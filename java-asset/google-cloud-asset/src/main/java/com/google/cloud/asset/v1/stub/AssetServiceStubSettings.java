/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.asset.v1.stub;

import static com.google.cloud.asset.v1.AssetServiceClient.SearchAllIamPoliciesPagedResponse;
import static com.google.cloud.asset.v1.AssetServiceClient.SearchAllResourcesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.grpc.ProtoOperationTransformers;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.longrunning.OperationTimedPollAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.asset.v1.AnalyzeIamPolicyLongrunningRequest;
import com.google.cloud.asset.v1.AnalyzeIamPolicyLongrunningResponse;
import com.google.cloud.asset.v1.AnalyzeIamPolicyRequest;
import com.google.cloud.asset.v1.AnalyzeIamPolicyResponse;
import com.google.cloud.asset.v1.BatchGetAssetsHistoryRequest;
import com.google.cloud.asset.v1.BatchGetAssetsHistoryResponse;
import com.google.cloud.asset.v1.CreateFeedRequest;
import com.google.cloud.asset.v1.DeleteFeedRequest;
import com.google.cloud.asset.v1.ExportAssetsRequest;
import com.google.cloud.asset.v1.ExportAssetsResponse;
import com.google.cloud.asset.v1.Feed;
import com.google.cloud.asset.v1.GetFeedRequest;
import com.google.cloud.asset.v1.IamPolicySearchResult;
import com.google.cloud.asset.v1.ListFeedsRequest;
import com.google.cloud.asset.v1.ListFeedsResponse;
import com.google.cloud.asset.v1.ResourceSearchResult;
import com.google.cloud.asset.v1.SearchAllIamPoliciesRequest;
import com.google.cloud.asset.v1.SearchAllIamPoliciesResponse;
import com.google.cloud.asset.v1.SearchAllResourcesRequest;
import com.google.cloud.asset.v1.SearchAllResourcesResponse;
import com.google.cloud.asset.v1.UpdateFeedRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
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
 * <p>For example, to set the total timeout of batchGetAssetsHistory to 30 seconds:
 *
 * <pre>{@code
 * AssetServiceStubSettings.Builder assetServiceSettingsBuilder =
 *     AssetServiceStubSettings.newBuilder();
 * assetServiceSettingsBuilder
 *     .batchGetAssetsHistorySettings()
 *     .setRetrySettings(
 *         assetServiceSettingsBuilder
 *             .batchGetAssetsHistorySettings()
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

  private final UnaryCallSettings<ExportAssetsRequest, Operation> exportAssetsSettings;
  private final OperationCallSettings<
          ExportAssetsRequest, ExportAssetsResponse, ExportAssetsRequest>
      exportAssetsOperationSettings;
  private final UnaryCallSettings<BatchGetAssetsHistoryRequest, BatchGetAssetsHistoryResponse>
      batchGetAssetsHistorySettings;
  private final UnaryCallSettings<CreateFeedRequest, Feed> createFeedSettings;
  private final UnaryCallSettings<GetFeedRequest, Feed> getFeedSettings;
  private final UnaryCallSettings<ListFeedsRequest, ListFeedsResponse> listFeedsSettings;
  private final UnaryCallSettings<UpdateFeedRequest, Feed> updateFeedSettings;
  private final UnaryCallSettings<DeleteFeedRequest, Empty> deleteFeedSettings;
  private final PagedCallSettings<
          SearchAllResourcesRequest, SearchAllResourcesResponse, SearchAllResourcesPagedResponse>
      searchAllResourcesSettings;
  private final PagedCallSettings<
          SearchAllIamPoliciesRequest,
          SearchAllIamPoliciesResponse,
          SearchAllIamPoliciesPagedResponse>
      searchAllIamPoliciesSettings;
  private final UnaryCallSettings<AnalyzeIamPolicyRequest, AnalyzeIamPolicyResponse>
      analyzeIamPolicySettings;
  private final UnaryCallSettings<AnalyzeIamPolicyLongrunningRequest, Operation>
      analyzeIamPolicyLongrunningSettings;
  private final OperationCallSettings<
          AnalyzeIamPolicyLongrunningRequest,
          AnalyzeIamPolicyLongrunningResponse,
          AnalyzeIamPolicyLongrunningRequest>
      analyzeIamPolicyLongrunningOperationSettings;

  private static final PagedListDescriptor<
          SearchAllResourcesRequest, SearchAllResourcesResponse, ResourceSearchResult>
      SEARCH_ALL_RESOURCES_PAGE_STR_DESC =
          new PagedListDescriptor<
              SearchAllResourcesRequest, SearchAllResourcesResponse, ResourceSearchResult>() {
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
            public Iterable<ResourceSearchResult> extractResources(
                SearchAllResourcesResponse payload) {
              return payload.getResultsList() == null
                  ? ImmutableList.<ResourceSearchResult>of()
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
                      SearchAllResourcesRequest, SearchAllResourcesResponse, ResourceSearchResult>
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

  /** Returns the object with the settings used for calls to exportAssets. */
  public UnaryCallSettings<ExportAssetsRequest, Operation> exportAssetsSettings() {
    return exportAssetsSettings;
  }

  /** Returns the object with the settings used for calls to exportAssets. */
  public OperationCallSettings<ExportAssetsRequest, ExportAssetsResponse, ExportAssetsRequest>
      exportAssetsOperationSettings() {
    return exportAssetsOperationSettings;
  }

  /** Returns the object with the settings used for calls to batchGetAssetsHistory. */
  public UnaryCallSettings<BatchGetAssetsHistoryRequest, BatchGetAssetsHistoryResponse>
      batchGetAssetsHistorySettings() {
    return batchGetAssetsHistorySettings;
  }

  /** Returns the object with the settings used for calls to createFeed. */
  public UnaryCallSettings<CreateFeedRequest, Feed> createFeedSettings() {
    return createFeedSettings;
  }

  /** Returns the object with the settings used for calls to getFeed. */
  public UnaryCallSettings<GetFeedRequest, Feed> getFeedSettings() {
    return getFeedSettings;
  }

  /** Returns the object with the settings used for calls to listFeeds. */
  public UnaryCallSettings<ListFeedsRequest, ListFeedsResponse> listFeedsSettings() {
    return listFeedsSettings;
  }

  /** Returns the object with the settings used for calls to updateFeed. */
  public UnaryCallSettings<UpdateFeedRequest, Feed> updateFeedSettings() {
    return updateFeedSettings;
  }

  /** Returns the object with the settings used for calls to deleteFeed. */
  public UnaryCallSettings<DeleteFeedRequest, Empty> deleteFeedSettings() {
    return deleteFeedSettings;
  }

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

  /** Returns the object with the settings used for calls to analyzeIamPolicy. */
  public UnaryCallSettings<AnalyzeIamPolicyRequest, AnalyzeIamPolicyResponse>
      analyzeIamPolicySettings() {
    return analyzeIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to analyzeIamPolicyLongrunning. */
  public UnaryCallSettings<AnalyzeIamPolicyLongrunningRequest, Operation>
      analyzeIamPolicyLongrunningSettings() {
    return analyzeIamPolicyLongrunningSettings;
  }

  /** Returns the object with the settings used for calls to analyzeIamPolicyLongrunning. */
  public OperationCallSettings<
          AnalyzeIamPolicyLongrunningRequest,
          AnalyzeIamPolicyLongrunningResponse,
          AnalyzeIamPolicyLongrunningRequest>
      analyzeIamPolicyLongrunningOperationSettings() {
    return analyzeIamPolicyLongrunningOperationSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public AssetServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcAssetServiceStub.create(this);
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

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder().setScopesToApply(DEFAULT_SERVICE_SCOPES);
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(AssetServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
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

  protected AssetServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    exportAssetsSettings = settingsBuilder.exportAssetsSettings().build();
    exportAssetsOperationSettings = settingsBuilder.exportAssetsOperationSettings().build();
    batchGetAssetsHistorySettings = settingsBuilder.batchGetAssetsHistorySettings().build();
    createFeedSettings = settingsBuilder.createFeedSettings().build();
    getFeedSettings = settingsBuilder.getFeedSettings().build();
    listFeedsSettings = settingsBuilder.listFeedsSettings().build();
    updateFeedSettings = settingsBuilder.updateFeedSettings().build();
    deleteFeedSettings = settingsBuilder.deleteFeedSettings().build();
    searchAllResourcesSettings = settingsBuilder.searchAllResourcesSettings().build();
    searchAllIamPoliciesSettings = settingsBuilder.searchAllIamPoliciesSettings().build();
    analyzeIamPolicySettings = settingsBuilder.analyzeIamPolicySettings().build();
    analyzeIamPolicyLongrunningSettings =
        settingsBuilder.analyzeIamPolicyLongrunningSettings().build();
    analyzeIamPolicyLongrunningOperationSettings =
        settingsBuilder.analyzeIamPolicyLongrunningOperationSettings().build();
  }

  /** Builder for AssetServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<AssetServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<ExportAssetsRequest, Operation> exportAssetsSettings;
    private final OperationCallSettings.Builder<
            ExportAssetsRequest, ExportAssetsResponse, ExportAssetsRequest>
        exportAssetsOperationSettings;
    private final UnaryCallSettings.Builder<
            BatchGetAssetsHistoryRequest, BatchGetAssetsHistoryResponse>
        batchGetAssetsHistorySettings;
    private final UnaryCallSettings.Builder<CreateFeedRequest, Feed> createFeedSettings;
    private final UnaryCallSettings.Builder<GetFeedRequest, Feed> getFeedSettings;
    private final UnaryCallSettings.Builder<ListFeedsRequest, ListFeedsResponse> listFeedsSettings;
    private final UnaryCallSettings.Builder<UpdateFeedRequest, Feed> updateFeedSettings;
    private final UnaryCallSettings.Builder<DeleteFeedRequest, Empty> deleteFeedSettings;
    private final PagedCallSettings.Builder<
            SearchAllResourcesRequest, SearchAllResourcesResponse, SearchAllResourcesPagedResponse>
        searchAllResourcesSettings;
    private final PagedCallSettings.Builder<
            SearchAllIamPoliciesRequest,
            SearchAllIamPoliciesResponse,
            SearchAllIamPoliciesPagedResponse>
        searchAllIamPoliciesSettings;
    private final UnaryCallSettings.Builder<AnalyzeIamPolicyRequest, AnalyzeIamPolicyResponse>
        analyzeIamPolicySettings;
    private final UnaryCallSettings.Builder<AnalyzeIamPolicyLongrunningRequest, Operation>
        analyzeIamPolicyLongrunningSettings;
    private final OperationCallSettings.Builder<
            AnalyzeIamPolicyLongrunningRequest,
            AnalyzeIamPolicyLongrunningResponse,
            AnalyzeIamPolicyLongrunningRequest>
        analyzeIamPolicyLongrunningOperationSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_0_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "retry_policy_1_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "retry_policy_2_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "retry_policy_3_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
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
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_1_params", settings);
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
      definitions.put("retry_policy_2_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(300000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(300000L))
              .setTotalTimeout(Duration.ofMillis(300000L))
              .build();
      definitions.put("retry_policy_3_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      exportAssetsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      exportAssetsOperationSettings = OperationCallSettings.newBuilder();
      batchGetAssetsHistorySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createFeedSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getFeedSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listFeedsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateFeedSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteFeedSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      searchAllResourcesSettings = PagedCallSettings.newBuilder(SEARCH_ALL_RESOURCES_PAGE_STR_FACT);
      searchAllIamPoliciesSettings =
          PagedCallSettings.newBuilder(SEARCH_ALL_IAM_POLICIES_PAGE_STR_FACT);
      analyzeIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      analyzeIamPolicyLongrunningSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      analyzeIamPolicyLongrunningOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              exportAssetsSettings,
              batchGetAssetsHistorySettings,
              createFeedSettings,
              getFeedSettings,
              listFeedsSettings,
              updateFeedSettings,
              deleteFeedSettings,
              searchAllResourcesSettings,
              searchAllIamPoliciesSettings,
              analyzeIamPolicySettings,
              analyzeIamPolicyLongrunningSettings);
      initDefaults(this);
    }

    protected Builder(AssetServiceStubSettings settings) {
      super(settings);

      exportAssetsSettings = settings.exportAssetsSettings.toBuilder();
      exportAssetsOperationSettings = settings.exportAssetsOperationSettings.toBuilder();
      batchGetAssetsHistorySettings = settings.batchGetAssetsHistorySettings.toBuilder();
      createFeedSettings = settings.createFeedSettings.toBuilder();
      getFeedSettings = settings.getFeedSettings.toBuilder();
      listFeedsSettings = settings.listFeedsSettings.toBuilder();
      updateFeedSettings = settings.updateFeedSettings.toBuilder();
      deleteFeedSettings = settings.deleteFeedSettings.toBuilder();
      searchAllResourcesSettings = settings.searchAllResourcesSettings.toBuilder();
      searchAllIamPoliciesSettings = settings.searchAllIamPoliciesSettings.toBuilder();
      analyzeIamPolicySettings = settings.analyzeIamPolicySettings.toBuilder();
      analyzeIamPolicyLongrunningSettings =
          settings.analyzeIamPolicyLongrunningSettings.toBuilder();
      analyzeIamPolicyLongrunningOperationSettings =
          settings.analyzeIamPolicyLongrunningOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              exportAssetsSettings,
              batchGetAssetsHistorySettings,
              createFeedSettings,
              getFeedSettings,
              listFeedsSettings,
              updateFeedSettings,
              deleteFeedSettings,
              searchAllResourcesSettings,
              searchAllIamPoliciesSettings,
              analyzeIamPolicySettings,
              analyzeIamPolicyLongrunningSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .exportAssetsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .batchGetAssetsHistorySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .createFeedSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getFeedSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .listFeedsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .updateFeedSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteFeedSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .searchAllResourcesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_2_params"));

      builder
          .searchAllIamPoliciesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_2_params"));

      builder
          .analyzeIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_3_params"));

      builder
          .analyzeIamPolicyLongrunningSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .exportAssetsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ExportAssetsRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ExportAssetsResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(ExportAssetsRequest.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .analyzeIamPolicyLongrunningOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<AnalyzeIamPolicyLongrunningRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  AnalyzeIamPolicyLongrunningResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  AnalyzeIamPolicyLongrunningRequest.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      return builder;
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'.
    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) throws Exception {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
    }

    /** Returns the builder for the settings used for calls to exportAssets. */
    public UnaryCallSettings.Builder<ExportAssetsRequest, Operation> exportAssetsSettings() {
      return exportAssetsSettings;
    }

    /** Returns the builder for the settings used for calls to exportAssets. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            ExportAssetsRequest, ExportAssetsResponse, ExportAssetsRequest>
        exportAssetsOperationSettings() {
      return exportAssetsOperationSettings;
    }

    /** Returns the builder for the settings used for calls to batchGetAssetsHistory. */
    public UnaryCallSettings.Builder<BatchGetAssetsHistoryRequest, BatchGetAssetsHistoryResponse>
        batchGetAssetsHistorySettings() {
      return batchGetAssetsHistorySettings;
    }

    /** Returns the builder for the settings used for calls to createFeed. */
    public UnaryCallSettings.Builder<CreateFeedRequest, Feed> createFeedSettings() {
      return createFeedSettings;
    }

    /** Returns the builder for the settings used for calls to getFeed. */
    public UnaryCallSettings.Builder<GetFeedRequest, Feed> getFeedSettings() {
      return getFeedSettings;
    }

    /** Returns the builder for the settings used for calls to listFeeds. */
    public UnaryCallSettings.Builder<ListFeedsRequest, ListFeedsResponse> listFeedsSettings() {
      return listFeedsSettings;
    }

    /** Returns the builder for the settings used for calls to updateFeed. */
    public UnaryCallSettings.Builder<UpdateFeedRequest, Feed> updateFeedSettings() {
      return updateFeedSettings;
    }

    /** Returns the builder for the settings used for calls to deleteFeed. */
    public UnaryCallSettings.Builder<DeleteFeedRequest, Empty> deleteFeedSettings() {
      return deleteFeedSettings;
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

    /** Returns the builder for the settings used for calls to analyzeIamPolicy. */
    public UnaryCallSettings.Builder<AnalyzeIamPolicyRequest, AnalyzeIamPolicyResponse>
        analyzeIamPolicySettings() {
      return analyzeIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to analyzeIamPolicyLongrunning. */
    public UnaryCallSettings.Builder<AnalyzeIamPolicyLongrunningRequest, Operation>
        analyzeIamPolicyLongrunningSettings() {
      return analyzeIamPolicyLongrunningSettings;
    }

    /** Returns the builder for the settings used for calls to analyzeIamPolicyLongrunning. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            AnalyzeIamPolicyLongrunningRequest,
            AnalyzeIamPolicyLongrunningResponse,
            AnalyzeIamPolicyLongrunningRequest>
        analyzeIamPolicyLongrunningOperationSettings() {
      return analyzeIamPolicyLongrunningOperationSettings;
    }

    @Override
    public AssetServiceStubSettings build() throws IOException {
      return new AssetServiceStubSettings(this);
    }
  }
}
