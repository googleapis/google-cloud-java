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

package com.google.cloud.chronicle.v1;

import static com.google.cloud.chronicle.v1.FeedsServiceClient.ListFeedPacksPagedResponse;
import static com.google.cloud.chronicle.v1.FeedsServiceClient.ListFeedSourceTypeSchemasPagedResponse;
import static com.google.cloud.chronicle.v1.FeedsServiceClient.ListFeedsPagedResponse;
import static com.google.cloud.chronicle.v1.FeedsServiceClient.ListLogTypeSchemasPagedResponse;

import com.google.api.HttpBody;
import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.chronicle.v1.stub.FeedsServiceStubSettings;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link FeedsServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (chronicle.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of fetchServiceAccountForCustomer:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * FeedsServiceSettings.Builder feedsServiceSettingsBuilder = FeedsServiceSettings.newBuilder();
 * feedsServiceSettingsBuilder
 *     .fetchServiceAccountForCustomerSettings()
 *     .setRetrySettings(
 *         feedsServiceSettingsBuilder
 *             .fetchServiceAccountForCustomerSettings()
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
 * FeedsServiceSettings feedsServiceSettings = feedsServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class FeedsServiceSettings extends ClientSettings<FeedsServiceSettings> {

  /** Returns the object with the settings used for calls to fetchServiceAccountForCustomer. */
  public UnaryCallSettings<FetchServiceAccountForCustomerRequest, FeedServiceAccount>
      fetchServiceAccountForCustomerSettings() {
    return ((FeedsServiceStubSettings) getStubSettings()).fetchServiceAccountForCustomerSettings();
  }

  /** Returns the object with the settings used for calls to createFeed. */
  public UnaryCallSettings<CreateFeedRequest, Feed> createFeedSettings() {
    return ((FeedsServiceStubSettings) getStubSettings()).createFeedSettings();
  }

  /** Returns the object with the settings used for calls to getFeed. */
  public UnaryCallSettings<GetFeedRequest, Feed> getFeedSettings() {
    return ((FeedsServiceStubSettings) getStubSettings()).getFeedSettings();
  }

  /** Returns the object with the settings used for calls to deleteFeed. */
  public UnaryCallSettings<DeleteFeedRequest, Empty> deleteFeedSettings() {
    return ((FeedsServiceStubSettings) getStubSettings()).deleteFeedSettings();
  }

  /** Returns the object with the settings used for calls to enableFeed. */
  public UnaryCallSettings<EnableFeedRequest, Feed> enableFeedSettings() {
    return ((FeedsServiceStubSettings) getStubSettings()).enableFeedSettings();
  }

  /** Returns the object with the settings used for calls to disableFeed. */
  public UnaryCallSettings<DisableFeedRequest, Feed> disableFeedSettings() {
    return ((FeedsServiceStubSettings) getStubSettings()).disableFeedSettings();
  }

  /** Returns the object with the settings used for calls to listFeeds. */
  public PagedCallSettings<ListFeedsRequest, ListFeedsResponse, ListFeedsPagedResponse>
      listFeedsSettings() {
    return ((FeedsServiceStubSettings) getStubSettings()).listFeedsSettings();
  }

  /** Returns the object with the settings used for calls to listFeedPacks. */
  public PagedCallSettings<ListFeedPacksRequest, ListFeedPacksResponse, ListFeedPacksPagedResponse>
      listFeedPacksSettings() {
    return ((FeedsServiceStubSettings) getStubSettings()).listFeedPacksSettings();
  }

  /** Returns the object with the settings used for calls to getFeedPack. */
  public UnaryCallSettings<GetFeedPackRequest, FeedPack> getFeedPackSettings() {
    return ((FeedsServiceStubSettings) getStubSettings()).getFeedPackSettings();
  }

  /** Returns the object with the settings used for calls to updateFeed. */
  public UnaryCallSettings<UpdateFeedRequest, Feed> updateFeedSettings() {
    return ((FeedsServiceStubSettings) getStubSettings()).updateFeedSettings();
  }

  /** Returns the object with the settings used for calls to listFeedSourceTypeSchemas. */
  public PagedCallSettings<
          ListFeedSourceTypeSchemasRequest,
          ListFeedSourceTypeSchemasResponse,
          ListFeedSourceTypeSchemasPagedResponse>
      listFeedSourceTypeSchemasSettings() {
    return ((FeedsServiceStubSettings) getStubSettings()).listFeedSourceTypeSchemasSettings();
  }

  /** Returns the object with the settings used for calls to listLogTypeSchemas. */
  public PagedCallSettings<
          ListLogTypeSchemasRequest, ListLogTypeSchemasResponse, ListLogTypeSchemasPagedResponse>
      listLogTypeSchemasSettings() {
    return ((FeedsServiceStubSettings) getStubSettings()).listLogTypeSchemasSettings();
  }

  /** Returns the object with the settings used for calls to importPushLogs. */
  public UnaryCallSettings<ImportPushLogsRequest, HttpBody> importPushLogsSettings() {
    return ((FeedsServiceStubSettings) getStubSettings()).importPushLogsSettings();
  }

  /** Returns the object with the settings used for calls to generateSecret. */
  public UnaryCallSettings<GenerateSecretRequest, GenerateSecretResponse> generateSecretSettings() {
    return ((FeedsServiceStubSettings) getStubSettings()).generateSecretSettings();
  }

  public static final FeedsServiceSettings create(FeedsServiceStubSettings stub)
      throws IOException {
    return new FeedsServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return FeedsServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return FeedsServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return FeedsServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return FeedsServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return FeedsServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return FeedsServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return FeedsServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return FeedsServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected FeedsServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for FeedsServiceSettings. */
  public static class Builder extends ClientSettings.Builder<FeedsServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(@Nullable ClientContext clientContext) {
      super(FeedsServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(FeedsServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(FeedsServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(FeedsServiceStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(FeedsServiceStubSettings.newHttpJsonBuilder());
    }

    public FeedsServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((FeedsServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to fetchServiceAccountForCustomer. */
    public UnaryCallSettings.Builder<FetchServiceAccountForCustomerRequest, FeedServiceAccount>
        fetchServiceAccountForCustomerSettings() {
      return getStubSettingsBuilder().fetchServiceAccountForCustomerSettings();
    }

    /** Returns the builder for the settings used for calls to createFeed. */
    public UnaryCallSettings.Builder<CreateFeedRequest, Feed> createFeedSettings() {
      return getStubSettingsBuilder().createFeedSettings();
    }

    /** Returns the builder for the settings used for calls to getFeed. */
    public UnaryCallSettings.Builder<GetFeedRequest, Feed> getFeedSettings() {
      return getStubSettingsBuilder().getFeedSettings();
    }

    /** Returns the builder for the settings used for calls to deleteFeed. */
    public UnaryCallSettings.Builder<DeleteFeedRequest, Empty> deleteFeedSettings() {
      return getStubSettingsBuilder().deleteFeedSettings();
    }

    /** Returns the builder for the settings used for calls to enableFeed. */
    public UnaryCallSettings.Builder<EnableFeedRequest, Feed> enableFeedSettings() {
      return getStubSettingsBuilder().enableFeedSettings();
    }

    /** Returns the builder for the settings used for calls to disableFeed. */
    public UnaryCallSettings.Builder<DisableFeedRequest, Feed> disableFeedSettings() {
      return getStubSettingsBuilder().disableFeedSettings();
    }

    /** Returns the builder for the settings used for calls to listFeeds. */
    public PagedCallSettings.Builder<ListFeedsRequest, ListFeedsResponse, ListFeedsPagedResponse>
        listFeedsSettings() {
      return getStubSettingsBuilder().listFeedsSettings();
    }

    /** Returns the builder for the settings used for calls to listFeedPacks. */
    public PagedCallSettings.Builder<
            ListFeedPacksRequest, ListFeedPacksResponse, ListFeedPacksPagedResponse>
        listFeedPacksSettings() {
      return getStubSettingsBuilder().listFeedPacksSettings();
    }

    /** Returns the builder for the settings used for calls to getFeedPack. */
    public UnaryCallSettings.Builder<GetFeedPackRequest, FeedPack> getFeedPackSettings() {
      return getStubSettingsBuilder().getFeedPackSettings();
    }

    /** Returns the builder for the settings used for calls to updateFeed. */
    public UnaryCallSettings.Builder<UpdateFeedRequest, Feed> updateFeedSettings() {
      return getStubSettingsBuilder().updateFeedSettings();
    }

    /** Returns the builder for the settings used for calls to listFeedSourceTypeSchemas. */
    public PagedCallSettings.Builder<
            ListFeedSourceTypeSchemasRequest,
            ListFeedSourceTypeSchemasResponse,
            ListFeedSourceTypeSchemasPagedResponse>
        listFeedSourceTypeSchemasSettings() {
      return getStubSettingsBuilder().listFeedSourceTypeSchemasSettings();
    }

    /** Returns the builder for the settings used for calls to listLogTypeSchemas. */
    public PagedCallSettings.Builder<
            ListLogTypeSchemasRequest, ListLogTypeSchemasResponse, ListLogTypeSchemasPagedResponse>
        listLogTypeSchemasSettings() {
      return getStubSettingsBuilder().listLogTypeSchemasSettings();
    }

    /** Returns the builder for the settings used for calls to importPushLogs. */
    public UnaryCallSettings.Builder<ImportPushLogsRequest, HttpBody> importPushLogsSettings() {
      return getStubSettingsBuilder().importPushLogsSettings();
    }

    /** Returns the builder for the settings used for calls to generateSecret. */
    public UnaryCallSettings.Builder<GenerateSecretRequest, GenerateSecretResponse>
        generateSecretSettings() {
      return getStubSettingsBuilder().generateSecretSettings();
    }

    @Override
    public FeedsServiceSettings build() throws IOException {
      return new FeedsServiceSettings(this);
    }
  }
}
