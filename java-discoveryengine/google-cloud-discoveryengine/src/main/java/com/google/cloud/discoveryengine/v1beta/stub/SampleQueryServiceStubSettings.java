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

package com.google.cloud.discoveryengine.v1beta.stub;

import static com.google.cloud.discoveryengine.v1beta.SampleQueryServiceClient.ListSampleQueriesPagedResponse;

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
import com.google.cloud.discoveryengine.v1beta.CreateSampleQueryRequest;
import com.google.cloud.discoveryengine.v1beta.DeleteSampleQueryRequest;
import com.google.cloud.discoveryengine.v1beta.GetSampleQueryRequest;
import com.google.cloud.discoveryengine.v1beta.ImportSampleQueriesMetadata;
import com.google.cloud.discoveryengine.v1beta.ImportSampleQueriesRequest;
import com.google.cloud.discoveryengine.v1beta.ImportSampleQueriesResponse;
import com.google.cloud.discoveryengine.v1beta.ListSampleQueriesRequest;
import com.google.cloud.discoveryengine.v1beta.ListSampleQueriesResponse;
import com.google.cloud.discoveryengine.v1beta.SampleQuery;
import com.google.cloud.discoveryengine.v1beta.UpdateSampleQueryRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link SampleQueryServiceStub}.
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
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getSampleQuery:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SampleQueryServiceStubSettings.Builder sampleQueryServiceSettingsBuilder =
 *     SampleQueryServiceStubSettings.newBuilder();
 * sampleQueryServiceSettingsBuilder
 *     .getSampleQuerySettings()
 *     .setRetrySettings(
 *         sampleQueryServiceSettingsBuilder
 *             .getSampleQuerySettings()
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
 * SampleQueryServiceStubSettings sampleQueryServiceSettings =
 *     sampleQueryServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for importSampleQueries:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SampleQueryServiceStubSettings.Builder sampleQueryServiceSettingsBuilder =
 *     SampleQueryServiceStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * sampleQueryServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class SampleQueryServiceStubSettings extends StubSettings<SampleQueryServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<GetSampleQueryRequest, SampleQuery> getSampleQuerySettings;
  private final PagedCallSettings<
          ListSampleQueriesRequest, ListSampleQueriesResponse, ListSampleQueriesPagedResponse>
      listSampleQueriesSettings;
  private final UnaryCallSettings<CreateSampleQueryRequest, SampleQuery> createSampleQuerySettings;
  private final UnaryCallSettings<UpdateSampleQueryRequest, SampleQuery> updateSampleQuerySettings;
  private final UnaryCallSettings<DeleteSampleQueryRequest, Empty> deleteSampleQuerySettings;
  private final UnaryCallSettings<ImportSampleQueriesRequest, Operation>
      importSampleQueriesSettings;
  private final OperationCallSettings<
          ImportSampleQueriesRequest, ImportSampleQueriesResponse, ImportSampleQueriesMetadata>
      importSampleQueriesOperationSettings;

  private static final PagedListDescriptor<
          ListSampleQueriesRequest, ListSampleQueriesResponse, SampleQuery>
      LIST_SAMPLE_QUERIES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListSampleQueriesRequest, ListSampleQueriesResponse, SampleQuery>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListSampleQueriesRequest injectToken(
                ListSampleQueriesRequest payload, String token) {
              return ListSampleQueriesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListSampleQueriesRequest injectPageSize(
                ListSampleQueriesRequest payload, int pageSize) {
              return ListSampleQueriesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListSampleQueriesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListSampleQueriesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<SampleQuery> extractResources(ListSampleQueriesResponse payload) {
              return payload.getSampleQueriesList();
            }
          };

  private static final PagedListResponseFactory<
          ListSampleQueriesRequest, ListSampleQueriesResponse, ListSampleQueriesPagedResponse>
      LIST_SAMPLE_QUERIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListSampleQueriesRequest,
              ListSampleQueriesResponse,
              ListSampleQueriesPagedResponse>() {
            @Override
            public ApiFuture<ListSampleQueriesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListSampleQueriesRequest, ListSampleQueriesResponse> callable,
                ListSampleQueriesRequest request,
                ApiCallContext context,
                ApiFuture<ListSampleQueriesResponse> futureResponse) {
              PageContext<ListSampleQueriesRequest, ListSampleQueriesResponse, SampleQuery>
                  pageContext =
                      PageContext.create(
                          callable, LIST_SAMPLE_QUERIES_PAGE_STR_DESC, request, context);
              return ListSampleQueriesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getSampleQuery. */
  public UnaryCallSettings<GetSampleQueryRequest, SampleQuery> getSampleQuerySettings() {
    return getSampleQuerySettings;
  }

  /** Returns the object with the settings used for calls to listSampleQueries. */
  public PagedCallSettings<
          ListSampleQueriesRequest, ListSampleQueriesResponse, ListSampleQueriesPagedResponse>
      listSampleQueriesSettings() {
    return listSampleQueriesSettings;
  }

  /** Returns the object with the settings used for calls to createSampleQuery. */
  public UnaryCallSettings<CreateSampleQueryRequest, SampleQuery> createSampleQuerySettings() {
    return createSampleQuerySettings;
  }

  /** Returns the object with the settings used for calls to updateSampleQuery. */
  public UnaryCallSettings<UpdateSampleQueryRequest, SampleQuery> updateSampleQuerySettings() {
    return updateSampleQuerySettings;
  }

  /** Returns the object with the settings used for calls to deleteSampleQuery. */
  public UnaryCallSettings<DeleteSampleQueryRequest, Empty> deleteSampleQuerySettings() {
    return deleteSampleQuerySettings;
  }

  /** Returns the object with the settings used for calls to importSampleQueries. */
  public UnaryCallSettings<ImportSampleQueriesRequest, Operation> importSampleQueriesSettings() {
    return importSampleQueriesSettings;
  }

  /** Returns the object with the settings used for calls to importSampleQueries. */
  public OperationCallSettings<
          ImportSampleQueriesRequest, ImportSampleQueriesResponse, ImportSampleQueriesMetadata>
      importSampleQueriesOperationSettings() {
    return importSampleQueriesOperationSettings;
  }

  public SampleQueryServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcSampleQueryServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonSampleQueryServiceStub.create(this);
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
  @ObsoleteApi("Use getEndpoint() instead")
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
            "gapic", GaxProperties.getLibraryVersion(SampleQueryServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(SampleQueryServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return SampleQueryServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected SampleQueryServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getSampleQuerySettings = settingsBuilder.getSampleQuerySettings().build();
    listSampleQueriesSettings = settingsBuilder.listSampleQueriesSettings().build();
    createSampleQuerySettings = settingsBuilder.createSampleQuerySettings().build();
    updateSampleQuerySettings = settingsBuilder.updateSampleQuerySettings().build();
    deleteSampleQuerySettings = settingsBuilder.deleteSampleQuerySettings().build();
    importSampleQueriesSettings = settingsBuilder.importSampleQueriesSettings().build();
    importSampleQueriesOperationSettings =
        settingsBuilder.importSampleQueriesOperationSettings().build();
  }

  /** Builder for SampleQueryServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<SampleQueryServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetSampleQueryRequest, SampleQuery>
        getSampleQuerySettings;
    private final PagedCallSettings.Builder<
            ListSampleQueriesRequest, ListSampleQueriesResponse, ListSampleQueriesPagedResponse>
        listSampleQueriesSettings;
    private final UnaryCallSettings.Builder<CreateSampleQueryRequest, SampleQuery>
        createSampleQuerySettings;
    private final UnaryCallSettings.Builder<UpdateSampleQueryRequest, SampleQuery>
        updateSampleQuerySettings;
    private final UnaryCallSettings.Builder<DeleteSampleQueryRequest, Empty>
        deleteSampleQuerySettings;
    private final UnaryCallSettings.Builder<ImportSampleQueriesRequest, Operation>
        importSampleQueriesSettings;
    private final OperationCallSettings.Builder<
            ImportSampleQueriesRequest, ImportSampleQueriesResponse, ImportSampleQueriesMetadata>
        importSampleQueriesOperationSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_1_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
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
              .setMaxRetryDelayDuration(Duration.ofMillis(10000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(30000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(30000L))
              .setTotalTimeoutDuration(Duration.ofMillis(30000L))
              .build();
      definitions.put("retry_policy_1_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      getSampleQuerySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listSampleQueriesSettings = PagedCallSettings.newBuilder(LIST_SAMPLE_QUERIES_PAGE_STR_FACT);
      createSampleQuerySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateSampleQuerySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteSampleQuerySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      importSampleQueriesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      importSampleQueriesOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getSampleQuerySettings,
              listSampleQueriesSettings,
              createSampleQuerySettings,
              updateSampleQuerySettings,
              deleteSampleQuerySettings,
              importSampleQueriesSettings);
      initDefaults(this);
    }

    protected Builder(SampleQueryServiceStubSettings settings) {
      super(settings);

      getSampleQuerySettings = settings.getSampleQuerySettings.toBuilder();
      listSampleQueriesSettings = settings.listSampleQueriesSettings.toBuilder();
      createSampleQuerySettings = settings.createSampleQuerySettings.toBuilder();
      updateSampleQuerySettings = settings.updateSampleQuerySettings.toBuilder();
      deleteSampleQuerySettings = settings.deleteSampleQuerySettings.toBuilder();
      importSampleQueriesSettings = settings.importSampleQueriesSettings.toBuilder();
      importSampleQueriesOperationSettings =
          settings.importSampleQueriesOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getSampleQuerySettings,
              listSampleQueriesSettings,
              createSampleQuerySettings,
              updateSampleQuerySettings,
              deleteSampleQuerySettings,
              importSampleQueriesSettings);
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
          .getSampleQuerySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .listSampleQueriesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .createSampleQuerySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .updateSampleQuerySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .deleteSampleQuerySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .importSampleQueriesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .importSampleQueriesOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ImportSampleQueriesRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  ImportSampleQueriesResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  ImportSampleQueriesMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
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

    /** Returns the builder for the settings used for calls to getSampleQuery. */
    public UnaryCallSettings.Builder<GetSampleQueryRequest, SampleQuery> getSampleQuerySettings() {
      return getSampleQuerySettings;
    }

    /** Returns the builder for the settings used for calls to listSampleQueries. */
    public PagedCallSettings.Builder<
            ListSampleQueriesRequest, ListSampleQueriesResponse, ListSampleQueriesPagedResponse>
        listSampleQueriesSettings() {
      return listSampleQueriesSettings;
    }

    /** Returns the builder for the settings used for calls to createSampleQuery. */
    public UnaryCallSettings.Builder<CreateSampleQueryRequest, SampleQuery>
        createSampleQuerySettings() {
      return createSampleQuerySettings;
    }

    /** Returns the builder for the settings used for calls to updateSampleQuery. */
    public UnaryCallSettings.Builder<UpdateSampleQueryRequest, SampleQuery>
        updateSampleQuerySettings() {
      return updateSampleQuerySettings;
    }

    /** Returns the builder for the settings used for calls to deleteSampleQuery. */
    public UnaryCallSettings.Builder<DeleteSampleQueryRequest, Empty> deleteSampleQuerySettings() {
      return deleteSampleQuerySettings;
    }

    /** Returns the builder for the settings used for calls to importSampleQueries. */
    public UnaryCallSettings.Builder<ImportSampleQueriesRequest, Operation>
        importSampleQueriesSettings() {
      return importSampleQueriesSettings;
    }

    /** Returns the builder for the settings used for calls to importSampleQueries. */
    public OperationCallSettings.Builder<
            ImportSampleQueriesRequest, ImportSampleQueriesResponse, ImportSampleQueriesMetadata>
        importSampleQueriesOperationSettings() {
      return importSampleQueriesOperationSettings;
    }

    @Override
    public SampleQueryServiceStubSettings build() throws IOException {
      return new SampleQueryServiceStubSettings(this);
    }
  }
}
