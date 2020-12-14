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

package com.google.cloud.translate.v3beta1;

import static com.google.cloud.translate.v3beta1.TranslationServiceClient.ListGlossariesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.translate.v3beta1.stub.TranslationServiceStubSettings;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link TranslationServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (translate.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of translateText to 30 seconds:
 *
 * <pre>{@code
 * TranslationServiceSettings.Builder translationServiceSettingsBuilder =
 *     TranslationServiceSettings.newBuilder();
 * translationServiceSettingsBuilder
 *     .translateTextSettings()
 *     .setRetrySettings(
 *         translationServiceSettingsBuilder
 *             .translateTextSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * TranslationServiceSettings translationServiceSettings =
 *     translationServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class TranslationServiceSettings extends ClientSettings<TranslationServiceSettings> {

  /** Returns the object with the settings used for calls to translateText. */
  public UnaryCallSettings<TranslateTextRequest, TranslateTextResponse> translateTextSettings() {
    return ((TranslationServiceStubSettings) getStubSettings()).translateTextSettings();
  }

  /** Returns the object with the settings used for calls to detectLanguage. */
  public UnaryCallSettings<DetectLanguageRequest, DetectLanguageResponse> detectLanguageSettings() {
    return ((TranslationServiceStubSettings) getStubSettings()).detectLanguageSettings();
  }

  /** Returns the object with the settings used for calls to getSupportedLanguages. */
  public UnaryCallSettings<GetSupportedLanguagesRequest, SupportedLanguages>
      getSupportedLanguagesSettings() {
    return ((TranslationServiceStubSettings) getStubSettings()).getSupportedLanguagesSettings();
  }

  /** Returns the object with the settings used for calls to batchTranslateText. */
  public UnaryCallSettings<BatchTranslateTextRequest, Operation> batchTranslateTextSettings() {
    return ((TranslationServiceStubSettings) getStubSettings()).batchTranslateTextSettings();
  }

  /** Returns the object with the settings used for calls to batchTranslateText. */
  public OperationCallSettings<
          BatchTranslateTextRequest, BatchTranslateResponse, BatchTranslateMetadata>
      batchTranslateTextOperationSettings() {
    return ((TranslationServiceStubSettings) getStubSettings())
        .batchTranslateTextOperationSettings();
  }

  /** Returns the object with the settings used for calls to createGlossary. */
  public UnaryCallSettings<CreateGlossaryRequest, Operation> createGlossarySettings() {
    return ((TranslationServiceStubSettings) getStubSettings()).createGlossarySettings();
  }

  /** Returns the object with the settings used for calls to createGlossary. */
  public OperationCallSettings<CreateGlossaryRequest, Glossary, CreateGlossaryMetadata>
      createGlossaryOperationSettings() {
    return ((TranslationServiceStubSettings) getStubSettings()).createGlossaryOperationSettings();
  }

  /** Returns the object with the settings used for calls to listGlossaries. */
  public PagedCallSettings<
          ListGlossariesRequest, ListGlossariesResponse, ListGlossariesPagedResponse>
      listGlossariesSettings() {
    return ((TranslationServiceStubSettings) getStubSettings()).listGlossariesSettings();
  }

  /** Returns the object with the settings used for calls to getGlossary. */
  public UnaryCallSettings<GetGlossaryRequest, Glossary> getGlossarySettings() {
    return ((TranslationServiceStubSettings) getStubSettings()).getGlossarySettings();
  }

  /** Returns the object with the settings used for calls to deleteGlossary. */
  public UnaryCallSettings<DeleteGlossaryRequest, Operation> deleteGlossarySettings() {
    return ((TranslationServiceStubSettings) getStubSettings()).deleteGlossarySettings();
  }

  /** Returns the object with the settings used for calls to deleteGlossary. */
  public OperationCallSettings<
          DeleteGlossaryRequest, DeleteGlossaryResponse, DeleteGlossaryMetadata>
      deleteGlossaryOperationSettings() {
    return ((TranslationServiceStubSettings) getStubSettings()).deleteGlossaryOperationSettings();
  }

  public static final TranslationServiceSettings create(TranslationServiceStubSettings stub)
      throws IOException {
    return new TranslationServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return TranslationServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return TranslationServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return TranslationServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return TranslationServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return TranslationServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return TranslationServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return TranslationServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected TranslationServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for TranslationServiceSettings. */
  public static class Builder extends ClientSettings.Builder<TranslationServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(TranslationServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(TranslationServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(TranslationServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(TranslationServiceStubSettings.newBuilder());
    }

    public TranslationServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((TranslationServiceStubSettings.Builder) getStubSettings());
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'.
    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) throws Exception {
      super.applyToAllUnaryMethods(
          getStubSettingsBuilder().unaryMethodSettingsBuilders(), settingsUpdater);
      return this;
    }

    /** Returns the builder for the settings used for calls to translateText. */
    public UnaryCallSettings.Builder<TranslateTextRequest, TranslateTextResponse>
        translateTextSettings() {
      return getStubSettingsBuilder().translateTextSettings();
    }

    /** Returns the builder for the settings used for calls to detectLanguage. */
    public UnaryCallSettings.Builder<DetectLanguageRequest, DetectLanguageResponse>
        detectLanguageSettings() {
      return getStubSettingsBuilder().detectLanguageSettings();
    }

    /** Returns the builder for the settings used for calls to getSupportedLanguages. */
    public UnaryCallSettings.Builder<GetSupportedLanguagesRequest, SupportedLanguages>
        getSupportedLanguagesSettings() {
      return getStubSettingsBuilder().getSupportedLanguagesSettings();
    }

    /** Returns the builder for the settings used for calls to batchTranslateText. */
    public UnaryCallSettings.Builder<BatchTranslateTextRequest, Operation>
        batchTranslateTextSettings() {
      return getStubSettingsBuilder().batchTranslateTextSettings();
    }

    /** Returns the builder for the settings used for calls to batchTranslateText. */
    public OperationCallSettings.Builder<
            BatchTranslateTextRequest, BatchTranslateResponse, BatchTranslateMetadata>
        batchTranslateTextOperationSettings() {
      return getStubSettingsBuilder().batchTranslateTextOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createGlossary. */
    public UnaryCallSettings.Builder<CreateGlossaryRequest, Operation> createGlossarySettings() {
      return getStubSettingsBuilder().createGlossarySettings();
    }

    /** Returns the builder for the settings used for calls to createGlossary. */
    public OperationCallSettings.Builder<CreateGlossaryRequest, Glossary, CreateGlossaryMetadata>
        createGlossaryOperationSettings() {
      return getStubSettingsBuilder().createGlossaryOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listGlossaries. */
    public PagedCallSettings.Builder<
            ListGlossariesRequest, ListGlossariesResponse, ListGlossariesPagedResponse>
        listGlossariesSettings() {
      return getStubSettingsBuilder().listGlossariesSettings();
    }

    /** Returns the builder for the settings used for calls to getGlossary. */
    public UnaryCallSettings.Builder<GetGlossaryRequest, Glossary> getGlossarySettings() {
      return getStubSettingsBuilder().getGlossarySettings();
    }

    /** Returns the builder for the settings used for calls to deleteGlossary. */
    public UnaryCallSettings.Builder<DeleteGlossaryRequest, Operation> deleteGlossarySettings() {
      return getStubSettingsBuilder().deleteGlossarySettings();
    }

    /** Returns the builder for the settings used for calls to deleteGlossary. */
    public OperationCallSettings.Builder<
            DeleteGlossaryRequest, DeleteGlossaryResponse, DeleteGlossaryMetadata>
        deleteGlossaryOperationSettings() {
      return getStubSettingsBuilder().deleteGlossaryOperationSettings();
    }

    @Override
    public TranslationServiceSettings build() throws IOException {
      return new TranslationServiceSettings(this);
    }
  }
}
