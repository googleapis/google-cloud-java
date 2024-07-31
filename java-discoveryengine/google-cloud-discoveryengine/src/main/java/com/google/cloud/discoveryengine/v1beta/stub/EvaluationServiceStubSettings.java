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

import static com.google.cloud.discoveryengine.v1beta.EvaluationServiceClient.ListEvaluationResultsPagedResponse;
import static com.google.cloud.discoveryengine.v1beta.EvaluationServiceClient.ListEvaluationsPagedResponse;

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
import com.google.cloud.discoveryengine.v1beta.CreateEvaluationMetadata;
import com.google.cloud.discoveryengine.v1beta.CreateEvaluationRequest;
import com.google.cloud.discoveryengine.v1beta.Evaluation;
import com.google.cloud.discoveryengine.v1beta.GetEvaluationRequest;
import com.google.cloud.discoveryengine.v1beta.ListEvaluationResultsRequest;
import com.google.cloud.discoveryengine.v1beta.ListEvaluationResultsResponse;
import com.google.cloud.discoveryengine.v1beta.ListEvaluationsRequest;
import com.google.cloud.discoveryengine.v1beta.ListEvaluationsResponse;
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
 * Settings class to configure an instance of {@link EvaluationServiceStub}.
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
 * <p>For example, to set the total timeout of getEvaluation to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * EvaluationServiceStubSettings.Builder evaluationServiceSettingsBuilder =
 *     EvaluationServiceStubSettings.newBuilder();
 * evaluationServiceSettingsBuilder
 *     .getEvaluationSettings()
 *     .setRetrySettings(
 *         evaluationServiceSettingsBuilder
 *             .getEvaluationSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * EvaluationServiceStubSettings evaluationServiceSettings =
 *     evaluationServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class EvaluationServiceStubSettings extends StubSettings<EvaluationServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<GetEvaluationRequest, Evaluation> getEvaluationSettings;
  private final PagedCallSettings<
          ListEvaluationsRequest, ListEvaluationsResponse, ListEvaluationsPagedResponse>
      listEvaluationsSettings;
  private final UnaryCallSettings<CreateEvaluationRequest, Operation> createEvaluationSettings;
  private final OperationCallSettings<CreateEvaluationRequest, Evaluation, CreateEvaluationMetadata>
      createEvaluationOperationSettings;
  private final PagedCallSettings<
          ListEvaluationResultsRequest,
          ListEvaluationResultsResponse,
          ListEvaluationResultsPagedResponse>
      listEvaluationResultsSettings;

  private static final PagedListDescriptor<
          ListEvaluationsRequest, ListEvaluationsResponse, Evaluation>
      LIST_EVALUATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListEvaluationsRequest, ListEvaluationsResponse, Evaluation>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListEvaluationsRequest injectToken(
                ListEvaluationsRequest payload, String token) {
              return ListEvaluationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListEvaluationsRequest injectPageSize(
                ListEvaluationsRequest payload, int pageSize) {
              return ListEvaluationsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListEvaluationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListEvaluationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Evaluation> extractResources(ListEvaluationsResponse payload) {
              return payload.getEvaluationsList() == null
                  ? ImmutableList.<Evaluation>of()
                  : payload.getEvaluationsList();
            }
          };

  private static final PagedListDescriptor<
          ListEvaluationResultsRequest,
          ListEvaluationResultsResponse,
          ListEvaluationResultsResponse.EvaluationResult>
      LIST_EVALUATION_RESULTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListEvaluationResultsRequest,
              ListEvaluationResultsResponse,
              ListEvaluationResultsResponse.EvaluationResult>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListEvaluationResultsRequest injectToken(
                ListEvaluationResultsRequest payload, String token) {
              return ListEvaluationResultsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListEvaluationResultsRequest injectPageSize(
                ListEvaluationResultsRequest payload, int pageSize) {
              return ListEvaluationResultsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListEvaluationResultsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListEvaluationResultsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ListEvaluationResultsResponse.EvaluationResult> extractResources(
                ListEvaluationResultsResponse payload) {
              return payload.getEvaluationResultsList() == null
                  ? ImmutableList.<ListEvaluationResultsResponse.EvaluationResult>of()
                  : payload.getEvaluationResultsList();
            }
          };

  private static final PagedListResponseFactory<
          ListEvaluationsRequest, ListEvaluationsResponse, ListEvaluationsPagedResponse>
      LIST_EVALUATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListEvaluationsRequest, ListEvaluationsResponse, ListEvaluationsPagedResponse>() {
            @Override
            public ApiFuture<ListEvaluationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListEvaluationsRequest, ListEvaluationsResponse> callable,
                ListEvaluationsRequest request,
                ApiCallContext context,
                ApiFuture<ListEvaluationsResponse> futureResponse) {
              PageContext<ListEvaluationsRequest, ListEvaluationsResponse, Evaluation> pageContext =
                  PageContext.create(callable, LIST_EVALUATIONS_PAGE_STR_DESC, request, context);
              return ListEvaluationsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListEvaluationResultsRequest,
          ListEvaluationResultsResponse,
          ListEvaluationResultsPagedResponse>
      LIST_EVALUATION_RESULTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListEvaluationResultsRequest,
              ListEvaluationResultsResponse,
              ListEvaluationResultsPagedResponse>() {
            @Override
            public ApiFuture<ListEvaluationResultsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListEvaluationResultsRequest, ListEvaluationResultsResponse> callable,
                ListEvaluationResultsRequest request,
                ApiCallContext context,
                ApiFuture<ListEvaluationResultsResponse> futureResponse) {
              PageContext<
                      ListEvaluationResultsRequest,
                      ListEvaluationResultsResponse,
                      ListEvaluationResultsResponse.EvaluationResult>
                  pageContext =
                      PageContext.create(
                          callable, LIST_EVALUATION_RESULTS_PAGE_STR_DESC, request, context);
              return ListEvaluationResultsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getEvaluation. */
  public UnaryCallSettings<GetEvaluationRequest, Evaluation> getEvaluationSettings() {
    return getEvaluationSettings;
  }

  /** Returns the object with the settings used for calls to listEvaluations. */
  public PagedCallSettings<
          ListEvaluationsRequest, ListEvaluationsResponse, ListEvaluationsPagedResponse>
      listEvaluationsSettings() {
    return listEvaluationsSettings;
  }

  /** Returns the object with the settings used for calls to createEvaluation. */
  public UnaryCallSettings<CreateEvaluationRequest, Operation> createEvaluationSettings() {
    return createEvaluationSettings;
  }

  /** Returns the object with the settings used for calls to createEvaluation. */
  public OperationCallSettings<CreateEvaluationRequest, Evaluation, CreateEvaluationMetadata>
      createEvaluationOperationSettings() {
    return createEvaluationOperationSettings;
  }

  /** Returns the object with the settings used for calls to listEvaluationResults. */
  public PagedCallSettings<
          ListEvaluationResultsRequest,
          ListEvaluationResultsResponse,
          ListEvaluationResultsPagedResponse>
      listEvaluationResultsSettings() {
    return listEvaluationResultsSettings;
  }

  public EvaluationServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcEvaluationServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonEvaluationServiceStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(EvaluationServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(EvaluationServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return EvaluationServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected EvaluationServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getEvaluationSettings = settingsBuilder.getEvaluationSettings().build();
    listEvaluationsSettings = settingsBuilder.listEvaluationsSettings().build();
    createEvaluationSettings = settingsBuilder.createEvaluationSettings().build();
    createEvaluationOperationSettings = settingsBuilder.createEvaluationOperationSettings().build();
    listEvaluationResultsSettings = settingsBuilder.listEvaluationResultsSettings().build();
  }

  /** Builder for EvaluationServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<EvaluationServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetEvaluationRequest, Evaluation> getEvaluationSettings;
    private final PagedCallSettings.Builder<
            ListEvaluationsRequest, ListEvaluationsResponse, ListEvaluationsPagedResponse>
        listEvaluationsSettings;
    private final UnaryCallSettings.Builder<CreateEvaluationRequest, Operation>
        createEvaluationSettings;
    private final OperationCallSettings.Builder<
            CreateEvaluationRequest, Evaluation, CreateEvaluationMetadata>
        createEvaluationOperationSettings;
    private final PagedCallSettings.Builder<
            ListEvaluationResultsRequest,
            ListEvaluationResultsResponse,
            ListEvaluationResultsPagedResponse>
        listEvaluationResultsSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_1_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "no_retry_3_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
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
              .setInitialRpcTimeout(Duration.ofMillis(30000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(30000L))
              .setTotalTimeout(Duration.ofMillis(30000L))
              .build();
      definitions.put("retry_policy_1_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(300000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(300000L))
              .setTotalTimeout(Duration.ofMillis(300000L))
              .build();
      definitions.put("no_retry_3_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      getEvaluationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listEvaluationsSettings = PagedCallSettings.newBuilder(LIST_EVALUATIONS_PAGE_STR_FACT);
      createEvaluationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createEvaluationOperationSettings = OperationCallSettings.newBuilder();
      listEvaluationResultsSettings =
          PagedCallSettings.newBuilder(LIST_EVALUATION_RESULTS_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getEvaluationSettings,
              listEvaluationsSettings,
              createEvaluationSettings,
              listEvaluationResultsSettings);
      initDefaults(this);
    }

    protected Builder(EvaluationServiceStubSettings settings) {
      super(settings);

      getEvaluationSettings = settings.getEvaluationSettings.toBuilder();
      listEvaluationsSettings = settings.listEvaluationsSettings.toBuilder();
      createEvaluationSettings = settings.createEvaluationSettings.toBuilder();
      createEvaluationOperationSettings = settings.createEvaluationOperationSettings.toBuilder();
      listEvaluationResultsSettings = settings.listEvaluationResultsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getEvaluationSettings,
              listEvaluationsSettings,
              createEvaluationSettings,
              listEvaluationResultsSettings);
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
          .getEvaluationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .listEvaluationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .createEvaluationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_3_params"));

      builder
          .listEvaluationResultsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .createEvaluationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateEvaluationRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_3_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_3_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Evaluation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(CreateEvaluationMetadata.class))
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

    /** Returns the builder for the settings used for calls to getEvaluation. */
    public UnaryCallSettings.Builder<GetEvaluationRequest, Evaluation> getEvaluationSettings() {
      return getEvaluationSettings;
    }

    /** Returns the builder for the settings used for calls to listEvaluations. */
    public PagedCallSettings.Builder<
            ListEvaluationsRequest, ListEvaluationsResponse, ListEvaluationsPagedResponse>
        listEvaluationsSettings() {
      return listEvaluationsSettings;
    }

    /** Returns the builder for the settings used for calls to createEvaluation. */
    public UnaryCallSettings.Builder<CreateEvaluationRequest, Operation>
        createEvaluationSettings() {
      return createEvaluationSettings;
    }

    /** Returns the builder for the settings used for calls to createEvaluation. */
    public OperationCallSettings.Builder<
            CreateEvaluationRequest, Evaluation, CreateEvaluationMetadata>
        createEvaluationOperationSettings() {
      return createEvaluationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listEvaluationResults. */
    public PagedCallSettings.Builder<
            ListEvaluationResultsRequest,
            ListEvaluationResultsResponse,
            ListEvaluationResultsPagedResponse>
        listEvaluationResultsSettings() {
      return listEvaluationResultsSettings;
    }

    @Override
    public EvaluationServiceStubSettings build() throws IOException {
      return new EvaluationServiceStubSettings(this);
    }
  }
}
