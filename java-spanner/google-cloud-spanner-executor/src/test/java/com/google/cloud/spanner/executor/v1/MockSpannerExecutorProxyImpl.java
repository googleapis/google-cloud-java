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

package com.google.cloud.spanner.executor.v1;

import com.google.api.core.BetaApi;
import com.google.protobuf.AbstractMessage;
import com.google.spanner.executor.v1.SpannerAsyncActionRequest;
import com.google.spanner.executor.v1.SpannerAsyncActionResponse;
import com.google.spanner.executor.v1.SpannerExecutorProxyGrpc.SpannerExecutorProxyImplBase;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockSpannerExecutorProxyImpl extends SpannerExecutorProxyImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockSpannerExecutorProxyImpl() {
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
  public StreamObserver<SpannerAsyncActionRequest> executeActionAsync(
      final StreamObserver<SpannerAsyncActionResponse> responseObserver) {
    StreamObserver<SpannerAsyncActionRequest> requestObserver =
        new StreamObserver<SpannerAsyncActionRequest>() {
          @Override
          public void onNext(SpannerAsyncActionRequest value) {
            requests.add(value);
            final Object response = responses.remove();
            if (response instanceof SpannerAsyncActionResponse) {
              responseObserver.onNext(((SpannerAsyncActionResponse) response));
            } else if (response instanceof Exception) {
              responseObserver.onError(((Exception) response));
            } else {
              responseObserver.onError(
                  new IllegalArgumentException(
                      String.format(
                          "Unrecognized response type %s for method ExecuteActionAsync, expected %s"
                              + " or %s",
                          response == null ? "null" : response.getClass().getName(),
                          SpannerAsyncActionResponse.class.getName(),
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
