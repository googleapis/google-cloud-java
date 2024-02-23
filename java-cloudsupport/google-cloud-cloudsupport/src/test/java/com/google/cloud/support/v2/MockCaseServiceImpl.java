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

package com.google.cloud.support.v2;

import com.google.api.core.BetaApi;
import com.google.cloud.support.v2.CaseServiceGrpc.CaseServiceImplBase;
import com.google.protobuf.AbstractMessage;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockCaseServiceImpl extends CaseServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockCaseServiceImpl() {
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
  public void getCase(GetCaseRequest request, StreamObserver<Case> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Case) {
      requests.add(request);
      responseObserver.onNext(((Case) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetCase, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Case.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listCases(
      ListCasesRequest request, StreamObserver<ListCasesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListCasesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListCasesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListCases, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListCasesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void searchCases(
      SearchCasesRequest request, StreamObserver<SearchCasesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SearchCasesResponse) {
      requests.add(request);
      responseObserver.onNext(((SearchCasesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SearchCases, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SearchCasesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createCase(CreateCaseRequest request, StreamObserver<Case> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Case) {
      requests.add(request);
      responseObserver.onNext(((Case) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateCase, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Case.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateCase(UpdateCaseRequest request, StreamObserver<Case> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Case) {
      requests.add(request);
      responseObserver.onNext(((Case) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateCase, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Case.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void escalateCase(EscalateCaseRequest request, StreamObserver<Case> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Case) {
      requests.add(request);
      responseObserver.onNext(((Case) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method EscalateCase, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Case.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void closeCase(CloseCaseRequest request, StreamObserver<Case> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Case) {
      requests.add(request);
      responseObserver.onNext(((Case) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CloseCase, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Case.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void searchCaseClassifications(
      SearchCaseClassificationsRequest request,
      StreamObserver<SearchCaseClassificationsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SearchCaseClassificationsResponse) {
      requests.add(request);
      responseObserver.onNext(((SearchCaseClassificationsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SearchCaseClassifications, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SearchCaseClassificationsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
