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

package com.google.showcase.v1beta1;

import com.google.api.core.BetaApi;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import com.google.showcase.v1beta1.MessagingGrpc.MessagingImplBase;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockMessagingImpl extends MessagingImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockMessagingImpl() {
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
  public void createRoom(CreateRoomRequest request, StreamObserver<Room> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Room) {
      requests.add(request);
      responseObserver.onNext(((Room) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateRoom, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Room.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getRoom(GetRoomRequest request, StreamObserver<Room> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Room) {
      requests.add(request);
      responseObserver.onNext(((Room) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetRoom, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Room.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateRoom(UpdateRoomRequest request, StreamObserver<Room> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Room) {
      requests.add(request);
      responseObserver.onNext(((Room) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateRoom, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Room.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteRoom(DeleteRoomRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteRoom, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listRooms(
      ListRoomsRequest request, StreamObserver<ListRoomsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListRoomsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListRoomsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListRooms, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListRoomsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createBlurb(CreateBlurbRequest request, StreamObserver<Blurb> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Blurb) {
      requests.add(request);
      responseObserver.onNext(((Blurb) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateBlurb, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Blurb.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getBlurb(GetBlurbRequest request, StreamObserver<Blurb> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Blurb) {
      requests.add(request);
      responseObserver.onNext(((Blurb) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetBlurb, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Blurb.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateBlurb(UpdateBlurbRequest request, StreamObserver<Blurb> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Blurb) {
      requests.add(request);
      responseObserver.onNext(((Blurb) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateBlurb, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Blurb.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteBlurb(DeleteBlurbRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteBlurb, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listBlurbs(
      ListBlurbsRequest request, StreamObserver<ListBlurbsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListBlurbsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListBlurbsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListBlurbs, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListBlurbsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void searchBlurbs(
      SearchBlurbsRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method SearchBlurbs, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void streamBlurbs(
      StreamBlurbsRequest request, StreamObserver<StreamBlurbsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof StreamBlurbsResponse) {
      requests.add(request);
      responseObserver.onNext(((StreamBlurbsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method StreamBlurbs, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  StreamBlurbsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public StreamObserver<CreateBlurbRequest> sendBlurbs(
      final StreamObserver<SendBlurbsResponse> responseObserver) {
    StreamObserver<CreateBlurbRequest> requestObserver =
        new StreamObserver<CreateBlurbRequest>() {
          @Override
          public void onNext(CreateBlurbRequest value) {
            requests.add(value);
            final Object response = responses.remove();
            if (response instanceof SendBlurbsResponse) {
              responseObserver.onNext(((SendBlurbsResponse) response));
            } else if (response instanceof Exception) {
              responseObserver.onError(((Exception) response));
            } else {
              responseObserver.onError(
                  new IllegalArgumentException(
                      String.format(
                          "Unrecognized response type %s for method SendBlurbs, expected %s or %s",
                          response == null ? "null" : response.getClass().getName(),
                          SendBlurbsResponse.class.getName(),
                          Exception.class.getName())));
            }
          }

          @Override
          public void onError(Throwable t) {
            responseObserver.onError(t);
          }

          @Override
          public void onCompleted() {
            responseObserver.onCompleted();
          }
        };
    return requestObserver;
  }

  @Override
  public StreamObserver<ConnectRequest> connect(
      final StreamObserver<StreamBlurbsResponse> responseObserver) {
    StreamObserver<ConnectRequest> requestObserver =
        new StreamObserver<ConnectRequest>() {
          @Override
          public void onNext(ConnectRequest value) {
            requests.add(value);
            final Object response = responses.remove();
            if (response instanceof StreamBlurbsResponse) {
              responseObserver.onNext(((StreamBlurbsResponse) response));
            } else if (response instanceof Exception) {
              responseObserver.onError(((Exception) response));
            } else {
              responseObserver.onError(
                  new IllegalArgumentException(
                      String.format(
                          "Unrecognized response type %s for method Connect, expected %s or %s",
                          response == null ? "null" : response.getClass().getName(),
                          StreamBlurbsResponse.class.getName(),
                          Exception.class.getName())));
            }
          }

          @Override
          public void onError(Throwable t) {
            responseObserver.onError(t);
          }

          @Override
          public void onCompleted() {
            responseObserver.onCompleted();
          }
        };
    return requestObserver;
  }
}
