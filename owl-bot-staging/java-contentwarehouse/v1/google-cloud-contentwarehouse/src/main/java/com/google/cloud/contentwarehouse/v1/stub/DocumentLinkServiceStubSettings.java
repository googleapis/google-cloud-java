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

import static com.google.cloud.contentwarehouse.v1.DocumentLinkServiceClient.ListLinkedSourcesPagedResponse;

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
import com.google.cloud.contentwarehouse.v1.CreateDocumentLinkRequest;
import com.google.cloud.contentwarehouse.v1.DeleteDocumentLinkRequest;
import com.google.cloud.contentwarehouse.v1.DocumentLink;
import com.google.cloud.contentwarehouse.v1.ListLinkedSourcesRequest;
import com.google.cloud.contentwarehouse.v1.ListLinkedSourcesResponse;
import com.google.cloud.contentwarehouse.v1.ListLinkedTargetsRequest;
import com.google.cloud.contentwarehouse.v1.ListLinkedTargetsResponse;
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
 * Settings class to configure an instance of {@link DocumentLinkServiceStub}.
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
 * <p>For example, to set the total timeout of listLinkedTargets to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DocumentLinkServiceStubSettings.Builder documentLinkServiceSettingsBuilder =
 *     DocumentLinkServiceStubSettings.newBuilder();
 * documentLinkServiceSettingsBuilder
 *     .listLinkedTargetsSettings()
 *     .setRetrySettings(
 *         documentLinkServiceSettingsBuilder
 *             .listLinkedTargetsSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * DocumentLinkServiceStubSettings documentLinkServiceSettings =
 *     documentLinkServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class DocumentLinkServiceStubSettings extends StubSettings<DocumentLinkServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<ListLinkedTargetsRequest, ListLinkedTargetsResponse>
      listLinkedTargetsSettings;
  private final PagedCallSettings<
          ListLinkedSourcesRequest, ListLinkedSourcesResponse, ListLinkedSourcesPagedResponse>
      listLinkedSourcesSettings;
  private final UnaryCallSettings<CreateDocumentLinkRequest, DocumentLink>
      createDocumentLinkSettings;
  private final UnaryCallSettings<DeleteDocumentLinkRequest, Empty> deleteDocumentLinkSettings;

  private static final PagedListDescriptor<
          ListLinkedSourcesRequest, ListLinkedSourcesResponse, DocumentLink>
      LIST_LINKED_SOURCES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListLinkedSourcesRequest, ListLinkedSourcesResponse, DocumentLink>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListLinkedSourcesRequest injectToken(
                ListLinkedSourcesRequest payload, String token) {
              return ListLinkedSourcesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListLinkedSourcesRequest injectPageSize(
                ListLinkedSourcesRequest payload, int pageSize) {
              return ListLinkedSourcesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListLinkedSourcesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListLinkedSourcesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DocumentLink> extractResources(ListLinkedSourcesResponse payload) {
              return payload.getDocumentLinksList() == null
                  ? ImmutableList.<DocumentLink>of()
                  : payload.getDocumentLinksList();
            }
          };

  private static final PagedListResponseFactory<
          ListLinkedSourcesRequest, ListLinkedSourcesResponse, ListLinkedSourcesPagedResponse>
      LIST_LINKED_SOURCES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListLinkedSourcesRequest,
              ListLinkedSourcesResponse,
              ListLinkedSourcesPagedResponse>() {
            @Override
            public ApiFuture<ListLinkedSourcesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListLinkedSourcesRequest, ListLinkedSourcesResponse> callable,
                ListLinkedSourcesRequest request,
                ApiCallContext context,
                ApiFuture<ListLinkedSourcesResponse> futureResponse) {
              PageContext<ListLinkedSourcesRequest, ListLinkedSourcesResponse, DocumentLink>
                  pageContext =
                      PageContext.create(
                          callable, LIST_LINKED_SOURCES_PAGE_STR_DESC, request, context);
              return ListLinkedSourcesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listLinkedTargets. */
  public UnaryCallSettings<ListLinkedTargetsRequest, ListLinkedTargetsResponse>
      listLinkedTargetsSettings() {
    return listLinkedTargetsSettings;
  }

  /** Returns the object with the settings used for calls to listLinkedSources. */
  public PagedCallSettings<
          ListLinkedSourcesRequest, ListLinkedSourcesResponse, ListLinkedSourcesPagedResponse>
      listLinkedSourcesSettings() {
    return listLinkedSourcesSettings;
  }

  /** Returns the object with the settings used for calls to createDocumentLink. */
  public UnaryCallSettings<CreateDocumentLinkRequest, DocumentLink> createDocumentLinkSettings() {
    return createDocumentLinkSettings;
  }

  /** Returns the object with the settings used for calls to deleteDocumentLink. */
  public UnaryCallSettings<DeleteDocumentLinkRequest, Empty> deleteDocumentLinkSettings() {
    return deleteDocumentLinkSettings;
  }

  public DocumentLinkServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcDocumentLinkServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonDocumentLinkServiceStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(DocumentLinkServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(DocumentLinkServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DocumentLinkServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected DocumentLinkServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listLinkedTargetsSettings = settingsBuilder.listLinkedTargetsSettings().build();
    listLinkedSourcesSettings = settingsBuilder.listLinkedSourcesSettings().build();
    createDocumentLinkSettings = settingsBuilder.createDocumentLinkSettings().build();
    deleteDocumentLinkSettings = settingsBuilder.deleteDocumentLinkSettings().build();
  }

  /** Builder for DocumentLinkServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<DocumentLinkServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<ListLinkedTargetsRequest, ListLinkedTargetsResponse>
        listLinkedTargetsSettings;
    private final PagedCallSettings.Builder<
            ListLinkedSourcesRequest, ListLinkedSourcesResponse, ListLinkedSourcesPagedResponse>
        listLinkedSourcesSettings;
    private final UnaryCallSettings.Builder<CreateDocumentLinkRequest, DocumentLink>
        createDocumentLinkSettings;
    private final UnaryCallSettings.Builder<DeleteDocumentLinkRequest, Empty>
        deleteDocumentLinkSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_2_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
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
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listLinkedTargetsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listLinkedSourcesSettings = PagedCallSettings.newBuilder(LIST_LINKED_SOURCES_PAGE_STR_FACT);
      createDocumentLinkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteDocumentLinkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listLinkedTargetsSettings,
              listLinkedSourcesSettings,
              createDocumentLinkSettings,
              deleteDocumentLinkSettings);
      initDefaults(this);
    }

    protected Builder(DocumentLinkServiceStubSettings settings) {
      super(settings);

      listLinkedTargetsSettings = settings.listLinkedTargetsSettings.toBuilder();
      listLinkedSourcesSettings = settings.listLinkedSourcesSettings.toBuilder();
      createDocumentLinkSettings = settings.createDocumentLinkSettings.toBuilder();
      deleteDocumentLinkSettings = settings.deleteDocumentLinkSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listLinkedTargetsSettings,
              listLinkedSourcesSettings,
              createDocumentLinkSettings,
              deleteDocumentLinkSettings);
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
          .listLinkedTargetsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .listLinkedSourcesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .createDocumentLinkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .deleteDocumentLinkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

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

    /** Returns the builder for the settings used for calls to listLinkedTargets. */
    public UnaryCallSettings.Builder<ListLinkedTargetsRequest, ListLinkedTargetsResponse>
        listLinkedTargetsSettings() {
      return listLinkedTargetsSettings;
    }

    /** Returns the builder for the settings used for calls to listLinkedSources. */
    public PagedCallSettings.Builder<
            ListLinkedSourcesRequest, ListLinkedSourcesResponse, ListLinkedSourcesPagedResponse>
        listLinkedSourcesSettings() {
      return listLinkedSourcesSettings;
    }

    /** Returns the builder for the settings used for calls to createDocumentLink. */
    public UnaryCallSettings.Builder<CreateDocumentLinkRequest, DocumentLink>
        createDocumentLinkSettings() {
      return createDocumentLinkSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDocumentLink. */
    public UnaryCallSettings.Builder<DeleteDocumentLinkRequest, Empty>
        deleteDocumentLinkSettings() {
      return deleteDocumentLinkSettings;
    }

    @Override
    public DocumentLinkServiceStubSettings build() throws IOException {
      return new DocumentLinkServiceStubSettings(this);
    }
  }
}
