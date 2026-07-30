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

package com.google.storage.control.v2.stub;

import static com.google.storage.control.v2.StorageControlClient.ListFoldersPagedResponse;
import static com.google.storage.control.v2.StorageControlClient.ListIntelligenceFindingRevisionsPagedResponse;
import static com.google.storage.control.v2.StorageControlClient.ListIntelligenceFindingsPagedResponse;
import static com.google.storage.control.v2.StorageControlClient.SummarizeIntelligenceFindingsPagedResponse;

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
import com.google.api.pathtemplate.PathTemplate;
import com.google.common.base.Strings;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.TypeRegistry;
import com.google.storage.control.v2.AnywhereCache;
import com.google.storage.control.v2.CreateAnywhereCacheMetadata;
import com.google.storage.control.v2.CreateAnywhereCacheRequest;
import com.google.storage.control.v2.CreateFolderRequest;
import com.google.storage.control.v2.CreateManagedFolderRequest;
import com.google.storage.control.v2.CreateRapidCacheMetadata;
import com.google.storage.control.v2.CreateRapidCacheRequest;
import com.google.storage.control.v2.DeleteFolderRecursiveMetadata;
import com.google.storage.control.v2.DeleteFolderRecursiveRequest;
import com.google.storage.control.v2.DeleteFolderRequest;
import com.google.storage.control.v2.DeleteManagedFolderRequest;
import com.google.storage.control.v2.DisableAnywhereCacheRequest;
import com.google.storage.control.v2.Folder;
import com.google.storage.control.v2.GetAnywhereCacheRequest;
import com.google.storage.control.v2.GetFolderIntelligenceConfigRequest;
import com.google.storage.control.v2.GetFolderRequest;
import com.google.storage.control.v2.GetIntelligenceFindingRequest;
import com.google.storage.control.v2.GetIntelligenceFindingRevisionRequest;
import com.google.storage.control.v2.GetManagedFolderRequest;
import com.google.storage.control.v2.GetOrganizationIntelligenceConfigRequest;
import com.google.storage.control.v2.GetProjectIntelligenceConfigRequest;
import com.google.storage.control.v2.GetRapidCacheRequest;
import com.google.storage.control.v2.GetStorageLayoutRequest;
import com.google.storage.control.v2.IntelligenceConfig;
import com.google.storage.control.v2.IntelligenceFinding;
import com.google.storage.control.v2.IntelligenceFindingRevision;
import com.google.storage.control.v2.ListAnywhereCachesRequest;
import com.google.storage.control.v2.ListAnywhereCachesResponse;
import com.google.storage.control.v2.ListFoldersRequest;
import com.google.storage.control.v2.ListFoldersResponse;
import com.google.storage.control.v2.ListIntelligenceFindingRevisionsRequest;
import com.google.storage.control.v2.ListIntelligenceFindingRevisionsResponse;
import com.google.storage.control.v2.ListIntelligenceFindingsRequest;
import com.google.storage.control.v2.ListIntelligenceFindingsResponse;
import com.google.storage.control.v2.ListManagedFoldersRequest;
import com.google.storage.control.v2.ListManagedFoldersResponse;
import com.google.storage.control.v2.ListRapidCachesRequest;
import com.google.storage.control.v2.ListRapidCachesResponse;
import com.google.storage.control.v2.ManagedFolder;
import com.google.storage.control.v2.PauseAnywhereCacheRequest;
import com.google.storage.control.v2.RapidCache;
import com.google.storage.control.v2.RenameFolderMetadata;
import com.google.storage.control.v2.RenameFolderRequest;
import com.google.storage.control.v2.ResumeAnywhereCacheRequest;
import com.google.storage.control.v2.StorageLayout;
import com.google.storage.control.v2.SummarizeIntelligenceFindingsRequest;
import com.google.storage.control.v2.SummarizeIntelligenceFindingsResponse;
import com.google.storage.control.v2.UpdateAnywhereCacheMetadata;
import com.google.storage.control.v2.UpdateAnywhereCacheRequest;
import com.google.storage.control.v2.UpdateFolderIntelligenceConfigRequest;
import com.google.storage.control.v2.UpdateManagedFolderRequest;
import com.google.storage.control.v2.UpdateOrganizationIntelligenceConfigRequest;
import com.google.storage.control.v2.UpdateProjectIntelligenceConfigRequest;
import com.google.storage.control.v2.UpdateRapidCacheMetadata;
import com.google.storage.control.v2.UpdateRapidCacheRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the StorageControl service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class HttpJsonStorageControlStub extends StorageControlStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(RenameFolderMetadata.getDescriptor())
          .add(CreateRapidCacheMetadata.getDescriptor())
          .add(UpdateRapidCacheMetadata.getDescriptor())
          .add(Folder.getDescriptor())
          .add(AnywhereCache.getDescriptor())
          .add(UpdateAnywhereCacheMetadata.getDescriptor())
          .add(DeleteFolderRecursiveMetadata.getDescriptor())
          .add(CreateAnywhereCacheMetadata.getDescriptor())
          .add(RapidCache.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<CreateFolderRequest, Folder>
      createFolderMethodDescriptor =
          ApiMethodDescriptor.<CreateFolderRequest, Folder>newBuilder()
              .setFullMethodName("google.storage.control.v2.StorageControl/CreateFolder")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateFolderRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*/buckets/*}/folders",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateFolderRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateFolderRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "folderId", request.getFolderId());
                            serializer.putQueryParam(fields, "recursive", request.getRecursive());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("folder", request.getFolder(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Folder>newBuilder()
                      .setDefaultInstance(Folder.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteFolderRequest, Empty>
      deleteFolderMethodDescriptor =
          ApiMethodDescriptor.<DeleteFolderRequest, Empty>newBuilder()
              .setFullMethodName("google.storage.control.v2.StorageControl/DeleteFolder")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteFolderRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/buckets/*/folders/**}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteFolderRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteFolderRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasIfMetagenerationMatch()) {
                              serializer.putQueryParam(
                                  fields,
                                  "ifMetagenerationMatch",
                                  request.getIfMetagenerationMatch());
                            }
                            if (request.hasIfMetagenerationNotMatch()) {
                              serializer.putQueryParam(
                                  fields,
                                  "ifMetagenerationNotMatch",
                                  request.getIfMetagenerationNotMatch());
                            }
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
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

  private static final ApiMethodDescriptor<GetFolderRequest, Folder> getFolderMethodDescriptor =
      ApiMethodDescriptor.<GetFolderRequest, Folder>newBuilder()
          .setFullMethodName("google.storage.control.v2.StorageControl/GetFolder")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetFolderRequest>newBuilder()
                  .setPath(
                      "/v2/{name=projects/*/buckets/*/folders/**}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetFolderRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetFolderRequest> serializer =
                            ProtoRestSerializer.create();
                        if (request.hasIfMetagenerationMatch()) {
                          serializer.putQueryParam(
                              fields, "ifMetagenerationMatch", request.getIfMetagenerationMatch());
                        }
                        if (request.hasIfMetagenerationNotMatch()) {
                          serializer.putQueryParam(
                              fields,
                              "ifMetagenerationNotMatch",
                              request.getIfMetagenerationNotMatch());
                        }
                        serializer.putQueryParam(fields, "requestId", request.getRequestId());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Folder>newBuilder()
                  .setDefaultInstance(Folder.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListFoldersRequest, ListFoldersResponse>
      listFoldersMethodDescriptor =
          ApiMethodDescriptor.<ListFoldersRequest, ListFoldersResponse>newBuilder()
              .setFullMethodName("google.storage.control.v2.StorageControl/ListFolders")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListFoldersRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*/buckets/*}/folders",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListFoldersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListFoldersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "delimiter", request.getDelimiter());
                            serializer.putQueryParam(
                                fields, "lexicographicEnd", request.getLexicographicEnd());
                            serializer.putQueryParam(
                                fields, "lexicographicStart", request.getLexicographicStart());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "prefix", request.getPrefix());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListFoldersResponse>newBuilder()
                      .setDefaultInstance(ListFoldersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<RenameFolderRequest, Operation>
      renameFolderMethodDescriptor =
          ApiMethodDescriptor.<RenameFolderRequest, Operation>newBuilder()
              .setFullMethodName("google.storage.control.v2.StorageControl/RenameFolder")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RenameFolderRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/buckets/*/folders/**}:rename",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RenameFolderRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RenameFolderRequest> serializer =
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
                  (RenameFolderRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteFolderRecursiveRequest, Operation>
      deleteFolderRecursiveMethodDescriptor =
          ApiMethodDescriptor.<DeleteFolderRecursiveRequest, Operation>newBuilder()
              .setFullMethodName("google.storage.control.v2.StorageControl/DeleteFolderRecursive")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteFolderRecursiveRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/buckets/*/folders/**}:deleteRecursive",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteFolderRecursiveRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteFolderRecursiveRequest> serializer =
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
                  (DeleteFolderRecursiveRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetStorageLayoutRequest, StorageLayout>
      getStorageLayoutMethodDescriptor =
          ApiMethodDescriptor.<GetStorageLayoutRequest, StorageLayout>newBuilder()
              .setFullMethodName("google.storage.control.v2.StorageControl/GetStorageLayout")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetStorageLayoutRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/buckets/*/storageLayout}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetStorageLayoutRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetStorageLayoutRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "prefix", request.getPrefix());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<StorageLayout>newBuilder()
                      .setDefaultInstance(StorageLayout.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetProjectIntelligenceConfigRequest, IntelligenceConfig>
      getProjectIntelligenceConfigMethodDescriptor =
          ApiMethodDescriptor.<GetProjectIntelligenceConfigRequest, IntelligenceConfig>newBuilder()
              .setFullMethodName(
                  "google.storage.control.v2.StorageControl/GetProjectIntelligenceConfig")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetProjectIntelligenceConfigRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/locations/*/intelligenceConfig}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetProjectIntelligenceConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetProjectIntelligenceConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<IntelligenceConfig>newBuilder()
                      .setDefaultInstance(IntelligenceConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          UpdateProjectIntelligenceConfigRequest, IntelligenceConfig>
      updateProjectIntelligenceConfigMethodDescriptor =
          ApiMethodDescriptor
              .<UpdateProjectIntelligenceConfigRequest, IntelligenceConfig>newBuilder()
              .setFullMethodName(
                  "google.storage.control.v2.StorageControl/UpdateProjectIntelligenceConfig")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateProjectIntelligenceConfigRequest>newBuilder()
                      .setPath(
                          "/v2/{intelligenceConfig.name=projects/*/locations/*/intelligenceConfig}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateProjectIntelligenceConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "intelligenceConfig.name",
                                request.getIntelligenceConfig().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateProjectIntelligenceConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "intelligenceConfig", request.getIntelligenceConfig(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<IntelligenceConfig>newBuilder()
                      .setDefaultInstance(IntelligenceConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetFolderIntelligenceConfigRequest, IntelligenceConfig>
      getFolderIntelligenceConfigMethodDescriptor =
          ApiMethodDescriptor.<GetFolderIntelligenceConfigRequest, IntelligenceConfig>newBuilder()
              .setFullMethodName(
                  "google.storage.control.v2.StorageControl/GetFolderIntelligenceConfig")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetFolderIntelligenceConfigRequest>newBuilder()
                      .setPath(
                          "/v2/{name=folders/*/locations/*/intelligenceConfig}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetFolderIntelligenceConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetFolderIntelligenceConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<IntelligenceConfig>newBuilder()
                      .setDefaultInstance(IntelligenceConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          UpdateFolderIntelligenceConfigRequest, IntelligenceConfig>
      updateFolderIntelligenceConfigMethodDescriptor =
          ApiMethodDescriptor
              .<UpdateFolderIntelligenceConfigRequest, IntelligenceConfig>newBuilder()
              .setFullMethodName(
                  "google.storage.control.v2.StorageControl/UpdateFolderIntelligenceConfig")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateFolderIntelligenceConfigRequest>newBuilder()
                      .setPath(
                          "/v2/{intelligenceConfig.name=folders/*/locations/*/intelligenceConfig}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateFolderIntelligenceConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "intelligenceConfig.name",
                                request.getIntelligenceConfig().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateFolderIntelligenceConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "intelligenceConfig", request.getIntelligenceConfig(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<IntelligenceConfig>newBuilder()
                      .setDefaultInstance(IntelligenceConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          GetOrganizationIntelligenceConfigRequest, IntelligenceConfig>
      getOrganizationIntelligenceConfigMethodDescriptor =
          ApiMethodDescriptor
              .<GetOrganizationIntelligenceConfigRequest, IntelligenceConfig>newBuilder()
              .setFullMethodName(
                  "google.storage.control.v2.StorageControl/GetOrganizationIntelligenceConfig")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<GetOrganizationIntelligenceConfigRequest>newBuilder()
                      .setPath(
                          "/v2/{name=organizations/*/locations/*/intelligenceConfig}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetOrganizationIntelligenceConfigRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetOrganizationIntelligenceConfigRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<IntelligenceConfig>newBuilder()
                      .setDefaultInstance(IntelligenceConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          UpdateOrganizationIntelligenceConfigRequest, IntelligenceConfig>
      updateOrganizationIntelligenceConfigMethodDescriptor =
          ApiMethodDescriptor
              .<UpdateOrganizationIntelligenceConfigRequest, IntelligenceConfig>newBuilder()
              .setFullMethodName(
                  "google.storage.control.v2.StorageControl/UpdateOrganizationIntelligenceConfig")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<UpdateOrganizationIntelligenceConfigRequest>newBuilder()
                      .setPath(
                          "/v2/{intelligenceConfig.name=organizations/*/locations/*/intelligenceConfig}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateOrganizationIntelligenceConfigRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "intelligenceConfig.name",
                                request.getIntelligenceConfig().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateOrganizationIntelligenceConfigRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "intelligenceConfig", request.getIntelligenceConfig(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<IntelligenceConfig>newBuilder()
                      .setDefaultInstance(IntelligenceConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetIntelligenceFindingRequest, IntelligenceFinding>
      getIntelligenceFindingMethodDescriptor =
          ApiMethodDescriptor.<GetIntelligenceFindingRequest, IntelligenceFinding>newBuilder()
              .setFullMethodName("google.storage.control.v2.StorageControl/GetIntelligenceFinding")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIntelligenceFindingRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/locations/*/intelligenceFindings/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetIntelligenceFindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetIntelligenceFindingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<IntelligenceFinding>newBuilder()
                      .setDefaultInstance(IntelligenceFinding.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListIntelligenceFindingsRequest, ListIntelligenceFindingsResponse>
      listIntelligenceFindingsMethodDescriptor =
          ApiMethodDescriptor
              .<ListIntelligenceFindingsRequest, ListIntelligenceFindingsResponse>newBuilder()
              .setFullMethodName(
                  "google.storage.control.v2.StorageControl/ListIntelligenceFindings")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListIntelligenceFindingsRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*/locations/*}/intelligenceFindings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListIntelligenceFindingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListIntelligenceFindingsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListIntelligenceFindingsResponse>newBuilder()
                      .setDefaultInstance(ListIntelligenceFindingsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          SummarizeIntelligenceFindingsRequest, SummarizeIntelligenceFindingsResponse>
      summarizeIntelligenceFindingsMethodDescriptor =
          ApiMethodDescriptor
              .<SummarizeIntelligenceFindingsRequest, SummarizeIntelligenceFindingsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.storage.control.v2.StorageControl/SummarizeIntelligenceFindings")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SummarizeIntelligenceFindingsRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*/locations/*}/intelligenceFindings:summarize",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SummarizeIntelligenceFindingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{parent=folders/*/locations/*}/intelligenceFindings:summarize",
                          "/v2/{parent=organizations/*/locations/*}/intelligenceFindings:summarize")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SummarizeIntelligenceFindingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(
                                fields, "resourceScope", request.getResourceScopeValue());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SummarizeIntelligenceFindingsResponse>newBuilder()
                      .setDefaultInstance(
                          SummarizeIntelligenceFindingsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          GetIntelligenceFindingRevisionRequest, IntelligenceFindingRevision>
      getIntelligenceFindingRevisionMethodDescriptor =
          ApiMethodDescriptor
              .<GetIntelligenceFindingRevisionRequest, IntelligenceFindingRevision>newBuilder()
              .setFullMethodName(
                  "google.storage.control.v2.StorageControl/GetIntelligenceFindingRevision")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIntelligenceFindingRevisionRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/locations/*/intelligenceFindings/*/revisions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetIntelligenceFindingRevisionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetIntelligenceFindingRevisionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<IntelligenceFindingRevision>newBuilder()
                      .setDefaultInstance(IntelligenceFindingRevision.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListIntelligenceFindingRevisionsRequest, ListIntelligenceFindingRevisionsResponse>
      listIntelligenceFindingRevisionsMethodDescriptor =
          ApiMethodDescriptor
              .<ListIntelligenceFindingRevisionsRequest, ListIntelligenceFindingRevisionsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.storage.control.v2.StorageControl/ListIntelligenceFindingRevisions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListIntelligenceFindingRevisionsRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*/locations/*/intelligenceFindings/*}/revisions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListIntelligenceFindingRevisionsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListIntelligenceFindingRevisionsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListIntelligenceFindingRevisionsResponse>newBuilder()
                      .setDefaultInstance(
                          ListIntelligenceFindingRevisionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CreateFolderRequest, Folder> createFolderCallable;
  private final UnaryCallable<DeleteFolderRequest, Empty> deleteFolderCallable;
  private final UnaryCallable<GetFolderRequest, Folder> getFolderCallable;
  private final UnaryCallable<ListFoldersRequest, ListFoldersResponse> listFoldersCallable;
  private final UnaryCallable<ListFoldersRequest, ListFoldersPagedResponse>
      listFoldersPagedCallable;
  private final UnaryCallable<RenameFolderRequest, Operation> renameFolderCallable;
  private final OperationCallable<RenameFolderRequest, Folder, RenameFolderMetadata>
      renameFolderOperationCallable;
  private final UnaryCallable<DeleteFolderRecursiveRequest, Operation>
      deleteFolderRecursiveCallable;
  private final OperationCallable<
          DeleteFolderRecursiveRequest, Empty, DeleteFolderRecursiveMetadata>
      deleteFolderRecursiveOperationCallable;
  private final UnaryCallable<GetStorageLayoutRequest, StorageLayout> getStorageLayoutCallable;
  private final UnaryCallable<GetProjectIntelligenceConfigRequest, IntelligenceConfig>
      getProjectIntelligenceConfigCallable;
  private final UnaryCallable<UpdateProjectIntelligenceConfigRequest, IntelligenceConfig>
      updateProjectIntelligenceConfigCallable;
  private final UnaryCallable<GetFolderIntelligenceConfigRequest, IntelligenceConfig>
      getFolderIntelligenceConfigCallable;
  private final UnaryCallable<UpdateFolderIntelligenceConfigRequest, IntelligenceConfig>
      updateFolderIntelligenceConfigCallable;
  private final UnaryCallable<GetOrganizationIntelligenceConfigRequest, IntelligenceConfig>
      getOrganizationIntelligenceConfigCallable;
  private final UnaryCallable<UpdateOrganizationIntelligenceConfigRequest, IntelligenceConfig>
      updateOrganizationIntelligenceConfigCallable;
  private final UnaryCallable<GetIntelligenceFindingRequest, IntelligenceFinding>
      getIntelligenceFindingCallable;
  private final UnaryCallable<ListIntelligenceFindingsRequest, ListIntelligenceFindingsResponse>
      listIntelligenceFindingsCallable;
  private final UnaryCallable<
          ListIntelligenceFindingsRequest, ListIntelligenceFindingsPagedResponse>
      listIntelligenceFindingsPagedCallable;
  private final UnaryCallable<
          SummarizeIntelligenceFindingsRequest, SummarizeIntelligenceFindingsResponse>
      summarizeIntelligenceFindingsCallable;
  private final UnaryCallable<
          SummarizeIntelligenceFindingsRequest, SummarizeIntelligenceFindingsPagedResponse>
      summarizeIntelligenceFindingsPagedCallable;
  private final UnaryCallable<GetIntelligenceFindingRevisionRequest, IntelligenceFindingRevision>
      getIntelligenceFindingRevisionCallable;
  private final UnaryCallable<
          ListIntelligenceFindingRevisionsRequest, ListIntelligenceFindingRevisionsResponse>
      listIntelligenceFindingRevisionsCallable;
  private final UnaryCallable<
          ListIntelligenceFindingRevisionsRequest, ListIntelligenceFindingRevisionsPagedResponse>
      listIntelligenceFindingRevisionsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  private static final PathTemplate CREATE_FOLDER_0_PATH_TEMPLATE =
      PathTemplate.create("{bucket=**}");
  private static final PathTemplate DELETE_FOLDER_0_PATH_TEMPLATE =
      PathTemplate.create("{bucket=projects/*/buckets/*}/**");
  private static final PathTemplate GET_FOLDER_0_PATH_TEMPLATE =
      PathTemplate.create("{bucket=projects/*/buckets/*}/**");
  private static final PathTemplate LIST_FOLDERS_0_PATH_TEMPLATE =
      PathTemplate.create("{bucket=**}");
  private static final PathTemplate RENAME_FOLDER_0_PATH_TEMPLATE =
      PathTemplate.create("{bucket=projects/*/buckets/*}/**");
  private static final PathTemplate DELETE_FOLDER_RECURSIVE_0_PATH_TEMPLATE =
      PathTemplate.create("{bucket=projects/*/buckets/*}/**");
  private static final PathTemplate GET_STORAGE_LAYOUT_0_PATH_TEMPLATE =
      PathTemplate.create("{bucket=projects/*/buckets/*}/**");

  public static final HttpJsonStorageControlStub create(StorageControlStubSettings settings)
      throws IOException {
    return new HttpJsonStorageControlStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonStorageControlStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonStorageControlStub(
        StorageControlStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonStorageControlStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonStorageControlStub(
        StorageControlStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonStorageControlStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonStorageControlStub(
      StorageControlStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonStorageControlCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonStorageControlStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonStorageControlStub(
      StorageControlStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<CreateFolderRequest, Folder> createFolderTransportSettings =
        HttpJsonCallSettings.<CreateFolderRequest, Folder>newBuilder()
            .setMethodDescriptor(createFolderMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getParent(), "bucket", CREATE_FOLDER_0_PATH_TEMPLATE);
                  return builder.build();
                })
            .setRequestMutator(
                request -> {
                  CreateFolderRequest.Builder requestBuilder = request.toBuilder();
                  if (Strings.isNullOrEmpty(request.getRequestId())) {
                    requestBuilder.setRequestId(UUID.randomUUID().toString());
                  }
                  return requestBuilder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<DeleteFolderRequest, Empty> deleteFolderTransportSettings =
        HttpJsonCallSettings.<DeleteFolderRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteFolderMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getName(), "bucket", DELETE_FOLDER_0_PATH_TEMPLATE);
                  return builder.build();
                })
            .setRequestMutator(
                request -> {
                  DeleteFolderRequest.Builder requestBuilder = request.toBuilder();
                  if (Strings.isNullOrEmpty(request.getRequestId())) {
                    requestBuilder.setRequestId(UUID.randomUUID().toString());
                  }
                  return requestBuilder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<GetFolderRequest, Folder> getFolderTransportSettings =
        HttpJsonCallSettings.<GetFolderRequest, Folder>newBuilder()
            .setMethodDescriptor(getFolderMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getName(), "bucket", GET_FOLDER_0_PATH_TEMPLATE);
                  return builder.build();
                })
            .setRequestMutator(
                request -> {
                  GetFolderRequest.Builder requestBuilder = request.toBuilder();
                  if (Strings.isNullOrEmpty(request.getRequestId())) {
                    requestBuilder.setRequestId(UUID.randomUUID().toString());
                  }
                  return requestBuilder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListFoldersRequest, ListFoldersResponse> listFoldersTransportSettings =
        HttpJsonCallSettings.<ListFoldersRequest, ListFoldersResponse>newBuilder()
            .setMethodDescriptor(listFoldersMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getParent(), "bucket", LIST_FOLDERS_0_PATH_TEMPLATE);
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<RenameFolderRequest, Operation> renameFolderTransportSettings =
        HttpJsonCallSettings.<RenameFolderRequest, Operation>newBuilder()
            .setMethodDescriptor(renameFolderMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getName(), "bucket", RENAME_FOLDER_0_PATH_TEMPLATE);
                  return builder.build();
                })
            .setRequestMutator(
                request -> {
                  RenameFolderRequest.Builder requestBuilder = request.toBuilder();
                  if (Strings.isNullOrEmpty(request.getRequestId())) {
                    requestBuilder.setRequestId(UUID.randomUUID().toString());
                  }
                  return requestBuilder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<DeleteFolderRecursiveRequest, Operation>
        deleteFolderRecursiveTransportSettings =
            HttpJsonCallSettings.<DeleteFolderRecursiveRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteFolderRecursiveMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          request.getName(), "bucket", DELETE_FOLDER_RECURSIVE_0_PATH_TEMPLATE);
                      return builder.build();
                    })
                .setRequestMutator(
                    request -> {
                      DeleteFolderRecursiveRequest.Builder requestBuilder = request.toBuilder();
                      if (Strings.isNullOrEmpty(request.getRequestId())) {
                        requestBuilder.setRequestId(UUID.randomUUID().toString());
                      }
                      return requestBuilder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<GetStorageLayoutRequest, StorageLayout> getStorageLayoutTransportSettings =
        HttpJsonCallSettings.<GetStorageLayoutRequest, StorageLayout>newBuilder()
            .setMethodDescriptor(getStorageLayoutMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getName(), "bucket", GET_STORAGE_LAYOUT_0_PATH_TEMPLATE);
                  return builder.build();
                })
            .setRequestMutator(
                request -> {
                  GetStorageLayoutRequest.Builder requestBuilder = request.toBuilder();
                  if (Strings.isNullOrEmpty(request.getRequestId())) {
                    requestBuilder.setRequestId(UUID.randomUUID().toString());
                  }
                  return requestBuilder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<GetProjectIntelligenceConfigRequest, IntelligenceConfig>
        getProjectIntelligenceConfigTransportSettings =
            HttpJsonCallSettings
                .<GetProjectIntelligenceConfigRequest, IntelligenceConfig>newBuilder()
                .setMethodDescriptor(getProjectIntelligenceConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<UpdateProjectIntelligenceConfigRequest, IntelligenceConfig>
        updateProjectIntelligenceConfigTransportSettings =
            HttpJsonCallSettings
                .<UpdateProjectIntelligenceConfigRequest, IntelligenceConfig>newBuilder()
                .setMethodDescriptor(updateProjectIntelligenceConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "intelligence_config.name",
                          String.valueOf(request.getIntelligenceConfig().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetFolderIntelligenceConfigRequest, IntelligenceConfig>
        getFolderIntelligenceConfigTransportSettings =
            HttpJsonCallSettings
                .<GetFolderIntelligenceConfigRequest, IntelligenceConfig>newBuilder()
                .setMethodDescriptor(getFolderIntelligenceConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<UpdateFolderIntelligenceConfigRequest, IntelligenceConfig>
        updateFolderIntelligenceConfigTransportSettings =
            HttpJsonCallSettings
                .<UpdateFolderIntelligenceConfigRequest, IntelligenceConfig>newBuilder()
                .setMethodDescriptor(updateFolderIntelligenceConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "intelligence_config.name",
                          String.valueOf(request.getIntelligenceConfig().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetOrganizationIntelligenceConfigRequest, IntelligenceConfig>
        getOrganizationIntelligenceConfigTransportSettings =
            HttpJsonCallSettings
                .<GetOrganizationIntelligenceConfigRequest, IntelligenceConfig>newBuilder()
                .setMethodDescriptor(getOrganizationIntelligenceConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<UpdateOrganizationIntelligenceConfigRequest, IntelligenceConfig>
        updateOrganizationIntelligenceConfigTransportSettings =
            HttpJsonCallSettings
                .<UpdateOrganizationIntelligenceConfigRequest, IntelligenceConfig>newBuilder()
                .setMethodDescriptor(updateOrganizationIntelligenceConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "intelligence_config.name",
                          String.valueOf(request.getIntelligenceConfig().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetIntelligenceFindingRequest, IntelligenceFinding>
        getIntelligenceFindingTransportSettings =
            HttpJsonCallSettings.<GetIntelligenceFindingRequest, IntelligenceFinding>newBuilder()
                .setMethodDescriptor(getIntelligenceFindingMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<ListIntelligenceFindingsRequest, ListIntelligenceFindingsResponse>
        listIntelligenceFindingsTransportSettings =
            HttpJsonCallSettings
                .<ListIntelligenceFindingsRequest, ListIntelligenceFindingsResponse>newBuilder()
                .setMethodDescriptor(listIntelligenceFindingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<
            SummarizeIntelligenceFindingsRequest, SummarizeIntelligenceFindingsResponse>
        summarizeIntelligenceFindingsTransportSettings =
            HttpJsonCallSettings
                .<SummarizeIntelligenceFindingsRequest, SummarizeIntelligenceFindingsResponse>
                    newBuilder()
                .setMethodDescriptor(summarizeIntelligenceFindingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetIntelligenceFindingRevisionRequest, IntelligenceFindingRevision>
        getIntelligenceFindingRevisionTransportSettings =
            HttpJsonCallSettings
                .<GetIntelligenceFindingRevisionRequest, IntelligenceFindingRevision>newBuilder()
                .setMethodDescriptor(getIntelligenceFindingRevisionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<
            ListIntelligenceFindingRevisionsRequest, ListIntelligenceFindingRevisionsResponse>
        listIntelligenceFindingRevisionsTransportSettings =
            HttpJsonCallSettings
                .<ListIntelligenceFindingRevisionsRequest, ListIntelligenceFindingRevisionsResponse>
                    newBuilder()
                .setMethodDescriptor(listIntelligenceFindingRevisionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();

    this.createFolderCallable =
        callableFactory.createUnaryCallable(
            createFolderTransportSettings, settings.createFolderSettings(), clientContext);
    this.deleteFolderCallable =
        callableFactory.createUnaryCallable(
            deleteFolderTransportSettings, settings.deleteFolderSettings(), clientContext);
    this.getFolderCallable =
        callableFactory.createUnaryCallable(
            getFolderTransportSettings, settings.getFolderSettings(), clientContext);
    this.listFoldersCallable =
        callableFactory.createUnaryCallable(
            listFoldersTransportSettings, settings.listFoldersSettings(), clientContext);
    this.listFoldersPagedCallable =
        callableFactory.createPagedCallable(
            listFoldersTransportSettings, settings.listFoldersSettings(), clientContext);
    this.renameFolderCallable =
        callableFactory.createUnaryCallable(
            renameFolderTransportSettings, settings.renameFolderSettings(), clientContext);
    this.renameFolderOperationCallable =
        callableFactory.createOperationCallable(
            renameFolderTransportSettings,
            settings.renameFolderOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteFolderRecursiveCallable =
        callableFactory.createUnaryCallable(
            deleteFolderRecursiveTransportSettings,
            settings.deleteFolderRecursiveSettings(),
            clientContext);
    this.deleteFolderRecursiveOperationCallable =
        callableFactory.createOperationCallable(
            deleteFolderRecursiveTransportSettings,
            settings.deleteFolderRecursiveOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getStorageLayoutCallable =
        callableFactory.createUnaryCallable(
            getStorageLayoutTransportSettings, settings.getStorageLayoutSettings(), clientContext);
    this.getProjectIntelligenceConfigCallable =
        callableFactory.createUnaryCallable(
            getProjectIntelligenceConfigTransportSettings,
            settings.getProjectIntelligenceConfigSettings(),
            clientContext);
    this.updateProjectIntelligenceConfigCallable =
        callableFactory.createUnaryCallable(
            updateProjectIntelligenceConfigTransportSettings,
            settings.updateProjectIntelligenceConfigSettings(),
            clientContext);
    this.getFolderIntelligenceConfigCallable =
        callableFactory.createUnaryCallable(
            getFolderIntelligenceConfigTransportSettings,
            settings.getFolderIntelligenceConfigSettings(),
            clientContext);
    this.updateFolderIntelligenceConfigCallable =
        callableFactory.createUnaryCallable(
            updateFolderIntelligenceConfigTransportSettings,
            settings.updateFolderIntelligenceConfigSettings(),
            clientContext);
    this.getOrganizationIntelligenceConfigCallable =
        callableFactory.createUnaryCallable(
            getOrganizationIntelligenceConfigTransportSettings,
            settings.getOrganizationIntelligenceConfigSettings(),
            clientContext);
    this.updateOrganizationIntelligenceConfigCallable =
        callableFactory.createUnaryCallable(
            updateOrganizationIntelligenceConfigTransportSettings,
            settings.updateOrganizationIntelligenceConfigSettings(),
            clientContext);
    this.getIntelligenceFindingCallable =
        callableFactory.createUnaryCallable(
            getIntelligenceFindingTransportSettings,
            settings.getIntelligenceFindingSettings(),
            clientContext);
    this.listIntelligenceFindingsCallable =
        callableFactory.createUnaryCallable(
            listIntelligenceFindingsTransportSettings,
            settings.listIntelligenceFindingsSettings(),
            clientContext);
    this.listIntelligenceFindingsPagedCallable =
        callableFactory.createPagedCallable(
            listIntelligenceFindingsTransportSettings,
            settings.listIntelligenceFindingsSettings(),
            clientContext);
    this.summarizeIntelligenceFindingsCallable =
        callableFactory.createUnaryCallable(
            summarizeIntelligenceFindingsTransportSettings,
            settings.summarizeIntelligenceFindingsSettings(),
            clientContext);
    this.summarizeIntelligenceFindingsPagedCallable =
        callableFactory.createPagedCallable(
            summarizeIntelligenceFindingsTransportSettings,
            settings.summarizeIntelligenceFindingsSettings(),
            clientContext);
    this.getIntelligenceFindingRevisionCallable =
        callableFactory.createUnaryCallable(
            getIntelligenceFindingRevisionTransportSettings,
            settings.getIntelligenceFindingRevisionSettings(),
            clientContext);
    this.listIntelligenceFindingRevisionsCallable =
        callableFactory.createUnaryCallable(
            listIntelligenceFindingRevisionsTransportSettings,
            settings.listIntelligenceFindingRevisionsSettings(),
            clientContext);
    this.listIntelligenceFindingRevisionsPagedCallable =
        callableFactory.createPagedCallable(
            listIntelligenceFindingRevisionsTransportSettings,
            settings.listIntelligenceFindingRevisionsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createFolderMethodDescriptor);
    methodDescriptors.add(deleteFolderMethodDescriptor);
    methodDescriptors.add(getFolderMethodDescriptor);
    methodDescriptors.add(listFoldersMethodDescriptor);
    methodDescriptors.add(renameFolderMethodDescriptor);
    methodDescriptors.add(deleteFolderRecursiveMethodDescriptor);
    methodDescriptors.add(getStorageLayoutMethodDescriptor);
    methodDescriptors.add(getProjectIntelligenceConfigMethodDescriptor);
    methodDescriptors.add(updateProjectIntelligenceConfigMethodDescriptor);
    methodDescriptors.add(getFolderIntelligenceConfigMethodDescriptor);
    methodDescriptors.add(updateFolderIntelligenceConfigMethodDescriptor);
    methodDescriptors.add(getOrganizationIntelligenceConfigMethodDescriptor);
    methodDescriptors.add(updateOrganizationIntelligenceConfigMethodDescriptor);
    methodDescriptors.add(getIntelligenceFindingMethodDescriptor);
    methodDescriptors.add(listIntelligenceFindingsMethodDescriptor);
    methodDescriptors.add(summarizeIntelligenceFindingsMethodDescriptor);
    methodDescriptors.add(getIntelligenceFindingRevisionMethodDescriptor);
    methodDescriptors.add(listIntelligenceFindingRevisionsMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<CreateFolderRequest, Folder> createFolderCallable() {
    return createFolderCallable;
  }

  @Override
  public UnaryCallable<DeleteFolderRequest, Empty> deleteFolderCallable() {
    return deleteFolderCallable;
  }

  @Override
  public UnaryCallable<GetFolderRequest, Folder> getFolderCallable() {
    return getFolderCallable;
  }

  @Override
  public UnaryCallable<ListFoldersRequest, ListFoldersResponse> listFoldersCallable() {
    return listFoldersCallable;
  }

  @Override
  public UnaryCallable<ListFoldersRequest, ListFoldersPagedResponse> listFoldersPagedCallable() {
    return listFoldersPagedCallable;
  }

  @Override
  public UnaryCallable<RenameFolderRequest, Operation> renameFolderCallable() {
    return renameFolderCallable;
  }

  @Override
  public OperationCallable<RenameFolderRequest, Folder, RenameFolderMetadata>
      renameFolderOperationCallable() {
    return renameFolderOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteFolderRecursiveRequest, Operation> deleteFolderRecursiveCallable() {
    return deleteFolderRecursiveCallable;
  }

  @Override
  public OperationCallable<DeleteFolderRecursiveRequest, Empty, DeleteFolderRecursiveMetadata>
      deleteFolderRecursiveOperationCallable() {
    return deleteFolderRecursiveOperationCallable;
  }

  @Override
  public UnaryCallable<GetStorageLayoutRequest, StorageLayout> getStorageLayoutCallable() {
    return getStorageLayoutCallable;
  }

  @Override
  public UnaryCallable<GetProjectIntelligenceConfigRequest, IntelligenceConfig>
      getProjectIntelligenceConfigCallable() {
    return getProjectIntelligenceConfigCallable;
  }

  @Override
  public UnaryCallable<UpdateProjectIntelligenceConfigRequest, IntelligenceConfig>
      updateProjectIntelligenceConfigCallable() {
    return updateProjectIntelligenceConfigCallable;
  }

  @Override
  public UnaryCallable<GetFolderIntelligenceConfigRequest, IntelligenceConfig>
      getFolderIntelligenceConfigCallable() {
    return getFolderIntelligenceConfigCallable;
  }

  @Override
  public UnaryCallable<UpdateFolderIntelligenceConfigRequest, IntelligenceConfig>
      updateFolderIntelligenceConfigCallable() {
    return updateFolderIntelligenceConfigCallable;
  }

  @Override
  public UnaryCallable<GetOrganizationIntelligenceConfigRequest, IntelligenceConfig>
      getOrganizationIntelligenceConfigCallable() {
    return getOrganizationIntelligenceConfigCallable;
  }

  @Override
  public UnaryCallable<UpdateOrganizationIntelligenceConfigRequest, IntelligenceConfig>
      updateOrganizationIntelligenceConfigCallable() {
    return updateOrganizationIntelligenceConfigCallable;
  }

  @Override
  public UnaryCallable<GetIntelligenceFindingRequest, IntelligenceFinding>
      getIntelligenceFindingCallable() {
    return getIntelligenceFindingCallable;
  }

  @Override
  public UnaryCallable<ListIntelligenceFindingsRequest, ListIntelligenceFindingsResponse>
      listIntelligenceFindingsCallable() {
    return listIntelligenceFindingsCallable;
  }

  @Override
  public UnaryCallable<ListIntelligenceFindingsRequest, ListIntelligenceFindingsPagedResponse>
      listIntelligenceFindingsPagedCallable() {
    return listIntelligenceFindingsPagedCallable;
  }

  @Override
  public UnaryCallable<SummarizeIntelligenceFindingsRequest, SummarizeIntelligenceFindingsResponse>
      summarizeIntelligenceFindingsCallable() {
    return summarizeIntelligenceFindingsCallable;
  }

  @Override
  public UnaryCallable<
          SummarizeIntelligenceFindingsRequest, SummarizeIntelligenceFindingsPagedResponse>
      summarizeIntelligenceFindingsPagedCallable() {
    return summarizeIntelligenceFindingsPagedCallable;
  }

  @Override
  public UnaryCallable<GetIntelligenceFindingRevisionRequest, IntelligenceFindingRevision>
      getIntelligenceFindingRevisionCallable() {
    return getIntelligenceFindingRevisionCallable;
  }

  @Override
  public UnaryCallable<
          ListIntelligenceFindingRevisionsRequest, ListIntelligenceFindingRevisionsResponse>
      listIntelligenceFindingRevisionsCallable() {
    return listIntelligenceFindingRevisionsCallable;
  }

  @Override
  public UnaryCallable<
          ListIntelligenceFindingRevisionsRequest, ListIntelligenceFindingRevisionsPagedResponse>
      listIntelligenceFindingRevisionsPagedCallable() {
    return listIntelligenceFindingRevisionsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateManagedFolderRequest, ManagedFolder> createManagedFolderCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createManagedFolderCallable(). REST transport is not implemented for this"
            + " method yet.");
  }

  @Override
  public UnaryCallable<DeleteManagedFolderRequest, Empty> deleteManagedFolderCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteManagedFolderCallable(). REST transport is not implemented for this"
            + " method yet.");
  }

  @Override
  public UnaryCallable<GetManagedFolderRequest, ManagedFolder> getManagedFolderCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getManagedFolderCallable(). REST transport is not implemented for this"
            + " method yet.");
  }

  @Override
  public UnaryCallable<ListManagedFoldersRequest, ListManagedFoldersResponse>
      listManagedFoldersCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listManagedFoldersCallable(). REST transport is not implemented for this"
            + " method yet.");
  }

  @Override
  public UnaryCallable<UpdateManagedFolderRequest, ManagedFolder> updateManagedFolderCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateManagedFolderCallable(). REST transport is not implemented for this"
            + " method yet.");
  }

  @Override
  public UnaryCallable<CreateAnywhereCacheRequest, Operation> createAnywhereCacheCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createAnywhereCacheCallable(). REST transport is not implemented for this"
            + " method yet.");
  }

  @Override
  public UnaryCallable<UpdateAnywhereCacheRequest, Operation> updateAnywhereCacheCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateAnywhereCacheCallable(). REST transport is not implemented for this"
            + " method yet.");
  }

  @Override
  public UnaryCallable<DisableAnywhereCacheRequest, AnywhereCache> disableAnywhereCacheCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: disableAnywhereCacheCallable(). REST transport is not implemented for"
            + " this method yet.");
  }

  @Override
  public UnaryCallable<PauseAnywhereCacheRequest, AnywhereCache> pauseAnywhereCacheCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: pauseAnywhereCacheCallable(). REST transport is not implemented for this"
            + " method yet.");
  }

  @Override
  public UnaryCallable<ResumeAnywhereCacheRequest, AnywhereCache> resumeAnywhereCacheCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: resumeAnywhereCacheCallable(). REST transport is not implemented for this"
            + " method yet.");
  }

  @Override
  public UnaryCallable<GetAnywhereCacheRequest, AnywhereCache> getAnywhereCacheCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getAnywhereCacheCallable(). REST transport is not implemented for this"
            + " method yet.");
  }

  @Override
  public UnaryCallable<ListAnywhereCachesRequest, ListAnywhereCachesResponse>
      listAnywhereCachesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listAnywhereCachesCallable(). REST transport is not implemented for this"
            + " method yet.");
  }

  @Override
  public UnaryCallable<CreateRapidCacheRequest, Operation> createRapidCacheCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createRapidCacheCallable(). REST transport is not implemented for this"
            + " method yet.");
  }

  @Override
  public UnaryCallable<UpdateRapidCacheRequest, Operation> updateRapidCacheCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateRapidCacheCallable(). REST transport is not implemented for this"
            + " method yet.");
  }

  @Override
  public UnaryCallable<GetRapidCacheRequest, RapidCache> getRapidCacheCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getRapidCacheCallable(). REST transport is not implemented for this"
            + " method yet.");
  }

  @Override
  public UnaryCallable<ListRapidCachesRequest, ListRapidCachesResponse> listRapidCachesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listRapidCachesCallable(). REST transport is not implemented for this"
            + " method yet.");
  }

  @Override
  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getIamPolicyCallable(). REST transport is not implemented for this method"
            + " yet.");
  }

  @Override
  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: setIamPolicyCallable(). REST transport is not implemented for this method"
            + " yet.");
  }

  @Override
  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: testIamPermissionsCallable(). REST transport is not implemented for this"
            + " method yet.");
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
