/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.discoveryengine.v1.stub;

import static com.google.cloud.discoveryengine.v1.DataStoreServiceClient.ListDataStoresPagedResponse;

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
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
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
import com.google.cloud.discoveryengine.v1.CreateDataStoreMetadata;
import com.google.cloud.discoveryengine.v1.CreateDataStoreRequest;
import com.google.cloud.discoveryengine.v1.DataStore;
import com.google.cloud.discoveryengine.v1.DeleteDataStoreMetadata;
import com.google.cloud.discoveryengine.v1.DeleteDataStoreRequest;
import com.google.cloud.discoveryengine.v1.GetDataStoreRequest;
import com.google.cloud.discoveryengine.v1.ListDataStoresRequest;
import com.google.cloud.discoveryengine.v1.ListDataStoresResponse;
import com.google.cloud.discoveryengine.v1.UpdateDataStoreRequest;
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
 * Settings class to configure an instance of {@link DataStoreServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (discoveryengine.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getDataStore to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DataStoreServiceStubSettings.Builder dataStoreServiceSettingsBuilder =
 *     DataStoreServiceStubSettings.newBuilder();
 * dataStoreServiceSettingsBuilder
 *     .getDataStoreSettings()
 *     .setRetrySettings(
 *         dataStoreServiceSettingsBuilder
 *             .getDataStoreSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * DataStoreServiceStubSettings dataStoreServiceSettings = dataStoreServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class DataStoreServiceStubSettings extends StubSettings<DataStoreServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateDataStoreRequest, Operation> createDataStoreSettings;
  private final OperationCallSettings<CreateDataStoreRequest, DataStore, CreateDataStoreMetadata>
      createDataStoreOperationSettings;
  private final UnaryCallSettings<GetDataStoreRequest, DataStore> getDataStoreSettings;
  private final PagedCallSettings<
          ListDataStoresRequest, ListDataStoresResponse, ListDataStoresPagedResponse>
      listDataStoresSettings;
  private final UnaryCallSettings<DeleteDataStoreRequest, Operation> deleteDataStoreSettings;
  private final OperationCallSettings<DeleteDataStoreRequest, Empty, DeleteDataStoreMetadata>
      deleteDataStoreOperationSettings;
  private final UnaryCallSettings<UpdateDataStoreRequest, DataStore> updateDataStoreSettings;

  private static final PagedListDescriptor<ListDataStoresRequest, ListDataStoresResponse, DataStore>
      LIST_DATA_STORES_PAGE_STR_DESC =
          new PagedListDescriptor<ListDataStoresRequest, ListDataStoresResponse, DataStore>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDataStoresRequest injectToken(ListDataStoresRequest payload, String token) {
              return ListDataStoresRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDataStoresRequest injectPageSize(
                ListDataStoresRequest payload, int pageSize) {
              return ListDataStoresRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListDataStoresRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDataStoresResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DataStore> extractResources(ListDataStoresResponse payload) {
              return payload.getDataStoresList() == null
                  ? ImmutableList.<DataStore>of()
                  : payload.getDataStoresList();
            }
          };

  private static final PagedListResponseFactory<
          ListDataStoresRequest, ListDataStoresResponse, ListDataStoresPagedResponse>
      LIST_DATA_STORES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDataStoresRequest, ListDataStoresResponse, ListDataStoresPagedResponse>() {
            @Override
            public ApiFuture<ListDataStoresPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDataStoresRequest, ListDataStoresResponse> callable,
                ListDataStoresRequest request,
                ApiCallContext context,
                ApiFuture<ListDataStoresResponse> futureResponse) {
              PageContext<ListDataStoresRequest, ListDataStoresResponse, DataStore> pageContext =
                  PageContext.create(callable, LIST_DATA_STORES_PAGE_STR_DESC, request, context);
              return ListDataStoresPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createDataStore. */
  public UnaryCallSettings<CreateDataStoreRequest, Operation> createDataStoreSettings() {
    return createDataStoreSettings;
  }

  /** Returns the object with the settings used for calls to createDataStore. */
  public OperationCallSettings<CreateDataStoreRequest, DataStore, CreateDataStoreMetadata>
      createDataStoreOperationSettings() {
    return createDataStoreOperationSettings;
  }

  /** Returns the object with the settings used for calls to getDataStore. */
  public UnaryCallSettings<GetDataStoreRequest, DataStore> getDataStoreSettings() {
    return getDataStoreSettings;
  }

  /** Returns the object with the settings used for calls to listDataStores. */
  public PagedCallSettings<
          ListDataStoresRequest, ListDataStoresResponse, ListDataStoresPagedResponse>
      listDataStoresSettings() {
    return listDataStoresSettings;
  }

  /** Returns the object with the settings used for calls to deleteDataStore. */
  public UnaryCallSettings<DeleteDataStoreRequest, Operation> deleteDataStoreSettings() {
    return deleteDataStoreSettings;
  }

  /** Returns the object with the settings used for calls to deleteDataStore. */
  public OperationCallSettings<DeleteDataStoreRequest, Empty, DeleteDataStoreMetadata>
      deleteDataStoreOperationSettings() {
    return deleteDataStoreOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateDataStore. */
  public UnaryCallSettings<UpdateDataStoreRequest, DataStore> updateDataStoreSettings() {
    return updateDataStoreSettings;
  }

  public DataStoreServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcDataStoreServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonDataStoreServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "discoveryengine";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "discoveryengine.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "discoveryengine.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(DataStoreServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(DataStoreServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DataStoreServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected DataStoreServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createDataStoreSettings = settingsBuilder.createDataStoreSettings().build();
    createDataStoreOperationSettings = settingsBuilder.createDataStoreOperationSettings().build();
    getDataStoreSettings = settingsBuilder.getDataStoreSettings().build();
    listDataStoresSettings = settingsBuilder.listDataStoresSettings().build();
    deleteDataStoreSettings = settingsBuilder.deleteDataStoreSettings().build();
    deleteDataStoreOperationSettings = settingsBuilder.deleteDataStoreOperationSettings().build();
    updateDataStoreSettings = settingsBuilder.updateDataStoreSettings().build();
  }

  /** Builder for DataStoreServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<DataStoreServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateDataStoreRequest, Operation>
        createDataStoreSettings;
    private final OperationCallSettings.Builder<
            CreateDataStoreRequest, DataStore, CreateDataStoreMetadata>
        createDataStoreOperationSettings;
    private final UnaryCallSettings.Builder<GetDataStoreRequest, DataStore> getDataStoreSettings;
    private final PagedCallSettings.Builder<
            ListDataStoresRequest, ListDataStoresResponse, ListDataStoresPagedResponse>
        listDataStoresSettings;
    private final UnaryCallSettings.Builder<DeleteDataStoreRequest, Operation>
        deleteDataStoreSettings;
    private final OperationCallSettings.Builder<
            DeleteDataStoreRequest, Empty, DeleteDataStoreMetadata>
        deleteDataStoreOperationSettings;
    private final UnaryCallSettings.Builder<UpdateDataStoreRequest, DataStore>
        updateDataStoreSettings;
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

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createDataStoreSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createDataStoreOperationSettings = OperationCallSettings.newBuilder();
      getDataStoreSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listDataStoresSettings = PagedCallSettings.newBuilder(LIST_DATA_STORES_PAGE_STR_FACT);
      deleteDataStoreSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteDataStoreOperationSettings = OperationCallSettings.newBuilder();
      updateDataStoreSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createDataStoreSettings,
              getDataStoreSettings,
              listDataStoresSettings,
              deleteDataStoreSettings,
              updateDataStoreSettings);
      initDefaults(this);
    }

    protected Builder(DataStoreServiceStubSettings settings) {
      super(settings);

      createDataStoreSettings = settings.createDataStoreSettings.toBuilder();
      createDataStoreOperationSettings = settings.createDataStoreOperationSettings.toBuilder();
      getDataStoreSettings = settings.getDataStoreSettings.toBuilder();
      listDataStoresSettings = settings.listDataStoresSettings.toBuilder();
      deleteDataStoreSettings = settings.deleteDataStoreSettings.toBuilder();
      deleteDataStoreOperationSettings = settings.deleteDataStoreOperationSettings.toBuilder();
      updateDataStoreSettings = settings.updateDataStoreSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createDataStoreSettings,
              getDataStoreSettings,
              listDataStoresSettings,
              deleteDataStoreSettings,
              updateDataStoreSettings);
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
          .createDataStoreSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getDataStoreSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listDataStoresSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteDataStoreSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateDataStoreSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createDataStoreOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateDataStoreRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(DataStore.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(CreateDataStoreMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteDataStoreOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteDataStoreRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(DeleteDataStoreMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

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

    /** Returns the builder for the settings used for calls to createDataStore. */
    public UnaryCallSettings.Builder<CreateDataStoreRequest, Operation> createDataStoreSettings() {
      return createDataStoreSettings;
    }

    /** Returns the builder for the settings used for calls to createDataStore. */
    public OperationCallSettings.Builder<CreateDataStoreRequest, DataStore, CreateDataStoreMetadata>
        createDataStoreOperationSettings() {
      return createDataStoreOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getDataStore. */
    public UnaryCallSettings.Builder<GetDataStoreRequest, DataStore> getDataStoreSettings() {
      return getDataStoreSettings;
    }

    /** Returns the builder for the settings used for calls to listDataStores. */
    public PagedCallSettings.Builder<
            ListDataStoresRequest, ListDataStoresResponse, ListDataStoresPagedResponse>
        listDataStoresSettings() {
      return listDataStoresSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDataStore. */
    public UnaryCallSettings.Builder<DeleteDataStoreRequest, Operation> deleteDataStoreSettings() {
      return deleteDataStoreSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDataStore. */
    public OperationCallSettings.Builder<DeleteDataStoreRequest, Empty, DeleteDataStoreMetadata>
        deleteDataStoreOperationSettings() {
      return deleteDataStoreOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateDataStore. */
    public UnaryCallSettings.Builder<UpdateDataStoreRequest, DataStore> updateDataStoreSettings() {
      return updateDataStoreSettings;
    }

    @Override
    public DataStoreServiceStubSettings build() throws IOException {
      return new DataStoreServiceStubSettings(this);
    }
  }
}
