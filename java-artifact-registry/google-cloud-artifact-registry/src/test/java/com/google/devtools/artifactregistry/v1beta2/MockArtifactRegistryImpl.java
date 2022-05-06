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

package com.google.devtools.artifactregistry.v1beta2;

import com.google.api.core.BetaApi;
import com.google.devtools.artifactregistry.v1beta2.ArtifactRegistryGrpc.ArtifactRegistryImplBase;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockArtifactRegistryImpl extends ArtifactRegistryImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockArtifactRegistryImpl() {
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
  public void importAptArtifacts(
      ImportAptArtifactsRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method ImportAptArtifacts, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void importYumArtifacts(
      ImportYumArtifactsRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method ImportYumArtifacts, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listRepositories(
      ListRepositoriesRequest request, StreamObserver<ListRepositoriesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListRepositoriesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListRepositoriesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListRepositories, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListRepositoriesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getRepository(
      GetRepositoryRequest request, StreamObserver<Repository> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Repository) {
      requests.add(request);
      responseObserver.onNext(((Repository) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetRepository, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Repository.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createRepository(
      CreateRepositoryRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateRepository, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateRepository(
      UpdateRepositoryRequest request, StreamObserver<Repository> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Repository) {
      requests.add(request);
      responseObserver.onNext(((Repository) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateRepository, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Repository.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteRepository(
      DeleteRepositoryRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteRepository, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listPackages(
      ListPackagesRequest request, StreamObserver<ListPackagesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListPackagesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListPackagesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListPackages, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListPackagesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getPackage(GetPackageRequest request, StreamObserver<Package> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Package) {
      requests.add(request);
      responseObserver.onNext(((Package) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetPackage, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Package.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deletePackage(
      DeletePackageRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeletePackage, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listVersions(
      ListVersionsRequest request, StreamObserver<ListVersionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListVersionsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListVersionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListVersions, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListVersionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getVersion(GetVersionRequest request, StreamObserver<Version> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Version) {
      requests.add(request);
      responseObserver.onNext(((Version) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetVersion, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Version.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteVersion(
      DeleteVersionRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteVersion, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listFiles(
      ListFilesRequest request, StreamObserver<ListFilesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListFilesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListFilesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListFiles, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListFilesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getFile(GetFileRequest request, StreamObserver<File> responseObserver) {
    Object response = responses.poll();
    if (response instanceof File) {
      requests.add(request);
      responseObserver.onNext(((File) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetFile, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  File.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listTags(ListTagsRequest request, StreamObserver<ListTagsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListTagsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListTagsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListTags, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListTagsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getTag(GetTagRequest request, StreamObserver<Tag> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Tag) {
      requests.add(request);
      responseObserver.onNext(((Tag) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetTag, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Tag.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createTag(CreateTagRequest request, StreamObserver<Tag> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Tag) {
      requests.add(request);
      responseObserver.onNext(((Tag) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateTag, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Tag.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateTag(UpdateTagRequest request, StreamObserver<Tag> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Tag) {
      requests.add(request);
      responseObserver.onNext(((Tag) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateTag, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Tag.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteTag(DeleteTagRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteTag, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
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

  @Override
  public void getProjectSettings(
      GetProjectSettingsRequest request, StreamObserver<ProjectSettings> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ProjectSettings) {
      requests.add(request);
      responseObserver.onNext(((ProjectSettings) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetProjectSettings, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ProjectSettings.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateProjectSettings(
      UpdateProjectSettingsRequest request, StreamObserver<ProjectSettings> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ProjectSettings) {
      requests.add(request);
      responseObserver.onNext(((ProjectSettings) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateProjectSettings, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ProjectSettings.class.getName(),
                  Exception.class.getName())));
    }
  }
}
