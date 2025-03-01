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

package com.google.cloud.dataform.v1beta1;

import com.google.api.core.BetaApi;
import com.google.cloud.dataform.v1beta1.DataformGrpc.DataformImplBase;
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
public class MockDataformImpl extends DataformImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockDataformImpl() {
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
      CreateRepositoryRequest request, StreamObserver<Repository> responseObserver) {
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
                  "Unrecognized response type %s for method CreateRepository, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Repository.class.getName(),
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
      DeleteRepositoryRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteRepository, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void commitRepositoryChanges(
      CommitRepositoryChangesRequest request,
      StreamObserver<CommitRepositoryChangesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CommitRepositoryChangesResponse) {
      requests.add(request);
      responseObserver.onNext(((CommitRepositoryChangesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CommitRepositoryChanges, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CommitRepositoryChangesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void readRepositoryFile(
      ReadRepositoryFileRequest request,
      StreamObserver<ReadRepositoryFileResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ReadRepositoryFileResponse) {
      requests.add(request);
      responseObserver.onNext(((ReadRepositoryFileResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ReadRepositoryFile, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ReadRepositoryFileResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void queryRepositoryDirectoryContents(
      QueryRepositoryDirectoryContentsRequest request,
      StreamObserver<QueryRepositoryDirectoryContentsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof QueryRepositoryDirectoryContentsResponse) {
      requests.add(request);
      responseObserver.onNext(((QueryRepositoryDirectoryContentsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method QueryRepositoryDirectoryContents, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  QueryRepositoryDirectoryContentsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void fetchRepositoryHistory(
      FetchRepositoryHistoryRequest request,
      StreamObserver<FetchRepositoryHistoryResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FetchRepositoryHistoryResponse) {
      requests.add(request);
      responseObserver.onNext(((FetchRepositoryHistoryResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method FetchRepositoryHistory, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  FetchRepositoryHistoryResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void computeRepositoryAccessTokenStatus(
      ComputeRepositoryAccessTokenStatusRequest request,
      StreamObserver<ComputeRepositoryAccessTokenStatusResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ComputeRepositoryAccessTokenStatusResponse) {
      requests.add(request);
      responseObserver.onNext(((ComputeRepositoryAccessTokenStatusResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ComputeRepositoryAccessTokenStatus, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ComputeRepositoryAccessTokenStatusResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void fetchRemoteBranches(
      FetchRemoteBranchesRequest request,
      StreamObserver<FetchRemoteBranchesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FetchRemoteBranchesResponse) {
      requests.add(request);
      responseObserver.onNext(((FetchRemoteBranchesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method FetchRemoteBranches, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  FetchRemoteBranchesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listWorkspaces(
      ListWorkspacesRequest request, StreamObserver<ListWorkspacesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListWorkspacesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListWorkspacesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListWorkspaces, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListWorkspacesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getWorkspace(
      GetWorkspaceRequest request, StreamObserver<Workspace> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Workspace) {
      requests.add(request);
      responseObserver.onNext(((Workspace) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetWorkspace, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Workspace.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createWorkspace(
      CreateWorkspaceRequest request, StreamObserver<Workspace> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Workspace) {
      requests.add(request);
      responseObserver.onNext(((Workspace) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateWorkspace, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Workspace.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteWorkspace(
      DeleteWorkspaceRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteWorkspace, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void installNpmPackages(
      InstallNpmPackagesRequest request,
      StreamObserver<InstallNpmPackagesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof InstallNpmPackagesResponse) {
      requests.add(request);
      responseObserver.onNext(((InstallNpmPackagesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method InstallNpmPackages, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  InstallNpmPackagesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void pullGitCommits(
      PullGitCommitsRequest request, StreamObserver<PullGitCommitsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof PullGitCommitsResponse) {
      requests.add(request);
      responseObserver.onNext(((PullGitCommitsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method PullGitCommits, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  PullGitCommitsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void pushGitCommits(
      PushGitCommitsRequest request, StreamObserver<PushGitCommitsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof PushGitCommitsResponse) {
      requests.add(request);
      responseObserver.onNext(((PushGitCommitsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method PushGitCommits, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  PushGitCommitsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void fetchFileGitStatuses(
      FetchFileGitStatusesRequest request,
      StreamObserver<FetchFileGitStatusesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FetchFileGitStatusesResponse) {
      requests.add(request);
      responseObserver.onNext(((FetchFileGitStatusesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method FetchFileGitStatuses, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  FetchFileGitStatusesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void fetchGitAheadBehind(
      FetchGitAheadBehindRequest request,
      StreamObserver<FetchGitAheadBehindResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FetchGitAheadBehindResponse) {
      requests.add(request);
      responseObserver.onNext(((FetchGitAheadBehindResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method FetchGitAheadBehind, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  FetchGitAheadBehindResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void commitWorkspaceChanges(
      CommitWorkspaceChangesRequest request,
      StreamObserver<CommitWorkspaceChangesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CommitWorkspaceChangesResponse) {
      requests.add(request);
      responseObserver.onNext(((CommitWorkspaceChangesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CommitWorkspaceChanges, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CommitWorkspaceChangesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void resetWorkspaceChanges(
      ResetWorkspaceChangesRequest request,
      StreamObserver<ResetWorkspaceChangesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ResetWorkspaceChangesResponse) {
      requests.add(request);
      responseObserver.onNext(((ResetWorkspaceChangesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ResetWorkspaceChanges, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ResetWorkspaceChangesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void fetchFileDiff(
      FetchFileDiffRequest request, StreamObserver<FetchFileDiffResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FetchFileDiffResponse) {
      requests.add(request);
      responseObserver.onNext(((FetchFileDiffResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method FetchFileDiff, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  FetchFileDiffResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void queryDirectoryContents(
      QueryDirectoryContentsRequest request,
      StreamObserver<QueryDirectoryContentsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof QueryDirectoryContentsResponse) {
      requests.add(request);
      responseObserver.onNext(((QueryDirectoryContentsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method QueryDirectoryContents, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  QueryDirectoryContentsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void searchFiles(
      SearchFilesRequest request, StreamObserver<SearchFilesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SearchFilesResponse) {
      requests.add(request);
      responseObserver.onNext(((SearchFilesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SearchFiles, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SearchFilesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void makeDirectory(
      MakeDirectoryRequest request, StreamObserver<MakeDirectoryResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof MakeDirectoryResponse) {
      requests.add(request);
      responseObserver.onNext(((MakeDirectoryResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method MakeDirectory, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  MakeDirectoryResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void removeDirectory(
      RemoveDirectoryRequest request, StreamObserver<RemoveDirectoryResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RemoveDirectoryResponse) {
      requests.add(request);
      responseObserver.onNext(((RemoveDirectoryResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RemoveDirectory, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RemoveDirectoryResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void moveDirectory(
      MoveDirectoryRequest request, StreamObserver<MoveDirectoryResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof MoveDirectoryResponse) {
      requests.add(request);
      responseObserver.onNext(((MoveDirectoryResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method MoveDirectory, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  MoveDirectoryResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void readFile(ReadFileRequest request, StreamObserver<ReadFileResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ReadFileResponse) {
      requests.add(request);
      responseObserver.onNext(((ReadFileResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ReadFile, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ReadFileResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void removeFile(
      RemoveFileRequest request, StreamObserver<RemoveFileResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RemoveFileResponse) {
      requests.add(request);
      responseObserver.onNext(((RemoveFileResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RemoveFile, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RemoveFileResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void moveFile(MoveFileRequest request, StreamObserver<MoveFileResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof MoveFileResponse) {
      requests.add(request);
      responseObserver.onNext(((MoveFileResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method MoveFile, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  MoveFileResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void writeFile(
      WriteFileRequest request, StreamObserver<WriteFileResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof WriteFileResponse) {
      requests.add(request);
      responseObserver.onNext(((WriteFileResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method WriteFile, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  WriteFileResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listReleaseConfigs(
      ListReleaseConfigsRequest request,
      StreamObserver<ListReleaseConfigsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListReleaseConfigsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListReleaseConfigsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListReleaseConfigs, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListReleaseConfigsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getReleaseConfig(
      GetReleaseConfigRequest request, StreamObserver<ReleaseConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ReleaseConfig) {
      requests.add(request);
      responseObserver.onNext(((ReleaseConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetReleaseConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ReleaseConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createReleaseConfig(
      CreateReleaseConfigRequest request, StreamObserver<ReleaseConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ReleaseConfig) {
      requests.add(request);
      responseObserver.onNext(((ReleaseConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateReleaseConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ReleaseConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateReleaseConfig(
      UpdateReleaseConfigRequest request, StreamObserver<ReleaseConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ReleaseConfig) {
      requests.add(request);
      responseObserver.onNext(((ReleaseConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateReleaseConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ReleaseConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteReleaseConfig(
      DeleteReleaseConfigRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteReleaseConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listCompilationResults(
      ListCompilationResultsRequest request,
      StreamObserver<ListCompilationResultsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListCompilationResultsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListCompilationResultsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListCompilationResults, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListCompilationResultsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getCompilationResult(
      GetCompilationResultRequest request, StreamObserver<CompilationResult> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CompilationResult) {
      requests.add(request);
      responseObserver.onNext(((CompilationResult) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetCompilationResult, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CompilationResult.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createCompilationResult(
      CreateCompilationResultRequest request, StreamObserver<CompilationResult> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CompilationResult) {
      requests.add(request);
      responseObserver.onNext(((CompilationResult) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateCompilationResult, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CompilationResult.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void queryCompilationResultActions(
      QueryCompilationResultActionsRequest request,
      StreamObserver<QueryCompilationResultActionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof QueryCompilationResultActionsResponse) {
      requests.add(request);
      responseObserver.onNext(((QueryCompilationResultActionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method QueryCompilationResultActions, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  QueryCompilationResultActionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listWorkflowConfigs(
      ListWorkflowConfigsRequest request,
      StreamObserver<ListWorkflowConfigsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListWorkflowConfigsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListWorkflowConfigsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListWorkflowConfigs, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListWorkflowConfigsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getWorkflowConfig(
      GetWorkflowConfigRequest request, StreamObserver<WorkflowConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof WorkflowConfig) {
      requests.add(request);
      responseObserver.onNext(((WorkflowConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetWorkflowConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  WorkflowConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createWorkflowConfig(
      CreateWorkflowConfigRequest request, StreamObserver<WorkflowConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof WorkflowConfig) {
      requests.add(request);
      responseObserver.onNext(((WorkflowConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateWorkflowConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  WorkflowConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateWorkflowConfig(
      UpdateWorkflowConfigRequest request, StreamObserver<WorkflowConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof WorkflowConfig) {
      requests.add(request);
      responseObserver.onNext(((WorkflowConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateWorkflowConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  WorkflowConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteWorkflowConfig(
      DeleteWorkflowConfigRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteWorkflowConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listWorkflowInvocations(
      ListWorkflowInvocationsRequest request,
      StreamObserver<ListWorkflowInvocationsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListWorkflowInvocationsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListWorkflowInvocationsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListWorkflowInvocations, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListWorkflowInvocationsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getWorkflowInvocation(
      GetWorkflowInvocationRequest request, StreamObserver<WorkflowInvocation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof WorkflowInvocation) {
      requests.add(request);
      responseObserver.onNext(((WorkflowInvocation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetWorkflowInvocation, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  WorkflowInvocation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createWorkflowInvocation(
      CreateWorkflowInvocationRequest request,
      StreamObserver<WorkflowInvocation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof WorkflowInvocation) {
      requests.add(request);
      responseObserver.onNext(((WorkflowInvocation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateWorkflowInvocation, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  WorkflowInvocation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteWorkflowInvocation(
      DeleteWorkflowInvocationRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteWorkflowInvocation, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void cancelWorkflowInvocation(
      CancelWorkflowInvocationRequest request,
      StreamObserver<CancelWorkflowInvocationResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CancelWorkflowInvocationResponse) {
      requests.add(request);
      responseObserver.onNext(((CancelWorkflowInvocationResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CancelWorkflowInvocation, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CancelWorkflowInvocationResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void queryWorkflowInvocationActions(
      QueryWorkflowInvocationActionsRequest request,
      StreamObserver<QueryWorkflowInvocationActionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof QueryWorkflowInvocationActionsResponse) {
      requests.add(request);
      responseObserver.onNext(((QueryWorkflowInvocationActionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method QueryWorkflowInvocationActions, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  QueryWorkflowInvocationActionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getConfig(GetConfigRequest request, StreamObserver<Config> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Config) {
      requests.add(request);
      responseObserver.onNext(((Config) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Config.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateConfig(UpdateConfigRequest request, StreamObserver<Config> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Config) {
      requests.add(request);
      responseObserver.onNext(((Config) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Config.class.getName(),
                  Exception.class.getName())));
    }
  }
}
