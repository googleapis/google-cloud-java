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

package com.google.cloud.retail.v2alpha.stub;

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
import com.google.cloud.retail.v2alpha.AcceptTermsRequest;
import com.google.cloud.retail.v2alpha.AlertConfig;
import com.google.cloud.retail.v2alpha.EnrollSolutionMetadata;
import com.google.cloud.retail.v2alpha.EnrollSolutionRequest;
import com.google.cloud.retail.v2alpha.EnrollSolutionResponse;
import com.google.cloud.retail.v2alpha.GetAlertConfigRequest;
import com.google.cloud.retail.v2alpha.GetLoggingConfigRequest;
import com.google.cloud.retail.v2alpha.GetProjectRequest;
import com.google.cloud.retail.v2alpha.ListEnrolledSolutionsRequest;
import com.google.cloud.retail.v2alpha.ListEnrolledSolutionsResponse;
import com.google.cloud.retail.v2alpha.LoggingConfig;
import com.google.cloud.retail.v2alpha.Project;
import com.google.cloud.retail.v2alpha.UpdateAlertConfigRequest;
import com.google.cloud.retail.v2alpha.UpdateLoggingConfigRequest;
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
 * Settings class to configure an instance of {@link ProjectServiceStub}.
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
 * <p>For example, to set the total timeout of getProject to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ProjectServiceStubSettings.Builder projectServiceSettingsBuilder =
 *     ProjectServiceStubSettings.newBuilder();
 * projectServiceSettingsBuilder
 *     .getProjectSettings()
 *     .setRetrySettings(
 *         projectServiceSettingsBuilder
 *             .getProjectSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ProjectServiceStubSettings projectServiceSettings = projectServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ProjectServiceStubSettings extends StubSettings<ProjectServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<GetProjectRequest, Project> getProjectSettings;
  private final UnaryCallSettings<AcceptTermsRequest, Project> acceptTermsSettings;
  private final UnaryCallSettings<EnrollSolutionRequest, Operation> enrollSolutionSettings;
  private final OperationCallSettings<
          EnrollSolutionRequest, EnrollSolutionResponse, EnrollSolutionMetadata>
      enrollSolutionOperationSettings;
  private final UnaryCallSettings<ListEnrolledSolutionsRequest, ListEnrolledSolutionsResponse>
      listEnrolledSolutionsSettings;
  private final UnaryCallSettings<GetLoggingConfigRequest, LoggingConfig> getLoggingConfigSettings;
  private final UnaryCallSettings<UpdateLoggingConfigRequest, LoggingConfig>
      updateLoggingConfigSettings;
  private final UnaryCallSettings<GetAlertConfigRequest, AlertConfig> getAlertConfigSettings;
  private final UnaryCallSettings<UpdateAlertConfigRequest, AlertConfig> updateAlertConfigSettings;

  /** Returns the object with the settings used for calls to getProject. */
  public UnaryCallSettings<GetProjectRequest, Project> getProjectSettings() {
    return getProjectSettings;
  }

  /** Returns the object with the settings used for calls to acceptTerms. */
  public UnaryCallSettings<AcceptTermsRequest, Project> acceptTermsSettings() {
    return acceptTermsSettings;
  }

  /** Returns the object with the settings used for calls to enrollSolution. */
  public UnaryCallSettings<EnrollSolutionRequest, Operation> enrollSolutionSettings() {
    return enrollSolutionSettings;
  }

  /** Returns the object with the settings used for calls to enrollSolution. */
  public OperationCallSettings<
          EnrollSolutionRequest, EnrollSolutionResponse, EnrollSolutionMetadata>
      enrollSolutionOperationSettings() {
    return enrollSolutionOperationSettings;
  }

  /** Returns the object with the settings used for calls to listEnrolledSolutions. */
  public UnaryCallSettings<ListEnrolledSolutionsRequest, ListEnrolledSolutionsResponse>
      listEnrolledSolutionsSettings() {
    return listEnrolledSolutionsSettings;
  }

  /** Returns the object with the settings used for calls to getLoggingConfig. */
  public UnaryCallSettings<GetLoggingConfigRequest, LoggingConfig> getLoggingConfigSettings() {
    return getLoggingConfigSettings;
  }

  /** Returns the object with the settings used for calls to updateLoggingConfig. */
  public UnaryCallSettings<UpdateLoggingConfigRequest, LoggingConfig>
      updateLoggingConfigSettings() {
    return updateLoggingConfigSettings;
  }

  /** Returns the object with the settings used for calls to getAlertConfig. */
  public UnaryCallSettings<GetAlertConfigRequest, AlertConfig> getAlertConfigSettings() {
    return getAlertConfigSettings;
  }

  /** Returns the object with the settings used for calls to updateAlertConfig. */
  public UnaryCallSettings<UpdateAlertConfigRequest, AlertConfig> updateAlertConfigSettings() {
    return updateAlertConfigSettings;
  }

  public ProjectServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcProjectServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonProjectServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "retail";
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

  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(ProjectServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(ProjectServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ProjectServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected ProjectServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getProjectSettings = settingsBuilder.getProjectSettings().build();
    acceptTermsSettings = settingsBuilder.acceptTermsSettings().build();
    enrollSolutionSettings = settingsBuilder.enrollSolutionSettings().build();
    enrollSolutionOperationSettings = settingsBuilder.enrollSolutionOperationSettings().build();
    listEnrolledSolutionsSettings = settingsBuilder.listEnrolledSolutionsSettings().build();
    getLoggingConfigSettings = settingsBuilder.getLoggingConfigSettings().build();
    updateLoggingConfigSettings = settingsBuilder.updateLoggingConfigSettings().build();
    getAlertConfigSettings = settingsBuilder.getAlertConfigSettings().build();
    updateAlertConfigSettings = settingsBuilder.updateAlertConfigSettings().build();
  }

  /** Builder for ProjectServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<ProjectServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetProjectRequest, Project> getProjectSettings;
    private final UnaryCallSettings.Builder<AcceptTermsRequest, Project> acceptTermsSettings;
    private final UnaryCallSettings.Builder<EnrollSolutionRequest, Operation>
        enrollSolutionSettings;
    private final OperationCallSettings.Builder<
            EnrollSolutionRequest, EnrollSolutionResponse, EnrollSolutionMetadata>
        enrollSolutionOperationSettings;
    private final UnaryCallSettings.Builder<
            ListEnrolledSolutionsRequest, ListEnrolledSolutionsResponse>
        listEnrolledSolutionsSettings;
    private final UnaryCallSettings.Builder<GetLoggingConfigRequest, LoggingConfig>
        getLoggingConfigSettings;
    private final UnaryCallSettings.Builder<UpdateLoggingConfigRequest, LoggingConfig>
        updateLoggingConfigSettings;
    private final UnaryCallSettings.Builder<GetAlertConfigRequest, AlertConfig>
        getAlertConfigSettings;
    private final UnaryCallSettings.Builder<UpdateAlertConfigRequest, AlertConfig>
        updateAlertConfigSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_3_codes",
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
              .setMaxRetryDelay(Duration.ofMillis(30000L))
              .setInitialRpcTimeout(Duration.ofMillis(30000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(30000L))
              .setTotalTimeout(Duration.ofMillis(30000L))
              .build();
      definitions.put("retry_policy_3_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      getProjectSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      acceptTermsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      enrollSolutionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      enrollSolutionOperationSettings = OperationCallSettings.newBuilder();
      listEnrolledSolutionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getLoggingConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateLoggingConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getAlertConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateAlertConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getProjectSettings,
              acceptTermsSettings,
              enrollSolutionSettings,
              listEnrolledSolutionsSettings,
              getLoggingConfigSettings,
              updateLoggingConfigSettings,
              getAlertConfigSettings,
              updateAlertConfigSettings);
      initDefaults(this);
    }

    protected Builder(ProjectServiceStubSettings settings) {
      super(settings);

      getProjectSettings = settings.getProjectSettings.toBuilder();
      acceptTermsSettings = settings.acceptTermsSettings.toBuilder();
      enrollSolutionSettings = settings.enrollSolutionSettings.toBuilder();
      enrollSolutionOperationSettings = settings.enrollSolutionOperationSettings.toBuilder();
      listEnrolledSolutionsSettings = settings.listEnrolledSolutionsSettings.toBuilder();
      getLoggingConfigSettings = settings.getLoggingConfigSettings.toBuilder();
      updateLoggingConfigSettings = settings.updateLoggingConfigSettings.toBuilder();
      getAlertConfigSettings = settings.getAlertConfigSettings.toBuilder();
      updateAlertConfigSettings = settings.updateAlertConfigSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getProjectSettings,
              acceptTermsSettings,
              enrollSolutionSettings,
              listEnrolledSolutionsSettings,
              getLoggingConfigSettings,
              updateLoggingConfigSettings,
              getAlertConfigSettings,
              updateAlertConfigSettings);
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
          .getProjectSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_3_params"));

      builder
          .acceptTermsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_3_params"));

      builder
          .enrollSolutionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_3_params"));

      builder
          .listEnrolledSolutionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_3_params"));

      builder
          .getLoggingConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_3_params"));

      builder
          .updateLoggingConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_3_params"));

      builder
          .getAlertConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_3_params"));

      builder
          .updateAlertConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_3_params"));

      builder
          .enrollSolutionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<EnrollSolutionRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_3_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_3_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(EnrollSolutionResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(EnrollSolutionMetadata.class))
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

    /** Returns the builder for the settings used for calls to getProject. */
    public UnaryCallSettings.Builder<GetProjectRequest, Project> getProjectSettings() {
      return getProjectSettings;
    }

    /** Returns the builder for the settings used for calls to acceptTerms. */
    public UnaryCallSettings.Builder<AcceptTermsRequest, Project> acceptTermsSettings() {
      return acceptTermsSettings;
    }

    /** Returns the builder for the settings used for calls to enrollSolution. */
    public UnaryCallSettings.Builder<EnrollSolutionRequest, Operation> enrollSolutionSettings() {
      return enrollSolutionSettings;
    }

    /** Returns the builder for the settings used for calls to enrollSolution. */
    public OperationCallSettings.Builder<
            EnrollSolutionRequest, EnrollSolutionResponse, EnrollSolutionMetadata>
        enrollSolutionOperationSettings() {
      return enrollSolutionOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listEnrolledSolutions. */
    public UnaryCallSettings.Builder<ListEnrolledSolutionsRequest, ListEnrolledSolutionsResponse>
        listEnrolledSolutionsSettings() {
      return listEnrolledSolutionsSettings;
    }

    /** Returns the builder for the settings used for calls to getLoggingConfig. */
    public UnaryCallSettings.Builder<GetLoggingConfigRequest, LoggingConfig>
        getLoggingConfigSettings() {
      return getLoggingConfigSettings;
    }

    /** Returns the builder for the settings used for calls to updateLoggingConfig. */
    public UnaryCallSettings.Builder<UpdateLoggingConfigRequest, LoggingConfig>
        updateLoggingConfigSettings() {
      return updateLoggingConfigSettings;
    }

    /** Returns the builder for the settings used for calls to getAlertConfig. */
    public UnaryCallSettings.Builder<GetAlertConfigRequest, AlertConfig> getAlertConfigSettings() {
      return getAlertConfigSettings;
    }

    /** Returns the builder for the settings used for calls to updateAlertConfig. */
    public UnaryCallSettings.Builder<UpdateAlertConfigRequest, AlertConfig>
        updateAlertConfigSettings() {
      return updateAlertConfigSettings;
    }

    @Override
    public ProjectServiceStubSettings build() throws IOException {
      return new ProjectServiceStubSettings(this);
    }
  }
}
