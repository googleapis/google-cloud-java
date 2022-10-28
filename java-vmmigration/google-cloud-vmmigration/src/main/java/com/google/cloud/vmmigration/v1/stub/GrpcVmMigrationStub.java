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

package com.google.cloud.vmmigration.v1.stub;

import static com.google.cloud.vmmigration.v1.VmMigrationClient.ListCloneJobsPagedResponse;
import static com.google.cloud.vmmigration.v1.VmMigrationClient.ListCutoverJobsPagedResponse;
import static com.google.cloud.vmmigration.v1.VmMigrationClient.ListDatacenterConnectorsPagedResponse;
import static com.google.cloud.vmmigration.v1.VmMigrationClient.ListGroupsPagedResponse;
import static com.google.cloud.vmmigration.v1.VmMigrationClient.ListMigratingVmsPagedResponse;
import static com.google.cloud.vmmigration.v1.VmMigrationClient.ListSourcesPagedResponse;
import static com.google.cloud.vmmigration.v1.VmMigrationClient.ListTargetProjectsPagedResponse;
import static com.google.cloud.vmmigration.v1.VmMigrationClient.ListUtilizationReportsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.vmmigration.v1.AddGroupMigrationRequest;
import com.google.cloud.vmmigration.v1.AddGroupMigrationResponse;
import com.google.cloud.vmmigration.v1.CancelCloneJobRequest;
import com.google.cloud.vmmigration.v1.CancelCloneJobResponse;
import com.google.cloud.vmmigration.v1.CancelCutoverJobRequest;
import com.google.cloud.vmmigration.v1.CancelCutoverJobResponse;
import com.google.cloud.vmmigration.v1.CloneJob;
import com.google.cloud.vmmigration.v1.CreateCloneJobRequest;
import com.google.cloud.vmmigration.v1.CreateCutoverJobRequest;
import com.google.cloud.vmmigration.v1.CreateDatacenterConnectorRequest;
import com.google.cloud.vmmigration.v1.CreateGroupRequest;
import com.google.cloud.vmmigration.v1.CreateMigratingVmRequest;
import com.google.cloud.vmmigration.v1.CreateSourceRequest;
import com.google.cloud.vmmigration.v1.CreateTargetProjectRequest;
import com.google.cloud.vmmigration.v1.CreateUtilizationReportRequest;
import com.google.cloud.vmmigration.v1.CutoverJob;
import com.google.cloud.vmmigration.v1.DatacenterConnector;
import com.google.cloud.vmmigration.v1.DeleteDatacenterConnectorRequest;
import com.google.cloud.vmmigration.v1.DeleteGroupRequest;
import com.google.cloud.vmmigration.v1.DeleteMigratingVmRequest;
import com.google.cloud.vmmigration.v1.DeleteSourceRequest;
import com.google.cloud.vmmigration.v1.DeleteTargetProjectRequest;
import com.google.cloud.vmmigration.v1.DeleteUtilizationReportRequest;
import com.google.cloud.vmmigration.v1.FetchInventoryRequest;
import com.google.cloud.vmmigration.v1.FetchInventoryResponse;
import com.google.cloud.vmmigration.v1.FinalizeMigrationRequest;
import com.google.cloud.vmmigration.v1.FinalizeMigrationResponse;
import com.google.cloud.vmmigration.v1.GetCloneJobRequest;
import com.google.cloud.vmmigration.v1.GetCutoverJobRequest;
import com.google.cloud.vmmigration.v1.GetDatacenterConnectorRequest;
import com.google.cloud.vmmigration.v1.GetGroupRequest;
import com.google.cloud.vmmigration.v1.GetMigratingVmRequest;
import com.google.cloud.vmmigration.v1.GetSourceRequest;
import com.google.cloud.vmmigration.v1.GetTargetProjectRequest;
import com.google.cloud.vmmigration.v1.GetUtilizationReportRequest;
import com.google.cloud.vmmigration.v1.Group;
import com.google.cloud.vmmigration.v1.ListCloneJobsRequest;
import com.google.cloud.vmmigration.v1.ListCloneJobsResponse;
import com.google.cloud.vmmigration.v1.ListCutoverJobsRequest;
import com.google.cloud.vmmigration.v1.ListCutoverJobsResponse;
import com.google.cloud.vmmigration.v1.ListDatacenterConnectorsRequest;
import com.google.cloud.vmmigration.v1.ListDatacenterConnectorsResponse;
import com.google.cloud.vmmigration.v1.ListGroupsRequest;
import com.google.cloud.vmmigration.v1.ListGroupsResponse;
import com.google.cloud.vmmigration.v1.ListMigratingVmsRequest;
import com.google.cloud.vmmigration.v1.ListMigratingVmsResponse;
import com.google.cloud.vmmigration.v1.ListSourcesRequest;
import com.google.cloud.vmmigration.v1.ListSourcesResponse;
import com.google.cloud.vmmigration.v1.ListTargetProjectsRequest;
import com.google.cloud.vmmigration.v1.ListTargetProjectsResponse;
import com.google.cloud.vmmigration.v1.ListUtilizationReportsRequest;
import com.google.cloud.vmmigration.v1.ListUtilizationReportsResponse;
import com.google.cloud.vmmigration.v1.MigratingVm;
import com.google.cloud.vmmigration.v1.OperationMetadata;
import com.google.cloud.vmmigration.v1.PauseMigrationRequest;
import com.google.cloud.vmmigration.v1.PauseMigrationResponse;
import com.google.cloud.vmmigration.v1.RemoveGroupMigrationRequest;
import com.google.cloud.vmmigration.v1.RemoveGroupMigrationResponse;
import com.google.cloud.vmmigration.v1.ResumeMigrationRequest;
import com.google.cloud.vmmigration.v1.ResumeMigrationResponse;
import com.google.cloud.vmmigration.v1.Source;
import com.google.cloud.vmmigration.v1.StartMigrationRequest;
import com.google.cloud.vmmigration.v1.StartMigrationResponse;
import com.google.cloud.vmmigration.v1.TargetProject;
import com.google.cloud.vmmigration.v1.UpdateGroupRequest;
import com.google.cloud.vmmigration.v1.UpdateMigratingVmRequest;
import com.google.cloud.vmmigration.v1.UpdateSourceRequest;
import com.google.cloud.vmmigration.v1.UpdateTargetProjectRequest;
import com.google.cloud.vmmigration.v1.UpgradeApplianceRequest;
import com.google.cloud.vmmigration.v1.UpgradeApplianceResponse;
import com.google.cloud.vmmigration.v1.UtilizationReport;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the VmMigration service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcVmMigrationStub extends VmMigrationStub {
  private static final MethodDescriptor<ListSourcesRequest, ListSourcesResponse>
      listSourcesMethodDescriptor =
          MethodDescriptor.<ListSourcesRequest, ListSourcesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/ListSources")
              .setRequestMarshaller(ProtoUtils.marshaller(ListSourcesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListSourcesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetSourceRequest, Source> getSourceMethodDescriptor =
      MethodDescriptor.<GetSourceRequest, Source>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/GetSource")
          .setRequestMarshaller(ProtoUtils.marshaller(GetSourceRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Source.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateSourceRequest, Operation>
      createSourceMethodDescriptor =
          MethodDescriptor.<CreateSourceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/CreateSource")
              .setRequestMarshaller(ProtoUtils.marshaller(CreateSourceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateSourceRequest, Operation>
      updateSourceMethodDescriptor =
          MethodDescriptor.<UpdateSourceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/UpdateSource")
              .setRequestMarshaller(ProtoUtils.marshaller(UpdateSourceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteSourceRequest, Operation>
      deleteSourceMethodDescriptor =
          MethodDescriptor.<DeleteSourceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/DeleteSource")
              .setRequestMarshaller(ProtoUtils.marshaller(DeleteSourceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<FetchInventoryRequest, FetchInventoryResponse>
      fetchInventoryMethodDescriptor =
          MethodDescriptor.<FetchInventoryRequest, FetchInventoryResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/FetchInventory")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(FetchInventoryRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(FetchInventoryResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListUtilizationReportsRequest, ListUtilizationReportsResponse>
      listUtilizationReportsMethodDescriptor =
          MethodDescriptor
              .<ListUtilizationReportsRequest, ListUtilizationReportsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/ListUtilizationReports")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListUtilizationReportsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListUtilizationReportsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetUtilizationReportRequest, UtilizationReport>
      getUtilizationReportMethodDescriptor =
          MethodDescriptor.<GetUtilizationReportRequest, UtilizationReport>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/GetUtilizationReport")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetUtilizationReportRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(UtilizationReport.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateUtilizationReportRequest, Operation>
      createUtilizationReportMethodDescriptor =
          MethodDescriptor.<CreateUtilizationReportRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/CreateUtilizationReport")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateUtilizationReportRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteUtilizationReportRequest, Operation>
      deleteUtilizationReportMethodDescriptor =
          MethodDescriptor.<DeleteUtilizationReportRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/DeleteUtilizationReport")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteUtilizationReportRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListDatacenterConnectorsRequest, ListDatacenterConnectorsResponse>
      listDatacenterConnectorsMethodDescriptor =
          MethodDescriptor
              .<ListDatacenterConnectorsRequest, ListDatacenterConnectorsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/ListDatacenterConnectors")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDatacenterConnectorsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDatacenterConnectorsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetDatacenterConnectorRequest, DatacenterConnector>
      getDatacenterConnectorMethodDescriptor =
          MethodDescriptor.<GetDatacenterConnectorRequest, DatacenterConnector>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/GetDatacenterConnector")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetDatacenterConnectorRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(DatacenterConnector.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateDatacenterConnectorRequest, Operation>
      createDatacenterConnectorMethodDescriptor =
          MethodDescriptor.<CreateDatacenterConnectorRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.vmmigration.v1.VmMigration/CreateDatacenterConnector")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateDatacenterConnectorRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteDatacenterConnectorRequest, Operation>
      deleteDatacenterConnectorMethodDescriptor =
          MethodDescriptor.<DeleteDatacenterConnectorRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.vmmigration.v1.VmMigration/DeleteDatacenterConnector")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteDatacenterConnectorRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpgradeApplianceRequest, Operation>
      upgradeApplianceMethodDescriptor =
          MethodDescriptor.<UpgradeApplianceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/UpgradeAppliance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpgradeApplianceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateMigratingVmRequest, Operation>
      createMigratingVmMethodDescriptor =
          MethodDescriptor.<CreateMigratingVmRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/CreateMigratingVm")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateMigratingVmRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListMigratingVmsRequest, ListMigratingVmsResponse>
      listMigratingVmsMethodDescriptor =
          MethodDescriptor.<ListMigratingVmsRequest, ListMigratingVmsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/ListMigratingVms")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListMigratingVmsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListMigratingVmsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetMigratingVmRequest, MigratingVm>
      getMigratingVmMethodDescriptor =
          MethodDescriptor.<GetMigratingVmRequest, MigratingVm>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/GetMigratingVm")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetMigratingVmRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(MigratingVm.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateMigratingVmRequest, Operation>
      updateMigratingVmMethodDescriptor =
          MethodDescriptor.<UpdateMigratingVmRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/UpdateMigratingVm")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateMigratingVmRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteMigratingVmRequest, Operation>
      deleteMigratingVmMethodDescriptor =
          MethodDescriptor.<DeleteMigratingVmRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/DeleteMigratingVm")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteMigratingVmRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<StartMigrationRequest, Operation>
      startMigrationMethodDescriptor =
          MethodDescriptor.<StartMigrationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/StartMigration")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(StartMigrationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ResumeMigrationRequest, Operation>
      resumeMigrationMethodDescriptor =
          MethodDescriptor.<ResumeMigrationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/ResumeMigration")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ResumeMigrationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<PauseMigrationRequest, Operation>
      pauseMigrationMethodDescriptor =
          MethodDescriptor.<PauseMigrationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/PauseMigration")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(PauseMigrationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<FinalizeMigrationRequest, Operation>
      finalizeMigrationMethodDescriptor =
          MethodDescriptor.<FinalizeMigrationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/FinalizeMigration")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(FinalizeMigrationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateCloneJobRequest, Operation>
      createCloneJobMethodDescriptor =
          MethodDescriptor.<CreateCloneJobRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/CreateCloneJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateCloneJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CancelCloneJobRequest, Operation>
      cancelCloneJobMethodDescriptor =
          MethodDescriptor.<CancelCloneJobRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/CancelCloneJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CancelCloneJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListCloneJobsRequest, ListCloneJobsResponse>
      listCloneJobsMethodDescriptor =
          MethodDescriptor.<ListCloneJobsRequest, ListCloneJobsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/ListCloneJobs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListCloneJobsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListCloneJobsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetCloneJobRequest, CloneJob> getCloneJobMethodDescriptor =
      MethodDescriptor.<GetCloneJobRequest, CloneJob>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/GetCloneJob")
          .setRequestMarshaller(ProtoUtils.marshaller(GetCloneJobRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(CloneJob.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateCutoverJobRequest, Operation>
      createCutoverJobMethodDescriptor =
          MethodDescriptor.<CreateCutoverJobRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/CreateCutoverJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateCutoverJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CancelCutoverJobRequest, Operation>
      cancelCutoverJobMethodDescriptor =
          MethodDescriptor.<CancelCutoverJobRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/CancelCutoverJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CancelCutoverJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListCutoverJobsRequest, ListCutoverJobsResponse>
      listCutoverJobsMethodDescriptor =
          MethodDescriptor.<ListCutoverJobsRequest, ListCutoverJobsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/ListCutoverJobs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListCutoverJobsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListCutoverJobsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetCutoverJobRequest, CutoverJob>
      getCutoverJobMethodDescriptor =
          MethodDescriptor.<GetCutoverJobRequest, CutoverJob>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/GetCutoverJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetCutoverJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CutoverJob.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListGroupsRequest, ListGroupsResponse>
      listGroupsMethodDescriptor =
          MethodDescriptor.<ListGroupsRequest, ListGroupsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/ListGroups")
              .setRequestMarshaller(ProtoUtils.marshaller(ListGroupsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListGroupsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetGroupRequest, Group> getGroupMethodDescriptor =
      MethodDescriptor.<GetGroupRequest, Group>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/GetGroup")
          .setRequestMarshaller(ProtoUtils.marshaller(GetGroupRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Group.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateGroupRequest, Operation> createGroupMethodDescriptor =
      MethodDescriptor.<CreateGroupRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/CreateGroup")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateGroupRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateGroupRequest, Operation> updateGroupMethodDescriptor =
      MethodDescriptor.<UpdateGroupRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/UpdateGroup")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateGroupRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteGroupRequest, Operation> deleteGroupMethodDescriptor =
      MethodDescriptor.<DeleteGroupRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/DeleteGroup")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteGroupRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<AddGroupMigrationRequest, Operation>
      addGroupMigrationMethodDescriptor =
          MethodDescriptor.<AddGroupMigrationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/AddGroupMigration")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(AddGroupMigrationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RemoveGroupMigrationRequest, Operation>
      removeGroupMigrationMethodDescriptor =
          MethodDescriptor.<RemoveGroupMigrationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/RemoveGroupMigration")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RemoveGroupMigrationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListTargetProjectsRequest, ListTargetProjectsResponse>
      listTargetProjectsMethodDescriptor =
          MethodDescriptor.<ListTargetProjectsRequest, ListTargetProjectsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/ListTargetProjects")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListTargetProjectsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListTargetProjectsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetTargetProjectRequest, TargetProject>
      getTargetProjectMethodDescriptor =
          MethodDescriptor.<GetTargetProjectRequest, TargetProject>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/GetTargetProject")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetTargetProjectRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(TargetProject.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateTargetProjectRequest, Operation>
      createTargetProjectMethodDescriptor =
          MethodDescriptor.<CreateTargetProjectRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/CreateTargetProject")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateTargetProjectRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateTargetProjectRequest, Operation>
      updateTargetProjectMethodDescriptor =
          MethodDescriptor.<UpdateTargetProjectRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/UpdateTargetProject")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateTargetProjectRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteTargetProjectRequest, Operation>
      deleteTargetProjectMethodDescriptor =
          MethodDescriptor.<DeleteTargetProjectRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vmmigration.v1.VmMigration/DeleteTargetProject")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteTargetProjectRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListSourcesRequest, ListSourcesResponse> listSourcesCallable;
  private final UnaryCallable<ListSourcesRequest, ListSourcesPagedResponse>
      listSourcesPagedCallable;
  private final UnaryCallable<GetSourceRequest, Source> getSourceCallable;
  private final UnaryCallable<CreateSourceRequest, Operation> createSourceCallable;
  private final OperationCallable<CreateSourceRequest, Source, OperationMetadata>
      createSourceOperationCallable;
  private final UnaryCallable<UpdateSourceRequest, Operation> updateSourceCallable;
  private final OperationCallable<UpdateSourceRequest, Source, OperationMetadata>
      updateSourceOperationCallable;
  private final UnaryCallable<DeleteSourceRequest, Operation> deleteSourceCallable;
  private final OperationCallable<DeleteSourceRequest, Empty, OperationMetadata>
      deleteSourceOperationCallable;
  private final UnaryCallable<FetchInventoryRequest, FetchInventoryResponse> fetchInventoryCallable;
  private final UnaryCallable<ListUtilizationReportsRequest, ListUtilizationReportsResponse>
      listUtilizationReportsCallable;
  private final UnaryCallable<ListUtilizationReportsRequest, ListUtilizationReportsPagedResponse>
      listUtilizationReportsPagedCallable;
  private final UnaryCallable<GetUtilizationReportRequest, UtilizationReport>
      getUtilizationReportCallable;
  private final UnaryCallable<CreateUtilizationReportRequest, Operation>
      createUtilizationReportCallable;
  private final OperationCallable<
          CreateUtilizationReportRequest, UtilizationReport, OperationMetadata>
      createUtilizationReportOperationCallable;
  private final UnaryCallable<DeleteUtilizationReportRequest, Operation>
      deleteUtilizationReportCallable;
  private final OperationCallable<DeleteUtilizationReportRequest, Empty, OperationMetadata>
      deleteUtilizationReportOperationCallable;
  private final UnaryCallable<ListDatacenterConnectorsRequest, ListDatacenterConnectorsResponse>
      listDatacenterConnectorsCallable;
  private final UnaryCallable<
          ListDatacenterConnectorsRequest, ListDatacenterConnectorsPagedResponse>
      listDatacenterConnectorsPagedCallable;
  private final UnaryCallable<GetDatacenterConnectorRequest, DatacenterConnector>
      getDatacenterConnectorCallable;
  private final UnaryCallable<CreateDatacenterConnectorRequest, Operation>
      createDatacenterConnectorCallable;
  private final OperationCallable<
          CreateDatacenterConnectorRequest, DatacenterConnector, OperationMetadata>
      createDatacenterConnectorOperationCallable;
  private final UnaryCallable<DeleteDatacenterConnectorRequest, Operation>
      deleteDatacenterConnectorCallable;
  private final OperationCallable<DeleteDatacenterConnectorRequest, Empty, OperationMetadata>
      deleteDatacenterConnectorOperationCallable;
  private final UnaryCallable<UpgradeApplianceRequest, Operation> upgradeApplianceCallable;
  private final OperationCallable<
          UpgradeApplianceRequest, UpgradeApplianceResponse, OperationMetadata>
      upgradeApplianceOperationCallable;
  private final UnaryCallable<CreateMigratingVmRequest, Operation> createMigratingVmCallable;
  private final OperationCallable<CreateMigratingVmRequest, MigratingVm, OperationMetadata>
      createMigratingVmOperationCallable;
  private final UnaryCallable<ListMigratingVmsRequest, ListMigratingVmsResponse>
      listMigratingVmsCallable;
  private final UnaryCallable<ListMigratingVmsRequest, ListMigratingVmsPagedResponse>
      listMigratingVmsPagedCallable;
  private final UnaryCallable<GetMigratingVmRequest, MigratingVm> getMigratingVmCallable;
  private final UnaryCallable<UpdateMigratingVmRequest, Operation> updateMigratingVmCallable;
  private final OperationCallable<UpdateMigratingVmRequest, MigratingVm, OperationMetadata>
      updateMigratingVmOperationCallable;
  private final UnaryCallable<DeleteMigratingVmRequest, Operation> deleteMigratingVmCallable;
  private final OperationCallable<DeleteMigratingVmRequest, Empty, OperationMetadata>
      deleteMigratingVmOperationCallable;
  private final UnaryCallable<StartMigrationRequest, Operation> startMigrationCallable;
  private final OperationCallable<StartMigrationRequest, StartMigrationResponse, OperationMetadata>
      startMigrationOperationCallable;
  private final UnaryCallable<ResumeMigrationRequest, Operation> resumeMigrationCallable;
  private final OperationCallable<
          ResumeMigrationRequest, ResumeMigrationResponse, OperationMetadata>
      resumeMigrationOperationCallable;
  private final UnaryCallable<PauseMigrationRequest, Operation> pauseMigrationCallable;
  private final OperationCallable<PauseMigrationRequest, PauseMigrationResponse, OperationMetadata>
      pauseMigrationOperationCallable;
  private final UnaryCallable<FinalizeMigrationRequest, Operation> finalizeMigrationCallable;
  private final OperationCallable<
          FinalizeMigrationRequest, FinalizeMigrationResponse, OperationMetadata>
      finalizeMigrationOperationCallable;
  private final UnaryCallable<CreateCloneJobRequest, Operation> createCloneJobCallable;
  private final OperationCallable<CreateCloneJobRequest, CloneJob, OperationMetadata>
      createCloneJobOperationCallable;
  private final UnaryCallable<CancelCloneJobRequest, Operation> cancelCloneJobCallable;
  private final OperationCallable<CancelCloneJobRequest, CancelCloneJobResponse, OperationMetadata>
      cancelCloneJobOperationCallable;
  private final UnaryCallable<ListCloneJobsRequest, ListCloneJobsResponse> listCloneJobsCallable;
  private final UnaryCallable<ListCloneJobsRequest, ListCloneJobsPagedResponse>
      listCloneJobsPagedCallable;
  private final UnaryCallable<GetCloneJobRequest, CloneJob> getCloneJobCallable;
  private final UnaryCallable<CreateCutoverJobRequest, Operation> createCutoverJobCallable;
  private final OperationCallable<CreateCutoverJobRequest, CutoverJob, OperationMetadata>
      createCutoverJobOperationCallable;
  private final UnaryCallable<CancelCutoverJobRequest, Operation> cancelCutoverJobCallable;
  private final OperationCallable<
          CancelCutoverJobRequest, CancelCutoverJobResponse, OperationMetadata>
      cancelCutoverJobOperationCallable;
  private final UnaryCallable<ListCutoverJobsRequest, ListCutoverJobsResponse>
      listCutoverJobsCallable;
  private final UnaryCallable<ListCutoverJobsRequest, ListCutoverJobsPagedResponse>
      listCutoverJobsPagedCallable;
  private final UnaryCallable<GetCutoverJobRequest, CutoverJob> getCutoverJobCallable;
  private final UnaryCallable<ListGroupsRequest, ListGroupsResponse> listGroupsCallable;
  private final UnaryCallable<ListGroupsRequest, ListGroupsPagedResponse> listGroupsPagedCallable;
  private final UnaryCallable<GetGroupRequest, Group> getGroupCallable;
  private final UnaryCallable<CreateGroupRequest, Operation> createGroupCallable;
  private final OperationCallable<CreateGroupRequest, Group, OperationMetadata>
      createGroupOperationCallable;
  private final UnaryCallable<UpdateGroupRequest, Operation> updateGroupCallable;
  private final OperationCallable<UpdateGroupRequest, Group, OperationMetadata>
      updateGroupOperationCallable;
  private final UnaryCallable<DeleteGroupRequest, Operation> deleteGroupCallable;
  private final OperationCallable<DeleteGroupRequest, Empty, OperationMetadata>
      deleteGroupOperationCallable;
  private final UnaryCallable<AddGroupMigrationRequest, Operation> addGroupMigrationCallable;
  private final OperationCallable<
          AddGroupMigrationRequest, AddGroupMigrationResponse, OperationMetadata>
      addGroupMigrationOperationCallable;
  private final UnaryCallable<RemoveGroupMigrationRequest, Operation> removeGroupMigrationCallable;
  private final OperationCallable<
          RemoveGroupMigrationRequest, RemoveGroupMigrationResponse, OperationMetadata>
      removeGroupMigrationOperationCallable;
  private final UnaryCallable<ListTargetProjectsRequest, ListTargetProjectsResponse>
      listTargetProjectsCallable;
  private final UnaryCallable<ListTargetProjectsRequest, ListTargetProjectsPagedResponse>
      listTargetProjectsPagedCallable;
  private final UnaryCallable<GetTargetProjectRequest, TargetProject> getTargetProjectCallable;
  private final UnaryCallable<CreateTargetProjectRequest, Operation> createTargetProjectCallable;
  private final OperationCallable<CreateTargetProjectRequest, TargetProject, OperationMetadata>
      createTargetProjectOperationCallable;
  private final UnaryCallable<UpdateTargetProjectRequest, Operation> updateTargetProjectCallable;
  private final OperationCallable<UpdateTargetProjectRequest, TargetProject, OperationMetadata>
      updateTargetProjectOperationCallable;
  private final UnaryCallable<DeleteTargetProjectRequest, Operation> deleteTargetProjectCallable;
  private final OperationCallable<DeleteTargetProjectRequest, Empty, OperationMetadata>
      deleteTargetProjectOperationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcVmMigrationStub create(VmMigrationStubSettings settings)
      throws IOException {
    return new GrpcVmMigrationStub(settings, ClientContext.create(settings));
  }

  public static final GrpcVmMigrationStub create(ClientContext clientContext) throws IOException {
    return new GrpcVmMigrationStub(VmMigrationStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcVmMigrationStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcVmMigrationStub(
        VmMigrationStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcVmMigrationStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcVmMigrationStub(VmMigrationStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcVmMigrationCallableFactory());
  }

  /**
   * Constructs an instance of GrpcVmMigrationStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcVmMigrationStub(
      VmMigrationStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListSourcesRequest, ListSourcesResponse> listSourcesTransportSettings =
        GrpcCallSettings.<ListSourcesRequest, ListSourcesResponse>newBuilder()
            .setMethodDescriptor(listSourcesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetSourceRequest, Source> getSourceTransportSettings =
        GrpcCallSettings.<GetSourceRequest, Source>newBuilder()
            .setMethodDescriptor(getSourceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateSourceRequest, Operation> createSourceTransportSettings =
        GrpcCallSettings.<CreateSourceRequest, Operation>newBuilder()
            .setMethodDescriptor(createSourceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateSourceRequest, Operation> updateSourceTransportSettings =
        GrpcCallSettings.<UpdateSourceRequest, Operation>newBuilder()
            .setMethodDescriptor(updateSourceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("source.name", String.valueOf(request.getSource().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteSourceRequest, Operation> deleteSourceTransportSettings =
        GrpcCallSettings.<DeleteSourceRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteSourceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<FetchInventoryRequest, FetchInventoryResponse>
        fetchInventoryTransportSettings =
            GrpcCallSettings.<FetchInventoryRequest, FetchInventoryResponse>newBuilder()
                .setMethodDescriptor(fetchInventoryMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("source", String.valueOf(request.getSource()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListUtilizationReportsRequest, ListUtilizationReportsResponse>
        listUtilizationReportsTransportSettings =
            GrpcCallSettings
                .<ListUtilizationReportsRequest, ListUtilizationReportsResponse>newBuilder()
                .setMethodDescriptor(listUtilizationReportsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetUtilizationReportRequest, UtilizationReport>
        getUtilizationReportTransportSettings =
            GrpcCallSettings.<GetUtilizationReportRequest, UtilizationReport>newBuilder()
                .setMethodDescriptor(getUtilizationReportMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<CreateUtilizationReportRequest, Operation>
        createUtilizationReportTransportSettings =
            GrpcCallSettings.<CreateUtilizationReportRequest, Operation>newBuilder()
                .setMethodDescriptor(createUtilizationReportMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteUtilizationReportRequest, Operation>
        deleteUtilizationReportTransportSettings =
            GrpcCallSettings.<DeleteUtilizationReportRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteUtilizationReportMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListDatacenterConnectorsRequest, ListDatacenterConnectorsResponse>
        listDatacenterConnectorsTransportSettings =
            GrpcCallSettings
                .<ListDatacenterConnectorsRequest, ListDatacenterConnectorsResponse>newBuilder()
                .setMethodDescriptor(listDatacenterConnectorsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetDatacenterConnectorRequest, DatacenterConnector>
        getDatacenterConnectorTransportSettings =
            GrpcCallSettings.<GetDatacenterConnectorRequest, DatacenterConnector>newBuilder()
                .setMethodDescriptor(getDatacenterConnectorMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<CreateDatacenterConnectorRequest, Operation>
        createDatacenterConnectorTransportSettings =
            GrpcCallSettings.<CreateDatacenterConnectorRequest, Operation>newBuilder()
                .setMethodDescriptor(createDatacenterConnectorMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteDatacenterConnectorRequest, Operation>
        deleteDatacenterConnectorTransportSettings =
            GrpcCallSettings.<DeleteDatacenterConnectorRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteDatacenterConnectorMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UpgradeApplianceRequest, Operation> upgradeApplianceTransportSettings =
        GrpcCallSettings.<UpgradeApplianceRequest, Operation>newBuilder()
            .setMethodDescriptor(upgradeApplianceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put(
                      "datacenter_connector", String.valueOf(request.getDatacenterConnector()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateMigratingVmRequest, Operation> createMigratingVmTransportSettings =
        GrpcCallSettings.<CreateMigratingVmRequest, Operation>newBuilder()
            .setMethodDescriptor(createMigratingVmMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListMigratingVmsRequest, ListMigratingVmsResponse>
        listMigratingVmsTransportSettings =
            GrpcCallSettings.<ListMigratingVmsRequest, ListMigratingVmsResponse>newBuilder()
                .setMethodDescriptor(listMigratingVmsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetMigratingVmRequest, MigratingVm> getMigratingVmTransportSettings =
        GrpcCallSettings.<GetMigratingVmRequest, MigratingVm>newBuilder()
            .setMethodDescriptor(getMigratingVmMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateMigratingVmRequest, Operation> updateMigratingVmTransportSettings =
        GrpcCallSettings.<UpdateMigratingVmRequest, Operation>newBuilder()
            .setMethodDescriptor(updateMigratingVmMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put(
                      "migrating_vm.name", String.valueOf(request.getMigratingVm().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteMigratingVmRequest, Operation> deleteMigratingVmTransportSettings =
        GrpcCallSettings.<DeleteMigratingVmRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMigratingVmMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<StartMigrationRequest, Operation> startMigrationTransportSettings =
        GrpcCallSettings.<StartMigrationRequest, Operation>newBuilder()
            .setMethodDescriptor(startMigrationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("migrating_vm", String.valueOf(request.getMigratingVm()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ResumeMigrationRequest, Operation> resumeMigrationTransportSettings =
        GrpcCallSettings.<ResumeMigrationRequest, Operation>newBuilder()
            .setMethodDescriptor(resumeMigrationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("migrating_vm", String.valueOf(request.getMigratingVm()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<PauseMigrationRequest, Operation> pauseMigrationTransportSettings =
        GrpcCallSettings.<PauseMigrationRequest, Operation>newBuilder()
            .setMethodDescriptor(pauseMigrationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("migrating_vm", String.valueOf(request.getMigratingVm()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<FinalizeMigrationRequest, Operation> finalizeMigrationTransportSettings =
        GrpcCallSettings.<FinalizeMigrationRequest, Operation>newBuilder()
            .setMethodDescriptor(finalizeMigrationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("migrating_vm", String.valueOf(request.getMigratingVm()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateCloneJobRequest, Operation> createCloneJobTransportSettings =
        GrpcCallSettings.<CreateCloneJobRequest, Operation>newBuilder()
            .setMethodDescriptor(createCloneJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CancelCloneJobRequest, Operation> cancelCloneJobTransportSettings =
        GrpcCallSettings.<CancelCloneJobRequest, Operation>newBuilder()
            .setMethodDescriptor(cancelCloneJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListCloneJobsRequest, ListCloneJobsResponse> listCloneJobsTransportSettings =
        GrpcCallSettings.<ListCloneJobsRequest, ListCloneJobsResponse>newBuilder()
            .setMethodDescriptor(listCloneJobsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetCloneJobRequest, CloneJob> getCloneJobTransportSettings =
        GrpcCallSettings.<GetCloneJobRequest, CloneJob>newBuilder()
            .setMethodDescriptor(getCloneJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateCutoverJobRequest, Operation> createCutoverJobTransportSettings =
        GrpcCallSettings.<CreateCutoverJobRequest, Operation>newBuilder()
            .setMethodDescriptor(createCutoverJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CancelCutoverJobRequest, Operation> cancelCutoverJobTransportSettings =
        GrpcCallSettings.<CancelCutoverJobRequest, Operation>newBuilder()
            .setMethodDescriptor(cancelCutoverJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListCutoverJobsRequest, ListCutoverJobsResponse>
        listCutoverJobsTransportSettings =
            GrpcCallSettings.<ListCutoverJobsRequest, ListCutoverJobsResponse>newBuilder()
                .setMethodDescriptor(listCutoverJobsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetCutoverJobRequest, CutoverJob> getCutoverJobTransportSettings =
        GrpcCallSettings.<GetCutoverJobRequest, CutoverJob>newBuilder()
            .setMethodDescriptor(getCutoverJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListGroupsRequest, ListGroupsResponse> listGroupsTransportSettings =
        GrpcCallSettings.<ListGroupsRequest, ListGroupsResponse>newBuilder()
            .setMethodDescriptor(listGroupsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetGroupRequest, Group> getGroupTransportSettings =
        GrpcCallSettings.<GetGroupRequest, Group>newBuilder()
            .setMethodDescriptor(getGroupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateGroupRequest, Operation> createGroupTransportSettings =
        GrpcCallSettings.<CreateGroupRequest, Operation>newBuilder()
            .setMethodDescriptor(createGroupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateGroupRequest, Operation> updateGroupTransportSettings =
        GrpcCallSettings.<UpdateGroupRequest, Operation>newBuilder()
            .setMethodDescriptor(updateGroupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("group.name", String.valueOf(request.getGroup().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteGroupRequest, Operation> deleteGroupTransportSettings =
        GrpcCallSettings.<DeleteGroupRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteGroupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<AddGroupMigrationRequest, Operation> addGroupMigrationTransportSettings =
        GrpcCallSettings.<AddGroupMigrationRequest, Operation>newBuilder()
            .setMethodDescriptor(addGroupMigrationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("group", String.valueOf(request.getGroup()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<RemoveGroupMigrationRequest, Operation> removeGroupMigrationTransportSettings =
        GrpcCallSettings.<RemoveGroupMigrationRequest, Operation>newBuilder()
            .setMethodDescriptor(removeGroupMigrationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("group", String.valueOf(request.getGroup()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListTargetProjectsRequest, ListTargetProjectsResponse>
        listTargetProjectsTransportSettings =
            GrpcCallSettings.<ListTargetProjectsRequest, ListTargetProjectsResponse>newBuilder()
                .setMethodDescriptor(listTargetProjectsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetTargetProjectRequest, TargetProject> getTargetProjectTransportSettings =
        GrpcCallSettings.<GetTargetProjectRequest, TargetProject>newBuilder()
            .setMethodDescriptor(getTargetProjectMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateTargetProjectRequest, Operation> createTargetProjectTransportSettings =
        GrpcCallSettings.<CreateTargetProjectRequest, Operation>newBuilder()
            .setMethodDescriptor(createTargetProjectMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateTargetProjectRequest, Operation> updateTargetProjectTransportSettings =
        GrpcCallSettings.<UpdateTargetProjectRequest, Operation>newBuilder()
            .setMethodDescriptor(updateTargetProjectMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put(
                      "target_project.name", String.valueOf(request.getTargetProject().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteTargetProjectRequest, Operation> deleteTargetProjectTransportSettings =
        GrpcCallSettings.<DeleteTargetProjectRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteTargetProjectMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();

    this.listSourcesCallable =
        callableFactory.createUnaryCallable(
            listSourcesTransportSettings, settings.listSourcesSettings(), clientContext);
    this.listSourcesPagedCallable =
        callableFactory.createPagedCallable(
            listSourcesTransportSettings, settings.listSourcesSettings(), clientContext);
    this.getSourceCallable =
        callableFactory.createUnaryCallable(
            getSourceTransportSettings, settings.getSourceSettings(), clientContext);
    this.createSourceCallable =
        callableFactory.createUnaryCallable(
            createSourceTransportSettings, settings.createSourceSettings(), clientContext);
    this.createSourceOperationCallable =
        callableFactory.createOperationCallable(
            createSourceTransportSettings,
            settings.createSourceOperationSettings(),
            clientContext,
            operationsStub);
    this.updateSourceCallable =
        callableFactory.createUnaryCallable(
            updateSourceTransportSettings, settings.updateSourceSettings(), clientContext);
    this.updateSourceOperationCallable =
        callableFactory.createOperationCallable(
            updateSourceTransportSettings,
            settings.updateSourceOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteSourceCallable =
        callableFactory.createUnaryCallable(
            deleteSourceTransportSettings, settings.deleteSourceSettings(), clientContext);
    this.deleteSourceOperationCallable =
        callableFactory.createOperationCallable(
            deleteSourceTransportSettings,
            settings.deleteSourceOperationSettings(),
            clientContext,
            operationsStub);
    this.fetchInventoryCallable =
        callableFactory.createUnaryCallable(
            fetchInventoryTransportSettings, settings.fetchInventorySettings(), clientContext);
    this.listUtilizationReportsCallable =
        callableFactory.createUnaryCallable(
            listUtilizationReportsTransportSettings,
            settings.listUtilizationReportsSettings(),
            clientContext);
    this.listUtilizationReportsPagedCallable =
        callableFactory.createPagedCallable(
            listUtilizationReportsTransportSettings,
            settings.listUtilizationReportsSettings(),
            clientContext);
    this.getUtilizationReportCallable =
        callableFactory.createUnaryCallable(
            getUtilizationReportTransportSettings,
            settings.getUtilizationReportSettings(),
            clientContext);
    this.createUtilizationReportCallable =
        callableFactory.createUnaryCallable(
            createUtilizationReportTransportSettings,
            settings.createUtilizationReportSettings(),
            clientContext);
    this.createUtilizationReportOperationCallable =
        callableFactory.createOperationCallable(
            createUtilizationReportTransportSettings,
            settings.createUtilizationReportOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteUtilizationReportCallable =
        callableFactory.createUnaryCallable(
            deleteUtilizationReportTransportSettings,
            settings.deleteUtilizationReportSettings(),
            clientContext);
    this.deleteUtilizationReportOperationCallable =
        callableFactory.createOperationCallable(
            deleteUtilizationReportTransportSettings,
            settings.deleteUtilizationReportOperationSettings(),
            clientContext,
            operationsStub);
    this.listDatacenterConnectorsCallable =
        callableFactory.createUnaryCallable(
            listDatacenterConnectorsTransportSettings,
            settings.listDatacenterConnectorsSettings(),
            clientContext);
    this.listDatacenterConnectorsPagedCallable =
        callableFactory.createPagedCallable(
            listDatacenterConnectorsTransportSettings,
            settings.listDatacenterConnectorsSettings(),
            clientContext);
    this.getDatacenterConnectorCallable =
        callableFactory.createUnaryCallable(
            getDatacenterConnectorTransportSettings,
            settings.getDatacenterConnectorSettings(),
            clientContext);
    this.createDatacenterConnectorCallable =
        callableFactory.createUnaryCallable(
            createDatacenterConnectorTransportSettings,
            settings.createDatacenterConnectorSettings(),
            clientContext);
    this.createDatacenterConnectorOperationCallable =
        callableFactory.createOperationCallable(
            createDatacenterConnectorTransportSettings,
            settings.createDatacenterConnectorOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteDatacenterConnectorCallable =
        callableFactory.createUnaryCallable(
            deleteDatacenterConnectorTransportSettings,
            settings.deleteDatacenterConnectorSettings(),
            clientContext);
    this.deleteDatacenterConnectorOperationCallable =
        callableFactory.createOperationCallable(
            deleteDatacenterConnectorTransportSettings,
            settings.deleteDatacenterConnectorOperationSettings(),
            clientContext,
            operationsStub);
    this.upgradeApplianceCallable =
        callableFactory.createUnaryCallable(
            upgradeApplianceTransportSettings, settings.upgradeApplianceSettings(), clientContext);
    this.upgradeApplianceOperationCallable =
        callableFactory.createOperationCallable(
            upgradeApplianceTransportSettings,
            settings.upgradeApplianceOperationSettings(),
            clientContext,
            operationsStub);
    this.createMigratingVmCallable =
        callableFactory.createUnaryCallable(
            createMigratingVmTransportSettings,
            settings.createMigratingVmSettings(),
            clientContext);
    this.createMigratingVmOperationCallable =
        callableFactory.createOperationCallable(
            createMigratingVmTransportSettings,
            settings.createMigratingVmOperationSettings(),
            clientContext,
            operationsStub);
    this.listMigratingVmsCallable =
        callableFactory.createUnaryCallable(
            listMigratingVmsTransportSettings, settings.listMigratingVmsSettings(), clientContext);
    this.listMigratingVmsPagedCallable =
        callableFactory.createPagedCallable(
            listMigratingVmsTransportSettings, settings.listMigratingVmsSettings(), clientContext);
    this.getMigratingVmCallable =
        callableFactory.createUnaryCallable(
            getMigratingVmTransportSettings, settings.getMigratingVmSettings(), clientContext);
    this.updateMigratingVmCallable =
        callableFactory.createUnaryCallable(
            updateMigratingVmTransportSettings,
            settings.updateMigratingVmSettings(),
            clientContext);
    this.updateMigratingVmOperationCallable =
        callableFactory.createOperationCallable(
            updateMigratingVmTransportSettings,
            settings.updateMigratingVmOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteMigratingVmCallable =
        callableFactory.createUnaryCallable(
            deleteMigratingVmTransportSettings,
            settings.deleteMigratingVmSettings(),
            clientContext);
    this.deleteMigratingVmOperationCallable =
        callableFactory.createOperationCallable(
            deleteMigratingVmTransportSettings,
            settings.deleteMigratingVmOperationSettings(),
            clientContext,
            operationsStub);
    this.startMigrationCallable =
        callableFactory.createUnaryCallable(
            startMigrationTransportSettings, settings.startMigrationSettings(), clientContext);
    this.startMigrationOperationCallable =
        callableFactory.createOperationCallable(
            startMigrationTransportSettings,
            settings.startMigrationOperationSettings(),
            clientContext,
            operationsStub);
    this.resumeMigrationCallable =
        callableFactory.createUnaryCallable(
            resumeMigrationTransportSettings, settings.resumeMigrationSettings(), clientContext);
    this.resumeMigrationOperationCallable =
        callableFactory.createOperationCallable(
            resumeMigrationTransportSettings,
            settings.resumeMigrationOperationSettings(),
            clientContext,
            operationsStub);
    this.pauseMigrationCallable =
        callableFactory.createUnaryCallable(
            pauseMigrationTransportSettings, settings.pauseMigrationSettings(), clientContext);
    this.pauseMigrationOperationCallable =
        callableFactory.createOperationCallable(
            pauseMigrationTransportSettings,
            settings.pauseMigrationOperationSettings(),
            clientContext,
            operationsStub);
    this.finalizeMigrationCallable =
        callableFactory.createUnaryCallable(
            finalizeMigrationTransportSettings,
            settings.finalizeMigrationSettings(),
            clientContext);
    this.finalizeMigrationOperationCallable =
        callableFactory.createOperationCallable(
            finalizeMigrationTransportSettings,
            settings.finalizeMigrationOperationSettings(),
            clientContext,
            operationsStub);
    this.createCloneJobCallable =
        callableFactory.createUnaryCallable(
            createCloneJobTransportSettings, settings.createCloneJobSettings(), clientContext);
    this.createCloneJobOperationCallable =
        callableFactory.createOperationCallable(
            createCloneJobTransportSettings,
            settings.createCloneJobOperationSettings(),
            clientContext,
            operationsStub);
    this.cancelCloneJobCallable =
        callableFactory.createUnaryCallable(
            cancelCloneJobTransportSettings, settings.cancelCloneJobSettings(), clientContext);
    this.cancelCloneJobOperationCallable =
        callableFactory.createOperationCallable(
            cancelCloneJobTransportSettings,
            settings.cancelCloneJobOperationSettings(),
            clientContext,
            operationsStub);
    this.listCloneJobsCallable =
        callableFactory.createUnaryCallable(
            listCloneJobsTransportSettings, settings.listCloneJobsSettings(), clientContext);
    this.listCloneJobsPagedCallable =
        callableFactory.createPagedCallable(
            listCloneJobsTransportSettings, settings.listCloneJobsSettings(), clientContext);
    this.getCloneJobCallable =
        callableFactory.createUnaryCallable(
            getCloneJobTransportSettings, settings.getCloneJobSettings(), clientContext);
    this.createCutoverJobCallable =
        callableFactory.createUnaryCallable(
            createCutoverJobTransportSettings, settings.createCutoverJobSettings(), clientContext);
    this.createCutoverJobOperationCallable =
        callableFactory.createOperationCallable(
            createCutoverJobTransportSettings,
            settings.createCutoverJobOperationSettings(),
            clientContext,
            operationsStub);
    this.cancelCutoverJobCallable =
        callableFactory.createUnaryCallable(
            cancelCutoverJobTransportSettings, settings.cancelCutoverJobSettings(), clientContext);
    this.cancelCutoverJobOperationCallable =
        callableFactory.createOperationCallable(
            cancelCutoverJobTransportSettings,
            settings.cancelCutoverJobOperationSettings(),
            clientContext,
            operationsStub);
    this.listCutoverJobsCallable =
        callableFactory.createUnaryCallable(
            listCutoverJobsTransportSettings, settings.listCutoverJobsSettings(), clientContext);
    this.listCutoverJobsPagedCallable =
        callableFactory.createPagedCallable(
            listCutoverJobsTransportSettings, settings.listCutoverJobsSettings(), clientContext);
    this.getCutoverJobCallable =
        callableFactory.createUnaryCallable(
            getCutoverJobTransportSettings, settings.getCutoverJobSettings(), clientContext);
    this.listGroupsCallable =
        callableFactory.createUnaryCallable(
            listGroupsTransportSettings, settings.listGroupsSettings(), clientContext);
    this.listGroupsPagedCallable =
        callableFactory.createPagedCallable(
            listGroupsTransportSettings, settings.listGroupsSettings(), clientContext);
    this.getGroupCallable =
        callableFactory.createUnaryCallable(
            getGroupTransportSettings, settings.getGroupSettings(), clientContext);
    this.createGroupCallable =
        callableFactory.createUnaryCallable(
            createGroupTransportSettings, settings.createGroupSettings(), clientContext);
    this.createGroupOperationCallable =
        callableFactory.createOperationCallable(
            createGroupTransportSettings,
            settings.createGroupOperationSettings(),
            clientContext,
            operationsStub);
    this.updateGroupCallable =
        callableFactory.createUnaryCallable(
            updateGroupTransportSettings, settings.updateGroupSettings(), clientContext);
    this.updateGroupOperationCallable =
        callableFactory.createOperationCallable(
            updateGroupTransportSettings,
            settings.updateGroupOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteGroupCallable =
        callableFactory.createUnaryCallable(
            deleteGroupTransportSettings, settings.deleteGroupSettings(), clientContext);
    this.deleteGroupOperationCallable =
        callableFactory.createOperationCallable(
            deleteGroupTransportSettings,
            settings.deleteGroupOperationSettings(),
            clientContext,
            operationsStub);
    this.addGroupMigrationCallable =
        callableFactory.createUnaryCallable(
            addGroupMigrationTransportSettings,
            settings.addGroupMigrationSettings(),
            clientContext);
    this.addGroupMigrationOperationCallable =
        callableFactory.createOperationCallable(
            addGroupMigrationTransportSettings,
            settings.addGroupMigrationOperationSettings(),
            clientContext,
            operationsStub);
    this.removeGroupMigrationCallable =
        callableFactory.createUnaryCallable(
            removeGroupMigrationTransportSettings,
            settings.removeGroupMigrationSettings(),
            clientContext);
    this.removeGroupMigrationOperationCallable =
        callableFactory.createOperationCallable(
            removeGroupMigrationTransportSettings,
            settings.removeGroupMigrationOperationSettings(),
            clientContext,
            operationsStub);
    this.listTargetProjectsCallable =
        callableFactory.createUnaryCallable(
            listTargetProjectsTransportSettings,
            settings.listTargetProjectsSettings(),
            clientContext);
    this.listTargetProjectsPagedCallable =
        callableFactory.createPagedCallable(
            listTargetProjectsTransportSettings,
            settings.listTargetProjectsSettings(),
            clientContext);
    this.getTargetProjectCallable =
        callableFactory.createUnaryCallable(
            getTargetProjectTransportSettings, settings.getTargetProjectSettings(), clientContext);
    this.createTargetProjectCallable =
        callableFactory.createUnaryCallable(
            createTargetProjectTransportSettings,
            settings.createTargetProjectSettings(),
            clientContext);
    this.createTargetProjectOperationCallable =
        callableFactory.createOperationCallable(
            createTargetProjectTransportSettings,
            settings.createTargetProjectOperationSettings(),
            clientContext,
            operationsStub);
    this.updateTargetProjectCallable =
        callableFactory.createUnaryCallable(
            updateTargetProjectTransportSettings,
            settings.updateTargetProjectSettings(),
            clientContext);
    this.updateTargetProjectOperationCallable =
        callableFactory.createOperationCallable(
            updateTargetProjectTransportSettings,
            settings.updateTargetProjectOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteTargetProjectCallable =
        callableFactory.createUnaryCallable(
            deleteTargetProjectTransportSettings,
            settings.deleteTargetProjectSettings(),
            clientContext);
    this.deleteTargetProjectOperationCallable =
        callableFactory.createOperationCallable(
            deleteTargetProjectTransportSettings,
            settings.deleteTargetProjectOperationSettings(),
            clientContext,
            operationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListSourcesRequest, ListSourcesResponse> listSourcesCallable() {
    return listSourcesCallable;
  }

  @Override
  public UnaryCallable<ListSourcesRequest, ListSourcesPagedResponse> listSourcesPagedCallable() {
    return listSourcesPagedCallable;
  }

  @Override
  public UnaryCallable<GetSourceRequest, Source> getSourceCallable() {
    return getSourceCallable;
  }

  @Override
  public UnaryCallable<CreateSourceRequest, Operation> createSourceCallable() {
    return createSourceCallable;
  }

  @Override
  public OperationCallable<CreateSourceRequest, Source, OperationMetadata>
      createSourceOperationCallable() {
    return createSourceOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateSourceRequest, Operation> updateSourceCallable() {
    return updateSourceCallable;
  }

  @Override
  public OperationCallable<UpdateSourceRequest, Source, OperationMetadata>
      updateSourceOperationCallable() {
    return updateSourceOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteSourceRequest, Operation> deleteSourceCallable() {
    return deleteSourceCallable;
  }

  @Override
  public OperationCallable<DeleteSourceRequest, Empty, OperationMetadata>
      deleteSourceOperationCallable() {
    return deleteSourceOperationCallable;
  }

  @Override
  public UnaryCallable<FetchInventoryRequest, FetchInventoryResponse> fetchInventoryCallable() {
    return fetchInventoryCallable;
  }

  @Override
  public UnaryCallable<ListUtilizationReportsRequest, ListUtilizationReportsResponse>
      listUtilizationReportsCallable() {
    return listUtilizationReportsCallable;
  }

  @Override
  public UnaryCallable<ListUtilizationReportsRequest, ListUtilizationReportsPagedResponse>
      listUtilizationReportsPagedCallable() {
    return listUtilizationReportsPagedCallable;
  }

  @Override
  public UnaryCallable<GetUtilizationReportRequest, UtilizationReport>
      getUtilizationReportCallable() {
    return getUtilizationReportCallable;
  }

  @Override
  public UnaryCallable<CreateUtilizationReportRequest, Operation>
      createUtilizationReportCallable() {
    return createUtilizationReportCallable;
  }

  @Override
  public OperationCallable<CreateUtilizationReportRequest, UtilizationReport, OperationMetadata>
      createUtilizationReportOperationCallable() {
    return createUtilizationReportOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteUtilizationReportRequest, Operation>
      deleteUtilizationReportCallable() {
    return deleteUtilizationReportCallable;
  }

  @Override
  public OperationCallable<DeleteUtilizationReportRequest, Empty, OperationMetadata>
      deleteUtilizationReportOperationCallable() {
    return deleteUtilizationReportOperationCallable;
  }

  @Override
  public UnaryCallable<ListDatacenterConnectorsRequest, ListDatacenterConnectorsResponse>
      listDatacenterConnectorsCallable() {
    return listDatacenterConnectorsCallable;
  }

  @Override
  public UnaryCallable<ListDatacenterConnectorsRequest, ListDatacenterConnectorsPagedResponse>
      listDatacenterConnectorsPagedCallable() {
    return listDatacenterConnectorsPagedCallable;
  }

  @Override
  public UnaryCallable<GetDatacenterConnectorRequest, DatacenterConnector>
      getDatacenterConnectorCallable() {
    return getDatacenterConnectorCallable;
  }

  @Override
  public UnaryCallable<CreateDatacenterConnectorRequest, Operation>
      createDatacenterConnectorCallable() {
    return createDatacenterConnectorCallable;
  }

  @Override
  public OperationCallable<CreateDatacenterConnectorRequest, DatacenterConnector, OperationMetadata>
      createDatacenterConnectorOperationCallable() {
    return createDatacenterConnectorOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteDatacenterConnectorRequest, Operation>
      deleteDatacenterConnectorCallable() {
    return deleteDatacenterConnectorCallable;
  }

  @Override
  public OperationCallable<DeleteDatacenterConnectorRequest, Empty, OperationMetadata>
      deleteDatacenterConnectorOperationCallable() {
    return deleteDatacenterConnectorOperationCallable;
  }

  @Override
  public UnaryCallable<UpgradeApplianceRequest, Operation> upgradeApplianceCallable() {
    return upgradeApplianceCallable;
  }

  @Override
  public OperationCallable<UpgradeApplianceRequest, UpgradeApplianceResponse, OperationMetadata>
      upgradeApplianceOperationCallable() {
    return upgradeApplianceOperationCallable;
  }

  @Override
  public UnaryCallable<CreateMigratingVmRequest, Operation> createMigratingVmCallable() {
    return createMigratingVmCallable;
  }

  @Override
  public OperationCallable<CreateMigratingVmRequest, MigratingVm, OperationMetadata>
      createMigratingVmOperationCallable() {
    return createMigratingVmOperationCallable;
  }

  @Override
  public UnaryCallable<ListMigratingVmsRequest, ListMigratingVmsResponse>
      listMigratingVmsCallable() {
    return listMigratingVmsCallable;
  }

  @Override
  public UnaryCallable<ListMigratingVmsRequest, ListMigratingVmsPagedResponse>
      listMigratingVmsPagedCallable() {
    return listMigratingVmsPagedCallable;
  }

  @Override
  public UnaryCallable<GetMigratingVmRequest, MigratingVm> getMigratingVmCallable() {
    return getMigratingVmCallable;
  }

  @Override
  public UnaryCallable<UpdateMigratingVmRequest, Operation> updateMigratingVmCallable() {
    return updateMigratingVmCallable;
  }

  @Override
  public OperationCallable<UpdateMigratingVmRequest, MigratingVm, OperationMetadata>
      updateMigratingVmOperationCallable() {
    return updateMigratingVmOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteMigratingVmRequest, Operation> deleteMigratingVmCallable() {
    return deleteMigratingVmCallable;
  }

  @Override
  public OperationCallable<DeleteMigratingVmRequest, Empty, OperationMetadata>
      deleteMigratingVmOperationCallable() {
    return deleteMigratingVmOperationCallable;
  }

  @Override
  public UnaryCallable<StartMigrationRequest, Operation> startMigrationCallable() {
    return startMigrationCallable;
  }

  @Override
  public OperationCallable<StartMigrationRequest, StartMigrationResponse, OperationMetadata>
      startMigrationOperationCallable() {
    return startMigrationOperationCallable;
  }

  @Override
  public UnaryCallable<ResumeMigrationRequest, Operation> resumeMigrationCallable() {
    return resumeMigrationCallable;
  }

  @Override
  public OperationCallable<ResumeMigrationRequest, ResumeMigrationResponse, OperationMetadata>
      resumeMigrationOperationCallable() {
    return resumeMigrationOperationCallable;
  }

  @Override
  public UnaryCallable<PauseMigrationRequest, Operation> pauseMigrationCallable() {
    return pauseMigrationCallable;
  }

  @Override
  public OperationCallable<PauseMigrationRequest, PauseMigrationResponse, OperationMetadata>
      pauseMigrationOperationCallable() {
    return pauseMigrationOperationCallable;
  }

  @Override
  public UnaryCallable<FinalizeMigrationRequest, Operation> finalizeMigrationCallable() {
    return finalizeMigrationCallable;
  }

  @Override
  public OperationCallable<FinalizeMigrationRequest, FinalizeMigrationResponse, OperationMetadata>
      finalizeMigrationOperationCallable() {
    return finalizeMigrationOperationCallable;
  }

  @Override
  public UnaryCallable<CreateCloneJobRequest, Operation> createCloneJobCallable() {
    return createCloneJobCallable;
  }

  @Override
  public OperationCallable<CreateCloneJobRequest, CloneJob, OperationMetadata>
      createCloneJobOperationCallable() {
    return createCloneJobOperationCallable;
  }

  @Override
  public UnaryCallable<CancelCloneJobRequest, Operation> cancelCloneJobCallable() {
    return cancelCloneJobCallable;
  }

  @Override
  public OperationCallable<CancelCloneJobRequest, CancelCloneJobResponse, OperationMetadata>
      cancelCloneJobOperationCallable() {
    return cancelCloneJobOperationCallable;
  }

  @Override
  public UnaryCallable<ListCloneJobsRequest, ListCloneJobsResponse> listCloneJobsCallable() {
    return listCloneJobsCallable;
  }

  @Override
  public UnaryCallable<ListCloneJobsRequest, ListCloneJobsPagedResponse>
      listCloneJobsPagedCallable() {
    return listCloneJobsPagedCallable;
  }

  @Override
  public UnaryCallable<GetCloneJobRequest, CloneJob> getCloneJobCallable() {
    return getCloneJobCallable;
  }

  @Override
  public UnaryCallable<CreateCutoverJobRequest, Operation> createCutoverJobCallable() {
    return createCutoverJobCallable;
  }

  @Override
  public OperationCallable<CreateCutoverJobRequest, CutoverJob, OperationMetadata>
      createCutoverJobOperationCallable() {
    return createCutoverJobOperationCallable;
  }

  @Override
  public UnaryCallable<CancelCutoverJobRequest, Operation> cancelCutoverJobCallable() {
    return cancelCutoverJobCallable;
  }

  @Override
  public OperationCallable<CancelCutoverJobRequest, CancelCutoverJobResponse, OperationMetadata>
      cancelCutoverJobOperationCallable() {
    return cancelCutoverJobOperationCallable;
  }

  @Override
  public UnaryCallable<ListCutoverJobsRequest, ListCutoverJobsResponse> listCutoverJobsCallable() {
    return listCutoverJobsCallable;
  }

  @Override
  public UnaryCallable<ListCutoverJobsRequest, ListCutoverJobsPagedResponse>
      listCutoverJobsPagedCallable() {
    return listCutoverJobsPagedCallable;
  }

  @Override
  public UnaryCallable<GetCutoverJobRequest, CutoverJob> getCutoverJobCallable() {
    return getCutoverJobCallable;
  }

  @Override
  public UnaryCallable<ListGroupsRequest, ListGroupsResponse> listGroupsCallable() {
    return listGroupsCallable;
  }

  @Override
  public UnaryCallable<ListGroupsRequest, ListGroupsPagedResponse> listGroupsPagedCallable() {
    return listGroupsPagedCallable;
  }

  @Override
  public UnaryCallable<GetGroupRequest, Group> getGroupCallable() {
    return getGroupCallable;
  }

  @Override
  public UnaryCallable<CreateGroupRequest, Operation> createGroupCallable() {
    return createGroupCallable;
  }

  @Override
  public OperationCallable<CreateGroupRequest, Group, OperationMetadata>
      createGroupOperationCallable() {
    return createGroupOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateGroupRequest, Operation> updateGroupCallable() {
    return updateGroupCallable;
  }

  @Override
  public OperationCallable<UpdateGroupRequest, Group, OperationMetadata>
      updateGroupOperationCallable() {
    return updateGroupOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteGroupRequest, Operation> deleteGroupCallable() {
    return deleteGroupCallable;
  }

  @Override
  public OperationCallable<DeleteGroupRequest, Empty, OperationMetadata>
      deleteGroupOperationCallable() {
    return deleteGroupOperationCallable;
  }

  @Override
  public UnaryCallable<AddGroupMigrationRequest, Operation> addGroupMigrationCallable() {
    return addGroupMigrationCallable;
  }

  @Override
  public OperationCallable<AddGroupMigrationRequest, AddGroupMigrationResponse, OperationMetadata>
      addGroupMigrationOperationCallable() {
    return addGroupMigrationOperationCallable;
  }

  @Override
  public UnaryCallable<RemoveGroupMigrationRequest, Operation> removeGroupMigrationCallable() {
    return removeGroupMigrationCallable;
  }

  @Override
  public OperationCallable<
          RemoveGroupMigrationRequest, RemoveGroupMigrationResponse, OperationMetadata>
      removeGroupMigrationOperationCallable() {
    return removeGroupMigrationOperationCallable;
  }

  @Override
  public UnaryCallable<ListTargetProjectsRequest, ListTargetProjectsResponse>
      listTargetProjectsCallable() {
    return listTargetProjectsCallable;
  }

  @Override
  public UnaryCallable<ListTargetProjectsRequest, ListTargetProjectsPagedResponse>
      listTargetProjectsPagedCallable() {
    return listTargetProjectsPagedCallable;
  }

  @Override
  public UnaryCallable<GetTargetProjectRequest, TargetProject> getTargetProjectCallable() {
    return getTargetProjectCallable;
  }

  @Override
  public UnaryCallable<CreateTargetProjectRequest, Operation> createTargetProjectCallable() {
    return createTargetProjectCallable;
  }

  @Override
  public OperationCallable<CreateTargetProjectRequest, TargetProject, OperationMetadata>
      createTargetProjectOperationCallable() {
    return createTargetProjectOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateTargetProjectRequest, Operation> updateTargetProjectCallable() {
    return updateTargetProjectCallable;
  }

  @Override
  public OperationCallable<UpdateTargetProjectRequest, TargetProject, OperationMetadata>
      updateTargetProjectOperationCallable() {
    return updateTargetProjectOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteTargetProjectRequest, Operation> deleteTargetProjectCallable() {
    return deleteTargetProjectCallable;
  }

  @Override
  public OperationCallable<DeleteTargetProjectRequest, Empty, OperationMetadata>
      deleteTargetProjectOperationCallable() {
    return deleteTargetProjectOperationCallable;
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
