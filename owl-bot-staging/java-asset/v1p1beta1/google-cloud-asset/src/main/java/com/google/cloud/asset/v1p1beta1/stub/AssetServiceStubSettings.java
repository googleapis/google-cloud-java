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

package com.google.cloud.asset.v1p1beta1.stub;

import static com.google.cloud.asset.v1p1beta1.AssetServiceClient.SearchAllIamPoliciesPagedResponse;
import static com.google.cloud.asset.v1p1beta1.AssetServiceClient.SearchAllResourcesPagedResponse;

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
import com.google.cloud.asset.v1p1beta1.IamPolicySearchResult;
import com.google.cloud.asset.v1p1beta1.SearchAllIamPoliciesRequest;
import com.google.cloud.asset.v1p1beta1.SearchAllIamPoliciesResponse;
import com.google.cloud.asset.v1p1beta1.SearchAllResourcesRequest;
import com.google.cloud.asset.v1p1beta1.SearchAllResourcesResponse;
import com.google.cloud.asset.v1p1beta1.StandardResourceMetadata;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link AssetServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (cloudasset.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of searchAllResources to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AssetServiceStubSettings.Builder assetServiceSettingsBuilder =
 *     AssetServiceStubSettings.newBuilder();
 * assetServiceSettingsBuilder
 *     .searchAllResourcesSettings()
 *     .setRetrySettings(
 *         assetServiceSettingsBuilder
 *             .searchAllResourcesSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * AssetServiceStubSettings assetServiceSettings = assetServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class AssetServiceStubSettings extends StubSettings<AssetServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          SearchAllResourcesRequest, SearchAllResourcesResponse, SearchAllResourcesPagedResponse>
      searchAllResourcesSettings;
  private final PagedCallSettings<
          SearchAllIamPoliciesRequest,
          SearchAllIamPoliciesResponse,
          SearchAllIamPoliciesPagedResponse>
      searchAllIamPoliciesSettings;

  private static final PagedListDescriptor<
          SearchAllResourcesRequest, SearchAllResourcesResponse, StandardResourceMetadata>
      SEARCH_ALL_RESOURCES_PAGE_STR_DESC =
          new PagedListDescriptor<
              SearchAllResourcesRequest, SearchAllResourcesResponse, StandardResourceMetadata>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public SearchAllResourcesRequest injectToken(
                SearchAllResourcesRequest payload, String token) {
              return SearchAllResourcesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public SearchAllResourcesRequest injectPageSize(
                SearchAllResourcesRequest payload, int pageSize) {
              return SearchAllResourcesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(SearchAllResourcesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(SearchAllResourcesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<StandardResourceMetadata> extractResources(
                SearchAllResourcesResponse payload) {
              return payload.getResultsList() == null
                  ? ImmutableList.<StandardResourceMetadata>of()
                  : payload.getResultsList();
            }
          };

  private static final PagedListDescriptor<
          SearchAllIamPoliciesRequest, SearchAllIamPoliciesResponse, IamPolicySearchResult>
      SEARCH_ALL_IAM_POLICIES_PAGE_STR_DESC =
          new PagedListDescriptor<
              SearchAllIamPoliciesRequest, SearchAllIamPoliciesResponse, IamPolicySearchResult>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public SearchAllIamPoliciesRequest injectToken(
                SearchAllIamPoliciesRequest payload, String token) {
              return SearchAllIamPoliciesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public SearchAllIamPoliciesRequest injectPageSize(
                SearchAllIamPoliciesRequest payload, int pageSize) {
              return SearchAllIamPoliciesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(SearchAllIamPoliciesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(SearchAllIamPoliciesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<IamPolicySearchResult> extractResources(
                SearchAllIamPoliciesResponse payload) {
              return payload.getResultsList() == null
                  ? ImmutableList.<IamPolicySearchResult>of()
                  : payload.getResultsList();
            }
          };

  private static final PagedListResponseFactory<
          SearchAllResourcesRequest, SearchAllResourcesResponse, SearchAllResourcesPagedResponse>
      SEARCH_ALL_RESOURCES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              SearchAllResourcesRequest,
              SearchAllResourcesResponse,
              SearchAllResourcesPagedResponse>() {
            @Override
            public ApiFuture<SearchAllResourcesPagedResponse> getFuturePagedResponse(
                UnaryCallable<SearchAllResourcesRequest, SearchAllResourcesResponse> callable,
                SearchAllResourcesRequest request,
                ApiCallContext context,
                ApiFuture<SearchAllResourcesResponse> futureResponse) {
              PageContext<
                      SearchAllResourcesRequest,
                      SearchAllResourcesResponse,
                      StandardResourceMetadata>
                  pageContext =
                      PageContext.create(
                          callable, SEARCH_ALL_RESOURCES_PAGE_STR_DESC, request, context);
              return SearchAllResourcesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          SearchAllIamPoliciesRequest,
          SearchAllIamPoliciesResponse,
          SearchAllIamPoliciesPagedResponse>
      SEARCH_ALL_IAM_POLICIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              SearchAllIamPoliciesRequest,
              SearchAllIamPoliciesResponse,
              SearchAllIamPoliciesPagedResponse>() {
            @Override
            public ApiFuture<SearchAllIamPoliciesPagedResponse> getFuturePagedResponse(
                UnaryCallable<SearchAllIamPoliciesRequest, SearchAllIamPoliciesResponse> callable,
                SearchAllIamPoliciesRequest request,
                ApiCallContext context,
                ApiFuture<SearchAllIamPoliciesResponse> futureResponse) {
              PageContext<
                      SearchAllIamPoliciesRequest,
                      SearchAllIamPoliciesResponse,
                      IamPolicySearchResult>
                  pageContext =
                      PageContext.create(
                          callable, SEARCH_ALL_IAM_POLICIES_PAGE_STR_DESC, request, context);
              return SearchAllIamPoliciesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to searchAllResources. */
  public PagedCallSettings<
          SearchAllResourcesRequest, SearchAllResourcesResponse, SearchAllResourcesPagedResponse>
      searchAllResourcesSettings() {
    return searchAllResourcesSettings;
  }

  /** Returns the object with the settings used for calls to searchAllIamPolicies. */
  public PagedCallSettings<
          SearchAllIamPoliciesRequest,
          SearchAllIamPoliciesResponse,
          SearchAllIamPoliciesPagedResponse>
      searchAllIamPoliciesSettings() {
    return searchAllIamPoliciesSettings;
  }

  public AssetServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcAssetServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonAssetServiceStub.create(this);
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
    return "cloudasset.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "cloudasset.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(AssetServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(AssetServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return AssetServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected AssetServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    searchAllResourcesSettings = settingsBuilder.searchAllResourcesSettings().build();
    searchAllIamPoliciesSettings = settingsBuilder.searchAllIamPoliciesSettings().build();
  }

  /** Builder for AssetServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<AssetServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            SearchAllResourcesRequest, SearchAllResourcesResponse, SearchAllResourcesPagedResponse>
        searchAllResourcesSettings;
    private final PagedCallSettings.Builder<
            SearchAllIamPoliciesRequest,
            SearchAllIamPoliciesResponse,
            SearchAllIamPoliciesPagedResponse>
        searchAllIamPoliciesSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(15000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(15000L))
              .setTotalTimeout(Duration.ofMillis(15000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      searchAllResourcesSettings = PagedCallSettings.newBuilder(SEARCH_ALL_RESOURCES_PAGE_STR_FACT);
      searchAllIamPoliciesSettings =
          PagedCallSettings.newBuilder(SEARCH_ALL_IAM_POLICIES_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              searchAllResourcesSettings, searchAllIamPoliciesSettings);
      initDefaults(this);
    }

    protected Builder(AssetServiceStubSettings settings) {
      super(settings);

      searchAllResourcesSettings = settings.searchAllResourcesSettings.toBuilder();
      searchAllIamPoliciesSettings = settings.searchAllIamPoliciesSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              searchAllResourcesSettings, searchAllIamPoliciesSettings);
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
          .searchAllResourcesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .searchAllIamPoliciesSettings()
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

    /** Returns the builder for the settings used for calls to searchAllResources. */
    public PagedCallSettings.Builder<
            SearchAllResourcesRequest, SearchAllResourcesResponse, SearchAllResourcesPagedResponse>
        searchAllResourcesSettings() {
      return searchAllResourcesSettings;
    }

    /** Returns the builder for the settings used for calls to searchAllIamPolicies. */
    public PagedCallSettings.Builder<
            SearchAllIamPoliciesRequest,
            SearchAllIamPoliciesResponse,
            SearchAllIamPoliciesPagedResponse>
        searchAllIamPoliciesSettings() {
      return searchAllIamPoliciesSettings;
    }

    @Override
    public AssetServiceStubSettings build() throws IOException {
      return new AssetServiceStubSettings(this);
    }
  }
}
