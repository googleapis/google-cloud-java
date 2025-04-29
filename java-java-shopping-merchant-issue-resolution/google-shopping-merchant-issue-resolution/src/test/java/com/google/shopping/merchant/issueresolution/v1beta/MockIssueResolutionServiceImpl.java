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

package com.google.shopping.merchant.issueresolution.v1beta;

import com.google.api.core.BetaApi;
import com.google.protobuf.AbstractMessage;
import com.google.shopping.merchant.issueresolution.v1beta.IssueResolutionServiceGrpc.IssueResolutionServiceImplBase;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockIssueResolutionServiceImpl extends IssueResolutionServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockIssueResolutionServiceImpl() {
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
  public void renderAccountIssues(
      RenderAccountIssuesRequest request,
      StreamObserver<RenderAccountIssuesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RenderAccountIssuesResponse) {
      requests.add(request);
      responseObserver.onNext(((RenderAccountIssuesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RenderAccountIssues, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RenderAccountIssuesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void renderProductIssues(
      RenderProductIssuesRequest request,
      StreamObserver<RenderProductIssuesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RenderProductIssuesResponse) {
      requests.add(request);
      responseObserver.onNext(((RenderProductIssuesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RenderProductIssues, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RenderProductIssuesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void triggerAction(
      TriggerActionRequest request, StreamObserver<TriggerActionResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof TriggerActionResponse) {
      requests.add(request);
      responseObserver.onNext(((TriggerActionResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method TriggerAction, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  TriggerActionResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
