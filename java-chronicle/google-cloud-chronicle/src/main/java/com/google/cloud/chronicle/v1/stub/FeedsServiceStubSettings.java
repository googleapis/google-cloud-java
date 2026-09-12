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

package com.google.cloud.chronicle.v1.stub;

import static com.google.cloud.chronicle.v1.FeedsServiceClient.ListFeedPacksPagedResponse;
import static com.google.cloud.chronicle.v1.FeedsServiceClient.ListFeedSourceTypeSchemasPagedResponse;
import static com.google.cloud.chronicle.v1.FeedsServiceClient.ListFeedsPagedResponse;
import static com.google.cloud.chronicle.v1.FeedsServiceClient.ListLogTypeSchemasPagedResponse;

import com.google.api.HttpBody;
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
import com.google.cloud.chronicle.v1.CreateFeedRequest;
import com.google.cloud.chronicle.v1.DeleteFeedRequest;
import com.google.cloud.chronicle.v1.DisableFeedRequest;
import com.google.cloud.chronicle.v1.EnableFeedRequest;
import com.google.cloud.chronicle.v1.Feed;
import com.google.cloud.chronicle.v1.FeedPack;
import com.google.cloud.chronicle.v1.FeedServiceAccount;
import com.google.cloud.chronicle.v1.FeedSourceTypeSchema;
import com.google.cloud.chronicle.v1.FetchServiceAccountForCustomerRequest;
import com.google.cloud.chronicle.v1.GenerateSecretRequest;
import com.google.cloud.chronicle.v1.GenerateSecretResponse;
import com.google.cloud.chronicle.v1.GetFeedPackRequest;
import com.google.cloud.chronicle.v1.GetFeedRequest;
import com.google.cloud.chronicle.v1.ImportPushLogsRequest;
import com.google.cloud.chronicle.v1.ListFeedPacksRequest;
import com.google.cloud.chronicle.v1.ListFeedPacksResponse;
import com.google.cloud.chronicle.v1.ListFeedSourceTypeSchemasRequest;
import com.google.cloud.chronicle.v1.ListFeedSourceTypeSchemasResponse;
import com.google.cloud.chronicle.v1.ListFeedsRequest;
import com.google.cloud.chronicle.v1.ListFeedsResponse;
import com.google.cloud.chronicle.v1.ListLogTypeSchemasRequest;
import com.google.cloud.chronicle.v1.ListLogTypeSchemasResponse;
import com.google.cloud.chronicle.v1.LogTypeSchema;
import com.google.cloud.chronicle.v1.UpdateFeedRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link FeedsServiceStub}.
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
 * FeedsServiceStubSettings.Builder feedsServiceSettingsBuilder =
 *     FeedsServiceStubSettings.newBuilder();
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
 * FeedsServiceStubSettings feedsServiceSettings = feedsServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@NullMarked
@Generated("by gapic-generator-java")
@SuppressWarnings("CanonicalDuration")
public class FeedsServiceStubSettings extends StubSettings<FeedsServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/chronicle")
          .add("https://www.googleapis.com/auth/chronicle.readonly")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .build();

  private final UnaryCallSettings<FetchServiceAccountForCustomerRequest, FeedServiceAccount>
      fetchServiceAccountForCustomerSettings;
  private final UnaryCallSettings<CreateFeedRequest, Feed> createFeedSettings;
  private final UnaryCallSettings<GetFeedRequest, Feed> getFeedSettings;
  private final UnaryCallSettings<DeleteFeedRequest, Empty> deleteFeedSettings;
  private final UnaryCallSettings<EnableFeedRequest, Feed> enableFeedSettings;
  private final UnaryCallSettings<DisableFeedRequest, Feed> disableFeedSettings;
  private final PagedCallSettings<ListFeedsRequest, ListFeedsResponse, ListFeedsPagedResponse>
      listFeedsSettings;
  private final PagedCallSettings<
          ListFeedPacksRequest, ListFeedPacksResponse, ListFeedPacksPagedResponse>
      listFeedPacksSettings;
  private final UnaryCallSettings<GetFeedPackRequest, FeedPack> getFeedPackSettings;
  private final UnaryCallSettings<UpdateFeedRequest, Feed> updateFeedSettings;
  private final PagedCallSettings<
          ListFeedSourceTypeSchemasRequest,
          ListFeedSourceTypeSchemasResponse,
          ListFeedSourceTypeSchemasPagedResponse>
      listFeedSourceTypeSchemasSettings;
  private final PagedCallSettings<
          ListLogTypeSchemasRequest, ListLogTypeSchemasResponse, ListLogTypeSchemasPagedResponse>
      listLogTypeSchemasSettings;
  private final UnaryCallSettings<ImportPushLogsRequest, HttpBody> importPushLogsSettings;
  private final UnaryCallSettings<GenerateSecretRequest, GenerateSecretResponse>
      generateSecretSettings;

  private static final PagedListDescriptor<ListFeedsRequest, ListFeedsResponse, Feed>
      LIST_FEEDS_PAGE_STR_DESC =
          new PagedListDescriptor<ListFeedsRequest, ListFeedsResponse, Feed>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListFeedsRequest injectToken(ListFeedsRequest payload, String token) {
              return ListFeedsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListFeedsRequest injectPageSize(ListFeedsRequest payload, int pageSize) {
              return ListFeedsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListFeedsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListFeedsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Feed> extractResources(ListFeedsResponse payload) {
              return payload.getFeedsList();
            }
          };

  private static final PagedListDescriptor<ListFeedPacksRequest, ListFeedPacksResponse, FeedPack>
      LIST_FEED_PACKS_PAGE_STR_DESC =
          new PagedListDescriptor<ListFeedPacksRequest, ListFeedPacksResponse, FeedPack>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListFeedPacksRequest injectToken(ListFeedPacksRequest payload, String token) {
              return ListFeedPacksRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListFeedPacksRequest injectPageSize(ListFeedPacksRequest payload, int pageSize) {
              return ListFeedPacksRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListFeedPacksRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListFeedPacksResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<FeedPack> extractResources(ListFeedPacksResponse payload) {
              return payload.getFeedPacksList();
            }
          };

  private static final PagedListDescriptor<
          ListFeedSourceTypeSchemasRequest, ListFeedSourceTypeSchemasResponse, FeedSourceTypeSchema>
      LIST_FEED_SOURCE_TYPE_SCHEMAS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListFeedSourceTypeSchemasRequest,
              ListFeedSourceTypeSchemasResponse,
              FeedSourceTypeSchema>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListFeedSourceTypeSchemasRequest injectToken(
                ListFeedSourceTypeSchemasRequest payload, String token) {
              return ListFeedSourceTypeSchemasRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListFeedSourceTypeSchemasRequest injectPageSize(
                ListFeedSourceTypeSchemasRequest payload, int pageSize) {
              return ListFeedSourceTypeSchemasRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListFeedSourceTypeSchemasRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListFeedSourceTypeSchemasResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<FeedSourceTypeSchema> extractResources(
                ListFeedSourceTypeSchemasResponse payload) {
              return payload.getFeedSourceTypeSchemasList();
            }
          };

  private static final PagedListDescriptor<
          ListLogTypeSchemasRequest, ListLogTypeSchemasResponse, LogTypeSchema>
      LIST_LOG_TYPE_SCHEMAS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListLogTypeSchemasRequest, ListLogTypeSchemasResponse, LogTypeSchema>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListLogTypeSchemasRequest injectToken(
                ListLogTypeSchemasRequest payload, String token) {
              return ListLogTypeSchemasRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListLogTypeSchemasRequest injectPageSize(
                ListLogTypeSchemasRequest payload, int pageSize) {
              return ListLogTypeSchemasRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListLogTypeSchemasRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListLogTypeSchemasResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<LogTypeSchema> extractResources(ListLogTypeSchemasResponse payload) {
              return payload.getLogTypeSchemasList();
            }
          };

  private static final PagedListResponseFactory<
          ListFeedsRequest, ListFeedsResponse, ListFeedsPagedResponse>
      LIST_FEEDS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListFeedsRequest, ListFeedsResponse, ListFeedsPagedResponse>() {
            @Override
            public ApiFuture<ListFeedsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListFeedsRequest, ListFeedsResponse> callable,
                ListFeedsRequest request,
                ApiCallContext context,
                ApiFuture<ListFeedsResponse> futureResponse) {
              PageContext<ListFeedsRequest, ListFeedsResponse, Feed> pageContext =
                  PageContext.create(callable, LIST_FEEDS_PAGE_STR_DESC, request, context);
              return ListFeedsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListFeedPacksRequest, ListFeedPacksResponse, ListFeedPacksPagedResponse>
      LIST_FEED_PACKS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListFeedPacksRequest, ListFeedPacksResponse, ListFeedPacksPagedResponse>() {
            @Override
            public ApiFuture<ListFeedPacksPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListFeedPacksRequest, ListFeedPacksResponse> callable,
                ListFeedPacksRequest request,
                ApiCallContext context,
                ApiFuture<ListFeedPacksResponse> futureResponse) {
              PageContext<ListFeedPacksRequest, ListFeedPacksResponse, FeedPack> pageContext =
                  PageContext.create(callable, LIST_FEED_PACKS_PAGE_STR_DESC, request, context);
              return ListFeedPacksPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListFeedSourceTypeSchemasRequest,
          ListFeedSourceTypeSchemasResponse,
          ListFeedSourceTypeSchemasPagedResponse>
      LIST_FEED_SOURCE_TYPE_SCHEMAS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListFeedSourceTypeSchemasRequest,
              ListFeedSourceTypeSchemasResponse,
              ListFeedSourceTypeSchemasPagedResponse>() {
            @Override
            public ApiFuture<ListFeedSourceTypeSchemasPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListFeedSourceTypeSchemasRequest, ListFeedSourceTypeSchemasResponse>
                    callable,
                ListFeedSourceTypeSchemasRequest request,
                ApiCallContext context,
                ApiFuture<ListFeedSourceTypeSchemasResponse> futureResponse) {
              PageContext<
                      ListFeedSourceTypeSchemasRequest,
                      ListFeedSourceTypeSchemasResponse,
                      FeedSourceTypeSchema>
                  pageContext =
                      PageContext.create(
                          callable, LIST_FEED_SOURCE_TYPE_SCHEMAS_PAGE_STR_DESC, request, context);
              return ListFeedSourceTypeSchemasPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListLogTypeSchemasRequest, ListLogTypeSchemasResponse, ListLogTypeSchemasPagedResponse>
      LIST_LOG_TYPE_SCHEMAS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListLogTypeSchemasRequest,
              ListLogTypeSchemasResponse,
              ListLogTypeSchemasPagedResponse>() {
            @Override
            public ApiFuture<ListLogTypeSchemasPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListLogTypeSchemasRequest, ListLogTypeSchemasResponse> callable,
                ListLogTypeSchemasRequest request,
                ApiCallContext context,
                ApiFuture<ListLogTypeSchemasResponse> futureResponse) {
              PageContext<ListLogTypeSchemasRequest, ListLogTypeSchemasResponse, LogTypeSchema>
                  pageContext =
                      PageContext.create(
                          callable, LIST_LOG_TYPE_SCHEMAS_PAGE_STR_DESC, request, context);
              return ListLogTypeSchemasPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to fetchServiceAccountForCustomer. */
  public UnaryCallSettings<FetchServiceAccountForCustomerRequest, FeedServiceAccount>
      fetchServiceAccountForCustomerSettings() {
    return fetchServiceAccountForCustomerSettings;
  }

  /** Returns the object with the settings used for calls to createFeed. */
  public UnaryCallSettings<CreateFeedRequest, Feed> createFeedSettings() {
    return createFeedSettings;
  }

  /** Returns the object with the settings used for calls to getFeed. */
  public UnaryCallSettings<GetFeedRequest, Feed> getFeedSettings() {
    return getFeedSettings;
  }

  /** Returns the object with the settings used for calls to deleteFeed. */
  public UnaryCallSettings<DeleteFeedRequest, Empty> deleteFeedSettings() {
    return deleteFeedSettings;
  }

  /** Returns the object with the settings used for calls to enableFeed. */
  public UnaryCallSettings<EnableFeedRequest, Feed> enableFeedSettings() {
    return enableFeedSettings;
  }

  /** Returns the object with the settings used for calls to disableFeed. */
  public UnaryCallSettings<DisableFeedRequest, Feed> disableFeedSettings() {
    return disableFeedSettings;
  }

  /** Returns the object with the settings used for calls to listFeeds. */
  public PagedCallSettings<ListFeedsRequest, ListFeedsResponse, ListFeedsPagedResponse>
      listFeedsSettings() {
    return listFeedsSettings;
  }

  /** Returns the object with the settings used for calls to listFeedPacks. */
  public PagedCallSettings<ListFeedPacksRequest, ListFeedPacksResponse, ListFeedPacksPagedResponse>
      listFeedPacksSettings() {
    return listFeedPacksSettings;
  }

  /** Returns the object with the settings used for calls to getFeedPack. */
  public UnaryCallSettings<GetFeedPackRequest, FeedPack> getFeedPackSettings() {
    return getFeedPackSettings;
  }

  /** Returns the object with the settings used for calls to updateFeed. */
  public UnaryCallSettings<UpdateFeedRequest, Feed> updateFeedSettings() {
    return updateFeedSettings;
  }

  /** Returns the object with the settings used for calls to listFeedSourceTypeSchemas. */
  public PagedCallSettings<
          ListFeedSourceTypeSchemasRequest,
          ListFeedSourceTypeSchemasResponse,
          ListFeedSourceTypeSchemasPagedResponse>
      listFeedSourceTypeSchemasSettings() {
    return listFeedSourceTypeSchemasSettings;
  }

  /** Returns the object with the settings used for calls to listLogTypeSchemas. */
  public PagedCallSettings<
          ListLogTypeSchemasRequest, ListLogTypeSchemasResponse, ListLogTypeSchemasPagedResponse>
      listLogTypeSchemasSettings() {
    return listLogTypeSchemasSettings;
  }

  /** Returns the object with the settings used for calls to importPushLogs. */
  public UnaryCallSettings<ImportPushLogsRequest, HttpBody> importPushLogsSettings() {
    return importPushLogsSettings;
  }

  /** Returns the object with the settings used for calls to generateSecret. */
  public UnaryCallSettings<GenerateSecretRequest, GenerateSecretResponse> generateSecretSettings() {
    return generateSecretSettings;
  }

  public FeedsServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcFeedsServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonFeedsServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "chronicle";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "chronicle.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "chronicle.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(FeedsServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(FeedsServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return FeedsServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected FeedsServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    fetchServiceAccountForCustomerSettings =
        settingsBuilder.fetchServiceAccountForCustomerSettings().build();
    createFeedSettings = settingsBuilder.createFeedSettings().build();
    getFeedSettings = settingsBuilder.getFeedSettings().build();
    deleteFeedSettings = settingsBuilder.deleteFeedSettings().build();
    enableFeedSettings = settingsBuilder.enableFeedSettings().build();
    disableFeedSettings = settingsBuilder.disableFeedSettings().build();
    listFeedsSettings = settingsBuilder.listFeedsSettings().build();
    listFeedPacksSettings = settingsBuilder.listFeedPacksSettings().build();
    getFeedPackSettings = settingsBuilder.getFeedPackSettings().build();
    updateFeedSettings = settingsBuilder.updateFeedSettings().build();
    listFeedSourceTypeSchemasSettings = settingsBuilder.listFeedSourceTypeSchemasSettings().build();
    listLogTypeSchemasSettings = settingsBuilder.listLogTypeSchemasSettings().build();
    importPushLogsSettings = settingsBuilder.importPushLogsSettings().build();
    generateSecretSettings = settingsBuilder.generateSecretSettings().build();
  }

  @Override
  protected LibraryMetadata getLibraryMetadata() {
    return LibraryMetadata.newBuilder()
        .setArtifactName("com.google.cloud:google-cloud-chronicle")
        .setRepository("googleapis/google-cloud-java")
        .setVersion(Version.VERSION)
        .build();
  }

  /** Builder for FeedsServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<FeedsServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<
            FetchServiceAccountForCustomerRequest, FeedServiceAccount>
        fetchServiceAccountForCustomerSettings;
    private final UnaryCallSettings.Builder<CreateFeedRequest, Feed> createFeedSettings;
    private final UnaryCallSettings.Builder<GetFeedRequest, Feed> getFeedSettings;
    private final UnaryCallSettings.Builder<DeleteFeedRequest, Empty> deleteFeedSettings;
    private final UnaryCallSettings.Builder<EnableFeedRequest, Feed> enableFeedSettings;
    private final UnaryCallSettings.Builder<DisableFeedRequest, Feed> disableFeedSettings;
    private final PagedCallSettings.Builder<
            ListFeedsRequest, ListFeedsResponse, ListFeedsPagedResponse>
        listFeedsSettings;
    private final PagedCallSettings.Builder<
            ListFeedPacksRequest, ListFeedPacksResponse, ListFeedPacksPagedResponse>
        listFeedPacksSettings;
    private final UnaryCallSettings.Builder<GetFeedPackRequest, FeedPack> getFeedPackSettings;
    private final UnaryCallSettings.Builder<UpdateFeedRequest, Feed> updateFeedSettings;
    private final PagedCallSettings.Builder<
            ListFeedSourceTypeSchemasRequest,
            ListFeedSourceTypeSchemasResponse,
            ListFeedSourceTypeSchemasPagedResponse>
        listFeedSourceTypeSchemasSettings;
    private final PagedCallSettings.Builder<
            ListLogTypeSchemasRequest, ListLogTypeSchemasResponse, ListLogTypeSchemasPagedResponse>
        listLogTypeSchemasSettings;
    private final UnaryCallSettings.Builder<ImportPushLogsRequest, HttpBody> importPushLogsSettings;
    private final UnaryCallSettings.Builder<GenerateSecretRequest, GenerateSecretResponse>
        generateSecretSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_16_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "no_retry_18_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "retry_policy_15_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "retry_policy_17_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "no_retry_19_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "no_retry_20_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
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
              .setMaxRetryDelayDuration(Duration.ofMillis(60000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_16_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeoutDuration(Duration.ofMillis(300000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(300000L))
              .setTotalTimeoutDuration(Duration.ofMillis(300000L))
              .build();
      definitions.put("no_retry_18_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(30000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(30000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(30000L))
              .setTotalTimeoutDuration(Duration.ofMillis(30000L))
              .build();
      definitions.put("retry_policy_15_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(300000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(300000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(300000L))
              .setTotalTimeoutDuration(Duration.ofMillis(300000L))
              .build();
      definitions.put("retry_policy_17_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeoutDuration(Duration.ofMillis(120000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(120000L))
              .setTotalTimeoutDuration(Duration.ofMillis(120000L))
              .build();
      definitions.put("no_retry_19_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_20_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(@Nullable ClientContext clientContext) {
      super(clientContext);

      fetchServiceAccountForCustomerSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createFeedSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getFeedSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteFeedSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      enableFeedSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      disableFeedSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listFeedsSettings = PagedCallSettings.newBuilder(LIST_FEEDS_PAGE_STR_FACT);
      listFeedPacksSettings = PagedCallSettings.newBuilder(LIST_FEED_PACKS_PAGE_STR_FACT);
      getFeedPackSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateFeedSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listFeedSourceTypeSchemasSettings =
          PagedCallSettings.newBuilder(LIST_FEED_SOURCE_TYPE_SCHEMAS_PAGE_STR_FACT);
      listLogTypeSchemasSettings =
          PagedCallSettings.newBuilder(LIST_LOG_TYPE_SCHEMAS_PAGE_STR_FACT);
      importPushLogsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      generateSecretSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              fetchServiceAccountForCustomerSettings,
              createFeedSettings,
              getFeedSettings,
              deleteFeedSettings,
              enableFeedSettings,
              disableFeedSettings,
              listFeedsSettings,
              listFeedPacksSettings,
              getFeedPackSettings,
              updateFeedSettings,
              listFeedSourceTypeSchemasSettings,
              listLogTypeSchemasSettings,
              importPushLogsSettings,
              generateSecretSettings);
      initDefaults(this);
    }

    protected Builder(FeedsServiceStubSettings settings) {
      super(settings);

      fetchServiceAccountForCustomerSettings =
          settings.fetchServiceAccountForCustomerSettings.toBuilder();
      createFeedSettings = settings.createFeedSettings.toBuilder();
      getFeedSettings = settings.getFeedSettings.toBuilder();
      deleteFeedSettings = settings.deleteFeedSettings.toBuilder();
      enableFeedSettings = settings.enableFeedSettings.toBuilder();
      disableFeedSettings = settings.disableFeedSettings.toBuilder();
      listFeedsSettings = settings.listFeedsSettings.toBuilder();
      listFeedPacksSettings = settings.listFeedPacksSettings.toBuilder();
      getFeedPackSettings = settings.getFeedPackSettings.toBuilder();
      updateFeedSettings = settings.updateFeedSettings.toBuilder();
      listFeedSourceTypeSchemasSettings = settings.listFeedSourceTypeSchemasSettings.toBuilder();
      listLogTypeSchemasSettings = settings.listLogTypeSchemasSettings.toBuilder();
      importPushLogsSettings = settings.importPushLogsSettings.toBuilder();
      generateSecretSettings = settings.generateSecretSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              fetchServiceAccountForCustomerSettings,
              createFeedSettings,
              getFeedSettings,
              deleteFeedSettings,
              enableFeedSettings,
              disableFeedSettings,
              listFeedsSettings,
              listFeedPacksSettings,
              getFeedPackSettings,
              updateFeedSettings,
              listFeedSourceTypeSchemasSettings,
              listLogTypeSchemasSettings,
              importPushLogsSettings,
              generateSecretSettings);
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
          .fetchServiceAccountForCustomerSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_16_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_16_params"));

      builder
          .createFeedSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_18_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_18_params"));

      builder
          .getFeedSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_15_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_15_params"));

      builder
          .deleteFeedSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_18_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_18_params"));

      builder
          .enableFeedSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_18_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_18_params"));

      builder
          .disableFeedSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_18_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_18_params"));

      builder
          .listFeedsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_17_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_17_params"));

      builder
          .listFeedPacksSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_16_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_16_params"));

      builder
          .getFeedPackSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_15_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_15_params"));

      builder
          .updateFeedSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_18_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_18_params"));

      builder
          .listFeedSourceTypeSchemasSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_16_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_16_params"));

      builder
          .listLogTypeSchemasSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_16_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_16_params"));

      builder
          .importPushLogsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_19_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_19_params"));

      builder
          .generateSecretSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_20_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_20_params"));

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

    /** Returns the builder for the settings used for calls to fetchServiceAccountForCustomer. */
    public UnaryCallSettings.Builder<FetchServiceAccountForCustomerRequest, FeedServiceAccount>
        fetchServiceAccountForCustomerSettings() {
      return fetchServiceAccountForCustomerSettings;
    }

    /** Returns the builder for the settings used for calls to createFeed. */
    public UnaryCallSettings.Builder<CreateFeedRequest, Feed> createFeedSettings() {
      return createFeedSettings;
    }

    /** Returns the builder for the settings used for calls to getFeed. */
    public UnaryCallSettings.Builder<GetFeedRequest, Feed> getFeedSettings() {
      return getFeedSettings;
    }

    /** Returns the builder for the settings used for calls to deleteFeed. */
    public UnaryCallSettings.Builder<DeleteFeedRequest, Empty> deleteFeedSettings() {
      return deleteFeedSettings;
    }

    /** Returns the builder for the settings used for calls to enableFeed. */
    public UnaryCallSettings.Builder<EnableFeedRequest, Feed> enableFeedSettings() {
      return enableFeedSettings;
    }

    /** Returns the builder for the settings used for calls to disableFeed. */
    public UnaryCallSettings.Builder<DisableFeedRequest, Feed> disableFeedSettings() {
      return disableFeedSettings;
    }

    /** Returns the builder for the settings used for calls to listFeeds. */
    public PagedCallSettings.Builder<ListFeedsRequest, ListFeedsResponse, ListFeedsPagedResponse>
        listFeedsSettings() {
      return listFeedsSettings;
    }

    /** Returns the builder for the settings used for calls to listFeedPacks. */
    public PagedCallSettings.Builder<
            ListFeedPacksRequest, ListFeedPacksResponse, ListFeedPacksPagedResponse>
        listFeedPacksSettings() {
      return listFeedPacksSettings;
    }

    /** Returns the builder for the settings used for calls to getFeedPack. */
    public UnaryCallSettings.Builder<GetFeedPackRequest, FeedPack> getFeedPackSettings() {
      return getFeedPackSettings;
    }

    /** Returns the builder for the settings used for calls to updateFeed. */
    public UnaryCallSettings.Builder<UpdateFeedRequest, Feed> updateFeedSettings() {
      return updateFeedSettings;
    }

    /** Returns the builder for the settings used for calls to listFeedSourceTypeSchemas. */
    public PagedCallSettings.Builder<
            ListFeedSourceTypeSchemasRequest,
            ListFeedSourceTypeSchemasResponse,
            ListFeedSourceTypeSchemasPagedResponse>
        listFeedSourceTypeSchemasSettings() {
      return listFeedSourceTypeSchemasSettings;
    }

    /** Returns the builder for the settings used for calls to listLogTypeSchemas. */
    public PagedCallSettings.Builder<
            ListLogTypeSchemasRequest, ListLogTypeSchemasResponse, ListLogTypeSchemasPagedResponse>
        listLogTypeSchemasSettings() {
      return listLogTypeSchemasSettings;
    }

    /** Returns the builder for the settings used for calls to importPushLogs. */
    public UnaryCallSettings.Builder<ImportPushLogsRequest, HttpBody> importPushLogsSettings() {
      return importPushLogsSettings;
    }

    /** Returns the builder for the settings used for calls to generateSecret. */
    public UnaryCallSettings.Builder<GenerateSecretRequest, GenerateSecretResponse>
        generateSecretSettings() {
      return generateSecretSettings;
    }

    @Override
    public FeedsServiceStubSettings build() throws IOException {
      return new FeedsServiceStubSettings(this);
    }
  }
}
