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

package com.google.cloud.vertexai.api;

import com.google.api.core.BetaApi;
import com.google.cloud.vertexai.api.LlmUtilityServiceGrpc.LlmUtilityServiceImplBase;
import com.google.protobuf.AbstractMessage;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockLlmUtilityServiceImpl extends LlmUtilityServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockLlmUtilityServiceImpl() {
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
  public void countTokens(
      CountTokensRequest request, StreamObserver<CountTokensResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CountTokensResponse) {
      requests.add(request);
      responseObserver.onNext(((CountTokensResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CountTokens, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CountTokensResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void computeTokens(
      ComputeTokensRequest request, StreamObserver<ComputeTokensResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ComputeTokensResponse) {
      requests.add(request);
      responseObserver.onNext(((ComputeTokensResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ComputeTokens, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ComputeTokensResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
