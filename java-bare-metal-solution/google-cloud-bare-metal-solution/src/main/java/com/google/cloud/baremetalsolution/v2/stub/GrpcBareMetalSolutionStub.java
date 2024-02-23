/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.baremetalsolution.v2.stub;

import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListInstancesPagedResponse;
import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListLocationsPagedResponse;
import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListLunsPagedResponse;
import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListNetworksPagedResponse;
import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListNfsSharesPagedResponse;
import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListOSImagesPagedResponse;
import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListProvisioningQuotasPagedResponse;
import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListSSHKeysPagedResponse;
import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListVolumeSnapshotsPagedResponse;
import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListVolumesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.baremetalsolution.v2.CreateNfsShareRequest;
import com.google.cloud.baremetalsolution.v2.CreateProvisioningConfigRequest;
import com.google.cloud.baremetalsolution.v2.CreateSSHKeyRequest;
import com.google.cloud.baremetalsolution.v2.CreateVolumeSnapshotRequest;
import com.google.cloud.baremetalsolution.v2.DeleteNfsShareRequest;
import com.google.cloud.baremetalsolution.v2.DeleteSSHKeyRequest;
import com.google.cloud.baremetalsolution.v2.DeleteVolumeSnapshotRequest;
import com.google.cloud.baremetalsolution.v2.DetachLunRequest;
import com.google.cloud.baremetalsolution.v2.DisableInteractiveSerialConsoleRequest;
import com.google.cloud.baremetalsolution.v2.DisableInteractiveSerialConsoleResponse;
import com.google.cloud.baremetalsolution.v2.EnableInteractiveSerialConsoleRequest;
import com.google.cloud.baremetalsolution.v2.EnableInteractiveSerialConsoleResponse;
import com.google.cloud.baremetalsolution.v2.EvictLunRequest;
import com.google.cloud.baremetalsolution.v2.EvictVolumeRequest;
import com.google.cloud.baremetalsolution.v2.GetInstanceRequest;
import com.google.cloud.baremetalsolution.v2.GetLunRequest;
import com.google.cloud.baremetalsolution.v2.GetNetworkRequest;
import com.google.cloud.baremetalsolution.v2.GetNfsShareRequest;
import com.google.cloud.baremetalsolution.v2.GetProvisioningConfigRequest;
import com.google.cloud.baremetalsolution.v2.GetVolumeRequest;
import com.google.cloud.baremetalsolution.v2.GetVolumeSnapshotRequest;
import com.google.cloud.baremetalsolution.v2.Instance;
import com.google.cloud.baremetalsolution.v2.ListInstancesRequest;
import com.google.cloud.baremetalsolution.v2.ListInstancesResponse;
import com.google.cloud.baremetalsolution.v2.ListLunsRequest;
import com.google.cloud.baremetalsolution.v2.ListLunsResponse;
import com.google.cloud.baremetalsolution.v2.ListNetworkUsageRequest;
import com.google.cloud.baremetalsolution.v2.ListNetworkUsageResponse;
import com.google.cloud.baremetalsolution.v2.ListNetworksRequest;
import com.google.cloud.baremetalsolution.v2.ListNetworksResponse;
import com.google.cloud.baremetalsolution.v2.ListNfsSharesRequest;
import com.google.cloud.baremetalsolution.v2.ListNfsSharesResponse;
import com.google.cloud.baremetalsolution.v2.ListOSImagesRequest;
import com.google.cloud.baremetalsolution.v2.ListOSImagesResponse;
import com.google.cloud.baremetalsolution.v2.ListProvisioningQuotasRequest;
import com.google.cloud.baremetalsolution.v2.ListProvisioningQuotasResponse;
import com.google.cloud.baremetalsolution.v2.ListSSHKeysRequest;
import com.google.cloud.baremetalsolution.v2.ListSSHKeysResponse;
import com.google.cloud.baremetalsolution.v2.ListVolumeSnapshotsRequest;
import com.google.cloud.baremetalsolution.v2.ListVolumeSnapshotsResponse;
import com.google.cloud.baremetalsolution.v2.ListVolumesRequest;
import com.google.cloud.baremetalsolution.v2.ListVolumesResponse;
import com.google.cloud.baremetalsolution.v2.Lun;
import com.google.cloud.baremetalsolution.v2.Network;
import com.google.cloud.baremetalsolution.v2.NfsShare;
import com.google.cloud.baremetalsolution.v2.OperationMetadata;
import com.google.cloud.baremetalsolution.v2.ProvisioningConfig;
import com.google.cloud.baremetalsolution.v2.RenameInstanceRequest;
import com.google.cloud.baremetalsolution.v2.RenameNetworkRequest;
import com.google.cloud.baremetalsolution.v2.RenameNfsShareRequest;
import com.google.cloud.baremetalsolution.v2.RenameVolumeRequest;
import com.google.cloud.baremetalsolution.v2.ResetInstanceRequest;
import com.google.cloud.baremetalsolution.v2.ResetInstanceResponse;
import com.google.cloud.baremetalsolution.v2.ResizeVolumeRequest;
import com.google.cloud.baremetalsolution.v2.RestoreVolumeSnapshotRequest;
import com.google.cloud.baremetalsolution.v2.SSHKey;
import com.google.cloud.baremetalsolution.v2.StartInstanceRequest;
import com.google.cloud.baremetalsolution.v2.StartInstanceResponse;
import com.google.cloud.baremetalsolution.v2.StopInstanceRequest;
import com.google.cloud.baremetalsolution.v2.StopInstanceResponse;
import com.google.cloud.baremetalsolution.v2.SubmitProvisioningConfigRequest;
import com.google.cloud.baremetalsolution.v2.SubmitProvisioningConfigResponse;
import com.google.cloud.baremetalsolution.v2.UpdateInstanceRequest;
import com.google.cloud.baremetalsolution.v2.UpdateNetworkRequest;
import com.google.cloud.baremetalsolution.v2.UpdateNfsShareRequest;
import com.google.cloud.baremetalsolution.v2.UpdateProvisioningConfigRequest;
import com.google.cloud.baremetalsolution.v2.UpdateVolumeRequest;
import com.google.cloud.baremetalsolution.v2.Volume;
import com.google.cloud.baremetalsolution.v2.VolumeSnapshot;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
 * gRPC stub implementation for the BareMetalSolution service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcBareMetalSolutionStub extends BareMetalSolutionStub {
  private static final MethodDescriptor<ListInstancesRequest, ListInstancesResponse>
      listInstancesMethodDescriptor =
          MethodDescriptor.<ListInstancesRequest, ListInstancesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.baremetalsolution.v2.BareMetalSolution/ListInstances")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListInstancesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListInstancesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetInstanceRequest, Instance> getInstanceMethodDescriptor =
      MethodDescriptor.<GetInstanceRequest, Instance>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.baremetalsolution.v2.BareMetalSolution/GetInstance")
          .setRequestMarshaller(ProtoUtils.marshaller(GetInstanceRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Instance.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateInstanceRequest, Operation>
      updateInstanceMethodDescriptor =
          MethodDescriptor.<UpdateInstanceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.baremetalsolution.v2.BareMetalSolution/UpdateInstance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RenameInstanceRequest, Instance>
      renameInstanceMethodDescriptor =
          MethodDescriptor.<RenameInstanceRequest, Instance>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.baremetalsolution.v2.BareMetalSolution/RenameInstance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RenameInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Instance.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ResetInstanceRequest, Operation>
      resetInstanceMethodDescriptor =
          MethodDescriptor.<ResetInstanceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.baremetalsolution.v2.BareMetalSolution/ResetInstance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ResetInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<StartInstanceRequest, Operation>
      startInstanceMethodDescriptor =
          MethodDescriptor.<StartInstanceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.baremetalsolution.v2.BareMetalSolution/StartInstance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(StartInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<StopInstanceRequest, Operation>
      stopInstanceMethodDescriptor =
          MethodDescriptor.<StopInstanceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.baremetalsolution.v2.BareMetalSolution/StopInstance")
              .setRequestMarshaller(ProtoUtils.marshaller(StopInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<EnableInteractiveSerialConsoleRequest, Operation>
      enableInteractiveSerialConsoleMethodDescriptor =
          MethodDescriptor.<EnableInteractiveSerialConsoleRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.baremetalsolution.v2.BareMetalSolution/EnableInteractiveSerialConsole")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(EnableInteractiveSerialConsoleRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DisableInteractiveSerialConsoleRequest, Operation>
      disableInteractiveSerialConsoleMethodDescriptor =
          MethodDescriptor.<DisableInteractiveSerialConsoleRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.baremetalsolution.v2.BareMetalSolution/DisableInteractiveSerialConsole")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      DisableInteractiveSerialConsoleRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DetachLunRequest, Operation> detachLunMethodDescriptor =
      MethodDescriptor.<DetachLunRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.baremetalsolution.v2.BareMetalSolution/DetachLun")
          .setRequestMarshaller(ProtoUtils.marshaller(DetachLunRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListSSHKeysRequest, ListSSHKeysResponse>
      listSSHKeysMethodDescriptor =
          MethodDescriptor.<ListSSHKeysRequest, ListSSHKeysResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.baremetalsolution.v2.BareMetalSolution/ListSSHKeys")
              .setRequestMarshaller(ProtoUtils.marshaller(ListSSHKeysRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListSSHKeysResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateSSHKeyRequest, SSHKey> createSSHKeyMethodDescriptor =
      MethodDescriptor.<CreateSSHKeyRequest, SSHKey>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.baremetalsolution.v2.BareMetalSolution/CreateSSHKey")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateSSHKeyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(SSHKey.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteSSHKeyRequest, Empty> deleteSSHKeyMethodDescriptor =
      MethodDescriptor.<DeleteSSHKeyRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.baremetalsolution.v2.BareMetalSolution/DeleteSSHKey")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteSSHKeyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListVolumesRequest, ListVolumesResponse>
      listVolumesMethodDescriptor =
          MethodDescriptor.<ListVolumesRequest, ListVolumesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.baremetalsolution.v2.BareMetalSolution/ListVolumes")
              .setRequestMarshaller(ProtoUtils.marshaller(ListVolumesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListVolumesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetVolumeRequest, Volume> getVolumeMethodDescriptor =
      MethodDescriptor.<GetVolumeRequest, Volume>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.baremetalsolution.v2.BareMetalSolution/GetVolume")
          .setRequestMarshaller(ProtoUtils.marshaller(GetVolumeRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Volume.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateVolumeRequest, Operation>
      updateVolumeMethodDescriptor =
          MethodDescriptor.<UpdateVolumeRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.baremetalsolution.v2.BareMetalSolution/UpdateVolume")
              .setRequestMarshaller(ProtoUtils.marshaller(UpdateVolumeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RenameVolumeRequest, Volume> renameVolumeMethodDescriptor =
      MethodDescriptor.<RenameVolumeRequest, Volume>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.baremetalsolution.v2.BareMetalSolution/RenameVolume")
          .setRequestMarshaller(ProtoUtils.marshaller(RenameVolumeRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Volume.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<EvictVolumeRequest, Operation> evictVolumeMethodDescriptor =
      MethodDescriptor.<EvictVolumeRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.baremetalsolution.v2.BareMetalSolution/EvictVolume")
          .setRequestMarshaller(ProtoUtils.marshaller(EvictVolumeRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ResizeVolumeRequest, Operation>
      resizeVolumeMethodDescriptor =
          MethodDescriptor.<ResizeVolumeRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.baremetalsolution.v2.BareMetalSolution/ResizeVolume")
              .setRequestMarshaller(ProtoUtils.marshaller(ResizeVolumeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListNetworksRequest, ListNetworksResponse>
      listNetworksMethodDescriptor =
          MethodDescriptor.<ListNetworksRequest, ListNetworksResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.baremetalsolution.v2.BareMetalSolution/ListNetworks")
              .setRequestMarshaller(ProtoUtils.marshaller(ListNetworksRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListNetworksResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListNetworkUsageRequest, ListNetworkUsageResponse>
      listNetworkUsageMethodDescriptor =
          MethodDescriptor.<ListNetworkUsageRequest, ListNetworkUsageResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.baremetalsolution.v2.BareMetalSolution/ListNetworkUsage")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListNetworkUsageRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListNetworkUsageResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetNetworkRequest, Network> getNetworkMethodDescriptor =
      MethodDescriptor.<GetNetworkRequest, Network>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.baremetalsolution.v2.BareMetalSolution/GetNetwork")
          .setRequestMarshaller(ProtoUtils.marshaller(GetNetworkRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Network.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateNetworkRequest, Operation>
      updateNetworkMethodDescriptor =
          MethodDescriptor.<UpdateNetworkRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.baremetalsolution.v2.BareMetalSolution/UpdateNetwork")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateNetworkRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateVolumeSnapshotRequest, VolumeSnapshot>
      createVolumeSnapshotMethodDescriptor =
          MethodDescriptor.<CreateVolumeSnapshotRequest, VolumeSnapshot>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.baremetalsolution.v2.BareMetalSolution/CreateVolumeSnapshot")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateVolumeSnapshotRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(VolumeSnapshot.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RestoreVolumeSnapshotRequest, Operation>
      restoreVolumeSnapshotMethodDescriptor =
          MethodDescriptor.<RestoreVolumeSnapshotRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.baremetalsolution.v2.BareMetalSolution/RestoreVolumeSnapshot")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RestoreVolumeSnapshotRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteVolumeSnapshotRequest, Empty>
      deleteVolumeSnapshotMethodDescriptor =
          MethodDescriptor.<DeleteVolumeSnapshotRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.baremetalsolution.v2.BareMetalSolution/DeleteVolumeSnapshot")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteVolumeSnapshotRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetVolumeSnapshotRequest, VolumeSnapshot>
      getVolumeSnapshotMethodDescriptor =
          MethodDescriptor.<GetVolumeSnapshotRequest, VolumeSnapshot>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.baremetalsolution.v2.BareMetalSolution/GetVolumeSnapshot")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetVolumeSnapshotRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(VolumeSnapshot.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListVolumeSnapshotsRequest, ListVolumeSnapshotsResponse>
      listVolumeSnapshotsMethodDescriptor =
          MethodDescriptor.<ListVolumeSnapshotsRequest, ListVolumeSnapshotsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.baremetalsolution.v2.BareMetalSolution/ListVolumeSnapshots")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListVolumeSnapshotsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListVolumeSnapshotsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetLunRequest, Lun> getLunMethodDescriptor =
      MethodDescriptor.<GetLunRequest, Lun>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.baremetalsolution.v2.BareMetalSolution/GetLun")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLunRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Lun.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListLunsRequest, ListLunsResponse>
      listLunsMethodDescriptor =
          MethodDescriptor.<ListLunsRequest, ListLunsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.baremetalsolution.v2.BareMetalSolution/ListLuns")
              .setRequestMarshaller(ProtoUtils.marshaller(ListLunsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListLunsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<EvictLunRequest, Operation> evictLunMethodDescriptor =
      MethodDescriptor.<EvictLunRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.baremetalsolution.v2.BareMetalSolution/EvictLun")
          .setRequestMarshaller(ProtoUtils.marshaller(EvictLunRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetNfsShareRequest, NfsShare> getNfsShareMethodDescriptor =
      MethodDescriptor.<GetNfsShareRequest, NfsShare>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.baremetalsolution.v2.BareMetalSolution/GetNfsShare")
          .setRequestMarshaller(ProtoUtils.marshaller(GetNfsShareRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(NfsShare.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListNfsSharesRequest, ListNfsSharesResponse>
      listNfsSharesMethodDescriptor =
          MethodDescriptor.<ListNfsSharesRequest, ListNfsSharesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.baremetalsolution.v2.BareMetalSolution/ListNfsShares")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListNfsSharesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListNfsSharesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateNfsShareRequest, Operation>
      updateNfsShareMethodDescriptor =
          MethodDescriptor.<UpdateNfsShareRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.baremetalsolution.v2.BareMetalSolution/UpdateNfsShare")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateNfsShareRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateNfsShareRequest, Operation>
      createNfsShareMethodDescriptor =
          MethodDescriptor.<CreateNfsShareRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.baremetalsolution.v2.BareMetalSolution/CreateNfsShare")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateNfsShareRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RenameNfsShareRequest, NfsShare>
      renameNfsShareMethodDescriptor =
          MethodDescriptor.<RenameNfsShareRequest, NfsShare>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.baremetalsolution.v2.BareMetalSolution/RenameNfsShare")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RenameNfsShareRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(NfsShare.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteNfsShareRequest, Operation>
      deleteNfsShareMethodDescriptor =
          MethodDescriptor.<DeleteNfsShareRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.baremetalsolution.v2.BareMetalSolution/DeleteNfsShare")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteNfsShareRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListProvisioningQuotasRequest, ListProvisioningQuotasResponse>
      listProvisioningQuotasMethodDescriptor =
          MethodDescriptor
              .<ListProvisioningQuotasRequest, ListProvisioningQuotasResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.baremetalsolution.v2.BareMetalSolution/ListProvisioningQuotas")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListProvisioningQuotasRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListProvisioningQuotasResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          SubmitProvisioningConfigRequest, SubmitProvisioningConfigResponse>
      submitProvisioningConfigMethodDescriptor =
          MethodDescriptor
              .<SubmitProvisioningConfigRequest, SubmitProvisioningConfigResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.baremetalsolution.v2.BareMetalSolution/SubmitProvisioningConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SubmitProvisioningConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SubmitProvisioningConfigResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetProvisioningConfigRequest, ProvisioningConfig>
      getProvisioningConfigMethodDescriptor =
          MethodDescriptor.<GetProvisioningConfigRequest, ProvisioningConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.baremetalsolution.v2.BareMetalSolution/GetProvisioningConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetProvisioningConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ProvisioningConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateProvisioningConfigRequest, ProvisioningConfig>
      createProvisioningConfigMethodDescriptor =
          MethodDescriptor.<CreateProvisioningConfigRequest, ProvisioningConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.baremetalsolution.v2.BareMetalSolution/CreateProvisioningConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateProvisioningConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ProvisioningConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateProvisioningConfigRequest, ProvisioningConfig>
      updateProvisioningConfigMethodDescriptor =
          MethodDescriptor.<UpdateProvisioningConfigRequest, ProvisioningConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.baremetalsolution.v2.BareMetalSolution/UpdateProvisioningConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateProvisioningConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ProvisioningConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RenameNetworkRequest, Network>
      renameNetworkMethodDescriptor =
          MethodDescriptor.<RenameNetworkRequest, Network>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.baremetalsolution.v2.BareMetalSolution/RenameNetwork")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RenameNetworkRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Network.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListOSImagesRequest, ListOSImagesResponse>
      listOSImagesMethodDescriptor =
          MethodDescriptor.<ListOSImagesRequest, ListOSImagesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.baremetalsolution.v2.BareMetalSolution/ListOSImages")
              .setRequestMarshaller(ProtoUtils.marshaller(ListOSImagesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListOSImagesResponse.getDefaultInstance()))
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

  private final UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable;
  private final UnaryCallable<ListInstancesRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable;
  private final UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable;
  private final UnaryCallable<UpdateInstanceRequest, Operation> updateInstanceCallable;
  private final OperationCallable<UpdateInstanceRequest, Instance, OperationMetadata>
      updateInstanceOperationCallable;
  private final UnaryCallable<RenameInstanceRequest, Instance> renameInstanceCallable;
  private final UnaryCallable<ResetInstanceRequest, Operation> resetInstanceCallable;
  private final OperationCallable<ResetInstanceRequest, ResetInstanceResponse, OperationMetadata>
      resetInstanceOperationCallable;
  private final UnaryCallable<StartInstanceRequest, Operation> startInstanceCallable;
  private final OperationCallable<StartInstanceRequest, StartInstanceResponse, OperationMetadata>
      startInstanceOperationCallable;
  private final UnaryCallable<StopInstanceRequest, Operation> stopInstanceCallable;
  private final OperationCallable<StopInstanceRequest, StopInstanceResponse, OperationMetadata>
      stopInstanceOperationCallable;
  private final UnaryCallable<EnableInteractiveSerialConsoleRequest, Operation>
      enableInteractiveSerialConsoleCallable;
  private final OperationCallable<
          EnableInteractiveSerialConsoleRequest,
          EnableInteractiveSerialConsoleResponse,
          OperationMetadata>
      enableInteractiveSerialConsoleOperationCallable;
  private final UnaryCallable<DisableInteractiveSerialConsoleRequest, Operation>
      disableInteractiveSerialConsoleCallable;
  private final OperationCallable<
          DisableInteractiveSerialConsoleRequest,
          DisableInteractiveSerialConsoleResponse,
          OperationMetadata>
      disableInteractiveSerialConsoleOperationCallable;
  private final UnaryCallable<DetachLunRequest, Operation> detachLunCallable;
  private final OperationCallable<DetachLunRequest, Instance, OperationMetadata>
      detachLunOperationCallable;
  private final UnaryCallable<ListSSHKeysRequest, ListSSHKeysResponse> listSSHKeysCallable;
  private final UnaryCallable<ListSSHKeysRequest, ListSSHKeysPagedResponse>
      listSSHKeysPagedCallable;
  private final UnaryCallable<CreateSSHKeyRequest, SSHKey> createSSHKeyCallable;
  private final UnaryCallable<DeleteSSHKeyRequest, Empty> deleteSSHKeyCallable;
  private final UnaryCallable<ListVolumesRequest, ListVolumesResponse> listVolumesCallable;
  private final UnaryCallable<ListVolumesRequest, ListVolumesPagedResponse>
      listVolumesPagedCallable;
  private final UnaryCallable<GetVolumeRequest, Volume> getVolumeCallable;
  private final UnaryCallable<UpdateVolumeRequest, Operation> updateVolumeCallable;
  private final OperationCallable<UpdateVolumeRequest, Volume, OperationMetadata>
      updateVolumeOperationCallable;
  private final UnaryCallable<RenameVolumeRequest, Volume> renameVolumeCallable;
  private final UnaryCallable<EvictVolumeRequest, Operation> evictVolumeCallable;
  private final OperationCallable<EvictVolumeRequest, Empty, OperationMetadata>
      evictVolumeOperationCallable;
  private final UnaryCallable<ResizeVolumeRequest, Operation> resizeVolumeCallable;
  private final OperationCallable<ResizeVolumeRequest, Volume, OperationMetadata>
      resizeVolumeOperationCallable;
  private final UnaryCallable<ListNetworksRequest, ListNetworksResponse> listNetworksCallable;
  private final UnaryCallable<ListNetworksRequest, ListNetworksPagedResponse>
      listNetworksPagedCallable;
  private final UnaryCallable<ListNetworkUsageRequest, ListNetworkUsageResponse>
      listNetworkUsageCallable;
  private final UnaryCallable<GetNetworkRequest, Network> getNetworkCallable;
  private final UnaryCallable<UpdateNetworkRequest, Operation> updateNetworkCallable;
  private final OperationCallable<UpdateNetworkRequest, Network, OperationMetadata>
      updateNetworkOperationCallable;
  private final UnaryCallable<CreateVolumeSnapshotRequest, VolumeSnapshot>
      createVolumeSnapshotCallable;
  private final UnaryCallable<RestoreVolumeSnapshotRequest, Operation>
      restoreVolumeSnapshotCallable;
  private final OperationCallable<RestoreVolumeSnapshotRequest, VolumeSnapshot, OperationMetadata>
      restoreVolumeSnapshotOperationCallable;
  private final UnaryCallable<DeleteVolumeSnapshotRequest, Empty> deleteVolumeSnapshotCallable;
  private final UnaryCallable<GetVolumeSnapshotRequest, VolumeSnapshot> getVolumeSnapshotCallable;
  private final UnaryCallable<ListVolumeSnapshotsRequest, ListVolumeSnapshotsResponse>
      listVolumeSnapshotsCallable;
  private final UnaryCallable<ListVolumeSnapshotsRequest, ListVolumeSnapshotsPagedResponse>
      listVolumeSnapshotsPagedCallable;
  private final UnaryCallable<GetLunRequest, Lun> getLunCallable;
  private final UnaryCallable<ListLunsRequest, ListLunsResponse> listLunsCallable;
  private final UnaryCallable<ListLunsRequest, ListLunsPagedResponse> listLunsPagedCallable;
  private final UnaryCallable<EvictLunRequest, Operation> evictLunCallable;
  private final OperationCallable<EvictLunRequest, Empty, OperationMetadata>
      evictLunOperationCallable;
  private final UnaryCallable<GetNfsShareRequest, NfsShare> getNfsShareCallable;
  private final UnaryCallable<ListNfsSharesRequest, ListNfsSharesResponse> listNfsSharesCallable;
  private final UnaryCallable<ListNfsSharesRequest, ListNfsSharesPagedResponse>
      listNfsSharesPagedCallable;
  private final UnaryCallable<UpdateNfsShareRequest, Operation> updateNfsShareCallable;
  private final OperationCallable<UpdateNfsShareRequest, NfsShare, OperationMetadata>
      updateNfsShareOperationCallable;
  private final UnaryCallable<CreateNfsShareRequest, Operation> createNfsShareCallable;
  private final OperationCallable<CreateNfsShareRequest, NfsShare, OperationMetadata>
      createNfsShareOperationCallable;
  private final UnaryCallable<RenameNfsShareRequest, NfsShare> renameNfsShareCallable;
  private final UnaryCallable<DeleteNfsShareRequest, Operation> deleteNfsShareCallable;
  private final OperationCallable<DeleteNfsShareRequest, Empty, OperationMetadata>
      deleteNfsShareOperationCallable;
  private final UnaryCallable<ListProvisioningQuotasRequest, ListProvisioningQuotasResponse>
      listProvisioningQuotasCallable;
  private final UnaryCallable<ListProvisioningQuotasRequest, ListProvisioningQuotasPagedResponse>
      listProvisioningQuotasPagedCallable;
  private final UnaryCallable<SubmitProvisioningConfigRequest, SubmitProvisioningConfigResponse>
      submitProvisioningConfigCallable;
  private final UnaryCallable<GetProvisioningConfigRequest, ProvisioningConfig>
      getProvisioningConfigCallable;
  private final UnaryCallable<CreateProvisioningConfigRequest, ProvisioningConfig>
      createProvisioningConfigCallable;
  private final UnaryCallable<UpdateProvisioningConfigRequest, ProvisioningConfig>
      updateProvisioningConfigCallable;
  private final UnaryCallable<RenameNetworkRequest, Network> renameNetworkCallable;
  private final UnaryCallable<ListOSImagesRequest, ListOSImagesResponse> listOSImagesCallable;
  private final UnaryCallable<ListOSImagesRequest, ListOSImagesPagedResponse>
      listOSImagesPagedCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcBareMetalSolutionStub create(BareMetalSolutionStubSettings settings)
      throws IOException {
    return new GrpcBareMetalSolutionStub(settings, ClientContext.create(settings));
  }

  public static final GrpcBareMetalSolutionStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcBareMetalSolutionStub(
        BareMetalSolutionStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcBareMetalSolutionStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcBareMetalSolutionStub(
        BareMetalSolutionStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcBareMetalSolutionStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcBareMetalSolutionStub(
      BareMetalSolutionStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcBareMetalSolutionCallableFactory());
  }

  /**
   * Constructs an instance of GrpcBareMetalSolutionStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcBareMetalSolutionStub(
      BareMetalSolutionStubSettings settings,
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
    GrpcCallSettings<RenameInstanceRequest, Instance> renameInstanceTransportSettings =
        GrpcCallSettings.<RenameInstanceRequest, Instance>newBuilder()
            .setMethodDescriptor(renameInstanceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ResetInstanceRequest, Operation> resetInstanceTransportSettings =
        GrpcCallSettings.<ResetInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(resetInstanceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<StartInstanceRequest, Operation> startInstanceTransportSettings =
        GrpcCallSettings.<StartInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(startInstanceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<StopInstanceRequest, Operation> stopInstanceTransportSettings =
        GrpcCallSettings.<StopInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(stopInstanceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<EnableInteractiveSerialConsoleRequest, Operation>
        enableInteractiveSerialConsoleTransportSettings =
            GrpcCallSettings.<EnableInteractiveSerialConsoleRequest, Operation>newBuilder()
                .setMethodDescriptor(enableInteractiveSerialConsoleMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DisableInteractiveSerialConsoleRequest, Operation>
        disableInteractiveSerialConsoleTransportSettings =
            GrpcCallSettings.<DisableInteractiveSerialConsoleRequest, Operation>newBuilder()
                .setMethodDescriptor(disableInteractiveSerialConsoleMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DetachLunRequest, Operation> detachLunTransportSettings =
        GrpcCallSettings.<DetachLunRequest, Operation>newBuilder()
            .setMethodDescriptor(detachLunMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("instance", String.valueOf(request.getInstance()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListSSHKeysRequest, ListSSHKeysResponse> listSSHKeysTransportSettings =
        GrpcCallSettings.<ListSSHKeysRequest, ListSSHKeysResponse>newBuilder()
            .setMethodDescriptor(listSSHKeysMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateSSHKeyRequest, SSHKey> createSSHKeyTransportSettings =
        GrpcCallSettings.<CreateSSHKeyRequest, SSHKey>newBuilder()
            .setMethodDescriptor(createSSHKeyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteSSHKeyRequest, Empty> deleteSSHKeyTransportSettings =
        GrpcCallSettings.<DeleteSSHKeyRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteSSHKeyMethodDescriptor)
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
    GrpcCallSettings<RenameVolumeRequest, Volume> renameVolumeTransportSettings =
        GrpcCallSettings.<RenameVolumeRequest, Volume>newBuilder()
            .setMethodDescriptor(renameVolumeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<EvictVolumeRequest, Operation> evictVolumeTransportSettings =
        GrpcCallSettings.<EvictVolumeRequest, Operation>newBuilder()
            .setMethodDescriptor(evictVolumeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ResizeVolumeRequest, Operation> resizeVolumeTransportSettings =
        GrpcCallSettings.<ResizeVolumeRequest, Operation>newBuilder()
            .setMethodDescriptor(resizeVolumeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("volume", String.valueOf(request.getVolume()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListNetworksRequest, ListNetworksResponse> listNetworksTransportSettings =
        GrpcCallSettings.<ListNetworksRequest, ListNetworksResponse>newBuilder()
            .setMethodDescriptor(listNetworksMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListNetworkUsageRequest, ListNetworkUsageResponse>
        listNetworkUsageTransportSettings =
            GrpcCallSettings.<ListNetworkUsageRequest, ListNetworkUsageResponse>newBuilder()
                .setMethodDescriptor(listNetworkUsageMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("location", String.valueOf(request.getLocation()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetNetworkRequest, Network> getNetworkTransportSettings =
        GrpcCallSettings.<GetNetworkRequest, Network>newBuilder()
            .setMethodDescriptor(getNetworkMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateNetworkRequest, Operation> updateNetworkTransportSettings =
        GrpcCallSettings.<UpdateNetworkRequest, Operation>newBuilder()
            .setMethodDescriptor(updateNetworkMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("network.name", String.valueOf(request.getNetwork().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateVolumeSnapshotRequest, VolumeSnapshot>
        createVolumeSnapshotTransportSettings =
            GrpcCallSettings.<CreateVolumeSnapshotRequest, VolumeSnapshot>newBuilder()
                .setMethodDescriptor(createVolumeSnapshotMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<RestoreVolumeSnapshotRequest, Operation>
        restoreVolumeSnapshotTransportSettings =
            GrpcCallSettings.<RestoreVolumeSnapshotRequest, Operation>newBuilder()
                .setMethodDescriptor(restoreVolumeSnapshotMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("volume_snapshot", String.valueOf(request.getVolumeSnapshot()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteVolumeSnapshotRequest, Empty> deleteVolumeSnapshotTransportSettings =
        GrpcCallSettings.<DeleteVolumeSnapshotRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteVolumeSnapshotMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetVolumeSnapshotRequest, VolumeSnapshot> getVolumeSnapshotTransportSettings =
        GrpcCallSettings.<GetVolumeSnapshotRequest, VolumeSnapshot>newBuilder()
            .setMethodDescriptor(getVolumeSnapshotMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListVolumeSnapshotsRequest, ListVolumeSnapshotsResponse>
        listVolumeSnapshotsTransportSettings =
            GrpcCallSettings.<ListVolumeSnapshotsRequest, ListVolumeSnapshotsResponse>newBuilder()
                .setMethodDescriptor(listVolumeSnapshotsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetLunRequest, Lun> getLunTransportSettings =
        GrpcCallSettings.<GetLunRequest, Lun>newBuilder()
            .setMethodDescriptor(getLunMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListLunsRequest, ListLunsResponse> listLunsTransportSettings =
        GrpcCallSettings.<ListLunsRequest, ListLunsResponse>newBuilder()
            .setMethodDescriptor(listLunsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<EvictLunRequest, Operation> evictLunTransportSettings =
        GrpcCallSettings.<EvictLunRequest, Operation>newBuilder()
            .setMethodDescriptor(evictLunMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetNfsShareRequest, NfsShare> getNfsShareTransportSettings =
        GrpcCallSettings.<GetNfsShareRequest, NfsShare>newBuilder()
            .setMethodDescriptor(getNfsShareMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListNfsSharesRequest, ListNfsSharesResponse> listNfsSharesTransportSettings =
        GrpcCallSettings.<ListNfsSharesRequest, ListNfsSharesResponse>newBuilder()
            .setMethodDescriptor(listNfsSharesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateNfsShareRequest, Operation> updateNfsShareTransportSettings =
        GrpcCallSettings.<UpdateNfsShareRequest, Operation>newBuilder()
            .setMethodDescriptor(updateNfsShareMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("nfs_share.name", String.valueOf(request.getNfsShare().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateNfsShareRequest, Operation> createNfsShareTransportSettings =
        GrpcCallSettings.<CreateNfsShareRequest, Operation>newBuilder()
            .setMethodDescriptor(createNfsShareMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<RenameNfsShareRequest, NfsShare> renameNfsShareTransportSettings =
        GrpcCallSettings.<RenameNfsShareRequest, NfsShare>newBuilder()
            .setMethodDescriptor(renameNfsShareMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteNfsShareRequest, Operation> deleteNfsShareTransportSettings =
        GrpcCallSettings.<DeleteNfsShareRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteNfsShareMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListProvisioningQuotasRequest, ListProvisioningQuotasResponse>
        listProvisioningQuotasTransportSettings =
            GrpcCallSettings
                .<ListProvisioningQuotasRequest, ListProvisioningQuotasResponse>newBuilder()
                .setMethodDescriptor(listProvisioningQuotasMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<SubmitProvisioningConfigRequest, SubmitProvisioningConfigResponse>
        submitProvisioningConfigTransportSettings =
            GrpcCallSettings
                .<SubmitProvisioningConfigRequest, SubmitProvisioningConfigResponse>newBuilder()
                .setMethodDescriptor(submitProvisioningConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetProvisioningConfigRequest, ProvisioningConfig>
        getProvisioningConfigTransportSettings =
            GrpcCallSettings.<GetProvisioningConfigRequest, ProvisioningConfig>newBuilder()
                .setMethodDescriptor(getProvisioningConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateProvisioningConfigRequest, ProvisioningConfig>
        createProvisioningConfigTransportSettings =
            GrpcCallSettings.<CreateProvisioningConfigRequest, ProvisioningConfig>newBuilder()
                .setMethodDescriptor(createProvisioningConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateProvisioningConfigRequest, ProvisioningConfig>
        updateProvisioningConfigTransportSettings =
            GrpcCallSettings.<UpdateProvisioningConfigRequest, ProvisioningConfig>newBuilder()
                .setMethodDescriptor(updateProvisioningConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "provisioning_config.name",
                          String.valueOf(request.getProvisioningConfig().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<RenameNetworkRequest, Network> renameNetworkTransportSettings =
        GrpcCallSettings.<RenameNetworkRequest, Network>newBuilder()
            .setMethodDescriptor(renameNetworkMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListOSImagesRequest, ListOSImagesResponse> listOSImagesTransportSettings =
        GrpcCallSettings.<ListOSImagesRequest, ListOSImagesResponse>newBuilder()
            .setMethodDescriptor(listOSImagesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
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

    this.listInstancesCallable =
        callableFactory.createUnaryCallable(
            listInstancesTransportSettings, settings.listInstancesSettings(), clientContext);
    this.listInstancesPagedCallable =
        callableFactory.createPagedCallable(
            listInstancesTransportSettings, settings.listInstancesSettings(), clientContext);
    this.getInstanceCallable =
        callableFactory.createUnaryCallable(
            getInstanceTransportSettings, settings.getInstanceSettings(), clientContext);
    this.updateInstanceCallable =
        callableFactory.createUnaryCallable(
            updateInstanceTransportSettings, settings.updateInstanceSettings(), clientContext);
    this.updateInstanceOperationCallable =
        callableFactory.createOperationCallable(
            updateInstanceTransportSettings,
            settings.updateInstanceOperationSettings(),
            clientContext,
            operationsStub);
    this.renameInstanceCallable =
        callableFactory.createUnaryCallable(
            renameInstanceTransportSettings, settings.renameInstanceSettings(), clientContext);
    this.resetInstanceCallable =
        callableFactory.createUnaryCallable(
            resetInstanceTransportSettings, settings.resetInstanceSettings(), clientContext);
    this.resetInstanceOperationCallable =
        callableFactory.createOperationCallable(
            resetInstanceTransportSettings,
            settings.resetInstanceOperationSettings(),
            clientContext,
            operationsStub);
    this.startInstanceCallable =
        callableFactory.createUnaryCallable(
            startInstanceTransportSettings, settings.startInstanceSettings(), clientContext);
    this.startInstanceOperationCallable =
        callableFactory.createOperationCallable(
            startInstanceTransportSettings,
            settings.startInstanceOperationSettings(),
            clientContext,
            operationsStub);
    this.stopInstanceCallable =
        callableFactory.createUnaryCallable(
            stopInstanceTransportSettings, settings.stopInstanceSettings(), clientContext);
    this.stopInstanceOperationCallable =
        callableFactory.createOperationCallable(
            stopInstanceTransportSettings,
            settings.stopInstanceOperationSettings(),
            clientContext,
            operationsStub);
    this.enableInteractiveSerialConsoleCallable =
        callableFactory.createUnaryCallable(
            enableInteractiveSerialConsoleTransportSettings,
            settings.enableInteractiveSerialConsoleSettings(),
            clientContext);
    this.enableInteractiveSerialConsoleOperationCallable =
        callableFactory.createOperationCallable(
            enableInteractiveSerialConsoleTransportSettings,
            settings.enableInteractiveSerialConsoleOperationSettings(),
            clientContext,
            operationsStub);
    this.disableInteractiveSerialConsoleCallable =
        callableFactory.createUnaryCallable(
            disableInteractiveSerialConsoleTransportSettings,
            settings.disableInteractiveSerialConsoleSettings(),
            clientContext);
    this.disableInteractiveSerialConsoleOperationCallable =
        callableFactory.createOperationCallable(
            disableInteractiveSerialConsoleTransportSettings,
            settings.disableInteractiveSerialConsoleOperationSettings(),
            clientContext,
            operationsStub);
    this.detachLunCallable =
        callableFactory.createUnaryCallable(
            detachLunTransportSettings, settings.detachLunSettings(), clientContext);
    this.detachLunOperationCallable =
        callableFactory.createOperationCallable(
            detachLunTransportSettings,
            settings.detachLunOperationSettings(),
            clientContext,
            operationsStub);
    this.listSSHKeysCallable =
        callableFactory.createUnaryCallable(
            listSSHKeysTransportSettings, settings.listSSHKeysSettings(), clientContext);
    this.listSSHKeysPagedCallable =
        callableFactory.createPagedCallable(
            listSSHKeysTransportSettings, settings.listSSHKeysSettings(), clientContext);
    this.createSSHKeyCallable =
        callableFactory.createUnaryCallable(
            createSSHKeyTransportSettings, settings.createSSHKeySettings(), clientContext);
    this.deleteSSHKeyCallable =
        callableFactory.createUnaryCallable(
            deleteSSHKeyTransportSettings, settings.deleteSSHKeySettings(), clientContext);
    this.listVolumesCallable =
        callableFactory.createUnaryCallable(
            listVolumesTransportSettings, settings.listVolumesSettings(), clientContext);
    this.listVolumesPagedCallable =
        callableFactory.createPagedCallable(
            listVolumesTransportSettings, settings.listVolumesSettings(), clientContext);
    this.getVolumeCallable =
        callableFactory.createUnaryCallable(
            getVolumeTransportSettings, settings.getVolumeSettings(), clientContext);
    this.updateVolumeCallable =
        callableFactory.createUnaryCallable(
            updateVolumeTransportSettings, settings.updateVolumeSettings(), clientContext);
    this.updateVolumeOperationCallable =
        callableFactory.createOperationCallable(
            updateVolumeTransportSettings,
            settings.updateVolumeOperationSettings(),
            clientContext,
            operationsStub);
    this.renameVolumeCallable =
        callableFactory.createUnaryCallable(
            renameVolumeTransportSettings, settings.renameVolumeSettings(), clientContext);
    this.evictVolumeCallable =
        callableFactory.createUnaryCallable(
            evictVolumeTransportSettings, settings.evictVolumeSettings(), clientContext);
    this.evictVolumeOperationCallable =
        callableFactory.createOperationCallable(
            evictVolumeTransportSettings,
            settings.evictVolumeOperationSettings(),
            clientContext,
            operationsStub);
    this.resizeVolumeCallable =
        callableFactory.createUnaryCallable(
            resizeVolumeTransportSettings, settings.resizeVolumeSettings(), clientContext);
    this.resizeVolumeOperationCallable =
        callableFactory.createOperationCallable(
            resizeVolumeTransportSettings,
            settings.resizeVolumeOperationSettings(),
            clientContext,
            operationsStub);
    this.listNetworksCallable =
        callableFactory.createUnaryCallable(
            listNetworksTransportSettings, settings.listNetworksSettings(), clientContext);
    this.listNetworksPagedCallable =
        callableFactory.createPagedCallable(
            listNetworksTransportSettings, settings.listNetworksSettings(), clientContext);
    this.listNetworkUsageCallable =
        callableFactory.createUnaryCallable(
            listNetworkUsageTransportSettings, settings.listNetworkUsageSettings(), clientContext);
    this.getNetworkCallable =
        callableFactory.createUnaryCallable(
            getNetworkTransportSettings, settings.getNetworkSettings(), clientContext);
    this.updateNetworkCallable =
        callableFactory.createUnaryCallable(
            updateNetworkTransportSettings, settings.updateNetworkSettings(), clientContext);
    this.updateNetworkOperationCallable =
        callableFactory.createOperationCallable(
            updateNetworkTransportSettings,
            settings.updateNetworkOperationSettings(),
            clientContext,
            operationsStub);
    this.createVolumeSnapshotCallable =
        callableFactory.createUnaryCallable(
            createVolumeSnapshotTransportSettings,
            settings.createVolumeSnapshotSettings(),
            clientContext);
    this.restoreVolumeSnapshotCallable =
        callableFactory.createUnaryCallable(
            restoreVolumeSnapshotTransportSettings,
            settings.restoreVolumeSnapshotSettings(),
            clientContext);
    this.restoreVolumeSnapshotOperationCallable =
        callableFactory.createOperationCallable(
            restoreVolumeSnapshotTransportSettings,
            settings.restoreVolumeSnapshotOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteVolumeSnapshotCallable =
        callableFactory.createUnaryCallable(
            deleteVolumeSnapshotTransportSettings,
            settings.deleteVolumeSnapshotSettings(),
            clientContext);
    this.getVolumeSnapshotCallable =
        callableFactory.createUnaryCallable(
            getVolumeSnapshotTransportSettings,
            settings.getVolumeSnapshotSettings(),
            clientContext);
    this.listVolumeSnapshotsCallable =
        callableFactory.createUnaryCallable(
            listVolumeSnapshotsTransportSettings,
            settings.listVolumeSnapshotsSettings(),
            clientContext);
    this.listVolumeSnapshotsPagedCallable =
        callableFactory.createPagedCallable(
            listVolumeSnapshotsTransportSettings,
            settings.listVolumeSnapshotsSettings(),
            clientContext);
    this.getLunCallable =
        callableFactory.createUnaryCallable(
            getLunTransportSettings, settings.getLunSettings(), clientContext);
    this.listLunsCallable =
        callableFactory.createUnaryCallable(
            listLunsTransportSettings, settings.listLunsSettings(), clientContext);
    this.listLunsPagedCallable =
        callableFactory.createPagedCallable(
            listLunsTransportSettings, settings.listLunsSettings(), clientContext);
    this.evictLunCallable =
        callableFactory.createUnaryCallable(
            evictLunTransportSettings, settings.evictLunSettings(), clientContext);
    this.evictLunOperationCallable =
        callableFactory.createOperationCallable(
            evictLunTransportSettings,
            settings.evictLunOperationSettings(),
            clientContext,
            operationsStub);
    this.getNfsShareCallable =
        callableFactory.createUnaryCallable(
            getNfsShareTransportSettings, settings.getNfsShareSettings(), clientContext);
    this.listNfsSharesCallable =
        callableFactory.createUnaryCallable(
            listNfsSharesTransportSettings, settings.listNfsSharesSettings(), clientContext);
    this.listNfsSharesPagedCallable =
        callableFactory.createPagedCallable(
            listNfsSharesTransportSettings, settings.listNfsSharesSettings(), clientContext);
    this.updateNfsShareCallable =
        callableFactory.createUnaryCallable(
            updateNfsShareTransportSettings, settings.updateNfsShareSettings(), clientContext);
    this.updateNfsShareOperationCallable =
        callableFactory.createOperationCallable(
            updateNfsShareTransportSettings,
            settings.updateNfsShareOperationSettings(),
            clientContext,
            operationsStub);
    this.createNfsShareCallable =
        callableFactory.createUnaryCallable(
            createNfsShareTransportSettings, settings.createNfsShareSettings(), clientContext);
    this.createNfsShareOperationCallable =
        callableFactory.createOperationCallable(
            createNfsShareTransportSettings,
            settings.createNfsShareOperationSettings(),
            clientContext,
            operationsStub);
    this.renameNfsShareCallable =
        callableFactory.createUnaryCallable(
            renameNfsShareTransportSettings, settings.renameNfsShareSettings(), clientContext);
    this.deleteNfsShareCallable =
        callableFactory.createUnaryCallable(
            deleteNfsShareTransportSettings, settings.deleteNfsShareSettings(), clientContext);
    this.deleteNfsShareOperationCallable =
        callableFactory.createOperationCallable(
            deleteNfsShareTransportSettings,
            settings.deleteNfsShareOperationSettings(),
            clientContext,
            operationsStub);
    this.listProvisioningQuotasCallable =
        callableFactory.createUnaryCallable(
            listProvisioningQuotasTransportSettings,
            settings.listProvisioningQuotasSettings(),
            clientContext);
    this.listProvisioningQuotasPagedCallable =
        callableFactory.createPagedCallable(
            listProvisioningQuotasTransportSettings,
            settings.listProvisioningQuotasSettings(),
            clientContext);
    this.submitProvisioningConfigCallable =
        callableFactory.createUnaryCallable(
            submitProvisioningConfigTransportSettings,
            settings.submitProvisioningConfigSettings(),
            clientContext);
    this.getProvisioningConfigCallable =
        callableFactory.createUnaryCallable(
            getProvisioningConfigTransportSettings,
            settings.getProvisioningConfigSettings(),
            clientContext);
    this.createProvisioningConfigCallable =
        callableFactory.createUnaryCallable(
            createProvisioningConfigTransportSettings,
            settings.createProvisioningConfigSettings(),
            clientContext);
    this.updateProvisioningConfigCallable =
        callableFactory.createUnaryCallable(
            updateProvisioningConfigTransportSettings,
            settings.updateProvisioningConfigSettings(),
            clientContext);
    this.renameNetworkCallable =
        callableFactory.createUnaryCallable(
            renameNetworkTransportSettings, settings.renameNetworkSettings(), clientContext);
    this.listOSImagesCallable =
        callableFactory.createUnaryCallable(
            listOSImagesTransportSettings, settings.listOSImagesSettings(), clientContext);
    this.listOSImagesPagedCallable =
        callableFactory.createPagedCallable(
            listOSImagesTransportSettings, settings.listOSImagesSettings(), clientContext);
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
  public UnaryCallable<UpdateInstanceRequest, Operation> updateInstanceCallable() {
    return updateInstanceCallable;
  }

  @Override
  public OperationCallable<UpdateInstanceRequest, Instance, OperationMetadata>
      updateInstanceOperationCallable() {
    return updateInstanceOperationCallable;
  }

  @Override
  public UnaryCallable<RenameInstanceRequest, Instance> renameInstanceCallable() {
    return renameInstanceCallable;
  }

  @Override
  public UnaryCallable<ResetInstanceRequest, Operation> resetInstanceCallable() {
    return resetInstanceCallable;
  }

  @Override
  public OperationCallable<ResetInstanceRequest, ResetInstanceResponse, OperationMetadata>
      resetInstanceOperationCallable() {
    return resetInstanceOperationCallable;
  }

  @Override
  public UnaryCallable<StartInstanceRequest, Operation> startInstanceCallable() {
    return startInstanceCallable;
  }

  @Override
  public OperationCallable<StartInstanceRequest, StartInstanceResponse, OperationMetadata>
      startInstanceOperationCallable() {
    return startInstanceOperationCallable;
  }

  @Override
  public UnaryCallable<StopInstanceRequest, Operation> stopInstanceCallable() {
    return stopInstanceCallable;
  }

  @Override
  public OperationCallable<StopInstanceRequest, StopInstanceResponse, OperationMetadata>
      stopInstanceOperationCallable() {
    return stopInstanceOperationCallable;
  }

  @Override
  public UnaryCallable<EnableInteractiveSerialConsoleRequest, Operation>
      enableInteractiveSerialConsoleCallable() {
    return enableInteractiveSerialConsoleCallable;
  }

  @Override
  public OperationCallable<
          EnableInteractiveSerialConsoleRequest,
          EnableInteractiveSerialConsoleResponse,
          OperationMetadata>
      enableInteractiveSerialConsoleOperationCallable() {
    return enableInteractiveSerialConsoleOperationCallable;
  }

  @Override
  public UnaryCallable<DisableInteractiveSerialConsoleRequest, Operation>
      disableInteractiveSerialConsoleCallable() {
    return disableInteractiveSerialConsoleCallable;
  }

  @Override
  public OperationCallable<
          DisableInteractiveSerialConsoleRequest,
          DisableInteractiveSerialConsoleResponse,
          OperationMetadata>
      disableInteractiveSerialConsoleOperationCallable() {
    return disableInteractiveSerialConsoleOperationCallable;
  }

  @Override
  public UnaryCallable<DetachLunRequest, Operation> detachLunCallable() {
    return detachLunCallable;
  }

  @Override
  public OperationCallable<DetachLunRequest, Instance, OperationMetadata>
      detachLunOperationCallable() {
    return detachLunOperationCallable;
  }

  @Override
  public UnaryCallable<ListSSHKeysRequest, ListSSHKeysResponse> listSSHKeysCallable() {
    return listSSHKeysCallable;
  }

  @Override
  public UnaryCallable<ListSSHKeysRequest, ListSSHKeysPagedResponse> listSSHKeysPagedCallable() {
    return listSSHKeysPagedCallable;
  }

  @Override
  public UnaryCallable<CreateSSHKeyRequest, SSHKey> createSSHKeyCallable() {
    return createSSHKeyCallable;
  }

  @Override
  public UnaryCallable<DeleteSSHKeyRequest, Empty> deleteSSHKeyCallable() {
    return deleteSSHKeyCallable;
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
  public UnaryCallable<UpdateVolumeRequest, Operation> updateVolumeCallable() {
    return updateVolumeCallable;
  }

  @Override
  public OperationCallable<UpdateVolumeRequest, Volume, OperationMetadata>
      updateVolumeOperationCallable() {
    return updateVolumeOperationCallable;
  }

  @Override
  public UnaryCallable<RenameVolumeRequest, Volume> renameVolumeCallable() {
    return renameVolumeCallable;
  }

  @Override
  public UnaryCallable<EvictVolumeRequest, Operation> evictVolumeCallable() {
    return evictVolumeCallable;
  }

  @Override
  public OperationCallable<EvictVolumeRequest, Empty, OperationMetadata>
      evictVolumeOperationCallable() {
    return evictVolumeOperationCallable;
  }

  @Override
  public UnaryCallable<ResizeVolumeRequest, Operation> resizeVolumeCallable() {
    return resizeVolumeCallable;
  }

  @Override
  public OperationCallable<ResizeVolumeRequest, Volume, OperationMetadata>
      resizeVolumeOperationCallable() {
    return resizeVolumeOperationCallable;
  }

  @Override
  public UnaryCallable<ListNetworksRequest, ListNetworksResponse> listNetworksCallable() {
    return listNetworksCallable;
  }

  @Override
  public UnaryCallable<ListNetworksRequest, ListNetworksPagedResponse> listNetworksPagedCallable() {
    return listNetworksPagedCallable;
  }

  @Override
  public UnaryCallable<ListNetworkUsageRequest, ListNetworkUsageResponse>
      listNetworkUsageCallable() {
    return listNetworkUsageCallable;
  }

  @Override
  public UnaryCallable<GetNetworkRequest, Network> getNetworkCallable() {
    return getNetworkCallable;
  }

  @Override
  public UnaryCallable<UpdateNetworkRequest, Operation> updateNetworkCallable() {
    return updateNetworkCallable;
  }

  @Override
  public OperationCallable<UpdateNetworkRequest, Network, OperationMetadata>
      updateNetworkOperationCallable() {
    return updateNetworkOperationCallable;
  }

  @Override
  public UnaryCallable<CreateVolumeSnapshotRequest, VolumeSnapshot> createVolumeSnapshotCallable() {
    return createVolumeSnapshotCallable;
  }

  @Override
  public UnaryCallable<RestoreVolumeSnapshotRequest, Operation> restoreVolumeSnapshotCallable() {
    return restoreVolumeSnapshotCallable;
  }

  @Override
  public OperationCallable<RestoreVolumeSnapshotRequest, VolumeSnapshot, OperationMetadata>
      restoreVolumeSnapshotOperationCallable() {
    return restoreVolumeSnapshotOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteVolumeSnapshotRequest, Empty> deleteVolumeSnapshotCallable() {
    return deleteVolumeSnapshotCallable;
  }

  @Override
  public UnaryCallable<GetVolumeSnapshotRequest, VolumeSnapshot> getVolumeSnapshotCallable() {
    return getVolumeSnapshotCallable;
  }

  @Override
  public UnaryCallable<ListVolumeSnapshotsRequest, ListVolumeSnapshotsResponse>
      listVolumeSnapshotsCallable() {
    return listVolumeSnapshotsCallable;
  }

  @Override
  public UnaryCallable<ListVolumeSnapshotsRequest, ListVolumeSnapshotsPagedResponse>
      listVolumeSnapshotsPagedCallable() {
    return listVolumeSnapshotsPagedCallable;
  }

  @Override
  public UnaryCallable<GetLunRequest, Lun> getLunCallable() {
    return getLunCallable;
  }

  @Override
  public UnaryCallable<ListLunsRequest, ListLunsResponse> listLunsCallable() {
    return listLunsCallable;
  }

  @Override
  public UnaryCallable<ListLunsRequest, ListLunsPagedResponse> listLunsPagedCallable() {
    return listLunsPagedCallable;
  }

  @Override
  public UnaryCallable<EvictLunRequest, Operation> evictLunCallable() {
    return evictLunCallable;
  }

  @Override
  public OperationCallable<EvictLunRequest, Empty, OperationMetadata> evictLunOperationCallable() {
    return evictLunOperationCallable;
  }

  @Override
  public UnaryCallable<GetNfsShareRequest, NfsShare> getNfsShareCallable() {
    return getNfsShareCallable;
  }

  @Override
  public UnaryCallable<ListNfsSharesRequest, ListNfsSharesResponse> listNfsSharesCallable() {
    return listNfsSharesCallable;
  }

  @Override
  public UnaryCallable<ListNfsSharesRequest, ListNfsSharesPagedResponse>
      listNfsSharesPagedCallable() {
    return listNfsSharesPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateNfsShareRequest, Operation> updateNfsShareCallable() {
    return updateNfsShareCallable;
  }

  @Override
  public OperationCallable<UpdateNfsShareRequest, NfsShare, OperationMetadata>
      updateNfsShareOperationCallable() {
    return updateNfsShareOperationCallable;
  }

  @Override
  public UnaryCallable<CreateNfsShareRequest, Operation> createNfsShareCallable() {
    return createNfsShareCallable;
  }

  @Override
  public OperationCallable<CreateNfsShareRequest, NfsShare, OperationMetadata>
      createNfsShareOperationCallable() {
    return createNfsShareOperationCallable;
  }

  @Override
  public UnaryCallable<RenameNfsShareRequest, NfsShare> renameNfsShareCallable() {
    return renameNfsShareCallable;
  }

  @Override
  public UnaryCallable<DeleteNfsShareRequest, Operation> deleteNfsShareCallable() {
    return deleteNfsShareCallable;
  }

  @Override
  public OperationCallable<DeleteNfsShareRequest, Empty, OperationMetadata>
      deleteNfsShareOperationCallable() {
    return deleteNfsShareOperationCallable;
  }

  @Override
  public UnaryCallable<ListProvisioningQuotasRequest, ListProvisioningQuotasResponse>
      listProvisioningQuotasCallable() {
    return listProvisioningQuotasCallable;
  }

  @Override
  public UnaryCallable<ListProvisioningQuotasRequest, ListProvisioningQuotasPagedResponse>
      listProvisioningQuotasPagedCallable() {
    return listProvisioningQuotasPagedCallable;
  }

  @Override
  public UnaryCallable<SubmitProvisioningConfigRequest, SubmitProvisioningConfigResponse>
      submitProvisioningConfigCallable() {
    return submitProvisioningConfigCallable;
  }

  @Override
  public UnaryCallable<GetProvisioningConfigRequest, ProvisioningConfig>
      getProvisioningConfigCallable() {
    return getProvisioningConfigCallable;
  }

  @Override
  public UnaryCallable<CreateProvisioningConfigRequest, ProvisioningConfig>
      createProvisioningConfigCallable() {
    return createProvisioningConfigCallable;
  }

  @Override
  public UnaryCallable<UpdateProvisioningConfigRequest, ProvisioningConfig>
      updateProvisioningConfigCallable() {
    return updateProvisioningConfigCallable;
  }

  @Override
  public UnaryCallable<RenameNetworkRequest, Network> renameNetworkCallable() {
    return renameNetworkCallable;
  }

  @Override
  public UnaryCallable<ListOSImagesRequest, ListOSImagesResponse> listOSImagesCallable() {
    return listOSImagesCallable;
  }

  @Override
  public UnaryCallable<ListOSImagesRequest, ListOSImagesPagedResponse> listOSImagesPagedCallable() {
    return listOSImagesPagedCallable;
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
