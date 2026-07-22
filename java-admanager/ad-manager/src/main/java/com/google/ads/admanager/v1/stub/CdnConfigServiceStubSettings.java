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

import static com.google.ads.admanager.v1.CdnConfigServiceClient.ListCdnConfigsPagedResponse;

import com.google.ads.admanager.v1.BatchActivateCdnConfigsRequest;
import com.google.ads.admanager.v1.BatchActivateCdnConfigsResponse;
import com.google.ads.admanager.v1.BatchArchiveCdnConfigsRequest;
import com.google.ads.admanager.v1.BatchArchiveCdnConfigsResponse;
import com.google.ads.admanager.v1.BatchCreateCdnConfigsRequest;
import com.google.ads.admanager.v1.BatchCreateCdnConfigsResponse;
import com.google.ads.admanager.v1.BatchUpdateCdnConfigsRequest;
import com.google.ads.admanager.v1.BatchUpdateCdnConfigsResponse;
import com.google.ads.admanager.v1.CdnConfig;
import com.google.ads.admanager.v1.CreateCdnConfigRequest;
import com.google.ads.admanager.v1.GetCdnConfigRequest;
import com.google.ads.admanager.v1.ListCdnConfigsRequest;
import com.google.ads.admanager.v1.ListCdnConfigsResponse;
import com.google.ads.admanager.v1.UpdateCdnConfigRequest;
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
 * Settings class to configure an instance of {@link CdnConfigServiceStub}.
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
 * of getCdnConfig:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CdnConfigServiceStubSettings.Builder cdnConfigServiceSettingsBuilder =
 *     CdnConfigServiceStubSettings.newBuilder();
 * cdnConfigServiceSettingsBuilder
 *     .getCdnConfigSettings()
 *     .setRetrySettings(
 *         cdnConfigServiceSettingsBuilder
 *             .getCdnConfigSettings()
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
 * CdnConfigServiceStubSettings cdnConfigServiceSettings = cdnConfigServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@NullMarked
@Generated("by gapic-generator-java")
@SuppressWarnings("CanonicalDuration")
public class CdnConfigServiceStubSettings extends StubSettings<CdnConfigServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/admanager")
          .add("https://www.googleapis.com/auth/admanager.readonly")
          .build();

  private final UnaryCallSettings<GetCdnConfigRequest, CdnConfig> getCdnConfigSettings;
  private final PagedCallSettings<
          ListCdnConfigsRequest, ListCdnConfigsResponse, ListCdnConfigsPagedResponse>
      listCdnConfigsSettings;
  private final UnaryCallSettings<CreateCdnConfigRequest, CdnConfig> createCdnConfigSettings;
  private final UnaryCallSettings<BatchCreateCdnConfigsRequest, BatchCreateCdnConfigsResponse>
      batchCreateCdnConfigsSettings;
  private final UnaryCallSettings<UpdateCdnConfigRequest, CdnConfig> updateCdnConfigSettings;
  private final UnaryCallSettings<BatchUpdateCdnConfigsRequest, BatchUpdateCdnConfigsResponse>
      batchUpdateCdnConfigsSettings;
  private final UnaryCallSettings<BatchActivateCdnConfigsRequest, BatchActivateCdnConfigsResponse>
      batchActivateCdnConfigsSettings;
  private final UnaryCallSettings<BatchArchiveCdnConfigsRequest, BatchArchiveCdnConfigsResponse>
      batchArchiveCdnConfigsSettings;

  private static final PagedListDescriptor<ListCdnConfigsRequest, ListCdnConfigsResponse, CdnConfig>
      LIST_CDN_CONFIGS_PAGE_STR_DESC =
          new PagedListDescriptor<ListCdnConfigsRequest, ListCdnConfigsResponse, CdnConfig>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListCdnConfigsRequest injectToken(ListCdnConfigsRequest payload, String token) {
              return ListCdnConfigsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListCdnConfigsRequest injectPageSize(
                ListCdnConfigsRequest payload, int pageSize) {
              return ListCdnConfigsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListCdnConfigsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListCdnConfigsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<CdnConfig> extractResources(ListCdnConfigsResponse payload) {
              return payload.getCdnConfigsList();
            }
          };

  private static final PagedListResponseFactory<
          ListCdnConfigsRequest, ListCdnConfigsResponse, ListCdnConfigsPagedResponse>
      LIST_CDN_CONFIGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListCdnConfigsRequest, ListCdnConfigsResponse, ListCdnConfigsPagedResponse>() {
            @Override
            public ApiFuture<ListCdnConfigsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListCdnConfigsRequest, ListCdnConfigsResponse> callable,
                ListCdnConfigsRequest request,
                ApiCallContext context,
                ApiFuture<ListCdnConfigsResponse> futureResponse) {
              PageContext<ListCdnConfigsRequest, ListCdnConfigsResponse, CdnConfig> pageContext =
                  PageContext.create(callable, LIST_CDN_CONFIGS_PAGE_STR_DESC, request, context);
              return ListCdnConfigsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getCdnConfig. */
  public UnaryCallSettings<GetCdnConfigRequest, CdnConfig> getCdnConfigSettings() {
    return getCdnConfigSettings;
  }

  /** Returns the object with the settings used for calls to listCdnConfigs. */
  public PagedCallSettings<
          ListCdnConfigsRequest, ListCdnConfigsResponse, ListCdnConfigsPagedResponse>
      listCdnConfigsSettings() {
    return listCdnConfigsSettings;
  }

  /** Returns the object with the settings used for calls to createCdnConfig. */
  public UnaryCallSettings<CreateCdnConfigRequest, CdnConfig> createCdnConfigSettings() {
    return createCdnConfigSettings;
  }

  /** Returns the object with the settings used for calls to batchCreateCdnConfigs. */
  public UnaryCallSettings<BatchCreateCdnConfigsRequest, BatchCreateCdnConfigsResponse>
      batchCreateCdnConfigsSettings() {
    return batchCreateCdnConfigsSettings;
  }

  /** Returns the object with the settings used for calls to updateCdnConfig. */
  public UnaryCallSettings<UpdateCdnConfigRequest, CdnConfig> updateCdnConfigSettings() {
    return updateCdnConfigSettings;
  }

  /** Returns the object with the settings used for calls to batchUpdateCdnConfigs. */
  public UnaryCallSettings<BatchUpdateCdnConfigsRequest, BatchUpdateCdnConfigsResponse>
      batchUpdateCdnConfigsSettings() {
    return batchUpdateCdnConfigsSettings;
  }

  /** Returns the object with the settings used for calls to batchActivateCdnConfigs. */
  public UnaryCallSettings<BatchActivateCdnConfigsRequest, BatchActivateCdnConfigsResponse>
      batchActivateCdnConfigsSettings() {
    return batchActivateCdnConfigsSettings;
  }

  /** Returns the object with the settings used for calls to batchArchiveCdnConfigs. */
  public UnaryCallSettings<BatchArchiveCdnConfigsRequest, BatchArchiveCdnConfigsResponse>
      batchArchiveCdnConfigsSettings() {
    return batchArchiveCdnConfigsSettings;
  }

  public CdnConfigServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonCdnConfigServiceStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(CdnConfigServiceStubSettings.class))
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

  protected CdnConfigServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getCdnConfigSettings = settingsBuilder.getCdnConfigSettings().build();
    listCdnConfigsSettings = settingsBuilder.listCdnConfigsSettings().build();
    createCdnConfigSettings = settingsBuilder.createCdnConfigSettings().build();
    batchCreateCdnConfigsSettings = settingsBuilder.batchCreateCdnConfigsSettings().build();
    updateCdnConfigSettings = settingsBuilder.updateCdnConfigSettings().build();
    batchUpdateCdnConfigsSettings = settingsBuilder.batchUpdateCdnConfigsSettings().build();
    batchActivateCdnConfigsSettings = settingsBuilder.batchActivateCdnConfigsSettings().build();
    batchArchiveCdnConfigsSettings = settingsBuilder.batchArchiveCdnConfigsSettings().build();
  }

  @Override
  protected LibraryMetadata getLibraryMetadata() {
    return LibraryMetadata.newBuilder()
        .setArtifactName("com.google.api-ads:ad-manager")
        .setRepository("googleapis/google-cloud-java")
        .setVersion(Version.VERSION)
        .build();
  }

  /** Builder for CdnConfigServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<CdnConfigServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetCdnConfigRequest, CdnConfig> getCdnConfigSettings;
    private final PagedCallSettings.Builder<
            ListCdnConfigsRequest, ListCdnConfigsResponse, ListCdnConfigsPagedResponse>
        listCdnConfigsSettings;
    private final UnaryCallSettings.Builder<CreateCdnConfigRequest, CdnConfig>
        createCdnConfigSettings;
    private final UnaryCallSettings.Builder<
            BatchCreateCdnConfigsRequest, BatchCreateCdnConfigsResponse>
        batchCreateCdnConfigsSettings;
    private final UnaryCallSettings.Builder<UpdateCdnConfigRequest, CdnConfig>
        updateCdnConfigSettings;
    private final UnaryCallSettings.Builder<
            BatchUpdateCdnConfigsRequest, BatchUpdateCdnConfigsResponse>
        batchUpdateCdnConfigsSettings;
    private final UnaryCallSettings.Builder<
            BatchActivateCdnConfigsRequest, BatchActivateCdnConfigsResponse>
        batchActivateCdnConfigsSettings;
    private final UnaryCallSettings.Builder<
            BatchArchiveCdnConfigsRequest, BatchArchiveCdnConfigsResponse>
        batchArchiveCdnConfigsSettings;
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

      getCdnConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listCdnConfigsSettings = PagedCallSettings.newBuilder(LIST_CDN_CONFIGS_PAGE_STR_FACT);
      createCdnConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchCreateCdnConfigsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateCdnConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchUpdateCdnConfigsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchActivateCdnConfigsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchArchiveCdnConfigsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getCdnConfigSettings,
              listCdnConfigsSettings,
              createCdnConfigSettings,
              batchCreateCdnConfigsSettings,
              updateCdnConfigSettings,
              batchUpdateCdnConfigsSettings,
              batchActivateCdnConfigsSettings,
              batchArchiveCdnConfigsSettings);
      initDefaults(this);
    }

    protected Builder(CdnConfigServiceStubSettings settings) {
      super(settings);

      getCdnConfigSettings = settings.getCdnConfigSettings.toBuilder();
      listCdnConfigsSettings = settings.listCdnConfigsSettings.toBuilder();
      createCdnConfigSettings = settings.createCdnConfigSettings.toBuilder();
      batchCreateCdnConfigsSettings = settings.batchCreateCdnConfigsSettings.toBuilder();
      updateCdnConfigSettings = settings.updateCdnConfigSettings.toBuilder();
      batchUpdateCdnConfigsSettings = settings.batchUpdateCdnConfigsSettings.toBuilder();
      batchActivateCdnConfigsSettings = settings.batchActivateCdnConfigsSettings.toBuilder();
      batchArchiveCdnConfigsSettings = settings.batchArchiveCdnConfigsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getCdnConfigSettings,
              listCdnConfigsSettings,
              createCdnConfigSettings,
              batchCreateCdnConfigsSettings,
              updateCdnConfigSettings,
              batchUpdateCdnConfigsSettings,
              batchActivateCdnConfigsSettings,
              batchArchiveCdnConfigsSettings);
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
          .getCdnConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listCdnConfigsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createCdnConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchCreateCdnConfigsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateCdnConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchUpdateCdnConfigsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchActivateCdnConfigsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchArchiveCdnConfigsSettings()
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

    /** Returns the builder for the settings used for calls to getCdnConfig. */
    public UnaryCallSettings.Builder<GetCdnConfigRequest, CdnConfig> getCdnConfigSettings() {
      return getCdnConfigSettings;
    }

    /** Returns the builder for the settings used for calls to listCdnConfigs. */
    public PagedCallSettings.Builder<
            ListCdnConfigsRequest, ListCdnConfigsResponse, ListCdnConfigsPagedResponse>
        listCdnConfigsSettings() {
      return listCdnConfigsSettings;
    }

    /** Returns the builder for the settings used for calls to createCdnConfig. */
    public UnaryCallSettings.Builder<CreateCdnConfigRequest, CdnConfig> createCdnConfigSettings() {
      return createCdnConfigSettings;
    }

    /** Returns the builder for the settings used for calls to batchCreateCdnConfigs. */
    public UnaryCallSettings.Builder<BatchCreateCdnConfigsRequest, BatchCreateCdnConfigsResponse>
        batchCreateCdnConfigsSettings() {
      return batchCreateCdnConfigsSettings;
    }

    /** Returns the builder for the settings used for calls to updateCdnConfig. */
    public UnaryCallSettings.Builder<UpdateCdnConfigRequest, CdnConfig> updateCdnConfigSettings() {
      return updateCdnConfigSettings;
    }

    /** Returns the builder for the settings used for calls to batchUpdateCdnConfigs. */
    public UnaryCallSettings.Builder<BatchUpdateCdnConfigsRequest, BatchUpdateCdnConfigsResponse>
        batchUpdateCdnConfigsSettings() {
      return batchUpdateCdnConfigsSettings;
    }

    /** Returns the builder for the settings used for calls to batchActivateCdnConfigs. */
    public UnaryCallSettings.Builder<
            BatchActivateCdnConfigsRequest, BatchActivateCdnConfigsResponse>
        batchActivateCdnConfigsSettings() {
      return batchActivateCdnConfigsSettings;
    }

    /** Returns the builder for the settings used for calls to batchArchiveCdnConfigs. */
    public UnaryCallSettings.Builder<BatchArchiveCdnConfigsRequest, BatchArchiveCdnConfigsResponse>
        batchArchiveCdnConfigsSettings() {
      return batchArchiveCdnConfigsSettings;
    }

    @Override
    public CdnConfigServiceStubSettings build() throws IOException {
      return new CdnConfigServiceStubSettings(this);
    }
  }
}
