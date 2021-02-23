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

package com.google.cloud.aiplatform.v1.stub;

import static com.google.cloud.aiplatform.v1.JobServiceClient.ListBatchPredictionJobsPagedResponse;
import static com.google.cloud.aiplatform.v1.JobServiceClient.ListCustomJobsPagedResponse;
import static com.google.cloud.aiplatform.v1.JobServiceClient.ListDataLabelingJobsPagedResponse;
import static com.google.cloud.aiplatform.v1.JobServiceClient.ListHyperparameterTuningJobsPagedResponse;

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
import com.google.cloud.aiplatform.v1.BatchPredictionJob;
import com.google.cloud.aiplatform.v1.CancelBatchPredictionJobRequest;
import com.google.cloud.aiplatform.v1.CancelCustomJobRequest;
import com.google.cloud.aiplatform.v1.CancelDataLabelingJobRequest;
import com.google.cloud.aiplatform.v1.CancelHyperparameterTuningJobRequest;
import com.google.cloud.aiplatform.v1.CreateBatchPredictionJobRequest;
import com.google.cloud.aiplatform.v1.CreateCustomJobRequest;
import com.google.cloud.aiplatform.v1.CreateDataLabelingJobRequest;
import com.google.cloud.aiplatform.v1.CreateHyperparameterTuningJobRequest;
import com.google.cloud.aiplatform.v1.CustomJob;
import com.google.cloud.aiplatform.v1.DataLabelingJob;
import com.google.cloud.aiplatform.v1.DeleteBatchPredictionJobRequest;
import com.google.cloud.aiplatform.v1.DeleteCustomJobRequest;
import com.google.cloud.aiplatform.v1.DeleteDataLabelingJobRequest;
import com.google.cloud.aiplatform.v1.DeleteHyperparameterTuningJobRequest;
import com.google.cloud.aiplatform.v1.DeleteOperationMetadata;
import com.google.cloud.aiplatform.v1.GetBatchPredictionJobRequest;
import com.google.cloud.aiplatform.v1.GetCustomJobRequest;
import com.google.cloud.aiplatform.v1.GetDataLabelingJobRequest;
import com.google.cloud.aiplatform.v1.GetHyperparameterTuningJobRequest;
import com.google.cloud.aiplatform.v1.HyperparameterTuningJob;
import com.google.cloud.aiplatform.v1.ListBatchPredictionJobsRequest;
import com.google.cloud.aiplatform.v1.ListBatchPredictionJobsResponse;
import com.google.cloud.aiplatform.v1.ListCustomJobsRequest;
import com.google.cloud.aiplatform.v1.ListCustomJobsResponse;
import com.google.cloud.aiplatform.v1.ListDataLabelingJobsRequest;
import com.google.cloud.aiplatform.v1.ListDataLabelingJobsResponse;
import com.google.cloud.aiplatform.v1.ListHyperparameterTuningJobsRequest;
import com.google.cloud.aiplatform.v1.ListHyperparameterTuningJobsResponse;
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
 * Settings class to configure an instance of {@link JobServiceStub}.
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
 * JobServiceStubSettings.Builder jobServiceSettingsBuilder = JobServiceStubSettings.newBuilder();
 * jobServiceSettingsBuilder
 *     .createCustomJobSettings()
 *     .setRetrySettings(
 *         jobServiceSettingsBuilder
 *             .createCustomJobSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * JobServiceStubSettings jobServiceSettings = jobServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class JobServiceStubSettings extends StubSettings<JobServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateCustomJobRequest, CustomJob> createCustomJobSettings;
  private final UnaryCallSettings<GetCustomJobRequest, CustomJob> getCustomJobSettings;
  private final PagedCallSettings<
          ListCustomJobsRequest, ListCustomJobsResponse, ListCustomJobsPagedResponse>
      listCustomJobsSettings;
  private final UnaryCallSettings<DeleteCustomJobRequest, Operation> deleteCustomJobSettings;
  private final OperationCallSettings<DeleteCustomJobRequest, Empty, DeleteOperationMetadata>
      deleteCustomJobOperationSettings;
  private final UnaryCallSettings<CancelCustomJobRequest, Empty> cancelCustomJobSettings;
  private final UnaryCallSettings<CreateDataLabelingJobRequest, DataLabelingJob>
      createDataLabelingJobSettings;
  private final UnaryCallSettings<GetDataLabelingJobRequest, DataLabelingJob>
      getDataLabelingJobSettings;
  private final PagedCallSettings<
          ListDataLabelingJobsRequest,
          ListDataLabelingJobsResponse,
          ListDataLabelingJobsPagedResponse>
      listDataLabelingJobsSettings;
  private final UnaryCallSettings<DeleteDataLabelingJobRequest, Operation>
      deleteDataLabelingJobSettings;
  private final OperationCallSettings<DeleteDataLabelingJobRequest, Empty, DeleteOperationMetadata>
      deleteDataLabelingJobOperationSettings;
  private final UnaryCallSettings<CancelDataLabelingJobRequest, Empty>
      cancelDataLabelingJobSettings;
  private final UnaryCallSettings<CreateHyperparameterTuningJobRequest, HyperparameterTuningJob>
      createHyperparameterTuningJobSettings;
  private final UnaryCallSettings<GetHyperparameterTuningJobRequest, HyperparameterTuningJob>
      getHyperparameterTuningJobSettings;
  private final PagedCallSettings<
          ListHyperparameterTuningJobsRequest,
          ListHyperparameterTuningJobsResponse,
          ListHyperparameterTuningJobsPagedResponse>
      listHyperparameterTuningJobsSettings;
  private final UnaryCallSettings<DeleteHyperparameterTuningJobRequest, Operation>
      deleteHyperparameterTuningJobSettings;
  private final OperationCallSettings<
          DeleteHyperparameterTuningJobRequest, Empty, DeleteOperationMetadata>
      deleteHyperparameterTuningJobOperationSettings;
  private final UnaryCallSettings<CancelHyperparameterTuningJobRequest, Empty>
      cancelHyperparameterTuningJobSettings;
  private final UnaryCallSettings<CreateBatchPredictionJobRequest, BatchPredictionJob>
      createBatchPredictionJobSettings;
  private final UnaryCallSettings<GetBatchPredictionJobRequest, BatchPredictionJob>
      getBatchPredictionJobSettings;
  private final PagedCallSettings<
          ListBatchPredictionJobsRequest,
          ListBatchPredictionJobsResponse,
          ListBatchPredictionJobsPagedResponse>
      listBatchPredictionJobsSettings;
  private final UnaryCallSettings<DeleteBatchPredictionJobRequest, Operation>
      deleteBatchPredictionJobSettings;
  private final OperationCallSettings<
          DeleteBatchPredictionJobRequest, Empty, DeleteOperationMetadata>
      deleteBatchPredictionJobOperationSettings;
  private final UnaryCallSettings<CancelBatchPredictionJobRequest, Empty>
      cancelBatchPredictionJobSettings;

  private static final PagedListDescriptor<ListCustomJobsRequest, ListCustomJobsResponse, CustomJob>
      LIST_CUSTOM_JOBS_PAGE_STR_DESC =
          new PagedListDescriptor<ListCustomJobsRequest, ListCustomJobsResponse, CustomJob>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListCustomJobsRequest injectToken(ListCustomJobsRequest payload, String token) {
              return ListCustomJobsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListCustomJobsRequest injectPageSize(
                ListCustomJobsRequest payload, int pageSize) {
              return ListCustomJobsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListCustomJobsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListCustomJobsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<CustomJob> extractResources(ListCustomJobsResponse payload) {
              return payload.getCustomJobsList() == null
                  ? ImmutableList.<CustomJob>of()
                  : payload.getCustomJobsList();
            }
          };

  private static final PagedListDescriptor<
          ListDataLabelingJobsRequest, ListDataLabelingJobsResponse, DataLabelingJob>
      LIST_DATA_LABELING_JOBS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListDataLabelingJobsRequest, ListDataLabelingJobsResponse, DataLabelingJob>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDataLabelingJobsRequest injectToken(
                ListDataLabelingJobsRequest payload, String token) {
              return ListDataLabelingJobsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDataLabelingJobsRequest injectPageSize(
                ListDataLabelingJobsRequest payload, int pageSize) {
              return ListDataLabelingJobsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListDataLabelingJobsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDataLabelingJobsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DataLabelingJob> extractResources(
                ListDataLabelingJobsResponse payload) {
              return payload.getDataLabelingJobsList() == null
                  ? ImmutableList.<DataLabelingJob>of()
                  : payload.getDataLabelingJobsList();
            }
          };

  private static final PagedListDescriptor<
          ListHyperparameterTuningJobsRequest,
          ListHyperparameterTuningJobsResponse,
          HyperparameterTuningJob>
      LIST_HYPERPARAMETER_TUNING_JOBS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListHyperparameterTuningJobsRequest,
              ListHyperparameterTuningJobsResponse,
              HyperparameterTuningJob>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListHyperparameterTuningJobsRequest injectToken(
                ListHyperparameterTuningJobsRequest payload, String token) {
              return ListHyperparameterTuningJobsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListHyperparameterTuningJobsRequest injectPageSize(
                ListHyperparameterTuningJobsRequest payload, int pageSize) {
              return ListHyperparameterTuningJobsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListHyperparameterTuningJobsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListHyperparameterTuningJobsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<HyperparameterTuningJob> extractResources(
                ListHyperparameterTuningJobsResponse payload) {
              return payload.getHyperparameterTuningJobsList() == null
                  ? ImmutableList.<HyperparameterTuningJob>of()
                  : payload.getHyperparameterTuningJobsList();
            }
          };

  private static final PagedListDescriptor<
          ListBatchPredictionJobsRequest, ListBatchPredictionJobsResponse, BatchPredictionJob>
      LIST_BATCH_PREDICTION_JOBS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListBatchPredictionJobsRequest,
              ListBatchPredictionJobsResponse,
              BatchPredictionJob>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListBatchPredictionJobsRequest injectToken(
                ListBatchPredictionJobsRequest payload, String token) {
              return ListBatchPredictionJobsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListBatchPredictionJobsRequest injectPageSize(
                ListBatchPredictionJobsRequest payload, int pageSize) {
              return ListBatchPredictionJobsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListBatchPredictionJobsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListBatchPredictionJobsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<BatchPredictionJob> extractResources(
                ListBatchPredictionJobsResponse payload) {
              return payload.getBatchPredictionJobsList() == null
                  ? ImmutableList.<BatchPredictionJob>of()
                  : payload.getBatchPredictionJobsList();
            }
          };

  private static final PagedListResponseFactory<
          ListCustomJobsRequest, ListCustomJobsResponse, ListCustomJobsPagedResponse>
      LIST_CUSTOM_JOBS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListCustomJobsRequest, ListCustomJobsResponse, ListCustomJobsPagedResponse>() {
            @Override
            public ApiFuture<ListCustomJobsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListCustomJobsRequest, ListCustomJobsResponse> callable,
                ListCustomJobsRequest request,
                ApiCallContext context,
                ApiFuture<ListCustomJobsResponse> futureResponse) {
              PageContext<ListCustomJobsRequest, ListCustomJobsResponse, CustomJob> pageContext =
                  PageContext.create(callable, LIST_CUSTOM_JOBS_PAGE_STR_DESC, request, context);
              return ListCustomJobsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListDataLabelingJobsRequest,
          ListDataLabelingJobsResponse,
          ListDataLabelingJobsPagedResponse>
      LIST_DATA_LABELING_JOBS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDataLabelingJobsRequest,
              ListDataLabelingJobsResponse,
              ListDataLabelingJobsPagedResponse>() {
            @Override
            public ApiFuture<ListDataLabelingJobsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDataLabelingJobsRequest, ListDataLabelingJobsResponse> callable,
                ListDataLabelingJobsRequest request,
                ApiCallContext context,
                ApiFuture<ListDataLabelingJobsResponse> futureResponse) {
              PageContext<
                      ListDataLabelingJobsRequest, ListDataLabelingJobsResponse, DataLabelingJob>
                  pageContext =
                      PageContext.create(
                          callable, LIST_DATA_LABELING_JOBS_PAGE_STR_DESC, request, context);
              return ListDataLabelingJobsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListHyperparameterTuningJobsRequest,
          ListHyperparameterTuningJobsResponse,
          ListHyperparameterTuningJobsPagedResponse>
      LIST_HYPERPARAMETER_TUNING_JOBS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListHyperparameterTuningJobsRequest,
              ListHyperparameterTuningJobsResponse,
              ListHyperparameterTuningJobsPagedResponse>() {
            @Override
            public ApiFuture<ListHyperparameterTuningJobsPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        ListHyperparameterTuningJobsRequest, ListHyperparameterTuningJobsResponse>
                    callable,
                ListHyperparameterTuningJobsRequest request,
                ApiCallContext context,
                ApiFuture<ListHyperparameterTuningJobsResponse> futureResponse) {
              PageContext<
                      ListHyperparameterTuningJobsRequest,
                      ListHyperparameterTuningJobsResponse,
                      HyperparameterTuningJob>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_HYPERPARAMETER_TUNING_JOBS_PAGE_STR_DESC,
                          request,
                          context);
              return ListHyperparameterTuningJobsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListBatchPredictionJobsRequest,
          ListBatchPredictionJobsResponse,
          ListBatchPredictionJobsPagedResponse>
      LIST_BATCH_PREDICTION_JOBS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListBatchPredictionJobsRequest,
              ListBatchPredictionJobsResponse,
              ListBatchPredictionJobsPagedResponse>() {
            @Override
            public ApiFuture<ListBatchPredictionJobsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListBatchPredictionJobsRequest, ListBatchPredictionJobsResponse>
                    callable,
                ListBatchPredictionJobsRequest request,
                ApiCallContext context,
                ApiFuture<ListBatchPredictionJobsResponse> futureResponse) {
              PageContext<
                      ListBatchPredictionJobsRequest,
                      ListBatchPredictionJobsResponse,
                      BatchPredictionJob>
                  pageContext =
                      PageContext.create(
                          callable, LIST_BATCH_PREDICTION_JOBS_PAGE_STR_DESC, request, context);
              return ListBatchPredictionJobsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createCustomJob. */
  public UnaryCallSettings<CreateCustomJobRequest, CustomJob> createCustomJobSettings() {
    return createCustomJobSettings;
  }

  /** Returns the object with the settings used for calls to getCustomJob. */
  public UnaryCallSettings<GetCustomJobRequest, CustomJob> getCustomJobSettings() {
    return getCustomJobSettings;
  }

  /** Returns the object with the settings used for calls to listCustomJobs. */
  public PagedCallSettings<
          ListCustomJobsRequest, ListCustomJobsResponse, ListCustomJobsPagedResponse>
      listCustomJobsSettings() {
    return listCustomJobsSettings;
  }

  /** Returns the object with the settings used for calls to deleteCustomJob. */
  public UnaryCallSettings<DeleteCustomJobRequest, Operation> deleteCustomJobSettings() {
    return deleteCustomJobSettings;
  }

  /** Returns the object with the settings used for calls to deleteCustomJob. */
  public OperationCallSettings<DeleteCustomJobRequest, Empty, DeleteOperationMetadata>
      deleteCustomJobOperationSettings() {
    return deleteCustomJobOperationSettings;
  }

  /** Returns the object with the settings used for calls to cancelCustomJob. */
  public UnaryCallSettings<CancelCustomJobRequest, Empty> cancelCustomJobSettings() {
    return cancelCustomJobSettings;
  }

  /** Returns the object with the settings used for calls to createDataLabelingJob. */
  public UnaryCallSettings<CreateDataLabelingJobRequest, DataLabelingJob>
      createDataLabelingJobSettings() {
    return createDataLabelingJobSettings;
  }

  /** Returns the object with the settings used for calls to getDataLabelingJob. */
  public UnaryCallSettings<GetDataLabelingJobRequest, DataLabelingJob>
      getDataLabelingJobSettings() {
    return getDataLabelingJobSettings;
  }

  /** Returns the object with the settings used for calls to listDataLabelingJobs. */
  public PagedCallSettings<
          ListDataLabelingJobsRequest,
          ListDataLabelingJobsResponse,
          ListDataLabelingJobsPagedResponse>
      listDataLabelingJobsSettings() {
    return listDataLabelingJobsSettings;
  }

  /** Returns the object with the settings used for calls to deleteDataLabelingJob. */
  public UnaryCallSettings<DeleteDataLabelingJobRequest, Operation>
      deleteDataLabelingJobSettings() {
    return deleteDataLabelingJobSettings;
  }

  /** Returns the object with the settings used for calls to deleteDataLabelingJob. */
  public OperationCallSettings<DeleteDataLabelingJobRequest, Empty, DeleteOperationMetadata>
      deleteDataLabelingJobOperationSettings() {
    return deleteDataLabelingJobOperationSettings;
  }

  /** Returns the object with the settings used for calls to cancelDataLabelingJob. */
  public UnaryCallSettings<CancelDataLabelingJobRequest, Empty> cancelDataLabelingJobSettings() {
    return cancelDataLabelingJobSettings;
  }

  /** Returns the object with the settings used for calls to createHyperparameterTuningJob. */
  public UnaryCallSettings<CreateHyperparameterTuningJobRequest, HyperparameterTuningJob>
      createHyperparameterTuningJobSettings() {
    return createHyperparameterTuningJobSettings;
  }

  /** Returns the object with the settings used for calls to getHyperparameterTuningJob. */
  public UnaryCallSettings<GetHyperparameterTuningJobRequest, HyperparameterTuningJob>
      getHyperparameterTuningJobSettings() {
    return getHyperparameterTuningJobSettings;
  }

  /** Returns the object with the settings used for calls to listHyperparameterTuningJobs. */
  public PagedCallSettings<
          ListHyperparameterTuningJobsRequest,
          ListHyperparameterTuningJobsResponse,
          ListHyperparameterTuningJobsPagedResponse>
      listHyperparameterTuningJobsSettings() {
    return listHyperparameterTuningJobsSettings;
  }

  /** Returns the object with the settings used for calls to deleteHyperparameterTuningJob. */
  public UnaryCallSettings<DeleteHyperparameterTuningJobRequest, Operation>
      deleteHyperparameterTuningJobSettings() {
    return deleteHyperparameterTuningJobSettings;
  }

  /** Returns the object with the settings used for calls to deleteHyperparameterTuningJob. */
  public OperationCallSettings<DeleteHyperparameterTuningJobRequest, Empty, DeleteOperationMetadata>
      deleteHyperparameterTuningJobOperationSettings() {
    return deleteHyperparameterTuningJobOperationSettings;
  }

  /** Returns the object with the settings used for calls to cancelHyperparameterTuningJob. */
  public UnaryCallSettings<CancelHyperparameterTuningJobRequest, Empty>
      cancelHyperparameterTuningJobSettings() {
    return cancelHyperparameterTuningJobSettings;
  }

  /** Returns the object with the settings used for calls to createBatchPredictionJob. */
  public UnaryCallSettings<CreateBatchPredictionJobRequest, BatchPredictionJob>
      createBatchPredictionJobSettings() {
    return createBatchPredictionJobSettings;
  }

  /** Returns the object with the settings used for calls to getBatchPredictionJob. */
  public UnaryCallSettings<GetBatchPredictionJobRequest, BatchPredictionJob>
      getBatchPredictionJobSettings() {
    return getBatchPredictionJobSettings;
  }

  /** Returns the object with the settings used for calls to listBatchPredictionJobs. */
  public PagedCallSettings<
          ListBatchPredictionJobsRequest,
          ListBatchPredictionJobsResponse,
          ListBatchPredictionJobsPagedResponse>
      listBatchPredictionJobsSettings() {
    return listBatchPredictionJobsSettings;
  }

  /** Returns the object with the settings used for calls to deleteBatchPredictionJob. */
  public UnaryCallSettings<DeleteBatchPredictionJobRequest, Operation>
      deleteBatchPredictionJobSettings() {
    return deleteBatchPredictionJobSettings;
  }

  /** Returns the object with the settings used for calls to deleteBatchPredictionJob. */
  public OperationCallSettings<DeleteBatchPredictionJobRequest, Empty, DeleteOperationMetadata>
      deleteBatchPredictionJobOperationSettings() {
    return deleteBatchPredictionJobOperationSettings;
  }

  /** Returns the object with the settings used for calls to cancelBatchPredictionJob. */
  public UnaryCallSettings<CancelBatchPredictionJobRequest, Empty>
      cancelBatchPredictionJobSettings() {
    return cancelBatchPredictionJobSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public JobServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcJobServiceStub.create(this);
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
    return "aiplatform.googleapis.com:443";
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder().setScopesToApply(DEFAULT_SERVICE_SCOPES);
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
            "gapic", GaxProperties.getLibraryVersion(JobServiceStubSettings.class))
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

  protected JobServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createCustomJobSettings = settingsBuilder.createCustomJobSettings().build();
    getCustomJobSettings = settingsBuilder.getCustomJobSettings().build();
    listCustomJobsSettings = settingsBuilder.listCustomJobsSettings().build();
    deleteCustomJobSettings = settingsBuilder.deleteCustomJobSettings().build();
    deleteCustomJobOperationSettings = settingsBuilder.deleteCustomJobOperationSettings().build();
    cancelCustomJobSettings = settingsBuilder.cancelCustomJobSettings().build();
    createDataLabelingJobSettings = settingsBuilder.createDataLabelingJobSettings().build();
    getDataLabelingJobSettings = settingsBuilder.getDataLabelingJobSettings().build();
    listDataLabelingJobsSettings = settingsBuilder.listDataLabelingJobsSettings().build();
    deleteDataLabelingJobSettings = settingsBuilder.deleteDataLabelingJobSettings().build();
    deleteDataLabelingJobOperationSettings =
        settingsBuilder.deleteDataLabelingJobOperationSettings().build();
    cancelDataLabelingJobSettings = settingsBuilder.cancelDataLabelingJobSettings().build();
    createHyperparameterTuningJobSettings =
        settingsBuilder.createHyperparameterTuningJobSettings().build();
    getHyperparameterTuningJobSettings =
        settingsBuilder.getHyperparameterTuningJobSettings().build();
    listHyperparameterTuningJobsSettings =
        settingsBuilder.listHyperparameterTuningJobsSettings().build();
    deleteHyperparameterTuningJobSettings =
        settingsBuilder.deleteHyperparameterTuningJobSettings().build();
    deleteHyperparameterTuningJobOperationSettings =
        settingsBuilder.deleteHyperparameterTuningJobOperationSettings().build();
    cancelHyperparameterTuningJobSettings =
        settingsBuilder.cancelHyperparameterTuningJobSettings().build();
    createBatchPredictionJobSettings = settingsBuilder.createBatchPredictionJobSettings().build();
    getBatchPredictionJobSettings = settingsBuilder.getBatchPredictionJobSettings().build();
    listBatchPredictionJobsSettings = settingsBuilder.listBatchPredictionJobsSettings().build();
    deleteBatchPredictionJobSettings = settingsBuilder.deleteBatchPredictionJobSettings().build();
    deleteBatchPredictionJobOperationSettings =
        settingsBuilder.deleteBatchPredictionJobOperationSettings().build();
    cancelBatchPredictionJobSettings = settingsBuilder.cancelBatchPredictionJobSettings().build();
  }

  /** Builder for JobServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<JobServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateCustomJobRequest, CustomJob>
        createCustomJobSettings;
    private final UnaryCallSettings.Builder<GetCustomJobRequest, CustomJob> getCustomJobSettings;
    private final PagedCallSettings.Builder<
            ListCustomJobsRequest, ListCustomJobsResponse, ListCustomJobsPagedResponse>
        listCustomJobsSettings;
    private final UnaryCallSettings.Builder<DeleteCustomJobRequest, Operation>
        deleteCustomJobSettings;
    private final OperationCallSettings.Builder<
            DeleteCustomJobRequest, Empty, DeleteOperationMetadata>
        deleteCustomJobOperationSettings;
    private final UnaryCallSettings.Builder<CancelCustomJobRequest, Empty> cancelCustomJobSettings;
    private final UnaryCallSettings.Builder<CreateDataLabelingJobRequest, DataLabelingJob>
        createDataLabelingJobSettings;
    private final UnaryCallSettings.Builder<GetDataLabelingJobRequest, DataLabelingJob>
        getDataLabelingJobSettings;
    private final PagedCallSettings.Builder<
            ListDataLabelingJobsRequest,
            ListDataLabelingJobsResponse,
            ListDataLabelingJobsPagedResponse>
        listDataLabelingJobsSettings;
    private final UnaryCallSettings.Builder<DeleteDataLabelingJobRequest, Operation>
        deleteDataLabelingJobSettings;
    private final OperationCallSettings.Builder<
            DeleteDataLabelingJobRequest, Empty, DeleteOperationMetadata>
        deleteDataLabelingJobOperationSettings;
    private final UnaryCallSettings.Builder<CancelDataLabelingJobRequest, Empty>
        cancelDataLabelingJobSettings;
    private final UnaryCallSettings.Builder<
            CreateHyperparameterTuningJobRequest, HyperparameterTuningJob>
        createHyperparameterTuningJobSettings;
    private final UnaryCallSettings.Builder<
            GetHyperparameterTuningJobRequest, HyperparameterTuningJob>
        getHyperparameterTuningJobSettings;
    private final PagedCallSettings.Builder<
            ListHyperparameterTuningJobsRequest,
            ListHyperparameterTuningJobsResponse,
            ListHyperparameterTuningJobsPagedResponse>
        listHyperparameterTuningJobsSettings;
    private final UnaryCallSettings.Builder<DeleteHyperparameterTuningJobRequest, Operation>
        deleteHyperparameterTuningJobSettings;
    private final OperationCallSettings.Builder<
            DeleteHyperparameterTuningJobRequest, Empty, DeleteOperationMetadata>
        deleteHyperparameterTuningJobOperationSettings;
    private final UnaryCallSettings.Builder<CancelHyperparameterTuningJobRequest, Empty>
        cancelHyperparameterTuningJobSettings;
    private final UnaryCallSettings.Builder<CreateBatchPredictionJobRequest, BatchPredictionJob>
        createBatchPredictionJobSettings;
    private final UnaryCallSettings.Builder<GetBatchPredictionJobRequest, BatchPredictionJob>
        getBatchPredictionJobSettings;
    private final PagedCallSettings.Builder<
            ListBatchPredictionJobsRequest,
            ListBatchPredictionJobsResponse,
            ListBatchPredictionJobsPagedResponse>
        listBatchPredictionJobsSettings;
    private final UnaryCallSettings.Builder<DeleteBatchPredictionJobRequest, Operation>
        deleteBatchPredictionJobSettings;
    private final OperationCallSettings.Builder<
            DeleteBatchPredictionJobRequest, Empty, DeleteOperationMetadata>
        deleteBatchPredictionJobOperationSettings;
    private final UnaryCallSettings.Builder<CancelBatchPredictionJobRequest, Empty>
        cancelBatchPredictionJobSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createCustomJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getCustomJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listCustomJobsSettings = PagedCallSettings.newBuilder(LIST_CUSTOM_JOBS_PAGE_STR_FACT);
      deleteCustomJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteCustomJobOperationSettings = OperationCallSettings.newBuilder();
      cancelCustomJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createDataLabelingJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getDataLabelingJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listDataLabelingJobsSettings =
          PagedCallSettings.newBuilder(LIST_DATA_LABELING_JOBS_PAGE_STR_FACT);
      deleteDataLabelingJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteDataLabelingJobOperationSettings = OperationCallSettings.newBuilder();
      cancelDataLabelingJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createHyperparameterTuningJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getHyperparameterTuningJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listHyperparameterTuningJobsSettings =
          PagedCallSettings.newBuilder(LIST_HYPERPARAMETER_TUNING_JOBS_PAGE_STR_FACT);
      deleteHyperparameterTuningJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteHyperparameterTuningJobOperationSettings = OperationCallSettings.newBuilder();
      cancelHyperparameterTuningJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createBatchPredictionJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getBatchPredictionJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listBatchPredictionJobsSettings =
          PagedCallSettings.newBuilder(LIST_BATCH_PREDICTION_JOBS_PAGE_STR_FACT);
      deleteBatchPredictionJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteBatchPredictionJobOperationSettings = OperationCallSettings.newBuilder();
      cancelBatchPredictionJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createCustomJobSettings,
              getCustomJobSettings,
              listCustomJobsSettings,
              deleteCustomJobSettings,
              cancelCustomJobSettings,
              createDataLabelingJobSettings,
              getDataLabelingJobSettings,
              listDataLabelingJobsSettings,
              deleteDataLabelingJobSettings,
              cancelDataLabelingJobSettings,
              createHyperparameterTuningJobSettings,
              getHyperparameterTuningJobSettings,
              listHyperparameterTuningJobsSettings,
              deleteHyperparameterTuningJobSettings,
              cancelHyperparameterTuningJobSettings,
              createBatchPredictionJobSettings,
              getBatchPredictionJobSettings,
              listBatchPredictionJobsSettings,
              deleteBatchPredictionJobSettings,
              cancelBatchPredictionJobSettings);
      initDefaults(this);
    }

    protected Builder(JobServiceStubSettings settings) {
      super(settings);

      createCustomJobSettings = settings.createCustomJobSettings.toBuilder();
      getCustomJobSettings = settings.getCustomJobSettings.toBuilder();
      listCustomJobsSettings = settings.listCustomJobsSettings.toBuilder();
      deleteCustomJobSettings = settings.deleteCustomJobSettings.toBuilder();
      deleteCustomJobOperationSettings = settings.deleteCustomJobOperationSettings.toBuilder();
      cancelCustomJobSettings = settings.cancelCustomJobSettings.toBuilder();
      createDataLabelingJobSettings = settings.createDataLabelingJobSettings.toBuilder();
      getDataLabelingJobSettings = settings.getDataLabelingJobSettings.toBuilder();
      listDataLabelingJobsSettings = settings.listDataLabelingJobsSettings.toBuilder();
      deleteDataLabelingJobSettings = settings.deleteDataLabelingJobSettings.toBuilder();
      deleteDataLabelingJobOperationSettings =
          settings.deleteDataLabelingJobOperationSettings.toBuilder();
      cancelDataLabelingJobSettings = settings.cancelDataLabelingJobSettings.toBuilder();
      createHyperparameterTuningJobSettings =
          settings.createHyperparameterTuningJobSettings.toBuilder();
      getHyperparameterTuningJobSettings = settings.getHyperparameterTuningJobSettings.toBuilder();
      listHyperparameterTuningJobsSettings =
          settings.listHyperparameterTuningJobsSettings.toBuilder();
      deleteHyperparameterTuningJobSettings =
          settings.deleteHyperparameterTuningJobSettings.toBuilder();
      deleteHyperparameterTuningJobOperationSettings =
          settings.deleteHyperparameterTuningJobOperationSettings.toBuilder();
      cancelHyperparameterTuningJobSettings =
          settings.cancelHyperparameterTuningJobSettings.toBuilder();
      createBatchPredictionJobSettings = settings.createBatchPredictionJobSettings.toBuilder();
      getBatchPredictionJobSettings = settings.getBatchPredictionJobSettings.toBuilder();
      listBatchPredictionJobsSettings = settings.listBatchPredictionJobsSettings.toBuilder();
      deleteBatchPredictionJobSettings = settings.deleteBatchPredictionJobSettings.toBuilder();
      deleteBatchPredictionJobOperationSettings =
          settings.deleteBatchPredictionJobOperationSettings.toBuilder();
      cancelBatchPredictionJobSettings = settings.cancelBatchPredictionJobSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createCustomJobSettings,
              getCustomJobSettings,
              listCustomJobsSettings,
              deleteCustomJobSettings,
              cancelCustomJobSettings,
              createDataLabelingJobSettings,
              getDataLabelingJobSettings,
              listDataLabelingJobsSettings,
              deleteDataLabelingJobSettings,
              cancelDataLabelingJobSettings,
              createHyperparameterTuningJobSettings,
              getHyperparameterTuningJobSettings,
              listHyperparameterTuningJobsSettings,
              deleteHyperparameterTuningJobSettings,
              cancelHyperparameterTuningJobSettings,
              createBatchPredictionJobSettings,
              getBatchPredictionJobSettings,
              listBatchPredictionJobsSettings,
              deleteBatchPredictionJobSettings,
              cancelBatchPredictionJobSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .createCustomJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getCustomJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listCustomJobsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteCustomJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .cancelCustomJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createDataLabelingJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getDataLabelingJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listDataLabelingJobsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteDataLabelingJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .cancelDataLabelingJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createHyperparameterTuningJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getHyperparameterTuningJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listHyperparameterTuningJobsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteHyperparameterTuningJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .cancelHyperparameterTuningJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createBatchPredictionJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getBatchPredictionJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listBatchPredictionJobsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteBatchPredictionJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .cancelBatchPredictionJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteCustomJobOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteCustomJobRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteDataLabelingJobOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteDataLabelingJobRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteHyperparameterTuningJobOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteHyperparameterTuningJobRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
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
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteBatchPredictionJobOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteBatchPredictionJobRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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

    // NEXT_MAJOR_VER: remove 'throws Exception'.
    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) throws Exception {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
    }

    /** Returns the builder for the settings used for calls to createCustomJob. */
    public UnaryCallSettings.Builder<CreateCustomJobRequest, CustomJob> createCustomJobSettings() {
      return createCustomJobSettings;
    }

    /** Returns the builder for the settings used for calls to getCustomJob. */
    public UnaryCallSettings.Builder<GetCustomJobRequest, CustomJob> getCustomJobSettings() {
      return getCustomJobSettings;
    }

    /** Returns the builder for the settings used for calls to listCustomJobs. */
    public PagedCallSettings.Builder<
            ListCustomJobsRequest, ListCustomJobsResponse, ListCustomJobsPagedResponse>
        listCustomJobsSettings() {
      return listCustomJobsSettings;
    }

    /** Returns the builder for the settings used for calls to deleteCustomJob. */
    public UnaryCallSettings.Builder<DeleteCustomJobRequest, Operation> deleteCustomJobSettings() {
      return deleteCustomJobSettings;
    }

    /** Returns the builder for the settings used for calls to deleteCustomJob. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteCustomJobRequest, Empty, DeleteOperationMetadata>
        deleteCustomJobOperationSettings() {
      return deleteCustomJobOperationSettings;
    }

    /** Returns the builder for the settings used for calls to cancelCustomJob. */
    public UnaryCallSettings.Builder<CancelCustomJobRequest, Empty> cancelCustomJobSettings() {
      return cancelCustomJobSettings;
    }

    /** Returns the builder for the settings used for calls to createDataLabelingJob. */
    public UnaryCallSettings.Builder<CreateDataLabelingJobRequest, DataLabelingJob>
        createDataLabelingJobSettings() {
      return createDataLabelingJobSettings;
    }

    /** Returns the builder for the settings used for calls to getDataLabelingJob. */
    public UnaryCallSettings.Builder<GetDataLabelingJobRequest, DataLabelingJob>
        getDataLabelingJobSettings() {
      return getDataLabelingJobSettings;
    }

    /** Returns the builder for the settings used for calls to listDataLabelingJobs. */
    public PagedCallSettings.Builder<
            ListDataLabelingJobsRequest,
            ListDataLabelingJobsResponse,
            ListDataLabelingJobsPagedResponse>
        listDataLabelingJobsSettings() {
      return listDataLabelingJobsSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDataLabelingJob. */
    public UnaryCallSettings.Builder<DeleteDataLabelingJobRequest, Operation>
        deleteDataLabelingJobSettings() {
      return deleteDataLabelingJobSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDataLabelingJob. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            DeleteDataLabelingJobRequest, Empty, DeleteOperationMetadata>
        deleteDataLabelingJobOperationSettings() {
      return deleteDataLabelingJobOperationSettings;
    }

    /** Returns the builder for the settings used for calls to cancelDataLabelingJob. */
    public UnaryCallSettings.Builder<CancelDataLabelingJobRequest, Empty>
        cancelDataLabelingJobSettings() {
      return cancelDataLabelingJobSettings;
    }

    /** Returns the builder for the settings used for calls to createHyperparameterTuningJob. */
    public UnaryCallSettings.Builder<CreateHyperparameterTuningJobRequest, HyperparameterTuningJob>
        createHyperparameterTuningJobSettings() {
      return createHyperparameterTuningJobSettings;
    }

    /** Returns the builder for the settings used for calls to getHyperparameterTuningJob. */
    public UnaryCallSettings.Builder<GetHyperparameterTuningJobRequest, HyperparameterTuningJob>
        getHyperparameterTuningJobSettings() {
      return getHyperparameterTuningJobSettings;
    }

    /** Returns the builder for the settings used for calls to listHyperparameterTuningJobs. */
    public PagedCallSettings.Builder<
            ListHyperparameterTuningJobsRequest,
            ListHyperparameterTuningJobsResponse,
            ListHyperparameterTuningJobsPagedResponse>
        listHyperparameterTuningJobsSettings() {
      return listHyperparameterTuningJobsSettings;
    }

    /** Returns the builder for the settings used for calls to deleteHyperparameterTuningJob. */
    public UnaryCallSettings.Builder<DeleteHyperparameterTuningJobRequest, Operation>
        deleteHyperparameterTuningJobSettings() {
      return deleteHyperparameterTuningJobSettings;
    }

    /** Returns the builder for the settings used for calls to deleteHyperparameterTuningJob. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            DeleteHyperparameterTuningJobRequest, Empty, DeleteOperationMetadata>
        deleteHyperparameterTuningJobOperationSettings() {
      return deleteHyperparameterTuningJobOperationSettings;
    }

    /** Returns the builder for the settings used for calls to cancelHyperparameterTuningJob. */
    public UnaryCallSettings.Builder<CancelHyperparameterTuningJobRequest, Empty>
        cancelHyperparameterTuningJobSettings() {
      return cancelHyperparameterTuningJobSettings;
    }

    /** Returns the builder for the settings used for calls to createBatchPredictionJob. */
    public UnaryCallSettings.Builder<CreateBatchPredictionJobRequest, BatchPredictionJob>
        createBatchPredictionJobSettings() {
      return createBatchPredictionJobSettings;
    }

    /** Returns the builder for the settings used for calls to getBatchPredictionJob. */
    public UnaryCallSettings.Builder<GetBatchPredictionJobRequest, BatchPredictionJob>
        getBatchPredictionJobSettings() {
      return getBatchPredictionJobSettings;
    }

    /** Returns the builder for the settings used for calls to listBatchPredictionJobs. */
    public PagedCallSettings.Builder<
            ListBatchPredictionJobsRequest,
            ListBatchPredictionJobsResponse,
            ListBatchPredictionJobsPagedResponse>
        listBatchPredictionJobsSettings() {
      return listBatchPredictionJobsSettings;
    }

    /** Returns the builder for the settings used for calls to deleteBatchPredictionJob. */
    public UnaryCallSettings.Builder<DeleteBatchPredictionJobRequest, Operation>
        deleteBatchPredictionJobSettings() {
      return deleteBatchPredictionJobSettings;
    }

    /** Returns the builder for the settings used for calls to deleteBatchPredictionJob. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            DeleteBatchPredictionJobRequest, Empty, DeleteOperationMetadata>
        deleteBatchPredictionJobOperationSettings() {
      return deleteBatchPredictionJobOperationSettings;
    }

    /** Returns the builder for the settings used for calls to cancelBatchPredictionJob. */
    public UnaryCallSettings.Builder<CancelBatchPredictionJobRequest, Empty>
        cancelBatchPredictionJobSettings() {
      return cancelBatchPredictionJobSettings;
    }

    @Override
    public JobServiceStubSettings build() throws IOException {
      return new JobServiceStubSettings(this);
    }
  }
}
