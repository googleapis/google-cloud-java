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

package com.google.cloud.securitycenter.v2.stub;

import static com.google.cloud.securitycenter.v2.SecurityCenterClient.GroupFindingsPagedResponse;
import static com.google.cloud.securitycenter.v2.SecurityCenterClient.ListAttackPathsPagedResponse;
import static com.google.cloud.securitycenter.v2.SecurityCenterClient.ListBigQueryExportsPagedResponse;
import static com.google.cloud.securitycenter.v2.SecurityCenterClient.ListFindingsPagedResponse;
import static com.google.cloud.securitycenter.v2.SecurityCenterClient.ListMuteConfigsPagedResponse;
import static com.google.cloud.securitycenter.v2.SecurityCenterClient.ListNotificationConfigsPagedResponse;
import static com.google.cloud.securitycenter.v2.SecurityCenterClient.ListResourceValueConfigsPagedResponse;
import static com.google.cloud.securitycenter.v2.SecurityCenterClient.ListSourcesPagedResponse;
import static com.google.cloud.securitycenter.v2.SecurityCenterClient.ListValuedResourcesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.pathtemplate.PathTemplate;
import com.google.cloud.securitycenter.v2.BatchCreateResourceValueConfigsRequest;
import com.google.cloud.securitycenter.v2.BatchCreateResourceValueConfigsResponse;
import com.google.cloud.securitycenter.v2.BigQueryExport;
import com.google.cloud.securitycenter.v2.BulkMuteFindingsRequest;
import com.google.cloud.securitycenter.v2.BulkMuteFindingsResponse;
import com.google.cloud.securitycenter.v2.CreateBigQueryExportRequest;
import com.google.cloud.securitycenter.v2.CreateFindingRequest;
import com.google.cloud.securitycenter.v2.CreateMuteConfigRequest;
import com.google.cloud.securitycenter.v2.CreateNotificationConfigRequest;
import com.google.cloud.securitycenter.v2.CreateSourceRequest;
import com.google.cloud.securitycenter.v2.DeleteBigQueryExportRequest;
import com.google.cloud.securitycenter.v2.DeleteMuteConfigRequest;
import com.google.cloud.securitycenter.v2.DeleteNotificationConfigRequest;
import com.google.cloud.securitycenter.v2.DeleteResourceValueConfigRequest;
import com.google.cloud.securitycenter.v2.ExternalSystem;
import com.google.cloud.securitycenter.v2.Finding;
import com.google.cloud.securitycenter.v2.GetBigQueryExportRequest;
import com.google.cloud.securitycenter.v2.GetMuteConfigRequest;
import com.google.cloud.securitycenter.v2.GetNotificationConfigRequest;
import com.google.cloud.securitycenter.v2.GetResourceValueConfigRequest;
import com.google.cloud.securitycenter.v2.GetSimulationRequest;
import com.google.cloud.securitycenter.v2.GetSourceRequest;
import com.google.cloud.securitycenter.v2.GetValuedResourceRequest;
import com.google.cloud.securitycenter.v2.GroupFindingsRequest;
import com.google.cloud.securitycenter.v2.GroupFindingsResponse;
import com.google.cloud.securitycenter.v2.ListAttackPathsRequest;
import com.google.cloud.securitycenter.v2.ListAttackPathsResponse;
import com.google.cloud.securitycenter.v2.ListBigQueryExportsRequest;
import com.google.cloud.securitycenter.v2.ListBigQueryExportsResponse;
import com.google.cloud.securitycenter.v2.ListFindingsRequest;
import com.google.cloud.securitycenter.v2.ListFindingsResponse;
import com.google.cloud.securitycenter.v2.ListMuteConfigsRequest;
import com.google.cloud.securitycenter.v2.ListMuteConfigsResponse;
import com.google.cloud.securitycenter.v2.ListNotificationConfigsRequest;
import com.google.cloud.securitycenter.v2.ListNotificationConfigsResponse;
import com.google.cloud.securitycenter.v2.ListResourceValueConfigsRequest;
import com.google.cloud.securitycenter.v2.ListResourceValueConfigsResponse;
import com.google.cloud.securitycenter.v2.ListSourcesRequest;
import com.google.cloud.securitycenter.v2.ListSourcesResponse;
import com.google.cloud.securitycenter.v2.ListValuedResourcesRequest;
import com.google.cloud.securitycenter.v2.ListValuedResourcesResponse;
import com.google.cloud.securitycenter.v2.MuteConfig;
import com.google.cloud.securitycenter.v2.NotificationConfig;
import com.google.cloud.securitycenter.v2.ResourceValueConfig;
import com.google.cloud.securitycenter.v2.SecurityMarks;
import com.google.cloud.securitycenter.v2.SetFindingStateRequest;
import com.google.cloud.securitycenter.v2.SetMuteRequest;
import com.google.cloud.securitycenter.v2.Simulation;
import com.google.cloud.securitycenter.v2.Source;
import com.google.cloud.securitycenter.v2.UpdateBigQueryExportRequest;
import com.google.cloud.securitycenter.v2.UpdateExternalSystemRequest;
import com.google.cloud.securitycenter.v2.UpdateFindingRequest;
import com.google.cloud.securitycenter.v2.UpdateMuteConfigRequest;
import com.google.cloud.securitycenter.v2.UpdateNotificationConfigRequest;
import com.google.cloud.securitycenter.v2.UpdateResourceValueConfigRequest;
import com.google.cloud.securitycenter.v2.UpdateSecurityMarksRequest;
import com.google.cloud.securitycenter.v2.UpdateSourceRequest;
import com.google.cloud.securitycenter.v2.ValuedResource;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
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
 * gRPC stub implementation for the SecurityCenter service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcSecurityCenterStub extends SecurityCenterStub {
  private static final MethodDescriptor<
          BatchCreateResourceValueConfigsRequest, BatchCreateResourceValueConfigsResponse>
      batchCreateResourceValueConfigsMethodDescriptor =
          MethodDescriptor
              .<BatchCreateResourceValueConfigsRequest, BatchCreateResourceValueConfigsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securitycenter.v2.SecurityCenter/BatchCreateResourceValueConfigs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      BatchCreateResourceValueConfigsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      BatchCreateResourceValueConfigsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<BulkMuteFindingsRequest, Operation>
      bulkMuteFindingsMethodDescriptor =
          MethodDescriptor.<BulkMuteFindingsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.securitycenter.v2.SecurityCenter/BulkMuteFindings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BulkMuteFindingsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateBigQueryExportRequest, BigQueryExport>
      createBigQueryExportMethodDescriptor =
          MethodDescriptor.<CreateBigQueryExportRequest, BigQueryExport>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securitycenter.v2.SecurityCenter/CreateBigQueryExport")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateBigQueryExportRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(BigQueryExport.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateFindingRequest, Finding>
      createFindingMethodDescriptor =
          MethodDescriptor.<CreateFindingRequest, Finding>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.securitycenter.v2.SecurityCenter/CreateFinding")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateFindingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Finding.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateMuteConfigRequest, MuteConfig>
      createMuteConfigMethodDescriptor =
          MethodDescriptor.<CreateMuteConfigRequest, MuteConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.securitycenter.v2.SecurityCenter/CreateMuteConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateMuteConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(MuteConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateNotificationConfigRequest, NotificationConfig>
      createNotificationConfigMethodDescriptor =
          MethodDescriptor.<CreateNotificationConfigRequest, NotificationConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securitycenter.v2.SecurityCenter/CreateNotificationConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateNotificationConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(NotificationConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateSourceRequest, Source> createSourceMethodDescriptor =
      MethodDescriptor.<CreateSourceRequest, Source>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.securitycenter.v2.SecurityCenter/CreateSource")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateSourceRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Source.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteBigQueryExportRequest, Empty>
      deleteBigQueryExportMethodDescriptor =
          MethodDescriptor.<DeleteBigQueryExportRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securitycenter.v2.SecurityCenter/DeleteBigQueryExport")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteBigQueryExportRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteMuteConfigRequest, Empty>
      deleteMuteConfigMethodDescriptor =
          MethodDescriptor.<DeleteMuteConfigRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.securitycenter.v2.SecurityCenter/DeleteMuteConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteMuteConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteNotificationConfigRequest, Empty>
      deleteNotificationConfigMethodDescriptor =
          MethodDescriptor.<DeleteNotificationConfigRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securitycenter.v2.SecurityCenter/DeleteNotificationConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteNotificationConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteResourceValueConfigRequest, Empty>
      deleteResourceValueConfigMethodDescriptor =
          MethodDescriptor.<DeleteResourceValueConfigRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securitycenter.v2.SecurityCenter/DeleteResourceValueConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteResourceValueConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetBigQueryExportRequest, BigQueryExport>
      getBigQueryExportMethodDescriptor =
          MethodDescriptor.<GetBigQueryExportRequest, BigQueryExport>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.securitycenter.v2.SecurityCenter/GetBigQueryExport")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetBigQueryExportRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(BigQueryExport.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetSimulationRequest, Simulation>
      getSimulationMethodDescriptor =
          MethodDescriptor.<GetSimulationRequest, Simulation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.securitycenter.v2.SecurityCenter/GetSimulation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetSimulationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Simulation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetValuedResourceRequest, ValuedResource>
      getValuedResourceMethodDescriptor =
          MethodDescriptor.<GetValuedResourceRequest, ValuedResource>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.securitycenter.v2.SecurityCenter/GetValuedResource")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetValuedResourceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ValuedResource.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.securitycenter.v2.SecurityCenter/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetMuteConfigRequest, MuteConfig>
      getMuteConfigMethodDescriptor =
          MethodDescriptor.<GetMuteConfigRequest, MuteConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.securitycenter.v2.SecurityCenter/GetMuteConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetMuteConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(MuteConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetNotificationConfigRequest, NotificationConfig>
      getNotificationConfigMethodDescriptor =
          MethodDescriptor.<GetNotificationConfigRequest, NotificationConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securitycenter.v2.SecurityCenter/GetNotificationConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetNotificationConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(NotificationConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetResourceValueConfigRequest, ResourceValueConfig>
      getResourceValueConfigMethodDescriptor =
          MethodDescriptor.<GetResourceValueConfigRequest, ResourceValueConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securitycenter.v2.SecurityCenter/GetResourceValueConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetResourceValueConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ResourceValueConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetSourceRequest, Source> getSourceMethodDescriptor =
      MethodDescriptor.<GetSourceRequest, Source>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.securitycenter.v2.SecurityCenter/GetSource")
          .setRequestMarshaller(ProtoUtils.marshaller(GetSourceRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Source.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GroupFindingsRequest, GroupFindingsResponse>
      groupFindingsMethodDescriptor =
          MethodDescriptor.<GroupFindingsRequest, GroupFindingsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.securitycenter.v2.SecurityCenter/GroupFindings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GroupFindingsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GroupFindingsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListAttackPathsRequest, ListAttackPathsResponse>
      listAttackPathsMethodDescriptor =
          MethodDescriptor.<ListAttackPathsRequest, ListAttackPathsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.securitycenter.v2.SecurityCenter/ListAttackPaths")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAttackPathsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAttackPathsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListBigQueryExportsRequest, ListBigQueryExportsResponse>
      listBigQueryExportsMethodDescriptor =
          MethodDescriptor.<ListBigQueryExportsRequest, ListBigQueryExportsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securitycenter.v2.SecurityCenter/ListBigQueryExports")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListBigQueryExportsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListBigQueryExportsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListFindingsRequest, ListFindingsResponse>
      listFindingsMethodDescriptor =
          MethodDescriptor.<ListFindingsRequest, ListFindingsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.securitycenter.v2.SecurityCenter/ListFindings")
              .setRequestMarshaller(ProtoUtils.marshaller(ListFindingsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListFindingsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListMuteConfigsRequest, ListMuteConfigsResponse>
      listMuteConfigsMethodDescriptor =
          MethodDescriptor.<ListMuteConfigsRequest, ListMuteConfigsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.securitycenter.v2.SecurityCenter/ListMuteConfigs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListMuteConfigsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListMuteConfigsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListNotificationConfigsRequest, ListNotificationConfigsResponse>
      listNotificationConfigsMethodDescriptor =
          MethodDescriptor
              .<ListNotificationConfigsRequest, ListNotificationConfigsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securitycenter.v2.SecurityCenter/ListNotificationConfigs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListNotificationConfigsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListNotificationConfigsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListResourceValueConfigsRequest, ListResourceValueConfigsResponse>
      listResourceValueConfigsMethodDescriptor =
          MethodDescriptor
              .<ListResourceValueConfigsRequest, ListResourceValueConfigsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securitycenter.v2.SecurityCenter/ListResourceValueConfigs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListResourceValueConfigsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListResourceValueConfigsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListSourcesRequest, ListSourcesResponse>
      listSourcesMethodDescriptor =
          MethodDescriptor.<ListSourcesRequest, ListSourcesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.securitycenter.v2.SecurityCenter/ListSources")
              .setRequestMarshaller(ProtoUtils.marshaller(ListSourcesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListSourcesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListValuedResourcesRequest, ListValuedResourcesResponse>
      listValuedResourcesMethodDescriptor =
          MethodDescriptor.<ListValuedResourcesRequest, ListValuedResourcesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securitycenter.v2.SecurityCenter/ListValuedResources")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListValuedResourcesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListValuedResourcesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SetFindingStateRequest, Finding>
      setFindingStateMethodDescriptor =
          MethodDescriptor.<SetFindingStateRequest, Finding>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.securitycenter.v2.SecurityCenter/SetFindingState")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SetFindingStateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Finding.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.securitycenter.v2.SecurityCenter/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<SetMuteRequest, Finding> setMuteMethodDescriptor =
      MethodDescriptor.<SetMuteRequest, Finding>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.securitycenter.v2.SecurityCenter/SetMute")
          .setRequestMarshaller(ProtoUtils.marshaller(SetMuteRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Finding.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          MethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.securitycenter.v2.SecurityCenter/TestIamPermissions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateBigQueryExportRequest, BigQueryExport>
      updateBigQueryExportMethodDescriptor =
          MethodDescriptor.<UpdateBigQueryExportRequest, BigQueryExport>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securitycenter.v2.SecurityCenter/UpdateBigQueryExport")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateBigQueryExportRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(BigQueryExport.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateExternalSystemRequest, ExternalSystem>
      updateExternalSystemMethodDescriptor =
          MethodDescriptor.<UpdateExternalSystemRequest, ExternalSystem>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securitycenter.v2.SecurityCenter/UpdateExternalSystem")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateExternalSystemRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ExternalSystem.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateFindingRequest, Finding>
      updateFindingMethodDescriptor =
          MethodDescriptor.<UpdateFindingRequest, Finding>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.securitycenter.v2.SecurityCenter/UpdateFinding")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateFindingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Finding.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateMuteConfigRequest, MuteConfig>
      updateMuteConfigMethodDescriptor =
          MethodDescriptor.<UpdateMuteConfigRequest, MuteConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.securitycenter.v2.SecurityCenter/UpdateMuteConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateMuteConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(MuteConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateNotificationConfigRequest, NotificationConfig>
      updateNotificationConfigMethodDescriptor =
          MethodDescriptor.<UpdateNotificationConfigRequest, NotificationConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securitycenter.v2.SecurityCenter/UpdateNotificationConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateNotificationConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(NotificationConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateResourceValueConfigRequest, ResourceValueConfig>
      updateResourceValueConfigMethodDescriptor =
          MethodDescriptor.<UpdateResourceValueConfigRequest, ResourceValueConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securitycenter.v2.SecurityCenter/UpdateResourceValueConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateResourceValueConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ResourceValueConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateSecurityMarksRequest, SecurityMarks>
      updateSecurityMarksMethodDescriptor =
          MethodDescriptor.<UpdateSecurityMarksRequest, SecurityMarks>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securitycenter.v2.SecurityCenter/UpdateSecurityMarks")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateSecurityMarksRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(SecurityMarks.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateSourceRequest, Source> updateSourceMethodDescriptor =
      MethodDescriptor.<UpdateSourceRequest, Source>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.securitycenter.v2.SecurityCenter/UpdateSource")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateSourceRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Source.getDefaultInstance()))
          .build();

  private final UnaryCallable<
          BatchCreateResourceValueConfigsRequest, BatchCreateResourceValueConfigsResponse>
      batchCreateResourceValueConfigsCallable;
  private final UnaryCallable<BulkMuteFindingsRequest, Operation> bulkMuteFindingsCallable;
  private final OperationCallable<BulkMuteFindingsRequest, BulkMuteFindingsResponse, Empty>
      bulkMuteFindingsOperationCallable;
  private final UnaryCallable<CreateBigQueryExportRequest, BigQueryExport>
      createBigQueryExportCallable;
  private final UnaryCallable<CreateFindingRequest, Finding> createFindingCallable;
  private final UnaryCallable<CreateMuteConfigRequest, MuteConfig> createMuteConfigCallable;
  private final UnaryCallable<CreateNotificationConfigRequest, NotificationConfig>
      createNotificationConfigCallable;
  private final UnaryCallable<CreateSourceRequest, Source> createSourceCallable;
  private final UnaryCallable<DeleteBigQueryExportRequest, Empty> deleteBigQueryExportCallable;
  private final UnaryCallable<DeleteMuteConfigRequest, Empty> deleteMuteConfigCallable;
  private final UnaryCallable<DeleteNotificationConfigRequest, Empty>
      deleteNotificationConfigCallable;
  private final UnaryCallable<DeleteResourceValueConfigRequest, Empty>
      deleteResourceValueConfigCallable;
  private final UnaryCallable<GetBigQueryExportRequest, BigQueryExport> getBigQueryExportCallable;
  private final UnaryCallable<GetSimulationRequest, Simulation> getSimulationCallable;
  private final UnaryCallable<GetValuedResourceRequest, ValuedResource> getValuedResourceCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<GetMuteConfigRequest, MuteConfig> getMuteConfigCallable;
  private final UnaryCallable<GetNotificationConfigRequest, NotificationConfig>
      getNotificationConfigCallable;
  private final UnaryCallable<GetResourceValueConfigRequest, ResourceValueConfig>
      getResourceValueConfigCallable;
  private final UnaryCallable<GetSourceRequest, Source> getSourceCallable;
  private final UnaryCallable<GroupFindingsRequest, GroupFindingsResponse> groupFindingsCallable;
  private final UnaryCallable<GroupFindingsRequest, GroupFindingsPagedResponse>
      groupFindingsPagedCallable;
  private final UnaryCallable<ListAttackPathsRequest, ListAttackPathsResponse>
      listAttackPathsCallable;
  private final UnaryCallable<ListAttackPathsRequest, ListAttackPathsPagedResponse>
      listAttackPathsPagedCallable;
  private final UnaryCallable<ListBigQueryExportsRequest, ListBigQueryExportsResponse>
      listBigQueryExportsCallable;
  private final UnaryCallable<ListBigQueryExportsRequest, ListBigQueryExportsPagedResponse>
      listBigQueryExportsPagedCallable;
  private final UnaryCallable<ListFindingsRequest, ListFindingsResponse> listFindingsCallable;
  private final UnaryCallable<ListFindingsRequest, ListFindingsPagedResponse>
      listFindingsPagedCallable;
  private final UnaryCallable<ListMuteConfigsRequest, ListMuteConfigsResponse>
      listMuteConfigsCallable;
  private final UnaryCallable<ListMuteConfigsRequest, ListMuteConfigsPagedResponse>
      listMuteConfigsPagedCallable;
  private final UnaryCallable<ListNotificationConfigsRequest, ListNotificationConfigsResponse>
      listNotificationConfigsCallable;
  private final UnaryCallable<ListNotificationConfigsRequest, ListNotificationConfigsPagedResponse>
      listNotificationConfigsPagedCallable;
  private final UnaryCallable<ListResourceValueConfigsRequest, ListResourceValueConfigsResponse>
      listResourceValueConfigsCallable;
  private final UnaryCallable<
          ListResourceValueConfigsRequest, ListResourceValueConfigsPagedResponse>
      listResourceValueConfigsPagedCallable;
  private final UnaryCallable<ListSourcesRequest, ListSourcesResponse> listSourcesCallable;
  private final UnaryCallable<ListSourcesRequest, ListSourcesPagedResponse>
      listSourcesPagedCallable;
  private final UnaryCallable<ListValuedResourcesRequest, ListValuedResourcesResponse>
      listValuedResourcesCallable;
  private final UnaryCallable<ListValuedResourcesRequest, ListValuedResourcesPagedResponse>
      listValuedResourcesPagedCallable;
  private final UnaryCallable<SetFindingStateRequest, Finding> setFindingStateCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<SetMuteRequest, Finding> setMuteCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;
  private final UnaryCallable<UpdateBigQueryExportRequest, BigQueryExport>
      updateBigQueryExportCallable;
  private final UnaryCallable<UpdateExternalSystemRequest, ExternalSystem>
      updateExternalSystemCallable;
  private final UnaryCallable<UpdateFindingRequest, Finding> updateFindingCallable;
  private final UnaryCallable<UpdateMuteConfigRequest, MuteConfig> updateMuteConfigCallable;
  private final UnaryCallable<UpdateNotificationConfigRequest, NotificationConfig>
      updateNotificationConfigCallable;
  private final UnaryCallable<UpdateResourceValueConfigRequest, ResourceValueConfig>
      updateResourceValueConfigCallable;
  private final UnaryCallable<UpdateSecurityMarksRequest, SecurityMarks>
      updateSecurityMarksCallable;
  private final UnaryCallable<UpdateSourceRequest, Source> updateSourceCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  private static final PathTemplate CREATE_MUTE_CONFIG_0_PATH_TEMPLATE =
      PathTemplate.create("projects/*/locations/{location=*}");
  private static final PathTemplate CREATE_MUTE_CONFIG_1_PATH_TEMPLATE =
      PathTemplate.create("organizations/*/locations/{location=*}");
  private static final PathTemplate CREATE_MUTE_CONFIG_2_PATH_TEMPLATE =
      PathTemplate.create("folders/*/locations/{location=*}");
  private static final PathTemplate DELETE_MUTE_CONFIG_0_PATH_TEMPLATE =
      PathTemplate.create("projects/*/locations/{location=*}/muteConfigs/*");
  private static final PathTemplate DELETE_MUTE_CONFIG_1_PATH_TEMPLATE =
      PathTemplate.create("organizations/*/locations/{location=*}/muteConfigs/*");
  private static final PathTemplate DELETE_MUTE_CONFIG_2_PATH_TEMPLATE =
      PathTemplate.create("folders/*/locations/{location=*}/muteConfigs/*");
  private static final PathTemplate GET_MUTE_CONFIG_0_PATH_TEMPLATE =
      PathTemplate.create("projects/*/locations/{location=*}/muteConfigs/*");
  private static final PathTemplate GET_MUTE_CONFIG_1_PATH_TEMPLATE =
      PathTemplate.create("organizations/*/locations/{location=*}/muteConfigs/*");
  private static final PathTemplate GET_MUTE_CONFIG_2_PATH_TEMPLATE =
      PathTemplate.create("folders/*/locations/{location=*}/muteConfigs/*");
  private static final PathTemplate LIST_MUTE_CONFIGS_0_PATH_TEMPLATE =
      PathTemplate.create("projects/*/locations/{location=*}/muteConfigs");
  private static final PathTemplate LIST_MUTE_CONFIGS_1_PATH_TEMPLATE =
      PathTemplate.create("organizations/*/locations/{location=*}/muteConfigs");
  private static final PathTemplate LIST_MUTE_CONFIGS_2_PATH_TEMPLATE =
      PathTemplate.create("folders/*/locations/{location=*}/muteConfigs");
  private static final PathTemplate UPDATE_MUTE_CONFIG_0_PATH_TEMPLATE =
      PathTemplate.create("projects/*/locations/{location=*}/muteConfigs/*");
  private static final PathTemplate UPDATE_MUTE_CONFIG_1_PATH_TEMPLATE =
      PathTemplate.create("organizations/*/locations/{location=*}/muteConfigs/*");
  private static final PathTemplate UPDATE_MUTE_CONFIG_2_PATH_TEMPLATE =
      PathTemplate.create("folders/*/locations/{location=*}/muteConfigs/*");

  public static final GrpcSecurityCenterStub create(SecurityCenterStubSettings settings)
      throws IOException {
    return new GrpcSecurityCenterStub(settings, ClientContext.create(settings));
  }

  public static final GrpcSecurityCenterStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcSecurityCenterStub(
        SecurityCenterStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcSecurityCenterStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcSecurityCenterStub(
        SecurityCenterStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcSecurityCenterStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcSecurityCenterStub(SecurityCenterStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcSecurityCenterCallableFactory());
  }

  /**
   * Constructs an instance of GrpcSecurityCenterStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcSecurityCenterStub(
      SecurityCenterStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<
            BatchCreateResourceValueConfigsRequest, BatchCreateResourceValueConfigsResponse>
        batchCreateResourceValueConfigsTransportSettings =
            GrpcCallSettings
                .<BatchCreateResourceValueConfigsRequest, BatchCreateResourceValueConfigsResponse>
                    newBuilder()
                .setMethodDescriptor(batchCreateResourceValueConfigsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<BulkMuteFindingsRequest, Operation> bulkMuteFindingsTransportSettings =
        GrpcCallSettings.<BulkMuteFindingsRequest, Operation>newBuilder()
            .setMethodDescriptor(bulkMuteFindingsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateBigQueryExportRequest, BigQueryExport>
        createBigQueryExportTransportSettings =
            GrpcCallSettings.<CreateBigQueryExportRequest, BigQueryExport>newBuilder()
                .setMethodDescriptor(createBigQueryExportMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateFindingRequest, Finding> createFindingTransportSettings =
        GrpcCallSettings.<CreateFindingRequest, Finding>newBuilder()
            .setMethodDescriptor(createFindingMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateMuteConfigRequest, MuteConfig> createMuteConfigTransportSettings =
        GrpcCallSettings.<CreateMuteConfigRequest, MuteConfig>newBuilder()
            .setMethodDescriptor(createMuteConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getParent(), "location", CREATE_MUTE_CONFIG_0_PATH_TEMPLATE);
                  builder.add(request.getParent(), "location", CREATE_MUTE_CONFIG_1_PATH_TEMPLATE);
                  builder.add(request.getParent(), "location", CREATE_MUTE_CONFIG_2_PATH_TEMPLATE);
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateNotificationConfigRequest, NotificationConfig>
        createNotificationConfigTransportSettings =
            GrpcCallSettings.<CreateNotificationConfigRequest, NotificationConfig>newBuilder()
                .setMethodDescriptor(createNotificationConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateSourceRequest, Source> createSourceTransportSettings =
        GrpcCallSettings.<CreateSourceRequest, Source>newBuilder()
            .setMethodDescriptor(createSourceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteBigQueryExportRequest, Empty> deleteBigQueryExportTransportSettings =
        GrpcCallSettings.<DeleteBigQueryExportRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteBigQueryExportMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteMuteConfigRequest, Empty> deleteMuteConfigTransportSettings =
        GrpcCallSettings.<DeleteMuteConfigRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteMuteConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getName(), "location", DELETE_MUTE_CONFIG_0_PATH_TEMPLATE);
                  builder.add(request.getName(), "location", DELETE_MUTE_CONFIG_1_PATH_TEMPLATE);
                  builder.add(request.getName(), "location", DELETE_MUTE_CONFIG_2_PATH_TEMPLATE);
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteNotificationConfigRequest, Empty>
        deleteNotificationConfigTransportSettings =
            GrpcCallSettings.<DeleteNotificationConfigRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteNotificationConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteResourceValueConfigRequest, Empty>
        deleteResourceValueConfigTransportSettings =
            GrpcCallSettings.<DeleteResourceValueConfigRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteResourceValueConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetBigQueryExportRequest, BigQueryExport> getBigQueryExportTransportSettings =
        GrpcCallSettings.<GetBigQueryExportRequest, BigQueryExport>newBuilder()
            .setMethodDescriptor(getBigQueryExportMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetSimulationRequest, Simulation> getSimulationTransportSettings =
        GrpcCallSettings.<GetSimulationRequest, Simulation>newBuilder()
            .setMethodDescriptor(getSimulationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetValuedResourceRequest, ValuedResource> getValuedResourceTransportSettings =
        GrpcCallSettings.<GetValuedResourceRequest, ValuedResource>newBuilder()
            .setMethodDescriptor(getValuedResourceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        GrpcCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetMuteConfigRequest, MuteConfig> getMuteConfigTransportSettings =
        GrpcCallSettings.<GetMuteConfigRequest, MuteConfig>newBuilder()
            .setMethodDescriptor(getMuteConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getName(), "location", GET_MUTE_CONFIG_0_PATH_TEMPLATE);
                  builder.add(request.getName(), "location", GET_MUTE_CONFIG_1_PATH_TEMPLATE);
                  builder.add(request.getName(), "location", GET_MUTE_CONFIG_2_PATH_TEMPLATE);
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetNotificationConfigRequest, NotificationConfig>
        getNotificationConfigTransportSettings =
            GrpcCallSettings.<GetNotificationConfigRequest, NotificationConfig>newBuilder()
                .setMethodDescriptor(getNotificationConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetResourceValueConfigRequest, ResourceValueConfig>
        getResourceValueConfigTransportSettings =
            GrpcCallSettings.<GetResourceValueConfigRequest, ResourceValueConfig>newBuilder()
                .setMethodDescriptor(getResourceValueConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetSourceRequest, Source> getSourceTransportSettings =
        GrpcCallSettings.<GetSourceRequest, Source>newBuilder()
            .setMethodDescriptor(getSourceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GroupFindingsRequest, GroupFindingsResponse> groupFindingsTransportSettings =
        GrpcCallSettings.<GroupFindingsRequest, GroupFindingsResponse>newBuilder()
            .setMethodDescriptor(groupFindingsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListAttackPathsRequest, ListAttackPathsResponse>
        listAttackPathsTransportSettings =
            GrpcCallSettings.<ListAttackPathsRequest, ListAttackPathsResponse>newBuilder()
                .setMethodDescriptor(listAttackPathsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListBigQueryExportsRequest, ListBigQueryExportsResponse>
        listBigQueryExportsTransportSettings =
            GrpcCallSettings.<ListBigQueryExportsRequest, ListBigQueryExportsResponse>newBuilder()
                .setMethodDescriptor(listBigQueryExportsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListFindingsRequest, ListFindingsResponse> listFindingsTransportSettings =
        GrpcCallSettings.<ListFindingsRequest, ListFindingsResponse>newBuilder()
            .setMethodDescriptor(listFindingsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListMuteConfigsRequest, ListMuteConfigsResponse>
        listMuteConfigsTransportSettings =
            GrpcCallSettings.<ListMuteConfigsRequest, ListMuteConfigsResponse>newBuilder()
                .setMethodDescriptor(listMuteConfigsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          request.getParent(), "location", LIST_MUTE_CONFIGS_0_PATH_TEMPLATE);
                      builder.add(
                          request.getParent(), "location", LIST_MUTE_CONFIGS_1_PATH_TEMPLATE);
                      builder.add(
                          request.getParent(), "location", LIST_MUTE_CONFIGS_2_PATH_TEMPLATE);
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListNotificationConfigsRequest, ListNotificationConfigsResponse>
        listNotificationConfigsTransportSettings =
            GrpcCallSettings
                .<ListNotificationConfigsRequest, ListNotificationConfigsResponse>newBuilder()
                .setMethodDescriptor(listNotificationConfigsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListResourceValueConfigsRequest, ListResourceValueConfigsResponse>
        listResourceValueConfigsTransportSettings =
            GrpcCallSettings
                .<ListResourceValueConfigsRequest, ListResourceValueConfigsResponse>newBuilder()
                .setMethodDescriptor(listResourceValueConfigsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListSourcesRequest, ListSourcesResponse> listSourcesTransportSettings =
        GrpcCallSettings.<ListSourcesRequest, ListSourcesResponse>newBuilder()
            .setMethodDescriptor(listSourcesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListValuedResourcesRequest, ListValuedResourcesResponse>
        listValuedResourcesTransportSettings =
            GrpcCallSettings.<ListValuedResourcesRequest, ListValuedResourcesResponse>newBuilder()
                .setMethodDescriptor(listValuedResourcesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<SetFindingStateRequest, Finding> setFindingStateTransportSettings =
        GrpcCallSettings.<SetFindingStateRequest, Finding>newBuilder()
            .setMethodDescriptor(setFindingStateMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        GrpcCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<SetMuteRequest, Finding> setMuteTransportSettings =
        GrpcCallSettings.<SetMuteRequest, Finding>newBuilder()
            .setMethodDescriptor(setMuteMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            GrpcCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("resource", String.valueOf(request.getResource()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateBigQueryExportRequest, BigQueryExport>
        updateBigQueryExportTransportSettings =
            GrpcCallSettings.<UpdateBigQueryExportRequest, BigQueryExport>newBuilder()
                .setMethodDescriptor(updateBigQueryExportMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "big_query_export.name",
                          String.valueOf(request.getBigQueryExport().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateExternalSystemRequest, ExternalSystem>
        updateExternalSystemTransportSettings =
            GrpcCallSettings.<UpdateExternalSystemRequest, ExternalSystem>newBuilder()
                .setMethodDescriptor(updateExternalSystemMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "external_system.name",
                          String.valueOf(request.getExternalSystem().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateFindingRequest, Finding> updateFindingTransportSettings =
        GrpcCallSettings.<UpdateFindingRequest, Finding>newBuilder()
            .setMethodDescriptor(updateFindingMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("finding.name", String.valueOf(request.getFinding().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateMuteConfigRequest, MuteConfig> updateMuteConfigTransportSettings =
        GrpcCallSettings.<UpdateMuteConfigRequest, MuteConfig>newBuilder()
            .setMethodDescriptor(updateMuteConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  if (request.getMuteConfig() != null) {
                    builder.add(
                        request.getMuteConfig().getName(),
                        "location",
                        UPDATE_MUTE_CONFIG_0_PATH_TEMPLATE);
                  }
                  if (request.getMuteConfig() != null) {
                    builder.add(
                        request.getMuteConfig().getName(),
                        "location",
                        UPDATE_MUTE_CONFIG_1_PATH_TEMPLATE);
                  }
                  if (request.getMuteConfig() != null) {
                    builder.add(
                        request.getMuteConfig().getName(),
                        "location",
                        UPDATE_MUTE_CONFIG_2_PATH_TEMPLATE);
                  }
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateNotificationConfigRequest, NotificationConfig>
        updateNotificationConfigTransportSettings =
            GrpcCallSettings.<UpdateNotificationConfigRequest, NotificationConfig>newBuilder()
                .setMethodDescriptor(updateNotificationConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "notification_config.name",
                          String.valueOf(request.getNotificationConfig().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateResourceValueConfigRequest, ResourceValueConfig>
        updateResourceValueConfigTransportSettings =
            GrpcCallSettings.<UpdateResourceValueConfigRequest, ResourceValueConfig>newBuilder()
                .setMethodDescriptor(updateResourceValueConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "resource_value_config.name",
                          String.valueOf(request.getResourceValueConfig().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateSecurityMarksRequest, SecurityMarks>
        updateSecurityMarksTransportSettings =
            GrpcCallSettings.<UpdateSecurityMarksRequest, SecurityMarks>newBuilder()
                .setMethodDescriptor(updateSecurityMarksMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "security_marks.name",
                          String.valueOf(request.getSecurityMarks().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateSourceRequest, Source> updateSourceTransportSettings =
        GrpcCallSettings.<UpdateSourceRequest, Source>newBuilder()
            .setMethodDescriptor(updateSourceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("source.name", String.valueOf(request.getSource().getName()));
                  return builder.build();
                })
            .build();

    this.batchCreateResourceValueConfigsCallable =
        callableFactory.createUnaryCallable(
            batchCreateResourceValueConfigsTransportSettings,
            settings.batchCreateResourceValueConfigsSettings(),
            clientContext);
    this.bulkMuteFindingsCallable =
        callableFactory.createUnaryCallable(
            bulkMuteFindingsTransportSettings, settings.bulkMuteFindingsSettings(), clientContext);
    this.bulkMuteFindingsOperationCallable =
        callableFactory.createOperationCallable(
            bulkMuteFindingsTransportSettings,
            settings.bulkMuteFindingsOperationSettings(),
            clientContext,
            operationsStub);
    this.createBigQueryExportCallable =
        callableFactory.createUnaryCallable(
            createBigQueryExportTransportSettings,
            settings.createBigQueryExportSettings(),
            clientContext);
    this.createFindingCallable =
        callableFactory.createUnaryCallable(
            createFindingTransportSettings, settings.createFindingSettings(), clientContext);
    this.createMuteConfigCallable =
        callableFactory.createUnaryCallable(
            createMuteConfigTransportSettings, settings.createMuteConfigSettings(), clientContext);
    this.createNotificationConfigCallable =
        callableFactory.createUnaryCallable(
            createNotificationConfigTransportSettings,
            settings.createNotificationConfigSettings(),
            clientContext);
    this.createSourceCallable =
        callableFactory.createUnaryCallable(
            createSourceTransportSettings, settings.createSourceSettings(), clientContext);
    this.deleteBigQueryExportCallable =
        callableFactory.createUnaryCallable(
            deleteBigQueryExportTransportSettings,
            settings.deleteBigQueryExportSettings(),
            clientContext);
    this.deleteMuteConfigCallable =
        callableFactory.createUnaryCallable(
            deleteMuteConfigTransportSettings, settings.deleteMuteConfigSettings(), clientContext);
    this.deleteNotificationConfigCallable =
        callableFactory.createUnaryCallable(
            deleteNotificationConfigTransportSettings,
            settings.deleteNotificationConfigSettings(),
            clientContext);
    this.deleteResourceValueConfigCallable =
        callableFactory.createUnaryCallable(
            deleteResourceValueConfigTransportSettings,
            settings.deleteResourceValueConfigSettings(),
            clientContext);
    this.getBigQueryExportCallable =
        callableFactory.createUnaryCallable(
            getBigQueryExportTransportSettings,
            settings.getBigQueryExportSettings(),
            clientContext);
    this.getSimulationCallable =
        callableFactory.createUnaryCallable(
            getSimulationTransportSettings, settings.getSimulationSettings(), clientContext);
    this.getValuedResourceCallable =
        callableFactory.createUnaryCallable(
            getValuedResourceTransportSettings,
            settings.getValuedResourceSettings(),
            clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.getMuteConfigCallable =
        callableFactory.createUnaryCallable(
            getMuteConfigTransportSettings, settings.getMuteConfigSettings(), clientContext);
    this.getNotificationConfigCallable =
        callableFactory.createUnaryCallable(
            getNotificationConfigTransportSettings,
            settings.getNotificationConfigSettings(),
            clientContext);
    this.getResourceValueConfigCallable =
        callableFactory.createUnaryCallable(
            getResourceValueConfigTransportSettings,
            settings.getResourceValueConfigSettings(),
            clientContext);
    this.getSourceCallable =
        callableFactory.createUnaryCallable(
            getSourceTransportSettings, settings.getSourceSettings(), clientContext);
    this.groupFindingsCallable =
        callableFactory.createUnaryCallable(
            groupFindingsTransportSettings, settings.groupFindingsSettings(), clientContext);
    this.groupFindingsPagedCallable =
        callableFactory.createPagedCallable(
            groupFindingsTransportSettings, settings.groupFindingsSettings(), clientContext);
    this.listAttackPathsCallable =
        callableFactory.createUnaryCallable(
            listAttackPathsTransportSettings, settings.listAttackPathsSettings(), clientContext);
    this.listAttackPathsPagedCallable =
        callableFactory.createPagedCallable(
            listAttackPathsTransportSettings, settings.listAttackPathsSettings(), clientContext);
    this.listBigQueryExportsCallable =
        callableFactory.createUnaryCallable(
            listBigQueryExportsTransportSettings,
            settings.listBigQueryExportsSettings(),
            clientContext);
    this.listBigQueryExportsPagedCallable =
        callableFactory.createPagedCallable(
            listBigQueryExportsTransportSettings,
            settings.listBigQueryExportsSettings(),
            clientContext);
    this.listFindingsCallable =
        callableFactory.createUnaryCallable(
            listFindingsTransportSettings, settings.listFindingsSettings(), clientContext);
    this.listFindingsPagedCallable =
        callableFactory.createPagedCallable(
            listFindingsTransportSettings, settings.listFindingsSettings(), clientContext);
    this.listMuteConfigsCallable =
        callableFactory.createUnaryCallable(
            listMuteConfigsTransportSettings, settings.listMuteConfigsSettings(), clientContext);
    this.listMuteConfigsPagedCallable =
        callableFactory.createPagedCallable(
            listMuteConfigsTransportSettings, settings.listMuteConfigsSettings(), clientContext);
    this.listNotificationConfigsCallable =
        callableFactory.createUnaryCallable(
            listNotificationConfigsTransportSettings,
            settings.listNotificationConfigsSettings(),
            clientContext);
    this.listNotificationConfigsPagedCallable =
        callableFactory.createPagedCallable(
            listNotificationConfigsTransportSettings,
            settings.listNotificationConfigsSettings(),
            clientContext);
    this.listResourceValueConfigsCallable =
        callableFactory.createUnaryCallable(
            listResourceValueConfigsTransportSettings,
            settings.listResourceValueConfigsSettings(),
            clientContext);
    this.listResourceValueConfigsPagedCallable =
        callableFactory.createPagedCallable(
            listResourceValueConfigsTransportSettings,
            settings.listResourceValueConfigsSettings(),
            clientContext);
    this.listSourcesCallable =
        callableFactory.createUnaryCallable(
            listSourcesTransportSettings, settings.listSourcesSettings(), clientContext);
    this.listSourcesPagedCallable =
        callableFactory.createPagedCallable(
            listSourcesTransportSettings, settings.listSourcesSettings(), clientContext);
    this.listValuedResourcesCallable =
        callableFactory.createUnaryCallable(
            listValuedResourcesTransportSettings,
            settings.listValuedResourcesSettings(),
            clientContext);
    this.listValuedResourcesPagedCallable =
        callableFactory.createPagedCallable(
            listValuedResourcesTransportSettings,
            settings.listValuedResourcesSettings(),
            clientContext);
    this.setFindingStateCallable =
        callableFactory.createUnaryCallable(
            setFindingStateTransportSettings, settings.setFindingStateSettings(), clientContext);
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.setMuteCallable =
        callableFactory.createUnaryCallable(
            setMuteTransportSettings, settings.setMuteSettings(), clientContext);
    this.testIamPermissionsCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsTransportSettings,
            settings.testIamPermissionsSettings(),
            clientContext);
    this.updateBigQueryExportCallable =
        callableFactory.createUnaryCallable(
            updateBigQueryExportTransportSettings,
            settings.updateBigQueryExportSettings(),
            clientContext);
    this.updateExternalSystemCallable =
        callableFactory.createUnaryCallable(
            updateExternalSystemTransportSettings,
            settings.updateExternalSystemSettings(),
            clientContext);
    this.updateFindingCallable =
        callableFactory.createUnaryCallable(
            updateFindingTransportSettings, settings.updateFindingSettings(), clientContext);
    this.updateMuteConfigCallable =
        callableFactory.createUnaryCallable(
            updateMuteConfigTransportSettings, settings.updateMuteConfigSettings(), clientContext);
    this.updateNotificationConfigCallable =
        callableFactory.createUnaryCallable(
            updateNotificationConfigTransportSettings,
            settings.updateNotificationConfigSettings(),
            clientContext);
    this.updateResourceValueConfigCallable =
        callableFactory.createUnaryCallable(
            updateResourceValueConfigTransportSettings,
            settings.updateResourceValueConfigSettings(),
            clientContext);
    this.updateSecurityMarksCallable =
        callableFactory.createUnaryCallable(
            updateSecurityMarksTransportSettings,
            settings.updateSecurityMarksSettings(),
            clientContext);
    this.updateSourceCallable =
        callableFactory.createUnaryCallable(
            updateSourceTransportSettings, settings.updateSourceSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<
          BatchCreateResourceValueConfigsRequest, BatchCreateResourceValueConfigsResponse>
      batchCreateResourceValueConfigsCallable() {
    return batchCreateResourceValueConfigsCallable;
  }

  @Override
  public UnaryCallable<BulkMuteFindingsRequest, Operation> bulkMuteFindingsCallable() {
    return bulkMuteFindingsCallable;
  }

  @Override
  public OperationCallable<BulkMuteFindingsRequest, BulkMuteFindingsResponse, Empty>
      bulkMuteFindingsOperationCallable() {
    return bulkMuteFindingsOperationCallable;
  }

  @Override
  public UnaryCallable<CreateBigQueryExportRequest, BigQueryExport> createBigQueryExportCallable() {
    return createBigQueryExportCallable;
  }

  @Override
  public UnaryCallable<CreateFindingRequest, Finding> createFindingCallable() {
    return createFindingCallable;
  }

  @Override
  public UnaryCallable<CreateMuteConfigRequest, MuteConfig> createMuteConfigCallable() {
    return createMuteConfigCallable;
  }

  @Override
  public UnaryCallable<CreateNotificationConfigRequest, NotificationConfig>
      createNotificationConfigCallable() {
    return createNotificationConfigCallable;
  }

  @Override
  public UnaryCallable<CreateSourceRequest, Source> createSourceCallable() {
    return createSourceCallable;
  }

  @Override
  public UnaryCallable<DeleteBigQueryExportRequest, Empty> deleteBigQueryExportCallable() {
    return deleteBigQueryExportCallable;
  }

  @Override
  public UnaryCallable<DeleteMuteConfigRequest, Empty> deleteMuteConfigCallable() {
    return deleteMuteConfigCallable;
  }

  @Override
  public UnaryCallable<DeleteNotificationConfigRequest, Empty> deleteNotificationConfigCallable() {
    return deleteNotificationConfigCallable;
  }

  @Override
  public UnaryCallable<DeleteResourceValueConfigRequest, Empty>
      deleteResourceValueConfigCallable() {
    return deleteResourceValueConfigCallable;
  }

  @Override
  public UnaryCallable<GetBigQueryExportRequest, BigQueryExport> getBigQueryExportCallable() {
    return getBigQueryExportCallable;
  }

  @Override
  public UnaryCallable<GetSimulationRequest, Simulation> getSimulationCallable() {
    return getSimulationCallable;
  }

  @Override
  public UnaryCallable<GetValuedResourceRequest, ValuedResource> getValuedResourceCallable() {
    return getValuedResourceCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<GetMuteConfigRequest, MuteConfig> getMuteConfigCallable() {
    return getMuteConfigCallable;
  }

  @Override
  public UnaryCallable<GetNotificationConfigRequest, NotificationConfig>
      getNotificationConfigCallable() {
    return getNotificationConfigCallable;
  }

  @Override
  public UnaryCallable<GetResourceValueConfigRequest, ResourceValueConfig>
      getResourceValueConfigCallable() {
    return getResourceValueConfigCallable;
  }

  @Override
  public UnaryCallable<GetSourceRequest, Source> getSourceCallable() {
    return getSourceCallable;
  }

  @Override
  public UnaryCallable<GroupFindingsRequest, GroupFindingsResponse> groupFindingsCallable() {
    return groupFindingsCallable;
  }

  @Override
  public UnaryCallable<GroupFindingsRequest, GroupFindingsPagedResponse>
      groupFindingsPagedCallable() {
    return groupFindingsPagedCallable;
  }

  @Override
  public UnaryCallable<ListAttackPathsRequest, ListAttackPathsResponse> listAttackPathsCallable() {
    return listAttackPathsCallable;
  }

  @Override
  public UnaryCallable<ListAttackPathsRequest, ListAttackPathsPagedResponse>
      listAttackPathsPagedCallable() {
    return listAttackPathsPagedCallable;
  }

  @Override
  public UnaryCallable<ListBigQueryExportsRequest, ListBigQueryExportsResponse>
      listBigQueryExportsCallable() {
    return listBigQueryExportsCallable;
  }

  @Override
  public UnaryCallable<ListBigQueryExportsRequest, ListBigQueryExportsPagedResponse>
      listBigQueryExportsPagedCallable() {
    return listBigQueryExportsPagedCallable;
  }

  @Override
  public UnaryCallable<ListFindingsRequest, ListFindingsResponse> listFindingsCallable() {
    return listFindingsCallable;
  }

  @Override
  public UnaryCallable<ListFindingsRequest, ListFindingsPagedResponse> listFindingsPagedCallable() {
    return listFindingsPagedCallable;
  }

  @Override
  public UnaryCallable<ListMuteConfigsRequest, ListMuteConfigsResponse> listMuteConfigsCallable() {
    return listMuteConfigsCallable;
  }

  @Override
  public UnaryCallable<ListMuteConfigsRequest, ListMuteConfigsPagedResponse>
      listMuteConfigsPagedCallable() {
    return listMuteConfigsPagedCallable;
  }

  @Override
  public UnaryCallable<ListNotificationConfigsRequest, ListNotificationConfigsResponse>
      listNotificationConfigsCallable() {
    return listNotificationConfigsCallable;
  }

  @Override
  public UnaryCallable<ListNotificationConfigsRequest, ListNotificationConfigsPagedResponse>
      listNotificationConfigsPagedCallable() {
    return listNotificationConfigsPagedCallable;
  }

  @Override
  public UnaryCallable<ListResourceValueConfigsRequest, ListResourceValueConfigsResponse>
      listResourceValueConfigsCallable() {
    return listResourceValueConfigsCallable;
  }

  @Override
  public UnaryCallable<ListResourceValueConfigsRequest, ListResourceValueConfigsPagedResponse>
      listResourceValueConfigsPagedCallable() {
    return listResourceValueConfigsPagedCallable;
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
  public UnaryCallable<ListValuedResourcesRequest, ListValuedResourcesResponse>
      listValuedResourcesCallable() {
    return listValuedResourcesCallable;
  }

  @Override
  public UnaryCallable<ListValuedResourcesRequest, ListValuedResourcesPagedResponse>
      listValuedResourcesPagedCallable() {
    return listValuedResourcesPagedCallable;
  }

  @Override
  public UnaryCallable<SetFindingStateRequest, Finding> setFindingStateCallable() {
    return setFindingStateCallable;
  }

  @Override
  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<SetMuteRequest, Finding> setMuteCallable() {
    return setMuteCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
  }

  @Override
  public UnaryCallable<UpdateBigQueryExportRequest, BigQueryExport> updateBigQueryExportCallable() {
    return updateBigQueryExportCallable;
  }

  @Override
  public UnaryCallable<UpdateExternalSystemRequest, ExternalSystem> updateExternalSystemCallable() {
    return updateExternalSystemCallable;
  }

  @Override
  public UnaryCallable<UpdateFindingRequest, Finding> updateFindingCallable() {
    return updateFindingCallable;
  }

  @Override
  public UnaryCallable<UpdateMuteConfigRequest, MuteConfig> updateMuteConfigCallable() {
    return updateMuteConfigCallable;
  }

  @Override
  public UnaryCallable<UpdateNotificationConfigRequest, NotificationConfig>
      updateNotificationConfigCallable() {
    return updateNotificationConfigCallable;
  }

  @Override
  public UnaryCallable<UpdateResourceValueConfigRequest, ResourceValueConfig>
      updateResourceValueConfigCallable() {
    return updateResourceValueConfigCallable;
  }

  @Override
  public UnaryCallable<UpdateSecurityMarksRequest, SecurityMarks> updateSecurityMarksCallable() {
    return updateSecurityMarksCallable;
  }

  @Override
  public UnaryCallable<UpdateSourceRequest, Source> updateSourceCallable() {
    return updateSourceCallable;
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
