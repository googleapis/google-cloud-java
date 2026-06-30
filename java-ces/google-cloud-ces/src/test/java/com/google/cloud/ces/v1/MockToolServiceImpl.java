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

package com.google.cloud.ces.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.ces.v1.ToolServiceGrpc.ToolServiceImplBase;
import com.google.protobuf.AbstractMessage;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockToolServiceImpl extends ToolServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockToolServiceImpl() {
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
  public void executeTool(
      ExecuteToolRequest request, StreamObserver<ExecuteToolResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ExecuteToolResponse) {
      requests.add(request);
      responseObserver.onNext(((ExecuteToolResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ExecuteTool, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ExecuteToolResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void retrieveToolSchema(
      RetrieveToolSchemaRequest request,
      StreamObserver<RetrieveToolSchemaResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RetrieveToolSchemaResponse) {
      requests.add(request);
      responseObserver.onNext(((RetrieveToolSchemaResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RetrieveToolSchema, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RetrieveToolSchemaResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void retrieveTools(
      RetrieveToolsRequest request, StreamObserver<RetrieveToolsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RetrieveToolsResponse) {
      requests.add(request);
      responseObserver.onNext(((RetrieveToolsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RetrieveTools, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RetrieveToolsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
