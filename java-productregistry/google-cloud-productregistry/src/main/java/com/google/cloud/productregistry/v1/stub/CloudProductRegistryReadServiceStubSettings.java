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

package com.google.cloud.productregistry.v1.stub;

import static com.google.cloud.productregistry.v1.CloudProductRegistryReadServiceClient.ListLogicalProductVariantsPagedResponse;
import static com.google.cloud.productregistry.v1.CloudProductRegistryReadServiceClient.ListLogicalProductsPagedResponse;
import static com.google.cloud.productregistry.v1.CloudProductRegistryReadServiceClient.ListProductSuitesPagedResponse;

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
import com.google.cloud.productregistry.v1.GetLogicalProductRequest;
import com.google.cloud.productregistry.v1.GetLogicalProductVariantRequest;
import com.google.cloud.productregistry.v1.GetProductSuiteRequest;
import com.google.cloud.productregistry.v1.ListLogicalProductVariantsRequest;
import com.google.cloud.productregistry.v1.ListLogicalProductVariantsResponse;
import com.google.cloud.productregistry.v1.ListLogicalProductsRequest;
import com.google.cloud.productregistry.v1.ListLogicalProductsResponse;
import com.google.cloud.productregistry.v1.ListProductSuitesRequest;
import com.google.cloud.productregistry.v1.ListProductSuitesResponse;
import com.google.cloud.productregistry.v1.LogicalProduct;
import com.google.cloud.productregistry.v1.LogicalProductVariant;
import com.google.cloud.productregistry.v1.LookupEntityRequest;
import com.google.cloud.productregistry.v1.LookupEntityResponse;
import com.google.cloud.productregistry.v1.ProductSuite;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link CloudProductRegistryReadServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (cloudproductregistry.googleapis.com) and default port (443)
 *       are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getProductSuite:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CloudProductRegistryReadServiceStubSettings.Builder
 *     cloudProductRegistryReadServiceSettingsBuilder =
 *         CloudProductRegistryReadServiceStubSettings.newBuilder();
 * cloudProductRegistryReadServiceSettingsBuilder
 *     .getProductSuiteSettings()
 *     .setRetrySettings(
 *         cloudProductRegistryReadServiceSettingsBuilder
 *             .getProductSuiteSettings()
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
 * CloudProductRegistryReadServiceStubSettings cloudProductRegistryReadServiceSettings =
 *     cloudProductRegistryReadServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@NullMarked
@Generated("by gapic-generator-java")
@SuppressWarnings("CanonicalDuration")
public class CloudProductRegistryReadServiceStubSettings
    extends StubSettings<CloudProductRegistryReadServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().build();

  private final UnaryCallSettings<GetProductSuiteRequest, ProductSuite> getProductSuiteSettings;
  private final PagedCallSettings<
          ListProductSuitesRequest, ListProductSuitesResponse, ListProductSuitesPagedResponse>
      listProductSuitesSettings;
  private final UnaryCallSettings<GetLogicalProductRequest, LogicalProduct>
      getLogicalProductSettings;
  private final PagedCallSettings<
          ListLogicalProductsRequest, ListLogicalProductsResponse, ListLogicalProductsPagedResponse>
      listLogicalProductsSettings;
  private final UnaryCallSettings<GetLogicalProductVariantRequest, LogicalProductVariant>
      getLogicalProductVariantSettings;
  private final PagedCallSettings<
          ListLogicalProductVariantsRequest,
          ListLogicalProductVariantsResponse,
          ListLogicalProductVariantsPagedResponse>
      listLogicalProductVariantsSettings;
  private final UnaryCallSettings<LookupEntityRequest, LookupEntityResponse> lookupEntitySettings;

  private static final PagedListDescriptor<
          ListProductSuitesRequest, ListProductSuitesResponse, ProductSuite>
      LIST_PRODUCT_SUITES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListProductSuitesRequest, ListProductSuitesResponse, ProductSuite>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListProductSuitesRequest injectToken(
                ListProductSuitesRequest payload, String token) {
              return ListProductSuitesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListProductSuitesRequest injectPageSize(
                ListProductSuitesRequest payload, int pageSize) {
              return ListProductSuitesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListProductSuitesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListProductSuitesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ProductSuite> extractResources(ListProductSuitesResponse payload) {
              return payload.getProductSuitesList();
            }
          };

  private static final PagedListDescriptor<
          ListLogicalProductsRequest, ListLogicalProductsResponse, LogicalProduct>
      LIST_LOGICAL_PRODUCTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListLogicalProductsRequest, ListLogicalProductsResponse, LogicalProduct>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListLogicalProductsRequest injectToken(
                ListLogicalProductsRequest payload, String token) {
              return ListLogicalProductsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListLogicalProductsRequest injectPageSize(
                ListLogicalProductsRequest payload, int pageSize) {
              return ListLogicalProductsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListLogicalProductsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListLogicalProductsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<LogicalProduct> extractResources(ListLogicalProductsResponse payload) {
              return payload.getLogicalProductsList();
            }
          };

  private static final PagedListDescriptor<
          ListLogicalProductVariantsRequest,
          ListLogicalProductVariantsResponse,
          LogicalProductVariant>
      LIST_LOGICAL_PRODUCT_VARIANTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListLogicalProductVariantsRequest,
              ListLogicalProductVariantsResponse,
              LogicalProductVariant>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListLogicalProductVariantsRequest injectToken(
                ListLogicalProductVariantsRequest payload, String token) {
              return ListLogicalProductVariantsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListLogicalProductVariantsRequest injectPageSize(
                ListLogicalProductVariantsRequest payload, int pageSize) {
              return ListLogicalProductVariantsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListLogicalProductVariantsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListLogicalProductVariantsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<LogicalProductVariant> extractResources(
                ListLogicalProductVariantsResponse payload) {
              return payload.getLogicalProductVariantsList();
            }
          };

  private static final PagedListResponseFactory<
          ListProductSuitesRequest, ListProductSuitesResponse, ListProductSuitesPagedResponse>
      LIST_PRODUCT_SUITES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListProductSuitesRequest,
              ListProductSuitesResponse,
              ListProductSuitesPagedResponse>() {
            @Override
            public ApiFuture<ListProductSuitesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListProductSuitesRequest, ListProductSuitesResponse> callable,
                ListProductSuitesRequest request,
                ApiCallContext context,
                ApiFuture<ListProductSuitesResponse> futureResponse) {
              PageContext<ListProductSuitesRequest, ListProductSuitesResponse, ProductSuite>
                  pageContext =
                      PageContext.create(
                          callable, LIST_PRODUCT_SUITES_PAGE_STR_DESC, request, context);
              return ListProductSuitesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListLogicalProductsRequest, ListLogicalProductsResponse, ListLogicalProductsPagedResponse>
      LIST_LOGICAL_PRODUCTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListLogicalProductsRequest,
              ListLogicalProductsResponse,
              ListLogicalProductsPagedResponse>() {
            @Override
            public ApiFuture<ListLogicalProductsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListLogicalProductsRequest, ListLogicalProductsResponse> callable,
                ListLogicalProductsRequest request,
                ApiCallContext context,
                ApiFuture<ListLogicalProductsResponse> futureResponse) {
              PageContext<ListLogicalProductsRequest, ListLogicalProductsResponse, LogicalProduct>
                  pageContext =
                      PageContext.create(
                          callable, LIST_LOGICAL_PRODUCTS_PAGE_STR_DESC, request, context);
              return ListLogicalProductsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListLogicalProductVariantsRequest,
          ListLogicalProductVariantsResponse,
          ListLogicalProductVariantsPagedResponse>
      LIST_LOGICAL_PRODUCT_VARIANTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListLogicalProductVariantsRequest,
              ListLogicalProductVariantsResponse,
              ListLogicalProductVariantsPagedResponse>() {
            @Override
            public ApiFuture<ListLogicalProductVariantsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListLogicalProductVariantsRequest, ListLogicalProductVariantsResponse>
                    callable,
                ListLogicalProductVariantsRequest request,
                ApiCallContext context,
                ApiFuture<ListLogicalProductVariantsResponse> futureResponse) {
              PageContext<
                      ListLogicalProductVariantsRequest,
                      ListLogicalProductVariantsResponse,
                      LogicalProductVariant>
                  pageContext =
                      PageContext.create(
                          callable, LIST_LOGICAL_PRODUCT_VARIANTS_PAGE_STR_DESC, request, context);
              return ListLogicalProductVariantsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getProductSuite. */
  public UnaryCallSettings<GetProductSuiteRequest, ProductSuite> getProductSuiteSettings() {
    return getProductSuiteSettings;
  }

  /** Returns the object with the settings used for calls to listProductSuites. */
  public PagedCallSettings<
          ListProductSuitesRequest, ListProductSuitesResponse, ListProductSuitesPagedResponse>
      listProductSuitesSettings() {
    return listProductSuitesSettings;
  }

  /** Returns the object with the settings used for calls to getLogicalProduct. */
  public UnaryCallSettings<GetLogicalProductRequest, LogicalProduct> getLogicalProductSettings() {
    return getLogicalProductSettings;
  }

  /** Returns the object with the settings used for calls to listLogicalProducts. */
  public PagedCallSettings<
          ListLogicalProductsRequest, ListLogicalProductsResponse, ListLogicalProductsPagedResponse>
      listLogicalProductsSettings() {
    return listLogicalProductsSettings;
  }

  /** Returns the object with the settings used for calls to getLogicalProductVariant. */
  public UnaryCallSettings<GetLogicalProductVariantRequest, LogicalProductVariant>
      getLogicalProductVariantSettings() {
    return getLogicalProductVariantSettings;
  }

  /** Returns the object with the settings used for calls to listLogicalProductVariants. */
  public PagedCallSettings<
          ListLogicalProductVariantsRequest,
          ListLogicalProductVariantsResponse,
          ListLogicalProductVariantsPagedResponse>
      listLogicalProductVariantsSettings() {
    return listLogicalProductVariantsSettings;
  }

  /** Returns the object with the settings used for calls to lookupEntity. */
  public UnaryCallSettings<LookupEntityRequest, LookupEntityResponse> lookupEntitySettings() {
    return lookupEntitySettings;
  }

  public CloudProductRegistryReadServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcCloudProductRegistryReadServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonCloudProductRegistryReadServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "cloudproductregistry";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "cloudproductregistry.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "cloudproductregistry.mtls.googleapis.com:443";
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
            GaxProperties.getLibraryVersion(CloudProductRegistryReadServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic",
            GaxProperties.getLibraryVersion(CloudProductRegistryReadServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return CloudProductRegistryReadServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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
  public static Builder newBuilder(@Nullable ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected CloudProductRegistryReadServiceStubSettings(Builder settingsBuilder)
      throws IOException {
    super(settingsBuilder);

    getProductSuiteSettings = settingsBuilder.getProductSuiteSettings().build();
    listProductSuitesSettings = settingsBuilder.listProductSuitesSettings().build();
    getLogicalProductSettings = settingsBuilder.getLogicalProductSettings().build();
    listLogicalProductsSettings = settingsBuilder.listLogicalProductsSettings().build();
    getLogicalProductVariantSettings = settingsBuilder.getLogicalProductVariantSettings().build();
    listLogicalProductVariantsSettings =
        settingsBuilder.listLogicalProductVariantsSettings().build();
    lookupEntitySettings = settingsBuilder.lookupEntitySettings().build();
  }

  @Override
  protected LibraryMetadata getLibraryMetadata() {
    return LibraryMetadata.newBuilder()
        .setArtifactName("com.google.cloud:google-cloud-productregistry")
        .setRepository("googleapis/google-cloud-java")
        .setVersion(Version.VERSION)
        .build();
  }

  /** Builder for CloudProductRegistryReadServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<CloudProductRegistryReadServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetProductSuiteRequest, ProductSuite>
        getProductSuiteSettings;
    private final PagedCallSettings.Builder<
            ListProductSuitesRequest, ListProductSuitesResponse, ListProductSuitesPagedResponse>
        listProductSuitesSettings;
    private final UnaryCallSettings.Builder<GetLogicalProductRequest, LogicalProduct>
        getLogicalProductSettings;
    private final PagedCallSettings.Builder<
            ListLogicalProductsRequest,
            ListLogicalProductsResponse,
            ListLogicalProductsPagedResponse>
        listLogicalProductsSettings;
    private final UnaryCallSettings.Builder<GetLogicalProductVariantRequest, LogicalProductVariant>
        getLogicalProductVariantSettings;
    private final PagedCallSettings.Builder<
            ListLogicalProductVariantsRequest,
            ListLogicalProductVariantsResponse,
            ListLogicalProductVariantsPagedResponse>
        listLogicalProductVariantsSettings;
    private final UnaryCallSettings.Builder<LookupEntityRequest, LookupEntityResponse>
        lookupEntitySettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
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
              .setMaxRetryDelayDuration(Duration.ofMillis(10000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(@Nullable ClientContext clientContext) {
      super(clientContext);

      getProductSuiteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listProductSuitesSettings = PagedCallSettings.newBuilder(LIST_PRODUCT_SUITES_PAGE_STR_FACT);
      getLogicalProductSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listLogicalProductsSettings =
          PagedCallSettings.newBuilder(LIST_LOGICAL_PRODUCTS_PAGE_STR_FACT);
      getLogicalProductVariantSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listLogicalProductVariantsSettings =
          PagedCallSettings.newBuilder(LIST_LOGICAL_PRODUCT_VARIANTS_PAGE_STR_FACT);
      lookupEntitySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getProductSuiteSettings,
              listProductSuitesSettings,
              getLogicalProductSettings,
              listLogicalProductsSettings,
              getLogicalProductVariantSettings,
              listLogicalProductVariantsSettings,
              lookupEntitySettings);
      initDefaults(this);
    }

    protected Builder(CloudProductRegistryReadServiceStubSettings settings) {
      super(settings);

      getProductSuiteSettings = settings.getProductSuiteSettings.toBuilder();
      listProductSuitesSettings = settings.listProductSuitesSettings.toBuilder();
      getLogicalProductSettings = settings.getLogicalProductSettings.toBuilder();
      listLogicalProductsSettings = settings.listLogicalProductsSettings.toBuilder();
      getLogicalProductVariantSettings = settings.getLogicalProductVariantSettings.toBuilder();
      listLogicalProductVariantsSettings = settings.listLogicalProductVariantsSettings.toBuilder();
      lookupEntitySettings = settings.lookupEntitySettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getProductSuiteSettings,
              listProductSuitesSettings,
              getLogicalProductSettings,
              listLogicalProductsSettings,
              getLogicalProductVariantSettings,
              listLogicalProductVariantsSettings,
              lookupEntitySettings);
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
          .getProductSuiteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listProductSuitesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getLogicalProductSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listLogicalProductsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getLogicalProductVariantSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listLogicalProductVariantsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .lookupEntitySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

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

    /** Returns the builder for the settings used for calls to getProductSuite. */
    public UnaryCallSettings.Builder<GetProductSuiteRequest, ProductSuite>
        getProductSuiteSettings() {
      return getProductSuiteSettings;
    }

    /** Returns the builder for the settings used for calls to listProductSuites. */
    public PagedCallSettings.Builder<
            ListProductSuitesRequest, ListProductSuitesResponse, ListProductSuitesPagedResponse>
        listProductSuitesSettings() {
      return listProductSuitesSettings;
    }

    /** Returns the builder for the settings used for calls to getLogicalProduct. */
    public UnaryCallSettings.Builder<GetLogicalProductRequest, LogicalProduct>
        getLogicalProductSettings() {
      return getLogicalProductSettings;
    }

    /** Returns the builder for the settings used for calls to listLogicalProducts. */
    public PagedCallSettings.Builder<
            ListLogicalProductsRequest,
            ListLogicalProductsResponse,
            ListLogicalProductsPagedResponse>
        listLogicalProductsSettings() {
      return listLogicalProductsSettings;
    }

    /** Returns the builder for the settings used for calls to getLogicalProductVariant. */
    public UnaryCallSettings.Builder<GetLogicalProductVariantRequest, LogicalProductVariant>
        getLogicalProductVariantSettings() {
      return getLogicalProductVariantSettings;
    }

    /** Returns the builder for the settings used for calls to listLogicalProductVariants. */
    public PagedCallSettings.Builder<
            ListLogicalProductVariantsRequest,
            ListLogicalProductVariantsResponse,
            ListLogicalProductVariantsPagedResponse>
        listLogicalProductVariantsSettings() {
      return listLogicalProductVariantsSettings;
    }

    /** Returns the builder for the settings used for calls to lookupEntity. */
    public UnaryCallSettings.Builder<LookupEntityRequest, LookupEntityResponse>
        lookupEntitySettings() {
      return lookupEntitySettings;
    }

    @Override
    public CloudProductRegistryReadServiceStubSettings build() throws IOException {
      return new CloudProductRegistryReadServiceStubSettings(this);
    }
  }
}
