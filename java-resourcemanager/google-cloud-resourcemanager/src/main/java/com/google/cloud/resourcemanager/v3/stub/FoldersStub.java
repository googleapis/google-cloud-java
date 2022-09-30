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

package com.google.cloud.resourcemanager.v3.stub;

import static com.google.cloud.resourcemanager.v3.FoldersClient.ListFoldersPagedResponse;
import static com.google.cloud.resourcemanager.v3.FoldersClient.SearchFoldersPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.resourcemanager.v3.CreateFolderMetadata;
import com.google.cloud.resourcemanager.v3.CreateFolderRequest;
import com.google.cloud.resourcemanager.v3.DeleteFolderMetadata;
import com.google.cloud.resourcemanager.v3.DeleteFolderRequest;
import com.google.cloud.resourcemanager.v3.Folder;
import com.google.cloud.resourcemanager.v3.GetFolderRequest;
import com.google.cloud.resourcemanager.v3.ListFoldersRequest;
import com.google.cloud.resourcemanager.v3.ListFoldersResponse;
import com.google.cloud.resourcemanager.v3.MoveFolderMetadata;
import com.google.cloud.resourcemanager.v3.MoveFolderRequest;
import com.google.cloud.resourcemanager.v3.SearchFoldersRequest;
import com.google.cloud.resourcemanager.v3.SearchFoldersResponse;
import com.google.cloud.resourcemanager.v3.UndeleteFolderMetadata;
import com.google.cloud.resourcemanager.v3.UndeleteFolderRequest;
import com.google.cloud.resourcemanager.v3.UpdateFolderMetadata;
import com.google.cloud.resourcemanager.v3.UpdateFolderRequest;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Folders service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class FoldersStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
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

  public UnaryCallable<SearchFoldersRequest, SearchFoldersPagedResponse>
      searchFoldersPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: searchFoldersPagedCallable()");
  }

  public UnaryCallable<SearchFoldersRequest, SearchFoldersResponse> searchFoldersCallable() {
    throw new UnsupportedOperationException("Not implemented: searchFoldersCallable()");
  }

  public OperationCallable<CreateFolderRequest, Folder, CreateFolderMetadata>
      createFolderOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createFolderOperationCallable()");
  }

  public UnaryCallable<CreateFolderRequest, Operation> createFolderCallable() {
    throw new UnsupportedOperationException("Not implemented: createFolderCallable()");
  }

  public OperationCallable<UpdateFolderRequest, Folder, UpdateFolderMetadata>
      updateFolderOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateFolderOperationCallable()");
  }

  public UnaryCallable<UpdateFolderRequest, Operation> updateFolderCallable() {
    throw new UnsupportedOperationException("Not implemented: updateFolderCallable()");
  }

  public OperationCallable<MoveFolderRequest, Folder, MoveFolderMetadata>
      moveFolderOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: moveFolderOperationCallable()");
  }

  public UnaryCallable<MoveFolderRequest, Operation> moveFolderCallable() {
    throw new UnsupportedOperationException("Not implemented: moveFolderCallable()");
  }

  public OperationCallable<DeleteFolderRequest, Folder, DeleteFolderMetadata>
      deleteFolderOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteFolderOperationCallable()");
  }

  public UnaryCallable<DeleteFolderRequest, Operation> deleteFolderCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteFolderCallable()");
  }

  public OperationCallable<UndeleteFolderRequest, Folder, UndeleteFolderMetadata>
      undeleteFolderOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: undeleteFolderOperationCallable()");
  }

  public UnaryCallable<UndeleteFolderRequest, Operation> undeleteFolderCallable() {
    throw new UnsupportedOperationException("Not implemented: undeleteFolderCallable()");
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
