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

package com.google.cloud.chronicle.v1.stub;

import static com.google.cloud.chronicle.v1.EntityServiceClient.ListWatchlistsPagedResponse;

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
import com.google.cloud.chronicle.v1.CreateWatchlistRequest;
import com.google.cloud.chronicle.v1.DeleteWatchlistRequest;
import com.google.cloud.chronicle.v1.GetWatchlistRequest;
import com.google.cloud.chronicle.v1.ListWatchlistsRequest;
import com.google.cloud.chronicle.v1.ListWatchlistsResponse;
import com.google.cloud.chronicle.v1.UpdateWatchlistRequest;
import com.google.cloud.chronicle.v1.Watchlist;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link EntityServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (chronicle.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getWatchlist:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * EntityServiceStubSettings.Builder entityServiceSettingsBuilder =
 *     EntityServiceStubSettings.newBuilder();
 * entityServiceSettingsBuilder
 *     .getWatchlistSettings()
 *     .setRetrySettings(
 *         entityServiceSettingsBuilder
 *             .getWatchlistSettings()
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
 * EntityServiceStubSettings entityServiceSettings = entityServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 */
@Generated("by gapic-generator-java")
public class EntityServiceStubSettings extends StubSettings<EntityServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<GetWatchlistRequest, Watchlist> getWatchlistSettings;
  private final PagedCallSettings<
          ListWatchlistsRequest, ListWatchlistsResponse, ListWatchlistsPagedResponse>
      listWatchlistsSettings;
  private final UnaryCallSettings<CreateWatchlistRequest, Watchlist> createWatchlistSettings;
  private final UnaryCallSettings<UpdateWatchlistRequest, Watchlist> updateWatchlistSettings;
  private final UnaryCallSettings<DeleteWatchlistRequest, Empty> deleteWatchlistSettings;

  private static final PagedListDescriptor<ListWatchlistsRequest, ListWatchlistsResponse, Watchlist>
      LIST_WATCHLISTS_PAGE_STR_DESC =
          new PagedListDescriptor<ListWatchlistsRequest, ListWatchlistsResponse, Watchlist>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListWatchlistsRequest injectToken(ListWatchlistsRequest payload, String token) {
              return ListWatchlistsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListWatchlistsRequest injectPageSize(
                ListWatchlistsRequest payload, int pageSize) {
              return ListWatchlistsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListWatchlistsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListWatchlistsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Watchlist> extractResources(ListWatchlistsResponse payload) {
              return payload.getWatchlistsList();
            }
          };

  private static final PagedListResponseFactory<
          ListWatchlistsRequest, ListWatchlistsResponse, ListWatchlistsPagedResponse>
      LIST_WATCHLISTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListWatchlistsRequest, ListWatchlistsResponse, ListWatchlistsPagedResponse>() {
            @Override
            public ApiFuture<ListWatchlistsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListWatchlistsRequest, ListWatchlistsResponse> callable,
                ListWatchlistsRequest request,
                ApiCallContext context,
                ApiFuture<ListWatchlistsResponse> futureResponse) {
              PageContext<ListWatchlistsRequest, ListWatchlistsResponse, Watchlist> pageContext =
                  PageContext.create(callable, LIST_WATCHLISTS_PAGE_STR_DESC, request, context);
              return ListWatchlistsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getWatchlist. */
  public UnaryCallSettings<GetWatchlistRequest, Watchlist> getWatchlistSettings() {
    return getWatchlistSettings;
  }

  /** Returns the object with the settings used for calls to listWatchlists. */
  public PagedCallSettings<
          ListWatchlistsRequest, ListWatchlistsResponse, ListWatchlistsPagedResponse>
      listWatchlistsSettings() {
    return listWatchlistsSettings;
  }

  /** Returns the object with the settings used for calls to createWatchlist. */
  public UnaryCallSettings<CreateWatchlistRequest, Watchlist> createWatchlistSettings() {
    return createWatchlistSettings;
  }

  /** Returns the object with the settings used for calls to updateWatchlist. */
  public UnaryCallSettings<UpdateWatchlistRequest, Watchlist> updateWatchlistSettings() {
    return updateWatchlistSettings;
  }

  /** Returns the object with the settings used for calls to deleteWatchlist. */
  public UnaryCallSettings<DeleteWatchlistRequest, Empty> deleteWatchlistSettings() {
    return deleteWatchlistSettings;
  }

  public EntityServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcEntityServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonEntityServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "chronicle";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "chronicle.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "chronicle.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(EntityServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(EntityServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return EntityServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected EntityServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getWatchlistSettings = settingsBuilder.getWatchlistSettings().build();
    listWatchlistsSettings = settingsBuilder.listWatchlistsSettings().build();
    createWatchlistSettings = settingsBuilder.createWatchlistSettings().build();
    updateWatchlistSettings = settingsBuilder.updateWatchlistSettings().build();
    deleteWatchlistSettings = settingsBuilder.deleteWatchlistSettings().build();
  }

  /** Builder for EntityServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<EntityServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetWatchlistRequest, Watchlist> getWatchlistSettings;
    private final PagedCallSettings.Builder<
            ListWatchlistsRequest, ListWatchlistsResponse, ListWatchlistsPagedResponse>
        listWatchlistsSettings;
    private final UnaryCallSettings.Builder<CreateWatchlistRequest, Watchlist>
        createWatchlistSettings;
    private final UnaryCallSettings.Builder<UpdateWatchlistRequest, Watchlist>
        updateWatchlistSettings;
    private final UnaryCallSettings.Builder<DeleteWatchlistRequest, Empty> deleteWatchlistSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_1_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "no_retry_5_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(90000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(90000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(90000L))
              .setTotalTimeoutDuration(Duration.ofMillis(90000L))
              .build();
      definitions.put("retry_policy_1_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeoutDuration(Duration.ofMillis(90000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(90000L))
              .setTotalTimeoutDuration(Duration.ofMillis(90000L))
              .build();
      definitions.put("no_retry_5_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      getWatchlistSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listWatchlistsSettings = PagedCallSettings.newBuilder(LIST_WATCHLISTS_PAGE_STR_FACT);
      createWatchlistSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateWatchlistSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteWatchlistSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getWatchlistSettings,
              listWatchlistsSettings,
              createWatchlistSettings,
              updateWatchlistSettings,
              deleteWatchlistSettings);
      initDefaults(this);
    }

    protected Builder(EntityServiceStubSettings settings) {
      super(settings);

      getWatchlistSettings = settings.getWatchlistSettings.toBuilder();
      listWatchlistsSettings = settings.listWatchlistsSettings.toBuilder();
      createWatchlistSettings = settings.createWatchlistSettings.toBuilder();
      updateWatchlistSettings = settings.updateWatchlistSettings.toBuilder();
      deleteWatchlistSettings = settings.deleteWatchlistSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getWatchlistSettings,
              listWatchlistsSettings,
              createWatchlistSettings,
              updateWatchlistSettings,
              deleteWatchlistSettings);
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
          .getWatchlistSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .listWatchlistsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .createWatchlistSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_5_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_5_params"));

      builder
          .updateWatchlistSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_5_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_5_params"));

      builder
          .deleteWatchlistSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_5_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_5_params"));

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

    /** Returns the builder for the settings used for calls to getWatchlist. */
    public UnaryCallSettings.Builder<GetWatchlistRequest, Watchlist> getWatchlistSettings() {
      return getWatchlistSettings;
    }

    /** Returns the builder for the settings used for calls to listWatchlists. */
    public PagedCallSettings.Builder<
            ListWatchlistsRequest, ListWatchlistsResponse, ListWatchlistsPagedResponse>
        listWatchlistsSettings() {
      return listWatchlistsSettings;
    }

    /** Returns the builder for the settings used for calls to createWatchlist. */
    public UnaryCallSettings.Builder<CreateWatchlistRequest, Watchlist> createWatchlistSettings() {
      return createWatchlistSettings;
    }

    /** Returns the builder for the settings used for calls to updateWatchlist. */
    public UnaryCallSettings.Builder<UpdateWatchlistRequest, Watchlist> updateWatchlistSettings() {
      return updateWatchlistSettings;
    }

    /** Returns the builder for the settings used for calls to deleteWatchlist. */
    public UnaryCallSettings.Builder<DeleteWatchlistRequest, Empty> deleteWatchlistSettings() {
      return deleteWatchlistSettings;
    }

    @Override
    public EntityServiceStubSettings build() throws IOException {
      return new EntityServiceStubSettings(this);
    }
  }
}
