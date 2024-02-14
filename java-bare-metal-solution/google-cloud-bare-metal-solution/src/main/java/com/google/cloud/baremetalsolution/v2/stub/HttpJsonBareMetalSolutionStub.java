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
import com.google.protobuf.Empty;
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
          .add(Empty.getDescriptor())
          .add(Volume.getDescriptor())
          .add(StopInstanceResponse.getDescriptor())
          .add(EnableInteractiveSerialConsoleResponse.getDescriptor())
          .add(NfsShare.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(VolumeSnapshot.getDescriptor())
          .add(Instance.getDescriptor())
          .add(DisableInteractiveSerialConsoleResponse.getDescriptor())
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

  private static final ApiMethodDescriptor<RenameInstanceRequest, Instance>
      renameInstanceMethodDescriptor =
          ApiMethodDescriptor.<RenameInstanceRequest, Instance>newBuilder()
              .setFullMethodName(
                  "google.cloud.baremetalsolution.v2.BareMetalSolution/RenameInstance")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RenameInstanceRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/locations/*/instances/*}:rename",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RenameInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RenameInstanceRequest> serializer =
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
                  ProtoMessageResponseParser.<Instance>newBuilder()
                      .setDefaultInstance(Instance.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
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

  private static final ApiMethodDescriptor<EnableInteractiveSerialConsoleRequest, Operation>
      enableInteractiveSerialConsoleMethodDescriptor =
          ApiMethodDescriptor.<EnableInteractiveSerialConsoleRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.baremetalsolution.v2.BareMetalSolution/EnableInteractiveSerialConsole")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<EnableInteractiveSerialConsoleRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/locations/*/instances/*}:enableInteractiveSerialConsole",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<EnableInteractiveSerialConsoleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<EnableInteractiveSerialConsoleRequest> serializer =
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
                  (EnableInteractiveSerialConsoleRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DisableInteractiveSerialConsoleRequest, Operation>
      disableInteractiveSerialConsoleMethodDescriptor =
          ApiMethodDescriptor.<DisableInteractiveSerialConsoleRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.baremetalsolution.v2.BareMetalSolution/DisableInteractiveSerialConsole")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DisableInteractiveSerialConsoleRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/locations/*/instances/*}:disableInteractiveSerialConsole",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DisableInteractiveSerialConsoleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DisableInteractiveSerialConsoleRequest> serializer =
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
                  (DisableInteractiveSerialConsoleRequest request, Operation response) ->
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

  private static final ApiMethodDescriptor<ListSSHKeysRequest, ListSSHKeysResponse>
      listSSHKeysMethodDescriptor =
          ApiMethodDescriptor.<ListSSHKeysRequest, ListSSHKeysResponse>newBuilder()
              .setFullMethodName("google.cloud.baremetalsolution.v2.BareMetalSolution/ListSSHKeys")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListSSHKeysRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*/locations/*}/sshKeys",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListSSHKeysRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListSSHKeysRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListSSHKeysResponse>newBuilder()
                      .setDefaultInstance(ListSSHKeysResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateSSHKeyRequest, SSHKey>
      createSSHKeyMethodDescriptor =
          ApiMethodDescriptor.<CreateSSHKeyRequest, SSHKey>newBuilder()
              .setFullMethodName("google.cloud.baremetalsolution.v2.BareMetalSolution/CreateSSHKey")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateSSHKeyRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*/locations/*}/sshKeys",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSSHKeyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSSHKeyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "sshKeyId", request.getSshKeyId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("sshKey", request.getSshKey(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SSHKey>newBuilder()
                      .setDefaultInstance(SSHKey.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteSSHKeyRequest, Empty>
      deleteSSHKeyMethodDescriptor =
          ApiMethodDescriptor.<DeleteSSHKeyRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.baremetalsolution.v2.BareMetalSolution/DeleteSSHKey")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteSSHKeyRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/locations/*/sshKeys/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSSHKeyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSSHKeyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
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

  private static final ApiMethodDescriptor<RenameVolumeRequest, Volume>
      renameVolumeMethodDescriptor =
          ApiMethodDescriptor.<RenameVolumeRequest, Volume>newBuilder()
              .setFullMethodName("google.cloud.baremetalsolution.v2.BareMetalSolution/RenameVolume")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RenameVolumeRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/locations/*/volumes/*}:rename",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RenameVolumeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RenameVolumeRequest> serializer =
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
                  ProtoMessageResponseParser.<Volume>newBuilder()
                      .setDefaultInstance(Volume.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<EvictVolumeRequest, Operation>
      evictVolumeMethodDescriptor =
          ApiMethodDescriptor.<EvictVolumeRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.baremetalsolution.v2.BareMetalSolution/EvictVolume")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<EvictVolumeRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/locations/*/volumes/*}:evict",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<EvictVolumeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<EvictVolumeRequest> serializer =
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
                  (EvictVolumeRequest request, Operation response) ->
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

  private static final ApiMethodDescriptor<CreateVolumeSnapshotRequest, VolumeSnapshot>
      createVolumeSnapshotMethodDescriptor =
          ApiMethodDescriptor.<CreateVolumeSnapshotRequest, VolumeSnapshot>newBuilder()
              .setFullMethodName(
                  "google.cloud.baremetalsolution.v2.BareMetalSolution/CreateVolumeSnapshot")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateVolumeSnapshotRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*/locations/*/volumes/*}/snapshots",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateVolumeSnapshotRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateVolumeSnapshotRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("volumeSnapshot", request.getVolumeSnapshot(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<VolumeSnapshot>newBuilder()
                      .setDefaultInstance(VolumeSnapshot.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<RestoreVolumeSnapshotRequest, Operation>
      restoreVolumeSnapshotMethodDescriptor =
          ApiMethodDescriptor.<RestoreVolumeSnapshotRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.baremetalsolution.v2.BareMetalSolution/RestoreVolumeSnapshot")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RestoreVolumeSnapshotRequest>newBuilder()
                      .setPath(
                          "/v2/{volumeSnapshot=projects/*/locations/*/volumes/*/snapshots/*}:restoreVolumeSnapshot",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RestoreVolumeSnapshotRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "volumeSnapshot", request.getVolumeSnapshot());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RestoreVolumeSnapshotRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*", request.toBuilder().clearVolumeSnapshot().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (RestoreVolumeSnapshotRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteVolumeSnapshotRequest, Empty>
      deleteVolumeSnapshotMethodDescriptor =
          ApiMethodDescriptor.<DeleteVolumeSnapshotRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.baremetalsolution.v2.BareMetalSolution/DeleteVolumeSnapshot")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteVolumeSnapshotRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/locations/*/volumes/*/snapshots/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteVolumeSnapshotRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteVolumeSnapshotRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetVolumeSnapshotRequest, VolumeSnapshot>
      getVolumeSnapshotMethodDescriptor =
          ApiMethodDescriptor.<GetVolumeSnapshotRequest, VolumeSnapshot>newBuilder()
              .setFullMethodName(
                  "google.cloud.baremetalsolution.v2.BareMetalSolution/GetVolumeSnapshot")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetVolumeSnapshotRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/locations/*/volumes/*/snapshots/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetVolumeSnapshotRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetVolumeSnapshotRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<VolumeSnapshot>newBuilder()
                      .setDefaultInstance(VolumeSnapshot.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListVolumeSnapshotsRequest, ListVolumeSnapshotsResponse>
      listVolumeSnapshotsMethodDescriptor =
          ApiMethodDescriptor.<ListVolumeSnapshotsRequest, ListVolumeSnapshotsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.baremetalsolution.v2.BareMetalSolution/ListVolumeSnapshots")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListVolumeSnapshotsRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*/locations/*/volumes/*}/snapshots",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListVolumeSnapshotsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListVolumeSnapshotsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListVolumeSnapshotsResponse>newBuilder()
                      .setDefaultInstance(ListVolumeSnapshotsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
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

  private static final ApiMethodDescriptor<EvictLunRequest, Operation> evictLunMethodDescriptor =
      ApiMethodDescriptor.<EvictLunRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.baremetalsolution.v2.BareMetalSolution/EvictLun")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<EvictLunRequest>newBuilder()
                  .setPath(
                      "/v2/{name=projects/*/locations/*/volumes/*/luns/*}:evict",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<EvictLunRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<EvictLunRequest> serializer =
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
              (EvictLunRequest request, Operation response) ->
                  HttpJsonOperationSnapshot.create(response))
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

  private static final ApiMethodDescriptor<CreateNfsShareRequest, Operation>
      createNfsShareMethodDescriptor =
          ApiMethodDescriptor.<CreateNfsShareRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.baremetalsolution.v2.BareMetalSolution/CreateNfsShare")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateNfsShareRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*/locations/*}/nfsShares",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateNfsShareRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateNfsShareRequest> serializer =
                                ProtoRestSerializer.create();
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
                  (CreateNfsShareRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<RenameNfsShareRequest, NfsShare>
      renameNfsShareMethodDescriptor =
          ApiMethodDescriptor.<RenameNfsShareRequest, NfsShare>newBuilder()
              .setFullMethodName(
                  "google.cloud.baremetalsolution.v2.BareMetalSolution/RenameNfsShare")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RenameNfsShareRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/locations/*/nfsShares/*}:rename",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RenameNfsShareRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RenameNfsShareRequest> serializer =
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
                  ProtoMessageResponseParser.<NfsShare>newBuilder()
                      .setDefaultInstance(NfsShare.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteNfsShareRequest, Operation>
      deleteNfsShareMethodDescriptor =
          ApiMethodDescriptor.<DeleteNfsShareRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.baremetalsolution.v2.BareMetalSolution/DeleteNfsShare")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteNfsShareRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/locations/*/nfsShares/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteNfsShareRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteNfsShareRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeleteNfsShareRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          ListProvisioningQuotasRequest, ListProvisioningQuotasResponse>
      listProvisioningQuotasMethodDescriptor =
          ApiMethodDescriptor
              .<ListProvisioningQuotasRequest, ListProvisioningQuotasResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.baremetalsolution.v2.BareMetalSolution/ListProvisioningQuotas")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListProvisioningQuotasRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*/locations/*}/provisioningQuotas",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListProvisioningQuotasRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListProvisioningQuotasRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListProvisioningQuotasResponse>newBuilder()
                      .setDefaultInstance(ListProvisioningQuotasResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          SubmitProvisioningConfigRequest, SubmitProvisioningConfigResponse>
      submitProvisioningConfigMethodDescriptor =
          ApiMethodDescriptor
              .<SubmitProvisioningConfigRequest, SubmitProvisioningConfigResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.baremetalsolution.v2.BareMetalSolution/SubmitProvisioningConfig")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SubmitProvisioningConfigRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*/locations/*}/provisioningConfigs:submit",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SubmitProvisioningConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SubmitProvisioningConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SubmitProvisioningConfigResponse>newBuilder()
                      .setDefaultInstance(SubmitProvisioningConfigResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetProvisioningConfigRequest, ProvisioningConfig>
      getProvisioningConfigMethodDescriptor =
          ApiMethodDescriptor.<GetProvisioningConfigRequest, ProvisioningConfig>newBuilder()
              .setFullMethodName(
                  "google.cloud.baremetalsolution.v2.BareMetalSolution/GetProvisioningConfig")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetProvisioningConfigRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/locations/*/provisioningConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetProvisioningConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetProvisioningConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ProvisioningConfig>newBuilder()
                      .setDefaultInstance(ProvisioningConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateProvisioningConfigRequest, ProvisioningConfig>
      createProvisioningConfigMethodDescriptor =
          ApiMethodDescriptor.<CreateProvisioningConfigRequest, ProvisioningConfig>newBuilder()
              .setFullMethodName(
                  "google.cloud.baremetalsolution.v2.BareMetalSolution/CreateProvisioningConfig")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateProvisioningConfigRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*/locations/*}/provisioningConfigs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateProvisioningConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateProvisioningConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "email", request.getEmail());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "provisioningConfig", request.getProvisioningConfig(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ProvisioningConfig>newBuilder()
                      .setDefaultInstance(ProvisioningConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateProvisioningConfigRequest, ProvisioningConfig>
      updateProvisioningConfigMethodDescriptor =
          ApiMethodDescriptor.<UpdateProvisioningConfigRequest, ProvisioningConfig>newBuilder()
              .setFullMethodName(
                  "google.cloud.baremetalsolution.v2.BareMetalSolution/UpdateProvisioningConfig")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateProvisioningConfigRequest>newBuilder()
                      .setPath(
                          "/v2/{provisioningConfig.name=projects/*/locations/*/provisioningConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateProvisioningConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "provisioningConfig.name",
                                request.getProvisioningConfig().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateProvisioningConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "email", request.getEmail());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "provisioningConfig", request.getProvisioningConfig(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ProvisioningConfig>newBuilder()
                      .setDefaultInstance(ProvisioningConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<RenameNetworkRequest, Network>
      renameNetworkMethodDescriptor =
          ApiMethodDescriptor.<RenameNetworkRequest, Network>newBuilder()
              .setFullMethodName(
                  "google.cloud.baremetalsolution.v2.BareMetalSolution/RenameNetwork")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RenameNetworkRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/locations/*/networks/*}:rename",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RenameNetworkRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RenameNetworkRequest> serializer =
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
                  ProtoMessageResponseParser.<Network>newBuilder()
                      .setDefaultInstance(Network.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListOSImagesRequest, ListOSImagesResponse>
      listOSImagesMethodDescriptor =
          ApiMethodDescriptor.<ListOSImagesRequest, ListOSImagesResponse>newBuilder()
              .setFullMethodName("google.cloud.baremetalsolution.v2.BareMetalSolution/ListOSImages")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListOSImagesRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*/locations/*}/osImages",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListOSImagesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListOSImagesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListOSImagesResponse>newBuilder()
                      .setDefaultInstance(ListOSImagesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          ApiMethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListLocationsRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*}/locations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListLocationsResponse>newBuilder()
                      .setDefaultInstance(ListLocationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetLocationRequest, Location>
      getLocationMethodDescriptor =
          ApiMethodDescriptor.<GetLocationRequest, Location>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/GetLocation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetLocationRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/locations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Location>newBuilder()
                      .setDefaultInstance(Location.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
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
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetInstanceRequest, Instance> getInstanceTransportSettings =
        HttpJsonCallSettings.<GetInstanceRequest, Instance>newBuilder()
            .setMethodDescriptor(getInstanceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateInstanceRequest, Operation> updateInstanceTransportSettings =
        HttpJsonCallSettings.<UpdateInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(updateInstanceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("instance.name", String.valueOf(request.getInstance().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<RenameInstanceRequest, Instance> renameInstanceTransportSettings =
        HttpJsonCallSettings.<RenameInstanceRequest, Instance>newBuilder()
            .setMethodDescriptor(renameInstanceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ResetInstanceRequest, Operation> resetInstanceTransportSettings =
        HttpJsonCallSettings.<ResetInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(resetInstanceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<StartInstanceRequest, Operation> startInstanceTransportSettings =
        HttpJsonCallSettings.<StartInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(startInstanceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<StopInstanceRequest, Operation> stopInstanceTransportSettings =
        HttpJsonCallSettings.<StopInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(stopInstanceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<EnableInteractiveSerialConsoleRequest, Operation>
        enableInteractiveSerialConsoleTransportSettings =
            HttpJsonCallSettings.<EnableInteractiveSerialConsoleRequest, Operation>newBuilder()
                .setMethodDescriptor(enableInteractiveSerialConsoleMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DisableInteractiveSerialConsoleRequest, Operation>
        disableInteractiveSerialConsoleTransportSettings =
            HttpJsonCallSettings.<DisableInteractiveSerialConsoleRequest, Operation>newBuilder()
                .setMethodDescriptor(disableInteractiveSerialConsoleMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DetachLunRequest, Operation> detachLunTransportSettings =
        HttpJsonCallSettings.<DetachLunRequest, Operation>newBuilder()
            .setMethodDescriptor(detachLunMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("instance", String.valueOf(request.getInstance()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListSSHKeysRequest, ListSSHKeysResponse> listSSHKeysTransportSettings =
        HttpJsonCallSettings.<ListSSHKeysRequest, ListSSHKeysResponse>newBuilder()
            .setMethodDescriptor(listSSHKeysMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateSSHKeyRequest, SSHKey> createSSHKeyTransportSettings =
        HttpJsonCallSettings.<CreateSSHKeyRequest, SSHKey>newBuilder()
            .setMethodDescriptor(createSSHKeyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteSSHKeyRequest, Empty> deleteSSHKeyTransportSettings =
        HttpJsonCallSettings.<DeleteSSHKeyRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteSSHKeyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListVolumesRequest, ListVolumesResponse> listVolumesTransportSettings =
        HttpJsonCallSettings.<ListVolumesRequest, ListVolumesResponse>newBuilder()
            .setMethodDescriptor(listVolumesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetVolumeRequest, Volume> getVolumeTransportSettings =
        HttpJsonCallSettings.<GetVolumeRequest, Volume>newBuilder()
            .setMethodDescriptor(getVolumeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateVolumeRequest, Operation> updateVolumeTransportSettings =
        HttpJsonCallSettings.<UpdateVolumeRequest, Operation>newBuilder()
            .setMethodDescriptor(updateVolumeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("volume.name", String.valueOf(request.getVolume().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<RenameVolumeRequest, Volume> renameVolumeTransportSettings =
        HttpJsonCallSettings.<RenameVolumeRequest, Volume>newBuilder()
            .setMethodDescriptor(renameVolumeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<EvictVolumeRequest, Operation> evictVolumeTransportSettings =
        HttpJsonCallSettings.<EvictVolumeRequest, Operation>newBuilder()
            .setMethodDescriptor(evictVolumeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ResizeVolumeRequest, Operation> resizeVolumeTransportSettings =
        HttpJsonCallSettings.<ResizeVolumeRequest, Operation>newBuilder()
            .setMethodDescriptor(resizeVolumeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("volume", String.valueOf(request.getVolume()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListNetworksRequest, ListNetworksResponse> listNetworksTransportSettings =
        HttpJsonCallSettings.<ListNetworksRequest, ListNetworksResponse>newBuilder()
            .setMethodDescriptor(listNetworksMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListNetworkUsageRequest, ListNetworkUsageResponse>
        listNetworkUsageTransportSettings =
            HttpJsonCallSettings.<ListNetworkUsageRequest, ListNetworkUsageResponse>newBuilder()
                .setMethodDescriptor(listNetworkUsageMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("location", String.valueOf(request.getLocation()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetNetworkRequest, Network> getNetworkTransportSettings =
        HttpJsonCallSettings.<GetNetworkRequest, Network>newBuilder()
            .setMethodDescriptor(getNetworkMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateNetworkRequest, Operation> updateNetworkTransportSettings =
        HttpJsonCallSettings.<UpdateNetworkRequest, Operation>newBuilder()
            .setMethodDescriptor(updateNetworkMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("network.name", String.valueOf(request.getNetwork().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateVolumeSnapshotRequest, VolumeSnapshot>
        createVolumeSnapshotTransportSettings =
            HttpJsonCallSettings.<CreateVolumeSnapshotRequest, VolumeSnapshot>newBuilder()
                .setMethodDescriptor(createVolumeSnapshotMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<RestoreVolumeSnapshotRequest, Operation>
        restoreVolumeSnapshotTransportSettings =
            HttpJsonCallSettings.<RestoreVolumeSnapshotRequest, Operation>newBuilder()
                .setMethodDescriptor(restoreVolumeSnapshotMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("volume_snapshot", String.valueOf(request.getVolumeSnapshot()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteVolumeSnapshotRequest, Empty> deleteVolumeSnapshotTransportSettings =
        HttpJsonCallSettings.<DeleteVolumeSnapshotRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteVolumeSnapshotMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetVolumeSnapshotRequest, VolumeSnapshot>
        getVolumeSnapshotTransportSettings =
            HttpJsonCallSettings.<GetVolumeSnapshotRequest, VolumeSnapshot>newBuilder()
                .setMethodDescriptor(getVolumeSnapshotMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListVolumeSnapshotsRequest, ListVolumeSnapshotsResponse>
        listVolumeSnapshotsTransportSettings =
            HttpJsonCallSettings
                .<ListVolumeSnapshotsRequest, ListVolumeSnapshotsResponse>newBuilder()
                .setMethodDescriptor(listVolumeSnapshotsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetLunRequest, Lun> getLunTransportSettings =
        HttpJsonCallSettings.<GetLunRequest, Lun>newBuilder()
            .setMethodDescriptor(getLunMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListLunsRequest, ListLunsResponse> listLunsTransportSettings =
        HttpJsonCallSettings.<ListLunsRequest, ListLunsResponse>newBuilder()
            .setMethodDescriptor(listLunsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<EvictLunRequest, Operation> evictLunTransportSettings =
        HttpJsonCallSettings.<EvictLunRequest, Operation>newBuilder()
            .setMethodDescriptor(evictLunMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetNfsShareRequest, NfsShare> getNfsShareTransportSettings =
        HttpJsonCallSettings.<GetNfsShareRequest, NfsShare>newBuilder()
            .setMethodDescriptor(getNfsShareMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListNfsSharesRequest, ListNfsSharesResponse>
        listNfsSharesTransportSettings =
            HttpJsonCallSettings.<ListNfsSharesRequest, ListNfsSharesResponse>newBuilder()
                .setMethodDescriptor(listNfsSharesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateNfsShareRequest, Operation> updateNfsShareTransportSettings =
        HttpJsonCallSettings.<UpdateNfsShareRequest, Operation>newBuilder()
            .setMethodDescriptor(updateNfsShareMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("nfs_share.name", String.valueOf(request.getNfsShare().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateNfsShareRequest, Operation> createNfsShareTransportSettings =
        HttpJsonCallSettings.<CreateNfsShareRequest, Operation>newBuilder()
            .setMethodDescriptor(createNfsShareMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<RenameNfsShareRequest, NfsShare> renameNfsShareTransportSettings =
        HttpJsonCallSettings.<RenameNfsShareRequest, NfsShare>newBuilder()
            .setMethodDescriptor(renameNfsShareMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteNfsShareRequest, Operation> deleteNfsShareTransportSettings =
        HttpJsonCallSettings.<DeleteNfsShareRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteNfsShareMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListProvisioningQuotasRequest, ListProvisioningQuotasResponse>
        listProvisioningQuotasTransportSettings =
            HttpJsonCallSettings
                .<ListProvisioningQuotasRequest, ListProvisioningQuotasResponse>newBuilder()
                .setMethodDescriptor(listProvisioningQuotasMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<SubmitProvisioningConfigRequest, SubmitProvisioningConfigResponse>
        submitProvisioningConfigTransportSettings =
            HttpJsonCallSettings
                .<SubmitProvisioningConfigRequest, SubmitProvisioningConfigResponse>newBuilder()
                .setMethodDescriptor(submitProvisioningConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetProvisioningConfigRequest, ProvisioningConfig>
        getProvisioningConfigTransportSettings =
            HttpJsonCallSettings.<GetProvisioningConfigRequest, ProvisioningConfig>newBuilder()
                .setMethodDescriptor(getProvisioningConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateProvisioningConfigRequest, ProvisioningConfig>
        createProvisioningConfigTransportSettings =
            HttpJsonCallSettings.<CreateProvisioningConfigRequest, ProvisioningConfig>newBuilder()
                .setMethodDescriptor(createProvisioningConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateProvisioningConfigRequest, ProvisioningConfig>
        updateProvisioningConfigTransportSettings =
            HttpJsonCallSettings.<UpdateProvisioningConfigRequest, ProvisioningConfig>newBuilder()
                .setMethodDescriptor(updateProvisioningConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "provisioning_config.name",
                          String.valueOf(request.getProvisioningConfig().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<RenameNetworkRequest, Network> renameNetworkTransportSettings =
        HttpJsonCallSettings.<RenameNetworkRequest, Network>newBuilder()
            .setMethodDescriptor(renameNetworkMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListOSImagesRequest, ListOSImagesResponse> listOSImagesTransportSettings =
        HttpJsonCallSettings.<ListOSImagesRequest, ListOSImagesResponse>newBuilder()
            .setMethodDescriptor(listOSImagesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListLocationsRequest, ListLocationsResponse>
        listLocationsTransportSettings =
            HttpJsonCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
                .setMethodDescriptor(listLocationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        HttpJsonCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
    this.createNfsShareCallable =
        callableFactory.createUnaryCallable(
            createNfsShareTransportSettings, settings.createNfsShareSettings(), clientContext);
    this.createNfsShareOperationCallable =
        callableFactory.createOperationCallable(
            createNfsShareTransportSettings,
            settings.createNfsShareOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listInstancesMethodDescriptor);
    methodDescriptors.add(getInstanceMethodDescriptor);
    methodDescriptors.add(updateInstanceMethodDescriptor);
    methodDescriptors.add(renameInstanceMethodDescriptor);
    methodDescriptors.add(resetInstanceMethodDescriptor);
    methodDescriptors.add(startInstanceMethodDescriptor);
    methodDescriptors.add(stopInstanceMethodDescriptor);
    methodDescriptors.add(enableInteractiveSerialConsoleMethodDescriptor);
    methodDescriptors.add(disableInteractiveSerialConsoleMethodDescriptor);
    methodDescriptors.add(detachLunMethodDescriptor);
    methodDescriptors.add(listSSHKeysMethodDescriptor);
    methodDescriptors.add(createSSHKeyMethodDescriptor);
    methodDescriptors.add(deleteSSHKeyMethodDescriptor);
    methodDescriptors.add(listVolumesMethodDescriptor);
    methodDescriptors.add(getVolumeMethodDescriptor);
    methodDescriptors.add(updateVolumeMethodDescriptor);
    methodDescriptors.add(renameVolumeMethodDescriptor);
    methodDescriptors.add(evictVolumeMethodDescriptor);
    methodDescriptors.add(resizeVolumeMethodDescriptor);
    methodDescriptors.add(listNetworksMethodDescriptor);
    methodDescriptors.add(listNetworkUsageMethodDescriptor);
    methodDescriptors.add(getNetworkMethodDescriptor);
    methodDescriptors.add(updateNetworkMethodDescriptor);
    methodDescriptors.add(createVolumeSnapshotMethodDescriptor);
    methodDescriptors.add(restoreVolumeSnapshotMethodDescriptor);
    methodDescriptors.add(deleteVolumeSnapshotMethodDescriptor);
    methodDescriptors.add(getVolumeSnapshotMethodDescriptor);
    methodDescriptors.add(listVolumeSnapshotsMethodDescriptor);
    methodDescriptors.add(getLunMethodDescriptor);
    methodDescriptors.add(listLunsMethodDescriptor);
    methodDescriptors.add(evictLunMethodDescriptor);
    methodDescriptors.add(getNfsShareMethodDescriptor);
    methodDescriptors.add(listNfsSharesMethodDescriptor);
    methodDescriptors.add(updateNfsShareMethodDescriptor);
    methodDescriptors.add(createNfsShareMethodDescriptor);
    methodDescriptors.add(renameNfsShareMethodDescriptor);
    methodDescriptors.add(deleteNfsShareMethodDescriptor);
    methodDescriptors.add(listProvisioningQuotasMethodDescriptor);
    methodDescriptors.add(submitProvisioningConfigMethodDescriptor);
    methodDescriptors.add(getProvisioningConfigMethodDescriptor);
    methodDescriptors.add(createProvisioningConfigMethodDescriptor);
    methodDescriptors.add(updateProvisioningConfigMethodDescriptor);
    methodDescriptors.add(renameNetworkMethodDescriptor);
    methodDescriptors.add(listOSImagesMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
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
