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

package com.google.cloud.baremetalsolution.v2.stub;

import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListInstancesPagedResponse;
import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListLunsPagedResponse;
import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListNetworksPagedResponse;
import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListSnapshotSchedulePoliciesPagedResponse;
import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListVolumeSnapshotsPagedResponse;
import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListVolumesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.baremetalsolution.v2.CreateSnapshotSchedulePolicyRequest;
import com.google.cloud.baremetalsolution.v2.CreateVolumeSnapshotRequest;
import com.google.cloud.baremetalsolution.v2.DeleteSnapshotSchedulePolicyRequest;
import com.google.cloud.baremetalsolution.v2.DeleteVolumeSnapshotRequest;
import com.google.cloud.baremetalsolution.v2.GetInstanceRequest;
import com.google.cloud.baremetalsolution.v2.GetLunRequest;
import com.google.cloud.baremetalsolution.v2.GetNetworkRequest;
import com.google.cloud.baremetalsolution.v2.GetSnapshotSchedulePolicyRequest;
import com.google.cloud.baremetalsolution.v2.GetVolumeRequest;
import com.google.cloud.baremetalsolution.v2.GetVolumeSnapshotRequest;
import com.google.cloud.baremetalsolution.v2.Instance;
import com.google.cloud.baremetalsolution.v2.ListInstancesRequest;
import com.google.cloud.baremetalsolution.v2.ListInstancesResponse;
import com.google.cloud.baremetalsolution.v2.ListLunsRequest;
import com.google.cloud.baremetalsolution.v2.ListLunsResponse;
import com.google.cloud.baremetalsolution.v2.ListNetworksRequest;
import com.google.cloud.baremetalsolution.v2.ListNetworksResponse;
import com.google.cloud.baremetalsolution.v2.ListSnapshotSchedulePoliciesRequest;
import com.google.cloud.baremetalsolution.v2.ListSnapshotSchedulePoliciesResponse;
import com.google.cloud.baremetalsolution.v2.ListVolumeSnapshotsRequest;
import com.google.cloud.baremetalsolution.v2.ListVolumeSnapshotsResponse;
import com.google.cloud.baremetalsolution.v2.ListVolumesRequest;
import com.google.cloud.baremetalsolution.v2.ListVolumesResponse;
import com.google.cloud.baremetalsolution.v2.Lun;
import com.google.cloud.baremetalsolution.v2.Network;
import com.google.cloud.baremetalsolution.v2.OperationMetadata;
import com.google.cloud.baremetalsolution.v2.ResetInstanceRequest;
import com.google.cloud.baremetalsolution.v2.ResetInstanceResponse;
import com.google.cloud.baremetalsolution.v2.RestoreVolumeSnapshotRequest;
import com.google.cloud.baremetalsolution.v2.SnapshotSchedulePolicy;
import com.google.cloud.baremetalsolution.v2.UpdateSnapshotSchedulePolicyRequest;
import com.google.cloud.baremetalsolution.v2.UpdateVolumeRequest;
import com.google.cloud.baremetalsolution.v2.Volume;
import com.google.cloud.baremetalsolution.v2.VolumeSnapshot;
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

  private static final MethodDescriptor<ListNetworksRequest, ListNetworksResponse>
      listNetworksMethodDescriptor =
          MethodDescriptor.<ListNetworksRequest, ListNetworksResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.baremetalsolution.v2.BareMetalSolution/ListNetworks")
              .setRequestMarshaller(ProtoUtils.marshaller(ListNetworksRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListNetworksResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetNetworkRequest, Network> getNetworkMethodDescriptor =
      MethodDescriptor.<GetNetworkRequest, Network>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.baremetalsolution.v2.BareMetalSolution/GetNetwork")
          .setRequestMarshaller(ProtoUtils.marshaller(GetNetworkRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Network.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<
          ListSnapshotSchedulePoliciesRequest, ListSnapshotSchedulePoliciesResponse>
      listSnapshotSchedulePoliciesMethodDescriptor =
          MethodDescriptor
              .<ListSnapshotSchedulePoliciesRequest, ListSnapshotSchedulePoliciesResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.baremetalsolution.v2.BareMetalSolution/ListSnapshotSchedulePolicies")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListSnapshotSchedulePoliciesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListSnapshotSchedulePoliciesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetSnapshotSchedulePolicyRequest, SnapshotSchedulePolicy>
      getSnapshotSchedulePolicyMethodDescriptor =
          MethodDescriptor.<GetSnapshotSchedulePolicyRequest, SnapshotSchedulePolicy>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.baremetalsolution.v2.BareMetalSolution/GetSnapshotSchedulePolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetSnapshotSchedulePolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SnapshotSchedulePolicy.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateSnapshotSchedulePolicyRequest, SnapshotSchedulePolicy>
      createSnapshotSchedulePolicyMethodDescriptor =
          MethodDescriptor.<CreateSnapshotSchedulePolicyRequest, SnapshotSchedulePolicy>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.baremetalsolution.v2.BareMetalSolution/CreateSnapshotSchedulePolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateSnapshotSchedulePolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SnapshotSchedulePolicy.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateSnapshotSchedulePolicyRequest, SnapshotSchedulePolicy>
      updateSnapshotSchedulePolicyMethodDescriptor =
          MethodDescriptor.<UpdateSnapshotSchedulePolicyRequest, SnapshotSchedulePolicy>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.baremetalsolution.v2.BareMetalSolution/UpdateSnapshotSchedulePolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateSnapshotSchedulePolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SnapshotSchedulePolicy.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteSnapshotSchedulePolicyRequest, Empty>
      deleteSnapshotSchedulePolicyMethodDescriptor =
          MethodDescriptor.<DeleteSnapshotSchedulePolicyRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.baremetalsolution.v2.BareMetalSolution/DeleteSnapshotSchedulePolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteSnapshotSchedulePolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
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

  private final UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable;
  private final UnaryCallable<ListInstancesRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable;
  private final UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable;
  private final UnaryCallable<ResetInstanceRequest, Operation> resetInstanceCallable;
  private final OperationCallable<ResetInstanceRequest, ResetInstanceResponse, OperationMetadata>
      resetInstanceOperationCallable;
  private final UnaryCallable<ListVolumesRequest, ListVolumesResponse> listVolumesCallable;
  private final UnaryCallable<ListVolumesRequest, ListVolumesPagedResponse>
      listVolumesPagedCallable;
  private final UnaryCallable<GetVolumeRequest, Volume> getVolumeCallable;
  private final UnaryCallable<UpdateVolumeRequest, Operation> updateVolumeCallable;
  private final OperationCallable<UpdateVolumeRequest, Volume, OperationMetadata>
      updateVolumeOperationCallable;
  private final UnaryCallable<ListNetworksRequest, ListNetworksResponse> listNetworksCallable;
  private final UnaryCallable<ListNetworksRequest, ListNetworksPagedResponse>
      listNetworksPagedCallable;
  private final UnaryCallable<GetNetworkRequest, Network> getNetworkCallable;
  private final UnaryCallable<
          ListSnapshotSchedulePoliciesRequest, ListSnapshotSchedulePoliciesResponse>
      listSnapshotSchedulePoliciesCallable;
  private final UnaryCallable<
          ListSnapshotSchedulePoliciesRequest, ListSnapshotSchedulePoliciesPagedResponse>
      listSnapshotSchedulePoliciesPagedCallable;
  private final UnaryCallable<GetSnapshotSchedulePolicyRequest, SnapshotSchedulePolicy>
      getSnapshotSchedulePolicyCallable;
  private final UnaryCallable<CreateSnapshotSchedulePolicyRequest, SnapshotSchedulePolicy>
      createSnapshotSchedulePolicyCallable;
  private final UnaryCallable<UpdateSnapshotSchedulePolicyRequest, SnapshotSchedulePolicy>
      updateSnapshotSchedulePolicyCallable;
  private final UnaryCallable<DeleteSnapshotSchedulePolicyRequest, Empty>
      deleteSnapshotSchedulePolicyCallable;
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
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetInstanceRequest, Instance> getInstanceTransportSettings =
        GrpcCallSettings.<GetInstanceRequest, Instance>newBuilder()
            .setMethodDescriptor(getInstanceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ResetInstanceRequest, Operation> resetInstanceTransportSettings =
        GrpcCallSettings.<ResetInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(resetInstanceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListVolumesRequest, ListVolumesResponse> listVolumesTransportSettings =
        GrpcCallSettings.<ListVolumesRequest, ListVolumesResponse>newBuilder()
            .setMethodDescriptor(listVolumesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetVolumeRequest, Volume> getVolumeTransportSettings =
        GrpcCallSettings.<GetVolumeRequest, Volume>newBuilder()
            .setMethodDescriptor(getVolumeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateVolumeRequest, Operation> updateVolumeTransportSettings =
        GrpcCallSettings.<UpdateVolumeRequest, Operation>newBuilder()
            .setMethodDescriptor(updateVolumeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("volume.name", String.valueOf(request.getVolume().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListNetworksRequest, ListNetworksResponse> listNetworksTransportSettings =
        GrpcCallSettings.<ListNetworksRequest, ListNetworksResponse>newBuilder()
            .setMethodDescriptor(listNetworksMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetNetworkRequest, Network> getNetworkTransportSettings =
        GrpcCallSettings.<GetNetworkRequest, Network>newBuilder()
            .setMethodDescriptor(getNetworkMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListSnapshotSchedulePoliciesRequest, ListSnapshotSchedulePoliciesResponse>
        listSnapshotSchedulePoliciesTransportSettings =
            GrpcCallSettings
                .<ListSnapshotSchedulePoliciesRequest, ListSnapshotSchedulePoliciesResponse>
                    newBuilder()
                .setMethodDescriptor(listSnapshotSchedulePoliciesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetSnapshotSchedulePolicyRequest, SnapshotSchedulePolicy>
        getSnapshotSchedulePolicyTransportSettings =
            GrpcCallSettings.<GetSnapshotSchedulePolicyRequest, SnapshotSchedulePolicy>newBuilder()
                .setMethodDescriptor(getSnapshotSchedulePolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<CreateSnapshotSchedulePolicyRequest, SnapshotSchedulePolicy>
        createSnapshotSchedulePolicyTransportSettings =
            GrpcCallSettings
                .<CreateSnapshotSchedulePolicyRequest, SnapshotSchedulePolicy>newBuilder()
                .setMethodDescriptor(createSnapshotSchedulePolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UpdateSnapshotSchedulePolicyRequest, SnapshotSchedulePolicy>
        updateSnapshotSchedulePolicyTransportSettings =
            GrpcCallSettings
                .<UpdateSnapshotSchedulePolicyRequest, SnapshotSchedulePolicy>newBuilder()
                .setMethodDescriptor(updateSnapshotSchedulePolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put(
                          "snapshot_schedule_policy.name",
                          String.valueOf(request.getSnapshotSchedulePolicy().getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteSnapshotSchedulePolicyRequest, Empty>
        deleteSnapshotSchedulePolicyTransportSettings =
            GrpcCallSettings.<DeleteSnapshotSchedulePolicyRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteSnapshotSchedulePolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<CreateVolumeSnapshotRequest, VolumeSnapshot>
        createVolumeSnapshotTransportSettings =
            GrpcCallSettings.<CreateVolumeSnapshotRequest, VolumeSnapshot>newBuilder()
                .setMethodDescriptor(createVolumeSnapshotMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<RestoreVolumeSnapshotRequest, Operation>
        restoreVolumeSnapshotTransportSettings =
            GrpcCallSettings.<RestoreVolumeSnapshotRequest, Operation>newBuilder()
                .setMethodDescriptor(restoreVolumeSnapshotMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("volume_snapshot", String.valueOf(request.getVolumeSnapshot()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteVolumeSnapshotRequest, Empty> deleteVolumeSnapshotTransportSettings =
        GrpcCallSettings.<DeleteVolumeSnapshotRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteVolumeSnapshotMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetVolumeSnapshotRequest, VolumeSnapshot> getVolumeSnapshotTransportSettings =
        GrpcCallSettings.<GetVolumeSnapshotRequest, VolumeSnapshot>newBuilder()
            .setMethodDescriptor(getVolumeSnapshotMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListVolumeSnapshotsRequest, ListVolumeSnapshotsResponse>
        listVolumeSnapshotsTransportSettings =
            GrpcCallSettings.<ListVolumeSnapshotsRequest, ListVolumeSnapshotsResponse>newBuilder()
                .setMethodDescriptor(listVolumeSnapshotsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetLunRequest, Lun> getLunTransportSettings =
        GrpcCallSettings.<GetLunRequest, Lun>newBuilder()
            .setMethodDescriptor(getLunMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListLunsRequest, ListLunsResponse> listLunsTransportSettings =
        GrpcCallSettings.<ListLunsRequest, ListLunsResponse>newBuilder()
            .setMethodDescriptor(listLunsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
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
    this.resetInstanceCallable =
        callableFactory.createUnaryCallable(
            resetInstanceTransportSettings, settings.resetInstanceSettings(), clientContext);
    this.resetInstanceOperationCallable =
        callableFactory.createOperationCallable(
            resetInstanceTransportSettings,
            settings.resetInstanceOperationSettings(),
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
    this.updateVolumeCallable =
        callableFactory.createUnaryCallable(
            updateVolumeTransportSettings, settings.updateVolumeSettings(), clientContext);
    this.updateVolumeOperationCallable =
        callableFactory.createOperationCallable(
            updateVolumeTransportSettings,
            settings.updateVolumeOperationSettings(),
            clientContext,
            operationsStub);
    this.listNetworksCallable =
        callableFactory.createUnaryCallable(
            listNetworksTransportSettings, settings.listNetworksSettings(), clientContext);
    this.listNetworksPagedCallable =
        callableFactory.createPagedCallable(
            listNetworksTransportSettings, settings.listNetworksSettings(), clientContext);
    this.getNetworkCallable =
        callableFactory.createUnaryCallable(
            getNetworkTransportSettings, settings.getNetworkSettings(), clientContext);
    this.listSnapshotSchedulePoliciesCallable =
        callableFactory.createUnaryCallable(
            listSnapshotSchedulePoliciesTransportSettings,
            settings.listSnapshotSchedulePoliciesSettings(),
            clientContext);
    this.listSnapshotSchedulePoliciesPagedCallable =
        callableFactory.createPagedCallable(
            listSnapshotSchedulePoliciesTransportSettings,
            settings.listSnapshotSchedulePoliciesSettings(),
            clientContext);
    this.getSnapshotSchedulePolicyCallable =
        callableFactory.createUnaryCallable(
            getSnapshotSchedulePolicyTransportSettings,
            settings.getSnapshotSchedulePolicySettings(),
            clientContext);
    this.createSnapshotSchedulePolicyCallable =
        callableFactory.createUnaryCallable(
            createSnapshotSchedulePolicyTransportSettings,
            settings.createSnapshotSchedulePolicySettings(),
            clientContext);
    this.updateSnapshotSchedulePolicyCallable =
        callableFactory.createUnaryCallable(
            updateSnapshotSchedulePolicyTransportSettings,
            settings.updateSnapshotSchedulePolicySettings(),
            clientContext);
    this.deleteSnapshotSchedulePolicyCallable =
        callableFactory.createUnaryCallable(
            deleteSnapshotSchedulePolicyTransportSettings,
            settings.deleteSnapshotSchedulePolicySettings(),
            clientContext);
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
  public UnaryCallable<ResetInstanceRequest, Operation> resetInstanceCallable() {
    return resetInstanceCallable;
  }

  @Override
  public OperationCallable<ResetInstanceRequest, ResetInstanceResponse, OperationMetadata>
      resetInstanceOperationCallable() {
    return resetInstanceOperationCallable;
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
  public UnaryCallable<ListNetworksRequest, ListNetworksResponse> listNetworksCallable() {
    return listNetworksCallable;
  }

  @Override
  public UnaryCallable<ListNetworksRequest, ListNetworksPagedResponse> listNetworksPagedCallable() {
    return listNetworksPagedCallable;
  }

  @Override
  public UnaryCallable<GetNetworkRequest, Network> getNetworkCallable() {
    return getNetworkCallable;
  }

  @Override
  public UnaryCallable<ListSnapshotSchedulePoliciesRequest, ListSnapshotSchedulePoliciesResponse>
      listSnapshotSchedulePoliciesCallable() {
    return listSnapshotSchedulePoliciesCallable;
  }

  @Override
  public UnaryCallable<
          ListSnapshotSchedulePoliciesRequest, ListSnapshotSchedulePoliciesPagedResponse>
      listSnapshotSchedulePoliciesPagedCallable() {
    return listSnapshotSchedulePoliciesPagedCallable;
  }

  @Override
  public UnaryCallable<GetSnapshotSchedulePolicyRequest, SnapshotSchedulePolicy>
      getSnapshotSchedulePolicyCallable() {
    return getSnapshotSchedulePolicyCallable;
  }

  @Override
  public UnaryCallable<CreateSnapshotSchedulePolicyRequest, SnapshotSchedulePolicy>
      createSnapshotSchedulePolicyCallable() {
    return createSnapshotSchedulePolicyCallable;
  }

  @Override
  public UnaryCallable<UpdateSnapshotSchedulePolicyRequest, SnapshotSchedulePolicy>
      updateSnapshotSchedulePolicyCallable() {
    return updateSnapshotSchedulePolicyCallable;
  }

  @Override
  public UnaryCallable<DeleteSnapshotSchedulePolicyRequest, Empty>
      deleteSnapshotSchedulePolicyCallable() {
    return deleteSnapshotSchedulePolicyCallable;
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
