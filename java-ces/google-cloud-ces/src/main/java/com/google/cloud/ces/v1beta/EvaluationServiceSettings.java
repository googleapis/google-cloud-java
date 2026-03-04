/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.ces.v1beta;

import static com.google.cloud.ces.v1beta.EvaluationServiceClient.ListEvaluationDatasetsPagedResponse;
import static com.google.cloud.ces.v1beta.EvaluationServiceClient.ListEvaluationExpectationsPagedResponse;
import static com.google.cloud.ces.v1beta.EvaluationServiceClient.ListEvaluationResultsPagedResponse;
import static com.google.cloud.ces.v1beta.EvaluationServiceClient.ListEvaluationRunsPagedResponse;
import static com.google.cloud.ces.v1beta.EvaluationServiceClient.ListEvaluationsPagedResponse;
import static com.google.cloud.ces.v1beta.EvaluationServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.ces.v1beta.EvaluationServiceClient.ListScheduledEvaluationRunsPagedResponse;

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
import com.google.cloud.ces.v1beta.stub.EvaluationServiceStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link EvaluationServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (ces.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of uploadEvaluationAudio:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * EvaluationServiceSettings.Builder evaluationServiceSettingsBuilder =
 *     EvaluationServiceSettings.newBuilder();
 * evaluationServiceSettingsBuilder
 *     .uploadEvaluationAudioSettings()
 *     .setRetrySettings(
 *         evaluationServiceSettingsBuilder
 *             .uploadEvaluationAudioSettings()
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
 * EvaluationServiceSettings evaluationServiceSettings = evaluationServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for runEvaluation:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * EvaluationServiceSettings.Builder evaluationServiceSettingsBuilder =
 *     EvaluationServiceSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * evaluationServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class EvaluationServiceSettings extends ClientSettings<EvaluationServiceSettings> {

  /** Returns the object with the settings used for calls to runEvaluation. */
  public UnaryCallSettings<RunEvaluationRequest, Operation> runEvaluationSettings() {
    return ((EvaluationServiceStubSettings) getStubSettings()).runEvaluationSettings();
  }

  /** Returns the object with the settings used for calls to runEvaluation. */
  public OperationCallSettings<
          RunEvaluationRequest, RunEvaluationResponse, RunEvaluationOperationMetadata>
      runEvaluationOperationSettings() {
    return ((EvaluationServiceStubSettings) getStubSettings()).runEvaluationOperationSettings();
  }

  /** Returns the object with the settings used for calls to uploadEvaluationAudio. */
  public UnaryCallSettings<UploadEvaluationAudioRequest, UploadEvaluationAudioResponse>
      uploadEvaluationAudioSettings() {
    return ((EvaluationServiceStubSettings) getStubSettings()).uploadEvaluationAudioSettings();
  }

  /** Returns the object with the settings used for calls to createEvaluation. */
  public UnaryCallSettings<CreateEvaluationRequest, Evaluation> createEvaluationSettings() {
    return ((EvaluationServiceStubSettings) getStubSettings()).createEvaluationSettings();
  }

  /** Returns the object with the settings used for calls to generateEvaluation. */
  public UnaryCallSettings<GenerateEvaluationRequest, Operation> generateEvaluationSettings() {
    return ((EvaluationServiceStubSettings) getStubSettings()).generateEvaluationSettings();
  }

  /** Returns the object with the settings used for calls to generateEvaluation. */
  public OperationCallSettings<
          GenerateEvaluationRequest, Evaluation, GenerateEvaluationOperationMetadata>
      generateEvaluationOperationSettings() {
    return ((EvaluationServiceStubSettings) getStubSettings())
        .generateEvaluationOperationSettings();
  }

  /** Returns the object with the settings used for calls to importEvaluations. */
  public UnaryCallSettings<ImportEvaluationsRequest, Operation> importEvaluationsSettings() {
    return ((EvaluationServiceStubSettings) getStubSettings()).importEvaluationsSettings();
  }

  /** Returns the object with the settings used for calls to importEvaluations. */
  public OperationCallSettings<
          ImportEvaluationsRequest, ImportEvaluationsResponse, ImportEvaluationsOperationMetadata>
      importEvaluationsOperationSettings() {
    return ((EvaluationServiceStubSettings) getStubSettings()).importEvaluationsOperationSettings();
  }

  /** Returns the object with the settings used for calls to createEvaluationDataset. */
  public UnaryCallSettings<CreateEvaluationDatasetRequest, EvaluationDataset>
      createEvaluationDatasetSettings() {
    return ((EvaluationServiceStubSettings) getStubSettings()).createEvaluationDatasetSettings();
  }

  /** Returns the object with the settings used for calls to updateEvaluation. */
  public UnaryCallSettings<UpdateEvaluationRequest, Evaluation> updateEvaluationSettings() {
    return ((EvaluationServiceStubSettings) getStubSettings()).updateEvaluationSettings();
  }

  /** Returns the object with the settings used for calls to updateEvaluationDataset. */
  public UnaryCallSettings<UpdateEvaluationDatasetRequest, EvaluationDataset>
      updateEvaluationDatasetSettings() {
    return ((EvaluationServiceStubSettings) getStubSettings()).updateEvaluationDatasetSettings();
  }

  /** Returns the object with the settings used for calls to deleteEvaluation. */
  public UnaryCallSettings<DeleteEvaluationRequest, Empty> deleteEvaluationSettings() {
    return ((EvaluationServiceStubSettings) getStubSettings()).deleteEvaluationSettings();
  }

  /** Returns the object with the settings used for calls to deleteEvaluationResult. */
  public UnaryCallSettings<DeleteEvaluationResultRequest, Empty> deleteEvaluationResultSettings() {
    return ((EvaluationServiceStubSettings) getStubSettings()).deleteEvaluationResultSettings();
  }

  /** Returns the object with the settings used for calls to deleteEvaluationDataset. */
  public UnaryCallSettings<DeleteEvaluationDatasetRequest, Empty>
      deleteEvaluationDatasetSettings() {
    return ((EvaluationServiceStubSettings) getStubSettings()).deleteEvaluationDatasetSettings();
  }

  /** Returns the object with the settings used for calls to deleteEvaluationRun. */
  public UnaryCallSettings<DeleteEvaluationRunRequest, Operation> deleteEvaluationRunSettings() {
    return ((EvaluationServiceStubSettings) getStubSettings()).deleteEvaluationRunSettings();
  }

  /** Returns the object with the settings used for calls to deleteEvaluationRun. */
  public OperationCallSettings<
          DeleteEvaluationRunRequest, Empty, DeleteEvaluationRunOperationMetadata>
      deleteEvaluationRunOperationSettings() {
    return ((EvaluationServiceStubSettings) getStubSettings())
        .deleteEvaluationRunOperationSettings();
  }

  /** Returns the object with the settings used for calls to getEvaluation. */
  public UnaryCallSettings<GetEvaluationRequest, Evaluation> getEvaluationSettings() {
    return ((EvaluationServiceStubSettings) getStubSettings()).getEvaluationSettings();
  }

  /** Returns the object with the settings used for calls to getEvaluationResult. */
  public UnaryCallSettings<GetEvaluationResultRequest, EvaluationResult>
      getEvaluationResultSettings() {
    return ((EvaluationServiceStubSettings) getStubSettings()).getEvaluationResultSettings();
  }

  /** Returns the object with the settings used for calls to getEvaluationDataset. */
  public UnaryCallSettings<GetEvaluationDatasetRequest, EvaluationDataset>
      getEvaluationDatasetSettings() {
    return ((EvaluationServiceStubSettings) getStubSettings()).getEvaluationDatasetSettings();
  }

  /** Returns the object with the settings used for calls to getEvaluationRun. */
  public UnaryCallSettings<GetEvaluationRunRequest, EvaluationRun> getEvaluationRunSettings() {
    return ((EvaluationServiceStubSettings) getStubSettings()).getEvaluationRunSettings();
  }

  /** Returns the object with the settings used for calls to listEvaluations. */
  public PagedCallSettings<
          ListEvaluationsRequest, ListEvaluationsResponse, ListEvaluationsPagedResponse>
      listEvaluationsSettings() {
    return ((EvaluationServiceStubSettings) getStubSettings()).listEvaluationsSettings();
  }

  /** Returns the object with the settings used for calls to listEvaluationResults. */
  public PagedCallSettings<
          ListEvaluationResultsRequest,
          ListEvaluationResultsResponse,
          ListEvaluationResultsPagedResponse>
      listEvaluationResultsSettings() {
    return ((EvaluationServiceStubSettings) getStubSettings()).listEvaluationResultsSettings();
  }

  /** Returns the object with the settings used for calls to listEvaluationDatasets. */
  public PagedCallSettings<
          ListEvaluationDatasetsRequest,
          ListEvaluationDatasetsResponse,
          ListEvaluationDatasetsPagedResponse>
      listEvaluationDatasetsSettings() {
    return ((EvaluationServiceStubSettings) getStubSettings()).listEvaluationDatasetsSettings();
  }

  /** Returns the object with the settings used for calls to listEvaluationRuns. */
  public PagedCallSettings<
          ListEvaluationRunsRequest, ListEvaluationRunsResponse, ListEvaluationRunsPagedResponse>
      listEvaluationRunsSettings() {
    return ((EvaluationServiceStubSettings) getStubSettings()).listEvaluationRunsSettings();
  }

  /** Returns the object with the settings used for calls to listEvaluationExpectations. */
  public PagedCallSettings<
          ListEvaluationExpectationsRequest,
          ListEvaluationExpectationsResponse,
          ListEvaluationExpectationsPagedResponse>
      listEvaluationExpectationsSettings() {
    return ((EvaluationServiceStubSettings) getStubSettings()).listEvaluationExpectationsSettings();
  }

  /** Returns the object with the settings used for calls to getEvaluationExpectation. */
  public UnaryCallSettings<GetEvaluationExpectationRequest, EvaluationExpectation>
      getEvaluationExpectationSettings() {
    return ((EvaluationServiceStubSettings) getStubSettings()).getEvaluationExpectationSettings();
  }

  /** Returns the object with the settings used for calls to createEvaluationExpectation. */
  public UnaryCallSettings<CreateEvaluationExpectationRequest, EvaluationExpectation>
      createEvaluationExpectationSettings() {
    return ((EvaluationServiceStubSettings) getStubSettings())
        .createEvaluationExpectationSettings();
  }

  /** Returns the object with the settings used for calls to updateEvaluationExpectation. */
  public UnaryCallSettings<UpdateEvaluationExpectationRequest, EvaluationExpectation>
      updateEvaluationExpectationSettings() {
    return ((EvaluationServiceStubSettings) getStubSettings())
        .updateEvaluationExpectationSettings();
  }

  /** Returns the object with the settings used for calls to deleteEvaluationExpectation. */
  public UnaryCallSettings<DeleteEvaluationExpectationRequest, Empty>
      deleteEvaluationExpectationSettings() {
    return ((EvaluationServiceStubSettings) getStubSettings())
        .deleteEvaluationExpectationSettings();
  }

  /** Returns the object with the settings used for calls to createScheduledEvaluationRun. */
  public UnaryCallSettings<CreateScheduledEvaluationRunRequest, ScheduledEvaluationRun>
      createScheduledEvaluationRunSettings() {
    return ((EvaluationServiceStubSettings) getStubSettings())
        .createScheduledEvaluationRunSettings();
  }

  /** Returns the object with the settings used for calls to getScheduledEvaluationRun. */
  public UnaryCallSettings<GetScheduledEvaluationRunRequest, ScheduledEvaluationRun>
      getScheduledEvaluationRunSettings() {
    return ((EvaluationServiceStubSettings) getStubSettings()).getScheduledEvaluationRunSettings();
  }

  /** Returns the object with the settings used for calls to listScheduledEvaluationRuns. */
  public PagedCallSettings<
          ListScheduledEvaluationRunsRequest,
          ListScheduledEvaluationRunsResponse,
          ListScheduledEvaluationRunsPagedResponse>
      listScheduledEvaluationRunsSettings() {
    return ((EvaluationServiceStubSettings) getStubSettings())
        .listScheduledEvaluationRunsSettings();
  }

  /** Returns the object with the settings used for calls to updateScheduledEvaluationRun. */
  public UnaryCallSettings<UpdateScheduledEvaluationRunRequest, ScheduledEvaluationRun>
      updateScheduledEvaluationRunSettings() {
    return ((EvaluationServiceStubSettings) getStubSettings())
        .updateScheduledEvaluationRunSettings();
  }

  /** Returns the object with the settings used for calls to deleteScheduledEvaluationRun. */
  public UnaryCallSettings<DeleteScheduledEvaluationRunRequest, Empty>
      deleteScheduledEvaluationRunSettings() {
    return ((EvaluationServiceStubSettings) getStubSettings())
        .deleteScheduledEvaluationRunSettings();
  }

  /** Returns the object with the settings used for calls to testPersonaVoice. */
  public UnaryCallSettings<TestPersonaVoiceRequest, TestPersonaVoiceResponse>
      testPersonaVoiceSettings() {
    return ((EvaluationServiceStubSettings) getStubSettings()).testPersonaVoiceSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((EvaluationServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((EvaluationServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final EvaluationServiceSettings create(EvaluationServiceStubSettings stub)
      throws IOException {
    return new EvaluationServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return EvaluationServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return EvaluationServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return EvaluationServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return EvaluationServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return EvaluationServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return EvaluationServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return EvaluationServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return EvaluationServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected EvaluationServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for EvaluationServiceSettings. */
  public static class Builder extends ClientSettings.Builder<EvaluationServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(EvaluationServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(EvaluationServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(EvaluationServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(EvaluationServiceStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(EvaluationServiceStubSettings.newHttpJsonBuilder());
    }

    public EvaluationServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((EvaluationServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to runEvaluation. */
    public UnaryCallSettings.Builder<RunEvaluationRequest, Operation> runEvaluationSettings() {
      return getStubSettingsBuilder().runEvaluationSettings();
    }

    /** Returns the builder for the settings used for calls to runEvaluation. */
    public OperationCallSettings.Builder<
            RunEvaluationRequest, RunEvaluationResponse, RunEvaluationOperationMetadata>
        runEvaluationOperationSettings() {
      return getStubSettingsBuilder().runEvaluationOperationSettings();
    }

    /** Returns the builder for the settings used for calls to uploadEvaluationAudio. */
    public UnaryCallSettings.Builder<UploadEvaluationAudioRequest, UploadEvaluationAudioResponse>
        uploadEvaluationAudioSettings() {
      return getStubSettingsBuilder().uploadEvaluationAudioSettings();
    }

    /** Returns the builder for the settings used for calls to createEvaluation. */
    public UnaryCallSettings.Builder<CreateEvaluationRequest, Evaluation>
        createEvaluationSettings() {
      return getStubSettingsBuilder().createEvaluationSettings();
    }

    /** Returns the builder for the settings used for calls to generateEvaluation. */
    public UnaryCallSettings.Builder<GenerateEvaluationRequest, Operation>
        generateEvaluationSettings() {
      return getStubSettingsBuilder().generateEvaluationSettings();
    }

    /** Returns the builder for the settings used for calls to generateEvaluation. */
    public OperationCallSettings.Builder<
            GenerateEvaluationRequest, Evaluation, GenerateEvaluationOperationMetadata>
        generateEvaluationOperationSettings() {
      return getStubSettingsBuilder().generateEvaluationOperationSettings();
    }

    /** Returns the builder for the settings used for calls to importEvaluations. */
    public UnaryCallSettings.Builder<ImportEvaluationsRequest, Operation>
        importEvaluationsSettings() {
      return getStubSettingsBuilder().importEvaluationsSettings();
    }

    /** Returns the builder for the settings used for calls to importEvaluations. */
    public OperationCallSettings.Builder<
            ImportEvaluationsRequest, ImportEvaluationsResponse, ImportEvaluationsOperationMetadata>
        importEvaluationsOperationSettings() {
      return getStubSettingsBuilder().importEvaluationsOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createEvaluationDataset. */
    public UnaryCallSettings.Builder<CreateEvaluationDatasetRequest, EvaluationDataset>
        createEvaluationDatasetSettings() {
      return getStubSettingsBuilder().createEvaluationDatasetSettings();
    }

    /** Returns the builder for the settings used for calls to updateEvaluation. */
    public UnaryCallSettings.Builder<UpdateEvaluationRequest, Evaluation>
        updateEvaluationSettings() {
      return getStubSettingsBuilder().updateEvaluationSettings();
    }

    /** Returns the builder for the settings used for calls to updateEvaluationDataset. */
    public UnaryCallSettings.Builder<UpdateEvaluationDatasetRequest, EvaluationDataset>
        updateEvaluationDatasetSettings() {
      return getStubSettingsBuilder().updateEvaluationDatasetSettings();
    }

    /** Returns the builder for the settings used for calls to deleteEvaluation. */
    public UnaryCallSettings.Builder<DeleteEvaluationRequest, Empty> deleteEvaluationSettings() {
      return getStubSettingsBuilder().deleteEvaluationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteEvaluationResult. */
    public UnaryCallSettings.Builder<DeleteEvaluationResultRequest, Empty>
        deleteEvaluationResultSettings() {
      return getStubSettingsBuilder().deleteEvaluationResultSettings();
    }

    /** Returns the builder for the settings used for calls to deleteEvaluationDataset. */
    public UnaryCallSettings.Builder<DeleteEvaluationDatasetRequest, Empty>
        deleteEvaluationDatasetSettings() {
      return getStubSettingsBuilder().deleteEvaluationDatasetSettings();
    }

    /** Returns the builder for the settings used for calls to deleteEvaluationRun. */
    public UnaryCallSettings.Builder<DeleteEvaluationRunRequest, Operation>
        deleteEvaluationRunSettings() {
      return getStubSettingsBuilder().deleteEvaluationRunSettings();
    }

    /** Returns the builder for the settings used for calls to deleteEvaluationRun. */
    public OperationCallSettings.Builder<
            DeleteEvaluationRunRequest, Empty, DeleteEvaluationRunOperationMetadata>
        deleteEvaluationRunOperationSettings() {
      return getStubSettingsBuilder().deleteEvaluationRunOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getEvaluation. */
    public UnaryCallSettings.Builder<GetEvaluationRequest, Evaluation> getEvaluationSettings() {
      return getStubSettingsBuilder().getEvaluationSettings();
    }

    /** Returns the builder for the settings used for calls to getEvaluationResult. */
    public UnaryCallSettings.Builder<GetEvaluationResultRequest, EvaluationResult>
        getEvaluationResultSettings() {
      return getStubSettingsBuilder().getEvaluationResultSettings();
    }

    /** Returns the builder for the settings used for calls to getEvaluationDataset. */
    public UnaryCallSettings.Builder<GetEvaluationDatasetRequest, EvaluationDataset>
        getEvaluationDatasetSettings() {
      return getStubSettingsBuilder().getEvaluationDatasetSettings();
    }

    /** Returns the builder for the settings used for calls to getEvaluationRun. */
    public UnaryCallSettings.Builder<GetEvaluationRunRequest, EvaluationRun>
        getEvaluationRunSettings() {
      return getStubSettingsBuilder().getEvaluationRunSettings();
    }

    /** Returns the builder for the settings used for calls to listEvaluations. */
    public PagedCallSettings.Builder<
            ListEvaluationsRequest, ListEvaluationsResponse, ListEvaluationsPagedResponse>
        listEvaluationsSettings() {
      return getStubSettingsBuilder().listEvaluationsSettings();
    }

    /** Returns the builder for the settings used for calls to listEvaluationResults. */
    public PagedCallSettings.Builder<
            ListEvaluationResultsRequest,
            ListEvaluationResultsResponse,
            ListEvaluationResultsPagedResponse>
        listEvaluationResultsSettings() {
      return getStubSettingsBuilder().listEvaluationResultsSettings();
    }

    /** Returns the builder for the settings used for calls to listEvaluationDatasets. */
    public PagedCallSettings.Builder<
            ListEvaluationDatasetsRequest,
            ListEvaluationDatasetsResponse,
            ListEvaluationDatasetsPagedResponse>
        listEvaluationDatasetsSettings() {
      return getStubSettingsBuilder().listEvaluationDatasetsSettings();
    }

    /** Returns the builder for the settings used for calls to listEvaluationRuns. */
    public PagedCallSettings.Builder<
            ListEvaluationRunsRequest, ListEvaluationRunsResponse, ListEvaluationRunsPagedResponse>
        listEvaluationRunsSettings() {
      return getStubSettingsBuilder().listEvaluationRunsSettings();
    }

    /** Returns the builder for the settings used for calls to listEvaluationExpectations. */
    public PagedCallSettings.Builder<
            ListEvaluationExpectationsRequest,
            ListEvaluationExpectationsResponse,
            ListEvaluationExpectationsPagedResponse>
        listEvaluationExpectationsSettings() {
      return getStubSettingsBuilder().listEvaluationExpectationsSettings();
    }

    /** Returns the builder for the settings used for calls to getEvaluationExpectation. */
    public UnaryCallSettings.Builder<GetEvaluationExpectationRequest, EvaluationExpectation>
        getEvaluationExpectationSettings() {
      return getStubSettingsBuilder().getEvaluationExpectationSettings();
    }

    /** Returns the builder for the settings used for calls to createEvaluationExpectation. */
    public UnaryCallSettings.Builder<CreateEvaluationExpectationRequest, EvaluationExpectation>
        createEvaluationExpectationSettings() {
      return getStubSettingsBuilder().createEvaluationExpectationSettings();
    }

    /** Returns the builder for the settings used for calls to updateEvaluationExpectation. */
    public UnaryCallSettings.Builder<UpdateEvaluationExpectationRequest, EvaluationExpectation>
        updateEvaluationExpectationSettings() {
      return getStubSettingsBuilder().updateEvaluationExpectationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteEvaluationExpectation. */
    public UnaryCallSettings.Builder<DeleteEvaluationExpectationRequest, Empty>
        deleteEvaluationExpectationSettings() {
      return getStubSettingsBuilder().deleteEvaluationExpectationSettings();
    }

    /** Returns the builder for the settings used for calls to createScheduledEvaluationRun. */
    public UnaryCallSettings.Builder<CreateScheduledEvaluationRunRequest, ScheduledEvaluationRun>
        createScheduledEvaluationRunSettings() {
      return getStubSettingsBuilder().createScheduledEvaluationRunSettings();
    }

    /** Returns the builder for the settings used for calls to getScheduledEvaluationRun. */
    public UnaryCallSettings.Builder<GetScheduledEvaluationRunRequest, ScheduledEvaluationRun>
        getScheduledEvaluationRunSettings() {
      return getStubSettingsBuilder().getScheduledEvaluationRunSettings();
    }

    /** Returns the builder for the settings used for calls to listScheduledEvaluationRuns. */
    public PagedCallSettings.Builder<
            ListScheduledEvaluationRunsRequest,
            ListScheduledEvaluationRunsResponse,
            ListScheduledEvaluationRunsPagedResponse>
        listScheduledEvaluationRunsSettings() {
      return getStubSettingsBuilder().listScheduledEvaluationRunsSettings();
    }

    /** Returns the builder for the settings used for calls to updateScheduledEvaluationRun. */
    public UnaryCallSettings.Builder<UpdateScheduledEvaluationRunRequest, ScheduledEvaluationRun>
        updateScheduledEvaluationRunSettings() {
      return getStubSettingsBuilder().updateScheduledEvaluationRunSettings();
    }

    /** Returns the builder for the settings used for calls to deleteScheduledEvaluationRun. */
    public UnaryCallSettings.Builder<DeleteScheduledEvaluationRunRequest, Empty>
        deleteScheduledEvaluationRunSettings() {
      return getStubSettingsBuilder().deleteScheduledEvaluationRunSettings();
    }

    /** Returns the builder for the settings used for calls to testPersonaVoice. */
    public UnaryCallSettings.Builder<TestPersonaVoiceRequest, TestPersonaVoiceResponse>
        testPersonaVoiceSettings() {
      return getStubSettingsBuilder().testPersonaVoiceSettings();
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return getStubSettingsBuilder().listLocationsSettings();
    }

    /** Returns the builder for the settings used for calls to getLocation. */
    public UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings() {
      return getStubSettingsBuilder().getLocationSettings();
    }

    @Override
    public EvaluationServiceSettings build() throws IOException {
      return new EvaluationServiceSettings(this);
    }
  }
}
