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

package com.google.cloud.firestore.v1.stub;

import static com.google.cloud.firestore.v1.FirestoreAdminClient.ListFieldsPagedResponse;
import static com.google.cloud.firestore.v1.FirestoreAdminClient.ListIndexesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.pathtemplate.PathTemplate;
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
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the FirestoreAdmin service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcFirestoreAdminStub extends FirestoreAdminStub {
  private static final MethodDescriptor<CreateIndexRequest, Operation> createIndexMethodDescriptor =
      MethodDescriptor.<CreateIndexRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/CreateIndex")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateIndexRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListIndexesRequest, ListIndexesResponse>
      listIndexesMethodDescriptor =
          MethodDescriptor.<ListIndexesRequest, ListIndexesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/ListIndexes")
              .setRequestMarshaller(ProtoUtils.marshaller(ListIndexesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListIndexesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetIndexRequest, Index> getIndexMethodDescriptor =
      MethodDescriptor.<GetIndexRequest, Index>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/GetIndex")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIndexRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Index.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<DeleteIndexRequest, Empty> deleteIndexMethodDescriptor =
      MethodDescriptor.<DeleteIndexRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/DeleteIndex")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteIndexRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<GetFieldRequest, Field> getFieldMethodDescriptor =
      MethodDescriptor.<GetFieldRequest, Field>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/GetField")
          .setRequestMarshaller(ProtoUtils.marshaller(GetFieldRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Field.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<UpdateFieldRequest, Operation> updateFieldMethodDescriptor =
      MethodDescriptor.<UpdateFieldRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/UpdateField")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateFieldRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListFieldsRequest, ListFieldsResponse>
      listFieldsMethodDescriptor =
          MethodDescriptor.<ListFieldsRequest, ListFieldsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/ListFields")
              .setRequestMarshaller(ProtoUtils.marshaller(ListFieldsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListFieldsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ExportDocumentsRequest, Operation>
      exportDocumentsMethodDescriptor =
          MethodDescriptor.<ExportDocumentsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/ExportDocuments")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ExportDocumentsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ImportDocumentsRequest, Operation>
      importDocumentsMethodDescriptor =
          MethodDescriptor.<ImportDocumentsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/ImportDocuments")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ImportDocumentsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<BulkDeleteDocumentsRequest, Operation>
      bulkDeleteDocumentsMethodDescriptor =
          MethodDescriptor.<BulkDeleteDocumentsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/BulkDeleteDocuments")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BulkDeleteDocumentsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateDatabaseRequest, Operation>
      createDatabaseMethodDescriptor =
          MethodDescriptor.<CreateDatabaseRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/CreateDatabase")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateDatabaseRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetDatabaseRequest, Database> getDatabaseMethodDescriptor =
      MethodDescriptor.<GetDatabaseRequest, Database>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/GetDatabase")
          .setRequestMarshaller(ProtoUtils.marshaller(GetDatabaseRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Database.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListDatabasesRequest, ListDatabasesResponse>
      listDatabasesMethodDescriptor =
          MethodDescriptor.<ListDatabasesRequest, ListDatabasesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/ListDatabases")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDatabasesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDatabasesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateDatabaseRequest, Operation>
      updateDatabaseMethodDescriptor =
          MethodDescriptor.<UpdateDatabaseRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/UpdateDatabase")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateDatabaseRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteDatabaseRequest, Operation>
      deleteDatabaseMethodDescriptor =
          MethodDescriptor.<DeleteDatabaseRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/DeleteDatabase")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteDatabaseRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateUserCredsRequest, UserCreds>
      createUserCredsMethodDescriptor =
          MethodDescriptor.<CreateUserCredsRequest, UserCreds>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/CreateUserCreds")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateUserCredsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(UserCreds.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetUserCredsRequest, UserCreds>
      getUserCredsMethodDescriptor =
          MethodDescriptor.<GetUserCredsRequest, UserCreds>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/GetUserCreds")
              .setRequestMarshaller(ProtoUtils.marshaller(GetUserCredsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(UserCreds.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListUserCredsRequest, ListUserCredsResponse>
      listUserCredsMethodDescriptor =
          MethodDescriptor.<ListUserCredsRequest, ListUserCredsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/ListUserCreds")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListUserCredsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListUserCredsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<EnableUserCredsRequest, UserCreds>
      enableUserCredsMethodDescriptor =
          MethodDescriptor.<EnableUserCredsRequest, UserCreds>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/EnableUserCreds")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(EnableUserCredsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(UserCreds.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DisableUserCredsRequest, UserCreds>
      disableUserCredsMethodDescriptor =
          MethodDescriptor.<DisableUserCredsRequest, UserCreds>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/DisableUserCreds")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DisableUserCredsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(UserCreds.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ResetUserPasswordRequest, UserCreds>
      resetUserPasswordMethodDescriptor =
          MethodDescriptor.<ResetUserPasswordRequest, UserCreds>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/ResetUserPassword")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ResetUserPasswordRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(UserCreds.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteUserCredsRequest, Empty>
      deleteUserCredsMethodDescriptor =
          MethodDescriptor.<DeleteUserCredsRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/DeleteUserCreds")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteUserCredsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetBackupRequest, Backup> getBackupMethodDescriptor =
      MethodDescriptor.<GetBackupRequest, Backup>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/GetBackup")
          .setRequestMarshaller(ProtoUtils.marshaller(GetBackupRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Backup.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListBackupsRequest, ListBackupsResponse>
      listBackupsMethodDescriptor =
          MethodDescriptor.<ListBackupsRequest, ListBackupsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/ListBackups")
              .setRequestMarshaller(ProtoUtils.marshaller(ListBackupsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListBackupsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteBackupRequest, Empty> deleteBackupMethodDescriptor =
      MethodDescriptor.<DeleteBackupRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/DeleteBackup")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteBackupRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<RestoreDatabaseRequest, Operation>
      restoreDatabaseMethodDescriptor =
          MethodDescriptor.<RestoreDatabaseRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/RestoreDatabase")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RestoreDatabaseRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateBackupScheduleRequest, BackupSchedule>
      createBackupScheduleMethodDescriptor =
          MethodDescriptor.<CreateBackupScheduleRequest, BackupSchedule>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/CreateBackupSchedule")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateBackupScheduleRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(BackupSchedule.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetBackupScheduleRequest, BackupSchedule>
      getBackupScheduleMethodDescriptor =
          MethodDescriptor.<GetBackupScheduleRequest, BackupSchedule>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/GetBackupSchedule")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetBackupScheduleRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(BackupSchedule.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListBackupSchedulesRequest, ListBackupSchedulesResponse>
      listBackupSchedulesMethodDescriptor =
          MethodDescriptor.<ListBackupSchedulesRequest, ListBackupSchedulesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/ListBackupSchedules")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListBackupSchedulesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListBackupSchedulesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateBackupScheduleRequest, BackupSchedule>
      updateBackupScheduleMethodDescriptor =
          MethodDescriptor.<UpdateBackupScheduleRequest, BackupSchedule>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/UpdateBackupSchedule")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateBackupScheduleRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(BackupSchedule.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteBackupScheduleRequest, Empty>
      deleteBackupScheduleMethodDescriptor =
          MethodDescriptor.<DeleteBackupScheduleRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/DeleteBackupSchedule")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteBackupScheduleRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CloneDatabaseRequest, Operation>
      cloneDatabaseMethodDescriptor =
          MethodDescriptor.<CloneDatabaseRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.firestore.admin.v1.FirestoreAdmin/CloneDatabase")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CloneDatabaseRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<CreateIndexRequest, Operation> createIndexCallable;
  private final OperationCallable<CreateIndexRequest, Index, IndexOperationMetadata>
      createIndexOperationCallable;
  private final UnaryCallable<ListIndexesRequest, ListIndexesResponse> listIndexesCallable;
  private final UnaryCallable<ListIndexesRequest, ListIndexesPagedResponse>
      listIndexesPagedCallable;
  private final UnaryCallable<GetIndexRequest, Index> getIndexCallable;
  private final UnaryCallable<DeleteIndexRequest, Empty> deleteIndexCallable;
  private final UnaryCallable<GetFieldRequest, Field> getFieldCallable;
  private final UnaryCallable<UpdateFieldRequest, Operation> updateFieldCallable;
  private final OperationCallable<UpdateFieldRequest, Field, FieldOperationMetadata>
      updateFieldOperationCallable;
  private final UnaryCallable<ListFieldsRequest, ListFieldsResponse> listFieldsCallable;
  private final UnaryCallable<ListFieldsRequest, ListFieldsPagedResponse> listFieldsPagedCallable;
  private final UnaryCallable<ExportDocumentsRequest, Operation> exportDocumentsCallable;
  private final OperationCallable<
          ExportDocumentsRequest, ExportDocumentsResponse, ExportDocumentsMetadata>
      exportDocumentsOperationCallable;
  private final UnaryCallable<ImportDocumentsRequest, Operation> importDocumentsCallable;
  private final OperationCallable<ImportDocumentsRequest, Empty, ImportDocumentsMetadata>
      importDocumentsOperationCallable;
  private final UnaryCallable<BulkDeleteDocumentsRequest, Operation> bulkDeleteDocumentsCallable;
  private final OperationCallable<
          BulkDeleteDocumentsRequest, BulkDeleteDocumentsResponse, BulkDeleteDocumentsMetadata>
      bulkDeleteDocumentsOperationCallable;
  private final UnaryCallable<CreateDatabaseRequest, Operation> createDatabaseCallable;
  private final OperationCallable<CreateDatabaseRequest, Database, CreateDatabaseMetadata>
      createDatabaseOperationCallable;
  private final UnaryCallable<GetDatabaseRequest, Database> getDatabaseCallable;
  private final UnaryCallable<ListDatabasesRequest, ListDatabasesResponse> listDatabasesCallable;
  private final UnaryCallable<UpdateDatabaseRequest, Operation> updateDatabaseCallable;
  private final OperationCallable<UpdateDatabaseRequest, Database, UpdateDatabaseMetadata>
      updateDatabaseOperationCallable;
  private final UnaryCallable<DeleteDatabaseRequest, Operation> deleteDatabaseCallable;
  private final OperationCallable<DeleteDatabaseRequest, Database, DeleteDatabaseMetadata>
      deleteDatabaseOperationCallable;
  private final UnaryCallable<CreateUserCredsRequest, UserCreds> createUserCredsCallable;
  private final UnaryCallable<GetUserCredsRequest, UserCreds> getUserCredsCallable;
  private final UnaryCallable<ListUserCredsRequest, ListUserCredsResponse> listUserCredsCallable;
  private final UnaryCallable<EnableUserCredsRequest, UserCreds> enableUserCredsCallable;
  private final UnaryCallable<DisableUserCredsRequest, UserCreds> disableUserCredsCallable;
  private final UnaryCallable<ResetUserPasswordRequest, UserCreds> resetUserPasswordCallable;
  private final UnaryCallable<DeleteUserCredsRequest, Empty> deleteUserCredsCallable;
  private final UnaryCallable<GetBackupRequest, Backup> getBackupCallable;
  private final UnaryCallable<ListBackupsRequest, ListBackupsResponse> listBackupsCallable;
  private final UnaryCallable<DeleteBackupRequest, Empty> deleteBackupCallable;
  private final UnaryCallable<RestoreDatabaseRequest, Operation> restoreDatabaseCallable;
  private final OperationCallable<RestoreDatabaseRequest, Database, RestoreDatabaseMetadata>
      restoreDatabaseOperationCallable;
  private final UnaryCallable<CreateBackupScheduleRequest, BackupSchedule>
      createBackupScheduleCallable;
  private final UnaryCallable<GetBackupScheduleRequest, BackupSchedule> getBackupScheduleCallable;
  private final UnaryCallable<ListBackupSchedulesRequest, ListBackupSchedulesResponse>
      listBackupSchedulesCallable;
  private final UnaryCallable<UpdateBackupScheduleRequest, BackupSchedule>
      updateBackupScheduleCallable;
  private final UnaryCallable<DeleteBackupScheduleRequest, Empty> deleteBackupScheduleCallable;
  private final UnaryCallable<CloneDatabaseRequest, Operation> cloneDatabaseCallable;
  private final OperationCallable<CloneDatabaseRequest, Database, CloneDatabaseMetadata>
      cloneDatabaseOperationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  private static final PathTemplate CLONE_DATABASE_0_PATH_TEMPLATE =
      PathTemplate.create("projects/{project_id=*}/**");
  private static final PathTemplate CLONE_DATABASE_1_PATH_TEMPLATE =
      PathTemplate.create("projects/*/databases/{database_id=*}/**");

  public static final GrpcFirestoreAdminStub create(FirestoreAdminStubSettings settings)
      throws IOException {
    return new GrpcFirestoreAdminStub(settings, ClientContext.create(settings));
  }

  public static final GrpcFirestoreAdminStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcFirestoreAdminStub(
        FirestoreAdminStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcFirestoreAdminStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcFirestoreAdminStub(
        FirestoreAdminStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcFirestoreAdminStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcFirestoreAdminStub(FirestoreAdminStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcFirestoreAdminCallableFactory());
  }

  /**
   * Constructs an instance of GrpcFirestoreAdminStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcFirestoreAdminStub(
      FirestoreAdminStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateIndexRequest, Operation> createIndexTransportSettings =
        GrpcCallSettings.<CreateIndexRequest, Operation>newBuilder()
            .setMethodDescriptor(createIndexMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListIndexesRequest, ListIndexesResponse> listIndexesTransportSettings =
        GrpcCallSettings.<ListIndexesRequest, ListIndexesResponse>newBuilder()
            .setMethodDescriptor(listIndexesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetIndexRequest, Index> getIndexTransportSettings =
        GrpcCallSettings.<GetIndexRequest, Index>newBuilder()
            .setMethodDescriptor(getIndexMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteIndexRequest, Empty> deleteIndexTransportSettings =
        GrpcCallSettings.<DeleteIndexRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteIndexMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetFieldRequest, Field> getFieldTransportSettings =
        GrpcCallSettings.<GetFieldRequest, Field>newBuilder()
            .setMethodDescriptor(getFieldMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateFieldRequest, Operation> updateFieldTransportSettings =
        GrpcCallSettings.<UpdateFieldRequest, Operation>newBuilder()
            .setMethodDescriptor(updateFieldMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("field.name", String.valueOf(request.getField().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListFieldsRequest, ListFieldsResponse> listFieldsTransportSettings =
        GrpcCallSettings.<ListFieldsRequest, ListFieldsResponse>newBuilder()
            .setMethodDescriptor(listFieldsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ExportDocumentsRequest, Operation> exportDocumentsTransportSettings =
        GrpcCallSettings.<ExportDocumentsRequest, Operation>newBuilder()
            .setMethodDescriptor(exportDocumentsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ImportDocumentsRequest, Operation> importDocumentsTransportSettings =
        GrpcCallSettings.<ImportDocumentsRequest, Operation>newBuilder()
            .setMethodDescriptor(importDocumentsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<BulkDeleteDocumentsRequest, Operation> bulkDeleteDocumentsTransportSettings =
        GrpcCallSettings.<BulkDeleteDocumentsRequest, Operation>newBuilder()
            .setMethodDescriptor(bulkDeleteDocumentsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateDatabaseRequest, Operation> createDatabaseTransportSettings =
        GrpcCallSettings.<CreateDatabaseRequest, Operation>newBuilder()
            .setMethodDescriptor(createDatabaseMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetDatabaseRequest, Database> getDatabaseTransportSettings =
        GrpcCallSettings.<GetDatabaseRequest, Database>newBuilder()
            .setMethodDescriptor(getDatabaseMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListDatabasesRequest, ListDatabasesResponse> listDatabasesTransportSettings =
        GrpcCallSettings.<ListDatabasesRequest, ListDatabasesResponse>newBuilder()
            .setMethodDescriptor(listDatabasesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateDatabaseRequest, Operation> updateDatabaseTransportSettings =
        GrpcCallSettings.<UpdateDatabaseRequest, Operation>newBuilder()
            .setMethodDescriptor(updateDatabaseMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("database.name", String.valueOf(request.getDatabase().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteDatabaseRequest, Operation> deleteDatabaseTransportSettings =
        GrpcCallSettings.<DeleteDatabaseRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteDatabaseMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateUserCredsRequest, UserCreds> createUserCredsTransportSettings =
        GrpcCallSettings.<CreateUserCredsRequest, UserCreds>newBuilder()
            .setMethodDescriptor(createUserCredsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetUserCredsRequest, UserCreds> getUserCredsTransportSettings =
        GrpcCallSettings.<GetUserCredsRequest, UserCreds>newBuilder()
            .setMethodDescriptor(getUserCredsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListUserCredsRequest, ListUserCredsResponse> listUserCredsTransportSettings =
        GrpcCallSettings.<ListUserCredsRequest, ListUserCredsResponse>newBuilder()
            .setMethodDescriptor(listUserCredsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<EnableUserCredsRequest, UserCreds> enableUserCredsTransportSettings =
        GrpcCallSettings.<EnableUserCredsRequest, UserCreds>newBuilder()
            .setMethodDescriptor(enableUserCredsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DisableUserCredsRequest, UserCreds> disableUserCredsTransportSettings =
        GrpcCallSettings.<DisableUserCredsRequest, UserCreds>newBuilder()
            .setMethodDescriptor(disableUserCredsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ResetUserPasswordRequest, UserCreds> resetUserPasswordTransportSettings =
        GrpcCallSettings.<ResetUserPasswordRequest, UserCreds>newBuilder()
            .setMethodDescriptor(resetUserPasswordMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteUserCredsRequest, Empty> deleteUserCredsTransportSettings =
        GrpcCallSettings.<DeleteUserCredsRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteUserCredsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetBackupRequest, Backup> getBackupTransportSettings =
        GrpcCallSettings.<GetBackupRequest, Backup>newBuilder()
            .setMethodDescriptor(getBackupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListBackupsRequest, ListBackupsResponse> listBackupsTransportSettings =
        GrpcCallSettings.<ListBackupsRequest, ListBackupsResponse>newBuilder()
            .setMethodDescriptor(listBackupsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteBackupRequest, Empty> deleteBackupTransportSettings =
        GrpcCallSettings.<DeleteBackupRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteBackupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<RestoreDatabaseRequest, Operation> restoreDatabaseTransportSettings =
        GrpcCallSettings.<RestoreDatabaseRequest, Operation>newBuilder()
            .setMethodDescriptor(restoreDatabaseMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateBackupScheduleRequest, BackupSchedule>
        createBackupScheduleTransportSettings =
            GrpcCallSettings.<CreateBackupScheduleRequest, BackupSchedule>newBuilder()
                .setMethodDescriptor(createBackupScheduleMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetBackupScheduleRequest, BackupSchedule> getBackupScheduleTransportSettings =
        GrpcCallSettings.<GetBackupScheduleRequest, BackupSchedule>newBuilder()
            .setMethodDescriptor(getBackupScheduleMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListBackupSchedulesRequest, ListBackupSchedulesResponse>
        listBackupSchedulesTransportSettings =
            GrpcCallSettings.<ListBackupSchedulesRequest, ListBackupSchedulesResponse>newBuilder()
                .setMethodDescriptor(listBackupSchedulesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateBackupScheduleRequest, BackupSchedule>
        updateBackupScheduleTransportSettings =
            GrpcCallSettings.<UpdateBackupScheduleRequest, BackupSchedule>newBuilder()
                .setMethodDescriptor(updateBackupScheduleMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "backup_schedule.name",
                          String.valueOf(request.getBackupSchedule().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteBackupScheduleRequest, Empty> deleteBackupScheduleTransportSettings =
        GrpcCallSettings.<DeleteBackupScheduleRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteBackupScheduleMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CloneDatabaseRequest, Operation> cloneDatabaseTransportSettings =
        GrpcCallSettings.<CloneDatabaseRequest, Operation>newBuilder()
            .setMethodDescriptor(cloneDatabaseMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  if (request.getPitrSnapshot() != null) {
                    builder.add(
                        request.getPitrSnapshot().getDatabase(),
                        "project_id",
                        CLONE_DATABASE_0_PATH_TEMPLATE);
                  }
                  if (request.getPitrSnapshot() != null) {
                    builder.add(
                        request.getPitrSnapshot().getDatabase(),
                        "database_id",
                        CLONE_DATABASE_1_PATH_TEMPLATE);
                  }
                  return builder.build();
                })
            .build();

    this.createIndexCallable =
        callableFactory.createUnaryCallable(
            createIndexTransportSettings, settings.createIndexSettings(), clientContext);
    this.createIndexOperationCallable =
        callableFactory.createOperationCallable(
            createIndexTransportSettings,
            settings.createIndexOperationSettings(),
            clientContext,
            operationsStub);
    this.listIndexesCallable =
        callableFactory.createUnaryCallable(
            listIndexesTransportSettings, settings.listIndexesSettings(), clientContext);
    this.listIndexesPagedCallable =
        callableFactory.createPagedCallable(
            listIndexesTransportSettings, settings.listIndexesSettings(), clientContext);
    this.getIndexCallable =
        callableFactory.createUnaryCallable(
            getIndexTransportSettings, settings.getIndexSettings(), clientContext);
    this.deleteIndexCallable =
        callableFactory.createUnaryCallable(
            deleteIndexTransportSettings, settings.deleteIndexSettings(), clientContext);
    this.getFieldCallable =
        callableFactory.createUnaryCallable(
            getFieldTransportSettings, settings.getFieldSettings(), clientContext);
    this.updateFieldCallable =
        callableFactory.createUnaryCallable(
            updateFieldTransportSettings, settings.updateFieldSettings(), clientContext);
    this.updateFieldOperationCallable =
        callableFactory.createOperationCallable(
            updateFieldTransportSettings,
            settings.updateFieldOperationSettings(),
            clientContext,
            operationsStub);
    this.listFieldsCallable =
        callableFactory.createUnaryCallable(
            listFieldsTransportSettings, settings.listFieldsSettings(), clientContext);
    this.listFieldsPagedCallable =
        callableFactory.createPagedCallable(
            listFieldsTransportSettings, settings.listFieldsSettings(), clientContext);
    this.exportDocumentsCallable =
        callableFactory.createUnaryCallable(
            exportDocumentsTransportSettings, settings.exportDocumentsSettings(), clientContext);
    this.exportDocumentsOperationCallable =
        callableFactory.createOperationCallable(
            exportDocumentsTransportSettings,
            settings.exportDocumentsOperationSettings(),
            clientContext,
            operationsStub);
    this.importDocumentsCallable =
        callableFactory.createUnaryCallable(
            importDocumentsTransportSettings, settings.importDocumentsSettings(), clientContext);
    this.importDocumentsOperationCallable =
        callableFactory.createOperationCallable(
            importDocumentsTransportSettings,
            settings.importDocumentsOperationSettings(),
            clientContext,
            operationsStub);
    this.bulkDeleteDocumentsCallable =
        callableFactory.createUnaryCallable(
            bulkDeleteDocumentsTransportSettings,
            settings.bulkDeleteDocumentsSettings(),
            clientContext);
    this.bulkDeleteDocumentsOperationCallable =
        callableFactory.createOperationCallable(
            bulkDeleteDocumentsTransportSettings,
            settings.bulkDeleteDocumentsOperationSettings(),
            clientContext,
            operationsStub);
    this.createDatabaseCallable =
        callableFactory.createUnaryCallable(
            createDatabaseTransportSettings, settings.createDatabaseSettings(), clientContext);
    this.createDatabaseOperationCallable =
        callableFactory.createOperationCallable(
            createDatabaseTransportSettings,
            settings.createDatabaseOperationSettings(),
            clientContext,
            operationsStub);
    this.getDatabaseCallable =
        callableFactory.createUnaryCallable(
            getDatabaseTransportSettings, settings.getDatabaseSettings(), clientContext);
    this.listDatabasesCallable =
        callableFactory.createUnaryCallable(
            listDatabasesTransportSettings, settings.listDatabasesSettings(), clientContext);
    this.updateDatabaseCallable =
        callableFactory.createUnaryCallable(
            updateDatabaseTransportSettings, settings.updateDatabaseSettings(), clientContext);
    this.updateDatabaseOperationCallable =
        callableFactory.createOperationCallable(
            updateDatabaseTransportSettings,
            settings.updateDatabaseOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteDatabaseCallable =
        callableFactory.createUnaryCallable(
            deleteDatabaseTransportSettings, settings.deleteDatabaseSettings(), clientContext);
    this.deleteDatabaseOperationCallable =
        callableFactory.createOperationCallable(
            deleteDatabaseTransportSettings,
            settings.deleteDatabaseOperationSettings(),
            clientContext,
            operationsStub);
    this.createUserCredsCallable =
        callableFactory.createUnaryCallable(
            createUserCredsTransportSettings, settings.createUserCredsSettings(), clientContext);
    this.getUserCredsCallable =
        callableFactory.createUnaryCallable(
            getUserCredsTransportSettings, settings.getUserCredsSettings(), clientContext);
    this.listUserCredsCallable =
        callableFactory.createUnaryCallable(
            listUserCredsTransportSettings, settings.listUserCredsSettings(), clientContext);
    this.enableUserCredsCallable =
        callableFactory.createUnaryCallable(
            enableUserCredsTransportSettings, settings.enableUserCredsSettings(), clientContext);
    this.disableUserCredsCallable =
        callableFactory.createUnaryCallable(
            disableUserCredsTransportSettings, settings.disableUserCredsSettings(), clientContext);
    this.resetUserPasswordCallable =
        callableFactory.createUnaryCallable(
            resetUserPasswordTransportSettings,
            settings.resetUserPasswordSettings(),
            clientContext);
    this.deleteUserCredsCallable =
        callableFactory.createUnaryCallable(
            deleteUserCredsTransportSettings, settings.deleteUserCredsSettings(), clientContext);
    this.getBackupCallable =
        callableFactory.createUnaryCallable(
            getBackupTransportSettings, settings.getBackupSettings(), clientContext);
    this.listBackupsCallable =
        callableFactory.createUnaryCallable(
            listBackupsTransportSettings, settings.listBackupsSettings(), clientContext);
    this.deleteBackupCallable =
        callableFactory.createUnaryCallable(
            deleteBackupTransportSettings, settings.deleteBackupSettings(), clientContext);
    this.restoreDatabaseCallable =
        callableFactory.createUnaryCallable(
            restoreDatabaseTransportSettings, settings.restoreDatabaseSettings(), clientContext);
    this.restoreDatabaseOperationCallable =
        callableFactory.createOperationCallable(
            restoreDatabaseTransportSettings,
            settings.restoreDatabaseOperationSettings(),
            clientContext,
            operationsStub);
    this.createBackupScheduleCallable =
        callableFactory.createUnaryCallable(
            createBackupScheduleTransportSettings,
            settings.createBackupScheduleSettings(),
            clientContext);
    this.getBackupScheduleCallable =
        callableFactory.createUnaryCallable(
            getBackupScheduleTransportSettings,
            settings.getBackupScheduleSettings(),
            clientContext);
    this.listBackupSchedulesCallable =
        callableFactory.createUnaryCallable(
            listBackupSchedulesTransportSettings,
            settings.listBackupSchedulesSettings(),
            clientContext);
    this.updateBackupScheduleCallable =
        callableFactory.createUnaryCallable(
            updateBackupScheduleTransportSettings,
            settings.updateBackupScheduleSettings(),
            clientContext);
    this.deleteBackupScheduleCallable =
        callableFactory.createUnaryCallable(
            deleteBackupScheduleTransportSettings,
            settings.deleteBackupScheduleSettings(),
            clientContext);
    this.cloneDatabaseCallable =
        callableFactory.createUnaryCallable(
            cloneDatabaseTransportSettings, settings.cloneDatabaseSettings(), clientContext);
    this.cloneDatabaseOperationCallable =
        callableFactory.createOperationCallable(
            cloneDatabaseTransportSettings,
            settings.cloneDatabaseOperationSettings(),
            clientContext,
            operationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateIndexRequest, Operation> createIndexCallable() {
    return createIndexCallable;
  }

  @Override
  public OperationCallable<CreateIndexRequest, Index, IndexOperationMetadata>
      createIndexOperationCallable() {
    return createIndexOperationCallable;
  }

  @Override
  public UnaryCallable<ListIndexesRequest, ListIndexesResponse> listIndexesCallable() {
    return listIndexesCallable;
  }

  @Override
  public UnaryCallable<ListIndexesRequest, ListIndexesPagedResponse> listIndexesPagedCallable() {
    return listIndexesPagedCallable;
  }

  @Override
  public UnaryCallable<GetIndexRequest, Index> getIndexCallable() {
    return getIndexCallable;
  }

  @Override
  public UnaryCallable<DeleteIndexRequest, Empty> deleteIndexCallable() {
    return deleteIndexCallable;
  }

  @Override
  public UnaryCallable<GetFieldRequest, Field> getFieldCallable() {
    return getFieldCallable;
  }

  @Override
  public UnaryCallable<UpdateFieldRequest, Operation> updateFieldCallable() {
    return updateFieldCallable;
  }

  @Override
  public OperationCallable<UpdateFieldRequest, Field, FieldOperationMetadata>
      updateFieldOperationCallable() {
    return updateFieldOperationCallable;
  }

  @Override
  public UnaryCallable<ListFieldsRequest, ListFieldsResponse> listFieldsCallable() {
    return listFieldsCallable;
  }

  @Override
  public UnaryCallable<ListFieldsRequest, ListFieldsPagedResponse> listFieldsPagedCallable() {
    return listFieldsPagedCallable;
  }

  @Override
  public UnaryCallable<ExportDocumentsRequest, Operation> exportDocumentsCallable() {
    return exportDocumentsCallable;
  }

  @Override
  public OperationCallable<ExportDocumentsRequest, ExportDocumentsResponse, ExportDocumentsMetadata>
      exportDocumentsOperationCallable() {
    return exportDocumentsOperationCallable;
  }

  @Override
  public UnaryCallable<ImportDocumentsRequest, Operation> importDocumentsCallable() {
    return importDocumentsCallable;
  }

  @Override
  public OperationCallable<ImportDocumentsRequest, Empty, ImportDocumentsMetadata>
      importDocumentsOperationCallable() {
    return importDocumentsOperationCallable;
  }

  @Override
  public UnaryCallable<BulkDeleteDocumentsRequest, Operation> bulkDeleteDocumentsCallable() {
    return bulkDeleteDocumentsCallable;
  }

  @Override
  public OperationCallable<
          BulkDeleteDocumentsRequest, BulkDeleteDocumentsResponse, BulkDeleteDocumentsMetadata>
      bulkDeleteDocumentsOperationCallable() {
    return bulkDeleteDocumentsOperationCallable;
  }

  @Override
  public UnaryCallable<CreateDatabaseRequest, Operation> createDatabaseCallable() {
    return createDatabaseCallable;
  }

  @Override
  public OperationCallable<CreateDatabaseRequest, Database, CreateDatabaseMetadata>
      createDatabaseOperationCallable() {
    return createDatabaseOperationCallable;
  }

  @Override
  public UnaryCallable<GetDatabaseRequest, Database> getDatabaseCallable() {
    return getDatabaseCallable;
  }

  @Override
  public UnaryCallable<ListDatabasesRequest, ListDatabasesResponse> listDatabasesCallable() {
    return listDatabasesCallable;
  }

  @Override
  public UnaryCallable<UpdateDatabaseRequest, Operation> updateDatabaseCallable() {
    return updateDatabaseCallable;
  }

  @Override
  public OperationCallable<UpdateDatabaseRequest, Database, UpdateDatabaseMetadata>
      updateDatabaseOperationCallable() {
    return updateDatabaseOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteDatabaseRequest, Operation> deleteDatabaseCallable() {
    return deleteDatabaseCallable;
  }

  @Override
  public OperationCallable<DeleteDatabaseRequest, Database, DeleteDatabaseMetadata>
      deleteDatabaseOperationCallable() {
    return deleteDatabaseOperationCallable;
  }

  @Override
  public UnaryCallable<CreateUserCredsRequest, UserCreds> createUserCredsCallable() {
    return createUserCredsCallable;
  }

  @Override
  public UnaryCallable<GetUserCredsRequest, UserCreds> getUserCredsCallable() {
    return getUserCredsCallable;
  }

  @Override
  public UnaryCallable<ListUserCredsRequest, ListUserCredsResponse> listUserCredsCallable() {
    return listUserCredsCallable;
  }

  @Override
  public UnaryCallable<EnableUserCredsRequest, UserCreds> enableUserCredsCallable() {
    return enableUserCredsCallable;
  }

  @Override
  public UnaryCallable<DisableUserCredsRequest, UserCreds> disableUserCredsCallable() {
    return disableUserCredsCallable;
  }

  @Override
  public UnaryCallable<ResetUserPasswordRequest, UserCreds> resetUserPasswordCallable() {
    return resetUserPasswordCallable;
  }

  @Override
  public UnaryCallable<DeleteUserCredsRequest, Empty> deleteUserCredsCallable() {
    return deleteUserCredsCallable;
  }

  @Override
  public UnaryCallable<GetBackupRequest, Backup> getBackupCallable() {
    return getBackupCallable;
  }

  @Override
  public UnaryCallable<ListBackupsRequest, ListBackupsResponse> listBackupsCallable() {
    return listBackupsCallable;
  }

  @Override
  public UnaryCallable<DeleteBackupRequest, Empty> deleteBackupCallable() {
    return deleteBackupCallable;
  }

  @Override
  public UnaryCallable<RestoreDatabaseRequest, Operation> restoreDatabaseCallable() {
    return restoreDatabaseCallable;
  }

  @Override
  public OperationCallable<RestoreDatabaseRequest, Database, RestoreDatabaseMetadata>
      restoreDatabaseOperationCallable() {
    return restoreDatabaseOperationCallable;
  }

  @Override
  public UnaryCallable<CreateBackupScheduleRequest, BackupSchedule> createBackupScheduleCallable() {
    return createBackupScheduleCallable;
  }

  @Override
  public UnaryCallable<GetBackupScheduleRequest, BackupSchedule> getBackupScheduleCallable() {
    return getBackupScheduleCallable;
  }

  @Override
  public UnaryCallable<ListBackupSchedulesRequest, ListBackupSchedulesResponse>
      listBackupSchedulesCallable() {
    return listBackupSchedulesCallable;
  }

  @Override
  public UnaryCallable<UpdateBackupScheduleRequest, BackupSchedule> updateBackupScheduleCallable() {
    return updateBackupScheduleCallable;
  }

  @Override
  public UnaryCallable<DeleteBackupScheduleRequest, Empty> deleteBackupScheduleCallable() {
    return deleteBackupScheduleCallable;
  }

  @Override
  public UnaryCallable<CloneDatabaseRequest, Operation> cloneDatabaseCallable() {
    return cloneDatabaseCallable;
  }

  @Override
  public OperationCallable<CloneDatabaseRequest, Database, CloneDatabaseMetadata>
      cloneDatabaseOperationCallable() {
    return cloneDatabaseOperationCallable;
  }

  @Override
  public final void close() {
    try {
      backgroundResources.close();
    } catch (RuntimeException e) {
      throw e;
    } catch (Exception e) {
      throw new IllegalStateException("Failed to close resource", e);
    }
  }

  @Override
  public void shutdown() {
    backgroundResources.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return backgroundResources.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return backgroundResources.isTerminated();
  }

  @Override
  public void shutdownNow() {
    backgroundResources.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return backgroundResources.awaitTermination(duration, unit);
  }
}
