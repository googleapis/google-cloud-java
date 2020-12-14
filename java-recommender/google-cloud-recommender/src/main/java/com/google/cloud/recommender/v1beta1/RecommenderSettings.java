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

package com.google.cloud.recommender.v1beta1;

import static com.google.cloud.recommender.v1beta1.RecommenderClient.ListInsightsPagedResponse;
import static com.google.cloud.recommender.v1beta1.RecommenderClient.ListRecommendationsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.recommender.v1beta1.stub.RecommenderStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link RecommenderClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (recommender.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getInsight to 30 seconds:
 *
 * <pre>{@code
 * RecommenderSettings.Builder recommenderSettingsBuilder = RecommenderSettings.newBuilder();
 * recommenderSettingsBuilder
 *     .getInsightSettings()
 *     .setRetrySettings(
 *         recommenderSettingsBuilder
 *             .getInsightSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * RecommenderSettings recommenderSettings = recommenderSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class RecommenderSettings extends ClientSettings<RecommenderSettings> {

  /** Returns the object with the settings used for calls to listInsights. */
  public PagedCallSettings<ListInsightsRequest, ListInsightsResponse, ListInsightsPagedResponse>
      listInsightsSettings() {
    return ((RecommenderStubSettings) getStubSettings()).listInsightsSettings();
  }

  /** Returns the object with the settings used for calls to getInsight. */
  public UnaryCallSettings<GetInsightRequest, Insight> getInsightSettings() {
    return ((RecommenderStubSettings) getStubSettings()).getInsightSettings();
  }

  /** Returns the object with the settings used for calls to markInsightAccepted. */
  public UnaryCallSettings<MarkInsightAcceptedRequest, Insight> markInsightAcceptedSettings() {
    return ((RecommenderStubSettings) getStubSettings()).markInsightAcceptedSettings();
  }

  /** Returns the object with the settings used for calls to listRecommendations. */
  public PagedCallSettings<
          ListRecommendationsRequest, ListRecommendationsResponse, ListRecommendationsPagedResponse>
      listRecommendationsSettings() {
    return ((RecommenderStubSettings) getStubSettings()).listRecommendationsSettings();
  }

  /** Returns the object with the settings used for calls to getRecommendation. */
  public UnaryCallSettings<GetRecommendationRequest, Recommendation> getRecommendationSettings() {
    return ((RecommenderStubSettings) getStubSettings()).getRecommendationSettings();
  }

  /** Returns the object with the settings used for calls to markRecommendationClaimed. */
  public UnaryCallSettings<MarkRecommendationClaimedRequest, Recommendation>
      markRecommendationClaimedSettings() {
    return ((RecommenderStubSettings) getStubSettings()).markRecommendationClaimedSettings();
  }

  /** Returns the object with the settings used for calls to markRecommendationSucceeded. */
  public UnaryCallSettings<MarkRecommendationSucceededRequest, Recommendation>
      markRecommendationSucceededSettings() {
    return ((RecommenderStubSettings) getStubSettings()).markRecommendationSucceededSettings();
  }

  /** Returns the object with the settings used for calls to markRecommendationFailed. */
  public UnaryCallSettings<MarkRecommendationFailedRequest, Recommendation>
      markRecommendationFailedSettings() {
    return ((RecommenderStubSettings) getStubSettings()).markRecommendationFailedSettings();
  }

  public static final RecommenderSettings create(RecommenderStubSettings stub) throws IOException {
    return new RecommenderSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return RecommenderStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return RecommenderStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return RecommenderStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return RecommenderStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return RecommenderStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return RecommenderStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return RecommenderStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected RecommenderSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for RecommenderSettings. */
  public static class Builder extends ClientSettings.Builder<RecommenderSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(RecommenderStubSettings.newBuilder(clientContext));
    }

    protected Builder(RecommenderSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(RecommenderStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(RecommenderStubSettings.newBuilder());
    }

    public RecommenderStubSettings.Builder getStubSettingsBuilder() {
      return ((RecommenderStubSettings.Builder) getStubSettings());
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'.
    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) throws Exception {
      super.applyToAllUnaryMethods(
          getStubSettingsBuilder().unaryMethodSettingsBuilders(), settingsUpdater);
      return this;
    }

    /** Returns the builder for the settings used for calls to listInsights. */
    public PagedCallSettings.Builder<
            ListInsightsRequest, ListInsightsResponse, ListInsightsPagedResponse>
        listInsightsSettings() {
      return getStubSettingsBuilder().listInsightsSettings();
    }

    /** Returns the builder for the settings used for calls to getInsight. */
    public UnaryCallSettings.Builder<GetInsightRequest, Insight> getInsightSettings() {
      return getStubSettingsBuilder().getInsightSettings();
    }

    /** Returns the builder for the settings used for calls to markInsightAccepted. */
    public UnaryCallSettings.Builder<MarkInsightAcceptedRequest, Insight>
        markInsightAcceptedSettings() {
      return getStubSettingsBuilder().markInsightAcceptedSettings();
    }

    /** Returns the builder for the settings used for calls to listRecommendations. */
    public PagedCallSettings.Builder<
            ListRecommendationsRequest,
            ListRecommendationsResponse,
            ListRecommendationsPagedResponse>
        listRecommendationsSettings() {
      return getStubSettingsBuilder().listRecommendationsSettings();
    }

    /** Returns the builder for the settings used for calls to getRecommendation. */
    public UnaryCallSettings.Builder<GetRecommendationRequest, Recommendation>
        getRecommendationSettings() {
      return getStubSettingsBuilder().getRecommendationSettings();
    }

    /** Returns the builder for the settings used for calls to markRecommendationClaimed. */
    public UnaryCallSettings.Builder<MarkRecommendationClaimedRequest, Recommendation>
        markRecommendationClaimedSettings() {
      return getStubSettingsBuilder().markRecommendationClaimedSettings();
    }

    /** Returns the builder for the settings used for calls to markRecommendationSucceeded. */
    public UnaryCallSettings.Builder<MarkRecommendationSucceededRequest, Recommendation>
        markRecommendationSucceededSettings() {
      return getStubSettingsBuilder().markRecommendationSucceededSettings();
    }

    /** Returns the builder for the settings used for calls to markRecommendationFailed. */
    public UnaryCallSettings.Builder<MarkRecommendationFailedRequest, Recommendation>
        markRecommendationFailedSettings() {
      return getStubSettingsBuilder().markRecommendationFailedSettings();
    }

    @Override
    public RecommenderSettings build() throws IOException {
      return new RecommenderSettings(this);
    }
  }
}
