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

package com.google.cloud.dialogflow.cx.v3beta1;

import com.google.api.core.BetaApi;
import com.google.cloud.dialogflow.cx.v3beta1.AgentsGrpc.AgentsImplBase;
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
public class MockAgentsImpl extends AgentsImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockAgentsImpl() {
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
  public void listAgents(
      ListAgentsRequest request, StreamObserver<ListAgentsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListAgentsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListAgentsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListAgents, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListAgentsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getAgent(GetAgentRequest request, StreamObserver<Agent> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Agent) {
      requests.add(request);
      responseObserver.onNext(((Agent) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetAgent, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Agent.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createAgent(CreateAgentRequest request, StreamObserver<Agent> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Agent) {
      requests.add(request);
      responseObserver.onNext(((Agent) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateAgent, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Agent.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateAgent(UpdateAgentRequest request, StreamObserver<Agent> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Agent) {
      requests.add(request);
      responseObserver.onNext(((Agent) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateAgent, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Agent.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteAgent(DeleteAgentRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteAgent, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void exportAgent(ExportAgentRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method ExportAgent, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void restoreAgent(
      RestoreAgentRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method RestoreAgent, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void validateAgent(
      ValidateAgentRequest request, StreamObserver<AgentValidationResult> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AgentValidationResult) {
      requests.add(request);
      responseObserver.onNext(((AgentValidationResult) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ValidateAgent, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AgentValidationResult.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getAgentValidationResult(
      GetAgentValidationResultRequest request,
      StreamObserver<AgentValidationResult> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AgentValidationResult) {
      requests.add(request);
      responseObserver.onNext(((AgentValidationResult) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetAgentValidationResult, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AgentValidationResult.class.getName(),
                  Exception.class.getName())));
    }
  }
}
