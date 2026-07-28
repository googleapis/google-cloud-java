/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.memorystore.v1beta;

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
import com.google.cloud.memorystore.v1beta.stub.MemorystoreStub;
import com.google.cloud.memorystore.v1beta.stub.MemorystoreStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service describing handlers for resources
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
 * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
 *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
 *   Instance response = memorystoreClient.getInstance(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the MemorystoreClient object to clean up resources such as
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
 *      <td><p> ListInstances</td>
 *      <td><p> Lists Instances in a given project and location.</td>
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
 *      <td><p> Gets details of a single Instance.</td>
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
 *      <td><p> CreateInstance</td>
 *      <td><p> Creates a new Instance in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createInstanceAsync(CreateInstanceRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createInstanceAsync(LocationName parent, Instance instance, String instanceId)
 *           <li><p> createInstanceAsync(String parent, Instance instance, String instanceId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createInstanceOperationCallable()
 *           <li><p> createInstanceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateInstance</td>
 *      <td><p> Updates the parameters of a single Instance.</td>
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
 *      <td><p> DeleteInstance</td>
 *      <td><p> Deletes a single Instance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteInstanceAsync(DeleteInstanceRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteInstanceAsync(InstanceName name)
 *           <li><p> deleteInstanceAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteInstanceOperationCallable()
 *           <li><p> deleteInstanceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetCertificateAuthority</td>
 *      <td><p> Gets details about the certificate authority for an Instance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getCertificateAuthority(GetCertificateAuthorityRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getCertificateAuthority(InstanceName name)
 *           <li><p> getCertificateAuthority(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCertificateAuthorityCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetSharedRegionalCertificateAuthority</td>
 *      <td><p> Gets the details of shared regional certificate authority information for Memorystore instance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getSharedRegionalCertificateAuthority(GetSharedRegionalCertificateAuthorityRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getSharedRegionalCertificateAuthority(SharedRegionalCertificateAuthorityName name)
 *           <li><p> getSharedRegionalCertificateAuthority(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getSharedRegionalCertificateAuthorityCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RescheduleMaintenance</td>
 *      <td><p> Reschedules upcoming maintenance event.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> rescheduleMaintenanceAsync(RescheduleMaintenanceRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> rescheduleMaintenanceAsync(InstanceName name, RescheduleMaintenanceRequest.RescheduleType rescheduleType, Timestamp scheduleTime)
 *           <li><p> rescheduleMaintenanceAsync(String name, RescheduleMaintenanceRequest.RescheduleType rescheduleType, Timestamp scheduleTime)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> rescheduleMaintenanceOperationCallable()
 *           <li><p> rescheduleMaintenanceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListBackupCollections</td>
 *      <td><p> Lists all backup collections owned by a consumer project in either the specified location (region) or all locations.
 * <p>  If `location_id` is specified as `-` (wildcard), then all regions available to the project are queried, and the results are aggregated.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listBackupCollections(ListBackupCollectionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listBackupCollections(LocationName parent)
 *           <li><p> listBackupCollections(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listBackupCollectionsPagedCallable()
 *           <li><p> listBackupCollectionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetBackupCollection</td>
 *      <td><p> Get a backup collection.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getBackupCollection(GetBackupCollectionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getBackupCollection(BackupCollectionName name)
 *           <li><p> getBackupCollection(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getBackupCollectionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListBackups</td>
 *      <td><p> Lists all backups owned by a backup collection.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listBackups(ListBackupsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listBackups(BackupCollectionName parent)
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
 *      <td><p> Gets the details of a specific backup.</td>
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
 *      <td><p> DeleteBackup</td>
 *      <td><p> Deletes a specific backup.</td>
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
 *      <td><p> ExportBackup</td>
 *      <td><p> Exports a specific backup to a customer target Cloud Storage URI.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> exportBackupAsync(ExportBackupRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> exportBackupOperationCallable()
 *           <li><p> exportBackupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BackupInstance</td>
 *      <td><p> Backup Instance. If this is the first time a backup is being created, a backup collection will be created at the backend, and this backup belongs to this collection. Both collection and backup will have a resource name. Backup will be executed for each shard. A replica (primary if nonHA) will be selected to perform the execution. Backup call will be rejected if there is an ongoing backup or update operation. Be aware that during preview, if the instance's internal software version is too old, critical update will be performed before actual backup. Once the internal software version is updated to the minimum version required by the backup feature, subsequent backups will not require critical update. After preview, there will be no critical update needed for backup.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> backupInstanceAsync(BackupInstanceRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> backupInstanceAsync(InstanceName name)
 *           <li><p> backupInstanceAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> backupInstanceOperationCallable()
 *           <li><p> backupInstanceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> StartMigration</td>
 *      <td><p> Initiates the migration of a source instance to the target Memorystore instance.
 * <p>  After the successful completion of this operation, the target instance will: 1. Set up replication with the source instance and replicate any writes to the source instance. 2. Only allow reads.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> startMigrationAsync(StartMigrationRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> startMigrationOperationCallable()
 *           <li><p> startMigrationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> FinishMigration</td>
 *      <td><p> Finalizes the migration process.
 * <p>  After the successful completion of this operation, the target instance will: 1. Stop replicating from the source instance. 2. Allow both reads and writes.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> finishMigrationAsync(FinishMigrationRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> finishMigrationAsync(InstanceName name, boolean force)
 *           <li><p> finishMigrationAsync(String name, boolean force)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> finishMigrationOperationCallable()
 *           <li><p> finishMigrationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListTokenAuthUsers</td>
 *      <td><p> Lists all the token auth users for a token based auth enabled instance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listTokenAuthUsers(ListTokenAuthUsersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listTokenAuthUsers(InstanceName parent)
 *           <li><p> listTokenAuthUsers(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listTokenAuthUsersPagedCallable()
 *           <li><p> listTokenAuthUsersCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetTokenAuthUser</td>
 *      <td><p> Gets a specific token auth user for a token based auth enabled instance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getTokenAuthUser(GetTokenAuthUserRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getTokenAuthUser(TokenAuthUserName name)
 *           <li><p> getTokenAuthUser(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getTokenAuthUserCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAuthTokens</td>
 *      <td><p> Lists all the auth tokens for a specific token auth user.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAuthTokens(ListAuthTokensRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAuthTokens(TokenAuthUserName parent)
 *           <li><p> listAuthTokens(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAuthTokensPagedCallable()
 *           <li><p> listAuthTokensCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetAuthToken</td>
 *      <td><p> Gets a token based auth enabled instance's auth token for a given user.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAuthToken(GetAuthTokenRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAuthToken(AuthTokenName name)
 *           <li><p> getAuthToken(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAuthTokenCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> AddTokenAuthUser</td>
 *      <td><p> Adds a token auth user for a token based auth enabled instance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> addTokenAuthUserAsync(AddTokenAuthUserRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> addTokenAuthUserAsync(InstanceName instance, String tokenAuthUser)
 *           <li><p> addTokenAuthUserAsync(String instance, String tokenAuthUser)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> addTokenAuthUserOperationCallable()
 *           <li><p> addTokenAuthUserCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteTokenAuthUser</td>
 *      <td><p> Deletes a token auth user for a token based auth enabled instance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteTokenAuthUserAsync(DeleteTokenAuthUserRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteTokenAuthUserAsync(TokenAuthUserName name)
 *           <li><p> deleteTokenAuthUserAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteTokenAuthUserOperationCallable()
 *           <li><p> deleteTokenAuthUserCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> AddAuthToken</td>
 *      <td><p> Adds a token for a user of a token based auth enabled instance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> addAuthTokenAsync(AddAuthTokenRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> addAuthTokenAsync(TokenAuthUserName tokenAuthUser, AuthToken authToken)
 *           <li><p> addAuthTokenAsync(String tokenAuthUser, AuthToken authToken)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> addAuthTokenOperationCallable()
 *           <li><p> addAuthTokenCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteAuthToken</td>
 *      <td><p> Deletes a token for a user of a token based auth enabled instance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteAuthTokenAsync(DeleteAuthTokenRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteAuthTokenAsync(AuthTokenName name)
 *           <li><p> deleteAuthTokenAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteAuthTokenOperationCallable()
 *           <li><p> deleteAuthTokenCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLocations</td>
 *      <td><p> Lists information about the supported locations for this service.
 * <p> This method lists locations based on the resource scope provided inthe [ListLocationsRequest.name][google.cloud.location.ListLocationsRequest.name] field: &#42;&#42;&#42;Global locations&#42;&#42;: If `name` is empty, the method lists thepublic locations available to all projects. &#42; &#42;&#42;Project-specificlocations&#42;&#42;: If `name` follows the format`projects/{project}`, the method lists locations visible to thatspecific project. This includes public, private, or otherproject-specific locations enabled for the project.
 * <p> For gRPC and client library implementations, the resource name ispassed as the `name` field. For direct service calls, the resourcename isincorporated into the request path based on the specific serviceimplementation and version.</td>
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
 * <p>This class can be customized by passing in a custom instance of MemorystoreSettings to
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
 * MemorystoreSettings memorystoreSettings =
 *     MemorystoreSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * MemorystoreClient memorystoreClient = MemorystoreClient.create(memorystoreSettings);
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
 * MemorystoreSettings memorystoreSettings =
 *     MemorystoreSettings.newBuilder().setEndpoint(myEndpoint).build();
 * MemorystoreClient memorystoreClient = MemorystoreClient.create(memorystoreSettings);
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
 * MemorystoreSettings memorystoreSettings = MemorystoreSettings.newHttpJsonBuilder().build();
 * MemorystoreClient memorystoreClient = MemorystoreClient.create(memorystoreSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@BetaApi
@Generated("by gapic-generator-java")
public class MemorystoreClient implements BackgroundResource {
  private final @Nullable MemorystoreSettings settings;
  private final MemorystoreStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of MemorystoreClient with default settings. */
  public static final MemorystoreClient create() throws IOException {
    return create(MemorystoreSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of MemorystoreClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final MemorystoreClient create(MemorystoreSettings settings) throws IOException {
    return new MemorystoreClient(settings);
  }

  /**
   * Constructs an instance of MemorystoreClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(MemorystoreSettings).
   */
  public static final MemorystoreClient create(MemorystoreStub stub) {
    return new MemorystoreClient(stub);
  }

  /**
   * Constructs an instance of MemorystoreClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected MemorystoreClient(MemorystoreSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((MemorystoreStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected MemorystoreClient(MemorystoreStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final @Nullable MemorystoreSettings getSettings() {
    return settings;
  }

  public MemorystoreStub getStub() {
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
   * Lists Instances in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Instance element : memorystoreClient.listInstances(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent to list instances from. Format:
   *     projects/{project}/locations/{location}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInstancesPagedResponse listInstances(@Nullable LocationName parent) {
    ListInstancesRequest request =
        ListInstancesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listInstances(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Instances in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Instance element : memorystoreClient.listInstances(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent to list instances from. Format:
   *     projects/{project}/locations/{location}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInstancesPagedResponse listInstances(String parent) {
    ListInstancesRequest request = ListInstancesRequest.newBuilder().setParent(parent).build();
    return listInstances(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Instances in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   ListInstancesRequest request =
   *       ListInstancesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Instance element : memorystoreClient.listInstances(request).iterateAll()) {
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
   * Lists Instances in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   ListInstancesRequest request =
   *       ListInstancesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Instance> future =
   *       memorystoreClient.listInstancesPagedCallable().futureCall(request);
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
   * Lists Instances in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   ListInstancesRequest request =
   *       ListInstancesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListInstancesResponse response = memorystoreClient.listInstancesCallable().call(request);
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
   * Gets details of a single Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   Instance response = memorystoreClient.getInstance(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the instance to retrieve. Format:
   *     projects/{project}/locations/{location}/instances/{instance}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Instance getInstance(@Nullable InstanceName name) {
    GetInstanceRequest request =
        GetInstanceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   String name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   Instance response = memorystoreClient.getInstance(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the instance to retrieve. Format:
   *     projects/{project}/locations/{location}/instances/{instance}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Instance getInstance(String name) {
    GetInstanceRequest request = GetInstanceRequest.newBuilder().setName(name).build();
    return getInstance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   GetInstanceRequest request =
   *       GetInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   Instance response = memorystoreClient.getInstance(request);
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
   * Gets details of a single Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   GetInstanceRequest request =
   *       GetInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   ApiFuture<Instance> future = memorystoreClient.getInstanceCallable().futureCall(request);
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
   * Creates a new Instance in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Instance instance = Instance.newBuilder().build();
   *   String instanceId = "instanceId902024336";
   *   Instance response = memorystoreClient.createInstanceAsync(parent, instance, instanceId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this instance will be created. Format:
   *     projects/{project}/locations/{location}
   * @param instance Required. The instance to create.
   * @param instanceId Required. The ID to use for the instance, which will become the final
   *     component of the instance's resource name.
   *     <p>This value is subject to the following restrictions:
   *     <ul>
   *       <li>Must be 4-63 characters in length
   *       <li>Must begin with a letter or digit
   *       <li>Must contain only lowercase letters, digits, and hyphens
   *       <li>Must not end with a hyphen
   *       <li>Must be unique within a location
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> createInstanceAsync(
      @Nullable LocationName parent, Instance instance, String instanceId) {
    CreateInstanceRequest request =
        CreateInstanceRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setInstance(instance)
            .setInstanceId(instanceId)
            .build();
    return createInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Instance in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Instance instance = Instance.newBuilder().build();
   *   String instanceId = "instanceId902024336";
   *   Instance response = memorystoreClient.createInstanceAsync(parent, instance, instanceId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this instance will be created. Format:
   *     projects/{project}/locations/{location}
   * @param instance Required. The instance to create.
   * @param instanceId Required. The ID to use for the instance, which will become the final
   *     component of the instance's resource name.
   *     <p>This value is subject to the following restrictions:
   *     <ul>
   *       <li>Must be 4-63 characters in length
   *       <li>Must begin with a letter or digit
   *       <li>Must contain only lowercase letters, digits, and hyphens
   *       <li>Must not end with a hyphen
   *       <li>Must be unique within a location
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> createInstanceAsync(
      String parent, Instance instance, String instanceId) {
    CreateInstanceRequest request =
        CreateInstanceRequest.newBuilder()
            .setParent(parent)
            .setInstance(instance)
            .setInstanceId(instanceId)
            .build();
    return createInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Instance in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   CreateInstanceRequest request =
   *       CreateInstanceRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setInstanceId("instanceId902024336")
   *           .setInstance(Instance.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Instance response = memorystoreClient.createInstanceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> createInstanceAsync(
      CreateInstanceRequest request) {
    return createInstanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Instance in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   CreateInstanceRequest request =
   *       CreateInstanceRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setInstanceId("instanceId902024336")
   *           .setInstance(Instance.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Instance, OperationMetadata> future =
   *       memorystoreClient.createInstanceOperationCallable().futureCall(request);
   *   // Do something.
   *   Instance response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateInstanceRequest, Instance, OperationMetadata>
      createInstanceOperationCallable() {
    return stub.createInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Instance in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   CreateInstanceRequest request =
   *       CreateInstanceRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setInstanceId("instanceId902024336")
   *           .setInstance(Instance.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = memorystoreClient.createInstanceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateInstanceRequest, Operation> createInstanceCallable() {
    return stub.createInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   Instance instance = Instance.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Instance response = memorystoreClient.updateInstanceAsync(instance, updateMask).get();
   * }
   * }</pre>
   *
   * @param instance Required. The instance to update.
   * @param updateMask Optional. The list of fields to be updated on the instance. At least one
   *     field must be specified.
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
   * Updates the parameters of a single Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   UpdateInstanceRequest request =
   *       UpdateInstanceRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setInstance(Instance.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Instance response = memorystoreClient.updateInstanceAsync(request).get();
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
   * Updates the parameters of a single Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   UpdateInstanceRequest request =
   *       UpdateInstanceRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setInstance(Instance.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Instance, OperationMetadata> future =
   *       memorystoreClient.updateInstanceOperationCallable().futureCall(request);
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
   * Updates the parameters of a single Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   UpdateInstanceRequest request =
   *       UpdateInstanceRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setInstance(Instance.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = memorystoreClient.updateInstanceCallable().futureCall(request);
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
   * Deletes a single Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   memorystoreClient.deleteInstanceAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the instance to delete. Format:
   *     projects/{project}/locations/{location}/instances/{instance}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteInstanceAsync(
      @Nullable InstanceName name) {
    DeleteInstanceRequest request =
        DeleteInstanceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   String name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   memorystoreClient.deleteInstanceAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the instance to delete. Format:
   *     projects/{project}/locations/{location}/instances/{instance}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteInstanceAsync(String name) {
    DeleteInstanceRequest request = DeleteInstanceRequest.newBuilder().setName(name).build();
    return deleteInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   DeleteInstanceRequest request =
   *       DeleteInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   memorystoreClient.deleteInstanceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteInstanceAsync(
      DeleteInstanceRequest request) {
    return deleteInstanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   DeleteInstanceRequest request =
   *       DeleteInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       memorystoreClient.deleteInstanceOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteInstanceRequest, Empty, OperationMetadata>
      deleteInstanceOperationCallable() {
    return stub.deleteInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   DeleteInstanceRequest request =
   *       DeleteInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = memorystoreClient.deleteInstanceCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteInstanceRequest, Operation> deleteInstanceCallable() {
    return stub.deleteInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about the certificate authority for an Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   CertificateAuthority response = memorystoreClient.getCertificateAuthority(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the certificate authority. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/certificateAuthority
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CertificateAuthority getCertificateAuthority(@Nullable InstanceName name) {
    GetCertificateAuthorityRequest request =
        GetCertificateAuthorityRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getCertificateAuthority(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about the certificate authority for an Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   String name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   CertificateAuthority response = memorystoreClient.getCertificateAuthority(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the certificate authority. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/certificateAuthority
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CertificateAuthority getCertificateAuthority(String name) {
    GetCertificateAuthorityRequest request =
        GetCertificateAuthorityRequest.newBuilder().setName(name).build();
    return getCertificateAuthority(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about the certificate authority for an Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   GetCertificateAuthorityRequest request =
   *       GetCertificateAuthorityRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   CertificateAuthority response = memorystoreClient.getCertificateAuthority(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CertificateAuthority getCertificateAuthority(
      GetCertificateAuthorityRequest request) {
    return getCertificateAuthorityCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about the certificate authority for an Instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   GetCertificateAuthorityRequest request =
   *       GetCertificateAuthorityRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   ApiFuture<CertificateAuthority> future =
   *       memorystoreClient.getCertificateAuthorityCallable().futureCall(request);
   *   // Do something.
   *   CertificateAuthority response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetCertificateAuthorityRequest, CertificateAuthority>
      getCertificateAuthorityCallable() {
    return stub.getCertificateAuthorityCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of shared regional certificate authority information for Memorystore instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   SharedRegionalCertificateAuthorityName name =
   *       SharedRegionalCertificateAuthorityName.of("[PROJECT]", "[LOCATION]");
   *   SharedRegionalCertificateAuthority response =
   *       memorystoreClient.getSharedRegionalCertificateAuthority(name);
   * }
   * }</pre>
   *
   * @param name Required. Regional certificate authority resource name using the form:
   *     `projects/{project}/locations/{location}/sharedRegionalCertificateAuthority` where
   *     `location_id` refers to a Google Cloud region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SharedRegionalCertificateAuthority getSharedRegionalCertificateAuthority(
      @Nullable SharedRegionalCertificateAuthorityName name) {
    GetSharedRegionalCertificateAuthorityRequest request =
        GetSharedRegionalCertificateAuthorityRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getSharedRegionalCertificateAuthority(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of shared regional certificate authority information for Memorystore instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   String name = SharedRegionalCertificateAuthorityName.of("[PROJECT]", "[LOCATION]").toString();
   *   SharedRegionalCertificateAuthority response =
   *       memorystoreClient.getSharedRegionalCertificateAuthority(name);
   * }
   * }</pre>
   *
   * @param name Required. Regional certificate authority resource name using the form:
   *     `projects/{project}/locations/{location}/sharedRegionalCertificateAuthority` where
   *     `location_id` refers to a Google Cloud region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SharedRegionalCertificateAuthority getSharedRegionalCertificateAuthority(
      String name) {
    GetSharedRegionalCertificateAuthorityRequest request =
        GetSharedRegionalCertificateAuthorityRequest.newBuilder().setName(name).build();
    return getSharedRegionalCertificateAuthority(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of shared regional certificate authority information for Memorystore instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   GetSharedRegionalCertificateAuthorityRequest request =
   *       GetSharedRegionalCertificateAuthorityRequest.newBuilder()
   *           .setName(
   *               SharedRegionalCertificateAuthorityName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   SharedRegionalCertificateAuthority response =
   *       memorystoreClient.getSharedRegionalCertificateAuthority(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SharedRegionalCertificateAuthority getSharedRegionalCertificateAuthority(
      GetSharedRegionalCertificateAuthorityRequest request) {
    return getSharedRegionalCertificateAuthorityCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of shared regional certificate authority information for Memorystore instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   GetSharedRegionalCertificateAuthorityRequest request =
   *       GetSharedRegionalCertificateAuthorityRequest.newBuilder()
   *           .setName(
   *               SharedRegionalCertificateAuthorityName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   ApiFuture<SharedRegionalCertificateAuthority> future =
   *       memorystoreClient.getSharedRegionalCertificateAuthorityCallable().futureCall(request);
   *   // Do something.
   *   SharedRegionalCertificateAuthority response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          GetSharedRegionalCertificateAuthorityRequest, SharedRegionalCertificateAuthority>
      getSharedRegionalCertificateAuthorityCallable() {
    return stub.getSharedRegionalCertificateAuthorityCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reschedules upcoming maintenance event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   RescheduleMaintenanceRequest.RescheduleType rescheduleType =
   *       RescheduleMaintenanceRequest.RescheduleType.forNumber(0);
   *   Timestamp scheduleTime = Timestamp.newBuilder().build();
   *   Instance response =
   *       memorystoreClient.rescheduleMaintenanceAsync(name, rescheduleType, scheduleTime).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the instance to reschedule maintenance for:
   *     `projects/{project}/locations/{location_id}/instances/{instance}`
   * @param rescheduleType Required. If reschedule type is SPECIFIC_TIME, schedule_time must be set.
   * @param scheduleTime Optional. Timestamp when the maintenance shall be rescheduled to if
   *     reschedule_type=SPECIFIC_TIME, in RFC 3339 format. Example: `2012-11-15T16:19:00.094Z`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> rescheduleMaintenanceAsync(
      @Nullable InstanceName name,
      RescheduleMaintenanceRequest.RescheduleType rescheduleType,
      Timestamp scheduleTime) {
    RescheduleMaintenanceRequest request =
        RescheduleMaintenanceRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setRescheduleType(rescheduleType)
            .setScheduleTime(scheduleTime)
            .build();
    return rescheduleMaintenanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reschedules upcoming maintenance event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   String name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   RescheduleMaintenanceRequest.RescheduleType rescheduleType =
   *       RescheduleMaintenanceRequest.RescheduleType.forNumber(0);
   *   Timestamp scheduleTime = Timestamp.newBuilder().build();
   *   Instance response =
   *       memorystoreClient.rescheduleMaintenanceAsync(name, rescheduleType, scheduleTime).get();
   * }
   * }</pre>
   *
   * @param name Required. Name of the instance to reschedule maintenance for:
   *     `projects/{project}/locations/{location_id}/instances/{instance}`
   * @param rescheduleType Required. If reschedule type is SPECIFIC_TIME, schedule_time must be set.
   * @param scheduleTime Optional. Timestamp when the maintenance shall be rescheduled to if
   *     reschedule_type=SPECIFIC_TIME, in RFC 3339 format. Example: `2012-11-15T16:19:00.094Z`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> rescheduleMaintenanceAsync(
      String name,
      RescheduleMaintenanceRequest.RescheduleType rescheduleType,
      Timestamp scheduleTime) {
    RescheduleMaintenanceRequest request =
        RescheduleMaintenanceRequest.newBuilder()
            .setName(name)
            .setRescheduleType(rescheduleType)
            .setScheduleTime(scheduleTime)
            .build();
    return rescheduleMaintenanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reschedules upcoming maintenance event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   RescheduleMaintenanceRequest request =
   *       RescheduleMaintenanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setScheduleTime(Timestamp.newBuilder().build())
   *           .build();
   *   Instance response = memorystoreClient.rescheduleMaintenanceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> rescheduleMaintenanceAsync(
      RescheduleMaintenanceRequest request) {
    return rescheduleMaintenanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reschedules upcoming maintenance event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   RescheduleMaintenanceRequest request =
   *       RescheduleMaintenanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setScheduleTime(Timestamp.newBuilder().build())
   *           .build();
   *   OperationFuture<Instance, OperationMetadata> future =
   *       memorystoreClient.rescheduleMaintenanceOperationCallable().futureCall(request);
   *   // Do something.
   *   Instance response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<RescheduleMaintenanceRequest, Instance, OperationMetadata>
      rescheduleMaintenanceOperationCallable() {
    return stub.rescheduleMaintenanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reschedules upcoming maintenance event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   RescheduleMaintenanceRequest request =
   *       RescheduleMaintenanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setScheduleTime(Timestamp.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       memorystoreClient.rescheduleMaintenanceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RescheduleMaintenanceRequest, Operation>
      rescheduleMaintenanceCallable() {
    return stub.rescheduleMaintenanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all backup collections owned by a consumer project in either the specified location
   * (region) or all locations.
   *
   * <p>If `location_id` is specified as `-` (wildcard), then all regions available to the project
   * are queried, and the results are aggregated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (BackupCollection element :
   *       memorystoreClient.listBackupCollections(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the backupCollection location using the form:
   *     `projects/{project_id}/locations/{location_id}` where `location_id` refers to a Google
   *     Cloud region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupCollectionsPagedResponse listBackupCollections(
      @Nullable LocationName parent) {
    ListBackupCollectionsRequest request =
        ListBackupCollectionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listBackupCollections(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all backup collections owned by a consumer project in either the specified location
   * (region) or all locations.
   *
   * <p>If `location_id` is specified as `-` (wildcard), then all regions available to the project
   * are queried, and the results are aggregated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (BackupCollection element :
   *       memorystoreClient.listBackupCollections(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the backupCollection location using the form:
   *     `projects/{project_id}/locations/{location_id}` where `location_id` refers to a Google
   *     Cloud region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupCollectionsPagedResponse listBackupCollections(String parent) {
    ListBackupCollectionsRequest request =
        ListBackupCollectionsRequest.newBuilder().setParent(parent).build();
    return listBackupCollections(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all backup collections owned by a consumer project in either the specified location
   * (region) or all locations.
   *
   * <p>If `location_id` is specified as `-` (wildcard), then all regions available to the project
   * are queried, and the results are aggregated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   ListBackupCollectionsRequest request =
   *       ListBackupCollectionsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (BackupCollection element :
   *       memorystoreClient.listBackupCollections(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupCollectionsPagedResponse listBackupCollections(
      ListBackupCollectionsRequest request) {
    return listBackupCollectionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all backup collections owned by a consumer project in either the specified location
   * (region) or all locations.
   *
   * <p>If `location_id` is specified as `-` (wildcard), then all regions available to the project
   * are queried, and the results are aggregated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   ListBackupCollectionsRequest request =
   *       ListBackupCollectionsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<BackupCollection> future =
   *       memorystoreClient.listBackupCollectionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (BackupCollection element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListBackupCollectionsRequest, ListBackupCollectionsPagedResponse>
      listBackupCollectionsPagedCallable() {
    return stub.listBackupCollectionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all backup collections owned by a consumer project in either the specified location
   * (region) or all locations.
   *
   * <p>If `location_id` is specified as `-` (wildcard), then all regions available to the project
   * are queried, and the results are aggregated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   ListBackupCollectionsRequest request =
   *       ListBackupCollectionsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListBackupCollectionsResponse response =
   *         memorystoreClient.listBackupCollectionsCallable().call(request);
   *     for (BackupCollection element : response.getBackupCollectionsList()) {
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
  public final UnaryCallable<ListBackupCollectionsRequest, ListBackupCollectionsResponse>
      listBackupCollectionsCallable() {
    return stub.listBackupCollectionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a backup collection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   BackupCollectionName name =
   *       BackupCollectionName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]");
   *   BackupCollection response = memorystoreClient.getBackupCollection(name);
   * }
   * }</pre>
   *
   * @param name Required. Instance backupCollection resource name using the form:
   *     `projects/{project_id}/locations/{location_id}/backupCollections/{backup_collection_id}`
   *     where `location_id` refers to a Google Cloud region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BackupCollection getBackupCollection(@Nullable BackupCollectionName name) {
    GetBackupCollectionRequest request =
        GetBackupCollectionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getBackupCollection(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a backup collection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   String name =
   *       BackupCollectionName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]").toString();
   *   BackupCollection response = memorystoreClient.getBackupCollection(name);
   * }
   * }</pre>
   *
   * @param name Required. Instance backupCollection resource name using the form:
   *     `projects/{project_id}/locations/{location_id}/backupCollections/{backup_collection_id}`
   *     where `location_id` refers to a Google Cloud region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BackupCollection getBackupCollection(String name) {
    GetBackupCollectionRequest request =
        GetBackupCollectionRequest.newBuilder().setName(name).build();
    return getBackupCollection(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a backup collection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   GetBackupCollectionRequest request =
   *       GetBackupCollectionRequest.newBuilder()
   *           .setName(
   *               BackupCollectionName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]")
   *                   .toString())
   *           .build();
   *   BackupCollection response = memorystoreClient.getBackupCollection(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BackupCollection getBackupCollection(GetBackupCollectionRequest request) {
    return getBackupCollectionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a backup collection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   GetBackupCollectionRequest request =
   *       GetBackupCollectionRequest.newBuilder()
   *           .setName(
   *               BackupCollectionName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<BackupCollection> future =
   *       memorystoreClient.getBackupCollectionCallable().futureCall(request);
   *   // Do something.
   *   BackupCollection response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetBackupCollectionRequest, BackupCollection>
      getBackupCollectionCallable() {
    return stub.getBackupCollectionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all backups owned by a backup collection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   BackupCollectionName parent =
   *       BackupCollectionName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]");
   *   for (Backup element : memorystoreClient.listBackups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the backupCollection using the form:
   *     `projects/{project_id}/locations/{location_id}/backupCollections/{backup_collection_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupsPagedResponse listBackups(@Nullable BackupCollectionName parent) {
    ListBackupsRequest request =
        ListBackupsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listBackups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all backups owned by a backup collection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   String parent =
   *       BackupCollectionName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]").toString();
   *   for (Backup element : memorystoreClient.listBackups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the backupCollection using the form:
   *     `projects/{project_id}/locations/{location_id}/backupCollections/{backup_collection_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupsPagedResponse listBackups(String parent) {
    ListBackupsRequest request = ListBackupsRequest.newBuilder().setParent(parent).build();
    return listBackups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all backups owned by a backup collection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   ListBackupsRequest request =
   *       ListBackupsRequest.newBuilder()
   *           .setParent(
   *               BackupCollectionName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Backup element : memorystoreClient.listBackups(request).iterateAll()) {
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
   * Lists all backups owned by a backup collection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   ListBackupsRequest request =
   *       ListBackupsRequest.newBuilder()
   *           .setParent(
   *               BackupCollectionName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Backup> future = memorystoreClient.listBackupsPagedCallable().futureCall(request);
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
   * Lists all backups owned by a backup collection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   ListBackupsRequest request =
   *       ListBackupsRequest.newBuilder()
   *           .setParent(
   *               BackupCollectionName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListBackupsResponse response = memorystoreClient.listBackupsCallable().call(request);
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
   * Gets the details of a specific backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   BackupName name = BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]", "[BACKUP]");
   *   Backup response = memorystoreClient.getBackup(name);
   * }
   * }</pre>
   *
   * @param name Required. Instance backup resource name using the form:
   *     `projects/{project_id}/locations/{location_id}/backupCollections/{backup_collection_id}/backups/{backup_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Backup getBackup(@Nullable BackupName name) {
    GetBackupRequest request =
        GetBackupRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getBackup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a specific backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   String name =
   *       BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]", "[BACKUP]").toString();
   *   Backup response = memorystoreClient.getBackup(name);
   * }
   * }</pre>
   *
   * @param name Required. Instance backup resource name using the form:
   *     `projects/{project_id}/locations/{location_id}/backupCollections/{backup_collection_id}/backups/{backup_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Backup getBackup(String name) {
    GetBackupRequest request = GetBackupRequest.newBuilder().setName(name).build();
    return getBackup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a specific backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   GetBackupRequest request =
   *       GetBackupRequest.newBuilder()
   *           .setName(
   *               BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]", "[BACKUP]")
   *                   .toString())
   *           .build();
   *   Backup response = memorystoreClient.getBackup(request);
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
   * Gets the details of a specific backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   GetBackupRequest request =
   *       GetBackupRequest.newBuilder()
   *           .setName(
   *               BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]", "[BACKUP]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Backup> future = memorystoreClient.getBackupCallable().futureCall(request);
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
   * Deletes a specific backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   BackupName name = BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]", "[BACKUP]");
   *   memorystoreClient.deleteBackupAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Instance backup resource name using the form:
   *     `projects/{project_id}/locations/{location_id}/backupCollections/{backup_collection_id}/backups/{backup_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteBackupAsync(
      @Nullable BackupName name) {
    DeleteBackupRequest request =
        DeleteBackupRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteBackupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   String name =
   *       BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]", "[BACKUP]").toString();
   *   memorystoreClient.deleteBackupAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Instance backup resource name using the form:
   *     `projects/{project_id}/locations/{location_id}/backupCollections/{backup_collection_id}/backups/{backup_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteBackupAsync(String name) {
    DeleteBackupRequest request = DeleteBackupRequest.newBuilder().setName(name).build();
    return deleteBackupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   DeleteBackupRequest request =
   *       DeleteBackupRequest.newBuilder()
   *           .setName(
   *               BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]", "[BACKUP]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   memorystoreClient.deleteBackupAsync(request).get();
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
   * Deletes a specific backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   DeleteBackupRequest request =
   *       DeleteBackupRequest.newBuilder()
   *           .setName(
   *               BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]", "[BACKUP]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       memorystoreClient.deleteBackupOperationCallable().futureCall(request);
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
   * Deletes a specific backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   DeleteBackupRequest request =
   *       DeleteBackupRequest.newBuilder()
   *           .setName(
   *               BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]", "[BACKUP]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = memorystoreClient.deleteBackupCallable().futureCall(request);
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
   * Exports a specific backup to a customer target Cloud Storage URI.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   ExportBackupRequest request =
   *       ExportBackupRequest.newBuilder()
   *           .setName(
   *               BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]", "[BACKUP]")
   *                   .toString())
   *           .build();
   *   Backup response = memorystoreClient.exportBackupAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Backup, OperationMetadata> exportBackupAsync(
      ExportBackupRequest request) {
    return exportBackupOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports a specific backup to a customer target Cloud Storage URI.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   ExportBackupRequest request =
   *       ExportBackupRequest.newBuilder()
   *           .setName(
   *               BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]", "[BACKUP]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Backup, OperationMetadata> future =
   *       memorystoreClient.exportBackupOperationCallable().futureCall(request);
   *   // Do something.
   *   Backup response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ExportBackupRequest, Backup, OperationMetadata>
      exportBackupOperationCallable() {
    return stub.exportBackupOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports a specific backup to a customer target Cloud Storage URI.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   ExportBackupRequest request =
   *       ExportBackupRequest.newBuilder()
   *           .setName(
   *               BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP_COLLECTION]", "[BACKUP]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future = memorystoreClient.exportBackupCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ExportBackupRequest, Operation> exportBackupCallable() {
    return stub.exportBackupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Backup Instance. If this is the first time a backup is being created, a backup collection will
   * be created at the backend, and this backup belongs to this collection. Both collection and
   * backup will have a resource name. Backup will be executed for each shard. A replica (primary if
   * nonHA) will be selected to perform the execution. Backup call will be rejected if there is an
   * ongoing backup or update operation. Be aware that during preview, if the instance's internal
   * software version is too old, critical update will be performed before actual backup. Once the
   * internal software version is updated to the minimum version required by the backup feature,
   * subsequent backups will not require critical update. After preview, there will be no critical
   * update needed for backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   Instance response = memorystoreClient.backupInstanceAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Instance resource name using the form:
   *     `projects/{project_id}/locations/{location_id}/instances/{instance_id}` where `location_id`
   *     refers to a Google Cloud region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> backupInstanceAsync(
      @Nullable InstanceName name) {
    BackupInstanceRequest request =
        BackupInstanceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return backupInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Backup Instance. If this is the first time a backup is being created, a backup collection will
   * be created at the backend, and this backup belongs to this collection. Both collection and
   * backup will have a resource name. Backup will be executed for each shard. A replica (primary if
   * nonHA) will be selected to perform the execution. Backup call will be rejected if there is an
   * ongoing backup or update operation. Be aware that during preview, if the instance's internal
   * software version is too old, critical update will be performed before actual backup. Once the
   * internal software version is updated to the minimum version required by the backup feature,
   * subsequent backups will not require critical update. After preview, there will be no critical
   * update needed for backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   String name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   Instance response = memorystoreClient.backupInstanceAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Instance resource name using the form:
   *     `projects/{project_id}/locations/{location_id}/instances/{instance_id}` where `location_id`
   *     refers to a Google Cloud region.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> backupInstanceAsync(String name) {
    BackupInstanceRequest request = BackupInstanceRequest.newBuilder().setName(name).build();
    return backupInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Backup Instance. If this is the first time a backup is being created, a backup collection will
   * be created at the backend, and this backup belongs to this collection. Both collection and
   * backup will have a resource name. Backup will be executed for each shard. A replica (primary if
   * nonHA) will be selected to perform the execution. Backup call will be rejected if there is an
   * ongoing backup or update operation. Be aware that during preview, if the instance's internal
   * software version is too old, critical update will be performed before actual backup. Once the
   * internal software version is updated to the minimum version required by the backup feature,
   * subsequent backups will not require critical update. After preview, there will be no critical
   * update needed for backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   BackupInstanceRequest request =
   *       BackupInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setTtl(Duration.newBuilder().build())
   *           .setBackupId("backupId2121930365")
   *           .build();
   *   Instance response = memorystoreClient.backupInstanceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> backupInstanceAsync(
      BackupInstanceRequest request) {
    return backupInstanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Backup Instance. If this is the first time a backup is being created, a backup collection will
   * be created at the backend, and this backup belongs to this collection. Both collection and
   * backup will have a resource name. Backup will be executed for each shard. A replica (primary if
   * nonHA) will be selected to perform the execution. Backup call will be rejected if there is an
   * ongoing backup or update operation. Be aware that during preview, if the instance's internal
   * software version is too old, critical update will be performed before actual backup. Once the
   * internal software version is updated to the minimum version required by the backup feature,
   * subsequent backups will not require critical update. After preview, there will be no critical
   * update needed for backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   BackupInstanceRequest request =
   *       BackupInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setTtl(Duration.newBuilder().build())
   *           .setBackupId("backupId2121930365")
   *           .build();
   *   OperationFuture<Instance, OperationMetadata> future =
   *       memorystoreClient.backupInstanceOperationCallable().futureCall(request);
   *   // Do something.
   *   Instance response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<BackupInstanceRequest, Instance, OperationMetadata>
      backupInstanceOperationCallable() {
    return stub.backupInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Backup Instance. If this is the first time a backup is being created, a backup collection will
   * be created at the backend, and this backup belongs to this collection. Both collection and
   * backup will have a resource name. Backup will be executed for each shard. A replica (primary if
   * nonHA) will be selected to perform the execution. Backup call will be rejected if there is an
   * ongoing backup or update operation. Be aware that during preview, if the instance's internal
   * software version is too old, critical update will be performed before actual backup. Once the
   * internal software version is updated to the minimum version required by the backup feature,
   * subsequent backups will not require critical update. After preview, there will be no critical
   * update needed for backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   BackupInstanceRequest request =
   *       BackupInstanceRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setTtl(Duration.newBuilder().build())
   *           .setBackupId("backupId2121930365")
   *           .build();
   *   ApiFuture<Operation> future = memorystoreClient.backupInstanceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BackupInstanceRequest, Operation> backupInstanceCallable() {
    return stub.backupInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates the migration of a source instance to the target Memorystore instance.
   *
   * <p>After the successful completion of this operation, the target instance will: 1. Set up
   * replication with the source instance and replicate any writes to the source instance. 2. Only
   * allow reads.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   StartMigrationRequest request =
   *       StartMigrationRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   Instance response = memorystoreClient.startMigrationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> startMigrationAsync(
      StartMigrationRequest request) {
    return startMigrationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates the migration of a source instance to the target Memorystore instance.
   *
   * <p>After the successful completion of this operation, the target instance will: 1. Set up
   * replication with the source instance and replicate any writes to the source instance. 2. Only
   * allow reads.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   StartMigrationRequest request =
   *       StartMigrationRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   OperationFuture<Instance, OperationMetadata> future =
   *       memorystoreClient.startMigrationOperationCallable().futureCall(request);
   *   // Do something.
   *   Instance response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<StartMigrationRequest, Instance, OperationMetadata>
      startMigrationOperationCallable() {
    return stub.startMigrationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates the migration of a source instance to the target Memorystore instance.
   *
   * <p>After the successful completion of this operation, the target instance will: 1. Set up
   * replication with the source instance and replicate any writes to the source instance. 2. Only
   * allow reads.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   StartMigrationRequest request =
   *       StartMigrationRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   ApiFuture<Operation> future = memorystoreClient.startMigrationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<StartMigrationRequest, Operation> startMigrationCallable() {
    return stub.startMigrationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Finalizes the migration process.
   *
   * <p>After the successful completion of this operation, the target instance will: 1. Stop
   * replicating from the source instance. 2. Allow both reads and writes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   InstanceName name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   boolean force = true;
   *   Instance response = memorystoreClient.finishMigrationAsync(name, force).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the instance to finalize migration on. Format:
   *     projects/{project}/locations/{location}/instances/{instance}
   * @param force Optional. By default, the `FinishMigration` operation ensures the target
   *     replication offset to catch up to the source offset as of the time of the call. Set this
   *     field to `true` to bypass this offset verification check.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> finishMigrationAsync(
      @Nullable InstanceName name, boolean force) {
    FinishMigrationRequest request =
        FinishMigrationRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setForce(force)
            .build();
    return finishMigrationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Finalizes the migration process.
   *
   * <p>After the successful completion of this operation, the target instance will: 1. Stop
   * replicating from the source instance. 2. Allow both reads and writes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   String name = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   boolean force = true;
   *   Instance response = memorystoreClient.finishMigrationAsync(name, force).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the instance to finalize migration on. Format:
   *     projects/{project}/locations/{location}/instances/{instance}
   * @param force Optional. By default, the `FinishMigration` operation ensures the target
   *     replication offset to catch up to the source offset as of the time of the call. Set this
   *     field to `true` to bypass this offset verification check.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> finishMigrationAsync(
      String name, boolean force) {
    FinishMigrationRequest request =
        FinishMigrationRequest.newBuilder().setName(name).setForce(force).build();
    return finishMigrationAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Finalizes the migration process.
   *
   * <p>After the successful completion of this operation, the target instance will: 1. Stop
   * replicating from the source instance. 2. Allow both reads and writes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   FinishMigrationRequest request =
   *       FinishMigrationRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setForce(true)
   *           .build();
   *   Instance response = memorystoreClient.finishMigrationAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> finishMigrationAsync(
      FinishMigrationRequest request) {
    return finishMigrationOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Finalizes the migration process.
   *
   * <p>After the successful completion of this operation, the target instance will: 1. Stop
   * replicating from the source instance. 2. Allow both reads and writes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   FinishMigrationRequest request =
   *       FinishMigrationRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setForce(true)
   *           .build();
   *   OperationFuture<Instance, OperationMetadata> future =
   *       memorystoreClient.finishMigrationOperationCallable().futureCall(request);
   *   // Do something.
   *   Instance response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<FinishMigrationRequest, Instance, OperationMetadata>
      finishMigrationOperationCallable() {
    return stub.finishMigrationOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Finalizes the migration process.
   *
   * <p>After the successful completion of this operation, the target instance will: 1. Stop
   * replicating from the source instance. 2. Allow both reads and writes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   FinishMigrationRequest request =
   *       FinishMigrationRequest.newBuilder()
   *           .setName(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Operation> future = memorystoreClient.finishMigrationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<FinishMigrationRequest, Operation> finishMigrationCallable() {
    return stub.finishMigrationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the token auth users for a token based auth enabled instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   for (TokenAuthUser element : memorystoreClient.listTokenAuthUsers(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent to list token auth users from. Format:
   *     projects/{project}/locations/{location}/instances/{instance}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTokenAuthUsersPagedResponse listTokenAuthUsers(@Nullable InstanceName parent) {
    ListTokenAuthUsersRequest request =
        ListTokenAuthUsersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listTokenAuthUsers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the token auth users for a token based auth enabled instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   String parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   for (TokenAuthUser element : memorystoreClient.listTokenAuthUsers(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent to list token auth users from. Format:
   *     projects/{project}/locations/{location}/instances/{instance}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTokenAuthUsersPagedResponse listTokenAuthUsers(String parent) {
    ListTokenAuthUsersRequest request =
        ListTokenAuthUsersRequest.newBuilder().setParent(parent).build();
    return listTokenAuthUsers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the token auth users for a token based auth enabled instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   ListTokenAuthUsersRequest request =
   *       ListTokenAuthUsersRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (TokenAuthUser element : memorystoreClient.listTokenAuthUsers(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTokenAuthUsersPagedResponse listTokenAuthUsers(
      ListTokenAuthUsersRequest request) {
    return listTokenAuthUsersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the token auth users for a token based auth enabled instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   ListTokenAuthUsersRequest request =
   *       ListTokenAuthUsersRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<TokenAuthUser> future =
   *       memorystoreClient.listTokenAuthUsersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (TokenAuthUser element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListTokenAuthUsersRequest, ListTokenAuthUsersPagedResponse>
      listTokenAuthUsersPagedCallable() {
    return stub.listTokenAuthUsersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the token auth users for a token based auth enabled instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   ListTokenAuthUsersRequest request =
   *       ListTokenAuthUsersRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListTokenAuthUsersResponse response =
   *         memorystoreClient.listTokenAuthUsersCallable().call(request);
   *     for (TokenAuthUser element : response.getTokenAuthUsersList()) {
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
  public final UnaryCallable<ListTokenAuthUsersRequest, ListTokenAuthUsersResponse>
      listTokenAuthUsersCallable() {
    return stub.listTokenAuthUsersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a specific token auth user for a token based auth enabled instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   TokenAuthUserName name =
   *       TokenAuthUserName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[TOKEN_AUTH_USER]");
   *   TokenAuthUser response = memorystoreClient.getTokenAuthUser(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of token auth user for a basic auth enabled instance. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/tokenAuthUsers/{token_auth_user}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TokenAuthUser getTokenAuthUser(@Nullable TokenAuthUserName name) {
    GetTokenAuthUserRequest request =
        GetTokenAuthUserRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getTokenAuthUser(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a specific token auth user for a token based auth enabled instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   String name =
   *       TokenAuthUserName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[TOKEN_AUTH_USER]")
   *           .toString();
   *   TokenAuthUser response = memorystoreClient.getTokenAuthUser(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of token auth user for a basic auth enabled instance. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/tokenAuthUsers/{token_auth_user}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TokenAuthUser getTokenAuthUser(String name) {
    GetTokenAuthUserRequest request = GetTokenAuthUserRequest.newBuilder().setName(name).build();
    return getTokenAuthUser(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a specific token auth user for a token based auth enabled instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   GetTokenAuthUserRequest request =
   *       GetTokenAuthUserRequest.newBuilder()
   *           .setName(
   *               TokenAuthUserName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[TOKEN_AUTH_USER]")
   *                   .toString())
   *           .build();
   *   TokenAuthUser response = memorystoreClient.getTokenAuthUser(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TokenAuthUser getTokenAuthUser(GetTokenAuthUserRequest request) {
    return getTokenAuthUserCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a specific token auth user for a token based auth enabled instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   GetTokenAuthUserRequest request =
   *       GetTokenAuthUserRequest.newBuilder()
   *           .setName(
   *               TokenAuthUserName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[TOKEN_AUTH_USER]")
   *                   .toString())
   *           .build();
   *   ApiFuture<TokenAuthUser> future =
   *       memorystoreClient.getTokenAuthUserCallable().futureCall(request);
   *   // Do something.
   *   TokenAuthUser response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetTokenAuthUserRequest, TokenAuthUser> getTokenAuthUserCallable() {
    return stub.getTokenAuthUserCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the auth tokens for a specific token auth user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   TokenAuthUserName parent =
   *       TokenAuthUserName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[TOKEN_AUTH_USER]");
   *   for (AuthToken element : memorystoreClient.listAuthTokens(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent to list auth tokens from. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/tokenAuthUsers/{token_auth_user}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAuthTokensPagedResponse listAuthTokens(@Nullable TokenAuthUserName parent) {
    ListAuthTokensRequest request =
        ListAuthTokensRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAuthTokens(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the auth tokens for a specific token auth user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   String parent =
   *       TokenAuthUserName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[TOKEN_AUTH_USER]")
   *           .toString();
   *   for (AuthToken element : memorystoreClient.listAuthTokens(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent to list auth tokens from. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/tokenAuthUsers/{token_auth_user}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAuthTokensPagedResponse listAuthTokens(String parent) {
    ListAuthTokensRequest request = ListAuthTokensRequest.newBuilder().setParent(parent).build();
    return listAuthTokens(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the auth tokens for a specific token auth user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   ListAuthTokensRequest request =
   *       ListAuthTokensRequest.newBuilder()
   *           .setParent(
   *               TokenAuthUserName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[TOKEN_AUTH_USER]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (AuthToken element : memorystoreClient.listAuthTokens(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAuthTokensPagedResponse listAuthTokens(ListAuthTokensRequest request) {
    return listAuthTokensPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the auth tokens for a specific token auth user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   ListAuthTokensRequest request =
   *       ListAuthTokensRequest.newBuilder()
   *           .setParent(
   *               TokenAuthUserName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[TOKEN_AUTH_USER]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<AuthToken> future =
   *       memorystoreClient.listAuthTokensPagedCallable().futureCall(request);
   *   // Do something.
   *   for (AuthToken element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAuthTokensRequest, ListAuthTokensPagedResponse>
      listAuthTokensPagedCallable() {
    return stub.listAuthTokensPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the auth tokens for a specific token auth user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   ListAuthTokensRequest request =
   *       ListAuthTokensRequest.newBuilder()
   *           .setParent(
   *               TokenAuthUserName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[TOKEN_AUTH_USER]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListAuthTokensResponse response = memorystoreClient.listAuthTokensCallable().call(request);
   *     for (AuthToken element : response.getAuthTokensList()) {
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
  public final UnaryCallable<ListAuthTokensRequest, ListAuthTokensResponse>
      listAuthTokensCallable() {
    return stub.listAuthTokensCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a token based auth enabled instance's auth token for a given user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   AuthTokenName name =
   *       AuthTokenName.of(
   *           "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[TOKEN_AUTH_USER]", "[AUTH_TOKEN]");
   *   AuthToken response = memorystoreClient.getAuthToken(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of token auth user for a token auth enabled instance. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/tokenAuthUsers/{token_auth_user}/authTokens/{auth_token}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AuthToken getAuthToken(@Nullable AuthTokenName name) {
    GetAuthTokenRequest request =
        GetAuthTokenRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getAuthToken(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a token based auth enabled instance's auth token for a given user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   String name =
   *       AuthTokenName.of(
   *               "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[TOKEN_AUTH_USER]", "[AUTH_TOKEN]")
   *           .toString();
   *   AuthToken response = memorystoreClient.getAuthToken(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of token auth user for a token auth enabled instance. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/tokenAuthUsers/{token_auth_user}/authTokens/{auth_token}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AuthToken getAuthToken(String name) {
    GetAuthTokenRequest request = GetAuthTokenRequest.newBuilder().setName(name).build();
    return getAuthToken(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a token based auth enabled instance's auth token for a given user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   GetAuthTokenRequest request =
   *       GetAuthTokenRequest.newBuilder()
   *           .setName(
   *               AuthTokenName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[INSTANCE]",
   *                       "[TOKEN_AUTH_USER]",
   *                       "[AUTH_TOKEN]")
   *                   .toString())
   *           .build();
   *   AuthToken response = memorystoreClient.getAuthToken(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AuthToken getAuthToken(GetAuthTokenRequest request) {
    return getAuthTokenCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a token based auth enabled instance's auth token for a given user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   GetAuthTokenRequest request =
   *       GetAuthTokenRequest.newBuilder()
   *           .setName(
   *               AuthTokenName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[INSTANCE]",
   *                       "[TOKEN_AUTH_USER]",
   *                       "[AUTH_TOKEN]")
   *                   .toString())
   *           .build();
   *   ApiFuture<AuthToken> future = memorystoreClient.getAuthTokenCallable().futureCall(request);
   *   // Do something.
   *   AuthToken response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAuthTokenRequest, AuthToken> getAuthTokenCallable() {
    return stub.getAuthTokenCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a token auth user for a token based auth enabled instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   InstanceName instance = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   String tokenAuthUser = "tokenAuthUser345456300";
   *   Instance response = memorystoreClient.addTokenAuthUserAsync(instance, tokenAuthUser).get();
   * }
   * }</pre>
   *
   * @param instance Required. The instance resource that this token auth user will be added for.
   *     Format: projects/{project}/locations/{location}/instances/{instance}
   * @param tokenAuthUser Required. The name of the token auth user to add.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> addTokenAuthUserAsync(
      @Nullable InstanceName instance, String tokenAuthUser) {
    AddTokenAuthUserRequest request =
        AddTokenAuthUserRequest.newBuilder()
            .setInstance(instance == null ? null : instance.toString())
            .setTokenAuthUser(tokenAuthUser)
            .build();
    return addTokenAuthUserAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a token auth user for a token based auth enabled instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   String instance = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   String tokenAuthUser = "tokenAuthUser345456300";
   *   Instance response = memorystoreClient.addTokenAuthUserAsync(instance, tokenAuthUser).get();
   * }
   * }</pre>
   *
   * @param instance Required. The instance resource that this token auth user will be added for.
   *     Format: projects/{project}/locations/{location}/instances/{instance}
   * @param tokenAuthUser Required. The name of the token auth user to add.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> addTokenAuthUserAsync(
      String instance, String tokenAuthUser) {
    AddTokenAuthUserRequest request =
        AddTokenAuthUserRequest.newBuilder()
            .setInstance(instance)
            .setTokenAuthUser(tokenAuthUser)
            .build();
    return addTokenAuthUserAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a token auth user for a token based auth enabled instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   AddTokenAuthUserRequest request =
   *       AddTokenAuthUserRequest.newBuilder()
   *           .setInstance(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setTokenAuthUser("tokenAuthUser345456300")
   *           .build();
   *   Instance response = memorystoreClient.addTokenAuthUserAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Instance, OperationMetadata> addTokenAuthUserAsync(
      AddTokenAuthUserRequest request) {
    return addTokenAuthUserOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a token auth user for a token based auth enabled instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   AddTokenAuthUserRequest request =
   *       AddTokenAuthUserRequest.newBuilder()
   *           .setInstance(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setTokenAuthUser("tokenAuthUser345456300")
   *           .build();
   *   OperationFuture<Instance, OperationMetadata> future =
   *       memorystoreClient.addTokenAuthUserOperationCallable().futureCall(request);
   *   // Do something.
   *   Instance response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<AddTokenAuthUserRequest, Instance, OperationMetadata>
      addTokenAuthUserOperationCallable() {
    return stub.addTokenAuthUserOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a token auth user for a token based auth enabled instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   AddTokenAuthUserRequest request =
   *       AddTokenAuthUserRequest.newBuilder()
   *           .setInstance(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setTokenAuthUser("tokenAuthUser345456300")
   *           .build();
   *   ApiFuture<Operation> future =
   *       memorystoreClient.addTokenAuthUserCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AddTokenAuthUserRequest, Operation> addTokenAuthUserCallable() {
    return stub.addTokenAuthUserCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a token auth user for a token based auth enabled instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   TokenAuthUserName name =
   *       TokenAuthUserName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[TOKEN_AUTH_USER]");
   *   memorystoreClient.deleteTokenAuthUserAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the token auth user to delete. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/tokenAuthUsers/{token_auth_user}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteTokenAuthUserAsync(
      @Nullable TokenAuthUserName name) {
    DeleteTokenAuthUserRequest request =
        DeleteTokenAuthUserRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteTokenAuthUserAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a token auth user for a token based auth enabled instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   String name =
   *       TokenAuthUserName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[TOKEN_AUTH_USER]")
   *           .toString();
   *   memorystoreClient.deleteTokenAuthUserAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the token auth user to delete. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/tokenAuthUsers/{token_auth_user}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteTokenAuthUserAsync(String name) {
    DeleteTokenAuthUserRequest request =
        DeleteTokenAuthUserRequest.newBuilder().setName(name).build();
    return deleteTokenAuthUserAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a token auth user for a token based auth enabled instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   DeleteTokenAuthUserRequest request =
   *       DeleteTokenAuthUserRequest.newBuilder()
   *           .setName(
   *               TokenAuthUserName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[TOKEN_AUTH_USER]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   memorystoreClient.deleteTokenAuthUserAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteTokenAuthUserAsync(
      DeleteTokenAuthUserRequest request) {
    return deleteTokenAuthUserOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a token auth user for a token based auth enabled instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   DeleteTokenAuthUserRequest request =
   *       DeleteTokenAuthUserRequest.newBuilder()
   *           .setName(
   *               TokenAuthUserName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[TOKEN_AUTH_USER]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       memorystoreClient.deleteTokenAuthUserOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteTokenAuthUserRequest, Empty, OperationMetadata>
      deleteTokenAuthUserOperationCallable() {
    return stub.deleteTokenAuthUserOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a token auth user for a token based auth enabled instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   DeleteTokenAuthUserRequest request =
   *       DeleteTokenAuthUserRequest.newBuilder()
   *           .setName(
   *               TokenAuthUserName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[TOKEN_AUTH_USER]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       memorystoreClient.deleteTokenAuthUserCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteTokenAuthUserRequest, Operation> deleteTokenAuthUserCallable() {
    return stub.deleteTokenAuthUserCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a token for a user of a token based auth enabled instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   TokenAuthUserName tokenAuthUser =
   *       TokenAuthUserName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[TOKEN_AUTH_USER]");
   *   AuthToken authToken = AuthToken.newBuilder().build();
   *   TokenAuthUser response = memorystoreClient.addAuthTokenAsync(tokenAuthUser, authToken).get();
   * }
   * }</pre>
   *
   * @param tokenAuthUser Required. The name of the token auth user resource that this token will be
   *     added for.
   * @param authToken Required. The auth token to add.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TokenAuthUser, OperationMetadata> addAuthTokenAsync(
      @Nullable TokenAuthUserName tokenAuthUser, AuthToken authToken) {
    AddAuthTokenRequest request =
        AddAuthTokenRequest.newBuilder()
            .setTokenAuthUser(tokenAuthUser == null ? null : tokenAuthUser.toString())
            .setAuthToken(authToken)
            .build();
    return addAuthTokenAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a token for a user of a token based auth enabled instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   String tokenAuthUser =
   *       TokenAuthUserName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[TOKEN_AUTH_USER]")
   *           .toString();
   *   AuthToken authToken = AuthToken.newBuilder().build();
   *   TokenAuthUser response = memorystoreClient.addAuthTokenAsync(tokenAuthUser, authToken).get();
   * }
   * }</pre>
   *
   * @param tokenAuthUser Required. The name of the token auth user resource that this token will be
   *     added for.
   * @param authToken Required. The auth token to add.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TokenAuthUser, OperationMetadata> addAuthTokenAsync(
      String tokenAuthUser, AuthToken authToken) {
    AddAuthTokenRequest request =
        AddAuthTokenRequest.newBuilder()
            .setTokenAuthUser(tokenAuthUser)
            .setAuthToken(authToken)
            .build();
    return addAuthTokenAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a token for a user of a token based auth enabled instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   AddAuthTokenRequest request =
   *       AddAuthTokenRequest.newBuilder()
   *           .setTokenAuthUser(
   *               TokenAuthUserName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[TOKEN_AUTH_USER]")
   *                   .toString())
   *           .setAuthToken(AuthToken.newBuilder().build())
   *           .build();
   *   TokenAuthUser response = memorystoreClient.addAuthTokenAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TokenAuthUser, OperationMetadata> addAuthTokenAsync(
      AddAuthTokenRequest request) {
    return addAuthTokenOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a token for a user of a token based auth enabled instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   AddAuthTokenRequest request =
   *       AddAuthTokenRequest.newBuilder()
   *           .setTokenAuthUser(
   *               TokenAuthUserName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[TOKEN_AUTH_USER]")
   *                   .toString())
   *           .setAuthToken(AuthToken.newBuilder().build())
   *           .build();
   *   OperationFuture<TokenAuthUser, OperationMetadata> future =
   *       memorystoreClient.addAuthTokenOperationCallable().futureCall(request);
   *   // Do something.
   *   TokenAuthUser response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<AddAuthTokenRequest, TokenAuthUser, OperationMetadata>
      addAuthTokenOperationCallable() {
    return stub.addAuthTokenOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a token for a user of a token based auth enabled instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   AddAuthTokenRequest request =
   *       AddAuthTokenRequest.newBuilder()
   *           .setTokenAuthUser(
   *               TokenAuthUserName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[TOKEN_AUTH_USER]")
   *                   .toString())
   *           .setAuthToken(AuthToken.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = memorystoreClient.addAuthTokenCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AddAuthTokenRequest, Operation> addAuthTokenCallable() {
    return stub.addAuthTokenCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a token for a user of a token based auth enabled instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   AuthTokenName name =
   *       AuthTokenName.of(
   *           "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[TOKEN_AUTH_USER]", "[AUTH_TOKEN]");
   *   memorystoreClient.deleteAuthTokenAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the token auth user resource that this token will be deleted
   *     from. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/tokenAuthUsers/{token_auth_user}/authTokens/{name}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteAuthTokenAsync(
      @Nullable AuthTokenName name) {
    DeleteAuthTokenRequest request =
        DeleteAuthTokenRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteAuthTokenAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a token for a user of a token based auth enabled instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   String name =
   *       AuthTokenName.of(
   *               "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[TOKEN_AUTH_USER]", "[AUTH_TOKEN]")
   *           .toString();
   *   memorystoreClient.deleteAuthTokenAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the token auth user resource that this token will be deleted
   *     from. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/tokenAuthUsers/{token_auth_user}/authTokens/{name}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteAuthTokenAsync(String name) {
    DeleteAuthTokenRequest request = DeleteAuthTokenRequest.newBuilder().setName(name).build();
    return deleteAuthTokenAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a token for a user of a token based auth enabled instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   DeleteAuthTokenRequest request =
   *       DeleteAuthTokenRequest.newBuilder()
   *           .setName(
   *               AuthTokenName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[INSTANCE]",
   *                       "[TOKEN_AUTH_USER]",
   *                       "[AUTH_TOKEN]")
   *                   .toString())
   *           .build();
   *   memorystoreClient.deleteAuthTokenAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteAuthTokenAsync(
      DeleteAuthTokenRequest request) {
    return deleteAuthTokenOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a token for a user of a token based auth enabled instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   DeleteAuthTokenRequest request =
   *       DeleteAuthTokenRequest.newBuilder()
   *           .setName(
   *               AuthTokenName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[INSTANCE]",
   *                       "[TOKEN_AUTH_USER]",
   *                       "[AUTH_TOKEN]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       memorystoreClient.deleteAuthTokenOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteAuthTokenRequest, Empty, OperationMetadata>
      deleteAuthTokenOperationCallable() {
    return stub.deleteAuthTokenOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a token for a user of a token based auth enabled instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   DeleteAuthTokenRequest request =
   *       DeleteAuthTokenRequest.newBuilder()
   *           .setName(
   *               AuthTokenName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[INSTANCE]",
   *                       "[TOKEN_AUTH_USER]",
   *                       "[AUTH_TOKEN]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future = memorystoreClient.deleteAuthTokenCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteAuthTokenRequest, Operation> deleteAuthTokenCallable() {
    return stub.deleteAuthTokenCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>This method lists locations based on the resource scope provided inthe
   * [ListLocationsRequest.name][google.cloud.location.ListLocationsRequest.name] field:
   * &#42;&#42;&#42;Global locations&#42;&#42;: If `name` is empty, the method lists thepublic
   * locations available to all projects. &#42; &#42;&#42;Project-specificlocations&#42;&#42;: If
   * `name` follows the format`projects/{project}`, the method lists locations visible to
   * thatspecific project. This includes public, private, or otherproject-specific locations enabled
   * for the project.
   *
   * <p>For gRPC and client library implementations, the resource name ispassed as the `name` field.
   * For direct service calls, the resourcename isincorporated into the request path based on the
   * specific serviceimplementation and version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : memorystoreClient.listLocations(request).iterateAll()) {
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
   * <p>This method lists locations based on the resource scope provided inthe
   * [ListLocationsRequest.name][google.cloud.location.ListLocationsRequest.name] field:
   * &#42;&#42;&#42;Global locations&#42;&#42;: If `name` is empty, the method lists thepublic
   * locations available to all projects. &#42; &#42;&#42;Project-specificlocations&#42;&#42;: If
   * `name` follows the format`projects/{project}`, the method lists locations visible to
   * thatspecific project. This includes public, private, or otherproject-specific locations enabled
   * for the project.
   *
   * <p>For gRPC and client library implementations, the resource name ispassed as the `name` field.
   * For direct service calls, the resourcename isincorporated into the request path based on the
   * specific serviceimplementation and version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       memorystoreClient.listLocationsPagedCallable().futureCall(request);
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
   * <p>This method lists locations based on the resource scope provided inthe
   * [ListLocationsRequest.name][google.cloud.location.ListLocationsRequest.name] field:
   * &#42;&#42;&#42;Global locations&#42;&#42;: If `name` is empty, the method lists thepublic
   * locations available to all projects. &#42; &#42;&#42;Project-specificlocations&#42;&#42;: If
   * `name` follows the format`projects/{project}`, the method lists locations visible to
   * thatspecific project. This includes public, private, or otherproject-specific locations enabled
   * for the project.
   *
   * <p>For gRPC and client library implementations, the resource name ispassed as the `name` field.
   * For direct service calls, the resourcename isincorporated into the request path based on the
   * specific serviceimplementation and version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = memorystoreClient.listLocationsCallable().call(request);
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
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = memorystoreClient.getLocation(request);
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
   * try (MemorystoreClient memorystoreClient = MemorystoreClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = memorystoreClient.getLocationCallable().futureCall(request);
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
        @Nullable PageContext<ListInstancesRequest, ListInstancesResponse, Instance> context,
        @Nullable ListInstancesResponse response) {
      super(context, response);
    }

    private static ListInstancesPage createEmptyPage() {
      return new ListInstancesPage(null, null);
    }

    @Override
    protected ListInstancesPage createPage(
        @Nullable PageContext<ListInstancesRequest, ListInstancesResponse, Instance> context,
        @Nullable ListInstancesResponse response) {
      return new ListInstancesPage(context, response);
    }

    @Override
    public ApiFuture<ListInstancesPage> createPageAsync(
        @Nullable PageContext<ListInstancesRequest, ListInstancesResponse, Instance> context,
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

    private ListInstancesFixedSizeCollection(
        @Nullable List<ListInstancesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListInstancesFixedSizeCollection createEmptyCollection() {
      return new ListInstancesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListInstancesFixedSizeCollection createCollection(
        @Nullable List<ListInstancesPage> pages, int collectionSize) {
      return new ListInstancesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListBackupCollectionsPagedResponse
      extends AbstractPagedListResponse<
          ListBackupCollectionsRequest,
          ListBackupCollectionsResponse,
          BackupCollection,
          ListBackupCollectionsPage,
          ListBackupCollectionsFixedSizeCollection> {

    public static ApiFuture<ListBackupCollectionsPagedResponse> createAsync(
        PageContext<ListBackupCollectionsRequest, ListBackupCollectionsResponse, BackupCollection>
            context,
        ApiFuture<ListBackupCollectionsResponse> futureResponse) {
      ApiFuture<ListBackupCollectionsPage> futurePage =
          ListBackupCollectionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListBackupCollectionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListBackupCollectionsPagedResponse(ListBackupCollectionsPage page) {
      super(page, ListBackupCollectionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListBackupCollectionsPage
      extends AbstractPage<
          ListBackupCollectionsRequest,
          ListBackupCollectionsResponse,
          BackupCollection,
          ListBackupCollectionsPage> {

    private ListBackupCollectionsPage(
        @Nullable
            PageContext<
                ListBackupCollectionsRequest, ListBackupCollectionsResponse, BackupCollection>
            context,
        @Nullable ListBackupCollectionsResponse response) {
      super(context, response);
    }

    private static ListBackupCollectionsPage createEmptyPage() {
      return new ListBackupCollectionsPage(null, null);
    }

    @Override
    protected ListBackupCollectionsPage createPage(
        @Nullable
            PageContext<
                ListBackupCollectionsRequest, ListBackupCollectionsResponse, BackupCollection>
            context,
        @Nullable ListBackupCollectionsResponse response) {
      return new ListBackupCollectionsPage(context, response);
    }

    @Override
    public ApiFuture<ListBackupCollectionsPage> createPageAsync(
        @Nullable
            PageContext<
                ListBackupCollectionsRequest, ListBackupCollectionsResponse, BackupCollection>
            context,
        ApiFuture<ListBackupCollectionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListBackupCollectionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListBackupCollectionsRequest,
          ListBackupCollectionsResponse,
          BackupCollection,
          ListBackupCollectionsPage,
          ListBackupCollectionsFixedSizeCollection> {

    private ListBackupCollectionsFixedSizeCollection(
        @Nullable List<ListBackupCollectionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListBackupCollectionsFixedSizeCollection createEmptyCollection() {
      return new ListBackupCollectionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListBackupCollectionsFixedSizeCollection createCollection(
        @Nullable List<ListBackupCollectionsPage> pages, int collectionSize) {
      return new ListBackupCollectionsFixedSizeCollection(pages, collectionSize);
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
        @Nullable PageContext<ListBackupsRequest, ListBackupsResponse, Backup> context,
        @Nullable ListBackupsResponse response) {
      super(context, response);
    }

    private static ListBackupsPage createEmptyPage() {
      return new ListBackupsPage(null, null);
    }

    @Override
    protected ListBackupsPage createPage(
        @Nullable PageContext<ListBackupsRequest, ListBackupsResponse, Backup> context,
        @Nullable ListBackupsResponse response) {
      return new ListBackupsPage(context, response);
    }

    @Override
    public ApiFuture<ListBackupsPage> createPageAsync(
        @Nullable PageContext<ListBackupsRequest, ListBackupsResponse, Backup> context,
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

    private ListBackupsFixedSizeCollection(
        @Nullable List<ListBackupsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListBackupsFixedSizeCollection createEmptyCollection() {
      return new ListBackupsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListBackupsFixedSizeCollection createCollection(
        @Nullable List<ListBackupsPage> pages, int collectionSize) {
      return new ListBackupsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListTokenAuthUsersPagedResponse
      extends AbstractPagedListResponse<
          ListTokenAuthUsersRequest,
          ListTokenAuthUsersResponse,
          TokenAuthUser,
          ListTokenAuthUsersPage,
          ListTokenAuthUsersFixedSizeCollection> {

    public static ApiFuture<ListTokenAuthUsersPagedResponse> createAsync(
        PageContext<ListTokenAuthUsersRequest, ListTokenAuthUsersResponse, TokenAuthUser> context,
        ApiFuture<ListTokenAuthUsersResponse> futureResponse) {
      ApiFuture<ListTokenAuthUsersPage> futurePage =
          ListTokenAuthUsersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListTokenAuthUsersPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListTokenAuthUsersPagedResponse(ListTokenAuthUsersPage page) {
      super(page, ListTokenAuthUsersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTokenAuthUsersPage
      extends AbstractPage<
          ListTokenAuthUsersRequest,
          ListTokenAuthUsersResponse,
          TokenAuthUser,
          ListTokenAuthUsersPage> {

    private ListTokenAuthUsersPage(
        @Nullable PageContext<ListTokenAuthUsersRequest, ListTokenAuthUsersResponse, TokenAuthUser>
            context,
        @Nullable ListTokenAuthUsersResponse response) {
      super(context, response);
    }

    private static ListTokenAuthUsersPage createEmptyPage() {
      return new ListTokenAuthUsersPage(null, null);
    }

    @Override
    protected ListTokenAuthUsersPage createPage(
        @Nullable PageContext<ListTokenAuthUsersRequest, ListTokenAuthUsersResponse, TokenAuthUser>
            context,
        @Nullable ListTokenAuthUsersResponse response) {
      return new ListTokenAuthUsersPage(context, response);
    }

    @Override
    public ApiFuture<ListTokenAuthUsersPage> createPageAsync(
        @Nullable PageContext<ListTokenAuthUsersRequest, ListTokenAuthUsersResponse, TokenAuthUser>
            context,
        ApiFuture<ListTokenAuthUsersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTokenAuthUsersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTokenAuthUsersRequest,
          ListTokenAuthUsersResponse,
          TokenAuthUser,
          ListTokenAuthUsersPage,
          ListTokenAuthUsersFixedSizeCollection> {

    private ListTokenAuthUsersFixedSizeCollection(
        @Nullable List<ListTokenAuthUsersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTokenAuthUsersFixedSizeCollection createEmptyCollection() {
      return new ListTokenAuthUsersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTokenAuthUsersFixedSizeCollection createCollection(
        @Nullable List<ListTokenAuthUsersPage> pages, int collectionSize) {
      return new ListTokenAuthUsersFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListAuthTokensPagedResponse
      extends AbstractPagedListResponse<
          ListAuthTokensRequest,
          ListAuthTokensResponse,
          AuthToken,
          ListAuthTokensPage,
          ListAuthTokensFixedSizeCollection> {

    public static ApiFuture<ListAuthTokensPagedResponse> createAsync(
        PageContext<ListAuthTokensRequest, ListAuthTokensResponse, AuthToken> context,
        ApiFuture<ListAuthTokensResponse> futureResponse) {
      ApiFuture<ListAuthTokensPage> futurePage =
          ListAuthTokensPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAuthTokensPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAuthTokensPagedResponse(ListAuthTokensPage page) {
      super(page, ListAuthTokensFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAuthTokensPage
      extends AbstractPage<
          ListAuthTokensRequest, ListAuthTokensResponse, AuthToken, ListAuthTokensPage> {

    private ListAuthTokensPage(
        @Nullable PageContext<ListAuthTokensRequest, ListAuthTokensResponse, AuthToken> context,
        @Nullable ListAuthTokensResponse response) {
      super(context, response);
    }

    private static ListAuthTokensPage createEmptyPage() {
      return new ListAuthTokensPage(null, null);
    }

    @Override
    protected ListAuthTokensPage createPage(
        @Nullable PageContext<ListAuthTokensRequest, ListAuthTokensResponse, AuthToken> context,
        @Nullable ListAuthTokensResponse response) {
      return new ListAuthTokensPage(context, response);
    }

    @Override
    public ApiFuture<ListAuthTokensPage> createPageAsync(
        @Nullable PageContext<ListAuthTokensRequest, ListAuthTokensResponse, AuthToken> context,
        ApiFuture<ListAuthTokensResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAuthTokensFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAuthTokensRequest,
          ListAuthTokensResponse,
          AuthToken,
          ListAuthTokensPage,
          ListAuthTokensFixedSizeCollection> {

    private ListAuthTokensFixedSizeCollection(
        @Nullable List<ListAuthTokensPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAuthTokensFixedSizeCollection createEmptyCollection() {
      return new ListAuthTokensFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAuthTokensFixedSizeCollection createCollection(
        @Nullable List<ListAuthTokensPage> pages, int collectionSize) {
      return new ListAuthTokensFixedSizeCollection(pages, collectionSize);
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
        @Nullable PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        @Nullable ListLocationsResponse response) {
      super(context, response);
    }

    private static ListLocationsPage createEmptyPage() {
      return new ListLocationsPage(null, null);
    }

    @Override
    protected ListLocationsPage createPage(
        @Nullable PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        @Nullable ListLocationsResponse response) {
      return new ListLocationsPage(context, response);
    }

    @Override
    public ApiFuture<ListLocationsPage> createPageAsync(
        @Nullable PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
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

    private ListLocationsFixedSizeCollection(
        @Nullable List<ListLocationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLocationsFixedSizeCollection createEmptyCollection() {
      return new ListLocationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLocationsFixedSizeCollection createCollection(
        @Nullable List<ListLocationsPage> pages, int collectionSize) {
      return new ListLocationsFixedSizeCollection(pages, collectionSize);
    }
  }
}
