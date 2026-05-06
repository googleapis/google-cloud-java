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

package com.google.cloud.spanner.admin.database.v1;

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
import com.google.api.resourcenames.ResourceName;
import com.google.cloud.spanner.admin.database.v1.stub.DatabaseAdminStub;
import com.google.cloud.spanner.admin.database.v1.stub.DatabaseAdminStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import com.google.spanner.admin.database.v1.AddSplitPointsRequest;
import com.google.spanner.admin.database.v1.AddSplitPointsResponse;
import com.google.spanner.admin.database.v1.Backup;
import com.google.spanner.admin.database.v1.BackupName;
import com.google.spanner.admin.database.v1.BackupSchedule;
import com.google.spanner.admin.database.v1.BackupScheduleName;
import com.google.spanner.admin.database.v1.CopyBackupMetadata;
import com.google.spanner.admin.database.v1.CopyBackupRequest;
import com.google.spanner.admin.database.v1.CreateBackupMetadata;
import com.google.spanner.admin.database.v1.CreateBackupRequest;
import com.google.spanner.admin.database.v1.CreateBackupScheduleRequest;
import com.google.spanner.admin.database.v1.CreateDatabaseMetadata;
import com.google.spanner.admin.database.v1.CreateDatabaseRequest;
import com.google.spanner.admin.database.v1.Database;
import com.google.spanner.admin.database.v1.DatabaseName;
import com.google.spanner.admin.database.v1.DatabaseRole;
import com.google.spanner.admin.database.v1.DeleteBackupRequest;
import com.google.spanner.admin.database.v1.DeleteBackupScheduleRequest;
import com.google.spanner.admin.database.v1.DropDatabaseRequest;
import com.google.spanner.admin.database.v1.GetBackupRequest;
import com.google.spanner.admin.database.v1.GetBackupScheduleRequest;
import com.google.spanner.admin.database.v1.GetDatabaseDdlRequest;
import com.google.spanner.admin.database.v1.GetDatabaseDdlResponse;
import com.google.spanner.admin.database.v1.GetDatabaseRequest;
import com.google.spanner.admin.database.v1.InstanceName;
import com.google.spanner.admin.database.v1.InternalUpdateGraphOperationRequest;
import com.google.spanner.admin.database.v1.InternalUpdateGraphOperationResponse;
import com.google.spanner.admin.database.v1.ListBackupOperationsRequest;
import com.google.spanner.admin.database.v1.ListBackupOperationsResponse;
import com.google.spanner.admin.database.v1.ListBackupSchedulesRequest;
import com.google.spanner.admin.database.v1.ListBackupSchedulesResponse;
import com.google.spanner.admin.database.v1.ListBackupsRequest;
import com.google.spanner.admin.database.v1.ListBackupsResponse;
import com.google.spanner.admin.database.v1.ListDatabaseOperationsRequest;
import com.google.spanner.admin.database.v1.ListDatabaseOperationsResponse;
import com.google.spanner.admin.database.v1.ListDatabaseRolesRequest;
import com.google.spanner.admin.database.v1.ListDatabaseRolesResponse;
import com.google.spanner.admin.database.v1.ListDatabasesRequest;
import com.google.spanner.admin.database.v1.ListDatabasesResponse;
import com.google.spanner.admin.database.v1.RestoreDatabaseMetadata;
import com.google.spanner.admin.database.v1.RestoreDatabaseRequest;
import com.google.spanner.admin.database.v1.SplitPoints;
import com.google.spanner.admin.database.v1.UpdateBackupRequest;
import com.google.spanner.admin.database.v1.UpdateBackupScheduleRequest;
import com.google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata;
import com.google.spanner.admin.database.v1.UpdateDatabaseDdlRequest;
import com.google.spanner.admin.database.v1.UpdateDatabaseMetadata;
import com.google.spanner.admin.database.v1.UpdateDatabaseRequest;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Cloud Spanner Database Admin API
 *
 * <p>The Cloud Spanner Database Admin API can be used to: &#42; create, drop, and list databases
 * &#42; update the schema of pre-existing databases &#42; create, delete, copy and list backups for
 * a database &#42; restore a database from an existing backup
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
 * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
 *   DatabaseName name = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]");
 *   Database response = databaseAdminClient.getDatabase(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the DatabaseAdminClient object to clean up resources such
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
 *      <td><p> ListDatabases</td>
 *      <td><p> Lists Cloud Spanner databases.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listDatabases(ListDatabasesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listDatabases(InstanceName parent)
 *           <li><p> listDatabases(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listDatabasesPagedCallable()
 *           <li><p> listDatabasesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateDatabase</td>
 *      <td><p> Creates a new Cloud Spanner database and starts to prepare it for serving. The returned [long-running operation][google.longrunning.Operation] will have a name of the format `&lt;database_name&gt;/operations/&lt;operation_id&gt;` and can be used to track preparation of the database. The [metadata][google.longrunning.Operation.metadata] field type is [CreateDatabaseMetadata][google.spanner.admin.database.v1.CreateDatabaseMetadata]. The [response][google.longrunning.Operation.response] field type is [Database][google.spanner.admin.database.v1.Database], if successful.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createDatabaseAsync(CreateDatabaseRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createDatabaseAsync(InstanceName parent, String createStatement)
 *           <li><p> createDatabaseAsync(String parent, String createStatement)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createDatabaseOperationCallable()
 *           <li><p> createDatabaseCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetDatabase</td>
 *      <td><p> Gets the state of a Cloud Spanner database.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDatabase(GetDatabaseRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getDatabase(DatabaseName name)
 *           <li><p> getDatabase(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDatabaseCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateDatabase</td>
 *      <td><p> Updates a Cloud Spanner database. The returned [long-running operation][google.longrunning.Operation] can be used to track the progress of updating the database. If the named database does not exist, returns `NOT_FOUND`.
 * <p>  While the operation is pending:
 * <p>    &#42; The database's     [reconciling][google.spanner.admin.database.v1.Database.reconciling]     field is set to true.   &#42; Cancelling the operation is best-effort. If the cancellation succeeds,     the operation metadata's     [cancel_time][google.spanner.admin.database.v1.UpdateDatabaseMetadata.cancel_time]     is set, the updates are reverted, and the operation terminates with a     `CANCELLED` status.   &#42; New UpdateDatabase requests will return a `FAILED_PRECONDITION` error     until the pending operation is done (returns successfully or with     error).   &#42; Reading the database via the API continues to give the pre-request     values.
 * <p>  Upon completion of the returned operation:
 * <p>    &#42; The new values are in effect and readable via the API.   &#42; The database's     [reconciling][google.spanner.admin.database.v1.Database.reconciling]     field becomes false.
 * <p>  The returned [long-running operation][google.longrunning.Operation] will have a name of the format `projects/&lt;project&gt;/instances/&lt;instance&gt;/databases/&lt;database&gt;/operations/&lt;operation_id&gt;` and can be used to track the database modification. The [metadata][google.longrunning.Operation.metadata] field type is [UpdateDatabaseMetadata][google.spanner.admin.database.v1.UpdateDatabaseMetadata]. The [response][google.longrunning.Operation.response] field type is [Database][google.spanner.admin.database.v1.Database], if successful.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateDatabaseAsync(UpdateDatabaseRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateDatabaseAsync(Database database, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateDatabaseOperationCallable()
 *           <li><p> updateDatabaseCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateDatabaseDdl</td>
 *      <td><p> Updates the schema of a Cloud Spanner database by creating/altering/dropping tables, columns, indexes, etc. The returned [long-running operation][google.longrunning.Operation] will have a name of the format `&lt;database_name&gt;/operations/&lt;operation_id&gt;` and can be used to track execution of the schema change(s). The [metadata][google.longrunning.Operation.metadata] field type is [UpdateDatabaseDdlMetadata][google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata]. The operation has no response.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateDatabaseDdlAsync(UpdateDatabaseDdlRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateDatabaseDdlAsync(DatabaseName database, List&lt;String&gt; statements)
 *           <li><p> updateDatabaseDdlAsync(String database, List&lt;String&gt; statements)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateDatabaseDdlOperationCallable()
 *           <li><p> updateDatabaseDdlCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DropDatabase</td>
 *      <td><p> Drops (aka deletes) a Cloud Spanner database. Completed backups for the database will be retained according to their `expire_time`. Note: Cloud Spanner might continue to accept requests for a few seconds after the database has been deleted.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> dropDatabase(DropDatabaseRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> dropDatabase(DatabaseName database)
 *           <li><p> dropDatabase(String database)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> dropDatabaseCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetDatabaseDdl</td>
 *      <td><p> Returns the schema of a Cloud Spanner database as a list of formatted DDL statements. This method does not show pending schema updates, those may be queried using the [Operations][google.longrunning.Operations] API.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDatabaseDdl(GetDatabaseDdlRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getDatabaseDdl(DatabaseName database)
 *           <li><p> getDatabaseDdl(String database)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDatabaseDdlCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SetIamPolicy</td>
 *      <td><p> Sets the access control policy on a database or backup resource. Replaces any existing policy.
 * <p>  Authorization requires `spanner.databases.setIamPolicy` permission on [resource][google.iam.v1.SetIamPolicyRequest.resource]. For backups, authorization requires `spanner.backups.setIamPolicy` permission on [resource][google.iam.v1.SetIamPolicyRequest.resource].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> setIamPolicy(SetIamPolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> setIamPolicy(ResourceName resource, Policy policy)
 *           <li><p> setIamPolicy(String resource, Policy policy)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> setIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetIamPolicy</td>
 *      <td><p> Gets the access control policy for a database or backup resource. Returns an empty policy if a database or backup exists but does not have a policy set.
 * <p>  Authorization requires `spanner.databases.getIamPolicy` permission on [resource][google.iam.v1.GetIamPolicyRequest.resource]. For backups, authorization requires `spanner.backups.getIamPolicy` permission on [resource][google.iam.v1.GetIamPolicyRequest.resource].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getIamPolicy(GetIamPolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getIamPolicy(ResourceName resource)
 *           <li><p> getIamPolicy(String resource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> TestIamPermissions</td>
 *      <td><p> Returns permissions that the caller has on the specified database or backup resource.
 * <p>  Attempting this RPC on a non-existent Cloud Spanner database will result in a NOT_FOUND error if the user has `spanner.databases.list` permission on the containing Cloud Spanner instance. Otherwise returns an empty set of permissions. Calling this method on a backup that does not exist will result in a NOT_FOUND error if the user has `spanner.backups.list` permission on the containing instance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> testIamPermissions(TestIamPermissionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> testIamPermissions(ResourceName resource, List&lt;String&gt; permissions)
 *           <li><p> testIamPermissions(String resource, List&lt;String&gt; permissions)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> testIamPermissionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateBackup</td>
 *      <td><p> Starts creating a new Cloud Spanner Backup. The returned backup [long-running operation][google.longrunning.Operation] will have a name of the format `projects/&lt;project&gt;/instances/&lt;instance&gt;/backups/&lt;backup&gt;/operations/&lt;operation_id&gt;` and can be used to track creation of the backup. The [metadata][google.longrunning.Operation.metadata] field type is [CreateBackupMetadata][google.spanner.admin.database.v1.CreateBackupMetadata]. The [response][google.longrunning.Operation.response] field type is [Backup][google.spanner.admin.database.v1.Backup], if successful. Cancelling the returned operation will stop the creation and delete the backup. There can be only one pending backup creation per database. Backup creation of different databases can run concurrently.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createBackupAsync(CreateBackupRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createBackupAsync(InstanceName parent, Backup backup, String backupId)
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
 *      <td><p> CopyBackup</td>
 *      <td><p> Starts copying a Cloud Spanner Backup. The returned backup [long-running operation][google.longrunning.Operation] will have a name of the format `projects/&lt;project&gt;/instances/&lt;instance&gt;/backups/&lt;backup&gt;/operations/&lt;operation_id&gt;` and can be used to track copying of the backup. The operation is associated with the destination backup. The [metadata][google.longrunning.Operation.metadata] field type is [CopyBackupMetadata][google.spanner.admin.database.v1.CopyBackupMetadata]. The [response][google.longrunning.Operation.response] field type is [Backup][google.spanner.admin.database.v1.Backup], if successful. Cancelling the returned operation will stop the copying and delete the destination backup. Concurrent CopyBackup requests can run on the same source backup.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> copyBackupAsync(CopyBackupRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> copyBackupAsync(InstanceName parent, String backupId, BackupName sourceBackup, Timestamp expireTime)
 *           <li><p> copyBackupAsync(InstanceName parent, String backupId, String sourceBackup, Timestamp expireTime)
 *           <li><p> copyBackupAsync(String parent, String backupId, BackupName sourceBackup, Timestamp expireTime)
 *           <li><p> copyBackupAsync(String parent, String backupId, String sourceBackup, Timestamp expireTime)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> copyBackupOperationCallable()
 *           <li><p> copyBackupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetBackup</td>
 *      <td><p> Gets metadata on a pending or completed [Backup][google.spanner.admin.database.v1.Backup].</td>
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
 *      <td><p> Updates a pending or completed [Backup][google.spanner.admin.database.v1.Backup].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateBackup(UpdateBackupRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateBackup(Backup backup, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateBackupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteBackup</td>
 *      <td><p> Deletes a pending or completed [Backup][google.spanner.admin.database.v1.Backup].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteBackup(DeleteBackupRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteBackup(BackupName name)
 *           <li><p> deleteBackup(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteBackupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListBackups</td>
 *      <td><p> Lists completed and pending backups. Backups returned are ordered by `create_time` in descending order, starting from the most recent `create_time`.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listBackups(ListBackupsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listBackups(InstanceName parent)
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
 *      <td><p> RestoreDatabase</td>
 *      <td><p> Create a new database by restoring from a completed backup. The new database must be in the same project and in an instance with the same instance configuration as the instance containing the backup. The returned database [long-running operation][google.longrunning.Operation] has a name of the format `projects/&lt;project&gt;/instances/&lt;instance&gt;/databases/&lt;database&gt;/operations/&lt;operation_id&gt;`, and can be used to track the progress of the operation, and to cancel it. The [metadata][google.longrunning.Operation.metadata] field type is [RestoreDatabaseMetadata][google.spanner.admin.database.v1.RestoreDatabaseMetadata]. The [response][google.longrunning.Operation.response] type is [Database][google.spanner.admin.database.v1.Database], if successful. Cancelling the returned operation will stop the restore and delete the database. There can be only one database being restored into an instance at a time. Once the restore operation completes, a new restore operation can be initiated, without waiting for the optimize operation associated with the first restore to complete.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> restoreDatabaseAsync(RestoreDatabaseRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> restoreDatabaseAsync(InstanceName parent, String databaseId, BackupName backup)
 *           <li><p> restoreDatabaseAsync(InstanceName parent, String databaseId, String backup)
 *           <li><p> restoreDatabaseAsync(String parent, String databaseId, BackupName backup)
 *           <li><p> restoreDatabaseAsync(String parent, String databaseId, String backup)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> restoreDatabaseOperationCallable()
 *           <li><p> restoreDatabaseCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListDatabaseOperations</td>
 *      <td><p> Lists database [longrunning-operations][google.longrunning.Operation]. A database operation has a name of the form `projects/&lt;project&gt;/instances/&lt;instance&gt;/databases/&lt;database&gt;/operations/&lt;operation&gt;`. The long-running operation [metadata][google.longrunning.Operation.metadata] field type `metadata.type_url` describes the type of the metadata. Operations returned include those that have completed/failed/canceled within the last 7 days, and pending operations.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listDatabaseOperations(ListDatabaseOperationsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listDatabaseOperations(InstanceName parent)
 *           <li><p> listDatabaseOperations(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listDatabaseOperationsPagedCallable()
 *           <li><p> listDatabaseOperationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListBackupOperations</td>
 *      <td><p> Lists the backup [long-running operations][google.longrunning.Operation] in the given instance. A backup operation has a name of the form `projects/&lt;project&gt;/instances/&lt;instance&gt;/backups/&lt;backup&gt;/operations/&lt;operation&gt;`. The long-running operation [metadata][google.longrunning.Operation.metadata] field type `metadata.type_url` describes the type of the metadata. Operations returned include those that have completed/failed/canceled within the last 7 days, and pending operations. Operations returned are ordered by `operation.metadata.value.progress.start_time` in descending order starting from the most recently started operation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listBackupOperations(ListBackupOperationsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listBackupOperations(InstanceName parent)
 *           <li><p> listBackupOperations(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listBackupOperationsPagedCallable()
 *           <li><p> listBackupOperationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListDatabaseRoles</td>
 *      <td><p> Lists Cloud Spanner database roles.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listDatabaseRoles(ListDatabaseRolesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listDatabaseRoles(DatabaseName parent)
 *           <li><p> listDatabaseRoles(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listDatabaseRolesPagedCallable()
 *           <li><p> listDatabaseRolesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> AddSplitPoints</td>
 *      <td><p> Adds split points to specified tables, indexes of a database.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> addSplitPoints(AddSplitPointsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> addSplitPoints(DatabaseName database, List&lt;SplitPoints&gt; splitPoints)
 *           <li><p> addSplitPoints(String database, List&lt;SplitPoints&gt; splitPoints)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> addSplitPointsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateBackupSchedule</td>
 *      <td><p> Creates a new backup schedule.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createBackupSchedule(CreateBackupScheduleRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createBackupSchedule(DatabaseName parent, BackupSchedule backupSchedule, String backupScheduleId)
 *           <li><p> createBackupSchedule(String parent, BackupSchedule backupSchedule, String backupScheduleId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createBackupScheduleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetBackupSchedule</td>
 *      <td><p> Gets backup schedule for the input schedule name.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getBackupSchedule(GetBackupScheduleRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getBackupSchedule(BackupScheduleName name)
 *           <li><p> getBackupSchedule(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getBackupScheduleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateBackupSchedule</td>
 *      <td><p> Updates a backup schedule.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateBackupSchedule(UpdateBackupScheduleRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateBackupSchedule(BackupSchedule backupSchedule, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateBackupScheduleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteBackupSchedule</td>
 *      <td><p> Deletes a backup schedule.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteBackupSchedule(DeleteBackupScheduleRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteBackupSchedule(BackupScheduleName name)
 *           <li><p> deleteBackupSchedule(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteBackupScheduleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListBackupSchedules</td>
 *      <td><p> Lists all the backup schedules for the database.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listBackupSchedules(ListBackupSchedulesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listBackupSchedules(DatabaseName parent)
 *           <li><p> listBackupSchedules(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listBackupSchedulesPagedCallable()
 *           <li><p> listBackupSchedulesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> InternalUpdateGraphOperation</td>
 *      <td><p> This is an internal API called by Spanner Graph jobs. You should never need to call this API directly.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> internalUpdateGraphOperation(InternalUpdateGraphOperationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> internalUpdateGraphOperation(DatabaseName database, String operationId)
 *           <li><p> internalUpdateGraphOperation(String database, String operationId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> internalUpdateGraphOperationCallable()
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
 * <p>This class can be customized by passing in a custom instance of DatabaseAdminSettings to
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
 * DatabaseAdminSettings databaseAdminSettings =
 *     DatabaseAdminSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create(databaseAdminSettings);
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
 * DatabaseAdminSettings databaseAdminSettings =
 *     DatabaseAdminSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create(databaseAdminSettings);
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
 * DatabaseAdminSettings databaseAdminSettings =
 *     DatabaseAdminSettings.newHttpJsonBuilder().build();
 * DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create(databaseAdminSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class DatabaseAdminClient implements BackgroundResource {
  private final DatabaseAdminSettings settings;
  private final DatabaseAdminStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of DatabaseAdminClient with default settings. */
  public static final DatabaseAdminClient create() throws IOException {
    return create(DatabaseAdminSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DatabaseAdminClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final DatabaseAdminClient create(DatabaseAdminSettings settings)
      throws IOException {
    return new DatabaseAdminClient(settings);
  }

  /**
   * Constructs an instance of DatabaseAdminClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(DatabaseAdminSettings).
   */
  public static final DatabaseAdminClient create(DatabaseAdminStub stub) {
    return new DatabaseAdminClient(stub);
  }

  /**
   * Constructs an instance of DatabaseAdminClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected DatabaseAdminClient(DatabaseAdminSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((DatabaseAdminStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected DatabaseAdminClient(DatabaseAdminStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final DatabaseAdminSettings getSettings() {
    return settings;
  }

  public DatabaseAdminStub getStub() {
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
   * Lists Cloud Spanner databases.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   for (Database element : databaseAdminClient.listDatabases(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The instance whose databases should be listed. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDatabasesPagedResponse listDatabases(InstanceName parent) {
    ListDatabasesRequest request =
        ListDatabasesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDatabases(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Cloud Spanner databases.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   String parent = InstanceName.of("[PROJECT]", "[INSTANCE]").toString();
   *   for (Database element : databaseAdminClient.listDatabases(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The instance whose databases should be listed. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDatabasesPagedResponse listDatabases(String parent) {
    ListDatabasesRequest request = ListDatabasesRequest.newBuilder().setParent(parent).build();
    return listDatabases(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Cloud Spanner databases.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   ListDatabasesRequest request =
   *       ListDatabasesRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Database element : databaseAdminClient.listDatabases(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDatabasesPagedResponse listDatabases(ListDatabasesRequest request) {
    return listDatabasesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Cloud Spanner databases.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   ListDatabasesRequest request =
   *       ListDatabasesRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Database> future =
   *       databaseAdminClient.listDatabasesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Database element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDatabasesRequest, ListDatabasesPagedResponse>
      listDatabasesPagedCallable() {
    return stub.listDatabasesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Cloud Spanner databases.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   ListDatabasesRequest request =
   *       ListDatabasesRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListDatabasesResponse response = databaseAdminClient.listDatabasesCallable().call(request);
   *     for (Database element : response.getDatabasesList()) {
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
  public final UnaryCallable<ListDatabasesRequest, ListDatabasesResponse> listDatabasesCallable() {
    return stub.listDatabasesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Cloud Spanner database and starts to prepare it for serving. The returned
   * [long-running operation][google.longrunning.Operation] will have a name of the format
   * `&lt;database_name&gt;/operations/&lt;operation_id&gt;` and can be used to track preparation of
   * the database. The [metadata][google.longrunning.Operation.metadata] field type is
   * [CreateDatabaseMetadata][google.spanner.admin.database.v1.CreateDatabaseMetadata]. The
   * [response][google.longrunning.Operation.response] field type is
   * [Database][google.spanner.admin.database.v1.Database], if successful.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   String createStatement = "createStatement744686547";
   *   Database response = databaseAdminClient.createDatabaseAsync(parent, createStatement).get();
   * }
   * }</pre>
   *
   * @param parent Required. The name of the instance that will serve the new database. Values are
   *     of the form `projects/&lt;project&gt;/instances/&lt;instance&gt;`.
   * @param createStatement Required. A `CREATE DATABASE` statement, which specifies the ID of the
   *     new database. The database ID must conform to the regular expression
   *     `[a-z][a-z0-9_\\-]&#42;[a-z0-9]` and be between 2 and 30 characters in length. If the
   *     database ID is a reserved word or if it contains a hyphen, the database ID must be enclosed
   *     in backticks (`` ` ``).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Database, CreateDatabaseMetadata> createDatabaseAsync(
      InstanceName parent, String createStatement) {
    CreateDatabaseRequest request =
        CreateDatabaseRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setCreateStatement(createStatement)
            .build();
    return createDatabaseAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Cloud Spanner database and starts to prepare it for serving. The returned
   * [long-running operation][google.longrunning.Operation] will have a name of the format
   * `&lt;database_name&gt;/operations/&lt;operation_id&gt;` and can be used to track preparation of
   * the database. The [metadata][google.longrunning.Operation.metadata] field type is
   * [CreateDatabaseMetadata][google.spanner.admin.database.v1.CreateDatabaseMetadata]. The
   * [response][google.longrunning.Operation.response] field type is
   * [Database][google.spanner.admin.database.v1.Database], if successful.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   String parent = InstanceName.of("[PROJECT]", "[INSTANCE]").toString();
   *   String createStatement = "createStatement744686547";
   *   Database response = databaseAdminClient.createDatabaseAsync(parent, createStatement).get();
   * }
   * }</pre>
   *
   * @param parent Required. The name of the instance that will serve the new database. Values are
   *     of the form `projects/&lt;project&gt;/instances/&lt;instance&gt;`.
   * @param createStatement Required. A `CREATE DATABASE` statement, which specifies the ID of the
   *     new database. The database ID must conform to the regular expression
   *     `[a-z][a-z0-9_\\-]&#42;[a-z0-9]` and be between 2 and 30 characters in length. If the
   *     database ID is a reserved word or if it contains a hyphen, the database ID must be enclosed
   *     in backticks (`` ` ``).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Database, CreateDatabaseMetadata> createDatabaseAsync(
      String parent, String createStatement) {
    CreateDatabaseRequest request =
        CreateDatabaseRequest.newBuilder()
            .setParent(parent)
            .setCreateStatement(createStatement)
            .build();
    return createDatabaseAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Cloud Spanner database and starts to prepare it for serving. The returned
   * [long-running operation][google.longrunning.Operation] will have a name of the format
   * `&lt;database_name&gt;/operations/&lt;operation_id&gt;` and can be used to track preparation of
   * the database. The [metadata][google.longrunning.Operation.metadata] field type is
   * [CreateDatabaseMetadata][google.spanner.admin.database.v1.CreateDatabaseMetadata]. The
   * [response][google.longrunning.Operation.response] field type is
   * [Database][google.spanner.admin.database.v1.Database], if successful.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   CreateDatabaseRequest request =
   *       CreateDatabaseRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
   *           .setCreateStatement("createStatement744686547")
   *           .addAllExtraStatements(new ArrayList<String>())
   *           .setEncryptionConfig(EncryptionConfig.newBuilder().build())
   *           .setDatabaseDialect(DatabaseDialect.forNumber(0))
   *           .setProtoDescriptors(ByteString.EMPTY)
   *           .build();
   *   Database response = databaseAdminClient.createDatabaseAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Database, CreateDatabaseMetadata> createDatabaseAsync(
      CreateDatabaseRequest request) {
    return createDatabaseOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Cloud Spanner database and starts to prepare it for serving. The returned
   * [long-running operation][google.longrunning.Operation] will have a name of the format
   * `&lt;database_name&gt;/operations/&lt;operation_id&gt;` and can be used to track preparation of
   * the database. The [metadata][google.longrunning.Operation.metadata] field type is
   * [CreateDatabaseMetadata][google.spanner.admin.database.v1.CreateDatabaseMetadata]. The
   * [response][google.longrunning.Operation.response] field type is
   * [Database][google.spanner.admin.database.v1.Database], if successful.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   CreateDatabaseRequest request =
   *       CreateDatabaseRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
   *           .setCreateStatement("createStatement744686547")
   *           .addAllExtraStatements(new ArrayList<String>())
   *           .setEncryptionConfig(EncryptionConfig.newBuilder().build())
   *           .setDatabaseDialect(DatabaseDialect.forNumber(0))
   *           .setProtoDescriptors(ByteString.EMPTY)
   *           .build();
   *   OperationFuture<Database, CreateDatabaseMetadata> future =
   *       databaseAdminClient.createDatabaseOperationCallable().futureCall(request);
   *   // Do something.
   *   Database response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateDatabaseRequest, Database, CreateDatabaseMetadata>
      createDatabaseOperationCallable() {
    return stub.createDatabaseOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Cloud Spanner database and starts to prepare it for serving. The returned
   * [long-running operation][google.longrunning.Operation] will have a name of the format
   * `&lt;database_name&gt;/operations/&lt;operation_id&gt;` and can be used to track preparation of
   * the database. The [metadata][google.longrunning.Operation.metadata] field type is
   * [CreateDatabaseMetadata][google.spanner.admin.database.v1.CreateDatabaseMetadata]. The
   * [response][google.longrunning.Operation.response] field type is
   * [Database][google.spanner.admin.database.v1.Database], if successful.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   CreateDatabaseRequest request =
   *       CreateDatabaseRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
   *           .setCreateStatement("createStatement744686547")
   *           .addAllExtraStatements(new ArrayList<String>())
   *           .setEncryptionConfig(EncryptionConfig.newBuilder().build())
   *           .setDatabaseDialect(DatabaseDialect.forNumber(0))
   *           .setProtoDescriptors(ByteString.EMPTY)
   *           .build();
   *   ApiFuture<Operation> future =
   *       databaseAdminClient.createDatabaseCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateDatabaseRequest, Operation> createDatabaseCallable() {
    return stub.createDatabaseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the state of a Cloud Spanner database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   DatabaseName name = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]");
   *   Database response = databaseAdminClient.getDatabase(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the requested database. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/databases/&lt;database&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Database getDatabase(DatabaseName name) {
    GetDatabaseRequest request =
        GetDatabaseRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getDatabase(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the state of a Cloud Spanner database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   String name = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]").toString();
   *   Database response = databaseAdminClient.getDatabase(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the requested database. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/databases/&lt;database&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Database getDatabase(String name) {
    GetDatabaseRequest request = GetDatabaseRequest.newBuilder().setName(name).build();
    return getDatabase(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the state of a Cloud Spanner database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   GetDatabaseRequest request =
   *       GetDatabaseRequest.newBuilder()
   *           .setName(DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]").toString())
   *           .build();
   *   Database response = databaseAdminClient.getDatabase(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Database getDatabase(GetDatabaseRequest request) {
    return getDatabaseCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the state of a Cloud Spanner database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   GetDatabaseRequest request =
   *       GetDatabaseRequest.newBuilder()
   *           .setName(DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]").toString())
   *           .build();
   *   ApiFuture<Database> future = databaseAdminClient.getDatabaseCallable().futureCall(request);
   *   // Do something.
   *   Database response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDatabaseRequest, Database> getDatabaseCallable() {
    return stub.getDatabaseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Cloud Spanner database. The returned [long-running
   * operation][google.longrunning.Operation] can be used to track the progress of updating the
   * database. If the named database does not exist, returns `NOT_FOUND`.
   *
   * <p>While the operation is pending:
   *
   * <p>&#42; The database's [reconciling][google.spanner.admin.database.v1.Database.reconciling]
   * field is set to true. &#42; Cancelling the operation is best-effort. If the cancellation
   * succeeds, the operation metadata's
   * [cancel_time][google.spanner.admin.database.v1.UpdateDatabaseMetadata.cancel_time] is set, the
   * updates are reverted, and the operation terminates with a `CANCELLED` status. &#42; New
   * UpdateDatabase requests will return a `FAILED_PRECONDITION` error until the pending operation
   * is done (returns successfully or with error). &#42; Reading the database via the API continues
   * to give the pre-request values.
   *
   * <p>Upon completion of the returned operation:
   *
   * <p>&#42; The new values are in effect and readable via the API. &#42; The database's
   * [reconciling][google.spanner.admin.database.v1.Database.reconciling] field becomes false.
   *
   * <p>The returned [long-running operation][google.longrunning.Operation] will have a name of the
   * format
   * `projects/&lt;project&gt;/instances/&lt;instance&gt;/databases/&lt;database&gt;/operations/&lt;operation_id&gt;`
   * and can be used to track the database modification. The
   * [metadata][google.longrunning.Operation.metadata] field type is
   * [UpdateDatabaseMetadata][google.spanner.admin.database.v1.UpdateDatabaseMetadata]. The
   * [response][google.longrunning.Operation.response] field type is
   * [Database][google.spanner.admin.database.v1.Database], if successful.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   Database database = Database.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Database response = databaseAdminClient.updateDatabaseAsync(database, updateMask).get();
   * }
   * }</pre>
   *
   * @param database Required. The database to update. The `name` field of the database is of the
   *     form `projects/&lt;project&gt;/instances/&lt;instance&gt;/databases/&lt;database&gt;`.
   * @param updateMask Required. The list of fields to update. Currently, only
   *     `enable_drop_protection` field can be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Database, UpdateDatabaseMetadata> updateDatabaseAsync(
      Database database, FieldMask updateMask) {
    UpdateDatabaseRequest request =
        UpdateDatabaseRequest.newBuilder().setDatabase(database).setUpdateMask(updateMask).build();
    return updateDatabaseAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Cloud Spanner database. The returned [long-running
   * operation][google.longrunning.Operation] can be used to track the progress of updating the
   * database. If the named database does not exist, returns `NOT_FOUND`.
   *
   * <p>While the operation is pending:
   *
   * <p>&#42; The database's [reconciling][google.spanner.admin.database.v1.Database.reconciling]
   * field is set to true. &#42; Cancelling the operation is best-effort. If the cancellation
   * succeeds, the operation metadata's
   * [cancel_time][google.spanner.admin.database.v1.UpdateDatabaseMetadata.cancel_time] is set, the
   * updates are reverted, and the operation terminates with a `CANCELLED` status. &#42; New
   * UpdateDatabase requests will return a `FAILED_PRECONDITION` error until the pending operation
   * is done (returns successfully or with error). &#42; Reading the database via the API continues
   * to give the pre-request values.
   *
   * <p>Upon completion of the returned operation:
   *
   * <p>&#42; The new values are in effect and readable via the API. &#42; The database's
   * [reconciling][google.spanner.admin.database.v1.Database.reconciling] field becomes false.
   *
   * <p>The returned [long-running operation][google.longrunning.Operation] will have a name of the
   * format
   * `projects/&lt;project&gt;/instances/&lt;instance&gt;/databases/&lt;database&gt;/operations/&lt;operation_id&gt;`
   * and can be used to track the database modification. The
   * [metadata][google.longrunning.Operation.metadata] field type is
   * [UpdateDatabaseMetadata][google.spanner.admin.database.v1.UpdateDatabaseMetadata]. The
   * [response][google.longrunning.Operation.response] field type is
   * [Database][google.spanner.admin.database.v1.Database], if successful.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   UpdateDatabaseRequest request =
   *       UpdateDatabaseRequest.newBuilder()
   *           .setDatabase(Database.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Database response = databaseAdminClient.updateDatabaseAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Database, UpdateDatabaseMetadata> updateDatabaseAsync(
      UpdateDatabaseRequest request) {
    return updateDatabaseOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Cloud Spanner database. The returned [long-running
   * operation][google.longrunning.Operation] can be used to track the progress of updating the
   * database. If the named database does not exist, returns `NOT_FOUND`.
   *
   * <p>While the operation is pending:
   *
   * <p>&#42; The database's [reconciling][google.spanner.admin.database.v1.Database.reconciling]
   * field is set to true. &#42; Cancelling the operation is best-effort. If the cancellation
   * succeeds, the operation metadata's
   * [cancel_time][google.spanner.admin.database.v1.UpdateDatabaseMetadata.cancel_time] is set, the
   * updates are reverted, and the operation terminates with a `CANCELLED` status. &#42; New
   * UpdateDatabase requests will return a `FAILED_PRECONDITION` error until the pending operation
   * is done (returns successfully or with error). &#42; Reading the database via the API continues
   * to give the pre-request values.
   *
   * <p>Upon completion of the returned operation:
   *
   * <p>&#42; The new values are in effect and readable via the API. &#42; The database's
   * [reconciling][google.spanner.admin.database.v1.Database.reconciling] field becomes false.
   *
   * <p>The returned [long-running operation][google.longrunning.Operation] will have a name of the
   * format
   * `projects/&lt;project&gt;/instances/&lt;instance&gt;/databases/&lt;database&gt;/operations/&lt;operation_id&gt;`
   * and can be used to track the database modification. The
   * [metadata][google.longrunning.Operation.metadata] field type is
   * [UpdateDatabaseMetadata][google.spanner.admin.database.v1.UpdateDatabaseMetadata]. The
   * [response][google.longrunning.Operation.response] field type is
   * [Database][google.spanner.admin.database.v1.Database], if successful.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   UpdateDatabaseRequest request =
   *       UpdateDatabaseRequest.newBuilder()
   *           .setDatabase(Database.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<Database, UpdateDatabaseMetadata> future =
   *       databaseAdminClient.updateDatabaseOperationCallable().futureCall(request);
   *   // Do something.
   *   Database response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateDatabaseRequest, Database, UpdateDatabaseMetadata>
      updateDatabaseOperationCallable() {
    return stub.updateDatabaseOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a Cloud Spanner database. The returned [long-running
   * operation][google.longrunning.Operation] can be used to track the progress of updating the
   * database. If the named database does not exist, returns `NOT_FOUND`.
   *
   * <p>While the operation is pending:
   *
   * <p>&#42; The database's [reconciling][google.spanner.admin.database.v1.Database.reconciling]
   * field is set to true. &#42; Cancelling the operation is best-effort. If the cancellation
   * succeeds, the operation metadata's
   * [cancel_time][google.spanner.admin.database.v1.UpdateDatabaseMetadata.cancel_time] is set, the
   * updates are reverted, and the operation terminates with a `CANCELLED` status. &#42; New
   * UpdateDatabase requests will return a `FAILED_PRECONDITION` error until the pending operation
   * is done (returns successfully or with error). &#42; Reading the database via the API continues
   * to give the pre-request values.
   *
   * <p>Upon completion of the returned operation:
   *
   * <p>&#42; The new values are in effect and readable via the API. &#42; The database's
   * [reconciling][google.spanner.admin.database.v1.Database.reconciling] field becomes false.
   *
   * <p>The returned [long-running operation][google.longrunning.Operation] will have a name of the
   * format
   * `projects/&lt;project&gt;/instances/&lt;instance&gt;/databases/&lt;database&gt;/operations/&lt;operation_id&gt;`
   * and can be used to track the database modification. The
   * [metadata][google.longrunning.Operation.metadata] field type is
   * [UpdateDatabaseMetadata][google.spanner.admin.database.v1.UpdateDatabaseMetadata]. The
   * [response][google.longrunning.Operation.response] field type is
   * [Database][google.spanner.admin.database.v1.Database], if successful.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   UpdateDatabaseRequest request =
   *       UpdateDatabaseRequest.newBuilder()
   *           .setDatabase(Database.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       databaseAdminClient.updateDatabaseCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateDatabaseRequest, Operation> updateDatabaseCallable() {
    return stub.updateDatabaseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the schema of a Cloud Spanner database by creating/altering/dropping tables, columns,
   * indexes, etc. The returned [long-running operation][google.longrunning.Operation] will have a
   * name of the format `&lt;database_name&gt;/operations/&lt;operation_id&gt;` and can be used to
   * track execution of the schema change(s). The [metadata][google.longrunning.Operation.metadata]
   * field type is
   * [UpdateDatabaseDdlMetadata][google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata]. The
   * operation has no response.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   DatabaseName database = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]");
   *   List<String> statements = new ArrayList<>();
   *   databaseAdminClient.updateDatabaseDdlAsync(database, statements).get();
   * }
   * }</pre>
   *
   * @param database Required. The database to update.
   * @param statements Required. DDL statements to be applied to the database.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, UpdateDatabaseDdlMetadata> updateDatabaseDdlAsync(
      DatabaseName database, List<String> statements) {
    UpdateDatabaseDdlRequest request =
        UpdateDatabaseDdlRequest.newBuilder()
            .setDatabase(database == null ? null : database.toString())
            .addAllStatements(statements)
            .build();
    return updateDatabaseDdlAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the schema of a Cloud Spanner database by creating/altering/dropping tables, columns,
   * indexes, etc. The returned [long-running operation][google.longrunning.Operation] will have a
   * name of the format `&lt;database_name&gt;/operations/&lt;operation_id&gt;` and can be used to
   * track execution of the schema change(s). The [metadata][google.longrunning.Operation.metadata]
   * field type is
   * [UpdateDatabaseDdlMetadata][google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata]. The
   * operation has no response.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   String database = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]").toString();
   *   List<String> statements = new ArrayList<>();
   *   databaseAdminClient.updateDatabaseDdlAsync(database, statements).get();
   * }
   * }</pre>
   *
   * @param database Required. The database to update.
   * @param statements Required. DDL statements to be applied to the database.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, UpdateDatabaseDdlMetadata> updateDatabaseDdlAsync(
      String database, List<String> statements) {
    UpdateDatabaseDdlRequest request =
        UpdateDatabaseDdlRequest.newBuilder()
            .setDatabase(database)
            .addAllStatements(statements)
            .build();
    return updateDatabaseDdlAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the schema of a Cloud Spanner database by creating/altering/dropping tables, columns,
   * indexes, etc. The returned [long-running operation][google.longrunning.Operation] will have a
   * name of the format `&lt;database_name&gt;/operations/&lt;operation_id&gt;` and can be used to
   * track execution of the schema change(s). The [metadata][google.longrunning.Operation.metadata]
   * field type is
   * [UpdateDatabaseDdlMetadata][google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata]. The
   * operation has no response.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   UpdateDatabaseDdlRequest request =
   *       UpdateDatabaseDdlRequest.newBuilder()
   *           .setDatabase(DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]").toString())
   *           .addAllStatements(new ArrayList<String>())
   *           .setOperationId("operationId129704162")
   *           .setProtoDescriptors(ByteString.EMPTY)
   *           .setThroughputMode(true)
   *           .build();
   *   databaseAdminClient.updateDatabaseDdlAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, UpdateDatabaseDdlMetadata> updateDatabaseDdlAsync(
      UpdateDatabaseDdlRequest request) {
    return updateDatabaseDdlOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the schema of a Cloud Spanner database by creating/altering/dropping tables, columns,
   * indexes, etc. The returned [long-running operation][google.longrunning.Operation] will have a
   * name of the format `&lt;database_name&gt;/operations/&lt;operation_id&gt;` and can be used to
   * track execution of the schema change(s). The [metadata][google.longrunning.Operation.metadata]
   * field type is
   * [UpdateDatabaseDdlMetadata][google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata]. The
   * operation has no response.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   UpdateDatabaseDdlRequest request =
   *       UpdateDatabaseDdlRequest.newBuilder()
   *           .setDatabase(DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]").toString())
   *           .addAllStatements(new ArrayList<String>())
   *           .setOperationId("operationId129704162")
   *           .setProtoDescriptors(ByteString.EMPTY)
   *           .setThroughputMode(true)
   *           .build();
   *   OperationFuture<Empty, UpdateDatabaseDdlMetadata> future =
   *       databaseAdminClient.updateDatabaseDdlOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateDatabaseDdlRequest, Empty, UpdateDatabaseDdlMetadata>
      updateDatabaseDdlOperationCallable() {
    return stub.updateDatabaseDdlOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the schema of a Cloud Spanner database by creating/altering/dropping tables, columns,
   * indexes, etc. The returned [long-running operation][google.longrunning.Operation] will have a
   * name of the format `&lt;database_name&gt;/operations/&lt;operation_id&gt;` and can be used to
   * track execution of the schema change(s). The [metadata][google.longrunning.Operation.metadata]
   * field type is
   * [UpdateDatabaseDdlMetadata][google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata]. The
   * operation has no response.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   UpdateDatabaseDdlRequest request =
   *       UpdateDatabaseDdlRequest.newBuilder()
   *           .setDatabase(DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]").toString())
   *           .addAllStatements(new ArrayList<String>())
   *           .setOperationId("operationId129704162")
   *           .setProtoDescriptors(ByteString.EMPTY)
   *           .setThroughputMode(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       databaseAdminClient.updateDatabaseDdlCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateDatabaseDdlRequest, Operation> updateDatabaseDdlCallable() {
    return stub.updateDatabaseDdlCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Drops (aka deletes) a Cloud Spanner database. Completed backups for the database will be
   * retained according to their `expire_time`. Note: Cloud Spanner might continue to accept
   * requests for a few seconds after the database has been deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   DatabaseName database = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]");
   *   databaseAdminClient.dropDatabase(database);
   * }
   * }</pre>
   *
   * @param database Required. The database to be dropped.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void dropDatabase(DatabaseName database) {
    DropDatabaseRequest request =
        DropDatabaseRequest.newBuilder()
            .setDatabase(database == null ? null : database.toString())
            .build();
    dropDatabase(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Drops (aka deletes) a Cloud Spanner database. Completed backups for the database will be
   * retained according to their `expire_time`. Note: Cloud Spanner might continue to accept
   * requests for a few seconds after the database has been deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   String database = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]").toString();
   *   databaseAdminClient.dropDatabase(database);
   * }
   * }</pre>
   *
   * @param database Required. The database to be dropped.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void dropDatabase(String database) {
    DropDatabaseRequest request = DropDatabaseRequest.newBuilder().setDatabase(database).build();
    dropDatabase(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Drops (aka deletes) a Cloud Spanner database. Completed backups for the database will be
   * retained according to their `expire_time`. Note: Cloud Spanner might continue to accept
   * requests for a few seconds after the database has been deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   DropDatabaseRequest request =
   *       DropDatabaseRequest.newBuilder()
   *           .setDatabase(DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]").toString())
   *           .build();
   *   databaseAdminClient.dropDatabase(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void dropDatabase(DropDatabaseRequest request) {
    dropDatabaseCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Drops (aka deletes) a Cloud Spanner database. Completed backups for the database will be
   * retained according to their `expire_time`. Note: Cloud Spanner might continue to accept
   * requests for a few seconds after the database has been deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   DropDatabaseRequest request =
   *       DropDatabaseRequest.newBuilder()
   *           .setDatabase(DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]").toString())
   *           .build();
   *   ApiFuture<Empty> future = databaseAdminClient.dropDatabaseCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DropDatabaseRequest, Empty> dropDatabaseCallable() {
    return stub.dropDatabaseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the schema of a Cloud Spanner database as a list of formatted DDL statements. This
   * method does not show pending schema updates, those may be queried using the
   * [Operations][google.longrunning.Operations] API.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   DatabaseName database = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]");
   *   GetDatabaseDdlResponse response = databaseAdminClient.getDatabaseDdl(database);
   * }
   * }</pre>
   *
   * @param database Required. The database whose schema we wish to get. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/databases/&lt;database&gt;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GetDatabaseDdlResponse getDatabaseDdl(DatabaseName database) {
    GetDatabaseDdlRequest request =
        GetDatabaseDdlRequest.newBuilder()
            .setDatabase(database == null ? null : database.toString())
            .build();
    return getDatabaseDdl(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the schema of a Cloud Spanner database as a list of formatted DDL statements. This
   * method does not show pending schema updates, those may be queried using the
   * [Operations][google.longrunning.Operations] API.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   String database = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]").toString();
   *   GetDatabaseDdlResponse response = databaseAdminClient.getDatabaseDdl(database);
   * }
   * }</pre>
   *
   * @param database Required. The database whose schema we wish to get. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/databases/&lt;database&gt;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GetDatabaseDdlResponse getDatabaseDdl(String database) {
    GetDatabaseDdlRequest request =
        GetDatabaseDdlRequest.newBuilder().setDatabase(database).build();
    return getDatabaseDdl(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the schema of a Cloud Spanner database as a list of formatted DDL statements. This
   * method does not show pending schema updates, those may be queried using the
   * [Operations][google.longrunning.Operations] API.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   GetDatabaseDdlRequest request =
   *       GetDatabaseDdlRequest.newBuilder()
   *           .setDatabase(DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]").toString())
   *           .build();
   *   GetDatabaseDdlResponse response = databaseAdminClient.getDatabaseDdl(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GetDatabaseDdlResponse getDatabaseDdl(GetDatabaseDdlRequest request) {
    return getDatabaseDdlCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the schema of a Cloud Spanner database as a list of formatted DDL statements. This
   * method does not show pending schema updates, those may be queried using the
   * [Operations][google.longrunning.Operations] API.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   GetDatabaseDdlRequest request =
   *       GetDatabaseDdlRequest.newBuilder()
   *           .setDatabase(DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]").toString())
   *           .build();
   *   ApiFuture<GetDatabaseDdlResponse> future =
   *       databaseAdminClient.getDatabaseDdlCallable().futureCall(request);
   *   // Do something.
   *   GetDatabaseDdlResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDatabaseDdlRequest, GetDatabaseDdlResponse>
      getDatabaseDdlCallable() {
    return stub.getDatabaseDdlCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on a database or backup resource. Replaces any existing policy.
   *
   * <p>Authorization requires `spanner.databases.setIamPolicy` permission on
   * [resource][google.iam.v1.SetIamPolicyRequest.resource]. For backups, authorization requires
   * `spanner.backups.setIamPolicy` permission on
   * [resource][google.iam.v1.SetIamPolicyRequest.resource].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   ResourceName resource = BackupName.of("[PROJECT]", "[INSTANCE]", "[BACKUP]");
   *   Policy policy = Policy.newBuilder().build();
   *   Policy response = databaseAdminClient.setIamPolicy(resource, policy);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being specified. See the
   *     operation documentation for the appropriate value for this field.
   * @param policy REQUIRED: The complete policy to be applied to the `resource`. The size of the
   *     policy is limited to a few 10s of KB. An empty policy is a valid policy but certain Cloud
   *     Platform services (such as Projects) might reject them.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(ResourceName resource, Policy policy) {
    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .setPolicy(policy)
            .build();
    return setIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on a database or backup resource. Replaces any existing policy.
   *
   * <p>Authorization requires `spanner.databases.setIamPolicy` permission on
   * [resource][google.iam.v1.SetIamPolicyRequest.resource]. For backups, authorization requires
   * `spanner.backups.setIamPolicy` permission on
   * [resource][google.iam.v1.SetIamPolicyRequest.resource].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   String resource = BackupName.of("[PROJECT]", "[INSTANCE]", "[BACKUP]").toString();
   *   Policy policy = Policy.newBuilder().build();
   *   Policy response = databaseAdminClient.setIamPolicy(resource, policy);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being specified. See the
   *     operation documentation for the appropriate value for this field.
   * @param policy REQUIRED: The complete policy to be applied to the `resource`. The size of the
   *     policy is limited to a few 10s of KB. An empty policy is a valid policy but certain Cloud
   *     Platform services (such as Projects) might reject them.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(String resource, Policy policy) {
    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder().setResource(resource).setPolicy(policy).build();
    return setIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on a database or backup resource. Replaces any existing policy.
   *
   * <p>Authorization requires `spanner.databases.setIamPolicy` permission on
   * [resource][google.iam.v1.SetIamPolicyRequest.resource]. For backups, authorization requires
   * `spanner.backups.setIamPolicy` permission on
   * [resource][google.iam.v1.SetIamPolicyRequest.resource].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(BackupName.of("[PROJECT]", "[INSTANCE]", "[BACKUP]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = databaseAdminClient.setIamPolicy(request);
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
   * Sets the access control policy on a database or backup resource. Replaces any existing policy.
   *
   * <p>Authorization requires `spanner.databases.setIamPolicy` permission on
   * [resource][google.iam.v1.SetIamPolicyRequest.resource]. For backups, authorization requires
   * `spanner.backups.setIamPolicy` permission on
   * [resource][google.iam.v1.SetIamPolicyRequest.resource].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(BackupName.of("[PROJECT]", "[INSTANCE]", "[BACKUP]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = databaseAdminClient.setIamPolicyCallable().futureCall(request);
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
   * Gets the access control policy for a database or backup resource. Returns an empty policy if a
   * database or backup exists but does not have a policy set.
   *
   * <p>Authorization requires `spanner.databases.getIamPolicy` permission on
   * [resource][google.iam.v1.GetIamPolicyRequest.resource]. For backups, authorization requires
   * `spanner.backups.getIamPolicy` permission on
   * [resource][google.iam.v1.GetIamPolicyRequest.resource].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   ResourceName resource = BackupName.of("[PROJECT]", "[INSTANCE]", "[BACKUP]");
   *   Policy response = databaseAdminClient.getIamPolicy(resource);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(ResourceName resource) {
    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .build();
    return getIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a database or backup resource. Returns an empty policy if a
   * database or backup exists but does not have a policy set.
   *
   * <p>Authorization requires `spanner.databases.getIamPolicy` permission on
   * [resource][google.iam.v1.GetIamPolicyRequest.resource]. For backups, authorization requires
   * `spanner.backups.getIamPolicy` permission on
   * [resource][google.iam.v1.GetIamPolicyRequest.resource].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   String resource = BackupName.of("[PROJECT]", "[INSTANCE]", "[BACKUP]").toString();
   *   Policy response = databaseAdminClient.getIamPolicy(resource);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(String resource) {
    GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder().setResource(resource).build();
    return getIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a database or backup resource. Returns an empty policy if a
   * database or backup exists but does not have a policy set.
   *
   * <p>Authorization requires `spanner.databases.getIamPolicy` permission on
   * [resource][google.iam.v1.GetIamPolicyRequest.resource]. For backups, authorization requires
   * `spanner.backups.getIamPolicy` permission on
   * [resource][google.iam.v1.GetIamPolicyRequest.resource].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(BackupName.of("[PROJECT]", "[INSTANCE]", "[BACKUP]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = databaseAdminClient.getIamPolicy(request);
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
   * Gets the access control policy for a database or backup resource. Returns an empty policy if a
   * database or backup exists but does not have a policy set.
   *
   * <p>Authorization requires `spanner.databases.getIamPolicy` permission on
   * [resource][google.iam.v1.GetIamPolicyRequest.resource]. For backups, authorization requires
   * `spanner.backups.getIamPolicy` permission on
   * [resource][google.iam.v1.GetIamPolicyRequest.resource].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(BackupName.of("[PROJECT]", "[INSTANCE]", "[BACKUP]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = databaseAdminClient.getIamPolicyCallable().futureCall(request);
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
   * Returns permissions that the caller has on the specified database or backup resource.
   *
   * <p>Attempting this RPC on a non-existent Cloud Spanner database will result in a NOT_FOUND
   * error if the user has `spanner.databases.list` permission on the containing Cloud Spanner
   * instance. Otherwise returns an empty set of permissions. Calling this method on a backup that
   * does not exist will result in a NOT_FOUND error if the user has `spanner.backups.list`
   * permission on the containing instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   ResourceName resource = BackupName.of("[PROJECT]", "[INSTANCE]", "[BACKUP]");
   *   List<String> permissions = new ArrayList<>();
   *   TestIamPermissionsResponse response =
   *       databaseAdminClient.testIamPermissions(resource, permissions);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy detail is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @param permissions The set of permissions to check for the `resource`. Permissions with
   *     wildcards (such as '&#42;' or 'storage.&#42;') are not allowed. For more information see
   *     [IAM Overview](https://cloud.google.com/iam/docs/overview#permissions).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(
      ResourceName resource, List<String> permissions) {
    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .addAllPermissions(permissions)
            .build();
    return testIamPermissions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that the caller has on the specified database or backup resource.
   *
   * <p>Attempting this RPC on a non-existent Cloud Spanner database will result in a NOT_FOUND
   * error if the user has `spanner.databases.list` permission on the containing Cloud Spanner
   * instance. Otherwise returns an empty set of permissions. Calling this method on a backup that
   * does not exist will result in a NOT_FOUND error if the user has `spanner.backups.list`
   * permission on the containing instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   String resource = BackupName.of("[PROJECT]", "[INSTANCE]", "[BACKUP]").toString();
   *   List<String> permissions = new ArrayList<>();
   *   TestIamPermissionsResponse response =
   *       databaseAdminClient.testIamPermissions(resource, permissions);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy detail is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @param permissions The set of permissions to check for the `resource`. Permissions with
   *     wildcards (such as '&#42;' or 'storage.&#42;') are not allowed. For more information see
   *     [IAM Overview](https://cloud.google.com/iam/docs/overview#permissions).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(
      String resource, List<String> permissions) {
    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(resource)
            .addAllPermissions(permissions)
            .build();
    return testIamPermissions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that the caller has on the specified database or backup resource.
   *
   * <p>Attempting this RPC on a non-existent Cloud Spanner database will result in a NOT_FOUND
   * error if the user has `spanner.databases.list` permission on the containing Cloud Spanner
   * instance. Otherwise returns an empty set of permissions. Calling this method on a backup that
   * does not exist will result in a NOT_FOUND error if the user has `spanner.backups.list`
   * permission on the containing instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(BackupName.of("[PROJECT]", "[INSTANCE]", "[BACKUP]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = databaseAdminClient.testIamPermissions(request);
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
   * Returns permissions that the caller has on the specified database or backup resource.
   *
   * <p>Attempting this RPC on a non-existent Cloud Spanner database will result in a NOT_FOUND
   * error if the user has `spanner.databases.list` permission on the containing Cloud Spanner
   * instance. Otherwise returns an empty set of permissions. Calling this method on a backup that
   * does not exist will result in a NOT_FOUND error if the user has `spanner.backups.list`
   * permission on the containing instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(BackupName.of("[PROJECT]", "[INSTANCE]", "[BACKUP]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       databaseAdminClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something.
   *   TestIamPermissionsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return stub.testIamPermissionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts creating a new Cloud Spanner Backup. The returned backup [long-running
   * operation][google.longrunning.Operation] will have a name of the format
   * `projects/&lt;project&gt;/instances/&lt;instance&gt;/backups/&lt;backup&gt;/operations/&lt;operation_id&gt;`
   * and can be used to track creation of the backup. The
   * [metadata][google.longrunning.Operation.metadata] field type is
   * [CreateBackupMetadata][google.spanner.admin.database.v1.CreateBackupMetadata]. The
   * [response][google.longrunning.Operation.response] field type is
   * [Backup][google.spanner.admin.database.v1.Backup], if successful. Cancelling the returned
   * operation will stop the creation and delete the backup. There can be only one pending backup
   * creation per database. Backup creation of different databases can run concurrently.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   Backup backup = Backup.newBuilder().build();
   *   String backupId = "backupId2121930365";
   *   Backup response = databaseAdminClient.createBackupAsync(parent, backup, backupId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The name of the instance in which the backup will be created. This must
   *     be the same instance that contains the database the backup will be created from. The backup
   *     will be stored in the location(s) specified in the instance configuration of this instance.
   *     Values are of the form `projects/&lt;project&gt;/instances/&lt;instance&gt;`.
   * @param backup Required. The backup to create.
   * @param backupId Required. The id of the backup to be created. The `backup_id` appended to
   *     `parent` forms the full backup name of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/backups/&lt;backup_id&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Backup, CreateBackupMetadata> createBackupAsync(
      InstanceName parent, Backup backup, String backupId) {
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
   * Starts creating a new Cloud Spanner Backup. The returned backup [long-running
   * operation][google.longrunning.Operation] will have a name of the format
   * `projects/&lt;project&gt;/instances/&lt;instance&gt;/backups/&lt;backup&gt;/operations/&lt;operation_id&gt;`
   * and can be used to track creation of the backup. The
   * [metadata][google.longrunning.Operation.metadata] field type is
   * [CreateBackupMetadata][google.spanner.admin.database.v1.CreateBackupMetadata]. The
   * [response][google.longrunning.Operation.response] field type is
   * [Backup][google.spanner.admin.database.v1.Backup], if successful. Cancelling the returned
   * operation will stop the creation and delete the backup. There can be only one pending backup
   * creation per database. Backup creation of different databases can run concurrently.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   String parent = InstanceName.of("[PROJECT]", "[INSTANCE]").toString();
   *   Backup backup = Backup.newBuilder().build();
   *   String backupId = "backupId2121930365";
   *   Backup response = databaseAdminClient.createBackupAsync(parent, backup, backupId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The name of the instance in which the backup will be created. This must
   *     be the same instance that contains the database the backup will be created from. The backup
   *     will be stored in the location(s) specified in the instance configuration of this instance.
   *     Values are of the form `projects/&lt;project&gt;/instances/&lt;instance&gt;`.
   * @param backup Required. The backup to create.
   * @param backupId Required. The id of the backup to be created. The `backup_id` appended to
   *     `parent` forms the full backup name of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/backups/&lt;backup_id&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Backup, CreateBackupMetadata> createBackupAsync(
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
   * Starts creating a new Cloud Spanner Backup. The returned backup [long-running
   * operation][google.longrunning.Operation] will have a name of the format
   * `projects/&lt;project&gt;/instances/&lt;instance&gt;/backups/&lt;backup&gt;/operations/&lt;operation_id&gt;`
   * and can be used to track creation of the backup. The
   * [metadata][google.longrunning.Operation.metadata] field type is
   * [CreateBackupMetadata][google.spanner.admin.database.v1.CreateBackupMetadata]. The
   * [response][google.longrunning.Operation.response] field type is
   * [Backup][google.spanner.admin.database.v1.Backup], if successful. Cancelling the returned
   * operation will stop the creation and delete the backup. There can be only one pending backup
   * creation per database. Backup creation of different databases can run concurrently.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   CreateBackupRequest request =
   *       CreateBackupRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
   *           .setBackupId("backupId2121930365")
   *           .setBackup(Backup.newBuilder().build())
   *           .setEncryptionConfig(CreateBackupEncryptionConfig.newBuilder().build())
   *           .build();
   *   Backup response = databaseAdminClient.createBackupAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Backup, CreateBackupMetadata> createBackupAsync(
      CreateBackupRequest request) {
    return createBackupOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts creating a new Cloud Spanner Backup. The returned backup [long-running
   * operation][google.longrunning.Operation] will have a name of the format
   * `projects/&lt;project&gt;/instances/&lt;instance&gt;/backups/&lt;backup&gt;/operations/&lt;operation_id&gt;`
   * and can be used to track creation of the backup. The
   * [metadata][google.longrunning.Operation.metadata] field type is
   * [CreateBackupMetadata][google.spanner.admin.database.v1.CreateBackupMetadata]. The
   * [response][google.longrunning.Operation.response] field type is
   * [Backup][google.spanner.admin.database.v1.Backup], if successful. Cancelling the returned
   * operation will stop the creation and delete the backup. There can be only one pending backup
   * creation per database. Backup creation of different databases can run concurrently.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   CreateBackupRequest request =
   *       CreateBackupRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
   *           .setBackupId("backupId2121930365")
   *           .setBackup(Backup.newBuilder().build())
   *           .setEncryptionConfig(CreateBackupEncryptionConfig.newBuilder().build())
   *           .build();
   *   OperationFuture<Backup, CreateBackupMetadata> future =
   *       databaseAdminClient.createBackupOperationCallable().futureCall(request);
   *   // Do something.
   *   Backup response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateBackupRequest, Backup, CreateBackupMetadata>
      createBackupOperationCallable() {
    return stub.createBackupOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts creating a new Cloud Spanner Backup. The returned backup [long-running
   * operation][google.longrunning.Operation] will have a name of the format
   * `projects/&lt;project&gt;/instances/&lt;instance&gt;/backups/&lt;backup&gt;/operations/&lt;operation_id&gt;`
   * and can be used to track creation of the backup. The
   * [metadata][google.longrunning.Operation.metadata] field type is
   * [CreateBackupMetadata][google.spanner.admin.database.v1.CreateBackupMetadata]. The
   * [response][google.longrunning.Operation.response] field type is
   * [Backup][google.spanner.admin.database.v1.Backup], if successful. Cancelling the returned
   * operation will stop the creation and delete the backup. There can be only one pending backup
   * creation per database. Backup creation of different databases can run concurrently.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   CreateBackupRequest request =
   *       CreateBackupRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
   *           .setBackupId("backupId2121930365")
   *           .setBackup(Backup.newBuilder().build())
   *           .setEncryptionConfig(CreateBackupEncryptionConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = databaseAdminClient.createBackupCallable().futureCall(request);
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
   * Starts copying a Cloud Spanner Backup. The returned backup [long-running
   * operation][google.longrunning.Operation] will have a name of the format
   * `projects/&lt;project&gt;/instances/&lt;instance&gt;/backups/&lt;backup&gt;/operations/&lt;operation_id&gt;`
   * and can be used to track copying of the backup. The operation is associated with the
   * destination backup. The [metadata][google.longrunning.Operation.metadata] field type is
   * [CopyBackupMetadata][google.spanner.admin.database.v1.CopyBackupMetadata]. The
   * [response][google.longrunning.Operation.response] field type is
   * [Backup][google.spanner.admin.database.v1.Backup], if successful. Cancelling the returned
   * operation will stop the copying and delete the destination backup. Concurrent CopyBackup
   * requests can run on the same source backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   String backupId = "backupId2121930365";
   *   BackupName sourceBackup = BackupName.of("[PROJECT]", "[INSTANCE]", "[BACKUP]");
   *   Timestamp expireTime = Timestamp.newBuilder().build();
   *   Backup response =
   *       databaseAdminClient.copyBackupAsync(parent, backupId, sourceBackup, expireTime).get();
   * }
   * }</pre>
   *
   * @param parent Required. The name of the destination instance that will contain the backup copy.
   *     Values are of the form: `projects/&lt;project&gt;/instances/&lt;instance&gt;`.
   * @param backupId Required. The id of the backup copy. The `backup_id` appended to `parent` forms
   *     the full backup_uri of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/backups/&lt;backup&gt;`.
   * @param sourceBackup Required. The source backup to be copied. The source backup needs to be in
   *     READY state for it to be copied. Once CopyBackup is in progress, the source backup cannot
   *     be deleted or cleaned up on expiration until CopyBackup is finished. Values are of the
   *     form: `projects/&lt;project&gt;/instances/&lt;instance&gt;/backups/&lt;backup&gt;`.
   * @param expireTime Required. The expiration time of the backup in microsecond granularity. The
   *     expiration time must be at least 6 hours and at most 366 days from the `create_time` of the
   *     source backup. Once the `expire_time` has passed, the backup is eligible to be
   *     automatically deleted by Cloud Spanner to free the resources used by the backup.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Backup, CopyBackupMetadata> copyBackupAsync(
      InstanceName parent, String backupId, BackupName sourceBackup, Timestamp expireTime) {
    CopyBackupRequest request =
        CopyBackupRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setBackupId(backupId)
            .setSourceBackup(sourceBackup == null ? null : sourceBackup.toString())
            .setExpireTime(expireTime)
            .build();
    return copyBackupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts copying a Cloud Spanner Backup. The returned backup [long-running
   * operation][google.longrunning.Operation] will have a name of the format
   * `projects/&lt;project&gt;/instances/&lt;instance&gt;/backups/&lt;backup&gt;/operations/&lt;operation_id&gt;`
   * and can be used to track copying of the backup. The operation is associated with the
   * destination backup. The [metadata][google.longrunning.Operation.metadata] field type is
   * [CopyBackupMetadata][google.spanner.admin.database.v1.CopyBackupMetadata]. The
   * [response][google.longrunning.Operation.response] field type is
   * [Backup][google.spanner.admin.database.v1.Backup], if successful. Cancelling the returned
   * operation will stop the copying and delete the destination backup. Concurrent CopyBackup
   * requests can run on the same source backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   String backupId = "backupId2121930365";
   *   String sourceBackup = BackupName.of("[PROJECT]", "[INSTANCE]", "[BACKUP]").toString();
   *   Timestamp expireTime = Timestamp.newBuilder().build();
   *   Backup response =
   *       databaseAdminClient.copyBackupAsync(parent, backupId, sourceBackup, expireTime).get();
   * }
   * }</pre>
   *
   * @param parent Required. The name of the destination instance that will contain the backup copy.
   *     Values are of the form: `projects/&lt;project&gt;/instances/&lt;instance&gt;`.
   * @param backupId Required. The id of the backup copy. The `backup_id` appended to `parent` forms
   *     the full backup_uri of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/backups/&lt;backup&gt;`.
   * @param sourceBackup Required. The source backup to be copied. The source backup needs to be in
   *     READY state for it to be copied. Once CopyBackup is in progress, the source backup cannot
   *     be deleted or cleaned up on expiration until CopyBackup is finished. Values are of the
   *     form: `projects/&lt;project&gt;/instances/&lt;instance&gt;/backups/&lt;backup&gt;`.
   * @param expireTime Required. The expiration time of the backup in microsecond granularity. The
   *     expiration time must be at least 6 hours and at most 366 days from the `create_time` of the
   *     source backup. Once the `expire_time` has passed, the backup is eligible to be
   *     automatically deleted by Cloud Spanner to free the resources used by the backup.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Backup, CopyBackupMetadata> copyBackupAsync(
      InstanceName parent, String backupId, String sourceBackup, Timestamp expireTime) {
    CopyBackupRequest request =
        CopyBackupRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setBackupId(backupId)
            .setSourceBackup(sourceBackup)
            .setExpireTime(expireTime)
            .build();
    return copyBackupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts copying a Cloud Spanner Backup. The returned backup [long-running
   * operation][google.longrunning.Operation] will have a name of the format
   * `projects/&lt;project&gt;/instances/&lt;instance&gt;/backups/&lt;backup&gt;/operations/&lt;operation_id&gt;`
   * and can be used to track copying of the backup. The operation is associated with the
   * destination backup. The [metadata][google.longrunning.Operation.metadata] field type is
   * [CopyBackupMetadata][google.spanner.admin.database.v1.CopyBackupMetadata]. The
   * [response][google.longrunning.Operation.response] field type is
   * [Backup][google.spanner.admin.database.v1.Backup], if successful. Cancelling the returned
   * operation will stop the copying and delete the destination backup. Concurrent CopyBackup
   * requests can run on the same source backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   String parent = InstanceName.of("[PROJECT]", "[INSTANCE]").toString();
   *   String backupId = "backupId2121930365";
   *   BackupName sourceBackup = BackupName.of("[PROJECT]", "[INSTANCE]", "[BACKUP]");
   *   Timestamp expireTime = Timestamp.newBuilder().build();
   *   Backup response =
   *       databaseAdminClient.copyBackupAsync(parent, backupId, sourceBackup, expireTime).get();
   * }
   * }</pre>
   *
   * @param parent Required. The name of the destination instance that will contain the backup copy.
   *     Values are of the form: `projects/&lt;project&gt;/instances/&lt;instance&gt;`.
   * @param backupId Required. The id of the backup copy. The `backup_id` appended to `parent` forms
   *     the full backup_uri of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/backups/&lt;backup&gt;`.
   * @param sourceBackup Required. The source backup to be copied. The source backup needs to be in
   *     READY state for it to be copied. Once CopyBackup is in progress, the source backup cannot
   *     be deleted or cleaned up on expiration until CopyBackup is finished. Values are of the
   *     form: `projects/&lt;project&gt;/instances/&lt;instance&gt;/backups/&lt;backup&gt;`.
   * @param expireTime Required. The expiration time of the backup in microsecond granularity. The
   *     expiration time must be at least 6 hours and at most 366 days from the `create_time` of the
   *     source backup. Once the `expire_time` has passed, the backup is eligible to be
   *     automatically deleted by Cloud Spanner to free the resources used by the backup.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Backup, CopyBackupMetadata> copyBackupAsync(
      String parent, String backupId, BackupName sourceBackup, Timestamp expireTime) {
    CopyBackupRequest request =
        CopyBackupRequest.newBuilder()
            .setParent(parent)
            .setBackupId(backupId)
            .setSourceBackup(sourceBackup == null ? null : sourceBackup.toString())
            .setExpireTime(expireTime)
            .build();
    return copyBackupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts copying a Cloud Spanner Backup. The returned backup [long-running
   * operation][google.longrunning.Operation] will have a name of the format
   * `projects/&lt;project&gt;/instances/&lt;instance&gt;/backups/&lt;backup&gt;/operations/&lt;operation_id&gt;`
   * and can be used to track copying of the backup. The operation is associated with the
   * destination backup. The [metadata][google.longrunning.Operation.metadata] field type is
   * [CopyBackupMetadata][google.spanner.admin.database.v1.CopyBackupMetadata]. The
   * [response][google.longrunning.Operation.response] field type is
   * [Backup][google.spanner.admin.database.v1.Backup], if successful. Cancelling the returned
   * operation will stop the copying and delete the destination backup. Concurrent CopyBackup
   * requests can run on the same source backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   String parent = InstanceName.of("[PROJECT]", "[INSTANCE]").toString();
   *   String backupId = "backupId2121930365";
   *   String sourceBackup = BackupName.of("[PROJECT]", "[INSTANCE]", "[BACKUP]").toString();
   *   Timestamp expireTime = Timestamp.newBuilder().build();
   *   Backup response =
   *       databaseAdminClient.copyBackupAsync(parent, backupId, sourceBackup, expireTime).get();
   * }
   * }</pre>
   *
   * @param parent Required. The name of the destination instance that will contain the backup copy.
   *     Values are of the form: `projects/&lt;project&gt;/instances/&lt;instance&gt;`.
   * @param backupId Required. The id of the backup copy. The `backup_id` appended to `parent` forms
   *     the full backup_uri of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/backups/&lt;backup&gt;`.
   * @param sourceBackup Required. The source backup to be copied. The source backup needs to be in
   *     READY state for it to be copied. Once CopyBackup is in progress, the source backup cannot
   *     be deleted or cleaned up on expiration until CopyBackup is finished. Values are of the
   *     form: `projects/&lt;project&gt;/instances/&lt;instance&gt;/backups/&lt;backup&gt;`.
   * @param expireTime Required. The expiration time of the backup in microsecond granularity. The
   *     expiration time must be at least 6 hours and at most 366 days from the `create_time` of the
   *     source backup. Once the `expire_time` has passed, the backup is eligible to be
   *     automatically deleted by Cloud Spanner to free the resources used by the backup.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Backup, CopyBackupMetadata> copyBackupAsync(
      String parent, String backupId, String sourceBackup, Timestamp expireTime) {
    CopyBackupRequest request =
        CopyBackupRequest.newBuilder()
            .setParent(parent)
            .setBackupId(backupId)
            .setSourceBackup(sourceBackup)
            .setExpireTime(expireTime)
            .build();
    return copyBackupAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts copying a Cloud Spanner Backup. The returned backup [long-running
   * operation][google.longrunning.Operation] will have a name of the format
   * `projects/&lt;project&gt;/instances/&lt;instance&gt;/backups/&lt;backup&gt;/operations/&lt;operation_id&gt;`
   * and can be used to track copying of the backup. The operation is associated with the
   * destination backup. The [metadata][google.longrunning.Operation.metadata] field type is
   * [CopyBackupMetadata][google.spanner.admin.database.v1.CopyBackupMetadata]. The
   * [response][google.longrunning.Operation.response] field type is
   * [Backup][google.spanner.admin.database.v1.Backup], if successful. Cancelling the returned
   * operation will stop the copying and delete the destination backup. Concurrent CopyBackup
   * requests can run on the same source backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   CopyBackupRequest request =
   *       CopyBackupRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
   *           .setBackupId("backupId2121930365")
   *           .setSourceBackup(BackupName.of("[PROJECT]", "[INSTANCE]", "[BACKUP]").toString())
   *           .setExpireTime(Timestamp.newBuilder().build())
   *           .setEncryptionConfig(CopyBackupEncryptionConfig.newBuilder().build())
   *           .build();
   *   Backup response = databaseAdminClient.copyBackupAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Backup, CopyBackupMetadata> copyBackupAsync(
      CopyBackupRequest request) {
    return copyBackupOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts copying a Cloud Spanner Backup. The returned backup [long-running
   * operation][google.longrunning.Operation] will have a name of the format
   * `projects/&lt;project&gt;/instances/&lt;instance&gt;/backups/&lt;backup&gt;/operations/&lt;operation_id&gt;`
   * and can be used to track copying of the backup. The operation is associated with the
   * destination backup. The [metadata][google.longrunning.Operation.metadata] field type is
   * [CopyBackupMetadata][google.spanner.admin.database.v1.CopyBackupMetadata]. The
   * [response][google.longrunning.Operation.response] field type is
   * [Backup][google.spanner.admin.database.v1.Backup], if successful. Cancelling the returned
   * operation will stop the copying and delete the destination backup. Concurrent CopyBackup
   * requests can run on the same source backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   CopyBackupRequest request =
   *       CopyBackupRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
   *           .setBackupId("backupId2121930365")
   *           .setSourceBackup(BackupName.of("[PROJECT]", "[INSTANCE]", "[BACKUP]").toString())
   *           .setExpireTime(Timestamp.newBuilder().build())
   *           .setEncryptionConfig(CopyBackupEncryptionConfig.newBuilder().build())
   *           .build();
   *   OperationFuture<Backup, CopyBackupMetadata> future =
   *       databaseAdminClient.copyBackupOperationCallable().futureCall(request);
   *   // Do something.
   *   Backup response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CopyBackupRequest, Backup, CopyBackupMetadata>
      copyBackupOperationCallable() {
    return stub.copyBackupOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts copying a Cloud Spanner Backup. The returned backup [long-running
   * operation][google.longrunning.Operation] will have a name of the format
   * `projects/&lt;project&gt;/instances/&lt;instance&gt;/backups/&lt;backup&gt;/operations/&lt;operation_id&gt;`
   * and can be used to track copying of the backup. The operation is associated with the
   * destination backup. The [metadata][google.longrunning.Operation.metadata] field type is
   * [CopyBackupMetadata][google.spanner.admin.database.v1.CopyBackupMetadata]. The
   * [response][google.longrunning.Operation.response] field type is
   * [Backup][google.spanner.admin.database.v1.Backup], if successful. Cancelling the returned
   * operation will stop the copying and delete the destination backup. Concurrent CopyBackup
   * requests can run on the same source backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   CopyBackupRequest request =
   *       CopyBackupRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
   *           .setBackupId("backupId2121930365")
   *           .setSourceBackup(BackupName.of("[PROJECT]", "[INSTANCE]", "[BACKUP]").toString())
   *           .setExpireTime(Timestamp.newBuilder().build())
   *           .setEncryptionConfig(CopyBackupEncryptionConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = databaseAdminClient.copyBackupCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CopyBackupRequest, Operation> copyBackupCallable() {
    return stub.copyBackupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets metadata on a pending or completed [Backup][google.spanner.admin.database.v1.Backup].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   BackupName name = BackupName.of("[PROJECT]", "[INSTANCE]", "[BACKUP]");
   *   Backup response = databaseAdminClient.getBackup(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the backup. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/backups/&lt;backup&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Backup getBackup(BackupName name) {
    GetBackupRequest request =
        GetBackupRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getBackup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets metadata on a pending or completed [Backup][google.spanner.admin.database.v1.Backup].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   String name = BackupName.of("[PROJECT]", "[INSTANCE]", "[BACKUP]").toString();
   *   Backup response = databaseAdminClient.getBackup(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the backup. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/backups/&lt;backup&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Backup getBackup(String name) {
    GetBackupRequest request = GetBackupRequest.newBuilder().setName(name).build();
    return getBackup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets metadata on a pending or completed [Backup][google.spanner.admin.database.v1.Backup].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   GetBackupRequest request =
   *       GetBackupRequest.newBuilder()
   *           .setName(BackupName.of("[PROJECT]", "[INSTANCE]", "[BACKUP]").toString())
   *           .build();
   *   Backup response = databaseAdminClient.getBackup(request);
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
   * Gets metadata on a pending or completed [Backup][google.spanner.admin.database.v1.Backup].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   GetBackupRequest request =
   *       GetBackupRequest.newBuilder()
   *           .setName(BackupName.of("[PROJECT]", "[INSTANCE]", "[BACKUP]").toString())
   *           .build();
   *   ApiFuture<Backup> future = databaseAdminClient.getBackupCallable().futureCall(request);
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
   * Updates a pending or completed [Backup][google.spanner.admin.database.v1.Backup].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   Backup backup = Backup.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Backup response = databaseAdminClient.updateBackup(backup, updateMask);
   * }
   * }</pre>
   *
   * @param backup Required. The backup to update. `backup.name`, and the fields to be updated as
   *     specified by `update_mask` are required. Other fields are ignored. Update is only supported
   *     for the following fields: &#42; `backup.expire_time`.
   * @param updateMask Required. A mask specifying which fields (e.g. `expire_time`) in the Backup
   *     resource should be updated. This mask is relative to the Backup resource, not to the
   *     request message. The field mask must always be specified; this prevents any future fields
   *     from being erased accidentally by clients that do not know about them.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Backup updateBackup(Backup backup, FieldMask updateMask) {
    UpdateBackupRequest request =
        UpdateBackupRequest.newBuilder().setBackup(backup).setUpdateMask(updateMask).build();
    return updateBackup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a pending or completed [Backup][google.spanner.admin.database.v1.Backup].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   UpdateBackupRequest request =
   *       UpdateBackupRequest.newBuilder()
   *           .setBackup(Backup.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Backup response = databaseAdminClient.updateBackup(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Backup updateBackup(UpdateBackupRequest request) {
    return updateBackupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a pending or completed [Backup][google.spanner.admin.database.v1.Backup].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   UpdateBackupRequest request =
   *       UpdateBackupRequest.newBuilder()
   *           .setBackup(Backup.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Backup> future = databaseAdminClient.updateBackupCallable().futureCall(request);
   *   // Do something.
   *   Backup response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateBackupRequest, Backup> updateBackupCallable() {
    return stub.updateBackupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a pending or completed [Backup][google.spanner.admin.database.v1.Backup].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   BackupName name = BackupName.of("[PROJECT]", "[INSTANCE]", "[BACKUP]");
   *   databaseAdminClient.deleteBackup(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the backup to delete. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/backups/&lt;backup&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteBackup(BackupName name) {
    DeleteBackupRequest request =
        DeleteBackupRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteBackup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a pending or completed [Backup][google.spanner.admin.database.v1.Backup].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   String name = BackupName.of("[PROJECT]", "[INSTANCE]", "[BACKUP]").toString();
   *   databaseAdminClient.deleteBackup(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the backup to delete. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/backups/&lt;backup&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteBackup(String name) {
    DeleteBackupRequest request = DeleteBackupRequest.newBuilder().setName(name).build();
    deleteBackup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a pending or completed [Backup][google.spanner.admin.database.v1.Backup].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   DeleteBackupRequest request =
   *       DeleteBackupRequest.newBuilder()
   *           .setName(BackupName.of("[PROJECT]", "[INSTANCE]", "[BACKUP]").toString())
   *           .build();
   *   databaseAdminClient.deleteBackup(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteBackup(DeleteBackupRequest request) {
    deleteBackupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a pending or completed [Backup][google.spanner.admin.database.v1.Backup].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   DeleteBackupRequest request =
   *       DeleteBackupRequest.newBuilder()
   *           .setName(BackupName.of("[PROJECT]", "[INSTANCE]", "[BACKUP]").toString())
   *           .build();
   *   ApiFuture<Empty> future = databaseAdminClient.deleteBackupCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteBackupRequest, Empty> deleteBackupCallable() {
    return stub.deleteBackupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists completed and pending backups. Backups returned are ordered by `create_time` in
   * descending order, starting from the most recent `create_time`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   for (Backup element : databaseAdminClient.listBackups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The instance to list backups from. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupsPagedResponse listBackups(InstanceName parent) {
    ListBackupsRequest request =
        ListBackupsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listBackups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists completed and pending backups. Backups returned are ordered by `create_time` in
   * descending order, starting from the most recent `create_time`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   String parent = InstanceName.of("[PROJECT]", "[INSTANCE]").toString();
   *   for (Backup element : databaseAdminClient.listBackups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The instance to list backups from. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupsPagedResponse listBackups(String parent) {
    ListBackupsRequest request = ListBackupsRequest.newBuilder().setParent(parent).build();
    return listBackups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists completed and pending backups. Backups returned are ordered by `create_time` in
   * descending order, starting from the most recent `create_time`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   ListBackupsRequest request =
   *       ListBackupsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Backup element : databaseAdminClient.listBackups(request).iterateAll()) {
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
   * Lists completed and pending backups. Backups returned are ordered by `create_time` in
   * descending order, starting from the most recent `create_time`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   ListBackupsRequest request =
   *       ListBackupsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Backup> future = databaseAdminClient.listBackupsPagedCallable().futureCall(request);
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
   * Lists completed and pending backups. Backups returned are ordered by `create_time` in
   * descending order, starting from the most recent `create_time`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   ListBackupsRequest request =
   *       ListBackupsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListBackupsResponse response = databaseAdminClient.listBackupsCallable().call(request);
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
   * Create a new database by restoring from a completed backup. The new database must be in the
   * same project and in an instance with the same instance configuration as the instance containing
   * the backup. The returned database [long-running operation][google.longrunning.Operation] has a
   * name of the format
   * `projects/&lt;project&gt;/instances/&lt;instance&gt;/databases/&lt;database&gt;/operations/&lt;operation_id&gt;`,
   * and can be used to track the progress of the operation, and to cancel it. The
   * [metadata][google.longrunning.Operation.metadata] field type is
   * [RestoreDatabaseMetadata][google.spanner.admin.database.v1.RestoreDatabaseMetadata]. The
   * [response][google.longrunning.Operation.response] type is
   * [Database][google.spanner.admin.database.v1.Database], if successful. Cancelling the returned
   * operation will stop the restore and delete the database. There can be only one database being
   * restored into an instance at a time. Once the restore operation completes, a new restore
   * operation can be initiated, without waiting for the optimize operation associated with the
   * first restore to complete.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   String databaseId = "databaseId1688905718";
   *   BackupName backup = BackupName.of("[PROJECT]", "[INSTANCE]", "[BACKUP]");
   *   Database response =
   *       databaseAdminClient.restoreDatabaseAsync(parent, databaseId, backup).get();
   * }
   * }</pre>
   *
   * @param parent Required. The name of the instance in which to create the restored database. This
   *     instance must be in the same project and have the same instance configuration as the
   *     instance containing the source backup. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;`.
   * @param databaseId Required. The id of the database to create and restore to. This database must
   *     not already exist. The `database_id` appended to `parent` forms the full database name of
   *     the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/databases/&lt;database_id&gt;`.
   * @param backup Name of the backup from which to restore. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/backups/&lt;backup&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Database, RestoreDatabaseMetadata> restoreDatabaseAsync(
      InstanceName parent, String databaseId, BackupName backup) {
    RestoreDatabaseRequest request =
        RestoreDatabaseRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDatabaseId(databaseId)
            .setBackup(backup == null ? null : backup.toString())
            .build();
    return restoreDatabaseAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new database by restoring from a completed backup. The new database must be in the
   * same project and in an instance with the same instance configuration as the instance containing
   * the backup. The returned database [long-running operation][google.longrunning.Operation] has a
   * name of the format
   * `projects/&lt;project&gt;/instances/&lt;instance&gt;/databases/&lt;database&gt;/operations/&lt;operation_id&gt;`,
   * and can be used to track the progress of the operation, and to cancel it. The
   * [metadata][google.longrunning.Operation.metadata] field type is
   * [RestoreDatabaseMetadata][google.spanner.admin.database.v1.RestoreDatabaseMetadata]. The
   * [response][google.longrunning.Operation.response] type is
   * [Database][google.spanner.admin.database.v1.Database], if successful. Cancelling the returned
   * operation will stop the restore and delete the database. There can be only one database being
   * restored into an instance at a time. Once the restore operation completes, a new restore
   * operation can be initiated, without waiting for the optimize operation associated with the
   * first restore to complete.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   String databaseId = "databaseId1688905718";
   *   String backup = BackupName.of("[PROJECT]", "[INSTANCE]", "[BACKUP]").toString();
   *   Database response =
   *       databaseAdminClient.restoreDatabaseAsync(parent, databaseId, backup).get();
   * }
   * }</pre>
   *
   * @param parent Required. The name of the instance in which to create the restored database. This
   *     instance must be in the same project and have the same instance configuration as the
   *     instance containing the source backup. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;`.
   * @param databaseId Required. The id of the database to create and restore to. This database must
   *     not already exist. The `database_id` appended to `parent` forms the full database name of
   *     the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/databases/&lt;database_id&gt;`.
   * @param backup Name of the backup from which to restore. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/backups/&lt;backup&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Database, RestoreDatabaseMetadata> restoreDatabaseAsync(
      InstanceName parent, String databaseId, String backup) {
    RestoreDatabaseRequest request =
        RestoreDatabaseRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDatabaseId(databaseId)
            .setBackup(backup)
            .build();
    return restoreDatabaseAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new database by restoring from a completed backup. The new database must be in the
   * same project and in an instance with the same instance configuration as the instance containing
   * the backup. The returned database [long-running operation][google.longrunning.Operation] has a
   * name of the format
   * `projects/&lt;project&gt;/instances/&lt;instance&gt;/databases/&lt;database&gt;/operations/&lt;operation_id&gt;`,
   * and can be used to track the progress of the operation, and to cancel it. The
   * [metadata][google.longrunning.Operation.metadata] field type is
   * [RestoreDatabaseMetadata][google.spanner.admin.database.v1.RestoreDatabaseMetadata]. The
   * [response][google.longrunning.Operation.response] type is
   * [Database][google.spanner.admin.database.v1.Database], if successful. Cancelling the returned
   * operation will stop the restore and delete the database. There can be only one database being
   * restored into an instance at a time. Once the restore operation completes, a new restore
   * operation can be initiated, without waiting for the optimize operation associated with the
   * first restore to complete.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   String parent = InstanceName.of("[PROJECT]", "[INSTANCE]").toString();
   *   String databaseId = "databaseId1688905718";
   *   BackupName backup = BackupName.of("[PROJECT]", "[INSTANCE]", "[BACKUP]");
   *   Database response =
   *       databaseAdminClient.restoreDatabaseAsync(parent, databaseId, backup).get();
   * }
   * }</pre>
   *
   * @param parent Required. The name of the instance in which to create the restored database. This
   *     instance must be in the same project and have the same instance configuration as the
   *     instance containing the source backup. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;`.
   * @param databaseId Required. The id of the database to create and restore to. This database must
   *     not already exist. The `database_id` appended to `parent` forms the full database name of
   *     the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/databases/&lt;database_id&gt;`.
   * @param backup Name of the backup from which to restore. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/backups/&lt;backup&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Database, RestoreDatabaseMetadata> restoreDatabaseAsync(
      String parent, String databaseId, BackupName backup) {
    RestoreDatabaseRequest request =
        RestoreDatabaseRequest.newBuilder()
            .setParent(parent)
            .setDatabaseId(databaseId)
            .setBackup(backup == null ? null : backup.toString())
            .build();
    return restoreDatabaseAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new database by restoring from a completed backup. The new database must be in the
   * same project and in an instance with the same instance configuration as the instance containing
   * the backup. The returned database [long-running operation][google.longrunning.Operation] has a
   * name of the format
   * `projects/&lt;project&gt;/instances/&lt;instance&gt;/databases/&lt;database&gt;/operations/&lt;operation_id&gt;`,
   * and can be used to track the progress of the operation, and to cancel it. The
   * [metadata][google.longrunning.Operation.metadata] field type is
   * [RestoreDatabaseMetadata][google.spanner.admin.database.v1.RestoreDatabaseMetadata]. The
   * [response][google.longrunning.Operation.response] type is
   * [Database][google.spanner.admin.database.v1.Database], if successful. Cancelling the returned
   * operation will stop the restore and delete the database. There can be only one database being
   * restored into an instance at a time. Once the restore operation completes, a new restore
   * operation can be initiated, without waiting for the optimize operation associated with the
   * first restore to complete.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   String parent = InstanceName.of("[PROJECT]", "[INSTANCE]").toString();
   *   String databaseId = "databaseId1688905718";
   *   String backup = BackupName.of("[PROJECT]", "[INSTANCE]", "[BACKUP]").toString();
   *   Database response =
   *       databaseAdminClient.restoreDatabaseAsync(parent, databaseId, backup).get();
   * }
   * }</pre>
   *
   * @param parent Required. The name of the instance in which to create the restored database. This
   *     instance must be in the same project and have the same instance configuration as the
   *     instance containing the source backup. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;`.
   * @param databaseId Required. The id of the database to create and restore to. This database must
   *     not already exist. The `database_id` appended to `parent` forms the full database name of
   *     the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/databases/&lt;database_id&gt;`.
   * @param backup Name of the backup from which to restore. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/backups/&lt;backup&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Database, RestoreDatabaseMetadata> restoreDatabaseAsync(
      String parent, String databaseId, String backup) {
    RestoreDatabaseRequest request =
        RestoreDatabaseRequest.newBuilder()
            .setParent(parent)
            .setDatabaseId(databaseId)
            .setBackup(backup)
            .build();
    return restoreDatabaseAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new database by restoring from a completed backup. The new database must be in the
   * same project and in an instance with the same instance configuration as the instance containing
   * the backup. The returned database [long-running operation][google.longrunning.Operation] has a
   * name of the format
   * `projects/&lt;project&gt;/instances/&lt;instance&gt;/databases/&lt;database&gt;/operations/&lt;operation_id&gt;`,
   * and can be used to track the progress of the operation, and to cancel it. The
   * [metadata][google.longrunning.Operation.metadata] field type is
   * [RestoreDatabaseMetadata][google.spanner.admin.database.v1.RestoreDatabaseMetadata]. The
   * [response][google.longrunning.Operation.response] type is
   * [Database][google.spanner.admin.database.v1.Database], if successful. Cancelling the returned
   * operation will stop the restore and delete the database. There can be only one database being
   * restored into an instance at a time. Once the restore operation completes, a new restore
   * operation can be initiated, without waiting for the optimize operation associated with the
   * first restore to complete.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   RestoreDatabaseRequest request =
   *       RestoreDatabaseRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
   *           .setDatabaseId("databaseId1688905718")
   *           .setEncryptionConfig(RestoreDatabaseEncryptionConfig.newBuilder().build())
   *           .build();
   *   Database response = databaseAdminClient.restoreDatabaseAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Database, RestoreDatabaseMetadata> restoreDatabaseAsync(
      RestoreDatabaseRequest request) {
    return restoreDatabaseOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new database by restoring from a completed backup. The new database must be in the
   * same project and in an instance with the same instance configuration as the instance containing
   * the backup. The returned database [long-running operation][google.longrunning.Operation] has a
   * name of the format
   * `projects/&lt;project&gt;/instances/&lt;instance&gt;/databases/&lt;database&gt;/operations/&lt;operation_id&gt;`,
   * and can be used to track the progress of the operation, and to cancel it. The
   * [metadata][google.longrunning.Operation.metadata] field type is
   * [RestoreDatabaseMetadata][google.spanner.admin.database.v1.RestoreDatabaseMetadata]. The
   * [response][google.longrunning.Operation.response] type is
   * [Database][google.spanner.admin.database.v1.Database], if successful. Cancelling the returned
   * operation will stop the restore and delete the database. There can be only one database being
   * restored into an instance at a time. Once the restore operation completes, a new restore
   * operation can be initiated, without waiting for the optimize operation associated with the
   * first restore to complete.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   RestoreDatabaseRequest request =
   *       RestoreDatabaseRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
   *           .setDatabaseId("databaseId1688905718")
   *           .setEncryptionConfig(RestoreDatabaseEncryptionConfig.newBuilder().build())
   *           .build();
   *   OperationFuture<Database, RestoreDatabaseMetadata> future =
   *       databaseAdminClient.restoreDatabaseOperationCallable().futureCall(request);
   *   // Do something.
   *   Database response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<RestoreDatabaseRequest, Database, RestoreDatabaseMetadata>
      restoreDatabaseOperationCallable() {
    return stub.restoreDatabaseOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new database by restoring from a completed backup. The new database must be in the
   * same project and in an instance with the same instance configuration as the instance containing
   * the backup. The returned database [long-running operation][google.longrunning.Operation] has a
   * name of the format
   * `projects/&lt;project&gt;/instances/&lt;instance&gt;/databases/&lt;database&gt;/operations/&lt;operation_id&gt;`,
   * and can be used to track the progress of the operation, and to cancel it. The
   * [metadata][google.longrunning.Operation.metadata] field type is
   * [RestoreDatabaseMetadata][google.spanner.admin.database.v1.RestoreDatabaseMetadata]. The
   * [response][google.longrunning.Operation.response] type is
   * [Database][google.spanner.admin.database.v1.Database], if successful. Cancelling the returned
   * operation will stop the restore and delete the database. There can be only one database being
   * restored into an instance at a time. Once the restore operation completes, a new restore
   * operation can be initiated, without waiting for the optimize operation associated with the
   * first restore to complete.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   RestoreDatabaseRequest request =
   *       RestoreDatabaseRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
   *           .setDatabaseId("databaseId1688905718")
   *           .setEncryptionConfig(RestoreDatabaseEncryptionConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       databaseAdminClient.restoreDatabaseCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RestoreDatabaseRequest, Operation> restoreDatabaseCallable() {
    return stub.restoreDatabaseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists database [longrunning-operations][google.longrunning.Operation]. A database operation has
   * a name of the form
   * `projects/&lt;project&gt;/instances/&lt;instance&gt;/databases/&lt;database&gt;/operations/&lt;operation&gt;`.
   * The long-running operation [metadata][google.longrunning.Operation.metadata] field type
   * `metadata.type_url` describes the type of the metadata. Operations returned include those that
   * have completed/failed/canceled within the last 7 days, and pending operations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   for (Operation element : databaseAdminClient.listDatabaseOperations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The instance of the database operations. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDatabaseOperationsPagedResponse listDatabaseOperations(InstanceName parent) {
    ListDatabaseOperationsRequest request =
        ListDatabaseOperationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDatabaseOperations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists database [longrunning-operations][google.longrunning.Operation]. A database operation has
   * a name of the form
   * `projects/&lt;project&gt;/instances/&lt;instance&gt;/databases/&lt;database&gt;/operations/&lt;operation&gt;`.
   * The long-running operation [metadata][google.longrunning.Operation.metadata] field type
   * `metadata.type_url` describes the type of the metadata. Operations returned include those that
   * have completed/failed/canceled within the last 7 days, and pending operations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   String parent = InstanceName.of("[PROJECT]", "[INSTANCE]").toString();
   *   for (Operation element : databaseAdminClient.listDatabaseOperations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The instance of the database operations. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDatabaseOperationsPagedResponse listDatabaseOperations(String parent) {
    ListDatabaseOperationsRequest request =
        ListDatabaseOperationsRequest.newBuilder().setParent(parent).build();
    return listDatabaseOperations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists database [longrunning-operations][google.longrunning.Operation]. A database operation has
   * a name of the form
   * `projects/&lt;project&gt;/instances/&lt;instance&gt;/databases/&lt;database&gt;/operations/&lt;operation&gt;`.
   * The long-running operation [metadata][google.longrunning.Operation.metadata] field type
   * `metadata.type_url` describes the type of the metadata. Operations returned include those that
   * have completed/failed/canceled within the last 7 days, and pending operations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   ListDatabaseOperationsRequest request =
   *       ListDatabaseOperationsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Operation element : databaseAdminClient.listDatabaseOperations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDatabaseOperationsPagedResponse listDatabaseOperations(
      ListDatabaseOperationsRequest request) {
    return listDatabaseOperationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists database [longrunning-operations][google.longrunning.Operation]. A database operation has
   * a name of the form
   * `projects/&lt;project&gt;/instances/&lt;instance&gt;/databases/&lt;database&gt;/operations/&lt;operation&gt;`.
   * The long-running operation [metadata][google.longrunning.Operation.metadata] field type
   * `metadata.type_url` describes the type of the metadata. Operations returned include those that
   * have completed/failed/canceled within the last 7 days, and pending operations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   ListDatabaseOperationsRequest request =
   *       ListDatabaseOperationsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Operation> future =
   *       databaseAdminClient.listDatabaseOperationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Operation element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDatabaseOperationsRequest, ListDatabaseOperationsPagedResponse>
      listDatabaseOperationsPagedCallable() {
    return stub.listDatabaseOperationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists database [longrunning-operations][google.longrunning.Operation]. A database operation has
   * a name of the form
   * `projects/&lt;project&gt;/instances/&lt;instance&gt;/databases/&lt;database&gt;/operations/&lt;operation&gt;`.
   * The long-running operation [metadata][google.longrunning.Operation.metadata] field type
   * `metadata.type_url` describes the type of the metadata. Operations returned include those that
   * have completed/failed/canceled within the last 7 days, and pending operations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   ListDatabaseOperationsRequest request =
   *       ListDatabaseOperationsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListDatabaseOperationsResponse response =
   *         databaseAdminClient.listDatabaseOperationsCallable().call(request);
   *     for (Operation element : response.getOperationsList()) {
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
  public final UnaryCallable<ListDatabaseOperationsRequest, ListDatabaseOperationsResponse>
      listDatabaseOperationsCallable() {
    return stub.listDatabaseOperationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the backup [long-running operations][google.longrunning.Operation] in the given instance.
   * A backup operation has a name of the form
   * `projects/&lt;project&gt;/instances/&lt;instance&gt;/backups/&lt;backup&gt;/operations/&lt;operation&gt;`.
   * The long-running operation [metadata][google.longrunning.Operation.metadata] field type
   * `metadata.type_url` describes the type of the metadata. Operations returned include those that
   * have completed/failed/canceled within the last 7 days, and pending operations. Operations
   * returned are ordered by `operation.metadata.value.progress.start_time` in descending order
   * starting from the most recently started operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[INSTANCE]");
   *   for (Operation element : databaseAdminClient.listBackupOperations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The instance of the backup operations. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupOperationsPagedResponse listBackupOperations(InstanceName parent) {
    ListBackupOperationsRequest request =
        ListBackupOperationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listBackupOperations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the backup [long-running operations][google.longrunning.Operation] in the given instance.
   * A backup operation has a name of the form
   * `projects/&lt;project&gt;/instances/&lt;instance&gt;/backups/&lt;backup&gt;/operations/&lt;operation&gt;`.
   * The long-running operation [metadata][google.longrunning.Operation.metadata] field type
   * `metadata.type_url` describes the type of the metadata. Operations returned include those that
   * have completed/failed/canceled within the last 7 days, and pending operations. Operations
   * returned are ordered by `operation.metadata.value.progress.start_time` in descending order
   * starting from the most recently started operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   String parent = InstanceName.of("[PROJECT]", "[INSTANCE]").toString();
   *   for (Operation element : databaseAdminClient.listBackupOperations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The instance of the backup operations. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupOperationsPagedResponse listBackupOperations(String parent) {
    ListBackupOperationsRequest request =
        ListBackupOperationsRequest.newBuilder().setParent(parent).build();
    return listBackupOperations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the backup [long-running operations][google.longrunning.Operation] in the given instance.
   * A backup operation has a name of the form
   * `projects/&lt;project&gt;/instances/&lt;instance&gt;/backups/&lt;backup&gt;/operations/&lt;operation&gt;`.
   * The long-running operation [metadata][google.longrunning.Operation.metadata] field type
   * `metadata.type_url` describes the type of the metadata. Operations returned include those that
   * have completed/failed/canceled within the last 7 days, and pending operations. Operations
   * returned are ordered by `operation.metadata.value.progress.start_time` in descending order
   * starting from the most recently started operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   ListBackupOperationsRequest request =
   *       ListBackupOperationsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Operation element : databaseAdminClient.listBackupOperations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupOperationsPagedResponse listBackupOperations(
      ListBackupOperationsRequest request) {
    return listBackupOperationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the backup [long-running operations][google.longrunning.Operation] in the given instance.
   * A backup operation has a name of the form
   * `projects/&lt;project&gt;/instances/&lt;instance&gt;/backups/&lt;backup&gt;/operations/&lt;operation&gt;`.
   * The long-running operation [metadata][google.longrunning.Operation.metadata] field type
   * `metadata.type_url` describes the type of the metadata. Operations returned include those that
   * have completed/failed/canceled within the last 7 days, and pending operations. Operations
   * returned are ordered by `operation.metadata.value.progress.start_time` in descending order
   * starting from the most recently started operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   ListBackupOperationsRequest request =
   *       ListBackupOperationsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Operation> future =
   *       databaseAdminClient.listBackupOperationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Operation element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListBackupOperationsRequest, ListBackupOperationsPagedResponse>
      listBackupOperationsPagedCallable() {
    return stub.listBackupOperationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the backup [long-running operations][google.longrunning.Operation] in the given instance.
   * A backup operation has a name of the form
   * `projects/&lt;project&gt;/instances/&lt;instance&gt;/backups/&lt;backup&gt;/operations/&lt;operation&gt;`.
   * The long-running operation [metadata][google.longrunning.Operation.metadata] field type
   * `metadata.type_url` describes the type of the metadata. Operations returned include those that
   * have completed/failed/canceled within the last 7 days, and pending operations. Operations
   * returned are ordered by `operation.metadata.value.progress.start_time` in descending order
   * starting from the most recently started operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   ListBackupOperationsRequest request =
   *       ListBackupOperationsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[INSTANCE]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListBackupOperationsResponse response =
   *         databaseAdminClient.listBackupOperationsCallable().call(request);
   *     for (Operation element : response.getOperationsList()) {
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
  public final UnaryCallable<ListBackupOperationsRequest, ListBackupOperationsResponse>
      listBackupOperationsCallable() {
    return stub.listBackupOperationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Cloud Spanner database roles.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   DatabaseName parent = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]");
   *   for (DatabaseRole element : databaseAdminClient.listDatabaseRoles(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The database whose roles should be listed. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/databases/&lt;database&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDatabaseRolesPagedResponse listDatabaseRoles(DatabaseName parent) {
    ListDatabaseRolesRequest request =
        ListDatabaseRolesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDatabaseRoles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Cloud Spanner database roles.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   String parent = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]").toString();
   *   for (DatabaseRole element : databaseAdminClient.listDatabaseRoles(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The database whose roles should be listed. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/databases/&lt;database&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDatabaseRolesPagedResponse listDatabaseRoles(String parent) {
    ListDatabaseRolesRequest request =
        ListDatabaseRolesRequest.newBuilder().setParent(parent).build();
    return listDatabaseRoles(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Cloud Spanner database roles.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   ListDatabaseRolesRequest request =
   *       ListDatabaseRolesRequest.newBuilder()
   *           .setParent(DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (DatabaseRole element : databaseAdminClient.listDatabaseRoles(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDatabaseRolesPagedResponse listDatabaseRoles(ListDatabaseRolesRequest request) {
    return listDatabaseRolesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Cloud Spanner database roles.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   ListDatabaseRolesRequest request =
   *       ListDatabaseRolesRequest.newBuilder()
   *           .setParent(DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<DatabaseRole> future =
   *       databaseAdminClient.listDatabaseRolesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (DatabaseRole element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDatabaseRolesRequest, ListDatabaseRolesPagedResponse>
      listDatabaseRolesPagedCallable() {
    return stub.listDatabaseRolesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Cloud Spanner database roles.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   ListDatabaseRolesRequest request =
   *       ListDatabaseRolesRequest.newBuilder()
   *           .setParent(DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListDatabaseRolesResponse response =
   *         databaseAdminClient.listDatabaseRolesCallable().call(request);
   *     for (DatabaseRole element : response.getDatabaseRolesList()) {
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
  public final UnaryCallable<ListDatabaseRolesRequest, ListDatabaseRolesResponse>
      listDatabaseRolesCallable() {
    return stub.listDatabaseRolesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds split points to specified tables, indexes of a database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   DatabaseName database = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]");
   *   List<SplitPoints> splitPoints = new ArrayList<>();
   *   AddSplitPointsResponse response = databaseAdminClient.addSplitPoints(database, splitPoints);
   * }
   * }</pre>
   *
   * @param database Required. The database on whose tables/indexes split points are to be added.
   *     Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/databases/&lt;database&gt;`.
   * @param splitPoints Required. The split points to add.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AddSplitPointsResponse addSplitPoints(
      DatabaseName database, List<SplitPoints> splitPoints) {
    AddSplitPointsRequest request =
        AddSplitPointsRequest.newBuilder()
            .setDatabase(database == null ? null : database.toString())
            .addAllSplitPoints(splitPoints)
            .build();
    return addSplitPoints(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds split points to specified tables, indexes of a database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   String database = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]").toString();
   *   List<SplitPoints> splitPoints = new ArrayList<>();
   *   AddSplitPointsResponse response = databaseAdminClient.addSplitPoints(database, splitPoints);
   * }
   * }</pre>
   *
   * @param database Required. The database on whose tables/indexes split points are to be added.
   *     Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/databases/&lt;database&gt;`.
   * @param splitPoints Required. The split points to add.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AddSplitPointsResponse addSplitPoints(
      String database, List<SplitPoints> splitPoints) {
    AddSplitPointsRequest request =
        AddSplitPointsRequest.newBuilder()
            .setDatabase(database)
            .addAllSplitPoints(splitPoints)
            .build();
    return addSplitPoints(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds split points to specified tables, indexes of a database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   AddSplitPointsRequest request =
   *       AddSplitPointsRequest.newBuilder()
   *           .setDatabase(DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]").toString())
   *           .addAllSplitPoints(new ArrayList<SplitPoints>())
   *           .setInitiator("initiator-248987089")
   *           .build();
   *   AddSplitPointsResponse response = databaseAdminClient.addSplitPoints(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AddSplitPointsResponse addSplitPoints(AddSplitPointsRequest request) {
    return addSplitPointsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds split points to specified tables, indexes of a database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   AddSplitPointsRequest request =
   *       AddSplitPointsRequest.newBuilder()
   *           .setDatabase(DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]").toString())
   *           .addAllSplitPoints(new ArrayList<SplitPoints>())
   *           .setInitiator("initiator-248987089")
   *           .build();
   *   ApiFuture<AddSplitPointsResponse> future =
   *       databaseAdminClient.addSplitPointsCallable().futureCall(request);
   *   // Do something.
   *   AddSplitPointsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AddSplitPointsRequest, AddSplitPointsResponse>
      addSplitPointsCallable() {
    return stub.addSplitPointsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new backup schedule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   DatabaseName parent = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]");
   *   BackupSchedule backupSchedule = BackupSchedule.newBuilder().build();
   *   String backupScheduleId = "backupScheduleId1704974708";
   *   BackupSchedule response =
   *       databaseAdminClient.createBackupSchedule(parent, backupSchedule, backupScheduleId);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the database that this backup schedule applies to.
   * @param backupSchedule Required. The backup schedule to create.
   * @param backupScheduleId Required. The Id to use for the backup schedule. The
   *     `backup_schedule_id` appended to `parent` forms the full backup schedule name of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/databases/&lt;database&gt;/backupSchedules/&lt;backup_schedule_id&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BackupSchedule createBackupSchedule(
      DatabaseName parent, BackupSchedule backupSchedule, String backupScheduleId) {
    CreateBackupScheduleRequest request =
        CreateBackupScheduleRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setBackupSchedule(backupSchedule)
            .setBackupScheduleId(backupScheduleId)
            .build();
    return createBackupSchedule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new backup schedule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   String parent = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]").toString();
   *   BackupSchedule backupSchedule = BackupSchedule.newBuilder().build();
   *   String backupScheduleId = "backupScheduleId1704974708";
   *   BackupSchedule response =
   *       databaseAdminClient.createBackupSchedule(parent, backupSchedule, backupScheduleId);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the database that this backup schedule applies to.
   * @param backupSchedule Required. The backup schedule to create.
   * @param backupScheduleId Required. The Id to use for the backup schedule. The
   *     `backup_schedule_id` appended to `parent` forms the full backup schedule name of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/databases/&lt;database&gt;/backupSchedules/&lt;backup_schedule_id&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BackupSchedule createBackupSchedule(
      String parent, BackupSchedule backupSchedule, String backupScheduleId) {
    CreateBackupScheduleRequest request =
        CreateBackupScheduleRequest.newBuilder()
            .setParent(parent)
            .setBackupSchedule(backupSchedule)
            .setBackupScheduleId(backupScheduleId)
            .build();
    return createBackupSchedule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new backup schedule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   CreateBackupScheduleRequest request =
   *       CreateBackupScheduleRequest.newBuilder()
   *           .setParent(DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]").toString())
   *           .setBackupScheduleId("backupScheduleId1704974708")
   *           .setBackupSchedule(BackupSchedule.newBuilder().build())
   *           .build();
   *   BackupSchedule response = databaseAdminClient.createBackupSchedule(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BackupSchedule createBackupSchedule(CreateBackupScheduleRequest request) {
    return createBackupScheduleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new backup schedule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   CreateBackupScheduleRequest request =
   *       CreateBackupScheduleRequest.newBuilder()
   *           .setParent(DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]").toString())
   *           .setBackupScheduleId("backupScheduleId1704974708")
   *           .setBackupSchedule(BackupSchedule.newBuilder().build())
   *           .build();
   *   ApiFuture<BackupSchedule> future =
   *       databaseAdminClient.createBackupScheduleCallable().futureCall(request);
   *   // Do something.
   *   BackupSchedule response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateBackupScheduleRequest, BackupSchedule>
      createBackupScheduleCallable() {
    return stub.createBackupScheduleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets backup schedule for the input schedule name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   BackupScheduleName name =
   *       BackupScheduleName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]", "[SCHEDULE]");
   *   BackupSchedule response = databaseAdminClient.getBackupSchedule(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the schedule to retrieve. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/databases/&lt;database&gt;/backupSchedules/&lt;backup_schedule_id&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BackupSchedule getBackupSchedule(BackupScheduleName name) {
    GetBackupScheduleRequest request =
        GetBackupScheduleRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getBackupSchedule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets backup schedule for the input schedule name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   String name =
   *       BackupScheduleName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]", "[SCHEDULE]").toString();
   *   BackupSchedule response = databaseAdminClient.getBackupSchedule(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the schedule to retrieve. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/databases/&lt;database&gt;/backupSchedules/&lt;backup_schedule_id&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BackupSchedule getBackupSchedule(String name) {
    GetBackupScheduleRequest request = GetBackupScheduleRequest.newBuilder().setName(name).build();
    return getBackupSchedule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets backup schedule for the input schedule name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   GetBackupScheduleRequest request =
   *       GetBackupScheduleRequest.newBuilder()
   *           .setName(
   *               BackupScheduleName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]", "[SCHEDULE]")
   *                   .toString())
   *           .build();
   *   BackupSchedule response = databaseAdminClient.getBackupSchedule(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BackupSchedule getBackupSchedule(GetBackupScheduleRequest request) {
    return getBackupScheduleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets backup schedule for the input schedule name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   GetBackupScheduleRequest request =
   *       GetBackupScheduleRequest.newBuilder()
   *           .setName(
   *               BackupScheduleName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]", "[SCHEDULE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<BackupSchedule> future =
   *       databaseAdminClient.getBackupScheduleCallable().futureCall(request);
   *   // Do something.
   *   BackupSchedule response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetBackupScheduleRequest, BackupSchedule> getBackupScheduleCallable() {
    return stub.getBackupScheduleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a backup schedule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   BackupSchedule backupSchedule = BackupSchedule.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   BackupSchedule response =
   *       databaseAdminClient.updateBackupSchedule(backupSchedule, updateMask);
   * }
   * }</pre>
   *
   * @param backupSchedule Required. The backup schedule to update. `backup_schedule.name`, and the
   *     fields to be updated as specified by `update_mask` are required. Other fields are ignored.
   * @param updateMask Required. A mask specifying which fields in the BackupSchedule resource
   *     should be updated. This mask is relative to the BackupSchedule resource, not to the request
   *     message. The field mask must always be specified; this prevents any future fields from
   *     being erased accidentally.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BackupSchedule updateBackupSchedule(
      BackupSchedule backupSchedule, FieldMask updateMask) {
    UpdateBackupScheduleRequest request =
        UpdateBackupScheduleRequest.newBuilder()
            .setBackupSchedule(backupSchedule)
            .setUpdateMask(updateMask)
            .build();
    return updateBackupSchedule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a backup schedule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   UpdateBackupScheduleRequest request =
   *       UpdateBackupScheduleRequest.newBuilder()
   *           .setBackupSchedule(BackupSchedule.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   BackupSchedule response = databaseAdminClient.updateBackupSchedule(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BackupSchedule updateBackupSchedule(UpdateBackupScheduleRequest request) {
    return updateBackupScheduleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a backup schedule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   UpdateBackupScheduleRequest request =
   *       UpdateBackupScheduleRequest.newBuilder()
   *           .setBackupSchedule(BackupSchedule.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<BackupSchedule> future =
   *       databaseAdminClient.updateBackupScheduleCallable().futureCall(request);
   *   // Do something.
   *   BackupSchedule response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateBackupScheduleRequest, BackupSchedule>
      updateBackupScheduleCallable() {
    return stub.updateBackupScheduleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a backup schedule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   BackupScheduleName name =
   *       BackupScheduleName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]", "[SCHEDULE]");
   *   databaseAdminClient.deleteBackupSchedule(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the schedule to delete. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/databases/&lt;database&gt;/backupSchedules/&lt;backup_schedule_id&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteBackupSchedule(BackupScheduleName name) {
    DeleteBackupScheduleRequest request =
        DeleteBackupScheduleRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteBackupSchedule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a backup schedule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   String name =
   *       BackupScheduleName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]", "[SCHEDULE]").toString();
   *   databaseAdminClient.deleteBackupSchedule(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the schedule to delete. Values are of the form
   *     `projects/&lt;project&gt;/instances/&lt;instance&gt;/databases/&lt;database&gt;/backupSchedules/&lt;backup_schedule_id&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteBackupSchedule(String name) {
    DeleteBackupScheduleRequest request =
        DeleteBackupScheduleRequest.newBuilder().setName(name).build();
    deleteBackupSchedule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a backup schedule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   DeleteBackupScheduleRequest request =
   *       DeleteBackupScheduleRequest.newBuilder()
   *           .setName(
   *               BackupScheduleName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]", "[SCHEDULE]")
   *                   .toString())
   *           .build();
   *   databaseAdminClient.deleteBackupSchedule(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteBackupSchedule(DeleteBackupScheduleRequest request) {
    deleteBackupScheduleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a backup schedule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   DeleteBackupScheduleRequest request =
   *       DeleteBackupScheduleRequest.newBuilder()
   *           .setName(
   *               BackupScheduleName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]", "[SCHEDULE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       databaseAdminClient.deleteBackupScheduleCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteBackupScheduleRequest, Empty> deleteBackupScheduleCallable() {
    return stub.deleteBackupScheduleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the backup schedules for the database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   DatabaseName parent = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]");
   *   for (BackupSchedule element : databaseAdminClient.listBackupSchedules(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Database is the parent resource whose backup schedules should be
   *     listed. Values are of the form
   *     projects/&lt;project&gt;/instances/&lt;instance&gt;/databases/&lt;database&gt;
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupSchedulesPagedResponse listBackupSchedules(DatabaseName parent) {
    ListBackupSchedulesRequest request =
        ListBackupSchedulesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listBackupSchedules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the backup schedules for the database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   String parent = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]").toString();
   *   for (BackupSchedule element : databaseAdminClient.listBackupSchedules(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Database is the parent resource whose backup schedules should be
   *     listed. Values are of the form
   *     projects/&lt;project&gt;/instances/&lt;instance&gt;/databases/&lt;database&gt;
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupSchedulesPagedResponse listBackupSchedules(String parent) {
    ListBackupSchedulesRequest request =
        ListBackupSchedulesRequest.newBuilder().setParent(parent).build();
    return listBackupSchedules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the backup schedules for the database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   ListBackupSchedulesRequest request =
   *       ListBackupSchedulesRequest.newBuilder()
   *           .setParent(DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (BackupSchedule element : databaseAdminClient.listBackupSchedules(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupSchedulesPagedResponse listBackupSchedules(
      ListBackupSchedulesRequest request) {
    return listBackupSchedulesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the backup schedules for the database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   ListBackupSchedulesRequest request =
   *       ListBackupSchedulesRequest.newBuilder()
   *           .setParent(DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<BackupSchedule> future =
   *       databaseAdminClient.listBackupSchedulesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (BackupSchedule element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListBackupSchedulesRequest, ListBackupSchedulesPagedResponse>
      listBackupSchedulesPagedCallable() {
    return stub.listBackupSchedulesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the backup schedules for the database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   ListBackupSchedulesRequest request =
   *       ListBackupSchedulesRequest.newBuilder()
   *           .setParent(DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListBackupSchedulesResponse response =
   *         databaseAdminClient.listBackupSchedulesCallable().call(request);
   *     for (BackupSchedule element : response.getBackupSchedulesList()) {
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
  public final UnaryCallable<ListBackupSchedulesRequest, ListBackupSchedulesResponse>
      listBackupSchedulesCallable() {
    return stub.listBackupSchedulesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * This is an internal API called by Spanner Graph jobs. You should never need to call this API
   * directly.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   DatabaseName database = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]");
   *   String operationId = "operationId129704162";
   *   InternalUpdateGraphOperationResponse response =
   *       databaseAdminClient.internalUpdateGraphOperation(database, operationId);
   * }
   * }</pre>
   *
   * @param database Internal field, do not use directly.
   * @param operationId Internal field, do not use directly.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InternalUpdateGraphOperationResponse internalUpdateGraphOperation(
      DatabaseName database, String operationId) {
    InternalUpdateGraphOperationRequest request =
        InternalUpdateGraphOperationRequest.newBuilder()
            .setDatabase(database == null ? null : database.toString())
            .setOperationId(operationId)
            .build();
    return internalUpdateGraphOperation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * This is an internal API called by Spanner Graph jobs. You should never need to call this API
   * directly.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   String database = DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]").toString();
   *   String operationId = "operationId129704162";
   *   InternalUpdateGraphOperationResponse response =
   *       databaseAdminClient.internalUpdateGraphOperation(database, operationId);
   * }
   * }</pre>
   *
   * @param database Internal field, do not use directly.
   * @param operationId Internal field, do not use directly.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InternalUpdateGraphOperationResponse internalUpdateGraphOperation(
      String database, String operationId) {
    InternalUpdateGraphOperationRequest request =
        InternalUpdateGraphOperationRequest.newBuilder()
            .setDatabase(database)
            .setOperationId(operationId)
            .build();
    return internalUpdateGraphOperation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * This is an internal API called by Spanner Graph jobs. You should never need to call this API
   * directly.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   InternalUpdateGraphOperationRequest request =
   *       InternalUpdateGraphOperationRequest.newBuilder()
   *           .setDatabase(DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]").toString())
   *           .setOperationId("operationId129704162")
   *           .setVmIdentityToken("vmIdentityToken-417652124")
   *           .setProgress(-1001078227)
   *           .setStatus(Status.newBuilder().build())
   *           .build();
   *   InternalUpdateGraphOperationResponse response =
   *       databaseAdminClient.internalUpdateGraphOperation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InternalUpdateGraphOperationResponse internalUpdateGraphOperation(
      InternalUpdateGraphOperationRequest request) {
    return internalUpdateGraphOperationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * This is an internal API called by Spanner Graph jobs. You should never need to call this API
   * directly.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DatabaseAdminClient databaseAdminClient = DatabaseAdminClient.create()) {
   *   InternalUpdateGraphOperationRequest request =
   *       InternalUpdateGraphOperationRequest.newBuilder()
   *           .setDatabase(DatabaseName.of("[PROJECT]", "[INSTANCE]", "[DATABASE]").toString())
   *           .setOperationId("operationId129704162")
   *           .setVmIdentityToken("vmIdentityToken-417652124")
   *           .setProgress(-1001078227)
   *           .setStatus(Status.newBuilder().build())
   *           .build();
   *   ApiFuture<InternalUpdateGraphOperationResponse> future =
   *       databaseAdminClient.internalUpdateGraphOperationCallable().futureCall(request);
   *   // Do something.
   *   InternalUpdateGraphOperationResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          InternalUpdateGraphOperationRequest, InternalUpdateGraphOperationResponse>
      internalUpdateGraphOperationCallable() {
    return stub.internalUpdateGraphOperationCallable();
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

  public static class ListDatabasesPagedResponse
      extends AbstractPagedListResponse<
          ListDatabasesRequest,
          ListDatabasesResponse,
          Database,
          ListDatabasesPage,
          ListDatabasesFixedSizeCollection> {

    public static ApiFuture<ListDatabasesPagedResponse> createAsync(
        PageContext<ListDatabasesRequest, ListDatabasesResponse, Database> context,
        ApiFuture<ListDatabasesResponse> futureResponse) {
      ApiFuture<ListDatabasesPage> futurePage =
          ListDatabasesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDatabasesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDatabasesPagedResponse(ListDatabasesPage page) {
      super(page, ListDatabasesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDatabasesPage
      extends AbstractPage<
          ListDatabasesRequest, ListDatabasesResponse, Database, ListDatabasesPage> {

    private ListDatabasesPage(
        PageContext<ListDatabasesRequest, ListDatabasesResponse, Database> context,
        ListDatabasesResponse response) {
      super(context, response);
    }

    private static ListDatabasesPage createEmptyPage() {
      return new ListDatabasesPage(null, null);
    }

    @Override
    protected ListDatabasesPage createPage(
        PageContext<ListDatabasesRequest, ListDatabasesResponse, Database> context,
        ListDatabasesResponse response) {
      return new ListDatabasesPage(context, response);
    }

    @Override
    public ApiFuture<ListDatabasesPage> createPageAsync(
        PageContext<ListDatabasesRequest, ListDatabasesResponse, Database> context,
        ApiFuture<ListDatabasesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDatabasesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDatabasesRequest,
          ListDatabasesResponse,
          Database,
          ListDatabasesPage,
          ListDatabasesFixedSizeCollection> {

    private ListDatabasesFixedSizeCollection(List<ListDatabasesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDatabasesFixedSizeCollection createEmptyCollection() {
      return new ListDatabasesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDatabasesFixedSizeCollection createCollection(
        List<ListDatabasesPage> pages, int collectionSize) {
      return new ListDatabasesFixedSizeCollection(pages, collectionSize);
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

  public static class ListDatabaseOperationsPagedResponse
      extends AbstractPagedListResponse<
          ListDatabaseOperationsRequest,
          ListDatabaseOperationsResponse,
          Operation,
          ListDatabaseOperationsPage,
          ListDatabaseOperationsFixedSizeCollection> {

    public static ApiFuture<ListDatabaseOperationsPagedResponse> createAsync(
        PageContext<ListDatabaseOperationsRequest, ListDatabaseOperationsResponse, Operation>
            context,
        ApiFuture<ListDatabaseOperationsResponse> futureResponse) {
      ApiFuture<ListDatabaseOperationsPage> futurePage =
          ListDatabaseOperationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDatabaseOperationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDatabaseOperationsPagedResponse(ListDatabaseOperationsPage page) {
      super(page, ListDatabaseOperationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDatabaseOperationsPage
      extends AbstractPage<
          ListDatabaseOperationsRequest,
          ListDatabaseOperationsResponse,
          Operation,
          ListDatabaseOperationsPage> {

    private ListDatabaseOperationsPage(
        PageContext<ListDatabaseOperationsRequest, ListDatabaseOperationsResponse, Operation>
            context,
        ListDatabaseOperationsResponse response) {
      super(context, response);
    }

    private static ListDatabaseOperationsPage createEmptyPage() {
      return new ListDatabaseOperationsPage(null, null);
    }

    @Override
    protected ListDatabaseOperationsPage createPage(
        PageContext<ListDatabaseOperationsRequest, ListDatabaseOperationsResponse, Operation>
            context,
        ListDatabaseOperationsResponse response) {
      return new ListDatabaseOperationsPage(context, response);
    }

    @Override
    public ApiFuture<ListDatabaseOperationsPage> createPageAsync(
        PageContext<ListDatabaseOperationsRequest, ListDatabaseOperationsResponse, Operation>
            context,
        ApiFuture<ListDatabaseOperationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDatabaseOperationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDatabaseOperationsRequest,
          ListDatabaseOperationsResponse,
          Operation,
          ListDatabaseOperationsPage,
          ListDatabaseOperationsFixedSizeCollection> {

    private ListDatabaseOperationsFixedSizeCollection(
        List<ListDatabaseOperationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDatabaseOperationsFixedSizeCollection createEmptyCollection() {
      return new ListDatabaseOperationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDatabaseOperationsFixedSizeCollection createCollection(
        List<ListDatabaseOperationsPage> pages, int collectionSize) {
      return new ListDatabaseOperationsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListBackupOperationsPagedResponse
      extends AbstractPagedListResponse<
          ListBackupOperationsRequest,
          ListBackupOperationsResponse,
          Operation,
          ListBackupOperationsPage,
          ListBackupOperationsFixedSizeCollection> {

    public static ApiFuture<ListBackupOperationsPagedResponse> createAsync(
        PageContext<ListBackupOperationsRequest, ListBackupOperationsResponse, Operation> context,
        ApiFuture<ListBackupOperationsResponse> futureResponse) {
      ApiFuture<ListBackupOperationsPage> futurePage =
          ListBackupOperationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListBackupOperationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListBackupOperationsPagedResponse(ListBackupOperationsPage page) {
      super(page, ListBackupOperationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListBackupOperationsPage
      extends AbstractPage<
          ListBackupOperationsRequest,
          ListBackupOperationsResponse,
          Operation,
          ListBackupOperationsPage> {

    private ListBackupOperationsPage(
        PageContext<ListBackupOperationsRequest, ListBackupOperationsResponse, Operation> context,
        ListBackupOperationsResponse response) {
      super(context, response);
    }

    private static ListBackupOperationsPage createEmptyPage() {
      return new ListBackupOperationsPage(null, null);
    }

    @Override
    protected ListBackupOperationsPage createPage(
        PageContext<ListBackupOperationsRequest, ListBackupOperationsResponse, Operation> context,
        ListBackupOperationsResponse response) {
      return new ListBackupOperationsPage(context, response);
    }

    @Override
    public ApiFuture<ListBackupOperationsPage> createPageAsync(
        PageContext<ListBackupOperationsRequest, ListBackupOperationsResponse, Operation> context,
        ApiFuture<ListBackupOperationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListBackupOperationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListBackupOperationsRequest,
          ListBackupOperationsResponse,
          Operation,
          ListBackupOperationsPage,
          ListBackupOperationsFixedSizeCollection> {

    private ListBackupOperationsFixedSizeCollection(
        List<ListBackupOperationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListBackupOperationsFixedSizeCollection createEmptyCollection() {
      return new ListBackupOperationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListBackupOperationsFixedSizeCollection createCollection(
        List<ListBackupOperationsPage> pages, int collectionSize) {
      return new ListBackupOperationsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListDatabaseRolesPagedResponse
      extends AbstractPagedListResponse<
          ListDatabaseRolesRequest,
          ListDatabaseRolesResponse,
          DatabaseRole,
          ListDatabaseRolesPage,
          ListDatabaseRolesFixedSizeCollection> {

    public static ApiFuture<ListDatabaseRolesPagedResponse> createAsync(
        PageContext<ListDatabaseRolesRequest, ListDatabaseRolesResponse, DatabaseRole> context,
        ApiFuture<ListDatabaseRolesResponse> futureResponse) {
      ApiFuture<ListDatabaseRolesPage> futurePage =
          ListDatabaseRolesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDatabaseRolesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDatabaseRolesPagedResponse(ListDatabaseRolesPage page) {
      super(page, ListDatabaseRolesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDatabaseRolesPage
      extends AbstractPage<
          ListDatabaseRolesRequest,
          ListDatabaseRolesResponse,
          DatabaseRole,
          ListDatabaseRolesPage> {

    private ListDatabaseRolesPage(
        PageContext<ListDatabaseRolesRequest, ListDatabaseRolesResponse, DatabaseRole> context,
        ListDatabaseRolesResponse response) {
      super(context, response);
    }

    private static ListDatabaseRolesPage createEmptyPage() {
      return new ListDatabaseRolesPage(null, null);
    }

    @Override
    protected ListDatabaseRolesPage createPage(
        PageContext<ListDatabaseRolesRequest, ListDatabaseRolesResponse, DatabaseRole> context,
        ListDatabaseRolesResponse response) {
      return new ListDatabaseRolesPage(context, response);
    }

    @Override
    public ApiFuture<ListDatabaseRolesPage> createPageAsync(
        PageContext<ListDatabaseRolesRequest, ListDatabaseRolesResponse, DatabaseRole> context,
        ApiFuture<ListDatabaseRolesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDatabaseRolesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDatabaseRolesRequest,
          ListDatabaseRolesResponse,
          DatabaseRole,
          ListDatabaseRolesPage,
          ListDatabaseRolesFixedSizeCollection> {

    private ListDatabaseRolesFixedSizeCollection(
        List<ListDatabaseRolesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDatabaseRolesFixedSizeCollection createEmptyCollection() {
      return new ListDatabaseRolesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDatabaseRolesFixedSizeCollection createCollection(
        List<ListDatabaseRolesPage> pages, int collectionSize) {
      return new ListDatabaseRolesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListBackupSchedulesPagedResponse
      extends AbstractPagedListResponse<
          ListBackupSchedulesRequest,
          ListBackupSchedulesResponse,
          BackupSchedule,
          ListBackupSchedulesPage,
          ListBackupSchedulesFixedSizeCollection> {

    public static ApiFuture<ListBackupSchedulesPagedResponse> createAsync(
        PageContext<ListBackupSchedulesRequest, ListBackupSchedulesResponse, BackupSchedule>
            context,
        ApiFuture<ListBackupSchedulesResponse> futureResponse) {
      ApiFuture<ListBackupSchedulesPage> futurePage =
          ListBackupSchedulesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListBackupSchedulesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListBackupSchedulesPagedResponse(ListBackupSchedulesPage page) {
      super(page, ListBackupSchedulesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListBackupSchedulesPage
      extends AbstractPage<
          ListBackupSchedulesRequest,
          ListBackupSchedulesResponse,
          BackupSchedule,
          ListBackupSchedulesPage> {

    private ListBackupSchedulesPage(
        PageContext<ListBackupSchedulesRequest, ListBackupSchedulesResponse, BackupSchedule>
            context,
        ListBackupSchedulesResponse response) {
      super(context, response);
    }

    private static ListBackupSchedulesPage createEmptyPage() {
      return new ListBackupSchedulesPage(null, null);
    }

    @Override
    protected ListBackupSchedulesPage createPage(
        PageContext<ListBackupSchedulesRequest, ListBackupSchedulesResponse, BackupSchedule>
            context,
        ListBackupSchedulesResponse response) {
      return new ListBackupSchedulesPage(context, response);
    }

    @Override
    public ApiFuture<ListBackupSchedulesPage> createPageAsync(
        PageContext<ListBackupSchedulesRequest, ListBackupSchedulesResponse, BackupSchedule>
            context,
        ApiFuture<ListBackupSchedulesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListBackupSchedulesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListBackupSchedulesRequest,
          ListBackupSchedulesResponse,
          BackupSchedule,
          ListBackupSchedulesPage,
          ListBackupSchedulesFixedSizeCollection> {

    private ListBackupSchedulesFixedSizeCollection(
        List<ListBackupSchedulesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListBackupSchedulesFixedSizeCollection createEmptyCollection() {
      return new ListBackupSchedulesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListBackupSchedulesFixedSizeCollection createCollection(
        List<ListBackupSchedulesPage> pages, int collectionSize) {
      return new ListBackupSchedulesFixedSizeCollection(pages, collectionSize);
    }
  }
}
