/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.netapp.v1.stub;

import static com.google.cloud.netapp.v1.NetAppClient.ListActiveDirectoriesPagedResponse;
import static com.google.cloud.netapp.v1.NetAppClient.ListKmsConfigsPagedResponse;
import static com.google.cloud.netapp.v1.NetAppClient.ListLocationsPagedResponse;
import static com.google.cloud.netapp.v1.NetAppClient.ListReplicationsPagedResponse;
import static com.google.cloud.netapp.v1.NetAppClient.ListSnapshotsPagedResponse;
import static com.google.cloud.netapp.v1.NetAppClient.ListStoragePoolsPagedResponse;
import static com.google.cloud.netapp.v1.NetAppClient.ListVolumesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.netapp.v1.ActiveDirectory;
import com.google.cloud.netapp.v1.CreateActiveDirectoryRequest;
import com.google.cloud.netapp.v1.CreateKmsConfigRequest;
import com.google.cloud.netapp.v1.CreateReplicationRequest;
import com.google.cloud.netapp.v1.CreateSnapshotRequest;
import com.google.cloud.netapp.v1.CreateStoragePoolRequest;
import com.google.cloud.netapp.v1.CreateVolumeRequest;
import com.google.cloud.netapp.v1.DeleteActiveDirectoryRequest;
import com.google.cloud.netapp.v1.DeleteKmsConfigRequest;
import com.google.cloud.netapp.v1.DeleteReplicationRequest;
import com.google.cloud.netapp.v1.DeleteSnapshotRequest;
import com.google.cloud.netapp.v1.DeleteStoragePoolRequest;
import com.google.cloud.netapp.v1.DeleteVolumeRequest;
import com.google.cloud.netapp.v1.EncryptVolumesRequest;
import com.google.cloud.netapp.v1.GetActiveDirectoryRequest;
import com.google.cloud.netapp.v1.GetKmsConfigRequest;
import com.google.cloud.netapp.v1.GetReplicationRequest;
import com.google.cloud.netapp.v1.GetSnapshotRequest;
import com.google.cloud.netapp.v1.GetStoragePoolRequest;
import com.google.cloud.netapp.v1.GetVolumeRequest;
import com.google.cloud.netapp.v1.KmsConfig;
import com.google.cloud.netapp.v1.ListActiveDirectoriesRequest;
import com.google.cloud.netapp.v1.ListActiveDirectoriesResponse;
import com.google.cloud.netapp.v1.ListKmsConfigsRequest;
import com.google.cloud.netapp.v1.ListKmsConfigsResponse;
import com.google.cloud.netapp.v1.ListReplicationsRequest;
import com.google.cloud.netapp.v1.ListReplicationsResponse;
import com.google.cloud.netapp.v1.ListSnapshotsRequest;
import com.google.cloud.netapp.v1.ListSnapshotsResponse;
import com.google.cloud.netapp.v1.ListStoragePoolsRequest;
import com.google.cloud.netapp.v1.ListStoragePoolsResponse;
import com.google.cloud.netapp.v1.ListVolumesRequest;
import com.google.cloud.netapp.v1.ListVolumesResponse;
import com.google.cloud.netapp.v1.OperationMetadata;
import com.google.cloud.netapp.v1.Replication;
import com.google.cloud.netapp.v1.ResumeReplicationRequest;
import com.google.cloud.netapp.v1.ReverseReplicationDirectionRequest;
import com.google.cloud.netapp.v1.RevertVolumeRequest;
import com.google.cloud.netapp.v1.Snapshot;
import com.google.cloud.netapp.v1.StopReplicationRequest;
import com.google.cloud.netapp.v1.StoragePool;
import com.google.cloud.netapp.v1.UpdateActiveDirectoryRequest;
import com.google.cloud.netapp.v1.UpdateKmsConfigRequest;
import com.google.cloud.netapp.v1.UpdateReplicationRequest;
import com.google.cloud.netapp.v1.UpdateSnapshotRequest;
import com.google.cloud.netapp.v1.UpdateStoragePoolRequest;
import com.google.cloud.netapp.v1.UpdateVolumeRequest;
import com.google.cloud.netapp.v1.VerifyKmsConfigRequest;
import com.google.cloud.netapp.v1.VerifyKmsConfigResponse;
import com.google.cloud.netapp.v1.Volume;
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
/**
 * gRPC stub implementation for the NetApp service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcNetAppStub extends NetAppStub {
  private static final MethodDescriptor<ListStoragePoolsRequest, ListStoragePoolsResponse>
      listStoragePoolsMethodDescriptor =
          MethodDescriptor.<ListStoragePoolsRequest, ListStoragePoolsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.netapp.v1.NetApp/ListStoragePools")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListStoragePoolsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListStoragePoolsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateStoragePoolRequest, Operation>
      createStoragePoolMethodDescriptor =
          MethodDescriptor.<CreateStoragePoolRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.netapp.v1.NetApp/CreateStoragePool")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateStoragePoolRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetStoragePoolRequest, StoragePool>
      getStoragePoolMethodDescriptor =
          MethodDescriptor.<GetStoragePoolRequest, StoragePool>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.netapp.v1.NetApp/GetStoragePool")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetStoragePoolRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(StoragePool.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateStoragePoolRequest, Operation>
      updateStoragePoolMethodDescriptor =
          MethodDescriptor.<UpdateStoragePoolRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.netapp.v1.NetApp/UpdateStoragePool")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateStoragePoolRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteStoragePoolRequest, Operation>
      deleteStoragePoolMethodDescriptor =
          MethodDescriptor.<DeleteStoragePoolRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.netapp.v1.NetApp/DeleteStoragePool")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteStoragePoolRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListVolumesRequest, ListVolumesResponse>
      listVolumesMethodDescriptor =
          MethodDescriptor.<ListVolumesRequest, ListVolumesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.netapp.v1.NetApp/ListVolumes")
              .setRequestMarshaller(ProtoUtils.marshaller(ListVolumesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListVolumesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetVolumeRequest, Volume> getVolumeMethodDescriptor =
      MethodDescriptor.<GetVolumeRequest, Volume>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.netapp.v1.NetApp/GetVolume")
          .setRequestMarshaller(ProtoUtils.marshaller(GetVolumeRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Volume.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateVolumeRequest, Operation>
      createVolumeMethodDescriptor =
          MethodDescriptor.<CreateVolumeRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.netapp.v1.NetApp/CreateVolume")
              .setRequestMarshaller(ProtoUtils.marshaller(CreateVolumeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateVolumeRequest, Operation>
      updateVolumeMethodDescriptor =
          MethodDescriptor.<UpdateVolumeRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.netapp.v1.NetApp/UpdateVolume")
              .setRequestMarshaller(ProtoUtils.marshaller(UpdateVolumeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteVolumeRequest, Operation>
      deleteVolumeMethodDescriptor =
          MethodDescriptor.<DeleteVolumeRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.netapp.v1.NetApp/DeleteVolume")
              .setRequestMarshaller(ProtoUtils.marshaller(DeleteVolumeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RevertVolumeRequest, Operation>
      revertVolumeMethodDescriptor =
          MethodDescriptor.<RevertVolumeRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.netapp.v1.NetApp/RevertVolume")
              .setRequestMarshaller(ProtoUtils.marshaller(RevertVolumeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListSnapshotsRequest, ListSnapshotsResponse>
      listSnapshotsMethodDescriptor =
          MethodDescriptor.<ListSnapshotsRequest, ListSnapshotsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.netapp.v1.NetApp/ListSnapshots")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListSnapshotsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListSnapshotsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetSnapshotRequest, Snapshot> getSnapshotMethodDescriptor =
      MethodDescriptor.<GetSnapshotRequest, Snapshot>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.netapp.v1.NetApp/GetSnapshot")
          .setRequestMarshaller(ProtoUtils.marshaller(GetSnapshotRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Snapshot.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateSnapshotRequest, Operation>
      createSnapshotMethodDescriptor =
          MethodDescriptor.<CreateSnapshotRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.netapp.v1.NetApp/CreateSnapshot")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateSnapshotRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteSnapshotRequest, Operation>
      deleteSnapshotMethodDescriptor =
          MethodDescriptor.<DeleteSnapshotRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.netapp.v1.NetApp/DeleteSnapshot")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteSnapshotRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateSnapshotRequest, Operation>
      updateSnapshotMethodDescriptor =
          MethodDescriptor.<UpdateSnapshotRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.netapp.v1.NetApp/UpdateSnapshot")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateSnapshotRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListActiveDirectoriesRequest, ListActiveDirectoriesResponse>
      listActiveDirectoriesMethodDescriptor =
          MethodDescriptor.<ListActiveDirectoriesRequest, ListActiveDirectoriesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.netapp.v1.NetApp/ListActiveDirectories")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListActiveDirectoriesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListActiveDirectoriesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetActiveDirectoryRequest, ActiveDirectory>
      getActiveDirectoryMethodDescriptor =
          MethodDescriptor.<GetActiveDirectoryRequest, ActiveDirectory>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.netapp.v1.NetApp/GetActiveDirectory")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetActiveDirectoryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ActiveDirectory.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateActiveDirectoryRequest, Operation>
      createActiveDirectoryMethodDescriptor =
          MethodDescriptor.<CreateActiveDirectoryRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.netapp.v1.NetApp/CreateActiveDirectory")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateActiveDirectoryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateActiveDirectoryRequest, Operation>
      updateActiveDirectoryMethodDescriptor =
          MethodDescriptor.<UpdateActiveDirectoryRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.netapp.v1.NetApp/UpdateActiveDirectory")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateActiveDirectoryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteActiveDirectoryRequest, Operation>
      deleteActiveDirectoryMethodDescriptor =
          MethodDescriptor.<DeleteActiveDirectoryRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.netapp.v1.NetApp/DeleteActiveDirectory")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteActiveDirectoryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListKmsConfigsRequest, ListKmsConfigsResponse>
      listKmsConfigsMethodDescriptor =
          MethodDescriptor.<ListKmsConfigsRequest, ListKmsConfigsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.netapp.v1.NetApp/ListKmsConfigs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListKmsConfigsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListKmsConfigsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateKmsConfigRequest, Operation>
      createKmsConfigMethodDescriptor =
          MethodDescriptor.<CreateKmsConfigRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.netapp.v1.NetApp/CreateKmsConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateKmsConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetKmsConfigRequest, KmsConfig>
      getKmsConfigMethodDescriptor =
          MethodDescriptor.<GetKmsConfigRequest, KmsConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.netapp.v1.NetApp/GetKmsConfig")
              .setRequestMarshaller(ProtoUtils.marshaller(GetKmsConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(KmsConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateKmsConfigRequest, Operation>
      updateKmsConfigMethodDescriptor =
          MethodDescriptor.<UpdateKmsConfigRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.netapp.v1.NetApp/UpdateKmsConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateKmsConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<EncryptVolumesRequest, Operation>
      encryptVolumesMethodDescriptor =
          MethodDescriptor.<EncryptVolumesRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.netapp.v1.NetApp/EncryptVolumes")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(EncryptVolumesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<VerifyKmsConfigRequest, VerifyKmsConfigResponse>
      verifyKmsConfigMethodDescriptor =
          MethodDescriptor.<VerifyKmsConfigRequest, VerifyKmsConfigResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.netapp.v1.NetApp/VerifyKmsConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(VerifyKmsConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(VerifyKmsConfigResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteKmsConfigRequest, Operation>
      deleteKmsConfigMethodDescriptor =
          MethodDescriptor.<DeleteKmsConfigRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.netapp.v1.NetApp/DeleteKmsConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteKmsConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListReplicationsRequest, ListReplicationsResponse>
      listReplicationsMethodDescriptor =
          MethodDescriptor.<ListReplicationsRequest, ListReplicationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.netapp.v1.NetApp/ListReplications")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListReplicationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListReplicationsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetReplicationRequest, Replication>
      getReplicationMethodDescriptor =
          MethodDescriptor.<GetReplicationRequest, Replication>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.netapp.v1.NetApp/GetReplication")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetReplicationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Replication.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateReplicationRequest, Operation>
      createReplicationMethodDescriptor =
          MethodDescriptor.<CreateReplicationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.netapp.v1.NetApp/CreateReplication")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateReplicationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteReplicationRequest, Operation>
      deleteReplicationMethodDescriptor =
          MethodDescriptor.<DeleteReplicationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.netapp.v1.NetApp/DeleteReplication")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteReplicationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateReplicationRequest, Operation>
      updateReplicationMethodDescriptor =
          MethodDescriptor.<UpdateReplicationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.netapp.v1.NetApp/UpdateReplication")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateReplicationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<StopReplicationRequest, Operation>
      stopReplicationMethodDescriptor =
          MethodDescriptor.<StopReplicationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.netapp.v1.NetApp/StopReplication")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(StopReplicationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ResumeReplicationRequest, Operation>
      resumeReplicationMethodDescriptor =
          MethodDescriptor.<ResumeReplicationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.netapp.v1.NetApp/ResumeReplication")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ResumeReplicationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ReverseReplicationDirectionRequest, Operation>
      reverseReplicationDirectionMethodDescriptor =
          MethodDescriptor.<ReverseReplicationDirectionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.netapp.v1.NetApp/ReverseReplicationDirection")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ReverseReplicationDirectionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          MethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListLocationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListLocationsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetLocationRequest, Location> getLocationMethodDescriptor =
      MethodDescriptor.<GetLocationRequest, Location>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.location.Locations/GetLocation")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLocationRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Location.getDefaultInstance()))
          .build();

  private final UnaryCallable<ListStoragePoolsRequest, ListStoragePoolsResponse>
      listStoragePoolsCallable;
  private final UnaryCallable<ListStoragePoolsRequest, ListStoragePoolsPagedResponse>
      listStoragePoolsPagedCallable;
  private final UnaryCallable<CreateStoragePoolRequest, Operation> createStoragePoolCallable;
  private final OperationCallable<CreateStoragePoolRequest, StoragePool, OperationMetadata>
      createStoragePoolOperationCallable;
  private final UnaryCallable<GetStoragePoolRequest, StoragePool> getStoragePoolCallable;
  private final UnaryCallable<UpdateStoragePoolRequest, Operation> updateStoragePoolCallable;
  private final OperationCallable<UpdateStoragePoolRequest, StoragePool, OperationMetadata>
      updateStoragePoolOperationCallable;
  private final UnaryCallable<DeleteStoragePoolRequest, Operation> deleteStoragePoolCallable;
  private final OperationCallable<DeleteStoragePoolRequest, Empty, OperationMetadata>
      deleteStoragePoolOperationCallable;
  private final UnaryCallable<ListVolumesRequest, ListVolumesResponse> listVolumesCallable;
  private final UnaryCallable<ListVolumesRequest, ListVolumesPagedResponse>
      listVolumesPagedCallable;
  private final UnaryCallable<GetVolumeRequest, Volume> getVolumeCallable;
  private final UnaryCallable<CreateVolumeRequest, Operation> createVolumeCallable;
  private final OperationCallable<CreateVolumeRequest, Volume, OperationMetadata>
      createVolumeOperationCallable;
  private final UnaryCallable<UpdateVolumeRequest, Operation> updateVolumeCallable;
  private final OperationCallable<UpdateVolumeRequest, Volume, OperationMetadata>
      updateVolumeOperationCallable;
  private final UnaryCallable<DeleteVolumeRequest, Operation> deleteVolumeCallable;
  private final OperationCallable<DeleteVolumeRequest, Empty, OperationMetadata>
      deleteVolumeOperationCallable;
  private final UnaryCallable<RevertVolumeRequest, Operation> revertVolumeCallable;
  private final OperationCallable<RevertVolumeRequest, Volume, OperationMetadata>
      revertVolumeOperationCallable;
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
  private final UnaryCallable<ListActiveDirectoriesRequest, ListActiveDirectoriesResponse>
      listActiveDirectoriesCallable;
  private final UnaryCallable<ListActiveDirectoriesRequest, ListActiveDirectoriesPagedResponse>
      listActiveDirectoriesPagedCallable;
  private final UnaryCallable<GetActiveDirectoryRequest, ActiveDirectory>
      getActiveDirectoryCallable;
  private final UnaryCallable<CreateActiveDirectoryRequest, Operation>
      createActiveDirectoryCallable;
  private final OperationCallable<CreateActiveDirectoryRequest, ActiveDirectory, OperationMetadata>
      createActiveDirectoryOperationCallable;
  private final UnaryCallable<UpdateActiveDirectoryRequest, Operation>
      updateActiveDirectoryCallable;
  private final OperationCallable<UpdateActiveDirectoryRequest, ActiveDirectory, OperationMetadata>
      updateActiveDirectoryOperationCallable;
  private final UnaryCallable<DeleteActiveDirectoryRequest, Operation>
      deleteActiveDirectoryCallable;
  private final OperationCallable<DeleteActiveDirectoryRequest, Empty, OperationMetadata>
      deleteActiveDirectoryOperationCallable;
  private final UnaryCallable<ListKmsConfigsRequest, ListKmsConfigsResponse> listKmsConfigsCallable;
  private final UnaryCallable<ListKmsConfigsRequest, ListKmsConfigsPagedResponse>
      listKmsConfigsPagedCallable;
  private final UnaryCallable<CreateKmsConfigRequest, Operation> createKmsConfigCallable;
  private final OperationCallable<CreateKmsConfigRequest, KmsConfig, OperationMetadata>
      createKmsConfigOperationCallable;
  private final UnaryCallable<GetKmsConfigRequest, KmsConfig> getKmsConfigCallable;
  private final UnaryCallable<UpdateKmsConfigRequest, Operation> updateKmsConfigCallable;
  private final OperationCallable<UpdateKmsConfigRequest, KmsConfig, OperationMetadata>
      updateKmsConfigOperationCallable;
  private final UnaryCallable<EncryptVolumesRequest, Operation> encryptVolumesCallable;
  private final OperationCallable<EncryptVolumesRequest, KmsConfig, OperationMetadata>
      encryptVolumesOperationCallable;
  private final UnaryCallable<VerifyKmsConfigRequest, VerifyKmsConfigResponse>
      verifyKmsConfigCallable;
  private final UnaryCallable<DeleteKmsConfigRequest, Operation> deleteKmsConfigCallable;
  private final OperationCallable<DeleteKmsConfigRequest, Empty, OperationMetadata>
      deleteKmsConfigOperationCallable;
  private final UnaryCallable<ListReplicationsRequest, ListReplicationsResponse>
      listReplicationsCallable;
  private final UnaryCallable<ListReplicationsRequest, ListReplicationsPagedResponse>
      listReplicationsPagedCallable;
  private final UnaryCallable<GetReplicationRequest, Replication> getReplicationCallable;
  private final UnaryCallable<CreateReplicationRequest, Operation> createReplicationCallable;
  private final OperationCallable<CreateReplicationRequest, Replication, OperationMetadata>
      createReplicationOperationCallable;
  private final UnaryCallable<DeleteReplicationRequest, Operation> deleteReplicationCallable;
  private final OperationCallable<DeleteReplicationRequest, Empty, OperationMetadata>
      deleteReplicationOperationCallable;
  private final UnaryCallable<UpdateReplicationRequest, Operation> updateReplicationCallable;
  private final OperationCallable<UpdateReplicationRequest, Replication, OperationMetadata>
      updateReplicationOperationCallable;
  private final UnaryCallable<StopReplicationRequest, Operation> stopReplicationCallable;
  private final OperationCallable<StopReplicationRequest, Replication, OperationMetadata>
      stopReplicationOperationCallable;
  private final UnaryCallable<ResumeReplicationRequest, Operation> resumeReplicationCallable;
  private final OperationCallable<ResumeReplicationRequest, Replication, OperationMetadata>
      resumeReplicationOperationCallable;
  private final UnaryCallable<ReverseReplicationDirectionRequest, Operation>
      reverseReplicationDirectionCallable;
  private final OperationCallable<
          ReverseReplicationDirectionRequest, Replication, OperationMetadata>
      reverseReplicationDirectionOperationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcNetAppStub create(NetAppStubSettings settings) throws IOException {
    return new GrpcNetAppStub(settings, ClientContext.create(settings));
  }

  public static final GrpcNetAppStub create(ClientContext clientContext) throws IOException {
    return new GrpcNetAppStub(NetAppStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcNetAppStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcNetAppStub(
        NetAppStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcNetAppStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcNetAppStub(NetAppStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcNetAppCallableFactory());
  }

  /**
   * Constructs an instance of GrpcNetAppStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcNetAppStub(
      NetAppStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListStoragePoolsRequest, ListStoragePoolsResponse>
        listStoragePoolsTransportSettings =
            GrpcCallSettings.<ListStoragePoolsRequest, ListStoragePoolsResponse>newBuilder()
                .setMethodDescriptor(listStoragePoolsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateStoragePoolRequest, Operation> createStoragePoolTransportSettings =
        GrpcCallSettings.<CreateStoragePoolRequest, Operation>newBuilder()
            .setMethodDescriptor(createStoragePoolMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetStoragePoolRequest, StoragePool> getStoragePoolTransportSettings =
        GrpcCallSettings.<GetStoragePoolRequest, StoragePool>newBuilder()
            .setMethodDescriptor(getStoragePoolMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateStoragePoolRequest, Operation> updateStoragePoolTransportSettings =
        GrpcCallSettings.<UpdateStoragePoolRequest, Operation>newBuilder()
            .setMethodDescriptor(updateStoragePoolMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "storage_pool.name", String.valueOf(request.getStoragePool().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteStoragePoolRequest, Operation> deleteStoragePoolTransportSettings =
        GrpcCallSettings.<DeleteStoragePoolRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteStoragePoolMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListVolumesRequest, ListVolumesResponse> listVolumesTransportSettings =
        GrpcCallSettings.<ListVolumesRequest, ListVolumesResponse>newBuilder()
            .setMethodDescriptor(listVolumesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetVolumeRequest, Volume> getVolumeTransportSettings =
        GrpcCallSettings.<GetVolumeRequest, Volume>newBuilder()
            .setMethodDescriptor(getVolumeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateVolumeRequest, Operation> createVolumeTransportSettings =
        GrpcCallSettings.<CreateVolumeRequest, Operation>newBuilder()
            .setMethodDescriptor(createVolumeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateVolumeRequest, Operation> updateVolumeTransportSettings =
        GrpcCallSettings.<UpdateVolumeRequest, Operation>newBuilder()
            .setMethodDescriptor(updateVolumeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("volume.name", String.valueOf(request.getVolume().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteVolumeRequest, Operation> deleteVolumeTransportSettings =
        GrpcCallSettings.<DeleteVolumeRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteVolumeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<RevertVolumeRequest, Operation> revertVolumeTransportSettings =
        GrpcCallSettings.<RevertVolumeRequest, Operation>newBuilder()
            .setMethodDescriptor(revertVolumeMethodDescriptor)
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
    GrpcCallSettings<ListActiveDirectoriesRequest, ListActiveDirectoriesResponse>
        listActiveDirectoriesTransportSettings =
            GrpcCallSettings
                .<ListActiveDirectoriesRequest, ListActiveDirectoriesResponse>newBuilder()
                .setMethodDescriptor(listActiveDirectoriesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetActiveDirectoryRequest, ActiveDirectory>
        getActiveDirectoryTransportSettings =
            GrpcCallSettings.<GetActiveDirectoryRequest, ActiveDirectory>newBuilder()
                .setMethodDescriptor(getActiveDirectoryMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateActiveDirectoryRequest, Operation>
        createActiveDirectoryTransportSettings =
            GrpcCallSettings.<CreateActiveDirectoryRequest, Operation>newBuilder()
                .setMethodDescriptor(createActiveDirectoryMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateActiveDirectoryRequest, Operation>
        updateActiveDirectoryTransportSettings =
            GrpcCallSettings.<UpdateActiveDirectoryRequest, Operation>newBuilder()
                .setMethodDescriptor(updateActiveDirectoryMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "active_directory.name",
                          String.valueOf(request.getActiveDirectory().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteActiveDirectoryRequest, Operation>
        deleteActiveDirectoryTransportSettings =
            GrpcCallSettings.<DeleteActiveDirectoryRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteActiveDirectoryMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListKmsConfigsRequest, ListKmsConfigsResponse>
        listKmsConfigsTransportSettings =
            GrpcCallSettings.<ListKmsConfigsRequest, ListKmsConfigsResponse>newBuilder()
                .setMethodDescriptor(listKmsConfigsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateKmsConfigRequest, Operation> createKmsConfigTransportSettings =
        GrpcCallSettings.<CreateKmsConfigRequest, Operation>newBuilder()
            .setMethodDescriptor(createKmsConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetKmsConfigRequest, KmsConfig> getKmsConfigTransportSettings =
        GrpcCallSettings.<GetKmsConfigRequest, KmsConfig>newBuilder()
            .setMethodDescriptor(getKmsConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateKmsConfigRequest, Operation> updateKmsConfigTransportSettings =
        GrpcCallSettings.<UpdateKmsConfigRequest, Operation>newBuilder()
            .setMethodDescriptor(updateKmsConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("kms_config.name", String.valueOf(request.getKmsConfig().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<EncryptVolumesRequest, Operation> encryptVolumesTransportSettings =
        GrpcCallSettings.<EncryptVolumesRequest, Operation>newBuilder()
            .setMethodDescriptor(encryptVolumesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<VerifyKmsConfigRequest, VerifyKmsConfigResponse>
        verifyKmsConfigTransportSettings =
            GrpcCallSettings.<VerifyKmsConfigRequest, VerifyKmsConfigResponse>newBuilder()
                .setMethodDescriptor(verifyKmsConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteKmsConfigRequest, Operation> deleteKmsConfigTransportSettings =
        GrpcCallSettings.<DeleteKmsConfigRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteKmsConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListReplicationsRequest, ListReplicationsResponse>
        listReplicationsTransportSettings =
            GrpcCallSettings.<ListReplicationsRequest, ListReplicationsResponse>newBuilder()
                .setMethodDescriptor(listReplicationsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetReplicationRequest, Replication> getReplicationTransportSettings =
        GrpcCallSettings.<GetReplicationRequest, Replication>newBuilder()
            .setMethodDescriptor(getReplicationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateReplicationRequest, Operation> createReplicationTransportSettings =
        GrpcCallSettings.<CreateReplicationRequest, Operation>newBuilder()
            .setMethodDescriptor(createReplicationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteReplicationRequest, Operation> deleteReplicationTransportSettings =
        GrpcCallSettings.<DeleteReplicationRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteReplicationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateReplicationRequest, Operation> updateReplicationTransportSettings =
        GrpcCallSettings.<UpdateReplicationRequest, Operation>newBuilder()
            .setMethodDescriptor(updateReplicationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "replication.name", String.valueOf(request.getReplication().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<StopReplicationRequest, Operation> stopReplicationTransportSettings =
        GrpcCallSettings.<StopReplicationRequest, Operation>newBuilder()
            .setMethodDescriptor(stopReplicationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ResumeReplicationRequest, Operation> resumeReplicationTransportSettings =
        GrpcCallSettings.<ResumeReplicationRequest, Operation>newBuilder()
            .setMethodDescriptor(resumeReplicationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ReverseReplicationDirectionRequest, Operation>
        reverseReplicationDirectionTransportSettings =
            GrpcCallSettings.<ReverseReplicationDirectionRequest, Operation>newBuilder()
                .setMethodDescriptor(reverseReplicationDirectionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListLocationsRequest, ListLocationsResponse> listLocationsTransportSettings =
        GrpcCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
            .setMethodDescriptor(listLocationsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        GrpcCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.listStoragePoolsCallable =
        callableFactory.createUnaryCallable(
            listStoragePoolsTransportSettings, settings.listStoragePoolsSettings(), clientContext);
    this.listStoragePoolsPagedCallable =
        callableFactory.createPagedCallable(
            listStoragePoolsTransportSettings, settings.listStoragePoolsSettings(), clientContext);
    this.createStoragePoolCallable =
        callableFactory.createUnaryCallable(
            createStoragePoolTransportSettings,
            settings.createStoragePoolSettings(),
            clientContext);
    this.createStoragePoolOperationCallable =
        callableFactory.createOperationCallable(
            createStoragePoolTransportSettings,
            settings.createStoragePoolOperationSettings(),
            clientContext,
            operationsStub);
    this.getStoragePoolCallable =
        callableFactory.createUnaryCallable(
            getStoragePoolTransportSettings, settings.getStoragePoolSettings(), clientContext);
    this.updateStoragePoolCallable =
        callableFactory.createUnaryCallable(
            updateStoragePoolTransportSettings,
            settings.updateStoragePoolSettings(),
            clientContext);
    this.updateStoragePoolOperationCallable =
        callableFactory.createOperationCallable(
            updateStoragePoolTransportSettings,
            settings.updateStoragePoolOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteStoragePoolCallable =
        callableFactory.createUnaryCallable(
            deleteStoragePoolTransportSettings,
            settings.deleteStoragePoolSettings(),
            clientContext);
    this.deleteStoragePoolOperationCallable =
        callableFactory.createOperationCallable(
            deleteStoragePoolTransportSettings,
            settings.deleteStoragePoolOperationSettings(),
            clientContext,
            operationsStub);
    this.listVolumesCallable =
        callableFactory.createUnaryCallable(
            listVolumesTransportSettings, settings.listVolumesSettings(), clientContext);
    this.listVolumesPagedCallable =
        callableFactory.createPagedCallable(
            listVolumesTransportSettings, settings.listVolumesSettings(), clientContext);
    this.getVolumeCallable =
        callableFactory.createUnaryCallable(
            getVolumeTransportSettings, settings.getVolumeSettings(), clientContext);
    this.createVolumeCallable =
        callableFactory.createUnaryCallable(
            createVolumeTransportSettings, settings.createVolumeSettings(), clientContext);
    this.createVolumeOperationCallable =
        callableFactory.createOperationCallable(
            createVolumeTransportSettings,
            settings.createVolumeOperationSettings(),
            clientContext,
            operationsStub);
    this.updateVolumeCallable =
        callableFactory.createUnaryCallable(
            updateVolumeTransportSettings, settings.updateVolumeSettings(), clientContext);
    this.updateVolumeOperationCallable =
        callableFactory.createOperationCallable(
            updateVolumeTransportSettings,
            settings.updateVolumeOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteVolumeCallable =
        callableFactory.createUnaryCallable(
            deleteVolumeTransportSettings, settings.deleteVolumeSettings(), clientContext);
    this.deleteVolumeOperationCallable =
        callableFactory.createOperationCallable(
            deleteVolumeTransportSettings,
            settings.deleteVolumeOperationSettings(),
            clientContext,
            operationsStub);
    this.revertVolumeCallable =
        callableFactory.createUnaryCallable(
            revertVolumeTransportSettings, settings.revertVolumeSettings(), clientContext);
    this.revertVolumeOperationCallable =
        callableFactory.createOperationCallable(
            revertVolumeTransportSettings,
            settings.revertVolumeOperationSettings(),
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
    this.listActiveDirectoriesCallable =
        callableFactory.createUnaryCallable(
            listActiveDirectoriesTransportSettings,
            settings.listActiveDirectoriesSettings(),
            clientContext);
    this.listActiveDirectoriesPagedCallable =
        callableFactory.createPagedCallable(
            listActiveDirectoriesTransportSettings,
            settings.listActiveDirectoriesSettings(),
            clientContext);
    this.getActiveDirectoryCallable =
        callableFactory.createUnaryCallable(
            getActiveDirectoryTransportSettings,
            settings.getActiveDirectorySettings(),
            clientContext);
    this.createActiveDirectoryCallable =
        callableFactory.createUnaryCallable(
            createActiveDirectoryTransportSettings,
            settings.createActiveDirectorySettings(),
            clientContext);
    this.createActiveDirectoryOperationCallable =
        callableFactory.createOperationCallable(
            createActiveDirectoryTransportSettings,
            settings.createActiveDirectoryOperationSettings(),
            clientContext,
            operationsStub);
    this.updateActiveDirectoryCallable =
        callableFactory.createUnaryCallable(
            updateActiveDirectoryTransportSettings,
            settings.updateActiveDirectorySettings(),
            clientContext);
    this.updateActiveDirectoryOperationCallable =
        callableFactory.createOperationCallable(
            updateActiveDirectoryTransportSettings,
            settings.updateActiveDirectoryOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteActiveDirectoryCallable =
        callableFactory.createUnaryCallable(
            deleteActiveDirectoryTransportSettings,
            settings.deleteActiveDirectorySettings(),
            clientContext);
    this.deleteActiveDirectoryOperationCallable =
        callableFactory.createOperationCallable(
            deleteActiveDirectoryTransportSettings,
            settings.deleteActiveDirectoryOperationSettings(),
            clientContext,
            operationsStub);
    this.listKmsConfigsCallable =
        callableFactory.createUnaryCallable(
            listKmsConfigsTransportSettings, settings.listKmsConfigsSettings(), clientContext);
    this.listKmsConfigsPagedCallable =
        callableFactory.createPagedCallable(
            listKmsConfigsTransportSettings, settings.listKmsConfigsSettings(), clientContext);
    this.createKmsConfigCallable =
        callableFactory.createUnaryCallable(
            createKmsConfigTransportSettings, settings.createKmsConfigSettings(), clientContext);
    this.createKmsConfigOperationCallable =
        callableFactory.createOperationCallable(
            createKmsConfigTransportSettings,
            settings.createKmsConfigOperationSettings(),
            clientContext,
            operationsStub);
    this.getKmsConfigCallable =
        callableFactory.createUnaryCallable(
            getKmsConfigTransportSettings, settings.getKmsConfigSettings(), clientContext);
    this.updateKmsConfigCallable =
        callableFactory.createUnaryCallable(
            updateKmsConfigTransportSettings, settings.updateKmsConfigSettings(), clientContext);
    this.updateKmsConfigOperationCallable =
        callableFactory.createOperationCallable(
            updateKmsConfigTransportSettings,
            settings.updateKmsConfigOperationSettings(),
            clientContext,
            operationsStub);
    this.encryptVolumesCallable =
        callableFactory.createUnaryCallable(
            encryptVolumesTransportSettings, settings.encryptVolumesSettings(), clientContext);
    this.encryptVolumesOperationCallable =
        callableFactory.createOperationCallable(
            encryptVolumesTransportSettings,
            settings.encryptVolumesOperationSettings(),
            clientContext,
            operationsStub);
    this.verifyKmsConfigCallable =
        callableFactory.createUnaryCallable(
            verifyKmsConfigTransportSettings, settings.verifyKmsConfigSettings(), clientContext);
    this.deleteKmsConfigCallable =
        callableFactory.createUnaryCallable(
            deleteKmsConfigTransportSettings, settings.deleteKmsConfigSettings(), clientContext);
    this.deleteKmsConfigOperationCallable =
        callableFactory.createOperationCallable(
            deleteKmsConfigTransportSettings,
            settings.deleteKmsConfigOperationSettings(),
            clientContext,
            operationsStub);
    this.listReplicationsCallable =
        callableFactory.createUnaryCallable(
            listReplicationsTransportSettings, settings.listReplicationsSettings(), clientContext);
    this.listReplicationsPagedCallable =
        callableFactory.createPagedCallable(
            listReplicationsTransportSettings, settings.listReplicationsSettings(), clientContext);
    this.getReplicationCallable =
        callableFactory.createUnaryCallable(
            getReplicationTransportSettings, settings.getReplicationSettings(), clientContext);
    this.createReplicationCallable =
        callableFactory.createUnaryCallable(
            createReplicationTransportSettings,
            settings.createReplicationSettings(),
            clientContext);
    this.createReplicationOperationCallable =
        callableFactory.createOperationCallable(
            createReplicationTransportSettings,
            settings.createReplicationOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteReplicationCallable =
        callableFactory.createUnaryCallable(
            deleteReplicationTransportSettings,
            settings.deleteReplicationSettings(),
            clientContext);
    this.deleteReplicationOperationCallable =
        callableFactory.createOperationCallable(
            deleteReplicationTransportSettings,
            settings.deleteReplicationOperationSettings(),
            clientContext,
            operationsStub);
    this.updateReplicationCallable =
        callableFactory.createUnaryCallable(
            updateReplicationTransportSettings,
            settings.updateReplicationSettings(),
            clientContext);
    this.updateReplicationOperationCallable =
        callableFactory.createOperationCallable(
            updateReplicationTransportSettings,
            settings.updateReplicationOperationSettings(),
            clientContext,
            operationsStub);
    this.stopReplicationCallable =
        callableFactory.createUnaryCallable(
            stopReplicationTransportSettings, settings.stopReplicationSettings(), clientContext);
    this.stopReplicationOperationCallable =
        callableFactory.createOperationCallable(
            stopReplicationTransportSettings,
            settings.stopReplicationOperationSettings(),
            clientContext,
            operationsStub);
    this.resumeReplicationCallable =
        callableFactory.createUnaryCallable(
            resumeReplicationTransportSettings,
            settings.resumeReplicationSettings(),
            clientContext);
    this.resumeReplicationOperationCallable =
        callableFactory.createOperationCallable(
            resumeReplicationTransportSettings,
            settings.resumeReplicationOperationSettings(),
            clientContext,
            operationsStub);
    this.reverseReplicationDirectionCallable =
        callableFactory.createUnaryCallable(
            reverseReplicationDirectionTransportSettings,
            settings.reverseReplicationDirectionSettings(),
            clientContext);
    this.reverseReplicationDirectionOperationCallable =
        callableFactory.createOperationCallable(
            reverseReplicationDirectionTransportSettings,
            settings.reverseReplicationDirectionOperationSettings(),
            clientContext,
            operationsStub);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListStoragePoolsRequest, ListStoragePoolsResponse>
      listStoragePoolsCallable() {
    return listStoragePoolsCallable;
  }

  @Override
  public UnaryCallable<ListStoragePoolsRequest, ListStoragePoolsPagedResponse>
      listStoragePoolsPagedCallable() {
    return listStoragePoolsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateStoragePoolRequest, Operation> createStoragePoolCallable() {
    return createStoragePoolCallable;
  }

  @Override
  public OperationCallable<CreateStoragePoolRequest, StoragePool, OperationMetadata>
      createStoragePoolOperationCallable() {
    return createStoragePoolOperationCallable;
  }

  @Override
  public UnaryCallable<GetStoragePoolRequest, StoragePool> getStoragePoolCallable() {
    return getStoragePoolCallable;
  }

  @Override
  public UnaryCallable<UpdateStoragePoolRequest, Operation> updateStoragePoolCallable() {
    return updateStoragePoolCallable;
  }

  @Override
  public OperationCallable<UpdateStoragePoolRequest, StoragePool, OperationMetadata>
      updateStoragePoolOperationCallable() {
    return updateStoragePoolOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteStoragePoolRequest, Operation> deleteStoragePoolCallable() {
    return deleteStoragePoolCallable;
  }

  @Override
  public OperationCallable<DeleteStoragePoolRequest, Empty, OperationMetadata>
      deleteStoragePoolOperationCallable() {
    return deleteStoragePoolOperationCallable;
  }

  @Override
  public UnaryCallable<ListVolumesRequest, ListVolumesResponse> listVolumesCallable() {
    return listVolumesCallable;
  }

  @Override
  public UnaryCallable<ListVolumesRequest, ListVolumesPagedResponse> listVolumesPagedCallable() {
    return listVolumesPagedCallable;
  }

  @Override
  public UnaryCallable<GetVolumeRequest, Volume> getVolumeCallable() {
    return getVolumeCallable;
  }

  @Override
  public UnaryCallable<CreateVolumeRequest, Operation> createVolumeCallable() {
    return createVolumeCallable;
  }

  @Override
  public OperationCallable<CreateVolumeRequest, Volume, OperationMetadata>
      createVolumeOperationCallable() {
    return createVolumeOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateVolumeRequest, Operation> updateVolumeCallable() {
    return updateVolumeCallable;
  }

  @Override
  public OperationCallable<UpdateVolumeRequest, Volume, OperationMetadata>
      updateVolumeOperationCallable() {
    return updateVolumeOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteVolumeRequest, Operation> deleteVolumeCallable() {
    return deleteVolumeCallable;
  }

  @Override
  public OperationCallable<DeleteVolumeRequest, Empty, OperationMetadata>
      deleteVolumeOperationCallable() {
    return deleteVolumeOperationCallable;
  }

  @Override
  public UnaryCallable<RevertVolumeRequest, Operation> revertVolumeCallable() {
    return revertVolumeCallable;
  }

  @Override
  public OperationCallable<RevertVolumeRequest, Volume, OperationMetadata>
      revertVolumeOperationCallable() {
    return revertVolumeOperationCallable;
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
  public UnaryCallable<ListActiveDirectoriesRequest, ListActiveDirectoriesResponse>
      listActiveDirectoriesCallable() {
    return listActiveDirectoriesCallable;
  }

  @Override
  public UnaryCallable<ListActiveDirectoriesRequest, ListActiveDirectoriesPagedResponse>
      listActiveDirectoriesPagedCallable() {
    return listActiveDirectoriesPagedCallable;
  }

  @Override
  public UnaryCallable<GetActiveDirectoryRequest, ActiveDirectory> getActiveDirectoryCallable() {
    return getActiveDirectoryCallable;
  }

  @Override
  public UnaryCallable<CreateActiveDirectoryRequest, Operation> createActiveDirectoryCallable() {
    return createActiveDirectoryCallable;
  }

  @Override
  public OperationCallable<CreateActiveDirectoryRequest, ActiveDirectory, OperationMetadata>
      createActiveDirectoryOperationCallable() {
    return createActiveDirectoryOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateActiveDirectoryRequest, Operation> updateActiveDirectoryCallable() {
    return updateActiveDirectoryCallable;
  }

  @Override
  public OperationCallable<UpdateActiveDirectoryRequest, ActiveDirectory, OperationMetadata>
      updateActiveDirectoryOperationCallable() {
    return updateActiveDirectoryOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteActiveDirectoryRequest, Operation> deleteActiveDirectoryCallable() {
    return deleteActiveDirectoryCallable;
  }

  @Override
  public OperationCallable<DeleteActiveDirectoryRequest, Empty, OperationMetadata>
      deleteActiveDirectoryOperationCallable() {
    return deleteActiveDirectoryOperationCallable;
  }

  @Override
  public UnaryCallable<ListKmsConfigsRequest, ListKmsConfigsResponse> listKmsConfigsCallable() {
    return listKmsConfigsCallable;
  }

  @Override
  public UnaryCallable<ListKmsConfigsRequest, ListKmsConfigsPagedResponse>
      listKmsConfigsPagedCallable() {
    return listKmsConfigsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateKmsConfigRequest, Operation> createKmsConfigCallable() {
    return createKmsConfigCallable;
  }

  @Override
  public OperationCallable<CreateKmsConfigRequest, KmsConfig, OperationMetadata>
      createKmsConfigOperationCallable() {
    return createKmsConfigOperationCallable;
  }

  @Override
  public UnaryCallable<GetKmsConfigRequest, KmsConfig> getKmsConfigCallable() {
    return getKmsConfigCallable;
  }

  @Override
  public UnaryCallable<UpdateKmsConfigRequest, Operation> updateKmsConfigCallable() {
    return updateKmsConfigCallable;
  }

  @Override
  public OperationCallable<UpdateKmsConfigRequest, KmsConfig, OperationMetadata>
      updateKmsConfigOperationCallable() {
    return updateKmsConfigOperationCallable;
  }

  @Override
  public UnaryCallable<EncryptVolumesRequest, Operation> encryptVolumesCallable() {
    return encryptVolumesCallable;
  }

  @Override
  public OperationCallable<EncryptVolumesRequest, KmsConfig, OperationMetadata>
      encryptVolumesOperationCallable() {
    return encryptVolumesOperationCallable;
  }

  @Override
  public UnaryCallable<VerifyKmsConfigRequest, VerifyKmsConfigResponse> verifyKmsConfigCallable() {
    return verifyKmsConfigCallable;
  }

  @Override
  public UnaryCallable<DeleteKmsConfigRequest, Operation> deleteKmsConfigCallable() {
    return deleteKmsConfigCallable;
  }

  @Override
  public OperationCallable<DeleteKmsConfigRequest, Empty, OperationMetadata>
      deleteKmsConfigOperationCallable() {
    return deleteKmsConfigOperationCallable;
  }

  @Override
  public UnaryCallable<ListReplicationsRequest, ListReplicationsResponse>
      listReplicationsCallable() {
    return listReplicationsCallable;
  }

  @Override
  public UnaryCallable<ListReplicationsRequest, ListReplicationsPagedResponse>
      listReplicationsPagedCallable() {
    return listReplicationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetReplicationRequest, Replication> getReplicationCallable() {
    return getReplicationCallable;
  }

  @Override
  public UnaryCallable<CreateReplicationRequest, Operation> createReplicationCallable() {
    return createReplicationCallable;
  }

  @Override
  public OperationCallable<CreateReplicationRequest, Replication, OperationMetadata>
      createReplicationOperationCallable() {
    return createReplicationOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteReplicationRequest, Operation> deleteReplicationCallable() {
    return deleteReplicationCallable;
  }

  @Override
  public OperationCallable<DeleteReplicationRequest, Empty, OperationMetadata>
      deleteReplicationOperationCallable() {
    return deleteReplicationOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateReplicationRequest, Operation> updateReplicationCallable() {
    return updateReplicationCallable;
  }

  @Override
  public OperationCallable<UpdateReplicationRequest, Replication, OperationMetadata>
      updateReplicationOperationCallable() {
    return updateReplicationOperationCallable;
  }

  @Override
  public UnaryCallable<StopReplicationRequest, Operation> stopReplicationCallable() {
    return stopReplicationCallable;
  }

  @Override
  public OperationCallable<StopReplicationRequest, Replication, OperationMetadata>
      stopReplicationOperationCallable() {
    return stopReplicationOperationCallable;
  }

  @Override
  public UnaryCallable<ResumeReplicationRequest, Operation> resumeReplicationCallable() {
    return resumeReplicationCallable;
  }

  @Override
  public OperationCallable<ResumeReplicationRequest, Replication, OperationMetadata>
      resumeReplicationOperationCallable() {
    return resumeReplicationOperationCallable;
  }

  @Override
  public UnaryCallable<ReverseReplicationDirectionRequest, Operation>
      reverseReplicationDirectionCallable() {
    return reverseReplicationDirectionCallable;
  }

  @Override
  public OperationCallable<ReverseReplicationDirectionRequest, Replication, OperationMetadata>
      reverseReplicationDirectionOperationCallable() {
    return reverseReplicationDirectionOperationCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return listLocationsCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return listLocationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return getLocationCallable;
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
