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
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
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
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the StorageControl service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class StorageControlStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<CreateFolderRequest, Folder> createFolderCallable() {
    throw new UnsupportedOperationException("Not implemented: createFolderCallable()");
  }

  public UnaryCallable<DeleteFolderRequest, Empty> deleteFolderCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteFolderCallable()");
  }

  public UnaryCallable<GetFolderRequest, Folder> getFolderCallable() {
    throw new UnsupportedOperationException("Not implemented: getFolderCallable()");
  }

  public UnaryCallable<ListFoldersRequest, ListFoldersPagedResponse> listFoldersPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listFoldersPagedCallable()");
  }

  public UnaryCallable<ListFoldersRequest, ListFoldersResponse> listFoldersCallable() {
    throw new UnsupportedOperationException("Not implemented: listFoldersCallable()");
  }

  public OperationCallable<RenameFolderRequest, Folder, RenameFolderMetadata>
      renameFolderOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: renameFolderOperationCallable()");
  }

  public UnaryCallable<RenameFolderRequest, Operation> renameFolderCallable() {
    throw new UnsupportedOperationException("Not implemented: renameFolderCallable()");
  }

  public OperationCallable<DeleteFolderRecursiveRequest, Empty, DeleteFolderRecursiveMetadata>
      deleteFolderRecursiveOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteFolderRecursiveOperationCallable()");
  }

  public UnaryCallable<DeleteFolderRecursiveRequest, Operation> deleteFolderRecursiveCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteFolderRecursiveCallable()");
  }

  public UnaryCallable<GetStorageLayoutRequest, StorageLayout> getStorageLayoutCallable() {
    throw new UnsupportedOperationException("Not implemented: getStorageLayoutCallable()");
  }

  public UnaryCallable<CreateManagedFolderRequest, ManagedFolder> createManagedFolderCallable() {
    throw new UnsupportedOperationException("Not implemented: createManagedFolderCallable()");
  }

  public UnaryCallable<DeleteManagedFolderRequest, Empty> deleteManagedFolderCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteManagedFolderCallable()");
  }

  public UnaryCallable<GetManagedFolderRequest, ManagedFolder> getManagedFolderCallable() {
    throw new UnsupportedOperationException("Not implemented: getManagedFolderCallable()");
  }

  public UnaryCallable<ListManagedFoldersRequest, ListManagedFoldersPagedResponse>
      listManagedFoldersPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listManagedFoldersPagedCallable()");
  }

  public UnaryCallable<ListManagedFoldersRequest, ListManagedFoldersResponse>
      listManagedFoldersCallable() {
    throw new UnsupportedOperationException("Not implemented: listManagedFoldersCallable()");
  }

  public OperationCallable<CreateAnywhereCacheRequest, AnywhereCache, CreateAnywhereCacheMetadata>
      createAnywhereCacheOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createAnywhereCacheOperationCallable()");
  }

  public UnaryCallable<CreateAnywhereCacheRequest, Operation> createAnywhereCacheCallable() {
    throw new UnsupportedOperationException("Not implemented: createAnywhereCacheCallable()");
  }

  public OperationCallable<UpdateAnywhereCacheRequest, AnywhereCache, UpdateAnywhereCacheMetadata>
      updateAnywhereCacheOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateAnywhereCacheOperationCallable()");
  }

  public UnaryCallable<UpdateAnywhereCacheRequest, Operation> updateAnywhereCacheCallable() {
    throw new UnsupportedOperationException("Not implemented: updateAnywhereCacheCallable()");
  }

  public UnaryCallable<DisableAnywhereCacheRequest, AnywhereCache> disableAnywhereCacheCallable() {
    throw new UnsupportedOperationException("Not implemented: disableAnywhereCacheCallable()");
  }

  public UnaryCallable<PauseAnywhereCacheRequest, AnywhereCache> pauseAnywhereCacheCallable() {
    throw new UnsupportedOperationException("Not implemented: pauseAnywhereCacheCallable()");
  }

  public UnaryCallable<ResumeAnywhereCacheRequest, AnywhereCache> resumeAnywhereCacheCallable() {
    throw new UnsupportedOperationException("Not implemented: resumeAnywhereCacheCallable()");
  }

  public UnaryCallable<GetAnywhereCacheRequest, AnywhereCache> getAnywhereCacheCallable() {
    throw new UnsupportedOperationException("Not implemented: getAnywhereCacheCallable()");
  }

  public UnaryCallable<ListAnywhereCachesRequest, ListAnywhereCachesPagedResponse>
      listAnywhereCachesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAnywhereCachesPagedCallable()");
  }

  public UnaryCallable<ListAnywhereCachesRequest, ListAnywhereCachesResponse>
      listAnywhereCachesCallable() {
    throw new UnsupportedOperationException("Not implemented: listAnywhereCachesCallable()");
  }

  public UnaryCallable<GetProjectIntelligenceConfigRequest, IntelligenceConfig>
      getProjectIntelligenceConfigCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getProjectIntelligenceConfigCallable()");
  }

  public UnaryCallable<UpdateProjectIntelligenceConfigRequest, IntelligenceConfig>
      updateProjectIntelligenceConfigCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateProjectIntelligenceConfigCallable()");
  }

  public UnaryCallable<GetFolderIntelligenceConfigRequest, IntelligenceConfig>
      getFolderIntelligenceConfigCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getFolderIntelligenceConfigCallable()");
  }

  public UnaryCallable<UpdateFolderIntelligenceConfigRequest, IntelligenceConfig>
      updateFolderIntelligenceConfigCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateFolderIntelligenceConfigCallable()");
  }

  public UnaryCallable<GetOrganizationIntelligenceConfigRequest, IntelligenceConfig>
      getOrganizationIntelligenceConfigCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getOrganizationIntelligenceConfigCallable()");
  }

  public UnaryCallable<UpdateOrganizationIntelligenceConfigRequest, IntelligenceConfig>
      updateOrganizationIntelligenceConfigCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateOrganizationIntelligenceConfigCallable()");
  }

  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyCallable()");
  }

  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyCallable()");
  }

  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsCallable()");
  }

  @Override
  public abstract void close();
}
