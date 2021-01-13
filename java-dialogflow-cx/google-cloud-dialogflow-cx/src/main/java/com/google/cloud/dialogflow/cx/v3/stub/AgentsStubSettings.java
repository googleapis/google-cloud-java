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

package com.google.cloud.dialogflow.cx.v3.stub;

import static com.google.cloud.dialogflow.cx.v3.AgentsClient.ListAgentsPagedResponse;

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
import com.google.cloud.dialogflow.cx.v3.Agent;
import com.google.cloud.dialogflow.cx.v3.CreateAgentRequest;
import com.google.cloud.dialogflow.cx.v3.DeleteAgentRequest;
import com.google.cloud.dialogflow.cx.v3.ExportAgentRequest;
import com.google.cloud.dialogflow.cx.v3.ExportAgentResponse;
import com.google.cloud.dialogflow.cx.v3.GetAgentRequest;
import com.google.cloud.dialogflow.cx.v3.ListAgentsRequest;
import com.google.cloud.dialogflow.cx.v3.ListAgentsResponse;
import com.google.cloud.dialogflow.cx.v3.RestoreAgentRequest;
import com.google.cloud.dialogflow.cx.v3.UpdateAgentRequest;
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
 * Settings class to configure an instance of {@link AgentsStub}.
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
 * <p>For example, to set the total timeout of getAgent to 30 seconds:
 *
 * <pre>{@code
 * AgentsStubSettings.Builder agentsSettingsBuilder = AgentsStubSettings.newBuilder();
 * agentsSettingsBuilder
 *     .getAgentSettings()
 *     .setRetrySettings(
 *         agentsSettingsBuilder
 *             .getAgentSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * AgentsStubSettings agentsSettings = agentsSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class AgentsStubSettings extends StubSettings<AgentsStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/dialogflow")
          .build();

  private final PagedCallSettings<ListAgentsRequest, ListAgentsResponse, ListAgentsPagedResponse>
      listAgentsSettings;
  private final UnaryCallSettings<GetAgentRequest, Agent> getAgentSettings;
  private final UnaryCallSettings<CreateAgentRequest, Agent> createAgentSettings;
  private final UnaryCallSettings<UpdateAgentRequest, Agent> updateAgentSettings;
  private final UnaryCallSettings<DeleteAgentRequest, Empty> deleteAgentSettings;
  private final UnaryCallSettings<ExportAgentRequest, Operation> exportAgentSettings;
  private final OperationCallSettings<ExportAgentRequest, ExportAgentResponse, Struct>
      exportAgentOperationSettings;
  private final UnaryCallSettings<RestoreAgentRequest, Operation> restoreAgentSettings;
  private final OperationCallSettings<RestoreAgentRequest, Empty, Struct>
      restoreAgentOperationSettings;

  private static final PagedListDescriptor<ListAgentsRequest, ListAgentsResponse, Agent>
      LIST_AGENTS_PAGE_STR_DESC =
          new PagedListDescriptor<ListAgentsRequest, ListAgentsResponse, Agent>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAgentsRequest injectToken(ListAgentsRequest payload, String token) {
              return ListAgentsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAgentsRequest injectPageSize(ListAgentsRequest payload, int pageSize) {
              return ListAgentsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAgentsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAgentsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Agent> extractResources(ListAgentsResponse payload) {
              return payload.getAgentsList() == null
                  ? ImmutableList.<Agent>of()
                  : payload.getAgentsList();
            }
          };

  private static final PagedListResponseFactory<
          ListAgentsRequest, ListAgentsResponse, ListAgentsPagedResponse>
      LIST_AGENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAgentsRequest, ListAgentsResponse, ListAgentsPagedResponse>() {
            @Override
            public ApiFuture<ListAgentsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAgentsRequest, ListAgentsResponse> callable,
                ListAgentsRequest request,
                ApiCallContext context,
                ApiFuture<ListAgentsResponse> futureResponse) {
              PageContext<ListAgentsRequest, ListAgentsResponse, Agent> pageContext =
                  PageContext.create(callable, LIST_AGENTS_PAGE_STR_DESC, request, context);
              return ListAgentsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listAgents. */
  public PagedCallSettings<ListAgentsRequest, ListAgentsResponse, ListAgentsPagedResponse>
      listAgentsSettings() {
    return listAgentsSettings;
  }

  /** Returns the object with the settings used for calls to getAgent. */
  public UnaryCallSettings<GetAgentRequest, Agent> getAgentSettings() {
    return getAgentSettings;
  }

  /** Returns the object with the settings used for calls to createAgent. */
  public UnaryCallSettings<CreateAgentRequest, Agent> createAgentSettings() {
    return createAgentSettings;
  }

  /** Returns the object with the settings used for calls to updateAgent. */
  public UnaryCallSettings<UpdateAgentRequest, Agent> updateAgentSettings() {
    return updateAgentSettings;
  }

  /** Returns the object with the settings used for calls to deleteAgent. */
  public UnaryCallSettings<DeleteAgentRequest, Empty> deleteAgentSettings() {
    return deleteAgentSettings;
  }

  /** Returns the object with the settings used for calls to exportAgent. */
  public UnaryCallSettings<ExportAgentRequest, Operation> exportAgentSettings() {
    return exportAgentSettings;
  }

  /** Returns the object with the settings used for calls to exportAgent. */
  public OperationCallSettings<ExportAgentRequest, ExportAgentResponse, Struct>
      exportAgentOperationSettings() {
    return exportAgentOperationSettings;
  }

  /** Returns the object with the settings used for calls to restoreAgent. */
  public UnaryCallSettings<RestoreAgentRequest, Operation> restoreAgentSettings() {
    return restoreAgentSettings;
  }

  /** Returns the object with the settings used for calls to restoreAgent. */
  public OperationCallSettings<RestoreAgentRequest, Empty, Struct> restoreAgentOperationSettings() {
    return restoreAgentOperationSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public AgentsStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcAgentsStub.create(this);
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
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(AgentsStubSettings.class))
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

  protected AgentsStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listAgentsSettings = settingsBuilder.listAgentsSettings().build();
    getAgentSettings = settingsBuilder.getAgentSettings().build();
    createAgentSettings = settingsBuilder.createAgentSettings().build();
    updateAgentSettings = settingsBuilder.updateAgentSettings().build();
    deleteAgentSettings = settingsBuilder.deleteAgentSettings().build();
    exportAgentSettings = settingsBuilder.exportAgentSettings().build();
    exportAgentOperationSettings = settingsBuilder.exportAgentOperationSettings().build();
    restoreAgentSettings = settingsBuilder.restoreAgentSettings().build();
    restoreAgentOperationSettings = settingsBuilder.restoreAgentOperationSettings().build();
  }

  /** Builder for AgentsStubSettings. */
  public static class Builder extends StubSettings.Builder<AgentsStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListAgentsRequest, ListAgentsResponse, ListAgentsPagedResponse>
        listAgentsSettings;
    private final UnaryCallSettings.Builder<GetAgentRequest, Agent> getAgentSettings;
    private final UnaryCallSettings.Builder<CreateAgentRequest, Agent> createAgentSettings;
    private final UnaryCallSettings.Builder<UpdateAgentRequest, Agent> updateAgentSettings;
    private final UnaryCallSettings.Builder<DeleteAgentRequest, Empty> deleteAgentSettings;
    private final UnaryCallSettings.Builder<ExportAgentRequest, Operation> exportAgentSettings;
    private final OperationCallSettings.Builder<ExportAgentRequest, ExportAgentResponse, Struct>
        exportAgentOperationSettings;
    private final UnaryCallSettings.Builder<RestoreAgentRequest, Operation> restoreAgentSettings;
    private final OperationCallSettings.Builder<RestoreAgentRequest, Empty, Struct>
        restoreAgentOperationSettings;
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

      listAgentsSettings = PagedCallSettings.newBuilder(LIST_AGENTS_PAGE_STR_FACT);
      getAgentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createAgentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateAgentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteAgentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      exportAgentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      exportAgentOperationSettings = OperationCallSettings.newBuilder();
      restoreAgentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      restoreAgentOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listAgentsSettings,
              getAgentSettings,
              createAgentSettings,
              updateAgentSettings,
              deleteAgentSettings,
              exportAgentSettings,
              restoreAgentSettings);
      initDefaults(this);
    }

    protected Builder(AgentsStubSettings settings) {
      super(settings);

      listAgentsSettings = settings.listAgentsSettings.toBuilder();
      getAgentSettings = settings.getAgentSettings.toBuilder();
      createAgentSettings = settings.createAgentSettings.toBuilder();
      updateAgentSettings = settings.updateAgentSettings.toBuilder();
      deleteAgentSettings = settings.deleteAgentSettings.toBuilder();
      exportAgentSettings = settings.exportAgentSettings.toBuilder();
      exportAgentOperationSettings = settings.exportAgentOperationSettings.toBuilder();
      restoreAgentSettings = settings.restoreAgentSettings.toBuilder();
      restoreAgentOperationSettings = settings.restoreAgentOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listAgentsSettings,
              getAgentSettings,
              createAgentSettings,
              updateAgentSettings,
              deleteAgentSettings,
              exportAgentSettings,
              restoreAgentSettings);
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
          .listAgentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getAgentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createAgentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateAgentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteAgentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .exportAgentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .restoreAgentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .exportAgentOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<ExportAgentRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ExportAgentResponse.class))
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

      builder
          .restoreAgentOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<RestoreAgentRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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

    /** Returns the builder for the settings used for calls to listAgents. */
    public PagedCallSettings.Builder<ListAgentsRequest, ListAgentsResponse, ListAgentsPagedResponse>
        listAgentsSettings() {
      return listAgentsSettings;
    }

    /** Returns the builder for the settings used for calls to getAgent. */
    public UnaryCallSettings.Builder<GetAgentRequest, Agent> getAgentSettings() {
      return getAgentSettings;
    }

    /** Returns the builder for the settings used for calls to createAgent. */
    public UnaryCallSettings.Builder<CreateAgentRequest, Agent> createAgentSettings() {
      return createAgentSettings;
    }

    /** Returns the builder for the settings used for calls to updateAgent. */
    public UnaryCallSettings.Builder<UpdateAgentRequest, Agent> updateAgentSettings() {
      return updateAgentSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAgent. */
    public UnaryCallSettings.Builder<DeleteAgentRequest, Empty> deleteAgentSettings() {
      return deleteAgentSettings;
    }

    /** Returns the builder for the settings used for calls to exportAgent. */
    public UnaryCallSettings.Builder<ExportAgentRequest, Operation> exportAgentSettings() {
      return exportAgentSettings;
    }

    /** Returns the builder for the settings used for calls to exportAgent. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<ExportAgentRequest, ExportAgentResponse, Struct>
        exportAgentOperationSettings() {
      return exportAgentOperationSettings;
    }

    /** Returns the builder for the settings used for calls to restoreAgent. */
    public UnaryCallSettings.Builder<RestoreAgentRequest, Operation> restoreAgentSettings() {
      return restoreAgentSettings;
    }

    /** Returns the builder for the settings used for calls to restoreAgent. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<RestoreAgentRequest, Empty, Struct>
        restoreAgentOperationSettings() {
      return restoreAgentOperationSettings;
    }

    @Override
    public AgentsStubSettings build() throws IOException {
      return new AgentsStubSettings(this);
    }
  }
}
