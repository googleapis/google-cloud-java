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

package com.google.ads.admanager.v1;

import static com.google.ads.admanager.v1.ProposalServiceClient.FetchMarketplaceCommentsPagedResponse;
import static com.google.ads.admanager.v1.ProposalServiceClient.ListProposalsPagedResponse;

import com.google.ads.admanager.v1.stub.ProposalServiceStubSettings;
import com.google.api.core.ApiFunction;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ProposalServiceClient}.
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
 * ProposalServiceSettings.Builder proposalServiceSettingsBuilder =
 *     ProposalServiceSettings.newBuilder();
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
 * ProposalServiceSettings proposalServiceSettings = proposalServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class ProposalServiceSettings extends ClientSettings<ProposalServiceSettings> {

  /** Returns the object with the settings used for calls to getProposal. */
  public UnaryCallSettings<GetProposalRequest, Proposal> getProposalSettings() {
    return ((ProposalServiceStubSettings) getStubSettings()).getProposalSettings();
  }

  /** Returns the object with the settings used for calls to listProposals. */
  public PagedCallSettings<ListProposalsRequest, ListProposalsResponse, ListProposalsPagedResponse>
      listProposalsSettings() {
    return ((ProposalServiceStubSettings) getStubSettings()).listProposalsSettings();
  }

  /** Returns the object with the settings used for calls to createProposal. */
  public UnaryCallSettings<CreateProposalRequest, Proposal> createProposalSettings() {
    return ((ProposalServiceStubSettings) getStubSettings()).createProposalSettings();
  }

  /** Returns the object with the settings used for calls to batchCreateProposals. */
  public UnaryCallSettings<BatchCreateProposalsRequest, BatchCreateProposalsResponse>
      batchCreateProposalsSettings() {
    return ((ProposalServiceStubSettings) getStubSettings()).batchCreateProposalsSettings();
  }

  /** Returns the object with the settings used for calls to updateProposal. */
  public UnaryCallSettings<UpdateProposalRequest, Proposal> updateProposalSettings() {
    return ((ProposalServiceStubSettings) getStubSettings()).updateProposalSettings();
  }

  /** Returns the object with the settings used for calls to batchUpdateProposals. */
  public UnaryCallSettings<BatchUpdateProposalsRequest, BatchUpdateProposalsResponse>
      batchUpdateProposalsSettings() {
    return ((ProposalServiceStubSettings) getStubSettings()).batchUpdateProposalsSettings();
  }

  /** Returns the object with the settings used for calls to batchArchiveProposals. */
  public UnaryCallSettings<BatchArchiveProposalsRequest, BatchArchiveProposalsResponse>
      batchArchiveProposalsSettings() {
    return ((ProposalServiceStubSettings) getStubSettings()).batchArchiveProposalsSettings();
  }

  /** Returns the object with the settings used for calls to batchUnarchiveProposals. */
  public UnaryCallSettings<BatchUnarchiveProposalsRequest, BatchUnarchiveProposalsResponse>
      batchUnarchiveProposalsSettings() {
    return ((ProposalServiceStubSettings) getStubSettings()).batchUnarchiveProposalsSettings();
  }

  /** Returns the object with the settings used for calls to batchPauseProposals. */
  public UnaryCallSettings<BatchPauseProposalsRequest, BatchPauseProposalsResponse>
      batchPauseProposalsSettings() {
    return ((ProposalServiceStubSettings) getStubSettings()).batchPauseProposalsSettings();
  }

  /** Returns the object with the settings used for calls to batchResumeProposals. */
  public UnaryCallSettings<BatchResumeProposalsRequest, BatchResumeProposalsResponse>
      batchResumeProposalsSettings() {
    return ((ProposalServiceStubSettings) getStubSettings()).batchResumeProposalsSettings();
  }

  /** Returns the object with the settings used for calls to batchRequestBuyerReviewProposals. */
  public UnaryCallSettings<
          BatchRequestBuyerReviewProposalsRequest, BatchRequestBuyerReviewProposalsResponse>
      batchRequestBuyerReviewProposalsSettings() {
    return ((ProposalServiceStubSettings) getStubSettings())
        .batchRequestBuyerReviewProposalsSettings();
  }

  /** Returns the object with the settings used for calls to batchRequestBuyerAcceptProposals. */
  public UnaryCallSettings<
          BatchRequestBuyerAcceptProposalsRequest, BatchRequestBuyerAcceptProposalsResponse>
      batchRequestBuyerAcceptProposalsSettings() {
    return ((ProposalServiceStubSettings) getStubSettings())
        .batchRequestBuyerAcceptProposalsSettings();
  }

  /** Returns the object with the settings used for calls to batchReserveProposals. */
  public UnaryCallSettings<BatchReserveProposalsRequest, BatchReserveProposalsResponse>
      batchReserveProposalsSettings() {
    return ((ProposalServiceStubSettings) getStubSettings()).batchReserveProposalsSettings();
  }

  /** Returns the object with the settings used for calls to batchRedraftProposals. */
  public UnaryCallSettings<BatchRedraftProposalsRequest, BatchRedraftProposalsResponse>
      batchRedraftProposalsSettings() {
    return ((ProposalServiceStubSettings) getStubSettings()).batchRedraftProposalsSettings();
  }

  /** Returns the object with the settings used for calls to batchDiscardDraftProposals. */
  public UnaryCallSettings<BatchDiscardDraftProposalsRequest, BatchDiscardDraftProposalsResponse>
      batchDiscardDraftProposalsSettings() {
    return ((ProposalServiceStubSettings) getStubSettings()).batchDiscardDraftProposalsSettings();
  }

  /** Returns the object with the settings used for calls to batchTerminateProposals. */
  public UnaryCallSettings<BatchTerminateProposalsRequest, BatchTerminateProposalsResponse>
      batchTerminateProposalsSettings() {
    return ((ProposalServiceStubSettings) getStubSettings()).batchTerminateProposalsSettings();
  }

  /** Returns the object with the settings used for calls to batchPushToOrderProposals. */
  public UnaryCallSettings<BatchPushToOrderProposalsRequest, BatchPushToOrderProposalsResponse>
      batchPushToOrderProposalsSettings() {
    return ((ProposalServiceStubSettings) getStubSettings()).batchPushToOrderProposalsSettings();
  }

  /** Returns the object with the settings used for calls to fetchMarketplaceComments. */
  public PagedCallSettings<
          FetchMarketplaceCommentsRequest,
          FetchMarketplaceCommentsResponse,
          FetchMarketplaceCommentsPagedResponse>
      fetchMarketplaceCommentsSettings() {
    return ((ProposalServiceStubSettings) getStubSettings()).fetchMarketplaceCommentsSettings();
  }

  public static final ProposalServiceSettings create(ProposalServiceStubSettings stub)
      throws IOException {
    return new ProposalServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ProposalServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ProposalServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ProposalServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ProposalServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return ProposalServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ProposalServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ProposalServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected ProposalServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ProposalServiceSettings. */
  public static class Builder extends ClientSettings.Builder<ProposalServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(@Nullable ClientContext clientContext) {
      super(ProposalServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(ProposalServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ProposalServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(ProposalServiceStubSettings.newBuilder());
    }

    public ProposalServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((ProposalServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to getProposal. */
    public UnaryCallSettings.Builder<GetProposalRequest, Proposal> getProposalSettings() {
      return getStubSettingsBuilder().getProposalSettings();
    }

    /** Returns the builder for the settings used for calls to listProposals. */
    public PagedCallSettings.Builder<
            ListProposalsRequest, ListProposalsResponse, ListProposalsPagedResponse>
        listProposalsSettings() {
      return getStubSettingsBuilder().listProposalsSettings();
    }

    /** Returns the builder for the settings used for calls to createProposal. */
    public UnaryCallSettings.Builder<CreateProposalRequest, Proposal> createProposalSettings() {
      return getStubSettingsBuilder().createProposalSettings();
    }

    /** Returns the builder for the settings used for calls to batchCreateProposals. */
    public UnaryCallSettings.Builder<BatchCreateProposalsRequest, BatchCreateProposalsResponse>
        batchCreateProposalsSettings() {
      return getStubSettingsBuilder().batchCreateProposalsSettings();
    }

    /** Returns the builder for the settings used for calls to updateProposal. */
    public UnaryCallSettings.Builder<UpdateProposalRequest, Proposal> updateProposalSettings() {
      return getStubSettingsBuilder().updateProposalSettings();
    }

    /** Returns the builder for the settings used for calls to batchUpdateProposals. */
    public UnaryCallSettings.Builder<BatchUpdateProposalsRequest, BatchUpdateProposalsResponse>
        batchUpdateProposalsSettings() {
      return getStubSettingsBuilder().batchUpdateProposalsSettings();
    }

    /** Returns the builder for the settings used for calls to batchArchiveProposals. */
    public UnaryCallSettings.Builder<BatchArchiveProposalsRequest, BatchArchiveProposalsResponse>
        batchArchiveProposalsSettings() {
      return getStubSettingsBuilder().batchArchiveProposalsSettings();
    }

    /** Returns the builder for the settings used for calls to batchUnarchiveProposals. */
    public UnaryCallSettings.Builder<
            BatchUnarchiveProposalsRequest, BatchUnarchiveProposalsResponse>
        batchUnarchiveProposalsSettings() {
      return getStubSettingsBuilder().batchUnarchiveProposalsSettings();
    }

    /** Returns the builder for the settings used for calls to batchPauseProposals. */
    public UnaryCallSettings.Builder<BatchPauseProposalsRequest, BatchPauseProposalsResponse>
        batchPauseProposalsSettings() {
      return getStubSettingsBuilder().batchPauseProposalsSettings();
    }

    /** Returns the builder for the settings used for calls to batchResumeProposals. */
    public UnaryCallSettings.Builder<BatchResumeProposalsRequest, BatchResumeProposalsResponse>
        batchResumeProposalsSettings() {
      return getStubSettingsBuilder().batchResumeProposalsSettings();
    }

    /** Returns the builder for the settings used for calls to batchRequestBuyerReviewProposals. */
    public UnaryCallSettings.Builder<
            BatchRequestBuyerReviewProposalsRequest, BatchRequestBuyerReviewProposalsResponse>
        batchRequestBuyerReviewProposalsSettings() {
      return getStubSettingsBuilder().batchRequestBuyerReviewProposalsSettings();
    }

    /** Returns the builder for the settings used for calls to batchRequestBuyerAcceptProposals. */
    public UnaryCallSettings.Builder<
            BatchRequestBuyerAcceptProposalsRequest, BatchRequestBuyerAcceptProposalsResponse>
        batchRequestBuyerAcceptProposalsSettings() {
      return getStubSettingsBuilder().batchRequestBuyerAcceptProposalsSettings();
    }

    /** Returns the builder for the settings used for calls to batchReserveProposals. */
    public UnaryCallSettings.Builder<BatchReserveProposalsRequest, BatchReserveProposalsResponse>
        batchReserveProposalsSettings() {
      return getStubSettingsBuilder().batchReserveProposalsSettings();
    }

    /** Returns the builder for the settings used for calls to batchRedraftProposals. */
    public UnaryCallSettings.Builder<BatchRedraftProposalsRequest, BatchRedraftProposalsResponse>
        batchRedraftProposalsSettings() {
      return getStubSettingsBuilder().batchRedraftProposalsSettings();
    }

    /** Returns the builder for the settings used for calls to batchDiscardDraftProposals. */
    public UnaryCallSettings.Builder<
            BatchDiscardDraftProposalsRequest, BatchDiscardDraftProposalsResponse>
        batchDiscardDraftProposalsSettings() {
      return getStubSettingsBuilder().batchDiscardDraftProposalsSettings();
    }

    /** Returns the builder for the settings used for calls to batchTerminateProposals. */
    public UnaryCallSettings.Builder<
            BatchTerminateProposalsRequest, BatchTerminateProposalsResponse>
        batchTerminateProposalsSettings() {
      return getStubSettingsBuilder().batchTerminateProposalsSettings();
    }

    /** Returns the builder for the settings used for calls to batchPushToOrderProposals. */
    public UnaryCallSettings.Builder<
            BatchPushToOrderProposalsRequest, BatchPushToOrderProposalsResponse>
        batchPushToOrderProposalsSettings() {
      return getStubSettingsBuilder().batchPushToOrderProposalsSettings();
    }

    /** Returns the builder for the settings used for calls to fetchMarketplaceComments. */
    public PagedCallSettings.Builder<
            FetchMarketplaceCommentsRequest,
            FetchMarketplaceCommentsResponse,
            FetchMarketplaceCommentsPagedResponse>
        fetchMarketplaceCommentsSettings() {
      return getStubSettingsBuilder().fetchMarketplaceCommentsSettings();
    }

    @Override
    public ProposalServiceSettings build() throws IOException {
      return new ProposalServiceSettings(this);
    }
  }
}
