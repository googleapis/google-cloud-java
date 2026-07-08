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

import static com.google.ads.admanager.v1.RichMediaAdsCompanyServiceClient.ListRichMediaAdsCompaniesPagedResponse;

import com.google.ads.admanager.v1.GetRichMediaAdsCompanyRequest;
import com.google.ads.admanager.v1.ListRichMediaAdsCompaniesRequest;
import com.google.ads.admanager.v1.ListRichMediaAdsCompaniesResponse;
import com.google.ads.admanager.v1.RichMediaAdsCompany;
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

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link RichMediaAdsCompanyServiceStub}.
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
 * of getRichMediaAdsCompany:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * RichMediaAdsCompanyServiceStubSettings.Builder richMediaAdsCompanyServiceSettingsBuilder =
 *     RichMediaAdsCompanyServiceStubSettings.newBuilder();
 * richMediaAdsCompanyServiceSettingsBuilder
 *     .getRichMediaAdsCompanySettings()
 *     .setRetrySettings(
 *         richMediaAdsCompanyServiceSettingsBuilder
 *             .getRichMediaAdsCompanySettings()
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
 * RichMediaAdsCompanyServiceStubSettings richMediaAdsCompanyServiceSettings =
 *     richMediaAdsCompanyServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@NullMarked
@Generated("by gapic-generator-java")
@SuppressWarnings("CanonicalDuration")
public class RichMediaAdsCompanyServiceStubSettings
    extends StubSettings<RichMediaAdsCompanyServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/admanager")
          .add("https://www.googleapis.com/auth/admanager.readonly")
          .build();

  private final UnaryCallSettings<GetRichMediaAdsCompanyRequest, RichMediaAdsCompany>
      getRichMediaAdsCompanySettings;
  private final PagedCallSettings<
          ListRichMediaAdsCompaniesRequest,
          ListRichMediaAdsCompaniesResponse,
          ListRichMediaAdsCompaniesPagedResponse>
      listRichMediaAdsCompaniesSettings;

  private static final PagedListDescriptor<
          ListRichMediaAdsCompaniesRequest, ListRichMediaAdsCompaniesResponse, RichMediaAdsCompany>
      LIST_RICH_MEDIA_ADS_COMPANIES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListRichMediaAdsCompaniesRequest,
              ListRichMediaAdsCompaniesResponse,
              RichMediaAdsCompany>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListRichMediaAdsCompaniesRequest injectToken(
                ListRichMediaAdsCompaniesRequest payload, String token) {
              return ListRichMediaAdsCompaniesRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListRichMediaAdsCompaniesRequest injectPageSize(
                ListRichMediaAdsCompaniesRequest payload, int pageSize) {
              return ListRichMediaAdsCompaniesRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListRichMediaAdsCompaniesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListRichMediaAdsCompaniesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<RichMediaAdsCompany> extractResources(
                ListRichMediaAdsCompaniesResponse payload) {
              return payload.getRichMediaAdsCompaniesList();
            }
          };

  private static final PagedListResponseFactory<
          ListRichMediaAdsCompaniesRequest,
          ListRichMediaAdsCompaniesResponse,
          ListRichMediaAdsCompaniesPagedResponse>
      LIST_RICH_MEDIA_ADS_COMPANIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListRichMediaAdsCompaniesRequest,
              ListRichMediaAdsCompaniesResponse,
              ListRichMediaAdsCompaniesPagedResponse>() {
            @Override
            public ApiFuture<ListRichMediaAdsCompaniesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListRichMediaAdsCompaniesRequest, ListRichMediaAdsCompaniesResponse>
                    callable,
                ListRichMediaAdsCompaniesRequest request,
                ApiCallContext context,
                ApiFuture<ListRichMediaAdsCompaniesResponse> futureResponse) {
              PageContext<
                      ListRichMediaAdsCompaniesRequest,
                      ListRichMediaAdsCompaniesResponse,
                      RichMediaAdsCompany>
                  pageContext =
                      PageContext.create(
                          callable, LIST_RICH_MEDIA_ADS_COMPANIES_PAGE_STR_DESC, request, context);
              return ListRichMediaAdsCompaniesPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getRichMediaAdsCompany. */
  public UnaryCallSettings<GetRichMediaAdsCompanyRequest, RichMediaAdsCompany>
      getRichMediaAdsCompanySettings() {
    return getRichMediaAdsCompanySettings;
  }

  /** Returns the object with the settings used for calls to listRichMediaAdsCompanies. */
  public PagedCallSettings<
          ListRichMediaAdsCompaniesRequest,
          ListRichMediaAdsCompaniesResponse,
          ListRichMediaAdsCompaniesPagedResponse>
      listRichMediaAdsCompaniesSettings() {
    return listRichMediaAdsCompaniesSettings;
  }

  public RichMediaAdsCompanyServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonRichMediaAdsCompanyServiceStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(RichMediaAdsCompanyServiceStubSettings.class))
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

  protected RichMediaAdsCompanyServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getRichMediaAdsCompanySettings = settingsBuilder.getRichMediaAdsCompanySettings().build();
    listRichMediaAdsCompaniesSettings = settingsBuilder.listRichMediaAdsCompaniesSettings().build();
  }

  @Override
  protected LibraryMetadata getLibraryMetadata() {
    return LibraryMetadata.newBuilder()
        .setArtifactName("com.google.api-ads:ad-manager")
        .setRepository("googleapis/google-cloud-java")
        .setVersion(Version.VERSION)
        .build();
  }

  /** Builder for RichMediaAdsCompanyServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<RichMediaAdsCompanyServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetRichMediaAdsCompanyRequest, RichMediaAdsCompany>
        getRichMediaAdsCompanySettings;
    private final PagedCallSettings.Builder<
            ListRichMediaAdsCompaniesRequest,
            ListRichMediaAdsCompaniesResponse,
            ListRichMediaAdsCompaniesPagedResponse>
        listRichMediaAdsCompaniesSettings;
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

      getRichMediaAdsCompanySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listRichMediaAdsCompaniesSettings =
          PagedCallSettings.newBuilder(LIST_RICH_MEDIA_ADS_COMPANIES_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getRichMediaAdsCompanySettings, listRichMediaAdsCompaniesSettings);
      initDefaults(this);
    }

    protected Builder(RichMediaAdsCompanyServiceStubSettings settings) {
      super(settings);

      getRichMediaAdsCompanySettings = settings.getRichMediaAdsCompanySettings.toBuilder();
      listRichMediaAdsCompaniesSettings = settings.listRichMediaAdsCompaniesSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getRichMediaAdsCompanySettings, listRichMediaAdsCompaniesSettings);
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
          .getRichMediaAdsCompanySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listRichMediaAdsCompaniesSettings()
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

    /** Returns the builder for the settings used for calls to getRichMediaAdsCompany. */
    public UnaryCallSettings.Builder<GetRichMediaAdsCompanyRequest, RichMediaAdsCompany>
        getRichMediaAdsCompanySettings() {
      return getRichMediaAdsCompanySettings;
    }

    /** Returns the builder for the settings used for calls to listRichMediaAdsCompanies. */
    public PagedCallSettings.Builder<
            ListRichMediaAdsCompaniesRequest,
            ListRichMediaAdsCompaniesResponse,
            ListRichMediaAdsCompaniesPagedResponse>
        listRichMediaAdsCompaniesSettings() {
      return listRichMediaAdsCompaniesSettings;
    }

    @Override
    public RichMediaAdsCompanyServiceStubSettings build() throws IOException {
      return new RichMediaAdsCompanyServiceStubSettings(this);
    }
  }
}
