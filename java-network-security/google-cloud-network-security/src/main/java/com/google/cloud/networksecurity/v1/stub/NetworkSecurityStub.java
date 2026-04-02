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

package com.google.cloud.networksecurity.v1.stub;

import static com.google.cloud.networksecurity.v1.NetworkSecurityClient.ListAuthorizationPoliciesPagedResponse;
import static com.google.cloud.networksecurity.v1.NetworkSecurityClient.ListAuthzPoliciesPagedResponse;
import static com.google.cloud.networksecurity.v1.NetworkSecurityClient.ListBackendAuthenticationConfigsPagedResponse;
import static com.google.cloud.networksecurity.v1.NetworkSecurityClient.ListClientTlsPoliciesPagedResponse;
import static com.google.cloud.networksecurity.v1.NetworkSecurityClient.ListGatewaySecurityPoliciesPagedResponse;
import static com.google.cloud.networksecurity.v1.NetworkSecurityClient.ListGatewaySecurityPolicyRulesPagedResponse;
import static com.google.cloud.networksecurity.v1.NetworkSecurityClient.ListLocationsPagedResponse;
import static com.google.cloud.networksecurity.v1.NetworkSecurityClient.ListServerTlsPoliciesPagedResponse;
import static com.google.cloud.networksecurity.v1.NetworkSecurityClient.ListTlsInspectionPoliciesPagedResponse;
import static com.google.cloud.networksecurity.v1.NetworkSecurityClient.ListUrlListsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.networksecurity.v1.AuthorizationPolicy;
import com.google.cloud.networksecurity.v1.AuthzPolicy;
import com.google.cloud.networksecurity.v1.BackendAuthenticationConfig;
import com.google.cloud.networksecurity.v1.ClientTlsPolicy;
import com.google.cloud.networksecurity.v1.CreateAuthorizationPolicyRequest;
import com.google.cloud.networksecurity.v1.CreateAuthzPolicyRequest;
import com.google.cloud.networksecurity.v1.CreateBackendAuthenticationConfigRequest;
import com.google.cloud.networksecurity.v1.CreateClientTlsPolicyRequest;
import com.google.cloud.networksecurity.v1.CreateGatewaySecurityPolicyRequest;
import com.google.cloud.networksecurity.v1.CreateGatewaySecurityPolicyRuleRequest;
import com.google.cloud.networksecurity.v1.CreateServerTlsPolicyRequest;
import com.google.cloud.networksecurity.v1.CreateTlsInspectionPolicyRequest;
import com.google.cloud.networksecurity.v1.CreateUrlListRequest;
import com.google.cloud.networksecurity.v1.DeleteAuthorizationPolicyRequest;
import com.google.cloud.networksecurity.v1.DeleteAuthzPolicyRequest;
import com.google.cloud.networksecurity.v1.DeleteBackendAuthenticationConfigRequest;
import com.google.cloud.networksecurity.v1.DeleteClientTlsPolicyRequest;
import com.google.cloud.networksecurity.v1.DeleteGatewaySecurityPolicyRequest;
import com.google.cloud.networksecurity.v1.DeleteGatewaySecurityPolicyRuleRequest;
import com.google.cloud.networksecurity.v1.DeleteServerTlsPolicyRequest;
import com.google.cloud.networksecurity.v1.DeleteTlsInspectionPolicyRequest;
import com.google.cloud.networksecurity.v1.DeleteUrlListRequest;
import com.google.cloud.networksecurity.v1.GatewaySecurityPolicy;
import com.google.cloud.networksecurity.v1.GatewaySecurityPolicyRule;
import com.google.cloud.networksecurity.v1.GetAuthorizationPolicyRequest;
import com.google.cloud.networksecurity.v1.GetAuthzPolicyRequest;
import com.google.cloud.networksecurity.v1.GetBackendAuthenticationConfigRequest;
import com.google.cloud.networksecurity.v1.GetClientTlsPolicyRequest;
import com.google.cloud.networksecurity.v1.GetGatewaySecurityPolicyRequest;
import com.google.cloud.networksecurity.v1.GetGatewaySecurityPolicyRuleRequest;
import com.google.cloud.networksecurity.v1.GetServerTlsPolicyRequest;
import com.google.cloud.networksecurity.v1.GetTlsInspectionPolicyRequest;
import com.google.cloud.networksecurity.v1.GetUrlListRequest;
import com.google.cloud.networksecurity.v1.ListAuthorizationPoliciesRequest;
import com.google.cloud.networksecurity.v1.ListAuthorizationPoliciesResponse;
import com.google.cloud.networksecurity.v1.ListAuthzPoliciesRequest;
import com.google.cloud.networksecurity.v1.ListAuthzPoliciesResponse;
import com.google.cloud.networksecurity.v1.ListBackendAuthenticationConfigsRequest;
import com.google.cloud.networksecurity.v1.ListBackendAuthenticationConfigsResponse;
import com.google.cloud.networksecurity.v1.ListClientTlsPoliciesRequest;
import com.google.cloud.networksecurity.v1.ListClientTlsPoliciesResponse;
import com.google.cloud.networksecurity.v1.ListGatewaySecurityPoliciesRequest;
import com.google.cloud.networksecurity.v1.ListGatewaySecurityPoliciesResponse;
import com.google.cloud.networksecurity.v1.ListGatewaySecurityPolicyRulesRequest;
import com.google.cloud.networksecurity.v1.ListGatewaySecurityPolicyRulesResponse;
import com.google.cloud.networksecurity.v1.ListServerTlsPoliciesRequest;
import com.google.cloud.networksecurity.v1.ListServerTlsPoliciesResponse;
import com.google.cloud.networksecurity.v1.ListTlsInspectionPoliciesRequest;
import com.google.cloud.networksecurity.v1.ListTlsInspectionPoliciesResponse;
import com.google.cloud.networksecurity.v1.ListUrlListsRequest;
import com.google.cloud.networksecurity.v1.ListUrlListsResponse;
import com.google.cloud.networksecurity.v1.OperationMetadata;
import com.google.cloud.networksecurity.v1.ServerTlsPolicy;
import com.google.cloud.networksecurity.v1.TlsInspectionPolicy;
import com.google.cloud.networksecurity.v1.UpdateAuthorizationPolicyRequest;
import com.google.cloud.networksecurity.v1.UpdateAuthzPolicyRequest;
import com.google.cloud.networksecurity.v1.UpdateBackendAuthenticationConfigRequest;
import com.google.cloud.networksecurity.v1.UpdateClientTlsPolicyRequest;
import com.google.cloud.networksecurity.v1.UpdateGatewaySecurityPolicyRequest;
import com.google.cloud.networksecurity.v1.UpdateGatewaySecurityPolicyRuleRequest;
import com.google.cloud.networksecurity.v1.UpdateServerTlsPolicyRequest;
import com.google.cloud.networksecurity.v1.UpdateTlsInspectionPolicyRequest;
import com.google.cloud.networksecurity.v1.UpdateUrlListRequest;
import com.google.cloud.networksecurity.v1.UrlList;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the NetworkSecurity service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class NetworkSecurityStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public UnaryCallable<ListAuthorizationPoliciesRequest, ListAuthorizationPoliciesPagedResponse>
      listAuthorizationPoliciesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listAuthorizationPoliciesPagedCallable()");
  }

  public UnaryCallable<ListAuthorizationPoliciesRequest, ListAuthorizationPoliciesResponse>
      listAuthorizationPoliciesCallable() {
    throw new UnsupportedOperationException("Not implemented: listAuthorizationPoliciesCallable()");
  }

  public UnaryCallable<GetAuthorizationPolicyRequest, AuthorizationPolicy>
      getAuthorizationPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getAuthorizationPolicyCallable()");
  }

  public OperationCallable<CreateAuthorizationPolicyRequest, AuthorizationPolicy, OperationMetadata>
      createAuthorizationPolicyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createAuthorizationPolicyOperationCallable()");
  }

  public UnaryCallable<CreateAuthorizationPolicyRequest, Operation>
      createAuthorizationPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: createAuthorizationPolicyCallable()");
  }

  public OperationCallable<UpdateAuthorizationPolicyRequest, AuthorizationPolicy, OperationMetadata>
      updateAuthorizationPolicyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateAuthorizationPolicyOperationCallable()");
  }

  public UnaryCallable<UpdateAuthorizationPolicyRequest, Operation>
      updateAuthorizationPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: updateAuthorizationPolicyCallable()");
  }

  public OperationCallable<DeleteAuthorizationPolicyRequest, Empty, OperationMetadata>
      deleteAuthorizationPolicyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteAuthorizationPolicyOperationCallable()");
  }

  public UnaryCallable<DeleteAuthorizationPolicyRequest, Operation>
      deleteAuthorizationPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAuthorizationPolicyCallable()");
  }

  public UnaryCallable<
          ListBackendAuthenticationConfigsRequest, ListBackendAuthenticationConfigsPagedResponse>
      listBackendAuthenticationConfigsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listBackendAuthenticationConfigsPagedCallable()");
  }

  public UnaryCallable<
          ListBackendAuthenticationConfigsRequest, ListBackendAuthenticationConfigsResponse>
      listBackendAuthenticationConfigsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listBackendAuthenticationConfigsCallable()");
  }

  public UnaryCallable<GetBackendAuthenticationConfigRequest, BackendAuthenticationConfig>
      getBackendAuthenticationConfigCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getBackendAuthenticationConfigCallable()");
  }

  public OperationCallable<
          CreateBackendAuthenticationConfigRequest, BackendAuthenticationConfig, OperationMetadata>
      createBackendAuthenticationConfigOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createBackendAuthenticationConfigOperationCallable()");
  }

  public UnaryCallable<CreateBackendAuthenticationConfigRequest, Operation>
      createBackendAuthenticationConfigCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createBackendAuthenticationConfigCallable()");
  }

  public OperationCallable<
          UpdateBackendAuthenticationConfigRequest, BackendAuthenticationConfig, OperationMetadata>
      updateBackendAuthenticationConfigOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateBackendAuthenticationConfigOperationCallable()");
  }

  public UnaryCallable<UpdateBackendAuthenticationConfigRequest, Operation>
      updateBackendAuthenticationConfigCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateBackendAuthenticationConfigCallable()");
  }

  public OperationCallable<DeleteBackendAuthenticationConfigRequest, Empty, OperationMetadata>
      deleteBackendAuthenticationConfigOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteBackendAuthenticationConfigOperationCallable()");
  }

  public UnaryCallable<DeleteBackendAuthenticationConfigRequest, Operation>
      deleteBackendAuthenticationConfigCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteBackendAuthenticationConfigCallable()");
  }

  public UnaryCallable<ListServerTlsPoliciesRequest, ListServerTlsPoliciesPagedResponse>
      listServerTlsPoliciesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listServerTlsPoliciesPagedCallable()");
  }

  public UnaryCallable<ListServerTlsPoliciesRequest, ListServerTlsPoliciesResponse>
      listServerTlsPoliciesCallable() {
    throw new UnsupportedOperationException("Not implemented: listServerTlsPoliciesCallable()");
  }

  public UnaryCallable<GetServerTlsPolicyRequest, ServerTlsPolicy> getServerTlsPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getServerTlsPolicyCallable()");
  }

  public OperationCallable<CreateServerTlsPolicyRequest, ServerTlsPolicy, OperationMetadata>
      createServerTlsPolicyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createServerTlsPolicyOperationCallable()");
  }

  public UnaryCallable<CreateServerTlsPolicyRequest, Operation> createServerTlsPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: createServerTlsPolicyCallable()");
  }

  public OperationCallable<UpdateServerTlsPolicyRequest, ServerTlsPolicy, OperationMetadata>
      updateServerTlsPolicyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateServerTlsPolicyOperationCallable()");
  }

  public UnaryCallable<UpdateServerTlsPolicyRequest, Operation> updateServerTlsPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: updateServerTlsPolicyCallable()");
  }

  public OperationCallable<DeleteServerTlsPolicyRequest, Empty, OperationMetadata>
      deleteServerTlsPolicyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteServerTlsPolicyOperationCallable()");
  }

  public UnaryCallable<DeleteServerTlsPolicyRequest, Operation> deleteServerTlsPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteServerTlsPolicyCallable()");
  }

  public UnaryCallable<ListClientTlsPoliciesRequest, ListClientTlsPoliciesPagedResponse>
      listClientTlsPoliciesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listClientTlsPoliciesPagedCallable()");
  }

  public UnaryCallable<ListClientTlsPoliciesRequest, ListClientTlsPoliciesResponse>
      listClientTlsPoliciesCallable() {
    throw new UnsupportedOperationException("Not implemented: listClientTlsPoliciesCallable()");
  }

  public UnaryCallable<GetClientTlsPolicyRequest, ClientTlsPolicy> getClientTlsPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getClientTlsPolicyCallable()");
  }

  public OperationCallable<CreateClientTlsPolicyRequest, ClientTlsPolicy, OperationMetadata>
      createClientTlsPolicyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createClientTlsPolicyOperationCallable()");
  }

  public UnaryCallable<CreateClientTlsPolicyRequest, Operation> createClientTlsPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: createClientTlsPolicyCallable()");
  }

  public OperationCallable<UpdateClientTlsPolicyRequest, ClientTlsPolicy, OperationMetadata>
      updateClientTlsPolicyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateClientTlsPolicyOperationCallable()");
  }

  public UnaryCallable<UpdateClientTlsPolicyRequest, Operation> updateClientTlsPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: updateClientTlsPolicyCallable()");
  }

  public OperationCallable<DeleteClientTlsPolicyRequest, Empty, OperationMetadata>
      deleteClientTlsPolicyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteClientTlsPolicyOperationCallable()");
  }

  public UnaryCallable<DeleteClientTlsPolicyRequest, Operation> deleteClientTlsPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteClientTlsPolicyCallable()");
  }

  public UnaryCallable<ListGatewaySecurityPoliciesRequest, ListGatewaySecurityPoliciesPagedResponse>
      listGatewaySecurityPoliciesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listGatewaySecurityPoliciesPagedCallable()");
  }

  public UnaryCallable<ListGatewaySecurityPoliciesRequest, ListGatewaySecurityPoliciesResponse>
      listGatewaySecurityPoliciesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listGatewaySecurityPoliciesCallable()");
  }

  public UnaryCallable<GetGatewaySecurityPolicyRequest, GatewaySecurityPolicy>
      getGatewaySecurityPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getGatewaySecurityPolicyCallable()");
  }

  public OperationCallable<
          CreateGatewaySecurityPolicyRequest, GatewaySecurityPolicy, OperationMetadata>
      createGatewaySecurityPolicyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createGatewaySecurityPolicyOperationCallable()");
  }

  public UnaryCallable<CreateGatewaySecurityPolicyRequest, Operation>
      createGatewaySecurityPolicyCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createGatewaySecurityPolicyCallable()");
  }

  public OperationCallable<
          UpdateGatewaySecurityPolicyRequest, GatewaySecurityPolicy, OperationMetadata>
      updateGatewaySecurityPolicyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateGatewaySecurityPolicyOperationCallable()");
  }

  public UnaryCallable<UpdateGatewaySecurityPolicyRequest, Operation>
      updateGatewaySecurityPolicyCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateGatewaySecurityPolicyCallable()");
  }

  public OperationCallable<DeleteGatewaySecurityPolicyRequest, Empty, OperationMetadata>
      deleteGatewaySecurityPolicyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteGatewaySecurityPolicyOperationCallable()");
  }

  public UnaryCallable<DeleteGatewaySecurityPolicyRequest, Operation>
      deleteGatewaySecurityPolicyCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteGatewaySecurityPolicyCallable()");
  }

  public UnaryCallable<
          ListGatewaySecurityPolicyRulesRequest, ListGatewaySecurityPolicyRulesPagedResponse>
      listGatewaySecurityPolicyRulesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listGatewaySecurityPolicyRulesPagedCallable()");
  }

  public UnaryCallable<
          ListGatewaySecurityPolicyRulesRequest, ListGatewaySecurityPolicyRulesResponse>
      listGatewaySecurityPolicyRulesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listGatewaySecurityPolicyRulesCallable()");
  }

  public UnaryCallable<GetGatewaySecurityPolicyRuleRequest, GatewaySecurityPolicyRule>
      getGatewaySecurityPolicyRuleCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getGatewaySecurityPolicyRuleCallable()");
  }

  public OperationCallable<
          CreateGatewaySecurityPolicyRuleRequest, GatewaySecurityPolicyRule, OperationMetadata>
      createGatewaySecurityPolicyRuleOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createGatewaySecurityPolicyRuleOperationCallable()");
  }

  public UnaryCallable<CreateGatewaySecurityPolicyRuleRequest, Operation>
      createGatewaySecurityPolicyRuleCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createGatewaySecurityPolicyRuleCallable()");
  }

  public OperationCallable<
          UpdateGatewaySecurityPolicyRuleRequest, GatewaySecurityPolicyRule, OperationMetadata>
      updateGatewaySecurityPolicyRuleOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateGatewaySecurityPolicyRuleOperationCallable()");
  }

  public UnaryCallable<UpdateGatewaySecurityPolicyRuleRequest, Operation>
      updateGatewaySecurityPolicyRuleCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateGatewaySecurityPolicyRuleCallable()");
  }

  public OperationCallable<DeleteGatewaySecurityPolicyRuleRequest, Empty, OperationMetadata>
      deleteGatewaySecurityPolicyRuleOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteGatewaySecurityPolicyRuleOperationCallable()");
  }

  public UnaryCallable<DeleteGatewaySecurityPolicyRuleRequest, Operation>
      deleteGatewaySecurityPolicyRuleCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteGatewaySecurityPolicyRuleCallable()");
  }

  public UnaryCallable<ListUrlListsRequest, ListUrlListsPagedResponse> listUrlListsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listUrlListsPagedCallable()");
  }

  public UnaryCallable<ListUrlListsRequest, ListUrlListsResponse> listUrlListsCallable() {
    throw new UnsupportedOperationException("Not implemented: listUrlListsCallable()");
  }

  public UnaryCallable<GetUrlListRequest, UrlList> getUrlListCallable() {
    throw new UnsupportedOperationException("Not implemented: getUrlListCallable()");
  }

  public OperationCallable<CreateUrlListRequest, UrlList, OperationMetadata>
      createUrlListOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createUrlListOperationCallable()");
  }

  public UnaryCallable<CreateUrlListRequest, Operation> createUrlListCallable() {
    throw new UnsupportedOperationException("Not implemented: createUrlListCallable()");
  }

  public OperationCallable<UpdateUrlListRequest, UrlList, OperationMetadata>
      updateUrlListOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateUrlListOperationCallable()");
  }

  public UnaryCallable<UpdateUrlListRequest, Operation> updateUrlListCallable() {
    throw new UnsupportedOperationException("Not implemented: updateUrlListCallable()");
  }

  public OperationCallable<DeleteUrlListRequest, Empty, OperationMetadata>
      deleteUrlListOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteUrlListOperationCallable()");
  }

  public UnaryCallable<DeleteUrlListRequest, Operation> deleteUrlListCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteUrlListCallable()");
  }

  public UnaryCallable<ListTlsInspectionPoliciesRequest, ListTlsInspectionPoliciesPagedResponse>
      listTlsInspectionPoliciesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listTlsInspectionPoliciesPagedCallable()");
  }

  public UnaryCallable<ListTlsInspectionPoliciesRequest, ListTlsInspectionPoliciesResponse>
      listTlsInspectionPoliciesCallable() {
    throw new UnsupportedOperationException("Not implemented: listTlsInspectionPoliciesCallable()");
  }

  public UnaryCallable<GetTlsInspectionPolicyRequest, TlsInspectionPolicy>
      getTlsInspectionPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getTlsInspectionPolicyCallable()");
  }

  public OperationCallable<CreateTlsInspectionPolicyRequest, TlsInspectionPolicy, OperationMetadata>
      createTlsInspectionPolicyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createTlsInspectionPolicyOperationCallable()");
  }

  public UnaryCallable<CreateTlsInspectionPolicyRequest, Operation>
      createTlsInspectionPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: createTlsInspectionPolicyCallable()");
  }

  public OperationCallable<UpdateTlsInspectionPolicyRequest, TlsInspectionPolicy, OperationMetadata>
      updateTlsInspectionPolicyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateTlsInspectionPolicyOperationCallable()");
  }

  public UnaryCallable<UpdateTlsInspectionPolicyRequest, Operation>
      updateTlsInspectionPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: updateTlsInspectionPolicyCallable()");
  }

  public OperationCallable<DeleteTlsInspectionPolicyRequest, Empty, OperationMetadata>
      deleteTlsInspectionPolicyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteTlsInspectionPolicyOperationCallable()");
  }

  public UnaryCallable<DeleteTlsInspectionPolicyRequest, Operation>
      deleteTlsInspectionPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteTlsInspectionPolicyCallable()");
  }

  public UnaryCallable<ListAuthzPoliciesRequest, ListAuthzPoliciesPagedResponse>
      listAuthzPoliciesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAuthzPoliciesPagedCallable()");
  }

  public UnaryCallable<ListAuthzPoliciesRequest, ListAuthzPoliciesResponse>
      listAuthzPoliciesCallable() {
    throw new UnsupportedOperationException("Not implemented: listAuthzPoliciesCallable()");
  }

  public UnaryCallable<GetAuthzPolicyRequest, AuthzPolicy> getAuthzPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getAuthzPolicyCallable()");
  }

  public OperationCallable<CreateAuthzPolicyRequest, AuthzPolicy, OperationMetadata>
      createAuthzPolicyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createAuthzPolicyOperationCallable()");
  }

  public UnaryCallable<CreateAuthzPolicyRequest, Operation> createAuthzPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: createAuthzPolicyCallable()");
  }

  public OperationCallable<UpdateAuthzPolicyRequest, AuthzPolicy, OperationMetadata>
      updateAuthzPolicyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateAuthzPolicyOperationCallable()");
  }

  public UnaryCallable<UpdateAuthzPolicyRequest, Operation> updateAuthzPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: updateAuthzPolicyCallable()");
  }

  public OperationCallable<DeleteAuthzPolicyRequest, Empty, OperationMetadata>
      deleteAuthzPolicyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteAuthzPolicyOperationCallable()");
  }

  public UnaryCallable<DeleteAuthzPolicyRequest, Operation> deleteAuthzPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAuthzPolicyCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsPagedCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsCallable()");
  }

  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    throw new UnsupportedOperationException("Not implemented: getLocationCallable()");
  }

  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyCallable()");
  }

  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyCallable()");
  }

  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsCallable()");
  }

  @Override
  public abstract void close();
}
