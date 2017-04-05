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
package com.google.cloud.language.spi.v1;

import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.PropertiesProvider;
import com.google.api.gax.core.RetrySettings;
import com.google.api.gax.grpc.ChannelProvider;
import com.google.api.gax.grpc.ClientSettings;
import com.google.api.gax.grpc.ExecutorProvider;
import com.google.api.gax.grpc.InstantiatingChannelProvider;
import com.google.api.gax.grpc.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.SimpleCallSettings;
import com.google.api.gax.grpc.UnaryCallSettings;
import com.google.cloud.language.v1.AnalyzeEntitiesRequest;
import com.google.cloud.language.v1.AnalyzeEntitiesResponse;
import com.google.cloud.language.v1.AnalyzeSentimentRequest;
import com.google.cloud.language.v1.AnalyzeSentimentResponse;
import com.google.cloud.language.v1.AnalyzeSyntaxRequest;
import com.google.cloud.language.v1.AnalyzeSyntaxResponse;
import com.google.cloud.language.v1.AnnotateTextRequest;
import com.google.cloud.language.v1.AnnotateTextResponse;
import com.google.cloud.language.v1.LanguageServiceGrpc;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.protobuf.ExperimentalApi;
import io.grpc.Status;
import java.io.IOException;
import javax.annotation.Generated;
import org.joda.time.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link LanguageServiceClient}.
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
 * build() is called, the tree of builders is called to create the complete settings object. For
 * example, to set the total timeout of analyzeSentiment to 30 seconds:
 *
 * <pre>
 * <code>
 * LanguageServiceSettings.Builder languageServiceSettingsBuilder =
 *     LanguageServiceSettings.defaultBuilder();
 * languageServiceSettingsBuilder.analyzeSentimentSettings().getRetrySettingsBuilder()
 *     .setTotalTimeout(Duration.standardSeconds(30));
 * LanguageServiceSettings languageServiceSettings = languageServiceSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by GAPIC v0.0.5")
@ExperimentalApi
public class LanguageServiceSettings extends ClientSettings {
  /** The default address of the service. */
  private static final String DEFAULT_SERVICE_ADDRESS = "language.googleapis.com";

  /** The default port of the service. */
  private static final int DEFAULT_SERVICE_PORT = 443;

  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private static final String DEFAULT_GAPIC_NAME = "gapic";
  private static final String DEFAULT_GAPIC_VERSION = "";

  private static final String PROPERTIES_FILE = "/project.properties";
  private static final String META_VERSION_KEY = "artifact.version";

  private static String gapicVersion;

  private final SimpleCallSettings<AnalyzeSentimentRequest, AnalyzeSentimentResponse>
      analyzeSentimentSettings;
  private final SimpleCallSettings<AnalyzeEntitiesRequest, AnalyzeEntitiesResponse>
      analyzeEntitiesSettings;
  private final SimpleCallSettings<AnalyzeSyntaxRequest, AnalyzeSyntaxResponse>
      analyzeSyntaxSettings;
  private final SimpleCallSettings<AnnotateTextRequest, AnnotateTextResponse> annotateTextSettings;

  /** Returns the object with the settings used for calls to analyzeSentiment. */
  public SimpleCallSettings<AnalyzeSentimentRequest, AnalyzeSentimentResponse>
      analyzeSentimentSettings() {
    return analyzeSentimentSettings;
  }

  /** Returns the object with the settings used for calls to analyzeEntities. */
  public SimpleCallSettings<AnalyzeEntitiesRequest, AnalyzeEntitiesResponse>
      analyzeEntitiesSettings() {
    return analyzeEntitiesSettings;
  }

  /** Returns the object with the settings used for calls to analyzeSyntax. */
  public SimpleCallSettings<AnalyzeSyntaxRequest, AnalyzeSyntaxResponse> analyzeSyntaxSettings() {
    return analyzeSyntaxSettings;
  }

  /** Returns the object with the settings used for calls to annotateText. */
  public SimpleCallSettings<AnnotateTextRequest, AnnotateTextResponse> annotateTextSettings() {
    return annotateTextSettings;
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service address. */
  public static String getDefaultServiceAddress() {
    return DEFAULT_SERVICE_ADDRESS;
  }

  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return DEFAULT_SERVICE_PORT;
  }

  /** Returns the default service scopes. */
  public static ImmutableList<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder().setScopesToApply(DEFAULT_SERVICE_SCOPES);
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingChannelProvider.Builder defaultChannelProviderBuilder() {
    return InstantiatingChannelProvider.newBuilder()
        .setServiceAddress(DEFAULT_SERVICE_ADDRESS)
        .setPort(DEFAULT_SERVICE_PORT)
        .setGeneratorHeader(DEFAULT_GAPIC_NAME, getGapicVersion())
        .setCredentialsProvider(defaultCredentialsProviderBuilder().build());
  }

  private static String getGapicVersion() {
    if (gapicVersion == null) {
      gapicVersion =
          PropertiesProvider.loadProperty(
              LanguageServiceSettings.class, PROPERTIES_FILE, META_VERSION_KEY);
      gapicVersion = gapicVersion == null ? DEFAULT_GAPIC_VERSION : gapicVersion;
    }
    return gapicVersion;
  }

  /** Returns a builder for this class with recommended defaults. */
  public static Builder defaultBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder() {
    return new Builder();
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  private LanguageServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder.getExecutorProvider(), settingsBuilder.getChannelProvider());

    analyzeSentimentSettings = settingsBuilder.analyzeSentimentSettings().build();
    analyzeEntitiesSettings = settingsBuilder.analyzeEntitiesSettings().build();
    analyzeSyntaxSettings = settingsBuilder.analyzeSyntaxSettings().build();
    annotateTextSettings = settingsBuilder.annotateTextSettings().build();
  }

  /** Builder for LanguageServiceSettings. */
  public static class Builder extends ClientSettings.Builder {
    private final ImmutableList<UnaryCallSettings.Builder> unaryMethodSettingsBuilders;

    private final SimpleCallSettings.Builder<AnalyzeSentimentRequest, AnalyzeSentimentResponse>
        analyzeSentimentSettings;
    private final SimpleCallSettings.Builder<AnalyzeEntitiesRequest, AnalyzeEntitiesResponse>
        analyzeEntitiesSettings;
    private final SimpleCallSettings.Builder<AnalyzeSyntaxRequest, AnalyzeSyntaxResponse>
        analyzeSyntaxSettings;
    private final SimpleCallSettings.Builder<AnnotateTextRequest, AnnotateTextResponse>
        annotateTextSettings;

    private static final ImmutableMap<String, ImmutableSet<Status.Code>> RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<Status.Code>> definitions = ImmutableMap.builder();
      definitions.put(
          "idempotent",
          Sets.immutableEnumSet(
              Lists.<Status.Code>newArrayList(
                  Status.Code.DEADLINE_EXCEEDED, Status.Code.UNAVAILABLE)));
      definitions.put(
          "non_idempotent",
          Sets.immutableEnumSet(Lists.<Status.Code>newArrayList(Status.Code.UNAVAILABLE)));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings.Builder> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings.Builder> definitions = ImmutableMap.builder();
      RetrySettings.Builder settingsBuilder = null;
      settingsBuilder =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.millis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.millis(60000L))
              .setInitialRpcTimeout(Duration.millis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.millis(60000L))
              .setTotalTimeout(Duration.millis(600000L));
      definitions.put("default", settingsBuilder);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    private Builder() {
      super(defaultChannelProviderBuilder().build());

      analyzeSentimentSettings =
          SimpleCallSettings.newBuilder(LanguageServiceGrpc.METHOD_ANALYZE_SENTIMENT);

      analyzeEntitiesSettings =
          SimpleCallSettings.newBuilder(LanguageServiceGrpc.METHOD_ANALYZE_ENTITIES);

      analyzeSyntaxSettings =
          SimpleCallSettings.newBuilder(LanguageServiceGrpc.METHOD_ANALYZE_SYNTAX);

      annotateTextSettings =
          SimpleCallSettings.newBuilder(LanguageServiceGrpc.METHOD_ANNOTATE_TEXT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder>of(
              analyzeSentimentSettings,
              analyzeEntitiesSettings,
              analyzeSyntaxSettings,
              annotateTextSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder();

      builder
          .analyzeSentimentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .analyzeEntitiesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .analyzeSyntaxSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .annotateTextSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    private Builder(LanguageServiceSettings settings) {
      super(settings);

      analyzeSentimentSettings = settings.analyzeSentimentSettings.toBuilder();
      analyzeEntitiesSettings = settings.analyzeEntitiesSettings.toBuilder();
      analyzeSyntaxSettings = settings.analyzeSyntaxSettings.toBuilder();
      annotateTextSettings = settings.annotateTextSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder>of(
              analyzeSentimentSettings,
              analyzeEntitiesSettings,
              analyzeSyntaxSettings,
              annotateTextSettings);
    }

    @Override
    public Builder setExecutorProvider(ExecutorProvider executorProvider) {
      super.setExecutorProvider(executorProvider);
      return this;
    }

    @Override
    public Builder setChannelProvider(ChannelProvider channelProvider) {
      super.setChannelProvider(channelProvider);
      return this;
    }

    /**
     * Applies the given settings to all of the unary API methods in this service. Only values that
     * are non-null will be applied, so this method is not capable of un-setting any values.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(UnaryCallSettings.Builder unaryCallSettings)
        throws Exception {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, unaryCallSettings);
      return this;
    }

    /** Returns the builder for the settings used for calls to analyzeSentiment. */
    public SimpleCallSettings.Builder<AnalyzeSentimentRequest, AnalyzeSentimentResponse>
        analyzeSentimentSettings() {
      return analyzeSentimentSettings;
    }

    /** Returns the builder for the settings used for calls to analyzeEntities. */
    public SimpleCallSettings.Builder<AnalyzeEntitiesRequest, AnalyzeEntitiesResponse>
        analyzeEntitiesSettings() {
      return analyzeEntitiesSettings;
    }

    /** Returns the builder for the settings used for calls to analyzeSyntax. */
    public SimpleCallSettings.Builder<AnalyzeSyntaxRequest, AnalyzeSyntaxResponse>
        analyzeSyntaxSettings() {
      return analyzeSyntaxSettings;
    }

    /** Returns the builder for the settings used for calls to annotateText. */
    public SimpleCallSettings.Builder<AnnotateTextRequest, AnnotateTextResponse>
        annotateTextSettings() {
      return annotateTextSettings;
    }

    @Override
    public LanguageServiceSettings build() throws IOException {
      return new LanguageServiceSettings(this);
    }
  }
}
