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

package com.google.cloud.networksecurity.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.networksecurity.v1.NetworkSecurityGrpc.NetworkSecurityImplBase;
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
public class MockNetworkSecurityImpl extends NetworkSecurityImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockNetworkSecurityImpl() {
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
  public void listAuthorizationPolicies(
      ListAuthorizationPoliciesRequest request,
      StreamObserver<ListAuthorizationPoliciesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListAuthorizationPoliciesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListAuthorizationPoliciesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListAuthorizationPolicies, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListAuthorizationPoliciesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getAuthorizationPolicy(
      GetAuthorizationPolicyRequest request, StreamObserver<AuthorizationPolicy> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AuthorizationPolicy) {
      requests.add(request);
      responseObserver.onNext(((AuthorizationPolicy) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetAuthorizationPolicy, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  AuthorizationPolicy.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createAuthorizationPolicy(
      CreateAuthorizationPolicyRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateAuthorizationPolicy, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateAuthorizationPolicy(
      UpdateAuthorizationPolicyRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateAuthorizationPolicy, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteAuthorizationPolicy(
      DeleteAuthorizationPolicyRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteAuthorizationPolicy, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listBackendAuthenticationConfigs(
      ListBackendAuthenticationConfigsRequest request,
      StreamObserver<ListBackendAuthenticationConfigsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListBackendAuthenticationConfigsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListBackendAuthenticationConfigsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListBackendAuthenticationConfigs,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListBackendAuthenticationConfigsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getBackendAuthenticationConfig(
      GetBackendAuthenticationConfigRequest request,
      StreamObserver<BackendAuthenticationConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof BackendAuthenticationConfig) {
      requests.add(request);
      responseObserver.onNext(((BackendAuthenticationConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetBackendAuthenticationConfig,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  BackendAuthenticationConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createBackendAuthenticationConfig(
      CreateBackendAuthenticationConfigRequest request,
      StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateBackendAuthenticationConfig,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateBackendAuthenticationConfig(
      UpdateBackendAuthenticationConfigRequest request,
      StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateBackendAuthenticationConfig,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteBackendAuthenticationConfig(
      DeleteBackendAuthenticationConfigRequest request,
      StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteBackendAuthenticationConfig,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listServerTlsPolicies(
      ListServerTlsPoliciesRequest request,
      StreamObserver<ListServerTlsPoliciesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListServerTlsPoliciesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListServerTlsPoliciesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListServerTlsPolicies, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListServerTlsPoliciesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getServerTlsPolicy(
      GetServerTlsPolicyRequest request, StreamObserver<ServerTlsPolicy> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ServerTlsPolicy) {
      requests.add(request);
      responseObserver.onNext(((ServerTlsPolicy) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetServerTlsPolicy, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ServerTlsPolicy.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createServerTlsPolicy(
      CreateServerTlsPolicyRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateServerTlsPolicy, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateServerTlsPolicy(
      UpdateServerTlsPolicyRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateServerTlsPolicy, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteServerTlsPolicy(
      DeleteServerTlsPolicyRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteServerTlsPolicy, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listClientTlsPolicies(
      ListClientTlsPoliciesRequest request,
      StreamObserver<ListClientTlsPoliciesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListClientTlsPoliciesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListClientTlsPoliciesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListClientTlsPolicies, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListClientTlsPoliciesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getClientTlsPolicy(
      GetClientTlsPolicyRequest request, StreamObserver<ClientTlsPolicy> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ClientTlsPolicy) {
      requests.add(request);
      responseObserver.onNext(((ClientTlsPolicy) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetClientTlsPolicy, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ClientTlsPolicy.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createClientTlsPolicy(
      CreateClientTlsPolicyRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateClientTlsPolicy, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateClientTlsPolicy(
      UpdateClientTlsPolicyRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateClientTlsPolicy, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteClientTlsPolicy(
      DeleteClientTlsPolicyRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteClientTlsPolicy, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listGatewaySecurityPolicies(
      ListGatewaySecurityPoliciesRequest request,
      StreamObserver<ListGatewaySecurityPoliciesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListGatewaySecurityPoliciesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListGatewaySecurityPoliciesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListGatewaySecurityPolicies, expected"
                      + " %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListGatewaySecurityPoliciesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getGatewaySecurityPolicy(
      GetGatewaySecurityPolicyRequest request,
      StreamObserver<GatewaySecurityPolicy> responseObserver) {
    Object response = responses.poll();
    if (response instanceof GatewaySecurityPolicy) {
      requests.add(request);
      responseObserver.onNext(((GatewaySecurityPolicy) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetGatewaySecurityPolicy, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  GatewaySecurityPolicy.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createGatewaySecurityPolicy(
      CreateGatewaySecurityPolicyRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateGatewaySecurityPolicy, expected"
                      + " %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateGatewaySecurityPolicy(
      UpdateGatewaySecurityPolicyRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateGatewaySecurityPolicy, expected"
                      + " %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteGatewaySecurityPolicy(
      DeleteGatewaySecurityPolicyRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteGatewaySecurityPolicy, expected"
                      + " %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listGatewaySecurityPolicyRules(
      ListGatewaySecurityPolicyRulesRequest request,
      StreamObserver<ListGatewaySecurityPolicyRulesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListGatewaySecurityPolicyRulesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListGatewaySecurityPolicyRulesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListGatewaySecurityPolicyRules,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListGatewaySecurityPolicyRulesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getGatewaySecurityPolicyRule(
      GetGatewaySecurityPolicyRuleRequest request,
      StreamObserver<GatewaySecurityPolicyRule> responseObserver) {
    Object response = responses.poll();
    if (response instanceof GatewaySecurityPolicyRule) {
      requests.add(request);
      responseObserver.onNext(((GatewaySecurityPolicyRule) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetGatewaySecurityPolicyRule, expected"
                      + " %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  GatewaySecurityPolicyRule.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createGatewaySecurityPolicyRule(
      CreateGatewaySecurityPolicyRuleRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateGatewaySecurityPolicyRule,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateGatewaySecurityPolicyRule(
      UpdateGatewaySecurityPolicyRuleRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateGatewaySecurityPolicyRule,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteGatewaySecurityPolicyRule(
      DeleteGatewaySecurityPolicyRuleRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteGatewaySecurityPolicyRule,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listUrlLists(
      ListUrlListsRequest request, StreamObserver<ListUrlListsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListUrlListsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListUrlListsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListUrlLists, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListUrlListsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getUrlList(GetUrlListRequest request, StreamObserver<UrlList> responseObserver) {
    Object response = responses.poll();
    if (response instanceof UrlList) {
      requests.add(request);
      responseObserver.onNext(((UrlList) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetUrlList, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  UrlList.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createUrlList(
      CreateUrlListRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateUrlList, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateUrlList(
      UpdateUrlListRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateUrlList, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteUrlList(
      DeleteUrlListRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteUrlList, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listTlsInspectionPolicies(
      ListTlsInspectionPoliciesRequest request,
      StreamObserver<ListTlsInspectionPoliciesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListTlsInspectionPoliciesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListTlsInspectionPoliciesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListTlsInspectionPolicies, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListTlsInspectionPoliciesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getTlsInspectionPolicy(
      GetTlsInspectionPolicyRequest request, StreamObserver<TlsInspectionPolicy> responseObserver) {
    Object response = responses.poll();
    if (response instanceof TlsInspectionPolicy) {
      requests.add(request);
      responseObserver.onNext(((TlsInspectionPolicy) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetTlsInspectionPolicy, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  TlsInspectionPolicy.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createTlsInspectionPolicy(
      CreateTlsInspectionPolicyRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateTlsInspectionPolicy, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateTlsInspectionPolicy(
      UpdateTlsInspectionPolicyRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateTlsInspectionPolicy, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteTlsInspectionPolicy(
      DeleteTlsInspectionPolicyRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteTlsInspectionPolicy, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listAuthzPolicies(
      ListAuthzPoliciesRequest request,
      StreamObserver<ListAuthzPoliciesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListAuthzPoliciesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListAuthzPoliciesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListAuthzPolicies, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListAuthzPoliciesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getAuthzPolicy(
      GetAuthzPolicyRequest request, StreamObserver<AuthzPolicy> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AuthzPolicy) {
      requests.add(request);
      responseObserver.onNext(((AuthzPolicy) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetAuthzPolicy, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AuthzPolicy.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createAuthzPolicy(
      CreateAuthzPolicyRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateAuthzPolicy, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateAuthzPolicy(
      UpdateAuthzPolicyRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateAuthzPolicy, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteAuthzPolicy(
      DeleteAuthzPolicyRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteAuthzPolicy, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }
}
