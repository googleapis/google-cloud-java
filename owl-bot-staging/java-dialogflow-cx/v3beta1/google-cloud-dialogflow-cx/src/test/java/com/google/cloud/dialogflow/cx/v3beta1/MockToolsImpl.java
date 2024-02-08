/*
 * Copyright 2023 Google LLC
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
import com.google.cloud.dialogflow.cx.v3beta1.ToolsGrpc.ToolsImplBase;
import com.google.longrunning.Operation;
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
public class MockToolsImpl extends ToolsImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockToolsImpl() {
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
  public void createTool(CreateToolRequest request, StreamObserver<Tool> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Tool) {
      requests.add(request);
      responseObserver.onNext(((Tool) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateTool, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Tool.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listTools(
      ListToolsRequest request, StreamObserver<ListToolsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListToolsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListToolsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListTools, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListToolsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void exportTools(ExportToolsRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method ExportTools, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getTool(GetToolRequest request, StreamObserver<Tool> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Tool) {
      requests.add(request);
      responseObserver.onNext(((Tool) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetTool, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Tool.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateTool(UpdateToolRequest request, StreamObserver<Tool> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Tool) {
      requests.add(request);
      responseObserver.onNext(((Tool) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateTool, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Tool.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteTool(DeleteToolRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteTool, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }
}
