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

import static com.google.cloud.aiplatform.v1beta1.FeatureRegistryServiceClient.ListFeatureGroupsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.FeatureRegistryServiceClient.ListFeatureMonitorJobsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.FeatureRegistryServiceClient.ListFeatureMonitorsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.FeatureRegistryServiceClient.ListFeaturesPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.FeatureRegistryServiceClient.ListLocationsPagedResponse;

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
import com.google.cloud.aiplatform.v1beta1.BatchCreateFeaturesOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.BatchCreateFeaturesRequest;
import com.google.cloud.aiplatform.v1beta1.BatchCreateFeaturesResponse;
import com.google.cloud.aiplatform.v1beta1.CreateFeatureGroupOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.CreateFeatureGroupRequest;
import com.google.cloud.aiplatform.v1beta1.CreateFeatureMonitorJobRequest;
import com.google.cloud.aiplatform.v1beta1.CreateFeatureMonitorOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.CreateFeatureMonitorRequest;
import com.google.cloud.aiplatform.v1beta1.CreateFeatureOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.CreateFeatureRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteFeatureGroupRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteFeatureMonitorRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteFeatureRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.Feature;
import com.google.cloud.aiplatform.v1beta1.FeatureGroup;
import com.google.cloud.aiplatform.v1beta1.FeatureMonitor;
import com.google.cloud.aiplatform.v1beta1.FeatureMonitorJob;
import com.google.cloud.aiplatform.v1beta1.GetFeatureGroupRequest;
import com.google.cloud.aiplatform.v1beta1.GetFeatureMonitorJobRequest;
import com.google.cloud.aiplatform.v1beta1.GetFeatureMonitorRequest;
import com.google.cloud.aiplatform.v1beta1.GetFeatureRequest;
import com.google.cloud.aiplatform.v1beta1.ListFeatureGroupsRequest;
import com.google.cloud.aiplatform.v1beta1.ListFeatureGroupsResponse;
import com.google.cloud.aiplatform.v1beta1.ListFeatureMonitorJobsRequest;
import com.google.cloud.aiplatform.v1beta1.ListFeatureMonitorJobsResponse;
import com.google.cloud.aiplatform.v1beta1.ListFeatureMonitorsRequest;
import com.google.cloud.aiplatform.v1beta1.ListFeatureMonitorsResponse;
import com.google.cloud.aiplatform.v1beta1.ListFeaturesRequest;
import com.google.cloud.aiplatform.v1beta1.ListFeaturesResponse;
import com.google.cloud.aiplatform.v1beta1.UpdateFeatureGroupOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.UpdateFeatureGroupRequest;
import com.google.cloud.aiplatform.v1beta1.UpdateFeatureOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.UpdateFeatureRequest;
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
 * Settings class to configure an instance of {@link FeatureRegistryServiceStub}.
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
 * of getFeatureGroup:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * FeatureRegistryServiceStubSettings.Builder featureRegistryServiceSettingsBuilder =
 *     FeatureRegistryServiceStubSettings.newBuilder();
 * featureRegistryServiceSettingsBuilder
 *     .getFeatureGroupSettings()
 *     .setRetrySettings(
 *         featureRegistryServiceSettingsBuilder
 *             .getFeatureGroupSettings()
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
 * FeatureRegistryServiceStubSettings featureRegistryServiceSettings =
 *     featureRegistryServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createFeatureGroup:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * FeatureRegistryServiceStubSettings.Builder featureRegistryServiceSettingsBuilder =
 *     FeatureRegistryServiceStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelay(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * featureRegistryServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class FeatureRegistryServiceStubSettings
    extends StubSettings<FeatureRegistryServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateFeatureGroupRequest, Operation> createFeatureGroupSettings;
  private final OperationCallSettings<
          CreateFeatureGroupRequest, FeatureGroup, CreateFeatureGroupOperationMetadata>
      createFeatureGroupOperationSettings;
  private final UnaryCallSettings<GetFeatureGroupRequest, FeatureGroup> getFeatureGroupSettings;
  private final PagedCallSettings<
          ListFeatureGroupsRequest, ListFeatureGroupsResponse, ListFeatureGroupsPagedResponse>
      listFeatureGroupsSettings;
  private final UnaryCallSettings<UpdateFeatureGroupRequest, Operation> updateFeatureGroupSettings;
  private final OperationCallSettings<
          UpdateFeatureGroupRequest, FeatureGroup, UpdateFeatureGroupOperationMetadata>
      updateFeatureGroupOperationSettings;
  private final UnaryCallSettings<DeleteFeatureGroupRequest, Operation> deleteFeatureGroupSettings;
  private final OperationCallSettings<DeleteFeatureGroupRequest, Empty, DeleteOperationMetadata>
      deleteFeatureGroupOperationSettings;
  private final UnaryCallSettings<CreateFeatureRequest, Operation> createFeatureSettings;
  private final OperationCallSettings<CreateFeatureRequest, Feature, CreateFeatureOperationMetadata>
      createFeatureOperationSettings;
  private final UnaryCallSettings<BatchCreateFeaturesRequest, Operation>
      batchCreateFeaturesSettings;
  private final OperationCallSettings<
          BatchCreateFeaturesRequest,
          BatchCreateFeaturesResponse,
          BatchCreateFeaturesOperationMetadata>
      batchCreateFeaturesOperationSettings;
  private final UnaryCallSettings<GetFeatureRequest, Feature> getFeatureSettings;
  private final PagedCallSettings<
          ListFeaturesRequest, ListFeaturesResponse, ListFeaturesPagedResponse>
      listFeaturesSettings;
  private final UnaryCallSettings<UpdateFeatureRequest, Operation> updateFeatureSettings;
  private final OperationCallSettings<UpdateFeatureRequest, Feature, UpdateFeatureOperationMetadata>
      updateFeatureOperationSettings;
  private final UnaryCallSettings<DeleteFeatureRequest, Operation> deleteFeatureSettings;
  private final OperationCallSettings<DeleteFeatureRequest, Empty, DeleteOperationMetadata>
      deleteFeatureOperationSettings;
  private final UnaryCallSettings<CreateFeatureMonitorRequest, Operation>
      createFeatureMonitorSettings;
  private final OperationCallSettings<
          CreateFeatureMonitorRequest, FeatureMonitor, CreateFeatureMonitorOperationMetadata>
      createFeatureMonitorOperationSettings;
  private final UnaryCallSettings<GetFeatureMonitorRequest, FeatureMonitor>
      getFeatureMonitorSettings;
  private final PagedCallSettings<
          ListFeatureMonitorsRequest, ListFeatureMonitorsResponse, ListFeatureMonitorsPagedResponse>
      listFeatureMonitorsSettings;
  private final UnaryCallSettings<DeleteFeatureMonitorRequest, Operation>
      deleteFeatureMonitorSettings;
  private final OperationCallSettings<DeleteFeatureMonitorRequest, Empty, DeleteOperationMetadata>
      deleteFeatureMonitorOperationSettings;
  private final UnaryCallSettings<CreateFeatureMonitorJobRequest, FeatureMonitorJob>
      createFeatureMonitorJobSettings;
  private final UnaryCallSettings<GetFeatureMonitorJobRequest, FeatureMonitorJob>
      getFeatureMonitorJobSettings;
  private final PagedCallSettings<
          ListFeatureMonitorJobsRequest,
          ListFeatureMonitorJobsResponse,
          ListFeatureMonitorJobsPagedResponse>
      listFeatureMonitorJobsSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<
          ListFeatureGroupsRequest, ListFeatureGroupsResponse, FeatureGroup>
      LIST_FEATURE_GROUPS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListFeatureGroupsRequest, ListFeatureGroupsResponse, FeatureGroup>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListFeatureGroupsRequest injectToken(
                ListFeatureGroupsRequest payload, String token) {
              return ListFeatureGroupsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListFeatureGroupsRequest injectPageSize(
                ListFeatureGroupsRequest payload, int pageSize) {
              return ListFeatureGroupsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListFeatureGroupsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListFeatureGroupsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<FeatureGroup> extractResources(ListFeatureGroupsResponse payload) {
              return payload.getFeatureGroupsList();
            }
          };

  private static final PagedListDescriptor<ListFeaturesRequest, ListFeaturesResponse, Feature>
      LIST_FEATURES_PAGE_STR_DESC =
          new PagedListDescriptor<ListFeaturesRequest, ListFeaturesResponse, Feature>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListFeaturesRequest injectToken(ListFeaturesRequest payload, String token) {
              return ListFeaturesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListFeaturesRequest injectPageSize(ListFeaturesRequest payload, int pageSize) {
              return ListFeaturesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListFeaturesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListFeaturesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Feature> extractResources(ListFeaturesResponse payload) {
              return payload.getFeaturesList();
            }
          };

  private static final PagedListDescriptor<
          ListFeatureMonitorsRequest, ListFeatureMonitorsResponse, FeatureMonitor>
      LIST_FEATURE_MONITORS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListFeatureMonitorsRequest, ListFeatureMonitorsResponse, FeatureMonitor>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListFeatureMonitorsRequest injectToken(
                ListFeatureMonitorsRequest payload, String token) {
              return ListFeatureMonitorsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListFeatureMonitorsRequest injectPageSize(
                ListFeatureMonitorsRequest payload, int pageSize) {
              return ListFeatureMonitorsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListFeatureMonitorsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListFeatureMonitorsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<FeatureMonitor> extractResources(ListFeatureMonitorsResponse payload) {
              return payload.getFeatureMonitorsList();
            }
          };

  private static final PagedListDescriptor<
          ListFeatureMonitorJobsRequest, ListFeatureMonitorJobsResponse, FeatureMonitorJob>
      LIST_FEATURE_MONITOR_JOBS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListFeatureMonitorJobsRequest, ListFeatureMonitorJobsResponse, FeatureMonitorJob>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListFeatureMonitorJobsRequest injectToken(
                ListFeatureMonitorJobsRequest payload, String token) {
              return ListFeatureMonitorJobsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListFeatureMonitorJobsRequest injectPageSize(
                ListFeatureMonitorJobsRequest payload, int pageSize) {
              return ListFeatureMonitorJobsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListFeatureMonitorJobsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListFeatureMonitorJobsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<FeatureMonitorJob> extractResources(
                ListFeatureMonitorJobsResponse payload) {
              return payload.getFeatureMonitorJobsList();
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
          ListFeatureGroupsRequest, ListFeatureGroupsResponse, ListFeatureGroupsPagedResponse>
      LIST_FEATURE_GROUPS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListFeatureGroupsRequest,
              ListFeatureGroupsResponse,
              ListFeatureGroupsPagedResponse>() {
            @Override
            public ApiFuture<ListFeatureGroupsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListFeatureGroupsRequest, ListFeatureGroupsResponse> callable,
                ListFeatureGroupsRequest request,
                ApiCallContext context,
                ApiFuture<ListFeatureGroupsResponse> futureResponse) {
              PageContext<ListFeatureGroupsRequest, ListFeatureGroupsResponse, FeatureGroup>
                  pageContext =
                      PageContext.create(
                          callable, LIST_FEATURE_GROUPS_PAGE_STR_DESC, request, context);
              return ListFeatureGroupsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListFeaturesRequest, ListFeaturesResponse, ListFeaturesPagedResponse>
      LIST_FEATURES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListFeaturesRequest, ListFeaturesResponse, ListFeaturesPagedResponse>() {
            @Override
            public ApiFuture<ListFeaturesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListFeaturesRequest, ListFeaturesResponse> callable,
                ListFeaturesRequest request,
                ApiCallContext context,
                ApiFuture<ListFeaturesResponse> futureResponse) {
              PageContext<ListFeaturesRequest, ListFeaturesResponse, Feature> pageContext =
                  PageContext.create(callable, LIST_FEATURES_PAGE_STR_DESC, request, context);
              return ListFeaturesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListFeatureMonitorsRequest, ListFeatureMonitorsResponse, ListFeatureMonitorsPagedResponse>
      LIST_FEATURE_MONITORS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListFeatureMonitorsRequest,
              ListFeatureMonitorsResponse,
              ListFeatureMonitorsPagedResponse>() {
            @Override
            public ApiFuture<ListFeatureMonitorsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListFeatureMonitorsRequest, ListFeatureMonitorsResponse> callable,
                ListFeatureMonitorsRequest request,
                ApiCallContext context,
                ApiFuture<ListFeatureMonitorsResponse> futureResponse) {
              PageContext<ListFeatureMonitorsRequest, ListFeatureMonitorsResponse, FeatureMonitor>
                  pageContext =
                      PageContext.create(
                          callable, LIST_FEATURE_MONITORS_PAGE_STR_DESC, request, context);
              return ListFeatureMonitorsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListFeatureMonitorJobsRequest,
          ListFeatureMonitorJobsResponse,
          ListFeatureMonitorJobsPagedResponse>
      LIST_FEATURE_MONITOR_JOBS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListFeatureMonitorJobsRequest,
              ListFeatureMonitorJobsResponse,
              ListFeatureMonitorJobsPagedResponse>() {
            @Override
            public ApiFuture<ListFeatureMonitorJobsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListFeatureMonitorJobsRequest, ListFeatureMonitorJobsResponse>
                    callable,
                ListFeatureMonitorJobsRequest request,
                ApiCallContext context,
                ApiFuture<ListFeatureMonitorJobsResponse> futureResponse) {
              PageContext<
                      ListFeatureMonitorJobsRequest,
                      ListFeatureMonitorJobsResponse,
                      FeatureMonitorJob>
                  pageContext =
                      PageContext.create(
                          callable, LIST_FEATURE_MONITOR_JOBS_PAGE_STR_DESC, request, context);
              return ListFeatureMonitorJobsPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to createFeatureGroup. */
  public UnaryCallSettings<CreateFeatureGroupRequest, Operation> createFeatureGroupSettings() {
    return createFeatureGroupSettings;
  }

  /** Returns the object with the settings used for calls to createFeatureGroup. */
  public OperationCallSettings<
          CreateFeatureGroupRequest, FeatureGroup, CreateFeatureGroupOperationMetadata>
      createFeatureGroupOperationSettings() {
    return createFeatureGroupOperationSettings;
  }

  /** Returns the object with the settings used for calls to getFeatureGroup. */
  public UnaryCallSettings<GetFeatureGroupRequest, FeatureGroup> getFeatureGroupSettings() {
    return getFeatureGroupSettings;
  }

  /** Returns the object with the settings used for calls to listFeatureGroups. */
  public PagedCallSettings<
          ListFeatureGroupsRequest, ListFeatureGroupsResponse, ListFeatureGroupsPagedResponse>
      listFeatureGroupsSettings() {
    return listFeatureGroupsSettings;
  }

  /** Returns the object with the settings used for calls to updateFeatureGroup. */
  public UnaryCallSettings<UpdateFeatureGroupRequest, Operation> updateFeatureGroupSettings() {
    return updateFeatureGroupSettings;
  }

  /** Returns the object with the settings used for calls to updateFeatureGroup. */
  public OperationCallSettings<
          UpdateFeatureGroupRequest, FeatureGroup, UpdateFeatureGroupOperationMetadata>
      updateFeatureGroupOperationSettings() {
    return updateFeatureGroupOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteFeatureGroup. */
  public UnaryCallSettings<DeleteFeatureGroupRequest, Operation> deleteFeatureGroupSettings() {
    return deleteFeatureGroupSettings;
  }

  /** Returns the object with the settings used for calls to deleteFeatureGroup. */
  public OperationCallSettings<DeleteFeatureGroupRequest, Empty, DeleteOperationMetadata>
      deleteFeatureGroupOperationSettings() {
    return deleteFeatureGroupOperationSettings;
  }

  /** Returns the object with the settings used for calls to createFeature. */
  public UnaryCallSettings<CreateFeatureRequest, Operation> createFeatureSettings() {
    return createFeatureSettings;
  }

  /** Returns the object with the settings used for calls to createFeature. */
  public OperationCallSettings<CreateFeatureRequest, Feature, CreateFeatureOperationMetadata>
      createFeatureOperationSettings() {
    return createFeatureOperationSettings;
  }

  /** Returns the object with the settings used for calls to batchCreateFeatures. */
  public UnaryCallSettings<BatchCreateFeaturesRequest, Operation> batchCreateFeaturesSettings() {
    return batchCreateFeaturesSettings;
  }

  /** Returns the object with the settings used for calls to batchCreateFeatures. */
  public OperationCallSettings<
          BatchCreateFeaturesRequest,
          BatchCreateFeaturesResponse,
          BatchCreateFeaturesOperationMetadata>
      batchCreateFeaturesOperationSettings() {
    return batchCreateFeaturesOperationSettings;
  }

  /** Returns the object with the settings used for calls to getFeature. */
  public UnaryCallSettings<GetFeatureRequest, Feature> getFeatureSettings() {
    return getFeatureSettings;
  }

  /** Returns the object with the settings used for calls to listFeatures. */
  public PagedCallSettings<ListFeaturesRequest, ListFeaturesResponse, ListFeaturesPagedResponse>
      listFeaturesSettings() {
    return listFeaturesSettings;
  }

  /** Returns the object with the settings used for calls to updateFeature. */
  public UnaryCallSettings<UpdateFeatureRequest, Operation> updateFeatureSettings() {
    return updateFeatureSettings;
  }

  /** Returns the object with the settings used for calls to updateFeature. */
  public OperationCallSettings<UpdateFeatureRequest, Feature, UpdateFeatureOperationMetadata>
      updateFeatureOperationSettings() {
    return updateFeatureOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteFeature. */
  public UnaryCallSettings<DeleteFeatureRequest, Operation> deleteFeatureSettings() {
    return deleteFeatureSettings;
  }

  /** Returns the object with the settings used for calls to deleteFeature. */
  public OperationCallSettings<DeleteFeatureRequest, Empty, DeleteOperationMetadata>
      deleteFeatureOperationSettings() {
    return deleteFeatureOperationSettings;
  }

  /** Returns the object with the settings used for calls to createFeatureMonitor. */
  public UnaryCallSettings<CreateFeatureMonitorRequest, Operation> createFeatureMonitorSettings() {
    return createFeatureMonitorSettings;
  }

  /** Returns the object with the settings used for calls to createFeatureMonitor. */
  public OperationCallSettings<
          CreateFeatureMonitorRequest, FeatureMonitor, CreateFeatureMonitorOperationMetadata>
      createFeatureMonitorOperationSettings() {
    return createFeatureMonitorOperationSettings;
  }

  /** Returns the object with the settings used for calls to getFeatureMonitor. */
  public UnaryCallSettings<GetFeatureMonitorRequest, FeatureMonitor> getFeatureMonitorSettings() {
    return getFeatureMonitorSettings;
  }

  /** Returns the object with the settings used for calls to listFeatureMonitors. */
  public PagedCallSettings<
          ListFeatureMonitorsRequest, ListFeatureMonitorsResponse, ListFeatureMonitorsPagedResponse>
      listFeatureMonitorsSettings() {
    return listFeatureMonitorsSettings;
  }

  /** Returns the object with the settings used for calls to deleteFeatureMonitor. */
  public UnaryCallSettings<DeleteFeatureMonitorRequest, Operation> deleteFeatureMonitorSettings() {
    return deleteFeatureMonitorSettings;
  }

  /** Returns the object with the settings used for calls to deleteFeatureMonitor. */
  public OperationCallSettings<DeleteFeatureMonitorRequest, Empty, DeleteOperationMetadata>
      deleteFeatureMonitorOperationSettings() {
    return deleteFeatureMonitorOperationSettings;
  }

  /** Returns the object with the settings used for calls to createFeatureMonitorJob. */
  public UnaryCallSettings<CreateFeatureMonitorJobRequest, FeatureMonitorJob>
      createFeatureMonitorJobSettings() {
    return createFeatureMonitorJobSettings;
  }

  /** Returns the object with the settings used for calls to getFeatureMonitorJob. */
  public UnaryCallSettings<GetFeatureMonitorJobRequest, FeatureMonitorJob>
      getFeatureMonitorJobSettings() {
    return getFeatureMonitorJobSettings;
  }

  /** Returns the object with the settings used for calls to listFeatureMonitorJobs. */
  public PagedCallSettings<
          ListFeatureMonitorJobsRequest,
          ListFeatureMonitorJobsResponse,
          ListFeatureMonitorJobsPagedResponse>
      listFeatureMonitorJobsSettings() {
    return listFeatureMonitorJobsSettings;
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

  public FeatureRegistryServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcFeatureRegistryServiceStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(FeatureRegistryServiceStubSettings.class))
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

  protected FeatureRegistryServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createFeatureGroupSettings = settingsBuilder.createFeatureGroupSettings().build();
    createFeatureGroupOperationSettings =
        settingsBuilder.createFeatureGroupOperationSettings().build();
    getFeatureGroupSettings = settingsBuilder.getFeatureGroupSettings().build();
    listFeatureGroupsSettings = settingsBuilder.listFeatureGroupsSettings().build();
    updateFeatureGroupSettings = settingsBuilder.updateFeatureGroupSettings().build();
    updateFeatureGroupOperationSettings =
        settingsBuilder.updateFeatureGroupOperationSettings().build();
    deleteFeatureGroupSettings = settingsBuilder.deleteFeatureGroupSettings().build();
    deleteFeatureGroupOperationSettings =
        settingsBuilder.deleteFeatureGroupOperationSettings().build();
    createFeatureSettings = settingsBuilder.createFeatureSettings().build();
    createFeatureOperationSettings = settingsBuilder.createFeatureOperationSettings().build();
    batchCreateFeaturesSettings = settingsBuilder.batchCreateFeaturesSettings().build();
    batchCreateFeaturesOperationSettings =
        settingsBuilder.batchCreateFeaturesOperationSettings().build();
    getFeatureSettings = settingsBuilder.getFeatureSettings().build();
    listFeaturesSettings = settingsBuilder.listFeaturesSettings().build();
    updateFeatureSettings = settingsBuilder.updateFeatureSettings().build();
    updateFeatureOperationSettings = settingsBuilder.updateFeatureOperationSettings().build();
    deleteFeatureSettings = settingsBuilder.deleteFeatureSettings().build();
    deleteFeatureOperationSettings = settingsBuilder.deleteFeatureOperationSettings().build();
    createFeatureMonitorSettings = settingsBuilder.createFeatureMonitorSettings().build();
    createFeatureMonitorOperationSettings =
        settingsBuilder.createFeatureMonitorOperationSettings().build();
    getFeatureMonitorSettings = settingsBuilder.getFeatureMonitorSettings().build();
    listFeatureMonitorsSettings = settingsBuilder.listFeatureMonitorsSettings().build();
    deleteFeatureMonitorSettings = settingsBuilder.deleteFeatureMonitorSettings().build();
    deleteFeatureMonitorOperationSettings =
        settingsBuilder.deleteFeatureMonitorOperationSettings().build();
    createFeatureMonitorJobSettings = settingsBuilder.createFeatureMonitorJobSettings().build();
    getFeatureMonitorJobSettings = settingsBuilder.getFeatureMonitorJobSettings().build();
    listFeatureMonitorJobsSettings = settingsBuilder.listFeatureMonitorJobsSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for FeatureRegistryServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<FeatureRegistryServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateFeatureGroupRequest, Operation>
        createFeatureGroupSettings;
    private final OperationCallSettings.Builder<
            CreateFeatureGroupRequest, FeatureGroup, CreateFeatureGroupOperationMetadata>
        createFeatureGroupOperationSettings;
    private final UnaryCallSettings.Builder<GetFeatureGroupRequest, FeatureGroup>
        getFeatureGroupSettings;
    private final PagedCallSettings.Builder<
            ListFeatureGroupsRequest, ListFeatureGroupsResponse, ListFeatureGroupsPagedResponse>
        listFeatureGroupsSettings;
    private final UnaryCallSettings.Builder<UpdateFeatureGroupRequest, Operation>
        updateFeatureGroupSettings;
    private final OperationCallSettings.Builder<
            UpdateFeatureGroupRequest, FeatureGroup, UpdateFeatureGroupOperationMetadata>
        updateFeatureGroupOperationSettings;
    private final UnaryCallSettings.Builder<DeleteFeatureGroupRequest, Operation>
        deleteFeatureGroupSettings;
    private final OperationCallSettings.Builder<
            DeleteFeatureGroupRequest, Empty, DeleteOperationMetadata>
        deleteFeatureGroupOperationSettings;
    private final UnaryCallSettings.Builder<CreateFeatureRequest, Operation> createFeatureSettings;
    private final OperationCallSettings.Builder<
            CreateFeatureRequest, Feature, CreateFeatureOperationMetadata>
        createFeatureOperationSettings;
    private final UnaryCallSettings.Builder<BatchCreateFeaturesRequest, Operation>
        batchCreateFeaturesSettings;
    private final OperationCallSettings.Builder<
            BatchCreateFeaturesRequest,
            BatchCreateFeaturesResponse,
            BatchCreateFeaturesOperationMetadata>
        batchCreateFeaturesOperationSettings;
    private final UnaryCallSettings.Builder<GetFeatureRequest, Feature> getFeatureSettings;
    private final PagedCallSettings.Builder<
            ListFeaturesRequest, ListFeaturesResponse, ListFeaturesPagedResponse>
        listFeaturesSettings;
    private final UnaryCallSettings.Builder<UpdateFeatureRequest, Operation> updateFeatureSettings;
    private final OperationCallSettings.Builder<
            UpdateFeatureRequest, Feature, UpdateFeatureOperationMetadata>
        updateFeatureOperationSettings;
    private final UnaryCallSettings.Builder<DeleteFeatureRequest, Operation> deleteFeatureSettings;
    private final OperationCallSettings.Builder<
            DeleteFeatureRequest, Empty, DeleteOperationMetadata>
        deleteFeatureOperationSettings;
    private final UnaryCallSettings.Builder<CreateFeatureMonitorRequest, Operation>
        createFeatureMonitorSettings;
    private final OperationCallSettings.Builder<
            CreateFeatureMonitorRequest, FeatureMonitor, CreateFeatureMonitorOperationMetadata>
        createFeatureMonitorOperationSettings;
    private final UnaryCallSettings.Builder<GetFeatureMonitorRequest, FeatureMonitor>
        getFeatureMonitorSettings;
    private final PagedCallSettings.Builder<
            ListFeatureMonitorsRequest,
            ListFeatureMonitorsResponse,
            ListFeatureMonitorsPagedResponse>
        listFeatureMonitorsSettings;
    private final UnaryCallSettings.Builder<DeleteFeatureMonitorRequest, Operation>
        deleteFeatureMonitorSettings;
    private final OperationCallSettings.Builder<
            DeleteFeatureMonitorRequest, Empty, DeleteOperationMetadata>
        deleteFeatureMonitorOperationSettings;
    private final UnaryCallSettings.Builder<CreateFeatureMonitorJobRequest, FeatureMonitorJob>
        createFeatureMonitorJobSettings;
    private final UnaryCallSettings.Builder<GetFeatureMonitorJobRequest, FeatureMonitorJob>
        getFeatureMonitorJobSettings;
    private final PagedCallSettings.Builder<
            ListFeatureMonitorJobsRequest,
            ListFeatureMonitorJobsResponse,
            ListFeatureMonitorJobsPagedResponse>
        listFeatureMonitorJobsSettings;
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

      createFeatureGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createFeatureGroupOperationSettings = OperationCallSettings.newBuilder();
      getFeatureGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listFeatureGroupsSettings = PagedCallSettings.newBuilder(LIST_FEATURE_GROUPS_PAGE_STR_FACT);
      updateFeatureGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateFeatureGroupOperationSettings = OperationCallSettings.newBuilder();
      deleteFeatureGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteFeatureGroupOperationSettings = OperationCallSettings.newBuilder();
      createFeatureSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createFeatureOperationSettings = OperationCallSettings.newBuilder();
      batchCreateFeaturesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchCreateFeaturesOperationSettings = OperationCallSettings.newBuilder();
      getFeatureSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listFeaturesSettings = PagedCallSettings.newBuilder(LIST_FEATURES_PAGE_STR_FACT);
      updateFeatureSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateFeatureOperationSettings = OperationCallSettings.newBuilder();
      deleteFeatureSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteFeatureOperationSettings = OperationCallSettings.newBuilder();
      createFeatureMonitorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createFeatureMonitorOperationSettings = OperationCallSettings.newBuilder();
      getFeatureMonitorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listFeatureMonitorsSettings =
          PagedCallSettings.newBuilder(LIST_FEATURE_MONITORS_PAGE_STR_FACT);
      deleteFeatureMonitorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteFeatureMonitorOperationSettings = OperationCallSettings.newBuilder();
      createFeatureMonitorJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getFeatureMonitorJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listFeatureMonitorJobsSettings =
          PagedCallSettings.newBuilder(LIST_FEATURE_MONITOR_JOBS_PAGE_STR_FACT);
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createFeatureGroupSettings,
              getFeatureGroupSettings,
              listFeatureGroupsSettings,
              updateFeatureGroupSettings,
              deleteFeatureGroupSettings,
              createFeatureSettings,
              batchCreateFeaturesSettings,
              getFeatureSettings,
              listFeaturesSettings,
              updateFeatureSettings,
              deleteFeatureSettings,
              createFeatureMonitorSettings,
              getFeatureMonitorSettings,
              listFeatureMonitorsSettings,
              deleteFeatureMonitorSettings,
              createFeatureMonitorJobSettings,
              getFeatureMonitorJobSettings,
              listFeatureMonitorJobsSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(FeatureRegistryServiceStubSettings settings) {
      super(settings);

      createFeatureGroupSettings = settings.createFeatureGroupSettings.toBuilder();
      createFeatureGroupOperationSettings =
          settings.createFeatureGroupOperationSettings.toBuilder();
      getFeatureGroupSettings = settings.getFeatureGroupSettings.toBuilder();
      listFeatureGroupsSettings = settings.listFeatureGroupsSettings.toBuilder();
      updateFeatureGroupSettings = settings.updateFeatureGroupSettings.toBuilder();
      updateFeatureGroupOperationSettings =
          settings.updateFeatureGroupOperationSettings.toBuilder();
      deleteFeatureGroupSettings = settings.deleteFeatureGroupSettings.toBuilder();
      deleteFeatureGroupOperationSettings =
          settings.deleteFeatureGroupOperationSettings.toBuilder();
      createFeatureSettings = settings.createFeatureSettings.toBuilder();
      createFeatureOperationSettings = settings.createFeatureOperationSettings.toBuilder();
      batchCreateFeaturesSettings = settings.batchCreateFeaturesSettings.toBuilder();
      batchCreateFeaturesOperationSettings =
          settings.batchCreateFeaturesOperationSettings.toBuilder();
      getFeatureSettings = settings.getFeatureSettings.toBuilder();
      listFeaturesSettings = settings.listFeaturesSettings.toBuilder();
      updateFeatureSettings = settings.updateFeatureSettings.toBuilder();
      updateFeatureOperationSettings = settings.updateFeatureOperationSettings.toBuilder();
      deleteFeatureSettings = settings.deleteFeatureSettings.toBuilder();
      deleteFeatureOperationSettings = settings.deleteFeatureOperationSettings.toBuilder();
      createFeatureMonitorSettings = settings.createFeatureMonitorSettings.toBuilder();
      createFeatureMonitorOperationSettings =
          settings.createFeatureMonitorOperationSettings.toBuilder();
      getFeatureMonitorSettings = settings.getFeatureMonitorSettings.toBuilder();
      listFeatureMonitorsSettings = settings.listFeatureMonitorsSettings.toBuilder();
      deleteFeatureMonitorSettings = settings.deleteFeatureMonitorSettings.toBuilder();
      deleteFeatureMonitorOperationSettings =
          settings.deleteFeatureMonitorOperationSettings.toBuilder();
      createFeatureMonitorJobSettings = settings.createFeatureMonitorJobSettings.toBuilder();
      getFeatureMonitorJobSettings = settings.getFeatureMonitorJobSettings.toBuilder();
      listFeatureMonitorJobsSettings = settings.listFeatureMonitorJobsSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createFeatureGroupSettings,
              getFeatureGroupSettings,
              listFeatureGroupsSettings,
              updateFeatureGroupSettings,
              deleteFeatureGroupSettings,
              createFeatureSettings,
              batchCreateFeaturesSettings,
              getFeatureSettings,
              listFeaturesSettings,
              updateFeatureSettings,
              deleteFeatureSettings,
              createFeatureMonitorSettings,
              getFeatureMonitorSettings,
              listFeatureMonitorsSettings,
              deleteFeatureMonitorSettings,
              createFeatureMonitorJobSettings,
              getFeatureMonitorJobSettings,
              listFeatureMonitorJobsSettings,
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
          .createFeatureGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getFeatureGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listFeatureGroupsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateFeatureGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteFeatureGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createFeatureSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .batchCreateFeaturesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getFeatureSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listFeaturesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateFeatureSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteFeatureSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createFeatureMonitorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getFeatureMonitorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listFeatureMonitorsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteFeatureMonitorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createFeatureMonitorJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getFeatureMonitorJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listFeatureMonitorJobsSettings()
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
          .createFeatureGroupOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateFeatureGroupRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(FeatureGroup.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  CreateFeatureGroupOperationMetadata.class))
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
          .updateFeatureGroupOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateFeatureGroupRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(FeatureGroup.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  UpdateFeatureGroupOperationMetadata.class))
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
          .deleteFeatureGroupOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteFeatureGroupRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
          .createFeatureOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateFeatureRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Feature.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  CreateFeatureOperationMetadata.class))
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
          .batchCreateFeaturesOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<BatchCreateFeaturesRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  BatchCreateFeaturesResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  BatchCreateFeaturesOperationMetadata.class))
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
          .updateFeatureOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateFeatureRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Feature.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  UpdateFeatureOperationMetadata.class))
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
          .deleteFeatureOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteFeatureRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
          .createFeatureMonitorOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateFeatureMonitorRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(FeatureMonitor.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  CreateFeatureMonitorOperationMetadata.class))
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
          .deleteFeatureMonitorOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteFeatureMonitorRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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

    /** Returns the builder for the settings used for calls to createFeatureGroup. */
    public UnaryCallSettings.Builder<CreateFeatureGroupRequest, Operation>
        createFeatureGroupSettings() {
      return createFeatureGroupSettings;
    }

    /** Returns the builder for the settings used for calls to createFeatureGroup. */
    public OperationCallSettings.Builder<
            CreateFeatureGroupRequest, FeatureGroup, CreateFeatureGroupOperationMetadata>
        createFeatureGroupOperationSettings() {
      return createFeatureGroupOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getFeatureGroup. */
    public UnaryCallSettings.Builder<GetFeatureGroupRequest, FeatureGroup>
        getFeatureGroupSettings() {
      return getFeatureGroupSettings;
    }

    /** Returns the builder for the settings used for calls to listFeatureGroups. */
    public PagedCallSettings.Builder<
            ListFeatureGroupsRequest, ListFeatureGroupsResponse, ListFeatureGroupsPagedResponse>
        listFeatureGroupsSettings() {
      return listFeatureGroupsSettings;
    }

    /** Returns the builder for the settings used for calls to updateFeatureGroup. */
    public UnaryCallSettings.Builder<UpdateFeatureGroupRequest, Operation>
        updateFeatureGroupSettings() {
      return updateFeatureGroupSettings;
    }

    /** Returns the builder for the settings used for calls to updateFeatureGroup. */
    public OperationCallSettings.Builder<
            UpdateFeatureGroupRequest, FeatureGroup, UpdateFeatureGroupOperationMetadata>
        updateFeatureGroupOperationSettings() {
      return updateFeatureGroupOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteFeatureGroup. */
    public UnaryCallSettings.Builder<DeleteFeatureGroupRequest, Operation>
        deleteFeatureGroupSettings() {
      return deleteFeatureGroupSettings;
    }

    /** Returns the builder for the settings used for calls to deleteFeatureGroup. */
    public OperationCallSettings.Builder<DeleteFeatureGroupRequest, Empty, DeleteOperationMetadata>
        deleteFeatureGroupOperationSettings() {
      return deleteFeatureGroupOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createFeature. */
    public UnaryCallSettings.Builder<CreateFeatureRequest, Operation> createFeatureSettings() {
      return createFeatureSettings;
    }

    /** Returns the builder for the settings used for calls to createFeature. */
    public OperationCallSettings.Builder<
            CreateFeatureRequest, Feature, CreateFeatureOperationMetadata>
        createFeatureOperationSettings() {
      return createFeatureOperationSettings;
    }

    /** Returns the builder for the settings used for calls to batchCreateFeatures. */
    public UnaryCallSettings.Builder<BatchCreateFeaturesRequest, Operation>
        batchCreateFeaturesSettings() {
      return batchCreateFeaturesSettings;
    }

    /** Returns the builder for the settings used for calls to batchCreateFeatures. */
    public OperationCallSettings.Builder<
            BatchCreateFeaturesRequest,
            BatchCreateFeaturesResponse,
            BatchCreateFeaturesOperationMetadata>
        batchCreateFeaturesOperationSettings() {
      return batchCreateFeaturesOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getFeature. */
    public UnaryCallSettings.Builder<GetFeatureRequest, Feature> getFeatureSettings() {
      return getFeatureSettings;
    }

    /** Returns the builder for the settings used for calls to listFeatures. */
    public PagedCallSettings.Builder<
            ListFeaturesRequest, ListFeaturesResponse, ListFeaturesPagedResponse>
        listFeaturesSettings() {
      return listFeaturesSettings;
    }

    /** Returns the builder for the settings used for calls to updateFeature. */
    public UnaryCallSettings.Builder<UpdateFeatureRequest, Operation> updateFeatureSettings() {
      return updateFeatureSettings;
    }

    /** Returns the builder for the settings used for calls to updateFeature. */
    public OperationCallSettings.Builder<
            UpdateFeatureRequest, Feature, UpdateFeatureOperationMetadata>
        updateFeatureOperationSettings() {
      return updateFeatureOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteFeature. */
    public UnaryCallSettings.Builder<DeleteFeatureRequest, Operation> deleteFeatureSettings() {
      return deleteFeatureSettings;
    }

    /** Returns the builder for the settings used for calls to deleteFeature. */
    public OperationCallSettings.Builder<DeleteFeatureRequest, Empty, DeleteOperationMetadata>
        deleteFeatureOperationSettings() {
      return deleteFeatureOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createFeatureMonitor. */
    public UnaryCallSettings.Builder<CreateFeatureMonitorRequest, Operation>
        createFeatureMonitorSettings() {
      return createFeatureMonitorSettings;
    }

    /** Returns the builder for the settings used for calls to createFeatureMonitor. */
    public OperationCallSettings.Builder<
            CreateFeatureMonitorRequest, FeatureMonitor, CreateFeatureMonitorOperationMetadata>
        createFeatureMonitorOperationSettings() {
      return createFeatureMonitorOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getFeatureMonitor. */
    public UnaryCallSettings.Builder<GetFeatureMonitorRequest, FeatureMonitor>
        getFeatureMonitorSettings() {
      return getFeatureMonitorSettings;
    }

    /** Returns the builder for the settings used for calls to listFeatureMonitors. */
    public PagedCallSettings.Builder<
            ListFeatureMonitorsRequest,
            ListFeatureMonitorsResponse,
            ListFeatureMonitorsPagedResponse>
        listFeatureMonitorsSettings() {
      return listFeatureMonitorsSettings;
    }

    /** Returns the builder for the settings used for calls to deleteFeatureMonitor. */
    public UnaryCallSettings.Builder<DeleteFeatureMonitorRequest, Operation>
        deleteFeatureMonitorSettings() {
      return deleteFeatureMonitorSettings;
    }

    /** Returns the builder for the settings used for calls to deleteFeatureMonitor. */
    public OperationCallSettings.Builder<
            DeleteFeatureMonitorRequest, Empty, DeleteOperationMetadata>
        deleteFeatureMonitorOperationSettings() {
      return deleteFeatureMonitorOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createFeatureMonitorJob. */
    public UnaryCallSettings.Builder<CreateFeatureMonitorJobRequest, FeatureMonitorJob>
        createFeatureMonitorJobSettings() {
      return createFeatureMonitorJobSettings;
    }

    /** Returns the builder for the settings used for calls to getFeatureMonitorJob. */
    public UnaryCallSettings.Builder<GetFeatureMonitorJobRequest, FeatureMonitorJob>
        getFeatureMonitorJobSettings() {
      return getFeatureMonitorJobSettings;
    }

    /** Returns the builder for the settings used for calls to listFeatureMonitorJobs. */
    public PagedCallSettings.Builder<
            ListFeatureMonitorJobsRequest,
            ListFeatureMonitorJobsResponse,
            ListFeatureMonitorJobsPagedResponse>
        listFeatureMonitorJobsSettings() {
      return listFeatureMonitorJobsSettings;
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
    public FeatureRegistryServiceStubSettings build() throws IOException {
      return new FeatureRegistryServiceStubSettings(this);
    }
  }
}
