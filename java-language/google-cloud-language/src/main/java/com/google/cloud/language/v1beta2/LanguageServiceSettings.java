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

package com.google.cloud.language.v1beta2;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.language.v1beta2.stub.LanguageServiceStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
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
 * LanguageServiceSettings.Builder languageServiceSettingsBuilder =
 *     LanguageServiceSettings.newBuilder();
 * languageServiceSettingsBuilder
 *     .analyzeSentimentSettings()
 *     .setRetrySettings(
 *         languageServiceSettingsBuilder.analyzeSentimentSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * LanguageServiceSettings languageServiceSettings = languageServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class LanguageServiceSettings extends ClientSettings<LanguageServiceSettings> {

  /** Returns the object with the settings used for calls to analyzeSentiment. */
  public UnaryCallSettings<AnalyzeSentimentRequest, AnalyzeSentimentResponse>
      analyzeSentimentSettings() {
    return ((LanguageServiceStubSettings) getStubSettings()).analyzeSentimentSettings();
  }

  /** Returns the object with the settings used for calls to analyzeEntities. */
  public UnaryCallSettings<AnalyzeEntitiesRequest, AnalyzeEntitiesResponse>
      analyzeEntitiesSettings() {
    return ((LanguageServiceStubSettings) getStubSettings()).analyzeEntitiesSettings();
  }

  /** Returns the object with the settings used for calls to analyzeEntitySentiment. */
  public UnaryCallSettings<AnalyzeEntitySentimentRequest, AnalyzeEntitySentimentResponse>
      analyzeEntitySentimentSettings() {
    return ((LanguageServiceStubSettings) getStubSettings()).analyzeEntitySentimentSettings();
  }

  /** Returns the object with the settings used for calls to analyzeSyntax. */
  public UnaryCallSettings<AnalyzeSyntaxRequest, AnalyzeSyntaxResponse> analyzeSyntaxSettings() {
    return ((LanguageServiceStubSettings) getStubSettings()).analyzeSyntaxSettings();
  }

  /** Returns the object with the settings used for calls to classifyText. */
  public UnaryCallSettings<ClassifyTextRequest, ClassifyTextResponse> classifyTextSettings() {
    return ((LanguageServiceStubSettings) getStubSettings()).classifyTextSettings();
  }

  /** Returns the object with the settings used for calls to annotateText. */
  public UnaryCallSettings<AnnotateTextRequest, AnnotateTextResponse> annotateTextSettings() {
    return ((LanguageServiceStubSettings) getStubSettings()).annotateTextSettings();
  }

  public static final LanguageServiceSettings create(LanguageServiceStubSettings stub)
      throws IOException {
    return new LanguageServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return LanguageServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return LanguageServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return LanguageServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return LanguageServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return LanguageServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return LanguageServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return LanguageServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return LanguageServiceStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
  @BetaApi
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

  protected LanguageServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for LanguageServiceSettings. */
  public static class Builder extends ClientSettings.Builder<LanguageServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(LanguageServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(LanguageServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(LanguageServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(LanguageServiceStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(LanguageServiceStubSettings.newHttpJsonBuilder());
    }

    public LanguageServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((LanguageServiceStubSettings.Builder) getStubSettings());
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(
          getStubSettingsBuilder().unaryMethodSettingsBuilders(), settingsUpdater);
      return this;
    }

    /** Returns the builder for the settings used for calls to analyzeSentiment. */
    public UnaryCallSettings.Builder<AnalyzeSentimentRequest, AnalyzeSentimentResponse>
        analyzeSentimentSettings() {
      return getStubSettingsBuilder().analyzeSentimentSettings();
    }

    /** Returns the builder for the settings used for calls to analyzeEntities. */
    public UnaryCallSettings.Builder<AnalyzeEntitiesRequest, AnalyzeEntitiesResponse>
        analyzeEntitiesSettings() {
      return getStubSettingsBuilder().analyzeEntitiesSettings();
    }

    /** Returns the builder for the settings used for calls to analyzeEntitySentiment. */
    public UnaryCallSettings.Builder<AnalyzeEntitySentimentRequest, AnalyzeEntitySentimentResponse>
        analyzeEntitySentimentSettings() {
      return getStubSettingsBuilder().analyzeEntitySentimentSettings();
    }

    /** Returns the builder for the settings used for calls to analyzeSyntax. */
    public UnaryCallSettings.Builder<AnalyzeSyntaxRequest, AnalyzeSyntaxResponse>
        analyzeSyntaxSettings() {
      return getStubSettingsBuilder().analyzeSyntaxSettings();
    }

    /** Returns the builder for the settings used for calls to classifyText. */
    public UnaryCallSettings.Builder<ClassifyTextRequest, ClassifyTextResponse>
        classifyTextSettings() {
      return getStubSettingsBuilder().classifyTextSettings();
    }

    /** Returns the builder for the settings used for calls to annotateText. */
    public UnaryCallSettings.Builder<AnnotateTextRequest, AnnotateTextResponse>
        annotateTextSettings() {
      return getStubSettingsBuilder().annotateTextSettings();
    }

    @Override
    public LanguageServiceSettings build() throws IOException {
      return new LanguageServiceSettings(this);
    }
  }
}
