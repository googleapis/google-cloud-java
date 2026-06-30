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
import com.google.showcase.v1beta1.EchoGrpc.EchoImplBase;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockEchoImpl extends EchoImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockEchoImpl() {
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
  public void echo(EchoRequest request, StreamObserver<EchoResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof EchoResponse) {
      requests.add(request);
      responseObserver.onNext(((EchoResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method Echo, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  EchoResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void echoErrorDetails(
      EchoErrorDetailsRequest request, StreamObserver<EchoErrorDetailsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof EchoErrorDetailsResponse) {
      requests.add(request);
      responseObserver.onNext(((EchoErrorDetailsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method EchoErrorDetails, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  EchoErrorDetailsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void failEchoWithDetails(
      FailEchoWithDetailsRequest request,
      StreamObserver<FailEchoWithDetailsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FailEchoWithDetailsResponse) {
      requests.add(request);
      responseObserver.onNext(((FailEchoWithDetailsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method FailEchoWithDetails, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  FailEchoWithDetailsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void expand(ExpandRequest request, StreamObserver<EchoResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof EchoResponse) {
      requests.add(request);
      responseObserver.onNext(((EchoResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method Expand, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  EchoResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public StreamObserver<EchoRequest> collect(final StreamObserver<EchoResponse> responseObserver) {
    StreamObserver<EchoRequest> requestObserver =
        new StreamObserver<EchoRequest>() {
          @Override
          public void onNext(EchoRequest value) {
            requests.add(value);
            final Object response = responses.remove();
            if (response instanceof EchoResponse) {
              responseObserver.onNext(((EchoResponse) response));
            } else if (response instanceof Exception) {
              responseObserver.onError(((Exception) response));
            } else {
              responseObserver.onError(
                  new IllegalArgumentException(
                      String.format(
                          "Unrecognized response type %s for method Collect, expected %s or %s",
                          response == null ? "null" : response.getClass().getName(),
                          EchoResponse.class.getName(),
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
  public StreamObserver<EchoRequest> chat(final StreamObserver<EchoResponse> responseObserver) {
    StreamObserver<EchoRequest> requestObserver =
        new StreamObserver<EchoRequest>() {
          @Override
          public void onNext(EchoRequest value) {
            requests.add(value);
            final Object response = responses.remove();
            if (response instanceof EchoResponse) {
              responseObserver.onNext(((EchoResponse) response));
            } else if (response instanceof Exception) {
              responseObserver.onError(((Exception) response));
            } else {
              responseObserver.onError(
                  new IllegalArgumentException(
                      String.format(
                          "Unrecognized response type %s for method Chat, expected %s or %s",
                          response == null ? "null" : response.getClass().getName(),
                          EchoResponse.class.getName(),
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
  public void pagedExpand(
      PagedExpandRequest request, StreamObserver<PagedExpandResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof PagedExpandResponse) {
      requests.add(request);
      responseObserver.onNext(((PagedExpandResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method PagedExpand, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  PagedExpandResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void pagedExpandLegacy(
      PagedExpandLegacyRequest request, StreamObserver<PagedExpandResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof PagedExpandResponse) {
      requests.add(request);
      responseObserver.onNext(((PagedExpandResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method PagedExpandLegacy, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  PagedExpandResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void pagedExpandLegacyMapped(
      PagedExpandRequest request,
      StreamObserver<PagedExpandLegacyMappedResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof PagedExpandLegacyMappedResponse) {
      requests.add(request);
      responseObserver.onNext(((PagedExpandLegacyMappedResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method PagedExpandLegacyMapped, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  PagedExpandLegacyMappedResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void wait(WaitRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method Wait, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void block(BlockRequest request, StreamObserver<BlockResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof BlockResponse) {
      requests.add(request);
      responseObserver.onNext(((BlockResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method Block, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  BlockResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
