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

package com.google.cloud.gkebackup.v1;

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
import com.google.cloud.gkebackup.v1.stub.BackupForGKEStub;
import com.google.cloud.gkebackup.v1.stub.BackupForGKEStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
 * Service Description: BackupForGKE allows Kubernetes administrators to configure, execute, and
 * manage backup and restore operations for their GKE clusters.
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
 * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
 *   BackupPlanName name = BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]");
 *   BackupPlan response = backupForGKEClient.getBackupPlan(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the BackupForGKEClient object to clean up resources such
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
 *      <td><p> CreateBackupPlan</td>
 *      <td><p> Creates a new BackupPlan in a given location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createBackupPlanAsync(CreateBackupPlanRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createBackupPlanAsync(LocationName parent, BackupPlan backupPlan, String backupPlanId)
 *           <li><p> createBackupPlanAsync(String parent, BackupPlan backupPlan, String backupPlanId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createBackupPlanOperationCallable()
 *           <li><p> createBackupPlanCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListBackupPlans</td>
 *      <td><p> Lists BackupPlans in a given location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listBackupPlans(ListBackupPlansRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listBackupPlans(LocationName parent)
 *           <li><p> listBackupPlans(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listBackupPlansPagedCallable()
 *           <li><p> listBackupPlansCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetBackupPlan</td>
 *      <td><p> Retrieve the details of a single BackupPlan.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getBackupPlan(GetBackupPlanRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getBackupPlan(BackupPlanName name)
 *           <li><p> getBackupPlan(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getBackupPlanCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateBackupPlan</td>
 *      <td><p> Update a BackupPlan.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateBackupPlanAsync(UpdateBackupPlanRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateBackupPlanAsync(BackupPlan backupPlan, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateBackupPlanOperationCallable()
 *           <li><p> updateBackupPlanCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteBackupPlan</td>
 *      <td><p> Deletes an existing BackupPlan.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteBackupPlanAsync(DeleteBackupPlanRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteBackupPlanAsync(BackupPlanName name)
 *           <li><p> deleteBackupPlanAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteBackupPlanOperationCallable()
 *           <li><p> deleteBackupPlanCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateBackupChannel</td>
 *      <td><p> Creates a new BackupChannel in a given location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createBackupChannelAsync(CreateBackupChannelRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createBackupChannelAsync(LocationName parent, BackupChannel backupChannel, String backupChannelId)
 *           <li><p> createBackupChannelAsync(String parent, BackupChannel backupChannel, String backupChannelId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createBackupChannelOperationCallable()
 *           <li><p> createBackupChannelCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListBackupChannels</td>
 *      <td><p> Lists BackupChannels in a given location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listBackupChannels(ListBackupChannelsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listBackupChannels(LocationName parent)
 *           <li><p> listBackupChannels(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listBackupChannelsPagedCallable()
 *           <li><p> listBackupChannelsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetBackupChannel</td>
 *      <td><p> Retrieve the details of a single BackupChannel.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getBackupChannel(GetBackupChannelRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getBackupChannel(BackupChannelName name)
 *           <li><p> getBackupChannel(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getBackupChannelCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateBackupChannel</td>
 *      <td><p> Update a BackupChannel.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateBackupChannelAsync(UpdateBackupChannelRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateBackupChannelAsync(BackupChannel backupChannel, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateBackupChannelOperationCallable()
 *           <li><p> updateBackupChannelCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteBackupChannel</td>
 *      <td><p> Deletes an existing BackupChannel.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteBackupChannelAsync(DeleteBackupChannelRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteBackupChannelAsync(BackupChannelName name)
 *           <li><p> deleteBackupChannelAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteBackupChannelOperationCallable()
 *           <li><p> deleteBackupChannelCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListBackupPlanBindings</td>
 *      <td><p> Lists BackupPlanBindings in a given location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listBackupPlanBindings(ListBackupPlanBindingsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listBackupPlanBindings(BackupChannelName parent)
 *           <li><p> listBackupPlanBindings(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listBackupPlanBindingsPagedCallable()
 *           <li><p> listBackupPlanBindingsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetBackupPlanBinding</td>
 *      <td><p> Retrieve the details of a single BackupPlanBinding.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getBackupPlanBinding(GetBackupPlanBindingRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getBackupPlanBinding(BackupPlanBindingName name)
 *           <li><p> getBackupPlanBinding(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getBackupPlanBindingCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateBackup</td>
 *      <td><p> Creates a Backup for the given BackupPlan.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createBackupAsync(CreateBackupRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createBackupAsync(BackupPlanName parent, Backup backup, String backupId)
 *           <li><p> createBackupAsync(String parent, Backup backup, String backupId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createBackupOperationCallable()
 *           <li><p> createBackupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListBackups</td>
 *      <td><p> Lists the Backups for a given BackupPlan.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listBackups(ListBackupsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listBackups(BackupPlanName parent)
 *           <li><p> listBackups(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listBackupsPagedCallable()
 *           <li><p> listBackupsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetBackup</td>
 *      <td><p> Retrieve the details of a single Backup.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getBackup(GetBackupRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getBackup(BackupName name)
 *           <li><p> getBackup(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getBackupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateBackup</td>
 *      <td><p> Update a Backup.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateBackupAsync(UpdateBackupRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateBackupAsync(Backup backup, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateBackupOperationCallable()
 *           <li><p> updateBackupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteBackup</td>
 *      <td><p> Deletes an existing Backup.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteBackupAsync(DeleteBackupRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteBackupAsync(BackupName name)
 *           <li><p> deleteBackupAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteBackupOperationCallable()
 *           <li><p> deleteBackupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListVolumeBackups</td>
 *      <td><p> Lists the VolumeBackups for a given Backup.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listVolumeBackups(ListVolumeBackupsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listVolumeBackups(BackupName parent)
 *           <li><p> listVolumeBackups(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listVolumeBackupsPagedCallable()
 *           <li><p> listVolumeBackupsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetVolumeBackup</td>
 *      <td><p> Retrieve the details of a single VolumeBackup.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getVolumeBackup(GetVolumeBackupRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getVolumeBackup(VolumeBackupName name)
 *           <li><p> getVolumeBackup(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getVolumeBackupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateRestorePlan</td>
 *      <td><p> Creates a new RestorePlan in a given location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createRestorePlanAsync(CreateRestorePlanRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createRestorePlanAsync(LocationName parent, RestorePlan restorePlan, String restorePlanId)
 *           <li><p> createRestorePlanAsync(String parent, RestorePlan restorePlan, String restorePlanId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createRestorePlanOperationCallable()
 *           <li><p> createRestorePlanCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListRestorePlans</td>
 *      <td><p> Lists RestorePlans in a given location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listRestorePlans(ListRestorePlansRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listRestorePlans(LocationName parent)
 *           <li><p> listRestorePlans(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listRestorePlansPagedCallable()
 *           <li><p> listRestorePlansCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetRestorePlan</td>
 *      <td><p> Retrieve the details of a single RestorePlan.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getRestorePlan(GetRestorePlanRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getRestorePlan(RestorePlanName name)
 *           <li><p> getRestorePlan(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getRestorePlanCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateRestorePlan</td>
 *      <td><p> Update a RestorePlan.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateRestorePlanAsync(UpdateRestorePlanRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateRestorePlanAsync(RestorePlan restorePlan, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateRestorePlanOperationCallable()
 *           <li><p> updateRestorePlanCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteRestorePlan</td>
 *      <td><p> Deletes an existing RestorePlan.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteRestorePlanAsync(DeleteRestorePlanRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteRestorePlanAsync(RestorePlanName name)
 *           <li><p> deleteRestorePlanAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteRestorePlanOperationCallable()
 *           <li><p> deleteRestorePlanCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateRestoreChannel</td>
 *      <td><p> Creates a new RestoreChannel in a given location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createRestoreChannelAsync(CreateRestoreChannelRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createRestoreChannelAsync(LocationName parent, RestoreChannel restoreChannel, String restoreChannelId)
 *           <li><p> createRestoreChannelAsync(String parent, RestoreChannel restoreChannel, String restoreChannelId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createRestoreChannelOperationCallable()
 *           <li><p> createRestoreChannelCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListRestoreChannels</td>
 *      <td><p> Lists RestoreChannels in a given location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listRestoreChannels(ListRestoreChannelsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listRestoreChannels(LocationName parent)
 *           <li><p> listRestoreChannels(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listRestoreChannelsPagedCallable()
 *           <li><p> listRestoreChannelsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetRestoreChannel</td>
 *      <td><p> Retrieve the details of a single RestoreChannel.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getRestoreChannel(GetRestoreChannelRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getRestoreChannel(RestoreChannelName name)
 *           <li><p> getRestoreChannel(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getRestoreChannelCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateRestoreChannel</td>
 *      <td><p> Update a RestoreChannel.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateRestoreChannelAsync(UpdateRestoreChannelRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateRestoreChannelAsync(RestoreChannel restoreChannel, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateRestoreChannelOperationCallable()
 *           <li><p> updateRestoreChannelCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteRestoreChannel</td>
 *      <td><p> Deletes an existing RestoreChannel.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteRestoreChannelAsync(DeleteRestoreChannelRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteRestoreChannelAsync(RestoreChannelName name)
 *           <li><p> deleteRestoreChannelAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteRestoreChannelOperationCallable()
 *           <li><p> deleteRestoreChannelCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListRestorePlanBindings</td>
 *      <td><p> Lists RestorePlanBindings in a given location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listRestorePlanBindings(ListRestorePlanBindingsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listRestorePlanBindings(RestoreChannelName parent)
 *           <li><p> listRestorePlanBindings(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listRestorePlanBindingsPagedCallable()
 *           <li><p> listRestorePlanBindingsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetRestorePlanBinding</td>
 *      <td><p> Retrieve the details of a single RestorePlanBinding.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getRestorePlanBinding(GetRestorePlanBindingRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getRestorePlanBinding(RestorePlanBindingName name)
 *           <li><p> getRestorePlanBinding(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getRestorePlanBindingCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateRestore</td>
 *      <td><p> Creates a new Restore for the given RestorePlan.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createRestoreAsync(CreateRestoreRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createRestoreAsync(RestorePlanName parent, Restore restore, String restoreId)
 *           <li><p> createRestoreAsync(String parent, Restore restore, String restoreId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createRestoreOperationCallable()
 *           <li><p> createRestoreCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListRestores</td>
 *      <td><p> Lists the Restores for a given RestorePlan.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listRestores(ListRestoresRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listRestores(RestorePlanName parent)
 *           <li><p> listRestores(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listRestoresPagedCallable()
 *           <li><p> listRestoresCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetRestore</td>
 *      <td><p> Retrieves the details of a single Restore.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getRestore(GetRestoreRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getRestore(RestoreName name)
 *           <li><p> getRestore(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getRestoreCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateRestore</td>
 *      <td><p> Update a Restore.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateRestoreAsync(UpdateRestoreRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateRestoreAsync(Restore restore, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateRestoreOperationCallable()
 *           <li><p> updateRestoreCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteRestore</td>
 *      <td><p> Deletes an existing Restore.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteRestoreAsync(DeleteRestoreRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteRestoreAsync(RestoreName name)
 *           <li><p> deleteRestoreAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteRestoreOperationCallable()
 *           <li><p> deleteRestoreCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListVolumeRestores</td>
 *      <td><p> Lists the VolumeRestores for a given Restore.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listVolumeRestores(ListVolumeRestoresRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listVolumeRestores(RestoreName parent)
 *           <li><p> listVolumeRestores(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listVolumeRestoresPagedCallable()
 *           <li><p> listVolumeRestoresCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetVolumeRestore</td>
 *      <td><p> Retrieve the details of a single VolumeRestore.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getVolumeRestore(GetVolumeRestoreRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getVolumeRestore(VolumeRestoreName name)
 *           <li><p> getVolumeRestore(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getVolumeRestoreCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetBackupIndexDownloadUrl</td>
 *      <td><p> Retrieve the link to the backupIndex.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getBackupIndexDownloadUrl(GetBackupIndexDownloadUrlRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getBackupIndexDownloadUrl(BackupName backup)
 *           <li><p> getBackupIndexDownloadUrl(String backup)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getBackupIndexDownloadUrlCallable()
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
 * <p>This class can be customized by passing in a custom instance of BackupForGKESettings to
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
 * BackupForGKESettings backupForGKESettings =
 *     BackupForGKESettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * BackupForGKEClient backupForGKEClient = BackupForGKEClient.create(backupForGKESettings);
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
 * BackupForGKESettings backupForGKESettings =
 *     BackupForGKESettings.newBuilder().setEndpoint(myEndpoint).build();
 * BackupForGKEClient backupForGKEClient = BackupForGKEClient.create(backupForGKESettings);
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
 * BackupForGKESettings backupForGKESettings = BackupForGKESettings.newHttpJsonBuilder().build();
 * BackupForGKEClient backupForGKEClient = BackupForGKEClient.create(backupForGKESettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class BackupForGKEClient implements BackgroundResource {
  private final BackupForGKESettings settings;
  private final BackupForGKEStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of BackupForGKEClient with default settings. */
  public static final BackupForGKEClient create() throws IOException {
    return create(BackupForGKESettings.newBuilder().build());
  }

  /**
   * Constructs an instance of BackupForGKEClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final BackupForGKEClient create(BackupForGKESettings settings) throws IOException {
    return new BackupForGKEClient(settings);
  }

  /**
   * Constructs an instance of BackupForGKEClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(BackupForGKESettings).
   */
  public static final BackupForGKEClient create(BackupForGKEStub stub) {
    return new BackupForGKEClient(stub);
  }

  /**
   * Constructs an instance of BackupForGKEClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected BackupForGKEClient(BackupForGKESettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((BackupForGKEStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected BackupForGKEClient(BackupForGKEStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final BackupForGKESettings getSettings() {
    return settings;
  }

  public BackupForGKEStub getStub() {
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
   * Creates a new BackupPlan in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   BackupPlan backupPlan = BackupPlan.newBuilder().build();
   *   String backupPlanId = "backupPlanId-84871546";
   *   BackupPlan response =
   *       backupForGKEClient.createBackupPlanAsync(parent, backupPlan, backupPlanId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The location within which to create the BackupPlan. Format:
   *     `projects/&#42;/locations/&#42;`
   * @param backupPlan Required. The BackupPlan resource object to create.
   * @param backupPlanId Required. The client-provided short name for the BackupPlan resource. This
   *     name must:
   *     <p>- be between 1 and 63 characters long (inclusive) - consist of only lower-case ASCII
   *     letters, numbers, and dashes - start with a lower-case letter - end with a lower-case
   *     letter or number - be unique within the set of BackupPlans in this location
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BackupPlan, OperationMetadata> createBackupPlanAsync(
      LocationName parent, BackupPlan backupPlan, String backupPlanId) {
    CreateBackupPlanRequest request =
        CreateBackupPlanRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setBackupPlan(backupPlan)
            .setBackupPlanId(backupPlanId)
            .build();
    return createBackupPlanAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new BackupPlan in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   BackupPlan backupPlan = BackupPlan.newBuilder().build();
   *   String backupPlanId = "backupPlanId-84871546";
   *   BackupPlan response =
   *       backupForGKEClient.createBackupPlanAsync(parent, backupPlan, backupPlanId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The location within which to create the BackupPlan. Format:
   *     `projects/&#42;/locations/&#42;`
   * @param backupPlan Required. The BackupPlan resource object to create.
   * @param backupPlanId Required. The client-provided short name for the BackupPlan resource. This
   *     name must:
   *     <p>- be between 1 and 63 characters long (inclusive) - consist of only lower-case ASCII
   *     letters, numbers, and dashes - start with a lower-case letter - end with a lower-case
   *     letter or number - be unique within the set of BackupPlans in this location
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BackupPlan, OperationMetadata> createBackupPlanAsync(
      String parent, BackupPlan backupPlan, String backupPlanId) {
    CreateBackupPlanRequest request =
        CreateBackupPlanRequest.newBuilder()
            .setParent(parent)
            .setBackupPlan(backupPlan)
            .setBackupPlanId(backupPlanId)
            .build();
    return createBackupPlanAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new BackupPlan in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   CreateBackupPlanRequest request =
   *       CreateBackupPlanRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setBackupPlan(BackupPlan.newBuilder().build())
   *           .setBackupPlanId("backupPlanId-84871546")
   *           .build();
   *   BackupPlan response = backupForGKEClient.createBackupPlanAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BackupPlan, OperationMetadata> createBackupPlanAsync(
      CreateBackupPlanRequest request) {
    return createBackupPlanOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new BackupPlan in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   CreateBackupPlanRequest request =
   *       CreateBackupPlanRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setBackupPlan(BackupPlan.newBuilder().build())
   *           .setBackupPlanId("backupPlanId-84871546")
   *           .build();
   *   OperationFuture<BackupPlan, OperationMetadata> future =
   *       backupForGKEClient.createBackupPlanOperationCallable().futureCall(request);
   *   // Do something.
   *   BackupPlan response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateBackupPlanRequest, BackupPlan, OperationMetadata>
      createBackupPlanOperationCallable() {
    return stub.createBackupPlanOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new BackupPlan in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   CreateBackupPlanRequest request =
   *       CreateBackupPlanRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setBackupPlan(BackupPlan.newBuilder().build())
   *           .setBackupPlanId("backupPlanId-84871546")
   *           .build();
   *   ApiFuture<Operation> future =
   *       backupForGKEClient.createBackupPlanCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateBackupPlanRequest, Operation> createBackupPlanCallable() {
    return stub.createBackupPlanCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists BackupPlans in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (BackupPlan element : backupForGKEClient.listBackupPlans(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The location that contains the BackupPlans to list. Format:
   *     `projects/&#42;/locations/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupPlansPagedResponse listBackupPlans(LocationName parent) {
    ListBackupPlansRequest request =
        ListBackupPlansRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listBackupPlans(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists BackupPlans in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (BackupPlan element : backupForGKEClient.listBackupPlans(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The location that contains the BackupPlans to list. Format:
   *     `projects/&#42;/locations/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupPlansPagedResponse listBackupPlans(String parent) {
    ListBackupPlansRequest request = ListBackupPlansRequest.newBuilder().setParent(parent).build();
    return listBackupPlans(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists BackupPlans in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   ListBackupPlansRequest request =
   *       ListBackupPlansRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (BackupPlan element : backupForGKEClient.listBackupPlans(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupPlansPagedResponse listBackupPlans(ListBackupPlansRequest request) {
    return listBackupPlansPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists BackupPlans in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   ListBackupPlansRequest request =
   *       ListBackupPlansRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<BackupPlan> future =
   *       backupForGKEClient.listBackupPlansPagedCallable().futureCall(request);
   *   // Do something.
   *   for (BackupPlan element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListBackupPlansRequest, ListBackupPlansPagedResponse>
      listBackupPlansPagedCallable() {
    return stub.listBackupPlansPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists BackupPlans in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   ListBackupPlansRequest request =
   *       ListBackupPlansRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListBackupPlansResponse response =
   *         backupForGKEClient.listBackupPlansCallable().call(request);
   *     for (BackupPlan element : response.getBackupPlansList()) {
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
  public final UnaryCallable<ListBackupPlansRequest, ListBackupPlansResponse>
      listBackupPlansCallable() {
    return stub.listBackupPlansCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the details of a single BackupPlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   BackupPlanName name = BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]");
   *   BackupPlan response = backupForGKEClient.getBackupPlan(name);
   * }
   * }</pre>
   *
   * @param name Required. Fully qualified BackupPlan name. Format:
   *     `projects/&#42;/locations/&#42;/backupPlans/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BackupPlan getBackupPlan(BackupPlanName name) {
    GetBackupPlanRequest request =
        GetBackupPlanRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getBackupPlan(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the details of a single BackupPlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   String name = BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString();
   *   BackupPlan response = backupForGKEClient.getBackupPlan(name);
   * }
   * }</pre>
   *
   * @param name Required. Fully qualified BackupPlan name. Format:
   *     `projects/&#42;/locations/&#42;/backupPlans/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BackupPlan getBackupPlan(String name) {
    GetBackupPlanRequest request = GetBackupPlanRequest.newBuilder().setName(name).build();
    return getBackupPlan(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the details of a single BackupPlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   GetBackupPlanRequest request =
   *       GetBackupPlanRequest.newBuilder()
   *           .setName(BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString())
   *           .build();
   *   BackupPlan response = backupForGKEClient.getBackupPlan(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BackupPlan getBackupPlan(GetBackupPlanRequest request) {
    return getBackupPlanCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the details of a single BackupPlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   GetBackupPlanRequest request =
   *       GetBackupPlanRequest.newBuilder()
   *           .setName(BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString())
   *           .build();
   *   ApiFuture<BackupPlan> future = backupForGKEClient.getBackupPlanCallable().futureCall(request);
   *   // Do something.
   *   BackupPlan response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetBackupPlanRequest, BackupPlan> getBackupPlanCallable() {
    return stub.getBackupPlanCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a BackupPlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   BackupPlan backupPlan = BackupPlan.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   BackupPlan response = backupForGKEClient.updateBackupPlanAsync(backupPlan, updateMask).get();
   * }
   * }</pre>
   *
   * @param backupPlan Required. A new version of the BackupPlan resource that contains updated
   *     fields. This may be sparsely populated if an `update_mask` is provided.
   * @param updateMask Optional. This is used to specify the fields to be overwritten in the
   *     BackupPlan targeted for update. The values for each of these updated fields will be taken
   *     from the `backup_plan` provided with this request. Field names are relative to the root of
   *     the resource (e.g., `description`, `backup_config.include_volume_data`, etc.) If no
   *     `update_mask` is provided, all fields in `backup_plan` will be written to the target
   *     BackupPlan resource. Note that OUTPUT_ONLY and IMMUTABLE fields in `backup_plan` are
   *     ignored and are not used to update the target BackupPlan.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BackupPlan, OperationMetadata> updateBackupPlanAsync(
      BackupPlan backupPlan, FieldMask updateMask) {
    UpdateBackupPlanRequest request =
        UpdateBackupPlanRequest.newBuilder()
            .setBackupPlan(backupPlan)
            .setUpdateMask(updateMask)
            .build();
    return updateBackupPlanAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a BackupPlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   UpdateBackupPlanRequest request =
   *       UpdateBackupPlanRequest.newBuilder()
   *           .setBackupPlan(BackupPlan.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   BackupPlan response = backupForGKEClient.updateBackupPlanAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BackupPlan, OperationMetadata> updateBackupPlanAsync(
      UpdateBackupPlanRequest request) {
    return updateBackupPlanOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a BackupPlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   UpdateBackupPlanRequest request =
   *       UpdateBackupPlanRequest.newBuilder()
   *           .setBackupPlan(BackupPlan.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<BackupPlan, OperationMetadata> future =
   *       backupForGKEClient.updateBackupPlanOperationCallable().futureCall(request);
   *   // Do something.
   *   BackupPlan response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateBackupPlanRequest, BackupPlan, OperationMetadata>
      updateBackupPlanOperationCallable() {
    return stub.updateBackupPlanOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a BackupPlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   UpdateBackupPlanRequest request =
   *       UpdateBackupPlanRequest.newBuilder()
   *           .setBackupPlan(BackupPlan.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       backupForGKEClient.updateBackupPlanCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateBackupPlanRequest, Operation> updateBackupPlanCallable() {
    return stub.updateBackupPlanCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing BackupPlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   BackupPlanName name = BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]");
   *   backupForGKEClient.deleteBackupPlanAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Fully qualified BackupPlan name. Format:
   *     `projects/&#42;/locations/&#42;/backupPlans/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteBackupPlanAsync(
      BackupPlanName name) {
    DeleteBackupPlanRequest request =
        DeleteBackupPlanRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteBackupPlanAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing BackupPlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   String name = BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString();
   *   backupForGKEClient.deleteBackupPlanAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Fully qualified BackupPlan name. Format:
   *     `projects/&#42;/locations/&#42;/backupPlans/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteBackupPlanAsync(String name) {
    DeleteBackupPlanRequest request = DeleteBackupPlanRequest.newBuilder().setName(name).build();
    return deleteBackupPlanAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing BackupPlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   DeleteBackupPlanRequest request =
   *       DeleteBackupPlanRequest.newBuilder()
   *           .setName(BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   backupForGKEClient.deleteBackupPlanAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteBackupPlanAsync(
      DeleteBackupPlanRequest request) {
    return deleteBackupPlanOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing BackupPlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   DeleteBackupPlanRequest request =
   *       DeleteBackupPlanRequest.newBuilder()
   *           .setName(BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       backupForGKEClient.deleteBackupPlanOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteBackupPlanRequest, Empty, OperationMetadata>
      deleteBackupPlanOperationCallable() {
    return stub.deleteBackupPlanOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing BackupPlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   DeleteBackupPlanRequest request =
   *       DeleteBackupPlanRequest.newBuilder()
   *           .setName(BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future =
   *       backupForGKEClient.deleteBackupPlanCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteBackupPlanRequest, Operation> deleteBackupPlanCallable() {
    return stub.deleteBackupPlanCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new BackupChannel in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   BackupChannel backupChannel = BackupChannel.newBuilder().build();
   *   String backupChannelId = "backupChannelId707614172";
   *   BackupChannel response =
   *       backupForGKEClient.createBackupChannelAsync(parent, backupChannel, backupChannelId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The location within which to create the BackupChannel. Format:
   *     `projects/&#42;/locations/&#42;`
   * @param backupChannel Required. The BackupChannel resource object to create.
   * @param backupChannelId Optional. The client-provided short name for the BackupChannel resource.
   *     This name must:
   *     <p>- be between 1 and 63 characters long (inclusive) - consist of only lower-case ASCII
   *     letters, numbers, and dashes - start with a lower-case letter - end with a lower-case
   *     letter or number - be unique within the set of BackupChannels in this location If the user
   *     does not provide a name, a uuid will be used as the name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BackupChannel, OperationMetadata> createBackupChannelAsync(
      LocationName parent, BackupChannel backupChannel, String backupChannelId) {
    CreateBackupChannelRequest request =
        CreateBackupChannelRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setBackupChannel(backupChannel)
            .setBackupChannelId(backupChannelId)
            .build();
    return createBackupChannelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new BackupChannel in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   BackupChannel backupChannel = BackupChannel.newBuilder().build();
   *   String backupChannelId = "backupChannelId707614172";
   *   BackupChannel response =
   *       backupForGKEClient.createBackupChannelAsync(parent, backupChannel, backupChannelId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The location within which to create the BackupChannel. Format:
   *     `projects/&#42;/locations/&#42;`
   * @param backupChannel Required. The BackupChannel resource object to create.
   * @param backupChannelId Optional. The client-provided short name for the BackupChannel resource.
   *     This name must:
   *     <p>- be between 1 and 63 characters long (inclusive) - consist of only lower-case ASCII
   *     letters, numbers, and dashes - start with a lower-case letter - end with a lower-case
   *     letter or number - be unique within the set of BackupChannels in this location If the user
   *     does not provide a name, a uuid will be used as the name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BackupChannel, OperationMetadata> createBackupChannelAsync(
      String parent, BackupChannel backupChannel, String backupChannelId) {
    CreateBackupChannelRequest request =
        CreateBackupChannelRequest.newBuilder()
            .setParent(parent)
            .setBackupChannel(backupChannel)
            .setBackupChannelId(backupChannelId)
            .build();
    return createBackupChannelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new BackupChannel in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   CreateBackupChannelRequest request =
   *       CreateBackupChannelRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setBackupChannel(BackupChannel.newBuilder().build())
   *           .setBackupChannelId("backupChannelId707614172")
   *           .build();
   *   BackupChannel response = backupForGKEClient.createBackupChannelAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BackupChannel, OperationMetadata> createBackupChannelAsync(
      CreateBackupChannelRequest request) {
    return createBackupChannelOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new BackupChannel in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   CreateBackupChannelRequest request =
   *       CreateBackupChannelRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setBackupChannel(BackupChannel.newBuilder().build())
   *           .setBackupChannelId("backupChannelId707614172")
   *           .build();
   *   OperationFuture<BackupChannel, OperationMetadata> future =
   *       backupForGKEClient.createBackupChannelOperationCallable().futureCall(request);
   *   // Do something.
   *   BackupChannel response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateBackupChannelRequest, BackupChannel, OperationMetadata>
      createBackupChannelOperationCallable() {
    return stub.createBackupChannelOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new BackupChannel in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   CreateBackupChannelRequest request =
   *       CreateBackupChannelRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setBackupChannel(BackupChannel.newBuilder().build())
   *           .setBackupChannelId("backupChannelId707614172")
   *           .build();
   *   ApiFuture<Operation> future =
   *       backupForGKEClient.createBackupChannelCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateBackupChannelRequest, Operation> createBackupChannelCallable() {
    return stub.createBackupChannelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists BackupChannels in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (BackupChannel element : backupForGKEClient.listBackupChannels(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The location that contains the BackupChannels to list. Format:
   *     `projects/&#42;/locations/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupChannelsPagedResponse listBackupChannels(LocationName parent) {
    ListBackupChannelsRequest request =
        ListBackupChannelsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listBackupChannels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists BackupChannels in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (BackupChannel element : backupForGKEClient.listBackupChannels(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The location that contains the BackupChannels to list. Format:
   *     `projects/&#42;/locations/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupChannelsPagedResponse listBackupChannels(String parent) {
    ListBackupChannelsRequest request =
        ListBackupChannelsRequest.newBuilder().setParent(parent).build();
    return listBackupChannels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists BackupChannels in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   ListBackupChannelsRequest request =
   *       ListBackupChannelsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (BackupChannel element : backupForGKEClient.listBackupChannels(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupChannelsPagedResponse listBackupChannels(
      ListBackupChannelsRequest request) {
    return listBackupChannelsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists BackupChannels in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   ListBackupChannelsRequest request =
   *       ListBackupChannelsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<BackupChannel> future =
   *       backupForGKEClient.listBackupChannelsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (BackupChannel element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListBackupChannelsRequest, ListBackupChannelsPagedResponse>
      listBackupChannelsPagedCallable() {
    return stub.listBackupChannelsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists BackupChannels in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   ListBackupChannelsRequest request =
   *       ListBackupChannelsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListBackupChannelsResponse response =
   *         backupForGKEClient.listBackupChannelsCallable().call(request);
   *     for (BackupChannel element : response.getBackupChannelsList()) {
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
  public final UnaryCallable<ListBackupChannelsRequest, ListBackupChannelsResponse>
      listBackupChannelsCallable() {
    return stub.listBackupChannelsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the details of a single BackupChannel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   BackupChannelName name = BackupChannelName.of("[PROJECT]", "[LOCATION]", "[BACKUP_CHANNEL]");
   *   BackupChannel response = backupForGKEClient.getBackupChannel(name);
   * }
   * }</pre>
   *
   * @param name Required. Fully qualified BackupChannel name. Format:
   *     `projects/&#42;/locations/&#42;/backupChannels/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BackupChannel getBackupChannel(BackupChannelName name) {
    GetBackupChannelRequest request =
        GetBackupChannelRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getBackupChannel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the details of a single BackupChannel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   String name = BackupChannelName.of("[PROJECT]", "[LOCATION]", "[BACKUP_CHANNEL]").toString();
   *   BackupChannel response = backupForGKEClient.getBackupChannel(name);
   * }
   * }</pre>
   *
   * @param name Required. Fully qualified BackupChannel name. Format:
   *     `projects/&#42;/locations/&#42;/backupChannels/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BackupChannel getBackupChannel(String name) {
    GetBackupChannelRequest request = GetBackupChannelRequest.newBuilder().setName(name).build();
    return getBackupChannel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the details of a single BackupChannel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   GetBackupChannelRequest request =
   *       GetBackupChannelRequest.newBuilder()
   *           .setName(
   *               BackupChannelName.of("[PROJECT]", "[LOCATION]", "[BACKUP_CHANNEL]").toString())
   *           .build();
   *   BackupChannel response = backupForGKEClient.getBackupChannel(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BackupChannel getBackupChannel(GetBackupChannelRequest request) {
    return getBackupChannelCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the details of a single BackupChannel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   GetBackupChannelRequest request =
   *       GetBackupChannelRequest.newBuilder()
   *           .setName(
   *               BackupChannelName.of("[PROJECT]", "[LOCATION]", "[BACKUP_CHANNEL]").toString())
   *           .build();
   *   ApiFuture<BackupChannel> future =
   *       backupForGKEClient.getBackupChannelCallable().futureCall(request);
   *   // Do something.
   *   BackupChannel response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetBackupChannelRequest, BackupChannel> getBackupChannelCallable() {
    return stub.getBackupChannelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a BackupChannel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   BackupChannel backupChannel = BackupChannel.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   BackupChannel response =
   *       backupForGKEClient.updateBackupChannelAsync(backupChannel, updateMask).get();
   * }
   * }</pre>
   *
   * @param backupChannel Required. A new version of the BackupChannel resource that contains
   *     updated fields. This may be sparsely populated if an `update_mask` is provided.
   * @param updateMask Optional. This is used to specify the fields to be overwritten in the
   *     BackupChannel targeted for update. The values for each of these updated fields will be
   *     taken from the `backup_channel` provided with this request. Field names are relative to the
   *     root of the resource (e.g., `description`, `labels`, etc.) If no `update_mask` is provided,
   *     all fields in `backup_channel` will be written to the target BackupChannel resource. Note
   *     that OUTPUT_ONLY and IMMUTABLE fields in `backup_channel` are ignored and are not used to
   *     update the target BackupChannel.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BackupChannel, OperationMetadata> updateBackupChannelAsync(
      BackupChannel backupChannel, FieldMask updateMask) {
    UpdateBackupChannelRequest request =
        UpdateBackupChannelRequest.newBuilder()
            .setBackupChannel(backupChannel)
            .setUpdateMask(updateMask)
            .build();
    return updateBackupChannelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a BackupChannel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   UpdateBackupChannelRequest request =
   *       UpdateBackupChannelRequest.newBuilder()
   *           .setBackupChannel(BackupChannel.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   BackupChannel response = backupForGKEClient.updateBackupChannelAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BackupChannel, OperationMetadata> updateBackupChannelAsync(
      UpdateBackupChannelRequest request) {
    return updateBackupChannelOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a BackupChannel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   UpdateBackupChannelRequest request =
   *       UpdateBackupChannelRequest.newBuilder()
   *           .setBackupChannel(BackupChannel.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<BackupChannel, OperationMetadata> future =
   *       backupForGKEClient.updateBackupChannelOperationCallable().futureCall(request);
   *   // Do something.
   *   BackupChannel response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateBackupChannelRequest, BackupChannel, OperationMetadata>
      updateBackupChannelOperationCallable() {
    return stub.updateBackupChannelOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a BackupChannel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   UpdateBackupChannelRequest request =
   *       UpdateBackupChannelRequest.newBuilder()
   *           .setBackupChannel(BackupChannel.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       backupForGKEClient.updateBackupChannelCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateBackupChannelRequest, Operation> updateBackupChannelCallable() {
    return stub.updateBackupChannelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing BackupChannel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   BackupChannelName name = BackupChannelName.of("[PROJECT]", "[LOCATION]", "[BACKUP_CHANNEL]");
   *   backupForGKEClient.deleteBackupChannelAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Fully qualified BackupChannel name. Format:
   *     `projects/&#42;/locations/&#42;/backupChannels/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteBackupChannelAsync(
      BackupChannelName name) {
    DeleteBackupChannelRequest request =
        DeleteBackupChannelRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteBackupChannelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing BackupChannel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   String name = BackupChannelName.of("[PROJECT]", "[LOCATION]", "[BACKUP_CHANNEL]").toString();
   *   backupForGKEClient.deleteBackupChannelAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Fully qualified BackupChannel name. Format:
   *     `projects/&#42;/locations/&#42;/backupChannels/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteBackupChannelAsync(String name) {
    DeleteBackupChannelRequest request =
        DeleteBackupChannelRequest.newBuilder().setName(name).build();
    return deleteBackupChannelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing BackupChannel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   DeleteBackupChannelRequest request =
   *       DeleteBackupChannelRequest.newBuilder()
   *           .setName(
   *               BackupChannelName.of("[PROJECT]", "[LOCATION]", "[BACKUP_CHANNEL]").toString())
   *           .setEtag("etag3123477")
   *           .setForce(true)
   *           .build();
   *   backupForGKEClient.deleteBackupChannelAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteBackupChannelAsync(
      DeleteBackupChannelRequest request) {
    return deleteBackupChannelOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing BackupChannel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   DeleteBackupChannelRequest request =
   *       DeleteBackupChannelRequest.newBuilder()
   *           .setName(
   *               BackupChannelName.of("[PROJECT]", "[LOCATION]", "[BACKUP_CHANNEL]").toString())
   *           .setEtag("etag3123477")
   *           .setForce(true)
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       backupForGKEClient.deleteBackupChannelOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteBackupChannelRequest, Empty, OperationMetadata>
      deleteBackupChannelOperationCallable() {
    return stub.deleteBackupChannelOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing BackupChannel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   DeleteBackupChannelRequest request =
   *       DeleteBackupChannelRequest.newBuilder()
   *           .setName(
   *               BackupChannelName.of("[PROJECT]", "[LOCATION]", "[BACKUP_CHANNEL]").toString())
   *           .setEtag("etag3123477")
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       backupForGKEClient.deleteBackupChannelCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteBackupChannelRequest, Operation> deleteBackupChannelCallable() {
    return stub.deleteBackupChannelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists BackupPlanBindings in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   BackupChannelName parent =
   *       BackupChannelName.of("[PROJECT]", "[LOCATION]", "[BACKUP_CHANNEL]");
   *   for (BackupPlanBinding element :
   *       backupForGKEClient.listBackupPlanBindings(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The BackupChannel that contains the BackupPlanBindings to list. Format:
   *     `projects/&#42;/locations/&#42;/backupChannels/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupPlanBindingsPagedResponse listBackupPlanBindings(
      BackupChannelName parent) {
    ListBackupPlanBindingsRequest request =
        ListBackupPlanBindingsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listBackupPlanBindings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists BackupPlanBindings in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   String parent =
   *       BackupChannelName.of("[PROJECT]", "[LOCATION]", "[BACKUP_CHANNEL]").toString();
   *   for (BackupPlanBinding element :
   *       backupForGKEClient.listBackupPlanBindings(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The BackupChannel that contains the BackupPlanBindings to list. Format:
   *     `projects/&#42;/locations/&#42;/backupChannels/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupPlanBindingsPagedResponse listBackupPlanBindings(String parent) {
    ListBackupPlanBindingsRequest request =
        ListBackupPlanBindingsRequest.newBuilder().setParent(parent).build();
    return listBackupPlanBindings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists BackupPlanBindings in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   ListBackupPlanBindingsRequest request =
   *       ListBackupPlanBindingsRequest.newBuilder()
   *           .setParent(
   *               BackupChannelName.of("[PROJECT]", "[LOCATION]", "[BACKUP_CHANNEL]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (BackupPlanBinding element :
   *       backupForGKEClient.listBackupPlanBindings(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupPlanBindingsPagedResponse listBackupPlanBindings(
      ListBackupPlanBindingsRequest request) {
    return listBackupPlanBindingsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists BackupPlanBindings in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   ListBackupPlanBindingsRequest request =
   *       ListBackupPlanBindingsRequest.newBuilder()
   *           .setParent(
   *               BackupChannelName.of("[PROJECT]", "[LOCATION]", "[BACKUP_CHANNEL]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<BackupPlanBinding> future =
   *       backupForGKEClient.listBackupPlanBindingsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (BackupPlanBinding element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListBackupPlanBindingsRequest, ListBackupPlanBindingsPagedResponse>
      listBackupPlanBindingsPagedCallable() {
    return stub.listBackupPlanBindingsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists BackupPlanBindings in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   ListBackupPlanBindingsRequest request =
   *       ListBackupPlanBindingsRequest.newBuilder()
   *           .setParent(
   *               BackupChannelName.of("[PROJECT]", "[LOCATION]", "[BACKUP_CHANNEL]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListBackupPlanBindingsResponse response =
   *         backupForGKEClient.listBackupPlanBindingsCallable().call(request);
   *     for (BackupPlanBinding element : response.getBackupPlanBindingsList()) {
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
  public final UnaryCallable<ListBackupPlanBindingsRequest, ListBackupPlanBindingsResponse>
      listBackupPlanBindingsCallable() {
    return stub.listBackupPlanBindingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the details of a single BackupPlanBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   BackupPlanBindingName name =
   *       BackupPlanBindingName.of(
   *           "[PROJECT]", "[LOCATION]", "[BACKUP_CHANNEL]", "[BACKUP_PLAN_BINDING]");
   *   BackupPlanBinding response = backupForGKEClient.getBackupPlanBinding(name);
   * }
   * }</pre>
   *
   * @param name Required. Fully qualified BackupPlanBinding name. Format:
   *     `projects/&#42;/locations/&#42;/backupChannels/&#42;/backupPlanBindings/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BackupPlanBinding getBackupPlanBinding(BackupPlanBindingName name) {
    GetBackupPlanBindingRequest request =
        GetBackupPlanBindingRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getBackupPlanBinding(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the details of a single BackupPlanBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   String name =
   *       BackupPlanBindingName.of(
   *               "[PROJECT]", "[LOCATION]", "[BACKUP_CHANNEL]", "[BACKUP_PLAN_BINDING]")
   *           .toString();
   *   BackupPlanBinding response = backupForGKEClient.getBackupPlanBinding(name);
   * }
   * }</pre>
   *
   * @param name Required. Fully qualified BackupPlanBinding name. Format:
   *     `projects/&#42;/locations/&#42;/backupChannels/&#42;/backupPlanBindings/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BackupPlanBinding getBackupPlanBinding(String name) {
    GetBackupPlanBindingRequest request =
        GetBackupPlanBindingRequest.newBuilder().setName(name).build();
    return getBackupPlanBinding(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the details of a single BackupPlanBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   GetBackupPlanBindingRequest request =
   *       GetBackupPlanBindingRequest.newBuilder()
   *           .setName(
   *               BackupPlanBindingName.of(
   *                       "[PROJECT]", "[LOCATION]", "[BACKUP_CHANNEL]", "[BACKUP_PLAN_BINDING]")
   *                   .toString())
   *           .build();
   *   BackupPlanBinding response = backupForGKEClient.getBackupPlanBinding(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BackupPlanBinding getBackupPlanBinding(GetBackupPlanBindingRequest request) {
    return getBackupPlanBindingCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the details of a single BackupPlanBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   GetBackupPlanBindingRequest request =
   *       GetBackupPlanBindingRequest.newBuilder()
   *           .setName(
   *               BackupPlanBindingName.of(
   *                       "[PROJECT]", "[LOCATION]", "[BACKUP_CHANNEL]", "[BACKUP_PLAN_BINDING]")
   *                   .toString())
   *           .build();
   *   ApiFuture<BackupPlanBinding> future =
   *       backupForGKEClient.getBackupPlanBindingCallable().futureCall(request);
   *   // Do something.
   *   BackupPlanBinding response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetBackupPlanBindingRequest, BackupPlanBinding>
      getBackupPlanBindingCallable() {
    return stub.getBackupPlanBindingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Backup for the given BackupPlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   BackupPlanName parent = BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]");
   *   Backup backup = Backup.newBuilder().build();
   *   String backupId = "backupId2121930365";
   *   Backup response = backupForGKEClient.createBackupAsync(parent, backup, backupId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The BackupPlan within which to create the Backup. Format:
   *     `projects/&#42;/locations/&#42;/backupPlans/&#42;`
   * @param backup Optional. The Backup resource to create.
   * @param backupId Optional. The client-provided short name for the Backup resource. This name
   *     must:
   *     <p>- be between 1 and 63 characters long (inclusive) - consist of only lower-case ASCII
   *     letters, numbers, and dashes - start with a lower-case letter - end with a lower-case
   *     letter or number - be unique within the set of Backups in this BackupPlan
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Backup, OperationMetadata> createBackupAsync(
      BackupPlanName parent, Backup backup, String backupId) {
    CreateBackupRequest request =
        CreateBackupRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setBackup(backup)
            .setBackupId(backupId)
            .build();
    return createBackupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Backup for the given BackupPlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   String parent = BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString();
   *   Backup backup = Backup.newBuilder().build();
   *   String backupId = "backupId2121930365";
   *   Backup response = backupForGKEClient.createBackupAsync(parent, backup, backupId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The BackupPlan within which to create the Backup. Format:
   *     `projects/&#42;/locations/&#42;/backupPlans/&#42;`
   * @param backup Optional. The Backup resource to create.
   * @param backupId Optional. The client-provided short name for the Backup resource. This name
   *     must:
   *     <p>- be between 1 and 63 characters long (inclusive) - consist of only lower-case ASCII
   *     letters, numbers, and dashes - start with a lower-case letter - end with a lower-case
   *     letter or number - be unique within the set of Backups in this BackupPlan
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Backup, OperationMetadata> createBackupAsync(
      String parent, Backup backup, String backupId) {
    CreateBackupRequest request =
        CreateBackupRequest.newBuilder()
            .setParent(parent)
            .setBackup(backup)
            .setBackupId(backupId)
            .build();
    return createBackupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Backup for the given BackupPlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   CreateBackupRequest request =
   *       CreateBackupRequest.newBuilder()
   *           .setParent(BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString())
   *           .setBackup(Backup.newBuilder().build())
   *           .setBackupId("backupId2121930365")
   *           .build();
   *   Backup response = backupForGKEClient.createBackupAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Backup, OperationMetadata> createBackupAsync(
      CreateBackupRequest request) {
    return createBackupOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Backup for the given BackupPlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   CreateBackupRequest request =
   *       CreateBackupRequest.newBuilder()
   *           .setParent(BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString())
   *           .setBackup(Backup.newBuilder().build())
   *           .setBackupId("backupId2121930365")
   *           .build();
   *   OperationFuture<Backup, OperationMetadata> future =
   *       backupForGKEClient.createBackupOperationCallable().futureCall(request);
   *   // Do something.
   *   Backup response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateBackupRequest, Backup, OperationMetadata>
      createBackupOperationCallable() {
    return stub.createBackupOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Backup for the given BackupPlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   CreateBackupRequest request =
   *       CreateBackupRequest.newBuilder()
   *           .setParent(BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString())
   *           .setBackup(Backup.newBuilder().build())
   *           .setBackupId("backupId2121930365")
   *           .build();
   *   ApiFuture<Operation> future = backupForGKEClient.createBackupCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateBackupRequest, Operation> createBackupCallable() {
    return stub.createBackupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Backups for a given BackupPlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   BackupPlanName parent = BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]");
   *   for (Backup element : backupForGKEClient.listBackups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The BackupPlan that contains the Backups to list. Format:
   *     `projects/&#42;/locations/&#42;/backupPlans/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupsPagedResponse listBackups(BackupPlanName parent) {
    ListBackupsRequest request =
        ListBackupsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listBackups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Backups for a given BackupPlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   String parent = BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString();
   *   for (Backup element : backupForGKEClient.listBackups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The BackupPlan that contains the Backups to list. Format:
   *     `projects/&#42;/locations/&#42;/backupPlans/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupsPagedResponse listBackups(String parent) {
    ListBackupsRequest request = ListBackupsRequest.newBuilder().setParent(parent).build();
    return listBackups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Backups for a given BackupPlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   ListBackupsRequest request =
   *       ListBackupsRequest.newBuilder()
   *           .setParent(BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (Backup element : backupForGKEClient.listBackups(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupsPagedResponse listBackups(ListBackupsRequest request) {
    return listBackupsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Backups for a given BackupPlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   ListBackupsRequest request =
   *       ListBackupsRequest.newBuilder()
   *           .setParent(BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<Backup> future = backupForGKEClient.listBackupsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Backup element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListBackupsRequest, ListBackupsPagedResponse>
      listBackupsPagedCallable() {
    return stub.listBackupsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Backups for a given BackupPlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   ListBackupsRequest request =
   *       ListBackupsRequest.newBuilder()
   *           .setParent(BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     ListBackupsResponse response = backupForGKEClient.listBackupsCallable().call(request);
   *     for (Backup element : response.getBackupsList()) {
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
  public final UnaryCallable<ListBackupsRequest, ListBackupsResponse> listBackupsCallable() {
    return stub.listBackupsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the details of a single Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   BackupName name = BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]");
   *   Backup response = backupForGKEClient.getBackup(name);
   * }
   * }</pre>
   *
   * @param name Required. Full name of the Backup resource. Format:
   *     `projects/&#42;/locations/&#42;/backupPlans/&#42;/backups/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Backup getBackup(BackupName name) {
    GetBackupRequest request =
        GetBackupRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getBackup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the details of a single Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   String name =
   *       BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]").toString();
   *   Backup response = backupForGKEClient.getBackup(name);
   * }
   * }</pre>
   *
   * @param name Required. Full name of the Backup resource. Format:
   *     `projects/&#42;/locations/&#42;/backupPlans/&#42;/backups/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Backup getBackup(String name) {
    GetBackupRequest request = GetBackupRequest.newBuilder().setName(name).build();
    return getBackup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the details of a single Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   GetBackupRequest request =
   *       GetBackupRequest.newBuilder()
   *           .setName(
   *               BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]").toString())
   *           .build();
   *   Backup response = backupForGKEClient.getBackup(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Backup getBackup(GetBackupRequest request) {
    return getBackupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the details of a single Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   GetBackupRequest request =
   *       GetBackupRequest.newBuilder()
   *           .setName(
   *               BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]").toString())
   *           .build();
   *   ApiFuture<Backup> future = backupForGKEClient.getBackupCallable().futureCall(request);
   *   // Do something.
   *   Backup response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetBackupRequest, Backup> getBackupCallable() {
    return stub.getBackupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   Backup backup = Backup.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Backup response = backupForGKEClient.updateBackupAsync(backup, updateMask).get();
   * }
   * }</pre>
   *
   * @param backup Required. A new version of the Backup resource that contains updated fields. This
   *     may be sparsely populated if an `update_mask` is provided.
   * @param updateMask Optional. This is used to specify the fields to be overwritten in the Backup
   *     targeted for update. The values for each of these updated fields will be taken from the
   *     `backup_plan` provided with this request. Field names are relative to the root of the
   *     resource. If no `update_mask` is provided, all fields in `backup` will be written to the
   *     target Backup resource. Note that OUTPUT_ONLY and IMMUTABLE fields in `backup` are ignored
   *     and are not used to update the target Backup.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Backup, OperationMetadata> updateBackupAsync(
      Backup backup, FieldMask updateMask) {
    UpdateBackupRequest request =
        UpdateBackupRequest.newBuilder().setBackup(backup).setUpdateMask(updateMask).build();
    return updateBackupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   UpdateBackupRequest request =
   *       UpdateBackupRequest.newBuilder()
   *           .setBackup(Backup.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Backup response = backupForGKEClient.updateBackupAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Backup, OperationMetadata> updateBackupAsync(
      UpdateBackupRequest request) {
    return updateBackupOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   UpdateBackupRequest request =
   *       UpdateBackupRequest.newBuilder()
   *           .setBackup(Backup.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<Backup, OperationMetadata> future =
   *       backupForGKEClient.updateBackupOperationCallable().futureCall(request);
   *   // Do something.
   *   Backup response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateBackupRequest, Backup, OperationMetadata>
      updateBackupOperationCallable() {
    return stub.updateBackupOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   UpdateBackupRequest request =
   *       UpdateBackupRequest.newBuilder()
   *           .setBackup(Backup.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = backupForGKEClient.updateBackupCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateBackupRequest, Operation> updateBackupCallable() {
    return stub.updateBackupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   BackupName name = BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]");
   *   backupForGKEClient.deleteBackupAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the Backup resource. Format:
   *     `projects/&#42;/locations/&#42;/backupPlans/&#42;/backups/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteBackupAsync(BackupName name) {
    DeleteBackupRequest request =
        DeleteBackupRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteBackupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   String name =
   *       BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]").toString();
   *   backupForGKEClient.deleteBackupAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the Backup resource. Format:
   *     `projects/&#42;/locations/&#42;/backupPlans/&#42;/backups/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteBackupAsync(String name) {
    DeleteBackupRequest request = DeleteBackupRequest.newBuilder().setName(name).build();
    return deleteBackupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   DeleteBackupRequest request =
   *       DeleteBackupRequest.newBuilder()
   *           .setName(
   *               BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]").toString())
   *           .setEtag("etag3123477")
   *           .setForce(true)
   *           .build();
   *   backupForGKEClient.deleteBackupAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteBackupAsync(
      DeleteBackupRequest request) {
    return deleteBackupOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   DeleteBackupRequest request =
   *       DeleteBackupRequest.newBuilder()
   *           .setName(
   *               BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]").toString())
   *           .setEtag("etag3123477")
   *           .setForce(true)
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       backupForGKEClient.deleteBackupOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteBackupRequest, Empty, OperationMetadata>
      deleteBackupOperationCallable() {
    return stub.deleteBackupOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   DeleteBackupRequest request =
   *       DeleteBackupRequest.newBuilder()
   *           .setName(
   *               BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]").toString())
   *           .setEtag("etag3123477")
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Operation> future = backupForGKEClient.deleteBackupCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteBackupRequest, Operation> deleteBackupCallable() {
    return stub.deleteBackupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the VolumeBackups for a given Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   BackupName parent = BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]");
   *   for (VolumeBackup element : backupForGKEClient.listVolumeBackups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The Backup that contains the VolumeBackups to list. Format:
   *     `projects/&#42;/locations/&#42;/backupPlans/&#42;/backups/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVolumeBackupsPagedResponse listVolumeBackups(BackupName parent) {
    ListVolumeBackupsRequest request =
        ListVolumeBackupsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listVolumeBackups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the VolumeBackups for a given Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   String parent =
   *       BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]").toString();
   *   for (VolumeBackup element : backupForGKEClient.listVolumeBackups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The Backup that contains the VolumeBackups to list. Format:
   *     `projects/&#42;/locations/&#42;/backupPlans/&#42;/backups/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVolumeBackupsPagedResponse listVolumeBackups(String parent) {
    ListVolumeBackupsRequest request =
        ListVolumeBackupsRequest.newBuilder().setParent(parent).build();
    return listVolumeBackups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the VolumeBackups for a given Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   ListVolumeBackupsRequest request =
   *       ListVolumeBackupsRequest.newBuilder()
   *           .setParent(
   *               BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (VolumeBackup element : backupForGKEClient.listVolumeBackups(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVolumeBackupsPagedResponse listVolumeBackups(ListVolumeBackupsRequest request) {
    return listVolumeBackupsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the VolumeBackups for a given Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   ListVolumeBackupsRequest request =
   *       ListVolumeBackupsRequest.newBuilder()
   *           .setParent(
   *               BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<VolumeBackup> future =
   *       backupForGKEClient.listVolumeBackupsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (VolumeBackup element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListVolumeBackupsRequest, ListVolumeBackupsPagedResponse>
      listVolumeBackupsPagedCallable() {
    return stub.listVolumeBackupsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the VolumeBackups for a given Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   ListVolumeBackupsRequest request =
   *       ListVolumeBackupsRequest.newBuilder()
   *           .setParent(
   *               BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListVolumeBackupsResponse response =
   *         backupForGKEClient.listVolumeBackupsCallable().call(request);
   *     for (VolumeBackup element : response.getVolumeBackupsList()) {
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
  public final UnaryCallable<ListVolumeBackupsRequest, ListVolumeBackupsResponse>
      listVolumeBackupsCallable() {
    return stub.listVolumeBackupsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the details of a single VolumeBackup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   VolumeBackupName name =
   *       VolumeBackupName.of(
   *           "[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]", "[VOLUME_BACKUP]");
   *   VolumeBackup response = backupForGKEClient.getVolumeBackup(name);
   * }
   * }</pre>
   *
   * @param name Required. Full name of the VolumeBackup resource. Format:
   *     `projects/&#42;/locations/&#42;/backupPlans/&#42;/backups/&#42;/volumeBackups/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VolumeBackup getVolumeBackup(VolumeBackupName name) {
    GetVolumeBackupRequest request =
        GetVolumeBackupRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getVolumeBackup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the details of a single VolumeBackup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   String name =
   *       VolumeBackupName.of(
   *               "[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]", "[VOLUME_BACKUP]")
   *           .toString();
   *   VolumeBackup response = backupForGKEClient.getVolumeBackup(name);
   * }
   * }</pre>
   *
   * @param name Required. Full name of the VolumeBackup resource. Format:
   *     `projects/&#42;/locations/&#42;/backupPlans/&#42;/backups/&#42;/volumeBackups/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VolumeBackup getVolumeBackup(String name) {
    GetVolumeBackupRequest request = GetVolumeBackupRequest.newBuilder().setName(name).build();
    return getVolumeBackup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the details of a single VolumeBackup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   GetVolumeBackupRequest request =
   *       GetVolumeBackupRequest.newBuilder()
   *           .setName(
   *               VolumeBackupName.of(
   *                       "[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]", "[VOLUME_BACKUP]")
   *                   .toString())
   *           .build();
   *   VolumeBackup response = backupForGKEClient.getVolumeBackup(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VolumeBackup getVolumeBackup(GetVolumeBackupRequest request) {
    return getVolumeBackupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the details of a single VolumeBackup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   GetVolumeBackupRequest request =
   *       GetVolumeBackupRequest.newBuilder()
   *           .setName(
   *               VolumeBackupName.of(
   *                       "[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]", "[VOLUME_BACKUP]")
   *                   .toString())
   *           .build();
   *   ApiFuture<VolumeBackup> future =
   *       backupForGKEClient.getVolumeBackupCallable().futureCall(request);
   *   // Do something.
   *   VolumeBackup response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetVolumeBackupRequest, VolumeBackup> getVolumeBackupCallable() {
    return stub.getVolumeBackupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new RestorePlan in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   RestorePlan restorePlan = RestorePlan.newBuilder().build();
   *   String restorePlanId = "restorePlanId-857896366";
   *   RestorePlan response =
   *       backupForGKEClient.createRestorePlanAsync(parent, restorePlan, restorePlanId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The location within which to create the RestorePlan. Format:
   *     `projects/&#42;/locations/&#42;`
   * @param restorePlan Required. The RestorePlan resource object to create.
   * @param restorePlanId Required. The client-provided short name for the RestorePlan resource.
   *     This name must:
   *     <p>- be between 1 and 63 characters long (inclusive) - consist of only lower-case ASCII
   *     letters, numbers, and dashes - start with a lower-case letter - end with a lower-case
   *     letter or number - be unique within the set of RestorePlans in this location
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RestorePlan, OperationMetadata> createRestorePlanAsync(
      LocationName parent, RestorePlan restorePlan, String restorePlanId) {
    CreateRestorePlanRequest request =
        CreateRestorePlanRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setRestorePlan(restorePlan)
            .setRestorePlanId(restorePlanId)
            .build();
    return createRestorePlanAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new RestorePlan in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   RestorePlan restorePlan = RestorePlan.newBuilder().build();
   *   String restorePlanId = "restorePlanId-857896366";
   *   RestorePlan response =
   *       backupForGKEClient.createRestorePlanAsync(parent, restorePlan, restorePlanId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The location within which to create the RestorePlan. Format:
   *     `projects/&#42;/locations/&#42;`
   * @param restorePlan Required. The RestorePlan resource object to create.
   * @param restorePlanId Required. The client-provided short name for the RestorePlan resource.
   *     This name must:
   *     <p>- be between 1 and 63 characters long (inclusive) - consist of only lower-case ASCII
   *     letters, numbers, and dashes - start with a lower-case letter - end with a lower-case
   *     letter or number - be unique within the set of RestorePlans in this location
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RestorePlan, OperationMetadata> createRestorePlanAsync(
      String parent, RestorePlan restorePlan, String restorePlanId) {
    CreateRestorePlanRequest request =
        CreateRestorePlanRequest.newBuilder()
            .setParent(parent)
            .setRestorePlan(restorePlan)
            .setRestorePlanId(restorePlanId)
            .build();
    return createRestorePlanAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new RestorePlan in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   CreateRestorePlanRequest request =
   *       CreateRestorePlanRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setRestorePlan(RestorePlan.newBuilder().build())
   *           .setRestorePlanId("restorePlanId-857896366")
   *           .build();
   *   RestorePlan response = backupForGKEClient.createRestorePlanAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RestorePlan, OperationMetadata> createRestorePlanAsync(
      CreateRestorePlanRequest request) {
    return createRestorePlanOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new RestorePlan in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   CreateRestorePlanRequest request =
   *       CreateRestorePlanRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setRestorePlan(RestorePlan.newBuilder().build())
   *           .setRestorePlanId("restorePlanId-857896366")
   *           .build();
   *   OperationFuture<RestorePlan, OperationMetadata> future =
   *       backupForGKEClient.createRestorePlanOperationCallable().futureCall(request);
   *   // Do something.
   *   RestorePlan response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateRestorePlanRequest, RestorePlan, OperationMetadata>
      createRestorePlanOperationCallable() {
    return stub.createRestorePlanOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new RestorePlan in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   CreateRestorePlanRequest request =
   *       CreateRestorePlanRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setRestorePlan(RestorePlan.newBuilder().build())
   *           .setRestorePlanId("restorePlanId-857896366")
   *           .build();
   *   ApiFuture<Operation> future =
   *       backupForGKEClient.createRestorePlanCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateRestorePlanRequest, Operation> createRestorePlanCallable() {
    return stub.createRestorePlanCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists RestorePlans in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (RestorePlan element : backupForGKEClient.listRestorePlans(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The location that contains the RestorePlans to list. Format:
   *     `projects/&#42;/locations/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRestorePlansPagedResponse listRestorePlans(LocationName parent) {
    ListRestorePlansRequest request =
        ListRestorePlansRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listRestorePlans(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists RestorePlans in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (RestorePlan element : backupForGKEClient.listRestorePlans(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The location that contains the RestorePlans to list. Format:
   *     `projects/&#42;/locations/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRestorePlansPagedResponse listRestorePlans(String parent) {
    ListRestorePlansRequest request =
        ListRestorePlansRequest.newBuilder().setParent(parent).build();
    return listRestorePlans(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists RestorePlans in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   ListRestorePlansRequest request =
   *       ListRestorePlansRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (RestorePlan element : backupForGKEClient.listRestorePlans(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRestorePlansPagedResponse listRestorePlans(ListRestorePlansRequest request) {
    return listRestorePlansPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists RestorePlans in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   ListRestorePlansRequest request =
   *       ListRestorePlansRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<RestorePlan> future =
   *       backupForGKEClient.listRestorePlansPagedCallable().futureCall(request);
   *   // Do something.
   *   for (RestorePlan element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRestorePlansRequest, ListRestorePlansPagedResponse>
      listRestorePlansPagedCallable() {
    return stub.listRestorePlansPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists RestorePlans in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   ListRestorePlansRequest request =
   *       ListRestorePlansRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListRestorePlansResponse response =
   *         backupForGKEClient.listRestorePlansCallable().call(request);
   *     for (RestorePlan element : response.getRestorePlansList()) {
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
  public final UnaryCallable<ListRestorePlansRequest, ListRestorePlansResponse>
      listRestorePlansCallable() {
    return stub.listRestorePlansCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the details of a single RestorePlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   RestorePlanName name = RestorePlanName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]");
   *   RestorePlan response = backupForGKEClient.getRestorePlan(name);
   * }
   * }</pre>
   *
   * @param name Required. Fully qualified RestorePlan name. Format:
   *     `projects/&#42;/locations/&#42;/restorePlans/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RestorePlan getRestorePlan(RestorePlanName name) {
    GetRestorePlanRequest request =
        GetRestorePlanRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getRestorePlan(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the details of a single RestorePlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   String name = RestorePlanName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]").toString();
   *   RestorePlan response = backupForGKEClient.getRestorePlan(name);
   * }
   * }</pre>
   *
   * @param name Required. Fully qualified RestorePlan name. Format:
   *     `projects/&#42;/locations/&#42;/restorePlans/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RestorePlan getRestorePlan(String name) {
    GetRestorePlanRequest request = GetRestorePlanRequest.newBuilder().setName(name).build();
    return getRestorePlan(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the details of a single RestorePlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   GetRestorePlanRequest request =
   *       GetRestorePlanRequest.newBuilder()
   *           .setName(RestorePlanName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]").toString())
   *           .build();
   *   RestorePlan response = backupForGKEClient.getRestorePlan(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RestorePlan getRestorePlan(GetRestorePlanRequest request) {
    return getRestorePlanCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the details of a single RestorePlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   GetRestorePlanRequest request =
   *       GetRestorePlanRequest.newBuilder()
   *           .setName(RestorePlanName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]").toString())
   *           .build();
   *   ApiFuture<RestorePlan> future =
   *       backupForGKEClient.getRestorePlanCallable().futureCall(request);
   *   // Do something.
   *   RestorePlan response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRestorePlanRequest, RestorePlan> getRestorePlanCallable() {
    return stub.getRestorePlanCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a RestorePlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   RestorePlan restorePlan = RestorePlan.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   RestorePlan response =
   *       backupForGKEClient.updateRestorePlanAsync(restorePlan, updateMask).get();
   * }
   * }</pre>
   *
   * @param restorePlan Required. A new version of the RestorePlan resource that contains updated
   *     fields. This may be sparsely populated if an `update_mask` is provided.
   * @param updateMask Optional. This is used to specify the fields to be overwritten in the
   *     RestorePlan targeted for update. The values for each of these updated fields will be taken
   *     from the `restore_plan` provided with this request. Field names are relative to the root of
   *     the resource. If no `update_mask` is provided, all fields in `restore_plan` will be written
   *     to the target RestorePlan resource. Note that OUTPUT_ONLY and IMMUTABLE fields in
   *     `restore_plan` are ignored and are not used to update the target RestorePlan.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RestorePlan, OperationMetadata> updateRestorePlanAsync(
      RestorePlan restorePlan, FieldMask updateMask) {
    UpdateRestorePlanRequest request =
        UpdateRestorePlanRequest.newBuilder()
            .setRestorePlan(restorePlan)
            .setUpdateMask(updateMask)
            .build();
    return updateRestorePlanAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a RestorePlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   UpdateRestorePlanRequest request =
   *       UpdateRestorePlanRequest.newBuilder()
   *           .setRestorePlan(RestorePlan.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   RestorePlan response = backupForGKEClient.updateRestorePlanAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RestorePlan, OperationMetadata> updateRestorePlanAsync(
      UpdateRestorePlanRequest request) {
    return updateRestorePlanOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a RestorePlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   UpdateRestorePlanRequest request =
   *       UpdateRestorePlanRequest.newBuilder()
   *           .setRestorePlan(RestorePlan.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<RestorePlan, OperationMetadata> future =
   *       backupForGKEClient.updateRestorePlanOperationCallable().futureCall(request);
   *   // Do something.
   *   RestorePlan response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateRestorePlanRequest, RestorePlan, OperationMetadata>
      updateRestorePlanOperationCallable() {
    return stub.updateRestorePlanOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a RestorePlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   UpdateRestorePlanRequest request =
   *       UpdateRestorePlanRequest.newBuilder()
   *           .setRestorePlan(RestorePlan.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       backupForGKEClient.updateRestorePlanCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateRestorePlanRequest, Operation> updateRestorePlanCallable() {
    return stub.updateRestorePlanCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing RestorePlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   RestorePlanName name = RestorePlanName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]");
   *   backupForGKEClient.deleteRestorePlanAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Fully qualified RestorePlan name. Format:
   *     `projects/&#42;/locations/&#42;/restorePlans/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteRestorePlanAsync(
      RestorePlanName name) {
    DeleteRestorePlanRequest request =
        DeleteRestorePlanRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteRestorePlanAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing RestorePlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   String name = RestorePlanName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]").toString();
   *   backupForGKEClient.deleteRestorePlanAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Fully qualified RestorePlan name. Format:
   *     `projects/&#42;/locations/&#42;/restorePlans/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteRestorePlanAsync(String name) {
    DeleteRestorePlanRequest request = DeleteRestorePlanRequest.newBuilder().setName(name).build();
    return deleteRestorePlanAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing RestorePlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   DeleteRestorePlanRequest request =
   *       DeleteRestorePlanRequest.newBuilder()
   *           .setName(RestorePlanName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]").toString())
   *           .setEtag("etag3123477")
   *           .setForce(true)
   *           .build();
   *   backupForGKEClient.deleteRestorePlanAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteRestorePlanAsync(
      DeleteRestorePlanRequest request) {
    return deleteRestorePlanOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing RestorePlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   DeleteRestorePlanRequest request =
   *       DeleteRestorePlanRequest.newBuilder()
   *           .setName(RestorePlanName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]").toString())
   *           .setEtag("etag3123477")
   *           .setForce(true)
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       backupForGKEClient.deleteRestorePlanOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteRestorePlanRequest, Empty, OperationMetadata>
      deleteRestorePlanOperationCallable() {
    return stub.deleteRestorePlanOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing RestorePlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   DeleteRestorePlanRequest request =
   *       DeleteRestorePlanRequest.newBuilder()
   *           .setName(RestorePlanName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]").toString())
   *           .setEtag("etag3123477")
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       backupForGKEClient.deleteRestorePlanCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteRestorePlanRequest, Operation> deleteRestorePlanCallable() {
    return stub.deleteRestorePlanCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new RestoreChannel in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   RestoreChannel restoreChannel = RestoreChannel.newBuilder().build();
   *   String restoreChannelId = "restoreChannelId1139842704";
   *   RestoreChannel response =
   *       backupForGKEClient
   *           .createRestoreChannelAsync(parent, restoreChannel, restoreChannelId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The location within which to create the RestoreChannel. Format:
   *     `projects/&#42;/locations/&#42;`
   * @param restoreChannel Required. The RestoreChannel resource object to create.
   * @param restoreChannelId Optional. The client-provided short name for the RestoreChannel
   *     resource. This name must:
   *     <p>- be between 1 and 63 characters long (inclusive) - consist of only lower-case ASCII
   *     letters, numbers, and dashes - start with a lower-case letter - end with a lower-case
   *     letter or number - be unique within the set of RestoreChannels in this location If the user
   *     does not provide a name, a uuid will be used as the name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RestoreChannel, OperationMetadata> createRestoreChannelAsync(
      LocationName parent, RestoreChannel restoreChannel, String restoreChannelId) {
    CreateRestoreChannelRequest request =
        CreateRestoreChannelRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setRestoreChannel(restoreChannel)
            .setRestoreChannelId(restoreChannelId)
            .build();
    return createRestoreChannelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new RestoreChannel in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   RestoreChannel restoreChannel = RestoreChannel.newBuilder().build();
   *   String restoreChannelId = "restoreChannelId1139842704";
   *   RestoreChannel response =
   *       backupForGKEClient
   *           .createRestoreChannelAsync(parent, restoreChannel, restoreChannelId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The location within which to create the RestoreChannel. Format:
   *     `projects/&#42;/locations/&#42;`
   * @param restoreChannel Required. The RestoreChannel resource object to create.
   * @param restoreChannelId Optional. The client-provided short name for the RestoreChannel
   *     resource. This name must:
   *     <p>- be between 1 and 63 characters long (inclusive) - consist of only lower-case ASCII
   *     letters, numbers, and dashes - start with a lower-case letter - end with a lower-case
   *     letter or number - be unique within the set of RestoreChannels in this location If the user
   *     does not provide a name, a uuid will be used as the name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RestoreChannel, OperationMetadata> createRestoreChannelAsync(
      String parent, RestoreChannel restoreChannel, String restoreChannelId) {
    CreateRestoreChannelRequest request =
        CreateRestoreChannelRequest.newBuilder()
            .setParent(parent)
            .setRestoreChannel(restoreChannel)
            .setRestoreChannelId(restoreChannelId)
            .build();
    return createRestoreChannelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new RestoreChannel in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   CreateRestoreChannelRequest request =
   *       CreateRestoreChannelRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setRestoreChannel(RestoreChannel.newBuilder().build())
   *           .setRestoreChannelId("restoreChannelId1139842704")
   *           .build();
   *   RestoreChannel response = backupForGKEClient.createRestoreChannelAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RestoreChannel, OperationMetadata> createRestoreChannelAsync(
      CreateRestoreChannelRequest request) {
    return createRestoreChannelOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new RestoreChannel in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   CreateRestoreChannelRequest request =
   *       CreateRestoreChannelRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setRestoreChannel(RestoreChannel.newBuilder().build())
   *           .setRestoreChannelId("restoreChannelId1139842704")
   *           .build();
   *   OperationFuture<RestoreChannel, OperationMetadata> future =
   *       backupForGKEClient.createRestoreChannelOperationCallable().futureCall(request);
   *   // Do something.
   *   RestoreChannel response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateRestoreChannelRequest, RestoreChannel, OperationMetadata>
      createRestoreChannelOperationCallable() {
    return stub.createRestoreChannelOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new RestoreChannel in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   CreateRestoreChannelRequest request =
   *       CreateRestoreChannelRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setRestoreChannel(RestoreChannel.newBuilder().build())
   *           .setRestoreChannelId("restoreChannelId1139842704")
   *           .build();
   *   ApiFuture<Operation> future =
   *       backupForGKEClient.createRestoreChannelCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateRestoreChannelRequest, Operation>
      createRestoreChannelCallable() {
    return stub.createRestoreChannelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists RestoreChannels in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (RestoreChannel element : backupForGKEClient.listRestoreChannels(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The location that contains the RestoreChannels to list. Format:
   *     `projects/&#42;/locations/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRestoreChannelsPagedResponse listRestoreChannels(LocationName parent) {
    ListRestoreChannelsRequest request =
        ListRestoreChannelsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listRestoreChannels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists RestoreChannels in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (RestoreChannel element : backupForGKEClient.listRestoreChannels(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The location that contains the RestoreChannels to list. Format:
   *     `projects/&#42;/locations/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRestoreChannelsPagedResponse listRestoreChannels(String parent) {
    ListRestoreChannelsRequest request =
        ListRestoreChannelsRequest.newBuilder().setParent(parent).build();
    return listRestoreChannels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists RestoreChannels in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   ListRestoreChannelsRequest request =
   *       ListRestoreChannelsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (RestoreChannel element : backupForGKEClient.listRestoreChannels(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRestoreChannelsPagedResponse listRestoreChannels(
      ListRestoreChannelsRequest request) {
    return listRestoreChannelsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists RestoreChannels in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   ListRestoreChannelsRequest request =
   *       ListRestoreChannelsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<RestoreChannel> future =
   *       backupForGKEClient.listRestoreChannelsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (RestoreChannel element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRestoreChannelsRequest, ListRestoreChannelsPagedResponse>
      listRestoreChannelsPagedCallable() {
    return stub.listRestoreChannelsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists RestoreChannels in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   ListRestoreChannelsRequest request =
   *       ListRestoreChannelsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListRestoreChannelsResponse response =
   *         backupForGKEClient.listRestoreChannelsCallable().call(request);
   *     for (RestoreChannel element : response.getRestoreChannelsList()) {
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
  public final UnaryCallable<ListRestoreChannelsRequest, ListRestoreChannelsResponse>
      listRestoreChannelsCallable() {
    return stub.listRestoreChannelsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the details of a single RestoreChannel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   RestoreChannelName name =
   *       RestoreChannelName.of("[PROJECT]", "[LOCATION]", "[RESTORE_CHANNEL]");
   *   RestoreChannel response = backupForGKEClient.getRestoreChannel(name);
   * }
   * }</pre>
   *
   * @param name Required. Fully qualified RestoreChannel name. Format:
   *     `projects/&#42;/locations/&#42;/restoreChannels/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RestoreChannel getRestoreChannel(RestoreChannelName name) {
    GetRestoreChannelRequest request =
        GetRestoreChannelRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getRestoreChannel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the details of a single RestoreChannel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   String name =
   *       RestoreChannelName.of("[PROJECT]", "[LOCATION]", "[RESTORE_CHANNEL]").toString();
   *   RestoreChannel response = backupForGKEClient.getRestoreChannel(name);
   * }
   * }</pre>
   *
   * @param name Required. Fully qualified RestoreChannel name. Format:
   *     `projects/&#42;/locations/&#42;/restoreChannels/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RestoreChannel getRestoreChannel(String name) {
    GetRestoreChannelRequest request = GetRestoreChannelRequest.newBuilder().setName(name).build();
    return getRestoreChannel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the details of a single RestoreChannel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   GetRestoreChannelRequest request =
   *       GetRestoreChannelRequest.newBuilder()
   *           .setName(
   *               RestoreChannelName.of("[PROJECT]", "[LOCATION]", "[RESTORE_CHANNEL]").toString())
   *           .build();
   *   RestoreChannel response = backupForGKEClient.getRestoreChannel(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RestoreChannel getRestoreChannel(GetRestoreChannelRequest request) {
    return getRestoreChannelCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the details of a single RestoreChannel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   GetRestoreChannelRequest request =
   *       GetRestoreChannelRequest.newBuilder()
   *           .setName(
   *               RestoreChannelName.of("[PROJECT]", "[LOCATION]", "[RESTORE_CHANNEL]").toString())
   *           .build();
   *   ApiFuture<RestoreChannel> future =
   *       backupForGKEClient.getRestoreChannelCallable().futureCall(request);
   *   // Do something.
   *   RestoreChannel response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRestoreChannelRequest, RestoreChannel> getRestoreChannelCallable() {
    return stub.getRestoreChannelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a RestoreChannel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   RestoreChannel restoreChannel = RestoreChannel.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   RestoreChannel response =
   *       backupForGKEClient.updateRestoreChannelAsync(restoreChannel, updateMask).get();
   * }
   * }</pre>
   *
   * @param restoreChannel Required. A new version of the RestoreChannel resource that contains
   *     updated fields. This may be sparsely populated if an `update_mask` is provided.
   * @param updateMask Optional. This is used to specify the fields to be overwritten in the
   *     RestoreChannel targeted for update. The values for each of these updated fields will be
   *     taken from the `restore_channel` provided with this request. Field names are relative to
   *     the root of the resource (e.g., `description`, `destination_project_id`, etc.) If no
   *     `update_mask` is provided, all fields in `restore_channel` will be written to the target
   *     RestoreChannel resource. Note that OUTPUT_ONLY and IMMUTABLE fields in `restore_channel`
   *     are ignored and are not used to update the target RestoreChannel.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RestoreChannel, OperationMetadata> updateRestoreChannelAsync(
      RestoreChannel restoreChannel, FieldMask updateMask) {
    UpdateRestoreChannelRequest request =
        UpdateRestoreChannelRequest.newBuilder()
            .setRestoreChannel(restoreChannel)
            .setUpdateMask(updateMask)
            .build();
    return updateRestoreChannelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a RestoreChannel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   UpdateRestoreChannelRequest request =
   *       UpdateRestoreChannelRequest.newBuilder()
   *           .setRestoreChannel(RestoreChannel.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   RestoreChannel response = backupForGKEClient.updateRestoreChannelAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RestoreChannel, OperationMetadata> updateRestoreChannelAsync(
      UpdateRestoreChannelRequest request) {
    return updateRestoreChannelOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a RestoreChannel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   UpdateRestoreChannelRequest request =
   *       UpdateRestoreChannelRequest.newBuilder()
   *           .setRestoreChannel(RestoreChannel.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<RestoreChannel, OperationMetadata> future =
   *       backupForGKEClient.updateRestoreChannelOperationCallable().futureCall(request);
   *   // Do something.
   *   RestoreChannel response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateRestoreChannelRequest, RestoreChannel, OperationMetadata>
      updateRestoreChannelOperationCallable() {
    return stub.updateRestoreChannelOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a RestoreChannel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   UpdateRestoreChannelRequest request =
   *       UpdateRestoreChannelRequest.newBuilder()
   *           .setRestoreChannel(RestoreChannel.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       backupForGKEClient.updateRestoreChannelCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateRestoreChannelRequest, Operation>
      updateRestoreChannelCallable() {
    return stub.updateRestoreChannelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing RestoreChannel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   RestoreChannelName name =
   *       RestoreChannelName.of("[PROJECT]", "[LOCATION]", "[RESTORE_CHANNEL]");
   *   backupForGKEClient.deleteRestoreChannelAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Fully qualified RestoreChannel name. Format:
   *     `projects/&#42;/locations/&#42;/restoreChannels/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteRestoreChannelAsync(
      RestoreChannelName name) {
    DeleteRestoreChannelRequest request =
        DeleteRestoreChannelRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteRestoreChannelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing RestoreChannel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   String name =
   *       RestoreChannelName.of("[PROJECT]", "[LOCATION]", "[RESTORE_CHANNEL]").toString();
   *   backupForGKEClient.deleteRestoreChannelAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Fully qualified RestoreChannel name. Format:
   *     `projects/&#42;/locations/&#42;/restoreChannels/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteRestoreChannelAsync(String name) {
    DeleteRestoreChannelRequest request =
        DeleteRestoreChannelRequest.newBuilder().setName(name).build();
    return deleteRestoreChannelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing RestoreChannel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   DeleteRestoreChannelRequest request =
   *       DeleteRestoreChannelRequest.newBuilder()
   *           .setName(
   *               RestoreChannelName.of("[PROJECT]", "[LOCATION]", "[RESTORE_CHANNEL]").toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   backupForGKEClient.deleteRestoreChannelAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteRestoreChannelAsync(
      DeleteRestoreChannelRequest request) {
    return deleteRestoreChannelOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing RestoreChannel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   DeleteRestoreChannelRequest request =
   *       DeleteRestoreChannelRequest.newBuilder()
   *           .setName(
   *               RestoreChannelName.of("[PROJECT]", "[LOCATION]", "[RESTORE_CHANNEL]").toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       backupForGKEClient.deleteRestoreChannelOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteRestoreChannelRequest, Empty, OperationMetadata>
      deleteRestoreChannelOperationCallable() {
    return stub.deleteRestoreChannelOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing RestoreChannel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   DeleteRestoreChannelRequest request =
   *       DeleteRestoreChannelRequest.newBuilder()
   *           .setName(
   *               RestoreChannelName.of("[PROJECT]", "[LOCATION]", "[RESTORE_CHANNEL]").toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future =
   *       backupForGKEClient.deleteRestoreChannelCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteRestoreChannelRequest, Operation>
      deleteRestoreChannelCallable() {
    return stub.deleteRestoreChannelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists RestorePlanBindings in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   RestoreChannelName parent =
   *       RestoreChannelName.of("[PROJECT]", "[LOCATION]", "[RESTORE_CHANNEL]");
   *   for (RestorePlanBinding element :
   *       backupForGKEClient.listRestorePlanBindings(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The RestoreChannel that contains the ListRestorePlanBindings to list.
   *     Format: `projects/&#42;/locations/&#42;/restoreChannels/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRestorePlanBindingsPagedResponse listRestorePlanBindings(
      RestoreChannelName parent) {
    ListRestorePlanBindingsRequest request =
        ListRestorePlanBindingsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listRestorePlanBindings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists RestorePlanBindings in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   String parent =
   *       RestoreChannelName.of("[PROJECT]", "[LOCATION]", "[RESTORE_CHANNEL]").toString();
   *   for (RestorePlanBinding element :
   *       backupForGKEClient.listRestorePlanBindings(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The RestoreChannel that contains the ListRestorePlanBindings to list.
   *     Format: `projects/&#42;/locations/&#42;/restoreChannels/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRestorePlanBindingsPagedResponse listRestorePlanBindings(String parent) {
    ListRestorePlanBindingsRequest request =
        ListRestorePlanBindingsRequest.newBuilder().setParent(parent).build();
    return listRestorePlanBindings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists RestorePlanBindings in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   ListRestorePlanBindingsRequest request =
   *       ListRestorePlanBindingsRequest.newBuilder()
   *           .setParent(
   *               RestoreChannelName.of("[PROJECT]", "[LOCATION]", "[RESTORE_CHANNEL]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (RestorePlanBinding element :
   *       backupForGKEClient.listRestorePlanBindings(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRestorePlanBindingsPagedResponse listRestorePlanBindings(
      ListRestorePlanBindingsRequest request) {
    return listRestorePlanBindingsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists RestorePlanBindings in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   ListRestorePlanBindingsRequest request =
   *       ListRestorePlanBindingsRequest.newBuilder()
   *           .setParent(
   *               RestoreChannelName.of("[PROJECT]", "[LOCATION]", "[RESTORE_CHANNEL]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<RestorePlanBinding> future =
   *       backupForGKEClient.listRestorePlanBindingsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (RestorePlanBinding element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRestorePlanBindingsRequest, ListRestorePlanBindingsPagedResponse>
      listRestorePlanBindingsPagedCallable() {
    return stub.listRestorePlanBindingsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists RestorePlanBindings in a given location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   ListRestorePlanBindingsRequest request =
   *       ListRestorePlanBindingsRequest.newBuilder()
   *           .setParent(
   *               RestoreChannelName.of("[PROJECT]", "[LOCATION]", "[RESTORE_CHANNEL]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListRestorePlanBindingsResponse response =
   *         backupForGKEClient.listRestorePlanBindingsCallable().call(request);
   *     for (RestorePlanBinding element : response.getRestorePlanBindingsList()) {
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
  public final UnaryCallable<ListRestorePlanBindingsRequest, ListRestorePlanBindingsResponse>
      listRestorePlanBindingsCallable() {
    return stub.listRestorePlanBindingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the details of a single RestorePlanBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   RestorePlanBindingName name =
   *       RestorePlanBindingName.of(
   *           "[PROJECT]", "[LOCATION]", "[RESTORE_CHANNEL]", "[RESTORE_PLAN_BINDING]");
   *   RestorePlanBinding response = backupForGKEClient.getRestorePlanBinding(name);
   * }
   * }</pre>
   *
   * @param name Required. Fully qualified RestorePlanBinding name. Format:
   *     `projects/&#42;/locations/&#42;/restoreChannels/&#42;/restorePlanBindings/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RestorePlanBinding getRestorePlanBinding(RestorePlanBindingName name) {
    GetRestorePlanBindingRequest request =
        GetRestorePlanBindingRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getRestorePlanBinding(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the details of a single RestorePlanBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   String name =
   *       RestorePlanBindingName.of(
   *               "[PROJECT]", "[LOCATION]", "[RESTORE_CHANNEL]", "[RESTORE_PLAN_BINDING]")
   *           .toString();
   *   RestorePlanBinding response = backupForGKEClient.getRestorePlanBinding(name);
   * }
   * }</pre>
   *
   * @param name Required. Fully qualified RestorePlanBinding name. Format:
   *     `projects/&#42;/locations/&#42;/restoreChannels/&#42;/restorePlanBindings/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RestorePlanBinding getRestorePlanBinding(String name) {
    GetRestorePlanBindingRequest request =
        GetRestorePlanBindingRequest.newBuilder().setName(name).build();
    return getRestorePlanBinding(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the details of a single RestorePlanBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   GetRestorePlanBindingRequest request =
   *       GetRestorePlanBindingRequest.newBuilder()
   *           .setName(
   *               RestorePlanBindingName.of(
   *                       "[PROJECT]", "[LOCATION]", "[RESTORE_CHANNEL]", "[RESTORE_PLAN_BINDING]")
   *                   .toString())
   *           .build();
   *   RestorePlanBinding response = backupForGKEClient.getRestorePlanBinding(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RestorePlanBinding getRestorePlanBinding(GetRestorePlanBindingRequest request) {
    return getRestorePlanBindingCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the details of a single RestorePlanBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   GetRestorePlanBindingRequest request =
   *       GetRestorePlanBindingRequest.newBuilder()
   *           .setName(
   *               RestorePlanBindingName.of(
   *                       "[PROJECT]", "[LOCATION]", "[RESTORE_CHANNEL]", "[RESTORE_PLAN_BINDING]")
   *                   .toString())
   *           .build();
   *   ApiFuture<RestorePlanBinding> future =
   *       backupForGKEClient.getRestorePlanBindingCallable().futureCall(request);
   *   // Do something.
   *   RestorePlanBinding response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRestorePlanBindingRequest, RestorePlanBinding>
      getRestorePlanBindingCallable() {
    return stub.getRestorePlanBindingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Restore for the given RestorePlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   RestorePlanName parent = RestorePlanName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]");
   *   Restore restore = Restore.newBuilder().build();
   *   String restoreId = "restoreId-1845465015";
   *   Restore response = backupForGKEClient.createRestoreAsync(parent, restore, restoreId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The RestorePlan within which to create the Restore. Format:
   *     `projects/&#42;/locations/&#42;/restorePlans/&#42;`
   * @param restore Required. The restore resource to create.
   * @param restoreId Required. The client-provided short name for the Restore resource. This name
   *     must:
   *     <p>- be between 1 and 63 characters long (inclusive) - consist of only lower-case ASCII
   *     letters, numbers, and dashes - start with a lower-case letter - end with a lower-case
   *     letter or number - be unique within the set of Restores in this RestorePlan.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Restore, OperationMetadata> createRestoreAsync(
      RestorePlanName parent, Restore restore, String restoreId) {
    CreateRestoreRequest request =
        CreateRestoreRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setRestore(restore)
            .setRestoreId(restoreId)
            .build();
    return createRestoreAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Restore for the given RestorePlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   String parent = RestorePlanName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]").toString();
   *   Restore restore = Restore.newBuilder().build();
   *   String restoreId = "restoreId-1845465015";
   *   Restore response = backupForGKEClient.createRestoreAsync(parent, restore, restoreId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The RestorePlan within which to create the Restore. Format:
   *     `projects/&#42;/locations/&#42;/restorePlans/&#42;`
   * @param restore Required. The restore resource to create.
   * @param restoreId Required. The client-provided short name for the Restore resource. This name
   *     must:
   *     <p>- be between 1 and 63 characters long (inclusive) - consist of only lower-case ASCII
   *     letters, numbers, and dashes - start with a lower-case letter - end with a lower-case
   *     letter or number - be unique within the set of Restores in this RestorePlan.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Restore, OperationMetadata> createRestoreAsync(
      String parent, Restore restore, String restoreId) {
    CreateRestoreRequest request =
        CreateRestoreRequest.newBuilder()
            .setParent(parent)
            .setRestore(restore)
            .setRestoreId(restoreId)
            .build();
    return createRestoreAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Restore for the given RestorePlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   CreateRestoreRequest request =
   *       CreateRestoreRequest.newBuilder()
   *           .setParent(RestorePlanName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]").toString())
   *           .setRestore(Restore.newBuilder().build())
   *           .setRestoreId("restoreId-1845465015")
   *           .build();
   *   Restore response = backupForGKEClient.createRestoreAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Restore, OperationMetadata> createRestoreAsync(
      CreateRestoreRequest request) {
    return createRestoreOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Restore for the given RestorePlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   CreateRestoreRequest request =
   *       CreateRestoreRequest.newBuilder()
   *           .setParent(RestorePlanName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]").toString())
   *           .setRestore(Restore.newBuilder().build())
   *           .setRestoreId("restoreId-1845465015")
   *           .build();
   *   OperationFuture<Restore, OperationMetadata> future =
   *       backupForGKEClient.createRestoreOperationCallable().futureCall(request);
   *   // Do something.
   *   Restore response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateRestoreRequest, Restore, OperationMetadata>
      createRestoreOperationCallable() {
    return stub.createRestoreOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Restore for the given RestorePlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   CreateRestoreRequest request =
   *       CreateRestoreRequest.newBuilder()
   *           .setParent(RestorePlanName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]").toString())
   *           .setRestore(Restore.newBuilder().build())
   *           .setRestoreId("restoreId-1845465015")
   *           .build();
   *   ApiFuture<Operation> future = backupForGKEClient.createRestoreCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateRestoreRequest, Operation> createRestoreCallable() {
    return stub.createRestoreCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Restores for a given RestorePlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   RestorePlanName parent = RestorePlanName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]");
   *   for (Restore element : backupForGKEClient.listRestores(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The RestorePlan that contains the Restores to list. Format:
   *     `projects/&#42;/locations/&#42;/restorePlans/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRestoresPagedResponse listRestores(RestorePlanName parent) {
    ListRestoresRequest request =
        ListRestoresRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listRestores(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Restores for a given RestorePlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   String parent = RestorePlanName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]").toString();
   *   for (Restore element : backupForGKEClient.listRestores(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The RestorePlan that contains the Restores to list. Format:
   *     `projects/&#42;/locations/&#42;/restorePlans/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRestoresPagedResponse listRestores(String parent) {
    ListRestoresRequest request = ListRestoresRequest.newBuilder().setParent(parent).build();
    return listRestores(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Restores for a given RestorePlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   ListRestoresRequest request =
   *       ListRestoresRequest.newBuilder()
   *           .setParent(RestorePlanName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Restore element : backupForGKEClient.listRestores(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRestoresPagedResponse listRestores(ListRestoresRequest request) {
    return listRestoresPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Restores for a given RestorePlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   ListRestoresRequest request =
   *       ListRestoresRequest.newBuilder()
   *           .setParent(RestorePlanName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Restore> future =
   *       backupForGKEClient.listRestoresPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Restore element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRestoresRequest, ListRestoresPagedResponse>
      listRestoresPagedCallable() {
    return stub.listRestoresPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the Restores for a given RestorePlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   ListRestoresRequest request =
   *       ListRestoresRequest.newBuilder()
   *           .setParent(RestorePlanName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListRestoresResponse response = backupForGKEClient.listRestoresCallable().call(request);
   *     for (Restore element : response.getRestoresList()) {
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
  public final UnaryCallable<ListRestoresRequest, ListRestoresResponse> listRestoresCallable() {
    return stub.listRestoresCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the details of a single Restore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   RestoreName name = RestoreName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]", "[RESTORE]");
   *   Restore response = backupForGKEClient.getRestore(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the restore resource. Format:
   *     `projects/&#42;/locations/&#42;/restorePlans/&#42;/restores/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Restore getRestore(RestoreName name) {
    GetRestoreRequest request =
        GetRestoreRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getRestore(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the details of a single Restore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   String name =
   *       RestoreName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]", "[RESTORE]").toString();
   *   Restore response = backupForGKEClient.getRestore(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the restore resource. Format:
   *     `projects/&#42;/locations/&#42;/restorePlans/&#42;/restores/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Restore getRestore(String name) {
    GetRestoreRequest request = GetRestoreRequest.newBuilder().setName(name).build();
    return getRestore(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the details of a single Restore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   GetRestoreRequest request =
   *       GetRestoreRequest.newBuilder()
   *           .setName(
   *               RestoreName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]", "[RESTORE]")
   *                   .toString())
   *           .build();
   *   Restore response = backupForGKEClient.getRestore(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Restore getRestore(GetRestoreRequest request) {
    return getRestoreCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the details of a single Restore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   GetRestoreRequest request =
   *       GetRestoreRequest.newBuilder()
   *           .setName(
   *               RestoreName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]", "[RESTORE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Restore> future = backupForGKEClient.getRestoreCallable().futureCall(request);
   *   // Do something.
   *   Restore response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRestoreRequest, Restore> getRestoreCallable() {
    return stub.getRestoreCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a Restore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   Restore restore = Restore.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Restore response = backupForGKEClient.updateRestoreAsync(restore, updateMask).get();
   * }
   * }</pre>
   *
   * @param restore Required. A new version of the Restore resource that contains updated fields.
   *     This may be sparsely populated if an `update_mask` is provided.
   * @param updateMask Optional. This is used to specify the fields to be overwritten in the Restore
   *     targeted for update. The values for each of these updated fields will be taken from the
   *     `restore` provided with this request. Field names are relative to the root of the resource.
   *     If no `update_mask` is provided, all fields in `restore` will be written to the target
   *     Restore resource. Note that OUTPUT_ONLY and IMMUTABLE fields in `restore` are ignored and
   *     are not used to update the target Restore.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Restore, OperationMetadata> updateRestoreAsync(
      Restore restore, FieldMask updateMask) {
    UpdateRestoreRequest request =
        UpdateRestoreRequest.newBuilder().setRestore(restore).setUpdateMask(updateMask).build();
    return updateRestoreAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a Restore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   UpdateRestoreRequest request =
   *       UpdateRestoreRequest.newBuilder()
   *           .setRestore(Restore.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Restore response = backupForGKEClient.updateRestoreAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Restore, OperationMetadata> updateRestoreAsync(
      UpdateRestoreRequest request) {
    return updateRestoreOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a Restore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   UpdateRestoreRequest request =
   *       UpdateRestoreRequest.newBuilder()
   *           .setRestore(Restore.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<Restore, OperationMetadata> future =
   *       backupForGKEClient.updateRestoreOperationCallable().futureCall(request);
   *   // Do something.
   *   Restore response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateRestoreRequest, Restore, OperationMetadata>
      updateRestoreOperationCallable() {
    return stub.updateRestoreOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a Restore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   UpdateRestoreRequest request =
   *       UpdateRestoreRequest.newBuilder()
   *           .setRestore(Restore.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = backupForGKEClient.updateRestoreCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateRestoreRequest, Operation> updateRestoreCallable() {
    return stub.updateRestoreCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing Restore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   RestoreName name = RestoreName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]", "[RESTORE]");
   *   backupForGKEClient.deleteRestoreAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Full name of the Restore Format:
   *     `projects/&#42;/locations/&#42;/restorePlans/&#42;/restores/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteRestoreAsync(RestoreName name) {
    DeleteRestoreRequest request =
        DeleteRestoreRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteRestoreAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing Restore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   String name =
   *       RestoreName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]", "[RESTORE]").toString();
   *   backupForGKEClient.deleteRestoreAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Full name of the Restore Format:
   *     `projects/&#42;/locations/&#42;/restorePlans/&#42;/restores/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteRestoreAsync(String name) {
    DeleteRestoreRequest request = DeleteRestoreRequest.newBuilder().setName(name).build();
    return deleteRestoreAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing Restore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   DeleteRestoreRequest request =
   *       DeleteRestoreRequest.newBuilder()
   *           .setName(
   *               RestoreName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]", "[RESTORE]")
   *                   .toString())
   *           .setEtag("etag3123477")
   *           .setForce(true)
   *           .build();
   *   backupForGKEClient.deleteRestoreAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteRestoreAsync(
      DeleteRestoreRequest request) {
    return deleteRestoreOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing Restore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   DeleteRestoreRequest request =
   *       DeleteRestoreRequest.newBuilder()
   *           .setName(
   *               RestoreName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]", "[RESTORE]")
   *                   .toString())
   *           .setEtag("etag3123477")
   *           .setForce(true)
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       backupForGKEClient.deleteRestoreOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteRestoreRequest, Empty, OperationMetadata>
      deleteRestoreOperationCallable() {
    return stub.deleteRestoreOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing Restore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   DeleteRestoreRequest request =
   *       DeleteRestoreRequest.newBuilder()
   *           .setName(
   *               RestoreName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]", "[RESTORE]")
   *                   .toString())
   *           .setEtag("etag3123477")
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Operation> future = backupForGKEClient.deleteRestoreCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteRestoreRequest, Operation> deleteRestoreCallable() {
    return stub.deleteRestoreCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the VolumeRestores for a given Restore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   RestoreName parent = RestoreName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]", "[RESTORE]");
   *   for (VolumeRestore element : backupForGKEClient.listVolumeRestores(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The Restore that contains the VolumeRestores to list. Format:
   *     `projects/&#42;/locations/&#42;/restorePlans/&#42;/restores/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVolumeRestoresPagedResponse listVolumeRestores(RestoreName parent) {
    ListVolumeRestoresRequest request =
        ListVolumeRestoresRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listVolumeRestores(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the VolumeRestores for a given Restore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   String parent =
   *       RestoreName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]", "[RESTORE]").toString();
   *   for (VolumeRestore element : backupForGKEClient.listVolumeRestores(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The Restore that contains the VolumeRestores to list. Format:
   *     `projects/&#42;/locations/&#42;/restorePlans/&#42;/restores/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVolumeRestoresPagedResponse listVolumeRestores(String parent) {
    ListVolumeRestoresRequest request =
        ListVolumeRestoresRequest.newBuilder().setParent(parent).build();
    return listVolumeRestores(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the VolumeRestores for a given Restore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   ListVolumeRestoresRequest request =
   *       ListVolumeRestoresRequest.newBuilder()
   *           .setParent(
   *               RestoreName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]", "[RESTORE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (VolumeRestore element : backupForGKEClient.listVolumeRestores(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVolumeRestoresPagedResponse listVolumeRestores(
      ListVolumeRestoresRequest request) {
    return listVolumeRestoresPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the VolumeRestores for a given Restore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   ListVolumeRestoresRequest request =
   *       ListVolumeRestoresRequest.newBuilder()
   *           .setParent(
   *               RestoreName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]", "[RESTORE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<VolumeRestore> future =
   *       backupForGKEClient.listVolumeRestoresPagedCallable().futureCall(request);
   *   // Do something.
   *   for (VolumeRestore element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListVolumeRestoresRequest, ListVolumeRestoresPagedResponse>
      listVolumeRestoresPagedCallable() {
    return stub.listVolumeRestoresPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the VolumeRestores for a given Restore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   ListVolumeRestoresRequest request =
   *       ListVolumeRestoresRequest.newBuilder()
   *           .setParent(
   *               RestoreName.of("[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]", "[RESTORE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListVolumeRestoresResponse response =
   *         backupForGKEClient.listVolumeRestoresCallable().call(request);
   *     for (VolumeRestore element : response.getVolumeRestoresList()) {
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
  public final UnaryCallable<ListVolumeRestoresRequest, ListVolumeRestoresResponse>
      listVolumeRestoresCallable() {
    return stub.listVolumeRestoresCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the details of a single VolumeRestore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   VolumeRestoreName name =
   *       VolumeRestoreName.of(
   *           "[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]", "[RESTORE]", "[VOLUME_RESTORE]");
   *   VolumeRestore response = backupForGKEClient.getVolumeRestore(name);
   * }
   * }</pre>
   *
   * @param name Required. Full name of the VolumeRestore resource. Format:
   *     `projects/&#42;/locations/&#42;/restorePlans/&#42;/restores/&#42;/volumeRestores/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VolumeRestore getVolumeRestore(VolumeRestoreName name) {
    GetVolumeRestoreRequest request =
        GetVolumeRestoreRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getVolumeRestore(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the details of a single VolumeRestore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   String name =
   *       VolumeRestoreName.of(
   *               "[PROJECT]", "[LOCATION]", "[RESTORE_PLAN]", "[RESTORE]", "[VOLUME_RESTORE]")
   *           .toString();
   *   VolumeRestore response = backupForGKEClient.getVolumeRestore(name);
   * }
   * }</pre>
   *
   * @param name Required. Full name of the VolumeRestore resource. Format:
   *     `projects/&#42;/locations/&#42;/restorePlans/&#42;/restores/&#42;/volumeRestores/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VolumeRestore getVolumeRestore(String name) {
    GetVolumeRestoreRequest request = GetVolumeRestoreRequest.newBuilder().setName(name).build();
    return getVolumeRestore(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the details of a single VolumeRestore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   GetVolumeRestoreRequest request =
   *       GetVolumeRestoreRequest.newBuilder()
   *           .setName(
   *               VolumeRestoreName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[RESTORE_PLAN]",
   *                       "[RESTORE]",
   *                       "[VOLUME_RESTORE]")
   *                   .toString())
   *           .build();
   *   VolumeRestore response = backupForGKEClient.getVolumeRestore(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VolumeRestore getVolumeRestore(GetVolumeRestoreRequest request) {
    return getVolumeRestoreCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the details of a single VolumeRestore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   GetVolumeRestoreRequest request =
   *       GetVolumeRestoreRequest.newBuilder()
   *           .setName(
   *               VolumeRestoreName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[RESTORE_PLAN]",
   *                       "[RESTORE]",
   *                       "[VOLUME_RESTORE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<VolumeRestore> future =
   *       backupForGKEClient.getVolumeRestoreCallable().futureCall(request);
   *   // Do something.
   *   VolumeRestore response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetVolumeRestoreRequest, VolumeRestore> getVolumeRestoreCallable() {
    return stub.getVolumeRestoreCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the link to the backupIndex.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   BackupName backup = BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]");
   *   GetBackupIndexDownloadUrlResponse response =
   *       backupForGKEClient.getBackupIndexDownloadUrl(backup);
   * }
   * }</pre>
   *
   * @param backup Required. Full name of Backup resource. Format:
   *     projects/{project}/locations/{location}/backupPlans/{backup_plan}/backups/{backup}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GetBackupIndexDownloadUrlResponse getBackupIndexDownloadUrl(BackupName backup) {
    GetBackupIndexDownloadUrlRequest request =
        GetBackupIndexDownloadUrlRequest.newBuilder()
            .setBackup(backup == null ? null : backup.toString())
            .build();
    return getBackupIndexDownloadUrl(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the link to the backupIndex.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   String backup =
   *       BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]").toString();
   *   GetBackupIndexDownloadUrlResponse response =
   *       backupForGKEClient.getBackupIndexDownloadUrl(backup);
   * }
   * }</pre>
   *
   * @param backup Required. Full name of Backup resource. Format:
   *     projects/{project}/locations/{location}/backupPlans/{backup_plan}/backups/{backup}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GetBackupIndexDownloadUrlResponse getBackupIndexDownloadUrl(String backup) {
    GetBackupIndexDownloadUrlRequest request =
        GetBackupIndexDownloadUrlRequest.newBuilder().setBackup(backup).build();
    return getBackupIndexDownloadUrl(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the link to the backupIndex.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   GetBackupIndexDownloadUrlRequest request =
   *       GetBackupIndexDownloadUrlRequest.newBuilder()
   *           .setBackup(
   *               BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]").toString())
   *           .build();
   *   GetBackupIndexDownloadUrlResponse response =
   *       backupForGKEClient.getBackupIndexDownloadUrl(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GetBackupIndexDownloadUrlResponse getBackupIndexDownloadUrl(
      GetBackupIndexDownloadUrlRequest request) {
    return getBackupIndexDownloadUrlCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve the link to the backupIndex.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   GetBackupIndexDownloadUrlRequest request =
   *       GetBackupIndexDownloadUrlRequest.newBuilder()
   *           .setBackup(
   *               BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]").toString())
   *           .build();
   *   ApiFuture<GetBackupIndexDownloadUrlResponse> future =
   *       backupForGKEClient.getBackupIndexDownloadUrlCallable().futureCall(request);
   *   // Do something.
   *   GetBackupIndexDownloadUrlResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetBackupIndexDownloadUrlRequest, GetBackupIndexDownloadUrlResponse>
      getBackupIndexDownloadUrlCallable() {
    return stub.getBackupIndexDownloadUrlCallable();
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
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : backupForGKEClient.listLocations(request).iterateAll()) {
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
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       backupForGKEClient.listLocationsPagedCallable().futureCall(request);
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
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = backupForGKEClient.listLocationsCallable().call(request);
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
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = backupForGKEClient.getLocation(request);
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
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = backupForGKEClient.getLocationCallable().futureCall(request);
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
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = backupForGKEClient.setIamPolicy(request);
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
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = backupForGKEClient.setIamPolicyCallable().futureCall(request);
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
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = backupForGKEClient.getIamPolicy(request);
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
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = backupForGKEClient.getIamPolicyCallable().futureCall(request);
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
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = backupForGKEClient.testIamPermissions(request);
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
   * try (BackupForGKEClient backupForGKEClient = BackupForGKEClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[BACKUP]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       backupForGKEClient.testIamPermissionsCallable().futureCall(request);
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

  public static class ListBackupPlansPagedResponse
      extends AbstractPagedListResponse<
          ListBackupPlansRequest,
          ListBackupPlansResponse,
          BackupPlan,
          ListBackupPlansPage,
          ListBackupPlansFixedSizeCollection> {

    public static ApiFuture<ListBackupPlansPagedResponse> createAsync(
        PageContext<ListBackupPlansRequest, ListBackupPlansResponse, BackupPlan> context,
        ApiFuture<ListBackupPlansResponse> futureResponse) {
      ApiFuture<ListBackupPlansPage> futurePage =
          ListBackupPlansPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListBackupPlansPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListBackupPlansPagedResponse(ListBackupPlansPage page) {
      super(page, ListBackupPlansFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListBackupPlansPage
      extends AbstractPage<
          ListBackupPlansRequest, ListBackupPlansResponse, BackupPlan, ListBackupPlansPage> {

    private ListBackupPlansPage(
        PageContext<ListBackupPlansRequest, ListBackupPlansResponse, BackupPlan> context,
        ListBackupPlansResponse response) {
      super(context, response);
    }

    private static ListBackupPlansPage createEmptyPage() {
      return new ListBackupPlansPage(null, null);
    }

    @Override
    protected ListBackupPlansPage createPage(
        PageContext<ListBackupPlansRequest, ListBackupPlansResponse, BackupPlan> context,
        ListBackupPlansResponse response) {
      return new ListBackupPlansPage(context, response);
    }

    @Override
    public ApiFuture<ListBackupPlansPage> createPageAsync(
        PageContext<ListBackupPlansRequest, ListBackupPlansResponse, BackupPlan> context,
        ApiFuture<ListBackupPlansResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListBackupPlansFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListBackupPlansRequest,
          ListBackupPlansResponse,
          BackupPlan,
          ListBackupPlansPage,
          ListBackupPlansFixedSizeCollection> {

    private ListBackupPlansFixedSizeCollection(
        List<ListBackupPlansPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListBackupPlansFixedSizeCollection createEmptyCollection() {
      return new ListBackupPlansFixedSizeCollection(null, 0);
    }

    @Override
    protected ListBackupPlansFixedSizeCollection createCollection(
        List<ListBackupPlansPage> pages, int collectionSize) {
      return new ListBackupPlansFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListBackupChannelsPagedResponse
      extends AbstractPagedListResponse<
          ListBackupChannelsRequest,
          ListBackupChannelsResponse,
          BackupChannel,
          ListBackupChannelsPage,
          ListBackupChannelsFixedSizeCollection> {

    public static ApiFuture<ListBackupChannelsPagedResponse> createAsync(
        PageContext<ListBackupChannelsRequest, ListBackupChannelsResponse, BackupChannel> context,
        ApiFuture<ListBackupChannelsResponse> futureResponse) {
      ApiFuture<ListBackupChannelsPage> futurePage =
          ListBackupChannelsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListBackupChannelsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListBackupChannelsPagedResponse(ListBackupChannelsPage page) {
      super(page, ListBackupChannelsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListBackupChannelsPage
      extends AbstractPage<
          ListBackupChannelsRequest,
          ListBackupChannelsResponse,
          BackupChannel,
          ListBackupChannelsPage> {

    private ListBackupChannelsPage(
        PageContext<ListBackupChannelsRequest, ListBackupChannelsResponse, BackupChannel> context,
        ListBackupChannelsResponse response) {
      super(context, response);
    }

    private static ListBackupChannelsPage createEmptyPage() {
      return new ListBackupChannelsPage(null, null);
    }

    @Override
    protected ListBackupChannelsPage createPage(
        PageContext<ListBackupChannelsRequest, ListBackupChannelsResponse, BackupChannel> context,
        ListBackupChannelsResponse response) {
      return new ListBackupChannelsPage(context, response);
    }

    @Override
    public ApiFuture<ListBackupChannelsPage> createPageAsync(
        PageContext<ListBackupChannelsRequest, ListBackupChannelsResponse, BackupChannel> context,
        ApiFuture<ListBackupChannelsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListBackupChannelsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListBackupChannelsRequest,
          ListBackupChannelsResponse,
          BackupChannel,
          ListBackupChannelsPage,
          ListBackupChannelsFixedSizeCollection> {

    private ListBackupChannelsFixedSizeCollection(
        List<ListBackupChannelsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListBackupChannelsFixedSizeCollection createEmptyCollection() {
      return new ListBackupChannelsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListBackupChannelsFixedSizeCollection createCollection(
        List<ListBackupChannelsPage> pages, int collectionSize) {
      return new ListBackupChannelsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListBackupPlanBindingsPagedResponse
      extends AbstractPagedListResponse<
          ListBackupPlanBindingsRequest,
          ListBackupPlanBindingsResponse,
          BackupPlanBinding,
          ListBackupPlanBindingsPage,
          ListBackupPlanBindingsFixedSizeCollection> {

    public static ApiFuture<ListBackupPlanBindingsPagedResponse> createAsync(
        PageContext<
                ListBackupPlanBindingsRequest, ListBackupPlanBindingsResponse, BackupPlanBinding>
            context,
        ApiFuture<ListBackupPlanBindingsResponse> futureResponse) {
      ApiFuture<ListBackupPlanBindingsPage> futurePage =
          ListBackupPlanBindingsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListBackupPlanBindingsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListBackupPlanBindingsPagedResponse(ListBackupPlanBindingsPage page) {
      super(page, ListBackupPlanBindingsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListBackupPlanBindingsPage
      extends AbstractPage<
          ListBackupPlanBindingsRequest,
          ListBackupPlanBindingsResponse,
          BackupPlanBinding,
          ListBackupPlanBindingsPage> {

    private ListBackupPlanBindingsPage(
        PageContext<
                ListBackupPlanBindingsRequest, ListBackupPlanBindingsResponse, BackupPlanBinding>
            context,
        ListBackupPlanBindingsResponse response) {
      super(context, response);
    }

    private static ListBackupPlanBindingsPage createEmptyPage() {
      return new ListBackupPlanBindingsPage(null, null);
    }

    @Override
    protected ListBackupPlanBindingsPage createPage(
        PageContext<
                ListBackupPlanBindingsRequest, ListBackupPlanBindingsResponse, BackupPlanBinding>
            context,
        ListBackupPlanBindingsResponse response) {
      return new ListBackupPlanBindingsPage(context, response);
    }

    @Override
    public ApiFuture<ListBackupPlanBindingsPage> createPageAsync(
        PageContext<
                ListBackupPlanBindingsRequest, ListBackupPlanBindingsResponse, BackupPlanBinding>
            context,
        ApiFuture<ListBackupPlanBindingsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListBackupPlanBindingsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListBackupPlanBindingsRequest,
          ListBackupPlanBindingsResponse,
          BackupPlanBinding,
          ListBackupPlanBindingsPage,
          ListBackupPlanBindingsFixedSizeCollection> {

    private ListBackupPlanBindingsFixedSizeCollection(
        List<ListBackupPlanBindingsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListBackupPlanBindingsFixedSizeCollection createEmptyCollection() {
      return new ListBackupPlanBindingsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListBackupPlanBindingsFixedSizeCollection createCollection(
        List<ListBackupPlanBindingsPage> pages, int collectionSize) {
      return new ListBackupPlanBindingsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListBackupsPagedResponse
      extends AbstractPagedListResponse<
          ListBackupsRequest,
          ListBackupsResponse,
          Backup,
          ListBackupsPage,
          ListBackupsFixedSizeCollection> {

    public static ApiFuture<ListBackupsPagedResponse> createAsync(
        PageContext<ListBackupsRequest, ListBackupsResponse, Backup> context,
        ApiFuture<ListBackupsResponse> futureResponse) {
      ApiFuture<ListBackupsPage> futurePage =
          ListBackupsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListBackupsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListBackupsPagedResponse(ListBackupsPage page) {
      super(page, ListBackupsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListBackupsPage
      extends AbstractPage<ListBackupsRequest, ListBackupsResponse, Backup, ListBackupsPage> {

    private ListBackupsPage(
        PageContext<ListBackupsRequest, ListBackupsResponse, Backup> context,
        ListBackupsResponse response) {
      super(context, response);
    }

    private static ListBackupsPage createEmptyPage() {
      return new ListBackupsPage(null, null);
    }

    @Override
    protected ListBackupsPage createPage(
        PageContext<ListBackupsRequest, ListBackupsResponse, Backup> context,
        ListBackupsResponse response) {
      return new ListBackupsPage(context, response);
    }

    @Override
    public ApiFuture<ListBackupsPage> createPageAsync(
        PageContext<ListBackupsRequest, ListBackupsResponse, Backup> context,
        ApiFuture<ListBackupsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListBackupsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListBackupsRequest,
          ListBackupsResponse,
          Backup,
          ListBackupsPage,
          ListBackupsFixedSizeCollection> {

    private ListBackupsFixedSizeCollection(List<ListBackupsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListBackupsFixedSizeCollection createEmptyCollection() {
      return new ListBackupsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListBackupsFixedSizeCollection createCollection(
        List<ListBackupsPage> pages, int collectionSize) {
      return new ListBackupsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListVolumeBackupsPagedResponse
      extends AbstractPagedListResponse<
          ListVolumeBackupsRequest,
          ListVolumeBackupsResponse,
          VolumeBackup,
          ListVolumeBackupsPage,
          ListVolumeBackupsFixedSizeCollection> {

    public static ApiFuture<ListVolumeBackupsPagedResponse> createAsync(
        PageContext<ListVolumeBackupsRequest, ListVolumeBackupsResponse, VolumeBackup> context,
        ApiFuture<ListVolumeBackupsResponse> futureResponse) {
      ApiFuture<ListVolumeBackupsPage> futurePage =
          ListVolumeBackupsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListVolumeBackupsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListVolumeBackupsPagedResponse(ListVolumeBackupsPage page) {
      super(page, ListVolumeBackupsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListVolumeBackupsPage
      extends AbstractPage<
          ListVolumeBackupsRequest,
          ListVolumeBackupsResponse,
          VolumeBackup,
          ListVolumeBackupsPage> {

    private ListVolumeBackupsPage(
        PageContext<ListVolumeBackupsRequest, ListVolumeBackupsResponse, VolumeBackup> context,
        ListVolumeBackupsResponse response) {
      super(context, response);
    }

    private static ListVolumeBackupsPage createEmptyPage() {
      return new ListVolumeBackupsPage(null, null);
    }

    @Override
    protected ListVolumeBackupsPage createPage(
        PageContext<ListVolumeBackupsRequest, ListVolumeBackupsResponse, VolumeBackup> context,
        ListVolumeBackupsResponse response) {
      return new ListVolumeBackupsPage(context, response);
    }

    @Override
    public ApiFuture<ListVolumeBackupsPage> createPageAsync(
        PageContext<ListVolumeBackupsRequest, ListVolumeBackupsResponse, VolumeBackup> context,
        ApiFuture<ListVolumeBackupsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListVolumeBackupsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListVolumeBackupsRequest,
          ListVolumeBackupsResponse,
          VolumeBackup,
          ListVolumeBackupsPage,
          ListVolumeBackupsFixedSizeCollection> {

    private ListVolumeBackupsFixedSizeCollection(
        List<ListVolumeBackupsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListVolumeBackupsFixedSizeCollection createEmptyCollection() {
      return new ListVolumeBackupsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListVolumeBackupsFixedSizeCollection createCollection(
        List<ListVolumeBackupsPage> pages, int collectionSize) {
      return new ListVolumeBackupsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListRestorePlansPagedResponse
      extends AbstractPagedListResponse<
          ListRestorePlansRequest,
          ListRestorePlansResponse,
          RestorePlan,
          ListRestorePlansPage,
          ListRestorePlansFixedSizeCollection> {

    public static ApiFuture<ListRestorePlansPagedResponse> createAsync(
        PageContext<ListRestorePlansRequest, ListRestorePlansResponse, RestorePlan> context,
        ApiFuture<ListRestorePlansResponse> futureResponse) {
      ApiFuture<ListRestorePlansPage> futurePage =
          ListRestorePlansPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListRestorePlansPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListRestorePlansPagedResponse(ListRestorePlansPage page) {
      super(page, ListRestorePlansFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRestorePlansPage
      extends AbstractPage<
          ListRestorePlansRequest, ListRestorePlansResponse, RestorePlan, ListRestorePlansPage> {

    private ListRestorePlansPage(
        PageContext<ListRestorePlansRequest, ListRestorePlansResponse, RestorePlan> context,
        ListRestorePlansResponse response) {
      super(context, response);
    }

    private static ListRestorePlansPage createEmptyPage() {
      return new ListRestorePlansPage(null, null);
    }

    @Override
    protected ListRestorePlansPage createPage(
        PageContext<ListRestorePlansRequest, ListRestorePlansResponse, RestorePlan> context,
        ListRestorePlansResponse response) {
      return new ListRestorePlansPage(context, response);
    }

    @Override
    public ApiFuture<ListRestorePlansPage> createPageAsync(
        PageContext<ListRestorePlansRequest, ListRestorePlansResponse, RestorePlan> context,
        ApiFuture<ListRestorePlansResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRestorePlansFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRestorePlansRequest,
          ListRestorePlansResponse,
          RestorePlan,
          ListRestorePlansPage,
          ListRestorePlansFixedSizeCollection> {

    private ListRestorePlansFixedSizeCollection(
        List<ListRestorePlansPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRestorePlansFixedSizeCollection createEmptyCollection() {
      return new ListRestorePlansFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRestorePlansFixedSizeCollection createCollection(
        List<ListRestorePlansPage> pages, int collectionSize) {
      return new ListRestorePlansFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListRestoreChannelsPagedResponse
      extends AbstractPagedListResponse<
          ListRestoreChannelsRequest,
          ListRestoreChannelsResponse,
          RestoreChannel,
          ListRestoreChannelsPage,
          ListRestoreChannelsFixedSizeCollection> {

    public static ApiFuture<ListRestoreChannelsPagedResponse> createAsync(
        PageContext<ListRestoreChannelsRequest, ListRestoreChannelsResponse, RestoreChannel>
            context,
        ApiFuture<ListRestoreChannelsResponse> futureResponse) {
      ApiFuture<ListRestoreChannelsPage> futurePage =
          ListRestoreChannelsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListRestoreChannelsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListRestoreChannelsPagedResponse(ListRestoreChannelsPage page) {
      super(page, ListRestoreChannelsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRestoreChannelsPage
      extends AbstractPage<
          ListRestoreChannelsRequest,
          ListRestoreChannelsResponse,
          RestoreChannel,
          ListRestoreChannelsPage> {

    private ListRestoreChannelsPage(
        PageContext<ListRestoreChannelsRequest, ListRestoreChannelsResponse, RestoreChannel>
            context,
        ListRestoreChannelsResponse response) {
      super(context, response);
    }

    private static ListRestoreChannelsPage createEmptyPage() {
      return new ListRestoreChannelsPage(null, null);
    }

    @Override
    protected ListRestoreChannelsPage createPage(
        PageContext<ListRestoreChannelsRequest, ListRestoreChannelsResponse, RestoreChannel>
            context,
        ListRestoreChannelsResponse response) {
      return new ListRestoreChannelsPage(context, response);
    }

    @Override
    public ApiFuture<ListRestoreChannelsPage> createPageAsync(
        PageContext<ListRestoreChannelsRequest, ListRestoreChannelsResponse, RestoreChannel>
            context,
        ApiFuture<ListRestoreChannelsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRestoreChannelsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRestoreChannelsRequest,
          ListRestoreChannelsResponse,
          RestoreChannel,
          ListRestoreChannelsPage,
          ListRestoreChannelsFixedSizeCollection> {

    private ListRestoreChannelsFixedSizeCollection(
        List<ListRestoreChannelsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRestoreChannelsFixedSizeCollection createEmptyCollection() {
      return new ListRestoreChannelsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRestoreChannelsFixedSizeCollection createCollection(
        List<ListRestoreChannelsPage> pages, int collectionSize) {
      return new ListRestoreChannelsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListRestorePlanBindingsPagedResponse
      extends AbstractPagedListResponse<
          ListRestorePlanBindingsRequest,
          ListRestorePlanBindingsResponse,
          RestorePlanBinding,
          ListRestorePlanBindingsPage,
          ListRestorePlanBindingsFixedSizeCollection> {

    public static ApiFuture<ListRestorePlanBindingsPagedResponse> createAsync(
        PageContext<
                ListRestorePlanBindingsRequest, ListRestorePlanBindingsResponse, RestorePlanBinding>
            context,
        ApiFuture<ListRestorePlanBindingsResponse> futureResponse) {
      ApiFuture<ListRestorePlanBindingsPage> futurePage =
          ListRestorePlanBindingsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListRestorePlanBindingsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListRestorePlanBindingsPagedResponse(ListRestorePlanBindingsPage page) {
      super(page, ListRestorePlanBindingsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRestorePlanBindingsPage
      extends AbstractPage<
          ListRestorePlanBindingsRequest,
          ListRestorePlanBindingsResponse,
          RestorePlanBinding,
          ListRestorePlanBindingsPage> {

    private ListRestorePlanBindingsPage(
        PageContext<
                ListRestorePlanBindingsRequest, ListRestorePlanBindingsResponse, RestorePlanBinding>
            context,
        ListRestorePlanBindingsResponse response) {
      super(context, response);
    }

    private static ListRestorePlanBindingsPage createEmptyPage() {
      return new ListRestorePlanBindingsPage(null, null);
    }

    @Override
    protected ListRestorePlanBindingsPage createPage(
        PageContext<
                ListRestorePlanBindingsRequest, ListRestorePlanBindingsResponse, RestorePlanBinding>
            context,
        ListRestorePlanBindingsResponse response) {
      return new ListRestorePlanBindingsPage(context, response);
    }

    @Override
    public ApiFuture<ListRestorePlanBindingsPage> createPageAsync(
        PageContext<
                ListRestorePlanBindingsRequest, ListRestorePlanBindingsResponse, RestorePlanBinding>
            context,
        ApiFuture<ListRestorePlanBindingsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRestorePlanBindingsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRestorePlanBindingsRequest,
          ListRestorePlanBindingsResponse,
          RestorePlanBinding,
          ListRestorePlanBindingsPage,
          ListRestorePlanBindingsFixedSizeCollection> {

    private ListRestorePlanBindingsFixedSizeCollection(
        List<ListRestorePlanBindingsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRestorePlanBindingsFixedSizeCollection createEmptyCollection() {
      return new ListRestorePlanBindingsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRestorePlanBindingsFixedSizeCollection createCollection(
        List<ListRestorePlanBindingsPage> pages, int collectionSize) {
      return new ListRestorePlanBindingsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListRestoresPagedResponse
      extends AbstractPagedListResponse<
          ListRestoresRequest,
          ListRestoresResponse,
          Restore,
          ListRestoresPage,
          ListRestoresFixedSizeCollection> {

    public static ApiFuture<ListRestoresPagedResponse> createAsync(
        PageContext<ListRestoresRequest, ListRestoresResponse, Restore> context,
        ApiFuture<ListRestoresResponse> futureResponse) {
      ApiFuture<ListRestoresPage> futurePage =
          ListRestoresPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListRestoresPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListRestoresPagedResponse(ListRestoresPage page) {
      super(page, ListRestoresFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRestoresPage
      extends AbstractPage<ListRestoresRequest, ListRestoresResponse, Restore, ListRestoresPage> {

    private ListRestoresPage(
        PageContext<ListRestoresRequest, ListRestoresResponse, Restore> context,
        ListRestoresResponse response) {
      super(context, response);
    }

    private static ListRestoresPage createEmptyPage() {
      return new ListRestoresPage(null, null);
    }

    @Override
    protected ListRestoresPage createPage(
        PageContext<ListRestoresRequest, ListRestoresResponse, Restore> context,
        ListRestoresResponse response) {
      return new ListRestoresPage(context, response);
    }

    @Override
    public ApiFuture<ListRestoresPage> createPageAsync(
        PageContext<ListRestoresRequest, ListRestoresResponse, Restore> context,
        ApiFuture<ListRestoresResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRestoresFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRestoresRequest,
          ListRestoresResponse,
          Restore,
          ListRestoresPage,
          ListRestoresFixedSizeCollection> {

    private ListRestoresFixedSizeCollection(List<ListRestoresPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRestoresFixedSizeCollection createEmptyCollection() {
      return new ListRestoresFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRestoresFixedSizeCollection createCollection(
        List<ListRestoresPage> pages, int collectionSize) {
      return new ListRestoresFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListVolumeRestoresPagedResponse
      extends AbstractPagedListResponse<
          ListVolumeRestoresRequest,
          ListVolumeRestoresResponse,
          VolumeRestore,
          ListVolumeRestoresPage,
          ListVolumeRestoresFixedSizeCollection> {

    public static ApiFuture<ListVolumeRestoresPagedResponse> createAsync(
        PageContext<ListVolumeRestoresRequest, ListVolumeRestoresResponse, VolumeRestore> context,
        ApiFuture<ListVolumeRestoresResponse> futureResponse) {
      ApiFuture<ListVolumeRestoresPage> futurePage =
          ListVolumeRestoresPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListVolumeRestoresPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListVolumeRestoresPagedResponse(ListVolumeRestoresPage page) {
      super(page, ListVolumeRestoresFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListVolumeRestoresPage
      extends AbstractPage<
          ListVolumeRestoresRequest,
          ListVolumeRestoresResponse,
          VolumeRestore,
          ListVolumeRestoresPage> {

    private ListVolumeRestoresPage(
        PageContext<ListVolumeRestoresRequest, ListVolumeRestoresResponse, VolumeRestore> context,
        ListVolumeRestoresResponse response) {
      super(context, response);
    }

    private static ListVolumeRestoresPage createEmptyPage() {
      return new ListVolumeRestoresPage(null, null);
    }

    @Override
    protected ListVolumeRestoresPage createPage(
        PageContext<ListVolumeRestoresRequest, ListVolumeRestoresResponse, VolumeRestore> context,
        ListVolumeRestoresResponse response) {
      return new ListVolumeRestoresPage(context, response);
    }

    @Override
    public ApiFuture<ListVolumeRestoresPage> createPageAsync(
        PageContext<ListVolumeRestoresRequest, ListVolumeRestoresResponse, VolumeRestore> context,
        ApiFuture<ListVolumeRestoresResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListVolumeRestoresFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListVolumeRestoresRequest,
          ListVolumeRestoresResponse,
          VolumeRestore,
          ListVolumeRestoresPage,
          ListVolumeRestoresFixedSizeCollection> {

    private ListVolumeRestoresFixedSizeCollection(
        List<ListVolumeRestoresPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListVolumeRestoresFixedSizeCollection createEmptyCollection() {
      return new ListVolumeRestoresFixedSizeCollection(null, 0);
    }

    @Override
    protected ListVolumeRestoresFixedSizeCollection createCollection(
        List<ListVolumeRestoresPage> pages, int collectionSize) {
      return new ListVolumeRestoresFixedSizeCollection(pages, collectionSize);
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
