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

package com.google.cloud.spanner.admin.database.v1.stub;

import static com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient.ListBackupOperationsPagedResponse;
import static com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient.ListBackupSchedulesPagedResponse;
import static com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient.ListBackupsPagedResponse;
import static com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient.ListDatabaseOperationsPagedResponse;
import static com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient.ListDatabaseRolesPagedResponse;
import static com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient.ListDatabasesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import com.google.spanner.admin.database.v1.AddSplitPointsRequest;
import com.google.spanner.admin.database.v1.AddSplitPointsResponse;
import com.google.spanner.admin.database.v1.Backup;
import com.google.spanner.admin.database.v1.BackupSchedule;
import com.google.spanner.admin.database.v1.CopyBackupMetadata;
import com.google.spanner.admin.database.v1.CopyBackupRequest;
import com.google.spanner.admin.database.v1.CreateBackupMetadata;
import com.google.spanner.admin.database.v1.CreateBackupRequest;
import com.google.spanner.admin.database.v1.CreateBackupScheduleRequest;
import com.google.spanner.admin.database.v1.CreateDatabaseMetadata;
import com.google.spanner.admin.database.v1.CreateDatabaseRequest;
import com.google.spanner.admin.database.v1.Database;
import com.google.spanner.admin.database.v1.DeleteBackupRequest;
import com.google.spanner.admin.database.v1.DeleteBackupScheduleRequest;
import com.google.spanner.admin.database.v1.DropDatabaseRequest;
import com.google.spanner.admin.database.v1.GetBackupRequest;
import com.google.spanner.admin.database.v1.GetBackupScheduleRequest;
import com.google.spanner.admin.database.v1.GetDatabaseDdlRequest;
import com.google.spanner.admin.database.v1.GetDatabaseDdlResponse;
import com.google.spanner.admin.database.v1.GetDatabaseRequest;
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
import com.google.spanner.admin.database.v1.UpdateBackupRequest;
import com.google.spanner.admin.database.v1.UpdateBackupScheduleRequest;
import com.google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata;
import com.google.spanner.admin.database.v1.UpdateDatabaseDdlRequest;
import com.google.spanner.admin.database.v1.UpdateDatabaseMetadata;
import com.google.spanner.admin.database.v1.UpdateDatabaseRequest;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the DatabaseAdmin service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcDatabaseAdminStub extends DatabaseAdminStub {
  private static final MethodDescriptor<ListDatabasesRequest, ListDatabasesResponse>
      listDatabasesMethodDescriptor =
          MethodDescriptor.<ListDatabasesRequest, ListDatabasesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.spanner.admin.database.v1.DatabaseAdmin/ListDatabases")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDatabasesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDatabasesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateDatabaseRequest, Operation>
      createDatabaseMethodDescriptor =
          MethodDescriptor.<CreateDatabaseRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.spanner.admin.database.v1.DatabaseAdmin/CreateDatabase")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateDatabaseRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetDatabaseRequest, Database> getDatabaseMethodDescriptor =
      MethodDescriptor.<GetDatabaseRequest, Database>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.spanner.admin.database.v1.DatabaseAdmin/GetDatabase")
          .setRequestMarshaller(ProtoUtils.marshaller(GetDatabaseRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Database.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<UpdateDatabaseRequest, Operation>
      updateDatabaseMethodDescriptor =
          MethodDescriptor.<UpdateDatabaseRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.spanner.admin.database.v1.DatabaseAdmin/UpdateDatabase")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateDatabaseRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateDatabaseDdlRequest, Operation>
      updateDatabaseDdlMethodDescriptor =
          MethodDescriptor.<UpdateDatabaseDdlRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.spanner.admin.database.v1.DatabaseAdmin/UpdateDatabaseDdl")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateDatabaseDdlRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DropDatabaseRequest, Empty> dropDatabaseMethodDescriptor =
      MethodDescriptor.<DropDatabaseRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.spanner.admin.database.v1.DatabaseAdmin/DropDatabase")
          .setRequestMarshaller(ProtoUtils.marshaller(DropDatabaseRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<GetDatabaseDdlRequest, GetDatabaseDdlResponse>
      getDatabaseDdlMethodDescriptor =
          MethodDescriptor.<GetDatabaseDdlRequest, GetDatabaseDdlResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.spanner.admin.database.v1.DatabaseAdmin/GetDatabaseDdl")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetDatabaseDdlRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GetDatabaseDdlResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.spanner.admin.database.v1.DatabaseAdmin/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.spanner.admin.database.v1.DatabaseAdmin/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          MethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.spanner.admin.database.v1.DatabaseAdmin/TestIamPermissions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateBackupRequest, Operation>
      createBackupMethodDescriptor =
          MethodDescriptor.<CreateBackupRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.spanner.admin.database.v1.DatabaseAdmin/CreateBackup")
              .setRequestMarshaller(ProtoUtils.marshaller(CreateBackupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CopyBackupRequest, Operation> copyBackupMethodDescriptor =
      MethodDescriptor.<CopyBackupRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.spanner.admin.database.v1.DatabaseAdmin/CopyBackup")
          .setRequestMarshaller(ProtoUtils.marshaller(CopyBackupRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<GetBackupRequest, Backup> getBackupMethodDescriptor =
      MethodDescriptor.<GetBackupRequest, Backup>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.spanner.admin.database.v1.DatabaseAdmin/GetBackup")
          .setRequestMarshaller(ProtoUtils.marshaller(GetBackupRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Backup.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<UpdateBackupRequest, Backup> updateBackupMethodDescriptor =
      MethodDescriptor.<UpdateBackupRequest, Backup>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.spanner.admin.database.v1.DatabaseAdmin/UpdateBackup")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateBackupRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Backup.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<DeleteBackupRequest, Empty> deleteBackupMethodDescriptor =
      MethodDescriptor.<DeleteBackupRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.spanner.admin.database.v1.DatabaseAdmin/DeleteBackup")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteBackupRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListBackupsRequest, ListBackupsResponse>
      listBackupsMethodDescriptor =
          MethodDescriptor.<ListBackupsRequest, ListBackupsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.spanner.admin.database.v1.DatabaseAdmin/ListBackups")
              .setRequestMarshaller(ProtoUtils.marshaller(ListBackupsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListBackupsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<RestoreDatabaseRequest, Operation>
      restoreDatabaseMethodDescriptor =
          MethodDescriptor.<RestoreDatabaseRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.spanner.admin.database.v1.DatabaseAdmin/RestoreDatabase")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RestoreDatabaseRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListDatabaseOperationsRequest, ListDatabaseOperationsResponse>
      listDatabaseOperationsMethodDescriptor =
          MethodDescriptor
              .<ListDatabaseOperationsRequest, ListDatabaseOperationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.spanner.admin.database.v1.DatabaseAdmin/ListDatabaseOperations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDatabaseOperationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDatabaseOperationsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListBackupOperationsRequest, ListBackupOperationsResponse>
      listBackupOperationsMethodDescriptor =
          MethodDescriptor.<ListBackupOperationsRequest, ListBackupOperationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.spanner.admin.database.v1.DatabaseAdmin/ListBackupOperations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListBackupOperationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListBackupOperationsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListDatabaseRolesRequest, ListDatabaseRolesResponse>
      listDatabaseRolesMethodDescriptor =
          MethodDescriptor.<ListDatabaseRolesRequest, ListDatabaseRolesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.spanner.admin.database.v1.DatabaseAdmin/ListDatabaseRoles")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDatabaseRolesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDatabaseRolesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<AddSplitPointsRequest, AddSplitPointsResponse>
      addSplitPointsMethodDescriptor =
          MethodDescriptor.<AddSplitPointsRequest, AddSplitPointsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.spanner.admin.database.v1.DatabaseAdmin/AddSplitPoints")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(AddSplitPointsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(AddSplitPointsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateBackupScheduleRequest, BackupSchedule>
      createBackupScheduleMethodDescriptor =
          MethodDescriptor.<CreateBackupScheduleRequest, BackupSchedule>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.spanner.admin.database.v1.DatabaseAdmin/CreateBackupSchedule")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateBackupScheduleRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(BackupSchedule.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetBackupScheduleRequest, BackupSchedule>
      getBackupScheduleMethodDescriptor =
          MethodDescriptor.<GetBackupScheduleRequest, BackupSchedule>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.spanner.admin.database.v1.DatabaseAdmin/GetBackupSchedule")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetBackupScheduleRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(BackupSchedule.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateBackupScheduleRequest, BackupSchedule>
      updateBackupScheduleMethodDescriptor =
          MethodDescriptor.<UpdateBackupScheduleRequest, BackupSchedule>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.spanner.admin.database.v1.DatabaseAdmin/UpdateBackupSchedule")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateBackupScheduleRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(BackupSchedule.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteBackupScheduleRequest, Empty>
      deleteBackupScheduleMethodDescriptor =
          MethodDescriptor.<DeleteBackupScheduleRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.spanner.admin.database.v1.DatabaseAdmin/DeleteBackupSchedule")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteBackupScheduleRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListBackupSchedulesRequest, ListBackupSchedulesResponse>
      listBackupSchedulesMethodDescriptor =
          MethodDescriptor.<ListBackupSchedulesRequest, ListBackupSchedulesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.spanner.admin.database.v1.DatabaseAdmin/ListBackupSchedules")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListBackupSchedulesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListBackupSchedulesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          InternalUpdateGraphOperationRequest, InternalUpdateGraphOperationResponse>
      internalUpdateGraphOperationMethodDescriptor =
          MethodDescriptor
              .<InternalUpdateGraphOperationRequest, InternalUpdateGraphOperationResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.spanner.admin.database.v1.DatabaseAdmin/InternalUpdateGraphOperation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(InternalUpdateGraphOperationRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(InternalUpdateGraphOperationResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<ListDatabasesRequest, ListDatabasesResponse> listDatabasesCallable;
  private final UnaryCallable<ListDatabasesRequest, ListDatabasesPagedResponse>
      listDatabasesPagedCallable;
  private final UnaryCallable<CreateDatabaseRequest, Operation> createDatabaseCallable;
  private final OperationCallable<CreateDatabaseRequest, Database, CreateDatabaseMetadata>
      createDatabaseOperationCallable;
  private final UnaryCallable<GetDatabaseRequest, Database> getDatabaseCallable;
  private final UnaryCallable<UpdateDatabaseRequest, Operation> updateDatabaseCallable;
  private final OperationCallable<UpdateDatabaseRequest, Database, UpdateDatabaseMetadata>
      updateDatabaseOperationCallable;
  private final UnaryCallable<UpdateDatabaseDdlRequest, Operation> updateDatabaseDdlCallable;
  private final OperationCallable<UpdateDatabaseDdlRequest, Empty, UpdateDatabaseDdlMetadata>
      updateDatabaseDdlOperationCallable;
  private final UnaryCallable<DropDatabaseRequest, Empty> dropDatabaseCallable;
  private final UnaryCallable<GetDatabaseDdlRequest, GetDatabaseDdlResponse> getDatabaseDdlCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;
  private final UnaryCallable<CreateBackupRequest, Operation> createBackupCallable;
  private final OperationCallable<CreateBackupRequest, Backup, CreateBackupMetadata>
      createBackupOperationCallable;
  private final UnaryCallable<CopyBackupRequest, Operation> copyBackupCallable;
  private final OperationCallable<CopyBackupRequest, Backup, CopyBackupMetadata>
      copyBackupOperationCallable;
  private final UnaryCallable<GetBackupRequest, Backup> getBackupCallable;
  private final UnaryCallable<UpdateBackupRequest, Backup> updateBackupCallable;
  private final UnaryCallable<DeleteBackupRequest, Empty> deleteBackupCallable;
  private final UnaryCallable<ListBackupsRequest, ListBackupsResponse> listBackupsCallable;
  private final UnaryCallable<ListBackupsRequest, ListBackupsPagedResponse>
      listBackupsPagedCallable;
  private final UnaryCallable<RestoreDatabaseRequest, Operation> restoreDatabaseCallable;
  private final OperationCallable<RestoreDatabaseRequest, Database, RestoreDatabaseMetadata>
      restoreDatabaseOperationCallable;
  private final UnaryCallable<ListDatabaseOperationsRequest, ListDatabaseOperationsResponse>
      listDatabaseOperationsCallable;
  private final UnaryCallable<ListDatabaseOperationsRequest, ListDatabaseOperationsPagedResponse>
      listDatabaseOperationsPagedCallable;
  private final UnaryCallable<ListBackupOperationsRequest, ListBackupOperationsResponse>
      listBackupOperationsCallable;
  private final UnaryCallable<ListBackupOperationsRequest, ListBackupOperationsPagedResponse>
      listBackupOperationsPagedCallable;
  private final UnaryCallable<ListDatabaseRolesRequest, ListDatabaseRolesResponse>
      listDatabaseRolesCallable;
  private final UnaryCallable<ListDatabaseRolesRequest, ListDatabaseRolesPagedResponse>
      listDatabaseRolesPagedCallable;
  private final UnaryCallable<AddSplitPointsRequest, AddSplitPointsResponse> addSplitPointsCallable;
  private final UnaryCallable<CreateBackupScheduleRequest, BackupSchedule>
      createBackupScheduleCallable;
  private final UnaryCallable<GetBackupScheduleRequest, BackupSchedule> getBackupScheduleCallable;
  private final UnaryCallable<UpdateBackupScheduleRequest, BackupSchedule>
      updateBackupScheduleCallable;
  private final UnaryCallable<DeleteBackupScheduleRequest, Empty> deleteBackupScheduleCallable;
  private final UnaryCallable<ListBackupSchedulesRequest, ListBackupSchedulesResponse>
      listBackupSchedulesCallable;
  private final UnaryCallable<ListBackupSchedulesRequest, ListBackupSchedulesPagedResponse>
      listBackupSchedulesPagedCallable;
  private final UnaryCallable<
          InternalUpdateGraphOperationRequest, InternalUpdateGraphOperationResponse>
      internalUpdateGraphOperationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcDatabaseAdminStub create(DatabaseAdminStubSettings settings)
      throws IOException {
    return new GrpcDatabaseAdminStub(settings, ClientContext.create(settings));
  }

  public static final GrpcDatabaseAdminStub create(ClientContext clientContext) throws IOException {
    return new GrpcDatabaseAdminStub(DatabaseAdminStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcDatabaseAdminStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcDatabaseAdminStub(
        DatabaseAdminStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcDatabaseAdminStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcDatabaseAdminStub(DatabaseAdminStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcDatabaseAdminCallableFactory());
  }

  /**
   * Constructs an instance of GrpcDatabaseAdminStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcDatabaseAdminStub(
      DatabaseAdminStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListDatabasesRequest, ListDatabasesResponse> listDatabasesTransportSettings =
        GrpcCallSettings.<ListDatabasesRequest, ListDatabasesResponse>newBuilder()
            .setMethodDescriptor(listDatabasesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
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
            .setResourceNameExtractor(request -> request.getParent())
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
            .setResourceNameExtractor(request -> request.getName())
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
    GrpcCallSettings<UpdateDatabaseDdlRequest, Operation> updateDatabaseDdlTransportSettings =
        GrpcCallSettings.<UpdateDatabaseDdlRequest, Operation>newBuilder()
            .setMethodDescriptor(updateDatabaseDdlMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("database", String.valueOf(request.getDatabase()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getDatabase())
            .build();
    GrpcCallSettings<DropDatabaseRequest, Empty> dropDatabaseTransportSettings =
        GrpcCallSettings.<DropDatabaseRequest, Empty>newBuilder()
            .setMethodDescriptor(dropDatabaseMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("database", String.valueOf(request.getDatabase()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getDatabase())
            .build();
    GrpcCallSettings<GetDatabaseDdlRequest, GetDatabaseDdlResponse>
        getDatabaseDdlTransportSettings =
            GrpcCallSettings.<GetDatabaseDdlRequest, GetDatabaseDdlResponse>newBuilder()
                .setMethodDescriptor(getDatabaseDdlMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("database", String.valueOf(request.getDatabase()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getDatabase())
                .build();
    GrpcCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        GrpcCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getResource())
            .build();
    GrpcCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        GrpcCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getResource())
            .build();
    GrpcCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            GrpcCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("resource", String.valueOf(request.getResource()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getResource())
                .build();
    GrpcCallSettings<CreateBackupRequest, Operation> createBackupTransportSettings =
        GrpcCallSettings.<CreateBackupRequest, Operation>newBuilder()
            .setMethodDescriptor(createBackupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<CopyBackupRequest, Operation> copyBackupTransportSettings =
        GrpcCallSettings.<CopyBackupRequest, Operation>newBuilder()
            .setMethodDescriptor(copyBackupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
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
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<UpdateBackupRequest, Backup> updateBackupTransportSettings =
        GrpcCallSettings.<UpdateBackupRequest, Backup>newBuilder()
            .setMethodDescriptor(updateBackupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("backup.name", String.valueOf(request.getBackup().getName()));
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
            .setResourceNameExtractor(request -> request.getName())
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
            .setResourceNameExtractor(request -> request.getParent())
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
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<ListDatabaseOperationsRequest, ListDatabaseOperationsResponse>
        listDatabaseOperationsTransportSettings =
            GrpcCallSettings
                .<ListDatabaseOperationsRequest, ListDatabaseOperationsResponse>newBuilder()
                .setMethodDescriptor(listDatabaseOperationsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<ListBackupOperationsRequest, ListBackupOperationsResponse>
        listBackupOperationsTransportSettings =
            GrpcCallSettings.<ListBackupOperationsRequest, ListBackupOperationsResponse>newBuilder()
                .setMethodDescriptor(listBackupOperationsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<ListDatabaseRolesRequest, ListDatabaseRolesResponse>
        listDatabaseRolesTransportSettings =
            GrpcCallSettings.<ListDatabaseRolesRequest, ListDatabaseRolesResponse>newBuilder()
                .setMethodDescriptor(listDatabaseRolesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<AddSplitPointsRequest, AddSplitPointsResponse>
        addSplitPointsTransportSettings =
            GrpcCallSettings.<AddSplitPointsRequest, AddSplitPointsResponse>newBuilder()
                .setMethodDescriptor(addSplitPointsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("database", String.valueOf(request.getDatabase()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getDatabase())
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
                .setResourceNameExtractor(request -> request.getParent())
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
            .setResourceNameExtractor(request -> request.getName())
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
            .setResourceNameExtractor(request -> request.getName())
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
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<InternalUpdateGraphOperationRequest, InternalUpdateGraphOperationResponse>
        internalUpdateGraphOperationTransportSettings =
            GrpcCallSettings
                .<InternalUpdateGraphOperationRequest, InternalUpdateGraphOperationResponse>
                    newBuilder()
                .setMethodDescriptor(internalUpdateGraphOperationMethodDescriptor)
                .setResourceNameExtractor(request -> request.getDatabase())
                .build();

    this.listDatabasesCallable =
        callableFactory.createUnaryCallable(
            listDatabasesTransportSettings, settings.listDatabasesSettings(), clientContext);
    this.listDatabasesPagedCallable =
        callableFactory.createPagedCallable(
            listDatabasesTransportSettings, settings.listDatabasesSettings(), clientContext);
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
    this.updateDatabaseCallable =
        callableFactory.createUnaryCallable(
            updateDatabaseTransportSettings, settings.updateDatabaseSettings(), clientContext);
    this.updateDatabaseOperationCallable =
        callableFactory.createOperationCallable(
            updateDatabaseTransportSettings,
            settings.updateDatabaseOperationSettings(),
            clientContext,
            operationsStub);
    this.updateDatabaseDdlCallable =
        callableFactory.createUnaryCallable(
            updateDatabaseDdlTransportSettings,
            settings.updateDatabaseDdlSettings(),
            clientContext);
    this.updateDatabaseDdlOperationCallable =
        callableFactory.createOperationCallable(
            updateDatabaseDdlTransportSettings,
            settings.updateDatabaseDdlOperationSettings(),
            clientContext,
            operationsStub);
    this.dropDatabaseCallable =
        callableFactory.createUnaryCallable(
            dropDatabaseTransportSettings, settings.dropDatabaseSettings(), clientContext);
    this.getDatabaseDdlCallable =
        callableFactory.createUnaryCallable(
            getDatabaseDdlTransportSettings, settings.getDatabaseDdlSettings(), clientContext);
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.testIamPermissionsCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsTransportSettings,
            settings.testIamPermissionsSettings(),
            clientContext);
    this.createBackupCallable =
        callableFactory.createUnaryCallable(
            createBackupTransportSettings, settings.createBackupSettings(), clientContext);
    this.createBackupOperationCallable =
        callableFactory.createOperationCallable(
            createBackupTransportSettings,
            settings.createBackupOperationSettings(),
            clientContext,
            operationsStub);
    this.copyBackupCallable =
        callableFactory.createUnaryCallable(
            copyBackupTransportSettings, settings.copyBackupSettings(), clientContext);
    this.copyBackupOperationCallable =
        callableFactory.createOperationCallable(
            copyBackupTransportSettings,
            settings.copyBackupOperationSettings(),
            clientContext,
            operationsStub);
    this.getBackupCallable =
        callableFactory.createUnaryCallable(
            getBackupTransportSettings, settings.getBackupSettings(), clientContext);
    this.updateBackupCallable =
        callableFactory.createUnaryCallable(
            updateBackupTransportSettings, settings.updateBackupSettings(), clientContext);
    this.deleteBackupCallable =
        callableFactory.createUnaryCallable(
            deleteBackupTransportSettings, settings.deleteBackupSettings(), clientContext);
    this.listBackupsCallable =
        callableFactory.createUnaryCallable(
            listBackupsTransportSettings, settings.listBackupsSettings(), clientContext);
    this.listBackupsPagedCallable =
        callableFactory.createPagedCallable(
            listBackupsTransportSettings, settings.listBackupsSettings(), clientContext);
    this.restoreDatabaseCallable =
        callableFactory.createUnaryCallable(
            restoreDatabaseTransportSettings, settings.restoreDatabaseSettings(), clientContext);
    this.restoreDatabaseOperationCallable =
        callableFactory.createOperationCallable(
            restoreDatabaseTransportSettings,
            settings.restoreDatabaseOperationSettings(),
            clientContext,
            operationsStub);
    this.listDatabaseOperationsCallable =
        callableFactory.createUnaryCallable(
            listDatabaseOperationsTransportSettings,
            settings.listDatabaseOperationsSettings(),
            clientContext);
    this.listDatabaseOperationsPagedCallable =
        callableFactory.createPagedCallable(
            listDatabaseOperationsTransportSettings,
            settings.listDatabaseOperationsSettings(),
            clientContext);
    this.listBackupOperationsCallable =
        callableFactory.createUnaryCallable(
            listBackupOperationsTransportSettings,
            settings.listBackupOperationsSettings(),
            clientContext);
    this.listBackupOperationsPagedCallable =
        callableFactory.createPagedCallable(
            listBackupOperationsTransportSettings,
            settings.listBackupOperationsSettings(),
            clientContext);
    this.listDatabaseRolesCallable =
        callableFactory.createUnaryCallable(
            listDatabaseRolesTransportSettings,
            settings.listDatabaseRolesSettings(),
            clientContext);
    this.listDatabaseRolesPagedCallable =
        callableFactory.createPagedCallable(
            listDatabaseRolesTransportSettings,
            settings.listDatabaseRolesSettings(),
            clientContext);
    this.addSplitPointsCallable =
        callableFactory.createUnaryCallable(
            addSplitPointsTransportSettings, settings.addSplitPointsSettings(), clientContext);
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
    this.listBackupSchedulesCallable =
        callableFactory.createUnaryCallable(
            listBackupSchedulesTransportSettings,
            settings.listBackupSchedulesSettings(),
            clientContext);
    this.listBackupSchedulesPagedCallable =
        callableFactory.createPagedCallable(
            listBackupSchedulesTransportSettings,
            settings.listBackupSchedulesSettings(),
            clientContext);
    this.internalUpdateGraphOperationCallable =
        callableFactory.createUnaryCallable(
            internalUpdateGraphOperationTransportSettings,
            settings.internalUpdateGraphOperationSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListDatabasesRequest, ListDatabasesResponse> listDatabasesCallable() {
    return listDatabasesCallable;
  }

  @Override
  public UnaryCallable<ListDatabasesRequest, ListDatabasesPagedResponse>
      listDatabasesPagedCallable() {
    return listDatabasesPagedCallable;
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
  public UnaryCallable<UpdateDatabaseRequest, Operation> updateDatabaseCallable() {
    return updateDatabaseCallable;
  }

  @Override
  public OperationCallable<UpdateDatabaseRequest, Database, UpdateDatabaseMetadata>
      updateDatabaseOperationCallable() {
    return updateDatabaseOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateDatabaseDdlRequest, Operation> updateDatabaseDdlCallable() {
    return updateDatabaseDdlCallable;
  }

  @Override
  public OperationCallable<UpdateDatabaseDdlRequest, Empty, UpdateDatabaseDdlMetadata>
      updateDatabaseDdlOperationCallable() {
    return updateDatabaseDdlOperationCallable;
  }

  @Override
  public UnaryCallable<DropDatabaseRequest, Empty> dropDatabaseCallable() {
    return dropDatabaseCallable;
  }

  @Override
  public UnaryCallable<GetDatabaseDdlRequest, GetDatabaseDdlResponse> getDatabaseDdlCallable() {
    return getDatabaseDdlCallable;
  }

  @Override
  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
  }

  @Override
  public UnaryCallable<CreateBackupRequest, Operation> createBackupCallable() {
    return createBackupCallable;
  }

  @Override
  public OperationCallable<CreateBackupRequest, Backup, CreateBackupMetadata>
      createBackupOperationCallable() {
    return createBackupOperationCallable;
  }

  @Override
  public UnaryCallable<CopyBackupRequest, Operation> copyBackupCallable() {
    return copyBackupCallable;
  }

  @Override
  public OperationCallable<CopyBackupRequest, Backup, CopyBackupMetadata>
      copyBackupOperationCallable() {
    return copyBackupOperationCallable;
  }

  @Override
  public UnaryCallable<GetBackupRequest, Backup> getBackupCallable() {
    return getBackupCallable;
  }

  @Override
  public UnaryCallable<UpdateBackupRequest, Backup> updateBackupCallable() {
    return updateBackupCallable;
  }

  @Override
  public UnaryCallable<DeleteBackupRequest, Empty> deleteBackupCallable() {
    return deleteBackupCallable;
  }

  @Override
  public UnaryCallable<ListBackupsRequest, ListBackupsResponse> listBackupsCallable() {
    return listBackupsCallable;
  }

  @Override
  public UnaryCallable<ListBackupsRequest, ListBackupsPagedResponse> listBackupsPagedCallable() {
    return listBackupsPagedCallable;
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
  public UnaryCallable<ListDatabaseOperationsRequest, ListDatabaseOperationsResponse>
      listDatabaseOperationsCallable() {
    return listDatabaseOperationsCallable;
  }

  @Override
  public UnaryCallable<ListDatabaseOperationsRequest, ListDatabaseOperationsPagedResponse>
      listDatabaseOperationsPagedCallable() {
    return listDatabaseOperationsPagedCallable;
  }

  @Override
  public UnaryCallable<ListBackupOperationsRequest, ListBackupOperationsResponse>
      listBackupOperationsCallable() {
    return listBackupOperationsCallable;
  }

  @Override
  public UnaryCallable<ListBackupOperationsRequest, ListBackupOperationsPagedResponse>
      listBackupOperationsPagedCallable() {
    return listBackupOperationsPagedCallable;
  }

  @Override
  public UnaryCallable<ListDatabaseRolesRequest, ListDatabaseRolesResponse>
      listDatabaseRolesCallable() {
    return listDatabaseRolesCallable;
  }

  @Override
  public UnaryCallable<ListDatabaseRolesRequest, ListDatabaseRolesPagedResponse>
      listDatabaseRolesPagedCallable() {
    return listDatabaseRolesPagedCallable;
  }

  @Override
  public UnaryCallable<AddSplitPointsRequest, AddSplitPointsResponse> addSplitPointsCallable() {
    return addSplitPointsCallable;
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
  public UnaryCallable<UpdateBackupScheduleRequest, BackupSchedule> updateBackupScheduleCallable() {
    return updateBackupScheduleCallable;
  }

  @Override
  public UnaryCallable<DeleteBackupScheduleRequest, Empty> deleteBackupScheduleCallable() {
    return deleteBackupScheduleCallable;
  }

  @Override
  public UnaryCallable<ListBackupSchedulesRequest, ListBackupSchedulesResponse>
      listBackupSchedulesCallable() {
    return listBackupSchedulesCallable;
  }

  @Override
  public UnaryCallable<ListBackupSchedulesRequest, ListBackupSchedulesPagedResponse>
      listBackupSchedulesPagedCallable() {
    return listBackupSchedulesPagedCallable;
  }

  @Override
  public UnaryCallable<InternalUpdateGraphOperationRequest, InternalUpdateGraphOperationResponse>
      internalUpdateGraphOperationCallable() {
    return internalUpdateGraphOperationCallable;
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
