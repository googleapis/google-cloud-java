/*
 * Copyright 2025 Google LLC
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

import static com.google.cloud.aiplatform.v1beta1.DatasetServiceClient.ListAnnotationsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.DatasetServiceClient.ListDataItemsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.DatasetServiceClient.ListDatasetVersionsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.DatasetServiceClient.ListDatasetsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.DatasetServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.DatasetServiceClient.ListSavedQueriesPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.DatasetServiceClient.SearchDataItemsPagedResponse;

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
import com.google.cloud.aiplatform.v1beta1.stub.DatasetServiceStubSettings;
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
 * Settings class to configure an instance of {@link DatasetServiceClient}.
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
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getDataset:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DatasetServiceSettings.Builder datasetServiceSettingsBuilder =
 *     DatasetServiceSettings.newBuilder();
 * datasetServiceSettingsBuilder
 *     .getDatasetSettings()
 *     .setRetrySettings(
 *         datasetServiceSettingsBuilder
 *             .getDatasetSettings()
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
 * DatasetServiceSettings datasetServiceSettings = datasetServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createDataset:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DatasetServiceSettings.Builder datasetServiceSettingsBuilder =
 *     DatasetServiceSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * datasetServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class DatasetServiceSettings extends ClientSettings<DatasetServiceSettings> {

  /** Returns the object with the settings used for calls to createDataset. */
  public UnaryCallSettings<CreateDatasetRequest, Operation> createDatasetSettings() {
    return ((DatasetServiceStubSettings) getStubSettings()).createDatasetSettings();
  }

  /** Returns the object with the settings used for calls to createDataset. */
  public OperationCallSettings<CreateDatasetRequest, Dataset, CreateDatasetOperationMetadata>
      createDatasetOperationSettings() {
    return ((DatasetServiceStubSettings) getStubSettings()).createDatasetOperationSettings();
  }

  /** Returns the object with the settings used for calls to getDataset. */
  public UnaryCallSettings<GetDatasetRequest, Dataset> getDatasetSettings() {
    return ((DatasetServiceStubSettings) getStubSettings()).getDatasetSettings();
  }

  /** Returns the object with the settings used for calls to updateDataset. */
  public UnaryCallSettings<UpdateDatasetRequest, Dataset> updateDatasetSettings() {
    return ((DatasetServiceStubSettings) getStubSettings()).updateDatasetSettings();
  }

  /** Returns the object with the settings used for calls to listDatasets. */
  public PagedCallSettings<ListDatasetsRequest, ListDatasetsResponse, ListDatasetsPagedResponse>
      listDatasetsSettings() {
    return ((DatasetServiceStubSettings) getStubSettings()).listDatasetsSettings();
  }

  /** Returns the object with the settings used for calls to deleteDataset. */
  public UnaryCallSettings<DeleteDatasetRequest, Operation> deleteDatasetSettings() {
    return ((DatasetServiceStubSettings) getStubSettings()).deleteDatasetSettings();
  }

  /** Returns the object with the settings used for calls to deleteDataset. */
  public OperationCallSettings<DeleteDatasetRequest, Empty, DeleteOperationMetadata>
      deleteDatasetOperationSettings() {
    return ((DatasetServiceStubSettings) getStubSettings()).deleteDatasetOperationSettings();
  }

  /** Returns the object with the settings used for calls to importData. */
  public UnaryCallSettings<ImportDataRequest, Operation> importDataSettings() {
    return ((DatasetServiceStubSettings) getStubSettings()).importDataSettings();
  }

  /** Returns the object with the settings used for calls to importData. */
  public OperationCallSettings<ImportDataRequest, ImportDataResponse, ImportDataOperationMetadata>
      importDataOperationSettings() {
    return ((DatasetServiceStubSettings) getStubSettings()).importDataOperationSettings();
  }

  /** Returns the object with the settings used for calls to exportData. */
  public UnaryCallSettings<ExportDataRequest, Operation> exportDataSettings() {
    return ((DatasetServiceStubSettings) getStubSettings()).exportDataSettings();
  }

  /** Returns the object with the settings used for calls to exportData. */
  public OperationCallSettings<ExportDataRequest, ExportDataResponse, ExportDataOperationMetadata>
      exportDataOperationSettings() {
    return ((DatasetServiceStubSettings) getStubSettings()).exportDataOperationSettings();
  }

  /** Returns the object with the settings used for calls to createDatasetVersion. */
  public UnaryCallSettings<CreateDatasetVersionRequest, Operation> createDatasetVersionSettings() {
    return ((DatasetServiceStubSettings) getStubSettings()).createDatasetVersionSettings();
  }

  /** Returns the object with the settings used for calls to createDatasetVersion. */
  public OperationCallSettings<
          CreateDatasetVersionRequest, DatasetVersion, CreateDatasetVersionOperationMetadata>
      createDatasetVersionOperationSettings() {
    return ((DatasetServiceStubSettings) getStubSettings()).createDatasetVersionOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateDatasetVersion. */
  public UnaryCallSettings<UpdateDatasetVersionRequest, DatasetVersion>
      updateDatasetVersionSettings() {
    return ((DatasetServiceStubSettings) getStubSettings()).updateDatasetVersionSettings();
  }

  /** Returns the object with the settings used for calls to deleteDatasetVersion. */
  public UnaryCallSettings<DeleteDatasetVersionRequest, Operation> deleteDatasetVersionSettings() {
    return ((DatasetServiceStubSettings) getStubSettings()).deleteDatasetVersionSettings();
  }

  /** Returns the object with the settings used for calls to deleteDatasetVersion. */
  public OperationCallSettings<DeleteDatasetVersionRequest, Empty, DeleteOperationMetadata>
      deleteDatasetVersionOperationSettings() {
    return ((DatasetServiceStubSettings) getStubSettings()).deleteDatasetVersionOperationSettings();
  }

  /** Returns the object with the settings used for calls to getDatasetVersion. */
  public UnaryCallSettings<GetDatasetVersionRequest, DatasetVersion> getDatasetVersionSettings() {
    return ((DatasetServiceStubSettings) getStubSettings()).getDatasetVersionSettings();
  }

  /** Returns the object with the settings used for calls to listDatasetVersions. */
  public PagedCallSettings<
          ListDatasetVersionsRequest, ListDatasetVersionsResponse, ListDatasetVersionsPagedResponse>
      listDatasetVersionsSettings() {
    return ((DatasetServiceStubSettings) getStubSettings()).listDatasetVersionsSettings();
  }

  /** Returns the object with the settings used for calls to restoreDatasetVersion. */
  public UnaryCallSettings<RestoreDatasetVersionRequest, Operation>
      restoreDatasetVersionSettings() {
    return ((DatasetServiceStubSettings) getStubSettings()).restoreDatasetVersionSettings();
  }

  /** Returns the object with the settings used for calls to restoreDatasetVersion. */
  public OperationCallSettings<
          RestoreDatasetVersionRequest, DatasetVersion, RestoreDatasetVersionOperationMetadata>
      restoreDatasetVersionOperationSettings() {
    return ((DatasetServiceStubSettings) getStubSettings())
        .restoreDatasetVersionOperationSettings();
  }

  /** Returns the object with the settings used for calls to listDataItems. */
  public PagedCallSettings<ListDataItemsRequest, ListDataItemsResponse, ListDataItemsPagedResponse>
      listDataItemsSettings() {
    return ((DatasetServiceStubSettings) getStubSettings()).listDataItemsSettings();
  }

  /** Returns the object with the settings used for calls to searchDataItems. */
  public PagedCallSettings<
          SearchDataItemsRequest, SearchDataItemsResponse, SearchDataItemsPagedResponse>
      searchDataItemsSettings() {
    return ((DatasetServiceStubSettings) getStubSettings()).searchDataItemsSettings();
  }

  /** Returns the object with the settings used for calls to listSavedQueries. */
  public PagedCallSettings<
          ListSavedQueriesRequest, ListSavedQueriesResponse, ListSavedQueriesPagedResponse>
      listSavedQueriesSettings() {
    return ((DatasetServiceStubSettings) getStubSettings()).listSavedQueriesSettings();
  }

  /** Returns the object with the settings used for calls to deleteSavedQuery. */
  public UnaryCallSettings<DeleteSavedQueryRequest, Operation> deleteSavedQuerySettings() {
    return ((DatasetServiceStubSettings) getStubSettings()).deleteSavedQuerySettings();
  }

  /** Returns the object with the settings used for calls to deleteSavedQuery. */
  public OperationCallSettings<DeleteSavedQueryRequest, Empty, DeleteOperationMetadata>
      deleteSavedQueryOperationSettings() {
    return ((DatasetServiceStubSettings) getStubSettings()).deleteSavedQueryOperationSettings();
  }

  /** Returns the object with the settings used for calls to getAnnotationSpec. */
  public UnaryCallSettings<GetAnnotationSpecRequest, AnnotationSpec> getAnnotationSpecSettings() {
    return ((DatasetServiceStubSettings) getStubSettings()).getAnnotationSpecSettings();
  }

  /** Returns the object with the settings used for calls to listAnnotations. */
  public PagedCallSettings<
          ListAnnotationsRequest, ListAnnotationsResponse, ListAnnotationsPagedResponse>
      listAnnotationsSettings() {
    return ((DatasetServiceStubSettings) getStubSettings()).listAnnotationsSettings();
  }

  /** Returns the object with the settings used for calls to assessData. */
  public UnaryCallSettings<AssessDataRequest, Operation> assessDataSettings() {
    return ((DatasetServiceStubSettings) getStubSettings()).assessDataSettings();
  }

  /** Returns the object with the settings used for calls to assessData. */
  public OperationCallSettings<AssessDataRequest, AssessDataResponse, AssessDataOperationMetadata>
      assessDataOperationSettings() {
    return ((DatasetServiceStubSettings) getStubSettings()).assessDataOperationSettings();
  }

  /** Returns the object with the settings used for calls to assembleData. */
  public UnaryCallSettings<AssembleDataRequest, Operation> assembleDataSettings() {
    return ((DatasetServiceStubSettings) getStubSettings()).assembleDataSettings();
  }

  /** Returns the object with the settings used for calls to assembleData. */
  public OperationCallSettings<
          AssembleDataRequest, AssembleDataResponse, AssembleDataOperationMetadata>
      assembleDataOperationSettings() {
    return ((DatasetServiceStubSettings) getStubSettings()).assembleDataOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((DatasetServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((DatasetServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((DatasetServiceStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((DatasetServiceStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((DatasetServiceStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final DatasetServiceSettings create(DatasetServiceStubSettings stub)
      throws IOException {
    return new DatasetServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return DatasetServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return DatasetServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DatasetServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return DatasetServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return DatasetServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return DatasetServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DatasetServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected DatasetServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for DatasetServiceSettings. */
  public static class Builder extends ClientSettings.Builder<DatasetServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(DatasetServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(DatasetServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(DatasetServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(DatasetServiceStubSettings.newBuilder());
    }

    public DatasetServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((DatasetServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createDataset. */
    public UnaryCallSettings.Builder<CreateDatasetRequest, Operation> createDatasetSettings() {
      return getStubSettingsBuilder().createDatasetSettings();
    }

    /** Returns the builder for the settings used for calls to createDataset. */
    public OperationCallSettings.Builder<
            CreateDatasetRequest, Dataset, CreateDatasetOperationMetadata>
        createDatasetOperationSettings() {
      return getStubSettingsBuilder().createDatasetOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getDataset. */
    public UnaryCallSettings.Builder<GetDatasetRequest, Dataset> getDatasetSettings() {
      return getStubSettingsBuilder().getDatasetSettings();
    }

    /** Returns the builder for the settings used for calls to updateDataset. */
    public UnaryCallSettings.Builder<UpdateDatasetRequest, Dataset> updateDatasetSettings() {
      return getStubSettingsBuilder().updateDatasetSettings();
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
    public OperationCallSettings.Builder<DeleteDatasetRequest, Empty, DeleteOperationMetadata>
        deleteDatasetOperationSettings() {
      return getStubSettingsBuilder().deleteDatasetOperationSettings();
    }

    /** Returns the builder for the settings used for calls to importData. */
    public UnaryCallSettings.Builder<ImportDataRequest, Operation> importDataSettings() {
      return getStubSettingsBuilder().importDataSettings();
    }

    /** Returns the builder for the settings used for calls to importData. */
    public OperationCallSettings.Builder<
            ImportDataRequest, ImportDataResponse, ImportDataOperationMetadata>
        importDataOperationSettings() {
      return getStubSettingsBuilder().importDataOperationSettings();
    }

    /** Returns the builder for the settings used for calls to exportData. */
    public UnaryCallSettings.Builder<ExportDataRequest, Operation> exportDataSettings() {
      return getStubSettingsBuilder().exportDataSettings();
    }

    /** Returns the builder for the settings used for calls to exportData. */
    public OperationCallSettings.Builder<
            ExportDataRequest, ExportDataResponse, ExportDataOperationMetadata>
        exportDataOperationSettings() {
      return getStubSettingsBuilder().exportDataOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createDatasetVersion. */
    public UnaryCallSettings.Builder<CreateDatasetVersionRequest, Operation>
        createDatasetVersionSettings() {
      return getStubSettingsBuilder().createDatasetVersionSettings();
    }

    /** Returns the builder for the settings used for calls to createDatasetVersion. */
    public OperationCallSettings.Builder<
            CreateDatasetVersionRequest, DatasetVersion, CreateDatasetVersionOperationMetadata>
        createDatasetVersionOperationSettings() {
      return getStubSettingsBuilder().createDatasetVersionOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateDatasetVersion. */
    public UnaryCallSettings.Builder<UpdateDatasetVersionRequest, DatasetVersion>
        updateDatasetVersionSettings() {
      return getStubSettingsBuilder().updateDatasetVersionSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDatasetVersion. */
    public UnaryCallSettings.Builder<DeleteDatasetVersionRequest, Operation>
        deleteDatasetVersionSettings() {
      return getStubSettingsBuilder().deleteDatasetVersionSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDatasetVersion. */
    public OperationCallSettings.Builder<
            DeleteDatasetVersionRequest, Empty, DeleteOperationMetadata>
        deleteDatasetVersionOperationSettings() {
      return getStubSettingsBuilder().deleteDatasetVersionOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getDatasetVersion. */
    public UnaryCallSettings.Builder<GetDatasetVersionRequest, DatasetVersion>
        getDatasetVersionSettings() {
      return getStubSettingsBuilder().getDatasetVersionSettings();
    }

    /** Returns the builder for the settings used for calls to listDatasetVersions. */
    public PagedCallSettings.Builder<
            ListDatasetVersionsRequest,
            ListDatasetVersionsResponse,
            ListDatasetVersionsPagedResponse>
        listDatasetVersionsSettings() {
      return getStubSettingsBuilder().listDatasetVersionsSettings();
    }

    /** Returns the builder for the settings used for calls to restoreDatasetVersion. */
    public UnaryCallSettings.Builder<RestoreDatasetVersionRequest, Operation>
        restoreDatasetVersionSettings() {
      return getStubSettingsBuilder().restoreDatasetVersionSettings();
    }

    /** Returns the builder for the settings used for calls to restoreDatasetVersion. */
    public OperationCallSettings.Builder<
            RestoreDatasetVersionRequest, DatasetVersion, RestoreDatasetVersionOperationMetadata>
        restoreDatasetVersionOperationSettings() {
      return getStubSettingsBuilder().restoreDatasetVersionOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listDataItems. */
    public PagedCallSettings.Builder<
            ListDataItemsRequest, ListDataItemsResponse, ListDataItemsPagedResponse>
        listDataItemsSettings() {
      return getStubSettingsBuilder().listDataItemsSettings();
    }

    /** Returns the builder for the settings used for calls to searchDataItems. */
    public PagedCallSettings.Builder<
            SearchDataItemsRequest, SearchDataItemsResponse, SearchDataItemsPagedResponse>
        searchDataItemsSettings() {
      return getStubSettingsBuilder().searchDataItemsSettings();
    }

    /** Returns the builder for the settings used for calls to listSavedQueries. */
    public PagedCallSettings.Builder<
            ListSavedQueriesRequest, ListSavedQueriesResponse, ListSavedQueriesPagedResponse>
        listSavedQueriesSettings() {
      return getStubSettingsBuilder().listSavedQueriesSettings();
    }

    /** Returns the builder for the settings used for calls to deleteSavedQuery. */
    public UnaryCallSettings.Builder<DeleteSavedQueryRequest, Operation>
        deleteSavedQuerySettings() {
      return getStubSettingsBuilder().deleteSavedQuerySettings();
    }

    /** Returns the builder for the settings used for calls to deleteSavedQuery. */
    public OperationCallSettings.Builder<DeleteSavedQueryRequest, Empty, DeleteOperationMetadata>
        deleteSavedQueryOperationSettings() {
      return getStubSettingsBuilder().deleteSavedQueryOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getAnnotationSpec. */
    public UnaryCallSettings.Builder<GetAnnotationSpecRequest, AnnotationSpec>
        getAnnotationSpecSettings() {
      return getStubSettingsBuilder().getAnnotationSpecSettings();
    }

    /** Returns the builder for the settings used for calls to listAnnotations. */
    public PagedCallSettings.Builder<
            ListAnnotationsRequest, ListAnnotationsResponse, ListAnnotationsPagedResponse>
        listAnnotationsSettings() {
      return getStubSettingsBuilder().listAnnotationsSettings();
    }

    /** Returns the builder for the settings used for calls to assessData. */
    public UnaryCallSettings.Builder<AssessDataRequest, Operation> assessDataSettings() {
      return getStubSettingsBuilder().assessDataSettings();
    }

    /** Returns the builder for the settings used for calls to assessData. */
    public OperationCallSettings.Builder<
            AssessDataRequest, AssessDataResponse, AssessDataOperationMetadata>
        assessDataOperationSettings() {
      return getStubSettingsBuilder().assessDataOperationSettings();
    }

    /** Returns the builder for the settings used for calls to assembleData. */
    public UnaryCallSettings.Builder<AssembleDataRequest, Operation> assembleDataSettings() {
      return getStubSettingsBuilder().assembleDataSettings();
    }

    /** Returns the builder for the settings used for calls to assembleData. */
    public OperationCallSettings.Builder<
            AssembleDataRequest, AssembleDataResponse, AssembleDataOperationMetadata>
        assembleDataOperationSettings() {
      return getStubSettingsBuilder().assembleDataOperationSettings();
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
    public DatasetServiceSettings build() throws IOException {
      return new DatasetServiceSettings(this);
    }
  }
}
