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

package com.google.cloud.networkservices.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.networkservices.v1.DepServiceGrpc.DepServiceImplBase;
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
public class MockDepServiceImpl extends DepServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockDepServiceImpl() {
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
  public void listLbTrafficExtensions(
      ListLbTrafficExtensionsRequest request,
      StreamObserver<ListLbTrafficExtensionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListLbTrafficExtensionsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListLbTrafficExtensionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListLbTrafficExtensions, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListLbTrafficExtensionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getLbTrafficExtension(
      GetLbTrafficExtensionRequest request, StreamObserver<LbTrafficExtension> responseObserver) {
    Object response = responses.poll();
    if (response instanceof LbTrafficExtension) {
      requests.add(request);
      responseObserver.onNext(((LbTrafficExtension) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetLbTrafficExtension, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  LbTrafficExtension.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createLbTrafficExtension(
      CreateLbTrafficExtensionRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateLbTrafficExtension, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateLbTrafficExtension(
      UpdateLbTrafficExtensionRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateLbTrafficExtension, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteLbTrafficExtension(
      DeleteLbTrafficExtensionRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteLbTrafficExtension, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listLbRouteExtensions(
      ListLbRouteExtensionsRequest request,
      StreamObserver<ListLbRouteExtensionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListLbRouteExtensionsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListLbRouteExtensionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListLbRouteExtensions, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListLbRouteExtensionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getLbRouteExtension(
      GetLbRouteExtensionRequest request, StreamObserver<LbRouteExtension> responseObserver) {
    Object response = responses.poll();
    if (response instanceof LbRouteExtension) {
      requests.add(request);
      responseObserver.onNext(((LbRouteExtension) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetLbRouteExtension, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  LbRouteExtension.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createLbRouteExtension(
      CreateLbRouteExtensionRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateLbRouteExtension, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateLbRouteExtension(
      UpdateLbRouteExtensionRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateLbRouteExtension, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteLbRouteExtension(
      DeleteLbRouteExtensionRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteLbRouteExtension, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }
}
