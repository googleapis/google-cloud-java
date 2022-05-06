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

package com.google.appengine.v1;

import com.google.api.core.BetaApi;
import com.google.appengine.v1.FirewallGrpc.FirewallImplBase;
import com.google.appengine.v1.firewall.FirewallRule;
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
public class MockFirewallImpl extends FirewallImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockFirewallImpl() {
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
  public void listIngressRules(
      ListIngressRulesRequest request, StreamObserver<ListIngressRulesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListIngressRulesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListIngressRulesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListIngressRules, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListIngressRulesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void batchUpdateIngressRules(
      BatchUpdateIngressRulesRequest request,
      StreamObserver<BatchUpdateIngressRulesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof BatchUpdateIngressRulesResponse) {
      requests.add(request);
      responseObserver.onNext(((BatchUpdateIngressRulesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method BatchUpdateIngressRules, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  BatchUpdateIngressRulesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createIngressRule(
      CreateIngressRuleRequest request, StreamObserver<FirewallRule> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FirewallRule) {
      requests.add(request);
      responseObserver.onNext(((FirewallRule) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateIngressRule, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  FirewallRule.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getIngressRule(
      GetIngressRuleRequest request, StreamObserver<FirewallRule> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FirewallRule) {
      requests.add(request);
      responseObserver.onNext(((FirewallRule) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetIngressRule, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  FirewallRule.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateIngressRule(
      UpdateIngressRuleRequest request, StreamObserver<FirewallRule> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FirewallRule) {
      requests.add(request);
      responseObserver.onNext(((FirewallRule) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateIngressRule, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  FirewallRule.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteIngressRule(
      DeleteIngressRuleRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteIngressRule, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }
}
