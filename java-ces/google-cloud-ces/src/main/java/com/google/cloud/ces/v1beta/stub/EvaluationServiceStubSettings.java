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

package com.google.cloud.ces.v1beta.stub;

import static com.google.cloud.ces.v1beta.EvaluationServiceClient.ListEvaluationDatasetsPagedResponse;
import static com.google.cloud.ces.v1beta.EvaluationServiceClient.ListEvaluationExpectationsPagedResponse;
import static com.google.cloud.ces.v1beta.EvaluationServiceClient.ListEvaluationResultsPagedResponse;
import static com.google.cloud.ces.v1beta.EvaluationServiceClient.ListEvaluationRunsPagedResponse;
import static com.google.cloud.ces.v1beta.EvaluationServiceClient.ListEvaluationsPagedResponse;
import static com.google.cloud.ces.v1beta.EvaluationServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.ces.v1beta.EvaluationServiceClient.ListScheduledEvaluationRunsPagedResponse;

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
import com.google.cloud.ces.v1beta.CreateEvaluationDatasetRequest;
import com.google.cloud.ces.v1beta.CreateEvaluationExpectationRequest;
import com.google.cloud.ces.v1beta.CreateEvaluationRequest;
import com.google.cloud.ces.v1beta.CreateScheduledEvaluationRunRequest;
import com.google.cloud.ces.v1beta.DeleteEvaluationDatasetRequest;
import com.google.cloud.ces.v1beta.DeleteEvaluationExpectationRequest;
import com.google.cloud.ces.v1beta.DeleteEvaluationRequest;
import com.google.cloud.ces.v1beta.DeleteEvaluationResultRequest;
import com.google.cloud.ces.v1beta.DeleteEvaluationRunOperationMetadata;
import com.google.cloud.ces.v1beta.DeleteEvaluationRunRequest;
import com.google.cloud.ces.v1beta.DeleteScheduledEvaluationRunRequest;
import com.google.cloud.ces.v1beta.Evaluation;
import com.google.cloud.ces.v1beta.EvaluationDataset;
import com.google.cloud.ces.v1beta.EvaluationExpectation;
import com.google.cloud.ces.v1beta.EvaluationResult;
import com.google.cloud.ces.v1beta.EvaluationRun;
import com.google.cloud.ces.v1beta.GenerateEvaluationOperationMetadata;
import com.google.cloud.ces.v1beta.GenerateEvaluationRequest;
import com.google.cloud.ces.v1beta.GetEvaluationDatasetRequest;
import com.google.cloud.ces.v1beta.GetEvaluationExpectationRequest;
import com.google.cloud.ces.v1beta.GetEvaluationRequest;
import com.google.cloud.ces.v1beta.GetEvaluationResultRequest;
import com.google.cloud.ces.v1beta.GetEvaluationRunRequest;
import com.google.cloud.ces.v1beta.GetScheduledEvaluationRunRequest;
import com.google.cloud.ces.v1beta.ImportEvaluationsOperationMetadata;
import com.google.cloud.ces.v1beta.ImportEvaluationsRequest;
import com.google.cloud.ces.v1beta.ImportEvaluationsResponse;
import com.google.cloud.ces.v1beta.ListEvaluationDatasetsRequest;
import com.google.cloud.ces.v1beta.ListEvaluationDatasetsResponse;
import com.google.cloud.ces.v1beta.ListEvaluationExpectationsRequest;
import com.google.cloud.ces.v1beta.ListEvaluationExpectationsResponse;
import com.google.cloud.ces.v1beta.ListEvaluationResultsRequest;
import com.google.cloud.ces.v1beta.ListEvaluationResultsResponse;
import com.google.cloud.ces.v1beta.ListEvaluationRunsRequest;
import com.google.cloud.ces.v1beta.ListEvaluationRunsResponse;
import com.google.cloud.ces.v1beta.ListEvaluationsRequest;
import com.google.cloud.ces.v1beta.ListEvaluationsResponse;
import com.google.cloud.ces.v1beta.ListScheduledEvaluationRunsRequest;
import com.google.cloud.ces.v1beta.ListScheduledEvaluationRunsResponse;
import com.google.cloud.ces.v1beta.RunEvaluationOperationMetadata;
import com.google.cloud.ces.v1beta.RunEvaluationRequest;
import com.google.cloud.ces.v1beta.RunEvaluationResponse;
import com.google.cloud.ces.v1beta.ScheduledEvaluationRun;
import com.google.cloud.ces.v1beta.TestPersonaVoiceRequest;
import com.google.cloud.ces.v1beta.TestPersonaVoiceResponse;
import com.google.cloud.ces.v1beta.UpdateEvaluationDatasetRequest;
import com.google.cloud.ces.v1beta.UpdateEvaluationExpectationRequest;
import com.google.cloud.ces.v1beta.UpdateEvaluationRequest;
import com.google.cloud.ces.v1beta.UpdateScheduledEvaluationRunRequest;
import com.google.cloud.ces.v1beta.UploadEvaluationAudioRequest;
import com.google.cloud.ces.v1beta.UploadEvaluationAudioResponse;
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
 * Settings class to configure an instance of {@link EvaluationServiceStub}.
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
 * EvaluationServiceStubSettings.Builder evaluationServiceSettingsBuilder =
 *     EvaluationServiceStubSettings.newBuilder();
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
 * EvaluationServiceStubSettings evaluationServiceSettings =
 *     evaluationServiceSettingsBuilder.build();
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
 * EvaluationServiceStubSettings.Builder evaluationServiceSettingsBuilder =
 *     EvaluationServiceStubSettings.newBuilder();
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
public class EvaluationServiceStubSettings extends StubSettings<EvaluationServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/ces")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .build();

  private final UnaryCallSettings<RunEvaluationRequest, Operation> runEvaluationSettings;
  private final OperationCallSettings<
          RunEvaluationRequest, RunEvaluationResponse, RunEvaluationOperationMetadata>
      runEvaluationOperationSettings;
  private final UnaryCallSettings<UploadEvaluationAudioRequest, UploadEvaluationAudioResponse>
      uploadEvaluationAudioSettings;
  private final UnaryCallSettings<CreateEvaluationRequest, Evaluation> createEvaluationSettings;
  private final UnaryCallSettings<GenerateEvaluationRequest, Operation> generateEvaluationSettings;
  private final OperationCallSettings<
          GenerateEvaluationRequest, Evaluation, GenerateEvaluationOperationMetadata>
      generateEvaluationOperationSettings;
  private final UnaryCallSettings<ImportEvaluationsRequest, Operation> importEvaluationsSettings;
  private final OperationCallSettings<
          ImportEvaluationsRequest, ImportEvaluationsResponse, ImportEvaluationsOperationMetadata>
      importEvaluationsOperationSettings;
  private final UnaryCallSettings<CreateEvaluationDatasetRequest, EvaluationDataset>
      createEvaluationDatasetSettings;
  private final UnaryCallSettings<UpdateEvaluationRequest, Evaluation> updateEvaluationSettings;
  private final UnaryCallSettings<UpdateEvaluationDatasetRequest, EvaluationDataset>
      updateEvaluationDatasetSettings;
  private final UnaryCallSettings<DeleteEvaluationRequest, Empty> deleteEvaluationSettings;
  private final UnaryCallSettings<DeleteEvaluationResultRequest, Empty>
      deleteEvaluationResultSettings;
  private final UnaryCallSettings<DeleteEvaluationDatasetRequest, Empty>
      deleteEvaluationDatasetSettings;
  private final UnaryCallSettings<DeleteEvaluationRunRequest, Operation>
      deleteEvaluationRunSettings;
  private final OperationCallSettings<
          DeleteEvaluationRunRequest, Empty, DeleteEvaluationRunOperationMetadata>
      deleteEvaluationRunOperationSettings;
  private final UnaryCallSettings<GetEvaluationRequest, Evaluation> getEvaluationSettings;
  private final UnaryCallSettings<GetEvaluationResultRequest, EvaluationResult>
      getEvaluationResultSettings;
  private final UnaryCallSettings<GetEvaluationDatasetRequest, EvaluationDataset>
      getEvaluationDatasetSettings;
  private final UnaryCallSettings<GetEvaluationRunRequest, EvaluationRun> getEvaluationRunSettings;
  private final PagedCallSettings<
          ListEvaluationsRequest, ListEvaluationsResponse, ListEvaluationsPagedResponse>
      listEvaluationsSettings;
  private final PagedCallSettings<
          ListEvaluationResultsRequest,
          ListEvaluationResultsResponse,
          ListEvaluationResultsPagedResponse>
      listEvaluationResultsSettings;
  private final PagedCallSettings<
          ListEvaluationDatasetsRequest,
          ListEvaluationDatasetsResponse,
          ListEvaluationDatasetsPagedResponse>
      listEvaluationDatasetsSettings;
  private final PagedCallSettings<
          ListEvaluationRunsRequest, ListEvaluationRunsResponse, ListEvaluationRunsPagedResponse>
      listEvaluationRunsSettings;
  private final PagedCallSettings<
          ListEvaluationExpectationsRequest,
          ListEvaluationExpectationsResponse,
          ListEvaluationExpectationsPagedResponse>
      listEvaluationExpectationsSettings;
  private final UnaryCallSettings<GetEvaluationExpectationRequest, EvaluationExpectation>
      getEvaluationExpectationSettings;
  private final UnaryCallSettings<CreateEvaluationExpectationRequest, EvaluationExpectation>
      createEvaluationExpectationSettings;
  private final UnaryCallSettings<UpdateEvaluationExpectationRequest, EvaluationExpectation>
      updateEvaluationExpectationSettings;
  private final UnaryCallSettings<DeleteEvaluationExpectationRequest, Empty>
      deleteEvaluationExpectationSettings;
  private final UnaryCallSettings<CreateScheduledEvaluationRunRequest, ScheduledEvaluationRun>
      createScheduledEvaluationRunSettings;
  private final UnaryCallSettings<GetScheduledEvaluationRunRequest, ScheduledEvaluationRun>
      getScheduledEvaluationRunSettings;
  private final PagedCallSettings<
          ListScheduledEvaluationRunsRequest,
          ListScheduledEvaluationRunsResponse,
          ListScheduledEvaluationRunsPagedResponse>
      listScheduledEvaluationRunsSettings;
  private final UnaryCallSettings<UpdateScheduledEvaluationRunRequest, ScheduledEvaluationRun>
      updateScheduledEvaluationRunSettings;
  private final UnaryCallSettings<DeleteScheduledEvaluationRunRequest, Empty>
      deleteScheduledEvaluationRunSettings;
  private final UnaryCallSettings<TestPersonaVoiceRequest, TestPersonaVoiceResponse>
      testPersonaVoiceSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

  private static final PagedListDescriptor<
          ListEvaluationsRequest, ListEvaluationsResponse, Evaluation>
      LIST_EVALUATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListEvaluationsRequest, ListEvaluationsResponse, Evaluation>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListEvaluationsRequest injectToken(
                ListEvaluationsRequest payload, String token) {
              return ListEvaluationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListEvaluationsRequest injectPageSize(
                ListEvaluationsRequest payload, int pageSize) {
              return ListEvaluationsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListEvaluationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListEvaluationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Evaluation> extractResources(ListEvaluationsResponse payload) {
              return payload.getEvaluationsList();
            }
          };

  private static final PagedListDescriptor<
          ListEvaluationResultsRequest, ListEvaluationResultsResponse, EvaluationResult>
      LIST_EVALUATION_RESULTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListEvaluationResultsRequest, ListEvaluationResultsResponse, EvaluationResult>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListEvaluationResultsRequest injectToken(
                ListEvaluationResultsRequest payload, String token) {
              return ListEvaluationResultsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListEvaluationResultsRequest injectPageSize(
                ListEvaluationResultsRequest payload, int pageSize) {
              return ListEvaluationResultsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListEvaluationResultsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListEvaluationResultsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<EvaluationResult> extractResources(
                ListEvaluationResultsResponse payload) {
              return payload.getEvaluationResultsList();
            }
          };

  private static final PagedListDescriptor<
          ListEvaluationDatasetsRequest, ListEvaluationDatasetsResponse, EvaluationDataset>
      LIST_EVALUATION_DATASETS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListEvaluationDatasetsRequest, ListEvaluationDatasetsResponse, EvaluationDataset>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListEvaluationDatasetsRequest injectToken(
                ListEvaluationDatasetsRequest payload, String token) {
              return ListEvaluationDatasetsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListEvaluationDatasetsRequest injectPageSize(
                ListEvaluationDatasetsRequest payload, int pageSize) {
              return ListEvaluationDatasetsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListEvaluationDatasetsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListEvaluationDatasetsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<EvaluationDataset> extractResources(
                ListEvaluationDatasetsResponse payload) {
              return payload.getEvaluationDatasetsList();
            }
          };

  private static final PagedListDescriptor<
          ListEvaluationRunsRequest, ListEvaluationRunsResponse, EvaluationRun>
      LIST_EVALUATION_RUNS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListEvaluationRunsRequest, ListEvaluationRunsResponse, EvaluationRun>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListEvaluationRunsRequest injectToken(
                ListEvaluationRunsRequest payload, String token) {
              return ListEvaluationRunsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListEvaluationRunsRequest injectPageSize(
                ListEvaluationRunsRequest payload, int pageSize) {
              return ListEvaluationRunsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListEvaluationRunsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListEvaluationRunsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<EvaluationRun> extractResources(ListEvaluationRunsResponse payload) {
              return payload.getEvaluationRunsList();
            }
          };

  private static final PagedListDescriptor<
          ListEvaluationExpectationsRequest,
          ListEvaluationExpectationsResponse,
          EvaluationExpectation>
      LIST_EVALUATION_EXPECTATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListEvaluationExpectationsRequest,
              ListEvaluationExpectationsResponse,
              EvaluationExpectation>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListEvaluationExpectationsRequest injectToken(
                ListEvaluationExpectationsRequest payload, String token) {
              return ListEvaluationExpectationsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListEvaluationExpectationsRequest injectPageSize(
                ListEvaluationExpectationsRequest payload, int pageSize) {
              return ListEvaluationExpectationsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListEvaluationExpectationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListEvaluationExpectationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<EvaluationExpectation> extractResources(
                ListEvaluationExpectationsResponse payload) {
              return payload.getEvaluationExpectationsList();
            }
          };

  private static final PagedListDescriptor<
          ListScheduledEvaluationRunsRequest,
          ListScheduledEvaluationRunsResponse,
          ScheduledEvaluationRun>
      LIST_SCHEDULED_EVALUATION_RUNS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListScheduledEvaluationRunsRequest,
              ListScheduledEvaluationRunsResponse,
              ScheduledEvaluationRun>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListScheduledEvaluationRunsRequest injectToken(
                ListScheduledEvaluationRunsRequest payload, String token) {
              return ListScheduledEvaluationRunsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListScheduledEvaluationRunsRequest injectPageSize(
                ListScheduledEvaluationRunsRequest payload, int pageSize) {
              return ListScheduledEvaluationRunsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListScheduledEvaluationRunsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListScheduledEvaluationRunsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ScheduledEvaluationRun> extractResources(
                ListScheduledEvaluationRunsResponse payload) {
              return payload.getScheduledEvaluationRunsList();
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
          ListEvaluationsRequest, ListEvaluationsResponse, ListEvaluationsPagedResponse>
      LIST_EVALUATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListEvaluationsRequest, ListEvaluationsResponse, ListEvaluationsPagedResponse>() {
            @Override
            public ApiFuture<ListEvaluationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListEvaluationsRequest, ListEvaluationsResponse> callable,
                ListEvaluationsRequest request,
                ApiCallContext context,
                ApiFuture<ListEvaluationsResponse> futureResponse) {
              PageContext<ListEvaluationsRequest, ListEvaluationsResponse, Evaluation> pageContext =
                  PageContext.create(callable, LIST_EVALUATIONS_PAGE_STR_DESC, request, context);
              return ListEvaluationsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListEvaluationResultsRequest,
          ListEvaluationResultsResponse,
          ListEvaluationResultsPagedResponse>
      LIST_EVALUATION_RESULTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListEvaluationResultsRequest,
              ListEvaluationResultsResponse,
              ListEvaluationResultsPagedResponse>() {
            @Override
            public ApiFuture<ListEvaluationResultsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListEvaluationResultsRequest, ListEvaluationResultsResponse> callable,
                ListEvaluationResultsRequest request,
                ApiCallContext context,
                ApiFuture<ListEvaluationResultsResponse> futureResponse) {
              PageContext<
                      ListEvaluationResultsRequest, ListEvaluationResultsResponse, EvaluationResult>
                  pageContext =
                      PageContext.create(
                          callable, LIST_EVALUATION_RESULTS_PAGE_STR_DESC, request, context);
              return ListEvaluationResultsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListEvaluationDatasetsRequest,
          ListEvaluationDatasetsResponse,
          ListEvaluationDatasetsPagedResponse>
      LIST_EVALUATION_DATASETS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListEvaluationDatasetsRequest,
              ListEvaluationDatasetsResponse,
              ListEvaluationDatasetsPagedResponse>() {
            @Override
            public ApiFuture<ListEvaluationDatasetsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListEvaluationDatasetsRequest, ListEvaluationDatasetsResponse>
                    callable,
                ListEvaluationDatasetsRequest request,
                ApiCallContext context,
                ApiFuture<ListEvaluationDatasetsResponse> futureResponse) {
              PageContext<
                      ListEvaluationDatasetsRequest,
                      ListEvaluationDatasetsResponse,
                      EvaluationDataset>
                  pageContext =
                      PageContext.create(
                          callable, LIST_EVALUATION_DATASETS_PAGE_STR_DESC, request, context);
              return ListEvaluationDatasetsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListEvaluationRunsRequest, ListEvaluationRunsResponse, ListEvaluationRunsPagedResponse>
      LIST_EVALUATION_RUNS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListEvaluationRunsRequest,
              ListEvaluationRunsResponse,
              ListEvaluationRunsPagedResponse>() {
            @Override
            public ApiFuture<ListEvaluationRunsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListEvaluationRunsRequest, ListEvaluationRunsResponse> callable,
                ListEvaluationRunsRequest request,
                ApiCallContext context,
                ApiFuture<ListEvaluationRunsResponse> futureResponse) {
              PageContext<ListEvaluationRunsRequest, ListEvaluationRunsResponse, EvaluationRun>
                  pageContext =
                      PageContext.create(
                          callable, LIST_EVALUATION_RUNS_PAGE_STR_DESC, request, context);
              return ListEvaluationRunsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListEvaluationExpectationsRequest,
          ListEvaluationExpectationsResponse,
          ListEvaluationExpectationsPagedResponse>
      LIST_EVALUATION_EXPECTATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListEvaluationExpectationsRequest,
              ListEvaluationExpectationsResponse,
              ListEvaluationExpectationsPagedResponse>() {
            @Override
            public ApiFuture<ListEvaluationExpectationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListEvaluationExpectationsRequest, ListEvaluationExpectationsResponse>
                    callable,
                ListEvaluationExpectationsRequest request,
                ApiCallContext context,
                ApiFuture<ListEvaluationExpectationsResponse> futureResponse) {
              PageContext<
                      ListEvaluationExpectationsRequest,
                      ListEvaluationExpectationsResponse,
                      EvaluationExpectation>
                  pageContext =
                      PageContext.create(
                          callable, LIST_EVALUATION_EXPECTATIONS_PAGE_STR_DESC, request, context);
              return ListEvaluationExpectationsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListScheduledEvaluationRunsRequest,
          ListScheduledEvaluationRunsResponse,
          ListScheduledEvaluationRunsPagedResponse>
      LIST_SCHEDULED_EVALUATION_RUNS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListScheduledEvaluationRunsRequest,
              ListScheduledEvaluationRunsResponse,
              ListScheduledEvaluationRunsPagedResponse>() {
            @Override
            public ApiFuture<ListScheduledEvaluationRunsPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        ListScheduledEvaluationRunsRequest, ListScheduledEvaluationRunsResponse>
                    callable,
                ListScheduledEvaluationRunsRequest request,
                ApiCallContext context,
                ApiFuture<ListScheduledEvaluationRunsResponse> futureResponse) {
              PageContext<
                      ListScheduledEvaluationRunsRequest,
                      ListScheduledEvaluationRunsResponse,
                      ScheduledEvaluationRun>
                  pageContext =
                      PageContext.create(
                          callable, LIST_SCHEDULED_EVALUATION_RUNS_PAGE_STR_DESC, request, context);
              return ListScheduledEvaluationRunsPagedResponse.createAsync(
                  pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to runEvaluation. */
  public UnaryCallSettings<RunEvaluationRequest, Operation> runEvaluationSettings() {
    return runEvaluationSettings;
  }

  /** Returns the object with the settings used for calls to runEvaluation. */
  public OperationCallSettings<
          RunEvaluationRequest, RunEvaluationResponse, RunEvaluationOperationMetadata>
      runEvaluationOperationSettings() {
    return runEvaluationOperationSettings;
  }

  /** Returns the object with the settings used for calls to uploadEvaluationAudio. */
  public UnaryCallSettings<UploadEvaluationAudioRequest, UploadEvaluationAudioResponse>
      uploadEvaluationAudioSettings() {
    return uploadEvaluationAudioSettings;
  }

  /** Returns the object with the settings used for calls to createEvaluation. */
  public UnaryCallSettings<CreateEvaluationRequest, Evaluation> createEvaluationSettings() {
    return createEvaluationSettings;
  }

  /** Returns the object with the settings used for calls to generateEvaluation. */
  public UnaryCallSettings<GenerateEvaluationRequest, Operation> generateEvaluationSettings() {
    return generateEvaluationSettings;
  }

  /** Returns the object with the settings used for calls to generateEvaluation. */
  public OperationCallSettings<
          GenerateEvaluationRequest, Evaluation, GenerateEvaluationOperationMetadata>
      generateEvaluationOperationSettings() {
    return generateEvaluationOperationSettings;
  }

  /** Returns the object with the settings used for calls to importEvaluations. */
  public UnaryCallSettings<ImportEvaluationsRequest, Operation> importEvaluationsSettings() {
    return importEvaluationsSettings;
  }

  /** Returns the object with the settings used for calls to importEvaluations. */
  public OperationCallSettings<
          ImportEvaluationsRequest, ImportEvaluationsResponse, ImportEvaluationsOperationMetadata>
      importEvaluationsOperationSettings() {
    return importEvaluationsOperationSettings;
  }

  /** Returns the object with the settings used for calls to createEvaluationDataset. */
  public UnaryCallSettings<CreateEvaluationDatasetRequest, EvaluationDataset>
      createEvaluationDatasetSettings() {
    return createEvaluationDatasetSettings;
  }

  /** Returns the object with the settings used for calls to updateEvaluation. */
  public UnaryCallSettings<UpdateEvaluationRequest, Evaluation> updateEvaluationSettings() {
    return updateEvaluationSettings;
  }

  /** Returns the object with the settings used for calls to updateEvaluationDataset. */
  public UnaryCallSettings<UpdateEvaluationDatasetRequest, EvaluationDataset>
      updateEvaluationDatasetSettings() {
    return updateEvaluationDatasetSettings;
  }

  /** Returns the object with the settings used for calls to deleteEvaluation. */
  public UnaryCallSettings<DeleteEvaluationRequest, Empty> deleteEvaluationSettings() {
    return deleteEvaluationSettings;
  }

  /** Returns the object with the settings used for calls to deleteEvaluationResult. */
  public UnaryCallSettings<DeleteEvaluationResultRequest, Empty> deleteEvaluationResultSettings() {
    return deleteEvaluationResultSettings;
  }

  /** Returns the object with the settings used for calls to deleteEvaluationDataset. */
  public UnaryCallSettings<DeleteEvaluationDatasetRequest, Empty>
      deleteEvaluationDatasetSettings() {
    return deleteEvaluationDatasetSettings;
  }

  /** Returns the object with the settings used for calls to deleteEvaluationRun. */
  public UnaryCallSettings<DeleteEvaluationRunRequest, Operation> deleteEvaluationRunSettings() {
    return deleteEvaluationRunSettings;
  }

  /** Returns the object with the settings used for calls to deleteEvaluationRun. */
  public OperationCallSettings<
          DeleteEvaluationRunRequest, Empty, DeleteEvaluationRunOperationMetadata>
      deleteEvaluationRunOperationSettings() {
    return deleteEvaluationRunOperationSettings;
  }

  /** Returns the object with the settings used for calls to getEvaluation. */
  public UnaryCallSettings<GetEvaluationRequest, Evaluation> getEvaluationSettings() {
    return getEvaluationSettings;
  }

  /** Returns the object with the settings used for calls to getEvaluationResult. */
  public UnaryCallSettings<GetEvaluationResultRequest, EvaluationResult>
      getEvaluationResultSettings() {
    return getEvaluationResultSettings;
  }

  /** Returns the object with the settings used for calls to getEvaluationDataset. */
  public UnaryCallSettings<GetEvaluationDatasetRequest, EvaluationDataset>
      getEvaluationDatasetSettings() {
    return getEvaluationDatasetSettings;
  }

  /** Returns the object with the settings used for calls to getEvaluationRun. */
  public UnaryCallSettings<GetEvaluationRunRequest, EvaluationRun> getEvaluationRunSettings() {
    return getEvaluationRunSettings;
  }

  /** Returns the object with the settings used for calls to listEvaluations. */
  public PagedCallSettings<
          ListEvaluationsRequest, ListEvaluationsResponse, ListEvaluationsPagedResponse>
      listEvaluationsSettings() {
    return listEvaluationsSettings;
  }

  /** Returns the object with the settings used for calls to listEvaluationResults. */
  public PagedCallSettings<
          ListEvaluationResultsRequest,
          ListEvaluationResultsResponse,
          ListEvaluationResultsPagedResponse>
      listEvaluationResultsSettings() {
    return listEvaluationResultsSettings;
  }

  /** Returns the object with the settings used for calls to listEvaluationDatasets. */
  public PagedCallSettings<
          ListEvaluationDatasetsRequest,
          ListEvaluationDatasetsResponse,
          ListEvaluationDatasetsPagedResponse>
      listEvaluationDatasetsSettings() {
    return listEvaluationDatasetsSettings;
  }

  /** Returns the object with the settings used for calls to listEvaluationRuns. */
  public PagedCallSettings<
          ListEvaluationRunsRequest, ListEvaluationRunsResponse, ListEvaluationRunsPagedResponse>
      listEvaluationRunsSettings() {
    return listEvaluationRunsSettings;
  }

  /** Returns the object with the settings used for calls to listEvaluationExpectations. */
  public PagedCallSettings<
          ListEvaluationExpectationsRequest,
          ListEvaluationExpectationsResponse,
          ListEvaluationExpectationsPagedResponse>
      listEvaluationExpectationsSettings() {
    return listEvaluationExpectationsSettings;
  }

  /** Returns the object with the settings used for calls to getEvaluationExpectation. */
  public UnaryCallSettings<GetEvaluationExpectationRequest, EvaluationExpectation>
      getEvaluationExpectationSettings() {
    return getEvaluationExpectationSettings;
  }

  /** Returns the object with the settings used for calls to createEvaluationExpectation. */
  public UnaryCallSettings<CreateEvaluationExpectationRequest, EvaluationExpectation>
      createEvaluationExpectationSettings() {
    return createEvaluationExpectationSettings;
  }

  /** Returns the object with the settings used for calls to updateEvaluationExpectation. */
  public UnaryCallSettings<UpdateEvaluationExpectationRequest, EvaluationExpectation>
      updateEvaluationExpectationSettings() {
    return updateEvaluationExpectationSettings;
  }

  /** Returns the object with the settings used for calls to deleteEvaluationExpectation. */
  public UnaryCallSettings<DeleteEvaluationExpectationRequest, Empty>
      deleteEvaluationExpectationSettings() {
    return deleteEvaluationExpectationSettings;
  }

  /** Returns the object with the settings used for calls to createScheduledEvaluationRun. */
  public UnaryCallSettings<CreateScheduledEvaluationRunRequest, ScheduledEvaluationRun>
      createScheduledEvaluationRunSettings() {
    return createScheduledEvaluationRunSettings;
  }

  /** Returns the object with the settings used for calls to getScheduledEvaluationRun. */
  public UnaryCallSettings<GetScheduledEvaluationRunRequest, ScheduledEvaluationRun>
      getScheduledEvaluationRunSettings() {
    return getScheduledEvaluationRunSettings;
  }

  /** Returns the object with the settings used for calls to listScheduledEvaluationRuns. */
  public PagedCallSettings<
          ListScheduledEvaluationRunsRequest,
          ListScheduledEvaluationRunsResponse,
          ListScheduledEvaluationRunsPagedResponse>
      listScheduledEvaluationRunsSettings() {
    return listScheduledEvaluationRunsSettings;
  }

  /** Returns the object with the settings used for calls to updateScheduledEvaluationRun. */
  public UnaryCallSettings<UpdateScheduledEvaluationRunRequest, ScheduledEvaluationRun>
      updateScheduledEvaluationRunSettings() {
    return updateScheduledEvaluationRunSettings;
  }

  /** Returns the object with the settings used for calls to deleteScheduledEvaluationRun. */
  public UnaryCallSettings<DeleteScheduledEvaluationRunRequest, Empty>
      deleteScheduledEvaluationRunSettings() {
    return deleteScheduledEvaluationRunSettings;
  }

  /** Returns the object with the settings used for calls to testPersonaVoice. */
  public UnaryCallSettings<TestPersonaVoiceRequest, TestPersonaVoiceResponse>
      testPersonaVoiceSettings() {
    return testPersonaVoiceSettings;
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

  public EvaluationServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcEvaluationServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonEvaluationServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "ces";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "ces.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "ces.mtls.googleapis.com:443";
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
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(EvaluationServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(EvaluationServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return EvaluationServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected EvaluationServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    runEvaluationSettings = settingsBuilder.runEvaluationSettings().build();
    runEvaluationOperationSettings = settingsBuilder.runEvaluationOperationSettings().build();
    uploadEvaluationAudioSettings = settingsBuilder.uploadEvaluationAudioSettings().build();
    createEvaluationSettings = settingsBuilder.createEvaluationSettings().build();
    generateEvaluationSettings = settingsBuilder.generateEvaluationSettings().build();
    generateEvaluationOperationSettings =
        settingsBuilder.generateEvaluationOperationSettings().build();
    importEvaluationsSettings = settingsBuilder.importEvaluationsSettings().build();
    importEvaluationsOperationSettings =
        settingsBuilder.importEvaluationsOperationSettings().build();
    createEvaluationDatasetSettings = settingsBuilder.createEvaluationDatasetSettings().build();
    updateEvaluationSettings = settingsBuilder.updateEvaluationSettings().build();
    updateEvaluationDatasetSettings = settingsBuilder.updateEvaluationDatasetSettings().build();
    deleteEvaluationSettings = settingsBuilder.deleteEvaluationSettings().build();
    deleteEvaluationResultSettings = settingsBuilder.deleteEvaluationResultSettings().build();
    deleteEvaluationDatasetSettings = settingsBuilder.deleteEvaluationDatasetSettings().build();
    deleteEvaluationRunSettings = settingsBuilder.deleteEvaluationRunSettings().build();
    deleteEvaluationRunOperationSettings =
        settingsBuilder.deleteEvaluationRunOperationSettings().build();
    getEvaluationSettings = settingsBuilder.getEvaluationSettings().build();
    getEvaluationResultSettings = settingsBuilder.getEvaluationResultSettings().build();
    getEvaluationDatasetSettings = settingsBuilder.getEvaluationDatasetSettings().build();
    getEvaluationRunSettings = settingsBuilder.getEvaluationRunSettings().build();
    listEvaluationsSettings = settingsBuilder.listEvaluationsSettings().build();
    listEvaluationResultsSettings = settingsBuilder.listEvaluationResultsSettings().build();
    listEvaluationDatasetsSettings = settingsBuilder.listEvaluationDatasetsSettings().build();
    listEvaluationRunsSettings = settingsBuilder.listEvaluationRunsSettings().build();
    listEvaluationExpectationsSettings =
        settingsBuilder.listEvaluationExpectationsSettings().build();
    getEvaluationExpectationSettings = settingsBuilder.getEvaluationExpectationSettings().build();
    createEvaluationExpectationSettings =
        settingsBuilder.createEvaluationExpectationSettings().build();
    updateEvaluationExpectationSettings =
        settingsBuilder.updateEvaluationExpectationSettings().build();
    deleteEvaluationExpectationSettings =
        settingsBuilder.deleteEvaluationExpectationSettings().build();
    createScheduledEvaluationRunSettings =
        settingsBuilder.createScheduledEvaluationRunSettings().build();
    getScheduledEvaluationRunSettings = settingsBuilder.getScheduledEvaluationRunSettings().build();
    listScheduledEvaluationRunsSettings =
        settingsBuilder.listScheduledEvaluationRunsSettings().build();
    updateScheduledEvaluationRunSettings =
        settingsBuilder.updateScheduledEvaluationRunSettings().build();
    deleteScheduledEvaluationRunSettings =
        settingsBuilder.deleteScheduledEvaluationRunSettings().build();
    testPersonaVoiceSettings = settingsBuilder.testPersonaVoiceSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  /** Builder for EvaluationServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<EvaluationServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<RunEvaluationRequest, Operation> runEvaluationSettings;
    private final OperationCallSettings.Builder<
            RunEvaluationRequest, RunEvaluationResponse, RunEvaluationOperationMetadata>
        runEvaluationOperationSettings;
    private final UnaryCallSettings.Builder<
            UploadEvaluationAudioRequest, UploadEvaluationAudioResponse>
        uploadEvaluationAudioSettings;
    private final UnaryCallSettings.Builder<CreateEvaluationRequest, Evaluation>
        createEvaluationSettings;
    private final UnaryCallSettings.Builder<GenerateEvaluationRequest, Operation>
        generateEvaluationSettings;
    private final OperationCallSettings.Builder<
            GenerateEvaluationRequest, Evaluation, GenerateEvaluationOperationMetadata>
        generateEvaluationOperationSettings;
    private final UnaryCallSettings.Builder<ImportEvaluationsRequest, Operation>
        importEvaluationsSettings;
    private final OperationCallSettings.Builder<
            ImportEvaluationsRequest, ImportEvaluationsResponse, ImportEvaluationsOperationMetadata>
        importEvaluationsOperationSettings;
    private final UnaryCallSettings.Builder<CreateEvaluationDatasetRequest, EvaluationDataset>
        createEvaluationDatasetSettings;
    private final UnaryCallSettings.Builder<UpdateEvaluationRequest, Evaluation>
        updateEvaluationSettings;
    private final UnaryCallSettings.Builder<UpdateEvaluationDatasetRequest, EvaluationDataset>
        updateEvaluationDatasetSettings;
    private final UnaryCallSettings.Builder<DeleteEvaluationRequest, Empty>
        deleteEvaluationSettings;
    private final UnaryCallSettings.Builder<DeleteEvaluationResultRequest, Empty>
        deleteEvaluationResultSettings;
    private final UnaryCallSettings.Builder<DeleteEvaluationDatasetRequest, Empty>
        deleteEvaluationDatasetSettings;
    private final UnaryCallSettings.Builder<DeleteEvaluationRunRequest, Operation>
        deleteEvaluationRunSettings;
    private final OperationCallSettings.Builder<
            DeleteEvaluationRunRequest, Empty, DeleteEvaluationRunOperationMetadata>
        deleteEvaluationRunOperationSettings;
    private final UnaryCallSettings.Builder<GetEvaluationRequest, Evaluation> getEvaluationSettings;
    private final UnaryCallSettings.Builder<GetEvaluationResultRequest, EvaluationResult>
        getEvaluationResultSettings;
    private final UnaryCallSettings.Builder<GetEvaluationDatasetRequest, EvaluationDataset>
        getEvaluationDatasetSettings;
    private final UnaryCallSettings.Builder<GetEvaluationRunRequest, EvaluationRun>
        getEvaluationRunSettings;
    private final PagedCallSettings.Builder<
            ListEvaluationsRequest, ListEvaluationsResponse, ListEvaluationsPagedResponse>
        listEvaluationsSettings;
    private final PagedCallSettings.Builder<
            ListEvaluationResultsRequest,
            ListEvaluationResultsResponse,
            ListEvaluationResultsPagedResponse>
        listEvaluationResultsSettings;
    private final PagedCallSettings.Builder<
            ListEvaluationDatasetsRequest,
            ListEvaluationDatasetsResponse,
            ListEvaluationDatasetsPagedResponse>
        listEvaluationDatasetsSettings;
    private final PagedCallSettings.Builder<
            ListEvaluationRunsRequest, ListEvaluationRunsResponse, ListEvaluationRunsPagedResponse>
        listEvaluationRunsSettings;
    private final PagedCallSettings.Builder<
            ListEvaluationExpectationsRequest,
            ListEvaluationExpectationsResponse,
            ListEvaluationExpectationsPagedResponse>
        listEvaluationExpectationsSettings;
    private final UnaryCallSettings.Builder<GetEvaluationExpectationRequest, EvaluationExpectation>
        getEvaluationExpectationSettings;
    private final UnaryCallSettings.Builder<
            CreateEvaluationExpectationRequest, EvaluationExpectation>
        createEvaluationExpectationSettings;
    private final UnaryCallSettings.Builder<
            UpdateEvaluationExpectationRequest, EvaluationExpectation>
        updateEvaluationExpectationSettings;
    private final UnaryCallSettings.Builder<DeleteEvaluationExpectationRequest, Empty>
        deleteEvaluationExpectationSettings;
    private final UnaryCallSettings.Builder<
            CreateScheduledEvaluationRunRequest, ScheduledEvaluationRun>
        createScheduledEvaluationRunSettings;
    private final UnaryCallSettings.Builder<
            GetScheduledEvaluationRunRequest, ScheduledEvaluationRun>
        getScheduledEvaluationRunSettings;
    private final PagedCallSettings.Builder<
            ListScheduledEvaluationRunsRequest,
            ListScheduledEvaluationRunsResponse,
            ListScheduledEvaluationRunsPagedResponse>
        listScheduledEvaluationRunsSettings;
    private final UnaryCallSettings.Builder<
            UpdateScheduledEvaluationRunRequest, ScheduledEvaluationRun>
        updateScheduledEvaluationRunSettings;
    private final UnaryCallSettings.Builder<DeleteScheduledEvaluationRunRequest, Empty>
        deleteScheduledEvaluationRunSettings;
    private final UnaryCallSettings.Builder<TestPersonaVoiceRequest, TestPersonaVoiceResponse>
        testPersonaVoiceSettings;
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
          "retry_policy_0_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(60000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      runEvaluationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      runEvaluationOperationSettings = OperationCallSettings.newBuilder();
      uploadEvaluationAudioSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createEvaluationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      generateEvaluationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      generateEvaluationOperationSettings = OperationCallSettings.newBuilder();
      importEvaluationsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      importEvaluationsOperationSettings = OperationCallSettings.newBuilder();
      createEvaluationDatasetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateEvaluationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateEvaluationDatasetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteEvaluationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteEvaluationResultSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteEvaluationDatasetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteEvaluationRunSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteEvaluationRunOperationSettings = OperationCallSettings.newBuilder();
      getEvaluationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getEvaluationResultSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getEvaluationDatasetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getEvaluationRunSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listEvaluationsSettings = PagedCallSettings.newBuilder(LIST_EVALUATIONS_PAGE_STR_FACT);
      listEvaluationResultsSettings =
          PagedCallSettings.newBuilder(LIST_EVALUATION_RESULTS_PAGE_STR_FACT);
      listEvaluationDatasetsSettings =
          PagedCallSettings.newBuilder(LIST_EVALUATION_DATASETS_PAGE_STR_FACT);
      listEvaluationRunsSettings = PagedCallSettings.newBuilder(LIST_EVALUATION_RUNS_PAGE_STR_FACT);
      listEvaluationExpectationsSettings =
          PagedCallSettings.newBuilder(LIST_EVALUATION_EXPECTATIONS_PAGE_STR_FACT);
      getEvaluationExpectationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createEvaluationExpectationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateEvaluationExpectationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteEvaluationExpectationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createScheduledEvaluationRunSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getScheduledEvaluationRunSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listScheduledEvaluationRunsSettings =
          PagedCallSettings.newBuilder(LIST_SCHEDULED_EVALUATION_RUNS_PAGE_STR_FACT);
      updateScheduledEvaluationRunSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteScheduledEvaluationRunSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testPersonaVoiceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              runEvaluationSettings,
              uploadEvaluationAudioSettings,
              createEvaluationSettings,
              generateEvaluationSettings,
              importEvaluationsSettings,
              createEvaluationDatasetSettings,
              updateEvaluationSettings,
              updateEvaluationDatasetSettings,
              deleteEvaluationSettings,
              deleteEvaluationResultSettings,
              deleteEvaluationDatasetSettings,
              deleteEvaluationRunSettings,
              getEvaluationSettings,
              getEvaluationResultSettings,
              getEvaluationDatasetSettings,
              getEvaluationRunSettings,
              listEvaluationsSettings,
              listEvaluationResultsSettings,
              listEvaluationDatasetsSettings,
              listEvaluationRunsSettings,
              listEvaluationExpectationsSettings,
              getEvaluationExpectationSettings,
              createEvaluationExpectationSettings,
              updateEvaluationExpectationSettings,
              deleteEvaluationExpectationSettings,
              createScheduledEvaluationRunSettings,
              getScheduledEvaluationRunSettings,
              listScheduledEvaluationRunsSettings,
              updateScheduledEvaluationRunSettings,
              deleteScheduledEvaluationRunSettings,
              testPersonaVoiceSettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(EvaluationServiceStubSettings settings) {
      super(settings);

      runEvaluationSettings = settings.runEvaluationSettings.toBuilder();
      runEvaluationOperationSettings = settings.runEvaluationOperationSettings.toBuilder();
      uploadEvaluationAudioSettings = settings.uploadEvaluationAudioSettings.toBuilder();
      createEvaluationSettings = settings.createEvaluationSettings.toBuilder();
      generateEvaluationSettings = settings.generateEvaluationSettings.toBuilder();
      generateEvaluationOperationSettings =
          settings.generateEvaluationOperationSettings.toBuilder();
      importEvaluationsSettings = settings.importEvaluationsSettings.toBuilder();
      importEvaluationsOperationSettings = settings.importEvaluationsOperationSettings.toBuilder();
      createEvaluationDatasetSettings = settings.createEvaluationDatasetSettings.toBuilder();
      updateEvaluationSettings = settings.updateEvaluationSettings.toBuilder();
      updateEvaluationDatasetSettings = settings.updateEvaluationDatasetSettings.toBuilder();
      deleteEvaluationSettings = settings.deleteEvaluationSettings.toBuilder();
      deleteEvaluationResultSettings = settings.deleteEvaluationResultSettings.toBuilder();
      deleteEvaluationDatasetSettings = settings.deleteEvaluationDatasetSettings.toBuilder();
      deleteEvaluationRunSettings = settings.deleteEvaluationRunSettings.toBuilder();
      deleteEvaluationRunOperationSettings =
          settings.deleteEvaluationRunOperationSettings.toBuilder();
      getEvaluationSettings = settings.getEvaluationSettings.toBuilder();
      getEvaluationResultSettings = settings.getEvaluationResultSettings.toBuilder();
      getEvaluationDatasetSettings = settings.getEvaluationDatasetSettings.toBuilder();
      getEvaluationRunSettings = settings.getEvaluationRunSettings.toBuilder();
      listEvaluationsSettings = settings.listEvaluationsSettings.toBuilder();
      listEvaluationResultsSettings = settings.listEvaluationResultsSettings.toBuilder();
      listEvaluationDatasetsSettings = settings.listEvaluationDatasetsSettings.toBuilder();
      listEvaluationRunsSettings = settings.listEvaluationRunsSettings.toBuilder();
      listEvaluationExpectationsSettings = settings.listEvaluationExpectationsSettings.toBuilder();
      getEvaluationExpectationSettings = settings.getEvaluationExpectationSettings.toBuilder();
      createEvaluationExpectationSettings =
          settings.createEvaluationExpectationSettings.toBuilder();
      updateEvaluationExpectationSettings =
          settings.updateEvaluationExpectationSettings.toBuilder();
      deleteEvaluationExpectationSettings =
          settings.deleteEvaluationExpectationSettings.toBuilder();
      createScheduledEvaluationRunSettings =
          settings.createScheduledEvaluationRunSettings.toBuilder();
      getScheduledEvaluationRunSettings = settings.getScheduledEvaluationRunSettings.toBuilder();
      listScheduledEvaluationRunsSettings =
          settings.listScheduledEvaluationRunsSettings.toBuilder();
      updateScheduledEvaluationRunSettings =
          settings.updateScheduledEvaluationRunSettings.toBuilder();
      deleteScheduledEvaluationRunSettings =
          settings.deleteScheduledEvaluationRunSettings.toBuilder();
      testPersonaVoiceSettings = settings.testPersonaVoiceSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              runEvaluationSettings,
              uploadEvaluationAudioSettings,
              createEvaluationSettings,
              generateEvaluationSettings,
              importEvaluationsSettings,
              createEvaluationDatasetSettings,
              updateEvaluationSettings,
              updateEvaluationDatasetSettings,
              deleteEvaluationSettings,
              deleteEvaluationResultSettings,
              deleteEvaluationDatasetSettings,
              deleteEvaluationRunSettings,
              getEvaluationSettings,
              getEvaluationResultSettings,
              getEvaluationDatasetSettings,
              getEvaluationRunSettings,
              listEvaluationsSettings,
              listEvaluationResultsSettings,
              listEvaluationDatasetsSettings,
              listEvaluationRunsSettings,
              listEvaluationExpectationsSettings,
              getEvaluationExpectationSettings,
              createEvaluationExpectationSettings,
              updateEvaluationExpectationSettings,
              deleteEvaluationExpectationSettings,
              createScheduledEvaluationRunSettings,
              getScheduledEvaluationRunSettings,
              listScheduledEvaluationRunsSettings,
              updateScheduledEvaluationRunSettings,
              deleteScheduledEvaluationRunSettings,
              testPersonaVoiceSettings,
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
          .runEvaluationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .uploadEvaluationAudioSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createEvaluationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .generateEvaluationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .importEvaluationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createEvaluationDatasetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateEvaluationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateEvaluationDatasetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteEvaluationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteEvaluationResultSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteEvaluationDatasetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteEvaluationRunSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getEvaluationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getEvaluationResultSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getEvaluationDatasetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getEvaluationRunSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listEvaluationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listEvaluationResultsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listEvaluationDatasetsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listEvaluationRunsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listEvaluationExpectationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getEvaluationExpectationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createEvaluationExpectationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateEvaluationExpectationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteEvaluationExpectationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createScheduledEvaluationRunSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getScheduledEvaluationRunSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listScheduledEvaluationRunsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateScheduledEvaluationRunSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteScheduledEvaluationRunSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .testPersonaVoiceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getLocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .runEvaluationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<RunEvaluationRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(RunEvaluationResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  RunEvaluationOperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .generateEvaluationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<GenerateEvaluationRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Evaluation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  GenerateEvaluationOperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .importEvaluationsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ImportEvaluationsRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  ImportEvaluationsResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  ImportEvaluationsOperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteEvaluationRunOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteEvaluationRunRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  DeleteEvaluationRunOperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
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

    /** Returns the builder for the settings used for calls to runEvaluation. */
    public UnaryCallSettings.Builder<RunEvaluationRequest, Operation> runEvaluationSettings() {
      return runEvaluationSettings;
    }

    /** Returns the builder for the settings used for calls to runEvaluation. */
    public OperationCallSettings.Builder<
            RunEvaluationRequest, RunEvaluationResponse, RunEvaluationOperationMetadata>
        runEvaluationOperationSettings() {
      return runEvaluationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to uploadEvaluationAudio. */
    public UnaryCallSettings.Builder<UploadEvaluationAudioRequest, UploadEvaluationAudioResponse>
        uploadEvaluationAudioSettings() {
      return uploadEvaluationAudioSettings;
    }

    /** Returns the builder for the settings used for calls to createEvaluation. */
    public UnaryCallSettings.Builder<CreateEvaluationRequest, Evaluation>
        createEvaluationSettings() {
      return createEvaluationSettings;
    }

    /** Returns the builder for the settings used for calls to generateEvaluation. */
    public UnaryCallSettings.Builder<GenerateEvaluationRequest, Operation>
        generateEvaluationSettings() {
      return generateEvaluationSettings;
    }

    /** Returns the builder for the settings used for calls to generateEvaluation. */
    public OperationCallSettings.Builder<
            GenerateEvaluationRequest, Evaluation, GenerateEvaluationOperationMetadata>
        generateEvaluationOperationSettings() {
      return generateEvaluationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to importEvaluations. */
    public UnaryCallSettings.Builder<ImportEvaluationsRequest, Operation>
        importEvaluationsSettings() {
      return importEvaluationsSettings;
    }

    /** Returns the builder for the settings used for calls to importEvaluations. */
    public OperationCallSettings.Builder<
            ImportEvaluationsRequest, ImportEvaluationsResponse, ImportEvaluationsOperationMetadata>
        importEvaluationsOperationSettings() {
      return importEvaluationsOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createEvaluationDataset. */
    public UnaryCallSettings.Builder<CreateEvaluationDatasetRequest, EvaluationDataset>
        createEvaluationDatasetSettings() {
      return createEvaluationDatasetSettings;
    }

    /** Returns the builder for the settings used for calls to updateEvaluation. */
    public UnaryCallSettings.Builder<UpdateEvaluationRequest, Evaluation>
        updateEvaluationSettings() {
      return updateEvaluationSettings;
    }

    /** Returns the builder for the settings used for calls to updateEvaluationDataset. */
    public UnaryCallSettings.Builder<UpdateEvaluationDatasetRequest, EvaluationDataset>
        updateEvaluationDatasetSettings() {
      return updateEvaluationDatasetSettings;
    }

    /** Returns the builder for the settings used for calls to deleteEvaluation. */
    public UnaryCallSettings.Builder<DeleteEvaluationRequest, Empty> deleteEvaluationSettings() {
      return deleteEvaluationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteEvaluationResult. */
    public UnaryCallSettings.Builder<DeleteEvaluationResultRequest, Empty>
        deleteEvaluationResultSettings() {
      return deleteEvaluationResultSettings;
    }

    /** Returns the builder for the settings used for calls to deleteEvaluationDataset. */
    public UnaryCallSettings.Builder<DeleteEvaluationDatasetRequest, Empty>
        deleteEvaluationDatasetSettings() {
      return deleteEvaluationDatasetSettings;
    }

    /** Returns the builder for the settings used for calls to deleteEvaluationRun. */
    public UnaryCallSettings.Builder<DeleteEvaluationRunRequest, Operation>
        deleteEvaluationRunSettings() {
      return deleteEvaluationRunSettings;
    }

    /** Returns the builder for the settings used for calls to deleteEvaluationRun. */
    public OperationCallSettings.Builder<
            DeleteEvaluationRunRequest, Empty, DeleteEvaluationRunOperationMetadata>
        deleteEvaluationRunOperationSettings() {
      return deleteEvaluationRunOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getEvaluation. */
    public UnaryCallSettings.Builder<GetEvaluationRequest, Evaluation> getEvaluationSettings() {
      return getEvaluationSettings;
    }

    /** Returns the builder for the settings used for calls to getEvaluationResult. */
    public UnaryCallSettings.Builder<GetEvaluationResultRequest, EvaluationResult>
        getEvaluationResultSettings() {
      return getEvaluationResultSettings;
    }

    /** Returns the builder for the settings used for calls to getEvaluationDataset. */
    public UnaryCallSettings.Builder<GetEvaluationDatasetRequest, EvaluationDataset>
        getEvaluationDatasetSettings() {
      return getEvaluationDatasetSettings;
    }

    /** Returns the builder for the settings used for calls to getEvaluationRun. */
    public UnaryCallSettings.Builder<GetEvaluationRunRequest, EvaluationRun>
        getEvaluationRunSettings() {
      return getEvaluationRunSettings;
    }

    /** Returns the builder for the settings used for calls to listEvaluations. */
    public PagedCallSettings.Builder<
            ListEvaluationsRequest, ListEvaluationsResponse, ListEvaluationsPagedResponse>
        listEvaluationsSettings() {
      return listEvaluationsSettings;
    }

    /** Returns the builder for the settings used for calls to listEvaluationResults. */
    public PagedCallSettings.Builder<
            ListEvaluationResultsRequest,
            ListEvaluationResultsResponse,
            ListEvaluationResultsPagedResponse>
        listEvaluationResultsSettings() {
      return listEvaluationResultsSettings;
    }

    /** Returns the builder for the settings used for calls to listEvaluationDatasets. */
    public PagedCallSettings.Builder<
            ListEvaluationDatasetsRequest,
            ListEvaluationDatasetsResponse,
            ListEvaluationDatasetsPagedResponse>
        listEvaluationDatasetsSettings() {
      return listEvaluationDatasetsSettings;
    }

    /** Returns the builder for the settings used for calls to listEvaluationRuns. */
    public PagedCallSettings.Builder<
            ListEvaluationRunsRequest, ListEvaluationRunsResponse, ListEvaluationRunsPagedResponse>
        listEvaluationRunsSettings() {
      return listEvaluationRunsSettings;
    }

    /** Returns the builder for the settings used for calls to listEvaluationExpectations. */
    public PagedCallSettings.Builder<
            ListEvaluationExpectationsRequest,
            ListEvaluationExpectationsResponse,
            ListEvaluationExpectationsPagedResponse>
        listEvaluationExpectationsSettings() {
      return listEvaluationExpectationsSettings;
    }

    /** Returns the builder for the settings used for calls to getEvaluationExpectation. */
    public UnaryCallSettings.Builder<GetEvaluationExpectationRequest, EvaluationExpectation>
        getEvaluationExpectationSettings() {
      return getEvaluationExpectationSettings;
    }

    /** Returns the builder for the settings used for calls to createEvaluationExpectation. */
    public UnaryCallSettings.Builder<CreateEvaluationExpectationRequest, EvaluationExpectation>
        createEvaluationExpectationSettings() {
      return createEvaluationExpectationSettings;
    }

    /** Returns the builder for the settings used for calls to updateEvaluationExpectation. */
    public UnaryCallSettings.Builder<UpdateEvaluationExpectationRequest, EvaluationExpectation>
        updateEvaluationExpectationSettings() {
      return updateEvaluationExpectationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteEvaluationExpectation. */
    public UnaryCallSettings.Builder<DeleteEvaluationExpectationRequest, Empty>
        deleteEvaluationExpectationSettings() {
      return deleteEvaluationExpectationSettings;
    }

    /** Returns the builder for the settings used for calls to createScheduledEvaluationRun. */
    public UnaryCallSettings.Builder<CreateScheduledEvaluationRunRequest, ScheduledEvaluationRun>
        createScheduledEvaluationRunSettings() {
      return createScheduledEvaluationRunSettings;
    }

    /** Returns the builder for the settings used for calls to getScheduledEvaluationRun. */
    public UnaryCallSettings.Builder<GetScheduledEvaluationRunRequest, ScheduledEvaluationRun>
        getScheduledEvaluationRunSettings() {
      return getScheduledEvaluationRunSettings;
    }

    /** Returns the builder for the settings used for calls to listScheduledEvaluationRuns. */
    public PagedCallSettings.Builder<
            ListScheduledEvaluationRunsRequest,
            ListScheduledEvaluationRunsResponse,
            ListScheduledEvaluationRunsPagedResponse>
        listScheduledEvaluationRunsSettings() {
      return listScheduledEvaluationRunsSettings;
    }

    /** Returns the builder for the settings used for calls to updateScheduledEvaluationRun. */
    public UnaryCallSettings.Builder<UpdateScheduledEvaluationRunRequest, ScheduledEvaluationRun>
        updateScheduledEvaluationRunSettings() {
      return updateScheduledEvaluationRunSettings;
    }

    /** Returns the builder for the settings used for calls to deleteScheduledEvaluationRun. */
    public UnaryCallSettings.Builder<DeleteScheduledEvaluationRunRequest, Empty>
        deleteScheduledEvaluationRunSettings() {
      return deleteScheduledEvaluationRunSettings;
    }

    /** Returns the builder for the settings used for calls to testPersonaVoice. */
    public UnaryCallSettings.Builder<TestPersonaVoiceRequest, TestPersonaVoiceResponse>
        testPersonaVoiceSettings() {
      return testPersonaVoiceSettings;
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
    public EvaluationServiceStubSettings build() throws IOException {
      return new EvaluationServiceStubSettings(this);
    }
  }
}
