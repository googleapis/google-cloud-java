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
      PullGitCommitsRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method PullGitCommits, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void pushGitCommits(
      PushGitCommitsRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method PushGitCommits, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
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
      CommitWorkspaceChangesRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method CommitWorkspaceChanges, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void resetWorkspaceChanges(
      ResetWorkspaceChangesRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method ResetWorkspaceChanges, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
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
      RemoveDirectoryRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method RemoveDirectory, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
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
  public void removeFile(RemoveFileRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method RemoveFile, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
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
      CancelWorkflowInvocationRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method CancelWorkflowInvocation, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
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
}
