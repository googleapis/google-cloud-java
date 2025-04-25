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

package com.google.cloud.networkconnectivity.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.networkconnectivity.v1.CrossNetworkAutomationServiceGrpc.CrossNetworkAutomationServiceImplBase;
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
public class MockCrossNetworkAutomationServiceImpl extends CrossNetworkAutomationServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockCrossNetworkAutomationServiceImpl() {
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
  public void listServiceConnectionMaps(
      ListServiceConnectionMapsRequest request,
      StreamObserver<ListServiceConnectionMapsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListServiceConnectionMapsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListServiceConnectionMapsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListServiceConnectionMaps, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListServiceConnectionMapsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getServiceConnectionMap(
      GetServiceConnectionMapRequest request,
      StreamObserver<ServiceConnectionMap> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ServiceConnectionMap) {
      requests.add(request);
      responseObserver.onNext(((ServiceConnectionMap) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetServiceConnectionMap, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ServiceConnectionMap.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createServiceConnectionMap(
      CreateServiceConnectionMapRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateServiceConnectionMap, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateServiceConnectionMap(
      UpdateServiceConnectionMapRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateServiceConnectionMap, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteServiceConnectionMap(
      DeleteServiceConnectionMapRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteServiceConnectionMap, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listServiceConnectionPolicies(
      ListServiceConnectionPoliciesRequest request,
      StreamObserver<ListServiceConnectionPoliciesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListServiceConnectionPoliciesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListServiceConnectionPoliciesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListServiceConnectionPolicies, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListServiceConnectionPoliciesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getServiceConnectionPolicy(
      GetServiceConnectionPolicyRequest request,
      StreamObserver<ServiceConnectionPolicy> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ServiceConnectionPolicy) {
      requests.add(request);
      responseObserver.onNext(((ServiceConnectionPolicy) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetServiceConnectionPolicy, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ServiceConnectionPolicy.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createServiceConnectionPolicy(
      CreateServiceConnectionPolicyRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateServiceConnectionPolicy, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateServiceConnectionPolicy(
      UpdateServiceConnectionPolicyRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateServiceConnectionPolicy, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteServiceConnectionPolicy(
      DeleteServiceConnectionPolicyRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteServiceConnectionPolicy, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listServiceClasses(
      ListServiceClassesRequest request,
      StreamObserver<ListServiceClassesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListServiceClassesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListServiceClassesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListServiceClasses, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListServiceClassesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getServiceClass(
      GetServiceClassRequest request, StreamObserver<ServiceClass> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ServiceClass) {
      requests.add(request);
      responseObserver.onNext(((ServiceClass) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetServiceClass, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ServiceClass.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateServiceClass(
      UpdateServiceClassRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateServiceClass, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteServiceClass(
      DeleteServiceClassRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteServiceClass, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getServiceConnectionToken(
      GetServiceConnectionTokenRequest request,
      StreamObserver<ServiceConnectionToken> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ServiceConnectionToken) {
      requests.add(request);
      responseObserver.onNext(((ServiceConnectionToken) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetServiceConnectionToken, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ServiceConnectionToken.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listServiceConnectionTokens(
      ListServiceConnectionTokensRequest request,
      StreamObserver<ListServiceConnectionTokensResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListServiceConnectionTokensResponse) {
      requests.add(request);
      responseObserver.onNext(((ListServiceConnectionTokensResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListServiceConnectionTokens, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListServiceConnectionTokensResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createServiceConnectionToken(
      CreateServiceConnectionTokenRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateServiceConnectionToken, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteServiceConnectionToken(
      DeleteServiceConnectionTokenRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteServiceConnectionToken, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }
}
