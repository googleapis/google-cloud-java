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

package com.google.cloud.privatecatalog.v1beta1.stub;

import static com.google.cloud.privatecatalog.v1beta1.PrivateCatalogClient.SearchCatalogsPagedResponse;
import static com.google.cloud.privatecatalog.v1beta1.PrivateCatalogClient.SearchProductsPagedResponse;
import static com.google.cloud.privatecatalog.v1beta1.PrivateCatalogClient.SearchVersionsPagedResponse;

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
import com.google.cloud.privatecatalog.v1beta1.Catalog;
import com.google.cloud.privatecatalog.v1beta1.Product;
import com.google.cloud.privatecatalog.v1beta1.SearchCatalogsRequest;
import com.google.cloud.privatecatalog.v1beta1.SearchCatalogsResponse;
import com.google.cloud.privatecatalog.v1beta1.SearchProductsRequest;
import com.google.cloud.privatecatalog.v1beta1.SearchProductsResponse;
import com.google.cloud.privatecatalog.v1beta1.SearchVersionsRequest;
import com.google.cloud.privatecatalog.v1beta1.SearchVersionsResponse;
import com.google.cloud.privatecatalog.v1beta1.Version;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link PrivateCatalogStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (cloudprivatecatalog.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of searchCatalogs to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * PrivateCatalogStubSettings.Builder privateCatalogSettingsBuilder =
 *     PrivateCatalogStubSettings.newBuilder();
 * privateCatalogSettingsBuilder
 *     .searchCatalogsSettings()
 *     .setRetrySettings(
 *         privateCatalogSettingsBuilder.searchCatalogsSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * PrivateCatalogStubSettings privateCatalogSettings = privateCatalogSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class PrivateCatalogStubSettings extends StubSettings<PrivateCatalogStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          SearchCatalogsRequest, SearchCatalogsResponse, SearchCatalogsPagedResponse>
      searchCatalogsSettings;
  private final PagedCallSettings<
          SearchProductsRequest, SearchProductsResponse, SearchProductsPagedResponse>
      searchProductsSettings;
  private final PagedCallSettings<
          SearchVersionsRequest, SearchVersionsResponse, SearchVersionsPagedResponse>
      searchVersionsSettings;

  private static final PagedListDescriptor<SearchCatalogsRequest, SearchCatalogsResponse, Catalog>
      SEARCH_CATALOGS_PAGE_STR_DESC =
          new PagedListDescriptor<SearchCatalogsRequest, SearchCatalogsResponse, Catalog>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public SearchCatalogsRequest injectToken(SearchCatalogsRequest payload, String token) {
              return SearchCatalogsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public SearchCatalogsRequest injectPageSize(
                SearchCatalogsRequest payload, int pageSize) {
              return SearchCatalogsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(SearchCatalogsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(SearchCatalogsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Catalog> extractResources(SearchCatalogsResponse payload) {
              return payload.getCatalogsList() == null
                  ? ImmutableList.<Catalog>of()
                  : payload.getCatalogsList();
            }
          };

  private static final PagedListDescriptor<SearchProductsRequest, SearchProductsResponse, Product>
      SEARCH_PRODUCTS_PAGE_STR_DESC =
          new PagedListDescriptor<SearchProductsRequest, SearchProductsResponse, Product>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public SearchProductsRequest injectToken(SearchProductsRequest payload, String token) {
              return SearchProductsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public SearchProductsRequest injectPageSize(
                SearchProductsRequest payload, int pageSize) {
              return SearchProductsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(SearchProductsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(SearchProductsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Product> extractResources(SearchProductsResponse payload) {
              return payload.getProductsList() == null
                  ? ImmutableList.<Product>of()
                  : payload.getProductsList();
            }
          };

  private static final PagedListDescriptor<SearchVersionsRequest, SearchVersionsResponse, Version>
      SEARCH_VERSIONS_PAGE_STR_DESC =
          new PagedListDescriptor<SearchVersionsRequest, SearchVersionsResponse, Version>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public SearchVersionsRequest injectToken(SearchVersionsRequest payload, String token) {
              return SearchVersionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public SearchVersionsRequest injectPageSize(
                SearchVersionsRequest payload, int pageSize) {
              return SearchVersionsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(SearchVersionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(SearchVersionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Version> extractResources(SearchVersionsResponse payload) {
              return payload.getVersionsList() == null
                  ? ImmutableList.<Version>of()
                  : payload.getVersionsList();
            }
          };

  private static final PagedListResponseFactory<
          SearchCatalogsRequest, SearchCatalogsResponse, SearchCatalogsPagedResponse>
      SEARCH_CATALOGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              SearchCatalogsRequest, SearchCatalogsResponse, SearchCatalogsPagedResponse>() {
            @Override
            public ApiFuture<SearchCatalogsPagedResponse> getFuturePagedResponse(
                UnaryCallable<SearchCatalogsRequest, SearchCatalogsResponse> callable,
                SearchCatalogsRequest request,
                ApiCallContext context,
                ApiFuture<SearchCatalogsResponse> futureResponse) {
              PageContext<SearchCatalogsRequest, SearchCatalogsResponse, Catalog> pageContext =
                  PageContext.create(callable, SEARCH_CATALOGS_PAGE_STR_DESC, request, context);
              return SearchCatalogsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          SearchProductsRequest, SearchProductsResponse, SearchProductsPagedResponse>
      SEARCH_PRODUCTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              SearchProductsRequest, SearchProductsResponse, SearchProductsPagedResponse>() {
            @Override
            public ApiFuture<SearchProductsPagedResponse> getFuturePagedResponse(
                UnaryCallable<SearchProductsRequest, SearchProductsResponse> callable,
                SearchProductsRequest request,
                ApiCallContext context,
                ApiFuture<SearchProductsResponse> futureResponse) {
              PageContext<SearchProductsRequest, SearchProductsResponse, Product> pageContext =
                  PageContext.create(callable, SEARCH_PRODUCTS_PAGE_STR_DESC, request, context);
              return SearchProductsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          SearchVersionsRequest, SearchVersionsResponse, SearchVersionsPagedResponse>
      SEARCH_VERSIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              SearchVersionsRequest, SearchVersionsResponse, SearchVersionsPagedResponse>() {
            @Override
            public ApiFuture<SearchVersionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<SearchVersionsRequest, SearchVersionsResponse> callable,
                SearchVersionsRequest request,
                ApiCallContext context,
                ApiFuture<SearchVersionsResponse> futureResponse) {
              PageContext<SearchVersionsRequest, SearchVersionsResponse, Version> pageContext =
                  PageContext.create(callable, SEARCH_VERSIONS_PAGE_STR_DESC, request, context);
              return SearchVersionsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to searchCatalogs. */
  public PagedCallSettings<
          SearchCatalogsRequest, SearchCatalogsResponse, SearchCatalogsPagedResponse>
      searchCatalogsSettings() {
    return searchCatalogsSettings;
  }

  /** Returns the object with the settings used for calls to searchProducts. */
  public PagedCallSettings<
          SearchProductsRequest, SearchProductsResponse, SearchProductsPagedResponse>
      searchProductsSettings() {
    return searchProductsSettings;
  }

  /** Returns the object with the settings used for calls to searchVersions. */
  public PagedCallSettings<
          SearchVersionsRequest, SearchVersionsResponse, SearchVersionsPagedResponse>
      searchVersionsSettings() {
    return searchVersionsSettings;
  }

  public PrivateCatalogStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcPrivateCatalogStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonPrivateCatalogStub.create(this);
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
    return "cloudprivatecatalog.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "cloudprivatecatalog.mtls.googleapis.com:443";
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

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(PrivateCatalogStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(PrivateCatalogStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return PrivateCatalogStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected PrivateCatalogStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    searchCatalogsSettings = settingsBuilder.searchCatalogsSettings().build();
    searchProductsSettings = settingsBuilder.searchProductsSettings().build();
    searchVersionsSettings = settingsBuilder.searchVersionsSettings().build();
  }

  /** Builder for PrivateCatalogStubSettings. */
  public static class Builder extends StubSettings.Builder<PrivateCatalogStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            SearchCatalogsRequest, SearchCatalogsResponse, SearchCatalogsPagedResponse>
        searchCatalogsSettings;
    private final PagedCallSettings.Builder<
            SearchProductsRequest, SearchProductsResponse, SearchProductsPagedResponse>
        searchProductsSettings;
    private final PagedCallSettings.Builder<
            SearchVersionsRequest, SearchVersionsResponse, SearchVersionsPagedResponse>
        searchVersionsSettings;
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

      searchCatalogsSettings = PagedCallSettings.newBuilder(SEARCH_CATALOGS_PAGE_STR_FACT);
      searchProductsSettings = PagedCallSettings.newBuilder(SEARCH_PRODUCTS_PAGE_STR_FACT);
      searchVersionsSettings = PagedCallSettings.newBuilder(SEARCH_VERSIONS_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              searchCatalogsSettings, searchProductsSettings, searchVersionsSettings);
      initDefaults(this);
    }

    protected Builder(PrivateCatalogStubSettings settings) {
      super(settings);

      searchCatalogsSettings = settings.searchCatalogsSettings.toBuilder();
      searchProductsSettings = settings.searchProductsSettings.toBuilder();
      searchVersionsSettings = settings.searchVersionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              searchCatalogsSettings, searchProductsSettings, searchVersionsSettings);
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

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .searchCatalogsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .searchProductsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .searchVersionsSettings()
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

    /** Returns the builder for the settings used for calls to searchCatalogs. */
    public PagedCallSettings.Builder<
            SearchCatalogsRequest, SearchCatalogsResponse, SearchCatalogsPagedResponse>
        searchCatalogsSettings() {
      return searchCatalogsSettings;
    }

    /** Returns the builder for the settings used for calls to searchProducts. */
    public PagedCallSettings.Builder<
            SearchProductsRequest, SearchProductsResponse, SearchProductsPagedResponse>
        searchProductsSettings() {
      return searchProductsSettings;
    }

    /** Returns the builder for the settings used for calls to searchVersions. */
    public PagedCallSettings.Builder<
            SearchVersionsRequest, SearchVersionsResponse, SearchVersionsPagedResponse>
        searchVersionsSettings() {
      return searchVersionsSettings;
    }

    @Override
    public PrivateCatalogStubSettings build() throws IOException {
      return new PrivateCatalogStubSettings(this);
    }
  }
}
