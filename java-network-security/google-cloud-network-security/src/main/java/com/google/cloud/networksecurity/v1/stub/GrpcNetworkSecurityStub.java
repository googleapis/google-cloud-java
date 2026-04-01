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
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
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
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the NetworkSecurity service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcNetworkSecurityStub extends NetworkSecurityStub {
  private static final MethodDescriptor<
          ListAuthorizationPoliciesRequest, ListAuthorizationPoliciesResponse>
      listAuthorizationPoliciesMethodDescriptor =
          MethodDescriptor
              .<ListAuthorizationPoliciesRequest, ListAuthorizationPoliciesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.NetworkSecurity/ListAuthorizationPolicies")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAuthorizationPoliciesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAuthorizationPoliciesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetAuthorizationPolicyRequest, AuthorizationPolicy>
      getAuthorizationPolicyMethodDescriptor =
          MethodDescriptor.<GetAuthorizationPolicyRequest, AuthorizationPolicy>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.NetworkSecurity/GetAuthorizationPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAuthorizationPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(AuthorizationPolicy.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateAuthorizationPolicyRequest, Operation>
      createAuthorizationPolicyMethodDescriptor =
          MethodDescriptor.<CreateAuthorizationPolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.NetworkSecurity/CreateAuthorizationPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateAuthorizationPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateAuthorizationPolicyRequest, Operation>
      updateAuthorizationPolicyMethodDescriptor =
          MethodDescriptor.<UpdateAuthorizationPolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.NetworkSecurity/UpdateAuthorizationPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateAuthorizationPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteAuthorizationPolicyRequest, Operation>
      deleteAuthorizationPolicyMethodDescriptor =
          MethodDescriptor.<DeleteAuthorizationPolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.NetworkSecurity/DeleteAuthorizationPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteAuthorizationPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListBackendAuthenticationConfigsRequest, ListBackendAuthenticationConfigsResponse>
      listBackendAuthenticationConfigsMethodDescriptor =
          MethodDescriptor
              .<ListBackendAuthenticationConfigsRequest, ListBackendAuthenticationConfigsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.NetworkSecurity/ListBackendAuthenticationConfigs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      ListBackendAuthenticationConfigsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      ListBackendAuthenticationConfigsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          GetBackendAuthenticationConfigRequest, BackendAuthenticationConfig>
      getBackendAuthenticationConfigMethodDescriptor =
          MethodDescriptor
              .<GetBackendAuthenticationConfigRequest, BackendAuthenticationConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.NetworkSecurity/GetBackendAuthenticationConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetBackendAuthenticationConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(BackendAuthenticationConfig.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateBackendAuthenticationConfigRequest, Operation>
      createBackendAuthenticationConfigMethodDescriptor =
          MethodDescriptor.<CreateBackendAuthenticationConfigRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.NetworkSecurity/CreateBackendAuthenticationConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      CreateBackendAuthenticationConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateBackendAuthenticationConfigRequest, Operation>
      updateBackendAuthenticationConfigMethodDescriptor =
          MethodDescriptor.<UpdateBackendAuthenticationConfigRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.NetworkSecurity/UpdateBackendAuthenticationConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      UpdateBackendAuthenticationConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteBackendAuthenticationConfigRequest, Operation>
      deleteBackendAuthenticationConfigMethodDescriptor =
          MethodDescriptor.<DeleteBackendAuthenticationConfigRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.NetworkSecurity/DeleteBackendAuthenticationConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      DeleteBackendAuthenticationConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListServerTlsPoliciesRequest, ListServerTlsPoliciesResponse>
      listServerTlsPoliciesMethodDescriptor =
          MethodDescriptor.<ListServerTlsPoliciesRequest, ListServerTlsPoliciesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.NetworkSecurity/ListServerTlsPolicies")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListServerTlsPoliciesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListServerTlsPoliciesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetServerTlsPolicyRequest, ServerTlsPolicy>
      getServerTlsPolicyMethodDescriptor =
          MethodDescriptor.<GetServerTlsPolicyRequest, ServerTlsPolicy>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.NetworkSecurity/GetServerTlsPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetServerTlsPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ServerTlsPolicy.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateServerTlsPolicyRequest, Operation>
      createServerTlsPolicyMethodDescriptor =
          MethodDescriptor.<CreateServerTlsPolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.NetworkSecurity/CreateServerTlsPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateServerTlsPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateServerTlsPolicyRequest, Operation>
      updateServerTlsPolicyMethodDescriptor =
          MethodDescriptor.<UpdateServerTlsPolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.NetworkSecurity/UpdateServerTlsPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateServerTlsPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteServerTlsPolicyRequest, Operation>
      deleteServerTlsPolicyMethodDescriptor =
          MethodDescriptor.<DeleteServerTlsPolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.NetworkSecurity/DeleteServerTlsPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteServerTlsPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListClientTlsPoliciesRequest, ListClientTlsPoliciesResponse>
      listClientTlsPoliciesMethodDescriptor =
          MethodDescriptor.<ListClientTlsPoliciesRequest, ListClientTlsPoliciesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.NetworkSecurity/ListClientTlsPolicies")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListClientTlsPoliciesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListClientTlsPoliciesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetClientTlsPolicyRequest, ClientTlsPolicy>
      getClientTlsPolicyMethodDescriptor =
          MethodDescriptor.<GetClientTlsPolicyRequest, ClientTlsPolicy>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.NetworkSecurity/GetClientTlsPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetClientTlsPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ClientTlsPolicy.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateClientTlsPolicyRequest, Operation>
      createClientTlsPolicyMethodDescriptor =
          MethodDescriptor.<CreateClientTlsPolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.NetworkSecurity/CreateClientTlsPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateClientTlsPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateClientTlsPolicyRequest, Operation>
      updateClientTlsPolicyMethodDescriptor =
          MethodDescriptor.<UpdateClientTlsPolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.NetworkSecurity/UpdateClientTlsPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateClientTlsPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteClientTlsPolicyRequest, Operation>
      deleteClientTlsPolicyMethodDescriptor =
          MethodDescriptor.<DeleteClientTlsPolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.NetworkSecurity/DeleteClientTlsPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteClientTlsPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListGatewaySecurityPoliciesRequest, ListGatewaySecurityPoliciesResponse>
      listGatewaySecurityPoliciesMethodDescriptor =
          MethodDescriptor
              .<ListGatewaySecurityPoliciesRequest, ListGatewaySecurityPoliciesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.NetworkSecurity/ListGatewaySecurityPolicies")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListGatewaySecurityPoliciesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListGatewaySecurityPoliciesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetGatewaySecurityPolicyRequest, GatewaySecurityPolicy>
      getGatewaySecurityPolicyMethodDescriptor =
          MethodDescriptor.<GetGatewaySecurityPolicyRequest, GatewaySecurityPolicy>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.NetworkSecurity/GetGatewaySecurityPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetGatewaySecurityPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GatewaySecurityPolicy.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateGatewaySecurityPolicyRequest, Operation>
      createGatewaySecurityPolicyMethodDescriptor =
          MethodDescriptor.<CreateGatewaySecurityPolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.NetworkSecurity/CreateGatewaySecurityPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateGatewaySecurityPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateGatewaySecurityPolicyRequest, Operation>
      updateGatewaySecurityPolicyMethodDescriptor =
          MethodDescriptor.<UpdateGatewaySecurityPolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.NetworkSecurity/UpdateGatewaySecurityPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateGatewaySecurityPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteGatewaySecurityPolicyRequest, Operation>
      deleteGatewaySecurityPolicyMethodDescriptor =
          MethodDescriptor.<DeleteGatewaySecurityPolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.NetworkSecurity/DeleteGatewaySecurityPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteGatewaySecurityPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListGatewaySecurityPolicyRulesRequest, ListGatewaySecurityPolicyRulesResponse>
      listGatewaySecurityPolicyRulesMethodDescriptor =
          MethodDescriptor
              .<ListGatewaySecurityPolicyRulesRequest, ListGatewaySecurityPolicyRulesResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.NetworkSecurity/ListGatewaySecurityPolicyRules")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListGatewaySecurityPolicyRulesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      ListGatewaySecurityPolicyRulesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          GetGatewaySecurityPolicyRuleRequest, GatewaySecurityPolicyRule>
      getGatewaySecurityPolicyRuleMethodDescriptor =
          MethodDescriptor
              .<GetGatewaySecurityPolicyRuleRequest, GatewaySecurityPolicyRule>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.NetworkSecurity/GetGatewaySecurityPolicyRule")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetGatewaySecurityPolicyRuleRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GatewaySecurityPolicyRule.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateGatewaySecurityPolicyRuleRequest, Operation>
      createGatewaySecurityPolicyRuleMethodDescriptor =
          MethodDescriptor.<CreateGatewaySecurityPolicyRuleRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.NetworkSecurity/CreateGatewaySecurityPolicyRule")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      CreateGatewaySecurityPolicyRuleRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateGatewaySecurityPolicyRuleRequest, Operation>
      updateGatewaySecurityPolicyRuleMethodDescriptor =
          MethodDescriptor.<UpdateGatewaySecurityPolicyRuleRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.NetworkSecurity/UpdateGatewaySecurityPolicyRule")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      UpdateGatewaySecurityPolicyRuleRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteGatewaySecurityPolicyRuleRequest, Operation>
      deleteGatewaySecurityPolicyRuleMethodDescriptor =
          MethodDescriptor.<DeleteGatewaySecurityPolicyRuleRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.NetworkSecurity/DeleteGatewaySecurityPolicyRule")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      DeleteGatewaySecurityPolicyRuleRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListUrlListsRequest, ListUrlListsResponse>
      listUrlListsMethodDescriptor =
          MethodDescriptor.<ListUrlListsRequest, ListUrlListsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networksecurity.v1.NetworkSecurity/ListUrlLists")
              .setRequestMarshaller(ProtoUtils.marshaller(ListUrlListsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListUrlListsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetUrlListRequest, UrlList> getUrlListMethodDescriptor =
      MethodDescriptor.<GetUrlListRequest, UrlList>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.networksecurity.v1.NetworkSecurity/GetUrlList")
          .setRequestMarshaller(ProtoUtils.marshaller(GetUrlListRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(UrlList.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<CreateUrlListRequest, Operation>
      createUrlListMethodDescriptor =
          MethodDescriptor.<CreateUrlListRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networksecurity.v1.NetworkSecurity/CreateUrlList")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateUrlListRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateUrlListRequest, Operation>
      updateUrlListMethodDescriptor =
          MethodDescriptor.<UpdateUrlListRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networksecurity.v1.NetworkSecurity/UpdateUrlList")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateUrlListRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteUrlListRequest, Operation>
      deleteUrlListMethodDescriptor =
          MethodDescriptor.<DeleteUrlListRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networksecurity.v1.NetworkSecurity/DeleteUrlList")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteUrlListRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListTlsInspectionPoliciesRequest, ListTlsInspectionPoliciesResponse>
      listTlsInspectionPoliciesMethodDescriptor =
          MethodDescriptor
              .<ListTlsInspectionPoliciesRequest, ListTlsInspectionPoliciesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.NetworkSecurity/ListTlsInspectionPolicies")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListTlsInspectionPoliciesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListTlsInspectionPoliciesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetTlsInspectionPolicyRequest, TlsInspectionPolicy>
      getTlsInspectionPolicyMethodDescriptor =
          MethodDescriptor.<GetTlsInspectionPolicyRequest, TlsInspectionPolicy>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.NetworkSecurity/GetTlsInspectionPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetTlsInspectionPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TlsInspectionPolicy.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateTlsInspectionPolicyRequest, Operation>
      createTlsInspectionPolicyMethodDescriptor =
          MethodDescriptor.<CreateTlsInspectionPolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.NetworkSecurity/CreateTlsInspectionPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateTlsInspectionPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateTlsInspectionPolicyRequest, Operation>
      updateTlsInspectionPolicyMethodDescriptor =
          MethodDescriptor.<UpdateTlsInspectionPolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.NetworkSecurity/UpdateTlsInspectionPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateTlsInspectionPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteTlsInspectionPolicyRequest, Operation>
      deleteTlsInspectionPolicyMethodDescriptor =
          MethodDescriptor.<DeleteTlsInspectionPolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.NetworkSecurity/DeleteTlsInspectionPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteTlsInspectionPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListAuthzPoliciesRequest, ListAuthzPoliciesResponse>
      listAuthzPoliciesMethodDescriptor =
          MethodDescriptor.<ListAuthzPoliciesRequest, ListAuthzPoliciesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.NetworkSecurity/ListAuthzPolicies")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAuthzPoliciesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAuthzPoliciesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetAuthzPolicyRequest, AuthzPolicy>
      getAuthzPolicyMethodDescriptor =
          MethodDescriptor.<GetAuthzPolicyRequest, AuthzPolicy>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.networksecurity.v1.NetworkSecurity/GetAuthzPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAuthzPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AuthzPolicy.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateAuthzPolicyRequest, Operation>
      createAuthzPolicyMethodDescriptor =
          MethodDescriptor.<CreateAuthzPolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.NetworkSecurity/CreateAuthzPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateAuthzPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateAuthzPolicyRequest, Operation>
      updateAuthzPolicyMethodDescriptor =
          MethodDescriptor.<UpdateAuthzPolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.NetworkSecurity/UpdateAuthzPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateAuthzPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteAuthzPolicyRequest, Operation>
      deleteAuthzPolicyMethodDescriptor =
          MethodDescriptor.<DeleteAuthzPolicyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.networksecurity.v1.NetworkSecurity/DeleteAuthzPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteAuthzPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          MethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListLocationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListLocationsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetLocationRequest, Location> getLocationMethodDescriptor =
      MethodDescriptor.<GetLocationRequest, Location>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.location.Locations/GetLocation")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLocationRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Location.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          MethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.v1.IAMPolicy/TestIamPermissions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<ListAuthorizationPoliciesRequest, ListAuthorizationPoliciesResponse>
      listAuthorizationPoliciesCallable;
  private final UnaryCallable<
          ListAuthorizationPoliciesRequest, ListAuthorizationPoliciesPagedResponse>
      listAuthorizationPoliciesPagedCallable;
  private final UnaryCallable<GetAuthorizationPolicyRequest, AuthorizationPolicy>
      getAuthorizationPolicyCallable;
  private final UnaryCallable<CreateAuthorizationPolicyRequest, Operation>
      createAuthorizationPolicyCallable;
  private final OperationCallable<
          CreateAuthorizationPolicyRequest, AuthorizationPolicy, OperationMetadata>
      createAuthorizationPolicyOperationCallable;
  private final UnaryCallable<UpdateAuthorizationPolicyRequest, Operation>
      updateAuthorizationPolicyCallable;
  private final OperationCallable<
          UpdateAuthorizationPolicyRequest, AuthorizationPolicy, OperationMetadata>
      updateAuthorizationPolicyOperationCallable;
  private final UnaryCallable<DeleteAuthorizationPolicyRequest, Operation>
      deleteAuthorizationPolicyCallable;
  private final OperationCallable<DeleteAuthorizationPolicyRequest, Empty, OperationMetadata>
      deleteAuthorizationPolicyOperationCallable;
  private final UnaryCallable<
          ListBackendAuthenticationConfigsRequest, ListBackendAuthenticationConfigsResponse>
      listBackendAuthenticationConfigsCallable;
  private final UnaryCallable<
          ListBackendAuthenticationConfigsRequest, ListBackendAuthenticationConfigsPagedResponse>
      listBackendAuthenticationConfigsPagedCallable;
  private final UnaryCallable<GetBackendAuthenticationConfigRequest, BackendAuthenticationConfig>
      getBackendAuthenticationConfigCallable;
  private final UnaryCallable<CreateBackendAuthenticationConfigRequest, Operation>
      createBackendAuthenticationConfigCallable;
  private final OperationCallable<
          CreateBackendAuthenticationConfigRequest, BackendAuthenticationConfig, OperationMetadata>
      createBackendAuthenticationConfigOperationCallable;
  private final UnaryCallable<UpdateBackendAuthenticationConfigRequest, Operation>
      updateBackendAuthenticationConfigCallable;
  private final OperationCallable<
          UpdateBackendAuthenticationConfigRequest, BackendAuthenticationConfig, OperationMetadata>
      updateBackendAuthenticationConfigOperationCallable;
  private final UnaryCallable<DeleteBackendAuthenticationConfigRequest, Operation>
      deleteBackendAuthenticationConfigCallable;
  private final OperationCallable<
          DeleteBackendAuthenticationConfigRequest, Empty, OperationMetadata>
      deleteBackendAuthenticationConfigOperationCallable;
  private final UnaryCallable<ListServerTlsPoliciesRequest, ListServerTlsPoliciesResponse>
      listServerTlsPoliciesCallable;
  private final UnaryCallable<ListServerTlsPoliciesRequest, ListServerTlsPoliciesPagedResponse>
      listServerTlsPoliciesPagedCallable;
  private final UnaryCallable<GetServerTlsPolicyRequest, ServerTlsPolicy>
      getServerTlsPolicyCallable;
  private final UnaryCallable<CreateServerTlsPolicyRequest, Operation>
      createServerTlsPolicyCallable;
  private final OperationCallable<CreateServerTlsPolicyRequest, ServerTlsPolicy, OperationMetadata>
      createServerTlsPolicyOperationCallable;
  private final UnaryCallable<UpdateServerTlsPolicyRequest, Operation>
      updateServerTlsPolicyCallable;
  private final OperationCallable<UpdateServerTlsPolicyRequest, ServerTlsPolicy, OperationMetadata>
      updateServerTlsPolicyOperationCallable;
  private final UnaryCallable<DeleteServerTlsPolicyRequest, Operation>
      deleteServerTlsPolicyCallable;
  private final OperationCallable<DeleteServerTlsPolicyRequest, Empty, OperationMetadata>
      deleteServerTlsPolicyOperationCallable;
  private final UnaryCallable<ListClientTlsPoliciesRequest, ListClientTlsPoliciesResponse>
      listClientTlsPoliciesCallable;
  private final UnaryCallable<ListClientTlsPoliciesRequest, ListClientTlsPoliciesPagedResponse>
      listClientTlsPoliciesPagedCallable;
  private final UnaryCallable<GetClientTlsPolicyRequest, ClientTlsPolicy>
      getClientTlsPolicyCallable;
  private final UnaryCallable<CreateClientTlsPolicyRequest, Operation>
      createClientTlsPolicyCallable;
  private final OperationCallable<CreateClientTlsPolicyRequest, ClientTlsPolicy, OperationMetadata>
      createClientTlsPolicyOperationCallable;
  private final UnaryCallable<UpdateClientTlsPolicyRequest, Operation>
      updateClientTlsPolicyCallable;
  private final OperationCallable<UpdateClientTlsPolicyRequest, ClientTlsPolicy, OperationMetadata>
      updateClientTlsPolicyOperationCallable;
  private final UnaryCallable<DeleteClientTlsPolicyRequest, Operation>
      deleteClientTlsPolicyCallable;
  private final OperationCallable<DeleteClientTlsPolicyRequest, Empty, OperationMetadata>
      deleteClientTlsPolicyOperationCallable;
  private final UnaryCallable<
          ListGatewaySecurityPoliciesRequest, ListGatewaySecurityPoliciesResponse>
      listGatewaySecurityPoliciesCallable;
  private final UnaryCallable<
          ListGatewaySecurityPoliciesRequest, ListGatewaySecurityPoliciesPagedResponse>
      listGatewaySecurityPoliciesPagedCallable;
  private final UnaryCallable<GetGatewaySecurityPolicyRequest, GatewaySecurityPolicy>
      getGatewaySecurityPolicyCallable;
  private final UnaryCallable<CreateGatewaySecurityPolicyRequest, Operation>
      createGatewaySecurityPolicyCallable;
  private final OperationCallable<
          CreateGatewaySecurityPolicyRequest, GatewaySecurityPolicy, OperationMetadata>
      createGatewaySecurityPolicyOperationCallable;
  private final UnaryCallable<UpdateGatewaySecurityPolicyRequest, Operation>
      updateGatewaySecurityPolicyCallable;
  private final OperationCallable<
          UpdateGatewaySecurityPolicyRequest, GatewaySecurityPolicy, OperationMetadata>
      updateGatewaySecurityPolicyOperationCallable;
  private final UnaryCallable<DeleteGatewaySecurityPolicyRequest, Operation>
      deleteGatewaySecurityPolicyCallable;
  private final OperationCallable<DeleteGatewaySecurityPolicyRequest, Empty, OperationMetadata>
      deleteGatewaySecurityPolicyOperationCallable;
  private final UnaryCallable<
          ListGatewaySecurityPolicyRulesRequest, ListGatewaySecurityPolicyRulesResponse>
      listGatewaySecurityPolicyRulesCallable;
  private final UnaryCallable<
          ListGatewaySecurityPolicyRulesRequest, ListGatewaySecurityPolicyRulesPagedResponse>
      listGatewaySecurityPolicyRulesPagedCallable;
  private final UnaryCallable<GetGatewaySecurityPolicyRuleRequest, GatewaySecurityPolicyRule>
      getGatewaySecurityPolicyRuleCallable;
  private final UnaryCallable<CreateGatewaySecurityPolicyRuleRequest, Operation>
      createGatewaySecurityPolicyRuleCallable;
  private final OperationCallable<
          CreateGatewaySecurityPolicyRuleRequest, GatewaySecurityPolicyRule, OperationMetadata>
      createGatewaySecurityPolicyRuleOperationCallable;
  private final UnaryCallable<UpdateGatewaySecurityPolicyRuleRequest, Operation>
      updateGatewaySecurityPolicyRuleCallable;
  private final OperationCallable<
          UpdateGatewaySecurityPolicyRuleRequest, GatewaySecurityPolicyRule, OperationMetadata>
      updateGatewaySecurityPolicyRuleOperationCallable;
  private final UnaryCallable<DeleteGatewaySecurityPolicyRuleRequest, Operation>
      deleteGatewaySecurityPolicyRuleCallable;
  private final OperationCallable<DeleteGatewaySecurityPolicyRuleRequest, Empty, OperationMetadata>
      deleteGatewaySecurityPolicyRuleOperationCallable;
  private final UnaryCallable<ListUrlListsRequest, ListUrlListsResponse> listUrlListsCallable;
  private final UnaryCallable<ListUrlListsRequest, ListUrlListsPagedResponse>
      listUrlListsPagedCallable;
  private final UnaryCallable<GetUrlListRequest, UrlList> getUrlListCallable;
  private final UnaryCallable<CreateUrlListRequest, Operation> createUrlListCallable;
  private final OperationCallable<CreateUrlListRequest, UrlList, OperationMetadata>
      createUrlListOperationCallable;
  private final UnaryCallable<UpdateUrlListRequest, Operation> updateUrlListCallable;
  private final OperationCallable<UpdateUrlListRequest, UrlList, OperationMetadata>
      updateUrlListOperationCallable;
  private final UnaryCallable<DeleteUrlListRequest, Operation> deleteUrlListCallable;
  private final OperationCallable<DeleteUrlListRequest, Empty, OperationMetadata>
      deleteUrlListOperationCallable;
  private final UnaryCallable<ListTlsInspectionPoliciesRequest, ListTlsInspectionPoliciesResponse>
      listTlsInspectionPoliciesCallable;
  private final UnaryCallable<
          ListTlsInspectionPoliciesRequest, ListTlsInspectionPoliciesPagedResponse>
      listTlsInspectionPoliciesPagedCallable;
  private final UnaryCallable<GetTlsInspectionPolicyRequest, TlsInspectionPolicy>
      getTlsInspectionPolicyCallable;
  private final UnaryCallable<CreateTlsInspectionPolicyRequest, Operation>
      createTlsInspectionPolicyCallable;
  private final OperationCallable<
          CreateTlsInspectionPolicyRequest, TlsInspectionPolicy, OperationMetadata>
      createTlsInspectionPolicyOperationCallable;
  private final UnaryCallable<UpdateTlsInspectionPolicyRequest, Operation>
      updateTlsInspectionPolicyCallable;
  private final OperationCallable<
          UpdateTlsInspectionPolicyRequest, TlsInspectionPolicy, OperationMetadata>
      updateTlsInspectionPolicyOperationCallable;
  private final UnaryCallable<DeleteTlsInspectionPolicyRequest, Operation>
      deleteTlsInspectionPolicyCallable;
  private final OperationCallable<DeleteTlsInspectionPolicyRequest, Empty, OperationMetadata>
      deleteTlsInspectionPolicyOperationCallable;
  private final UnaryCallable<ListAuthzPoliciesRequest, ListAuthzPoliciesResponse>
      listAuthzPoliciesCallable;
  private final UnaryCallable<ListAuthzPoliciesRequest, ListAuthzPoliciesPagedResponse>
      listAuthzPoliciesPagedCallable;
  private final UnaryCallable<GetAuthzPolicyRequest, AuthzPolicy> getAuthzPolicyCallable;
  private final UnaryCallable<CreateAuthzPolicyRequest, Operation> createAuthzPolicyCallable;
  private final OperationCallable<CreateAuthzPolicyRequest, AuthzPolicy, OperationMetadata>
      createAuthzPolicyOperationCallable;
  private final UnaryCallable<UpdateAuthzPolicyRequest, Operation> updateAuthzPolicyCallable;
  private final OperationCallable<UpdateAuthzPolicyRequest, AuthzPolicy, OperationMetadata>
      updateAuthzPolicyOperationCallable;
  private final UnaryCallable<DeleteAuthzPolicyRequest, Operation> deleteAuthzPolicyCallable;
  private final OperationCallable<DeleteAuthzPolicyRequest, Empty, OperationMetadata>
      deleteAuthzPolicyOperationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcNetworkSecurityStub create(NetworkSecurityStubSettings settings)
      throws IOException {
    return new GrpcNetworkSecurityStub(settings, ClientContext.create(settings));
  }

  public static final GrpcNetworkSecurityStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcNetworkSecurityStub(
        NetworkSecurityStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcNetworkSecurityStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcNetworkSecurityStub(
        NetworkSecurityStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcNetworkSecurityStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcNetworkSecurityStub(
      NetworkSecurityStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcNetworkSecurityCallableFactory());
  }

  /**
   * Constructs an instance of GrpcNetworkSecurityStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcNetworkSecurityStub(
      NetworkSecurityStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListAuthorizationPoliciesRequest, ListAuthorizationPoliciesResponse>
        listAuthorizationPoliciesTransportSettings =
            GrpcCallSettings
                .<ListAuthorizationPoliciesRequest, ListAuthorizationPoliciesResponse>newBuilder()
                .setMethodDescriptor(listAuthorizationPoliciesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetAuthorizationPolicyRequest, AuthorizationPolicy>
        getAuthorizationPolicyTransportSettings =
            GrpcCallSettings.<GetAuthorizationPolicyRequest, AuthorizationPolicy>newBuilder()
                .setMethodDescriptor(getAuthorizationPolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<CreateAuthorizationPolicyRequest, Operation>
        createAuthorizationPolicyTransportSettings =
            GrpcCallSettings.<CreateAuthorizationPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(createAuthorizationPolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<UpdateAuthorizationPolicyRequest, Operation>
        updateAuthorizationPolicyTransportSettings =
            GrpcCallSettings.<UpdateAuthorizationPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(updateAuthorizationPolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "authorization_policy.name",
                          String.valueOf(request.getAuthorizationPolicy().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteAuthorizationPolicyRequest, Operation>
        deleteAuthorizationPolicyTransportSettings =
            GrpcCallSettings.<DeleteAuthorizationPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteAuthorizationPolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<
            ListBackendAuthenticationConfigsRequest, ListBackendAuthenticationConfigsResponse>
        listBackendAuthenticationConfigsTransportSettings =
            GrpcCallSettings
                .<ListBackendAuthenticationConfigsRequest, ListBackendAuthenticationConfigsResponse>
                    newBuilder()
                .setMethodDescriptor(listBackendAuthenticationConfigsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetBackendAuthenticationConfigRequest, BackendAuthenticationConfig>
        getBackendAuthenticationConfigTransportSettings =
            GrpcCallSettings
                .<GetBackendAuthenticationConfigRequest, BackendAuthenticationConfig>newBuilder()
                .setMethodDescriptor(getBackendAuthenticationConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<CreateBackendAuthenticationConfigRequest, Operation>
        createBackendAuthenticationConfigTransportSettings =
            GrpcCallSettings.<CreateBackendAuthenticationConfigRequest, Operation>newBuilder()
                .setMethodDescriptor(createBackendAuthenticationConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<UpdateBackendAuthenticationConfigRequest, Operation>
        updateBackendAuthenticationConfigTransportSettings =
            GrpcCallSettings.<UpdateBackendAuthenticationConfigRequest, Operation>newBuilder()
                .setMethodDescriptor(updateBackendAuthenticationConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "backend_authentication_config.name",
                          String.valueOf(request.getBackendAuthenticationConfig().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteBackendAuthenticationConfigRequest, Operation>
        deleteBackendAuthenticationConfigTransportSettings =
            GrpcCallSettings.<DeleteBackendAuthenticationConfigRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteBackendAuthenticationConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<ListServerTlsPoliciesRequest, ListServerTlsPoliciesResponse>
        listServerTlsPoliciesTransportSettings =
            GrpcCallSettings
                .<ListServerTlsPoliciesRequest, ListServerTlsPoliciesResponse>newBuilder()
                .setMethodDescriptor(listServerTlsPoliciesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetServerTlsPolicyRequest, ServerTlsPolicy>
        getServerTlsPolicyTransportSettings =
            GrpcCallSettings.<GetServerTlsPolicyRequest, ServerTlsPolicy>newBuilder()
                .setMethodDescriptor(getServerTlsPolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<CreateServerTlsPolicyRequest, Operation>
        createServerTlsPolicyTransportSettings =
            GrpcCallSettings.<CreateServerTlsPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(createServerTlsPolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<UpdateServerTlsPolicyRequest, Operation>
        updateServerTlsPolicyTransportSettings =
            GrpcCallSettings.<UpdateServerTlsPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(updateServerTlsPolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "server_tls_policy.name",
                          String.valueOf(request.getServerTlsPolicy().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteServerTlsPolicyRequest, Operation>
        deleteServerTlsPolicyTransportSettings =
            GrpcCallSettings.<DeleteServerTlsPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteServerTlsPolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<ListClientTlsPoliciesRequest, ListClientTlsPoliciesResponse>
        listClientTlsPoliciesTransportSettings =
            GrpcCallSettings
                .<ListClientTlsPoliciesRequest, ListClientTlsPoliciesResponse>newBuilder()
                .setMethodDescriptor(listClientTlsPoliciesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetClientTlsPolicyRequest, ClientTlsPolicy>
        getClientTlsPolicyTransportSettings =
            GrpcCallSettings.<GetClientTlsPolicyRequest, ClientTlsPolicy>newBuilder()
                .setMethodDescriptor(getClientTlsPolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<CreateClientTlsPolicyRequest, Operation>
        createClientTlsPolicyTransportSettings =
            GrpcCallSettings.<CreateClientTlsPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(createClientTlsPolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<UpdateClientTlsPolicyRequest, Operation>
        updateClientTlsPolicyTransportSettings =
            GrpcCallSettings.<UpdateClientTlsPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(updateClientTlsPolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "client_tls_policy.name",
                          String.valueOf(request.getClientTlsPolicy().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteClientTlsPolicyRequest, Operation>
        deleteClientTlsPolicyTransportSettings =
            GrpcCallSettings.<DeleteClientTlsPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteClientTlsPolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<ListGatewaySecurityPoliciesRequest, ListGatewaySecurityPoliciesResponse>
        listGatewaySecurityPoliciesTransportSettings =
            GrpcCallSettings
                .<ListGatewaySecurityPoliciesRequest, ListGatewaySecurityPoliciesResponse>
                    newBuilder()
                .setMethodDescriptor(listGatewaySecurityPoliciesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetGatewaySecurityPolicyRequest, GatewaySecurityPolicy>
        getGatewaySecurityPolicyTransportSettings =
            GrpcCallSettings.<GetGatewaySecurityPolicyRequest, GatewaySecurityPolicy>newBuilder()
                .setMethodDescriptor(getGatewaySecurityPolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<CreateGatewaySecurityPolicyRequest, Operation>
        createGatewaySecurityPolicyTransportSettings =
            GrpcCallSettings.<CreateGatewaySecurityPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(createGatewaySecurityPolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<UpdateGatewaySecurityPolicyRequest, Operation>
        updateGatewaySecurityPolicyTransportSettings =
            GrpcCallSettings.<UpdateGatewaySecurityPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(updateGatewaySecurityPolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "gateway_security_policy.name",
                          String.valueOf(request.getGatewaySecurityPolicy().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteGatewaySecurityPolicyRequest, Operation>
        deleteGatewaySecurityPolicyTransportSettings =
            GrpcCallSettings.<DeleteGatewaySecurityPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteGatewaySecurityPolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<ListGatewaySecurityPolicyRulesRequest, ListGatewaySecurityPolicyRulesResponse>
        listGatewaySecurityPolicyRulesTransportSettings =
            GrpcCallSettings
                .<ListGatewaySecurityPolicyRulesRequest, ListGatewaySecurityPolicyRulesResponse>
                    newBuilder()
                .setMethodDescriptor(listGatewaySecurityPolicyRulesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetGatewaySecurityPolicyRuleRequest, GatewaySecurityPolicyRule>
        getGatewaySecurityPolicyRuleTransportSettings =
            GrpcCallSettings
                .<GetGatewaySecurityPolicyRuleRequest, GatewaySecurityPolicyRule>newBuilder()
                .setMethodDescriptor(getGatewaySecurityPolicyRuleMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<CreateGatewaySecurityPolicyRuleRequest, Operation>
        createGatewaySecurityPolicyRuleTransportSettings =
            GrpcCallSettings.<CreateGatewaySecurityPolicyRuleRequest, Operation>newBuilder()
                .setMethodDescriptor(createGatewaySecurityPolicyRuleMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<UpdateGatewaySecurityPolicyRuleRequest, Operation>
        updateGatewaySecurityPolicyRuleTransportSettings =
            GrpcCallSettings.<UpdateGatewaySecurityPolicyRuleRequest, Operation>newBuilder()
                .setMethodDescriptor(updateGatewaySecurityPolicyRuleMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "gateway_security_policy_rule.name",
                          String.valueOf(request.getGatewaySecurityPolicyRule().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteGatewaySecurityPolicyRuleRequest, Operation>
        deleteGatewaySecurityPolicyRuleTransportSettings =
            GrpcCallSettings.<DeleteGatewaySecurityPolicyRuleRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteGatewaySecurityPolicyRuleMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<ListUrlListsRequest, ListUrlListsResponse> listUrlListsTransportSettings =
        GrpcCallSettings.<ListUrlListsRequest, ListUrlListsResponse>newBuilder()
            .setMethodDescriptor(listUrlListsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<GetUrlListRequest, UrlList> getUrlListTransportSettings =
        GrpcCallSettings.<GetUrlListRequest, UrlList>newBuilder()
            .setMethodDescriptor(getUrlListMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<CreateUrlListRequest, Operation> createUrlListTransportSettings =
        GrpcCallSettings.<CreateUrlListRequest, Operation>newBuilder()
            .setMethodDescriptor(createUrlListMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<UpdateUrlListRequest, Operation> updateUrlListTransportSettings =
        GrpcCallSettings.<UpdateUrlListRequest, Operation>newBuilder()
            .setMethodDescriptor(updateUrlListMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("url_list.name", String.valueOf(request.getUrlList().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteUrlListRequest, Operation> deleteUrlListTransportSettings =
        GrpcCallSettings.<DeleteUrlListRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteUrlListMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ListTlsInspectionPoliciesRequest, ListTlsInspectionPoliciesResponse>
        listTlsInspectionPoliciesTransportSettings =
            GrpcCallSettings
                .<ListTlsInspectionPoliciesRequest, ListTlsInspectionPoliciesResponse>newBuilder()
                .setMethodDescriptor(listTlsInspectionPoliciesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetTlsInspectionPolicyRequest, TlsInspectionPolicy>
        getTlsInspectionPolicyTransportSettings =
            GrpcCallSettings.<GetTlsInspectionPolicyRequest, TlsInspectionPolicy>newBuilder()
                .setMethodDescriptor(getTlsInspectionPolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<CreateTlsInspectionPolicyRequest, Operation>
        createTlsInspectionPolicyTransportSettings =
            GrpcCallSettings.<CreateTlsInspectionPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(createTlsInspectionPolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<UpdateTlsInspectionPolicyRequest, Operation>
        updateTlsInspectionPolicyTransportSettings =
            GrpcCallSettings.<UpdateTlsInspectionPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(updateTlsInspectionPolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "tls_inspection_policy.name",
                          String.valueOf(request.getTlsInspectionPolicy().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteTlsInspectionPolicyRequest, Operation>
        deleteTlsInspectionPolicyTransportSettings =
            GrpcCallSettings.<DeleteTlsInspectionPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteTlsInspectionPolicyMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    GrpcCallSettings<ListAuthzPoliciesRequest, ListAuthzPoliciesResponse>
        listAuthzPoliciesTransportSettings =
            GrpcCallSettings.<ListAuthzPoliciesRequest, ListAuthzPoliciesResponse>newBuilder()
                .setMethodDescriptor(listAuthzPoliciesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetAuthzPolicyRequest, AuthzPolicy> getAuthzPolicyTransportSettings =
        GrpcCallSettings.<GetAuthzPolicyRequest, AuthzPolicy>newBuilder()
            .setMethodDescriptor(getAuthzPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<CreateAuthzPolicyRequest, Operation> createAuthzPolicyTransportSettings =
        GrpcCallSettings.<CreateAuthzPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(createAuthzPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<UpdateAuthzPolicyRequest, Operation> updateAuthzPolicyTransportSettings =
        GrpcCallSettings.<UpdateAuthzPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(updateAuthzPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "authz_policy.name", String.valueOf(request.getAuthzPolicy().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteAuthzPolicyRequest, Operation> deleteAuthzPolicyTransportSettings =
        GrpcCallSettings.<DeleteAuthzPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteAuthzPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ListLocationsRequest, ListLocationsResponse> listLocationsTransportSettings =
        GrpcCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
            .setMethodDescriptor(listLocationsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        GrpcCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        GrpcCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getResource())
            .build();
    GrpcCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        GrpcCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getResource())
            .build();
    GrpcCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            GrpcCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("resource", String.valueOf(request.getResource()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getResource())
                .build();

    this.listAuthorizationPoliciesCallable =
        callableFactory.createUnaryCallable(
            listAuthorizationPoliciesTransportSettings,
            settings.listAuthorizationPoliciesSettings(),
            clientContext);
    this.listAuthorizationPoliciesPagedCallable =
        callableFactory.createPagedCallable(
            listAuthorizationPoliciesTransportSettings,
            settings.listAuthorizationPoliciesSettings(),
            clientContext);
    this.getAuthorizationPolicyCallable =
        callableFactory.createUnaryCallable(
            getAuthorizationPolicyTransportSettings,
            settings.getAuthorizationPolicySettings(),
            clientContext);
    this.createAuthorizationPolicyCallable =
        callableFactory.createUnaryCallable(
            createAuthorizationPolicyTransportSettings,
            settings.createAuthorizationPolicySettings(),
            clientContext);
    this.createAuthorizationPolicyOperationCallable =
        callableFactory.createOperationCallable(
            createAuthorizationPolicyTransportSettings,
            settings.createAuthorizationPolicyOperationSettings(),
            clientContext,
            operationsStub);
    this.updateAuthorizationPolicyCallable =
        callableFactory.createUnaryCallable(
            updateAuthorizationPolicyTransportSettings,
            settings.updateAuthorizationPolicySettings(),
            clientContext);
    this.updateAuthorizationPolicyOperationCallable =
        callableFactory.createOperationCallable(
            updateAuthorizationPolicyTransportSettings,
            settings.updateAuthorizationPolicyOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteAuthorizationPolicyCallable =
        callableFactory.createUnaryCallable(
            deleteAuthorizationPolicyTransportSettings,
            settings.deleteAuthorizationPolicySettings(),
            clientContext);
    this.deleteAuthorizationPolicyOperationCallable =
        callableFactory.createOperationCallable(
            deleteAuthorizationPolicyTransportSettings,
            settings.deleteAuthorizationPolicyOperationSettings(),
            clientContext,
            operationsStub);
    this.listBackendAuthenticationConfigsCallable =
        callableFactory.createUnaryCallable(
            listBackendAuthenticationConfigsTransportSettings,
            settings.listBackendAuthenticationConfigsSettings(),
            clientContext);
    this.listBackendAuthenticationConfigsPagedCallable =
        callableFactory.createPagedCallable(
            listBackendAuthenticationConfigsTransportSettings,
            settings.listBackendAuthenticationConfigsSettings(),
            clientContext);
    this.getBackendAuthenticationConfigCallable =
        callableFactory.createUnaryCallable(
            getBackendAuthenticationConfigTransportSettings,
            settings.getBackendAuthenticationConfigSettings(),
            clientContext);
    this.createBackendAuthenticationConfigCallable =
        callableFactory.createUnaryCallable(
            createBackendAuthenticationConfigTransportSettings,
            settings.createBackendAuthenticationConfigSettings(),
            clientContext);
    this.createBackendAuthenticationConfigOperationCallable =
        callableFactory.createOperationCallable(
            createBackendAuthenticationConfigTransportSettings,
            settings.createBackendAuthenticationConfigOperationSettings(),
            clientContext,
            operationsStub);
    this.updateBackendAuthenticationConfigCallable =
        callableFactory.createUnaryCallable(
            updateBackendAuthenticationConfigTransportSettings,
            settings.updateBackendAuthenticationConfigSettings(),
            clientContext);
    this.updateBackendAuthenticationConfigOperationCallable =
        callableFactory.createOperationCallable(
            updateBackendAuthenticationConfigTransportSettings,
            settings.updateBackendAuthenticationConfigOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteBackendAuthenticationConfigCallable =
        callableFactory.createUnaryCallable(
            deleteBackendAuthenticationConfigTransportSettings,
            settings.deleteBackendAuthenticationConfigSettings(),
            clientContext);
    this.deleteBackendAuthenticationConfigOperationCallable =
        callableFactory.createOperationCallable(
            deleteBackendAuthenticationConfigTransportSettings,
            settings.deleteBackendAuthenticationConfigOperationSettings(),
            clientContext,
            operationsStub);
    this.listServerTlsPoliciesCallable =
        callableFactory.createUnaryCallable(
            listServerTlsPoliciesTransportSettings,
            settings.listServerTlsPoliciesSettings(),
            clientContext);
    this.listServerTlsPoliciesPagedCallable =
        callableFactory.createPagedCallable(
            listServerTlsPoliciesTransportSettings,
            settings.listServerTlsPoliciesSettings(),
            clientContext);
    this.getServerTlsPolicyCallable =
        callableFactory.createUnaryCallable(
            getServerTlsPolicyTransportSettings,
            settings.getServerTlsPolicySettings(),
            clientContext);
    this.createServerTlsPolicyCallable =
        callableFactory.createUnaryCallable(
            createServerTlsPolicyTransportSettings,
            settings.createServerTlsPolicySettings(),
            clientContext);
    this.createServerTlsPolicyOperationCallable =
        callableFactory.createOperationCallable(
            createServerTlsPolicyTransportSettings,
            settings.createServerTlsPolicyOperationSettings(),
            clientContext,
            operationsStub);
    this.updateServerTlsPolicyCallable =
        callableFactory.createUnaryCallable(
            updateServerTlsPolicyTransportSettings,
            settings.updateServerTlsPolicySettings(),
            clientContext);
    this.updateServerTlsPolicyOperationCallable =
        callableFactory.createOperationCallable(
            updateServerTlsPolicyTransportSettings,
            settings.updateServerTlsPolicyOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteServerTlsPolicyCallable =
        callableFactory.createUnaryCallable(
            deleteServerTlsPolicyTransportSettings,
            settings.deleteServerTlsPolicySettings(),
            clientContext);
    this.deleteServerTlsPolicyOperationCallable =
        callableFactory.createOperationCallable(
            deleteServerTlsPolicyTransportSettings,
            settings.deleteServerTlsPolicyOperationSettings(),
            clientContext,
            operationsStub);
    this.listClientTlsPoliciesCallable =
        callableFactory.createUnaryCallable(
            listClientTlsPoliciesTransportSettings,
            settings.listClientTlsPoliciesSettings(),
            clientContext);
    this.listClientTlsPoliciesPagedCallable =
        callableFactory.createPagedCallable(
            listClientTlsPoliciesTransportSettings,
            settings.listClientTlsPoliciesSettings(),
            clientContext);
    this.getClientTlsPolicyCallable =
        callableFactory.createUnaryCallable(
            getClientTlsPolicyTransportSettings,
            settings.getClientTlsPolicySettings(),
            clientContext);
    this.createClientTlsPolicyCallable =
        callableFactory.createUnaryCallable(
            createClientTlsPolicyTransportSettings,
            settings.createClientTlsPolicySettings(),
            clientContext);
    this.createClientTlsPolicyOperationCallable =
        callableFactory.createOperationCallable(
            createClientTlsPolicyTransportSettings,
            settings.createClientTlsPolicyOperationSettings(),
            clientContext,
            operationsStub);
    this.updateClientTlsPolicyCallable =
        callableFactory.createUnaryCallable(
            updateClientTlsPolicyTransportSettings,
            settings.updateClientTlsPolicySettings(),
            clientContext);
    this.updateClientTlsPolicyOperationCallable =
        callableFactory.createOperationCallable(
            updateClientTlsPolicyTransportSettings,
            settings.updateClientTlsPolicyOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteClientTlsPolicyCallable =
        callableFactory.createUnaryCallable(
            deleteClientTlsPolicyTransportSettings,
            settings.deleteClientTlsPolicySettings(),
            clientContext);
    this.deleteClientTlsPolicyOperationCallable =
        callableFactory.createOperationCallable(
            deleteClientTlsPolicyTransportSettings,
            settings.deleteClientTlsPolicyOperationSettings(),
            clientContext,
            operationsStub);
    this.listGatewaySecurityPoliciesCallable =
        callableFactory.createUnaryCallable(
            listGatewaySecurityPoliciesTransportSettings,
            settings.listGatewaySecurityPoliciesSettings(),
            clientContext);
    this.listGatewaySecurityPoliciesPagedCallable =
        callableFactory.createPagedCallable(
            listGatewaySecurityPoliciesTransportSettings,
            settings.listGatewaySecurityPoliciesSettings(),
            clientContext);
    this.getGatewaySecurityPolicyCallable =
        callableFactory.createUnaryCallable(
            getGatewaySecurityPolicyTransportSettings,
            settings.getGatewaySecurityPolicySettings(),
            clientContext);
    this.createGatewaySecurityPolicyCallable =
        callableFactory.createUnaryCallable(
            createGatewaySecurityPolicyTransportSettings,
            settings.createGatewaySecurityPolicySettings(),
            clientContext);
    this.createGatewaySecurityPolicyOperationCallable =
        callableFactory.createOperationCallable(
            createGatewaySecurityPolicyTransportSettings,
            settings.createGatewaySecurityPolicyOperationSettings(),
            clientContext,
            operationsStub);
    this.updateGatewaySecurityPolicyCallable =
        callableFactory.createUnaryCallable(
            updateGatewaySecurityPolicyTransportSettings,
            settings.updateGatewaySecurityPolicySettings(),
            clientContext);
    this.updateGatewaySecurityPolicyOperationCallable =
        callableFactory.createOperationCallable(
            updateGatewaySecurityPolicyTransportSettings,
            settings.updateGatewaySecurityPolicyOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteGatewaySecurityPolicyCallable =
        callableFactory.createUnaryCallable(
            deleteGatewaySecurityPolicyTransportSettings,
            settings.deleteGatewaySecurityPolicySettings(),
            clientContext);
    this.deleteGatewaySecurityPolicyOperationCallable =
        callableFactory.createOperationCallable(
            deleteGatewaySecurityPolicyTransportSettings,
            settings.deleteGatewaySecurityPolicyOperationSettings(),
            clientContext,
            operationsStub);
    this.listGatewaySecurityPolicyRulesCallable =
        callableFactory.createUnaryCallable(
            listGatewaySecurityPolicyRulesTransportSettings,
            settings.listGatewaySecurityPolicyRulesSettings(),
            clientContext);
    this.listGatewaySecurityPolicyRulesPagedCallable =
        callableFactory.createPagedCallable(
            listGatewaySecurityPolicyRulesTransportSettings,
            settings.listGatewaySecurityPolicyRulesSettings(),
            clientContext);
    this.getGatewaySecurityPolicyRuleCallable =
        callableFactory.createUnaryCallable(
            getGatewaySecurityPolicyRuleTransportSettings,
            settings.getGatewaySecurityPolicyRuleSettings(),
            clientContext);
    this.createGatewaySecurityPolicyRuleCallable =
        callableFactory.createUnaryCallable(
            createGatewaySecurityPolicyRuleTransportSettings,
            settings.createGatewaySecurityPolicyRuleSettings(),
            clientContext);
    this.createGatewaySecurityPolicyRuleOperationCallable =
        callableFactory.createOperationCallable(
            createGatewaySecurityPolicyRuleTransportSettings,
            settings.createGatewaySecurityPolicyRuleOperationSettings(),
            clientContext,
            operationsStub);
    this.updateGatewaySecurityPolicyRuleCallable =
        callableFactory.createUnaryCallable(
            updateGatewaySecurityPolicyRuleTransportSettings,
            settings.updateGatewaySecurityPolicyRuleSettings(),
            clientContext);
    this.updateGatewaySecurityPolicyRuleOperationCallable =
        callableFactory.createOperationCallable(
            updateGatewaySecurityPolicyRuleTransportSettings,
            settings.updateGatewaySecurityPolicyRuleOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteGatewaySecurityPolicyRuleCallable =
        callableFactory.createUnaryCallable(
            deleteGatewaySecurityPolicyRuleTransportSettings,
            settings.deleteGatewaySecurityPolicyRuleSettings(),
            clientContext);
    this.deleteGatewaySecurityPolicyRuleOperationCallable =
        callableFactory.createOperationCallable(
            deleteGatewaySecurityPolicyRuleTransportSettings,
            settings.deleteGatewaySecurityPolicyRuleOperationSettings(),
            clientContext,
            operationsStub);
    this.listUrlListsCallable =
        callableFactory.createUnaryCallable(
            listUrlListsTransportSettings, settings.listUrlListsSettings(), clientContext);
    this.listUrlListsPagedCallable =
        callableFactory.createPagedCallable(
            listUrlListsTransportSettings, settings.listUrlListsSettings(), clientContext);
    this.getUrlListCallable =
        callableFactory.createUnaryCallable(
            getUrlListTransportSettings, settings.getUrlListSettings(), clientContext);
    this.createUrlListCallable =
        callableFactory.createUnaryCallable(
            createUrlListTransportSettings, settings.createUrlListSettings(), clientContext);
    this.createUrlListOperationCallable =
        callableFactory.createOperationCallable(
            createUrlListTransportSettings,
            settings.createUrlListOperationSettings(),
            clientContext,
            operationsStub);
    this.updateUrlListCallable =
        callableFactory.createUnaryCallable(
            updateUrlListTransportSettings, settings.updateUrlListSettings(), clientContext);
    this.updateUrlListOperationCallable =
        callableFactory.createOperationCallable(
            updateUrlListTransportSettings,
            settings.updateUrlListOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteUrlListCallable =
        callableFactory.createUnaryCallable(
            deleteUrlListTransportSettings, settings.deleteUrlListSettings(), clientContext);
    this.deleteUrlListOperationCallable =
        callableFactory.createOperationCallable(
            deleteUrlListTransportSettings,
            settings.deleteUrlListOperationSettings(),
            clientContext,
            operationsStub);
    this.listTlsInspectionPoliciesCallable =
        callableFactory.createUnaryCallable(
            listTlsInspectionPoliciesTransportSettings,
            settings.listTlsInspectionPoliciesSettings(),
            clientContext);
    this.listTlsInspectionPoliciesPagedCallable =
        callableFactory.createPagedCallable(
            listTlsInspectionPoliciesTransportSettings,
            settings.listTlsInspectionPoliciesSettings(),
            clientContext);
    this.getTlsInspectionPolicyCallable =
        callableFactory.createUnaryCallable(
            getTlsInspectionPolicyTransportSettings,
            settings.getTlsInspectionPolicySettings(),
            clientContext);
    this.createTlsInspectionPolicyCallable =
        callableFactory.createUnaryCallable(
            createTlsInspectionPolicyTransportSettings,
            settings.createTlsInspectionPolicySettings(),
            clientContext);
    this.createTlsInspectionPolicyOperationCallable =
        callableFactory.createOperationCallable(
            createTlsInspectionPolicyTransportSettings,
            settings.createTlsInspectionPolicyOperationSettings(),
            clientContext,
            operationsStub);
    this.updateTlsInspectionPolicyCallable =
        callableFactory.createUnaryCallable(
            updateTlsInspectionPolicyTransportSettings,
            settings.updateTlsInspectionPolicySettings(),
            clientContext);
    this.updateTlsInspectionPolicyOperationCallable =
        callableFactory.createOperationCallable(
            updateTlsInspectionPolicyTransportSettings,
            settings.updateTlsInspectionPolicyOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteTlsInspectionPolicyCallable =
        callableFactory.createUnaryCallable(
            deleteTlsInspectionPolicyTransportSettings,
            settings.deleteTlsInspectionPolicySettings(),
            clientContext);
    this.deleteTlsInspectionPolicyOperationCallable =
        callableFactory.createOperationCallable(
            deleteTlsInspectionPolicyTransportSettings,
            settings.deleteTlsInspectionPolicyOperationSettings(),
            clientContext,
            operationsStub);
    this.listAuthzPoliciesCallable =
        callableFactory.createUnaryCallable(
            listAuthzPoliciesTransportSettings,
            settings.listAuthzPoliciesSettings(),
            clientContext);
    this.listAuthzPoliciesPagedCallable =
        callableFactory.createPagedCallable(
            listAuthzPoliciesTransportSettings,
            settings.listAuthzPoliciesSettings(),
            clientContext);
    this.getAuthzPolicyCallable =
        callableFactory.createUnaryCallable(
            getAuthzPolicyTransportSettings, settings.getAuthzPolicySettings(), clientContext);
    this.createAuthzPolicyCallable =
        callableFactory.createUnaryCallable(
            createAuthzPolicyTransportSettings,
            settings.createAuthzPolicySettings(),
            clientContext);
    this.createAuthzPolicyOperationCallable =
        callableFactory.createOperationCallable(
            createAuthzPolicyTransportSettings,
            settings.createAuthzPolicyOperationSettings(),
            clientContext,
            operationsStub);
    this.updateAuthzPolicyCallable =
        callableFactory.createUnaryCallable(
            updateAuthzPolicyTransportSettings,
            settings.updateAuthzPolicySettings(),
            clientContext);
    this.updateAuthzPolicyOperationCallable =
        callableFactory.createOperationCallable(
            updateAuthzPolicyTransportSettings,
            settings.updateAuthzPolicyOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteAuthzPolicyCallable =
        callableFactory.createUnaryCallable(
            deleteAuthzPolicyTransportSettings,
            settings.deleteAuthzPolicySettings(),
            clientContext);
    this.deleteAuthzPolicyOperationCallable =
        callableFactory.createOperationCallable(
            deleteAuthzPolicyTransportSettings,
            settings.deleteAuthzPolicyOperationSettings(),
            clientContext,
            operationsStub);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.testIamPermissionsCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsTransportSettings,
            settings.testIamPermissionsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListAuthorizationPoliciesRequest, ListAuthorizationPoliciesResponse>
      listAuthorizationPoliciesCallable() {
    return listAuthorizationPoliciesCallable;
  }

  @Override
  public UnaryCallable<ListAuthorizationPoliciesRequest, ListAuthorizationPoliciesPagedResponse>
      listAuthorizationPoliciesPagedCallable() {
    return listAuthorizationPoliciesPagedCallable;
  }

  @Override
  public UnaryCallable<GetAuthorizationPolicyRequest, AuthorizationPolicy>
      getAuthorizationPolicyCallable() {
    return getAuthorizationPolicyCallable;
  }

  @Override
  public UnaryCallable<CreateAuthorizationPolicyRequest, Operation>
      createAuthorizationPolicyCallable() {
    return createAuthorizationPolicyCallable;
  }

  @Override
  public OperationCallable<CreateAuthorizationPolicyRequest, AuthorizationPolicy, OperationMetadata>
      createAuthorizationPolicyOperationCallable() {
    return createAuthorizationPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateAuthorizationPolicyRequest, Operation>
      updateAuthorizationPolicyCallable() {
    return updateAuthorizationPolicyCallable;
  }

  @Override
  public OperationCallable<UpdateAuthorizationPolicyRequest, AuthorizationPolicy, OperationMetadata>
      updateAuthorizationPolicyOperationCallable() {
    return updateAuthorizationPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteAuthorizationPolicyRequest, Operation>
      deleteAuthorizationPolicyCallable() {
    return deleteAuthorizationPolicyCallable;
  }

  @Override
  public OperationCallable<DeleteAuthorizationPolicyRequest, Empty, OperationMetadata>
      deleteAuthorizationPolicyOperationCallable() {
    return deleteAuthorizationPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<
          ListBackendAuthenticationConfigsRequest, ListBackendAuthenticationConfigsResponse>
      listBackendAuthenticationConfigsCallable() {
    return listBackendAuthenticationConfigsCallable;
  }

  @Override
  public UnaryCallable<
          ListBackendAuthenticationConfigsRequest, ListBackendAuthenticationConfigsPagedResponse>
      listBackendAuthenticationConfigsPagedCallable() {
    return listBackendAuthenticationConfigsPagedCallable;
  }

  @Override
  public UnaryCallable<GetBackendAuthenticationConfigRequest, BackendAuthenticationConfig>
      getBackendAuthenticationConfigCallable() {
    return getBackendAuthenticationConfigCallable;
  }

  @Override
  public UnaryCallable<CreateBackendAuthenticationConfigRequest, Operation>
      createBackendAuthenticationConfigCallable() {
    return createBackendAuthenticationConfigCallable;
  }

  @Override
  public OperationCallable<
          CreateBackendAuthenticationConfigRequest, BackendAuthenticationConfig, OperationMetadata>
      createBackendAuthenticationConfigOperationCallable() {
    return createBackendAuthenticationConfigOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateBackendAuthenticationConfigRequest, Operation>
      updateBackendAuthenticationConfigCallable() {
    return updateBackendAuthenticationConfigCallable;
  }

  @Override
  public OperationCallable<
          UpdateBackendAuthenticationConfigRequest, BackendAuthenticationConfig, OperationMetadata>
      updateBackendAuthenticationConfigOperationCallable() {
    return updateBackendAuthenticationConfigOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteBackendAuthenticationConfigRequest, Operation>
      deleteBackendAuthenticationConfigCallable() {
    return deleteBackendAuthenticationConfigCallable;
  }

  @Override
  public OperationCallable<DeleteBackendAuthenticationConfigRequest, Empty, OperationMetadata>
      deleteBackendAuthenticationConfigOperationCallable() {
    return deleteBackendAuthenticationConfigOperationCallable;
  }

  @Override
  public UnaryCallable<ListServerTlsPoliciesRequest, ListServerTlsPoliciesResponse>
      listServerTlsPoliciesCallable() {
    return listServerTlsPoliciesCallable;
  }

  @Override
  public UnaryCallable<ListServerTlsPoliciesRequest, ListServerTlsPoliciesPagedResponse>
      listServerTlsPoliciesPagedCallable() {
    return listServerTlsPoliciesPagedCallable;
  }

  @Override
  public UnaryCallable<GetServerTlsPolicyRequest, ServerTlsPolicy> getServerTlsPolicyCallable() {
    return getServerTlsPolicyCallable;
  }

  @Override
  public UnaryCallable<CreateServerTlsPolicyRequest, Operation> createServerTlsPolicyCallable() {
    return createServerTlsPolicyCallable;
  }

  @Override
  public OperationCallable<CreateServerTlsPolicyRequest, ServerTlsPolicy, OperationMetadata>
      createServerTlsPolicyOperationCallable() {
    return createServerTlsPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateServerTlsPolicyRequest, Operation> updateServerTlsPolicyCallable() {
    return updateServerTlsPolicyCallable;
  }

  @Override
  public OperationCallable<UpdateServerTlsPolicyRequest, ServerTlsPolicy, OperationMetadata>
      updateServerTlsPolicyOperationCallable() {
    return updateServerTlsPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteServerTlsPolicyRequest, Operation> deleteServerTlsPolicyCallable() {
    return deleteServerTlsPolicyCallable;
  }

  @Override
  public OperationCallable<DeleteServerTlsPolicyRequest, Empty, OperationMetadata>
      deleteServerTlsPolicyOperationCallable() {
    return deleteServerTlsPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<ListClientTlsPoliciesRequest, ListClientTlsPoliciesResponse>
      listClientTlsPoliciesCallable() {
    return listClientTlsPoliciesCallable;
  }

  @Override
  public UnaryCallable<ListClientTlsPoliciesRequest, ListClientTlsPoliciesPagedResponse>
      listClientTlsPoliciesPagedCallable() {
    return listClientTlsPoliciesPagedCallable;
  }

  @Override
  public UnaryCallable<GetClientTlsPolicyRequest, ClientTlsPolicy> getClientTlsPolicyCallable() {
    return getClientTlsPolicyCallable;
  }

  @Override
  public UnaryCallable<CreateClientTlsPolicyRequest, Operation> createClientTlsPolicyCallable() {
    return createClientTlsPolicyCallable;
  }

  @Override
  public OperationCallable<CreateClientTlsPolicyRequest, ClientTlsPolicy, OperationMetadata>
      createClientTlsPolicyOperationCallable() {
    return createClientTlsPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateClientTlsPolicyRequest, Operation> updateClientTlsPolicyCallable() {
    return updateClientTlsPolicyCallable;
  }

  @Override
  public OperationCallable<UpdateClientTlsPolicyRequest, ClientTlsPolicy, OperationMetadata>
      updateClientTlsPolicyOperationCallable() {
    return updateClientTlsPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteClientTlsPolicyRequest, Operation> deleteClientTlsPolicyCallable() {
    return deleteClientTlsPolicyCallable;
  }

  @Override
  public OperationCallable<DeleteClientTlsPolicyRequest, Empty, OperationMetadata>
      deleteClientTlsPolicyOperationCallable() {
    return deleteClientTlsPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<ListGatewaySecurityPoliciesRequest, ListGatewaySecurityPoliciesResponse>
      listGatewaySecurityPoliciesCallable() {
    return listGatewaySecurityPoliciesCallable;
  }

  @Override
  public UnaryCallable<ListGatewaySecurityPoliciesRequest, ListGatewaySecurityPoliciesPagedResponse>
      listGatewaySecurityPoliciesPagedCallable() {
    return listGatewaySecurityPoliciesPagedCallable;
  }

  @Override
  public UnaryCallable<GetGatewaySecurityPolicyRequest, GatewaySecurityPolicy>
      getGatewaySecurityPolicyCallable() {
    return getGatewaySecurityPolicyCallable;
  }

  @Override
  public UnaryCallable<CreateGatewaySecurityPolicyRequest, Operation>
      createGatewaySecurityPolicyCallable() {
    return createGatewaySecurityPolicyCallable;
  }

  @Override
  public OperationCallable<
          CreateGatewaySecurityPolicyRequest, GatewaySecurityPolicy, OperationMetadata>
      createGatewaySecurityPolicyOperationCallable() {
    return createGatewaySecurityPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateGatewaySecurityPolicyRequest, Operation>
      updateGatewaySecurityPolicyCallable() {
    return updateGatewaySecurityPolicyCallable;
  }

  @Override
  public OperationCallable<
          UpdateGatewaySecurityPolicyRequest, GatewaySecurityPolicy, OperationMetadata>
      updateGatewaySecurityPolicyOperationCallable() {
    return updateGatewaySecurityPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteGatewaySecurityPolicyRequest, Operation>
      deleteGatewaySecurityPolicyCallable() {
    return deleteGatewaySecurityPolicyCallable;
  }

  @Override
  public OperationCallable<DeleteGatewaySecurityPolicyRequest, Empty, OperationMetadata>
      deleteGatewaySecurityPolicyOperationCallable() {
    return deleteGatewaySecurityPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<
          ListGatewaySecurityPolicyRulesRequest, ListGatewaySecurityPolicyRulesResponse>
      listGatewaySecurityPolicyRulesCallable() {
    return listGatewaySecurityPolicyRulesCallable;
  }

  @Override
  public UnaryCallable<
          ListGatewaySecurityPolicyRulesRequest, ListGatewaySecurityPolicyRulesPagedResponse>
      listGatewaySecurityPolicyRulesPagedCallable() {
    return listGatewaySecurityPolicyRulesPagedCallable;
  }

  @Override
  public UnaryCallable<GetGatewaySecurityPolicyRuleRequest, GatewaySecurityPolicyRule>
      getGatewaySecurityPolicyRuleCallable() {
    return getGatewaySecurityPolicyRuleCallable;
  }

  @Override
  public UnaryCallable<CreateGatewaySecurityPolicyRuleRequest, Operation>
      createGatewaySecurityPolicyRuleCallable() {
    return createGatewaySecurityPolicyRuleCallable;
  }

  @Override
  public OperationCallable<
          CreateGatewaySecurityPolicyRuleRequest, GatewaySecurityPolicyRule, OperationMetadata>
      createGatewaySecurityPolicyRuleOperationCallable() {
    return createGatewaySecurityPolicyRuleOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateGatewaySecurityPolicyRuleRequest, Operation>
      updateGatewaySecurityPolicyRuleCallable() {
    return updateGatewaySecurityPolicyRuleCallable;
  }

  @Override
  public OperationCallable<
          UpdateGatewaySecurityPolicyRuleRequest, GatewaySecurityPolicyRule, OperationMetadata>
      updateGatewaySecurityPolicyRuleOperationCallable() {
    return updateGatewaySecurityPolicyRuleOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteGatewaySecurityPolicyRuleRequest, Operation>
      deleteGatewaySecurityPolicyRuleCallable() {
    return deleteGatewaySecurityPolicyRuleCallable;
  }

  @Override
  public OperationCallable<DeleteGatewaySecurityPolicyRuleRequest, Empty, OperationMetadata>
      deleteGatewaySecurityPolicyRuleOperationCallable() {
    return deleteGatewaySecurityPolicyRuleOperationCallable;
  }

  @Override
  public UnaryCallable<ListUrlListsRequest, ListUrlListsResponse> listUrlListsCallable() {
    return listUrlListsCallable;
  }

  @Override
  public UnaryCallable<ListUrlListsRequest, ListUrlListsPagedResponse> listUrlListsPagedCallable() {
    return listUrlListsPagedCallable;
  }

  @Override
  public UnaryCallable<GetUrlListRequest, UrlList> getUrlListCallable() {
    return getUrlListCallable;
  }

  @Override
  public UnaryCallable<CreateUrlListRequest, Operation> createUrlListCallable() {
    return createUrlListCallable;
  }

  @Override
  public OperationCallable<CreateUrlListRequest, UrlList, OperationMetadata>
      createUrlListOperationCallable() {
    return createUrlListOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateUrlListRequest, Operation> updateUrlListCallable() {
    return updateUrlListCallable;
  }

  @Override
  public OperationCallable<UpdateUrlListRequest, UrlList, OperationMetadata>
      updateUrlListOperationCallable() {
    return updateUrlListOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteUrlListRequest, Operation> deleteUrlListCallable() {
    return deleteUrlListCallable;
  }

  @Override
  public OperationCallable<DeleteUrlListRequest, Empty, OperationMetadata>
      deleteUrlListOperationCallable() {
    return deleteUrlListOperationCallable;
  }

  @Override
  public UnaryCallable<ListTlsInspectionPoliciesRequest, ListTlsInspectionPoliciesResponse>
      listTlsInspectionPoliciesCallable() {
    return listTlsInspectionPoliciesCallable;
  }

  @Override
  public UnaryCallable<ListTlsInspectionPoliciesRequest, ListTlsInspectionPoliciesPagedResponse>
      listTlsInspectionPoliciesPagedCallable() {
    return listTlsInspectionPoliciesPagedCallable;
  }

  @Override
  public UnaryCallable<GetTlsInspectionPolicyRequest, TlsInspectionPolicy>
      getTlsInspectionPolicyCallable() {
    return getTlsInspectionPolicyCallable;
  }

  @Override
  public UnaryCallable<CreateTlsInspectionPolicyRequest, Operation>
      createTlsInspectionPolicyCallable() {
    return createTlsInspectionPolicyCallable;
  }

  @Override
  public OperationCallable<CreateTlsInspectionPolicyRequest, TlsInspectionPolicy, OperationMetadata>
      createTlsInspectionPolicyOperationCallable() {
    return createTlsInspectionPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateTlsInspectionPolicyRequest, Operation>
      updateTlsInspectionPolicyCallable() {
    return updateTlsInspectionPolicyCallable;
  }

  @Override
  public OperationCallable<UpdateTlsInspectionPolicyRequest, TlsInspectionPolicy, OperationMetadata>
      updateTlsInspectionPolicyOperationCallable() {
    return updateTlsInspectionPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteTlsInspectionPolicyRequest, Operation>
      deleteTlsInspectionPolicyCallable() {
    return deleteTlsInspectionPolicyCallable;
  }

  @Override
  public OperationCallable<DeleteTlsInspectionPolicyRequest, Empty, OperationMetadata>
      deleteTlsInspectionPolicyOperationCallable() {
    return deleteTlsInspectionPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<ListAuthzPoliciesRequest, ListAuthzPoliciesResponse>
      listAuthzPoliciesCallable() {
    return listAuthzPoliciesCallable;
  }

  @Override
  public UnaryCallable<ListAuthzPoliciesRequest, ListAuthzPoliciesPagedResponse>
      listAuthzPoliciesPagedCallable() {
    return listAuthzPoliciesPagedCallable;
  }

  @Override
  public UnaryCallable<GetAuthzPolicyRequest, AuthzPolicy> getAuthzPolicyCallable() {
    return getAuthzPolicyCallable;
  }

  @Override
  public UnaryCallable<CreateAuthzPolicyRequest, Operation> createAuthzPolicyCallable() {
    return createAuthzPolicyCallable;
  }

  @Override
  public OperationCallable<CreateAuthzPolicyRequest, AuthzPolicy, OperationMetadata>
      createAuthzPolicyOperationCallable() {
    return createAuthzPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateAuthzPolicyRequest, Operation> updateAuthzPolicyCallable() {
    return updateAuthzPolicyCallable;
  }

  @Override
  public OperationCallable<UpdateAuthzPolicyRequest, AuthzPolicy, OperationMetadata>
      updateAuthzPolicyOperationCallable() {
    return updateAuthzPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteAuthzPolicyRequest, Operation> deleteAuthzPolicyCallable() {
    return deleteAuthzPolicyCallable;
  }

  @Override
  public OperationCallable<DeleteAuthzPolicyRequest, Empty, OperationMetadata>
      deleteAuthzPolicyOperationCallable() {
    return deleteAuthzPolicyOperationCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return listLocationsCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return listLocationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return getLocationCallable;
  }

  @Override
  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
  }

  @Override
  public final void close() {
    try {
      backgroundResources.close();
    } catch (RuntimeException e) {
      throw e;
    } catch (Exception e) {
      throw new IllegalStateException("Failed to close resource", e);
    }
  }

  @Override
  public void shutdown() {
    backgroundResources.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return backgroundResources.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return backgroundResources.isTerminated();
  }

  @Override
  public void shutdownNow() {
    backgroundResources.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return backgroundResources.awaitTermination(duration, unit);
  }
}
