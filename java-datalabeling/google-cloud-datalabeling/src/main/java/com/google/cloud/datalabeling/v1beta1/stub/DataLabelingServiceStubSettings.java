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

package com.google.cloud.datalabeling.v1beta1.stub;

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
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.grpc.ProtoOperationTransformers;
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
import com.google.cloud.datalabeling.v1beta1.AnnotatedDataset;
import com.google.cloud.datalabeling.v1beta1.AnnotationSpecSet;
import com.google.cloud.datalabeling.v1beta1.CreateAnnotationSpecSetRequest;
import com.google.cloud.datalabeling.v1beta1.CreateDatasetRequest;
import com.google.cloud.datalabeling.v1beta1.CreateEvaluationJobRequest;
import com.google.cloud.datalabeling.v1beta1.CreateInstructionMetadata;
import com.google.cloud.datalabeling.v1beta1.CreateInstructionRequest;
import com.google.cloud.datalabeling.v1beta1.DataItem;
import com.google.cloud.datalabeling.v1beta1.Dataset;
import com.google.cloud.datalabeling.v1beta1.DeleteAnnotatedDatasetRequest;
import com.google.cloud.datalabeling.v1beta1.DeleteAnnotationSpecSetRequest;
import com.google.cloud.datalabeling.v1beta1.DeleteDatasetRequest;
import com.google.cloud.datalabeling.v1beta1.DeleteEvaluationJobRequest;
import com.google.cloud.datalabeling.v1beta1.DeleteInstructionRequest;
import com.google.cloud.datalabeling.v1beta1.Evaluation;
import com.google.cloud.datalabeling.v1beta1.EvaluationJob;
import com.google.cloud.datalabeling.v1beta1.Example;
import com.google.cloud.datalabeling.v1beta1.ExportDataOperationMetadata;
import com.google.cloud.datalabeling.v1beta1.ExportDataOperationResponse;
import com.google.cloud.datalabeling.v1beta1.ExportDataRequest;
import com.google.cloud.datalabeling.v1beta1.GetAnnotatedDatasetRequest;
import com.google.cloud.datalabeling.v1beta1.GetAnnotationSpecSetRequest;
import com.google.cloud.datalabeling.v1beta1.GetDataItemRequest;
import com.google.cloud.datalabeling.v1beta1.GetDatasetRequest;
import com.google.cloud.datalabeling.v1beta1.GetEvaluationJobRequest;
import com.google.cloud.datalabeling.v1beta1.GetEvaluationRequest;
import com.google.cloud.datalabeling.v1beta1.GetExampleRequest;
import com.google.cloud.datalabeling.v1beta1.GetInstructionRequest;
import com.google.cloud.datalabeling.v1beta1.ImportDataOperationMetadata;
import com.google.cloud.datalabeling.v1beta1.ImportDataOperationResponse;
import com.google.cloud.datalabeling.v1beta1.ImportDataRequest;
import com.google.cloud.datalabeling.v1beta1.Instruction;
import com.google.cloud.datalabeling.v1beta1.LabelImageRequest;
import com.google.cloud.datalabeling.v1beta1.LabelOperationMetadata;
import com.google.cloud.datalabeling.v1beta1.LabelTextRequest;
import com.google.cloud.datalabeling.v1beta1.LabelVideoRequest;
import com.google.cloud.datalabeling.v1beta1.ListAnnotatedDatasetsRequest;
import com.google.cloud.datalabeling.v1beta1.ListAnnotatedDatasetsResponse;
import com.google.cloud.datalabeling.v1beta1.ListAnnotationSpecSetsRequest;
import com.google.cloud.datalabeling.v1beta1.ListAnnotationSpecSetsResponse;
import com.google.cloud.datalabeling.v1beta1.ListDataItemsRequest;
import com.google.cloud.datalabeling.v1beta1.ListDataItemsResponse;
import com.google.cloud.datalabeling.v1beta1.ListDatasetsRequest;
import com.google.cloud.datalabeling.v1beta1.ListDatasetsResponse;
import com.google.cloud.datalabeling.v1beta1.ListEvaluationJobsRequest;
import com.google.cloud.datalabeling.v1beta1.ListEvaluationJobsResponse;
import com.google.cloud.datalabeling.v1beta1.ListExamplesRequest;
import com.google.cloud.datalabeling.v1beta1.ListExamplesResponse;
import com.google.cloud.datalabeling.v1beta1.ListInstructionsRequest;
import com.google.cloud.datalabeling.v1beta1.ListInstructionsResponse;
import com.google.cloud.datalabeling.v1beta1.PauseEvaluationJobRequest;
import com.google.cloud.datalabeling.v1beta1.ResumeEvaluationJobRequest;
import com.google.cloud.datalabeling.v1beta1.SearchEvaluationsRequest;
import com.google.cloud.datalabeling.v1beta1.SearchEvaluationsResponse;
import com.google.cloud.datalabeling.v1beta1.SearchExampleComparisonsRequest;
import com.google.cloud.datalabeling.v1beta1.SearchExampleComparisonsResponse;
import com.google.cloud.datalabeling.v1beta1.UpdateEvaluationJobRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link DataLabelingServiceStub}.
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
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DataLabelingServiceStubSettings.Builder dataLabelingServiceSettingsBuilder =
 *     DataLabelingServiceStubSettings.newBuilder();
 * dataLabelingServiceSettingsBuilder
 *     .createDatasetSettings()
 *     .setRetrySettings(
 *         dataLabelingServiceSettingsBuilder
 *             .createDatasetSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * DataLabelingServiceStubSettings dataLabelingServiceSettings =
 *     dataLabelingServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class DataLabelingServiceStubSettings extends StubSettings<DataLabelingServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateDatasetRequest, Dataset> createDatasetSettings;
  private final UnaryCallSettings<GetDatasetRequest, Dataset> getDatasetSettings;
  private final PagedCallSettings<
          ListDatasetsRequest, ListDatasetsResponse, ListDatasetsPagedResponse>
      listDatasetsSettings;
  private final UnaryCallSettings<DeleteDatasetRequest, Empty> deleteDatasetSettings;
  private final UnaryCallSettings<ImportDataRequest, Operation> importDataSettings;
  private final OperationCallSettings<
          ImportDataRequest, ImportDataOperationResponse, ImportDataOperationMetadata>
      importDataOperationSettings;
  private final UnaryCallSettings<ExportDataRequest, Operation> exportDataSettings;
  private final OperationCallSettings<
          ExportDataRequest, ExportDataOperationResponse, ExportDataOperationMetadata>
      exportDataOperationSettings;
  private final UnaryCallSettings<GetDataItemRequest, DataItem> getDataItemSettings;
  private final PagedCallSettings<
          ListDataItemsRequest, ListDataItemsResponse, ListDataItemsPagedResponse>
      listDataItemsSettings;
  private final UnaryCallSettings<GetAnnotatedDatasetRequest, AnnotatedDataset>
      getAnnotatedDatasetSettings;
  private final PagedCallSettings<
          ListAnnotatedDatasetsRequest,
          ListAnnotatedDatasetsResponse,
          ListAnnotatedDatasetsPagedResponse>
      listAnnotatedDatasetsSettings;
  private final UnaryCallSettings<DeleteAnnotatedDatasetRequest, Empty>
      deleteAnnotatedDatasetSettings;
  private final UnaryCallSettings<LabelImageRequest, Operation> labelImageSettings;
  private final OperationCallSettings<LabelImageRequest, AnnotatedDataset, LabelOperationMetadata>
      labelImageOperationSettings;
  private final UnaryCallSettings<LabelVideoRequest, Operation> labelVideoSettings;
  private final OperationCallSettings<LabelVideoRequest, AnnotatedDataset, LabelOperationMetadata>
      labelVideoOperationSettings;
  private final UnaryCallSettings<LabelTextRequest, Operation> labelTextSettings;
  private final OperationCallSettings<LabelTextRequest, AnnotatedDataset, LabelOperationMetadata>
      labelTextOperationSettings;
  private final UnaryCallSettings<GetExampleRequest, Example> getExampleSettings;
  private final PagedCallSettings<
          ListExamplesRequest, ListExamplesResponse, ListExamplesPagedResponse>
      listExamplesSettings;
  private final UnaryCallSettings<CreateAnnotationSpecSetRequest, AnnotationSpecSet>
      createAnnotationSpecSetSettings;
  private final UnaryCallSettings<GetAnnotationSpecSetRequest, AnnotationSpecSet>
      getAnnotationSpecSetSettings;
  private final PagedCallSettings<
          ListAnnotationSpecSetsRequest,
          ListAnnotationSpecSetsResponse,
          ListAnnotationSpecSetsPagedResponse>
      listAnnotationSpecSetsSettings;
  private final UnaryCallSettings<DeleteAnnotationSpecSetRequest, Empty>
      deleteAnnotationSpecSetSettings;
  private final UnaryCallSettings<CreateInstructionRequest, Operation> createInstructionSettings;
  private final OperationCallSettings<
          CreateInstructionRequest, Instruction, CreateInstructionMetadata>
      createInstructionOperationSettings;
  private final UnaryCallSettings<GetInstructionRequest, Instruction> getInstructionSettings;
  private final PagedCallSettings<
          ListInstructionsRequest, ListInstructionsResponse, ListInstructionsPagedResponse>
      listInstructionsSettings;
  private final UnaryCallSettings<DeleteInstructionRequest, Empty> deleteInstructionSettings;
  private final UnaryCallSettings<GetEvaluationRequest, Evaluation> getEvaluationSettings;
  private final PagedCallSettings<
          SearchEvaluationsRequest, SearchEvaluationsResponse, SearchEvaluationsPagedResponse>
      searchEvaluationsSettings;
  private final PagedCallSettings<
          SearchExampleComparisonsRequest,
          SearchExampleComparisonsResponse,
          SearchExampleComparisonsPagedResponse>
      searchExampleComparisonsSettings;
  private final UnaryCallSettings<CreateEvaluationJobRequest, EvaluationJob>
      createEvaluationJobSettings;
  private final UnaryCallSettings<UpdateEvaluationJobRequest, EvaluationJob>
      updateEvaluationJobSettings;
  private final UnaryCallSettings<GetEvaluationJobRequest, EvaluationJob> getEvaluationJobSettings;
  private final UnaryCallSettings<PauseEvaluationJobRequest, Empty> pauseEvaluationJobSettings;
  private final UnaryCallSettings<ResumeEvaluationJobRequest, Empty> resumeEvaluationJobSettings;
  private final UnaryCallSettings<DeleteEvaluationJobRequest, Empty> deleteEvaluationJobSettings;
  private final PagedCallSettings<
          ListEvaluationJobsRequest, ListEvaluationJobsResponse, ListEvaluationJobsPagedResponse>
      listEvaluationJobsSettings;

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
              return payload.getDatasetsList() == null
                  ? ImmutableList.<Dataset>of()
                  : payload.getDatasetsList();
            }
          };

  private static final PagedListDescriptor<ListDataItemsRequest, ListDataItemsResponse, DataItem>
      LIST_DATA_ITEMS_PAGE_STR_DESC =
          new PagedListDescriptor<ListDataItemsRequest, ListDataItemsResponse, DataItem>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDataItemsRequest injectToken(ListDataItemsRequest payload, String token) {
              return ListDataItemsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDataItemsRequest injectPageSize(ListDataItemsRequest payload, int pageSize) {
              return ListDataItemsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListDataItemsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDataItemsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DataItem> extractResources(ListDataItemsResponse payload) {
              return payload.getDataItemsList() == null
                  ? ImmutableList.<DataItem>of()
                  : payload.getDataItemsList();
            }
          };

  private static final PagedListDescriptor<
          ListAnnotatedDatasetsRequest, ListAnnotatedDatasetsResponse, AnnotatedDataset>
      LIST_ANNOTATED_DATASETS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListAnnotatedDatasetsRequest, ListAnnotatedDatasetsResponse, AnnotatedDataset>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAnnotatedDatasetsRequest injectToken(
                ListAnnotatedDatasetsRequest payload, String token) {
              return ListAnnotatedDatasetsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAnnotatedDatasetsRequest injectPageSize(
                ListAnnotatedDatasetsRequest payload, int pageSize) {
              return ListAnnotatedDatasetsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAnnotatedDatasetsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAnnotatedDatasetsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<AnnotatedDataset> extractResources(
                ListAnnotatedDatasetsResponse payload) {
              return payload.getAnnotatedDatasetsList() == null
                  ? ImmutableList.<AnnotatedDataset>of()
                  : payload.getAnnotatedDatasetsList();
            }
          };

  private static final PagedListDescriptor<ListExamplesRequest, ListExamplesResponse, Example>
      LIST_EXAMPLES_PAGE_STR_DESC =
          new PagedListDescriptor<ListExamplesRequest, ListExamplesResponse, Example>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListExamplesRequest injectToken(ListExamplesRequest payload, String token) {
              return ListExamplesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListExamplesRequest injectPageSize(ListExamplesRequest payload, int pageSize) {
              return ListExamplesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListExamplesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListExamplesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Example> extractResources(ListExamplesResponse payload) {
              return payload.getExamplesList() == null
                  ? ImmutableList.<Example>of()
                  : payload.getExamplesList();
            }
          };

  private static final PagedListDescriptor<
          ListAnnotationSpecSetsRequest, ListAnnotationSpecSetsResponse, AnnotationSpecSet>
      LIST_ANNOTATION_SPEC_SETS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListAnnotationSpecSetsRequest, ListAnnotationSpecSetsResponse, AnnotationSpecSet>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAnnotationSpecSetsRequest injectToken(
                ListAnnotationSpecSetsRequest payload, String token) {
              return ListAnnotationSpecSetsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAnnotationSpecSetsRequest injectPageSize(
                ListAnnotationSpecSetsRequest payload, int pageSize) {
              return ListAnnotationSpecSetsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListAnnotationSpecSetsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAnnotationSpecSetsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<AnnotationSpecSet> extractResources(
                ListAnnotationSpecSetsResponse payload) {
              return payload.getAnnotationSpecSetsList() == null
                  ? ImmutableList.<AnnotationSpecSet>of()
                  : payload.getAnnotationSpecSetsList();
            }
          };

  private static final PagedListDescriptor<
          ListInstructionsRequest, ListInstructionsResponse, Instruction>
      LIST_INSTRUCTIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListInstructionsRequest, ListInstructionsResponse, Instruction>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListInstructionsRequest injectToken(
                ListInstructionsRequest payload, String token) {
              return ListInstructionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListInstructionsRequest injectPageSize(
                ListInstructionsRequest payload, int pageSize) {
              return ListInstructionsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListInstructionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListInstructionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Instruction> extractResources(ListInstructionsResponse payload) {
              return payload.getInstructionsList() == null
                  ? ImmutableList.<Instruction>of()
                  : payload.getInstructionsList();
            }
          };

  private static final PagedListDescriptor<
          SearchEvaluationsRequest, SearchEvaluationsResponse, Evaluation>
      SEARCH_EVALUATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              SearchEvaluationsRequest, SearchEvaluationsResponse, Evaluation>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public SearchEvaluationsRequest injectToken(
                SearchEvaluationsRequest payload, String token) {
              return SearchEvaluationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public SearchEvaluationsRequest injectPageSize(
                SearchEvaluationsRequest payload, int pageSize) {
              return SearchEvaluationsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(SearchEvaluationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(SearchEvaluationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Evaluation> extractResources(SearchEvaluationsResponse payload) {
              return payload.getEvaluationsList() == null
                  ? ImmutableList.<Evaluation>of()
                  : payload.getEvaluationsList();
            }
          };

  private static final PagedListDescriptor<
          SearchExampleComparisonsRequest,
          SearchExampleComparisonsResponse,
          SearchExampleComparisonsResponse.ExampleComparison>
      SEARCH_EXAMPLE_COMPARISONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              SearchExampleComparisonsRequest,
              SearchExampleComparisonsResponse,
              SearchExampleComparisonsResponse.ExampleComparison>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public SearchExampleComparisonsRequest injectToken(
                SearchExampleComparisonsRequest payload, String token) {
              return SearchExampleComparisonsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public SearchExampleComparisonsRequest injectPageSize(
                SearchExampleComparisonsRequest payload, int pageSize) {
              return SearchExampleComparisonsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(SearchExampleComparisonsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(SearchExampleComparisonsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<SearchExampleComparisonsResponse.ExampleComparison> extractResources(
                SearchExampleComparisonsResponse payload) {
              return payload.getExampleComparisonsList() == null
                  ? ImmutableList.<SearchExampleComparisonsResponse.ExampleComparison>of()
                  : payload.getExampleComparisonsList();
            }
          };

  private static final PagedListDescriptor<
          ListEvaluationJobsRequest, ListEvaluationJobsResponse, EvaluationJob>
      LIST_EVALUATION_JOBS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListEvaluationJobsRequest, ListEvaluationJobsResponse, EvaluationJob>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListEvaluationJobsRequest injectToken(
                ListEvaluationJobsRequest payload, String token) {
              return ListEvaluationJobsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListEvaluationJobsRequest injectPageSize(
                ListEvaluationJobsRequest payload, int pageSize) {
              return ListEvaluationJobsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListEvaluationJobsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListEvaluationJobsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<EvaluationJob> extractResources(ListEvaluationJobsResponse payload) {
              return payload.getEvaluationJobsList() == null
                  ? ImmutableList.<EvaluationJob>of()
                  : payload.getEvaluationJobsList();
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
          ListDataItemsRequest, ListDataItemsResponse, ListDataItemsPagedResponse>
      LIST_DATA_ITEMS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDataItemsRequest, ListDataItemsResponse, ListDataItemsPagedResponse>() {
            @Override
            public ApiFuture<ListDataItemsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDataItemsRequest, ListDataItemsResponse> callable,
                ListDataItemsRequest request,
                ApiCallContext context,
                ApiFuture<ListDataItemsResponse> futureResponse) {
              PageContext<ListDataItemsRequest, ListDataItemsResponse, DataItem> pageContext =
                  PageContext.create(callable, LIST_DATA_ITEMS_PAGE_STR_DESC, request, context);
              return ListDataItemsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListAnnotatedDatasetsRequest,
          ListAnnotatedDatasetsResponse,
          ListAnnotatedDatasetsPagedResponse>
      LIST_ANNOTATED_DATASETS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAnnotatedDatasetsRequest,
              ListAnnotatedDatasetsResponse,
              ListAnnotatedDatasetsPagedResponse>() {
            @Override
            public ApiFuture<ListAnnotatedDatasetsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAnnotatedDatasetsRequest, ListAnnotatedDatasetsResponse> callable,
                ListAnnotatedDatasetsRequest request,
                ApiCallContext context,
                ApiFuture<ListAnnotatedDatasetsResponse> futureResponse) {
              PageContext<
                      ListAnnotatedDatasetsRequest, ListAnnotatedDatasetsResponse, AnnotatedDataset>
                  pageContext =
                      PageContext.create(
                          callable, LIST_ANNOTATED_DATASETS_PAGE_STR_DESC, request, context);
              return ListAnnotatedDatasetsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListExamplesRequest, ListExamplesResponse, ListExamplesPagedResponse>
      LIST_EXAMPLES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListExamplesRequest, ListExamplesResponse, ListExamplesPagedResponse>() {
            @Override
            public ApiFuture<ListExamplesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListExamplesRequest, ListExamplesResponse> callable,
                ListExamplesRequest request,
                ApiCallContext context,
                ApiFuture<ListExamplesResponse> futureResponse) {
              PageContext<ListExamplesRequest, ListExamplesResponse, Example> pageContext =
                  PageContext.create(callable, LIST_EXAMPLES_PAGE_STR_DESC, request, context);
              return ListExamplesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListAnnotationSpecSetsRequest,
          ListAnnotationSpecSetsResponse,
          ListAnnotationSpecSetsPagedResponse>
      LIST_ANNOTATION_SPEC_SETS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAnnotationSpecSetsRequest,
              ListAnnotationSpecSetsResponse,
              ListAnnotationSpecSetsPagedResponse>() {
            @Override
            public ApiFuture<ListAnnotationSpecSetsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAnnotationSpecSetsRequest, ListAnnotationSpecSetsResponse>
                    callable,
                ListAnnotationSpecSetsRequest request,
                ApiCallContext context,
                ApiFuture<ListAnnotationSpecSetsResponse> futureResponse) {
              PageContext<
                      ListAnnotationSpecSetsRequest,
                      ListAnnotationSpecSetsResponse,
                      AnnotationSpecSet>
                  pageContext =
                      PageContext.create(
                          callable, LIST_ANNOTATION_SPEC_SETS_PAGE_STR_DESC, request, context);
              return ListAnnotationSpecSetsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListInstructionsRequest, ListInstructionsResponse, ListInstructionsPagedResponse>
      LIST_INSTRUCTIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListInstructionsRequest, ListInstructionsResponse, ListInstructionsPagedResponse>() {
            @Override
            public ApiFuture<ListInstructionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListInstructionsRequest, ListInstructionsResponse> callable,
                ListInstructionsRequest request,
                ApiCallContext context,
                ApiFuture<ListInstructionsResponse> futureResponse) {
              PageContext<ListInstructionsRequest, ListInstructionsResponse, Instruction>
                  pageContext =
                      PageContext.create(
                          callable, LIST_INSTRUCTIONS_PAGE_STR_DESC, request, context);
              return ListInstructionsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          SearchEvaluationsRequest, SearchEvaluationsResponse, SearchEvaluationsPagedResponse>
      SEARCH_EVALUATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              SearchEvaluationsRequest,
              SearchEvaluationsResponse,
              SearchEvaluationsPagedResponse>() {
            @Override
            public ApiFuture<SearchEvaluationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<SearchEvaluationsRequest, SearchEvaluationsResponse> callable,
                SearchEvaluationsRequest request,
                ApiCallContext context,
                ApiFuture<SearchEvaluationsResponse> futureResponse) {
              PageContext<SearchEvaluationsRequest, SearchEvaluationsResponse, Evaluation>
                  pageContext =
                      PageContext.create(
                          callable, SEARCH_EVALUATIONS_PAGE_STR_DESC, request, context);
              return SearchEvaluationsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          SearchExampleComparisonsRequest,
          SearchExampleComparisonsResponse,
          SearchExampleComparisonsPagedResponse>
      SEARCH_EXAMPLE_COMPARISONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              SearchExampleComparisonsRequest,
              SearchExampleComparisonsResponse,
              SearchExampleComparisonsPagedResponse>() {
            @Override
            public ApiFuture<SearchExampleComparisonsPagedResponse> getFuturePagedResponse(
                UnaryCallable<SearchExampleComparisonsRequest, SearchExampleComparisonsResponse>
                    callable,
                SearchExampleComparisonsRequest request,
                ApiCallContext context,
                ApiFuture<SearchExampleComparisonsResponse> futureResponse) {
              PageContext<
                      SearchExampleComparisonsRequest,
                      SearchExampleComparisonsResponse,
                      SearchExampleComparisonsResponse.ExampleComparison>
                  pageContext =
                      PageContext.create(
                          callable, SEARCH_EXAMPLE_COMPARISONS_PAGE_STR_DESC, request, context);
              return SearchExampleComparisonsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListEvaluationJobsRequest, ListEvaluationJobsResponse, ListEvaluationJobsPagedResponse>
      LIST_EVALUATION_JOBS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListEvaluationJobsRequest,
              ListEvaluationJobsResponse,
              ListEvaluationJobsPagedResponse>() {
            @Override
            public ApiFuture<ListEvaluationJobsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListEvaluationJobsRequest, ListEvaluationJobsResponse> callable,
                ListEvaluationJobsRequest request,
                ApiCallContext context,
                ApiFuture<ListEvaluationJobsResponse> futureResponse) {
              PageContext<ListEvaluationJobsRequest, ListEvaluationJobsResponse, EvaluationJob>
                  pageContext =
                      PageContext.create(
                          callable, LIST_EVALUATION_JOBS_PAGE_STR_DESC, request, context);
              return ListEvaluationJobsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createDataset. */
  public UnaryCallSettings<CreateDatasetRequest, Dataset> createDatasetSettings() {
    return createDatasetSettings;
  }

  /** Returns the object with the settings used for calls to getDataset. */
  public UnaryCallSettings<GetDatasetRequest, Dataset> getDatasetSettings() {
    return getDatasetSettings;
  }

  /** Returns the object with the settings used for calls to listDatasets. */
  public PagedCallSettings<ListDatasetsRequest, ListDatasetsResponse, ListDatasetsPagedResponse>
      listDatasetsSettings() {
    return listDatasetsSettings;
  }

  /** Returns the object with the settings used for calls to deleteDataset. */
  public UnaryCallSettings<DeleteDatasetRequest, Empty> deleteDatasetSettings() {
    return deleteDatasetSettings;
  }

  /** Returns the object with the settings used for calls to importData. */
  public UnaryCallSettings<ImportDataRequest, Operation> importDataSettings() {
    return importDataSettings;
  }

  /** Returns the object with the settings used for calls to importData. */
  public OperationCallSettings<
          ImportDataRequest, ImportDataOperationResponse, ImportDataOperationMetadata>
      importDataOperationSettings() {
    return importDataOperationSettings;
  }

  /** Returns the object with the settings used for calls to exportData. */
  public UnaryCallSettings<ExportDataRequest, Operation> exportDataSettings() {
    return exportDataSettings;
  }

  /** Returns the object with the settings used for calls to exportData. */
  public OperationCallSettings<
          ExportDataRequest, ExportDataOperationResponse, ExportDataOperationMetadata>
      exportDataOperationSettings() {
    return exportDataOperationSettings;
  }

  /** Returns the object with the settings used for calls to getDataItem. */
  public UnaryCallSettings<GetDataItemRequest, DataItem> getDataItemSettings() {
    return getDataItemSettings;
  }

  /** Returns the object with the settings used for calls to listDataItems. */
  public PagedCallSettings<ListDataItemsRequest, ListDataItemsResponse, ListDataItemsPagedResponse>
      listDataItemsSettings() {
    return listDataItemsSettings;
  }

  /** Returns the object with the settings used for calls to getAnnotatedDataset. */
  public UnaryCallSettings<GetAnnotatedDatasetRequest, AnnotatedDataset>
      getAnnotatedDatasetSettings() {
    return getAnnotatedDatasetSettings;
  }

  /** Returns the object with the settings used for calls to listAnnotatedDatasets. */
  public PagedCallSettings<
          ListAnnotatedDatasetsRequest,
          ListAnnotatedDatasetsResponse,
          ListAnnotatedDatasetsPagedResponse>
      listAnnotatedDatasetsSettings() {
    return listAnnotatedDatasetsSettings;
  }

  /** Returns the object with the settings used for calls to deleteAnnotatedDataset. */
  public UnaryCallSettings<DeleteAnnotatedDatasetRequest, Empty> deleteAnnotatedDatasetSettings() {
    return deleteAnnotatedDatasetSettings;
  }

  /** Returns the object with the settings used for calls to labelImage. */
  public UnaryCallSettings<LabelImageRequest, Operation> labelImageSettings() {
    return labelImageSettings;
  }

  /** Returns the object with the settings used for calls to labelImage. */
  public OperationCallSettings<LabelImageRequest, AnnotatedDataset, LabelOperationMetadata>
      labelImageOperationSettings() {
    return labelImageOperationSettings;
  }

  /** Returns the object with the settings used for calls to labelVideo. */
  public UnaryCallSettings<LabelVideoRequest, Operation> labelVideoSettings() {
    return labelVideoSettings;
  }

  /** Returns the object with the settings used for calls to labelVideo. */
  public OperationCallSettings<LabelVideoRequest, AnnotatedDataset, LabelOperationMetadata>
      labelVideoOperationSettings() {
    return labelVideoOperationSettings;
  }

  /** Returns the object with the settings used for calls to labelText. */
  public UnaryCallSettings<LabelTextRequest, Operation> labelTextSettings() {
    return labelTextSettings;
  }

  /** Returns the object with the settings used for calls to labelText. */
  public OperationCallSettings<LabelTextRequest, AnnotatedDataset, LabelOperationMetadata>
      labelTextOperationSettings() {
    return labelTextOperationSettings;
  }

  /** Returns the object with the settings used for calls to getExample. */
  public UnaryCallSettings<GetExampleRequest, Example> getExampleSettings() {
    return getExampleSettings;
  }

  /** Returns the object with the settings used for calls to listExamples. */
  public PagedCallSettings<ListExamplesRequest, ListExamplesResponse, ListExamplesPagedResponse>
      listExamplesSettings() {
    return listExamplesSettings;
  }

  /** Returns the object with the settings used for calls to createAnnotationSpecSet. */
  public UnaryCallSettings<CreateAnnotationSpecSetRequest, AnnotationSpecSet>
      createAnnotationSpecSetSettings() {
    return createAnnotationSpecSetSettings;
  }

  /** Returns the object with the settings used for calls to getAnnotationSpecSet. */
  public UnaryCallSettings<GetAnnotationSpecSetRequest, AnnotationSpecSet>
      getAnnotationSpecSetSettings() {
    return getAnnotationSpecSetSettings;
  }

  /** Returns the object with the settings used for calls to listAnnotationSpecSets. */
  public PagedCallSettings<
          ListAnnotationSpecSetsRequest,
          ListAnnotationSpecSetsResponse,
          ListAnnotationSpecSetsPagedResponse>
      listAnnotationSpecSetsSettings() {
    return listAnnotationSpecSetsSettings;
  }

  /** Returns the object with the settings used for calls to deleteAnnotationSpecSet. */
  public UnaryCallSettings<DeleteAnnotationSpecSetRequest, Empty>
      deleteAnnotationSpecSetSettings() {
    return deleteAnnotationSpecSetSettings;
  }

  /** Returns the object with the settings used for calls to createInstruction. */
  public UnaryCallSettings<CreateInstructionRequest, Operation> createInstructionSettings() {
    return createInstructionSettings;
  }

  /** Returns the object with the settings used for calls to createInstruction. */
  public OperationCallSettings<CreateInstructionRequest, Instruction, CreateInstructionMetadata>
      createInstructionOperationSettings() {
    return createInstructionOperationSettings;
  }

  /** Returns the object with the settings used for calls to getInstruction. */
  public UnaryCallSettings<GetInstructionRequest, Instruction> getInstructionSettings() {
    return getInstructionSettings;
  }

  /** Returns the object with the settings used for calls to listInstructions. */
  public PagedCallSettings<
          ListInstructionsRequest, ListInstructionsResponse, ListInstructionsPagedResponse>
      listInstructionsSettings() {
    return listInstructionsSettings;
  }

  /** Returns the object with the settings used for calls to deleteInstruction. */
  public UnaryCallSettings<DeleteInstructionRequest, Empty> deleteInstructionSettings() {
    return deleteInstructionSettings;
  }

  /** Returns the object with the settings used for calls to getEvaluation. */
  public UnaryCallSettings<GetEvaluationRequest, Evaluation> getEvaluationSettings() {
    return getEvaluationSettings;
  }

  /** Returns the object with the settings used for calls to searchEvaluations. */
  public PagedCallSettings<
          SearchEvaluationsRequest, SearchEvaluationsResponse, SearchEvaluationsPagedResponse>
      searchEvaluationsSettings() {
    return searchEvaluationsSettings;
  }

  /** Returns the object with the settings used for calls to searchExampleComparisons. */
  public PagedCallSettings<
          SearchExampleComparisonsRequest,
          SearchExampleComparisonsResponse,
          SearchExampleComparisonsPagedResponse>
      searchExampleComparisonsSettings() {
    return searchExampleComparisonsSettings;
  }

  /** Returns the object with the settings used for calls to createEvaluationJob. */
  public UnaryCallSettings<CreateEvaluationJobRequest, EvaluationJob>
      createEvaluationJobSettings() {
    return createEvaluationJobSettings;
  }

  /** Returns the object with the settings used for calls to updateEvaluationJob. */
  public UnaryCallSettings<UpdateEvaluationJobRequest, EvaluationJob>
      updateEvaluationJobSettings() {
    return updateEvaluationJobSettings;
  }

  /** Returns the object with the settings used for calls to getEvaluationJob. */
  public UnaryCallSettings<GetEvaluationJobRequest, EvaluationJob> getEvaluationJobSettings() {
    return getEvaluationJobSettings;
  }

  /** Returns the object with the settings used for calls to pauseEvaluationJob. */
  public UnaryCallSettings<PauseEvaluationJobRequest, Empty> pauseEvaluationJobSettings() {
    return pauseEvaluationJobSettings;
  }

  /** Returns the object with the settings used for calls to resumeEvaluationJob. */
  public UnaryCallSettings<ResumeEvaluationJobRequest, Empty> resumeEvaluationJobSettings() {
    return resumeEvaluationJobSettings;
  }

  /** Returns the object with the settings used for calls to deleteEvaluationJob. */
  public UnaryCallSettings<DeleteEvaluationJobRequest, Empty> deleteEvaluationJobSettings() {
    return deleteEvaluationJobSettings;
  }

  /** Returns the object with the settings used for calls to listEvaluationJobs. */
  public PagedCallSettings<
          ListEvaluationJobsRequest, ListEvaluationJobsResponse, ListEvaluationJobsPagedResponse>
      listEvaluationJobsSettings() {
    return listEvaluationJobsSettings;
  }

  public DataLabelingServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcDataLabelingServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "datalabeling.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "datalabeling.mtls.googleapis.com:443";
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

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(DataLabelingServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
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

  protected DataLabelingServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createDatasetSettings = settingsBuilder.createDatasetSettings().build();
    getDatasetSettings = settingsBuilder.getDatasetSettings().build();
    listDatasetsSettings = settingsBuilder.listDatasetsSettings().build();
    deleteDatasetSettings = settingsBuilder.deleteDatasetSettings().build();
    importDataSettings = settingsBuilder.importDataSettings().build();
    importDataOperationSettings = settingsBuilder.importDataOperationSettings().build();
    exportDataSettings = settingsBuilder.exportDataSettings().build();
    exportDataOperationSettings = settingsBuilder.exportDataOperationSettings().build();
    getDataItemSettings = settingsBuilder.getDataItemSettings().build();
    listDataItemsSettings = settingsBuilder.listDataItemsSettings().build();
    getAnnotatedDatasetSettings = settingsBuilder.getAnnotatedDatasetSettings().build();
    listAnnotatedDatasetsSettings = settingsBuilder.listAnnotatedDatasetsSettings().build();
    deleteAnnotatedDatasetSettings = settingsBuilder.deleteAnnotatedDatasetSettings().build();
    labelImageSettings = settingsBuilder.labelImageSettings().build();
    labelImageOperationSettings = settingsBuilder.labelImageOperationSettings().build();
    labelVideoSettings = settingsBuilder.labelVideoSettings().build();
    labelVideoOperationSettings = settingsBuilder.labelVideoOperationSettings().build();
    labelTextSettings = settingsBuilder.labelTextSettings().build();
    labelTextOperationSettings = settingsBuilder.labelTextOperationSettings().build();
    getExampleSettings = settingsBuilder.getExampleSettings().build();
    listExamplesSettings = settingsBuilder.listExamplesSettings().build();
    createAnnotationSpecSetSettings = settingsBuilder.createAnnotationSpecSetSettings().build();
    getAnnotationSpecSetSettings = settingsBuilder.getAnnotationSpecSetSettings().build();
    listAnnotationSpecSetsSettings = settingsBuilder.listAnnotationSpecSetsSettings().build();
    deleteAnnotationSpecSetSettings = settingsBuilder.deleteAnnotationSpecSetSettings().build();
    createInstructionSettings = settingsBuilder.createInstructionSettings().build();
    createInstructionOperationSettings =
        settingsBuilder.createInstructionOperationSettings().build();
    getInstructionSettings = settingsBuilder.getInstructionSettings().build();
    listInstructionsSettings = settingsBuilder.listInstructionsSettings().build();
    deleteInstructionSettings = settingsBuilder.deleteInstructionSettings().build();
    getEvaluationSettings = settingsBuilder.getEvaluationSettings().build();
    searchEvaluationsSettings = settingsBuilder.searchEvaluationsSettings().build();
    searchExampleComparisonsSettings = settingsBuilder.searchExampleComparisonsSettings().build();
    createEvaluationJobSettings = settingsBuilder.createEvaluationJobSettings().build();
    updateEvaluationJobSettings = settingsBuilder.updateEvaluationJobSettings().build();
    getEvaluationJobSettings = settingsBuilder.getEvaluationJobSettings().build();
    pauseEvaluationJobSettings = settingsBuilder.pauseEvaluationJobSettings().build();
    resumeEvaluationJobSettings = settingsBuilder.resumeEvaluationJobSettings().build();
    deleteEvaluationJobSettings = settingsBuilder.deleteEvaluationJobSettings().build();
    listEvaluationJobsSettings = settingsBuilder.listEvaluationJobsSettings().build();
  }

  /** Builder for DataLabelingServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<DataLabelingServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateDatasetRequest, Dataset> createDatasetSettings;
    private final UnaryCallSettings.Builder<GetDatasetRequest, Dataset> getDatasetSettings;
    private final PagedCallSettings.Builder<
            ListDatasetsRequest, ListDatasetsResponse, ListDatasetsPagedResponse>
        listDatasetsSettings;
    private final UnaryCallSettings.Builder<DeleteDatasetRequest, Empty> deleteDatasetSettings;
    private final UnaryCallSettings.Builder<ImportDataRequest, Operation> importDataSettings;
    private final OperationCallSettings.Builder<
            ImportDataRequest, ImportDataOperationResponse, ImportDataOperationMetadata>
        importDataOperationSettings;
    private final UnaryCallSettings.Builder<ExportDataRequest, Operation> exportDataSettings;
    private final OperationCallSettings.Builder<
            ExportDataRequest, ExportDataOperationResponse, ExportDataOperationMetadata>
        exportDataOperationSettings;
    private final UnaryCallSettings.Builder<GetDataItemRequest, DataItem> getDataItemSettings;
    private final PagedCallSettings.Builder<
            ListDataItemsRequest, ListDataItemsResponse, ListDataItemsPagedResponse>
        listDataItemsSettings;
    private final UnaryCallSettings.Builder<GetAnnotatedDatasetRequest, AnnotatedDataset>
        getAnnotatedDatasetSettings;
    private final PagedCallSettings.Builder<
            ListAnnotatedDatasetsRequest,
            ListAnnotatedDatasetsResponse,
            ListAnnotatedDatasetsPagedResponse>
        listAnnotatedDatasetsSettings;
    private final UnaryCallSettings.Builder<DeleteAnnotatedDatasetRequest, Empty>
        deleteAnnotatedDatasetSettings;
    private final UnaryCallSettings.Builder<LabelImageRequest, Operation> labelImageSettings;
    private final OperationCallSettings.Builder<
            LabelImageRequest, AnnotatedDataset, LabelOperationMetadata>
        labelImageOperationSettings;
    private final UnaryCallSettings.Builder<LabelVideoRequest, Operation> labelVideoSettings;
    private final OperationCallSettings.Builder<
            LabelVideoRequest, AnnotatedDataset, LabelOperationMetadata>
        labelVideoOperationSettings;
    private final UnaryCallSettings.Builder<LabelTextRequest, Operation> labelTextSettings;
    private final OperationCallSettings.Builder<
            LabelTextRequest, AnnotatedDataset, LabelOperationMetadata>
        labelTextOperationSettings;
    private final UnaryCallSettings.Builder<GetExampleRequest, Example> getExampleSettings;
    private final PagedCallSettings.Builder<
            ListExamplesRequest, ListExamplesResponse, ListExamplesPagedResponse>
        listExamplesSettings;
    private final UnaryCallSettings.Builder<CreateAnnotationSpecSetRequest, AnnotationSpecSet>
        createAnnotationSpecSetSettings;
    private final UnaryCallSettings.Builder<GetAnnotationSpecSetRequest, AnnotationSpecSet>
        getAnnotationSpecSetSettings;
    private final PagedCallSettings.Builder<
            ListAnnotationSpecSetsRequest,
            ListAnnotationSpecSetsResponse,
            ListAnnotationSpecSetsPagedResponse>
        listAnnotationSpecSetsSettings;
    private final UnaryCallSettings.Builder<DeleteAnnotationSpecSetRequest, Empty>
        deleteAnnotationSpecSetSettings;
    private final UnaryCallSettings.Builder<CreateInstructionRequest, Operation>
        createInstructionSettings;
    private final OperationCallSettings.Builder<
            CreateInstructionRequest, Instruction, CreateInstructionMetadata>
        createInstructionOperationSettings;
    private final UnaryCallSettings.Builder<GetInstructionRequest, Instruction>
        getInstructionSettings;
    private final PagedCallSettings.Builder<
            ListInstructionsRequest, ListInstructionsResponse, ListInstructionsPagedResponse>
        listInstructionsSettings;
    private final UnaryCallSettings.Builder<DeleteInstructionRequest, Empty>
        deleteInstructionSettings;
    private final UnaryCallSettings.Builder<GetEvaluationRequest, Evaluation> getEvaluationSettings;
    private final PagedCallSettings.Builder<
            SearchEvaluationsRequest, SearchEvaluationsResponse, SearchEvaluationsPagedResponse>
        searchEvaluationsSettings;
    private final PagedCallSettings.Builder<
            SearchExampleComparisonsRequest,
            SearchExampleComparisonsResponse,
            SearchExampleComparisonsPagedResponse>
        searchExampleComparisonsSettings;
    private final UnaryCallSettings.Builder<CreateEvaluationJobRequest, EvaluationJob>
        createEvaluationJobSettings;
    private final UnaryCallSettings.Builder<UpdateEvaluationJobRequest, EvaluationJob>
        updateEvaluationJobSettings;
    private final UnaryCallSettings.Builder<GetEvaluationJobRequest, EvaluationJob>
        getEvaluationJobSettings;
    private final UnaryCallSettings.Builder<PauseEvaluationJobRequest, Empty>
        pauseEvaluationJobSettings;
    private final UnaryCallSettings.Builder<ResumeEvaluationJobRequest, Empty>
        resumeEvaluationJobSettings;
    private final UnaryCallSettings.Builder<DeleteEvaluationJobRequest, Empty>
        deleteEvaluationJobSettings;
    private final PagedCallSettings.Builder<
            ListEvaluationJobsRequest, ListEvaluationJobsResponse, ListEvaluationJobsPagedResponse>
        listEvaluationJobsSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_0_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "retry_policy_1_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(30000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(30000L))
              .setTotalTimeout(Duration.ofMillis(30000L))
              .build();
      definitions.put("no_retry_0_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(30000L))
              .setInitialRpcTimeout(Duration.ofMillis(30000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(30000L))
              .setTotalTimeout(Duration.ofMillis(30000L))
              .build();
      definitions.put("retry_policy_1_params", settings);
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createDatasetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getDatasetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listDatasetsSettings = PagedCallSettings.newBuilder(LIST_DATASETS_PAGE_STR_FACT);
      deleteDatasetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      importDataSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      importDataOperationSettings = OperationCallSettings.newBuilder();
      exportDataSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      exportDataOperationSettings = OperationCallSettings.newBuilder();
      getDataItemSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listDataItemsSettings = PagedCallSettings.newBuilder(LIST_DATA_ITEMS_PAGE_STR_FACT);
      getAnnotatedDatasetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listAnnotatedDatasetsSettings =
          PagedCallSettings.newBuilder(LIST_ANNOTATED_DATASETS_PAGE_STR_FACT);
      deleteAnnotatedDatasetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      labelImageSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      labelImageOperationSettings = OperationCallSettings.newBuilder();
      labelVideoSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      labelVideoOperationSettings = OperationCallSettings.newBuilder();
      labelTextSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      labelTextOperationSettings = OperationCallSettings.newBuilder();
      getExampleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listExamplesSettings = PagedCallSettings.newBuilder(LIST_EXAMPLES_PAGE_STR_FACT);
      createAnnotationSpecSetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getAnnotationSpecSetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listAnnotationSpecSetsSettings =
          PagedCallSettings.newBuilder(LIST_ANNOTATION_SPEC_SETS_PAGE_STR_FACT);
      deleteAnnotationSpecSetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createInstructionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createInstructionOperationSettings = OperationCallSettings.newBuilder();
      getInstructionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listInstructionsSettings = PagedCallSettings.newBuilder(LIST_INSTRUCTIONS_PAGE_STR_FACT);
      deleteInstructionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getEvaluationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      searchEvaluationsSettings = PagedCallSettings.newBuilder(SEARCH_EVALUATIONS_PAGE_STR_FACT);
      searchExampleComparisonsSettings =
          PagedCallSettings.newBuilder(SEARCH_EXAMPLE_COMPARISONS_PAGE_STR_FACT);
      createEvaluationJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateEvaluationJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getEvaluationJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      pauseEvaluationJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      resumeEvaluationJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteEvaluationJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listEvaluationJobsSettings = PagedCallSettings.newBuilder(LIST_EVALUATION_JOBS_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createDatasetSettings,
              getDatasetSettings,
              listDatasetsSettings,
              deleteDatasetSettings,
              importDataSettings,
              exportDataSettings,
              getDataItemSettings,
              listDataItemsSettings,
              getAnnotatedDatasetSettings,
              listAnnotatedDatasetsSettings,
              deleteAnnotatedDatasetSettings,
              labelImageSettings,
              labelVideoSettings,
              labelTextSettings,
              getExampleSettings,
              listExamplesSettings,
              createAnnotationSpecSetSettings,
              getAnnotationSpecSetSettings,
              listAnnotationSpecSetsSettings,
              deleteAnnotationSpecSetSettings,
              createInstructionSettings,
              getInstructionSettings,
              listInstructionsSettings,
              deleteInstructionSettings,
              getEvaluationSettings,
              searchEvaluationsSettings,
              searchExampleComparisonsSettings,
              createEvaluationJobSettings,
              updateEvaluationJobSettings,
              getEvaluationJobSettings,
              pauseEvaluationJobSettings,
              resumeEvaluationJobSettings,
              deleteEvaluationJobSettings,
              listEvaluationJobsSettings);
      initDefaults(this);
    }

    protected Builder(DataLabelingServiceStubSettings settings) {
      super(settings);

      createDatasetSettings = settings.createDatasetSettings.toBuilder();
      getDatasetSettings = settings.getDatasetSettings.toBuilder();
      listDatasetsSettings = settings.listDatasetsSettings.toBuilder();
      deleteDatasetSettings = settings.deleteDatasetSettings.toBuilder();
      importDataSettings = settings.importDataSettings.toBuilder();
      importDataOperationSettings = settings.importDataOperationSettings.toBuilder();
      exportDataSettings = settings.exportDataSettings.toBuilder();
      exportDataOperationSettings = settings.exportDataOperationSettings.toBuilder();
      getDataItemSettings = settings.getDataItemSettings.toBuilder();
      listDataItemsSettings = settings.listDataItemsSettings.toBuilder();
      getAnnotatedDatasetSettings = settings.getAnnotatedDatasetSettings.toBuilder();
      listAnnotatedDatasetsSettings = settings.listAnnotatedDatasetsSettings.toBuilder();
      deleteAnnotatedDatasetSettings = settings.deleteAnnotatedDatasetSettings.toBuilder();
      labelImageSettings = settings.labelImageSettings.toBuilder();
      labelImageOperationSettings = settings.labelImageOperationSettings.toBuilder();
      labelVideoSettings = settings.labelVideoSettings.toBuilder();
      labelVideoOperationSettings = settings.labelVideoOperationSettings.toBuilder();
      labelTextSettings = settings.labelTextSettings.toBuilder();
      labelTextOperationSettings = settings.labelTextOperationSettings.toBuilder();
      getExampleSettings = settings.getExampleSettings.toBuilder();
      listExamplesSettings = settings.listExamplesSettings.toBuilder();
      createAnnotationSpecSetSettings = settings.createAnnotationSpecSetSettings.toBuilder();
      getAnnotationSpecSetSettings = settings.getAnnotationSpecSetSettings.toBuilder();
      listAnnotationSpecSetsSettings = settings.listAnnotationSpecSetsSettings.toBuilder();
      deleteAnnotationSpecSetSettings = settings.deleteAnnotationSpecSetSettings.toBuilder();
      createInstructionSettings = settings.createInstructionSettings.toBuilder();
      createInstructionOperationSettings = settings.createInstructionOperationSettings.toBuilder();
      getInstructionSettings = settings.getInstructionSettings.toBuilder();
      listInstructionsSettings = settings.listInstructionsSettings.toBuilder();
      deleteInstructionSettings = settings.deleteInstructionSettings.toBuilder();
      getEvaluationSettings = settings.getEvaluationSettings.toBuilder();
      searchEvaluationsSettings = settings.searchEvaluationsSettings.toBuilder();
      searchExampleComparisonsSettings = settings.searchExampleComparisonsSettings.toBuilder();
      createEvaluationJobSettings = settings.createEvaluationJobSettings.toBuilder();
      updateEvaluationJobSettings = settings.updateEvaluationJobSettings.toBuilder();
      getEvaluationJobSettings = settings.getEvaluationJobSettings.toBuilder();
      pauseEvaluationJobSettings = settings.pauseEvaluationJobSettings.toBuilder();
      resumeEvaluationJobSettings = settings.resumeEvaluationJobSettings.toBuilder();
      deleteEvaluationJobSettings = settings.deleteEvaluationJobSettings.toBuilder();
      listEvaluationJobsSettings = settings.listEvaluationJobsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createDatasetSettings,
              getDatasetSettings,
              listDatasetsSettings,
              deleteDatasetSettings,
              importDataSettings,
              exportDataSettings,
              getDataItemSettings,
              listDataItemsSettings,
              getAnnotatedDatasetSettings,
              listAnnotatedDatasetsSettings,
              deleteAnnotatedDatasetSettings,
              labelImageSettings,
              labelVideoSettings,
              labelTextSettings,
              getExampleSettings,
              listExamplesSettings,
              createAnnotationSpecSetSettings,
              getAnnotationSpecSetSettings,
              listAnnotationSpecSetsSettings,
              deleteAnnotationSpecSetSettings,
              createInstructionSettings,
              getInstructionSettings,
              listInstructionsSettings,
              deleteInstructionSettings,
              getEvaluationSettings,
              searchEvaluationsSettings,
              searchExampleComparisonsSettings,
              createEvaluationJobSettings,
              updateEvaluationJobSettings,
              getEvaluationJobSettings,
              pauseEvaluationJobSettings,
              resumeEvaluationJobSettings,
              deleteEvaluationJobSettings,
              listEvaluationJobsSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .createDatasetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getDatasetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .listDatasetsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .deleteDatasetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .importDataSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .exportDataSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .getDataItemSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .listDataItemsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .getAnnotatedDatasetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .listAnnotatedDatasetsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .deleteAnnotatedDatasetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .labelImageSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .labelVideoSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .labelTextSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getExampleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .listExamplesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .createAnnotationSpecSetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getAnnotationSpecSetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .listAnnotationSpecSetsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .deleteAnnotationSpecSetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .createInstructionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getInstructionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .listInstructionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .deleteInstructionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .getEvaluationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .searchEvaluationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .searchExampleComparisonsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createEvaluationJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateEvaluationJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getEvaluationJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .pauseEvaluationJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .resumeEvaluationJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteEvaluationJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .listEvaluationJobsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .importDataOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<ImportDataRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  ImportDataOperationResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  ImportDataOperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .exportDataOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<ExportDataRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  ExportDataOperationResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  ExportDataOperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .labelImageOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<LabelImageRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(AnnotatedDataset.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(LabelOperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .labelVideoOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<LabelVideoRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(AnnotatedDataset.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(LabelOperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .labelTextOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<LabelTextRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(AnnotatedDataset.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(LabelOperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createInstructionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateInstructionRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Instruction.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  CreateInstructionMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
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

    /** Returns the builder for the settings used for calls to createDataset. */
    public UnaryCallSettings.Builder<CreateDatasetRequest, Dataset> createDatasetSettings() {
      return createDatasetSettings;
    }

    /** Returns the builder for the settings used for calls to getDataset. */
    public UnaryCallSettings.Builder<GetDatasetRequest, Dataset> getDatasetSettings() {
      return getDatasetSettings;
    }

    /** Returns the builder for the settings used for calls to listDatasets. */
    public PagedCallSettings.Builder<
            ListDatasetsRequest, ListDatasetsResponse, ListDatasetsPagedResponse>
        listDatasetsSettings() {
      return listDatasetsSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDataset. */
    public UnaryCallSettings.Builder<DeleteDatasetRequest, Empty> deleteDatasetSettings() {
      return deleteDatasetSettings;
    }

    /** Returns the builder for the settings used for calls to importData. */
    public UnaryCallSettings.Builder<ImportDataRequest, Operation> importDataSettings() {
      return importDataSettings;
    }

    /** Returns the builder for the settings used for calls to importData. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            ImportDataRequest, ImportDataOperationResponse, ImportDataOperationMetadata>
        importDataOperationSettings() {
      return importDataOperationSettings;
    }

    /** Returns the builder for the settings used for calls to exportData. */
    public UnaryCallSettings.Builder<ExportDataRequest, Operation> exportDataSettings() {
      return exportDataSettings;
    }

    /** Returns the builder for the settings used for calls to exportData. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            ExportDataRequest, ExportDataOperationResponse, ExportDataOperationMetadata>
        exportDataOperationSettings() {
      return exportDataOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getDataItem. */
    public UnaryCallSettings.Builder<GetDataItemRequest, DataItem> getDataItemSettings() {
      return getDataItemSettings;
    }

    /** Returns the builder for the settings used for calls to listDataItems. */
    public PagedCallSettings.Builder<
            ListDataItemsRequest, ListDataItemsResponse, ListDataItemsPagedResponse>
        listDataItemsSettings() {
      return listDataItemsSettings;
    }

    /** Returns the builder for the settings used for calls to getAnnotatedDataset. */
    public UnaryCallSettings.Builder<GetAnnotatedDatasetRequest, AnnotatedDataset>
        getAnnotatedDatasetSettings() {
      return getAnnotatedDatasetSettings;
    }

    /** Returns the builder for the settings used for calls to listAnnotatedDatasets. */
    public PagedCallSettings.Builder<
            ListAnnotatedDatasetsRequest,
            ListAnnotatedDatasetsResponse,
            ListAnnotatedDatasetsPagedResponse>
        listAnnotatedDatasetsSettings() {
      return listAnnotatedDatasetsSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAnnotatedDataset. */
    public UnaryCallSettings.Builder<DeleteAnnotatedDatasetRequest, Empty>
        deleteAnnotatedDatasetSettings() {
      return deleteAnnotatedDatasetSettings;
    }

    /** Returns the builder for the settings used for calls to labelImage. */
    public UnaryCallSettings.Builder<LabelImageRequest, Operation> labelImageSettings() {
      return labelImageSettings;
    }

    /** Returns the builder for the settings used for calls to labelImage. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            LabelImageRequest, AnnotatedDataset, LabelOperationMetadata>
        labelImageOperationSettings() {
      return labelImageOperationSettings;
    }

    /** Returns the builder for the settings used for calls to labelVideo. */
    public UnaryCallSettings.Builder<LabelVideoRequest, Operation> labelVideoSettings() {
      return labelVideoSettings;
    }

    /** Returns the builder for the settings used for calls to labelVideo. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            LabelVideoRequest, AnnotatedDataset, LabelOperationMetadata>
        labelVideoOperationSettings() {
      return labelVideoOperationSettings;
    }

    /** Returns the builder for the settings used for calls to labelText. */
    public UnaryCallSettings.Builder<LabelTextRequest, Operation> labelTextSettings() {
      return labelTextSettings;
    }

    /** Returns the builder for the settings used for calls to labelText. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<LabelTextRequest, AnnotatedDataset, LabelOperationMetadata>
        labelTextOperationSettings() {
      return labelTextOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getExample. */
    public UnaryCallSettings.Builder<GetExampleRequest, Example> getExampleSettings() {
      return getExampleSettings;
    }

    /** Returns the builder for the settings used for calls to listExamples. */
    public PagedCallSettings.Builder<
            ListExamplesRequest, ListExamplesResponse, ListExamplesPagedResponse>
        listExamplesSettings() {
      return listExamplesSettings;
    }

    /** Returns the builder for the settings used for calls to createAnnotationSpecSet. */
    public UnaryCallSettings.Builder<CreateAnnotationSpecSetRequest, AnnotationSpecSet>
        createAnnotationSpecSetSettings() {
      return createAnnotationSpecSetSettings;
    }

    /** Returns the builder for the settings used for calls to getAnnotationSpecSet. */
    public UnaryCallSettings.Builder<GetAnnotationSpecSetRequest, AnnotationSpecSet>
        getAnnotationSpecSetSettings() {
      return getAnnotationSpecSetSettings;
    }

    /** Returns the builder for the settings used for calls to listAnnotationSpecSets. */
    public PagedCallSettings.Builder<
            ListAnnotationSpecSetsRequest,
            ListAnnotationSpecSetsResponse,
            ListAnnotationSpecSetsPagedResponse>
        listAnnotationSpecSetsSettings() {
      return listAnnotationSpecSetsSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAnnotationSpecSet. */
    public UnaryCallSettings.Builder<DeleteAnnotationSpecSetRequest, Empty>
        deleteAnnotationSpecSetSettings() {
      return deleteAnnotationSpecSetSettings;
    }

    /** Returns the builder for the settings used for calls to createInstruction. */
    public UnaryCallSettings.Builder<CreateInstructionRequest, Operation>
        createInstructionSettings() {
      return createInstructionSettings;
    }

    /** Returns the builder for the settings used for calls to createInstruction. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            CreateInstructionRequest, Instruction, CreateInstructionMetadata>
        createInstructionOperationSettings() {
      return createInstructionOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getInstruction. */
    public UnaryCallSettings.Builder<GetInstructionRequest, Instruction> getInstructionSettings() {
      return getInstructionSettings;
    }

    /** Returns the builder for the settings used for calls to listInstructions. */
    public PagedCallSettings.Builder<
            ListInstructionsRequest, ListInstructionsResponse, ListInstructionsPagedResponse>
        listInstructionsSettings() {
      return listInstructionsSettings;
    }

    /** Returns the builder for the settings used for calls to deleteInstruction. */
    public UnaryCallSettings.Builder<DeleteInstructionRequest, Empty> deleteInstructionSettings() {
      return deleteInstructionSettings;
    }

    /** Returns the builder for the settings used for calls to getEvaluation. */
    public UnaryCallSettings.Builder<GetEvaluationRequest, Evaluation> getEvaluationSettings() {
      return getEvaluationSettings;
    }

    /** Returns the builder for the settings used for calls to searchEvaluations. */
    public PagedCallSettings.Builder<
            SearchEvaluationsRequest, SearchEvaluationsResponse, SearchEvaluationsPagedResponse>
        searchEvaluationsSettings() {
      return searchEvaluationsSettings;
    }

    /** Returns the builder for the settings used for calls to searchExampleComparisons. */
    public PagedCallSettings.Builder<
            SearchExampleComparisonsRequest,
            SearchExampleComparisonsResponse,
            SearchExampleComparisonsPagedResponse>
        searchExampleComparisonsSettings() {
      return searchExampleComparisonsSettings;
    }

    /** Returns the builder for the settings used for calls to createEvaluationJob. */
    public UnaryCallSettings.Builder<CreateEvaluationJobRequest, EvaluationJob>
        createEvaluationJobSettings() {
      return createEvaluationJobSettings;
    }

    /** Returns the builder for the settings used for calls to updateEvaluationJob. */
    public UnaryCallSettings.Builder<UpdateEvaluationJobRequest, EvaluationJob>
        updateEvaluationJobSettings() {
      return updateEvaluationJobSettings;
    }

    /** Returns the builder for the settings used for calls to getEvaluationJob. */
    public UnaryCallSettings.Builder<GetEvaluationJobRequest, EvaluationJob>
        getEvaluationJobSettings() {
      return getEvaluationJobSettings;
    }

    /** Returns the builder for the settings used for calls to pauseEvaluationJob. */
    public UnaryCallSettings.Builder<PauseEvaluationJobRequest, Empty>
        pauseEvaluationJobSettings() {
      return pauseEvaluationJobSettings;
    }

    /** Returns the builder for the settings used for calls to resumeEvaluationJob. */
    public UnaryCallSettings.Builder<ResumeEvaluationJobRequest, Empty>
        resumeEvaluationJobSettings() {
      return resumeEvaluationJobSettings;
    }

    /** Returns the builder for the settings used for calls to deleteEvaluationJob. */
    public UnaryCallSettings.Builder<DeleteEvaluationJobRequest, Empty>
        deleteEvaluationJobSettings() {
      return deleteEvaluationJobSettings;
    }

    /** Returns the builder for the settings used for calls to listEvaluationJobs. */
    public PagedCallSettings.Builder<
            ListEvaluationJobsRequest, ListEvaluationJobsResponse, ListEvaluationJobsPagedResponse>
        listEvaluationJobsSettings() {
      return listEvaluationJobsSettings;
    }

    @Override
    public DataLabelingServiceStubSettings build() throws IOException {
      return new DataLabelingServiceStubSettings(this);
    }
  }
}
