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

package com.google.cloud.agentregistry.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.agentregistry.v1.AgentRegistryGrpc.AgentRegistryImplBase;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockAgentRegistryImpl extends AgentRegistryImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockAgentRegistryImpl() {
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
  public void searchAgents(
      SearchAgentsRequest request, StreamObserver<SearchAgentsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SearchAgentsResponse) {
      requests.add(request);
      responseObserver.onNext(((SearchAgentsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SearchAgents, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SearchAgentsResponse.class.getName(),
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
  public void listEndpoints(
      ListEndpointsRequest request, StreamObserver<ListEndpointsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListEndpointsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListEndpointsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListEndpoints, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListEndpointsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getEndpoint(GetEndpointRequest request, StreamObserver<Endpoint> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Endpoint) {
      requests.add(request);
      responseObserver.onNext(((Endpoint) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetEndpoint, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Endpoint.class.getName(),
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
  public void searchMcpServers(
      SearchMcpServersRequest request, StreamObserver<SearchMcpServersResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SearchMcpServersResponse) {
      requests.add(request);
      responseObserver.onNext(((SearchMcpServersResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SearchMcpServers, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SearchMcpServersResponse.class.getName(),
                  Exception.class.getName())));
    }
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
  public void listServices(
      ListServicesRequest request, StreamObserver<ListServicesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListServicesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListServicesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListServices, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListServicesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getService(GetServiceRequest request, StreamObserver<Service> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Service) {
      requests.add(request);
      responseObserver.onNext(((Service) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetService, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Service.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createService(
      CreateServiceRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateService, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateService(
      UpdateServiceRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateService, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteService(
      DeleteServiceRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteService, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listBindings(
      ListBindingsRequest request, StreamObserver<ListBindingsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListBindingsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListBindingsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListBindings, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListBindingsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getBinding(GetBindingRequest request, StreamObserver<Binding> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Binding) {
      requests.add(request);
      responseObserver.onNext(((Binding) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetBinding, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Binding.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createBinding(
      CreateBindingRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateBinding, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateBinding(
      UpdateBindingRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateBinding, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteBinding(
      DeleteBindingRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteBinding, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void fetchAvailableBindings(
      FetchAvailableBindingsRequest request,
      StreamObserver<FetchAvailableBindingsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FetchAvailableBindingsResponse) {
      requests.add(request);
      responseObserver.onNext(((FetchAvailableBindingsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method FetchAvailableBindings, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  FetchAvailableBindingsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
