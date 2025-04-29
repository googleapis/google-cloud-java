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

package com.google.cloud.aiplatform.v1beta1.stub;

import static com.google.cloud.aiplatform.v1beta1.DatasetServiceClient.ListAnnotationsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.DatasetServiceClient.ListDataItemsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.DatasetServiceClient.ListDatasetVersionsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.DatasetServiceClient.ListDatasetsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.DatasetServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.DatasetServiceClient.ListSavedQueriesPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.DatasetServiceClient.SearchDataItemsPagedResponse;

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
import com.google.cloud.aiplatform.v1beta1.Annotation;
import com.google.cloud.aiplatform.v1beta1.AnnotationSpec;
import com.google.cloud.aiplatform.v1beta1.AssembleDataOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.AssembleDataRequest;
import com.google.cloud.aiplatform.v1beta1.AssembleDataResponse;
import com.google.cloud.aiplatform.v1beta1.AssessDataOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.AssessDataRequest;
import com.google.cloud.aiplatform.v1beta1.AssessDataResponse;
import com.google.cloud.aiplatform.v1beta1.CreateDatasetOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.CreateDatasetRequest;
import com.google.cloud.aiplatform.v1beta1.CreateDatasetVersionOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.CreateDatasetVersionRequest;
import com.google.cloud.aiplatform.v1beta1.DataItem;
import com.google.cloud.aiplatform.v1beta1.DataItemView;
import com.google.cloud.aiplatform.v1beta1.Dataset;
import com.google.cloud.aiplatform.v1beta1.DatasetVersion;
import com.google.cloud.aiplatform.v1beta1.DeleteDatasetRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteDatasetVersionRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.DeleteSavedQueryRequest;
import com.google.cloud.aiplatform.v1beta1.ExportDataOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.ExportDataRequest;
import com.google.cloud.aiplatform.v1beta1.ExportDataResponse;
import com.google.cloud.aiplatform.v1beta1.GetAnnotationSpecRequest;
import com.google.cloud.aiplatform.v1beta1.GetDatasetRequest;
import com.google.cloud.aiplatform.v1beta1.GetDatasetVersionRequest;
import com.google.cloud.aiplatform.v1beta1.ImportDataOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.ImportDataRequest;
import com.google.cloud.aiplatform.v1beta1.ImportDataResponse;
import com.google.cloud.aiplatform.v1beta1.ListAnnotationsRequest;
import com.google.cloud.aiplatform.v1beta1.ListAnnotationsResponse;
import com.google.cloud.aiplatform.v1beta1.ListDataItemsRequest;
import com.google.cloud.aiplatform.v1beta1.ListDataItemsResponse;
import com.google.cloud.aiplatform.v1beta1.ListDatasetVersionsRequest;
import com.google.cloud.aiplatform.v1beta1.ListDatasetVersionsResponse;
import com.google.cloud.aiplatform.v1beta1.ListDatasetsRequest;
import com.google.cloud.aiplatform.v1beta1.ListDatasetsResponse;
import com.google.cloud.aiplatform.v1beta1.ListSavedQueriesRequest;
import com.google.cloud.aiplatform.v1beta1.ListSavedQueriesResponse;
import com.google.cloud.aiplatform.v1beta1.RestoreDatasetVersionOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.RestoreDatasetVersionRequest;
import com.google.cloud.aiplatform.v1beta1.SavedQuery;
import com.google.cloud.aiplatform.v1beta1.SearchDataItemsRequest;
import com.google.cloud.aiplatform.v1beta1.SearchDataItemsResponse;
import com.google.cloud.aiplatform.v1beta1.UpdateDatasetRequest;
import com.google.cloud.aiplatform.v1beta1.UpdateDatasetVersionRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link DatasetServiceStub}.
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
 * DatasetServiceStubSettings.Builder datasetServiceSettingsBuilder =
 *     DatasetServiceStubSettings.newBuilder();
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
 * DatasetServiceStubSettings datasetServiceSettings = datasetServiceSettingsBuilder.build();
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
 * DatasetServiceStubSettings.Builder datasetServiceSettingsBuilder =
 *     DatasetServiceStubSettings.newBuilder();
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
public class DatasetServiceStubSettings extends StubSettings<DatasetServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateDatasetRequest, Operation> createDatasetSettings;
  private final OperationCallSettings<CreateDatasetRequest, Dataset, CreateDatasetOperationMetadata>
      createDatasetOperationSettings;
  private final UnaryCallSettings<GetDatasetRequest, Dataset> getDatasetSettings;
  private final UnaryCallSettings<UpdateDatasetRequest, Dataset> updateDatasetSettings;
  private final PagedCallSettings<
          ListDatasetsRequest, ListDatasetsResponse, ListDatasetsPagedResponse>
      listDatasetsSettings;
  private final UnaryCallSettings<DeleteDatasetRequest, Operation> deleteDatasetSettings;
  private final OperationCallSettings<DeleteDatasetRequest, Empty, DeleteOperationMetadata>
      deleteDatasetOperationSettings;
  private final UnaryCallSettings<ImportDataRequest, Operation> importDataSettings;
  private final OperationCallSettings<
          ImportDataRequest, ImportDataResponse, ImportDataOperationMetadata>
      importDataOperationSettings;
  private final UnaryCallSettings<ExportDataRequest, Operation> exportDataSettings;
  private final OperationCallSettings<
          ExportDataRequest, ExportDataResponse, ExportDataOperationMetadata>
      exportDataOperationSettings;
  private final UnaryCallSettings<CreateDatasetVersionRequest, Operation>
      createDatasetVersionSettings;
  private final OperationCallSettings<
          CreateDatasetVersionRequest, DatasetVersion, CreateDatasetVersionOperationMetadata>
      createDatasetVersionOperationSettings;
  private final UnaryCallSettings<UpdateDatasetVersionRequest, DatasetVersion>
      updateDatasetVersionSettings;
  private final UnaryCallSettings<DeleteDatasetVersionRequest, Operation>
      deleteDatasetVersionSettings;
  private final OperationCallSettings<DeleteDatasetVersionRequest, Empty, DeleteOperationMetadata>
      deleteDatasetVersionOperationSettings;
  private final UnaryCallSettings<GetDatasetVersionRequest, DatasetVersion>
      getDatasetVersionSettings;
  private final PagedCallSettings<
          ListDatasetVersionsRequest, ListDatasetVersionsResponse, ListDatasetVersionsPagedResponse>
      listDatasetVersionsSettings;
  private final UnaryCallSettings<RestoreDatasetVersionRequest, Operation>
      restoreDatasetVersionSettings;
  private final OperationCallSettings<
          RestoreDatasetVersionRequest, DatasetVersion, RestoreDatasetVersionOperationMetadata>
      restoreDatasetVersionOperationSettings;
  private final PagedCallSettings<
          ListDataItemsRequest, ListDataItemsResponse, ListDataItemsPagedResponse>
      listDataItemsSettings;
  private final PagedCallSettings<
          SearchDataItemsRequest, SearchDataItemsResponse, SearchDataItemsPagedResponse>
      searchDataItemsSettings;
  private final PagedCallSettings<
          ListSavedQueriesRequest, ListSavedQueriesResponse, ListSavedQueriesPagedResponse>
      listSavedQueriesSettings;
  private final UnaryCallSettings<DeleteSavedQueryRequest, Operation> deleteSavedQuerySettings;
  private final OperationCallSettings<DeleteSavedQueryRequest, Empty, DeleteOperationMetadata>
      deleteSavedQueryOperationSettings;
  private final UnaryCallSettings<GetAnnotationSpecRequest, AnnotationSpec>
      getAnnotationSpecSettings;
  private final PagedCallSettings<
          ListAnnotationsRequest, ListAnnotationsResponse, ListAnnotationsPagedResponse>
      listAnnotationsSettings;
  private final UnaryCallSettings<AssessDataRequest, Operation> assessDataSettings;
  private final OperationCallSettings<
          AssessDataRequest, AssessDataResponse, AssessDataOperationMetadata>
      assessDataOperationSettings;
  private final UnaryCallSettings<AssembleDataRequest, Operation> assembleDataSettings;
  private final OperationCallSettings<
          AssembleDataRequest, AssembleDataResponse, AssembleDataOperationMetadata>
      assembleDataOperationSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

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

  private static final PagedListDescriptor<
          ListDatasetVersionsRequest, ListDatasetVersionsResponse, DatasetVersion>
      LIST_DATASET_VERSIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListDatasetVersionsRequest, ListDatasetVersionsResponse, DatasetVersion>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDatasetVersionsRequest injectToken(
                ListDatasetVersionsRequest payload, String token) {
              return ListDatasetVersionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDatasetVersionsRequest injectPageSize(
                ListDatasetVersionsRequest payload, int pageSize) {
              return ListDatasetVersionsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListDatasetVersionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDatasetVersionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DatasetVersion> extractResources(ListDatasetVersionsResponse payload) {
              return payload.getDatasetVersionsList();
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
              return payload.getDataItemsList();
            }
          };

  private static final PagedListDescriptor<
          SearchDataItemsRequest, SearchDataItemsResponse, DataItemView>
      SEARCH_DATA_ITEMS_PAGE_STR_DESC =
          new PagedListDescriptor<SearchDataItemsRequest, SearchDataItemsResponse, DataItemView>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public SearchDataItemsRequest injectToken(
                SearchDataItemsRequest payload, String token) {
              return SearchDataItemsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public SearchDataItemsRequest injectPageSize(
                SearchDataItemsRequest payload, int pageSize) {
              return SearchDataItemsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(SearchDataItemsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(SearchDataItemsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DataItemView> extractResources(SearchDataItemsResponse payload) {
              return payload.getDataItemViewsList();
            }
          };

  private static final PagedListDescriptor<
          ListSavedQueriesRequest, ListSavedQueriesResponse, SavedQuery>
      LIST_SAVED_QUERIES_PAGE_STR_DESC =
          new PagedListDescriptor<ListSavedQueriesRequest, ListSavedQueriesResponse, SavedQuery>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListSavedQueriesRequest injectToken(
                ListSavedQueriesRequest payload, String token) {
              return ListSavedQueriesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListSavedQueriesRequest injectPageSize(
                ListSavedQueriesRequest payload, int pageSize) {
              return ListSavedQueriesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListSavedQueriesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListSavedQueriesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<SavedQuery> extractResources(ListSavedQueriesResponse payload) {
              return payload.getSavedQueriesList();
            }
          };

  private static final PagedListDescriptor<
          ListAnnotationsRequest, ListAnnotationsResponse, Annotation>
      LIST_ANNOTATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListAnnotationsRequest, ListAnnotationsResponse, Annotation>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAnnotationsRequest injectToken(
                ListAnnotationsRequest payload, String token) {
              return ListAnnotationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAnnotationsRequest injectPageSize(
                ListAnnotationsRequest payload, int pageSize) {
              return ListAnnotationsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAnnotationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAnnotationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Annotation> extractResources(ListAnnotationsResponse payload) {
              return payload.getAnnotationsList();
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
          ListDatasetVersionsRequest, ListDatasetVersionsResponse, ListDatasetVersionsPagedResponse>
      LIST_DATASET_VERSIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDatasetVersionsRequest,
              ListDatasetVersionsResponse,
              ListDatasetVersionsPagedResponse>() {
            @Override
            public ApiFuture<ListDatasetVersionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDatasetVersionsRequest, ListDatasetVersionsResponse> callable,
                ListDatasetVersionsRequest request,
                ApiCallContext context,
                ApiFuture<ListDatasetVersionsResponse> futureResponse) {
              PageContext<ListDatasetVersionsRequest, ListDatasetVersionsResponse, DatasetVersion>
                  pageContext =
                      PageContext.create(
                          callable, LIST_DATASET_VERSIONS_PAGE_STR_DESC, request, context);
              return ListDatasetVersionsPagedResponse.createAsync(pageContext, futureResponse);
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
          SearchDataItemsRequest, SearchDataItemsResponse, SearchDataItemsPagedResponse>
      SEARCH_DATA_ITEMS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              SearchDataItemsRequest, SearchDataItemsResponse, SearchDataItemsPagedResponse>() {
            @Override
            public ApiFuture<SearchDataItemsPagedResponse> getFuturePagedResponse(
                UnaryCallable<SearchDataItemsRequest, SearchDataItemsResponse> callable,
                SearchDataItemsRequest request,
                ApiCallContext context,
                ApiFuture<SearchDataItemsResponse> futureResponse) {
              PageContext<SearchDataItemsRequest, SearchDataItemsResponse, DataItemView>
                  pageContext =
                      PageContext.create(
                          callable, SEARCH_DATA_ITEMS_PAGE_STR_DESC, request, context);
              return SearchDataItemsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListSavedQueriesRequest, ListSavedQueriesResponse, ListSavedQueriesPagedResponse>
      LIST_SAVED_QUERIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListSavedQueriesRequest, ListSavedQueriesResponse, ListSavedQueriesPagedResponse>() {
            @Override
            public ApiFuture<ListSavedQueriesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListSavedQueriesRequest, ListSavedQueriesResponse> callable,
                ListSavedQueriesRequest request,
                ApiCallContext context,
                ApiFuture<ListSavedQueriesResponse> futureResponse) {
              PageContext<ListSavedQueriesRequest, ListSavedQueriesResponse, SavedQuery>
                  pageContext =
                      PageContext.create(
                          callable, LIST_SAVED_QUERIES_PAGE_STR_DESC, request, context);
              return ListSavedQueriesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListAnnotationsRequest, ListAnnotationsResponse, ListAnnotationsPagedResponse>
      LIST_ANNOTATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAnnotationsRequest, ListAnnotationsResponse, ListAnnotationsPagedResponse>() {
            @Override
            public ApiFuture<ListAnnotationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAnnotationsRequest, ListAnnotationsResponse> callable,
                ListAnnotationsRequest request,
                ApiCallContext context,
                ApiFuture<ListAnnotationsResponse> futureResponse) {
              PageContext<ListAnnotationsRequest, ListAnnotationsResponse, Annotation> pageContext =
                  PageContext.create(callable, LIST_ANNOTATIONS_PAGE_STR_DESC, request, context);
              return ListAnnotationsPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to createDataset. */
  public UnaryCallSettings<CreateDatasetRequest, Operation> createDatasetSettings() {
    return createDatasetSettings;
  }

  /** Returns the object with the settings used for calls to createDataset. */
  public OperationCallSettings<CreateDatasetRequest, Dataset, CreateDatasetOperationMetadata>
      createDatasetOperationSettings() {
    return createDatasetOperationSettings;
  }

  /** Returns the object with the settings used for calls to getDataset. */
  public UnaryCallSettings<GetDatasetRequest, Dataset> getDatasetSettings() {
    return getDatasetSettings;
  }

  /** Returns the object with the settings used for calls to updateDataset. */
  public UnaryCallSettings<UpdateDatasetRequest, Dataset> updateDatasetSettings() {
    return updateDatasetSettings;
  }

  /** Returns the object with the settings used for calls to listDatasets. */
  public PagedCallSettings<ListDatasetsRequest, ListDatasetsResponse, ListDatasetsPagedResponse>
      listDatasetsSettings() {
    return listDatasetsSettings;
  }

  /** Returns the object with the settings used for calls to deleteDataset. */
  public UnaryCallSettings<DeleteDatasetRequest, Operation> deleteDatasetSettings() {
    return deleteDatasetSettings;
  }

  /** Returns the object with the settings used for calls to deleteDataset. */
  public OperationCallSettings<DeleteDatasetRequest, Empty, DeleteOperationMetadata>
      deleteDatasetOperationSettings() {
    return deleteDatasetOperationSettings;
  }

  /** Returns the object with the settings used for calls to importData. */
  public UnaryCallSettings<ImportDataRequest, Operation> importDataSettings() {
    return importDataSettings;
  }

  /** Returns the object with the settings used for calls to importData. */
  public OperationCallSettings<ImportDataRequest, ImportDataResponse, ImportDataOperationMetadata>
      importDataOperationSettings() {
    return importDataOperationSettings;
  }

  /** Returns the object with the settings used for calls to exportData. */
  public UnaryCallSettings<ExportDataRequest, Operation> exportDataSettings() {
    return exportDataSettings;
  }

  /** Returns the object with the settings used for calls to exportData. */
  public OperationCallSettings<ExportDataRequest, ExportDataResponse, ExportDataOperationMetadata>
      exportDataOperationSettings() {
    return exportDataOperationSettings;
  }

  /** Returns the object with the settings used for calls to createDatasetVersion. */
  public UnaryCallSettings<CreateDatasetVersionRequest, Operation> createDatasetVersionSettings() {
    return createDatasetVersionSettings;
  }

  /** Returns the object with the settings used for calls to createDatasetVersion. */
  public OperationCallSettings<
          CreateDatasetVersionRequest, DatasetVersion, CreateDatasetVersionOperationMetadata>
      createDatasetVersionOperationSettings() {
    return createDatasetVersionOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateDatasetVersion. */
  public UnaryCallSettings<UpdateDatasetVersionRequest, DatasetVersion>
      updateDatasetVersionSettings() {
    return updateDatasetVersionSettings;
  }

  /** Returns the object with the settings used for calls to deleteDatasetVersion. */
  public UnaryCallSettings<DeleteDatasetVersionRequest, Operation> deleteDatasetVersionSettings() {
    return deleteDatasetVersionSettings;
  }

  /** Returns the object with the settings used for calls to deleteDatasetVersion. */
  public OperationCallSettings<DeleteDatasetVersionRequest, Empty, DeleteOperationMetadata>
      deleteDatasetVersionOperationSettings() {
    return deleteDatasetVersionOperationSettings;
  }

  /** Returns the object with the settings used for calls to getDatasetVersion. */
  public UnaryCallSettings<GetDatasetVersionRequest, DatasetVersion> getDatasetVersionSettings() {
    return getDatasetVersionSettings;
  }

  /** Returns the object with the settings used for calls to listDatasetVersions. */
  public PagedCallSettings<
          ListDatasetVersionsRequest, ListDatasetVersionsResponse, ListDatasetVersionsPagedResponse>
      listDatasetVersionsSettings() {
    return listDatasetVersionsSettings;
  }

  /** Returns the object with the settings used for calls to restoreDatasetVersion. */
  public UnaryCallSettings<RestoreDatasetVersionRequest, Operation>
      restoreDatasetVersionSettings() {
    return restoreDatasetVersionSettings;
  }

  /** Returns the object with the settings used for calls to restoreDatasetVersion. */
  public OperationCallSettings<
          RestoreDatasetVersionRequest, DatasetVersion, RestoreDatasetVersionOperationMetadata>
      restoreDatasetVersionOperationSettings() {
    return restoreDatasetVersionOperationSettings;
  }

  /** Returns the object with the settings used for calls to listDataItems. */
  public PagedCallSettings<ListDataItemsRequest, ListDataItemsResponse, ListDataItemsPagedResponse>
      listDataItemsSettings() {
    return listDataItemsSettings;
  }

  /** Returns the object with the settings used for calls to searchDataItems. */
  public PagedCallSettings<
          SearchDataItemsRequest, SearchDataItemsResponse, SearchDataItemsPagedResponse>
      searchDataItemsSettings() {
    return searchDataItemsSettings;
  }

  /** Returns the object with the settings used for calls to listSavedQueries. */
  public PagedCallSettings<
          ListSavedQueriesRequest, ListSavedQueriesResponse, ListSavedQueriesPagedResponse>
      listSavedQueriesSettings() {
    return listSavedQueriesSettings;
  }

  /** Returns the object with the settings used for calls to deleteSavedQuery. */
  public UnaryCallSettings<DeleteSavedQueryRequest, Operation> deleteSavedQuerySettings() {
    return deleteSavedQuerySettings;
  }

  /** Returns the object with the settings used for calls to deleteSavedQuery. */
  public OperationCallSettings<DeleteSavedQueryRequest, Empty, DeleteOperationMetadata>
      deleteSavedQueryOperationSettings() {
    return deleteSavedQueryOperationSettings;
  }

  /** Returns the object with the settings used for calls to getAnnotationSpec. */
  public UnaryCallSettings<GetAnnotationSpecRequest, AnnotationSpec> getAnnotationSpecSettings() {
    return getAnnotationSpecSettings;
  }

  /** Returns the object with the settings used for calls to listAnnotations. */
  public PagedCallSettings<
          ListAnnotationsRequest, ListAnnotationsResponse, ListAnnotationsPagedResponse>
      listAnnotationsSettings() {
    return listAnnotationsSettings;
  }

  /** Returns the object with the settings used for calls to assessData. */
  public UnaryCallSettings<AssessDataRequest, Operation> assessDataSettings() {
    return assessDataSettings;
  }

  /** Returns the object with the settings used for calls to assessData. */
  public OperationCallSettings<AssessDataRequest, AssessDataResponse, AssessDataOperationMetadata>
      assessDataOperationSettings() {
    return assessDataOperationSettings;
  }

  /** Returns the object with the settings used for calls to assembleData. */
  public UnaryCallSettings<AssembleDataRequest, Operation> assembleDataSettings() {
    return assembleDataSettings;
  }

  /** Returns the object with the settings used for calls to assembleData. */
  public OperationCallSettings<
          AssembleDataRequest, AssembleDataResponse, AssembleDataOperationMetadata>
      assembleDataOperationSettings() {
    return assembleDataOperationSettings;
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

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return setIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return getIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return testIamPermissionsSettings;
  }

  public DatasetServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcDatasetServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "aiplatform";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "aiplatform.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "aiplatform.mtls.googleapis.com:443";
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

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(DatasetServiceStubSettings.class))
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

  protected DatasetServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createDatasetSettings = settingsBuilder.createDatasetSettings().build();
    createDatasetOperationSettings = settingsBuilder.createDatasetOperationSettings().build();
    getDatasetSettings = settingsBuilder.getDatasetSettings().build();
    updateDatasetSettings = settingsBuilder.updateDatasetSettings().build();
    listDatasetsSettings = settingsBuilder.listDatasetsSettings().build();
    deleteDatasetSettings = settingsBuilder.deleteDatasetSettings().build();
    deleteDatasetOperationSettings = settingsBuilder.deleteDatasetOperationSettings().build();
    importDataSettings = settingsBuilder.importDataSettings().build();
    importDataOperationSettings = settingsBuilder.importDataOperationSettings().build();
    exportDataSettings = settingsBuilder.exportDataSettings().build();
    exportDataOperationSettings = settingsBuilder.exportDataOperationSettings().build();
    createDatasetVersionSettings = settingsBuilder.createDatasetVersionSettings().build();
    createDatasetVersionOperationSettings =
        settingsBuilder.createDatasetVersionOperationSettings().build();
    updateDatasetVersionSettings = settingsBuilder.updateDatasetVersionSettings().build();
    deleteDatasetVersionSettings = settingsBuilder.deleteDatasetVersionSettings().build();
    deleteDatasetVersionOperationSettings =
        settingsBuilder.deleteDatasetVersionOperationSettings().build();
    getDatasetVersionSettings = settingsBuilder.getDatasetVersionSettings().build();
    listDatasetVersionsSettings = settingsBuilder.listDatasetVersionsSettings().build();
    restoreDatasetVersionSettings = settingsBuilder.restoreDatasetVersionSettings().build();
    restoreDatasetVersionOperationSettings =
        settingsBuilder.restoreDatasetVersionOperationSettings().build();
    listDataItemsSettings = settingsBuilder.listDataItemsSettings().build();
    searchDataItemsSettings = settingsBuilder.searchDataItemsSettings().build();
    listSavedQueriesSettings = settingsBuilder.listSavedQueriesSettings().build();
    deleteSavedQuerySettings = settingsBuilder.deleteSavedQuerySettings().build();
    deleteSavedQueryOperationSettings = settingsBuilder.deleteSavedQueryOperationSettings().build();
    getAnnotationSpecSettings = settingsBuilder.getAnnotationSpecSettings().build();
    listAnnotationsSettings = settingsBuilder.listAnnotationsSettings().build();
    assessDataSettings = settingsBuilder.assessDataSettings().build();
    assessDataOperationSettings = settingsBuilder.assessDataOperationSettings().build();
    assembleDataSettings = settingsBuilder.assembleDataSettings().build();
    assembleDataOperationSettings = settingsBuilder.assembleDataOperationSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for DatasetServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<DatasetServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateDatasetRequest, Operation> createDatasetSettings;
    private final OperationCallSettings.Builder<
            CreateDatasetRequest, Dataset, CreateDatasetOperationMetadata>
        createDatasetOperationSettings;
    private final UnaryCallSettings.Builder<GetDatasetRequest, Dataset> getDatasetSettings;
    private final UnaryCallSettings.Builder<UpdateDatasetRequest, Dataset> updateDatasetSettings;
    private final PagedCallSettings.Builder<
            ListDatasetsRequest, ListDatasetsResponse, ListDatasetsPagedResponse>
        listDatasetsSettings;
    private final UnaryCallSettings.Builder<DeleteDatasetRequest, Operation> deleteDatasetSettings;
    private final OperationCallSettings.Builder<
            DeleteDatasetRequest, Empty, DeleteOperationMetadata>
        deleteDatasetOperationSettings;
    private final UnaryCallSettings.Builder<ImportDataRequest, Operation> importDataSettings;
    private final OperationCallSettings.Builder<
            ImportDataRequest, ImportDataResponse, ImportDataOperationMetadata>
        importDataOperationSettings;
    private final UnaryCallSettings.Builder<ExportDataRequest, Operation> exportDataSettings;
    private final OperationCallSettings.Builder<
            ExportDataRequest, ExportDataResponse, ExportDataOperationMetadata>
        exportDataOperationSettings;
    private final UnaryCallSettings.Builder<CreateDatasetVersionRequest, Operation>
        createDatasetVersionSettings;
    private final OperationCallSettings.Builder<
            CreateDatasetVersionRequest, DatasetVersion, CreateDatasetVersionOperationMetadata>
        createDatasetVersionOperationSettings;
    private final UnaryCallSettings.Builder<UpdateDatasetVersionRequest, DatasetVersion>
        updateDatasetVersionSettings;
    private final UnaryCallSettings.Builder<DeleteDatasetVersionRequest, Operation>
        deleteDatasetVersionSettings;
    private final OperationCallSettings.Builder<
            DeleteDatasetVersionRequest, Empty, DeleteOperationMetadata>
        deleteDatasetVersionOperationSettings;
    private final UnaryCallSettings.Builder<GetDatasetVersionRequest, DatasetVersion>
        getDatasetVersionSettings;
    private final PagedCallSettings.Builder<
            ListDatasetVersionsRequest,
            ListDatasetVersionsResponse,
            ListDatasetVersionsPagedResponse>
        listDatasetVersionsSettings;
    private final UnaryCallSettings.Builder<RestoreDatasetVersionRequest, Operation>
        restoreDatasetVersionSettings;
    private final OperationCallSettings.Builder<
            RestoreDatasetVersionRequest, DatasetVersion, RestoreDatasetVersionOperationMetadata>
        restoreDatasetVersionOperationSettings;
    private final PagedCallSettings.Builder<
            ListDataItemsRequest, ListDataItemsResponse, ListDataItemsPagedResponse>
        listDataItemsSettings;
    private final PagedCallSettings.Builder<
            SearchDataItemsRequest, SearchDataItemsResponse, SearchDataItemsPagedResponse>
        searchDataItemsSettings;
    private final PagedCallSettings.Builder<
            ListSavedQueriesRequest, ListSavedQueriesResponse, ListSavedQueriesPagedResponse>
        listSavedQueriesSettings;
    private final UnaryCallSettings.Builder<DeleteSavedQueryRequest, Operation>
        deleteSavedQuerySettings;
    private final OperationCallSettings.Builder<
            DeleteSavedQueryRequest, Empty, DeleteOperationMetadata>
        deleteSavedQueryOperationSettings;
    private final UnaryCallSettings.Builder<GetAnnotationSpecRequest, AnnotationSpec>
        getAnnotationSpecSettings;
    private final PagedCallSettings.Builder<
            ListAnnotationsRequest, ListAnnotationsResponse, ListAnnotationsPagedResponse>
        listAnnotationsSettings;
    private final UnaryCallSettings.Builder<AssessDataRequest, Operation> assessDataSettings;
    private final OperationCallSettings.Builder<
            AssessDataRequest, AssessDataResponse, AssessDataOperationMetadata>
        assessDataOperationSettings;
    private final UnaryCallSettings.Builder<AssembleDataRequest, Operation> assembleDataSettings;
    private final OperationCallSettings.Builder<
            AssembleDataRequest, AssembleDataResponse, AssembleDataOperationMetadata>
        assembleDataOperationSettings;
    private final PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings;
    private final UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings;
    private final UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings;
    private final UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings;
    private final UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_0_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeoutDuration(Duration.ofMillis(5000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(5000L))
              .setTotalTimeoutDuration(Duration.ofMillis(5000L))
              .build();
      definitions.put("no_retry_0_params", settings);
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
      createDatasetOperationSettings = OperationCallSettings.newBuilder();
      getDatasetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateDatasetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listDatasetsSettings = PagedCallSettings.newBuilder(LIST_DATASETS_PAGE_STR_FACT);
      deleteDatasetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteDatasetOperationSettings = OperationCallSettings.newBuilder();
      importDataSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      importDataOperationSettings = OperationCallSettings.newBuilder();
      exportDataSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      exportDataOperationSettings = OperationCallSettings.newBuilder();
      createDatasetVersionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createDatasetVersionOperationSettings = OperationCallSettings.newBuilder();
      updateDatasetVersionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteDatasetVersionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteDatasetVersionOperationSettings = OperationCallSettings.newBuilder();
      getDatasetVersionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listDatasetVersionsSettings =
          PagedCallSettings.newBuilder(LIST_DATASET_VERSIONS_PAGE_STR_FACT);
      restoreDatasetVersionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      restoreDatasetVersionOperationSettings = OperationCallSettings.newBuilder();
      listDataItemsSettings = PagedCallSettings.newBuilder(LIST_DATA_ITEMS_PAGE_STR_FACT);
      searchDataItemsSettings = PagedCallSettings.newBuilder(SEARCH_DATA_ITEMS_PAGE_STR_FACT);
      listSavedQueriesSettings = PagedCallSettings.newBuilder(LIST_SAVED_QUERIES_PAGE_STR_FACT);
      deleteSavedQuerySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteSavedQueryOperationSettings = OperationCallSettings.newBuilder();
      getAnnotationSpecSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listAnnotationsSettings = PagedCallSettings.newBuilder(LIST_ANNOTATIONS_PAGE_STR_FACT);
      assessDataSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      assessDataOperationSettings = OperationCallSettings.newBuilder();
      assembleDataSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      assembleDataOperationSettings = OperationCallSettings.newBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createDatasetSettings,
              getDatasetSettings,
              updateDatasetSettings,
              listDatasetsSettings,
              deleteDatasetSettings,
              importDataSettings,
              exportDataSettings,
              createDatasetVersionSettings,
              updateDatasetVersionSettings,
              deleteDatasetVersionSettings,
              getDatasetVersionSettings,
              listDatasetVersionsSettings,
              restoreDatasetVersionSettings,
              listDataItemsSettings,
              searchDataItemsSettings,
              listSavedQueriesSettings,
              deleteSavedQuerySettings,
              getAnnotationSpecSettings,
              listAnnotationsSettings,
              assessDataSettings,
              assembleDataSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(DatasetServiceStubSettings settings) {
      super(settings);

      createDatasetSettings = settings.createDatasetSettings.toBuilder();
      createDatasetOperationSettings = settings.createDatasetOperationSettings.toBuilder();
      getDatasetSettings = settings.getDatasetSettings.toBuilder();
      updateDatasetSettings = settings.updateDatasetSettings.toBuilder();
      listDatasetsSettings = settings.listDatasetsSettings.toBuilder();
      deleteDatasetSettings = settings.deleteDatasetSettings.toBuilder();
      deleteDatasetOperationSettings = settings.deleteDatasetOperationSettings.toBuilder();
      importDataSettings = settings.importDataSettings.toBuilder();
      importDataOperationSettings = settings.importDataOperationSettings.toBuilder();
      exportDataSettings = settings.exportDataSettings.toBuilder();
      exportDataOperationSettings = settings.exportDataOperationSettings.toBuilder();
      createDatasetVersionSettings = settings.createDatasetVersionSettings.toBuilder();
      createDatasetVersionOperationSettings =
          settings.createDatasetVersionOperationSettings.toBuilder();
      updateDatasetVersionSettings = settings.updateDatasetVersionSettings.toBuilder();
      deleteDatasetVersionSettings = settings.deleteDatasetVersionSettings.toBuilder();
      deleteDatasetVersionOperationSettings =
          settings.deleteDatasetVersionOperationSettings.toBuilder();
      getDatasetVersionSettings = settings.getDatasetVersionSettings.toBuilder();
      listDatasetVersionsSettings = settings.listDatasetVersionsSettings.toBuilder();
      restoreDatasetVersionSettings = settings.restoreDatasetVersionSettings.toBuilder();
      restoreDatasetVersionOperationSettings =
          settings.restoreDatasetVersionOperationSettings.toBuilder();
      listDataItemsSettings = settings.listDataItemsSettings.toBuilder();
      searchDataItemsSettings = settings.searchDataItemsSettings.toBuilder();
      listSavedQueriesSettings = settings.listSavedQueriesSettings.toBuilder();
      deleteSavedQuerySettings = settings.deleteSavedQuerySettings.toBuilder();
      deleteSavedQueryOperationSettings = settings.deleteSavedQueryOperationSettings.toBuilder();
      getAnnotationSpecSettings = settings.getAnnotationSpecSettings.toBuilder();
      listAnnotationsSettings = settings.listAnnotationsSettings.toBuilder();
      assessDataSettings = settings.assessDataSettings.toBuilder();
      assessDataOperationSettings = settings.assessDataOperationSettings.toBuilder();
      assembleDataSettings = settings.assembleDataSettings.toBuilder();
      assembleDataOperationSettings = settings.assembleDataOperationSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createDatasetSettings,
              getDatasetSettings,
              updateDatasetSettings,
              listDatasetsSettings,
              deleteDatasetSettings,
              importDataSettings,
              exportDataSettings,
              createDatasetVersionSettings,
              updateDatasetVersionSettings,
              deleteDatasetVersionSettings,
              getDatasetVersionSettings,
              listDatasetVersionsSettings,
              restoreDatasetVersionSettings,
              listDataItemsSettings,
              searchDataItemsSettings,
              listSavedQueriesSettings,
              deleteSavedQuerySettings,
              getAnnotationSpecSettings,
              listAnnotationsSettings,
              assessDataSettings,
              assembleDataSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
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

    private static Builder initDefaults(Builder builder) {
      builder
          .createDatasetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getDatasetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateDatasetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listDatasetsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteDatasetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .importDataSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .exportDataSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createDatasetVersionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateDatasetVersionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteDatasetVersionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getDatasetVersionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listDatasetVersionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .restoreDatasetVersionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listDataItemsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .searchDataItemsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listSavedQueriesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteSavedQuerySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getAnnotationSpecSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listAnnotationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .assessDataSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .assembleDataSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getLocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .testIamPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createDatasetOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateDatasetRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Dataset.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  CreateDatasetOperationMetadata.class))
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
          .deleteDatasetOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteDatasetRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(DeleteOperationMetadata.class))
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
          .importDataOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<ImportDataRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ImportDataResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  ImportDataOperationMetadata.class))
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
          .exportDataOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<ExportDataRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ExportDataResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  ExportDataOperationMetadata.class))
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
          .createDatasetVersionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateDatasetVersionRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(DatasetVersion.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  CreateDatasetVersionOperationMetadata.class))
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
          .deleteDatasetVersionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteDatasetVersionRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(DeleteOperationMetadata.class))
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
          .restoreDatasetVersionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<RestoreDatasetVersionRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(DatasetVersion.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  RestoreDatasetVersionOperationMetadata.class))
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
          .deleteSavedQueryOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteSavedQueryRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(DeleteOperationMetadata.class))
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
          .assessDataOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<AssessDataRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(AssessDataResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  AssessDataOperationMetadata.class))
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
          .assembleDataOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<AssembleDataRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(AssembleDataResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  AssembleDataOperationMetadata.class))
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

    /** Returns the builder for the settings used for calls to createDataset. */
    public UnaryCallSettings.Builder<CreateDatasetRequest, Operation> createDatasetSettings() {
      return createDatasetSettings;
    }

    /** Returns the builder for the settings used for calls to createDataset. */
    public OperationCallSettings.Builder<
            CreateDatasetRequest, Dataset, CreateDatasetOperationMetadata>
        createDatasetOperationSettings() {
      return createDatasetOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getDataset. */
    public UnaryCallSettings.Builder<GetDatasetRequest, Dataset> getDatasetSettings() {
      return getDatasetSettings;
    }

    /** Returns the builder for the settings used for calls to updateDataset. */
    public UnaryCallSettings.Builder<UpdateDatasetRequest, Dataset> updateDatasetSettings() {
      return updateDatasetSettings;
    }

    /** Returns the builder for the settings used for calls to listDatasets. */
    public PagedCallSettings.Builder<
            ListDatasetsRequest, ListDatasetsResponse, ListDatasetsPagedResponse>
        listDatasetsSettings() {
      return listDatasetsSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDataset. */
    public UnaryCallSettings.Builder<DeleteDatasetRequest, Operation> deleteDatasetSettings() {
      return deleteDatasetSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDataset. */
    public OperationCallSettings.Builder<DeleteDatasetRequest, Empty, DeleteOperationMetadata>
        deleteDatasetOperationSettings() {
      return deleteDatasetOperationSettings;
    }

    /** Returns the builder for the settings used for calls to importData. */
    public UnaryCallSettings.Builder<ImportDataRequest, Operation> importDataSettings() {
      return importDataSettings;
    }

    /** Returns the builder for the settings used for calls to importData. */
    public OperationCallSettings.Builder<
            ImportDataRequest, ImportDataResponse, ImportDataOperationMetadata>
        importDataOperationSettings() {
      return importDataOperationSettings;
    }

    /** Returns the builder for the settings used for calls to exportData. */
    public UnaryCallSettings.Builder<ExportDataRequest, Operation> exportDataSettings() {
      return exportDataSettings;
    }

    /** Returns the builder for the settings used for calls to exportData. */
    public OperationCallSettings.Builder<
            ExportDataRequest, ExportDataResponse, ExportDataOperationMetadata>
        exportDataOperationSettings() {
      return exportDataOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createDatasetVersion. */
    public UnaryCallSettings.Builder<CreateDatasetVersionRequest, Operation>
        createDatasetVersionSettings() {
      return createDatasetVersionSettings;
    }

    /** Returns the builder for the settings used for calls to createDatasetVersion. */
    public OperationCallSettings.Builder<
            CreateDatasetVersionRequest, DatasetVersion, CreateDatasetVersionOperationMetadata>
        createDatasetVersionOperationSettings() {
      return createDatasetVersionOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateDatasetVersion. */
    public UnaryCallSettings.Builder<UpdateDatasetVersionRequest, DatasetVersion>
        updateDatasetVersionSettings() {
      return updateDatasetVersionSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDatasetVersion. */
    public UnaryCallSettings.Builder<DeleteDatasetVersionRequest, Operation>
        deleteDatasetVersionSettings() {
      return deleteDatasetVersionSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDatasetVersion. */
    public OperationCallSettings.Builder<
            DeleteDatasetVersionRequest, Empty, DeleteOperationMetadata>
        deleteDatasetVersionOperationSettings() {
      return deleteDatasetVersionOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getDatasetVersion. */
    public UnaryCallSettings.Builder<GetDatasetVersionRequest, DatasetVersion>
        getDatasetVersionSettings() {
      return getDatasetVersionSettings;
    }

    /** Returns the builder for the settings used for calls to listDatasetVersions. */
    public PagedCallSettings.Builder<
            ListDatasetVersionsRequest,
            ListDatasetVersionsResponse,
            ListDatasetVersionsPagedResponse>
        listDatasetVersionsSettings() {
      return listDatasetVersionsSettings;
    }

    /** Returns the builder for the settings used for calls to restoreDatasetVersion. */
    public UnaryCallSettings.Builder<RestoreDatasetVersionRequest, Operation>
        restoreDatasetVersionSettings() {
      return restoreDatasetVersionSettings;
    }

    /** Returns the builder for the settings used for calls to restoreDatasetVersion. */
    public OperationCallSettings.Builder<
            RestoreDatasetVersionRequest, DatasetVersion, RestoreDatasetVersionOperationMetadata>
        restoreDatasetVersionOperationSettings() {
      return restoreDatasetVersionOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listDataItems. */
    public PagedCallSettings.Builder<
            ListDataItemsRequest, ListDataItemsResponse, ListDataItemsPagedResponse>
        listDataItemsSettings() {
      return listDataItemsSettings;
    }

    /** Returns the builder for the settings used for calls to searchDataItems. */
    public PagedCallSettings.Builder<
            SearchDataItemsRequest, SearchDataItemsResponse, SearchDataItemsPagedResponse>
        searchDataItemsSettings() {
      return searchDataItemsSettings;
    }

    /** Returns the builder for the settings used for calls to listSavedQueries. */
    public PagedCallSettings.Builder<
            ListSavedQueriesRequest, ListSavedQueriesResponse, ListSavedQueriesPagedResponse>
        listSavedQueriesSettings() {
      return listSavedQueriesSettings;
    }

    /** Returns the builder for the settings used for calls to deleteSavedQuery. */
    public UnaryCallSettings.Builder<DeleteSavedQueryRequest, Operation>
        deleteSavedQuerySettings() {
      return deleteSavedQuerySettings;
    }

    /** Returns the builder for the settings used for calls to deleteSavedQuery. */
    public OperationCallSettings.Builder<DeleteSavedQueryRequest, Empty, DeleteOperationMetadata>
        deleteSavedQueryOperationSettings() {
      return deleteSavedQueryOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getAnnotationSpec. */
    public UnaryCallSettings.Builder<GetAnnotationSpecRequest, AnnotationSpec>
        getAnnotationSpecSettings() {
      return getAnnotationSpecSettings;
    }

    /** Returns the builder for the settings used for calls to listAnnotations. */
    public PagedCallSettings.Builder<
            ListAnnotationsRequest, ListAnnotationsResponse, ListAnnotationsPagedResponse>
        listAnnotationsSettings() {
      return listAnnotationsSettings;
    }

    /** Returns the builder for the settings used for calls to assessData. */
    public UnaryCallSettings.Builder<AssessDataRequest, Operation> assessDataSettings() {
      return assessDataSettings;
    }

    /** Returns the builder for the settings used for calls to assessData. */
    public OperationCallSettings.Builder<
            AssessDataRequest, AssessDataResponse, AssessDataOperationMetadata>
        assessDataOperationSettings() {
      return assessDataOperationSettings;
    }

    /** Returns the builder for the settings used for calls to assembleData. */
    public UnaryCallSettings.Builder<AssembleDataRequest, Operation> assembleDataSettings() {
      return assembleDataSettings;
    }

    /** Returns the builder for the settings used for calls to assembleData. */
    public OperationCallSettings.Builder<
            AssembleDataRequest, AssembleDataResponse, AssembleDataOperationMetadata>
        assembleDataOperationSettings() {
      return assembleDataOperationSettings;
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

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return setIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return testIamPermissionsSettings;
    }

    @Override
    public DatasetServiceStubSettings build() throws IOException {
      return new DatasetServiceStubSettings(this);
    }
  }
}
