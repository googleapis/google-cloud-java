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

package com.google.cloud.networksecurity.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.networksecurity.v1.FirewallActivationGrpc.FirewallActivationImplBase;
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
public class MockFirewallActivationImpl extends FirewallActivationImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockFirewallActivationImpl() {
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
  public void listFirewallEndpoints(
      ListFirewallEndpointsRequest request,
      StreamObserver<ListFirewallEndpointsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListFirewallEndpointsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListFirewallEndpointsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListFirewallEndpoints, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListFirewallEndpointsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getFirewallEndpoint(
      GetFirewallEndpointRequest request, StreamObserver<FirewallEndpoint> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FirewallEndpoint) {
      requests.add(request);
      responseObserver.onNext(((FirewallEndpoint) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetFirewallEndpoint, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  FirewallEndpoint.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createFirewallEndpoint(
      CreateFirewallEndpointRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateFirewallEndpoint, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteFirewallEndpoint(
      DeleteFirewallEndpointRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteFirewallEndpoint, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateFirewallEndpoint(
      UpdateFirewallEndpointRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateFirewallEndpoint, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listFirewallEndpointAssociations(
      ListFirewallEndpointAssociationsRequest request,
      StreamObserver<ListFirewallEndpointAssociationsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListFirewallEndpointAssociationsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListFirewallEndpointAssociationsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListFirewallEndpointAssociations,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListFirewallEndpointAssociationsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getFirewallEndpointAssociation(
      GetFirewallEndpointAssociationRequest request,
      StreamObserver<FirewallEndpointAssociation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FirewallEndpointAssociation) {
      requests.add(request);
      responseObserver.onNext(((FirewallEndpointAssociation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetFirewallEndpointAssociation,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  FirewallEndpointAssociation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createFirewallEndpointAssociation(
      CreateFirewallEndpointAssociationRequest request,
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
                  "Unrecognized response type %s for method CreateFirewallEndpointAssociation,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteFirewallEndpointAssociation(
      DeleteFirewallEndpointAssociationRequest request,
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
                  "Unrecognized response type %s for method DeleteFirewallEndpointAssociation,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateFirewallEndpointAssociation(
      UpdateFirewallEndpointAssociationRequest request,
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
                  "Unrecognized response type %s for method UpdateFirewallEndpointAssociation,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }
}
