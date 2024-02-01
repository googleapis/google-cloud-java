/*
 * Copyright 2023 Google LLC
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

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
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
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the TelcoAutomation service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class TelcoAutomationStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<ListOrchestrationClustersRequest, ListOrchestrationClustersPagedResponse>
      listOrchestrationClustersPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listOrchestrationClustersPagedCallable()");
  }

  public UnaryCallable<ListOrchestrationClustersRequest, ListOrchestrationClustersResponse>
      listOrchestrationClustersCallable() {
    throw new UnsupportedOperationException("Not implemented: listOrchestrationClustersCallable()");
  }

  public UnaryCallable<GetOrchestrationClusterRequest, OrchestrationCluster>
      getOrchestrationClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: getOrchestrationClusterCallable()");
  }

  public OperationCallable<
          CreateOrchestrationClusterRequest, OrchestrationCluster, OperationMetadata>
      createOrchestrationClusterOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createOrchestrationClusterOperationCallable()");
  }

  public UnaryCallable<CreateOrchestrationClusterRequest, Operation>
      createOrchestrationClusterCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createOrchestrationClusterCallable()");
  }

  public OperationCallable<DeleteOrchestrationClusterRequest, Empty, OperationMetadata>
      deleteOrchestrationClusterOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteOrchestrationClusterOperationCallable()");
  }

  public UnaryCallable<DeleteOrchestrationClusterRequest, Operation>
      deleteOrchestrationClusterCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteOrchestrationClusterCallable()");
  }

  public UnaryCallable<ListEdgeSlmsRequest, ListEdgeSlmsPagedResponse> listEdgeSlmsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listEdgeSlmsPagedCallable()");
  }

  public UnaryCallable<ListEdgeSlmsRequest, ListEdgeSlmsResponse> listEdgeSlmsCallable() {
    throw new UnsupportedOperationException("Not implemented: listEdgeSlmsCallable()");
  }

  public UnaryCallable<GetEdgeSlmRequest, EdgeSlm> getEdgeSlmCallable() {
    throw new UnsupportedOperationException("Not implemented: getEdgeSlmCallable()");
  }

  public OperationCallable<CreateEdgeSlmRequest, EdgeSlm, OperationMetadata>
      createEdgeSlmOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createEdgeSlmOperationCallable()");
  }

  public UnaryCallable<CreateEdgeSlmRequest, Operation> createEdgeSlmCallable() {
    throw new UnsupportedOperationException("Not implemented: createEdgeSlmCallable()");
  }

  public OperationCallable<DeleteEdgeSlmRequest, Empty, OperationMetadata>
      deleteEdgeSlmOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteEdgeSlmOperationCallable()");
  }

  public UnaryCallable<DeleteEdgeSlmRequest, Operation> deleteEdgeSlmCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteEdgeSlmCallable()");
  }

  public UnaryCallable<CreateBlueprintRequest, Blueprint> createBlueprintCallable() {
    throw new UnsupportedOperationException("Not implemented: createBlueprintCallable()");
  }

  public UnaryCallable<UpdateBlueprintRequest, Blueprint> updateBlueprintCallable() {
    throw new UnsupportedOperationException("Not implemented: updateBlueprintCallable()");
  }

  public UnaryCallable<GetBlueprintRequest, Blueprint> getBlueprintCallable() {
    throw new UnsupportedOperationException("Not implemented: getBlueprintCallable()");
  }

  public UnaryCallable<DeleteBlueprintRequest, Empty> deleteBlueprintCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteBlueprintCallable()");
  }

  public UnaryCallable<ListBlueprintsRequest, ListBlueprintsPagedResponse>
      listBlueprintsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listBlueprintsPagedCallable()");
  }

  public UnaryCallable<ListBlueprintsRequest, ListBlueprintsResponse> listBlueprintsCallable() {
    throw new UnsupportedOperationException("Not implemented: listBlueprintsCallable()");
  }

  public UnaryCallable<ApproveBlueprintRequest, Blueprint> approveBlueprintCallable() {
    throw new UnsupportedOperationException("Not implemented: approveBlueprintCallable()");
  }

  public UnaryCallable<ProposeBlueprintRequest, Blueprint> proposeBlueprintCallable() {
    throw new UnsupportedOperationException("Not implemented: proposeBlueprintCallable()");
  }

  public UnaryCallable<RejectBlueprintRequest, Blueprint> rejectBlueprintCallable() {
    throw new UnsupportedOperationException("Not implemented: rejectBlueprintCallable()");
  }

  public UnaryCallable<ListBlueprintRevisionsRequest, ListBlueprintRevisionsPagedResponse>
      listBlueprintRevisionsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listBlueprintRevisionsPagedCallable()");
  }

  public UnaryCallable<ListBlueprintRevisionsRequest, ListBlueprintRevisionsResponse>
      listBlueprintRevisionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listBlueprintRevisionsCallable()");
  }

  public UnaryCallable<SearchBlueprintRevisionsRequest, SearchBlueprintRevisionsPagedResponse>
      searchBlueprintRevisionsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: searchBlueprintRevisionsPagedCallable()");
  }

  public UnaryCallable<SearchBlueprintRevisionsRequest, SearchBlueprintRevisionsResponse>
      searchBlueprintRevisionsCallable() {
    throw new UnsupportedOperationException("Not implemented: searchBlueprintRevisionsCallable()");
  }

  public UnaryCallable<SearchDeploymentRevisionsRequest, SearchDeploymentRevisionsPagedResponse>
      searchDeploymentRevisionsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: searchDeploymentRevisionsPagedCallable()");
  }

  public UnaryCallable<SearchDeploymentRevisionsRequest, SearchDeploymentRevisionsResponse>
      searchDeploymentRevisionsCallable() {
    throw new UnsupportedOperationException("Not implemented: searchDeploymentRevisionsCallable()");
  }

  public UnaryCallable<DiscardBlueprintChangesRequest, DiscardBlueprintChangesResponse>
      discardBlueprintChangesCallable() {
    throw new UnsupportedOperationException("Not implemented: discardBlueprintChangesCallable()");
  }

  public UnaryCallable<ListPublicBlueprintsRequest, ListPublicBlueprintsPagedResponse>
      listPublicBlueprintsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPublicBlueprintsPagedCallable()");
  }

  public UnaryCallable<ListPublicBlueprintsRequest, ListPublicBlueprintsResponse>
      listPublicBlueprintsCallable() {
    throw new UnsupportedOperationException("Not implemented: listPublicBlueprintsCallable()");
  }

  public UnaryCallable<GetPublicBlueprintRequest, PublicBlueprint> getPublicBlueprintCallable() {
    throw new UnsupportedOperationException("Not implemented: getPublicBlueprintCallable()");
  }

  public UnaryCallable<CreateDeploymentRequest, Deployment> createDeploymentCallable() {
    throw new UnsupportedOperationException("Not implemented: createDeploymentCallable()");
  }

  public UnaryCallable<UpdateDeploymentRequest, Deployment> updateDeploymentCallable() {
    throw new UnsupportedOperationException("Not implemented: updateDeploymentCallable()");
  }

  public UnaryCallable<GetDeploymentRequest, Deployment> getDeploymentCallable() {
    throw new UnsupportedOperationException("Not implemented: getDeploymentCallable()");
  }

  public UnaryCallable<RemoveDeploymentRequest, Empty> removeDeploymentCallable() {
    throw new UnsupportedOperationException("Not implemented: removeDeploymentCallable()");
  }

  public UnaryCallable<ListDeploymentsRequest, ListDeploymentsPagedResponse>
      listDeploymentsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listDeploymentsPagedCallable()");
  }

  public UnaryCallable<ListDeploymentsRequest, ListDeploymentsResponse> listDeploymentsCallable() {
    throw new UnsupportedOperationException("Not implemented: listDeploymentsCallable()");
  }

  public UnaryCallable<ListDeploymentRevisionsRequest, ListDeploymentRevisionsPagedResponse>
      listDeploymentRevisionsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listDeploymentRevisionsPagedCallable()");
  }

  public UnaryCallable<ListDeploymentRevisionsRequest, ListDeploymentRevisionsResponse>
      listDeploymentRevisionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listDeploymentRevisionsCallable()");
  }

  public UnaryCallable<DiscardDeploymentChangesRequest, DiscardDeploymentChangesResponse>
      discardDeploymentChangesCallable() {
    throw new UnsupportedOperationException("Not implemented: discardDeploymentChangesCallable()");
  }

  public UnaryCallable<ApplyDeploymentRequest, Deployment> applyDeploymentCallable() {
    throw new UnsupportedOperationException("Not implemented: applyDeploymentCallable()");
  }

  public UnaryCallable<ComputeDeploymentStatusRequest, ComputeDeploymentStatusResponse>
      computeDeploymentStatusCallable() {
    throw new UnsupportedOperationException("Not implemented: computeDeploymentStatusCallable()");
  }

  public UnaryCallable<RollbackDeploymentRequest, Deployment> rollbackDeploymentCallable() {
    throw new UnsupportedOperationException("Not implemented: rollbackDeploymentCallable()");
  }

  public UnaryCallable<GetHydratedDeploymentRequest, HydratedDeployment>
      getHydratedDeploymentCallable() {
    throw new UnsupportedOperationException("Not implemented: getHydratedDeploymentCallable()");
  }

  public UnaryCallable<ListHydratedDeploymentsRequest, ListHydratedDeploymentsPagedResponse>
      listHydratedDeploymentsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listHydratedDeploymentsPagedCallable()");
  }

  public UnaryCallable<ListHydratedDeploymentsRequest, ListHydratedDeploymentsResponse>
      listHydratedDeploymentsCallable() {
    throw new UnsupportedOperationException("Not implemented: listHydratedDeploymentsCallable()");
  }

  public UnaryCallable<UpdateHydratedDeploymentRequest, HydratedDeployment>
      updateHydratedDeploymentCallable() {
    throw new UnsupportedOperationException("Not implemented: updateHydratedDeploymentCallable()");
  }

  public UnaryCallable<ApplyHydratedDeploymentRequest, HydratedDeployment>
      applyHydratedDeploymentCallable() {
    throw new UnsupportedOperationException("Not implemented: applyHydratedDeploymentCallable()");
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

  @Override
  public abstract void close();
}
