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

package com.google.appengine.v1;

import com.google.api.core.BetaApi;
import com.google.appengine.v1.AuthorizedCertificatesGrpc.AuthorizedCertificatesImplBase;
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
public class MockAuthorizedCertificatesImpl extends AuthorizedCertificatesImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockAuthorizedCertificatesImpl() {
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
  public void listAuthorizedCertificates(
      ListAuthorizedCertificatesRequest request,
      StreamObserver<ListAuthorizedCertificatesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListAuthorizedCertificatesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListAuthorizedCertificatesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListAuthorizedCertificates, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListAuthorizedCertificatesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getAuthorizedCertificate(
      GetAuthorizedCertificateRequest request,
      StreamObserver<AuthorizedCertificate> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AuthorizedCertificate) {
      requests.add(request);
      responseObserver.onNext(((AuthorizedCertificate) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetAuthorizedCertificate, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AuthorizedCertificate.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createAuthorizedCertificate(
      CreateAuthorizedCertificateRequest request,
      StreamObserver<AuthorizedCertificate> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AuthorizedCertificate) {
      requests.add(request);
      responseObserver.onNext(((AuthorizedCertificate) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateAuthorizedCertificate, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AuthorizedCertificate.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateAuthorizedCertificate(
      UpdateAuthorizedCertificateRequest request,
      StreamObserver<AuthorizedCertificate> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AuthorizedCertificate) {
      requests.add(request);
      responseObserver.onNext(((AuthorizedCertificate) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateAuthorizedCertificate, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AuthorizedCertificate.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteAuthorizedCertificate(
      DeleteAuthorizedCertificateRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteAuthorizedCertificate, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }
}
