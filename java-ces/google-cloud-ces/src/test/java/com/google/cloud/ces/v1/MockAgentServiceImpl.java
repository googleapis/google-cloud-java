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
import com.google.cloud.ces.v1.AgentServiceGrpc.AgentServiceImplBase;
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
public class MockAgentServiceImpl extends AgentServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockAgentServiceImpl() {
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
  public void listApps(ListAppsRequest request, StreamObserver<ListAppsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListAppsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListAppsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListApps, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListAppsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getApp(GetAppRequest request, StreamObserver<App> responseObserver) {
    Object response = responses.poll();
    if (response instanceof App) {
      requests.add(request);
      responseObserver.onNext(((App) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetApp, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  App.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createApp(CreateAppRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateApp, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateApp(UpdateAppRequest request, StreamObserver<App> responseObserver) {
    Object response = responses.poll();
    if (response instanceof App) {
      requests.add(request);
      responseObserver.onNext(((App) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateApp, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  App.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteApp(DeleteAppRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteApp, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void exportApp(ExportAppRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method ExportApp, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void importApp(ImportAppRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method ImportApp, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
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
  public void listExamples(
      ListExamplesRequest request, StreamObserver<ListExamplesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListExamplesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListExamplesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListExamples, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListExamplesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getExample(GetExampleRequest request, StreamObserver<Example> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Example) {
      requests.add(request);
      responseObserver.onNext(((Example) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetExample, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Example.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createExample(
      CreateExampleRequest request, StreamObserver<Example> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Example) {
      requests.add(request);
      responseObserver.onNext(((Example) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateExample, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Example.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateExample(
      UpdateExampleRequest request, StreamObserver<Example> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Example) {
      requests.add(request);
      responseObserver.onNext(((Example) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateExample, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Example.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteExample(DeleteExampleRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteExample, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
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
  public void listConversations(
      ListConversationsRequest request,
      StreamObserver<ListConversationsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListConversationsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListConversationsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListConversations, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListConversationsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getConversation(
      GetConversationRequest request, StreamObserver<Conversation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Conversation) {
      requests.add(request);
      responseObserver.onNext(((Conversation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetConversation, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Conversation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteConversation(
      DeleteConversationRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteConversation, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void batchDeleteConversations(
      BatchDeleteConversationsRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method BatchDeleteConversations, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
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

  @Override
  public void listGuardrails(
      ListGuardrailsRequest request, StreamObserver<ListGuardrailsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListGuardrailsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListGuardrailsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListGuardrails, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListGuardrailsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getGuardrail(
      GetGuardrailRequest request, StreamObserver<Guardrail> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Guardrail) {
      requests.add(request);
      responseObserver.onNext(((Guardrail) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetGuardrail, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Guardrail.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createGuardrail(
      CreateGuardrailRequest request, StreamObserver<Guardrail> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Guardrail) {
      requests.add(request);
      responseObserver.onNext(((Guardrail) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateGuardrail, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Guardrail.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateGuardrail(
      UpdateGuardrailRequest request, StreamObserver<Guardrail> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Guardrail) {
      requests.add(request);
      responseObserver.onNext(((Guardrail) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateGuardrail, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Guardrail.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteGuardrail(
      DeleteGuardrailRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteGuardrail, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listDeployments(
      ListDeploymentsRequest request, StreamObserver<ListDeploymentsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListDeploymentsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListDeploymentsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListDeployments, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListDeploymentsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getDeployment(
      GetDeploymentRequest request, StreamObserver<Deployment> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Deployment) {
      requests.add(request);
      responseObserver.onNext(((Deployment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetDeployment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Deployment.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createDeployment(
      CreateDeploymentRequest request, StreamObserver<Deployment> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Deployment) {
      requests.add(request);
      responseObserver.onNext(((Deployment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateDeployment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Deployment.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateDeployment(
      UpdateDeploymentRequest request, StreamObserver<Deployment> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Deployment) {
      requests.add(request);
      responseObserver.onNext(((Deployment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateDeployment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Deployment.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteDeployment(
      DeleteDeploymentRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteDeployment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listToolsets(
      ListToolsetsRequest request, StreamObserver<ListToolsetsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListToolsetsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListToolsetsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListToolsets, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListToolsetsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getToolset(GetToolsetRequest request, StreamObserver<Toolset> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Toolset) {
      requests.add(request);
      responseObserver.onNext(((Toolset) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetToolset, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Toolset.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createToolset(
      CreateToolsetRequest request, StreamObserver<Toolset> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Toolset) {
      requests.add(request);
      responseObserver.onNext(((Toolset) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateToolset, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Toolset.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateToolset(
      UpdateToolsetRequest request, StreamObserver<Toolset> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Toolset) {
      requests.add(request);
      responseObserver.onNext(((Toolset) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateToolset, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Toolset.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteToolset(DeleteToolsetRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteToolset, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listAppVersions(
      ListAppVersionsRequest request, StreamObserver<ListAppVersionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListAppVersionsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListAppVersionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListAppVersions, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListAppVersionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getAppVersion(
      GetAppVersionRequest request, StreamObserver<AppVersion> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AppVersion) {
      requests.add(request);
      responseObserver.onNext(((AppVersion) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetAppVersion, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AppVersion.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createAppVersion(
      CreateAppVersionRequest request, StreamObserver<AppVersion> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AppVersion) {
      requests.add(request);
      responseObserver.onNext(((AppVersion) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateAppVersion, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AppVersion.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteAppVersion(
      DeleteAppVersionRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteAppVersion, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void restoreAppVersion(
      RestoreAppVersionRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method RestoreAppVersion, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listChangelogs(
      ListChangelogsRequest request, StreamObserver<ListChangelogsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListChangelogsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListChangelogsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListChangelogs, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListChangelogsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getChangelog(
      GetChangelogRequest request, StreamObserver<Changelog> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Changelog) {
      requests.add(request);
      responseObserver.onNext(((Changelog) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetChangelog, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Changelog.class.getName(),
                  Exception.class.getName())));
    }
  }
}
