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

package com.google.cloud.datalabeling.v1beta1;

import static com.google.cloud.datalabeling.v1beta1.DataLabelingServiceClient.ListAnnotatedDatasetsPagedResponse;
import static com.google.cloud.datalabeling.v1beta1.DataLabelingServiceClient.ListAnnotationSpecSetsPagedResponse;
import static com.google.cloud.datalabeling.v1beta1.DataLabelingServiceClient.ListDataItemsPagedResponse;
import static com.google.cloud.datalabeling.v1beta1.DataLabelingServiceClient.ListDatasetsPagedResponse;
import static com.google.cloud.datalabeling.v1beta1.DataLabelingServiceClient.ListEvaluationJobsPagedResponse;
import static com.google.cloud.datalabeling.v1beta1.DataLabelingServiceClient.ListExamplesPagedResponse;
import static com.google.cloud.datalabeling.v1beta1.DataLabelingServiceClient.ListInstructionsPagedResponse;
import static com.google.cloud.datalabeling.v1beta1.DataLabelingServiceClient.SearchEvaluationsPagedResponse;
import static com.google.cloud.datalabeling.v1beta1.DataLabelingServiceClient.SearchExampleComparisonsPagedResponse;

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
import com.google.cloud.datalabeling.v1beta1.stub.DataLabelingServiceStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link DataLabelingServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (datalabeling.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createDataset to 30 seconds:
 *
 * <pre>{@code
 * DataLabelingServiceSettings.Builder dataLabelingServiceSettingsBuilder =
 *     DataLabelingServiceSettings.newBuilder();
 * dataLabelingServiceSettingsBuilder
 *     .createDatasetSettings()
 *     .setRetrySettings(
 *         dataLabelingServiceSettingsBuilder
 *             .createDatasetSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * DataLabelingServiceSettings dataLabelingServiceSettings =
 *     dataLabelingServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class DataLabelingServiceSettings extends ClientSettings<DataLabelingServiceSettings> {

  /** Returns the object with the settings used for calls to createDataset. */
  public UnaryCallSettings<CreateDatasetRequest, Dataset> createDatasetSettings() {
    return ((DataLabelingServiceStubSettings) getStubSettings()).createDatasetSettings();
  }

  /** Returns the object with the settings used for calls to getDataset. */
  public UnaryCallSettings<GetDatasetRequest, Dataset> getDatasetSettings() {
    return ((DataLabelingServiceStubSettings) getStubSettings()).getDatasetSettings();
  }

  /** Returns the object with the settings used for calls to listDatasets. */
  public PagedCallSettings<ListDatasetsRequest, ListDatasetsResponse, ListDatasetsPagedResponse>
      listDatasetsSettings() {
    return ((DataLabelingServiceStubSettings) getStubSettings()).listDatasetsSettings();
  }

  /** Returns the object with the settings used for calls to deleteDataset. */
  public UnaryCallSettings<DeleteDatasetRequest, Empty> deleteDatasetSettings() {
    return ((DataLabelingServiceStubSettings) getStubSettings()).deleteDatasetSettings();
  }

  /** Returns the object with the settings used for calls to importData. */
  public UnaryCallSettings<ImportDataRequest, Operation> importDataSettings() {
    return ((DataLabelingServiceStubSettings) getStubSettings()).importDataSettings();
  }

  /** Returns the object with the settings used for calls to importData. */
  public OperationCallSettings<
          ImportDataRequest, ImportDataOperationResponse, ImportDataOperationMetadata>
      importDataOperationSettings() {
    return ((DataLabelingServiceStubSettings) getStubSettings()).importDataOperationSettings();
  }

  /** Returns the object with the settings used for calls to exportData. */
  public UnaryCallSettings<ExportDataRequest, Operation> exportDataSettings() {
    return ((DataLabelingServiceStubSettings) getStubSettings()).exportDataSettings();
  }

  /** Returns the object with the settings used for calls to exportData. */
  public OperationCallSettings<
          ExportDataRequest, ExportDataOperationResponse, ExportDataOperationMetadata>
      exportDataOperationSettings() {
    return ((DataLabelingServiceStubSettings) getStubSettings()).exportDataOperationSettings();
  }

  /** Returns the object with the settings used for calls to getDataItem. */
  public UnaryCallSettings<GetDataItemRequest, DataItem> getDataItemSettings() {
    return ((DataLabelingServiceStubSettings) getStubSettings()).getDataItemSettings();
  }

  /** Returns the object with the settings used for calls to listDataItems. */
  public PagedCallSettings<ListDataItemsRequest, ListDataItemsResponse, ListDataItemsPagedResponse>
      listDataItemsSettings() {
    return ((DataLabelingServiceStubSettings) getStubSettings()).listDataItemsSettings();
  }

  /** Returns the object with the settings used for calls to getAnnotatedDataset. */
  public UnaryCallSettings<GetAnnotatedDatasetRequest, AnnotatedDataset>
      getAnnotatedDatasetSettings() {
    return ((DataLabelingServiceStubSettings) getStubSettings()).getAnnotatedDatasetSettings();
  }

  /** Returns the object with the settings used for calls to listAnnotatedDatasets. */
  public PagedCallSettings<
          ListAnnotatedDatasetsRequest,
          ListAnnotatedDatasetsResponse,
          ListAnnotatedDatasetsPagedResponse>
      listAnnotatedDatasetsSettings() {
    return ((DataLabelingServiceStubSettings) getStubSettings()).listAnnotatedDatasetsSettings();
  }

  /** Returns the object with the settings used for calls to deleteAnnotatedDataset. */
  public UnaryCallSettings<DeleteAnnotatedDatasetRequest, Empty> deleteAnnotatedDatasetSettings() {
    return ((DataLabelingServiceStubSettings) getStubSettings()).deleteAnnotatedDatasetSettings();
  }

  /** Returns the object with the settings used for calls to labelImage. */
  public UnaryCallSettings<LabelImageRequest, Operation> labelImageSettings() {
    return ((DataLabelingServiceStubSettings) getStubSettings()).labelImageSettings();
  }

  /** Returns the object with the settings used for calls to labelImage. */
  public OperationCallSettings<LabelImageRequest, AnnotatedDataset, LabelOperationMetadata>
      labelImageOperationSettings() {
    return ((DataLabelingServiceStubSettings) getStubSettings()).labelImageOperationSettings();
  }

  /** Returns the object with the settings used for calls to labelVideo. */
  public UnaryCallSettings<LabelVideoRequest, Operation> labelVideoSettings() {
    return ((DataLabelingServiceStubSettings) getStubSettings()).labelVideoSettings();
  }

  /** Returns the object with the settings used for calls to labelVideo. */
  public OperationCallSettings<LabelVideoRequest, AnnotatedDataset, LabelOperationMetadata>
      labelVideoOperationSettings() {
    return ((DataLabelingServiceStubSettings) getStubSettings()).labelVideoOperationSettings();
  }

  /** Returns the object with the settings used for calls to labelText. */
  public UnaryCallSettings<LabelTextRequest, Operation> labelTextSettings() {
    return ((DataLabelingServiceStubSettings) getStubSettings()).labelTextSettings();
  }

  /** Returns the object with the settings used for calls to labelText. */
  public OperationCallSettings<LabelTextRequest, AnnotatedDataset, LabelOperationMetadata>
      labelTextOperationSettings() {
    return ((DataLabelingServiceStubSettings) getStubSettings()).labelTextOperationSettings();
  }

  /** Returns the object with the settings used for calls to getExample. */
  public UnaryCallSettings<GetExampleRequest, Example> getExampleSettings() {
    return ((DataLabelingServiceStubSettings) getStubSettings()).getExampleSettings();
  }

  /** Returns the object with the settings used for calls to listExamples. */
  public PagedCallSettings<ListExamplesRequest, ListExamplesResponse, ListExamplesPagedResponse>
      listExamplesSettings() {
    return ((DataLabelingServiceStubSettings) getStubSettings()).listExamplesSettings();
  }

  /** Returns the object with the settings used for calls to createAnnotationSpecSet. */
  public UnaryCallSettings<CreateAnnotationSpecSetRequest, AnnotationSpecSet>
      createAnnotationSpecSetSettings() {
    return ((DataLabelingServiceStubSettings) getStubSettings()).createAnnotationSpecSetSettings();
  }

  /** Returns the object with the settings used for calls to getAnnotationSpecSet. */
  public UnaryCallSettings<GetAnnotationSpecSetRequest, AnnotationSpecSet>
      getAnnotationSpecSetSettings() {
    return ((DataLabelingServiceStubSettings) getStubSettings()).getAnnotationSpecSetSettings();
  }

  /** Returns the object with the settings used for calls to listAnnotationSpecSets. */
  public PagedCallSettings<
          ListAnnotationSpecSetsRequest,
          ListAnnotationSpecSetsResponse,
          ListAnnotationSpecSetsPagedResponse>
      listAnnotationSpecSetsSettings() {
    return ((DataLabelingServiceStubSettings) getStubSettings()).listAnnotationSpecSetsSettings();
  }

  /** Returns the object with the settings used for calls to deleteAnnotationSpecSet. */
  public UnaryCallSettings<DeleteAnnotationSpecSetRequest, Empty>
      deleteAnnotationSpecSetSettings() {
    return ((DataLabelingServiceStubSettings) getStubSettings()).deleteAnnotationSpecSetSettings();
  }

  /** Returns the object with the settings used for calls to createInstruction. */
  public UnaryCallSettings<CreateInstructionRequest, Operation> createInstructionSettings() {
    return ((DataLabelingServiceStubSettings) getStubSettings()).createInstructionSettings();
  }

  /** Returns the object with the settings used for calls to createInstruction. */
  public OperationCallSettings<CreateInstructionRequest, Instruction, CreateInstructionMetadata>
      createInstructionOperationSettings() {
    return ((DataLabelingServiceStubSettings) getStubSettings())
        .createInstructionOperationSettings();
  }

  /** Returns the object with the settings used for calls to getInstruction. */
  public UnaryCallSettings<GetInstructionRequest, Instruction> getInstructionSettings() {
    return ((DataLabelingServiceStubSettings) getStubSettings()).getInstructionSettings();
  }

  /** Returns the object with the settings used for calls to listInstructions. */
  public PagedCallSettings<
          ListInstructionsRequest, ListInstructionsResponse, ListInstructionsPagedResponse>
      listInstructionsSettings() {
    return ((DataLabelingServiceStubSettings) getStubSettings()).listInstructionsSettings();
  }

  /** Returns the object with the settings used for calls to deleteInstruction. */
  public UnaryCallSettings<DeleteInstructionRequest, Empty> deleteInstructionSettings() {
    return ((DataLabelingServiceStubSettings) getStubSettings()).deleteInstructionSettings();
  }

  /** Returns the object with the settings used for calls to getEvaluation. */
  public UnaryCallSettings<GetEvaluationRequest, Evaluation> getEvaluationSettings() {
    return ((DataLabelingServiceStubSettings) getStubSettings()).getEvaluationSettings();
  }

  /** Returns the object with the settings used for calls to searchEvaluations. */
  public PagedCallSettings<
          SearchEvaluationsRequest, SearchEvaluationsResponse, SearchEvaluationsPagedResponse>
      searchEvaluationsSettings() {
    return ((DataLabelingServiceStubSettings) getStubSettings()).searchEvaluationsSettings();
  }

  /** Returns the object with the settings used for calls to searchExampleComparisons. */
  public PagedCallSettings<
          SearchExampleComparisonsRequest,
          SearchExampleComparisonsResponse,
          SearchExampleComparisonsPagedResponse>
      searchExampleComparisonsSettings() {
    return ((DataLabelingServiceStubSettings) getStubSettings()).searchExampleComparisonsSettings();
  }

  /** Returns the object with the settings used for calls to createEvaluationJob. */
  public UnaryCallSettings<CreateEvaluationJobRequest, EvaluationJob>
      createEvaluationJobSettings() {
    return ((DataLabelingServiceStubSettings) getStubSettings()).createEvaluationJobSettings();
  }

  /** Returns the object with the settings used for calls to updateEvaluationJob. */
  public UnaryCallSettings<UpdateEvaluationJobRequest, EvaluationJob>
      updateEvaluationJobSettings() {
    return ((DataLabelingServiceStubSettings) getStubSettings()).updateEvaluationJobSettings();
  }

  /** Returns the object with the settings used for calls to getEvaluationJob. */
  public UnaryCallSettings<GetEvaluationJobRequest, EvaluationJob> getEvaluationJobSettings() {
    return ((DataLabelingServiceStubSettings) getStubSettings()).getEvaluationJobSettings();
  }

  /** Returns the object with the settings used for calls to pauseEvaluationJob. */
  public UnaryCallSettings<PauseEvaluationJobRequest, Empty> pauseEvaluationJobSettings() {
    return ((DataLabelingServiceStubSettings) getStubSettings()).pauseEvaluationJobSettings();
  }

  /** Returns the object with the settings used for calls to resumeEvaluationJob. */
  public UnaryCallSettings<ResumeEvaluationJobRequest, Empty> resumeEvaluationJobSettings() {
    return ((DataLabelingServiceStubSettings) getStubSettings()).resumeEvaluationJobSettings();
  }

  /** Returns the object with the settings used for calls to deleteEvaluationJob. */
  public UnaryCallSettings<DeleteEvaluationJobRequest, Empty> deleteEvaluationJobSettings() {
    return ((DataLabelingServiceStubSettings) getStubSettings()).deleteEvaluationJobSettings();
  }

  /** Returns the object with the settings used for calls to listEvaluationJobs. */
  public PagedCallSettings<
          ListEvaluationJobsRequest, ListEvaluationJobsResponse, ListEvaluationJobsPagedResponse>
      listEvaluationJobsSettings() {
    return ((DataLabelingServiceStubSettings) getStubSettings()).listEvaluationJobsSettings();
  }

  public static final DataLabelingServiceSettings create(DataLabelingServiceStubSettings stub)
      throws IOException {
    return new DataLabelingServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return DataLabelingServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return DataLabelingServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DataLabelingServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return DataLabelingServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return DataLabelingServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return DataLabelingServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DataLabelingServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected DataLabelingServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for DataLabelingServiceSettings. */
  public static class Builder extends ClientSettings.Builder<DataLabelingServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(DataLabelingServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(DataLabelingServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(DataLabelingServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(DataLabelingServiceStubSettings.newBuilder());
    }

    public DataLabelingServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((DataLabelingServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createDataset. */
    public UnaryCallSettings.Builder<CreateDatasetRequest, Dataset> createDatasetSettings() {
      return getStubSettingsBuilder().createDatasetSettings();
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
    public UnaryCallSettings.Builder<DeleteDatasetRequest, Empty> deleteDatasetSettings() {
      return getStubSettingsBuilder().deleteDatasetSettings();
    }

    /** Returns the builder for the settings used for calls to importData. */
    public UnaryCallSettings.Builder<ImportDataRequest, Operation> importDataSettings() {
      return getStubSettingsBuilder().importDataSettings();
    }

    /** Returns the builder for the settings used for calls to importData. */
    public OperationCallSettings.Builder<
            ImportDataRequest, ImportDataOperationResponse, ImportDataOperationMetadata>
        importDataOperationSettings() {
      return getStubSettingsBuilder().importDataOperationSettings();
    }

    /** Returns the builder for the settings used for calls to exportData. */
    public UnaryCallSettings.Builder<ExportDataRequest, Operation> exportDataSettings() {
      return getStubSettingsBuilder().exportDataSettings();
    }

    /** Returns the builder for the settings used for calls to exportData. */
    public OperationCallSettings.Builder<
            ExportDataRequest, ExportDataOperationResponse, ExportDataOperationMetadata>
        exportDataOperationSettings() {
      return getStubSettingsBuilder().exportDataOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getDataItem. */
    public UnaryCallSettings.Builder<GetDataItemRequest, DataItem> getDataItemSettings() {
      return getStubSettingsBuilder().getDataItemSettings();
    }

    /** Returns the builder for the settings used for calls to listDataItems. */
    public PagedCallSettings.Builder<
            ListDataItemsRequest, ListDataItemsResponse, ListDataItemsPagedResponse>
        listDataItemsSettings() {
      return getStubSettingsBuilder().listDataItemsSettings();
    }

    /** Returns the builder for the settings used for calls to getAnnotatedDataset. */
    public UnaryCallSettings.Builder<GetAnnotatedDatasetRequest, AnnotatedDataset>
        getAnnotatedDatasetSettings() {
      return getStubSettingsBuilder().getAnnotatedDatasetSettings();
    }

    /** Returns the builder for the settings used for calls to listAnnotatedDatasets. */
    public PagedCallSettings.Builder<
            ListAnnotatedDatasetsRequest,
            ListAnnotatedDatasetsResponse,
            ListAnnotatedDatasetsPagedResponse>
        listAnnotatedDatasetsSettings() {
      return getStubSettingsBuilder().listAnnotatedDatasetsSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAnnotatedDataset. */
    public UnaryCallSettings.Builder<DeleteAnnotatedDatasetRequest, Empty>
        deleteAnnotatedDatasetSettings() {
      return getStubSettingsBuilder().deleteAnnotatedDatasetSettings();
    }

    /** Returns the builder for the settings used for calls to labelImage. */
    public UnaryCallSettings.Builder<LabelImageRequest, Operation> labelImageSettings() {
      return getStubSettingsBuilder().labelImageSettings();
    }

    /** Returns the builder for the settings used for calls to labelImage. */
    public OperationCallSettings.Builder<
            LabelImageRequest, AnnotatedDataset, LabelOperationMetadata>
        labelImageOperationSettings() {
      return getStubSettingsBuilder().labelImageOperationSettings();
    }

    /** Returns the builder for the settings used for calls to labelVideo. */
    public UnaryCallSettings.Builder<LabelVideoRequest, Operation> labelVideoSettings() {
      return getStubSettingsBuilder().labelVideoSettings();
    }

    /** Returns the builder for the settings used for calls to labelVideo. */
    public OperationCallSettings.Builder<
            LabelVideoRequest, AnnotatedDataset, LabelOperationMetadata>
        labelVideoOperationSettings() {
      return getStubSettingsBuilder().labelVideoOperationSettings();
    }

    /** Returns the builder for the settings used for calls to labelText. */
    public UnaryCallSettings.Builder<LabelTextRequest, Operation> labelTextSettings() {
      return getStubSettingsBuilder().labelTextSettings();
    }

    /** Returns the builder for the settings used for calls to labelText. */
    public OperationCallSettings.Builder<LabelTextRequest, AnnotatedDataset, LabelOperationMetadata>
        labelTextOperationSettings() {
      return getStubSettingsBuilder().labelTextOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getExample. */
    public UnaryCallSettings.Builder<GetExampleRequest, Example> getExampleSettings() {
      return getStubSettingsBuilder().getExampleSettings();
    }

    /** Returns the builder for the settings used for calls to listExamples. */
    public PagedCallSettings.Builder<
            ListExamplesRequest, ListExamplesResponse, ListExamplesPagedResponse>
        listExamplesSettings() {
      return getStubSettingsBuilder().listExamplesSettings();
    }

    /** Returns the builder for the settings used for calls to createAnnotationSpecSet. */
    public UnaryCallSettings.Builder<CreateAnnotationSpecSetRequest, AnnotationSpecSet>
        createAnnotationSpecSetSettings() {
      return getStubSettingsBuilder().createAnnotationSpecSetSettings();
    }

    /** Returns the builder for the settings used for calls to getAnnotationSpecSet. */
    public UnaryCallSettings.Builder<GetAnnotationSpecSetRequest, AnnotationSpecSet>
        getAnnotationSpecSetSettings() {
      return getStubSettingsBuilder().getAnnotationSpecSetSettings();
    }

    /** Returns the builder for the settings used for calls to listAnnotationSpecSets. */
    public PagedCallSettings.Builder<
            ListAnnotationSpecSetsRequest,
            ListAnnotationSpecSetsResponse,
            ListAnnotationSpecSetsPagedResponse>
        listAnnotationSpecSetsSettings() {
      return getStubSettingsBuilder().listAnnotationSpecSetsSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAnnotationSpecSet. */
    public UnaryCallSettings.Builder<DeleteAnnotationSpecSetRequest, Empty>
        deleteAnnotationSpecSetSettings() {
      return getStubSettingsBuilder().deleteAnnotationSpecSetSettings();
    }

    /** Returns the builder for the settings used for calls to createInstruction. */
    public UnaryCallSettings.Builder<CreateInstructionRequest, Operation>
        createInstructionSettings() {
      return getStubSettingsBuilder().createInstructionSettings();
    }

    /** Returns the builder for the settings used for calls to createInstruction. */
    public OperationCallSettings.Builder<
            CreateInstructionRequest, Instruction, CreateInstructionMetadata>
        createInstructionOperationSettings() {
      return getStubSettingsBuilder().createInstructionOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getInstruction. */
    public UnaryCallSettings.Builder<GetInstructionRequest, Instruction> getInstructionSettings() {
      return getStubSettingsBuilder().getInstructionSettings();
    }

    /** Returns the builder for the settings used for calls to listInstructions. */
    public PagedCallSettings.Builder<
            ListInstructionsRequest, ListInstructionsResponse, ListInstructionsPagedResponse>
        listInstructionsSettings() {
      return getStubSettingsBuilder().listInstructionsSettings();
    }

    /** Returns the builder for the settings used for calls to deleteInstruction. */
    public UnaryCallSettings.Builder<DeleteInstructionRequest, Empty> deleteInstructionSettings() {
      return getStubSettingsBuilder().deleteInstructionSettings();
    }

    /** Returns the builder for the settings used for calls to getEvaluation. */
    public UnaryCallSettings.Builder<GetEvaluationRequest, Evaluation> getEvaluationSettings() {
      return getStubSettingsBuilder().getEvaluationSettings();
    }

    /** Returns the builder for the settings used for calls to searchEvaluations. */
    public PagedCallSettings.Builder<
            SearchEvaluationsRequest, SearchEvaluationsResponse, SearchEvaluationsPagedResponse>
        searchEvaluationsSettings() {
      return getStubSettingsBuilder().searchEvaluationsSettings();
    }

    /** Returns the builder for the settings used for calls to searchExampleComparisons. */
    public PagedCallSettings.Builder<
            SearchExampleComparisonsRequest,
            SearchExampleComparisonsResponse,
            SearchExampleComparisonsPagedResponse>
        searchExampleComparisonsSettings() {
      return getStubSettingsBuilder().searchExampleComparisonsSettings();
    }

    /** Returns the builder for the settings used for calls to createEvaluationJob. */
    public UnaryCallSettings.Builder<CreateEvaluationJobRequest, EvaluationJob>
        createEvaluationJobSettings() {
      return getStubSettingsBuilder().createEvaluationJobSettings();
    }

    /** Returns the builder for the settings used for calls to updateEvaluationJob. */
    public UnaryCallSettings.Builder<UpdateEvaluationJobRequest, EvaluationJob>
        updateEvaluationJobSettings() {
      return getStubSettingsBuilder().updateEvaluationJobSettings();
    }

    /** Returns the builder for the settings used for calls to getEvaluationJob. */
    public UnaryCallSettings.Builder<GetEvaluationJobRequest, EvaluationJob>
        getEvaluationJobSettings() {
      return getStubSettingsBuilder().getEvaluationJobSettings();
    }

    /** Returns the builder for the settings used for calls to pauseEvaluationJob. */
    public UnaryCallSettings.Builder<PauseEvaluationJobRequest, Empty>
        pauseEvaluationJobSettings() {
      return getStubSettingsBuilder().pauseEvaluationJobSettings();
    }

    /** Returns the builder for the settings used for calls to resumeEvaluationJob. */
    public UnaryCallSettings.Builder<ResumeEvaluationJobRequest, Empty>
        resumeEvaluationJobSettings() {
      return getStubSettingsBuilder().resumeEvaluationJobSettings();
    }

    /** Returns the builder for the settings used for calls to deleteEvaluationJob. */
    public UnaryCallSettings.Builder<DeleteEvaluationJobRequest, Empty>
        deleteEvaluationJobSettings() {
      return getStubSettingsBuilder().deleteEvaluationJobSettings();
    }

    /** Returns the builder for the settings used for calls to listEvaluationJobs. */
    public PagedCallSettings.Builder<
            ListEvaluationJobsRequest, ListEvaluationJobsResponse, ListEvaluationJobsPagedResponse>
        listEvaluationJobsSettings() {
      return getStubSettingsBuilder().listEvaluationJobsSettings();
    }

    @Override
    public DataLabelingServiceSettings build() throws IOException {
      return new DataLabelingServiceSettings(this);
    }
  }
}
