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

package com.google.developers.knowledge.v1.stub;

import static com.google.developers.knowledge.v1.DeveloperKnowledgeClient.SearchDocumentChunksPagedResponse;

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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.developers.knowledge.v1.AnswerQueryRequest;
import com.google.developers.knowledge.v1.AnswerQueryResponse;
import com.google.developers.knowledge.v1.BatchGetDocumentsRequest;
import com.google.developers.knowledge.v1.BatchGetDocumentsResponse;
import com.google.developers.knowledge.v1.Document;
import com.google.developers.knowledge.v1.DocumentChunk;
import com.google.developers.knowledge.v1.GetDocumentRequest;
import com.google.developers.knowledge.v1.SearchDocumentChunksRequest;
import com.google.developers.knowledge.v1.SearchDocumentChunksResponse;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link DeveloperKnowledgeStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (developerknowledge.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getDocument:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DeveloperKnowledgeStubSettings.Builder developerKnowledgeSettingsBuilder =
 *     DeveloperKnowledgeStubSettings.newBuilder();
 * developerKnowledgeSettingsBuilder
 *     .getDocumentSettings()
 *     .setRetrySettings(
 *         developerKnowledgeSettingsBuilder
 *             .getDocumentSettings()
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
 * DeveloperKnowledgeStubSettings developerKnowledgeSettings =
 *     developerKnowledgeSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@NullMarked
@Generated("by gapic-generator-java")
@SuppressWarnings("CanonicalDuration")
public class DeveloperKnowledgeStubSettings extends StubSettings<DeveloperKnowledgeStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          SearchDocumentChunksRequest,
          SearchDocumentChunksResponse,
          SearchDocumentChunksPagedResponse>
      searchDocumentChunksSettings;
  private final UnaryCallSettings<GetDocumentRequest, Document> getDocumentSettings;
  private final UnaryCallSettings<BatchGetDocumentsRequest, BatchGetDocumentsResponse>
      batchGetDocumentsSettings;
  private final UnaryCallSettings<AnswerQueryRequest, AnswerQueryResponse> answerQuerySettings;

  private static final PagedListDescriptor<
          SearchDocumentChunksRequest, SearchDocumentChunksResponse, DocumentChunk>
      SEARCH_DOCUMENT_CHUNKS_PAGE_STR_DESC =
          new PagedListDescriptor<
              SearchDocumentChunksRequest, SearchDocumentChunksResponse, DocumentChunk>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public SearchDocumentChunksRequest injectToken(
                SearchDocumentChunksRequest payload, String token) {
              return SearchDocumentChunksRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public SearchDocumentChunksRequest injectPageSize(
                SearchDocumentChunksRequest payload, int pageSize) {
              return SearchDocumentChunksRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(SearchDocumentChunksRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(SearchDocumentChunksResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DocumentChunk> extractResources(SearchDocumentChunksResponse payload) {
              return payload.getResultsList();
            }
          };

  private static final PagedListResponseFactory<
          SearchDocumentChunksRequest,
          SearchDocumentChunksResponse,
          SearchDocumentChunksPagedResponse>
      SEARCH_DOCUMENT_CHUNKS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              SearchDocumentChunksRequest,
              SearchDocumentChunksResponse,
              SearchDocumentChunksPagedResponse>() {
            @Override
            public ApiFuture<SearchDocumentChunksPagedResponse> getFuturePagedResponse(
                UnaryCallable<SearchDocumentChunksRequest, SearchDocumentChunksResponse> callable,
                SearchDocumentChunksRequest request,
                ApiCallContext context,
                ApiFuture<SearchDocumentChunksResponse> futureResponse) {
              PageContext<SearchDocumentChunksRequest, SearchDocumentChunksResponse, DocumentChunk>
                  pageContext =
                      PageContext.create(
                          callable, SEARCH_DOCUMENT_CHUNKS_PAGE_STR_DESC, request, context);
              return SearchDocumentChunksPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to searchDocumentChunks. */
  public PagedCallSettings<
          SearchDocumentChunksRequest,
          SearchDocumentChunksResponse,
          SearchDocumentChunksPagedResponse>
      searchDocumentChunksSettings() {
    return searchDocumentChunksSettings;
  }

  /** Returns the object with the settings used for calls to getDocument. */
  public UnaryCallSettings<GetDocumentRequest, Document> getDocumentSettings() {
    return getDocumentSettings;
  }

  /** Returns the object with the settings used for calls to batchGetDocuments. */
  public UnaryCallSettings<BatchGetDocumentsRequest, BatchGetDocumentsResponse>
      batchGetDocumentsSettings() {
    return batchGetDocumentsSettings;
  }

  /** Returns the object with the settings used for calls to answerQuery. */
  public UnaryCallSettings<AnswerQueryRequest, AnswerQueryResponse> answerQuerySettings() {
    return answerQuerySettings;
  }

  public DeveloperKnowledgeStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcDeveloperKnowledgeStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonDeveloperKnowledgeStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "developerknowledge";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "developerknowledge.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "developerknowledge.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(DeveloperKnowledgeStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(DeveloperKnowledgeStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DeveloperKnowledgeStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected DeveloperKnowledgeStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    searchDocumentChunksSettings = settingsBuilder.searchDocumentChunksSettings().build();
    getDocumentSettings = settingsBuilder.getDocumentSettings().build();
    batchGetDocumentsSettings = settingsBuilder.batchGetDocumentsSettings().build();
    answerQuerySettings = settingsBuilder.answerQuerySettings().build();
  }

  @Override
  protected LibraryMetadata getLibraryMetadata() {
    return LibraryMetadata.newBuilder()
        .setArtifactName("com.google.cloud:google-cloud-developer-knowledge")
        .setRepository("googleapis/google-cloud-java")
        .setVersion(Version.VERSION)
        .build();
  }

  /** Builder for DeveloperKnowledgeStubSettings. */
  public static class Builder
      extends StubSettings.Builder<DeveloperKnowledgeStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            SearchDocumentChunksRequest,
            SearchDocumentChunksResponse,
            SearchDocumentChunksPagedResponse>
        searchDocumentChunksSettings;
    private final UnaryCallSettings.Builder<GetDocumentRequest, Document> getDocumentSettings;
    private final UnaryCallSettings.Builder<BatchGetDocumentsRequest, BatchGetDocumentsResponse>
        batchGetDocumentsSettings;
    private final UnaryCallSettings.Builder<AnswerQueryRequest, AnswerQueryResponse>
        answerQuerySettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
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

      searchDocumentChunksSettings =
          PagedCallSettings.newBuilder(SEARCH_DOCUMENT_CHUNKS_PAGE_STR_FACT);
      getDocumentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchGetDocumentsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      answerQuerySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              searchDocumentChunksSettings,
              getDocumentSettings,
              batchGetDocumentsSettings,
              answerQuerySettings);
      initDefaults(this);
    }

    protected Builder(DeveloperKnowledgeStubSettings settings) {
      super(settings);

      searchDocumentChunksSettings = settings.searchDocumentChunksSettings.toBuilder();
      getDocumentSettings = settings.getDocumentSettings.toBuilder();
      batchGetDocumentsSettings = settings.batchGetDocumentsSettings.toBuilder();
      answerQuerySettings = settings.answerQuerySettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              searchDocumentChunksSettings,
              getDocumentSettings,
              batchGetDocumentsSettings,
              answerQuerySettings);
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
          .searchDocumentChunksSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getDocumentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .batchGetDocumentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .answerQuerySettings()
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

    /** Returns the builder for the settings used for calls to searchDocumentChunks. */
    public PagedCallSettings.Builder<
            SearchDocumentChunksRequest,
            SearchDocumentChunksResponse,
            SearchDocumentChunksPagedResponse>
        searchDocumentChunksSettings() {
      return searchDocumentChunksSettings;
    }

    /** Returns the builder for the settings used for calls to getDocument. */
    public UnaryCallSettings.Builder<GetDocumentRequest, Document> getDocumentSettings() {
      return getDocumentSettings;
    }

    /** Returns the builder for the settings used for calls to batchGetDocuments. */
    public UnaryCallSettings.Builder<BatchGetDocumentsRequest, BatchGetDocumentsResponse>
        batchGetDocumentsSettings() {
      return batchGetDocumentsSettings;
    }

    /** Returns the builder for the settings used for calls to answerQuery. */
    public UnaryCallSettings.Builder<AnswerQueryRequest, AnswerQueryResponse>
        answerQuerySettings() {
      return answerQuerySettings;
    }

    @Override
    public DeveloperKnowledgeStubSettings build() throws IOException {
      return new DeveloperKnowledgeStubSettings(this);
    }
  }
}
