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

package com.google.cloud.designcenter.v1;

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
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.designcenter.v1.stub.DesignCenterStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link DesignCenterClient}.
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
 * DesignCenterSettings.Builder designCenterSettingsBuilder = DesignCenterSettings.newBuilder();
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
 * DesignCenterSettings designCenterSettings = designCenterSettingsBuilder.build();
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
 * DesignCenterSettings.Builder designCenterSettingsBuilder = DesignCenterSettings.newBuilder();
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
public class DesignCenterSettings extends ClientSettings<DesignCenterSettings> {

  /** Returns the object with the settings used for calls to getSpace. */
  public UnaryCallSettings<GetSpaceRequest, Space> getSpaceSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).getSpaceSettings();
  }

  /** Returns the object with the settings used for calls to listSpaces. */
  public PagedCallSettings<ListSpacesRequest, ListSpacesResponse, ListSpacesPagedResponse>
      listSpacesSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).listSpacesSettings();
  }

  /** Returns the object with the settings used for calls to createSpace. */
  public UnaryCallSettings<CreateSpaceRequest, Space> createSpaceSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).createSpaceSettings();
  }

  /** Returns the object with the settings used for calls to updateSpace. */
  public UnaryCallSettings<UpdateSpaceRequest, Space> updateSpaceSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).updateSpaceSettings();
  }

  /** Returns the object with the settings used for calls to deleteSpace. */
  public UnaryCallSettings<DeleteSpaceRequest, Empty> deleteSpaceSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).deleteSpaceSettings();
  }

  /** Returns the object with the settings used for calls to getApplicationTemplate. */
  public UnaryCallSettings<GetApplicationTemplateRequest, ApplicationTemplate>
      getApplicationTemplateSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).getApplicationTemplateSettings();
  }

  /** Returns the object with the settings used for calls to listApplicationTemplates. */
  public PagedCallSettings<
          ListApplicationTemplatesRequest,
          ListApplicationTemplatesResponse,
          ListApplicationTemplatesPagedResponse>
      listApplicationTemplatesSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).listApplicationTemplatesSettings();
  }

  /** Returns the object with the settings used for calls to createApplicationTemplate. */
  public UnaryCallSettings<CreateApplicationTemplateRequest, ApplicationTemplate>
      createApplicationTemplateSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).createApplicationTemplateSettings();
  }

  /** Returns the object with the settings used for calls to updateApplicationTemplate. */
  public UnaryCallSettings<UpdateApplicationTemplateRequest, ApplicationTemplate>
      updateApplicationTemplateSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).updateApplicationTemplateSettings();
  }

  /** Returns the object with the settings used for calls to importApplicationTemplate. */
  public UnaryCallSettings<ImportApplicationTemplateRequest, ApplicationTemplate>
      importApplicationTemplateSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).importApplicationTemplateSettings();
  }

  /** Returns the object with the settings used for calls to deleteApplicationTemplate. */
  public UnaryCallSettings<DeleteApplicationTemplateRequest, Empty>
      deleteApplicationTemplateSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).deleteApplicationTemplateSettings();
  }

  /** Returns the object with the settings used for calls to commitApplicationTemplate. */
  public UnaryCallSettings<CommitApplicationTemplateRequest, ApplicationTemplateRevision>
      commitApplicationTemplateSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).commitApplicationTemplateSettings();
  }

  /** Returns the object with the settings used for calls to snapshotApplicationTemplate. */
  public UnaryCallSettings<SnapshotApplicationTemplateRequest, Operation>
      snapshotApplicationTemplateSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).snapshotApplicationTemplateSettings();
  }

  /** Returns the object with the settings used for calls to snapshotApplicationTemplate. */
  public OperationCallSettings<
          SnapshotApplicationTemplateRequest,
          SnapshotApplicationTemplateResponse,
          OperationMetadata>
      snapshotApplicationTemplateOperationSettings() {
    return ((DesignCenterStubSettings) getStubSettings())
        .snapshotApplicationTemplateOperationSettings();
  }

  /** Returns the object with the settings used for calls to generateApplicationTemplateIaC. */
  public UnaryCallSettings<
          GenerateApplicationTemplateIaCRequest, GenerateApplicationTemplateIaCResponse>
      generateApplicationTemplateIaCSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).generateApplicationTemplateIaCSettings();
  }

  /** Returns the object with the settings used for calls to exportApplicationTemplateIaC. */
  public UnaryCallSettings<ExportApplicationTemplateIaCRequest, Operation>
      exportApplicationTemplateIaCSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).exportApplicationTemplateIaCSettings();
  }

  /** Returns the object with the settings used for calls to exportApplicationTemplateIaC. */
  public OperationCallSettings<
          ExportApplicationTemplateIaCRequest,
          ExportApplicationTemplateIaCResponse,
          OperationMetadata>
      exportApplicationTemplateIaCOperationSettings() {
    return ((DesignCenterStubSettings) getStubSettings())
        .exportApplicationTemplateIaCOperationSettings();
  }

  /**
   * Returns the object with the settings used for calls to generateApplicationTemplateRevisionIaC.
   */
  public UnaryCallSettings<
          GenerateApplicationTemplateRevisionIaCRequest,
          GenerateApplicationTemplateRevisionIaCResponse>
      generateApplicationTemplateRevisionIaCSettings() {
    return ((DesignCenterStubSettings) getStubSettings())
        .generateApplicationTemplateRevisionIaCSettings();
  }

  /**
   * Returns the object with the settings used for calls to exportApplicationTemplateRevisionIaC.
   */
  public UnaryCallSettings<ExportApplicationTemplateRevisionIaCRequest, Operation>
      exportApplicationTemplateRevisionIaCSettings() {
    return ((DesignCenterStubSettings) getStubSettings())
        .exportApplicationTemplateRevisionIaCSettings();
  }

  /**
   * Returns the object with the settings used for calls to exportApplicationTemplateRevisionIaC.
   */
  public OperationCallSettings<
          ExportApplicationTemplateRevisionIaCRequest,
          ExportApplicationTemplateRevisionIaCResponse,
          OperationMetadata>
      exportApplicationTemplateRevisionIaCOperationSettings() {
    return ((DesignCenterStubSettings) getStubSettings())
        .exportApplicationTemplateRevisionIaCOperationSettings();
  }

  /** Returns the object with the settings used for calls to getComponent. */
  public UnaryCallSettings<GetComponentRequest, Component> getComponentSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).getComponentSettings();
  }

  /** Returns the object with the settings used for calls to listComponents. */
  public PagedCallSettings<
          ListComponentsRequest, ListComponentsResponse, ListComponentsPagedResponse>
      listComponentsSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).listComponentsSettings();
  }

  /** Returns the object with the settings used for calls to createComponent. */
  public UnaryCallSettings<CreateComponentRequest, Component> createComponentSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).createComponentSettings();
  }

  /** Returns the object with the settings used for calls to updateComponent. */
  public UnaryCallSettings<UpdateComponentRequest, Component> updateComponentSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).updateComponentSettings();
  }

  /** Returns the object with the settings used for calls to deleteComponent. */
  public UnaryCallSettings<DeleteComponentRequest, Empty> deleteComponentSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).deleteComponentSettings();
  }

  /** Returns the object with the settings used for calls to getConnection. */
  public UnaryCallSettings<GetConnectionRequest, Connection> getConnectionSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).getConnectionSettings();
  }

  /** Returns the object with the settings used for calls to listConnections. */
  public PagedCallSettings<
          ListConnectionsRequest, ListConnectionsResponse, ListConnectionsPagedResponse>
      listConnectionsSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).listConnectionsSettings();
  }

  /** Returns the object with the settings used for calls to createConnection. */
  public UnaryCallSettings<CreateConnectionRequest, Connection> createConnectionSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).createConnectionSettings();
  }

  /** Returns the object with the settings used for calls to updateConnection. */
  public UnaryCallSettings<UpdateConnectionRequest, Connection> updateConnectionSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).updateConnectionSettings();
  }

  /** Returns the object with the settings used for calls to deleteConnection. */
  public UnaryCallSettings<DeleteConnectionRequest, Empty> deleteConnectionSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).deleteConnectionSettings();
  }

  /** Returns the object with the settings used for calls to getApplicationTemplateRevision. */
  public UnaryCallSettings<GetApplicationTemplateRevisionRequest, ApplicationTemplateRevision>
      getApplicationTemplateRevisionSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).getApplicationTemplateRevisionSettings();
  }

  /** Returns the object with the settings used for calls to listApplicationTemplateRevisions. */
  public PagedCallSettings<
          ListApplicationTemplateRevisionsRequest,
          ListApplicationTemplateRevisionsResponse,
          ListApplicationTemplateRevisionsPagedResponse>
      listApplicationTemplateRevisionsSettings() {
    return ((DesignCenterStubSettings) getStubSettings())
        .listApplicationTemplateRevisionsSettings();
  }

  /** Returns the object with the settings used for calls to deleteApplicationTemplateRevision. */
  public UnaryCallSettings<DeleteApplicationTemplateRevisionRequest, Empty>
      deleteApplicationTemplateRevisionSettings() {
    return ((DesignCenterStubSettings) getStubSettings())
        .deleteApplicationTemplateRevisionSettings();
  }

  /** Returns the object with the settings used for calls to getCatalog. */
  public UnaryCallSettings<GetCatalogRequest, Catalog> getCatalogSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).getCatalogSettings();
  }

  /** Returns the object with the settings used for calls to listCatalogs. */
  public PagedCallSettings<ListCatalogsRequest, ListCatalogsResponse, ListCatalogsPagedResponse>
      listCatalogsSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).listCatalogsSettings();
  }

  /** Returns the object with the settings used for calls to createCatalog. */
  public UnaryCallSettings<CreateCatalogRequest, Catalog> createCatalogSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).createCatalogSettings();
  }

  /** Returns the object with the settings used for calls to updateCatalog. */
  public UnaryCallSettings<UpdateCatalogRequest, Catalog> updateCatalogSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).updateCatalogSettings();
  }

  /** Returns the object with the settings used for calls to deleteCatalog. */
  public UnaryCallSettings<DeleteCatalogRequest, Operation> deleteCatalogSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).deleteCatalogSettings();
  }

  /** Returns the object with the settings used for calls to deleteCatalog. */
  public OperationCallSettings<DeleteCatalogRequest, Empty, OperationMetadata>
      deleteCatalogOperationSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).deleteCatalogOperationSettings();
  }

  /** Returns the object with the settings used for calls to createCatalogTemplate. */
  public UnaryCallSettings<CreateCatalogTemplateRequest, CatalogTemplate>
      createCatalogTemplateSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).createCatalogTemplateSettings();
  }

  /** Returns the object with the settings used for calls to getCatalogTemplate. */
  public UnaryCallSettings<GetCatalogTemplateRequest, CatalogTemplate>
      getCatalogTemplateSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).getCatalogTemplateSettings();
  }

  /** Returns the object with the settings used for calls to listCatalogTemplates. */
  public PagedCallSettings<
          ListCatalogTemplatesRequest,
          ListCatalogTemplatesResponse,
          ListCatalogTemplatesPagedResponse>
      listCatalogTemplatesSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).listCatalogTemplatesSettings();
  }

  /** Returns the object with the settings used for calls to updateCatalogTemplate. */
  public UnaryCallSettings<UpdateCatalogTemplateRequest, CatalogTemplate>
      updateCatalogTemplateSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).updateCatalogTemplateSettings();
  }

  /** Returns the object with the settings used for calls to deleteCatalogTemplate. */
  public UnaryCallSettings<DeleteCatalogTemplateRequest, Operation>
      deleteCatalogTemplateSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).deleteCatalogTemplateSettings();
  }

  /** Returns the object with the settings used for calls to deleteCatalogTemplate. */
  public OperationCallSettings<DeleteCatalogTemplateRequest, Empty, OperationMetadata>
      deleteCatalogTemplateOperationSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).deleteCatalogTemplateOperationSettings();
  }

  /** Returns the object with the settings used for calls to createShare. */
  public UnaryCallSettings<CreateShareRequest, Operation> createShareSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).createShareSettings();
  }

  /** Returns the object with the settings used for calls to createShare. */
  public OperationCallSettings<CreateShareRequest, Share, OperationMetadata>
      createShareOperationSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).createShareOperationSettings();
  }

  /** Returns the object with the settings used for calls to listShares. */
  public PagedCallSettings<ListSharesRequest, ListSharesResponse, ListSharesPagedResponse>
      listSharesSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).listSharesSettings();
  }

  /** Returns the object with the settings used for calls to getShare. */
  public UnaryCallSettings<GetShareRequest, Share> getShareSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).getShareSettings();
  }

  /** Returns the object with the settings used for calls to deleteShare. */
  public UnaryCallSettings<DeleteShareRequest, Operation> deleteShareSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).deleteShareSettings();
  }

  /** Returns the object with the settings used for calls to deleteShare. */
  public OperationCallSettings<DeleteShareRequest, Empty, OperationMetadata>
      deleteShareOperationSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).deleteShareOperationSettings();
  }

  /** Returns the object with the settings used for calls to syncShare. */
  public UnaryCallSettings<SyncShareRequest, Operation> syncShareSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).syncShareSettings();
  }

  /** Returns the object with the settings used for calls to syncShare. */
  public OperationCallSettings<SyncShareRequest, Share, OperationMetadata>
      syncShareOperationSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).syncShareOperationSettings();
  }

  /** Returns the object with the settings used for calls to getSharedTemplate. */
  public UnaryCallSettings<GetSharedTemplateRequest, SharedTemplate> getSharedTemplateSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).getSharedTemplateSettings();
  }

  /** Returns the object with the settings used for calls to listSharedTemplates. */
  public PagedCallSettings<
          ListSharedTemplatesRequest, ListSharedTemplatesResponse, ListSharedTemplatesPagedResponse>
      listSharedTemplatesSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).listSharedTemplatesSettings();
  }

  /** Returns the object with the settings used for calls to getSharedTemplateRevision. */
  public UnaryCallSettings<GetSharedTemplateRevisionRequest, SharedTemplateRevision>
      getSharedTemplateRevisionSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).getSharedTemplateRevisionSettings();
  }

  /** Returns the object with the settings used for calls to listSharedTemplateRevisions. */
  public PagedCallSettings<
          ListSharedTemplateRevisionsRequest,
          ListSharedTemplateRevisionsResponse,
          ListSharedTemplateRevisionsPagedResponse>
      listSharedTemplateRevisionsSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).listSharedTemplateRevisionsSettings();
  }

  /** Returns the object with the settings used for calls to createCatalogTemplateRevision. */
  public UnaryCallSettings<CreateCatalogTemplateRevisionRequest, Operation>
      createCatalogTemplateRevisionSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).createCatalogTemplateRevisionSettings();
  }

  /** Returns the object with the settings used for calls to createCatalogTemplateRevision. */
  public OperationCallSettings<
          CreateCatalogTemplateRevisionRequest, CatalogTemplateRevision, OperationMetadata>
      createCatalogTemplateRevisionOperationSettings() {
    return ((DesignCenterStubSettings) getStubSettings())
        .createCatalogTemplateRevisionOperationSettings();
  }

  /** Returns the object with the settings used for calls to getCatalogTemplateRevision. */
  public UnaryCallSettings<GetCatalogTemplateRevisionRequest, CatalogTemplateRevision>
      getCatalogTemplateRevisionSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).getCatalogTemplateRevisionSettings();
  }

  /** Returns the object with the settings used for calls to listCatalogTemplateRevisions. */
  public PagedCallSettings<
          ListCatalogTemplateRevisionsRequest,
          ListCatalogTemplateRevisionsResponse,
          ListCatalogTemplateRevisionsPagedResponse>
      listCatalogTemplateRevisionsSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).listCatalogTemplateRevisionsSettings();
  }

  /** Returns the object with the settings used for calls to deleteCatalogTemplateRevision. */
  public UnaryCallSettings<DeleteCatalogTemplateRevisionRequest, Operation>
      deleteCatalogTemplateRevisionSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).deleteCatalogTemplateRevisionSettings();
  }

  /** Returns the object with the settings used for calls to deleteCatalogTemplateRevision. */
  public OperationCallSettings<DeleteCatalogTemplateRevisionRequest, Empty, OperationMetadata>
      deleteCatalogTemplateRevisionOperationSettings() {
    return ((DesignCenterStubSettings) getStubSettings())
        .deleteCatalogTemplateRevisionOperationSettings();
  }

  /** Returns the object with the settings used for calls to createApplication. */
  public UnaryCallSettings<CreateApplicationRequest, Application> createApplicationSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).createApplicationSettings();
  }

  /** Returns the object with the settings used for calls to getApplication. */
  public UnaryCallSettings<GetApplicationRequest, Application> getApplicationSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).getApplicationSettings();
  }

  /** Returns the object with the settings used for calls to listApplications. */
  public PagedCallSettings<
          ListApplicationsRequest, ListApplicationsResponse, ListApplicationsPagedResponse>
      listApplicationsSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).listApplicationsSettings();
  }

  /** Returns the object with the settings used for calls to updateApplication. */
  public UnaryCallSettings<UpdateApplicationRequest, Application> updateApplicationSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).updateApplicationSettings();
  }

  /** Returns the object with the settings used for calls to deleteApplication. */
  public UnaryCallSettings<DeleteApplicationRequest, Operation> deleteApplicationSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).deleteApplicationSettings();
  }

  /** Returns the object with the settings used for calls to deleteApplication. */
  public OperationCallSettings<DeleteApplicationRequest, Empty, OperationMetadata>
      deleteApplicationOperationSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).deleteApplicationOperationSettings();
  }

  /** Returns the object with the settings used for calls to deployApplication. */
  public UnaryCallSettings<DeployApplicationRequest, Operation> deployApplicationSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).deployApplicationSettings();
  }

  /** Returns the object with the settings used for calls to deployApplication. */
  public OperationCallSettings<
          DeployApplicationRequest, DeployApplicationResponse, OperationMetadata>
      deployApplicationOperationSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).deployApplicationOperationSettings();
  }

  /** Returns the object with the settings used for calls to previewApplication. */
  public UnaryCallSettings<PreviewApplicationRequest, Operation> previewApplicationSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).previewApplicationSettings();
  }

  /** Returns the object with the settings used for calls to previewApplication. */
  public OperationCallSettings<
          PreviewApplicationRequest, PreviewApplicationResponse, OperationMetadata>
      previewApplicationOperationSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).previewApplicationOperationSettings();
  }

  /** Returns the object with the settings used for calls to fetchApplicationAssessmentReport. */
  public UnaryCallSettings<
          FetchApplicationAssessmentReportRequest, FetchApplicationAssessmentReportResponse>
      fetchApplicationAssessmentReportSettings() {
    return ((DesignCenterStubSettings) getStubSettings())
        .fetchApplicationAssessmentReportSettings();
  }

  /** Returns the object with the settings used for calls to generateApplicationAssessmentReport. */
  public UnaryCallSettings<GenerateApplicationAssessmentReportRequest, Operation>
      generateApplicationAssessmentReportSettings() {
    return ((DesignCenterStubSettings) getStubSettings())
        .generateApplicationAssessmentReportSettings();
  }

  /** Returns the object with the settings used for calls to generateApplicationAssessmentReport. */
  public OperationCallSettings<
          GenerateApplicationAssessmentReportRequest,
          GenerateApplicationAssessmentReportResponse,
          OperationMetadata>
      generateApplicationAssessmentReportOperationSettings() {
    return ((DesignCenterStubSettings) getStubSettings())
        .generateApplicationAssessmentReportOperationSettings();
  }

  /**
   * Returns the object with the settings used for calls to
   * generateApplicationTemplateAssessmentReport.
   */
  public UnaryCallSettings<GenerateApplicationTemplateAssessmentReportRequest, Operation>
      generateApplicationTemplateAssessmentReportSettings() {
    return ((DesignCenterStubSettings) getStubSettings())
        .generateApplicationTemplateAssessmentReportSettings();
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
    return ((DesignCenterStubSettings) getStubSettings())
        .generateApplicationTemplateAssessmentReportOperationSettings();
  }

  /**
   * Returns the object with the settings used for calls to generateAssessmentReport.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<GenerateAssessmentReportRequest, Operation>
      generateAssessmentReportSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).generateAssessmentReportSettings();
  }

  /**
   * Returns the object with the settings used for calls to generateAssessmentReport.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public OperationCallSettings<
          GenerateAssessmentReportRequest, GenerateAssessmentReportResponse, OperationMetadata>
      generateAssessmentReportOperationSettings() {
    return ((DesignCenterStubSettings) getStubSettings())
        .generateAssessmentReportOperationSettings();
  }

  /**
   * Returns the object with the settings used for calls to generateTerraformPlanAssessmentReport.
   */
  public UnaryCallSettings<GenerateTerraformPlanAssessmentReportRequest, Operation>
      generateTerraformPlanAssessmentReportSettings() {
    return ((DesignCenterStubSettings) getStubSettings())
        .generateTerraformPlanAssessmentReportSettings();
  }

  /**
   * Returns the object with the settings used for calls to generateTerraformPlanAssessmentReport.
   */
  public OperationCallSettings<
          GenerateTerraformPlanAssessmentReportRequest,
          GenerateTerraformPlanAssessmentReportResponse,
          OperationMetadata>
      generateTerraformPlanAssessmentReportOperationSettings() {
    return ((DesignCenterStubSettings) getStubSettings())
        .generateTerraformPlanAssessmentReportOperationSettings();
  }

  /** Returns the object with the settings used for calls to getPolicy. */
  public UnaryCallSettings<GetPolicyRequest, com.google.cloud.designcenter.v1.Policy>
      getPolicySettings() {
    return ((DesignCenterStubSettings) getStubSettings()).getPolicySettings();
  }

  /** Returns the object with the settings used for calls to listPolicies. */
  public PagedCallSettings<ListPoliciesRequest, ListPoliciesResponse, ListPoliciesPagedResponse>
      listPoliciesSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).listPoliciesSettings();
  }

  /** Returns the object with the settings used for calls to createPolicy. */
  public UnaryCallSettings<CreatePolicyRequest, com.google.cloud.designcenter.v1.Policy>
      createPolicySettings() {
    return ((DesignCenterStubSettings) getStubSettings()).createPolicySettings();
  }

  /** Returns the object with the settings used for calls to updatePolicy. */
  public UnaryCallSettings<UpdatePolicyRequest, com.google.cloud.designcenter.v1.Policy>
      updatePolicySettings() {
    return ((DesignCenterStubSettings) getStubSettings()).updatePolicySettings();
  }

  /** Returns the object with the settings used for calls to deletePolicy. */
  public UnaryCallSettings<DeletePolicyRequest, Empty> deletePolicySettings() {
    return ((DesignCenterStubSettings) getStubSettings()).deletePolicySettings();
  }

  /** Returns the object with the settings used for calls to fetchFrameworks. */
  public PagedCallSettings<
          FetchFrameworksRequest, FetchFrameworksResponse, FetchFrameworksPagedResponse>
      fetchFrameworksSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).fetchFrameworksSettings();
  }

  /** Returns the object with the settings used for calls to generateApplicationIaC. */
  public UnaryCallSettings<GenerateApplicationIaCRequest, GenerateApplicationIaCResponse>
      generateApplicationIaCSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).generateApplicationIaCSettings();
  }

  /** Returns the object with the settings used for calls to exportApplicationIaC. */
  public UnaryCallSettings<ExportApplicationIaCRequest, Operation> exportApplicationIaCSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).exportApplicationIaCSettings();
  }

  /** Returns the object with the settings used for calls to exportApplicationIaC. */
  public OperationCallSettings<
          ExportApplicationIaCRequest, ExportApplicationIaCResponse, OperationMetadata>
      exportApplicationIaCOperationSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).exportApplicationIaCOperationSettings();
  }

  /** Returns the object with the settings used for calls to importApplicationTemplateIaC. */
  public UnaryCallSettings<
          ImportApplicationTemplateIaCRequest, ImportApplicationTemplateIaCResponse>
      importApplicationTemplateIaCSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).importApplicationTemplateIaCSettings();
  }

  /** Returns the object with the settings used for calls to ingestApplicationTemplateIaC. */
  public UnaryCallSettings<IngestApplicationTemplateIaCRequest, Operation>
      ingestApplicationTemplateIaCSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).ingestApplicationTemplateIaCSettings();
  }

  /** Returns the object with the settings used for calls to ingestApplicationTemplateIaC. */
  public OperationCallSettings<
          IngestApplicationTemplateIaCRequest,
          IngestApplicationTemplateIaCResponse,
          OperationMetadata>
      ingestApplicationTemplateIaCOperationSettings() {
    return ((DesignCenterStubSettings) getStubSettings())
        .ingestApplicationTemplateIaCOperationSettings();
  }

  /** Returns the object with the settings used for calls to importApplicationIaC. */
  public UnaryCallSettings<ImportApplicationIaCRequest, ImportApplicationIaCResponse>
      importApplicationIaCSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).importApplicationIaCSettings();
  }

  /** Returns the object with the settings used for calls to registerAppHubApplicationResources. */
  public UnaryCallSettings<RegisterAppHubApplicationResourcesRequest, Operation>
      registerAppHubApplicationResourcesSettings() {
    return ((DesignCenterStubSettings) getStubSettings())
        .registerAppHubApplicationResourcesSettings();
  }

  /** Returns the object with the settings used for calls to registerAppHubApplicationResources. */
  public OperationCallSettings<
          RegisterAppHubApplicationResourcesRequest,
          RegisterAppHubApplicationResourcesResponse,
          OperationMetadata>
      registerAppHubApplicationResourcesOperationSettings() {
    return ((DesignCenterStubSettings) getStubSettings())
        .registerAppHubApplicationResourcesOperationSettings();
  }

  /**
   * Returns the object with the settings used for calls to listApplicationTemplateSystemRevisions.
   */
  public PagedCallSettings<
          ListApplicationTemplateSystemRevisionsRequest,
          ListApplicationTemplateSystemRevisionsResponse,
          ListApplicationTemplateSystemRevisionsPagedResponse>
      listApplicationTemplateSystemRevisionsSettings() {
    return ((DesignCenterStubSettings) getStubSettings())
        .listApplicationTemplateSystemRevisionsSettings();
  }

  /**
   * Returns the object with the settings used for calls to getApplicationTemplateSystemRevision.
   */
  public UnaryCallSettings<
          GetApplicationTemplateSystemRevisionRequest, ApplicationTemplateSystemRevision>
      getApplicationTemplateSystemRevisionSettings() {
    return ((DesignCenterStubSettings) getStubSettings())
        .getApplicationTemplateSystemRevisionSettings();
  }

  /** Returns the object with the settings used for calls to recommendIAMRoles. */
  public UnaryCallSettings<RecommendIAMRolesRequest, Operation> recommendIAMRolesSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).recommendIAMRolesSettings();
  }

  /** Returns the object with the settings used for calls to recommendIAMRoles. */
  public OperationCallSettings<
          RecommendIAMRolesRequest, RecommendIAMRolesResponse, OperationMetadata>
      recommendIAMRolesOperationSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).recommendIAMRolesOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((DesignCenterStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((DesignCenterStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((DesignCenterStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final DesignCenterSettings create(DesignCenterStubSettings stub)
      throws IOException {
    return new DesignCenterSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return DesignCenterStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return DesignCenterStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DesignCenterStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return DesignCenterStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return DesignCenterStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return DesignCenterStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return DesignCenterStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DesignCenterStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected DesignCenterSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for DesignCenterSettings. */
  public static class Builder extends ClientSettings.Builder<DesignCenterSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(@Nullable ClientContext clientContext) {
      super(DesignCenterStubSettings.newBuilder(clientContext));
    }

    protected Builder(DesignCenterSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(DesignCenterStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(DesignCenterStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(DesignCenterStubSettings.newHttpJsonBuilder());
    }

    public DesignCenterStubSettings.Builder getStubSettingsBuilder() {
      return ((DesignCenterStubSettings.Builder) getStubSettings());
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(
          getStubSettingsBuilder().unaryMethodSettingsBuilders(), settingsUpdater);
      return this;
    }

    /** Returns the builder for the settings used for calls to getSpace. */
    public UnaryCallSettings.Builder<GetSpaceRequest, Space> getSpaceSettings() {
      return getStubSettingsBuilder().getSpaceSettings();
    }

    /** Returns the builder for the settings used for calls to listSpaces. */
    public PagedCallSettings.Builder<ListSpacesRequest, ListSpacesResponse, ListSpacesPagedResponse>
        listSpacesSettings() {
      return getStubSettingsBuilder().listSpacesSettings();
    }

    /** Returns the builder for the settings used for calls to createSpace. */
    public UnaryCallSettings.Builder<CreateSpaceRequest, Space> createSpaceSettings() {
      return getStubSettingsBuilder().createSpaceSettings();
    }

    /** Returns the builder for the settings used for calls to updateSpace. */
    public UnaryCallSettings.Builder<UpdateSpaceRequest, Space> updateSpaceSettings() {
      return getStubSettingsBuilder().updateSpaceSettings();
    }

    /** Returns the builder for the settings used for calls to deleteSpace. */
    public UnaryCallSettings.Builder<DeleteSpaceRequest, Empty> deleteSpaceSettings() {
      return getStubSettingsBuilder().deleteSpaceSettings();
    }

    /** Returns the builder for the settings used for calls to getApplicationTemplate. */
    public UnaryCallSettings.Builder<GetApplicationTemplateRequest, ApplicationTemplate>
        getApplicationTemplateSettings() {
      return getStubSettingsBuilder().getApplicationTemplateSettings();
    }

    /** Returns the builder for the settings used for calls to listApplicationTemplates. */
    public PagedCallSettings.Builder<
            ListApplicationTemplatesRequest,
            ListApplicationTemplatesResponse,
            ListApplicationTemplatesPagedResponse>
        listApplicationTemplatesSettings() {
      return getStubSettingsBuilder().listApplicationTemplatesSettings();
    }

    /** Returns the builder for the settings used for calls to createApplicationTemplate. */
    public UnaryCallSettings.Builder<CreateApplicationTemplateRequest, ApplicationTemplate>
        createApplicationTemplateSettings() {
      return getStubSettingsBuilder().createApplicationTemplateSettings();
    }

    /** Returns the builder for the settings used for calls to updateApplicationTemplate. */
    public UnaryCallSettings.Builder<UpdateApplicationTemplateRequest, ApplicationTemplate>
        updateApplicationTemplateSettings() {
      return getStubSettingsBuilder().updateApplicationTemplateSettings();
    }

    /** Returns the builder for the settings used for calls to importApplicationTemplate. */
    public UnaryCallSettings.Builder<ImportApplicationTemplateRequest, ApplicationTemplate>
        importApplicationTemplateSettings() {
      return getStubSettingsBuilder().importApplicationTemplateSettings();
    }

    /** Returns the builder for the settings used for calls to deleteApplicationTemplate. */
    public UnaryCallSettings.Builder<DeleteApplicationTemplateRequest, Empty>
        deleteApplicationTemplateSettings() {
      return getStubSettingsBuilder().deleteApplicationTemplateSettings();
    }

    /** Returns the builder for the settings used for calls to commitApplicationTemplate. */
    public UnaryCallSettings.Builder<CommitApplicationTemplateRequest, ApplicationTemplateRevision>
        commitApplicationTemplateSettings() {
      return getStubSettingsBuilder().commitApplicationTemplateSettings();
    }

    /** Returns the builder for the settings used for calls to snapshotApplicationTemplate. */
    public UnaryCallSettings.Builder<SnapshotApplicationTemplateRequest, Operation>
        snapshotApplicationTemplateSettings() {
      return getStubSettingsBuilder().snapshotApplicationTemplateSettings();
    }

    /** Returns the builder for the settings used for calls to snapshotApplicationTemplate. */
    public OperationCallSettings.Builder<
            SnapshotApplicationTemplateRequest,
            SnapshotApplicationTemplateResponse,
            OperationMetadata>
        snapshotApplicationTemplateOperationSettings() {
      return getStubSettingsBuilder().snapshotApplicationTemplateOperationSettings();
    }

    /** Returns the builder for the settings used for calls to generateApplicationTemplateIaC. */
    public UnaryCallSettings.Builder<
            GenerateApplicationTemplateIaCRequest, GenerateApplicationTemplateIaCResponse>
        generateApplicationTemplateIaCSettings() {
      return getStubSettingsBuilder().generateApplicationTemplateIaCSettings();
    }

    /** Returns the builder for the settings used for calls to exportApplicationTemplateIaC. */
    public UnaryCallSettings.Builder<ExportApplicationTemplateIaCRequest, Operation>
        exportApplicationTemplateIaCSettings() {
      return getStubSettingsBuilder().exportApplicationTemplateIaCSettings();
    }

    /** Returns the builder for the settings used for calls to exportApplicationTemplateIaC. */
    public OperationCallSettings.Builder<
            ExportApplicationTemplateIaCRequest,
            ExportApplicationTemplateIaCResponse,
            OperationMetadata>
        exportApplicationTemplateIaCOperationSettings() {
      return getStubSettingsBuilder().exportApplicationTemplateIaCOperationSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * generateApplicationTemplateRevisionIaC.
     */
    public UnaryCallSettings.Builder<
            GenerateApplicationTemplateRevisionIaCRequest,
            GenerateApplicationTemplateRevisionIaCResponse>
        generateApplicationTemplateRevisionIaCSettings() {
      return getStubSettingsBuilder().generateApplicationTemplateRevisionIaCSettings();
    }

    /**
     * Returns the builder for the settings used for calls to exportApplicationTemplateRevisionIaC.
     */
    public UnaryCallSettings.Builder<ExportApplicationTemplateRevisionIaCRequest, Operation>
        exportApplicationTemplateRevisionIaCSettings() {
      return getStubSettingsBuilder().exportApplicationTemplateRevisionIaCSettings();
    }

    /**
     * Returns the builder for the settings used for calls to exportApplicationTemplateRevisionIaC.
     */
    public OperationCallSettings.Builder<
            ExportApplicationTemplateRevisionIaCRequest,
            ExportApplicationTemplateRevisionIaCResponse,
            OperationMetadata>
        exportApplicationTemplateRevisionIaCOperationSettings() {
      return getStubSettingsBuilder().exportApplicationTemplateRevisionIaCOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getComponent. */
    public UnaryCallSettings.Builder<GetComponentRequest, Component> getComponentSettings() {
      return getStubSettingsBuilder().getComponentSettings();
    }

    /** Returns the builder for the settings used for calls to listComponents. */
    public PagedCallSettings.Builder<
            ListComponentsRequest, ListComponentsResponse, ListComponentsPagedResponse>
        listComponentsSettings() {
      return getStubSettingsBuilder().listComponentsSettings();
    }

    /** Returns the builder for the settings used for calls to createComponent. */
    public UnaryCallSettings.Builder<CreateComponentRequest, Component> createComponentSettings() {
      return getStubSettingsBuilder().createComponentSettings();
    }

    /** Returns the builder for the settings used for calls to updateComponent. */
    public UnaryCallSettings.Builder<UpdateComponentRequest, Component> updateComponentSettings() {
      return getStubSettingsBuilder().updateComponentSettings();
    }

    /** Returns the builder for the settings used for calls to deleteComponent. */
    public UnaryCallSettings.Builder<DeleteComponentRequest, Empty> deleteComponentSettings() {
      return getStubSettingsBuilder().deleteComponentSettings();
    }

    /** Returns the builder for the settings used for calls to getConnection. */
    public UnaryCallSettings.Builder<GetConnectionRequest, Connection> getConnectionSettings() {
      return getStubSettingsBuilder().getConnectionSettings();
    }

    /** Returns the builder for the settings used for calls to listConnections. */
    public PagedCallSettings.Builder<
            ListConnectionsRequest, ListConnectionsResponse, ListConnectionsPagedResponse>
        listConnectionsSettings() {
      return getStubSettingsBuilder().listConnectionsSettings();
    }

    /** Returns the builder for the settings used for calls to createConnection. */
    public UnaryCallSettings.Builder<CreateConnectionRequest, Connection>
        createConnectionSettings() {
      return getStubSettingsBuilder().createConnectionSettings();
    }

    /** Returns the builder for the settings used for calls to updateConnection. */
    public UnaryCallSettings.Builder<UpdateConnectionRequest, Connection>
        updateConnectionSettings() {
      return getStubSettingsBuilder().updateConnectionSettings();
    }

    /** Returns the builder for the settings used for calls to deleteConnection. */
    public UnaryCallSettings.Builder<DeleteConnectionRequest, Empty> deleteConnectionSettings() {
      return getStubSettingsBuilder().deleteConnectionSettings();
    }

    /** Returns the builder for the settings used for calls to getApplicationTemplateRevision. */
    public UnaryCallSettings.Builder<
            GetApplicationTemplateRevisionRequest, ApplicationTemplateRevision>
        getApplicationTemplateRevisionSettings() {
      return getStubSettingsBuilder().getApplicationTemplateRevisionSettings();
    }

    /** Returns the builder for the settings used for calls to listApplicationTemplateRevisions. */
    public PagedCallSettings.Builder<
            ListApplicationTemplateRevisionsRequest,
            ListApplicationTemplateRevisionsResponse,
            ListApplicationTemplateRevisionsPagedResponse>
        listApplicationTemplateRevisionsSettings() {
      return getStubSettingsBuilder().listApplicationTemplateRevisionsSettings();
    }

    /** Returns the builder for the settings used for calls to deleteApplicationTemplateRevision. */
    public UnaryCallSettings.Builder<DeleteApplicationTemplateRevisionRequest, Empty>
        deleteApplicationTemplateRevisionSettings() {
      return getStubSettingsBuilder().deleteApplicationTemplateRevisionSettings();
    }

    /** Returns the builder for the settings used for calls to getCatalog. */
    public UnaryCallSettings.Builder<GetCatalogRequest, Catalog> getCatalogSettings() {
      return getStubSettingsBuilder().getCatalogSettings();
    }

    /** Returns the builder for the settings used for calls to listCatalogs. */
    public PagedCallSettings.Builder<
            ListCatalogsRequest, ListCatalogsResponse, ListCatalogsPagedResponse>
        listCatalogsSettings() {
      return getStubSettingsBuilder().listCatalogsSettings();
    }

    /** Returns the builder for the settings used for calls to createCatalog. */
    public UnaryCallSettings.Builder<CreateCatalogRequest, Catalog> createCatalogSettings() {
      return getStubSettingsBuilder().createCatalogSettings();
    }

    /** Returns the builder for the settings used for calls to updateCatalog. */
    public UnaryCallSettings.Builder<UpdateCatalogRequest, Catalog> updateCatalogSettings() {
      return getStubSettingsBuilder().updateCatalogSettings();
    }

    /** Returns the builder for the settings used for calls to deleteCatalog. */
    public UnaryCallSettings.Builder<DeleteCatalogRequest, Operation> deleteCatalogSettings() {
      return getStubSettingsBuilder().deleteCatalogSettings();
    }

    /** Returns the builder for the settings used for calls to deleteCatalog. */
    public OperationCallSettings.Builder<DeleteCatalogRequest, Empty, OperationMetadata>
        deleteCatalogOperationSettings() {
      return getStubSettingsBuilder().deleteCatalogOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createCatalogTemplate. */
    public UnaryCallSettings.Builder<CreateCatalogTemplateRequest, CatalogTemplate>
        createCatalogTemplateSettings() {
      return getStubSettingsBuilder().createCatalogTemplateSettings();
    }

    /** Returns the builder for the settings used for calls to getCatalogTemplate. */
    public UnaryCallSettings.Builder<GetCatalogTemplateRequest, CatalogTemplate>
        getCatalogTemplateSettings() {
      return getStubSettingsBuilder().getCatalogTemplateSettings();
    }

    /** Returns the builder for the settings used for calls to listCatalogTemplates. */
    public PagedCallSettings.Builder<
            ListCatalogTemplatesRequest,
            ListCatalogTemplatesResponse,
            ListCatalogTemplatesPagedResponse>
        listCatalogTemplatesSettings() {
      return getStubSettingsBuilder().listCatalogTemplatesSettings();
    }

    /** Returns the builder for the settings used for calls to updateCatalogTemplate. */
    public UnaryCallSettings.Builder<UpdateCatalogTemplateRequest, CatalogTemplate>
        updateCatalogTemplateSettings() {
      return getStubSettingsBuilder().updateCatalogTemplateSettings();
    }

    /** Returns the builder for the settings used for calls to deleteCatalogTemplate. */
    public UnaryCallSettings.Builder<DeleteCatalogTemplateRequest, Operation>
        deleteCatalogTemplateSettings() {
      return getStubSettingsBuilder().deleteCatalogTemplateSettings();
    }

    /** Returns the builder for the settings used for calls to deleteCatalogTemplate. */
    public OperationCallSettings.Builder<DeleteCatalogTemplateRequest, Empty, OperationMetadata>
        deleteCatalogTemplateOperationSettings() {
      return getStubSettingsBuilder().deleteCatalogTemplateOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createShare. */
    public UnaryCallSettings.Builder<CreateShareRequest, Operation> createShareSettings() {
      return getStubSettingsBuilder().createShareSettings();
    }

    /** Returns the builder for the settings used for calls to createShare. */
    public OperationCallSettings.Builder<CreateShareRequest, Share, OperationMetadata>
        createShareOperationSettings() {
      return getStubSettingsBuilder().createShareOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listShares. */
    public PagedCallSettings.Builder<ListSharesRequest, ListSharesResponse, ListSharesPagedResponse>
        listSharesSettings() {
      return getStubSettingsBuilder().listSharesSettings();
    }

    /** Returns the builder for the settings used for calls to getShare. */
    public UnaryCallSettings.Builder<GetShareRequest, Share> getShareSettings() {
      return getStubSettingsBuilder().getShareSettings();
    }

    /** Returns the builder for the settings used for calls to deleteShare. */
    public UnaryCallSettings.Builder<DeleteShareRequest, Operation> deleteShareSettings() {
      return getStubSettingsBuilder().deleteShareSettings();
    }

    /** Returns the builder for the settings used for calls to deleteShare. */
    public OperationCallSettings.Builder<DeleteShareRequest, Empty, OperationMetadata>
        deleteShareOperationSettings() {
      return getStubSettingsBuilder().deleteShareOperationSettings();
    }

    /** Returns the builder for the settings used for calls to syncShare. */
    public UnaryCallSettings.Builder<SyncShareRequest, Operation> syncShareSettings() {
      return getStubSettingsBuilder().syncShareSettings();
    }

    /** Returns the builder for the settings used for calls to syncShare. */
    public OperationCallSettings.Builder<SyncShareRequest, Share, OperationMetadata>
        syncShareOperationSettings() {
      return getStubSettingsBuilder().syncShareOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getSharedTemplate. */
    public UnaryCallSettings.Builder<GetSharedTemplateRequest, SharedTemplate>
        getSharedTemplateSettings() {
      return getStubSettingsBuilder().getSharedTemplateSettings();
    }

    /** Returns the builder for the settings used for calls to listSharedTemplates. */
    public PagedCallSettings.Builder<
            ListSharedTemplatesRequest,
            ListSharedTemplatesResponse,
            ListSharedTemplatesPagedResponse>
        listSharedTemplatesSettings() {
      return getStubSettingsBuilder().listSharedTemplatesSettings();
    }

    /** Returns the builder for the settings used for calls to getSharedTemplateRevision. */
    public UnaryCallSettings.Builder<GetSharedTemplateRevisionRequest, SharedTemplateRevision>
        getSharedTemplateRevisionSettings() {
      return getStubSettingsBuilder().getSharedTemplateRevisionSettings();
    }

    /** Returns the builder for the settings used for calls to listSharedTemplateRevisions. */
    public PagedCallSettings.Builder<
            ListSharedTemplateRevisionsRequest,
            ListSharedTemplateRevisionsResponse,
            ListSharedTemplateRevisionsPagedResponse>
        listSharedTemplateRevisionsSettings() {
      return getStubSettingsBuilder().listSharedTemplateRevisionsSettings();
    }

    /** Returns the builder for the settings used for calls to createCatalogTemplateRevision. */
    public UnaryCallSettings.Builder<CreateCatalogTemplateRevisionRequest, Operation>
        createCatalogTemplateRevisionSettings() {
      return getStubSettingsBuilder().createCatalogTemplateRevisionSettings();
    }

    /** Returns the builder for the settings used for calls to createCatalogTemplateRevision. */
    public OperationCallSettings.Builder<
            CreateCatalogTemplateRevisionRequest, CatalogTemplateRevision, OperationMetadata>
        createCatalogTemplateRevisionOperationSettings() {
      return getStubSettingsBuilder().createCatalogTemplateRevisionOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getCatalogTemplateRevision. */
    public UnaryCallSettings.Builder<GetCatalogTemplateRevisionRequest, CatalogTemplateRevision>
        getCatalogTemplateRevisionSettings() {
      return getStubSettingsBuilder().getCatalogTemplateRevisionSettings();
    }

    /** Returns the builder for the settings used for calls to listCatalogTemplateRevisions. */
    public PagedCallSettings.Builder<
            ListCatalogTemplateRevisionsRequest,
            ListCatalogTemplateRevisionsResponse,
            ListCatalogTemplateRevisionsPagedResponse>
        listCatalogTemplateRevisionsSettings() {
      return getStubSettingsBuilder().listCatalogTemplateRevisionsSettings();
    }

    /** Returns the builder for the settings used for calls to deleteCatalogTemplateRevision. */
    public UnaryCallSettings.Builder<DeleteCatalogTemplateRevisionRequest, Operation>
        deleteCatalogTemplateRevisionSettings() {
      return getStubSettingsBuilder().deleteCatalogTemplateRevisionSettings();
    }

    /** Returns the builder for the settings used for calls to deleteCatalogTemplateRevision. */
    public OperationCallSettings.Builder<
            DeleteCatalogTemplateRevisionRequest, Empty, OperationMetadata>
        deleteCatalogTemplateRevisionOperationSettings() {
      return getStubSettingsBuilder().deleteCatalogTemplateRevisionOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createApplication. */
    public UnaryCallSettings.Builder<CreateApplicationRequest, Application>
        createApplicationSettings() {
      return getStubSettingsBuilder().createApplicationSettings();
    }

    /** Returns the builder for the settings used for calls to getApplication. */
    public UnaryCallSettings.Builder<GetApplicationRequest, Application> getApplicationSettings() {
      return getStubSettingsBuilder().getApplicationSettings();
    }

    /** Returns the builder for the settings used for calls to listApplications. */
    public PagedCallSettings.Builder<
            ListApplicationsRequest, ListApplicationsResponse, ListApplicationsPagedResponse>
        listApplicationsSettings() {
      return getStubSettingsBuilder().listApplicationsSettings();
    }

    /** Returns the builder for the settings used for calls to updateApplication. */
    public UnaryCallSettings.Builder<UpdateApplicationRequest, Application>
        updateApplicationSettings() {
      return getStubSettingsBuilder().updateApplicationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteApplication. */
    public UnaryCallSettings.Builder<DeleteApplicationRequest, Operation>
        deleteApplicationSettings() {
      return getStubSettingsBuilder().deleteApplicationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteApplication. */
    public OperationCallSettings.Builder<DeleteApplicationRequest, Empty, OperationMetadata>
        deleteApplicationOperationSettings() {
      return getStubSettingsBuilder().deleteApplicationOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deployApplication. */
    public UnaryCallSettings.Builder<DeployApplicationRequest, Operation>
        deployApplicationSettings() {
      return getStubSettingsBuilder().deployApplicationSettings();
    }

    /** Returns the builder for the settings used for calls to deployApplication. */
    public OperationCallSettings.Builder<
            DeployApplicationRequest, DeployApplicationResponse, OperationMetadata>
        deployApplicationOperationSettings() {
      return getStubSettingsBuilder().deployApplicationOperationSettings();
    }

    /** Returns the builder for the settings used for calls to previewApplication. */
    public UnaryCallSettings.Builder<PreviewApplicationRequest, Operation>
        previewApplicationSettings() {
      return getStubSettingsBuilder().previewApplicationSettings();
    }

    /** Returns the builder for the settings used for calls to previewApplication. */
    public OperationCallSettings.Builder<
            PreviewApplicationRequest, PreviewApplicationResponse, OperationMetadata>
        previewApplicationOperationSettings() {
      return getStubSettingsBuilder().previewApplicationOperationSettings();
    }

    /** Returns the builder for the settings used for calls to fetchApplicationAssessmentReport. */
    public UnaryCallSettings.Builder<
            FetchApplicationAssessmentReportRequest, FetchApplicationAssessmentReportResponse>
        fetchApplicationAssessmentReportSettings() {
      return getStubSettingsBuilder().fetchApplicationAssessmentReportSettings();
    }

    /**
     * Returns the builder for the settings used for calls to generateApplicationAssessmentReport.
     */
    public UnaryCallSettings.Builder<GenerateApplicationAssessmentReportRequest, Operation>
        generateApplicationAssessmentReportSettings() {
      return getStubSettingsBuilder().generateApplicationAssessmentReportSettings();
    }

    /**
     * Returns the builder for the settings used for calls to generateApplicationAssessmentReport.
     */
    public OperationCallSettings.Builder<
            GenerateApplicationAssessmentReportRequest,
            GenerateApplicationAssessmentReportResponse,
            OperationMetadata>
        generateApplicationAssessmentReportOperationSettings() {
      return getStubSettingsBuilder().generateApplicationAssessmentReportOperationSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * generateApplicationTemplateAssessmentReport.
     */
    public UnaryCallSettings.Builder<GenerateApplicationTemplateAssessmentReportRequest, Operation>
        generateApplicationTemplateAssessmentReportSettings() {
      return getStubSettingsBuilder().generateApplicationTemplateAssessmentReportSettings();
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
      return getStubSettingsBuilder()
          .generateApplicationTemplateAssessmentReportOperationSettings();
    }

    /**
     * Returns the builder for the settings used for calls to generateAssessmentReport.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<GenerateAssessmentReportRequest, Operation>
        generateAssessmentReportSettings() {
      return getStubSettingsBuilder().generateAssessmentReportSettings();
    }

    /**
     * Returns the builder for the settings used for calls to generateAssessmentReport.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public OperationCallSettings.Builder<
            GenerateAssessmentReportRequest, GenerateAssessmentReportResponse, OperationMetadata>
        generateAssessmentReportOperationSettings() {
      return getStubSettingsBuilder().generateAssessmentReportOperationSettings();
    }

    /**
     * Returns the builder for the settings used for calls to generateTerraformPlanAssessmentReport.
     */
    public UnaryCallSettings.Builder<GenerateTerraformPlanAssessmentReportRequest, Operation>
        generateTerraformPlanAssessmentReportSettings() {
      return getStubSettingsBuilder().generateTerraformPlanAssessmentReportSettings();
    }

    /**
     * Returns the builder for the settings used for calls to generateTerraformPlanAssessmentReport.
     */
    public OperationCallSettings.Builder<
            GenerateTerraformPlanAssessmentReportRequest,
            GenerateTerraformPlanAssessmentReportResponse,
            OperationMetadata>
        generateTerraformPlanAssessmentReportOperationSettings() {
      return getStubSettingsBuilder().generateTerraformPlanAssessmentReportOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getPolicy. */
    public UnaryCallSettings.Builder<GetPolicyRequest, com.google.cloud.designcenter.v1.Policy>
        getPolicySettings() {
      return getStubSettingsBuilder().getPolicySettings();
    }

    /** Returns the builder for the settings used for calls to listPolicies. */
    public PagedCallSettings.Builder<
            ListPoliciesRequest, ListPoliciesResponse, ListPoliciesPagedResponse>
        listPoliciesSettings() {
      return getStubSettingsBuilder().listPoliciesSettings();
    }

    /** Returns the builder for the settings used for calls to createPolicy. */
    public UnaryCallSettings.Builder<CreatePolicyRequest, com.google.cloud.designcenter.v1.Policy>
        createPolicySettings() {
      return getStubSettingsBuilder().createPolicySettings();
    }

    /** Returns the builder for the settings used for calls to updatePolicy. */
    public UnaryCallSettings.Builder<UpdatePolicyRequest, com.google.cloud.designcenter.v1.Policy>
        updatePolicySettings() {
      return getStubSettingsBuilder().updatePolicySettings();
    }

    /** Returns the builder for the settings used for calls to deletePolicy. */
    public UnaryCallSettings.Builder<DeletePolicyRequest, Empty> deletePolicySettings() {
      return getStubSettingsBuilder().deletePolicySettings();
    }

    /** Returns the builder for the settings used for calls to fetchFrameworks. */
    public PagedCallSettings.Builder<
            FetchFrameworksRequest, FetchFrameworksResponse, FetchFrameworksPagedResponse>
        fetchFrameworksSettings() {
      return getStubSettingsBuilder().fetchFrameworksSettings();
    }

    /** Returns the builder for the settings used for calls to generateApplicationIaC. */
    public UnaryCallSettings.Builder<GenerateApplicationIaCRequest, GenerateApplicationIaCResponse>
        generateApplicationIaCSettings() {
      return getStubSettingsBuilder().generateApplicationIaCSettings();
    }

    /** Returns the builder for the settings used for calls to exportApplicationIaC. */
    public UnaryCallSettings.Builder<ExportApplicationIaCRequest, Operation>
        exportApplicationIaCSettings() {
      return getStubSettingsBuilder().exportApplicationIaCSettings();
    }

    /** Returns the builder for the settings used for calls to exportApplicationIaC. */
    public OperationCallSettings.Builder<
            ExportApplicationIaCRequest, ExportApplicationIaCResponse, OperationMetadata>
        exportApplicationIaCOperationSettings() {
      return getStubSettingsBuilder().exportApplicationIaCOperationSettings();
    }

    /** Returns the builder for the settings used for calls to importApplicationTemplateIaC. */
    public UnaryCallSettings.Builder<
            ImportApplicationTemplateIaCRequest, ImportApplicationTemplateIaCResponse>
        importApplicationTemplateIaCSettings() {
      return getStubSettingsBuilder().importApplicationTemplateIaCSettings();
    }

    /** Returns the builder for the settings used for calls to ingestApplicationTemplateIaC. */
    public UnaryCallSettings.Builder<IngestApplicationTemplateIaCRequest, Operation>
        ingestApplicationTemplateIaCSettings() {
      return getStubSettingsBuilder().ingestApplicationTemplateIaCSettings();
    }

    /** Returns the builder for the settings used for calls to ingestApplicationTemplateIaC. */
    public OperationCallSettings.Builder<
            IngestApplicationTemplateIaCRequest,
            IngestApplicationTemplateIaCResponse,
            OperationMetadata>
        ingestApplicationTemplateIaCOperationSettings() {
      return getStubSettingsBuilder().ingestApplicationTemplateIaCOperationSettings();
    }

    /** Returns the builder for the settings used for calls to importApplicationIaC. */
    public UnaryCallSettings.Builder<ImportApplicationIaCRequest, ImportApplicationIaCResponse>
        importApplicationIaCSettings() {
      return getStubSettingsBuilder().importApplicationIaCSettings();
    }

    /**
     * Returns the builder for the settings used for calls to registerAppHubApplicationResources.
     */
    public UnaryCallSettings.Builder<RegisterAppHubApplicationResourcesRequest, Operation>
        registerAppHubApplicationResourcesSettings() {
      return getStubSettingsBuilder().registerAppHubApplicationResourcesSettings();
    }

    /**
     * Returns the builder for the settings used for calls to registerAppHubApplicationResources.
     */
    public OperationCallSettings.Builder<
            RegisterAppHubApplicationResourcesRequest,
            RegisterAppHubApplicationResourcesResponse,
            OperationMetadata>
        registerAppHubApplicationResourcesOperationSettings() {
      return getStubSettingsBuilder().registerAppHubApplicationResourcesOperationSettings();
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
      return getStubSettingsBuilder().listApplicationTemplateSystemRevisionsSettings();
    }

    /**
     * Returns the builder for the settings used for calls to getApplicationTemplateSystemRevision.
     */
    public UnaryCallSettings.Builder<
            GetApplicationTemplateSystemRevisionRequest, ApplicationTemplateSystemRevision>
        getApplicationTemplateSystemRevisionSettings() {
      return getStubSettingsBuilder().getApplicationTemplateSystemRevisionSettings();
    }

    /** Returns the builder for the settings used for calls to recommendIAMRoles. */
    public UnaryCallSettings.Builder<RecommendIAMRolesRequest, Operation>
        recommendIAMRolesSettings() {
      return getStubSettingsBuilder().recommendIAMRolesSettings();
    }

    /** Returns the builder for the settings used for calls to recommendIAMRoles. */
    public OperationCallSettings.Builder<
            RecommendIAMRolesRequest, RecommendIAMRolesResponse, OperationMetadata>
        recommendIAMRolesOperationSettings() {
      return getStubSettingsBuilder().recommendIAMRolesOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return getStubSettingsBuilder().listLocationsSettings();
    }

    /** Returns the builder for the settings used for calls to getLocation. */
    public UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings() {
      return getStubSettingsBuilder().getLocationSettings();
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return getStubSettingsBuilder().setIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getStubSettingsBuilder().getIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return getStubSettingsBuilder().testIamPermissionsSettings();
    }

    @Override
    public DesignCenterSettings build() throws IOException {
      return new DesignCenterSettings(this);
    }
  }
}
