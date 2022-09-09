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

package com.google.cloud.networksecurity.v1.stub;

import static com.google.cloud.networksecurity.v1.NetworkSecurityClient.ListAuthorizationPoliciesPagedResponse;
import static com.google.cloud.networksecurity.v1.NetworkSecurityClient.ListClientTlsPoliciesPagedResponse;
import static com.google.cloud.networksecurity.v1.NetworkSecurityClient.ListServerTlsPoliciesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
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
import com.google.cloud.networksecurity.v1.AuthorizationPolicy;
import com.google.cloud.networksecurity.v1.ClientTlsPolicy;
import com.google.cloud.networksecurity.v1.CreateAuthorizationPolicyRequest;
import com.google.cloud.networksecurity.v1.CreateClientTlsPolicyRequest;
import com.google.cloud.networksecurity.v1.CreateServerTlsPolicyRequest;
import com.google.cloud.networksecurity.v1.DeleteAuthorizationPolicyRequest;
import com.google.cloud.networksecurity.v1.DeleteClientTlsPolicyRequest;
import com.google.cloud.networksecurity.v1.DeleteServerTlsPolicyRequest;
import com.google.cloud.networksecurity.v1.GetAuthorizationPolicyRequest;
import com.google.cloud.networksecurity.v1.GetClientTlsPolicyRequest;
import com.google.cloud.networksecurity.v1.GetServerTlsPolicyRequest;
import com.google.cloud.networksecurity.v1.ListAuthorizationPoliciesRequest;
import com.google.cloud.networksecurity.v1.ListAuthorizationPoliciesResponse;
import com.google.cloud.networksecurity.v1.ListClientTlsPoliciesRequest;
import com.google.cloud.networksecurity.v1.ListClientTlsPoliciesResponse;
import com.google.cloud.networksecurity.v1.ListServerTlsPoliciesRequest;
import com.google.cloud.networksecurity.v1.ListServerTlsPoliciesResponse;
import com.google.cloud.networksecurity.v1.OperationMetadata;
import com.google.cloud.networksecurity.v1.ServerTlsPolicy;
import com.google.cloud.networksecurity.v1.UpdateAuthorizationPolicyRequest;
import com.google.cloud.networksecurity.v1.UpdateClientTlsPolicyRequest;
import com.google.cloud.networksecurity.v1.UpdateServerTlsPolicyRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

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
 * <p>For example, to set the total timeout of getAuthorizationPolicy to 30 seconds:
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
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * NetworkSecurityStubSettings networkSecuritySettings = networkSecuritySettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
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
              return payload.getAuthorizationPoliciesList() == null
                  ? ImmutableList.<AuthorizationPolicy>of()
                  : payload.getAuthorizationPoliciesList();
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
              return payload.getServerTlsPoliciesList() == null
                  ? ImmutableList.<ServerTlsPolicy>of()
                  : payload.getServerTlsPoliciesList();
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
              return payload.getClientTlsPoliciesList() == null
                  ? ImmutableList.<ClientTlsPolicy>of()
                  : payload.getClientTlsPoliciesList();
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

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
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

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
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
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
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

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listAuthorizationPoliciesSettings,
              getAuthorizationPolicySettings,
              createAuthorizationPolicySettings,
              updateAuthorizationPolicySettings,
              deleteAuthorizationPolicySettings,
              listServerTlsPoliciesSettings,
              getServerTlsPolicySettings,
              createServerTlsPolicySettings,
              updateServerTlsPolicySettings,
              deleteServerTlsPolicySettings,
              listClientTlsPoliciesSettings,
              getClientTlsPolicySettings,
              createClientTlsPolicySettings,
              updateClientTlsPolicySettings,
              deleteClientTlsPolicySettings);
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

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listAuthorizationPoliciesSettings,
              getAuthorizationPolicySettings,
              createAuthorizationPolicySettings,
              updateAuthorizationPolicySettings,
              deleteAuthorizationPolicySettings,
              listServerTlsPoliciesSettings,
              getServerTlsPolicySettings,
              createServerTlsPolicySettings,
              updateServerTlsPolicySettings,
              deleteServerTlsPolicySettings,
              listClientTlsPoliciesSettings,
              getClientTlsPolicySettings,
              createClientTlsPolicySettings,
              updateClientTlsPolicySettings,
              deleteClientTlsPolicySettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
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
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
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
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
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
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
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
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
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
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
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
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
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
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
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
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
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
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
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
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
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
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
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
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteAuthorizationPolicyRequest, Empty, OperationMetadata>
        deleteAuthorizationPolicyOperationSettings() {
      return deleteAuthorizationPolicyOperationSettings;
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
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
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
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
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
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
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
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
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
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
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
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteClientTlsPolicyRequest, Empty, OperationMetadata>
        deleteClientTlsPolicyOperationSettings() {
      return deleteClientTlsPolicyOperationSettings;
    }

    @Override
    public NetworkSecurityStubSettings build() throws IOException {
      return new NetworkSecurityStubSettings(this);
    }
  }
}
