/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.netapp.v1;

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
import com.google.cloud.netapp.v1.stub.NetAppStub;
import com.google.cloud.netapp.v1.stub.NetAppStubSettings;
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
 * Service Description: NetApp Files Google Cloud Service
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
 * try (NetAppClient netAppClient = NetAppClient.create()) {
 *   StoragePoolName name = StoragePoolName.of("[PROJECT]", "[LOCATION]", "[STORAGE_POOL]");
 *   StoragePool response = netAppClient.getStoragePool(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the NetAppClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    <tr>
 *      <td>ListStoragePools</td>
 *      <td><p>Returns descriptions of all storage pools owned by the caller.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>listStoragePools(ListStoragePoolsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>listStoragePools(LocationName parent)
 *           <li>listStoragePools(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>listStoragePoolsPagedCallable()
 *           <li>listStoragePoolsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>CreateStoragePool</td>
 *      <td><p>Creates a new storage pool.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>createStoragePoolAsync(CreateStoragePoolRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>createStoragePoolAsync(LocationName parent, StoragePool storagePool, String storagePoolId)
 *           <li>createStoragePoolAsync(String parent, StoragePool storagePool, String storagePoolId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>createStoragePoolOperationCallable()
 *           <li>createStoragePoolCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>GetStoragePool</td>
 *      <td><p>Returns the description of the specified storage pool by poolId.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>getStoragePool(GetStoragePoolRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>getStoragePool(StoragePoolName name)
 *           <li>getStoragePool(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>getStoragePoolCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>UpdateStoragePool</td>
 *      <td><p>Updates the storage pool properties with the full spec</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>updateStoragePoolAsync(UpdateStoragePoolRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>updateStoragePoolAsync(StoragePool storagePool, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>updateStoragePoolOperationCallable()
 *           <li>updateStoragePoolCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>DeleteStoragePool</td>
 *      <td><p>Warning! This operation will permanently delete the storage pool.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>deleteStoragePoolAsync(DeleteStoragePoolRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>deleteStoragePoolAsync(StoragePoolName name)
 *           <li>deleteStoragePoolAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>deleteStoragePoolOperationCallable()
 *           <li>deleteStoragePoolCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>ListVolumes</td>
 *      <td><p>Lists Volumes in a given project.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>listVolumes(ListVolumesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>listVolumes(LocationName parent)
 *           <li>listVolumes(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>listVolumesPagedCallable()
 *           <li>listVolumesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>GetVolume</td>
 *      <td><p>Gets details of a single Volume.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>getVolume(GetVolumeRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>getVolume(VolumeName name)
 *           <li>getVolume(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>getVolumeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>CreateVolume</td>
 *      <td><p>Creates a new Volume in a given project and location.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>createVolumeAsync(CreateVolumeRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>createVolumeAsync(LocationName parent, Volume volume, String volumeId)
 *           <li>createVolumeAsync(String parent, Volume volume, String volumeId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>createVolumeOperationCallable()
 *           <li>createVolumeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>UpdateVolume</td>
 *      <td><p>Updates the parameters of a single Volume.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>updateVolumeAsync(UpdateVolumeRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>updateVolumeAsync(Volume volume, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>updateVolumeOperationCallable()
 *           <li>updateVolumeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>DeleteVolume</td>
 *      <td><p>Deletes a single Volume.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>deleteVolumeAsync(DeleteVolumeRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>deleteVolumeAsync(VolumeName name)
 *           <li>deleteVolumeAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>deleteVolumeOperationCallable()
 *           <li>deleteVolumeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>RevertVolume</td>
 *      <td><p>Revert an existing volume to a specified snapshot.
 *  Warning! This operation will permanently revert all changes made after the
 *  snapshot was created.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>revertVolumeAsync(RevertVolumeRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>revertVolumeOperationCallable()
 *           <li>revertVolumeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>ListSnapshots</td>
 *      <td><p>Returns descriptions of all snapshots for a volume.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>listSnapshots(ListSnapshotsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>listSnapshots(VolumeName parent)
 *           <li>listSnapshots(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>listSnapshotsPagedCallable()
 *           <li>listSnapshotsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>GetSnapshot</td>
 *      <td><p>Describe a snapshot for a volume.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>getSnapshot(GetSnapshotRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>getSnapshot(SnapshotName name)
 *           <li>getSnapshot(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>getSnapshotCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>CreateSnapshot</td>
 *      <td><p>Create a new snapshot for a volume.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>createSnapshotAsync(CreateSnapshotRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>createSnapshotAsync(VolumeName parent, Snapshot snapshot, String snapshotId)
 *           <li>createSnapshotAsync(String parent, Snapshot snapshot, String snapshotId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>createSnapshotOperationCallable()
 *           <li>createSnapshotCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>DeleteSnapshot</td>
 *      <td><p>Deletes a snapshot.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>deleteSnapshotAsync(DeleteSnapshotRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>deleteSnapshotAsync(SnapshotName name)
 *           <li>deleteSnapshotAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>deleteSnapshotOperationCallable()
 *           <li>deleteSnapshotCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>UpdateSnapshot</td>
 *      <td><p>Updates the settings of a specific snapshot.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>updateSnapshotAsync(UpdateSnapshotRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>updateSnapshotAsync(Snapshot snapshot, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>updateSnapshotOperationCallable()
 *           <li>updateSnapshotCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>ListActiveDirectories</td>
 *      <td><p>Lists active directories.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>listActiveDirectories(ListActiveDirectoriesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>listActiveDirectories(LocationName parent)
 *           <li>listActiveDirectories(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>listActiveDirectoriesPagedCallable()
 *           <li>listActiveDirectoriesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>GetActiveDirectory</td>
 *      <td><p>Describes a specified active directory.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>getActiveDirectory(GetActiveDirectoryRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>getActiveDirectory(ActiveDirectoryName name)
 *           <li>getActiveDirectory(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>getActiveDirectoryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>CreateActiveDirectory</td>
 *      <td><p>CreateActiveDirectory
 *  Creates the active directory specified in the request.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>createActiveDirectoryAsync(CreateActiveDirectoryRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>createActiveDirectoryAsync(LocationName parent, ActiveDirectory activeDirectory, String activeDirectoryId)
 *           <li>createActiveDirectoryAsync(String parent, ActiveDirectory activeDirectory, String activeDirectoryId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>createActiveDirectoryOperationCallable()
 *           <li>createActiveDirectoryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>UpdateActiveDirectory</td>
 *      <td><p>Update the parameters of an active directories.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>updateActiveDirectoryAsync(UpdateActiveDirectoryRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>updateActiveDirectoryAsync(ActiveDirectory activeDirectory, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>updateActiveDirectoryOperationCallable()
 *           <li>updateActiveDirectoryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>DeleteActiveDirectory</td>
 *      <td><p>Delete the active directory specified in the request.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>deleteActiveDirectoryAsync(DeleteActiveDirectoryRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>deleteActiveDirectoryAsync(ActiveDirectoryName name)
 *           <li>deleteActiveDirectoryAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>deleteActiveDirectoryOperationCallable()
 *           <li>deleteActiveDirectoryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>ListKmsConfigs</td>
 *      <td><p>Returns descriptions of all KMS configs owned by the caller.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>listKmsConfigs(ListKmsConfigsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>listKmsConfigs(LocationName parent)
 *           <li>listKmsConfigs(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>listKmsConfigsPagedCallable()
 *           <li>listKmsConfigsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>CreateKmsConfig</td>
 *      <td><p>Creates a new KMS config.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>createKmsConfigAsync(CreateKmsConfigRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>createKmsConfigAsync(LocationName parent, KmsConfig kmsConfig, String kmsConfigId)
 *           <li>createKmsConfigAsync(String parent, KmsConfig kmsConfig, String kmsConfigId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>createKmsConfigOperationCallable()
 *           <li>createKmsConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>GetKmsConfig</td>
 *      <td><p>Returns the description of the specified KMS config by kms_config_id.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>getKmsConfig(GetKmsConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>getKmsConfig(KmsConfigName name)
 *           <li>getKmsConfig(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>getKmsConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>UpdateKmsConfig</td>
 *      <td><p>Updates the Kms config properties with the full spec</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>updateKmsConfigAsync(UpdateKmsConfigRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>updateKmsConfigAsync(KmsConfig kmsConfig, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>updateKmsConfigOperationCallable()
 *           <li>updateKmsConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>EncryptVolumes</td>
 *      <td><p>Encrypt the existing volumes without CMEK encryption with the desired the
 *  KMS config for the whole region.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>encryptVolumesAsync(EncryptVolumesRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>encryptVolumesOperationCallable()
 *           <li>encryptVolumesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>VerifyKmsConfig</td>
 *      <td><p>Verifies KMS config reachability.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>verifyKmsConfig(VerifyKmsConfigRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>verifyKmsConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>DeleteKmsConfig</td>
 *      <td><p>Warning! This operation will permanently delete the Kms config.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>deleteKmsConfigAsync(DeleteKmsConfigRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>deleteKmsConfigAsync(KmsConfigName name)
 *           <li>deleteKmsConfigAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>deleteKmsConfigOperationCallable()
 *           <li>deleteKmsConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>ListReplications</td>
 *      <td><p>Returns descriptions of all replications for a volume.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>listReplications(ListReplicationsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>listReplications(VolumeName parent)
 *           <li>listReplications(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>listReplicationsPagedCallable()
 *           <li>listReplicationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>GetReplication</td>
 *      <td><p>Describe a replication for a volume.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>getReplication(GetReplicationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>getReplication(ReplicationName name)
 *           <li>getReplication(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>getReplicationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>CreateReplication</td>
 *      <td><p>Create a new replication for a volume.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>createReplicationAsync(CreateReplicationRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>createReplicationAsync(VolumeName parent, Replication replication, String replicationId)
 *           <li>createReplicationAsync(String parent, Replication replication, String replicationId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>createReplicationOperationCallable()
 *           <li>createReplicationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>DeleteReplication</td>
 *      <td><p>Deletes a replication.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>deleteReplicationAsync(DeleteReplicationRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>deleteReplicationAsync(ReplicationName name)
 *           <li>deleteReplicationAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>deleteReplicationOperationCallable()
 *           <li>deleteReplicationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>UpdateReplication</td>
 *      <td><p>Updates the settings of a specific replication.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>updateReplicationAsync(UpdateReplicationRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>updateReplicationAsync(Replication replication, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>updateReplicationOperationCallable()
 *           <li>updateReplicationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>StopReplication</td>
 *      <td><p>Stop Cross Region Replication.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>stopReplicationAsync(StopReplicationRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>stopReplicationOperationCallable()
 *           <li>stopReplicationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>ResumeReplication</td>
 *      <td><p>Resume Cross Region Replication.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>resumeReplicationAsync(ResumeReplicationRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>resumeReplicationOperationCallable()
 *           <li>resumeReplicationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>ReverseReplicationDirection</td>
 *      <td><p>Reverses direction of replication. Source becomes destination and
 *  destination becomes source.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>reverseReplicationDirectionAsync(ReverseReplicationDirectionRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>reverseReplicationDirectionOperationCallable()
 *           <li>reverseReplicationDirectionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>ListLocations</td>
 *      <td><p>Lists information about the supported locations for this service.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>listLocations(ListLocationsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>listLocationsPagedCallable()
 *           <li>listLocationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>GetLocation</td>
 *      <td><p>Gets information about a location.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>getLocation(GetLocationRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>getLocationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    </tr>
 *  </table>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of NetAppSettings to create().
 * For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * NetAppSettings netAppSettings =
 *     NetAppSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * NetAppClient netAppClient = NetAppClient.create(netAppSettings);
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
 * NetAppSettings netAppSettings = NetAppSettings.newBuilder().setEndpoint(myEndpoint).build();
 * NetAppClient netAppClient = NetAppClient.create(netAppSettings);
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
 * NetAppSettings netAppSettings = NetAppSettings.newHttpJsonBuilder().build();
 * NetAppClient netAppClient = NetAppClient.create(netAppSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class NetAppClient implements BackgroundResource {
  private final NetAppSettings settings;
  private final NetAppStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of NetAppClient with default settings. */
  public static final NetAppClient create() throws IOException {
    return create(NetAppSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of NetAppClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final NetAppClient create(NetAppSettings settings) throws IOException {
    return new NetAppClient(settings);
  }

  /**
   * Constructs an instance of NetAppClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(NetAppSettings).
   */
  public static final NetAppClient create(NetAppStub stub) {
    return new NetAppClient(stub);
  }

  /**
   * Constructs an instance of NetAppClient, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected NetAppClient(NetAppSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((NetAppStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected NetAppClient(NetAppStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final NetAppSettings getSettings() {
    return settings;
  }

  public NetAppStub getStub() {
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
   * Returns descriptions of all storage pools owned by the caller.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (StoragePool element : netAppClient.listStoragePools(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListStoragePoolsPagedResponse listStoragePools(LocationName parent) {
    ListStoragePoolsRequest request =
        ListStoragePoolsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listStoragePools(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns descriptions of all storage pools owned by the caller.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (StoragePool element : netAppClient.listStoragePools(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListStoragePoolsPagedResponse listStoragePools(String parent) {
    ListStoragePoolsRequest request =
        ListStoragePoolsRequest.newBuilder().setParent(parent).build();
    return listStoragePools(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns descriptions of all storage pools owned by the caller.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   ListStoragePoolsRequest request =
   *       ListStoragePoolsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (StoragePool element : netAppClient.listStoragePools(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListStoragePoolsPagedResponse listStoragePools(ListStoragePoolsRequest request) {
    return listStoragePoolsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns descriptions of all storage pools owned by the caller.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   ListStoragePoolsRequest request =
   *       ListStoragePoolsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<StoragePool> future =
   *       netAppClient.listStoragePoolsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (StoragePool element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListStoragePoolsRequest, ListStoragePoolsPagedResponse>
      listStoragePoolsPagedCallable() {
    return stub.listStoragePoolsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns descriptions of all storage pools owned by the caller.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   ListStoragePoolsRequest request =
   *       ListStoragePoolsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListStoragePoolsResponse response = netAppClient.listStoragePoolsCallable().call(request);
   *     for (StoragePool element : response.getStoragePoolsList()) {
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
  public final UnaryCallable<ListStoragePoolsRequest, ListStoragePoolsResponse>
      listStoragePoolsCallable() {
    return stub.listStoragePoolsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new storage pool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   StoragePool storagePool = StoragePool.newBuilder().build();
   *   String storagePoolId = "storagePoolId1617506482";
   *   StoragePool response =
   *       netAppClient.createStoragePoolAsync(parent, storagePool, storagePoolId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param storagePool Required. The required parameters to create a new storage pool.
   * @param storagePoolId Required. Id of the requesting storage pool If auto-generating Id
   *     server-side, remove this field and id from the method_signature of Create RPC
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<StoragePool, OperationMetadata> createStoragePoolAsync(
      LocationName parent, StoragePool storagePool, String storagePoolId) {
    CreateStoragePoolRequest request =
        CreateStoragePoolRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setStoragePool(storagePool)
            .setStoragePoolId(storagePoolId)
            .build();
    return createStoragePoolAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new storage pool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   StoragePool storagePool = StoragePool.newBuilder().build();
   *   String storagePoolId = "storagePoolId1617506482";
   *   StoragePool response =
   *       netAppClient.createStoragePoolAsync(parent, storagePool, storagePoolId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param storagePool Required. The required parameters to create a new storage pool.
   * @param storagePoolId Required. Id of the requesting storage pool If auto-generating Id
   *     server-side, remove this field and id from the method_signature of Create RPC
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<StoragePool, OperationMetadata> createStoragePoolAsync(
      String parent, StoragePool storagePool, String storagePoolId) {
    CreateStoragePoolRequest request =
        CreateStoragePoolRequest.newBuilder()
            .setParent(parent)
            .setStoragePool(storagePool)
            .setStoragePoolId(storagePoolId)
            .build();
    return createStoragePoolAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new storage pool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   CreateStoragePoolRequest request =
   *       CreateStoragePoolRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setStoragePoolId("storagePoolId1617506482")
   *           .setStoragePool(StoragePool.newBuilder().build())
   *           .build();
   *   StoragePool response = netAppClient.createStoragePoolAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<StoragePool, OperationMetadata> createStoragePoolAsync(
      CreateStoragePoolRequest request) {
    return createStoragePoolOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new storage pool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   CreateStoragePoolRequest request =
   *       CreateStoragePoolRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setStoragePoolId("storagePoolId1617506482")
   *           .setStoragePool(StoragePool.newBuilder().build())
   *           .build();
   *   OperationFuture<StoragePool, OperationMetadata> future =
   *       netAppClient.createStoragePoolOperationCallable().futureCall(request);
   *   // Do something.
   *   StoragePool response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateStoragePoolRequest, StoragePool, OperationMetadata>
      createStoragePoolOperationCallable() {
    return stub.createStoragePoolOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new storage pool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   CreateStoragePoolRequest request =
   *       CreateStoragePoolRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setStoragePoolId("storagePoolId1617506482")
   *           .setStoragePool(StoragePool.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = netAppClient.createStoragePoolCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateStoragePoolRequest, Operation> createStoragePoolCallable() {
    return stub.createStoragePoolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the description of the specified storage pool by poolId.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   StoragePoolName name = StoragePoolName.of("[PROJECT]", "[LOCATION]", "[STORAGE_POOL]");
   *   StoragePool response = netAppClient.getStoragePool(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the storage pool
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final StoragePool getStoragePool(StoragePoolName name) {
    GetStoragePoolRequest request =
        GetStoragePoolRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getStoragePool(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the description of the specified storage pool by poolId.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   String name = StoragePoolName.of("[PROJECT]", "[LOCATION]", "[STORAGE_POOL]").toString();
   *   StoragePool response = netAppClient.getStoragePool(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the storage pool
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final StoragePool getStoragePool(String name) {
    GetStoragePoolRequest request = GetStoragePoolRequest.newBuilder().setName(name).build();
    return getStoragePool(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the description of the specified storage pool by poolId.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   GetStoragePoolRequest request =
   *       GetStoragePoolRequest.newBuilder()
   *           .setName(StoragePoolName.of("[PROJECT]", "[LOCATION]", "[STORAGE_POOL]").toString())
   *           .build();
   *   StoragePool response = netAppClient.getStoragePool(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final StoragePool getStoragePool(GetStoragePoolRequest request) {
    return getStoragePoolCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the description of the specified storage pool by poolId.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   GetStoragePoolRequest request =
   *       GetStoragePoolRequest.newBuilder()
   *           .setName(StoragePoolName.of("[PROJECT]", "[LOCATION]", "[STORAGE_POOL]").toString())
   *           .build();
   *   ApiFuture<StoragePool> future = netAppClient.getStoragePoolCallable().futureCall(request);
   *   // Do something.
   *   StoragePool response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetStoragePoolRequest, StoragePool> getStoragePoolCallable() {
    return stub.getStoragePoolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the storage pool properties with the full spec
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   StoragePool storagePool = StoragePool.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   StoragePool response = netAppClient.updateStoragePoolAsync(storagePool, updateMask).get();
   * }
   * }</pre>
   *
   * @param storagePool Required. The pool being updated
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     StoragePool resource by the update. The fields specified in the update_mask are relative to
   *     the resource, not the full request. A field will be overwritten if it is in the mask. If
   *     the user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<StoragePool, OperationMetadata> updateStoragePoolAsync(
      StoragePool storagePool, FieldMask updateMask) {
    UpdateStoragePoolRequest request =
        UpdateStoragePoolRequest.newBuilder()
            .setStoragePool(storagePool)
            .setUpdateMask(updateMask)
            .build();
    return updateStoragePoolAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the storage pool properties with the full spec
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   UpdateStoragePoolRequest request =
   *       UpdateStoragePoolRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setStoragePool(StoragePool.newBuilder().build())
   *           .build();
   *   StoragePool response = netAppClient.updateStoragePoolAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<StoragePool, OperationMetadata> updateStoragePoolAsync(
      UpdateStoragePoolRequest request) {
    return updateStoragePoolOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the storage pool properties with the full spec
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   UpdateStoragePoolRequest request =
   *       UpdateStoragePoolRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setStoragePool(StoragePool.newBuilder().build())
   *           .build();
   *   OperationFuture<StoragePool, OperationMetadata> future =
   *       netAppClient.updateStoragePoolOperationCallable().futureCall(request);
   *   // Do something.
   *   StoragePool response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateStoragePoolRequest, StoragePool, OperationMetadata>
      updateStoragePoolOperationCallable() {
    return stub.updateStoragePoolOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the storage pool properties with the full spec
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   UpdateStoragePoolRequest request =
   *       UpdateStoragePoolRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setStoragePool(StoragePool.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = netAppClient.updateStoragePoolCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateStoragePoolRequest, Operation> updateStoragePoolCallable() {
    return stub.updateStoragePoolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Warning! This operation will permanently delete the storage pool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   StoragePoolName name = StoragePoolName.of("[PROJECT]", "[LOCATION]", "[STORAGE_POOL]");
   *   netAppClient.deleteStoragePoolAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the storage pool
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteStoragePoolAsync(
      StoragePoolName name) {
    DeleteStoragePoolRequest request =
        DeleteStoragePoolRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteStoragePoolAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Warning! This operation will permanently delete the storage pool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   String name = StoragePoolName.of("[PROJECT]", "[LOCATION]", "[STORAGE_POOL]").toString();
   *   netAppClient.deleteStoragePoolAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the storage pool
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteStoragePoolAsync(String name) {
    DeleteStoragePoolRequest request = DeleteStoragePoolRequest.newBuilder().setName(name).build();
    return deleteStoragePoolAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Warning! This operation will permanently delete the storage pool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   DeleteStoragePoolRequest request =
   *       DeleteStoragePoolRequest.newBuilder()
   *           .setName(StoragePoolName.of("[PROJECT]", "[LOCATION]", "[STORAGE_POOL]").toString())
   *           .build();
   *   netAppClient.deleteStoragePoolAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteStoragePoolAsync(
      DeleteStoragePoolRequest request) {
    return deleteStoragePoolOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Warning! This operation will permanently delete the storage pool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   DeleteStoragePoolRequest request =
   *       DeleteStoragePoolRequest.newBuilder()
   *           .setName(StoragePoolName.of("[PROJECT]", "[LOCATION]", "[STORAGE_POOL]").toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       netAppClient.deleteStoragePoolOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteStoragePoolRequest, Empty, OperationMetadata>
      deleteStoragePoolOperationCallable() {
    return stub.deleteStoragePoolOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Warning! This operation will permanently delete the storage pool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   DeleteStoragePoolRequest request =
   *       DeleteStoragePoolRequest.newBuilder()
   *           .setName(StoragePoolName.of("[PROJECT]", "[LOCATION]", "[STORAGE_POOL]").toString())
   *           .build();
   *   ApiFuture<Operation> future = netAppClient.deleteStoragePoolCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteStoragePoolRequest, Operation> deleteStoragePoolCallable() {
    return stub.deleteStoragePoolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Volumes in a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Volume element : netAppClient.listVolumes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListVolumesRequest
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
   * Lists Volumes in a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Volume element : netAppClient.listVolumes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListVolumesRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVolumesPagedResponse listVolumes(String parent) {
    ListVolumesRequest request = ListVolumesRequest.newBuilder().setParent(parent).build();
    return listVolumes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Volumes in a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   ListVolumesRequest request =
   *       ListVolumesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Volume element : netAppClient.listVolumes(request).iterateAll()) {
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
   * Lists Volumes in a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   ListVolumesRequest request =
   *       ListVolumesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Volume> future = netAppClient.listVolumesPagedCallable().futureCall(request);
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
   * Lists Volumes in a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   ListVolumesRequest request =
   *       ListVolumesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListVolumesResponse response = netAppClient.listVolumesCallable().call(request);
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
   * Gets details of a single Volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   VolumeName name = VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]");
   *   Volume response = netAppClient.getVolume(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the volume
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Volume getVolume(VolumeName name) {
    GetVolumeRequest request =
        GetVolumeRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getVolume(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   String name = VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString();
   *   Volume response = netAppClient.getVolume(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the volume
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Volume getVolume(String name) {
    GetVolumeRequest request = GetVolumeRequest.newBuilder().setName(name).build();
    return getVolume(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   GetVolumeRequest request =
   *       GetVolumeRequest.newBuilder()
   *           .setName(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
   *           .build();
   *   Volume response = netAppClient.getVolume(request);
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
   * Gets details of a single Volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   GetVolumeRequest request =
   *       GetVolumeRequest.newBuilder()
   *           .setName(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
   *           .build();
   *   ApiFuture<Volume> future = netAppClient.getVolumeCallable().futureCall(request);
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
   * Creates a new Volume in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Volume volume = Volume.newBuilder().build();
   *   String volumeId = "volumeId-1869770283";
   *   Volume response = netAppClient.createVolumeAsync(parent, volume, volumeId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param volume Required. The volume being created.
   * @param volumeId Required. Id of the requesting volume If auto-generating Id server-side, remove
   *     this field and Id from the method_signature of Create RPC
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Volume, OperationMetadata> createVolumeAsync(
      LocationName parent, Volume volume, String volumeId) {
    CreateVolumeRequest request =
        CreateVolumeRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setVolume(volume)
            .setVolumeId(volumeId)
            .build();
    return createVolumeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Volume in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Volume volume = Volume.newBuilder().build();
   *   String volumeId = "volumeId-1869770283";
   *   Volume response = netAppClient.createVolumeAsync(parent, volume, volumeId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param volume Required. The volume being created.
   * @param volumeId Required. Id of the requesting volume If auto-generating Id server-side, remove
   *     this field and Id from the method_signature of Create RPC
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Volume, OperationMetadata> createVolumeAsync(
      String parent, Volume volume, String volumeId) {
    CreateVolumeRequest request =
        CreateVolumeRequest.newBuilder()
            .setParent(parent)
            .setVolume(volume)
            .setVolumeId(volumeId)
            .build();
    return createVolumeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Volume in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   CreateVolumeRequest request =
   *       CreateVolumeRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setVolumeId("volumeId-1869770283")
   *           .setVolume(Volume.newBuilder().build())
   *           .build();
   *   Volume response = netAppClient.createVolumeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Volume, OperationMetadata> createVolumeAsync(
      CreateVolumeRequest request) {
    return createVolumeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Volume in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   CreateVolumeRequest request =
   *       CreateVolumeRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setVolumeId("volumeId-1869770283")
   *           .setVolume(Volume.newBuilder().build())
   *           .build();
   *   OperationFuture<Volume, OperationMetadata> future =
   *       netAppClient.createVolumeOperationCallable().futureCall(request);
   *   // Do something.
   *   Volume response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateVolumeRequest, Volume, OperationMetadata>
      createVolumeOperationCallable() {
    return stub.createVolumeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Volume in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   CreateVolumeRequest request =
   *       CreateVolumeRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setVolumeId("volumeId-1869770283")
   *           .setVolume(Volume.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = netAppClient.createVolumeCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateVolumeRequest, Operation> createVolumeCallable() {
    return stub.createVolumeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   Volume volume = Volume.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Volume response = netAppClient.updateVolumeAsync(volume, updateMask).get();
   * }
   * }</pre>
   *
   * @param volume Required. The volume being updated
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     Volume resource by the update. The fields specified in the update_mask are relative to the
   *     resource, not the full request. A field will be overwritten if it is in the mask. If the
   *     user does not provide a mask then all fields will be overwritten.
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
   * Updates the parameters of a single Volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   UpdateVolumeRequest request =
   *       UpdateVolumeRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setVolume(Volume.newBuilder().build())
   *           .build();
   *   Volume response = netAppClient.updateVolumeAsync(request).get();
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
   * Updates the parameters of a single Volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   UpdateVolumeRequest request =
   *       UpdateVolumeRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setVolume(Volume.newBuilder().build())
   *           .build();
   *   OperationFuture<Volume, OperationMetadata> future =
   *       netAppClient.updateVolumeOperationCallable().futureCall(request);
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
   * Updates the parameters of a single Volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   UpdateVolumeRequest request =
   *       UpdateVolumeRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setVolume(Volume.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = netAppClient.updateVolumeCallable().futureCall(request);
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
   * Deletes a single Volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   VolumeName name = VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]");
   *   netAppClient.deleteVolumeAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the volume
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteVolumeAsync(VolumeName name) {
    DeleteVolumeRequest request =
        DeleteVolumeRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteVolumeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   String name = VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString();
   *   netAppClient.deleteVolumeAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the volume
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteVolumeAsync(String name) {
    DeleteVolumeRequest request = DeleteVolumeRequest.newBuilder().setName(name).build();
    return deleteVolumeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   DeleteVolumeRequest request =
   *       DeleteVolumeRequest.newBuilder()
   *           .setName(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
   *           .setForce(true)
   *           .build();
   *   netAppClient.deleteVolumeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteVolumeAsync(
      DeleteVolumeRequest request) {
    return deleteVolumeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   DeleteVolumeRequest request =
   *       DeleteVolumeRequest.newBuilder()
   *           .setName(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
   *           .setForce(true)
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       netAppClient.deleteVolumeOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteVolumeRequest, Empty, OperationMetadata>
      deleteVolumeOperationCallable() {
    return stub.deleteVolumeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   DeleteVolumeRequest request =
   *       DeleteVolumeRequest.newBuilder()
   *           .setName(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Operation> future = netAppClient.deleteVolumeCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteVolumeRequest, Operation> deleteVolumeCallable() {
    return stub.deleteVolumeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Revert an existing volume to a specified snapshot. Warning! This operation will permanently
   * revert all changes made after the snapshot was created.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   RevertVolumeRequest request =
   *       RevertVolumeRequest.newBuilder()
   *           .setName(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
   *           .setSnapshotId("snapshotId-1113817601")
   *           .build();
   *   Volume response = netAppClient.revertVolumeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Volume, OperationMetadata> revertVolumeAsync(
      RevertVolumeRequest request) {
    return revertVolumeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Revert an existing volume to a specified snapshot. Warning! This operation will permanently
   * revert all changes made after the snapshot was created.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   RevertVolumeRequest request =
   *       RevertVolumeRequest.newBuilder()
   *           .setName(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
   *           .setSnapshotId("snapshotId-1113817601")
   *           .build();
   *   OperationFuture<Volume, OperationMetadata> future =
   *       netAppClient.revertVolumeOperationCallable().futureCall(request);
   *   // Do something.
   *   Volume response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<RevertVolumeRequest, Volume, OperationMetadata>
      revertVolumeOperationCallable() {
    return stub.revertVolumeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Revert an existing volume to a specified snapshot. Warning! This operation will permanently
   * revert all changes made after the snapshot was created.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   RevertVolumeRequest request =
   *       RevertVolumeRequest.newBuilder()
   *           .setName(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
   *           .setSnapshotId("snapshotId-1113817601")
   *           .build();
   *   ApiFuture<Operation> future = netAppClient.revertVolumeCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RevertVolumeRequest, Operation> revertVolumeCallable() {
    return stub.revertVolumeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns descriptions of all snapshots for a volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   VolumeName parent = VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]");
   *   for (Snapshot element : netAppClient.listSnapshots(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The volume for which to retrieve snapshot information, in the format
   *     `projects/{project_id}/locations/{location}/volumes/{volume_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSnapshotsPagedResponse listSnapshots(VolumeName parent) {
    ListSnapshotsRequest request =
        ListSnapshotsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listSnapshots(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns descriptions of all snapshots for a volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   String parent = VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString();
   *   for (Snapshot element : netAppClient.listSnapshots(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The volume for which to retrieve snapshot information, in the format
   *     `projects/{project_id}/locations/{location}/volumes/{volume_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSnapshotsPagedResponse listSnapshots(String parent) {
    ListSnapshotsRequest request = ListSnapshotsRequest.newBuilder().setParent(parent).build();
    return listSnapshots(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns descriptions of all snapshots for a volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   ListSnapshotsRequest request =
   *       ListSnapshotsRequest.newBuilder()
   *           .setParent(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (Snapshot element : netAppClient.listSnapshots(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSnapshotsPagedResponse listSnapshots(ListSnapshotsRequest request) {
    return listSnapshotsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns descriptions of all snapshots for a volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   ListSnapshotsRequest request =
   *       ListSnapshotsRequest.newBuilder()
   *           .setParent(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<Snapshot> future = netAppClient.listSnapshotsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Snapshot element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSnapshotsRequest, ListSnapshotsPagedResponse>
      listSnapshotsPagedCallable() {
    return stub.listSnapshotsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns descriptions of all snapshots for a volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   ListSnapshotsRequest request =
   *       ListSnapshotsRequest.newBuilder()
   *           .setParent(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListSnapshotsResponse response = netAppClient.listSnapshotsCallable().call(request);
   *     for (Snapshot element : response.getSnapshotsList()) {
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
  public final UnaryCallable<ListSnapshotsRequest, ListSnapshotsResponse> listSnapshotsCallable() {
    return stub.listSnapshotsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Describe a snapshot for a volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   SnapshotName name = SnapshotName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[SNAPSHOT]");
   *   Snapshot response = netAppClient.getSnapshot(name);
   * }
   * }</pre>
   *
   * @param name Required. The snapshot resource name, in the format
   *     `projects/{project_id}/locations/{location}/volumes/{volume_id}/snapshots/{snapshot_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Snapshot getSnapshot(SnapshotName name) {
    GetSnapshotRequest request =
        GetSnapshotRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getSnapshot(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Describe a snapshot for a volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   String name = SnapshotName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[SNAPSHOT]").toString();
   *   Snapshot response = netAppClient.getSnapshot(name);
   * }
   * }</pre>
   *
   * @param name Required. The snapshot resource name, in the format
   *     `projects/{project_id}/locations/{location}/volumes/{volume_id}/snapshots/{snapshot_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Snapshot getSnapshot(String name) {
    GetSnapshotRequest request = GetSnapshotRequest.newBuilder().setName(name).build();
    return getSnapshot(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Describe a snapshot for a volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   GetSnapshotRequest request =
   *       GetSnapshotRequest.newBuilder()
   *           .setName(
   *               SnapshotName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[SNAPSHOT]").toString())
   *           .build();
   *   Snapshot response = netAppClient.getSnapshot(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Snapshot getSnapshot(GetSnapshotRequest request) {
    return getSnapshotCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Describe a snapshot for a volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   GetSnapshotRequest request =
   *       GetSnapshotRequest.newBuilder()
   *           .setName(
   *               SnapshotName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[SNAPSHOT]").toString())
   *           .build();
   *   ApiFuture<Snapshot> future = netAppClient.getSnapshotCallable().futureCall(request);
   *   // Do something.
   *   Snapshot response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSnapshotRequest, Snapshot> getSnapshotCallable() {
    return stub.getSnapshotCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new snapshot for a volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   VolumeName parent = VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]");
   *   Snapshot snapshot = Snapshot.newBuilder().build();
   *   String snapshotId = "snapshotId-1113817601";
   *   Snapshot response = netAppClient.createSnapshotAsync(parent, snapshot, snapshotId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The NetApp volume to create the snapshots of, in the format
   *     `projects/{project_id}/locations/{location}/volumes/{volume_id}`
   * @param snapshot Required. A snapshot resource
   * @param snapshotId Required. ID of the snapshot to create. This value must start with a
   *     lowercase letter followed by up to 62 lowercase letters, numbers, or hyphens, and cannot
   *     end with a hyphen.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Snapshot, OperationMetadata> createSnapshotAsync(
      VolumeName parent, Snapshot snapshot, String snapshotId) {
    CreateSnapshotRequest request =
        CreateSnapshotRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSnapshot(snapshot)
            .setSnapshotId(snapshotId)
            .build();
    return createSnapshotAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new snapshot for a volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   String parent = VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString();
   *   Snapshot snapshot = Snapshot.newBuilder().build();
   *   String snapshotId = "snapshotId-1113817601";
   *   Snapshot response = netAppClient.createSnapshotAsync(parent, snapshot, snapshotId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The NetApp volume to create the snapshots of, in the format
   *     `projects/{project_id}/locations/{location}/volumes/{volume_id}`
   * @param snapshot Required. A snapshot resource
   * @param snapshotId Required. ID of the snapshot to create. This value must start with a
   *     lowercase letter followed by up to 62 lowercase letters, numbers, or hyphens, and cannot
   *     end with a hyphen.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Snapshot, OperationMetadata> createSnapshotAsync(
      String parent, Snapshot snapshot, String snapshotId) {
    CreateSnapshotRequest request =
        CreateSnapshotRequest.newBuilder()
            .setParent(parent)
            .setSnapshot(snapshot)
            .setSnapshotId(snapshotId)
            .build();
    return createSnapshotAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new snapshot for a volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   CreateSnapshotRequest request =
   *       CreateSnapshotRequest.newBuilder()
   *           .setParent(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
   *           .setSnapshot(Snapshot.newBuilder().build())
   *           .setSnapshotId("snapshotId-1113817601")
   *           .build();
   *   Snapshot response = netAppClient.createSnapshotAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Snapshot, OperationMetadata> createSnapshotAsync(
      CreateSnapshotRequest request) {
    return createSnapshotOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new snapshot for a volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   CreateSnapshotRequest request =
   *       CreateSnapshotRequest.newBuilder()
   *           .setParent(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
   *           .setSnapshot(Snapshot.newBuilder().build())
   *           .setSnapshotId("snapshotId-1113817601")
   *           .build();
   *   OperationFuture<Snapshot, OperationMetadata> future =
   *       netAppClient.createSnapshotOperationCallable().futureCall(request);
   *   // Do something.
   *   Snapshot response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateSnapshotRequest, Snapshot, OperationMetadata>
      createSnapshotOperationCallable() {
    return stub.createSnapshotOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new snapshot for a volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   CreateSnapshotRequest request =
   *       CreateSnapshotRequest.newBuilder()
   *           .setParent(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
   *           .setSnapshot(Snapshot.newBuilder().build())
   *           .setSnapshotId("snapshotId-1113817601")
   *           .build();
   *   ApiFuture<Operation> future = netAppClient.createSnapshotCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateSnapshotRequest, Operation> createSnapshotCallable() {
    return stub.createSnapshotCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a snapshot.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   SnapshotName name = SnapshotName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[SNAPSHOT]");
   *   netAppClient.deleteSnapshotAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The snapshot resource name, in the format
   *     `projects/&#42;/locations/&#42;/volumes/&#42;/snapshots/{snapshot_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteSnapshotAsync(SnapshotName name) {
    DeleteSnapshotRequest request =
        DeleteSnapshotRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteSnapshotAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a snapshot.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   String name = SnapshotName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[SNAPSHOT]").toString();
   *   netAppClient.deleteSnapshotAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The snapshot resource name, in the format
   *     `projects/&#42;/locations/&#42;/volumes/&#42;/snapshots/{snapshot_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteSnapshotAsync(String name) {
    DeleteSnapshotRequest request = DeleteSnapshotRequest.newBuilder().setName(name).build();
    return deleteSnapshotAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a snapshot.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   DeleteSnapshotRequest request =
   *       DeleteSnapshotRequest.newBuilder()
   *           .setName(
   *               SnapshotName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[SNAPSHOT]").toString())
   *           .build();
   *   netAppClient.deleteSnapshotAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteSnapshotAsync(
      DeleteSnapshotRequest request) {
    return deleteSnapshotOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a snapshot.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   DeleteSnapshotRequest request =
   *       DeleteSnapshotRequest.newBuilder()
   *           .setName(
   *               SnapshotName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[SNAPSHOT]").toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       netAppClient.deleteSnapshotOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteSnapshotRequest, Empty, OperationMetadata>
      deleteSnapshotOperationCallable() {
    return stub.deleteSnapshotOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a snapshot.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   DeleteSnapshotRequest request =
   *       DeleteSnapshotRequest.newBuilder()
   *           .setName(
   *               SnapshotName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[SNAPSHOT]").toString())
   *           .build();
   *   ApiFuture<Operation> future = netAppClient.deleteSnapshotCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteSnapshotRequest, Operation> deleteSnapshotCallable() {
    return stub.deleteSnapshotCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the settings of a specific snapshot.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   Snapshot snapshot = Snapshot.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Snapshot response = netAppClient.updateSnapshotAsync(snapshot, updateMask).get();
   * }
   * }</pre>
   *
   * @param snapshot Required. A snapshot resource
   * @param updateMask Required. Mask of fields to update. At least one path must be supplied in
   *     this field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Snapshot, OperationMetadata> updateSnapshotAsync(
      Snapshot snapshot, FieldMask updateMask) {
    UpdateSnapshotRequest request =
        UpdateSnapshotRequest.newBuilder().setSnapshot(snapshot).setUpdateMask(updateMask).build();
    return updateSnapshotAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the settings of a specific snapshot.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   UpdateSnapshotRequest request =
   *       UpdateSnapshotRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setSnapshot(Snapshot.newBuilder().build())
   *           .build();
   *   Snapshot response = netAppClient.updateSnapshotAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Snapshot, OperationMetadata> updateSnapshotAsync(
      UpdateSnapshotRequest request) {
    return updateSnapshotOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the settings of a specific snapshot.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   UpdateSnapshotRequest request =
   *       UpdateSnapshotRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setSnapshot(Snapshot.newBuilder().build())
   *           .build();
   *   OperationFuture<Snapshot, OperationMetadata> future =
   *       netAppClient.updateSnapshotOperationCallable().futureCall(request);
   *   // Do something.
   *   Snapshot response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateSnapshotRequest, Snapshot, OperationMetadata>
      updateSnapshotOperationCallable() {
    return stub.updateSnapshotOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the settings of a specific snapshot.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   UpdateSnapshotRequest request =
   *       UpdateSnapshotRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setSnapshot(Snapshot.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = netAppClient.updateSnapshotCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateSnapshotRequest, Operation> updateSnapshotCallable() {
    return stub.updateSnapshotCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists active directories.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (ActiveDirectory element : netAppClient.listActiveDirectories(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListActiveDirectoriesRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListActiveDirectoriesPagedResponse listActiveDirectories(LocationName parent) {
    ListActiveDirectoriesRequest request =
        ListActiveDirectoriesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listActiveDirectories(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists active directories.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (ActiveDirectory element : netAppClient.listActiveDirectories(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListActiveDirectoriesRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListActiveDirectoriesPagedResponse listActiveDirectories(String parent) {
    ListActiveDirectoriesRequest request =
        ListActiveDirectoriesRequest.newBuilder().setParent(parent).build();
    return listActiveDirectories(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists active directories.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   ListActiveDirectoriesRequest request =
   *       ListActiveDirectoriesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (ActiveDirectory element : netAppClient.listActiveDirectories(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListActiveDirectoriesPagedResponse listActiveDirectories(
      ListActiveDirectoriesRequest request) {
    return listActiveDirectoriesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists active directories.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   ListActiveDirectoriesRequest request =
   *       ListActiveDirectoriesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<ActiveDirectory> future =
   *       netAppClient.listActiveDirectoriesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ActiveDirectory element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListActiveDirectoriesRequest, ListActiveDirectoriesPagedResponse>
      listActiveDirectoriesPagedCallable() {
    return stub.listActiveDirectoriesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists active directories.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   ListActiveDirectoriesRequest request =
   *       ListActiveDirectoriesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListActiveDirectoriesResponse response =
   *         netAppClient.listActiveDirectoriesCallable().call(request);
   *     for (ActiveDirectory element : response.getActiveDirectoriesList()) {
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
  public final UnaryCallable<ListActiveDirectoriesRequest, ListActiveDirectoriesResponse>
      listActiveDirectoriesCallable() {
    return stub.listActiveDirectoriesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Describes a specified active directory.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   ActiveDirectoryName name =
   *       ActiveDirectoryName.of("[PROJECT]", "[LOCATION]", "[ACTIVE_DIRECTORY]");
   *   ActiveDirectory response = netAppClient.getActiveDirectory(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the active directory.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ActiveDirectory getActiveDirectory(ActiveDirectoryName name) {
    GetActiveDirectoryRequest request =
        GetActiveDirectoryRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getActiveDirectory(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Describes a specified active directory.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   String name =
   *       ActiveDirectoryName.of("[PROJECT]", "[LOCATION]", "[ACTIVE_DIRECTORY]").toString();
   *   ActiveDirectory response = netAppClient.getActiveDirectory(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the active directory.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ActiveDirectory getActiveDirectory(String name) {
    GetActiveDirectoryRequest request =
        GetActiveDirectoryRequest.newBuilder().setName(name).build();
    return getActiveDirectory(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Describes a specified active directory.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   GetActiveDirectoryRequest request =
   *       GetActiveDirectoryRequest.newBuilder()
   *           .setName(
   *               ActiveDirectoryName.of("[PROJECT]", "[LOCATION]", "[ACTIVE_DIRECTORY]")
   *                   .toString())
   *           .build();
   *   ActiveDirectory response = netAppClient.getActiveDirectory(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ActiveDirectory getActiveDirectory(GetActiveDirectoryRequest request) {
    return getActiveDirectoryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Describes a specified active directory.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   GetActiveDirectoryRequest request =
   *       GetActiveDirectoryRequest.newBuilder()
   *           .setName(
   *               ActiveDirectoryName.of("[PROJECT]", "[LOCATION]", "[ACTIVE_DIRECTORY]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ActiveDirectory> future =
   *       netAppClient.getActiveDirectoryCallable().futureCall(request);
   *   // Do something.
   *   ActiveDirectory response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetActiveDirectoryRequest, ActiveDirectory>
      getActiveDirectoryCallable() {
    return stub.getActiveDirectoryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * CreateActiveDirectory Creates the active directory specified in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ActiveDirectory activeDirectory = ActiveDirectory.newBuilder().build();
   *   String activeDirectoryId = "activeDirectoryId589359490";
   *   ActiveDirectory response =
   *       netAppClient.createActiveDirectoryAsync(parent, activeDirectory, activeDirectoryId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param activeDirectory Required. Fields of the to be created active directory.
   * @param activeDirectoryId Required. ID of the active directory to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ActiveDirectory, OperationMetadata> createActiveDirectoryAsync(
      LocationName parent, ActiveDirectory activeDirectory, String activeDirectoryId) {
    CreateActiveDirectoryRequest request =
        CreateActiveDirectoryRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setActiveDirectory(activeDirectory)
            .setActiveDirectoryId(activeDirectoryId)
            .build();
    return createActiveDirectoryAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * CreateActiveDirectory Creates the active directory specified in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   ActiveDirectory activeDirectory = ActiveDirectory.newBuilder().build();
   *   String activeDirectoryId = "activeDirectoryId589359490";
   *   ActiveDirectory response =
   *       netAppClient.createActiveDirectoryAsync(parent, activeDirectory, activeDirectoryId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param activeDirectory Required. Fields of the to be created active directory.
   * @param activeDirectoryId Required. ID of the active directory to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ActiveDirectory, OperationMetadata> createActiveDirectoryAsync(
      String parent, ActiveDirectory activeDirectory, String activeDirectoryId) {
    CreateActiveDirectoryRequest request =
        CreateActiveDirectoryRequest.newBuilder()
            .setParent(parent)
            .setActiveDirectory(activeDirectory)
            .setActiveDirectoryId(activeDirectoryId)
            .build();
    return createActiveDirectoryAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * CreateActiveDirectory Creates the active directory specified in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   CreateActiveDirectoryRequest request =
   *       CreateActiveDirectoryRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setActiveDirectory(ActiveDirectory.newBuilder().build())
   *           .setActiveDirectoryId("activeDirectoryId589359490")
   *           .build();
   *   ActiveDirectory response = netAppClient.createActiveDirectoryAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ActiveDirectory, OperationMetadata> createActiveDirectoryAsync(
      CreateActiveDirectoryRequest request) {
    return createActiveDirectoryOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * CreateActiveDirectory Creates the active directory specified in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   CreateActiveDirectoryRequest request =
   *       CreateActiveDirectoryRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setActiveDirectory(ActiveDirectory.newBuilder().build())
   *           .setActiveDirectoryId("activeDirectoryId589359490")
   *           .build();
   *   OperationFuture<ActiveDirectory, OperationMetadata> future =
   *       netAppClient.createActiveDirectoryOperationCallable().futureCall(request);
   *   // Do something.
   *   ActiveDirectory response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateActiveDirectoryRequest, ActiveDirectory, OperationMetadata>
      createActiveDirectoryOperationCallable() {
    return stub.createActiveDirectoryOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * CreateActiveDirectory Creates the active directory specified in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   CreateActiveDirectoryRequest request =
   *       CreateActiveDirectoryRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setActiveDirectory(ActiveDirectory.newBuilder().build())
   *           .setActiveDirectoryId("activeDirectoryId589359490")
   *           .build();
   *   ApiFuture<Operation> future =
   *       netAppClient.createActiveDirectoryCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateActiveDirectoryRequest, Operation>
      createActiveDirectoryCallable() {
    return stub.createActiveDirectoryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the parameters of an active directories.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   ActiveDirectory activeDirectory = ActiveDirectory.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   ActiveDirectory response =
   *       netAppClient.updateActiveDirectoryAsync(activeDirectory, updateMask).get();
   * }
   * }</pre>
   *
   * @param activeDirectory Required. The volume being updated
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     Active Directory resource by the update. The fields specified in the update_mask are
   *     relative to the resource, not the full request. A field will be overwritten if it is in the
   *     mask. If the user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ActiveDirectory, OperationMetadata> updateActiveDirectoryAsync(
      ActiveDirectory activeDirectory, FieldMask updateMask) {
    UpdateActiveDirectoryRequest request =
        UpdateActiveDirectoryRequest.newBuilder()
            .setActiveDirectory(activeDirectory)
            .setUpdateMask(updateMask)
            .build();
    return updateActiveDirectoryAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the parameters of an active directories.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   UpdateActiveDirectoryRequest request =
   *       UpdateActiveDirectoryRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setActiveDirectory(ActiveDirectory.newBuilder().build())
   *           .build();
   *   ActiveDirectory response = netAppClient.updateActiveDirectoryAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ActiveDirectory, OperationMetadata> updateActiveDirectoryAsync(
      UpdateActiveDirectoryRequest request) {
    return updateActiveDirectoryOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the parameters of an active directories.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   UpdateActiveDirectoryRequest request =
   *       UpdateActiveDirectoryRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setActiveDirectory(ActiveDirectory.newBuilder().build())
   *           .build();
   *   OperationFuture<ActiveDirectory, OperationMetadata> future =
   *       netAppClient.updateActiveDirectoryOperationCallable().futureCall(request);
   *   // Do something.
   *   ActiveDirectory response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateActiveDirectoryRequest, ActiveDirectory, OperationMetadata>
      updateActiveDirectoryOperationCallable() {
    return stub.updateActiveDirectoryOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the parameters of an active directories.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   UpdateActiveDirectoryRequest request =
   *       UpdateActiveDirectoryRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setActiveDirectory(ActiveDirectory.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       netAppClient.updateActiveDirectoryCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateActiveDirectoryRequest, Operation>
      updateActiveDirectoryCallable() {
    return stub.updateActiveDirectoryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete the active directory specified in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   ActiveDirectoryName name =
   *       ActiveDirectoryName.of("[PROJECT]", "[LOCATION]", "[ACTIVE_DIRECTORY]");
   *   netAppClient.deleteActiveDirectoryAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the active directory.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteActiveDirectoryAsync(
      ActiveDirectoryName name) {
    DeleteActiveDirectoryRequest request =
        DeleteActiveDirectoryRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteActiveDirectoryAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete the active directory specified in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   String name =
   *       ActiveDirectoryName.of("[PROJECT]", "[LOCATION]", "[ACTIVE_DIRECTORY]").toString();
   *   netAppClient.deleteActiveDirectoryAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the active directory.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteActiveDirectoryAsync(String name) {
    DeleteActiveDirectoryRequest request =
        DeleteActiveDirectoryRequest.newBuilder().setName(name).build();
    return deleteActiveDirectoryAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete the active directory specified in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   DeleteActiveDirectoryRequest request =
   *       DeleteActiveDirectoryRequest.newBuilder()
   *           .setName(
   *               ActiveDirectoryName.of("[PROJECT]", "[LOCATION]", "[ACTIVE_DIRECTORY]")
   *                   .toString())
   *           .build();
   *   netAppClient.deleteActiveDirectoryAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteActiveDirectoryAsync(
      DeleteActiveDirectoryRequest request) {
    return deleteActiveDirectoryOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete the active directory specified in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   DeleteActiveDirectoryRequest request =
   *       DeleteActiveDirectoryRequest.newBuilder()
   *           .setName(
   *               ActiveDirectoryName.of("[PROJECT]", "[LOCATION]", "[ACTIVE_DIRECTORY]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       netAppClient.deleteActiveDirectoryOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteActiveDirectoryRequest, Empty, OperationMetadata>
      deleteActiveDirectoryOperationCallable() {
    return stub.deleteActiveDirectoryOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete the active directory specified in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   DeleteActiveDirectoryRequest request =
   *       DeleteActiveDirectoryRequest.newBuilder()
   *           .setName(
   *               ActiveDirectoryName.of("[PROJECT]", "[LOCATION]", "[ACTIVE_DIRECTORY]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       netAppClient.deleteActiveDirectoryCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteActiveDirectoryRequest, Operation>
      deleteActiveDirectoryCallable() {
    return stub.deleteActiveDirectoryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns descriptions of all KMS configs owned by the caller.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (KmsConfig element : netAppClient.listKmsConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListKmsConfigsPagedResponse listKmsConfigs(LocationName parent) {
    ListKmsConfigsRequest request =
        ListKmsConfigsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listKmsConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns descriptions of all KMS configs owned by the caller.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (KmsConfig element : netAppClient.listKmsConfigs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListKmsConfigsPagedResponse listKmsConfigs(String parent) {
    ListKmsConfigsRequest request = ListKmsConfigsRequest.newBuilder().setParent(parent).build();
    return listKmsConfigs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns descriptions of all KMS configs owned by the caller.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   ListKmsConfigsRequest request =
   *       ListKmsConfigsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (KmsConfig element : netAppClient.listKmsConfigs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListKmsConfigsPagedResponse listKmsConfigs(ListKmsConfigsRequest request) {
    return listKmsConfigsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns descriptions of all KMS configs owned by the caller.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   ListKmsConfigsRequest request =
   *       ListKmsConfigsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<KmsConfig> future = netAppClient.listKmsConfigsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (KmsConfig element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListKmsConfigsRequest, ListKmsConfigsPagedResponse>
      listKmsConfigsPagedCallable() {
    return stub.listKmsConfigsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns descriptions of all KMS configs owned by the caller.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   ListKmsConfigsRequest request =
   *       ListKmsConfigsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListKmsConfigsResponse response = netAppClient.listKmsConfigsCallable().call(request);
   *     for (KmsConfig element : response.getKmsConfigsList()) {
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
  public final UnaryCallable<ListKmsConfigsRequest, ListKmsConfigsResponse>
      listKmsConfigsCallable() {
    return stub.listKmsConfigsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new KMS config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   KmsConfig kmsConfig = KmsConfig.newBuilder().build();
   *   String kmsConfigId = "kmsConfigId-1159731602";
   *   KmsConfig response = netAppClient.createKmsConfigAsync(parent, kmsConfig, kmsConfigId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param kmsConfig Required. The required parameters to create a new KmsConfig.
   * @param kmsConfigId Required. Id of the requesting KmsConfig If auto-generating Id server-side,
   *     remove this field and id from the method_signature of Create RPC
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<KmsConfig, OperationMetadata> createKmsConfigAsync(
      LocationName parent, KmsConfig kmsConfig, String kmsConfigId) {
    CreateKmsConfigRequest request =
        CreateKmsConfigRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setKmsConfig(kmsConfig)
            .setKmsConfigId(kmsConfigId)
            .build();
    return createKmsConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new KMS config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   KmsConfig kmsConfig = KmsConfig.newBuilder().build();
   *   String kmsConfigId = "kmsConfigId-1159731602";
   *   KmsConfig response = netAppClient.createKmsConfigAsync(parent, kmsConfig, kmsConfigId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param kmsConfig Required. The required parameters to create a new KmsConfig.
   * @param kmsConfigId Required. Id of the requesting KmsConfig If auto-generating Id server-side,
   *     remove this field and id from the method_signature of Create RPC
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<KmsConfig, OperationMetadata> createKmsConfigAsync(
      String parent, KmsConfig kmsConfig, String kmsConfigId) {
    CreateKmsConfigRequest request =
        CreateKmsConfigRequest.newBuilder()
            .setParent(parent)
            .setKmsConfig(kmsConfig)
            .setKmsConfigId(kmsConfigId)
            .build();
    return createKmsConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new KMS config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   CreateKmsConfigRequest request =
   *       CreateKmsConfigRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setKmsConfigId("kmsConfigId-1159731602")
   *           .setKmsConfig(KmsConfig.newBuilder().build())
   *           .build();
   *   KmsConfig response = netAppClient.createKmsConfigAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<KmsConfig, OperationMetadata> createKmsConfigAsync(
      CreateKmsConfigRequest request) {
    return createKmsConfigOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new KMS config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   CreateKmsConfigRequest request =
   *       CreateKmsConfigRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setKmsConfigId("kmsConfigId-1159731602")
   *           .setKmsConfig(KmsConfig.newBuilder().build())
   *           .build();
   *   OperationFuture<KmsConfig, OperationMetadata> future =
   *       netAppClient.createKmsConfigOperationCallable().futureCall(request);
   *   // Do something.
   *   KmsConfig response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateKmsConfigRequest, KmsConfig, OperationMetadata>
      createKmsConfigOperationCallable() {
    return stub.createKmsConfigOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new KMS config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   CreateKmsConfigRequest request =
   *       CreateKmsConfigRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setKmsConfigId("kmsConfigId-1159731602")
   *           .setKmsConfig(KmsConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = netAppClient.createKmsConfigCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateKmsConfigRequest, Operation> createKmsConfigCallable() {
    return stub.createKmsConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the description of the specified KMS config by kms_config_id.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   KmsConfigName name = KmsConfigName.of("[PROJECT]", "[LOCATION]", "[KMS_CONFIG]");
   *   KmsConfig response = netAppClient.getKmsConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the KmsConfig
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final KmsConfig getKmsConfig(KmsConfigName name) {
    GetKmsConfigRequest request =
        GetKmsConfigRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getKmsConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the description of the specified KMS config by kms_config_id.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   String name = KmsConfigName.of("[PROJECT]", "[LOCATION]", "[KMS_CONFIG]").toString();
   *   KmsConfig response = netAppClient.getKmsConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the KmsConfig
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final KmsConfig getKmsConfig(String name) {
    GetKmsConfigRequest request = GetKmsConfigRequest.newBuilder().setName(name).build();
    return getKmsConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the description of the specified KMS config by kms_config_id.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   GetKmsConfigRequest request =
   *       GetKmsConfigRequest.newBuilder()
   *           .setName(KmsConfigName.of("[PROJECT]", "[LOCATION]", "[KMS_CONFIG]").toString())
   *           .build();
   *   KmsConfig response = netAppClient.getKmsConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final KmsConfig getKmsConfig(GetKmsConfigRequest request) {
    return getKmsConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the description of the specified KMS config by kms_config_id.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   GetKmsConfigRequest request =
   *       GetKmsConfigRequest.newBuilder()
   *           .setName(KmsConfigName.of("[PROJECT]", "[LOCATION]", "[KMS_CONFIG]").toString())
   *           .build();
   *   ApiFuture<KmsConfig> future = netAppClient.getKmsConfigCallable().futureCall(request);
   *   // Do something.
   *   KmsConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetKmsConfigRequest, KmsConfig> getKmsConfigCallable() {
    return stub.getKmsConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the Kms config properties with the full spec
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   KmsConfig kmsConfig = KmsConfig.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   KmsConfig response = netAppClient.updateKmsConfigAsync(kmsConfig, updateMask).get();
   * }
   * }</pre>
   *
   * @param kmsConfig Required. The KmsConfig being updated
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     KmsConfig resource by the update. The fields specified in the update_mask are relative to
   *     the resource, not the full request. A field will be overwritten if it is in the mask. If
   *     the user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<KmsConfig, OperationMetadata> updateKmsConfigAsync(
      KmsConfig kmsConfig, FieldMask updateMask) {
    UpdateKmsConfigRequest request =
        UpdateKmsConfigRequest.newBuilder()
            .setKmsConfig(kmsConfig)
            .setUpdateMask(updateMask)
            .build();
    return updateKmsConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the Kms config properties with the full spec
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   UpdateKmsConfigRequest request =
   *       UpdateKmsConfigRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setKmsConfig(KmsConfig.newBuilder().build())
   *           .build();
   *   KmsConfig response = netAppClient.updateKmsConfigAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<KmsConfig, OperationMetadata> updateKmsConfigAsync(
      UpdateKmsConfigRequest request) {
    return updateKmsConfigOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the Kms config properties with the full spec
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   UpdateKmsConfigRequest request =
   *       UpdateKmsConfigRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setKmsConfig(KmsConfig.newBuilder().build())
   *           .build();
   *   OperationFuture<KmsConfig, OperationMetadata> future =
   *       netAppClient.updateKmsConfigOperationCallable().futureCall(request);
   *   // Do something.
   *   KmsConfig response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateKmsConfigRequest, KmsConfig, OperationMetadata>
      updateKmsConfigOperationCallable() {
    return stub.updateKmsConfigOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the Kms config properties with the full spec
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   UpdateKmsConfigRequest request =
   *       UpdateKmsConfigRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setKmsConfig(KmsConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = netAppClient.updateKmsConfigCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateKmsConfigRequest, Operation> updateKmsConfigCallable() {
    return stub.updateKmsConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Encrypt the existing volumes without CMEK encryption with the desired the KMS config for the
   * whole region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   EncryptVolumesRequest request =
   *       EncryptVolumesRequest.newBuilder()
   *           .setName(KmsConfigName.of("[PROJECT]", "[LOCATION]", "[KMS_CONFIG]").toString())
   *           .build();
   *   KmsConfig response = netAppClient.encryptVolumesAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<KmsConfig, OperationMetadata> encryptVolumesAsync(
      EncryptVolumesRequest request) {
    return encryptVolumesOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Encrypt the existing volumes without CMEK encryption with the desired the KMS config for the
   * whole region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   EncryptVolumesRequest request =
   *       EncryptVolumesRequest.newBuilder()
   *           .setName(KmsConfigName.of("[PROJECT]", "[LOCATION]", "[KMS_CONFIG]").toString())
   *           .build();
   *   OperationFuture<KmsConfig, OperationMetadata> future =
   *       netAppClient.encryptVolumesOperationCallable().futureCall(request);
   *   // Do something.
   *   KmsConfig response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<EncryptVolumesRequest, KmsConfig, OperationMetadata>
      encryptVolumesOperationCallable() {
    return stub.encryptVolumesOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Encrypt the existing volumes without CMEK encryption with the desired the KMS config for the
   * whole region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   EncryptVolumesRequest request =
   *       EncryptVolumesRequest.newBuilder()
   *           .setName(KmsConfigName.of("[PROJECT]", "[LOCATION]", "[KMS_CONFIG]").toString())
   *           .build();
   *   ApiFuture<Operation> future = netAppClient.encryptVolumesCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<EncryptVolumesRequest, Operation> encryptVolumesCallable() {
    return stub.encryptVolumesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Verifies KMS config reachability.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   VerifyKmsConfigRequest request =
   *       VerifyKmsConfigRequest.newBuilder()
   *           .setName(KmsConfigName.of("[PROJECT]", "[LOCATION]", "[KMS_CONFIG]").toString())
   *           .build();
   *   VerifyKmsConfigResponse response = netAppClient.verifyKmsConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VerifyKmsConfigResponse verifyKmsConfig(VerifyKmsConfigRequest request) {
    return verifyKmsConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Verifies KMS config reachability.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   VerifyKmsConfigRequest request =
   *       VerifyKmsConfigRequest.newBuilder()
   *           .setName(KmsConfigName.of("[PROJECT]", "[LOCATION]", "[KMS_CONFIG]").toString())
   *           .build();
   *   ApiFuture<VerifyKmsConfigResponse> future =
   *       netAppClient.verifyKmsConfigCallable().futureCall(request);
   *   // Do something.
   *   VerifyKmsConfigResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<VerifyKmsConfigRequest, VerifyKmsConfigResponse>
      verifyKmsConfigCallable() {
    return stub.verifyKmsConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Warning! This operation will permanently delete the Kms config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   KmsConfigName name = KmsConfigName.of("[PROJECT]", "[LOCATION]", "[KMS_CONFIG]");
   *   netAppClient.deleteKmsConfigAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the KmsConfig.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteKmsConfigAsync(KmsConfigName name) {
    DeleteKmsConfigRequest request =
        DeleteKmsConfigRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteKmsConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Warning! This operation will permanently delete the Kms config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   String name = KmsConfigName.of("[PROJECT]", "[LOCATION]", "[KMS_CONFIG]").toString();
   *   netAppClient.deleteKmsConfigAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the KmsConfig.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteKmsConfigAsync(String name) {
    DeleteKmsConfigRequest request = DeleteKmsConfigRequest.newBuilder().setName(name).build();
    return deleteKmsConfigAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Warning! This operation will permanently delete the Kms config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   DeleteKmsConfigRequest request =
   *       DeleteKmsConfigRequest.newBuilder()
   *           .setName(KmsConfigName.of("[PROJECT]", "[LOCATION]", "[KMS_CONFIG]").toString())
   *           .build();
   *   netAppClient.deleteKmsConfigAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteKmsConfigAsync(
      DeleteKmsConfigRequest request) {
    return deleteKmsConfigOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Warning! This operation will permanently delete the Kms config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   DeleteKmsConfigRequest request =
   *       DeleteKmsConfigRequest.newBuilder()
   *           .setName(KmsConfigName.of("[PROJECT]", "[LOCATION]", "[KMS_CONFIG]").toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       netAppClient.deleteKmsConfigOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteKmsConfigRequest, Empty, OperationMetadata>
      deleteKmsConfigOperationCallable() {
    return stub.deleteKmsConfigOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Warning! This operation will permanently delete the Kms config.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   DeleteKmsConfigRequest request =
   *       DeleteKmsConfigRequest.newBuilder()
   *           .setName(KmsConfigName.of("[PROJECT]", "[LOCATION]", "[KMS_CONFIG]").toString())
   *           .build();
   *   ApiFuture<Operation> future = netAppClient.deleteKmsConfigCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteKmsConfigRequest, Operation> deleteKmsConfigCallable() {
    return stub.deleteKmsConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns descriptions of all replications for a volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   VolumeName parent = VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]");
   *   for (Replication element : netAppClient.listReplications(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The volume for which to retrieve replication information, in the format
   *     `projects/{project_id}/locations/{location}/volumes/{volume_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReplicationsPagedResponse listReplications(VolumeName parent) {
    ListReplicationsRequest request =
        ListReplicationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listReplications(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns descriptions of all replications for a volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   String parent = VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString();
   *   for (Replication element : netAppClient.listReplications(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The volume for which to retrieve replication information, in the format
   *     `projects/{project_id}/locations/{location}/volumes/{volume_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReplicationsPagedResponse listReplications(String parent) {
    ListReplicationsRequest request =
        ListReplicationsRequest.newBuilder().setParent(parent).build();
    return listReplications(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns descriptions of all replications for a volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   ListReplicationsRequest request =
   *       ListReplicationsRequest.newBuilder()
   *           .setParent(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (Replication element : netAppClient.listReplications(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReplicationsPagedResponse listReplications(ListReplicationsRequest request) {
    return listReplicationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns descriptions of all replications for a volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   ListReplicationsRequest request =
   *       ListReplicationsRequest.newBuilder()
   *           .setParent(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<Replication> future =
   *       netAppClient.listReplicationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Replication element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListReplicationsRequest, ListReplicationsPagedResponse>
      listReplicationsPagedCallable() {
    return stub.listReplicationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns descriptions of all replications for a volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   ListReplicationsRequest request =
   *       ListReplicationsRequest.newBuilder()
   *           .setParent(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListReplicationsResponse response = netAppClient.listReplicationsCallable().call(request);
   *     for (Replication element : response.getReplicationsList()) {
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
  public final UnaryCallable<ListReplicationsRequest, ListReplicationsResponse>
      listReplicationsCallable() {
    return stub.listReplicationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Describe a replication for a volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   ReplicationName name =
   *       ReplicationName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[REPLICATION]");
   *   Replication response = netAppClient.getReplication(name);
   * }
   * }</pre>
   *
   * @param name Required. The replication resource name, in the format
   *     `projects/{project_id}/locations/{location}/volumes/{volume_id}/replications/{replication_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Replication getReplication(ReplicationName name) {
    GetReplicationRequest request =
        GetReplicationRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getReplication(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Describe a replication for a volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   String name =
   *       ReplicationName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[REPLICATION]").toString();
   *   Replication response = netAppClient.getReplication(name);
   * }
   * }</pre>
   *
   * @param name Required. The replication resource name, in the format
   *     `projects/{project_id}/locations/{location}/volumes/{volume_id}/replications/{replication_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Replication getReplication(String name) {
    GetReplicationRequest request = GetReplicationRequest.newBuilder().setName(name).build();
    return getReplication(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Describe a replication for a volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   GetReplicationRequest request =
   *       GetReplicationRequest.newBuilder()
   *           .setName(
   *               ReplicationName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[REPLICATION]")
   *                   .toString())
   *           .build();
   *   Replication response = netAppClient.getReplication(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Replication getReplication(GetReplicationRequest request) {
    return getReplicationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Describe a replication for a volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   GetReplicationRequest request =
   *       GetReplicationRequest.newBuilder()
   *           .setName(
   *               ReplicationName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[REPLICATION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Replication> future = netAppClient.getReplicationCallable().futureCall(request);
   *   // Do something.
   *   Replication response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetReplicationRequest, Replication> getReplicationCallable() {
    return stub.getReplicationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new replication for a volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   VolumeName parent = VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]");
   *   Replication replication = Replication.newBuilder().build();
   *   String replicationId = "replicationId1170820615";
   *   Replication response =
   *       netAppClient.createReplicationAsync(parent, replication, replicationId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The NetApp volume to create the replications of, in the format
   *     `projects/{project_id}/locations/{location}/volumes/{volume_id}`
   * @param replication Required. A replication resource
   * @param replicationId Required. ID of the replication to create. This value must start with a
   *     lowercase letter followed by up to 62 lowercase letters, numbers, or hyphens, and cannot
   *     end with a hyphen.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Replication, OperationMetadata> createReplicationAsync(
      VolumeName parent, Replication replication, String replicationId) {
    CreateReplicationRequest request =
        CreateReplicationRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setReplication(replication)
            .setReplicationId(replicationId)
            .build();
    return createReplicationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new replication for a volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   String parent = VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString();
   *   Replication replication = Replication.newBuilder().build();
   *   String replicationId = "replicationId1170820615";
   *   Replication response =
   *       netAppClient.createReplicationAsync(parent, replication, replicationId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The NetApp volume to create the replications of, in the format
   *     `projects/{project_id}/locations/{location}/volumes/{volume_id}`
   * @param replication Required. A replication resource
   * @param replicationId Required. ID of the replication to create. This value must start with a
   *     lowercase letter followed by up to 62 lowercase letters, numbers, or hyphens, and cannot
   *     end with a hyphen.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Replication, OperationMetadata> createReplicationAsync(
      String parent, Replication replication, String replicationId) {
    CreateReplicationRequest request =
        CreateReplicationRequest.newBuilder()
            .setParent(parent)
            .setReplication(replication)
            .setReplicationId(replicationId)
            .build();
    return createReplicationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new replication for a volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   CreateReplicationRequest request =
   *       CreateReplicationRequest.newBuilder()
   *           .setParent(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
   *           .setReplication(Replication.newBuilder().build())
   *           .setReplicationId("replicationId1170820615")
   *           .build();
   *   Replication response = netAppClient.createReplicationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Replication, OperationMetadata> createReplicationAsync(
      CreateReplicationRequest request) {
    return createReplicationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new replication for a volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   CreateReplicationRequest request =
   *       CreateReplicationRequest.newBuilder()
   *           .setParent(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
   *           .setReplication(Replication.newBuilder().build())
   *           .setReplicationId("replicationId1170820615")
   *           .build();
   *   OperationFuture<Replication, OperationMetadata> future =
   *       netAppClient.createReplicationOperationCallable().futureCall(request);
   *   // Do something.
   *   Replication response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateReplicationRequest, Replication, OperationMetadata>
      createReplicationOperationCallable() {
    return stub.createReplicationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new replication for a volume.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   CreateReplicationRequest request =
   *       CreateReplicationRequest.newBuilder()
   *           .setParent(VolumeName.of("[PROJECT]", "[LOCATION]", "[VOLUME]").toString())
   *           .setReplication(Replication.newBuilder().build())
   *           .setReplicationId("replicationId1170820615")
   *           .build();
   *   ApiFuture<Operation> future = netAppClient.createReplicationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateReplicationRequest, Operation> createReplicationCallable() {
    return stub.createReplicationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a replication.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   ReplicationName name =
   *       ReplicationName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[REPLICATION]");
   *   netAppClient.deleteReplicationAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The replication resource name, in the format
   *     `projects/&#42;/locations/&#42;/volumes/&#42;/replications/{replication_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteReplicationAsync(
      ReplicationName name) {
    DeleteReplicationRequest request =
        DeleteReplicationRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteReplicationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a replication.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   String name =
   *       ReplicationName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[REPLICATION]").toString();
   *   netAppClient.deleteReplicationAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The replication resource name, in the format
   *     `projects/&#42;/locations/&#42;/volumes/&#42;/replications/{replication_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteReplicationAsync(String name) {
    DeleteReplicationRequest request = DeleteReplicationRequest.newBuilder().setName(name).build();
    return deleteReplicationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a replication.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   DeleteReplicationRequest request =
   *       DeleteReplicationRequest.newBuilder()
   *           .setName(
   *               ReplicationName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[REPLICATION]")
   *                   .toString())
   *           .build();
   *   netAppClient.deleteReplicationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteReplicationAsync(
      DeleteReplicationRequest request) {
    return deleteReplicationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a replication.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   DeleteReplicationRequest request =
   *       DeleteReplicationRequest.newBuilder()
   *           .setName(
   *               ReplicationName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[REPLICATION]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       netAppClient.deleteReplicationOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteReplicationRequest, Empty, OperationMetadata>
      deleteReplicationOperationCallable() {
    return stub.deleteReplicationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a replication.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   DeleteReplicationRequest request =
   *       DeleteReplicationRequest.newBuilder()
   *           .setName(
   *               ReplicationName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[REPLICATION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future = netAppClient.deleteReplicationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteReplicationRequest, Operation> deleteReplicationCallable() {
    return stub.deleteReplicationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the settings of a specific replication.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   Replication replication = Replication.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Replication response = netAppClient.updateReplicationAsync(replication, updateMask).get();
   * }
   * }</pre>
   *
   * @param replication Required. A replication resource
   * @param updateMask Required. Mask of fields to update. At least one path must be supplied in
   *     this field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Replication, OperationMetadata> updateReplicationAsync(
      Replication replication, FieldMask updateMask) {
    UpdateReplicationRequest request =
        UpdateReplicationRequest.newBuilder()
            .setReplication(replication)
            .setUpdateMask(updateMask)
            .build();
    return updateReplicationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the settings of a specific replication.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   UpdateReplicationRequest request =
   *       UpdateReplicationRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setReplication(Replication.newBuilder().build())
   *           .build();
   *   Replication response = netAppClient.updateReplicationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Replication, OperationMetadata> updateReplicationAsync(
      UpdateReplicationRequest request) {
    return updateReplicationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the settings of a specific replication.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   UpdateReplicationRequest request =
   *       UpdateReplicationRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setReplication(Replication.newBuilder().build())
   *           .build();
   *   OperationFuture<Replication, OperationMetadata> future =
   *       netAppClient.updateReplicationOperationCallable().futureCall(request);
   *   // Do something.
   *   Replication response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateReplicationRequest, Replication, OperationMetadata>
      updateReplicationOperationCallable() {
    return stub.updateReplicationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the settings of a specific replication.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   UpdateReplicationRequest request =
   *       UpdateReplicationRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setReplication(Replication.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = netAppClient.updateReplicationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateReplicationRequest, Operation> updateReplicationCallable() {
    return stub.updateReplicationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stop Cross Region Replication.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   StopReplicationRequest request =
   *       StopReplicationRequest.newBuilder()
   *           .setName(
   *               ReplicationName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[REPLICATION]")
   *                   .toString())
   *           .setForce(true)
   *           .build();
   *   Replication response = netAppClient.stopReplicationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Replication, OperationMetadata> stopReplicationAsync(
      StopReplicationRequest request) {
    return stopReplicationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stop Cross Region Replication.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   StopReplicationRequest request =
   *       StopReplicationRequest.newBuilder()
   *           .setName(
   *               ReplicationName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[REPLICATION]")
   *                   .toString())
   *           .setForce(true)
   *           .build();
   *   OperationFuture<Replication, OperationMetadata> future =
   *       netAppClient.stopReplicationOperationCallable().futureCall(request);
   *   // Do something.
   *   Replication response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<StopReplicationRequest, Replication, OperationMetadata>
      stopReplicationOperationCallable() {
    return stub.stopReplicationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stop Cross Region Replication.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   StopReplicationRequest request =
   *       StopReplicationRequest.newBuilder()
   *           .setName(
   *               ReplicationName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[REPLICATION]")
   *                   .toString())
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Operation> future = netAppClient.stopReplicationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<StopReplicationRequest, Operation> stopReplicationCallable() {
    return stub.stopReplicationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resume Cross Region Replication.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   ResumeReplicationRequest request =
   *       ResumeReplicationRequest.newBuilder()
   *           .setName(
   *               ReplicationName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[REPLICATION]")
   *                   .toString())
   *           .build();
   *   Replication response = netAppClient.resumeReplicationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Replication, OperationMetadata> resumeReplicationAsync(
      ResumeReplicationRequest request) {
    return resumeReplicationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resume Cross Region Replication.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   ResumeReplicationRequest request =
   *       ResumeReplicationRequest.newBuilder()
   *           .setName(
   *               ReplicationName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[REPLICATION]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Replication, OperationMetadata> future =
   *       netAppClient.resumeReplicationOperationCallable().futureCall(request);
   *   // Do something.
   *   Replication response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ResumeReplicationRequest, Replication, OperationMetadata>
      resumeReplicationOperationCallable() {
    return stub.resumeReplicationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resume Cross Region Replication.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   ResumeReplicationRequest request =
   *       ResumeReplicationRequest.newBuilder()
   *           .setName(
   *               ReplicationName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[REPLICATION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future = netAppClient.resumeReplicationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ResumeReplicationRequest, Operation> resumeReplicationCallable() {
    return stub.resumeReplicationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reverses direction of replication. Source becomes destination and destination becomes source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   ReverseReplicationDirectionRequest request =
   *       ReverseReplicationDirectionRequest.newBuilder()
   *           .setName(
   *               ReplicationName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[REPLICATION]")
   *                   .toString())
   *           .build();
   *   Replication response = netAppClient.reverseReplicationDirectionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Replication, OperationMetadata> reverseReplicationDirectionAsync(
      ReverseReplicationDirectionRequest request) {
    return reverseReplicationDirectionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reverses direction of replication. Source becomes destination and destination becomes source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   ReverseReplicationDirectionRequest request =
   *       ReverseReplicationDirectionRequest.newBuilder()
   *           .setName(
   *               ReplicationName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[REPLICATION]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Replication, OperationMetadata> future =
   *       netAppClient.reverseReplicationDirectionOperationCallable().futureCall(request);
   *   // Do something.
   *   Replication response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ReverseReplicationDirectionRequest, Replication, OperationMetadata>
      reverseReplicationDirectionOperationCallable() {
    return stub.reverseReplicationDirectionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reverses direction of replication. Source becomes destination and destination becomes source.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   ReverseReplicationDirectionRequest request =
   *       ReverseReplicationDirectionRequest.newBuilder()
   *           .setName(
   *               ReplicationName.of("[PROJECT]", "[LOCATION]", "[VOLUME]", "[REPLICATION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       netAppClient.reverseReplicationDirectionCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ReverseReplicationDirectionRequest, Operation>
      reverseReplicationDirectionCallable() {
    return stub.reverseReplicationDirectionCallable();
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
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : netAppClient.listLocations(request).iterateAll()) {
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
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future = netAppClient.listLocationsPagedCallable().futureCall(request);
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
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = netAppClient.listLocationsCallable().call(request);
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
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = netAppClient.getLocation(request);
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
   * try (NetAppClient netAppClient = NetAppClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = netAppClient.getLocationCallable().futureCall(request);
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

  public static class ListStoragePoolsPagedResponse
      extends AbstractPagedListResponse<
          ListStoragePoolsRequest,
          ListStoragePoolsResponse,
          StoragePool,
          ListStoragePoolsPage,
          ListStoragePoolsFixedSizeCollection> {

    public static ApiFuture<ListStoragePoolsPagedResponse> createAsync(
        PageContext<ListStoragePoolsRequest, ListStoragePoolsResponse, StoragePool> context,
        ApiFuture<ListStoragePoolsResponse> futureResponse) {
      ApiFuture<ListStoragePoolsPage> futurePage =
          ListStoragePoolsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListStoragePoolsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListStoragePoolsPagedResponse(ListStoragePoolsPage page) {
      super(page, ListStoragePoolsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListStoragePoolsPage
      extends AbstractPage<
          ListStoragePoolsRequest, ListStoragePoolsResponse, StoragePool, ListStoragePoolsPage> {

    private ListStoragePoolsPage(
        PageContext<ListStoragePoolsRequest, ListStoragePoolsResponse, StoragePool> context,
        ListStoragePoolsResponse response) {
      super(context, response);
    }

    private static ListStoragePoolsPage createEmptyPage() {
      return new ListStoragePoolsPage(null, null);
    }

    @Override
    protected ListStoragePoolsPage createPage(
        PageContext<ListStoragePoolsRequest, ListStoragePoolsResponse, StoragePool> context,
        ListStoragePoolsResponse response) {
      return new ListStoragePoolsPage(context, response);
    }

    @Override
    public ApiFuture<ListStoragePoolsPage> createPageAsync(
        PageContext<ListStoragePoolsRequest, ListStoragePoolsResponse, StoragePool> context,
        ApiFuture<ListStoragePoolsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListStoragePoolsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListStoragePoolsRequest,
          ListStoragePoolsResponse,
          StoragePool,
          ListStoragePoolsPage,
          ListStoragePoolsFixedSizeCollection> {

    private ListStoragePoolsFixedSizeCollection(
        List<ListStoragePoolsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListStoragePoolsFixedSizeCollection createEmptyCollection() {
      return new ListStoragePoolsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListStoragePoolsFixedSizeCollection createCollection(
        List<ListStoragePoolsPage> pages, int collectionSize) {
      return new ListStoragePoolsFixedSizeCollection(pages, collectionSize);
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

  public static class ListSnapshotsPagedResponse
      extends AbstractPagedListResponse<
          ListSnapshotsRequest,
          ListSnapshotsResponse,
          Snapshot,
          ListSnapshotsPage,
          ListSnapshotsFixedSizeCollection> {

    public static ApiFuture<ListSnapshotsPagedResponse> createAsync(
        PageContext<ListSnapshotsRequest, ListSnapshotsResponse, Snapshot> context,
        ApiFuture<ListSnapshotsResponse> futureResponse) {
      ApiFuture<ListSnapshotsPage> futurePage =
          ListSnapshotsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListSnapshotsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListSnapshotsPagedResponse(ListSnapshotsPage page) {
      super(page, ListSnapshotsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSnapshotsPage
      extends AbstractPage<
          ListSnapshotsRequest, ListSnapshotsResponse, Snapshot, ListSnapshotsPage> {

    private ListSnapshotsPage(
        PageContext<ListSnapshotsRequest, ListSnapshotsResponse, Snapshot> context,
        ListSnapshotsResponse response) {
      super(context, response);
    }

    private static ListSnapshotsPage createEmptyPage() {
      return new ListSnapshotsPage(null, null);
    }

    @Override
    protected ListSnapshotsPage createPage(
        PageContext<ListSnapshotsRequest, ListSnapshotsResponse, Snapshot> context,
        ListSnapshotsResponse response) {
      return new ListSnapshotsPage(context, response);
    }

    @Override
    public ApiFuture<ListSnapshotsPage> createPageAsync(
        PageContext<ListSnapshotsRequest, ListSnapshotsResponse, Snapshot> context,
        ApiFuture<ListSnapshotsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSnapshotsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSnapshotsRequest,
          ListSnapshotsResponse,
          Snapshot,
          ListSnapshotsPage,
          ListSnapshotsFixedSizeCollection> {

    private ListSnapshotsFixedSizeCollection(List<ListSnapshotsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSnapshotsFixedSizeCollection createEmptyCollection() {
      return new ListSnapshotsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSnapshotsFixedSizeCollection createCollection(
        List<ListSnapshotsPage> pages, int collectionSize) {
      return new ListSnapshotsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListActiveDirectoriesPagedResponse
      extends AbstractPagedListResponse<
          ListActiveDirectoriesRequest,
          ListActiveDirectoriesResponse,
          ActiveDirectory,
          ListActiveDirectoriesPage,
          ListActiveDirectoriesFixedSizeCollection> {

    public static ApiFuture<ListActiveDirectoriesPagedResponse> createAsync(
        PageContext<ListActiveDirectoriesRequest, ListActiveDirectoriesResponse, ActiveDirectory>
            context,
        ApiFuture<ListActiveDirectoriesResponse> futureResponse) {
      ApiFuture<ListActiveDirectoriesPage> futurePage =
          ListActiveDirectoriesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListActiveDirectoriesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListActiveDirectoriesPagedResponse(ListActiveDirectoriesPage page) {
      super(page, ListActiveDirectoriesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListActiveDirectoriesPage
      extends AbstractPage<
          ListActiveDirectoriesRequest,
          ListActiveDirectoriesResponse,
          ActiveDirectory,
          ListActiveDirectoriesPage> {

    private ListActiveDirectoriesPage(
        PageContext<ListActiveDirectoriesRequest, ListActiveDirectoriesResponse, ActiveDirectory>
            context,
        ListActiveDirectoriesResponse response) {
      super(context, response);
    }

    private static ListActiveDirectoriesPage createEmptyPage() {
      return new ListActiveDirectoriesPage(null, null);
    }

    @Override
    protected ListActiveDirectoriesPage createPage(
        PageContext<ListActiveDirectoriesRequest, ListActiveDirectoriesResponse, ActiveDirectory>
            context,
        ListActiveDirectoriesResponse response) {
      return new ListActiveDirectoriesPage(context, response);
    }

    @Override
    public ApiFuture<ListActiveDirectoriesPage> createPageAsync(
        PageContext<ListActiveDirectoriesRequest, ListActiveDirectoriesResponse, ActiveDirectory>
            context,
        ApiFuture<ListActiveDirectoriesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListActiveDirectoriesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListActiveDirectoriesRequest,
          ListActiveDirectoriesResponse,
          ActiveDirectory,
          ListActiveDirectoriesPage,
          ListActiveDirectoriesFixedSizeCollection> {

    private ListActiveDirectoriesFixedSizeCollection(
        List<ListActiveDirectoriesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListActiveDirectoriesFixedSizeCollection createEmptyCollection() {
      return new ListActiveDirectoriesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListActiveDirectoriesFixedSizeCollection createCollection(
        List<ListActiveDirectoriesPage> pages, int collectionSize) {
      return new ListActiveDirectoriesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListKmsConfigsPagedResponse
      extends AbstractPagedListResponse<
          ListKmsConfigsRequest,
          ListKmsConfigsResponse,
          KmsConfig,
          ListKmsConfigsPage,
          ListKmsConfigsFixedSizeCollection> {

    public static ApiFuture<ListKmsConfigsPagedResponse> createAsync(
        PageContext<ListKmsConfigsRequest, ListKmsConfigsResponse, KmsConfig> context,
        ApiFuture<ListKmsConfigsResponse> futureResponse) {
      ApiFuture<ListKmsConfigsPage> futurePage =
          ListKmsConfigsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListKmsConfigsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListKmsConfigsPagedResponse(ListKmsConfigsPage page) {
      super(page, ListKmsConfigsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListKmsConfigsPage
      extends AbstractPage<
          ListKmsConfigsRequest, ListKmsConfigsResponse, KmsConfig, ListKmsConfigsPage> {

    private ListKmsConfigsPage(
        PageContext<ListKmsConfigsRequest, ListKmsConfigsResponse, KmsConfig> context,
        ListKmsConfigsResponse response) {
      super(context, response);
    }

    private static ListKmsConfigsPage createEmptyPage() {
      return new ListKmsConfigsPage(null, null);
    }

    @Override
    protected ListKmsConfigsPage createPage(
        PageContext<ListKmsConfigsRequest, ListKmsConfigsResponse, KmsConfig> context,
        ListKmsConfigsResponse response) {
      return new ListKmsConfigsPage(context, response);
    }

    @Override
    public ApiFuture<ListKmsConfigsPage> createPageAsync(
        PageContext<ListKmsConfigsRequest, ListKmsConfigsResponse, KmsConfig> context,
        ApiFuture<ListKmsConfigsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListKmsConfigsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListKmsConfigsRequest,
          ListKmsConfigsResponse,
          KmsConfig,
          ListKmsConfigsPage,
          ListKmsConfigsFixedSizeCollection> {

    private ListKmsConfigsFixedSizeCollection(List<ListKmsConfigsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListKmsConfigsFixedSizeCollection createEmptyCollection() {
      return new ListKmsConfigsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListKmsConfigsFixedSizeCollection createCollection(
        List<ListKmsConfigsPage> pages, int collectionSize) {
      return new ListKmsConfigsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListReplicationsPagedResponse
      extends AbstractPagedListResponse<
          ListReplicationsRequest,
          ListReplicationsResponse,
          Replication,
          ListReplicationsPage,
          ListReplicationsFixedSizeCollection> {

    public static ApiFuture<ListReplicationsPagedResponse> createAsync(
        PageContext<ListReplicationsRequest, ListReplicationsResponse, Replication> context,
        ApiFuture<ListReplicationsResponse> futureResponse) {
      ApiFuture<ListReplicationsPage> futurePage =
          ListReplicationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListReplicationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListReplicationsPagedResponse(ListReplicationsPage page) {
      super(page, ListReplicationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListReplicationsPage
      extends AbstractPage<
          ListReplicationsRequest, ListReplicationsResponse, Replication, ListReplicationsPage> {

    private ListReplicationsPage(
        PageContext<ListReplicationsRequest, ListReplicationsResponse, Replication> context,
        ListReplicationsResponse response) {
      super(context, response);
    }

    private static ListReplicationsPage createEmptyPage() {
      return new ListReplicationsPage(null, null);
    }

    @Override
    protected ListReplicationsPage createPage(
        PageContext<ListReplicationsRequest, ListReplicationsResponse, Replication> context,
        ListReplicationsResponse response) {
      return new ListReplicationsPage(context, response);
    }

    @Override
    public ApiFuture<ListReplicationsPage> createPageAsync(
        PageContext<ListReplicationsRequest, ListReplicationsResponse, Replication> context,
        ApiFuture<ListReplicationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListReplicationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListReplicationsRequest,
          ListReplicationsResponse,
          Replication,
          ListReplicationsPage,
          ListReplicationsFixedSizeCollection> {

    private ListReplicationsFixedSizeCollection(
        List<ListReplicationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListReplicationsFixedSizeCollection createEmptyCollection() {
      return new ListReplicationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListReplicationsFixedSizeCollection createCollection(
        List<ListReplicationsPage> pages, int collectionSize) {
      return new ListReplicationsFixedSizeCollection(pages, collectionSize);
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
