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

package com.google.cloud.agentidentity.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.agentidentity.v1.AuthProviderServiceGrpc.AuthProviderServiceImplBase;
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
public class MockAuthProviderServiceImpl extends AuthProviderServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockAuthProviderServiceImpl() {
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
  public void listAuthProviders(
      ListAuthProvidersRequest request,
      StreamObserver<ListAuthProvidersResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListAuthProvidersResponse) {
      requests.add(request);
      responseObserver.onNext(((ListAuthProvidersResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListAuthProviders, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListAuthProvidersResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getAuthProvider(
      GetAuthProviderRequest request, StreamObserver<AuthProvider> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AuthProvider) {
      requests.add(request);
      responseObserver.onNext(((AuthProvider) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetAuthProvider, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AuthProvider.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createAuthProvider(
      CreateAuthProviderRequest request, StreamObserver<AuthProvider> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AuthProvider) {
      requests.add(request);
      responseObserver.onNext(((AuthProvider) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateAuthProvider, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AuthProvider.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateAuthProvider(
      UpdateAuthProviderRequest request, StreamObserver<AuthProvider> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AuthProvider) {
      requests.add(request);
      responseObserver.onNext(((AuthProvider) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateAuthProvider, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AuthProvider.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteAuthProvider(
      DeleteAuthProviderRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteAuthProvider, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void undeleteAuthProvider(
      UndeleteAuthProviderRequest request, StreamObserver<AuthProvider> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AuthProvider) {
      requests.add(request);
      responseObserver.onNext(((AuthProvider) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UndeleteAuthProvider, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  AuthProvider.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void queryAuthProviders(
      QueryAuthProvidersRequest request,
      StreamObserver<QueryAuthProvidersResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof QueryAuthProvidersResponse) {
      requests.add(request);
      responseObserver.onNext(((QueryAuthProvidersResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method QueryAuthProviders, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  QueryAuthProvidersResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void queryWorkloads(
      QueryWorkloadsRequest request, StreamObserver<QueryWorkloadsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof QueryWorkloadsResponse) {
      requests.add(request);
      responseObserver.onNext(((QueryWorkloadsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method QueryWorkloads, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  QueryWorkloadsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listAuthorizations(
      ListAuthorizationsRequest request,
      StreamObserver<ListAuthorizationsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListAuthorizationsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListAuthorizationsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListAuthorizations, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListAuthorizationsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getAuthorization(
      GetAuthorizationRequest request, StreamObserver<Authorization> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Authorization) {
      requests.add(request);
      responseObserver.onNext(((Authorization) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetAuthorization, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Authorization.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteAuthorization(
      DeleteAuthorizationRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteAuthorization, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listAccessSummaries(
      ListAccessSummariesRequest request,
      StreamObserver<ListAccessSummariesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListAccessSummariesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListAccessSummariesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListAccessSummaries, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListAccessSummariesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getAccessSummary(
      GetAccessSummaryRequest request, StreamObserver<AccessSummary> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AccessSummary) {
      requests.add(request);
      responseObserver.onNext(((AccessSummary) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetAccessSummary, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AccessSummary.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void revokeAuthorization(
      RevokeAuthorizationRequest request,
      StreamObserver<RevokeAuthorizationResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RevokeAuthorizationResponse) {
      requests.add(request);
      responseObserver.onNext(((RevokeAuthorizationResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RevokeAuthorization, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RevokeAuthorizationResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void enableAuthProvider(
      EnableAuthProviderRequest request, StreamObserver<AuthProvider> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AuthProvider) {
      requests.add(request);
      responseObserver.onNext(((AuthProvider) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method EnableAuthProvider, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AuthProvider.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void disableAuthProvider(
      DisableAuthProviderRequest request, StreamObserver<AuthProvider> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AuthProvider) {
      requests.add(request);
      responseObserver.onNext(((AuthProvider) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DisableAuthProvider, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AuthProvider.class.getName(),
                  Exception.class.getName())));
    }
  }
}
