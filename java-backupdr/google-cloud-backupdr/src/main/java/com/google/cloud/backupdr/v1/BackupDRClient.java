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

package com.google.cloud.backupdr.v1;

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
import com.google.cloud.backupdr.v1.stub.BackupDRStub;
import com.google.cloud.backupdr.v1.stub.BackupDRStubSettings;
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
 * Service Description: The BackupDR Service
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
 * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
 *   ManagementServerName name =
 *       ManagementServerName.of("[PROJECT]", "[LOCATION]", "[MANAGEMENTSERVER]");
 *   ManagementServer response = backupDRClient.getManagementServer(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the BackupDRClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> ListManagementServers</td>
 *      <td><p> Lists ManagementServers in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listManagementServers(ListManagementServersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listManagementServers(LocationName parent)
 *           <li><p> listManagementServers(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listManagementServersPagedCallable()
 *           <li><p> listManagementServersCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetManagementServer</td>
 *      <td><p> Gets details of a single ManagementServer.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getManagementServer(GetManagementServerRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getManagementServer(ManagementServerName name)
 *           <li><p> getManagementServer(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getManagementServerCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateManagementServer</td>
 *      <td><p> Creates a new ManagementServer in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createManagementServerAsync(CreateManagementServerRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createManagementServerAsync(LocationName parent, ManagementServer managementServer, String managementServerId)
 *           <li><p> createManagementServerAsync(String parent, ManagementServer managementServer, String managementServerId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createManagementServerOperationCallable()
 *           <li><p> createManagementServerCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteManagementServer</td>
 *      <td><p> Deletes a single ManagementServer.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteManagementServerAsync(DeleteManagementServerRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteManagementServerAsync(ManagementServerName name)
 *           <li><p> deleteManagementServerAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteManagementServerOperationCallable()
 *           <li><p> deleteManagementServerCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateBackupVault</td>
 *      <td><p> Creates a new BackupVault in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createBackupVaultAsync(CreateBackupVaultRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createBackupVaultAsync(LocationName parent, BackupVault backupVault, String backupVaultId)
 *           <li><p> createBackupVaultAsync(String parent, BackupVault backupVault, String backupVaultId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createBackupVaultOperationCallable()
 *           <li><p> createBackupVaultCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListBackupVaults</td>
 *      <td><p> Lists BackupVaults in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listBackupVaults(ListBackupVaultsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listBackupVaults(LocationName parent)
 *           <li><p> listBackupVaults(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listBackupVaultsPagedCallable()
 *           <li><p> listBackupVaultsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> FetchUsableBackupVaults</td>
 *      <td><p> FetchUsableBackupVaults lists usable BackupVaults in a given project and location. Usable BackupVault are the ones that user has backupdr.backupVaults.get permission.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> fetchUsableBackupVaults(FetchUsableBackupVaultsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> fetchUsableBackupVaults(LocationName parent)
 *           <li><p> fetchUsableBackupVaults(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> fetchUsableBackupVaultsPagedCallable()
 *           <li><p> fetchUsableBackupVaultsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetBackupVault</td>
 *      <td><p> Gets details of a BackupVault.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getBackupVault(GetBackupVaultRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getBackupVault(BackupVaultName name)
 *           <li><p> getBackupVault(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getBackupVaultCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateBackupVault</td>
 *      <td><p> Updates the settings of a BackupVault.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateBackupVaultAsync(UpdateBackupVaultRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateBackupVaultAsync(BackupVault backupVault, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateBackupVaultOperationCallable()
 *           <li><p> updateBackupVaultCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteBackupVault</td>
 *      <td><p> Deletes a BackupVault.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteBackupVaultAsync(DeleteBackupVaultRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteBackupVaultAsync(BackupVaultName name)
 *           <li><p> deleteBackupVaultAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteBackupVaultOperationCallable()
 *           <li><p> deleteBackupVaultCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListDataSources</td>
 *      <td><p> Lists DataSources in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listDataSources(ListDataSourcesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listDataSources(BackupVaultName parent)
 *           <li><p> listDataSources(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listDataSourcesPagedCallable()
 *           <li><p> listDataSourcesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetDataSource</td>
 *      <td><p> Gets details of a DataSource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDataSource(GetDataSourceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getDataSource(DataSourceName name)
 *           <li><p> getDataSource(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDataSourceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateDataSource</td>
 *      <td><p> Updates the settings of a DataSource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateDataSourceAsync(UpdateDataSourceRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateDataSourceAsync(DataSource dataSource, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateDataSourceOperationCallable()
 *           <li><p> updateDataSourceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListBackups</td>
 *      <td><p> Lists Backups in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listBackups(ListBackupsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listBackups(DataSourceName parent)
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
 *      <td><p> Gets details of a Backup.</td>
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
 *      <td><p> Updates the settings of a Backup.</td>
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
 *      <td><p> Deletes a Backup.</td>
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
 *      <td><p> RestoreBackup</td>
 *      <td><p> Restore from a Backup</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> restoreBackupAsync(RestoreBackupRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> restoreBackupAsync(BackupName name)
 *           <li><p> restoreBackupAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> restoreBackupOperationCallable()
 *           <li><p> restoreBackupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateBackupPlan</td>
 *      <td><p> Create a BackupPlan</td>
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
 *      <td><p> GetBackupPlan</td>
 *      <td><p> Gets details of a single BackupPlan.</td>
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
 *      <td><p> ListBackupPlans</td>
 *      <td><p> Lists BackupPlans in a given project and location.</td>
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
 *      <td><p> DeleteBackupPlan</td>
 *      <td><p> Deletes a single BackupPlan.</td>
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
 *      <td><p> GetBackupPlanRevision</td>
 *      <td><p> Gets details of a single BackupPlanRevision.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getBackupPlanRevision(GetBackupPlanRevisionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getBackupPlanRevision(BackupPlanRevisionName name)
 *           <li><p> getBackupPlanRevision(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getBackupPlanRevisionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListBackupPlanRevisions</td>
 *      <td><p> Lists BackupPlanRevisions in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listBackupPlanRevisions(ListBackupPlanRevisionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listBackupPlanRevisions(BackupPlanName parent)
 *           <li><p> listBackupPlanRevisions(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listBackupPlanRevisionsPagedCallable()
 *           <li><p> listBackupPlanRevisionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateBackupPlanAssociation</td>
 *      <td><p> Create a BackupPlanAssociation</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createBackupPlanAssociationAsync(CreateBackupPlanAssociationRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createBackupPlanAssociationAsync(LocationName parent, BackupPlanAssociation backupPlanAssociation, String backupPlanAssociationId)
 *           <li><p> createBackupPlanAssociationAsync(String parent, BackupPlanAssociation backupPlanAssociation, String backupPlanAssociationId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createBackupPlanAssociationOperationCallable()
 *           <li><p> createBackupPlanAssociationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateBackupPlanAssociation</td>
 *      <td><p> Update a BackupPlanAssociation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateBackupPlanAssociationAsync(UpdateBackupPlanAssociationRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateBackupPlanAssociationAsync(BackupPlanAssociation backupPlanAssociation, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateBackupPlanAssociationOperationCallable()
 *           <li><p> updateBackupPlanAssociationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetBackupPlanAssociation</td>
 *      <td><p> Gets details of a single BackupPlanAssociation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getBackupPlanAssociation(GetBackupPlanAssociationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getBackupPlanAssociation(BackupPlanAssociationName name)
 *           <li><p> getBackupPlanAssociation(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getBackupPlanAssociationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListBackupPlanAssociations</td>
 *      <td><p> Lists BackupPlanAssociations in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listBackupPlanAssociations(ListBackupPlanAssociationsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listBackupPlanAssociations(LocationName parent)
 *           <li><p> listBackupPlanAssociations(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listBackupPlanAssociationsPagedCallable()
 *           <li><p> listBackupPlanAssociationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> FetchBackupPlanAssociationsForResourceType</td>
 *      <td><p> List BackupPlanAssociations for a given resource type.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> fetchBackupPlanAssociationsForResourceType(FetchBackupPlanAssociationsForResourceTypeRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> fetchBackupPlanAssociationsForResourceType(LocationName parent, String resourceType)
 *           <li><p> fetchBackupPlanAssociationsForResourceType(String parent, String resourceType)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> fetchBackupPlanAssociationsForResourceTypePagedCallable()
 *           <li><p> fetchBackupPlanAssociationsForResourceTypeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteBackupPlanAssociation</td>
 *      <td><p> Deletes a single BackupPlanAssociation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteBackupPlanAssociationAsync(DeleteBackupPlanAssociationRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteBackupPlanAssociationAsync(BackupPlanAssociationName name)
 *           <li><p> deleteBackupPlanAssociationAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteBackupPlanAssociationOperationCallable()
 *           <li><p> deleteBackupPlanAssociationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> TriggerBackup</td>
 *      <td><p> Triggers a new Backup.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> triggerBackupAsync(TriggerBackupRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> triggerBackupAsync(BackupPlanAssociationName name, String ruleId)
 *           <li><p> triggerBackupAsync(String name, String ruleId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> triggerBackupOperationCallable()
 *           <li><p> triggerBackupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetDataSourceReference</td>
 *      <td><p> Gets details of a single DataSourceReference.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDataSourceReference(GetDataSourceReferenceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getDataSourceReference(DataSourceReferenceName name)
 *           <li><p> getDataSourceReference(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDataSourceReferenceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> FetchDataSourceReferencesForResourceType</td>
 *      <td><p> Fetch DataSourceReferences for a given project, location and resource type.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> fetchDataSourceReferencesForResourceType(FetchDataSourceReferencesForResourceTypeRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> fetchDataSourceReferencesForResourceType(LocationName parent, String resourceType)
 *           <li><p> fetchDataSourceReferencesForResourceType(String parent, String resourceType)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> fetchDataSourceReferencesForResourceTypePagedCallable()
 *           <li><p> fetchDataSourceReferencesForResourceTypeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> InitializeService</td>
 *      <td><p> Initializes the service related config for a project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> initializeServiceAsync(InitializeServiceRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> initializeServiceOperationCallable()
 *           <li><p> initializeServiceCallable()
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
 * <p>This class can be customized by passing in a custom instance of BackupDRSettings to create().
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
 * BackupDRSettings backupDRSettings =
 *     BackupDRSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * BackupDRClient backupDRClient = BackupDRClient.create(backupDRSettings);
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
 * BackupDRSettings backupDRSettings =
 *     BackupDRSettings.newBuilder().setEndpoint(myEndpoint).build();
 * BackupDRClient backupDRClient = BackupDRClient.create(backupDRSettings);
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
 * BackupDRSettings backupDRSettings = BackupDRSettings.newHttpJsonBuilder().build();
 * BackupDRClient backupDRClient = BackupDRClient.create(backupDRSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class BackupDRClient implements BackgroundResource {
  private final BackupDRSettings settings;
  private final BackupDRStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of BackupDRClient with default settings. */
  public static final BackupDRClient create() throws IOException {
    return create(BackupDRSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of BackupDRClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final BackupDRClient create(BackupDRSettings settings) throws IOException {
    return new BackupDRClient(settings);
  }

  /**
   * Constructs an instance of BackupDRClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(BackupDRSettings).
   */
  public static final BackupDRClient create(BackupDRStub stub) {
    return new BackupDRClient(stub);
  }

  /**
   * Constructs an instance of BackupDRClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected BackupDRClient(BackupDRSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((BackupDRStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected BackupDRClient(BackupDRStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final BackupDRSettings getSettings() {
    return settings;
  }

  public BackupDRStub getStub() {
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
   * Lists ManagementServers in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (ManagementServer element : backupDRClient.listManagementServers(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location for which to retrieve management servers
   *     information, in the format 'projects/{project_id}/locations/{location}'. In Cloud BackupDR,
   *     locations map to Google Cloud regions, for example
   *     <ul>
   *       <li>&#42;us-central1&#42;&#42;. To retrieve management servers for all locations, use "-"
   *           for the '{location}' value.
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListManagementServersPagedResponse listManagementServers(LocationName parent) {
    ListManagementServersRequest request =
        ListManagementServersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listManagementServers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ManagementServers in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (ManagementServer element : backupDRClient.listManagementServers(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location for which to retrieve management servers
   *     information, in the format 'projects/{project_id}/locations/{location}'. In Cloud BackupDR,
   *     locations map to Google Cloud regions, for example
   *     <ul>
   *       <li>&#42;us-central1&#42;&#42;. To retrieve management servers for all locations, use "-"
   *           for the '{location}' value.
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListManagementServersPagedResponse listManagementServers(String parent) {
    ListManagementServersRequest request =
        ListManagementServersRequest.newBuilder().setParent(parent).build();
    return listManagementServers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ManagementServers in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   ListManagementServersRequest request =
   *       ListManagementServersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (ManagementServer element : backupDRClient.listManagementServers(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListManagementServersPagedResponse listManagementServers(
      ListManagementServersRequest request) {
    return listManagementServersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ManagementServers in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   ListManagementServersRequest request =
   *       ListManagementServersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<ManagementServer> future =
   *       backupDRClient.listManagementServersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ManagementServer element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListManagementServersRequest, ListManagementServersPagedResponse>
      listManagementServersPagedCallable() {
    return stub.listManagementServersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ManagementServers in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   ListManagementServersRequest request =
   *       ListManagementServersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListManagementServersResponse response =
   *         backupDRClient.listManagementServersCallable().call(request);
   *     for (ManagementServer element : response.getManagementServersList()) {
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
  public final UnaryCallable<ListManagementServersRequest, ListManagementServersResponse>
      listManagementServersCallable() {
    return stub.listManagementServersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ManagementServer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   ManagementServerName name =
   *       ManagementServerName.of("[PROJECT]", "[LOCATION]", "[MANAGEMENTSERVER]");
   *   ManagementServer response = backupDRClient.getManagementServer(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the management server resource name, in the format
   *     'projects/{project_id}/locations/{location}/managementServers/{resource_name}'
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ManagementServer getManagementServer(ManagementServerName name) {
    GetManagementServerRequest request =
        GetManagementServerRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getManagementServer(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ManagementServer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   String name =
   *       ManagementServerName.of("[PROJECT]", "[LOCATION]", "[MANAGEMENTSERVER]").toString();
   *   ManagementServer response = backupDRClient.getManagementServer(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the management server resource name, in the format
   *     'projects/{project_id}/locations/{location}/managementServers/{resource_name}'
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ManagementServer getManagementServer(String name) {
    GetManagementServerRequest request =
        GetManagementServerRequest.newBuilder().setName(name).build();
    return getManagementServer(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ManagementServer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   GetManagementServerRequest request =
   *       GetManagementServerRequest.newBuilder()
   *           .setName(
   *               ManagementServerName.of("[PROJECT]", "[LOCATION]", "[MANAGEMENTSERVER]")
   *                   .toString())
   *           .build();
   *   ManagementServer response = backupDRClient.getManagementServer(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ManagementServer getManagementServer(GetManagementServerRequest request) {
    return getManagementServerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ManagementServer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   GetManagementServerRequest request =
   *       GetManagementServerRequest.newBuilder()
   *           .setName(
   *               ManagementServerName.of("[PROJECT]", "[LOCATION]", "[MANAGEMENTSERVER]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ManagementServer> future =
   *       backupDRClient.getManagementServerCallable().futureCall(request);
   *   // Do something.
   *   ManagementServer response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetManagementServerRequest, ManagementServer>
      getManagementServerCallable() {
    return stub.getManagementServerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ManagementServer in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ManagementServer managementServer = ManagementServer.newBuilder().build();
   *   String managementServerId = "managementServerId-1229628127";
   *   ManagementServer response =
   *       backupDRClient
   *           .createManagementServerAsync(parent, managementServer, managementServerId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The management server project and location in the format
   *     'projects/{project_id}/locations/{location}'. In Cloud Backup and DR locations map to
   *     Google Cloud regions, for example &#42;&#42;us-central1&#42;&#42;.
   * @param managementServer Required. A [management server
   *     resource][google.cloud.backupdr.v1.ManagementServer]
   * @param managementServerId Required. The name of the management server to create. The name must
   *     be unique for the specified project and location.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ManagementServer, OperationMetadata> createManagementServerAsync(
      LocationName parent, ManagementServer managementServer, String managementServerId) {
    CreateManagementServerRequest request =
        CreateManagementServerRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setManagementServer(managementServer)
            .setManagementServerId(managementServerId)
            .build();
    return createManagementServerAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ManagementServer in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   ManagementServer managementServer = ManagementServer.newBuilder().build();
   *   String managementServerId = "managementServerId-1229628127";
   *   ManagementServer response =
   *       backupDRClient
   *           .createManagementServerAsync(parent, managementServer, managementServerId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The management server project and location in the format
   *     'projects/{project_id}/locations/{location}'. In Cloud Backup and DR locations map to
   *     Google Cloud regions, for example &#42;&#42;us-central1&#42;&#42;.
   * @param managementServer Required. A [management server
   *     resource][google.cloud.backupdr.v1.ManagementServer]
   * @param managementServerId Required. The name of the management server to create. The name must
   *     be unique for the specified project and location.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ManagementServer, OperationMetadata> createManagementServerAsync(
      String parent, ManagementServer managementServer, String managementServerId) {
    CreateManagementServerRequest request =
        CreateManagementServerRequest.newBuilder()
            .setParent(parent)
            .setManagementServer(managementServer)
            .setManagementServerId(managementServerId)
            .build();
    return createManagementServerAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ManagementServer in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   CreateManagementServerRequest request =
   *       CreateManagementServerRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setManagementServerId("managementServerId-1229628127")
   *           .setManagementServer(ManagementServer.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ManagementServer response = backupDRClient.createManagementServerAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ManagementServer, OperationMetadata> createManagementServerAsync(
      CreateManagementServerRequest request) {
    return createManagementServerOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ManagementServer in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   CreateManagementServerRequest request =
   *       CreateManagementServerRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setManagementServerId("managementServerId-1229628127")
   *           .setManagementServer(ManagementServer.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<ManagementServer, OperationMetadata> future =
   *       backupDRClient.createManagementServerOperationCallable().futureCall(request);
   *   // Do something.
   *   ManagementServer response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateManagementServerRequest, ManagementServer, OperationMetadata>
      createManagementServerOperationCallable() {
    return stub.createManagementServerOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ManagementServer in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   CreateManagementServerRequest request =
   *       CreateManagementServerRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setManagementServerId("managementServerId-1229628127")
   *           .setManagementServer(ManagementServer.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       backupDRClient.createManagementServerCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateManagementServerRequest, Operation>
      createManagementServerCallable() {
    return stub.createManagementServerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ManagementServer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   ManagementServerName name =
   *       ManagementServerName.of("[PROJECT]", "[LOCATION]", "[MANAGEMENTSERVER]");
   *   backupDRClient.deleteManagementServerAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteManagementServerAsync(
      ManagementServerName name) {
    DeleteManagementServerRequest request =
        DeleteManagementServerRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteManagementServerAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ManagementServer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   String name =
   *       ManagementServerName.of("[PROJECT]", "[LOCATION]", "[MANAGEMENTSERVER]").toString();
   *   backupDRClient.deleteManagementServerAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteManagementServerAsync(String name) {
    DeleteManagementServerRequest request =
        DeleteManagementServerRequest.newBuilder().setName(name).build();
    return deleteManagementServerAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ManagementServer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   DeleteManagementServerRequest request =
   *       DeleteManagementServerRequest.newBuilder()
   *           .setName(
   *               ManagementServerName.of("[PROJECT]", "[LOCATION]", "[MANAGEMENTSERVER]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   backupDRClient.deleteManagementServerAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteManagementServerAsync(
      DeleteManagementServerRequest request) {
    return deleteManagementServerOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ManagementServer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   DeleteManagementServerRequest request =
   *       DeleteManagementServerRequest.newBuilder()
   *           .setName(
   *               ManagementServerName.of("[PROJECT]", "[LOCATION]", "[MANAGEMENTSERVER]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       backupDRClient.deleteManagementServerOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteManagementServerRequest, Empty, OperationMetadata>
      deleteManagementServerOperationCallable() {
    return stub.deleteManagementServerOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ManagementServer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   DeleteManagementServerRequest request =
   *       DeleteManagementServerRequest.newBuilder()
   *           .setName(
   *               ManagementServerName.of("[PROJECT]", "[LOCATION]", "[MANAGEMENTSERVER]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       backupDRClient.deleteManagementServerCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteManagementServerRequest, Operation>
      deleteManagementServerCallable() {
    return stub.deleteManagementServerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new BackupVault in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   BackupVault backupVault = BackupVault.newBuilder().build();
   *   String backupVaultId = "backupVaultId-1897432373";
   *   BackupVault response =
   *       backupDRClient.createBackupVaultAsync(parent, backupVault, backupVaultId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param backupVault Required. The resource being created
   * @param backupVaultId Required. ID of the requesting object If auto-generating ID server-side,
   *     remove this field and backup_vault_id from the method_signature of Create RPC
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BackupVault, OperationMetadata> createBackupVaultAsync(
      LocationName parent, BackupVault backupVault, String backupVaultId) {
    CreateBackupVaultRequest request =
        CreateBackupVaultRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setBackupVault(backupVault)
            .setBackupVaultId(backupVaultId)
            .build();
    return createBackupVaultAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new BackupVault in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   BackupVault backupVault = BackupVault.newBuilder().build();
   *   String backupVaultId = "backupVaultId-1897432373";
   *   BackupVault response =
   *       backupDRClient.createBackupVaultAsync(parent, backupVault, backupVaultId).get();
   * }
   * }</pre>
   *
   * @param parent Required. Value for parent.
   * @param backupVault Required. The resource being created
   * @param backupVaultId Required. ID of the requesting object If auto-generating ID server-side,
   *     remove this field and backup_vault_id from the method_signature of Create RPC
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BackupVault, OperationMetadata> createBackupVaultAsync(
      String parent, BackupVault backupVault, String backupVaultId) {
    CreateBackupVaultRequest request =
        CreateBackupVaultRequest.newBuilder()
            .setParent(parent)
            .setBackupVault(backupVault)
            .setBackupVaultId(backupVaultId)
            .build();
    return createBackupVaultAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new BackupVault in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   CreateBackupVaultRequest request =
   *       CreateBackupVaultRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setBackupVaultId("backupVaultId-1897432373")
   *           .setBackupVault(BackupVault.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   BackupVault response = backupDRClient.createBackupVaultAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BackupVault, OperationMetadata> createBackupVaultAsync(
      CreateBackupVaultRequest request) {
    return createBackupVaultOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new BackupVault in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   CreateBackupVaultRequest request =
   *       CreateBackupVaultRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setBackupVaultId("backupVaultId-1897432373")
   *           .setBackupVault(BackupVault.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<BackupVault, OperationMetadata> future =
   *       backupDRClient.createBackupVaultOperationCallable().futureCall(request);
   *   // Do something.
   *   BackupVault response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateBackupVaultRequest, BackupVault, OperationMetadata>
      createBackupVaultOperationCallable() {
    return stub.createBackupVaultOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new BackupVault in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   CreateBackupVaultRequest request =
   *       CreateBackupVaultRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setBackupVaultId("backupVaultId-1897432373")
   *           .setBackupVault(BackupVault.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future = backupDRClient.createBackupVaultCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateBackupVaultRequest, Operation> createBackupVaultCallable() {
    return stub.createBackupVaultCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists BackupVaults in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (BackupVault element : backupDRClient.listBackupVaults(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location for which to retrieve backupvault stores
   *     information, in the format 'projects/{project_id}/locations/{location}'. In Cloud Backup
   *     and DR, locations map to Google Cloud regions, for example
   *     <ul>
   *       <li>&#42;us-central1&#42;&#42;. To retrieve backupvault stores for all locations, use "-"
   *           for the '{location}' value.
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupVaultsPagedResponse listBackupVaults(LocationName parent) {
    ListBackupVaultsRequest request =
        ListBackupVaultsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listBackupVaults(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists BackupVaults in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (BackupVault element : backupDRClient.listBackupVaults(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location for which to retrieve backupvault stores
   *     information, in the format 'projects/{project_id}/locations/{location}'. In Cloud Backup
   *     and DR, locations map to Google Cloud regions, for example
   *     <ul>
   *       <li>&#42;us-central1&#42;&#42;. To retrieve backupvault stores for all locations, use "-"
   *           for the '{location}' value.
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupVaultsPagedResponse listBackupVaults(String parent) {
    ListBackupVaultsRequest request =
        ListBackupVaultsRequest.newBuilder().setParent(parent).build();
    return listBackupVaults(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists BackupVaults in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   ListBackupVaultsRequest request =
   *       ListBackupVaultsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setView(BackupVaultView.forNumber(0))
   *           .build();
   *   for (BackupVault element : backupDRClient.listBackupVaults(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupVaultsPagedResponse listBackupVaults(ListBackupVaultsRequest request) {
    return listBackupVaultsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists BackupVaults in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   ListBackupVaultsRequest request =
   *       ListBackupVaultsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setView(BackupVaultView.forNumber(0))
   *           .build();
   *   ApiFuture<BackupVault> future =
   *       backupDRClient.listBackupVaultsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (BackupVault element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListBackupVaultsRequest, ListBackupVaultsPagedResponse>
      listBackupVaultsPagedCallable() {
    return stub.listBackupVaultsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists BackupVaults in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   ListBackupVaultsRequest request =
   *       ListBackupVaultsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setView(BackupVaultView.forNumber(0))
   *           .build();
   *   while (true) {
   *     ListBackupVaultsResponse response = backupDRClient.listBackupVaultsCallable().call(request);
   *     for (BackupVault element : response.getBackupVaultsList()) {
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
  public final UnaryCallable<ListBackupVaultsRequest, ListBackupVaultsResponse>
      listBackupVaultsCallable() {
    return stub.listBackupVaultsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * FetchUsableBackupVaults lists usable BackupVaults in a given project and location. Usable
   * BackupVault are the ones that user has backupdr.backupVaults.get permission.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (BackupVault element : backupDRClient.fetchUsableBackupVaults(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location for which to retrieve backupvault stores
   *     information, in the format 'projects/{project_id}/locations/{location}'. In Cloud Backup
   *     and DR, locations map to Google Cloud regions, for example
   *     <ul>
   *       <li>&#42;us-central1&#42;&#42;. To retrieve backupvault stores for all locations, use "-"
   *           for the '{location}' value.
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchUsableBackupVaultsPagedResponse fetchUsableBackupVaults(LocationName parent) {
    FetchUsableBackupVaultsRequest request =
        FetchUsableBackupVaultsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return fetchUsableBackupVaults(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * FetchUsableBackupVaults lists usable BackupVaults in a given project and location. Usable
   * BackupVault are the ones that user has backupdr.backupVaults.get permission.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (BackupVault element : backupDRClient.fetchUsableBackupVaults(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location for which to retrieve backupvault stores
   *     information, in the format 'projects/{project_id}/locations/{location}'. In Cloud Backup
   *     and DR, locations map to Google Cloud regions, for example
   *     <ul>
   *       <li>&#42;us-central1&#42;&#42;. To retrieve backupvault stores for all locations, use "-"
   *           for the '{location}' value.
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchUsableBackupVaultsPagedResponse fetchUsableBackupVaults(String parent) {
    FetchUsableBackupVaultsRequest request =
        FetchUsableBackupVaultsRequest.newBuilder().setParent(parent).build();
    return fetchUsableBackupVaults(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * FetchUsableBackupVaults lists usable BackupVaults in a given project and location. Usable
   * BackupVault are the ones that user has backupdr.backupVaults.get permission.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   FetchUsableBackupVaultsRequest request =
   *       FetchUsableBackupVaultsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (BackupVault element : backupDRClient.fetchUsableBackupVaults(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchUsableBackupVaultsPagedResponse fetchUsableBackupVaults(
      FetchUsableBackupVaultsRequest request) {
    return fetchUsableBackupVaultsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * FetchUsableBackupVaults lists usable BackupVaults in a given project and location. Usable
   * BackupVault are the ones that user has backupdr.backupVaults.get permission.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   FetchUsableBackupVaultsRequest request =
   *       FetchUsableBackupVaultsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<BackupVault> future =
   *       backupDRClient.fetchUsableBackupVaultsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (BackupVault element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<FetchUsableBackupVaultsRequest, FetchUsableBackupVaultsPagedResponse>
      fetchUsableBackupVaultsPagedCallable() {
    return stub.fetchUsableBackupVaultsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * FetchUsableBackupVaults lists usable BackupVaults in a given project and location. Usable
   * BackupVault are the ones that user has backupdr.backupVaults.get permission.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   FetchUsableBackupVaultsRequest request =
   *       FetchUsableBackupVaultsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     FetchUsableBackupVaultsResponse response =
   *         backupDRClient.fetchUsableBackupVaultsCallable().call(request);
   *     for (BackupVault element : response.getBackupVaultsList()) {
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
  public final UnaryCallable<FetchUsableBackupVaultsRequest, FetchUsableBackupVaultsResponse>
      fetchUsableBackupVaultsCallable() {
    return stub.fetchUsableBackupVaultsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a BackupVault.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   BackupVaultName name = BackupVaultName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]");
   *   BackupVault response = backupDRClient.getBackupVault(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the backupvault store resource name, in the format
   *     'projects/{project_id}/locations/{location}/backupVaults/{resource_name}'
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BackupVault getBackupVault(BackupVaultName name) {
    GetBackupVaultRequest request =
        GetBackupVaultRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getBackupVault(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a BackupVault.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   String name = BackupVaultName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]").toString();
   *   BackupVault response = backupDRClient.getBackupVault(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the backupvault store resource name, in the format
   *     'projects/{project_id}/locations/{location}/backupVaults/{resource_name}'
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BackupVault getBackupVault(String name) {
    GetBackupVaultRequest request = GetBackupVaultRequest.newBuilder().setName(name).build();
    return getBackupVault(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a BackupVault.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   GetBackupVaultRequest request =
   *       GetBackupVaultRequest.newBuilder()
   *           .setName(BackupVaultName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]").toString())
   *           .setView(BackupVaultView.forNumber(0))
   *           .build();
   *   BackupVault response = backupDRClient.getBackupVault(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BackupVault getBackupVault(GetBackupVaultRequest request) {
    return getBackupVaultCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a BackupVault.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   GetBackupVaultRequest request =
   *       GetBackupVaultRequest.newBuilder()
   *           .setName(BackupVaultName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]").toString())
   *           .setView(BackupVaultView.forNumber(0))
   *           .build();
   *   ApiFuture<BackupVault> future = backupDRClient.getBackupVaultCallable().futureCall(request);
   *   // Do something.
   *   BackupVault response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetBackupVaultRequest, BackupVault> getBackupVaultCallable() {
    return stub.getBackupVaultCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the settings of a BackupVault.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   BackupVault backupVault = BackupVault.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   BackupVault response = backupDRClient.updateBackupVaultAsync(backupVault, updateMask).get();
   * }
   * }</pre>
   *
   * @param backupVault Required. The resource being updated
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     BackupVault resource by the update. The fields specified in the update_mask are relative to
   *     the resource, not the full request. A field will be overwritten if it is in the mask. If
   *     the user does not provide a mask then the request will fail.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BackupVault, OperationMetadata> updateBackupVaultAsync(
      BackupVault backupVault, FieldMask updateMask) {
    UpdateBackupVaultRequest request =
        UpdateBackupVaultRequest.newBuilder()
            .setBackupVault(backupVault)
            .setUpdateMask(updateMask)
            .build();
    return updateBackupVaultAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the settings of a BackupVault.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   UpdateBackupVaultRequest request =
   *       UpdateBackupVaultRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setBackupVault(BackupVault.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .setForce(true)
   *           .setForceUpdateAccessRestriction(true)
   *           .build();
   *   BackupVault response = backupDRClient.updateBackupVaultAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BackupVault, OperationMetadata> updateBackupVaultAsync(
      UpdateBackupVaultRequest request) {
    return updateBackupVaultOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the settings of a BackupVault.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   UpdateBackupVaultRequest request =
   *       UpdateBackupVaultRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setBackupVault(BackupVault.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .setForce(true)
   *           .setForceUpdateAccessRestriction(true)
   *           .build();
   *   OperationFuture<BackupVault, OperationMetadata> future =
   *       backupDRClient.updateBackupVaultOperationCallable().futureCall(request);
   *   // Do something.
   *   BackupVault response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateBackupVaultRequest, BackupVault, OperationMetadata>
      updateBackupVaultOperationCallable() {
    return stub.updateBackupVaultOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the settings of a BackupVault.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   UpdateBackupVaultRequest request =
   *       UpdateBackupVaultRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setBackupVault(BackupVault.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setValidateOnly(true)
   *           .setForce(true)
   *           .setForceUpdateAccessRestriction(true)
   *           .build();
   *   ApiFuture<Operation> future = backupDRClient.updateBackupVaultCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateBackupVaultRequest, Operation> updateBackupVaultCallable() {
    return stub.updateBackupVaultCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a BackupVault.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   BackupVaultName name = BackupVaultName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]");
   *   backupDRClient.deleteBackupVaultAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteBackupVaultAsync(
      BackupVaultName name) {
    DeleteBackupVaultRequest request =
        DeleteBackupVaultRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteBackupVaultAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a BackupVault.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   String name = BackupVaultName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]").toString();
   *   backupDRClient.deleteBackupVaultAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteBackupVaultAsync(String name) {
    DeleteBackupVaultRequest request = DeleteBackupVaultRequest.newBuilder().setName(name).build();
    return deleteBackupVaultAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a BackupVault.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   DeleteBackupVaultRequest request =
   *       DeleteBackupVaultRequest.newBuilder()
   *           .setName(BackupVaultName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .setEtag("etag3123477")
   *           .setValidateOnly(true)
   *           .setAllowMissing(true)
   *           .setIgnoreBackupPlanReferences(true)
   *           .build();
   *   backupDRClient.deleteBackupVaultAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteBackupVaultAsync(
      DeleteBackupVaultRequest request) {
    return deleteBackupVaultOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a BackupVault.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   DeleteBackupVaultRequest request =
   *       DeleteBackupVaultRequest.newBuilder()
   *           .setName(BackupVaultName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .setEtag("etag3123477")
   *           .setValidateOnly(true)
   *           .setAllowMissing(true)
   *           .setIgnoreBackupPlanReferences(true)
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       backupDRClient.deleteBackupVaultOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteBackupVaultRequest, Empty, OperationMetadata>
      deleteBackupVaultOperationCallable() {
    return stub.deleteBackupVaultOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a BackupVault.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   DeleteBackupVaultRequest request =
   *       DeleteBackupVaultRequest.newBuilder()
   *           .setName(BackupVaultName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .setEtag("etag3123477")
   *           .setValidateOnly(true)
   *           .setAllowMissing(true)
   *           .setIgnoreBackupPlanReferences(true)
   *           .build();
   *   ApiFuture<Operation> future = backupDRClient.deleteBackupVaultCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteBackupVaultRequest, Operation> deleteBackupVaultCallable() {
    return stub.deleteBackupVaultCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DataSources in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   BackupVaultName parent = BackupVaultName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]");
   *   for (DataSource element : backupDRClient.listDataSources(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location for which to retrieve data sources
   *     information, in the format 'projects/{project_id}/locations/{location}'. In Cloud Backup
   *     and DR, locations map to Google Cloud regions, for example &#42;&#42;us-central1&#42;&#42;.
   *     To retrieve data sources for all locations, use "-" for the '{location}' value.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataSourcesPagedResponse listDataSources(BackupVaultName parent) {
    ListDataSourcesRequest request =
        ListDataSourcesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDataSources(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DataSources in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   String parent = BackupVaultName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]").toString();
   *   for (DataSource element : backupDRClient.listDataSources(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location for which to retrieve data sources
   *     information, in the format 'projects/{project_id}/locations/{location}'. In Cloud Backup
   *     and DR, locations map to Google Cloud regions, for example &#42;&#42;us-central1&#42;&#42;.
   *     To retrieve data sources for all locations, use "-" for the '{location}' value.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataSourcesPagedResponse listDataSources(String parent) {
    ListDataSourcesRequest request = ListDataSourcesRequest.newBuilder().setParent(parent).build();
    return listDataSources(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DataSources in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   ListDataSourcesRequest request =
   *       ListDataSourcesRequest.newBuilder()
   *           .setParent(BackupVaultName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (DataSource element : backupDRClient.listDataSources(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataSourcesPagedResponse listDataSources(ListDataSourcesRequest request) {
    return listDataSourcesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DataSources in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   ListDataSourcesRequest request =
   *       ListDataSourcesRequest.newBuilder()
   *           .setParent(BackupVaultName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<DataSource> future =
   *       backupDRClient.listDataSourcesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (DataSource element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDataSourcesRequest, ListDataSourcesPagedResponse>
      listDataSourcesPagedCallable() {
    return stub.listDataSourcesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists DataSources in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   ListDataSourcesRequest request =
   *       ListDataSourcesRequest.newBuilder()
   *           .setParent(BackupVaultName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListDataSourcesResponse response = backupDRClient.listDataSourcesCallable().call(request);
   *     for (DataSource element : response.getDataSourcesList()) {
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
  public final UnaryCallable<ListDataSourcesRequest, ListDataSourcesResponse>
      listDataSourcesCallable() {
    return stub.listDataSourcesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a DataSource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   DataSourceName name =
   *       DataSourceName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]", "[DATASOURCE]");
   *   DataSource response = backupDRClient.getDataSource(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the data source resource name, in the format
   *     'projects/{project_id}/locations/{location}/backupVaults/{resource_name}/dataSource/{resource_name}'
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataSource getDataSource(DataSourceName name) {
    GetDataSourceRequest request =
        GetDataSourceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getDataSource(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a DataSource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   String name =
   *       DataSourceName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]", "[DATASOURCE]").toString();
   *   DataSource response = backupDRClient.getDataSource(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the data source resource name, in the format
   *     'projects/{project_id}/locations/{location}/backupVaults/{resource_name}/dataSource/{resource_name}'
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataSource getDataSource(String name) {
    GetDataSourceRequest request = GetDataSourceRequest.newBuilder().setName(name).build();
    return getDataSource(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a DataSource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   GetDataSourceRequest request =
   *       GetDataSourceRequest.newBuilder()
   *           .setName(
   *               DataSourceName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]", "[DATASOURCE]")
   *                   .toString())
   *           .build();
   *   DataSource response = backupDRClient.getDataSource(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataSource getDataSource(GetDataSourceRequest request) {
    return getDataSourceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a DataSource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   GetDataSourceRequest request =
   *       GetDataSourceRequest.newBuilder()
   *           .setName(
   *               DataSourceName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]", "[DATASOURCE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<DataSource> future = backupDRClient.getDataSourceCallable().futureCall(request);
   *   // Do something.
   *   DataSource response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDataSourceRequest, DataSource> getDataSourceCallable() {
    return stub.getDataSourceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the settings of a DataSource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   DataSource dataSource = DataSource.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   DataSource response = backupDRClient.updateDataSourceAsync(dataSource, updateMask).get();
   * }
   * }</pre>
   *
   * @param dataSource Required. The resource being updated
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     DataSource resource by the update. The fields specified in the update_mask are relative to
   *     the resource, not the full request. A field will be overwritten if it is in the mask. If
   *     the user does not provide a mask then the request will fail.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DataSource, OperationMetadata> updateDataSourceAsync(
      DataSource dataSource, FieldMask updateMask) {
    UpdateDataSourceRequest request =
        UpdateDataSourceRequest.newBuilder()
            .setDataSource(dataSource)
            .setUpdateMask(updateMask)
            .build();
    return updateDataSourceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the settings of a DataSource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   UpdateDataSourceRequest request =
   *       UpdateDataSourceRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setDataSource(DataSource.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setAllowMissing(true)
   *           .build();
   *   DataSource response = backupDRClient.updateDataSourceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<DataSource, OperationMetadata> updateDataSourceAsync(
      UpdateDataSourceRequest request) {
    return updateDataSourceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the settings of a DataSource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   UpdateDataSourceRequest request =
   *       UpdateDataSourceRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setDataSource(DataSource.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setAllowMissing(true)
   *           .build();
   *   OperationFuture<DataSource, OperationMetadata> future =
   *       backupDRClient.updateDataSourceOperationCallable().futureCall(request);
   *   // Do something.
   *   DataSource response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateDataSourceRequest, DataSource, OperationMetadata>
      updateDataSourceOperationCallable() {
    return stub.updateDataSourceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the settings of a DataSource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   UpdateDataSourceRequest request =
   *       UpdateDataSourceRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setDataSource(DataSource.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .setAllowMissing(true)
   *           .build();
   *   ApiFuture<Operation> future = backupDRClient.updateDataSourceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateDataSourceRequest, Operation> updateDataSourceCallable() {
    return stub.updateDataSourceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Backups in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   DataSourceName parent =
   *       DataSourceName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]", "[DATASOURCE]");
   *   for (Backup element : backupDRClient.listBackups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location for which to retrieve backup information, in
   *     the format 'projects/{project_id}/locations/{location}'. In Cloud Backup and DR, locations
   *     map to Google Cloud regions, for example &#42;&#42;us-central1&#42;&#42;. To retrieve data
   *     sources for all locations, use "-" for the '{location}' value.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupsPagedResponse listBackups(DataSourceName parent) {
    ListBackupsRequest request =
        ListBackupsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listBackups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Backups in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   String parent =
   *       DataSourceName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]", "[DATASOURCE]").toString();
   *   for (Backup element : backupDRClient.listBackups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location for which to retrieve backup information, in
   *     the format 'projects/{project_id}/locations/{location}'. In Cloud Backup and DR, locations
   *     map to Google Cloud regions, for example &#42;&#42;us-central1&#42;&#42;. To retrieve data
   *     sources for all locations, use "-" for the '{location}' value.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupsPagedResponse listBackups(String parent) {
    ListBackupsRequest request = ListBackupsRequest.newBuilder().setParent(parent).build();
    return listBackups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Backups in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   ListBackupsRequest request =
   *       ListBackupsRequest.newBuilder()
   *           .setParent(
   *               DataSourceName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]", "[DATASOURCE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setView(BackupView.forNumber(0))
   *           .build();
   *   for (Backup element : backupDRClient.listBackups(request).iterateAll()) {
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
   * Lists Backups in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   ListBackupsRequest request =
   *       ListBackupsRequest.newBuilder()
   *           .setParent(
   *               DataSourceName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]", "[DATASOURCE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setView(BackupView.forNumber(0))
   *           .build();
   *   ApiFuture<Backup> future = backupDRClient.listBackupsPagedCallable().futureCall(request);
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
   * Lists Backups in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   ListBackupsRequest request =
   *       ListBackupsRequest.newBuilder()
   *           .setParent(
   *               DataSourceName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]", "[DATASOURCE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setView(BackupView.forNumber(0))
   *           .build();
   *   while (true) {
   *     ListBackupsResponse response = backupDRClient.listBackupsCallable().call(request);
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
   * Gets details of a Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   BackupName name =
   *       BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]", "[DATASOURCE]", "[BACKUP]");
   *   Backup response = backupDRClient.getBackup(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the data source resource name, in the format
   *     'projects/{project_id}/locations/{location}/backupVaults/{backupVault}/dataSources/{datasource}/backups/{backup}'
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Backup getBackup(BackupName name) {
    GetBackupRequest request =
        GetBackupRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getBackup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   String name =
   *       BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]", "[DATASOURCE]", "[BACKUP]")
   *           .toString();
   *   Backup response = backupDRClient.getBackup(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the data source resource name, in the format
   *     'projects/{project_id}/locations/{location}/backupVaults/{backupVault}/dataSources/{datasource}/backups/{backup}'
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Backup getBackup(String name) {
    GetBackupRequest request = GetBackupRequest.newBuilder().setName(name).build();
    return getBackup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   GetBackupRequest request =
   *       GetBackupRequest.newBuilder()
   *           .setName(
   *               BackupName.of(
   *                       "[PROJECT]", "[LOCATION]", "[BACKUPVAULT]", "[DATASOURCE]", "[BACKUP]")
   *                   .toString())
   *           .setView(BackupView.forNumber(0))
   *           .build();
   *   Backup response = backupDRClient.getBackup(request);
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
   * Gets details of a Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   GetBackupRequest request =
   *       GetBackupRequest.newBuilder()
   *           .setName(
   *               BackupName.of(
   *                       "[PROJECT]", "[LOCATION]", "[BACKUPVAULT]", "[DATASOURCE]", "[BACKUP]")
   *                   .toString())
   *           .setView(BackupView.forNumber(0))
   *           .build();
   *   ApiFuture<Backup> future = backupDRClient.getBackupCallable().futureCall(request);
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
   * Updates the settings of a Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   Backup backup = Backup.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Backup response = backupDRClient.updateBackupAsync(backup, updateMask).get();
   * }
   * }</pre>
   *
   * @param backup Required. The resource being updated
   * @param updateMask Required. Field mask is used to specify the fields to be overwritten in the
   *     Backup resource by the update. The fields specified in the update_mask are relative to the
   *     resource, not the full request. A field will be overwritten if it is in the mask. If the
   *     user does not provide a mask then the request will fail.
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
   * Updates the settings of a Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   UpdateBackupRequest request =
   *       UpdateBackupRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setBackup(Backup.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Backup response = backupDRClient.updateBackupAsync(request).get();
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
   * Updates the settings of a Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   UpdateBackupRequest request =
   *       UpdateBackupRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setBackup(Backup.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Backup, OperationMetadata> future =
   *       backupDRClient.updateBackupOperationCallable().futureCall(request);
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
   * Updates the settings of a Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   UpdateBackupRequest request =
   *       UpdateBackupRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setBackup(Backup.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = backupDRClient.updateBackupCallable().futureCall(request);
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
   * Deletes a Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   BackupName name =
   *       BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]", "[DATASOURCE]", "[BACKUP]");
   *   Backup response = backupDRClient.deleteBackupAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Backup, OperationMetadata> deleteBackupAsync(BackupName name) {
    DeleteBackupRequest request =
        DeleteBackupRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteBackupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   String name =
   *       BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]", "[DATASOURCE]", "[BACKUP]")
   *           .toString();
   *   Backup response = backupDRClient.deleteBackupAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Backup, OperationMetadata> deleteBackupAsync(String name) {
    DeleteBackupRequest request = DeleteBackupRequest.newBuilder().setName(name).build();
    return deleteBackupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   DeleteBackupRequest request =
   *       DeleteBackupRequest.newBuilder()
   *           .setName(
   *               BackupName.of(
   *                       "[PROJECT]", "[LOCATION]", "[BACKUPVAULT]", "[DATASOURCE]", "[BACKUP]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Backup response = backupDRClient.deleteBackupAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Backup, OperationMetadata> deleteBackupAsync(
      DeleteBackupRequest request) {
    return deleteBackupOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   DeleteBackupRequest request =
   *       DeleteBackupRequest.newBuilder()
   *           .setName(
   *               BackupName.of(
   *                       "[PROJECT]", "[LOCATION]", "[BACKUPVAULT]", "[DATASOURCE]", "[BACKUP]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Backup, OperationMetadata> future =
   *       backupDRClient.deleteBackupOperationCallable().futureCall(request);
   *   // Do something.
   *   Backup response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteBackupRequest, Backup, OperationMetadata>
      deleteBackupOperationCallable() {
    return stub.deleteBackupOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   DeleteBackupRequest request =
   *       DeleteBackupRequest.newBuilder()
   *           .setName(
   *               BackupName.of(
   *                       "[PROJECT]", "[LOCATION]", "[BACKUPVAULT]", "[DATASOURCE]", "[BACKUP]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = backupDRClient.deleteBackupCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteBackupRequest, Operation> deleteBackupCallable() {
    return stub.deleteBackupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restore from a Backup
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   BackupName name =
   *       BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]", "[DATASOURCE]", "[BACKUP]");
   *   RestoreBackupResponse response = backupDRClient.restoreBackupAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Backup instance, in the format
   *     'projects/&#42;/locations/&#42;/backupVaults/&#42;/dataSources/&#42;/backups/'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RestoreBackupResponse, OperationMetadata> restoreBackupAsync(
      BackupName name) {
    RestoreBackupRequest request =
        RestoreBackupRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return restoreBackupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restore from a Backup
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   String name =
   *       BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUPVAULT]", "[DATASOURCE]", "[BACKUP]")
   *           .toString();
   *   RestoreBackupResponse response = backupDRClient.restoreBackupAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Backup instance, in the format
   *     'projects/&#42;/locations/&#42;/backupVaults/&#42;/dataSources/&#42;/backups/'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RestoreBackupResponse, OperationMetadata> restoreBackupAsync(
      String name) {
    RestoreBackupRequest request = RestoreBackupRequest.newBuilder().setName(name).build();
    return restoreBackupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restore from a Backup
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   RestoreBackupRequest request =
   *       RestoreBackupRequest.newBuilder()
   *           .setName(
   *               BackupName.of(
   *                       "[PROJECT]", "[LOCATION]", "[BACKUPVAULT]", "[DATASOURCE]", "[BACKUP]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   RestoreBackupResponse response = backupDRClient.restoreBackupAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RestoreBackupResponse, OperationMetadata> restoreBackupAsync(
      RestoreBackupRequest request) {
    return restoreBackupOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restore from a Backup
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   RestoreBackupRequest request =
   *       RestoreBackupRequest.newBuilder()
   *           .setName(
   *               BackupName.of(
   *                       "[PROJECT]", "[LOCATION]", "[BACKUPVAULT]", "[DATASOURCE]", "[BACKUP]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<RestoreBackupResponse, OperationMetadata> future =
   *       backupDRClient.restoreBackupOperationCallable().futureCall(request);
   *   // Do something.
   *   RestoreBackupResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<RestoreBackupRequest, RestoreBackupResponse, OperationMetadata>
      restoreBackupOperationCallable() {
    return stub.restoreBackupOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restore from a Backup
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   RestoreBackupRequest request =
   *       RestoreBackupRequest.newBuilder()
   *           .setName(
   *               BackupName.of(
   *                       "[PROJECT]", "[LOCATION]", "[BACKUPVAULT]", "[DATASOURCE]", "[BACKUP]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = backupDRClient.restoreBackupCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RestoreBackupRequest, Operation> restoreBackupCallable() {
    return stub.restoreBackupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a BackupPlan
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   BackupPlan backupPlan = BackupPlan.newBuilder().build();
   *   String backupPlanId = "backupPlanId-84871546";
   *   BackupPlan response =
   *       backupDRClient.createBackupPlanAsync(parent, backupPlan, backupPlanId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The `BackupPlan` project and location in the format
   *     `projects/{project}/locations/{location}`. In Cloud BackupDR locations map to GCP regions,
   *     for example &#42;&#42;us-central1&#42;&#42;.
   * @param backupPlan Required. The `BackupPlan` resource object to create.
   * @param backupPlanId Required. The name of the `BackupPlan` to create. The name must be unique
   *     for the specified project and location.The name must start with a lowercase letter followed
   *     by up to 62 lowercase letters, numbers, or hyphens. Pattern, /[a-z][a-z0-9-]{,62}/.
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
   * Create a BackupPlan
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   BackupPlan backupPlan = BackupPlan.newBuilder().build();
   *   String backupPlanId = "backupPlanId-84871546";
   *   BackupPlan response =
   *       backupDRClient.createBackupPlanAsync(parent, backupPlan, backupPlanId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The `BackupPlan` project and location in the format
   *     `projects/{project}/locations/{location}`. In Cloud BackupDR locations map to GCP regions,
   *     for example &#42;&#42;us-central1&#42;&#42;.
   * @param backupPlan Required. The `BackupPlan` resource object to create.
   * @param backupPlanId Required. The name of the `BackupPlan` to create. The name must be unique
   *     for the specified project and location.The name must start with a lowercase letter followed
   *     by up to 62 lowercase letters, numbers, or hyphens. Pattern, /[a-z][a-z0-9-]{,62}/.
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
   * Create a BackupPlan
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   CreateBackupPlanRequest request =
   *       CreateBackupPlanRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setBackupPlanId("backupPlanId-84871546")
   *           .setBackupPlan(BackupPlan.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   BackupPlan response = backupDRClient.createBackupPlanAsync(request).get();
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
   * Create a BackupPlan
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   CreateBackupPlanRequest request =
   *       CreateBackupPlanRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setBackupPlanId("backupPlanId-84871546")
   *           .setBackupPlan(BackupPlan.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<BackupPlan, OperationMetadata> future =
   *       backupDRClient.createBackupPlanOperationCallable().futureCall(request);
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
   * Create a BackupPlan
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   CreateBackupPlanRequest request =
   *       CreateBackupPlanRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setBackupPlanId("backupPlanId-84871546")
   *           .setBackupPlan(BackupPlan.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = backupDRClient.createBackupPlanCallable().futureCall(request);
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
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   BackupPlan backupPlan = BackupPlan.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   BackupPlan response = backupDRClient.updateBackupPlanAsync(backupPlan, updateMask).get();
   * }
   * }</pre>
   *
   * @param backupPlan Required. The resource being updated
   * @param updateMask Required. The list of fields to update. Field mask is used to specify the
   *     fields to be overwritten in the BackupPlan resource by the update. The fields specified in
   *     the update_mask are relative to the resource, not the full request. A field will be
   *     overwritten if it is in the mask. If the user does not provide a mask then the request will
   *     fail. Currently, these fields are supported in update: description, schedules, retention
   *     period, adding and removing Backup Rules.
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
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   UpdateBackupPlanRequest request =
   *       UpdateBackupPlanRequest.newBuilder()
   *           .setBackupPlan(BackupPlan.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   BackupPlan response = backupDRClient.updateBackupPlanAsync(request).get();
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
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   UpdateBackupPlanRequest request =
   *       UpdateBackupPlanRequest.newBuilder()
   *           .setBackupPlan(BackupPlan.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<BackupPlan, OperationMetadata> future =
   *       backupDRClient.updateBackupPlanOperationCallable().futureCall(request);
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
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   UpdateBackupPlanRequest request =
   *       UpdateBackupPlanRequest.newBuilder()
   *           .setBackupPlan(BackupPlan.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = backupDRClient.updateBackupPlanCallable().futureCall(request);
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
   * Gets details of a single BackupPlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   BackupPlanName name = BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]");
   *   BackupPlan response = backupDRClient.getBackupPlan(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the `BackupPlan` to retrieve.
   *     <p>Format: `projects/{project}/locations/{location}/backupPlans/{backup_plan}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BackupPlan getBackupPlan(BackupPlanName name) {
    GetBackupPlanRequest request =
        GetBackupPlanRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getBackupPlan(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single BackupPlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   String name = BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString();
   *   BackupPlan response = backupDRClient.getBackupPlan(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the `BackupPlan` to retrieve.
   *     <p>Format: `projects/{project}/locations/{location}/backupPlans/{backup_plan}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BackupPlan getBackupPlan(String name) {
    GetBackupPlanRequest request = GetBackupPlanRequest.newBuilder().setName(name).build();
    return getBackupPlan(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single BackupPlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   GetBackupPlanRequest request =
   *       GetBackupPlanRequest.newBuilder()
   *           .setName(BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString())
   *           .build();
   *   BackupPlan response = backupDRClient.getBackupPlan(request);
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
   * Gets details of a single BackupPlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   GetBackupPlanRequest request =
   *       GetBackupPlanRequest.newBuilder()
   *           .setName(BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString())
   *           .build();
   *   ApiFuture<BackupPlan> future = backupDRClient.getBackupPlanCallable().futureCall(request);
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
   * Lists BackupPlans in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (BackupPlan element : backupDRClient.listBackupPlans(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location for which to retrieve `BackupPlans`
   *     information. Format: `projects/{project}/locations/{location}`. In Cloud BackupDR,
   *     locations map to GCP regions, for e.g. &#42;&#42;us-central1&#42;&#42;. To retrieve backup
   *     plans for all locations, use "-" for the `{location}` value.
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
   * Lists BackupPlans in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (BackupPlan element : backupDRClient.listBackupPlans(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location for which to retrieve `BackupPlans`
   *     information. Format: `projects/{project}/locations/{location}`. In Cloud BackupDR,
   *     locations map to GCP regions, for e.g. &#42;&#42;us-central1&#42;&#42;. To retrieve backup
   *     plans for all locations, use "-" for the `{location}` value.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupPlansPagedResponse listBackupPlans(String parent) {
    ListBackupPlansRequest request = ListBackupPlansRequest.newBuilder().setParent(parent).build();
    return listBackupPlans(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists BackupPlans in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   ListBackupPlansRequest request =
   *       ListBackupPlansRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (BackupPlan element : backupDRClient.listBackupPlans(request).iterateAll()) {
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
   * Lists BackupPlans in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   ListBackupPlansRequest request =
   *       ListBackupPlansRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<BackupPlan> future =
   *       backupDRClient.listBackupPlansPagedCallable().futureCall(request);
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
   * Lists BackupPlans in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   ListBackupPlansRequest request =
   *       ListBackupPlansRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListBackupPlansResponse response = backupDRClient.listBackupPlansCallable().call(request);
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
   * Deletes a single BackupPlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   BackupPlanName name = BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]");
   *   backupDRClient.deleteBackupPlanAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the `BackupPlan` to delete.
   *     <p>Format: `projects/{project}/locations/{location}/backupPlans/{backup_plan}`
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
   * Deletes a single BackupPlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   String name = BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString();
   *   backupDRClient.deleteBackupPlanAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the `BackupPlan` to delete.
   *     <p>Format: `projects/{project}/locations/{location}/backupPlans/{backup_plan}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteBackupPlanAsync(String name) {
    DeleteBackupPlanRequest request = DeleteBackupPlanRequest.newBuilder().setName(name).build();
    return deleteBackupPlanAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single BackupPlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   DeleteBackupPlanRequest request =
   *       DeleteBackupPlanRequest.newBuilder()
   *           .setName(BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   backupDRClient.deleteBackupPlanAsync(request).get();
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
   * Deletes a single BackupPlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   DeleteBackupPlanRequest request =
   *       DeleteBackupPlanRequest.newBuilder()
   *           .setName(BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       backupDRClient.deleteBackupPlanOperationCallable().futureCall(request);
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
   * Deletes a single BackupPlan.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   DeleteBackupPlanRequest request =
   *       DeleteBackupPlanRequest.newBuilder()
   *           .setName(BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = backupDRClient.deleteBackupPlanCallable().futureCall(request);
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
   * Gets details of a single BackupPlanRevision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   BackupPlanRevisionName name =
   *       BackupPlanRevisionName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[REVISION]");
   *   BackupPlanRevision response = backupDRClient.getBackupPlanRevision(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the `BackupPlanRevision` to retrieve.
   *     <p>Format:
   *     `projects/{project}/locations/{location}/backupPlans/{backup_plan}/revisions/{revision}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BackupPlanRevision getBackupPlanRevision(BackupPlanRevisionName name) {
    GetBackupPlanRevisionRequest request =
        GetBackupPlanRevisionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getBackupPlanRevision(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single BackupPlanRevision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   String name =
   *       BackupPlanRevisionName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[REVISION]")
   *           .toString();
   *   BackupPlanRevision response = backupDRClient.getBackupPlanRevision(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the `BackupPlanRevision` to retrieve.
   *     <p>Format:
   *     `projects/{project}/locations/{location}/backupPlans/{backup_plan}/revisions/{revision}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BackupPlanRevision getBackupPlanRevision(String name) {
    GetBackupPlanRevisionRequest request =
        GetBackupPlanRevisionRequest.newBuilder().setName(name).build();
    return getBackupPlanRevision(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single BackupPlanRevision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   GetBackupPlanRevisionRequest request =
   *       GetBackupPlanRevisionRequest.newBuilder()
   *           .setName(
   *               BackupPlanRevisionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[REVISION]")
   *                   .toString())
   *           .build();
   *   BackupPlanRevision response = backupDRClient.getBackupPlanRevision(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BackupPlanRevision getBackupPlanRevision(GetBackupPlanRevisionRequest request) {
    return getBackupPlanRevisionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single BackupPlanRevision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   GetBackupPlanRevisionRequest request =
   *       GetBackupPlanRevisionRequest.newBuilder()
   *           .setName(
   *               BackupPlanRevisionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]", "[REVISION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<BackupPlanRevision> future =
   *       backupDRClient.getBackupPlanRevisionCallable().futureCall(request);
   *   // Do something.
   *   BackupPlanRevision response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetBackupPlanRevisionRequest, BackupPlanRevision>
      getBackupPlanRevisionCallable() {
    return stub.getBackupPlanRevisionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists BackupPlanRevisions in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   BackupPlanName parent = BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]");
   *   for (BackupPlanRevision element :
   *       backupDRClient.listBackupPlanRevisions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location for which to retrieve `BackupPlanRevisions`
   *     information. Format: `projects/{project}/locations/{location}/backupPlans/{backup_plan}`.
   *     In Cloud BackupDR, locations map to GCP regions, for e.g. &#42;&#42;us-central1&#42;&#42;.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupPlanRevisionsPagedResponse listBackupPlanRevisions(BackupPlanName parent) {
    ListBackupPlanRevisionsRequest request =
        ListBackupPlanRevisionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listBackupPlanRevisions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists BackupPlanRevisions in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   String parent = BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString();
   *   for (BackupPlanRevision element :
   *       backupDRClient.listBackupPlanRevisions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location for which to retrieve `BackupPlanRevisions`
   *     information. Format: `projects/{project}/locations/{location}/backupPlans/{backup_plan}`.
   *     In Cloud BackupDR, locations map to GCP regions, for e.g. &#42;&#42;us-central1&#42;&#42;.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupPlanRevisionsPagedResponse listBackupPlanRevisions(String parent) {
    ListBackupPlanRevisionsRequest request =
        ListBackupPlanRevisionsRequest.newBuilder().setParent(parent).build();
    return listBackupPlanRevisions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists BackupPlanRevisions in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   ListBackupPlanRevisionsRequest request =
   *       ListBackupPlanRevisionsRequest.newBuilder()
   *           .setParent(BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (BackupPlanRevision element :
   *       backupDRClient.listBackupPlanRevisions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupPlanRevisionsPagedResponse listBackupPlanRevisions(
      ListBackupPlanRevisionsRequest request) {
    return listBackupPlanRevisionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists BackupPlanRevisions in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   ListBackupPlanRevisionsRequest request =
   *       ListBackupPlanRevisionsRequest.newBuilder()
   *           .setParent(BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<BackupPlanRevision> future =
   *       backupDRClient.listBackupPlanRevisionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (BackupPlanRevision element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListBackupPlanRevisionsRequest, ListBackupPlanRevisionsPagedResponse>
      listBackupPlanRevisionsPagedCallable() {
    return stub.listBackupPlanRevisionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists BackupPlanRevisions in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   ListBackupPlanRevisionsRequest request =
   *       ListBackupPlanRevisionsRequest.newBuilder()
   *           .setParent(BackupPlanName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListBackupPlanRevisionsResponse response =
   *         backupDRClient.listBackupPlanRevisionsCallable().call(request);
   *     for (BackupPlanRevision element : response.getBackupPlanRevisionsList()) {
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
  public final UnaryCallable<ListBackupPlanRevisionsRequest, ListBackupPlanRevisionsResponse>
      listBackupPlanRevisionsCallable() {
    return stub.listBackupPlanRevisionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a BackupPlanAssociation
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   BackupPlanAssociation backupPlanAssociation = BackupPlanAssociation.newBuilder().build();
   *   String backupPlanAssociationId = "backupPlanAssociationId567762737";
   *   BackupPlanAssociation response =
   *       backupDRClient
   *           .createBackupPlanAssociationAsync(
   *               parent, backupPlanAssociation, backupPlanAssociationId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The backup plan association project and location in the format
   *     `projects/{project_id}/locations/{location}`. In Cloud BackupDR locations map to GCP
   *     regions, for example &#42;&#42;us-central1&#42;&#42;.
   * @param backupPlanAssociation Required. The resource being created
   * @param backupPlanAssociationId Required. The name of the backup plan association to create. The
   *     name must be unique for the specified project and location.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BackupPlanAssociation, OperationMetadata>
      createBackupPlanAssociationAsync(
          LocationName parent,
          BackupPlanAssociation backupPlanAssociation,
          String backupPlanAssociationId) {
    CreateBackupPlanAssociationRequest request =
        CreateBackupPlanAssociationRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setBackupPlanAssociation(backupPlanAssociation)
            .setBackupPlanAssociationId(backupPlanAssociationId)
            .build();
    return createBackupPlanAssociationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a BackupPlanAssociation
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   BackupPlanAssociation backupPlanAssociation = BackupPlanAssociation.newBuilder().build();
   *   String backupPlanAssociationId = "backupPlanAssociationId567762737";
   *   BackupPlanAssociation response =
   *       backupDRClient
   *           .createBackupPlanAssociationAsync(
   *               parent, backupPlanAssociation, backupPlanAssociationId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The backup plan association project and location in the format
   *     `projects/{project_id}/locations/{location}`. In Cloud BackupDR locations map to GCP
   *     regions, for example &#42;&#42;us-central1&#42;&#42;.
   * @param backupPlanAssociation Required. The resource being created
   * @param backupPlanAssociationId Required. The name of the backup plan association to create. The
   *     name must be unique for the specified project and location.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BackupPlanAssociation, OperationMetadata>
      createBackupPlanAssociationAsync(
          String parent,
          BackupPlanAssociation backupPlanAssociation,
          String backupPlanAssociationId) {
    CreateBackupPlanAssociationRequest request =
        CreateBackupPlanAssociationRequest.newBuilder()
            .setParent(parent)
            .setBackupPlanAssociation(backupPlanAssociation)
            .setBackupPlanAssociationId(backupPlanAssociationId)
            .build();
    return createBackupPlanAssociationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a BackupPlanAssociation
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   CreateBackupPlanAssociationRequest request =
   *       CreateBackupPlanAssociationRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setBackupPlanAssociationId("backupPlanAssociationId567762737")
   *           .setBackupPlanAssociation(BackupPlanAssociation.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   BackupPlanAssociation response =
   *       backupDRClient.createBackupPlanAssociationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BackupPlanAssociation, OperationMetadata>
      createBackupPlanAssociationAsync(CreateBackupPlanAssociationRequest request) {
    return createBackupPlanAssociationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a BackupPlanAssociation
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   CreateBackupPlanAssociationRequest request =
   *       CreateBackupPlanAssociationRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setBackupPlanAssociationId("backupPlanAssociationId567762737")
   *           .setBackupPlanAssociation(BackupPlanAssociation.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<BackupPlanAssociation, OperationMetadata> future =
   *       backupDRClient.createBackupPlanAssociationOperationCallable().futureCall(request);
   *   // Do something.
   *   BackupPlanAssociation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateBackupPlanAssociationRequest, BackupPlanAssociation, OperationMetadata>
      createBackupPlanAssociationOperationCallable() {
    return stub.createBackupPlanAssociationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a BackupPlanAssociation
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   CreateBackupPlanAssociationRequest request =
   *       CreateBackupPlanAssociationRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setBackupPlanAssociationId("backupPlanAssociationId567762737")
   *           .setBackupPlanAssociation(BackupPlanAssociation.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       backupDRClient.createBackupPlanAssociationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateBackupPlanAssociationRequest, Operation>
      createBackupPlanAssociationCallable() {
    return stub.createBackupPlanAssociationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a BackupPlanAssociation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   BackupPlanAssociation backupPlanAssociation = BackupPlanAssociation.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   BackupPlanAssociation response =
   *       backupDRClient.updateBackupPlanAssociationAsync(backupPlanAssociation, updateMask).get();
   * }
   * }</pre>
   *
   * @param backupPlanAssociation Required. The resource being updated
   * @param updateMask Required. The list of fields to update. Field mask is used to specify the
   *     fields to be overwritten in the BackupPlanAssociation resource by the update. The fields
   *     specified in the update_mask are relative to the resource, not the full request. A field
   *     will be overwritten if it is in the mask. If the user does not provide a mask then the
   *     request will fail. Currently backup_plan_association.backup_plan is the only supported
   *     field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BackupPlanAssociation, OperationMetadata>
      updateBackupPlanAssociationAsync(
          BackupPlanAssociation backupPlanAssociation, FieldMask updateMask) {
    UpdateBackupPlanAssociationRequest request =
        UpdateBackupPlanAssociationRequest.newBuilder()
            .setBackupPlanAssociation(backupPlanAssociation)
            .setUpdateMask(updateMask)
            .build();
    return updateBackupPlanAssociationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a BackupPlanAssociation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   UpdateBackupPlanAssociationRequest request =
   *       UpdateBackupPlanAssociationRequest.newBuilder()
   *           .setBackupPlanAssociation(BackupPlanAssociation.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   BackupPlanAssociation response =
   *       backupDRClient.updateBackupPlanAssociationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BackupPlanAssociation, OperationMetadata>
      updateBackupPlanAssociationAsync(UpdateBackupPlanAssociationRequest request) {
    return updateBackupPlanAssociationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a BackupPlanAssociation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   UpdateBackupPlanAssociationRequest request =
   *       UpdateBackupPlanAssociationRequest.newBuilder()
   *           .setBackupPlanAssociation(BackupPlanAssociation.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<BackupPlanAssociation, OperationMetadata> future =
   *       backupDRClient.updateBackupPlanAssociationOperationCallable().futureCall(request);
   *   // Do something.
   *   BackupPlanAssociation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdateBackupPlanAssociationRequest, BackupPlanAssociation, OperationMetadata>
      updateBackupPlanAssociationOperationCallable() {
    return stub.updateBackupPlanAssociationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a BackupPlanAssociation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   UpdateBackupPlanAssociationRequest request =
   *       UpdateBackupPlanAssociationRequest.newBuilder()
   *           .setBackupPlanAssociation(BackupPlanAssociation.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       backupDRClient.updateBackupPlanAssociationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateBackupPlanAssociationRequest, Operation>
      updateBackupPlanAssociationCallable() {
    return stub.updateBackupPlanAssociationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single BackupPlanAssociation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   BackupPlanAssociationName name =
   *       BackupPlanAssociationName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN_ASSOCIATION]");
   *   BackupPlanAssociation response = backupDRClient.getBackupPlanAssociation(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the backup plan association resource, in the format
   *     `projects/{project}/locations/{location}/backupPlanAssociations/{backupPlanAssociationId}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BackupPlanAssociation getBackupPlanAssociation(BackupPlanAssociationName name) {
    GetBackupPlanAssociationRequest request =
        GetBackupPlanAssociationRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getBackupPlanAssociation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single BackupPlanAssociation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   String name =
   *       BackupPlanAssociationName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN_ASSOCIATION]")
   *           .toString();
   *   BackupPlanAssociation response = backupDRClient.getBackupPlanAssociation(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the backup plan association resource, in the format
   *     `projects/{project}/locations/{location}/backupPlanAssociations/{backupPlanAssociationId}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BackupPlanAssociation getBackupPlanAssociation(String name) {
    GetBackupPlanAssociationRequest request =
        GetBackupPlanAssociationRequest.newBuilder().setName(name).build();
    return getBackupPlanAssociation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single BackupPlanAssociation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   GetBackupPlanAssociationRequest request =
   *       GetBackupPlanAssociationRequest.newBuilder()
   *           .setName(
   *               BackupPlanAssociationName.of(
   *                       "[PROJECT]", "[LOCATION]", "[BACKUP_PLAN_ASSOCIATION]")
   *                   .toString())
   *           .build();
   *   BackupPlanAssociation response = backupDRClient.getBackupPlanAssociation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BackupPlanAssociation getBackupPlanAssociation(
      GetBackupPlanAssociationRequest request) {
    return getBackupPlanAssociationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single BackupPlanAssociation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   GetBackupPlanAssociationRequest request =
   *       GetBackupPlanAssociationRequest.newBuilder()
   *           .setName(
   *               BackupPlanAssociationName.of(
   *                       "[PROJECT]", "[LOCATION]", "[BACKUP_PLAN_ASSOCIATION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<BackupPlanAssociation> future =
   *       backupDRClient.getBackupPlanAssociationCallable().futureCall(request);
   *   // Do something.
   *   BackupPlanAssociation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetBackupPlanAssociationRequest, BackupPlanAssociation>
      getBackupPlanAssociationCallable() {
    return stub.getBackupPlanAssociationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists BackupPlanAssociations in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (BackupPlanAssociation element :
   *       backupDRClient.listBackupPlanAssociations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location for which to retrieve backup Plan Associations
   *     information, in the format `projects/{project_id}/locations/{location}`. In Cloud BackupDR,
   *     locations map to GCP regions, for example &#42;&#42;us-central1&#42;&#42;. To retrieve
   *     backup plan associations for all locations, use "-" for the `{location}` value.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupPlanAssociationsPagedResponse listBackupPlanAssociations(
      LocationName parent) {
    ListBackupPlanAssociationsRequest request =
        ListBackupPlanAssociationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listBackupPlanAssociations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists BackupPlanAssociations in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (BackupPlanAssociation element :
   *       backupDRClient.listBackupPlanAssociations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location for which to retrieve backup Plan Associations
   *     information, in the format `projects/{project_id}/locations/{location}`. In Cloud BackupDR,
   *     locations map to GCP regions, for example &#42;&#42;us-central1&#42;&#42;. To retrieve
   *     backup plan associations for all locations, use "-" for the `{location}` value.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupPlanAssociationsPagedResponse listBackupPlanAssociations(String parent) {
    ListBackupPlanAssociationsRequest request =
        ListBackupPlanAssociationsRequest.newBuilder().setParent(parent).build();
    return listBackupPlanAssociations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists BackupPlanAssociations in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   ListBackupPlanAssociationsRequest request =
   *       ListBackupPlanAssociationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (BackupPlanAssociation element :
   *       backupDRClient.listBackupPlanAssociations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupPlanAssociationsPagedResponse listBackupPlanAssociations(
      ListBackupPlanAssociationsRequest request) {
    return listBackupPlanAssociationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists BackupPlanAssociations in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   ListBackupPlanAssociationsRequest request =
   *       ListBackupPlanAssociationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<BackupPlanAssociation> future =
   *       backupDRClient.listBackupPlanAssociationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (BackupPlanAssociation element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListBackupPlanAssociationsRequest, ListBackupPlanAssociationsPagedResponse>
      listBackupPlanAssociationsPagedCallable() {
    return stub.listBackupPlanAssociationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists BackupPlanAssociations in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   ListBackupPlanAssociationsRequest request =
   *       ListBackupPlanAssociationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListBackupPlanAssociationsResponse response =
   *         backupDRClient.listBackupPlanAssociationsCallable().call(request);
   *     for (BackupPlanAssociation element : response.getBackupPlanAssociationsList()) {
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
  public final UnaryCallable<ListBackupPlanAssociationsRequest, ListBackupPlanAssociationsResponse>
      listBackupPlanAssociationsCallable() {
    return stub.listBackupPlanAssociationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List BackupPlanAssociations for a given resource type.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   String resourceType = "resourceType-384364440";
   *   for (BackupPlanAssociation element :
   *       backupDRClient
   *           .fetchBackupPlanAssociationsForResourceType(parent, resourceType)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name. Format:
   *     projects/{project}/locations/{location}
   * @param resourceType Required. The type of the GCP resource. Ex: sql.googleapis.com/Instance
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchBackupPlanAssociationsForResourceTypePagedResponse
      fetchBackupPlanAssociationsForResourceType(LocationName parent, String resourceType) {
    FetchBackupPlanAssociationsForResourceTypeRequest request =
        FetchBackupPlanAssociationsForResourceTypeRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setResourceType(resourceType)
            .build();
    return fetchBackupPlanAssociationsForResourceType(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List BackupPlanAssociations for a given resource type.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   String resourceType = "resourceType-384364440";
   *   for (BackupPlanAssociation element :
   *       backupDRClient
   *           .fetchBackupPlanAssociationsForResourceType(parent, resourceType)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name. Format:
   *     projects/{project}/locations/{location}
   * @param resourceType Required. The type of the GCP resource. Ex: sql.googleapis.com/Instance
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchBackupPlanAssociationsForResourceTypePagedResponse
      fetchBackupPlanAssociationsForResourceType(String parent, String resourceType) {
    FetchBackupPlanAssociationsForResourceTypeRequest request =
        FetchBackupPlanAssociationsForResourceTypeRequest.newBuilder()
            .setParent(parent)
            .setResourceType(resourceType)
            .build();
    return fetchBackupPlanAssociationsForResourceType(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List BackupPlanAssociations for a given resource type.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   FetchBackupPlanAssociationsForResourceTypeRequest request =
   *       FetchBackupPlanAssociationsForResourceTypeRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setResourceType("resourceType-384364440")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (BackupPlanAssociation element :
   *       backupDRClient.fetchBackupPlanAssociationsForResourceType(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchBackupPlanAssociationsForResourceTypePagedResponse
      fetchBackupPlanAssociationsForResourceType(
          FetchBackupPlanAssociationsForResourceTypeRequest request) {
    return fetchBackupPlanAssociationsForResourceTypePagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List BackupPlanAssociations for a given resource type.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   FetchBackupPlanAssociationsForResourceTypeRequest request =
   *       FetchBackupPlanAssociationsForResourceTypeRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setResourceType("resourceType-384364440")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<BackupPlanAssociation> future =
   *       backupDRClient
   *           .fetchBackupPlanAssociationsForResourceTypePagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (BackupPlanAssociation element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          FetchBackupPlanAssociationsForResourceTypeRequest,
          FetchBackupPlanAssociationsForResourceTypePagedResponse>
      fetchBackupPlanAssociationsForResourceTypePagedCallable() {
    return stub.fetchBackupPlanAssociationsForResourceTypePagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List BackupPlanAssociations for a given resource type.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   FetchBackupPlanAssociationsForResourceTypeRequest request =
   *       FetchBackupPlanAssociationsForResourceTypeRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setResourceType("resourceType-384364440")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     FetchBackupPlanAssociationsForResourceTypeResponse response =
   *         backupDRClient.fetchBackupPlanAssociationsForResourceTypeCallable().call(request);
   *     for (BackupPlanAssociation element : response.getBackupPlanAssociationsList()) {
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
          FetchBackupPlanAssociationsForResourceTypeRequest,
          FetchBackupPlanAssociationsForResourceTypeResponse>
      fetchBackupPlanAssociationsForResourceTypeCallable() {
    return stub.fetchBackupPlanAssociationsForResourceTypeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single BackupPlanAssociation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   BackupPlanAssociationName name =
   *       BackupPlanAssociationName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN_ASSOCIATION]");
   *   backupDRClient.deleteBackupPlanAssociationAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the backup plan association resource, in the format
   *     `projects/{project}/locations/{location}/backupPlanAssociations/{backupPlanAssociationId}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteBackupPlanAssociationAsync(
      BackupPlanAssociationName name) {
    DeleteBackupPlanAssociationRequest request =
        DeleteBackupPlanAssociationRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteBackupPlanAssociationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single BackupPlanAssociation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   String name =
   *       BackupPlanAssociationName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN_ASSOCIATION]")
   *           .toString();
   *   backupDRClient.deleteBackupPlanAssociationAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the backup plan association resource, in the format
   *     `projects/{project}/locations/{location}/backupPlanAssociations/{backupPlanAssociationId}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteBackupPlanAssociationAsync(
      String name) {
    DeleteBackupPlanAssociationRequest request =
        DeleteBackupPlanAssociationRequest.newBuilder().setName(name).build();
    return deleteBackupPlanAssociationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single BackupPlanAssociation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   DeleteBackupPlanAssociationRequest request =
   *       DeleteBackupPlanAssociationRequest.newBuilder()
   *           .setName(
   *               BackupPlanAssociationName.of(
   *                       "[PROJECT]", "[LOCATION]", "[BACKUP_PLAN_ASSOCIATION]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   backupDRClient.deleteBackupPlanAssociationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteBackupPlanAssociationAsync(
      DeleteBackupPlanAssociationRequest request) {
    return deleteBackupPlanAssociationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single BackupPlanAssociation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   DeleteBackupPlanAssociationRequest request =
   *       DeleteBackupPlanAssociationRequest.newBuilder()
   *           .setName(
   *               BackupPlanAssociationName.of(
   *                       "[PROJECT]", "[LOCATION]", "[BACKUP_PLAN_ASSOCIATION]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       backupDRClient.deleteBackupPlanAssociationOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteBackupPlanAssociationRequest, Empty, OperationMetadata>
      deleteBackupPlanAssociationOperationCallable() {
    return stub.deleteBackupPlanAssociationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single BackupPlanAssociation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   DeleteBackupPlanAssociationRequest request =
   *       DeleteBackupPlanAssociationRequest.newBuilder()
   *           .setName(
   *               BackupPlanAssociationName.of(
   *                       "[PROJECT]", "[LOCATION]", "[BACKUP_PLAN_ASSOCIATION]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       backupDRClient.deleteBackupPlanAssociationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteBackupPlanAssociationRequest, Operation>
      deleteBackupPlanAssociationCallable() {
    return stub.deleteBackupPlanAssociationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Triggers a new Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   BackupPlanAssociationName name =
   *       BackupPlanAssociationName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN_ASSOCIATION]");
   *   String ruleId = "ruleId-919875273";
   *   BackupPlanAssociation response = backupDRClient.triggerBackupAsync(name, ruleId).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the backup plan association resource, in the format
   *     `projects/{project}/locations/{location}/backupPlanAssociations/{backupPlanAssociationId}`
   * @param ruleId Required. backup rule_id for which a backup needs to be triggered.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BackupPlanAssociation, OperationMetadata> triggerBackupAsync(
      BackupPlanAssociationName name, String ruleId) {
    TriggerBackupRequest request =
        TriggerBackupRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setRuleId(ruleId)
            .build();
    return triggerBackupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Triggers a new Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   String name =
   *       BackupPlanAssociationName.of("[PROJECT]", "[LOCATION]", "[BACKUP_PLAN_ASSOCIATION]")
   *           .toString();
   *   String ruleId = "ruleId-919875273";
   *   BackupPlanAssociation response = backupDRClient.triggerBackupAsync(name, ruleId).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the backup plan association resource, in the format
   *     `projects/{project}/locations/{location}/backupPlanAssociations/{backupPlanAssociationId}`
   * @param ruleId Required. backup rule_id for which a backup needs to be triggered.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BackupPlanAssociation, OperationMetadata> triggerBackupAsync(
      String name, String ruleId) {
    TriggerBackupRequest request =
        TriggerBackupRequest.newBuilder().setName(name).setRuleId(ruleId).build();
    return triggerBackupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Triggers a new Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   TriggerBackupRequest request =
   *       TriggerBackupRequest.newBuilder()
   *           .setName(
   *               BackupPlanAssociationName.of(
   *                       "[PROJECT]", "[LOCATION]", "[BACKUP_PLAN_ASSOCIATION]")
   *                   .toString())
   *           .setRuleId("ruleId-919875273")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   BackupPlanAssociation response = backupDRClient.triggerBackupAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BackupPlanAssociation, OperationMetadata> triggerBackupAsync(
      TriggerBackupRequest request) {
    return triggerBackupOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Triggers a new Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   TriggerBackupRequest request =
   *       TriggerBackupRequest.newBuilder()
   *           .setName(
   *               BackupPlanAssociationName.of(
   *                       "[PROJECT]", "[LOCATION]", "[BACKUP_PLAN_ASSOCIATION]")
   *                   .toString())
   *           .setRuleId("ruleId-919875273")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<BackupPlanAssociation, OperationMetadata> future =
   *       backupDRClient.triggerBackupOperationCallable().futureCall(request);
   *   // Do something.
   *   BackupPlanAssociation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<TriggerBackupRequest, BackupPlanAssociation, OperationMetadata>
      triggerBackupOperationCallable() {
    return stub.triggerBackupOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Triggers a new Backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   TriggerBackupRequest request =
   *       TriggerBackupRequest.newBuilder()
   *           .setName(
   *               BackupPlanAssociationName.of(
   *                       "[PROJECT]", "[LOCATION]", "[BACKUP_PLAN_ASSOCIATION]")
   *                   .toString())
   *           .setRuleId("ruleId-919875273")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = backupDRClient.triggerBackupCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TriggerBackupRequest, Operation> triggerBackupCallable() {
    return stub.triggerBackupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single DataSourceReference.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   DataSourceReferenceName name =
   *       DataSourceReferenceName.of("[PROJECT]", "[LOCATION]", "[DATA_SOURCE_REFERENCE]");
   *   DataSourceReference response = backupDRClient.getDataSourceReference(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the DataSourceReference to retrieve. Format:
   *     projects/{project}/locations/{location}/dataSourceReferences/{data_source_reference}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataSourceReference getDataSourceReference(DataSourceReferenceName name) {
    GetDataSourceReferenceRequest request =
        GetDataSourceReferenceRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getDataSourceReference(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single DataSourceReference.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   String name =
   *       DataSourceReferenceName.of("[PROJECT]", "[LOCATION]", "[DATA_SOURCE_REFERENCE]")
   *           .toString();
   *   DataSourceReference response = backupDRClient.getDataSourceReference(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the DataSourceReference to retrieve. Format:
   *     projects/{project}/locations/{location}/dataSourceReferences/{data_source_reference}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataSourceReference getDataSourceReference(String name) {
    GetDataSourceReferenceRequest request =
        GetDataSourceReferenceRequest.newBuilder().setName(name).build();
    return getDataSourceReference(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single DataSourceReference.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   GetDataSourceReferenceRequest request =
   *       GetDataSourceReferenceRequest.newBuilder()
   *           .setName(
   *               DataSourceReferenceName.of("[PROJECT]", "[LOCATION]", "[DATA_SOURCE_REFERENCE]")
   *                   .toString())
   *           .build();
   *   DataSourceReference response = backupDRClient.getDataSourceReference(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataSourceReference getDataSourceReference(GetDataSourceReferenceRequest request) {
    return getDataSourceReferenceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single DataSourceReference.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   GetDataSourceReferenceRequest request =
   *       GetDataSourceReferenceRequest.newBuilder()
   *           .setName(
   *               DataSourceReferenceName.of("[PROJECT]", "[LOCATION]", "[DATA_SOURCE_REFERENCE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<DataSourceReference> future =
   *       backupDRClient.getDataSourceReferenceCallable().futureCall(request);
   *   // Do something.
   *   DataSourceReference response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDataSourceReferenceRequest, DataSourceReference>
      getDataSourceReferenceCallable() {
    return stub.getDataSourceReferenceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetch DataSourceReferences for a given project, location and resource type.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   String resourceType = "resourceType-384364440";
   *   for (DataSourceReference element :
   *       backupDRClient
   *           .fetchDataSourceReferencesForResourceType(parent, resourceType)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name. Format:
   *     projects/{project}/locations/{location}
   * @param resourceType Required. The type of the GCP resource. Ex: sql.googleapis.com/Instance
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchDataSourceReferencesForResourceTypePagedResponse
      fetchDataSourceReferencesForResourceType(LocationName parent, String resourceType) {
    FetchDataSourceReferencesForResourceTypeRequest request =
        FetchDataSourceReferencesForResourceTypeRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setResourceType(resourceType)
            .build();
    return fetchDataSourceReferencesForResourceType(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetch DataSourceReferences for a given project, location and resource type.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   String resourceType = "resourceType-384364440";
   *   for (DataSourceReference element :
   *       backupDRClient
   *           .fetchDataSourceReferencesForResourceType(parent, resourceType)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name. Format:
   *     projects/{project}/locations/{location}
   * @param resourceType Required. The type of the GCP resource. Ex: sql.googleapis.com/Instance
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchDataSourceReferencesForResourceTypePagedResponse
      fetchDataSourceReferencesForResourceType(String parent, String resourceType) {
    FetchDataSourceReferencesForResourceTypeRequest request =
        FetchDataSourceReferencesForResourceTypeRequest.newBuilder()
            .setParent(parent)
            .setResourceType(resourceType)
            .build();
    return fetchDataSourceReferencesForResourceType(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetch DataSourceReferences for a given project, location and resource type.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   FetchDataSourceReferencesForResourceTypeRequest request =
   *       FetchDataSourceReferencesForResourceTypeRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setResourceType("resourceType-384364440")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (DataSourceReference element :
   *       backupDRClient.fetchDataSourceReferencesForResourceType(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchDataSourceReferencesForResourceTypePagedResponse
      fetchDataSourceReferencesForResourceType(
          FetchDataSourceReferencesForResourceTypeRequest request) {
    return fetchDataSourceReferencesForResourceTypePagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetch DataSourceReferences for a given project, location and resource type.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   FetchDataSourceReferencesForResourceTypeRequest request =
   *       FetchDataSourceReferencesForResourceTypeRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setResourceType("resourceType-384364440")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<DataSourceReference> future =
   *       backupDRClient
   *           .fetchDataSourceReferencesForResourceTypePagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (DataSourceReference element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          FetchDataSourceReferencesForResourceTypeRequest,
          FetchDataSourceReferencesForResourceTypePagedResponse>
      fetchDataSourceReferencesForResourceTypePagedCallable() {
    return stub.fetchDataSourceReferencesForResourceTypePagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetch DataSourceReferences for a given project, location and resource type.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   FetchDataSourceReferencesForResourceTypeRequest request =
   *       FetchDataSourceReferencesForResourceTypeRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setResourceType("resourceType-384364440")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     FetchDataSourceReferencesForResourceTypeResponse response =
   *         backupDRClient.fetchDataSourceReferencesForResourceTypeCallable().call(request);
   *     for (DataSourceReference element : response.getDataSourceReferencesList()) {
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
          FetchDataSourceReferencesForResourceTypeRequest,
          FetchDataSourceReferencesForResourceTypeResponse>
      fetchDataSourceReferencesForResourceTypeCallable() {
    return stub.fetchDataSourceReferencesForResourceTypeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initializes the service related config for a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   InitializeServiceRequest request =
   *       InitializeServiceRequest.newBuilder()
   *           .setName("name3373707")
   *           .setResourceType("resourceType-384364440")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   InitializeServiceResponse response = backupDRClient.initializeServiceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<InitializeServiceResponse, OperationMetadata> initializeServiceAsync(
      InitializeServiceRequest request) {
    return initializeServiceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initializes the service related config for a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   InitializeServiceRequest request =
   *       InitializeServiceRequest.newBuilder()
   *           .setName("name3373707")
   *           .setResourceType("resourceType-384364440")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<InitializeServiceResponse, OperationMetadata> future =
   *       backupDRClient.initializeServiceOperationCallable().futureCall(request);
   *   // Do something.
   *   InitializeServiceResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          InitializeServiceRequest, InitializeServiceResponse, OperationMetadata>
      initializeServiceOperationCallable() {
    return stub.initializeServiceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initializes the service related config for a project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   InitializeServiceRequest request =
   *       InitializeServiceRequest.newBuilder()
   *           .setName("name3373707")
   *           .setResourceType("resourceType-384364440")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = backupDRClient.initializeServiceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InitializeServiceRequest, Operation> initializeServiceCallable() {
    return stub.initializeServiceCallable();
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
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : backupDRClient.listLocations(request).iterateAll()) {
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
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future = backupDRClient.listLocationsPagedCallable().futureCall(request);
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
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = backupDRClient.listLocationsCallable().call(request);
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
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = backupDRClient.getLocation(request);
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
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = backupDRClient.getLocationCallable().futureCall(request);
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
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               ManagementServerName.of("[PROJECT]", "[LOCATION]", "[MANAGEMENTSERVER]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = backupDRClient.setIamPolicy(request);
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
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               ManagementServerName.of("[PROJECT]", "[LOCATION]", "[MANAGEMENTSERVER]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = backupDRClient.setIamPolicyCallable().futureCall(request);
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
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               ManagementServerName.of("[PROJECT]", "[LOCATION]", "[MANAGEMENTSERVER]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = backupDRClient.getIamPolicy(request);
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
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               ManagementServerName.of("[PROJECT]", "[LOCATION]", "[MANAGEMENTSERVER]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = backupDRClient.getIamPolicyCallable().futureCall(request);
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
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               ManagementServerName.of("[PROJECT]", "[LOCATION]", "[MANAGEMENTSERVER]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = backupDRClient.testIamPermissions(request);
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
   * try (BackupDRClient backupDRClient = BackupDRClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               ManagementServerName.of("[PROJECT]", "[LOCATION]", "[MANAGEMENTSERVER]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       backupDRClient.testIamPermissionsCallable().futureCall(request);
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

  public static class ListManagementServersPagedResponse
      extends AbstractPagedListResponse<
          ListManagementServersRequest,
          ListManagementServersResponse,
          ManagementServer,
          ListManagementServersPage,
          ListManagementServersFixedSizeCollection> {

    public static ApiFuture<ListManagementServersPagedResponse> createAsync(
        PageContext<ListManagementServersRequest, ListManagementServersResponse, ManagementServer>
            context,
        ApiFuture<ListManagementServersResponse> futureResponse) {
      ApiFuture<ListManagementServersPage> futurePage =
          ListManagementServersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListManagementServersPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListManagementServersPagedResponse(ListManagementServersPage page) {
      super(page, ListManagementServersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListManagementServersPage
      extends AbstractPage<
          ListManagementServersRequest,
          ListManagementServersResponse,
          ManagementServer,
          ListManagementServersPage> {

    private ListManagementServersPage(
        PageContext<ListManagementServersRequest, ListManagementServersResponse, ManagementServer>
            context,
        ListManagementServersResponse response) {
      super(context, response);
    }

    private static ListManagementServersPage createEmptyPage() {
      return new ListManagementServersPage(null, null);
    }

    @Override
    protected ListManagementServersPage createPage(
        PageContext<ListManagementServersRequest, ListManagementServersResponse, ManagementServer>
            context,
        ListManagementServersResponse response) {
      return new ListManagementServersPage(context, response);
    }

    @Override
    public ApiFuture<ListManagementServersPage> createPageAsync(
        PageContext<ListManagementServersRequest, ListManagementServersResponse, ManagementServer>
            context,
        ApiFuture<ListManagementServersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListManagementServersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListManagementServersRequest,
          ListManagementServersResponse,
          ManagementServer,
          ListManagementServersPage,
          ListManagementServersFixedSizeCollection> {

    private ListManagementServersFixedSizeCollection(
        List<ListManagementServersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListManagementServersFixedSizeCollection createEmptyCollection() {
      return new ListManagementServersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListManagementServersFixedSizeCollection createCollection(
        List<ListManagementServersPage> pages, int collectionSize) {
      return new ListManagementServersFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListBackupVaultsPagedResponse
      extends AbstractPagedListResponse<
          ListBackupVaultsRequest,
          ListBackupVaultsResponse,
          BackupVault,
          ListBackupVaultsPage,
          ListBackupVaultsFixedSizeCollection> {

    public static ApiFuture<ListBackupVaultsPagedResponse> createAsync(
        PageContext<ListBackupVaultsRequest, ListBackupVaultsResponse, BackupVault> context,
        ApiFuture<ListBackupVaultsResponse> futureResponse) {
      ApiFuture<ListBackupVaultsPage> futurePage =
          ListBackupVaultsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListBackupVaultsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListBackupVaultsPagedResponse(ListBackupVaultsPage page) {
      super(page, ListBackupVaultsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListBackupVaultsPage
      extends AbstractPage<
          ListBackupVaultsRequest, ListBackupVaultsResponse, BackupVault, ListBackupVaultsPage> {

    private ListBackupVaultsPage(
        PageContext<ListBackupVaultsRequest, ListBackupVaultsResponse, BackupVault> context,
        ListBackupVaultsResponse response) {
      super(context, response);
    }

    private static ListBackupVaultsPage createEmptyPage() {
      return new ListBackupVaultsPage(null, null);
    }

    @Override
    protected ListBackupVaultsPage createPage(
        PageContext<ListBackupVaultsRequest, ListBackupVaultsResponse, BackupVault> context,
        ListBackupVaultsResponse response) {
      return new ListBackupVaultsPage(context, response);
    }

    @Override
    public ApiFuture<ListBackupVaultsPage> createPageAsync(
        PageContext<ListBackupVaultsRequest, ListBackupVaultsResponse, BackupVault> context,
        ApiFuture<ListBackupVaultsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListBackupVaultsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListBackupVaultsRequest,
          ListBackupVaultsResponse,
          BackupVault,
          ListBackupVaultsPage,
          ListBackupVaultsFixedSizeCollection> {

    private ListBackupVaultsFixedSizeCollection(
        List<ListBackupVaultsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListBackupVaultsFixedSizeCollection createEmptyCollection() {
      return new ListBackupVaultsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListBackupVaultsFixedSizeCollection createCollection(
        List<ListBackupVaultsPage> pages, int collectionSize) {
      return new ListBackupVaultsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class FetchUsableBackupVaultsPagedResponse
      extends AbstractPagedListResponse<
          FetchUsableBackupVaultsRequest,
          FetchUsableBackupVaultsResponse,
          BackupVault,
          FetchUsableBackupVaultsPage,
          FetchUsableBackupVaultsFixedSizeCollection> {

    public static ApiFuture<FetchUsableBackupVaultsPagedResponse> createAsync(
        PageContext<FetchUsableBackupVaultsRequest, FetchUsableBackupVaultsResponse, BackupVault>
            context,
        ApiFuture<FetchUsableBackupVaultsResponse> futureResponse) {
      ApiFuture<FetchUsableBackupVaultsPage> futurePage =
          FetchUsableBackupVaultsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new FetchUsableBackupVaultsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private FetchUsableBackupVaultsPagedResponse(FetchUsableBackupVaultsPage page) {
      super(page, FetchUsableBackupVaultsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class FetchUsableBackupVaultsPage
      extends AbstractPage<
          FetchUsableBackupVaultsRequest,
          FetchUsableBackupVaultsResponse,
          BackupVault,
          FetchUsableBackupVaultsPage> {

    private FetchUsableBackupVaultsPage(
        PageContext<FetchUsableBackupVaultsRequest, FetchUsableBackupVaultsResponse, BackupVault>
            context,
        FetchUsableBackupVaultsResponse response) {
      super(context, response);
    }

    private static FetchUsableBackupVaultsPage createEmptyPage() {
      return new FetchUsableBackupVaultsPage(null, null);
    }

    @Override
    protected FetchUsableBackupVaultsPage createPage(
        PageContext<FetchUsableBackupVaultsRequest, FetchUsableBackupVaultsResponse, BackupVault>
            context,
        FetchUsableBackupVaultsResponse response) {
      return new FetchUsableBackupVaultsPage(context, response);
    }

    @Override
    public ApiFuture<FetchUsableBackupVaultsPage> createPageAsync(
        PageContext<FetchUsableBackupVaultsRequest, FetchUsableBackupVaultsResponse, BackupVault>
            context,
        ApiFuture<FetchUsableBackupVaultsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class FetchUsableBackupVaultsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          FetchUsableBackupVaultsRequest,
          FetchUsableBackupVaultsResponse,
          BackupVault,
          FetchUsableBackupVaultsPage,
          FetchUsableBackupVaultsFixedSizeCollection> {

    private FetchUsableBackupVaultsFixedSizeCollection(
        List<FetchUsableBackupVaultsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static FetchUsableBackupVaultsFixedSizeCollection createEmptyCollection() {
      return new FetchUsableBackupVaultsFixedSizeCollection(null, 0);
    }

    @Override
    protected FetchUsableBackupVaultsFixedSizeCollection createCollection(
        List<FetchUsableBackupVaultsPage> pages, int collectionSize) {
      return new FetchUsableBackupVaultsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListDataSourcesPagedResponse
      extends AbstractPagedListResponse<
          ListDataSourcesRequest,
          ListDataSourcesResponse,
          DataSource,
          ListDataSourcesPage,
          ListDataSourcesFixedSizeCollection> {

    public static ApiFuture<ListDataSourcesPagedResponse> createAsync(
        PageContext<ListDataSourcesRequest, ListDataSourcesResponse, DataSource> context,
        ApiFuture<ListDataSourcesResponse> futureResponse) {
      ApiFuture<ListDataSourcesPage> futurePage =
          ListDataSourcesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDataSourcesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDataSourcesPagedResponse(ListDataSourcesPage page) {
      super(page, ListDataSourcesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDataSourcesPage
      extends AbstractPage<
          ListDataSourcesRequest, ListDataSourcesResponse, DataSource, ListDataSourcesPage> {

    private ListDataSourcesPage(
        PageContext<ListDataSourcesRequest, ListDataSourcesResponse, DataSource> context,
        ListDataSourcesResponse response) {
      super(context, response);
    }

    private static ListDataSourcesPage createEmptyPage() {
      return new ListDataSourcesPage(null, null);
    }

    @Override
    protected ListDataSourcesPage createPage(
        PageContext<ListDataSourcesRequest, ListDataSourcesResponse, DataSource> context,
        ListDataSourcesResponse response) {
      return new ListDataSourcesPage(context, response);
    }

    @Override
    public ApiFuture<ListDataSourcesPage> createPageAsync(
        PageContext<ListDataSourcesRequest, ListDataSourcesResponse, DataSource> context,
        ApiFuture<ListDataSourcesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDataSourcesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDataSourcesRequest,
          ListDataSourcesResponse,
          DataSource,
          ListDataSourcesPage,
          ListDataSourcesFixedSizeCollection> {

    private ListDataSourcesFixedSizeCollection(
        List<ListDataSourcesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDataSourcesFixedSizeCollection createEmptyCollection() {
      return new ListDataSourcesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDataSourcesFixedSizeCollection createCollection(
        List<ListDataSourcesPage> pages, int collectionSize) {
      return new ListDataSourcesFixedSizeCollection(pages, collectionSize);
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

  public static class ListBackupPlanRevisionsPagedResponse
      extends AbstractPagedListResponse<
          ListBackupPlanRevisionsRequest,
          ListBackupPlanRevisionsResponse,
          BackupPlanRevision,
          ListBackupPlanRevisionsPage,
          ListBackupPlanRevisionsFixedSizeCollection> {

    public static ApiFuture<ListBackupPlanRevisionsPagedResponse> createAsync(
        PageContext<
                ListBackupPlanRevisionsRequest, ListBackupPlanRevisionsResponse, BackupPlanRevision>
            context,
        ApiFuture<ListBackupPlanRevisionsResponse> futureResponse) {
      ApiFuture<ListBackupPlanRevisionsPage> futurePage =
          ListBackupPlanRevisionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListBackupPlanRevisionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListBackupPlanRevisionsPagedResponse(ListBackupPlanRevisionsPage page) {
      super(page, ListBackupPlanRevisionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListBackupPlanRevisionsPage
      extends AbstractPage<
          ListBackupPlanRevisionsRequest,
          ListBackupPlanRevisionsResponse,
          BackupPlanRevision,
          ListBackupPlanRevisionsPage> {

    private ListBackupPlanRevisionsPage(
        PageContext<
                ListBackupPlanRevisionsRequest, ListBackupPlanRevisionsResponse, BackupPlanRevision>
            context,
        ListBackupPlanRevisionsResponse response) {
      super(context, response);
    }

    private static ListBackupPlanRevisionsPage createEmptyPage() {
      return new ListBackupPlanRevisionsPage(null, null);
    }

    @Override
    protected ListBackupPlanRevisionsPage createPage(
        PageContext<
                ListBackupPlanRevisionsRequest, ListBackupPlanRevisionsResponse, BackupPlanRevision>
            context,
        ListBackupPlanRevisionsResponse response) {
      return new ListBackupPlanRevisionsPage(context, response);
    }

    @Override
    public ApiFuture<ListBackupPlanRevisionsPage> createPageAsync(
        PageContext<
                ListBackupPlanRevisionsRequest, ListBackupPlanRevisionsResponse, BackupPlanRevision>
            context,
        ApiFuture<ListBackupPlanRevisionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListBackupPlanRevisionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListBackupPlanRevisionsRequest,
          ListBackupPlanRevisionsResponse,
          BackupPlanRevision,
          ListBackupPlanRevisionsPage,
          ListBackupPlanRevisionsFixedSizeCollection> {

    private ListBackupPlanRevisionsFixedSizeCollection(
        List<ListBackupPlanRevisionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListBackupPlanRevisionsFixedSizeCollection createEmptyCollection() {
      return new ListBackupPlanRevisionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListBackupPlanRevisionsFixedSizeCollection createCollection(
        List<ListBackupPlanRevisionsPage> pages, int collectionSize) {
      return new ListBackupPlanRevisionsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListBackupPlanAssociationsPagedResponse
      extends AbstractPagedListResponse<
          ListBackupPlanAssociationsRequest,
          ListBackupPlanAssociationsResponse,
          BackupPlanAssociation,
          ListBackupPlanAssociationsPage,
          ListBackupPlanAssociationsFixedSizeCollection> {

    public static ApiFuture<ListBackupPlanAssociationsPagedResponse> createAsync(
        PageContext<
                ListBackupPlanAssociationsRequest,
                ListBackupPlanAssociationsResponse,
                BackupPlanAssociation>
            context,
        ApiFuture<ListBackupPlanAssociationsResponse> futureResponse) {
      ApiFuture<ListBackupPlanAssociationsPage> futurePage =
          ListBackupPlanAssociationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListBackupPlanAssociationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListBackupPlanAssociationsPagedResponse(ListBackupPlanAssociationsPage page) {
      super(page, ListBackupPlanAssociationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListBackupPlanAssociationsPage
      extends AbstractPage<
          ListBackupPlanAssociationsRequest,
          ListBackupPlanAssociationsResponse,
          BackupPlanAssociation,
          ListBackupPlanAssociationsPage> {

    private ListBackupPlanAssociationsPage(
        PageContext<
                ListBackupPlanAssociationsRequest,
                ListBackupPlanAssociationsResponse,
                BackupPlanAssociation>
            context,
        ListBackupPlanAssociationsResponse response) {
      super(context, response);
    }

    private static ListBackupPlanAssociationsPage createEmptyPage() {
      return new ListBackupPlanAssociationsPage(null, null);
    }

    @Override
    protected ListBackupPlanAssociationsPage createPage(
        PageContext<
                ListBackupPlanAssociationsRequest,
                ListBackupPlanAssociationsResponse,
                BackupPlanAssociation>
            context,
        ListBackupPlanAssociationsResponse response) {
      return new ListBackupPlanAssociationsPage(context, response);
    }

    @Override
    public ApiFuture<ListBackupPlanAssociationsPage> createPageAsync(
        PageContext<
                ListBackupPlanAssociationsRequest,
                ListBackupPlanAssociationsResponse,
                BackupPlanAssociation>
            context,
        ApiFuture<ListBackupPlanAssociationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListBackupPlanAssociationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListBackupPlanAssociationsRequest,
          ListBackupPlanAssociationsResponse,
          BackupPlanAssociation,
          ListBackupPlanAssociationsPage,
          ListBackupPlanAssociationsFixedSizeCollection> {

    private ListBackupPlanAssociationsFixedSizeCollection(
        List<ListBackupPlanAssociationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListBackupPlanAssociationsFixedSizeCollection createEmptyCollection() {
      return new ListBackupPlanAssociationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListBackupPlanAssociationsFixedSizeCollection createCollection(
        List<ListBackupPlanAssociationsPage> pages, int collectionSize) {
      return new ListBackupPlanAssociationsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class FetchBackupPlanAssociationsForResourceTypePagedResponse
      extends AbstractPagedListResponse<
          FetchBackupPlanAssociationsForResourceTypeRequest,
          FetchBackupPlanAssociationsForResourceTypeResponse,
          BackupPlanAssociation,
          FetchBackupPlanAssociationsForResourceTypePage,
          FetchBackupPlanAssociationsForResourceTypeFixedSizeCollection> {

    public static ApiFuture<FetchBackupPlanAssociationsForResourceTypePagedResponse> createAsync(
        PageContext<
                FetchBackupPlanAssociationsForResourceTypeRequest,
                FetchBackupPlanAssociationsForResourceTypeResponse,
                BackupPlanAssociation>
            context,
        ApiFuture<FetchBackupPlanAssociationsForResourceTypeResponse> futureResponse) {
      ApiFuture<FetchBackupPlanAssociationsForResourceTypePage> futurePage =
          FetchBackupPlanAssociationsForResourceTypePage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new FetchBackupPlanAssociationsForResourceTypePagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private FetchBackupPlanAssociationsForResourceTypePagedResponse(
        FetchBackupPlanAssociationsForResourceTypePage page) {
      super(
          page,
          FetchBackupPlanAssociationsForResourceTypeFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class FetchBackupPlanAssociationsForResourceTypePage
      extends AbstractPage<
          FetchBackupPlanAssociationsForResourceTypeRequest,
          FetchBackupPlanAssociationsForResourceTypeResponse,
          BackupPlanAssociation,
          FetchBackupPlanAssociationsForResourceTypePage> {

    private FetchBackupPlanAssociationsForResourceTypePage(
        PageContext<
                FetchBackupPlanAssociationsForResourceTypeRequest,
                FetchBackupPlanAssociationsForResourceTypeResponse,
                BackupPlanAssociation>
            context,
        FetchBackupPlanAssociationsForResourceTypeResponse response) {
      super(context, response);
    }

    private static FetchBackupPlanAssociationsForResourceTypePage createEmptyPage() {
      return new FetchBackupPlanAssociationsForResourceTypePage(null, null);
    }

    @Override
    protected FetchBackupPlanAssociationsForResourceTypePage createPage(
        PageContext<
                FetchBackupPlanAssociationsForResourceTypeRequest,
                FetchBackupPlanAssociationsForResourceTypeResponse,
                BackupPlanAssociation>
            context,
        FetchBackupPlanAssociationsForResourceTypeResponse response) {
      return new FetchBackupPlanAssociationsForResourceTypePage(context, response);
    }

    @Override
    public ApiFuture<FetchBackupPlanAssociationsForResourceTypePage> createPageAsync(
        PageContext<
                FetchBackupPlanAssociationsForResourceTypeRequest,
                FetchBackupPlanAssociationsForResourceTypeResponse,
                BackupPlanAssociation>
            context,
        ApiFuture<FetchBackupPlanAssociationsForResourceTypeResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class FetchBackupPlanAssociationsForResourceTypeFixedSizeCollection
      extends AbstractFixedSizeCollection<
          FetchBackupPlanAssociationsForResourceTypeRequest,
          FetchBackupPlanAssociationsForResourceTypeResponse,
          BackupPlanAssociation,
          FetchBackupPlanAssociationsForResourceTypePage,
          FetchBackupPlanAssociationsForResourceTypeFixedSizeCollection> {

    private FetchBackupPlanAssociationsForResourceTypeFixedSizeCollection(
        List<FetchBackupPlanAssociationsForResourceTypePage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static FetchBackupPlanAssociationsForResourceTypeFixedSizeCollection
        createEmptyCollection() {
      return new FetchBackupPlanAssociationsForResourceTypeFixedSizeCollection(null, 0);
    }

    @Override
    protected FetchBackupPlanAssociationsForResourceTypeFixedSizeCollection createCollection(
        List<FetchBackupPlanAssociationsForResourceTypePage> pages, int collectionSize) {
      return new FetchBackupPlanAssociationsForResourceTypeFixedSizeCollection(
          pages, collectionSize);
    }
  }

  public static class FetchDataSourceReferencesForResourceTypePagedResponse
      extends AbstractPagedListResponse<
          FetchDataSourceReferencesForResourceTypeRequest,
          FetchDataSourceReferencesForResourceTypeResponse,
          DataSourceReference,
          FetchDataSourceReferencesForResourceTypePage,
          FetchDataSourceReferencesForResourceTypeFixedSizeCollection> {

    public static ApiFuture<FetchDataSourceReferencesForResourceTypePagedResponse> createAsync(
        PageContext<
                FetchDataSourceReferencesForResourceTypeRequest,
                FetchDataSourceReferencesForResourceTypeResponse,
                DataSourceReference>
            context,
        ApiFuture<FetchDataSourceReferencesForResourceTypeResponse> futureResponse) {
      ApiFuture<FetchDataSourceReferencesForResourceTypePage> futurePage =
          FetchDataSourceReferencesForResourceTypePage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new FetchDataSourceReferencesForResourceTypePagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private FetchDataSourceReferencesForResourceTypePagedResponse(
        FetchDataSourceReferencesForResourceTypePage page) {
      super(
          page,
          FetchDataSourceReferencesForResourceTypeFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class FetchDataSourceReferencesForResourceTypePage
      extends AbstractPage<
          FetchDataSourceReferencesForResourceTypeRequest,
          FetchDataSourceReferencesForResourceTypeResponse,
          DataSourceReference,
          FetchDataSourceReferencesForResourceTypePage> {

    private FetchDataSourceReferencesForResourceTypePage(
        PageContext<
                FetchDataSourceReferencesForResourceTypeRequest,
                FetchDataSourceReferencesForResourceTypeResponse,
                DataSourceReference>
            context,
        FetchDataSourceReferencesForResourceTypeResponse response) {
      super(context, response);
    }

    private static FetchDataSourceReferencesForResourceTypePage createEmptyPage() {
      return new FetchDataSourceReferencesForResourceTypePage(null, null);
    }

    @Override
    protected FetchDataSourceReferencesForResourceTypePage createPage(
        PageContext<
                FetchDataSourceReferencesForResourceTypeRequest,
                FetchDataSourceReferencesForResourceTypeResponse,
                DataSourceReference>
            context,
        FetchDataSourceReferencesForResourceTypeResponse response) {
      return new FetchDataSourceReferencesForResourceTypePage(context, response);
    }

    @Override
    public ApiFuture<FetchDataSourceReferencesForResourceTypePage> createPageAsync(
        PageContext<
                FetchDataSourceReferencesForResourceTypeRequest,
                FetchDataSourceReferencesForResourceTypeResponse,
                DataSourceReference>
            context,
        ApiFuture<FetchDataSourceReferencesForResourceTypeResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class FetchDataSourceReferencesForResourceTypeFixedSizeCollection
      extends AbstractFixedSizeCollection<
          FetchDataSourceReferencesForResourceTypeRequest,
          FetchDataSourceReferencesForResourceTypeResponse,
          DataSourceReference,
          FetchDataSourceReferencesForResourceTypePage,
          FetchDataSourceReferencesForResourceTypeFixedSizeCollection> {

    private FetchDataSourceReferencesForResourceTypeFixedSizeCollection(
        List<FetchDataSourceReferencesForResourceTypePage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static FetchDataSourceReferencesForResourceTypeFixedSizeCollection
        createEmptyCollection() {
      return new FetchDataSourceReferencesForResourceTypeFixedSizeCollection(null, 0);
    }

    @Override
    protected FetchDataSourceReferencesForResourceTypeFixedSizeCollection createCollection(
        List<FetchDataSourceReferencesForResourceTypePage> pages, int collectionSize) {
      return new FetchDataSourceReferencesForResourceTypeFixedSizeCollection(pages, collectionSize);
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
