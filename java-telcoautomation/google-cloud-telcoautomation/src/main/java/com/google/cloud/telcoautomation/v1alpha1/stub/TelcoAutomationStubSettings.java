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

package com.google.cloud.telcoautomation.v1alpha1.stub;

import static com.google.cloud.telcoautomation.v1alpha1.TelcoAutomationClient.ListBlueprintRevisionsPagedResponse;
import static com.google.cloud.telcoautomation.v1alpha1.TelcoAutomationClient.ListBlueprintsPagedResponse;
import static com.google.cloud.telcoautomation.v1alpha1.TelcoAutomationClient.ListDeploymentRevisionsPagedResponse;
import static com.google.cloud.telcoautomation.v1alpha1.TelcoAutomationClient.ListDeploymentsPagedResponse;
import static com.google.cloud.telcoautomation.v1alpha1.TelcoAutomationClient.ListEdgeSlmsPagedResponse;
import static com.google.cloud.telcoautomation.v1alpha1.TelcoAutomationClient.ListHydratedDeploymentsPagedResponse;
import static com.google.cloud.telcoautomation.v1alpha1.TelcoAutomationClient.ListLocationsPagedResponse;
import static com.google.cloud.telcoautomation.v1alpha1.TelcoAutomationClient.ListOrchestrationClustersPagedResponse;
import static com.google.cloud.telcoautomation.v1alpha1.TelcoAutomationClient.ListPublicBlueprintsPagedResponse;
import static com.google.cloud.telcoautomation.v1alpha1.TelcoAutomationClient.SearchBlueprintRevisionsPagedResponse;
import static com.google.cloud.telcoautomation.v1alpha1.TelcoAutomationClient.SearchDeploymentRevisionsPagedResponse;

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
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.telcoautomation.v1alpha1.ApplyDeploymentRequest;
import com.google.cloud.telcoautomation.v1alpha1.ApplyHydratedDeploymentRequest;
import com.google.cloud.telcoautomation.v1alpha1.ApproveBlueprintRequest;
import com.google.cloud.telcoautomation.v1alpha1.Blueprint;
import com.google.cloud.telcoautomation.v1alpha1.ComputeDeploymentStatusRequest;
import com.google.cloud.telcoautomation.v1alpha1.ComputeDeploymentStatusResponse;
import com.google.cloud.telcoautomation.v1alpha1.CreateBlueprintRequest;
import com.google.cloud.telcoautomation.v1alpha1.CreateDeploymentRequest;
import com.google.cloud.telcoautomation.v1alpha1.CreateEdgeSlmRequest;
import com.google.cloud.telcoautomation.v1alpha1.CreateOrchestrationClusterRequest;
import com.google.cloud.telcoautomation.v1alpha1.DeleteBlueprintRequest;
import com.google.cloud.telcoautomation.v1alpha1.DeleteEdgeSlmRequest;
import com.google.cloud.telcoautomation.v1alpha1.DeleteOrchestrationClusterRequest;
import com.google.cloud.telcoautomation.v1alpha1.Deployment;
import com.google.cloud.telcoautomation.v1alpha1.DiscardBlueprintChangesRequest;
import com.google.cloud.telcoautomation.v1alpha1.DiscardBlueprintChangesResponse;
import com.google.cloud.telcoautomation.v1alpha1.DiscardDeploymentChangesRequest;
import com.google.cloud.telcoautomation.v1alpha1.DiscardDeploymentChangesResponse;
import com.google.cloud.telcoautomation.v1alpha1.EdgeSlm;
import com.google.cloud.telcoautomation.v1alpha1.GetBlueprintRequest;
import com.google.cloud.telcoautomation.v1alpha1.GetDeploymentRequest;
import com.google.cloud.telcoautomation.v1alpha1.GetEdgeSlmRequest;
import com.google.cloud.telcoautomation.v1alpha1.GetHydratedDeploymentRequest;
import com.google.cloud.telcoautomation.v1alpha1.GetOrchestrationClusterRequest;
import com.google.cloud.telcoautomation.v1alpha1.GetPublicBlueprintRequest;
import com.google.cloud.telcoautomation.v1alpha1.HydratedDeployment;
import com.google.cloud.telcoautomation.v1alpha1.ListBlueprintRevisionsRequest;
import com.google.cloud.telcoautomation.v1alpha1.ListBlueprintRevisionsResponse;
import com.google.cloud.telcoautomation.v1alpha1.ListBlueprintsRequest;
import com.google.cloud.telcoautomation.v1alpha1.ListBlueprintsResponse;
import com.google.cloud.telcoautomation.v1alpha1.ListDeploymentRevisionsRequest;
import com.google.cloud.telcoautomation.v1alpha1.ListDeploymentRevisionsResponse;
import com.google.cloud.telcoautomation.v1alpha1.ListDeploymentsRequest;
import com.google.cloud.telcoautomation.v1alpha1.ListDeploymentsResponse;
import com.google.cloud.telcoautomation.v1alpha1.ListEdgeSlmsRequest;
import com.google.cloud.telcoautomation.v1alpha1.ListEdgeSlmsResponse;
import com.google.cloud.telcoautomation.v1alpha1.ListHydratedDeploymentsRequest;
import com.google.cloud.telcoautomation.v1alpha1.ListHydratedDeploymentsResponse;
import com.google.cloud.telcoautomation.v1alpha1.ListOrchestrationClustersRequest;
import com.google.cloud.telcoautomation.v1alpha1.ListOrchestrationClustersResponse;
import com.google.cloud.telcoautomation.v1alpha1.ListPublicBlueprintsRequest;
import com.google.cloud.telcoautomation.v1alpha1.ListPublicBlueprintsResponse;
import com.google.cloud.telcoautomation.v1alpha1.OperationMetadata;
import com.google.cloud.telcoautomation.v1alpha1.OrchestrationCluster;
import com.google.cloud.telcoautomation.v1alpha1.ProposeBlueprintRequest;
import com.google.cloud.telcoautomation.v1alpha1.PublicBlueprint;
import com.google.cloud.telcoautomation.v1alpha1.RejectBlueprintRequest;
import com.google.cloud.telcoautomation.v1alpha1.RemoveDeploymentRequest;
import com.google.cloud.telcoautomation.v1alpha1.RollbackDeploymentRequest;
import com.google.cloud.telcoautomation.v1alpha1.SearchBlueprintRevisionsRequest;
import com.google.cloud.telcoautomation.v1alpha1.SearchBlueprintRevisionsResponse;
import com.google.cloud.telcoautomation.v1alpha1.SearchDeploymentRevisionsRequest;
import com.google.cloud.telcoautomation.v1alpha1.SearchDeploymentRevisionsResponse;
import com.google.cloud.telcoautomation.v1alpha1.UpdateBlueprintRequest;
import com.google.cloud.telcoautomation.v1alpha1.UpdateDeploymentRequest;
import com.google.cloud.telcoautomation.v1alpha1.UpdateHydratedDeploymentRequest;
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
 * Settings class to configure an instance of {@link TelcoAutomationStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (telcoautomation.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getOrchestrationCluster to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * TelcoAutomationStubSettings.Builder telcoAutomationSettingsBuilder =
 *     TelcoAutomationStubSettings.newBuilder();
 * telcoAutomationSettingsBuilder
 *     .getOrchestrationClusterSettings()
 *     .setRetrySettings(
 *         telcoAutomationSettingsBuilder
 *             .getOrchestrationClusterSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * TelcoAutomationStubSettings telcoAutomationSettings = telcoAutomationSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class TelcoAutomationStubSettings extends StubSettings<TelcoAutomationStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListOrchestrationClustersRequest,
          ListOrchestrationClustersResponse,
          ListOrchestrationClustersPagedResponse>
      listOrchestrationClustersSettings;
  private final UnaryCallSettings<GetOrchestrationClusterRequest, OrchestrationCluster>
      getOrchestrationClusterSettings;
  private final UnaryCallSettings<CreateOrchestrationClusterRequest, Operation>
      createOrchestrationClusterSettings;
  private final OperationCallSettings<
          CreateOrchestrationClusterRequest, OrchestrationCluster, OperationMetadata>
      createOrchestrationClusterOperationSettings;
  private final UnaryCallSettings<DeleteOrchestrationClusterRequest, Operation>
      deleteOrchestrationClusterSettings;
  private final OperationCallSettings<DeleteOrchestrationClusterRequest, Empty, OperationMetadata>
      deleteOrchestrationClusterOperationSettings;
  private final PagedCallSettings<
          ListEdgeSlmsRequest, ListEdgeSlmsResponse, ListEdgeSlmsPagedResponse>
      listEdgeSlmsSettings;
  private final UnaryCallSettings<GetEdgeSlmRequest, EdgeSlm> getEdgeSlmSettings;
  private final UnaryCallSettings<CreateEdgeSlmRequest, Operation> createEdgeSlmSettings;
  private final OperationCallSettings<CreateEdgeSlmRequest, EdgeSlm, OperationMetadata>
      createEdgeSlmOperationSettings;
  private final UnaryCallSettings<DeleteEdgeSlmRequest, Operation> deleteEdgeSlmSettings;
  private final OperationCallSettings<DeleteEdgeSlmRequest, Empty, OperationMetadata>
      deleteEdgeSlmOperationSettings;
  private final UnaryCallSettings<CreateBlueprintRequest, Blueprint> createBlueprintSettings;
  private final UnaryCallSettings<UpdateBlueprintRequest, Blueprint> updateBlueprintSettings;
  private final UnaryCallSettings<GetBlueprintRequest, Blueprint> getBlueprintSettings;
  private final UnaryCallSettings<DeleteBlueprintRequest, Empty> deleteBlueprintSettings;
  private final PagedCallSettings<
          ListBlueprintsRequest, ListBlueprintsResponse, ListBlueprintsPagedResponse>
      listBlueprintsSettings;
  private final UnaryCallSettings<ApproveBlueprintRequest, Blueprint> approveBlueprintSettings;
  private final UnaryCallSettings<ProposeBlueprintRequest, Blueprint> proposeBlueprintSettings;
  private final UnaryCallSettings<RejectBlueprintRequest, Blueprint> rejectBlueprintSettings;
  private final PagedCallSettings<
          ListBlueprintRevisionsRequest,
          ListBlueprintRevisionsResponse,
          ListBlueprintRevisionsPagedResponse>
      listBlueprintRevisionsSettings;
  private final PagedCallSettings<
          SearchBlueprintRevisionsRequest,
          SearchBlueprintRevisionsResponse,
          SearchBlueprintRevisionsPagedResponse>
      searchBlueprintRevisionsSettings;
  private final PagedCallSettings<
          SearchDeploymentRevisionsRequest,
          SearchDeploymentRevisionsResponse,
          SearchDeploymentRevisionsPagedResponse>
      searchDeploymentRevisionsSettings;
  private final UnaryCallSettings<DiscardBlueprintChangesRequest, DiscardBlueprintChangesResponse>
      discardBlueprintChangesSettings;
  private final PagedCallSettings<
          ListPublicBlueprintsRequest,
          ListPublicBlueprintsResponse,
          ListPublicBlueprintsPagedResponse>
      listPublicBlueprintsSettings;
  private final UnaryCallSettings<GetPublicBlueprintRequest, PublicBlueprint>
      getPublicBlueprintSettings;
  private final UnaryCallSettings<CreateDeploymentRequest, Deployment> createDeploymentSettings;
  private final UnaryCallSettings<UpdateDeploymentRequest, Deployment> updateDeploymentSettings;
  private final UnaryCallSettings<GetDeploymentRequest, Deployment> getDeploymentSettings;
  private final UnaryCallSettings<RemoveDeploymentRequest, Empty> removeDeploymentSettings;
  private final PagedCallSettings<
          ListDeploymentsRequest, ListDeploymentsResponse, ListDeploymentsPagedResponse>
      listDeploymentsSettings;
  private final PagedCallSettings<
          ListDeploymentRevisionsRequest,
          ListDeploymentRevisionsResponse,
          ListDeploymentRevisionsPagedResponse>
      listDeploymentRevisionsSettings;
  private final UnaryCallSettings<DiscardDeploymentChangesRequest, DiscardDeploymentChangesResponse>
      discardDeploymentChangesSettings;
  private final UnaryCallSettings<ApplyDeploymentRequest, Deployment> applyDeploymentSettings;
  private final UnaryCallSettings<ComputeDeploymentStatusRequest, ComputeDeploymentStatusResponse>
      computeDeploymentStatusSettings;
  private final UnaryCallSettings<RollbackDeploymentRequest, Deployment> rollbackDeploymentSettings;
  private final UnaryCallSettings<GetHydratedDeploymentRequest, HydratedDeployment>
      getHydratedDeploymentSettings;
  private final PagedCallSettings<
          ListHydratedDeploymentsRequest,
          ListHydratedDeploymentsResponse,
          ListHydratedDeploymentsPagedResponse>
      listHydratedDeploymentsSettings;
  private final UnaryCallSettings<UpdateHydratedDeploymentRequest, HydratedDeployment>
      updateHydratedDeploymentSettings;
  private final UnaryCallSettings<ApplyHydratedDeploymentRequest, HydratedDeployment>
      applyHydratedDeploymentSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

  private static final PagedListDescriptor<
          ListOrchestrationClustersRequest, ListOrchestrationClustersResponse, OrchestrationCluster>
      LIST_ORCHESTRATION_CLUSTERS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListOrchestrationClustersRequest,
              ListOrchestrationClustersResponse,
              OrchestrationCluster>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListOrchestrationClustersRequest injectToken(
                ListOrchestrationClustersRequest payload, String token) {
              return ListOrchestrationClustersRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListOrchestrationClustersRequest injectPageSize(
                ListOrchestrationClustersRequest payload, int pageSize) {
              return ListOrchestrationClustersRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListOrchestrationClustersRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListOrchestrationClustersResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<OrchestrationCluster> extractResources(
                ListOrchestrationClustersResponse payload) {
              return payload.getOrchestrationClustersList() == null
                  ? ImmutableList.<OrchestrationCluster>of()
                  : payload.getOrchestrationClustersList();
            }
          };

  private static final PagedListDescriptor<ListEdgeSlmsRequest, ListEdgeSlmsResponse, EdgeSlm>
      LIST_EDGE_SLMS_PAGE_STR_DESC =
          new PagedListDescriptor<ListEdgeSlmsRequest, ListEdgeSlmsResponse, EdgeSlm>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListEdgeSlmsRequest injectToken(ListEdgeSlmsRequest payload, String token) {
              return ListEdgeSlmsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListEdgeSlmsRequest injectPageSize(ListEdgeSlmsRequest payload, int pageSize) {
              return ListEdgeSlmsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListEdgeSlmsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListEdgeSlmsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<EdgeSlm> extractResources(ListEdgeSlmsResponse payload) {
              return payload.getEdgeSlmsList() == null
                  ? ImmutableList.<EdgeSlm>of()
                  : payload.getEdgeSlmsList();
            }
          };

  private static final PagedListDescriptor<ListBlueprintsRequest, ListBlueprintsResponse, Blueprint>
      LIST_BLUEPRINTS_PAGE_STR_DESC =
          new PagedListDescriptor<ListBlueprintsRequest, ListBlueprintsResponse, Blueprint>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListBlueprintsRequest injectToken(ListBlueprintsRequest payload, String token) {
              return ListBlueprintsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListBlueprintsRequest injectPageSize(
                ListBlueprintsRequest payload, int pageSize) {
              return ListBlueprintsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListBlueprintsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListBlueprintsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Blueprint> extractResources(ListBlueprintsResponse payload) {
              return payload.getBlueprintsList() == null
                  ? ImmutableList.<Blueprint>of()
                  : payload.getBlueprintsList();
            }
          };

  private static final PagedListDescriptor<
          ListBlueprintRevisionsRequest, ListBlueprintRevisionsResponse, Blueprint>
      LIST_BLUEPRINT_REVISIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListBlueprintRevisionsRequest, ListBlueprintRevisionsResponse, Blueprint>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListBlueprintRevisionsRequest injectToken(
                ListBlueprintRevisionsRequest payload, String token) {
              return ListBlueprintRevisionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListBlueprintRevisionsRequest injectPageSize(
                ListBlueprintRevisionsRequest payload, int pageSize) {
              return ListBlueprintRevisionsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListBlueprintRevisionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListBlueprintRevisionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Blueprint> extractResources(ListBlueprintRevisionsResponse payload) {
              return payload.getBlueprintsList() == null
                  ? ImmutableList.<Blueprint>of()
                  : payload.getBlueprintsList();
            }
          };

  private static final PagedListDescriptor<
          SearchBlueprintRevisionsRequest, SearchBlueprintRevisionsResponse, Blueprint>
      SEARCH_BLUEPRINT_REVISIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              SearchBlueprintRevisionsRequest, SearchBlueprintRevisionsResponse, Blueprint>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public SearchBlueprintRevisionsRequest injectToken(
                SearchBlueprintRevisionsRequest payload, String token) {
              return SearchBlueprintRevisionsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public SearchBlueprintRevisionsRequest injectPageSize(
                SearchBlueprintRevisionsRequest payload, int pageSize) {
              return SearchBlueprintRevisionsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(SearchBlueprintRevisionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(SearchBlueprintRevisionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Blueprint> extractResources(SearchBlueprintRevisionsResponse payload) {
              return payload.getBlueprintsList() == null
                  ? ImmutableList.<Blueprint>of()
                  : payload.getBlueprintsList();
            }
          };

  private static final PagedListDescriptor<
          SearchDeploymentRevisionsRequest, SearchDeploymentRevisionsResponse, Deployment>
      SEARCH_DEPLOYMENT_REVISIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              SearchDeploymentRevisionsRequest, SearchDeploymentRevisionsResponse, Deployment>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public SearchDeploymentRevisionsRequest injectToken(
                SearchDeploymentRevisionsRequest payload, String token) {
              return SearchDeploymentRevisionsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public SearchDeploymentRevisionsRequest injectPageSize(
                SearchDeploymentRevisionsRequest payload, int pageSize) {
              return SearchDeploymentRevisionsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(SearchDeploymentRevisionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(SearchDeploymentRevisionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Deployment> extractResources(
                SearchDeploymentRevisionsResponse payload) {
              return payload.getDeploymentsList() == null
                  ? ImmutableList.<Deployment>of()
                  : payload.getDeploymentsList();
            }
          };

  private static final PagedListDescriptor<
          ListPublicBlueprintsRequest, ListPublicBlueprintsResponse, PublicBlueprint>
      LIST_PUBLIC_BLUEPRINTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListPublicBlueprintsRequest, ListPublicBlueprintsResponse, PublicBlueprint>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListPublicBlueprintsRequest injectToken(
                ListPublicBlueprintsRequest payload, String token) {
              return ListPublicBlueprintsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListPublicBlueprintsRequest injectPageSize(
                ListPublicBlueprintsRequest payload, int pageSize) {
              return ListPublicBlueprintsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListPublicBlueprintsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListPublicBlueprintsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<PublicBlueprint> extractResources(
                ListPublicBlueprintsResponse payload) {
              return payload.getPublicBlueprintsList() == null
                  ? ImmutableList.<PublicBlueprint>of()
                  : payload.getPublicBlueprintsList();
            }
          };

  private static final PagedListDescriptor<
          ListDeploymentsRequest, ListDeploymentsResponse, Deployment>
      LIST_DEPLOYMENTS_PAGE_STR_DESC =
          new PagedListDescriptor<ListDeploymentsRequest, ListDeploymentsResponse, Deployment>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDeploymentsRequest injectToken(
                ListDeploymentsRequest payload, String token) {
              return ListDeploymentsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDeploymentsRequest injectPageSize(
                ListDeploymentsRequest payload, int pageSize) {
              return ListDeploymentsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListDeploymentsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDeploymentsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Deployment> extractResources(ListDeploymentsResponse payload) {
              return payload.getDeploymentsList() == null
                  ? ImmutableList.<Deployment>of()
                  : payload.getDeploymentsList();
            }
          };

  private static final PagedListDescriptor<
          ListDeploymentRevisionsRequest, ListDeploymentRevisionsResponse, Deployment>
      LIST_DEPLOYMENT_REVISIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListDeploymentRevisionsRequest, ListDeploymentRevisionsResponse, Deployment>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDeploymentRevisionsRequest injectToken(
                ListDeploymentRevisionsRequest payload, String token) {
              return ListDeploymentRevisionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDeploymentRevisionsRequest injectPageSize(
                ListDeploymentRevisionsRequest payload, int pageSize) {
              return ListDeploymentRevisionsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListDeploymentRevisionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDeploymentRevisionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Deployment> extractResources(ListDeploymentRevisionsResponse payload) {
              return payload.getDeploymentsList() == null
                  ? ImmutableList.<Deployment>of()
                  : payload.getDeploymentsList();
            }
          };

  private static final PagedListDescriptor<
          ListHydratedDeploymentsRequest, ListHydratedDeploymentsResponse, HydratedDeployment>
      LIST_HYDRATED_DEPLOYMENTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListHydratedDeploymentsRequest,
              ListHydratedDeploymentsResponse,
              HydratedDeployment>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListHydratedDeploymentsRequest injectToken(
                ListHydratedDeploymentsRequest payload, String token) {
              return ListHydratedDeploymentsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListHydratedDeploymentsRequest injectPageSize(
                ListHydratedDeploymentsRequest payload, int pageSize) {
              return ListHydratedDeploymentsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListHydratedDeploymentsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListHydratedDeploymentsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<HydratedDeployment> extractResources(
                ListHydratedDeploymentsResponse payload) {
              return payload.getHydratedDeploymentsList() == null
                  ? ImmutableList.<HydratedDeployment>of()
                  : payload.getHydratedDeploymentsList();
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
          ListOrchestrationClustersRequest,
          ListOrchestrationClustersResponse,
          ListOrchestrationClustersPagedResponse>
      LIST_ORCHESTRATION_CLUSTERS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListOrchestrationClustersRequest,
              ListOrchestrationClustersResponse,
              ListOrchestrationClustersPagedResponse>() {
            @Override
            public ApiFuture<ListOrchestrationClustersPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListOrchestrationClustersRequest, ListOrchestrationClustersResponse>
                    callable,
                ListOrchestrationClustersRequest request,
                ApiCallContext context,
                ApiFuture<ListOrchestrationClustersResponse> futureResponse) {
              PageContext<
                      ListOrchestrationClustersRequest,
                      ListOrchestrationClustersResponse,
                      OrchestrationCluster>
                  pageContext =
                      PageContext.create(
                          callable, LIST_ORCHESTRATION_CLUSTERS_PAGE_STR_DESC, request, context);
              return ListOrchestrationClustersPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListEdgeSlmsRequest, ListEdgeSlmsResponse, ListEdgeSlmsPagedResponse>
      LIST_EDGE_SLMS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListEdgeSlmsRequest, ListEdgeSlmsResponse, ListEdgeSlmsPagedResponse>() {
            @Override
            public ApiFuture<ListEdgeSlmsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListEdgeSlmsRequest, ListEdgeSlmsResponse> callable,
                ListEdgeSlmsRequest request,
                ApiCallContext context,
                ApiFuture<ListEdgeSlmsResponse> futureResponse) {
              PageContext<ListEdgeSlmsRequest, ListEdgeSlmsResponse, EdgeSlm> pageContext =
                  PageContext.create(callable, LIST_EDGE_SLMS_PAGE_STR_DESC, request, context);
              return ListEdgeSlmsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListBlueprintsRequest, ListBlueprintsResponse, ListBlueprintsPagedResponse>
      LIST_BLUEPRINTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListBlueprintsRequest, ListBlueprintsResponse, ListBlueprintsPagedResponse>() {
            @Override
            public ApiFuture<ListBlueprintsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListBlueprintsRequest, ListBlueprintsResponse> callable,
                ListBlueprintsRequest request,
                ApiCallContext context,
                ApiFuture<ListBlueprintsResponse> futureResponse) {
              PageContext<ListBlueprintsRequest, ListBlueprintsResponse, Blueprint> pageContext =
                  PageContext.create(callable, LIST_BLUEPRINTS_PAGE_STR_DESC, request, context);
              return ListBlueprintsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListBlueprintRevisionsRequest,
          ListBlueprintRevisionsResponse,
          ListBlueprintRevisionsPagedResponse>
      LIST_BLUEPRINT_REVISIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListBlueprintRevisionsRequest,
              ListBlueprintRevisionsResponse,
              ListBlueprintRevisionsPagedResponse>() {
            @Override
            public ApiFuture<ListBlueprintRevisionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListBlueprintRevisionsRequest, ListBlueprintRevisionsResponse>
                    callable,
                ListBlueprintRevisionsRequest request,
                ApiCallContext context,
                ApiFuture<ListBlueprintRevisionsResponse> futureResponse) {
              PageContext<ListBlueprintRevisionsRequest, ListBlueprintRevisionsResponse, Blueprint>
                  pageContext =
                      PageContext.create(
                          callable, LIST_BLUEPRINT_REVISIONS_PAGE_STR_DESC, request, context);
              return ListBlueprintRevisionsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          SearchBlueprintRevisionsRequest,
          SearchBlueprintRevisionsResponse,
          SearchBlueprintRevisionsPagedResponse>
      SEARCH_BLUEPRINT_REVISIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              SearchBlueprintRevisionsRequest,
              SearchBlueprintRevisionsResponse,
              SearchBlueprintRevisionsPagedResponse>() {
            @Override
            public ApiFuture<SearchBlueprintRevisionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<SearchBlueprintRevisionsRequest, SearchBlueprintRevisionsResponse>
                    callable,
                SearchBlueprintRevisionsRequest request,
                ApiCallContext context,
                ApiFuture<SearchBlueprintRevisionsResponse> futureResponse) {
              PageContext<
                      SearchBlueprintRevisionsRequest, SearchBlueprintRevisionsResponse, Blueprint>
                  pageContext =
                      PageContext.create(
                          callable, SEARCH_BLUEPRINT_REVISIONS_PAGE_STR_DESC, request, context);
              return SearchBlueprintRevisionsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          SearchDeploymentRevisionsRequest,
          SearchDeploymentRevisionsResponse,
          SearchDeploymentRevisionsPagedResponse>
      SEARCH_DEPLOYMENT_REVISIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              SearchDeploymentRevisionsRequest,
              SearchDeploymentRevisionsResponse,
              SearchDeploymentRevisionsPagedResponse>() {
            @Override
            public ApiFuture<SearchDeploymentRevisionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<SearchDeploymentRevisionsRequest, SearchDeploymentRevisionsResponse>
                    callable,
                SearchDeploymentRevisionsRequest request,
                ApiCallContext context,
                ApiFuture<SearchDeploymentRevisionsResponse> futureResponse) {
              PageContext<
                      SearchDeploymentRevisionsRequest,
                      SearchDeploymentRevisionsResponse,
                      Deployment>
                  pageContext =
                      PageContext.create(
                          callable, SEARCH_DEPLOYMENT_REVISIONS_PAGE_STR_DESC, request, context);
              return SearchDeploymentRevisionsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListPublicBlueprintsRequest,
          ListPublicBlueprintsResponse,
          ListPublicBlueprintsPagedResponse>
      LIST_PUBLIC_BLUEPRINTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListPublicBlueprintsRequest,
              ListPublicBlueprintsResponse,
              ListPublicBlueprintsPagedResponse>() {
            @Override
            public ApiFuture<ListPublicBlueprintsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListPublicBlueprintsRequest, ListPublicBlueprintsResponse> callable,
                ListPublicBlueprintsRequest request,
                ApiCallContext context,
                ApiFuture<ListPublicBlueprintsResponse> futureResponse) {
              PageContext<
                      ListPublicBlueprintsRequest, ListPublicBlueprintsResponse, PublicBlueprint>
                  pageContext =
                      PageContext.create(
                          callable, LIST_PUBLIC_BLUEPRINTS_PAGE_STR_DESC, request, context);
              return ListPublicBlueprintsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListDeploymentsRequest, ListDeploymentsResponse, ListDeploymentsPagedResponse>
      LIST_DEPLOYMENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDeploymentsRequest, ListDeploymentsResponse, ListDeploymentsPagedResponse>() {
            @Override
            public ApiFuture<ListDeploymentsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDeploymentsRequest, ListDeploymentsResponse> callable,
                ListDeploymentsRequest request,
                ApiCallContext context,
                ApiFuture<ListDeploymentsResponse> futureResponse) {
              PageContext<ListDeploymentsRequest, ListDeploymentsResponse, Deployment> pageContext =
                  PageContext.create(callable, LIST_DEPLOYMENTS_PAGE_STR_DESC, request, context);
              return ListDeploymentsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListDeploymentRevisionsRequest,
          ListDeploymentRevisionsResponse,
          ListDeploymentRevisionsPagedResponse>
      LIST_DEPLOYMENT_REVISIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDeploymentRevisionsRequest,
              ListDeploymentRevisionsResponse,
              ListDeploymentRevisionsPagedResponse>() {
            @Override
            public ApiFuture<ListDeploymentRevisionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDeploymentRevisionsRequest, ListDeploymentRevisionsResponse>
                    callable,
                ListDeploymentRevisionsRequest request,
                ApiCallContext context,
                ApiFuture<ListDeploymentRevisionsResponse> futureResponse) {
              PageContext<
                      ListDeploymentRevisionsRequest, ListDeploymentRevisionsResponse, Deployment>
                  pageContext =
                      PageContext.create(
                          callable, LIST_DEPLOYMENT_REVISIONS_PAGE_STR_DESC, request, context);
              return ListDeploymentRevisionsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListHydratedDeploymentsRequest,
          ListHydratedDeploymentsResponse,
          ListHydratedDeploymentsPagedResponse>
      LIST_HYDRATED_DEPLOYMENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListHydratedDeploymentsRequest,
              ListHydratedDeploymentsResponse,
              ListHydratedDeploymentsPagedResponse>() {
            @Override
            public ApiFuture<ListHydratedDeploymentsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListHydratedDeploymentsRequest, ListHydratedDeploymentsResponse>
                    callable,
                ListHydratedDeploymentsRequest request,
                ApiCallContext context,
                ApiFuture<ListHydratedDeploymentsResponse> futureResponse) {
              PageContext<
                      ListHydratedDeploymentsRequest,
                      ListHydratedDeploymentsResponse,
                      HydratedDeployment>
                  pageContext =
                      PageContext.create(
                          callable, LIST_HYDRATED_DEPLOYMENTS_PAGE_STR_DESC, request, context);
              return ListHydratedDeploymentsPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to listOrchestrationClusters. */
  public PagedCallSettings<
          ListOrchestrationClustersRequest,
          ListOrchestrationClustersResponse,
          ListOrchestrationClustersPagedResponse>
      listOrchestrationClustersSettings() {
    return listOrchestrationClustersSettings;
  }

  /** Returns the object with the settings used for calls to getOrchestrationCluster. */
  public UnaryCallSettings<GetOrchestrationClusterRequest, OrchestrationCluster>
      getOrchestrationClusterSettings() {
    return getOrchestrationClusterSettings;
  }

  /** Returns the object with the settings used for calls to createOrchestrationCluster. */
  public UnaryCallSettings<CreateOrchestrationClusterRequest, Operation>
      createOrchestrationClusterSettings() {
    return createOrchestrationClusterSettings;
  }

  /** Returns the object with the settings used for calls to createOrchestrationCluster. */
  public OperationCallSettings<
          CreateOrchestrationClusterRequest, OrchestrationCluster, OperationMetadata>
      createOrchestrationClusterOperationSettings() {
    return createOrchestrationClusterOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteOrchestrationCluster. */
  public UnaryCallSettings<DeleteOrchestrationClusterRequest, Operation>
      deleteOrchestrationClusterSettings() {
    return deleteOrchestrationClusterSettings;
  }

  /** Returns the object with the settings used for calls to deleteOrchestrationCluster. */
  public OperationCallSettings<DeleteOrchestrationClusterRequest, Empty, OperationMetadata>
      deleteOrchestrationClusterOperationSettings() {
    return deleteOrchestrationClusterOperationSettings;
  }

  /** Returns the object with the settings used for calls to listEdgeSlms. */
  public PagedCallSettings<ListEdgeSlmsRequest, ListEdgeSlmsResponse, ListEdgeSlmsPagedResponse>
      listEdgeSlmsSettings() {
    return listEdgeSlmsSettings;
  }

  /** Returns the object with the settings used for calls to getEdgeSlm. */
  public UnaryCallSettings<GetEdgeSlmRequest, EdgeSlm> getEdgeSlmSettings() {
    return getEdgeSlmSettings;
  }

  /** Returns the object with the settings used for calls to createEdgeSlm. */
  public UnaryCallSettings<CreateEdgeSlmRequest, Operation> createEdgeSlmSettings() {
    return createEdgeSlmSettings;
  }

  /** Returns the object with the settings used for calls to createEdgeSlm. */
  public OperationCallSettings<CreateEdgeSlmRequest, EdgeSlm, OperationMetadata>
      createEdgeSlmOperationSettings() {
    return createEdgeSlmOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteEdgeSlm. */
  public UnaryCallSettings<DeleteEdgeSlmRequest, Operation> deleteEdgeSlmSettings() {
    return deleteEdgeSlmSettings;
  }

  /** Returns the object with the settings used for calls to deleteEdgeSlm. */
  public OperationCallSettings<DeleteEdgeSlmRequest, Empty, OperationMetadata>
      deleteEdgeSlmOperationSettings() {
    return deleteEdgeSlmOperationSettings;
  }

  /** Returns the object with the settings used for calls to createBlueprint. */
  public UnaryCallSettings<CreateBlueprintRequest, Blueprint> createBlueprintSettings() {
    return createBlueprintSettings;
  }

  /** Returns the object with the settings used for calls to updateBlueprint. */
  public UnaryCallSettings<UpdateBlueprintRequest, Blueprint> updateBlueprintSettings() {
    return updateBlueprintSettings;
  }

  /** Returns the object with the settings used for calls to getBlueprint. */
  public UnaryCallSettings<GetBlueprintRequest, Blueprint> getBlueprintSettings() {
    return getBlueprintSettings;
  }

  /** Returns the object with the settings used for calls to deleteBlueprint. */
  public UnaryCallSettings<DeleteBlueprintRequest, Empty> deleteBlueprintSettings() {
    return deleteBlueprintSettings;
  }

  /** Returns the object with the settings used for calls to listBlueprints. */
  public PagedCallSettings<
          ListBlueprintsRequest, ListBlueprintsResponse, ListBlueprintsPagedResponse>
      listBlueprintsSettings() {
    return listBlueprintsSettings;
  }

  /** Returns the object with the settings used for calls to approveBlueprint. */
  public UnaryCallSettings<ApproveBlueprintRequest, Blueprint> approveBlueprintSettings() {
    return approveBlueprintSettings;
  }

  /** Returns the object with the settings used for calls to proposeBlueprint. */
  public UnaryCallSettings<ProposeBlueprintRequest, Blueprint> proposeBlueprintSettings() {
    return proposeBlueprintSettings;
  }

  /** Returns the object with the settings used for calls to rejectBlueprint. */
  public UnaryCallSettings<RejectBlueprintRequest, Blueprint> rejectBlueprintSettings() {
    return rejectBlueprintSettings;
  }

  /** Returns the object with the settings used for calls to listBlueprintRevisions. */
  public PagedCallSettings<
          ListBlueprintRevisionsRequest,
          ListBlueprintRevisionsResponse,
          ListBlueprintRevisionsPagedResponse>
      listBlueprintRevisionsSettings() {
    return listBlueprintRevisionsSettings;
  }

  /** Returns the object with the settings used for calls to searchBlueprintRevisions. */
  public PagedCallSettings<
          SearchBlueprintRevisionsRequest,
          SearchBlueprintRevisionsResponse,
          SearchBlueprintRevisionsPagedResponse>
      searchBlueprintRevisionsSettings() {
    return searchBlueprintRevisionsSettings;
  }

  /** Returns the object with the settings used for calls to searchDeploymentRevisions. */
  public PagedCallSettings<
          SearchDeploymentRevisionsRequest,
          SearchDeploymentRevisionsResponse,
          SearchDeploymentRevisionsPagedResponse>
      searchDeploymentRevisionsSettings() {
    return searchDeploymentRevisionsSettings;
  }

  /** Returns the object with the settings used for calls to discardBlueprintChanges. */
  public UnaryCallSettings<DiscardBlueprintChangesRequest, DiscardBlueprintChangesResponse>
      discardBlueprintChangesSettings() {
    return discardBlueprintChangesSettings;
  }

  /** Returns the object with the settings used for calls to listPublicBlueprints. */
  public PagedCallSettings<
          ListPublicBlueprintsRequest,
          ListPublicBlueprintsResponse,
          ListPublicBlueprintsPagedResponse>
      listPublicBlueprintsSettings() {
    return listPublicBlueprintsSettings;
  }

  /** Returns the object with the settings used for calls to getPublicBlueprint. */
  public UnaryCallSettings<GetPublicBlueprintRequest, PublicBlueprint>
      getPublicBlueprintSettings() {
    return getPublicBlueprintSettings;
  }

  /** Returns the object with the settings used for calls to createDeployment. */
  public UnaryCallSettings<CreateDeploymentRequest, Deployment> createDeploymentSettings() {
    return createDeploymentSettings;
  }

  /** Returns the object with the settings used for calls to updateDeployment. */
  public UnaryCallSettings<UpdateDeploymentRequest, Deployment> updateDeploymentSettings() {
    return updateDeploymentSettings;
  }

  /** Returns the object with the settings used for calls to getDeployment. */
  public UnaryCallSettings<GetDeploymentRequest, Deployment> getDeploymentSettings() {
    return getDeploymentSettings;
  }

  /** Returns the object with the settings used for calls to removeDeployment. */
  public UnaryCallSettings<RemoveDeploymentRequest, Empty> removeDeploymentSettings() {
    return removeDeploymentSettings;
  }

  /** Returns the object with the settings used for calls to listDeployments. */
  public PagedCallSettings<
          ListDeploymentsRequest, ListDeploymentsResponse, ListDeploymentsPagedResponse>
      listDeploymentsSettings() {
    return listDeploymentsSettings;
  }

  /** Returns the object with the settings used for calls to listDeploymentRevisions. */
  public PagedCallSettings<
          ListDeploymentRevisionsRequest,
          ListDeploymentRevisionsResponse,
          ListDeploymentRevisionsPagedResponse>
      listDeploymentRevisionsSettings() {
    return listDeploymentRevisionsSettings;
  }

  /** Returns the object with the settings used for calls to discardDeploymentChanges. */
  public UnaryCallSettings<DiscardDeploymentChangesRequest, DiscardDeploymentChangesResponse>
      discardDeploymentChangesSettings() {
    return discardDeploymentChangesSettings;
  }

  /** Returns the object with the settings used for calls to applyDeployment. */
  public UnaryCallSettings<ApplyDeploymentRequest, Deployment> applyDeploymentSettings() {
    return applyDeploymentSettings;
  }

  /** Returns the object with the settings used for calls to computeDeploymentStatus. */
  public UnaryCallSettings<ComputeDeploymentStatusRequest, ComputeDeploymentStatusResponse>
      computeDeploymentStatusSettings() {
    return computeDeploymentStatusSettings;
  }

  /** Returns the object with the settings used for calls to rollbackDeployment. */
  public UnaryCallSettings<RollbackDeploymentRequest, Deployment> rollbackDeploymentSettings() {
    return rollbackDeploymentSettings;
  }

  /** Returns the object with the settings used for calls to getHydratedDeployment. */
  public UnaryCallSettings<GetHydratedDeploymentRequest, HydratedDeployment>
      getHydratedDeploymentSettings() {
    return getHydratedDeploymentSettings;
  }

  /** Returns the object with the settings used for calls to listHydratedDeployments. */
  public PagedCallSettings<
          ListHydratedDeploymentsRequest,
          ListHydratedDeploymentsResponse,
          ListHydratedDeploymentsPagedResponse>
      listHydratedDeploymentsSettings() {
    return listHydratedDeploymentsSettings;
  }

  /** Returns the object with the settings used for calls to updateHydratedDeployment. */
  public UnaryCallSettings<UpdateHydratedDeploymentRequest, HydratedDeployment>
      updateHydratedDeploymentSettings() {
    return updateHydratedDeploymentSettings;
  }

  /** Returns the object with the settings used for calls to applyHydratedDeployment. */
  public UnaryCallSettings<ApplyHydratedDeploymentRequest, HydratedDeployment>
      applyHydratedDeploymentSettings() {
    return applyHydratedDeploymentSettings;
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

  public TelcoAutomationStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcTelcoAutomationStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonTelcoAutomationStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "telcoautomation";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "telcoautomation.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "telcoautomation.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(TelcoAutomationStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(TelcoAutomationStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return TelcoAutomationStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected TelcoAutomationStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listOrchestrationClustersSettings = settingsBuilder.listOrchestrationClustersSettings().build();
    getOrchestrationClusterSettings = settingsBuilder.getOrchestrationClusterSettings().build();
    createOrchestrationClusterSettings =
        settingsBuilder.createOrchestrationClusterSettings().build();
    createOrchestrationClusterOperationSettings =
        settingsBuilder.createOrchestrationClusterOperationSettings().build();
    deleteOrchestrationClusterSettings =
        settingsBuilder.deleteOrchestrationClusterSettings().build();
    deleteOrchestrationClusterOperationSettings =
        settingsBuilder.deleteOrchestrationClusterOperationSettings().build();
    listEdgeSlmsSettings = settingsBuilder.listEdgeSlmsSettings().build();
    getEdgeSlmSettings = settingsBuilder.getEdgeSlmSettings().build();
    createEdgeSlmSettings = settingsBuilder.createEdgeSlmSettings().build();
    createEdgeSlmOperationSettings = settingsBuilder.createEdgeSlmOperationSettings().build();
    deleteEdgeSlmSettings = settingsBuilder.deleteEdgeSlmSettings().build();
    deleteEdgeSlmOperationSettings = settingsBuilder.deleteEdgeSlmOperationSettings().build();
    createBlueprintSettings = settingsBuilder.createBlueprintSettings().build();
    updateBlueprintSettings = settingsBuilder.updateBlueprintSettings().build();
    getBlueprintSettings = settingsBuilder.getBlueprintSettings().build();
    deleteBlueprintSettings = settingsBuilder.deleteBlueprintSettings().build();
    listBlueprintsSettings = settingsBuilder.listBlueprintsSettings().build();
    approveBlueprintSettings = settingsBuilder.approveBlueprintSettings().build();
    proposeBlueprintSettings = settingsBuilder.proposeBlueprintSettings().build();
    rejectBlueprintSettings = settingsBuilder.rejectBlueprintSettings().build();
    listBlueprintRevisionsSettings = settingsBuilder.listBlueprintRevisionsSettings().build();
    searchBlueprintRevisionsSettings = settingsBuilder.searchBlueprintRevisionsSettings().build();
    searchDeploymentRevisionsSettings = settingsBuilder.searchDeploymentRevisionsSettings().build();
    discardBlueprintChangesSettings = settingsBuilder.discardBlueprintChangesSettings().build();
    listPublicBlueprintsSettings = settingsBuilder.listPublicBlueprintsSettings().build();
    getPublicBlueprintSettings = settingsBuilder.getPublicBlueprintSettings().build();
    createDeploymentSettings = settingsBuilder.createDeploymentSettings().build();
    updateDeploymentSettings = settingsBuilder.updateDeploymentSettings().build();
    getDeploymentSettings = settingsBuilder.getDeploymentSettings().build();
    removeDeploymentSettings = settingsBuilder.removeDeploymentSettings().build();
    listDeploymentsSettings = settingsBuilder.listDeploymentsSettings().build();
    listDeploymentRevisionsSettings = settingsBuilder.listDeploymentRevisionsSettings().build();
    discardDeploymentChangesSettings = settingsBuilder.discardDeploymentChangesSettings().build();
    applyDeploymentSettings = settingsBuilder.applyDeploymentSettings().build();
    computeDeploymentStatusSettings = settingsBuilder.computeDeploymentStatusSettings().build();
    rollbackDeploymentSettings = settingsBuilder.rollbackDeploymentSettings().build();
    getHydratedDeploymentSettings = settingsBuilder.getHydratedDeploymentSettings().build();
    listHydratedDeploymentsSettings = settingsBuilder.listHydratedDeploymentsSettings().build();
    updateHydratedDeploymentSettings = settingsBuilder.updateHydratedDeploymentSettings().build();
    applyHydratedDeploymentSettings = settingsBuilder.applyHydratedDeploymentSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  /** Builder for TelcoAutomationStubSettings. */
  public static class Builder extends StubSettings.Builder<TelcoAutomationStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListOrchestrationClustersRequest,
            ListOrchestrationClustersResponse,
            ListOrchestrationClustersPagedResponse>
        listOrchestrationClustersSettings;
    private final UnaryCallSettings.Builder<GetOrchestrationClusterRequest, OrchestrationCluster>
        getOrchestrationClusterSettings;
    private final UnaryCallSettings.Builder<CreateOrchestrationClusterRequest, Operation>
        createOrchestrationClusterSettings;
    private final OperationCallSettings.Builder<
            CreateOrchestrationClusterRequest, OrchestrationCluster, OperationMetadata>
        createOrchestrationClusterOperationSettings;
    private final UnaryCallSettings.Builder<DeleteOrchestrationClusterRequest, Operation>
        deleteOrchestrationClusterSettings;
    private final OperationCallSettings.Builder<
            DeleteOrchestrationClusterRequest, Empty, OperationMetadata>
        deleteOrchestrationClusterOperationSettings;
    private final PagedCallSettings.Builder<
            ListEdgeSlmsRequest, ListEdgeSlmsResponse, ListEdgeSlmsPagedResponse>
        listEdgeSlmsSettings;
    private final UnaryCallSettings.Builder<GetEdgeSlmRequest, EdgeSlm> getEdgeSlmSettings;
    private final UnaryCallSettings.Builder<CreateEdgeSlmRequest, Operation> createEdgeSlmSettings;
    private final OperationCallSettings.Builder<CreateEdgeSlmRequest, EdgeSlm, OperationMetadata>
        createEdgeSlmOperationSettings;
    private final UnaryCallSettings.Builder<DeleteEdgeSlmRequest, Operation> deleteEdgeSlmSettings;
    private final OperationCallSettings.Builder<DeleteEdgeSlmRequest, Empty, OperationMetadata>
        deleteEdgeSlmOperationSettings;
    private final UnaryCallSettings.Builder<CreateBlueprintRequest, Blueprint>
        createBlueprintSettings;
    private final UnaryCallSettings.Builder<UpdateBlueprintRequest, Blueprint>
        updateBlueprintSettings;
    private final UnaryCallSettings.Builder<GetBlueprintRequest, Blueprint> getBlueprintSettings;
    private final UnaryCallSettings.Builder<DeleteBlueprintRequest, Empty> deleteBlueprintSettings;
    private final PagedCallSettings.Builder<
            ListBlueprintsRequest, ListBlueprintsResponse, ListBlueprintsPagedResponse>
        listBlueprintsSettings;
    private final UnaryCallSettings.Builder<ApproveBlueprintRequest, Blueprint>
        approveBlueprintSettings;
    private final UnaryCallSettings.Builder<ProposeBlueprintRequest, Blueprint>
        proposeBlueprintSettings;
    private final UnaryCallSettings.Builder<RejectBlueprintRequest, Blueprint>
        rejectBlueprintSettings;
    private final PagedCallSettings.Builder<
            ListBlueprintRevisionsRequest,
            ListBlueprintRevisionsResponse,
            ListBlueprintRevisionsPagedResponse>
        listBlueprintRevisionsSettings;
    private final PagedCallSettings.Builder<
            SearchBlueprintRevisionsRequest,
            SearchBlueprintRevisionsResponse,
            SearchBlueprintRevisionsPagedResponse>
        searchBlueprintRevisionsSettings;
    private final PagedCallSettings.Builder<
            SearchDeploymentRevisionsRequest,
            SearchDeploymentRevisionsResponse,
            SearchDeploymentRevisionsPagedResponse>
        searchDeploymentRevisionsSettings;
    private final UnaryCallSettings.Builder<
            DiscardBlueprintChangesRequest, DiscardBlueprintChangesResponse>
        discardBlueprintChangesSettings;
    private final PagedCallSettings.Builder<
            ListPublicBlueprintsRequest,
            ListPublicBlueprintsResponse,
            ListPublicBlueprintsPagedResponse>
        listPublicBlueprintsSettings;
    private final UnaryCallSettings.Builder<GetPublicBlueprintRequest, PublicBlueprint>
        getPublicBlueprintSettings;
    private final UnaryCallSettings.Builder<CreateDeploymentRequest, Deployment>
        createDeploymentSettings;
    private final UnaryCallSettings.Builder<UpdateDeploymentRequest, Deployment>
        updateDeploymentSettings;
    private final UnaryCallSettings.Builder<GetDeploymentRequest, Deployment> getDeploymentSettings;
    private final UnaryCallSettings.Builder<RemoveDeploymentRequest, Empty>
        removeDeploymentSettings;
    private final PagedCallSettings.Builder<
            ListDeploymentsRequest, ListDeploymentsResponse, ListDeploymentsPagedResponse>
        listDeploymentsSettings;
    private final PagedCallSettings.Builder<
            ListDeploymentRevisionsRequest,
            ListDeploymentRevisionsResponse,
            ListDeploymentRevisionsPagedResponse>
        listDeploymentRevisionsSettings;
    private final UnaryCallSettings.Builder<
            DiscardDeploymentChangesRequest, DiscardDeploymentChangesResponse>
        discardDeploymentChangesSettings;
    private final UnaryCallSettings.Builder<ApplyDeploymentRequest, Deployment>
        applyDeploymentSettings;
    private final UnaryCallSettings.Builder<
            ComputeDeploymentStatusRequest, ComputeDeploymentStatusResponse>
        computeDeploymentStatusSettings;
    private final UnaryCallSettings.Builder<RollbackDeploymentRequest, Deployment>
        rollbackDeploymentSettings;
    private final UnaryCallSettings.Builder<GetHydratedDeploymentRequest, HydratedDeployment>
        getHydratedDeploymentSettings;
    private final PagedCallSettings.Builder<
            ListHydratedDeploymentsRequest,
            ListHydratedDeploymentsResponse,
            ListHydratedDeploymentsPagedResponse>
        listHydratedDeploymentsSettings;
    private final UnaryCallSettings.Builder<UpdateHydratedDeploymentRequest, HydratedDeployment>
        updateHydratedDeploymentSettings;
    private final UnaryCallSettings.Builder<ApplyHydratedDeploymentRequest, HydratedDeployment>
        applyHydratedDeploymentSettings;
    private final PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings;
    private final UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
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
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_1_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listOrchestrationClustersSettings =
          PagedCallSettings.newBuilder(LIST_ORCHESTRATION_CLUSTERS_PAGE_STR_FACT);
      getOrchestrationClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createOrchestrationClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createOrchestrationClusterOperationSettings = OperationCallSettings.newBuilder();
      deleteOrchestrationClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteOrchestrationClusterOperationSettings = OperationCallSettings.newBuilder();
      listEdgeSlmsSettings = PagedCallSettings.newBuilder(LIST_EDGE_SLMS_PAGE_STR_FACT);
      getEdgeSlmSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createEdgeSlmSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createEdgeSlmOperationSettings = OperationCallSettings.newBuilder();
      deleteEdgeSlmSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteEdgeSlmOperationSettings = OperationCallSettings.newBuilder();
      createBlueprintSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateBlueprintSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getBlueprintSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteBlueprintSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listBlueprintsSettings = PagedCallSettings.newBuilder(LIST_BLUEPRINTS_PAGE_STR_FACT);
      approveBlueprintSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      proposeBlueprintSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      rejectBlueprintSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listBlueprintRevisionsSettings =
          PagedCallSettings.newBuilder(LIST_BLUEPRINT_REVISIONS_PAGE_STR_FACT);
      searchBlueprintRevisionsSettings =
          PagedCallSettings.newBuilder(SEARCH_BLUEPRINT_REVISIONS_PAGE_STR_FACT);
      searchDeploymentRevisionsSettings =
          PagedCallSettings.newBuilder(SEARCH_DEPLOYMENT_REVISIONS_PAGE_STR_FACT);
      discardBlueprintChangesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listPublicBlueprintsSettings =
          PagedCallSettings.newBuilder(LIST_PUBLIC_BLUEPRINTS_PAGE_STR_FACT);
      getPublicBlueprintSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createDeploymentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateDeploymentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getDeploymentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      removeDeploymentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listDeploymentsSettings = PagedCallSettings.newBuilder(LIST_DEPLOYMENTS_PAGE_STR_FACT);
      listDeploymentRevisionsSettings =
          PagedCallSettings.newBuilder(LIST_DEPLOYMENT_REVISIONS_PAGE_STR_FACT);
      discardDeploymentChangesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      applyDeploymentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      computeDeploymentStatusSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      rollbackDeploymentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getHydratedDeploymentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listHydratedDeploymentsSettings =
          PagedCallSettings.newBuilder(LIST_HYDRATED_DEPLOYMENTS_PAGE_STR_FACT);
      updateHydratedDeploymentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      applyHydratedDeploymentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listOrchestrationClustersSettings,
              getOrchestrationClusterSettings,
              createOrchestrationClusterSettings,
              deleteOrchestrationClusterSettings,
              listEdgeSlmsSettings,
              getEdgeSlmSettings,
              createEdgeSlmSettings,
              deleteEdgeSlmSettings,
              createBlueprintSettings,
              updateBlueprintSettings,
              getBlueprintSettings,
              deleteBlueprintSettings,
              listBlueprintsSettings,
              approveBlueprintSettings,
              proposeBlueprintSettings,
              rejectBlueprintSettings,
              listBlueprintRevisionsSettings,
              searchBlueprintRevisionsSettings,
              searchDeploymentRevisionsSettings,
              discardBlueprintChangesSettings,
              listPublicBlueprintsSettings,
              getPublicBlueprintSettings,
              createDeploymentSettings,
              updateDeploymentSettings,
              getDeploymentSettings,
              removeDeploymentSettings,
              listDeploymentsSettings,
              listDeploymentRevisionsSettings,
              discardDeploymentChangesSettings,
              applyDeploymentSettings,
              computeDeploymentStatusSettings,
              rollbackDeploymentSettings,
              getHydratedDeploymentSettings,
              listHydratedDeploymentsSettings,
              updateHydratedDeploymentSettings,
              applyHydratedDeploymentSettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(TelcoAutomationStubSettings settings) {
      super(settings);

      listOrchestrationClustersSettings = settings.listOrchestrationClustersSettings.toBuilder();
      getOrchestrationClusterSettings = settings.getOrchestrationClusterSettings.toBuilder();
      createOrchestrationClusterSettings = settings.createOrchestrationClusterSettings.toBuilder();
      createOrchestrationClusterOperationSettings =
          settings.createOrchestrationClusterOperationSettings.toBuilder();
      deleteOrchestrationClusterSettings = settings.deleteOrchestrationClusterSettings.toBuilder();
      deleteOrchestrationClusterOperationSettings =
          settings.deleteOrchestrationClusterOperationSettings.toBuilder();
      listEdgeSlmsSettings = settings.listEdgeSlmsSettings.toBuilder();
      getEdgeSlmSettings = settings.getEdgeSlmSettings.toBuilder();
      createEdgeSlmSettings = settings.createEdgeSlmSettings.toBuilder();
      createEdgeSlmOperationSettings = settings.createEdgeSlmOperationSettings.toBuilder();
      deleteEdgeSlmSettings = settings.deleteEdgeSlmSettings.toBuilder();
      deleteEdgeSlmOperationSettings = settings.deleteEdgeSlmOperationSettings.toBuilder();
      createBlueprintSettings = settings.createBlueprintSettings.toBuilder();
      updateBlueprintSettings = settings.updateBlueprintSettings.toBuilder();
      getBlueprintSettings = settings.getBlueprintSettings.toBuilder();
      deleteBlueprintSettings = settings.deleteBlueprintSettings.toBuilder();
      listBlueprintsSettings = settings.listBlueprintsSettings.toBuilder();
      approveBlueprintSettings = settings.approveBlueprintSettings.toBuilder();
      proposeBlueprintSettings = settings.proposeBlueprintSettings.toBuilder();
      rejectBlueprintSettings = settings.rejectBlueprintSettings.toBuilder();
      listBlueprintRevisionsSettings = settings.listBlueprintRevisionsSettings.toBuilder();
      searchBlueprintRevisionsSettings = settings.searchBlueprintRevisionsSettings.toBuilder();
      searchDeploymentRevisionsSettings = settings.searchDeploymentRevisionsSettings.toBuilder();
      discardBlueprintChangesSettings = settings.discardBlueprintChangesSettings.toBuilder();
      listPublicBlueprintsSettings = settings.listPublicBlueprintsSettings.toBuilder();
      getPublicBlueprintSettings = settings.getPublicBlueprintSettings.toBuilder();
      createDeploymentSettings = settings.createDeploymentSettings.toBuilder();
      updateDeploymentSettings = settings.updateDeploymentSettings.toBuilder();
      getDeploymentSettings = settings.getDeploymentSettings.toBuilder();
      removeDeploymentSettings = settings.removeDeploymentSettings.toBuilder();
      listDeploymentsSettings = settings.listDeploymentsSettings.toBuilder();
      listDeploymentRevisionsSettings = settings.listDeploymentRevisionsSettings.toBuilder();
      discardDeploymentChangesSettings = settings.discardDeploymentChangesSettings.toBuilder();
      applyDeploymentSettings = settings.applyDeploymentSettings.toBuilder();
      computeDeploymentStatusSettings = settings.computeDeploymentStatusSettings.toBuilder();
      rollbackDeploymentSettings = settings.rollbackDeploymentSettings.toBuilder();
      getHydratedDeploymentSettings = settings.getHydratedDeploymentSettings.toBuilder();
      listHydratedDeploymentsSettings = settings.listHydratedDeploymentsSettings.toBuilder();
      updateHydratedDeploymentSettings = settings.updateHydratedDeploymentSettings.toBuilder();
      applyHydratedDeploymentSettings = settings.applyHydratedDeploymentSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listOrchestrationClustersSettings,
              getOrchestrationClusterSettings,
              createOrchestrationClusterSettings,
              deleteOrchestrationClusterSettings,
              listEdgeSlmsSettings,
              getEdgeSlmSettings,
              createEdgeSlmSettings,
              deleteEdgeSlmSettings,
              createBlueprintSettings,
              updateBlueprintSettings,
              getBlueprintSettings,
              deleteBlueprintSettings,
              listBlueprintsSettings,
              approveBlueprintSettings,
              proposeBlueprintSettings,
              rejectBlueprintSettings,
              listBlueprintRevisionsSettings,
              searchBlueprintRevisionsSettings,
              searchDeploymentRevisionsSettings,
              discardBlueprintChangesSettings,
              listPublicBlueprintsSettings,
              getPublicBlueprintSettings,
              createDeploymentSettings,
              updateDeploymentSettings,
              getDeploymentSettings,
              removeDeploymentSettings,
              listDeploymentsSettings,
              listDeploymentRevisionsSettings,
              discardDeploymentChangesSettings,
              applyDeploymentSettings,
              computeDeploymentStatusSettings,
              rollbackDeploymentSettings,
              getHydratedDeploymentSettings,
              listHydratedDeploymentsSettings,
              updateHydratedDeploymentSettings,
              applyHydratedDeploymentSettings,
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
          .listOrchestrationClustersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getOrchestrationClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createOrchestrationClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteOrchestrationClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listEdgeSlmsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getEdgeSlmSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createEdgeSlmSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteEdgeSlmSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createBlueprintSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateBlueprintSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getBlueprintSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteBlueprintSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listBlueprintsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .approveBlueprintSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .proposeBlueprintSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .rejectBlueprintSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listBlueprintRevisionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .searchBlueprintRevisionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .searchDeploymentRevisionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .discardBlueprintChangesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listPublicBlueprintsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getPublicBlueprintSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createDeploymentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateDeploymentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getDeploymentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .removeDeploymentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listDeploymentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listDeploymentRevisionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .discardDeploymentChangesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .applyDeploymentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .computeDeploymentStatusSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .rollbackDeploymentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getHydratedDeploymentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listHydratedDeploymentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateHydratedDeploymentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .applyHydratedDeploymentSettings()
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
          .createOrchestrationClusterOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateOrchestrationClusterRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(OrchestrationCluster.class))
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
          .deleteOrchestrationClusterOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteOrchestrationClusterRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
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
          .createEdgeSlmOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateEdgeSlmRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(EdgeSlm.class))
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
          .deleteEdgeSlmOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteEdgeSlmRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
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

    /** Returns the builder for the settings used for calls to listOrchestrationClusters. */
    public PagedCallSettings.Builder<
            ListOrchestrationClustersRequest,
            ListOrchestrationClustersResponse,
            ListOrchestrationClustersPagedResponse>
        listOrchestrationClustersSettings() {
      return listOrchestrationClustersSettings;
    }

    /** Returns the builder for the settings used for calls to getOrchestrationCluster. */
    public UnaryCallSettings.Builder<GetOrchestrationClusterRequest, OrchestrationCluster>
        getOrchestrationClusterSettings() {
      return getOrchestrationClusterSettings;
    }

    /** Returns the builder for the settings used for calls to createOrchestrationCluster. */
    public UnaryCallSettings.Builder<CreateOrchestrationClusterRequest, Operation>
        createOrchestrationClusterSettings() {
      return createOrchestrationClusterSettings;
    }

    /** Returns the builder for the settings used for calls to createOrchestrationCluster. */
    public OperationCallSettings.Builder<
            CreateOrchestrationClusterRequest, OrchestrationCluster, OperationMetadata>
        createOrchestrationClusterOperationSettings() {
      return createOrchestrationClusterOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteOrchestrationCluster. */
    public UnaryCallSettings.Builder<DeleteOrchestrationClusterRequest, Operation>
        deleteOrchestrationClusterSettings() {
      return deleteOrchestrationClusterSettings;
    }

    /** Returns the builder for the settings used for calls to deleteOrchestrationCluster. */
    public OperationCallSettings.Builder<
            DeleteOrchestrationClusterRequest, Empty, OperationMetadata>
        deleteOrchestrationClusterOperationSettings() {
      return deleteOrchestrationClusterOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listEdgeSlms. */
    public PagedCallSettings.Builder<
            ListEdgeSlmsRequest, ListEdgeSlmsResponse, ListEdgeSlmsPagedResponse>
        listEdgeSlmsSettings() {
      return listEdgeSlmsSettings;
    }

    /** Returns the builder for the settings used for calls to getEdgeSlm. */
    public UnaryCallSettings.Builder<GetEdgeSlmRequest, EdgeSlm> getEdgeSlmSettings() {
      return getEdgeSlmSettings;
    }

    /** Returns the builder for the settings used for calls to createEdgeSlm. */
    public UnaryCallSettings.Builder<CreateEdgeSlmRequest, Operation> createEdgeSlmSettings() {
      return createEdgeSlmSettings;
    }

    /** Returns the builder for the settings used for calls to createEdgeSlm. */
    public OperationCallSettings.Builder<CreateEdgeSlmRequest, EdgeSlm, OperationMetadata>
        createEdgeSlmOperationSettings() {
      return createEdgeSlmOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteEdgeSlm. */
    public UnaryCallSettings.Builder<DeleteEdgeSlmRequest, Operation> deleteEdgeSlmSettings() {
      return deleteEdgeSlmSettings;
    }

    /** Returns the builder for the settings used for calls to deleteEdgeSlm. */
    public OperationCallSettings.Builder<DeleteEdgeSlmRequest, Empty, OperationMetadata>
        deleteEdgeSlmOperationSettings() {
      return deleteEdgeSlmOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createBlueprint. */
    public UnaryCallSettings.Builder<CreateBlueprintRequest, Blueprint> createBlueprintSettings() {
      return createBlueprintSettings;
    }

    /** Returns the builder for the settings used for calls to updateBlueprint. */
    public UnaryCallSettings.Builder<UpdateBlueprintRequest, Blueprint> updateBlueprintSettings() {
      return updateBlueprintSettings;
    }

    /** Returns the builder for the settings used for calls to getBlueprint. */
    public UnaryCallSettings.Builder<GetBlueprintRequest, Blueprint> getBlueprintSettings() {
      return getBlueprintSettings;
    }

    /** Returns the builder for the settings used for calls to deleteBlueprint. */
    public UnaryCallSettings.Builder<DeleteBlueprintRequest, Empty> deleteBlueprintSettings() {
      return deleteBlueprintSettings;
    }

    /** Returns the builder for the settings used for calls to listBlueprints. */
    public PagedCallSettings.Builder<
            ListBlueprintsRequest, ListBlueprintsResponse, ListBlueprintsPagedResponse>
        listBlueprintsSettings() {
      return listBlueprintsSettings;
    }

    /** Returns the builder for the settings used for calls to approveBlueprint. */
    public UnaryCallSettings.Builder<ApproveBlueprintRequest, Blueprint>
        approveBlueprintSettings() {
      return approveBlueprintSettings;
    }

    /** Returns the builder for the settings used for calls to proposeBlueprint. */
    public UnaryCallSettings.Builder<ProposeBlueprintRequest, Blueprint>
        proposeBlueprintSettings() {
      return proposeBlueprintSettings;
    }

    /** Returns the builder for the settings used for calls to rejectBlueprint. */
    public UnaryCallSettings.Builder<RejectBlueprintRequest, Blueprint> rejectBlueprintSettings() {
      return rejectBlueprintSettings;
    }

    /** Returns the builder for the settings used for calls to listBlueprintRevisions. */
    public PagedCallSettings.Builder<
            ListBlueprintRevisionsRequest,
            ListBlueprintRevisionsResponse,
            ListBlueprintRevisionsPagedResponse>
        listBlueprintRevisionsSettings() {
      return listBlueprintRevisionsSettings;
    }

    /** Returns the builder for the settings used for calls to searchBlueprintRevisions. */
    public PagedCallSettings.Builder<
            SearchBlueprintRevisionsRequest,
            SearchBlueprintRevisionsResponse,
            SearchBlueprintRevisionsPagedResponse>
        searchBlueprintRevisionsSettings() {
      return searchBlueprintRevisionsSettings;
    }

    /** Returns the builder for the settings used for calls to searchDeploymentRevisions. */
    public PagedCallSettings.Builder<
            SearchDeploymentRevisionsRequest,
            SearchDeploymentRevisionsResponse,
            SearchDeploymentRevisionsPagedResponse>
        searchDeploymentRevisionsSettings() {
      return searchDeploymentRevisionsSettings;
    }

    /** Returns the builder for the settings used for calls to discardBlueprintChanges. */
    public UnaryCallSettings.Builder<
            DiscardBlueprintChangesRequest, DiscardBlueprintChangesResponse>
        discardBlueprintChangesSettings() {
      return discardBlueprintChangesSettings;
    }

    /** Returns the builder for the settings used for calls to listPublicBlueprints. */
    public PagedCallSettings.Builder<
            ListPublicBlueprintsRequest,
            ListPublicBlueprintsResponse,
            ListPublicBlueprintsPagedResponse>
        listPublicBlueprintsSettings() {
      return listPublicBlueprintsSettings;
    }

    /** Returns the builder for the settings used for calls to getPublicBlueprint. */
    public UnaryCallSettings.Builder<GetPublicBlueprintRequest, PublicBlueprint>
        getPublicBlueprintSettings() {
      return getPublicBlueprintSettings;
    }

    /** Returns the builder for the settings used for calls to createDeployment. */
    public UnaryCallSettings.Builder<CreateDeploymentRequest, Deployment>
        createDeploymentSettings() {
      return createDeploymentSettings;
    }

    /** Returns the builder for the settings used for calls to updateDeployment. */
    public UnaryCallSettings.Builder<UpdateDeploymentRequest, Deployment>
        updateDeploymentSettings() {
      return updateDeploymentSettings;
    }

    /** Returns the builder for the settings used for calls to getDeployment. */
    public UnaryCallSettings.Builder<GetDeploymentRequest, Deployment> getDeploymentSettings() {
      return getDeploymentSettings;
    }

    /** Returns the builder for the settings used for calls to removeDeployment. */
    public UnaryCallSettings.Builder<RemoveDeploymentRequest, Empty> removeDeploymentSettings() {
      return removeDeploymentSettings;
    }

    /** Returns the builder for the settings used for calls to listDeployments. */
    public PagedCallSettings.Builder<
            ListDeploymentsRequest, ListDeploymentsResponse, ListDeploymentsPagedResponse>
        listDeploymentsSettings() {
      return listDeploymentsSettings;
    }

    /** Returns the builder for the settings used for calls to listDeploymentRevisions. */
    public PagedCallSettings.Builder<
            ListDeploymentRevisionsRequest,
            ListDeploymentRevisionsResponse,
            ListDeploymentRevisionsPagedResponse>
        listDeploymentRevisionsSettings() {
      return listDeploymentRevisionsSettings;
    }

    /** Returns the builder for the settings used for calls to discardDeploymentChanges. */
    public UnaryCallSettings.Builder<
            DiscardDeploymentChangesRequest, DiscardDeploymentChangesResponse>
        discardDeploymentChangesSettings() {
      return discardDeploymentChangesSettings;
    }

    /** Returns the builder for the settings used for calls to applyDeployment. */
    public UnaryCallSettings.Builder<ApplyDeploymentRequest, Deployment> applyDeploymentSettings() {
      return applyDeploymentSettings;
    }

    /** Returns the builder for the settings used for calls to computeDeploymentStatus. */
    public UnaryCallSettings.Builder<
            ComputeDeploymentStatusRequest, ComputeDeploymentStatusResponse>
        computeDeploymentStatusSettings() {
      return computeDeploymentStatusSettings;
    }

    /** Returns the builder for the settings used for calls to rollbackDeployment. */
    public UnaryCallSettings.Builder<RollbackDeploymentRequest, Deployment>
        rollbackDeploymentSettings() {
      return rollbackDeploymentSettings;
    }

    /** Returns the builder for the settings used for calls to getHydratedDeployment. */
    public UnaryCallSettings.Builder<GetHydratedDeploymentRequest, HydratedDeployment>
        getHydratedDeploymentSettings() {
      return getHydratedDeploymentSettings;
    }

    /** Returns the builder for the settings used for calls to listHydratedDeployments. */
    public PagedCallSettings.Builder<
            ListHydratedDeploymentsRequest,
            ListHydratedDeploymentsResponse,
            ListHydratedDeploymentsPagedResponse>
        listHydratedDeploymentsSettings() {
      return listHydratedDeploymentsSettings;
    }

    /** Returns the builder for the settings used for calls to updateHydratedDeployment. */
    public UnaryCallSettings.Builder<UpdateHydratedDeploymentRequest, HydratedDeployment>
        updateHydratedDeploymentSettings() {
      return updateHydratedDeploymentSettings;
    }

    /** Returns the builder for the settings used for calls to applyHydratedDeployment. */
    public UnaryCallSettings.Builder<ApplyHydratedDeploymentRequest, HydratedDeployment>
        applyHydratedDeploymentSettings() {
      return applyHydratedDeploymentSettings;
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
    public TelcoAutomationStubSettings build() throws IOException {
      return new TelcoAutomationStubSettings(this);
    }
  }
}
