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

package com.google.cloud.firestore.v1.stub;

import static com.google.cloud.firestore.v1.FirestoreAdminClient.ListFieldsPagedResponse;
import static com.google.cloud.firestore.v1.FirestoreAdminClient.ListIndexesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.firestore.admin.v1.Backup;
import com.google.firestore.admin.v1.BackupSchedule;
import com.google.firestore.admin.v1.BulkDeleteDocumentsMetadata;
import com.google.firestore.admin.v1.BulkDeleteDocumentsRequest;
import com.google.firestore.admin.v1.BulkDeleteDocumentsResponse;
import com.google.firestore.admin.v1.CloneDatabaseMetadata;
import com.google.firestore.admin.v1.CloneDatabaseRequest;
import com.google.firestore.admin.v1.CreateBackupScheduleRequest;
import com.google.firestore.admin.v1.CreateDatabaseMetadata;
import com.google.firestore.admin.v1.CreateDatabaseRequest;
import com.google.firestore.admin.v1.CreateIndexRequest;
import com.google.firestore.admin.v1.CreateUserCredsRequest;
import com.google.firestore.admin.v1.Database;
import com.google.firestore.admin.v1.DeleteBackupRequest;
import com.google.firestore.admin.v1.DeleteBackupScheduleRequest;
import com.google.firestore.admin.v1.DeleteDatabaseMetadata;
import com.google.firestore.admin.v1.DeleteDatabaseRequest;
import com.google.firestore.admin.v1.DeleteIndexRequest;
import com.google.firestore.admin.v1.DeleteUserCredsRequest;
import com.google.firestore.admin.v1.DisableUserCredsRequest;
import com.google.firestore.admin.v1.EnableUserCredsRequest;
import com.google.firestore.admin.v1.ExportDocumentsMetadata;
import com.google.firestore.admin.v1.ExportDocumentsRequest;
import com.google.firestore.admin.v1.ExportDocumentsResponse;
import com.google.firestore.admin.v1.Field;
import com.google.firestore.admin.v1.FieldOperationMetadata;
import com.google.firestore.admin.v1.GetBackupRequest;
import com.google.firestore.admin.v1.GetBackupScheduleRequest;
import com.google.firestore.admin.v1.GetDatabaseRequest;
import com.google.firestore.admin.v1.GetFieldRequest;
import com.google.firestore.admin.v1.GetIndexRequest;
import com.google.firestore.admin.v1.GetUserCredsRequest;
import com.google.firestore.admin.v1.ImportDocumentsMetadata;
import com.google.firestore.admin.v1.ImportDocumentsRequest;
import com.google.firestore.admin.v1.Index;
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
import com.google.firestore.admin.v1.ListUserCredsRequest;
import com.google.firestore.admin.v1.ListUserCredsResponse;
import com.google.firestore.admin.v1.ResetUserPasswordRequest;
import com.google.firestore.admin.v1.RestoreDatabaseMetadata;
import com.google.firestore.admin.v1.RestoreDatabaseRequest;
import com.google.firestore.admin.v1.UpdateBackupScheduleRequest;
import com.google.firestore.admin.v1.UpdateDatabaseMetadata;
import com.google.firestore.admin.v1.UpdateDatabaseRequest;
import com.google.firestore.admin.v1.UpdateFieldRequest;
import com.google.firestore.admin.v1.UserCreds;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the FirestoreAdmin service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class FirestoreAdminStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public OperationCallable<CreateIndexRequest, Index, IndexOperationMetadata>
      createIndexOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createIndexOperationCallable()");
  }

  public UnaryCallable<CreateIndexRequest, Operation> createIndexCallable() {
    throw new UnsupportedOperationException("Not implemented: createIndexCallable()");
  }

  public UnaryCallable<ListIndexesRequest, ListIndexesPagedResponse> listIndexesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listIndexesPagedCallable()");
  }

  public UnaryCallable<ListIndexesRequest, ListIndexesResponse> listIndexesCallable() {
    throw new UnsupportedOperationException("Not implemented: listIndexesCallable()");
  }

  public UnaryCallable<GetIndexRequest, Index> getIndexCallable() {
    throw new UnsupportedOperationException("Not implemented: getIndexCallable()");
  }

  public UnaryCallable<DeleteIndexRequest, Empty> deleteIndexCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteIndexCallable()");
  }

  public UnaryCallable<GetFieldRequest, Field> getFieldCallable() {
    throw new UnsupportedOperationException("Not implemented: getFieldCallable()");
  }

  public OperationCallable<UpdateFieldRequest, Field, FieldOperationMetadata>
      updateFieldOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateFieldOperationCallable()");
  }

  public UnaryCallable<UpdateFieldRequest, Operation> updateFieldCallable() {
    throw new UnsupportedOperationException("Not implemented: updateFieldCallable()");
  }

  public UnaryCallable<ListFieldsRequest, ListFieldsPagedResponse> listFieldsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listFieldsPagedCallable()");
  }

  public UnaryCallable<ListFieldsRequest, ListFieldsResponse> listFieldsCallable() {
    throw new UnsupportedOperationException("Not implemented: listFieldsCallable()");
  }

  public OperationCallable<ExportDocumentsRequest, ExportDocumentsResponse, ExportDocumentsMetadata>
      exportDocumentsOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: exportDocumentsOperationCallable()");
  }

  public UnaryCallable<ExportDocumentsRequest, Operation> exportDocumentsCallable() {
    throw new UnsupportedOperationException("Not implemented: exportDocumentsCallable()");
  }

  public OperationCallable<ImportDocumentsRequest, Empty, ImportDocumentsMetadata>
      importDocumentsOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: importDocumentsOperationCallable()");
  }

  public UnaryCallable<ImportDocumentsRequest, Operation> importDocumentsCallable() {
    throw new UnsupportedOperationException("Not implemented: importDocumentsCallable()");
  }

  public OperationCallable<
          BulkDeleteDocumentsRequest, BulkDeleteDocumentsResponse, BulkDeleteDocumentsMetadata>
      bulkDeleteDocumentsOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: bulkDeleteDocumentsOperationCallable()");
  }

  public UnaryCallable<BulkDeleteDocumentsRequest, Operation> bulkDeleteDocumentsCallable() {
    throw new UnsupportedOperationException("Not implemented: bulkDeleteDocumentsCallable()");
  }

  public OperationCallable<CreateDatabaseRequest, Database, CreateDatabaseMetadata>
      createDatabaseOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createDatabaseOperationCallable()");
  }

  public UnaryCallable<CreateDatabaseRequest, Operation> createDatabaseCallable() {
    throw new UnsupportedOperationException("Not implemented: createDatabaseCallable()");
  }

  public UnaryCallable<GetDatabaseRequest, Database> getDatabaseCallable() {
    throw new UnsupportedOperationException("Not implemented: getDatabaseCallable()");
  }

  public UnaryCallable<ListDatabasesRequest, ListDatabasesResponse> listDatabasesCallable() {
    throw new UnsupportedOperationException("Not implemented: listDatabasesCallable()");
  }

  public OperationCallable<UpdateDatabaseRequest, Database, UpdateDatabaseMetadata>
      updateDatabaseOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateDatabaseOperationCallable()");
  }

  public UnaryCallable<UpdateDatabaseRequest, Operation> updateDatabaseCallable() {
    throw new UnsupportedOperationException("Not implemented: updateDatabaseCallable()");
  }

  public OperationCallable<DeleteDatabaseRequest, Database, DeleteDatabaseMetadata>
      deleteDatabaseOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteDatabaseOperationCallable()");
  }

  public UnaryCallable<DeleteDatabaseRequest, Operation> deleteDatabaseCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteDatabaseCallable()");
  }

  public UnaryCallable<CreateUserCredsRequest, UserCreds> createUserCredsCallable() {
    throw new UnsupportedOperationException("Not implemented: createUserCredsCallable()");
  }

  public UnaryCallable<GetUserCredsRequest, UserCreds> getUserCredsCallable() {
    throw new UnsupportedOperationException("Not implemented: getUserCredsCallable()");
  }

  public UnaryCallable<ListUserCredsRequest, ListUserCredsResponse> listUserCredsCallable() {
    throw new UnsupportedOperationException("Not implemented: listUserCredsCallable()");
  }

  public UnaryCallable<EnableUserCredsRequest, UserCreds> enableUserCredsCallable() {
    throw new UnsupportedOperationException("Not implemented: enableUserCredsCallable()");
  }

  public UnaryCallable<DisableUserCredsRequest, UserCreds> disableUserCredsCallable() {
    throw new UnsupportedOperationException("Not implemented: disableUserCredsCallable()");
  }

  public UnaryCallable<ResetUserPasswordRequest, UserCreds> resetUserPasswordCallable() {
    throw new UnsupportedOperationException("Not implemented: resetUserPasswordCallable()");
  }

  public UnaryCallable<DeleteUserCredsRequest, Empty> deleteUserCredsCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteUserCredsCallable()");
  }

  public UnaryCallable<GetBackupRequest, Backup> getBackupCallable() {
    throw new UnsupportedOperationException("Not implemented: getBackupCallable()");
  }

  public UnaryCallable<ListBackupsRequest, ListBackupsResponse> listBackupsCallable() {
    throw new UnsupportedOperationException("Not implemented: listBackupsCallable()");
  }

  public UnaryCallable<DeleteBackupRequest, Empty> deleteBackupCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteBackupCallable()");
  }

  public OperationCallable<RestoreDatabaseRequest, Database, RestoreDatabaseMetadata>
      restoreDatabaseOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: restoreDatabaseOperationCallable()");
  }

  public UnaryCallable<RestoreDatabaseRequest, Operation> restoreDatabaseCallable() {
    throw new UnsupportedOperationException("Not implemented: restoreDatabaseCallable()");
  }

  public UnaryCallable<CreateBackupScheduleRequest, BackupSchedule> createBackupScheduleCallable() {
    throw new UnsupportedOperationException("Not implemented: createBackupScheduleCallable()");
  }

  public UnaryCallable<GetBackupScheduleRequest, BackupSchedule> getBackupScheduleCallable() {
    throw new UnsupportedOperationException("Not implemented: getBackupScheduleCallable()");
  }

  public UnaryCallable<ListBackupSchedulesRequest, ListBackupSchedulesResponse>
      listBackupSchedulesCallable() {
    throw new UnsupportedOperationException("Not implemented: listBackupSchedulesCallable()");
  }

  public UnaryCallable<UpdateBackupScheduleRequest, BackupSchedule> updateBackupScheduleCallable() {
    throw new UnsupportedOperationException("Not implemented: updateBackupScheduleCallable()");
  }

  public UnaryCallable<DeleteBackupScheduleRequest, Empty> deleteBackupScheduleCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteBackupScheduleCallable()");
  }

  public OperationCallable<CloneDatabaseRequest, Database, CloneDatabaseMetadata>
      cloneDatabaseOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: cloneDatabaseOperationCallable()");
  }

  public UnaryCallable<CloneDatabaseRequest, Operation> cloneDatabaseCallable() {
    throw new UnsupportedOperationException("Not implemented: cloneDatabaseCallable()");
  }

  @Override
  public abstract void close();
}
