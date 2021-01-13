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

import static com.google.cloud.dialogflow.cx.v3.ExperimentsClient.ListExperimentsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.cx.v3.CreateExperimentRequest;
import com.google.cloud.dialogflow.cx.v3.DeleteExperimentRequest;
import com.google.cloud.dialogflow.cx.v3.Experiment;
import com.google.cloud.dialogflow.cx.v3.GetExperimentRequest;
import com.google.cloud.dialogflow.cx.v3.ListExperimentsRequest;
import com.google.cloud.dialogflow.cx.v3.ListExperimentsResponse;
import com.google.cloud.dialogflow.cx.v3.StartExperimentRequest;
import com.google.cloud.dialogflow.cx.v3.StopExperimentRequest;
import com.google.cloud.dialogflow.cx.v3.UpdateExperimentRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ExperimentsStub}.
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
 * <p>For example, to set the total timeout of getExperiment to 30 seconds:
 *
 * <pre>{@code
 * ExperimentsStubSettings.Builder experimentsSettingsBuilder =
 *     ExperimentsStubSettings.newBuilder();
 * experimentsSettingsBuilder
 *     .getExperimentSettings()
 *     .setRetrySettings(
 *         experimentsSettingsBuilder
 *             .getExperimentSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ExperimentsStubSettings experimentsSettings = experimentsSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class ExperimentsStubSettings extends StubSettings<ExperimentsStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/dialogflow")
          .build();

  private final PagedCallSettings<
          ListExperimentsRequest, ListExperimentsResponse, ListExperimentsPagedResponse>
      listExperimentsSettings;
  private final UnaryCallSettings<GetExperimentRequest, Experiment> getExperimentSettings;
  private final UnaryCallSettings<CreateExperimentRequest, Experiment> createExperimentSettings;
  private final UnaryCallSettings<UpdateExperimentRequest, Experiment> updateExperimentSettings;
  private final UnaryCallSettings<DeleteExperimentRequest, Empty> deleteExperimentSettings;
  private final UnaryCallSettings<StartExperimentRequest, Experiment> startExperimentSettings;
  private final UnaryCallSettings<StopExperimentRequest, Experiment> stopExperimentSettings;

  private static final PagedListDescriptor<
          ListExperimentsRequest, ListExperimentsResponse, Experiment>
      LIST_EXPERIMENTS_PAGE_STR_DESC =
          new PagedListDescriptor<ListExperimentsRequest, ListExperimentsResponse, Experiment>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListExperimentsRequest injectToken(
                ListExperimentsRequest payload, String token) {
              return ListExperimentsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListExperimentsRequest injectPageSize(
                ListExperimentsRequest payload, int pageSize) {
              return ListExperimentsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListExperimentsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListExperimentsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Experiment> extractResources(ListExperimentsResponse payload) {
              return payload.getExperimentsList() == null
                  ? ImmutableList.<Experiment>of()
                  : payload.getExperimentsList();
            }
          };

  private static final PagedListResponseFactory<
          ListExperimentsRequest, ListExperimentsResponse, ListExperimentsPagedResponse>
      LIST_EXPERIMENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListExperimentsRequest, ListExperimentsResponse, ListExperimentsPagedResponse>() {
            @Override
            public ApiFuture<ListExperimentsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListExperimentsRequest, ListExperimentsResponse> callable,
                ListExperimentsRequest request,
                ApiCallContext context,
                ApiFuture<ListExperimentsResponse> futureResponse) {
              PageContext<ListExperimentsRequest, ListExperimentsResponse, Experiment> pageContext =
                  PageContext.create(callable, LIST_EXPERIMENTS_PAGE_STR_DESC, request, context);
              return ListExperimentsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listExperiments. */
  public PagedCallSettings<
          ListExperimentsRequest, ListExperimentsResponse, ListExperimentsPagedResponse>
      listExperimentsSettings() {
    return listExperimentsSettings;
  }

  /** Returns the object with the settings used for calls to getExperiment. */
  public UnaryCallSettings<GetExperimentRequest, Experiment> getExperimentSettings() {
    return getExperimentSettings;
  }

  /** Returns the object with the settings used for calls to createExperiment. */
  public UnaryCallSettings<CreateExperimentRequest, Experiment> createExperimentSettings() {
    return createExperimentSettings;
  }

  /** Returns the object with the settings used for calls to updateExperiment. */
  public UnaryCallSettings<UpdateExperimentRequest, Experiment> updateExperimentSettings() {
    return updateExperimentSettings;
  }

  /** Returns the object with the settings used for calls to deleteExperiment. */
  public UnaryCallSettings<DeleteExperimentRequest, Empty> deleteExperimentSettings() {
    return deleteExperimentSettings;
  }

  /** Returns the object with the settings used for calls to startExperiment. */
  public UnaryCallSettings<StartExperimentRequest, Experiment> startExperimentSettings() {
    return startExperimentSettings;
  }

  /** Returns the object with the settings used for calls to stopExperiment. */
  public UnaryCallSettings<StopExperimentRequest, Experiment> stopExperimentSettings() {
    return stopExperimentSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public ExperimentsStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcExperimentsStub.create(this);
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
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(ExperimentsStubSettings.class))
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

  protected ExperimentsStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listExperimentsSettings = settingsBuilder.listExperimentsSettings().build();
    getExperimentSettings = settingsBuilder.getExperimentSettings().build();
    createExperimentSettings = settingsBuilder.createExperimentSettings().build();
    updateExperimentSettings = settingsBuilder.updateExperimentSettings().build();
    deleteExperimentSettings = settingsBuilder.deleteExperimentSettings().build();
    startExperimentSettings = settingsBuilder.startExperimentSettings().build();
    stopExperimentSettings = settingsBuilder.stopExperimentSettings().build();
  }

  /** Builder for ExperimentsStubSettings. */
  public static class Builder extends StubSettings.Builder<ExperimentsStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListExperimentsRequest, ListExperimentsResponse, ListExperimentsPagedResponse>
        listExperimentsSettings;
    private final UnaryCallSettings.Builder<GetExperimentRequest, Experiment> getExperimentSettings;
    private final UnaryCallSettings.Builder<CreateExperimentRequest, Experiment>
        createExperimentSettings;
    private final UnaryCallSettings.Builder<UpdateExperimentRequest, Experiment>
        updateExperimentSettings;
    private final UnaryCallSettings.Builder<DeleteExperimentRequest, Empty>
        deleteExperimentSettings;
    private final UnaryCallSettings.Builder<StartExperimentRequest, Experiment>
        startExperimentSettings;
    private final UnaryCallSettings.Builder<StopExperimentRequest, Experiment>
        stopExperimentSettings;
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

      listExperimentsSettings = PagedCallSettings.newBuilder(LIST_EXPERIMENTS_PAGE_STR_FACT);
      getExperimentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createExperimentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateExperimentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteExperimentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      startExperimentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      stopExperimentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listExperimentsSettings,
              getExperimentSettings,
              createExperimentSettings,
              updateExperimentSettings,
              deleteExperimentSettings,
              startExperimentSettings,
              stopExperimentSettings);
      initDefaults(this);
    }

    protected Builder(ExperimentsStubSettings settings) {
      super(settings);

      listExperimentsSettings = settings.listExperimentsSettings.toBuilder();
      getExperimentSettings = settings.getExperimentSettings.toBuilder();
      createExperimentSettings = settings.createExperimentSettings.toBuilder();
      updateExperimentSettings = settings.updateExperimentSettings.toBuilder();
      deleteExperimentSettings = settings.deleteExperimentSettings.toBuilder();
      startExperimentSettings = settings.startExperimentSettings.toBuilder();
      stopExperimentSettings = settings.stopExperimentSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listExperimentsSettings,
              getExperimentSettings,
              createExperimentSettings,
              updateExperimentSettings,
              deleteExperimentSettings,
              startExperimentSettings,
              stopExperimentSettings);
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
          .listExperimentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getExperimentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createExperimentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateExperimentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteExperimentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .startExperimentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .stopExperimentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

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

    /** Returns the builder for the settings used for calls to listExperiments. */
    public PagedCallSettings.Builder<
            ListExperimentsRequest, ListExperimentsResponse, ListExperimentsPagedResponse>
        listExperimentsSettings() {
      return listExperimentsSettings;
    }

    /** Returns the builder for the settings used for calls to getExperiment. */
    public UnaryCallSettings.Builder<GetExperimentRequest, Experiment> getExperimentSettings() {
      return getExperimentSettings;
    }

    /** Returns the builder for the settings used for calls to createExperiment. */
    public UnaryCallSettings.Builder<CreateExperimentRequest, Experiment>
        createExperimentSettings() {
      return createExperimentSettings;
    }

    /** Returns the builder for the settings used for calls to updateExperiment. */
    public UnaryCallSettings.Builder<UpdateExperimentRequest, Experiment>
        updateExperimentSettings() {
      return updateExperimentSettings;
    }

    /** Returns the builder for the settings used for calls to deleteExperiment. */
    public UnaryCallSettings.Builder<DeleteExperimentRequest, Empty> deleteExperimentSettings() {
      return deleteExperimentSettings;
    }

    /** Returns the builder for the settings used for calls to startExperiment. */
    public UnaryCallSettings.Builder<StartExperimentRequest, Experiment> startExperimentSettings() {
      return startExperimentSettings;
    }

    /** Returns the builder for the settings used for calls to stopExperiment. */
    public UnaryCallSettings.Builder<StopExperimentRequest, Experiment> stopExperimentSettings() {
      return stopExperimentSettings;
    }

    @Override
    public ExperimentsStubSettings build() throws IOException {
      return new ExperimentsStubSettings(this);
    }
  }
}
