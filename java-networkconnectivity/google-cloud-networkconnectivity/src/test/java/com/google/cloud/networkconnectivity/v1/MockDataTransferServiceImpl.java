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
import com.google.cloud.networkconnectivity.v1.DataTransferServiceGrpc.DataTransferServiceImplBase;
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
public class MockDataTransferServiceImpl extends DataTransferServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockDataTransferServiceImpl() {
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
  public void listMulticloudDataTransferConfigs(
      ListMulticloudDataTransferConfigsRequest request,
      StreamObserver<ListMulticloudDataTransferConfigsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListMulticloudDataTransferConfigsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListMulticloudDataTransferConfigsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListMulticloudDataTransferConfigs,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListMulticloudDataTransferConfigsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getMulticloudDataTransferConfig(
      GetMulticloudDataTransferConfigRequest request,
      StreamObserver<MulticloudDataTransferConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof MulticloudDataTransferConfig) {
      requests.add(request);
      responseObserver.onNext(((MulticloudDataTransferConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetMulticloudDataTransferConfig,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  MulticloudDataTransferConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createMulticloudDataTransferConfig(
      CreateMulticloudDataTransferConfigRequest request,
      StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateMulticloudDataTransferConfig,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateMulticloudDataTransferConfig(
      UpdateMulticloudDataTransferConfigRequest request,
      StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateMulticloudDataTransferConfig,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteMulticloudDataTransferConfig(
      DeleteMulticloudDataTransferConfigRequest request,
      StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteMulticloudDataTransferConfig,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listDestinations(
      ListDestinationsRequest request, StreamObserver<ListDestinationsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListDestinationsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListDestinationsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListDestinations, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListDestinationsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getDestination(
      GetDestinationRequest request, StreamObserver<Destination> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Destination) {
      requests.add(request);
      responseObserver.onNext(((Destination) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetDestination, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Destination.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createDestination(
      CreateDestinationRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateDestination, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateDestination(
      UpdateDestinationRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateDestination, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteDestination(
      DeleteDestinationRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteDestination, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getMulticloudDataTransferSupportedService(
      GetMulticloudDataTransferSupportedServiceRequest request,
      StreamObserver<MulticloudDataTransferSupportedService> responseObserver) {
    Object response = responses.poll();
    if (response instanceof MulticloudDataTransferSupportedService) {
      requests.add(request);
      responseObserver.onNext(((MulticloudDataTransferSupportedService) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method"
                      + " GetMulticloudDataTransferSupportedService, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  MulticloudDataTransferSupportedService.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listMulticloudDataTransferSupportedServices(
      ListMulticloudDataTransferSupportedServicesRequest request,
      StreamObserver<ListMulticloudDataTransferSupportedServicesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListMulticloudDataTransferSupportedServicesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListMulticloudDataTransferSupportedServicesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method"
                      + " ListMulticloudDataTransferSupportedServices, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListMulticloudDataTransferSupportedServicesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
