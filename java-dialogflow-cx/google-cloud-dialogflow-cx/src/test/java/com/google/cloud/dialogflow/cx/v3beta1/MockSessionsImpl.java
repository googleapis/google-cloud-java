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

package com.google.cloud.dialogflow.cx.v3beta1;

import com.google.api.core.BetaApi;
import com.google.cloud.dialogflow.cx.v3beta1.SessionsGrpc.SessionsImplBase;
import com.google.protobuf.AbstractMessage;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockSessionsImpl extends SessionsImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockSessionsImpl() {
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
  public void detectIntent(
      DetectIntentRequest request, StreamObserver<DetectIntentResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DetectIntentResponse) {
      requests.add(request);
      responseObserver.onNext(((DetectIntentResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DetectIntent, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DetectIntentResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public StreamObserver<StreamingDetectIntentRequest> streamingDetectIntent(
      final StreamObserver<StreamingDetectIntentResponse> responseObserver) {
    StreamObserver<StreamingDetectIntentRequest> requestObserver =
        new StreamObserver<StreamingDetectIntentRequest>() {
          @Override
          public void onNext(StreamingDetectIntentRequest value) {
            requests.add(value);
            final Object response = responses.remove();
            if (response instanceof StreamingDetectIntentResponse) {
              responseObserver.onNext(((StreamingDetectIntentResponse) response));
            } else if (response instanceof Exception) {
              responseObserver.onError(((Exception) response));
            } else {
              responseObserver.onError(
                  new IllegalArgumentException(
                      String.format(
                          "Unrecognized response type %s for method StreamingDetectIntent, expected %s or %s",
                          response == null ? "null" : response.getClass().getName(),
                          StreamingDetectIntentResponse.class.getName(),
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
  public void matchIntent(
      MatchIntentRequest request, StreamObserver<MatchIntentResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof MatchIntentResponse) {
      requests.add(request);
      responseObserver.onNext(((MatchIntentResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method MatchIntent, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  MatchIntentResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void fulfillIntent(
      FulfillIntentRequest request, StreamObserver<FulfillIntentResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FulfillIntentResponse) {
      requests.add(request);
      responseObserver.onNext(((FulfillIntentResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method FulfillIntent, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  FulfillIntentResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
