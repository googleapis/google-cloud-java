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

package com.google.cloud.translate.v3;

import static com.google.cloud.translate.v3.TranslationServiceClient.ListAdaptiveMtDatasetsPagedResponse;
import static com.google.cloud.translate.v3.TranslationServiceClient.ListAdaptiveMtFilesPagedResponse;
import static com.google.cloud.translate.v3.TranslationServiceClient.ListAdaptiveMtSentencesPagedResponse;
import static com.google.cloud.translate.v3.TranslationServiceClient.ListDatasetsPagedResponse;
import static com.google.cloud.translate.v3.TranslationServiceClient.ListExamplesPagedResponse;
import static com.google.cloud.translate.v3.TranslationServiceClient.ListGlossariesPagedResponse;
import static com.google.cloud.translate.v3.TranslationServiceClient.ListGlossaryEntriesPagedResponse;
import static com.google.cloud.translate.v3.TranslationServiceClient.ListModelsPagedResponse;

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
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.translate.v3.stub.TranslationServiceStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
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
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of translateText:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * TranslationServiceSettings.Builder translationServiceSettingsBuilder =
 *     TranslationServiceSettings.newBuilder();
 * translationServiceSettingsBuilder
 *     .translateTextSettings()
 *     .setRetrySettings(
 *         translationServiceSettingsBuilder
 *             .translateTextSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofSeconds(1))
 *             .setInitialRpcTimeoutDuration(Duration.ofSeconds(5))
 *             .setMaxAttempts(5)
 *             .setMaxRetryDelayDuration(Duration.ofSeconds(30))
 *             .setMaxRpcTimeoutDuration(Duration.ofSeconds(60))
 *             .setRetryDelayMultiplier(1.3)
 *             .setRpcTimeoutMultiplier(1.5)
 *             .setTotalTimeoutDuration(Duration.ofSeconds(300))
 *             .build());
 * TranslationServiceSettings translationServiceSettings =
 *     translationServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for batchTranslateText:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * TranslationServiceSettings.Builder translationServiceSettingsBuilder =
 *     TranslationServiceSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * translationServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class TranslationServiceSettings extends ClientSettings<TranslationServiceSettings> {

  /** Returns the object with the settings used for calls to translateText. */
  public UnaryCallSettings<TranslateTextRequest, TranslateTextResponse> translateTextSettings() {
    return ((TranslationServiceStubSettings) getStubSettings()).translateTextSettings();
  }

  /** Returns the object with the settings used for calls to romanizeText. */
  public UnaryCallSettings<RomanizeTextRequest, RomanizeTextResponse> romanizeTextSettings() {
    return ((TranslationServiceStubSettings) getStubSettings()).romanizeTextSettings();
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

  /** Returns the object with the settings used for calls to translateDocument. */
  public UnaryCallSettings<TranslateDocumentRequest, TranslateDocumentResponse>
      translateDocumentSettings() {
    return ((TranslationServiceStubSettings) getStubSettings()).translateDocumentSettings();
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

  /** Returns the object with the settings used for calls to batchTranslateDocument. */
  public UnaryCallSettings<BatchTranslateDocumentRequest, Operation>
      batchTranslateDocumentSettings() {
    return ((TranslationServiceStubSettings) getStubSettings()).batchTranslateDocumentSettings();
  }

  /** Returns the object with the settings used for calls to batchTranslateDocument. */
  public OperationCallSettings<
          BatchTranslateDocumentRequest,
          BatchTranslateDocumentResponse,
          BatchTranslateDocumentMetadata>
      batchTranslateDocumentOperationSettings() {
    return ((TranslationServiceStubSettings) getStubSettings())
        .batchTranslateDocumentOperationSettings();
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

  /** Returns the object with the settings used for calls to updateGlossary. */
  public UnaryCallSettings<UpdateGlossaryRequest, Operation> updateGlossarySettings() {
    return ((TranslationServiceStubSettings) getStubSettings()).updateGlossarySettings();
  }

  /** Returns the object with the settings used for calls to updateGlossary. */
  public OperationCallSettings<UpdateGlossaryRequest, Glossary, UpdateGlossaryMetadata>
      updateGlossaryOperationSettings() {
    return ((TranslationServiceStubSettings) getStubSettings()).updateGlossaryOperationSettings();
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

  /** Returns the object with the settings used for calls to getGlossaryEntry. */
  public UnaryCallSettings<GetGlossaryEntryRequest, GlossaryEntry> getGlossaryEntrySettings() {
    return ((TranslationServiceStubSettings) getStubSettings()).getGlossaryEntrySettings();
  }

  /** Returns the object with the settings used for calls to listGlossaryEntries. */
  public PagedCallSettings<
          ListGlossaryEntriesRequest, ListGlossaryEntriesResponse, ListGlossaryEntriesPagedResponse>
      listGlossaryEntriesSettings() {
    return ((TranslationServiceStubSettings) getStubSettings()).listGlossaryEntriesSettings();
  }

  /** Returns the object with the settings used for calls to createGlossaryEntry. */
  public UnaryCallSettings<CreateGlossaryEntryRequest, GlossaryEntry>
      createGlossaryEntrySettings() {
    return ((TranslationServiceStubSettings) getStubSettings()).createGlossaryEntrySettings();
  }

  /** Returns the object with the settings used for calls to updateGlossaryEntry. */
  public UnaryCallSettings<UpdateGlossaryEntryRequest, GlossaryEntry>
      updateGlossaryEntrySettings() {
    return ((TranslationServiceStubSettings) getStubSettings()).updateGlossaryEntrySettings();
  }

  /** Returns the object with the settings used for calls to deleteGlossaryEntry. */
  public UnaryCallSettings<DeleteGlossaryEntryRequest, Empty> deleteGlossaryEntrySettings() {
    return ((TranslationServiceStubSettings) getStubSettings()).deleteGlossaryEntrySettings();
  }

  /** Returns the object with the settings used for calls to createDataset. */
  public UnaryCallSettings<CreateDatasetRequest, Operation> createDatasetSettings() {
    return ((TranslationServiceStubSettings) getStubSettings()).createDatasetSettings();
  }

  /** Returns the object with the settings used for calls to createDataset. */
  public OperationCallSettings<CreateDatasetRequest, Dataset, CreateDatasetMetadata>
      createDatasetOperationSettings() {
    return ((TranslationServiceStubSettings) getStubSettings()).createDatasetOperationSettings();
  }

  /** Returns the object with the settings used for calls to getDataset. */
  public UnaryCallSettings<GetDatasetRequest, Dataset> getDatasetSettings() {
    return ((TranslationServiceStubSettings) getStubSettings()).getDatasetSettings();
  }

  /** Returns the object with the settings used for calls to listDatasets. */
  public PagedCallSettings<ListDatasetsRequest, ListDatasetsResponse, ListDatasetsPagedResponse>
      listDatasetsSettings() {
    return ((TranslationServiceStubSettings) getStubSettings()).listDatasetsSettings();
  }

  /** Returns the object with the settings used for calls to deleteDataset. */
  public UnaryCallSettings<DeleteDatasetRequest, Operation> deleteDatasetSettings() {
    return ((TranslationServiceStubSettings) getStubSettings()).deleteDatasetSettings();
  }

  /** Returns the object with the settings used for calls to deleteDataset. */
  public OperationCallSettings<DeleteDatasetRequest, Empty, DeleteDatasetMetadata>
      deleteDatasetOperationSettings() {
    return ((TranslationServiceStubSettings) getStubSettings()).deleteDatasetOperationSettings();
  }

  /** Returns the object with the settings used for calls to createAdaptiveMtDataset. */
  public UnaryCallSettings<CreateAdaptiveMtDatasetRequest, AdaptiveMtDataset>
      createAdaptiveMtDatasetSettings() {
    return ((TranslationServiceStubSettings) getStubSettings()).createAdaptiveMtDatasetSettings();
  }

  /** Returns the object with the settings used for calls to deleteAdaptiveMtDataset. */
  public UnaryCallSettings<DeleteAdaptiveMtDatasetRequest, Empty>
      deleteAdaptiveMtDatasetSettings() {
    return ((TranslationServiceStubSettings) getStubSettings()).deleteAdaptiveMtDatasetSettings();
  }

  /** Returns the object with the settings used for calls to getAdaptiveMtDataset. */
  public UnaryCallSettings<GetAdaptiveMtDatasetRequest, AdaptiveMtDataset>
      getAdaptiveMtDatasetSettings() {
    return ((TranslationServiceStubSettings) getStubSettings()).getAdaptiveMtDatasetSettings();
  }

  /** Returns the object with the settings used for calls to listAdaptiveMtDatasets. */
  public PagedCallSettings<
          ListAdaptiveMtDatasetsRequest,
          ListAdaptiveMtDatasetsResponse,
          ListAdaptiveMtDatasetsPagedResponse>
      listAdaptiveMtDatasetsSettings() {
    return ((TranslationServiceStubSettings) getStubSettings()).listAdaptiveMtDatasetsSettings();
  }

  /** Returns the object with the settings used for calls to adaptiveMtTranslate. */
  public UnaryCallSettings<AdaptiveMtTranslateRequest, AdaptiveMtTranslateResponse>
      adaptiveMtTranslateSettings() {
    return ((TranslationServiceStubSettings) getStubSettings()).adaptiveMtTranslateSettings();
  }

  /** Returns the object with the settings used for calls to getAdaptiveMtFile. */
  public UnaryCallSettings<GetAdaptiveMtFileRequest, AdaptiveMtFile> getAdaptiveMtFileSettings() {
    return ((TranslationServiceStubSettings) getStubSettings()).getAdaptiveMtFileSettings();
  }

  /** Returns the object with the settings used for calls to deleteAdaptiveMtFile. */
  public UnaryCallSettings<DeleteAdaptiveMtFileRequest, Empty> deleteAdaptiveMtFileSettings() {
    return ((TranslationServiceStubSettings) getStubSettings()).deleteAdaptiveMtFileSettings();
  }

  /** Returns the object with the settings used for calls to importAdaptiveMtFile. */
  public UnaryCallSettings<ImportAdaptiveMtFileRequest, ImportAdaptiveMtFileResponse>
      importAdaptiveMtFileSettings() {
    return ((TranslationServiceStubSettings) getStubSettings()).importAdaptiveMtFileSettings();
  }

  /** Returns the object with the settings used for calls to listAdaptiveMtFiles. */
  public PagedCallSettings<
          ListAdaptiveMtFilesRequest, ListAdaptiveMtFilesResponse, ListAdaptiveMtFilesPagedResponse>
      listAdaptiveMtFilesSettings() {
    return ((TranslationServiceStubSettings) getStubSettings()).listAdaptiveMtFilesSettings();
  }

  /** Returns the object with the settings used for calls to listAdaptiveMtSentences. */
  public PagedCallSettings<
          ListAdaptiveMtSentencesRequest,
          ListAdaptiveMtSentencesResponse,
          ListAdaptiveMtSentencesPagedResponse>
      listAdaptiveMtSentencesSettings() {
    return ((TranslationServiceStubSettings) getStubSettings()).listAdaptiveMtSentencesSettings();
  }

  /** Returns the object with the settings used for calls to importData. */
  public UnaryCallSettings<ImportDataRequest, Operation> importDataSettings() {
    return ((TranslationServiceStubSettings) getStubSettings()).importDataSettings();
  }

  /** Returns the object with the settings used for calls to importData. */
  public OperationCallSettings<ImportDataRequest, Empty, ImportDataMetadata>
      importDataOperationSettings() {
    return ((TranslationServiceStubSettings) getStubSettings()).importDataOperationSettings();
  }

  /** Returns the object with the settings used for calls to exportData. */
  public UnaryCallSettings<ExportDataRequest, Operation> exportDataSettings() {
    return ((TranslationServiceStubSettings) getStubSettings()).exportDataSettings();
  }

  /** Returns the object with the settings used for calls to exportData. */
  public OperationCallSettings<ExportDataRequest, Empty, ExportDataMetadata>
      exportDataOperationSettings() {
    return ((TranslationServiceStubSettings) getStubSettings()).exportDataOperationSettings();
  }

  /** Returns the object with the settings used for calls to listExamples. */
  public PagedCallSettings<ListExamplesRequest, ListExamplesResponse, ListExamplesPagedResponse>
      listExamplesSettings() {
    return ((TranslationServiceStubSettings) getStubSettings()).listExamplesSettings();
  }

  /** Returns the object with the settings used for calls to createModel. */
  public UnaryCallSettings<CreateModelRequest, Operation> createModelSettings() {
    return ((TranslationServiceStubSettings) getStubSettings()).createModelSettings();
  }

  /** Returns the object with the settings used for calls to createModel. */
  public OperationCallSettings<CreateModelRequest, Model, CreateModelMetadata>
      createModelOperationSettings() {
    return ((TranslationServiceStubSettings) getStubSettings()).createModelOperationSettings();
  }

  /** Returns the object with the settings used for calls to listModels. */
  public PagedCallSettings<ListModelsRequest, ListModelsResponse, ListModelsPagedResponse>
      listModelsSettings() {
    return ((TranslationServiceStubSettings) getStubSettings()).listModelsSettings();
  }

  /** Returns the object with the settings used for calls to getModel. */
  public UnaryCallSettings<GetModelRequest, Model> getModelSettings() {
    return ((TranslationServiceStubSettings) getStubSettings()).getModelSettings();
  }

  /** Returns the object with the settings used for calls to deleteModel. */
  public UnaryCallSettings<DeleteModelRequest, Operation> deleteModelSettings() {
    return ((TranslationServiceStubSettings) getStubSettings()).deleteModelSettings();
  }

  /** Returns the object with the settings used for calls to deleteModel. */
  public OperationCallSettings<DeleteModelRequest, Empty, DeleteModelMetadata>
      deleteModelOperationSettings() {
    return ((TranslationServiceStubSettings) getStubSettings()).deleteModelOperationSettings();
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

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return TranslationServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return TranslationServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return TranslationServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return TranslationServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

    private static Builder createHttpJsonDefault() {
      return new Builder(TranslationServiceStubSettings.newHttpJsonBuilder());
    }

    public TranslationServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((TranslationServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to translateText. */
    public UnaryCallSettings.Builder<TranslateTextRequest, TranslateTextResponse>
        translateTextSettings() {
      return getStubSettingsBuilder().translateTextSettings();
    }

    /** Returns the builder for the settings used for calls to romanizeText. */
    public UnaryCallSettings.Builder<RomanizeTextRequest, RomanizeTextResponse>
        romanizeTextSettings() {
      return getStubSettingsBuilder().romanizeTextSettings();
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

    /** Returns the builder for the settings used for calls to translateDocument. */
    public UnaryCallSettings.Builder<TranslateDocumentRequest, TranslateDocumentResponse>
        translateDocumentSettings() {
      return getStubSettingsBuilder().translateDocumentSettings();
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

    /** Returns the builder for the settings used for calls to batchTranslateDocument. */
    public UnaryCallSettings.Builder<BatchTranslateDocumentRequest, Operation>
        batchTranslateDocumentSettings() {
      return getStubSettingsBuilder().batchTranslateDocumentSettings();
    }

    /** Returns the builder for the settings used for calls to batchTranslateDocument. */
    public OperationCallSettings.Builder<
            BatchTranslateDocumentRequest,
            BatchTranslateDocumentResponse,
            BatchTranslateDocumentMetadata>
        batchTranslateDocumentOperationSettings() {
      return getStubSettingsBuilder().batchTranslateDocumentOperationSettings();
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

    /** Returns the builder for the settings used for calls to updateGlossary. */
    public UnaryCallSettings.Builder<UpdateGlossaryRequest, Operation> updateGlossarySettings() {
      return getStubSettingsBuilder().updateGlossarySettings();
    }

    /** Returns the builder for the settings used for calls to updateGlossary. */
    public OperationCallSettings.Builder<UpdateGlossaryRequest, Glossary, UpdateGlossaryMetadata>
        updateGlossaryOperationSettings() {
      return getStubSettingsBuilder().updateGlossaryOperationSettings();
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

    /** Returns the builder for the settings used for calls to getGlossaryEntry. */
    public UnaryCallSettings.Builder<GetGlossaryEntryRequest, GlossaryEntry>
        getGlossaryEntrySettings() {
      return getStubSettingsBuilder().getGlossaryEntrySettings();
    }

    /** Returns the builder for the settings used for calls to listGlossaryEntries. */
    public PagedCallSettings.Builder<
            ListGlossaryEntriesRequest,
            ListGlossaryEntriesResponse,
            ListGlossaryEntriesPagedResponse>
        listGlossaryEntriesSettings() {
      return getStubSettingsBuilder().listGlossaryEntriesSettings();
    }

    /** Returns the builder for the settings used for calls to createGlossaryEntry. */
    public UnaryCallSettings.Builder<CreateGlossaryEntryRequest, GlossaryEntry>
        createGlossaryEntrySettings() {
      return getStubSettingsBuilder().createGlossaryEntrySettings();
    }

    /** Returns the builder for the settings used for calls to updateGlossaryEntry. */
    public UnaryCallSettings.Builder<UpdateGlossaryEntryRequest, GlossaryEntry>
        updateGlossaryEntrySettings() {
      return getStubSettingsBuilder().updateGlossaryEntrySettings();
    }

    /** Returns the builder for the settings used for calls to deleteGlossaryEntry. */
    public UnaryCallSettings.Builder<DeleteGlossaryEntryRequest, Empty>
        deleteGlossaryEntrySettings() {
      return getStubSettingsBuilder().deleteGlossaryEntrySettings();
    }

    /** Returns the builder for the settings used for calls to createDataset. */
    public UnaryCallSettings.Builder<CreateDatasetRequest, Operation> createDatasetSettings() {
      return getStubSettingsBuilder().createDatasetSettings();
    }

    /** Returns the builder for the settings used for calls to createDataset. */
    public OperationCallSettings.Builder<CreateDatasetRequest, Dataset, CreateDatasetMetadata>
        createDatasetOperationSettings() {
      return getStubSettingsBuilder().createDatasetOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getDataset. */
    public UnaryCallSettings.Builder<GetDatasetRequest, Dataset> getDatasetSettings() {
      return getStubSettingsBuilder().getDatasetSettings();
    }

    /** Returns the builder for the settings used for calls to listDatasets. */
    public PagedCallSettings.Builder<
            ListDatasetsRequest, ListDatasetsResponse, ListDatasetsPagedResponse>
        listDatasetsSettings() {
      return getStubSettingsBuilder().listDatasetsSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDataset. */
    public UnaryCallSettings.Builder<DeleteDatasetRequest, Operation> deleteDatasetSettings() {
      return getStubSettingsBuilder().deleteDatasetSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDataset. */
    public OperationCallSettings.Builder<DeleteDatasetRequest, Empty, DeleteDatasetMetadata>
        deleteDatasetOperationSettings() {
      return getStubSettingsBuilder().deleteDatasetOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createAdaptiveMtDataset. */
    public UnaryCallSettings.Builder<CreateAdaptiveMtDatasetRequest, AdaptiveMtDataset>
        createAdaptiveMtDatasetSettings() {
      return getStubSettingsBuilder().createAdaptiveMtDatasetSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAdaptiveMtDataset. */
    public UnaryCallSettings.Builder<DeleteAdaptiveMtDatasetRequest, Empty>
        deleteAdaptiveMtDatasetSettings() {
      return getStubSettingsBuilder().deleteAdaptiveMtDatasetSettings();
    }

    /** Returns the builder for the settings used for calls to getAdaptiveMtDataset. */
    public UnaryCallSettings.Builder<GetAdaptiveMtDatasetRequest, AdaptiveMtDataset>
        getAdaptiveMtDatasetSettings() {
      return getStubSettingsBuilder().getAdaptiveMtDatasetSettings();
    }

    /** Returns the builder for the settings used for calls to listAdaptiveMtDatasets. */
    public PagedCallSettings.Builder<
            ListAdaptiveMtDatasetsRequest,
            ListAdaptiveMtDatasetsResponse,
            ListAdaptiveMtDatasetsPagedResponse>
        listAdaptiveMtDatasetsSettings() {
      return getStubSettingsBuilder().listAdaptiveMtDatasetsSettings();
    }

    /** Returns the builder for the settings used for calls to adaptiveMtTranslate. */
    public UnaryCallSettings.Builder<AdaptiveMtTranslateRequest, AdaptiveMtTranslateResponse>
        adaptiveMtTranslateSettings() {
      return getStubSettingsBuilder().adaptiveMtTranslateSettings();
    }

    /** Returns the builder for the settings used for calls to getAdaptiveMtFile. */
    public UnaryCallSettings.Builder<GetAdaptiveMtFileRequest, AdaptiveMtFile>
        getAdaptiveMtFileSettings() {
      return getStubSettingsBuilder().getAdaptiveMtFileSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAdaptiveMtFile. */
    public UnaryCallSettings.Builder<DeleteAdaptiveMtFileRequest, Empty>
        deleteAdaptiveMtFileSettings() {
      return getStubSettingsBuilder().deleteAdaptiveMtFileSettings();
    }

    /** Returns the builder for the settings used for calls to importAdaptiveMtFile. */
    public UnaryCallSettings.Builder<ImportAdaptiveMtFileRequest, ImportAdaptiveMtFileResponse>
        importAdaptiveMtFileSettings() {
      return getStubSettingsBuilder().importAdaptiveMtFileSettings();
    }

    /** Returns the builder for the settings used for calls to listAdaptiveMtFiles. */
    public PagedCallSettings.Builder<
            ListAdaptiveMtFilesRequest,
            ListAdaptiveMtFilesResponse,
            ListAdaptiveMtFilesPagedResponse>
        listAdaptiveMtFilesSettings() {
      return getStubSettingsBuilder().listAdaptiveMtFilesSettings();
    }

    /** Returns the builder for the settings used for calls to listAdaptiveMtSentences. */
    public PagedCallSettings.Builder<
            ListAdaptiveMtSentencesRequest,
            ListAdaptiveMtSentencesResponse,
            ListAdaptiveMtSentencesPagedResponse>
        listAdaptiveMtSentencesSettings() {
      return getStubSettingsBuilder().listAdaptiveMtSentencesSettings();
    }

    /** Returns the builder for the settings used for calls to importData. */
    public UnaryCallSettings.Builder<ImportDataRequest, Operation> importDataSettings() {
      return getStubSettingsBuilder().importDataSettings();
    }

    /** Returns the builder for the settings used for calls to importData. */
    public OperationCallSettings.Builder<ImportDataRequest, Empty, ImportDataMetadata>
        importDataOperationSettings() {
      return getStubSettingsBuilder().importDataOperationSettings();
    }

    /** Returns the builder for the settings used for calls to exportData. */
    public UnaryCallSettings.Builder<ExportDataRequest, Operation> exportDataSettings() {
      return getStubSettingsBuilder().exportDataSettings();
    }

    /** Returns the builder for the settings used for calls to exportData. */
    public OperationCallSettings.Builder<ExportDataRequest, Empty, ExportDataMetadata>
        exportDataOperationSettings() {
      return getStubSettingsBuilder().exportDataOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listExamples. */
    public PagedCallSettings.Builder<
            ListExamplesRequest, ListExamplesResponse, ListExamplesPagedResponse>
        listExamplesSettings() {
      return getStubSettingsBuilder().listExamplesSettings();
    }

    /** Returns the builder for the settings used for calls to createModel. */
    public UnaryCallSettings.Builder<CreateModelRequest, Operation> createModelSettings() {
      return getStubSettingsBuilder().createModelSettings();
    }

    /** Returns the builder for the settings used for calls to createModel. */
    public OperationCallSettings.Builder<CreateModelRequest, Model, CreateModelMetadata>
        createModelOperationSettings() {
      return getStubSettingsBuilder().createModelOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listModels. */
    public PagedCallSettings.Builder<ListModelsRequest, ListModelsResponse, ListModelsPagedResponse>
        listModelsSettings() {
      return getStubSettingsBuilder().listModelsSettings();
    }

    /** Returns the builder for the settings used for calls to getModel. */
    public UnaryCallSettings.Builder<GetModelRequest, Model> getModelSettings() {
      return getStubSettingsBuilder().getModelSettings();
    }

    /** Returns the builder for the settings used for calls to deleteModel. */
    public UnaryCallSettings.Builder<DeleteModelRequest, Operation> deleteModelSettings() {
      return getStubSettingsBuilder().deleteModelSettings();
    }

    /** Returns the builder for the settings used for calls to deleteModel. */
    public OperationCallSettings.Builder<DeleteModelRequest, Empty, DeleteModelMetadata>
        deleteModelOperationSettings() {
      return getStubSettingsBuilder().deleteModelOperationSettings();
    }

    @Override
    public TranslationServiceSettings build() throws IOException {
      return new TranslationServiceSettings(this);
    }
  }
}
