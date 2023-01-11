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

package com.google.cloud.language.v1.stub;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.language.v1.AnalyzeEntitiesRequest;
import com.google.cloud.language.v1.AnalyzeEntitiesResponse;
import com.google.cloud.language.v1.AnalyzeEntitySentimentRequest;
import com.google.cloud.language.v1.AnalyzeEntitySentimentResponse;
import com.google.cloud.language.v1.AnalyzeSentimentRequest;
import com.google.cloud.language.v1.AnalyzeSentimentResponse;
import com.google.cloud.language.v1.AnalyzeSyntaxRequest;
import com.google.cloud.language.v1.AnalyzeSyntaxResponse;
import com.google.cloud.language.v1.AnnotateTextRequest;
import com.google.cloud.language.v1.AnnotateTextResponse;
import com.google.cloud.language.v1.ClassifyTextRequest;
import com.google.cloud.language.v1.ClassifyTextResponse;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link LanguageServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (language.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of analyzeSentiment to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * LanguageServiceStubSettings.Builder languageServiceSettingsBuilder =
 *     LanguageServiceStubSettings.newBuilder();
 * languageServiceSettingsBuilder
 *     .analyzeSentimentSettings()
 *     .setRetrySettings(
 *         languageServiceSettingsBuilder
 *             .analyzeSentimentSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * LanguageServiceStubSettings languageServiceSettings = languageServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class LanguageServiceStubSettings extends StubSettings<LanguageServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-language")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .build();

  private final UnaryCallSettings<AnalyzeSentimentRequest, AnalyzeSentimentResponse>
      analyzeSentimentSettings;
  private final UnaryCallSettings<AnalyzeEntitiesRequest, AnalyzeEntitiesResponse>
      analyzeEntitiesSettings;
  private final UnaryCallSettings<AnalyzeEntitySentimentRequest, AnalyzeEntitySentimentResponse>
      analyzeEntitySentimentSettings;
  private final UnaryCallSettings<AnalyzeSyntaxRequest, AnalyzeSyntaxResponse>
      analyzeSyntaxSettings;
  private final UnaryCallSettings<ClassifyTextRequest, ClassifyTextResponse> classifyTextSettings;
  private final UnaryCallSettings<AnnotateTextRequest, AnnotateTextResponse> annotateTextSettings;

  /** Returns the object with the settings used for calls to analyzeSentiment. */
  public UnaryCallSettings<AnalyzeSentimentRequest, AnalyzeSentimentResponse>
      analyzeSentimentSettings() {
    return analyzeSentimentSettings;
  }

  /** Returns the object with the settings used for calls to analyzeEntities. */
  public UnaryCallSettings<AnalyzeEntitiesRequest, AnalyzeEntitiesResponse>
      analyzeEntitiesSettings() {
    return analyzeEntitiesSettings;
  }

  /** Returns the object with the settings used for calls to analyzeEntitySentiment. */
  public UnaryCallSettings<AnalyzeEntitySentimentRequest, AnalyzeEntitySentimentResponse>
      analyzeEntitySentimentSettings() {
    return analyzeEntitySentimentSettings;
  }

  /** Returns the object with the settings used for calls to analyzeSyntax. */
  public UnaryCallSettings<AnalyzeSyntaxRequest, AnalyzeSyntaxResponse> analyzeSyntaxSettings() {
    return analyzeSyntaxSettings;
  }

  /** Returns the object with the settings used for calls to classifyText. */
  public UnaryCallSettings<ClassifyTextRequest, ClassifyTextResponse> classifyTextSettings() {
    return classifyTextSettings;
  }

  /** Returns the object with the settings used for calls to annotateText. */
  public UnaryCallSettings<AnnotateTextRequest, AnnotateTextResponse> annotateTextSettings() {
    return annotateTextSettings;
  }

  public LanguageServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcLanguageServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonLanguageServiceStub.create(this);
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
    return "language.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "language.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(LanguageServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(LanguageServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return LanguageServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected LanguageServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    analyzeSentimentSettings = settingsBuilder.analyzeSentimentSettings().build();
    analyzeEntitiesSettings = settingsBuilder.analyzeEntitiesSettings().build();
    analyzeEntitySentimentSettings = settingsBuilder.analyzeEntitySentimentSettings().build();
    analyzeSyntaxSettings = settingsBuilder.analyzeSyntaxSettings().build();
    classifyTextSettings = settingsBuilder.classifyTextSettings().build();
    annotateTextSettings = settingsBuilder.annotateTextSettings().build();
  }

  /** Builder for LanguageServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<LanguageServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<AnalyzeSentimentRequest, AnalyzeSentimentResponse>
        analyzeSentimentSettings;
    private final UnaryCallSettings.Builder<AnalyzeEntitiesRequest, AnalyzeEntitiesResponse>
        analyzeEntitiesSettings;
    private final UnaryCallSettings.Builder<
            AnalyzeEntitySentimentRequest, AnalyzeEntitySentimentResponse>
        analyzeEntitySentimentSettings;
    private final UnaryCallSettings.Builder<AnalyzeSyntaxRequest, AnalyzeSyntaxResponse>
        analyzeSyntaxSettings;
    private final UnaryCallSettings.Builder<ClassifyTextRequest, ClassifyTextResponse>
        classifyTextSettings;
    private final UnaryCallSettings.Builder<AnnotateTextRequest, AnnotateTextResponse>
        annotateTextSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
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
              .setInitialRpcTimeout(Duration.ofMillis(600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(600000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      analyzeSentimentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      analyzeEntitiesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      analyzeEntitySentimentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      analyzeSyntaxSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      classifyTextSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      annotateTextSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              analyzeSentimentSettings,
              analyzeEntitiesSettings,
              analyzeEntitySentimentSettings,
              analyzeSyntaxSettings,
              classifyTextSettings,
              annotateTextSettings);
      initDefaults(this);
    }

    protected Builder(LanguageServiceStubSettings settings) {
      super(settings);

      analyzeSentimentSettings = settings.analyzeSentimentSettings.toBuilder();
      analyzeEntitiesSettings = settings.analyzeEntitiesSettings.toBuilder();
      analyzeEntitySentimentSettings = settings.analyzeEntitySentimentSettings.toBuilder();
      analyzeSyntaxSettings = settings.analyzeSyntaxSettings.toBuilder();
      classifyTextSettings = settings.classifyTextSettings.toBuilder();
      annotateTextSettings = settings.annotateTextSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              analyzeSentimentSettings,
              analyzeEntitiesSettings,
              analyzeEntitySentimentSettings,
              analyzeSyntaxSettings,
              classifyTextSettings,
              annotateTextSettings);
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
          .analyzeSentimentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .analyzeEntitiesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .analyzeEntitySentimentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .analyzeSyntaxSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .classifyTextSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .annotateTextSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

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

    /** Returns the builder for the settings used for calls to analyzeSentiment. */
    public UnaryCallSettings.Builder<AnalyzeSentimentRequest, AnalyzeSentimentResponse>
        analyzeSentimentSettings() {
      return analyzeSentimentSettings;
    }

    /** Returns the builder for the settings used for calls to analyzeEntities. */
    public UnaryCallSettings.Builder<AnalyzeEntitiesRequest, AnalyzeEntitiesResponse>
        analyzeEntitiesSettings() {
      return analyzeEntitiesSettings;
    }

    /** Returns the builder for the settings used for calls to analyzeEntitySentiment. */
    public UnaryCallSettings.Builder<AnalyzeEntitySentimentRequest, AnalyzeEntitySentimentResponse>
        analyzeEntitySentimentSettings() {
      return analyzeEntitySentimentSettings;
    }

    /** Returns the builder for the settings used for calls to analyzeSyntax. */
    public UnaryCallSettings.Builder<AnalyzeSyntaxRequest, AnalyzeSyntaxResponse>
        analyzeSyntaxSettings() {
      return analyzeSyntaxSettings;
    }

    /** Returns the builder for the settings used for calls to classifyText. */
    public UnaryCallSettings.Builder<ClassifyTextRequest, ClassifyTextResponse>
        classifyTextSettings() {
      return classifyTextSettings;
    }

    /** Returns the builder for the settings used for calls to annotateText. */
    public UnaryCallSettings.Builder<AnnotateTextRequest, AnnotateTextResponse>
        annotateTextSettings() {
      return annotateTextSettings;
    }

    @Override
    public LanguageServiceStubSettings build() throws IOException {
      return new LanguageServiceStubSettings(this);
    }
  }
}
