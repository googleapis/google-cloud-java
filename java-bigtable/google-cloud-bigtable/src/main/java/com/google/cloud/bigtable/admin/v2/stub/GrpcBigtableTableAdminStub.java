/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.bigtable.admin.v2.stub;

import static com.google.cloud.bigtable.admin.v2.BaseBigtableTableAdminClient.ListBackupsPagedResponse;
import static com.google.cloud.bigtable.admin.v2.BaseBigtableTableAdminClient.ListSnapshotsPagedResponse;
import static com.google.cloud.bigtable.admin.v2.BaseBigtableTableAdminClient.ListTablesPagedResponse;

import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.bigtable.admin.v2.Backup;
import com.google.bigtable.admin.v2.CheckConsistencyRequest;
import com.google.bigtable.admin.v2.CheckConsistencyResponse;
import com.google.bigtable.admin.v2.CreateBackupMetadata;
import com.google.bigtable.admin.v2.CreateBackupRequest;
import com.google.bigtable.admin.v2.CreateTableFromSnapshotMetadata;
import com.google.bigtable.admin.v2.CreateTableFromSnapshotRequest;
import com.google.bigtable.admin.v2.CreateTableRequest;
import com.google.bigtable.admin.v2.DeleteBackupRequest;
import com.google.bigtable.admin.v2.DeleteSnapshotRequest;
import com.google.bigtable.admin.v2.DeleteTableRequest;
import com.google.bigtable.admin.v2.DropRowRangeRequest;
import com.google.bigtable.admin.v2.GenerateConsistencyTokenRequest;
import com.google.bigtable.admin.v2.GenerateConsistencyTokenResponse;
import com.google.bigtable.admin.v2.GetBackupRequest;
import com.google.bigtable.admin.v2.GetSnapshotRequest;
import com.google.bigtable.admin.v2.GetTableRequest;
import com.google.bigtable.admin.v2.ListBackupsRequest;
import com.google.bigtable.admin.v2.ListBackupsResponse;
import com.google.bigtable.admin.v2.ListSnapshotsRequest;
import com.google.bigtable.admin.v2.ListSnapshotsResponse;
import com.google.bigtable.admin.v2.ListTablesRequest;
import com.google.bigtable.admin.v2.ListTablesResponse;
import com.google.bigtable.admin.v2.ModifyColumnFamiliesRequest;
import com.google.bigtable.admin.v2.RestoreTableMetadata;
import com.google.bigtable.admin.v2.RestoreTableRequest;
import com.google.bigtable.admin.v2.Snapshot;
import com.google.bigtable.admin.v2.SnapshotTableMetadata;
import com.google.bigtable.admin.v2.SnapshotTableRequest;
import com.google.bigtable.admin.v2.Table;
import com.google.bigtable.admin.v2.UpdateBackupRequest;
import com.google.common.collect.ImmutableMap;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/** For internal use only. */
@Generated("by gapic-generator")
@InternalApi
public class GrpcBigtableTableAdminStub extends BigtableTableAdminStub {
  private static final MethodDescriptor<CreateTableRequest, Table> createTableMethodDescriptor =
      MethodDescriptor.<CreateTableRequest, Table>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.bigtable.admin.v2.BigtableTableAdmin/CreateTable")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateTableRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Table.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateTableFromSnapshotRequest, Operation>
      createTableFromSnapshotMethodDescriptor =
          MethodDescriptor.<CreateTableFromSnapshotRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.bigtable.admin.v2.BigtableTableAdmin/CreateTableFromSnapshot")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateTableFromSnapshotRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListTablesRequest, ListTablesResponse>
      listTablesMethodDescriptor =
          MethodDescriptor.<ListTablesRequest, ListTablesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.bigtable.admin.v2.BigtableTableAdmin/ListTables")
              .setRequestMarshaller(ProtoUtils.marshaller(ListTablesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListTablesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetTableRequest, Table> getTableMethodDescriptor =
      MethodDescriptor.<GetTableRequest, Table>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.bigtable.admin.v2.BigtableTableAdmin/GetTable")
          .setRequestMarshaller(ProtoUtils.marshaller(GetTableRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Table.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteTableRequest, Empty> deleteTableMethodDescriptor =
      MethodDescriptor.<DeleteTableRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.bigtable.admin.v2.BigtableTableAdmin/DeleteTable")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteTableRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ModifyColumnFamiliesRequest, Table>
      modifyColumnFamiliesMethodDescriptor =
          MethodDescriptor.<ModifyColumnFamiliesRequest, Table>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.bigtable.admin.v2.BigtableTableAdmin/ModifyColumnFamilies")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ModifyColumnFamiliesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Table.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DropRowRangeRequest, Empty> dropRowRangeMethodDescriptor =
      MethodDescriptor.<DropRowRangeRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.bigtable.admin.v2.BigtableTableAdmin/DropRowRange")
          .setRequestMarshaller(ProtoUtils.marshaller(DropRowRangeRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<
          GenerateConsistencyTokenRequest, GenerateConsistencyTokenResponse>
      generateConsistencyTokenMethodDescriptor =
          MethodDescriptor
              .<GenerateConsistencyTokenRequest, GenerateConsistencyTokenResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.bigtable.admin.v2.BigtableTableAdmin/GenerateConsistencyToken")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GenerateConsistencyTokenRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GenerateConsistencyTokenResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CheckConsistencyRequest, CheckConsistencyResponse>
      checkConsistencyMethodDescriptor =
          MethodDescriptor.<CheckConsistencyRequest, CheckConsistencyResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.bigtable.admin.v2.BigtableTableAdmin/CheckConsistency")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CheckConsistencyRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(CheckConsistencyResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SnapshotTableRequest, Operation>
      snapshotTableMethodDescriptor =
          MethodDescriptor.<SnapshotTableRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.bigtable.admin.v2.BigtableTableAdmin/SnapshotTable")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SnapshotTableRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetSnapshotRequest, Snapshot> getSnapshotMethodDescriptor =
      MethodDescriptor.<GetSnapshotRequest, Snapshot>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.bigtable.admin.v2.BigtableTableAdmin/GetSnapshot")
          .setRequestMarshaller(ProtoUtils.marshaller(GetSnapshotRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Snapshot.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListSnapshotsRequest, ListSnapshotsResponse>
      listSnapshotsMethodDescriptor =
          MethodDescriptor.<ListSnapshotsRequest, ListSnapshotsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.bigtable.admin.v2.BigtableTableAdmin/ListSnapshots")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListSnapshotsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListSnapshotsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteSnapshotRequest, Empty>
      deleteSnapshotMethodDescriptor =
          MethodDescriptor.<DeleteSnapshotRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.bigtable.admin.v2.BigtableTableAdmin/DeleteSnapshot")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteSnapshotRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateBackupRequest, Operation>
      createBackupMethodDescriptor =
          MethodDescriptor.<CreateBackupRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.bigtable.admin.v2.BigtableTableAdmin/CreateBackup")
              .setRequestMarshaller(ProtoUtils.marshaller(CreateBackupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetBackupRequest, Backup> getBackupMethodDescriptor =
      MethodDescriptor.<GetBackupRequest, Backup>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.bigtable.admin.v2.BigtableTableAdmin/GetBackup")
          .setRequestMarshaller(ProtoUtils.marshaller(GetBackupRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Backup.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateBackupRequest, Backup> updateBackupMethodDescriptor =
      MethodDescriptor.<UpdateBackupRequest, Backup>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.bigtable.admin.v2.BigtableTableAdmin/UpdateBackup")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateBackupRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Backup.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteBackupRequest, Empty> deleteBackupMethodDescriptor =
      MethodDescriptor.<DeleteBackupRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.bigtable.admin.v2.BigtableTableAdmin/DeleteBackup")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteBackupRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListBackupsRequest, ListBackupsResponse>
      listBackupsMethodDescriptor =
          MethodDescriptor.<ListBackupsRequest, ListBackupsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.bigtable.admin.v2.BigtableTableAdmin/ListBackups")
              .setRequestMarshaller(ProtoUtils.marshaller(ListBackupsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListBackupsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RestoreTableRequest, Operation>
      restoreTableMethodDescriptor =
          MethodDescriptor.<RestoreTableRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.bigtable.admin.v2.BigtableTableAdmin/RestoreTable")
              .setRequestMarshaller(ProtoUtils.marshaller(RestoreTableRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.bigtable.admin.v2.BigtableTableAdmin/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.bigtable.admin.v2.BigtableTableAdmin/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          MethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.bigtable.admin.v2.BigtableTableAdmin/TestIamPermissions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreateTableRequest, Table> createTableCallable;
  private final UnaryCallable<CreateTableFromSnapshotRequest, Operation>
      createTableFromSnapshotCallable;
  private final OperationCallable<
          CreateTableFromSnapshotRequest, Table, CreateTableFromSnapshotMetadata>
      createTableFromSnapshotOperationCallable;
  private final UnaryCallable<ListTablesRequest, ListTablesResponse> listTablesCallable;
  private final UnaryCallable<ListTablesRequest, ListTablesPagedResponse> listTablesPagedCallable;
  private final UnaryCallable<GetTableRequest, Table> getTableCallable;
  private final UnaryCallable<DeleteTableRequest, Empty> deleteTableCallable;
  private final UnaryCallable<ModifyColumnFamiliesRequest, Table> modifyColumnFamiliesCallable;
  private final UnaryCallable<DropRowRangeRequest, Empty> dropRowRangeCallable;
  private final UnaryCallable<GenerateConsistencyTokenRequest, GenerateConsistencyTokenResponse>
      generateConsistencyTokenCallable;
  private final UnaryCallable<CheckConsistencyRequest, CheckConsistencyResponse>
      checkConsistencyCallable;
  private final UnaryCallable<SnapshotTableRequest, Operation> snapshotTableCallable;
  private final OperationCallable<SnapshotTableRequest, Snapshot, SnapshotTableMetadata>
      snapshotTableOperationCallable;
  private final UnaryCallable<GetSnapshotRequest, Snapshot> getSnapshotCallable;
  private final UnaryCallable<ListSnapshotsRequest, ListSnapshotsResponse> listSnapshotsCallable;
  private final UnaryCallable<ListSnapshotsRequest, ListSnapshotsPagedResponse>
      listSnapshotsPagedCallable;
  private final UnaryCallable<DeleteSnapshotRequest, Empty> deleteSnapshotCallable;
  private final UnaryCallable<CreateBackupRequest, Operation> createBackupCallable;
  private final OperationCallable<CreateBackupRequest, Backup, CreateBackupMetadata>
      createBackupOperationCallable;
  private final UnaryCallable<GetBackupRequest, Backup> getBackupCallable;
  private final UnaryCallable<UpdateBackupRequest, Backup> updateBackupCallable;
  private final UnaryCallable<DeleteBackupRequest, Empty> deleteBackupCallable;
  private final UnaryCallable<ListBackupsRequest, ListBackupsResponse> listBackupsCallable;
  private final UnaryCallable<ListBackupsRequest, ListBackupsPagedResponse>
      listBackupsPagedCallable;
  private final UnaryCallable<RestoreTableRequest, Operation> restoreTableCallable;
  private final OperationCallable<RestoreTableRequest, Table, RestoreTableMetadata>
      restoreTableOperationCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcBigtableTableAdminStub create(BigtableTableAdminStubSettings settings)
      throws IOException {
    return new GrpcBigtableTableAdminStub(settings, ClientContext.create(settings));
  }

  public static final GrpcBigtableTableAdminStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcBigtableTableAdminStub(
        BigtableTableAdminStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcBigtableTableAdminStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcBigtableTableAdminStub(
        BigtableTableAdminStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcBigtableTableAdminStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcBigtableTableAdminStub(
      BigtableTableAdminStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcBigtableTableAdminCallableFactory());
  }

  /**
   * Constructs an instance of GrpcBigtableTableAdminStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcBigtableTableAdminStub(
      BigtableTableAdminStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateTableRequest, Table> createTableTransportSettings =
        GrpcCallSettings.<CreateTableRequest, Table>newBuilder()
            .setMethodDescriptor(createTableMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateTableRequest>() {
                  @Override
                  public Map<String, String> extract(CreateTableRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CreateTableFromSnapshotRequest, Operation>
        createTableFromSnapshotTransportSettings =
            GrpcCallSettings.<CreateTableFromSnapshotRequest, Operation>newBuilder()
                .setMethodDescriptor(createTableFromSnapshotMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<CreateTableFromSnapshotRequest>() {
                      @Override
                      public Map<String, String> extract(CreateTableFromSnapshotRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<ListTablesRequest, ListTablesResponse> listTablesTransportSettings =
        GrpcCallSettings.<ListTablesRequest, ListTablesResponse>newBuilder()
            .setMethodDescriptor(listTablesMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ListTablesRequest>() {
                  @Override
                  public Map<String, String> extract(ListTablesRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetTableRequest, Table> getTableTransportSettings =
        GrpcCallSettings.<GetTableRequest, Table>newBuilder()
            .setMethodDescriptor(getTableMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetTableRequest>() {
                  @Override
                  public Map<String, String> extract(GetTableRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeleteTableRequest, Empty> deleteTableTransportSettings =
        GrpcCallSettings.<DeleteTableRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteTableMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteTableRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteTableRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ModifyColumnFamiliesRequest, Table> modifyColumnFamiliesTransportSettings =
        GrpcCallSettings.<ModifyColumnFamiliesRequest, Table>newBuilder()
            .setMethodDescriptor(modifyColumnFamiliesMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ModifyColumnFamiliesRequest>() {
                  @Override
                  public Map<String, String> extract(ModifyColumnFamiliesRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DropRowRangeRequest, Empty> dropRowRangeTransportSettings =
        GrpcCallSettings.<DropRowRangeRequest, Empty>newBuilder()
            .setMethodDescriptor(dropRowRangeMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DropRowRangeRequest>() {
                  @Override
                  public Map<String, String> extract(DropRowRangeRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GenerateConsistencyTokenRequest, GenerateConsistencyTokenResponse>
        generateConsistencyTokenTransportSettings =
            GrpcCallSettings
                .<GenerateConsistencyTokenRequest, GenerateConsistencyTokenResponse>newBuilder()
                .setMethodDescriptor(generateConsistencyTokenMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<GenerateConsistencyTokenRequest>() {
                      @Override
                      public Map<String, String> extract(GenerateConsistencyTokenRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<CheckConsistencyRequest, CheckConsistencyResponse>
        checkConsistencyTransportSettings =
            GrpcCallSettings.<CheckConsistencyRequest, CheckConsistencyResponse>newBuilder()
                .setMethodDescriptor(checkConsistencyMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<CheckConsistencyRequest>() {
                      @Override
                      public Map<String, String> extract(CheckConsistencyRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<SnapshotTableRequest, Operation> snapshotTableTransportSettings =
        GrpcCallSettings.<SnapshotTableRequest, Operation>newBuilder()
            .setMethodDescriptor(snapshotTableMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<SnapshotTableRequest>() {
                  @Override
                  public Map<String, String> extract(SnapshotTableRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetSnapshotRequest, Snapshot> getSnapshotTransportSettings =
        GrpcCallSettings.<GetSnapshotRequest, Snapshot>newBuilder()
            .setMethodDescriptor(getSnapshotMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetSnapshotRequest>() {
                  @Override
                  public Map<String, String> extract(GetSnapshotRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListSnapshotsRequest, ListSnapshotsResponse> listSnapshotsTransportSettings =
        GrpcCallSettings.<ListSnapshotsRequest, ListSnapshotsResponse>newBuilder()
            .setMethodDescriptor(listSnapshotsMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ListSnapshotsRequest>() {
                  @Override
                  public Map<String, String> extract(ListSnapshotsRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeleteSnapshotRequest, Empty> deleteSnapshotTransportSettings =
        GrpcCallSettings.<DeleteSnapshotRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteSnapshotMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteSnapshotRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteSnapshotRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CreateBackupRequest, Operation> createBackupTransportSettings =
        GrpcCallSettings.<CreateBackupRequest, Operation>newBuilder()
            .setMethodDescriptor(createBackupMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateBackupRequest>() {
                  @Override
                  public Map<String, String> extract(CreateBackupRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetBackupRequest, Backup> getBackupTransportSettings =
        GrpcCallSettings.<GetBackupRequest, Backup>newBuilder()
            .setMethodDescriptor(getBackupMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetBackupRequest>() {
                  @Override
                  public Map<String, String> extract(GetBackupRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UpdateBackupRequest, Backup> updateBackupTransportSettings =
        GrpcCallSettings.<UpdateBackupRequest, Backup>newBuilder()
            .setMethodDescriptor(updateBackupMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateBackupRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateBackupRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("backup.name", String.valueOf(request.getBackup().getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeleteBackupRequest, Empty> deleteBackupTransportSettings =
        GrpcCallSettings.<DeleteBackupRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteBackupMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteBackupRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteBackupRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListBackupsRequest, ListBackupsResponse> listBackupsTransportSettings =
        GrpcCallSettings.<ListBackupsRequest, ListBackupsResponse>newBuilder()
            .setMethodDescriptor(listBackupsMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ListBackupsRequest>() {
                  @Override
                  public Map<String, String> extract(ListBackupsRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<RestoreTableRequest, Operation> restoreTableTransportSettings =
        GrpcCallSettings.<RestoreTableRequest, Operation>newBuilder()
            .setMethodDescriptor(restoreTableMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<RestoreTableRequest>() {
                  @Override
                  public Map<String, String> extract(RestoreTableRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        GrpcCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetIamPolicyRequest>() {
                  @Override
                  public Map<String, String> extract(GetIamPolicyRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("resource", String.valueOf(request.getResource()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        GrpcCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<SetIamPolicyRequest>() {
                  @Override
                  public Map<String, String> extract(SetIamPolicyRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("resource", String.valueOf(request.getResource()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            GrpcCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<TestIamPermissionsRequest>() {
                      @Override
                      public Map<String, String> extract(TestIamPermissionsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("resource", String.valueOf(request.getResource()));
                        return params.build();
                      }
                    })
                .build();

    this.createTableCallable =
        callableFactory.createUnaryCallable(
            createTableTransportSettings, settings.createTableSettings(), clientContext);
    this.createTableFromSnapshotCallable =
        callableFactory.createUnaryCallable(
            createTableFromSnapshotTransportSettings,
            settings.createTableFromSnapshotSettings(),
            clientContext);
    this.createTableFromSnapshotOperationCallable =
        callableFactory.createOperationCallable(
            createTableFromSnapshotTransportSettings,
            settings.createTableFromSnapshotOperationSettings(),
            clientContext,
            operationsStub);
    this.listTablesCallable =
        callableFactory.createUnaryCallable(
            listTablesTransportSettings, settings.listTablesSettings(), clientContext);
    this.listTablesPagedCallable =
        callableFactory.createPagedCallable(
            listTablesTransportSettings, settings.listTablesSettings(), clientContext);
    this.getTableCallable =
        callableFactory.createUnaryCallable(
            getTableTransportSettings, settings.getTableSettings(), clientContext);
    this.deleteTableCallable =
        callableFactory.createUnaryCallable(
            deleteTableTransportSettings, settings.deleteTableSettings(), clientContext);
    this.modifyColumnFamiliesCallable =
        callableFactory.createUnaryCallable(
            modifyColumnFamiliesTransportSettings,
            settings.modifyColumnFamiliesSettings(),
            clientContext);
    this.dropRowRangeCallable =
        callableFactory.createUnaryCallable(
            dropRowRangeTransportSettings, settings.dropRowRangeSettings(), clientContext);
    this.generateConsistencyTokenCallable =
        callableFactory.createUnaryCallable(
            generateConsistencyTokenTransportSettings,
            settings.generateConsistencyTokenSettings(),
            clientContext);
    this.checkConsistencyCallable =
        callableFactory.createUnaryCallable(
            checkConsistencyTransportSettings, settings.checkConsistencySettings(), clientContext);
    this.snapshotTableCallable =
        callableFactory.createUnaryCallable(
            snapshotTableTransportSettings, settings.snapshotTableSettings(), clientContext);
    this.snapshotTableOperationCallable =
        callableFactory.createOperationCallable(
            snapshotTableTransportSettings,
            settings.snapshotTableOperationSettings(),
            clientContext,
            operationsStub);
    this.getSnapshotCallable =
        callableFactory.createUnaryCallable(
            getSnapshotTransportSettings, settings.getSnapshotSettings(), clientContext);
    this.listSnapshotsCallable =
        callableFactory.createUnaryCallable(
            listSnapshotsTransportSettings, settings.listSnapshotsSettings(), clientContext);
    this.listSnapshotsPagedCallable =
        callableFactory.createPagedCallable(
            listSnapshotsTransportSettings, settings.listSnapshotsSettings(), clientContext);
    this.deleteSnapshotCallable =
        callableFactory.createUnaryCallable(
            deleteSnapshotTransportSettings, settings.deleteSnapshotSettings(), clientContext);
    this.createBackupCallable =
        callableFactory.createUnaryCallable(
            createBackupTransportSettings, settings.createBackupSettings(), clientContext);
    this.createBackupOperationCallable =
        callableFactory.createOperationCallable(
            createBackupTransportSettings,
            settings.createBackupOperationSettings(),
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
    this.restoreTableCallable =
        callableFactory.createUnaryCallable(
            restoreTableTransportSettings, settings.restoreTableSettings(), clientContext);
    this.restoreTableOperationCallable =
        callableFactory.createOperationCallable(
            restoreTableTransportSettings,
            settings.restoreTableOperationSettings(),
            clientContext,
            operationsStub);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.testIamPermissionsCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsTransportSettings,
            settings.testIamPermissionsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateTableRequest, Table> createTableCallable() {
    return createTableCallable;
  }

  @Override
  public UnaryCallable<CreateTableFromSnapshotRequest, Operation>
      createTableFromSnapshotCallable() {
    return createTableFromSnapshotCallable;
  }

  @Override
  public OperationCallable<CreateTableFromSnapshotRequest, Table, CreateTableFromSnapshotMetadata>
      createTableFromSnapshotOperationCallable() {
    return createTableFromSnapshotOperationCallable;
  }

  @Override
  public UnaryCallable<ListTablesRequest, ListTablesResponse> listTablesCallable() {
    return listTablesCallable;
  }

  @Override
  public UnaryCallable<ListTablesRequest, ListTablesPagedResponse> listTablesPagedCallable() {
    return listTablesPagedCallable;
  }

  @Override
  public UnaryCallable<GetTableRequest, Table> getTableCallable() {
    return getTableCallable;
  }

  @Override
  public UnaryCallable<DeleteTableRequest, Empty> deleteTableCallable() {
    return deleteTableCallable;
  }

  @Override
  public UnaryCallable<ModifyColumnFamiliesRequest, Table> modifyColumnFamiliesCallable() {
    return modifyColumnFamiliesCallable;
  }

  @Override
  public UnaryCallable<DropRowRangeRequest, Empty> dropRowRangeCallable() {
    return dropRowRangeCallable;
  }

  @Override
  public UnaryCallable<GenerateConsistencyTokenRequest, GenerateConsistencyTokenResponse>
      generateConsistencyTokenCallable() {
    return generateConsistencyTokenCallable;
  }

  @Override
  public UnaryCallable<CheckConsistencyRequest, CheckConsistencyResponse>
      checkConsistencyCallable() {
    return checkConsistencyCallable;
  }

  @Override
  public UnaryCallable<SnapshotTableRequest, Operation> snapshotTableCallable() {
    return snapshotTableCallable;
  }

  @Override
  public OperationCallable<SnapshotTableRequest, Snapshot, SnapshotTableMetadata>
      snapshotTableOperationCallable() {
    return snapshotTableOperationCallable;
  }

  @Override
  public UnaryCallable<GetSnapshotRequest, Snapshot> getSnapshotCallable() {
    return getSnapshotCallable;
  }

  @Override
  public UnaryCallable<ListSnapshotsRequest, ListSnapshotsResponse> listSnapshotsCallable() {
    return listSnapshotsCallable;
  }

  @Override
  public UnaryCallable<ListSnapshotsRequest, ListSnapshotsPagedResponse>
      listSnapshotsPagedCallable() {
    return listSnapshotsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteSnapshotRequest, Empty> deleteSnapshotCallable() {
    return deleteSnapshotCallable;
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
  public UnaryCallable<RestoreTableRequest, Operation> restoreTableCallable() {
    return restoreTableCallable;
  }

  @Override
  public OperationCallable<RestoreTableRequest, Table, RestoreTableMetadata>
      restoreTableOperationCallable() {
    return restoreTableOperationCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
  }

  @Override
  public final void close() {
    shutdown();
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
