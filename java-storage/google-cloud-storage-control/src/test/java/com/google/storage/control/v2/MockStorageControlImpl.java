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

package com.google.storage.control.v2;

import com.google.api.core.BetaApi;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import com.google.storage.control.v2.StorageControlGrpc.StorageControlImplBase;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockStorageControlImpl extends StorageControlImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockStorageControlImpl() {
    requests = new ArrayList<>();
    responses = new LinkedList<>();
  }

  public List<AbstractMessage> getRequests() {
    return requests;
  }

  public void addResponse(AbstractMessage response) {
    responses.add(response);
  }

  public void setResponses(List<AbstractMessage> responses) {
    this.responses = new LinkedList<Object>(responses);
  }

  public void addException(Exception exception) {
    responses.add(exception);
  }

  public void reset() {
    requests = new ArrayList<>();
    responses = new LinkedList<>();
  }

  @Override
  public void createFolder(CreateFolderRequest request, StreamObserver<Folder> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Folder) {
      requests.add(request);
      responseObserver.onNext(((Folder) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateFolder, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Folder.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteFolder(DeleteFolderRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext(((Empty) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteFolder, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getFolder(GetFolderRequest request, StreamObserver<Folder> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Folder) {
      requests.add(request);
      responseObserver.onNext(((Folder) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetFolder, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Folder.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listFolders(
      ListFoldersRequest request, StreamObserver<ListFoldersResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListFoldersResponse) {
      requests.add(request);
      responseObserver.onNext(((ListFoldersResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListFolders, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListFoldersResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void renameFolder(
      RenameFolderRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RenameFolder, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteFolderRecursive(
      DeleteFolderRecursiveRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteFolderRecursive, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getStorageLayout(
      GetStorageLayoutRequest request, StreamObserver<StorageLayout> responseObserver) {
    Object response = responses.poll();
    if (response instanceof StorageLayout) {
      requests.add(request);
      responseObserver.onNext(((StorageLayout) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetStorageLayout, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  StorageLayout.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createManagedFolder(
      CreateManagedFolderRequest request, StreamObserver<ManagedFolder> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ManagedFolder) {
      requests.add(request);
      responseObserver.onNext(((ManagedFolder) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateManagedFolder, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ManagedFolder.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteManagedFolder(
      DeleteManagedFolderRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext(((Empty) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteManagedFolder, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getManagedFolder(
      GetManagedFolderRequest request, StreamObserver<ManagedFolder> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ManagedFolder) {
      requests.add(request);
      responseObserver.onNext(((ManagedFolder) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetManagedFolder, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ManagedFolder.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listManagedFolders(
      ListManagedFoldersRequest request,
      StreamObserver<ListManagedFoldersResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListManagedFoldersResponse) {
      requests.add(request);
      responseObserver.onNext(((ListManagedFoldersResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListManagedFolders, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListManagedFoldersResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createAnywhereCache(
      CreateAnywhereCacheRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateAnywhereCache, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateAnywhereCache(
      UpdateAnywhereCacheRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateAnywhereCache, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void disableAnywhereCache(
      DisableAnywhereCacheRequest request, StreamObserver<AnywhereCache> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AnywhereCache) {
      requests.add(request);
      responseObserver.onNext(((AnywhereCache) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DisableAnywhereCache, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  AnywhereCache.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void pauseAnywhereCache(
      PauseAnywhereCacheRequest request, StreamObserver<AnywhereCache> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AnywhereCache) {
      requests.add(request);
      responseObserver.onNext(((AnywhereCache) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method PauseAnywhereCache, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AnywhereCache.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void resumeAnywhereCache(
      ResumeAnywhereCacheRequest request, StreamObserver<AnywhereCache> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AnywhereCache) {
      requests.add(request);
      responseObserver.onNext(((AnywhereCache) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ResumeAnywhereCache, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AnywhereCache.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getAnywhereCache(
      GetAnywhereCacheRequest request, StreamObserver<AnywhereCache> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AnywhereCache) {
      requests.add(request);
      responseObserver.onNext(((AnywhereCache) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetAnywhereCache, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AnywhereCache.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listAnywhereCaches(
      ListAnywhereCachesRequest request,
      StreamObserver<ListAnywhereCachesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListAnywhereCachesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListAnywhereCachesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListAnywhereCaches, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListAnywhereCachesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getProjectIntelligenceConfig(
      GetProjectIntelligenceConfigRequest request,
      StreamObserver<IntelligenceConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof IntelligenceConfig) {
      requests.add(request);
      responseObserver.onNext(((IntelligenceConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetProjectIntelligenceConfig, expected"
                      + " %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  IntelligenceConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateProjectIntelligenceConfig(
      UpdateProjectIntelligenceConfigRequest request,
      StreamObserver<IntelligenceConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof IntelligenceConfig) {
      requests.add(request);
      responseObserver.onNext(((IntelligenceConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateProjectIntelligenceConfig,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  IntelligenceConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getFolderIntelligenceConfig(
      GetFolderIntelligenceConfigRequest request,
      StreamObserver<IntelligenceConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof IntelligenceConfig) {
      requests.add(request);
      responseObserver.onNext(((IntelligenceConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetFolderIntelligenceConfig, expected"
                      + " %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  IntelligenceConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateFolderIntelligenceConfig(
      UpdateFolderIntelligenceConfigRequest request,
      StreamObserver<IntelligenceConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof IntelligenceConfig) {
      requests.add(request);
      responseObserver.onNext(((IntelligenceConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateFolderIntelligenceConfig,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  IntelligenceConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getOrganizationIntelligenceConfig(
      GetOrganizationIntelligenceConfigRequest request,
      StreamObserver<IntelligenceConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof IntelligenceConfig) {
      requests.add(request);
      responseObserver.onNext(((IntelligenceConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetOrganizationIntelligenceConfig,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  IntelligenceConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateOrganizationIntelligenceConfig(
      UpdateOrganizationIntelligenceConfigRequest request,
      StreamObserver<IntelligenceConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof IntelligenceConfig) {
      requests.add(request);
      responseObserver.onNext(((IntelligenceConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateOrganizationIntelligenceConfig,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  IntelligenceConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getIamPolicy(GetIamPolicyRequest request, StreamObserver<Policy> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Policy) {
      requests.add(request);
      responseObserver.onNext(((Policy) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetIamPolicy, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Policy.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void setIamPolicy(SetIamPolicyRequest request, StreamObserver<Policy> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Policy) {
      requests.add(request);
      responseObserver.onNext(((Policy) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SetIamPolicy, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Policy.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void testIamPermissions(
      TestIamPermissionsRequest request,
      StreamObserver<TestIamPermissionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof TestIamPermissionsResponse) {
      requests.add(request);
      responseObserver.onNext(((TestIamPermissionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method TestIamPermissions, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  TestIamPermissionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
