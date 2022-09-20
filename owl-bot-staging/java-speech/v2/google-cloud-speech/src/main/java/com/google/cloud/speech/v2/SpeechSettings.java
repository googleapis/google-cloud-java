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

package com.google.cloud.speech.v2;

import static com.google.cloud.speech.v2.SpeechClient.ListCustomClassesPagedResponse;
import static com.google.cloud.speech.v2.SpeechClient.ListPhraseSetsPagedResponse;
import static com.google.cloud.speech.v2.SpeechClient.ListRecognizersPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.StreamingCallSettings;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.speech.v2.stub.SpeechStubSettings;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link SpeechClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (speech.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getRecognizer to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SpeechSettings.Builder speechSettingsBuilder = SpeechSettings.newBuilder();
 * speechSettingsBuilder
 *     .getRecognizerSettings()
 *     .setRetrySettings(
 *         speechSettingsBuilder.getRecognizerSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * SpeechSettings speechSettings = speechSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class SpeechSettings extends ClientSettings<SpeechSettings> {

  /** Returns the object with the settings used for calls to createRecognizer. */
  public UnaryCallSettings<CreateRecognizerRequest, Operation> createRecognizerSettings() {
    return ((SpeechStubSettings) getStubSettings()).createRecognizerSettings();
  }

  /** Returns the object with the settings used for calls to createRecognizer. */
  public OperationCallSettings<CreateRecognizerRequest, Recognizer, OperationMetadata>
      createRecognizerOperationSettings() {
    return ((SpeechStubSettings) getStubSettings()).createRecognizerOperationSettings();
  }

  /** Returns the object with the settings used for calls to listRecognizers. */
  public PagedCallSettings<
          ListRecognizersRequest, ListRecognizersResponse, ListRecognizersPagedResponse>
      listRecognizersSettings() {
    return ((SpeechStubSettings) getStubSettings()).listRecognizersSettings();
  }

  /** Returns the object with the settings used for calls to getRecognizer. */
  public UnaryCallSettings<GetRecognizerRequest, Recognizer> getRecognizerSettings() {
    return ((SpeechStubSettings) getStubSettings()).getRecognizerSettings();
  }

  /** Returns the object with the settings used for calls to updateRecognizer. */
  public UnaryCallSettings<UpdateRecognizerRequest, Operation> updateRecognizerSettings() {
    return ((SpeechStubSettings) getStubSettings()).updateRecognizerSettings();
  }

  /** Returns the object with the settings used for calls to updateRecognizer. */
  public OperationCallSettings<UpdateRecognizerRequest, Recognizer, OperationMetadata>
      updateRecognizerOperationSettings() {
    return ((SpeechStubSettings) getStubSettings()).updateRecognizerOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteRecognizer. */
  public UnaryCallSettings<DeleteRecognizerRequest, Operation> deleteRecognizerSettings() {
    return ((SpeechStubSettings) getStubSettings()).deleteRecognizerSettings();
  }

  /** Returns the object with the settings used for calls to deleteRecognizer. */
  public OperationCallSettings<DeleteRecognizerRequest, Recognizer, OperationMetadata>
      deleteRecognizerOperationSettings() {
    return ((SpeechStubSettings) getStubSettings()).deleteRecognizerOperationSettings();
  }

  /** Returns the object with the settings used for calls to undeleteRecognizer. */
  public UnaryCallSettings<UndeleteRecognizerRequest, Operation> undeleteRecognizerSettings() {
    return ((SpeechStubSettings) getStubSettings()).undeleteRecognizerSettings();
  }

  /** Returns the object with the settings used for calls to undeleteRecognizer. */
  public OperationCallSettings<UndeleteRecognizerRequest, Recognizer, OperationMetadata>
      undeleteRecognizerOperationSettings() {
    return ((SpeechStubSettings) getStubSettings()).undeleteRecognizerOperationSettings();
  }

  /** Returns the object with the settings used for calls to recognize. */
  public UnaryCallSettings<RecognizeRequest, RecognizeResponse> recognizeSettings() {
    return ((SpeechStubSettings) getStubSettings()).recognizeSettings();
  }

  /** Returns the object with the settings used for calls to streamingRecognize. */
  public StreamingCallSettings<StreamingRecognizeRequest, StreamingRecognizeResponse>
      streamingRecognizeSettings() {
    return ((SpeechStubSettings) getStubSettings()).streamingRecognizeSettings();
  }

  /** Returns the object with the settings used for calls to batchRecognize. */
  public UnaryCallSettings<BatchRecognizeRequest, Operation> batchRecognizeSettings() {
    return ((SpeechStubSettings) getStubSettings()).batchRecognizeSettings();
  }

  /** Returns the object with the settings used for calls to batchRecognize. */
  public OperationCallSettings<BatchRecognizeRequest, BatchRecognizeResponse, OperationMetadata>
      batchRecognizeOperationSettings() {
    return ((SpeechStubSettings) getStubSettings()).batchRecognizeOperationSettings();
  }

  /** Returns the object with the settings used for calls to getConfig. */
  public UnaryCallSettings<GetConfigRequest, Config> getConfigSettings() {
    return ((SpeechStubSettings) getStubSettings()).getConfigSettings();
  }

  /** Returns the object with the settings used for calls to updateConfig. */
  public UnaryCallSettings<UpdateConfigRequest, Config> updateConfigSettings() {
    return ((SpeechStubSettings) getStubSettings()).updateConfigSettings();
  }

  /** Returns the object with the settings used for calls to createCustomClass. */
  public UnaryCallSettings<CreateCustomClassRequest, Operation> createCustomClassSettings() {
    return ((SpeechStubSettings) getStubSettings()).createCustomClassSettings();
  }

  /** Returns the object with the settings used for calls to createCustomClass. */
  public OperationCallSettings<CreateCustomClassRequest, CustomClass, OperationMetadata>
      createCustomClassOperationSettings() {
    return ((SpeechStubSettings) getStubSettings()).createCustomClassOperationSettings();
  }

  /** Returns the object with the settings used for calls to listCustomClasses. */
  public PagedCallSettings<
          ListCustomClassesRequest, ListCustomClassesResponse, ListCustomClassesPagedResponse>
      listCustomClassesSettings() {
    return ((SpeechStubSettings) getStubSettings()).listCustomClassesSettings();
  }

  /** Returns the object with the settings used for calls to getCustomClass. */
  public UnaryCallSettings<GetCustomClassRequest, CustomClass> getCustomClassSettings() {
    return ((SpeechStubSettings) getStubSettings()).getCustomClassSettings();
  }

  /** Returns the object with the settings used for calls to updateCustomClass. */
  public UnaryCallSettings<UpdateCustomClassRequest, Operation> updateCustomClassSettings() {
    return ((SpeechStubSettings) getStubSettings()).updateCustomClassSettings();
  }

  /** Returns the object with the settings used for calls to updateCustomClass. */
  public OperationCallSettings<UpdateCustomClassRequest, CustomClass, OperationMetadata>
      updateCustomClassOperationSettings() {
    return ((SpeechStubSettings) getStubSettings()).updateCustomClassOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteCustomClass. */
  public UnaryCallSettings<DeleteCustomClassRequest, Operation> deleteCustomClassSettings() {
    return ((SpeechStubSettings) getStubSettings()).deleteCustomClassSettings();
  }

  /** Returns the object with the settings used for calls to deleteCustomClass. */
  public OperationCallSettings<DeleteCustomClassRequest, CustomClass, OperationMetadata>
      deleteCustomClassOperationSettings() {
    return ((SpeechStubSettings) getStubSettings()).deleteCustomClassOperationSettings();
  }

  /** Returns the object with the settings used for calls to undeleteCustomClass. */
  public UnaryCallSettings<UndeleteCustomClassRequest, Operation> undeleteCustomClassSettings() {
    return ((SpeechStubSettings) getStubSettings()).undeleteCustomClassSettings();
  }

  /** Returns the object with the settings used for calls to undeleteCustomClass. */
  public OperationCallSettings<UndeleteCustomClassRequest, CustomClass, OperationMetadata>
      undeleteCustomClassOperationSettings() {
    return ((SpeechStubSettings) getStubSettings()).undeleteCustomClassOperationSettings();
  }

  /** Returns the object with the settings used for calls to createPhraseSet. */
  public UnaryCallSettings<CreatePhraseSetRequest, Operation> createPhraseSetSettings() {
    return ((SpeechStubSettings) getStubSettings()).createPhraseSetSettings();
  }

  /** Returns the object with the settings used for calls to createPhraseSet. */
  public OperationCallSettings<CreatePhraseSetRequest, PhraseSet, OperationMetadata>
      createPhraseSetOperationSettings() {
    return ((SpeechStubSettings) getStubSettings()).createPhraseSetOperationSettings();
  }

  /** Returns the object with the settings used for calls to listPhraseSets. */
  public PagedCallSettings<
          ListPhraseSetsRequest, ListPhraseSetsResponse, ListPhraseSetsPagedResponse>
      listPhraseSetsSettings() {
    return ((SpeechStubSettings) getStubSettings()).listPhraseSetsSettings();
  }

  /** Returns the object with the settings used for calls to getPhraseSet. */
  public UnaryCallSettings<GetPhraseSetRequest, PhraseSet> getPhraseSetSettings() {
    return ((SpeechStubSettings) getStubSettings()).getPhraseSetSettings();
  }

  /** Returns the object with the settings used for calls to updatePhraseSet. */
  public UnaryCallSettings<UpdatePhraseSetRequest, Operation> updatePhraseSetSettings() {
    return ((SpeechStubSettings) getStubSettings()).updatePhraseSetSettings();
  }

  /** Returns the object with the settings used for calls to updatePhraseSet. */
  public OperationCallSettings<UpdatePhraseSetRequest, PhraseSet, OperationMetadata>
      updatePhraseSetOperationSettings() {
    return ((SpeechStubSettings) getStubSettings()).updatePhraseSetOperationSettings();
  }

  /** Returns the object with the settings used for calls to deletePhraseSet. */
  public UnaryCallSettings<DeletePhraseSetRequest, Operation> deletePhraseSetSettings() {
    return ((SpeechStubSettings) getStubSettings()).deletePhraseSetSettings();
  }

  /** Returns the object with the settings used for calls to deletePhraseSet. */
  public OperationCallSettings<DeletePhraseSetRequest, PhraseSet, OperationMetadata>
      deletePhraseSetOperationSettings() {
    return ((SpeechStubSettings) getStubSettings()).deletePhraseSetOperationSettings();
  }

  /** Returns the object with the settings used for calls to undeletePhraseSet. */
  public UnaryCallSettings<UndeletePhraseSetRequest, Operation> undeletePhraseSetSettings() {
    return ((SpeechStubSettings) getStubSettings()).undeletePhraseSetSettings();
  }

  /** Returns the object with the settings used for calls to undeletePhraseSet. */
  public OperationCallSettings<UndeletePhraseSetRequest, PhraseSet, OperationMetadata>
      undeletePhraseSetOperationSettings() {
    return ((SpeechStubSettings) getStubSettings()).undeletePhraseSetOperationSettings();
  }

  public static final SpeechSettings create(SpeechStubSettings stub) throws IOException {
    return new SpeechSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return SpeechStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return SpeechStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return SpeechStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return SpeechStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return SpeechStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return SpeechStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return SpeechStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return SpeechStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected SpeechSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for SpeechSettings. */
  public static class Builder extends ClientSettings.Builder<SpeechSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(SpeechStubSettings.newBuilder(clientContext));
    }

    protected Builder(SpeechSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(SpeechStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(SpeechStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(SpeechStubSettings.newHttpJsonBuilder());
    }

    public SpeechStubSettings.Builder getStubSettingsBuilder() {
      return ((SpeechStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createRecognizer. */
    public UnaryCallSettings.Builder<CreateRecognizerRequest, Operation>
        createRecognizerSettings() {
      return getStubSettingsBuilder().createRecognizerSettings();
    }

    /** Returns the builder for the settings used for calls to createRecognizer. */
    public OperationCallSettings.Builder<CreateRecognizerRequest, Recognizer, OperationMetadata>
        createRecognizerOperationSettings() {
      return getStubSettingsBuilder().createRecognizerOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listRecognizers. */
    public PagedCallSettings.Builder<
            ListRecognizersRequest, ListRecognizersResponse, ListRecognizersPagedResponse>
        listRecognizersSettings() {
      return getStubSettingsBuilder().listRecognizersSettings();
    }

    /** Returns the builder for the settings used for calls to getRecognizer. */
    public UnaryCallSettings.Builder<GetRecognizerRequest, Recognizer> getRecognizerSettings() {
      return getStubSettingsBuilder().getRecognizerSettings();
    }

    /** Returns the builder for the settings used for calls to updateRecognizer. */
    public UnaryCallSettings.Builder<UpdateRecognizerRequest, Operation>
        updateRecognizerSettings() {
      return getStubSettingsBuilder().updateRecognizerSettings();
    }

    /** Returns the builder for the settings used for calls to updateRecognizer. */
    public OperationCallSettings.Builder<UpdateRecognizerRequest, Recognizer, OperationMetadata>
        updateRecognizerOperationSettings() {
      return getStubSettingsBuilder().updateRecognizerOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteRecognizer. */
    public UnaryCallSettings.Builder<DeleteRecognizerRequest, Operation>
        deleteRecognizerSettings() {
      return getStubSettingsBuilder().deleteRecognizerSettings();
    }

    /** Returns the builder for the settings used for calls to deleteRecognizer. */
    public OperationCallSettings.Builder<DeleteRecognizerRequest, Recognizer, OperationMetadata>
        deleteRecognizerOperationSettings() {
      return getStubSettingsBuilder().deleteRecognizerOperationSettings();
    }

    /** Returns the builder for the settings used for calls to undeleteRecognizer. */
    public UnaryCallSettings.Builder<UndeleteRecognizerRequest, Operation>
        undeleteRecognizerSettings() {
      return getStubSettingsBuilder().undeleteRecognizerSettings();
    }

    /** Returns the builder for the settings used for calls to undeleteRecognizer. */
    public OperationCallSettings.Builder<UndeleteRecognizerRequest, Recognizer, OperationMetadata>
        undeleteRecognizerOperationSettings() {
      return getStubSettingsBuilder().undeleteRecognizerOperationSettings();
    }

    /** Returns the builder for the settings used for calls to recognize. */
    public UnaryCallSettings.Builder<RecognizeRequest, RecognizeResponse> recognizeSettings() {
      return getStubSettingsBuilder().recognizeSettings();
    }

    /** Returns the builder for the settings used for calls to streamingRecognize. */
    public StreamingCallSettings.Builder<StreamingRecognizeRequest, StreamingRecognizeResponse>
        streamingRecognizeSettings() {
      return getStubSettingsBuilder().streamingRecognizeSettings();
    }

    /** Returns the builder for the settings used for calls to batchRecognize. */
    public UnaryCallSettings.Builder<BatchRecognizeRequest, Operation> batchRecognizeSettings() {
      return getStubSettingsBuilder().batchRecognizeSettings();
    }

    /** Returns the builder for the settings used for calls to batchRecognize. */
    public OperationCallSettings.Builder<
            BatchRecognizeRequest, BatchRecognizeResponse, OperationMetadata>
        batchRecognizeOperationSettings() {
      return getStubSettingsBuilder().batchRecognizeOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getConfig. */
    public UnaryCallSettings.Builder<GetConfigRequest, Config> getConfigSettings() {
      return getStubSettingsBuilder().getConfigSettings();
    }

    /** Returns the builder for the settings used for calls to updateConfig. */
    public UnaryCallSettings.Builder<UpdateConfigRequest, Config> updateConfigSettings() {
      return getStubSettingsBuilder().updateConfigSettings();
    }

    /** Returns the builder for the settings used for calls to createCustomClass. */
    public UnaryCallSettings.Builder<CreateCustomClassRequest, Operation>
        createCustomClassSettings() {
      return getStubSettingsBuilder().createCustomClassSettings();
    }

    /** Returns the builder for the settings used for calls to createCustomClass. */
    public OperationCallSettings.Builder<CreateCustomClassRequest, CustomClass, OperationMetadata>
        createCustomClassOperationSettings() {
      return getStubSettingsBuilder().createCustomClassOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listCustomClasses. */
    public PagedCallSettings.Builder<
            ListCustomClassesRequest, ListCustomClassesResponse, ListCustomClassesPagedResponse>
        listCustomClassesSettings() {
      return getStubSettingsBuilder().listCustomClassesSettings();
    }

    /** Returns the builder for the settings used for calls to getCustomClass. */
    public UnaryCallSettings.Builder<GetCustomClassRequest, CustomClass> getCustomClassSettings() {
      return getStubSettingsBuilder().getCustomClassSettings();
    }

    /** Returns the builder for the settings used for calls to updateCustomClass. */
    public UnaryCallSettings.Builder<UpdateCustomClassRequest, Operation>
        updateCustomClassSettings() {
      return getStubSettingsBuilder().updateCustomClassSettings();
    }

    /** Returns the builder for the settings used for calls to updateCustomClass. */
    public OperationCallSettings.Builder<UpdateCustomClassRequest, CustomClass, OperationMetadata>
        updateCustomClassOperationSettings() {
      return getStubSettingsBuilder().updateCustomClassOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteCustomClass. */
    public UnaryCallSettings.Builder<DeleteCustomClassRequest, Operation>
        deleteCustomClassSettings() {
      return getStubSettingsBuilder().deleteCustomClassSettings();
    }

    /** Returns the builder for the settings used for calls to deleteCustomClass. */
    public OperationCallSettings.Builder<DeleteCustomClassRequest, CustomClass, OperationMetadata>
        deleteCustomClassOperationSettings() {
      return getStubSettingsBuilder().deleteCustomClassOperationSettings();
    }

    /** Returns the builder for the settings used for calls to undeleteCustomClass. */
    public UnaryCallSettings.Builder<UndeleteCustomClassRequest, Operation>
        undeleteCustomClassSettings() {
      return getStubSettingsBuilder().undeleteCustomClassSettings();
    }

    /** Returns the builder for the settings used for calls to undeleteCustomClass. */
    public OperationCallSettings.Builder<UndeleteCustomClassRequest, CustomClass, OperationMetadata>
        undeleteCustomClassOperationSettings() {
      return getStubSettingsBuilder().undeleteCustomClassOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createPhraseSet. */
    public UnaryCallSettings.Builder<CreatePhraseSetRequest, Operation> createPhraseSetSettings() {
      return getStubSettingsBuilder().createPhraseSetSettings();
    }

    /** Returns the builder for the settings used for calls to createPhraseSet. */
    public OperationCallSettings.Builder<CreatePhraseSetRequest, PhraseSet, OperationMetadata>
        createPhraseSetOperationSettings() {
      return getStubSettingsBuilder().createPhraseSetOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listPhraseSets. */
    public PagedCallSettings.Builder<
            ListPhraseSetsRequest, ListPhraseSetsResponse, ListPhraseSetsPagedResponse>
        listPhraseSetsSettings() {
      return getStubSettingsBuilder().listPhraseSetsSettings();
    }

    /** Returns the builder for the settings used for calls to getPhraseSet. */
    public UnaryCallSettings.Builder<GetPhraseSetRequest, PhraseSet> getPhraseSetSettings() {
      return getStubSettingsBuilder().getPhraseSetSettings();
    }

    /** Returns the builder for the settings used for calls to updatePhraseSet. */
    public UnaryCallSettings.Builder<UpdatePhraseSetRequest, Operation> updatePhraseSetSettings() {
      return getStubSettingsBuilder().updatePhraseSetSettings();
    }

    /** Returns the builder for the settings used for calls to updatePhraseSet. */
    public OperationCallSettings.Builder<UpdatePhraseSetRequest, PhraseSet, OperationMetadata>
        updatePhraseSetOperationSettings() {
      return getStubSettingsBuilder().updatePhraseSetOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deletePhraseSet. */
    public UnaryCallSettings.Builder<DeletePhraseSetRequest, Operation> deletePhraseSetSettings() {
      return getStubSettingsBuilder().deletePhraseSetSettings();
    }

    /** Returns the builder for the settings used for calls to deletePhraseSet. */
    public OperationCallSettings.Builder<DeletePhraseSetRequest, PhraseSet, OperationMetadata>
        deletePhraseSetOperationSettings() {
      return getStubSettingsBuilder().deletePhraseSetOperationSettings();
    }

    /** Returns the builder for the settings used for calls to undeletePhraseSet. */
    public UnaryCallSettings.Builder<UndeletePhraseSetRequest, Operation>
        undeletePhraseSetSettings() {
      return getStubSettingsBuilder().undeletePhraseSetSettings();
    }

    /** Returns the builder for the settings used for calls to undeletePhraseSet. */
    public OperationCallSettings.Builder<UndeletePhraseSetRequest, PhraseSet, OperationMetadata>
        undeletePhraseSetOperationSettings() {
      return getStubSettingsBuilder().undeletePhraseSetOperationSettings();
    }

    @Override
    public SpeechSettings build() throws IOException {
      return new SpeechSettings(this);
    }
  }
}
