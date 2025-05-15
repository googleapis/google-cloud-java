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

package com.google.cloud.chronicle.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.chronicle.v1.RuleServiceGrpc.RuleServiceImplBase;
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
public class MockRuleServiceImpl extends RuleServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockRuleServiceImpl() {
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
  public void createRule(CreateRuleRequest request, StreamObserver<Rule> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Rule) {
      requests.add(request);
      responseObserver.onNext(((Rule) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateRule, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Rule.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getRule(GetRuleRequest request, StreamObserver<Rule> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Rule) {
      requests.add(request);
      responseObserver.onNext(((Rule) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetRule, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Rule.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listRules(
      ListRulesRequest request, StreamObserver<ListRulesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListRulesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListRulesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListRules, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListRulesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateRule(UpdateRuleRequest request, StreamObserver<Rule> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Rule) {
      requests.add(request);
      responseObserver.onNext(((Rule) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateRule, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Rule.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteRule(DeleteRuleRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteRule, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listRuleRevisions(
      ListRuleRevisionsRequest request,
      StreamObserver<ListRuleRevisionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListRuleRevisionsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListRuleRevisionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListRuleRevisions, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListRuleRevisionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createRetrohunt(
      CreateRetrohuntRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateRetrohunt, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getRetrohunt(
      GetRetrohuntRequest request, StreamObserver<Retrohunt> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Retrohunt) {
      requests.add(request);
      responseObserver.onNext(((Retrohunt) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetRetrohunt, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Retrohunt.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listRetrohunts(
      ListRetrohuntsRequest request, StreamObserver<ListRetrohuntsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListRetrohuntsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListRetrohuntsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListRetrohunts, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListRetrohuntsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getRuleDeployment(
      GetRuleDeploymentRequest request, StreamObserver<RuleDeployment> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RuleDeployment) {
      requests.add(request);
      responseObserver.onNext(((RuleDeployment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetRuleDeployment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RuleDeployment.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listRuleDeployments(
      ListRuleDeploymentsRequest request,
      StreamObserver<ListRuleDeploymentsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListRuleDeploymentsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListRuleDeploymentsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListRuleDeployments, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListRuleDeploymentsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateRuleDeployment(
      UpdateRuleDeploymentRequest request, StreamObserver<RuleDeployment> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RuleDeployment) {
      requests.add(request);
      responseObserver.onNext(((RuleDeployment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateRuleDeployment, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  RuleDeployment.class.getName(),
                  Exception.class.getName())));
    }
  }
}
