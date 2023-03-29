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

package com.google.cloud.contentwarehouse.v1.stub;

import static com.google.cloud.contentwarehouse.v1.DocumentServiceClient.SearchDocumentsPagedResponse;

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
import com.google.cloud.contentwarehouse.v1.CreateDocumentRequest;
import com.google.cloud.contentwarehouse.v1.CreateDocumentResponse;
import com.google.cloud.contentwarehouse.v1.DeleteDocumentRequest;
import com.google.cloud.contentwarehouse.v1.Document;
import com.google.cloud.contentwarehouse.v1.FetchAclRequest;
import com.google.cloud.contentwarehouse.v1.FetchAclResponse;
import com.google.cloud.contentwarehouse.v1.GetDocumentRequest;
import com.google.cloud.contentwarehouse.v1.SearchDocumentsRequest;
import com.google.cloud.contentwarehouse.v1.SearchDocumentsResponse;
import com.google.cloud.contentwarehouse.v1.SetAclRequest;
import com.google.cloud.contentwarehouse.v1.SetAclResponse;
import com.google.cloud.contentwarehouse.v1.UpdateDocumentRequest;
import com.google.cloud.contentwarehouse.v1.UpdateDocumentResponse;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link DocumentServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (contentwarehouse.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createDocument to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DocumentServiceStubSettings.Builder documentServiceSettingsBuilder =
 *     DocumentServiceStubSettings.newBuilder();
 * documentServiceSettingsBuilder
 *     .createDocumentSettings()
 *     .setRetrySettings(
 *         documentServiceSettingsBuilder
 *             .createDocumentSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * DocumentServiceStubSettings documentServiceSettings = documentServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class DocumentServiceStubSettings extends StubSettings<DocumentServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateDocumentRequest, CreateDocumentResponse>
      createDocumentSettings;
  private final UnaryCallSettings<GetDocumentRequest, Document> getDocumentSettings;
  private final UnaryCallSettings<UpdateDocumentRequest, UpdateDocumentResponse>
      updateDocumentSettings;
  private final UnaryCallSettings<DeleteDocumentRequest, Empty> deleteDocumentSettings;
  private final PagedCallSettings<
          SearchDocumentsRequest, SearchDocumentsResponse, SearchDocumentsPagedResponse>
      searchDocumentsSettings;
  private final UnaryCallSettings<FetchAclRequest, FetchAclResponse> fetchAclSettings;
  private final UnaryCallSettings<SetAclRequest, SetAclResponse> setAclSettings;

  private static final PagedListDescriptor<
          SearchDocumentsRequest, SearchDocumentsResponse, SearchDocumentsResponse.MatchingDocument>
      SEARCH_DOCUMENTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              SearchDocumentsRequest,
              SearchDocumentsResponse,
              SearchDocumentsResponse.MatchingDocument>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public SearchDocumentsRequest injectToken(
                SearchDocumentsRequest payload, String token) {
              return SearchDocumentsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public SearchDocumentsRequest injectPageSize(
                SearchDocumentsRequest payload, int pageSize) {
              return SearchDocumentsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(SearchDocumentsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(SearchDocumentsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<SearchDocumentsResponse.MatchingDocument> extractResources(
                SearchDocumentsResponse payload) {
              return payload.getMatchingDocumentsList() == null
                  ? ImmutableList.<SearchDocumentsResponse.MatchingDocument>of()
                  : payload.getMatchingDocumentsList();
            }
          };

  private static final PagedListResponseFactory<
          SearchDocumentsRequest, SearchDocumentsResponse, SearchDocumentsPagedResponse>
      SEARCH_DOCUMENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              SearchDocumentsRequest, SearchDocumentsResponse, SearchDocumentsPagedResponse>() {
            @Override
            public ApiFuture<SearchDocumentsPagedResponse> getFuturePagedResponse(
                UnaryCallable<SearchDocumentsRequest, SearchDocumentsResponse> callable,
                SearchDocumentsRequest request,
                ApiCallContext context,
                ApiFuture<SearchDocumentsResponse> futureResponse) {
              PageContext<
                      SearchDocumentsRequest,
                      SearchDocumentsResponse,
                      SearchDocumentsResponse.MatchingDocument>
                  pageContext =
                      PageContext.create(
                          callable, SEARCH_DOCUMENTS_PAGE_STR_DESC, request, context);
              return SearchDocumentsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createDocument. */
  public UnaryCallSettings<CreateDocumentRequest, CreateDocumentResponse> createDocumentSettings() {
    return createDocumentSettings;
  }

  /** Returns the object with the settings used for calls to getDocument. */
  public UnaryCallSettings<GetDocumentRequest, Document> getDocumentSettings() {
    return getDocumentSettings;
  }

  /** Returns the object with the settings used for calls to updateDocument. */
  public UnaryCallSettings<UpdateDocumentRequest, UpdateDocumentResponse> updateDocumentSettings() {
    return updateDocumentSettings;
  }

  /** Returns the object with the settings used for calls to deleteDocument. */
  public UnaryCallSettings<DeleteDocumentRequest, Empty> deleteDocumentSettings() {
    return deleteDocumentSettings;
  }

  /** Returns the object with the settings used for calls to searchDocuments. */
  public PagedCallSettings<
          SearchDocumentsRequest, SearchDocumentsResponse, SearchDocumentsPagedResponse>
      searchDocumentsSettings() {
    return searchDocumentsSettings;
  }

  /** Returns the object with the settings used for calls to fetchAcl. */
  public UnaryCallSettings<FetchAclRequest, FetchAclResponse> fetchAclSettings() {
    return fetchAclSettings;
  }

  /** Returns the object with the settings used for calls to setAcl. */
  public UnaryCallSettings<SetAclRequest, SetAclResponse> setAclSettings() {
    return setAclSettings;
  }

  public DocumentServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcDocumentServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonDocumentServiceStub.create(this);
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
    return "contentwarehouse.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "contentwarehouse.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(DocumentServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(DocumentServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DocumentServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected DocumentServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createDocumentSettings = settingsBuilder.createDocumentSettings().build();
    getDocumentSettings = settingsBuilder.getDocumentSettings().build();
    updateDocumentSettings = settingsBuilder.updateDocumentSettings().build();
    deleteDocumentSettings = settingsBuilder.deleteDocumentSettings().build();
    searchDocumentsSettings = settingsBuilder.searchDocumentsSettings().build();
    fetchAclSettings = settingsBuilder.fetchAclSettings().build();
    setAclSettings = settingsBuilder.setAclSettings().build();
  }

  /** Builder for DocumentServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<DocumentServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateDocumentRequest, CreateDocumentResponse>
        createDocumentSettings;
    private final UnaryCallSettings.Builder<GetDocumentRequest, Document> getDocumentSettings;
    private final UnaryCallSettings.Builder<UpdateDocumentRequest, UpdateDocumentResponse>
        updateDocumentSettings;
    private final UnaryCallSettings.Builder<DeleteDocumentRequest, Empty> deleteDocumentSettings;
    private final PagedCallSettings.Builder<
            SearchDocumentsRequest, SearchDocumentsResponse, SearchDocumentsPagedResponse>
        searchDocumentsSettings;
    private final UnaryCallSettings.Builder<FetchAclRequest, FetchAclResponse> fetchAclSettings;
    private final UnaryCallSettings.Builder<SetAclRequest, SetAclResponse> setAclSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_2_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(180000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(180000L))
              .setTotalTimeout(Duration.ofMillis(180000L))
              .build();
      definitions.put("no_retry_2_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(10000L))
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_1_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createDocumentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getDocumentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateDocumentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteDocumentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      searchDocumentsSettings = PagedCallSettings.newBuilder(SEARCH_DOCUMENTS_PAGE_STR_FACT);
      fetchAclSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setAclSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createDocumentSettings,
              getDocumentSettings,
              updateDocumentSettings,
              deleteDocumentSettings,
              searchDocumentsSettings,
              fetchAclSettings,
              setAclSettings);
      initDefaults(this);
    }

    protected Builder(DocumentServiceStubSettings settings) {
      super(settings);

      createDocumentSettings = settings.createDocumentSettings.toBuilder();
      getDocumentSettings = settings.getDocumentSettings.toBuilder();
      updateDocumentSettings = settings.updateDocumentSettings.toBuilder();
      deleteDocumentSettings = settings.deleteDocumentSettings.toBuilder();
      searchDocumentsSettings = settings.searchDocumentsSettings.toBuilder();
      fetchAclSettings = settings.fetchAclSettings.toBuilder();
      setAclSettings = settings.setAclSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createDocumentSettings,
              getDocumentSettings,
              updateDocumentSettings,
              deleteDocumentSettings,
              searchDocumentsSettings,
              fetchAclSettings,
              setAclSettings);
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
          .createDocumentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .getDocumentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateDocumentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .deleteDocumentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .searchDocumentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .fetchAclSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .setAclSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

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

    /** Returns the builder for the settings used for calls to createDocument. */
    public UnaryCallSettings.Builder<CreateDocumentRequest, CreateDocumentResponse>
        createDocumentSettings() {
      return createDocumentSettings;
    }

    /** Returns the builder for the settings used for calls to getDocument. */
    public UnaryCallSettings.Builder<GetDocumentRequest, Document> getDocumentSettings() {
      return getDocumentSettings;
    }

    /** Returns the builder for the settings used for calls to updateDocument. */
    public UnaryCallSettings.Builder<UpdateDocumentRequest, UpdateDocumentResponse>
        updateDocumentSettings() {
      return updateDocumentSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDocument. */
    public UnaryCallSettings.Builder<DeleteDocumentRequest, Empty> deleteDocumentSettings() {
      return deleteDocumentSettings;
    }

    /** Returns the builder for the settings used for calls to searchDocuments. */
    public PagedCallSettings.Builder<
            SearchDocumentsRequest, SearchDocumentsResponse, SearchDocumentsPagedResponse>
        searchDocumentsSettings() {
      return searchDocumentsSettings;
    }

    /** Returns the builder for the settings used for calls to fetchAcl. */
    public UnaryCallSettings.Builder<FetchAclRequest, FetchAclResponse> fetchAclSettings() {
      return fetchAclSettings;
    }

    /** Returns the builder for the settings used for calls to setAcl. */
    public UnaryCallSettings.Builder<SetAclRequest, SetAclResponse> setAclSettings() {
      return setAclSettings;
    }

    @Override
    public DocumentServiceStubSettings build() throws IOException {
      return new DocumentServiceStubSettings(this);
    }
  }
}
