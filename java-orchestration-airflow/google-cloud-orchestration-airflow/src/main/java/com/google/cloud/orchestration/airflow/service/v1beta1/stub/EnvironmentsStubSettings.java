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

package com.google.cloud.orchestration.airflow.service.v1beta1.stub;

import static com.google.cloud.orchestration.airflow.service.v1beta1.EnvironmentsClient.ListEnvironmentsPagedResponse;

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
import com.google.cloud.orchestration.airflow.service.v1beta1.CheckUpgradeRequest;
import com.google.cloud.orchestration.airflow.service.v1beta1.CheckUpgradeResponse;
import com.google.cloud.orchestration.airflow.service.v1beta1.CreateEnvironmentRequest;
import com.google.cloud.orchestration.airflow.service.v1beta1.DeleteEnvironmentRequest;
import com.google.cloud.orchestration.airflow.service.v1beta1.Environment;
import com.google.cloud.orchestration.airflow.service.v1beta1.GetEnvironmentRequest;
import com.google.cloud.orchestration.airflow.service.v1beta1.ListEnvironmentsRequest;
import com.google.cloud.orchestration.airflow.service.v1beta1.ListEnvironmentsResponse;
import com.google.cloud.orchestration.airflow.service.v1beta1.OperationMetadata;
import com.google.cloud.orchestration.airflow.service.v1beta1.RestartWebServerRequest;
import com.google.cloud.orchestration.airflow.service.v1beta1.UpdateEnvironmentRequest;
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
 * Settings class to configure an instance of {@link EnvironmentsStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (composer.googleapis.com) and default port (443) are used.
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
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * EnvironmentsStubSettings.Builder environmentsSettingsBuilder =
 *     EnvironmentsStubSettings.newBuilder();
 * environmentsSettingsBuilder
 *     .getEnvironmentSettings()
 *     .setRetrySettings(
 *         environmentsSettingsBuilder.getEnvironmentSettings().getRetrySettings().toBuilder()
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
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateEnvironmentRequest, Operation> createEnvironmentSettings;
  private final OperationCallSettings<CreateEnvironmentRequest, Environment, OperationMetadata>
      createEnvironmentOperationSettings;
  private final UnaryCallSettings<GetEnvironmentRequest, Environment> getEnvironmentSettings;
  private final PagedCallSettings<
          ListEnvironmentsRequest, ListEnvironmentsResponse, ListEnvironmentsPagedResponse>
      listEnvironmentsSettings;
  private final UnaryCallSettings<UpdateEnvironmentRequest, Operation> updateEnvironmentSettings;
  private final OperationCallSettings<UpdateEnvironmentRequest, Environment, OperationMetadata>
      updateEnvironmentOperationSettings;
  private final UnaryCallSettings<DeleteEnvironmentRequest, Operation> deleteEnvironmentSettings;
  private final OperationCallSettings<DeleteEnvironmentRequest, Empty, OperationMetadata>
      deleteEnvironmentOperationSettings;
  private final UnaryCallSettings<RestartWebServerRequest, Operation> restartWebServerSettings;
  private final OperationCallSettings<RestartWebServerRequest, Environment, OperationMetadata>
      restartWebServerOperationSettings;
  private final UnaryCallSettings<CheckUpgradeRequest, Operation> checkUpgradeSettings;
  private final OperationCallSettings<CheckUpgradeRequest, CheckUpgradeResponse, OperationMetadata>
      checkUpgradeOperationSettings;

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

  /** Returns the object with the settings used for calls to createEnvironment. */
  public UnaryCallSettings<CreateEnvironmentRequest, Operation> createEnvironmentSettings() {
    return createEnvironmentSettings;
  }

  /** Returns the object with the settings used for calls to createEnvironment. */
  public OperationCallSettings<CreateEnvironmentRequest, Environment, OperationMetadata>
      createEnvironmentOperationSettings() {
    return createEnvironmentOperationSettings;
  }

  /** Returns the object with the settings used for calls to getEnvironment. */
  public UnaryCallSettings<GetEnvironmentRequest, Environment> getEnvironmentSettings() {
    return getEnvironmentSettings;
  }

  /** Returns the object with the settings used for calls to listEnvironments. */
  public PagedCallSettings<
          ListEnvironmentsRequest, ListEnvironmentsResponse, ListEnvironmentsPagedResponse>
      listEnvironmentsSettings() {
    return listEnvironmentsSettings;
  }

  /** Returns the object with the settings used for calls to updateEnvironment. */
  public UnaryCallSettings<UpdateEnvironmentRequest, Operation> updateEnvironmentSettings() {
    return updateEnvironmentSettings;
  }

  /** Returns the object with the settings used for calls to updateEnvironment. */
  public OperationCallSettings<UpdateEnvironmentRequest, Environment, OperationMetadata>
      updateEnvironmentOperationSettings() {
    return updateEnvironmentOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteEnvironment. */
  public UnaryCallSettings<DeleteEnvironmentRequest, Operation> deleteEnvironmentSettings() {
    return deleteEnvironmentSettings;
  }

  /** Returns the object with the settings used for calls to deleteEnvironment. */
  public OperationCallSettings<DeleteEnvironmentRequest, Empty, OperationMetadata>
      deleteEnvironmentOperationSettings() {
    return deleteEnvironmentOperationSettings;
  }

  /** Returns the object with the settings used for calls to restartWebServer. */
  public UnaryCallSettings<RestartWebServerRequest, Operation> restartWebServerSettings() {
    return restartWebServerSettings;
  }

  /** Returns the object with the settings used for calls to restartWebServer. */
  public OperationCallSettings<RestartWebServerRequest, Environment, OperationMetadata>
      restartWebServerOperationSettings() {
    return restartWebServerOperationSettings;
  }

  /** Returns the object with the settings used for calls to checkUpgrade. */
  public UnaryCallSettings<CheckUpgradeRequest, Operation> checkUpgradeSettings() {
    return checkUpgradeSettings;
  }

  /** Returns the object with the settings used for calls to checkUpgrade. */
  public OperationCallSettings<CheckUpgradeRequest, CheckUpgradeResponse, OperationMetadata>
      checkUpgradeOperationSettings() {
    return checkUpgradeOperationSettings;
  }

  public EnvironmentsStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcEnvironmentsStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonEnvironmentsStub.create(this);
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
    return "composer.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "composer.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(EnvironmentsStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(EnvironmentsStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return EnvironmentsStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected EnvironmentsStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createEnvironmentSettings = settingsBuilder.createEnvironmentSettings().build();
    createEnvironmentOperationSettings =
        settingsBuilder.createEnvironmentOperationSettings().build();
    getEnvironmentSettings = settingsBuilder.getEnvironmentSettings().build();
    listEnvironmentsSettings = settingsBuilder.listEnvironmentsSettings().build();
    updateEnvironmentSettings = settingsBuilder.updateEnvironmentSettings().build();
    updateEnvironmentOperationSettings =
        settingsBuilder.updateEnvironmentOperationSettings().build();
    deleteEnvironmentSettings = settingsBuilder.deleteEnvironmentSettings().build();
    deleteEnvironmentOperationSettings =
        settingsBuilder.deleteEnvironmentOperationSettings().build();
    restartWebServerSettings = settingsBuilder.restartWebServerSettings().build();
    restartWebServerOperationSettings = settingsBuilder.restartWebServerOperationSettings().build();
    checkUpgradeSettings = settingsBuilder.checkUpgradeSettings().build();
    checkUpgradeOperationSettings = settingsBuilder.checkUpgradeOperationSettings().build();
  }

  /** Builder for EnvironmentsStubSettings. */
  public static class Builder extends StubSettings.Builder<EnvironmentsStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateEnvironmentRequest, Operation>
        createEnvironmentSettings;
    private final OperationCallSettings.Builder<
            CreateEnvironmentRequest, Environment, OperationMetadata>
        createEnvironmentOperationSettings;
    private final UnaryCallSettings.Builder<GetEnvironmentRequest, Environment>
        getEnvironmentSettings;
    private final PagedCallSettings.Builder<
            ListEnvironmentsRequest, ListEnvironmentsResponse, ListEnvironmentsPagedResponse>
        listEnvironmentsSettings;
    private final UnaryCallSettings.Builder<UpdateEnvironmentRequest, Operation>
        updateEnvironmentSettings;
    private final OperationCallSettings.Builder<
            UpdateEnvironmentRequest, Environment, OperationMetadata>
        updateEnvironmentOperationSettings;
    private final UnaryCallSettings.Builder<DeleteEnvironmentRequest, Operation>
        deleteEnvironmentSettings;
    private final OperationCallSettings.Builder<DeleteEnvironmentRequest, Empty, OperationMetadata>
        deleteEnvironmentOperationSettings;
    private final UnaryCallSettings.Builder<RestartWebServerRequest, Operation>
        restartWebServerSettings;
    private final OperationCallSettings.Builder<
            RestartWebServerRequest, Environment, OperationMetadata>
        restartWebServerOperationSettings;
    private final UnaryCallSettings.Builder<CheckUpgradeRequest, Operation> checkUpgradeSettings;
    private final OperationCallSettings.Builder<
            CheckUpgradeRequest, CheckUpgradeResponse, OperationMetadata>
        checkUpgradeOperationSettings;
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

      createEnvironmentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createEnvironmentOperationSettings = OperationCallSettings.newBuilder();
      getEnvironmentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listEnvironmentsSettings = PagedCallSettings.newBuilder(LIST_ENVIRONMENTS_PAGE_STR_FACT);
      updateEnvironmentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateEnvironmentOperationSettings = OperationCallSettings.newBuilder();
      deleteEnvironmentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteEnvironmentOperationSettings = OperationCallSettings.newBuilder();
      restartWebServerSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      restartWebServerOperationSettings = OperationCallSettings.newBuilder();
      checkUpgradeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      checkUpgradeOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createEnvironmentSettings,
              getEnvironmentSettings,
              listEnvironmentsSettings,
              updateEnvironmentSettings,
              deleteEnvironmentSettings,
              restartWebServerSettings,
              checkUpgradeSettings);
      initDefaults(this);
    }

    protected Builder(EnvironmentsStubSettings settings) {
      super(settings);

      createEnvironmentSettings = settings.createEnvironmentSettings.toBuilder();
      createEnvironmentOperationSettings = settings.createEnvironmentOperationSettings.toBuilder();
      getEnvironmentSettings = settings.getEnvironmentSettings.toBuilder();
      listEnvironmentsSettings = settings.listEnvironmentsSettings.toBuilder();
      updateEnvironmentSettings = settings.updateEnvironmentSettings.toBuilder();
      updateEnvironmentOperationSettings = settings.updateEnvironmentOperationSettings.toBuilder();
      deleteEnvironmentSettings = settings.deleteEnvironmentSettings.toBuilder();
      deleteEnvironmentOperationSettings = settings.deleteEnvironmentOperationSettings.toBuilder();
      restartWebServerSettings = settings.restartWebServerSettings.toBuilder();
      restartWebServerOperationSettings = settings.restartWebServerOperationSettings.toBuilder();
      checkUpgradeSettings = settings.checkUpgradeSettings.toBuilder();
      checkUpgradeOperationSettings = settings.checkUpgradeOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createEnvironmentSettings,
              getEnvironmentSettings,
              listEnvironmentsSettings,
              updateEnvironmentSettings,
              deleteEnvironmentSettings,
              restartWebServerSettings,
              checkUpgradeSettings);
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
          .createEnvironmentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getEnvironmentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listEnvironmentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateEnvironmentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteEnvironmentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .restartWebServerSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .checkUpgradeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createEnvironmentOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateEnvironmentRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Environment.class))
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
          .updateEnvironmentOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateEnvironmentRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Environment.class))
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
          .deleteEnvironmentOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteEnvironmentRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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

      builder
          .restartWebServerOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<RestartWebServerRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Environment.class))
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
          .checkUpgradeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CheckUpgradeRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(CheckUpgradeResponse.class))
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

    /** Returns the builder for the settings used for calls to createEnvironment. */
    public UnaryCallSettings.Builder<CreateEnvironmentRequest, Operation>
        createEnvironmentSettings() {
      return createEnvironmentSettings;
    }

    /** Returns the builder for the settings used for calls to createEnvironment. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateEnvironmentRequest, Environment, OperationMetadata>
        createEnvironmentOperationSettings() {
      return createEnvironmentOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getEnvironment. */
    public UnaryCallSettings.Builder<GetEnvironmentRequest, Environment> getEnvironmentSettings() {
      return getEnvironmentSettings;
    }

    /** Returns the builder for the settings used for calls to listEnvironments. */
    public PagedCallSettings.Builder<
            ListEnvironmentsRequest, ListEnvironmentsResponse, ListEnvironmentsPagedResponse>
        listEnvironmentsSettings() {
      return listEnvironmentsSettings;
    }

    /** Returns the builder for the settings used for calls to updateEnvironment. */
    public UnaryCallSettings.Builder<UpdateEnvironmentRequest, Operation>
        updateEnvironmentSettings() {
      return updateEnvironmentSettings;
    }

    /** Returns the builder for the settings used for calls to updateEnvironment. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpdateEnvironmentRequest, Environment, OperationMetadata>
        updateEnvironmentOperationSettings() {
      return updateEnvironmentOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteEnvironment. */
    public UnaryCallSettings.Builder<DeleteEnvironmentRequest, Operation>
        deleteEnvironmentSettings() {
      return deleteEnvironmentSettings;
    }

    /** Returns the builder for the settings used for calls to deleteEnvironment. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteEnvironmentRequest, Empty, OperationMetadata>
        deleteEnvironmentOperationSettings() {
      return deleteEnvironmentOperationSettings;
    }

    /** Returns the builder for the settings used for calls to restartWebServer. */
    public UnaryCallSettings.Builder<RestartWebServerRequest, Operation>
        restartWebServerSettings() {
      return restartWebServerSettings;
    }

    /** Returns the builder for the settings used for calls to restartWebServer. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<RestartWebServerRequest, Environment, OperationMetadata>
        restartWebServerOperationSettings() {
      return restartWebServerOperationSettings;
    }

    /** Returns the builder for the settings used for calls to checkUpgrade. */
    public UnaryCallSettings.Builder<CheckUpgradeRequest, Operation> checkUpgradeSettings() {
      return checkUpgradeSettings;
    }

    /** Returns the builder for the settings used for calls to checkUpgrade. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            CheckUpgradeRequest, CheckUpgradeResponse, OperationMetadata>
        checkUpgradeOperationSettings() {
      return checkUpgradeOperationSettings;
    }

    @Override
    public EnvironmentsStubSettings build() throws IOException {
      return new EnvironmentsStubSettings(this);
    }
  }
}
