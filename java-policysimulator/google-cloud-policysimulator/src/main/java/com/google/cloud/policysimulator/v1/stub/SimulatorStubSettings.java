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

package com.google.cloud.policysimulator.v1.stub;

import static com.google.cloud.policysimulator.v1.SimulatorClient.ListReplayResultsPagedResponse;

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
import com.google.cloud.policysimulator.v1.CreateReplayRequest;
import com.google.cloud.policysimulator.v1.GetReplayRequest;
import com.google.cloud.policysimulator.v1.ListReplayResultsRequest;
import com.google.cloud.policysimulator.v1.ListReplayResultsResponse;
import com.google.cloud.policysimulator.v1.Replay;
import com.google.cloud.policysimulator.v1.ReplayOperationMetadata;
import com.google.cloud.policysimulator.v1.ReplayResult;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link SimulatorStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (policysimulator.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getReplay to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SimulatorStubSettings.Builder simulatorSettingsBuilder = SimulatorStubSettings.newBuilder();
 * simulatorSettingsBuilder
 *     .getReplaySettings()
 *     .setRetrySettings(
 *         simulatorSettingsBuilder
 *             .getReplaySettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * SimulatorStubSettings simulatorSettings = simulatorSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class SimulatorStubSettings extends StubSettings<SimulatorStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<GetReplayRequest, Replay> getReplaySettings;
  private final UnaryCallSettings<CreateReplayRequest, Operation> createReplaySettings;
  private final OperationCallSettings<CreateReplayRequest, Replay, ReplayOperationMetadata>
      createReplayOperationSettings;
  private final PagedCallSettings<
          ListReplayResultsRequest, ListReplayResultsResponse, ListReplayResultsPagedResponse>
      listReplayResultsSettings;

  private static final PagedListDescriptor<
          ListReplayResultsRequest, ListReplayResultsResponse, ReplayResult>
      LIST_REPLAY_RESULTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListReplayResultsRequest, ListReplayResultsResponse, ReplayResult>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListReplayResultsRequest injectToken(
                ListReplayResultsRequest payload, String token) {
              return ListReplayResultsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListReplayResultsRequest injectPageSize(
                ListReplayResultsRequest payload, int pageSize) {
              return ListReplayResultsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListReplayResultsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListReplayResultsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ReplayResult> extractResources(ListReplayResultsResponse payload) {
              return payload.getReplayResultsList() == null
                  ? ImmutableList.<ReplayResult>of()
                  : payload.getReplayResultsList();
            }
          };

  private static final PagedListResponseFactory<
          ListReplayResultsRequest, ListReplayResultsResponse, ListReplayResultsPagedResponse>
      LIST_REPLAY_RESULTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListReplayResultsRequest,
              ListReplayResultsResponse,
              ListReplayResultsPagedResponse>() {
            @Override
            public ApiFuture<ListReplayResultsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListReplayResultsRequest, ListReplayResultsResponse> callable,
                ListReplayResultsRequest request,
                ApiCallContext context,
                ApiFuture<ListReplayResultsResponse> futureResponse) {
              PageContext<ListReplayResultsRequest, ListReplayResultsResponse, ReplayResult>
                  pageContext =
                      PageContext.create(
                          callable, LIST_REPLAY_RESULTS_PAGE_STR_DESC, request, context);
              return ListReplayResultsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getReplay. */
  public UnaryCallSettings<GetReplayRequest, Replay> getReplaySettings() {
    return getReplaySettings;
  }

  /** Returns the object with the settings used for calls to createReplay. */
  public UnaryCallSettings<CreateReplayRequest, Operation> createReplaySettings() {
    return createReplaySettings;
  }

  /** Returns the object with the settings used for calls to createReplay. */
  public OperationCallSettings<CreateReplayRequest, Replay, ReplayOperationMetadata>
      createReplayOperationSettings() {
    return createReplayOperationSettings;
  }

  /** Returns the object with the settings used for calls to listReplayResults. */
  public PagedCallSettings<
          ListReplayResultsRequest, ListReplayResultsResponse, ListReplayResultsPagedResponse>
      listReplayResultsSettings() {
    return listReplayResultsSettings;
  }

  public SimulatorStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcSimulatorStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonSimulatorStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "policysimulator";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "policysimulator.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "policysimulator.mtls.googleapis.com:443";
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
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(SimulatorStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(SimulatorStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return SimulatorStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected SimulatorStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getReplaySettings = settingsBuilder.getReplaySettings().build();
    createReplaySettings = settingsBuilder.createReplaySettings().build();
    createReplayOperationSettings = settingsBuilder.createReplayOperationSettings().build();
    listReplayResultsSettings = settingsBuilder.listReplayResultsSettings().build();
  }

  /** Builder for SimulatorStubSettings. */
  public static class Builder extends StubSettings.Builder<SimulatorStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetReplayRequest, Replay> getReplaySettings;
    private final UnaryCallSettings.Builder<CreateReplayRequest, Operation> createReplaySettings;
    private final OperationCallSettings.Builder<
            CreateReplayRequest, Replay, ReplayOperationMetadata>
        createReplayOperationSettings;
    private final PagedCallSettings.Builder<
            ListReplayResultsRequest, ListReplayResultsResponse, ListReplayResultsPagedResponse>
        listReplayResultsSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
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

      getReplaySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createReplaySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createReplayOperationSettings = OperationCallSettings.newBuilder();
      listReplayResultsSettings = PagedCallSettings.newBuilder(LIST_REPLAY_RESULTS_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getReplaySettings, createReplaySettings, listReplayResultsSettings);
      initDefaults(this);
    }

    protected Builder(SimulatorStubSettings settings) {
      super(settings);

      getReplaySettings = settings.getReplaySettings.toBuilder();
      createReplaySettings = settings.createReplaySettings.toBuilder();
      createReplayOperationSettings = settings.createReplayOperationSettings.toBuilder();
      listReplayResultsSettings = settings.listReplayResultsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getReplaySettings, createReplaySettings, listReplayResultsSettings);
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
          .getReplaySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createReplaySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listReplayResultsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createReplayOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateReplayRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Replay.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(ReplayOperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(1000L))
                      .setRetryDelayMultiplier(2.0)
                      .setMaxRetryDelay(Duration.ofMillis(10000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(18000000L))
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

    /** Returns the builder for the settings used for calls to getReplay. */
    public UnaryCallSettings.Builder<GetReplayRequest, Replay> getReplaySettings() {
      return getReplaySettings;
    }

    /** Returns the builder for the settings used for calls to createReplay. */
    public UnaryCallSettings.Builder<CreateReplayRequest, Operation> createReplaySettings() {
      return createReplaySettings;
    }

    /** Returns the builder for the settings used for calls to createReplay. */
    public OperationCallSettings.Builder<CreateReplayRequest, Replay, ReplayOperationMetadata>
        createReplayOperationSettings() {
      return createReplayOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listReplayResults. */
    public PagedCallSettings.Builder<
            ListReplayResultsRequest, ListReplayResultsResponse, ListReplayResultsPagedResponse>
        listReplayResultsSettings() {
      return listReplayResultsSettings;
    }

    @Override
    public SimulatorStubSettings build() throws IOException {
      return new SimulatorStubSettings(this);
    }
  }
}
