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

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
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
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the DesignCenter service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public abstract class DesignCenterStub implements BackgroundResource {

  public @Nullable OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.@Nullable OperationsStub
      getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<GetSpaceRequest, Space> getSpaceCallable() {
    throw new UnsupportedOperationException("Not implemented: getSpaceCallable()");
  }

  public UnaryCallable<ListSpacesRequest, ListSpacesPagedResponse> listSpacesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSpacesPagedCallable()");
  }

  public UnaryCallable<ListSpacesRequest, ListSpacesResponse> listSpacesCallable() {
    throw new UnsupportedOperationException("Not implemented: listSpacesCallable()");
  }

  public UnaryCallable<CreateSpaceRequest, Space> createSpaceCallable() {
    throw new UnsupportedOperationException("Not implemented: createSpaceCallable()");
  }

  public UnaryCallable<UpdateSpaceRequest, Space> updateSpaceCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSpaceCallable()");
  }

  public UnaryCallable<DeleteSpaceRequest, Empty> deleteSpaceCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSpaceCallable()");
  }

  public UnaryCallable<GetApplicationTemplateRequest, ApplicationTemplate>
      getApplicationTemplateCallable() {
    throw new UnsupportedOperationException("Not implemented: getApplicationTemplateCallable()");
  }

  public UnaryCallable<ListApplicationTemplatesRequest, ListApplicationTemplatesPagedResponse>
      listApplicationTemplatesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listApplicationTemplatesPagedCallable()");
  }

  public UnaryCallable<ListApplicationTemplatesRequest, ListApplicationTemplatesResponse>
      listApplicationTemplatesCallable() {
    throw new UnsupportedOperationException("Not implemented: listApplicationTemplatesCallable()");
  }

  public UnaryCallable<CreateApplicationTemplateRequest, ApplicationTemplate>
      createApplicationTemplateCallable() {
    throw new UnsupportedOperationException("Not implemented: createApplicationTemplateCallable()");
  }

  public UnaryCallable<UpdateApplicationTemplateRequest, ApplicationTemplate>
      updateApplicationTemplateCallable() {
    throw new UnsupportedOperationException("Not implemented: updateApplicationTemplateCallable()");
  }

  public UnaryCallable<ImportApplicationTemplateRequest, ApplicationTemplate>
      importApplicationTemplateCallable() {
    throw new UnsupportedOperationException("Not implemented: importApplicationTemplateCallable()");
  }

  public UnaryCallable<DeleteApplicationTemplateRequest, Empty>
      deleteApplicationTemplateCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteApplicationTemplateCallable()");
  }

  public UnaryCallable<CommitApplicationTemplateRequest, ApplicationTemplateRevision>
      commitApplicationTemplateCallable() {
    throw new UnsupportedOperationException("Not implemented: commitApplicationTemplateCallable()");
  }

  public OperationCallable<
          SnapshotApplicationTemplateRequest,
          SnapshotApplicationTemplateResponse,
          OperationMetadata>
      snapshotApplicationTemplateOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: snapshotApplicationTemplateOperationCallable()");
  }

  public UnaryCallable<SnapshotApplicationTemplateRequest, Operation>
      snapshotApplicationTemplateCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: snapshotApplicationTemplateCallable()");
  }

  public UnaryCallable<
          GenerateApplicationTemplateIaCRequest, GenerateApplicationTemplateIaCResponse>
      generateApplicationTemplateIaCCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: generateApplicationTemplateIaCCallable()");
  }

  public OperationCallable<
          ExportApplicationTemplateIaCRequest,
          ExportApplicationTemplateIaCResponse,
          OperationMetadata>
      exportApplicationTemplateIaCOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: exportApplicationTemplateIaCOperationCallable()");
  }

  public UnaryCallable<ExportApplicationTemplateIaCRequest, Operation>
      exportApplicationTemplateIaCCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: exportApplicationTemplateIaCCallable()");
  }

  public UnaryCallable<
          GenerateApplicationTemplateRevisionIaCRequest,
          GenerateApplicationTemplateRevisionIaCResponse>
      generateApplicationTemplateRevisionIaCCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: generateApplicationTemplateRevisionIaCCallable()");
  }

  public OperationCallable<
          ExportApplicationTemplateRevisionIaCRequest,
          ExportApplicationTemplateRevisionIaCResponse,
          OperationMetadata>
      exportApplicationTemplateRevisionIaCOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: exportApplicationTemplateRevisionIaCOperationCallable()");
  }

  public UnaryCallable<ExportApplicationTemplateRevisionIaCRequest, Operation>
      exportApplicationTemplateRevisionIaCCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: exportApplicationTemplateRevisionIaCCallable()");
  }

  public UnaryCallable<GetComponentRequest, Component> getComponentCallable() {
    throw new UnsupportedOperationException("Not implemented: getComponentCallable()");
  }

  public UnaryCallable<ListComponentsRequest, ListComponentsPagedResponse>
      listComponentsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listComponentsPagedCallable()");
  }

  public UnaryCallable<ListComponentsRequest, ListComponentsResponse> listComponentsCallable() {
    throw new UnsupportedOperationException("Not implemented: listComponentsCallable()");
  }

  public UnaryCallable<CreateComponentRequest, Component> createComponentCallable() {
    throw new UnsupportedOperationException("Not implemented: createComponentCallable()");
  }

  public UnaryCallable<UpdateComponentRequest, Component> updateComponentCallable() {
    throw new UnsupportedOperationException("Not implemented: updateComponentCallable()");
  }

  public UnaryCallable<DeleteComponentRequest, Empty> deleteComponentCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteComponentCallable()");
  }

  public UnaryCallable<GetConnectionRequest, Connection> getConnectionCallable() {
    throw new UnsupportedOperationException("Not implemented: getConnectionCallable()");
  }

  public UnaryCallable<ListConnectionsRequest, ListConnectionsPagedResponse>
      listConnectionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listConnectionsPagedCallable()");
  }

  public UnaryCallable<ListConnectionsRequest, ListConnectionsResponse> listConnectionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listConnectionsCallable()");
  }

  public UnaryCallable<CreateConnectionRequest, Connection> createConnectionCallable() {
    throw new UnsupportedOperationException("Not implemented: createConnectionCallable()");
  }

  public UnaryCallable<UpdateConnectionRequest, Connection> updateConnectionCallable() {
    throw new UnsupportedOperationException("Not implemented: updateConnectionCallable()");
  }

  public UnaryCallable<DeleteConnectionRequest, Empty> deleteConnectionCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteConnectionCallable()");
  }

  public UnaryCallable<GetApplicationTemplateRevisionRequest, ApplicationTemplateRevision>
      getApplicationTemplateRevisionCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getApplicationTemplateRevisionCallable()");
  }

  public UnaryCallable<
          ListApplicationTemplateRevisionsRequest, ListApplicationTemplateRevisionsPagedResponse>
      listApplicationTemplateRevisionsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listApplicationTemplateRevisionsPagedCallable()");
  }

  public UnaryCallable<
          ListApplicationTemplateRevisionsRequest, ListApplicationTemplateRevisionsResponse>
      listApplicationTemplateRevisionsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listApplicationTemplateRevisionsCallable()");
  }

  public UnaryCallable<DeleteApplicationTemplateRevisionRequest, Empty>
      deleteApplicationTemplateRevisionCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteApplicationTemplateRevisionCallable()");
  }

  public UnaryCallable<GetCatalogRequest, Catalog> getCatalogCallable() {
    throw new UnsupportedOperationException("Not implemented: getCatalogCallable()");
  }

  public UnaryCallable<ListCatalogsRequest, ListCatalogsPagedResponse> listCatalogsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listCatalogsPagedCallable()");
  }

  public UnaryCallable<ListCatalogsRequest, ListCatalogsResponse> listCatalogsCallable() {
    throw new UnsupportedOperationException("Not implemented: listCatalogsCallable()");
  }

  public UnaryCallable<CreateCatalogRequest, Catalog> createCatalogCallable() {
    throw new UnsupportedOperationException("Not implemented: createCatalogCallable()");
  }

  public UnaryCallable<UpdateCatalogRequest, Catalog> updateCatalogCallable() {
    throw new UnsupportedOperationException("Not implemented: updateCatalogCallable()");
  }

  public OperationCallable<DeleteCatalogRequest, Empty, OperationMetadata>
      deleteCatalogOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCatalogOperationCallable()");
  }

  public UnaryCallable<DeleteCatalogRequest, Operation> deleteCatalogCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCatalogCallable()");
  }

  public UnaryCallable<CreateCatalogTemplateRequest, CatalogTemplate>
      createCatalogTemplateCallable() {
    throw new UnsupportedOperationException("Not implemented: createCatalogTemplateCallable()");
  }

  public UnaryCallable<GetCatalogTemplateRequest, CatalogTemplate> getCatalogTemplateCallable() {
    throw new UnsupportedOperationException("Not implemented: getCatalogTemplateCallable()");
  }

  public UnaryCallable<ListCatalogTemplatesRequest, ListCatalogTemplatesPagedResponse>
      listCatalogTemplatesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listCatalogTemplatesPagedCallable()");
  }

  public UnaryCallable<ListCatalogTemplatesRequest, ListCatalogTemplatesResponse>
      listCatalogTemplatesCallable() {
    throw new UnsupportedOperationException("Not implemented: listCatalogTemplatesCallable()");
  }

  public UnaryCallable<UpdateCatalogTemplateRequest, CatalogTemplate>
      updateCatalogTemplateCallable() {
    throw new UnsupportedOperationException("Not implemented: updateCatalogTemplateCallable()");
  }

  public OperationCallable<DeleteCatalogTemplateRequest, Empty, OperationMetadata>
      deleteCatalogTemplateOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteCatalogTemplateOperationCallable()");
  }

  public UnaryCallable<DeleteCatalogTemplateRequest, Operation> deleteCatalogTemplateCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCatalogTemplateCallable()");
  }

  public OperationCallable<CreateShareRequest, Share, OperationMetadata>
      createShareOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createShareOperationCallable()");
  }

  public UnaryCallable<CreateShareRequest, Operation> createShareCallable() {
    throw new UnsupportedOperationException("Not implemented: createShareCallable()");
  }

  public UnaryCallable<ListSharesRequest, ListSharesPagedResponse> listSharesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSharesPagedCallable()");
  }

  public UnaryCallable<ListSharesRequest, ListSharesResponse> listSharesCallable() {
    throw new UnsupportedOperationException("Not implemented: listSharesCallable()");
  }

  public UnaryCallable<GetShareRequest, Share> getShareCallable() {
    throw new UnsupportedOperationException("Not implemented: getShareCallable()");
  }

  public OperationCallable<DeleteShareRequest, Empty, OperationMetadata>
      deleteShareOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteShareOperationCallable()");
  }

  public UnaryCallable<DeleteShareRequest, Operation> deleteShareCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteShareCallable()");
  }

  public OperationCallable<SyncShareRequest, Share, OperationMetadata>
      syncShareOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: syncShareOperationCallable()");
  }

  public UnaryCallable<SyncShareRequest, Operation> syncShareCallable() {
    throw new UnsupportedOperationException("Not implemented: syncShareCallable()");
  }

  public UnaryCallable<GetSharedTemplateRequest, SharedTemplate> getSharedTemplateCallable() {
    throw new UnsupportedOperationException("Not implemented: getSharedTemplateCallable()");
  }

  public UnaryCallable<ListSharedTemplatesRequest, ListSharedTemplatesPagedResponse>
      listSharedTemplatesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSharedTemplatesPagedCallable()");
  }

  public UnaryCallable<ListSharedTemplatesRequest, ListSharedTemplatesResponse>
      listSharedTemplatesCallable() {
    throw new UnsupportedOperationException("Not implemented: listSharedTemplatesCallable()");
  }

  public UnaryCallable<GetSharedTemplateRevisionRequest, SharedTemplateRevision>
      getSharedTemplateRevisionCallable() {
    throw new UnsupportedOperationException("Not implemented: getSharedTemplateRevisionCallable()");
  }

  public UnaryCallable<ListSharedTemplateRevisionsRequest, ListSharedTemplateRevisionsPagedResponse>
      listSharedTemplateRevisionsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listSharedTemplateRevisionsPagedCallable()");
  }

  public UnaryCallable<ListSharedTemplateRevisionsRequest, ListSharedTemplateRevisionsResponse>
      listSharedTemplateRevisionsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listSharedTemplateRevisionsCallable()");
  }

  public OperationCallable<
          CreateCatalogTemplateRevisionRequest, CatalogTemplateRevision, OperationMetadata>
      createCatalogTemplateRevisionOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createCatalogTemplateRevisionOperationCallable()");
  }

  public UnaryCallable<CreateCatalogTemplateRevisionRequest, Operation>
      createCatalogTemplateRevisionCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createCatalogTemplateRevisionCallable()");
  }

  public UnaryCallable<GetCatalogTemplateRevisionRequest, CatalogTemplateRevision>
      getCatalogTemplateRevisionCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getCatalogTemplateRevisionCallable()");
  }

  public UnaryCallable<
          ListCatalogTemplateRevisionsRequest, ListCatalogTemplateRevisionsPagedResponse>
      listCatalogTemplateRevisionsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listCatalogTemplateRevisionsPagedCallable()");
  }

  public UnaryCallable<ListCatalogTemplateRevisionsRequest, ListCatalogTemplateRevisionsResponse>
      listCatalogTemplateRevisionsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listCatalogTemplateRevisionsCallable()");
  }

  public OperationCallable<DeleteCatalogTemplateRevisionRequest, Empty, OperationMetadata>
      deleteCatalogTemplateRevisionOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteCatalogTemplateRevisionOperationCallable()");
  }

  public UnaryCallable<DeleteCatalogTemplateRevisionRequest, Operation>
      deleteCatalogTemplateRevisionCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteCatalogTemplateRevisionCallable()");
  }

  public UnaryCallable<CreateApplicationRequest, Application> createApplicationCallable() {
    throw new UnsupportedOperationException("Not implemented: createApplicationCallable()");
  }

  public UnaryCallable<GetApplicationRequest, Application> getApplicationCallable() {
    throw new UnsupportedOperationException("Not implemented: getApplicationCallable()");
  }

  public UnaryCallable<ListApplicationsRequest, ListApplicationsPagedResponse>
      listApplicationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listApplicationsPagedCallable()");
  }

  public UnaryCallable<ListApplicationsRequest, ListApplicationsResponse>
      listApplicationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listApplicationsCallable()");
  }

  public UnaryCallable<UpdateApplicationRequest, Application> updateApplicationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateApplicationCallable()");
  }

  public OperationCallable<DeleteApplicationRequest, Empty, OperationMetadata>
      deleteApplicationOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteApplicationOperationCallable()");
  }

  public UnaryCallable<DeleteApplicationRequest, Operation> deleteApplicationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteApplicationCallable()");
  }

  public OperationCallable<DeployApplicationRequest, DeployApplicationResponse, OperationMetadata>
      deployApplicationOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deployApplicationOperationCallable()");
  }

  public UnaryCallable<DeployApplicationRequest, Operation> deployApplicationCallable() {
    throw new UnsupportedOperationException("Not implemented: deployApplicationCallable()");
  }

  public OperationCallable<PreviewApplicationRequest, PreviewApplicationResponse, OperationMetadata>
      previewApplicationOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: previewApplicationOperationCallable()");
  }

  public UnaryCallable<PreviewApplicationRequest, Operation> previewApplicationCallable() {
    throw new UnsupportedOperationException("Not implemented: previewApplicationCallable()");
  }

  public UnaryCallable<
          FetchApplicationAssessmentReportRequest, FetchApplicationAssessmentReportResponse>
      fetchApplicationAssessmentReportCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: fetchApplicationAssessmentReportCallable()");
  }

  public OperationCallable<
          GenerateApplicationAssessmentReportRequest,
          GenerateApplicationAssessmentReportResponse,
          OperationMetadata>
      generateApplicationAssessmentReportOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: generateApplicationAssessmentReportOperationCallable()");
  }

  public UnaryCallable<GenerateApplicationAssessmentReportRequest, Operation>
      generateApplicationAssessmentReportCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: generateApplicationAssessmentReportCallable()");
  }

  public OperationCallable<
          GenerateApplicationTemplateAssessmentReportRequest,
          GenerateApplicationTemplateAssessmentReportResponse,
          OperationMetadata>
      generateApplicationTemplateAssessmentReportOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: generateApplicationTemplateAssessmentReportOperationCallable()");
  }

  public UnaryCallable<GenerateApplicationTemplateAssessmentReportRequest, Operation>
      generateApplicationTemplateAssessmentReportCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: generateApplicationTemplateAssessmentReportCallable()");
  }

  @Deprecated
  public OperationCallable<
          GenerateAssessmentReportRequest, GenerateAssessmentReportResponse, OperationMetadata>
      generateAssessmentReportOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: generateAssessmentReportOperationCallable()");
  }

  @Deprecated
  public UnaryCallable<GenerateAssessmentReportRequest, Operation>
      generateAssessmentReportCallable() {
    throw new UnsupportedOperationException("Not implemented: generateAssessmentReportCallable()");
  }

  public OperationCallable<
          GenerateTerraformPlanAssessmentReportRequest,
          GenerateTerraformPlanAssessmentReportResponse,
          OperationMetadata>
      generateTerraformPlanAssessmentReportOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: generateTerraformPlanAssessmentReportOperationCallable()");
  }

  public UnaryCallable<GenerateTerraformPlanAssessmentReportRequest, Operation>
      generateTerraformPlanAssessmentReportCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: generateTerraformPlanAssessmentReportCallable()");
  }

  public UnaryCallable<GetPolicyRequest, Policy> getPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getPolicyCallable()");
  }

  public UnaryCallable<ListPoliciesRequest, ListPoliciesPagedResponse> listPoliciesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPoliciesPagedCallable()");
  }

  public UnaryCallable<ListPoliciesRequest, ListPoliciesResponse> listPoliciesCallable() {
    throw new UnsupportedOperationException("Not implemented: listPoliciesCallable()");
  }

  public UnaryCallable<CreatePolicyRequest, Policy> createPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: createPolicyCallable()");
  }

  public UnaryCallable<UpdatePolicyRequest, Policy> updatePolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: updatePolicyCallable()");
  }

  public UnaryCallable<DeletePolicyRequest, Empty> deletePolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: deletePolicyCallable()");
  }

  public UnaryCallable<FetchFrameworksRequest, FetchFrameworksPagedResponse>
      fetchFrameworksPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: fetchFrameworksPagedCallable()");
  }

  public UnaryCallable<FetchFrameworksRequest, FetchFrameworksResponse> fetchFrameworksCallable() {
    throw new UnsupportedOperationException("Not implemented: fetchFrameworksCallable()");
  }

  public UnaryCallable<GenerateApplicationIaCRequest, GenerateApplicationIaCResponse>
      generateApplicationIaCCallable() {
    throw new UnsupportedOperationException("Not implemented: generateApplicationIaCCallable()");
  }

  public OperationCallable<
          ExportApplicationIaCRequest, ExportApplicationIaCResponse, OperationMetadata>
      exportApplicationIaCOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: exportApplicationIaCOperationCallable()");
  }

  public UnaryCallable<ExportApplicationIaCRequest, Operation> exportApplicationIaCCallable() {
    throw new UnsupportedOperationException("Not implemented: exportApplicationIaCCallable()");
  }

  public UnaryCallable<ImportApplicationTemplateIaCRequest, ImportApplicationTemplateIaCResponse>
      importApplicationTemplateIaCCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: importApplicationTemplateIaCCallable()");
  }

  public OperationCallable<
          IngestApplicationTemplateIaCRequest,
          IngestApplicationTemplateIaCResponse,
          OperationMetadata>
      ingestApplicationTemplateIaCOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: ingestApplicationTemplateIaCOperationCallable()");
  }

  public UnaryCallable<IngestApplicationTemplateIaCRequest, Operation>
      ingestApplicationTemplateIaCCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: ingestApplicationTemplateIaCCallable()");
  }

  public UnaryCallable<ImportApplicationIaCRequest, ImportApplicationIaCResponse>
      importApplicationIaCCallable() {
    throw new UnsupportedOperationException("Not implemented: importApplicationIaCCallable()");
  }

  public OperationCallable<
          RegisterAppHubApplicationResourcesRequest,
          RegisterAppHubApplicationResourcesResponse,
          OperationMetadata>
      registerAppHubApplicationResourcesOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: registerAppHubApplicationResourcesOperationCallable()");
  }

  public UnaryCallable<RegisterAppHubApplicationResourcesRequest, Operation>
      registerAppHubApplicationResourcesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: registerAppHubApplicationResourcesCallable()");
  }

  public UnaryCallable<
          ListApplicationTemplateSystemRevisionsRequest,
          ListApplicationTemplateSystemRevisionsPagedResponse>
      listApplicationTemplateSystemRevisionsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listApplicationTemplateSystemRevisionsPagedCallable()");
  }

  public UnaryCallable<
          ListApplicationTemplateSystemRevisionsRequest,
          ListApplicationTemplateSystemRevisionsResponse>
      listApplicationTemplateSystemRevisionsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listApplicationTemplateSystemRevisionsCallable()");
  }

  public UnaryCallable<
          GetApplicationTemplateSystemRevisionRequest, ApplicationTemplateSystemRevision>
      getApplicationTemplateSystemRevisionCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getApplicationTemplateSystemRevisionCallable()");
  }

  public OperationCallable<RecommendIAMRolesRequest, RecommendIAMRolesResponse, OperationMetadata>
      recommendIAMRolesOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: recommendIAMRolesOperationCallable()");
  }

  public UnaryCallable<RecommendIAMRolesRequest, Operation> recommendIAMRolesCallable() {
    throw new UnsupportedOperationException("Not implemented: recommendIAMRolesCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsPagedCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsCallable()");
  }

  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    throw new UnsupportedOperationException("Not implemented: getLocationCallable()");
  }

  public UnaryCallable<SetIamPolicyRequest, com.google.iam.v1.Policy> setIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyCallable()");
  }

  public UnaryCallable<GetIamPolicyRequest, com.google.iam.v1.Policy> getIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyCallable()");
  }

  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsCallable()");
  }

  @Override
  public abstract void close();
}
