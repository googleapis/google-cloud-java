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
import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListNfsSharesPagedResponse;
import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListVolumesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.baremetalsolution.v2.DetachLunRequest;
import com.google.cloud.baremetalsolution.v2.GetInstanceRequest;
import com.google.cloud.baremetalsolution.v2.GetLunRequest;
import com.google.cloud.baremetalsolution.v2.GetNetworkRequest;
import com.google.cloud.baremetalsolution.v2.GetNfsShareRequest;
import com.google.cloud.baremetalsolution.v2.GetVolumeRequest;
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
import com.google.cloud.baremetalsolution.v2.ListVolumesRequest;
import com.google.cloud.baremetalsolution.v2.ListVolumesResponse;
import com.google.cloud.baremetalsolution.v2.Lun;
import com.google.cloud.baremetalsolution.v2.Network;
import com.google.cloud.baremetalsolution.v2.NfsShare;
import com.google.cloud.baremetalsolution.v2.OperationMetadata;
import com.google.cloud.baremetalsolution.v2.ResetInstanceRequest;
import com.google.cloud.baremetalsolution.v2.ResetInstanceResponse;
import com.google.cloud.baremetalsolution.v2.ResizeVolumeRequest;
import com.google.cloud.baremetalsolution.v2.StartInstanceRequest;
import com.google.cloud.baremetalsolution.v2.StartInstanceResponse;
import com.google.cloud.baremetalsolution.v2.StopInstanceRequest;
import com.google.cloud.baremetalsolution.v2.StopInstanceResponse;
import com.google.cloud.baremetalsolution.v2.UpdateInstanceRequest;
import com.google.cloud.baremetalsolution.v2.UpdateNetworkRequest;
import com.google.cloud.baremetalsolution.v2.UpdateNfsShareRequest;
import com.google.cloud.baremetalsolution.v2.UpdateVolumeRequest;
import com.google.cloud.baremetalsolution.v2.Volume;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
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

  private static final MethodDescriptor<DetachLunRequest, Operation> detachLunMethodDescriptor =
      MethodDescriptor.<DetachLunRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.baremetalsolution.v2.BareMetalSolution/DetachLun")
          .setRequestMarshaller(ProtoUtils.marshaller(DetachLunRequest.getDefaultInstance()))
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

  private final UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable;
  private final UnaryCallable<ListInstancesRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable;
  private final UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable;
  private final UnaryCallable<UpdateInstanceRequest, Operation> updateInstanceCallable;
  private final OperationCallable<UpdateInstanceRequest, Instance, OperationMetadata>
      updateInstanceOperationCallable;
  private final UnaryCallable<ResetInstanceRequest, Operation> resetInstanceCallable;
  private final OperationCallable<ResetInstanceRequest, ResetInstanceResponse, OperationMetadata>
      resetInstanceOperationCallable;
  private final UnaryCallable<StartInstanceRequest, Operation> startInstanceCallable;
  private final OperationCallable<StartInstanceRequest, StartInstanceResponse, OperationMetadata>
      startInstanceOperationCallable;
  private final UnaryCallable<StopInstanceRequest, Operation> stopInstanceCallable;
  private final OperationCallable<StopInstanceRequest, StopInstanceResponse, OperationMetadata>
      stopInstanceOperationCallable;
  private final UnaryCallable<DetachLunRequest, Operation> detachLunCallable;
  private final OperationCallable<DetachLunRequest, Instance, OperationMetadata>
      detachLunOperationCallable;
  private final UnaryCallable<ListVolumesRequest, ListVolumesResponse> listVolumesCallable;
  private final UnaryCallable<ListVolumesRequest, ListVolumesPagedResponse>
      listVolumesPagedCallable;
  private final UnaryCallable<GetVolumeRequest, Volume> getVolumeCallable;
  private final UnaryCallable<UpdateVolumeRequest, Operation> updateVolumeCallable;
  private final OperationCallable<UpdateVolumeRequest, Volume, OperationMetadata>
      updateVolumeOperationCallable;
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
  private final UnaryCallable<GetLunRequest, Lun> getLunCallable;
  private final UnaryCallable<ListLunsRequest, ListLunsResponse> listLunsCallable;
  private final UnaryCallable<ListLunsRequest, ListLunsPagedResponse> listLunsPagedCallable;
  private final UnaryCallable<GetNfsShareRequest, NfsShare> getNfsShareCallable;
  private final UnaryCallable<ListNfsSharesRequest, ListNfsSharesResponse> listNfsSharesCallable;
  private final UnaryCallable<ListNfsSharesRequest, ListNfsSharesPagedResponse>
      listNfsSharesPagedCallable;
  private final UnaryCallable<UpdateNfsShareRequest, Operation> updateNfsShareCallable;
  private final OperationCallable<UpdateNfsShareRequest, NfsShare, OperationMetadata>
      updateNfsShareOperationCallable;

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
    GrpcCallSettings<UpdateInstanceRequest, Operation> updateInstanceTransportSettings =
        GrpcCallSettings.<UpdateInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(updateInstanceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("instance.name", String.valueOf(request.getInstance().getName()));
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
    GrpcCallSettings<StartInstanceRequest, Operation> startInstanceTransportSettings =
        GrpcCallSettings.<StartInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(startInstanceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<StopInstanceRequest, Operation> stopInstanceTransportSettings =
        GrpcCallSettings.<StopInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(stopInstanceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DetachLunRequest, Operation> detachLunTransportSettings =
        GrpcCallSettings.<DetachLunRequest, Operation>newBuilder()
            .setMethodDescriptor(detachLunMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("instance", String.valueOf(request.getInstance()));
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
    GrpcCallSettings<ResizeVolumeRequest, Operation> resizeVolumeTransportSettings =
        GrpcCallSettings.<ResizeVolumeRequest, Operation>newBuilder()
            .setMethodDescriptor(resizeVolumeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("volume", String.valueOf(request.getVolume()));
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
    GrpcCallSettings<ListNetworkUsageRequest, ListNetworkUsageResponse>
        listNetworkUsageTransportSettings =
            GrpcCallSettings.<ListNetworkUsageRequest, ListNetworkUsageResponse>newBuilder()
                .setMethodDescriptor(listNetworkUsageMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("location", String.valueOf(request.getLocation()));
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
    GrpcCallSettings<UpdateNetworkRequest, Operation> updateNetworkTransportSettings =
        GrpcCallSettings.<UpdateNetworkRequest, Operation>newBuilder()
            .setMethodDescriptor(updateNetworkMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("network.name", String.valueOf(request.getNetwork().getName()));
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
    GrpcCallSettings<GetNfsShareRequest, NfsShare> getNfsShareTransportSettings =
        GrpcCallSettings.<GetNfsShareRequest, NfsShare>newBuilder()
            .setMethodDescriptor(getNfsShareMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListNfsSharesRequest, ListNfsSharesResponse> listNfsSharesTransportSettings =
        GrpcCallSettings.<ListNfsSharesRequest, ListNfsSharesResponse>newBuilder()
            .setMethodDescriptor(listNfsSharesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateNfsShareRequest, Operation> updateNfsShareTransportSettings =
        GrpcCallSettings.<UpdateNfsShareRequest, Operation>newBuilder()
            .setMethodDescriptor(updateNfsShareMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("nfs_share.name", String.valueOf(request.getNfsShare().getName()));
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
    this.updateInstanceCallable =
        callableFactory.createUnaryCallable(
            updateInstanceTransportSettings, settings.updateInstanceSettings(), clientContext);
    this.updateInstanceOperationCallable =
        callableFactory.createOperationCallable(
            updateInstanceTransportSettings,
            settings.updateInstanceOperationSettings(),
            clientContext,
            operationsStub);
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
    this.detachLunCallable =
        callableFactory.createUnaryCallable(
            detachLunTransportSettings, settings.detachLunSettings(), clientContext);
    this.detachLunOperationCallable =
        callableFactory.createOperationCallable(
            detachLunTransportSettings,
            settings.detachLunOperationSettings(),
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
    this.getLunCallable =
        callableFactory.createUnaryCallable(
            getLunTransportSettings, settings.getLunSettings(), clientContext);
    this.listLunsCallable =
        callableFactory.createUnaryCallable(
            listLunsTransportSettings, settings.listLunsSettings(), clientContext);
    this.listLunsPagedCallable =
        callableFactory.createPagedCallable(
            listLunsTransportSettings, settings.listLunsSettings(), clientContext);
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
  public UnaryCallable<DetachLunRequest, Operation> detachLunCallable() {
    return detachLunCallable;
  }

  @Override
  public OperationCallable<DetachLunRequest, Instance, OperationMetadata>
      detachLunOperationCallable() {
    return detachLunOperationCallable;
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
