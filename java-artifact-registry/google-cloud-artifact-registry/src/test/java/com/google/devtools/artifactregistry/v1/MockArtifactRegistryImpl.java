/*
 * Copyright 2025 Google LLC
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

package com.google.devtools.artifactregistry.v1;

import com.google.api.core.BetaApi;
import com.google.devtools.artifactregistry.v1.ArtifactRegistryGrpc.ArtifactRegistryImplBase;
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
  public void listDockerImages(
      ListDockerImagesRequest request, StreamObserver<ListDockerImagesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListDockerImagesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListDockerImagesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListDockerImages, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListDockerImagesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getDockerImage(
      GetDockerImageRequest request, StreamObserver<DockerImage> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DockerImage) {
      requests.add(request);
      responseObserver.onNext(((DockerImage) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetDockerImage, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DockerImage.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listMavenArtifacts(
      ListMavenArtifactsRequest request,
      StreamObserver<ListMavenArtifactsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListMavenArtifactsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListMavenArtifactsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListMavenArtifacts, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListMavenArtifactsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getMavenArtifact(
      GetMavenArtifactRequest request, StreamObserver<MavenArtifact> responseObserver) {
    Object response = responses.poll();
    if (response instanceof MavenArtifact) {
      requests.add(request);
      responseObserver.onNext(((MavenArtifact) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetMavenArtifact, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  MavenArtifact.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listNpmPackages(
      ListNpmPackagesRequest request, StreamObserver<ListNpmPackagesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListNpmPackagesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListNpmPackagesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListNpmPackages, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListNpmPackagesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getNpmPackage(
      GetNpmPackageRequest request, StreamObserver<NpmPackage> responseObserver) {
    Object response = responses.poll();
    if (response instanceof NpmPackage) {
      requests.add(request);
      responseObserver.onNext(((NpmPackage) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetNpmPackage, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  NpmPackage.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listPythonPackages(
      ListPythonPackagesRequest request,
      StreamObserver<ListPythonPackagesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListPythonPackagesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListPythonPackagesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListPythonPackages, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListPythonPackagesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getPythonPackage(
      GetPythonPackageRequest request, StreamObserver<PythonPackage> responseObserver) {
    Object response = responses.poll();
    if (response instanceof PythonPackage) {
      requests.add(request);
      responseObserver.onNext(((PythonPackage) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetPythonPackage, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  PythonPackage.class.getName(),
                  Exception.class.getName())));
    }
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
  public void batchDeleteVersions(
      BatchDeleteVersionsRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method BatchDeleteVersions, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateVersion(
      UpdateVersionRequest request, StreamObserver<Version> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateVersion, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Version.class.getName(),
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
  public void deleteFile(DeleteFileRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteFile, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateFile(UpdateFileRequest request, StreamObserver<File> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateFile, expected %s or %s",
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
  public void createRule(CreateRuleRequest request, StreamObserver<Rule> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Rule) {
      requests.add(request);
      responseObserver.onNext(((Rule) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateRule, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Rule.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listRules(
      ListRulesRequest request, StreamObserver<ListRulesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListRulesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListRulesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListRules, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListRulesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getRule(GetRuleRequest request, StreamObserver<Rule> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Rule) {
      requests.add(request);
      responseObserver.onNext(((Rule) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetRule, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Rule.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateRule(UpdateRuleRequest request, StreamObserver<Rule> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Rule) {
      requests.add(request);
      responseObserver.onNext(((Rule) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateRule, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Rule.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteRule(DeleteRuleRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteRule, expected %s or %s",
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

  @Override
  public void getVPCSCConfig(
      GetVPCSCConfigRequest request, StreamObserver<VPCSCConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof VPCSCConfig) {
      requests.add(request);
      responseObserver.onNext(((VPCSCConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetVPCSCConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  VPCSCConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateVPCSCConfig(
      UpdateVPCSCConfigRequest request, StreamObserver<VPCSCConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof VPCSCConfig) {
      requests.add(request);
      responseObserver.onNext(((VPCSCConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateVPCSCConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  VPCSCConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updatePackage(
      UpdatePackageRequest request, StreamObserver<Package> responseObserver) {
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
                  "Unrecognized response type %s for method UpdatePackage, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Package.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listAttachments(
      ListAttachmentsRequest request, StreamObserver<ListAttachmentsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListAttachmentsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListAttachmentsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListAttachments, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListAttachmentsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getAttachment(
      GetAttachmentRequest request, StreamObserver<Attachment> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Attachment) {
      requests.add(request);
      responseObserver.onNext(((Attachment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetAttachment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Attachment.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createAttachment(
      CreateAttachmentRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateAttachment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteAttachment(
      DeleteAttachmentRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteAttachment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }
}
