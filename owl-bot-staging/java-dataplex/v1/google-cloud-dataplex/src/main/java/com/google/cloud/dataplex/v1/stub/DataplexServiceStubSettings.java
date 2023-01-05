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

package com.google.cloud.dataplex.v1.stub;

import static com.google.cloud.dataplex.v1.DataplexServiceClient.ListAssetActionsPagedResponse;
import static com.google.cloud.dataplex.v1.DataplexServiceClient.ListAssetsPagedResponse;
import static com.google.cloud.dataplex.v1.DataplexServiceClient.ListEnvironmentsPagedResponse;
import static com.google.cloud.dataplex.v1.DataplexServiceClient.ListJobsPagedResponse;
import static com.google.cloud.dataplex.v1.DataplexServiceClient.ListLakeActionsPagedResponse;
import static com.google.cloud.dataplex.v1.DataplexServiceClient.ListLakesPagedResponse;
import static com.google.cloud.dataplex.v1.DataplexServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.dataplex.v1.DataplexServiceClient.ListSessionsPagedResponse;
import static com.google.cloud.dataplex.v1.DataplexServiceClient.ListTasksPagedResponse;
import static com.google.cloud.dataplex.v1.DataplexServiceClient.ListZoneActionsPagedResponse;
import static com.google.cloud.dataplex.v1.DataplexServiceClient.ListZonesPagedResponse;

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
import com.google.cloud.dataplex.v1.Action;
import com.google.cloud.dataplex.v1.Asset;
import com.google.cloud.dataplex.v1.CancelJobRequest;
import com.google.cloud.dataplex.v1.CreateAssetRequest;
import com.google.cloud.dataplex.v1.CreateEnvironmentRequest;
import com.google.cloud.dataplex.v1.CreateLakeRequest;
import com.google.cloud.dataplex.v1.CreateTaskRequest;
import com.google.cloud.dataplex.v1.CreateZoneRequest;
import com.google.cloud.dataplex.v1.DeleteAssetRequest;
import com.google.cloud.dataplex.v1.DeleteEnvironmentRequest;
import com.google.cloud.dataplex.v1.DeleteLakeRequest;
import com.google.cloud.dataplex.v1.DeleteTaskRequest;
import com.google.cloud.dataplex.v1.DeleteZoneRequest;
import com.google.cloud.dataplex.v1.Environment;
import com.google.cloud.dataplex.v1.GetAssetRequest;
import com.google.cloud.dataplex.v1.GetEnvironmentRequest;
import com.google.cloud.dataplex.v1.GetJobRequest;
import com.google.cloud.dataplex.v1.GetLakeRequest;
import com.google.cloud.dataplex.v1.GetTaskRequest;
import com.google.cloud.dataplex.v1.GetZoneRequest;
import com.google.cloud.dataplex.v1.Job;
import com.google.cloud.dataplex.v1.Lake;
import com.google.cloud.dataplex.v1.ListActionsResponse;
import com.google.cloud.dataplex.v1.ListAssetActionsRequest;
import com.google.cloud.dataplex.v1.ListAssetsRequest;
import com.google.cloud.dataplex.v1.ListAssetsResponse;
import com.google.cloud.dataplex.v1.ListEnvironmentsRequest;
import com.google.cloud.dataplex.v1.ListEnvironmentsResponse;
import com.google.cloud.dataplex.v1.ListJobsRequest;
import com.google.cloud.dataplex.v1.ListJobsResponse;
import com.google.cloud.dataplex.v1.ListLakeActionsRequest;
import com.google.cloud.dataplex.v1.ListLakesRequest;
import com.google.cloud.dataplex.v1.ListLakesResponse;
import com.google.cloud.dataplex.v1.ListSessionsRequest;
import com.google.cloud.dataplex.v1.ListSessionsResponse;
import com.google.cloud.dataplex.v1.ListTasksRequest;
import com.google.cloud.dataplex.v1.ListTasksResponse;
import com.google.cloud.dataplex.v1.ListZoneActionsRequest;
import com.google.cloud.dataplex.v1.ListZonesRequest;
import com.google.cloud.dataplex.v1.ListZonesResponse;
import com.google.cloud.dataplex.v1.OperationMetadata;
import com.google.cloud.dataplex.v1.Session;
import com.google.cloud.dataplex.v1.Task;
import com.google.cloud.dataplex.v1.UpdateAssetRequest;
import com.google.cloud.dataplex.v1.UpdateEnvironmentRequest;
import com.google.cloud.dataplex.v1.UpdateLakeRequest;
import com.google.cloud.dataplex.v1.UpdateTaskRequest;
import com.google.cloud.dataplex.v1.UpdateZoneRequest;
import com.google.cloud.dataplex.v1.Zone;
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
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link DataplexServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (dataplex.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getLake to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DataplexServiceStubSettings.Builder dataplexServiceSettingsBuilder =
 *     DataplexServiceStubSettings.newBuilder();
 * dataplexServiceSettingsBuilder
 *     .getLakeSettings()
 *     .setRetrySettings(
 *         dataplexServiceSettingsBuilder.getLakeSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * DataplexServiceStubSettings dataplexServiceSettings = dataplexServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class DataplexServiceStubSettings extends StubSettings<DataplexServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateLakeRequest, Operation> createLakeSettings;
  private final OperationCallSettings<CreateLakeRequest, Lake, OperationMetadata>
      createLakeOperationSettings;
  private final UnaryCallSettings<UpdateLakeRequest, Operation> updateLakeSettings;
  private final OperationCallSettings<UpdateLakeRequest, Lake, OperationMetadata>
      updateLakeOperationSettings;
  private final UnaryCallSettings<DeleteLakeRequest, Operation> deleteLakeSettings;
  private final OperationCallSettings<DeleteLakeRequest, Empty, OperationMetadata>
      deleteLakeOperationSettings;
  private final PagedCallSettings<ListLakesRequest, ListLakesResponse, ListLakesPagedResponse>
      listLakesSettings;
  private final UnaryCallSettings<GetLakeRequest, Lake> getLakeSettings;
  private final PagedCallSettings<
          ListLakeActionsRequest, ListActionsResponse, ListLakeActionsPagedResponse>
      listLakeActionsSettings;
  private final UnaryCallSettings<CreateZoneRequest, Operation> createZoneSettings;
  private final OperationCallSettings<CreateZoneRequest, Zone, OperationMetadata>
      createZoneOperationSettings;
  private final UnaryCallSettings<UpdateZoneRequest, Operation> updateZoneSettings;
  private final OperationCallSettings<UpdateZoneRequest, Zone, OperationMetadata>
      updateZoneOperationSettings;
  private final UnaryCallSettings<DeleteZoneRequest, Operation> deleteZoneSettings;
  private final OperationCallSettings<DeleteZoneRequest, Empty, OperationMetadata>
      deleteZoneOperationSettings;
  private final PagedCallSettings<ListZonesRequest, ListZonesResponse, ListZonesPagedResponse>
      listZonesSettings;
  private final UnaryCallSettings<GetZoneRequest, Zone> getZoneSettings;
  private final PagedCallSettings<
          ListZoneActionsRequest, ListActionsResponse, ListZoneActionsPagedResponse>
      listZoneActionsSettings;
  private final UnaryCallSettings<CreateAssetRequest, Operation> createAssetSettings;
  private final OperationCallSettings<CreateAssetRequest, Asset, OperationMetadata>
      createAssetOperationSettings;
  private final UnaryCallSettings<UpdateAssetRequest, Operation> updateAssetSettings;
  private final OperationCallSettings<UpdateAssetRequest, Asset, OperationMetadata>
      updateAssetOperationSettings;
  private final UnaryCallSettings<DeleteAssetRequest, Operation> deleteAssetSettings;
  private final OperationCallSettings<DeleteAssetRequest, Empty, OperationMetadata>
      deleteAssetOperationSettings;
  private final PagedCallSettings<ListAssetsRequest, ListAssetsResponse, ListAssetsPagedResponse>
      listAssetsSettings;
  private final UnaryCallSettings<GetAssetRequest, Asset> getAssetSettings;
  private final PagedCallSettings<
          ListAssetActionsRequest, ListActionsResponse, ListAssetActionsPagedResponse>
      listAssetActionsSettings;
  private final UnaryCallSettings<CreateTaskRequest, Operation> createTaskSettings;
  private final OperationCallSettings<CreateTaskRequest, Task, OperationMetadata>
      createTaskOperationSettings;
  private final UnaryCallSettings<UpdateTaskRequest, Operation> updateTaskSettings;
  private final OperationCallSettings<UpdateTaskRequest, Task, OperationMetadata>
      updateTaskOperationSettings;
  private final UnaryCallSettings<DeleteTaskRequest, Operation> deleteTaskSettings;
  private final OperationCallSettings<DeleteTaskRequest, Empty, OperationMetadata>
      deleteTaskOperationSettings;
  private final PagedCallSettings<ListTasksRequest, ListTasksResponse, ListTasksPagedResponse>
      listTasksSettings;
  private final UnaryCallSettings<GetTaskRequest, Task> getTaskSettings;
  private final PagedCallSettings<ListJobsRequest, ListJobsResponse, ListJobsPagedResponse>
      listJobsSettings;
  private final UnaryCallSettings<GetJobRequest, Job> getJobSettings;
  private final UnaryCallSettings<CancelJobRequest, Empty> cancelJobSettings;
  private final UnaryCallSettings<CreateEnvironmentRequest, Operation> createEnvironmentSettings;
  private final OperationCallSettings<CreateEnvironmentRequest, Environment, OperationMetadata>
      createEnvironmentOperationSettings;
  private final UnaryCallSettings<UpdateEnvironmentRequest, Operation> updateEnvironmentSettings;
  private final OperationCallSettings<UpdateEnvironmentRequest, Environment, OperationMetadata>
      updateEnvironmentOperationSettings;
  private final UnaryCallSettings<DeleteEnvironmentRequest, Operation> deleteEnvironmentSettings;
  private final OperationCallSettings<DeleteEnvironmentRequest, Empty, OperationMetadata>
      deleteEnvironmentOperationSettings;
  private final PagedCallSettings<
          ListEnvironmentsRequest, ListEnvironmentsResponse, ListEnvironmentsPagedResponse>
      listEnvironmentsSettings;
  private final UnaryCallSettings<GetEnvironmentRequest, Environment> getEnvironmentSettings;
  private final PagedCallSettings<
          ListSessionsRequest, ListSessionsResponse, ListSessionsPagedResponse>
      listSessionsSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

  private static final PagedListDescriptor<ListLakesRequest, ListLakesResponse, Lake>
      LIST_LAKES_PAGE_STR_DESC =
          new PagedListDescriptor<ListLakesRequest, ListLakesResponse, Lake>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListLakesRequest injectToken(ListLakesRequest payload, String token) {
              return ListLakesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListLakesRequest injectPageSize(ListLakesRequest payload, int pageSize) {
              return ListLakesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListLakesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListLakesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Lake> extractResources(ListLakesResponse payload) {
              return payload.getLakesList() == null
                  ? ImmutableList.<Lake>of()
                  : payload.getLakesList();
            }
          };

  private static final PagedListDescriptor<ListLakeActionsRequest, ListActionsResponse, Action>
      LIST_LAKE_ACTIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListLakeActionsRequest, ListActionsResponse, Action>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListLakeActionsRequest injectToken(
                ListLakeActionsRequest payload, String token) {
              return ListLakeActionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListLakeActionsRequest injectPageSize(
                ListLakeActionsRequest payload, int pageSize) {
              return ListLakeActionsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListLakeActionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListActionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Action> extractResources(ListActionsResponse payload) {
              return payload.getActionsList() == null
                  ? ImmutableList.<Action>of()
                  : payload.getActionsList();
            }
          };

  private static final PagedListDescriptor<ListZonesRequest, ListZonesResponse, Zone>
      LIST_ZONES_PAGE_STR_DESC =
          new PagedListDescriptor<ListZonesRequest, ListZonesResponse, Zone>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListZonesRequest injectToken(ListZonesRequest payload, String token) {
              return ListZonesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListZonesRequest injectPageSize(ListZonesRequest payload, int pageSize) {
              return ListZonesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListZonesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListZonesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Zone> extractResources(ListZonesResponse payload) {
              return payload.getZonesList() == null
                  ? ImmutableList.<Zone>of()
                  : payload.getZonesList();
            }
          };

  private static final PagedListDescriptor<ListZoneActionsRequest, ListActionsResponse, Action>
      LIST_ZONE_ACTIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListZoneActionsRequest, ListActionsResponse, Action>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListZoneActionsRequest injectToken(
                ListZoneActionsRequest payload, String token) {
              return ListZoneActionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListZoneActionsRequest injectPageSize(
                ListZoneActionsRequest payload, int pageSize) {
              return ListZoneActionsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListZoneActionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListActionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Action> extractResources(ListActionsResponse payload) {
              return payload.getActionsList() == null
                  ? ImmutableList.<Action>of()
                  : payload.getActionsList();
            }
          };

  private static final PagedListDescriptor<ListAssetsRequest, ListAssetsResponse, Asset>
      LIST_ASSETS_PAGE_STR_DESC =
          new PagedListDescriptor<ListAssetsRequest, ListAssetsResponse, Asset>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAssetsRequest injectToken(ListAssetsRequest payload, String token) {
              return ListAssetsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAssetsRequest injectPageSize(ListAssetsRequest payload, int pageSize) {
              return ListAssetsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAssetsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAssetsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Asset> extractResources(ListAssetsResponse payload) {
              return payload.getAssetsList() == null
                  ? ImmutableList.<Asset>of()
                  : payload.getAssetsList();
            }
          };

  private static final PagedListDescriptor<ListAssetActionsRequest, ListActionsResponse, Action>
      LIST_ASSET_ACTIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListAssetActionsRequest, ListActionsResponse, Action>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAssetActionsRequest injectToken(
                ListAssetActionsRequest payload, String token) {
              return ListAssetActionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAssetActionsRequest injectPageSize(
                ListAssetActionsRequest payload, int pageSize) {
              return ListAssetActionsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAssetActionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListActionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Action> extractResources(ListActionsResponse payload) {
              return payload.getActionsList() == null
                  ? ImmutableList.<Action>of()
                  : payload.getActionsList();
            }
          };

  private static final PagedListDescriptor<ListTasksRequest, ListTasksResponse, Task>
      LIST_TASKS_PAGE_STR_DESC =
          new PagedListDescriptor<ListTasksRequest, ListTasksResponse, Task>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListTasksRequest injectToken(ListTasksRequest payload, String token) {
              return ListTasksRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListTasksRequest injectPageSize(ListTasksRequest payload, int pageSize) {
              return ListTasksRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListTasksRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListTasksResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Task> extractResources(ListTasksResponse payload) {
              return payload.getTasksList() == null
                  ? ImmutableList.<Task>of()
                  : payload.getTasksList();
            }
          };

  private static final PagedListDescriptor<ListJobsRequest, ListJobsResponse, Job>
      LIST_JOBS_PAGE_STR_DESC =
          new PagedListDescriptor<ListJobsRequest, ListJobsResponse, Job>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListJobsRequest injectToken(ListJobsRequest payload, String token) {
              return ListJobsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListJobsRequest injectPageSize(ListJobsRequest payload, int pageSize) {
              return ListJobsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListJobsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListJobsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Job> extractResources(ListJobsResponse payload) {
              return payload.getJobsList() == null
                  ? ImmutableList.<Job>of()
                  : payload.getJobsList();
            }
          };

  private static final PagedListDescriptor<
          ListEnvironmentsRequest, ListEnvironmentsResponse, Environment>
      LIST_ENVIRONMENTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListEnvironmentsRequest, ListEnvironmentsResponse, Environment>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListEnvironmentsRequest injectToken(
                ListEnvironmentsRequest payload, String token) {
              return ListEnvironmentsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListEnvironmentsRequest injectPageSize(
                ListEnvironmentsRequest payload, int pageSize) {
              return ListEnvironmentsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListEnvironmentsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListEnvironmentsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Environment> extractResources(ListEnvironmentsResponse payload) {
              return payload.getEnvironmentsList() == null
                  ? ImmutableList.<Environment>of()
                  : payload.getEnvironmentsList();
            }
          };

  private static final PagedListDescriptor<ListSessionsRequest, ListSessionsResponse, Session>
      LIST_SESSIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListSessionsRequest, ListSessionsResponse, Session>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListSessionsRequest injectToken(ListSessionsRequest payload, String token) {
              return ListSessionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListSessionsRequest injectPageSize(ListSessionsRequest payload, int pageSize) {
              return ListSessionsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListSessionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListSessionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Session> extractResources(ListSessionsResponse payload) {
              return payload.getSessionsList() == null
                  ? ImmutableList.<Session>of()
                  : payload.getSessionsList();
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
          ListLakesRequest, ListLakesResponse, ListLakesPagedResponse>
      LIST_LAKES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListLakesRequest, ListLakesResponse, ListLakesPagedResponse>() {
            @Override
            public ApiFuture<ListLakesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListLakesRequest, ListLakesResponse> callable,
                ListLakesRequest request,
                ApiCallContext context,
                ApiFuture<ListLakesResponse> futureResponse) {
              PageContext<ListLakesRequest, ListLakesResponse, Lake> pageContext =
                  PageContext.create(callable, LIST_LAKES_PAGE_STR_DESC, request, context);
              return ListLakesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListLakeActionsRequest, ListActionsResponse, ListLakeActionsPagedResponse>
      LIST_LAKE_ACTIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListLakeActionsRequest, ListActionsResponse, ListLakeActionsPagedResponse>() {
            @Override
            public ApiFuture<ListLakeActionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListLakeActionsRequest, ListActionsResponse> callable,
                ListLakeActionsRequest request,
                ApiCallContext context,
                ApiFuture<ListActionsResponse> futureResponse) {
              PageContext<ListLakeActionsRequest, ListActionsResponse, Action> pageContext =
                  PageContext.create(callable, LIST_LAKE_ACTIONS_PAGE_STR_DESC, request, context);
              return ListLakeActionsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListZonesRequest, ListZonesResponse, ListZonesPagedResponse>
      LIST_ZONES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListZonesRequest, ListZonesResponse, ListZonesPagedResponse>() {
            @Override
            public ApiFuture<ListZonesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListZonesRequest, ListZonesResponse> callable,
                ListZonesRequest request,
                ApiCallContext context,
                ApiFuture<ListZonesResponse> futureResponse) {
              PageContext<ListZonesRequest, ListZonesResponse, Zone> pageContext =
                  PageContext.create(callable, LIST_ZONES_PAGE_STR_DESC, request, context);
              return ListZonesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListZoneActionsRequest, ListActionsResponse, ListZoneActionsPagedResponse>
      LIST_ZONE_ACTIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListZoneActionsRequest, ListActionsResponse, ListZoneActionsPagedResponse>() {
            @Override
            public ApiFuture<ListZoneActionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListZoneActionsRequest, ListActionsResponse> callable,
                ListZoneActionsRequest request,
                ApiCallContext context,
                ApiFuture<ListActionsResponse> futureResponse) {
              PageContext<ListZoneActionsRequest, ListActionsResponse, Action> pageContext =
                  PageContext.create(callable, LIST_ZONE_ACTIONS_PAGE_STR_DESC, request, context);
              return ListZoneActionsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListAssetsRequest, ListAssetsResponse, ListAssetsPagedResponse>
      LIST_ASSETS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAssetsRequest, ListAssetsResponse, ListAssetsPagedResponse>() {
            @Override
            public ApiFuture<ListAssetsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAssetsRequest, ListAssetsResponse> callable,
                ListAssetsRequest request,
                ApiCallContext context,
                ApiFuture<ListAssetsResponse> futureResponse) {
              PageContext<ListAssetsRequest, ListAssetsResponse, Asset> pageContext =
                  PageContext.create(callable, LIST_ASSETS_PAGE_STR_DESC, request, context);
              return ListAssetsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListAssetActionsRequest, ListActionsResponse, ListAssetActionsPagedResponse>
      LIST_ASSET_ACTIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAssetActionsRequest, ListActionsResponse, ListAssetActionsPagedResponse>() {
            @Override
            public ApiFuture<ListAssetActionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAssetActionsRequest, ListActionsResponse> callable,
                ListAssetActionsRequest request,
                ApiCallContext context,
                ApiFuture<ListActionsResponse> futureResponse) {
              PageContext<ListAssetActionsRequest, ListActionsResponse, Action> pageContext =
                  PageContext.create(callable, LIST_ASSET_ACTIONS_PAGE_STR_DESC, request, context);
              return ListAssetActionsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListTasksRequest, ListTasksResponse, ListTasksPagedResponse>
      LIST_TASKS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListTasksRequest, ListTasksResponse, ListTasksPagedResponse>() {
            @Override
            public ApiFuture<ListTasksPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListTasksRequest, ListTasksResponse> callable,
                ListTasksRequest request,
                ApiCallContext context,
                ApiFuture<ListTasksResponse> futureResponse) {
              PageContext<ListTasksRequest, ListTasksResponse, Task> pageContext =
                  PageContext.create(callable, LIST_TASKS_PAGE_STR_DESC, request, context);
              return ListTasksPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListJobsRequest, ListJobsResponse, ListJobsPagedResponse>
      LIST_JOBS_PAGE_STR_FACT =
          new PagedListResponseFactory<ListJobsRequest, ListJobsResponse, ListJobsPagedResponse>() {
            @Override
            public ApiFuture<ListJobsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListJobsRequest, ListJobsResponse> callable,
                ListJobsRequest request,
                ApiCallContext context,
                ApiFuture<ListJobsResponse> futureResponse) {
              PageContext<ListJobsRequest, ListJobsResponse, Job> pageContext =
                  PageContext.create(callable, LIST_JOBS_PAGE_STR_DESC, request, context);
              return ListJobsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListEnvironmentsRequest, ListEnvironmentsResponse, ListEnvironmentsPagedResponse>
      LIST_ENVIRONMENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListEnvironmentsRequest, ListEnvironmentsResponse, ListEnvironmentsPagedResponse>() {
            @Override
            public ApiFuture<ListEnvironmentsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListEnvironmentsRequest, ListEnvironmentsResponse> callable,
                ListEnvironmentsRequest request,
                ApiCallContext context,
                ApiFuture<ListEnvironmentsResponse> futureResponse) {
              PageContext<ListEnvironmentsRequest, ListEnvironmentsResponse, Environment>
                  pageContext =
                      PageContext.create(
                          callable, LIST_ENVIRONMENTS_PAGE_STR_DESC, request, context);
              return ListEnvironmentsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListSessionsRequest, ListSessionsResponse, ListSessionsPagedResponse>
      LIST_SESSIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListSessionsRequest, ListSessionsResponse, ListSessionsPagedResponse>() {
            @Override
            public ApiFuture<ListSessionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListSessionsRequest, ListSessionsResponse> callable,
                ListSessionsRequest request,
                ApiCallContext context,
                ApiFuture<ListSessionsResponse> futureResponse) {
              PageContext<ListSessionsRequest, ListSessionsResponse, Session> pageContext =
                  PageContext.create(callable, LIST_SESSIONS_PAGE_STR_DESC, request, context);
              return ListSessionsPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to createLake. */
  public UnaryCallSettings<CreateLakeRequest, Operation> createLakeSettings() {
    return createLakeSettings;
  }

  /** Returns the object with the settings used for calls to createLake. */
  public OperationCallSettings<CreateLakeRequest, Lake, OperationMetadata>
      createLakeOperationSettings() {
    return createLakeOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateLake. */
  public UnaryCallSettings<UpdateLakeRequest, Operation> updateLakeSettings() {
    return updateLakeSettings;
  }

  /** Returns the object with the settings used for calls to updateLake. */
  public OperationCallSettings<UpdateLakeRequest, Lake, OperationMetadata>
      updateLakeOperationSettings() {
    return updateLakeOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteLake. */
  public UnaryCallSettings<DeleteLakeRequest, Operation> deleteLakeSettings() {
    return deleteLakeSettings;
  }

  /** Returns the object with the settings used for calls to deleteLake. */
  public OperationCallSettings<DeleteLakeRequest, Empty, OperationMetadata>
      deleteLakeOperationSettings() {
    return deleteLakeOperationSettings;
  }

  /** Returns the object with the settings used for calls to listLakes. */
  public PagedCallSettings<ListLakesRequest, ListLakesResponse, ListLakesPagedResponse>
      listLakesSettings() {
    return listLakesSettings;
  }

  /** Returns the object with the settings used for calls to getLake. */
  public UnaryCallSettings<GetLakeRequest, Lake> getLakeSettings() {
    return getLakeSettings;
  }

  /** Returns the object with the settings used for calls to listLakeActions. */
  public PagedCallSettings<
          ListLakeActionsRequest, ListActionsResponse, ListLakeActionsPagedResponse>
      listLakeActionsSettings() {
    return listLakeActionsSettings;
  }

  /** Returns the object with the settings used for calls to createZone. */
  public UnaryCallSettings<CreateZoneRequest, Operation> createZoneSettings() {
    return createZoneSettings;
  }

  /** Returns the object with the settings used for calls to createZone. */
  public OperationCallSettings<CreateZoneRequest, Zone, OperationMetadata>
      createZoneOperationSettings() {
    return createZoneOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateZone. */
  public UnaryCallSettings<UpdateZoneRequest, Operation> updateZoneSettings() {
    return updateZoneSettings;
  }

  /** Returns the object with the settings used for calls to updateZone. */
  public OperationCallSettings<UpdateZoneRequest, Zone, OperationMetadata>
      updateZoneOperationSettings() {
    return updateZoneOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteZone. */
  public UnaryCallSettings<DeleteZoneRequest, Operation> deleteZoneSettings() {
    return deleteZoneSettings;
  }

  /** Returns the object with the settings used for calls to deleteZone. */
  public OperationCallSettings<DeleteZoneRequest, Empty, OperationMetadata>
      deleteZoneOperationSettings() {
    return deleteZoneOperationSettings;
  }

  /** Returns the object with the settings used for calls to listZones. */
  public PagedCallSettings<ListZonesRequest, ListZonesResponse, ListZonesPagedResponse>
      listZonesSettings() {
    return listZonesSettings;
  }

  /** Returns the object with the settings used for calls to getZone. */
  public UnaryCallSettings<GetZoneRequest, Zone> getZoneSettings() {
    return getZoneSettings;
  }

  /** Returns the object with the settings used for calls to listZoneActions. */
  public PagedCallSettings<
          ListZoneActionsRequest, ListActionsResponse, ListZoneActionsPagedResponse>
      listZoneActionsSettings() {
    return listZoneActionsSettings;
  }

  /** Returns the object with the settings used for calls to createAsset. */
  public UnaryCallSettings<CreateAssetRequest, Operation> createAssetSettings() {
    return createAssetSettings;
  }

  /** Returns the object with the settings used for calls to createAsset. */
  public OperationCallSettings<CreateAssetRequest, Asset, OperationMetadata>
      createAssetOperationSettings() {
    return createAssetOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateAsset. */
  public UnaryCallSettings<UpdateAssetRequest, Operation> updateAssetSettings() {
    return updateAssetSettings;
  }

  /** Returns the object with the settings used for calls to updateAsset. */
  public OperationCallSettings<UpdateAssetRequest, Asset, OperationMetadata>
      updateAssetOperationSettings() {
    return updateAssetOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteAsset. */
  public UnaryCallSettings<DeleteAssetRequest, Operation> deleteAssetSettings() {
    return deleteAssetSettings;
  }

  /** Returns the object with the settings used for calls to deleteAsset. */
  public OperationCallSettings<DeleteAssetRequest, Empty, OperationMetadata>
      deleteAssetOperationSettings() {
    return deleteAssetOperationSettings;
  }

  /** Returns the object with the settings used for calls to listAssets. */
  public PagedCallSettings<ListAssetsRequest, ListAssetsResponse, ListAssetsPagedResponse>
      listAssetsSettings() {
    return listAssetsSettings;
  }

  /** Returns the object with the settings used for calls to getAsset. */
  public UnaryCallSettings<GetAssetRequest, Asset> getAssetSettings() {
    return getAssetSettings;
  }

  /** Returns the object with the settings used for calls to listAssetActions. */
  public PagedCallSettings<
          ListAssetActionsRequest, ListActionsResponse, ListAssetActionsPagedResponse>
      listAssetActionsSettings() {
    return listAssetActionsSettings;
  }

  /** Returns the object with the settings used for calls to createTask. */
  public UnaryCallSettings<CreateTaskRequest, Operation> createTaskSettings() {
    return createTaskSettings;
  }

  /** Returns the object with the settings used for calls to createTask. */
  public OperationCallSettings<CreateTaskRequest, Task, OperationMetadata>
      createTaskOperationSettings() {
    return createTaskOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateTask. */
  public UnaryCallSettings<UpdateTaskRequest, Operation> updateTaskSettings() {
    return updateTaskSettings;
  }

  /** Returns the object with the settings used for calls to updateTask. */
  public OperationCallSettings<UpdateTaskRequest, Task, OperationMetadata>
      updateTaskOperationSettings() {
    return updateTaskOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteTask. */
  public UnaryCallSettings<DeleteTaskRequest, Operation> deleteTaskSettings() {
    return deleteTaskSettings;
  }

  /** Returns the object with the settings used for calls to deleteTask. */
  public OperationCallSettings<DeleteTaskRequest, Empty, OperationMetadata>
      deleteTaskOperationSettings() {
    return deleteTaskOperationSettings;
  }

  /** Returns the object with the settings used for calls to listTasks. */
  public PagedCallSettings<ListTasksRequest, ListTasksResponse, ListTasksPagedResponse>
      listTasksSettings() {
    return listTasksSettings;
  }

  /** Returns the object with the settings used for calls to getTask. */
  public UnaryCallSettings<GetTaskRequest, Task> getTaskSettings() {
    return getTaskSettings;
  }

  /** Returns the object with the settings used for calls to listJobs. */
  public PagedCallSettings<ListJobsRequest, ListJobsResponse, ListJobsPagedResponse>
      listJobsSettings() {
    return listJobsSettings;
  }

  /** Returns the object with the settings used for calls to getJob. */
  public UnaryCallSettings<GetJobRequest, Job> getJobSettings() {
    return getJobSettings;
  }

  /** Returns the object with the settings used for calls to cancelJob. */
  public UnaryCallSettings<CancelJobRequest, Empty> cancelJobSettings() {
    return cancelJobSettings;
  }

  /** Returns the object with the settings used for calls to createEnvironment. */
  public UnaryCallSettings<CreateEnvironmentRequest, Operation> createEnvironmentSettings() {
    return createEnvironmentSettings;
  }

  /** Returns the object with the settings used for calls to createEnvironment. */
  public OperationCallSettings<CreateEnvironmentRequest, Environment, OperationMetadata>
      createEnvironmentOperationSettings() {
    return createEnvironmentOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateEnvironment. */
  public UnaryCallSettings<UpdateEnvironmentRequest, Operation> updateEnvironmentSettings() {
    return updateEnvironmentSettings;
  }

  /** Returns the object with the settings used for calls to updateEnvironment. */
  public OperationCallSettings<UpdateEnvironmentRequest, Environment, OperationMetadata>
      updateEnvironmentOperationSettings() {
    return updateEnvironmentOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteEnvironment. */
  public UnaryCallSettings<DeleteEnvironmentRequest, Operation> deleteEnvironmentSettings() {
    return deleteEnvironmentSettings;
  }

  /** Returns the object with the settings used for calls to deleteEnvironment. */
  public OperationCallSettings<DeleteEnvironmentRequest, Empty, OperationMetadata>
      deleteEnvironmentOperationSettings() {
    return deleteEnvironmentOperationSettings;
  }

  /** Returns the object with the settings used for calls to listEnvironments. */
  public PagedCallSettings<
          ListEnvironmentsRequest, ListEnvironmentsResponse, ListEnvironmentsPagedResponse>
      listEnvironmentsSettings() {
    return listEnvironmentsSettings;
  }

  /** Returns the object with the settings used for calls to getEnvironment. */
  public UnaryCallSettings<GetEnvironmentRequest, Environment> getEnvironmentSettings() {
    return getEnvironmentSettings;
  }

  /** Returns the object with the settings used for calls to listSessions. */
  public PagedCallSettings<ListSessionsRequest, ListSessionsResponse, ListSessionsPagedResponse>
      listSessionsSettings() {
    return listSessionsSettings;
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

  public DataplexServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcDataplexServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonDataplexServiceStub.create(this);
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
    return "dataplex.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "dataplex.mtls.googleapis.com:443";
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

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(DataplexServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(DataplexServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DataplexServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected DataplexServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createLakeSettings = settingsBuilder.createLakeSettings().build();
    createLakeOperationSettings = settingsBuilder.createLakeOperationSettings().build();
    updateLakeSettings = settingsBuilder.updateLakeSettings().build();
    updateLakeOperationSettings = settingsBuilder.updateLakeOperationSettings().build();
    deleteLakeSettings = settingsBuilder.deleteLakeSettings().build();
    deleteLakeOperationSettings = settingsBuilder.deleteLakeOperationSettings().build();
    listLakesSettings = settingsBuilder.listLakesSettings().build();
    getLakeSettings = settingsBuilder.getLakeSettings().build();
    listLakeActionsSettings = settingsBuilder.listLakeActionsSettings().build();
    createZoneSettings = settingsBuilder.createZoneSettings().build();
    createZoneOperationSettings = settingsBuilder.createZoneOperationSettings().build();
    updateZoneSettings = settingsBuilder.updateZoneSettings().build();
    updateZoneOperationSettings = settingsBuilder.updateZoneOperationSettings().build();
    deleteZoneSettings = settingsBuilder.deleteZoneSettings().build();
    deleteZoneOperationSettings = settingsBuilder.deleteZoneOperationSettings().build();
    listZonesSettings = settingsBuilder.listZonesSettings().build();
    getZoneSettings = settingsBuilder.getZoneSettings().build();
    listZoneActionsSettings = settingsBuilder.listZoneActionsSettings().build();
    createAssetSettings = settingsBuilder.createAssetSettings().build();
    createAssetOperationSettings = settingsBuilder.createAssetOperationSettings().build();
    updateAssetSettings = settingsBuilder.updateAssetSettings().build();
    updateAssetOperationSettings = settingsBuilder.updateAssetOperationSettings().build();
    deleteAssetSettings = settingsBuilder.deleteAssetSettings().build();
    deleteAssetOperationSettings = settingsBuilder.deleteAssetOperationSettings().build();
    listAssetsSettings = settingsBuilder.listAssetsSettings().build();
    getAssetSettings = settingsBuilder.getAssetSettings().build();
    listAssetActionsSettings = settingsBuilder.listAssetActionsSettings().build();
    createTaskSettings = settingsBuilder.createTaskSettings().build();
    createTaskOperationSettings = settingsBuilder.createTaskOperationSettings().build();
    updateTaskSettings = settingsBuilder.updateTaskSettings().build();
    updateTaskOperationSettings = settingsBuilder.updateTaskOperationSettings().build();
    deleteTaskSettings = settingsBuilder.deleteTaskSettings().build();
    deleteTaskOperationSettings = settingsBuilder.deleteTaskOperationSettings().build();
    listTasksSettings = settingsBuilder.listTasksSettings().build();
    getTaskSettings = settingsBuilder.getTaskSettings().build();
    listJobsSettings = settingsBuilder.listJobsSettings().build();
    getJobSettings = settingsBuilder.getJobSettings().build();
    cancelJobSettings = settingsBuilder.cancelJobSettings().build();
    createEnvironmentSettings = settingsBuilder.createEnvironmentSettings().build();
    createEnvironmentOperationSettings =
        settingsBuilder.createEnvironmentOperationSettings().build();
    updateEnvironmentSettings = settingsBuilder.updateEnvironmentSettings().build();
    updateEnvironmentOperationSettings =
        settingsBuilder.updateEnvironmentOperationSettings().build();
    deleteEnvironmentSettings = settingsBuilder.deleteEnvironmentSettings().build();
    deleteEnvironmentOperationSettings =
        settingsBuilder.deleteEnvironmentOperationSettings().build();
    listEnvironmentsSettings = settingsBuilder.listEnvironmentsSettings().build();
    getEnvironmentSettings = settingsBuilder.getEnvironmentSettings().build();
    listSessionsSettings = settingsBuilder.listSessionsSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  /** Builder for DataplexServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<DataplexServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateLakeRequest, Operation> createLakeSettings;
    private final OperationCallSettings.Builder<CreateLakeRequest, Lake, OperationMetadata>
        createLakeOperationSettings;
    private final UnaryCallSettings.Builder<UpdateLakeRequest, Operation> updateLakeSettings;
    private final OperationCallSettings.Builder<UpdateLakeRequest, Lake, OperationMetadata>
        updateLakeOperationSettings;
    private final UnaryCallSettings.Builder<DeleteLakeRequest, Operation> deleteLakeSettings;
    private final OperationCallSettings.Builder<DeleteLakeRequest, Empty, OperationMetadata>
        deleteLakeOperationSettings;
    private final PagedCallSettings.Builder<
            ListLakesRequest, ListLakesResponse, ListLakesPagedResponse>
        listLakesSettings;
    private final UnaryCallSettings.Builder<GetLakeRequest, Lake> getLakeSettings;
    private final PagedCallSettings.Builder<
            ListLakeActionsRequest, ListActionsResponse, ListLakeActionsPagedResponse>
        listLakeActionsSettings;
    private final UnaryCallSettings.Builder<CreateZoneRequest, Operation> createZoneSettings;
    private final OperationCallSettings.Builder<CreateZoneRequest, Zone, OperationMetadata>
        createZoneOperationSettings;
    private final UnaryCallSettings.Builder<UpdateZoneRequest, Operation> updateZoneSettings;
    private final OperationCallSettings.Builder<UpdateZoneRequest, Zone, OperationMetadata>
        updateZoneOperationSettings;
    private final UnaryCallSettings.Builder<DeleteZoneRequest, Operation> deleteZoneSettings;
    private final OperationCallSettings.Builder<DeleteZoneRequest, Empty, OperationMetadata>
        deleteZoneOperationSettings;
    private final PagedCallSettings.Builder<
            ListZonesRequest, ListZonesResponse, ListZonesPagedResponse>
        listZonesSettings;
    private final UnaryCallSettings.Builder<GetZoneRequest, Zone> getZoneSettings;
    private final PagedCallSettings.Builder<
            ListZoneActionsRequest, ListActionsResponse, ListZoneActionsPagedResponse>
        listZoneActionsSettings;
    private final UnaryCallSettings.Builder<CreateAssetRequest, Operation> createAssetSettings;
    private final OperationCallSettings.Builder<CreateAssetRequest, Asset, OperationMetadata>
        createAssetOperationSettings;
    private final UnaryCallSettings.Builder<UpdateAssetRequest, Operation> updateAssetSettings;
    private final OperationCallSettings.Builder<UpdateAssetRequest, Asset, OperationMetadata>
        updateAssetOperationSettings;
    private final UnaryCallSettings.Builder<DeleteAssetRequest, Operation> deleteAssetSettings;
    private final OperationCallSettings.Builder<DeleteAssetRequest, Empty, OperationMetadata>
        deleteAssetOperationSettings;
    private final PagedCallSettings.Builder<
            ListAssetsRequest, ListAssetsResponse, ListAssetsPagedResponse>
        listAssetsSettings;
    private final UnaryCallSettings.Builder<GetAssetRequest, Asset> getAssetSettings;
    private final PagedCallSettings.Builder<
            ListAssetActionsRequest, ListActionsResponse, ListAssetActionsPagedResponse>
        listAssetActionsSettings;
    private final UnaryCallSettings.Builder<CreateTaskRequest, Operation> createTaskSettings;
    private final OperationCallSettings.Builder<CreateTaskRequest, Task, OperationMetadata>
        createTaskOperationSettings;
    private final UnaryCallSettings.Builder<UpdateTaskRequest, Operation> updateTaskSettings;
    private final OperationCallSettings.Builder<UpdateTaskRequest, Task, OperationMetadata>
        updateTaskOperationSettings;
    private final UnaryCallSettings.Builder<DeleteTaskRequest, Operation> deleteTaskSettings;
    private final OperationCallSettings.Builder<DeleteTaskRequest, Empty, OperationMetadata>
        deleteTaskOperationSettings;
    private final PagedCallSettings.Builder<
            ListTasksRequest, ListTasksResponse, ListTasksPagedResponse>
        listTasksSettings;
    private final UnaryCallSettings.Builder<GetTaskRequest, Task> getTaskSettings;
    private final PagedCallSettings.Builder<
            ListJobsRequest, ListJobsResponse, ListJobsPagedResponse>
        listJobsSettings;
    private final UnaryCallSettings.Builder<GetJobRequest, Job> getJobSettings;
    private final UnaryCallSettings.Builder<CancelJobRequest, Empty> cancelJobSettings;
    private final UnaryCallSettings.Builder<CreateEnvironmentRequest, Operation>
        createEnvironmentSettings;
    private final OperationCallSettings.Builder<
            CreateEnvironmentRequest, Environment, OperationMetadata>
        createEnvironmentOperationSettings;
    private final UnaryCallSettings.Builder<UpdateEnvironmentRequest, Operation>
        updateEnvironmentSettings;
    private final OperationCallSettings.Builder<
            UpdateEnvironmentRequest, Environment, OperationMetadata>
        updateEnvironmentOperationSettings;
    private final UnaryCallSettings.Builder<DeleteEnvironmentRequest, Operation>
        deleteEnvironmentSettings;
    private final OperationCallSettings.Builder<DeleteEnvironmentRequest, Empty, OperationMetadata>
        deleteEnvironmentOperationSettings;
    private final PagedCallSettings.Builder<
            ListEnvironmentsRequest, ListEnvironmentsResponse, ListEnvironmentsPagedResponse>
        listEnvironmentsSettings;
    private final UnaryCallSettings.Builder<GetEnvironmentRequest, Environment>
        getEnvironmentSettings;
    private final PagedCallSettings.Builder<
            ListSessionsRequest, ListSessionsResponse, ListSessionsPagedResponse>
        listSessionsSettings;
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
          "no_retry_6_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "retry_policy_1_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_6_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(10000L))
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_1_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(10000L))
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createLakeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createLakeOperationSettings = OperationCallSettings.newBuilder();
      updateLakeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateLakeOperationSettings = OperationCallSettings.newBuilder();
      deleteLakeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteLakeOperationSettings = OperationCallSettings.newBuilder();
      listLakesSettings = PagedCallSettings.newBuilder(LIST_LAKES_PAGE_STR_FACT);
      getLakeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listLakeActionsSettings = PagedCallSettings.newBuilder(LIST_LAKE_ACTIONS_PAGE_STR_FACT);
      createZoneSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createZoneOperationSettings = OperationCallSettings.newBuilder();
      updateZoneSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateZoneOperationSettings = OperationCallSettings.newBuilder();
      deleteZoneSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteZoneOperationSettings = OperationCallSettings.newBuilder();
      listZonesSettings = PagedCallSettings.newBuilder(LIST_ZONES_PAGE_STR_FACT);
      getZoneSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listZoneActionsSettings = PagedCallSettings.newBuilder(LIST_ZONE_ACTIONS_PAGE_STR_FACT);
      createAssetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createAssetOperationSettings = OperationCallSettings.newBuilder();
      updateAssetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateAssetOperationSettings = OperationCallSettings.newBuilder();
      deleteAssetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteAssetOperationSettings = OperationCallSettings.newBuilder();
      listAssetsSettings = PagedCallSettings.newBuilder(LIST_ASSETS_PAGE_STR_FACT);
      getAssetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listAssetActionsSettings = PagedCallSettings.newBuilder(LIST_ASSET_ACTIONS_PAGE_STR_FACT);
      createTaskSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createTaskOperationSettings = OperationCallSettings.newBuilder();
      updateTaskSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateTaskOperationSettings = OperationCallSettings.newBuilder();
      deleteTaskSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteTaskOperationSettings = OperationCallSettings.newBuilder();
      listTasksSettings = PagedCallSettings.newBuilder(LIST_TASKS_PAGE_STR_FACT);
      getTaskSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listJobsSettings = PagedCallSettings.newBuilder(LIST_JOBS_PAGE_STR_FACT);
      getJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      cancelJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createEnvironmentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createEnvironmentOperationSettings = OperationCallSettings.newBuilder();
      updateEnvironmentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateEnvironmentOperationSettings = OperationCallSettings.newBuilder();
      deleteEnvironmentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteEnvironmentOperationSettings = OperationCallSettings.newBuilder();
      listEnvironmentsSettings = PagedCallSettings.newBuilder(LIST_ENVIRONMENTS_PAGE_STR_FACT);
      getEnvironmentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listSessionsSettings = PagedCallSettings.newBuilder(LIST_SESSIONS_PAGE_STR_FACT);
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createLakeSettings,
              updateLakeSettings,
              deleteLakeSettings,
              listLakesSettings,
              getLakeSettings,
              listLakeActionsSettings,
              createZoneSettings,
              updateZoneSettings,
              deleteZoneSettings,
              listZonesSettings,
              getZoneSettings,
              listZoneActionsSettings,
              createAssetSettings,
              updateAssetSettings,
              deleteAssetSettings,
              listAssetsSettings,
              getAssetSettings,
              listAssetActionsSettings,
              createTaskSettings,
              updateTaskSettings,
              deleteTaskSettings,
              listTasksSettings,
              getTaskSettings,
              listJobsSettings,
              getJobSettings,
              cancelJobSettings,
              createEnvironmentSettings,
              updateEnvironmentSettings,
              deleteEnvironmentSettings,
              listEnvironmentsSettings,
              getEnvironmentSettings,
              listSessionsSettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(DataplexServiceStubSettings settings) {
      super(settings);

      createLakeSettings = settings.createLakeSettings.toBuilder();
      createLakeOperationSettings = settings.createLakeOperationSettings.toBuilder();
      updateLakeSettings = settings.updateLakeSettings.toBuilder();
      updateLakeOperationSettings = settings.updateLakeOperationSettings.toBuilder();
      deleteLakeSettings = settings.deleteLakeSettings.toBuilder();
      deleteLakeOperationSettings = settings.deleteLakeOperationSettings.toBuilder();
      listLakesSettings = settings.listLakesSettings.toBuilder();
      getLakeSettings = settings.getLakeSettings.toBuilder();
      listLakeActionsSettings = settings.listLakeActionsSettings.toBuilder();
      createZoneSettings = settings.createZoneSettings.toBuilder();
      createZoneOperationSettings = settings.createZoneOperationSettings.toBuilder();
      updateZoneSettings = settings.updateZoneSettings.toBuilder();
      updateZoneOperationSettings = settings.updateZoneOperationSettings.toBuilder();
      deleteZoneSettings = settings.deleteZoneSettings.toBuilder();
      deleteZoneOperationSettings = settings.deleteZoneOperationSettings.toBuilder();
      listZonesSettings = settings.listZonesSettings.toBuilder();
      getZoneSettings = settings.getZoneSettings.toBuilder();
      listZoneActionsSettings = settings.listZoneActionsSettings.toBuilder();
      createAssetSettings = settings.createAssetSettings.toBuilder();
      createAssetOperationSettings = settings.createAssetOperationSettings.toBuilder();
      updateAssetSettings = settings.updateAssetSettings.toBuilder();
      updateAssetOperationSettings = settings.updateAssetOperationSettings.toBuilder();
      deleteAssetSettings = settings.deleteAssetSettings.toBuilder();
      deleteAssetOperationSettings = settings.deleteAssetOperationSettings.toBuilder();
      listAssetsSettings = settings.listAssetsSettings.toBuilder();
      getAssetSettings = settings.getAssetSettings.toBuilder();
      listAssetActionsSettings = settings.listAssetActionsSettings.toBuilder();
      createTaskSettings = settings.createTaskSettings.toBuilder();
      createTaskOperationSettings = settings.createTaskOperationSettings.toBuilder();
      updateTaskSettings = settings.updateTaskSettings.toBuilder();
      updateTaskOperationSettings = settings.updateTaskOperationSettings.toBuilder();
      deleteTaskSettings = settings.deleteTaskSettings.toBuilder();
      deleteTaskOperationSettings = settings.deleteTaskOperationSettings.toBuilder();
      listTasksSettings = settings.listTasksSettings.toBuilder();
      getTaskSettings = settings.getTaskSettings.toBuilder();
      listJobsSettings = settings.listJobsSettings.toBuilder();
      getJobSettings = settings.getJobSettings.toBuilder();
      cancelJobSettings = settings.cancelJobSettings.toBuilder();
      createEnvironmentSettings = settings.createEnvironmentSettings.toBuilder();
      createEnvironmentOperationSettings = settings.createEnvironmentOperationSettings.toBuilder();
      updateEnvironmentSettings = settings.updateEnvironmentSettings.toBuilder();
      updateEnvironmentOperationSettings = settings.updateEnvironmentOperationSettings.toBuilder();
      deleteEnvironmentSettings = settings.deleteEnvironmentSettings.toBuilder();
      deleteEnvironmentOperationSettings = settings.deleteEnvironmentOperationSettings.toBuilder();
      listEnvironmentsSettings = settings.listEnvironmentsSettings.toBuilder();
      getEnvironmentSettings = settings.getEnvironmentSettings.toBuilder();
      listSessionsSettings = settings.listSessionsSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createLakeSettings,
              updateLakeSettings,
              deleteLakeSettings,
              listLakesSettings,
              getLakeSettings,
              listLakeActionsSettings,
              createZoneSettings,
              updateZoneSettings,
              deleteZoneSettings,
              listZonesSettings,
              getZoneSettings,
              listZoneActionsSettings,
              createAssetSettings,
              updateAssetSettings,
              deleteAssetSettings,
              listAssetsSettings,
              getAssetSettings,
              listAssetActionsSettings,
              createTaskSettings,
              updateTaskSettings,
              deleteTaskSettings,
              listTasksSettings,
              getTaskSettings,
              listJobsSettings,
              getJobSettings,
              cancelJobSettings,
              createEnvironmentSettings,
              updateEnvironmentSettings,
              deleteEnvironmentSettings,
              listEnvironmentsSettings,
              getEnvironmentSettings,
              listSessionsSettings,
              listLocationsSettings,
              getLocationSettings);
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

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .createLakeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_6_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_6_params"));

      builder
          .updateLakeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_6_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_6_params"));

      builder
          .deleteLakeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_6_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_6_params"));

      builder
          .listLakesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .getLakeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listLakeActionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .createZoneSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_6_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_6_params"));

      builder
          .updateZoneSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_6_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_6_params"));

      builder
          .deleteZoneSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_6_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_6_params"));

      builder
          .listZonesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .getZoneSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listZoneActionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .createAssetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_6_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_6_params"));

      builder
          .updateAssetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_6_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_6_params"));

      builder
          .deleteAssetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_6_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_6_params"));

      builder
          .listAssetsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .getAssetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listAssetActionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .createTaskSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_6_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_6_params"));

      builder
          .updateTaskSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_6_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_6_params"));

      builder
          .deleteTaskSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_6_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_6_params"));

      builder
          .listTasksSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .getTaskSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listJobsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .getJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .cancelJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_6_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_6_params"));

      builder
          .createEnvironmentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_6_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_6_params"));

      builder
          .updateEnvironmentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_6_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_6_params"));

      builder
          .deleteEnvironmentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_6_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_6_params"));

      builder
          .listEnvironmentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .getEnvironmentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listSessionsSettings()
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
          .createLakeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<CreateLakeRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_6_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_6_params"))
                  .build())
          .setResponseTransformer(ProtoOperationTransformers.ResponseTransformer.create(Lake.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .updateLakeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<UpdateLakeRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_6_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_6_params"))
                  .build())
          .setResponseTransformer(ProtoOperationTransformers.ResponseTransformer.create(Lake.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .deleteLakeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<DeleteLakeRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_6_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_6_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .createZoneOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<CreateZoneRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_6_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_6_params"))
                  .build())
          .setResponseTransformer(ProtoOperationTransformers.ResponseTransformer.create(Zone.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .updateZoneOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<UpdateZoneRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_6_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_6_params"))
                  .build())
          .setResponseTransformer(ProtoOperationTransformers.ResponseTransformer.create(Zone.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .deleteZoneOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<DeleteZoneRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_6_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_6_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .createAssetOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<CreateAssetRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_6_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_6_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Asset.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .updateAssetOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<UpdateAssetRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_6_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_6_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Asset.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .deleteAssetOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<DeleteAssetRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_6_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_6_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .createTaskOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<CreateTaskRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_6_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_6_params"))
                  .build())
          .setResponseTransformer(ProtoOperationTransformers.ResponseTransformer.create(Task.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .updateTaskOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<UpdateTaskRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_6_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_6_params"))
                  .build())
          .setResponseTransformer(ProtoOperationTransformers.ResponseTransformer.create(Task.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .deleteTaskOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<DeleteTaskRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_6_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_6_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .createEnvironmentOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateEnvironmentRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_6_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_6_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Environment.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .updateEnvironmentOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateEnvironmentRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_6_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_6_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Environment.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .deleteEnvironmentOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteEnvironmentRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_6_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_6_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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

    /** Returns the builder for the settings used for calls to createLake. */
    public UnaryCallSettings.Builder<CreateLakeRequest, Operation> createLakeSettings() {
      return createLakeSettings;
    }

    /** Returns the builder for the settings used for calls to createLake. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateLakeRequest, Lake, OperationMetadata>
        createLakeOperationSettings() {
      return createLakeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateLake. */
    public UnaryCallSettings.Builder<UpdateLakeRequest, Operation> updateLakeSettings() {
      return updateLakeSettings;
    }

    /** Returns the builder for the settings used for calls to updateLake. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpdateLakeRequest, Lake, OperationMetadata>
        updateLakeOperationSettings() {
      return updateLakeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteLake. */
    public UnaryCallSettings.Builder<DeleteLakeRequest, Operation> deleteLakeSettings() {
      return deleteLakeSettings;
    }

    /** Returns the builder for the settings used for calls to deleteLake. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteLakeRequest, Empty, OperationMetadata>
        deleteLakeOperationSettings() {
      return deleteLakeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listLakes. */
    public PagedCallSettings.Builder<ListLakesRequest, ListLakesResponse, ListLakesPagedResponse>
        listLakesSettings() {
      return listLakesSettings;
    }

    /** Returns the builder for the settings used for calls to getLake. */
    public UnaryCallSettings.Builder<GetLakeRequest, Lake> getLakeSettings() {
      return getLakeSettings;
    }

    /** Returns the builder for the settings used for calls to listLakeActions. */
    public PagedCallSettings.Builder<
            ListLakeActionsRequest, ListActionsResponse, ListLakeActionsPagedResponse>
        listLakeActionsSettings() {
      return listLakeActionsSettings;
    }

    /** Returns the builder for the settings used for calls to createZone. */
    public UnaryCallSettings.Builder<CreateZoneRequest, Operation> createZoneSettings() {
      return createZoneSettings;
    }

    /** Returns the builder for the settings used for calls to createZone. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateZoneRequest, Zone, OperationMetadata>
        createZoneOperationSettings() {
      return createZoneOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateZone. */
    public UnaryCallSettings.Builder<UpdateZoneRequest, Operation> updateZoneSettings() {
      return updateZoneSettings;
    }

    /** Returns the builder for the settings used for calls to updateZone. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpdateZoneRequest, Zone, OperationMetadata>
        updateZoneOperationSettings() {
      return updateZoneOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteZone. */
    public UnaryCallSettings.Builder<DeleteZoneRequest, Operation> deleteZoneSettings() {
      return deleteZoneSettings;
    }

    /** Returns the builder for the settings used for calls to deleteZone. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteZoneRequest, Empty, OperationMetadata>
        deleteZoneOperationSettings() {
      return deleteZoneOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listZones. */
    public PagedCallSettings.Builder<ListZonesRequest, ListZonesResponse, ListZonesPagedResponse>
        listZonesSettings() {
      return listZonesSettings;
    }

    /** Returns the builder for the settings used for calls to getZone. */
    public UnaryCallSettings.Builder<GetZoneRequest, Zone> getZoneSettings() {
      return getZoneSettings;
    }

    /** Returns the builder for the settings used for calls to listZoneActions. */
    public PagedCallSettings.Builder<
            ListZoneActionsRequest, ListActionsResponse, ListZoneActionsPagedResponse>
        listZoneActionsSettings() {
      return listZoneActionsSettings;
    }

    /** Returns the builder for the settings used for calls to createAsset. */
    public UnaryCallSettings.Builder<CreateAssetRequest, Operation> createAssetSettings() {
      return createAssetSettings;
    }

    /** Returns the builder for the settings used for calls to createAsset. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateAssetRequest, Asset, OperationMetadata>
        createAssetOperationSettings() {
      return createAssetOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateAsset. */
    public UnaryCallSettings.Builder<UpdateAssetRequest, Operation> updateAssetSettings() {
      return updateAssetSettings;
    }

    /** Returns the builder for the settings used for calls to updateAsset. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpdateAssetRequest, Asset, OperationMetadata>
        updateAssetOperationSettings() {
      return updateAssetOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAsset. */
    public UnaryCallSettings.Builder<DeleteAssetRequest, Operation> deleteAssetSettings() {
      return deleteAssetSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAsset. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteAssetRequest, Empty, OperationMetadata>
        deleteAssetOperationSettings() {
      return deleteAssetOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listAssets. */
    public PagedCallSettings.Builder<ListAssetsRequest, ListAssetsResponse, ListAssetsPagedResponse>
        listAssetsSettings() {
      return listAssetsSettings;
    }

    /** Returns the builder for the settings used for calls to getAsset. */
    public UnaryCallSettings.Builder<GetAssetRequest, Asset> getAssetSettings() {
      return getAssetSettings;
    }

    /** Returns the builder for the settings used for calls to listAssetActions. */
    public PagedCallSettings.Builder<
            ListAssetActionsRequest, ListActionsResponse, ListAssetActionsPagedResponse>
        listAssetActionsSettings() {
      return listAssetActionsSettings;
    }

    /** Returns the builder for the settings used for calls to createTask. */
    public UnaryCallSettings.Builder<CreateTaskRequest, Operation> createTaskSettings() {
      return createTaskSettings;
    }

    /** Returns the builder for the settings used for calls to createTask. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateTaskRequest, Task, OperationMetadata>
        createTaskOperationSettings() {
      return createTaskOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateTask. */
    public UnaryCallSettings.Builder<UpdateTaskRequest, Operation> updateTaskSettings() {
      return updateTaskSettings;
    }

    /** Returns the builder for the settings used for calls to updateTask. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpdateTaskRequest, Task, OperationMetadata>
        updateTaskOperationSettings() {
      return updateTaskOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteTask. */
    public UnaryCallSettings.Builder<DeleteTaskRequest, Operation> deleteTaskSettings() {
      return deleteTaskSettings;
    }

    /** Returns the builder for the settings used for calls to deleteTask. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteTaskRequest, Empty, OperationMetadata>
        deleteTaskOperationSettings() {
      return deleteTaskOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listTasks. */
    public PagedCallSettings.Builder<ListTasksRequest, ListTasksResponse, ListTasksPagedResponse>
        listTasksSettings() {
      return listTasksSettings;
    }

    /** Returns the builder for the settings used for calls to getTask. */
    public UnaryCallSettings.Builder<GetTaskRequest, Task> getTaskSettings() {
      return getTaskSettings;
    }

    /** Returns the builder for the settings used for calls to listJobs. */
    public PagedCallSettings.Builder<ListJobsRequest, ListJobsResponse, ListJobsPagedResponse>
        listJobsSettings() {
      return listJobsSettings;
    }

    /** Returns the builder for the settings used for calls to getJob. */
    public UnaryCallSettings.Builder<GetJobRequest, Job> getJobSettings() {
      return getJobSettings;
    }

    /** Returns the builder for the settings used for calls to cancelJob. */
    public UnaryCallSettings.Builder<CancelJobRequest, Empty> cancelJobSettings() {
      return cancelJobSettings;
    }

    /** Returns the builder for the settings used for calls to createEnvironment. */
    public UnaryCallSettings.Builder<CreateEnvironmentRequest, Operation>
        createEnvironmentSettings() {
      return createEnvironmentSettings;
    }

    /** Returns the builder for the settings used for calls to createEnvironment. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateEnvironmentRequest, Environment, OperationMetadata>
        createEnvironmentOperationSettings() {
      return createEnvironmentOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateEnvironment. */
    public UnaryCallSettings.Builder<UpdateEnvironmentRequest, Operation>
        updateEnvironmentSettings() {
      return updateEnvironmentSettings;
    }

    /** Returns the builder for the settings used for calls to updateEnvironment. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpdateEnvironmentRequest, Environment, OperationMetadata>
        updateEnvironmentOperationSettings() {
      return updateEnvironmentOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteEnvironment. */
    public UnaryCallSettings.Builder<DeleteEnvironmentRequest, Operation>
        deleteEnvironmentSettings() {
      return deleteEnvironmentSettings;
    }

    /** Returns the builder for the settings used for calls to deleteEnvironment. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteEnvironmentRequest, Empty, OperationMetadata>
        deleteEnvironmentOperationSettings() {
      return deleteEnvironmentOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listEnvironments. */
    public PagedCallSettings.Builder<
            ListEnvironmentsRequest, ListEnvironmentsResponse, ListEnvironmentsPagedResponse>
        listEnvironmentsSettings() {
      return listEnvironmentsSettings;
    }

    /** Returns the builder for the settings used for calls to getEnvironment. */
    public UnaryCallSettings.Builder<GetEnvironmentRequest, Environment> getEnvironmentSettings() {
      return getEnvironmentSettings;
    }

    /** Returns the builder for the settings used for calls to listSessions. */
    public PagedCallSettings.Builder<
            ListSessionsRequest, ListSessionsResponse, ListSessionsPagedResponse>
        listSessionsSettings() {
      return listSessionsSettings;
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
    public DataplexServiceStubSettings build() throws IOException {
      return new DataplexServiceStubSettings(this);
    }
  }
}
