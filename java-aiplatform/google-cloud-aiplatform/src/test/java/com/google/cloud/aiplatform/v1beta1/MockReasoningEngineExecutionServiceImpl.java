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

package com.google.cloud.aiplatform.v1beta1;

import com.google.api.HttpBody;
import com.google.api.core.BetaApi;
import com.google.cloud.aiplatform.v1beta1.ReasoningEngineExecutionServiceGrpc.ReasoningEngineExecutionServiceImplBase;
import com.google.protobuf.AbstractMessage;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockReasoningEngineExecutionServiceImpl
    extends ReasoningEngineExecutionServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockReasoningEngineExecutionServiceImpl() {
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
  public void queryReasoningEngine(
      QueryReasoningEngineRequest request,
      StreamObserver<QueryReasoningEngineResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof QueryReasoningEngineResponse) {
      requests.add(request);
      responseObserver.onNext(((QueryReasoningEngineResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method QueryReasoningEngine, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  QueryReasoningEngineResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void streamQueryReasoningEngine(
      StreamQueryReasoningEngineRequest request, StreamObserver<HttpBody> responseObserver) {
    Object response = responses.poll();
    if (response instanceof HttpBody) {
      requests.add(request);
      responseObserver.onNext(((HttpBody) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method StreamQueryReasoningEngine, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  HttpBody.class.getName(),
                  Exception.class.getName())));
    }
  }
}
