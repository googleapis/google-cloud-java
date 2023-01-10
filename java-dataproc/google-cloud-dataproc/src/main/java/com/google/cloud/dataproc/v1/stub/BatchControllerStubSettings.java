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

package com.google.cloud.dataproc.v1.stub;

import static com.google.cloud.dataproc.v1.BatchControllerClient.ListBatchesPagedResponse;

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
import com.google.cloud.dataproc.v1.Batch;
import com.google.cloud.dataproc.v1.BatchOperationMetadata;
import com.google.cloud.dataproc.v1.CreateBatchRequest;
import com.google.cloud.dataproc.v1.DeleteBatchRequest;
import com.google.cloud.dataproc.v1.GetBatchRequest;
import com.google.cloud.dataproc.v1.ListBatchesRequest;
import com.google.cloud.dataproc.v1.ListBatchesResponse;
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
 * Settings class to configure an instance of {@link BatchControllerStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (dataproc.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getBatch to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * BatchControllerStubSettings.Builder batchControllerSettingsBuilder =
 *     BatchControllerStubSettings.newBuilder();
 * batchControllerSettingsBuilder
 *     .getBatchSettings()
 *     .setRetrySettings(
 *         batchControllerSettingsBuilder
 *             .getBatchSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * BatchControllerStubSettings batchControllerSettings = batchControllerSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class BatchControllerStubSettings extends StubSettings<BatchControllerStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateBatchRequest, Operation> createBatchSettings;
  private final OperationCallSettings<CreateBatchRequest, Batch, BatchOperationMetadata>
      createBatchOperationSettings;
  private final UnaryCallSettings<GetBatchRequest, Batch> getBatchSettings;
  private final PagedCallSettings<ListBatchesRequest, ListBatchesResponse, ListBatchesPagedResponse>
      listBatchesSettings;
  private final UnaryCallSettings<DeleteBatchRequest, Empty> deleteBatchSettings;

  private static final PagedListDescriptor<ListBatchesRequest, ListBatchesResponse, Batch>
      LIST_BATCHES_PAGE_STR_DESC =
          new PagedListDescriptor<ListBatchesRequest, ListBatchesResponse, Batch>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListBatchesRequest injectToken(ListBatchesRequest payload, String token) {
              return ListBatchesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListBatchesRequest injectPageSize(ListBatchesRequest payload, int pageSize) {
              return ListBatchesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListBatchesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListBatchesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Batch> extractResources(ListBatchesResponse payload) {
              return payload.getBatchesList() == null
                  ? ImmutableList.<Batch>of()
                  : payload.getBatchesList();
            }
          };

  private static final PagedListResponseFactory<
          ListBatchesRequest, ListBatchesResponse, ListBatchesPagedResponse>
      LIST_BATCHES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListBatchesRequest, ListBatchesResponse, ListBatchesPagedResponse>() {
            @Override
            public ApiFuture<ListBatchesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListBatchesRequest, ListBatchesResponse> callable,
                ListBatchesRequest request,
                ApiCallContext context,
                ApiFuture<ListBatchesResponse> futureResponse) {
              PageContext<ListBatchesRequest, ListBatchesResponse, Batch> pageContext =
                  PageContext.create(callable, LIST_BATCHES_PAGE_STR_DESC, request, context);
              return ListBatchesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createBatch. */
  public UnaryCallSettings<CreateBatchRequest, Operation> createBatchSettings() {
    return createBatchSettings;
  }

  /** Returns the object with the settings used for calls to createBatch. */
  public OperationCallSettings<CreateBatchRequest, Batch, BatchOperationMetadata>
      createBatchOperationSettings() {
    return createBatchOperationSettings;
  }

  /** Returns the object with the settings used for calls to getBatch. */
  public UnaryCallSettings<GetBatchRequest, Batch> getBatchSettings() {
    return getBatchSettings;
  }

  /** Returns the object with the settings used for calls to listBatches. */
  public PagedCallSettings<ListBatchesRequest, ListBatchesResponse, ListBatchesPagedResponse>
      listBatchesSettings() {
    return listBatchesSettings;
  }

  /** Returns the object with the settings used for calls to deleteBatch. */
  public UnaryCallSettings<DeleteBatchRequest, Empty> deleteBatchSettings() {
    return deleteBatchSettings;
  }

  public BatchControllerStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcBatchControllerStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonBatchControllerStub.create(this);
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
    return "dataproc.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "dataproc.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(BatchControllerStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(BatchControllerStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return BatchControllerStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected BatchControllerStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createBatchSettings = settingsBuilder.createBatchSettings().build();
    createBatchOperationSettings = settingsBuilder.createBatchOperationSettings().build();
    getBatchSettings = settingsBuilder.getBatchSettings().build();
    listBatchesSettings = settingsBuilder.listBatchesSettings().build();
    deleteBatchSettings = settingsBuilder.deleteBatchSettings().build();
  }

  /** Builder for BatchControllerStubSettings. */
  public static class Builder extends StubSettings.Builder<BatchControllerStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateBatchRequest, Operation> createBatchSettings;
    private final OperationCallSettings.Builder<CreateBatchRequest, Batch, BatchOperationMetadata>
        createBatchOperationSettings;
    private final UnaryCallSettings.Builder<GetBatchRequest, Batch> getBatchSettings;
    private final PagedCallSettings.Builder<
            ListBatchesRequest, ListBatchesResponse, ListBatchesPagedResponse>
        listBatchesSettings;
    private final UnaryCallSettings.Builder<DeleteBatchRequest, Empty> deleteBatchSettings;
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

      createBatchSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createBatchOperationSettings = OperationCallSettings.newBuilder();
      getBatchSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listBatchesSettings = PagedCallSettings.newBuilder(LIST_BATCHES_PAGE_STR_FACT);
      deleteBatchSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createBatchSettings, getBatchSettings, listBatchesSettings, deleteBatchSettings);
      initDefaults(this);
    }

    protected Builder(BatchControllerStubSettings settings) {
      super(settings);

      createBatchSettings = settings.createBatchSettings.toBuilder();
      createBatchOperationSettings = settings.createBatchOperationSettings.toBuilder();
      getBatchSettings = settings.getBatchSettings.toBuilder();
      listBatchesSettings = settings.listBatchesSettings.toBuilder();
      deleteBatchSettings = settings.deleteBatchSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createBatchSettings, getBatchSettings, listBatchesSettings, deleteBatchSettings);
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
          .createBatchSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getBatchSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listBatchesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteBatchSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createBatchOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<CreateBatchRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Batch.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(BatchOperationMetadata.class))
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

    /** Returns the builder for the settings used for calls to createBatch. */
    public UnaryCallSettings.Builder<CreateBatchRequest, Operation> createBatchSettings() {
      return createBatchSettings;
    }

    /** Returns the builder for the settings used for calls to createBatch. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateBatchRequest, Batch, BatchOperationMetadata>
        createBatchOperationSettings() {
      return createBatchOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getBatch. */
    public UnaryCallSettings.Builder<GetBatchRequest, Batch> getBatchSettings() {
      return getBatchSettings;
    }

    /** Returns the builder for the settings used for calls to listBatches. */
    public PagedCallSettings.Builder<
            ListBatchesRequest, ListBatchesResponse, ListBatchesPagedResponse>
        listBatchesSettings() {
      return listBatchesSettings;
    }

    /** Returns the builder for the settings used for calls to deleteBatch. */
    public UnaryCallSettings.Builder<DeleteBatchRequest, Empty> deleteBatchSettings() {
      return deleteBatchSettings;
    }

    @Override
    public BatchControllerStubSettings build() throws IOException {
      return new BatchControllerStubSettings(this);
    }
  }
}
