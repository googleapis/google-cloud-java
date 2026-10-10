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

package com.google.ads.admanager.v1.stub;

import static com.google.ads.admanager.v1.CreativeWrapperServiceClient.ListCreativeWrappersPagedResponse;

import com.google.ads.admanager.v1.BatchActivateCreativeWrappersRequest;
import com.google.ads.admanager.v1.BatchActivateCreativeWrappersResponse;
import com.google.ads.admanager.v1.BatchCreateCreativeWrappersRequest;
import com.google.ads.admanager.v1.BatchCreateCreativeWrappersResponse;
import com.google.ads.admanager.v1.BatchDeactivateCreativeWrappersRequest;
import com.google.ads.admanager.v1.BatchDeactivateCreativeWrappersResponse;
import com.google.ads.admanager.v1.BatchUpdateCreativeWrappersRequest;
import com.google.ads.admanager.v1.BatchUpdateCreativeWrappersResponse;
import com.google.ads.admanager.v1.CreateCreativeWrapperRequest;
import com.google.ads.admanager.v1.CreativeWrapper;
import com.google.ads.admanager.v1.GetCreativeWrapperRequest;
import com.google.ads.admanager.v1.ListCreativeWrappersRequest;
import com.google.ads.admanager.v1.ListCreativeWrappersResponse;
import com.google.ads.admanager.v1.UpdateCreativeWrapperRequest;
import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ObsoleteApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.LibraryMetadata;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link CreativeWrapperServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (admanager.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getCreativeWrapper:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CreativeWrapperServiceStubSettings.Builder creativeWrapperServiceSettingsBuilder =
 *     CreativeWrapperServiceStubSettings.newBuilder();
 * creativeWrapperServiceSettingsBuilder
 *     .getCreativeWrapperSettings()
 *     .setRetrySettings(
 *         creativeWrapperServiceSettingsBuilder
 *             .getCreativeWrapperSettings()
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
 * CreativeWrapperServiceStubSettings creativeWrapperServiceSettings =
 *     creativeWrapperServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@NullMarked
@Generated("by gapic-generator-java")
@SuppressWarnings("CanonicalDuration")
public class CreativeWrapperServiceStubSettings
    extends StubSettings<CreativeWrapperServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/admanager")
          .add("https://www.googleapis.com/auth/admanager.readonly")
          .build();

  private final UnaryCallSettings<GetCreativeWrapperRequest, CreativeWrapper>
      getCreativeWrapperSettings;
  private final PagedCallSettings<
          ListCreativeWrappersRequest,
          ListCreativeWrappersResponse,
          ListCreativeWrappersPagedResponse>
      listCreativeWrappersSettings;
  private final UnaryCallSettings<CreateCreativeWrapperRequest, CreativeWrapper>
      createCreativeWrapperSettings;
  private final UnaryCallSettings<
          BatchCreateCreativeWrappersRequest, BatchCreateCreativeWrappersResponse>
      batchCreateCreativeWrappersSettings;
  private final UnaryCallSettings<UpdateCreativeWrapperRequest, CreativeWrapper>
      updateCreativeWrapperSettings;
  private final UnaryCallSettings<
          BatchUpdateCreativeWrappersRequest, BatchUpdateCreativeWrappersResponse>
      batchUpdateCreativeWrappersSettings;
  private final UnaryCallSettings<
          BatchActivateCreativeWrappersRequest, BatchActivateCreativeWrappersResponse>
      batchActivateCreativeWrappersSettings;
  private final UnaryCallSettings<
          BatchDeactivateCreativeWrappersRequest, BatchDeactivateCreativeWrappersResponse>
      batchDeactivateCreativeWrappersSettings;

  private static final PagedListDescriptor<
          ListCreativeWrappersRequest, ListCreativeWrappersResponse, CreativeWrapper>
      LIST_CREATIVE_WRAPPERS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListCreativeWrappersRequest, ListCreativeWrappersResponse, CreativeWrapper>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListCreativeWrappersRequest injectToken(
                ListCreativeWrappersRequest payload, String token) {
              return ListCreativeWrappersRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListCreativeWrappersRequest injectPageSize(
                ListCreativeWrappersRequest payload, int pageSize) {
              return ListCreativeWrappersRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListCreativeWrappersRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListCreativeWrappersResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<CreativeWrapper> extractResources(
                ListCreativeWrappersResponse payload) {
              return payload.getCreativeWrappersList();
            }
          };

  private static final PagedListResponseFactory<
          ListCreativeWrappersRequest,
          ListCreativeWrappersResponse,
          ListCreativeWrappersPagedResponse>
      LIST_CREATIVE_WRAPPERS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListCreativeWrappersRequest,
              ListCreativeWrappersResponse,
              ListCreativeWrappersPagedResponse>() {
            @Override
            public ApiFuture<ListCreativeWrappersPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListCreativeWrappersRequest, ListCreativeWrappersResponse> callable,
                ListCreativeWrappersRequest request,
                ApiCallContext context,
                ApiFuture<ListCreativeWrappersResponse> futureResponse) {
              PageContext<
                      ListCreativeWrappersRequest, ListCreativeWrappersResponse, CreativeWrapper>
                  pageContext =
                      PageContext.create(
                          callable, LIST_CREATIVE_WRAPPERS_PAGE_STR_DESC, request, context);
              return ListCreativeWrappersPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getCreativeWrapper. */
  public UnaryCallSettings<GetCreativeWrapperRequest, CreativeWrapper>
      getCreativeWrapperSettings() {
    return getCreativeWrapperSettings;
  }

  /** Returns the object with the settings used for calls to listCreativeWrappers. */
  public PagedCallSettings<
          ListCreativeWrappersRequest,
          ListCreativeWrappersResponse,
          ListCreativeWrappersPagedResponse>
      listCreativeWrappersSettings() {
    return listCreativeWrappersSettings;
  }

  /** Returns the object with the settings used for calls to createCreativeWrapper. */
  public UnaryCallSettings<CreateCreativeWrapperRequest, CreativeWrapper>
      createCreativeWrapperSettings() {
    return createCreativeWrapperSettings;
  }

  /** Returns the object with the settings used for calls to batchCreateCreativeWrappers. */
  public UnaryCallSettings<BatchCreateCreativeWrappersRequest, BatchCreateCreativeWrappersResponse>
      batchCreateCreativeWrappersSettings() {
    return batchCreateCreativeWrappersSettings;
  }

  /** Returns the object with the settings used for calls to updateCreativeWrapper. */
  public UnaryCallSettings<UpdateCreativeWrapperRequest, CreativeWrapper>
      updateCreativeWrapperSettings() {
    return updateCreativeWrapperSettings;
  }

  /** Returns the object with the settings used for calls to batchUpdateCreativeWrappers. */
  public UnaryCallSettings<BatchUpdateCreativeWrappersRequest, BatchUpdateCreativeWrappersResponse>
      batchUpdateCreativeWrappersSettings() {
    return batchUpdateCreativeWrappersSettings;
  }

  /** Returns the object with the settings used for calls to batchActivateCreativeWrappers. */
  public UnaryCallSettings<
          BatchActivateCreativeWrappersRequest, BatchActivateCreativeWrappersResponse>
      batchActivateCreativeWrappersSettings() {
    return batchActivateCreativeWrappersSettings;
  }

  /** Returns the object with the settings used for calls to batchDeactivateCreativeWrappers. */
  public UnaryCallSettings<
          BatchDeactivateCreativeWrappersRequest, BatchDeactivateCreativeWrappersResponse>
      batchDeactivateCreativeWrappersSettings() {
    return batchDeactivateCreativeWrappersSettings;
  }

  public CreativeWrapperServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonCreativeWrapperServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "admanager";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "admanager.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "admanager.mtls.googleapis.com:443";
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
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultHttpJsonTransportProviderBuilder().build();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(CreativeWrapperServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(@Nullable ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected CreativeWrapperServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getCreativeWrapperSettings = settingsBuilder.getCreativeWrapperSettings().build();
    listCreativeWrappersSettings = settingsBuilder.listCreativeWrappersSettings().build();
    createCreativeWrapperSettings = settingsBuilder.createCreativeWrapperSettings().build();
    batchCreateCreativeWrappersSettings =
        settingsBuilder.batchCreateCreativeWrappersSettings().build();
    updateCreativeWrapperSettings = settingsBuilder.updateCreativeWrapperSettings().build();
    batchUpdateCreativeWrappersSettings =
        settingsBuilder.batchUpdateCreativeWrappersSettings().build();
    batchActivateCreativeWrappersSettings =
        settingsBuilder.batchActivateCreativeWrappersSettings().build();
    batchDeactivateCreativeWrappersSettings =
        settingsBuilder.batchDeactivateCreativeWrappersSettings().build();
  }

  @Override
  protected LibraryMetadata getLibraryMetadata() {
    return LibraryMetadata.newBuilder()
        .setArtifactName("com.google.api-ads:ad-manager")
        .setRepository("googleapis/google-cloud-java")
        .setVersion(Version.VERSION)
        .build();
  }

  /** Builder for CreativeWrapperServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<CreativeWrapperServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetCreativeWrapperRequest, CreativeWrapper>
        getCreativeWrapperSettings;
    private final PagedCallSettings.Builder<
            ListCreativeWrappersRequest,
            ListCreativeWrappersResponse,
            ListCreativeWrappersPagedResponse>
        listCreativeWrappersSettings;
    private final UnaryCallSettings.Builder<CreateCreativeWrapperRequest, CreativeWrapper>
        createCreativeWrapperSettings;
    private final UnaryCallSettings.Builder<
            BatchCreateCreativeWrappersRequest, BatchCreateCreativeWrappersResponse>
        batchCreateCreativeWrappersSettings;
    private final UnaryCallSettings.Builder<UpdateCreativeWrapperRequest, CreativeWrapper>
        updateCreativeWrapperSettings;
    private final UnaryCallSettings.Builder<
            BatchUpdateCreativeWrappersRequest, BatchUpdateCreativeWrappersResponse>
        batchUpdateCreativeWrappersSettings;
    private final UnaryCallSettings.Builder<
            BatchActivateCreativeWrappersRequest, BatchActivateCreativeWrappersResponse>
        batchActivateCreativeWrappersSettings;
    private final UnaryCallSettings.Builder<
            BatchDeactivateCreativeWrappersRequest, BatchDeactivateCreativeWrappersResponse>
        batchDeactivateCreativeWrappersSettings;
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

    protected Builder(@Nullable ClientContext clientContext) {
      super(clientContext);

      getCreativeWrapperSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listCreativeWrappersSettings =
          PagedCallSettings.newBuilder(LIST_CREATIVE_WRAPPERS_PAGE_STR_FACT);
      createCreativeWrapperSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchCreateCreativeWrappersSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateCreativeWrapperSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchUpdateCreativeWrappersSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchActivateCreativeWrappersSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchDeactivateCreativeWrappersSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getCreativeWrapperSettings,
              listCreativeWrappersSettings,
              createCreativeWrapperSettings,
              batchCreateCreativeWrappersSettings,
              updateCreativeWrapperSettings,
              batchUpdateCreativeWrappersSettings,
              batchActivateCreativeWrappersSettings,
              batchDeactivateCreativeWrappersSettings);
      initDefaults(this);
    }

    protected Builder(CreativeWrapperServiceStubSettings settings) {
      super(settings);

      getCreativeWrapperSettings = settings.getCreativeWrapperSettings.toBuilder();
      listCreativeWrappersSettings = settings.listCreativeWrappersSettings.toBuilder();
      createCreativeWrapperSettings = settings.createCreativeWrapperSettings.toBuilder();
      batchCreateCreativeWrappersSettings =
          settings.batchCreateCreativeWrappersSettings.toBuilder();
      updateCreativeWrapperSettings = settings.updateCreativeWrapperSettings.toBuilder();
      batchUpdateCreativeWrappersSettings =
          settings.batchUpdateCreativeWrappersSettings.toBuilder();
      batchActivateCreativeWrappersSettings =
          settings.batchActivateCreativeWrappersSettings.toBuilder();
      batchDeactivateCreativeWrappersSettings =
          settings.batchDeactivateCreativeWrappersSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getCreativeWrapperSettings,
              listCreativeWrappersSettings,
              createCreativeWrapperSettings,
              batchCreateCreativeWrappersSettings,
              updateCreativeWrapperSettings,
              batchUpdateCreativeWrappersSettings,
              batchActivateCreativeWrappersSettings,
              batchDeactivateCreativeWrappersSettings);
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
          .getCreativeWrapperSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listCreativeWrappersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createCreativeWrapperSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchCreateCreativeWrappersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateCreativeWrapperSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchUpdateCreativeWrappersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchActivateCreativeWrappersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchDeactivateCreativeWrappersSettings()
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

    /** Returns the builder for the settings used for calls to getCreativeWrapper. */
    public UnaryCallSettings.Builder<GetCreativeWrapperRequest, CreativeWrapper>
        getCreativeWrapperSettings() {
      return getCreativeWrapperSettings;
    }

    /** Returns the builder for the settings used for calls to listCreativeWrappers. */
    public PagedCallSettings.Builder<
            ListCreativeWrappersRequest,
            ListCreativeWrappersResponse,
            ListCreativeWrappersPagedResponse>
        listCreativeWrappersSettings() {
      return listCreativeWrappersSettings;
    }

    /** Returns the builder for the settings used for calls to createCreativeWrapper. */
    public UnaryCallSettings.Builder<CreateCreativeWrapperRequest, CreativeWrapper>
        createCreativeWrapperSettings() {
      return createCreativeWrapperSettings;
    }

    /** Returns the builder for the settings used for calls to batchCreateCreativeWrappers. */
    public UnaryCallSettings.Builder<
            BatchCreateCreativeWrappersRequest, BatchCreateCreativeWrappersResponse>
        batchCreateCreativeWrappersSettings() {
      return batchCreateCreativeWrappersSettings;
    }

    /** Returns the builder for the settings used for calls to updateCreativeWrapper. */
    public UnaryCallSettings.Builder<UpdateCreativeWrapperRequest, CreativeWrapper>
        updateCreativeWrapperSettings() {
      return updateCreativeWrapperSettings;
    }

    /** Returns the builder for the settings used for calls to batchUpdateCreativeWrappers. */
    public UnaryCallSettings.Builder<
            BatchUpdateCreativeWrappersRequest, BatchUpdateCreativeWrappersResponse>
        batchUpdateCreativeWrappersSettings() {
      return batchUpdateCreativeWrappersSettings;
    }

    /** Returns the builder for the settings used for calls to batchActivateCreativeWrappers. */
    public UnaryCallSettings.Builder<
            BatchActivateCreativeWrappersRequest, BatchActivateCreativeWrappersResponse>
        batchActivateCreativeWrappersSettings() {
      return batchActivateCreativeWrappersSettings;
    }

    /** Returns the builder for the settings used for calls to batchDeactivateCreativeWrappers. */
    public UnaryCallSettings.Builder<
            BatchDeactivateCreativeWrappersRequest, BatchDeactivateCreativeWrappersResponse>
        batchDeactivateCreativeWrappersSettings() {
      return batchDeactivateCreativeWrappersSettings;
    }

    @Override
    public CreativeWrapperServiceStubSettings build() throws IOException {
      return new CreativeWrapperServiceStubSettings(this);
    }
  }
}
