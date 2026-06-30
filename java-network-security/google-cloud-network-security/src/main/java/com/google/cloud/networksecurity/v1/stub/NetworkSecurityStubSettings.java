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

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ObsoleteApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.grpc.ProtoOperationTransformers;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.longrunning.OperationTimedPollAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.LibraryMetadata;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link NetworkSecurityStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (networksecurity.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getAuthorizationPolicy:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * NetworkSecurityStubSettings.Builder networkSecuritySettingsBuilder =
 *     NetworkSecurityStubSettings.newBuilder();
 * networkSecuritySettingsBuilder
 *     .getAuthorizationPolicySettings()
 *     .setRetrySettings(
 *         networkSecuritySettingsBuilder
 *             .getAuthorizationPolicySettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofSeconds(1))
 *             .setInitialRpcTimeoutDuration(Duration.ofSeconds(5))
 *             .setMaxAttempts(5)
 *             .setMaxRetryDelayDuration(Duration.ofSeconds(30))
 *             .setMaxRpcTimeoutDuration(Duration.ofSeconds(60))
 *             .setRetryDelayMultiplier(1.3)
 *             .setRpcTimeoutMultiplier(1.5)
 *             .setTotalTimeoutDuration(Duration.ofSeconds(300))
 *             .build());
 * NetworkSecurityStubSettings networkSecuritySettings = networkSecuritySettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createAuthorizationPolicy:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * NetworkSecurityStubSettings.Builder networkSecuritySettingsBuilder =
 *     NetworkSecurityStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * networkSecuritySettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
@SuppressWarnings("CanonicalDuration")
public class NetworkSecurityStubSettings extends StubSettings<NetworkSecurityStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListAuthorizationPoliciesRequest,
          ListAuthorizationPoliciesResponse,
          ListAuthorizationPoliciesPagedResponse>
      listAuthorizationPoliciesSettings;
  private final UnaryCallSettings<GetAuthorizationPolicyRequest, AuthorizationPolicy>
      getAuthorizationPolicySettings;
  private final UnaryCallSettings<CreateAuthorizationPolicyRequest, Operation>
      createAuthorizationPolicySettings;
  private final OperationCallSettings<
          CreateAuthorizationPolicyRequest, AuthorizationPolicy, OperationMetadata>
      createAuthorizationPolicyOperationSettings;
  private final UnaryCallSettings<UpdateAuthorizationPolicyRequest, Operation>
      updateAuthorizationPolicySettings;
  private final OperationCallSettings<
          UpdateAuthorizationPolicyRequest, AuthorizationPolicy, OperationMetadata>
      updateAuthorizationPolicyOperationSettings;
  private final UnaryCallSettings<DeleteAuthorizationPolicyRequest, Operation>
      deleteAuthorizationPolicySettings;
  private final OperationCallSettings<DeleteAuthorizationPolicyRequest, Empty, OperationMetadata>
      deleteAuthorizationPolicyOperationSettings;
  private final PagedCallSettings<
          ListBackendAuthenticationConfigsRequest,
          ListBackendAuthenticationConfigsResponse,
          ListBackendAuthenticationConfigsPagedResponse>
      listBackendAuthenticationConfigsSettings;
  private final UnaryCallSettings<
          GetBackendAuthenticationConfigRequest, BackendAuthenticationConfig>
      getBackendAuthenticationConfigSettings;
  private final UnaryCallSettings<CreateBackendAuthenticationConfigRequest, Operation>
      createBackendAuthenticationConfigSettings;
  private final OperationCallSettings<
          CreateBackendAuthenticationConfigRequest, BackendAuthenticationConfig, OperationMetadata>
      createBackendAuthenticationConfigOperationSettings;
  private final UnaryCallSettings<UpdateBackendAuthenticationConfigRequest, Operation>
      updateBackendAuthenticationConfigSettings;
  private final OperationCallSettings<
          UpdateBackendAuthenticationConfigRequest, BackendAuthenticationConfig, OperationMetadata>
      updateBackendAuthenticationConfigOperationSettings;
  private final UnaryCallSettings<DeleteBackendAuthenticationConfigRequest, Operation>
      deleteBackendAuthenticationConfigSettings;
  private final OperationCallSettings<
          DeleteBackendAuthenticationConfigRequest, Empty, OperationMetadata>
      deleteBackendAuthenticationConfigOperationSettings;
  private final PagedCallSettings<
          ListServerTlsPoliciesRequest,
          ListServerTlsPoliciesResponse,
          ListServerTlsPoliciesPagedResponse>
      listServerTlsPoliciesSettings;
  private final UnaryCallSettings<GetServerTlsPolicyRequest, ServerTlsPolicy>
      getServerTlsPolicySettings;
  private final UnaryCallSettings<CreateServerTlsPolicyRequest, Operation>
      createServerTlsPolicySettings;
  private final OperationCallSettings<
          CreateServerTlsPolicyRequest, ServerTlsPolicy, OperationMetadata>
      createServerTlsPolicyOperationSettings;
  private final UnaryCallSettings<UpdateServerTlsPolicyRequest, Operation>
      updateServerTlsPolicySettings;
  private final OperationCallSettings<
          UpdateServerTlsPolicyRequest, ServerTlsPolicy, OperationMetadata>
      updateServerTlsPolicyOperationSettings;
  private final UnaryCallSettings<DeleteServerTlsPolicyRequest, Operation>
      deleteServerTlsPolicySettings;
  private final OperationCallSettings<DeleteServerTlsPolicyRequest, Empty, OperationMetadata>
      deleteServerTlsPolicyOperationSettings;
  private final PagedCallSettings<
          ListClientTlsPoliciesRequest,
          ListClientTlsPoliciesResponse,
          ListClientTlsPoliciesPagedResponse>
      listClientTlsPoliciesSettings;
  private final UnaryCallSettings<GetClientTlsPolicyRequest, ClientTlsPolicy>
      getClientTlsPolicySettings;
  private final UnaryCallSettings<CreateClientTlsPolicyRequest, Operation>
      createClientTlsPolicySettings;
  private final OperationCallSettings<
          CreateClientTlsPolicyRequest, ClientTlsPolicy, OperationMetadata>
      createClientTlsPolicyOperationSettings;
  private final UnaryCallSettings<UpdateClientTlsPolicyRequest, Operation>
      updateClientTlsPolicySettings;
  private final OperationCallSettings<
          UpdateClientTlsPolicyRequest, ClientTlsPolicy, OperationMetadata>
      updateClientTlsPolicyOperationSettings;
  private final UnaryCallSettings<DeleteClientTlsPolicyRequest, Operation>
      deleteClientTlsPolicySettings;
  private final OperationCallSettings<DeleteClientTlsPolicyRequest, Empty, OperationMetadata>
      deleteClientTlsPolicyOperationSettings;
  private final PagedCallSettings<
          ListGatewaySecurityPoliciesRequest,
          ListGatewaySecurityPoliciesResponse,
          ListGatewaySecurityPoliciesPagedResponse>
      listGatewaySecurityPoliciesSettings;
  private final UnaryCallSettings<GetGatewaySecurityPolicyRequest, GatewaySecurityPolicy>
      getGatewaySecurityPolicySettings;
  private final UnaryCallSettings<CreateGatewaySecurityPolicyRequest, Operation>
      createGatewaySecurityPolicySettings;
  private final OperationCallSettings<
          CreateGatewaySecurityPolicyRequest, GatewaySecurityPolicy, OperationMetadata>
      createGatewaySecurityPolicyOperationSettings;
  private final UnaryCallSettings<UpdateGatewaySecurityPolicyRequest, Operation>
      updateGatewaySecurityPolicySettings;
  private final OperationCallSettings<
          UpdateGatewaySecurityPolicyRequest, GatewaySecurityPolicy, OperationMetadata>
      updateGatewaySecurityPolicyOperationSettings;
  private final UnaryCallSettings<DeleteGatewaySecurityPolicyRequest, Operation>
      deleteGatewaySecurityPolicySettings;
  private final OperationCallSettings<DeleteGatewaySecurityPolicyRequest, Empty, OperationMetadata>
      deleteGatewaySecurityPolicyOperationSettings;
  private final PagedCallSettings<
          ListGatewaySecurityPolicyRulesRequest,
          ListGatewaySecurityPolicyRulesResponse,
          ListGatewaySecurityPolicyRulesPagedResponse>
      listGatewaySecurityPolicyRulesSettings;
  private final UnaryCallSettings<GetGatewaySecurityPolicyRuleRequest, GatewaySecurityPolicyRule>
      getGatewaySecurityPolicyRuleSettings;
  private final UnaryCallSettings<CreateGatewaySecurityPolicyRuleRequest, Operation>
      createGatewaySecurityPolicyRuleSettings;
  private final OperationCallSettings<
          CreateGatewaySecurityPolicyRuleRequest, GatewaySecurityPolicyRule, OperationMetadata>
      createGatewaySecurityPolicyRuleOperationSettings;
  private final UnaryCallSettings<UpdateGatewaySecurityPolicyRuleRequest, Operation>
      updateGatewaySecurityPolicyRuleSettings;
  private final OperationCallSettings<
          UpdateGatewaySecurityPolicyRuleRequest, GatewaySecurityPolicyRule, OperationMetadata>
      updateGatewaySecurityPolicyRuleOperationSettings;
  private final UnaryCallSettings<DeleteGatewaySecurityPolicyRuleRequest, Operation>
      deleteGatewaySecurityPolicyRuleSettings;
  private final OperationCallSettings<
          DeleteGatewaySecurityPolicyRuleRequest, Empty, OperationMetadata>
      deleteGatewaySecurityPolicyRuleOperationSettings;
  private final PagedCallSettings<
          ListUrlListsRequest, ListUrlListsResponse, ListUrlListsPagedResponse>
      listUrlListsSettings;
  private final UnaryCallSettings<GetUrlListRequest, UrlList> getUrlListSettings;
  private final UnaryCallSettings<CreateUrlListRequest, Operation> createUrlListSettings;
  private final OperationCallSettings<CreateUrlListRequest, UrlList, OperationMetadata>
      createUrlListOperationSettings;
  private final UnaryCallSettings<UpdateUrlListRequest, Operation> updateUrlListSettings;
  private final OperationCallSettings<UpdateUrlListRequest, UrlList, OperationMetadata>
      updateUrlListOperationSettings;
  private final UnaryCallSettings<DeleteUrlListRequest, Operation> deleteUrlListSettings;
  private final OperationCallSettings<DeleteUrlListRequest, Empty, OperationMetadata>
      deleteUrlListOperationSettings;
  private final PagedCallSettings<
          ListTlsInspectionPoliciesRequest,
          ListTlsInspectionPoliciesResponse,
          ListTlsInspectionPoliciesPagedResponse>
      listTlsInspectionPoliciesSettings;
  private final UnaryCallSettings<GetTlsInspectionPolicyRequest, TlsInspectionPolicy>
      getTlsInspectionPolicySettings;
  private final UnaryCallSettings<CreateTlsInspectionPolicyRequest, Operation>
      createTlsInspectionPolicySettings;
  private final OperationCallSettings<
          CreateTlsInspectionPolicyRequest, TlsInspectionPolicy, OperationMetadata>
      createTlsInspectionPolicyOperationSettings;
  private final UnaryCallSettings<UpdateTlsInspectionPolicyRequest, Operation>
      updateTlsInspectionPolicySettings;
  private final OperationCallSettings<
          UpdateTlsInspectionPolicyRequest, TlsInspectionPolicy, OperationMetadata>
      updateTlsInspectionPolicyOperationSettings;
  private final UnaryCallSettings<DeleteTlsInspectionPolicyRequest, Operation>
      deleteTlsInspectionPolicySettings;
  private final OperationCallSettings<DeleteTlsInspectionPolicyRequest, Empty, OperationMetadata>
      deleteTlsInspectionPolicyOperationSettings;
  private final PagedCallSettings<
          ListAuthzPoliciesRequest, ListAuthzPoliciesResponse, ListAuthzPoliciesPagedResponse>
      listAuthzPoliciesSettings;
  private final UnaryCallSettings<GetAuthzPolicyRequest, AuthzPolicy> getAuthzPolicySettings;
  private final UnaryCallSettings<CreateAuthzPolicyRequest, Operation> createAuthzPolicySettings;
  private final OperationCallSettings<CreateAuthzPolicyRequest, AuthzPolicy, OperationMetadata>
      createAuthzPolicyOperationSettings;
  private final UnaryCallSettings<UpdateAuthzPolicyRequest, Operation> updateAuthzPolicySettings;
  private final OperationCallSettings<UpdateAuthzPolicyRequest, AuthzPolicy, OperationMetadata>
      updateAuthzPolicyOperationSettings;
  private final UnaryCallSettings<DeleteAuthzPolicyRequest, Operation> deleteAuthzPolicySettings;
  private final OperationCallSettings<DeleteAuthzPolicyRequest, Empty, OperationMetadata>
      deleteAuthzPolicyOperationSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<
          ListAuthorizationPoliciesRequest, ListAuthorizationPoliciesResponse, AuthorizationPolicy>
      LIST_AUTHORIZATION_POLICIES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListAuthorizationPoliciesRequest,
              ListAuthorizationPoliciesResponse,
              AuthorizationPolicy>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAuthorizationPoliciesRequest injectToken(
                ListAuthorizationPoliciesRequest payload, String token) {
              return ListAuthorizationPoliciesRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListAuthorizationPoliciesRequest injectPageSize(
                ListAuthorizationPoliciesRequest payload, int pageSize) {
              return ListAuthorizationPoliciesRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListAuthorizationPoliciesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAuthorizationPoliciesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<AuthorizationPolicy> extractResources(
                ListAuthorizationPoliciesResponse payload) {
              return payload.getAuthorizationPoliciesList();
            }
          };

  private static final PagedListDescriptor<
          ListBackendAuthenticationConfigsRequest,
          ListBackendAuthenticationConfigsResponse,
          BackendAuthenticationConfig>
      LIST_BACKEND_AUTHENTICATION_CONFIGS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListBackendAuthenticationConfigsRequest,
              ListBackendAuthenticationConfigsResponse,
              BackendAuthenticationConfig>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListBackendAuthenticationConfigsRequest injectToken(
                ListBackendAuthenticationConfigsRequest payload, String token) {
              return ListBackendAuthenticationConfigsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListBackendAuthenticationConfigsRequest injectPageSize(
                ListBackendAuthenticationConfigsRequest payload, int pageSize) {
              return ListBackendAuthenticationConfigsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListBackendAuthenticationConfigsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListBackendAuthenticationConfigsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<BackendAuthenticationConfig> extractResources(
                ListBackendAuthenticationConfigsResponse payload) {
              return payload.getBackendAuthenticationConfigsList();
            }
          };

  private static final PagedListDescriptor<
          ListServerTlsPoliciesRequest, ListServerTlsPoliciesResponse, ServerTlsPolicy>
      LIST_SERVER_TLS_POLICIES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListServerTlsPoliciesRequest, ListServerTlsPoliciesResponse, ServerTlsPolicy>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListServerTlsPoliciesRequest injectToken(
                ListServerTlsPoliciesRequest payload, String token) {
              return ListServerTlsPoliciesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListServerTlsPoliciesRequest injectPageSize(
                ListServerTlsPoliciesRequest payload, int pageSize) {
              return ListServerTlsPoliciesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListServerTlsPoliciesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListServerTlsPoliciesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ServerTlsPolicy> extractResources(
                ListServerTlsPoliciesResponse payload) {
              return payload.getServerTlsPoliciesList();
            }
          };

  private static final PagedListDescriptor<
          ListClientTlsPoliciesRequest, ListClientTlsPoliciesResponse, ClientTlsPolicy>
      LIST_CLIENT_TLS_POLICIES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListClientTlsPoliciesRequest, ListClientTlsPoliciesResponse, ClientTlsPolicy>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListClientTlsPoliciesRequest injectToken(
                ListClientTlsPoliciesRequest payload, String token) {
              return ListClientTlsPoliciesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListClientTlsPoliciesRequest injectPageSize(
                ListClientTlsPoliciesRequest payload, int pageSize) {
              return ListClientTlsPoliciesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListClientTlsPoliciesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListClientTlsPoliciesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ClientTlsPolicy> extractResources(
                ListClientTlsPoliciesResponse payload) {
              return payload.getClientTlsPoliciesList();
            }
          };

  private static final PagedListDescriptor<
          ListGatewaySecurityPoliciesRequest,
          ListGatewaySecurityPoliciesResponse,
          GatewaySecurityPolicy>
      LIST_GATEWAY_SECURITY_POLICIES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListGatewaySecurityPoliciesRequest,
              ListGatewaySecurityPoliciesResponse,
              GatewaySecurityPolicy>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListGatewaySecurityPoliciesRequest injectToken(
                ListGatewaySecurityPoliciesRequest payload, String token) {
              return ListGatewaySecurityPoliciesRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListGatewaySecurityPoliciesRequest injectPageSize(
                ListGatewaySecurityPoliciesRequest payload, int pageSize) {
              return ListGatewaySecurityPoliciesRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListGatewaySecurityPoliciesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListGatewaySecurityPoliciesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<GatewaySecurityPolicy> extractResources(
                ListGatewaySecurityPoliciesResponse payload) {
              return payload.getGatewaySecurityPoliciesList();
            }
          };

  private static final PagedListDescriptor<
          ListGatewaySecurityPolicyRulesRequest,
          ListGatewaySecurityPolicyRulesResponse,
          GatewaySecurityPolicyRule>
      LIST_GATEWAY_SECURITY_POLICY_RULES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListGatewaySecurityPolicyRulesRequest,
              ListGatewaySecurityPolicyRulesResponse,
              GatewaySecurityPolicyRule>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListGatewaySecurityPolicyRulesRequest injectToken(
                ListGatewaySecurityPolicyRulesRequest payload, String token) {
              return ListGatewaySecurityPolicyRulesRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListGatewaySecurityPolicyRulesRequest injectPageSize(
                ListGatewaySecurityPolicyRulesRequest payload, int pageSize) {
              return ListGatewaySecurityPolicyRulesRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListGatewaySecurityPolicyRulesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListGatewaySecurityPolicyRulesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<GatewaySecurityPolicyRule> extractResources(
                ListGatewaySecurityPolicyRulesResponse payload) {
              return payload.getGatewaySecurityPolicyRulesList();
            }
          };

  private static final PagedListDescriptor<ListUrlListsRequest, ListUrlListsResponse, UrlList>
      LIST_URL_LISTS_PAGE_STR_DESC =
          new PagedListDescriptor<ListUrlListsRequest, ListUrlListsResponse, UrlList>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListUrlListsRequest injectToken(ListUrlListsRequest payload, String token) {
              return ListUrlListsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListUrlListsRequest injectPageSize(ListUrlListsRequest payload, int pageSize) {
              return ListUrlListsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListUrlListsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListUrlListsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<UrlList> extractResources(ListUrlListsResponse payload) {
              return payload.getUrlListsList();
            }
          };

  private static final PagedListDescriptor<
          ListTlsInspectionPoliciesRequest, ListTlsInspectionPoliciesResponse, TlsInspectionPolicy>
      LIST_TLS_INSPECTION_POLICIES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListTlsInspectionPoliciesRequest,
              ListTlsInspectionPoliciesResponse,
              TlsInspectionPolicy>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListTlsInspectionPoliciesRequest injectToken(
                ListTlsInspectionPoliciesRequest payload, String token) {
              return ListTlsInspectionPoliciesRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListTlsInspectionPoliciesRequest injectPageSize(
                ListTlsInspectionPoliciesRequest payload, int pageSize) {
              return ListTlsInspectionPoliciesRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListTlsInspectionPoliciesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListTlsInspectionPoliciesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<TlsInspectionPolicy> extractResources(
                ListTlsInspectionPoliciesResponse payload) {
              return payload.getTlsInspectionPoliciesList();
            }
          };

  private static final PagedListDescriptor<
          ListAuthzPoliciesRequest, ListAuthzPoliciesResponse, AuthzPolicy>
      LIST_AUTHZ_POLICIES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListAuthzPoliciesRequest, ListAuthzPoliciesResponse, AuthzPolicy>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAuthzPoliciesRequest injectToken(
                ListAuthzPoliciesRequest payload, String token) {
              return ListAuthzPoliciesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAuthzPoliciesRequest injectPageSize(
                ListAuthzPoliciesRequest payload, int pageSize) {
              return ListAuthzPoliciesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAuthzPoliciesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAuthzPoliciesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<AuthzPolicy> extractResources(ListAuthzPoliciesResponse payload) {
              return payload.getAuthzPoliciesList();
            }
          };

  private static final PagedListDescriptor<ListLocationsRequest, ListLocationsResponse, Location>
      LIST_LOCATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListLocationsRequest, ListLocationsResponse, Location>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListLocationsRequest injectToken(ListLocationsRequest payload, String token) {
              return ListLocationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListLocationsRequest injectPageSize(ListLocationsRequest payload, int pageSize) {
              return ListLocationsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListLocationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListLocationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Location> extractResources(ListLocationsResponse payload) {
              return payload.getLocationsList();
            }
          };

  private static final PagedListResponseFactory<
          ListAuthorizationPoliciesRequest,
          ListAuthorizationPoliciesResponse,
          ListAuthorizationPoliciesPagedResponse>
      LIST_AUTHORIZATION_POLICIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAuthorizationPoliciesRequest,
              ListAuthorizationPoliciesResponse,
              ListAuthorizationPoliciesPagedResponse>() {
            @Override
            public ApiFuture<ListAuthorizationPoliciesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAuthorizationPoliciesRequest, ListAuthorizationPoliciesResponse>
                    callable,
                ListAuthorizationPoliciesRequest request,
                ApiCallContext context,
                ApiFuture<ListAuthorizationPoliciesResponse> futureResponse) {
              PageContext<
                      ListAuthorizationPoliciesRequest,
                      ListAuthorizationPoliciesResponse,
                      AuthorizationPolicy>
                  pageContext =
                      PageContext.create(
                          callable, LIST_AUTHORIZATION_POLICIES_PAGE_STR_DESC, request, context);
              return ListAuthorizationPoliciesPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListBackendAuthenticationConfigsRequest,
          ListBackendAuthenticationConfigsResponse,
          ListBackendAuthenticationConfigsPagedResponse>
      LIST_BACKEND_AUTHENTICATION_CONFIGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListBackendAuthenticationConfigsRequest,
              ListBackendAuthenticationConfigsResponse,
              ListBackendAuthenticationConfigsPagedResponse>() {
            @Override
            public ApiFuture<ListBackendAuthenticationConfigsPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        ListBackendAuthenticationConfigsRequest,
                        ListBackendAuthenticationConfigsResponse>
                    callable,
                ListBackendAuthenticationConfigsRequest request,
                ApiCallContext context,
                ApiFuture<ListBackendAuthenticationConfigsResponse> futureResponse) {
              PageContext<
                      ListBackendAuthenticationConfigsRequest,
                      ListBackendAuthenticationConfigsResponse,
                      BackendAuthenticationConfig>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_BACKEND_AUTHENTICATION_CONFIGS_PAGE_STR_DESC,
                          request,
                          context);
              return ListBackendAuthenticationConfigsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListServerTlsPoliciesRequest,
          ListServerTlsPoliciesResponse,
          ListServerTlsPoliciesPagedResponse>
      LIST_SERVER_TLS_POLICIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListServerTlsPoliciesRequest,
              ListServerTlsPoliciesResponse,
              ListServerTlsPoliciesPagedResponse>() {
            @Override
            public ApiFuture<ListServerTlsPoliciesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListServerTlsPoliciesRequest, ListServerTlsPoliciesResponse> callable,
                ListServerTlsPoliciesRequest request,
                ApiCallContext context,
                ApiFuture<ListServerTlsPoliciesResponse> futureResponse) {
              PageContext<
                      ListServerTlsPoliciesRequest, ListServerTlsPoliciesResponse, ServerTlsPolicy>
                  pageContext =
                      PageContext.create(
                          callable, LIST_SERVER_TLS_POLICIES_PAGE_STR_DESC, request, context);
              return ListServerTlsPoliciesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListClientTlsPoliciesRequest,
          ListClientTlsPoliciesResponse,
          ListClientTlsPoliciesPagedResponse>
      LIST_CLIENT_TLS_POLICIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListClientTlsPoliciesRequest,
              ListClientTlsPoliciesResponse,
              ListClientTlsPoliciesPagedResponse>() {
            @Override
            public ApiFuture<ListClientTlsPoliciesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListClientTlsPoliciesRequest, ListClientTlsPoliciesResponse> callable,
                ListClientTlsPoliciesRequest request,
                ApiCallContext context,
                ApiFuture<ListClientTlsPoliciesResponse> futureResponse) {
              PageContext<
                      ListClientTlsPoliciesRequest, ListClientTlsPoliciesResponse, ClientTlsPolicy>
                  pageContext =
                      PageContext.create(
                          callable, LIST_CLIENT_TLS_POLICIES_PAGE_STR_DESC, request, context);
              return ListClientTlsPoliciesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListGatewaySecurityPoliciesRequest,
          ListGatewaySecurityPoliciesResponse,
          ListGatewaySecurityPoliciesPagedResponse>
      LIST_GATEWAY_SECURITY_POLICIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListGatewaySecurityPoliciesRequest,
              ListGatewaySecurityPoliciesResponse,
              ListGatewaySecurityPoliciesPagedResponse>() {
            @Override
            public ApiFuture<ListGatewaySecurityPoliciesPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        ListGatewaySecurityPoliciesRequest, ListGatewaySecurityPoliciesResponse>
                    callable,
                ListGatewaySecurityPoliciesRequest request,
                ApiCallContext context,
                ApiFuture<ListGatewaySecurityPoliciesResponse> futureResponse) {
              PageContext<
                      ListGatewaySecurityPoliciesRequest,
                      ListGatewaySecurityPoliciesResponse,
                      GatewaySecurityPolicy>
                  pageContext =
                      PageContext.create(
                          callable, LIST_GATEWAY_SECURITY_POLICIES_PAGE_STR_DESC, request, context);
              return ListGatewaySecurityPoliciesPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListGatewaySecurityPolicyRulesRequest,
          ListGatewaySecurityPolicyRulesResponse,
          ListGatewaySecurityPolicyRulesPagedResponse>
      LIST_GATEWAY_SECURITY_POLICY_RULES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListGatewaySecurityPolicyRulesRequest,
              ListGatewaySecurityPolicyRulesResponse,
              ListGatewaySecurityPolicyRulesPagedResponse>() {
            @Override
            public ApiFuture<ListGatewaySecurityPolicyRulesPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        ListGatewaySecurityPolicyRulesRequest,
                        ListGatewaySecurityPolicyRulesResponse>
                    callable,
                ListGatewaySecurityPolicyRulesRequest request,
                ApiCallContext context,
                ApiFuture<ListGatewaySecurityPolicyRulesResponse> futureResponse) {
              PageContext<
                      ListGatewaySecurityPolicyRulesRequest,
                      ListGatewaySecurityPolicyRulesResponse,
                      GatewaySecurityPolicyRule>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_GATEWAY_SECURITY_POLICY_RULES_PAGE_STR_DESC,
                          request,
                          context);
              return ListGatewaySecurityPolicyRulesPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListUrlListsRequest, ListUrlListsResponse, ListUrlListsPagedResponse>
      LIST_URL_LISTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListUrlListsRequest, ListUrlListsResponse, ListUrlListsPagedResponse>() {
            @Override
            public ApiFuture<ListUrlListsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListUrlListsRequest, ListUrlListsResponse> callable,
                ListUrlListsRequest request,
                ApiCallContext context,
                ApiFuture<ListUrlListsResponse> futureResponse) {
              PageContext<ListUrlListsRequest, ListUrlListsResponse, UrlList> pageContext =
                  PageContext.create(callable, LIST_URL_LISTS_PAGE_STR_DESC, request, context);
              return ListUrlListsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListTlsInspectionPoliciesRequest,
          ListTlsInspectionPoliciesResponse,
          ListTlsInspectionPoliciesPagedResponse>
      LIST_TLS_INSPECTION_POLICIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListTlsInspectionPoliciesRequest,
              ListTlsInspectionPoliciesResponse,
              ListTlsInspectionPoliciesPagedResponse>() {
            @Override
            public ApiFuture<ListTlsInspectionPoliciesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListTlsInspectionPoliciesRequest, ListTlsInspectionPoliciesResponse>
                    callable,
                ListTlsInspectionPoliciesRequest request,
                ApiCallContext context,
                ApiFuture<ListTlsInspectionPoliciesResponse> futureResponse) {
              PageContext<
                      ListTlsInspectionPoliciesRequest,
                      ListTlsInspectionPoliciesResponse,
                      TlsInspectionPolicy>
                  pageContext =
                      PageContext.create(
                          callable, LIST_TLS_INSPECTION_POLICIES_PAGE_STR_DESC, request, context);
              return ListTlsInspectionPoliciesPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListAuthzPoliciesRequest, ListAuthzPoliciesResponse, ListAuthzPoliciesPagedResponse>
      LIST_AUTHZ_POLICIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAuthzPoliciesRequest,
              ListAuthzPoliciesResponse,
              ListAuthzPoliciesPagedResponse>() {
            @Override
            public ApiFuture<ListAuthzPoliciesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAuthzPoliciesRequest, ListAuthzPoliciesResponse> callable,
                ListAuthzPoliciesRequest request,
                ApiCallContext context,
                ApiFuture<ListAuthzPoliciesResponse> futureResponse) {
              PageContext<ListAuthzPoliciesRequest, ListAuthzPoliciesResponse, AuthzPolicy>
                  pageContext =
                      PageContext.create(
                          callable, LIST_AUTHZ_POLICIES_PAGE_STR_DESC, request, context);
              return ListAuthzPoliciesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      LIST_LOCATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>() {
            @Override
            public ApiFuture<ListLocationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListLocationsRequest, ListLocationsResponse> callable,
                ListLocationsRequest request,
                ApiCallContext context,
                ApiFuture<ListLocationsResponse> futureResponse) {
              PageContext<ListLocationsRequest, ListLocationsResponse, Location> pageContext =
                  PageContext.create(callable, LIST_LOCATIONS_PAGE_STR_DESC, request, context);
              return ListLocationsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listAuthorizationPolicies. */
  public PagedCallSettings<
          ListAuthorizationPoliciesRequest,
          ListAuthorizationPoliciesResponse,
          ListAuthorizationPoliciesPagedResponse>
      listAuthorizationPoliciesSettings() {
    return listAuthorizationPoliciesSettings;
  }

  /** Returns the object with the settings used for calls to getAuthorizationPolicy. */
  public UnaryCallSettings<GetAuthorizationPolicyRequest, AuthorizationPolicy>
      getAuthorizationPolicySettings() {
    return getAuthorizationPolicySettings;
  }

  /** Returns the object with the settings used for calls to createAuthorizationPolicy. */
  public UnaryCallSettings<CreateAuthorizationPolicyRequest, Operation>
      createAuthorizationPolicySettings() {
    return createAuthorizationPolicySettings;
  }

  /** Returns the object with the settings used for calls to createAuthorizationPolicy. */
  public OperationCallSettings<
          CreateAuthorizationPolicyRequest, AuthorizationPolicy, OperationMetadata>
      createAuthorizationPolicyOperationSettings() {
    return createAuthorizationPolicyOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateAuthorizationPolicy. */
  public UnaryCallSettings<UpdateAuthorizationPolicyRequest, Operation>
      updateAuthorizationPolicySettings() {
    return updateAuthorizationPolicySettings;
  }

  /** Returns the object with the settings used for calls to updateAuthorizationPolicy. */
  public OperationCallSettings<
          UpdateAuthorizationPolicyRequest, AuthorizationPolicy, OperationMetadata>
      updateAuthorizationPolicyOperationSettings() {
    return updateAuthorizationPolicyOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteAuthorizationPolicy. */
  public UnaryCallSettings<DeleteAuthorizationPolicyRequest, Operation>
      deleteAuthorizationPolicySettings() {
    return deleteAuthorizationPolicySettings;
  }

  /** Returns the object with the settings used for calls to deleteAuthorizationPolicy. */
  public OperationCallSettings<DeleteAuthorizationPolicyRequest, Empty, OperationMetadata>
      deleteAuthorizationPolicyOperationSettings() {
    return deleteAuthorizationPolicyOperationSettings;
  }

  /** Returns the object with the settings used for calls to listBackendAuthenticationConfigs. */
  public PagedCallSettings<
          ListBackendAuthenticationConfigsRequest,
          ListBackendAuthenticationConfigsResponse,
          ListBackendAuthenticationConfigsPagedResponse>
      listBackendAuthenticationConfigsSettings() {
    return listBackendAuthenticationConfigsSettings;
  }

  /** Returns the object with the settings used for calls to getBackendAuthenticationConfig. */
  public UnaryCallSettings<GetBackendAuthenticationConfigRequest, BackendAuthenticationConfig>
      getBackendAuthenticationConfigSettings() {
    return getBackendAuthenticationConfigSettings;
  }

  /** Returns the object with the settings used for calls to createBackendAuthenticationConfig. */
  public UnaryCallSettings<CreateBackendAuthenticationConfigRequest, Operation>
      createBackendAuthenticationConfigSettings() {
    return createBackendAuthenticationConfigSettings;
  }

  /** Returns the object with the settings used for calls to createBackendAuthenticationConfig. */
  public OperationCallSettings<
          CreateBackendAuthenticationConfigRequest, BackendAuthenticationConfig, OperationMetadata>
      createBackendAuthenticationConfigOperationSettings() {
    return createBackendAuthenticationConfigOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateBackendAuthenticationConfig. */
  public UnaryCallSettings<UpdateBackendAuthenticationConfigRequest, Operation>
      updateBackendAuthenticationConfigSettings() {
    return updateBackendAuthenticationConfigSettings;
  }

  /** Returns the object with the settings used for calls to updateBackendAuthenticationConfig. */
  public OperationCallSettings<
          UpdateBackendAuthenticationConfigRequest, BackendAuthenticationConfig, OperationMetadata>
      updateBackendAuthenticationConfigOperationSettings() {
    return updateBackendAuthenticationConfigOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteBackendAuthenticationConfig. */
  public UnaryCallSettings<DeleteBackendAuthenticationConfigRequest, Operation>
      deleteBackendAuthenticationConfigSettings() {
    return deleteBackendAuthenticationConfigSettings;
  }

  /** Returns the object with the settings used for calls to deleteBackendAuthenticationConfig. */
  public OperationCallSettings<DeleteBackendAuthenticationConfigRequest, Empty, OperationMetadata>
      deleteBackendAuthenticationConfigOperationSettings() {
    return deleteBackendAuthenticationConfigOperationSettings;
  }

  /** Returns the object with the settings used for calls to listServerTlsPolicies. */
  public PagedCallSettings<
          ListServerTlsPoliciesRequest,
          ListServerTlsPoliciesResponse,
          ListServerTlsPoliciesPagedResponse>
      listServerTlsPoliciesSettings() {
    return listServerTlsPoliciesSettings;
  }

  /** Returns the object with the settings used for calls to getServerTlsPolicy. */
  public UnaryCallSettings<GetServerTlsPolicyRequest, ServerTlsPolicy>
      getServerTlsPolicySettings() {
    return getServerTlsPolicySettings;
  }

  /** Returns the object with the settings used for calls to createServerTlsPolicy. */
  public UnaryCallSettings<CreateServerTlsPolicyRequest, Operation>
      createServerTlsPolicySettings() {
    return createServerTlsPolicySettings;
  }

  /** Returns the object with the settings used for calls to createServerTlsPolicy. */
  public OperationCallSettings<CreateServerTlsPolicyRequest, ServerTlsPolicy, OperationMetadata>
      createServerTlsPolicyOperationSettings() {
    return createServerTlsPolicyOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateServerTlsPolicy. */
  public UnaryCallSettings<UpdateServerTlsPolicyRequest, Operation>
      updateServerTlsPolicySettings() {
    return updateServerTlsPolicySettings;
  }

  /** Returns the object with the settings used for calls to updateServerTlsPolicy. */
  public OperationCallSettings<UpdateServerTlsPolicyRequest, ServerTlsPolicy, OperationMetadata>
      updateServerTlsPolicyOperationSettings() {
    return updateServerTlsPolicyOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteServerTlsPolicy. */
  public UnaryCallSettings<DeleteServerTlsPolicyRequest, Operation>
      deleteServerTlsPolicySettings() {
    return deleteServerTlsPolicySettings;
  }

  /** Returns the object with the settings used for calls to deleteServerTlsPolicy. */
  public OperationCallSettings<DeleteServerTlsPolicyRequest, Empty, OperationMetadata>
      deleteServerTlsPolicyOperationSettings() {
    return deleteServerTlsPolicyOperationSettings;
  }

  /** Returns the object with the settings used for calls to listClientTlsPolicies. */
  public PagedCallSettings<
          ListClientTlsPoliciesRequest,
          ListClientTlsPoliciesResponse,
          ListClientTlsPoliciesPagedResponse>
      listClientTlsPoliciesSettings() {
    return listClientTlsPoliciesSettings;
  }

  /** Returns the object with the settings used for calls to getClientTlsPolicy. */
  public UnaryCallSettings<GetClientTlsPolicyRequest, ClientTlsPolicy>
      getClientTlsPolicySettings() {
    return getClientTlsPolicySettings;
  }

  /** Returns the object with the settings used for calls to createClientTlsPolicy. */
  public UnaryCallSettings<CreateClientTlsPolicyRequest, Operation>
      createClientTlsPolicySettings() {
    return createClientTlsPolicySettings;
  }

  /** Returns the object with the settings used for calls to createClientTlsPolicy. */
  public OperationCallSettings<CreateClientTlsPolicyRequest, ClientTlsPolicy, OperationMetadata>
      createClientTlsPolicyOperationSettings() {
    return createClientTlsPolicyOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateClientTlsPolicy. */
  public UnaryCallSettings<UpdateClientTlsPolicyRequest, Operation>
      updateClientTlsPolicySettings() {
    return updateClientTlsPolicySettings;
  }

  /** Returns the object with the settings used for calls to updateClientTlsPolicy. */
  public OperationCallSettings<UpdateClientTlsPolicyRequest, ClientTlsPolicy, OperationMetadata>
      updateClientTlsPolicyOperationSettings() {
    return updateClientTlsPolicyOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteClientTlsPolicy. */
  public UnaryCallSettings<DeleteClientTlsPolicyRequest, Operation>
      deleteClientTlsPolicySettings() {
    return deleteClientTlsPolicySettings;
  }

  /** Returns the object with the settings used for calls to deleteClientTlsPolicy. */
  public OperationCallSettings<DeleteClientTlsPolicyRequest, Empty, OperationMetadata>
      deleteClientTlsPolicyOperationSettings() {
    return deleteClientTlsPolicyOperationSettings;
  }

  /** Returns the object with the settings used for calls to listGatewaySecurityPolicies. */
  public PagedCallSettings<
          ListGatewaySecurityPoliciesRequest,
          ListGatewaySecurityPoliciesResponse,
          ListGatewaySecurityPoliciesPagedResponse>
      listGatewaySecurityPoliciesSettings() {
    return listGatewaySecurityPoliciesSettings;
  }

  /** Returns the object with the settings used for calls to getGatewaySecurityPolicy. */
  public UnaryCallSettings<GetGatewaySecurityPolicyRequest, GatewaySecurityPolicy>
      getGatewaySecurityPolicySettings() {
    return getGatewaySecurityPolicySettings;
  }

  /** Returns the object with the settings used for calls to createGatewaySecurityPolicy. */
  public UnaryCallSettings<CreateGatewaySecurityPolicyRequest, Operation>
      createGatewaySecurityPolicySettings() {
    return createGatewaySecurityPolicySettings;
  }

  /** Returns the object with the settings used for calls to createGatewaySecurityPolicy. */
  public OperationCallSettings<
          CreateGatewaySecurityPolicyRequest, GatewaySecurityPolicy, OperationMetadata>
      createGatewaySecurityPolicyOperationSettings() {
    return createGatewaySecurityPolicyOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateGatewaySecurityPolicy. */
  public UnaryCallSettings<UpdateGatewaySecurityPolicyRequest, Operation>
      updateGatewaySecurityPolicySettings() {
    return updateGatewaySecurityPolicySettings;
  }

  /** Returns the object with the settings used for calls to updateGatewaySecurityPolicy. */
  public OperationCallSettings<
          UpdateGatewaySecurityPolicyRequest, GatewaySecurityPolicy, OperationMetadata>
      updateGatewaySecurityPolicyOperationSettings() {
    return updateGatewaySecurityPolicyOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteGatewaySecurityPolicy. */
  public UnaryCallSettings<DeleteGatewaySecurityPolicyRequest, Operation>
      deleteGatewaySecurityPolicySettings() {
    return deleteGatewaySecurityPolicySettings;
  }

  /** Returns the object with the settings used for calls to deleteGatewaySecurityPolicy. */
  public OperationCallSettings<DeleteGatewaySecurityPolicyRequest, Empty, OperationMetadata>
      deleteGatewaySecurityPolicyOperationSettings() {
    return deleteGatewaySecurityPolicyOperationSettings;
  }

  /** Returns the object with the settings used for calls to listGatewaySecurityPolicyRules. */
  public PagedCallSettings<
          ListGatewaySecurityPolicyRulesRequest,
          ListGatewaySecurityPolicyRulesResponse,
          ListGatewaySecurityPolicyRulesPagedResponse>
      listGatewaySecurityPolicyRulesSettings() {
    return listGatewaySecurityPolicyRulesSettings;
  }

  /** Returns the object with the settings used for calls to getGatewaySecurityPolicyRule. */
  public UnaryCallSettings<GetGatewaySecurityPolicyRuleRequest, GatewaySecurityPolicyRule>
      getGatewaySecurityPolicyRuleSettings() {
    return getGatewaySecurityPolicyRuleSettings;
  }

  /** Returns the object with the settings used for calls to createGatewaySecurityPolicyRule. */
  public UnaryCallSettings<CreateGatewaySecurityPolicyRuleRequest, Operation>
      createGatewaySecurityPolicyRuleSettings() {
    return createGatewaySecurityPolicyRuleSettings;
  }

  /** Returns the object with the settings used for calls to createGatewaySecurityPolicyRule. */
  public OperationCallSettings<
          CreateGatewaySecurityPolicyRuleRequest, GatewaySecurityPolicyRule, OperationMetadata>
      createGatewaySecurityPolicyRuleOperationSettings() {
    return createGatewaySecurityPolicyRuleOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateGatewaySecurityPolicyRule. */
  public UnaryCallSettings<UpdateGatewaySecurityPolicyRuleRequest, Operation>
      updateGatewaySecurityPolicyRuleSettings() {
    return updateGatewaySecurityPolicyRuleSettings;
  }

  /** Returns the object with the settings used for calls to updateGatewaySecurityPolicyRule. */
  public OperationCallSettings<
          UpdateGatewaySecurityPolicyRuleRequest, GatewaySecurityPolicyRule, OperationMetadata>
      updateGatewaySecurityPolicyRuleOperationSettings() {
    return updateGatewaySecurityPolicyRuleOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteGatewaySecurityPolicyRule. */
  public UnaryCallSettings<DeleteGatewaySecurityPolicyRuleRequest, Operation>
      deleteGatewaySecurityPolicyRuleSettings() {
    return deleteGatewaySecurityPolicyRuleSettings;
  }

  /** Returns the object with the settings used for calls to deleteGatewaySecurityPolicyRule. */
  public OperationCallSettings<DeleteGatewaySecurityPolicyRuleRequest, Empty, OperationMetadata>
      deleteGatewaySecurityPolicyRuleOperationSettings() {
    return deleteGatewaySecurityPolicyRuleOperationSettings;
  }

  /** Returns the object with the settings used for calls to listUrlLists. */
  public PagedCallSettings<ListUrlListsRequest, ListUrlListsResponse, ListUrlListsPagedResponse>
      listUrlListsSettings() {
    return listUrlListsSettings;
  }

  /** Returns the object with the settings used for calls to getUrlList. */
  public UnaryCallSettings<GetUrlListRequest, UrlList> getUrlListSettings() {
    return getUrlListSettings;
  }

  /** Returns the object with the settings used for calls to createUrlList. */
  public UnaryCallSettings<CreateUrlListRequest, Operation> createUrlListSettings() {
    return createUrlListSettings;
  }

  /** Returns the object with the settings used for calls to createUrlList. */
  public OperationCallSettings<CreateUrlListRequest, UrlList, OperationMetadata>
      createUrlListOperationSettings() {
    return createUrlListOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateUrlList. */
  public UnaryCallSettings<UpdateUrlListRequest, Operation> updateUrlListSettings() {
    return updateUrlListSettings;
  }

  /** Returns the object with the settings used for calls to updateUrlList. */
  public OperationCallSettings<UpdateUrlListRequest, UrlList, OperationMetadata>
      updateUrlListOperationSettings() {
    return updateUrlListOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteUrlList. */
  public UnaryCallSettings<DeleteUrlListRequest, Operation> deleteUrlListSettings() {
    return deleteUrlListSettings;
  }

  /** Returns the object with the settings used for calls to deleteUrlList. */
  public OperationCallSettings<DeleteUrlListRequest, Empty, OperationMetadata>
      deleteUrlListOperationSettings() {
    return deleteUrlListOperationSettings;
  }

  /** Returns the object with the settings used for calls to listTlsInspectionPolicies. */
  public PagedCallSettings<
          ListTlsInspectionPoliciesRequest,
          ListTlsInspectionPoliciesResponse,
          ListTlsInspectionPoliciesPagedResponse>
      listTlsInspectionPoliciesSettings() {
    return listTlsInspectionPoliciesSettings;
  }

  /** Returns the object with the settings used for calls to getTlsInspectionPolicy. */
  public UnaryCallSettings<GetTlsInspectionPolicyRequest, TlsInspectionPolicy>
      getTlsInspectionPolicySettings() {
    return getTlsInspectionPolicySettings;
  }

  /** Returns the object with the settings used for calls to createTlsInspectionPolicy. */
  public UnaryCallSettings<CreateTlsInspectionPolicyRequest, Operation>
      createTlsInspectionPolicySettings() {
    return createTlsInspectionPolicySettings;
  }

  /** Returns the object with the settings used for calls to createTlsInspectionPolicy. */
  public OperationCallSettings<
          CreateTlsInspectionPolicyRequest, TlsInspectionPolicy, OperationMetadata>
      createTlsInspectionPolicyOperationSettings() {
    return createTlsInspectionPolicyOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateTlsInspectionPolicy. */
  public UnaryCallSettings<UpdateTlsInspectionPolicyRequest, Operation>
      updateTlsInspectionPolicySettings() {
    return updateTlsInspectionPolicySettings;
  }

  /** Returns the object with the settings used for calls to updateTlsInspectionPolicy. */
  public OperationCallSettings<
          UpdateTlsInspectionPolicyRequest, TlsInspectionPolicy, OperationMetadata>
      updateTlsInspectionPolicyOperationSettings() {
    return updateTlsInspectionPolicyOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteTlsInspectionPolicy. */
  public UnaryCallSettings<DeleteTlsInspectionPolicyRequest, Operation>
      deleteTlsInspectionPolicySettings() {
    return deleteTlsInspectionPolicySettings;
  }

  /** Returns the object with the settings used for calls to deleteTlsInspectionPolicy. */
  public OperationCallSettings<DeleteTlsInspectionPolicyRequest, Empty, OperationMetadata>
      deleteTlsInspectionPolicyOperationSettings() {
    return deleteTlsInspectionPolicyOperationSettings;
  }

  /** Returns the object with the settings used for calls to listAuthzPolicies. */
  public PagedCallSettings<
          ListAuthzPoliciesRequest, ListAuthzPoliciesResponse, ListAuthzPoliciesPagedResponse>
      listAuthzPoliciesSettings() {
    return listAuthzPoliciesSettings;
  }

  /** Returns the object with the settings used for calls to getAuthzPolicy. */
  public UnaryCallSettings<GetAuthzPolicyRequest, AuthzPolicy> getAuthzPolicySettings() {
    return getAuthzPolicySettings;
  }

  /** Returns the object with the settings used for calls to createAuthzPolicy. */
  public UnaryCallSettings<CreateAuthzPolicyRequest, Operation> createAuthzPolicySettings() {
    return createAuthzPolicySettings;
  }

  /** Returns the object with the settings used for calls to createAuthzPolicy. */
  public OperationCallSettings<CreateAuthzPolicyRequest, AuthzPolicy, OperationMetadata>
      createAuthzPolicyOperationSettings() {
    return createAuthzPolicyOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateAuthzPolicy. */
  public UnaryCallSettings<UpdateAuthzPolicyRequest, Operation> updateAuthzPolicySettings() {
    return updateAuthzPolicySettings;
  }

  /** Returns the object with the settings used for calls to updateAuthzPolicy. */
  public OperationCallSettings<UpdateAuthzPolicyRequest, AuthzPolicy, OperationMetadata>
      updateAuthzPolicyOperationSettings() {
    return updateAuthzPolicyOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteAuthzPolicy. */
  public UnaryCallSettings<DeleteAuthzPolicyRequest, Operation> deleteAuthzPolicySettings() {
    return deleteAuthzPolicySettings;
  }

  /** Returns the object with the settings used for calls to deleteAuthzPolicy. */
  public OperationCallSettings<DeleteAuthzPolicyRequest, Empty, OperationMetadata>
      deleteAuthzPolicyOperationSettings() {
    return deleteAuthzPolicyOperationSettings;
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return listLocationsSettings;
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return getLocationSettings;
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return setIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return getIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return testIamPermissionsSettings;
  }

  public NetworkSecurityStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcNetworkSecurityStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "networksecurity";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "networksecurity.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "networksecurity.mtls.googleapis.com:443";
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder()
        .setScopesToApply(DEFAULT_SERVICE_SCOPES)
        .setUseJwtAccessWithScope(true);
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(NetworkSecurityStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected NetworkSecurityStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listAuthorizationPoliciesSettings = settingsBuilder.listAuthorizationPoliciesSettings().build();
    getAuthorizationPolicySettings = settingsBuilder.getAuthorizationPolicySettings().build();
    createAuthorizationPolicySettings = settingsBuilder.createAuthorizationPolicySettings().build();
    createAuthorizationPolicyOperationSettings =
        settingsBuilder.createAuthorizationPolicyOperationSettings().build();
    updateAuthorizationPolicySettings = settingsBuilder.updateAuthorizationPolicySettings().build();
    updateAuthorizationPolicyOperationSettings =
        settingsBuilder.updateAuthorizationPolicyOperationSettings().build();
    deleteAuthorizationPolicySettings = settingsBuilder.deleteAuthorizationPolicySettings().build();
    deleteAuthorizationPolicyOperationSettings =
        settingsBuilder.deleteAuthorizationPolicyOperationSettings().build();
    listBackendAuthenticationConfigsSettings =
        settingsBuilder.listBackendAuthenticationConfigsSettings().build();
    getBackendAuthenticationConfigSettings =
        settingsBuilder.getBackendAuthenticationConfigSettings().build();
    createBackendAuthenticationConfigSettings =
        settingsBuilder.createBackendAuthenticationConfigSettings().build();
    createBackendAuthenticationConfigOperationSettings =
        settingsBuilder.createBackendAuthenticationConfigOperationSettings().build();
    updateBackendAuthenticationConfigSettings =
        settingsBuilder.updateBackendAuthenticationConfigSettings().build();
    updateBackendAuthenticationConfigOperationSettings =
        settingsBuilder.updateBackendAuthenticationConfigOperationSettings().build();
    deleteBackendAuthenticationConfigSettings =
        settingsBuilder.deleteBackendAuthenticationConfigSettings().build();
    deleteBackendAuthenticationConfigOperationSettings =
        settingsBuilder.deleteBackendAuthenticationConfigOperationSettings().build();
    listServerTlsPoliciesSettings = settingsBuilder.listServerTlsPoliciesSettings().build();
    getServerTlsPolicySettings = settingsBuilder.getServerTlsPolicySettings().build();
    createServerTlsPolicySettings = settingsBuilder.createServerTlsPolicySettings().build();
    createServerTlsPolicyOperationSettings =
        settingsBuilder.createServerTlsPolicyOperationSettings().build();
    updateServerTlsPolicySettings = settingsBuilder.updateServerTlsPolicySettings().build();
    updateServerTlsPolicyOperationSettings =
        settingsBuilder.updateServerTlsPolicyOperationSettings().build();
    deleteServerTlsPolicySettings = settingsBuilder.deleteServerTlsPolicySettings().build();
    deleteServerTlsPolicyOperationSettings =
        settingsBuilder.deleteServerTlsPolicyOperationSettings().build();
    listClientTlsPoliciesSettings = settingsBuilder.listClientTlsPoliciesSettings().build();
    getClientTlsPolicySettings = settingsBuilder.getClientTlsPolicySettings().build();
    createClientTlsPolicySettings = settingsBuilder.createClientTlsPolicySettings().build();
    createClientTlsPolicyOperationSettings =
        settingsBuilder.createClientTlsPolicyOperationSettings().build();
    updateClientTlsPolicySettings = settingsBuilder.updateClientTlsPolicySettings().build();
    updateClientTlsPolicyOperationSettings =
        settingsBuilder.updateClientTlsPolicyOperationSettings().build();
    deleteClientTlsPolicySettings = settingsBuilder.deleteClientTlsPolicySettings().build();
    deleteClientTlsPolicyOperationSettings =
        settingsBuilder.deleteClientTlsPolicyOperationSettings().build();
    listGatewaySecurityPoliciesSettings =
        settingsBuilder.listGatewaySecurityPoliciesSettings().build();
    getGatewaySecurityPolicySettings = settingsBuilder.getGatewaySecurityPolicySettings().build();
    createGatewaySecurityPolicySettings =
        settingsBuilder.createGatewaySecurityPolicySettings().build();
    createGatewaySecurityPolicyOperationSettings =
        settingsBuilder.createGatewaySecurityPolicyOperationSettings().build();
    updateGatewaySecurityPolicySettings =
        settingsBuilder.updateGatewaySecurityPolicySettings().build();
    updateGatewaySecurityPolicyOperationSettings =
        settingsBuilder.updateGatewaySecurityPolicyOperationSettings().build();
    deleteGatewaySecurityPolicySettings =
        settingsBuilder.deleteGatewaySecurityPolicySettings().build();
    deleteGatewaySecurityPolicyOperationSettings =
        settingsBuilder.deleteGatewaySecurityPolicyOperationSettings().build();
    listGatewaySecurityPolicyRulesSettings =
        settingsBuilder.listGatewaySecurityPolicyRulesSettings().build();
    getGatewaySecurityPolicyRuleSettings =
        settingsBuilder.getGatewaySecurityPolicyRuleSettings().build();
    createGatewaySecurityPolicyRuleSettings =
        settingsBuilder.createGatewaySecurityPolicyRuleSettings().build();
    createGatewaySecurityPolicyRuleOperationSettings =
        settingsBuilder.createGatewaySecurityPolicyRuleOperationSettings().build();
    updateGatewaySecurityPolicyRuleSettings =
        settingsBuilder.updateGatewaySecurityPolicyRuleSettings().build();
    updateGatewaySecurityPolicyRuleOperationSettings =
        settingsBuilder.updateGatewaySecurityPolicyRuleOperationSettings().build();
    deleteGatewaySecurityPolicyRuleSettings =
        settingsBuilder.deleteGatewaySecurityPolicyRuleSettings().build();
    deleteGatewaySecurityPolicyRuleOperationSettings =
        settingsBuilder.deleteGatewaySecurityPolicyRuleOperationSettings().build();
    listUrlListsSettings = settingsBuilder.listUrlListsSettings().build();
    getUrlListSettings = settingsBuilder.getUrlListSettings().build();
    createUrlListSettings = settingsBuilder.createUrlListSettings().build();
    createUrlListOperationSettings = settingsBuilder.createUrlListOperationSettings().build();
    updateUrlListSettings = settingsBuilder.updateUrlListSettings().build();
    updateUrlListOperationSettings = settingsBuilder.updateUrlListOperationSettings().build();
    deleteUrlListSettings = settingsBuilder.deleteUrlListSettings().build();
    deleteUrlListOperationSettings = settingsBuilder.deleteUrlListOperationSettings().build();
    listTlsInspectionPoliciesSettings = settingsBuilder.listTlsInspectionPoliciesSettings().build();
    getTlsInspectionPolicySettings = settingsBuilder.getTlsInspectionPolicySettings().build();
    createTlsInspectionPolicySettings = settingsBuilder.createTlsInspectionPolicySettings().build();
    createTlsInspectionPolicyOperationSettings =
        settingsBuilder.createTlsInspectionPolicyOperationSettings().build();
    updateTlsInspectionPolicySettings = settingsBuilder.updateTlsInspectionPolicySettings().build();
    updateTlsInspectionPolicyOperationSettings =
        settingsBuilder.updateTlsInspectionPolicyOperationSettings().build();
    deleteTlsInspectionPolicySettings = settingsBuilder.deleteTlsInspectionPolicySettings().build();
    deleteTlsInspectionPolicyOperationSettings =
        settingsBuilder.deleteTlsInspectionPolicyOperationSettings().build();
    listAuthzPoliciesSettings = settingsBuilder.listAuthzPoliciesSettings().build();
    getAuthzPolicySettings = settingsBuilder.getAuthzPolicySettings().build();
    createAuthzPolicySettings = settingsBuilder.createAuthzPolicySettings().build();
    createAuthzPolicyOperationSettings =
        settingsBuilder.createAuthzPolicyOperationSettings().build();
    updateAuthzPolicySettings = settingsBuilder.updateAuthzPolicySettings().build();
    updateAuthzPolicyOperationSettings =
        settingsBuilder.updateAuthzPolicyOperationSettings().build();
    deleteAuthzPolicySettings = settingsBuilder.deleteAuthzPolicySettings().build();
    deleteAuthzPolicyOperationSettings =
        settingsBuilder.deleteAuthzPolicyOperationSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  @Override
  protected LibraryMetadata getLibraryMetadata() {
    return LibraryMetadata.newBuilder()
        .setArtifactName("com.google.cloud:google-cloud-network-security")
        .setRepository("googleapis/google-cloud-java")
        .setVersion(Version.VERSION)
        .build();
  }

  /** Builder for NetworkSecurityStubSettings. */
  public static class Builder extends StubSettings.Builder<NetworkSecurityStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListAuthorizationPoliciesRequest,
            ListAuthorizationPoliciesResponse,
            ListAuthorizationPoliciesPagedResponse>
        listAuthorizationPoliciesSettings;
    private final UnaryCallSettings.Builder<GetAuthorizationPolicyRequest, AuthorizationPolicy>
        getAuthorizationPolicySettings;
    private final UnaryCallSettings.Builder<CreateAuthorizationPolicyRequest, Operation>
        createAuthorizationPolicySettings;
    private final OperationCallSettings.Builder<
            CreateAuthorizationPolicyRequest, AuthorizationPolicy, OperationMetadata>
        createAuthorizationPolicyOperationSettings;
    private final UnaryCallSettings.Builder<UpdateAuthorizationPolicyRequest, Operation>
        updateAuthorizationPolicySettings;
    private final OperationCallSettings.Builder<
            UpdateAuthorizationPolicyRequest, AuthorizationPolicy, OperationMetadata>
        updateAuthorizationPolicyOperationSettings;
    private final UnaryCallSettings.Builder<DeleteAuthorizationPolicyRequest, Operation>
        deleteAuthorizationPolicySettings;
    private final OperationCallSettings.Builder<
            DeleteAuthorizationPolicyRequest, Empty, OperationMetadata>
        deleteAuthorizationPolicyOperationSettings;
    private final PagedCallSettings.Builder<
            ListBackendAuthenticationConfigsRequest,
            ListBackendAuthenticationConfigsResponse,
            ListBackendAuthenticationConfigsPagedResponse>
        listBackendAuthenticationConfigsSettings;
    private final UnaryCallSettings.Builder<
            GetBackendAuthenticationConfigRequest, BackendAuthenticationConfig>
        getBackendAuthenticationConfigSettings;
    private final UnaryCallSettings.Builder<CreateBackendAuthenticationConfigRequest, Operation>
        createBackendAuthenticationConfigSettings;
    private final OperationCallSettings.Builder<
            CreateBackendAuthenticationConfigRequest,
            BackendAuthenticationConfig,
            OperationMetadata>
        createBackendAuthenticationConfigOperationSettings;
    private final UnaryCallSettings.Builder<UpdateBackendAuthenticationConfigRequest, Operation>
        updateBackendAuthenticationConfigSettings;
    private final OperationCallSettings.Builder<
            UpdateBackendAuthenticationConfigRequest,
            BackendAuthenticationConfig,
            OperationMetadata>
        updateBackendAuthenticationConfigOperationSettings;
    private final UnaryCallSettings.Builder<DeleteBackendAuthenticationConfigRequest, Operation>
        deleteBackendAuthenticationConfigSettings;
    private final OperationCallSettings.Builder<
            DeleteBackendAuthenticationConfigRequest, Empty, OperationMetadata>
        deleteBackendAuthenticationConfigOperationSettings;
    private final PagedCallSettings.Builder<
            ListServerTlsPoliciesRequest,
            ListServerTlsPoliciesResponse,
            ListServerTlsPoliciesPagedResponse>
        listServerTlsPoliciesSettings;
    private final UnaryCallSettings.Builder<GetServerTlsPolicyRequest, ServerTlsPolicy>
        getServerTlsPolicySettings;
    private final UnaryCallSettings.Builder<CreateServerTlsPolicyRequest, Operation>
        createServerTlsPolicySettings;
    private final OperationCallSettings.Builder<
            CreateServerTlsPolicyRequest, ServerTlsPolicy, OperationMetadata>
        createServerTlsPolicyOperationSettings;
    private final UnaryCallSettings.Builder<UpdateServerTlsPolicyRequest, Operation>
        updateServerTlsPolicySettings;
    private final OperationCallSettings.Builder<
            UpdateServerTlsPolicyRequest, ServerTlsPolicy, OperationMetadata>
        updateServerTlsPolicyOperationSettings;
    private final UnaryCallSettings.Builder<DeleteServerTlsPolicyRequest, Operation>
        deleteServerTlsPolicySettings;
    private final OperationCallSettings.Builder<
            DeleteServerTlsPolicyRequest, Empty, OperationMetadata>
        deleteServerTlsPolicyOperationSettings;
    private final PagedCallSettings.Builder<
            ListClientTlsPoliciesRequest,
            ListClientTlsPoliciesResponse,
            ListClientTlsPoliciesPagedResponse>
        listClientTlsPoliciesSettings;
    private final UnaryCallSettings.Builder<GetClientTlsPolicyRequest, ClientTlsPolicy>
        getClientTlsPolicySettings;
    private final UnaryCallSettings.Builder<CreateClientTlsPolicyRequest, Operation>
        createClientTlsPolicySettings;
    private final OperationCallSettings.Builder<
            CreateClientTlsPolicyRequest, ClientTlsPolicy, OperationMetadata>
        createClientTlsPolicyOperationSettings;
    private final UnaryCallSettings.Builder<UpdateClientTlsPolicyRequest, Operation>
        updateClientTlsPolicySettings;
    private final OperationCallSettings.Builder<
            UpdateClientTlsPolicyRequest, ClientTlsPolicy, OperationMetadata>
        updateClientTlsPolicyOperationSettings;
    private final UnaryCallSettings.Builder<DeleteClientTlsPolicyRequest, Operation>
        deleteClientTlsPolicySettings;
    private final OperationCallSettings.Builder<
            DeleteClientTlsPolicyRequest, Empty, OperationMetadata>
        deleteClientTlsPolicyOperationSettings;
    private final PagedCallSettings.Builder<
            ListGatewaySecurityPoliciesRequest,
            ListGatewaySecurityPoliciesResponse,
            ListGatewaySecurityPoliciesPagedResponse>
        listGatewaySecurityPoliciesSettings;
    private final UnaryCallSettings.Builder<GetGatewaySecurityPolicyRequest, GatewaySecurityPolicy>
        getGatewaySecurityPolicySettings;
    private final UnaryCallSettings.Builder<CreateGatewaySecurityPolicyRequest, Operation>
        createGatewaySecurityPolicySettings;
    private final OperationCallSettings.Builder<
            CreateGatewaySecurityPolicyRequest, GatewaySecurityPolicy, OperationMetadata>
        createGatewaySecurityPolicyOperationSettings;
    private final UnaryCallSettings.Builder<UpdateGatewaySecurityPolicyRequest, Operation>
        updateGatewaySecurityPolicySettings;
    private final OperationCallSettings.Builder<
            UpdateGatewaySecurityPolicyRequest, GatewaySecurityPolicy, OperationMetadata>
        updateGatewaySecurityPolicyOperationSettings;
    private final UnaryCallSettings.Builder<DeleteGatewaySecurityPolicyRequest, Operation>
        deleteGatewaySecurityPolicySettings;
    private final OperationCallSettings.Builder<
            DeleteGatewaySecurityPolicyRequest, Empty, OperationMetadata>
        deleteGatewaySecurityPolicyOperationSettings;
    private final PagedCallSettings.Builder<
            ListGatewaySecurityPolicyRulesRequest,
            ListGatewaySecurityPolicyRulesResponse,
            ListGatewaySecurityPolicyRulesPagedResponse>
        listGatewaySecurityPolicyRulesSettings;
    private final UnaryCallSettings.Builder<
            GetGatewaySecurityPolicyRuleRequest, GatewaySecurityPolicyRule>
        getGatewaySecurityPolicyRuleSettings;
    private final UnaryCallSettings.Builder<CreateGatewaySecurityPolicyRuleRequest, Operation>
        createGatewaySecurityPolicyRuleSettings;
    private final OperationCallSettings.Builder<
            CreateGatewaySecurityPolicyRuleRequest, GatewaySecurityPolicyRule, OperationMetadata>
        createGatewaySecurityPolicyRuleOperationSettings;
    private final UnaryCallSettings.Builder<UpdateGatewaySecurityPolicyRuleRequest, Operation>
        updateGatewaySecurityPolicyRuleSettings;
    private final OperationCallSettings.Builder<
            UpdateGatewaySecurityPolicyRuleRequest, GatewaySecurityPolicyRule, OperationMetadata>
        updateGatewaySecurityPolicyRuleOperationSettings;
    private final UnaryCallSettings.Builder<DeleteGatewaySecurityPolicyRuleRequest, Operation>
        deleteGatewaySecurityPolicyRuleSettings;
    private final OperationCallSettings.Builder<
            DeleteGatewaySecurityPolicyRuleRequest, Empty, OperationMetadata>
        deleteGatewaySecurityPolicyRuleOperationSettings;
    private final PagedCallSettings.Builder<
            ListUrlListsRequest, ListUrlListsResponse, ListUrlListsPagedResponse>
        listUrlListsSettings;
    private final UnaryCallSettings.Builder<GetUrlListRequest, UrlList> getUrlListSettings;
    private final UnaryCallSettings.Builder<CreateUrlListRequest, Operation> createUrlListSettings;
    private final OperationCallSettings.Builder<CreateUrlListRequest, UrlList, OperationMetadata>
        createUrlListOperationSettings;
    private final UnaryCallSettings.Builder<UpdateUrlListRequest, Operation> updateUrlListSettings;
    private final OperationCallSettings.Builder<UpdateUrlListRequest, UrlList, OperationMetadata>
        updateUrlListOperationSettings;
    private final UnaryCallSettings.Builder<DeleteUrlListRequest, Operation> deleteUrlListSettings;
    private final OperationCallSettings.Builder<DeleteUrlListRequest, Empty, OperationMetadata>
        deleteUrlListOperationSettings;
    private final PagedCallSettings.Builder<
            ListTlsInspectionPoliciesRequest,
            ListTlsInspectionPoliciesResponse,
            ListTlsInspectionPoliciesPagedResponse>
        listTlsInspectionPoliciesSettings;
    private final UnaryCallSettings.Builder<GetTlsInspectionPolicyRequest, TlsInspectionPolicy>
        getTlsInspectionPolicySettings;
    private final UnaryCallSettings.Builder<CreateTlsInspectionPolicyRequest, Operation>
        createTlsInspectionPolicySettings;
    private final OperationCallSettings.Builder<
            CreateTlsInspectionPolicyRequest, TlsInspectionPolicy, OperationMetadata>
        createTlsInspectionPolicyOperationSettings;
    private final UnaryCallSettings.Builder<UpdateTlsInspectionPolicyRequest, Operation>
        updateTlsInspectionPolicySettings;
    private final OperationCallSettings.Builder<
            UpdateTlsInspectionPolicyRequest, TlsInspectionPolicy, OperationMetadata>
        updateTlsInspectionPolicyOperationSettings;
    private final UnaryCallSettings.Builder<DeleteTlsInspectionPolicyRequest, Operation>
        deleteTlsInspectionPolicySettings;
    private final OperationCallSettings.Builder<
            DeleteTlsInspectionPolicyRequest, Empty, OperationMetadata>
        deleteTlsInspectionPolicyOperationSettings;
    private final PagedCallSettings.Builder<
            ListAuthzPoliciesRequest, ListAuthzPoliciesResponse, ListAuthzPoliciesPagedResponse>
        listAuthzPoliciesSettings;
    private final UnaryCallSettings.Builder<GetAuthzPolicyRequest, AuthzPolicy>
        getAuthzPolicySettings;
    private final UnaryCallSettings.Builder<CreateAuthzPolicyRequest, Operation>
        createAuthzPolicySettings;
    private final OperationCallSettings.Builder<
            CreateAuthzPolicyRequest, AuthzPolicy, OperationMetadata>
        createAuthzPolicyOperationSettings;
    private final UnaryCallSettings.Builder<UpdateAuthzPolicyRequest, Operation>
        updateAuthzPolicySettings;
    private final OperationCallSettings.Builder<
            UpdateAuthzPolicyRequest, AuthzPolicy, OperationMetadata>
        updateAuthzPolicyOperationSettings;
    private final UnaryCallSettings.Builder<DeleteAuthzPolicyRequest, Operation>
        deleteAuthzPolicySettings;
    private final OperationCallSettings.Builder<DeleteAuthzPolicyRequest, Empty, OperationMetadata>
        deleteAuthzPolicyOperationSettings;
    private final PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings;
    private final UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings;
    private final UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings;
    private final UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings;
    private final UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_0_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listAuthorizationPoliciesSettings =
          PagedCallSettings.newBuilder(LIST_AUTHORIZATION_POLICIES_PAGE_STR_FACT);
      getAuthorizationPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createAuthorizationPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createAuthorizationPolicyOperationSettings = OperationCallSettings.newBuilder();
      updateAuthorizationPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateAuthorizationPolicyOperationSettings = OperationCallSettings.newBuilder();
      deleteAuthorizationPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteAuthorizationPolicyOperationSettings = OperationCallSettings.newBuilder();
      listBackendAuthenticationConfigsSettings =
          PagedCallSettings.newBuilder(LIST_BACKEND_AUTHENTICATION_CONFIGS_PAGE_STR_FACT);
      getBackendAuthenticationConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createBackendAuthenticationConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createBackendAuthenticationConfigOperationSettings = OperationCallSettings.newBuilder();
      updateBackendAuthenticationConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateBackendAuthenticationConfigOperationSettings = OperationCallSettings.newBuilder();
      deleteBackendAuthenticationConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteBackendAuthenticationConfigOperationSettings = OperationCallSettings.newBuilder();
      listServerTlsPoliciesSettings =
          PagedCallSettings.newBuilder(LIST_SERVER_TLS_POLICIES_PAGE_STR_FACT);
      getServerTlsPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createServerTlsPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createServerTlsPolicyOperationSettings = OperationCallSettings.newBuilder();
      updateServerTlsPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateServerTlsPolicyOperationSettings = OperationCallSettings.newBuilder();
      deleteServerTlsPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteServerTlsPolicyOperationSettings = OperationCallSettings.newBuilder();
      listClientTlsPoliciesSettings =
          PagedCallSettings.newBuilder(LIST_CLIENT_TLS_POLICIES_PAGE_STR_FACT);
      getClientTlsPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createClientTlsPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createClientTlsPolicyOperationSettings = OperationCallSettings.newBuilder();
      updateClientTlsPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateClientTlsPolicyOperationSettings = OperationCallSettings.newBuilder();
      deleteClientTlsPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteClientTlsPolicyOperationSettings = OperationCallSettings.newBuilder();
      listGatewaySecurityPoliciesSettings =
          PagedCallSettings.newBuilder(LIST_GATEWAY_SECURITY_POLICIES_PAGE_STR_FACT);
      getGatewaySecurityPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createGatewaySecurityPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createGatewaySecurityPolicyOperationSettings = OperationCallSettings.newBuilder();
      updateGatewaySecurityPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateGatewaySecurityPolicyOperationSettings = OperationCallSettings.newBuilder();
      deleteGatewaySecurityPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteGatewaySecurityPolicyOperationSettings = OperationCallSettings.newBuilder();
      listGatewaySecurityPolicyRulesSettings =
          PagedCallSettings.newBuilder(LIST_GATEWAY_SECURITY_POLICY_RULES_PAGE_STR_FACT);
      getGatewaySecurityPolicyRuleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createGatewaySecurityPolicyRuleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createGatewaySecurityPolicyRuleOperationSettings = OperationCallSettings.newBuilder();
      updateGatewaySecurityPolicyRuleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateGatewaySecurityPolicyRuleOperationSettings = OperationCallSettings.newBuilder();
      deleteGatewaySecurityPolicyRuleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteGatewaySecurityPolicyRuleOperationSettings = OperationCallSettings.newBuilder();
      listUrlListsSettings = PagedCallSettings.newBuilder(LIST_URL_LISTS_PAGE_STR_FACT);
      getUrlListSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createUrlListSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createUrlListOperationSettings = OperationCallSettings.newBuilder();
      updateUrlListSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateUrlListOperationSettings = OperationCallSettings.newBuilder();
      deleteUrlListSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteUrlListOperationSettings = OperationCallSettings.newBuilder();
      listTlsInspectionPoliciesSettings =
          PagedCallSettings.newBuilder(LIST_TLS_INSPECTION_POLICIES_PAGE_STR_FACT);
      getTlsInspectionPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createTlsInspectionPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createTlsInspectionPolicyOperationSettings = OperationCallSettings.newBuilder();
      updateTlsInspectionPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateTlsInspectionPolicyOperationSettings = OperationCallSettings.newBuilder();
      deleteTlsInspectionPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteTlsInspectionPolicyOperationSettings = OperationCallSettings.newBuilder();
      listAuthzPoliciesSettings = PagedCallSettings.newBuilder(LIST_AUTHZ_POLICIES_PAGE_STR_FACT);
      getAuthzPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createAuthzPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createAuthzPolicyOperationSettings = OperationCallSettings.newBuilder();
      updateAuthzPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateAuthzPolicyOperationSettings = OperationCallSettings.newBuilder();
      deleteAuthzPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteAuthzPolicyOperationSettings = OperationCallSettings.newBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listAuthorizationPoliciesSettings,
              getAuthorizationPolicySettings,
              createAuthorizationPolicySettings,
              updateAuthorizationPolicySettings,
              deleteAuthorizationPolicySettings,
              listBackendAuthenticationConfigsSettings,
              getBackendAuthenticationConfigSettings,
              createBackendAuthenticationConfigSettings,
              updateBackendAuthenticationConfigSettings,
              deleteBackendAuthenticationConfigSettings,
              listServerTlsPoliciesSettings,
              getServerTlsPolicySettings,
              createServerTlsPolicySettings,
              updateServerTlsPolicySettings,
              deleteServerTlsPolicySettings,
              listClientTlsPoliciesSettings,
              getClientTlsPolicySettings,
              createClientTlsPolicySettings,
              updateClientTlsPolicySettings,
              deleteClientTlsPolicySettings,
              listGatewaySecurityPoliciesSettings,
              getGatewaySecurityPolicySettings,
              createGatewaySecurityPolicySettings,
              updateGatewaySecurityPolicySettings,
              deleteGatewaySecurityPolicySettings,
              listGatewaySecurityPolicyRulesSettings,
              getGatewaySecurityPolicyRuleSettings,
              createGatewaySecurityPolicyRuleSettings,
              updateGatewaySecurityPolicyRuleSettings,
              deleteGatewaySecurityPolicyRuleSettings,
              listUrlListsSettings,
              getUrlListSettings,
              createUrlListSettings,
              updateUrlListSettings,
              deleteUrlListSettings,
              listTlsInspectionPoliciesSettings,
              getTlsInspectionPolicySettings,
              createTlsInspectionPolicySettings,
              updateTlsInspectionPolicySettings,
              deleteTlsInspectionPolicySettings,
              listAuthzPoliciesSettings,
              getAuthzPolicySettings,
              createAuthzPolicySettings,
              updateAuthzPolicySettings,
              deleteAuthzPolicySettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(NetworkSecurityStubSettings settings) {
      super(settings);

      listAuthorizationPoliciesSettings = settings.listAuthorizationPoliciesSettings.toBuilder();
      getAuthorizationPolicySettings = settings.getAuthorizationPolicySettings.toBuilder();
      createAuthorizationPolicySettings = settings.createAuthorizationPolicySettings.toBuilder();
      createAuthorizationPolicyOperationSettings =
          settings.createAuthorizationPolicyOperationSettings.toBuilder();
      updateAuthorizationPolicySettings = settings.updateAuthorizationPolicySettings.toBuilder();
      updateAuthorizationPolicyOperationSettings =
          settings.updateAuthorizationPolicyOperationSettings.toBuilder();
      deleteAuthorizationPolicySettings = settings.deleteAuthorizationPolicySettings.toBuilder();
      deleteAuthorizationPolicyOperationSettings =
          settings.deleteAuthorizationPolicyOperationSettings.toBuilder();
      listBackendAuthenticationConfigsSettings =
          settings.listBackendAuthenticationConfigsSettings.toBuilder();
      getBackendAuthenticationConfigSettings =
          settings.getBackendAuthenticationConfigSettings.toBuilder();
      createBackendAuthenticationConfigSettings =
          settings.createBackendAuthenticationConfigSettings.toBuilder();
      createBackendAuthenticationConfigOperationSettings =
          settings.createBackendAuthenticationConfigOperationSettings.toBuilder();
      updateBackendAuthenticationConfigSettings =
          settings.updateBackendAuthenticationConfigSettings.toBuilder();
      updateBackendAuthenticationConfigOperationSettings =
          settings.updateBackendAuthenticationConfigOperationSettings.toBuilder();
      deleteBackendAuthenticationConfigSettings =
          settings.deleteBackendAuthenticationConfigSettings.toBuilder();
      deleteBackendAuthenticationConfigOperationSettings =
          settings.deleteBackendAuthenticationConfigOperationSettings.toBuilder();
      listServerTlsPoliciesSettings = settings.listServerTlsPoliciesSettings.toBuilder();
      getServerTlsPolicySettings = settings.getServerTlsPolicySettings.toBuilder();
      createServerTlsPolicySettings = settings.createServerTlsPolicySettings.toBuilder();
      createServerTlsPolicyOperationSettings =
          settings.createServerTlsPolicyOperationSettings.toBuilder();
      updateServerTlsPolicySettings = settings.updateServerTlsPolicySettings.toBuilder();
      updateServerTlsPolicyOperationSettings =
          settings.updateServerTlsPolicyOperationSettings.toBuilder();
      deleteServerTlsPolicySettings = settings.deleteServerTlsPolicySettings.toBuilder();
      deleteServerTlsPolicyOperationSettings =
          settings.deleteServerTlsPolicyOperationSettings.toBuilder();
      listClientTlsPoliciesSettings = settings.listClientTlsPoliciesSettings.toBuilder();
      getClientTlsPolicySettings = settings.getClientTlsPolicySettings.toBuilder();
      createClientTlsPolicySettings = settings.createClientTlsPolicySettings.toBuilder();
      createClientTlsPolicyOperationSettings =
          settings.createClientTlsPolicyOperationSettings.toBuilder();
      updateClientTlsPolicySettings = settings.updateClientTlsPolicySettings.toBuilder();
      updateClientTlsPolicyOperationSettings =
          settings.updateClientTlsPolicyOperationSettings.toBuilder();
      deleteClientTlsPolicySettings = settings.deleteClientTlsPolicySettings.toBuilder();
      deleteClientTlsPolicyOperationSettings =
          settings.deleteClientTlsPolicyOperationSettings.toBuilder();
      listGatewaySecurityPoliciesSettings =
          settings.listGatewaySecurityPoliciesSettings.toBuilder();
      getGatewaySecurityPolicySettings = settings.getGatewaySecurityPolicySettings.toBuilder();
      createGatewaySecurityPolicySettings =
          settings.createGatewaySecurityPolicySettings.toBuilder();
      createGatewaySecurityPolicyOperationSettings =
          settings.createGatewaySecurityPolicyOperationSettings.toBuilder();
      updateGatewaySecurityPolicySettings =
          settings.updateGatewaySecurityPolicySettings.toBuilder();
      updateGatewaySecurityPolicyOperationSettings =
          settings.updateGatewaySecurityPolicyOperationSettings.toBuilder();
      deleteGatewaySecurityPolicySettings =
          settings.deleteGatewaySecurityPolicySettings.toBuilder();
      deleteGatewaySecurityPolicyOperationSettings =
          settings.deleteGatewaySecurityPolicyOperationSettings.toBuilder();
      listGatewaySecurityPolicyRulesSettings =
          settings.listGatewaySecurityPolicyRulesSettings.toBuilder();
      getGatewaySecurityPolicyRuleSettings =
          settings.getGatewaySecurityPolicyRuleSettings.toBuilder();
      createGatewaySecurityPolicyRuleSettings =
          settings.createGatewaySecurityPolicyRuleSettings.toBuilder();
      createGatewaySecurityPolicyRuleOperationSettings =
          settings.createGatewaySecurityPolicyRuleOperationSettings.toBuilder();
      updateGatewaySecurityPolicyRuleSettings =
          settings.updateGatewaySecurityPolicyRuleSettings.toBuilder();
      updateGatewaySecurityPolicyRuleOperationSettings =
          settings.updateGatewaySecurityPolicyRuleOperationSettings.toBuilder();
      deleteGatewaySecurityPolicyRuleSettings =
          settings.deleteGatewaySecurityPolicyRuleSettings.toBuilder();
      deleteGatewaySecurityPolicyRuleOperationSettings =
          settings.deleteGatewaySecurityPolicyRuleOperationSettings.toBuilder();
      listUrlListsSettings = settings.listUrlListsSettings.toBuilder();
      getUrlListSettings = settings.getUrlListSettings.toBuilder();
      createUrlListSettings = settings.createUrlListSettings.toBuilder();
      createUrlListOperationSettings = settings.createUrlListOperationSettings.toBuilder();
      updateUrlListSettings = settings.updateUrlListSettings.toBuilder();
      updateUrlListOperationSettings = settings.updateUrlListOperationSettings.toBuilder();
      deleteUrlListSettings = settings.deleteUrlListSettings.toBuilder();
      deleteUrlListOperationSettings = settings.deleteUrlListOperationSettings.toBuilder();
      listTlsInspectionPoliciesSettings = settings.listTlsInspectionPoliciesSettings.toBuilder();
      getTlsInspectionPolicySettings = settings.getTlsInspectionPolicySettings.toBuilder();
      createTlsInspectionPolicySettings = settings.createTlsInspectionPolicySettings.toBuilder();
      createTlsInspectionPolicyOperationSettings =
          settings.createTlsInspectionPolicyOperationSettings.toBuilder();
      updateTlsInspectionPolicySettings = settings.updateTlsInspectionPolicySettings.toBuilder();
      updateTlsInspectionPolicyOperationSettings =
          settings.updateTlsInspectionPolicyOperationSettings.toBuilder();
      deleteTlsInspectionPolicySettings = settings.deleteTlsInspectionPolicySettings.toBuilder();
      deleteTlsInspectionPolicyOperationSettings =
          settings.deleteTlsInspectionPolicyOperationSettings.toBuilder();
      listAuthzPoliciesSettings = settings.listAuthzPoliciesSettings.toBuilder();
      getAuthzPolicySettings = settings.getAuthzPolicySettings.toBuilder();
      createAuthzPolicySettings = settings.createAuthzPolicySettings.toBuilder();
      createAuthzPolicyOperationSettings = settings.createAuthzPolicyOperationSettings.toBuilder();
      updateAuthzPolicySettings = settings.updateAuthzPolicySettings.toBuilder();
      updateAuthzPolicyOperationSettings = settings.updateAuthzPolicyOperationSettings.toBuilder();
      deleteAuthzPolicySettings = settings.deleteAuthzPolicySettings.toBuilder();
      deleteAuthzPolicyOperationSettings = settings.deleteAuthzPolicyOperationSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listAuthorizationPoliciesSettings,
              getAuthorizationPolicySettings,
              createAuthorizationPolicySettings,
              updateAuthorizationPolicySettings,
              deleteAuthorizationPolicySettings,
              listBackendAuthenticationConfigsSettings,
              getBackendAuthenticationConfigSettings,
              createBackendAuthenticationConfigSettings,
              updateBackendAuthenticationConfigSettings,
              deleteBackendAuthenticationConfigSettings,
              listServerTlsPoliciesSettings,
              getServerTlsPolicySettings,
              createServerTlsPolicySettings,
              updateServerTlsPolicySettings,
              deleteServerTlsPolicySettings,
              listClientTlsPoliciesSettings,
              getClientTlsPolicySettings,
              createClientTlsPolicySettings,
              updateClientTlsPolicySettings,
              deleteClientTlsPolicySettings,
              listGatewaySecurityPoliciesSettings,
              getGatewaySecurityPolicySettings,
              createGatewaySecurityPolicySettings,
              updateGatewaySecurityPolicySettings,
              deleteGatewaySecurityPolicySettings,
              listGatewaySecurityPolicyRulesSettings,
              getGatewaySecurityPolicyRuleSettings,
              createGatewaySecurityPolicyRuleSettings,
              updateGatewaySecurityPolicyRuleSettings,
              deleteGatewaySecurityPolicyRuleSettings,
              listUrlListsSettings,
              getUrlListSettings,
              createUrlListSettings,
              updateUrlListSettings,
              deleteUrlListSettings,
              listTlsInspectionPoliciesSettings,
              getTlsInspectionPolicySettings,
              createTlsInspectionPolicySettings,
              updateTlsInspectionPolicySettings,
              deleteTlsInspectionPolicySettings,
              listAuthzPoliciesSettings,
              getAuthzPolicySettings,
              createAuthzPolicySettings,
              updateAuthzPolicySettings,
              deleteAuthzPolicySettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .listAuthorizationPoliciesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getAuthorizationPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createAuthorizationPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateAuthorizationPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteAuthorizationPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listBackendAuthenticationConfigsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getBackendAuthenticationConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createBackendAuthenticationConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateBackendAuthenticationConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteBackendAuthenticationConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listServerTlsPoliciesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getServerTlsPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createServerTlsPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateServerTlsPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteServerTlsPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listClientTlsPoliciesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getClientTlsPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createClientTlsPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateClientTlsPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteClientTlsPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listGatewaySecurityPoliciesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getGatewaySecurityPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createGatewaySecurityPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateGatewaySecurityPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteGatewaySecurityPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listGatewaySecurityPolicyRulesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getGatewaySecurityPolicyRuleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createGatewaySecurityPolicyRuleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateGatewaySecurityPolicyRuleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteGatewaySecurityPolicyRuleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listUrlListsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getUrlListSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createUrlListSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateUrlListSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteUrlListSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listTlsInspectionPoliciesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getTlsInspectionPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createTlsInspectionPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateTlsInspectionPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteTlsInspectionPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listAuthzPoliciesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getAuthzPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createAuthzPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateAuthzPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteAuthzPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getLocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .testIamPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createAuthorizationPolicyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateAuthorizationPolicyRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(AuthorizationPolicy.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateAuthorizationPolicyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateAuthorizationPolicyRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(AuthorizationPolicy.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteAuthorizationPolicyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteAuthorizationPolicyRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createBackendAuthenticationConfigOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateBackendAuthenticationConfigRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  BackendAuthenticationConfig.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateBackendAuthenticationConfigOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateBackendAuthenticationConfigRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  BackendAuthenticationConfig.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteBackendAuthenticationConfigOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteBackendAuthenticationConfigRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createServerTlsPolicyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateServerTlsPolicyRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ServerTlsPolicy.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateServerTlsPolicyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateServerTlsPolicyRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ServerTlsPolicy.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteServerTlsPolicyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteServerTlsPolicyRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createClientTlsPolicyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateClientTlsPolicyRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ClientTlsPolicy.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateClientTlsPolicyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateClientTlsPolicyRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ClientTlsPolicy.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteClientTlsPolicyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteClientTlsPolicyRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createGatewaySecurityPolicyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateGatewaySecurityPolicyRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(GatewaySecurityPolicy.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateGatewaySecurityPolicyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateGatewaySecurityPolicyRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(GatewaySecurityPolicy.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteGatewaySecurityPolicyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteGatewaySecurityPolicyRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createGatewaySecurityPolicyRuleOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateGatewaySecurityPolicyRuleRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  GatewaySecurityPolicyRule.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateGatewaySecurityPolicyRuleOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateGatewaySecurityPolicyRuleRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  GatewaySecurityPolicyRule.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteGatewaySecurityPolicyRuleOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteGatewaySecurityPolicyRuleRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createUrlListOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateUrlListRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(UrlList.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateUrlListOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateUrlListRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(UrlList.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteUrlListOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteUrlListRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createTlsInspectionPolicyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateTlsInspectionPolicyRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(TlsInspectionPolicy.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateTlsInspectionPolicyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateTlsInspectionPolicyRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(TlsInspectionPolicy.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteTlsInspectionPolicyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteTlsInspectionPolicyRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createAuthzPolicyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateAuthzPolicyRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(AuthzPolicy.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateAuthzPolicyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateAuthzPolicyRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(AuthzPolicy.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteAuthzPolicyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteAuthzPolicyRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      return builder;
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
    }

    /** Returns the builder for the settings used for calls to listAuthorizationPolicies. */
    public PagedCallSettings.Builder<
            ListAuthorizationPoliciesRequest,
            ListAuthorizationPoliciesResponse,
            ListAuthorizationPoliciesPagedResponse>
        listAuthorizationPoliciesSettings() {
      return listAuthorizationPoliciesSettings;
    }

    /** Returns the builder for the settings used for calls to getAuthorizationPolicy. */
    public UnaryCallSettings.Builder<GetAuthorizationPolicyRequest, AuthorizationPolicy>
        getAuthorizationPolicySettings() {
      return getAuthorizationPolicySettings;
    }

    /** Returns the builder for the settings used for calls to createAuthorizationPolicy. */
    public UnaryCallSettings.Builder<CreateAuthorizationPolicyRequest, Operation>
        createAuthorizationPolicySettings() {
      return createAuthorizationPolicySettings;
    }

    /** Returns the builder for the settings used for calls to createAuthorizationPolicy. */
    public OperationCallSettings.Builder<
            CreateAuthorizationPolicyRequest, AuthorizationPolicy, OperationMetadata>
        createAuthorizationPolicyOperationSettings() {
      return createAuthorizationPolicyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateAuthorizationPolicy. */
    public UnaryCallSettings.Builder<UpdateAuthorizationPolicyRequest, Operation>
        updateAuthorizationPolicySettings() {
      return updateAuthorizationPolicySettings;
    }

    /** Returns the builder for the settings used for calls to updateAuthorizationPolicy. */
    public OperationCallSettings.Builder<
            UpdateAuthorizationPolicyRequest, AuthorizationPolicy, OperationMetadata>
        updateAuthorizationPolicyOperationSettings() {
      return updateAuthorizationPolicyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAuthorizationPolicy. */
    public UnaryCallSettings.Builder<DeleteAuthorizationPolicyRequest, Operation>
        deleteAuthorizationPolicySettings() {
      return deleteAuthorizationPolicySettings;
    }

    /** Returns the builder for the settings used for calls to deleteAuthorizationPolicy. */
    public OperationCallSettings.Builder<DeleteAuthorizationPolicyRequest, Empty, OperationMetadata>
        deleteAuthorizationPolicyOperationSettings() {
      return deleteAuthorizationPolicyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listBackendAuthenticationConfigs. */
    public PagedCallSettings.Builder<
            ListBackendAuthenticationConfigsRequest,
            ListBackendAuthenticationConfigsResponse,
            ListBackendAuthenticationConfigsPagedResponse>
        listBackendAuthenticationConfigsSettings() {
      return listBackendAuthenticationConfigsSettings;
    }

    /** Returns the builder for the settings used for calls to getBackendAuthenticationConfig. */
    public UnaryCallSettings.Builder<
            GetBackendAuthenticationConfigRequest, BackendAuthenticationConfig>
        getBackendAuthenticationConfigSettings() {
      return getBackendAuthenticationConfigSettings;
    }

    /** Returns the builder for the settings used for calls to createBackendAuthenticationConfig. */
    public UnaryCallSettings.Builder<CreateBackendAuthenticationConfigRequest, Operation>
        createBackendAuthenticationConfigSettings() {
      return createBackendAuthenticationConfigSettings;
    }

    /** Returns the builder for the settings used for calls to createBackendAuthenticationConfig. */
    public OperationCallSettings.Builder<
            CreateBackendAuthenticationConfigRequest,
            BackendAuthenticationConfig,
            OperationMetadata>
        createBackendAuthenticationConfigOperationSettings() {
      return createBackendAuthenticationConfigOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateBackendAuthenticationConfig. */
    public UnaryCallSettings.Builder<UpdateBackendAuthenticationConfigRequest, Operation>
        updateBackendAuthenticationConfigSettings() {
      return updateBackendAuthenticationConfigSettings;
    }

    /** Returns the builder for the settings used for calls to updateBackendAuthenticationConfig. */
    public OperationCallSettings.Builder<
            UpdateBackendAuthenticationConfigRequest,
            BackendAuthenticationConfig,
            OperationMetadata>
        updateBackendAuthenticationConfigOperationSettings() {
      return updateBackendAuthenticationConfigOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteBackendAuthenticationConfig. */
    public UnaryCallSettings.Builder<DeleteBackendAuthenticationConfigRequest, Operation>
        deleteBackendAuthenticationConfigSettings() {
      return deleteBackendAuthenticationConfigSettings;
    }

    /** Returns the builder for the settings used for calls to deleteBackendAuthenticationConfig. */
    public OperationCallSettings.Builder<
            DeleteBackendAuthenticationConfigRequest, Empty, OperationMetadata>
        deleteBackendAuthenticationConfigOperationSettings() {
      return deleteBackendAuthenticationConfigOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listServerTlsPolicies. */
    public PagedCallSettings.Builder<
            ListServerTlsPoliciesRequest,
            ListServerTlsPoliciesResponse,
            ListServerTlsPoliciesPagedResponse>
        listServerTlsPoliciesSettings() {
      return listServerTlsPoliciesSettings;
    }

    /** Returns the builder for the settings used for calls to getServerTlsPolicy. */
    public UnaryCallSettings.Builder<GetServerTlsPolicyRequest, ServerTlsPolicy>
        getServerTlsPolicySettings() {
      return getServerTlsPolicySettings;
    }

    /** Returns the builder for the settings used for calls to createServerTlsPolicy. */
    public UnaryCallSettings.Builder<CreateServerTlsPolicyRequest, Operation>
        createServerTlsPolicySettings() {
      return createServerTlsPolicySettings;
    }

    /** Returns the builder for the settings used for calls to createServerTlsPolicy. */
    public OperationCallSettings.Builder<
            CreateServerTlsPolicyRequest, ServerTlsPolicy, OperationMetadata>
        createServerTlsPolicyOperationSettings() {
      return createServerTlsPolicyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateServerTlsPolicy. */
    public UnaryCallSettings.Builder<UpdateServerTlsPolicyRequest, Operation>
        updateServerTlsPolicySettings() {
      return updateServerTlsPolicySettings;
    }

    /** Returns the builder for the settings used for calls to updateServerTlsPolicy. */
    public OperationCallSettings.Builder<
            UpdateServerTlsPolicyRequest, ServerTlsPolicy, OperationMetadata>
        updateServerTlsPolicyOperationSettings() {
      return updateServerTlsPolicyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteServerTlsPolicy. */
    public UnaryCallSettings.Builder<DeleteServerTlsPolicyRequest, Operation>
        deleteServerTlsPolicySettings() {
      return deleteServerTlsPolicySettings;
    }

    /** Returns the builder for the settings used for calls to deleteServerTlsPolicy. */
    public OperationCallSettings.Builder<DeleteServerTlsPolicyRequest, Empty, OperationMetadata>
        deleteServerTlsPolicyOperationSettings() {
      return deleteServerTlsPolicyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listClientTlsPolicies. */
    public PagedCallSettings.Builder<
            ListClientTlsPoliciesRequest,
            ListClientTlsPoliciesResponse,
            ListClientTlsPoliciesPagedResponse>
        listClientTlsPoliciesSettings() {
      return listClientTlsPoliciesSettings;
    }

    /** Returns the builder for the settings used for calls to getClientTlsPolicy. */
    public UnaryCallSettings.Builder<GetClientTlsPolicyRequest, ClientTlsPolicy>
        getClientTlsPolicySettings() {
      return getClientTlsPolicySettings;
    }

    /** Returns the builder for the settings used for calls to createClientTlsPolicy. */
    public UnaryCallSettings.Builder<CreateClientTlsPolicyRequest, Operation>
        createClientTlsPolicySettings() {
      return createClientTlsPolicySettings;
    }

    /** Returns the builder for the settings used for calls to createClientTlsPolicy. */
    public OperationCallSettings.Builder<
            CreateClientTlsPolicyRequest, ClientTlsPolicy, OperationMetadata>
        createClientTlsPolicyOperationSettings() {
      return createClientTlsPolicyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateClientTlsPolicy. */
    public UnaryCallSettings.Builder<UpdateClientTlsPolicyRequest, Operation>
        updateClientTlsPolicySettings() {
      return updateClientTlsPolicySettings;
    }

    /** Returns the builder for the settings used for calls to updateClientTlsPolicy. */
    public OperationCallSettings.Builder<
            UpdateClientTlsPolicyRequest, ClientTlsPolicy, OperationMetadata>
        updateClientTlsPolicyOperationSettings() {
      return updateClientTlsPolicyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteClientTlsPolicy. */
    public UnaryCallSettings.Builder<DeleteClientTlsPolicyRequest, Operation>
        deleteClientTlsPolicySettings() {
      return deleteClientTlsPolicySettings;
    }

    /** Returns the builder for the settings used for calls to deleteClientTlsPolicy. */
    public OperationCallSettings.Builder<DeleteClientTlsPolicyRequest, Empty, OperationMetadata>
        deleteClientTlsPolicyOperationSettings() {
      return deleteClientTlsPolicyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listGatewaySecurityPolicies. */
    public PagedCallSettings.Builder<
            ListGatewaySecurityPoliciesRequest,
            ListGatewaySecurityPoliciesResponse,
            ListGatewaySecurityPoliciesPagedResponse>
        listGatewaySecurityPoliciesSettings() {
      return listGatewaySecurityPoliciesSettings;
    }

    /** Returns the builder for the settings used for calls to getGatewaySecurityPolicy. */
    public UnaryCallSettings.Builder<GetGatewaySecurityPolicyRequest, GatewaySecurityPolicy>
        getGatewaySecurityPolicySettings() {
      return getGatewaySecurityPolicySettings;
    }

    /** Returns the builder for the settings used for calls to createGatewaySecurityPolicy. */
    public UnaryCallSettings.Builder<CreateGatewaySecurityPolicyRequest, Operation>
        createGatewaySecurityPolicySettings() {
      return createGatewaySecurityPolicySettings;
    }

    /** Returns the builder for the settings used for calls to createGatewaySecurityPolicy. */
    public OperationCallSettings.Builder<
            CreateGatewaySecurityPolicyRequest, GatewaySecurityPolicy, OperationMetadata>
        createGatewaySecurityPolicyOperationSettings() {
      return createGatewaySecurityPolicyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateGatewaySecurityPolicy. */
    public UnaryCallSettings.Builder<UpdateGatewaySecurityPolicyRequest, Operation>
        updateGatewaySecurityPolicySettings() {
      return updateGatewaySecurityPolicySettings;
    }

    /** Returns the builder for the settings used for calls to updateGatewaySecurityPolicy. */
    public OperationCallSettings.Builder<
            UpdateGatewaySecurityPolicyRequest, GatewaySecurityPolicy, OperationMetadata>
        updateGatewaySecurityPolicyOperationSettings() {
      return updateGatewaySecurityPolicyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteGatewaySecurityPolicy. */
    public UnaryCallSettings.Builder<DeleteGatewaySecurityPolicyRequest, Operation>
        deleteGatewaySecurityPolicySettings() {
      return deleteGatewaySecurityPolicySettings;
    }

    /** Returns the builder for the settings used for calls to deleteGatewaySecurityPolicy. */
    public OperationCallSettings.Builder<
            DeleteGatewaySecurityPolicyRequest, Empty, OperationMetadata>
        deleteGatewaySecurityPolicyOperationSettings() {
      return deleteGatewaySecurityPolicyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listGatewaySecurityPolicyRules. */
    public PagedCallSettings.Builder<
            ListGatewaySecurityPolicyRulesRequest,
            ListGatewaySecurityPolicyRulesResponse,
            ListGatewaySecurityPolicyRulesPagedResponse>
        listGatewaySecurityPolicyRulesSettings() {
      return listGatewaySecurityPolicyRulesSettings;
    }

    /** Returns the builder for the settings used for calls to getGatewaySecurityPolicyRule. */
    public UnaryCallSettings.Builder<GetGatewaySecurityPolicyRuleRequest, GatewaySecurityPolicyRule>
        getGatewaySecurityPolicyRuleSettings() {
      return getGatewaySecurityPolicyRuleSettings;
    }

    /** Returns the builder for the settings used for calls to createGatewaySecurityPolicyRule. */
    public UnaryCallSettings.Builder<CreateGatewaySecurityPolicyRuleRequest, Operation>
        createGatewaySecurityPolicyRuleSettings() {
      return createGatewaySecurityPolicyRuleSettings;
    }

    /** Returns the builder for the settings used for calls to createGatewaySecurityPolicyRule. */
    public OperationCallSettings.Builder<
            CreateGatewaySecurityPolicyRuleRequest, GatewaySecurityPolicyRule, OperationMetadata>
        createGatewaySecurityPolicyRuleOperationSettings() {
      return createGatewaySecurityPolicyRuleOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateGatewaySecurityPolicyRule. */
    public UnaryCallSettings.Builder<UpdateGatewaySecurityPolicyRuleRequest, Operation>
        updateGatewaySecurityPolicyRuleSettings() {
      return updateGatewaySecurityPolicyRuleSettings;
    }

    /** Returns the builder for the settings used for calls to updateGatewaySecurityPolicyRule. */
    public OperationCallSettings.Builder<
            UpdateGatewaySecurityPolicyRuleRequest, GatewaySecurityPolicyRule, OperationMetadata>
        updateGatewaySecurityPolicyRuleOperationSettings() {
      return updateGatewaySecurityPolicyRuleOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteGatewaySecurityPolicyRule. */
    public UnaryCallSettings.Builder<DeleteGatewaySecurityPolicyRuleRequest, Operation>
        deleteGatewaySecurityPolicyRuleSettings() {
      return deleteGatewaySecurityPolicyRuleSettings;
    }

    /** Returns the builder for the settings used for calls to deleteGatewaySecurityPolicyRule. */
    public OperationCallSettings.Builder<
            DeleteGatewaySecurityPolicyRuleRequest, Empty, OperationMetadata>
        deleteGatewaySecurityPolicyRuleOperationSettings() {
      return deleteGatewaySecurityPolicyRuleOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listUrlLists. */
    public PagedCallSettings.Builder<
            ListUrlListsRequest, ListUrlListsResponse, ListUrlListsPagedResponse>
        listUrlListsSettings() {
      return listUrlListsSettings;
    }

    /** Returns the builder for the settings used for calls to getUrlList. */
    public UnaryCallSettings.Builder<GetUrlListRequest, UrlList> getUrlListSettings() {
      return getUrlListSettings;
    }

    /** Returns the builder for the settings used for calls to createUrlList. */
    public UnaryCallSettings.Builder<CreateUrlListRequest, Operation> createUrlListSettings() {
      return createUrlListSettings;
    }

    /** Returns the builder for the settings used for calls to createUrlList. */
    public OperationCallSettings.Builder<CreateUrlListRequest, UrlList, OperationMetadata>
        createUrlListOperationSettings() {
      return createUrlListOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateUrlList. */
    public UnaryCallSettings.Builder<UpdateUrlListRequest, Operation> updateUrlListSettings() {
      return updateUrlListSettings;
    }

    /** Returns the builder for the settings used for calls to updateUrlList. */
    public OperationCallSettings.Builder<UpdateUrlListRequest, UrlList, OperationMetadata>
        updateUrlListOperationSettings() {
      return updateUrlListOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteUrlList. */
    public UnaryCallSettings.Builder<DeleteUrlListRequest, Operation> deleteUrlListSettings() {
      return deleteUrlListSettings;
    }

    /** Returns the builder for the settings used for calls to deleteUrlList. */
    public OperationCallSettings.Builder<DeleteUrlListRequest, Empty, OperationMetadata>
        deleteUrlListOperationSettings() {
      return deleteUrlListOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listTlsInspectionPolicies. */
    public PagedCallSettings.Builder<
            ListTlsInspectionPoliciesRequest,
            ListTlsInspectionPoliciesResponse,
            ListTlsInspectionPoliciesPagedResponse>
        listTlsInspectionPoliciesSettings() {
      return listTlsInspectionPoliciesSettings;
    }

    /** Returns the builder for the settings used for calls to getTlsInspectionPolicy. */
    public UnaryCallSettings.Builder<GetTlsInspectionPolicyRequest, TlsInspectionPolicy>
        getTlsInspectionPolicySettings() {
      return getTlsInspectionPolicySettings;
    }

    /** Returns the builder for the settings used for calls to createTlsInspectionPolicy. */
    public UnaryCallSettings.Builder<CreateTlsInspectionPolicyRequest, Operation>
        createTlsInspectionPolicySettings() {
      return createTlsInspectionPolicySettings;
    }

    /** Returns the builder for the settings used for calls to createTlsInspectionPolicy. */
    public OperationCallSettings.Builder<
            CreateTlsInspectionPolicyRequest, TlsInspectionPolicy, OperationMetadata>
        createTlsInspectionPolicyOperationSettings() {
      return createTlsInspectionPolicyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateTlsInspectionPolicy. */
    public UnaryCallSettings.Builder<UpdateTlsInspectionPolicyRequest, Operation>
        updateTlsInspectionPolicySettings() {
      return updateTlsInspectionPolicySettings;
    }

    /** Returns the builder for the settings used for calls to updateTlsInspectionPolicy. */
    public OperationCallSettings.Builder<
            UpdateTlsInspectionPolicyRequest, TlsInspectionPolicy, OperationMetadata>
        updateTlsInspectionPolicyOperationSettings() {
      return updateTlsInspectionPolicyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteTlsInspectionPolicy. */
    public UnaryCallSettings.Builder<DeleteTlsInspectionPolicyRequest, Operation>
        deleteTlsInspectionPolicySettings() {
      return deleteTlsInspectionPolicySettings;
    }

    /** Returns the builder for the settings used for calls to deleteTlsInspectionPolicy. */
    public OperationCallSettings.Builder<DeleteTlsInspectionPolicyRequest, Empty, OperationMetadata>
        deleteTlsInspectionPolicyOperationSettings() {
      return deleteTlsInspectionPolicyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listAuthzPolicies. */
    public PagedCallSettings.Builder<
            ListAuthzPoliciesRequest, ListAuthzPoliciesResponse, ListAuthzPoliciesPagedResponse>
        listAuthzPoliciesSettings() {
      return listAuthzPoliciesSettings;
    }

    /** Returns the builder for the settings used for calls to getAuthzPolicy. */
    public UnaryCallSettings.Builder<GetAuthzPolicyRequest, AuthzPolicy> getAuthzPolicySettings() {
      return getAuthzPolicySettings;
    }

    /** Returns the builder for the settings used for calls to createAuthzPolicy. */
    public UnaryCallSettings.Builder<CreateAuthzPolicyRequest, Operation>
        createAuthzPolicySettings() {
      return createAuthzPolicySettings;
    }

    /** Returns the builder for the settings used for calls to createAuthzPolicy. */
    public OperationCallSettings.Builder<CreateAuthzPolicyRequest, AuthzPolicy, OperationMetadata>
        createAuthzPolicyOperationSettings() {
      return createAuthzPolicyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateAuthzPolicy. */
    public UnaryCallSettings.Builder<UpdateAuthzPolicyRequest, Operation>
        updateAuthzPolicySettings() {
      return updateAuthzPolicySettings;
    }

    /** Returns the builder for the settings used for calls to updateAuthzPolicy. */
    public OperationCallSettings.Builder<UpdateAuthzPolicyRequest, AuthzPolicy, OperationMetadata>
        updateAuthzPolicyOperationSettings() {
      return updateAuthzPolicyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAuthzPolicy. */
    public UnaryCallSettings.Builder<DeleteAuthzPolicyRequest, Operation>
        deleteAuthzPolicySettings() {
      return deleteAuthzPolicySettings;
    }

    /** Returns the builder for the settings used for calls to deleteAuthzPolicy. */
    public OperationCallSettings.Builder<DeleteAuthzPolicyRequest, Empty, OperationMetadata>
        deleteAuthzPolicyOperationSettings() {
      return deleteAuthzPolicyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return listLocationsSettings;
    }

    /** Returns the builder for the settings used for calls to getLocation. */
    public UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings() {
      return getLocationSettings;
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return setIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return testIamPermissionsSettings;
    }

    @Override
    public NetworkSecurityStubSettings build() throws IOException {
      return new NetworkSecurityStubSettings(this);
    }
  }
}
