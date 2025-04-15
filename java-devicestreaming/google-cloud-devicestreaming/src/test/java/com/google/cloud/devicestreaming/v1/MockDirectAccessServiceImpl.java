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

package com.google.cloud.devicestreaming.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.devicestreaming.v1.DirectAccessServiceGrpc.DirectAccessServiceImplBase;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockDirectAccessServiceImpl extends DirectAccessServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockDirectAccessServiceImpl() {
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
  public void createDeviceSession(
      CreateDeviceSessionRequest request, StreamObserver<DeviceSession> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DeviceSession) {
      requests.add(request);
      responseObserver.onNext(((DeviceSession) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateDeviceSession, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DeviceSession.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listDeviceSessions(
      ListDeviceSessionsRequest request,
      StreamObserver<ListDeviceSessionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListDeviceSessionsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListDeviceSessionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListDeviceSessions, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListDeviceSessionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getDeviceSession(
      GetDeviceSessionRequest request, StreamObserver<DeviceSession> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DeviceSession) {
      requests.add(request);
      responseObserver.onNext(((DeviceSession) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetDeviceSession, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DeviceSession.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void cancelDeviceSession(
      CancelDeviceSessionRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method CancelDeviceSession, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateDeviceSession(
      UpdateDeviceSessionRequest request, StreamObserver<DeviceSession> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DeviceSession) {
      requests.add(request);
      responseObserver.onNext(((DeviceSession) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateDeviceSession, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DeviceSession.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public StreamObserver<AdbMessage> adbConnect(
      final StreamObserver<DeviceMessage> responseObserver) {
    StreamObserver<AdbMessage> requestObserver =
        new StreamObserver<AdbMessage>() {
          @Override
          public void onNext(AdbMessage value) {
            requests.add(value);
            final Object response = responses.remove();
            if (response instanceof DeviceMessage) {
              responseObserver.onNext(((DeviceMessage) response));
            } else if (response instanceof Exception) {
              responseObserver.onError(((Exception) response));
            } else {
              responseObserver.onError(
                  new IllegalArgumentException(
                      String.format(
                          "Unrecognized response type %s for method AdbConnect, expected %s or %s",
                          response == null ? "null" : response.getClass().getName(),
                          DeviceMessage.class.getName(),
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
