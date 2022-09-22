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

package com.google.cloud.dataproc.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.dataproc.v1.AutoscalingPolicyServiceGrpc.AutoscalingPolicyServiceImplBase;
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
public class MockAutoscalingPolicyServiceImpl extends AutoscalingPolicyServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockAutoscalingPolicyServiceImpl() {
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
  public void createAutoscalingPolicy(
      CreateAutoscalingPolicyRequest request, StreamObserver<AutoscalingPolicy> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AutoscalingPolicy) {
      requests.add(request);
      responseObserver.onNext(((AutoscalingPolicy) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateAutoscalingPolicy, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AutoscalingPolicy.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateAutoscalingPolicy(
      UpdateAutoscalingPolicyRequest request, StreamObserver<AutoscalingPolicy> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AutoscalingPolicy) {
      requests.add(request);
      responseObserver.onNext(((AutoscalingPolicy) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateAutoscalingPolicy, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AutoscalingPolicy.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getAutoscalingPolicy(
      GetAutoscalingPolicyRequest request, StreamObserver<AutoscalingPolicy> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AutoscalingPolicy) {
      requests.add(request);
      responseObserver.onNext(((AutoscalingPolicy) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetAutoscalingPolicy, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AutoscalingPolicy.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listAutoscalingPolicies(
      ListAutoscalingPoliciesRequest request,
      StreamObserver<ListAutoscalingPoliciesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListAutoscalingPoliciesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListAutoscalingPoliciesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListAutoscalingPolicies, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListAutoscalingPoliciesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteAutoscalingPolicy(
      DeleteAutoscalingPolicyRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteAutoscalingPolicy, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }
}
