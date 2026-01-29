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

package com.google.cloud.apiregistry.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.apiregistry.v1.CloudApiRegistryGrpc.CloudApiRegistryImplBase;
import com.google.protobuf.AbstractMessage;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockCloudApiRegistryImpl extends CloudApiRegistryImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockCloudApiRegistryImpl() {
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
  public void getMcpServer(
      GetMcpServerRequest request, StreamObserver<McpServer> responseObserver) {
    Object response = responses.poll();
    if (response instanceof McpServer) {
      requests.add(request);
      responseObserver.onNext(((McpServer) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetMcpServer, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  McpServer.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listMcpServers(
      ListMcpServersRequest request, StreamObserver<ListMcpServersResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListMcpServersResponse) {
      requests.add(request);
      responseObserver.onNext(((ListMcpServersResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListMcpServers, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListMcpServersResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getMcpTool(GetMcpToolRequest request, StreamObserver<McpTool> responseObserver) {
    Object response = responses.poll();
    if (response instanceof McpTool) {
      requests.add(request);
      responseObserver.onNext(((McpTool) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetMcpTool, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  McpTool.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listMcpTools(
      ListMcpToolsRequest request, StreamObserver<ListMcpToolsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListMcpToolsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListMcpToolsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListMcpTools, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListMcpToolsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
