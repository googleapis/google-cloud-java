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

package com.google.cloud.baremetalsolution.v2;

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
import com.google.cloud.baremetalsolution.v2.stub.BareMetalSolutionStub;
import com.google.cloud.baremetalsolution.v2.stub.BareMetalSolutionStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Performs management operations on Bare Metal Solution servers.
 *
 * <p>The `baremetalsolution.googleapis.com` service provides management capabilities for Bare Metal
 * Solution servers. To access the API methods, you must assign Bare Metal Solution IAM roles
 * containing the desired permissions to your staff in your Google Cloud project. You must also
 * enable the Bare Metal Solution API. Once enabled, the methods act upon specific servers in your
 * Bare Metal Solution environment.
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
 * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
 *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
 *   Instance response = bareMetalSolutionClient.getInstance(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the BareMetalSolutionClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> ListInstances</td>
 *      <td><p> List servers in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listInstances(ListInstancesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listInstances(LocationName parent)
 *           <li><p> listInstances(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listInstancesPagedCallable()
 *           <li><p> listInstancesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetInstance</td>
 *      <td><p> Get details about a single server.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getInstance(GetInstanceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getInstance(InstanceName name)
 *           <li><p> getInstance(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getInstanceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateInstance</td>
 *      <td><p> Update details of a single server.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateInstanceAsync(UpdateInstanceRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateInstanceAsync(Instance instance, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateInstanceOperationCallable()
 *           <li><p> updateInstanceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RenameInstance</td>
 *      <td><p> RenameInstance sets a new name for an instance. Use with caution, previous names become immediately invalidated.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> renameInstance(RenameInstanceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> renameInstance(InstanceName name, String newInstanceId)
 *           <li><p> renameInstance(String name, String newInstanceId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> renameInstanceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ResetInstance</td>
 *      <td><p> Perform an ungraceful, hard reset on a server. Equivalent to shutting the power off and then turning it back on.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> resetInstanceAsync(ResetInstanceRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> resetInstanceAsync(InstanceName name)
 *           <li><p> resetInstanceAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> resetInstanceOperationCallable()
 *           <li><p> resetInstanceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> StartInstance</td>
 *      <td><p> Starts a server that was shutdown.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> startInstanceAsync(StartInstanceRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> startInstanceAsync(InstanceName name)
 *           <li><p> startInstanceAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> startInstanceOperationCallable()
 *           <li><p> startInstanceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> StopInstance</td>
 *      <td><p> Stop a running server.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> stopInstanceAsync(StopInstanceRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> stopInstanceAsync(InstanceName name)
 *           <li><p> stopInstanceAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> stopInstanceOperationCallable()
 *           <li><p> stopInstanceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> EnableInteractiveSerialConsole</td>
 *      <td><p> Enable the interactive serial console feature on an instance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> enableInteractiveSerialConsoleAsync(EnableInteractiveSerialConsoleRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> enableInteractiveSerialConsoleAsync(InstanceName name)
 *           <li><p> enableInteractiveSerialConsoleAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> enableInteractiveSerialConsoleOperationCallable()
 *           <li><p> enableInteractiveSerialConsoleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DisableInteractiveSerialConsole</td>
 *      <td><p> Disable the interactive serial console feature on an instance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> disableInteractiveSerialConsoleAsync(DisableInteractiveSerialConsoleRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> disableInteractiveSerialConsoleAsync(InstanceName name)
 *           <li><p> disableInteractiveSerialConsoleAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> disableInteractiveSerialConsoleOperationCallable()
 *           <li><p> disableInteractiveSerialConsoleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DetachLun</td>
 *      <td><p> Detach LUN from Instance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> detachLunAsync(DetachLunRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> detachLunAsync(InstanceName instance, LunName lun)
 *           <li><p> detachLunAsync(InstanceName instance, String lun)
 *           <li><p> detachLunAsync(String instance, LunName lun)
 *           <li><p> detachLunAsync(String instance, String lun)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> detachLunOperationCallable()
 *           <li><p> detachLunCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListSSHKeys</td>
 *      <td><p> Lists the public SSH keys registered for the specified project. These SSH keys are used only for the interactive serial console feature.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listSSHKeys(ListSSHKeysRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listSSHKeys(LocationName parent)
 *           <li><p> listSSHKeys(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listSSHKeysPagedCallable()
 *           <li><p> listSSHKeysCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateSSHKey</td>
 *      <td><p> Register a public SSH key in the specified project for use with the interactive serial console feature.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createSSHKey(CreateSSHKeyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createSSHKey(LocationName parent, SSHKey sshKey, String sshKeyId)
 *           <li><p> createSSHKey(String parent, SSHKey sshKey, String sshKeyId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createSSHKeyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteSSHKey</td>
 *      <td><p> Deletes a public SSH key registered in the specified project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteSSHKey(DeleteSSHKeyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteSSHKey(SshKeyName name)
 *           <li><p> deleteSSHKey(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteSSHKeyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListVolumes</td>
 *      <td><p> List storage volumes in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listVolumes(ListVolumesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listVolumes(LocationName parent)
 *           <li><p> listVolumes(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listVolumesPagedCallable()
 *           <li><p> listVolumesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetVolume</td>
 *      <td><p> Get details of a single storage volume.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getVolume(GetVolumeRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getVolume(VolumeName name)
 *           <li><p> getVolume(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getVolumeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateVolume</td>
 *      <td><p> Update details of a single storage volume.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateVolumeAsync(UpdateVolumeRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateVolumeAsync(Volume volume, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateVolumeOperationCallable()
 *           <li><p> updateVolumeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RenameVolume</td>
 *      <td><p> RenameVolume sets a new name for a volume. Use with caution, previous names become immediately invalidated.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> renameVolume(RenameVolumeRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> renameVolume(VolumeName name, String newVolumeId)
 *           <li><p> renameVolume(String name, String newVolumeId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> renameVolumeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> EvictVolume</td>
 *      <td><p> Skips volume's cooloff and deletes it now. Volume must be in cooloff state.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> evictVolumeAsync(EvictVolumeRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> evictVolumeAsync(VolumeName name)
 *           <li><p> evictVolumeAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> evictVolumeOperationCallable()
 *           <li><p> evictVolumeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ResizeVolume</td>
 *      <td><p> Emergency Volume resize.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> resizeVolumeAsync(ResizeVolumeRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> resizeVolumeAsync(VolumeName volume, long sizeGib)
 *           <li><p> resizeVolumeAsync(String volume, long sizeGib)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> resizeVolumeOperationCallable()
 *           <li><p> resizeVolumeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListNetworks</td>
 *      <td><p> List network in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listNetworks(ListNetworksRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listNetworks(LocationName parent)
 *           <li><p> listNetworks(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listNetworksPagedCallable()
 *           <li><p> listNetworksCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListNetworkUsage</td>
 *      <td><p> List all Networks (and used IPs for each Network) in the vendor account associated with the specified project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listNetworkUsage(ListNetworkUsageRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listNetworkUsage(LocationName location)
 *           <li><p> listNetworkUsage(String location)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listNetworkUsageCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetNetwork</td>
 *      <td><p> Get details of a single network.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getNetwork(GetNetworkRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getNetwork(NetworkName name)
 *           <li><p> getNetwork(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getNetworkCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateNetwork</td>
 *      <td><p> Update details of a single network.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateNetworkAsync(UpdateNetworkRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateNetworkAsync(Network network, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateNetworkOperationCallable()
 *           <li><p> updateNetworkCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateVolumeSnapshot</td>
 *      <td><p> Takes a snapshot of a boot volume. Returns INVALID_ARGUMENT if called for a non-boot volume.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createVolumeSnapshot(CreateVolumeSnapshotRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createVolumeSnapshot(VolumeName parent, VolumeSnapshot volumeSnapshot)
 *           <li><p> createVolumeSnapshot(String parent, VolumeSnapshot volumeSnapshot)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createVolumeSnapshotCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RestoreVolumeSnapshot</td>
 *      <td><p> Uses the specified snapshot to restore its parent volume. Returns INVALID_ARGUMENT if called for a non-boot volume.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> restoreVolumeSnapshotAsync(RestoreVolumeSnapshotRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> restoreVolumeSnapshotAsync(VolumeSnapshotName volumeSnapshot)
 *           <li><p> restoreVolumeSnapshotAsync(String volumeSnapshot)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> restoreVolumeSnapshotOperationCallable()
 *           <li><p> restoreVolumeSnapshotCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteVolumeSnapshot</td>
 *      <td><p> Deletes a volume snapshot. Returns INVALID_ARGUMENT if called for a non-boot volume.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteVolumeSnapshot(DeleteVolumeSnapshotRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteVolumeSnapshot(VolumeSnapshotName name)
 *           <li><p> deleteVolumeSnapshot(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteVolumeSnapshotCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetVolumeSnapshot</td>
 *      <td><p> Returns the specified snapshot resource. Returns INVALID_ARGUMENT if called for a non-boot volume.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getVolumeSnapshot(GetVolumeSnapshotRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getVolumeSnapshot(VolumeSnapshotName name)
 *           <li><p> getVolumeSnapshot(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getVolumeSnapshotCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListVolumeSnapshots</td>
 *      <td><p> Retrieves the list of snapshots for the specified volume. Returns a response with an empty list of snapshots if called for a non-boot volume.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listVolumeSnapshots(ListVolumeSnapshotsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listVolumeSnapshots(VolumeName parent)
 *           <li><p> listVolumeSnapshots(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listVolumeSnapshotsPagedCallable()
 *           <li><p> listVolumeSnapshotsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetLun</td>
 *      <td><p> Get details of a single storage logical unit number(LUN).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getLun(GetLunRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getLun(LunName name)
 *           <li><p> getLun(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getLunCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLuns</td>
 *      <td><p> List storage volume luns for given storage volume.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listLuns(ListLunsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listLuns(VolumeName parent)
 *           <li><p> listLuns(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listLunsPagedCallable()
 *           <li><p> listLunsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> EvictLun</td>
 *      <td><p> Skips lun's cooloff and deletes it now. Lun must be in cooloff state.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> evictLunAsync(EvictLunRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> evictLunAsync(LunName name)
 *           <li><p> evictLunAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> evictLunOperationCallable()
 *           <li><p> evictLunCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetNfsShare</td>
 *      <td><p> Get details of a single NFS share.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getNfsShare(GetNfsShareRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getNfsShare(NFSShareName name)
 *           <li><p> getNfsShare(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getNfsShareCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListNfsShares</td>
 *      <td><p> List NFS shares.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listNfsShares(ListNfsSharesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listNfsShares(LocationName parent)
 *           <li><p> listNfsShares(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listNfsSharesPagedCallable()
 *           <li><p> listNfsSharesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateNfsShare</td>
 *      <td><p> Update details of a single NFS share.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateNfsShareAsync(UpdateNfsShareRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateNfsShareAsync(NfsShare nfsShare, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateNfsShareOperationCallable()
 *           <li><p> updateNfsShareCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateNfsShare</td>
 *      <td><p> Create an NFS share.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createNfsShareAsync(CreateNfsShareRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createNfsShareAsync(LocationName parent, NfsShare nfsShare)
 *           <li><p> createNfsShareAsync(String parent, NfsShare nfsShare)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createNfsShareOperationCallable()
 *           <li><p> createNfsShareCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RenameNfsShare</td>
 *      <td><p> RenameNfsShare sets a new name for an nfsshare. Use with caution, previous names become immediately invalidated.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> renameNfsShare(RenameNfsShareRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> renameNfsShare(NFSShareName name, String newNfsshareId)
 *           <li><p> renameNfsShare(String name, String newNfsshareId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> renameNfsShareCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteNfsShare</td>
 *      <td><p> Delete an NFS share. The underlying volume is automatically deleted.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteNfsShareAsync(DeleteNfsShareRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteNfsShareAsync(NFSShareName name)
 *           <li><p> deleteNfsShareAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteNfsShareOperationCallable()
 *           <li><p> deleteNfsShareCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListProvisioningQuotas</td>
 *      <td><p> List the budget details to provision resources on a given project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listProvisioningQuotas(ListProvisioningQuotasRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listProvisioningQuotas(LocationName parent)
 *           <li><p> listProvisioningQuotas(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listProvisioningQuotasPagedCallable()
 *           <li><p> listProvisioningQuotasCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SubmitProvisioningConfig</td>
 *      <td><p> Submit a provisiong configuration for a given project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> submitProvisioningConfig(SubmitProvisioningConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> submitProvisioningConfig(LocationName parent, ProvisioningConfig provisioningConfig)
 *           <li><p> submitProvisioningConfig(String parent, ProvisioningConfig provisioningConfig)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> submitProvisioningConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetProvisioningConfig</td>
 *      <td><p> Get ProvisioningConfig by name.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getProvisioningConfig(GetProvisioningConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getProvisioningConfig(ProvisioningConfigName name)
 *           <li><p> getProvisioningConfig(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getProvisioningConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateProvisioningConfig</td>
 *      <td><p> Create new ProvisioningConfig.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createProvisioningConfig(CreateProvisioningConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createProvisioningConfig(LocationName parent, ProvisioningConfig provisioningConfig)
 *           <li><p> createProvisioningConfig(String parent, ProvisioningConfig provisioningConfig)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createProvisioningConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateProvisioningConfig</td>
 *      <td><p> Update existing ProvisioningConfig.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateProvisioningConfig(UpdateProvisioningConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateProvisioningConfig(ProvisioningConfig provisioningConfig, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateProvisioningConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RenameNetwork</td>
 *      <td><p> RenameNetwork sets a new name for a network. Use with caution, previous names become immediately invalidated.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> renameNetwork(RenameNetworkRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> renameNetwork(NetworkName name, String newNetworkId)
 *           <li><p> renameNetwork(String name, String newNetworkId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> renameNetworkCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListOSImages</td>
 *      <td><p> Retrieves the list of OS images which are currently approved.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listOSImages(ListOSImagesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listOSImages(LocationName parent)
 *           <li><p> listOSImages(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listOSImagesPagedCallable()
 *           <li><p> listOSImagesCallable()
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
 *  </table>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of BareMetalSolutionSettings to
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
 * BareMetalSolutionSettings bareMetalSolutionSettings =
 *     BareMetalSolutionSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * BareMetalSolutionClient bareMetalSolutionClient =
 *     BareMetalSolutionClient.create(bareMetalSolutionSettings);
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
 * BareMetalSolutionSettings bareMetalSolutionSettings =
 *     BareMetalSolutionSettings.newBuilder().setEndpoint(myEndpoint).build();
 * BareMetalSolutionClient bareMetalSolutionClient =
 *     BareMetalSolutionClient.create(bareMetalSolutionSettings);
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
 * BareMetalSolutionSettings bareMetalSolutionSettings =
 *     BareMetalSolutionSettings.newHttpJsonBuilder().build();
 * BareMetalSolutionClient bareMetalSolutionClient =
 *     BareMetalSolutionClient.create(bareMetalSolutionSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class BareMetalSolutionClient implements BackgroundResource {
  private final BareMetalSolutionSettings settings;
  private final BareMetalSolutionStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of BareMetalSolutionClient with default settings. */
  public static final BareMetalSolutionClient create() throws IOException {
    return create(BareMetalSolutionSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of BareMetalSolutionClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final BareMetalSolutionClient create(BareMetalSolutionSettings settings)
      throws IOException {
    return new BareMetalSolutionClient(settings);
  }

  /**
   * Constructs an instance of BareMetalSolutionClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(BareMetalSolutionSettings).
   */
  public static final BareMetalSolutionClient create(BareMetalSolutionStub stub) {
    return new BareMetalSolutionClient(stub);
  }

  /**
   * Constructs an instance of BareMetalSolutionClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected BareMetalSolutionClient(BareMetalSolutionSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((BareMetalSolutionStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected BareMetalSolutionClient(BareMetalSolutionStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final BareMetalSolutionSettings getSettings() {
    return settings;
  }

  public BareMetalSolutionStub getStub() {
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
   * List servers in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Instance element : bareMetalSolutionClient.listInstances(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListInstancesRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInstancesPagedResponse listInstances(LocationName parent) {
    ListInstancesRequest request =
        ListInstancesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listInstances(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List servers in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Instance element : bareMetalSolutionClient.listInstances(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListInstancesRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInstancesPagedResponse listInstances(String parent) {
    ListInstancesRequest request = ListInstancesRequest.newBuilder().setParent(parent).build();
    return listInstances(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List servers in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListInstancesRequest request =
   *       ListInstancesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (Instance element : bareMetalSolutionClient.listInstances(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInstancesPagedResponse listInstances(ListInstancesRequest request) {
    return listInstancesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List servers in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListInstancesRequest request =
   *       ListInstancesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<Instance> future =
   *       bareMetalSolutionClient.listInstancesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Instance element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListInstancesRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable() {
    return stub.listInstancesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List servers in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListInstancesRequest request =
   *       ListInstancesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListInstancesResponse response =
   *         bareMetalSolutionClient.listInstancesCallable().call(request);
   *     for (Instance element : response.getInstancesList()) {
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
  public final UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable() {
    return stub.listInstancesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details about a single server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   Instance response = bareMetalSolutionClient.getInstance(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Instance getInstance(InstanceName name) {
    GetInstanceRequest request =
        GetInstanceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details about a single server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   Instance response = bareMetalSolutionClient.getInstance(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Instance getInstance(String name) {
    GetInstanceRequest request = GetInstanceRequest.newBuilder().setName(name).build();
    return getInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details about a single server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   GetInstanceRequest request =
   *       GetInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   Instance response = bareMetalSolutionClient.getInstance(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Instance getInstance(GetInstanceRequest request) {
    return getInstanceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details about a single server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   GetInstanceRequest request =
   *       GetInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   ApiFuture<Instance> future =
   *       bareMetalSolutionClient.getInstanceCallable().futureCall(request);
   *   // Do something.
   *   Instance response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable() {
    return stub.getInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update details of a single server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   Instance instance = Instance.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Instance response = bareMetalSolutionClient.updateInstanceAsync(instance, updateMask).get();
   * }
   * }</pre>
   *
   * @param instance Required. The server to update.
   *     <p>The `name` field is used to identify the instance to update. Format:
   *     projects/{project}/locations/{location}/instances/{instance}
   * @param updateMask The list of fields to update. The currently supported fields are: `labels`
   *     `hyperthreading_enabled` `os_image`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> updateInstanceAsync(
      Instance instance, FieldMask updateMask) {
    UpdateInstanceRequest request =
        UpdateInstanceRequest.newBuilder().setInstance(instance).setUpdateMask(updateMask).build();
    return updateInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update details of a single server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   UpdateInstanceRequest request =
   *       UpdateInstanceRequest.newBuilder()
   *           .setInstance(Instance.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Instance response = bareMetalSolutionClient.updateInstanceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> updateInstanceAsync(
      UpdateInstanceRequest request) {
    return updateInstanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update details of a single server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   UpdateInstanceRequest request =
   *       UpdateInstanceRequest.newBuilder()
   *           .setInstance(Instance.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<Instance, OperationMetadata> future =
   *       bareMetalSolutionClient.updateInstanceOperationCallable().futureCall(request);
   *   // Do something.
   *   Instance response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateInstanceRequest, Instance, OperationMetadata>
      updateInstanceOperationCallable() {
    return stub.updateInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update details of a single server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   UpdateInstanceRequest request =
   *       UpdateInstanceRequest.newBuilder()
   *           .setInstance(Instance.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       bareMetalSolutionClient.updateInstanceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateInstanceRequest, Operation> updateInstanceCallable() {
    return stub.updateInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * RenameInstance sets a new name for an instance. Use with caution, previous names become
   * immediately invalidated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   String newInstanceId = "newInstanceId1749535312";
   *   Instance response = bareMetalSolutionClient.renameInstance(name, newInstanceId);
   * }
   * }</pre>
   *
   * @param name Required. The `name` field is used to identify the instance. Format:
   *     projects/{project}/locations/{location}/instances/{instance}
   * @param newInstanceId Required. The new `id` of the instance.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Instance renameInstance(InstanceName name, String newInstanceId) {
    RenameInstanceRequest request =
        RenameInstanceRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setNewInstanceId(newInstanceId)
            .build();
    return renameInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * RenameInstance sets a new name for an instance. Use with caution, previous names become
   * immediately invalidated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   String newInstanceId = "newInstanceId1749535312";
   *   Instance response = bareMetalSolutionClient.renameInstance(name, newInstanceId);
   * }
   * }</pre>
   *
   * @param name Required. The `name` field is used to identify the instance. Format:
   *     projects/{project}/locations/{location}/instances/{instance}
   * @param newInstanceId Required. The new `id` of the instance.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Instance renameInstance(String name, String newInstanceId) {
    RenameInstanceRequest request =
        RenameInstanceRequest.newBuilder().setName(name).setNewInstanceId(newInstanceId).build();
    return renameInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * RenameInstance sets a new name for an instance. Use with caution, previous names become
   * immediately invalidated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   RenameInstanceRequest request =
   *       RenameInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setNewInstanceId("newInstanceId1749535312")
   *           .build();
   *   Instance response = bareMetalSolutionClient.renameInstance(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Instance renameInstance(RenameInstanceRequest request) {
    return renameInstanceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * RenameInstance sets a new name for an instance. Use with caution, previous names become
   * immediately invalidated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   RenameInstanceRequest request =
   *       RenameInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setNewInstanceId("newInstanceId1749535312")
   *           .build();
   *   ApiFuture<Instance> future =
   *       bareMetalSolutionClient.renameInstanceCallable().futureCall(request);
   *   // Do something.
   *   Instance response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RenameInstanceRequest, Instance> renameInstanceCallable() {
    return stub.renameInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Perform an ungraceful, hard reset on a server. Equivalent to shutting the power off and then
   * turning it back on.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   ResetInstanceResponse response = bareMetalSolutionClient.resetInstanceAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ResetInstanceResponse, OperationMetadata> resetInstanceAsync(
      InstanceName name) {
    ResetInstanceRequest request =
        ResetInstanceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return resetInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Perform an ungraceful, hard reset on a server. Equivalent to shutting the power off and then
   * turning it back on.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   ResetInstanceResponse response = bareMetalSolutionClient.resetInstanceAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ResetInstanceResponse, OperationMetadata> resetInstanceAsync(
      String name) {
    ResetInstanceRequest request = ResetInstanceRequest.newBuilder().setName(name).build();
    return resetInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Perform an ungraceful, hard reset on a server. Equivalent to shutting the power off and then
   * turning it back on.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ResetInstanceRequest request =
   *       ResetInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   ResetInstanceResponse response = bareMetalSolutionClient.resetInstanceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ResetInstanceResponse, OperationMetadata> resetInstanceAsync(
      ResetInstanceRequest request) {
    return resetInstanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Perform an ungraceful, hard reset on a server. Equivalent to shutting the power off and then
   * turning it back on.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ResetInstanceRequest request =
   *       ResetInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   OperationFuture<ResetInstanceResponse, OperationMetadata> future =
   *       bareMetalSolutionClient.resetInstanceOperationCallable().futureCall(request);
   *   // Do something.
   *   ResetInstanceResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ResetInstanceRequest, ResetInstanceResponse, OperationMetadata>
      resetInstanceOperationCallable() {
    return stub.resetInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Perform an ungraceful, hard reset on a server. Equivalent to shutting the power off and then
   * turning it back on.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ResetInstanceRequest request =
   *       ResetInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       bareMetalSolutionClient.resetInstanceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ResetInstanceRequest, Operation> resetInstanceCallable() {
    return stub.resetInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts a server that was shutdown.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   StartInstanceResponse response = bareMetalSolutionClient.startInstanceAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<StartInstanceResponse, OperationMetadata> startInstanceAsync(
      InstanceName name) {
    StartInstanceRequest request =
        StartInstanceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return startInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts a server that was shutdown.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   StartInstanceResponse response = bareMetalSolutionClient.startInstanceAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<StartInstanceResponse, OperationMetadata> startInstanceAsync(
      String name) {
    StartInstanceRequest request = StartInstanceRequest.newBuilder().setName(name).build();
    return startInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts a server that was shutdown.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   StartInstanceRequest request =
   *       StartInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   StartInstanceResponse response = bareMetalSolutionClient.startInstanceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<StartInstanceResponse, OperationMetadata> startInstanceAsync(
      StartInstanceRequest request) {
    return startInstanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts a server that was shutdown.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   StartInstanceRequest request =
   *       StartInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   OperationFuture<StartInstanceResponse, OperationMetadata> future =
   *       bareMetalSolutionClient.startInstanceOperationCallable().futureCall(request);
   *   // Do something.
   *   StartInstanceResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<StartInstanceRequest, StartInstanceResponse, OperationMetadata>
      startInstanceOperationCallable() {
    return stub.startInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts a server that was shutdown.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   StartInstanceRequest request =
   *       StartInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       bareMetalSolutionClient.startInstanceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<StartInstanceRequest, Operation> startInstanceCallable() {
    return stub.startInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stop a running server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   StopInstanceResponse response = bareMetalSolutionClient.stopInstanceAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<StopInstanceResponse, OperationMetadata> stopInstanceAsync(
      InstanceName name) {
    StopInstanceRequest request =
        StopInstanceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return stopInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stop a running server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   StopInstanceResponse response = bareMetalSolutionClient.stopInstanceAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<StopInstanceResponse, OperationMetadata> stopInstanceAsync(
      String name) {
    StopInstanceRequest request = StopInstanceRequest.newBuilder().setName(name).build();
    return stopInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stop a running server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   StopInstanceRequest request =
   *       StopInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   StopInstanceResponse response = bareMetalSolutionClient.stopInstanceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<StopInstanceResponse, OperationMetadata> stopInstanceAsync(
      StopInstanceRequest request) {
    return stopInstanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stop a running server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   StopInstanceRequest request =
   *       StopInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   OperationFuture<StopInstanceResponse, OperationMetadata> future =
   *       bareMetalSolutionClient.stopInstanceOperationCallable().futureCall(request);
   *   // Do something.
   *   StopInstanceResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<StopInstanceRequest, StopInstanceResponse, OperationMetadata>
      stopInstanceOperationCallable() {
    return stub.stopInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stop a running server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   StopInstanceRequest request =
   *       StopInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       bareMetalSolutionClient.stopInstanceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<StopInstanceRequest, Operation> stopInstanceCallable() {
    return stub.stopInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enable the interactive serial console feature on an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   EnableInteractiveSerialConsoleResponse response =
   *       bareMetalSolutionClient.enableInteractiveSerialConsoleAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<EnableInteractiveSerialConsoleResponse, OperationMetadata>
      enableInteractiveSerialConsoleAsync(InstanceName name) {
    EnableInteractiveSerialConsoleRequest request =
        EnableInteractiveSerialConsoleRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return enableInteractiveSerialConsoleAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enable the interactive serial console feature on an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   EnableInteractiveSerialConsoleResponse response =
   *       bareMetalSolutionClient.enableInteractiveSerialConsoleAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<EnableInteractiveSerialConsoleResponse, OperationMetadata>
      enableInteractiveSerialConsoleAsync(String name) {
    EnableInteractiveSerialConsoleRequest request =
        EnableInteractiveSerialConsoleRequest.newBuilder().setName(name).build();
    return enableInteractiveSerialConsoleAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enable the interactive serial console feature on an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   EnableInteractiveSerialConsoleRequest request =
   *       EnableInteractiveSerialConsoleRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   EnableInteractiveSerialConsoleResponse response =
   *       bareMetalSolutionClient.enableInteractiveSerialConsoleAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<EnableInteractiveSerialConsoleResponse, OperationMetadata>
      enableInteractiveSerialConsoleAsync(EnableInteractiveSerialConsoleRequest request) {
    return enableInteractiveSerialConsoleOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enable the interactive serial console feature on an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   EnableInteractiveSerialConsoleRequest request =
   *       EnableInteractiveSerialConsoleRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   OperationFuture<EnableInteractiveSerialConsoleResponse, OperationMetadata> future =
   *       bareMetalSolutionClient
   *           .enableInteractiveSerialConsoleOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   EnableInteractiveSerialConsoleResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          EnableInteractiveSerialConsoleRequest,
          EnableInteractiveSerialConsoleResponse,
          OperationMetadata>
      enableInteractiveSerialConsoleOperationCallable() {
    return stub.enableInteractiveSerialConsoleOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enable the interactive serial console feature on an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   EnableInteractiveSerialConsoleRequest request =
   *       EnableInteractiveSerialConsoleRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       bareMetalSolutionClient.enableInteractiveSerialConsoleCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<EnableInteractiveSerialConsoleRequest, Operation>
      enableInteractiveSerialConsoleCallable() {
    return stub.enableInteractiveSerialConsoleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disable the interactive serial console feature on an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   DisableInteractiveSerialConsoleResponse response =
   *       bareMetalSolutionClient.disableInteractiveSerialConsoleAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DisableInteractiveSerialConsoleResponse, OperationMetadata>
      disableInteractiveSerialConsoleAsync(InstanceName name) {
    DisableInteractiveSerialConsoleRequest request =
        DisableInteractiveSerialConsoleRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return disableInteractiveSerialConsoleAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disable the interactive serial console feature on an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   DisableInteractiveSerialConsoleResponse response =
   *       bareMetalSolutionClient.disableInteractiveSerialConsoleAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DisableInteractiveSerialConsoleResponse, OperationMetadata>
      disableInteractiveSerialConsoleAsync(String name) {
    DisableInteractiveSerialConsoleRequest request =
        DisableInteractiveSerialConsoleRequest.newBuilder().setName(name).build();
    return disableInteractiveSerialConsoleAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disable the interactive serial console feature on an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   DisableInteractiveSerialConsoleRequest request =
   *       DisableInteractiveSerialConsoleRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   DisableInteractiveSerialConsoleResponse response =
   *       bareMetalSolutionClient.disableInteractiveSerialConsoleAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DisableInteractiveSerialConsoleResponse, OperationMetadata>
      disableInteractiveSerialConsoleAsync(DisableInteractiveSerialConsoleRequest request) {
    return disableInteractiveSerialConsoleOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disable the interactive serial console feature on an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   DisableInteractiveSerialConsoleRequest request =
   *       DisableInteractiveSerialConsoleRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   OperationFuture<DisableInteractiveSerialConsoleResponse, OperationMetadata> future =
   *       bareMetalSolutionClient
   *           .disableInteractiveSerialConsoleOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   DisableInteractiveSerialConsoleResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          DisableInteractiveSerialConsoleRequest,
          DisableInteractiveSerialConsoleResponse,
          OperationMetadata>
      disableInteractiveSerialConsoleOperationCallable() {
    return stub.disableInteractiveSerialConsoleOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disable the interactive serial console feature on an instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   DisableInteractiveSerialConsoleRequest request =
   *       DisableInteractiveSerialConsoleRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       bareMetalSolutionClient.disableInteractiveSerialConsoleCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DisableInteractiveSerialConsoleRequest, Operation>
      disableInteractiveSerialConsoleCallable() {
    return stub.disableInteractiveSerialConsoleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Detach LUN from Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   InstanceName instance = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   LunName lun = LunName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[LUN]");
   *   Instance response = bareMetalSolutionClient.detachLunAsync(instance, lun).get();
   * }
   * }</pre>
   *
   * @param instance Required. Name of the instance.
   * @param lun Required. Name of the Lun to detach.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> detachLunAsync(
      InstanceName instance, LunName lun) {
    DetachLunRequest request =
        DetachLunRequest.newBuilder()
            .setInstance(instance == null ? null : instance.toString())
            .setLun(lun == null ? null : lun.toString())
            .build();
    return detachLunAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Detach LUN from Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   InstanceName instance = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   String lun = LunName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[LUN]").toString();
   *   Instance response = bareMetalSolutionClient.detachLunAsync(instance, lun).get();
   * }
   * }</pre>
   *
   * @param instance Required. Name of the instance.
   * @param lun Required. Name of the Lun to detach.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> detachLunAsync(
      InstanceName instance, String lun) {
    DetachLunRequest request =
        DetachLunRequest.newBuilder()
            .setInstance(instance == null ? null : instance.toString())
            .setLun(lun)
            .build();
    return detachLunAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Detach LUN from Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String instance = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   LunName lun = LunName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[LUN]");
   *   Instance response = bareMetalSolutionClient.detachLunAsync(instance, lun).get();
   * }
   * }</pre>
   *
   * @param instance Required. Name of the instance.
   * @param lun Required. Name of the Lun to detach.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> detachLunAsync(
      String instance, LunName lun) {
    DetachLunRequest request =
        DetachLunRequest.newBuilder()
            .setInstance(instance)
            .setLun(lun == null ? null : lun.toString())
            .build();
    return detachLunAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Detach LUN from Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String instance = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   String lun = LunName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[LUN]").toString();
   *   Instance response = bareMetalSolutionClient.detachLunAsync(instance, lun).get();
   * }
   * }</pre>
   *
   * @param instance Required. Name of the instance.
   * @param lun Required. Name of the Lun to detach.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> detachLunAsync(
      String instance, String lun) {
    DetachLunRequest request =
        DetachLunRequest.newBuilder().setInstance(instance).setLun(lun).build();
    return detachLunAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Detach LUN from Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   DetachLunRequest request =
   *       DetachLunRequest.newBuilder()
   *           .setInstance(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setLun(LunName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[LUN]").toString())
   *           .setSkipReboot(true)
   *           .build();
   *   Instance response = bareMetalSolutionClient.detachLunAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> detachLunAsync(
      DetachLunRequest request) {
    return detachLunOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Detach LUN from Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   DetachLunRequest request =
   *       DetachLunRequest.newBuilder()
   *           .setInstance(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setLun(LunName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[LUN]").toString())
   *           .setSkipReboot(true)
   *           .build();
   *   OperationFuture<Instance, OperationMetadata> future =
   *       bareMetalSolutionClient.detachLunOperationCallable().futureCall(request);
   *   // Do something.
   *   Instance response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DetachLunRequest, Instance, OperationMetadata>
      detachLunOperationCallable() {
    return stub.detachLunOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Detach LUN from Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   DetachLunRequest request =
   *       DetachLunRequest.newBuilder()
   *           .setInstance(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setLun(LunName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[LUN]").toString())
   *           .setSkipReboot(true)
   *           .build();
   *   ApiFuture<Operation> future = bareMetalSolutionClient.detachLunCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DetachLunRequest, Operation> detachLunCallable() {
    return stub.detachLunCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the public SSH keys registered for the specified project. These SSH keys are used only
   * for the interactive serial console feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (SSHKey element : bareMetalSolutionClient.listSSHKeys(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent containing the SSH keys. Currently, the only valid value for
   *     the location is "global".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSSHKeysPagedResponse listSSHKeys(LocationName parent) {
    ListSSHKeysRequest request =
        ListSSHKeysRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listSSHKeys(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the public SSH keys registered for the specified project. These SSH keys are used only
   * for the interactive serial console feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (SSHKey element : bareMetalSolutionClient.listSSHKeys(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent containing the SSH keys. Currently, the only valid value for
   *     the location is "global".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSSHKeysPagedResponse listSSHKeys(String parent) {
    ListSSHKeysRequest request = ListSSHKeysRequest.newBuilder().setParent(parent).build();
    return listSSHKeys(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the public SSH keys registered for the specified project. These SSH keys are used only
   * for the interactive serial console feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListSSHKeysRequest request =
   *       ListSSHKeysRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (SSHKey element : bareMetalSolutionClient.listSSHKeys(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSSHKeysPagedResponse listSSHKeys(ListSSHKeysRequest request) {
    return listSSHKeysPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the public SSH keys registered for the specified project. These SSH keys are used only
   * for the interactive serial console feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListSSHKeysRequest request =
   *       ListSSHKeysRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<SSHKey> future =
   *       bareMetalSolutionClient.listSSHKeysPagedCallable().futureCall(request);
   *   // Do something.
   *   for (SSHKey element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSSHKeysRequest, ListSSHKeysPagedResponse>
      listSSHKeysPagedCallable() {
    return stub.listSSHKeysPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the public SSH keys registered for the specified project. These SSH keys are used only
   * for the interactive serial console feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListSSHKeysRequest request =
   *       ListSSHKeysRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListSSHKeysResponse response = bareMetalSolutionClient.listSSHKeysCallable().call(request);
   *     for (SSHKey element : response.getSshKeysList()) {
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
  public final UnaryCallable<ListSSHKeysRequest, ListSSHKeysResponse> listSSHKeysCallable() {
    return stub.listSSHKeysCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Register a public SSH key in the specified project for use with the interactive serial console
   * feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   SSHKey sshKey = SSHKey.newBuilder().build();
   *   String sshKeyId = "sshKeyId593257138";
   *   SSHKey response = bareMetalSolutionClient.createSSHKey(parent, sshKey, sshKeyId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent containing the SSH keys.
   * @param sshKey Required. The SSH key to register.
   * @param sshKeyId Required. The ID to use for the key, which will become the final component of
   *     the key's resource name.
   *     <p>This value must match the regex: [a-zA-Z0-9{@literal @}.\\-_]{1,64}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SSHKey createSSHKey(LocationName parent, SSHKey sshKey, String sshKeyId) {
    CreateSSHKeyRequest request =
        CreateSSHKeyRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSshKey(sshKey)
            .setSshKeyId(sshKeyId)
            .build();
    return createSSHKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Register a public SSH key in the specified project for use with the interactive serial console
   * feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   SSHKey sshKey = SSHKey.newBuilder().build();
   *   String sshKeyId = "sshKeyId593257138";
   *   SSHKey response = bareMetalSolutionClient.createSSHKey(parent, sshKey, sshKeyId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent containing the SSH keys.
   * @param sshKey Required. The SSH key to register.
   * @param sshKeyId Required. The ID to use for the key, which will become the final component of
   *     the key's resource name.
   *     <p>This value must match the regex: [a-zA-Z0-9{@literal @}.\\-_]{1,64}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SSHKey createSSHKey(String parent, SSHKey sshKey, String sshKeyId) {
    CreateSSHKeyRequest request =
        CreateSSHKeyRequest.newBuilder()
            .setParent(parent)
            .setSshKey(sshKey)
            .setSshKeyId(sshKeyId)
            .build();
    return createSSHKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Register a public SSH key in the specified project for use with the interactive serial console
   * feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   CreateSSHKeyRequest request =
   *       CreateSSHKeyRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSshKey(SSHKey.newBuilder().build())
   *           .setSshKeyId("sshKeyId593257138")
   *           .build();
   *   SSHKey response = bareMetalSolutionClient.createSSHKey(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SSHKey createSSHKey(CreateSSHKeyRequest request) {
    return createSSHKeyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Register a public SSH key in the specified project for use with the interactive serial console
   * feature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   CreateSSHKeyRequest request =
   *       CreateSSHKeyRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSshKey(SSHKey.newBuilder().build())
   *           .setSshKeyId("sshKeyId593257138")
   *           .build();
   *   ApiFuture<SSHKey> future = bareMetalSolutionClient.createSSHKeyCallable().futureCall(request);
   *   // Do something.
   *   SSHKey response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateSSHKeyRequest, SSHKey> createSSHKeyCallable() {
    return stub.createSSHKeyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a public SSH key registered in the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   SshKeyName name = SshKeyName.of("[PROJECT]", "[LOCATION]", "[SSH_KEY]");
   *   bareMetalSolutionClient.deleteSSHKey(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the SSH key to delete. Currently, the only valid value for
   *     the location is "global".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSSHKey(SshKeyName name) {
    DeleteSSHKeyRequest request =
        DeleteSSHKeyRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteSSHKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a public SSH key registered in the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String name = SshKeyName.of("[PROJECT]", "[LOCATION]", "[SSH_KEY]").toString();
   *   bareMetalSolutionClient.deleteSSHKey(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the SSH key to delete. Currently, the only valid value for
   *     the location is "global".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSSHKey(String name) {
    DeleteSSHKeyRequest request = DeleteSSHKeyRequest.newBuilder().setName(name).build();
    deleteSSHKey(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a public SSH key registered in the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   DeleteSSHKeyRequest request =
   *       DeleteSSHKeyRequest.newBuilder()
   *           .setName(SshKeyName.of("[PROJECT]", "[LOCATION]", "[SSH_KEY]").toString())
   *           .build();
   *   bareMetalSolutionClient.deleteSSHKey(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteSSHKey(DeleteSSHKeyRequest request) {
    deleteSSHKeyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a public SSH key registered in the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   DeleteSSHKeyRequest request =
   *       DeleteSSHKeyRequest.newBuilder()
   *           .setName(SshKeyName.of("[PROJECT]", "[LOCATION]", "[SSH_KEY]").toString())
   *           .build();
   *   ApiFuture<Empty> future = bareMetalSolutionClient.deleteSSHKeyCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteSSHKeyRequest, Empty> deleteSSHKeyCallable() {
    return stub.deleteSSHKeyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List storage volumes in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Volume element : bareMetalSolutionClient.listVolumes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListVolumesRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVolumesPagedResponse listVolumes(LocationName parent) {
    ListVolumesRequest request =
        ListVolumesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listVolumes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List storage volumes in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Volume element : bareMetalSolutionClient.listVolumes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListVolumesRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVolumesPagedResponse listVolumes(String parent) {
    ListVolumesRequest request = ListVolumesRequest.newBuilder().setParent(parent).build();
    return listVolumes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List storage volumes in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListVolumesRequest request =
   *       ListVolumesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (Volume element : bareMetalSolutionClient.listVolumes(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVolumesPagedResponse listVolumes(ListVolumesRequest request) {
    return listVolumesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List storage volumes in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListVolumesRequest request =
   *       ListVolumesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<Volume> future =
   *       bareMetalSolutionClient.listVolumesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Volume element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListVolumesRequest, ListVolumesPagedResponse>
      listVolumesPagedCallable() {
    return stub.listVolumesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List storage volumes in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListVolumesRequest request =
   *       ListVolumesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListVolumesResponse response = bareMetalSolutionClient.listVolumesCallable().call(request);
   *     for (Volume element : response.getVolumesList()) {
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
  public final UnaryCallable<ListVolumesRequest, ListVolumesResponse> listVolumesCallable() {
    return stub.listVolumesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details of a single storage volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   VolumeName name = VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]");
   *   Volume response = bareMetalSolutionClient.getVolume(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Volume getVolume(VolumeName name) {
    GetVolumeRequest request =
        GetVolumeRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getVolume(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details of a single storage volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String name = VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString();
   *   Volume response = bareMetalSolutionClient.getVolume(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Volume getVolume(String name) {
    GetVolumeRequest request = GetVolumeRequest.newBuilder().setName(name).build();
    return getVolume(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details of a single storage volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   GetVolumeRequest request =
   *       GetVolumeRequest.newBuilder()
   *           .setName(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
   *           .build();
   *   Volume response = bareMetalSolutionClient.getVolume(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Volume getVolume(GetVolumeRequest request) {
    return getVolumeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details of a single storage volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   GetVolumeRequest request =
   *       GetVolumeRequest.newBuilder()
   *           .setName(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
   *           .build();
   *   ApiFuture<Volume> future = bareMetalSolutionClient.getVolumeCallable().futureCall(request);
   *   // Do something.
   *   Volume response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetVolumeRequest, Volume> getVolumeCallable() {
    return stub.getVolumeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update details of a single storage volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   Volume volume = Volume.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Volume response = bareMetalSolutionClient.updateVolumeAsync(volume, updateMask).get();
   * }
   * }</pre>
   *
   * @param volume Required. The volume to update.
   *     <p>The `name` field is used to identify the volume to update. Format:
   *     projects/{project}/locations/{location}/volumes/{volume}
   * @param updateMask The list of fields to update. The only currently supported fields are:
   *     'labels'
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Volume, OperationMetadata> updateVolumeAsync(
      Volume volume, FieldMask updateMask) {
    UpdateVolumeRequest request =
        UpdateVolumeRequest.newBuilder().setVolume(volume).setUpdateMask(updateMask).build();
    return updateVolumeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update details of a single storage volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   UpdateVolumeRequest request =
   *       UpdateVolumeRequest.newBuilder()
   *           .setVolume(Volume.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Volume response = bareMetalSolutionClient.updateVolumeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Volume, OperationMetadata> updateVolumeAsync(
      UpdateVolumeRequest request) {
    return updateVolumeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update details of a single storage volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   UpdateVolumeRequest request =
   *       UpdateVolumeRequest.newBuilder()
   *           .setVolume(Volume.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<Volume, OperationMetadata> future =
   *       bareMetalSolutionClient.updateVolumeOperationCallable().futureCall(request);
   *   // Do something.
   *   Volume response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateVolumeRequest, Volume, OperationMetadata>
      updateVolumeOperationCallable() {
    return stub.updateVolumeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update details of a single storage volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   UpdateVolumeRequest request =
   *       UpdateVolumeRequest.newBuilder()
   *           .setVolume(Volume.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       bareMetalSolutionClient.updateVolumeCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateVolumeRequest, Operation> updateVolumeCallable() {
    return stub.updateVolumeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * RenameVolume sets a new name for a volume. Use with caution, previous names become immediately
   * invalidated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   VolumeName name = VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]");
   *   String newVolumeId = "newVolumeId-613023851";
   *   Volume response = bareMetalSolutionClient.renameVolume(name, newVolumeId);
   * }
   * }</pre>
   *
   * @param name Required. The `name` field is used to identify the volume. Format:
   *     projects/{project}/locations/{location}/volumes/{volume}
   * @param newVolumeId Required. The new `id` of the volume.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Volume renameVolume(VolumeName name, String newVolumeId) {
    RenameVolumeRequest request =
        RenameVolumeRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setNewVolumeId(newVolumeId)
            .build();
    return renameVolume(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * RenameVolume sets a new name for a volume. Use with caution, previous names become immediately
   * invalidated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String name = VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString();
   *   String newVolumeId = "newVolumeId-613023851";
   *   Volume response = bareMetalSolutionClient.renameVolume(name, newVolumeId);
   * }
   * }</pre>
   *
   * @param name Required. The `name` field is used to identify the volume. Format:
   *     projects/{project}/locations/{location}/volumes/{volume}
   * @param newVolumeId Required. The new `id` of the volume.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Volume renameVolume(String name, String newVolumeId) {
    RenameVolumeRequest request =
        RenameVolumeRequest.newBuilder().setName(name).setNewVolumeId(newVolumeId).build();
    return renameVolume(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * RenameVolume sets a new name for a volume. Use with caution, previous names become immediately
   * invalidated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   RenameVolumeRequest request =
   *       RenameVolumeRequest.newBuilder()
   *           .setName(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
   *           .setNewVolumeId("newVolumeId-613023851")
   *           .build();
   *   Volume response = bareMetalSolutionClient.renameVolume(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Volume renameVolume(RenameVolumeRequest request) {
    return renameVolumeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * RenameVolume sets a new name for a volume. Use with caution, previous names become immediately
   * invalidated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   RenameVolumeRequest request =
   *       RenameVolumeRequest.newBuilder()
   *           .setName(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
   *           .setNewVolumeId("newVolumeId-613023851")
   *           .build();
   *   ApiFuture<Volume> future = bareMetalSolutionClient.renameVolumeCallable().futureCall(request);
   *   // Do something.
   *   Volume response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RenameVolumeRequest, Volume> renameVolumeCallable() {
    return stub.renameVolumeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Skips volume's cooloff and deletes it now. Volume must be in cooloff state.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   VolumeName name = VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]");
   *   bareMetalSolutionClient.evictVolumeAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Volume.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> evictVolumeAsync(VolumeName name) {
    EvictVolumeRequest request =
        EvictVolumeRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return evictVolumeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Skips volume's cooloff and deletes it now. Volume must be in cooloff state.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String name = VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString();
   *   bareMetalSolutionClient.evictVolumeAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Volume.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> evictVolumeAsync(String name) {
    EvictVolumeRequest request = EvictVolumeRequest.newBuilder().setName(name).build();
    return evictVolumeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Skips volume's cooloff and deletes it now. Volume must be in cooloff state.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   EvictVolumeRequest request =
   *       EvictVolumeRequest.newBuilder()
   *           .setName(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
   *           .build();
   *   bareMetalSolutionClient.evictVolumeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> evictVolumeAsync(
      EvictVolumeRequest request) {
    return evictVolumeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Skips volume's cooloff and deletes it now. Volume must be in cooloff state.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   EvictVolumeRequest request =
   *       EvictVolumeRequest.newBuilder()
   *           .setName(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       bareMetalSolutionClient.evictVolumeOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<EvictVolumeRequest, Empty, OperationMetadata>
      evictVolumeOperationCallable() {
    return stub.evictVolumeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Skips volume's cooloff and deletes it now. Volume must be in cooloff state.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   EvictVolumeRequest request =
   *       EvictVolumeRequest.newBuilder()
   *           .setName(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       bareMetalSolutionClient.evictVolumeCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<EvictVolumeRequest, Operation> evictVolumeCallable() {
    return stub.evictVolumeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Emergency Volume resize.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   VolumeName volume = VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]");
   *   long sizeGib = 847296130;
   *   Volume response = bareMetalSolutionClient.resizeVolumeAsync(volume, sizeGib).get();
   * }
   * }</pre>
   *
   * @param volume Required. Volume to resize.
   * @param sizeGib New Volume size, in GiB.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Volume, OperationMetadata> resizeVolumeAsync(
      VolumeName volume, long sizeGib) {
    ResizeVolumeRequest request =
        ResizeVolumeRequest.newBuilder()
            .setVolume(volume == null ? null : volume.toString())
            .setSizeGib(sizeGib)
            .build();
    return resizeVolumeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Emergency Volume resize.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String volume = VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString();
   *   long sizeGib = 847296130;
   *   Volume response = bareMetalSolutionClient.resizeVolumeAsync(volume, sizeGib).get();
   * }
   * }</pre>
   *
   * @param volume Required. Volume to resize.
   * @param sizeGib New Volume size, in GiB.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Volume, OperationMetadata> resizeVolumeAsync(
      String volume, long sizeGib) {
    ResizeVolumeRequest request =
        ResizeVolumeRequest.newBuilder().setVolume(volume).setSizeGib(sizeGib).build();
    return resizeVolumeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Emergency Volume resize.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ResizeVolumeRequest request =
   *       ResizeVolumeRequest.newBuilder()
   *           .setVolume(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
   *           .setSizeGib(847296130)
   *           .build();
   *   Volume response = bareMetalSolutionClient.resizeVolumeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Volume, OperationMetadata> resizeVolumeAsync(
      ResizeVolumeRequest request) {
    return resizeVolumeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Emergency Volume resize.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ResizeVolumeRequest request =
   *       ResizeVolumeRequest.newBuilder()
   *           .setVolume(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
   *           .setSizeGib(847296130)
   *           .build();
   *   OperationFuture<Volume, OperationMetadata> future =
   *       bareMetalSolutionClient.resizeVolumeOperationCallable().futureCall(request);
   *   // Do something.
   *   Volume response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ResizeVolumeRequest, Volume, OperationMetadata>
      resizeVolumeOperationCallable() {
    return stub.resizeVolumeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Emergency Volume resize.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ResizeVolumeRequest request =
   *       ResizeVolumeRequest.newBuilder()
   *           .setVolume(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
   *           .setSizeGib(847296130)
   *           .build();
   *   ApiFuture<Operation> future =
   *       bareMetalSolutionClient.resizeVolumeCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ResizeVolumeRequest, Operation> resizeVolumeCallable() {
    return stub.resizeVolumeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List network in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Network element : bareMetalSolutionClient.listNetworks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListNetworksRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNetworksPagedResponse listNetworks(LocationName parent) {
    ListNetworksRequest request =
        ListNetworksRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listNetworks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List network in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Network element : bareMetalSolutionClient.listNetworks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListNetworksRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNetworksPagedResponse listNetworks(String parent) {
    ListNetworksRequest request = ListNetworksRequest.newBuilder().setParent(parent).build();
    return listNetworks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List network in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListNetworksRequest request =
   *       ListNetworksRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (Network element : bareMetalSolutionClient.listNetworks(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNetworksPagedResponse listNetworks(ListNetworksRequest request) {
    return listNetworksPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List network in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListNetworksRequest request =
   *       ListNetworksRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<Network> future =
   *       bareMetalSolutionClient.listNetworksPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Network element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListNetworksRequest, ListNetworksPagedResponse>
      listNetworksPagedCallable() {
    return stub.listNetworksPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List network in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListNetworksRequest request =
   *       ListNetworksRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListNetworksResponse response =
   *         bareMetalSolutionClient.listNetworksCallable().call(request);
   *     for (Network element : response.getNetworksList()) {
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
  public final UnaryCallable<ListNetworksRequest, ListNetworksResponse> listNetworksCallable() {
    return stub.listNetworksCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all Networks (and used IPs for each Network) in the vendor account associated with the
   * specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   LocationName location = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ListNetworkUsageResponse response = bareMetalSolutionClient.listNetworkUsage(location);
   * }
   * }</pre>
   *
   * @param location Required. Parent value (project and location).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNetworkUsageResponse listNetworkUsage(LocationName location) {
    ListNetworkUsageRequest request =
        ListNetworkUsageRequest.newBuilder()
            .setLocation(location == null ? null : location.toString())
            .build();
    return listNetworkUsage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all Networks (and used IPs for each Network) in the vendor account associated with the
   * specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String location = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   ListNetworkUsageResponse response = bareMetalSolutionClient.listNetworkUsage(location);
   * }
   * }</pre>
   *
   * @param location Required. Parent value (project and location).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNetworkUsageResponse listNetworkUsage(String location) {
    ListNetworkUsageRequest request =
        ListNetworkUsageRequest.newBuilder().setLocation(location).build();
    return listNetworkUsage(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all Networks (and used IPs for each Network) in the vendor account associated with the
   * specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListNetworkUsageRequest request =
   *       ListNetworkUsageRequest.newBuilder()
   *           .setLocation(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   ListNetworkUsageResponse response = bareMetalSolutionClient.listNetworkUsage(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNetworkUsageResponse listNetworkUsage(ListNetworkUsageRequest request) {
    return listNetworkUsageCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all Networks (and used IPs for each Network) in the vendor account associated with the
   * specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListNetworkUsageRequest request =
   *       ListNetworkUsageRequest.newBuilder()
   *           .setLocation(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   ApiFuture<ListNetworkUsageResponse> future =
   *       bareMetalSolutionClient.listNetworkUsageCallable().futureCall(request);
   *   // Do something.
   *   ListNetworkUsageResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ListNetworkUsageRequest, ListNetworkUsageResponse>
      listNetworkUsageCallable() {
    return stub.listNetworkUsageCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details of a single network.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   NetworkName name = NetworkName.of("[PROJECT]", "[LOCATION]", "[NETWORK]");
   *   Network response = bareMetalSolutionClient.getNetwork(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Network getNetwork(NetworkName name) {
    GetNetworkRequest request =
        GetNetworkRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getNetwork(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details of a single network.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String name = NetworkName.of("[PROJECT]", "[LOCATION]", "[NETWORK]").toString();
   *   Network response = bareMetalSolutionClient.getNetwork(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Network getNetwork(String name) {
    GetNetworkRequest request = GetNetworkRequest.newBuilder().setName(name).build();
    return getNetwork(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details of a single network.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   GetNetworkRequest request =
   *       GetNetworkRequest.newBuilder()
   *           .setName(NetworkName.of("[PROJECT]", "[LOCATION]", "[NETWORK]").toString())
   *           .build();
   *   Network response = bareMetalSolutionClient.getNetwork(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Network getNetwork(GetNetworkRequest request) {
    return getNetworkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details of a single network.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   GetNetworkRequest request =
   *       GetNetworkRequest.newBuilder()
   *           .setName(NetworkName.of("[PROJECT]", "[LOCATION]", "[NETWORK]").toString())
   *           .build();
   *   ApiFuture<Network> future = bareMetalSolutionClient.getNetworkCallable().futureCall(request);
   *   // Do something.
   *   Network response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetNetworkRequest, Network> getNetworkCallable() {
    return stub.getNetworkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update details of a single network.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   Network network = Network.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Network response = bareMetalSolutionClient.updateNetworkAsync(network, updateMask).get();
   * }
   * }</pre>
   *
   * @param network Required. The network to update.
   *     <p>The `name` field is used to identify the instance to update. Format:
   *     projects/{project}/locations/{location}/networks/{network}
   * @param updateMask The list of fields to update. The only currently supported fields are:
   *     `labels`, `reservations`, `vrf.vlan_attachments`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Network, OperationMetadata> updateNetworkAsync(
      Network network, FieldMask updateMask) {
    UpdateNetworkRequest request =
        UpdateNetworkRequest.newBuilder().setNetwork(network).setUpdateMask(updateMask).build();
    return updateNetworkAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update details of a single network.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   UpdateNetworkRequest request =
   *       UpdateNetworkRequest.newBuilder()
   *           .setNetwork(Network.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Network response = bareMetalSolutionClient.updateNetworkAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Network, OperationMetadata> updateNetworkAsync(
      UpdateNetworkRequest request) {
    return updateNetworkOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update details of a single network.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   UpdateNetworkRequest request =
   *       UpdateNetworkRequest.newBuilder()
   *           .setNetwork(Network.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<Network, OperationMetadata> future =
   *       bareMetalSolutionClient.updateNetworkOperationCallable().futureCall(request);
   *   // Do something.
   *   Network response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateNetworkRequest, Network, OperationMetadata>
      updateNetworkOperationCallable() {
    return stub.updateNetworkOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update details of a single network.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   UpdateNetworkRequest request =
   *       UpdateNetworkRequest.newBuilder()
   *           .setNetwork(Network.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       bareMetalSolutionClient.updateNetworkCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateNetworkRequest, Operation> updateNetworkCallable() {
    return stub.updateNetworkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Takes a snapshot of a boot volume. Returns INVALID_ARGUMENT if called for a non-boot volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   VolumeName parent = VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]");
   *   VolumeSnapshot volumeSnapshot = VolumeSnapshot.newBuilder().build();
   *   VolumeSnapshot response =
   *       bareMetalSolutionClient.createVolumeSnapshot(parent, volumeSnapshot);
   * }
   * }</pre>
   *
   * @param parent Required. The volume to snapshot.
   * @param volumeSnapshot Required. The snapshot to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VolumeSnapshot createVolumeSnapshot(
      VolumeName parent, VolumeSnapshot volumeSnapshot) {
    CreateVolumeSnapshotRequest request =
        CreateVolumeSnapshotRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setVolumeSnapshot(volumeSnapshot)
            .build();
    return createVolumeSnapshot(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Takes a snapshot of a boot volume. Returns INVALID_ARGUMENT if called for a non-boot volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String parent = VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString();
   *   VolumeSnapshot volumeSnapshot = VolumeSnapshot.newBuilder().build();
   *   VolumeSnapshot response =
   *       bareMetalSolutionClient.createVolumeSnapshot(parent, volumeSnapshot);
   * }
   * }</pre>
   *
   * @param parent Required. The volume to snapshot.
   * @param volumeSnapshot Required. The snapshot to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VolumeSnapshot createVolumeSnapshot(String parent, VolumeSnapshot volumeSnapshot) {
    CreateVolumeSnapshotRequest request =
        CreateVolumeSnapshotRequest.newBuilder()
            .setParent(parent)
            .setVolumeSnapshot(volumeSnapshot)
            .build();
    return createVolumeSnapshot(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Takes a snapshot of a boot volume. Returns INVALID_ARGUMENT if called for a non-boot volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   CreateVolumeSnapshotRequest request =
   *       CreateVolumeSnapshotRequest.newBuilder()
   *           .setParent(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
   *           .setVolumeSnapshot(VolumeSnapshot.newBuilder().build())
   *           .build();
   *   VolumeSnapshot response = bareMetalSolutionClient.createVolumeSnapshot(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VolumeSnapshot createVolumeSnapshot(CreateVolumeSnapshotRequest request) {
    return createVolumeSnapshotCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Takes a snapshot of a boot volume. Returns INVALID_ARGUMENT if called for a non-boot volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   CreateVolumeSnapshotRequest request =
   *       CreateVolumeSnapshotRequest.newBuilder()
   *           .setParent(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
   *           .setVolumeSnapshot(VolumeSnapshot.newBuilder().build())
   *           .build();
   *   ApiFuture<VolumeSnapshot> future =
   *       bareMetalSolutionClient.createVolumeSnapshotCallable().futureCall(request);
   *   // Do something.
   *   VolumeSnapshot response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateVolumeSnapshotRequest, VolumeSnapshot>
      createVolumeSnapshotCallable() {
    return stub.createVolumeSnapshotCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Uses the specified snapshot to restore its parent volume. Returns INVALID_ARGUMENT if called
   * for a non-boot volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   VolumeSnapshotName volumeSnapshot =
   *       VolumeSnapshotName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[SNAPSHOT]");
   *   VolumeSnapshot response =
   *       bareMetalSolutionClient.restoreVolumeSnapshotAsync(volumeSnapshot).get();
   * }
   * }</pre>
   *
   * @param volumeSnapshot Required. Name of the snapshot which will be used to restore its parent
   *     volume.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<VolumeSnapshot, OperationMetadata> restoreVolumeSnapshotAsync(
      VolumeSnapshotName volumeSnapshot) {
    RestoreVolumeSnapshotRequest request =
        RestoreVolumeSnapshotRequest.newBuilder()
            .setVolumeSnapshot(volumeSnapshot == null ? null : volumeSnapshot.toString())
            .build();
    return restoreVolumeSnapshotAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Uses the specified snapshot to restore its parent volume. Returns INVALID_ARGUMENT if called
   * for a non-boot volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String volumeSnapshot =
   *       VolumeSnapshotName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[SNAPSHOT]").toString();
   *   VolumeSnapshot response =
   *       bareMetalSolutionClient.restoreVolumeSnapshotAsync(volumeSnapshot).get();
   * }
   * }</pre>
   *
   * @param volumeSnapshot Required. Name of the snapshot which will be used to restore its parent
   *     volume.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<VolumeSnapshot, OperationMetadata> restoreVolumeSnapshotAsync(
      String volumeSnapshot) {
    RestoreVolumeSnapshotRequest request =
        RestoreVolumeSnapshotRequest.newBuilder().setVolumeSnapshot(volumeSnapshot).build();
    return restoreVolumeSnapshotAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Uses the specified snapshot to restore its parent volume. Returns INVALID_ARGUMENT if called
   * for a non-boot volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   RestoreVolumeSnapshotRequest request =
   *       RestoreVolumeSnapshotRequest.newBuilder()
   *           .setVolumeSnapshot(
   *               VolumeSnapshotName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[SNAPSHOT]")
   *                   .toString())
   *           .build();
   *   VolumeSnapshot response = bareMetalSolutionClient.restoreVolumeSnapshotAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<VolumeSnapshot, OperationMetadata> restoreVolumeSnapshotAsync(
      RestoreVolumeSnapshotRequest request) {
    return restoreVolumeSnapshotOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Uses the specified snapshot to restore its parent volume. Returns INVALID_ARGUMENT if called
   * for a non-boot volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   RestoreVolumeSnapshotRequest request =
   *       RestoreVolumeSnapshotRequest.newBuilder()
   *           .setVolumeSnapshot(
   *               VolumeSnapshotName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[SNAPSHOT]")
   *                   .toString())
   *           .build();
   *   OperationFuture<VolumeSnapshot, OperationMetadata> future =
   *       bareMetalSolutionClient.restoreVolumeSnapshotOperationCallable().futureCall(request);
   *   // Do something.
   *   VolumeSnapshot response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<RestoreVolumeSnapshotRequest, VolumeSnapshot, OperationMetadata>
      restoreVolumeSnapshotOperationCallable() {
    return stub.restoreVolumeSnapshotOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Uses the specified snapshot to restore its parent volume. Returns INVALID_ARGUMENT if called
   * for a non-boot volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   RestoreVolumeSnapshotRequest request =
   *       RestoreVolumeSnapshotRequest.newBuilder()
   *           .setVolumeSnapshot(
   *               VolumeSnapshotName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[SNAPSHOT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       bareMetalSolutionClient.restoreVolumeSnapshotCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RestoreVolumeSnapshotRequest, Operation>
      restoreVolumeSnapshotCallable() {
    return stub.restoreVolumeSnapshotCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a volume snapshot. Returns INVALID_ARGUMENT if called for a non-boot volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   VolumeSnapshotName name =
   *       VolumeSnapshotName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[SNAPSHOT]");
   *   bareMetalSolutionClient.deleteVolumeSnapshot(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the snapshot to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteVolumeSnapshot(VolumeSnapshotName name) {
    DeleteVolumeSnapshotRequest request =
        DeleteVolumeSnapshotRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteVolumeSnapshot(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a volume snapshot. Returns INVALID_ARGUMENT if called for a non-boot volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String name =
   *       VolumeSnapshotName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[SNAPSHOT]").toString();
   *   bareMetalSolutionClient.deleteVolumeSnapshot(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the snapshot to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteVolumeSnapshot(String name) {
    DeleteVolumeSnapshotRequest request =
        DeleteVolumeSnapshotRequest.newBuilder().setName(name).build();
    deleteVolumeSnapshot(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a volume snapshot. Returns INVALID_ARGUMENT if called for a non-boot volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   DeleteVolumeSnapshotRequest request =
   *       DeleteVolumeSnapshotRequest.newBuilder()
   *           .setName(
   *               VolumeSnapshotName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[SNAPSHOT]")
   *                   .toString())
   *           .build();
   *   bareMetalSolutionClient.deleteVolumeSnapshot(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteVolumeSnapshot(DeleteVolumeSnapshotRequest request) {
    deleteVolumeSnapshotCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a volume snapshot. Returns INVALID_ARGUMENT if called for a non-boot volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   DeleteVolumeSnapshotRequest request =
   *       DeleteVolumeSnapshotRequest.newBuilder()
   *           .setName(
   *               VolumeSnapshotName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[SNAPSHOT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       bareMetalSolutionClient.deleteVolumeSnapshotCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteVolumeSnapshotRequest, Empty> deleteVolumeSnapshotCallable() {
    return stub.deleteVolumeSnapshotCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified snapshot resource. Returns INVALID_ARGUMENT if called for a non-boot
   * volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   VolumeSnapshotName name =
   *       VolumeSnapshotName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[SNAPSHOT]");
   *   VolumeSnapshot response = bareMetalSolutionClient.getVolumeSnapshot(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the snapshot.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VolumeSnapshot getVolumeSnapshot(VolumeSnapshotName name) {
    GetVolumeSnapshotRequest request =
        GetVolumeSnapshotRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getVolumeSnapshot(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified snapshot resource. Returns INVALID_ARGUMENT if called for a non-boot
   * volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String name =
   *       VolumeSnapshotName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[SNAPSHOT]").toString();
   *   VolumeSnapshot response = bareMetalSolutionClient.getVolumeSnapshot(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the snapshot.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VolumeSnapshot getVolumeSnapshot(String name) {
    GetVolumeSnapshotRequest request = GetVolumeSnapshotRequest.newBuilder().setName(name).build();
    return getVolumeSnapshot(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified snapshot resource. Returns INVALID_ARGUMENT if called for a non-boot
   * volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   GetVolumeSnapshotRequest request =
   *       GetVolumeSnapshotRequest.newBuilder()
   *           .setName(
   *               VolumeSnapshotName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[SNAPSHOT]")
   *                   .toString())
   *           .build();
   *   VolumeSnapshot response = bareMetalSolutionClient.getVolumeSnapshot(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VolumeSnapshot getVolumeSnapshot(GetVolumeSnapshotRequest request) {
    return getVolumeSnapshotCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified snapshot resource. Returns INVALID_ARGUMENT if called for a non-boot
   * volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   GetVolumeSnapshotRequest request =
   *       GetVolumeSnapshotRequest.newBuilder()
   *           .setName(
   *               VolumeSnapshotName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[SNAPSHOT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<VolumeSnapshot> future =
   *       bareMetalSolutionClient.getVolumeSnapshotCallable().futureCall(request);
   *   // Do something.
   *   VolumeSnapshot response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetVolumeSnapshotRequest, VolumeSnapshot> getVolumeSnapshotCallable() {
    return stub.getVolumeSnapshotCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of snapshots for the specified volume. Returns a response with an empty list
   * of snapshots if called for a non-boot volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   VolumeName parent = VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]");
   *   for (VolumeSnapshot element :
   *       bareMetalSolutionClient.listVolumeSnapshots(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListVolumesRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVolumeSnapshotsPagedResponse listVolumeSnapshots(VolumeName parent) {
    ListVolumeSnapshotsRequest request =
        ListVolumeSnapshotsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listVolumeSnapshots(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of snapshots for the specified volume. Returns a response with an empty list
   * of snapshots if called for a non-boot volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String parent = VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString();
   *   for (VolumeSnapshot element :
   *       bareMetalSolutionClient.listVolumeSnapshots(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListVolumesRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVolumeSnapshotsPagedResponse listVolumeSnapshots(String parent) {
    ListVolumeSnapshotsRequest request =
        ListVolumeSnapshotsRequest.newBuilder().setParent(parent).build();
    return listVolumeSnapshots(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of snapshots for the specified volume. Returns a response with an empty list
   * of snapshots if called for a non-boot volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListVolumeSnapshotsRequest request =
   *       ListVolumeSnapshotsRequest.newBuilder()
   *           .setParent(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (VolumeSnapshot element :
   *       bareMetalSolutionClient.listVolumeSnapshots(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVolumeSnapshotsPagedResponse listVolumeSnapshots(
      ListVolumeSnapshotsRequest request) {
    return listVolumeSnapshotsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of snapshots for the specified volume. Returns a response with an empty list
   * of snapshots if called for a non-boot volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListVolumeSnapshotsRequest request =
   *       ListVolumeSnapshotsRequest.newBuilder()
   *           .setParent(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<VolumeSnapshot> future =
   *       bareMetalSolutionClient.listVolumeSnapshotsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (VolumeSnapshot element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListVolumeSnapshotsRequest, ListVolumeSnapshotsPagedResponse>
      listVolumeSnapshotsPagedCallable() {
    return stub.listVolumeSnapshotsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of snapshots for the specified volume. Returns a response with an empty list
   * of snapshots if called for a non-boot volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListVolumeSnapshotsRequest request =
   *       ListVolumeSnapshotsRequest.newBuilder()
   *           .setParent(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListVolumeSnapshotsResponse response =
   *         bareMetalSolutionClient.listVolumeSnapshotsCallable().call(request);
   *     for (VolumeSnapshot element : response.getVolumeSnapshotsList()) {
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
  public final UnaryCallable<ListVolumeSnapshotsRequest, ListVolumeSnapshotsResponse>
      listVolumeSnapshotsCallable() {
    return stub.listVolumeSnapshotsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details of a single storage logical unit number(LUN).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   LunName name = LunName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[LUN]");
   *   Lun response = bareMetalSolutionClient.getLun(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Lun getLun(LunName name) {
    GetLunRequest request =
        GetLunRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getLun(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details of a single storage logical unit number(LUN).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String name = LunName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[LUN]").toString();
   *   Lun response = bareMetalSolutionClient.getLun(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Lun getLun(String name) {
    GetLunRequest request = GetLunRequest.newBuilder().setName(name).build();
    return getLun(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details of a single storage logical unit number(LUN).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   GetLunRequest request =
   *       GetLunRequest.newBuilder()
   *           .setName(LunName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[LUN]").toString())
   *           .build();
   *   Lun response = bareMetalSolutionClient.getLun(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Lun getLun(GetLunRequest request) {
    return getLunCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details of a single storage logical unit number(LUN).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   GetLunRequest request =
   *       GetLunRequest.newBuilder()
   *           .setName(LunName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[LUN]").toString())
   *           .build();
   *   ApiFuture<Lun> future = bareMetalSolutionClient.getLunCallable().futureCall(request);
   *   // Do something.
   *   Lun response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLunRequest, Lun> getLunCallable() {
    return stub.getLunCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List storage volume luns for given storage volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   VolumeName parent = VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]");
   *   for (Lun element : bareMetalSolutionClient.listLuns(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListLunsRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLunsPagedResponse listLuns(VolumeName parent) {
    ListLunsRequest request =
        ListLunsRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listLuns(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List storage volume luns for given storage volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String parent = VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString();
   *   for (Lun element : bareMetalSolutionClient.listLuns(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListLunsRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLunsPagedResponse listLuns(String parent) {
    ListLunsRequest request = ListLunsRequest.newBuilder().setParent(parent).build();
    return listLuns(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List storage volume luns for given storage volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListLunsRequest request =
   *       ListLunsRequest.newBuilder()
   *           .setParent(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Lun element : bareMetalSolutionClient.listLuns(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLunsPagedResponse listLuns(ListLunsRequest request) {
    return listLunsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List storage volume luns for given storage volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListLunsRequest request =
   *       ListLunsRequest.newBuilder()
   *           .setParent(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Lun> future = bareMetalSolutionClient.listLunsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Lun element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLunsRequest, ListLunsPagedResponse> listLunsPagedCallable() {
    return stub.listLunsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List storage volume luns for given storage volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListLunsRequest request =
   *       ListLunsRequest.newBuilder()
   *           .setParent(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLunsResponse response = bareMetalSolutionClient.listLunsCallable().call(request);
   *     for (Lun element : response.getLunsList()) {
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
  public final UnaryCallable<ListLunsRequest, ListLunsResponse> listLunsCallable() {
    return stub.listLunsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Skips lun's cooloff and deletes it now. Lun must be in cooloff state.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   LunName name = LunName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[LUN]");
   *   bareMetalSolutionClient.evictLunAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the lun.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> evictLunAsync(LunName name) {
    EvictLunRequest request =
        EvictLunRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return evictLunAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Skips lun's cooloff and deletes it now. Lun must be in cooloff state.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String name = LunName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[LUN]").toString();
   *   bareMetalSolutionClient.evictLunAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the lun.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> evictLunAsync(String name) {
    EvictLunRequest request = EvictLunRequest.newBuilder().setName(name).build();
    return evictLunAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Skips lun's cooloff and deletes it now. Lun must be in cooloff state.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   EvictLunRequest request =
   *       EvictLunRequest.newBuilder()
   *           .setName(LunName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[LUN]").toString())
   *           .build();
   *   bareMetalSolutionClient.evictLunAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> evictLunAsync(EvictLunRequest request) {
    return evictLunOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Skips lun's cooloff and deletes it now. Lun must be in cooloff state.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   EvictLunRequest request =
   *       EvictLunRequest.newBuilder()
   *           .setName(LunName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[LUN]").toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       bareMetalSolutionClient.evictLunOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<EvictLunRequest, Empty, OperationMetadata>
      evictLunOperationCallable() {
    return stub.evictLunOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Skips lun's cooloff and deletes it now. Lun must be in cooloff state.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   EvictLunRequest request =
   *       EvictLunRequest.newBuilder()
   *           .setName(LunName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[LUN]").toString())
   *           .build();
   *   ApiFuture<Operation> future = bareMetalSolutionClient.evictLunCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<EvictLunRequest, Operation> evictLunCallable() {
    return stub.evictLunCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details of a single NFS share.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   NFSShareName name = NFSShareName.of("[PROJECT]", "[LOCATION]", "[NFS_SHARE]");
   *   NfsShare response = bareMetalSolutionClient.getNfsShare(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NfsShare getNfsShare(NFSShareName name) {
    GetNfsShareRequest request =
        GetNfsShareRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getNfsShare(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details of a single NFS share.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String name = NFSShareName.of("[PROJECT]", "[LOCATION]", "[NFS_SHARE]").toString();
   *   NfsShare response = bareMetalSolutionClient.getNfsShare(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NfsShare getNfsShare(String name) {
    GetNfsShareRequest request = GetNfsShareRequest.newBuilder().setName(name).build();
    return getNfsShare(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details of a single NFS share.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   GetNfsShareRequest request =
   *       GetNfsShareRequest.newBuilder()
   *           .setName(NFSShareName.of("[PROJECT]", "[LOCATION]", "[NFS_SHARE]").toString())
   *           .build();
   *   NfsShare response = bareMetalSolutionClient.getNfsShare(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NfsShare getNfsShare(GetNfsShareRequest request) {
    return getNfsShareCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details of a single NFS share.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   GetNfsShareRequest request =
   *       GetNfsShareRequest.newBuilder()
   *           .setName(NFSShareName.of("[PROJECT]", "[LOCATION]", "[NFS_SHARE]").toString())
   *           .build();
   *   ApiFuture<NfsShare> future =
   *       bareMetalSolutionClient.getNfsShareCallable().futureCall(request);
   *   // Do something.
   *   NfsShare response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetNfsShareRequest, NfsShare> getNfsShareCallable() {
    return stub.getNfsShareCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List NFS shares.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (NfsShare element : bareMetalSolutionClient.listNfsShares(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListNfsSharesRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNfsSharesPagedResponse listNfsShares(LocationName parent) {
    ListNfsSharesRequest request =
        ListNfsSharesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listNfsShares(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List NFS shares.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (NfsShare element : bareMetalSolutionClient.listNfsShares(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListNfsSharesRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNfsSharesPagedResponse listNfsShares(String parent) {
    ListNfsSharesRequest request = ListNfsSharesRequest.newBuilder().setParent(parent).build();
    return listNfsShares(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List NFS shares.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListNfsSharesRequest request =
   *       ListNfsSharesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (NfsShare element : bareMetalSolutionClient.listNfsShares(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNfsSharesPagedResponse listNfsShares(ListNfsSharesRequest request) {
    return listNfsSharesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List NFS shares.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListNfsSharesRequest request =
   *       ListNfsSharesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<NfsShare> future =
   *       bareMetalSolutionClient.listNfsSharesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (NfsShare element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListNfsSharesRequest, ListNfsSharesPagedResponse>
      listNfsSharesPagedCallable() {
    return stub.listNfsSharesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List NFS shares.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListNfsSharesRequest request =
   *       ListNfsSharesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListNfsSharesResponse response =
   *         bareMetalSolutionClient.listNfsSharesCallable().call(request);
   *     for (NfsShare element : response.getNfsSharesList()) {
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
  public final UnaryCallable<ListNfsSharesRequest, ListNfsSharesResponse> listNfsSharesCallable() {
    return stub.listNfsSharesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update details of a single NFS share.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   NfsShare nfsShare = NfsShare.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   NfsShare response = bareMetalSolutionClient.updateNfsShareAsync(nfsShare, updateMask).get();
   * }
   * }</pre>
   *
   * @param nfsShare Required. The NFS share to update.
   *     <p>The `name` field is used to identify the NFS share to update. Format:
   *     projects/{project}/locations/{location}/nfsShares/{nfs_share}
   * @param updateMask The list of fields to update. The only currently supported fields are:
   *     `labels` `allowed_clients`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<NfsShare, OperationMetadata> updateNfsShareAsync(
      NfsShare nfsShare, FieldMask updateMask) {
    UpdateNfsShareRequest request =
        UpdateNfsShareRequest.newBuilder().setNfsShare(nfsShare).setUpdateMask(updateMask).build();
    return updateNfsShareAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update details of a single NFS share.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   UpdateNfsShareRequest request =
   *       UpdateNfsShareRequest.newBuilder()
   *           .setNfsShare(NfsShare.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   NfsShare response = bareMetalSolutionClient.updateNfsShareAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<NfsShare, OperationMetadata> updateNfsShareAsync(
      UpdateNfsShareRequest request) {
    return updateNfsShareOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update details of a single NFS share.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   UpdateNfsShareRequest request =
   *       UpdateNfsShareRequest.newBuilder()
   *           .setNfsShare(NfsShare.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<NfsShare, OperationMetadata> future =
   *       bareMetalSolutionClient.updateNfsShareOperationCallable().futureCall(request);
   *   // Do something.
   *   NfsShare response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateNfsShareRequest, NfsShare, OperationMetadata>
      updateNfsShareOperationCallable() {
    return stub.updateNfsShareOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update details of a single NFS share.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   UpdateNfsShareRequest request =
   *       UpdateNfsShareRequest.newBuilder()
   *           .setNfsShare(NfsShare.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       bareMetalSolutionClient.updateNfsShareCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateNfsShareRequest, Operation> updateNfsShareCallable() {
    return stub.updateNfsShareCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create an NFS share.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   NfsShare nfsShare = NfsShare.newBuilder().build();
   *   NfsShare response = bareMetalSolutionClient.createNfsShareAsync(parent, nfsShare).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent project and location.
   * @param nfsShare Required. The NfsShare to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<NfsShare, OperationMetadata> createNfsShareAsync(
      LocationName parent, NfsShare nfsShare) {
    CreateNfsShareRequest request =
        CreateNfsShareRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setNfsShare(nfsShare)
            .build();
    return createNfsShareAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create an NFS share.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   NfsShare nfsShare = NfsShare.newBuilder().build();
   *   NfsShare response = bareMetalSolutionClient.createNfsShareAsync(parent, nfsShare).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent project and location.
   * @param nfsShare Required. The NfsShare to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<NfsShare, OperationMetadata> createNfsShareAsync(
      String parent, NfsShare nfsShare) {
    CreateNfsShareRequest request =
        CreateNfsShareRequest.newBuilder().setParent(parent).setNfsShare(nfsShare).build();
    return createNfsShareAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create an NFS share.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   CreateNfsShareRequest request =
   *       CreateNfsShareRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setNfsShare(NfsShare.newBuilder().build())
   *           .build();
   *   NfsShare response = bareMetalSolutionClient.createNfsShareAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<NfsShare, OperationMetadata> createNfsShareAsync(
      CreateNfsShareRequest request) {
    return createNfsShareOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create an NFS share.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   CreateNfsShareRequest request =
   *       CreateNfsShareRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setNfsShare(NfsShare.newBuilder().build())
   *           .build();
   *   OperationFuture<NfsShare, OperationMetadata> future =
   *       bareMetalSolutionClient.createNfsShareOperationCallable().futureCall(request);
   *   // Do something.
   *   NfsShare response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateNfsShareRequest, NfsShare, OperationMetadata>
      createNfsShareOperationCallable() {
    return stub.createNfsShareOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create an NFS share.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   CreateNfsShareRequest request =
   *       CreateNfsShareRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setNfsShare(NfsShare.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       bareMetalSolutionClient.createNfsShareCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateNfsShareRequest, Operation> createNfsShareCallable() {
    return stub.createNfsShareCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * RenameNfsShare sets a new name for an nfsshare. Use with caution, previous names become
   * immediately invalidated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   NFSShareName name = NFSShareName.of("[PROJECT]", "[LOCATION]", "[NFS_SHARE]");
   *   String newNfsshareId = "newNfsshareId1643043071";
   *   NfsShare response = bareMetalSolutionClient.renameNfsShare(name, newNfsshareId);
   * }
   * }</pre>
   *
   * @param name Required. The `name` field is used to identify the nfsshare. Format:
   *     projects/{project}/locations/{location}/nfsshares/{nfsshare}
   * @param newNfsshareId Required. The new `id` of the nfsshare.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NfsShare renameNfsShare(NFSShareName name, String newNfsshareId) {
    RenameNfsShareRequest request =
        RenameNfsShareRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setNewNfsshareId(newNfsshareId)
            .build();
    return renameNfsShare(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * RenameNfsShare sets a new name for an nfsshare. Use with caution, previous names become
   * immediately invalidated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String name = NFSShareName.of("[PROJECT]", "[LOCATION]", "[NFS_SHARE]").toString();
   *   String newNfsshareId = "newNfsshareId1643043071";
   *   NfsShare response = bareMetalSolutionClient.renameNfsShare(name, newNfsshareId);
   * }
   * }</pre>
   *
   * @param name Required. The `name` field is used to identify the nfsshare. Format:
   *     projects/{project}/locations/{location}/nfsshares/{nfsshare}
   * @param newNfsshareId Required. The new `id` of the nfsshare.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NfsShare renameNfsShare(String name, String newNfsshareId) {
    RenameNfsShareRequest request =
        RenameNfsShareRequest.newBuilder().setName(name).setNewNfsshareId(newNfsshareId).build();
    return renameNfsShare(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * RenameNfsShare sets a new name for an nfsshare. Use with caution, previous names become
   * immediately invalidated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   RenameNfsShareRequest request =
   *       RenameNfsShareRequest.newBuilder()
   *           .setName(NFSShareName.of("[PROJECT]", "[LOCATION]", "[NFS_SHARE]").toString())
   *           .setNewNfsshareId("newNfsshareId1643043071")
   *           .build();
   *   NfsShare response = bareMetalSolutionClient.renameNfsShare(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NfsShare renameNfsShare(RenameNfsShareRequest request) {
    return renameNfsShareCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * RenameNfsShare sets a new name for an nfsshare. Use with caution, previous names become
   * immediately invalidated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   RenameNfsShareRequest request =
   *       RenameNfsShareRequest.newBuilder()
   *           .setName(NFSShareName.of("[PROJECT]", "[LOCATION]", "[NFS_SHARE]").toString())
   *           .setNewNfsshareId("newNfsshareId1643043071")
   *           .build();
   *   ApiFuture<NfsShare> future =
   *       bareMetalSolutionClient.renameNfsShareCallable().futureCall(request);
   *   // Do something.
   *   NfsShare response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RenameNfsShareRequest, NfsShare> renameNfsShareCallable() {
    return stub.renameNfsShareCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete an NFS share. The underlying volume is automatically deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   NFSShareName name = NFSShareName.of("[PROJECT]", "[LOCATION]", "[NFS_SHARE]");
   *   bareMetalSolutionClient.deleteNfsShareAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the NFS share to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteNfsShareAsync(NFSShareName name) {
    DeleteNfsShareRequest request =
        DeleteNfsShareRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteNfsShareAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete an NFS share. The underlying volume is automatically deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String name = NFSShareName.of("[PROJECT]", "[LOCATION]", "[NFS_SHARE]").toString();
   *   bareMetalSolutionClient.deleteNfsShareAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the NFS share to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteNfsShareAsync(String name) {
    DeleteNfsShareRequest request = DeleteNfsShareRequest.newBuilder().setName(name).build();
    return deleteNfsShareAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete an NFS share. The underlying volume is automatically deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   DeleteNfsShareRequest request =
   *       DeleteNfsShareRequest.newBuilder()
   *           .setName(NFSShareName.of("[PROJECT]", "[LOCATION]", "[NFS_SHARE]").toString())
   *           .build();
   *   bareMetalSolutionClient.deleteNfsShareAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteNfsShareAsync(
      DeleteNfsShareRequest request) {
    return deleteNfsShareOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete an NFS share. The underlying volume is automatically deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   DeleteNfsShareRequest request =
   *       DeleteNfsShareRequest.newBuilder()
   *           .setName(NFSShareName.of("[PROJECT]", "[LOCATION]", "[NFS_SHARE]").toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       bareMetalSolutionClient.deleteNfsShareOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteNfsShareRequest, Empty, OperationMetadata>
      deleteNfsShareOperationCallable() {
    return stub.deleteNfsShareOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete an NFS share. The underlying volume is automatically deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   DeleteNfsShareRequest request =
   *       DeleteNfsShareRequest.newBuilder()
   *           .setName(NFSShareName.of("[PROJECT]", "[LOCATION]", "[NFS_SHARE]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       bareMetalSolutionClient.deleteNfsShareCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteNfsShareRequest, Operation> deleteNfsShareCallable() {
    return stub.deleteNfsShareCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List the budget details to provision resources on a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (ProvisioningQuota element :
   *       bareMetalSolutionClient.listProvisioningQuotas(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListProvisioningQuotasRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProvisioningQuotasPagedResponse listProvisioningQuotas(LocationName parent) {
    ListProvisioningQuotasRequest request =
        ListProvisioningQuotasRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listProvisioningQuotas(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List the budget details to provision resources on a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (ProvisioningQuota element :
   *       bareMetalSolutionClient.listProvisioningQuotas(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListProvisioningQuotasRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProvisioningQuotasPagedResponse listProvisioningQuotas(String parent) {
    ListProvisioningQuotasRequest request =
        ListProvisioningQuotasRequest.newBuilder().setParent(parent).build();
    return listProvisioningQuotas(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List the budget details to provision resources on a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListProvisioningQuotasRequest request =
   *       ListProvisioningQuotasRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (ProvisioningQuota element :
   *       bareMetalSolutionClient.listProvisioningQuotas(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProvisioningQuotasPagedResponse listProvisioningQuotas(
      ListProvisioningQuotasRequest request) {
    return listProvisioningQuotasPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List the budget details to provision resources on a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListProvisioningQuotasRequest request =
   *       ListProvisioningQuotasRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<ProvisioningQuota> future =
   *       bareMetalSolutionClient.listProvisioningQuotasPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ProvisioningQuota element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListProvisioningQuotasRequest, ListProvisioningQuotasPagedResponse>
      listProvisioningQuotasPagedCallable() {
    return stub.listProvisioningQuotasPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List the budget details to provision resources on a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListProvisioningQuotasRequest request =
   *       ListProvisioningQuotasRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListProvisioningQuotasResponse response =
   *         bareMetalSolutionClient.listProvisioningQuotasCallable().call(request);
   *     for (ProvisioningQuota element : response.getProvisioningQuotasList()) {
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
  public final UnaryCallable<ListProvisioningQuotasRequest, ListProvisioningQuotasResponse>
      listProvisioningQuotasCallable() {
    return stub.listProvisioningQuotasCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Submit a provisiong configuration for a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ProvisioningConfig provisioningConfig = ProvisioningConfig.newBuilder().build();
   *   SubmitProvisioningConfigResponse response =
   *       bareMetalSolutionClient.submitProvisioningConfig(parent, provisioningConfig);
   * }
   * }</pre>
   *
   * @param parent Required. The parent project and location containing the ProvisioningConfig.
   * @param provisioningConfig Required. The ProvisioningConfig to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SubmitProvisioningConfigResponse submitProvisioningConfig(
      LocationName parent, ProvisioningConfig provisioningConfig) {
    SubmitProvisioningConfigRequest request =
        SubmitProvisioningConfigRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setProvisioningConfig(provisioningConfig)
            .build();
    return submitProvisioningConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Submit a provisiong configuration for a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   ProvisioningConfig provisioningConfig = ProvisioningConfig.newBuilder().build();
   *   SubmitProvisioningConfigResponse response =
   *       bareMetalSolutionClient.submitProvisioningConfig(parent, provisioningConfig);
   * }
   * }</pre>
   *
   * @param parent Required. The parent project and location containing the ProvisioningConfig.
   * @param provisioningConfig Required. The ProvisioningConfig to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SubmitProvisioningConfigResponse submitProvisioningConfig(
      String parent, ProvisioningConfig provisioningConfig) {
    SubmitProvisioningConfigRequest request =
        SubmitProvisioningConfigRequest.newBuilder()
            .setParent(parent)
            .setProvisioningConfig(provisioningConfig)
            .build();
    return submitProvisioningConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Submit a provisiong configuration for a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   SubmitProvisioningConfigRequest request =
   *       SubmitProvisioningConfigRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setProvisioningConfig(ProvisioningConfig.newBuilder().build())
   *           .setEmail("email96619420")
   *           .build();
   *   SubmitProvisioningConfigResponse response =
   *       bareMetalSolutionClient.submitProvisioningConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SubmitProvisioningConfigResponse submitProvisioningConfig(
      SubmitProvisioningConfigRequest request) {
    return submitProvisioningConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Submit a provisiong configuration for a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   SubmitProvisioningConfigRequest request =
   *       SubmitProvisioningConfigRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setProvisioningConfig(ProvisioningConfig.newBuilder().build())
   *           .setEmail("email96619420")
   *           .build();
   *   ApiFuture<SubmitProvisioningConfigResponse> future =
   *       bareMetalSolutionClient.submitProvisioningConfigCallable().futureCall(request);
   *   // Do something.
   *   SubmitProvisioningConfigResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SubmitProvisioningConfigRequest, SubmitProvisioningConfigResponse>
      submitProvisioningConfigCallable() {
    return stub.submitProvisioningConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get ProvisioningConfig by name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ProvisioningConfigName name =
   *       ProvisioningConfigName.of("[PROJECT]", "[LOCATION]", "[PROVISIONING_CONFIG]");
   *   ProvisioningConfig response = bareMetalSolutionClient.getProvisioningConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the ProvisioningConfig.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ProvisioningConfig getProvisioningConfig(ProvisioningConfigName name) {
    GetProvisioningConfigRequest request =
        GetProvisioningConfigRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getProvisioningConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get ProvisioningConfig by name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String name =
   *       ProvisioningConfigName.of("[PROJECT]", "[LOCATION]", "[PROVISIONING_CONFIG]").toString();
   *   ProvisioningConfig response = bareMetalSolutionClient.getProvisioningConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the ProvisioningConfig.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ProvisioningConfig getProvisioningConfig(String name) {
    GetProvisioningConfigRequest request =
        GetProvisioningConfigRequest.newBuilder().setName(name).build();
    return getProvisioningConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get ProvisioningConfig by name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   GetProvisioningConfigRequest request =
   *       GetProvisioningConfigRequest.newBuilder()
   *           .setName(
   *               ProvisioningConfigName.of("[PROJECT]", "[LOCATION]", "[PROVISIONING_CONFIG]")
   *                   .toString())
   *           .build();
   *   ProvisioningConfig response = bareMetalSolutionClient.getProvisioningConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ProvisioningConfig getProvisioningConfig(GetProvisioningConfigRequest request) {
    return getProvisioningConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get ProvisioningConfig by name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   GetProvisioningConfigRequest request =
   *       GetProvisioningConfigRequest.newBuilder()
   *           .setName(
   *               ProvisioningConfigName.of("[PROJECT]", "[LOCATION]", "[PROVISIONING_CONFIG]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ProvisioningConfig> future =
   *       bareMetalSolutionClient.getProvisioningConfigCallable().futureCall(request);
   *   // Do something.
   *   ProvisioningConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetProvisioningConfigRequest, ProvisioningConfig>
      getProvisioningConfigCallable() {
    return stub.getProvisioningConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create new ProvisioningConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ProvisioningConfig provisioningConfig = ProvisioningConfig.newBuilder().build();
   *   ProvisioningConfig response =
   *       bareMetalSolutionClient.createProvisioningConfig(parent, provisioningConfig);
   * }
   * }</pre>
   *
   * @param parent Required. The parent project and location containing the ProvisioningConfig.
   * @param provisioningConfig Required. The ProvisioningConfig to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ProvisioningConfig createProvisioningConfig(
      LocationName parent, ProvisioningConfig provisioningConfig) {
    CreateProvisioningConfigRequest request =
        CreateProvisioningConfigRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setProvisioningConfig(provisioningConfig)
            .build();
    return createProvisioningConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create new ProvisioningConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   ProvisioningConfig provisioningConfig = ProvisioningConfig.newBuilder().build();
   *   ProvisioningConfig response =
   *       bareMetalSolutionClient.createProvisioningConfig(parent, provisioningConfig);
   * }
   * }</pre>
   *
   * @param parent Required. The parent project and location containing the ProvisioningConfig.
   * @param provisioningConfig Required. The ProvisioningConfig to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ProvisioningConfig createProvisioningConfig(
      String parent, ProvisioningConfig provisioningConfig) {
    CreateProvisioningConfigRequest request =
        CreateProvisioningConfigRequest.newBuilder()
            .setParent(parent)
            .setProvisioningConfig(provisioningConfig)
            .build();
    return createProvisioningConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create new ProvisioningConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   CreateProvisioningConfigRequest request =
   *       CreateProvisioningConfigRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setProvisioningConfig(ProvisioningConfig.newBuilder().build())
   *           .setEmail("email96619420")
   *           .build();
   *   ProvisioningConfig response = bareMetalSolutionClient.createProvisioningConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ProvisioningConfig createProvisioningConfig(
      CreateProvisioningConfigRequest request) {
    return createProvisioningConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create new ProvisioningConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   CreateProvisioningConfigRequest request =
   *       CreateProvisioningConfigRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setProvisioningConfig(ProvisioningConfig.newBuilder().build())
   *           .setEmail("email96619420")
   *           .build();
   *   ApiFuture<ProvisioningConfig> future =
   *       bareMetalSolutionClient.createProvisioningConfigCallable().futureCall(request);
   *   // Do something.
   *   ProvisioningConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateProvisioningConfigRequest, ProvisioningConfig>
      createProvisioningConfigCallable() {
    return stub.createProvisioningConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update existing ProvisioningConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ProvisioningConfig provisioningConfig = ProvisioningConfig.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   ProvisioningConfig response =
   *       bareMetalSolutionClient.updateProvisioningConfig(provisioningConfig, updateMask);
   * }
   * }</pre>
   *
   * @param provisioningConfig Required. The ProvisioningConfig to update.
   * @param updateMask Required. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ProvisioningConfig updateProvisioningConfig(
      ProvisioningConfig provisioningConfig, FieldMask updateMask) {
    UpdateProvisioningConfigRequest request =
        UpdateProvisioningConfigRequest.newBuilder()
            .setProvisioningConfig(provisioningConfig)
            .setUpdateMask(updateMask)
            .build();
    return updateProvisioningConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update existing ProvisioningConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   UpdateProvisioningConfigRequest request =
   *       UpdateProvisioningConfigRequest.newBuilder()
   *           .setProvisioningConfig(ProvisioningConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setEmail("email96619420")
   *           .build();
   *   ProvisioningConfig response = bareMetalSolutionClient.updateProvisioningConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ProvisioningConfig updateProvisioningConfig(
      UpdateProvisioningConfigRequest request) {
    return updateProvisioningConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update existing ProvisioningConfig.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   UpdateProvisioningConfigRequest request =
   *       UpdateProvisioningConfigRequest.newBuilder()
   *           .setProvisioningConfig(ProvisioningConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setEmail("email96619420")
   *           .build();
   *   ApiFuture<ProvisioningConfig> future =
   *       bareMetalSolutionClient.updateProvisioningConfigCallable().futureCall(request);
   *   // Do something.
   *   ProvisioningConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateProvisioningConfigRequest, ProvisioningConfig>
      updateProvisioningConfigCallable() {
    return stub.updateProvisioningConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * RenameNetwork sets a new name for a network. Use with caution, previous names become
   * immediately invalidated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   NetworkName name = NetworkName.of("[PROJECT]", "[LOCATION]", "[NETWORK]");
   *   String newNetworkId = "newNetworkId-1927751127";
   *   Network response = bareMetalSolutionClient.renameNetwork(name, newNetworkId);
   * }
   * }</pre>
   *
   * @param name Required. The `name` field is used to identify the network. Format:
   *     projects/{project}/locations/{location}/networks/{network}
   * @param newNetworkId Required. The new `id` of the network.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Network renameNetwork(NetworkName name, String newNetworkId) {
    RenameNetworkRequest request =
        RenameNetworkRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setNewNetworkId(newNetworkId)
            .build();
    return renameNetwork(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * RenameNetwork sets a new name for a network. Use with caution, previous names become
   * immediately invalidated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String name = NetworkName.of("[PROJECT]", "[LOCATION]", "[NETWORK]").toString();
   *   String newNetworkId = "newNetworkId-1927751127";
   *   Network response = bareMetalSolutionClient.renameNetwork(name, newNetworkId);
   * }
   * }</pre>
   *
   * @param name Required. The `name` field is used to identify the network. Format:
   *     projects/{project}/locations/{location}/networks/{network}
   * @param newNetworkId Required. The new `id` of the network.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Network renameNetwork(String name, String newNetworkId) {
    RenameNetworkRequest request =
        RenameNetworkRequest.newBuilder().setName(name).setNewNetworkId(newNetworkId).build();
    return renameNetwork(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * RenameNetwork sets a new name for a network. Use with caution, previous names become
   * immediately invalidated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   RenameNetworkRequest request =
   *       RenameNetworkRequest.newBuilder()
   *           .setName(NetworkName.of("[PROJECT]", "[LOCATION]", "[NETWORK]").toString())
   *           .setNewNetworkId("newNetworkId-1927751127")
   *           .build();
   *   Network response = bareMetalSolutionClient.renameNetwork(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Network renameNetwork(RenameNetworkRequest request) {
    return renameNetworkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * RenameNetwork sets a new name for a network. Use with caution, previous names become
   * immediately invalidated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   RenameNetworkRequest request =
   *       RenameNetworkRequest.newBuilder()
   *           .setName(NetworkName.of("[PROJECT]", "[LOCATION]", "[NETWORK]").toString())
   *           .setNewNetworkId("newNetworkId-1927751127")
   *           .build();
   *   ApiFuture<Network> future =
   *       bareMetalSolutionClient.renameNetworkCallable().futureCall(request);
   *   // Do something.
   *   Network response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RenameNetworkRequest, Network> renameNetworkCallable() {
    return stub.renameNetworkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of OS images which are currently approved.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (OSImage element : bareMetalSolutionClient.listOSImages(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListProvisioningQuotasRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOSImagesPagedResponse listOSImages(LocationName parent) {
    ListOSImagesRequest request =
        ListOSImagesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listOSImages(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of OS images which are currently approved.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (OSImage element : bareMetalSolutionClient.listOSImages(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListProvisioningQuotasRequest.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOSImagesPagedResponse listOSImages(String parent) {
    ListOSImagesRequest request = ListOSImagesRequest.newBuilder().setParent(parent).build();
    return listOSImages(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of OS images which are currently approved.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListOSImagesRequest request =
   *       ListOSImagesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (OSImage element : bareMetalSolutionClient.listOSImages(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOSImagesPagedResponse listOSImages(ListOSImagesRequest request) {
    return listOSImagesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of OS images which are currently approved.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListOSImagesRequest request =
   *       ListOSImagesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<OSImage> future =
   *       bareMetalSolutionClient.listOSImagesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (OSImage element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListOSImagesRequest, ListOSImagesPagedResponse>
      listOSImagesPagedCallable() {
    return stub.listOSImagesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of OS images which are currently approved.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListOSImagesRequest request =
   *       ListOSImagesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListOSImagesResponse response =
   *         bareMetalSolutionClient.listOSImagesCallable().call(request);
   *     for (OSImage element : response.getOsImagesList()) {
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
  public final UnaryCallable<ListOSImagesRequest, ListOSImagesResponse> listOSImagesCallable() {
    return stub.listOSImagesCallable();
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
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : bareMetalSolutionClient.listLocations(request).iterateAll()) {
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
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       bareMetalSolutionClient.listLocationsPagedCallable().futureCall(request);
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
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         bareMetalSolutionClient.listLocationsCallable().call(request);
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
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = bareMetalSolutionClient.getLocation(request);
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
   * try (BareMetalSolutionClient bareMetalSolutionClient = BareMetalSolutionClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       bareMetalSolutionClient.getLocationCallable().futureCall(request);
   *   // Do something.
   *   Location response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return stub.getLocationCallable();
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

  public static class ListInstancesPagedResponse
      extends AbstractPagedListResponse<
          ListInstancesRequest,
          ListInstancesResponse,
          Instance,
          ListInstancesPage,
          ListInstancesFixedSizeCollection> {

    public static ApiFuture<ListInstancesPagedResponse> createAsync(
        PageContext<ListInstancesRequest, ListInstancesResponse, Instance> context,
        ApiFuture<ListInstancesResponse> futureResponse) {
      ApiFuture<ListInstancesPage> futurePage =
          ListInstancesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListInstancesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListInstancesPagedResponse(ListInstancesPage page) {
      super(page, ListInstancesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListInstancesPage
      extends AbstractPage<
          ListInstancesRequest, ListInstancesResponse, Instance, ListInstancesPage> {

    private ListInstancesPage(
        PageContext<ListInstancesRequest, ListInstancesResponse, Instance> context,
        ListInstancesResponse response) {
      super(context, response);
    }

    private static ListInstancesPage createEmptyPage() {
      return new ListInstancesPage(null, null);
    }

    @Override
    protected ListInstancesPage createPage(
        PageContext<ListInstancesRequest, ListInstancesResponse, Instance> context,
        ListInstancesResponse response) {
      return new ListInstancesPage(context, response);
    }

    @Override
    public ApiFuture<ListInstancesPage> createPageAsync(
        PageContext<ListInstancesRequest, ListInstancesResponse, Instance> context,
        ApiFuture<ListInstancesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListInstancesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListInstancesRequest,
          ListInstancesResponse,
          Instance,
          ListInstancesPage,
          ListInstancesFixedSizeCollection> {

    private ListInstancesFixedSizeCollection(List<ListInstancesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListInstancesFixedSizeCollection createEmptyCollection() {
      return new ListInstancesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListInstancesFixedSizeCollection createCollection(
        List<ListInstancesPage> pages, int collectionSize) {
      return new ListInstancesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListSSHKeysPagedResponse
      extends AbstractPagedListResponse<
          ListSSHKeysRequest,
          ListSSHKeysResponse,
          SSHKey,
          ListSSHKeysPage,
          ListSSHKeysFixedSizeCollection> {

    public static ApiFuture<ListSSHKeysPagedResponse> createAsync(
        PageContext<ListSSHKeysRequest, ListSSHKeysResponse, SSHKey> context,
        ApiFuture<ListSSHKeysResponse> futureResponse) {
      ApiFuture<ListSSHKeysPage> futurePage =
          ListSSHKeysPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListSSHKeysPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListSSHKeysPagedResponse(ListSSHKeysPage page) {
      super(page, ListSSHKeysFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSSHKeysPage
      extends AbstractPage<ListSSHKeysRequest, ListSSHKeysResponse, SSHKey, ListSSHKeysPage> {

    private ListSSHKeysPage(
        PageContext<ListSSHKeysRequest, ListSSHKeysResponse, SSHKey> context,
        ListSSHKeysResponse response) {
      super(context, response);
    }

    private static ListSSHKeysPage createEmptyPage() {
      return new ListSSHKeysPage(null, null);
    }

    @Override
    protected ListSSHKeysPage createPage(
        PageContext<ListSSHKeysRequest, ListSSHKeysResponse, SSHKey> context,
        ListSSHKeysResponse response) {
      return new ListSSHKeysPage(context, response);
    }

    @Override
    public ApiFuture<ListSSHKeysPage> createPageAsync(
        PageContext<ListSSHKeysRequest, ListSSHKeysResponse, SSHKey> context,
        ApiFuture<ListSSHKeysResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSSHKeysFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSSHKeysRequest,
          ListSSHKeysResponse,
          SSHKey,
          ListSSHKeysPage,
          ListSSHKeysFixedSizeCollection> {

    private ListSSHKeysFixedSizeCollection(List<ListSSHKeysPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSSHKeysFixedSizeCollection createEmptyCollection() {
      return new ListSSHKeysFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSSHKeysFixedSizeCollection createCollection(
        List<ListSSHKeysPage> pages, int collectionSize) {
      return new ListSSHKeysFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListVolumesPagedResponse
      extends AbstractPagedListResponse<
          ListVolumesRequest,
          ListVolumesResponse,
          Volume,
          ListVolumesPage,
          ListVolumesFixedSizeCollection> {

    public static ApiFuture<ListVolumesPagedResponse> createAsync(
        PageContext<ListVolumesRequest, ListVolumesResponse, Volume> context,
        ApiFuture<ListVolumesResponse> futureResponse) {
      ApiFuture<ListVolumesPage> futurePage =
          ListVolumesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListVolumesPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListVolumesPagedResponse(ListVolumesPage page) {
      super(page, ListVolumesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListVolumesPage
      extends AbstractPage<ListVolumesRequest, ListVolumesResponse, Volume, ListVolumesPage> {

    private ListVolumesPage(
        PageContext<ListVolumesRequest, ListVolumesResponse, Volume> context,
        ListVolumesResponse response) {
      super(context, response);
    }

    private static ListVolumesPage createEmptyPage() {
      return new ListVolumesPage(null, null);
    }

    @Override
    protected ListVolumesPage createPage(
        PageContext<ListVolumesRequest, ListVolumesResponse, Volume> context,
        ListVolumesResponse response) {
      return new ListVolumesPage(context, response);
    }

    @Override
    public ApiFuture<ListVolumesPage> createPageAsync(
        PageContext<ListVolumesRequest, ListVolumesResponse, Volume> context,
        ApiFuture<ListVolumesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListVolumesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListVolumesRequest,
          ListVolumesResponse,
          Volume,
          ListVolumesPage,
          ListVolumesFixedSizeCollection> {

    private ListVolumesFixedSizeCollection(List<ListVolumesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListVolumesFixedSizeCollection createEmptyCollection() {
      return new ListVolumesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListVolumesFixedSizeCollection createCollection(
        List<ListVolumesPage> pages, int collectionSize) {
      return new ListVolumesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListNetworksPagedResponse
      extends AbstractPagedListResponse<
          ListNetworksRequest,
          ListNetworksResponse,
          Network,
          ListNetworksPage,
          ListNetworksFixedSizeCollection> {

    public static ApiFuture<ListNetworksPagedResponse> createAsync(
        PageContext<ListNetworksRequest, ListNetworksResponse, Network> context,
        ApiFuture<ListNetworksResponse> futureResponse) {
      ApiFuture<ListNetworksPage> futurePage =
          ListNetworksPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListNetworksPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListNetworksPagedResponse(ListNetworksPage page) {
      super(page, ListNetworksFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListNetworksPage
      extends AbstractPage<ListNetworksRequest, ListNetworksResponse, Network, ListNetworksPage> {

    private ListNetworksPage(
        PageContext<ListNetworksRequest, ListNetworksResponse, Network> context,
        ListNetworksResponse response) {
      super(context, response);
    }

    private static ListNetworksPage createEmptyPage() {
      return new ListNetworksPage(null, null);
    }

    @Override
    protected ListNetworksPage createPage(
        PageContext<ListNetworksRequest, ListNetworksResponse, Network> context,
        ListNetworksResponse response) {
      return new ListNetworksPage(context, response);
    }

    @Override
    public ApiFuture<ListNetworksPage> createPageAsync(
        PageContext<ListNetworksRequest, ListNetworksResponse, Network> context,
        ApiFuture<ListNetworksResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListNetworksFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListNetworksRequest,
          ListNetworksResponse,
          Network,
          ListNetworksPage,
          ListNetworksFixedSizeCollection> {

    private ListNetworksFixedSizeCollection(List<ListNetworksPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListNetworksFixedSizeCollection createEmptyCollection() {
      return new ListNetworksFixedSizeCollection(null, 0);
    }

    @Override
    protected ListNetworksFixedSizeCollection createCollection(
        List<ListNetworksPage> pages, int collectionSize) {
      return new ListNetworksFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListVolumeSnapshotsPagedResponse
      extends AbstractPagedListResponse<
          ListVolumeSnapshotsRequest,
          ListVolumeSnapshotsResponse,
          VolumeSnapshot,
          ListVolumeSnapshotsPage,
          ListVolumeSnapshotsFixedSizeCollection> {

    public static ApiFuture<ListVolumeSnapshotsPagedResponse> createAsync(
        PageContext<ListVolumeSnapshotsRequest, ListVolumeSnapshotsResponse, VolumeSnapshot>
            context,
        ApiFuture<ListVolumeSnapshotsResponse> futureResponse) {
      ApiFuture<ListVolumeSnapshotsPage> futurePage =
          ListVolumeSnapshotsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListVolumeSnapshotsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListVolumeSnapshotsPagedResponse(ListVolumeSnapshotsPage page) {
      super(page, ListVolumeSnapshotsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListVolumeSnapshotsPage
      extends AbstractPage<
          ListVolumeSnapshotsRequest,
          ListVolumeSnapshotsResponse,
          VolumeSnapshot,
          ListVolumeSnapshotsPage> {

    private ListVolumeSnapshotsPage(
        PageContext<ListVolumeSnapshotsRequest, ListVolumeSnapshotsResponse, VolumeSnapshot>
            context,
        ListVolumeSnapshotsResponse response) {
      super(context, response);
    }

    private static ListVolumeSnapshotsPage createEmptyPage() {
      return new ListVolumeSnapshotsPage(null, null);
    }

    @Override
    protected ListVolumeSnapshotsPage createPage(
        PageContext<ListVolumeSnapshotsRequest, ListVolumeSnapshotsResponse, VolumeSnapshot>
            context,
        ListVolumeSnapshotsResponse response) {
      return new ListVolumeSnapshotsPage(context, response);
    }

    @Override
    public ApiFuture<ListVolumeSnapshotsPage> createPageAsync(
        PageContext<ListVolumeSnapshotsRequest, ListVolumeSnapshotsResponse, VolumeSnapshot>
            context,
        ApiFuture<ListVolumeSnapshotsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListVolumeSnapshotsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListVolumeSnapshotsRequest,
          ListVolumeSnapshotsResponse,
          VolumeSnapshot,
          ListVolumeSnapshotsPage,
          ListVolumeSnapshotsFixedSizeCollection> {

    private ListVolumeSnapshotsFixedSizeCollection(
        List<ListVolumeSnapshotsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListVolumeSnapshotsFixedSizeCollection createEmptyCollection() {
      return new ListVolumeSnapshotsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListVolumeSnapshotsFixedSizeCollection createCollection(
        List<ListVolumeSnapshotsPage> pages, int collectionSize) {
      return new ListVolumeSnapshotsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListLunsPagedResponse
      extends AbstractPagedListResponse<
          ListLunsRequest, ListLunsResponse, Lun, ListLunsPage, ListLunsFixedSizeCollection> {

    public static ApiFuture<ListLunsPagedResponse> createAsync(
        PageContext<ListLunsRequest, ListLunsResponse, Lun> context,
        ApiFuture<ListLunsResponse> futureResponse) {
      ApiFuture<ListLunsPage> futurePage =
          ListLunsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListLunsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListLunsPagedResponse(ListLunsPage page) {
      super(page, ListLunsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListLunsPage
      extends AbstractPage<ListLunsRequest, ListLunsResponse, Lun, ListLunsPage> {

    private ListLunsPage(
        PageContext<ListLunsRequest, ListLunsResponse, Lun> context, ListLunsResponse response) {
      super(context, response);
    }

    private static ListLunsPage createEmptyPage() {
      return new ListLunsPage(null, null);
    }

    @Override
    protected ListLunsPage createPage(
        PageContext<ListLunsRequest, ListLunsResponse, Lun> context, ListLunsResponse response) {
      return new ListLunsPage(context, response);
    }

    @Override
    public ApiFuture<ListLunsPage> createPageAsync(
        PageContext<ListLunsRequest, ListLunsResponse, Lun> context,
        ApiFuture<ListLunsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLunsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLunsRequest, ListLunsResponse, Lun, ListLunsPage, ListLunsFixedSizeCollection> {

    private ListLunsFixedSizeCollection(List<ListLunsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLunsFixedSizeCollection createEmptyCollection() {
      return new ListLunsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLunsFixedSizeCollection createCollection(
        List<ListLunsPage> pages, int collectionSize) {
      return new ListLunsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListNfsSharesPagedResponse
      extends AbstractPagedListResponse<
          ListNfsSharesRequest,
          ListNfsSharesResponse,
          NfsShare,
          ListNfsSharesPage,
          ListNfsSharesFixedSizeCollection> {

    public static ApiFuture<ListNfsSharesPagedResponse> createAsync(
        PageContext<ListNfsSharesRequest, ListNfsSharesResponse, NfsShare> context,
        ApiFuture<ListNfsSharesResponse> futureResponse) {
      ApiFuture<ListNfsSharesPage> futurePage =
          ListNfsSharesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListNfsSharesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListNfsSharesPagedResponse(ListNfsSharesPage page) {
      super(page, ListNfsSharesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListNfsSharesPage
      extends AbstractPage<
          ListNfsSharesRequest, ListNfsSharesResponse, NfsShare, ListNfsSharesPage> {

    private ListNfsSharesPage(
        PageContext<ListNfsSharesRequest, ListNfsSharesResponse, NfsShare> context,
        ListNfsSharesResponse response) {
      super(context, response);
    }

    private static ListNfsSharesPage createEmptyPage() {
      return new ListNfsSharesPage(null, null);
    }

    @Override
    protected ListNfsSharesPage createPage(
        PageContext<ListNfsSharesRequest, ListNfsSharesResponse, NfsShare> context,
        ListNfsSharesResponse response) {
      return new ListNfsSharesPage(context, response);
    }

    @Override
    public ApiFuture<ListNfsSharesPage> createPageAsync(
        PageContext<ListNfsSharesRequest, ListNfsSharesResponse, NfsShare> context,
        ApiFuture<ListNfsSharesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListNfsSharesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListNfsSharesRequest,
          ListNfsSharesResponse,
          NfsShare,
          ListNfsSharesPage,
          ListNfsSharesFixedSizeCollection> {

    private ListNfsSharesFixedSizeCollection(List<ListNfsSharesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListNfsSharesFixedSizeCollection createEmptyCollection() {
      return new ListNfsSharesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListNfsSharesFixedSizeCollection createCollection(
        List<ListNfsSharesPage> pages, int collectionSize) {
      return new ListNfsSharesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListProvisioningQuotasPagedResponse
      extends AbstractPagedListResponse<
          ListProvisioningQuotasRequest,
          ListProvisioningQuotasResponse,
          ProvisioningQuota,
          ListProvisioningQuotasPage,
          ListProvisioningQuotasFixedSizeCollection> {

    public static ApiFuture<ListProvisioningQuotasPagedResponse> createAsync(
        PageContext<
                ListProvisioningQuotasRequest, ListProvisioningQuotasResponse, ProvisioningQuota>
            context,
        ApiFuture<ListProvisioningQuotasResponse> futureResponse) {
      ApiFuture<ListProvisioningQuotasPage> futurePage =
          ListProvisioningQuotasPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListProvisioningQuotasPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListProvisioningQuotasPagedResponse(ListProvisioningQuotasPage page) {
      super(page, ListProvisioningQuotasFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListProvisioningQuotasPage
      extends AbstractPage<
          ListProvisioningQuotasRequest,
          ListProvisioningQuotasResponse,
          ProvisioningQuota,
          ListProvisioningQuotasPage> {

    private ListProvisioningQuotasPage(
        PageContext<
                ListProvisioningQuotasRequest, ListProvisioningQuotasResponse, ProvisioningQuota>
            context,
        ListProvisioningQuotasResponse response) {
      super(context, response);
    }

    private static ListProvisioningQuotasPage createEmptyPage() {
      return new ListProvisioningQuotasPage(null, null);
    }

    @Override
    protected ListProvisioningQuotasPage createPage(
        PageContext<
                ListProvisioningQuotasRequest, ListProvisioningQuotasResponse, ProvisioningQuota>
            context,
        ListProvisioningQuotasResponse response) {
      return new ListProvisioningQuotasPage(context, response);
    }

    @Override
    public ApiFuture<ListProvisioningQuotasPage> createPageAsync(
        PageContext<
                ListProvisioningQuotasRequest, ListProvisioningQuotasResponse, ProvisioningQuota>
            context,
        ApiFuture<ListProvisioningQuotasResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListProvisioningQuotasFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListProvisioningQuotasRequest,
          ListProvisioningQuotasResponse,
          ProvisioningQuota,
          ListProvisioningQuotasPage,
          ListProvisioningQuotasFixedSizeCollection> {

    private ListProvisioningQuotasFixedSizeCollection(
        List<ListProvisioningQuotasPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListProvisioningQuotasFixedSizeCollection createEmptyCollection() {
      return new ListProvisioningQuotasFixedSizeCollection(null, 0);
    }

    @Override
    protected ListProvisioningQuotasFixedSizeCollection createCollection(
        List<ListProvisioningQuotasPage> pages, int collectionSize) {
      return new ListProvisioningQuotasFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListOSImagesPagedResponse
      extends AbstractPagedListResponse<
          ListOSImagesRequest,
          ListOSImagesResponse,
          OSImage,
          ListOSImagesPage,
          ListOSImagesFixedSizeCollection> {

    public static ApiFuture<ListOSImagesPagedResponse> createAsync(
        PageContext<ListOSImagesRequest, ListOSImagesResponse, OSImage> context,
        ApiFuture<ListOSImagesResponse> futureResponse) {
      ApiFuture<ListOSImagesPage> futurePage =
          ListOSImagesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListOSImagesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListOSImagesPagedResponse(ListOSImagesPage page) {
      super(page, ListOSImagesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListOSImagesPage
      extends AbstractPage<ListOSImagesRequest, ListOSImagesResponse, OSImage, ListOSImagesPage> {

    private ListOSImagesPage(
        PageContext<ListOSImagesRequest, ListOSImagesResponse, OSImage> context,
        ListOSImagesResponse response) {
      super(context, response);
    }

    private static ListOSImagesPage createEmptyPage() {
      return new ListOSImagesPage(null, null);
    }

    @Override
    protected ListOSImagesPage createPage(
        PageContext<ListOSImagesRequest, ListOSImagesResponse, OSImage> context,
        ListOSImagesResponse response) {
      return new ListOSImagesPage(context, response);
    }

    @Override
    public ApiFuture<ListOSImagesPage> createPageAsync(
        PageContext<ListOSImagesRequest, ListOSImagesResponse, OSImage> context,
        ApiFuture<ListOSImagesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListOSImagesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListOSImagesRequest,
          ListOSImagesResponse,
          OSImage,
          ListOSImagesPage,
          ListOSImagesFixedSizeCollection> {

    private ListOSImagesFixedSizeCollection(List<ListOSImagesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListOSImagesFixedSizeCollection createEmptyCollection() {
      return new ListOSImagesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListOSImagesFixedSizeCollection createCollection(
        List<ListOSImagesPage> pages, int collectionSize) {
      return new ListOSImagesFixedSizeCollection(pages, collectionSize);
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
