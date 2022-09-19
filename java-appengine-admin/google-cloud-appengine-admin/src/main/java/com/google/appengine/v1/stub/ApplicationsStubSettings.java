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

package com.google.appengine.v1.stub;

import com.google.api.core.ApiFunction;
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
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.appengine.v1.Application;
import com.google.appengine.v1.CreateApplicationRequest;
import com.google.appengine.v1.GetApplicationRequest;
import com.google.appengine.v1.OperationMetadataV1;
import com.google.appengine.v1.RepairApplicationRequest;
import com.google.appengine.v1.UpdateApplicationRequest;
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
 * Settings class to configure an instance of {@link ApplicationsStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (appengine.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getApplication to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ApplicationsStubSettings.Builder applicationsSettingsBuilder =
 *     ApplicationsStubSettings.newBuilder();
 * applicationsSettingsBuilder
 *     .getApplicationSettings()
 *     .setRetrySettings(
 *         applicationsSettingsBuilder.getApplicationSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ApplicationsStubSettings applicationsSettings = applicationsSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class ApplicationsStubSettings extends StubSettings<ApplicationsStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/appengine.admin")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/cloud-platform.read-only")
          .build();

  private final UnaryCallSettings<GetApplicationRequest, Application> getApplicationSettings;
  private final UnaryCallSettings<CreateApplicationRequest, Operation> createApplicationSettings;
  private final OperationCallSettings<CreateApplicationRequest, Application, OperationMetadataV1>
      createApplicationOperationSettings;
  private final UnaryCallSettings<UpdateApplicationRequest, Operation> updateApplicationSettings;
  private final OperationCallSettings<UpdateApplicationRequest, Application, OperationMetadataV1>
      updateApplicationOperationSettings;
  private final UnaryCallSettings<RepairApplicationRequest, Operation> repairApplicationSettings;
  private final OperationCallSettings<RepairApplicationRequest, Application, OperationMetadataV1>
      repairApplicationOperationSettings;

  /** Returns the object with the settings used for calls to getApplication. */
  public UnaryCallSettings<GetApplicationRequest, Application> getApplicationSettings() {
    return getApplicationSettings;
  }

  /** Returns the object with the settings used for calls to createApplication. */
  public UnaryCallSettings<CreateApplicationRequest, Operation> createApplicationSettings() {
    return createApplicationSettings;
  }

  /** Returns the object with the settings used for calls to createApplication. */
  public OperationCallSettings<CreateApplicationRequest, Application, OperationMetadataV1>
      createApplicationOperationSettings() {
    return createApplicationOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateApplication. */
  public UnaryCallSettings<UpdateApplicationRequest, Operation> updateApplicationSettings() {
    return updateApplicationSettings;
  }

  /** Returns the object with the settings used for calls to updateApplication. */
  public OperationCallSettings<UpdateApplicationRequest, Application, OperationMetadataV1>
      updateApplicationOperationSettings() {
    return updateApplicationOperationSettings;
  }

  /** Returns the object with the settings used for calls to repairApplication. */
  public UnaryCallSettings<RepairApplicationRequest, Operation> repairApplicationSettings() {
    return repairApplicationSettings;
  }

  /** Returns the object with the settings used for calls to repairApplication. */
  public OperationCallSettings<RepairApplicationRequest, Application, OperationMetadataV1>
      repairApplicationOperationSettings() {
    return repairApplicationOperationSettings;
  }

  public ApplicationsStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcApplicationsStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonApplicationsStub.create(this);
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
    return "appengine.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "appengine.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(ApplicationsStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(ApplicationsStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApplicationsStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected ApplicationsStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getApplicationSettings = settingsBuilder.getApplicationSettings().build();
    createApplicationSettings = settingsBuilder.createApplicationSettings().build();
    createApplicationOperationSettings =
        settingsBuilder.createApplicationOperationSettings().build();
    updateApplicationSettings = settingsBuilder.updateApplicationSettings().build();
    updateApplicationOperationSettings =
        settingsBuilder.updateApplicationOperationSettings().build();
    repairApplicationSettings = settingsBuilder.repairApplicationSettings().build();
    repairApplicationOperationSettings =
        settingsBuilder.repairApplicationOperationSettings().build();
  }

  /** Builder for ApplicationsStubSettings. */
  public static class Builder extends StubSettings.Builder<ApplicationsStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetApplicationRequest, Application>
        getApplicationSettings;
    private final UnaryCallSettings.Builder<CreateApplicationRequest, Operation>
        createApplicationSettings;
    private final OperationCallSettings.Builder<
            CreateApplicationRequest, Application, OperationMetadataV1>
        createApplicationOperationSettings;
    private final UnaryCallSettings.Builder<UpdateApplicationRequest, Operation>
        updateApplicationSettings;
    private final OperationCallSettings.Builder<
            UpdateApplicationRequest, Application, OperationMetadataV1>
        updateApplicationOperationSettings;
    private final UnaryCallSettings.Builder<RepairApplicationRequest, Operation>
        repairApplicationSettings;
    private final OperationCallSettings.Builder<
            RepairApplicationRequest, Application, OperationMetadataV1>
        repairApplicationOperationSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_0_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      getApplicationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createApplicationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createApplicationOperationSettings = OperationCallSettings.newBuilder();
      updateApplicationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateApplicationOperationSettings = OperationCallSettings.newBuilder();
      repairApplicationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      repairApplicationOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getApplicationSettings,
              createApplicationSettings,
              updateApplicationSettings,
              repairApplicationSettings);
      initDefaults(this);
    }

    protected Builder(ApplicationsStubSettings settings) {
      super(settings);

      getApplicationSettings = settings.getApplicationSettings.toBuilder();
      createApplicationSettings = settings.createApplicationSettings.toBuilder();
      createApplicationOperationSettings = settings.createApplicationOperationSettings.toBuilder();
      updateApplicationSettings = settings.updateApplicationSettings.toBuilder();
      updateApplicationOperationSettings = settings.updateApplicationOperationSettings.toBuilder();
      repairApplicationSettings = settings.repairApplicationSettings.toBuilder();
      repairApplicationOperationSettings = settings.repairApplicationOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getApplicationSettings,
              createApplicationSettings,
              updateApplicationSettings,
              repairApplicationSettings);
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
          .getApplicationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createApplicationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateApplicationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .repairApplicationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createApplicationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateApplicationRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Application.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadataV1.class))
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
          .updateApplicationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateApplicationRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Application.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadataV1.class))
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
          .repairApplicationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<RepairApplicationRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Application.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadataV1.class))
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

    /** Returns the builder for the settings used for calls to getApplication. */
    public UnaryCallSettings.Builder<GetApplicationRequest, Application> getApplicationSettings() {
      return getApplicationSettings;
    }

    /** Returns the builder for the settings used for calls to createApplication. */
    public UnaryCallSettings.Builder<CreateApplicationRequest, Operation>
        createApplicationSettings() {
      return createApplicationSettings;
    }

    /** Returns the builder for the settings used for calls to createApplication. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateApplicationRequest, Application, OperationMetadataV1>
        createApplicationOperationSettings() {
      return createApplicationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateApplication. */
    public UnaryCallSettings.Builder<UpdateApplicationRequest, Operation>
        updateApplicationSettings() {
      return updateApplicationSettings;
    }

    /** Returns the builder for the settings used for calls to updateApplication. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpdateApplicationRequest, Application, OperationMetadataV1>
        updateApplicationOperationSettings() {
      return updateApplicationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to repairApplication. */
    public UnaryCallSettings.Builder<RepairApplicationRequest, Operation>
        repairApplicationSettings() {
      return repairApplicationSettings;
    }

    /** Returns the builder for the settings used for calls to repairApplication. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<RepairApplicationRequest, Application, OperationMetadataV1>
        repairApplicationOperationSettings() {
      return repairApplicationOperationSettings;
    }

    @Override
    public ApplicationsStubSettings build() throws IOException {
      return new ApplicationsStubSettings(this);
    }
  }
}
