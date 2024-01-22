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

package com.google.cloud.telcoautomation.v1.stub;

import static com.google.cloud.telcoautomation.v1.TelcoAutomationClient.ListBlueprintRevisionsPagedResponse;
import static com.google.cloud.telcoautomation.v1.TelcoAutomationClient.ListBlueprintsPagedResponse;
import static com.google.cloud.telcoautomation.v1.TelcoAutomationClient.ListDeploymentRevisionsPagedResponse;
import static com.google.cloud.telcoautomation.v1.TelcoAutomationClient.ListDeploymentsPagedResponse;
import static com.google.cloud.telcoautomation.v1.TelcoAutomationClient.ListEdgeSlmsPagedResponse;
import static com.google.cloud.telcoautomation.v1.TelcoAutomationClient.ListHydratedDeploymentsPagedResponse;
import static com.google.cloud.telcoautomation.v1.TelcoAutomationClient.ListLocationsPagedResponse;
import static com.google.cloud.telcoautomation.v1.TelcoAutomationClient.ListOrchestrationClustersPagedResponse;
import static com.google.cloud.telcoautomation.v1.TelcoAutomationClient.ListPublicBlueprintsPagedResponse;
import static com.google.cloud.telcoautomation.v1.TelcoAutomationClient.SearchBlueprintRevisionsPagedResponse;
import static com.google.cloud.telcoautomation.v1.TelcoAutomationClient.SearchDeploymentRevisionsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.telcoautomation.v1.ApplyDeploymentRequest;
import com.google.cloud.telcoautomation.v1.ApplyHydratedDeploymentRequest;
import com.google.cloud.telcoautomation.v1.ApproveBlueprintRequest;
import com.google.cloud.telcoautomation.v1.Blueprint;
import com.google.cloud.telcoautomation.v1.ComputeDeploymentStatusRequest;
import com.google.cloud.telcoautomation.v1.ComputeDeploymentStatusResponse;
import com.google.cloud.telcoautomation.v1.CreateBlueprintRequest;
import com.google.cloud.telcoautomation.v1.CreateDeploymentRequest;
import com.google.cloud.telcoautomation.v1.CreateEdgeSlmRequest;
import com.google.cloud.telcoautomation.v1.CreateOrchestrationClusterRequest;
import com.google.cloud.telcoautomation.v1.DeleteBlueprintRequest;
import com.google.cloud.telcoautomation.v1.DeleteEdgeSlmRequest;
import com.google.cloud.telcoautomation.v1.DeleteOrchestrationClusterRequest;
import com.google.cloud.telcoautomation.v1.Deployment;
import com.google.cloud.telcoautomation.v1.DiscardBlueprintChangesRequest;
import com.google.cloud.telcoautomation.v1.DiscardBlueprintChangesResponse;
import com.google.cloud.telcoautomation.v1.DiscardDeploymentChangesRequest;
import com.google.cloud.telcoautomation.v1.DiscardDeploymentChangesResponse;
import com.google.cloud.telcoautomation.v1.EdgeSlm;
import com.google.cloud.telcoautomation.v1.GetBlueprintRequest;
import com.google.cloud.telcoautomation.v1.GetDeploymentRequest;
import com.google.cloud.telcoautomation.v1.GetEdgeSlmRequest;
import com.google.cloud.telcoautomation.v1.GetHydratedDeploymentRequest;
import com.google.cloud.telcoautomation.v1.GetOrchestrationClusterRequest;
import com.google.cloud.telcoautomation.v1.GetPublicBlueprintRequest;
import com.google.cloud.telcoautomation.v1.HydratedDeployment;
import com.google.cloud.telcoautomation.v1.ListBlueprintRevisionsRequest;
import com.google.cloud.telcoautomation.v1.ListBlueprintRevisionsResponse;
import com.google.cloud.telcoautomation.v1.ListBlueprintsRequest;
import com.google.cloud.telcoautomation.v1.ListBlueprintsResponse;
import com.google.cloud.telcoautomation.v1.ListDeploymentRevisionsRequest;
import com.google.cloud.telcoautomation.v1.ListDeploymentRevisionsResponse;
import com.google.cloud.telcoautomation.v1.ListDeploymentsRequest;
import com.google.cloud.telcoautomation.v1.ListDeploymentsResponse;
import com.google.cloud.telcoautomation.v1.ListEdgeSlmsRequest;
import com.google.cloud.telcoautomation.v1.ListEdgeSlmsResponse;
import com.google.cloud.telcoautomation.v1.ListHydratedDeploymentsRequest;
import com.google.cloud.telcoautomation.v1.ListHydratedDeploymentsResponse;
import com.google.cloud.telcoautomation.v1.ListOrchestrationClustersRequest;
import com.google.cloud.telcoautomation.v1.ListOrchestrationClustersResponse;
import com.google.cloud.telcoautomation.v1.ListPublicBlueprintsRequest;
import com.google.cloud.telcoautomation.v1.ListPublicBlueprintsResponse;
import com.google.cloud.telcoautomation.v1.OperationMetadata;
import com.google.cloud.telcoautomation.v1.OrchestrationCluster;
import com.google.cloud.telcoautomation.v1.ProposeBlueprintRequest;
import com.google.cloud.telcoautomation.v1.PublicBlueprint;
import com.google.cloud.telcoautomation.v1.RejectBlueprintRequest;
import com.google.cloud.telcoautomation.v1.RemoveDeploymentRequest;
import com.google.cloud.telcoautomation.v1.RollbackDeploymentRequest;
import com.google.cloud.telcoautomation.v1.SearchBlueprintRevisionsRequest;
import com.google.cloud.telcoautomation.v1.SearchBlueprintRevisionsResponse;
import com.google.cloud.telcoautomation.v1.SearchDeploymentRevisionsRequest;
import com.google.cloud.telcoautomation.v1.SearchDeploymentRevisionsResponse;
import com.google.cloud.telcoautomation.v1.UpdateBlueprintRequest;
import com.google.cloud.telcoautomation.v1.UpdateDeploymentRequest;
import com.google.cloud.telcoautomation.v1.UpdateHydratedDeploymentRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the TelcoAutomation service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcTelcoAutomationStub extends TelcoAutomationStub {
  private static final MethodDescriptor<
          ListOrchestrationClustersRequest, ListOrchestrationClustersResponse>
      listOrchestrationClustersMethodDescriptor =
          MethodDescriptor
              .<ListOrchestrationClustersRequest, ListOrchestrationClustersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.telcoautomation.v1.TelcoAutomation/ListOrchestrationClusters")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListOrchestrationClustersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListOrchestrationClustersResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetOrchestrationClusterRequest, OrchestrationCluster>
      getOrchestrationClusterMethodDescriptor =
          MethodDescriptor.<GetOrchestrationClusterRequest, OrchestrationCluster>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.telcoautomation.v1.TelcoAutomation/GetOrchestrationCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetOrchestrationClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(OrchestrationCluster.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateOrchestrationClusterRequest, Operation>
      createOrchestrationClusterMethodDescriptor =
          MethodDescriptor.<CreateOrchestrationClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.telcoautomation.v1.TelcoAutomation/CreateOrchestrationCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateOrchestrationClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteOrchestrationClusterRequest, Operation>
      deleteOrchestrationClusterMethodDescriptor =
          MethodDescriptor.<DeleteOrchestrationClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.telcoautomation.v1.TelcoAutomation/DeleteOrchestrationCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteOrchestrationClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListEdgeSlmsRequest, ListEdgeSlmsResponse>
      listEdgeSlmsMethodDescriptor =
          MethodDescriptor.<ListEdgeSlmsRequest, ListEdgeSlmsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.telcoautomation.v1.TelcoAutomation/ListEdgeSlms")
              .setRequestMarshaller(ProtoUtils.marshaller(ListEdgeSlmsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListEdgeSlmsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetEdgeSlmRequest, EdgeSlm> getEdgeSlmMethodDescriptor =
      MethodDescriptor.<GetEdgeSlmRequest, EdgeSlm>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.telcoautomation.v1.TelcoAutomation/GetEdgeSlm")
          .setRequestMarshaller(ProtoUtils.marshaller(GetEdgeSlmRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(EdgeSlm.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateEdgeSlmRequest, Operation>
      createEdgeSlmMethodDescriptor =
          MethodDescriptor.<CreateEdgeSlmRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.telcoautomation.v1.TelcoAutomation/CreateEdgeSlm")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateEdgeSlmRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteEdgeSlmRequest, Operation>
      deleteEdgeSlmMethodDescriptor =
          MethodDescriptor.<DeleteEdgeSlmRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.telcoautomation.v1.TelcoAutomation/DeleteEdgeSlm")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteEdgeSlmRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateBlueprintRequest, Blueprint>
      createBlueprintMethodDescriptor =
          MethodDescriptor.<CreateBlueprintRequest, Blueprint>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.telcoautomation.v1.TelcoAutomation/CreateBlueprint")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateBlueprintRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Blueprint.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateBlueprintRequest, Blueprint>
      updateBlueprintMethodDescriptor =
          MethodDescriptor.<UpdateBlueprintRequest, Blueprint>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.telcoautomation.v1.TelcoAutomation/UpdateBlueprint")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateBlueprintRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Blueprint.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetBlueprintRequest, Blueprint>
      getBlueprintMethodDescriptor =
          MethodDescriptor.<GetBlueprintRequest, Blueprint>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.telcoautomation.v1.TelcoAutomation/GetBlueprint")
              .setRequestMarshaller(ProtoUtils.marshaller(GetBlueprintRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Blueprint.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteBlueprintRequest, Empty>
      deleteBlueprintMethodDescriptor =
          MethodDescriptor.<DeleteBlueprintRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.telcoautomation.v1.TelcoAutomation/DeleteBlueprint")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteBlueprintRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListBlueprintsRequest, ListBlueprintsResponse>
      listBlueprintsMethodDescriptor =
          MethodDescriptor.<ListBlueprintsRequest, ListBlueprintsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.telcoautomation.v1.TelcoAutomation/ListBlueprints")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListBlueprintsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListBlueprintsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ApproveBlueprintRequest, Blueprint>
      approveBlueprintMethodDescriptor =
          MethodDescriptor.<ApproveBlueprintRequest, Blueprint>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.telcoautomation.v1.TelcoAutomation/ApproveBlueprint")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ApproveBlueprintRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Blueprint.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ProposeBlueprintRequest, Blueprint>
      proposeBlueprintMethodDescriptor =
          MethodDescriptor.<ProposeBlueprintRequest, Blueprint>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.telcoautomation.v1.TelcoAutomation/ProposeBlueprint")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ProposeBlueprintRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Blueprint.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RejectBlueprintRequest, Blueprint>
      rejectBlueprintMethodDescriptor =
          MethodDescriptor.<RejectBlueprintRequest, Blueprint>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.telcoautomation.v1.TelcoAutomation/RejectBlueprint")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RejectBlueprintRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Blueprint.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListBlueprintRevisionsRequest, ListBlueprintRevisionsResponse>
      listBlueprintRevisionsMethodDescriptor =
          MethodDescriptor
              .<ListBlueprintRevisionsRequest, ListBlueprintRevisionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.telcoautomation.v1.TelcoAutomation/ListBlueprintRevisions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListBlueprintRevisionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListBlueprintRevisionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          SearchBlueprintRevisionsRequest, SearchBlueprintRevisionsResponse>
      searchBlueprintRevisionsMethodDescriptor =
          MethodDescriptor
              .<SearchBlueprintRevisionsRequest, SearchBlueprintRevisionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.telcoautomation.v1.TelcoAutomation/SearchBlueprintRevisions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SearchBlueprintRevisionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SearchBlueprintRevisionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          SearchDeploymentRevisionsRequest, SearchDeploymentRevisionsResponse>
      searchDeploymentRevisionsMethodDescriptor =
          MethodDescriptor
              .<SearchDeploymentRevisionsRequest, SearchDeploymentRevisionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.telcoautomation.v1.TelcoAutomation/SearchDeploymentRevisions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SearchDeploymentRevisionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SearchDeploymentRevisionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          DiscardBlueprintChangesRequest, DiscardBlueprintChangesResponse>
      discardBlueprintChangesMethodDescriptor =
          MethodDescriptor
              .<DiscardBlueprintChangesRequest, DiscardBlueprintChangesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.telcoautomation.v1.TelcoAutomation/DiscardBlueprintChanges")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DiscardBlueprintChangesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(DiscardBlueprintChangesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListPublicBlueprintsRequest, ListPublicBlueprintsResponse>
      listPublicBlueprintsMethodDescriptor =
          MethodDescriptor.<ListPublicBlueprintsRequest, ListPublicBlueprintsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.telcoautomation.v1.TelcoAutomation/ListPublicBlueprints")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListPublicBlueprintsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListPublicBlueprintsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetPublicBlueprintRequest, PublicBlueprint>
      getPublicBlueprintMethodDescriptor =
          MethodDescriptor.<GetPublicBlueprintRequest, PublicBlueprint>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.telcoautomation.v1.TelcoAutomation/GetPublicBlueprint")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetPublicBlueprintRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(PublicBlueprint.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateDeploymentRequest, Deployment>
      createDeploymentMethodDescriptor =
          MethodDescriptor.<CreateDeploymentRequest, Deployment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.telcoautomation.v1.TelcoAutomation/CreateDeployment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Deployment.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateDeploymentRequest, Deployment>
      updateDeploymentMethodDescriptor =
          MethodDescriptor.<UpdateDeploymentRequest, Deployment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.telcoautomation.v1.TelcoAutomation/UpdateDeployment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Deployment.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetDeploymentRequest, Deployment>
      getDeploymentMethodDescriptor =
          MethodDescriptor.<GetDeploymentRequest, Deployment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.telcoautomation.v1.TelcoAutomation/GetDeployment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Deployment.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RemoveDeploymentRequest, Empty>
      removeDeploymentMethodDescriptor =
          MethodDescriptor.<RemoveDeploymentRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.telcoautomation.v1.TelcoAutomation/RemoveDeployment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RemoveDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListDeploymentsRequest, ListDeploymentsResponse>
      listDeploymentsMethodDescriptor =
          MethodDescriptor.<ListDeploymentsRequest, ListDeploymentsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.telcoautomation.v1.TelcoAutomation/ListDeployments")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDeploymentsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDeploymentsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListDeploymentRevisionsRequest, ListDeploymentRevisionsResponse>
      listDeploymentRevisionsMethodDescriptor =
          MethodDescriptor
              .<ListDeploymentRevisionsRequest, ListDeploymentRevisionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.telcoautomation.v1.TelcoAutomation/ListDeploymentRevisions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDeploymentRevisionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDeploymentRevisionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          DiscardDeploymentChangesRequest, DiscardDeploymentChangesResponse>
      discardDeploymentChangesMethodDescriptor =
          MethodDescriptor
              .<DiscardDeploymentChangesRequest, DiscardDeploymentChangesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.telcoautomation.v1.TelcoAutomation/DiscardDeploymentChanges")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DiscardDeploymentChangesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(DiscardDeploymentChangesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ApplyDeploymentRequest, Deployment>
      applyDeploymentMethodDescriptor =
          MethodDescriptor.<ApplyDeploymentRequest, Deployment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.telcoautomation.v1.TelcoAutomation/ApplyDeployment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ApplyDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Deployment.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ComputeDeploymentStatusRequest, ComputeDeploymentStatusResponse>
      computeDeploymentStatusMethodDescriptor =
          MethodDescriptor
              .<ComputeDeploymentStatusRequest, ComputeDeploymentStatusResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.telcoautomation.v1.TelcoAutomation/ComputeDeploymentStatus")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ComputeDeploymentStatusRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ComputeDeploymentStatusResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RollbackDeploymentRequest, Deployment>
      rollbackDeploymentMethodDescriptor =
          MethodDescriptor.<RollbackDeploymentRequest, Deployment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.telcoautomation.v1.TelcoAutomation/RollbackDeployment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RollbackDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Deployment.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetHydratedDeploymentRequest, HydratedDeployment>
      getHydratedDeploymentMethodDescriptor =
          MethodDescriptor.<GetHydratedDeploymentRequest, HydratedDeployment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.telcoautomation.v1.TelcoAutomation/GetHydratedDeployment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetHydratedDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(HydratedDeployment.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListHydratedDeploymentsRequest, ListHydratedDeploymentsResponse>
      listHydratedDeploymentsMethodDescriptor =
          MethodDescriptor
              .<ListHydratedDeploymentsRequest, ListHydratedDeploymentsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.telcoautomation.v1.TelcoAutomation/ListHydratedDeployments")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListHydratedDeploymentsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListHydratedDeploymentsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateHydratedDeploymentRequest, HydratedDeployment>
      updateHydratedDeploymentMethodDescriptor =
          MethodDescriptor.<UpdateHydratedDeploymentRequest, HydratedDeployment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.telcoautomation.v1.TelcoAutomation/UpdateHydratedDeployment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateHydratedDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(HydratedDeployment.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ApplyHydratedDeploymentRequest, HydratedDeployment>
      applyHydratedDeploymentMethodDescriptor =
          MethodDescriptor.<ApplyHydratedDeploymentRequest, HydratedDeployment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.telcoautomation.v1.TelcoAutomation/ApplyHydratedDeployment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ApplyHydratedDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(HydratedDeployment.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          MethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListLocationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListLocationsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetLocationRequest, Location> getLocationMethodDescriptor =
      MethodDescriptor.<GetLocationRequest, Location>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.location.Locations/GetLocation")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLocationRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Location.getDefaultInstance()))
          .build();

  private final UnaryCallable<ListOrchestrationClustersRequest, ListOrchestrationClustersResponse>
      listOrchestrationClustersCallable;
  private final UnaryCallable<
          ListOrchestrationClustersRequest, ListOrchestrationClustersPagedResponse>
      listOrchestrationClustersPagedCallable;
  private final UnaryCallable<GetOrchestrationClusterRequest, OrchestrationCluster>
      getOrchestrationClusterCallable;
  private final UnaryCallable<CreateOrchestrationClusterRequest, Operation>
      createOrchestrationClusterCallable;
  private final OperationCallable<
          CreateOrchestrationClusterRequest, OrchestrationCluster, OperationMetadata>
      createOrchestrationClusterOperationCallable;
  private final UnaryCallable<DeleteOrchestrationClusterRequest, Operation>
      deleteOrchestrationClusterCallable;
  private final OperationCallable<DeleteOrchestrationClusterRequest, Empty, OperationMetadata>
      deleteOrchestrationClusterOperationCallable;
  private final UnaryCallable<ListEdgeSlmsRequest, ListEdgeSlmsResponse> listEdgeSlmsCallable;
  private final UnaryCallable<ListEdgeSlmsRequest, ListEdgeSlmsPagedResponse>
      listEdgeSlmsPagedCallable;
  private final UnaryCallable<GetEdgeSlmRequest, EdgeSlm> getEdgeSlmCallable;
  private final UnaryCallable<CreateEdgeSlmRequest, Operation> createEdgeSlmCallable;
  private final OperationCallable<CreateEdgeSlmRequest, EdgeSlm, OperationMetadata>
      createEdgeSlmOperationCallable;
  private final UnaryCallable<DeleteEdgeSlmRequest, Operation> deleteEdgeSlmCallable;
  private final OperationCallable<DeleteEdgeSlmRequest, Empty, OperationMetadata>
      deleteEdgeSlmOperationCallable;
  private final UnaryCallable<CreateBlueprintRequest, Blueprint> createBlueprintCallable;
  private final UnaryCallable<UpdateBlueprintRequest, Blueprint> updateBlueprintCallable;
  private final UnaryCallable<GetBlueprintRequest, Blueprint> getBlueprintCallable;
  private final UnaryCallable<DeleteBlueprintRequest, Empty> deleteBlueprintCallable;
  private final UnaryCallable<ListBlueprintsRequest, ListBlueprintsResponse> listBlueprintsCallable;
  private final UnaryCallable<ListBlueprintsRequest, ListBlueprintsPagedResponse>
      listBlueprintsPagedCallable;
  private final UnaryCallable<ApproveBlueprintRequest, Blueprint> approveBlueprintCallable;
  private final UnaryCallable<ProposeBlueprintRequest, Blueprint> proposeBlueprintCallable;
  private final UnaryCallable<RejectBlueprintRequest, Blueprint> rejectBlueprintCallable;
  private final UnaryCallable<ListBlueprintRevisionsRequest, ListBlueprintRevisionsResponse>
      listBlueprintRevisionsCallable;
  private final UnaryCallable<ListBlueprintRevisionsRequest, ListBlueprintRevisionsPagedResponse>
      listBlueprintRevisionsPagedCallable;
  private final UnaryCallable<SearchBlueprintRevisionsRequest, SearchBlueprintRevisionsResponse>
      searchBlueprintRevisionsCallable;
  private final UnaryCallable<
          SearchBlueprintRevisionsRequest, SearchBlueprintRevisionsPagedResponse>
      searchBlueprintRevisionsPagedCallable;
  private final UnaryCallable<SearchDeploymentRevisionsRequest, SearchDeploymentRevisionsResponse>
      searchDeploymentRevisionsCallable;
  private final UnaryCallable<
          SearchDeploymentRevisionsRequest, SearchDeploymentRevisionsPagedResponse>
      searchDeploymentRevisionsPagedCallable;
  private final UnaryCallable<DiscardBlueprintChangesRequest, DiscardBlueprintChangesResponse>
      discardBlueprintChangesCallable;
  private final UnaryCallable<ListPublicBlueprintsRequest, ListPublicBlueprintsResponse>
      listPublicBlueprintsCallable;
  private final UnaryCallable<ListPublicBlueprintsRequest, ListPublicBlueprintsPagedResponse>
      listPublicBlueprintsPagedCallable;
  private final UnaryCallable<GetPublicBlueprintRequest, PublicBlueprint>
      getPublicBlueprintCallable;
  private final UnaryCallable<CreateDeploymentRequest, Deployment> createDeploymentCallable;
  private final UnaryCallable<UpdateDeploymentRequest, Deployment> updateDeploymentCallable;
  private final UnaryCallable<GetDeploymentRequest, Deployment> getDeploymentCallable;
  private final UnaryCallable<RemoveDeploymentRequest, Empty> removeDeploymentCallable;
  private final UnaryCallable<ListDeploymentsRequest, ListDeploymentsResponse>
      listDeploymentsCallable;
  private final UnaryCallable<ListDeploymentsRequest, ListDeploymentsPagedResponse>
      listDeploymentsPagedCallable;
  private final UnaryCallable<ListDeploymentRevisionsRequest, ListDeploymentRevisionsResponse>
      listDeploymentRevisionsCallable;
  private final UnaryCallable<ListDeploymentRevisionsRequest, ListDeploymentRevisionsPagedResponse>
      listDeploymentRevisionsPagedCallable;
  private final UnaryCallable<DiscardDeploymentChangesRequest, DiscardDeploymentChangesResponse>
      discardDeploymentChangesCallable;
  private final UnaryCallable<ApplyDeploymentRequest, Deployment> applyDeploymentCallable;
  private final UnaryCallable<ComputeDeploymentStatusRequest, ComputeDeploymentStatusResponse>
      computeDeploymentStatusCallable;
  private final UnaryCallable<RollbackDeploymentRequest, Deployment> rollbackDeploymentCallable;
  private final UnaryCallable<GetHydratedDeploymentRequest, HydratedDeployment>
      getHydratedDeploymentCallable;
  private final UnaryCallable<ListHydratedDeploymentsRequest, ListHydratedDeploymentsResponse>
      listHydratedDeploymentsCallable;
  private final UnaryCallable<ListHydratedDeploymentsRequest, ListHydratedDeploymentsPagedResponse>
      listHydratedDeploymentsPagedCallable;
  private final UnaryCallable<UpdateHydratedDeploymentRequest, HydratedDeployment>
      updateHydratedDeploymentCallable;
  private final UnaryCallable<ApplyHydratedDeploymentRequest, HydratedDeployment>
      applyHydratedDeploymentCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcTelcoAutomationStub create(TelcoAutomationStubSettings settings)
      throws IOException {
    return new GrpcTelcoAutomationStub(settings, ClientContext.create(settings));
  }

  public static final GrpcTelcoAutomationStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcTelcoAutomationStub(
        TelcoAutomationStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcTelcoAutomationStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcTelcoAutomationStub(
        TelcoAutomationStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcTelcoAutomationStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcTelcoAutomationStub(
      TelcoAutomationStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcTelcoAutomationCallableFactory());
  }

  /**
   * Constructs an instance of GrpcTelcoAutomationStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcTelcoAutomationStub(
      TelcoAutomationStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListOrchestrationClustersRequest, ListOrchestrationClustersResponse>
        listOrchestrationClustersTransportSettings =
            GrpcCallSettings
                .<ListOrchestrationClustersRequest, ListOrchestrationClustersResponse>newBuilder()
                .setMethodDescriptor(listOrchestrationClustersMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetOrchestrationClusterRequest, OrchestrationCluster>
        getOrchestrationClusterTransportSettings =
            GrpcCallSettings.<GetOrchestrationClusterRequest, OrchestrationCluster>newBuilder()
                .setMethodDescriptor(getOrchestrationClusterMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateOrchestrationClusterRequest, Operation>
        createOrchestrationClusterTransportSettings =
            GrpcCallSettings.<CreateOrchestrationClusterRequest, Operation>newBuilder()
                .setMethodDescriptor(createOrchestrationClusterMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteOrchestrationClusterRequest, Operation>
        deleteOrchestrationClusterTransportSettings =
            GrpcCallSettings.<DeleteOrchestrationClusterRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteOrchestrationClusterMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListEdgeSlmsRequest, ListEdgeSlmsResponse> listEdgeSlmsTransportSettings =
        GrpcCallSettings.<ListEdgeSlmsRequest, ListEdgeSlmsResponse>newBuilder()
            .setMethodDescriptor(listEdgeSlmsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetEdgeSlmRequest, EdgeSlm> getEdgeSlmTransportSettings =
        GrpcCallSettings.<GetEdgeSlmRequest, EdgeSlm>newBuilder()
            .setMethodDescriptor(getEdgeSlmMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateEdgeSlmRequest, Operation> createEdgeSlmTransportSettings =
        GrpcCallSettings.<CreateEdgeSlmRequest, Operation>newBuilder()
            .setMethodDescriptor(createEdgeSlmMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteEdgeSlmRequest, Operation> deleteEdgeSlmTransportSettings =
        GrpcCallSettings.<DeleteEdgeSlmRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteEdgeSlmMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateBlueprintRequest, Blueprint> createBlueprintTransportSettings =
        GrpcCallSettings.<CreateBlueprintRequest, Blueprint>newBuilder()
            .setMethodDescriptor(createBlueprintMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateBlueprintRequest, Blueprint> updateBlueprintTransportSettings =
        GrpcCallSettings.<UpdateBlueprintRequest, Blueprint>newBuilder()
            .setMethodDescriptor(updateBlueprintMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("blueprint.name", String.valueOf(request.getBlueprint().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetBlueprintRequest, Blueprint> getBlueprintTransportSettings =
        GrpcCallSettings.<GetBlueprintRequest, Blueprint>newBuilder()
            .setMethodDescriptor(getBlueprintMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteBlueprintRequest, Empty> deleteBlueprintTransportSettings =
        GrpcCallSettings.<DeleteBlueprintRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteBlueprintMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListBlueprintsRequest, ListBlueprintsResponse>
        listBlueprintsTransportSettings =
            GrpcCallSettings.<ListBlueprintsRequest, ListBlueprintsResponse>newBuilder()
                .setMethodDescriptor(listBlueprintsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ApproveBlueprintRequest, Blueprint> approveBlueprintTransportSettings =
        GrpcCallSettings.<ApproveBlueprintRequest, Blueprint>newBuilder()
            .setMethodDescriptor(approveBlueprintMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ProposeBlueprintRequest, Blueprint> proposeBlueprintTransportSettings =
        GrpcCallSettings.<ProposeBlueprintRequest, Blueprint>newBuilder()
            .setMethodDescriptor(proposeBlueprintMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<RejectBlueprintRequest, Blueprint> rejectBlueprintTransportSettings =
        GrpcCallSettings.<RejectBlueprintRequest, Blueprint>newBuilder()
            .setMethodDescriptor(rejectBlueprintMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListBlueprintRevisionsRequest, ListBlueprintRevisionsResponse>
        listBlueprintRevisionsTransportSettings =
            GrpcCallSettings
                .<ListBlueprintRevisionsRequest, ListBlueprintRevisionsResponse>newBuilder()
                .setMethodDescriptor(listBlueprintRevisionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<SearchBlueprintRevisionsRequest, SearchBlueprintRevisionsResponse>
        searchBlueprintRevisionsTransportSettings =
            GrpcCallSettings
                .<SearchBlueprintRevisionsRequest, SearchBlueprintRevisionsResponse>newBuilder()
                .setMethodDescriptor(searchBlueprintRevisionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<SearchDeploymentRevisionsRequest, SearchDeploymentRevisionsResponse>
        searchDeploymentRevisionsTransportSettings =
            GrpcCallSettings
                .<SearchDeploymentRevisionsRequest, SearchDeploymentRevisionsResponse>newBuilder()
                .setMethodDescriptor(searchDeploymentRevisionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DiscardBlueprintChangesRequest, DiscardBlueprintChangesResponse>
        discardBlueprintChangesTransportSettings =
            GrpcCallSettings
                .<DiscardBlueprintChangesRequest, DiscardBlueprintChangesResponse>newBuilder()
                .setMethodDescriptor(discardBlueprintChangesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListPublicBlueprintsRequest, ListPublicBlueprintsResponse>
        listPublicBlueprintsTransportSettings =
            GrpcCallSettings.<ListPublicBlueprintsRequest, ListPublicBlueprintsResponse>newBuilder()
                .setMethodDescriptor(listPublicBlueprintsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetPublicBlueprintRequest, PublicBlueprint>
        getPublicBlueprintTransportSettings =
            GrpcCallSettings.<GetPublicBlueprintRequest, PublicBlueprint>newBuilder()
                .setMethodDescriptor(getPublicBlueprintMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateDeploymentRequest, Deployment> createDeploymentTransportSettings =
        GrpcCallSettings.<CreateDeploymentRequest, Deployment>newBuilder()
            .setMethodDescriptor(createDeploymentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateDeploymentRequest, Deployment> updateDeploymentTransportSettings =
        GrpcCallSettings.<UpdateDeploymentRequest, Deployment>newBuilder()
            .setMethodDescriptor(updateDeploymentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("deployment.name", String.valueOf(request.getDeployment().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetDeploymentRequest, Deployment> getDeploymentTransportSettings =
        GrpcCallSettings.<GetDeploymentRequest, Deployment>newBuilder()
            .setMethodDescriptor(getDeploymentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<RemoveDeploymentRequest, Empty> removeDeploymentTransportSettings =
        GrpcCallSettings.<RemoveDeploymentRequest, Empty>newBuilder()
            .setMethodDescriptor(removeDeploymentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListDeploymentsRequest, ListDeploymentsResponse>
        listDeploymentsTransportSettings =
            GrpcCallSettings.<ListDeploymentsRequest, ListDeploymentsResponse>newBuilder()
                .setMethodDescriptor(listDeploymentsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListDeploymentRevisionsRequest, ListDeploymentRevisionsResponse>
        listDeploymentRevisionsTransportSettings =
            GrpcCallSettings
                .<ListDeploymentRevisionsRequest, ListDeploymentRevisionsResponse>newBuilder()
                .setMethodDescriptor(listDeploymentRevisionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DiscardDeploymentChangesRequest, DiscardDeploymentChangesResponse>
        discardDeploymentChangesTransportSettings =
            GrpcCallSettings
                .<DiscardDeploymentChangesRequest, DiscardDeploymentChangesResponse>newBuilder()
                .setMethodDescriptor(discardDeploymentChangesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ApplyDeploymentRequest, Deployment> applyDeploymentTransportSettings =
        GrpcCallSettings.<ApplyDeploymentRequest, Deployment>newBuilder()
            .setMethodDescriptor(applyDeploymentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ComputeDeploymentStatusRequest, ComputeDeploymentStatusResponse>
        computeDeploymentStatusTransportSettings =
            GrpcCallSettings
                .<ComputeDeploymentStatusRequest, ComputeDeploymentStatusResponse>newBuilder()
                .setMethodDescriptor(computeDeploymentStatusMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<RollbackDeploymentRequest, Deployment> rollbackDeploymentTransportSettings =
        GrpcCallSettings.<RollbackDeploymentRequest, Deployment>newBuilder()
            .setMethodDescriptor(rollbackDeploymentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetHydratedDeploymentRequest, HydratedDeployment>
        getHydratedDeploymentTransportSettings =
            GrpcCallSettings.<GetHydratedDeploymentRequest, HydratedDeployment>newBuilder()
                .setMethodDescriptor(getHydratedDeploymentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListHydratedDeploymentsRequest, ListHydratedDeploymentsResponse>
        listHydratedDeploymentsTransportSettings =
            GrpcCallSettings
                .<ListHydratedDeploymentsRequest, ListHydratedDeploymentsResponse>newBuilder()
                .setMethodDescriptor(listHydratedDeploymentsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateHydratedDeploymentRequest, HydratedDeployment>
        updateHydratedDeploymentTransportSettings =
            GrpcCallSettings.<UpdateHydratedDeploymentRequest, HydratedDeployment>newBuilder()
                .setMethodDescriptor(updateHydratedDeploymentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "hydrated_deployment.name",
                          String.valueOf(request.getHydratedDeployment().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ApplyHydratedDeploymentRequest, HydratedDeployment>
        applyHydratedDeploymentTransportSettings =
            GrpcCallSettings.<ApplyHydratedDeploymentRequest, HydratedDeployment>newBuilder()
                .setMethodDescriptor(applyHydratedDeploymentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListLocationsRequest, ListLocationsResponse> listLocationsTransportSettings =
        GrpcCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
            .setMethodDescriptor(listLocationsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        GrpcCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.listOrchestrationClustersCallable =
        callableFactory.createUnaryCallable(
            listOrchestrationClustersTransportSettings,
            settings.listOrchestrationClustersSettings(),
            clientContext);
    this.listOrchestrationClustersPagedCallable =
        callableFactory.createPagedCallable(
            listOrchestrationClustersTransportSettings,
            settings.listOrchestrationClustersSettings(),
            clientContext);
    this.getOrchestrationClusterCallable =
        callableFactory.createUnaryCallable(
            getOrchestrationClusterTransportSettings,
            settings.getOrchestrationClusterSettings(),
            clientContext);
    this.createOrchestrationClusterCallable =
        callableFactory.createUnaryCallable(
            createOrchestrationClusterTransportSettings,
            settings.createOrchestrationClusterSettings(),
            clientContext);
    this.createOrchestrationClusterOperationCallable =
        callableFactory.createOperationCallable(
            createOrchestrationClusterTransportSettings,
            settings.createOrchestrationClusterOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteOrchestrationClusterCallable =
        callableFactory.createUnaryCallable(
            deleteOrchestrationClusterTransportSettings,
            settings.deleteOrchestrationClusterSettings(),
            clientContext);
    this.deleteOrchestrationClusterOperationCallable =
        callableFactory.createOperationCallable(
            deleteOrchestrationClusterTransportSettings,
            settings.deleteOrchestrationClusterOperationSettings(),
            clientContext,
            operationsStub);
    this.listEdgeSlmsCallable =
        callableFactory.createUnaryCallable(
            listEdgeSlmsTransportSettings, settings.listEdgeSlmsSettings(), clientContext);
    this.listEdgeSlmsPagedCallable =
        callableFactory.createPagedCallable(
            listEdgeSlmsTransportSettings, settings.listEdgeSlmsSettings(), clientContext);
    this.getEdgeSlmCallable =
        callableFactory.createUnaryCallable(
            getEdgeSlmTransportSettings, settings.getEdgeSlmSettings(), clientContext);
    this.createEdgeSlmCallable =
        callableFactory.createUnaryCallable(
            createEdgeSlmTransportSettings, settings.createEdgeSlmSettings(), clientContext);
    this.createEdgeSlmOperationCallable =
        callableFactory.createOperationCallable(
            createEdgeSlmTransportSettings,
            settings.createEdgeSlmOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteEdgeSlmCallable =
        callableFactory.createUnaryCallable(
            deleteEdgeSlmTransportSettings, settings.deleteEdgeSlmSettings(), clientContext);
    this.deleteEdgeSlmOperationCallable =
        callableFactory.createOperationCallable(
            deleteEdgeSlmTransportSettings,
            settings.deleteEdgeSlmOperationSettings(),
            clientContext,
            operationsStub);
    this.createBlueprintCallable =
        callableFactory.createUnaryCallable(
            createBlueprintTransportSettings, settings.createBlueprintSettings(), clientContext);
    this.updateBlueprintCallable =
        callableFactory.createUnaryCallable(
            updateBlueprintTransportSettings, settings.updateBlueprintSettings(), clientContext);
    this.getBlueprintCallable =
        callableFactory.createUnaryCallable(
            getBlueprintTransportSettings, settings.getBlueprintSettings(), clientContext);
    this.deleteBlueprintCallable =
        callableFactory.createUnaryCallable(
            deleteBlueprintTransportSettings, settings.deleteBlueprintSettings(), clientContext);
    this.listBlueprintsCallable =
        callableFactory.createUnaryCallable(
            listBlueprintsTransportSettings, settings.listBlueprintsSettings(), clientContext);
    this.listBlueprintsPagedCallable =
        callableFactory.createPagedCallable(
            listBlueprintsTransportSettings, settings.listBlueprintsSettings(), clientContext);
    this.approveBlueprintCallable =
        callableFactory.createUnaryCallable(
            approveBlueprintTransportSettings, settings.approveBlueprintSettings(), clientContext);
    this.proposeBlueprintCallable =
        callableFactory.createUnaryCallable(
            proposeBlueprintTransportSettings, settings.proposeBlueprintSettings(), clientContext);
    this.rejectBlueprintCallable =
        callableFactory.createUnaryCallable(
            rejectBlueprintTransportSettings, settings.rejectBlueprintSettings(), clientContext);
    this.listBlueprintRevisionsCallable =
        callableFactory.createUnaryCallable(
            listBlueprintRevisionsTransportSettings,
            settings.listBlueprintRevisionsSettings(),
            clientContext);
    this.listBlueprintRevisionsPagedCallable =
        callableFactory.createPagedCallable(
            listBlueprintRevisionsTransportSettings,
            settings.listBlueprintRevisionsSettings(),
            clientContext);
    this.searchBlueprintRevisionsCallable =
        callableFactory.createUnaryCallable(
            searchBlueprintRevisionsTransportSettings,
            settings.searchBlueprintRevisionsSettings(),
            clientContext);
    this.searchBlueprintRevisionsPagedCallable =
        callableFactory.createPagedCallable(
            searchBlueprintRevisionsTransportSettings,
            settings.searchBlueprintRevisionsSettings(),
            clientContext);
    this.searchDeploymentRevisionsCallable =
        callableFactory.createUnaryCallable(
            searchDeploymentRevisionsTransportSettings,
            settings.searchDeploymentRevisionsSettings(),
            clientContext);
    this.searchDeploymentRevisionsPagedCallable =
        callableFactory.createPagedCallable(
            searchDeploymentRevisionsTransportSettings,
            settings.searchDeploymentRevisionsSettings(),
            clientContext);
    this.discardBlueprintChangesCallable =
        callableFactory.createUnaryCallable(
            discardBlueprintChangesTransportSettings,
            settings.discardBlueprintChangesSettings(),
            clientContext);
    this.listPublicBlueprintsCallable =
        callableFactory.createUnaryCallable(
            listPublicBlueprintsTransportSettings,
            settings.listPublicBlueprintsSettings(),
            clientContext);
    this.listPublicBlueprintsPagedCallable =
        callableFactory.createPagedCallable(
            listPublicBlueprintsTransportSettings,
            settings.listPublicBlueprintsSettings(),
            clientContext);
    this.getPublicBlueprintCallable =
        callableFactory.createUnaryCallable(
            getPublicBlueprintTransportSettings,
            settings.getPublicBlueprintSettings(),
            clientContext);
    this.createDeploymentCallable =
        callableFactory.createUnaryCallable(
            createDeploymentTransportSettings, settings.createDeploymentSettings(), clientContext);
    this.updateDeploymentCallable =
        callableFactory.createUnaryCallable(
            updateDeploymentTransportSettings, settings.updateDeploymentSettings(), clientContext);
    this.getDeploymentCallable =
        callableFactory.createUnaryCallable(
            getDeploymentTransportSettings, settings.getDeploymentSettings(), clientContext);
    this.removeDeploymentCallable =
        callableFactory.createUnaryCallable(
            removeDeploymentTransportSettings, settings.removeDeploymentSettings(), clientContext);
    this.listDeploymentsCallable =
        callableFactory.createUnaryCallable(
            listDeploymentsTransportSettings, settings.listDeploymentsSettings(), clientContext);
    this.listDeploymentsPagedCallable =
        callableFactory.createPagedCallable(
            listDeploymentsTransportSettings, settings.listDeploymentsSettings(), clientContext);
    this.listDeploymentRevisionsCallable =
        callableFactory.createUnaryCallable(
            listDeploymentRevisionsTransportSettings,
            settings.listDeploymentRevisionsSettings(),
            clientContext);
    this.listDeploymentRevisionsPagedCallable =
        callableFactory.createPagedCallable(
            listDeploymentRevisionsTransportSettings,
            settings.listDeploymentRevisionsSettings(),
            clientContext);
    this.discardDeploymentChangesCallable =
        callableFactory.createUnaryCallable(
            discardDeploymentChangesTransportSettings,
            settings.discardDeploymentChangesSettings(),
            clientContext);
    this.applyDeploymentCallable =
        callableFactory.createUnaryCallable(
            applyDeploymentTransportSettings, settings.applyDeploymentSettings(), clientContext);
    this.computeDeploymentStatusCallable =
        callableFactory.createUnaryCallable(
            computeDeploymentStatusTransportSettings,
            settings.computeDeploymentStatusSettings(),
            clientContext);
    this.rollbackDeploymentCallable =
        callableFactory.createUnaryCallable(
            rollbackDeploymentTransportSettings,
            settings.rollbackDeploymentSettings(),
            clientContext);
    this.getHydratedDeploymentCallable =
        callableFactory.createUnaryCallable(
            getHydratedDeploymentTransportSettings,
            settings.getHydratedDeploymentSettings(),
            clientContext);
    this.listHydratedDeploymentsCallable =
        callableFactory.createUnaryCallable(
            listHydratedDeploymentsTransportSettings,
            settings.listHydratedDeploymentsSettings(),
            clientContext);
    this.listHydratedDeploymentsPagedCallable =
        callableFactory.createPagedCallable(
            listHydratedDeploymentsTransportSettings,
            settings.listHydratedDeploymentsSettings(),
            clientContext);
    this.updateHydratedDeploymentCallable =
        callableFactory.createUnaryCallable(
            updateHydratedDeploymentTransportSettings,
            settings.updateHydratedDeploymentSettings(),
            clientContext);
    this.applyHydratedDeploymentCallable =
        callableFactory.createUnaryCallable(
            applyHydratedDeploymentTransportSettings,
            settings.applyHydratedDeploymentSettings(),
            clientContext);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListOrchestrationClustersRequest, ListOrchestrationClustersResponse>
      listOrchestrationClustersCallable() {
    return listOrchestrationClustersCallable;
  }

  @Override
  public UnaryCallable<ListOrchestrationClustersRequest, ListOrchestrationClustersPagedResponse>
      listOrchestrationClustersPagedCallable() {
    return listOrchestrationClustersPagedCallable;
  }

  @Override
  public UnaryCallable<GetOrchestrationClusterRequest, OrchestrationCluster>
      getOrchestrationClusterCallable() {
    return getOrchestrationClusterCallable;
  }

  @Override
  public UnaryCallable<CreateOrchestrationClusterRequest, Operation>
      createOrchestrationClusterCallable() {
    return createOrchestrationClusterCallable;
  }

  @Override
  public OperationCallable<
          CreateOrchestrationClusterRequest, OrchestrationCluster, OperationMetadata>
      createOrchestrationClusterOperationCallable() {
    return createOrchestrationClusterOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteOrchestrationClusterRequest, Operation>
      deleteOrchestrationClusterCallable() {
    return deleteOrchestrationClusterCallable;
  }

  @Override
  public OperationCallable<DeleteOrchestrationClusterRequest, Empty, OperationMetadata>
      deleteOrchestrationClusterOperationCallable() {
    return deleteOrchestrationClusterOperationCallable;
  }

  @Override
  public UnaryCallable<ListEdgeSlmsRequest, ListEdgeSlmsResponse> listEdgeSlmsCallable() {
    return listEdgeSlmsCallable;
  }

  @Override
  public UnaryCallable<ListEdgeSlmsRequest, ListEdgeSlmsPagedResponse> listEdgeSlmsPagedCallable() {
    return listEdgeSlmsPagedCallable;
  }

  @Override
  public UnaryCallable<GetEdgeSlmRequest, EdgeSlm> getEdgeSlmCallable() {
    return getEdgeSlmCallable;
  }

  @Override
  public UnaryCallable<CreateEdgeSlmRequest, Operation> createEdgeSlmCallable() {
    return createEdgeSlmCallable;
  }

  @Override
  public OperationCallable<CreateEdgeSlmRequest, EdgeSlm, OperationMetadata>
      createEdgeSlmOperationCallable() {
    return createEdgeSlmOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteEdgeSlmRequest, Operation> deleteEdgeSlmCallable() {
    return deleteEdgeSlmCallable;
  }

  @Override
  public OperationCallable<DeleteEdgeSlmRequest, Empty, OperationMetadata>
      deleteEdgeSlmOperationCallable() {
    return deleteEdgeSlmOperationCallable;
  }

  @Override
  public UnaryCallable<CreateBlueprintRequest, Blueprint> createBlueprintCallable() {
    return createBlueprintCallable;
  }

  @Override
  public UnaryCallable<UpdateBlueprintRequest, Blueprint> updateBlueprintCallable() {
    return updateBlueprintCallable;
  }

  @Override
  public UnaryCallable<GetBlueprintRequest, Blueprint> getBlueprintCallable() {
    return getBlueprintCallable;
  }

  @Override
  public UnaryCallable<DeleteBlueprintRequest, Empty> deleteBlueprintCallable() {
    return deleteBlueprintCallable;
  }

  @Override
  public UnaryCallable<ListBlueprintsRequest, ListBlueprintsResponse> listBlueprintsCallable() {
    return listBlueprintsCallable;
  }

  @Override
  public UnaryCallable<ListBlueprintsRequest, ListBlueprintsPagedResponse>
      listBlueprintsPagedCallable() {
    return listBlueprintsPagedCallable;
  }

  @Override
  public UnaryCallable<ApproveBlueprintRequest, Blueprint> approveBlueprintCallable() {
    return approveBlueprintCallable;
  }

  @Override
  public UnaryCallable<ProposeBlueprintRequest, Blueprint> proposeBlueprintCallable() {
    return proposeBlueprintCallable;
  }

  @Override
  public UnaryCallable<RejectBlueprintRequest, Blueprint> rejectBlueprintCallable() {
    return rejectBlueprintCallable;
  }

  @Override
  public UnaryCallable<ListBlueprintRevisionsRequest, ListBlueprintRevisionsResponse>
      listBlueprintRevisionsCallable() {
    return listBlueprintRevisionsCallable;
  }

  @Override
  public UnaryCallable<ListBlueprintRevisionsRequest, ListBlueprintRevisionsPagedResponse>
      listBlueprintRevisionsPagedCallable() {
    return listBlueprintRevisionsPagedCallable;
  }

  @Override
  public UnaryCallable<SearchBlueprintRevisionsRequest, SearchBlueprintRevisionsResponse>
      searchBlueprintRevisionsCallable() {
    return searchBlueprintRevisionsCallable;
  }

  @Override
  public UnaryCallable<SearchBlueprintRevisionsRequest, SearchBlueprintRevisionsPagedResponse>
      searchBlueprintRevisionsPagedCallable() {
    return searchBlueprintRevisionsPagedCallable;
  }

  @Override
  public UnaryCallable<SearchDeploymentRevisionsRequest, SearchDeploymentRevisionsResponse>
      searchDeploymentRevisionsCallable() {
    return searchDeploymentRevisionsCallable;
  }

  @Override
  public UnaryCallable<SearchDeploymentRevisionsRequest, SearchDeploymentRevisionsPagedResponse>
      searchDeploymentRevisionsPagedCallable() {
    return searchDeploymentRevisionsPagedCallable;
  }

  @Override
  public UnaryCallable<DiscardBlueprintChangesRequest, DiscardBlueprintChangesResponse>
      discardBlueprintChangesCallable() {
    return discardBlueprintChangesCallable;
  }

  @Override
  public UnaryCallable<ListPublicBlueprintsRequest, ListPublicBlueprintsResponse>
      listPublicBlueprintsCallable() {
    return listPublicBlueprintsCallable;
  }

  @Override
  public UnaryCallable<ListPublicBlueprintsRequest, ListPublicBlueprintsPagedResponse>
      listPublicBlueprintsPagedCallable() {
    return listPublicBlueprintsPagedCallable;
  }

  @Override
  public UnaryCallable<GetPublicBlueprintRequest, PublicBlueprint> getPublicBlueprintCallable() {
    return getPublicBlueprintCallable;
  }

  @Override
  public UnaryCallable<CreateDeploymentRequest, Deployment> createDeploymentCallable() {
    return createDeploymentCallable;
  }

  @Override
  public UnaryCallable<UpdateDeploymentRequest, Deployment> updateDeploymentCallable() {
    return updateDeploymentCallable;
  }

  @Override
  public UnaryCallable<GetDeploymentRequest, Deployment> getDeploymentCallable() {
    return getDeploymentCallable;
  }

  @Override
  public UnaryCallable<RemoveDeploymentRequest, Empty> removeDeploymentCallable() {
    return removeDeploymentCallable;
  }

  @Override
  public UnaryCallable<ListDeploymentsRequest, ListDeploymentsResponse> listDeploymentsCallable() {
    return listDeploymentsCallable;
  }

  @Override
  public UnaryCallable<ListDeploymentsRequest, ListDeploymentsPagedResponse>
      listDeploymentsPagedCallable() {
    return listDeploymentsPagedCallable;
  }

  @Override
  public UnaryCallable<ListDeploymentRevisionsRequest, ListDeploymentRevisionsResponse>
      listDeploymentRevisionsCallable() {
    return listDeploymentRevisionsCallable;
  }

  @Override
  public UnaryCallable<ListDeploymentRevisionsRequest, ListDeploymentRevisionsPagedResponse>
      listDeploymentRevisionsPagedCallable() {
    return listDeploymentRevisionsPagedCallable;
  }

  @Override
  public UnaryCallable<DiscardDeploymentChangesRequest, DiscardDeploymentChangesResponse>
      discardDeploymentChangesCallable() {
    return discardDeploymentChangesCallable;
  }

  @Override
  public UnaryCallable<ApplyDeploymentRequest, Deployment> applyDeploymentCallable() {
    return applyDeploymentCallable;
  }

  @Override
  public UnaryCallable<ComputeDeploymentStatusRequest, ComputeDeploymentStatusResponse>
      computeDeploymentStatusCallable() {
    return computeDeploymentStatusCallable;
  }

  @Override
  public UnaryCallable<RollbackDeploymentRequest, Deployment> rollbackDeploymentCallable() {
    return rollbackDeploymentCallable;
  }

  @Override
  public UnaryCallable<GetHydratedDeploymentRequest, HydratedDeployment>
      getHydratedDeploymentCallable() {
    return getHydratedDeploymentCallable;
  }

  @Override
  public UnaryCallable<ListHydratedDeploymentsRequest, ListHydratedDeploymentsResponse>
      listHydratedDeploymentsCallable() {
    return listHydratedDeploymentsCallable;
  }

  @Override
  public UnaryCallable<ListHydratedDeploymentsRequest, ListHydratedDeploymentsPagedResponse>
      listHydratedDeploymentsPagedCallable() {
    return listHydratedDeploymentsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateHydratedDeploymentRequest, HydratedDeployment>
      updateHydratedDeploymentCallable() {
    return updateHydratedDeploymentCallable;
  }

  @Override
  public UnaryCallable<ApplyHydratedDeploymentRequest, HydratedDeployment>
      applyHydratedDeploymentCallable() {
    return applyHydratedDeploymentCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return listLocationsCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return listLocationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return getLocationCallable;
  }

  @Override
  public final void close() {
    try {
      backgroundResources.close();
    } catch (RuntimeException e) {
      throw e;
    } catch (Exception e) {
      throw new IllegalStateException("Failed to close resource", e);
    }
  }

  @Override
  public void shutdown() {
    backgroundResources.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return backgroundResources.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return backgroundResources.isTerminated();
  }

  @Override
  public void shutdownNow() {
    backgroundResources.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return backgroundResources.awaitTermination(duration, unit);
  }
}
