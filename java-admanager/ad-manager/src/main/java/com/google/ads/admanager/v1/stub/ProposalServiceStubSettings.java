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

import static com.google.ads.admanager.v1.ProposalServiceClient.FetchMarketplaceCommentsPagedResponse;
import static com.google.ads.admanager.v1.ProposalServiceClient.ListProposalsPagedResponse;

import com.google.ads.admanager.v1.BatchArchiveProposalsRequest;
import com.google.ads.admanager.v1.BatchArchiveProposalsResponse;
import com.google.ads.admanager.v1.BatchCreateProposalsRequest;
import com.google.ads.admanager.v1.BatchCreateProposalsResponse;
import com.google.ads.admanager.v1.BatchDiscardDraftProposalsRequest;
import com.google.ads.admanager.v1.BatchDiscardDraftProposalsResponse;
import com.google.ads.admanager.v1.BatchPauseProposalsRequest;
import com.google.ads.admanager.v1.BatchPauseProposalsResponse;
import com.google.ads.admanager.v1.BatchPushToOrderProposalsRequest;
import com.google.ads.admanager.v1.BatchPushToOrderProposalsResponse;
import com.google.ads.admanager.v1.BatchRedraftProposalsRequest;
import com.google.ads.admanager.v1.BatchRedraftProposalsResponse;
import com.google.ads.admanager.v1.BatchRequestBuyerAcceptProposalsRequest;
import com.google.ads.admanager.v1.BatchRequestBuyerAcceptProposalsResponse;
import com.google.ads.admanager.v1.BatchRequestBuyerReviewProposalsRequest;
import com.google.ads.admanager.v1.BatchRequestBuyerReviewProposalsResponse;
import com.google.ads.admanager.v1.BatchReserveProposalsRequest;
import com.google.ads.admanager.v1.BatchReserveProposalsResponse;
import com.google.ads.admanager.v1.BatchResumeProposalsRequest;
import com.google.ads.admanager.v1.BatchResumeProposalsResponse;
import com.google.ads.admanager.v1.BatchTerminateProposalsRequest;
import com.google.ads.admanager.v1.BatchTerminateProposalsResponse;
import com.google.ads.admanager.v1.BatchUnarchiveProposalsRequest;
import com.google.ads.admanager.v1.BatchUnarchiveProposalsResponse;
import com.google.ads.admanager.v1.BatchUpdateProposalsRequest;
import com.google.ads.admanager.v1.BatchUpdateProposalsResponse;
import com.google.ads.admanager.v1.CreateProposalRequest;
import com.google.ads.admanager.v1.FetchMarketplaceCommentsRequest;
import com.google.ads.admanager.v1.FetchMarketplaceCommentsResponse;
import com.google.ads.admanager.v1.GetProposalRequest;
import com.google.ads.admanager.v1.ListProposalsRequest;
import com.google.ads.admanager.v1.ListProposalsResponse;
import com.google.ads.admanager.v1.MarketplaceComment;
import com.google.ads.admanager.v1.Proposal;
import com.google.ads.admanager.v1.UpdateProposalRequest;
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
 * Settings class to configure an instance of {@link ProposalServiceStub}.
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
 * of getProposal:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ProposalServiceStubSettings.Builder proposalServiceSettingsBuilder =
 *     ProposalServiceStubSettings.newBuilder();
 * proposalServiceSettingsBuilder
 *     .getProposalSettings()
 *     .setRetrySettings(
 *         proposalServiceSettingsBuilder
 *             .getProposalSettings()
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
 * ProposalServiceStubSettings proposalServiceSettings = proposalServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@NullMarked
@Generated("by gapic-generator-java")
@SuppressWarnings("CanonicalDuration")
public class ProposalServiceStubSettings extends StubSettings<ProposalServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/admanager")
          .add("https://www.googleapis.com/auth/admanager.readonly")
          .build();

  private final UnaryCallSettings<GetProposalRequest, Proposal> getProposalSettings;
  private final PagedCallSettings<
          ListProposalsRequest, ListProposalsResponse, ListProposalsPagedResponse>
      listProposalsSettings;
  private final UnaryCallSettings<CreateProposalRequest, Proposal> createProposalSettings;
  private final UnaryCallSettings<BatchCreateProposalsRequest, BatchCreateProposalsResponse>
      batchCreateProposalsSettings;
  private final UnaryCallSettings<UpdateProposalRequest, Proposal> updateProposalSettings;
  private final UnaryCallSettings<BatchUpdateProposalsRequest, BatchUpdateProposalsResponse>
      batchUpdateProposalsSettings;
  private final UnaryCallSettings<BatchArchiveProposalsRequest, BatchArchiveProposalsResponse>
      batchArchiveProposalsSettings;
  private final UnaryCallSettings<BatchUnarchiveProposalsRequest, BatchUnarchiveProposalsResponse>
      batchUnarchiveProposalsSettings;
  private final UnaryCallSettings<BatchPauseProposalsRequest, BatchPauseProposalsResponse>
      batchPauseProposalsSettings;
  private final UnaryCallSettings<BatchResumeProposalsRequest, BatchResumeProposalsResponse>
      batchResumeProposalsSettings;
  private final UnaryCallSettings<
          BatchRequestBuyerReviewProposalsRequest, BatchRequestBuyerReviewProposalsResponse>
      batchRequestBuyerReviewProposalsSettings;
  private final UnaryCallSettings<
          BatchRequestBuyerAcceptProposalsRequest, BatchRequestBuyerAcceptProposalsResponse>
      batchRequestBuyerAcceptProposalsSettings;
  private final UnaryCallSettings<BatchReserveProposalsRequest, BatchReserveProposalsResponse>
      batchReserveProposalsSettings;
  private final UnaryCallSettings<BatchRedraftProposalsRequest, BatchRedraftProposalsResponse>
      batchRedraftProposalsSettings;
  private final UnaryCallSettings<
          BatchDiscardDraftProposalsRequest, BatchDiscardDraftProposalsResponse>
      batchDiscardDraftProposalsSettings;
  private final UnaryCallSettings<BatchTerminateProposalsRequest, BatchTerminateProposalsResponse>
      batchTerminateProposalsSettings;
  private final UnaryCallSettings<
          BatchPushToOrderProposalsRequest, BatchPushToOrderProposalsResponse>
      batchPushToOrderProposalsSettings;
  private final PagedCallSettings<
          FetchMarketplaceCommentsRequest,
          FetchMarketplaceCommentsResponse,
          FetchMarketplaceCommentsPagedResponse>
      fetchMarketplaceCommentsSettings;

  private static final PagedListDescriptor<ListProposalsRequest, ListProposalsResponse, Proposal>
      LIST_PROPOSALS_PAGE_STR_DESC =
          new PagedListDescriptor<ListProposalsRequest, ListProposalsResponse, Proposal>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListProposalsRequest injectToken(ListProposalsRequest payload, String token) {
              return ListProposalsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListProposalsRequest injectPageSize(ListProposalsRequest payload, int pageSize) {
              return ListProposalsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListProposalsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListProposalsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Proposal> extractResources(ListProposalsResponse payload) {
              return payload.getProposalsList();
            }
          };

  private static final PagedListDescriptor<
          FetchMarketplaceCommentsRequest, FetchMarketplaceCommentsResponse, MarketplaceComment>
      FETCH_MARKETPLACE_COMMENTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              FetchMarketplaceCommentsRequest,
              FetchMarketplaceCommentsResponse,
              MarketplaceComment>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public FetchMarketplaceCommentsRequest injectToken(
                FetchMarketplaceCommentsRequest payload, String token) {
              return FetchMarketplaceCommentsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public FetchMarketplaceCommentsRequest injectPageSize(
                FetchMarketplaceCommentsRequest payload, int pageSize) {
              return FetchMarketplaceCommentsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(FetchMarketplaceCommentsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(FetchMarketplaceCommentsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<MarketplaceComment> extractResources(
                FetchMarketplaceCommentsResponse payload) {
              return payload.getMarketplaceCommentsList();
            }
          };

  private static final PagedListResponseFactory<
          ListProposalsRequest, ListProposalsResponse, ListProposalsPagedResponse>
      LIST_PROPOSALS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListProposalsRequest, ListProposalsResponse, ListProposalsPagedResponse>() {
            @Override
            public ApiFuture<ListProposalsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListProposalsRequest, ListProposalsResponse> callable,
                ListProposalsRequest request,
                ApiCallContext context,
                ApiFuture<ListProposalsResponse> futureResponse) {
              PageContext<ListProposalsRequest, ListProposalsResponse, Proposal> pageContext =
                  PageContext.create(callable, LIST_PROPOSALS_PAGE_STR_DESC, request, context);
              return ListProposalsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          FetchMarketplaceCommentsRequest,
          FetchMarketplaceCommentsResponse,
          FetchMarketplaceCommentsPagedResponse>
      FETCH_MARKETPLACE_COMMENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              FetchMarketplaceCommentsRequest,
              FetchMarketplaceCommentsResponse,
              FetchMarketplaceCommentsPagedResponse>() {
            @Override
            public ApiFuture<FetchMarketplaceCommentsPagedResponse> getFuturePagedResponse(
                UnaryCallable<FetchMarketplaceCommentsRequest, FetchMarketplaceCommentsResponse>
                    callable,
                FetchMarketplaceCommentsRequest request,
                ApiCallContext context,
                ApiFuture<FetchMarketplaceCommentsResponse> futureResponse) {
              PageContext<
                      FetchMarketplaceCommentsRequest,
                      FetchMarketplaceCommentsResponse,
                      MarketplaceComment>
                  pageContext =
                      PageContext.create(
                          callable, FETCH_MARKETPLACE_COMMENTS_PAGE_STR_DESC, request, context);
              return FetchMarketplaceCommentsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getProposal. */
  public UnaryCallSettings<GetProposalRequest, Proposal> getProposalSettings() {
    return getProposalSettings;
  }

  /** Returns the object with the settings used for calls to listProposals. */
  public PagedCallSettings<ListProposalsRequest, ListProposalsResponse, ListProposalsPagedResponse>
      listProposalsSettings() {
    return listProposalsSettings;
  }

  /** Returns the object with the settings used for calls to createProposal. */
  public UnaryCallSettings<CreateProposalRequest, Proposal> createProposalSettings() {
    return createProposalSettings;
  }

  /** Returns the object with the settings used for calls to batchCreateProposals. */
  public UnaryCallSettings<BatchCreateProposalsRequest, BatchCreateProposalsResponse>
      batchCreateProposalsSettings() {
    return batchCreateProposalsSettings;
  }

  /** Returns the object with the settings used for calls to updateProposal. */
  public UnaryCallSettings<UpdateProposalRequest, Proposal> updateProposalSettings() {
    return updateProposalSettings;
  }

  /** Returns the object with the settings used for calls to batchUpdateProposals. */
  public UnaryCallSettings<BatchUpdateProposalsRequest, BatchUpdateProposalsResponse>
      batchUpdateProposalsSettings() {
    return batchUpdateProposalsSettings;
  }

  /** Returns the object with the settings used for calls to batchArchiveProposals. */
  public UnaryCallSettings<BatchArchiveProposalsRequest, BatchArchiveProposalsResponse>
      batchArchiveProposalsSettings() {
    return batchArchiveProposalsSettings;
  }

  /** Returns the object with the settings used for calls to batchUnarchiveProposals. */
  public UnaryCallSettings<BatchUnarchiveProposalsRequest, BatchUnarchiveProposalsResponse>
      batchUnarchiveProposalsSettings() {
    return batchUnarchiveProposalsSettings;
  }

  /** Returns the object with the settings used for calls to batchPauseProposals. */
  public UnaryCallSettings<BatchPauseProposalsRequest, BatchPauseProposalsResponse>
      batchPauseProposalsSettings() {
    return batchPauseProposalsSettings;
  }

  /** Returns the object with the settings used for calls to batchResumeProposals. */
  public UnaryCallSettings<BatchResumeProposalsRequest, BatchResumeProposalsResponse>
      batchResumeProposalsSettings() {
    return batchResumeProposalsSettings;
  }

  /** Returns the object with the settings used for calls to batchRequestBuyerReviewProposals. */
  public UnaryCallSettings<
          BatchRequestBuyerReviewProposalsRequest, BatchRequestBuyerReviewProposalsResponse>
      batchRequestBuyerReviewProposalsSettings() {
    return batchRequestBuyerReviewProposalsSettings;
  }

  /** Returns the object with the settings used for calls to batchRequestBuyerAcceptProposals. */
  public UnaryCallSettings<
          BatchRequestBuyerAcceptProposalsRequest, BatchRequestBuyerAcceptProposalsResponse>
      batchRequestBuyerAcceptProposalsSettings() {
    return batchRequestBuyerAcceptProposalsSettings;
  }

  /** Returns the object with the settings used for calls to batchReserveProposals. */
  public UnaryCallSettings<BatchReserveProposalsRequest, BatchReserveProposalsResponse>
      batchReserveProposalsSettings() {
    return batchReserveProposalsSettings;
  }

  /** Returns the object with the settings used for calls to batchRedraftProposals. */
  public UnaryCallSettings<BatchRedraftProposalsRequest, BatchRedraftProposalsResponse>
      batchRedraftProposalsSettings() {
    return batchRedraftProposalsSettings;
  }

  /** Returns the object with the settings used for calls to batchDiscardDraftProposals. */
  public UnaryCallSettings<BatchDiscardDraftProposalsRequest, BatchDiscardDraftProposalsResponse>
      batchDiscardDraftProposalsSettings() {
    return batchDiscardDraftProposalsSettings;
  }

  /** Returns the object with the settings used for calls to batchTerminateProposals. */
  public UnaryCallSettings<BatchTerminateProposalsRequest, BatchTerminateProposalsResponse>
      batchTerminateProposalsSettings() {
    return batchTerminateProposalsSettings;
  }

  /** Returns the object with the settings used for calls to batchPushToOrderProposals. */
  public UnaryCallSettings<BatchPushToOrderProposalsRequest, BatchPushToOrderProposalsResponse>
      batchPushToOrderProposalsSettings() {
    return batchPushToOrderProposalsSettings;
  }

  /** Returns the object with the settings used for calls to fetchMarketplaceComments. */
  public PagedCallSettings<
          FetchMarketplaceCommentsRequest,
          FetchMarketplaceCommentsResponse,
          FetchMarketplaceCommentsPagedResponse>
      fetchMarketplaceCommentsSettings() {
    return fetchMarketplaceCommentsSettings;
  }

  public ProposalServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonProposalServiceStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(ProposalServiceStubSettings.class))
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

  protected ProposalServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getProposalSettings = settingsBuilder.getProposalSettings().build();
    listProposalsSettings = settingsBuilder.listProposalsSettings().build();
    createProposalSettings = settingsBuilder.createProposalSettings().build();
    batchCreateProposalsSettings = settingsBuilder.batchCreateProposalsSettings().build();
    updateProposalSettings = settingsBuilder.updateProposalSettings().build();
    batchUpdateProposalsSettings = settingsBuilder.batchUpdateProposalsSettings().build();
    batchArchiveProposalsSettings = settingsBuilder.batchArchiveProposalsSettings().build();
    batchUnarchiveProposalsSettings = settingsBuilder.batchUnarchiveProposalsSettings().build();
    batchPauseProposalsSettings = settingsBuilder.batchPauseProposalsSettings().build();
    batchResumeProposalsSettings = settingsBuilder.batchResumeProposalsSettings().build();
    batchRequestBuyerReviewProposalsSettings =
        settingsBuilder.batchRequestBuyerReviewProposalsSettings().build();
    batchRequestBuyerAcceptProposalsSettings =
        settingsBuilder.batchRequestBuyerAcceptProposalsSettings().build();
    batchReserveProposalsSettings = settingsBuilder.batchReserveProposalsSettings().build();
    batchRedraftProposalsSettings = settingsBuilder.batchRedraftProposalsSettings().build();
    batchDiscardDraftProposalsSettings =
        settingsBuilder.batchDiscardDraftProposalsSettings().build();
    batchTerminateProposalsSettings = settingsBuilder.batchTerminateProposalsSettings().build();
    batchPushToOrderProposalsSettings = settingsBuilder.batchPushToOrderProposalsSettings().build();
    fetchMarketplaceCommentsSettings = settingsBuilder.fetchMarketplaceCommentsSettings().build();
  }

  @Override
  protected LibraryMetadata getLibraryMetadata() {
    return LibraryMetadata.newBuilder()
        .setArtifactName("com.google.api-ads:ad-manager")
        .setRepository("googleapis/google-cloud-java")
        .setVersion(Version.VERSION)
        .build();
  }

  /** Builder for ProposalServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<ProposalServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetProposalRequest, Proposal> getProposalSettings;
    private final PagedCallSettings.Builder<
            ListProposalsRequest, ListProposalsResponse, ListProposalsPagedResponse>
        listProposalsSettings;
    private final UnaryCallSettings.Builder<CreateProposalRequest, Proposal> createProposalSettings;
    private final UnaryCallSettings.Builder<
            BatchCreateProposalsRequest, BatchCreateProposalsResponse>
        batchCreateProposalsSettings;
    private final UnaryCallSettings.Builder<UpdateProposalRequest, Proposal> updateProposalSettings;
    private final UnaryCallSettings.Builder<
            BatchUpdateProposalsRequest, BatchUpdateProposalsResponse>
        batchUpdateProposalsSettings;
    private final UnaryCallSettings.Builder<
            BatchArchiveProposalsRequest, BatchArchiveProposalsResponse>
        batchArchiveProposalsSettings;
    private final UnaryCallSettings.Builder<
            BatchUnarchiveProposalsRequest, BatchUnarchiveProposalsResponse>
        batchUnarchiveProposalsSettings;
    private final UnaryCallSettings.Builder<BatchPauseProposalsRequest, BatchPauseProposalsResponse>
        batchPauseProposalsSettings;
    private final UnaryCallSettings.Builder<
            BatchResumeProposalsRequest, BatchResumeProposalsResponse>
        batchResumeProposalsSettings;
    private final UnaryCallSettings.Builder<
            BatchRequestBuyerReviewProposalsRequest, BatchRequestBuyerReviewProposalsResponse>
        batchRequestBuyerReviewProposalsSettings;
    private final UnaryCallSettings.Builder<
            BatchRequestBuyerAcceptProposalsRequest, BatchRequestBuyerAcceptProposalsResponse>
        batchRequestBuyerAcceptProposalsSettings;
    private final UnaryCallSettings.Builder<
            BatchReserveProposalsRequest, BatchReserveProposalsResponse>
        batchReserveProposalsSettings;
    private final UnaryCallSettings.Builder<
            BatchRedraftProposalsRequest, BatchRedraftProposalsResponse>
        batchRedraftProposalsSettings;
    private final UnaryCallSettings.Builder<
            BatchDiscardDraftProposalsRequest, BatchDiscardDraftProposalsResponse>
        batchDiscardDraftProposalsSettings;
    private final UnaryCallSettings.Builder<
            BatchTerminateProposalsRequest, BatchTerminateProposalsResponse>
        batchTerminateProposalsSettings;
    private final UnaryCallSettings.Builder<
            BatchPushToOrderProposalsRequest, BatchPushToOrderProposalsResponse>
        batchPushToOrderProposalsSettings;
    private final PagedCallSettings.Builder<
            FetchMarketplaceCommentsRequest,
            FetchMarketplaceCommentsResponse,
            FetchMarketplaceCommentsPagedResponse>
        fetchMarketplaceCommentsSettings;
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

      getProposalSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listProposalsSettings = PagedCallSettings.newBuilder(LIST_PROPOSALS_PAGE_STR_FACT);
      createProposalSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchCreateProposalsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateProposalSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchUpdateProposalsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchArchiveProposalsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchUnarchiveProposalsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchPauseProposalsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchResumeProposalsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchRequestBuyerReviewProposalsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchRequestBuyerAcceptProposalsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchReserveProposalsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchRedraftProposalsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchDiscardDraftProposalsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchTerminateProposalsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchPushToOrderProposalsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      fetchMarketplaceCommentsSettings =
          PagedCallSettings.newBuilder(FETCH_MARKETPLACE_COMMENTS_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getProposalSettings,
              listProposalsSettings,
              createProposalSettings,
              batchCreateProposalsSettings,
              updateProposalSettings,
              batchUpdateProposalsSettings,
              batchArchiveProposalsSettings,
              batchUnarchiveProposalsSettings,
              batchPauseProposalsSettings,
              batchResumeProposalsSettings,
              batchRequestBuyerReviewProposalsSettings,
              batchRequestBuyerAcceptProposalsSettings,
              batchReserveProposalsSettings,
              batchRedraftProposalsSettings,
              batchDiscardDraftProposalsSettings,
              batchTerminateProposalsSettings,
              batchPushToOrderProposalsSettings,
              fetchMarketplaceCommentsSettings);
      initDefaults(this);
    }

    protected Builder(ProposalServiceStubSettings settings) {
      super(settings);

      getProposalSettings = settings.getProposalSettings.toBuilder();
      listProposalsSettings = settings.listProposalsSettings.toBuilder();
      createProposalSettings = settings.createProposalSettings.toBuilder();
      batchCreateProposalsSettings = settings.batchCreateProposalsSettings.toBuilder();
      updateProposalSettings = settings.updateProposalSettings.toBuilder();
      batchUpdateProposalsSettings = settings.batchUpdateProposalsSettings.toBuilder();
      batchArchiveProposalsSettings = settings.batchArchiveProposalsSettings.toBuilder();
      batchUnarchiveProposalsSettings = settings.batchUnarchiveProposalsSettings.toBuilder();
      batchPauseProposalsSettings = settings.batchPauseProposalsSettings.toBuilder();
      batchResumeProposalsSettings = settings.batchResumeProposalsSettings.toBuilder();
      batchRequestBuyerReviewProposalsSettings =
          settings.batchRequestBuyerReviewProposalsSettings.toBuilder();
      batchRequestBuyerAcceptProposalsSettings =
          settings.batchRequestBuyerAcceptProposalsSettings.toBuilder();
      batchReserveProposalsSettings = settings.batchReserveProposalsSettings.toBuilder();
      batchRedraftProposalsSettings = settings.batchRedraftProposalsSettings.toBuilder();
      batchDiscardDraftProposalsSettings = settings.batchDiscardDraftProposalsSettings.toBuilder();
      batchTerminateProposalsSettings = settings.batchTerminateProposalsSettings.toBuilder();
      batchPushToOrderProposalsSettings = settings.batchPushToOrderProposalsSettings.toBuilder();
      fetchMarketplaceCommentsSettings = settings.fetchMarketplaceCommentsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getProposalSettings,
              listProposalsSettings,
              createProposalSettings,
              batchCreateProposalsSettings,
              updateProposalSettings,
              batchUpdateProposalsSettings,
              batchArchiveProposalsSettings,
              batchUnarchiveProposalsSettings,
              batchPauseProposalsSettings,
              batchResumeProposalsSettings,
              batchRequestBuyerReviewProposalsSettings,
              batchRequestBuyerAcceptProposalsSettings,
              batchReserveProposalsSettings,
              batchRedraftProposalsSettings,
              batchDiscardDraftProposalsSettings,
              batchTerminateProposalsSettings,
              batchPushToOrderProposalsSettings,
              fetchMarketplaceCommentsSettings);
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
          .getProposalSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listProposalsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createProposalSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchCreateProposalsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateProposalSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchUpdateProposalsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchArchiveProposalsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchUnarchiveProposalsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchPauseProposalsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchResumeProposalsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchRequestBuyerReviewProposalsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchRequestBuyerAcceptProposalsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchReserveProposalsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchRedraftProposalsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchDiscardDraftProposalsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchTerminateProposalsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchPushToOrderProposalsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .fetchMarketplaceCommentsSettings()
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

    /** Returns the builder for the settings used for calls to getProposal. */
    public UnaryCallSettings.Builder<GetProposalRequest, Proposal> getProposalSettings() {
      return getProposalSettings;
    }

    /** Returns the builder for the settings used for calls to listProposals. */
    public PagedCallSettings.Builder<
            ListProposalsRequest, ListProposalsResponse, ListProposalsPagedResponse>
        listProposalsSettings() {
      return listProposalsSettings;
    }

    /** Returns the builder for the settings used for calls to createProposal. */
    public UnaryCallSettings.Builder<CreateProposalRequest, Proposal> createProposalSettings() {
      return createProposalSettings;
    }

    /** Returns the builder for the settings used for calls to batchCreateProposals. */
    public UnaryCallSettings.Builder<BatchCreateProposalsRequest, BatchCreateProposalsResponse>
        batchCreateProposalsSettings() {
      return batchCreateProposalsSettings;
    }

    /** Returns the builder for the settings used for calls to updateProposal. */
    public UnaryCallSettings.Builder<UpdateProposalRequest, Proposal> updateProposalSettings() {
      return updateProposalSettings;
    }

    /** Returns the builder for the settings used for calls to batchUpdateProposals. */
    public UnaryCallSettings.Builder<BatchUpdateProposalsRequest, BatchUpdateProposalsResponse>
        batchUpdateProposalsSettings() {
      return batchUpdateProposalsSettings;
    }

    /** Returns the builder for the settings used for calls to batchArchiveProposals. */
    public UnaryCallSettings.Builder<BatchArchiveProposalsRequest, BatchArchiveProposalsResponse>
        batchArchiveProposalsSettings() {
      return batchArchiveProposalsSettings;
    }

    /** Returns the builder for the settings used for calls to batchUnarchiveProposals. */
    public UnaryCallSettings.Builder<
            BatchUnarchiveProposalsRequest, BatchUnarchiveProposalsResponse>
        batchUnarchiveProposalsSettings() {
      return batchUnarchiveProposalsSettings;
    }

    /** Returns the builder for the settings used for calls to batchPauseProposals. */
    public UnaryCallSettings.Builder<BatchPauseProposalsRequest, BatchPauseProposalsResponse>
        batchPauseProposalsSettings() {
      return batchPauseProposalsSettings;
    }

    /** Returns the builder for the settings used for calls to batchResumeProposals. */
    public UnaryCallSettings.Builder<BatchResumeProposalsRequest, BatchResumeProposalsResponse>
        batchResumeProposalsSettings() {
      return batchResumeProposalsSettings;
    }

    /** Returns the builder for the settings used for calls to batchRequestBuyerReviewProposals. */
    public UnaryCallSettings.Builder<
            BatchRequestBuyerReviewProposalsRequest, BatchRequestBuyerReviewProposalsResponse>
        batchRequestBuyerReviewProposalsSettings() {
      return batchRequestBuyerReviewProposalsSettings;
    }

    /** Returns the builder for the settings used for calls to batchRequestBuyerAcceptProposals. */
    public UnaryCallSettings.Builder<
            BatchRequestBuyerAcceptProposalsRequest, BatchRequestBuyerAcceptProposalsResponse>
        batchRequestBuyerAcceptProposalsSettings() {
      return batchRequestBuyerAcceptProposalsSettings;
    }

    /** Returns the builder for the settings used for calls to batchReserveProposals. */
    public UnaryCallSettings.Builder<BatchReserveProposalsRequest, BatchReserveProposalsResponse>
        batchReserveProposalsSettings() {
      return batchReserveProposalsSettings;
    }

    /** Returns the builder for the settings used for calls to batchRedraftProposals. */
    public UnaryCallSettings.Builder<BatchRedraftProposalsRequest, BatchRedraftProposalsResponse>
        batchRedraftProposalsSettings() {
      return batchRedraftProposalsSettings;
    }

    /** Returns the builder for the settings used for calls to batchDiscardDraftProposals. */
    public UnaryCallSettings.Builder<
            BatchDiscardDraftProposalsRequest, BatchDiscardDraftProposalsResponse>
        batchDiscardDraftProposalsSettings() {
      return batchDiscardDraftProposalsSettings;
    }

    /** Returns the builder for the settings used for calls to batchTerminateProposals. */
    public UnaryCallSettings.Builder<
            BatchTerminateProposalsRequest, BatchTerminateProposalsResponse>
        batchTerminateProposalsSettings() {
      return batchTerminateProposalsSettings;
    }

    /** Returns the builder for the settings used for calls to batchPushToOrderProposals. */
    public UnaryCallSettings.Builder<
            BatchPushToOrderProposalsRequest, BatchPushToOrderProposalsResponse>
        batchPushToOrderProposalsSettings() {
      return batchPushToOrderProposalsSettings;
    }

    /** Returns the builder for the settings used for calls to fetchMarketplaceComments. */
    public PagedCallSettings.Builder<
            FetchMarketplaceCommentsRequest,
            FetchMarketplaceCommentsResponse,
            FetchMarketplaceCommentsPagedResponse>
        fetchMarketplaceCommentsSettings() {
      return fetchMarketplaceCommentsSettings;
    }

    @Override
    public ProposalServiceStubSettings build() throws IOException {
      return new ProposalServiceStubSettings(this);
    }
  }
}
