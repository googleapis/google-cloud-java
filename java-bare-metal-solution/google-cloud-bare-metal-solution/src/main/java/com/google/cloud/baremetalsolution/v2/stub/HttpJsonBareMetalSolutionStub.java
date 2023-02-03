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

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonOperationSnapshot;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.httpjson.longrunning.stub.HttpJsonOperationsStub;
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
import com.google.longrunning.Operation;
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the BareMetalSolution service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonBareMetalSolutionStub extends BareMetalSolutionStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(StartInstanceResponse.getDescriptor())
          .add(ResetInstanceResponse.getDescriptor())
          .add(Volume.getDescriptor())
          .add(StopInstanceResponse.getDescriptor())
          .add(NfsShare.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(Instance.getDescriptor())
          .add(Network.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<ListInstancesRequest, ListInstancesResponse>
      listInstancesMethodDescriptor =
          ApiMethodDescriptor.<ListInstancesRequest, ListInstancesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.baremetalsolution.v2.BareMetalSolution/ListInstances")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListInstancesRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*/locations/*}/instances",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListInstancesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListInstancesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListInstancesResponse>newBuilder()
                      .setDefaultInstance(ListInstancesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetInstanceRequest, Instance>
      getInstanceMethodDescriptor =
          ApiMethodDescriptor.<GetInstanceRequest, Instance>newBuilder()
              .setFullMethodName("google.cloud.baremetalsolution.v2.BareMetalSolution/GetInstance")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetInstanceRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/locations/*/instances/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Instance>newBuilder()
                      .setDefaultInstance(Instance.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateInstanceRequest, Operation>
      updateInstanceMethodDescriptor =
          ApiMethodDescriptor.<UpdateInstanceRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.baremetalsolution.v2.BareMetalSolution/UpdateInstance")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateInstanceRequest>newBuilder()
                      .setPath(
                          "/v2/{instance.name=projects/*/locations/*/instances/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "instance.name", request.getInstance().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("instance", request.getInstance(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateInstanceRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ResetInstanceRequest, Operation>
      resetInstanceMethodDescriptor =
          ApiMethodDescriptor.<ResetInstanceRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.baremetalsolution.v2.BareMetalSolution/ResetInstance")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ResetInstanceRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/locations/*/instances/*}:reset",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ResetInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ResetInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ResetInstanceRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<StartInstanceRequest, Operation>
      startInstanceMethodDescriptor =
          ApiMethodDescriptor.<StartInstanceRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.baremetalsolution.v2.BareMetalSolution/StartInstance")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<StartInstanceRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/locations/*/instances/*}:start",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<StartInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<StartInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (StartInstanceRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<StopInstanceRequest, Operation>
      stopInstanceMethodDescriptor =
          ApiMethodDescriptor.<StopInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.baremetalsolution.v2.BareMetalSolution/StopInstance")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<StopInstanceRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/locations/*/instances/*}:stop",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<StopInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<StopInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (StopInstanceRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DetachLunRequest, Operation> detachLunMethodDescriptor =
      ApiMethodDescriptor.<DetachLunRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.baremetalsolution.v2.BareMetalSolution/DetachLun")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<DetachLunRequest>newBuilder()
                  .setPath(
                      "/v2/{instance=projects/*/locations/*/instances/*}:detachLun",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<DetachLunRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "instance", request.getInstance());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<DetachLunRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create()
                              .toBody("*", request.toBuilder().clearInstance().build(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Operation>newBuilder()
                  .setDefaultInstance(Operation.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .setOperationSnapshotFactory(
              (DetachLunRequest request, Operation response) ->
                  HttpJsonOperationSnapshot.create(response))
          .build();

  private static final ApiMethodDescriptor<ListVolumesRequest, ListVolumesResponse>
      listVolumesMethodDescriptor =
          ApiMethodDescriptor.<ListVolumesRequest, ListVolumesResponse>newBuilder()
              .setFullMethodName("google.cloud.baremetalsolution.v2.BareMetalSolution/ListVolumes")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListVolumesRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*/locations/*}/volumes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListVolumesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListVolumesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListVolumesResponse>newBuilder()
                      .setDefaultInstance(ListVolumesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetVolumeRequest, Volume> getVolumeMethodDescriptor =
      ApiMethodDescriptor.<GetVolumeRequest, Volume>newBuilder()
          .setFullMethodName("google.cloud.baremetalsolution.v2.BareMetalSolution/GetVolume")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetVolumeRequest>newBuilder()
                  .setPath(
                      "/v2/{name=projects/*/locations/*/volumes/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetVolumeRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetVolumeRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Volume>newBuilder()
                  .setDefaultInstance(Volume.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<UpdateVolumeRequest, Operation>
      updateVolumeMethodDescriptor =
          ApiMethodDescriptor.<UpdateVolumeRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.baremetalsolution.v2.BareMetalSolution/UpdateVolume")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateVolumeRequest>newBuilder()
                      .setPath(
                          "/v2/{volume.name=projects/*/locations/*/volumes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateVolumeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "volume.name", request.getVolume().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateVolumeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("volume", request.getVolume(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateVolumeRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ResizeVolumeRequest, Operation>
      resizeVolumeMethodDescriptor =
          ApiMethodDescriptor.<ResizeVolumeRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.baremetalsolution.v2.BareMetalSolution/ResizeVolume")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ResizeVolumeRequest>newBuilder()
                      .setPath(
                          "/v2/{volume=projects/*/locations/*/volumes/*}:resize",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ResizeVolumeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "volume", request.getVolume());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ResizeVolumeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearVolume().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ResizeVolumeRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListNetworksRequest, ListNetworksResponse>
      listNetworksMethodDescriptor =
          ApiMethodDescriptor.<ListNetworksRequest, ListNetworksResponse>newBuilder()
              .setFullMethodName("google.cloud.baremetalsolution.v2.BareMetalSolution/ListNetworks")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListNetworksRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*/locations/*}/networks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListNetworksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListNetworksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListNetworksResponse>newBuilder()
                      .setDefaultInstance(ListNetworksResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListNetworkUsageRequest, ListNetworkUsageResponse>
      listNetworkUsageMethodDescriptor =
          ApiMethodDescriptor.<ListNetworkUsageRequest, ListNetworkUsageResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.baremetalsolution.v2.BareMetalSolution/ListNetworkUsage")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListNetworkUsageRequest>newBuilder()
                      .setPath(
                          "/v2/{location=projects/*/locations/*}/networks:listNetworkUsage",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListNetworkUsageRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "location", request.getLocation());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListNetworkUsageRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListNetworkUsageResponse>newBuilder()
                      .setDefaultInstance(ListNetworkUsageResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetNetworkRequest, Network> getNetworkMethodDescriptor =
      ApiMethodDescriptor.<GetNetworkRequest, Network>newBuilder()
          .setFullMethodName("google.cloud.baremetalsolution.v2.BareMetalSolution/GetNetwork")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetNetworkRequest>newBuilder()
                  .setPath(
                      "/v2/{name=projects/*/locations/*/networks/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetNetworkRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetNetworkRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Network>newBuilder()
                  .setDefaultInstance(Network.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<UpdateNetworkRequest, Operation>
      updateNetworkMethodDescriptor =
          ApiMethodDescriptor.<UpdateNetworkRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.baremetalsolution.v2.BareMetalSolution/UpdateNetwork")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateNetworkRequest>newBuilder()
                      .setPath(
                          "/v2/{network.name=projects/*/locations/*/networks/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateNetworkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "network.name", request.getNetwork().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateNetworkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("network", request.getNetwork(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateNetworkRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetLunRequest, Lun> getLunMethodDescriptor =
      ApiMethodDescriptor.<GetLunRequest, Lun>newBuilder()
          .setFullMethodName("google.cloud.baremetalsolution.v2.BareMetalSolution/GetLun")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetLunRequest>newBuilder()
                  .setPath(
                      "/v2/{name=projects/*/locations/*/volumes/*/luns/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetLunRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetLunRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Lun>newBuilder()
                  .setDefaultInstance(Lun.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListLunsRequest, ListLunsResponse>
      listLunsMethodDescriptor =
          ApiMethodDescriptor.<ListLunsRequest, ListLunsResponse>newBuilder()
              .setFullMethodName("google.cloud.baremetalsolution.v2.BareMetalSolution/ListLuns")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListLunsRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*/locations/*/volumes/*}/luns",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListLunsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListLunsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListLunsResponse>newBuilder()
                      .setDefaultInstance(ListLunsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetNfsShareRequest, NfsShare>
      getNfsShareMethodDescriptor =
          ApiMethodDescriptor.<GetNfsShareRequest, NfsShare>newBuilder()
              .setFullMethodName("google.cloud.baremetalsolution.v2.BareMetalSolution/GetNfsShare")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetNfsShareRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/locations/*/nfsShares/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetNfsShareRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetNfsShareRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<NfsShare>newBuilder()
                      .setDefaultInstance(NfsShare.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListNfsSharesRequest, ListNfsSharesResponse>
      listNfsSharesMethodDescriptor =
          ApiMethodDescriptor.<ListNfsSharesRequest, ListNfsSharesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.baremetalsolution.v2.BareMetalSolution/ListNfsShares")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListNfsSharesRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*/locations/*}/nfsShares",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListNfsSharesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListNfsSharesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListNfsSharesResponse>newBuilder()
                      .setDefaultInstance(ListNfsSharesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateNfsShareRequest, Operation>
      updateNfsShareMethodDescriptor =
          ApiMethodDescriptor.<UpdateNfsShareRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.baremetalsolution.v2.BareMetalSolution/UpdateNfsShare")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateNfsShareRequest>newBuilder()
                      .setPath(
                          "/v2/{nfsShare.name=projects/*/locations/*/nfsShares/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateNfsShareRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "nfsShare.name", request.getNfsShare().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateNfsShareRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("nfsShare", request.getNfsShare(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateNfsShareRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
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
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonBareMetalSolutionStub create(BareMetalSolutionStubSettings settings)
      throws IOException {
    return new HttpJsonBareMetalSolutionStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonBareMetalSolutionStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonBareMetalSolutionStub(
        BareMetalSolutionStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonBareMetalSolutionStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonBareMetalSolutionStub(
        BareMetalSolutionStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonBareMetalSolutionStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonBareMetalSolutionStub(
      BareMetalSolutionStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonBareMetalSolutionCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonBareMetalSolutionStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonBareMetalSolutionStub(
      BareMetalSolutionStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<ListInstancesRequest, ListInstancesResponse>
        listInstancesTransportSettings =
            HttpJsonCallSettings.<ListInstancesRequest, ListInstancesResponse>newBuilder()
                .setMethodDescriptor(listInstancesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetInstanceRequest, Instance> getInstanceTransportSettings =
        HttpJsonCallSettings.<GetInstanceRequest, Instance>newBuilder()
            .setMethodDescriptor(getInstanceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateInstanceRequest, Operation> updateInstanceTransportSettings =
        HttpJsonCallSettings.<UpdateInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(updateInstanceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ResetInstanceRequest, Operation> resetInstanceTransportSettings =
        HttpJsonCallSettings.<ResetInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(resetInstanceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<StartInstanceRequest, Operation> startInstanceTransportSettings =
        HttpJsonCallSettings.<StartInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(startInstanceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<StopInstanceRequest, Operation> stopInstanceTransportSettings =
        HttpJsonCallSettings.<StopInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(stopInstanceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DetachLunRequest, Operation> detachLunTransportSettings =
        HttpJsonCallSettings.<DetachLunRequest, Operation>newBuilder()
            .setMethodDescriptor(detachLunMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListVolumesRequest, ListVolumesResponse> listVolumesTransportSettings =
        HttpJsonCallSettings.<ListVolumesRequest, ListVolumesResponse>newBuilder()
            .setMethodDescriptor(listVolumesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetVolumeRequest, Volume> getVolumeTransportSettings =
        HttpJsonCallSettings.<GetVolumeRequest, Volume>newBuilder()
            .setMethodDescriptor(getVolumeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateVolumeRequest, Operation> updateVolumeTransportSettings =
        HttpJsonCallSettings.<UpdateVolumeRequest, Operation>newBuilder()
            .setMethodDescriptor(updateVolumeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ResizeVolumeRequest, Operation> resizeVolumeTransportSettings =
        HttpJsonCallSettings.<ResizeVolumeRequest, Operation>newBuilder()
            .setMethodDescriptor(resizeVolumeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListNetworksRequest, ListNetworksResponse> listNetworksTransportSettings =
        HttpJsonCallSettings.<ListNetworksRequest, ListNetworksResponse>newBuilder()
            .setMethodDescriptor(listNetworksMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListNetworkUsageRequest, ListNetworkUsageResponse>
        listNetworkUsageTransportSettings =
            HttpJsonCallSettings.<ListNetworkUsageRequest, ListNetworkUsageResponse>newBuilder()
                .setMethodDescriptor(listNetworkUsageMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetNetworkRequest, Network> getNetworkTransportSettings =
        HttpJsonCallSettings.<GetNetworkRequest, Network>newBuilder()
            .setMethodDescriptor(getNetworkMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateNetworkRequest, Operation> updateNetworkTransportSettings =
        HttpJsonCallSettings.<UpdateNetworkRequest, Operation>newBuilder()
            .setMethodDescriptor(updateNetworkMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetLunRequest, Lun> getLunTransportSettings =
        HttpJsonCallSettings.<GetLunRequest, Lun>newBuilder()
            .setMethodDescriptor(getLunMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListLunsRequest, ListLunsResponse> listLunsTransportSettings =
        HttpJsonCallSettings.<ListLunsRequest, ListLunsResponse>newBuilder()
            .setMethodDescriptor(listLunsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetNfsShareRequest, NfsShare> getNfsShareTransportSettings =
        HttpJsonCallSettings.<GetNfsShareRequest, NfsShare>newBuilder()
            .setMethodDescriptor(getNfsShareMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListNfsSharesRequest, ListNfsSharesResponse>
        listNfsSharesTransportSettings =
            HttpJsonCallSettings.<ListNfsSharesRequest, ListNfsSharesResponse>newBuilder()
                .setMethodDescriptor(listNfsSharesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateNfsShareRequest, Operation> updateNfsShareTransportSettings =
        HttpJsonCallSettings.<UpdateNfsShareRequest, Operation>newBuilder()
            .setMethodDescriptor(updateNfsShareMethodDescriptor)
            .setTypeRegistry(typeRegistry)
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
            httpJsonOperationsStub);
    this.resetInstanceCallable =
        callableFactory.createUnaryCallable(
            resetInstanceTransportSettings, settings.resetInstanceSettings(), clientContext);
    this.resetInstanceOperationCallable =
        callableFactory.createOperationCallable(
            resetInstanceTransportSettings,
            settings.resetInstanceOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.startInstanceCallable =
        callableFactory.createUnaryCallable(
            startInstanceTransportSettings, settings.startInstanceSettings(), clientContext);
    this.startInstanceOperationCallable =
        callableFactory.createOperationCallable(
            startInstanceTransportSettings,
            settings.startInstanceOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.stopInstanceCallable =
        callableFactory.createUnaryCallable(
            stopInstanceTransportSettings, settings.stopInstanceSettings(), clientContext);
    this.stopInstanceOperationCallable =
        callableFactory.createOperationCallable(
            stopInstanceTransportSettings,
            settings.stopInstanceOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.detachLunCallable =
        callableFactory.createUnaryCallable(
            detachLunTransportSettings, settings.detachLunSettings(), clientContext);
    this.detachLunOperationCallable =
        callableFactory.createOperationCallable(
            detachLunTransportSettings,
            settings.detachLunOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
    this.resizeVolumeCallable =
        callableFactory.createUnaryCallable(
            resizeVolumeTransportSettings, settings.resizeVolumeSettings(), clientContext);
    this.resizeVolumeOperationCallable =
        callableFactory.createOperationCallable(
            resizeVolumeTransportSettings,
            settings.resizeVolumeOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listInstancesMethodDescriptor);
    methodDescriptors.add(getInstanceMethodDescriptor);
    methodDescriptors.add(updateInstanceMethodDescriptor);
    methodDescriptors.add(resetInstanceMethodDescriptor);
    methodDescriptors.add(startInstanceMethodDescriptor);
    methodDescriptors.add(stopInstanceMethodDescriptor);
    methodDescriptors.add(detachLunMethodDescriptor);
    methodDescriptors.add(listVolumesMethodDescriptor);
    methodDescriptors.add(getVolumeMethodDescriptor);
    methodDescriptors.add(updateVolumeMethodDescriptor);
    methodDescriptors.add(resizeVolumeMethodDescriptor);
    methodDescriptors.add(listNetworksMethodDescriptor);
    methodDescriptors.add(listNetworkUsageMethodDescriptor);
    methodDescriptors.add(getNetworkMethodDescriptor);
    methodDescriptors.add(updateNetworkMethodDescriptor);
    methodDescriptors.add(getLunMethodDescriptor);
    methodDescriptors.add(listLunsMethodDescriptor);
    methodDescriptors.add(getNfsShareMethodDescriptor);
    methodDescriptors.add(listNfsSharesMethodDescriptor);
    methodDescriptors.add(updateNfsShareMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
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
