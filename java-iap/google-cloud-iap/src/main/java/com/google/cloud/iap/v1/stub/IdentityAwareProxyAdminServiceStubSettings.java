/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.iap.v1.stub;

import static com.google.cloud.iap.v1.IdentityAwareProxyAdminServiceClient.ListTunnelDestGroupsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.iap.v1.CreateTunnelDestGroupRequest;
import com.google.cloud.iap.v1.DeleteTunnelDestGroupRequest;
import com.google.cloud.iap.v1.GetIapSettingsRequest;
import com.google.cloud.iap.v1.GetTunnelDestGroupRequest;
import com.google.cloud.iap.v1.IapSettings;
import com.google.cloud.iap.v1.ListTunnelDestGroupsRequest;
import com.google.cloud.iap.v1.ListTunnelDestGroupsResponse;
import com.google.cloud.iap.v1.TunnelDestGroup;
import com.google.cloud.iap.v1.UpdateIapSettingsRequest;
import com.google.cloud.iap.v1.UpdateTunnelDestGroupRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link IdentityAwareProxyAdminServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (iap.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of setIamPolicy to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * IdentityAwareProxyAdminServiceStubSettings.Builder
 *     identityAwareProxyAdminServiceSettingsBuilder =
 *         IdentityAwareProxyAdminServiceStubSettings.newBuilder();
 * identityAwareProxyAdminServiceSettingsBuilder
 *     .setIamPolicySettings()
 *     .setRetrySettings(
 *         identityAwareProxyAdminServiceSettingsBuilder
 *             .setIamPolicySettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * IdentityAwareProxyAdminServiceStubSettings identityAwareProxyAdminServiceSettings =
 *     identityAwareProxyAdminServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class IdentityAwareProxyAdminServiceStubSettings
    extends StubSettings<IdentityAwareProxyAdminServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;
  private final UnaryCallSettings<GetIapSettingsRequest, IapSettings> getIapSettingsSettings;
  private final UnaryCallSettings<UpdateIapSettingsRequest, IapSettings> updateIapSettingsSettings;
  private final PagedCallSettings<
          ListTunnelDestGroupsRequest,
          ListTunnelDestGroupsResponse,
          ListTunnelDestGroupsPagedResponse>
      listTunnelDestGroupsSettings;
  private final UnaryCallSettings<CreateTunnelDestGroupRequest, TunnelDestGroup>
      createTunnelDestGroupSettings;
  private final UnaryCallSettings<GetTunnelDestGroupRequest, TunnelDestGroup>
      getTunnelDestGroupSettings;
  private final UnaryCallSettings<DeleteTunnelDestGroupRequest, Empty>
      deleteTunnelDestGroupSettings;
  private final UnaryCallSettings<UpdateTunnelDestGroupRequest, TunnelDestGroup>
      updateTunnelDestGroupSettings;

  private static final PagedListDescriptor<
          ListTunnelDestGroupsRequest, ListTunnelDestGroupsResponse, TunnelDestGroup>
      LIST_TUNNEL_DEST_GROUPS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListTunnelDestGroupsRequest, ListTunnelDestGroupsResponse, TunnelDestGroup>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListTunnelDestGroupsRequest injectToken(
                ListTunnelDestGroupsRequest payload, String token) {
              return ListTunnelDestGroupsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListTunnelDestGroupsRequest injectPageSize(
                ListTunnelDestGroupsRequest payload, int pageSize) {
              return ListTunnelDestGroupsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListTunnelDestGroupsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListTunnelDestGroupsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<TunnelDestGroup> extractResources(
                ListTunnelDestGroupsResponse payload) {
              return payload.getTunnelDestGroupsList() == null
                  ? ImmutableList.<TunnelDestGroup>of()
                  : payload.getTunnelDestGroupsList();
            }
          };

  private static final PagedListResponseFactory<
          ListTunnelDestGroupsRequest,
          ListTunnelDestGroupsResponse,
          ListTunnelDestGroupsPagedResponse>
      LIST_TUNNEL_DEST_GROUPS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListTunnelDestGroupsRequest,
              ListTunnelDestGroupsResponse,
              ListTunnelDestGroupsPagedResponse>() {
            @Override
            public ApiFuture<ListTunnelDestGroupsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListTunnelDestGroupsRequest, ListTunnelDestGroupsResponse> callable,
                ListTunnelDestGroupsRequest request,
                ApiCallContext context,
                ApiFuture<ListTunnelDestGroupsResponse> futureResponse) {
              PageContext<
                      ListTunnelDestGroupsRequest, ListTunnelDestGroupsResponse, TunnelDestGroup>
                  pageContext =
                      PageContext.create(
                          callable, LIST_TUNNEL_DEST_GROUPS_PAGE_STR_DESC, request, context);
              return ListTunnelDestGroupsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

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

  /** Returns the object with the settings used for calls to getIapSettings. */
  public UnaryCallSettings<GetIapSettingsRequest, IapSettings> getIapSettingsSettings() {
    return getIapSettingsSettings;
  }

  /** Returns the object with the settings used for calls to updateIapSettings. */
  public UnaryCallSettings<UpdateIapSettingsRequest, IapSettings> updateIapSettingsSettings() {
    return updateIapSettingsSettings;
  }

  /** Returns the object with the settings used for calls to listTunnelDestGroups. */
  public PagedCallSettings<
          ListTunnelDestGroupsRequest,
          ListTunnelDestGroupsResponse,
          ListTunnelDestGroupsPagedResponse>
      listTunnelDestGroupsSettings() {
    return listTunnelDestGroupsSettings;
  }

  /** Returns the object with the settings used for calls to createTunnelDestGroup. */
  public UnaryCallSettings<CreateTunnelDestGroupRequest, TunnelDestGroup>
      createTunnelDestGroupSettings() {
    return createTunnelDestGroupSettings;
  }

  /** Returns the object with the settings used for calls to getTunnelDestGroup. */
  public UnaryCallSettings<GetTunnelDestGroupRequest, TunnelDestGroup>
      getTunnelDestGroupSettings() {
    return getTunnelDestGroupSettings;
  }

  /** Returns the object with the settings used for calls to deleteTunnelDestGroup. */
  public UnaryCallSettings<DeleteTunnelDestGroupRequest, Empty> deleteTunnelDestGroupSettings() {
    return deleteTunnelDestGroupSettings;
  }

  /** Returns the object with the settings used for calls to updateTunnelDestGroup. */
  public UnaryCallSettings<UpdateTunnelDestGroupRequest, TunnelDestGroup>
      updateTunnelDestGroupSettings() {
    return updateTunnelDestGroupSettings;
  }

  public IdentityAwareProxyAdminServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcIdentityAwareProxyAdminServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonIdentityAwareProxyAdminServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "iap";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "iap.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "iap.mtls.googleapis.com:443";
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

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic",
            GaxProperties.getLibraryVersion(IdentityAwareProxyAdminServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic",
            GaxProperties.getLibraryVersion(IdentityAwareProxyAdminServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return IdentityAwareProxyAdminServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
  public static Builder newHttpJsonBuilder() {
    return Builder.createHttpJsonDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected IdentityAwareProxyAdminServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
    getIapSettingsSettings = settingsBuilder.getIapSettingsSettings().build();
    updateIapSettingsSettings = settingsBuilder.updateIapSettingsSettings().build();
    listTunnelDestGroupsSettings = settingsBuilder.listTunnelDestGroupsSettings().build();
    createTunnelDestGroupSettings = settingsBuilder.createTunnelDestGroupSettings().build();
    getTunnelDestGroupSettings = settingsBuilder.getTunnelDestGroupSettings().build();
    deleteTunnelDestGroupSettings = settingsBuilder.deleteTunnelDestGroupSettings().build();
    updateTunnelDestGroupSettings = settingsBuilder.updateTunnelDestGroupSettings().build();
  }

  /** Builder for IdentityAwareProxyAdminServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<IdentityAwareProxyAdminServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings;
    private final UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings;
    private final UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings;
    private final UnaryCallSettings.Builder<GetIapSettingsRequest, IapSettings>
        getIapSettingsSettings;
    private final UnaryCallSettings.Builder<UpdateIapSettingsRequest, IapSettings>
        updateIapSettingsSettings;
    private final PagedCallSettings.Builder<
            ListTunnelDestGroupsRequest,
            ListTunnelDestGroupsResponse,
            ListTunnelDestGroupsPagedResponse>
        listTunnelDestGroupsSettings;
    private final UnaryCallSettings.Builder<CreateTunnelDestGroupRequest, TunnelDestGroup>
        createTunnelDestGroupSettings;
    private final UnaryCallSettings.Builder<GetTunnelDestGroupRequest, TunnelDestGroup>
        getTunnelDestGroupSettings;
    private final UnaryCallSettings.Builder<DeleteTunnelDestGroupRequest, Empty>
        deleteTunnelDestGroupSettings;
    private final UnaryCallSettings.Builder<UpdateTunnelDestGroupRequest, TunnelDestGroup>
        updateTunnelDestGroupSettings;
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

      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIapSettingsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateIapSettingsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listTunnelDestGroupsSettings =
          PagedCallSettings.newBuilder(LIST_TUNNEL_DEST_GROUPS_PAGE_STR_FACT);
      createTunnelDestGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getTunnelDestGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteTunnelDestGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateTunnelDestGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings,
              getIapSettingsSettings,
              updateIapSettingsSettings,
              listTunnelDestGroupsSettings,
              createTunnelDestGroupSettings,
              getTunnelDestGroupSettings,
              deleteTunnelDestGroupSettings,
              updateTunnelDestGroupSettings);
      initDefaults(this);
    }

    protected Builder(IdentityAwareProxyAdminServiceStubSettings settings) {
      super(settings);

      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();
      getIapSettingsSettings = settings.getIapSettingsSettings.toBuilder();
      updateIapSettingsSettings = settings.updateIapSettingsSettings.toBuilder();
      listTunnelDestGroupsSettings = settings.listTunnelDestGroupsSettings.toBuilder();
      createTunnelDestGroupSettings = settings.createTunnelDestGroupSettings.toBuilder();
      getTunnelDestGroupSettings = settings.getTunnelDestGroupSettings.toBuilder();
      deleteTunnelDestGroupSettings = settings.deleteTunnelDestGroupSettings.toBuilder();
      updateTunnelDestGroupSettings = settings.updateTunnelDestGroupSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings,
              getIapSettingsSettings,
              updateIapSettingsSettings,
              listTunnelDestGroupsSettings,
              createTunnelDestGroupSettings,
              getTunnelDestGroupSettings,
              deleteTunnelDestGroupSettings,
              updateTunnelDestGroupSettings);
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

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
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
          .getIapSettingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateIapSettingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listTunnelDestGroupsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createTunnelDestGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getTunnelDestGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteTunnelDestGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateTunnelDestGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

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

    /** Returns the builder for the settings used for calls to getIapSettings. */
    public UnaryCallSettings.Builder<GetIapSettingsRequest, IapSettings> getIapSettingsSettings() {
      return getIapSettingsSettings;
    }

    /** Returns the builder for the settings used for calls to updateIapSettings. */
    public UnaryCallSettings.Builder<UpdateIapSettingsRequest, IapSettings>
        updateIapSettingsSettings() {
      return updateIapSettingsSettings;
    }

    /** Returns the builder for the settings used for calls to listTunnelDestGroups. */
    public PagedCallSettings.Builder<
            ListTunnelDestGroupsRequest,
            ListTunnelDestGroupsResponse,
            ListTunnelDestGroupsPagedResponse>
        listTunnelDestGroupsSettings() {
      return listTunnelDestGroupsSettings;
    }

    /** Returns the builder for the settings used for calls to createTunnelDestGroup. */
    public UnaryCallSettings.Builder<CreateTunnelDestGroupRequest, TunnelDestGroup>
        createTunnelDestGroupSettings() {
      return createTunnelDestGroupSettings;
    }

    /** Returns the builder for the settings used for calls to getTunnelDestGroup. */
    public UnaryCallSettings.Builder<GetTunnelDestGroupRequest, TunnelDestGroup>
        getTunnelDestGroupSettings() {
      return getTunnelDestGroupSettings;
    }

    /** Returns the builder for the settings used for calls to deleteTunnelDestGroup. */
    public UnaryCallSettings.Builder<DeleteTunnelDestGroupRequest, Empty>
        deleteTunnelDestGroupSettings() {
      return deleteTunnelDestGroupSettings;
    }

    /** Returns the builder for the settings used for calls to updateTunnelDestGroup. */
    public UnaryCallSettings.Builder<UpdateTunnelDestGroupRequest, TunnelDestGroup>
        updateTunnelDestGroupSettings() {
      return updateTunnelDestGroupSettings;
    }

    @Override
    public IdentityAwareProxyAdminServiceStubSettings build() throws IOException {
      return new IdentityAwareProxyAdminServiceStubSettings(this);
    }
  }
}
