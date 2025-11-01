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

package com.google.ads.admanager.v1.stub;

import static com.google.ads.admanager.v1.SiteServiceClient.ListSitesPagedResponse;

import com.google.ads.admanager.v1.BatchCreateSitesRequest;
import com.google.ads.admanager.v1.BatchCreateSitesResponse;
import com.google.ads.admanager.v1.BatchDeactivateSitesRequest;
import com.google.ads.admanager.v1.BatchDeactivateSitesResponse;
import com.google.ads.admanager.v1.BatchSubmitSitesForApprovalRequest;
import com.google.ads.admanager.v1.BatchSubmitSitesForApprovalResponse;
import com.google.ads.admanager.v1.BatchUpdateSitesRequest;
import com.google.ads.admanager.v1.BatchUpdateSitesResponse;
import com.google.ads.admanager.v1.CreateSiteRequest;
import com.google.ads.admanager.v1.GetSiteRequest;
import com.google.ads.admanager.v1.ListSitesRequest;
import com.google.ads.admanager.v1.ListSitesResponse;
import com.google.ads.admanager.v1.Site;
import com.google.ads.admanager.v1.UpdateSiteRequest;
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

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link SiteServiceStub}.
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
 * of getSite:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SiteServiceStubSettings.Builder siteServiceSettingsBuilder =
 *     SiteServiceStubSettings.newBuilder();
 * siteServiceSettingsBuilder
 *     .getSiteSettings()
 *     .setRetrySettings(
 *         siteServiceSettingsBuilder
 *             .getSiteSettings()
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
 * SiteServiceStubSettings siteServiceSettings = siteServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 */
@Generated("by gapic-generator-java")
public class SiteServiceStubSettings extends StubSettings<SiteServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/admanager").build();

  private final UnaryCallSettings<GetSiteRequest, Site> getSiteSettings;
  private final PagedCallSettings<ListSitesRequest, ListSitesResponse, ListSitesPagedResponse>
      listSitesSettings;
  private final UnaryCallSettings<CreateSiteRequest, Site> createSiteSettings;
  private final UnaryCallSettings<BatchCreateSitesRequest, BatchCreateSitesResponse>
      batchCreateSitesSettings;
  private final UnaryCallSettings<UpdateSiteRequest, Site> updateSiteSettings;
  private final UnaryCallSettings<BatchUpdateSitesRequest, BatchUpdateSitesResponse>
      batchUpdateSitesSettings;
  private final UnaryCallSettings<BatchDeactivateSitesRequest, BatchDeactivateSitesResponse>
      batchDeactivateSitesSettings;
  private final UnaryCallSettings<
          BatchSubmitSitesForApprovalRequest, BatchSubmitSitesForApprovalResponse>
      batchSubmitSitesForApprovalSettings;

  private static final PagedListDescriptor<ListSitesRequest, ListSitesResponse, Site>
      LIST_SITES_PAGE_STR_DESC =
          new PagedListDescriptor<ListSitesRequest, ListSitesResponse, Site>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListSitesRequest injectToken(ListSitesRequest payload, String token) {
              return ListSitesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListSitesRequest injectPageSize(ListSitesRequest payload, int pageSize) {
              return ListSitesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListSitesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListSitesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Site> extractResources(ListSitesResponse payload) {
              return payload.getSitesList();
            }
          };

  private static final PagedListResponseFactory<
          ListSitesRequest, ListSitesResponse, ListSitesPagedResponse>
      LIST_SITES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListSitesRequest, ListSitesResponse, ListSitesPagedResponse>() {
            @Override
            public ApiFuture<ListSitesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListSitesRequest, ListSitesResponse> callable,
                ListSitesRequest request,
                ApiCallContext context,
                ApiFuture<ListSitesResponse> futureResponse) {
              PageContext<ListSitesRequest, ListSitesResponse, Site> pageContext =
                  PageContext.create(callable, LIST_SITES_PAGE_STR_DESC, request, context);
              return ListSitesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getSite. */
  public UnaryCallSettings<GetSiteRequest, Site> getSiteSettings() {
    return getSiteSettings;
  }

  /** Returns the object with the settings used for calls to listSites. */
  public PagedCallSettings<ListSitesRequest, ListSitesResponse, ListSitesPagedResponse>
      listSitesSettings() {
    return listSitesSettings;
  }

  /** Returns the object with the settings used for calls to createSite. */
  public UnaryCallSettings<CreateSiteRequest, Site> createSiteSettings() {
    return createSiteSettings;
  }

  /** Returns the object with the settings used for calls to batchCreateSites. */
  public UnaryCallSettings<BatchCreateSitesRequest, BatchCreateSitesResponse>
      batchCreateSitesSettings() {
    return batchCreateSitesSettings;
  }

  /** Returns the object with the settings used for calls to updateSite. */
  public UnaryCallSettings<UpdateSiteRequest, Site> updateSiteSettings() {
    return updateSiteSettings;
  }

  /** Returns the object with the settings used for calls to batchUpdateSites. */
  public UnaryCallSettings<BatchUpdateSitesRequest, BatchUpdateSitesResponse>
      batchUpdateSitesSettings() {
    return batchUpdateSitesSettings;
  }

  /** Returns the object with the settings used for calls to batchDeactivateSites. */
  public UnaryCallSettings<BatchDeactivateSitesRequest, BatchDeactivateSitesResponse>
      batchDeactivateSitesSettings() {
    return batchDeactivateSitesSettings;
  }

  /** Returns the object with the settings used for calls to batchSubmitSitesForApproval. */
  public UnaryCallSettings<BatchSubmitSitesForApprovalRequest, BatchSubmitSitesForApprovalResponse>
      batchSubmitSitesForApprovalSettings() {
    return batchSubmitSitesForApprovalSettings;
  }

  public SiteServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonSiteServiceStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(SiteServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
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

  protected SiteServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getSiteSettings = settingsBuilder.getSiteSettings().build();
    listSitesSettings = settingsBuilder.listSitesSettings().build();
    createSiteSettings = settingsBuilder.createSiteSettings().build();
    batchCreateSitesSettings = settingsBuilder.batchCreateSitesSettings().build();
    updateSiteSettings = settingsBuilder.updateSiteSettings().build();
    batchUpdateSitesSettings = settingsBuilder.batchUpdateSitesSettings().build();
    batchDeactivateSitesSettings = settingsBuilder.batchDeactivateSitesSettings().build();
    batchSubmitSitesForApprovalSettings =
        settingsBuilder.batchSubmitSitesForApprovalSettings().build();
  }

  /** Builder for SiteServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<SiteServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetSiteRequest, Site> getSiteSettings;
    private final PagedCallSettings.Builder<
            ListSitesRequest, ListSitesResponse, ListSitesPagedResponse>
        listSitesSettings;
    private final UnaryCallSettings.Builder<CreateSiteRequest, Site> createSiteSettings;
    private final UnaryCallSettings.Builder<BatchCreateSitesRequest, BatchCreateSitesResponse>
        batchCreateSitesSettings;
    private final UnaryCallSettings.Builder<UpdateSiteRequest, Site> updateSiteSettings;
    private final UnaryCallSettings.Builder<BatchUpdateSitesRequest, BatchUpdateSitesResponse>
        batchUpdateSitesSettings;
    private final UnaryCallSettings.Builder<
            BatchDeactivateSitesRequest, BatchDeactivateSitesResponse>
        batchDeactivateSitesSettings;
    private final UnaryCallSettings.Builder<
            BatchSubmitSitesForApprovalRequest, BatchSubmitSitesForApprovalResponse>
        batchSubmitSitesForApprovalSettings;
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

      getSiteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listSitesSettings = PagedCallSettings.newBuilder(LIST_SITES_PAGE_STR_FACT);
      createSiteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchCreateSitesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateSiteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchUpdateSitesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchDeactivateSitesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchSubmitSitesForApprovalSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getSiteSettings,
              listSitesSettings,
              createSiteSettings,
              batchCreateSitesSettings,
              updateSiteSettings,
              batchUpdateSitesSettings,
              batchDeactivateSitesSettings,
              batchSubmitSitesForApprovalSettings);
      initDefaults(this);
    }

    protected Builder(SiteServiceStubSettings settings) {
      super(settings);

      getSiteSettings = settings.getSiteSettings.toBuilder();
      listSitesSettings = settings.listSitesSettings.toBuilder();
      createSiteSettings = settings.createSiteSettings.toBuilder();
      batchCreateSitesSettings = settings.batchCreateSitesSettings.toBuilder();
      updateSiteSettings = settings.updateSiteSettings.toBuilder();
      batchUpdateSitesSettings = settings.batchUpdateSitesSettings.toBuilder();
      batchDeactivateSitesSettings = settings.batchDeactivateSitesSettings.toBuilder();
      batchSubmitSitesForApprovalSettings =
          settings.batchSubmitSitesForApprovalSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getSiteSettings,
              listSitesSettings,
              createSiteSettings,
              batchCreateSitesSettings,
              updateSiteSettings,
              batchUpdateSitesSettings,
              batchDeactivateSitesSettings,
              batchSubmitSitesForApprovalSettings);
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
          .getSiteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listSitesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createSiteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchCreateSitesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateSiteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchUpdateSitesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchDeactivateSitesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchSubmitSitesForApprovalSettings()
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

    /** Returns the builder for the settings used for calls to getSite. */
    public UnaryCallSettings.Builder<GetSiteRequest, Site> getSiteSettings() {
      return getSiteSettings;
    }

    /** Returns the builder for the settings used for calls to listSites. */
    public PagedCallSettings.Builder<ListSitesRequest, ListSitesResponse, ListSitesPagedResponse>
        listSitesSettings() {
      return listSitesSettings;
    }

    /** Returns the builder for the settings used for calls to createSite. */
    public UnaryCallSettings.Builder<CreateSiteRequest, Site> createSiteSettings() {
      return createSiteSettings;
    }

    /** Returns the builder for the settings used for calls to batchCreateSites. */
    public UnaryCallSettings.Builder<BatchCreateSitesRequest, BatchCreateSitesResponse>
        batchCreateSitesSettings() {
      return batchCreateSitesSettings;
    }

    /** Returns the builder for the settings used for calls to updateSite. */
    public UnaryCallSettings.Builder<UpdateSiteRequest, Site> updateSiteSettings() {
      return updateSiteSettings;
    }

    /** Returns the builder for the settings used for calls to batchUpdateSites. */
    public UnaryCallSettings.Builder<BatchUpdateSitesRequest, BatchUpdateSitesResponse>
        batchUpdateSitesSettings() {
      return batchUpdateSitesSettings;
    }

    /** Returns the builder for the settings used for calls to batchDeactivateSites. */
    public UnaryCallSettings.Builder<BatchDeactivateSitesRequest, BatchDeactivateSitesResponse>
        batchDeactivateSitesSettings() {
      return batchDeactivateSitesSettings;
    }

    /** Returns the builder for the settings used for calls to batchSubmitSitesForApproval. */
    public UnaryCallSettings.Builder<
            BatchSubmitSitesForApprovalRequest, BatchSubmitSitesForApprovalResponse>
        batchSubmitSitesForApprovalSettings() {
      return batchSubmitSitesForApprovalSettings;
    }

    @Override
    public SiteServiceStubSettings build() throws IOException {
      return new SiteServiceStubSettings(this);
    }
  }
}
