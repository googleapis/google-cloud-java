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
import com.google.cloud.networksecurity.v1.InterceptGrpc.InterceptImplBase;
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
public class MockInterceptImpl extends InterceptImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockInterceptImpl() {
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
  public void listInterceptEndpointGroups(
      ListInterceptEndpointGroupsRequest request,
      StreamObserver<ListInterceptEndpointGroupsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListInterceptEndpointGroupsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListInterceptEndpointGroupsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListInterceptEndpointGroups, expected"
                      + " %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListInterceptEndpointGroupsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getInterceptEndpointGroup(
      GetInterceptEndpointGroupRequest request,
      StreamObserver<InterceptEndpointGroup> responseObserver) {
    Object response = responses.poll();
    if (response instanceof InterceptEndpointGroup) {
      requests.add(request);
      responseObserver.onNext(((InterceptEndpointGroup) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetInterceptEndpointGroup, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  InterceptEndpointGroup.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createInterceptEndpointGroup(
      CreateInterceptEndpointGroupRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateInterceptEndpointGroup, expected"
                      + " %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateInterceptEndpointGroup(
      UpdateInterceptEndpointGroupRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateInterceptEndpointGroup, expected"
                      + " %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteInterceptEndpointGroup(
      DeleteInterceptEndpointGroupRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteInterceptEndpointGroup, expected"
                      + " %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listInterceptEndpointGroupAssociations(
      ListInterceptEndpointGroupAssociationsRequest request,
      StreamObserver<ListInterceptEndpointGroupAssociationsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListInterceptEndpointGroupAssociationsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListInterceptEndpointGroupAssociationsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListInterceptEndpointGroupAssociations,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListInterceptEndpointGroupAssociationsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getInterceptEndpointGroupAssociation(
      GetInterceptEndpointGroupAssociationRequest request,
      StreamObserver<InterceptEndpointGroupAssociation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof InterceptEndpointGroupAssociation) {
      requests.add(request);
      responseObserver.onNext(((InterceptEndpointGroupAssociation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetInterceptEndpointGroupAssociation,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  InterceptEndpointGroupAssociation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createInterceptEndpointGroupAssociation(
      CreateInterceptEndpointGroupAssociationRequest request,
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
                  "Unrecognized response type %s for method"
                      + " CreateInterceptEndpointGroupAssociation, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateInterceptEndpointGroupAssociation(
      UpdateInterceptEndpointGroupAssociationRequest request,
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
                  "Unrecognized response type %s for method"
                      + " UpdateInterceptEndpointGroupAssociation, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteInterceptEndpointGroupAssociation(
      DeleteInterceptEndpointGroupAssociationRequest request,
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
                  "Unrecognized response type %s for method"
                      + " DeleteInterceptEndpointGroupAssociation, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listInterceptDeploymentGroups(
      ListInterceptDeploymentGroupsRequest request,
      StreamObserver<ListInterceptDeploymentGroupsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListInterceptDeploymentGroupsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListInterceptDeploymentGroupsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListInterceptDeploymentGroups, expected"
                      + " %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListInterceptDeploymentGroupsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getInterceptDeploymentGroup(
      GetInterceptDeploymentGroupRequest request,
      StreamObserver<InterceptDeploymentGroup> responseObserver) {
    Object response = responses.poll();
    if (response instanceof InterceptDeploymentGroup) {
      requests.add(request);
      responseObserver.onNext(((InterceptDeploymentGroup) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetInterceptDeploymentGroup, expected"
                      + " %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  InterceptDeploymentGroup.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createInterceptDeploymentGroup(
      CreateInterceptDeploymentGroupRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateInterceptDeploymentGroup,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateInterceptDeploymentGroup(
      UpdateInterceptDeploymentGroupRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateInterceptDeploymentGroup,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteInterceptDeploymentGroup(
      DeleteInterceptDeploymentGroupRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteInterceptDeploymentGroup,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listInterceptDeployments(
      ListInterceptDeploymentsRequest request,
      StreamObserver<ListInterceptDeploymentsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListInterceptDeploymentsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListInterceptDeploymentsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListInterceptDeployments, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListInterceptDeploymentsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getInterceptDeployment(
      GetInterceptDeploymentRequest request, StreamObserver<InterceptDeployment> responseObserver) {
    Object response = responses.poll();
    if (response instanceof InterceptDeployment) {
      requests.add(request);
      responseObserver.onNext(((InterceptDeployment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetInterceptDeployment, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  InterceptDeployment.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createInterceptDeployment(
      CreateInterceptDeploymentRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateInterceptDeployment, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateInterceptDeployment(
      UpdateInterceptDeploymentRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateInterceptDeployment, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteInterceptDeployment(
      DeleteInterceptDeploymentRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteInterceptDeployment, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }
}
