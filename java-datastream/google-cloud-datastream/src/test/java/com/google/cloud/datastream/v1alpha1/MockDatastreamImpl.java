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

package com.google.cloud.datastream.v1alpha1;

import com.google.api.core.BetaApi;
import com.google.cloud.datastream.v1alpha1.DatastreamGrpc.DatastreamImplBase;
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
public class MockDatastreamImpl extends DatastreamImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockDatastreamImpl() {
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
  public void listConnectionProfiles(
      ListConnectionProfilesRequest request,
      StreamObserver<ListConnectionProfilesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListConnectionProfilesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListConnectionProfilesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListConnectionProfiles, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListConnectionProfilesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getConnectionProfile(
      GetConnectionProfileRequest request, StreamObserver<ConnectionProfile> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ConnectionProfile) {
      requests.add(request);
      responseObserver.onNext(((ConnectionProfile) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetConnectionProfile, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ConnectionProfile.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createConnectionProfile(
      CreateConnectionProfileRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateConnectionProfile, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateConnectionProfile(
      UpdateConnectionProfileRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateConnectionProfile, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteConnectionProfile(
      DeleteConnectionProfileRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteConnectionProfile, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void discoverConnectionProfile(
      DiscoverConnectionProfileRequest request,
      StreamObserver<DiscoverConnectionProfileResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DiscoverConnectionProfileResponse) {
      requests.add(request);
      responseObserver.onNext(((DiscoverConnectionProfileResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DiscoverConnectionProfile, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DiscoverConnectionProfileResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listStreams(
      ListStreamsRequest request, StreamObserver<ListStreamsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListStreamsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListStreamsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListStreams, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListStreamsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getStream(GetStreamRequest request, StreamObserver<Stream> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Stream) {
      requests.add(request);
      responseObserver.onNext(((Stream) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetStream, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Stream.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createStream(
      CreateStreamRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateStream, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateStream(
      UpdateStreamRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateStream, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteStream(
      DeleteStreamRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteStream, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void fetchErrors(FetchErrorsRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method FetchErrors, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void fetchStaticIps(
      FetchStaticIpsRequest request, StreamObserver<FetchStaticIpsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FetchStaticIpsResponse) {
      requests.add(request);
      responseObserver.onNext(((FetchStaticIpsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method FetchStaticIps, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  FetchStaticIpsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createPrivateConnection(
      CreatePrivateConnectionRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreatePrivateConnection, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getPrivateConnection(
      GetPrivateConnectionRequest request, StreamObserver<PrivateConnection> responseObserver) {
    Object response = responses.poll();
    if (response instanceof PrivateConnection) {
      requests.add(request);
      responseObserver.onNext(((PrivateConnection) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetPrivateConnection, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  PrivateConnection.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listPrivateConnections(
      ListPrivateConnectionsRequest request,
      StreamObserver<ListPrivateConnectionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListPrivateConnectionsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListPrivateConnectionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListPrivateConnections, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListPrivateConnectionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deletePrivateConnection(
      DeletePrivateConnectionRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeletePrivateConnection, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createRoute(CreateRouteRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateRoute, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
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
  public void deleteRoute(DeleteRouteRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteRoute, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }
}
