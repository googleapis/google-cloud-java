/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.lustre.v1.stub;

import static com.google.cloud.lustre.v1.LustreClient.ListDirectoryPoliciesPagedResponse;
import static com.google.cloud.lustre.v1.LustreClient.ListInstancesPagedResponse;
import static com.google.cloud.lustre.v1.LustreClient.ListLocationsPagedResponse;
import static com.google.cloud.lustre.v1.LustreClient.ListMirrorsPagedResponse;

import com.google.api.HttpRule;
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
import com.google.cloud.lustre.v1.CreateDirectoryPolicyRequest;
import com.google.cloud.lustre.v1.CreateInstanceRequest;
import com.google.cloud.lustre.v1.CreateMirrorMetadata;
import com.google.cloud.lustre.v1.CreateMirrorRequest;
import com.google.cloud.lustre.v1.DeleteDirectoryPolicyRequest;
import com.google.cloud.lustre.v1.DeleteInstanceRequest;
import com.google.cloud.lustre.v1.DeleteMirrorRequest;
import com.google.cloud.lustre.v1.DirectoryPolicy;
import com.google.cloud.lustre.v1.ExportDataMetadata;
import com.google.cloud.lustre.v1.ExportDataRequest;
import com.google.cloud.lustre.v1.ExportDataResponse;
import com.google.cloud.lustre.v1.GetDirectoryPolicyRequest;
import com.google.cloud.lustre.v1.GetInstanceRequest;
import com.google.cloud.lustre.v1.GetMirrorRequest;
import com.google.cloud.lustre.v1.ImportDataMetadata;
import com.google.cloud.lustre.v1.ImportDataRequest;
import com.google.cloud.lustre.v1.ImportDataResponse;
import com.google.cloud.lustre.v1.Instance;
import com.google.cloud.lustre.v1.ListDirectoryPoliciesRequest;
import com.google.cloud.lustre.v1.ListDirectoryPoliciesResponse;
import com.google.cloud.lustre.v1.ListInstancesRequest;
import com.google.cloud.lustre.v1.ListInstancesResponse;
import com.google.cloud.lustre.v1.ListMirrorsRequest;
import com.google.cloud.lustre.v1.ListMirrorsResponse;
import com.google.cloud.lustre.v1.Mirror;
import com.google.cloud.lustre.v1.OperationMetadata;
import com.google.cloud.lustre.v1.RescheduleMaintenanceRequest;
import com.google.cloud.lustre.v1.UpdateInstanceRequest;
import com.google.cloud.lustre.v1.UpdateMirrorRequest;
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
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the Lustre service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class HttpJsonLustreStub extends LustreStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(Instance.getDescriptor())
          .add(ImportDataMetadata.getDescriptor())
          .add(ExportDataResponse.getDescriptor())
          .add(CreateMirrorMetadata.getDescriptor())
          .add(ExportDataMetadata.getDescriptor())
          .add(DirectoryPolicy.getDescriptor())
          .add(Mirror.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(ImportDataResponse.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<ListInstancesRequest, ListInstancesResponse>
      listInstancesMethodDescriptor =
          ApiMethodDescriptor.<ListInstancesRequest, ListInstancesResponse>newBuilder()
              .setFullMethodName("google.cloud.lustre.v1.Lustre/ListInstances")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListInstancesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/instances",
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
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
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
              .setFullMethodName("google.cloud.lustre.v1.Lustre/GetInstance")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetInstanceRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/instances/*}",
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

  private static final ApiMethodDescriptor<CreateInstanceRequest, Operation>
      createInstanceMethodDescriptor =
          ApiMethodDescriptor.<CreateInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.lustre.v1.Lustre/CreateInstance")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateInstanceRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/instances",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "instanceId", request.getInstanceId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
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
                  (CreateInstanceRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateInstanceRequest, Operation>
      updateInstanceMethodDescriptor =
          ApiMethodDescriptor.<UpdateInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.lustre.v1.Lustre/UpdateInstance")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateInstanceRequest>newBuilder()
                      .setPath(
                          "/v1/{instance.name=projects/*/locations/*/instances/*}",
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
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
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

  private static final ApiMethodDescriptor<DeleteInstanceRequest, Operation>
      deleteInstanceMethodDescriptor =
          ApiMethodDescriptor.<DeleteInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.lustre.v1.Lustre/DeleteInstance")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteInstanceRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/instances/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "force", request.getForce());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
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
                  (DeleteInstanceRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<RescheduleMaintenanceRequest, Operation>
      rescheduleMaintenanceMethodDescriptor =
          ApiMethodDescriptor.<RescheduleMaintenanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.lustre.v1.Lustre/RescheduleMaintenance")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RescheduleMaintenanceRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/instances/*}:rescheduleMaintenance",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RescheduleMaintenanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RescheduleMaintenanceRequest> serializer =
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
                  (RescheduleMaintenanceRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ImportDataRequest, Operation>
      importDataMethodDescriptor =
          ApiMethodDescriptor.<ImportDataRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.lustre.v1.Lustre/ImportData")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ImportDataRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/instances/*}:importData",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ImportDataRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ImportDataRequest> serializer =
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
                  (ImportDataRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ExportDataRequest, Operation>
      exportDataMethodDescriptor =
          ApiMethodDescriptor.<ExportDataRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.lustre.v1.Lustre/ExportData")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ExportDataRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/instances/*}:exportData",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ExportDataRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ExportDataRequest> serializer =
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
                  (ExportDataRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CreateMirrorRequest, Operation>
      createMirrorMethodDescriptor =
          ApiMethodDescriptor.<CreateMirrorRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.lustre.v1.Lustre/CreateMirror")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateMirrorRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/instances/*}/mirrors",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateMirrorRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateMirrorRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "mirrorId", request.getMirrorId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("mirror", request.getMirror(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateMirrorRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateMirrorRequest, Operation>
      updateMirrorMethodDescriptor =
          ApiMethodDescriptor.<UpdateMirrorRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.lustre.v1.Lustre/UpdateMirror")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateMirrorRequest>newBuilder()
                      .setPath(
                          "/v1/{mirror.name=projects/*/locations/*/instances/*/mirrors/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateMirrorRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "mirror.name", request.getMirror().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateMirrorRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("mirror", request.getMirror(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateMirrorRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteMirrorRequest, Operation>
      deleteMirrorMethodDescriptor =
          ApiMethodDescriptor.<DeleteMirrorRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.lustre.v1.Lustre/DeleteMirror")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteMirrorRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/instances/*/mirrors/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteMirrorRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteMirrorRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
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
                  (DeleteMirrorRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetMirrorRequest, Mirror> getMirrorMethodDescriptor =
      ApiMethodDescriptor.<GetMirrorRequest, Mirror>newBuilder()
          .setFullMethodName("google.cloud.lustre.v1.Lustre/GetMirror")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetMirrorRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/instances/*/mirrors/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetMirrorRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetMirrorRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Mirror>newBuilder()
                  .setDefaultInstance(Mirror.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListMirrorsRequest, ListMirrorsResponse>
      listMirrorsMethodDescriptor =
          ApiMethodDescriptor.<ListMirrorsRequest, ListMirrorsResponse>newBuilder()
              .setFullMethodName("google.cloud.lustre.v1.Lustre/ListMirrors")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListMirrorsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/instances/*}/mirrors",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListMirrorsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListMirrorsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListMirrorsResponse>newBuilder()
                      .setDefaultInstance(ListMirrorsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateDirectoryPolicyRequest, Operation>
      createDirectoryPolicyMethodDescriptor =
          ApiMethodDescriptor.<CreateDirectoryPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.lustre.v1.Lustre/CreateDirectoryPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateDirectoryPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/instances/*}/directoryPolicies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDirectoryPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateDirectoryPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "directoryPolicyId", request.getDirectoryPolicyId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("directoryPolicy", request.getDirectoryPolicy(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateDirectoryPolicyRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteDirectoryPolicyRequest, Operation>
      deleteDirectoryPolicyMethodDescriptor =
          ApiMethodDescriptor.<DeleteDirectoryPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.lustre.v1.Lustre/DeleteDirectoryPolicy")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteDirectoryPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/instances/*/directoryPolicies/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDirectoryPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteDirectoryPolicyRequest> serializer =
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
                  (DeleteDirectoryPolicyRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetDirectoryPolicyRequest, DirectoryPolicy>
      getDirectoryPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetDirectoryPolicyRequest, DirectoryPolicy>newBuilder()
              .setFullMethodName("google.cloud.lustre.v1.Lustre/GetDirectoryPolicy")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDirectoryPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/instances/*/directoryPolicies/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetDirectoryPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetDirectoryPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DirectoryPolicy>newBuilder()
                      .setDefaultInstance(DirectoryPolicy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListDirectoryPoliciesRequest, ListDirectoryPoliciesResponse>
      listDirectoryPoliciesMethodDescriptor =
          ApiMethodDescriptor
              .<ListDirectoryPoliciesRequest, ListDirectoryPoliciesResponse>newBuilder()
              .setFullMethodName("google.cloud.lustre.v1.Lustre/ListDirectoryPolicies")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDirectoryPoliciesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/instances/*}/directoryPolicies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDirectoryPoliciesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDirectoryPoliciesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListDirectoryPoliciesResponse>newBuilder()
                      .setDefaultInstance(ListDirectoryPoliciesResponse.getDefaultInstance())
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
  private final UnaryCallable<DeleteInstanceRequest, Operation> deleteInstanceCallable;
  private final OperationCallable<DeleteInstanceRequest, Empty, OperationMetadata>
      deleteInstanceOperationCallable;
  private final UnaryCallable<RescheduleMaintenanceRequest, Operation>
      rescheduleMaintenanceCallable;
  private final OperationCallable<RescheduleMaintenanceRequest, Instance, OperationMetadata>
      rescheduleMaintenanceOperationCallable;
  private final UnaryCallable<ImportDataRequest, Operation> importDataCallable;
  private final OperationCallable<ImportDataRequest, ImportDataResponse, ImportDataMetadata>
      importDataOperationCallable;
  private final UnaryCallable<ExportDataRequest, Operation> exportDataCallable;
  private final OperationCallable<ExportDataRequest, ExportDataResponse, ExportDataMetadata>
      exportDataOperationCallable;
  private final UnaryCallable<CreateMirrorRequest, Operation> createMirrorCallable;
  private final OperationCallable<CreateMirrorRequest, Mirror, CreateMirrorMetadata>
      createMirrorOperationCallable;
  private final UnaryCallable<UpdateMirrorRequest, Operation> updateMirrorCallable;
  private final OperationCallable<UpdateMirrorRequest, Mirror, OperationMetadata>
      updateMirrorOperationCallable;
  private final UnaryCallable<DeleteMirrorRequest, Operation> deleteMirrorCallable;
  private final OperationCallable<DeleteMirrorRequest, Empty, OperationMetadata>
      deleteMirrorOperationCallable;
  private final UnaryCallable<GetMirrorRequest, Mirror> getMirrorCallable;
  private final UnaryCallable<ListMirrorsRequest, ListMirrorsResponse> listMirrorsCallable;
  private final UnaryCallable<ListMirrorsRequest, ListMirrorsPagedResponse>
      listMirrorsPagedCallable;
  private final UnaryCallable<CreateDirectoryPolicyRequest, Operation>
      createDirectoryPolicyCallable;
  private final OperationCallable<CreateDirectoryPolicyRequest, DirectoryPolicy, OperationMetadata>
      createDirectoryPolicyOperationCallable;
  private final UnaryCallable<DeleteDirectoryPolicyRequest, Operation>
      deleteDirectoryPolicyCallable;
  private final OperationCallable<DeleteDirectoryPolicyRequest, Empty, OperationMetadata>
      deleteDirectoryPolicyOperationCallable;
  private final UnaryCallable<GetDirectoryPolicyRequest, DirectoryPolicy>
      getDirectoryPolicyCallable;
  private final UnaryCallable<ListDirectoryPoliciesRequest, ListDirectoryPoliciesResponse>
      listDirectoryPoliciesCallable;
  private final UnaryCallable<ListDirectoryPoliciesRequest, ListDirectoryPoliciesPagedResponse>
      listDirectoryPoliciesPagedCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonLustreStub create(LustreStubSettings settings) throws IOException {
    return new HttpJsonLustreStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonLustreStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonLustreStub(LustreStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonLustreStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonLustreStub(
        LustreStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonLustreStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonLustreStub(LustreStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonLustreCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonLustreStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonLustreStub(
      LustreStubSettings settings,
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
                .setResourceNameExtractor(request -> request.getParent())
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
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<CreateInstanceRequest, Operation> createInstanceTransportSettings =
        HttpJsonCallSettings.<CreateInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(createInstanceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
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
    HttpJsonCallSettings<DeleteInstanceRequest, Operation> deleteInstanceTransportSettings =
        HttpJsonCallSettings.<DeleteInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteInstanceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<RescheduleMaintenanceRequest, Operation>
        rescheduleMaintenanceTransportSettings =
            HttpJsonCallSettings.<RescheduleMaintenanceRequest, Operation>newBuilder()
                .setMethodDescriptor(rescheduleMaintenanceMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<ImportDataRequest, Operation> importDataTransportSettings =
        HttpJsonCallSettings.<ImportDataRequest, Operation>newBuilder()
            .setMethodDescriptor(importDataMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ExportDataRequest, Operation> exportDataTransportSettings =
        HttpJsonCallSettings.<ExportDataRequest, Operation>newBuilder()
            .setMethodDescriptor(exportDataMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<CreateMirrorRequest, Operation> createMirrorTransportSettings =
        HttpJsonCallSettings.<CreateMirrorRequest, Operation>newBuilder()
            .setMethodDescriptor(createMirrorMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<UpdateMirrorRequest, Operation> updateMirrorTransportSettings =
        HttpJsonCallSettings.<UpdateMirrorRequest, Operation>newBuilder()
            .setMethodDescriptor(updateMirrorMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("mirror.name", String.valueOf(request.getMirror().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteMirrorRequest, Operation> deleteMirrorTransportSettings =
        HttpJsonCallSettings.<DeleteMirrorRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMirrorMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<GetMirrorRequest, Mirror> getMirrorTransportSettings =
        HttpJsonCallSettings.<GetMirrorRequest, Mirror>newBuilder()
            .setMethodDescriptor(getMirrorMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListMirrorsRequest, ListMirrorsResponse> listMirrorsTransportSettings =
        HttpJsonCallSettings.<ListMirrorsRequest, ListMirrorsResponse>newBuilder()
            .setMethodDescriptor(listMirrorsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<CreateDirectoryPolicyRequest, Operation>
        createDirectoryPolicyTransportSettings =
            HttpJsonCallSettings.<CreateDirectoryPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(createDirectoryPolicyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<DeleteDirectoryPolicyRequest, Operation>
        deleteDirectoryPolicyTransportSettings =
            HttpJsonCallSettings.<DeleteDirectoryPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteDirectoryPolicyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<GetDirectoryPolicyRequest, DirectoryPolicy>
        getDirectoryPolicyTransportSettings =
            HttpJsonCallSettings.<GetDirectoryPolicyRequest, DirectoryPolicy>newBuilder()
                .setMethodDescriptor(getDirectoryPolicyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<ListDirectoryPoliciesRequest, ListDirectoryPoliciesResponse>
        listDirectoryPoliciesTransportSettings =
            HttpJsonCallSettings
                .<ListDirectoryPoliciesRequest, ListDirectoryPoliciesResponse>newBuilder()
                .setMethodDescriptor(listDirectoryPoliciesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
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
    this.createInstanceCallable =
        callableFactory.createUnaryCallable(
            createInstanceTransportSettings, settings.createInstanceSettings(), clientContext);
    this.createInstanceOperationCallable =
        callableFactory.createOperationCallable(
            createInstanceTransportSettings,
            settings.createInstanceOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateInstanceCallable =
        callableFactory.createUnaryCallable(
            updateInstanceTransportSettings, settings.updateInstanceSettings(), clientContext);
    this.updateInstanceOperationCallable =
        callableFactory.createOperationCallable(
            updateInstanceTransportSettings,
            settings.updateInstanceOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteInstanceCallable =
        callableFactory.createUnaryCallable(
            deleteInstanceTransportSettings, settings.deleteInstanceSettings(), clientContext);
    this.deleteInstanceOperationCallable =
        callableFactory.createOperationCallable(
            deleteInstanceTransportSettings,
            settings.deleteInstanceOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.rescheduleMaintenanceCallable =
        callableFactory.createUnaryCallable(
            rescheduleMaintenanceTransportSettings,
            settings.rescheduleMaintenanceSettings(),
            clientContext);
    this.rescheduleMaintenanceOperationCallable =
        callableFactory.createOperationCallable(
            rescheduleMaintenanceTransportSettings,
            settings.rescheduleMaintenanceOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.importDataCallable =
        callableFactory.createUnaryCallable(
            importDataTransportSettings, settings.importDataSettings(), clientContext);
    this.importDataOperationCallable =
        callableFactory.createOperationCallable(
            importDataTransportSettings,
            settings.importDataOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.exportDataCallable =
        callableFactory.createUnaryCallable(
            exportDataTransportSettings, settings.exportDataSettings(), clientContext);
    this.exportDataOperationCallable =
        callableFactory.createOperationCallable(
            exportDataTransportSettings,
            settings.exportDataOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.createMirrorCallable =
        callableFactory.createUnaryCallable(
            createMirrorTransportSettings, settings.createMirrorSettings(), clientContext);
    this.createMirrorOperationCallable =
        callableFactory.createOperationCallable(
            createMirrorTransportSettings,
            settings.createMirrorOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateMirrorCallable =
        callableFactory.createUnaryCallable(
            updateMirrorTransportSettings, settings.updateMirrorSettings(), clientContext);
    this.updateMirrorOperationCallable =
        callableFactory.createOperationCallable(
            updateMirrorTransportSettings,
            settings.updateMirrorOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteMirrorCallable =
        callableFactory.createUnaryCallable(
            deleteMirrorTransportSettings, settings.deleteMirrorSettings(), clientContext);
    this.deleteMirrorOperationCallable =
        callableFactory.createOperationCallable(
            deleteMirrorTransportSettings,
            settings.deleteMirrorOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getMirrorCallable =
        callableFactory.createUnaryCallable(
            getMirrorTransportSettings, settings.getMirrorSettings(), clientContext);
    this.listMirrorsCallable =
        callableFactory.createUnaryCallable(
            listMirrorsTransportSettings, settings.listMirrorsSettings(), clientContext);
    this.listMirrorsPagedCallable =
        callableFactory.createPagedCallable(
            listMirrorsTransportSettings, settings.listMirrorsSettings(), clientContext);
    this.createDirectoryPolicyCallable =
        callableFactory.createUnaryCallable(
            createDirectoryPolicyTransportSettings,
            settings.createDirectoryPolicySettings(),
            clientContext);
    this.createDirectoryPolicyOperationCallable =
        callableFactory.createOperationCallable(
            createDirectoryPolicyTransportSettings,
            settings.createDirectoryPolicyOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteDirectoryPolicyCallable =
        callableFactory.createUnaryCallable(
            deleteDirectoryPolicyTransportSettings,
            settings.deleteDirectoryPolicySettings(),
            clientContext);
    this.deleteDirectoryPolicyOperationCallable =
        callableFactory.createOperationCallable(
            deleteDirectoryPolicyTransportSettings,
            settings.deleteDirectoryPolicyOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getDirectoryPolicyCallable =
        callableFactory.createUnaryCallable(
            getDirectoryPolicyTransportSettings,
            settings.getDirectoryPolicySettings(),
            clientContext);
    this.listDirectoryPoliciesCallable =
        callableFactory.createUnaryCallable(
            listDirectoryPoliciesTransportSettings,
            settings.listDirectoryPoliciesSettings(),
            clientContext);
    this.listDirectoryPoliciesPagedCallable =
        callableFactory.createPagedCallable(
            listDirectoryPoliciesTransportSettings,
            settings.listDirectoryPoliciesSettings(),
            clientContext);
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
    methodDescriptors.add(createInstanceMethodDescriptor);
    methodDescriptors.add(updateInstanceMethodDescriptor);
    methodDescriptors.add(deleteInstanceMethodDescriptor);
    methodDescriptors.add(rescheduleMaintenanceMethodDescriptor);
    methodDescriptors.add(importDataMethodDescriptor);
    methodDescriptors.add(exportDataMethodDescriptor);
    methodDescriptors.add(createMirrorMethodDescriptor);
    methodDescriptors.add(updateMirrorMethodDescriptor);
    methodDescriptors.add(deleteMirrorMethodDescriptor);
    methodDescriptors.add(getMirrorMethodDescriptor);
    methodDescriptors.add(listMirrorsMethodDescriptor);
    methodDescriptors.add(createDirectoryPolicyMethodDescriptor);
    methodDescriptors.add(deleteDirectoryPolicyMethodDescriptor);
    methodDescriptors.add(getDirectoryPolicyMethodDescriptor);
    methodDescriptors.add(listDirectoryPoliciesMethodDescriptor);
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
  public UnaryCallable<DeleteInstanceRequest, Operation> deleteInstanceCallable() {
    return deleteInstanceCallable;
  }

  @Override
  public OperationCallable<DeleteInstanceRequest, Empty, OperationMetadata>
      deleteInstanceOperationCallable() {
    return deleteInstanceOperationCallable;
  }

  @Override
  public UnaryCallable<RescheduleMaintenanceRequest, Operation> rescheduleMaintenanceCallable() {
    return rescheduleMaintenanceCallable;
  }

  @Override
  public OperationCallable<RescheduleMaintenanceRequest, Instance, OperationMetadata>
      rescheduleMaintenanceOperationCallable() {
    return rescheduleMaintenanceOperationCallable;
  }

  @Override
  public UnaryCallable<ImportDataRequest, Operation> importDataCallable() {
    return importDataCallable;
  }

  @Override
  public OperationCallable<ImportDataRequest, ImportDataResponse, ImportDataMetadata>
      importDataOperationCallable() {
    return importDataOperationCallable;
  }

  @Override
  public UnaryCallable<ExportDataRequest, Operation> exportDataCallable() {
    return exportDataCallable;
  }

  @Override
  public OperationCallable<ExportDataRequest, ExportDataResponse, ExportDataMetadata>
      exportDataOperationCallable() {
    return exportDataOperationCallable;
  }

  @Override
  public UnaryCallable<CreateMirrorRequest, Operation> createMirrorCallable() {
    return createMirrorCallable;
  }

  @Override
  public OperationCallable<CreateMirrorRequest, Mirror, CreateMirrorMetadata>
      createMirrorOperationCallable() {
    return createMirrorOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateMirrorRequest, Operation> updateMirrorCallable() {
    return updateMirrorCallable;
  }

  @Override
  public OperationCallable<UpdateMirrorRequest, Mirror, OperationMetadata>
      updateMirrorOperationCallable() {
    return updateMirrorOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteMirrorRequest, Operation> deleteMirrorCallable() {
    return deleteMirrorCallable;
  }

  @Override
  public OperationCallable<DeleteMirrorRequest, Empty, OperationMetadata>
      deleteMirrorOperationCallable() {
    return deleteMirrorOperationCallable;
  }

  @Override
  public UnaryCallable<GetMirrorRequest, Mirror> getMirrorCallable() {
    return getMirrorCallable;
  }

  @Override
  public UnaryCallable<ListMirrorsRequest, ListMirrorsResponse> listMirrorsCallable() {
    return listMirrorsCallable;
  }

  @Override
  public UnaryCallable<ListMirrorsRequest, ListMirrorsPagedResponse> listMirrorsPagedCallable() {
    return listMirrorsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateDirectoryPolicyRequest, Operation> createDirectoryPolicyCallable() {
    return createDirectoryPolicyCallable;
  }

  @Override
  public OperationCallable<CreateDirectoryPolicyRequest, DirectoryPolicy, OperationMetadata>
      createDirectoryPolicyOperationCallable() {
    return createDirectoryPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteDirectoryPolicyRequest, Operation> deleteDirectoryPolicyCallable() {
    return deleteDirectoryPolicyCallable;
  }

  @Override
  public OperationCallable<DeleteDirectoryPolicyRequest, Empty, OperationMetadata>
      deleteDirectoryPolicyOperationCallable() {
    return deleteDirectoryPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<GetDirectoryPolicyRequest, DirectoryPolicy> getDirectoryPolicyCallable() {
    return getDirectoryPolicyCallable;
  }

  @Override
  public UnaryCallable<ListDirectoryPoliciesRequest, ListDirectoryPoliciesResponse>
      listDirectoryPoliciesCallable() {
    return listDirectoryPoliciesCallable;
  }

  @Override
  public UnaryCallable<ListDirectoryPoliciesRequest, ListDirectoryPoliciesPagedResponse>
      listDirectoryPoliciesPagedCallable() {
    return listDirectoryPoliciesPagedCallable;
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
