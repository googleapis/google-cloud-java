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

import static com.google.storage.control.v2.StorageControlClient.ListAnywhereCachesPagedResponse;
import static com.google.storage.control.v2.StorageControlClient.ListFoldersPagedResponse;
import static com.google.storage.control.v2.StorageControlClient.ListManagedFoldersPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
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
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import com.google.storage.control.v2.AnywhereCache;
import com.google.storage.control.v2.CreateAnywhereCacheMetadata;
import com.google.storage.control.v2.CreateAnywhereCacheRequest;
import com.google.storage.control.v2.CreateFolderRequest;
import com.google.storage.control.v2.CreateManagedFolderRequest;
import com.google.storage.control.v2.DeleteFolderRecursiveMetadata;
import com.google.storage.control.v2.DeleteFolderRecursiveRequest;
import com.google.storage.control.v2.DeleteFolderRequest;
import com.google.storage.control.v2.DeleteManagedFolderRequest;
import com.google.storage.control.v2.DisableAnywhereCacheRequest;
import com.google.storage.control.v2.Folder;
import com.google.storage.control.v2.GetAnywhereCacheRequest;
import com.google.storage.control.v2.GetFolderIntelligenceConfigRequest;
import com.google.storage.control.v2.GetFolderRequest;
import com.google.storage.control.v2.GetManagedFolderRequest;
import com.google.storage.control.v2.GetOrganizationIntelligenceConfigRequest;
import com.google.storage.control.v2.GetProjectIntelligenceConfigRequest;
import com.google.storage.control.v2.GetStorageLayoutRequest;
import com.google.storage.control.v2.IntelligenceConfig;
import com.google.storage.control.v2.ListAnywhereCachesRequest;
import com.google.storage.control.v2.ListAnywhereCachesResponse;
import com.google.storage.control.v2.ListFoldersRequest;
import com.google.storage.control.v2.ListFoldersResponse;
import com.google.storage.control.v2.ListManagedFoldersRequest;
import com.google.storage.control.v2.ListManagedFoldersResponse;
import com.google.storage.control.v2.ManagedFolder;
import com.google.storage.control.v2.PauseAnywhereCacheRequest;
import com.google.storage.control.v2.RenameFolderMetadata;
import com.google.storage.control.v2.RenameFolderRequest;
import com.google.storage.control.v2.ResumeAnywhereCacheRequest;
import com.google.storage.control.v2.StorageLayout;
import com.google.storage.control.v2.UpdateAnywhereCacheMetadata;
import com.google.storage.control.v2.UpdateAnywhereCacheRequest;
import com.google.storage.control.v2.UpdateFolderIntelligenceConfigRequest;
import com.google.storage.control.v2.UpdateOrganizationIntelligenceConfigRequest;
import com.google.storage.control.v2.UpdateProjectIntelligenceConfigRequest;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the StorageControl service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcStorageControlStub extends StorageControlStub {
  private static final MethodDescriptor<CreateFolderRequest, Folder> createFolderMethodDescriptor =
      MethodDescriptor.<CreateFolderRequest, Folder>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.storage.control.v2.StorageControl/CreateFolder")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateFolderRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Folder.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<DeleteFolderRequest, Empty> deleteFolderMethodDescriptor =
      MethodDescriptor.<DeleteFolderRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.storage.control.v2.StorageControl/DeleteFolder")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteFolderRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<GetFolderRequest, Folder> getFolderMethodDescriptor =
      MethodDescriptor.<GetFolderRequest, Folder>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.storage.control.v2.StorageControl/GetFolder")
          .setRequestMarshaller(ProtoUtils.marshaller(GetFolderRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Folder.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListFoldersRequest, ListFoldersResponse>
      listFoldersMethodDescriptor =
          MethodDescriptor.<ListFoldersRequest, ListFoldersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.storage.control.v2.StorageControl/ListFolders")
              .setRequestMarshaller(ProtoUtils.marshaller(ListFoldersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListFoldersResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<RenameFolderRequest, Operation>
      renameFolderMethodDescriptor =
          MethodDescriptor.<RenameFolderRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.storage.control.v2.StorageControl/RenameFolder")
              .setRequestMarshaller(ProtoUtils.marshaller(RenameFolderRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteFolderRecursiveRequest, Operation>
      deleteFolderRecursiveMethodDescriptor =
          MethodDescriptor.<DeleteFolderRecursiveRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.storage.control.v2.StorageControl/DeleteFolderRecursive")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteFolderRecursiveRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetStorageLayoutRequest, StorageLayout>
      getStorageLayoutMethodDescriptor =
          MethodDescriptor.<GetStorageLayoutRequest, StorageLayout>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.storage.control.v2.StorageControl/GetStorageLayout")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetStorageLayoutRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(StorageLayout.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateManagedFolderRequest, ManagedFolder>
      createManagedFolderMethodDescriptor =
          MethodDescriptor.<CreateManagedFolderRequest, ManagedFolder>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.storage.control.v2.StorageControl/CreateManagedFolder")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateManagedFolderRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ManagedFolder.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteManagedFolderRequest, Empty>
      deleteManagedFolderMethodDescriptor =
          MethodDescriptor.<DeleteManagedFolderRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.storage.control.v2.StorageControl/DeleteManagedFolder")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteManagedFolderRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetManagedFolderRequest, ManagedFolder>
      getManagedFolderMethodDescriptor =
          MethodDescriptor.<GetManagedFolderRequest, ManagedFolder>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.storage.control.v2.StorageControl/GetManagedFolder")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetManagedFolderRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ManagedFolder.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListManagedFoldersRequest, ListManagedFoldersResponse>
      listManagedFoldersMethodDescriptor =
          MethodDescriptor.<ListManagedFoldersRequest, ListManagedFoldersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.storage.control.v2.StorageControl/ListManagedFolders")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListManagedFoldersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListManagedFoldersResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateAnywhereCacheRequest, Operation>
      createAnywhereCacheMethodDescriptor =
          MethodDescriptor.<CreateAnywhereCacheRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.storage.control.v2.StorageControl/CreateAnywhereCache")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateAnywhereCacheRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateAnywhereCacheRequest, Operation>
      updateAnywhereCacheMethodDescriptor =
          MethodDescriptor.<UpdateAnywhereCacheRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.storage.control.v2.StorageControl/UpdateAnywhereCache")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateAnywhereCacheRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DisableAnywhereCacheRequest, AnywhereCache>
      disableAnywhereCacheMethodDescriptor =
          MethodDescriptor.<DisableAnywhereCacheRequest, AnywhereCache>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.storage.control.v2.StorageControl/DisableAnywhereCache")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DisableAnywhereCacheRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AnywhereCache.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<PauseAnywhereCacheRequest, AnywhereCache>
      pauseAnywhereCacheMethodDescriptor =
          MethodDescriptor.<PauseAnywhereCacheRequest, AnywhereCache>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.storage.control.v2.StorageControl/PauseAnywhereCache")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(PauseAnywhereCacheRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AnywhereCache.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ResumeAnywhereCacheRequest, AnywhereCache>
      resumeAnywhereCacheMethodDescriptor =
          MethodDescriptor.<ResumeAnywhereCacheRequest, AnywhereCache>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.storage.control.v2.StorageControl/ResumeAnywhereCache")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ResumeAnywhereCacheRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AnywhereCache.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetAnywhereCacheRequest, AnywhereCache>
      getAnywhereCacheMethodDescriptor =
          MethodDescriptor.<GetAnywhereCacheRequest, AnywhereCache>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.storage.control.v2.StorageControl/GetAnywhereCache")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAnywhereCacheRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AnywhereCache.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListAnywhereCachesRequest, ListAnywhereCachesResponse>
      listAnywhereCachesMethodDescriptor =
          MethodDescriptor.<ListAnywhereCachesRequest, ListAnywhereCachesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.storage.control.v2.StorageControl/ListAnywhereCaches")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAnywhereCachesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAnywhereCachesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetProjectIntelligenceConfigRequest, IntelligenceConfig>
      getProjectIntelligenceConfigMethodDescriptor =
          MethodDescriptor.<GetProjectIntelligenceConfigRequest, IntelligenceConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.storage.control.v2.StorageControl/GetProjectIntelligenceConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetProjectIntelligenceConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(IntelligenceConfig.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateProjectIntelligenceConfigRequest, IntelligenceConfig>
      updateProjectIntelligenceConfigMethodDescriptor =
          MethodDescriptor.<UpdateProjectIntelligenceConfigRequest, IntelligenceConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.storage.control.v2.StorageControl/UpdateProjectIntelligenceConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      UpdateProjectIntelligenceConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(IntelligenceConfig.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetFolderIntelligenceConfigRequest, IntelligenceConfig>
      getFolderIntelligenceConfigMethodDescriptor =
          MethodDescriptor.<GetFolderIntelligenceConfigRequest, IntelligenceConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.storage.control.v2.StorageControl/GetFolderIntelligenceConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetFolderIntelligenceConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(IntelligenceConfig.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateFolderIntelligenceConfigRequest, IntelligenceConfig>
      updateFolderIntelligenceConfigMethodDescriptor =
          MethodDescriptor.<UpdateFolderIntelligenceConfigRequest, IntelligenceConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.storage.control.v2.StorageControl/UpdateFolderIntelligenceConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateFolderIntelligenceConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(IntelligenceConfig.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          GetOrganizationIntelligenceConfigRequest, IntelligenceConfig>
      getOrganizationIntelligenceConfigMethodDescriptor =
          MethodDescriptor
              .<GetOrganizationIntelligenceConfigRequest, IntelligenceConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.storage.control.v2.StorageControl/GetOrganizationIntelligenceConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      GetOrganizationIntelligenceConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(IntelligenceConfig.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          UpdateOrganizationIntelligenceConfigRequest, IntelligenceConfig>
      updateOrganizationIntelligenceConfigMethodDescriptor =
          MethodDescriptor
              .<UpdateOrganizationIntelligenceConfigRequest, IntelligenceConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.storage.control.v2.StorageControl/UpdateOrganizationIntelligenceConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      UpdateOrganizationIntelligenceConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(IntelligenceConfig.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.storage.control.v2.StorageControl/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.storage.control.v2.StorageControl/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          MethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.storage.control.v2.StorageControl/TestIamPermissions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
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
  private final UnaryCallable<CreateManagedFolderRequest, ManagedFolder>
      createManagedFolderCallable;
  private final UnaryCallable<DeleteManagedFolderRequest, Empty> deleteManagedFolderCallable;
  private final UnaryCallable<GetManagedFolderRequest, ManagedFolder> getManagedFolderCallable;
  private final UnaryCallable<ListManagedFoldersRequest, ListManagedFoldersResponse>
      listManagedFoldersCallable;
  private final UnaryCallable<ListManagedFoldersRequest, ListManagedFoldersPagedResponse>
      listManagedFoldersPagedCallable;
  private final UnaryCallable<CreateAnywhereCacheRequest, Operation> createAnywhereCacheCallable;
  private final OperationCallable<
          CreateAnywhereCacheRequest, AnywhereCache, CreateAnywhereCacheMetadata>
      createAnywhereCacheOperationCallable;
  private final UnaryCallable<UpdateAnywhereCacheRequest, Operation> updateAnywhereCacheCallable;
  private final OperationCallable<
          UpdateAnywhereCacheRequest, AnywhereCache, UpdateAnywhereCacheMetadata>
      updateAnywhereCacheOperationCallable;
  private final UnaryCallable<DisableAnywhereCacheRequest, AnywhereCache>
      disableAnywhereCacheCallable;
  private final UnaryCallable<PauseAnywhereCacheRequest, AnywhereCache> pauseAnywhereCacheCallable;
  private final UnaryCallable<ResumeAnywhereCacheRequest, AnywhereCache>
      resumeAnywhereCacheCallable;
  private final UnaryCallable<GetAnywhereCacheRequest, AnywhereCache> getAnywhereCacheCallable;
  private final UnaryCallable<ListAnywhereCachesRequest, ListAnywhereCachesResponse>
      listAnywhereCachesCallable;
  private final UnaryCallable<ListAnywhereCachesRequest, ListAnywhereCachesPagedResponse>
      listAnywhereCachesPagedCallable;
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
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

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
  private static final PathTemplate CREATE_MANAGED_FOLDER_0_PATH_TEMPLATE =
      PathTemplate.create("{bucket=**}");
  private static final PathTemplate DELETE_MANAGED_FOLDER_0_PATH_TEMPLATE =
      PathTemplate.create("{bucket=projects/*/buckets/*}/**");
  private static final PathTemplate GET_MANAGED_FOLDER_0_PATH_TEMPLATE =
      PathTemplate.create("{bucket=projects/*/buckets/*}/**");
  private static final PathTemplate LIST_MANAGED_FOLDERS_0_PATH_TEMPLATE =
      PathTemplate.create("{bucket=**}");
  private static final PathTemplate CREATE_ANYWHERE_CACHE_0_PATH_TEMPLATE =
      PathTemplate.create("{bucket=**}");
  private static final PathTemplate UPDATE_ANYWHERE_CACHE_0_PATH_TEMPLATE =
      PathTemplate.create("{bucket=projects/*/buckets/*}/**");
  private static final PathTemplate DISABLE_ANYWHERE_CACHE_0_PATH_TEMPLATE =
      PathTemplate.create("{bucket=projects/*/buckets/*}/**");
  private static final PathTemplate PAUSE_ANYWHERE_CACHE_0_PATH_TEMPLATE =
      PathTemplate.create("{bucket=projects/*/buckets/*}/**");
  private static final PathTemplate RESUME_ANYWHERE_CACHE_0_PATH_TEMPLATE =
      PathTemplate.create("{bucket=projects/*/buckets/*}/**");
  private static final PathTemplate GET_ANYWHERE_CACHE_0_PATH_TEMPLATE =
      PathTemplate.create("{bucket=projects/*/buckets/*}/**");
  private static final PathTemplate LIST_ANYWHERE_CACHES_0_PATH_TEMPLATE =
      PathTemplate.create("{bucket=**}");
  private static final PathTemplate GET_IAM_POLICY_0_PATH_TEMPLATE =
      PathTemplate.create("{bucket=**}");
  private static final PathTemplate GET_IAM_POLICY_1_PATH_TEMPLATE =
      PathTemplate.create("{bucket=projects/*/buckets/*}/**");
  private static final PathTemplate SET_IAM_POLICY_0_PATH_TEMPLATE =
      PathTemplate.create("{bucket=**}");
  private static final PathTemplate SET_IAM_POLICY_1_PATH_TEMPLATE =
      PathTemplate.create("{bucket=projects/*/buckets/*}/**");
  private static final PathTemplate TEST_IAM_PERMISSIONS_0_PATH_TEMPLATE =
      PathTemplate.create("{bucket=**}");
  private static final PathTemplate TEST_IAM_PERMISSIONS_1_PATH_TEMPLATE =
      PathTemplate.create("{bucket=projects/*/buckets/*}/objects/**");
  private static final PathTemplate TEST_IAM_PERMISSIONS_2_PATH_TEMPLATE =
      PathTemplate.create("{bucket=projects/*/buckets/*}/managedFolders/**");

  public static final GrpcStorageControlStub create(StorageControlStubSettings settings)
      throws IOException {
    return new GrpcStorageControlStub(settings, ClientContext.create(settings));
  }

  public static final GrpcStorageControlStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcStorageControlStub(
        StorageControlStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcStorageControlStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcStorageControlStub(
        StorageControlStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcStorageControlStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcStorageControlStub(StorageControlStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcStorageControlCallableFactory());
  }

  /**
   * Constructs an instance of GrpcStorageControlStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcStorageControlStub(
      StorageControlStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateFolderRequest, Folder> createFolderTransportSettings =
        GrpcCallSettings.<CreateFolderRequest, Folder>newBuilder()
            .setMethodDescriptor(createFolderMethodDescriptor)
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
    GrpcCallSettings<DeleteFolderRequest, Empty> deleteFolderTransportSettings =
        GrpcCallSettings.<DeleteFolderRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteFolderMethodDescriptor)
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
    GrpcCallSettings<GetFolderRequest, Folder> getFolderTransportSettings =
        GrpcCallSettings.<GetFolderRequest, Folder>newBuilder()
            .setMethodDescriptor(getFolderMethodDescriptor)
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
    GrpcCallSettings<ListFoldersRequest, ListFoldersResponse> listFoldersTransportSettings =
        GrpcCallSettings.<ListFoldersRequest, ListFoldersResponse>newBuilder()
            .setMethodDescriptor(listFoldersMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getParent(), "bucket", LIST_FOLDERS_0_PATH_TEMPLATE);
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<RenameFolderRequest, Operation> renameFolderTransportSettings =
        GrpcCallSettings.<RenameFolderRequest, Operation>newBuilder()
            .setMethodDescriptor(renameFolderMethodDescriptor)
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
    GrpcCallSettings<DeleteFolderRecursiveRequest, Operation>
        deleteFolderRecursiveTransportSettings =
            GrpcCallSettings.<DeleteFolderRecursiveRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteFolderRecursiveMethodDescriptor)
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
    GrpcCallSettings<GetStorageLayoutRequest, StorageLayout> getStorageLayoutTransportSettings =
        GrpcCallSettings.<GetStorageLayoutRequest, StorageLayout>newBuilder()
            .setMethodDescriptor(getStorageLayoutMethodDescriptor)
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
    GrpcCallSettings<CreateManagedFolderRequest, ManagedFolder>
        createManagedFolderTransportSettings =
            GrpcCallSettings.<CreateManagedFolderRequest, ManagedFolder>newBuilder()
                .setMethodDescriptor(createManagedFolderMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          request.getParent(), "bucket", CREATE_MANAGED_FOLDER_0_PATH_TEMPLATE);
                      return builder.build();
                    })
                .setRequestMutator(
                    request -> {
                      CreateManagedFolderRequest.Builder requestBuilder = request.toBuilder();
                      if (Strings.isNullOrEmpty(request.getRequestId())) {
                        requestBuilder.setRequestId(UUID.randomUUID().toString());
                      }
                      return requestBuilder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<DeleteManagedFolderRequest, Empty> deleteManagedFolderTransportSettings =
        GrpcCallSettings.<DeleteManagedFolderRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteManagedFolderMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getName(), "bucket", DELETE_MANAGED_FOLDER_0_PATH_TEMPLATE);
                  return builder.build();
                })
            .setRequestMutator(
                request -> {
                  DeleteManagedFolderRequest.Builder requestBuilder = request.toBuilder();
                  if (Strings.isNullOrEmpty(request.getRequestId())) {
                    requestBuilder.setRequestId(UUID.randomUUID().toString());
                  }
                  return requestBuilder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<GetManagedFolderRequest, ManagedFolder> getManagedFolderTransportSettings =
        GrpcCallSettings.<GetManagedFolderRequest, ManagedFolder>newBuilder()
            .setMethodDescriptor(getManagedFolderMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getName(), "bucket", GET_MANAGED_FOLDER_0_PATH_TEMPLATE);
                  return builder.build();
                })
            .setRequestMutator(
                request -> {
                  GetManagedFolderRequest.Builder requestBuilder = request.toBuilder();
                  if (Strings.isNullOrEmpty(request.getRequestId())) {
                    requestBuilder.setRequestId(UUID.randomUUID().toString());
                  }
                  return requestBuilder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ListManagedFoldersRequest, ListManagedFoldersResponse>
        listManagedFoldersTransportSettings =
            GrpcCallSettings.<ListManagedFoldersRequest, ListManagedFoldersResponse>newBuilder()
                .setMethodDescriptor(listManagedFoldersMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          request.getParent(), "bucket", LIST_MANAGED_FOLDERS_0_PATH_TEMPLATE);
                      return builder.build();
                    })
                .setRequestMutator(
                    request -> {
                      ListManagedFoldersRequest.Builder requestBuilder = request.toBuilder();
                      if (Strings.isNullOrEmpty(request.getRequestId())) {
                        requestBuilder.setRequestId(UUID.randomUUID().toString());
                      }
                      return requestBuilder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<CreateAnywhereCacheRequest, Operation> createAnywhereCacheTransportSettings =
        GrpcCallSettings.<CreateAnywhereCacheRequest, Operation>newBuilder()
            .setMethodDescriptor(createAnywhereCacheMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getParent(), "bucket", CREATE_ANYWHERE_CACHE_0_PATH_TEMPLATE);
                  return builder.build();
                })
            .setRequestMutator(
                request -> {
                  CreateAnywhereCacheRequest.Builder requestBuilder = request.toBuilder();
                  if (Strings.isNullOrEmpty(request.getRequestId())) {
                    requestBuilder.setRequestId(UUID.randomUUID().toString());
                  }
                  return requestBuilder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<UpdateAnywhereCacheRequest, Operation> updateAnywhereCacheTransportSettings =
        GrpcCallSettings.<UpdateAnywhereCacheRequest, Operation>newBuilder()
            .setMethodDescriptor(updateAnywhereCacheMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  if (request.getAnywhereCache() != null) {
                    builder.add(
                        request.getAnywhereCache().getName(),
                        "bucket",
                        UPDATE_ANYWHERE_CACHE_0_PATH_TEMPLATE);
                  }
                  return builder.build();
                })
            .setRequestMutator(
                request -> {
                  UpdateAnywhereCacheRequest.Builder requestBuilder = request.toBuilder();
                  if (Strings.isNullOrEmpty(request.getRequestId())) {
                    requestBuilder.setRequestId(UUID.randomUUID().toString());
                  }
                  return requestBuilder.build();
                })
            .build();
    GrpcCallSettings<DisableAnywhereCacheRequest, AnywhereCache>
        disableAnywhereCacheTransportSettings =
            GrpcCallSettings.<DisableAnywhereCacheRequest, AnywhereCache>newBuilder()
                .setMethodDescriptor(disableAnywhereCacheMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          request.getName(), "bucket", DISABLE_ANYWHERE_CACHE_0_PATH_TEMPLATE);
                      return builder.build();
                    })
                .setRequestMutator(
                    request -> {
                      DisableAnywhereCacheRequest.Builder requestBuilder = request.toBuilder();
                      if (Strings.isNullOrEmpty(request.getRequestId())) {
                        requestBuilder.setRequestId(UUID.randomUUID().toString());
                      }
                      return requestBuilder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<PauseAnywhereCacheRequest, AnywhereCache> pauseAnywhereCacheTransportSettings =
        GrpcCallSettings.<PauseAnywhereCacheRequest, AnywhereCache>newBuilder()
            .setMethodDescriptor(pauseAnywhereCacheMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getName(), "bucket", PAUSE_ANYWHERE_CACHE_0_PATH_TEMPLATE);
                  return builder.build();
                })
            .setRequestMutator(
                request -> {
                  PauseAnywhereCacheRequest.Builder requestBuilder = request.toBuilder();
                  if (Strings.isNullOrEmpty(request.getRequestId())) {
                    requestBuilder.setRequestId(UUID.randomUUID().toString());
                  }
                  return requestBuilder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ResumeAnywhereCacheRequest, AnywhereCache>
        resumeAnywhereCacheTransportSettings =
            GrpcCallSettings.<ResumeAnywhereCacheRequest, AnywhereCache>newBuilder()
                .setMethodDescriptor(resumeAnywhereCacheMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          request.getName(), "bucket", RESUME_ANYWHERE_CACHE_0_PATH_TEMPLATE);
                      return builder.build();
                    })
                .setRequestMutator(
                    request -> {
                      ResumeAnywhereCacheRequest.Builder requestBuilder = request.toBuilder();
                      if (Strings.isNullOrEmpty(request.getRequestId())) {
                        requestBuilder.setRequestId(UUID.randomUUID().toString());
                      }
                      return requestBuilder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<GetAnywhereCacheRequest, AnywhereCache> getAnywhereCacheTransportSettings =
        GrpcCallSettings.<GetAnywhereCacheRequest, AnywhereCache>newBuilder()
            .setMethodDescriptor(getAnywhereCacheMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getName(), "bucket", GET_ANYWHERE_CACHE_0_PATH_TEMPLATE);
                  return builder.build();
                })
            .setRequestMutator(
                request -> {
                  GetAnywhereCacheRequest.Builder requestBuilder = request.toBuilder();
                  if (Strings.isNullOrEmpty(request.getRequestId())) {
                    requestBuilder.setRequestId(UUID.randomUUID().toString());
                  }
                  return requestBuilder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ListAnywhereCachesRequest, ListAnywhereCachesResponse>
        listAnywhereCachesTransportSettings =
            GrpcCallSettings.<ListAnywhereCachesRequest, ListAnywhereCachesResponse>newBuilder()
                .setMethodDescriptor(listAnywhereCachesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          request.getParent(), "bucket", LIST_ANYWHERE_CACHES_0_PATH_TEMPLATE);
                      return builder.build();
                    })
                .setRequestMutator(
                    request -> {
                      ListAnywhereCachesRequest.Builder requestBuilder = request.toBuilder();
                      if (Strings.isNullOrEmpty(request.getRequestId())) {
                        requestBuilder.setRequestId(UUID.randomUUID().toString());
                      }
                      return requestBuilder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetProjectIntelligenceConfigRequest, IntelligenceConfig>
        getProjectIntelligenceConfigTransportSettings =
            GrpcCallSettings.<GetProjectIntelligenceConfigRequest, IntelligenceConfig>newBuilder()
                .setMethodDescriptor(getProjectIntelligenceConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<UpdateProjectIntelligenceConfigRequest, IntelligenceConfig>
        updateProjectIntelligenceConfigTransportSettings =
            GrpcCallSettings
                .<UpdateProjectIntelligenceConfigRequest, IntelligenceConfig>newBuilder()
                .setMethodDescriptor(updateProjectIntelligenceConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "intelligence_config.name",
                          String.valueOf(request.getIntelligenceConfig().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetFolderIntelligenceConfigRequest, IntelligenceConfig>
        getFolderIntelligenceConfigTransportSettings =
            GrpcCallSettings.<GetFolderIntelligenceConfigRequest, IntelligenceConfig>newBuilder()
                .setMethodDescriptor(getFolderIntelligenceConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<UpdateFolderIntelligenceConfigRequest, IntelligenceConfig>
        updateFolderIntelligenceConfigTransportSettings =
            GrpcCallSettings.<UpdateFolderIntelligenceConfigRequest, IntelligenceConfig>newBuilder()
                .setMethodDescriptor(updateFolderIntelligenceConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "intelligence_config.name",
                          String.valueOf(request.getIntelligenceConfig().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetOrganizationIntelligenceConfigRequest, IntelligenceConfig>
        getOrganizationIntelligenceConfigTransportSettings =
            GrpcCallSettings
                .<GetOrganizationIntelligenceConfigRequest, IntelligenceConfig>newBuilder()
                .setMethodDescriptor(getOrganizationIntelligenceConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<UpdateOrganizationIntelligenceConfigRequest, IntelligenceConfig>
        updateOrganizationIntelligenceConfigTransportSettings =
            GrpcCallSettings
                .<UpdateOrganizationIntelligenceConfigRequest, IntelligenceConfig>newBuilder()
                .setMethodDescriptor(updateOrganizationIntelligenceConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "intelligence_config.name",
                          String.valueOf(request.getIntelligenceConfig().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        GrpcCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getResource(), "bucket", GET_IAM_POLICY_0_PATH_TEMPLATE);
                  builder.add(request.getResource(), "bucket", GET_IAM_POLICY_1_PATH_TEMPLATE);
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getResource())
            .build();
    GrpcCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        GrpcCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getResource(), "bucket", SET_IAM_POLICY_0_PATH_TEMPLATE);
                  builder.add(request.getResource(), "bucket", SET_IAM_POLICY_1_PATH_TEMPLATE);
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getResource())
            .build();
    GrpcCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            GrpcCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          request.getResource(), "bucket", TEST_IAM_PERMISSIONS_0_PATH_TEMPLATE);
                      builder.add(
                          request.getResource(), "bucket", TEST_IAM_PERMISSIONS_1_PATH_TEMPLATE);
                      builder.add(
                          request.getResource(), "bucket", TEST_IAM_PERMISSIONS_2_PATH_TEMPLATE);
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getResource())
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
            operationsStub);
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
            operationsStub);
    this.getStorageLayoutCallable =
        callableFactory.createUnaryCallable(
            getStorageLayoutTransportSettings, settings.getStorageLayoutSettings(), clientContext);
    this.createManagedFolderCallable =
        callableFactory.createUnaryCallable(
            createManagedFolderTransportSettings,
            settings.createManagedFolderSettings(),
            clientContext);
    this.deleteManagedFolderCallable =
        callableFactory.createUnaryCallable(
            deleteManagedFolderTransportSettings,
            settings.deleteManagedFolderSettings(),
            clientContext);
    this.getManagedFolderCallable =
        callableFactory.createUnaryCallable(
            getManagedFolderTransportSettings, settings.getManagedFolderSettings(), clientContext);
    this.listManagedFoldersCallable =
        callableFactory.createUnaryCallable(
            listManagedFoldersTransportSettings,
            settings.listManagedFoldersSettings(),
            clientContext);
    this.listManagedFoldersPagedCallable =
        callableFactory.createPagedCallable(
            listManagedFoldersTransportSettings,
            settings.listManagedFoldersSettings(),
            clientContext);
    this.createAnywhereCacheCallable =
        callableFactory.createUnaryCallable(
            createAnywhereCacheTransportSettings,
            settings.createAnywhereCacheSettings(),
            clientContext);
    this.createAnywhereCacheOperationCallable =
        callableFactory.createOperationCallable(
            createAnywhereCacheTransportSettings,
            settings.createAnywhereCacheOperationSettings(),
            clientContext,
            operationsStub);
    this.updateAnywhereCacheCallable =
        callableFactory.createUnaryCallable(
            updateAnywhereCacheTransportSettings,
            settings.updateAnywhereCacheSettings(),
            clientContext);
    this.updateAnywhereCacheOperationCallable =
        callableFactory.createOperationCallable(
            updateAnywhereCacheTransportSettings,
            settings.updateAnywhereCacheOperationSettings(),
            clientContext,
            operationsStub);
    this.disableAnywhereCacheCallable =
        callableFactory.createUnaryCallable(
            disableAnywhereCacheTransportSettings,
            settings.disableAnywhereCacheSettings(),
            clientContext);
    this.pauseAnywhereCacheCallable =
        callableFactory.createUnaryCallable(
            pauseAnywhereCacheTransportSettings,
            settings.pauseAnywhereCacheSettings(),
            clientContext);
    this.resumeAnywhereCacheCallable =
        callableFactory.createUnaryCallable(
            resumeAnywhereCacheTransportSettings,
            settings.resumeAnywhereCacheSettings(),
            clientContext);
    this.getAnywhereCacheCallable =
        callableFactory.createUnaryCallable(
            getAnywhereCacheTransportSettings, settings.getAnywhereCacheSettings(), clientContext);
    this.listAnywhereCachesCallable =
        callableFactory.createUnaryCallable(
            listAnywhereCachesTransportSettings,
            settings.listAnywhereCachesSettings(),
            clientContext);
    this.listAnywhereCachesPagedCallable =
        callableFactory.createPagedCallable(
            listAnywhereCachesTransportSettings,
            settings.listAnywhereCachesSettings(),
            clientContext);
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
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.testIamPermissionsCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsTransportSettings,
            settings.testIamPermissionsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
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
  public UnaryCallable<CreateManagedFolderRequest, ManagedFolder> createManagedFolderCallable() {
    return createManagedFolderCallable;
  }

  @Override
  public UnaryCallable<DeleteManagedFolderRequest, Empty> deleteManagedFolderCallable() {
    return deleteManagedFolderCallable;
  }

  @Override
  public UnaryCallable<GetManagedFolderRequest, ManagedFolder> getManagedFolderCallable() {
    return getManagedFolderCallable;
  }

  @Override
  public UnaryCallable<ListManagedFoldersRequest, ListManagedFoldersResponse>
      listManagedFoldersCallable() {
    return listManagedFoldersCallable;
  }

  @Override
  public UnaryCallable<ListManagedFoldersRequest, ListManagedFoldersPagedResponse>
      listManagedFoldersPagedCallable() {
    return listManagedFoldersPagedCallable;
  }

  @Override
  public UnaryCallable<CreateAnywhereCacheRequest, Operation> createAnywhereCacheCallable() {
    return createAnywhereCacheCallable;
  }

  @Override
  public OperationCallable<CreateAnywhereCacheRequest, AnywhereCache, CreateAnywhereCacheMetadata>
      createAnywhereCacheOperationCallable() {
    return createAnywhereCacheOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateAnywhereCacheRequest, Operation> updateAnywhereCacheCallable() {
    return updateAnywhereCacheCallable;
  }

  @Override
  public OperationCallable<UpdateAnywhereCacheRequest, AnywhereCache, UpdateAnywhereCacheMetadata>
      updateAnywhereCacheOperationCallable() {
    return updateAnywhereCacheOperationCallable;
  }

  @Override
  public UnaryCallable<DisableAnywhereCacheRequest, AnywhereCache> disableAnywhereCacheCallable() {
    return disableAnywhereCacheCallable;
  }

  @Override
  public UnaryCallable<PauseAnywhereCacheRequest, AnywhereCache> pauseAnywhereCacheCallable() {
    return pauseAnywhereCacheCallable;
  }

  @Override
  public UnaryCallable<ResumeAnywhereCacheRequest, AnywhereCache> resumeAnywhereCacheCallable() {
    return resumeAnywhereCacheCallable;
  }

  @Override
  public UnaryCallable<GetAnywhereCacheRequest, AnywhereCache> getAnywhereCacheCallable() {
    return getAnywhereCacheCallable;
  }

  @Override
  public UnaryCallable<ListAnywhereCachesRequest, ListAnywhereCachesResponse>
      listAnywhereCachesCallable() {
    return listAnywhereCachesCallable;
  }

  @Override
  public UnaryCallable<ListAnywhereCachesRequest, ListAnywhereCachesPagedResponse>
      listAnywhereCachesPagedCallable() {
    return listAnywhereCachesPagedCallable;
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
  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
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
