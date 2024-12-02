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

package com.google.cloud.discoveryengine.v1beta;

import com.google.api.core.BetaApi;
import com.google.cloud.discoveryengine.v1beta.GroundedGenerationServiceGrpc.GroundedGenerationServiceImplBase;
import com.google.protobuf.AbstractMessage;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockGroundedGenerationServiceImpl extends GroundedGenerationServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockGroundedGenerationServiceImpl() {
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
  public StreamObserver<GenerateGroundedContentRequest> streamGenerateGroundedContent(
      final StreamObserver<GenerateGroundedContentResponse> responseObserver) {
    StreamObserver<GenerateGroundedContentRequest> requestObserver =
        new StreamObserver<GenerateGroundedContentRequest>() {
          @Override
          public void onNext(GenerateGroundedContentRequest value) {
            requests.add(value);
            final Object response = responses.remove();
            if (response instanceof GenerateGroundedContentResponse) {
              responseObserver.onNext(((GenerateGroundedContentResponse) response));
            } else if (response instanceof Exception) {
              responseObserver.onError(((Exception) response));
            } else {
              responseObserver.onError(
                  new IllegalArgumentException(
                      String.format(
                          "Unrecognized response type %s for method StreamGenerateGroundedContent,"
                              + " expected %s or %s",
                          response == null ? "null" : response.getClass().getName(),
                          GenerateGroundedContentResponse.class.getName(),
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
  public void generateGroundedContent(
      GenerateGroundedContentRequest request,
      StreamObserver<GenerateGroundedContentResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof GenerateGroundedContentResponse) {
      requests.add(request);
      responseObserver.onNext(((GenerateGroundedContentResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GenerateGroundedContent, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  GenerateGroundedContentResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void checkGrounding(
      CheckGroundingRequest request, StreamObserver<CheckGroundingResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CheckGroundingResponse) {
      requests.add(request);
      responseObserver.onNext(((CheckGroundingResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CheckGrounding, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CheckGroundingResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
