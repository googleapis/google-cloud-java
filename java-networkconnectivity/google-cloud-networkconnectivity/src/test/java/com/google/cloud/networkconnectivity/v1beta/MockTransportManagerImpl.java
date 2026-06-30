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

package com.google.cloud.networkconnectivity.v1beta;

import com.google.api.core.BetaApi;
import com.google.cloud.networkconnectivity.v1beta.TransportManagerGrpc.TransportManagerImplBase;
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
public class MockTransportManagerImpl extends TransportManagerImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockTransportManagerImpl() {
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
  public void listRemoteTransportProfiles(
      ListRemoteTransportProfilesRequest request,
      StreamObserver<ListRemoteTransportProfilesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListRemoteTransportProfilesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListRemoteTransportProfilesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListRemoteTransportProfiles, expected"
                      + " %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListRemoteTransportProfilesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getRemoteTransportProfile(
      GetRemoteTransportProfileRequest request,
      StreamObserver<RemoteTransportProfile> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RemoteTransportProfile) {
      requests.add(request);
      responseObserver.onNext(((RemoteTransportProfile) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetRemoteTransportProfile, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RemoteTransportProfile.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listTransports(
      ListTransportsRequest request, StreamObserver<ListTransportsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListTransportsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListTransportsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListTransports, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListTransportsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getTransport(
      GetTransportRequest request, StreamObserver<Transport> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Transport) {
      requests.add(request);
      responseObserver.onNext(((Transport) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetTransport, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Transport.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getStatus(
      GetStatusRequest request, StreamObserver<GetStatusResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof GetStatusResponse) {
      requests.add(request);
      responseObserver.onNext(((GetStatusResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetStatus, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  GetStatusResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createTransport(
      CreateTransportRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateTransport, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateTransport(
      UpdateTransportRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateTransport, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteTransport(
      DeleteTransportRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteTransport, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }
}
