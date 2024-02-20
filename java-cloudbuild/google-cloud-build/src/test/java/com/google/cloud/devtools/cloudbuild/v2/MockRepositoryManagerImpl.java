/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.devtools.cloudbuild.v2;

import com.google.api.core.BetaApi;
import com.google.cloudbuild.v2.BatchCreateRepositoriesRequest;
import com.google.cloudbuild.v2.Connection;
import com.google.cloudbuild.v2.CreateConnectionRequest;
import com.google.cloudbuild.v2.CreateRepositoryRequest;
import com.google.cloudbuild.v2.DeleteConnectionRequest;
import com.google.cloudbuild.v2.DeleteRepositoryRequest;
import com.google.cloudbuild.v2.FetchGitRefsRequest;
import com.google.cloudbuild.v2.FetchGitRefsResponse;
import com.google.cloudbuild.v2.FetchLinkableRepositoriesRequest;
import com.google.cloudbuild.v2.FetchLinkableRepositoriesResponse;
import com.google.cloudbuild.v2.FetchReadTokenRequest;
import com.google.cloudbuild.v2.FetchReadTokenResponse;
import com.google.cloudbuild.v2.FetchReadWriteTokenRequest;
import com.google.cloudbuild.v2.FetchReadWriteTokenResponse;
import com.google.cloudbuild.v2.GetConnectionRequest;
import com.google.cloudbuild.v2.GetRepositoryRequest;
import com.google.cloudbuild.v2.ListConnectionsRequest;
import com.google.cloudbuild.v2.ListConnectionsResponse;
import com.google.cloudbuild.v2.ListRepositoriesRequest;
import com.google.cloudbuild.v2.ListRepositoriesResponse;
import com.google.cloudbuild.v2.Repository;
import com.google.cloudbuild.v2.RepositoryManagerGrpc.RepositoryManagerImplBase;
import com.google.cloudbuild.v2.UpdateConnectionRequest;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockRepositoryManagerImpl extends RepositoryManagerImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockRepositoryManagerImpl() {
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
  public void createConnection(
      CreateConnectionRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateConnection, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getConnection(
      GetConnectionRequest request, StreamObserver<Connection> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Connection) {
      requests.add(request);
      responseObserver.onNext(((Connection) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetConnection, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Connection.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listConnections(
      ListConnectionsRequest request, StreamObserver<ListConnectionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListConnectionsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListConnectionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListConnections, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListConnectionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateConnection(
      UpdateConnectionRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateConnection, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteConnection(
      DeleteConnectionRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteConnection, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
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
  public void batchCreateRepositories(
      BatchCreateRepositoriesRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method BatchCreateRepositories, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
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
  public void fetchReadWriteToken(
      FetchReadWriteTokenRequest request,
      StreamObserver<FetchReadWriteTokenResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FetchReadWriteTokenResponse) {
      requests.add(request);
      responseObserver.onNext(((FetchReadWriteTokenResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method FetchReadWriteToken, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  FetchReadWriteTokenResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void fetchReadToken(
      FetchReadTokenRequest request, StreamObserver<FetchReadTokenResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FetchReadTokenResponse) {
      requests.add(request);
      responseObserver.onNext(((FetchReadTokenResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method FetchReadToken, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  FetchReadTokenResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void fetchLinkableRepositories(
      FetchLinkableRepositoriesRequest request,
      StreamObserver<FetchLinkableRepositoriesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FetchLinkableRepositoriesResponse) {
      requests.add(request);
      responseObserver.onNext(((FetchLinkableRepositoriesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method FetchLinkableRepositories, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  FetchLinkableRepositoriesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void fetchGitRefs(
      FetchGitRefsRequest request, StreamObserver<FetchGitRefsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FetchGitRefsResponse) {
      requests.add(request);
      responseObserver.onNext(((FetchGitRefsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method FetchGitRefs, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  FetchGitRefsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
