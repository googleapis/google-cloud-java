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

package com.google.cloud.aiplatform.v1beta1;

import static com.google.cloud.aiplatform.v1beta1.JobServiceClient.ListBatchPredictionJobsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.JobServiceClient.ListCustomJobsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.JobServiceClient.ListDataLabelingJobsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.JobServiceClient.ListHyperparameterTuningJobsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.JobServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.JobServiceClient.ListModelDeploymentMonitoringJobsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.JobServiceClient.SearchModelDeploymentMonitoringStatsAnomaliesPagedResponse;

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
import com.google.cloud.aiplatform.v1beta1.stub.JobServiceStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link JobServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (aiplatform.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createCustomJob to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * JobServiceSettings.Builder jobServiceSettingsBuilder = JobServiceSettings.newBuilder();
 * jobServiceSettingsBuilder
 *     .createCustomJobSettings()
 *     .setRetrySettings(
 *         jobServiceSettingsBuilder.createCustomJobSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * JobServiceSettings jobServiceSettings = jobServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class JobServiceSettings extends ClientSettings<JobServiceSettings> {

  /** Returns the object with the settings used for calls to createCustomJob. */
  public UnaryCallSettings<CreateCustomJobRequest, CustomJob> createCustomJobSettings() {
    return ((JobServiceStubSettings) getStubSettings()).createCustomJobSettings();
  }

  /** Returns the object with the settings used for calls to getCustomJob. */
  public UnaryCallSettings<GetCustomJobRequest, CustomJob> getCustomJobSettings() {
    return ((JobServiceStubSettings) getStubSettings()).getCustomJobSettings();
  }

  /** Returns the object with the settings used for calls to listCustomJobs. */
  public PagedCallSettings<
          ListCustomJobsRequest, ListCustomJobsResponse, ListCustomJobsPagedResponse>
      listCustomJobsSettings() {
    return ((JobServiceStubSettings) getStubSettings()).listCustomJobsSettings();
  }

  /** Returns the object with the settings used for calls to deleteCustomJob. */
  public UnaryCallSettings<DeleteCustomJobRequest, Operation> deleteCustomJobSettings() {
    return ((JobServiceStubSettings) getStubSettings()).deleteCustomJobSettings();
  }

  /** Returns the object with the settings used for calls to deleteCustomJob. */
  public OperationCallSettings<DeleteCustomJobRequest, Empty, DeleteOperationMetadata>
      deleteCustomJobOperationSettings() {
    return ((JobServiceStubSettings) getStubSettings()).deleteCustomJobOperationSettings();
  }

  /** Returns the object with the settings used for calls to cancelCustomJob. */
  public UnaryCallSettings<CancelCustomJobRequest, Empty> cancelCustomJobSettings() {
    return ((JobServiceStubSettings) getStubSettings()).cancelCustomJobSettings();
  }

  /** Returns the object with the settings used for calls to createDataLabelingJob. */
  public UnaryCallSettings<CreateDataLabelingJobRequest, DataLabelingJob>
      createDataLabelingJobSettings() {
    return ((JobServiceStubSettings) getStubSettings()).createDataLabelingJobSettings();
  }

  /** Returns the object with the settings used for calls to getDataLabelingJob. */
  public UnaryCallSettings<GetDataLabelingJobRequest, DataLabelingJob>
      getDataLabelingJobSettings() {
    return ((JobServiceStubSettings) getStubSettings()).getDataLabelingJobSettings();
  }

  /** Returns the object with the settings used for calls to listDataLabelingJobs. */
  public PagedCallSettings<
          ListDataLabelingJobsRequest,
          ListDataLabelingJobsResponse,
          ListDataLabelingJobsPagedResponse>
      listDataLabelingJobsSettings() {
    return ((JobServiceStubSettings) getStubSettings()).listDataLabelingJobsSettings();
  }

  /** Returns the object with the settings used for calls to deleteDataLabelingJob. */
  public UnaryCallSettings<DeleteDataLabelingJobRequest, Operation>
      deleteDataLabelingJobSettings() {
    return ((JobServiceStubSettings) getStubSettings()).deleteDataLabelingJobSettings();
  }

  /** Returns the object with the settings used for calls to deleteDataLabelingJob. */
  public OperationCallSettings<DeleteDataLabelingJobRequest, Empty, DeleteOperationMetadata>
      deleteDataLabelingJobOperationSettings() {
    return ((JobServiceStubSettings) getStubSettings()).deleteDataLabelingJobOperationSettings();
  }

  /** Returns the object with the settings used for calls to cancelDataLabelingJob. */
  public UnaryCallSettings<CancelDataLabelingJobRequest, Empty> cancelDataLabelingJobSettings() {
    return ((JobServiceStubSettings) getStubSettings()).cancelDataLabelingJobSettings();
  }

  /** Returns the object with the settings used for calls to createHyperparameterTuningJob. */
  public UnaryCallSettings<CreateHyperparameterTuningJobRequest, HyperparameterTuningJob>
      createHyperparameterTuningJobSettings() {
    return ((JobServiceStubSettings) getStubSettings()).createHyperparameterTuningJobSettings();
  }

  /** Returns the object with the settings used for calls to getHyperparameterTuningJob. */
  public UnaryCallSettings<GetHyperparameterTuningJobRequest, HyperparameterTuningJob>
      getHyperparameterTuningJobSettings() {
    return ((JobServiceStubSettings) getStubSettings()).getHyperparameterTuningJobSettings();
  }

  /** Returns the object with the settings used for calls to listHyperparameterTuningJobs. */
  public PagedCallSettings<
          ListHyperparameterTuningJobsRequest,
          ListHyperparameterTuningJobsResponse,
          ListHyperparameterTuningJobsPagedResponse>
      listHyperparameterTuningJobsSettings() {
    return ((JobServiceStubSettings) getStubSettings()).listHyperparameterTuningJobsSettings();
  }

  /** Returns the object with the settings used for calls to deleteHyperparameterTuningJob. */
  public UnaryCallSettings<DeleteHyperparameterTuningJobRequest, Operation>
      deleteHyperparameterTuningJobSettings() {
    return ((JobServiceStubSettings) getStubSettings()).deleteHyperparameterTuningJobSettings();
  }

  /** Returns the object with the settings used for calls to deleteHyperparameterTuningJob. */
  public OperationCallSettings<DeleteHyperparameterTuningJobRequest, Empty, DeleteOperationMetadata>
      deleteHyperparameterTuningJobOperationSettings() {
    return ((JobServiceStubSettings) getStubSettings())
        .deleteHyperparameterTuningJobOperationSettings();
  }

  /** Returns the object with the settings used for calls to cancelHyperparameterTuningJob. */
  public UnaryCallSettings<CancelHyperparameterTuningJobRequest, Empty>
      cancelHyperparameterTuningJobSettings() {
    return ((JobServiceStubSettings) getStubSettings()).cancelHyperparameterTuningJobSettings();
  }

  /** Returns the object with the settings used for calls to createBatchPredictionJob. */
  public UnaryCallSettings<CreateBatchPredictionJobRequest, BatchPredictionJob>
      createBatchPredictionJobSettings() {
    return ((JobServiceStubSettings) getStubSettings()).createBatchPredictionJobSettings();
  }

  /** Returns the object with the settings used for calls to getBatchPredictionJob. */
  public UnaryCallSettings<GetBatchPredictionJobRequest, BatchPredictionJob>
      getBatchPredictionJobSettings() {
    return ((JobServiceStubSettings) getStubSettings()).getBatchPredictionJobSettings();
  }

  /** Returns the object with the settings used for calls to listBatchPredictionJobs. */
  public PagedCallSettings<
          ListBatchPredictionJobsRequest,
          ListBatchPredictionJobsResponse,
          ListBatchPredictionJobsPagedResponse>
      listBatchPredictionJobsSettings() {
    return ((JobServiceStubSettings) getStubSettings()).listBatchPredictionJobsSettings();
  }

  /** Returns the object with the settings used for calls to deleteBatchPredictionJob. */
  public UnaryCallSettings<DeleteBatchPredictionJobRequest, Operation>
      deleteBatchPredictionJobSettings() {
    return ((JobServiceStubSettings) getStubSettings()).deleteBatchPredictionJobSettings();
  }

  /** Returns the object with the settings used for calls to deleteBatchPredictionJob. */
  public OperationCallSettings<DeleteBatchPredictionJobRequest, Empty, DeleteOperationMetadata>
      deleteBatchPredictionJobOperationSettings() {
    return ((JobServiceStubSettings) getStubSettings()).deleteBatchPredictionJobOperationSettings();
  }

  /** Returns the object with the settings used for calls to cancelBatchPredictionJob. */
  public UnaryCallSettings<CancelBatchPredictionJobRequest, Empty>
      cancelBatchPredictionJobSettings() {
    return ((JobServiceStubSettings) getStubSettings()).cancelBatchPredictionJobSettings();
  }

  /** Returns the object with the settings used for calls to createModelDeploymentMonitoringJob. */
  public UnaryCallSettings<CreateModelDeploymentMonitoringJobRequest, ModelDeploymentMonitoringJob>
      createModelDeploymentMonitoringJobSettings() {
    return ((JobServiceStubSettings) getStubSettings())
        .createModelDeploymentMonitoringJobSettings();
  }

  /**
   * Returns the object with the settings used for calls to
   * searchModelDeploymentMonitoringStatsAnomalies.
   */
  public PagedCallSettings<
          SearchModelDeploymentMonitoringStatsAnomaliesRequest,
          SearchModelDeploymentMonitoringStatsAnomaliesResponse,
          SearchModelDeploymentMonitoringStatsAnomaliesPagedResponse>
      searchModelDeploymentMonitoringStatsAnomaliesSettings() {
    return ((JobServiceStubSettings) getStubSettings())
        .searchModelDeploymentMonitoringStatsAnomaliesSettings();
  }

  /** Returns the object with the settings used for calls to getModelDeploymentMonitoringJob. */
  public UnaryCallSettings<GetModelDeploymentMonitoringJobRequest, ModelDeploymentMonitoringJob>
      getModelDeploymentMonitoringJobSettings() {
    return ((JobServiceStubSettings) getStubSettings()).getModelDeploymentMonitoringJobSettings();
  }

  /** Returns the object with the settings used for calls to listModelDeploymentMonitoringJobs. */
  public PagedCallSettings<
          ListModelDeploymentMonitoringJobsRequest,
          ListModelDeploymentMonitoringJobsResponse,
          ListModelDeploymentMonitoringJobsPagedResponse>
      listModelDeploymentMonitoringJobsSettings() {
    return ((JobServiceStubSettings) getStubSettings()).listModelDeploymentMonitoringJobsSettings();
  }

  /** Returns the object with the settings used for calls to updateModelDeploymentMonitoringJob. */
  public UnaryCallSettings<UpdateModelDeploymentMonitoringJobRequest, Operation>
      updateModelDeploymentMonitoringJobSettings() {
    return ((JobServiceStubSettings) getStubSettings())
        .updateModelDeploymentMonitoringJobSettings();
  }

  /** Returns the object with the settings used for calls to updateModelDeploymentMonitoringJob. */
  public OperationCallSettings<
          UpdateModelDeploymentMonitoringJobRequest,
          ModelDeploymentMonitoringJob,
          UpdateModelDeploymentMonitoringJobOperationMetadata>
      updateModelDeploymentMonitoringJobOperationSettings() {
    return ((JobServiceStubSettings) getStubSettings())
        .updateModelDeploymentMonitoringJobOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteModelDeploymentMonitoringJob. */
  public UnaryCallSettings<DeleteModelDeploymentMonitoringJobRequest, Operation>
      deleteModelDeploymentMonitoringJobSettings() {
    return ((JobServiceStubSettings) getStubSettings())
        .deleteModelDeploymentMonitoringJobSettings();
  }

  /** Returns the object with the settings used for calls to deleteModelDeploymentMonitoringJob. */
  public OperationCallSettings<
          DeleteModelDeploymentMonitoringJobRequest, Empty, DeleteOperationMetadata>
      deleteModelDeploymentMonitoringJobOperationSettings() {
    return ((JobServiceStubSettings) getStubSettings())
        .deleteModelDeploymentMonitoringJobOperationSettings();
  }

  /** Returns the object with the settings used for calls to pauseModelDeploymentMonitoringJob. */
  public UnaryCallSettings<PauseModelDeploymentMonitoringJobRequest, Empty>
      pauseModelDeploymentMonitoringJobSettings() {
    return ((JobServiceStubSettings) getStubSettings()).pauseModelDeploymentMonitoringJobSettings();
  }

  /** Returns the object with the settings used for calls to resumeModelDeploymentMonitoringJob. */
  public UnaryCallSettings<ResumeModelDeploymentMonitoringJobRequest, Empty>
      resumeModelDeploymentMonitoringJobSettings() {
    return ((JobServiceStubSettings) getStubSettings())
        .resumeModelDeploymentMonitoringJobSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((JobServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((JobServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((JobServiceStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((JobServiceStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((JobServiceStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final JobServiceSettings create(JobServiceStubSettings stub) throws IOException {
    return new JobServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return JobServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return JobServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return JobServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return JobServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return JobServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return JobServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return JobServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected JobServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for JobServiceSettings. */
  public static class Builder extends ClientSettings.Builder<JobServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(JobServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(JobServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(JobServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(JobServiceStubSettings.newBuilder());
    }

    public JobServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((JobServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createCustomJob. */
    public UnaryCallSettings.Builder<CreateCustomJobRequest, CustomJob> createCustomJobSettings() {
      return getStubSettingsBuilder().createCustomJobSettings();
    }

    /** Returns the builder for the settings used for calls to getCustomJob. */
    public UnaryCallSettings.Builder<GetCustomJobRequest, CustomJob> getCustomJobSettings() {
      return getStubSettingsBuilder().getCustomJobSettings();
    }

    /** Returns the builder for the settings used for calls to listCustomJobs. */
    public PagedCallSettings.Builder<
            ListCustomJobsRequest, ListCustomJobsResponse, ListCustomJobsPagedResponse>
        listCustomJobsSettings() {
      return getStubSettingsBuilder().listCustomJobsSettings();
    }

    /** Returns the builder for the settings used for calls to deleteCustomJob. */
    public UnaryCallSettings.Builder<DeleteCustomJobRequest, Operation> deleteCustomJobSettings() {
      return getStubSettingsBuilder().deleteCustomJobSettings();
    }

    /** Returns the builder for the settings used for calls to deleteCustomJob. */
    public OperationCallSettings.Builder<DeleteCustomJobRequest, Empty, DeleteOperationMetadata>
        deleteCustomJobOperationSettings() {
      return getStubSettingsBuilder().deleteCustomJobOperationSettings();
    }

    /** Returns the builder for the settings used for calls to cancelCustomJob. */
    public UnaryCallSettings.Builder<CancelCustomJobRequest, Empty> cancelCustomJobSettings() {
      return getStubSettingsBuilder().cancelCustomJobSettings();
    }

    /** Returns the builder for the settings used for calls to createDataLabelingJob. */
    public UnaryCallSettings.Builder<CreateDataLabelingJobRequest, DataLabelingJob>
        createDataLabelingJobSettings() {
      return getStubSettingsBuilder().createDataLabelingJobSettings();
    }

    /** Returns the builder for the settings used for calls to getDataLabelingJob. */
    public UnaryCallSettings.Builder<GetDataLabelingJobRequest, DataLabelingJob>
        getDataLabelingJobSettings() {
      return getStubSettingsBuilder().getDataLabelingJobSettings();
    }

    /** Returns the builder for the settings used for calls to listDataLabelingJobs. */
    public PagedCallSettings.Builder<
            ListDataLabelingJobsRequest,
            ListDataLabelingJobsResponse,
            ListDataLabelingJobsPagedResponse>
        listDataLabelingJobsSettings() {
      return getStubSettingsBuilder().listDataLabelingJobsSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDataLabelingJob. */
    public UnaryCallSettings.Builder<DeleteDataLabelingJobRequest, Operation>
        deleteDataLabelingJobSettings() {
      return getStubSettingsBuilder().deleteDataLabelingJobSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDataLabelingJob. */
    public OperationCallSettings.Builder<
            DeleteDataLabelingJobRequest, Empty, DeleteOperationMetadata>
        deleteDataLabelingJobOperationSettings() {
      return getStubSettingsBuilder().deleteDataLabelingJobOperationSettings();
    }

    /** Returns the builder for the settings used for calls to cancelDataLabelingJob. */
    public UnaryCallSettings.Builder<CancelDataLabelingJobRequest, Empty>
        cancelDataLabelingJobSettings() {
      return getStubSettingsBuilder().cancelDataLabelingJobSettings();
    }

    /** Returns the builder for the settings used for calls to createHyperparameterTuningJob. */
    public UnaryCallSettings.Builder<CreateHyperparameterTuningJobRequest, HyperparameterTuningJob>
        createHyperparameterTuningJobSettings() {
      return getStubSettingsBuilder().createHyperparameterTuningJobSettings();
    }

    /** Returns the builder for the settings used for calls to getHyperparameterTuningJob. */
    public UnaryCallSettings.Builder<GetHyperparameterTuningJobRequest, HyperparameterTuningJob>
        getHyperparameterTuningJobSettings() {
      return getStubSettingsBuilder().getHyperparameterTuningJobSettings();
    }

    /** Returns the builder for the settings used for calls to listHyperparameterTuningJobs. */
    public PagedCallSettings.Builder<
            ListHyperparameterTuningJobsRequest,
            ListHyperparameterTuningJobsResponse,
            ListHyperparameterTuningJobsPagedResponse>
        listHyperparameterTuningJobsSettings() {
      return getStubSettingsBuilder().listHyperparameterTuningJobsSettings();
    }

    /** Returns the builder for the settings used for calls to deleteHyperparameterTuningJob. */
    public UnaryCallSettings.Builder<DeleteHyperparameterTuningJobRequest, Operation>
        deleteHyperparameterTuningJobSettings() {
      return getStubSettingsBuilder().deleteHyperparameterTuningJobSettings();
    }

    /** Returns the builder for the settings used for calls to deleteHyperparameterTuningJob. */
    public OperationCallSettings.Builder<
            DeleteHyperparameterTuningJobRequest, Empty, DeleteOperationMetadata>
        deleteHyperparameterTuningJobOperationSettings() {
      return getStubSettingsBuilder().deleteHyperparameterTuningJobOperationSettings();
    }

    /** Returns the builder for the settings used for calls to cancelHyperparameterTuningJob. */
    public UnaryCallSettings.Builder<CancelHyperparameterTuningJobRequest, Empty>
        cancelHyperparameterTuningJobSettings() {
      return getStubSettingsBuilder().cancelHyperparameterTuningJobSettings();
    }

    /** Returns the builder for the settings used for calls to createBatchPredictionJob. */
    public UnaryCallSettings.Builder<CreateBatchPredictionJobRequest, BatchPredictionJob>
        createBatchPredictionJobSettings() {
      return getStubSettingsBuilder().createBatchPredictionJobSettings();
    }

    /** Returns the builder for the settings used for calls to getBatchPredictionJob. */
    public UnaryCallSettings.Builder<GetBatchPredictionJobRequest, BatchPredictionJob>
        getBatchPredictionJobSettings() {
      return getStubSettingsBuilder().getBatchPredictionJobSettings();
    }

    /** Returns the builder for the settings used for calls to listBatchPredictionJobs. */
    public PagedCallSettings.Builder<
            ListBatchPredictionJobsRequest,
            ListBatchPredictionJobsResponse,
            ListBatchPredictionJobsPagedResponse>
        listBatchPredictionJobsSettings() {
      return getStubSettingsBuilder().listBatchPredictionJobsSettings();
    }

    /** Returns the builder for the settings used for calls to deleteBatchPredictionJob. */
    public UnaryCallSettings.Builder<DeleteBatchPredictionJobRequest, Operation>
        deleteBatchPredictionJobSettings() {
      return getStubSettingsBuilder().deleteBatchPredictionJobSettings();
    }

    /** Returns the builder for the settings used for calls to deleteBatchPredictionJob. */
    public OperationCallSettings.Builder<
            DeleteBatchPredictionJobRequest, Empty, DeleteOperationMetadata>
        deleteBatchPredictionJobOperationSettings() {
      return getStubSettingsBuilder().deleteBatchPredictionJobOperationSettings();
    }

    /** Returns the builder for the settings used for calls to cancelBatchPredictionJob. */
    public UnaryCallSettings.Builder<CancelBatchPredictionJobRequest, Empty>
        cancelBatchPredictionJobSettings() {
      return getStubSettingsBuilder().cancelBatchPredictionJobSettings();
    }

    /**
     * Returns the builder for the settings used for calls to createModelDeploymentMonitoringJob.
     */
    public UnaryCallSettings.Builder<
            CreateModelDeploymentMonitoringJobRequest, ModelDeploymentMonitoringJob>
        createModelDeploymentMonitoringJobSettings() {
      return getStubSettingsBuilder().createModelDeploymentMonitoringJobSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * searchModelDeploymentMonitoringStatsAnomalies.
     */
    public PagedCallSettings.Builder<
            SearchModelDeploymentMonitoringStatsAnomaliesRequest,
            SearchModelDeploymentMonitoringStatsAnomaliesResponse,
            SearchModelDeploymentMonitoringStatsAnomaliesPagedResponse>
        searchModelDeploymentMonitoringStatsAnomaliesSettings() {
      return getStubSettingsBuilder().searchModelDeploymentMonitoringStatsAnomaliesSettings();
    }

    /** Returns the builder for the settings used for calls to getModelDeploymentMonitoringJob. */
    public UnaryCallSettings.Builder<
            GetModelDeploymentMonitoringJobRequest, ModelDeploymentMonitoringJob>
        getModelDeploymentMonitoringJobSettings() {
      return getStubSettingsBuilder().getModelDeploymentMonitoringJobSettings();
    }

    /** Returns the builder for the settings used for calls to listModelDeploymentMonitoringJobs. */
    public PagedCallSettings.Builder<
            ListModelDeploymentMonitoringJobsRequest,
            ListModelDeploymentMonitoringJobsResponse,
            ListModelDeploymentMonitoringJobsPagedResponse>
        listModelDeploymentMonitoringJobsSettings() {
      return getStubSettingsBuilder().listModelDeploymentMonitoringJobsSettings();
    }

    /**
     * Returns the builder for the settings used for calls to updateModelDeploymentMonitoringJob.
     */
    public UnaryCallSettings.Builder<UpdateModelDeploymentMonitoringJobRequest, Operation>
        updateModelDeploymentMonitoringJobSettings() {
      return getStubSettingsBuilder().updateModelDeploymentMonitoringJobSettings();
    }

    /**
     * Returns the builder for the settings used for calls to updateModelDeploymentMonitoringJob.
     */
    public OperationCallSettings.Builder<
            UpdateModelDeploymentMonitoringJobRequest,
            ModelDeploymentMonitoringJob,
            UpdateModelDeploymentMonitoringJobOperationMetadata>
        updateModelDeploymentMonitoringJobOperationSettings() {
      return getStubSettingsBuilder().updateModelDeploymentMonitoringJobOperationSettings();
    }

    /**
     * Returns the builder for the settings used for calls to deleteModelDeploymentMonitoringJob.
     */
    public UnaryCallSettings.Builder<DeleteModelDeploymentMonitoringJobRequest, Operation>
        deleteModelDeploymentMonitoringJobSettings() {
      return getStubSettingsBuilder().deleteModelDeploymentMonitoringJobSettings();
    }

    /**
     * Returns the builder for the settings used for calls to deleteModelDeploymentMonitoringJob.
     */
    public OperationCallSettings.Builder<
            DeleteModelDeploymentMonitoringJobRequest, Empty, DeleteOperationMetadata>
        deleteModelDeploymentMonitoringJobOperationSettings() {
      return getStubSettingsBuilder().deleteModelDeploymentMonitoringJobOperationSettings();
    }

    /** Returns the builder for the settings used for calls to pauseModelDeploymentMonitoringJob. */
    public UnaryCallSettings.Builder<PauseModelDeploymentMonitoringJobRequest, Empty>
        pauseModelDeploymentMonitoringJobSettings() {
      return getStubSettingsBuilder().pauseModelDeploymentMonitoringJobSettings();
    }

    /**
     * Returns the builder for the settings used for calls to resumeModelDeploymentMonitoringJob.
     */
    public UnaryCallSettings.Builder<ResumeModelDeploymentMonitoringJobRequest, Empty>
        resumeModelDeploymentMonitoringJobSettings() {
      return getStubSettingsBuilder().resumeModelDeploymentMonitoringJobSettings();
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

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return getStubSettingsBuilder().setIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getStubSettingsBuilder().getIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return getStubSettingsBuilder().testIamPermissionsSettings();
    }

    @Override
    public JobServiceSettings build() throws IOException {
      return new JobServiceSettings(this);
    }
  }
}
