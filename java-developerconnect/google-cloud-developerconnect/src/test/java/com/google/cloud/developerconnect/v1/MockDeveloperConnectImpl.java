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

package com.google.cloud.developerconnect.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.developerconnect.v1.DeveloperConnectGrpc.DeveloperConnectImplBase;
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
public class MockDeveloperConnectImpl extends DeveloperConnectImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockDeveloperConnectImpl() {
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
  public void createGitRepositoryLink(
      CreateGitRepositoryLinkRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateGitRepositoryLink, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteGitRepositoryLink(
      DeleteGitRepositoryLinkRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteGitRepositoryLink, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listGitRepositoryLinks(
      ListGitRepositoryLinksRequest request,
      StreamObserver<ListGitRepositoryLinksResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListGitRepositoryLinksResponse) {
      requests.add(request);
      responseObserver.onNext(((ListGitRepositoryLinksResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListGitRepositoryLinks, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListGitRepositoryLinksResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getGitRepositoryLink(
      GetGitRepositoryLinkRequest request, StreamObserver<GitRepositoryLink> responseObserver) {
    Object response = responses.poll();
    if (response instanceof GitRepositoryLink) {
      requests.add(request);
      responseObserver.onNext(((GitRepositoryLink) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetGitRepositoryLink, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  GitRepositoryLink.class.getName(),
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
  public void fetchLinkableGitRepositories(
      FetchLinkableGitRepositoriesRequest request,
      StreamObserver<FetchLinkableGitRepositoriesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FetchLinkableGitRepositoriesResponse) {
      requests.add(request);
      responseObserver.onNext(((FetchLinkableGitRepositoriesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method FetchLinkableGitRepositories, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  FetchLinkableGitRepositoriesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void fetchGitHubInstallations(
      FetchGitHubInstallationsRequest request,
      StreamObserver<FetchGitHubInstallationsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FetchGitHubInstallationsResponse) {
      requests.add(request);
      responseObserver.onNext(((FetchGitHubInstallationsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method FetchGitHubInstallations, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  FetchGitHubInstallationsResponse.class.getName(),
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
