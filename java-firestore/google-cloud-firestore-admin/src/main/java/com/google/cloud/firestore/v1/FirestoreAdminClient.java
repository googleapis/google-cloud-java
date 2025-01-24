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

package com.google.cloud.firestore.v1;

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
import com.google.cloud.firestore.v1.stub.FirestoreAdminStub;
import com.google.cloud.firestore.v1.stub.FirestoreAdminStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.firestore.admin.v1.Backup;
import com.google.firestore.admin.v1.BackupName;
import com.google.firestore.admin.v1.BackupSchedule;
import com.google.firestore.admin.v1.BackupScheduleName;
import com.google.firestore.admin.v1.BulkDeleteDocumentsMetadata;
import com.google.firestore.admin.v1.BulkDeleteDocumentsRequest;
import com.google.firestore.admin.v1.BulkDeleteDocumentsResponse;
import com.google.firestore.admin.v1.CollectionGroupName;
import com.google.firestore.admin.v1.CreateBackupScheduleRequest;
import com.google.firestore.admin.v1.CreateDatabaseMetadata;
import com.google.firestore.admin.v1.CreateDatabaseRequest;
import com.google.firestore.admin.v1.CreateIndexRequest;
import com.google.firestore.admin.v1.Database;
import com.google.firestore.admin.v1.DatabaseName;
import com.google.firestore.admin.v1.DeleteBackupRequest;
import com.google.firestore.admin.v1.DeleteBackupScheduleRequest;
import com.google.firestore.admin.v1.DeleteDatabaseMetadata;
import com.google.firestore.admin.v1.DeleteDatabaseRequest;
import com.google.firestore.admin.v1.DeleteIndexRequest;
import com.google.firestore.admin.v1.ExportDocumentsMetadata;
import com.google.firestore.admin.v1.ExportDocumentsRequest;
import com.google.firestore.admin.v1.ExportDocumentsResponse;
import com.google.firestore.admin.v1.Field;
import com.google.firestore.admin.v1.FieldName;
import com.google.firestore.admin.v1.FieldOperationMetadata;
import com.google.firestore.admin.v1.GetBackupRequest;
import com.google.firestore.admin.v1.GetBackupScheduleRequest;
import com.google.firestore.admin.v1.GetDatabaseRequest;
import com.google.firestore.admin.v1.GetFieldRequest;
import com.google.firestore.admin.v1.GetIndexRequest;
import com.google.firestore.admin.v1.ImportDocumentsMetadata;
import com.google.firestore.admin.v1.ImportDocumentsRequest;
import com.google.firestore.admin.v1.Index;
import com.google.firestore.admin.v1.IndexName;
import com.google.firestore.admin.v1.IndexOperationMetadata;
import com.google.firestore.admin.v1.ListBackupSchedulesRequest;
import com.google.firestore.admin.v1.ListBackupSchedulesResponse;
import com.google.firestore.admin.v1.ListBackupsRequest;
import com.google.firestore.admin.v1.ListBackupsResponse;
import com.google.firestore.admin.v1.ListDatabasesRequest;
import com.google.firestore.admin.v1.ListDatabasesResponse;
import com.google.firestore.admin.v1.ListFieldsRequest;
import com.google.firestore.admin.v1.ListFieldsResponse;
import com.google.firestore.admin.v1.ListIndexesRequest;
import com.google.firestore.admin.v1.ListIndexesResponse;
import com.google.firestore.admin.v1.LocationName;
import com.google.firestore.admin.v1.ProjectName;
import com.google.firestore.admin.v1.RestoreDatabaseMetadata;
import com.google.firestore.admin.v1.RestoreDatabaseRequest;
import com.google.firestore.admin.v1.UpdateBackupScheduleRequest;
import com.google.firestore.admin.v1.UpdateDatabaseMetadata;
import com.google.firestore.admin.v1.UpdateDatabaseRequest;
import com.google.firestore.admin.v1.UpdateFieldRequest;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The Cloud Firestore Admin API.
 *
 * <p>This API provides several administrative services for Cloud Firestore.
 *
 * <p>Project, Database, Namespace, Collection, Collection Group, and Document are used as defined
 * in the Google Cloud Firestore API.
 *
 * <p>Operation: An Operation represents work being performed in the background.
 *
 * <p>The index service manages Cloud Firestore indexes.
 *
 * <p>Index creation is performed asynchronously. An Operation resource is created for each such
 * asynchronous operation. The state of the operation (including any errors encountered) may be
 * queried via the Operation resource.
 *
 * <p>The Operations collection provides a record of actions performed for the specified Project
 * (including any Operations in progress). Operations are not created directly but through calls on
 * other collections or resources.
 *
 * <p>An Operation that is done may be deleted so that it is no longer listed as part of the
 * Operation collection. Operations are garbage collected after 30 days. By default, ListOperations
 * will only return in progress and failed operations. To list completed operation, issue a
 * ListOperations request with the filter `done: true`.
 *
 * <p>Operations are created by service `FirestoreAdmin`, but are accessed via service
 * `google.longrunning.Operations`.
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
 * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
 *   IndexName name = IndexName.of("[PROJECT]", "[DATABASE]", "[COLLECTION]", "[INDEX]");
 *   Index response = firestoreAdminClient.getIndex(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the FirestoreAdminClient object to clean up resources such
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
 *      <td><p> CreateIndex</td>
 *      <td><p> Creates a composite index. This returns a [google.longrunning.Operation][google.longrunning.Operation] which may be used to track the status of the creation. The metadata for the operation will be the type [IndexOperationMetadata][google.firestore.admin.v1.IndexOperationMetadata].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createIndexAsync(CreateIndexRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createIndexAsync(CollectionGroupName parent, Index index)
 *           <li><p> createIndexAsync(String parent, Index index)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createIndexOperationCallable()
 *           <li><p> createIndexCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListIndexes</td>
 *      <td><p> Lists composite indexes.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listIndexes(ListIndexesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listIndexes(CollectionGroupName parent)
 *           <li><p> listIndexes(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listIndexesPagedCallable()
 *           <li><p> listIndexesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetIndex</td>
 *      <td><p> Gets a composite index.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getIndex(GetIndexRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getIndex(IndexName name)
 *           <li><p> getIndex(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getIndexCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteIndex</td>
 *      <td><p> Deletes a composite index.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteIndex(DeleteIndexRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteIndex(IndexName name)
 *           <li><p> deleteIndex(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteIndexCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetField</td>
 *      <td><p> Gets the metadata and configuration for a Field.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getField(GetFieldRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getField(FieldName name)
 *           <li><p> getField(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getFieldCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateField</td>
 *      <td><p> Updates a field configuration. Currently, field updates apply only to single field index configuration. However, calls to [FirestoreAdmin.UpdateField][google.firestore.admin.v1.FirestoreAdmin.UpdateField] should provide a field mask to avoid changing any configuration that the caller isn't aware of. The field mask should be specified as: `{ paths: "index_config" }`.
 * <p>  This call returns a [google.longrunning.Operation][google.longrunning.Operation] which may be used to track the status of the field update. The metadata for the operation will be the type [FieldOperationMetadata][google.firestore.admin.v1.FieldOperationMetadata].
 * <p>  To configure the default field settings for the database, use the special `Field` with resource name: `projects/{project_id}/databases/{database_id}/collectionGroups/__default__/fields/&#42;`.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateFieldAsync(UpdateFieldRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateFieldAsync(Field field)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateFieldOperationCallable()
 *           <li><p> updateFieldCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListFields</td>
 *      <td><p> Lists the field configuration and metadata for this database.
 * <p>  Currently, [FirestoreAdmin.ListFields][google.firestore.admin.v1.FirestoreAdmin.ListFields] only supports listing fields that have been explicitly overridden. To issue this query, call [FirestoreAdmin.ListFields][google.firestore.admin.v1.FirestoreAdmin.ListFields] with the filter set to `indexConfig.usesAncestorConfig:false` or `ttlConfig:&#42;`.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listFields(ListFieldsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listFields(CollectionGroupName parent)
 *           <li><p> listFields(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listFieldsPagedCallable()
 *           <li><p> listFieldsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ExportDocuments</td>
 *      <td><p> Exports a copy of all or a subset of documents from Google Cloud Firestore to another storage system, such as Google Cloud Storage. Recent updates to documents may not be reflected in the export. The export occurs in the background and its progress can be monitored and managed via the Operation resource that is created. The output of an export may only be used once the associated operation is done. If an export operation is cancelled before completion it may leave partial data behind in Google Cloud Storage.
 * <p>  For more details on export behavior and output format, refer to: https://cloud.google.com/firestore/docs/manage-data/export-import</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> exportDocumentsAsync(ExportDocumentsRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> exportDocumentsAsync(DatabaseName name)
 *           <li><p> exportDocumentsAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> exportDocumentsOperationCallable()
 *           <li><p> exportDocumentsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ImportDocuments</td>
 *      <td><p> Imports documents into Google Cloud Firestore. Existing documents with the same name are overwritten. The import occurs in the background and its progress can be monitored and managed via the Operation resource that is created. If an ImportDocuments operation is cancelled, it is possible that a subset of the data has already been imported to Cloud Firestore.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> importDocumentsAsync(ImportDocumentsRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> importDocumentsAsync(DatabaseName name)
 *           <li><p> importDocumentsAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> importDocumentsOperationCallable()
 *           <li><p> importDocumentsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BulkDeleteDocuments</td>
 *      <td><p> Bulk deletes a subset of documents from Google Cloud Firestore. Documents created or updated after the underlying system starts to process the request will not be deleted. The bulk delete occurs in the background and its progress can be monitored and managed via the Operation resource that is created.
 * <p>  For more details on bulk delete behavior, refer to: https://cloud.google.com/firestore/docs/manage-data/bulk-delete</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> bulkDeleteDocumentsAsync(BulkDeleteDocumentsRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> bulkDeleteDocumentsAsync(DatabaseName name)
 *           <li><p> bulkDeleteDocumentsAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> bulkDeleteDocumentsOperationCallable()
 *           <li><p> bulkDeleteDocumentsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateDatabase</td>
 *      <td><p> Create a database.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createDatabaseAsync(CreateDatabaseRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createDatabaseAsync(ProjectName parent, Database database, String databaseId)
 *           <li><p> createDatabaseAsync(String parent, Database database, String databaseId)
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
 *      <td><p> Gets information about a database.</td>
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
 *      <td><p> ListDatabases</td>
 *      <td><p> List all the databases in the project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listDatabases(ListDatabasesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listDatabases(ProjectName parent)
 *           <li><p> listDatabases(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listDatabasesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateDatabase</td>
 *      <td><p> Updates a database.</td>
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
 *      <td><p> DeleteDatabase</td>
 *      <td><p> Deletes a database.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteDatabaseAsync(DeleteDatabaseRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteDatabaseAsync(DatabaseName name)
 *           <li><p> deleteDatabaseAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteDatabaseOperationCallable()
 *           <li><p> deleteDatabaseCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetBackup</td>
 *      <td><p> Gets information about a backup.</td>
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
 *      <td><p> ListBackups</td>
 *      <td><p> Lists all the backups.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listBackups(ListBackupsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listBackups(LocationName parent)
 *           <li><p> listBackups(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listBackupsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteBackup</td>
 *      <td><p> Deletes a backup.</td>
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
 *      <td><p> RestoreDatabase</td>
 *      <td><p> Creates a new database by restoring from an existing backup.
 * <p>  The new database must be in the same cloud region or multi-region location as the existing backup. This behaves similar to [FirestoreAdmin.CreateDatabase][google.firestore.admin.v1.FirestoreAdmin.CreateDatabase] except instead of creating a new empty database, a new database is created with the database type, index configuration, and documents from an existing backup.
 * <p>  The [long-running operation][google.longrunning.Operation] can be used to track the progress of the restore, with the Operation's [metadata][google.longrunning.Operation.metadata] field type being the [RestoreDatabaseMetadata][google.firestore.admin.v1.RestoreDatabaseMetadata]. The [response][google.longrunning.Operation.response] type is the [Database][google.firestore.admin.v1.Database] if the restore was successful. The new database is not readable or writeable until the LRO has completed.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> restoreDatabaseAsync(RestoreDatabaseRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> restoreDatabaseOperationCallable()
 *           <li><p> restoreDatabaseCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateBackupSchedule</td>
 *      <td><p> Creates a backup schedule on a database. At most two backup schedules can be configured on a database, one daily backup schedule and one weekly backup schedule.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createBackupSchedule(CreateBackupScheduleRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createBackupSchedule(DatabaseName parent, BackupSchedule backupSchedule)
 *           <li><p> createBackupSchedule(String parent, BackupSchedule backupSchedule)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createBackupScheduleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetBackupSchedule</td>
 *      <td><p> Gets information about a backup schedule.</td>
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
 *      <td><p> ListBackupSchedules</td>
 *      <td><p> List backup schedules.</td>
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
 *           <li><p> listBackupSchedulesCallable()
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
 *  </table>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of FirestoreAdminSettings to
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
 * FirestoreAdminSettings firestoreAdminSettings =
 *     FirestoreAdminSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create(firestoreAdminSettings);
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
 * FirestoreAdminSettings firestoreAdminSettings =
 *     FirestoreAdminSettings.newBuilder().setEndpoint(myEndpoint).build();
 * FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create(firestoreAdminSettings);
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
 * FirestoreAdminSettings firestoreAdminSettings =
 *     FirestoreAdminSettings.newHttpJsonBuilder().build();
 * FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create(firestoreAdminSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class FirestoreAdminClient implements BackgroundResource {
  private final FirestoreAdminSettings settings;
  private final FirestoreAdminStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of FirestoreAdminClient with default settings. */
  public static final FirestoreAdminClient create() throws IOException {
    return create(FirestoreAdminSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of FirestoreAdminClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final FirestoreAdminClient create(FirestoreAdminSettings settings)
      throws IOException {
    return new FirestoreAdminClient(settings);
  }

  /**
   * Constructs an instance of FirestoreAdminClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(FirestoreAdminSettings).
   */
  public static final FirestoreAdminClient create(FirestoreAdminStub stub) {
    return new FirestoreAdminClient(stub);
  }

  /**
   * Constructs an instance of FirestoreAdminClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected FirestoreAdminClient(FirestoreAdminSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((FirestoreAdminStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected FirestoreAdminClient(FirestoreAdminStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final FirestoreAdminSettings getSettings() {
    return settings;
  }

  public FirestoreAdminStub getStub() {
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
   * Creates a composite index. This returns a
   * [google.longrunning.Operation][google.longrunning.Operation] which may be used to track the
   * status of the creation. The metadata for the operation will be the type
   * [IndexOperationMetadata][google.firestore.admin.v1.IndexOperationMetadata].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   CollectionGroupName parent =
   *       CollectionGroupName.of("[PROJECT]", "[DATABASE]", "[COLLECTION]");
   *   Index index = Index.newBuilder().build();
   *   Index response = firestoreAdminClient.createIndexAsync(parent, index).get();
   * }
   * }</pre>
   *
   * @param parent Required. A parent name of the form
   *     `projects/{project_id}/databases/{database_id}/collectionGroups/{collection_id}`
   * @param index Required. The composite index to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Index, IndexOperationMetadata> createIndexAsync(
      CollectionGroupName parent, Index index) {
    CreateIndexRequest request =
        CreateIndexRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setIndex(index)
            .build();
    return createIndexAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a composite index. This returns a
   * [google.longrunning.Operation][google.longrunning.Operation] which may be used to track the
   * status of the creation. The metadata for the operation will be the type
   * [IndexOperationMetadata][google.firestore.admin.v1.IndexOperationMetadata].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   String parent = CollectionGroupName.of("[PROJECT]", "[DATABASE]", "[COLLECTION]").toString();
   *   Index index = Index.newBuilder().build();
   *   Index response = firestoreAdminClient.createIndexAsync(parent, index).get();
   * }
   * }</pre>
   *
   * @param parent Required. A parent name of the form
   *     `projects/{project_id}/databases/{database_id}/collectionGroups/{collection_id}`
   * @param index Required. The composite index to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Index, IndexOperationMetadata> createIndexAsync(
      String parent, Index index) {
    CreateIndexRequest request =
        CreateIndexRequest.newBuilder().setParent(parent).setIndex(index).build();
    return createIndexAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a composite index. This returns a
   * [google.longrunning.Operation][google.longrunning.Operation] which may be used to track the
   * status of the creation. The metadata for the operation will be the type
   * [IndexOperationMetadata][google.firestore.admin.v1.IndexOperationMetadata].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   CreateIndexRequest request =
   *       CreateIndexRequest.newBuilder()
   *           .setParent(
   *               CollectionGroupName.of("[PROJECT]", "[DATABASE]", "[COLLECTION]").toString())
   *           .setIndex(Index.newBuilder().build())
   *           .build();
   *   Index response = firestoreAdminClient.createIndexAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Index, IndexOperationMetadata> createIndexAsync(
      CreateIndexRequest request) {
    return createIndexOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a composite index. This returns a
   * [google.longrunning.Operation][google.longrunning.Operation] which may be used to track the
   * status of the creation. The metadata for the operation will be the type
   * [IndexOperationMetadata][google.firestore.admin.v1.IndexOperationMetadata].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   CreateIndexRequest request =
   *       CreateIndexRequest.newBuilder()
   *           .setParent(
   *               CollectionGroupName.of("[PROJECT]", "[DATABASE]", "[COLLECTION]").toString())
   *           .setIndex(Index.newBuilder().build())
   *           .build();
   *   OperationFuture<Index, IndexOperationMetadata> future =
   *       firestoreAdminClient.createIndexOperationCallable().futureCall(request);
   *   // Do something.
   *   Index response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateIndexRequest, Index, IndexOperationMetadata>
      createIndexOperationCallable() {
    return stub.createIndexOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a composite index. This returns a
   * [google.longrunning.Operation][google.longrunning.Operation] which may be used to track the
   * status of the creation. The metadata for the operation will be the type
   * [IndexOperationMetadata][google.firestore.admin.v1.IndexOperationMetadata].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   CreateIndexRequest request =
   *       CreateIndexRequest.newBuilder()
   *           .setParent(
   *               CollectionGroupName.of("[PROJECT]", "[DATABASE]", "[COLLECTION]").toString())
   *           .setIndex(Index.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = firestoreAdminClient.createIndexCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateIndexRequest, Operation> createIndexCallable() {
    return stub.createIndexCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists composite indexes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   CollectionGroupName parent =
   *       CollectionGroupName.of("[PROJECT]", "[DATABASE]", "[COLLECTION]");
   *   for (Index element : firestoreAdminClient.listIndexes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. A parent name of the form
   *     `projects/{project_id}/databases/{database_id}/collectionGroups/{collection_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListIndexesPagedResponse listIndexes(CollectionGroupName parent) {
    ListIndexesRequest request =
        ListIndexesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listIndexes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists composite indexes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   String parent = CollectionGroupName.of("[PROJECT]", "[DATABASE]", "[COLLECTION]").toString();
   *   for (Index element : firestoreAdminClient.listIndexes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. A parent name of the form
   *     `projects/{project_id}/databases/{database_id}/collectionGroups/{collection_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListIndexesPagedResponse listIndexes(String parent) {
    ListIndexesRequest request = ListIndexesRequest.newBuilder().setParent(parent).build();
    return listIndexes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists composite indexes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   ListIndexesRequest request =
   *       ListIndexesRequest.newBuilder()
   *           .setParent(
   *               CollectionGroupName.of("[PROJECT]", "[DATABASE]", "[COLLECTION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Index element : firestoreAdminClient.listIndexes(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListIndexesPagedResponse listIndexes(ListIndexesRequest request) {
    return listIndexesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists composite indexes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   ListIndexesRequest request =
   *       ListIndexesRequest.newBuilder()
   *           .setParent(
   *               CollectionGroupName.of("[PROJECT]", "[DATABASE]", "[COLLECTION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Index> future = firestoreAdminClient.listIndexesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Index element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListIndexesRequest, ListIndexesPagedResponse>
      listIndexesPagedCallable() {
    return stub.listIndexesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists composite indexes.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   ListIndexesRequest request =
   *       ListIndexesRequest.newBuilder()
   *           .setParent(
   *               CollectionGroupName.of("[PROJECT]", "[DATABASE]", "[COLLECTION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListIndexesResponse response = firestoreAdminClient.listIndexesCallable().call(request);
   *     for (Index element : response.getIndexesList()) {
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
  public final UnaryCallable<ListIndexesRequest, ListIndexesResponse> listIndexesCallable() {
    return stub.listIndexesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a composite index.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   IndexName name = IndexName.of("[PROJECT]", "[DATABASE]", "[COLLECTION]", "[INDEX]");
   *   Index response = firestoreAdminClient.getIndex(name);
   * }
   * }</pre>
   *
   * @param name Required. A name of the form
   *     `projects/{project_id}/databases/{database_id}/collectionGroups/{collection_id}/indexes/{index_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Index getIndex(IndexName name) {
    GetIndexRequest request =
        GetIndexRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getIndex(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a composite index.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   String name = IndexName.of("[PROJECT]", "[DATABASE]", "[COLLECTION]", "[INDEX]").toString();
   *   Index response = firestoreAdminClient.getIndex(name);
   * }
   * }</pre>
   *
   * @param name Required. A name of the form
   *     `projects/{project_id}/databases/{database_id}/collectionGroups/{collection_id}/indexes/{index_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Index getIndex(String name) {
    GetIndexRequest request = GetIndexRequest.newBuilder().setName(name).build();
    return getIndex(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a composite index.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   GetIndexRequest request =
   *       GetIndexRequest.newBuilder()
   *           .setName(
   *               IndexName.of("[PROJECT]", "[DATABASE]", "[COLLECTION]", "[INDEX]").toString())
   *           .build();
   *   Index response = firestoreAdminClient.getIndex(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Index getIndex(GetIndexRequest request) {
    return getIndexCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a composite index.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   GetIndexRequest request =
   *       GetIndexRequest.newBuilder()
   *           .setName(
   *               IndexName.of("[PROJECT]", "[DATABASE]", "[COLLECTION]", "[INDEX]").toString())
   *           .build();
   *   ApiFuture<Index> future = firestoreAdminClient.getIndexCallable().futureCall(request);
   *   // Do something.
   *   Index response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIndexRequest, Index> getIndexCallable() {
    return stub.getIndexCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a composite index.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   IndexName name = IndexName.of("[PROJECT]", "[DATABASE]", "[COLLECTION]", "[INDEX]");
   *   firestoreAdminClient.deleteIndex(name);
   * }
   * }</pre>
   *
   * @param name Required. A name of the form
   *     `projects/{project_id}/databases/{database_id}/collectionGroups/{collection_id}/indexes/{index_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteIndex(IndexName name) {
    DeleteIndexRequest request =
        DeleteIndexRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteIndex(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a composite index.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   String name = IndexName.of("[PROJECT]", "[DATABASE]", "[COLLECTION]", "[INDEX]").toString();
   *   firestoreAdminClient.deleteIndex(name);
   * }
   * }</pre>
   *
   * @param name Required. A name of the form
   *     `projects/{project_id}/databases/{database_id}/collectionGroups/{collection_id}/indexes/{index_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteIndex(String name) {
    DeleteIndexRequest request = DeleteIndexRequest.newBuilder().setName(name).build();
    deleteIndex(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a composite index.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   DeleteIndexRequest request =
   *       DeleteIndexRequest.newBuilder()
   *           .setName(
   *               IndexName.of("[PROJECT]", "[DATABASE]", "[COLLECTION]", "[INDEX]").toString())
   *           .build();
   *   firestoreAdminClient.deleteIndex(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteIndex(DeleteIndexRequest request) {
    deleteIndexCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a composite index.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   DeleteIndexRequest request =
   *       DeleteIndexRequest.newBuilder()
   *           .setName(
   *               IndexName.of("[PROJECT]", "[DATABASE]", "[COLLECTION]", "[INDEX]").toString())
   *           .build();
   *   ApiFuture<Empty> future = firestoreAdminClient.deleteIndexCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteIndexRequest, Empty> deleteIndexCallable() {
    return stub.deleteIndexCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the metadata and configuration for a Field.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   FieldName name = FieldName.of("[PROJECT]", "[DATABASE]", "[COLLECTION]", "[FIELD]");
   *   Field response = firestoreAdminClient.getField(name);
   * }
   * }</pre>
   *
   * @param name Required. A name of the form
   *     `projects/{project_id}/databases/{database_id}/collectionGroups/{collection_id}/fields/{field_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Field getField(FieldName name) {
    GetFieldRequest request =
        GetFieldRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getField(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the metadata and configuration for a Field.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   String name = FieldName.of("[PROJECT]", "[DATABASE]", "[COLLECTION]", "[FIELD]").toString();
   *   Field response = firestoreAdminClient.getField(name);
   * }
   * }</pre>
   *
   * @param name Required. A name of the form
   *     `projects/{project_id}/databases/{database_id}/collectionGroups/{collection_id}/fields/{field_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Field getField(String name) {
    GetFieldRequest request = GetFieldRequest.newBuilder().setName(name).build();
    return getField(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the metadata and configuration for a Field.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   GetFieldRequest request =
   *       GetFieldRequest.newBuilder()
   *           .setName(
   *               FieldName.of("[PROJECT]", "[DATABASE]", "[COLLECTION]", "[FIELD]").toString())
   *           .build();
   *   Field response = firestoreAdminClient.getField(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Field getField(GetFieldRequest request) {
    return getFieldCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the metadata and configuration for a Field.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   GetFieldRequest request =
   *       GetFieldRequest.newBuilder()
   *           .setName(
   *               FieldName.of("[PROJECT]", "[DATABASE]", "[COLLECTION]", "[FIELD]").toString())
   *           .build();
   *   ApiFuture<Field> future = firestoreAdminClient.getFieldCallable().futureCall(request);
   *   // Do something.
   *   Field response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetFieldRequest, Field> getFieldCallable() {
    return stub.getFieldCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a field configuration. Currently, field updates apply only to single field index
   * configuration. However, calls to
   * [FirestoreAdmin.UpdateField][google.firestore.admin.v1.FirestoreAdmin.UpdateField] should
   * provide a field mask to avoid changing any configuration that the caller isn't aware of. The
   * field mask should be specified as: `{ paths: "index_config" }`.
   *
   * <p>This call returns a [google.longrunning.Operation][google.longrunning.Operation] which may
   * be used to track the status of the field update. The metadata for the operation will be the
   * type [FieldOperationMetadata][google.firestore.admin.v1.FieldOperationMetadata].
   *
   * <p>To configure the default field settings for the database, use the special `Field` with
   * resource name:
   * `projects/{project_id}/databases/{database_id}/collectionGroups/__default__/fields/&#42;`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   Field field = Field.newBuilder().build();
   *   Field response = firestoreAdminClient.updateFieldAsync(field).get();
   * }
   * }</pre>
   *
   * @param field Required. The field to be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Field, FieldOperationMetadata> updateFieldAsync(Field field) {
    UpdateFieldRequest request = UpdateFieldRequest.newBuilder().setField(field).build();
    return updateFieldAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a field configuration. Currently, field updates apply only to single field index
   * configuration. However, calls to
   * [FirestoreAdmin.UpdateField][google.firestore.admin.v1.FirestoreAdmin.UpdateField] should
   * provide a field mask to avoid changing any configuration that the caller isn't aware of. The
   * field mask should be specified as: `{ paths: "index_config" }`.
   *
   * <p>This call returns a [google.longrunning.Operation][google.longrunning.Operation] which may
   * be used to track the status of the field update. The metadata for the operation will be the
   * type [FieldOperationMetadata][google.firestore.admin.v1.FieldOperationMetadata].
   *
   * <p>To configure the default field settings for the database, use the special `Field` with
   * resource name:
   * `projects/{project_id}/databases/{database_id}/collectionGroups/__default__/fields/&#42;`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   UpdateFieldRequest request =
   *       UpdateFieldRequest.newBuilder()
   *           .setField(Field.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Field response = firestoreAdminClient.updateFieldAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Field, FieldOperationMetadata> updateFieldAsync(
      UpdateFieldRequest request) {
    return updateFieldOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a field configuration. Currently, field updates apply only to single field index
   * configuration. However, calls to
   * [FirestoreAdmin.UpdateField][google.firestore.admin.v1.FirestoreAdmin.UpdateField] should
   * provide a field mask to avoid changing any configuration that the caller isn't aware of. The
   * field mask should be specified as: `{ paths: "index_config" }`.
   *
   * <p>This call returns a [google.longrunning.Operation][google.longrunning.Operation] which may
   * be used to track the status of the field update. The metadata for the operation will be the
   * type [FieldOperationMetadata][google.firestore.admin.v1.FieldOperationMetadata].
   *
   * <p>To configure the default field settings for the database, use the special `Field` with
   * resource name:
   * `projects/{project_id}/databases/{database_id}/collectionGroups/__default__/fields/&#42;`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   UpdateFieldRequest request =
   *       UpdateFieldRequest.newBuilder()
   *           .setField(Field.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<Field, FieldOperationMetadata> future =
   *       firestoreAdminClient.updateFieldOperationCallable().futureCall(request);
   *   // Do something.
   *   Field response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateFieldRequest, Field, FieldOperationMetadata>
      updateFieldOperationCallable() {
    return stub.updateFieldOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a field configuration. Currently, field updates apply only to single field index
   * configuration. However, calls to
   * [FirestoreAdmin.UpdateField][google.firestore.admin.v1.FirestoreAdmin.UpdateField] should
   * provide a field mask to avoid changing any configuration that the caller isn't aware of. The
   * field mask should be specified as: `{ paths: "index_config" }`.
   *
   * <p>This call returns a [google.longrunning.Operation][google.longrunning.Operation] which may
   * be used to track the status of the field update. The metadata for the operation will be the
   * type [FieldOperationMetadata][google.firestore.admin.v1.FieldOperationMetadata].
   *
   * <p>To configure the default field settings for the database, use the special `Field` with
   * resource name:
   * `projects/{project_id}/databases/{database_id}/collectionGroups/__default__/fields/&#42;`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   UpdateFieldRequest request =
   *       UpdateFieldRequest.newBuilder()
   *           .setField(Field.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = firestoreAdminClient.updateFieldCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateFieldRequest, Operation> updateFieldCallable() {
    return stub.updateFieldCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the field configuration and metadata for this database.
   *
   * <p>Currently, [FirestoreAdmin.ListFields][google.firestore.admin.v1.FirestoreAdmin.ListFields]
   * only supports listing fields that have been explicitly overridden. To issue this query, call
   * [FirestoreAdmin.ListFields][google.firestore.admin.v1.FirestoreAdmin.ListFields] with the
   * filter set to `indexConfig.usesAncestorConfig:false` or `ttlConfig:&#42;`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   CollectionGroupName parent =
   *       CollectionGroupName.of("[PROJECT]", "[DATABASE]", "[COLLECTION]");
   *   for (Field element : firestoreAdminClient.listFields(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. A parent name of the form
   *     `projects/{project_id}/databases/{database_id}/collectionGroups/{collection_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFieldsPagedResponse listFields(CollectionGroupName parent) {
    ListFieldsRequest request =
        ListFieldsRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listFields(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the field configuration and metadata for this database.
   *
   * <p>Currently, [FirestoreAdmin.ListFields][google.firestore.admin.v1.FirestoreAdmin.ListFields]
   * only supports listing fields that have been explicitly overridden. To issue this query, call
   * [FirestoreAdmin.ListFields][google.firestore.admin.v1.FirestoreAdmin.ListFields] with the
   * filter set to `indexConfig.usesAncestorConfig:false` or `ttlConfig:&#42;`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   String parent = CollectionGroupName.of("[PROJECT]", "[DATABASE]", "[COLLECTION]").toString();
   *   for (Field element : firestoreAdminClient.listFields(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. A parent name of the form
   *     `projects/{project_id}/databases/{database_id}/collectionGroups/{collection_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFieldsPagedResponse listFields(String parent) {
    ListFieldsRequest request = ListFieldsRequest.newBuilder().setParent(parent).build();
    return listFields(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the field configuration and metadata for this database.
   *
   * <p>Currently, [FirestoreAdmin.ListFields][google.firestore.admin.v1.FirestoreAdmin.ListFields]
   * only supports listing fields that have been explicitly overridden. To issue this query, call
   * [FirestoreAdmin.ListFields][google.firestore.admin.v1.FirestoreAdmin.ListFields] with the
   * filter set to `indexConfig.usesAncestorConfig:false` or `ttlConfig:&#42;`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   ListFieldsRequest request =
   *       ListFieldsRequest.newBuilder()
   *           .setParent(
   *               CollectionGroupName.of("[PROJECT]", "[DATABASE]", "[COLLECTION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Field element : firestoreAdminClient.listFields(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFieldsPagedResponse listFields(ListFieldsRequest request) {
    return listFieldsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the field configuration and metadata for this database.
   *
   * <p>Currently, [FirestoreAdmin.ListFields][google.firestore.admin.v1.FirestoreAdmin.ListFields]
   * only supports listing fields that have been explicitly overridden. To issue this query, call
   * [FirestoreAdmin.ListFields][google.firestore.admin.v1.FirestoreAdmin.ListFields] with the
   * filter set to `indexConfig.usesAncestorConfig:false` or `ttlConfig:&#42;`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   ListFieldsRequest request =
   *       ListFieldsRequest.newBuilder()
   *           .setParent(
   *               CollectionGroupName.of("[PROJECT]", "[DATABASE]", "[COLLECTION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Field> future = firestoreAdminClient.listFieldsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Field element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListFieldsRequest, ListFieldsPagedResponse> listFieldsPagedCallable() {
    return stub.listFieldsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the field configuration and metadata for this database.
   *
   * <p>Currently, [FirestoreAdmin.ListFields][google.firestore.admin.v1.FirestoreAdmin.ListFields]
   * only supports listing fields that have been explicitly overridden. To issue this query, call
   * [FirestoreAdmin.ListFields][google.firestore.admin.v1.FirestoreAdmin.ListFields] with the
   * filter set to `indexConfig.usesAncestorConfig:false` or `ttlConfig:&#42;`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   ListFieldsRequest request =
   *       ListFieldsRequest.newBuilder()
   *           .setParent(
   *               CollectionGroupName.of("[PROJECT]", "[DATABASE]", "[COLLECTION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListFieldsResponse response = firestoreAdminClient.listFieldsCallable().call(request);
   *     for (Field element : response.getFieldsList()) {
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
  public final UnaryCallable<ListFieldsRequest, ListFieldsResponse> listFieldsCallable() {
    return stub.listFieldsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports a copy of all or a subset of documents from Google Cloud Firestore to another storage
   * system, such as Google Cloud Storage. Recent updates to documents may not be reflected in the
   * export. The export occurs in the background and its progress can be monitored and managed via
   * the Operation resource that is created. The output of an export may only be used once the
   * associated operation is done. If an export operation is cancelled before completion it may
   * leave partial data behind in Google Cloud Storage.
   *
   * <p>For more details on export behavior and output format, refer to:
   * https://cloud.google.com/firestore/docs/manage-data/export-import
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   DatabaseName name = DatabaseName.of("[PROJECT]", "[DATABASE]");
   *   ExportDocumentsResponse response = firestoreAdminClient.exportDocumentsAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Database to export. Should be of the form:
   *     `projects/{project_id}/databases/{database_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportDocumentsResponse, ExportDocumentsMetadata>
      exportDocumentsAsync(DatabaseName name) {
    ExportDocumentsRequest request =
        ExportDocumentsRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return exportDocumentsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports a copy of all or a subset of documents from Google Cloud Firestore to another storage
   * system, such as Google Cloud Storage. Recent updates to documents may not be reflected in the
   * export. The export occurs in the background and its progress can be monitored and managed via
   * the Operation resource that is created. The output of an export may only be used once the
   * associated operation is done. If an export operation is cancelled before completion it may
   * leave partial data behind in Google Cloud Storage.
   *
   * <p>For more details on export behavior and output format, refer to:
   * https://cloud.google.com/firestore/docs/manage-data/export-import
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   String name = DatabaseName.of("[PROJECT]", "[DATABASE]").toString();
   *   ExportDocumentsResponse response = firestoreAdminClient.exportDocumentsAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Database to export. Should be of the form:
   *     `projects/{project_id}/databases/{database_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportDocumentsResponse, ExportDocumentsMetadata>
      exportDocumentsAsync(String name) {
    ExportDocumentsRequest request = ExportDocumentsRequest.newBuilder().setName(name).build();
    return exportDocumentsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports a copy of all or a subset of documents from Google Cloud Firestore to another storage
   * system, such as Google Cloud Storage. Recent updates to documents may not be reflected in the
   * export. The export occurs in the background and its progress can be monitored and managed via
   * the Operation resource that is created. The output of an export may only be used once the
   * associated operation is done. If an export operation is cancelled before completion it may
   * leave partial data behind in Google Cloud Storage.
   *
   * <p>For more details on export behavior and output format, refer to:
   * https://cloud.google.com/firestore/docs/manage-data/export-import
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   ExportDocumentsRequest request =
   *       ExportDocumentsRequest.newBuilder()
   *           .setName(DatabaseName.of("[PROJECT]", "[DATABASE]").toString())
   *           .addAllCollectionIds(new ArrayList<String>())
   *           .setOutputUriPrefix("outputUriPrefix499858205")
   *           .addAllNamespaceIds(new ArrayList<String>())
   *           .setSnapshotTime(Timestamp.newBuilder().build())
   *           .build();
   *   ExportDocumentsResponse response = firestoreAdminClient.exportDocumentsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportDocumentsResponse, ExportDocumentsMetadata>
      exportDocumentsAsync(ExportDocumentsRequest request) {
    return exportDocumentsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports a copy of all or a subset of documents from Google Cloud Firestore to another storage
   * system, such as Google Cloud Storage. Recent updates to documents may not be reflected in the
   * export. The export occurs in the background and its progress can be monitored and managed via
   * the Operation resource that is created. The output of an export may only be used once the
   * associated operation is done. If an export operation is cancelled before completion it may
   * leave partial data behind in Google Cloud Storage.
   *
   * <p>For more details on export behavior and output format, refer to:
   * https://cloud.google.com/firestore/docs/manage-data/export-import
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   ExportDocumentsRequest request =
   *       ExportDocumentsRequest.newBuilder()
   *           .setName(DatabaseName.of("[PROJECT]", "[DATABASE]").toString())
   *           .addAllCollectionIds(new ArrayList<String>())
   *           .setOutputUriPrefix("outputUriPrefix499858205")
   *           .addAllNamespaceIds(new ArrayList<String>())
   *           .setSnapshotTime(Timestamp.newBuilder().build())
   *           .build();
   *   OperationFuture<ExportDocumentsResponse, ExportDocumentsMetadata> future =
   *       firestoreAdminClient.exportDocumentsOperationCallable().futureCall(request);
   *   // Do something.
   *   ExportDocumentsResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          ExportDocumentsRequest, ExportDocumentsResponse, ExportDocumentsMetadata>
      exportDocumentsOperationCallable() {
    return stub.exportDocumentsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports a copy of all or a subset of documents from Google Cloud Firestore to another storage
   * system, such as Google Cloud Storage. Recent updates to documents may not be reflected in the
   * export. The export occurs in the background and its progress can be monitored and managed via
   * the Operation resource that is created. The output of an export may only be used once the
   * associated operation is done. If an export operation is cancelled before completion it may
   * leave partial data behind in Google Cloud Storage.
   *
   * <p>For more details on export behavior and output format, refer to:
   * https://cloud.google.com/firestore/docs/manage-data/export-import
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   ExportDocumentsRequest request =
   *       ExportDocumentsRequest.newBuilder()
   *           .setName(DatabaseName.of("[PROJECT]", "[DATABASE]").toString())
   *           .addAllCollectionIds(new ArrayList<String>())
   *           .setOutputUriPrefix("outputUriPrefix499858205")
   *           .addAllNamespaceIds(new ArrayList<String>())
   *           .setSnapshotTime(Timestamp.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       firestoreAdminClient.exportDocumentsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ExportDocumentsRequest, Operation> exportDocumentsCallable() {
    return stub.exportDocumentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports documents into Google Cloud Firestore. Existing documents with the same name are
   * overwritten. The import occurs in the background and its progress can be monitored and managed
   * via the Operation resource that is created. If an ImportDocuments operation is cancelled, it is
   * possible that a subset of the data has already been imported to Cloud Firestore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   DatabaseName name = DatabaseName.of("[PROJECT]", "[DATABASE]");
   *   firestoreAdminClient.importDocumentsAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Database to import into. Should be of the form:
   *     `projects/{project_id}/databases/{database_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, ImportDocumentsMetadata> importDocumentsAsync(
      DatabaseName name) {
    ImportDocumentsRequest request =
        ImportDocumentsRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return importDocumentsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports documents into Google Cloud Firestore. Existing documents with the same name are
   * overwritten. The import occurs in the background and its progress can be monitored and managed
   * via the Operation resource that is created. If an ImportDocuments operation is cancelled, it is
   * possible that a subset of the data has already been imported to Cloud Firestore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   String name = DatabaseName.of("[PROJECT]", "[DATABASE]").toString();
   *   firestoreAdminClient.importDocumentsAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Database to import into. Should be of the form:
   *     `projects/{project_id}/databases/{database_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, ImportDocumentsMetadata> importDocumentsAsync(String name) {
    ImportDocumentsRequest request = ImportDocumentsRequest.newBuilder().setName(name).build();
    return importDocumentsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports documents into Google Cloud Firestore. Existing documents with the same name are
   * overwritten. The import occurs in the background and its progress can be monitored and managed
   * via the Operation resource that is created. If an ImportDocuments operation is cancelled, it is
   * possible that a subset of the data has already been imported to Cloud Firestore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   ImportDocumentsRequest request =
   *       ImportDocumentsRequest.newBuilder()
   *           .setName(DatabaseName.of("[PROJECT]", "[DATABASE]").toString())
   *           .addAllCollectionIds(new ArrayList<String>())
   *           .setInputUriPrefix("inputUriPrefix-97481100")
   *           .addAllNamespaceIds(new ArrayList<String>())
   *           .build();
   *   firestoreAdminClient.importDocumentsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, ImportDocumentsMetadata> importDocumentsAsync(
      ImportDocumentsRequest request) {
    return importDocumentsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports documents into Google Cloud Firestore. Existing documents with the same name are
   * overwritten. The import occurs in the background and its progress can be monitored and managed
   * via the Operation resource that is created. If an ImportDocuments operation is cancelled, it is
   * possible that a subset of the data has already been imported to Cloud Firestore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   ImportDocumentsRequest request =
   *       ImportDocumentsRequest.newBuilder()
   *           .setName(DatabaseName.of("[PROJECT]", "[DATABASE]").toString())
   *           .addAllCollectionIds(new ArrayList<String>())
   *           .setInputUriPrefix("inputUriPrefix-97481100")
   *           .addAllNamespaceIds(new ArrayList<String>())
   *           .build();
   *   OperationFuture<Empty, ImportDocumentsMetadata> future =
   *       firestoreAdminClient.importDocumentsOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ImportDocumentsRequest, Empty, ImportDocumentsMetadata>
      importDocumentsOperationCallable() {
    return stub.importDocumentsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports documents into Google Cloud Firestore. Existing documents with the same name are
   * overwritten. The import occurs in the background and its progress can be monitored and managed
   * via the Operation resource that is created. If an ImportDocuments operation is cancelled, it is
   * possible that a subset of the data has already been imported to Cloud Firestore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   ImportDocumentsRequest request =
   *       ImportDocumentsRequest.newBuilder()
   *           .setName(DatabaseName.of("[PROJECT]", "[DATABASE]").toString())
   *           .addAllCollectionIds(new ArrayList<String>())
   *           .setInputUriPrefix("inputUriPrefix-97481100")
   *           .addAllNamespaceIds(new ArrayList<String>())
   *           .build();
   *   ApiFuture<Operation> future =
   *       firestoreAdminClient.importDocumentsCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ImportDocumentsRequest, Operation> importDocumentsCallable() {
    return stub.importDocumentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Bulk deletes a subset of documents from Google Cloud Firestore. Documents created or updated
   * after the underlying system starts to process the request will not be deleted. The bulk delete
   * occurs in the background and its progress can be monitored and managed via the Operation
   * resource that is created.
   *
   * <p>For more details on bulk delete behavior, refer to:
   * https://cloud.google.com/firestore/docs/manage-data/bulk-delete
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   DatabaseName name = DatabaseName.of("[PROJECT]", "[DATABASE]");
   *   BulkDeleteDocumentsResponse response =
   *       firestoreAdminClient.bulkDeleteDocumentsAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Database to operate. Should be of the form:
   *     `projects/{project_id}/databases/{database_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BulkDeleteDocumentsResponse, BulkDeleteDocumentsMetadata>
      bulkDeleteDocumentsAsync(DatabaseName name) {
    BulkDeleteDocumentsRequest request =
        BulkDeleteDocumentsRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return bulkDeleteDocumentsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Bulk deletes a subset of documents from Google Cloud Firestore. Documents created or updated
   * after the underlying system starts to process the request will not be deleted. The bulk delete
   * occurs in the background and its progress can be monitored and managed via the Operation
   * resource that is created.
   *
   * <p>For more details on bulk delete behavior, refer to:
   * https://cloud.google.com/firestore/docs/manage-data/bulk-delete
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   String name = DatabaseName.of("[PROJECT]", "[DATABASE]").toString();
   *   BulkDeleteDocumentsResponse response =
   *       firestoreAdminClient.bulkDeleteDocumentsAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Database to operate. Should be of the form:
   *     `projects/{project_id}/databases/{database_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BulkDeleteDocumentsResponse, BulkDeleteDocumentsMetadata>
      bulkDeleteDocumentsAsync(String name) {
    BulkDeleteDocumentsRequest request =
        BulkDeleteDocumentsRequest.newBuilder().setName(name).build();
    return bulkDeleteDocumentsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Bulk deletes a subset of documents from Google Cloud Firestore. Documents created or updated
   * after the underlying system starts to process the request will not be deleted. The bulk delete
   * occurs in the background and its progress can be monitored and managed via the Operation
   * resource that is created.
   *
   * <p>For more details on bulk delete behavior, refer to:
   * https://cloud.google.com/firestore/docs/manage-data/bulk-delete
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   BulkDeleteDocumentsRequest request =
   *       BulkDeleteDocumentsRequest.newBuilder()
   *           .setName(DatabaseName.of("[PROJECT]", "[DATABASE]").toString())
   *           .addAllCollectionIds(new ArrayList<String>())
   *           .addAllNamespaceIds(new ArrayList<String>())
   *           .build();
   *   BulkDeleteDocumentsResponse response =
   *       firestoreAdminClient.bulkDeleteDocumentsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BulkDeleteDocumentsResponse, BulkDeleteDocumentsMetadata>
      bulkDeleteDocumentsAsync(BulkDeleteDocumentsRequest request) {
    return bulkDeleteDocumentsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Bulk deletes a subset of documents from Google Cloud Firestore. Documents created or updated
   * after the underlying system starts to process the request will not be deleted. The bulk delete
   * occurs in the background and its progress can be monitored and managed via the Operation
   * resource that is created.
   *
   * <p>For more details on bulk delete behavior, refer to:
   * https://cloud.google.com/firestore/docs/manage-data/bulk-delete
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   BulkDeleteDocumentsRequest request =
   *       BulkDeleteDocumentsRequest.newBuilder()
   *           .setName(DatabaseName.of("[PROJECT]", "[DATABASE]").toString())
   *           .addAllCollectionIds(new ArrayList<String>())
   *           .addAllNamespaceIds(new ArrayList<String>())
   *           .build();
   *   OperationFuture<BulkDeleteDocumentsResponse, BulkDeleteDocumentsMetadata> future =
   *       firestoreAdminClient.bulkDeleteDocumentsOperationCallable().futureCall(request);
   *   // Do something.
   *   BulkDeleteDocumentsResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          BulkDeleteDocumentsRequest, BulkDeleteDocumentsResponse, BulkDeleteDocumentsMetadata>
      bulkDeleteDocumentsOperationCallable() {
    return stub.bulkDeleteDocumentsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Bulk deletes a subset of documents from Google Cloud Firestore. Documents created or updated
   * after the underlying system starts to process the request will not be deleted. The bulk delete
   * occurs in the background and its progress can be monitored and managed via the Operation
   * resource that is created.
   *
   * <p>For more details on bulk delete behavior, refer to:
   * https://cloud.google.com/firestore/docs/manage-data/bulk-delete
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   BulkDeleteDocumentsRequest request =
   *       BulkDeleteDocumentsRequest.newBuilder()
   *           .setName(DatabaseName.of("[PROJECT]", "[DATABASE]").toString())
   *           .addAllCollectionIds(new ArrayList<String>())
   *           .addAllNamespaceIds(new ArrayList<String>())
   *           .build();
   *   ApiFuture<Operation> future =
   *       firestoreAdminClient.bulkDeleteDocumentsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BulkDeleteDocumentsRequest, Operation> bulkDeleteDocumentsCallable() {
    return stub.bulkDeleteDocumentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   Database database = Database.newBuilder().build();
   *   String databaseId = "databaseId1688905718";
   *   Database response =
   *       firestoreAdminClient.createDatabaseAsync(parent, database, databaseId).get();
   * }
   * }</pre>
   *
   * @param parent Required. A parent name of the form `projects/{project_id}`
   * @param database Required. The Database to create.
   * @param databaseId Required. The ID to use for the database, which will become the final
   *     component of the database's resource name.
   *     <p>This value should be 4-63 characters. Valid characters are /[a-z][0-9]-/ with first
   *     character a letter and the last a letter or a number. Must not be UUID-like
   *     /[0-9a-f]{8}(-[0-9a-f]{4}){3}-[0-9a-f]{12}/.
   *     <p>"(default)" database ID is also valid.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Database, CreateDatabaseMetadata> createDatabaseAsync(
      ProjectName parent, Database database, String databaseId) {
    CreateDatabaseRequest request =
        CreateDatabaseRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDatabase(database)
            .setDatabaseId(databaseId)
            .build();
    return createDatabaseAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   Database database = Database.newBuilder().build();
   *   String databaseId = "databaseId1688905718";
   *   Database response =
   *       firestoreAdminClient.createDatabaseAsync(parent, database, databaseId).get();
   * }
   * }</pre>
   *
   * @param parent Required. A parent name of the form `projects/{project_id}`
   * @param database Required. The Database to create.
   * @param databaseId Required. The ID to use for the database, which will become the final
   *     component of the database's resource name.
   *     <p>This value should be 4-63 characters. Valid characters are /[a-z][0-9]-/ with first
   *     character a letter and the last a letter or a number. Must not be UUID-like
   *     /[0-9a-f]{8}(-[0-9a-f]{4}){3}-[0-9a-f]{12}/.
   *     <p>"(default)" database ID is also valid.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Database, CreateDatabaseMetadata> createDatabaseAsync(
      String parent, Database database, String databaseId) {
    CreateDatabaseRequest request =
        CreateDatabaseRequest.newBuilder()
            .setParent(parent)
            .setDatabase(database)
            .setDatabaseId(databaseId)
            .build();
    return createDatabaseAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   CreateDatabaseRequest request =
   *       CreateDatabaseRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setDatabase(Database.newBuilder().build())
   *           .setDatabaseId("databaseId1688905718")
   *           .build();
   *   Database response = firestoreAdminClient.createDatabaseAsync(request).get();
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
   * Create a database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   CreateDatabaseRequest request =
   *       CreateDatabaseRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setDatabase(Database.newBuilder().build())
   *           .setDatabaseId("databaseId1688905718")
   *           .build();
   *   OperationFuture<Database, CreateDatabaseMetadata> future =
   *       firestoreAdminClient.createDatabaseOperationCallable().futureCall(request);
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
   * Create a database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   CreateDatabaseRequest request =
   *       CreateDatabaseRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setDatabase(Database.newBuilder().build())
   *           .setDatabaseId("databaseId1688905718")
   *           .build();
   *   ApiFuture<Operation> future =
   *       firestoreAdminClient.createDatabaseCallable().futureCall(request);
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
   * Gets information about a database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   DatabaseName name = DatabaseName.of("[PROJECT]", "[DATABASE]");
   *   Database response = firestoreAdminClient.getDatabase(name);
   * }
   * }</pre>
   *
   * @param name Required. A name of the form `projects/{project_id}/databases/{database_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Database getDatabase(DatabaseName name) {
    GetDatabaseRequest request =
        GetDatabaseRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getDatabase(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   String name = DatabaseName.of("[PROJECT]", "[DATABASE]").toString();
   *   Database response = firestoreAdminClient.getDatabase(name);
   * }
   * }</pre>
   *
   * @param name Required. A name of the form `projects/{project_id}/databases/{database_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Database getDatabase(String name) {
    GetDatabaseRequest request = GetDatabaseRequest.newBuilder().setName(name).build();
    return getDatabase(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   GetDatabaseRequest request =
   *       GetDatabaseRequest.newBuilder()
   *           .setName(DatabaseName.of("[PROJECT]", "[DATABASE]").toString())
   *           .build();
   *   Database response = firestoreAdminClient.getDatabase(request);
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
   * Gets information about a database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   GetDatabaseRequest request =
   *       GetDatabaseRequest.newBuilder()
   *           .setName(DatabaseName.of("[PROJECT]", "[DATABASE]").toString())
   *           .build();
   *   ApiFuture<Database> future = firestoreAdminClient.getDatabaseCallable().futureCall(request);
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
   * List all the databases in the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   ListDatabasesResponse response = firestoreAdminClient.listDatabases(parent);
   * }
   * }</pre>
   *
   * @param parent Required. A parent name of the form `projects/{project_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDatabasesResponse listDatabases(ProjectName parent) {
    ListDatabasesRequest request =
        ListDatabasesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDatabases(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all the databases in the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   ListDatabasesResponse response = firestoreAdminClient.listDatabases(parent);
   * }
   * }</pre>
   *
   * @param parent Required. A parent name of the form `projects/{project_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDatabasesResponse listDatabases(String parent) {
    ListDatabasesRequest request = ListDatabasesRequest.newBuilder().setParent(parent).build();
    return listDatabases(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all the databases in the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   ListDatabasesRequest request =
   *       ListDatabasesRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setShowDeleted(true)
   *           .build();
   *   ListDatabasesResponse response = firestoreAdminClient.listDatabases(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDatabasesResponse listDatabases(ListDatabasesRequest request) {
    return listDatabasesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all the databases in the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   ListDatabasesRequest request =
   *       ListDatabasesRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setShowDeleted(true)
   *           .build();
   *   ApiFuture<ListDatabasesResponse> future =
   *       firestoreAdminClient.listDatabasesCallable().futureCall(request);
   *   // Do something.
   *   ListDatabasesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDatabasesRequest, ListDatabasesResponse> listDatabasesCallable() {
    return stub.listDatabasesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   Database database = Database.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Database response = firestoreAdminClient.updateDatabaseAsync(database, updateMask).get();
   * }
   * }</pre>
   *
   * @param database Required. The database to update.
   * @param updateMask The list of fields to be updated.
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
   * Updates a database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   UpdateDatabaseRequest request =
   *       UpdateDatabaseRequest.newBuilder()
   *           .setDatabase(Database.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Database response = firestoreAdminClient.updateDatabaseAsync(request).get();
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
   * Updates a database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   UpdateDatabaseRequest request =
   *       UpdateDatabaseRequest.newBuilder()
   *           .setDatabase(Database.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<Database, UpdateDatabaseMetadata> future =
   *       firestoreAdminClient.updateDatabaseOperationCallable().futureCall(request);
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
   * Updates a database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   UpdateDatabaseRequest request =
   *       UpdateDatabaseRequest.newBuilder()
   *           .setDatabase(Database.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       firestoreAdminClient.updateDatabaseCallable().futureCall(request);
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
   * Deletes a database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   DatabaseName name = DatabaseName.of("[PROJECT]", "[DATABASE]");
   *   Database response = firestoreAdminClient.deleteDatabaseAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. A name of the form `projects/{project_id}/databases/{database_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Database, DeleteDatabaseMetadata> deleteDatabaseAsync(
      DatabaseName name) {
    DeleteDatabaseRequest request =
        DeleteDatabaseRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteDatabaseAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   String name = DatabaseName.of("[PROJECT]", "[DATABASE]").toString();
   *   Database response = firestoreAdminClient.deleteDatabaseAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. A name of the form `projects/{project_id}/databases/{database_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Database, DeleteDatabaseMetadata> deleteDatabaseAsync(String name) {
    DeleteDatabaseRequest request = DeleteDatabaseRequest.newBuilder().setName(name).build();
    return deleteDatabaseAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   DeleteDatabaseRequest request =
   *       DeleteDatabaseRequest.newBuilder()
   *           .setName(DatabaseName.of("[PROJECT]", "[DATABASE]").toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   Database response = firestoreAdminClient.deleteDatabaseAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Database, DeleteDatabaseMetadata> deleteDatabaseAsync(
      DeleteDatabaseRequest request) {
    return deleteDatabaseOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   DeleteDatabaseRequest request =
   *       DeleteDatabaseRequest.newBuilder()
   *           .setName(DatabaseName.of("[PROJECT]", "[DATABASE]").toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<Database, DeleteDatabaseMetadata> future =
   *       firestoreAdminClient.deleteDatabaseOperationCallable().futureCall(request);
   *   // Do something.
   *   Database response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteDatabaseRequest, Database, DeleteDatabaseMetadata>
      deleteDatabaseOperationCallable() {
    return stub.deleteDatabaseOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   DeleteDatabaseRequest request =
   *       DeleteDatabaseRequest.newBuilder()
   *           .setName(DatabaseName.of("[PROJECT]", "[DATABASE]").toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future =
   *       firestoreAdminClient.deleteDatabaseCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteDatabaseRequest, Operation> deleteDatabaseCallable() {
    return stub.deleteDatabaseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   BackupName name = BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP]");
   *   Backup response = firestoreAdminClient.getBackup(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the backup to fetch.
   *     <p>Format is `projects/{project}/locations/{location}/backups/{backup}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Backup getBackup(BackupName name) {
    GetBackupRequest request =
        GetBackupRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getBackup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   String name = BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP]").toString();
   *   Backup response = firestoreAdminClient.getBackup(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the backup to fetch.
   *     <p>Format is `projects/{project}/locations/{location}/backups/{backup}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Backup getBackup(String name) {
    GetBackupRequest request = GetBackupRequest.newBuilder().setName(name).build();
    return getBackup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   GetBackupRequest request =
   *       GetBackupRequest.newBuilder()
   *           .setName(BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP]").toString())
   *           .build();
   *   Backup response = firestoreAdminClient.getBackup(request);
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
   * Gets information about a backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   GetBackupRequest request =
   *       GetBackupRequest.newBuilder()
   *           .setName(BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP]").toString())
   *           .build();
   *   ApiFuture<Backup> future = firestoreAdminClient.getBackupCallable().futureCall(request);
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
   * Lists all the backups.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ListBackupsResponse response = firestoreAdminClient.listBackups(parent);
   * }
   * }</pre>
   *
   * @param parent Required. The location to list backups from.
   *     <p>Format is `projects/{project}/locations/{location}`. Use `{location} = '-'` to list
   *     backups from all locations for the given project. This allows listing backups from a single
   *     location or from all locations.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupsResponse listBackups(LocationName parent) {
    ListBackupsRequest request =
        ListBackupsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listBackups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the backups.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   ListBackupsResponse response = firestoreAdminClient.listBackups(parent);
   * }
   * }</pre>
   *
   * @param parent Required. The location to list backups from.
   *     <p>Format is `projects/{project}/locations/{location}`. Use `{location} = '-'` to list
   *     backups from all locations for the given project. This allows listing backups from a single
   *     location or from all locations.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupsResponse listBackups(String parent) {
    ListBackupsRequest request = ListBackupsRequest.newBuilder().setParent(parent).build();
    return listBackups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the backups.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   ListBackupsRequest request =
   *       ListBackupsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ListBackupsResponse response = firestoreAdminClient.listBackups(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupsResponse listBackups(ListBackupsRequest request) {
    return listBackupsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the backups.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   ListBackupsRequest request =
   *       ListBackupsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<ListBackupsResponse> future =
   *       firestoreAdminClient.listBackupsCallable().futureCall(request);
   *   // Do something.
   *   ListBackupsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ListBackupsRequest, ListBackupsResponse> listBackupsCallable() {
    return stub.listBackupsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   BackupName name = BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP]");
   *   firestoreAdminClient.deleteBackup(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the backup to delete.
   *     <p>format is `projects/{project}/locations/{location}/backups/{backup}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteBackup(BackupName name) {
    DeleteBackupRequest request =
        DeleteBackupRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteBackup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   String name = BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP]").toString();
   *   firestoreAdminClient.deleteBackup(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the backup to delete.
   *     <p>format is `projects/{project}/locations/{location}/backups/{backup}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteBackup(String name) {
    DeleteBackupRequest request = DeleteBackupRequest.newBuilder().setName(name).build();
    deleteBackup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   DeleteBackupRequest request =
   *       DeleteBackupRequest.newBuilder()
   *           .setName(BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP]").toString())
   *           .build();
   *   firestoreAdminClient.deleteBackup(request);
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
   * Deletes a backup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   DeleteBackupRequest request =
   *       DeleteBackupRequest.newBuilder()
   *           .setName(BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP]").toString())
   *           .build();
   *   ApiFuture<Empty> future = firestoreAdminClient.deleteBackupCallable().futureCall(request);
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
   * Creates a new database by restoring from an existing backup.
   *
   * <p>The new database must be in the same cloud region or multi-region location as the existing
   * backup. This behaves similar to
   * [FirestoreAdmin.CreateDatabase][google.firestore.admin.v1.FirestoreAdmin.CreateDatabase] except
   * instead of creating a new empty database, a new database is created with the database type,
   * index configuration, and documents from an existing backup.
   *
   * <p>The [long-running operation][google.longrunning.Operation] can be used to track the progress
   * of the restore, with the Operation's [metadata][google.longrunning.Operation.metadata] field
   * type being the [RestoreDatabaseMetadata][google.firestore.admin.v1.RestoreDatabaseMetadata].
   * The [response][google.longrunning.Operation.response] type is the
   * [Database][google.firestore.admin.v1.Database] if the restore was successful. The new database
   * is not readable or writeable until the LRO has completed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   RestoreDatabaseRequest request =
   *       RestoreDatabaseRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setDatabaseId("databaseId1688905718")
   *           .setBackup(BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP]").toString())
   *           .setEncryptionConfig(Database.EncryptionConfig.newBuilder().build())
   *           .build();
   *   Database response = firestoreAdminClient.restoreDatabaseAsync(request).get();
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
   * Creates a new database by restoring from an existing backup.
   *
   * <p>The new database must be in the same cloud region or multi-region location as the existing
   * backup. This behaves similar to
   * [FirestoreAdmin.CreateDatabase][google.firestore.admin.v1.FirestoreAdmin.CreateDatabase] except
   * instead of creating a new empty database, a new database is created with the database type,
   * index configuration, and documents from an existing backup.
   *
   * <p>The [long-running operation][google.longrunning.Operation] can be used to track the progress
   * of the restore, with the Operation's [metadata][google.longrunning.Operation.metadata] field
   * type being the [RestoreDatabaseMetadata][google.firestore.admin.v1.RestoreDatabaseMetadata].
   * The [response][google.longrunning.Operation.response] type is the
   * [Database][google.firestore.admin.v1.Database] if the restore was successful. The new database
   * is not readable or writeable until the LRO has completed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   RestoreDatabaseRequest request =
   *       RestoreDatabaseRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setDatabaseId("databaseId1688905718")
   *           .setBackup(BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP]").toString())
   *           .setEncryptionConfig(Database.EncryptionConfig.newBuilder().build())
   *           .build();
   *   OperationFuture<Database, RestoreDatabaseMetadata> future =
   *       firestoreAdminClient.restoreDatabaseOperationCallable().futureCall(request);
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
   * Creates a new database by restoring from an existing backup.
   *
   * <p>The new database must be in the same cloud region or multi-region location as the existing
   * backup. This behaves similar to
   * [FirestoreAdmin.CreateDatabase][google.firestore.admin.v1.FirestoreAdmin.CreateDatabase] except
   * instead of creating a new empty database, a new database is created with the database type,
   * index configuration, and documents from an existing backup.
   *
   * <p>The [long-running operation][google.longrunning.Operation] can be used to track the progress
   * of the restore, with the Operation's [metadata][google.longrunning.Operation.metadata] field
   * type being the [RestoreDatabaseMetadata][google.firestore.admin.v1.RestoreDatabaseMetadata].
   * The [response][google.longrunning.Operation.response] type is the
   * [Database][google.firestore.admin.v1.Database] if the restore was successful. The new database
   * is not readable or writeable until the LRO has completed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   RestoreDatabaseRequest request =
   *       RestoreDatabaseRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setDatabaseId("databaseId1688905718")
   *           .setBackup(BackupName.of("[PROJECT]", "[LOCATION]", "[BACKUP]").toString())
   *           .setEncryptionConfig(Database.EncryptionConfig.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       firestoreAdminClient.restoreDatabaseCallable().futureCall(request);
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
   * Creates a backup schedule on a database. At most two backup schedules can be configured on a
   * database, one daily backup schedule and one weekly backup schedule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   DatabaseName parent = DatabaseName.of("[PROJECT]", "[DATABASE]");
   *   BackupSchedule backupSchedule = BackupSchedule.newBuilder().build();
   *   BackupSchedule response = firestoreAdminClient.createBackupSchedule(parent, backupSchedule);
   * }
   * }</pre>
   *
   * @param parent Required. The parent database.
   *     <p>Format `projects/{project}/databases/{database}`
   * @param backupSchedule Required. The backup schedule to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BackupSchedule createBackupSchedule(
      DatabaseName parent, BackupSchedule backupSchedule) {
    CreateBackupScheduleRequest request =
        CreateBackupScheduleRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setBackupSchedule(backupSchedule)
            .build();
    return createBackupSchedule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a backup schedule on a database. At most two backup schedules can be configured on a
   * database, one daily backup schedule and one weekly backup schedule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   String parent = DatabaseName.of("[PROJECT]", "[DATABASE]").toString();
   *   BackupSchedule backupSchedule = BackupSchedule.newBuilder().build();
   *   BackupSchedule response = firestoreAdminClient.createBackupSchedule(parent, backupSchedule);
   * }
   * }</pre>
   *
   * @param parent Required. The parent database.
   *     <p>Format `projects/{project}/databases/{database}`
   * @param backupSchedule Required. The backup schedule to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BackupSchedule createBackupSchedule(String parent, BackupSchedule backupSchedule) {
    CreateBackupScheduleRequest request =
        CreateBackupScheduleRequest.newBuilder()
            .setParent(parent)
            .setBackupSchedule(backupSchedule)
            .build();
    return createBackupSchedule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a backup schedule on a database. At most two backup schedules can be configured on a
   * database, one daily backup schedule and one weekly backup schedule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   CreateBackupScheduleRequest request =
   *       CreateBackupScheduleRequest.newBuilder()
   *           .setParent(DatabaseName.of("[PROJECT]", "[DATABASE]").toString())
   *           .setBackupSchedule(BackupSchedule.newBuilder().build())
   *           .build();
   *   BackupSchedule response = firestoreAdminClient.createBackupSchedule(request);
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
   * Creates a backup schedule on a database. At most two backup schedules can be configured on a
   * database, one daily backup schedule and one weekly backup schedule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   CreateBackupScheduleRequest request =
   *       CreateBackupScheduleRequest.newBuilder()
   *           .setParent(DatabaseName.of("[PROJECT]", "[DATABASE]").toString())
   *           .setBackupSchedule(BackupSchedule.newBuilder().build())
   *           .build();
   *   ApiFuture<BackupSchedule> future =
   *       firestoreAdminClient.createBackupScheduleCallable().futureCall(request);
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
   * Gets information about a backup schedule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   BackupScheduleName name =
   *       BackupScheduleName.of("[PROJECT]", "[DATABASE]", "[BACKUP_SCHEDULE]");
   *   BackupSchedule response = firestoreAdminClient.getBackupSchedule(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the backup schedule.
   *     <p>Format `projects/{project}/databases/{database}/backupSchedules/{backup_schedule}`
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
   * Gets information about a backup schedule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   String name =
   *       BackupScheduleName.of("[PROJECT]", "[DATABASE]", "[BACKUP_SCHEDULE]").toString();
   *   BackupSchedule response = firestoreAdminClient.getBackupSchedule(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the backup schedule.
   *     <p>Format `projects/{project}/databases/{database}/backupSchedules/{backup_schedule}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BackupSchedule getBackupSchedule(String name) {
    GetBackupScheduleRequest request = GetBackupScheduleRequest.newBuilder().setName(name).build();
    return getBackupSchedule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a backup schedule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   GetBackupScheduleRequest request =
   *       GetBackupScheduleRequest.newBuilder()
   *           .setName(
   *               BackupScheduleName.of("[PROJECT]", "[DATABASE]", "[BACKUP_SCHEDULE]").toString())
   *           .build();
   *   BackupSchedule response = firestoreAdminClient.getBackupSchedule(request);
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
   * Gets information about a backup schedule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   GetBackupScheduleRequest request =
   *       GetBackupScheduleRequest.newBuilder()
   *           .setName(
   *               BackupScheduleName.of("[PROJECT]", "[DATABASE]", "[BACKUP_SCHEDULE]").toString())
   *           .build();
   *   ApiFuture<BackupSchedule> future =
   *       firestoreAdminClient.getBackupScheduleCallable().futureCall(request);
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
   * List backup schedules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   DatabaseName parent = DatabaseName.of("[PROJECT]", "[DATABASE]");
   *   ListBackupSchedulesResponse response = firestoreAdminClient.listBackupSchedules(parent);
   * }
   * }</pre>
   *
   * @param parent Required. The parent database.
   *     <p>Format is `projects/{project}/databases/{database}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupSchedulesResponse listBackupSchedules(DatabaseName parent) {
    ListBackupSchedulesRequest request =
        ListBackupSchedulesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listBackupSchedules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List backup schedules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   String parent = DatabaseName.of("[PROJECT]", "[DATABASE]").toString();
   *   ListBackupSchedulesResponse response = firestoreAdminClient.listBackupSchedules(parent);
   * }
   * }</pre>
   *
   * @param parent Required. The parent database.
   *     <p>Format is `projects/{project}/databases/{database}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupSchedulesResponse listBackupSchedules(String parent) {
    ListBackupSchedulesRequest request =
        ListBackupSchedulesRequest.newBuilder().setParent(parent).build();
    return listBackupSchedules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List backup schedules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   ListBackupSchedulesRequest request =
   *       ListBackupSchedulesRequest.newBuilder()
   *           .setParent(DatabaseName.of("[PROJECT]", "[DATABASE]").toString())
   *           .build();
   *   ListBackupSchedulesResponse response = firestoreAdminClient.listBackupSchedules(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBackupSchedulesResponse listBackupSchedules(ListBackupSchedulesRequest request) {
    return listBackupSchedulesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List backup schedules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   ListBackupSchedulesRequest request =
   *       ListBackupSchedulesRequest.newBuilder()
   *           .setParent(DatabaseName.of("[PROJECT]", "[DATABASE]").toString())
   *           .build();
   *   ApiFuture<ListBackupSchedulesResponse> future =
   *       firestoreAdminClient.listBackupSchedulesCallable().futureCall(request);
   *   // Do something.
   *   ListBackupSchedulesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ListBackupSchedulesRequest, ListBackupSchedulesResponse>
      listBackupSchedulesCallable() {
    return stub.listBackupSchedulesCallable();
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
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   BackupSchedule backupSchedule = BackupSchedule.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   BackupSchedule response =
   *       firestoreAdminClient.updateBackupSchedule(backupSchedule, updateMask);
   * }
   * }</pre>
   *
   * @param backupSchedule Required. The backup schedule to update.
   * @param updateMask The list of fields to be updated.
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
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   UpdateBackupScheduleRequest request =
   *       UpdateBackupScheduleRequest.newBuilder()
   *           .setBackupSchedule(BackupSchedule.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   BackupSchedule response = firestoreAdminClient.updateBackupSchedule(request);
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
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   UpdateBackupScheduleRequest request =
   *       UpdateBackupScheduleRequest.newBuilder()
   *           .setBackupSchedule(BackupSchedule.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<BackupSchedule> future =
   *       firestoreAdminClient.updateBackupScheduleCallable().futureCall(request);
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
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   BackupScheduleName name =
   *       BackupScheduleName.of("[PROJECT]", "[DATABASE]", "[BACKUP_SCHEDULE]");
   *   firestoreAdminClient.deleteBackupSchedule(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the backup schedule.
   *     <p>Format `projects/{project}/databases/{database}/backupSchedules/{backup_schedule}`
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
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   String name =
   *       BackupScheduleName.of("[PROJECT]", "[DATABASE]", "[BACKUP_SCHEDULE]").toString();
   *   firestoreAdminClient.deleteBackupSchedule(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the backup schedule.
   *     <p>Format `projects/{project}/databases/{database}/backupSchedules/{backup_schedule}`
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
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   DeleteBackupScheduleRequest request =
   *       DeleteBackupScheduleRequest.newBuilder()
   *           .setName(
   *               BackupScheduleName.of("[PROJECT]", "[DATABASE]", "[BACKUP_SCHEDULE]").toString())
   *           .build();
   *   firestoreAdminClient.deleteBackupSchedule(request);
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
   * try (FirestoreAdminClient firestoreAdminClient = FirestoreAdminClient.create()) {
   *   DeleteBackupScheduleRequest request =
   *       DeleteBackupScheduleRequest.newBuilder()
   *           .setName(
   *               BackupScheduleName.of("[PROJECT]", "[DATABASE]", "[BACKUP_SCHEDULE]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       firestoreAdminClient.deleteBackupScheduleCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteBackupScheduleRequest, Empty> deleteBackupScheduleCallable() {
    return stub.deleteBackupScheduleCallable();
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

  public static class ListIndexesPagedResponse
      extends AbstractPagedListResponse<
          ListIndexesRequest,
          ListIndexesResponse,
          Index,
          ListIndexesPage,
          ListIndexesFixedSizeCollection> {

    public static ApiFuture<ListIndexesPagedResponse> createAsync(
        PageContext<ListIndexesRequest, ListIndexesResponse, Index> context,
        ApiFuture<ListIndexesResponse> futureResponse) {
      ApiFuture<ListIndexesPage> futurePage =
          ListIndexesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListIndexesPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListIndexesPagedResponse(ListIndexesPage page) {
      super(page, ListIndexesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListIndexesPage
      extends AbstractPage<ListIndexesRequest, ListIndexesResponse, Index, ListIndexesPage> {

    private ListIndexesPage(
        PageContext<ListIndexesRequest, ListIndexesResponse, Index> context,
        ListIndexesResponse response) {
      super(context, response);
    }

    private static ListIndexesPage createEmptyPage() {
      return new ListIndexesPage(null, null);
    }

    @Override
    protected ListIndexesPage createPage(
        PageContext<ListIndexesRequest, ListIndexesResponse, Index> context,
        ListIndexesResponse response) {
      return new ListIndexesPage(context, response);
    }

    @Override
    public ApiFuture<ListIndexesPage> createPageAsync(
        PageContext<ListIndexesRequest, ListIndexesResponse, Index> context,
        ApiFuture<ListIndexesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListIndexesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListIndexesRequest,
          ListIndexesResponse,
          Index,
          ListIndexesPage,
          ListIndexesFixedSizeCollection> {

    private ListIndexesFixedSizeCollection(List<ListIndexesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListIndexesFixedSizeCollection createEmptyCollection() {
      return new ListIndexesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListIndexesFixedSizeCollection createCollection(
        List<ListIndexesPage> pages, int collectionSize) {
      return new ListIndexesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListFieldsPagedResponse
      extends AbstractPagedListResponse<
          ListFieldsRequest,
          ListFieldsResponse,
          Field,
          ListFieldsPage,
          ListFieldsFixedSizeCollection> {

    public static ApiFuture<ListFieldsPagedResponse> createAsync(
        PageContext<ListFieldsRequest, ListFieldsResponse, Field> context,
        ApiFuture<ListFieldsResponse> futureResponse) {
      ApiFuture<ListFieldsPage> futurePage =
          ListFieldsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListFieldsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListFieldsPagedResponse(ListFieldsPage page) {
      super(page, ListFieldsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListFieldsPage
      extends AbstractPage<ListFieldsRequest, ListFieldsResponse, Field, ListFieldsPage> {

    private ListFieldsPage(
        PageContext<ListFieldsRequest, ListFieldsResponse, Field> context,
        ListFieldsResponse response) {
      super(context, response);
    }

    private static ListFieldsPage createEmptyPage() {
      return new ListFieldsPage(null, null);
    }

    @Override
    protected ListFieldsPage createPage(
        PageContext<ListFieldsRequest, ListFieldsResponse, Field> context,
        ListFieldsResponse response) {
      return new ListFieldsPage(context, response);
    }

    @Override
    public ApiFuture<ListFieldsPage> createPageAsync(
        PageContext<ListFieldsRequest, ListFieldsResponse, Field> context,
        ApiFuture<ListFieldsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFieldsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListFieldsRequest,
          ListFieldsResponse,
          Field,
          ListFieldsPage,
          ListFieldsFixedSizeCollection> {

    private ListFieldsFixedSizeCollection(List<ListFieldsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListFieldsFixedSizeCollection createEmptyCollection() {
      return new ListFieldsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListFieldsFixedSizeCollection createCollection(
        List<ListFieldsPage> pages, int collectionSize) {
      return new ListFieldsFixedSizeCollection(pages, collectionSize);
    }
  }
}
