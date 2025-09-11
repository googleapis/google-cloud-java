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

package com.google.cloud.biglake.v1.stub;

import static com.google.cloud.biglake.v1.IcebergCatalogServiceClient.ListIcebergCatalogsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.core.ObsoleteApi;
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
import com.google.cloud.biglake.v1.CreateIcebergCatalogRequest;
import com.google.cloud.biglake.v1.FailoverIcebergCatalogRequest;
import com.google.cloud.biglake.v1.FailoverIcebergCatalogResponse;
import com.google.cloud.biglake.v1.GetIcebergCatalogRequest;
import com.google.cloud.biglake.v1.IcebergCatalog;
import com.google.cloud.biglake.v1.ListIcebergCatalogsRequest;
import com.google.cloud.biglake.v1.ListIcebergCatalogsResponse;
import com.google.cloud.biglake.v1.UpdateIcebergCatalogRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link IcebergCatalogServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (biglake.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getIcebergCatalog:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * IcebergCatalogServiceStubSettings.Builder icebergCatalogServiceSettingsBuilder =
 *     IcebergCatalogServiceStubSettings.newBuilder();
 * icebergCatalogServiceSettingsBuilder
 *     .getIcebergCatalogSettings()
 *     .setRetrySettings(
 *         icebergCatalogServiceSettingsBuilder
 *             .getIcebergCatalogSettings()
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
 * IcebergCatalogServiceStubSettings icebergCatalogServiceSettings =
 *     icebergCatalogServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 */
@Generated("by gapic-generator-java")
public class IcebergCatalogServiceStubSettings
    extends StubSettings<IcebergCatalogServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/bigquery")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .build();

  private final UnaryCallSettings<GetIcebergCatalogRequest, IcebergCatalog>
      getIcebergCatalogSettings;
  private final PagedCallSettings<
          ListIcebergCatalogsRequest, ListIcebergCatalogsResponse, ListIcebergCatalogsPagedResponse>
      listIcebergCatalogsSettings;
  private final UnaryCallSettings<UpdateIcebergCatalogRequest, IcebergCatalog>
      updateIcebergCatalogSettings;
  private final UnaryCallSettings<CreateIcebergCatalogRequest, IcebergCatalog>
      createIcebergCatalogSettings;
  private final UnaryCallSettings<FailoverIcebergCatalogRequest, FailoverIcebergCatalogResponse>
      failoverIcebergCatalogSettings;

  private static final PagedListDescriptor<
          ListIcebergCatalogsRequest, ListIcebergCatalogsResponse, IcebergCatalog>
      LIST_ICEBERG_CATALOGS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListIcebergCatalogsRequest, ListIcebergCatalogsResponse, IcebergCatalog>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListIcebergCatalogsRequest injectToken(
                ListIcebergCatalogsRequest payload, String token) {
              return ListIcebergCatalogsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListIcebergCatalogsRequest injectPageSize(
                ListIcebergCatalogsRequest payload, int pageSize) {
              return ListIcebergCatalogsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListIcebergCatalogsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListIcebergCatalogsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<IcebergCatalog> extractResources(ListIcebergCatalogsResponse payload) {
              return payload.getIcebergCatalogsList();
            }
          };

  private static final PagedListResponseFactory<
          ListIcebergCatalogsRequest, ListIcebergCatalogsResponse, ListIcebergCatalogsPagedResponse>
      LIST_ICEBERG_CATALOGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListIcebergCatalogsRequest,
              ListIcebergCatalogsResponse,
              ListIcebergCatalogsPagedResponse>() {
            @Override
            public ApiFuture<ListIcebergCatalogsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListIcebergCatalogsRequest, ListIcebergCatalogsResponse> callable,
                ListIcebergCatalogsRequest request,
                ApiCallContext context,
                ApiFuture<ListIcebergCatalogsResponse> futureResponse) {
              PageContext<ListIcebergCatalogsRequest, ListIcebergCatalogsResponse, IcebergCatalog>
                  pageContext =
                      PageContext.create(
                          callable, LIST_ICEBERG_CATALOGS_PAGE_STR_DESC, request, context);
              return ListIcebergCatalogsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getIcebergCatalog. */
  public UnaryCallSettings<GetIcebergCatalogRequest, IcebergCatalog> getIcebergCatalogSettings() {
    return getIcebergCatalogSettings;
  }

  /** Returns the object with the settings used for calls to listIcebergCatalogs. */
  public PagedCallSettings<
          ListIcebergCatalogsRequest, ListIcebergCatalogsResponse, ListIcebergCatalogsPagedResponse>
      listIcebergCatalogsSettings() {
    return listIcebergCatalogsSettings;
  }

  /** Returns the object with the settings used for calls to updateIcebergCatalog. */
  public UnaryCallSettings<UpdateIcebergCatalogRequest, IcebergCatalog>
      updateIcebergCatalogSettings() {
    return updateIcebergCatalogSettings;
  }

  /** Returns the object with the settings used for calls to createIcebergCatalog. */
  public UnaryCallSettings<CreateIcebergCatalogRequest, IcebergCatalog>
      createIcebergCatalogSettings() {
    return createIcebergCatalogSettings;
  }

  /** Returns the object with the settings used for calls to failoverIcebergCatalog. */
  public UnaryCallSettings<FailoverIcebergCatalogRequest, FailoverIcebergCatalogResponse>
      failoverIcebergCatalogSettings() {
    return failoverIcebergCatalogSettings;
  }

  public IcebergCatalogServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcIcebergCatalogServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonIcebergCatalogServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "biglake";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "biglake.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "biglake.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(IcebergCatalogServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(IcebergCatalogServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return IcebergCatalogServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected IcebergCatalogServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getIcebergCatalogSettings = settingsBuilder.getIcebergCatalogSettings().build();
    listIcebergCatalogsSettings = settingsBuilder.listIcebergCatalogsSettings().build();
    updateIcebergCatalogSettings = settingsBuilder.updateIcebergCatalogSettings().build();
    createIcebergCatalogSettings = settingsBuilder.createIcebergCatalogSettings().build();
    failoverIcebergCatalogSettings = settingsBuilder.failoverIcebergCatalogSettings().build();
  }

  /** Builder for IcebergCatalogServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<IcebergCatalogServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetIcebergCatalogRequest, IcebergCatalog>
        getIcebergCatalogSettings;
    private final PagedCallSettings.Builder<
            ListIcebergCatalogsRequest,
            ListIcebergCatalogsResponse,
            ListIcebergCatalogsPagedResponse>
        listIcebergCatalogsSettings;
    private final UnaryCallSettings.Builder<UpdateIcebergCatalogRequest, IcebergCatalog>
        updateIcebergCatalogSettings;
    private final UnaryCallSettings.Builder<CreateIcebergCatalogRequest, IcebergCatalog>
        createIcebergCatalogSettings;
    private final UnaryCallSettings.Builder<
            FailoverIcebergCatalogRequest, FailoverIcebergCatalogResponse>
        failoverIcebergCatalogSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      getIcebergCatalogSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listIcebergCatalogsSettings =
          PagedCallSettings.newBuilder(LIST_ICEBERG_CATALOGS_PAGE_STR_FACT);
      updateIcebergCatalogSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createIcebergCatalogSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      failoverIcebergCatalogSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getIcebergCatalogSettings,
              listIcebergCatalogsSettings,
              updateIcebergCatalogSettings,
              createIcebergCatalogSettings,
              failoverIcebergCatalogSettings);
      initDefaults(this);
    }

    protected Builder(IcebergCatalogServiceStubSettings settings) {
      super(settings);

      getIcebergCatalogSettings = settings.getIcebergCatalogSettings.toBuilder();
      listIcebergCatalogsSettings = settings.listIcebergCatalogsSettings.toBuilder();
      updateIcebergCatalogSettings = settings.updateIcebergCatalogSettings.toBuilder();
      createIcebergCatalogSettings = settings.createIcebergCatalogSettings.toBuilder();
      failoverIcebergCatalogSettings = settings.failoverIcebergCatalogSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getIcebergCatalogSettings,
              listIcebergCatalogsSettings,
              updateIcebergCatalogSettings,
              createIcebergCatalogSettings,
              failoverIcebergCatalogSettings);
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
          .getIcebergCatalogSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listIcebergCatalogsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateIcebergCatalogSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createIcebergCatalogSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .failoverIcebergCatalogSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

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

    /** Returns the builder for the settings used for calls to getIcebergCatalog. */
    public UnaryCallSettings.Builder<GetIcebergCatalogRequest, IcebergCatalog>
        getIcebergCatalogSettings() {
      return getIcebergCatalogSettings;
    }

    /** Returns the builder for the settings used for calls to listIcebergCatalogs. */
    public PagedCallSettings.Builder<
            ListIcebergCatalogsRequest,
            ListIcebergCatalogsResponse,
            ListIcebergCatalogsPagedResponse>
        listIcebergCatalogsSettings() {
      return listIcebergCatalogsSettings;
    }

    /** Returns the builder for the settings used for calls to updateIcebergCatalog. */
    public UnaryCallSettings.Builder<UpdateIcebergCatalogRequest, IcebergCatalog>
        updateIcebergCatalogSettings() {
      return updateIcebergCatalogSettings;
    }

    /** Returns the builder for the settings used for calls to createIcebergCatalog. */
    public UnaryCallSettings.Builder<CreateIcebergCatalogRequest, IcebergCatalog>
        createIcebergCatalogSettings() {
      return createIcebergCatalogSettings;
    }

    /** Returns the builder for the settings used for calls to failoverIcebergCatalog. */
    public UnaryCallSettings.Builder<FailoverIcebergCatalogRequest, FailoverIcebergCatalogResponse>
        failoverIcebergCatalogSettings() {
      return failoverIcebergCatalogSettings;
    }

    @Override
    public IcebergCatalogServiceStubSettings build() throws IOException {
      return new IcebergCatalogServiceStubSettings(this);
    }
  }
}
