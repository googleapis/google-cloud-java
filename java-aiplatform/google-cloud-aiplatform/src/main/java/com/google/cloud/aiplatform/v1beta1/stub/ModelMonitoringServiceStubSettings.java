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

package com.google.cloud.aiplatform.v1beta1.stub;

import static com.google.cloud.aiplatform.v1beta1.ModelMonitoringServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.ModelMonitoringServiceClient.ListModelMonitoringJobsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.ModelMonitoringServiceClient.ListModelMonitorsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.ModelMonitoringServiceClient.SearchModelMonitoringAlertsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.ModelMonitoringServiceClient.SearchModelMonitoringStatsPagedResponse;

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
import com.google.cloud.aiplatform.v1beta1.CreateModelMonitorOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.CreateModelMonitorRequest;
import com.google.cloud.aiplatform.v1beta1.CreateModelMonitoringJobRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteModelMonitorRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteModelMonitoringJobRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.GetModelMonitorRequest;
import com.google.cloud.aiplatform.v1beta1.GetModelMonitoringJobRequest;
import com.google.cloud.aiplatform.v1beta1.ListModelMonitoringJobsRequest;
import com.google.cloud.aiplatform.v1beta1.ListModelMonitoringJobsResponse;
import com.google.cloud.aiplatform.v1beta1.ListModelMonitorsRequest;
import com.google.cloud.aiplatform.v1beta1.ListModelMonitorsResponse;
import com.google.cloud.aiplatform.v1beta1.ModelMonitor;
import com.google.cloud.aiplatform.v1beta1.ModelMonitoringAlert;
import com.google.cloud.aiplatform.v1beta1.ModelMonitoringJob;
import com.google.cloud.aiplatform.v1beta1.ModelMonitoringStats;
import com.google.cloud.aiplatform.v1beta1.SearchModelMonitoringAlertsRequest;
import com.google.cloud.aiplatform.v1beta1.SearchModelMonitoringAlertsResponse;
import com.google.cloud.aiplatform.v1beta1.SearchModelMonitoringStatsRequest;
import com.google.cloud.aiplatform.v1beta1.SearchModelMonitoringStatsResponse;
import com.google.cloud.aiplatform.v1beta1.UpdateModelMonitorOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.UpdateModelMonitorRequest;
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
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ModelMonitoringServiceStub}.
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
 * <p>For example, to set the total timeout of getModelMonitor to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ModelMonitoringServiceStubSettings.Builder modelMonitoringServiceSettingsBuilder =
 *     ModelMonitoringServiceStubSettings.newBuilder();
 * modelMonitoringServiceSettingsBuilder
 *     .getModelMonitorSettings()
 *     .setRetrySettings(
 *         modelMonitoringServiceSettingsBuilder
 *             .getModelMonitorSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ModelMonitoringServiceStubSettings modelMonitoringServiceSettings =
 *     modelMonitoringServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ModelMonitoringServiceStubSettings
    extends StubSettings<ModelMonitoringServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateModelMonitorRequest, Operation> createModelMonitorSettings;
  private final OperationCallSettings<
          CreateModelMonitorRequest, ModelMonitor, CreateModelMonitorOperationMetadata>
      createModelMonitorOperationSettings;
  private final UnaryCallSettings<UpdateModelMonitorRequest, Operation> updateModelMonitorSettings;
  private final OperationCallSettings<
          UpdateModelMonitorRequest, ModelMonitor, UpdateModelMonitorOperationMetadata>
      updateModelMonitorOperationSettings;
  private final UnaryCallSettings<GetModelMonitorRequest, ModelMonitor> getModelMonitorSettings;
  private final PagedCallSettings<
          ListModelMonitorsRequest, ListModelMonitorsResponse, ListModelMonitorsPagedResponse>
      listModelMonitorsSettings;
  private final UnaryCallSettings<DeleteModelMonitorRequest, Operation> deleteModelMonitorSettings;
  private final OperationCallSettings<DeleteModelMonitorRequest, Empty, DeleteOperationMetadata>
      deleteModelMonitorOperationSettings;
  private final UnaryCallSettings<CreateModelMonitoringJobRequest, ModelMonitoringJob>
      createModelMonitoringJobSettings;
  private final UnaryCallSettings<GetModelMonitoringJobRequest, ModelMonitoringJob>
      getModelMonitoringJobSettings;
  private final PagedCallSettings<
          ListModelMonitoringJobsRequest,
          ListModelMonitoringJobsResponse,
          ListModelMonitoringJobsPagedResponse>
      listModelMonitoringJobsSettings;
  private final UnaryCallSettings<DeleteModelMonitoringJobRequest, Operation>
      deleteModelMonitoringJobSettings;
  private final OperationCallSettings<
          DeleteModelMonitoringJobRequest, Empty, DeleteOperationMetadata>
      deleteModelMonitoringJobOperationSettings;
  private final PagedCallSettings<
          SearchModelMonitoringStatsRequest,
          SearchModelMonitoringStatsResponse,
          SearchModelMonitoringStatsPagedResponse>
      searchModelMonitoringStatsSettings;
  private final PagedCallSettings<
          SearchModelMonitoringAlertsRequest,
          SearchModelMonitoringAlertsResponse,
          SearchModelMonitoringAlertsPagedResponse>
      searchModelMonitoringAlertsSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<
          ListModelMonitorsRequest, ListModelMonitorsResponse, ModelMonitor>
      LIST_MODEL_MONITORS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListModelMonitorsRequest, ListModelMonitorsResponse, ModelMonitor>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListModelMonitorsRequest injectToken(
                ListModelMonitorsRequest payload, String token) {
              return ListModelMonitorsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListModelMonitorsRequest injectPageSize(
                ListModelMonitorsRequest payload, int pageSize) {
              return ListModelMonitorsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListModelMonitorsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListModelMonitorsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ModelMonitor> extractResources(ListModelMonitorsResponse payload) {
              return payload.getModelMonitorsList() == null
                  ? ImmutableList.<ModelMonitor>of()
                  : payload.getModelMonitorsList();
            }
          };

  private static final PagedListDescriptor<
          ListModelMonitoringJobsRequest, ListModelMonitoringJobsResponse, ModelMonitoringJob>
      LIST_MODEL_MONITORING_JOBS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListModelMonitoringJobsRequest,
              ListModelMonitoringJobsResponse,
              ModelMonitoringJob>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListModelMonitoringJobsRequest injectToken(
                ListModelMonitoringJobsRequest payload, String token) {
              return ListModelMonitoringJobsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListModelMonitoringJobsRequest injectPageSize(
                ListModelMonitoringJobsRequest payload, int pageSize) {
              return ListModelMonitoringJobsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListModelMonitoringJobsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListModelMonitoringJobsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ModelMonitoringJob> extractResources(
                ListModelMonitoringJobsResponse payload) {
              return payload.getModelMonitoringJobsList() == null
                  ? ImmutableList.<ModelMonitoringJob>of()
                  : payload.getModelMonitoringJobsList();
            }
          };

  private static final PagedListDescriptor<
          SearchModelMonitoringStatsRequest,
          SearchModelMonitoringStatsResponse,
          ModelMonitoringStats>
      SEARCH_MODEL_MONITORING_STATS_PAGE_STR_DESC =
          new PagedListDescriptor<
              SearchModelMonitoringStatsRequest,
              SearchModelMonitoringStatsResponse,
              ModelMonitoringStats>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public SearchModelMonitoringStatsRequest injectToken(
                SearchModelMonitoringStatsRequest payload, String token) {
              return SearchModelMonitoringStatsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public SearchModelMonitoringStatsRequest injectPageSize(
                SearchModelMonitoringStatsRequest payload, int pageSize) {
              return SearchModelMonitoringStatsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(SearchModelMonitoringStatsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(SearchModelMonitoringStatsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ModelMonitoringStats> extractResources(
                SearchModelMonitoringStatsResponse payload) {
              return payload.getMonitoringStatsList() == null
                  ? ImmutableList.<ModelMonitoringStats>of()
                  : payload.getMonitoringStatsList();
            }
          };

  private static final PagedListDescriptor<
          SearchModelMonitoringAlertsRequest,
          SearchModelMonitoringAlertsResponse,
          ModelMonitoringAlert>
      SEARCH_MODEL_MONITORING_ALERTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              SearchModelMonitoringAlertsRequest,
              SearchModelMonitoringAlertsResponse,
              ModelMonitoringAlert>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public SearchModelMonitoringAlertsRequest injectToken(
                SearchModelMonitoringAlertsRequest payload, String token) {
              return SearchModelMonitoringAlertsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public SearchModelMonitoringAlertsRequest injectPageSize(
                SearchModelMonitoringAlertsRequest payload, int pageSize) {
              return SearchModelMonitoringAlertsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(SearchModelMonitoringAlertsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(SearchModelMonitoringAlertsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ModelMonitoringAlert> extractResources(
                SearchModelMonitoringAlertsResponse payload) {
              return payload.getModelMonitoringAlertsList() == null
                  ? ImmutableList.<ModelMonitoringAlert>of()
                  : payload.getModelMonitoringAlertsList();
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
              return payload.getLocationsList() == null
                  ? ImmutableList.<Location>of()
                  : payload.getLocationsList();
            }
          };

  private static final PagedListResponseFactory<
          ListModelMonitorsRequest, ListModelMonitorsResponse, ListModelMonitorsPagedResponse>
      LIST_MODEL_MONITORS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListModelMonitorsRequest,
              ListModelMonitorsResponse,
              ListModelMonitorsPagedResponse>() {
            @Override
            public ApiFuture<ListModelMonitorsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListModelMonitorsRequest, ListModelMonitorsResponse> callable,
                ListModelMonitorsRequest request,
                ApiCallContext context,
                ApiFuture<ListModelMonitorsResponse> futureResponse) {
              PageContext<ListModelMonitorsRequest, ListModelMonitorsResponse, ModelMonitor>
                  pageContext =
                      PageContext.create(
                          callable, LIST_MODEL_MONITORS_PAGE_STR_DESC, request, context);
              return ListModelMonitorsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListModelMonitoringJobsRequest,
          ListModelMonitoringJobsResponse,
          ListModelMonitoringJobsPagedResponse>
      LIST_MODEL_MONITORING_JOBS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListModelMonitoringJobsRequest,
              ListModelMonitoringJobsResponse,
              ListModelMonitoringJobsPagedResponse>() {
            @Override
            public ApiFuture<ListModelMonitoringJobsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListModelMonitoringJobsRequest, ListModelMonitoringJobsResponse>
                    callable,
                ListModelMonitoringJobsRequest request,
                ApiCallContext context,
                ApiFuture<ListModelMonitoringJobsResponse> futureResponse) {
              PageContext<
                      ListModelMonitoringJobsRequest,
                      ListModelMonitoringJobsResponse,
                      ModelMonitoringJob>
                  pageContext =
                      PageContext.create(
                          callable, LIST_MODEL_MONITORING_JOBS_PAGE_STR_DESC, request, context);
              return ListModelMonitoringJobsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          SearchModelMonitoringStatsRequest,
          SearchModelMonitoringStatsResponse,
          SearchModelMonitoringStatsPagedResponse>
      SEARCH_MODEL_MONITORING_STATS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              SearchModelMonitoringStatsRequest,
              SearchModelMonitoringStatsResponse,
              SearchModelMonitoringStatsPagedResponse>() {
            @Override
            public ApiFuture<SearchModelMonitoringStatsPagedResponse> getFuturePagedResponse(
                UnaryCallable<SearchModelMonitoringStatsRequest, SearchModelMonitoringStatsResponse>
                    callable,
                SearchModelMonitoringStatsRequest request,
                ApiCallContext context,
                ApiFuture<SearchModelMonitoringStatsResponse> futureResponse) {
              PageContext<
                      SearchModelMonitoringStatsRequest,
                      SearchModelMonitoringStatsResponse,
                      ModelMonitoringStats>
                  pageContext =
                      PageContext.create(
                          callable, SEARCH_MODEL_MONITORING_STATS_PAGE_STR_DESC, request, context);
              return SearchModelMonitoringStatsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          SearchModelMonitoringAlertsRequest,
          SearchModelMonitoringAlertsResponse,
          SearchModelMonitoringAlertsPagedResponse>
      SEARCH_MODEL_MONITORING_ALERTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              SearchModelMonitoringAlertsRequest,
              SearchModelMonitoringAlertsResponse,
              SearchModelMonitoringAlertsPagedResponse>() {
            @Override
            public ApiFuture<SearchModelMonitoringAlertsPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        SearchModelMonitoringAlertsRequest, SearchModelMonitoringAlertsResponse>
                    callable,
                SearchModelMonitoringAlertsRequest request,
                ApiCallContext context,
                ApiFuture<SearchModelMonitoringAlertsResponse> futureResponse) {
              PageContext<
                      SearchModelMonitoringAlertsRequest,
                      SearchModelMonitoringAlertsResponse,
                      ModelMonitoringAlert>
                  pageContext =
                      PageContext.create(
                          callable, SEARCH_MODEL_MONITORING_ALERTS_PAGE_STR_DESC, request, context);
              return SearchModelMonitoringAlertsPagedResponse.createAsync(
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

  /** Returns the object with the settings used for calls to createModelMonitor. */
  public UnaryCallSettings<CreateModelMonitorRequest, Operation> createModelMonitorSettings() {
    return createModelMonitorSettings;
  }

  /** Returns the object with the settings used for calls to createModelMonitor. */
  public OperationCallSettings<
          CreateModelMonitorRequest, ModelMonitor, CreateModelMonitorOperationMetadata>
      createModelMonitorOperationSettings() {
    return createModelMonitorOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateModelMonitor. */
  public UnaryCallSettings<UpdateModelMonitorRequest, Operation> updateModelMonitorSettings() {
    return updateModelMonitorSettings;
  }

  /** Returns the object with the settings used for calls to updateModelMonitor. */
  public OperationCallSettings<
          UpdateModelMonitorRequest, ModelMonitor, UpdateModelMonitorOperationMetadata>
      updateModelMonitorOperationSettings() {
    return updateModelMonitorOperationSettings;
  }

  /** Returns the object with the settings used for calls to getModelMonitor. */
  public UnaryCallSettings<GetModelMonitorRequest, ModelMonitor> getModelMonitorSettings() {
    return getModelMonitorSettings;
  }

  /** Returns the object with the settings used for calls to listModelMonitors. */
  public PagedCallSettings<
          ListModelMonitorsRequest, ListModelMonitorsResponse, ListModelMonitorsPagedResponse>
      listModelMonitorsSettings() {
    return listModelMonitorsSettings;
  }

  /** Returns the object with the settings used for calls to deleteModelMonitor. */
  public UnaryCallSettings<DeleteModelMonitorRequest, Operation> deleteModelMonitorSettings() {
    return deleteModelMonitorSettings;
  }

  /** Returns the object with the settings used for calls to deleteModelMonitor. */
  public OperationCallSettings<DeleteModelMonitorRequest, Empty, DeleteOperationMetadata>
      deleteModelMonitorOperationSettings() {
    return deleteModelMonitorOperationSettings;
  }

  /** Returns the object with the settings used for calls to createModelMonitoringJob. */
  public UnaryCallSettings<CreateModelMonitoringJobRequest, ModelMonitoringJob>
      createModelMonitoringJobSettings() {
    return createModelMonitoringJobSettings;
  }

  /** Returns the object with the settings used for calls to getModelMonitoringJob. */
  public UnaryCallSettings<GetModelMonitoringJobRequest, ModelMonitoringJob>
      getModelMonitoringJobSettings() {
    return getModelMonitoringJobSettings;
  }

  /** Returns the object with the settings used for calls to listModelMonitoringJobs. */
  public PagedCallSettings<
          ListModelMonitoringJobsRequest,
          ListModelMonitoringJobsResponse,
          ListModelMonitoringJobsPagedResponse>
      listModelMonitoringJobsSettings() {
    return listModelMonitoringJobsSettings;
  }

  /** Returns the object with the settings used for calls to deleteModelMonitoringJob. */
  public UnaryCallSettings<DeleteModelMonitoringJobRequest, Operation>
      deleteModelMonitoringJobSettings() {
    return deleteModelMonitoringJobSettings;
  }

  /** Returns the object with the settings used for calls to deleteModelMonitoringJob. */
  public OperationCallSettings<DeleteModelMonitoringJobRequest, Empty, DeleteOperationMetadata>
      deleteModelMonitoringJobOperationSettings() {
    return deleteModelMonitoringJobOperationSettings;
  }

  /** Returns the object with the settings used for calls to searchModelMonitoringStats. */
  public PagedCallSettings<
          SearchModelMonitoringStatsRequest,
          SearchModelMonitoringStatsResponse,
          SearchModelMonitoringStatsPagedResponse>
      searchModelMonitoringStatsSettings() {
    return searchModelMonitoringStatsSettings;
  }

  /** Returns the object with the settings used for calls to searchModelMonitoringAlerts. */
  public PagedCallSettings<
          SearchModelMonitoringAlertsRequest,
          SearchModelMonitoringAlertsResponse,
          SearchModelMonitoringAlertsPagedResponse>
      searchModelMonitoringAlertsSettings() {
    return searchModelMonitoringAlertsSettings;
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

  public ModelMonitoringServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcModelMonitoringServiceStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(ModelMonitoringServiceStubSettings.class))
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

  protected ModelMonitoringServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createModelMonitorSettings = settingsBuilder.createModelMonitorSettings().build();
    createModelMonitorOperationSettings =
        settingsBuilder.createModelMonitorOperationSettings().build();
    updateModelMonitorSettings = settingsBuilder.updateModelMonitorSettings().build();
    updateModelMonitorOperationSettings =
        settingsBuilder.updateModelMonitorOperationSettings().build();
    getModelMonitorSettings = settingsBuilder.getModelMonitorSettings().build();
    listModelMonitorsSettings = settingsBuilder.listModelMonitorsSettings().build();
    deleteModelMonitorSettings = settingsBuilder.deleteModelMonitorSettings().build();
    deleteModelMonitorOperationSettings =
        settingsBuilder.deleteModelMonitorOperationSettings().build();
    createModelMonitoringJobSettings = settingsBuilder.createModelMonitoringJobSettings().build();
    getModelMonitoringJobSettings = settingsBuilder.getModelMonitoringJobSettings().build();
    listModelMonitoringJobsSettings = settingsBuilder.listModelMonitoringJobsSettings().build();
    deleteModelMonitoringJobSettings = settingsBuilder.deleteModelMonitoringJobSettings().build();
    deleteModelMonitoringJobOperationSettings =
        settingsBuilder.deleteModelMonitoringJobOperationSettings().build();
    searchModelMonitoringStatsSettings =
        settingsBuilder.searchModelMonitoringStatsSettings().build();
    searchModelMonitoringAlertsSettings =
        settingsBuilder.searchModelMonitoringAlertsSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for ModelMonitoringServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<ModelMonitoringServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateModelMonitorRequest, Operation>
        createModelMonitorSettings;
    private final OperationCallSettings.Builder<
            CreateModelMonitorRequest, ModelMonitor, CreateModelMonitorOperationMetadata>
        createModelMonitorOperationSettings;
    private final UnaryCallSettings.Builder<UpdateModelMonitorRequest, Operation>
        updateModelMonitorSettings;
    private final OperationCallSettings.Builder<
            UpdateModelMonitorRequest, ModelMonitor, UpdateModelMonitorOperationMetadata>
        updateModelMonitorOperationSettings;
    private final UnaryCallSettings.Builder<GetModelMonitorRequest, ModelMonitor>
        getModelMonitorSettings;
    private final PagedCallSettings.Builder<
            ListModelMonitorsRequest, ListModelMonitorsResponse, ListModelMonitorsPagedResponse>
        listModelMonitorsSettings;
    private final UnaryCallSettings.Builder<DeleteModelMonitorRequest, Operation>
        deleteModelMonitorSettings;
    private final OperationCallSettings.Builder<
            DeleteModelMonitorRequest, Empty, DeleteOperationMetadata>
        deleteModelMonitorOperationSettings;
    private final UnaryCallSettings.Builder<CreateModelMonitoringJobRequest, ModelMonitoringJob>
        createModelMonitoringJobSettings;
    private final UnaryCallSettings.Builder<GetModelMonitoringJobRequest, ModelMonitoringJob>
        getModelMonitoringJobSettings;
    private final PagedCallSettings.Builder<
            ListModelMonitoringJobsRequest,
            ListModelMonitoringJobsResponse,
            ListModelMonitoringJobsPagedResponse>
        listModelMonitoringJobsSettings;
    private final UnaryCallSettings.Builder<DeleteModelMonitoringJobRequest, Operation>
        deleteModelMonitoringJobSettings;
    private final OperationCallSettings.Builder<
            DeleteModelMonitoringJobRequest, Empty, DeleteOperationMetadata>
        deleteModelMonitoringJobOperationSettings;
    private final PagedCallSettings.Builder<
            SearchModelMonitoringStatsRequest,
            SearchModelMonitoringStatsResponse,
            SearchModelMonitoringStatsPagedResponse>
        searchModelMonitoringStatsSettings;
    private final PagedCallSettings.Builder<
            SearchModelMonitoringAlertsRequest,
            SearchModelMonitoringAlertsResponse,
            SearchModelMonitoringAlertsPagedResponse>
        searchModelMonitoringAlertsSettings;
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

      createModelMonitorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createModelMonitorOperationSettings = OperationCallSettings.newBuilder();
      updateModelMonitorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateModelMonitorOperationSettings = OperationCallSettings.newBuilder();
      getModelMonitorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listModelMonitorsSettings = PagedCallSettings.newBuilder(LIST_MODEL_MONITORS_PAGE_STR_FACT);
      deleteModelMonitorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteModelMonitorOperationSettings = OperationCallSettings.newBuilder();
      createModelMonitoringJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getModelMonitoringJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listModelMonitoringJobsSettings =
          PagedCallSettings.newBuilder(LIST_MODEL_MONITORING_JOBS_PAGE_STR_FACT);
      deleteModelMonitoringJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteModelMonitoringJobOperationSettings = OperationCallSettings.newBuilder();
      searchModelMonitoringStatsSettings =
          PagedCallSettings.newBuilder(SEARCH_MODEL_MONITORING_STATS_PAGE_STR_FACT);
      searchModelMonitoringAlertsSettings =
          PagedCallSettings.newBuilder(SEARCH_MODEL_MONITORING_ALERTS_PAGE_STR_FACT);
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createModelMonitorSettings,
              updateModelMonitorSettings,
              getModelMonitorSettings,
              listModelMonitorsSettings,
              deleteModelMonitorSettings,
              createModelMonitoringJobSettings,
              getModelMonitoringJobSettings,
              listModelMonitoringJobsSettings,
              deleteModelMonitoringJobSettings,
              searchModelMonitoringStatsSettings,
              searchModelMonitoringAlertsSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(ModelMonitoringServiceStubSettings settings) {
      super(settings);

      createModelMonitorSettings = settings.createModelMonitorSettings.toBuilder();
      createModelMonitorOperationSettings =
          settings.createModelMonitorOperationSettings.toBuilder();
      updateModelMonitorSettings = settings.updateModelMonitorSettings.toBuilder();
      updateModelMonitorOperationSettings =
          settings.updateModelMonitorOperationSettings.toBuilder();
      getModelMonitorSettings = settings.getModelMonitorSettings.toBuilder();
      listModelMonitorsSettings = settings.listModelMonitorsSettings.toBuilder();
      deleteModelMonitorSettings = settings.deleteModelMonitorSettings.toBuilder();
      deleteModelMonitorOperationSettings =
          settings.deleteModelMonitorOperationSettings.toBuilder();
      createModelMonitoringJobSettings = settings.createModelMonitoringJobSettings.toBuilder();
      getModelMonitoringJobSettings = settings.getModelMonitoringJobSettings.toBuilder();
      listModelMonitoringJobsSettings = settings.listModelMonitoringJobsSettings.toBuilder();
      deleteModelMonitoringJobSettings = settings.deleteModelMonitoringJobSettings.toBuilder();
      deleteModelMonitoringJobOperationSettings =
          settings.deleteModelMonitoringJobOperationSettings.toBuilder();
      searchModelMonitoringStatsSettings = settings.searchModelMonitoringStatsSettings.toBuilder();
      searchModelMonitoringAlertsSettings =
          settings.searchModelMonitoringAlertsSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createModelMonitorSettings,
              updateModelMonitorSettings,
              getModelMonitorSettings,
              listModelMonitorsSettings,
              deleteModelMonitorSettings,
              createModelMonitoringJobSettings,
              getModelMonitoringJobSettings,
              listModelMonitoringJobsSettings,
              deleteModelMonitoringJobSettings,
              searchModelMonitoringStatsSettings,
              searchModelMonitoringAlertsSettings,
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
          .createModelMonitorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateModelMonitorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getModelMonitorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listModelMonitorsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteModelMonitorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createModelMonitoringJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getModelMonitoringJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listModelMonitoringJobsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteModelMonitoringJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .searchModelMonitoringStatsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .searchModelMonitoringAlertsSettings()
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
          .createModelMonitorOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateModelMonitorRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ModelMonitor.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  CreateModelMonitorOperationMetadata.class))
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
          .updateModelMonitorOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateModelMonitorRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ModelMonitor.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  UpdateModelMonitorOperationMetadata.class))
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
          .deleteModelMonitorOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteModelMonitorRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
          .deleteModelMonitoringJobOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteModelMonitoringJobRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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

    /** Returns the builder for the settings used for calls to createModelMonitor. */
    public UnaryCallSettings.Builder<CreateModelMonitorRequest, Operation>
        createModelMonitorSettings() {
      return createModelMonitorSettings;
    }

    /** Returns the builder for the settings used for calls to createModelMonitor. */
    public OperationCallSettings.Builder<
            CreateModelMonitorRequest, ModelMonitor, CreateModelMonitorOperationMetadata>
        createModelMonitorOperationSettings() {
      return createModelMonitorOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateModelMonitor. */
    public UnaryCallSettings.Builder<UpdateModelMonitorRequest, Operation>
        updateModelMonitorSettings() {
      return updateModelMonitorSettings;
    }

    /** Returns the builder for the settings used for calls to updateModelMonitor. */
    public OperationCallSettings.Builder<
            UpdateModelMonitorRequest, ModelMonitor, UpdateModelMonitorOperationMetadata>
        updateModelMonitorOperationSettings() {
      return updateModelMonitorOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getModelMonitor. */
    public UnaryCallSettings.Builder<GetModelMonitorRequest, ModelMonitor>
        getModelMonitorSettings() {
      return getModelMonitorSettings;
    }

    /** Returns the builder for the settings used for calls to listModelMonitors. */
    public PagedCallSettings.Builder<
            ListModelMonitorsRequest, ListModelMonitorsResponse, ListModelMonitorsPagedResponse>
        listModelMonitorsSettings() {
      return listModelMonitorsSettings;
    }

    /** Returns the builder for the settings used for calls to deleteModelMonitor. */
    public UnaryCallSettings.Builder<DeleteModelMonitorRequest, Operation>
        deleteModelMonitorSettings() {
      return deleteModelMonitorSettings;
    }

    /** Returns the builder for the settings used for calls to deleteModelMonitor. */
    public OperationCallSettings.Builder<DeleteModelMonitorRequest, Empty, DeleteOperationMetadata>
        deleteModelMonitorOperationSettings() {
      return deleteModelMonitorOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createModelMonitoringJob. */
    public UnaryCallSettings.Builder<CreateModelMonitoringJobRequest, ModelMonitoringJob>
        createModelMonitoringJobSettings() {
      return createModelMonitoringJobSettings;
    }

    /** Returns the builder for the settings used for calls to getModelMonitoringJob. */
    public UnaryCallSettings.Builder<GetModelMonitoringJobRequest, ModelMonitoringJob>
        getModelMonitoringJobSettings() {
      return getModelMonitoringJobSettings;
    }

    /** Returns the builder for the settings used for calls to listModelMonitoringJobs. */
    public PagedCallSettings.Builder<
            ListModelMonitoringJobsRequest,
            ListModelMonitoringJobsResponse,
            ListModelMonitoringJobsPagedResponse>
        listModelMonitoringJobsSettings() {
      return listModelMonitoringJobsSettings;
    }

    /** Returns the builder for the settings used for calls to deleteModelMonitoringJob. */
    public UnaryCallSettings.Builder<DeleteModelMonitoringJobRequest, Operation>
        deleteModelMonitoringJobSettings() {
      return deleteModelMonitoringJobSettings;
    }

    /** Returns the builder for the settings used for calls to deleteModelMonitoringJob. */
    public OperationCallSettings.Builder<
            DeleteModelMonitoringJobRequest, Empty, DeleteOperationMetadata>
        deleteModelMonitoringJobOperationSettings() {
      return deleteModelMonitoringJobOperationSettings;
    }

    /** Returns the builder for the settings used for calls to searchModelMonitoringStats. */
    public PagedCallSettings.Builder<
            SearchModelMonitoringStatsRequest,
            SearchModelMonitoringStatsResponse,
            SearchModelMonitoringStatsPagedResponse>
        searchModelMonitoringStatsSettings() {
      return searchModelMonitoringStatsSettings;
    }

    /** Returns the builder for the settings used for calls to searchModelMonitoringAlerts. */
    public PagedCallSettings.Builder<
            SearchModelMonitoringAlertsRequest,
            SearchModelMonitoringAlertsResponse,
            SearchModelMonitoringAlertsPagedResponse>
        searchModelMonitoringAlertsSettings() {
      return searchModelMonitoringAlertsSettings;
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
    public ModelMonitoringServiceStubSettings build() throws IOException {
      return new ModelMonitoringServiceStubSettings(this);
    }
  }
}
