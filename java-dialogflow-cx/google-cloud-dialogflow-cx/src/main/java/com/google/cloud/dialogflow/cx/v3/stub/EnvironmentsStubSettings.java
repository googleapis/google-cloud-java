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

import static com.google.cloud.dialogflow.cx.v3.EnvironmentsClient.ListEnvironmentsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3.EnvironmentsClient.LookupEnvironmentHistoryPagedResponse;

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
import com.google.cloud.dialogflow.cx.v3.CreateEnvironmentRequest;
import com.google.cloud.dialogflow.cx.v3.DeleteEnvironmentRequest;
import com.google.cloud.dialogflow.cx.v3.Environment;
import com.google.cloud.dialogflow.cx.v3.GetEnvironmentRequest;
import com.google.cloud.dialogflow.cx.v3.ListEnvironmentsRequest;
import com.google.cloud.dialogflow.cx.v3.ListEnvironmentsResponse;
import com.google.cloud.dialogflow.cx.v3.LookupEnvironmentHistoryRequest;
import com.google.cloud.dialogflow.cx.v3.LookupEnvironmentHistoryResponse;
import com.google.cloud.dialogflow.cx.v3.UpdateEnvironmentRequest;
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
 * Settings class to configure an instance of {@link EnvironmentsStub}.
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
 * <p>For example, to set the total timeout of getEnvironment to 30 seconds:
 *
 * <pre>{@code
 * EnvironmentsStubSettings.Builder environmentsSettingsBuilder =
 *     EnvironmentsStubSettings.newBuilder();
 * environmentsSettingsBuilder
 *     .getEnvironmentSettings()
 *     .setRetrySettings(
 *         environmentsSettingsBuilder
 *             .getEnvironmentSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * EnvironmentsStubSettings environmentsSettings = environmentsSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class EnvironmentsStubSettings extends StubSettings<EnvironmentsStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/dialogflow")
          .build();

  private final PagedCallSettings<
          ListEnvironmentsRequest, ListEnvironmentsResponse, ListEnvironmentsPagedResponse>
      listEnvironmentsSettings;
  private final UnaryCallSettings<GetEnvironmentRequest, Environment> getEnvironmentSettings;
  private final UnaryCallSettings<CreateEnvironmentRequest, Operation> createEnvironmentSettings;
  private final OperationCallSettings<CreateEnvironmentRequest, Environment, Struct>
      createEnvironmentOperationSettings;
  private final UnaryCallSettings<UpdateEnvironmentRequest, Operation> updateEnvironmentSettings;
  private final OperationCallSettings<UpdateEnvironmentRequest, Environment, Struct>
      updateEnvironmentOperationSettings;
  private final UnaryCallSettings<DeleteEnvironmentRequest, Empty> deleteEnvironmentSettings;
  private final PagedCallSettings<
          LookupEnvironmentHistoryRequest,
          LookupEnvironmentHistoryResponse,
          LookupEnvironmentHistoryPagedResponse>
      lookupEnvironmentHistorySettings;

  private static final PagedListDescriptor<
          ListEnvironmentsRequest, ListEnvironmentsResponse, Environment>
      LIST_ENVIRONMENTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListEnvironmentsRequest, ListEnvironmentsResponse, Environment>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListEnvironmentsRequest injectToken(
                ListEnvironmentsRequest payload, String token) {
              return ListEnvironmentsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListEnvironmentsRequest injectPageSize(
                ListEnvironmentsRequest payload, int pageSize) {
              return ListEnvironmentsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListEnvironmentsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListEnvironmentsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Environment> extractResources(ListEnvironmentsResponse payload) {
              return payload.getEnvironmentsList() == null
                  ? ImmutableList.<Environment>of()
                  : payload.getEnvironmentsList();
            }
          };

  private static final PagedListDescriptor<
          LookupEnvironmentHistoryRequest, LookupEnvironmentHistoryResponse, Environment>
      LOOKUP_ENVIRONMENT_HISTORY_PAGE_STR_DESC =
          new PagedListDescriptor<
              LookupEnvironmentHistoryRequest, LookupEnvironmentHistoryResponse, Environment>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public LookupEnvironmentHistoryRequest injectToken(
                LookupEnvironmentHistoryRequest payload, String token) {
              return LookupEnvironmentHistoryRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public LookupEnvironmentHistoryRequest injectPageSize(
                LookupEnvironmentHistoryRequest payload, int pageSize) {
              return LookupEnvironmentHistoryRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(LookupEnvironmentHistoryRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(LookupEnvironmentHistoryResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Environment> extractResources(
                LookupEnvironmentHistoryResponse payload) {
              return payload.getEnvironmentsList() == null
                  ? ImmutableList.<Environment>of()
                  : payload.getEnvironmentsList();
            }
          };

  private static final PagedListResponseFactory<
          ListEnvironmentsRequest, ListEnvironmentsResponse, ListEnvironmentsPagedResponse>
      LIST_ENVIRONMENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListEnvironmentsRequest, ListEnvironmentsResponse, ListEnvironmentsPagedResponse>() {
            @Override
            public ApiFuture<ListEnvironmentsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListEnvironmentsRequest, ListEnvironmentsResponse> callable,
                ListEnvironmentsRequest request,
                ApiCallContext context,
                ApiFuture<ListEnvironmentsResponse> futureResponse) {
              PageContext<ListEnvironmentsRequest, ListEnvironmentsResponse, Environment>
                  pageContext =
                      PageContext.create(
                          callable, LIST_ENVIRONMENTS_PAGE_STR_DESC, request, context);
              return ListEnvironmentsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          LookupEnvironmentHistoryRequest,
          LookupEnvironmentHistoryResponse,
          LookupEnvironmentHistoryPagedResponse>
      LOOKUP_ENVIRONMENT_HISTORY_PAGE_STR_FACT =
          new PagedListResponseFactory<
              LookupEnvironmentHistoryRequest,
              LookupEnvironmentHistoryResponse,
              LookupEnvironmentHistoryPagedResponse>() {
            @Override
            public ApiFuture<LookupEnvironmentHistoryPagedResponse> getFuturePagedResponse(
                UnaryCallable<LookupEnvironmentHistoryRequest, LookupEnvironmentHistoryResponse>
                    callable,
                LookupEnvironmentHistoryRequest request,
                ApiCallContext context,
                ApiFuture<LookupEnvironmentHistoryResponse> futureResponse) {
              PageContext<
                      LookupEnvironmentHistoryRequest,
                      LookupEnvironmentHistoryResponse,
                      Environment>
                  pageContext =
                      PageContext.create(
                          callable, LOOKUP_ENVIRONMENT_HISTORY_PAGE_STR_DESC, request, context);
              return LookupEnvironmentHistoryPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listEnvironments. */
  public PagedCallSettings<
          ListEnvironmentsRequest, ListEnvironmentsResponse, ListEnvironmentsPagedResponse>
      listEnvironmentsSettings() {
    return listEnvironmentsSettings;
  }

  /** Returns the object with the settings used for calls to getEnvironment. */
  public UnaryCallSettings<GetEnvironmentRequest, Environment> getEnvironmentSettings() {
    return getEnvironmentSettings;
  }

  /** Returns the object with the settings used for calls to createEnvironment. */
  public UnaryCallSettings<CreateEnvironmentRequest, Operation> createEnvironmentSettings() {
    return createEnvironmentSettings;
  }

  /** Returns the object with the settings used for calls to createEnvironment. */
  public OperationCallSettings<CreateEnvironmentRequest, Environment, Struct>
      createEnvironmentOperationSettings() {
    return createEnvironmentOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateEnvironment. */
  public UnaryCallSettings<UpdateEnvironmentRequest, Operation> updateEnvironmentSettings() {
    return updateEnvironmentSettings;
  }

  /** Returns the object with the settings used for calls to updateEnvironment. */
  public OperationCallSettings<UpdateEnvironmentRequest, Environment, Struct>
      updateEnvironmentOperationSettings() {
    return updateEnvironmentOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteEnvironment. */
  public UnaryCallSettings<DeleteEnvironmentRequest, Empty> deleteEnvironmentSettings() {
    return deleteEnvironmentSettings;
  }

  /** Returns the object with the settings used for calls to lookupEnvironmentHistory. */
  public PagedCallSettings<
          LookupEnvironmentHistoryRequest,
          LookupEnvironmentHistoryResponse,
          LookupEnvironmentHistoryPagedResponse>
      lookupEnvironmentHistorySettings() {
    return lookupEnvironmentHistorySettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public EnvironmentsStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcEnvironmentsStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(EnvironmentsStubSettings.class))
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

  protected EnvironmentsStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listEnvironmentsSettings = settingsBuilder.listEnvironmentsSettings().build();
    getEnvironmentSettings = settingsBuilder.getEnvironmentSettings().build();
    createEnvironmentSettings = settingsBuilder.createEnvironmentSettings().build();
    createEnvironmentOperationSettings =
        settingsBuilder.createEnvironmentOperationSettings().build();
    updateEnvironmentSettings = settingsBuilder.updateEnvironmentSettings().build();
    updateEnvironmentOperationSettings =
        settingsBuilder.updateEnvironmentOperationSettings().build();
    deleteEnvironmentSettings = settingsBuilder.deleteEnvironmentSettings().build();
    lookupEnvironmentHistorySettings = settingsBuilder.lookupEnvironmentHistorySettings().build();
  }

  /** Builder for EnvironmentsStubSettings. */
  public static class Builder extends StubSettings.Builder<EnvironmentsStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListEnvironmentsRequest, ListEnvironmentsResponse, ListEnvironmentsPagedResponse>
        listEnvironmentsSettings;
    private final UnaryCallSettings.Builder<GetEnvironmentRequest, Environment>
        getEnvironmentSettings;
    private final UnaryCallSettings.Builder<CreateEnvironmentRequest, Operation>
        createEnvironmentSettings;
    private final OperationCallSettings.Builder<CreateEnvironmentRequest, Environment, Struct>
        createEnvironmentOperationSettings;
    private final UnaryCallSettings.Builder<UpdateEnvironmentRequest, Operation>
        updateEnvironmentSettings;
    private final OperationCallSettings.Builder<UpdateEnvironmentRequest, Environment, Struct>
        updateEnvironmentOperationSettings;
    private final UnaryCallSettings.Builder<DeleteEnvironmentRequest, Empty>
        deleteEnvironmentSettings;
    private final PagedCallSettings.Builder<
            LookupEnvironmentHistoryRequest,
            LookupEnvironmentHistoryResponse,
            LookupEnvironmentHistoryPagedResponse>
        lookupEnvironmentHistorySettings;
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

      listEnvironmentsSettings = PagedCallSettings.newBuilder(LIST_ENVIRONMENTS_PAGE_STR_FACT);
      getEnvironmentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createEnvironmentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createEnvironmentOperationSettings = OperationCallSettings.newBuilder();
      updateEnvironmentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateEnvironmentOperationSettings = OperationCallSettings.newBuilder();
      deleteEnvironmentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      lookupEnvironmentHistorySettings =
          PagedCallSettings.newBuilder(LOOKUP_ENVIRONMENT_HISTORY_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listEnvironmentsSettings,
              getEnvironmentSettings,
              createEnvironmentSettings,
              updateEnvironmentSettings,
              deleteEnvironmentSettings,
              lookupEnvironmentHistorySettings);
      initDefaults(this);
    }

    protected Builder(EnvironmentsStubSettings settings) {
      super(settings);

      listEnvironmentsSettings = settings.listEnvironmentsSettings.toBuilder();
      getEnvironmentSettings = settings.getEnvironmentSettings.toBuilder();
      createEnvironmentSettings = settings.createEnvironmentSettings.toBuilder();
      createEnvironmentOperationSettings = settings.createEnvironmentOperationSettings.toBuilder();
      updateEnvironmentSettings = settings.updateEnvironmentSettings.toBuilder();
      updateEnvironmentOperationSettings = settings.updateEnvironmentOperationSettings.toBuilder();
      deleteEnvironmentSettings = settings.deleteEnvironmentSettings.toBuilder();
      lookupEnvironmentHistorySettings = settings.lookupEnvironmentHistorySettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listEnvironmentsSettings,
              getEnvironmentSettings,
              createEnvironmentSettings,
              updateEnvironmentSettings,
              deleteEnvironmentSettings,
              lookupEnvironmentHistorySettings);
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
          .listEnvironmentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getEnvironmentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createEnvironmentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateEnvironmentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteEnvironmentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .lookupEnvironmentHistorySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createEnvironmentOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateEnvironmentRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Environment.class))
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
          .updateEnvironmentOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateEnvironmentRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Environment.class))
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

    /** Returns the builder for the settings used for calls to listEnvironments. */
    public PagedCallSettings.Builder<
            ListEnvironmentsRequest, ListEnvironmentsResponse, ListEnvironmentsPagedResponse>
        listEnvironmentsSettings() {
      return listEnvironmentsSettings;
    }

    /** Returns the builder for the settings used for calls to getEnvironment. */
    public UnaryCallSettings.Builder<GetEnvironmentRequest, Environment> getEnvironmentSettings() {
      return getEnvironmentSettings;
    }

    /** Returns the builder for the settings used for calls to createEnvironment. */
    public UnaryCallSettings.Builder<CreateEnvironmentRequest, Operation>
        createEnvironmentSettings() {
      return createEnvironmentSettings;
    }

    /** Returns the builder for the settings used for calls to createEnvironment. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateEnvironmentRequest, Environment, Struct>
        createEnvironmentOperationSettings() {
      return createEnvironmentOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateEnvironment. */
    public UnaryCallSettings.Builder<UpdateEnvironmentRequest, Operation>
        updateEnvironmentSettings() {
      return updateEnvironmentSettings;
    }

    /** Returns the builder for the settings used for calls to updateEnvironment. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpdateEnvironmentRequest, Environment, Struct>
        updateEnvironmentOperationSettings() {
      return updateEnvironmentOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteEnvironment. */
    public UnaryCallSettings.Builder<DeleteEnvironmentRequest, Empty> deleteEnvironmentSettings() {
      return deleteEnvironmentSettings;
    }

    /** Returns the builder for the settings used for calls to lookupEnvironmentHistory. */
    public PagedCallSettings.Builder<
            LookupEnvironmentHistoryRequest,
            LookupEnvironmentHistoryResponse,
            LookupEnvironmentHistoryPagedResponse>
        lookupEnvironmentHistorySettings() {
      return lookupEnvironmentHistorySettings;
    }

    @Override
    public EnvironmentsStubSettings build() throws IOException {
      return new EnvironmentsStubSettings(this);
    }
  }
}
