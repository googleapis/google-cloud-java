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

package com.google.cloud.financialservices.v1.stub;

import static com.google.cloud.financialservices.v1.AMLClient.ListBacktestResultsPagedResponse;
import static com.google.cloud.financialservices.v1.AMLClient.ListDatasetsPagedResponse;
import static com.google.cloud.financialservices.v1.AMLClient.ListEngineConfigsPagedResponse;
import static com.google.cloud.financialservices.v1.AMLClient.ListEngineVersionsPagedResponse;
import static com.google.cloud.financialservices.v1.AMLClient.ListInstancesPagedResponse;
import static com.google.cloud.financialservices.v1.AMLClient.ListLocationsPagedResponse;
import static com.google.cloud.financialservices.v1.AMLClient.ListModelsPagedResponse;
import static com.google.cloud.financialservices.v1.AMLClient.ListPredictionResultsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.core.ObsoleteApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.grpc.ProtoOperationTransformers;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.longrunning.OperationTimedPollAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.financialservices.v1.BacktestResult;
import com.google.cloud.financialservices.v1.CreateBacktestResultRequest;
import com.google.cloud.financialservices.v1.CreateDatasetRequest;
import com.google.cloud.financialservices.v1.CreateEngineConfigRequest;
import com.google.cloud.financialservices.v1.CreateInstanceRequest;
import com.google.cloud.financialservices.v1.CreateModelRequest;
import com.google.cloud.financialservices.v1.CreatePredictionResultRequest;
import com.google.cloud.financialservices.v1.Dataset;
import com.google.cloud.financialservices.v1.DeleteBacktestResultRequest;
import com.google.cloud.financialservices.v1.DeleteDatasetRequest;
import com.google.cloud.financialservices.v1.DeleteEngineConfigRequest;
import com.google.cloud.financialservices.v1.DeleteInstanceRequest;
import com.google.cloud.financialservices.v1.DeleteModelRequest;
import com.google.cloud.financialservices.v1.DeletePredictionResultRequest;
import com.google.cloud.financialservices.v1.EngineConfig;
import com.google.cloud.financialservices.v1.EngineVersion;
import com.google.cloud.financialservices.v1.ExportBacktestResultMetadataRequest;
import com.google.cloud.financialservices.v1.ExportBacktestResultMetadataResponse;
import com.google.cloud.financialservices.v1.ExportEngineConfigMetadataRequest;
import com.google.cloud.financialservices.v1.ExportEngineConfigMetadataResponse;
import com.google.cloud.financialservices.v1.ExportModelMetadataRequest;
import com.google.cloud.financialservices.v1.ExportModelMetadataResponse;
import com.google.cloud.financialservices.v1.ExportPredictionResultMetadataRequest;
import com.google.cloud.financialservices.v1.ExportPredictionResultMetadataResponse;
import com.google.cloud.financialservices.v1.ExportRegisteredPartiesRequest;
import com.google.cloud.financialservices.v1.ExportRegisteredPartiesResponse;
import com.google.cloud.financialservices.v1.GetBacktestResultRequest;
import com.google.cloud.financialservices.v1.GetDatasetRequest;
import com.google.cloud.financialservices.v1.GetEngineConfigRequest;
import com.google.cloud.financialservices.v1.GetEngineVersionRequest;
import com.google.cloud.financialservices.v1.GetInstanceRequest;
import com.google.cloud.financialservices.v1.GetModelRequest;
import com.google.cloud.financialservices.v1.GetPredictionResultRequest;
import com.google.cloud.financialservices.v1.ImportRegisteredPartiesRequest;
import com.google.cloud.financialservices.v1.ImportRegisteredPartiesResponse;
import com.google.cloud.financialservices.v1.Instance;
import com.google.cloud.financialservices.v1.ListBacktestResultsRequest;
import com.google.cloud.financialservices.v1.ListBacktestResultsResponse;
import com.google.cloud.financialservices.v1.ListDatasetsRequest;
import com.google.cloud.financialservices.v1.ListDatasetsResponse;
import com.google.cloud.financialservices.v1.ListEngineConfigsRequest;
import com.google.cloud.financialservices.v1.ListEngineConfigsResponse;
import com.google.cloud.financialservices.v1.ListEngineVersionsRequest;
import com.google.cloud.financialservices.v1.ListEngineVersionsResponse;
import com.google.cloud.financialservices.v1.ListInstancesRequest;
import com.google.cloud.financialservices.v1.ListInstancesResponse;
import com.google.cloud.financialservices.v1.ListModelsRequest;
import com.google.cloud.financialservices.v1.ListModelsResponse;
import com.google.cloud.financialservices.v1.ListPredictionResultsRequest;
import com.google.cloud.financialservices.v1.ListPredictionResultsResponse;
import com.google.cloud.financialservices.v1.Model;
import com.google.cloud.financialservices.v1.OperationMetadata;
import com.google.cloud.financialservices.v1.PredictionResult;
import com.google.cloud.financialservices.v1.UpdateBacktestResultRequest;
import com.google.cloud.financialservices.v1.UpdateDatasetRequest;
import com.google.cloud.financialservices.v1.UpdateEngineConfigRequest;
import com.google.cloud.financialservices.v1.UpdateInstanceRequest;
import com.google.cloud.financialservices.v1.UpdateModelRequest;
import com.google.cloud.financialservices.v1.UpdatePredictionResultRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link AMLStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (financialservices.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getInstance:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AMLStubSettings.Builder aMLSettingsBuilder = AMLStubSettings.newBuilder();
 * aMLSettingsBuilder
 *     .getInstanceSettings()
 *     .setRetrySettings(
 *         aMLSettingsBuilder
 *             .getInstanceSettings()
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
 * AMLStubSettings aMLSettings = aMLSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createInstance:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AMLStubSettings.Builder aMLSettingsBuilder = AMLStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * aMLSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class AMLStubSettings extends StubSettings<AMLStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>
      listInstancesSettings;
  private final UnaryCallSettings<GetInstanceRequest, Instance> getInstanceSettings;
  private final UnaryCallSettings<CreateInstanceRequest, Operation> createInstanceSettings;
  private final OperationCallSettings<CreateInstanceRequest, Instance, OperationMetadata>
      createInstanceOperationSettings;
  private final UnaryCallSettings<UpdateInstanceRequest, Operation> updateInstanceSettings;
  private final OperationCallSettings<UpdateInstanceRequest, Instance, OperationMetadata>
      updateInstanceOperationSettings;
  private final UnaryCallSettings<DeleteInstanceRequest, Operation> deleteInstanceSettings;
  private final OperationCallSettings<DeleteInstanceRequest, Empty, OperationMetadata>
      deleteInstanceOperationSettings;
  private final UnaryCallSettings<ImportRegisteredPartiesRequest, Operation>
      importRegisteredPartiesSettings;
  private final OperationCallSettings<
          ImportRegisteredPartiesRequest, ImportRegisteredPartiesResponse, OperationMetadata>
      importRegisteredPartiesOperationSettings;
  private final UnaryCallSettings<ExportRegisteredPartiesRequest, Operation>
      exportRegisteredPartiesSettings;
  private final OperationCallSettings<
          ExportRegisteredPartiesRequest, ExportRegisteredPartiesResponse, OperationMetadata>
      exportRegisteredPartiesOperationSettings;
  private final PagedCallSettings<
          ListDatasetsRequest, ListDatasetsResponse, ListDatasetsPagedResponse>
      listDatasetsSettings;
  private final UnaryCallSettings<GetDatasetRequest, Dataset> getDatasetSettings;
  private final UnaryCallSettings<CreateDatasetRequest, Operation> createDatasetSettings;
  private final OperationCallSettings<CreateDatasetRequest, Dataset, OperationMetadata>
      createDatasetOperationSettings;
  private final UnaryCallSettings<UpdateDatasetRequest, Operation> updateDatasetSettings;
  private final OperationCallSettings<UpdateDatasetRequest, Dataset, OperationMetadata>
      updateDatasetOperationSettings;
  private final UnaryCallSettings<DeleteDatasetRequest, Operation> deleteDatasetSettings;
  private final OperationCallSettings<DeleteDatasetRequest, Empty, OperationMetadata>
      deleteDatasetOperationSettings;
  private final PagedCallSettings<ListModelsRequest, ListModelsResponse, ListModelsPagedResponse>
      listModelsSettings;
  private final UnaryCallSettings<GetModelRequest, Model> getModelSettings;
  private final UnaryCallSettings<CreateModelRequest, Operation> createModelSettings;
  private final OperationCallSettings<CreateModelRequest, Model, OperationMetadata>
      createModelOperationSettings;
  private final UnaryCallSettings<UpdateModelRequest, Operation> updateModelSettings;
  private final OperationCallSettings<UpdateModelRequest, Model, OperationMetadata>
      updateModelOperationSettings;
  private final UnaryCallSettings<ExportModelMetadataRequest, Operation>
      exportModelMetadataSettings;
  private final OperationCallSettings<
          ExportModelMetadataRequest, ExportModelMetadataResponse, OperationMetadata>
      exportModelMetadataOperationSettings;
  private final UnaryCallSettings<DeleteModelRequest, Operation> deleteModelSettings;
  private final OperationCallSettings<DeleteModelRequest, Empty, OperationMetadata>
      deleteModelOperationSettings;
  private final PagedCallSettings<
          ListEngineConfigsRequest, ListEngineConfigsResponse, ListEngineConfigsPagedResponse>
      listEngineConfigsSettings;
  private final UnaryCallSettings<GetEngineConfigRequest, EngineConfig> getEngineConfigSettings;
  private final UnaryCallSettings<CreateEngineConfigRequest, Operation> createEngineConfigSettings;
  private final OperationCallSettings<CreateEngineConfigRequest, EngineConfig, OperationMetadata>
      createEngineConfigOperationSettings;
  private final UnaryCallSettings<UpdateEngineConfigRequest, Operation> updateEngineConfigSettings;
  private final OperationCallSettings<UpdateEngineConfigRequest, EngineConfig, OperationMetadata>
      updateEngineConfigOperationSettings;
  private final UnaryCallSettings<ExportEngineConfigMetadataRequest, Operation>
      exportEngineConfigMetadataSettings;
  private final OperationCallSettings<
          ExportEngineConfigMetadataRequest, ExportEngineConfigMetadataResponse, OperationMetadata>
      exportEngineConfigMetadataOperationSettings;
  private final UnaryCallSettings<DeleteEngineConfigRequest, Operation> deleteEngineConfigSettings;
  private final OperationCallSettings<DeleteEngineConfigRequest, Empty, OperationMetadata>
      deleteEngineConfigOperationSettings;
  private final UnaryCallSettings<GetEngineVersionRequest, EngineVersion> getEngineVersionSettings;
  private final PagedCallSettings<
          ListEngineVersionsRequest, ListEngineVersionsResponse, ListEngineVersionsPagedResponse>
      listEngineVersionsSettings;
  private final PagedCallSettings<
          ListPredictionResultsRequest,
          ListPredictionResultsResponse,
          ListPredictionResultsPagedResponse>
      listPredictionResultsSettings;
  private final UnaryCallSettings<GetPredictionResultRequest, PredictionResult>
      getPredictionResultSettings;
  private final UnaryCallSettings<CreatePredictionResultRequest, Operation>
      createPredictionResultSettings;
  private final OperationCallSettings<
          CreatePredictionResultRequest, PredictionResult, OperationMetadata>
      createPredictionResultOperationSettings;
  private final UnaryCallSettings<UpdatePredictionResultRequest, Operation>
      updatePredictionResultSettings;
  private final OperationCallSettings<
          UpdatePredictionResultRequest, PredictionResult, OperationMetadata>
      updatePredictionResultOperationSettings;
  private final UnaryCallSettings<ExportPredictionResultMetadataRequest, Operation>
      exportPredictionResultMetadataSettings;
  private final OperationCallSettings<
          ExportPredictionResultMetadataRequest,
          ExportPredictionResultMetadataResponse,
          OperationMetadata>
      exportPredictionResultMetadataOperationSettings;
  private final UnaryCallSettings<DeletePredictionResultRequest, Operation>
      deletePredictionResultSettings;
  private final OperationCallSettings<DeletePredictionResultRequest, Empty, OperationMetadata>
      deletePredictionResultOperationSettings;
  private final PagedCallSettings<
          ListBacktestResultsRequest, ListBacktestResultsResponse, ListBacktestResultsPagedResponse>
      listBacktestResultsSettings;
  private final UnaryCallSettings<GetBacktestResultRequest, BacktestResult>
      getBacktestResultSettings;
  private final UnaryCallSettings<CreateBacktestResultRequest, Operation>
      createBacktestResultSettings;
  private final OperationCallSettings<
          CreateBacktestResultRequest, BacktestResult, OperationMetadata>
      createBacktestResultOperationSettings;
  private final UnaryCallSettings<UpdateBacktestResultRequest, Operation>
      updateBacktestResultSettings;
  private final OperationCallSettings<
          UpdateBacktestResultRequest, BacktestResult, OperationMetadata>
      updateBacktestResultOperationSettings;
  private final UnaryCallSettings<ExportBacktestResultMetadataRequest, Operation>
      exportBacktestResultMetadataSettings;
  private final OperationCallSettings<
          ExportBacktestResultMetadataRequest,
          ExportBacktestResultMetadataResponse,
          OperationMetadata>
      exportBacktestResultMetadataOperationSettings;
  private final UnaryCallSettings<DeleteBacktestResultRequest, Operation>
      deleteBacktestResultSettings;
  private final OperationCallSettings<DeleteBacktestResultRequest, Empty, OperationMetadata>
      deleteBacktestResultOperationSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

  private static final PagedListDescriptor<ListInstancesRequest, ListInstancesResponse, Instance>
      LIST_INSTANCES_PAGE_STR_DESC =
          new PagedListDescriptor<ListInstancesRequest, ListInstancesResponse, Instance>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListInstancesRequest injectToken(ListInstancesRequest payload, String token) {
              return ListInstancesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListInstancesRequest injectPageSize(ListInstancesRequest payload, int pageSize) {
              return ListInstancesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListInstancesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListInstancesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Instance> extractResources(ListInstancesResponse payload) {
              return payload.getInstancesList();
            }
          };

  private static final PagedListDescriptor<ListDatasetsRequest, ListDatasetsResponse, Dataset>
      LIST_DATASETS_PAGE_STR_DESC =
          new PagedListDescriptor<ListDatasetsRequest, ListDatasetsResponse, Dataset>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDatasetsRequest injectToken(ListDatasetsRequest payload, String token) {
              return ListDatasetsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDatasetsRequest injectPageSize(ListDatasetsRequest payload, int pageSize) {
              return ListDatasetsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListDatasetsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDatasetsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Dataset> extractResources(ListDatasetsResponse payload) {
              return payload.getDatasetsList();
            }
          };

  private static final PagedListDescriptor<ListModelsRequest, ListModelsResponse, Model>
      LIST_MODELS_PAGE_STR_DESC =
          new PagedListDescriptor<ListModelsRequest, ListModelsResponse, Model>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListModelsRequest injectToken(ListModelsRequest payload, String token) {
              return ListModelsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListModelsRequest injectPageSize(ListModelsRequest payload, int pageSize) {
              return ListModelsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListModelsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListModelsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Model> extractResources(ListModelsResponse payload) {
              return payload.getModelsList();
            }
          };

  private static final PagedListDescriptor<
          ListEngineConfigsRequest, ListEngineConfigsResponse, EngineConfig>
      LIST_ENGINE_CONFIGS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListEngineConfigsRequest, ListEngineConfigsResponse, EngineConfig>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListEngineConfigsRequest injectToken(
                ListEngineConfigsRequest payload, String token) {
              return ListEngineConfigsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListEngineConfigsRequest injectPageSize(
                ListEngineConfigsRequest payload, int pageSize) {
              return ListEngineConfigsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListEngineConfigsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListEngineConfigsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<EngineConfig> extractResources(ListEngineConfigsResponse payload) {
              return payload.getEngineConfigsList();
            }
          };

  private static final PagedListDescriptor<
          ListEngineVersionsRequest, ListEngineVersionsResponse, EngineVersion>
      LIST_ENGINE_VERSIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListEngineVersionsRequest, ListEngineVersionsResponse, EngineVersion>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListEngineVersionsRequest injectToken(
                ListEngineVersionsRequest payload, String token) {
              return ListEngineVersionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListEngineVersionsRequest injectPageSize(
                ListEngineVersionsRequest payload, int pageSize) {
              return ListEngineVersionsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListEngineVersionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListEngineVersionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<EngineVersion> extractResources(ListEngineVersionsResponse payload) {
              return payload.getEngineVersionsList();
            }
          };

  private static final PagedListDescriptor<
          ListPredictionResultsRequest, ListPredictionResultsResponse, PredictionResult>
      LIST_PREDICTION_RESULTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListPredictionResultsRequest, ListPredictionResultsResponse, PredictionResult>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListPredictionResultsRequest injectToken(
                ListPredictionResultsRequest payload, String token) {
              return ListPredictionResultsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListPredictionResultsRequest injectPageSize(
                ListPredictionResultsRequest payload, int pageSize) {
              return ListPredictionResultsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListPredictionResultsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListPredictionResultsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<PredictionResult> extractResources(
                ListPredictionResultsResponse payload) {
              return payload.getPredictionResultsList();
            }
          };

  private static final PagedListDescriptor<
          ListBacktestResultsRequest, ListBacktestResultsResponse, BacktestResult>
      LIST_BACKTEST_RESULTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListBacktestResultsRequest, ListBacktestResultsResponse, BacktestResult>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListBacktestResultsRequest injectToken(
                ListBacktestResultsRequest payload, String token) {
              return ListBacktestResultsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListBacktestResultsRequest injectPageSize(
                ListBacktestResultsRequest payload, int pageSize) {
              return ListBacktestResultsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListBacktestResultsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListBacktestResultsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<BacktestResult> extractResources(ListBacktestResultsResponse payload) {
              return payload.getBacktestResultsList();
            }
          };

  private static final PagedListDescriptor<ListLocationsRequest, ListLocationsResponse, Location>
      LIST_LOCATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListLocationsRequest, ListLocationsResponse, Location>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListLocationsRequest injectToken(ListLocationsRequest payload, String token) {
              return ListLocationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListLocationsRequest injectPageSize(ListLocationsRequest payload, int pageSize) {
              return ListLocationsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListLocationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListLocationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Location> extractResources(ListLocationsResponse payload) {
              return payload.getLocationsList();
            }
          };

  private static final PagedListResponseFactory<
          ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>
      LIST_INSTANCES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>() {
            @Override
            public ApiFuture<ListInstancesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListInstancesRequest, ListInstancesResponse> callable,
                ListInstancesRequest request,
                ApiCallContext context,
                ApiFuture<ListInstancesResponse> futureResponse) {
              PageContext<ListInstancesRequest, ListInstancesResponse, Instance> pageContext =
                  PageContext.create(callable, LIST_INSTANCES_PAGE_STR_DESC, request, context);
              return ListInstancesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListDatasetsRequest, ListDatasetsResponse, ListDatasetsPagedResponse>
      LIST_DATASETS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDatasetsRequest, ListDatasetsResponse, ListDatasetsPagedResponse>() {
            @Override
            public ApiFuture<ListDatasetsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDatasetsRequest, ListDatasetsResponse> callable,
                ListDatasetsRequest request,
                ApiCallContext context,
                ApiFuture<ListDatasetsResponse> futureResponse) {
              PageContext<ListDatasetsRequest, ListDatasetsResponse, Dataset> pageContext =
                  PageContext.create(callable, LIST_DATASETS_PAGE_STR_DESC, request, context);
              return ListDatasetsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListModelsRequest, ListModelsResponse, ListModelsPagedResponse>
      LIST_MODELS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListModelsRequest, ListModelsResponse, ListModelsPagedResponse>() {
            @Override
            public ApiFuture<ListModelsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListModelsRequest, ListModelsResponse> callable,
                ListModelsRequest request,
                ApiCallContext context,
                ApiFuture<ListModelsResponse> futureResponse) {
              PageContext<ListModelsRequest, ListModelsResponse, Model> pageContext =
                  PageContext.create(callable, LIST_MODELS_PAGE_STR_DESC, request, context);
              return ListModelsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListEngineConfigsRequest, ListEngineConfigsResponse, ListEngineConfigsPagedResponse>
      LIST_ENGINE_CONFIGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListEngineConfigsRequest,
              ListEngineConfigsResponse,
              ListEngineConfigsPagedResponse>() {
            @Override
            public ApiFuture<ListEngineConfigsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListEngineConfigsRequest, ListEngineConfigsResponse> callable,
                ListEngineConfigsRequest request,
                ApiCallContext context,
                ApiFuture<ListEngineConfigsResponse> futureResponse) {
              PageContext<ListEngineConfigsRequest, ListEngineConfigsResponse, EngineConfig>
                  pageContext =
                      PageContext.create(
                          callable, LIST_ENGINE_CONFIGS_PAGE_STR_DESC, request, context);
              return ListEngineConfigsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListEngineVersionsRequest, ListEngineVersionsResponse, ListEngineVersionsPagedResponse>
      LIST_ENGINE_VERSIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListEngineVersionsRequest,
              ListEngineVersionsResponse,
              ListEngineVersionsPagedResponse>() {
            @Override
            public ApiFuture<ListEngineVersionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListEngineVersionsRequest, ListEngineVersionsResponse> callable,
                ListEngineVersionsRequest request,
                ApiCallContext context,
                ApiFuture<ListEngineVersionsResponse> futureResponse) {
              PageContext<ListEngineVersionsRequest, ListEngineVersionsResponse, EngineVersion>
                  pageContext =
                      PageContext.create(
                          callable, LIST_ENGINE_VERSIONS_PAGE_STR_DESC, request, context);
              return ListEngineVersionsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListPredictionResultsRequest,
          ListPredictionResultsResponse,
          ListPredictionResultsPagedResponse>
      LIST_PREDICTION_RESULTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListPredictionResultsRequest,
              ListPredictionResultsResponse,
              ListPredictionResultsPagedResponse>() {
            @Override
            public ApiFuture<ListPredictionResultsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListPredictionResultsRequest, ListPredictionResultsResponse> callable,
                ListPredictionResultsRequest request,
                ApiCallContext context,
                ApiFuture<ListPredictionResultsResponse> futureResponse) {
              PageContext<
                      ListPredictionResultsRequest, ListPredictionResultsResponse, PredictionResult>
                  pageContext =
                      PageContext.create(
                          callable, LIST_PREDICTION_RESULTS_PAGE_STR_DESC, request, context);
              return ListPredictionResultsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListBacktestResultsRequest, ListBacktestResultsResponse, ListBacktestResultsPagedResponse>
      LIST_BACKTEST_RESULTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListBacktestResultsRequest,
              ListBacktestResultsResponse,
              ListBacktestResultsPagedResponse>() {
            @Override
            public ApiFuture<ListBacktestResultsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListBacktestResultsRequest, ListBacktestResultsResponse> callable,
                ListBacktestResultsRequest request,
                ApiCallContext context,
                ApiFuture<ListBacktestResultsResponse> futureResponse) {
              PageContext<ListBacktestResultsRequest, ListBacktestResultsResponse, BacktestResult>
                  pageContext =
                      PageContext.create(
                          callable, LIST_BACKTEST_RESULTS_PAGE_STR_DESC, request, context);
              return ListBacktestResultsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      LIST_LOCATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>() {
            @Override
            public ApiFuture<ListLocationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListLocationsRequest, ListLocationsResponse> callable,
                ListLocationsRequest request,
                ApiCallContext context,
                ApiFuture<ListLocationsResponse> futureResponse) {
              PageContext<ListLocationsRequest, ListLocationsResponse, Location> pageContext =
                  PageContext.create(callable, LIST_LOCATIONS_PAGE_STR_DESC, request, context);
              return ListLocationsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listInstances. */
  public PagedCallSettings<ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>
      listInstancesSettings() {
    return listInstancesSettings;
  }

  /** Returns the object with the settings used for calls to getInstance. */
  public UnaryCallSettings<GetInstanceRequest, Instance> getInstanceSettings() {
    return getInstanceSettings;
  }

  /** Returns the object with the settings used for calls to createInstance. */
  public UnaryCallSettings<CreateInstanceRequest, Operation> createInstanceSettings() {
    return createInstanceSettings;
  }

  /** Returns the object with the settings used for calls to createInstance. */
  public OperationCallSettings<CreateInstanceRequest, Instance, OperationMetadata>
      createInstanceOperationSettings() {
    return createInstanceOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateInstance. */
  public UnaryCallSettings<UpdateInstanceRequest, Operation> updateInstanceSettings() {
    return updateInstanceSettings;
  }

  /** Returns the object with the settings used for calls to updateInstance. */
  public OperationCallSettings<UpdateInstanceRequest, Instance, OperationMetadata>
      updateInstanceOperationSettings() {
    return updateInstanceOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteInstance. */
  public UnaryCallSettings<DeleteInstanceRequest, Operation> deleteInstanceSettings() {
    return deleteInstanceSettings;
  }

  /** Returns the object with the settings used for calls to deleteInstance. */
  public OperationCallSettings<DeleteInstanceRequest, Empty, OperationMetadata>
      deleteInstanceOperationSettings() {
    return deleteInstanceOperationSettings;
  }

  /** Returns the object with the settings used for calls to importRegisteredParties. */
  public UnaryCallSettings<ImportRegisteredPartiesRequest, Operation>
      importRegisteredPartiesSettings() {
    return importRegisteredPartiesSettings;
  }

  /** Returns the object with the settings used for calls to importRegisteredParties. */
  public OperationCallSettings<
          ImportRegisteredPartiesRequest, ImportRegisteredPartiesResponse, OperationMetadata>
      importRegisteredPartiesOperationSettings() {
    return importRegisteredPartiesOperationSettings;
  }

  /** Returns the object with the settings used for calls to exportRegisteredParties. */
  public UnaryCallSettings<ExportRegisteredPartiesRequest, Operation>
      exportRegisteredPartiesSettings() {
    return exportRegisteredPartiesSettings;
  }

  /** Returns the object with the settings used for calls to exportRegisteredParties. */
  public OperationCallSettings<
          ExportRegisteredPartiesRequest, ExportRegisteredPartiesResponse, OperationMetadata>
      exportRegisteredPartiesOperationSettings() {
    return exportRegisteredPartiesOperationSettings;
  }

  /** Returns the object with the settings used for calls to listDatasets. */
  public PagedCallSettings<ListDatasetsRequest, ListDatasetsResponse, ListDatasetsPagedResponse>
      listDatasetsSettings() {
    return listDatasetsSettings;
  }

  /** Returns the object with the settings used for calls to getDataset. */
  public UnaryCallSettings<GetDatasetRequest, Dataset> getDatasetSettings() {
    return getDatasetSettings;
  }

  /** Returns the object with the settings used for calls to createDataset. */
  public UnaryCallSettings<CreateDatasetRequest, Operation> createDatasetSettings() {
    return createDatasetSettings;
  }

  /** Returns the object with the settings used for calls to createDataset. */
  public OperationCallSettings<CreateDatasetRequest, Dataset, OperationMetadata>
      createDatasetOperationSettings() {
    return createDatasetOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateDataset. */
  public UnaryCallSettings<UpdateDatasetRequest, Operation> updateDatasetSettings() {
    return updateDatasetSettings;
  }

  /** Returns the object with the settings used for calls to updateDataset. */
  public OperationCallSettings<UpdateDatasetRequest, Dataset, OperationMetadata>
      updateDatasetOperationSettings() {
    return updateDatasetOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteDataset. */
  public UnaryCallSettings<DeleteDatasetRequest, Operation> deleteDatasetSettings() {
    return deleteDatasetSettings;
  }

  /** Returns the object with the settings used for calls to deleteDataset. */
  public OperationCallSettings<DeleteDatasetRequest, Empty, OperationMetadata>
      deleteDatasetOperationSettings() {
    return deleteDatasetOperationSettings;
  }

  /** Returns the object with the settings used for calls to listModels. */
  public PagedCallSettings<ListModelsRequest, ListModelsResponse, ListModelsPagedResponse>
      listModelsSettings() {
    return listModelsSettings;
  }

  /** Returns the object with the settings used for calls to getModel. */
  public UnaryCallSettings<GetModelRequest, Model> getModelSettings() {
    return getModelSettings;
  }

  /** Returns the object with the settings used for calls to createModel. */
  public UnaryCallSettings<CreateModelRequest, Operation> createModelSettings() {
    return createModelSettings;
  }

  /** Returns the object with the settings used for calls to createModel. */
  public OperationCallSettings<CreateModelRequest, Model, OperationMetadata>
      createModelOperationSettings() {
    return createModelOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateModel. */
  public UnaryCallSettings<UpdateModelRequest, Operation> updateModelSettings() {
    return updateModelSettings;
  }

  /** Returns the object with the settings used for calls to updateModel. */
  public OperationCallSettings<UpdateModelRequest, Model, OperationMetadata>
      updateModelOperationSettings() {
    return updateModelOperationSettings;
  }

  /** Returns the object with the settings used for calls to exportModelMetadata. */
  public UnaryCallSettings<ExportModelMetadataRequest, Operation> exportModelMetadataSettings() {
    return exportModelMetadataSettings;
  }

  /** Returns the object with the settings used for calls to exportModelMetadata. */
  public OperationCallSettings<
          ExportModelMetadataRequest, ExportModelMetadataResponse, OperationMetadata>
      exportModelMetadataOperationSettings() {
    return exportModelMetadataOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteModel. */
  public UnaryCallSettings<DeleteModelRequest, Operation> deleteModelSettings() {
    return deleteModelSettings;
  }

  /** Returns the object with the settings used for calls to deleteModel. */
  public OperationCallSettings<DeleteModelRequest, Empty, OperationMetadata>
      deleteModelOperationSettings() {
    return deleteModelOperationSettings;
  }

  /** Returns the object with the settings used for calls to listEngineConfigs. */
  public PagedCallSettings<
          ListEngineConfigsRequest, ListEngineConfigsResponse, ListEngineConfigsPagedResponse>
      listEngineConfigsSettings() {
    return listEngineConfigsSettings;
  }

  /** Returns the object with the settings used for calls to getEngineConfig. */
  public UnaryCallSettings<GetEngineConfigRequest, EngineConfig> getEngineConfigSettings() {
    return getEngineConfigSettings;
  }

  /** Returns the object with the settings used for calls to createEngineConfig. */
  public UnaryCallSettings<CreateEngineConfigRequest, Operation> createEngineConfigSettings() {
    return createEngineConfigSettings;
  }

  /** Returns the object with the settings used for calls to createEngineConfig. */
  public OperationCallSettings<CreateEngineConfigRequest, EngineConfig, OperationMetadata>
      createEngineConfigOperationSettings() {
    return createEngineConfigOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateEngineConfig. */
  public UnaryCallSettings<UpdateEngineConfigRequest, Operation> updateEngineConfigSettings() {
    return updateEngineConfigSettings;
  }

  /** Returns the object with the settings used for calls to updateEngineConfig. */
  public OperationCallSettings<UpdateEngineConfigRequest, EngineConfig, OperationMetadata>
      updateEngineConfigOperationSettings() {
    return updateEngineConfigOperationSettings;
  }

  /** Returns the object with the settings used for calls to exportEngineConfigMetadata. */
  public UnaryCallSettings<ExportEngineConfigMetadataRequest, Operation>
      exportEngineConfigMetadataSettings() {
    return exportEngineConfigMetadataSettings;
  }

  /** Returns the object with the settings used for calls to exportEngineConfigMetadata. */
  public OperationCallSettings<
          ExportEngineConfigMetadataRequest, ExportEngineConfigMetadataResponse, OperationMetadata>
      exportEngineConfigMetadataOperationSettings() {
    return exportEngineConfigMetadataOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteEngineConfig. */
  public UnaryCallSettings<DeleteEngineConfigRequest, Operation> deleteEngineConfigSettings() {
    return deleteEngineConfigSettings;
  }

  /** Returns the object with the settings used for calls to deleteEngineConfig. */
  public OperationCallSettings<DeleteEngineConfigRequest, Empty, OperationMetadata>
      deleteEngineConfigOperationSettings() {
    return deleteEngineConfigOperationSettings;
  }

  /** Returns the object with the settings used for calls to getEngineVersion. */
  public UnaryCallSettings<GetEngineVersionRequest, EngineVersion> getEngineVersionSettings() {
    return getEngineVersionSettings;
  }

  /** Returns the object with the settings used for calls to listEngineVersions. */
  public PagedCallSettings<
          ListEngineVersionsRequest, ListEngineVersionsResponse, ListEngineVersionsPagedResponse>
      listEngineVersionsSettings() {
    return listEngineVersionsSettings;
  }

  /** Returns the object with the settings used for calls to listPredictionResults. */
  public PagedCallSettings<
          ListPredictionResultsRequest,
          ListPredictionResultsResponse,
          ListPredictionResultsPagedResponse>
      listPredictionResultsSettings() {
    return listPredictionResultsSettings;
  }

  /** Returns the object with the settings used for calls to getPredictionResult. */
  public UnaryCallSettings<GetPredictionResultRequest, PredictionResult>
      getPredictionResultSettings() {
    return getPredictionResultSettings;
  }

  /** Returns the object with the settings used for calls to createPredictionResult. */
  public UnaryCallSettings<CreatePredictionResultRequest, Operation>
      createPredictionResultSettings() {
    return createPredictionResultSettings;
  }

  /** Returns the object with the settings used for calls to createPredictionResult. */
  public OperationCallSettings<CreatePredictionResultRequest, PredictionResult, OperationMetadata>
      createPredictionResultOperationSettings() {
    return createPredictionResultOperationSettings;
  }

  /** Returns the object with the settings used for calls to updatePredictionResult. */
  public UnaryCallSettings<UpdatePredictionResultRequest, Operation>
      updatePredictionResultSettings() {
    return updatePredictionResultSettings;
  }

  /** Returns the object with the settings used for calls to updatePredictionResult. */
  public OperationCallSettings<UpdatePredictionResultRequest, PredictionResult, OperationMetadata>
      updatePredictionResultOperationSettings() {
    return updatePredictionResultOperationSettings;
  }

  /** Returns the object with the settings used for calls to exportPredictionResultMetadata. */
  public UnaryCallSettings<ExportPredictionResultMetadataRequest, Operation>
      exportPredictionResultMetadataSettings() {
    return exportPredictionResultMetadataSettings;
  }

  /** Returns the object with the settings used for calls to exportPredictionResultMetadata. */
  public OperationCallSettings<
          ExportPredictionResultMetadataRequest,
          ExportPredictionResultMetadataResponse,
          OperationMetadata>
      exportPredictionResultMetadataOperationSettings() {
    return exportPredictionResultMetadataOperationSettings;
  }

  /** Returns the object with the settings used for calls to deletePredictionResult. */
  public UnaryCallSettings<DeletePredictionResultRequest, Operation>
      deletePredictionResultSettings() {
    return deletePredictionResultSettings;
  }

  /** Returns the object with the settings used for calls to deletePredictionResult. */
  public OperationCallSettings<DeletePredictionResultRequest, Empty, OperationMetadata>
      deletePredictionResultOperationSettings() {
    return deletePredictionResultOperationSettings;
  }

  /** Returns the object with the settings used for calls to listBacktestResults. */
  public PagedCallSettings<
          ListBacktestResultsRequest, ListBacktestResultsResponse, ListBacktestResultsPagedResponse>
      listBacktestResultsSettings() {
    return listBacktestResultsSettings;
  }

  /** Returns the object with the settings used for calls to getBacktestResult. */
  public UnaryCallSettings<GetBacktestResultRequest, BacktestResult> getBacktestResultSettings() {
    return getBacktestResultSettings;
  }

  /** Returns the object with the settings used for calls to createBacktestResult. */
  public UnaryCallSettings<CreateBacktestResultRequest, Operation> createBacktestResultSettings() {
    return createBacktestResultSettings;
  }

  /** Returns the object with the settings used for calls to createBacktestResult. */
  public OperationCallSettings<CreateBacktestResultRequest, BacktestResult, OperationMetadata>
      createBacktestResultOperationSettings() {
    return createBacktestResultOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateBacktestResult. */
  public UnaryCallSettings<UpdateBacktestResultRequest, Operation> updateBacktestResultSettings() {
    return updateBacktestResultSettings;
  }

  /** Returns the object with the settings used for calls to updateBacktestResult. */
  public OperationCallSettings<UpdateBacktestResultRequest, BacktestResult, OperationMetadata>
      updateBacktestResultOperationSettings() {
    return updateBacktestResultOperationSettings;
  }

  /** Returns the object with the settings used for calls to exportBacktestResultMetadata. */
  public UnaryCallSettings<ExportBacktestResultMetadataRequest, Operation>
      exportBacktestResultMetadataSettings() {
    return exportBacktestResultMetadataSettings;
  }

  /** Returns the object with the settings used for calls to exportBacktestResultMetadata. */
  public OperationCallSettings<
          ExportBacktestResultMetadataRequest,
          ExportBacktestResultMetadataResponse,
          OperationMetadata>
      exportBacktestResultMetadataOperationSettings() {
    return exportBacktestResultMetadataOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteBacktestResult. */
  public UnaryCallSettings<DeleteBacktestResultRequest, Operation> deleteBacktestResultSettings() {
    return deleteBacktestResultSettings;
  }

  /** Returns the object with the settings used for calls to deleteBacktestResult. */
  public OperationCallSettings<DeleteBacktestResultRequest, Empty, OperationMetadata>
      deleteBacktestResultOperationSettings() {
    return deleteBacktestResultOperationSettings;
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return listLocationsSettings;
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return getLocationSettings;
  }

  public AMLStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcAMLStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonAMLStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "financialservices";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "financialservices.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "financialservices.mtls.googleapis.com:443";
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

  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(AMLStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(AMLStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return AMLStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected AMLStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listInstancesSettings = settingsBuilder.listInstancesSettings().build();
    getInstanceSettings = settingsBuilder.getInstanceSettings().build();
    createInstanceSettings = settingsBuilder.createInstanceSettings().build();
    createInstanceOperationSettings = settingsBuilder.createInstanceOperationSettings().build();
    updateInstanceSettings = settingsBuilder.updateInstanceSettings().build();
    updateInstanceOperationSettings = settingsBuilder.updateInstanceOperationSettings().build();
    deleteInstanceSettings = settingsBuilder.deleteInstanceSettings().build();
    deleteInstanceOperationSettings = settingsBuilder.deleteInstanceOperationSettings().build();
    importRegisteredPartiesSettings = settingsBuilder.importRegisteredPartiesSettings().build();
    importRegisteredPartiesOperationSettings =
        settingsBuilder.importRegisteredPartiesOperationSettings().build();
    exportRegisteredPartiesSettings = settingsBuilder.exportRegisteredPartiesSettings().build();
    exportRegisteredPartiesOperationSettings =
        settingsBuilder.exportRegisteredPartiesOperationSettings().build();
    listDatasetsSettings = settingsBuilder.listDatasetsSettings().build();
    getDatasetSettings = settingsBuilder.getDatasetSettings().build();
    createDatasetSettings = settingsBuilder.createDatasetSettings().build();
    createDatasetOperationSettings = settingsBuilder.createDatasetOperationSettings().build();
    updateDatasetSettings = settingsBuilder.updateDatasetSettings().build();
    updateDatasetOperationSettings = settingsBuilder.updateDatasetOperationSettings().build();
    deleteDatasetSettings = settingsBuilder.deleteDatasetSettings().build();
    deleteDatasetOperationSettings = settingsBuilder.deleteDatasetOperationSettings().build();
    listModelsSettings = settingsBuilder.listModelsSettings().build();
    getModelSettings = settingsBuilder.getModelSettings().build();
    createModelSettings = settingsBuilder.createModelSettings().build();
    createModelOperationSettings = settingsBuilder.createModelOperationSettings().build();
    updateModelSettings = settingsBuilder.updateModelSettings().build();
    updateModelOperationSettings = settingsBuilder.updateModelOperationSettings().build();
    exportModelMetadataSettings = settingsBuilder.exportModelMetadataSettings().build();
    exportModelMetadataOperationSettings =
        settingsBuilder.exportModelMetadataOperationSettings().build();
    deleteModelSettings = settingsBuilder.deleteModelSettings().build();
    deleteModelOperationSettings = settingsBuilder.deleteModelOperationSettings().build();
    listEngineConfigsSettings = settingsBuilder.listEngineConfigsSettings().build();
    getEngineConfigSettings = settingsBuilder.getEngineConfigSettings().build();
    createEngineConfigSettings = settingsBuilder.createEngineConfigSettings().build();
    createEngineConfigOperationSettings =
        settingsBuilder.createEngineConfigOperationSettings().build();
    updateEngineConfigSettings = settingsBuilder.updateEngineConfigSettings().build();
    updateEngineConfigOperationSettings =
        settingsBuilder.updateEngineConfigOperationSettings().build();
    exportEngineConfigMetadataSettings =
        settingsBuilder.exportEngineConfigMetadataSettings().build();
    exportEngineConfigMetadataOperationSettings =
        settingsBuilder.exportEngineConfigMetadataOperationSettings().build();
    deleteEngineConfigSettings = settingsBuilder.deleteEngineConfigSettings().build();
    deleteEngineConfigOperationSettings =
        settingsBuilder.deleteEngineConfigOperationSettings().build();
    getEngineVersionSettings = settingsBuilder.getEngineVersionSettings().build();
    listEngineVersionsSettings = settingsBuilder.listEngineVersionsSettings().build();
    listPredictionResultsSettings = settingsBuilder.listPredictionResultsSettings().build();
    getPredictionResultSettings = settingsBuilder.getPredictionResultSettings().build();
    createPredictionResultSettings = settingsBuilder.createPredictionResultSettings().build();
    createPredictionResultOperationSettings =
        settingsBuilder.createPredictionResultOperationSettings().build();
    updatePredictionResultSettings = settingsBuilder.updatePredictionResultSettings().build();
    updatePredictionResultOperationSettings =
        settingsBuilder.updatePredictionResultOperationSettings().build();
    exportPredictionResultMetadataSettings =
        settingsBuilder.exportPredictionResultMetadataSettings().build();
    exportPredictionResultMetadataOperationSettings =
        settingsBuilder.exportPredictionResultMetadataOperationSettings().build();
    deletePredictionResultSettings = settingsBuilder.deletePredictionResultSettings().build();
    deletePredictionResultOperationSettings =
        settingsBuilder.deletePredictionResultOperationSettings().build();
    listBacktestResultsSettings = settingsBuilder.listBacktestResultsSettings().build();
    getBacktestResultSettings = settingsBuilder.getBacktestResultSettings().build();
    createBacktestResultSettings = settingsBuilder.createBacktestResultSettings().build();
    createBacktestResultOperationSettings =
        settingsBuilder.createBacktestResultOperationSettings().build();
    updateBacktestResultSettings = settingsBuilder.updateBacktestResultSettings().build();
    updateBacktestResultOperationSettings =
        settingsBuilder.updateBacktestResultOperationSettings().build();
    exportBacktestResultMetadataSettings =
        settingsBuilder.exportBacktestResultMetadataSettings().build();
    exportBacktestResultMetadataOperationSettings =
        settingsBuilder.exportBacktestResultMetadataOperationSettings().build();
    deleteBacktestResultSettings = settingsBuilder.deleteBacktestResultSettings().build();
    deleteBacktestResultOperationSettings =
        settingsBuilder.deleteBacktestResultOperationSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  /** Builder for AMLStubSettings. */
  public static class Builder extends StubSettings.Builder<AMLStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>
        listInstancesSettings;
    private final UnaryCallSettings.Builder<GetInstanceRequest, Instance> getInstanceSettings;
    private final UnaryCallSettings.Builder<CreateInstanceRequest, Operation>
        createInstanceSettings;
    private final OperationCallSettings.Builder<CreateInstanceRequest, Instance, OperationMetadata>
        createInstanceOperationSettings;
    private final UnaryCallSettings.Builder<UpdateInstanceRequest, Operation>
        updateInstanceSettings;
    private final OperationCallSettings.Builder<UpdateInstanceRequest, Instance, OperationMetadata>
        updateInstanceOperationSettings;
    private final UnaryCallSettings.Builder<DeleteInstanceRequest, Operation>
        deleteInstanceSettings;
    private final OperationCallSettings.Builder<DeleteInstanceRequest, Empty, OperationMetadata>
        deleteInstanceOperationSettings;
    private final UnaryCallSettings.Builder<ImportRegisteredPartiesRequest, Operation>
        importRegisteredPartiesSettings;
    private final OperationCallSettings.Builder<
            ImportRegisteredPartiesRequest, ImportRegisteredPartiesResponse, OperationMetadata>
        importRegisteredPartiesOperationSettings;
    private final UnaryCallSettings.Builder<ExportRegisteredPartiesRequest, Operation>
        exportRegisteredPartiesSettings;
    private final OperationCallSettings.Builder<
            ExportRegisteredPartiesRequest, ExportRegisteredPartiesResponse, OperationMetadata>
        exportRegisteredPartiesOperationSettings;
    private final PagedCallSettings.Builder<
            ListDatasetsRequest, ListDatasetsResponse, ListDatasetsPagedResponse>
        listDatasetsSettings;
    private final UnaryCallSettings.Builder<GetDatasetRequest, Dataset> getDatasetSettings;
    private final UnaryCallSettings.Builder<CreateDatasetRequest, Operation> createDatasetSettings;
    private final OperationCallSettings.Builder<CreateDatasetRequest, Dataset, OperationMetadata>
        createDatasetOperationSettings;
    private final UnaryCallSettings.Builder<UpdateDatasetRequest, Operation> updateDatasetSettings;
    private final OperationCallSettings.Builder<UpdateDatasetRequest, Dataset, OperationMetadata>
        updateDatasetOperationSettings;
    private final UnaryCallSettings.Builder<DeleteDatasetRequest, Operation> deleteDatasetSettings;
    private final OperationCallSettings.Builder<DeleteDatasetRequest, Empty, OperationMetadata>
        deleteDatasetOperationSettings;
    private final PagedCallSettings.Builder<
            ListModelsRequest, ListModelsResponse, ListModelsPagedResponse>
        listModelsSettings;
    private final UnaryCallSettings.Builder<GetModelRequest, Model> getModelSettings;
    private final UnaryCallSettings.Builder<CreateModelRequest, Operation> createModelSettings;
    private final OperationCallSettings.Builder<CreateModelRequest, Model, OperationMetadata>
        createModelOperationSettings;
    private final UnaryCallSettings.Builder<UpdateModelRequest, Operation> updateModelSettings;
    private final OperationCallSettings.Builder<UpdateModelRequest, Model, OperationMetadata>
        updateModelOperationSettings;
    private final UnaryCallSettings.Builder<ExportModelMetadataRequest, Operation>
        exportModelMetadataSettings;
    private final OperationCallSettings.Builder<
            ExportModelMetadataRequest, ExportModelMetadataResponse, OperationMetadata>
        exportModelMetadataOperationSettings;
    private final UnaryCallSettings.Builder<DeleteModelRequest, Operation> deleteModelSettings;
    private final OperationCallSettings.Builder<DeleteModelRequest, Empty, OperationMetadata>
        deleteModelOperationSettings;
    private final PagedCallSettings.Builder<
            ListEngineConfigsRequest, ListEngineConfigsResponse, ListEngineConfigsPagedResponse>
        listEngineConfigsSettings;
    private final UnaryCallSettings.Builder<GetEngineConfigRequest, EngineConfig>
        getEngineConfigSettings;
    private final UnaryCallSettings.Builder<CreateEngineConfigRequest, Operation>
        createEngineConfigSettings;
    private final OperationCallSettings.Builder<
            CreateEngineConfigRequest, EngineConfig, OperationMetadata>
        createEngineConfigOperationSettings;
    private final UnaryCallSettings.Builder<UpdateEngineConfigRequest, Operation>
        updateEngineConfigSettings;
    private final OperationCallSettings.Builder<
            UpdateEngineConfigRequest, EngineConfig, OperationMetadata>
        updateEngineConfigOperationSettings;
    private final UnaryCallSettings.Builder<ExportEngineConfigMetadataRequest, Operation>
        exportEngineConfigMetadataSettings;
    private final OperationCallSettings.Builder<
            ExportEngineConfigMetadataRequest,
            ExportEngineConfigMetadataResponse,
            OperationMetadata>
        exportEngineConfigMetadataOperationSettings;
    private final UnaryCallSettings.Builder<DeleteEngineConfigRequest, Operation>
        deleteEngineConfigSettings;
    private final OperationCallSettings.Builder<DeleteEngineConfigRequest, Empty, OperationMetadata>
        deleteEngineConfigOperationSettings;
    private final UnaryCallSettings.Builder<GetEngineVersionRequest, EngineVersion>
        getEngineVersionSettings;
    private final PagedCallSettings.Builder<
            ListEngineVersionsRequest, ListEngineVersionsResponse, ListEngineVersionsPagedResponse>
        listEngineVersionsSettings;
    private final PagedCallSettings.Builder<
            ListPredictionResultsRequest,
            ListPredictionResultsResponse,
            ListPredictionResultsPagedResponse>
        listPredictionResultsSettings;
    private final UnaryCallSettings.Builder<GetPredictionResultRequest, PredictionResult>
        getPredictionResultSettings;
    private final UnaryCallSettings.Builder<CreatePredictionResultRequest, Operation>
        createPredictionResultSettings;
    private final OperationCallSettings.Builder<
            CreatePredictionResultRequest, PredictionResult, OperationMetadata>
        createPredictionResultOperationSettings;
    private final UnaryCallSettings.Builder<UpdatePredictionResultRequest, Operation>
        updatePredictionResultSettings;
    private final OperationCallSettings.Builder<
            UpdatePredictionResultRequest, PredictionResult, OperationMetadata>
        updatePredictionResultOperationSettings;
    private final UnaryCallSettings.Builder<ExportPredictionResultMetadataRequest, Operation>
        exportPredictionResultMetadataSettings;
    private final OperationCallSettings.Builder<
            ExportPredictionResultMetadataRequest,
            ExportPredictionResultMetadataResponse,
            OperationMetadata>
        exportPredictionResultMetadataOperationSettings;
    private final UnaryCallSettings.Builder<DeletePredictionResultRequest, Operation>
        deletePredictionResultSettings;
    private final OperationCallSettings.Builder<
            DeletePredictionResultRequest, Empty, OperationMetadata>
        deletePredictionResultOperationSettings;
    private final PagedCallSettings.Builder<
            ListBacktestResultsRequest,
            ListBacktestResultsResponse,
            ListBacktestResultsPagedResponse>
        listBacktestResultsSettings;
    private final UnaryCallSettings.Builder<GetBacktestResultRequest, BacktestResult>
        getBacktestResultSettings;
    private final UnaryCallSettings.Builder<CreateBacktestResultRequest, Operation>
        createBacktestResultSettings;
    private final OperationCallSettings.Builder<
            CreateBacktestResultRequest, BacktestResult, OperationMetadata>
        createBacktestResultOperationSettings;
    private final UnaryCallSettings.Builder<UpdateBacktestResultRequest, Operation>
        updateBacktestResultSettings;
    private final OperationCallSettings.Builder<
            UpdateBacktestResultRequest, BacktestResult, OperationMetadata>
        updateBacktestResultOperationSettings;
    private final UnaryCallSettings.Builder<ExportBacktestResultMetadataRequest, Operation>
        exportBacktestResultMetadataSettings;
    private final OperationCallSettings.Builder<
            ExportBacktestResultMetadataRequest,
            ExportBacktestResultMetadataResponse,
            OperationMetadata>
        exportBacktestResultMetadataOperationSettings;
    private final UnaryCallSettings.Builder<DeleteBacktestResultRequest, Operation>
        deleteBacktestResultSettings;
    private final OperationCallSettings.Builder<
            DeleteBacktestResultRequest, Empty, OperationMetadata>
        deleteBacktestResultOperationSettings;
    private final PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings;
    private final UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_0_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeoutDuration(Duration.ofMillis(10000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(10000L))
              .setTotalTimeoutDuration(Duration.ofMillis(10000L))
              .build();
      definitions.put("no_retry_0_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeoutDuration(Duration.ofMillis(120000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(120000L))
              .setTotalTimeoutDuration(Duration.ofMillis(120000L))
              .build();
      definitions.put("no_retry_1_params", settings);
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listInstancesSettings = PagedCallSettings.newBuilder(LIST_INSTANCES_PAGE_STR_FACT);
      getInstanceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createInstanceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createInstanceOperationSettings = OperationCallSettings.newBuilder();
      updateInstanceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateInstanceOperationSettings = OperationCallSettings.newBuilder();
      deleteInstanceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteInstanceOperationSettings = OperationCallSettings.newBuilder();
      importRegisteredPartiesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      importRegisteredPartiesOperationSettings = OperationCallSettings.newBuilder();
      exportRegisteredPartiesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      exportRegisteredPartiesOperationSettings = OperationCallSettings.newBuilder();
      listDatasetsSettings = PagedCallSettings.newBuilder(LIST_DATASETS_PAGE_STR_FACT);
      getDatasetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createDatasetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createDatasetOperationSettings = OperationCallSettings.newBuilder();
      updateDatasetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateDatasetOperationSettings = OperationCallSettings.newBuilder();
      deleteDatasetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteDatasetOperationSettings = OperationCallSettings.newBuilder();
      listModelsSettings = PagedCallSettings.newBuilder(LIST_MODELS_PAGE_STR_FACT);
      getModelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createModelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createModelOperationSettings = OperationCallSettings.newBuilder();
      updateModelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateModelOperationSettings = OperationCallSettings.newBuilder();
      exportModelMetadataSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      exportModelMetadataOperationSettings = OperationCallSettings.newBuilder();
      deleteModelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteModelOperationSettings = OperationCallSettings.newBuilder();
      listEngineConfigsSettings = PagedCallSettings.newBuilder(LIST_ENGINE_CONFIGS_PAGE_STR_FACT);
      getEngineConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createEngineConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createEngineConfigOperationSettings = OperationCallSettings.newBuilder();
      updateEngineConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateEngineConfigOperationSettings = OperationCallSettings.newBuilder();
      exportEngineConfigMetadataSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      exportEngineConfigMetadataOperationSettings = OperationCallSettings.newBuilder();
      deleteEngineConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteEngineConfigOperationSettings = OperationCallSettings.newBuilder();
      getEngineVersionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listEngineVersionsSettings = PagedCallSettings.newBuilder(LIST_ENGINE_VERSIONS_PAGE_STR_FACT);
      listPredictionResultsSettings =
          PagedCallSettings.newBuilder(LIST_PREDICTION_RESULTS_PAGE_STR_FACT);
      getPredictionResultSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createPredictionResultSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createPredictionResultOperationSettings = OperationCallSettings.newBuilder();
      updatePredictionResultSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updatePredictionResultOperationSettings = OperationCallSettings.newBuilder();
      exportPredictionResultMetadataSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      exportPredictionResultMetadataOperationSettings = OperationCallSettings.newBuilder();
      deletePredictionResultSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deletePredictionResultOperationSettings = OperationCallSettings.newBuilder();
      listBacktestResultsSettings =
          PagedCallSettings.newBuilder(LIST_BACKTEST_RESULTS_PAGE_STR_FACT);
      getBacktestResultSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createBacktestResultSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createBacktestResultOperationSettings = OperationCallSettings.newBuilder();
      updateBacktestResultSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateBacktestResultOperationSettings = OperationCallSettings.newBuilder();
      exportBacktestResultMetadataSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      exportBacktestResultMetadataOperationSettings = OperationCallSettings.newBuilder();
      deleteBacktestResultSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteBacktestResultOperationSettings = OperationCallSettings.newBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listInstancesSettings,
              getInstanceSettings,
              createInstanceSettings,
              updateInstanceSettings,
              deleteInstanceSettings,
              importRegisteredPartiesSettings,
              exportRegisteredPartiesSettings,
              listDatasetsSettings,
              getDatasetSettings,
              createDatasetSettings,
              updateDatasetSettings,
              deleteDatasetSettings,
              listModelsSettings,
              getModelSettings,
              createModelSettings,
              updateModelSettings,
              exportModelMetadataSettings,
              deleteModelSettings,
              listEngineConfigsSettings,
              getEngineConfigSettings,
              createEngineConfigSettings,
              updateEngineConfigSettings,
              exportEngineConfigMetadataSettings,
              deleteEngineConfigSettings,
              getEngineVersionSettings,
              listEngineVersionsSettings,
              listPredictionResultsSettings,
              getPredictionResultSettings,
              createPredictionResultSettings,
              updatePredictionResultSettings,
              exportPredictionResultMetadataSettings,
              deletePredictionResultSettings,
              listBacktestResultsSettings,
              getBacktestResultSettings,
              createBacktestResultSettings,
              updateBacktestResultSettings,
              exportBacktestResultMetadataSettings,
              deleteBacktestResultSettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(AMLStubSettings settings) {
      super(settings);

      listInstancesSettings = settings.listInstancesSettings.toBuilder();
      getInstanceSettings = settings.getInstanceSettings.toBuilder();
      createInstanceSettings = settings.createInstanceSettings.toBuilder();
      createInstanceOperationSettings = settings.createInstanceOperationSettings.toBuilder();
      updateInstanceSettings = settings.updateInstanceSettings.toBuilder();
      updateInstanceOperationSettings = settings.updateInstanceOperationSettings.toBuilder();
      deleteInstanceSettings = settings.deleteInstanceSettings.toBuilder();
      deleteInstanceOperationSettings = settings.deleteInstanceOperationSettings.toBuilder();
      importRegisteredPartiesSettings = settings.importRegisteredPartiesSettings.toBuilder();
      importRegisteredPartiesOperationSettings =
          settings.importRegisteredPartiesOperationSettings.toBuilder();
      exportRegisteredPartiesSettings = settings.exportRegisteredPartiesSettings.toBuilder();
      exportRegisteredPartiesOperationSettings =
          settings.exportRegisteredPartiesOperationSettings.toBuilder();
      listDatasetsSettings = settings.listDatasetsSettings.toBuilder();
      getDatasetSettings = settings.getDatasetSettings.toBuilder();
      createDatasetSettings = settings.createDatasetSettings.toBuilder();
      createDatasetOperationSettings = settings.createDatasetOperationSettings.toBuilder();
      updateDatasetSettings = settings.updateDatasetSettings.toBuilder();
      updateDatasetOperationSettings = settings.updateDatasetOperationSettings.toBuilder();
      deleteDatasetSettings = settings.deleteDatasetSettings.toBuilder();
      deleteDatasetOperationSettings = settings.deleteDatasetOperationSettings.toBuilder();
      listModelsSettings = settings.listModelsSettings.toBuilder();
      getModelSettings = settings.getModelSettings.toBuilder();
      createModelSettings = settings.createModelSettings.toBuilder();
      createModelOperationSettings = settings.createModelOperationSettings.toBuilder();
      updateModelSettings = settings.updateModelSettings.toBuilder();
      updateModelOperationSettings = settings.updateModelOperationSettings.toBuilder();
      exportModelMetadataSettings = settings.exportModelMetadataSettings.toBuilder();
      exportModelMetadataOperationSettings =
          settings.exportModelMetadataOperationSettings.toBuilder();
      deleteModelSettings = settings.deleteModelSettings.toBuilder();
      deleteModelOperationSettings = settings.deleteModelOperationSettings.toBuilder();
      listEngineConfigsSettings = settings.listEngineConfigsSettings.toBuilder();
      getEngineConfigSettings = settings.getEngineConfigSettings.toBuilder();
      createEngineConfigSettings = settings.createEngineConfigSettings.toBuilder();
      createEngineConfigOperationSettings =
          settings.createEngineConfigOperationSettings.toBuilder();
      updateEngineConfigSettings = settings.updateEngineConfigSettings.toBuilder();
      updateEngineConfigOperationSettings =
          settings.updateEngineConfigOperationSettings.toBuilder();
      exportEngineConfigMetadataSettings = settings.exportEngineConfigMetadataSettings.toBuilder();
      exportEngineConfigMetadataOperationSettings =
          settings.exportEngineConfigMetadataOperationSettings.toBuilder();
      deleteEngineConfigSettings = settings.deleteEngineConfigSettings.toBuilder();
      deleteEngineConfigOperationSettings =
          settings.deleteEngineConfigOperationSettings.toBuilder();
      getEngineVersionSettings = settings.getEngineVersionSettings.toBuilder();
      listEngineVersionsSettings = settings.listEngineVersionsSettings.toBuilder();
      listPredictionResultsSettings = settings.listPredictionResultsSettings.toBuilder();
      getPredictionResultSettings = settings.getPredictionResultSettings.toBuilder();
      createPredictionResultSettings = settings.createPredictionResultSettings.toBuilder();
      createPredictionResultOperationSettings =
          settings.createPredictionResultOperationSettings.toBuilder();
      updatePredictionResultSettings = settings.updatePredictionResultSettings.toBuilder();
      updatePredictionResultOperationSettings =
          settings.updatePredictionResultOperationSettings.toBuilder();
      exportPredictionResultMetadataSettings =
          settings.exportPredictionResultMetadataSettings.toBuilder();
      exportPredictionResultMetadataOperationSettings =
          settings.exportPredictionResultMetadataOperationSettings.toBuilder();
      deletePredictionResultSettings = settings.deletePredictionResultSettings.toBuilder();
      deletePredictionResultOperationSettings =
          settings.deletePredictionResultOperationSettings.toBuilder();
      listBacktestResultsSettings = settings.listBacktestResultsSettings.toBuilder();
      getBacktestResultSettings = settings.getBacktestResultSettings.toBuilder();
      createBacktestResultSettings = settings.createBacktestResultSettings.toBuilder();
      createBacktestResultOperationSettings =
          settings.createBacktestResultOperationSettings.toBuilder();
      updateBacktestResultSettings = settings.updateBacktestResultSettings.toBuilder();
      updateBacktestResultOperationSettings =
          settings.updateBacktestResultOperationSettings.toBuilder();
      exportBacktestResultMetadataSettings =
          settings.exportBacktestResultMetadataSettings.toBuilder();
      exportBacktestResultMetadataOperationSettings =
          settings.exportBacktestResultMetadataOperationSettings.toBuilder();
      deleteBacktestResultSettings = settings.deleteBacktestResultSettings.toBuilder();
      deleteBacktestResultOperationSettings =
          settings.deleteBacktestResultOperationSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listInstancesSettings,
              getInstanceSettings,
              createInstanceSettings,
              updateInstanceSettings,
              deleteInstanceSettings,
              importRegisteredPartiesSettings,
              exportRegisteredPartiesSettings,
              listDatasetsSettings,
              getDatasetSettings,
              createDatasetSettings,
              updateDatasetSettings,
              deleteDatasetSettings,
              listModelsSettings,
              getModelSettings,
              createModelSettings,
              updateModelSettings,
              exportModelMetadataSettings,
              deleteModelSettings,
              listEngineConfigsSettings,
              getEngineConfigSettings,
              createEngineConfigSettings,
              updateEngineConfigSettings,
              exportEngineConfigMetadataSettings,
              deleteEngineConfigSettings,
              getEngineVersionSettings,
              listEngineVersionsSettings,
              listPredictionResultsSettings,
              getPredictionResultSettings,
              createPredictionResultSettings,
              updatePredictionResultSettings,
              exportPredictionResultMetadataSettings,
              deletePredictionResultSettings,
              listBacktestResultsSettings,
              getBacktestResultSettings,
              createBacktestResultSettings,
              updateBacktestResultSettings,
              exportBacktestResultMetadataSettings,
              deleteBacktestResultSettings,
              listLocationsSettings,
              getLocationSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .listInstancesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getInstanceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createInstanceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateInstanceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteInstanceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .importRegisteredPartiesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .exportRegisteredPartiesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listDatasetsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getDatasetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createDatasetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateDatasetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteDatasetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listModelsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getModelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createModelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateModelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .exportModelMetadataSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteModelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listEngineConfigsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getEngineConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createEngineConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateEngineConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .exportEngineConfigMetadataSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteEngineConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getEngineVersionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listEngineVersionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listPredictionResultsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getPredictionResultSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createPredictionResultSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updatePredictionResultSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .exportPredictionResultMetadataSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deletePredictionResultSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listBacktestResultsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getBacktestResultSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createBacktestResultSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateBacktestResultSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .exportBacktestResultMetadataSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteBacktestResultSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getLocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createInstanceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateInstanceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Instance.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(2.0)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateInstanceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateInstanceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Instance.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(2.0)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteInstanceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteInstanceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(600000L))
                      .setRetryDelayMultiplier(2.0)
                      .setMaxRetryDelayDuration(Duration.ofMillis(7200000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(259200000L))
                      .build()));

      builder
          .importRegisteredPartiesOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ImportRegisteredPartiesRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  ImportRegisteredPartiesResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(30000L))
                      .setRetryDelayMultiplier(2.0)
                      .setMaxRetryDelayDuration(Duration.ofMillis(180000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(1200000L))
                      .build()));

      builder
          .exportRegisteredPartiesOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ExportRegisteredPartiesRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  ExportRegisteredPartiesResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(30000L))
                      .setRetryDelayMultiplier(2.0)
                      .setMaxRetryDelayDuration(Duration.ofMillis(180000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(1200000L))
                      .build()));

      builder
          .createDatasetOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateDatasetRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Dataset.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(30000L))
                      .setRetryDelayMultiplier(2.0)
                      .setMaxRetryDelayDuration(Duration.ofMillis(180000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(1200000L))
                      .build()));

      builder
          .updateDatasetOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateDatasetRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Dataset.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(300000L))
                      .setRetryDelayMultiplier(2.0)
                      .setMaxRetryDelayDuration(Duration.ofMillis(1800000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(86400000L))
                      .build()));

      builder
          .deleteDatasetOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteDatasetRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(300000L))
                      .setRetryDelayMultiplier(2.0)
                      .setMaxRetryDelayDuration(Duration.ofMillis(1800000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(86400000L))
                      .build()));

      builder
          .createModelOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<CreateModelRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Model.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(600000L))
                      .setRetryDelayMultiplier(2.0)
                      .setMaxRetryDelayDuration(Duration.ofMillis(7200000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(259200000L))
                      .build()));

      builder
          .updateModelOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<UpdateModelRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Model.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(2.0)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .exportModelMetadataOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ExportModelMetadataRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  ExportModelMetadataResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(30000L))
                      .setRetryDelayMultiplier(2.0)
                      .setMaxRetryDelayDuration(Duration.ofMillis(180000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(1200000L))
                      .build()));

      builder
          .deleteModelOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<DeleteModelRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(2.0)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createEngineConfigOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateEngineConfigRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(EngineConfig.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(600000L))
                      .setRetryDelayMultiplier(2.0)
                      .setMaxRetryDelayDuration(Duration.ofMillis(7200000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(259200000L))
                      .build()));

      builder
          .updateEngineConfigOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateEngineConfigRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(EngineConfig.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(2.0)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .exportEngineConfigMetadataOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ExportEngineConfigMetadataRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  ExportEngineConfigMetadataResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(30000L))
                      .setRetryDelayMultiplier(2.0)
                      .setMaxRetryDelayDuration(Duration.ofMillis(180000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(1200000L))
                      .build()));

      builder
          .deleteEngineConfigOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteEngineConfigRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(2.0)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createPredictionResultOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreatePredictionResultRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(PredictionResult.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(600000L))
                      .setRetryDelayMultiplier(2.0)
                      .setMaxRetryDelayDuration(Duration.ofMillis(7200000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(172800000L))
                      .build()));

      builder
          .updatePredictionResultOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdatePredictionResultRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(PredictionResult.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(2.0)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .exportPredictionResultMetadataOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ExportPredictionResultMetadataRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  ExportPredictionResultMetadataResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(60000L))
                      .setRetryDelayMultiplier(2.0)
                      .setMaxRetryDelayDuration(Duration.ofMillis(300000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(7200000L))
                      .build()));

      builder
          .deletePredictionResultOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeletePredictionResultRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(30000L))
                      .setRetryDelayMultiplier(2.0)
                      .setMaxRetryDelayDuration(Duration.ofMillis(180000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(1200000L))
                      .build()));

      builder
          .createBacktestResultOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateBacktestResultRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(BacktestResult.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(600000L))
                      .setRetryDelayMultiplier(2.0)
                      .setMaxRetryDelayDuration(Duration.ofMillis(7200000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(172800000L))
                      .build()));

      builder
          .updateBacktestResultOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateBacktestResultRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(BacktestResult.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(2.0)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .exportBacktestResultMetadataOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ExportBacktestResultMetadataRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  ExportBacktestResultMetadataResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(60000L))
                      .setRetryDelayMultiplier(2.0)
                      .setMaxRetryDelayDuration(Duration.ofMillis(300000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(7200000L))
                      .build()));

      builder
          .deleteBacktestResultOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteBacktestResultRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(30000L))
                      .setRetryDelayMultiplier(2.0)
                      .setMaxRetryDelayDuration(Duration.ofMillis(180000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(1200000L))
                      .build()));

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

    /** Returns the builder for the settings used for calls to listInstances. */
    public PagedCallSettings.Builder<
            ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>
        listInstancesSettings() {
      return listInstancesSettings;
    }

    /** Returns the builder for the settings used for calls to getInstance. */
    public UnaryCallSettings.Builder<GetInstanceRequest, Instance> getInstanceSettings() {
      return getInstanceSettings;
    }

    /** Returns the builder for the settings used for calls to createInstance. */
    public UnaryCallSettings.Builder<CreateInstanceRequest, Operation> createInstanceSettings() {
      return createInstanceSettings;
    }

    /** Returns the builder for the settings used for calls to createInstance. */
    public OperationCallSettings.Builder<CreateInstanceRequest, Instance, OperationMetadata>
        createInstanceOperationSettings() {
      return createInstanceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateInstance. */
    public UnaryCallSettings.Builder<UpdateInstanceRequest, Operation> updateInstanceSettings() {
      return updateInstanceSettings;
    }

    /** Returns the builder for the settings used for calls to updateInstance. */
    public OperationCallSettings.Builder<UpdateInstanceRequest, Instance, OperationMetadata>
        updateInstanceOperationSettings() {
      return updateInstanceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteInstance. */
    public UnaryCallSettings.Builder<DeleteInstanceRequest, Operation> deleteInstanceSettings() {
      return deleteInstanceSettings;
    }

    /** Returns the builder for the settings used for calls to deleteInstance. */
    public OperationCallSettings.Builder<DeleteInstanceRequest, Empty, OperationMetadata>
        deleteInstanceOperationSettings() {
      return deleteInstanceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to importRegisteredParties. */
    public UnaryCallSettings.Builder<ImportRegisteredPartiesRequest, Operation>
        importRegisteredPartiesSettings() {
      return importRegisteredPartiesSettings;
    }

    /** Returns the builder for the settings used for calls to importRegisteredParties. */
    public OperationCallSettings.Builder<
            ImportRegisteredPartiesRequest, ImportRegisteredPartiesResponse, OperationMetadata>
        importRegisteredPartiesOperationSettings() {
      return importRegisteredPartiesOperationSettings;
    }

    /** Returns the builder for the settings used for calls to exportRegisteredParties. */
    public UnaryCallSettings.Builder<ExportRegisteredPartiesRequest, Operation>
        exportRegisteredPartiesSettings() {
      return exportRegisteredPartiesSettings;
    }

    /** Returns the builder for the settings used for calls to exportRegisteredParties. */
    public OperationCallSettings.Builder<
            ExportRegisteredPartiesRequest, ExportRegisteredPartiesResponse, OperationMetadata>
        exportRegisteredPartiesOperationSettings() {
      return exportRegisteredPartiesOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listDatasets. */
    public PagedCallSettings.Builder<
            ListDatasetsRequest, ListDatasetsResponse, ListDatasetsPagedResponse>
        listDatasetsSettings() {
      return listDatasetsSettings;
    }

    /** Returns the builder for the settings used for calls to getDataset. */
    public UnaryCallSettings.Builder<GetDatasetRequest, Dataset> getDatasetSettings() {
      return getDatasetSettings;
    }

    /** Returns the builder for the settings used for calls to createDataset. */
    public UnaryCallSettings.Builder<CreateDatasetRequest, Operation> createDatasetSettings() {
      return createDatasetSettings;
    }

    /** Returns the builder for the settings used for calls to createDataset. */
    public OperationCallSettings.Builder<CreateDatasetRequest, Dataset, OperationMetadata>
        createDatasetOperationSettings() {
      return createDatasetOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateDataset. */
    public UnaryCallSettings.Builder<UpdateDatasetRequest, Operation> updateDatasetSettings() {
      return updateDatasetSettings;
    }

    /** Returns the builder for the settings used for calls to updateDataset. */
    public OperationCallSettings.Builder<UpdateDatasetRequest, Dataset, OperationMetadata>
        updateDatasetOperationSettings() {
      return updateDatasetOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDataset. */
    public UnaryCallSettings.Builder<DeleteDatasetRequest, Operation> deleteDatasetSettings() {
      return deleteDatasetSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDataset. */
    public OperationCallSettings.Builder<DeleteDatasetRequest, Empty, OperationMetadata>
        deleteDatasetOperationSettings() {
      return deleteDatasetOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listModels. */
    public PagedCallSettings.Builder<ListModelsRequest, ListModelsResponse, ListModelsPagedResponse>
        listModelsSettings() {
      return listModelsSettings;
    }

    /** Returns the builder for the settings used for calls to getModel. */
    public UnaryCallSettings.Builder<GetModelRequest, Model> getModelSettings() {
      return getModelSettings;
    }

    /** Returns the builder for the settings used for calls to createModel. */
    public UnaryCallSettings.Builder<CreateModelRequest, Operation> createModelSettings() {
      return createModelSettings;
    }

    /** Returns the builder for the settings used for calls to createModel. */
    public OperationCallSettings.Builder<CreateModelRequest, Model, OperationMetadata>
        createModelOperationSettings() {
      return createModelOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateModel. */
    public UnaryCallSettings.Builder<UpdateModelRequest, Operation> updateModelSettings() {
      return updateModelSettings;
    }

    /** Returns the builder for the settings used for calls to updateModel. */
    public OperationCallSettings.Builder<UpdateModelRequest, Model, OperationMetadata>
        updateModelOperationSettings() {
      return updateModelOperationSettings;
    }

    /** Returns the builder for the settings used for calls to exportModelMetadata. */
    public UnaryCallSettings.Builder<ExportModelMetadataRequest, Operation>
        exportModelMetadataSettings() {
      return exportModelMetadataSettings;
    }

    /** Returns the builder for the settings used for calls to exportModelMetadata. */
    public OperationCallSettings.Builder<
            ExportModelMetadataRequest, ExportModelMetadataResponse, OperationMetadata>
        exportModelMetadataOperationSettings() {
      return exportModelMetadataOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteModel. */
    public UnaryCallSettings.Builder<DeleteModelRequest, Operation> deleteModelSettings() {
      return deleteModelSettings;
    }

    /** Returns the builder for the settings used for calls to deleteModel. */
    public OperationCallSettings.Builder<DeleteModelRequest, Empty, OperationMetadata>
        deleteModelOperationSettings() {
      return deleteModelOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listEngineConfigs. */
    public PagedCallSettings.Builder<
            ListEngineConfigsRequest, ListEngineConfigsResponse, ListEngineConfigsPagedResponse>
        listEngineConfigsSettings() {
      return listEngineConfigsSettings;
    }

    /** Returns the builder for the settings used for calls to getEngineConfig. */
    public UnaryCallSettings.Builder<GetEngineConfigRequest, EngineConfig>
        getEngineConfigSettings() {
      return getEngineConfigSettings;
    }

    /** Returns the builder for the settings used for calls to createEngineConfig. */
    public UnaryCallSettings.Builder<CreateEngineConfigRequest, Operation>
        createEngineConfigSettings() {
      return createEngineConfigSettings;
    }

    /** Returns the builder for the settings used for calls to createEngineConfig. */
    public OperationCallSettings.Builder<CreateEngineConfigRequest, EngineConfig, OperationMetadata>
        createEngineConfigOperationSettings() {
      return createEngineConfigOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateEngineConfig. */
    public UnaryCallSettings.Builder<UpdateEngineConfigRequest, Operation>
        updateEngineConfigSettings() {
      return updateEngineConfigSettings;
    }

    /** Returns the builder for the settings used for calls to updateEngineConfig. */
    public OperationCallSettings.Builder<UpdateEngineConfigRequest, EngineConfig, OperationMetadata>
        updateEngineConfigOperationSettings() {
      return updateEngineConfigOperationSettings;
    }

    /** Returns the builder for the settings used for calls to exportEngineConfigMetadata. */
    public UnaryCallSettings.Builder<ExportEngineConfigMetadataRequest, Operation>
        exportEngineConfigMetadataSettings() {
      return exportEngineConfigMetadataSettings;
    }

    /** Returns the builder for the settings used for calls to exportEngineConfigMetadata. */
    public OperationCallSettings.Builder<
            ExportEngineConfigMetadataRequest,
            ExportEngineConfigMetadataResponse,
            OperationMetadata>
        exportEngineConfigMetadataOperationSettings() {
      return exportEngineConfigMetadataOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteEngineConfig. */
    public UnaryCallSettings.Builder<DeleteEngineConfigRequest, Operation>
        deleteEngineConfigSettings() {
      return deleteEngineConfigSettings;
    }

    /** Returns the builder for the settings used for calls to deleteEngineConfig. */
    public OperationCallSettings.Builder<DeleteEngineConfigRequest, Empty, OperationMetadata>
        deleteEngineConfigOperationSettings() {
      return deleteEngineConfigOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getEngineVersion. */
    public UnaryCallSettings.Builder<GetEngineVersionRequest, EngineVersion>
        getEngineVersionSettings() {
      return getEngineVersionSettings;
    }

    /** Returns the builder for the settings used for calls to listEngineVersions. */
    public PagedCallSettings.Builder<
            ListEngineVersionsRequest, ListEngineVersionsResponse, ListEngineVersionsPagedResponse>
        listEngineVersionsSettings() {
      return listEngineVersionsSettings;
    }

    /** Returns the builder for the settings used for calls to listPredictionResults. */
    public PagedCallSettings.Builder<
            ListPredictionResultsRequest,
            ListPredictionResultsResponse,
            ListPredictionResultsPagedResponse>
        listPredictionResultsSettings() {
      return listPredictionResultsSettings;
    }

    /** Returns the builder for the settings used for calls to getPredictionResult. */
    public UnaryCallSettings.Builder<GetPredictionResultRequest, PredictionResult>
        getPredictionResultSettings() {
      return getPredictionResultSettings;
    }

    /** Returns the builder for the settings used for calls to createPredictionResult. */
    public UnaryCallSettings.Builder<CreatePredictionResultRequest, Operation>
        createPredictionResultSettings() {
      return createPredictionResultSettings;
    }

    /** Returns the builder for the settings used for calls to createPredictionResult. */
    public OperationCallSettings.Builder<
            CreatePredictionResultRequest, PredictionResult, OperationMetadata>
        createPredictionResultOperationSettings() {
      return createPredictionResultOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updatePredictionResult. */
    public UnaryCallSettings.Builder<UpdatePredictionResultRequest, Operation>
        updatePredictionResultSettings() {
      return updatePredictionResultSettings;
    }

    /** Returns the builder for the settings used for calls to updatePredictionResult. */
    public OperationCallSettings.Builder<
            UpdatePredictionResultRequest, PredictionResult, OperationMetadata>
        updatePredictionResultOperationSettings() {
      return updatePredictionResultOperationSettings;
    }

    /** Returns the builder for the settings used for calls to exportPredictionResultMetadata. */
    public UnaryCallSettings.Builder<ExportPredictionResultMetadataRequest, Operation>
        exportPredictionResultMetadataSettings() {
      return exportPredictionResultMetadataSettings;
    }

    /** Returns the builder for the settings used for calls to exportPredictionResultMetadata. */
    public OperationCallSettings.Builder<
            ExportPredictionResultMetadataRequest,
            ExportPredictionResultMetadataResponse,
            OperationMetadata>
        exportPredictionResultMetadataOperationSettings() {
      return exportPredictionResultMetadataOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deletePredictionResult. */
    public UnaryCallSettings.Builder<DeletePredictionResultRequest, Operation>
        deletePredictionResultSettings() {
      return deletePredictionResultSettings;
    }

    /** Returns the builder for the settings used for calls to deletePredictionResult. */
    public OperationCallSettings.Builder<DeletePredictionResultRequest, Empty, OperationMetadata>
        deletePredictionResultOperationSettings() {
      return deletePredictionResultOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listBacktestResults. */
    public PagedCallSettings.Builder<
            ListBacktestResultsRequest,
            ListBacktestResultsResponse,
            ListBacktestResultsPagedResponse>
        listBacktestResultsSettings() {
      return listBacktestResultsSettings;
    }

    /** Returns the builder for the settings used for calls to getBacktestResult. */
    public UnaryCallSettings.Builder<GetBacktestResultRequest, BacktestResult>
        getBacktestResultSettings() {
      return getBacktestResultSettings;
    }

    /** Returns the builder for the settings used for calls to createBacktestResult. */
    public UnaryCallSettings.Builder<CreateBacktestResultRequest, Operation>
        createBacktestResultSettings() {
      return createBacktestResultSettings;
    }

    /** Returns the builder for the settings used for calls to createBacktestResult. */
    public OperationCallSettings.Builder<
            CreateBacktestResultRequest, BacktestResult, OperationMetadata>
        createBacktestResultOperationSettings() {
      return createBacktestResultOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateBacktestResult. */
    public UnaryCallSettings.Builder<UpdateBacktestResultRequest, Operation>
        updateBacktestResultSettings() {
      return updateBacktestResultSettings;
    }

    /** Returns the builder for the settings used for calls to updateBacktestResult. */
    public OperationCallSettings.Builder<
            UpdateBacktestResultRequest, BacktestResult, OperationMetadata>
        updateBacktestResultOperationSettings() {
      return updateBacktestResultOperationSettings;
    }

    /** Returns the builder for the settings used for calls to exportBacktestResultMetadata. */
    public UnaryCallSettings.Builder<ExportBacktestResultMetadataRequest, Operation>
        exportBacktestResultMetadataSettings() {
      return exportBacktestResultMetadataSettings;
    }

    /** Returns the builder for the settings used for calls to exportBacktestResultMetadata. */
    public OperationCallSettings.Builder<
            ExportBacktestResultMetadataRequest,
            ExportBacktestResultMetadataResponse,
            OperationMetadata>
        exportBacktestResultMetadataOperationSettings() {
      return exportBacktestResultMetadataOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteBacktestResult. */
    public UnaryCallSettings.Builder<DeleteBacktestResultRequest, Operation>
        deleteBacktestResultSettings() {
      return deleteBacktestResultSettings;
    }

    /** Returns the builder for the settings used for calls to deleteBacktestResult. */
    public OperationCallSettings.Builder<DeleteBacktestResultRequest, Empty, OperationMetadata>
        deleteBacktestResultOperationSettings() {
      return deleteBacktestResultOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return listLocationsSettings;
    }

    /** Returns the builder for the settings used for calls to getLocation. */
    public UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings() {
      return getLocationSettings;
    }

    @Override
    public AMLStubSettings build() throws IOException {
      return new AMLStubSettings(this);
    }
  }
}
