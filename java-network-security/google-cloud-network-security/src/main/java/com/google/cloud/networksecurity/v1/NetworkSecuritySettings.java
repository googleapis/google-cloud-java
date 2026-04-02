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
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.networksecurity.v1.stub.NetworkSecurityStubSettings;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link NetworkSecurityClient}.
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
 * NetworkSecuritySettings.Builder networkSecuritySettingsBuilder =
 *     NetworkSecuritySettings.newBuilder();
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
 * NetworkSecuritySettings networkSecuritySettings = networkSecuritySettingsBuilder.build();
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
 * NetworkSecuritySettings.Builder networkSecuritySettingsBuilder =
 *     NetworkSecuritySettings.newBuilder();
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
public class NetworkSecuritySettings extends ClientSettings<NetworkSecuritySettings> {

  /** Returns the object with the settings used for calls to listAuthorizationPolicies. */
  public PagedCallSettings<
          ListAuthorizationPoliciesRequest,
          ListAuthorizationPoliciesResponse,
          ListAuthorizationPoliciesPagedResponse>
      listAuthorizationPoliciesSettings() {
    return ((NetworkSecurityStubSettings) getStubSettings()).listAuthorizationPoliciesSettings();
  }

  /** Returns the object with the settings used for calls to getAuthorizationPolicy. */
  public UnaryCallSettings<GetAuthorizationPolicyRequest, AuthorizationPolicy>
      getAuthorizationPolicySettings() {
    return ((NetworkSecurityStubSettings) getStubSettings()).getAuthorizationPolicySettings();
  }

  /** Returns the object with the settings used for calls to createAuthorizationPolicy. */
  public UnaryCallSettings<CreateAuthorizationPolicyRequest, Operation>
      createAuthorizationPolicySettings() {
    return ((NetworkSecurityStubSettings) getStubSettings()).createAuthorizationPolicySettings();
  }

  /** Returns the object with the settings used for calls to createAuthorizationPolicy. */
  public OperationCallSettings<
          CreateAuthorizationPolicyRequest, AuthorizationPolicy, OperationMetadata>
      createAuthorizationPolicyOperationSettings() {
    return ((NetworkSecurityStubSettings) getStubSettings())
        .createAuthorizationPolicyOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateAuthorizationPolicy. */
  public UnaryCallSettings<UpdateAuthorizationPolicyRequest, Operation>
      updateAuthorizationPolicySettings() {
    return ((NetworkSecurityStubSettings) getStubSettings()).updateAuthorizationPolicySettings();
  }

  /** Returns the object with the settings used for calls to updateAuthorizationPolicy. */
  public OperationCallSettings<
          UpdateAuthorizationPolicyRequest, AuthorizationPolicy, OperationMetadata>
      updateAuthorizationPolicyOperationSettings() {
    return ((NetworkSecurityStubSettings) getStubSettings())
        .updateAuthorizationPolicyOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteAuthorizationPolicy. */
  public UnaryCallSettings<DeleteAuthorizationPolicyRequest, Operation>
      deleteAuthorizationPolicySettings() {
    return ((NetworkSecurityStubSettings) getStubSettings()).deleteAuthorizationPolicySettings();
  }

  /** Returns the object with the settings used for calls to deleteAuthorizationPolicy. */
  public OperationCallSettings<DeleteAuthorizationPolicyRequest, Empty, OperationMetadata>
      deleteAuthorizationPolicyOperationSettings() {
    return ((NetworkSecurityStubSettings) getStubSettings())
        .deleteAuthorizationPolicyOperationSettings();
  }

  /** Returns the object with the settings used for calls to listBackendAuthenticationConfigs. */
  public PagedCallSettings<
          ListBackendAuthenticationConfigsRequest,
          ListBackendAuthenticationConfigsResponse,
          ListBackendAuthenticationConfigsPagedResponse>
      listBackendAuthenticationConfigsSettings() {
    return ((NetworkSecurityStubSettings) getStubSettings())
        .listBackendAuthenticationConfigsSettings();
  }

  /** Returns the object with the settings used for calls to getBackendAuthenticationConfig. */
  public UnaryCallSettings<GetBackendAuthenticationConfigRequest, BackendAuthenticationConfig>
      getBackendAuthenticationConfigSettings() {
    return ((NetworkSecurityStubSettings) getStubSettings())
        .getBackendAuthenticationConfigSettings();
  }

  /** Returns the object with the settings used for calls to createBackendAuthenticationConfig. */
  public UnaryCallSettings<CreateBackendAuthenticationConfigRequest, Operation>
      createBackendAuthenticationConfigSettings() {
    return ((NetworkSecurityStubSettings) getStubSettings())
        .createBackendAuthenticationConfigSettings();
  }

  /** Returns the object with the settings used for calls to createBackendAuthenticationConfig. */
  public OperationCallSettings<
          CreateBackendAuthenticationConfigRequest, BackendAuthenticationConfig, OperationMetadata>
      createBackendAuthenticationConfigOperationSettings() {
    return ((NetworkSecurityStubSettings) getStubSettings())
        .createBackendAuthenticationConfigOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateBackendAuthenticationConfig. */
  public UnaryCallSettings<UpdateBackendAuthenticationConfigRequest, Operation>
      updateBackendAuthenticationConfigSettings() {
    return ((NetworkSecurityStubSettings) getStubSettings())
        .updateBackendAuthenticationConfigSettings();
  }

  /** Returns the object with the settings used for calls to updateBackendAuthenticationConfig. */
  public OperationCallSettings<
          UpdateBackendAuthenticationConfigRequest, BackendAuthenticationConfig, OperationMetadata>
      updateBackendAuthenticationConfigOperationSettings() {
    return ((NetworkSecurityStubSettings) getStubSettings())
        .updateBackendAuthenticationConfigOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteBackendAuthenticationConfig. */
  public UnaryCallSettings<DeleteBackendAuthenticationConfigRequest, Operation>
      deleteBackendAuthenticationConfigSettings() {
    return ((NetworkSecurityStubSettings) getStubSettings())
        .deleteBackendAuthenticationConfigSettings();
  }

  /** Returns the object with the settings used for calls to deleteBackendAuthenticationConfig. */
  public OperationCallSettings<DeleteBackendAuthenticationConfigRequest, Empty, OperationMetadata>
      deleteBackendAuthenticationConfigOperationSettings() {
    return ((NetworkSecurityStubSettings) getStubSettings())
        .deleteBackendAuthenticationConfigOperationSettings();
  }

  /** Returns the object with the settings used for calls to listServerTlsPolicies. */
  public PagedCallSettings<
          ListServerTlsPoliciesRequest,
          ListServerTlsPoliciesResponse,
          ListServerTlsPoliciesPagedResponse>
      listServerTlsPoliciesSettings() {
    return ((NetworkSecurityStubSettings) getStubSettings()).listServerTlsPoliciesSettings();
  }

  /** Returns the object with the settings used for calls to getServerTlsPolicy. */
  public UnaryCallSettings<GetServerTlsPolicyRequest, ServerTlsPolicy>
      getServerTlsPolicySettings() {
    return ((NetworkSecurityStubSettings) getStubSettings()).getServerTlsPolicySettings();
  }

  /** Returns the object with the settings used for calls to createServerTlsPolicy. */
  public UnaryCallSettings<CreateServerTlsPolicyRequest, Operation>
      createServerTlsPolicySettings() {
    return ((NetworkSecurityStubSettings) getStubSettings()).createServerTlsPolicySettings();
  }

  /** Returns the object with the settings used for calls to createServerTlsPolicy. */
  public OperationCallSettings<CreateServerTlsPolicyRequest, ServerTlsPolicy, OperationMetadata>
      createServerTlsPolicyOperationSettings() {
    return ((NetworkSecurityStubSettings) getStubSettings())
        .createServerTlsPolicyOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateServerTlsPolicy. */
  public UnaryCallSettings<UpdateServerTlsPolicyRequest, Operation>
      updateServerTlsPolicySettings() {
    return ((NetworkSecurityStubSettings) getStubSettings()).updateServerTlsPolicySettings();
  }

  /** Returns the object with the settings used for calls to updateServerTlsPolicy. */
  public OperationCallSettings<UpdateServerTlsPolicyRequest, ServerTlsPolicy, OperationMetadata>
      updateServerTlsPolicyOperationSettings() {
    return ((NetworkSecurityStubSettings) getStubSettings())
        .updateServerTlsPolicyOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteServerTlsPolicy. */
  public UnaryCallSettings<DeleteServerTlsPolicyRequest, Operation>
      deleteServerTlsPolicySettings() {
    return ((NetworkSecurityStubSettings) getStubSettings()).deleteServerTlsPolicySettings();
  }

  /** Returns the object with the settings used for calls to deleteServerTlsPolicy. */
  public OperationCallSettings<DeleteServerTlsPolicyRequest, Empty, OperationMetadata>
      deleteServerTlsPolicyOperationSettings() {
    return ((NetworkSecurityStubSettings) getStubSettings())
        .deleteServerTlsPolicyOperationSettings();
  }

  /** Returns the object with the settings used for calls to listClientTlsPolicies. */
  public PagedCallSettings<
          ListClientTlsPoliciesRequest,
          ListClientTlsPoliciesResponse,
          ListClientTlsPoliciesPagedResponse>
      listClientTlsPoliciesSettings() {
    return ((NetworkSecurityStubSettings) getStubSettings()).listClientTlsPoliciesSettings();
  }

  /** Returns the object with the settings used for calls to getClientTlsPolicy. */
  public UnaryCallSettings<GetClientTlsPolicyRequest, ClientTlsPolicy>
      getClientTlsPolicySettings() {
    return ((NetworkSecurityStubSettings) getStubSettings()).getClientTlsPolicySettings();
  }

  /** Returns the object with the settings used for calls to createClientTlsPolicy. */
  public UnaryCallSettings<CreateClientTlsPolicyRequest, Operation>
      createClientTlsPolicySettings() {
    return ((NetworkSecurityStubSettings) getStubSettings()).createClientTlsPolicySettings();
  }

  /** Returns the object with the settings used for calls to createClientTlsPolicy. */
  public OperationCallSettings<CreateClientTlsPolicyRequest, ClientTlsPolicy, OperationMetadata>
      createClientTlsPolicyOperationSettings() {
    return ((NetworkSecurityStubSettings) getStubSettings())
        .createClientTlsPolicyOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateClientTlsPolicy. */
  public UnaryCallSettings<UpdateClientTlsPolicyRequest, Operation>
      updateClientTlsPolicySettings() {
    return ((NetworkSecurityStubSettings) getStubSettings()).updateClientTlsPolicySettings();
  }

  /** Returns the object with the settings used for calls to updateClientTlsPolicy. */
  public OperationCallSettings<UpdateClientTlsPolicyRequest, ClientTlsPolicy, OperationMetadata>
      updateClientTlsPolicyOperationSettings() {
    return ((NetworkSecurityStubSettings) getStubSettings())
        .updateClientTlsPolicyOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteClientTlsPolicy. */
  public UnaryCallSettings<DeleteClientTlsPolicyRequest, Operation>
      deleteClientTlsPolicySettings() {
    return ((NetworkSecurityStubSettings) getStubSettings()).deleteClientTlsPolicySettings();
  }

  /** Returns the object with the settings used for calls to deleteClientTlsPolicy. */
  public OperationCallSettings<DeleteClientTlsPolicyRequest, Empty, OperationMetadata>
      deleteClientTlsPolicyOperationSettings() {
    return ((NetworkSecurityStubSettings) getStubSettings())
        .deleteClientTlsPolicyOperationSettings();
  }

  /** Returns the object with the settings used for calls to listGatewaySecurityPolicies. */
  public PagedCallSettings<
          ListGatewaySecurityPoliciesRequest,
          ListGatewaySecurityPoliciesResponse,
          ListGatewaySecurityPoliciesPagedResponse>
      listGatewaySecurityPoliciesSettings() {
    return ((NetworkSecurityStubSettings) getStubSettings()).listGatewaySecurityPoliciesSettings();
  }

  /** Returns the object with the settings used for calls to getGatewaySecurityPolicy. */
  public UnaryCallSettings<GetGatewaySecurityPolicyRequest, GatewaySecurityPolicy>
      getGatewaySecurityPolicySettings() {
    return ((NetworkSecurityStubSettings) getStubSettings()).getGatewaySecurityPolicySettings();
  }

  /** Returns the object with the settings used for calls to createGatewaySecurityPolicy. */
  public UnaryCallSettings<CreateGatewaySecurityPolicyRequest, Operation>
      createGatewaySecurityPolicySettings() {
    return ((NetworkSecurityStubSettings) getStubSettings()).createGatewaySecurityPolicySettings();
  }

  /** Returns the object with the settings used for calls to createGatewaySecurityPolicy. */
  public OperationCallSettings<
          CreateGatewaySecurityPolicyRequest, GatewaySecurityPolicy, OperationMetadata>
      createGatewaySecurityPolicyOperationSettings() {
    return ((NetworkSecurityStubSettings) getStubSettings())
        .createGatewaySecurityPolicyOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateGatewaySecurityPolicy. */
  public UnaryCallSettings<UpdateGatewaySecurityPolicyRequest, Operation>
      updateGatewaySecurityPolicySettings() {
    return ((NetworkSecurityStubSettings) getStubSettings()).updateGatewaySecurityPolicySettings();
  }

  /** Returns the object with the settings used for calls to updateGatewaySecurityPolicy. */
  public OperationCallSettings<
          UpdateGatewaySecurityPolicyRequest, GatewaySecurityPolicy, OperationMetadata>
      updateGatewaySecurityPolicyOperationSettings() {
    return ((NetworkSecurityStubSettings) getStubSettings())
        .updateGatewaySecurityPolicyOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteGatewaySecurityPolicy. */
  public UnaryCallSettings<DeleteGatewaySecurityPolicyRequest, Operation>
      deleteGatewaySecurityPolicySettings() {
    return ((NetworkSecurityStubSettings) getStubSettings()).deleteGatewaySecurityPolicySettings();
  }

  /** Returns the object with the settings used for calls to deleteGatewaySecurityPolicy. */
  public OperationCallSettings<DeleteGatewaySecurityPolicyRequest, Empty, OperationMetadata>
      deleteGatewaySecurityPolicyOperationSettings() {
    return ((NetworkSecurityStubSettings) getStubSettings())
        .deleteGatewaySecurityPolicyOperationSettings();
  }

  /** Returns the object with the settings used for calls to listGatewaySecurityPolicyRules. */
  public PagedCallSettings<
          ListGatewaySecurityPolicyRulesRequest,
          ListGatewaySecurityPolicyRulesResponse,
          ListGatewaySecurityPolicyRulesPagedResponse>
      listGatewaySecurityPolicyRulesSettings() {
    return ((NetworkSecurityStubSettings) getStubSettings())
        .listGatewaySecurityPolicyRulesSettings();
  }

  /** Returns the object with the settings used for calls to getGatewaySecurityPolicyRule. */
  public UnaryCallSettings<GetGatewaySecurityPolicyRuleRequest, GatewaySecurityPolicyRule>
      getGatewaySecurityPolicyRuleSettings() {
    return ((NetworkSecurityStubSettings) getStubSettings()).getGatewaySecurityPolicyRuleSettings();
  }

  /** Returns the object with the settings used for calls to createGatewaySecurityPolicyRule. */
  public UnaryCallSettings<CreateGatewaySecurityPolicyRuleRequest, Operation>
      createGatewaySecurityPolicyRuleSettings() {
    return ((NetworkSecurityStubSettings) getStubSettings())
        .createGatewaySecurityPolicyRuleSettings();
  }

  /** Returns the object with the settings used for calls to createGatewaySecurityPolicyRule. */
  public OperationCallSettings<
          CreateGatewaySecurityPolicyRuleRequest, GatewaySecurityPolicyRule, OperationMetadata>
      createGatewaySecurityPolicyRuleOperationSettings() {
    return ((NetworkSecurityStubSettings) getStubSettings())
        .createGatewaySecurityPolicyRuleOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateGatewaySecurityPolicyRule. */
  public UnaryCallSettings<UpdateGatewaySecurityPolicyRuleRequest, Operation>
      updateGatewaySecurityPolicyRuleSettings() {
    return ((NetworkSecurityStubSettings) getStubSettings())
        .updateGatewaySecurityPolicyRuleSettings();
  }

  /** Returns the object with the settings used for calls to updateGatewaySecurityPolicyRule. */
  public OperationCallSettings<
          UpdateGatewaySecurityPolicyRuleRequest, GatewaySecurityPolicyRule, OperationMetadata>
      updateGatewaySecurityPolicyRuleOperationSettings() {
    return ((NetworkSecurityStubSettings) getStubSettings())
        .updateGatewaySecurityPolicyRuleOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteGatewaySecurityPolicyRule. */
  public UnaryCallSettings<DeleteGatewaySecurityPolicyRuleRequest, Operation>
      deleteGatewaySecurityPolicyRuleSettings() {
    return ((NetworkSecurityStubSettings) getStubSettings())
        .deleteGatewaySecurityPolicyRuleSettings();
  }

  /** Returns the object with the settings used for calls to deleteGatewaySecurityPolicyRule. */
  public OperationCallSettings<DeleteGatewaySecurityPolicyRuleRequest, Empty, OperationMetadata>
      deleteGatewaySecurityPolicyRuleOperationSettings() {
    return ((NetworkSecurityStubSettings) getStubSettings())
        .deleteGatewaySecurityPolicyRuleOperationSettings();
  }

  /** Returns the object with the settings used for calls to listUrlLists. */
  public PagedCallSettings<ListUrlListsRequest, ListUrlListsResponse, ListUrlListsPagedResponse>
      listUrlListsSettings() {
    return ((NetworkSecurityStubSettings) getStubSettings()).listUrlListsSettings();
  }

  /** Returns the object with the settings used for calls to getUrlList. */
  public UnaryCallSettings<GetUrlListRequest, UrlList> getUrlListSettings() {
    return ((NetworkSecurityStubSettings) getStubSettings()).getUrlListSettings();
  }

  /** Returns the object with the settings used for calls to createUrlList. */
  public UnaryCallSettings<CreateUrlListRequest, Operation> createUrlListSettings() {
    return ((NetworkSecurityStubSettings) getStubSettings()).createUrlListSettings();
  }

  /** Returns the object with the settings used for calls to createUrlList. */
  public OperationCallSettings<CreateUrlListRequest, UrlList, OperationMetadata>
      createUrlListOperationSettings() {
    return ((NetworkSecurityStubSettings) getStubSettings()).createUrlListOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateUrlList. */
  public UnaryCallSettings<UpdateUrlListRequest, Operation> updateUrlListSettings() {
    return ((NetworkSecurityStubSettings) getStubSettings()).updateUrlListSettings();
  }

  /** Returns the object with the settings used for calls to updateUrlList. */
  public OperationCallSettings<UpdateUrlListRequest, UrlList, OperationMetadata>
      updateUrlListOperationSettings() {
    return ((NetworkSecurityStubSettings) getStubSettings()).updateUrlListOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteUrlList. */
  public UnaryCallSettings<DeleteUrlListRequest, Operation> deleteUrlListSettings() {
    return ((NetworkSecurityStubSettings) getStubSettings()).deleteUrlListSettings();
  }

  /** Returns the object with the settings used for calls to deleteUrlList. */
  public OperationCallSettings<DeleteUrlListRequest, Empty, OperationMetadata>
      deleteUrlListOperationSettings() {
    return ((NetworkSecurityStubSettings) getStubSettings()).deleteUrlListOperationSettings();
  }

  /** Returns the object with the settings used for calls to listTlsInspectionPolicies. */
  public PagedCallSettings<
          ListTlsInspectionPoliciesRequest,
          ListTlsInspectionPoliciesResponse,
          ListTlsInspectionPoliciesPagedResponse>
      listTlsInspectionPoliciesSettings() {
    return ((NetworkSecurityStubSettings) getStubSettings()).listTlsInspectionPoliciesSettings();
  }

  /** Returns the object with the settings used for calls to getTlsInspectionPolicy. */
  public UnaryCallSettings<GetTlsInspectionPolicyRequest, TlsInspectionPolicy>
      getTlsInspectionPolicySettings() {
    return ((NetworkSecurityStubSettings) getStubSettings()).getTlsInspectionPolicySettings();
  }

  /** Returns the object with the settings used for calls to createTlsInspectionPolicy. */
  public UnaryCallSettings<CreateTlsInspectionPolicyRequest, Operation>
      createTlsInspectionPolicySettings() {
    return ((NetworkSecurityStubSettings) getStubSettings()).createTlsInspectionPolicySettings();
  }

  /** Returns the object with the settings used for calls to createTlsInspectionPolicy. */
  public OperationCallSettings<
          CreateTlsInspectionPolicyRequest, TlsInspectionPolicy, OperationMetadata>
      createTlsInspectionPolicyOperationSettings() {
    return ((NetworkSecurityStubSettings) getStubSettings())
        .createTlsInspectionPolicyOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateTlsInspectionPolicy. */
  public UnaryCallSettings<UpdateTlsInspectionPolicyRequest, Operation>
      updateTlsInspectionPolicySettings() {
    return ((NetworkSecurityStubSettings) getStubSettings()).updateTlsInspectionPolicySettings();
  }

  /** Returns the object with the settings used for calls to updateTlsInspectionPolicy. */
  public OperationCallSettings<
          UpdateTlsInspectionPolicyRequest, TlsInspectionPolicy, OperationMetadata>
      updateTlsInspectionPolicyOperationSettings() {
    return ((NetworkSecurityStubSettings) getStubSettings())
        .updateTlsInspectionPolicyOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteTlsInspectionPolicy. */
  public UnaryCallSettings<DeleteTlsInspectionPolicyRequest, Operation>
      deleteTlsInspectionPolicySettings() {
    return ((NetworkSecurityStubSettings) getStubSettings()).deleteTlsInspectionPolicySettings();
  }

  /** Returns the object with the settings used for calls to deleteTlsInspectionPolicy. */
  public OperationCallSettings<DeleteTlsInspectionPolicyRequest, Empty, OperationMetadata>
      deleteTlsInspectionPolicyOperationSettings() {
    return ((NetworkSecurityStubSettings) getStubSettings())
        .deleteTlsInspectionPolicyOperationSettings();
  }

  /** Returns the object with the settings used for calls to listAuthzPolicies. */
  public PagedCallSettings<
          ListAuthzPoliciesRequest, ListAuthzPoliciesResponse, ListAuthzPoliciesPagedResponse>
      listAuthzPoliciesSettings() {
    return ((NetworkSecurityStubSettings) getStubSettings()).listAuthzPoliciesSettings();
  }

  /** Returns the object with the settings used for calls to getAuthzPolicy. */
  public UnaryCallSettings<GetAuthzPolicyRequest, AuthzPolicy> getAuthzPolicySettings() {
    return ((NetworkSecurityStubSettings) getStubSettings()).getAuthzPolicySettings();
  }

  /** Returns the object with the settings used for calls to createAuthzPolicy. */
  public UnaryCallSettings<CreateAuthzPolicyRequest, Operation> createAuthzPolicySettings() {
    return ((NetworkSecurityStubSettings) getStubSettings()).createAuthzPolicySettings();
  }

  /** Returns the object with the settings used for calls to createAuthzPolicy. */
  public OperationCallSettings<CreateAuthzPolicyRequest, AuthzPolicy, OperationMetadata>
      createAuthzPolicyOperationSettings() {
    return ((NetworkSecurityStubSettings) getStubSettings()).createAuthzPolicyOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateAuthzPolicy. */
  public UnaryCallSettings<UpdateAuthzPolicyRequest, Operation> updateAuthzPolicySettings() {
    return ((NetworkSecurityStubSettings) getStubSettings()).updateAuthzPolicySettings();
  }

  /** Returns the object with the settings used for calls to updateAuthzPolicy. */
  public OperationCallSettings<UpdateAuthzPolicyRequest, AuthzPolicy, OperationMetadata>
      updateAuthzPolicyOperationSettings() {
    return ((NetworkSecurityStubSettings) getStubSettings()).updateAuthzPolicyOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteAuthzPolicy. */
  public UnaryCallSettings<DeleteAuthzPolicyRequest, Operation> deleteAuthzPolicySettings() {
    return ((NetworkSecurityStubSettings) getStubSettings()).deleteAuthzPolicySettings();
  }

  /** Returns the object with the settings used for calls to deleteAuthzPolicy. */
  public OperationCallSettings<DeleteAuthzPolicyRequest, Empty, OperationMetadata>
      deleteAuthzPolicyOperationSettings() {
    return ((NetworkSecurityStubSettings) getStubSettings()).deleteAuthzPolicyOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((NetworkSecurityStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((NetworkSecurityStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((NetworkSecurityStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((NetworkSecurityStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((NetworkSecurityStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final NetworkSecuritySettings create(NetworkSecurityStubSettings stub)
      throws IOException {
    return new NetworkSecuritySettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return NetworkSecurityStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return NetworkSecurityStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return NetworkSecurityStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return NetworkSecurityStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return NetworkSecurityStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return NetworkSecurityStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return NetworkSecurityStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected NetworkSecuritySettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for NetworkSecuritySettings. */
  public static class Builder extends ClientSettings.Builder<NetworkSecuritySettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(NetworkSecurityStubSettings.newBuilder(clientContext));
    }

    protected Builder(NetworkSecuritySettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(NetworkSecurityStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(NetworkSecurityStubSettings.newBuilder());
    }

    public NetworkSecurityStubSettings.Builder getStubSettingsBuilder() {
      return ((NetworkSecurityStubSettings.Builder) getStubSettings());
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(
          getStubSettingsBuilder().unaryMethodSettingsBuilders(), settingsUpdater);
      return this;
    }

    /** Returns the builder for the settings used for calls to listAuthorizationPolicies. */
    public PagedCallSettings.Builder<
            ListAuthorizationPoliciesRequest,
            ListAuthorizationPoliciesResponse,
            ListAuthorizationPoliciesPagedResponse>
        listAuthorizationPoliciesSettings() {
      return getStubSettingsBuilder().listAuthorizationPoliciesSettings();
    }

    /** Returns the builder for the settings used for calls to getAuthorizationPolicy. */
    public UnaryCallSettings.Builder<GetAuthorizationPolicyRequest, AuthorizationPolicy>
        getAuthorizationPolicySettings() {
      return getStubSettingsBuilder().getAuthorizationPolicySettings();
    }

    /** Returns the builder for the settings used for calls to createAuthorizationPolicy. */
    public UnaryCallSettings.Builder<CreateAuthorizationPolicyRequest, Operation>
        createAuthorizationPolicySettings() {
      return getStubSettingsBuilder().createAuthorizationPolicySettings();
    }

    /** Returns the builder for the settings used for calls to createAuthorizationPolicy. */
    public OperationCallSettings.Builder<
            CreateAuthorizationPolicyRequest, AuthorizationPolicy, OperationMetadata>
        createAuthorizationPolicyOperationSettings() {
      return getStubSettingsBuilder().createAuthorizationPolicyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateAuthorizationPolicy. */
    public UnaryCallSettings.Builder<UpdateAuthorizationPolicyRequest, Operation>
        updateAuthorizationPolicySettings() {
      return getStubSettingsBuilder().updateAuthorizationPolicySettings();
    }

    /** Returns the builder for the settings used for calls to updateAuthorizationPolicy. */
    public OperationCallSettings.Builder<
            UpdateAuthorizationPolicyRequest, AuthorizationPolicy, OperationMetadata>
        updateAuthorizationPolicyOperationSettings() {
      return getStubSettingsBuilder().updateAuthorizationPolicyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAuthorizationPolicy. */
    public UnaryCallSettings.Builder<DeleteAuthorizationPolicyRequest, Operation>
        deleteAuthorizationPolicySettings() {
      return getStubSettingsBuilder().deleteAuthorizationPolicySettings();
    }

    /** Returns the builder for the settings used for calls to deleteAuthorizationPolicy. */
    public OperationCallSettings.Builder<DeleteAuthorizationPolicyRequest, Empty, OperationMetadata>
        deleteAuthorizationPolicyOperationSettings() {
      return getStubSettingsBuilder().deleteAuthorizationPolicyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listBackendAuthenticationConfigs. */
    public PagedCallSettings.Builder<
            ListBackendAuthenticationConfigsRequest,
            ListBackendAuthenticationConfigsResponse,
            ListBackendAuthenticationConfigsPagedResponse>
        listBackendAuthenticationConfigsSettings() {
      return getStubSettingsBuilder().listBackendAuthenticationConfigsSettings();
    }

    /** Returns the builder for the settings used for calls to getBackendAuthenticationConfig. */
    public UnaryCallSettings.Builder<
            GetBackendAuthenticationConfigRequest, BackendAuthenticationConfig>
        getBackendAuthenticationConfigSettings() {
      return getStubSettingsBuilder().getBackendAuthenticationConfigSettings();
    }

    /** Returns the builder for the settings used for calls to createBackendAuthenticationConfig. */
    public UnaryCallSettings.Builder<CreateBackendAuthenticationConfigRequest, Operation>
        createBackendAuthenticationConfigSettings() {
      return getStubSettingsBuilder().createBackendAuthenticationConfigSettings();
    }

    /** Returns the builder for the settings used for calls to createBackendAuthenticationConfig. */
    public OperationCallSettings.Builder<
            CreateBackendAuthenticationConfigRequest,
            BackendAuthenticationConfig,
            OperationMetadata>
        createBackendAuthenticationConfigOperationSettings() {
      return getStubSettingsBuilder().createBackendAuthenticationConfigOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateBackendAuthenticationConfig. */
    public UnaryCallSettings.Builder<UpdateBackendAuthenticationConfigRequest, Operation>
        updateBackendAuthenticationConfigSettings() {
      return getStubSettingsBuilder().updateBackendAuthenticationConfigSettings();
    }

    /** Returns the builder for the settings used for calls to updateBackendAuthenticationConfig. */
    public OperationCallSettings.Builder<
            UpdateBackendAuthenticationConfigRequest,
            BackendAuthenticationConfig,
            OperationMetadata>
        updateBackendAuthenticationConfigOperationSettings() {
      return getStubSettingsBuilder().updateBackendAuthenticationConfigOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteBackendAuthenticationConfig. */
    public UnaryCallSettings.Builder<DeleteBackendAuthenticationConfigRequest, Operation>
        deleteBackendAuthenticationConfigSettings() {
      return getStubSettingsBuilder().deleteBackendAuthenticationConfigSettings();
    }

    /** Returns the builder for the settings used for calls to deleteBackendAuthenticationConfig. */
    public OperationCallSettings.Builder<
            DeleteBackendAuthenticationConfigRequest, Empty, OperationMetadata>
        deleteBackendAuthenticationConfigOperationSettings() {
      return getStubSettingsBuilder().deleteBackendAuthenticationConfigOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listServerTlsPolicies. */
    public PagedCallSettings.Builder<
            ListServerTlsPoliciesRequest,
            ListServerTlsPoliciesResponse,
            ListServerTlsPoliciesPagedResponse>
        listServerTlsPoliciesSettings() {
      return getStubSettingsBuilder().listServerTlsPoliciesSettings();
    }

    /** Returns the builder for the settings used for calls to getServerTlsPolicy. */
    public UnaryCallSettings.Builder<GetServerTlsPolicyRequest, ServerTlsPolicy>
        getServerTlsPolicySettings() {
      return getStubSettingsBuilder().getServerTlsPolicySettings();
    }

    /** Returns the builder for the settings used for calls to createServerTlsPolicy. */
    public UnaryCallSettings.Builder<CreateServerTlsPolicyRequest, Operation>
        createServerTlsPolicySettings() {
      return getStubSettingsBuilder().createServerTlsPolicySettings();
    }

    /** Returns the builder for the settings used for calls to createServerTlsPolicy. */
    public OperationCallSettings.Builder<
            CreateServerTlsPolicyRequest, ServerTlsPolicy, OperationMetadata>
        createServerTlsPolicyOperationSettings() {
      return getStubSettingsBuilder().createServerTlsPolicyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateServerTlsPolicy. */
    public UnaryCallSettings.Builder<UpdateServerTlsPolicyRequest, Operation>
        updateServerTlsPolicySettings() {
      return getStubSettingsBuilder().updateServerTlsPolicySettings();
    }

    /** Returns the builder for the settings used for calls to updateServerTlsPolicy. */
    public OperationCallSettings.Builder<
            UpdateServerTlsPolicyRequest, ServerTlsPolicy, OperationMetadata>
        updateServerTlsPolicyOperationSettings() {
      return getStubSettingsBuilder().updateServerTlsPolicyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteServerTlsPolicy. */
    public UnaryCallSettings.Builder<DeleteServerTlsPolicyRequest, Operation>
        deleteServerTlsPolicySettings() {
      return getStubSettingsBuilder().deleteServerTlsPolicySettings();
    }

    /** Returns the builder for the settings used for calls to deleteServerTlsPolicy. */
    public OperationCallSettings.Builder<DeleteServerTlsPolicyRequest, Empty, OperationMetadata>
        deleteServerTlsPolicyOperationSettings() {
      return getStubSettingsBuilder().deleteServerTlsPolicyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listClientTlsPolicies. */
    public PagedCallSettings.Builder<
            ListClientTlsPoliciesRequest,
            ListClientTlsPoliciesResponse,
            ListClientTlsPoliciesPagedResponse>
        listClientTlsPoliciesSettings() {
      return getStubSettingsBuilder().listClientTlsPoliciesSettings();
    }

    /** Returns the builder for the settings used for calls to getClientTlsPolicy. */
    public UnaryCallSettings.Builder<GetClientTlsPolicyRequest, ClientTlsPolicy>
        getClientTlsPolicySettings() {
      return getStubSettingsBuilder().getClientTlsPolicySettings();
    }

    /** Returns the builder for the settings used for calls to createClientTlsPolicy. */
    public UnaryCallSettings.Builder<CreateClientTlsPolicyRequest, Operation>
        createClientTlsPolicySettings() {
      return getStubSettingsBuilder().createClientTlsPolicySettings();
    }

    /** Returns the builder for the settings used for calls to createClientTlsPolicy. */
    public OperationCallSettings.Builder<
            CreateClientTlsPolicyRequest, ClientTlsPolicy, OperationMetadata>
        createClientTlsPolicyOperationSettings() {
      return getStubSettingsBuilder().createClientTlsPolicyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateClientTlsPolicy. */
    public UnaryCallSettings.Builder<UpdateClientTlsPolicyRequest, Operation>
        updateClientTlsPolicySettings() {
      return getStubSettingsBuilder().updateClientTlsPolicySettings();
    }

    /** Returns the builder for the settings used for calls to updateClientTlsPolicy. */
    public OperationCallSettings.Builder<
            UpdateClientTlsPolicyRequest, ClientTlsPolicy, OperationMetadata>
        updateClientTlsPolicyOperationSettings() {
      return getStubSettingsBuilder().updateClientTlsPolicyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteClientTlsPolicy. */
    public UnaryCallSettings.Builder<DeleteClientTlsPolicyRequest, Operation>
        deleteClientTlsPolicySettings() {
      return getStubSettingsBuilder().deleteClientTlsPolicySettings();
    }

    /** Returns the builder for the settings used for calls to deleteClientTlsPolicy. */
    public OperationCallSettings.Builder<DeleteClientTlsPolicyRequest, Empty, OperationMetadata>
        deleteClientTlsPolicyOperationSettings() {
      return getStubSettingsBuilder().deleteClientTlsPolicyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listGatewaySecurityPolicies. */
    public PagedCallSettings.Builder<
            ListGatewaySecurityPoliciesRequest,
            ListGatewaySecurityPoliciesResponse,
            ListGatewaySecurityPoliciesPagedResponse>
        listGatewaySecurityPoliciesSettings() {
      return getStubSettingsBuilder().listGatewaySecurityPoliciesSettings();
    }

    /** Returns the builder for the settings used for calls to getGatewaySecurityPolicy. */
    public UnaryCallSettings.Builder<GetGatewaySecurityPolicyRequest, GatewaySecurityPolicy>
        getGatewaySecurityPolicySettings() {
      return getStubSettingsBuilder().getGatewaySecurityPolicySettings();
    }

    /** Returns the builder for the settings used for calls to createGatewaySecurityPolicy. */
    public UnaryCallSettings.Builder<CreateGatewaySecurityPolicyRequest, Operation>
        createGatewaySecurityPolicySettings() {
      return getStubSettingsBuilder().createGatewaySecurityPolicySettings();
    }

    /** Returns the builder for the settings used for calls to createGatewaySecurityPolicy. */
    public OperationCallSettings.Builder<
            CreateGatewaySecurityPolicyRequest, GatewaySecurityPolicy, OperationMetadata>
        createGatewaySecurityPolicyOperationSettings() {
      return getStubSettingsBuilder().createGatewaySecurityPolicyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateGatewaySecurityPolicy. */
    public UnaryCallSettings.Builder<UpdateGatewaySecurityPolicyRequest, Operation>
        updateGatewaySecurityPolicySettings() {
      return getStubSettingsBuilder().updateGatewaySecurityPolicySettings();
    }

    /** Returns the builder for the settings used for calls to updateGatewaySecurityPolicy. */
    public OperationCallSettings.Builder<
            UpdateGatewaySecurityPolicyRequest, GatewaySecurityPolicy, OperationMetadata>
        updateGatewaySecurityPolicyOperationSettings() {
      return getStubSettingsBuilder().updateGatewaySecurityPolicyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteGatewaySecurityPolicy. */
    public UnaryCallSettings.Builder<DeleteGatewaySecurityPolicyRequest, Operation>
        deleteGatewaySecurityPolicySettings() {
      return getStubSettingsBuilder().deleteGatewaySecurityPolicySettings();
    }

    /** Returns the builder for the settings used for calls to deleteGatewaySecurityPolicy. */
    public OperationCallSettings.Builder<
            DeleteGatewaySecurityPolicyRequest, Empty, OperationMetadata>
        deleteGatewaySecurityPolicyOperationSettings() {
      return getStubSettingsBuilder().deleteGatewaySecurityPolicyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listGatewaySecurityPolicyRules. */
    public PagedCallSettings.Builder<
            ListGatewaySecurityPolicyRulesRequest,
            ListGatewaySecurityPolicyRulesResponse,
            ListGatewaySecurityPolicyRulesPagedResponse>
        listGatewaySecurityPolicyRulesSettings() {
      return getStubSettingsBuilder().listGatewaySecurityPolicyRulesSettings();
    }

    /** Returns the builder for the settings used for calls to getGatewaySecurityPolicyRule. */
    public UnaryCallSettings.Builder<GetGatewaySecurityPolicyRuleRequest, GatewaySecurityPolicyRule>
        getGatewaySecurityPolicyRuleSettings() {
      return getStubSettingsBuilder().getGatewaySecurityPolicyRuleSettings();
    }

    /** Returns the builder for the settings used for calls to createGatewaySecurityPolicyRule. */
    public UnaryCallSettings.Builder<CreateGatewaySecurityPolicyRuleRequest, Operation>
        createGatewaySecurityPolicyRuleSettings() {
      return getStubSettingsBuilder().createGatewaySecurityPolicyRuleSettings();
    }

    /** Returns the builder for the settings used for calls to createGatewaySecurityPolicyRule. */
    public OperationCallSettings.Builder<
            CreateGatewaySecurityPolicyRuleRequest, GatewaySecurityPolicyRule, OperationMetadata>
        createGatewaySecurityPolicyRuleOperationSettings() {
      return getStubSettingsBuilder().createGatewaySecurityPolicyRuleOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateGatewaySecurityPolicyRule. */
    public UnaryCallSettings.Builder<UpdateGatewaySecurityPolicyRuleRequest, Operation>
        updateGatewaySecurityPolicyRuleSettings() {
      return getStubSettingsBuilder().updateGatewaySecurityPolicyRuleSettings();
    }

    /** Returns the builder for the settings used for calls to updateGatewaySecurityPolicyRule. */
    public OperationCallSettings.Builder<
            UpdateGatewaySecurityPolicyRuleRequest, GatewaySecurityPolicyRule, OperationMetadata>
        updateGatewaySecurityPolicyRuleOperationSettings() {
      return getStubSettingsBuilder().updateGatewaySecurityPolicyRuleOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteGatewaySecurityPolicyRule. */
    public UnaryCallSettings.Builder<DeleteGatewaySecurityPolicyRuleRequest, Operation>
        deleteGatewaySecurityPolicyRuleSettings() {
      return getStubSettingsBuilder().deleteGatewaySecurityPolicyRuleSettings();
    }

    /** Returns the builder for the settings used for calls to deleteGatewaySecurityPolicyRule. */
    public OperationCallSettings.Builder<
            DeleteGatewaySecurityPolicyRuleRequest, Empty, OperationMetadata>
        deleteGatewaySecurityPolicyRuleOperationSettings() {
      return getStubSettingsBuilder().deleteGatewaySecurityPolicyRuleOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listUrlLists. */
    public PagedCallSettings.Builder<
            ListUrlListsRequest, ListUrlListsResponse, ListUrlListsPagedResponse>
        listUrlListsSettings() {
      return getStubSettingsBuilder().listUrlListsSettings();
    }

    /** Returns the builder for the settings used for calls to getUrlList. */
    public UnaryCallSettings.Builder<GetUrlListRequest, UrlList> getUrlListSettings() {
      return getStubSettingsBuilder().getUrlListSettings();
    }

    /** Returns the builder for the settings used for calls to createUrlList. */
    public UnaryCallSettings.Builder<CreateUrlListRequest, Operation> createUrlListSettings() {
      return getStubSettingsBuilder().createUrlListSettings();
    }

    /** Returns the builder for the settings used for calls to createUrlList. */
    public OperationCallSettings.Builder<CreateUrlListRequest, UrlList, OperationMetadata>
        createUrlListOperationSettings() {
      return getStubSettingsBuilder().createUrlListOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateUrlList. */
    public UnaryCallSettings.Builder<UpdateUrlListRequest, Operation> updateUrlListSettings() {
      return getStubSettingsBuilder().updateUrlListSettings();
    }

    /** Returns the builder for the settings used for calls to updateUrlList. */
    public OperationCallSettings.Builder<UpdateUrlListRequest, UrlList, OperationMetadata>
        updateUrlListOperationSettings() {
      return getStubSettingsBuilder().updateUrlListOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteUrlList. */
    public UnaryCallSettings.Builder<DeleteUrlListRequest, Operation> deleteUrlListSettings() {
      return getStubSettingsBuilder().deleteUrlListSettings();
    }

    /** Returns the builder for the settings used for calls to deleteUrlList. */
    public OperationCallSettings.Builder<DeleteUrlListRequest, Empty, OperationMetadata>
        deleteUrlListOperationSettings() {
      return getStubSettingsBuilder().deleteUrlListOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listTlsInspectionPolicies. */
    public PagedCallSettings.Builder<
            ListTlsInspectionPoliciesRequest,
            ListTlsInspectionPoliciesResponse,
            ListTlsInspectionPoliciesPagedResponse>
        listTlsInspectionPoliciesSettings() {
      return getStubSettingsBuilder().listTlsInspectionPoliciesSettings();
    }

    /** Returns the builder for the settings used for calls to getTlsInspectionPolicy. */
    public UnaryCallSettings.Builder<GetTlsInspectionPolicyRequest, TlsInspectionPolicy>
        getTlsInspectionPolicySettings() {
      return getStubSettingsBuilder().getTlsInspectionPolicySettings();
    }

    /** Returns the builder for the settings used for calls to createTlsInspectionPolicy. */
    public UnaryCallSettings.Builder<CreateTlsInspectionPolicyRequest, Operation>
        createTlsInspectionPolicySettings() {
      return getStubSettingsBuilder().createTlsInspectionPolicySettings();
    }

    /** Returns the builder for the settings used for calls to createTlsInspectionPolicy. */
    public OperationCallSettings.Builder<
            CreateTlsInspectionPolicyRequest, TlsInspectionPolicy, OperationMetadata>
        createTlsInspectionPolicyOperationSettings() {
      return getStubSettingsBuilder().createTlsInspectionPolicyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateTlsInspectionPolicy. */
    public UnaryCallSettings.Builder<UpdateTlsInspectionPolicyRequest, Operation>
        updateTlsInspectionPolicySettings() {
      return getStubSettingsBuilder().updateTlsInspectionPolicySettings();
    }

    /** Returns the builder for the settings used for calls to updateTlsInspectionPolicy. */
    public OperationCallSettings.Builder<
            UpdateTlsInspectionPolicyRequest, TlsInspectionPolicy, OperationMetadata>
        updateTlsInspectionPolicyOperationSettings() {
      return getStubSettingsBuilder().updateTlsInspectionPolicyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteTlsInspectionPolicy. */
    public UnaryCallSettings.Builder<DeleteTlsInspectionPolicyRequest, Operation>
        deleteTlsInspectionPolicySettings() {
      return getStubSettingsBuilder().deleteTlsInspectionPolicySettings();
    }

    /** Returns the builder for the settings used for calls to deleteTlsInspectionPolicy. */
    public OperationCallSettings.Builder<DeleteTlsInspectionPolicyRequest, Empty, OperationMetadata>
        deleteTlsInspectionPolicyOperationSettings() {
      return getStubSettingsBuilder().deleteTlsInspectionPolicyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listAuthzPolicies. */
    public PagedCallSettings.Builder<
            ListAuthzPoliciesRequest, ListAuthzPoliciesResponse, ListAuthzPoliciesPagedResponse>
        listAuthzPoliciesSettings() {
      return getStubSettingsBuilder().listAuthzPoliciesSettings();
    }

    /** Returns the builder for the settings used for calls to getAuthzPolicy. */
    public UnaryCallSettings.Builder<GetAuthzPolicyRequest, AuthzPolicy> getAuthzPolicySettings() {
      return getStubSettingsBuilder().getAuthzPolicySettings();
    }

    /** Returns the builder for the settings used for calls to createAuthzPolicy. */
    public UnaryCallSettings.Builder<CreateAuthzPolicyRequest, Operation>
        createAuthzPolicySettings() {
      return getStubSettingsBuilder().createAuthzPolicySettings();
    }

    /** Returns the builder for the settings used for calls to createAuthzPolicy. */
    public OperationCallSettings.Builder<CreateAuthzPolicyRequest, AuthzPolicy, OperationMetadata>
        createAuthzPolicyOperationSettings() {
      return getStubSettingsBuilder().createAuthzPolicyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateAuthzPolicy. */
    public UnaryCallSettings.Builder<UpdateAuthzPolicyRequest, Operation>
        updateAuthzPolicySettings() {
      return getStubSettingsBuilder().updateAuthzPolicySettings();
    }

    /** Returns the builder for the settings used for calls to updateAuthzPolicy. */
    public OperationCallSettings.Builder<UpdateAuthzPolicyRequest, AuthzPolicy, OperationMetadata>
        updateAuthzPolicyOperationSettings() {
      return getStubSettingsBuilder().updateAuthzPolicyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAuthzPolicy. */
    public UnaryCallSettings.Builder<DeleteAuthzPolicyRequest, Operation>
        deleteAuthzPolicySettings() {
      return getStubSettingsBuilder().deleteAuthzPolicySettings();
    }

    /** Returns the builder for the settings used for calls to deleteAuthzPolicy. */
    public OperationCallSettings.Builder<DeleteAuthzPolicyRequest, Empty, OperationMetadata>
        deleteAuthzPolicyOperationSettings() {
      return getStubSettingsBuilder().deleteAuthzPolicyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return getStubSettingsBuilder().listLocationsSettings();
    }

    /** Returns the builder for the settings used for calls to getLocation. */
    public UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings() {
      return getStubSettingsBuilder().getLocationSettings();
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return getStubSettingsBuilder().setIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getStubSettingsBuilder().getIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return getStubSettingsBuilder().testIamPermissionsSettings();
    }

    @Override
    public NetworkSecuritySettings build() throws IOException {
      return new NetworkSecuritySettings(this);
    }
  }
}
