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

package com.google.cloud.asset.v1;

import static com.google.cloud.asset.v1.AssetServiceClient.ListAssetsPagedResponse;
import static com.google.cloud.asset.v1.AssetServiceClient.ListSavedQueriesPagedResponse;
import static com.google.cloud.asset.v1.AssetServiceClient.SearchAllIamPoliciesPagedResponse;
import static com.google.cloud.asset.v1.AssetServiceClient.SearchAllResourcesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.asset.v1.stub.AssetServiceStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link AssetServiceClient}.
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
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AssetServiceSettings.Builder assetServiceSettingsBuilder = AssetServiceSettings.newBuilder();
 * assetServiceSettingsBuilder
 *     .batchGetAssetsHistorySettings()
 *     .setRetrySettings(
 *         assetServiceSettingsBuilder
 *             .batchGetAssetsHistorySettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * AssetServiceSettings assetServiceSettings = assetServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class AssetServiceSettings extends ClientSettings<AssetServiceSettings> {

  /** Returns the object with the settings used for calls to exportAssets. */
  public UnaryCallSettings<ExportAssetsRequest, Operation> exportAssetsSettings() {
    return ((AssetServiceStubSettings) getStubSettings()).exportAssetsSettings();
  }

  /** Returns the object with the settings used for calls to exportAssets. */
  public OperationCallSettings<ExportAssetsRequest, ExportAssetsResponse, ExportAssetsRequest>
      exportAssetsOperationSettings() {
    return ((AssetServiceStubSettings) getStubSettings()).exportAssetsOperationSettings();
  }

  /** Returns the object with the settings used for calls to listAssets. */
  public PagedCallSettings<ListAssetsRequest, ListAssetsResponse, ListAssetsPagedResponse>
      listAssetsSettings() {
    return ((AssetServiceStubSettings) getStubSettings()).listAssetsSettings();
  }

  /** Returns the object with the settings used for calls to batchGetAssetsHistory. */
  public UnaryCallSettings<BatchGetAssetsHistoryRequest, BatchGetAssetsHistoryResponse>
      batchGetAssetsHistorySettings() {
    return ((AssetServiceStubSettings) getStubSettings()).batchGetAssetsHistorySettings();
  }

  /** Returns the object with the settings used for calls to createFeed. */
  public UnaryCallSettings<CreateFeedRequest, Feed> createFeedSettings() {
    return ((AssetServiceStubSettings) getStubSettings()).createFeedSettings();
  }

  /** Returns the object with the settings used for calls to getFeed. */
  public UnaryCallSettings<GetFeedRequest, Feed> getFeedSettings() {
    return ((AssetServiceStubSettings) getStubSettings()).getFeedSettings();
  }

  /** Returns the object with the settings used for calls to listFeeds. */
  public UnaryCallSettings<ListFeedsRequest, ListFeedsResponse> listFeedsSettings() {
    return ((AssetServiceStubSettings) getStubSettings()).listFeedsSettings();
  }

  /** Returns the object with the settings used for calls to updateFeed. */
  public UnaryCallSettings<UpdateFeedRequest, Feed> updateFeedSettings() {
    return ((AssetServiceStubSettings) getStubSettings()).updateFeedSettings();
  }

  /** Returns the object with the settings used for calls to deleteFeed. */
  public UnaryCallSettings<DeleteFeedRequest, Empty> deleteFeedSettings() {
    return ((AssetServiceStubSettings) getStubSettings()).deleteFeedSettings();
  }

  /** Returns the object with the settings used for calls to searchAllResources. */
  public PagedCallSettings<
          SearchAllResourcesRequest, SearchAllResourcesResponse, SearchAllResourcesPagedResponse>
      searchAllResourcesSettings() {
    return ((AssetServiceStubSettings) getStubSettings()).searchAllResourcesSettings();
  }

  /** Returns the object with the settings used for calls to searchAllIamPolicies. */
  public PagedCallSettings<
          SearchAllIamPoliciesRequest,
          SearchAllIamPoliciesResponse,
          SearchAllIamPoliciesPagedResponse>
      searchAllIamPoliciesSettings() {
    return ((AssetServiceStubSettings) getStubSettings()).searchAllIamPoliciesSettings();
  }

  /** Returns the object with the settings used for calls to analyzeIamPolicy. */
  public UnaryCallSettings<AnalyzeIamPolicyRequest, AnalyzeIamPolicyResponse>
      analyzeIamPolicySettings() {
    return ((AssetServiceStubSettings) getStubSettings()).analyzeIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to analyzeIamPolicyLongrunning. */
  public UnaryCallSettings<AnalyzeIamPolicyLongrunningRequest, Operation>
      analyzeIamPolicyLongrunningSettings() {
    return ((AssetServiceStubSettings) getStubSettings()).analyzeIamPolicyLongrunningSettings();
  }

  /** Returns the object with the settings used for calls to analyzeIamPolicyLongrunning. */
  public OperationCallSettings<
          AnalyzeIamPolicyLongrunningRequest,
          AnalyzeIamPolicyLongrunningResponse,
          AnalyzeIamPolicyLongrunningMetadata>
      analyzeIamPolicyLongrunningOperationSettings() {
    return ((AssetServiceStubSettings) getStubSettings())
        .analyzeIamPolicyLongrunningOperationSettings();
  }

  /** Returns the object with the settings used for calls to analyzeMove. */
  public UnaryCallSettings<AnalyzeMoveRequest, AnalyzeMoveResponse> analyzeMoveSettings() {
    return ((AssetServiceStubSettings) getStubSettings()).analyzeMoveSettings();
  }

  /** Returns the object with the settings used for calls to queryAssets. */
  public UnaryCallSettings<QueryAssetsRequest, QueryAssetsResponse> queryAssetsSettings() {
    return ((AssetServiceStubSettings) getStubSettings()).queryAssetsSettings();
  }

  /** Returns the object with the settings used for calls to createSavedQuery. */
  public UnaryCallSettings<CreateSavedQueryRequest, SavedQuery> createSavedQuerySettings() {
    return ((AssetServiceStubSettings) getStubSettings()).createSavedQuerySettings();
  }

  /** Returns the object with the settings used for calls to getSavedQuery. */
  public UnaryCallSettings<GetSavedQueryRequest, SavedQuery> getSavedQuerySettings() {
    return ((AssetServiceStubSettings) getStubSettings()).getSavedQuerySettings();
  }

  /** Returns the object with the settings used for calls to listSavedQueries. */
  public PagedCallSettings<
          ListSavedQueriesRequest, ListSavedQueriesResponse, ListSavedQueriesPagedResponse>
      listSavedQueriesSettings() {
    return ((AssetServiceStubSettings) getStubSettings()).listSavedQueriesSettings();
  }

  /** Returns the object with the settings used for calls to updateSavedQuery. */
  public UnaryCallSettings<UpdateSavedQueryRequest, SavedQuery> updateSavedQuerySettings() {
    return ((AssetServiceStubSettings) getStubSettings()).updateSavedQuerySettings();
  }

  /** Returns the object with the settings used for calls to deleteSavedQuery. */
  public UnaryCallSettings<DeleteSavedQueryRequest, Empty> deleteSavedQuerySettings() {
    return ((AssetServiceStubSettings) getStubSettings()).deleteSavedQuerySettings();
  }

  /** Returns the object with the settings used for calls to batchGetEffectiveIamPolicies. */
  public UnaryCallSettings<
          BatchGetEffectiveIamPoliciesRequest, BatchGetEffectiveIamPoliciesResponse>
      batchGetEffectiveIamPoliciesSettings() {
    return ((AssetServiceStubSettings) getStubSettings()).batchGetEffectiveIamPoliciesSettings();
  }

  public static final AssetServiceSettings create(AssetServiceStubSettings stub)
      throws IOException {
    return new AssetServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return AssetServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return AssetServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return AssetServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return AssetServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return AssetServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return AssetServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return AssetServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return AssetServiceStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
  @BetaApi
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

  protected AssetServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for AssetServiceSettings. */
  public static class Builder extends ClientSettings.Builder<AssetServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(AssetServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(AssetServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(AssetServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(AssetServiceStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(AssetServiceStubSettings.newHttpJsonBuilder());
    }

    public AssetServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((AssetServiceStubSettings.Builder) getStubSettings());
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(
          getStubSettingsBuilder().unaryMethodSettingsBuilders(), settingsUpdater);
      return this;
    }

    /** Returns the builder for the settings used for calls to exportAssets. */
    public UnaryCallSettings.Builder<ExportAssetsRequest, Operation> exportAssetsSettings() {
      return getStubSettingsBuilder().exportAssetsSettings();
    }

    /** Returns the builder for the settings used for calls to exportAssets. */
    public OperationCallSettings.Builder<
            ExportAssetsRequest, ExportAssetsResponse, ExportAssetsRequest>
        exportAssetsOperationSettings() {
      return getStubSettingsBuilder().exportAssetsOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listAssets. */
    public PagedCallSettings.Builder<ListAssetsRequest, ListAssetsResponse, ListAssetsPagedResponse>
        listAssetsSettings() {
      return getStubSettingsBuilder().listAssetsSettings();
    }

    /** Returns the builder for the settings used for calls to batchGetAssetsHistory. */
    public UnaryCallSettings.Builder<BatchGetAssetsHistoryRequest, BatchGetAssetsHistoryResponse>
        batchGetAssetsHistorySettings() {
      return getStubSettingsBuilder().batchGetAssetsHistorySettings();
    }

    /** Returns the builder for the settings used for calls to createFeed. */
    public UnaryCallSettings.Builder<CreateFeedRequest, Feed> createFeedSettings() {
      return getStubSettingsBuilder().createFeedSettings();
    }

    /** Returns the builder for the settings used for calls to getFeed. */
    public UnaryCallSettings.Builder<GetFeedRequest, Feed> getFeedSettings() {
      return getStubSettingsBuilder().getFeedSettings();
    }

    /** Returns the builder for the settings used for calls to listFeeds. */
    public UnaryCallSettings.Builder<ListFeedsRequest, ListFeedsResponse> listFeedsSettings() {
      return getStubSettingsBuilder().listFeedsSettings();
    }

    /** Returns the builder for the settings used for calls to updateFeed. */
    public UnaryCallSettings.Builder<UpdateFeedRequest, Feed> updateFeedSettings() {
      return getStubSettingsBuilder().updateFeedSettings();
    }

    /** Returns the builder for the settings used for calls to deleteFeed. */
    public UnaryCallSettings.Builder<DeleteFeedRequest, Empty> deleteFeedSettings() {
      return getStubSettingsBuilder().deleteFeedSettings();
    }

    /** Returns the builder for the settings used for calls to searchAllResources. */
    public PagedCallSettings.Builder<
            SearchAllResourcesRequest, SearchAllResourcesResponse, SearchAllResourcesPagedResponse>
        searchAllResourcesSettings() {
      return getStubSettingsBuilder().searchAllResourcesSettings();
    }

    /** Returns the builder for the settings used for calls to searchAllIamPolicies. */
    public PagedCallSettings.Builder<
            SearchAllIamPoliciesRequest,
            SearchAllIamPoliciesResponse,
            SearchAllIamPoliciesPagedResponse>
        searchAllIamPoliciesSettings() {
      return getStubSettingsBuilder().searchAllIamPoliciesSettings();
    }

    /** Returns the builder for the settings used for calls to analyzeIamPolicy. */
    public UnaryCallSettings.Builder<AnalyzeIamPolicyRequest, AnalyzeIamPolicyResponse>
        analyzeIamPolicySettings() {
      return getStubSettingsBuilder().analyzeIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to analyzeIamPolicyLongrunning. */
    public UnaryCallSettings.Builder<AnalyzeIamPolicyLongrunningRequest, Operation>
        analyzeIamPolicyLongrunningSettings() {
      return getStubSettingsBuilder().analyzeIamPolicyLongrunningSettings();
    }

    /** Returns the builder for the settings used for calls to analyzeIamPolicyLongrunning. */
    public OperationCallSettings.Builder<
            AnalyzeIamPolicyLongrunningRequest,
            AnalyzeIamPolicyLongrunningResponse,
            AnalyzeIamPolicyLongrunningMetadata>
        analyzeIamPolicyLongrunningOperationSettings() {
      return getStubSettingsBuilder().analyzeIamPolicyLongrunningOperationSettings();
    }

    /** Returns the builder for the settings used for calls to analyzeMove. */
    public UnaryCallSettings.Builder<AnalyzeMoveRequest, AnalyzeMoveResponse>
        analyzeMoveSettings() {
      return getStubSettingsBuilder().analyzeMoveSettings();
    }

    /** Returns the builder for the settings used for calls to queryAssets. */
    public UnaryCallSettings.Builder<QueryAssetsRequest, QueryAssetsResponse>
        queryAssetsSettings() {
      return getStubSettingsBuilder().queryAssetsSettings();
    }

    /** Returns the builder for the settings used for calls to createSavedQuery. */
    public UnaryCallSettings.Builder<CreateSavedQueryRequest, SavedQuery>
        createSavedQuerySettings() {
      return getStubSettingsBuilder().createSavedQuerySettings();
    }

    /** Returns the builder for the settings used for calls to getSavedQuery. */
    public UnaryCallSettings.Builder<GetSavedQueryRequest, SavedQuery> getSavedQuerySettings() {
      return getStubSettingsBuilder().getSavedQuerySettings();
    }

    /** Returns the builder for the settings used for calls to listSavedQueries. */
    public PagedCallSettings.Builder<
            ListSavedQueriesRequest, ListSavedQueriesResponse, ListSavedQueriesPagedResponse>
        listSavedQueriesSettings() {
      return getStubSettingsBuilder().listSavedQueriesSettings();
    }

    /** Returns the builder for the settings used for calls to updateSavedQuery. */
    public UnaryCallSettings.Builder<UpdateSavedQueryRequest, SavedQuery>
        updateSavedQuerySettings() {
      return getStubSettingsBuilder().updateSavedQuerySettings();
    }

    /** Returns the builder for the settings used for calls to deleteSavedQuery. */
    public UnaryCallSettings.Builder<DeleteSavedQueryRequest, Empty> deleteSavedQuerySettings() {
      return getStubSettingsBuilder().deleteSavedQuerySettings();
    }

    /** Returns the builder for the settings used for calls to batchGetEffectiveIamPolicies. */
    public UnaryCallSettings.Builder<
            BatchGetEffectiveIamPoliciesRequest, BatchGetEffectiveIamPoliciesResponse>
        batchGetEffectiveIamPoliciesSettings() {
      return getStubSettingsBuilder().batchGetEffectiveIamPoliciesSettings();
    }

    @Override
    public AssetServiceSettings build() throws IOException {
      return new AssetServiceSettings(this);
    }
  }
}
