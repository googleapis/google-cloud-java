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

package com.google.cloud.netapp.v1.stub;

import static com.google.cloud.netapp.v1.NetAppClient.ListActiveDirectoriesPagedResponse;
import static com.google.cloud.netapp.v1.NetAppClient.ListBackupPoliciesPagedResponse;
import static com.google.cloud.netapp.v1.NetAppClient.ListBackupVaultsPagedResponse;
import static com.google.cloud.netapp.v1.NetAppClient.ListBackupsPagedResponse;
import static com.google.cloud.netapp.v1.NetAppClient.ListKmsConfigsPagedResponse;
import static com.google.cloud.netapp.v1.NetAppClient.ListLocationsPagedResponse;
import static com.google.cloud.netapp.v1.NetAppClient.ListReplicationsPagedResponse;
import static com.google.cloud.netapp.v1.NetAppClient.ListSnapshotsPagedResponse;
import static com.google.cloud.netapp.v1.NetAppClient.ListStoragePoolsPagedResponse;
import static com.google.cloud.netapp.v1.NetAppClient.ListVolumesPagedResponse;

import com.google.api.HttpRule;
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
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.netapp.v1.ActiveDirectory;
import com.google.cloud.netapp.v1.Backup;
import com.google.cloud.netapp.v1.BackupPolicy;
import com.google.cloud.netapp.v1.BackupVault;
import com.google.cloud.netapp.v1.CreateActiveDirectoryRequest;
import com.google.cloud.netapp.v1.CreateBackupPolicyRequest;
import com.google.cloud.netapp.v1.CreateBackupRequest;
import com.google.cloud.netapp.v1.CreateBackupVaultRequest;
import com.google.cloud.netapp.v1.CreateKmsConfigRequest;
import com.google.cloud.netapp.v1.CreateReplicationRequest;
import com.google.cloud.netapp.v1.CreateSnapshotRequest;
import com.google.cloud.netapp.v1.CreateStoragePoolRequest;
import com.google.cloud.netapp.v1.CreateVolumeRequest;
import com.google.cloud.netapp.v1.DeleteActiveDirectoryRequest;
import com.google.cloud.netapp.v1.DeleteBackupPolicyRequest;
import com.google.cloud.netapp.v1.DeleteBackupRequest;
import com.google.cloud.netapp.v1.DeleteBackupVaultRequest;
import com.google.cloud.netapp.v1.DeleteKmsConfigRequest;
import com.google.cloud.netapp.v1.DeleteReplicationRequest;
import com.google.cloud.netapp.v1.DeleteSnapshotRequest;
import com.google.cloud.netapp.v1.DeleteStoragePoolRequest;
import com.google.cloud.netapp.v1.DeleteVolumeRequest;
import com.google.cloud.netapp.v1.EncryptVolumesRequest;
import com.google.cloud.netapp.v1.GetActiveDirectoryRequest;
import com.google.cloud.netapp.v1.GetBackupPolicyRequest;
import com.google.cloud.netapp.v1.GetBackupRequest;
import com.google.cloud.netapp.v1.GetBackupVaultRequest;
import com.google.cloud.netapp.v1.GetKmsConfigRequest;
import com.google.cloud.netapp.v1.GetReplicationRequest;
import com.google.cloud.netapp.v1.GetSnapshotRequest;
import com.google.cloud.netapp.v1.GetStoragePoolRequest;
import com.google.cloud.netapp.v1.GetVolumeRequest;
import com.google.cloud.netapp.v1.KmsConfig;
import com.google.cloud.netapp.v1.ListActiveDirectoriesRequest;
import com.google.cloud.netapp.v1.ListActiveDirectoriesResponse;
import com.google.cloud.netapp.v1.ListBackupPoliciesRequest;
import com.google.cloud.netapp.v1.ListBackupPoliciesResponse;
import com.google.cloud.netapp.v1.ListBackupVaultsRequest;
import com.google.cloud.netapp.v1.ListBackupVaultsResponse;
import com.google.cloud.netapp.v1.ListBackupsRequest;
import com.google.cloud.netapp.v1.ListBackupsResponse;
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
import com.google.cloud.netapp.v1.UpdateBackupPolicyRequest;
import com.google.cloud.netapp.v1.UpdateBackupRequest;
import com.google.cloud.netapp.v1.UpdateBackupVaultRequest;
import com.google.cloud.netapp.v1.UpdateKmsConfigRequest;
import com.google.cloud.netapp.v1.UpdateReplicationRequest;
import com.google.cloud.netapp.v1.UpdateSnapshotRequest;
import com.google.cloud.netapp.v1.UpdateStoragePoolRequest;
import com.google.cloud.netapp.v1.UpdateVolumeRequest;
import com.google.cloud.netapp.v1.VerifyKmsConfigRequest;
import com.google.cloud.netapp.v1.VerifyKmsConfigResponse;
import com.google.cloud.netapp.v1.Volume;
import com.google.common.collect.ImmutableMap;
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
 * REST stub implementation for the NetApp service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonNetAppStub extends NetAppStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(StoragePool.getDescriptor())
          .add(Empty.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(BackupPolicy.getDescriptor())
          .add(Volume.getDescriptor())
          .add(KmsConfig.getDescriptor())
          .add(Snapshot.getDescriptor())
          .add(BackupVault.getDescriptor())
          .add(ActiveDirectory.getDescriptor())
          .add(Replication.getDescriptor())
          .add(Backup.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<ListStoragePoolsRequest, ListStoragePoolsResponse>
      listStoragePoolsMethodDescriptor =
          ApiMethodDescriptor.<ListStoragePoolsRequest, ListStoragePoolsResponse>newBuilder()
              .setFullMethodName("google.cloud.netapp.v1.NetApp/ListStoragePools")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListStoragePoolsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/storagePools",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListStoragePoolsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListStoragePoolsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListStoragePoolsResponse>newBuilder()
                      .setDefaultInstance(ListStoragePoolsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateStoragePoolRequest, Operation>
      createStoragePoolMethodDescriptor =
          ApiMethodDescriptor.<CreateStoragePoolRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.netapp.v1.NetApp/CreateStoragePool")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateStoragePoolRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/storagePools",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateStoragePoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateStoragePoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "storagePoolId", request.getStoragePoolId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("storagePool", request.getStoragePool(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateStoragePoolRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetStoragePoolRequest, StoragePool>
      getStoragePoolMethodDescriptor =
          ApiMethodDescriptor.<GetStoragePoolRequest, StoragePool>newBuilder()
              .setFullMethodName("google.cloud.netapp.v1.NetApp/GetStoragePool")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetStoragePoolRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/storagePools/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetStoragePoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetStoragePoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<StoragePool>newBuilder()
                      .setDefaultInstance(StoragePool.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateStoragePoolRequest, Operation>
      updateStoragePoolMethodDescriptor =
          ApiMethodDescriptor.<UpdateStoragePoolRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.netapp.v1.NetApp/UpdateStoragePool")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateStoragePoolRequest>newBuilder()
                      .setPath(
                          "/v1/{storagePool.name=projects/*/locations/*/storagePools/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateStoragePoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "storagePool.name", request.getStoragePool().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateStoragePoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("storagePool", request.getStoragePool(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateStoragePoolRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteStoragePoolRequest, Operation>
      deleteStoragePoolMethodDescriptor =
          ApiMethodDescriptor.<DeleteStoragePoolRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.netapp.v1.NetApp/DeleteStoragePool")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteStoragePoolRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/storagePools/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteStoragePoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteStoragePoolRequest> serializer =
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
                  (DeleteStoragePoolRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListVolumesRequest, ListVolumesResponse>
      listVolumesMethodDescriptor =
          ApiMethodDescriptor.<ListVolumesRequest, ListVolumesResponse>newBuilder()
              .setFullMethodName("google.cloud.netapp.v1.NetApp/ListVolumes")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListVolumesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/volumes",
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
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
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
          .setFullMethodName("google.cloud.netapp.v1.NetApp/GetVolume")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetVolumeRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/volumes/*}",
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

  private static final ApiMethodDescriptor<CreateVolumeRequest, Operation>
      createVolumeMethodDescriptor =
          ApiMethodDescriptor.<CreateVolumeRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.netapp.v1.NetApp/CreateVolume")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateVolumeRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/volumes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateVolumeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateVolumeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "volumeId", request.getVolumeId());
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
                  (CreateVolumeRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateVolumeRequest, Operation>
      updateVolumeMethodDescriptor =
          ApiMethodDescriptor.<UpdateVolumeRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.netapp.v1.NetApp/UpdateVolume")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateVolumeRequest>newBuilder()
                      .setPath(
                          "/v1/{volume.name=projects/*/locations/*/volumes/*}",
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

  private static final ApiMethodDescriptor<DeleteVolumeRequest, Operation>
      deleteVolumeMethodDescriptor =
          ApiMethodDescriptor.<DeleteVolumeRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.netapp.v1.NetApp/DeleteVolume")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteVolumeRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/volumes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteVolumeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteVolumeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "force", request.getForce());
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
                  (DeleteVolumeRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<RevertVolumeRequest, Operation>
      revertVolumeMethodDescriptor =
          ApiMethodDescriptor.<RevertVolumeRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.netapp.v1.NetApp/RevertVolume")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RevertVolumeRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/volumes/*}:revert",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RevertVolumeRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RevertVolumeRequest> serializer =
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
                  (RevertVolumeRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListSnapshotsRequest, ListSnapshotsResponse>
      listSnapshotsMethodDescriptor =
          ApiMethodDescriptor.<ListSnapshotsRequest, ListSnapshotsResponse>newBuilder()
              .setFullMethodName("google.cloud.netapp.v1.NetApp/ListSnapshots")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListSnapshotsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/volumes/*}/snapshots",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListSnapshotsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListSnapshotsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListSnapshotsResponse>newBuilder()
                      .setDefaultInstance(ListSnapshotsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetSnapshotRequest, Snapshot>
      getSnapshotMethodDescriptor =
          ApiMethodDescriptor.<GetSnapshotRequest, Snapshot>newBuilder()
              .setFullMethodName("google.cloud.netapp.v1.NetApp/GetSnapshot")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetSnapshotRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/volumes/*/snapshots/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetSnapshotRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetSnapshotRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Snapshot>newBuilder()
                      .setDefaultInstance(Snapshot.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateSnapshotRequest, Operation>
      createSnapshotMethodDescriptor =
          ApiMethodDescriptor.<CreateSnapshotRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.netapp.v1.NetApp/CreateSnapshot")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateSnapshotRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/volumes/*}/snapshots",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSnapshotRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSnapshotRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "snapshotId", request.getSnapshotId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("snapshot", request.getSnapshot(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateSnapshotRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteSnapshotRequest, Operation>
      deleteSnapshotMethodDescriptor =
          ApiMethodDescriptor.<DeleteSnapshotRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.netapp.v1.NetApp/DeleteSnapshot")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteSnapshotRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/volumes/*/snapshots/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSnapshotRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSnapshotRequest> serializer =
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
                  (DeleteSnapshotRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateSnapshotRequest, Operation>
      updateSnapshotMethodDescriptor =
          ApiMethodDescriptor.<UpdateSnapshotRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.netapp.v1.NetApp/UpdateSnapshot")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateSnapshotRequest>newBuilder()
                      .setPath(
                          "/v1/{snapshot.name=projects/*/locations/*/volumes/*/snapshots/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSnapshotRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "snapshot.name", request.getSnapshot().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSnapshotRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("snapshot", request.getSnapshot(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateSnapshotRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          ListActiveDirectoriesRequest, ListActiveDirectoriesResponse>
      listActiveDirectoriesMethodDescriptor =
          ApiMethodDescriptor
              .<ListActiveDirectoriesRequest, ListActiveDirectoriesResponse>newBuilder()
              .setFullMethodName("google.cloud.netapp.v1.NetApp/ListActiveDirectories")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListActiveDirectoriesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/activeDirectories",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListActiveDirectoriesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListActiveDirectoriesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListActiveDirectoriesResponse>newBuilder()
                      .setDefaultInstance(ListActiveDirectoriesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetActiveDirectoryRequest, ActiveDirectory>
      getActiveDirectoryMethodDescriptor =
          ApiMethodDescriptor.<GetActiveDirectoryRequest, ActiveDirectory>newBuilder()
              .setFullMethodName("google.cloud.netapp.v1.NetApp/GetActiveDirectory")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetActiveDirectoryRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/activeDirectories/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetActiveDirectoryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetActiveDirectoryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ActiveDirectory>newBuilder()
                      .setDefaultInstance(ActiveDirectory.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateActiveDirectoryRequest, Operation>
      createActiveDirectoryMethodDescriptor =
          ApiMethodDescriptor.<CreateActiveDirectoryRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.netapp.v1.NetApp/CreateActiveDirectory")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateActiveDirectoryRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/activeDirectories",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateActiveDirectoryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateActiveDirectoryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "activeDirectoryId", request.getActiveDirectoryId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("activeDirectory", request.getActiveDirectory(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateActiveDirectoryRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateActiveDirectoryRequest, Operation>
      updateActiveDirectoryMethodDescriptor =
          ApiMethodDescriptor.<UpdateActiveDirectoryRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.netapp.v1.NetApp/UpdateActiveDirectory")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateActiveDirectoryRequest>newBuilder()
                      .setPath(
                          "/v1/{activeDirectory.name=projects/*/locations/*/activeDirectories/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateActiveDirectoryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "activeDirectory.name",
                                request.getActiveDirectory().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateActiveDirectoryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("activeDirectory", request.getActiveDirectory(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateActiveDirectoryRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteActiveDirectoryRequest, Operation>
      deleteActiveDirectoryMethodDescriptor =
          ApiMethodDescriptor.<DeleteActiveDirectoryRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.netapp.v1.NetApp/DeleteActiveDirectory")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteActiveDirectoryRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/activeDirectories/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteActiveDirectoryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteActiveDirectoryRequest> serializer =
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
                  (DeleteActiveDirectoryRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListKmsConfigsRequest, ListKmsConfigsResponse>
      listKmsConfigsMethodDescriptor =
          ApiMethodDescriptor.<ListKmsConfigsRequest, ListKmsConfigsResponse>newBuilder()
              .setFullMethodName("google.cloud.netapp.v1.NetApp/ListKmsConfigs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListKmsConfigsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/kmsConfigs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListKmsConfigsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListKmsConfigsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListKmsConfigsResponse>newBuilder()
                      .setDefaultInstance(ListKmsConfigsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateKmsConfigRequest, Operation>
      createKmsConfigMethodDescriptor =
          ApiMethodDescriptor.<CreateKmsConfigRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.netapp.v1.NetApp/CreateKmsConfig")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateKmsConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/kmsConfigs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateKmsConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateKmsConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "kmsConfigId", request.getKmsConfigId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("kmsConfig", request.getKmsConfig(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateKmsConfigRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetKmsConfigRequest, KmsConfig>
      getKmsConfigMethodDescriptor =
          ApiMethodDescriptor.<GetKmsConfigRequest, KmsConfig>newBuilder()
              .setFullMethodName("google.cloud.netapp.v1.NetApp/GetKmsConfig")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetKmsConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/kmsConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetKmsConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetKmsConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<KmsConfig>newBuilder()
                      .setDefaultInstance(KmsConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateKmsConfigRequest, Operation>
      updateKmsConfigMethodDescriptor =
          ApiMethodDescriptor.<UpdateKmsConfigRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.netapp.v1.NetApp/UpdateKmsConfig")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateKmsConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{kmsConfig.name=projects/*/locations/*/kmsConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateKmsConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "kmsConfig.name", request.getKmsConfig().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateKmsConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("kmsConfig", request.getKmsConfig(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateKmsConfigRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<EncryptVolumesRequest, Operation>
      encryptVolumesMethodDescriptor =
          ApiMethodDescriptor.<EncryptVolumesRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.netapp.v1.NetApp/EncryptVolumes")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<EncryptVolumesRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/kmsConfigs/*}:encrypt",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<EncryptVolumesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<EncryptVolumesRequest> serializer =
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
                  (EncryptVolumesRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<VerifyKmsConfigRequest, VerifyKmsConfigResponse>
      verifyKmsConfigMethodDescriptor =
          ApiMethodDescriptor.<VerifyKmsConfigRequest, VerifyKmsConfigResponse>newBuilder()
              .setFullMethodName("google.cloud.netapp.v1.NetApp/VerifyKmsConfig")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<VerifyKmsConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/kmsConfigs/*}:verify",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<VerifyKmsConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<VerifyKmsConfigRequest> serializer =
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
                  ProtoMessageResponseParser.<VerifyKmsConfigResponse>newBuilder()
                      .setDefaultInstance(VerifyKmsConfigResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteKmsConfigRequest, Operation>
      deleteKmsConfigMethodDescriptor =
          ApiMethodDescriptor.<DeleteKmsConfigRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.netapp.v1.NetApp/DeleteKmsConfig")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteKmsConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/kmsConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteKmsConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteKmsConfigRequest> serializer =
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
                  (DeleteKmsConfigRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListReplicationsRequest, ListReplicationsResponse>
      listReplicationsMethodDescriptor =
          ApiMethodDescriptor.<ListReplicationsRequest, ListReplicationsResponse>newBuilder()
              .setFullMethodName("google.cloud.netapp.v1.NetApp/ListReplications")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListReplicationsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/volumes/*}/replications",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListReplicationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListReplicationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListReplicationsResponse>newBuilder()
                      .setDefaultInstance(ListReplicationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetReplicationRequest, Replication>
      getReplicationMethodDescriptor =
          ApiMethodDescriptor.<GetReplicationRequest, Replication>newBuilder()
              .setFullMethodName("google.cloud.netapp.v1.NetApp/GetReplication")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetReplicationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/volumes/*/replications/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetReplicationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetReplicationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Replication>newBuilder()
                      .setDefaultInstance(Replication.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateReplicationRequest, Operation>
      createReplicationMethodDescriptor =
          ApiMethodDescriptor.<CreateReplicationRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.netapp.v1.NetApp/CreateReplication")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateReplicationRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/volumes/*}/replications",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateReplicationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateReplicationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "replicationId", request.getReplicationId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("replication", request.getReplication(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateReplicationRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteReplicationRequest, Operation>
      deleteReplicationMethodDescriptor =
          ApiMethodDescriptor.<DeleteReplicationRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.netapp.v1.NetApp/DeleteReplication")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteReplicationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/volumes/*/replications/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteReplicationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteReplicationRequest> serializer =
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
                  (DeleteReplicationRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateReplicationRequest, Operation>
      updateReplicationMethodDescriptor =
          ApiMethodDescriptor.<UpdateReplicationRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.netapp.v1.NetApp/UpdateReplication")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateReplicationRequest>newBuilder()
                      .setPath(
                          "/v1/{replication.name=projects/*/locations/*/volumes/*/replications/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateReplicationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "replication.name", request.getReplication().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateReplicationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("replication", request.getReplication(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateReplicationRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<StopReplicationRequest, Operation>
      stopReplicationMethodDescriptor =
          ApiMethodDescriptor.<StopReplicationRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.netapp.v1.NetApp/StopReplication")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<StopReplicationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/volumes/*/replications/*}:stop",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<StopReplicationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<StopReplicationRequest> serializer =
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
                  (StopReplicationRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ResumeReplicationRequest, Operation>
      resumeReplicationMethodDescriptor =
          ApiMethodDescriptor.<ResumeReplicationRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.netapp.v1.NetApp/ResumeReplication")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ResumeReplicationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/volumes/*/replications/*}:resume",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ResumeReplicationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ResumeReplicationRequest> serializer =
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
                  (ResumeReplicationRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ReverseReplicationDirectionRequest, Operation>
      reverseReplicationDirectionMethodDescriptor =
          ApiMethodDescriptor.<ReverseReplicationDirectionRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.netapp.v1.NetApp/ReverseReplicationDirection")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ReverseReplicationDirectionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/volumes/*/replications/*}:reverseDirection",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ReverseReplicationDirectionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ReverseReplicationDirectionRequest> serializer =
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
                  (ReverseReplicationDirectionRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CreateBackupVaultRequest, Operation>
      createBackupVaultMethodDescriptor =
          ApiMethodDescriptor.<CreateBackupVaultRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.netapp.v1.NetApp/CreateBackupVault")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateBackupVaultRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/backupVaults",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateBackupVaultRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateBackupVaultRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "backupVaultId", request.getBackupVaultId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("backupVault", request.getBackupVault(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateBackupVaultRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetBackupVaultRequest, BackupVault>
      getBackupVaultMethodDescriptor =
          ApiMethodDescriptor.<GetBackupVaultRequest, BackupVault>newBuilder()
              .setFullMethodName("google.cloud.netapp.v1.NetApp/GetBackupVault")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetBackupVaultRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/backupVaults/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetBackupVaultRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetBackupVaultRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BackupVault>newBuilder()
                      .setDefaultInstance(BackupVault.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListBackupVaultsRequest, ListBackupVaultsResponse>
      listBackupVaultsMethodDescriptor =
          ApiMethodDescriptor.<ListBackupVaultsRequest, ListBackupVaultsResponse>newBuilder()
              .setFullMethodName("google.cloud.netapp.v1.NetApp/ListBackupVaults")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListBackupVaultsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/backupVaults",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListBackupVaultsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListBackupVaultsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListBackupVaultsResponse>newBuilder()
                      .setDefaultInstance(ListBackupVaultsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateBackupVaultRequest, Operation>
      updateBackupVaultMethodDescriptor =
          ApiMethodDescriptor.<UpdateBackupVaultRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.netapp.v1.NetApp/UpdateBackupVault")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateBackupVaultRequest>newBuilder()
                      .setPath(
                          "/v1/{backupVault.name=projects/*/locations/*/backupVaults/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateBackupVaultRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "backupVault.name", request.getBackupVault().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateBackupVaultRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("backupVault", request.getBackupVault(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateBackupVaultRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteBackupVaultRequest, Operation>
      deleteBackupVaultMethodDescriptor =
          ApiMethodDescriptor.<DeleteBackupVaultRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.netapp.v1.NetApp/DeleteBackupVault")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteBackupVaultRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/backupVaults/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteBackupVaultRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteBackupVaultRequest> serializer =
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
                  (DeleteBackupVaultRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CreateBackupRequest, Operation>
      createBackupMethodDescriptor =
          ApiMethodDescriptor.<CreateBackupRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.netapp.v1.NetApp/CreateBackup")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateBackupRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/backupVaults/*}/backups",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateBackupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateBackupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "backupId", request.getBackupId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("backup", request.getBackup(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateBackupRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetBackupRequest, Backup> getBackupMethodDescriptor =
      ApiMethodDescriptor.<GetBackupRequest, Backup>newBuilder()
          .setFullMethodName("google.cloud.netapp.v1.NetApp/GetBackup")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetBackupRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/backupVaults/*/backups/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetBackupRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetBackupRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Backup>newBuilder()
                  .setDefaultInstance(Backup.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListBackupsRequest, ListBackupsResponse>
      listBackupsMethodDescriptor =
          ApiMethodDescriptor.<ListBackupsRequest, ListBackupsResponse>newBuilder()
              .setFullMethodName("google.cloud.netapp.v1.NetApp/ListBackups")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListBackupsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/backupVaults/*}/backups",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListBackupsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListBackupsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListBackupsResponse>newBuilder()
                      .setDefaultInstance(ListBackupsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteBackupRequest, Operation>
      deleteBackupMethodDescriptor =
          ApiMethodDescriptor.<DeleteBackupRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.netapp.v1.NetApp/DeleteBackup")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteBackupRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/backupVaults/*/backups/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteBackupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteBackupRequest> serializer =
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
                  (DeleteBackupRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateBackupRequest, Operation>
      updateBackupMethodDescriptor =
          ApiMethodDescriptor.<UpdateBackupRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.netapp.v1.NetApp/UpdateBackup")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateBackupRequest>newBuilder()
                      .setPath(
                          "/v1/{backup.name=projects/*/locations/*/backupVaults/*/backups/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateBackupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "backup.name", request.getBackup().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateBackupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("backup", request.getBackup(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateBackupRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CreateBackupPolicyRequest, Operation>
      createBackupPolicyMethodDescriptor =
          ApiMethodDescriptor.<CreateBackupPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.netapp.v1.NetApp/CreateBackupPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateBackupPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/backupPolicies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateBackupPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateBackupPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "backupPolicyId", request.getBackupPolicyId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("backupPolicy", request.getBackupPolicy(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateBackupPolicyRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetBackupPolicyRequest, BackupPolicy>
      getBackupPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetBackupPolicyRequest, BackupPolicy>newBuilder()
              .setFullMethodName("google.cloud.netapp.v1.NetApp/GetBackupPolicy")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetBackupPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/backupPolicies/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetBackupPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetBackupPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BackupPolicy>newBuilder()
                      .setDefaultInstance(BackupPolicy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListBackupPoliciesRequest, ListBackupPoliciesResponse>
      listBackupPoliciesMethodDescriptor =
          ApiMethodDescriptor.<ListBackupPoliciesRequest, ListBackupPoliciesResponse>newBuilder()
              .setFullMethodName("google.cloud.netapp.v1.NetApp/ListBackupPolicies")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListBackupPoliciesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/backupPolicies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListBackupPoliciesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListBackupPoliciesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListBackupPoliciesResponse>newBuilder()
                      .setDefaultInstance(ListBackupPoliciesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateBackupPolicyRequest, Operation>
      updateBackupPolicyMethodDescriptor =
          ApiMethodDescriptor.<UpdateBackupPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.netapp.v1.NetApp/UpdateBackupPolicy")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateBackupPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{backupPolicy.name=projects/*/locations/*/backupPolicies/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateBackupPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "backupPolicy.name", request.getBackupPolicy().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateBackupPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("backupPolicy", request.getBackupPolicy(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateBackupPolicyRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteBackupPolicyRequest, Operation>
      deleteBackupPolicyMethodDescriptor =
          ApiMethodDescriptor.<DeleteBackupPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.netapp.v1.NetApp/DeleteBackupPolicy")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteBackupPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/backupPolicies/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteBackupPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteBackupPolicyRequest> serializer =
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
                  (DeleteBackupPolicyRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
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
                          "/v1/{name=projects/*}/locations",
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
                          "/v1/{name=projects/*/locations/*}",
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
  private final UnaryCallable<CreateBackupVaultRequest, Operation> createBackupVaultCallable;
  private final OperationCallable<CreateBackupVaultRequest, BackupVault, OperationMetadata>
      createBackupVaultOperationCallable;
  private final UnaryCallable<GetBackupVaultRequest, BackupVault> getBackupVaultCallable;
  private final UnaryCallable<ListBackupVaultsRequest, ListBackupVaultsResponse>
      listBackupVaultsCallable;
  private final UnaryCallable<ListBackupVaultsRequest, ListBackupVaultsPagedResponse>
      listBackupVaultsPagedCallable;
  private final UnaryCallable<UpdateBackupVaultRequest, Operation> updateBackupVaultCallable;
  private final OperationCallable<UpdateBackupVaultRequest, BackupVault, OperationMetadata>
      updateBackupVaultOperationCallable;
  private final UnaryCallable<DeleteBackupVaultRequest, Operation> deleteBackupVaultCallable;
  private final OperationCallable<DeleteBackupVaultRequest, Empty, OperationMetadata>
      deleteBackupVaultOperationCallable;
  private final UnaryCallable<CreateBackupRequest, Operation> createBackupCallable;
  private final OperationCallable<CreateBackupRequest, Backup, OperationMetadata>
      createBackupOperationCallable;
  private final UnaryCallable<GetBackupRequest, Backup> getBackupCallable;
  private final UnaryCallable<ListBackupsRequest, ListBackupsResponse> listBackupsCallable;
  private final UnaryCallable<ListBackupsRequest, ListBackupsPagedResponse>
      listBackupsPagedCallable;
  private final UnaryCallable<DeleteBackupRequest, Operation> deleteBackupCallable;
  private final OperationCallable<DeleteBackupRequest, Empty, OperationMetadata>
      deleteBackupOperationCallable;
  private final UnaryCallable<UpdateBackupRequest, Operation> updateBackupCallable;
  private final OperationCallable<UpdateBackupRequest, Backup, OperationMetadata>
      updateBackupOperationCallable;
  private final UnaryCallable<CreateBackupPolicyRequest, Operation> createBackupPolicyCallable;
  private final OperationCallable<CreateBackupPolicyRequest, BackupPolicy, OperationMetadata>
      createBackupPolicyOperationCallable;
  private final UnaryCallable<GetBackupPolicyRequest, BackupPolicy> getBackupPolicyCallable;
  private final UnaryCallable<ListBackupPoliciesRequest, ListBackupPoliciesResponse>
      listBackupPoliciesCallable;
  private final UnaryCallable<ListBackupPoliciesRequest, ListBackupPoliciesPagedResponse>
      listBackupPoliciesPagedCallable;
  private final UnaryCallable<UpdateBackupPolicyRequest, Operation> updateBackupPolicyCallable;
  private final OperationCallable<UpdateBackupPolicyRequest, BackupPolicy, OperationMetadata>
      updateBackupPolicyOperationCallable;
  private final UnaryCallable<DeleteBackupPolicyRequest, Operation> deleteBackupPolicyCallable;
  private final OperationCallable<DeleteBackupPolicyRequest, Empty, OperationMetadata>
      deleteBackupPolicyOperationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonNetAppStub create(NetAppStubSettings settings) throws IOException {
    return new HttpJsonNetAppStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonNetAppStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonNetAppStub(NetAppStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonNetAppStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonNetAppStub(
        NetAppStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonNetAppStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonNetAppStub(NetAppStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonNetAppCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonNetAppStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonNetAppStub(
      NetAppStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(
            clientContext,
            callableFactory,
            typeRegistry,
            ImmutableMap.<String, HttpRule>builder()
                .put(
                    "google.longrunning.Operations.CancelOperation",
                    HttpRule.newBuilder()
                        .setPost("/v1/{name=projects/*/locations/*/operations/*}:cancel")
                        .build())
                .put(
                    "google.longrunning.Operations.DeleteOperation",
                    HttpRule.newBuilder()
                        .setDelete("/v1/{name=projects/*/locations/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.GetOperation",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/locations/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.ListOperations",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/locations/*}/operations")
                        .build())
                .build());

    HttpJsonCallSettings<ListStoragePoolsRequest, ListStoragePoolsResponse>
        listStoragePoolsTransportSettings =
            HttpJsonCallSettings.<ListStoragePoolsRequest, ListStoragePoolsResponse>newBuilder()
                .setMethodDescriptor(listStoragePoolsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateStoragePoolRequest, Operation> createStoragePoolTransportSettings =
        HttpJsonCallSettings.<CreateStoragePoolRequest, Operation>newBuilder()
            .setMethodDescriptor(createStoragePoolMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetStoragePoolRequest, StoragePool> getStoragePoolTransportSettings =
        HttpJsonCallSettings.<GetStoragePoolRequest, StoragePool>newBuilder()
            .setMethodDescriptor(getStoragePoolMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateStoragePoolRequest, Operation> updateStoragePoolTransportSettings =
        HttpJsonCallSettings.<UpdateStoragePoolRequest, Operation>newBuilder()
            .setMethodDescriptor(updateStoragePoolMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "storage_pool.name", String.valueOf(request.getStoragePool().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteStoragePoolRequest, Operation> deleteStoragePoolTransportSettings =
        HttpJsonCallSettings.<DeleteStoragePoolRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteStoragePoolMethodDescriptor)
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
    HttpJsonCallSettings<CreateVolumeRequest, Operation> createVolumeTransportSettings =
        HttpJsonCallSettings.<CreateVolumeRequest, Operation>newBuilder()
            .setMethodDescriptor(createVolumeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
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
    HttpJsonCallSettings<DeleteVolumeRequest, Operation> deleteVolumeTransportSettings =
        HttpJsonCallSettings.<DeleteVolumeRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteVolumeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<RevertVolumeRequest, Operation> revertVolumeTransportSettings =
        HttpJsonCallSettings.<RevertVolumeRequest, Operation>newBuilder()
            .setMethodDescriptor(revertVolumeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListSnapshotsRequest, ListSnapshotsResponse>
        listSnapshotsTransportSettings =
            HttpJsonCallSettings.<ListSnapshotsRequest, ListSnapshotsResponse>newBuilder()
                .setMethodDescriptor(listSnapshotsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetSnapshotRequest, Snapshot> getSnapshotTransportSettings =
        HttpJsonCallSettings.<GetSnapshotRequest, Snapshot>newBuilder()
            .setMethodDescriptor(getSnapshotMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateSnapshotRequest, Operation> createSnapshotTransportSettings =
        HttpJsonCallSettings.<CreateSnapshotRequest, Operation>newBuilder()
            .setMethodDescriptor(createSnapshotMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteSnapshotRequest, Operation> deleteSnapshotTransportSettings =
        HttpJsonCallSettings.<DeleteSnapshotRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteSnapshotMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateSnapshotRequest, Operation> updateSnapshotTransportSettings =
        HttpJsonCallSettings.<UpdateSnapshotRequest, Operation>newBuilder()
            .setMethodDescriptor(updateSnapshotMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("snapshot.name", String.valueOf(request.getSnapshot().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListActiveDirectoriesRequest, ListActiveDirectoriesResponse>
        listActiveDirectoriesTransportSettings =
            HttpJsonCallSettings
                .<ListActiveDirectoriesRequest, ListActiveDirectoriesResponse>newBuilder()
                .setMethodDescriptor(listActiveDirectoriesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetActiveDirectoryRequest, ActiveDirectory>
        getActiveDirectoryTransportSettings =
            HttpJsonCallSettings.<GetActiveDirectoryRequest, ActiveDirectory>newBuilder()
                .setMethodDescriptor(getActiveDirectoryMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateActiveDirectoryRequest, Operation>
        createActiveDirectoryTransportSettings =
            HttpJsonCallSettings.<CreateActiveDirectoryRequest, Operation>newBuilder()
                .setMethodDescriptor(createActiveDirectoryMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateActiveDirectoryRequest, Operation>
        updateActiveDirectoryTransportSettings =
            HttpJsonCallSettings.<UpdateActiveDirectoryRequest, Operation>newBuilder()
                .setMethodDescriptor(updateActiveDirectoryMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "active_directory.name",
                          String.valueOf(request.getActiveDirectory().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteActiveDirectoryRequest, Operation>
        deleteActiveDirectoryTransportSettings =
            HttpJsonCallSettings.<DeleteActiveDirectoryRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteActiveDirectoryMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListKmsConfigsRequest, ListKmsConfigsResponse>
        listKmsConfigsTransportSettings =
            HttpJsonCallSettings.<ListKmsConfigsRequest, ListKmsConfigsResponse>newBuilder()
                .setMethodDescriptor(listKmsConfigsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateKmsConfigRequest, Operation> createKmsConfigTransportSettings =
        HttpJsonCallSettings.<CreateKmsConfigRequest, Operation>newBuilder()
            .setMethodDescriptor(createKmsConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetKmsConfigRequest, KmsConfig> getKmsConfigTransportSettings =
        HttpJsonCallSettings.<GetKmsConfigRequest, KmsConfig>newBuilder()
            .setMethodDescriptor(getKmsConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateKmsConfigRequest, Operation> updateKmsConfigTransportSettings =
        HttpJsonCallSettings.<UpdateKmsConfigRequest, Operation>newBuilder()
            .setMethodDescriptor(updateKmsConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("kms_config.name", String.valueOf(request.getKmsConfig().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<EncryptVolumesRequest, Operation> encryptVolumesTransportSettings =
        HttpJsonCallSettings.<EncryptVolumesRequest, Operation>newBuilder()
            .setMethodDescriptor(encryptVolumesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<VerifyKmsConfigRequest, VerifyKmsConfigResponse>
        verifyKmsConfigTransportSettings =
            HttpJsonCallSettings.<VerifyKmsConfigRequest, VerifyKmsConfigResponse>newBuilder()
                .setMethodDescriptor(verifyKmsConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteKmsConfigRequest, Operation> deleteKmsConfigTransportSettings =
        HttpJsonCallSettings.<DeleteKmsConfigRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteKmsConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListReplicationsRequest, ListReplicationsResponse>
        listReplicationsTransportSettings =
            HttpJsonCallSettings.<ListReplicationsRequest, ListReplicationsResponse>newBuilder()
                .setMethodDescriptor(listReplicationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetReplicationRequest, Replication> getReplicationTransportSettings =
        HttpJsonCallSettings.<GetReplicationRequest, Replication>newBuilder()
            .setMethodDescriptor(getReplicationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateReplicationRequest, Operation> createReplicationTransportSettings =
        HttpJsonCallSettings.<CreateReplicationRequest, Operation>newBuilder()
            .setMethodDescriptor(createReplicationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteReplicationRequest, Operation> deleteReplicationTransportSettings =
        HttpJsonCallSettings.<DeleteReplicationRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteReplicationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateReplicationRequest, Operation> updateReplicationTransportSettings =
        HttpJsonCallSettings.<UpdateReplicationRequest, Operation>newBuilder()
            .setMethodDescriptor(updateReplicationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "replication.name", String.valueOf(request.getReplication().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<StopReplicationRequest, Operation> stopReplicationTransportSettings =
        HttpJsonCallSettings.<StopReplicationRequest, Operation>newBuilder()
            .setMethodDescriptor(stopReplicationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ResumeReplicationRequest, Operation> resumeReplicationTransportSettings =
        HttpJsonCallSettings.<ResumeReplicationRequest, Operation>newBuilder()
            .setMethodDescriptor(resumeReplicationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ReverseReplicationDirectionRequest, Operation>
        reverseReplicationDirectionTransportSettings =
            HttpJsonCallSettings.<ReverseReplicationDirectionRequest, Operation>newBuilder()
                .setMethodDescriptor(reverseReplicationDirectionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateBackupVaultRequest, Operation> createBackupVaultTransportSettings =
        HttpJsonCallSettings.<CreateBackupVaultRequest, Operation>newBuilder()
            .setMethodDescriptor(createBackupVaultMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetBackupVaultRequest, BackupVault> getBackupVaultTransportSettings =
        HttpJsonCallSettings.<GetBackupVaultRequest, BackupVault>newBuilder()
            .setMethodDescriptor(getBackupVaultMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListBackupVaultsRequest, ListBackupVaultsResponse>
        listBackupVaultsTransportSettings =
            HttpJsonCallSettings.<ListBackupVaultsRequest, ListBackupVaultsResponse>newBuilder()
                .setMethodDescriptor(listBackupVaultsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateBackupVaultRequest, Operation> updateBackupVaultTransportSettings =
        HttpJsonCallSettings.<UpdateBackupVaultRequest, Operation>newBuilder()
            .setMethodDescriptor(updateBackupVaultMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "backup_vault.name", String.valueOf(request.getBackupVault().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteBackupVaultRequest, Operation> deleteBackupVaultTransportSettings =
        HttpJsonCallSettings.<DeleteBackupVaultRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteBackupVaultMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateBackupRequest, Operation> createBackupTransportSettings =
        HttpJsonCallSettings.<CreateBackupRequest, Operation>newBuilder()
            .setMethodDescriptor(createBackupMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetBackupRequest, Backup> getBackupTransportSettings =
        HttpJsonCallSettings.<GetBackupRequest, Backup>newBuilder()
            .setMethodDescriptor(getBackupMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListBackupsRequest, ListBackupsResponse> listBackupsTransportSettings =
        HttpJsonCallSettings.<ListBackupsRequest, ListBackupsResponse>newBuilder()
            .setMethodDescriptor(listBackupsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteBackupRequest, Operation> deleteBackupTransportSettings =
        HttpJsonCallSettings.<DeleteBackupRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteBackupMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateBackupRequest, Operation> updateBackupTransportSettings =
        HttpJsonCallSettings.<UpdateBackupRequest, Operation>newBuilder()
            .setMethodDescriptor(updateBackupMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("backup.name", String.valueOf(request.getBackup().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateBackupPolicyRequest, Operation> createBackupPolicyTransportSettings =
        HttpJsonCallSettings.<CreateBackupPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(createBackupPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetBackupPolicyRequest, BackupPolicy> getBackupPolicyTransportSettings =
        HttpJsonCallSettings.<GetBackupPolicyRequest, BackupPolicy>newBuilder()
            .setMethodDescriptor(getBackupPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListBackupPoliciesRequest, ListBackupPoliciesResponse>
        listBackupPoliciesTransportSettings =
            HttpJsonCallSettings.<ListBackupPoliciesRequest, ListBackupPoliciesResponse>newBuilder()
                .setMethodDescriptor(listBackupPoliciesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateBackupPolicyRequest, Operation> updateBackupPolicyTransportSettings =
        HttpJsonCallSettings.<UpdateBackupPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(updateBackupPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "backup_policy.name", String.valueOf(request.getBackupPolicy().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteBackupPolicyRequest, Operation> deleteBackupPolicyTransportSettings =
        HttpJsonCallSettings.<DeleteBackupPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteBackupPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
    this.createVolumeCallable =
        callableFactory.createUnaryCallable(
            createVolumeTransportSettings, settings.createVolumeSettings(), clientContext);
    this.createVolumeOperationCallable =
        callableFactory.createOperationCallable(
            createVolumeTransportSettings,
            settings.createVolumeOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateVolumeCallable =
        callableFactory.createUnaryCallable(
            updateVolumeTransportSettings, settings.updateVolumeSettings(), clientContext);
    this.updateVolumeOperationCallable =
        callableFactory.createOperationCallable(
            updateVolumeTransportSettings,
            settings.updateVolumeOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteVolumeCallable =
        callableFactory.createUnaryCallable(
            deleteVolumeTransportSettings, settings.deleteVolumeSettings(), clientContext);
    this.deleteVolumeOperationCallable =
        callableFactory.createOperationCallable(
            deleteVolumeTransportSettings,
            settings.deleteVolumeOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.revertVolumeCallable =
        callableFactory.createUnaryCallable(
            revertVolumeTransportSettings, settings.revertVolumeSettings(), clientContext);
    this.revertVolumeOperationCallable =
        callableFactory.createOperationCallable(
            revertVolumeTransportSettings,
            settings.revertVolumeOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
    this.deleteSnapshotCallable =
        callableFactory.createUnaryCallable(
            deleteSnapshotTransportSettings, settings.deleteSnapshotSettings(), clientContext);
    this.deleteSnapshotOperationCallable =
        callableFactory.createOperationCallable(
            deleteSnapshotTransportSettings,
            settings.deleteSnapshotOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateSnapshotCallable =
        callableFactory.createUnaryCallable(
            updateSnapshotTransportSettings, settings.updateSnapshotSettings(), clientContext);
    this.updateSnapshotOperationCallable =
        callableFactory.createOperationCallable(
            updateSnapshotTransportSettings,
            settings.updateSnapshotOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
    this.encryptVolumesCallable =
        callableFactory.createUnaryCallable(
            encryptVolumesTransportSettings, settings.encryptVolumesSettings(), clientContext);
    this.encryptVolumesOperationCallable =
        callableFactory.createOperationCallable(
            encryptVolumesTransportSettings,
            settings.encryptVolumesOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
    this.stopReplicationCallable =
        callableFactory.createUnaryCallable(
            stopReplicationTransportSettings, settings.stopReplicationSettings(), clientContext);
    this.stopReplicationOperationCallable =
        callableFactory.createOperationCallable(
            stopReplicationTransportSettings,
            settings.stopReplicationOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
    this.createBackupVaultCallable =
        callableFactory.createUnaryCallable(
            createBackupVaultTransportSettings,
            settings.createBackupVaultSettings(),
            clientContext);
    this.createBackupVaultOperationCallable =
        callableFactory.createOperationCallable(
            createBackupVaultTransportSettings,
            settings.createBackupVaultOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getBackupVaultCallable =
        callableFactory.createUnaryCallable(
            getBackupVaultTransportSettings, settings.getBackupVaultSettings(), clientContext);
    this.listBackupVaultsCallable =
        callableFactory.createUnaryCallable(
            listBackupVaultsTransportSettings, settings.listBackupVaultsSettings(), clientContext);
    this.listBackupVaultsPagedCallable =
        callableFactory.createPagedCallable(
            listBackupVaultsTransportSettings, settings.listBackupVaultsSettings(), clientContext);
    this.updateBackupVaultCallable =
        callableFactory.createUnaryCallable(
            updateBackupVaultTransportSettings,
            settings.updateBackupVaultSettings(),
            clientContext);
    this.updateBackupVaultOperationCallable =
        callableFactory.createOperationCallable(
            updateBackupVaultTransportSettings,
            settings.updateBackupVaultOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteBackupVaultCallable =
        callableFactory.createUnaryCallable(
            deleteBackupVaultTransportSettings,
            settings.deleteBackupVaultSettings(),
            clientContext);
    this.deleteBackupVaultOperationCallable =
        callableFactory.createOperationCallable(
            deleteBackupVaultTransportSettings,
            settings.deleteBackupVaultOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.createBackupCallable =
        callableFactory.createUnaryCallable(
            createBackupTransportSettings, settings.createBackupSettings(), clientContext);
    this.createBackupOperationCallable =
        callableFactory.createOperationCallable(
            createBackupTransportSettings,
            settings.createBackupOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getBackupCallable =
        callableFactory.createUnaryCallable(
            getBackupTransportSettings, settings.getBackupSettings(), clientContext);
    this.listBackupsCallable =
        callableFactory.createUnaryCallable(
            listBackupsTransportSettings, settings.listBackupsSettings(), clientContext);
    this.listBackupsPagedCallable =
        callableFactory.createPagedCallable(
            listBackupsTransportSettings, settings.listBackupsSettings(), clientContext);
    this.deleteBackupCallable =
        callableFactory.createUnaryCallable(
            deleteBackupTransportSettings, settings.deleteBackupSettings(), clientContext);
    this.deleteBackupOperationCallable =
        callableFactory.createOperationCallable(
            deleteBackupTransportSettings,
            settings.deleteBackupOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateBackupCallable =
        callableFactory.createUnaryCallable(
            updateBackupTransportSettings, settings.updateBackupSettings(), clientContext);
    this.updateBackupOperationCallable =
        callableFactory.createOperationCallable(
            updateBackupTransportSettings,
            settings.updateBackupOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.createBackupPolicyCallable =
        callableFactory.createUnaryCallable(
            createBackupPolicyTransportSettings,
            settings.createBackupPolicySettings(),
            clientContext);
    this.createBackupPolicyOperationCallable =
        callableFactory.createOperationCallable(
            createBackupPolicyTransportSettings,
            settings.createBackupPolicyOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getBackupPolicyCallable =
        callableFactory.createUnaryCallable(
            getBackupPolicyTransportSettings, settings.getBackupPolicySettings(), clientContext);
    this.listBackupPoliciesCallable =
        callableFactory.createUnaryCallable(
            listBackupPoliciesTransportSettings,
            settings.listBackupPoliciesSettings(),
            clientContext);
    this.listBackupPoliciesPagedCallable =
        callableFactory.createPagedCallable(
            listBackupPoliciesTransportSettings,
            settings.listBackupPoliciesSettings(),
            clientContext);
    this.updateBackupPolicyCallable =
        callableFactory.createUnaryCallable(
            updateBackupPolicyTransportSettings,
            settings.updateBackupPolicySettings(),
            clientContext);
    this.updateBackupPolicyOperationCallable =
        callableFactory.createOperationCallable(
            updateBackupPolicyTransportSettings,
            settings.updateBackupPolicyOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteBackupPolicyCallable =
        callableFactory.createUnaryCallable(
            deleteBackupPolicyTransportSettings,
            settings.deleteBackupPolicySettings(),
            clientContext);
    this.deleteBackupPolicyOperationCallable =
        callableFactory.createOperationCallable(
            deleteBackupPolicyTransportSettings,
            settings.deleteBackupPolicyOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
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
    methodDescriptors.add(listStoragePoolsMethodDescriptor);
    methodDescriptors.add(createStoragePoolMethodDescriptor);
    methodDescriptors.add(getStoragePoolMethodDescriptor);
    methodDescriptors.add(updateStoragePoolMethodDescriptor);
    methodDescriptors.add(deleteStoragePoolMethodDescriptor);
    methodDescriptors.add(listVolumesMethodDescriptor);
    methodDescriptors.add(getVolumeMethodDescriptor);
    methodDescriptors.add(createVolumeMethodDescriptor);
    methodDescriptors.add(updateVolumeMethodDescriptor);
    methodDescriptors.add(deleteVolumeMethodDescriptor);
    methodDescriptors.add(revertVolumeMethodDescriptor);
    methodDescriptors.add(listSnapshotsMethodDescriptor);
    methodDescriptors.add(getSnapshotMethodDescriptor);
    methodDescriptors.add(createSnapshotMethodDescriptor);
    methodDescriptors.add(deleteSnapshotMethodDescriptor);
    methodDescriptors.add(updateSnapshotMethodDescriptor);
    methodDescriptors.add(listActiveDirectoriesMethodDescriptor);
    methodDescriptors.add(getActiveDirectoryMethodDescriptor);
    methodDescriptors.add(createActiveDirectoryMethodDescriptor);
    methodDescriptors.add(updateActiveDirectoryMethodDescriptor);
    methodDescriptors.add(deleteActiveDirectoryMethodDescriptor);
    methodDescriptors.add(listKmsConfigsMethodDescriptor);
    methodDescriptors.add(createKmsConfigMethodDescriptor);
    methodDescriptors.add(getKmsConfigMethodDescriptor);
    methodDescriptors.add(updateKmsConfigMethodDescriptor);
    methodDescriptors.add(encryptVolumesMethodDescriptor);
    methodDescriptors.add(verifyKmsConfigMethodDescriptor);
    methodDescriptors.add(deleteKmsConfigMethodDescriptor);
    methodDescriptors.add(listReplicationsMethodDescriptor);
    methodDescriptors.add(getReplicationMethodDescriptor);
    methodDescriptors.add(createReplicationMethodDescriptor);
    methodDescriptors.add(deleteReplicationMethodDescriptor);
    methodDescriptors.add(updateReplicationMethodDescriptor);
    methodDescriptors.add(stopReplicationMethodDescriptor);
    methodDescriptors.add(resumeReplicationMethodDescriptor);
    methodDescriptors.add(reverseReplicationDirectionMethodDescriptor);
    methodDescriptors.add(createBackupVaultMethodDescriptor);
    methodDescriptors.add(getBackupVaultMethodDescriptor);
    methodDescriptors.add(listBackupVaultsMethodDescriptor);
    methodDescriptors.add(updateBackupVaultMethodDescriptor);
    methodDescriptors.add(deleteBackupVaultMethodDescriptor);
    methodDescriptors.add(createBackupMethodDescriptor);
    methodDescriptors.add(getBackupMethodDescriptor);
    methodDescriptors.add(listBackupsMethodDescriptor);
    methodDescriptors.add(deleteBackupMethodDescriptor);
    methodDescriptors.add(updateBackupMethodDescriptor);
    methodDescriptors.add(createBackupPolicyMethodDescriptor);
    methodDescriptors.add(getBackupPolicyMethodDescriptor);
    methodDescriptors.add(listBackupPoliciesMethodDescriptor);
    methodDescriptors.add(updateBackupPolicyMethodDescriptor);
    methodDescriptors.add(deleteBackupPolicyMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
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
  public UnaryCallable<CreateBackupVaultRequest, Operation> createBackupVaultCallable() {
    return createBackupVaultCallable;
  }

  @Override
  public OperationCallable<CreateBackupVaultRequest, BackupVault, OperationMetadata>
      createBackupVaultOperationCallable() {
    return createBackupVaultOperationCallable;
  }

  @Override
  public UnaryCallable<GetBackupVaultRequest, BackupVault> getBackupVaultCallable() {
    return getBackupVaultCallable;
  }

  @Override
  public UnaryCallable<ListBackupVaultsRequest, ListBackupVaultsResponse>
      listBackupVaultsCallable() {
    return listBackupVaultsCallable;
  }

  @Override
  public UnaryCallable<ListBackupVaultsRequest, ListBackupVaultsPagedResponse>
      listBackupVaultsPagedCallable() {
    return listBackupVaultsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateBackupVaultRequest, Operation> updateBackupVaultCallable() {
    return updateBackupVaultCallable;
  }

  @Override
  public OperationCallable<UpdateBackupVaultRequest, BackupVault, OperationMetadata>
      updateBackupVaultOperationCallable() {
    return updateBackupVaultOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteBackupVaultRequest, Operation> deleteBackupVaultCallable() {
    return deleteBackupVaultCallable;
  }

  @Override
  public OperationCallable<DeleteBackupVaultRequest, Empty, OperationMetadata>
      deleteBackupVaultOperationCallable() {
    return deleteBackupVaultOperationCallable;
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
  public UnaryCallable<GetBackupRequest, Backup> getBackupCallable() {
    return getBackupCallable;
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
  public UnaryCallable<CreateBackupPolicyRequest, Operation> createBackupPolicyCallable() {
    return createBackupPolicyCallable;
  }

  @Override
  public OperationCallable<CreateBackupPolicyRequest, BackupPolicy, OperationMetadata>
      createBackupPolicyOperationCallable() {
    return createBackupPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<GetBackupPolicyRequest, BackupPolicy> getBackupPolicyCallable() {
    return getBackupPolicyCallable;
  }

  @Override
  public UnaryCallable<ListBackupPoliciesRequest, ListBackupPoliciesResponse>
      listBackupPoliciesCallable() {
    return listBackupPoliciesCallable;
  }

  @Override
  public UnaryCallable<ListBackupPoliciesRequest, ListBackupPoliciesPagedResponse>
      listBackupPoliciesPagedCallable() {
    return listBackupPoliciesPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateBackupPolicyRequest, Operation> updateBackupPolicyCallable() {
    return updateBackupPolicyCallable;
  }

  @Override
  public OperationCallable<UpdateBackupPolicyRequest, BackupPolicy, OperationMetadata>
      updateBackupPolicyOperationCallable() {
    return updateBackupPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteBackupPolicyRequest, Operation> deleteBackupPolicyCallable() {
    return deleteBackupPolicyCallable;
  }

  @Override
  public OperationCallable<DeleteBackupPolicyRequest, Empty, OperationMetadata>
      deleteBackupPolicyOperationCallable() {
    return deleteBackupPolicyOperationCallable;
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
