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

package com.google.cloud.metastore.v1.stub;

import static com.google.cloud.metastore.v1.DataprocMetastoreFederationClient.ListFederationsPagedResponse;

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
import com.google.cloud.metastore.v1.CreateFederationRequest;
import com.google.cloud.metastore.v1.DeleteFederationRequest;
import com.google.cloud.metastore.v1.Federation;
import com.google.cloud.metastore.v1.GetFederationRequest;
import com.google.cloud.metastore.v1.ListFederationsRequest;
import com.google.cloud.metastore.v1.ListFederationsResponse;
import com.google.cloud.metastore.v1.OperationMetadata;
import com.google.cloud.metastore.v1.UpdateFederationRequest;
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
 * Settings class to configure an instance of {@link DataprocMetastoreFederationStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (metastore.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getFederation to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DataprocMetastoreFederationStubSettings.Builder dataprocMetastoreFederationSettingsBuilder =
 *     DataprocMetastoreFederationStubSettings.newBuilder();
 * dataprocMetastoreFederationSettingsBuilder
 *     .getFederationSettings()
 *     .setRetrySettings(
 *         dataprocMetastoreFederationSettingsBuilder
 *             .getFederationSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * DataprocMetastoreFederationStubSettings dataprocMetastoreFederationSettings =
 *     dataprocMetastoreFederationSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class DataprocMetastoreFederationStubSettings
    extends StubSettings<DataprocMetastoreFederationStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListFederationsRequest, ListFederationsResponse, ListFederationsPagedResponse>
      listFederationsSettings;
  private final UnaryCallSettings<GetFederationRequest, Federation> getFederationSettings;
  private final UnaryCallSettings<CreateFederationRequest, Operation> createFederationSettings;
  private final OperationCallSettings<CreateFederationRequest, Federation, OperationMetadata>
      createFederationOperationSettings;
  private final UnaryCallSettings<UpdateFederationRequest, Operation> updateFederationSettings;
  private final OperationCallSettings<UpdateFederationRequest, Federation, OperationMetadata>
      updateFederationOperationSettings;
  private final UnaryCallSettings<DeleteFederationRequest, Operation> deleteFederationSettings;
  private final OperationCallSettings<DeleteFederationRequest, Empty, OperationMetadata>
      deleteFederationOperationSettings;

  private static final PagedListDescriptor<
          ListFederationsRequest, ListFederationsResponse, Federation>
      LIST_FEDERATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListFederationsRequest, ListFederationsResponse, Federation>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListFederationsRequest injectToken(
                ListFederationsRequest payload, String token) {
              return ListFederationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListFederationsRequest injectPageSize(
                ListFederationsRequest payload, int pageSize) {
              return ListFederationsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListFederationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListFederationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Federation> extractResources(ListFederationsResponse payload) {
              return payload.getFederationsList() == null
                  ? ImmutableList.<Federation>of()
                  : payload.getFederationsList();
            }
          };

  private static final PagedListResponseFactory<
          ListFederationsRequest, ListFederationsResponse, ListFederationsPagedResponse>
      LIST_FEDERATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListFederationsRequest, ListFederationsResponse, ListFederationsPagedResponse>() {
            @Override
            public ApiFuture<ListFederationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListFederationsRequest, ListFederationsResponse> callable,
                ListFederationsRequest request,
                ApiCallContext context,
                ApiFuture<ListFederationsResponse> futureResponse) {
              PageContext<ListFederationsRequest, ListFederationsResponse, Federation> pageContext =
                  PageContext.create(callable, LIST_FEDERATIONS_PAGE_STR_DESC, request, context);
              return ListFederationsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listFederations. */
  public PagedCallSettings<
          ListFederationsRequest, ListFederationsResponse, ListFederationsPagedResponse>
      listFederationsSettings() {
    return listFederationsSettings;
  }

  /** Returns the object with the settings used for calls to getFederation. */
  public UnaryCallSettings<GetFederationRequest, Federation> getFederationSettings() {
    return getFederationSettings;
  }

  /** Returns the object with the settings used for calls to createFederation. */
  public UnaryCallSettings<CreateFederationRequest, Operation> createFederationSettings() {
    return createFederationSettings;
  }

  /** Returns the object with the settings used for calls to createFederation. */
  public OperationCallSettings<CreateFederationRequest, Federation, OperationMetadata>
      createFederationOperationSettings() {
    return createFederationOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateFederation. */
  public UnaryCallSettings<UpdateFederationRequest, Operation> updateFederationSettings() {
    return updateFederationSettings;
  }

  /** Returns the object with the settings used for calls to updateFederation. */
  public OperationCallSettings<UpdateFederationRequest, Federation, OperationMetadata>
      updateFederationOperationSettings() {
    return updateFederationOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteFederation. */
  public UnaryCallSettings<DeleteFederationRequest, Operation> deleteFederationSettings() {
    return deleteFederationSettings;
  }

  /** Returns the object with the settings used for calls to deleteFederation. */
  public OperationCallSettings<DeleteFederationRequest, Empty, OperationMetadata>
      deleteFederationOperationSettings() {
    return deleteFederationOperationSettings;
  }

  public DataprocMetastoreFederationStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcDataprocMetastoreFederationStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonDataprocMetastoreFederationStub.create(this);
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
    return "metastore.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "metastore.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(DataprocMetastoreFederationStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(DataprocMetastoreFederationStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DataprocMetastoreFederationStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected DataprocMetastoreFederationStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listFederationsSettings = settingsBuilder.listFederationsSettings().build();
    getFederationSettings = settingsBuilder.getFederationSettings().build();
    createFederationSettings = settingsBuilder.createFederationSettings().build();
    createFederationOperationSettings = settingsBuilder.createFederationOperationSettings().build();
    updateFederationSettings = settingsBuilder.updateFederationSettings().build();
    updateFederationOperationSettings = settingsBuilder.updateFederationOperationSettings().build();
    deleteFederationSettings = settingsBuilder.deleteFederationSettings().build();
    deleteFederationOperationSettings = settingsBuilder.deleteFederationOperationSettings().build();
  }

  /** Builder for DataprocMetastoreFederationStubSettings. */
  public static class Builder
      extends StubSettings.Builder<DataprocMetastoreFederationStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListFederationsRequest, ListFederationsResponse, ListFederationsPagedResponse>
        listFederationsSettings;
    private final UnaryCallSettings.Builder<GetFederationRequest, Federation> getFederationSettings;
    private final UnaryCallSettings.Builder<CreateFederationRequest, Operation>
        createFederationSettings;
    private final OperationCallSettings.Builder<
            CreateFederationRequest, Federation, OperationMetadata>
        createFederationOperationSettings;
    private final UnaryCallSettings.Builder<UpdateFederationRequest, Operation>
        updateFederationSettings;
    private final OperationCallSettings.Builder<
            UpdateFederationRequest, Federation, OperationMetadata>
        updateFederationOperationSettings;
    private final UnaryCallSettings.Builder<DeleteFederationRequest, Operation>
        deleteFederationSettings;
    private final OperationCallSettings.Builder<DeleteFederationRequest, Empty, OperationMetadata>
        deleteFederationOperationSettings;
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

      listFederationsSettings = PagedCallSettings.newBuilder(LIST_FEDERATIONS_PAGE_STR_FACT);
      getFederationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createFederationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createFederationOperationSettings = OperationCallSettings.newBuilder();
      updateFederationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateFederationOperationSettings = OperationCallSettings.newBuilder();
      deleteFederationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteFederationOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listFederationsSettings,
              getFederationSettings,
              createFederationSettings,
              updateFederationSettings,
              deleteFederationSettings);
      initDefaults(this);
    }

    protected Builder(DataprocMetastoreFederationStubSettings settings) {
      super(settings);

      listFederationsSettings = settings.listFederationsSettings.toBuilder();
      getFederationSettings = settings.getFederationSettings.toBuilder();
      createFederationSettings = settings.createFederationSettings.toBuilder();
      createFederationOperationSettings = settings.createFederationOperationSettings.toBuilder();
      updateFederationSettings = settings.updateFederationSettings.toBuilder();
      updateFederationOperationSettings = settings.updateFederationOperationSettings.toBuilder();
      deleteFederationSettings = settings.deleteFederationSettings.toBuilder();
      deleteFederationOperationSettings = settings.deleteFederationOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listFederationsSettings,
              getFederationSettings,
              createFederationSettings,
              updateFederationSettings,
              deleteFederationSettings);
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
          .listFederationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getFederationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createFederationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateFederationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteFederationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createFederationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateFederationRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Federation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .updateFederationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateFederationRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Federation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .deleteFederationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteFederationRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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

    /** Returns the builder for the settings used for calls to listFederations. */
    public PagedCallSettings.Builder<
            ListFederationsRequest, ListFederationsResponse, ListFederationsPagedResponse>
        listFederationsSettings() {
      return listFederationsSettings;
    }

    /** Returns the builder for the settings used for calls to getFederation. */
    public UnaryCallSettings.Builder<GetFederationRequest, Federation> getFederationSettings() {
      return getFederationSettings;
    }

    /** Returns the builder for the settings used for calls to createFederation. */
    public UnaryCallSettings.Builder<CreateFederationRequest, Operation>
        createFederationSettings() {
      return createFederationSettings;
    }

    /** Returns the builder for the settings used for calls to createFederation. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateFederationRequest, Federation, OperationMetadata>
        createFederationOperationSettings() {
      return createFederationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateFederation. */
    public UnaryCallSettings.Builder<UpdateFederationRequest, Operation>
        updateFederationSettings() {
      return updateFederationSettings;
    }

    /** Returns the builder for the settings used for calls to updateFederation. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpdateFederationRequest, Federation, OperationMetadata>
        updateFederationOperationSettings() {
      return updateFederationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteFederation. */
    public UnaryCallSettings.Builder<DeleteFederationRequest, Operation>
        deleteFederationSettings() {
      return deleteFederationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteFederation. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteFederationRequest, Empty, OperationMetadata>
        deleteFederationOperationSettings() {
      return deleteFederationOperationSettings;
    }

    @Override
    public DataprocMetastoreFederationStubSettings build() throws IOException {
      return new DataprocMetastoreFederationStubSettings(this);
    }
  }
}
