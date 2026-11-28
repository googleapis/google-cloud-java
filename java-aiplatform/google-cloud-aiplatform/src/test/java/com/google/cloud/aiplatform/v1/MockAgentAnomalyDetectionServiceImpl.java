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

package com.google.cloud.aiplatform.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.aiplatform.v1.AgentAnomalyDetectionServiceGrpc.AgentAnomalyDetectionServiceImplBase;
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
public class MockAgentAnomalyDetectionServiceImpl extends AgentAnomalyDetectionServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockAgentAnomalyDetectionServiceImpl() {
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
  public void getAgentAnomalyDetectionScope(
      GetAgentAnomalyDetectionScopeRequest request,
      StreamObserver<AgentAnomalyDetectionScope> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AgentAnomalyDetectionScope) {
      requests.add(request);
      responseObserver.onNext(((AgentAnomalyDetectionScope) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetAgentAnomalyDetectionScope, expected"
                      + " %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AgentAnomalyDetectionScope.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getMonitoredAgent(
      GetMonitoredAgentRequest request, StreamObserver<MonitoredAgent> responseObserver) {
    Object response = responses.poll();
    if (response instanceof MonitoredAgent) {
      requests.add(request);
      responseObserver.onNext(((MonitoredAgent) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetMonitoredAgent, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  MonitoredAgent.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listMonitoredAgents(
      ListMonitoredAgentsRequest request,
      StreamObserver<ListMonitoredAgentsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListMonitoredAgentsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListMonitoredAgentsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListMonitoredAgents, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListMonitoredAgentsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void enableMonitoredAgent(
      EnableMonitoredAgentRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method EnableMonitoredAgent, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void disableMonitoredAgent(
      DisableMonitoredAgentRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DisableMonitoredAgent, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteAgentAnomalyDetectionScope(
      DeleteAgentAnomalyDetectionScopeRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteAgentAnomalyDetectionScope,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createAgentAnomalyDetectionScope(
      CreateAgentAnomalyDetectionScopeRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateAgentAnomalyDetectionScope,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listAgentAnomalyDetectionScopes(
      ListAgentAnomalyDetectionScopesRequest request,
      StreamObserver<ListAgentAnomalyDetectionScopesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListAgentAnomalyDetectionScopesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListAgentAnomalyDetectionScopesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListAgentAnomalyDetectionScopes,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListAgentAnomalyDetectionScopesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listAnalyzedSessions(
      ListAnalyzedSessionsRequest request,
      StreamObserver<ListAnalyzedSessionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListAnalyzedSessionsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListAnalyzedSessionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListAnalyzedSessions, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListAnalyzedSessionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getAnalyzedSession(
      GetAnalyzedSessionRequest request, StreamObserver<AnalyzedSession> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AnalyzedSession) {
      requests.add(request);
      responseObserver.onNext(((AnalyzedSession) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetAnalyzedSession, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AnalyzedSession.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listAnalyzedInvocations(
      ListAnalyzedInvocationsRequest request,
      StreamObserver<ListAnalyzedInvocationsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListAnalyzedInvocationsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListAnalyzedInvocationsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListAnalyzedInvocations, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListAnalyzedInvocationsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getAnalyzedInvocation(
      GetAnalyzedInvocationRequest request, StreamObserver<AnalyzedInvocation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AnalyzedInvocation) {
      requests.add(request);
      responseObserver.onNext(((AnalyzedInvocation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetAnalyzedInvocation, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  AnalyzedInvocation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void aggregateAnalyzedSessions(
      AggregateAnalyzedSessionsRequest request,
      StreamObserver<AggregateAnalyzedSessionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AggregateAnalyzedSessionsResponse) {
      requests.add(request);
      responseObserver.onNext(((AggregateAnalyzedSessionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method AggregateAnalyzedSessions, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AggregateAnalyzedSessionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void clearTrainingData(
      ClearTrainingDataRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method ClearTrainingData, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }
}
