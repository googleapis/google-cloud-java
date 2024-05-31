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

import static com.google.cloud.iap.v1.IdentityAwareProxyOAuthServiceClient.ListIdentityAwareProxyClientsPagedResponse;

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
import com.google.cloud.iap.v1.Brand;
import com.google.cloud.iap.v1.CreateBrandRequest;
import com.google.cloud.iap.v1.CreateIdentityAwareProxyClientRequest;
import com.google.cloud.iap.v1.DeleteIdentityAwareProxyClientRequest;
import com.google.cloud.iap.v1.GetBrandRequest;
import com.google.cloud.iap.v1.GetIdentityAwareProxyClientRequest;
import com.google.cloud.iap.v1.IdentityAwareProxyClient;
import com.google.cloud.iap.v1.ListBrandsRequest;
import com.google.cloud.iap.v1.ListBrandsResponse;
import com.google.cloud.iap.v1.ListIdentityAwareProxyClientsRequest;
import com.google.cloud.iap.v1.ListIdentityAwareProxyClientsResponse;
import com.google.cloud.iap.v1.ResetIdentityAwareProxyClientSecretRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link IdentityAwareProxyOAuthServiceStub}.
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
 * <p>For example, to set the total timeout of listBrands to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * IdentityAwareProxyOAuthServiceStubSettings.Builder
 *     identityAwareProxyOAuthServiceSettingsBuilder =
 *         IdentityAwareProxyOAuthServiceStubSettings.newBuilder();
 * identityAwareProxyOAuthServiceSettingsBuilder
 *     .listBrandsSettings()
 *     .setRetrySettings(
 *         identityAwareProxyOAuthServiceSettingsBuilder
 *             .listBrandsSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * IdentityAwareProxyOAuthServiceStubSettings identityAwareProxyOAuthServiceSettings =
 *     identityAwareProxyOAuthServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class IdentityAwareProxyOAuthServiceStubSettings
    extends StubSettings<IdentityAwareProxyOAuthServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<ListBrandsRequest, ListBrandsResponse> listBrandsSettings;
  private final UnaryCallSettings<CreateBrandRequest, Brand> createBrandSettings;
  private final UnaryCallSettings<GetBrandRequest, Brand> getBrandSettings;
  private final UnaryCallSettings<CreateIdentityAwareProxyClientRequest, IdentityAwareProxyClient>
      createIdentityAwareProxyClientSettings;
  private final PagedCallSettings<
          ListIdentityAwareProxyClientsRequest,
          ListIdentityAwareProxyClientsResponse,
          ListIdentityAwareProxyClientsPagedResponse>
      listIdentityAwareProxyClientsSettings;
  private final UnaryCallSettings<GetIdentityAwareProxyClientRequest, IdentityAwareProxyClient>
      getIdentityAwareProxyClientSettings;
  private final UnaryCallSettings<
          ResetIdentityAwareProxyClientSecretRequest, IdentityAwareProxyClient>
      resetIdentityAwareProxyClientSecretSettings;
  private final UnaryCallSettings<DeleteIdentityAwareProxyClientRequest, Empty>
      deleteIdentityAwareProxyClientSettings;

  private static final PagedListDescriptor<
          ListIdentityAwareProxyClientsRequest,
          ListIdentityAwareProxyClientsResponse,
          IdentityAwareProxyClient>
      LIST_IDENTITY_AWARE_PROXY_CLIENTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListIdentityAwareProxyClientsRequest,
              ListIdentityAwareProxyClientsResponse,
              IdentityAwareProxyClient>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListIdentityAwareProxyClientsRequest injectToken(
                ListIdentityAwareProxyClientsRequest payload, String token) {
              return ListIdentityAwareProxyClientsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListIdentityAwareProxyClientsRequest injectPageSize(
                ListIdentityAwareProxyClientsRequest payload, int pageSize) {
              return ListIdentityAwareProxyClientsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListIdentityAwareProxyClientsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListIdentityAwareProxyClientsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<IdentityAwareProxyClient> extractResources(
                ListIdentityAwareProxyClientsResponse payload) {
              return payload.getIdentityAwareProxyClientsList() == null
                  ? ImmutableList.<IdentityAwareProxyClient>of()
                  : payload.getIdentityAwareProxyClientsList();
            }
          };

  private static final PagedListResponseFactory<
          ListIdentityAwareProxyClientsRequest,
          ListIdentityAwareProxyClientsResponse,
          ListIdentityAwareProxyClientsPagedResponse>
      LIST_IDENTITY_AWARE_PROXY_CLIENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListIdentityAwareProxyClientsRequest,
              ListIdentityAwareProxyClientsResponse,
              ListIdentityAwareProxyClientsPagedResponse>() {
            @Override
            public ApiFuture<ListIdentityAwareProxyClientsPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        ListIdentityAwareProxyClientsRequest, ListIdentityAwareProxyClientsResponse>
                    callable,
                ListIdentityAwareProxyClientsRequest request,
                ApiCallContext context,
                ApiFuture<ListIdentityAwareProxyClientsResponse> futureResponse) {
              PageContext<
                      ListIdentityAwareProxyClientsRequest,
                      ListIdentityAwareProxyClientsResponse,
                      IdentityAwareProxyClient>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_IDENTITY_AWARE_PROXY_CLIENTS_PAGE_STR_DESC,
                          request,
                          context);
              return ListIdentityAwareProxyClientsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listBrands. */
  public UnaryCallSettings<ListBrandsRequest, ListBrandsResponse> listBrandsSettings() {
    return listBrandsSettings;
  }

  /** Returns the object with the settings used for calls to createBrand. */
  public UnaryCallSettings<CreateBrandRequest, Brand> createBrandSettings() {
    return createBrandSettings;
  }

  /** Returns the object with the settings used for calls to getBrand. */
  public UnaryCallSettings<GetBrandRequest, Brand> getBrandSettings() {
    return getBrandSettings;
  }

  /** Returns the object with the settings used for calls to createIdentityAwareProxyClient. */
  public UnaryCallSettings<CreateIdentityAwareProxyClientRequest, IdentityAwareProxyClient>
      createIdentityAwareProxyClientSettings() {
    return createIdentityAwareProxyClientSettings;
  }

  /** Returns the object with the settings used for calls to listIdentityAwareProxyClients. */
  public PagedCallSettings<
          ListIdentityAwareProxyClientsRequest,
          ListIdentityAwareProxyClientsResponse,
          ListIdentityAwareProxyClientsPagedResponse>
      listIdentityAwareProxyClientsSettings() {
    return listIdentityAwareProxyClientsSettings;
  }

  /** Returns the object with the settings used for calls to getIdentityAwareProxyClient. */
  public UnaryCallSettings<GetIdentityAwareProxyClientRequest, IdentityAwareProxyClient>
      getIdentityAwareProxyClientSettings() {
    return getIdentityAwareProxyClientSettings;
  }

  /** Returns the object with the settings used for calls to resetIdentityAwareProxyClientSecret. */
  public UnaryCallSettings<ResetIdentityAwareProxyClientSecretRequest, IdentityAwareProxyClient>
      resetIdentityAwareProxyClientSecretSettings() {
    return resetIdentityAwareProxyClientSecretSettings;
  }

  /** Returns the object with the settings used for calls to deleteIdentityAwareProxyClient. */
  public UnaryCallSettings<DeleteIdentityAwareProxyClientRequest, Empty>
      deleteIdentityAwareProxyClientSettings() {
    return deleteIdentityAwareProxyClientSettings;
  }

  public IdentityAwareProxyOAuthServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcIdentityAwareProxyOAuthServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonIdentityAwareProxyOAuthServiceStub.create(this);
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
            GaxProperties.getLibraryVersion(IdentityAwareProxyOAuthServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic",
            GaxProperties.getLibraryVersion(IdentityAwareProxyOAuthServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return IdentityAwareProxyOAuthServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected IdentityAwareProxyOAuthServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listBrandsSettings = settingsBuilder.listBrandsSettings().build();
    createBrandSettings = settingsBuilder.createBrandSettings().build();
    getBrandSettings = settingsBuilder.getBrandSettings().build();
    createIdentityAwareProxyClientSettings =
        settingsBuilder.createIdentityAwareProxyClientSettings().build();
    listIdentityAwareProxyClientsSettings =
        settingsBuilder.listIdentityAwareProxyClientsSettings().build();
    getIdentityAwareProxyClientSettings =
        settingsBuilder.getIdentityAwareProxyClientSettings().build();
    resetIdentityAwareProxyClientSecretSettings =
        settingsBuilder.resetIdentityAwareProxyClientSecretSettings().build();
    deleteIdentityAwareProxyClientSettings =
        settingsBuilder.deleteIdentityAwareProxyClientSettings().build();
  }

  /** Builder for IdentityAwareProxyOAuthServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<IdentityAwareProxyOAuthServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<ListBrandsRequest, ListBrandsResponse>
        listBrandsSettings;
    private final UnaryCallSettings.Builder<CreateBrandRequest, Brand> createBrandSettings;
    private final UnaryCallSettings.Builder<GetBrandRequest, Brand> getBrandSettings;
    private final UnaryCallSettings.Builder<
            CreateIdentityAwareProxyClientRequest, IdentityAwareProxyClient>
        createIdentityAwareProxyClientSettings;
    private final PagedCallSettings.Builder<
            ListIdentityAwareProxyClientsRequest,
            ListIdentityAwareProxyClientsResponse,
            ListIdentityAwareProxyClientsPagedResponse>
        listIdentityAwareProxyClientsSettings;
    private final UnaryCallSettings.Builder<
            GetIdentityAwareProxyClientRequest, IdentityAwareProxyClient>
        getIdentityAwareProxyClientSettings;
    private final UnaryCallSettings.Builder<
            ResetIdentityAwareProxyClientSecretRequest, IdentityAwareProxyClient>
        resetIdentityAwareProxyClientSecretSettings;
    private final UnaryCallSettings.Builder<DeleteIdentityAwareProxyClientRequest, Empty>
        deleteIdentityAwareProxyClientSettings;
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

      listBrandsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createBrandSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getBrandSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createIdentityAwareProxyClientSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listIdentityAwareProxyClientsSettings =
          PagedCallSettings.newBuilder(LIST_IDENTITY_AWARE_PROXY_CLIENTS_PAGE_STR_FACT);
      getIdentityAwareProxyClientSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      resetIdentityAwareProxyClientSecretSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteIdentityAwareProxyClientSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listBrandsSettings,
              createBrandSettings,
              getBrandSettings,
              createIdentityAwareProxyClientSettings,
              listIdentityAwareProxyClientsSettings,
              getIdentityAwareProxyClientSettings,
              resetIdentityAwareProxyClientSecretSettings,
              deleteIdentityAwareProxyClientSettings);
      initDefaults(this);
    }

    protected Builder(IdentityAwareProxyOAuthServiceStubSettings settings) {
      super(settings);

      listBrandsSettings = settings.listBrandsSettings.toBuilder();
      createBrandSettings = settings.createBrandSettings.toBuilder();
      getBrandSettings = settings.getBrandSettings.toBuilder();
      createIdentityAwareProxyClientSettings =
          settings.createIdentityAwareProxyClientSettings.toBuilder();
      listIdentityAwareProxyClientsSettings =
          settings.listIdentityAwareProxyClientsSettings.toBuilder();
      getIdentityAwareProxyClientSettings =
          settings.getIdentityAwareProxyClientSettings.toBuilder();
      resetIdentityAwareProxyClientSecretSettings =
          settings.resetIdentityAwareProxyClientSecretSettings.toBuilder();
      deleteIdentityAwareProxyClientSettings =
          settings.deleteIdentityAwareProxyClientSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listBrandsSettings,
              createBrandSettings,
              getBrandSettings,
              createIdentityAwareProxyClientSettings,
              listIdentityAwareProxyClientsSettings,
              getIdentityAwareProxyClientSettings,
              resetIdentityAwareProxyClientSecretSettings,
              deleteIdentityAwareProxyClientSettings);
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
          .listBrandsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createBrandSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getBrandSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createIdentityAwareProxyClientSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listIdentityAwareProxyClientsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getIdentityAwareProxyClientSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .resetIdentityAwareProxyClientSecretSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteIdentityAwareProxyClientSettings()
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

    /** Returns the builder for the settings used for calls to listBrands. */
    public UnaryCallSettings.Builder<ListBrandsRequest, ListBrandsResponse> listBrandsSettings() {
      return listBrandsSettings;
    }

    /** Returns the builder for the settings used for calls to createBrand. */
    public UnaryCallSettings.Builder<CreateBrandRequest, Brand> createBrandSettings() {
      return createBrandSettings;
    }

    /** Returns the builder for the settings used for calls to getBrand. */
    public UnaryCallSettings.Builder<GetBrandRequest, Brand> getBrandSettings() {
      return getBrandSettings;
    }

    /** Returns the builder for the settings used for calls to createIdentityAwareProxyClient. */
    public UnaryCallSettings.Builder<
            CreateIdentityAwareProxyClientRequest, IdentityAwareProxyClient>
        createIdentityAwareProxyClientSettings() {
      return createIdentityAwareProxyClientSettings;
    }

    /** Returns the builder for the settings used for calls to listIdentityAwareProxyClients. */
    public PagedCallSettings.Builder<
            ListIdentityAwareProxyClientsRequest,
            ListIdentityAwareProxyClientsResponse,
            ListIdentityAwareProxyClientsPagedResponse>
        listIdentityAwareProxyClientsSettings() {
      return listIdentityAwareProxyClientsSettings;
    }

    /** Returns the builder for the settings used for calls to getIdentityAwareProxyClient. */
    public UnaryCallSettings.Builder<GetIdentityAwareProxyClientRequest, IdentityAwareProxyClient>
        getIdentityAwareProxyClientSettings() {
      return getIdentityAwareProxyClientSettings;
    }

    /**
     * Returns the builder for the settings used for calls to resetIdentityAwareProxyClientSecret.
     */
    public UnaryCallSettings.Builder<
            ResetIdentityAwareProxyClientSecretRequest, IdentityAwareProxyClient>
        resetIdentityAwareProxyClientSecretSettings() {
      return resetIdentityAwareProxyClientSecretSettings;
    }

    /** Returns the builder for the settings used for calls to deleteIdentityAwareProxyClient. */
    public UnaryCallSettings.Builder<DeleteIdentityAwareProxyClientRequest, Empty>
        deleteIdentityAwareProxyClientSettings() {
      return deleteIdentityAwareProxyClientSettings;
    }

    @Override
    public IdentityAwareProxyOAuthServiceStubSettings build() throws IOException {
      return new IdentityAwareProxyOAuthServiceStubSettings(this);
    }
  }
}
