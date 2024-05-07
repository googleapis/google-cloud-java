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

package com.google.cloud.visionai.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.visionai.v1.StreamingServiceGrpc.StreamingServiceImplBase;
import com.google.protobuf.AbstractMessage;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockStreamingServiceImpl extends StreamingServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockStreamingServiceImpl() {
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
  public StreamObserver<SendPacketsRequest> sendPackets(
      final StreamObserver<SendPacketsResponse> responseObserver) {
    StreamObserver<SendPacketsRequest> requestObserver =
        new StreamObserver<SendPacketsRequest>() {
          @Override
          public void onNext(SendPacketsRequest value) {
            requests.add(value);
            final Object response = responses.remove();
            if (response instanceof SendPacketsResponse) {
              responseObserver.onNext(((SendPacketsResponse) response));
            } else if (response instanceof Exception) {
              responseObserver.onError(((Exception) response));
            } else {
              responseObserver.onError(
                  new IllegalArgumentException(
                      String.format(
                          "Unrecognized response type %s for method SendPackets, expected %s or %s",
                          response == null ? "null" : response.getClass().getName(),
                          SendPacketsResponse.class.getName(),
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
  public StreamObserver<ReceivePacketsRequest> receivePackets(
      final StreamObserver<ReceivePacketsResponse> responseObserver) {
    StreamObserver<ReceivePacketsRequest> requestObserver =
        new StreamObserver<ReceivePacketsRequest>() {
          @Override
          public void onNext(ReceivePacketsRequest value) {
            requests.add(value);
            final Object response = responses.remove();
            if (response instanceof ReceivePacketsResponse) {
              responseObserver.onNext(((ReceivePacketsResponse) response));
            } else if (response instanceof Exception) {
              responseObserver.onError(((Exception) response));
            } else {
              responseObserver.onError(
                  new IllegalArgumentException(
                      String.format(
                          "Unrecognized response type %s for method ReceivePackets, expected %s or %s",
                          response == null ? "null" : response.getClass().getName(),
                          ReceivePacketsResponse.class.getName(),
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
  public StreamObserver<ReceiveEventsRequest> receiveEvents(
      final StreamObserver<ReceiveEventsResponse> responseObserver) {
    StreamObserver<ReceiveEventsRequest> requestObserver =
        new StreamObserver<ReceiveEventsRequest>() {
          @Override
          public void onNext(ReceiveEventsRequest value) {
            requests.add(value);
            final Object response = responses.remove();
            if (response instanceof ReceiveEventsResponse) {
              responseObserver.onNext(((ReceiveEventsResponse) response));
            } else if (response instanceof Exception) {
              responseObserver.onError(((Exception) response));
            } else {
              responseObserver.onError(
                  new IllegalArgumentException(
                      String.format(
                          "Unrecognized response type %s for method ReceiveEvents, expected %s or %s",
                          response == null ? "null" : response.getClass().getName(),
                          ReceiveEventsResponse.class.getName(),
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
  public void acquireLease(AcquireLeaseRequest request, StreamObserver<Lease> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Lease) {
      requests.add(request);
      responseObserver.onNext(((Lease) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method AcquireLease, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Lease.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void renewLease(RenewLeaseRequest request, StreamObserver<Lease> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Lease) {
      requests.add(request);
      responseObserver.onNext(((Lease) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RenewLease, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Lease.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void releaseLease(
      ReleaseLeaseRequest request, StreamObserver<ReleaseLeaseResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ReleaseLeaseResponse) {
      requests.add(request);
      responseObserver.onNext(((ReleaseLeaseResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ReleaseLease, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ReleaseLeaseResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
