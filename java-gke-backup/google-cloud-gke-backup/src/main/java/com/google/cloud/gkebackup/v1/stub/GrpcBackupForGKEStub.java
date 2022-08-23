/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.gkebackup.v1.stub;

import static com.google.cloud.gkebackup.v1.BackupForGKEClient.ListBackupPlansPagedResponse;
import static com.google.cloud.gkebackup.v1.BackupForGKEClient.ListBackupsPagedResponse;
import static com.google.cloud.gkebackup.v1.BackupForGKEClient.ListRestorePlansPagedResponse;
import static com.google.cloud.gkebackup.v1.BackupForGKEClient.ListRestoresPagedResponse;
import static com.google.cloud.gkebackup.v1.BackupForGKEClient.ListVolumeBackupsPagedResponse;
import static com.google.cloud.gkebackup.v1.BackupForGKEClient.ListVolumeRestoresPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.gkebackup.v1.Backup;
import com.google.cloud.gkebackup.v1.BackupPlan;
import com.google.cloud.gkebackup.v1.CreateBackupPlanRequest;
import com.google.cloud.gkebackup.v1.CreateBackupRequest;
import com.google.cloud.gkebackup.v1.CreateRestorePlanRequest;
import com.google.cloud.gkebackup.v1.CreateRestoreRequest;
import com.google.cloud.gkebackup.v1.DeleteBackupPlanRequest;
import com.google.cloud.gkebackup.v1.DeleteBackupRequest;
import com.google.cloud.gkebackup.v1.DeleteRestorePlanRequest;
import com.google.cloud.gkebackup.v1.DeleteRestoreRequest;
import com.google.cloud.gkebackup.v1.GetBackupPlanRequest;
import com.google.cloud.gkebackup.v1.GetBackupRequest;
import com.google.cloud.gkebackup.v1.GetRestorePlanRequest;
import com.google.cloud.gkebackup.v1.GetRestoreRequest;
import com.google.cloud.gkebackup.v1.GetVolumeBackupRequest;
import com.google.cloud.gkebackup.v1.GetVolumeRestoreRequest;
import com.google.cloud.gkebackup.v1.ListBackupPlansRequest;
import com.google.cloud.gkebackup.v1.ListBackupPlansResponse;
import com.google.cloud.gkebackup.v1.ListBackupsRequest;
import com.google.cloud.gkebackup.v1.ListBackupsResponse;
import com.google.cloud.gkebackup.v1.ListRestorePlansRequest;
import com.google.cloud.gkebackup.v1.ListRestorePlansResponse;
import com.google.cloud.gkebackup.v1.ListRestoresRequest;
import com.google.cloud.gkebackup.v1.ListRestoresResponse;
import com.google.cloud.gkebackup.v1.ListVolumeBackupsRequest;
import com.google.cloud.gkebackup.v1.ListVolumeBackupsResponse;
import com.google.cloud.gkebackup.v1.ListVolumeRestoresRequest;
import com.google.cloud.gkebackup.v1.ListVolumeRestoresResponse;
import com.google.cloud.gkebackup.v1.OperationMetadata;
import com.google.cloud.gkebackup.v1.Restore;
import com.google.cloud.gkebackup.v1.RestorePlan;
import com.google.cloud.gkebackup.v1.UpdateBackupPlanRequest;
import com.google.cloud.gkebackup.v1.UpdateBackupRequest;
import com.google.cloud.gkebackup.v1.UpdateRestorePlanRequest;
import com.google.cloud.gkebackup.v1.UpdateRestoreRequest;
import com.google.cloud.gkebackup.v1.VolumeBackup;
import com.google.cloud.gkebackup.v1.VolumeRestore;
import com.google.common.collect.ImmutableMap;
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
 * gRPC stub implementation for the BackupForGKE service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcBackupForGKEStub extends BackupForGKEStub {
  private static final MethodDescriptor<CreateBackupPlanRequest, Operation>
      createBackupPlanMethodDescriptor =
          MethodDescriptor.<CreateBackupPlanRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkebackup.v1.BackupForGKE/CreateBackupPlan")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateBackupPlanRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListBackupPlansRequest, ListBackupPlansResponse>
      listBackupPlansMethodDescriptor =
          MethodDescriptor.<ListBackupPlansRequest, ListBackupPlansResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkebackup.v1.BackupForGKE/ListBackupPlans")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListBackupPlansRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListBackupPlansResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetBackupPlanRequest, BackupPlan>
      getBackupPlanMethodDescriptor =
          MethodDescriptor.<GetBackupPlanRequest, BackupPlan>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkebackup.v1.BackupForGKE/GetBackupPlan")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetBackupPlanRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(BackupPlan.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateBackupPlanRequest, Operation>
      updateBackupPlanMethodDescriptor =
          MethodDescriptor.<UpdateBackupPlanRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkebackup.v1.BackupForGKE/UpdateBackupPlan")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateBackupPlanRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteBackupPlanRequest, Operation>
      deleteBackupPlanMethodDescriptor =
          MethodDescriptor.<DeleteBackupPlanRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkebackup.v1.BackupForGKE/DeleteBackupPlan")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteBackupPlanRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateBackupRequest, Operation>
      createBackupMethodDescriptor =
          MethodDescriptor.<CreateBackupRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkebackup.v1.BackupForGKE/CreateBackup")
              .setRequestMarshaller(ProtoUtils.marshaller(CreateBackupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListBackupsRequest, ListBackupsResponse>
      listBackupsMethodDescriptor =
          MethodDescriptor.<ListBackupsRequest, ListBackupsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkebackup.v1.BackupForGKE/ListBackups")
              .setRequestMarshaller(ProtoUtils.marshaller(ListBackupsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListBackupsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetBackupRequest, Backup> getBackupMethodDescriptor =
      MethodDescriptor.<GetBackupRequest, Backup>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.gkebackup.v1.BackupForGKE/GetBackup")
          .setRequestMarshaller(ProtoUtils.marshaller(GetBackupRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Backup.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateBackupRequest, Operation>
      updateBackupMethodDescriptor =
          MethodDescriptor.<UpdateBackupRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkebackup.v1.BackupForGKE/UpdateBackup")
              .setRequestMarshaller(ProtoUtils.marshaller(UpdateBackupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteBackupRequest, Operation>
      deleteBackupMethodDescriptor =
          MethodDescriptor.<DeleteBackupRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkebackup.v1.BackupForGKE/DeleteBackup")
              .setRequestMarshaller(ProtoUtils.marshaller(DeleteBackupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListVolumeBackupsRequest, ListVolumeBackupsResponse>
      listVolumeBackupsMethodDescriptor =
          MethodDescriptor.<ListVolumeBackupsRequest, ListVolumeBackupsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkebackup.v1.BackupForGKE/ListVolumeBackups")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListVolumeBackupsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListVolumeBackupsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetVolumeBackupRequest, VolumeBackup>
      getVolumeBackupMethodDescriptor =
          MethodDescriptor.<GetVolumeBackupRequest, VolumeBackup>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkebackup.v1.BackupForGKE/GetVolumeBackup")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetVolumeBackupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(VolumeBackup.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateRestorePlanRequest, Operation>
      createRestorePlanMethodDescriptor =
          MethodDescriptor.<CreateRestorePlanRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkebackup.v1.BackupForGKE/CreateRestorePlan")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateRestorePlanRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListRestorePlansRequest, ListRestorePlansResponse>
      listRestorePlansMethodDescriptor =
          MethodDescriptor.<ListRestorePlansRequest, ListRestorePlansResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkebackup.v1.BackupForGKE/ListRestorePlans")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListRestorePlansRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListRestorePlansResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetRestorePlanRequest, RestorePlan>
      getRestorePlanMethodDescriptor =
          MethodDescriptor.<GetRestorePlanRequest, RestorePlan>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkebackup.v1.BackupForGKE/GetRestorePlan")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetRestorePlanRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(RestorePlan.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateRestorePlanRequest, Operation>
      updateRestorePlanMethodDescriptor =
          MethodDescriptor.<UpdateRestorePlanRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkebackup.v1.BackupForGKE/UpdateRestorePlan")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateRestorePlanRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteRestorePlanRequest, Operation>
      deleteRestorePlanMethodDescriptor =
          MethodDescriptor.<DeleteRestorePlanRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkebackup.v1.BackupForGKE/DeleteRestorePlan")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteRestorePlanRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateRestoreRequest, Operation>
      createRestoreMethodDescriptor =
          MethodDescriptor.<CreateRestoreRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkebackup.v1.BackupForGKE/CreateRestore")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateRestoreRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListRestoresRequest, ListRestoresResponse>
      listRestoresMethodDescriptor =
          MethodDescriptor.<ListRestoresRequest, ListRestoresResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkebackup.v1.BackupForGKE/ListRestores")
              .setRequestMarshaller(ProtoUtils.marshaller(ListRestoresRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListRestoresResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetRestoreRequest, Restore> getRestoreMethodDescriptor =
      MethodDescriptor.<GetRestoreRequest, Restore>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.gkebackup.v1.BackupForGKE/GetRestore")
          .setRequestMarshaller(ProtoUtils.marshaller(GetRestoreRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Restore.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateRestoreRequest, Operation>
      updateRestoreMethodDescriptor =
          MethodDescriptor.<UpdateRestoreRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkebackup.v1.BackupForGKE/UpdateRestore")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateRestoreRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteRestoreRequest, Operation>
      deleteRestoreMethodDescriptor =
          MethodDescriptor.<DeleteRestoreRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkebackup.v1.BackupForGKE/DeleteRestore")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteRestoreRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListVolumeRestoresRequest, ListVolumeRestoresResponse>
      listVolumeRestoresMethodDescriptor =
          MethodDescriptor.<ListVolumeRestoresRequest, ListVolumeRestoresResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkebackup.v1.BackupForGKE/ListVolumeRestores")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListVolumeRestoresRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListVolumeRestoresResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetVolumeRestoreRequest, VolumeRestore>
      getVolumeRestoreMethodDescriptor =
          MethodDescriptor.<GetVolumeRestoreRequest, VolumeRestore>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.gkebackup.v1.BackupForGKE/GetVolumeRestore")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetVolumeRestoreRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(VolumeRestore.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreateBackupPlanRequest, Operation> createBackupPlanCallable;
  private final OperationCallable<CreateBackupPlanRequest, BackupPlan, OperationMetadata>
      createBackupPlanOperationCallable;
  private final UnaryCallable<ListBackupPlansRequest, ListBackupPlansResponse>
      listBackupPlansCallable;
  private final UnaryCallable<ListBackupPlansRequest, ListBackupPlansPagedResponse>
      listBackupPlansPagedCallable;
  private final UnaryCallable<GetBackupPlanRequest, BackupPlan> getBackupPlanCallable;
  private final UnaryCallable<UpdateBackupPlanRequest, Operation> updateBackupPlanCallable;
  private final OperationCallable<UpdateBackupPlanRequest, BackupPlan, OperationMetadata>
      updateBackupPlanOperationCallable;
  private final UnaryCallable<DeleteBackupPlanRequest, Operation> deleteBackupPlanCallable;
  private final OperationCallable<DeleteBackupPlanRequest, Empty, OperationMetadata>
      deleteBackupPlanOperationCallable;
  private final UnaryCallable<CreateBackupRequest, Operation> createBackupCallable;
  private final OperationCallable<CreateBackupRequest, Backup, OperationMetadata>
      createBackupOperationCallable;
  private final UnaryCallable<ListBackupsRequest, ListBackupsResponse> listBackupsCallable;
  private final UnaryCallable<ListBackupsRequest, ListBackupsPagedResponse>
      listBackupsPagedCallable;
  private final UnaryCallable<GetBackupRequest, Backup> getBackupCallable;
  private final UnaryCallable<UpdateBackupRequest, Operation> updateBackupCallable;
  private final OperationCallable<UpdateBackupRequest, Backup, OperationMetadata>
      updateBackupOperationCallable;
  private final UnaryCallable<DeleteBackupRequest, Operation> deleteBackupCallable;
  private final OperationCallable<DeleteBackupRequest, Empty, OperationMetadata>
      deleteBackupOperationCallable;
  private final UnaryCallable<ListVolumeBackupsRequest, ListVolumeBackupsResponse>
      listVolumeBackupsCallable;
  private final UnaryCallable<ListVolumeBackupsRequest, ListVolumeBackupsPagedResponse>
      listVolumeBackupsPagedCallable;
  private final UnaryCallable<GetVolumeBackupRequest, VolumeBackup> getVolumeBackupCallable;
  private final UnaryCallable<CreateRestorePlanRequest, Operation> createRestorePlanCallable;
  private final OperationCallable<CreateRestorePlanRequest, RestorePlan, OperationMetadata>
      createRestorePlanOperationCallable;
  private final UnaryCallable<ListRestorePlansRequest, ListRestorePlansResponse>
      listRestorePlansCallable;
  private final UnaryCallable<ListRestorePlansRequest, ListRestorePlansPagedResponse>
      listRestorePlansPagedCallable;
  private final UnaryCallable<GetRestorePlanRequest, RestorePlan> getRestorePlanCallable;
  private final UnaryCallable<UpdateRestorePlanRequest, Operation> updateRestorePlanCallable;
  private final OperationCallable<UpdateRestorePlanRequest, RestorePlan, OperationMetadata>
      updateRestorePlanOperationCallable;
  private final UnaryCallable<DeleteRestorePlanRequest, Operation> deleteRestorePlanCallable;
  private final OperationCallable<DeleteRestorePlanRequest, Empty, OperationMetadata>
      deleteRestorePlanOperationCallable;
  private final UnaryCallable<CreateRestoreRequest, Operation> createRestoreCallable;
  private final OperationCallable<CreateRestoreRequest, Restore, OperationMetadata>
      createRestoreOperationCallable;
  private final UnaryCallable<ListRestoresRequest, ListRestoresResponse> listRestoresCallable;
  private final UnaryCallable<ListRestoresRequest, ListRestoresPagedResponse>
      listRestoresPagedCallable;
  private final UnaryCallable<GetRestoreRequest, Restore> getRestoreCallable;
  private final UnaryCallable<UpdateRestoreRequest, Operation> updateRestoreCallable;
  private final OperationCallable<UpdateRestoreRequest, Restore, OperationMetadata>
      updateRestoreOperationCallable;
  private final UnaryCallable<DeleteRestoreRequest, Operation> deleteRestoreCallable;
  private final OperationCallable<DeleteRestoreRequest, Empty, OperationMetadata>
      deleteRestoreOperationCallable;
  private final UnaryCallable<ListVolumeRestoresRequest, ListVolumeRestoresResponse>
      listVolumeRestoresCallable;
  private final UnaryCallable<ListVolumeRestoresRequest, ListVolumeRestoresPagedResponse>
      listVolumeRestoresPagedCallable;
  private final UnaryCallable<GetVolumeRestoreRequest, VolumeRestore> getVolumeRestoreCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcBackupForGKEStub create(BackupForGKEStubSettings settings)
      throws IOException {
    return new GrpcBackupForGKEStub(settings, ClientContext.create(settings));
  }

  public static final GrpcBackupForGKEStub create(ClientContext clientContext) throws IOException {
    return new GrpcBackupForGKEStub(BackupForGKEStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcBackupForGKEStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcBackupForGKEStub(
        BackupForGKEStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcBackupForGKEStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcBackupForGKEStub(BackupForGKEStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcBackupForGKECallableFactory());
  }

  /**
   * Constructs an instance of GrpcBackupForGKEStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcBackupForGKEStub(
      BackupForGKEStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateBackupPlanRequest, Operation> createBackupPlanTransportSettings =
        GrpcCallSettings.<CreateBackupPlanRequest, Operation>newBuilder()
            .setMethodDescriptor(createBackupPlanMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListBackupPlansRequest, ListBackupPlansResponse>
        listBackupPlansTransportSettings =
            GrpcCallSettings.<ListBackupPlansRequest, ListBackupPlansResponse>newBuilder()
                .setMethodDescriptor(listBackupPlansMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetBackupPlanRequest, BackupPlan> getBackupPlanTransportSettings =
        GrpcCallSettings.<GetBackupPlanRequest, BackupPlan>newBuilder()
            .setMethodDescriptor(getBackupPlanMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateBackupPlanRequest, Operation> updateBackupPlanTransportSettings =
        GrpcCallSettings.<UpdateBackupPlanRequest, Operation>newBuilder()
            .setMethodDescriptor(updateBackupPlanMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("backup_plan.name", String.valueOf(request.getBackupPlan().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteBackupPlanRequest, Operation> deleteBackupPlanTransportSettings =
        GrpcCallSettings.<DeleteBackupPlanRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteBackupPlanMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateBackupRequest, Operation> createBackupTransportSettings =
        GrpcCallSettings.<CreateBackupRequest, Operation>newBuilder()
            .setMethodDescriptor(createBackupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListBackupsRequest, ListBackupsResponse> listBackupsTransportSettings =
        GrpcCallSettings.<ListBackupsRequest, ListBackupsResponse>newBuilder()
            .setMethodDescriptor(listBackupsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetBackupRequest, Backup> getBackupTransportSettings =
        GrpcCallSettings.<GetBackupRequest, Backup>newBuilder()
            .setMethodDescriptor(getBackupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateBackupRequest, Operation> updateBackupTransportSettings =
        GrpcCallSettings.<UpdateBackupRequest, Operation>newBuilder()
            .setMethodDescriptor(updateBackupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("backup.name", String.valueOf(request.getBackup().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteBackupRequest, Operation> deleteBackupTransportSettings =
        GrpcCallSettings.<DeleteBackupRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteBackupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListVolumeBackupsRequest, ListVolumeBackupsResponse>
        listVolumeBackupsTransportSettings =
            GrpcCallSettings.<ListVolumeBackupsRequest, ListVolumeBackupsResponse>newBuilder()
                .setMethodDescriptor(listVolumeBackupsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetVolumeBackupRequest, VolumeBackup> getVolumeBackupTransportSettings =
        GrpcCallSettings.<GetVolumeBackupRequest, VolumeBackup>newBuilder()
            .setMethodDescriptor(getVolumeBackupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateRestorePlanRequest, Operation> createRestorePlanTransportSettings =
        GrpcCallSettings.<CreateRestorePlanRequest, Operation>newBuilder()
            .setMethodDescriptor(createRestorePlanMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListRestorePlansRequest, ListRestorePlansResponse>
        listRestorePlansTransportSettings =
            GrpcCallSettings.<ListRestorePlansRequest, ListRestorePlansResponse>newBuilder()
                .setMethodDescriptor(listRestorePlansMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetRestorePlanRequest, RestorePlan> getRestorePlanTransportSettings =
        GrpcCallSettings.<GetRestorePlanRequest, RestorePlan>newBuilder()
            .setMethodDescriptor(getRestorePlanMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateRestorePlanRequest, Operation> updateRestorePlanTransportSettings =
        GrpcCallSettings.<UpdateRestorePlanRequest, Operation>newBuilder()
            .setMethodDescriptor(updateRestorePlanMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put(
                      "restore_plan.name", String.valueOf(request.getRestorePlan().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteRestorePlanRequest, Operation> deleteRestorePlanTransportSettings =
        GrpcCallSettings.<DeleteRestorePlanRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteRestorePlanMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateRestoreRequest, Operation> createRestoreTransportSettings =
        GrpcCallSettings.<CreateRestoreRequest, Operation>newBuilder()
            .setMethodDescriptor(createRestoreMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListRestoresRequest, ListRestoresResponse> listRestoresTransportSettings =
        GrpcCallSettings.<ListRestoresRequest, ListRestoresResponse>newBuilder()
            .setMethodDescriptor(listRestoresMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetRestoreRequest, Restore> getRestoreTransportSettings =
        GrpcCallSettings.<GetRestoreRequest, Restore>newBuilder()
            .setMethodDescriptor(getRestoreMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateRestoreRequest, Operation> updateRestoreTransportSettings =
        GrpcCallSettings.<UpdateRestoreRequest, Operation>newBuilder()
            .setMethodDescriptor(updateRestoreMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("restore.name", String.valueOf(request.getRestore().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteRestoreRequest, Operation> deleteRestoreTransportSettings =
        GrpcCallSettings.<DeleteRestoreRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteRestoreMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListVolumeRestoresRequest, ListVolumeRestoresResponse>
        listVolumeRestoresTransportSettings =
            GrpcCallSettings.<ListVolumeRestoresRequest, ListVolumeRestoresResponse>newBuilder()
                .setMethodDescriptor(listVolumeRestoresMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetVolumeRestoreRequest, VolumeRestore> getVolumeRestoreTransportSettings =
        GrpcCallSettings.<GetVolumeRestoreRequest, VolumeRestore>newBuilder()
            .setMethodDescriptor(getVolumeRestoreMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();

    this.createBackupPlanCallable =
        callableFactory.createUnaryCallable(
            createBackupPlanTransportSettings, settings.createBackupPlanSettings(), clientContext);
    this.createBackupPlanOperationCallable =
        callableFactory.createOperationCallable(
            createBackupPlanTransportSettings,
            settings.createBackupPlanOperationSettings(),
            clientContext,
            operationsStub);
    this.listBackupPlansCallable =
        callableFactory.createUnaryCallable(
            listBackupPlansTransportSettings, settings.listBackupPlansSettings(), clientContext);
    this.listBackupPlansPagedCallable =
        callableFactory.createPagedCallable(
            listBackupPlansTransportSettings, settings.listBackupPlansSettings(), clientContext);
    this.getBackupPlanCallable =
        callableFactory.createUnaryCallable(
            getBackupPlanTransportSettings, settings.getBackupPlanSettings(), clientContext);
    this.updateBackupPlanCallable =
        callableFactory.createUnaryCallable(
            updateBackupPlanTransportSettings, settings.updateBackupPlanSettings(), clientContext);
    this.updateBackupPlanOperationCallable =
        callableFactory.createOperationCallable(
            updateBackupPlanTransportSettings,
            settings.updateBackupPlanOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteBackupPlanCallable =
        callableFactory.createUnaryCallable(
            deleteBackupPlanTransportSettings, settings.deleteBackupPlanSettings(), clientContext);
    this.deleteBackupPlanOperationCallable =
        callableFactory.createOperationCallable(
            deleteBackupPlanTransportSettings,
            settings.deleteBackupPlanOperationSettings(),
            clientContext,
            operationsStub);
    this.createBackupCallable =
        callableFactory.createUnaryCallable(
            createBackupTransportSettings, settings.createBackupSettings(), clientContext);
    this.createBackupOperationCallable =
        callableFactory.createOperationCallable(
            createBackupTransportSettings,
            settings.createBackupOperationSettings(),
            clientContext,
            operationsStub);
    this.listBackupsCallable =
        callableFactory.createUnaryCallable(
            listBackupsTransportSettings, settings.listBackupsSettings(), clientContext);
    this.listBackupsPagedCallable =
        callableFactory.createPagedCallable(
            listBackupsTransportSettings, settings.listBackupsSettings(), clientContext);
    this.getBackupCallable =
        callableFactory.createUnaryCallable(
            getBackupTransportSettings, settings.getBackupSettings(), clientContext);
    this.updateBackupCallable =
        callableFactory.createUnaryCallable(
            updateBackupTransportSettings, settings.updateBackupSettings(), clientContext);
    this.updateBackupOperationCallable =
        callableFactory.createOperationCallable(
            updateBackupTransportSettings,
            settings.updateBackupOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteBackupCallable =
        callableFactory.createUnaryCallable(
            deleteBackupTransportSettings, settings.deleteBackupSettings(), clientContext);
    this.deleteBackupOperationCallable =
        callableFactory.createOperationCallable(
            deleteBackupTransportSettings,
            settings.deleteBackupOperationSettings(),
            clientContext,
            operationsStub);
    this.listVolumeBackupsCallable =
        callableFactory.createUnaryCallable(
            listVolumeBackupsTransportSettings,
            settings.listVolumeBackupsSettings(),
            clientContext);
    this.listVolumeBackupsPagedCallable =
        callableFactory.createPagedCallable(
            listVolumeBackupsTransportSettings,
            settings.listVolumeBackupsSettings(),
            clientContext);
    this.getVolumeBackupCallable =
        callableFactory.createUnaryCallable(
            getVolumeBackupTransportSettings, settings.getVolumeBackupSettings(), clientContext);
    this.createRestorePlanCallable =
        callableFactory.createUnaryCallable(
            createRestorePlanTransportSettings,
            settings.createRestorePlanSettings(),
            clientContext);
    this.createRestorePlanOperationCallable =
        callableFactory.createOperationCallable(
            createRestorePlanTransportSettings,
            settings.createRestorePlanOperationSettings(),
            clientContext,
            operationsStub);
    this.listRestorePlansCallable =
        callableFactory.createUnaryCallable(
            listRestorePlansTransportSettings, settings.listRestorePlansSettings(), clientContext);
    this.listRestorePlansPagedCallable =
        callableFactory.createPagedCallable(
            listRestorePlansTransportSettings, settings.listRestorePlansSettings(), clientContext);
    this.getRestorePlanCallable =
        callableFactory.createUnaryCallable(
            getRestorePlanTransportSettings, settings.getRestorePlanSettings(), clientContext);
    this.updateRestorePlanCallable =
        callableFactory.createUnaryCallable(
            updateRestorePlanTransportSettings,
            settings.updateRestorePlanSettings(),
            clientContext);
    this.updateRestorePlanOperationCallable =
        callableFactory.createOperationCallable(
            updateRestorePlanTransportSettings,
            settings.updateRestorePlanOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteRestorePlanCallable =
        callableFactory.createUnaryCallable(
            deleteRestorePlanTransportSettings,
            settings.deleteRestorePlanSettings(),
            clientContext);
    this.deleteRestorePlanOperationCallable =
        callableFactory.createOperationCallable(
            deleteRestorePlanTransportSettings,
            settings.deleteRestorePlanOperationSettings(),
            clientContext,
            operationsStub);
    this.createRestoreCallable =
        callableFactory.createUnaryCallable(
            createRestoreTransportSettings, settings.createRestoreSettings(), clientContext);
    this.createRestoreOperationCallable =
        callableFactory.createOperationCallable(
            createRestoreTransportSettings,
            settings.createRestoreOperationSettings(),
            clientContext,
            operationsStub);
    this.listRestoresCallable =
        callableFactory.createUnaryCallable(
            listRestoresTransportSettings, settings.listRestoresSettings(), clientContext);
    this.listRestoresPagedCallable =
        callableFactory.createPagedCallable(
            listRestoresTransportSettings, settings.listRestoresSettings(), clientContext);
    this.getRestoreCallable =
        callableFactory.createUnaryCallable(
            getRestoreTransportSettings, settings.getRestoreSettings(), clientContext);
    this.updateRestoreCallable =
        callableFactory.createUnaryCallable(
            updateRestoreTransportSettings, settings.updateRestoreSettings(), clientContext);
    this.updateRestoreOperationCallable =
        callableFactory.createOperationCallable(
            updateRestoreTransportSettings,
            settings.updateRestoreOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteRestoreCallable =
        callableFactory.createUnaryCallable(
            deleteRestoreTransportSettings, settings.deleteRestoreSettings(), clientContext);
    this.deleteRestoreOperationCallable =
        callableFactory.createOperationCallable(
            deleteRestoreTransportSettings,
            settings.deleteRestoreOperationSettings(),
            clientContext,
            operationsStub);
    this.listVolumeRestoresCallable =
        callableFactory.createUnaryCallable(
            listVolumeRestoresTransportSettings,
            settings.listVolumeRestoresSettings(),
            clientContext);
    this.listVolumeRestoresPagedCallable =
        callableFactory.createPagedCallable(
            listVolumeRestoresTransportSettings,
            settings.listVolumeRestoresSettings(),
            clientContext);
    this.getVolumeRestoreCallable =
        callableFactory.createUnaryCallable(
            getVolumeRestoreTransportSettings, settings.getVolumeRestoreSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateBackupPlanRequest, Operation> createBackupPlanCallable() {
    return createBackupPlanCallable;
  }

  @Override
  public OperationCallable<CreateBackupPlanRequest, BackupPlan, OperationMetadata>
      createBackupPlanOperationCallable() {
    return createBackupPlanOperationCallable;
  }

  @Override
  public UnaryCallable<ListBackupPlansRequest, ListBackupPlansResponse> listBackupPlansCallable() {
    return listBackupPlansCallable;
  }

  @Override
  public UnaryCallable<ListBackupPlansRequest, ListBackupPlansPagedResponse>
      listBackupPlansPagedCallable() {
    return listBackupPlansPagedCallable;
  }

  @Override
  public UnaryCallable<GetBackupPlanRequest, BackupPlan> getBackupPlanCallable() {
    return getBackupPlanCallable;
  }

  @Override
  public UnaryCallable<UpdateBackupPlanRequest, Operation> updateBackupPlanCallable() {
    return updateBackupPlanCallable;
  }

  @Override
  public OperationCallable<UpdateBackupPlanRequest, BackupPlan, OperationMetadata>
      updateBackupPlanOperationCallable() {
    return updateBackupPlanOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteBackupPlanRequest, Operation> deleteBackupPlanCallable() {
    return deleteBackupPlanCallable;
  }

  @Override
  public OperationCallable<DeleteBackupPlanRequest, Empty, OperationMetadata>
      deleteBackupPlanOperationCallable() {
    return deleteBackupPlanOperationCallable;
  }

  @Override
  public UnaryCallable<CreateBackupRequest, Operation> createBackupCallable() {
    return createBackupCallable;
  }

  @Override
  public OperationCallable<CreateBackupRequest, Backup, OperationMetadata>
      createBackupOperationCallable() {
    return createBackupOperationCallable;
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
  public UnaryCallable<GetBackupRequest, Backup> getBackupCallable() {
    return getBackupCallable;
  }

  @Override
  public UnaryCallable<UpdateBackupRequest, Operation> updateBackupCallable() {
    return updateBackupCallable;
  }

  @Override
  public OperationCallable<UpdateBackupRequest, Backup, OperationMetadata>
      updateBackupOperationCallable() {
    return updateBackupOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteBackupRequest, Operation> deleteBackupCallable() {
    return deleteBackupCallable;
  }

  @Override
  public OperationCallable<DeleteBackupRequest, Empty, OperationMetadata>
      deleteBackupOperationCallable() {
    return deleteBackupOperationCallable;
  }

  @Override
  public UnaryCallable<ListVolumeBackupsRequest, ListVolumeBackupsResponse>
      listVolumeBackupsCallable() {
    return listVolumeBackupsCallable;
  }

  @Override
  public UnaryCallable<ListVolumeBackupsRequest, ListVolumeBackupsPagedResponse>
      listVolumeBackupsPagedCallable() {
    return listVolumeBackupsPagedCallable;
  }

  @Override
  public UnaryCallable<GetVolumeBackupRequest, VolumeBackup> getVolumeBackupCallable() {
    return getVolumeBackupCallable;
  }

  @Override
  public UnaryCallable<CreateRestorePlanRequest, Operation> createRestorePlanCallable() {
    return createRestorePlanCallable;
  }

  @Override
  public OperationCallable<CreateRestorePlanRequest, RestorePlan, OperationMetadata>
      createRestorePlanOperationCallable() {
    return createRestorePlanOperationCallable;
  }

  @Override
  public UnaryCallable<ListRestorePlansRequest, ListRestorePlansResponse>
      listRestorePlansCallable() {
    return listRestorePlansCallable;
  }

  @Override
  public UnaryCallable<ListRestorePlansRequest, ListRestorePlansPagedResponse>
      listRestorePlansPagedCallable() {
    return listRestorePlansPagedCallable;
  }

  @Override
  public UnaryCallable<GetRestorePlanRequest, RestorePlan> getRestorePlanCallable() {
    return getRestorePlanCallable;
  }

  @Override
  public UnaryCallable<UpdateRestorePlanRequest, Operation> updateRestorePlanCallable() {
    return updateRestorePlanCallable;
  }

  @Override
  public OperationCallable<UpdateRestorePlanRequest, RestorePlan, OperationMetadata>
      updateRestorePlanOperationCallable() {
    return updateRestorePlanOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteRestorePlanRequest, Operation> deleteRestorePlanCallable() {
    return deleteRestorePlanCallable;
  }

  @Override
  public OperationCallable<DeleteRestorePlanRequest, Empty, OperationMetadata>
      deleteRestorePlanOperationCallable() {
    return deleteRestorePlanOperationCallable;
  }

  @Override
  public UnaryCallable<CreateRestoreRequest, Operation> createRestoreCallable() {
    return createRestoreCallable;
  }

  @Override
  public OperationCallable<CreateRestoreRequest, Restore, OperationMetadata>
      createRestoreOperationCallable() {
    return createRestoreOperationCallable;
  }

  @Override
  public UnaryCallable<ListRestoresRequest, ListRestoresResponse> listRestoresCallable() {
    return listRestoresCallable;
  }

  @Override
  public UnaryCallable<ListRestoresRequest, ListRestoresPagedResponse> listRestoresPagedCallable() {
    return listRestoresPagedCallable;
  }

  @Override
  public UnaryCallable<GetRestoreRequest, Restore> getRestoreCallable() {
    return getRestoreCallable;
  }

  @Override
  public UnaryCallable<UpdateRestoreRequest, Operation> updateRestoreCallable() {
    return updateRestoreCallable;
  }

  @Override
  public OperationCallable<UpdateRestoreRequest, Restore, OperationMetadata>
      updateRestoreOperationCallable() {
    return updateRestoreOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteRestoreRequest, Operation> deleteRestoreCallable() {
    return deleteRestoreCallable;
  }

  @Override
  public OperationCallable<DeleteRestoreRequest, Empty, OperationMetadata>
      deleteRestoreOperationCallable() {
    return deleteRestoreOperationCallable;
  }

  @Override
  public UnaryCallable<ListVolumeRestoresRequest, ListVolumeRestoresResponse>
      listVolumeRestoresCallable() {
    return listVolumeRestoresCallable;
  }

  @Override
  public UnaryCallable<ListVolumeRestoresRequest, ListVolumeRestoresPagedResponse>
      listVolumeRestoresPagedCallable() {
    return listVolumeRestoresPagedCallable;
  }

  @Override
  public UnaryCallable<GetVolumeRestoreRequest, VolumeRestore> getVolumeRestoreCallable() {
    return getVolumeRestoreCallable;
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
