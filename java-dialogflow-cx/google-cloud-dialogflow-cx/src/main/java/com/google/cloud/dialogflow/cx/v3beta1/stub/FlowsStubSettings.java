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

package com.google.cloud.dialogflow.cx.v3beta1.stub;

import static com.google.cloud.dialogflow.cx.v3beta1.FlowsClient.ListFlowsPagedResponse;

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
import com.google.cloud.dialogflow.cx.v3beta1.CreateFlowRequest;
import com.google.cloud.dialogflow.cx.v3beta1.DeleteFlowRequest;
import com.google.cloud.dialogflow.cx.v3beta1.Flow;
import com.google.cloud.dialogflow.cx.v3beta1.GetFlowRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ListFlowsRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ListFlowsResponse;
import com.google.cloud.dialogflow.cx.v3beta1.TrainFlowRequest;
import com.google.cloud.dialogflow.cx.v3beta1.UpdateFlowRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.Struct;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link FlowsStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (dialogflow.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createFlow to 30 seconds:
 *
 * <pre>{@code
 * FlowsStubSettings.Builder flowsSettingsBuilder = FlowsStubSettings.newBuilder();
 * flowsSettingsBuilder
 *     .createFlowSettings()
 *     .setRetrySettings(
 *         flowsSettingsBuilder
 *             .createFlowSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * FlowsStubSettings flowsSettings = flowsSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class FlowsStubSettings extends StubSettings<FlowsStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/dialogflow")
          .build();

  private final UnaryCallSettings<CreateFlowRequest, Flow> createFlowSettings;
  private final UnaryCallSettings<DeleteFlowRequest, Empty> deleteFlowSettings;
  private final PagedCallSettings<ListFlowsRequest, ListFlowsResponse, ListFlowsPagedResponse>
      listFlowsSettings;
  private final UnaryCallSettings<GetFlowRequest, Flow> getFlowSettings;
  private final UnaryCallSettings<UpdateFlowRequest, Flow> updateFlowSettings;
  private final UnaryCallSettings<TrainFlowRequest, Operation> trainFlowSettings;
  private final OperationCallSettings<TrainFlowRequest, Empty, Struct> trainFlowOperationSettings;

  private static final PagedListDescriptor<ListFlowsRequest, ListFlowsResponse, Flow>
      LIST_FLOWS_PAGE_STR_DESC =
          new PagedListDescriptor<ListFlowsRequest, ListFlowsResponse, Flow>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListFlowsRequest injectToken(ListFlowsRequest payload, String token) {
              return ListFlowsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListFlowsRequest injectPageSize(ListFlowsRequest payload, int pageSize) {
              return ListFlowsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListFlowsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListFlowsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Flow> extractResources(ListFlowsResponse payload) {
              return payload.getFlowsList() == null
                  ? ImmutableList.<Flow>of()
                  : payload.getFlowsList();
            }
          };

  private static final PagedListResponseFactory<
          ListFlowsRequest, ListFlowsResponse, ListFlowsPagedResponse>
      LIST_FLOWS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListFlowsRequest, ListFlowsResponse, ListFlowsPagedResponse>() {
            @Override
            public ApiFuture<ListFlowsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListFlowsRequest, ListFlowsResponse> callable,
                ListFlowsRequest request,
                ApiCallContext context,
                ApiFuture<ListFlowsResponse> futureResponse) {
              PageContext<ListFlowsRequest, ListFlowsResponse, Flow> pageContext =
                  PageContext.create(callable, LIST_FLOWS_PAGE_STR_DESC, request, context);
              return ListFlowsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createFlow. */
  public UnaryCallSettings<CreateFlowRequest, Flow> createFlowSettings() {
    return createFlowSettings;
  }

  /** Returns the object with the settings used for calls to deleteFlow. */
  public UnaryCallSettings<DeleteFlowRequest, Empty> deleteFlowSettings() {
    return deleteFlowSettings;
  }

  /** Returns the object with the settings used for calls to listFlows. */
  public PagedCallSettings<ListFlowsRequest, ListFlowsResponse, ListFlowsPagedResponse>
      listFlowsSettings() {
    return listFlowsSettings;
  }

  /** Returns the object with the settings used for calls to getFlow. */
  public UnaryCallSettings<GetFlowRequest, Flow> getFlowSettings() {
    return getFlowSettings;
  }

  /** Returns the object with the settings used for calls to updateFlow. */
  public UnaryCallSettings<UpdateFlowRequest, Flow> updateFlowSettings() {
    return updateFlowSettings;
  }

  /** Returns the object with the settings used for calls to trainFlow. */
  public UnaryCallSettings<TrainFlowRequest, Operation> trainFlowSettings() {
    return trainFlowSettings;
  }

  /** Returns the object with the settings used for calls to trainFlow. */
  public OperationCallSettings<TrainFlowRequest, Empty, Struct> trainFlowOperationSettings() {
    return trainFlowOperationSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public FlowsStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcFlowsStub.create(this);
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
    return "dialogflow.googleapis.com:443";
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
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(FlowsStubSettings.class))
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

  protected FlowsStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createFlowSettings = settingsBuilder.createFlowSettings().build();
    deleteFlowSettings = settingsBuilder.deleteFlowSettings().build();
    listFlowsSettings = settingsBuilder.listFlowsSettings().build();
    getFlowSettings = settingsBuilder.getFlowSettings().build();
    updateFlowSettings = settingsBuilder.updateFlowSettings().build();
    trainFlowSettings = settingsBuilder.trainFlowSettings().build();
    trainFlowOperationSettings = settingsBuilder.trainFlowOperationSettings().build();
  }

  /** Builder for FlowsStubSettings. */
  public static class Builder extends StubSettings.Builder<FlowsStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateFlowRequest, Flow> createFlowSettings;
    private final UnaryCallSettings.Builder<DeleteFlowRequest, Empty> deleteFlowSettings;
    private final PagedCallSettings.Builder<
            ListFlowsRequest, ListFlowsResponse, ListFlowsPagedResponse>
        listFlowsSettings;
    private final UnaryCallSettings.Builder<GetFlowRequest, Flow> getFlowSettings;
    private final UnaryCallSettings.Builder<UpdateFlowRequest, Flow> updateFlowSettings;
    private final UnaryCallSettings.Builder<TrainFlowRequest, Operation> trainFlowSettings;
    private final OperationCallSettings.Builder<TrainFlowRequest, Empty, Struct>
        trainFlowOperationSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
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
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
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

      createFlowSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteFlowSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listFlowsSettings = PagedCallSettings.newBuilder(LIST_FLOWS_PAGE_STR_FACT);
      getFlowSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateFlowSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      trainFlowSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      trainFlowOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createFlowSettings,
              deleteFlowSettings,
              listFlowsSettings,
              getFlowSettings,
              updateFlowSettings,
              trainFlowSettings);
      initDefaults(this);
    }

    protected Builder(FlowsStubSettings settings) {
      super(settings);

      createFlowSettings = settings.createFlowSettings.toBuilder();
      deleteFlowSettings = settings.deleteFlowSettings.toBuilder();
      listFlowsSettings = settings.listFlowsSettings.toBuilder();
      getFlowSettings = settings.getFlowSettings.toBuilder();
      updateFlowSettings = settings.updateFlowSettings.toBuilder();
      trainFlowSettings = settings.trainFlowSettings.toBuilder();
      trainFlowOperationSettings = settings.trainFlowOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createFlowSettings,
              deleteFlowSettings,
              listFlowsSettings,
              getFlowSettings,
              updateFlowSettings,
              trainFlowSettings);
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
          .createFlowSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteFlowSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listFlowsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getFlowSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateFlowSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .trainFlowSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .trainFlowOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<TrainFlowRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Struct.class))
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

    /** Returns the builder for the settings used for calls to createFlow. */
    public UnaryCallSettings.Builder<CreateFlowRequest, Flow> createFlowSettings() {
      return createFlowSettings;
    }

    /** Returns the builder for the settings used for calls to deleteFlow. */
    public UnaryCallSettings.Builder<DeleteFlowRequest, Empty> deleteFlowSettings() {
      return deleteFlowSettings;
    }

    /** Returns the builder for the settings used for calls to listFlows. */
    public PagedCallSettings.Builder<ListFlowsRequest, ListFlowsResponse, ListFlowsPagedResponse>
        listFlowsSettings() {
      return listFlowsSettings;
    }

    /** Returns the builder for the settings used for calls to getFlow. */
    public UnaryCallSettings.Builder<GetFlowRequest, Flow> getFlowSettings() {
      return getFlowSettings;
    }

    /** Returns the builder for the settings used for calls to updateFlow. */
    public UnaryCallSettings.Builder<UpdateFlowRequest, Flow> updateFlowSettings() {
      return updateFlowSettings;
    }

    /** Returns the builder for the settings used for calls to trainFlow. */
    public UnaryCallSettings.Builder<TrainFlowRequest, Operation> trainFlowSettings() {
      return trainFlowSettings;
    }

    /** Returns the builder for the settings used for calls to trainFlow. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<TrainFlowRequest, Empty, Struct>
        trainFlowOperationSettings() {
      return trainFlowOperationSettings;
    }

    @Override
    public FlowsStubSettings build() throws IOException {
      return new FlowsStubSettings(this);
    }
  }
}
