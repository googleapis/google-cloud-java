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

package com.google.cloud.networkconnectivity.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.networkconnectivity.v1.HubServiceGrpc.HubServiceImplBase;
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
public class MockHubServiceImpl extends HubServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockHubServiceImpl() {
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
  public void listHubs(ListHubsRequest request, StreamObserver<ListHubsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListHubsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListHubsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListHubs, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListHubsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getHub(GetHubRequest request, StreamObserver<Hub> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Hub) {
      requests.add(request);
      responseObserver.onNext(((Hub) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetHub, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Hub.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createHub(CreateHubRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateHub, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateHub(UpdateHubRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateHub, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteHub(DeleteHubRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteHub, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listHubSpokes(
      ListHubSpokesRequest request, StreamObserver<ListHubSpokesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListHubSpokesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListHubSpokesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListHubSpokes, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListHubSpokesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listSpokes(
      ListSpokesRequest request, StreamObserver<ListSpokesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListSpokesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListSpokesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListSpokes, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListSpokesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getSpoke(GetSpokeRequest request, StreamObserver<Spoke> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Spoke) {
      requests.add(request);
      responseObserver.onNext(((Spoke) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetSpoke, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Spoke.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createSpoke(CreateSpokeRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateSpoke, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateSpoke(UpdateSpokeRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateSpoke, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void rejectHubSpoke(
      RejectHubSpokeRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method RejectHubSpoke, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void acceptHubSpoke(
      AcceptHubSpokeRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method AcceptHubSpoke, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteSpoke(DeleteSpokeRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteSpoke, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getRouteTable(
      GetRouteTableRequest request, StreamObserver<RouteTable> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RouteTable) {
      requests.add(request);
      responseObserver.onNext(((RouteTable) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetRouteTable, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RouteTable.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getRoute(GetRouteRequest request, StreamObserver<Route> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Route) {
      requests.add(request);
      responseObserver.onNext(((Route) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetRoute, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Route.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listRoutes(
      ListRoutesRequest request, StreamObserver<ListRoutesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListRoutesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListRoutesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListRoutes, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListRoutesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listRouteTables(
      ListRouteTablesRequest request, StreamObserver<ListRouteTablesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListRouteTablesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListRouteTablesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListRouteTables, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListRouteTablesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getGroup(GetGroupRequest request, StreamObserver<Group> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Group) {
      requests.add(request);
      responseObserver.onNext(((Group) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetGroup, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Group.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listGroups(
      ListGroupsRequest request, StreamObserver<ListGroupsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListGroupsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListGroupsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListGroups, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListGroupsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
