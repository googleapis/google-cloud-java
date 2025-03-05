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

package com.google.cloud.filestore.v1.stub;

import static com.google.cloud.filestore.v1.CloudFilestoreManagerClient.ListBackupsPagedResponse;
import static com.google.cloud.filestore.v1.CloudFilestoreManagerClient.ListInstancesPagedResponse;
import static com.google.cloud.filestore.v1.CloudFilestoreManagerClient.ListSnapshotsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.common.OperationMetadata;
import com.google.cloud.filestore.v1.Backup;
import com.google.cloud.filestore.v1.CreateBackupRequest;
import com.google.cloud.filestore.v1.CreateInstanceRequest;
import com.google.cloud.filestore.v1.CreateSnapshotRequest;
import com.google.cloud.filestore.v1.DeleteBackupRequest;
import com.google.cloud.filestore.v1.DeleteInstanceRequest;
import com.google.cloud.filestore.v1.DeleteSnapshotRequest;
import com.google.cloud.filestore.v1.GetBackupRequest;
import com.google.cloud.filestore.v1.GetInstanceRequest;
import com.google.cloud.filestore.v1.GetSnapshotRequest;
import com.google.cloud.filestore.v1.Instance;
import com.google.cloud.filestore.v1.ListBackupsRequest;
import com.google.cloud.filestore.v1.ListBackupsResponse;
import com.google.cloud.filestore.v1.ListInstancesRequest;
import com.google.cloud.filestore.v1.ListInstancesResponse;
import com.google.cloud.filestore.v1.ListSnapshotsRequest;
import com.google.cloud.filestore.v1.ListSnapshotsResponse;
import com.google.cloud.filestore.v1.PromoteReplicaRequest;
import com.google.cloud.filestore.v1.RestoreInstanceRequest;
import com.google.cloud.filestore.v1.RevertInstanceRequest;
import com.google.cloud.filestore.v1.Snapshot;
import com.google.cloud.filestore.v1.UpdateBackupRequest;
import com.google.cloud.filestore.v1.UpdateInstanceRequest;
import com.google.cloud.filestore.v1.UpdateSnapshotRequest;
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
 * gRPC stub implementation for the CloudFilestoreManager service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcCloudFilestoreManagerStub extends CloudFilestoreManagerStub {
  private static final MethodDescriptor<ListInstancesRequest, ListInstancesResponse>
      listInstancesMethodDescriptor =
          MethodDescriptor.<ListInstancesRequest, ListInstancesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.filestore.v1.CloudFilestoreManager/ListInstances")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListInstancesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListInstancesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetInstanceRequest, Instance> getInstanceMethodDescriptor =
      MethodDescriptor.<GetInstanceRequest, Instance>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.filestore.v1.CloudFilestoreManager/GetInstance")
          .setRequestMarshaller(ProtoUtils.marshaller(GetInstanceRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Instance.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateInstanceRequest, Operation>
      createInstanceMethodDescriptor =
          MethodDescriptor.<CreateInstanceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.filestore.v1.CloudFilestoreManager/CreateInstance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateInstanceRequest, Operation>
      updateInstanceMethodDescriptor =
          MethodDescriptor.<UpdateInstanceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.filestore.v1.CloudFilestoreManager/UpdateInstance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RestoreInstanceRequest, Operation>
      restoreInstanceMethodDescriptor =
          MethodDescriptor.<RestoreInstanceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.filestore.v1.CloudFilestoreManager/RestoreInstance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RestoreInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RevertInstanceRequest, Operation>
      revertInstanceMethodDescriptor =
          MethodDescriptor.<RevertInstanceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.filestore.v1.CloudFilestoreManager/RevertInstance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RevertInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteInstanceRequest, Operation>
      deleteInstanceMethodDescriptor =
          MethodDescriptor.<DeleteInstanceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.filestore.v1.CloudFilestoreManager/DeleteInstance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListSnapshotsRequest, ListSnapshotsResponse>
      listSnapshotsMethodDescriptor =
          MethodDescriptor.<ListSnapshotsRequest, ListSnapshotsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.filestore.v1.CloudFilestoreManager/ListSnapshots")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListSnapshotsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListSnapshotsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetSnapshotRequest, Snapshot> getSnapshotMethodDescriptor =
      MethodDescriptor.<GetSnapshotRequest, Snapshot>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.filestore.v1.CloudFilestoreManager/GetSnapshot")
          .setRequestMarshaller(ProtoUtils.marshaller(GetSnapshotRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Snapshot.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateSnapshotRequest, Operation>
      createSnapshotMethodDescriptor =
          MethodDescriptor.<CreateSnapshotRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.filestore.v1.CloudFilestoreManager/CreateSnapshot")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateSnapshotRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteSnapshotRequest, Operation>
      deleteSnapshotMethodDescriptor =
          MethodDescriptor.<DeleteSnapshotRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.filestore.v1.CloudFilestoreManager/DeleteSnapshot")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteSnapshotRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateSnapshotRequest, Operation>
      updateSnapshotMethodDescriptor =
          MethodDescriptor.<UpdateSnapshotRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.filestore.v1.CloudFilestoreManager/UpdateSnapshot")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateSnapshotRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListBackupsRequest, ListBackupsResponse>
      listBackupsMethodDescriptor =
          MethodDescriptor.<ListBackupsRequest, ListBackupsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.filestore.v1.CloudFilestoreManager/ListBackups")
              .setRequestMarshaller(ProtoUtils.marshaller(ListBackupsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListBackupsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetBackupRequest, Backup> getBackupMethodDescriptor =
      MethodDescriptor.<GetBackupRequest, Backup>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.filestore.v1.CloudFilestoreManager/GetBackup")
          .setRequestMarshaller(ProtoUtils.marshaller(GetBackupRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Backup.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateBackupRequest, Operation>
      createBackupMethodDescriptor =
          MethodDescriptor.<CreateBackupRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.filestore.v1.CloudFilestoreManager/CreateBackup")
              .setRequestMarshaller(ProtoUtils.marshaller(CreateBackupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteBackupRequest, Operation>
      deleteBackupMethodDescriptor =
          MethodDescriptor.<DeleteBackupRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.filestore.v1.CloudFilestoreManager/DeleteBackup")
              .setRequestMarshaller(ProtoUtils.marshaller(DeleteBackupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateBackupRequest, Operation>
      updateBackupMethodDescriptor =
          MethodDescriptor.<UpdateBackupRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.filestore.v1.CloudFilestoreManager/UpdateBackup")
              .setRequestMarshaller(ProtoUtils.marshaller(UpdateBackupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<PromoteReplicaRequest, Operation>
      promoteReplicaMethodDescriptor =
          MethodDescriptor.<PromoteReplicaRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.filestore.v1.CloudFilestoreManager/PromoteReplica")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(PromoteReplicaRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable;
  private final UnaryCallable<ListInstancesRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable;
  private final UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable;
  private final UnaryCallable<CreateInstanceRequest, Operation> createInstanceCallable;
  private final OperationCallable<CreateInstanceRequest, Instance, OperationMetadata>
      createInstanceOperationCallable;
  private final UnaryCallable<UpdateInstanceRequest, Operation> updateInstanceCallable;
  private final OperationCallable<UpdateInstanceRequest, Instance, OperationMetadata>
      updateInstanceOperationCallable;
  private final UnaryCallable<RestoreInstanceRequest, Operation> restoreInstanceCallable;
  private final OperationCallable<RestoreInstanceRequest, Instance, OperationMetadata>
      restoreInstanceOperationCallable;
  private final UnaryCallable<RevertInstanceRequest, Operation> revertInstanceCallable;
  private final OperationCallable<RevertInstanceRequest, Instance, OperationMetadata>
      revertInstanceOperationCallable;
  private final UnaryCallable<DeleteInstanceRequest, Operation> deleteInstanceCallable;
  private final OperationCallable<DeleteInstanceRequest, Empty, OperationMetadata>
      deleteInstanceOperationCallable;
  private final UnaryCallable<ListSnapshotsRequest, ListSnapshotsResponse> listSnapshotsCallable;
  private final UnaryCallable<ListSnapshotsRequest, ListSnapshotsPagedResponse>
      listSnapshotsPagedCallable;
  private final UnaryCallable<GetSnapshotRequest, Snapshot> getSnapshotCallable;
  private final UnaryCallable<CreateSnapshotRequest, Operation> createSnapshotCallable;
  private final OperationCallable<CreateSnapshotRequest, Snapshot, OperationMetadata>
      createSnapshotOperationCallable;
  private final UnaryCallable<DeleteSnapshotRequest, Operation> deleteSnapshotCallable;
  private final OperationCallable<DeleteSnapshotRequest, Empty, OperationMetadata>
      deleteSnapshotOperationCallable;
  private final UnaryCallable<UpdateSnapshotRequest, Operation> updateSnapshotCallable;
  private final OperationCallable<UpdateSnapshotRequest, Snapshot, OperationMetadata>
      updateSnapshotOperationCallable;
  private final UnaryCallable<ListBackupsRequest, ListBackupsResponse> listBackupsCallable;
  private final UnaryCallable<ListBackupsRequest, ListBackupsPagedResponse>
      listBackupsPagedCallable;
  private final UnaryCallable<GetBackupRequest, Backup> getBackupCallable;
  private final UnaryCallable<CreateBackupRequest, Operation> createBackupCallable;
  private final OperationCallable<CreateBackupRequest, Backup, OperationMetadata>
      createBackupOperationCallable;
  private final UnaryCallable<DeleteBackupRequest, Operation> deleteBackupCallable;
  private final OperationCallable<DeleteBackupRequest, Empty, OperationMetadata>
      deleteBackupOperationCallable;
  private final UnaryCallable<UpdateBackupRequest, Operation> updateBackupCallable;
  private final OperationCallable<UpdateBackupRequest, Backup, OperationMetadata>
      updateBackupOperationCallable;
  private final UnaryCallable<PromoteReplicaRequest, Operation> promoteReplicaCallable;
  private final OperationCallable<PromoteReplicaRequest, Instance, OperationMetadata>
      promoteReplicaOperationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcCloudFilestoreManagerStub create(
      CloudFilestoreManagerStubSettings settings) throws IOException {
    return new GrpcCloudFilestoreManagerStub(settings, ClientContext.create(settings));
  }

  public static final GrpcCloudFilestoreManagerStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcCloudFilestoreManagerStub(
        CloudFilestoreManagerStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcCloudFilestoreManagerStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcCloudFilestoreManagerStub(
        CloudFilestoreManagerStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcCloudFilestoreManagerStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcCloudFilestoreManagerStub(
      CloudFilestoreManagerStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcCloudFilestoreManagerCallableFactory());
  }

  /**
   * Constructs an instance of GrpcCloudFilestoreManagerStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcCloudFilestoreManagerStub(
      CloudFilestoreManagerStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListInstancesRequest, ListInstancesResponse> listInstancesTransportSettings =
        GrpcCallSettings.<ListInstancesRequest, ListInstancesResponse>newBuilder()
            .setMethodDescriptor(listInstancesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetInstanceRequest, Instance> getInstanceTransportSettings =
        GrpcCallSettings.<GetInstanceRequest, Instance>newBuilder()
            .setMethodDescriptor(getInstanceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateInstanceRequest, Operation> createInstanceTransportSettings =
        GrpcCallSettings.<CreateInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(createInstanceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateInstanceRequest, Operation> updateInstanceTransportSettings =
        GrpcCallSettings.<UpdateInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(updateInstanceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("instance.name", String.valueOf(request.getInstance().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<RestoreInstanceRequest, Operation> restoreInstanceTransportSettings =
        GrpcCallSettings.<RestoreInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(restoreInstanceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<RevertInstanceRequest, Operation> revertInstanceTransportSettings =
        GrpcCallSettings.<RevertInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(revertInstanceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteInstanceRequest, Operation> deleteInstanceTransportSettings =
        GrpcCallSettings.<DeleteInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteInstanceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListSnapshotsRequest, ListSnapshotsResponse> listSnapshotsTransportSettings =
        GrpcCallSettings.<ListSnapshotsRequest, ListSnapshotsResponse>newBuilder()
            .setMethodDescriptor(listSnapshotsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetSnapshotRequest, Snapshot> getSnapshotTransportSettings =
        GrpcCallSettings.<GetSnapshotRequest, Snapshot>newBuilder()
            .setMethodDescriptor(getSnapshotMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateSnapshotRequest, Operation> createSnapshotTransportSettings =
        GrpcCallSettings.<CreateSnapshotRequest, Operation>newBuilder()
            .setMethodDescriptor(createSnapshotMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteSnapshotRequest, Operation> deleteSnapshotTransportSettings =
        GrpcCallSettings.<DeleteSnapshotRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteSnapshotMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateSnapshotRequest, Operation> updateSnapshotTransportSettings =
        GrpcCallSettings.<UpdateSnapshotRequest, Operation>newBuilder()
            .setMethodDescriptor(updateSnapshotMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("snapshot.name", String.valueOf(request.getSnapshot().getName()));
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
    GrpcCallSettings<CreateBackupRequest, Operation> createBackupTransportSettings =
        GrpcCallSettings.<CreateBackupRequest, Operation>newBuilder()
            .setMethodDescriptor(createBackupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteBackupRequest, Operation> deleteBackupTransportSettings =
        GrpcCallSettings.<DeleteBackupRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteBackupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateBackupRequest, Operation> updateBackupTransportSettings =
        GrpcCallSettings.<UpdateBackupRequest, Operation>newBuilder()
            .setMethodDescriptor(updateBackupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("backup.name", String.valueOf(request.getBackup().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<PromoteReplicaRequest, Operation> promoteReplicaTransportSettings =
        GrpcCallSettings.<PromoteReplicaRequest, Operation>newBuilder()
            .setMethodDescriptor(promoteReplicaMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.listInstancesCallable =
        callableFactory.createUnaryCallable(
            listInstancesTransportSettings, settings.listInstancesSettings(), clientContext);
    this.listInstancesPagedCallable =
        callableFactory.createPagedCallable(
            listInstancesTransportSettings, settings.listInstancesSettings(), clientContext);
    this.getInstanceCallable =
        callableFactory.createUnaryCallable(
            getInstanceTransportSettings, settings.getInstanceSettings(), clientContext);
    this.createInstanceCallable =
        callableFactory.createUnaryCallable(
            createInstanceTransportSettings, settings.createInstanceSettings(), clientContext);
    this.createInstanceOperationCallable =
        callableFactory.createOperationCallable(
            createInstanceTransportSettings,
            settings.createInstanceOperationSettings(),
            clientContext,
            operationsStub);
    this.updateInstanceCallable =
        callableFactory.createUnaryCallable(
            updateInstanceTransportSettings, settings.updateInstanceSettings(), clientContext);
    this.updateInstanceOperationCallable =
        callableFactory.createOperationCallable(
            updateInstanceTransportSettings,
            settings.updateInstanceOperationSettings(),
            clientContext,
            operationsStub);
    this.restoreInstanceCallable =
        callableFactory.createUnaryCallable(
            restoreInstanceTransportSettings, settings.restoreInstanceSettings(), clientContext);
    this.restoreInstanceOperationCallable =
        callableFactory.createOperationCallable(
            restoreInstanceTransportSettings,
            settings.restoreInstanceOperationSettings(),
            clientContext,
            operationsStub);
    this.revertInstanceCallable =
        callableFactory.createUnaryCallable(
            revertInstanceTransportSettings, settings.revertInstanceSettings(), clientContext);
    this.revertInstanceOperationCallable =
        callableFactory.createOperationCallable(
            revertInstanceTransportSettings,
            settings.revertInstanceOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteInstanceCallable =
        callableFactory.createUnaryCallable(
            deleteInstanceTransportSettings, settings.deleteInstanceSettings(), clientContext);
    this.deleteInstanceOperationCallable =
        callableFactory.createOperationCallable(
            deleteInstanceTransportSettings,
            settings.deleteInstanceOperationSettings(),
            clientContext,
            operationsStub);
    this.listSnapshotsCallable =
        callableFactory.createUnaryCallable(
            listSnapshotsTransportSettings, settings.listSnapshotsSettings(), clientContext);
    this.listSnapshotsPagedCallable =
        callableFactory.createPagedCallable(
            listSnapshotsTransportSettings, settings.listSnapshotsSettings(), clientContext);
    this.getSnapshotCallable =
        callableFactory.createUnaryCallable(
            getSnapshotTransportSettings, settings.getSnapshotSettings(), clientContext);
    this.createSnapshotCallable =
        callableFactory.createUnaryCallable(
            createSnapshotTransportSettings, settings.createSnapshotSettings(), clientContext);
    this.createSnapshotOperationCallable =
        callableFactory.createOperationCallable(
            createSnapshotTransportSettings,
            settings.createSnapshotOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteSnapshotCallable =
        callableFactory.createUnaryCallable(
            deleteSnapshotTransportSettings, settings.deleteSnapshotSettings(), clientContext);
    this.deleteSnapshotOperationCallable =
        callableFactory.createOperationCallable(
            deleteSnapshotTransportSettings,
            settings.deleteSnapshotOperationSettings(),
            clientContext,
            operationsStub);
    this.updateSnapshotCallable =
        callableFactory.createUnaryCallable(
            updateSnapshotTransportSettings, settings.updateSnapshotSettings(), clientContext);
    this.updateSnapshotOperationCallable =
        callableFactory.createOperationCallable(
            updateSnapshotTransportSettings,
            settings.updateSnapshotOperationSettings(),
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
    this.createBackupCallable =
        callableFactory.createUnaryCallable(
            createBackupTransportSettings, settings.createBackupSettings(), clientContext);
    this.createBackupOperationCallable =
        callableFactory.createOperationCallable(
            createBackupTransportSettings,
            settings.createBackupOperationSettings(),
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
    this.updateBackupCallable =
        callableFactory.createUnaryCallable(
            updateBackupTransportSettings, settings.updateBackupSettings(), clientContext);
    this.updateBackupOperationCallable =
        callableFactory.createOperationCallable(
            updateBackupTransportSettings,
            settings.updateBackupOperationSettings(),
            clientContext,
            operationsStub);
    this.promoteReplicaCallable =
        callableFactory.createUnaryCallable(
            promoteReplicaTransportSettings, settings.promoteReplicaSettings(), clientContext);
    this.promoteReplicaOperationCallable =
        callableFactory.createOperationCallable(
            promoteReplicaTransportSettings,
            settings.promoteReplicaOperationSettings(),
            clientContext,
            operationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable() {
    return listInstancesCallable;
  }

  @Override
  public UnaryCallable<ListInstancesRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable() {
    return listInstancesPagedCallable;
  }

  @Override
  public UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable() {
    return getInstanceCallable;
  }

  @Override
  public UnaryCallable<CreateInstanceRequest, Operation> createInstanceCallable() {
    return createInstanceCallable;
  }

  @Override
  public OperationCallable<CreateInstanceRequest, Instance, OperationMetadata>
      createInstanceOperationCallable() {
    return createInstanceOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateInstanceRequest, Operation> updateInstanceCallable() {
    return updateInstanceCallable;
  }

  @Override
  public OperationCallable<UpdateInstanceRequest, Instance, OperationMetadata>
      updateInstanceOperationCallable() {
    return updateInstanceOperationCallable;
  }

  @Override
  public UnaryCallable<RestoreInstanceRequest, Operation> restoreInstanceCallable() {
    return restoreInstanceCallable;
  }

  @Override
  public OperationCallable<RestoreInstanceRequest, Instance, OperationMetadata>
      restoreInstanceOperationCallable() {
    return restoreInstanceOperationCallable;
  }

  @Override
  public UnaryCallable<RevertInstanceRequest, Operation> revertInstanceCallable() {
    return revertInstanceCallable;
  }

  @Override
  public OperationCallable<RevertInstanceRequest, Instance, OperationMetadata>
      revertInstanceOperationCallable() {
    return revertInstanceOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteInstanceRequest, Operation> deleteInstanceCallable() {
    return deleteInstanceCallable;
  }

  @Override
  public OperationCallable<DeleteInstanceRequest, Empty, OperationMetadata>
      deleteInstanceOperationCallable() {
    return deleteInstanceOperationCallable;
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
  public UnaryCallable<GetSnapshotRequest, Snapshot> getSnapshotCallable() {
    return getSnapshotCallable;
  }

  @Override
  public UnaryCallable<CreateSnapshotRequest, Operation> createSnapshotCallable() {
    return createSnapshotCallable;
  }

  @Override
  public OperationCallable<CreateSnapshotRequest, Snapshot, OperationMetadata>
      createSnapshotOperationCallable() {
    return createSnapshotOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteSnapshotRequest, Operation> deleteSnapshotCallable() {
    return deleteSnapshotCallable;
  }

  @Override
  public OperationCallable<DeleteSnapshotRequest, Empty, OperationMetadata>
      deleteSnapshotOperationCallable() {
    return deleteSnapshotOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateSnapshotRequest, Operation> updateSnapshotCallable() {
    return updateSnapshotCallable;
  }

  @Override
  public OperationCallable<UpdateSnapshotRequest, Snapshot, OperationMetadata>
      updateSnapshotOperationCallable() {
    return updateSnapshotOperationCallable;
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
  public UnaryCallable<CreateBackupRequest, Operation> createBackupCallable() {
    return createBackupCallable;
  }

  @Override
  public OperationCallable<CreateBackupRequest, Backup, OperationMetadata>
      createBackupOperationCallable() {
    return createBackupOperationCallable;
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
  public UnaryCallable<UpdateBackupRequest, Operation> updateBackupCallable() {
    return updateBackupCallable;
  }

  @Override
  public OperationCallable<UpdateBackupRequest, Backup, OperationMetadata>
      updateBackupOperationCallable() {
    return updateBackupOperationCallable;
  }

  @Override
  public UnaryCallable<PromoteReplicaRequest, Operation> promoteReplicaCallable() {
    return promoteReplicaCallable;
  }

  @Override
  public OperationCallable<PromoteReplicaRequest, Instance, OperationMetadata>
      promoteReplicaOperationCallable() {
    return promoteReplicaOperationCallable;
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
