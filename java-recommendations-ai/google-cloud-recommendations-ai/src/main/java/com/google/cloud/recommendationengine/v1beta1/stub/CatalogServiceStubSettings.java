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

package com.google.cloud.recommendationengine.v1beta1.stub;

import static com.google.cloud.recommendationengine.v1beta1.CatalogServiceClient.ListCatalogItemsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.grpc.ProtoOperationTransformers;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.longrunning.OperationTimedPollAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.recommendationengine.v1beta1.CatalogItem;
import com.google.cloud.recommendationengine.v1beta1.CreateCatalogItemRequest;
import com.google.cloud.recommendationengine.v1beta1.DeleteCatalogItemRequest;
import com.google.cloud.recommendationengine.v1beta1.GetCatalogItemRequest;
import com.google.cloud.recommendationengine.v1beta1.ImportCatalogItemsRequest;
import com.google.cloud.recommendationengine.v1beta1.ImportCatalogItemsResponse;
import com.google.cloud.recommendationengine.v1beta1.ImportMetadata;
import com.google.cloud.recommendationengine.v1beta1.ListCatalogItemsRequest;
import com.google.cloud.recommendationengine.v1beta1.ListCatalogItemsResponse;
import com.google.cloud.recommendationengine.v1beta1.UpdateCatalogItemRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link CatalogServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (recommendationengine.googleapis.com) and default port (443)
 *       are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createCatalogItem to 30 seconds:
 *
 * <pre>{@code
 * CatalogServiceStubSettings.Builder catalogServiceSettingsBuilder =
 *     CatalogServiceStubSettings.newBuilder();
 * catalogServiceSettingsBuilder
 *     .createCatalogItemSettings()
 *     .setRetrySettings(
 *         catalogServiceSettingsBuilder
 *             .createCatalogItemSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * CatalogServiceStubSettings catalogServiceSettings = catalogServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class CatalogServiceStubSettings extends StubSettings<CatalogServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateCatalogItemRequest, CatalogItem> createCatalogItemSettings;
  private final UnaryCallSettings<GetCatalogItemRequest, CatalogItem> getCatalogItemSettings;
  private final PagedCallSettings<
          ListCatalogItemsRequest, ListCatalogItemsResponse, ListCatalogItemsPagedResponse>
      listCatalogItemsSettings;
  private final UnaryCallSettings<UpdateCatalogItemRequest, CatalogItem> updateCatalogItemSettings;
  private final UnaryCallSettings<DeleteCatalogItemRequest, Empty> deleteCatalogItemSettings;
  private final UnaryCallSettings<ImportCatalogItemsRequest, Operation> importCatalogItemsSettings;
  private final OperationCallSettings<
          ImportCatalogItemsRequest, ImportCatalogItemsResponse, ImportMetadata>
      importCatalogItemsOperationSettings;

  private static final PagedListDescriptor<
          ListCatalogItemsRequest, ListCatalogItemsResponse, CatalogItem>
      LIST_CATALOG_ITEMS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListCatalogItemsRequest, ListCatalogItemsResponse, CatalogItem>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListCatalogItemsRequest injectToken(
                ListCatalogItemsRequest payload, String token) {
              return ListCatalogItemsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListCatalogItemsRequest injectPageSize(
                ListCatalogItemsRequest payload, int pageSize) {
              return ListCatalogItemsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListCatalogItemsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListCatalogItemsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<CatalogItem> extractResources(ListCatalogItemsResponse payload) {
              return payload.getCatalogItemsList() == null
                  ? ImmutableList.<CatalogItem>of()
                  : payload.getCatalogItemsList();
            }
          };

  private static final PagedListResponseFactory<
          ListCatalogItemsRequest, ListCatalogItemsResponse, ListCatalogItemsPagedResponse>
      LIST_CATALOG_ITEMS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListCatalogItemsRequest, ListCatalogItemsResponse, ListCatalogItemsPagedResponse>() {
            @Override
            public ApiFuture<ListCatalogItemsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListCatalogItemsRequest, ListCatalogItemsResponse> callable,
                ListCatalogItemsRequest request,
                ApiCallContext context,
                ApiFuture<ListCatalogItemsResponse> futureResponse) {
              PageContext<ListCatalogItemsRequest, ListCatalogItemsResponse, CatalogItem>
                  pageContext =
                      PageContext.create(
                          callable, LIST_CATALOG_ITEMS_PAGE_STR_DESC, request, context);
              return ListCatalogItemsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createCatalogItem. */
  public UnaryCallSettings<CreateCatalogItemRequest, CatalogItem> createCatalogItemSettings() {
    return createCatalogItemSettings;
  }

  /** Returns the object with the settings used for calls to getCatalogItem. */
  public UnaryCallSettings<GetCatalogItemRequest, CatalogItem> getCatalogItemSettings() {
    return getCatalogItemSettings;
  }

  /** Returns the object with the settings used for calls to listCatalogItems. */
  public PagedCallSettings<
          ListCatalogItemsRequest, ListCatalogItemsResponse, ListCatalogItemsPagedResponse>
      listCatalogItemsSettings() {
    return listCatalogItemsSettings;
  }

  /** Returns the object with the settings used for calls to updateCatalogItem. */
  public UnaryCallSettings<UpdateCatalogItemRequest, CatalogItem> updateCatalogItemSettings() {
    return updateCatalogItemSettings;
  }

  /** Returns the object with the settings used for calls to deleteCatalogItem. */
  public UnaryCallSettings<DeleteCatalogItemRequest, Empty> deleteCatalogItemSettings() {
    return deleteCatalogItemSettings;
  }

  /** Returns the object with the settings used for calls to importCatalogItems. */
  public UnaryCallSettings<ImportCatalogItemsRequest, Operation> importCatalogItemsSettings() {
    return importCatalogItemsSettings;
  }

  /** Returns the object with the settings used for calls to importCatalogItems. */
  public OperationCallSettings<
          ImportCatalogItemsRequest, ImportCatalogItemsResponse, ImportMetadata>
      importCatalogItemsOperationSettings() {
    return importCatalogItemsOperationSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public CatalogServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcCatalogServiceStub.create(this);
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
    return "recommendationengine.googleapis.com:443";
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder().setScopesToApply(DEFAULT_SERVICE_SCOPES);
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(CatalogServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
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

  protected CatalogServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createCatalogItemSettings = settingsBuilder.createCatalogItemSettings().build();
    getCatalogItemSettings = settingsBuilder.getCatalogItemSettings().build();
    listCatalogItemsSettings = settingsBuilder.listCatalogItemsSettings().build();
    updateCatalogItemSettings = settingsBuilder.updateCatalogItemSettings().build();
    deleteCatalogItemSettings = settingsBuilder.deleteCatalogItemSettings().build();
    importCatalogItemsSettings = settingsBuilder.importCatalogItemsSettings().build();
    importCatalogItemsOperationSettings =
        settingsBuilder.importCatalogItemsOperationSettings().build();
  }

  /** Builder for CatalogServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<CatalogServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateCatalogItemRequest, CatalogItem>
        createCatalogItemSettings;
    private final UnaryCallSettings.Builder<GetCatalogItemRequest, CatalogItem>
        getCatalogItemSettings;
    private final PagedCallSettings.Builder<
            ListCatalogItemsRequest, ListCatalogItemsResponse, ListCatalogItemsPagedResponse>
        listCatalogItemsSettings;
    private final UnaryCallSettings.Builder<UpdateCatalogItemRequest, CatalogItem>
        updateCatalogItemSettings;
    private final UnaryCallSettings.Builder<DeleteCatalogItemRequest, Empty>
        deleteCatalogItemSettings;
    private final UnaryCallSettings.Builder<ImportCatalogItemsRequest, Operation>
        importCatalogItemsSettings;
    private final OperationCallSettings.Builder<
            ImportCatalogItemsRequest, ImportCatalogItemsResponse, ImportMetadata>
        importCatalogItemsOperationSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.UNAVAILABLE, StatusCode.Code.DEADLINE_EXCEEDED)));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(600000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createCatalogItemSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getCatalogItemSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listCatalogItemsSettings = PagedCallSettings.newBuilder(LIST_CATALOG_ITEMS_PAGE_STR_FACT);
      updateCatalogItemSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteCatalogItemSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      importCatalogItemsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      importCatalogItemsOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createCatalogItemSettings,
              getCatalogItemSettings,
              listCatalogItemsSettings,
              updateCatalogItemSettings,
              deleteCatalogItemSettings,
              importCatalogItemsSettings);
      initDefaults(this);
    }

    protected Builder(CatalogServiceStubSettings settings) {
      super(settings);

      createCatalogItemSettings = settings.createCatalogItemSettings.toBuilder();
      getCatalogItemSettings = settings.getCatalogItemSettings.toBuilder();
      listCatalogItemsSettings = settings.listCatalogItemsSettings.toBuilder();
      updateCatalogItemSettings = settings.updateCatalogItemSettings.toBuilder();
      deleteCatalogItemSettings = settings.deleteCatalogItemSettings.toBuilder();
      importCatalogItemsSettings = settings.importCatalogItemsSettings.toBuilder();
      importCatalogItemsOperationSettings =
          settings.importCatalogItemsOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createCatalogItemSettings,
              getCatalogItemSettings,
              listCatalogItemsSettings,
              updateCatalogItemSettings,
              deleteCatalogItemSettings,
              importCatalogItemsSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .createCatalogItemSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getCatalogItemSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listCatalogItemsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateCatalogItemSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteCatalogItemSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .importCatalogItemsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .importCatalogItemsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ImportCatalogItemsRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  ImportCatalogItemsResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(ImportMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(5000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      return builder;
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'.
    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) throws Exception {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
    }

    /** Returns the builder for the settings used for calls to createCatalogItem. */
    public UnaryCallSettings.Builder<CreateCatalogItemRequest, CatalogItem>
        createCatalogItemSettings() {
      return createCatalogItemSettings;
    }

    /** Returns the builder for the settings used for calls to getCatalogItem. */
    public UnaryCallSettings.Builder<GetCatalogItemRequest, CatalogItem> getCatalogItemSettings() {
      return getCatalogItemSettings;
    }

    /** Returns the builder for the settings used for calls to listCatalogItems. */
    public PagedCallSettings.Builder<
            ListCatalogItemsRequest, ListCatalogItemsResponse, ListCatalogItemsPagedResponse>
        listCatalogItemsSettings() {
      return listCatalogItemsSettings;
    }

    /** Returns the builder for the settings used for calls to updateCatalogItem. */
    public UnaryCallSettings.Builder<UpdateCatalogItemRequest, CatalogItem>
        updateCatalogItemSettings() {
      return updateCatalogItemSettings;
    }

    /** Returns the builder for the settings used for calls to deleteCatalogItem. */
    public UnaryCallSettings.Builder<DeleteCatalogItemRequest, Empty> deleteCatalogItemSettings() {
      return deleteCatalogItemSettings;
    }

    /** Returns the builder for the settings used for calls to importCatalogItems. */
    public UnaryCallSettings.Builder<ImportCatalogItemsRequest, Operation>
        importCatalogItemsSettings() {
      return importCatalogItemsSettings;
    }

    /** Returns the builder for the settings used for calls to importCatalogItems. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            ImportCatalogItemsRequest, ImportCatalogItemsResponse, ImportMetadata>
        importCatalogItemsOperationSettings() {
      return importCatalogItemsOperationSettings;
    }

    @Override
    public CatalogServiceStubSettings build() throws IOException {
      return new CatalogServiceStubSettings(this);
    }
  }
}
