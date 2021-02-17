/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.speech.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.speech.v1.SpeechGrpc.SpeechImplBase;
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
public class MockSpeechImpl extends SpeechImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockSpeechImpl() {
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
  public void recognize(
      RecognizeRequest request, StreamObserver<RecognizeResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof RecognizeResponse) {
      requests.add(request);
      responseObserver.onNext(((RecognizeResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method Recognize, expected %s or %s",
                  response.getClass().getName(),
                  RecognizeResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void longRunningRecognize(
      LongRunningRecognizeRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.remove();
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
                  "Unrecognized response type %s for method LongRunningRecognize, expected %s or %s",
                  response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public StreamObserver<StreamingRecognizeRequest> streamingRecognize(
      final StreamObserver<StreamingRecognizeResponse> responseObserver) {
    StreamObserver<StreamingRecognizeRequest> requestObserver =
        new StreamObserver<StreamingRecognizeRequest>() {
          @Override
          public void onNext(StreamingRecognizeRequest value) {
            requests.add(value);
            final Object response = responses.remove();
            if (response instanceof StreamingRecognizeResponse) {
              responseObserver.onNext(((StreamingRecognizeResponse) response));
            } else if (response instanceof Exception) {
              responseObserver.onError(((Exception) response));
            } else {
              responseObserver.onError(
                  new IllegalArgumentException(
                      String.format(
                          "Unrecognized response type %s for method StreamingRecognize, expected %s or %s",
                          response.getClass().getName(),
                          StreamingRecognizeResponse.class.getName(),
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
