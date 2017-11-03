/*
 * Copyright 2017, Google Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.dlp.v2beta1;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.core.PropertiesProvider;
import com.google.api.gax.grpc.GrpcExtraHeaderData;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.grpc.ProtoOperationTransformers;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.longrunning.OperationTimedPollAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.dlp.v2beta1.stub.DlpServiceStub;
import com.google.cloud.dlp.v2beta1.stub.GrpcDlpServiceStub;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.privacy.dlp.v2beta1.AnalyzeDataSourceRiskRequest;
import com.google.privacy.dlp.v2beta1.CreateInspectOperationRequest;
import com.google.privacy.dlp.v2beta1.DeidentifyContentRequest;
import com.google.privacy.dlp.v2beta1.DeidentifyContentResponse;
import com.google.privacy.dlp.v2beta1.InspectContentRequest;
import com.google.privacy.dlp.v2beta1.InspectContentResponse;
import com.google.privacy.dlp.v2beta1.InspectOperationMetadata;
import com.google.privacy.dlp.v2beta1.InspectOperationResult;
import com.google.privacy.dlp.v2beta1.ListInfoTypesRequest;
import com.google.privacy.dlp.v2beta1.ListInfoTypesResponse;
import com.google.privacy.dlp.v2beta1.ListInspectFindingsRequest;
import com.google.privacy.dlp.v2beta1.ListInspectFindingsResponse;
import com.google.privacy.dlp.v2beta1.ListRootCategoriesRequest;
import com.google.privacy.dlp.v2beta1.ListRootCategoriesResponse;
import com.google.privacy.dlp.v2beta1.RedactContentRequest;
import com.google.privacy.dlp.v2beta1.RedactContentResponse;
import com.google.privacy.dlp.v2beta1.RiskAnalysisOperationMetadata;
import com.google.privacy.dlp.v2beta1.RiskAnalysisOperationResult;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link DlpServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (dlp.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object. For
 * example, to set the total timeout of deidentifyContent to 30 seconds:
 *
 * <pre>
 * <code>
 * DlpServiceSettings.Builder dlpServiceSettingsBuilder =
 *     DlpServiceSettings.newBuilder();
 * dlpServiceSettingsBuilder.deidentifyContentSettings().getRetrySettingsBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * DlpServiceSettings dlpServiceSettings = dlpServiceSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by GAPIC v0.0.5")
@BetaApi
public class DlpServiceSettings extends ClientSettings {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private static final String DEFAULT_GAPIC_NAME = "gapic";
  private static final String DEFAULT_GAPIC_VERSION = "";

  private static final String PROPERTIES_FILE = "/com/google/cloud/dlp/project.properties";
  private static final String META_VERSION_KEY = "artifact.version";

  private static String gapicVersion;

  private final UnaryCallSettings<DeidentifyContentRequest, DeidentifyContentResponse>
      deidentifyContentSettings;
  private final UnaryCallSettings<AnalyzeDataSourceRiskRequest, Operation>
      analyzeDataSourceRiskSettings;
  private final OperationCallSettings<
          AnalyzeDataSourceRiskRequest, RiskAnalysisOperationResult, RiskAnalysisOperationMetadata>
      analyzeDataSourceRiskOperationSettings;
  private final UnaryCallSettings<InspectContentRequest, InspectContentResponse>
      inspectContentSettings;
  private final UnaryCallSettings<RedactContentRequest, RedactContentResponse>
      redactContentSettings;
  private final UnaryCallSettings<CreateInspectOperationRequest, Operation>
      createInspectOperationSettings;
  private final OperationCallSettings<
          CreateInspectOperationRequest, InspectOperationResult, InspectOperationMetadata>
      createInspectOperationOperationSettings;
  private final UnaryCallSettings<ListInspectFindingsRequest, ListInspectFindingsResponse>
      listInspectFindingsSettings;
  private final UnaryCallSettings<ListInfoTypesRequest, ListInfoTypesResponse>
      listInfoTypesSettings;
  private final UnaryCallSettings<ListRootCategoriesRequest, ListRootCategoriesResponse>
      listRootCategoriesSettings;

  /** Returns the object with the settings used for calls to deidentifyContent. */
  public UnaryCallSettings<DeidentifyContentRequest, DeidentifyContentResponse>
      deidentifyContentSettings() {
    return deidentifyContentSettings;
  }

  /** Returns the object with the settings used for calls to analyzeDataSourceRisk. */
  public UnaryCallSettings<AnalyzeDataSourceRiskRequest, Operation>
      analyzeDataSourceRiskSettings() {
    return analyzeDataSourceRiskSettings;
  }

  /** Returns the object with the settings used for calls to analyzeDataSourceRisk. */
  public OperationCallSettings<
          AnalyzeDataSourceRiskRequest, RiskAnalysisOperationResult, RiskAnalysisOperationMetadata>
      analyzeDataSourceRiskOperationSettings() {
    return analyzeDataSourceRiskOperationSettings;
  }

  /** Returns the object with the settings used for calls to inspectContent. */
  public UnaryCallSettings<InspectContentRequest, InspectContentResponse> inspectContentSettings() {
    return inspectContentSettings;
  }

  /** Returns the object with the settings used for calls to redactContent. */
  public UnaryCallSettings<RedactContentRequest, RedactContentResponse> redactContentSettings() {
    return redactContentSettings;
  }

  /** Returns the object with the settings used for calls to createInspectOperation. */
  public UnaryCallSettings<CreateInspectOperationRequest, Operation>
      createInspectOperationSettings() {
    return createInspectOperationSettings;
  }

  /** Returns the object with the settings used for calls to createInspectOperation. */
  public OperationCallSettings<
          CreateInspectOperationRequest, InspectOperationResult, InspectOperationMetadata>
      createInspectOperationOperationSettings() {
    return createInspectOperationOperationSettings;
  }

  /** Returns the object with the settings used for calls to listInspectFindings. */
  public UnaryCallSettings<ListInspectFindingsRequest, ListInspectFindingsResponse>
      listInspectFindingsSettings() {
    return listInspectFindingsSettings;
  }

  /** Returns the object with the settings used for calls to listInfoTypes. */
  public UnaryCallSettings<ListInfoTypesRequest, ListInfoTypesResponse> listInfoTypesSettings() {
    return listInfoTypesSettings;
  }

  /** Returns the object with the settings used for calls to listRootCategories. */
  public UnaryCallSettings<ListRootCategoriesRequest, ListRootCategoriesResponse>
      listRootCategoriesSettings() {
    return listRootCategoriesSettings;
  }

  public DlpServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcDlpServiceStub.create(this);
    } else {
      throw new UnsupportedOperationException(
          "Transport not supported: " + getTransportChannelProvider().getTransportName());
    }
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "dlp.googleapis.com:443";
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
    return InstantiatingGrpcChannelProvider.newBuilder().setEndpoint(getDefaultEndpoint());
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratorHeader(DEFAULT_GAPIC_NAME, getGapicVersion())
        .setApiClientHeaderLineKey("x-goog-api-client")
        .addApiClientHeaderLineData(GrpcExtraHeaderData.getXGoogApiClientData());
  }

  private static String getGapicVersion() {
    if (gapicVersion == null) {
      gapicVersion =
          PropertiesProvider.loadProperty(
              DlpServiceSettings.class, PROPERTIES_FILE, META_VERSION_KEY);
      gapicVersion = gapicVersion == null ? DEFAULT_GAPIC_VERSION : gapicVersion;
    }
    return gapicVersion;
  }

  /** Returns a builder for this class with recommended defaults. */
  @Deprecated
  public static Builder defaultBuilder() {
    return Builder.createDefault();
  }

  /**
   * Returns a builder for this class with recommended defaults for API methods, and the given
   * ClientContext used for executor/transport/credentials.
   */
  @Deprecated
  public static Builder defaultBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
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

  private DlpServiceSettings(Builder settingsBuilder) throws IOException {
    super(
        settingsBuilder.getExecutorProvider(),
        settingsBuilder.getTransportChannelProvider(),
        settingsBuilder.getCredentialsProvider(),
        settingsBuilder.getHeaderProvider(),
        settingsBuilder.getClock());

    deidentifyContentSettings = settingsBuilder.deidentifyContentSettings().build();
    analyzeDataSourceRiskSettings = settingsBuilder.analyzeDataSourceRiskSettings().build();
    analyzeDataSourceRiskOperationSettings =
        settingsBuilder.analyzeDataSourceRiskOperationSettings().build();
    inspectContentSettings = settingsBuilder.inspectContentSettings().build();
    redactContentSettings = settingsBuilder.redactContentSettings().build();
    createInspectOperationSettings = settingsBuilder.createInspectOperationSettings().build();
    createInspectOperationOperationSettings =
        settingsBuilder.createInspectOperationOperationSettings().build();
    listInspectFindingsSettings = settingsBuilder.listInspectFindingsSettings().build();
    listInfoTypesSettings = settingsBuilder.listInfoTypesSettings().build();
    listRootCategoriesSettings = settingsBuilder.listRootCategoriesSettings().build();
  }

  /** Builder for DlpServiceSettings. */
  public static class Builder extends ClientSettings.Builder {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final UnaryCallSettings.Builder<DeidentifyContentRequest, DeidentifyContentResponse>
        deidentifyContentSettings;
    private final UnaryCallSettings.Builder<AnalyzeDataSourceRiskRequest, Operation>
        analyzeDataSourceRiskSettings;
    private final OperationCallSettings.Builder<
            AnalyzeDataSourceRiskRequest, RiskAnalysisOperationResult,
            RiskAnalysisOperationMetadata>
        analyzeDataSourceRiskOperationSettings;
    private final UnaryCallSettings.Builder<InspectContentRequest, InspectContentResponse>
        inspectContentSettings;
    private final UnaryCallSettings.Builder<RedactContentRequest, RedactContentResponse>
        redactContentSettings;
    private final UnaryCallSettings.Builder<CreateInspectOperationRequest, Operation>
        createInspectOperationSettings;
    private final OperationCallSettings.Builder<
            CreateInspectOperationRequest, InspectOperationResult, InspectOperationMetadata>
        createInspectOperationOperationSettings;
    private final UnaryCallSettings.Builder<ListInspectFindingsRequest, ListInspectFindingsResponse>
        listInspectFindingsSettings;
    private final UnaryCallSettings.Builder<ListInfoTypesRequest, ListInfoTypesResponse>
        listInfoTypesSettings;
    private final UnaryCallSettings.Builder<ListRootCategoriesRequest, ListRootCategoriesResponse>
        listRootCategoriesSettings;

    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "idempotent",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
      definitions.put("non_idempotent", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
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
              .setInitialRpcTimeout(Duration.ofMillis(20000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(20000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("default", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    private Builder() {
      this((ClientContext) null);
    }

    private Builder(ClientContext clientContext) {
      super(clientContext);

      deidentifyContentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      analyzeDataSourceRiskSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      analyzeDataSourceRiskOperationSettings = OperationCallSettings.newBuilder();

      inspectContentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      redactContentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      createInspectOperationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      createInspectOperationOperationSettings = OperationCallSettings.newBuilder();

      listInspectFindingsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listInfoTypesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listRootCategoriesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              deidentifyContentSettings,
              analyzeDataSourceRiskSettings,
              inspectContentSettings,
              redactContentSettings,
              createInspectOperationSettings,
              listInspectFindingsSettings,
              listInfoTypesSettings,
              listRootCategoriesSettings);

      initDefaults(this);
    }

    private static Builder createDefault() {
      Builder builder = new Builder((ClientContext) null);
      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {

      builder
          .deidentifyContentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .analyzeDataSourceRiskSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .inspectContentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .redactContentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .createInspectOperationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listInspectFindingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listInfoTypesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listRootCategoriesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));
      builder
          .analyzeDataSourceRiskOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<AnalyzeDataSourceRiskRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  RiskAnalysisOperationResult.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  RiskAnalysisOperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(20000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO) // ignored
                      .setRpcTimeoutMultiplier(1.0) // ignored
                      .setMaxRpcTimeout(Duration.ZERO) // ignored
                      .setTotalTimeout(Duration.ofMillis(86400000L))
                      .build()));
      builder
          .createInspectOperationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateInspectOperationRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(InspectOperationResult.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(InspectOperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(20000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO) // ignored
                      .setRpcTimeoutMultiplier(1.0) // ignored
                      .setMaxRpcTimeout(Duration.ZERO) // ignored
                      .setTotalTimeout(Duration.ofMillis(86400000L))
                      .build()));

      return builder;
    }

    private Builder(DlpServiceSettings settings) {
      super(settings);

      deidentifyContentSettings = settings.deidentifyContentSettings.toBuilder();
      analyzeDataSourceRiskSettings = settings.analyzeDataSourceRiskSettings.toBuilder();
      analyzeDataSourceRiskOperationSettings =
          settings.analyzeDataSourceRiskOperationSettings.toBuilder();
      inspectContentSettings = settings.inspectContentSettings.toBuilder();
      redactContentSettings = settings.redactContentSettings.toBuilder();
      createInspectOperationSettings = settings.createInspectOperationSettings.toBuilder();
      createInspectOperationOperationSettings =
          settings.createInspectOperationOperationSettings.toBuilder();
      listInspectFindingsSettings = settings.listInspectFindingsSettings.toBuilder();
      listInfoTypesSettings = settings.listInfoTypesSettings.toBuilder();
      listRootCategoriesSettings = settings.listRootCategoriesSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              deidentifyContentSettings,
              analyzeDataSourceRiskSettings,
              inspectContentSettings,
              redactContentSettings,
              createInspectOperationSettings,
              listInspectFindingsSettings,
              listInfoTypesSettings,
              listRootCategoriesSettings);
    }

    @Override
    public Builder setExecutorProvider(ExecutorProvider executorProvider) {
      super.setExecutorProvider(executorProvider);
      return this;
    }

    @Override
    public Builder setTransportChannelProvider(TransportChannelProvider transportProvider) {
      super.setTransportChannelProvider(transportProvider);
      return this;
    }

    @Override
    public Builder setHeaderProvider(HeaderProvider headerProvider) {
      super.setHeaderProvider(headerProvider);
      return this;
    }

    @Override
    public Builder setCredentialsProvider(CredentialsProvider credentialsProvider) {
      super.setCredentialsProvider(credentialsProvider);
      return this;
    }

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

    /** Returns the builder for the settings used for calls to deidentifyContent. */
    public UnaryCallSettings.Builder<DeidentifyContentRequest, DeidentifyContentResponse>
        deidentifyContentSettings() {
      return deidentifyContentSettings;
    }

    /** Returns the builder for the settings used for calls to analyzeDataSourceRisk. */
    public UnaryCallSettings.Builder<AnalyzeDataSourceRiskRequest, Operation>
        analyzeDataSourceRiskSettings() {
      return analyzeDataSourceRiskSettings;
    }

    /** Returns the builder for the settings used for calls to analyzeDataSourceRisk. */
    public OperationCallSettings.Builder<
            AnalyzeDataSourceRiskRequest, RiskAnalysisOperationResult,
            RiskAnalysisOperationMetadata>
        analyzeDataSourceRiskOperationSettings() {
      return analyzeDataSourceRiskOperationSettings;
    }

    /** Returns the builder for the settings used for calls to inspectContent. */
    public UnaryCallSettings.Builder<InspectContentRequest, InspectContentResponse>
        inspectContentSettings() {
      return inspectContentSettings;
    }

    /** Returns the builder for the settings used for calls to redactContent. */
    public UnaryCallSettings.Builder<RedactContentRequest, RedactContentResponse>
        redactContentSettings() {
      return redactContentSettings;
    }

    /** Returns the builder for the settings used for calls to createInspectOperation. */
    public UnaryCallSettings.Builder<CreateInspectOperationRequest, Operation>
        createInspectOperationSettings() {
      return createInspectOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createInspectOperation. */
    public OperationCallSettings.Builder<
            CreateInspectOperationRequest, InspectOperationResult, InspectOperationMetadata>
        createInspectOperationOperationSettings() {
      return createInspectOperationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listInspectFindings. */
    public UnaryCallSettings.Builder<ListInspectFindingsRequest, ListInspectFindingsResponse>
        listInspectFindingsSettings() {
      return listInspectFindingsSettings;
    }

    /** Returns the builder for the settings used for calls to listInfoTypes. */
    public UnaryCallSettings.Builder<ListInfoTypesRequest, ListInfoTypesResponse>
        listInfoTypesSettings() {
      return listInfoTypesSettings;
    }

    /** Returns the builder for the settings used for calls to listRootCategories. */
    public UnaryCallSettings.Builder<ListRootCategoriesRequest, ListRootCategoriesResponse>
        listRootCategoriesSettings() {
      return listRootCategoriesSettings;
    }

    @Override
    public DlpServiceSettings build() throws IOException {
      return new DlpServiceSettings(this);
    }
  }
}
