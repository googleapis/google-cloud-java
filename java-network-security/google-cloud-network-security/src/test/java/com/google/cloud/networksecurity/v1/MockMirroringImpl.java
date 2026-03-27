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
import com.google.cloud.networksecurity.v1.MirroringGrpc.MirroringImplBase;
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
public class MockMirroringImpl extends MirroringImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockMirroringImpl() {
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
  public void listMirroringEndpointGroups(
      ListMirroringEndpointGroupsRequest request,
      StreamObserver<ListMirroringEndpointGroupsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListMirroringEndpointGroupsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListMirroringEndpointGroupsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListMirroringEndpointGroups, expected"
                      + " %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListMirroringEndpointGroupsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getMirroringEndpointGroup(
      GetMirroringEndpointGroupRequest request,
      StreamObserver<MirroringEndpointGroup> responseObserver) {
    Object response = responses.poll();
    if (response instanceof MirroringEndpointGroup) {
      requests.add(request);
      responseObserver.onNext(((MirroringEndpointGroup) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetMirroringEndpointGroup, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  MirroringEndpointGroup.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createMirroringEndpointGroup(
      CreateMirroringEndpointGroupRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateMirroringEndpointGroup, expected"
                      + " %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateMirroringEndpointGroup(
      UpdateMirroringEndpointGroupRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateMirroringEndpointGroup, expected"
                      + " %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteMirroringEndpointGroup(
      DeleteMirroringEndpointGroupRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteMirroringEndpointGroup, expected"
                      + " %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listMirroringEndpointGroupAssociations(
      ListMirroringEndpointGroupAssociationsRequest request,
      StreamObserver<ListMirroringEndpointGroupAssociationsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListMirroringEndpointGroupAssociationsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListMirroringEndpointGroupAssociationsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListMirroringEndpointGroupAssociations,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListMirroringEndpointGroupAssociationsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getMirroringEndpointGroupAssociation(
      GetMirroringEndpointGroupAssociationRequest request,
      StreamObserver<MirroringEndpointGroupAssociation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof MirroringEndpointGroupAssociation) {
      requests.add(request);
      responseObserver.onNext(((MirroringEndpointGroupAssociation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetMirroringEndpointGroupAssociation,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  MirroringEndpointGroupAssociation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createMirroringEndpointGroupAssociation(
      CreateMirroringEndpointGroupAssociationRequest request,
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
                      + " CreateMirroringEndpointGroupAssociation, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateMirroringEndpointGroupAssociation(
      UpdateMirroringEndpointGroupAssociationRequest request,
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
                      + " UpdateMirroringEndpointGroupAssociation, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteMirroringEndpointGroupAssociation(
      DeleteMirroringEndpointGroupAssociationRequest request,
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
                      + " DeleteMirroringEndpointGroupAssociation, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listMirroringDeploymentGroups(
      ListMirroringDeploymentGroupsRequest request,
      StreamObserver<ListMirroringDeploymentGroupsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListMirroringDeploymentGroupsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListMirroringDeploymentGroupsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListMirroringDeploymentGroups, expected"
                      + " %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListMirroringDeploymentGroupsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getMirroringDeploymentGroup(
      GetMirroringDeploymentGroupRequest request,
      StreamObserver<MirroringDeploymentGroup> responseObserver) {
    Object response = responses.poll();
    if (response instanceof MirroringDeploymentGroup) {
      requests.add(request);
      responseObserver.onNext(((MirroringDeploymentGroup) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetMirroringDeploymentGroup, expected"
                      + " %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  MirroringDeploymentGroup.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createMirroringDeploymentGroup(
      CreateMirroringDeploymentGroupRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateMirroringDeploymentGroup,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateMirroringDeploymentGroup(
      UpdateMirroringDeploymentGroupRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateMirroringDeploymentGroup,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteMirroringDeploymentGroup(
      DeleteMirroringDeploymentGroupRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteMirroringDeploymentGroup,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listMirroringDeployments(
      ListMirroringDeploymentsRequest request,
      StreamObserver<ListMirroringDeploymentsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListMirroringDeploymentsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListMirroringDeploymentsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListMirroringDeployments, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListMirroringDeploymentsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getMirroringDeployment(
      GetMirroringDeploymentRequest request, StreamObserver<MirroringDeployment> responseObserver) {
    Object response = responses.poll();
    if (response instanceof MirroringDeployment) {
      requests.add(request);
      responseObserver.onNext(((MirroringDeployment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetMirroringDeployment, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  MirroringDeployment.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createMirroringDeployment(
      CreateMirroringDeploymentRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateMirroringDeployment, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateMirroringDeployment(
      UpdateMirroringDeploymentRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateMirroringDeployment, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteMirroringDeployment(
      DeleteMirroringDeploymentRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteMirroringDeployment, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }
}
