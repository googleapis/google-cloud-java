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

import static com.google.cloud.contentwarehouse.v1.DocumentSchemaServiceClient.ListDocumentSchemasPagedResponse;

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
import com.google.cloud.contentwarehouse.v1.CreateDocumentSchemaRequest;
import com.google.cloud.contentwarehouse.v1.DeleteDocumentSchemaRequest;
import com.google.cloud.contentwarehouse.v1.DocumentSchema;
import com.google.cloud.contentwarehouse.v1.GetDocumentSchemaRequest;
import com.google.cloud.contentwarehouse.v1.ListDocumentSchemasRequest;
import com.google.cloud.contentwarehouse.v1.ListDocumentSchemasResponse;
import com.google.cloud.contentwarehouse.v1.UpdateDocumentSchemaRequest;
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
 * Settings class to configure an instance of {@link DocumentSchemaServiceStub}.
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
 * <p>For example, to set the total timeout of createDocumentSchema to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DocumentSchemaServiceStubSettings.Builder documentSchemaServiceSettingsBuilder =
 *     DocumentSchemaServiceStubSettings.newBuilder();
 * documentSchemaServiceSettingsBuilder
 *     .createDocumentSchemaSettings()
 *     .setRetrySettings(
 *         documentSchemaServiceSettingsBuilder
 *             .createDocumentSchemaSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * DocumentSchemaServiceStubSettings documentSchemaServiceSettings =
 *     documentSchemaServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class DocumentSchemaServiceStubSettings
    extends StubSettings<DocumentSchemaServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateDocumentSchemaRequest, DocumentSchema>
      createDocumentSchemaSettings;
  private final UnaryCallSettings<UpdateDocumentSchemaRequest, DocumentSchema>
      updateDocumentSchemaSettings;
  private final UnaryCallSettings<GetDocumentSchemaRequest, DocumentSchema>
      getDocumentSchemaSettings;
  private final UnaryCallSettings<DeleteDocumentSchemaRequest, Empty> deleteDocumentSchemaSettings;
  private final PagedCallSettings<
          ListDocumentSchemasRequest, ListDocumentSchemasResponse, ListDocumentSchemasPagedResponse>
      listDocumentSchemasSettings;

  private static final PagedListDescriptor<
          ListDocumentSchemasRequest, ListDocumentSchemasResponse, DocumentSchema>
      LIST_DOCUMENT_SCHEMAS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListDocumentSchemasRequest, ListDocumentSchemasResponse, DocumentSchema>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDocumentSchemasRequest injectToken(
                ListDocumentSchemasRequest payload, String token) {
              return ListDocumentSchemasRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDocumentSchemasRequest injectPageSize(
                ListDocumentSchemasRequest payload, int pageSize) {
              return ListDocumentSchemasRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListDocumentSchemasRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDocumentSchemasResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DocumentSchema> extractResources(ListDocumentSchemasResponse payload) {
              return payload.getDocumentSchemasList() == null
                  ? ImmutableList.<DocumentSchema>of()
                  : payload.getDocumentSchemasList();
            }
          };

  private static final PagedListResponseFactory<
          ListDocumentSchemasRequest, ListDocumentSchemasResponse, ListDocumentSchemasPagedResponse>
      LIST_DOCUMENT_SCHEMAS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDocumentSchemasRequest,
              ListDocumentSchemasResponse,
              ListDocumentSchemasPagedResponse>() {
            @Override
            public ApiFuture<ListDocumentSchemasPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDocumentSchemasRequest, ListDocumentSchemasResponse> callable,
                ListDocumentSchemasRequest request,
                ApiCallContext context,
                ApiFuture<ListDocumentSchemasResponse> futureResponse) {
              PageContext<ListDocumentSchemasRequest, ListDocumentSchemasResponse, DocumentSchema>
                  pageContext =
                      PageContext.create(
                          callable, LIST_DOCUMENT_SCHEMAS_PAGE_STR_DESC, request, context);
              return ListDocumentSchemasPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createDocumentSchema. */
  public UnaryCallSettings<CreateDocumentSchemaRequest, DocumentSchema>
      createDocumentSchemaSettings() {
    return createDocumentSchemaSettings;
  }

  /** Returns the object with the settings used for calls to updateDocumentSchema. */
  public UnaryCallSettings<UpdateDocumentSchemaRequest, DocumentSchema>
      updateDocumentSchemaSettings() {
    return updateDocumentSchemaSettings;
  }

  /** Returns the object with the settings used for calls to getDocumentSchema. */
  public UnaryCallSettings<GetDocumentSchemaRequest, DocumentSchema> getDocumentSchemaSettings() {
    return getDocumentSchemaSettings;
  }

  /** Returns the object with the settings used for calls to deleteDocumentSchema. */
  public UnaryCallSettings<DeleteDocumentSchemaRequest, Empty> deleteDocumentSchemaSettings() {
    return deleteDocumentSchemaSettings;
  }

  /** Returns the object with the settings used for calls to listDocumentSchemas. */
  public PagedCallSettings<
          ListDocumentSchemasRequest, ListDocumentSchemasResponse, ListDocumentSchemasPagedResponse>
      listDocumentSchemasSettings() {
    return listDocumentSchemasSettings;
  }

  public DocumentSchemaServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcDocumentSchemaServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonDocumentSchemaServiceStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(DocumentSchemaServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(DocumentSchemaServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DocumentSchemaServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected DocumentSchemaServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createDocumentSchemaSettings = settingsBuilder.createDocumentSchemaSettings().build();
    updateDocumentSchemaSettings = settingsBuilder.updateDocumentSchemaSettings().build();
    getDocumentSchemaSettings = settingsBuilder.getDocumentSchemaSettings().build();
    deleteDocumentSchemaSettings = settingsBuilder.deleteDocumentSchemaSettings().build();
    listDocumentSchemasSettings = settingsBuilder.listDocumentSchemasSettings().build();
  }

  /** Builder for DocumentSchemaServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<DocumentSchemaServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateDocumentSchemaRequest, DocumentSchema>
        createDocumentSchemaSettings;
    private final UnaryCallSettings.Builder<UpdateDocumentSchemaRequest, DocumentSchema>
        updateDocumentSchemaSettings;
    private final UnaryCallSettings.Builder<GetDocumentSchemaRequest, DocumentSchema>
        getDocumentSchemaSettings;
    private final UnaryCallSettings.Builder<DeleteDocumentSchemaRequest, Empty>
        deleteDocumentSchemaSettings;
    private final PagedCallSettings.Builder<
            ListDocumentSchemasRequest,
            ListDocumentSchemasResponse,
            ListDocumentSchemasPagedResponse>
        listDocumentSchemasSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "retry_policy_0_codes",
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
      definitions.put("no_retry_1_params", settings);
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
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createDocumentSchemaSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateDocumentSchemaSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getDocumentSchemaSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteDocumentSchemaSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listDocumentSchemasSettings =
          PagedCallSettings.newBuilder(LIST_DOCUMENT_SCHEMAS_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createDocumentSchemaSettings,
              updateDocumentSchemaSettings,
              getDocumentSchemaSettings,
              deleteDocumentSchemaSettings,
              listDocumentSchemasSettings);
      initDefaults(this);
    }

    protected Builder(DocumentSchemaServiceStubSettings settings) {
      super(settings);

      createDocumentSchemaSettings = settings.createDocumentSchemaSettings.toBuilder();
      updateDocumentSchemaSettings = settings.updateDocumentSchemaSettings.toBuilder();
      getDocumentSchemaSettings = settings.getDocumentSchemaSettings.toBuilder();
      deleteDocumentSchemaSettings = settings.deleteDocumentSchemaSettings.toBuilder();
      listDocumentSchemasSettings = settings.listDocumentSchemasSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createDocumentSchemaSettings,
              updateDocumentSchemaSettings,
              getDocumentSchemaSettings,
              deleteDocumentSchemaSettings,
              listDocumentSchemasSettings);
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
          .createDocumentSchemaSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateDocumentSchemaSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getDocumentSchemaSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteDocumentSchemaSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listDocumentSchemasSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

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

    /** Returns the builder for the settings used for calls to createDocumentSchema. */
    public UnaryCallSettings.Builder<CreateDocumentSchemaRequest, DocumentSchema>
        createDocumentSchemaSettings() {
      return createDocumentSchemaSettings;
    }

    /** Returns the builder for the settings used for calls to updateDocumentSchema. */
    public UnaryCallSettings.Builder<UpdateDocumentSchemaRequest, DocumentSchema>
        updateDocumentSchemaSettings() {
      return updateDocumentSchemaSettings;
    }

    /** Returns the builder for the settings used for calls to getDocumentSchema. */
    public UnaryCallSettings.Builder<GetDocumentSchemaRequest, DocumentSchema>
        getDocumentSchemaSettings() {
      return getDocumentSchemaSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDocumentSchema. */
    public UnaryCallSettings.Builder<DeleteDocumentSchemaRequest, Empty>
        deleteDocumentSchemaSettings() {
      return deleteDocumentSchemaSettings;
    }

    /** Returns the builder for the settings used for calls to listDocumentSchemas. */
    public PagedCallSettings.Builder<
            ListDocumentSchemasRequest,
            ListDocumentSchemasResponse,
            ListDocumentSchemasPagedResponse>
        listDocumentSchemasSettings() {
      return listDocumentSchemasSettings;
    }

    @Override
    public DocumentSchemaServiceStubSettings build() throws IOException {
      return new DocumentSchemaServiceStubSettings(this);
    }
  }
}
