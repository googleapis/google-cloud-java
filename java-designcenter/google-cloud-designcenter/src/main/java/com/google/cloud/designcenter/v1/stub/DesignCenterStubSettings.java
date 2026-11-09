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

package com.google.cloud.designcenter.v1.stub;

import static com.google.cloud.designcenter.v1.DesignCenterClient.FetchFrameworksPagedResponse;
import static com.google.cloud.designcenter.v1.DesignCenterClient.ListApplicationTemplateRevisionsPagedResponse;
import static com.google.cloud.designcenter.v1.DesignCenterClient.ListApplicationTemplateSystemRevisionsPagedResponse;
import static com.google.cloud.designcenter.v1.DesignCenterClient.ListApplicationTemplatesPagedResponse;
import static com.google.cloud.designcenter.v1.DesignCenterClient.ListApplicationsPagedResponse;
import static com.google.cloud.designcenter.v1.DesignCenterClient.ListCatalogTemplateRevisionsPagedResponse;
import static com.google.cloud.designcenter.v1.DesignCenterClient.ListCatalogTemplatesPagedResponse;
import static com.google.cloud.designcenter.v1.DesignCenterClient.ListCatalogsPagedResponse;
import static com.google.cloud.designcenter.v1.DesignCenterClient.ListComponentsPagedResponse;
import static com.google.cloud.designcenter.v1.DesignCenterClient.ListConnectionsPagedResponse;
import static com.google.cloud.designcenter.v1.DesignCenterClient.ListLocationsPagedResponse;
import static com.google.cloud.designcenter.v1.DesignCenterClient.ListPoliciesPagedResponse;
import static com.google.cloud.designcenter.v1.DesignCenterClient.ListSharedTemplateRevisionsPagedResponse;
import static com.google.cloud.designcenter.v1.DesignCenterClient.ListSharedTemplatesPagedResponse;
import static com.google.cloud.designcenter.v1.DesignCenterClient.ListSharesPagedResponse;
import static com.google.cloud.designcenter.v1.DesignCenterClient.ListSpacesPagedResponse;

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
import com.google.api.gax.rpc.LibraryMetadata;
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
import com.google.cloud.designcenter.v1.Application;
import com.google.cloud.designcenter.v1.ApplicationTemplate;
import com.google.cloud.designcenter.v1.ApplicationTemplateRevision;
import com.google.cloud.designcenter.v1.ApplicationTemplateSystemRevision;
import com.google.cloud.designcenter.v1.Catalog;
import com.google.cloud.designcenter.v1.CatalogTemplate;
import com.google.cloud.designcenter.v1.CatalogTemplateRevision;
import com.google.cloud.designcenter.v1.CommitApplicationTemplateRequest;
import com.google.cloud.designcenter.v1.Component;
import com.google.cloud.designcenter.v1.Connection;
import com.google.cloud.designcenter.v1.CreateApplicationRequest;
import com.google.cloud.designcenter.v1.CreateApplicationTemplateRequest;
import com.google.cloud.designcenter.v1.CreateCatalogRequest;
import com.google.cloud.designcenter.v1.CreateCatalogTemplateRequest;
import com.google.cloud.designcenter.v1.CreateCatalogTemplateRevisionRequest;
import com.google.cloud.designcenter.v1.CreateComponentRequest;
import com.google.cloud.designcenter.v1.CreateConnectionRequest;
import com.google.cloud.designcenter.v1.CreatePolicyRequest;
import com.google.cloud.designcenter.v1.CreateShareRequest;
import com.google.cloud.designcenter.v1.CreateSpaceRequest;
import com.google.cloud.designcenter.v1.DeleteApplicationRequest;
import com.google.cloud.designcenter.v1.DeleteApplicationTemplateRequest;
import com.google.cloud.designcenter.v1.DeleteApplicationTemplateRevisionRequest;
import com.google.cloud.designcenter.v1.DeleteCatalogRequest;
import com.google.cloud.designcenter.v1.DeleteCatalogTemplateRequest;
import com.google.cloud.designcenter.v1.DeleteCatalogTemplateRevisionRequest;
import com.google.cloud.designcenter.v1.DeleteComponentRequest;
import com.google.cloud.designcenter.v1.DeleteConnectionRequest;
import com.google.cloud.designcenter.v1.DeletePolicyRequest;
import com.google.cloud.designcenter.v1.DeleteShareRequest;
import com.google.cloud.designcenter.v1.DeleteSpaceRequest;
import com.google.cloud.designcenter.v1.DeployApplicationRequest;
import com.google.cloud.designcenter.v1.DeployApplicationResponse;
import com.google.cloud.designcenter.v1.ExportApplicationIaCRequest;
import com.google.cloud.designcenter.v1.ExportApplicationIaCResponse;
import com.google.cloud.designcenter.v1.ExportApplicationTemplateIaCRequest;
import com.google.cloud.designcenter.v1.ExportApplicationTemplateIaCResponse;
import com.google.cloud.designcenter.v1.ExportApplicationTemplateRevisionIaCRequest;
import com.google.cloud.designcenter.v1.ExportApplicationTemplateRevisionIaCResponse;
import com.google.cloud.designcenter.v1.FetchApplicationAssessmentReportRequest;
import com.google.cloud.designcenter.v1.FetchApplicationAssessmentReportResponse;
import com.google.cloud.designcenter.v1.FetchFrameworksRequest;
import com.google.cloud.designcenter.v1.FetchFrameworksResponse;
import com.google.cloud.designcenter.v1.Framework;
import com.google.cloud.designcenter.v1.GenerateApplicationAssessmentReportRequest;
import com.google.cloud.designcenter.v1.GenerateApplicationAssessmentReportResponse;
import com.google.cloud.designcenter.v1.GenerateApplicationIaCRequest;
import com.google.cloud.designcenter.v1.GenerateApplicationIaCResponse;
import com.google.cloud.designcenter.v1.GenerateApplicationTemplateAssessmentReportRequest;
import com.google.cloud.designcenter.v1.GenerateApplicationTemplateAssessmentReportResponse;
import com.google.cloud.designcenter.v1.GenerateApplicationTemplateIaCRequest;
import com.google.cloud.designcenter.v1.GenerateApplicationTemplateIaCResponse;
import com.google.cloud.designcenter.v1.GenerateApplicationTemplateRevisionIaCRequest;
import com.google.cloud.designcenter.v1.GenerateApplicationTemplateRevisionIaCResponse;
import com.google.cloud.designcenter.v1.GenerateAssessmentReportRequest;
import com.google.cloud.designcenter.v1.GenerateAssessmentReportResponse;
import com.google.cloud.designcenter.v1.GenerateTerraformPlanAssessmentReportRequest;
import com.google.cloud.designcenter.v1.GenerateTerraformPlanAssessmentReportResponse;
import com.google.cloud.designcenter.v1.GetApplicationRequest;
import com.google.cloud.designcenter.v1.GetApplicationTemplateRequest;
import com.google.cloud.designcenter.v1.GetApplicationTemplateRevisionRequest;
import com.google.cloud.designcenter.v1.GetApplicationTemplateSystemRevisionRequest;
import com.google.cloud.designcenter.v1.GetCatalogRequest;
import com.google.cloud.designcenter.v1.GetCatalogTemplateRequest;
import com.google.cloud.designcenter.v1.GetCatalogTemplateRevisionRequest;
import com.google.cloud.designcenter.v1.GetComponentRequest;
import com.google.cloud.designcenter.v1.GetConnectionRequest;
import com.google.cloud.designcenter.v1.GetPolicyRequest;
import com.google.cloud.designcenter.v1.GetShareRequest;
import com.google.cloud.designcenter.v1.GetSharedTemplateRequest;
import com.google.cloud.designcenter.v1.GetSharedTemplateRevisionRequest;
import com.google.cloud.designcenter.v1.GetSpaceRequest;
import com.google.cloud.designcenter.v1.ImportApplicationIaCRequest;
import com.google.cloud.designcenter.v1.ImportApplicationIaCResponse;
import com.google.cloud.designcenter.v1.ImportApplicationTemplateIaCRequest;
import com.google.cloud.designcenter.v1.ImportApplicationTemplateIaCResponse;
import com.google.cloud.designcenter.v1.ImportApplicationTemplateRequest;
import com.google.cloud.designcenter.v1.IngestApplicationTemplateIaCRequest;
import com.google.cloud.designcenter.v1.IngestApplicationTemplateIaCResponse;
import com.google.cloud.designcenter.v1.ListApplicationTemplateRevisionsRequest;
import com.google.cloud.designcenter.v1.ListApplicationTemplateRevisionsResponse;
import com.google.cloud.designcenter.v1.ListApplicationTemplateSystemRevisionsRequest;
import com.google.cloud.designcenter.v1.ListApplicationTemplateSystemRevisionsResponse;
import com.google.cloud.designcenter.v1.ListApplicationTemplatesRequest;
import com.google.cloud.designcenter.v1.ListApplicationTemplatesResponse;
import com.google.cloud.designcenter.v1.ListApplicationsRequest;
import com.google.cloud.designcenter.v1.ListApplicationsResponse;
import com.google.cloud.designcenter.v1.ListCatalogTemplateRevisionsRequest;
import com.google.cloud.designcenter.v1.ListCatalogTemplateRevisionsResponse;
import com.google.cloud.designcenter.v1.ListCatalogTemplatesRequest;
import com.google.cloud.designcenter.v1.ListCatalogTemplatesResponse;
import com.google.cloud.designcenter.v1.ListCatalogsRequest;
import com.google.cloud.designcenter.v1.ListCatalogsResponse;
import com.google.cloud.designcenter.v1.ListComponentsRequest;
import com.google.cloud.designcenter.v1.ListComponentsResponse;
import com.google.cloud.designcenter.v1.ListConnectionsRequest;
import com.google.cloud.designcenter.v1.ListConnectionsResponse;
import com.google.cloud.designcenter.v1.ListPoliciesRequest;
import com.google.cloud.designcenter.v1.ListPoliciesResponse;
import com.google.cloud.designcenter.v1.ListSharedTemplateRevisionsRequest;
import com.google.cloud.designcenter.v1.ListSharedTemplateRevisionsResponse;
import com.google.cloud.designcenter.v1.ListSharedTemplatesRequest;
import com.google.cloud.designcenter.v1.ListSharedTemplatesResponse;
import com.google.cloud.designcenter.v1.ListSharesRequest;
import com.google.cloud.designcenter.v1.ListSharesResponse;
import com.google.cloud.designcenter.v1.ListSpacesRequest;
import com.google.cloud.designcenter.v1.ListSpacesResponse;
import com.google.cloud.designcenter.v1.OperationMetadata;
import com.google.cloud.designcenter.v1.Policy;
import com.google.cloud.designcenter.v1.PreviewApplicationRequest;
import com.google.cloud.designcenter.v1.PreviewApplicationResponse;
import com.google.cloud.designcenter.v1.RecommendIAMRolesRequest;
import com.google.cloud.designcenter.v1.RecommendIAMRolesResponse;
import com.google.cloud.designcenter.v1.RegisterAppHubApplicationResourcesRequest;
import com.google.cloud.designcenter.v1.RegisterAppHubApplicationResourcesResponse;
import com.google.cloud.designcenter.v1.Share;
import com.google.cloud.designcenter.v1.SharedTemplate;
import com.google.cloud.designcenter.v1.SharedTemplateRevision;
import com.google.cloud.designcenter.v1.SnapshotApplicationTemplateRequest;
import com.google.cloud.designcenter.v1.SnapshotApplicationTemplateResponse;
import com.google.cloud.designcenter.v1.Space;
import com.google.cloud.designcenter.v1.SyncShareRequest;
import com.google.cloud.designcenter.v1.UpdateApplicationRequest;
import com.google.cloud.designcenter.v1.UpdateApplicationTemplateRequest;
import com.google.cloud.designcenter.v1.UpdateCatalogRequest;
import com.google.cloud.designcenter.v1.UpdateCatalogTemplateRequest;
import com.google.cloud.designcenter.v1.UpdateComponentRequest;
import com.google.cloud.designcenter.v1.UpdateConnectionRequest;
import com.google.cloud.designcenter.v1.UpdatePolicyRequest;
import com.google.cloud.designcenter.v1.UpdateSpaceRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link DesignCenterStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (designcenter.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getSpace:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DesignCenterStubSettings.Builder designCenterSettingsBuilder =
 *     DesignCenterStubSettings.newBuilder();
 * designCenterSettingsBuilder
 *     .getSpaceSettings()
 *     .setRetrySettings(
 *         designCenterSettingsBuilder
 *             .getSpaceSettings()
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
 * DesignCenterStubSettings designCenterSettings = designCenterSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for snapshotApplicationTemplate:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DesignCenterStubSettings.Builder designCenterSettingsBuilder =
 *     DesignCenterStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * designCenterSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@NullMarked
@Generated("by gapic-generator-java")
@SuppressWarnings("CanonicalDuration")
public class DesignCenterStubSettings extends StubSettings<DesignCenterStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<GetSpaceRequest, Space> getSpaceSettings;
  private final PagedCallSettings<ListSpacesRequest, ListSpacesResponse, ListSpacesPagedResponse>
      listSpacesSettings;
  private final UnaryCallSettings<CreateSpaceRequest, Space> createSpaceSettings;
  private final UnaryCallSettings<UpdateSpaceRequest, Space> updateSpaceSettings;
  private final UnaryCallSettings<DeleteSpaceRequest, Empty> deleteSpaceSettings;
  private final UnaryCallSettings<GetApplicationTemplateRequest, ApplicationTemplate>
      getApplicationTemplateSettings;
  private final PagedCallSettings<
          ListApplicationTemplatesRequest,
          ListApplicationTemplatesResponse,
          ListApplicationTemplatesPagedResponse>
      listApplicationTemplatesSettings;
  private final UnaryCallSettings<CreateApplicationTemplateRequest, ApplicationTemplate>
      createApplicationTemplateSettings;
  private final UnaryCallSettings<UpdateApplicationTemplateRequest, ApplicationTemplate>
      updateApplicationTemplateSettings;
  private final UnaryCallSettings<ImportApplicationTemplateRequest, ApplicationTemplate>
      importApplicationTemplateSettings;
  private final UnaryCallSettings<DeleteApplicationTemplateRequest, Empty>
      deleteApplicationTemplateSettings;
  private final UnaryCallSettings<CommitApplicationTemplateRequest, ApplicationTemplateRevision>
      commitApplicationTemplateSettings;
  private final UnaryCallSettings<SnapshotApplicationTemplateRequest, Operation>
      snapshotApplicationTemplateSettings;
  private final OperationCallSettings<
          SnapshotApplicationTemplateRequest,
          SnapshotApplicationTemplateResponse,
          OperationMetadata>
      snapshotApplicationTemplateOperationSettings;
  private final UnaryCallSettings<
          GenerateApplicationTemplateIaCRequest, GenerateApplicationTemplateIaCResponse>
      generateApplicationTemplateIaCSettings;
  private final UnaryCallSettings<ExportApplicationTemplateIaCRequest, Operation>
      exportApplicationTemplateIaCSettings;
  private final OperationCallSettings<
          ExportApplicationTemplateIaCRequest,
          ExportApplicationTemplateIaCResponse,
          OperationMetadata>
      exportApplicationTemplateIaCOperationSettings;
  private final UnaryCallSettings<
          GenerateApplicationTemplateRevisionIaCRequest,
          GenerateApplicationTemplateRevisionIaCResponse>
      generateApplicationTemplateRevisionIaCSettings;
  private final UnaryCallSettings<ExportApplicationTemplateRevisionIaCRequest, Operation>
      exportApplicationTemplateRevisionIaCSettings;
  private final OperationCallSettings<
          ExportApplicationTemplateRevisionIaCRequest,
          ExportApplicationTemplateRevisionIaCResponse,
          OperationMetadata>
      exportApplicationTemplateRevisionIaCOperationSettings;
  private final UnaryCallSettings<GetComponentRequest, Component> getComponentSettings;
  private final PagedCallSettings<
          ListComponentsRequest, ListComponentsResponse, ListComponentsPagedResponse>
      listComponentsSettings;
  private final UnaryCallSettings<CreateComponentRequest, Component> createComponentSettings;
  private final UnaryCallSettings<UpdateComponentRequest, Component> updateComponentSettings;
  private final UnaryCallSettings<DeleteComponentRequest, Empty> deleteComponentSettings;
  private final UnaryCallSettings<GetConnectionRequest, Connection> getConnectionSettings;
  private final PagedCallSettings<
          ListConnectionsRequest, ListConnectionsResponse, ListConnectionsPagedResponse>
      listConnectionsSettings;
  private final UnaryCallSettings<CreateConnectionRequest, Connection> createConnectionSettings;
  private final UnaryCallSettings<UpdateConnectionRequest, Connection> updateConnectionSettings;
  private final UnaryCallSettings<DeleteConnectionRequest, Empty> deleteConnectionSettings;
  private final UnaryCallSettings<
          GetApplicationTemplateRevisionRequest, ApplicationTemplateRevision>
      getApplicationTemplateRevisionSettings;
  private final PagedCallSettings<
          ListApplicationTemplateRevisionsRequest,
          ListApplicationTemplateRevisionsResponse,
          ListApplicationTemplateRevisionsPagedResponse>
      listApplicationTemplateRevisionsSettings;
  private final UnaryCallSettings<DeleteApplicationTemplateRevisionRequest, Empty>
      deleteApplicationTemplateRevisionSettings;
  private final UnaryCallSettings<GetCatalogRequest, Catalog> getCatalogSettings;
  private final PagedCallSettings<
          ListCatalogsRequest, ListCatalogsResponse, ListCatalogsPagedResponse>
      listCatalogsSettings;
  private final UnaryCallSettings<CreateCatalogRequest, Catalog> createCatalogSettings;
  private final UnaryCallSettings<UpdateCatalogRequest, Catalog> updateCatalogSettings;
  private final UnaryCallSettings<DeleteCatalogRequest, Operation> deleteCatalogSettings;
  private final OperationCallSettings<DeleteCatalogRequest, Empty, OperationMetadata>
      deleteCatalogOperationSettings;
  private final UnaryCallSettings<CreateCatalogTemplateRequest, CatalogTemplate>
      createCatalogTemplateSettings;
  private final UnaryCallSettings<GetCatalogTemplateRequest, CatalogTemplate>
      getCatalogTemplateSettings;
  private final PagedCallSettings<
          ListCatalogTemplatesRequest,
          ListCatalogTemplatesResponse,
          ListCatalogTemplatesPagedResponse>
      listCatalogTemplatesSettings;
  private final UnaryCallSettings<UpdateCatalogTemplateRequest, CatalogTemplate>
      updateCatalogTemplateSettings;
  private final UnaryCallSettings<DeleteCatalogTemplateRequest, Operation>
      deleteCatalogTemplateSettings;
  private final OperationCallSettings<DeleteCatalogTemplateRequest, Empty, OperationMetadata>
      deleteCatalogTemplateOperationSettings;
  private final UnaryCallSettings<CreateShareRequest, Operation> createShareSettings;
  private final OperationCallSettings<CreateShareRequest, Share, OperationMetadata>
      createShareOperationSettings;
  private final PagedCallSettings<ListSharesRequest, ListSharesResponse, ListSharesPagedResponse>
      listSharesSettings;
  private final UnaryCallSettings<GetShareRequest, Share> getShareSettings;
  private final UnaryCallSettings<DeleteShareRequest, Operation> deleteShareSettings;
  private final OperationCallSettings<DeleteShareRequest, Empty, OperationMetadata>
      deleteShareOperationSettings;
  private final UnaryCallSettings<SyncShareRequest, Operation> syncShareSettings;
  private final OperationCallSettings<SyncShareRequest, Share, OperationMetadata>
      syncShareOperationSettings;
  private final UnaryCallSettings<GetSharedTemplateRequest, SharedTemplate>
      getSharedTemplateSettings;
  private final PagedCallSettings<
          ListSharedTemplatesRequest, ListSharedTemplatesResponse, ListSharedTemplatesPagedResponse>
      listSharedTemplatesSettings;
  private final UnaryCallSettings<GetSharedTemplateRevisionRequest, SharedTemplateRevision>
      getSharedTemplateRevisionSettings;
  private final PagedCallSettings<
          ListSharedTemplateRevisionsRequest,
          ListSharedTemplateRevisionsResponse,
          ListSharedTemplateRevisionsPagedResponse>
      listSharedTemplateRevisionsSettings;
  private final UnaryCallSettings<CreateCatalogTemplateRevisionRequest, Operation>
      createCatalogTemplateRevisionSettings;
  private final OperationCallSettings<
          CreateCatalogTemplateRevisionRequest, CatalogTemplateRevision, OperationMetadata>
      createCatalogTemplateRevisionOperationSettings;
  private final UnaryCallSettings<GetCatalogTemplateRevisionRequest, CatalogTemplateRevision>
      getCatalogTemplateRevisionSettings;
  private final PagedCallSettings<
          ListCatalogTemplateRevisionsRequest,
          ListCatalogTemplateRevisionsResponse,
          ListCatalogTemplateRevisionsPagedResponse>
      listCatalogTemplateRevisionsSettings;
  private final UnaryCallSettings<DeleteCatalogTemplateRevisionRequest, Operation>
      deleteCatalogTemplateRevisionSettings;
  private final OperationCallSettings<
          DeleteCatalogTemplateRevisionRequest, Empty, OperationMetadata>
      deleteCatalogTemplateRevisionOperationSettings;
  private final UnaryCallSettings<CreateApplicationRequest, Application> createApplicationSettings;
  private final UnaryCallSettings<GetApplicationRequest, Application> getApplicationSettings;
  private final PagedCallSettings<
          ListApplicationsRequest, ListApplicationsResponse, ListApplicationsPagedResponse>
      listApplicationsSettings;
  private final UnaryCallSettings<UpdateApplicationRequest, Application> updateApplicationSettings;
  private final UnaryCallSettings<DeleteApplicationRequest, Operation> deleteApplicationSettings;
  private final OperationCallSettings<DeleteApplicationRequest, Empty, OperationMetadata>
      deleteApplicationOperationSettings;
  private final UnaryCallSettings<DeployApplicationRequest, Operation> deployApplicationSettings;
  private final OperationCallSettings<
          DeployApplicationRequest, DeployApplicationResponse, OperationMetadata>
      deployApplicationOperationSettings;
  private final UnaryCallSettings<PreviewApplicationRequest, Operation> previewApplicationSettings;
  private final OperationCallSettings<
          PreviewApplicationRequest, PreviewApplicationResponse, OperationMetadata>
      previewApplicationOperationSettings;
  private final UnaryCallSettings<
          FetchApplicationAssessmentReportRequest, FetchApplicationAssessmentReportResponse>
      fetchApplicationAssessmentReportSettings;
  private final UnaryCallSettings<GenerateApplicationAssessmentReportRequest, Operation>
      generateApplicationAssessmentReportSettings;
  private final OperationCallSettings<
          GenerateApplicationAssessmentReportRequest,
          GenerateApplicationAssessmentReportResponse,
          OperationMetadata>
      generateApplicationAssessmentReportOperationSettings;
  private final UnaryCallSettings<GenerateApplicationTemplateAssessmentReportRequest, Operation>
      generateApplicationTemplateAssessmentReportSettings;
  private final OperationCallSettings<
          GenerateApplicationTemplateAssessmentReportRequest,
          GenerateApplicationTemplateAssessmentReportResponse,
          OperationMetadata>
      generateApplicationTemplateAssessmentReportOperationSettings;
  private final UnaryCallSettings<GenerateAssessmentReportRequest, Operation>
      generateAssessmentReportSettings;
  private final OperationCallSettings<
          GenerateAssessmentReportRequest, GenerateAssessmentReportResponse, OperationMetadata>
      generateAssessmentReportOperationSettings;
  private final UnaryCallSettings<GenerateTerraformPlanAssessmentReportRequest, Operation>
      generateTerraformPlanAssessmentReportSettings;
  private final OperationCallSettings<
          GenerateTerraformPlanAssessmentReportRequest,
          GenerateTerraformPlanAssessmentReportResponse,
          OperationMetadata>
      generateTerraformPlanAssessmentReportOperationSettings;
  private final UnaryCallSettings<GetPolicyRequest, Policy> getPolicySettings;
  private final PagedCallSettings<
          ListPoliciesRequest, ListPoliciesResponse, ListPoliciesPagedResponse>
      listPoliciesSettings;
  private final UnaryCallSettings<CreatePolicyRequest, Policy> createPolicySettings;
  private final UnaryCallSettings<UpdatePolicyRequest, Policy> updatePolicySettings;
  private final UnaryCallSettings<DeletePolicyRequest, Empty> deletePolicySettings;
  private final PagedCallSettings<
          FetchFrameworksRequest, FetchFrameworksResponse, FetchFrameworksPagedResponse>
      fetchFrameworksSettings;
  private final UnaryCallSettings<GenerateApplicationIaCRequest, GenerateApplicationIaCResponse>
      generateApplicationIaCSettings;
  private final UnaryCallSettings<ExportApplicationIaCRequest, Operation>
      exportApplicationIaCSettings;
  private final OperationCallSettings<
          ExportApplicationIaCRequest, ExportApplicationIaCResponse, OperationMetadata>
      exportApplicationIaCOperationSettings;
  private final UnaryCallSettings<
          ImportApplicationTemplateIaCRequest, ImportApplicationTemplateIaCResponse>
      importApplicationTemplateIaCSettings;
  private final UnaryCallSettings<IngestApplicationTemplateIaCRequest, Operation>
      ingestApplicationTemplateIaCSettings;
  private final OperationCallSettings<
          IngestApplicationTemplateIaCRequest,
          IngestApplicationTemplateIaCResponse,
          OperationMetadata>
      ingestApplicationTemplateIaCOperationSettings;
  private final UnaryCallSettings<ImportApplicationIaCRequest, ImportApplicationIaCResponse>
      importApplicationIaCSettings;
  private final UnaryCallSettings<RegisterAppHubApplicationResourcesRequest, Operation>
      registerAppHubApplicationResourcesSettings;
  private final OperationCallSettings<
          RegisterAppHubApplicationResourcesRequest,
          RegisterAppHubApplicationResourcesResponse,
          OperationMetadata>
      registerAppHubApplicationResourcesOperationSettings;
  private final PagedCallSettings<
          ListApplicationTemplateSystemRevisionsRequest,
          ListApplicationTemplateSystemRevisionsResponse,
          ListApplicationTemplateSystemRevisionsPagedResponse>
      listApplicationTemplateSystemRevisionsSettings;
  private final UnaryCallSettings<
          GetApplicationTemplateSystemRevisionRequest, ApplicationTemplateSystemRevision>
      getApplicationTemplateSystemRevisionSettings;
  private final UnaryCallSettings<RecommendIAMRolesRequest, Operation> recommendIAMRolesSettings;
  private final OperationCallSettings<
          RecommendIAMRolesRequest, RecommendIAMRolesResponse, OperationMetadata>
      recommendIAMRolesOperationSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, com.google.iam.v1.Policy>
      setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, com.google.iam.v1.Policy>
      getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<ListSpacesRequest, ListSpacesResponse, Space>
      LIST_SPACES_PAGE_STR_DESC =
          new PagedListDescriptor<ListSpacesRequest, ListSpacesResponse, Space>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListSpacesRequest injectToken(ListSpacesRequest payload, String token) {
              return ListSpacesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListSpacesRequest injectPageSize(ListSpacesRequest payload, int pageSize) {
              return ListSpacesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListSpacesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListSpacesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Space> extractResources(ListSpacesResponse payload) {
              return payload.getSpacesList();
            }
          };

  private static final PagedListDescriptor<
          ListApplicationTemplatesRequest, ListApplicationTemplatesResponse, ApplicationTemplate>
      LIST_APPLICATION_TEMPLATES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListApplicationTemplatesRequest,
              ListApplicationTemplatesResponse,
              ApplicationTemplate>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListApplicationTemplatesRequest injectToken(
                ListApplicationTemplatesRequest payload, String token) {
              return ListApplicationTemplatesRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListApplicationTemplatesRequest injectPageSize(
                ListApplicationTemplatesRequest payload, int pageSize) {
              return ListApplicationTemplatesRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListApplicationTemplatesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListApplicationTemplatesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ApplicationTemplate> extractResources(
                ListApplicationTemplatesResponse payload) {
              return payload.getApplicationTemplatesList();
            }
          };

  private static final PagedListDescriptor<ListComponentsRequest, ListComponentsResponse, Component>
      LIST_COMPONENTS_PAGE_STR_DESC =
          new PagedListDescriptor<ListComponentsRequest, ListComponentsResponse, Component>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListComponentsRequest injectToken(ListComponentsRequest payload, String token) {
              return ListComponentsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListComponentsRequest injectPageSize(
                ListComponentsRequest payload, int pageSize) {
              return ListComponentsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListComponentsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListComponentsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Component> extractResources(ListComponentsResponse payload) {
              return payload.getComponentsList();
            }
          };

  private static final PagedListDescriptor<
          ListConnectionsRequest, ListConnectionsResponse, Connection>
      LIST_CONNECTIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListConnectionsRequest, ListConnectionsResponse, Connection>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListConnectionsRequest injectToken(
                ListConnectionsRequest payload, String token) {
              return ListConnectionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListConnectionsRequest injectPageSize(
                ListConnectionsRequest payload, int pageSize) {
              return ListConnectionsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListConnectionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListConnectionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Connection> extractResources(ListConnectionsResponse payload) {
              return payload.getConnectionsList();
            }
          };

  private static final PagedListDescriptor<
          ListApplicationTemplateRevisionsRequest,
          ListApplicationTemplateRevisionsResponse,
          ApplicationTemplateRevision>
      LIST_APPLICATION_TEMPLATE_REVISIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListApplicationTemplateRevisionsRequest,
              ListApplicationTemplateRevisionsResponse,
              ApplicationTemplateRevision>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListApplicationTemplateRevisionsRequest injectToken(
                ListApplicationTemplateRevisionsRequest payload, String token) {
              return ListApplicationTemplateRevisionsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListApplicationTemplateRevisionsRequest injectPageSize(
                ListApplicationTemplateRevisionsRequest payload, int pageSize) {
              return ListApplicationTemplateRevisionsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListApplicationTemplateRevisionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListApplicationTemplateRevisionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ApplicationTemplateRevision> extractResources(
                ListApplicationTemplateRevisionsResponse payload) {
              return payload.getApplicationTemplateRevisionsList();
            }
          };

  private static final PagedListDescriptor<ListCatalogsRequest, ListCatalogsResponse, Catalog>
      LIST_CATALOGS_PAGE_STR_DESC =
          new PagedListDescriptor<ListCatalogsRequest, ListCatalogsResponse, Catalog>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListCatalogsRequest injectToken(ListCatalogsRequest payload, String token) {
              return ListCatalogsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListCatalogsRequest injectPageSize(ListCatalogsRequest payload, int pageSize) {
              return ListCatalogsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListCatalogsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListCatalogsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Catalog> extractResources(ListCatalogsResponse payload) {
              return payload.getCatalogsList();
            }
          };

  private static final PagedListDescriptor<
          ListCatalogTemplatesRequest, ListCatalogTemplatesResponse, CatalogTemplate>
      LIST_CATALOG_TEMPLATES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListCatalogTemplatesRequest, ListCatalogTemplatesResponse, CatalogTemplate>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListCatalogTemplatesRequest injectToken(
                ListCatalogTemplatesRequest payload, String token) {
              return ListCatalogTemplatesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListCatalogTemplatesRequest injectPageSize(
                ListCatalogTemplatesRequest payload, int pageSize) {
              return ListCatalogTemplatesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListCatalogTemplatesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListCatalogTemplatesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<CatalogTemplate> extractResources(
                ListCatalogTemplatesResponse payload) {
              return payload.getCatalogTemplatesList();
            }
          };

  private static final PagedListDescriptor<ListSharesRequest, ListSharesResponse, Share>
      LIST_SHARES_PAGE_STR_DESC =
          new PagedListDescriptor<ListSharesRequest, ListSharesResponse, Share>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListSharesRequest injectToken(ListSharesRequest payload, String token) {
              return ListSharesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListSharesRequest injectPageSize(ListSharesRequest payload, int pageSize) {
              return ListSharesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListSharesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListSharesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Share> extractResources(ListSharesResponse payload) {
              return payload.getSharesList();
            }
          };

  private static final PagedListDescriptor<
          ListSharedTemplatesRequest, ListSharedTemplatesResponse, SharedTemplate>
      LIST_SHARED_TEMPLATES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListSharedTemplatesRequest, ListSharedTemplatesResponse, SharedTemplate>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListSharedTemplatesRequest injectToken(
                ListSharedTemplatesRequest payload, String token) {
              return ListSharedTemplatesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListSharedTemplatesRequest injectPageSize(
                ListSharedTemplatesRequest payload, int pageSize) {
              return ListSharedTemplatesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListSharedTemplatesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListSharedTemplatesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<SharedTemplate> extractResources(ListSharedTemplatesResponse payload) {
              return payload.getSharedTemplatesList();
            }
          };

  private static final PagedListDescriptor<
          ListSharedTemplateRevisionsRequest,
          ListSharedTemplateRevisionsResponse,
          SharedTemplateRevision>
      LIST_SHARED_TEMPLATE_REVISIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListSharedTemplateRevisionsRequest,
              ListSharedTemplateRevisionsResponse,
              SharedTemplateRevision>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListSharedTemplateRevisionsRequest injectToken(
                ListSharedTemplateRevisionsRequest payload, String token) {
              return ListSharedTemplateRevisionsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListSharedTemplateRevisionsRequest injectPageSize(
                ListSharedTemplateRevisionsRequest payload, int pageSize) {
              return ListSharedTemplateRevisionsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListSharedTemplateRevisionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListSharedTemplateRevisionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<SharedTemplateRevision> extractResources(
                ListSharedTemplateRevisionsResponse payload) {
              return payload.getSharedTemplateRevisionsList();
            }
          };

  private static final PagedListDescriptor<
          ListCatalogTemplateRevisionsRequest,
          ListCatalogTemplateRevisionsResponse,
          CatalogTemplateRevision>
      LIST_CATALOG_TEMPLATE_REVISIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListCatalogTemplateRevisionsRequest,
              ListCatalogTemplateRevisionsResponse,
              CatalogTemplateRevision>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListCatalogTemplateRevisionsRequest injectToken(
                ListCatalogTemplateRevisionsRequest payload, String token) {
              return ListCatalogTemplateRevisionsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListCatalogTemplateRevisionsRequest injectPageSize(
                ListCatalogTemplateRevisionsRequest payload, int pageSize) {
              return ListCatalogTemplateRevisionsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListCatalogTemplateRevisionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListCatalogTemplateRevisionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<CatalogTemplateRevision> extractResources(
                ListCatalogTemplateRevisionsResponse payload) {
              return payload.getCatalogTemplateRevisionsList();
            }
          };

  private static final PagedListDescriptor<
          ListApplicationsRequest, ListApplicationsResponse, Application>
      LIST_APPLICATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListApplicationsRequest, ListApplicationsResponse, Application>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListApplicationsRequest injectToken(
                ListApplicationsRequest payload, String token) {
              return ListApplicationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListApplicationsRequest injectPageSize(
                ListApplicationsRequest payload, int pageSize) {
              return ListApplicationsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListApplicationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListApplicationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Application> extractResources(ListApplicationsResponse payload) {
              return payload.getApplicationsList();
            }
          };

  private static final PagedListDescriptor<ListPoliciesRequest, ListPoliciesResponse, Policy>
      LIST_POLICIES_PAGE_STR_DESC =
          new PagedListDescriptor<ListPoliciesRequest, ListPoliciesResponse, Policy>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListPoliciesRequest injectToken(ListPoliciesRequest payload, String token) {
              return ListPoliciesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListPoliciesRequest injectPageSize(ListPoliciesRequest payload, int pageSize) {
              return ListPoliciesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListPoliciesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListPoliciesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Policy> extractResources(ListPoliciesResponse payload) {
              return payload.getPoliciesList();
            }
          };

  private static final PagedListDescriptor<
          FetchFrameworksRequest, FetchFrameworksResponse, Framework>
      FETCH_FRAMEWORKS_PAGE_STR_DESC =
          new PagedListDescriptor<FetchFrameworksRequest, FetchFrameworksResponse, Framework>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public FetchFrameworksRequest injectToken(
                FetchFrameworksRequest payload, String token) {
              return FetchFrameworksRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public FetchFrameworksRequest injectPageSize(
                FetchFrameworksRequest payload, int pageSize) {
              return FetchFrameworksRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(FetchFrameworksRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(FetchFrameworksResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Framework> extractResources(FetchFrameworksResponse payload) {
              return payload.getFrameworksList();
            }
          };

  private static final PagedListDescriptor<
          ListApplicationTemplateSystemRevisionsRequest,
          ListApplicationTemplateSystemRevisionsResponse,
          ApplicationTemplateSystemRevision>
      LIST_APPLICATION_TEMPLATE_SYSTEM_REVISIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListApplicationTemplateSystemRevisionsRequest,
              ListApplicationTemplateSystemRevisionsResponse,
              ApplicationTemplateSystemRevision>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListApplicationTemplateSystemRevisionsRequest injectToken(
                ListApplicationTemplateSystemRevisionsRequest payload, String token) {
              return ListApplicationTemplateSystemRevisionsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListApplicationTemplateSystemRevisionsRequest injectPageSize(
                ListApplicationTemplateSystemRevisionsRequest payload, int pageSize) {
              return ListApplicationTemplateSystemRevisionsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListApplicationTemplateSystemRevisionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListApplicationTemplateSystemRevisionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ApplicationTemplateSystemRevision> extractResources(
                ListApplicationTemplateSystemRevisionsResponse payload) {
              return payload.getApplicationTemplateSystemRevisionsList();
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
          ListSpacesRequest, ListSpacesResponse, ListSpacesPagedResponse>
      LIST_SPACES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListSpacesRequest, ListSpacesResponse, ListSpacesPagedResponse>() {
            @Override
            public ApiFuture<ListSpacesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListSpacesRequest, ListSpacesResponse> callable,
                ListSpacesRequest request,
                ApiCallContext context,
                ApiFuture<ListSpacesResponse> futureResponse) {
              PageContext<ListSpacesRequest, ListSpacesResponse, Space> pageContext =
                  PageContext.create(callable, LIST_SPACES_PAGE_STR_DESC, request, context);
              return ListSpacesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListApplicationTemplatesRequest,
          ListApplicationTemplatesResponse,
          ListApplicationTemplatesPagedResponse>
      LIST_APPLICATION_TEMPLATES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListApplicationTemplatesRequest,
              ListApplicationTemplatesResponse,
              ListApplicationTemplatesPagedResponse>() {
            @Override
            public ApiFuture<ListApplicationTemplatesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListApplicationTemplatesRequest, ListApplicationTemplatesResponse>
                    callable,
                ListApplicationTemplatesRequest request,
                ApiCallContext context,
                ApiFuture<ListApplicationTemplatesResponse> futureResponse) {
              PageContext<
                      ListApplicationTemplatesRequest,
                      ListApplicationTemplatesResponse,
                      ApplicationTemplate>
                  pageContext =
                      PageContext.create(
                          callable, LIST_APPLICATION_TEMPLATES_PAGE_STR_DESC, request, context);
              return ListApplicationTemplatesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListComponentsRequest, ListComponentsResponse, ListComponentsPagedResponse>
      LIST_COMPONENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListComponentsRequest, ListComponentsResponse, ListComponentsPagedResponse>() {
            @Override
            public ApiFuture<ListComponentsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListComponentsRequest, ListComponentsResponse> callable,
                ListComponentsRequest request,
                ApiCallContext context,
                ApiFuture<ListComponentsResponse> futureResponse) {
              PageContext<ListComponentsRequest, ListComponentsResponse, Component> pageContext =
                  PageContext.create(callable, LIST_COMPONENTS_PAGE_STR_DESC, request, context);
              return ListComponentsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListConnectionsRequest, ListConnectionsResponse, ListConnectionsPagedResponse>
      LIST_CONNECTIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListConnectionsRequest, ListConnectionsResponse, ListConnectionsPagedResponse>() {
            @Override
            public ApiFuture<ListConnectionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListConnectionsRequest, ListConnectionsResponse> callable,
                ListConnectionsRequest request,
                ApiCallContext context,
                ApiFuture<ListConnectionsResponse> futureResponse) {
              PageContext<ListConnectionsRequest, ListConnectionsResponse, Connection> pageContext =
                  PageContext.create(callable, LIST_CONNECTIONS_PAGE_STR_DESC, request, context);
              return ListConnectionsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListApplicationTemplateRevisionsRequest,
          ListApplicationTemplateRevisionsResponse,
          ListApplicationTemplateRevisionsPagedResponse>
      LIST_APPLICATION_TEMPLATE_REVISIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListApplicationTemplateRevisionsRequest,
              ListApplicationTemplateRevisionsResponse,
              ListApplicationTemplateRevisionsPagedResponse>() {
            @Override
            public ApiFuture<ListApplicationTemplateRevisionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        ListApplicationTemplateRevisionsRequest,
                        ListApplicationTemplateRevisionsResponse>
                    callable,
                ListApplicationTemplateRevisionsRequest request,
                ApiCallContext context,
                ApiFuture<ListApplicationTemplateRevisionsResponse> futureResponse) {
              PageContext<
                      ListApplicationTemplateRevisionsRequest,
                      ListApplicationTemplateRevisionsResponse,
                      ApplicationTemplateRevision>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_APPLICATION_TEMPLATE_REVISIONS_PAGE_STR_DESC,
                          request,
                          context);
              return ListApplicationTemplateRevisionsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListCatalogsRequest, ListCatalogsResponse, ListCatalogsPagedResponse>
      LIST_CATALOGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListCatalogsRequest, ListCatalogsResponse, ListCatalogsPagedResponse>() {
            @Override
            public ApiFuture<ListCatalogsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListCatalogsRequest, ListCatalogsResponse> callable,
                ListCatalogsRequest request,
                ApiCallContext context,
                ApiFuture<ListCatalogsResponse> futureResponse) {
              PageContext<ListCatalogsRequest, ListCatalogsResponse, Catalog> pageContext =
                  PageContext.create(callable, LIST_CATALOGS_PAGE_STR_DESC, request, context);
              return ListCatalogsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListCatalogTemplatesRequest,
          ListCatalogTemplatesResponse,
          ListCatalogTemplatesPagedResponse>
      LIST_CATALOG_TEMPLATES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListCatalogTemplatesRequest,
              ListCatalogTemplatesResponse,
              ListCatalogTemplatesPagedResponse>() {
            @Override
            public ApiFuture<ListCatalogTemplatesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListCatalogTemplatesRequest, ListCatalogTemplatesResponse> callable,
                ListCatalogTemplatesRequest request,
                ApiCallContext context,
                ApiFuture<ListCatalogTemplatesResponse> futureResponse) {
              PageContext<
                      ListCatalogTemplatesRequest, ListCatalogTemplatesResponse, CatalogTemplate>
                  pageContext =
                      PageContext.create(
                          callable, LIST_CATALOG_TEMPLATES_PAGE_STR_DESC, request, context);
              return ListCatalogTemplatesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListSharesRequest, ListSharesResponse, ListSharesPagedResponse>
      LIST_SHARES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListSharesRequest, ListSharesResponse, ListSharesPagedResponse>() {
            @Override
            public ApiFuture<ListSharesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListSharesRequest, ListSharesResponse> callable,
                ListSharesRequest request,
                ApiCallContext context,
                ApiFuture<ListSharesResponse> futureResponse) {
              PageContext<ListSharesRequest, ListSharesResponse, Share> pageContext =
                  PageContext.create(callable, LIST_SHARES_PAGE_STR_DESC, request, context);
              return ListSharesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListSharedTemplatesRequest, ListSharedTemplatesResponse, ListSharedTemplatesPagedResponse>
      LIST_SHARED_TEMPLATES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListSharedTemplatesRequest,
              ListSharedTemplatesResponse,
              ListSharedTemplatesPagedResponse>() {
            @Override
            public ApiFuture<ListSharedTemplatesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListSharedTemplatesRequest, ListSharedTemplatesResponse> callable,
                ListSharedTemplatesRequest request,
                ApiCallContext context,
                ApiFuture<ListSharedTemplatesResponse> futureResponse) {
              PageContext<ListSharedTemplatesRequest, ListSharedTemplatesResponse, SharedTemplate>
                  pageContext =
                      PageContext.create(
                          callable, LIST_SHARED_TEMPLATES_PAGE_STR_DESC, request, context);
              return ListSharedTemplatesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListSharedTemplateRevisionsRequest,
          ListSharedTemplateRevisionsResponse,
          ListSharedTemplateRevisionsPagedResponse>
      LIST_SHARED_TEMPLATE_REVISIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListSharedTemplateRevisionsRequest,
              ListSharedTemplateRevisionsResponse,
              ListSharedTemplateRevisionsPagedResponse>() {
            @Override
            public ApiFuture<ListSharedTemplateRevisionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        ListSharedTemplateRevisionsRequest, ListSharedTemplateRevisionsResponse>
                    callable,
                ListSharedTemplateRevisionsRequest request,
                ApiCallContext context,
                ApiFuture<ListSharedTemplateRevisionsResponse> futureResponse) {
              PageContext<
                      ListSharedTemplateRevisionsRequest,
                      ListSharedTemplateRevisionsResponse,
                      SharedTemplateRevision>
                  pageContext =
                      PageContext.create(
                          callable, LIST_SHARED_TEMPLATE_REVISIONS_PAGE_STR_DESC, request, context);
              return ListSharedTemplateRevisionsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListCatalogTemplateRevisionsRequest,
          ListCatalogTemplateRevisionsResponse,
          ListCatalogTemplateRevisionsPagedResponse>
      LIST_CATALOG_TEMPLATE_REVISIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListCatalogTemplateRevisionsRequest,
              ListCatalogTemplateRevisionsResponse,
              ListCatalogTemplateRevisionsPagedResponse>() {
            @Override
            public ApiFuture<ListCatalogTemplateRevisionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        ListCatalogTemplateRevisionsRequest, ListCatalogTemplateRevisionsResponse>
                    callable,
                ListCatalogTemplateRevisionsRequest request,
                ApiCallContext context,
                ApiFuture<ListCatalogTemplateRevisionsResponse> futureResponse) {
              PageContext<
                      ListCatalogTemplateRevisionsRequest,
                      ListCatalogTemplateRevisionsResponse,
                      CatalogTemplateRevision>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_CATALOG_TEMPLATE_REVISIONS_PAGE_STR_DESC,
                          request,
                          context);
              return ListCatalogTemplateRevisionsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListApplicationsRequest, ListApplicationsResponse, ListApplicationsPagedResponse>
      LIST_APPLICATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListApplicationsRequest, ListApplicationsResponse, ListApplicationsPagedResponse>() {
            @Override
            public ApiFuture<ListApplicationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListApplicationsRequest, ListApplicationsResponse> callable,
                ListApplicationsRequest request,
                ApiCallContext context,
                ApiFuture<ListApplicationsResponse> futureResponse) {
              PageContext<ListApplicationsRequest, ListApplicationsResponse, Application>
                  pageContext =
                      PageContext.create(
                          callable, LIST_APPLICATIONS_PAGE_STR_DESC, request, context);
              return ListApplicationsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListPoliciesRequest, ListPoliciesResponse, ListPoliciesPagedResponse>
      LIST_POLICIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListPoliciesRequest, ListPoliciesResponse, ListPoliciesPagedResponse>() {
            @Override
            public ApiFuture<ListPoliciesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListPoliciesRequest, ListPoliciesResponse> callable,
                ListPoliciesRequest request,
                ApiCallContext context,
                ApiFuture<ListPoliciesResponse> futureResponse) {
              PageContext<ListPoliciesRequest, ListPoliciesResponse, Policy> pageContext =
                  PageContext.create(callable, LIST_POLICIES_PAGE_STR_DESC, request, context);
              return ListPoliciesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          FetchFrameworksRequest, FetchFrameworksResponse, FetchFrameworksPagedResponse>
      FETCH_FRAMEWORKS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              FetchFrameworksRequest, FetchFrameworksResponse, FetchFrameworksPagedResponse>() {
            @Override
            public ApiFuture<FetchFrameworksPagedResponse> getFuturePagedResponse(
                UnaryCallable<FetchFrameworksRequest, FetchFrameworksResponse> callable,
                FetchFrameworksRequest request,
                ApiCallContext context,
                ApiFuture<FetchFrameworksResponse> futureResponse) {
              PageContext<FetchFrameworksRequest, FetchFrameworksResponse, Framework> pageContext =
                  PageContext.create(callable, FETCH_FRAMEWORKS_PAGE_STR_DESC, request, context);
              return FetchFrameworksPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListApplicationTemplateSystemRevisionsRequest,
          ListApplicationTemplateSystemRevisionsResponse,
          ListApplicationTemplateSystemRevisionsPagedResponse>
      LIST_APPLICATION_TEMPLATE_SYSTEM_REVISIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListApplicationTemplateSystemRevisionsRequest,
              ListApplicationTemplateSystemRevisionsResponse,
              ListApplicationTemplateSystemRevisionsPagedResponse>() {
            @Override
            public ApiFuture<ListApplicationTemplateSystemRevisionsPagedResponse>
                getFuturePagedResponse(
                    UnaryCallable<
                            ListApplicationTemplateSystemRevisionsRequest,
                            ListApplicationTemplateSystemRevisionsResponse>
                        callable,
                    ListApplicationTemplateSystemRevisionsRequest request,
                    ApiCallContext context,
                    ApiFuture<ListApplicationTemplateSystemRevisionsResponse> futureResponse) {
              PageContext<
                      ListApplicationTemplateSystemRevisionsRequest,
                      ListApplicationTemplateSystemRevisionsResponse,
                      ApplicationTemplateSystemRevision>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_APPLICATION_TEMPLATE_SYSTEM_REVISIONS_PAGE_STR_DESC,
                          request,
                          context);
              return ListApplicationTemplateSystemRevisionsPagedResponse.createAsync(
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

  /** Returns the object with the settings used for calls to getSpace. */
  public UnaryCallSettings<GetSpaceRequest, Space> getSpaceSettings() {
    return getSpaceSettings;
  }

  /** Returns the object with the settings used for calls to listSpaces. */
  public PagedCallSettings<ListSpacesRequest, ListSpacesResponse, ListSpacesPagedResponse>
      listSpacesSettings() {
    return listSpacesSettings;
  }

  /** Returns the object with the settings used for calls to createSpace. */
  public UnaryCallSettings<CreateSpaceRequest, Space> createSpaceSettings() {
    return createSpaceSettings;
  }

  /** Returns the object with the settings used for calls to updateSpace. */
  public UnaryCallSettings<UpdateSpaceRequest, Space> updateSpaceSettings() {
    return updateSpaceSettings;
  }

  /** Returns the object with the settings used for calls to deleteSpace. */
  public UnaryCallSettings<DeleteSpaceRequest, Empty> deleteSpaceSettings() {
    return deleteSpaceSettings;
  }

  /** Returns the object with the settings used for calls to getApplicationTemplate. */
  public UnaryCallSettings<GetApplicationTemplateRequest, ApplicationTemplate>
      getApplicationTemplateSettings() {
    return getApplicationTemplateSettings;
  }

  /** Returns the object with the settings used for calls to listApplicationTemplates. */
  public PagedCallSettings<
          ListApplicationTemplatesRequest,
          ListApplicationTemplatesResponse,
          ListApplicationTemplatesPagedResponse>
      listApplicationTemplatesSettings() {
    return listApplicationTemplatesSettings;
  }

  /** Returns the object with the settings used for calls to createApplicationTemplate. */
  public UnaryCallSettings<CreateApplicationTemplateRequest, ApplicationTemplate>
      createApplicationTemplateSettings() {
    return createApplicationTemplateSettings;
  }

  /** Returns the object with the settings used for calls to updateApplicationTemplate. */
  public UnaryCallSettings<UpdateApplicationTemplateRequest, ApplicationTemplate>
      updateApplicationTemplateSettings() {
    return updateApplicationTemplateSettings;
  }

  /** Returns the object with the settings used for calls to importApplicationTemplate. */
  public UnaryCallSettings<ImportApplicationTemplateRequest, ApplicationTemplate>
      importApplicationTemplateSettings() {
    return importApplicationTemplateSettings;
  }

  /** Returns the object with the settings used for calls to deleteApplicationTemplate. */
  public UnaryCallSettings<DeleteApplicationTemplateRequest, Empty>
      deleteApplicationTemplateSettings() {
    return deleteApplicationTemplateSettings;
  }

  /** Returns the object with the settings used for calls to commitApplicationTemplate. */
  public UnaryCallSettings<CommitApplicationTemplateRequest, ApplicationTemplateRevision>
      commitApplicationTemplateSettings() {
    return commitApplicationTemplateSettings;
  }

  /** Returns the object with the settings used for calls to snapshotApplicationTemplate. */
  public UnaryCallSettings<SnapshotApplicationTemplateRequest, Operation>
      snapshotApplicationTemplateSettings() {
    return snapshotApplicationTemplateSettings;
  }

  /** Returns the object with the settings used for calls to snapshotApplicationTemplate. */
  public OperationCallSettings<
          SnapshotApplicationTemplateRequest,
          SnapshotApplicationTemplateResponse,
          OperationMetadata>
      snapshotApplicationTemplateOperationSettings() {
    return snapshotApplicationTemplateOperationSettings;
  }

  /** Returns the object with the settings used for calls to generateApplicationTemplateIaC. */
  public UnaryCallSettings<
          GenerateApplicationTemplateIaCRequest, GenerateApplicationTemplateIaCResponse>
      generateApplicationTemplateIaCSettings() {
    return generateApplicationTemplateIaCSettings;
  }

  /** Returns the object with the settings used for calls to exportApplicationTemplateIaC. */
  public UnaryCallSettings<ExportApplicationTemplateIaCRequest, Operation>
      exportApplicationTemplateIaCSettings() {
    return exportApplicationTemplateIaCSettings;
  }

  /** Returns the object with the settings used for calls to exportApplicationTemplateIaC. */
  public OperationCallSettings<
          ExportApplicationTemplateIaCRequest,
          ExportApplicationTemplateIaCResponse,
          OperationMetadata>
      exportApplicationTemplateIaCOperationSettings() {
    return exportApplicationTemplateIaCOperationSettings;
  }

  /**
   * Returns the object with the settings used for calls to generateApplicationTemplateRevisionIaC.
   */
  public UnaryCallSettings<
          GenerateApplicationTemplateRevisionIaCRequest,
          GenerateApplicationTemplateRevisionIaCResponse>
      generateApplicationTemplateRevisionIaCSettings() {
    return generateApplicationTemplateRevisionIaCSettings;
  }

  /**
   * Returns the object with the settings used for calls to exportApplicationTemplateRevisionIaC.
   */
  public UnaryCallSettings<ExportApplicationTemplateRevisionIaCRequest, Operation>
      exportApplicationTemplateRevisionIaCSettings() {
    return exportApplicationTemplateRevisionIaCSettings;
  }

  /**
   * Returns the object with the settings used for calls to exportApplicationTemplateRevisionIaC.
   */
  public OperationCallSettings<
          ExportApplicationTemplateRevisionIaCRequest,
          ExportApplicationTemplateRevisionIaCResponse,
          OperationMetadata>
      exportApplicationTemplateRevisionIaCOperationSettings() {
    return exportApplicationTemplateRevisionIaCOperationSettings;
  }

  /** Returns the object with the settings used for calls to getComponent. */
  public UnaryCallSettings<GetComponentRequest, Component> getComponentSettings() {
    return getComponentSettings;
  }

  /** Returns the object with the settings used for calls to listComponents. */
  public PagedCallSettings<
          ListComponentsRequest, ListComponentsResponse, ListComponentsPagedResponse>
      listComponentsSettings() {
    return listComponentsSettings;
  }

  /** Returns the object with the settings used for calls to createComponent. */
  public UnaryCallSettings<CreateComponentRequest, Component> createComponentSettings() {
    return createComponentSettings;
  }

  /** Returns the object with the settings used for calls to updateComponent. */
  public UnaryCallSettings<UpdateComponentRequest, Component> updateComponentSettings() {
    return updateComponentSettings;
  }

  /** Returns the object with the settings used for calls to deleteComponent. */
  public UnaryCallSettings<DeleteComponentRequest, Empty> deleteComponentSettings() {
    return deleteComponentSettings;
  }

  /** Returns the object with the settings used for calls to getConnection. */
  public UnaryCallSettings<GetConnectionRequest, Connection> getConnectionSettings() {
    return getConnectionSettings;
  }

  /** Returns the object with the settings used for calls to listConnections. */
  public PagedCallSettings<
          ListConnectionsRequest, ListConnectionsResponse, ListConnectionsPagedResponse>
      listConnectionsSettings() {
    return listConnectionsSettings;
  }

  /** Returns the object with the settings used for calls to createConnection. */
  public UnaryCallSettings<CreateConnectionRequest, Connection> createConnectionSettings() {
    return createConnectionSettings;
  }

  /** Returns the object with the settings used for calls to updateConnection. */
  public UnaryCallSettings<UpdateConnectionRequest, Connection> updateConnectionSettings() {
    return updateConnectionSettings;
  }

  /** Returns the object with the settings used for calls to deleteConnection. */
  public UnaryCallSettings<DeleteConnectionRequest, Empty> deleteConnectionSettings() {
    return deleteConnectionSettings;
  }

  /** Returns the object with the settings used for calls to getApplicationTemplateRevision. */
  public UnaryCallSettings<GetApplicationTemplateRevisionRequest, ApplicationTemplateRevision>
      getApplicationTemplateRevisionSettings() {
    return getApplicationTemplateRevisionSettings;
  }

  /** Returns the object with the settings used for calls to listApplicationTemplateRevisions. */
  public PagedCallSettings<
          ListApplicationTemplateRevisionsRequest,
          ListApplicationTemplateRevisionsResponse,
          ListApplicationTemplateRevisionsPagedResponse>
      listApplicationTemplateRevisionsSettings() {
    return listApplicationTemplateRevisionsSettings;
  }

  /** Returns the object with the settings used for calls to deleteApplicationTemplateRevision. */
  public UnaryCallSettings<DeleteApplicationTemplateRevisionRequest, Empty>
      deleteApplicationTemplateRevisionSettings() {
    return deleteApplicationTemplateRevisionSettings;
  }

  /** Returns the object with the settings used for calls to getCatalog. */
  public UnaryCallSettings<GetCatalogRequest, Catalog> getCatalogSettings() {
    return getCatalogSettings;
  }

  /** Returns the object with the settings used for calls to listCatalogs. */
  public PagedCallSettings<ListCatalogsRequest, ListCatalogsResponse, ListCatalogsPagedResponse>
      listCatalogsSettings() {
    return listCatalogsSettings;
  }

  /** Returns the object with the settings used for calls to createCatalog. */
  public UnaryCallSettings<CreateCatalogRequest, Catalog> createCatalogSettings() {
    return createCatalogSettings;
  }

  /** Returns the object with the settings used for calls to updateCatalog. */
  public UnaryCallSettings<UpdateCatalogRequest, Catalog> updateCatalogSettings() {
    return updateCatalogSettings;
  }

  /** Returns the object with the settings used for calls to deleteCatalog. */
  public UnaryCallSettings<DeleteCatalogRequest, Operation> deleteCatalogSettings() {
    return deleteCatalogSettings;
  }

  /** Returns the object with the settings used for calls to deleteCatalog. */
  public OperationCallSettings<DeleteCatalogRequest, Empty, OperationMetadata>
      deleteCatalogOperationSettings() {
    return deleteCatalogOperationSettings;
  }

  /** Returns the object with the settings used for calls to createCatalogTemplate. */
  public UnaryCallSettings<CreateCatalogTemplateRequest, CatalogTemplate>
      createCatalogTemplateSettings() {
    return createCatalogTemplateSettings;
  }

  /** Returns the object with the settings used for calls to getCatalogTemplate. */
  public UnaryCallSettings<GetCatalogTemplateRequest, CatalogTemplate>
      getCatalogTemplateSettings() {
    return getCatalogTemplateSettings;
  }

  /** Returns the object with the settings used for calls to listCatalogTemplates. */
  public PagedCallSettings<
          ListCatalogTemplatesRequest,
          ListCatalogTemplatesResponse,
          ListCatalogTemplatesPagedResponse>
      listCatalogTemplatesSettings() {
    return listCatalogTemplatesSettings;
  }

  /** Returns the object with the settings used for calls to updateCatalogTemplate. */
  public UnaryCallSettings<UpdateCatalogTemplateRequest, CatalogTemplate>
      updateCatalogTemplateSettings() {
    return updateCatalogTemplateSettings;
  }

  /** Returns the object with the settings used for calls to deleteCatalogTemplate. */
  public UnaryCallSettings<DeleteCatalogTemplateRequest, Operation>
      deleteCatalogTemplateSettings() {
    return deleteCatalogTemplateSettings;
  }

  /** Returns the object with the settings used for calls to deleteCatalogTemplate. */
  public OperationCallSettings<DeleteCatalogTemplateRequest, Empty, OperationMetadata>
      deleteCatalogTemplateOperationSettings() {
    return deleteCatalogTemplateOperationSettings;
  }

  /** Returns the object with the settings used for calls to createShare. */
  public UnaryCallSettings<CreateShareRequest, Operation> createShareSettings() {
    return createShareSettings;
  }

  /** Returns the object with the settings used for calls to createShare. */
  public OperationCallSettings<CreateShareRequest, Share, OperationMetadata>
      createShareOperationSettings() {
    return createShareOperationSettings;
  }

  /** Returns the object with the settings used for calls to listShares. */
  public PagedCallSettings<ListSharesRequest, ListSharesResponse, ListSharesPagedResponse>
      listSharesSettings() {
    return listSharesSettings;
  }

  /** Returns the object with the settings used for calls to getShare. */
  public UnaryCallSettings<GetShareRequest, Share> getShareSettings() {
    return getShareSettings;
  }

  /** Returns the object with the settings used for calls to deleteShare. */
  public UnaryCallSettings<DeleteShareRequest, Operation> deleteShareSettings() {
    return deleteShareSettings;
  }

  /** Returns the object with the settings used for calls to deleteShare. */
  public OperationCallSettings<DeleteShareRequest, Empty, OperationMetadata>
      deleteShareOperationSettings() {
    return deleteShareOperationSettings;
  }

  /** Returns the object with the settings used for calls to syncShare. */
  public UnaryCallSettings<SyncShareRequest, Operation> syncShareSettings() {
    return syncShareSettings;
  }

  /** Returns the object with the settings used for calls to syncShare. */
  public OperationCallSettings<SyncShareRequest, Share, OperationMetadata>
      syncShareOperationSettings() {
    return syncShareOperationSettings;
  }

  /** Returns the object with the settings used for calls to getSharedTemplate. */
  public UnaryCallSettings<GetSharedTemplateRequest, SharedTemplate> getSharedTemplateSettings() {
    return getSharedTemplateSettings;
  }

  /** Returns the object with the settings used for calls to listSharedTemplates. */
  public PagedCallSettings<
          ListSharedTemplatesRequest, ListSharedTemplatesResponse, ListSharedTemplatesPagedResponse>
      listSharedTemplatesSettings() {
    return listSharedTemplatesSettings;
  }

  /** Returns the object with the settings used for calls to getSharedTemplateRevision. */
  public UnaryCallSettings<GetSharedTemplateRevisionRequest, SharedTemplateRevision>
      getSharedTemplateRevisionSettings() {
    return getSharedTemplateRevisionSettings;
  }

  /** Returns the object with the settings used for calls to listSharedTemplateRevisions. */
  public PagedCallSettings<
          ListSharedTemplateRevisionsRequest,
          ListSharedTemplateRevisionsResponse,
          ListSharedTemplateRevisionsPagedResponse>
      listSharedTemplateRevisionsSettings() {
    return listSharedTemplateRevisionsSettings;
  }

  /** Returns the object with the settings used for calls to createCatalogTemplateRevision. */
  public UnaryCallSettings<CreateCatalogTemplateRevisionRequest, Operation>
      createCatalogTemplateRevisionSettings() {
    return createCatalogTemplateRevisionSettings;
  }

  /** Returns the object with the settings used for calls to createCatalogTemplateRevision. */
  public OperationCallSettings<
          CreateCatalogTemplateRevisionRequest, CatalogTemplateRevision, OperationMetadata>
      createCatalogTemplateRevisionOperationSettings() {
    return createCatalogTemplateRevisionOperationSettings;
  }

  /** Returns the object with the settings used for calls to getCatalogTemplateRevision. */
  public UnaryCallSettings<GetCatalogTemplateRevisionRequest, CatalogTemplateRevision>
      getCatalogTemplateRevisionSettings() {
    return getCatalogTemplateRevisionSettings;
  }

  /** Returns the object with the settings used for calls to listCatalogTemplateRevisions. */
  public PagedCallSettings<
          ListCatalogTemplateRevisionsRequest,
          ListCatalogTemplateRevisionsResponse,
          ListCatalogTemplateRevisionsPagedResponse>
      listCatalogTemplateRevisionsSettings() {
    return listCatalogTemplateRevisionsSettings;
  }

  /** Returns the object with the settings used for calls to deleteCatalogTemplateRevision. */
  public UnaryCallSettings<DeleteCatalogTemplateRevisionRequest, Operation>
      deleteCatalogTemplateRevisionSettings() {
    return deleteCatalogTemplateRevisionSettings;
  }

  /** Returns the object with the settings used for calls to deleteCatalogTemplateRevision. */
  public OperationCallSettings<DeleteCatalogTemplateRevisionRequest, Empty, OperationMetadata>
      deleteCatalogTemplateRevisionOperationSettings() {
    return deleteCatalogTemplateRevisionOperationSettings;
  }

  /** Returns the object with the settings used for calls to createApplication. */
  public UnaryCallSettings<CreateApplicationRequest, Application> createApplicationSettings() {
    return createApplicationSettings;
  }

  /** Returns the object with the settings used for calls to getApplication. */
  public UnaryCallSettings<GetApplicationRequest, Application> getApplicationSettings() {
    return getApplicationSettings;
  }

  /** Returns the object with the settings used for calls to listApplications. */
  public PagedCallSettings<
          ListApplicationsRequest, ListApplicationsResponse, ListApplicationsPagedResponse>
      listApplicationsSettings() {
    return listApplicationsSettings;
  }

  /** Returns the object with the settings used for calls to updateApplication. */
  public UnaryCallSettings<UpdateApplicationRequest, Application> updateApplicationSettings() {
    return updateApplicationSettings;
  }

  /** Returns the object with the settings used for calls to deleteApplication. */
  public UnaryCallSettings<DeleteApplicationRequest, Operation> deleteApplicationSettings() {
    return deleteApplicationSettings;
  }

  /** Returns the object with the settings used for calls to deleteApplication. */
  public OperationCallSettings<DeleteApplicationRequest, Empty, OperationMetadata>
      deleteApplicationOperationSettings() {
    return deleteApplicationOperationSettings;
  }

  /** Returns the object with the settings used for calls to deployApplication. */
  public UnaryCallSettings<DeployApplicationRequest, Operation> deployApplicationSettings() {
    return deployApplicationSettings;
  }

  /** Returns the object with the settings used for calls to deployApplication. */
  public OperationCallSettings<
          DeployApplicationRequest, DeployApplicationResponse, OperationMetadata>
      deployApplicationOperationSettings() {
    return deployApplicationOperationSettings;
  }

  /** Returns the object with the settings used for calls to previewApplication. */
  public UnaryCallSettings<PreviewApplicationRequest, Operation> previewApplicationSettings() {
    return previewApplicationSettings;
  }

  /** Returns the object with the settings used for calls to previewApplication. */
  public OperationCallSettings<
          PreviewApplicationRequest, PreviewApplicationResponse, OperationMetadata>
      previewApplicationOperationSettings() {
    return previewApplicationOperationSettings;
  }

  /** Returns the object with the settings used for calls to fetchApplicationAssessmentReport. */
  public UnaryCallSettings<
          FetchApplicationAssessmentReportRequest, FetchApplicationAssessmentReportResponse>
      fetchApplicationAssessmentReportSettings() {
    return fetchApplicationAssessmentReportSettings;
  }

  /** Returns the object with the settings used for calls to generateApplicationAssessmentReport. */
  public UnaryCallSettings<GenerateApplicationAssessmentReportRequest, Operation>
      generateApplicationAssessmentReportSettings() {
    return generateApplicationAssessmentReportSettings;
  }

  /** Returns the object with the settings used for calls to generateApplicationAssessmentReport. */
  public OperationCallSettings<
          GenerateApplicationAssessmentReportRequest,
          GenerateApplicationAssessmentReportResponse,
          OperationMetadata>
      generateApplicationAssessmentReportOperationSettings() {
    return generateApplicationAssessmentReportOperationSettings;
  }

  /**
   * Returns the object with the settings used for calls to
   * generateApplicationTemplateAssessmentReport.
   */
  public UnaryCallSettings<GenerateApplicationTemplateAssessmentReportRequest, Operation>
      generateApplicationTemplateAssessmentReportSettings() {
    return generateApplicationTemplateAssessmentReportSettings;
  }

  /**
   * Returns the object with the settings used for calls to
   * generateApplicationTemplateAssessmentReport.
   */
  public OperationCallSettings<
          GenerateApplicationTemplateAssessmentReportRequest,
          GenerateApplicationTemplateAssessmentReportResponse,
          OperationMetadata>
      generateApplicationTemplateAssessmentReportOperationSettings() {
    return generateApplicationTemplateAssessmentReportOperationSettings;
  }

  /**
   * Returns the object with the settings used for calls to generateAssessmentReport.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<GenerateAssessmentReportRequest, Operation>
      generateAssessmentReportSettings() {
    return generateAssessmentReportSettings;
  }

  /** Returns the object with the settings used for calls to generateAssessmentReport. */
  public OperationCallSettings<
          GenerateAssessmentReportRequest, GenerateAssessmentReportResponse, OperationMetadata>
      generateAssessmentReportOperationSettings() {
    return generateAssessmentReportOperationSettings;
  }

  /**
   * Returns the object with the settings used for calls to generateTerraformPlanAssessmentReport.
   */
  public UnaryCallSettings<GenerateTerraformPlanAssessmentReportRequest, Operation>
      generateTerraformPlanAssessmentReportSettings() {
    return generateTerraformPlanAssessmentReportSettings;
  }

  /**
   * Returns the object with the settings used for calls to generateTerraformPlanAssessmentReport.
   */
  public OperationCallSettings<
          GenerateTerraformPlanAssessmentReportRequest,
          GenerateTerraformPlanAssessmentReportResponse,
          OperationMetadata>
      generateTerraformPlanAssessmentReportOperationSettings() {
    return generateTerraformPlanAssessmentReportOperationSettings;
  }

  /** Returns the object with the settings used for calls to getPolicy. */
  public UnaryCallSettings<GetPolicyRequest, Policy> getPolicySettings() {
    return getPolicySettings;
  }

  /** Returns the object with the settings used for calls to listPolicies. */
  public PagedCallSettings<ListPoliciesRequest, ListPoliciesResponse, ListPoliciesPagedResponse>
      listPoliciesSettings() {
    return listPoliciesSettings;
  }

  /** Returns the object with the settings used for calls to createPolicy. */
  public UnaryCallSettings<CreatePolicyRequest, Policy> createPolicySettings() {
    return createPolicySettings;
  }

  /** Returns the object with the settings used for calls to updatePolicy. */
  public UnaryCallSettings<UpdatePolicyRequest, Policy> updatePolicySettings() {
    return updatePolicySettings;
  }

  /** Returns the object with the settings used for calls to deletePolicy. */
  public UnaryCallSettings<DeletePolicyRequest, Empty> deletePolicySettings() {
    return deletePolicySettings;
  }

  /** Returns the object with the settings used for calls to fetchFrameworks. */
  public PagedCallSettings<
          FetchFrameworksRequest, FetchFrameworksResponse, FetchFrameworksPagedResponse>
      fetchFrameworksSettings() {
    return fetchFrameworksSettings;
  }

  /** Returns the object with the settings used for calls to generateApplicationIaC. */
  public UnaryCallSettings<GenerateApplicationIaCRequest, GenerateApplicationIaCResponse>
      generateApplicationIaCSettings() {
    return generateApplicationIaCSettings;
  }

  /** Returns the object with the settings used for calls to exportApplicationIaC. */
  public UnaryCallSettings<ExportApplicationIaCRequest, Operation> exportApplicationIaCSettings() {
    return exportApplicationIaCSettings;
  }

  /** Returns the object with the settings used for calls to exportApplicationIaC. */
  public OperationCallSettings<
          ExportApplicationIaCRequest, ExportApplicationIaCResponse, OperationMetadata>
      exportApplicationIaCOperationSettings() {
    return exportApplicationIaCOperationSettings;
  }

  /** Returns the object with the settings used for calls to importApplicationTemplateIaC. */
  public UnaryCallSettings<
          ImportApplicationTemplateIaCRequest, ImportApplicationTemplateIaCResponse>
      importApplicationTemplateIaCSettings() {
    return importApplicationTemplateIaCSettings;
  }

  /** Returns the object with the settings used for calls to ingestApplicationTemplateIaC. */
  public UnaryCallSettings<IngestApplicationTemplateIaCRequest, Operation>
      ingestApplicationTemplateIaCSettings() {
    return ingestApplicationTemplateIaCSettings;
  }

  /** Returns the object with the settings used for calls to ingestApplicationTemplateIaC. */
  public OperationCallSettings<
          IngestApplicationTemplateIaCRequest,
          IngestApplicationTemplateIaCResponse,
          OperationMetadata>
      ingestApplicationTemplateIaCOperationSettings() {
    return ingestApplicationTemplateIaCOperationSettings;
  }

  /** Returns the object with the settings used for calls to importApplicationIaC. */
  public UnaryCallSettings<ImportApplicationIaCRequest, ImportApplicationIaCResponse>
      importApplicationIaCSettings() {
    return importApplicationIaCSettings;
  }

  /** Returns the object with the settings used for calls to registerAppHubApplicationResources. */
  public UnaryCallSettings<RegisterAppHubApplicationResourcesRequest, Operation>
      registerAppHubApplicationResourcesSettings() {
    return registerAppHubApplicationResourcesSettings;
  }

  /** Returns the object with the settings used for calls to registerAppHubApplicationResources. */
  public OperationCallSettings<
          RegisterAppHubApplicationResourcesRequest,
          RegisterAppHubApplicationResourcesResponse,
          OperationMetadata>
      registerAppHubApplicationResourcesOperationSettings() {
    return registerAppHubApplicationResourcesOperationSettings;
  }

  /**
   * Returns the object with the settings used for calls to listApplicationTemplateSystemRevisions.
   */
  public PagedCallSettings<
          ListApplicationTemplateSystemRevisionsRequest,
          ListApplicationTemplateSystemRevisionsResponse,
          ListApplicationTemplateSystemRevisionsPagedResponse>
      listApplicationTemplateSystemRevisionsSettings() {
    return listApplicationTemplateSystemRevisionsSettings;
  }

  /**
   * Returns the object with the settings used for calls to getApplicationTemplateSystemRevision.
   */
  public UnaryCallSettings<
          GetApplicationTemplateSystemRevisionRequest, ApplicationTemplateSystemRevision>
      getApplicationTemplateSystemRevisionSettings() {
    return getApplicationTemplateSystemRevisionSettings;
  }

  /** Returns the object with the settings used for calls to recommendIAMRoles. */
  public UnaryCallSettings<RecommendIAMRolesRequest, Operation> recommendIAMRolesSettings() {
    return recommendIAMRolesSettings;
  }

  /** Returns the object with the settings used for calls to recommendIAMRoles. */
  public OperationCallSettings<
          RecommendIAMRolesRequest, RecommendIAMRolesResponse, OperationMetadata>
      recommendIAMRolesOperationSettings() {
    return recommendIAMRolesOperationSettings;
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
  public UnaryCallSettings<SetIamPolicyRequest, com.google.iam.v1.Policy> setIamPolicySettings() {
    return setIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, com.google.iam.v1.Policy> getIamPolicySettings() {
    return getIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return testIamPermissionsSettings;
  }

  public DesignCenterStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcDesignCenterStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonDesignCenterStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "designcenter";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "designcenter.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "designcenter.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(DesignCenterStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(DesignCenterStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DesignCenterStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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
  public static Builder newBuilder(@Nullable ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected DesignCenterStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getSpaceSettings = settingsBuilder.getSpaceSettings().build();
    listSpacesSettings = settingsBuilder.listSpacesSettings().build();
    createSpaceSettings = settingsBuilder.createSpaceSettings().build();
    updateSpaceSettings = settingsBuilder.updateSpaceSettings().build();
    deleteSpaceSettings = settingsBuilder.deleteSpaceSettings().build();
    getApplicationTemplateSettings = settingsBuilder.getApplicationTemplateSettings().build();
    listApplicationTemplatesSettings = settingsBuilder.listApplicationTemplatesSettings().build();
    createApplicationTemplateSettings = settingsBuilder.createApplicationTemplateSettings().build();
    updateApplicationTemplateSettings = settingsBuilder.updateApplicationTemplateSettings().build();
    importApplicationTemplateSettings = settingsBuilder.importApplicationTemplateSettings().build();
    deleteApplicationTemplateSettings = settingsBuilder.deleteApplicationTemplateSettings().build();
    commitApplicationTemplateSettings = settingsBuilder.commitApplicationTemplateSettings().build();
    snapshotApplicationTemplateSettings =
        settingsBuilder.snapshotApplicationTemplateSettings().build();
    snapshotApplicationTemplateOperationSettings =
        settingsBuilder.snapshotApplicationTemplateOperationSettings().build();
    generateApplicationTemplateIaCSettings =
        settingsBuilder.generateApplicationTemplateIaCSettings().build();
    exportApplicationTemplateIaCSettings =
        settingsBuilder.exportApplicationTemplateIaCSettings().build();
    exportApplicationTemplateIaCOperationSettings =
        settingsBuilder.exportApplicationTemplateIaCOperationSettings().build();
    generateApplicationTemplateRevisionIaCSettings =
        settingsBuilder.generateApplicationTemplateRevisionIaCSettings().build();
    exportApplicationTemplateRevisionIaCSettings =
        settingsBuilder.exportApplicationTemplateRevisionIaCSettings().build();
    exportApplicationTemplateRevisionIaCOperationSettings =
        settingsBuilder.exportApplicationTemplateRevisionIaCOperationSettings().build();
    getComponentSettings = settingsBuilder.getComponentSettings().build();
    listComponentsSettings = settingsBuilder.listComponentsSettings().build();
    createComponentSettings = settingsBuilder.createComponentSettings().build();
    updateComponentSettings = settingsBuilder.updateComponentSettings().build();
    deleteComponentSettings = settingsBuilder.deleteComponentSettings().build();
    getConnectionSettings = settingsBuilder.getConnectionSettings().build();
    listConnectionsSettings = settingsBuilder.listConnectionsSettings().build();
    createConnectionSettings = settingsBuilder.createConnectionSettings().build();
    updateConnectionSettings = settingsBuilder.updateConnectionSettings().build();
    deleteConnectionSettings = settingsBuilder.deleteConnectionSettings().build();
    getApplicationTemplateRevisionSettings =
        settingsBuilder.getApplicationTemplateRevisionSettings().build();
    listApplicationTemplateRevisionsSettings =
        settingsBuilder.listApplicationTemplateRevisionsSettings().build();
    deleteApplicationTemplateRevisionSettings =
        settingsBuilder.deleteApplicationTemplateRevisionSettings().build();
    getCatalogSettings = settingsBuilder.getCatalogSettings().build();
    listCatalogsSettings = settingsBuilder.listCatalogsSettings().build();
    createCatalogSettings = settingsBuilder.createCatalogSettings().build();
    updateCatalogSettings = settingsBuilder.updateCatalogSettings().build();
    deleteCatalogSettings = settingsBuilder.deleteCatalogSettings().build();
    deleteCatalogOperationSettings = settingsBuilder.deleteCatalogOperationSettings().build();
    createCatalogTemplateSettings = settingsBuilder.createCatalogTemplateSettings().build();
    getCatalogTemplateSettings = settingsBuilder.getCatalogTemplateSettings().build();
    listCatalogTemplatesSettings = settingsBuilder.listCatalogTemplatesSettings().build();
    updateCatalogTemplateSettings = settingsBuilder.updateCatalogTemplateSettings().build();
    deleteCatalogTemplateSettings = settingsBuilder.deleteCatalogTemplateSettings().build();
    deleteCatalogTemplateOperationSettings =
        settingsBuilder.deleteCatalogTemplateOperationSettings().build();
    createShareSettings = settingsBuilder.createShareSettings().build();
    createShareOperationSettings = settingsBuilder.createShareOperationSettings().build();
    listSharesSettings = settingsBuilder.listSharesSettings().build();
    getShareSettings = settingsBuilder.getShareSettings().build();
    deleteShareSettings = settingsBuilder.deleteShareSettings().build();
    deleteShareOperationSettings = settingsBuilder.deleteShareOperationSettings().build();
    syncShareSettings = settingsBuilder.syncShareSettings().build();
    syncShareOperationSettings = settingsBuilder.syncShareOperationSettings().build();
    getSharedTemplateSettings = settingsBuilder.getSharedTemplateSettings().build();
    listSharedTemplatesSettings = settingsBuilder.listSharedTemplatesSettings().build();
    getSharedTemplateRevisionSettings = settingsBuilder.getSharedTemplateRevisionSettings().build();
    listSharedTemplateRevisionsSettings =
        settingsBuilder.listSharedTemplateRevisionsSettings().build();
    createCatalogTemplateRevisionSettings =
        settingsBuilder.createCatalogTemplateRevisionSettings().build();
    createCatalogTemplateRevisionOperationSettings =
        settingsBuilder.createCatalogTemplateRevisionOperationSettings().build();
    getCatalogTemplateRevisionSettings =
        settingsBuilder.getCatalogTemplateRevisionSettings().build();
    listCatalogTemplateRevisionsSettings =
        settingsBuilder.listCatalogTemplateRevisionsSettings().build();
    deleteCatalogTemplateRevisionSettings =
        settingsBuilder.deleteCatalogTemplateRevisionSettings().build();
    deleteCatalogTemplateRevisionOperationSettings =
        settingsBuilder.deleteCatalogTemplateRevisionOperationSettings().build();
    createApplicationSettings = settingsBuilder.createApplicationSettings().build();
    getApplicationSettings = settingsBuilder.getApplicationSettings().build();
    listApplicationsSettings = settingsBuilder.listApplicationsSettings().build();
    updateApplicationSettings = settingsBuilder.updateApplicationSettings().build();
    deleteApplicationSettings = settingsBuilder.deleteApplicationSettings().build();
    deleteApplicationOperationSettings =
        settingsBuilder.deleteApplicationOperationSettings().build();
    deployApplicationSettings = settingsBuilder.deployApplicationSettings().build();
    deployApplicationOperationSettings =
        settingsBuilder.deployApplicationOperationSettings().build();
    previewApplicationSettings = settingsBuilder.previewApplicationSettings().build();
    previewApplicationOperationSettings =
        settingsBuilder.previewApplicationOperationSettings().build();
    fetchApplicationAssessmentReportSettings =
        settingsBuilder.fetchApplicationAssessmentReportSettings().build();
    generateApplicationAssessmentReportSettings =
        settingsBuilder.generateApplicationAssessmentReportSettings().build();
    generateApplicationAssessmentReportOperationSettings =
        settingsBuilder.generateApplicationAssessmentReportOperationSettings().build();
    generateApplicationTemplateAssessmentReportSettings =
        settingsBuilder.generateApplicationTemplateAssessmentReportSettings().build();
    generateApplicationTemplateAssessmentReportOperationSettings =
        settingsBuilder.generateApplicationTemplateAssessmentReportOperationSettings().build();
    generateAssessmentReportSettings = settingsBuilder.generateAssessmentReportSettings().build();
    generateAssessmentReportOperationSettings =
        settingsBuilder.generateAssessmentReportOperationSettings().build();
    generateTerraformPlanAssessmentReportSettings =
        settingsBuilder.generateTerraformPlanAssessmentReportSettings().build();
    generateTerraformPlanAssessmentReportOperationSettings =
        settingsBuilder.generateTerraformPlanAssessmentReportOperationSettings().build();
    getPolicySettings = settingsBuilder.getPolicySettings().build();
    listPoliciesSettings = settingsBuilder.listPoliciesSettings().build();
    createPolicySettings = settingsBuilder.createPolicySettings().build();
    updatePolicySettings = settingsBuilder.updatePolicySettings().build();
    deletePolicySettings = settingsBuilder.deletePolicySettings().build();
    fetchFrameworksSettings = settingsBuilder.fetchFrameworksSettings().build();
    generateApplicationIaCSettings = settingsBuilder.generateApplicationIaCSettings().build();
    exportApplicationIaCSettings = settingsBuilder.exportApplicationIaCSettings().build();
    exportApplicationIaCOperationSettings =
        settingsBuilder.exportApplicationIaCOperationSettings().build();
    importApplicationTemplateIaCSettings =
        settingsBuilder.importApplicationTemplateIaCSettings().build();
    ingestApplicationTemplateIaCSettings =
        settingsBuilder.ingestApplicationTemplateIaCSettings().build();
    ingestApplicationTemplateIaCOperationSettings =
        settingsBuilder.ingestApplicationTemplateIaCOperationSettings().build();
    importApplicationIaCSettings = settingsBuilder.importApplicationIaCSettings().build();
    registerAppHubApplicationResourcesSettings =
        settingsBuilder.registerAppHubApplicationResourcesSettings().build();
    registerAppHubApplicationResourcesOperationSettings =
        settingsBuilder.registerAppHubApplicationResourcesOperationSettings().build();
    listApplicationTemplateSystemRevisionsSettings =
        settingsBuilder.listApplicationTemplateSystemRevisionsSettings().build();
    getApplicationTemplateSystemRevisionSettings =
        settingsBuilder.getApplicationTemplateSystemRevisionSettings().build();
    recommendIAMRolesSettings = settingsBuilder.recommendIAMRolesSettings().build();
    recommendIAMRolesOperationSettings =
        settingsBuilder.recommendIAMRolesOperationSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  @Override
  protected LibraryMetadata getLibraryMetadata() {
    return LibraryMetadata.newBuilder()
        .setArtifactName("com.google.cloud:google-cloud-designcenter")
        .setRepository("googleapis/google-cloud-java")
        .setVersion(Version.VERSION)
        .build();
  }

  /** Builder for DesignCenterStubSettings. */
  public static class Builder extends StubSettings.Builder<DesignCenterStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetSpaceRequest, Space> getSpaceSettings;
    private final PagedCallSettings.Builder<
            ListSpacesRequest, ListSpacesResponse, ListSpacesPagedResponse>
        listSpacesSettings;
    private final UnaryCallSettings.Builder<CreateSpaceRequest, Space> createSpaceSettings;
    private final UnaryCallSettings.Builder<UpdateSpaceRequest, Space> updateSpaceSettings;
    private final UnaryCallSettings.Builder<DeleteSpaceRequest, Empty> deleteSpaceSettings;
    private final UnaryCallSettings.Builder<GetApplicationTemplateRequest, ApplicationTemplate>
        getApplicationTemplateSettings;
    private final PagedCallSettings.Builder<
            ListApplicationTemplatesRequest,
            ListApplicationTemplatesResponse,
            ListApplicationTemplatesPagedResponse>
        listApplicationTemplatesSettings;
    private final UnaryCallSettings.Builder<CreateApplicationTemplateRequest, ApplicationTemplate>
        createApplicationTemplateSettings;
    private final UnaryCallSettings.Builder<UpdateApplicationTemplateRequest, ApplicationTemplate>
        updateApplicationTemplateSettings;
    private final UnaryCallSettings.Builder<ImportApplicationTemplateRequest, ApplicationTemplate>
        importApplicationTemplateSettings;
    private final UnaryCallSettings.Builder<DeleteApplicationTemplateRequest, Empty>
        deleteApplicationTemplateSettings;
    private final UnaryCallSettings.Builder<
            CommitApplicationTemplateRequest, ApplicationTemplateRevision>
        commitApplicationTemplateSettings;
    private final UnaryCallSettings.Builder<SnapshotApplicationTemplateRequest, Operation>
        snapshotApplicationTemplateSettings;
    private final OperationCallSettings.Builder<
            SnapshotApplicationTemplateRequest,
            SnapshotApplicationTemplateResponse,
            OperationMetadata>
        snapshotApplicationTemplateOperationSettings;
    private final UnaryCallSettings.Builder<
            GenerateApplicationTemplateIaCRequest, GenerateApplicationTemplateIaCResponse>
        generateApplicationTemplateIaCSettings;
    private final UnaryCallSettings.Builder<ExportApplicationTemplateIaCRequest, Operation>
        exportApplicationTemplateIaCSettings;
    private final OperationCallSettings.Builder<
            ExportApplicationTemplateIaCRequest,
            ExportApplicationTemplateIaCResponse,
            OperationMetadata>
        exportApplicationTemplateIaCOperationSettings;
    private final UnaryCallSettings.Builder<
            GenerateApplicationTemplateRevisionIaCRequest,
            GenerateApplicationTemplateRevisionIaCResponse>
        generateApplicationTemplateRevisionIaCSettings;
    private final UnaryCallSettings.Builder<ExportApplicationTemplateRevisionIaCRequest, Operation>
        exportApplicationTemplateRevisionIaCSettings;
    private final OperationCallSettings.Builder<
            ExportApplicationTemplateRevisionIaCRequest,
            ExportApplicationTemplateRevisionIaCResponse,
            OperationMetadata>
        exportApplicationTemplateRevisionIaCOperationSettings;
    private final UnaryCallSettings.Builder<GetComponentRequest, Component> getComponentSettings;
    private final PagedCallSettings.Builder<
            ListComponentsRequest, ListComponentsResponse, ListComponentsPagedResponse>
        listComponentsSettings;
    private final UnaryCallSettings.Builder<CreateComponentRequest, Component>
        createComponentSettings;
    private final UnaryCallSettings.Builder<UpdateComponentRequest, Component>
        updateComponentSettings;
    private final UnaryCallSettings.Builder<DeleteComponentRequest, Empty> deleteComponentSettings;
    private final UnaryCallSettings.Builder<GetConnectionRequest, Connection> getConnectionSettings;
    private final PagedCallSettings.Builder<
            ListConnectionsRequest, ListConnectionsResponse, ListConnectionsPagedResponse>
        listConnectionsSettings;
    private final UnaryCallSettings.Builder<CreateConnectionRequest, Connection>
        createConnectionSettings;
    private final UnaryCallSettings.Builder<UpdateConnectionRequest, Connection>
        updateConnectionSettings;
    private final UnaryCallSettings.Builder<DeleteConnectionRequest, Empty>
        deleteConnectionSettings;
    private final UnaryCallSettings.Builder<
            GetApplicationTemplateRevisionRequest, ApplicationTemplateRevision>
        getApplicationTemplateRevisionSettings;
    private final PagedCallSettings.Builder<
            ListApplicationTemplateRevisionsRequest,
            ListApplicationTemplateRevisionsResponse,
            ListApplicationTemplateRevisionsPagedResponse>
        listApplicationTemplateRevisionsSettings;
    private final UnaryCallSettings.Builder<DeleteApplicationTemplateRevisionRequest, Empty>
        deleteApplicationTemplateRevisionSettings;
    private final UnaryCallSettings.Builder<GetCatalogRequest, Catalog> getCatalogSettings;
    private final PagedCallSettings.Builder<
            ListCatalogsRequest, ListCatalogsResponse, ListCatalogsPagedResponse>
        listCatalogsSettings;
    private final UnaryCallSettings.Builder<CreateCatalogRequest, Catalog> createCatalogSettings;
    private final UnaryCallSettings.Builder<UpdateCatalogRequest, Catalog> updateCatalogSettings;
    private final UnaryCallSettings.Builder<DeleteCatalogRequest, Operation> deleteCatalogSettings;
    private final OperationCallSettings.Builder<DeleteCatalogRequest, Empty, OperationMetadata>
        deleteCatalogOperationSettings;
    private final UnaryCallSettings.Builder<CreateCatalogTemplateRequest, CatalogTemplate>
        createCatalogTemplateSettings;
    private final UnaryCallSettings.Builder<GetCatalogTemplateRequest, CatalogTemplate>
        getCatalogTemplateSettings;
    private final PagedCallSettings.Builder<
            ListCatalogTemplatesRequest,
            ListCatalogTemplatesResponse,
            ListCatalogTemplatesPagedResponse>
        listCatalogTemplatesSettings;
    private final UnaryCallSettings.Builder<UpdateCatalogTemplateRequest, CatalogTemplate>
        updateCatalogTemplateSettings;
    private final UnaryCallSettings.Builder<DeleteCatalogTemplateRequest, Operation>
        deleteCatalogTemplateSettings;
    private final OperationCallSettings.Builder<
            DeleteCatalogTemplateRequest, Empty, OperationMetadata>
        deleteCatalogTemplateOperationSettings;
    private final UnaryCallSettings.Builder<CreateShareRequest, Operation> createShareSettings;
    private final OperationCallSettings.Builder<CreateShareRequest, Share, OperationMetadata>
        createShareOperationSettings;
    private final PagedCallSettings.Builder<
            ListSharesRequest, ListSharesResponse, ListSharesPagedResponse>
        listSharesSettings;
    private final UnaryCallSettings.Builder<GetShareRequest, Share> getShareSettings;
    private final UnaryCallSettings.Builder<DeleteShareRequest, Operation> deleteShareSettings;
    private final OperationCallSettings.Builder<DeleteShareRequest, Empty, OperationMetadata>
        deleteShareOperationSettings;
    private final UnaryCallSettings.Builder<SyncShareRequest, Operation> syncShareSettings;
    private final OperationCallSettings.Builder<SyncShareRequest, Share, OperationMetadata>
        syncShareOperationSettings;
    private final UnaryCallSettings.Builder<GetSharedTemplateRequest, SharedTemplate>
        getSharedTemplateSettings;
    private final PagedCallSettings.Builder<
            ListSharedTemplatesRequest,
            ListSharedTemplatesResponse,
            ListSharedTemplatesPagedResponse>
        listSharedTemplatesSettings;
    private final UnaryCallSettings.Builder<
            GetSharedTemplateRevisionRequest, SharedTemplateRevision>
        getSharedTemplateRevisionSettings;
    private final PagedCallSettings.Builder<
            ListSharedTemplateRevisionsRequest,
            ListSharedTemplateRevisionsResponse,
            ListSharedTemplateRevisionsPagedResponse>
        listSharedTemplateRevisionsSettings;
    private final UnaryCallSettings.Builder<CreateCatalogTemplateRevisionRequest, Operation>
        createCatalogTemplateRevisionSettings;
    private final OperationCallSettings.Builder<
            CreateCatalogTemplateRevisionRequest, CatalogTemplateRevision, OperationMetadata>
        createCatalogTemplateRevisionOperationSettings;
    private final UnaryCallSettings.Builder<
            GetCatalogTemplateRevisionRequest, CatalogTemplateRevision>
        getCatalogTemplateRevisionSettings;
    private final PagedCallSettings.Builder<
            ListCatalogTemplateRevisionsRequest,
            ListCatalogTemplateRevisionsResponse,
            ListCatalogTemplateRevisionsPagedResponse>
        listCatalogTemplateRevisionsSettings;
    private final UnaryCallSettings.Builder<DeleteCatalogTemplateRevisionRequest, Operation>
        deleteCatalogTemplateRevisionSettings;
    private final OperationCallSettings.Builder<
            DeleteCatalogTemplateRevisionRequest, Empty, OperationMetadata>
        deleteCatalogTemplateRevisionOperationSettings;
    private final UnaryCallSettings.Builder<CreateApplicationRequest, Application>
        createApplicationSettings;
    private final UnaryCallSettings.Builder<GetApplicationRequest, Application>
        getApplicationSettings;
    private final PagedCallSettings.Builder<
            ListApplicationsRequest, ListApplicationsResponse, ListApplicationsPagedResponse>
        listApplicationsSettings;
    private final UnaryCallSettings.Builder<UpdateApplicationRequest, Application>
        updateApplicationSettings;
    private final UnaryCallSettings.Builder<DeleteApplicationRequest, Operation>
        deleteApplicationSettings;
    private final OperationCallSettings.Builder<DeleteApplicationRequest, Empty, OperationMetadata>
        deleteApplicationOperationSettings;
    private final UnaryCallSettings.Builder<DeployApplicationRequest, Operation>
        deployApplicationSettings;
    private final OperationCallSettings.Builder<
            DeployApplicationRequest, DeployApplicationResponse, OperationMetadata>
        deployApplicationOperationSettings;
    private final UnaryCallSettings.Builder<PreviewApplicationRequest, Operation>
        previewApplicationSettings;
    private final OperationCallSettings.Builder<
            PreviewApplicationRequest, PreviewApplicationResponse, OperationMetadata>
        previewApplicationOperationSettings;
    private final UnaryCallSettings.Builder<
            FetchApplicationAssessmentReportRequest, FetchApplicationAssessmentReportResponse>
        fetchApplicationAssessmentReportSettings;
    private final UnaryCallSettings.Builder<GenerateApplicationAssessmentReportRequest, Operation>
        generateApplicationAssessmentReportSettings;
    private final OperationCallSettings.Builder<
            GenerateApplicationAssessmentReportRequest,
            GenerateApplicationAssessmentReportResponse,
            OperationMetadata>
        generateApplicationAssessmentReportOperationSettings;
    private final UnaryCallSettings.Builder<
            GenerateApplicationTemplateAssessmentReportRequest, Operation>
        generateApplicationTemplateAssessmentReportSettings;
    private final OperationCallSettings.Builder<
            GenerateApplicationTemplateAssessmentReportRequest,
            GenerateApplicationTemplateAssessmentReportResponse,
            OperationMetadata>
        generateApplicationTemplateAssessmentReportOperationSettings;
    private final UnaryCallSettings.Builder<GenerateAssessmentReportRequest, Operation>
        generateAssessmentReportSettings;
    private final OperationCallSettings.Builder<
            GenerateAssessmentReportRequest, GenerateAssessmentReportResponse, OperationMetadata>
        generateAssessmentReportOperationSettings;
    private final UnaryCallSettings.Builder<GenerateTerraformPlanAssessmentReportRequest, Operation>
        generateTerraformPlanAssessmentReportSettings;
    private final OperationCallSettings.Builder<
            GenerateTerraformPlanAssessmentReportRequest,
            GenerateTerraformPlanAssessmentReportResponse,
            OperationMetadata>
        generateTerraformPlanAssessmentReportOperationSettings;
    private final UnaryCallSettings.Builder<GetPolicyRequest, Policy> getPolicySettings;
    private final PagedCallSettings.Builder<
            ListPoliciesRequest, ListPoliciesResponse, ListPoliciesPagedResponse>
        listPoliciesSettings;
    private final UnaryCallSettings.Builder<CreatePolicyRequest, Policy> createPolicySettings;
    private final UnaryCallSettings.Builder<UpdatePolicyRequest, Policy> updatePolicySettings;
    private final UnaryCallSettings.Builder<DeletePolicyRequest, Empty> deletePolicySettings;
    private final PagedCallSettings.Builder<
            FetchFrameworksRequest, FetchFrameworksResponse, FetchFrameworksPagedResponse>
        fetchFrameworksSettings;
    private final UnaryCallSettings.Builder<
            GenerateApplicationIaCRequest, GenerateApplicationIaCResponse>
        generateApplicationIaCSettings;
    private final UnaryCallSettings.Builder<ExportApplicationIaCRequest, Operation>
        exportApplicationIaCSettings;
    private final OperationCallSettings.Builder<
            ExportApplicationIaCRequest, ExportApplicationIaCResponse, OperationMetadata>
        exportApplicationIaCOperationSettings;
    private final UnaryCallSettings.Builder<
            ImportApplicationTemplateIaCRequest, ImportApplicationTemplateIaCResponse>
        importApplicationTemplateIaCSettings;
    private final UnaryCallSettings.Builder<IngestApplicationTemplateIaCRequest, Operation>
        ingestApplicationTemplateIaCSettings;
    private final OperationCallSettings.Builder<
            IngestApplicationTemplateIaCRequest,
            IngestApplicationTemplateIaCResponse,
            OperationMetadata>
        ingestApplicationTemplateIaCOperationSettings;
    private final UnaryCallSettings.Builder<
            ImportApplicationIaCRequest, ImportApplicationIaCResponse>
        importApplicationIaCSettings;
    private final UnaryCallSettings.Builder<RegisterAppHubApplicationResourcesRequest, Operation>
        registerAppHubApplicationResourcesSettings;
    private final OperationCallSettings.Builder<
            RegisterAppHubApplicationResourcesRequest,
            RegisterAppHubApplicationResourcesResponse,
            OperationMetadata>
        registerAppHubApplicationResourcesOperationSettings;
    private final PagedCallSettings.Builder<
            ListApplicationTemplateSystemRevisionsRequest,
            ListApplicationTemplateSystemRevisionsResponse,
            ListApplicationTemplateSystemRevisionsPagedResponse>
        listApplicationTemplateSystemRevisionsSettings;
    private final UnaryCallSettings.Builder<
            GetApplicationTemplateSystemRevisionRequest, ApplicationTemplateSystemRevision>
        getApplicationTemplateSystemRevisionSettings;
    private final UnaryCallSettings.Builder<RecommendIAMRolesRequest, Operation>
        recommendIAMRolesSettings;
    private final OperationCallSettings.Builder<
            RecommendIAMRolesRequest, RecommendIAMRolesResponse, OperationMetadata>
        recommendIAMRolesOperationSettings;
    private final PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings;
    private final UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings;
    private final UnaryCallSettings.Builder<SetIamPolicyRequest, com.google.iam.v1.Policy>
        setIamPolicySettings;
    private final UnaryCallSettings.Builder<GetIamPolicyRequest, com.google.iam.v1.Policy>
        getIamPolicySettings;
    private final UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "no_retry_2_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(10000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeoutDuration(Duration.ofMillis(120000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(120000L))
              .setTotalTimeoutDuration(Duration.ofMillis(120000L))
              .build();
      definitions.put("no_retry_1_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_2_params", settings);
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(@Nullable ClientContext clientContext) {
      super(clientContext);

      getSpaceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listSpacesSettings = PagedCallSettings.newBuilder(LIST_SPACES_PAGE_STR_FACT);
      createSpaceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateSpaceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteSpaceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getApplicationTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listApplicationTemplatesSettings =
          PagedCallSettings.newBuilder(LIST_APPLICATION_TEMPLATES_PAGE_STR_FACT);
      createApplicationTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateApplicationTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      importApplicationTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteApplicationTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      commitApplicationTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      snapshotApplicationTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      snapshotApplicationTemplateOperationSettings = OperationCallSettings.newBuilder();
      generateApplicationTemplateIaCSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      exportApplicationTemplateIaCSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      exportApplicationTemplateIaCOperationSettings = OperationCallSettings.newBuilder();
      generateApplicationTemplateRevisionIaCSettings =
          UnaryCallSettings.newUnaryCallSettingsBuilder();
      exportApplicationTemplateRevisionIaCSettings =
          UnaryCallSettings.newUnaryCallSettingsBuilder();
      exportApplicationTemplateRevisionIaCOperationSettings = OperationCallSettings.newBuilder();
      getComponentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listComponentsSettings = PagedCallSettings.newBuilder(LIST_COMPONENTS_PAGE_STR_FACT);
      createComponentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateComponentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteComponentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getConnectionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listConnectionsSettings = PagedCallSettings.newBuilder(LIST_CONNECTIONS_PAGE_STR_FACT);
      createConnectionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateConnectionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteConnectionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getApplicationTemplateRevisionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listApplicationTemplateRevisionsSettings =
          PagedCallSettings.newBuilder(LIST_APPLICATION_TEMPLATE_REVISIONS_PAGE_STR_FACT);
      deleteApplicationTemplateRevisionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getCatalogSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listCatalogsSettings = PagedCallSettings.newBuilder(LIST_CATALOGS_PAGE_STR_FACT);
      createCatalogSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateCatalogSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteCatalogSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteCatalogOperationSettings = OperationCallSettings.newBuilder();
      createCatalogTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getCatalogTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listCatalogTemplatesSettings =
          PagedCallSettings.newBuilder(LIST_CATALOG_TEMPLATES_PAGE_STR_FACT);
      updateCatalogTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteCatalogTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteCatalogTemplateOperationSettings = OperationCallSettings.newBuilder();
      createShareSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createShareOperationSettings = OperationCallSettings.newBuilder();
      listSharesSettings = PagedCallSettings.newBuilder(LIST_SHARES_PAGE_STR_FACT);
      getShareSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteShareSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteShareOperationSettings = OperationCallSettings.newBuilder();
      syncShareSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      syncShareOperationSettings = OperationCallSettings.newBuilder();
      getSharedTemplateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listSharedTemplatesSettings =
          PagedCallSettings.newBuilder(LIST_SHARED_TEMPLATES_PAGE_STR_FACT);
      getSharedTemplateRevisionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listSharedTemplateRevisionsSettings =
          PagedCallSettings.newBuilder(LIST_SHARED_TEMPLATE_REVISIONS_PAGE_STR_FACT);
      createCatalogTemplateRevisionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createCatalogTemplateRevisionOperationSettings = OperationCallSettings.newBuilder();
      getCatalogTemplateRevisionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listCatalogTemplateRevisionsSettings =
          PagedCallSettings.newBuilder(LIST_CATALOG_TEMPLATE_REVISIONS_PAGE_STR_FACT);
      deleteCatalogTemplateRevisionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteCatalogTemplateRevisionOperationSettings = OperationCallSettings.newBuilder();
      createApplicationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getApplicationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listApplicationsSettings = PagedCallSettings.newBuilder(LIST_APPLICATIONS_PAGE_STR_FACT);
      updateApplicationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteApplicationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteApplicationOperationSettings = OperationCallSettings.newBuilder();
      deployApplicationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deployApplicationOperationSettings = OperationCallSettings.newBuilder();
      previewApplicationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      previewApplicationOperationSettings = OperationCallSettings.newBuilder();
      fetchApplicationAssessmentReportSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      generateApplicationAssessmentReportSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      generateApplicationAssessmentReportOperationSettings = OperationCallSettings.newBuilder();
      generateApplicationTemplateAssessmentReportSettings =
          UnaryCallSettings.newUnaryCallSettingsBuilder();
      generateApplicationTemplateAssessmentReportOperationSettings =
          OperationCallSettings.newBuilder();
      generateAssessmentReportSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      generateAssessmentReportOperationSettings = OperationCallSettings.newBuilder();
      generateTerraformPlanAssessmentReportSettings =
          UnaryCallSettings.newUnaryCallSettingsBuilder();
      generateTerraformPlanAssessmentReportOperationSettings = OperationCallSettings.newBuilder();
      getPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listPoliciesSettings = PagedCallSettings.newBuilder(LIST_POLICIES_PAGE_STR_FACT);
      createPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updatePolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deletePolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      fetchFrameworksSettings = PagedCallSettings.newBuilder(FETCH_FRAMEWORKS_PAGE_STR_FACT);
      generateApplicationIaCSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      exportApplicationIaCSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      exportApplicationIaCOperationSettings = OperationCallSettings.newBuilder();
      importApplicationTemplateIaCSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      ingestApplicationTemplateIaCSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      ingestApplicationTemplateIaCOperationSettings = OperationCallSettings.newBuilder();
      importApplicationIaCSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      registerAppHubApplicationResourcesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      registerAppHubApplicationResourcesOperationSettings = OperationCallSettings.newBuilder();
      listApplicationTemplateSystemRevisionsSettings =
          PagedCallSettings.newBuilder(LIST_APPLICATION_TEMPLATE_SYSTEM_REVISIONS_PAGE_STR_FACT);
      getApplicationTemplateSystemRevisionSettings =
          UnaryCallSettings.newUnaryCallSettingsBuilder();
      recommendIAMRolesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      recommendIAMRolesOperationSettings = OperationCallSettings.newBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getSpaceSettings,
              listSpacesSettings,
              createSpaceSettings,
              updateSpaceSettings,
              deleteSpaceSettings,
              getApplicationTemplateSettings,
              listApplicationTemplatesSettings,
              createApplicationTemplateSettings,
              updateApplicationTemplateSettings,
              importApplicationTemplateSettings,
              deleteApplicationTemplateSettings,
              commitApplicationTemplateSettings,
              snapshotApplicationTemplateSettings,
              generateApplicationTemplateIaCSettings,
              exportApplicationTemplateIaCSettings,
              generateApplicationTemplateRevisionIaCSettings,
              exportApplicationTemplateRevisionIaCSettings,
              getComponentSettings,
              listComponentsSettings,
              createComponentSettings,
              updateComponentSettings,
              deleteComponentSettings,
              getConnectionSettings,
              listConnectionsSettings,
              createConnectionSettings,
              updateConnectionSettings,
              deleteConnectionSettings,
              getApplicationTemplateRevisionSettings,
              listApplicationTemplateRevisionsSettings,
              deleteApplicationTemplateRevisionSettings,
              getCatalogSettings,
              listCatalogsSettings,
              createCatalogSettings,
              updateCatalogSettings,
              deleteCatalogSettings,
              createCatalogTemplateSettings,
              getCatalogTemplateSettings,
              listCatalogTemplatesSettings,
              updateCatalogTemplateSettings,
              deleteCatalogTemplateSettings,
              createShareSettings,
              listSharesSettings,
              getShareSettings,
              deleteShareSettings,
              syncShareSettings,
              getSharedTemplateSettings,
              listSharedTemplatesSettings,
              getSharedTemplateRevisionSettings,
              listSharedTemplateRevisionsSettings,
              createCatalogTemplateRevisionSettings,
              getCatalogTemplateRevisionSettings,
              listCatalogTemplateRevisionsSettings,
              deleteCatalogTemplateRevisionSettings,
              createApplicationSettings,
              getApplicationSettings,
              listApplicationsSettings,
              updateApplicationSettings,
              deleteApplicationSettings,
              deployApplicationSettings,
              previewApplicationSettings,
              fetchApplicationAssessmentReportSettings,
              generateApplicationAssessmentReportSettings,
              generateApplicationTemplateAssessmentReportSettings,
              generateAssessmentReportSettings,
              generateTerraformPlanAssessmentReportSettings,
              getPolicySettings,
              listPoliciesSettings,
              createPolicySettings,
              updatePolicySettings,
              deletePolicySettings,
              fetchFrameworksSettings,
              generateApplicationIaCSettings,
              exportApplicationIaCSettings,
              importApplicationTemplateIaCSettings,
              ingestApplicationTemplateIaCSettings,
              importApplicationIaCSettings,
              registerAppHubApplicationResourcesSettings,
              listApplicationTemplateSystemRevisionsSettings,
              getApplicationTemplateSystemRevisionSettings,
              recommendIAMRolesSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(DesignCenterStubSettings settings) {
      super(settings);

      getSpaceSettings = settings.getSpaceSettings.toBuilder();
      listSpacesSettings = settings.listSpacesSettings.toBuilder();
      createSpaceSettings = settings.createSpaceSettings.toBuilder();
      updateSpaceSettings = settings.updateSpaceSettings.toBuilder();
      deleteSpaceSettings = settings.deleteSpaceSettings.toBuilder();
      getApplicationTemplateSettings = settings.getApplicationTemplateSettings.toBuilder();
      listApplicationTemplatesSettings = settings.listApplicationTemplatesSettings.toBuilder();
      createApplicationTemplateSettings = settings.createApplicationTemplateSettings.toBuilder();
      updateApplicationTemplateSettings = settings.updateApplicationTemplateSettings.toBuilder();
      importApplicationTemplateSettings = settings.importApplicationTemplateSettings.toBuilder();
      deleteApplicationTemplateSettings = settings.deleteApplicationTemplateSettings.toBuilder();
      commitApplicationTemplateSettings = settings.commitApplicationTemplateSettings.toBuilder();
      snapshotApplicationTemplateSettings =
          settings.snapshotApplicationTemplateSettings.toBuilder();
      snapshotApplicationTemplateOperationSettings =
          settings.snapshotApplicationTemplateOperationSettings.toBuilder();
      generateApplicationTemplateIaCSettings =
          settings.generateApplicationTemplateIaCSettings.toBuilder();
      exportApplicationTemplateIaCSettings =
          settings.exportApplicationTemplateIaCSettings.toBuilder();
      exportApplicationTemplateIaCOperationSettings =
          settings.exportApplicationTemplateIaCOperationSettings.toBuilder();
      generateApplicationTemplateRevisionIaCSettings =
          settings.generateApplicationTemplateRevisionIaCSettings.toBuilder();
      exportApplicationTemplateRevisionIaCSettings =
          settings.exportApplicationTemplateRevisionIaCSettings.toBuilder();
      exportApplicationTemplateRevisionIaCOperationSettings =
          settings.exportApplicationTemplateRevisionIaCOperationSettings.toBuilder();
      getComponentSettings = settings.getComponentSettings.toBuilder();
      listComponentsSettings = settings.listComponentsSettings.toBuilder();
      createComponentSettings = settings.createComponentSettings.toBuilder();
      updateComponentSettings = settings.updateComponentSettings.toBuilder();
      deleteComponentSettings = settings.deleteComponentSettings.toBuilder();
      getConnectionSettings = settings.getConnectionSettings.toBuilder();
      listConnectionsSettings = settings.listConnectionsSettings.toBuilder();
      createConnectionSettings = settings.createConnectionSettings.toBuilder();
      updateConnectionSettings = settings.updateConnectionSettings.toBuilder();
      deleteConnectionSettings = settings.deleteConnectionSettings.toBuilder();
      getApplicationTemplateRevisionSettings =
          settings.getApplicationTemplateRevisionSettings.toBuilder();
      listApplicationTemplateRevisionsSettings =
          settings.listApplicationTemplateRevisionsSettings.toBuilder();
      deleteApplicationTemplateRevisionSettings =
          settings.deleteApplicationTemplateRevisionSettings.toBuilder();
      getCatalogSettings = settings.getCatalogSettings.toBuilder();
      listCatalogsSettings = settings.listCatalogsSettings.toBuilder();
      createCatalogSettings = settings.createCatalogSettings.toBuilder();
      updateCatalogSettings = settings.updateCatalogSettings.toBuilder();
      deleteCatalogSettings = settings.deleteCatalogSettings.toBuilder();
      deleteCatalogOperationSettings = settings.deleteCatalogOperationSettings.toBuilder();
      createCatalogTemplateSettings = settings.createCatalogTemplateSettings.toBuilder();
      getCatalogTemplateSettings = settings.getCatalogTemplateSettings.toBuilder();
      listCatalogTemplatesSettings = settings.listCatalogTemplatesSettings.toBuilder();
      updateCatalogTemplateSettings = settings.updateCatalogTemplateSettings.toBuilder();
      deleteCatalogTemplateSettings = settings.deleteCatalogTemplateSettings.toBuilder();
      deleteCatalogTemplateOperationSettings =
          settings.deleteCatalogTemplateOperationSettings.toBuilder();
      createShareSettings = settings.createShareSettings.toBuilder();
      createShareOperationSettings = settings.createShareOperationSettings.toBuilder();
      listSharesSettings = settings.listSharesSettings.toBuilder();
      getShareSettings = settings.getShareSettings.toBuilder();
      deleteShareSettings = settings.deleteShareSettings.toBuilder();
      deleteShareOperationSettings = settings.deleteShareOperationSettings.toBuilder();
      syncShareSettings = settings.syncShareSettings.toBuilder();
      syncShareOperationSettings = settings.syncShareOperationSettings.toBuilder();
      getSharedTemplateSettings = settings.getSharedTemplateSettings.toBuilder();
      listSharedTemplatesSettings = settings.listSharedTemplatesSettings.toBuilder();
      getSharedTemplateRevisionSettings = settings.getSharedTemplateRevisionSettings.toBuilder();
      listSharedTemplateRevisionsSettings =
          settings.listSharedTemplateRevisionsSettings.toBuilder();
      createCatalogTemplateRevisionSettings =
          settings.createCatalogTemplateRevisionSettings.toBuilder();
      createCatalogTemplateRevisionOperationSettings =
          settings.createCatalogTemplateRevisionOperationSettings.toBuilder();
      getCatalogTemplateRevisionSettings = settings.getCatalogTemplateRevisionSettings.toBuilder();
      listCatalogTemplateRevisionsSettings =
          settings.listCatalogTemplateRevisionsSettings.toBuilder();
      deleteCatalogTemplateRevisionSettings =
          settings.deleteCatalogTemplateRevisionSettings.toBuilder();
      deleteCatalogTemplateRevisionOperationSettings =
          settings.deleteCatalogTemplateRevisionOperationSettings.toBuilder();
      createApplicationSettings = settings.createApplicationSettings.toBuilder();
      getApplicationSettings = settings.getApplicationSettings.toBuilder();
      listApplicationsSettings = settings.listApplicationsSettings.toBuilder();
      updateApplicationSettings = settings.updateApplicationSettings.toBuilder();
      deleteApplicationSettings = settings.deleteApplicationSettings.toBuilder();
      deleteApplicationOperationSettings = settings.deleteApplicationOperationSettings.toBuilder();
      deployApplicationSettings = settings.deployApplicationSettings.toBuilder();
      deployApplicationOperationSettings = settings.deployApplicationOperationSettings.toBuilder();
      previewApplicationSettings = settings.previewApplicationSettings.toBuilder();
      previewApplicationOperationSettings =
          settings.previewApplicationOperationSettings.toBuilder();
      fetchApplicationAssessmentReportSettings =
          settings.fetchApplicationAssessmentReportSettings.toBuilder();
      generateApplicationAssessmentReportSettings =
          settings.generateApplicationAssessmentReportSettings.toBuilder();
      generateApplicationAssessmentReportOperationSettings =
          settings.generateApplicationAssessmentReportOperationSettings.toBuilder();
      generateApplicationTemplateAssessmentReportSettings =
          settings.generateApplicationTemplateAssessmentReportSettings.toBuilder();
      generateApplicationTemplateAssessmentReportOperationSettings =
          settings.generateApplicationTemplateAssessmentReportOperationSettings.toBuilder();
      generateAssessmentReportSettings = settings.generateAssessmentReportSettings.toBuilder();
      generateAssessmentReportOperationSettings =
          settings.generateAssessmentReportOperationSettings.toBuilder();
      generateTerraformPlanAssessmentReportSettings =
          settings.generateTerraformPlanAssessmentReportSettings.toBuilder();
      generateTerraformPlanAssessmentReportOperationSettings =
          settings.generateTerraformPlanAssessmentReportOperationSettings.toBuilder();
      getPolicySettings = settings.getPolicySettings.toBuilder();
      listPoliciesSettings = settings.listPoliciesSettings.toBuilder();
      createPolicySettings = settings.createPolicySettings.toBuilder();
      updatePolicySettings = settings.updatePolicySettings.toBuilder();
      deletePolicySettings = settings.deletePolicySettings.toBuilder();
      fetchFrameworksSettings = settings.fetchFrameworksSettings.toBuilder();
      generateApplicationIaCSettings = settings.generateApplicationIaCSettings.toBuilder();
      exportApplicationIaCSettings = settings.exportApplicationIaCSettings.toBuilder();
      exportApplicationIaCOperationSettings =
          settings.exportApplicationIaCOperationSettings.toBuilder();
      importApplicationTemplateIaCSettings =
          settings.importApplicationTemplateIaCSettings.toBuilder();
      ingestApplicationTemplateIaCSettings =
          settings.ingestApplicationTemplateIaCSettings.toBuilder();
      ingestApplicationTemplateIaCOperationSettings =
          settings.ingestApplicationTemplateIaCOperationSettings.toBuilder();
      importApplicationIaCSettings = settings.importApplicationIaCSettings.toBuilder();
      registerAppHubApplicationResourcesSettings =
          settings.registerAppHubApplicationResourcesSettings.toBuilder();
      registerAppHubApplicationResourcesOperationSettings =
          settings.registerAppHubApplicationResourcesOperationSettings.toBuilder();
      listApplicationTemplateSystemRevisionsSettings =
          settings.listApplicationTemplateSystemRevisionsSettings.toBuilder();
      getApplicationTemplateSystemRevisionSettings =
          settings.getApplicationTemplateSystemRevisionSettings.toBuilder();
      recommendIAMRolesSettings = settings.recommendIAMRolesSettings.toBuilder();
      recommendIAMRolesOperationSettings = settings.recommendIAMRolesOperationSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getSpaceSettings,
              listSpacesSettings,
              createSpaceSettings,
              updateSpaceSettings,
              deleteSpaceSettings,
              getApplicationTemplateSettings,
              listApplicationTemplatesSettings,
              createApplicationTemplateSettings,
              updateApplicationTemplateSettings,
              importApplicationTemplateSettings,
              deleteApplicationTemplateSettings,
              commitApplicationTemplateSettings,
              snapshotApplicationTemplateSettings,
              generateApplicationTemplateIaCSettings,
              exportApplicationTemplateIaCSettings,
              generateApplicationTemplateRevisionIaCSettings,
              exportApplicationTemplateRevisionIaCSettings,
              getComponentSettings,
              listComponentsSettings,
              createComponentSettings,
              updateComponentSettings,
              deleteComponentSettings,
              getConnectionSettings,
              listConnectionsSettings,
              createConnectionSettings,
              updateConnectionSettings,
              deleteConnectionSettings,
              getApplicationTemplateRevisionSettings,
              listApplicationTemplateRevisionsSettings,
              deleteApplicationTemplateRevisionSettings,
              getCatalogSettings,
              listCatalogsSettings,
              createCatalogSettings,
              updateCatalogSettings,
              deleteCatalogSettings,
              createCatalogTemplateSettings,
              getCatalogTemplateSettings,
              listCatalogTemplatesSettings,
              updateCatalogTemplateSettings,
              deleteCatalogTemplateSettings,
              createShareSettings,
              listSharesSettings,
              getShareSettings,
              deleteShareSettings,
              syncShareSettings,
              getSharedTemplateSettings,
              listSharedTemplatesSettings,
              getSharedTemplateRevisionSettings,
              listSharedTemplateRevisionsSettings,
              createCatalogTemplateRevisionSettings,
              getCatalogTemplateRevisionSettings,
              listCatalogTemplateRevisionsSettings,
              deleteCatalogTemplateRevisionSettings,
              createApplicationSettings,
              getApplicationSettings,
              listApplicationsSettings,
              updateApplicationSettings,
              deleteApplicationSettings,
              deployApplicationSettings,
              previewApplicationSettings,
              fetchApplicationAssessmentReportSettings,
              generateApplicationAssessmentReportSettings,
              generateApplicationTemplateAssessmentReportSettings,
              generateAssessmentReportSettings,
              generateTerraformPlanAssessmentReportSettings,
              getPolicySettings,
              listPoliciesSettings,
              createPolicySettings,
              updatePolicySettings,
              deletePolicySettings,
              fetchFrameworksSettings,
              generateApplicationIaCSettings,
              exportApplicationIaCSettings,
              importApplicationTemplateIaCSettings,
              ingestApplicationTemplateIaCSettings,
              importApplicationIaCSettings,
              registerAppHubApplicationResourcesSettings,
              listApplicationTemplateSystemRevisionsSettings,
              getApplicationTemplateSystemRevisionSettings,
              recommendIAMRolesSettings,
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
          .getSpaceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listSpacesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createSpaceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateSpaceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .deleteSpaceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .getApplicationTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listApplicationTemplatesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createApplicationTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .updateApplicationTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .importApplicationTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .deleteApplicationTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .commitApplicationTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .snapshotApplicationTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .generateApplicationTemplateIaCSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .exportApplicationTemplateIaCSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .generateApplicationTemplateRevisionIaCSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .exportApplicationTemplateRevisionIaCSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .getComponentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listComponentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createComponentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .updateComponentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .deleteComponentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .getConnectionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listConnectionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createConnectionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .updateConnectionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .deleteConnectionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .getApplicationTemplateRevisionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listApplicationTemplateRevisionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteApplicationTemplateRevisionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .getCatalogSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listCatalogsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createCatalogSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .updateCatalogSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .deleteCatalogSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .createCatalogTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .getCatalogTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listCatalogTemplatesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateCatalogTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .deleteCatalogTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .createShareSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .listSharesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getShareSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteShareSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .syncShareSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .getSharedTemplateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listSharedTemplatesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getSharedTemplateRevisionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listSharedTemplateRevisionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createCatalogTemplateRevisionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .getCatalogTemplateRevisionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listCatalogTemplateRevisionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteCatalogTemplateRevisionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .createApplicationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .getApplicationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listApplicationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateApplicationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .deleteApplicationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .deployApplicationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .previewApplicationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .fetchApplicationAssessmentReportSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .generateApplicationAssessmentReportSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .generateApplicationTemplateAssessmentReportSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .generateAssessmentReportSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .generateTerraformPlanAssessmentReportSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .getPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listPoliciesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .updatePolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .deletePolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .fetchFrameworksSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .generateApplicationIaCSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .exportApplicationIaCSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .importApplicationTemplateIaCSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .ingestApplicationTemplateIaCSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .importApplicationIaCSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .registerAppHubApplicationResourcesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .listApplicationTemplateSystemRevisionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getApplicationTemplateSystemRevisionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .recommendIAMRolesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

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
          .snapshotApplicationTemplateOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<SnapshotApplicationTemplateRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  SnapshotApplicationTemplateResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .exportApplicationTemplateIaCOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ExportApplicationTemplateIaCRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  ExportApplicationTemplateIaCResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .exportApplicationTemplateRevisionIaCOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ExportApplicationTemplateRevisionIaCRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  ExportApplicationTemplateRevisionIaCResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .deleteCatalogOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteCatalogRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .deleteCatalogTemplateOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteCatalogTemplateRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .createShareOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<CreateShareRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Share.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .deleteShareOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<DeleteShareRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .syncShareOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<SyncShareRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Share.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .createCatalogTemplateRevisionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateCatalogTemplateRevisionRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(CatalogTemplateRevision.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .deleteCatalogTemplateRevisionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteCatalogTemplateRevisionRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .deleteApplicationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteApplicationRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .deployApplicationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeployApplicationRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  DeployApplicationResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .previewApplicationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<PreviewApplicationRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  PreviewApplicationResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .generateApplicationAssessmentReportOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<GenerateApplicationAssessmentReportRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  GenerateApplicationAssessmentReportResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .generateApplicationTemplateAssessmentReportOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<GenerateApplicationTemplateAssessmentReportRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  GenerateApplicationTemplateAssessmentReportResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .generateAssessmentReportOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<GenerateAssessmentReportRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  GenerateAssessmentReportResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .generateTerraformPlanAssessmentReportOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<GenerateTerraformPlanAssessmentReportRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  GenerateTerraformPlanAssessmentReportResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .exportApplicationIaCOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ExportApplicationIaCRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  ExportApplicationIaCResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .ingestApplicationTemplateIaCOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<IngestApplicationTemplateIaCRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  IngestApplicationTemplateIaCResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .registerAppHubApplicationResourcesOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<RegisterAppHubApplicationResourcesRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  RegisterAppHubApplicationResourcesResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .recommendIAMRolesOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<RecommendIAMRolesRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  RecommendIAMRolesResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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

    /** Returns the builder for the settings used for calls to getSpace. */
    public UnaryCallSettings.Builder<GetSpaceRequest, Space> getSpaceSettings() {
      return getSpaceSettings;
    }

    /** Returns the builder for the settings used for calls to listSpaces. */
    public PagedCallSettings.Builder<ListSpacesRequest, ListSpacesResponse, ListSpacesPagedResponse>
        listSpacesSettings() {
      return listSpacesSettings;
    }

    /** Returns the builder for the settings used for calls to createSpace. */
    public UnaryCallSettings.Builder<CreateSpaceRequest, Space> createSpaceSettings() {
      return createSpaceSettings;
    }

    /** Returns the builder for the settings used for calls to updateSpace. */
    public UnaryCallSettings.Builder<UpdateSpaceRequest, Space> updateSpaceSettings() {
      return updateSpaceSettings;
    }

    /** Returns the builder for the settings used for calls to deleteSpace. */
    public UnaryCallSettings.Builder<DeleteSpaceRequest, Empty> deleteSpaceSettings() {
      return deleteSpaceSettings;
    }

    /** Returns the builder for the settings used for calls to getApplicationTemplate. */
    public UnaryCallSettings.Builder<GetApplicationTemplateRequest, ApplicationTemplate>
        getApplicationTemplateSettings() {
      return getApplicationTemplateSettings;
    }

    /** Returns the builder for the settings used for calls to listApplicationTemplates. */
    public PagedCallSettings.Builder<
            ListApplicationTemplatesRequest,
            ListApplicationTemplatesResponse,
            ListApplicationTemplatesPagedResponse>
        listApplicationTemplatesSettings() {
      return listApplicationTemplatesSettings;
    }

    /** Returns the builder for the settings used for calls to createApplicationTemplate. */
    public UnaryCallSettings.Builder<CreateApplicationTemplateRequest, ApplicationTemplate>
        createApplicationTemplateSettings() {
      return createApplicationTemplateSettings;
    }

    /** Returns the builder for the settings used for calls to updateApplicationTemplate. */
    public UnaryCallSettings.Builder<UpdateApplicationTemplateRequest, ApplicationTemplate>
        updateApplicationTemplateSettings() {
      return updateApplicationTemplateSettings;
    }

    /** Returns the builder for the settings used for calls to importApplicationTemplate. */
    public UnaryCallSettings.Builder<ImportApplicationTemplateRequest, ApplicationTemplate>
        importApplicationTemplateSettings() {
      return importApplicationTemplateSettings;
    }

    /** Returns the builder for the settings used for calls to deleteApplicationTemplate. */
    public UnaryCallSettings.Builder<DeleteApplicationTemplateRequest, Empty>
        deleteApplicationTemplateSettings() {
      return deleteApplicationTemplateSettings;
    }

    /** Returns the builder for the settings used for calls to commitApplicationTemplate. */
    public UnaryCallSettings.Builder<CommitApplicationTemplateRequest, ApplicationTemplateRevision>
        commitApplicationTemplateSettings() {
      return commitApplicationTemplateSettings;
    }

    /** Returns the builder for the settings used for calls to snapshotApplicationTemplate. */
    public UnaryCallSettings.Builder<SnapshotApplicationTemplateRequest, Operation>
        snapshotApplicationTemplateSettings() {
      return snapshotApplicationTemplateSettings;
    }

    /** Returns the builder for the settings used for calls to snapshotApplicationTemplate. */
    public OperationCallSettings.Builder<
            SnapshotApplicationTemplateRequest,
            SnapshotApplicationTemplateResponse,
            OperationMetadata>
        snapshotApplicationTemplateOperationSettings() {
      return snapshotApplicationTemplateOperationSettings;
    }

    /** Returns the builder for the settings used for calls to generateApplicationTemplateIaC. */
    public UnaryCallSettings.Builder<
            GenerateApplicationTemplateIaCRequest, GenerateApplicationTemplateIaCResponse>
        generateApplicationTemplateIaCSettings() {
      return generateApplicationTemplateIaCSettings;
    }

    /** Returns the builder for the settings used for calls to exportApplicationTemplateIaC. */
    public UnaryCallSettings.Builder<ExportApplicationTemplateIaCRequest, Operation>
        exportApplicationTemplateIaCSettings() {
      return exportApplicationTemplateIaCSettings;
    }

    /** Returns the builder for the settings used for calls to exportApplicationTemplateIaC. */
    public OperationCallSettings.Builder<
            ExportApplicationTemplateIaCRequest,
            ExportApplicationTemplateIaCResponse,
            OperationMetadata>
        exportApplicationTemplateIaCOperationSettings() {
      return exportApplicationTemplateIaCOperationSettings;
    }

    /**
     * Returns the builder for the settings used for calls to
     * generateApplicationTemplateRevisionIaC.
     */
    public UnaryCallSettings.Builder<
            GenerateApplicationTemplateRevisionIaCRequest,
            GenerateApplicationTemplateRevisionIaCResponse>
        generateApplicationTemplateRevisionIaCSettings() {
      return generateApplicationTemplateRevisionIaCSettings;
    }

    /**
     * Returns the builder for the settings used for calls to exportApplicationTemplateRevisionIaC.
     */
    public UnaryCallSettings.Builder<ExportApplicationTemplateRevisionIaCRequest, Operation>
        exportApplicationTemplateRevisionIaCSettings() {
      return exportApplicationTemplateRevisionIaCSettings;
    }

    /**
     * Returns the builder for the settings used for calls to exportApplicationTemplateRevisionIaC.
     */
    public OperationCallSettings.Builder<
            ExportApplicationTemplateRevisionIaCRequest,
            ExportApplicationTemplateRevisionIaCResponse,
            OperationMetadata>
        exportApplicationTemplateRevisionIaCOperationSettings() {
      return exportApplicationTemplateRevisionIaCOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getComponent. */
    public UnaryCallSettings.Builder<GetComponentRequest, Component> getComponentSettings() {
      return getComponentSettings;
    }

    /** Returns the builder for the settings used for calls to listComponents. */
    public PagedCallSettings.Builder<
            ListComponentsRequest, ListComponentsResponse, ListComponentsPagedResponse>
        listComponentsSettings() {
      return listComponentsSettings;
    }

    /** Returns the builder for the settings used for calls to createComponent. */
    public UnaryCallSettings.Builder<CreateComponentRequest, Component> createComponentSettings() {
      return createComponentSettings;
    }

    /** Returns the builder for the settings used for calls to updateComponent. */
    public UnaryCallSettings.Builder<UpdateComponentRequest, Component> updateComponentSettings() {
      return updateComponentSettings;
    }

    /** Returns the builder for the settings used for calls to deleteComponent. */
    public UnaryCallSettings.Builder<DeleteComponentRequest, Empty> deleteComponentSettings() {
      return deleteComponentSettings;
    }

    /** Returns the builder for the settings used for calls to getConnection. */
    public UnaryCallSettings.Builder<GetConnectionRequest, Connection> getConnectionSettings() {
      return getConnectionSettings;
    }

    /** Returns the builder for the settings used for calls to listConnections. */
    public PagedCallSettings.Builder<
            ListConnectionsRequest, ListConnectionsResponse, ListConnectionsPagedResponse>
        listConnectionsSettings() {
      return listConnectionsSettings;
    }

    /** Returns the builder for the settings used for calls to createConnection. */
    public UnaryCallSettings.Builder<CreateConnectionRequest, Connection>
        createConnectionSettings() {
      return createConnectionSettings;
    }

    /** Returns the builder for the settings used for calls to updateConnection. */
    public UnaryCallSettings.Builder<UpdateConnectionRequest, Connection>
        updateConnectionSettings() {
      return updateConnectionSettings;
    }

    /** Returns the builder for the settings used for calls to deleteConnection. */
    public UnaryCallSettings.Builder<DeleteConnectionRequest, Empty> deleteConnectionSettings() {
      return deleteConnectionSettings;
    }

    /** Returns the builder for the settings used for calls to getApplicationTemplateRevision. */
    public UnaryCallSettings.Builder<
            GetApplicationTemplateRevisionRequest, ApplicationTemplateRevision>
        getApplicationTemplateRevisionSettings() {
      return getApplicationTemplateRevisionSettings;
    }

    /** Returns the builder for the settings used for calls to listApplicationTemplateRevisions. */
    public PagedCallSettings.Builder<
            ListApplicationTemplateRevisionsRequest,
            ListApplicationTemplateRevisionsResponse,
            ListApplicationTemplateRevisionsPagedResponse>
        listApplicationTemplateRevisionsSettings() {
      return listApplicationTemplateRevisionsSettings;
    }

    /** Returns the builder for the settings used for calls to deleteApplicationTemplateRevision. */
    public UnaryCallSettings.Builder<DeleteApplicationTemplateRevisionRequest, Empty>
        deleteApplicationTemplateRevisionSettings() {
      return deleteApplicationTemplateRevisionSettings;
    }

    /** Returns the builder for the settings used for calls to getCatalog. */
    public UnaryCallSettings.Builder<GetCatalogRequest, Catalog> getCatalogSettings() {
      return getCatalogSettings;
    }

    /** Returns the builder for the settings used for calls to listCatalogs. */
    public PagedCallSettings.Builder<
            ListCatalogsRequest, ListCatalogsResponse, ListCatalogsPagedResponse>
        listCatalogsSettings() {
      return listCatalogsSettings;
    }

    /** Returns the builder for the settings used for calls to createCatalog. */
    public UnaryCallSettings.Builder<CreateCatalogRequest, Catalog> createCatalogSettings() {
      return createCatalogSettings;
    }

    /** Returns the builder for the settings used for calls to updateCatalog. */
    public UnaryCallSettings.Builder<UpdateCatalogRequest, Catalog> updateCatalogSettings() {
      return updateCatalogSettings;
    }

    /** Returns the builder for the settings used for calls to deleteCatalog. */
    public UnaryCallSettings.Builder<DeleteCatalogRequest, Operation> deleteCatalogSettings() {
      return deleteCatalogSettings;
    }

    /** Returns the builder for the settings used for calls to deleteCatalog. */
    public OperationCallSettings.Builder<DeleteCatalogRequest, Empty, OperationMetadata>
        deleteCatalogOperationSettings() {
      return deleteCatalogOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createCatalogTemplate. */
    public UnaryCallSettings.Builder<CreateCatalogTemplateRequest, CatalogTemplate>
        createCatalogTemplateSettings() {
      return createCatalogTemplateSettings;
    }

    /** Returns the builder for the settings used for calls to getCatalogTemplate. */
    public UnaryCallSettings.Builder<GetCatalogTemplateRequest, CatalogTemplate>
        getCatalogTemplateSettings() {
      return getCatalogTemplateSettings;
    }

    /** Returns the builder for the settings used for calls to listCatalogTemplates. */
    public PagedCallSettings.Builder<
            ListCatalogTemplatesRequest,
            ListCatalogTemplatesResponse,
            ListCatalogTemplatesPagedResponse>
        listCatalogTemplatesSettings() {
      return listCatalogTemplatesSettings;
    }

    /** Returns the builder for the settings used for calls to updateCatalogTemplate. */
    public UnaryCallSettings.Builder<UpdateCatalogTemplateRequest, CatalogTemplate>
        updateCatalogTemplateSettings() {
      return updateCatalogTemplateSettings;
    }

    /** Returns the builder for the settings used for calls to deleteCatalogTemplate. */
    public UnaryCallSettings.Builder<DeleteCatalogTemplateRequest, Operation>
        deleteCatalogTemplateSettings() {
      return deleteCatalogTemplateSettings;
    }

    /** Returns the builder for the settings used for calls to deleteCatalogTemplate. */
    public OperationCallSettings.Builder<DeleteCatalogTemplateRequest, Empty, OperationMetadata>
        deleteCatalogTemplateOperationSettings() {
      return deleteCatalogTemplateOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createShare. */
    public UnaryCallSettings.Builder<CreateShareRequest, Operation> createShareSettings() {
      return createShareSettings;
    }

    /** Returns the builder for the settings used for calls to createShare. */
    public OperationCallSettings.Builder<CreateShareRequest, Share, OperationMetadata>
        createShareOperationSettings() {
      return createShareOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listShares. */
    public PagedCallSettings.Builder<ListSharesRequest, ListSharesResponse, ListSharesPagedResponse>
        listSharesSettings() {
      return listSharesSettings;
    }

    /** Returns the builder for the settings used for calls to getShare. */
    public UnaryCallSettings.Builder<GetShareRequest, Share> getShareSettings() {
      return getShareSettings;
    }

    /** Returns the builder for the settings used for calls to deleteShare. */
    public UnaryCallSettings.Builder<DeleteShareRequest, Operation> deleteShareSettings() {
      return deleteShareSettings;
    }

    /** Returns the builder for the settings used for calls to deleteShare. */
    public OperationCallSettings.Builder<DeleteShareRequest, Empty, OperationMetadata>
        deleteShareOperationSettings() {
      return deleteShareOperationSettings;
    }

    /** Returns the builder for the settings used for calls to syncShare. */
    public UnaryCallSettings.Builder<SyncShareRequest, Operation> syncShareSettings() {
      return syncShareSettings;
    }

    /** Returns the builder for the settings used for calls to syncShare. */
    public OperationCallSettings.Builder<SyncShareRequest, Share, OperationMetadata>
        syncShareOperationSettings() {
      return syncShareOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getSharedTemplate. */
    public UnaryCallSettings.Builder<GetSharedTemplateRequest, SharedTemplate>
        getSharedTemplateSettings() {
      return getSharedTemplateSettings;
    }

    /** Returns the builder for the settings used for calls to listSharedTemplates. */
    public PagedCallSettings.Builder<
            ListSharedTemplatesRequest,
            ListSharedTemplatesResponse,
            ListSharedTemplatesPagedResponse>
        listSharedTemplatesSettings() {
      return listSharedTemplatesSettings;
    }

    /** Returns the builder for the settings used for calls to getSharedTemplateRevision. */
    public UnaryCallSettings.Builder<GetSharedTemplateRevisionRequest, SharedTemplateRevision>
        getSharedTemplateRevisionSettings() {
      return getSharedTemplateRevisionSettings;
    }

    /** Returns the builder for the settings used for calls to listSharedTemplateRevisions. */
    public PagedCallSettings.Builder<
            ListSharedTemplateRevisionsRequest,
            ListSharedTemplateRevisionsResponse,
            ListSharedTemplateRevisionsPagedResponse>
        listSharedTemplateRevisionsSettings() {
      return listSharedTemplateRevisionsSettings;
    }

    /** Returns the builder for the settings used for calls to createCatalogTemplateRevision. */
    public UnaryCallSettings.Builder<CreateCatalogTemplateRevisionRequest, Operation>
        createCatalogTemplateRevisionSettings() {
      return createCatalogTemplateRevisionSettings;
    }

    /** Returns the builder for the settings used for calls to createCatalogTemplateRevision. */
    public OperationCallSettings.Builder<
            CreateCatalogTemplateRevisionRequest, CatalogTemplateRevision, OperationMetadata>
        createCatalogTemplateRevisionOperationSettings() {
      return createCatalogTemplateRevisionOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getCatalogTemplateRevision. */
    public UnaryCallSettings.Builder<GetCatalogTemplateRevisionRequest, CatalogTemplateRevision>
        getCatalogTemplateRevisionSettings() {
      return getCatalogTemplateRevisionSettings;
    }

    /** Returns the builder for the settings used for calls to listCatalogTemplateRevisions. */
    public PagedCallSettings.Builder<
            ListCatalogTemplateRevisionsRequest,
            ListCatalogTemplateRevisionsResponse,
            ListCatalogTemplateRevisionsPagedResponse>
        listCatalogTemplateRevisionsSettings() {
      return listCatalogTemplateRevisionsSettings;
    }

    /** Returns the builder for the settings used for calls to deleteCatalogTemplateRevision. */
    public UnaryCallSettings.Builder<DeleteCatalogTemplateRevisionRequest, Operation>
        deleteCatalogTemplateRevisionSettings() {
      return deleteCatalogTemplateRevisionSettings;
    }

    /** Returns the builder for the settings used for calls to deleteCatalogTemplateRevision. */
    public OperationCallSettings.Builder<
            DeleteCatalogTemplateRevisionRequest, Empty, OperationMetadata>
        deleteCatalogTemplateRevisionOperationSettings() {
      return deleteCatalogTemplateRevisionOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createApplication. */
    public UnaryCallSettings.Builder<CreateApplicationRequest, Application>
        createApplicationSettings() {
      return createApplicationSettings;
    }

    /** Returns the builder for the settings used for calls to getApplication. */
    public UnaryCallSettings.Builder<GetApplicationRequest, Application> getApplicationSettings() {
      return getApplicationSettings;
    }

    /** Returns the builder for the settings used for calls to listApplications. */
    public PagedCallSettings.Builder<
            ListApplicationsRequest, ListApplicationsResponse, ListApplicationsPagedResponse>
        listApplicationsSettings() {
      return listApplicationsSettings;
    }

    /** Returns the builder for the settings used for calls to updateApplication. */
    public UnaryCallSettings.Builder<UpdateApplicationRequest, Application>
        updateApplicationSettings() {
      return updateApplicationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteApplication. */
    public UnaryCallSettings.Builder<DeleteApplicationRequest, Operation>
        deleteApplicationSettings() {
      return deleteApplicationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteApplication. */
    public OperationCallSettings.Builder<DeleteApplicationRequest, Empty, OperationMetadata>
        deleteApplicationOperationSettings() {
      return deleteApplicationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deployApplication. */
    public UnaryCallSettings.Builder<DeployApplicationRequest, Operation>
        deployApplicationSettings() {
      return deployApplicationSettings;
    }

    /** Returns the builder for the settings used for calls to deployApplication. */
    public OperationCallSettings.Builder<
            DeployApplicationRequest, DeployApplicationResponse, OperationMetadata>
        deployApplicationOperationSettings() {
      return deployApplicationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to previewApplication. */
    public UnaryCallSettings.Builder<PreviewApplicationRequest, Operation>
        previewApplicationSettings() {
      return previewApplicationSettings;
    }

    /** Returns the builder for the settings used for calls to previewApplication. */
    public OperationCallSettings.Builder<
            PreviewApplicationRequest, PreviewApplicationResponse, OperationMetadata>
        previewApplicationOperationSettings() {
      return previewApplicationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to fetchApplicationAssessmentReport. */
    public UnaryCallSettings.Builder<
            FetchApplicationAssessmentReportRequest, FetchApplicationAssessmentReportResponse>
        fetchApplicationAssessmentReportSettings() {
      return fetchApplicationAssessmentReportSettings;
    }

    /**
     * Returns the builder for the settings used for calls to generateApplicationAssessmentReport.
     */
    public UnaryCallSettings.Builder<GenerateApplicationAssessmentReportRequest, Operation>
        generateApplicationAssessmentReportSettings() {
      return generateApplicationAssessmentReportSettings;
    }

    /**
     * Returns the builder for the settings used for calls to generateApplicationAssessmentReport.
     */
    public OperationCallSettings.Builder<
            GenerateApplicationAssessmentReportRequest,
            GenerateApplicationAssessmentReportResponse,
            OperationMetadata>
        generateApplicationAssessmentReportOperationSettings() {
      return generateApplicationAssessmentReportOperationSettings;
    }

    /**
     * Returns the builder for the settings used for calls to
     * generateApplicationTemplateAssessmentReport.
     */
    public UnaryCallSettings.Builder<GenerateApplicationTemplateAssessmentReportRequest, Operation>
        generateApplicationTemplateAssessmentReportSettings() {
      return generateApplicationTemplateAssessmentReportSettings;
    }

    /**
     * Returns the builder for the settings used for calls to
     * generateApplicationTemplateAssessmentReport.
     */
    public OperationCallSettings.Builder<
            GenerateApplicationTemplateAssessmentReportRequest,
            GenerateApplicationTemplateAssessmentReportResponse,
            OperationMetadata>
        generateApplicationTemplateAssessmentReportOperationSettings() {
      return generateApplicationTemplateAssessmentReportOperationSettings;
    }

    /**
     * Returns the builder for the settings used for calls to generateAssessmentReport.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<GenerateAssessmentReportRequest, Operation>
        generateAssessmentReportSettings() {
      return generateAssessmentReportSettings;
    }

    /** Returns the builder for the settings used for calls to generateAssessmentReport. */
    public OperationCallSettings.Builder<
            GenerateAssessmentReportRequest, GenerateAssessmentReportResponse, OperationMetadata>
        generateAssessmentReportOperationSettings() {
      return generateAssessmentReportOperationSettings;
    }

    /**
     * Returns the builder for the settings used for calls to generateTerraformPlanAssessmentReport.
     */
    public UnaryCallSettings.Builder<GenerateTerraformPlanAssessmentReportRequest, Operation>
        generateTerraformPlanAssessmentReportSettings() {
      return generateTerraformPlanAssessmentReportSettings;
    }

    /**
     * Returns the builder for the settings used for calls to generateTerraformPlanAssessmentReport.
     */
    public OperationCallSettings.Builder<
            GenerateTerraformPlanAssessmentReportRequest,
            GenerateTerraformPlanAssessmentReportResponse,
            OperationMetadata>
        generateTerraformPlanAssessmentReportOperationSettings() {
      return generateTerraformPlanAssessmentReportOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getPolicy. */
    public UnaryCallSettings.Builder<GetPolicyRequest, Policy> getPolicySettings() {
      return getPolicySettings;
    }

    /** Returns the builder for the settings used for calls to listPolicies. */
    public PagedCallSettings.Builder<
            ListPoliciesRequest, ListPoliciesResponse, ListPoliciesPagedResponse>
        listPoliciesSettings() {
      return listPoliciesSettings;
    }

    /** Returns the builder for the settings used for calls to createPolicy. */
    public UnaryCallSettings.Builder<CreatePolicyRequest, Policy> createPolicySettings() {
      return createPolicySettings;
    }

    /** Returns the builder for the settings used for calls to updatePolicy. */
    public UnaryCallSettings.Builder<UpdatePolicyRequest, Policy> updatePolicySettings() {
      return updatePolicySettings;
    }

    /** Returns the builder for the settings used for calls to deletePolicy. */
    public UnaryCallSettings.Builder<DeletePolicyRequest, Empty> deletePolicySettings() {
      return deletePolicySettings;
    }

    /** Returns the builder for the settings used for calls to fetchFrameworks. */
    public PagedCallSettings.Builder<
            FetchFrameworksRequest, FetchFrameworksResponse, FetchFrameworksPagedResponse>
        fetchFrameworksSettings() {
      return fetchFrameworksSettings;
    }

    /** Returns the builder for the settings used for calls to generateApplicationIaC. */
    public UnaryCallSettings.Builder<GenerateApplicationIaCRequest, GenerateApplicationIaCResponse>
        generateApplicationIaCSettings() {
      return generateApplicationIaCSettings;
    }

    /** Returns the builder for the settings used for calls to exportApplicationIaC. */
    public UnaryCallSettings.Builder<ExportApplicationIaCRequest, Operation>
        exportApplicationIaCSettings() {
      return exportApplicationIaCSettings;
    }

    /** Returns the builder for the settings used for calls to exportApplicationIaC. */
    public OperationCallSettings.Builder<
            ExportApplicationIaCRequest, ExportApplicationIaCResponse, OperationMetadata>
        exportApplicationIaCOperationSettings() {
      return exportApplicationIaCOperationSettings;
    }

    /** Returns the builder for the settings used for calls to importApplicationTemplateIaC. */
    public UnaryCallSettings.Builder<
            ImportApplicationTemplateIaCRequest, ImportApplicationTemplateIaCResponse>
        importApplicationTemplateIaCSettings() {
      return importApplicationTemplateIaCSettings;
    }

    /** Returns the builder for the settings used for calls to ingestApplicationTemplateIaC. */
    public UnaryCallSettings.Builder<IngestApplicationTemplateIaCRequest, Operation>
        ingestApplicationTemplateIaCSettings() {
      return ingestApplicationTemplateIaCSettings;
    }

    /** Returns the builder for the settings used for calls to ingestApplicationTemplateIaC. */
    public OperationCallSettings.Builder<
            IngestApplicationTemplateIaCRequest,
            IngestApplicationTemplateIaCResponse,
            OperationMetadata>
        ingestApplicationTemplateIaCOperationSettings() {
      return ingestApplicationTemplateIaCOperationSettings;
    }

    /** Returns the builder for the settings used for calls to importApplicationIaC. */
    public UnaryCallSettings.Builder<ImportApplicationIaCRequest, ImportApplicationIaCResponse>
        importApplicationIaCSettings() {
      return importApplicationIaCSettings;
    }

    /**
     * Returns the builder for the settings used for calls to registerAppHubApplicationResources.
     */
    public UnaryCallSettings.Builder<RegisterAppHubApplicationResourcesRequest, Operation>
        registerAppHubApplicationResourcesSettings() {
      return registerAppHubApplicationResourcesSettings;
    }

    /**
     * Returns the builder for the settings used for calls to registerAppHubApplicationResources.
     */
    public OperationCallSettings.Builder<
            RegisterAppHubApplicationResourcesRequest,
            RegisterAppHubApplicationResourcesResponse,
            OperationMetadata>
        registerAppHubApplicationResourcesOperationSettings() {
      return registerAppHubApplicationResourcesOperationSettings;
    }

    /**
     * Returns the builder for the settings used for calls to
     * listApplicationTemplateSystemRevisions.
     */
    public PagedCallSettings.Builder<
            ListApplicationTemplateSystemRevisionsRequest,
            ListApplicationTemplateSystemRevisionsResponse,
            ListApplicationTemplateSystemRevisionsPagedResponse>
        listApplicationTemplateSystemRevisionsSettings() {
      return listApplicationTemplateSystemRevisionsSettings;
    }

    /**
     * Returns the builder for the settings used for calls to getApplicationTemplateSystemRevision.
     */
    public UnaryCallSettings.Builder<
            GetApplicationTemplateSystemRevisionRequest, ApplicationTemplateSystemRevision>
        getApplicationTemplateSystemRevisionSettings() {
      return getApplicationTemplateSystemRevisionSettings;
    }

    /** Returns the builder for the settings used for calls to recommendIAMRoles. */
    public UnaryCallSettings.Builder<RecommendIAMRolesRequest, Operation>
        recommendIAMRolesSettings() {
      return recommendIAMRolesSettings;
    }

    /** Returns the builder for the settings used for calls to recommendIAMRoles. */
    public OperationCallSettings.Builder<
            RecommendIAMRolesRequest, RecommendIAMRolesResponse, OperationMetadata>
        recommendIAMRolesOperationSettings() {
      return recommendIAMRolesOperationSettings;
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
    public UnaryCallSettings.Builder<SetIamPolicyRequest, com.google.iam.v1.Policy>
        setIamPolicySettings() {
      return setIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, com.google.iam.v1.Policy>
        getIamPolicySettings() {
      return getIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return testIamPermissionsSettings;
    }

    @Override
    public DesignCenterStubSettings build() throws IOException {
      return new DesignCenterStubSettings(this);
    }
  }
}
