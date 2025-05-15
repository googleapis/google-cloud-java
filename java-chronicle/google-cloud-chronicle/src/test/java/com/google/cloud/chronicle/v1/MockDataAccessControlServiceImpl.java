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

package com.google.cloud.chronicle.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.chronicle.v1.DataAccessControlServiceGrpc.DataAccessControlServiceImplBase;
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
public class MockDataAccessControlServiceImpl extends DataAccessControlServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockDataAccessControlServiceImpl() {
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
  public void createDataAccessLabel(
      CreateDataAccessLabelRequest request, StreamObserver<DataAccessLabel> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DataAccessLabel) {
      requests.add(request);
      responseObserver.onNext(((DataAccessLabel) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateDataAccessLabel, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  DataAccessLabel.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getDataAccessLabel(
      GetDataAccessLabelRequest request, StreamObserver<DataAccessLabel> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DataAccessLabel) {
      requests.add(request);
      responseObserver.onNext(((DataAccessLabel) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetDataAccessLabel, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DataAccessLabel.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listDataAccessLabels(
      ListDataAccessLabelsRequest request,
      StreamObserver<ListDataAccessLabelsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListDataAccessLabelsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListDataAccessLabelsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListDataAccessLabels, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListDataAccessLabelsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateDataAccessLabel(
      UpdateDataAccessLabelRequest request, StreamObserver<DataAccessLabel> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DataAccessLabel) {
      requests.add(request);
      responseObserver.onNext(((DataAccessLabel) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateDataAccessLabel, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  DataAccessLabel.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteDataAccessLabel(
      DeleteDataAccessLabelRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteDataAccessLabel, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createDataAccessScope(
      CreateDataAccessScopeRequest request, StreamObserver<DataAccessScope> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DataAccessScope) {
      requests.add(request);
      responseObserver.onNext(((DataAccessScope) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateDataAccessScope, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  DataAccessScope.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getDataAccessScope(
      GetDataAccessScopeRequest request, StreamObserver<DataAccessScope> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DataAccessScope) {
      requests.add(request);
      responseObserver.onNext(((DataAccessScope) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetDataAccessScope, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DataAccessScope.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listDataAccessScopes(
      ListDataAccessScopesRequest request,
      StreamObserver<ListDataAccessScopesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListDataAccessScopesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListDataAccessScopesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListDataAccessScopes, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListDataAccessScopesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateDataAccessScope(
      UpdateDataAccessScopeRequest request, StreamObserver<DataAccessScope> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DataAccessScope) {
      requests.add(request);
      responseObserver.onNext(((DataAccessScope) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateDataAccessScope, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  DataAccessScope.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteDataAccessScope(
      DeleteDataAccessScopeRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteDataAccessScope, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }
}
