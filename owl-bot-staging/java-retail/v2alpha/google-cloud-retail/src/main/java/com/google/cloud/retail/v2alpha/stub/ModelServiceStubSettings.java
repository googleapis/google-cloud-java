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

package com.google.cloud.retail.v2alpha.stub;

import static com.google.cloud.retail.v2alpha.ModelServiceClient.ListModelsPagedResponse;

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
import com.google.cloud.retail.v2alpha.CreateModelMetadata;
import com.google.cloud.retail.v2alpha.CreateModelRequest;
import com.google.cloud.retail.v2alpha.DeleteModelRequest;
import com.google.cloud.retail.v2alpha.ListModelsRequest;
import com.google.cloud.retail.v2alpha.ListModelsResponse;
import com.google.cloud.retail.v2alpha.Model;
import com.google.cloud.retail.v2alpha.PauseModelRequest;
import com.google.cloud.retail.v2alpha.ResumeModelRequest;
import com.google.cloud.retail.v2alpha.TuneModelMetadata;
import com.google.cloud.retail.v2alpha.TuneModelRequest;
import com.google.cloud.retail.v2alpha.TuneModelResponse;
import com.google.cloud.retail.v2alpha.UpdateModelRequest;
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
 * Settings class to configure an instance of {@link ModelServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (retail.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of pauseModel to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ModelServiceStubSettings.Builder modelServiceSettingsBuilder =
 *     ModelServiceStubSettings.newBuilder();
 * modelServiceSettingsBuilder
 *     .pauseModelSettings()
 *     .setRetrySettings(
 *         modelServiceSettingsBuilder
 *             .pauseModelSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ModelServiceStubSettings modelServiceSettings = modelServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ModelServiceStubSettings extends StubSettings<ModelServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateModelRequest, Operation> createModelSettings;
  private final OperationCallSettings<CreateModelRequest, Model, CreateModelMetadata>
      createModelOperationSettings;
  private final UnaryCallSettings<PauseModelRequest, Model> pauseModelSettings;
  private final UnaryCallSettings<ResumeModelRequest, Model> resumeModelSettings;
  private final UnaryCallSettings<DeleteModelRequest, Empty> deleteModelSettings;
  private final PagedCallSettings<ListModelsRequest, ListModelsResponse, ListModelsPagedResponse>
      listModelsSettings;
  private final UnaryCallSettings<UpdateModelRequest, Model> updateModelSettings;
  private final UnaryCallSettings<TuneModelRequest, Operation> tuneModelSettings;
  private final OperationCallSettings<TuneModelRequest, TuneModelResponse, TuneModelMetadata>
      tuneModelOperationSettings;

  private static final PagedListDescriptor<ListModelsRequest, ListModelsResponse, Model>
      LIST_MODELS_PAGE_STR_DESC =
          new PagedListDescriptor<ListModelsRequest, ListModelsResponse, Model>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListModelsRequest injectToken(ListModelsRequest payload, String token) {
              return ListModelsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListModelsRequest injectPageSize(ListModelsRequest payload, int pageSize) {
              return ListModelsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListModelsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListModelsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Model> extractResources(ListModelsResponse payload) {
              return payload.getModelsList() == null
                  ? ImmutableList.<Model>of()
                  : payload.getModelsList();
            }
          };

  private static final PagedListResponseFactory<
          ListModelsRequest, ListModelsResponse, ListModelsPagedResponse>
      LIST_MODELS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListModelsRequest, ListModelsResponse, ListModelsPagedResponse>() {
            @Override
            public ApiFuture<ListModelsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListModelsRequest, ListModelsResponse> callable,
                ListModelsRequest request,
                ApiCallContext context,
                ApiFuture<ListModelsResponse> futureResponse) {
              PageContext<ListModelsRequest, ListModelsResponse, Model> pageContext =
                  PageContext.create(callable, LIST_MODELS_PAGE_STR_DESC, request, context);
              return ListModelsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createModel. */
  public UnaryCallSettings<CreateModelRequest, Operation> createModelSettings() {
    return createModelSettings;
  }

  /** Returns the object with the settings used for calls to createModel. */
  public OperationCallSettings<CreateModelRequest, Model, CreateModelMetadata>
      createModelOperationSettings() {
    return createModelOperationSettings;
  }

  /** Returns the object with the settings used for calls to pauseModel. */
  public UnaryCallSettings<PauseModelRequest, Model> pauseModelSettings() {
    return pauseModelSettings;
  }

  /** Returns the object with the settings used for calls to resumeModel. */
  public UnaryCallSettings<ResumeModelRequest, Model> resumeModelSettings() {
    return resumeModelSettings;
  }

  /** Returns the object with the settings used for calls to deleteModel. */
  public UnaryCallSettings<DeleteModelRequest, Empty> deleteModelSettings() {
    return deleteModelSettings;
  }

  /** Returns the object with the settings used for calls to listModels. */
  public PagedCallSettings<ListModelsRequest, ListModelsResponse, ListModelsPagedResponse>
      listModelsSettings() {
    return listModelsSettings;
  }

  /** Returns the object with the settings used for calls to updateModel. */
  public UnaryCallSettings<UpdateModelRequest, Model> updateModelSettings() {
    return updateModelSettings;
  }

  /** Returns the object with the settings used for calls to tuneModel. */
  public UnaryCallSettings<TuneModelRequest, Operation> tuneModelSettings() {
    return tuneModelSettings;
  }

  /** Returns the object with the settings used for calls to tuneModel. */
  public OperationCallSettings<TuneModelRequest, TuneModelResponse, TuneModelMetadata>
      tuneModelOperationSettings() {
    return tuneModelOperationSettings;
  }

  public ModelServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcModelServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonModelServiceStub.create(this);
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
    return "retail.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "retail.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(ModelServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(ModelServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ModelServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected ModelServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createModelSettings = settingsBuilder.createModelSettings().build();
    createModelOperationSettings = settingsBuilder.createModelOperationSettings().build();
    pauseModelSettings = settingsBuilder.pauseModelSettings().build();
    resumeModelSettings = settingsBuilder.resumeModelSettings().build();
    deleteModelSettings = settingsBuilder.deleteModelSettings().build();
    listModelsSettings = settingsBuilder.listModelsSettings().build();
    updateModelSettings = settingsBuilder.updateModelSettings().build();
    tuneModelSettings = settingsBuilder.tuneModelSettings().build();
    tuneModelOperationSettings = settingsBuilder.tuneModelOperationSettings().build();
  }

  /** Builder for ModelServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<ModelServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateModelRequest, Operation> createModelSettings;
    private final OperationCallSettings.Builder<CreateModelRequest, Model, CreateModelMetadata>
        createModelOperationSettings;
    private final UnaryCallSettings.Builder<PauseModelRequest, Model> pauseModelSettings;
    private final UnaryCallSettings.Builder<ResumeModelRequest, Model> resumeModelSettings;
    private final UnaryCallSettings.Builder<DeleteModelRequest, Empty> deleteModelSettings;
    private final PagedCallSettings.Builder<
            ListModelsRequest, ListModelsResponse, ListModelsPagedResponse>
        listModelsSettings;
    private final UnaryCallSettings.Builder<UpdateModelRequest, Model> updateModelSettings;
    private final UnaryCallSettings.Builder<TuneModelRequest, Operation> tuneModelSettings;
    private final OperationCallSettings.Builder<
            TuneModelRequest, TuneModelResponse, TuneModelMetadata>
        tuneModelOperationSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_2_codes",
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
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_2_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createModelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createModelOperationSettings = OperationCallSettings.newBuilder();
      pauseModelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      resumeModelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteModelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listModelsSettings = PagedCallSettings.newBuilder(LIST_MODELS_PAGE_STR_FACT);
      updateModelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      tuneModelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      tuneModelOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createModelSettings,
              pauseModelSettings,
              resumeModelSettings,
              deleteModelSettings,
              listModelsSettings,
              updateModelSettings,
              tuneModelSettings);
      initDefaults(this);
    }

    protected Builder(ModelServiceStubSettings settings) {
      super(settings);

      createModelSettings = settings.createModelSettings.toBuilder();
      createModelOperationSettings = settings.createModelOperationSettings.toBuilder();
      pauseModelSettings = settings.pauseModelSettings.toBuilder();
      resumeModelSettings = settings.resumeModelSettings.toBuilder();
      deleteModelSettings = settings.deleteModelSettings.toBuilder();
      listModelsSettings = settings.listModelsSettings.toBuilder();
      updateModelSettings = settings.updateModelSettings.toBuilder();
      tuneModelSettings = settings.tuneModelSettings.toBuilder();
      tuneModelOperationSettings = settings.tuneModelOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createModelSettings,
              pauseModelSettings,
              resumeModelSettings,
              deleteModelSettings,
              listModelsSettings,
              updateModelSettings,
              tuneModelSettings);
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
          .createModelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_2_params"));

      builder
          .pauseModelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_2_params"));

      builder
          .resumeModelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_2_params"));

      builder
          .deleteModelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_2_params"));

      builder
          .listModelsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_2_params"));

      builder
          .updateModelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_2_params"));

      builder
          .tuneModelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_2_params"));

      builder
          .createModelOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<CreateModelRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Model.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(CreateModelMetadata.class))
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
          .tuneModelOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<TuneModelRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(TuneModelResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(TuneModelMetadata.class))
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

    /** Returns the builder for the settings used for calls to createModel. */
    public UnaryCallSettings.Builder<CreateModelRequest, Operation> createModelSettings() {
      return createModelSettings;
    }

    /** Returns the builder for the settings used for calls to createModel. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateModelRequest, Model, CreateModelMetadata>
        createModelOperationSettings() {
      return createModelOperationSettings;
    }

    /** Returns the builder for the settings used for calls to pauseModel. */
    public UnaryCallSettings.Builder<PauseModelRequest, Model> pauseModelSettings() {
      return pauseModelSettings;
    }

    /** Returns the builder for the settings used for calls to resumeModel. */
    public UnaryCallSettings.Builder<ResumeModelRequest, Model> resumeModelSettings() {
      return resumeModelSettings;
    }

    /** Returns the builder for the settings used for calls to deleteModel. */
    public UnaryCallSettings.Builder<DeleteModelRequest, Empty> deleteModelSettings() {
      return deleteModelSettings;
    }

    /** Returns the builder for the settings used for calls to listModels. */
    public PagedCallSettings.Builder<ListModelsRequest, ListModelsResponse, ListModelsPagedResponse>
        listModelsSettings() {
      return listModelsSettings;
    }

    /** Returns the builder for the settings used for calls to updateModel. */
    public UnaryCallSettings.Builder<UpdateModelRequest, Model> updateModelSettings() {
      return updateModelSettings;
    }

    /** Returns the builder for the settings used for calls to tuneModel. */
    public UnaryCallSettings.Builder<TuneModelRequest, Operation> tuneModelSettings() {
      return tuneModelSettings;
    }

    /** Returns the builder for the settings used for calls to tuneModel. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<TuneModelRequest, TuneModelResponse, TuneModelMetadata>
        tuneModelOperationSettings() {
      return tuneModelOperationSettings;
    }

    @Override
    public ModelServiceStubSettings build() throws IOException {
      return new ModelServiceStubSettings(this);
    }
  }
}
