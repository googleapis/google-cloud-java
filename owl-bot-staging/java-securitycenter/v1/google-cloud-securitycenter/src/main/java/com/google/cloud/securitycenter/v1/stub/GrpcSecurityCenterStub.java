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

package com.google.cloud.securitycenter.v1.stub;

import static com.google.cloud.securitycenter.v1.SecurityCenterClient.GroupAssetsPagedResponse;
import static com.google.cloud.securitycenter.v1.SecurityCenterClient.GroupFindingsPagedResponse;
import static com.google.cloud.securitycenter.v1.SecurityCenterClient.ListAssetsPagedResponse;
import static com.google.cloud.securitycenter.v1.SecurityCenterClient.ListBigQueryExportsPagedResponse;
import static com.google.cloud.securitycenter.v1.SecurityCenterClient.ListFindingsPagedResponse;
import static com.google.cloud.securitycenter.v1.SecurityCenterClient.ListMuteConfigsPagedResponse;
import static com.google.cloud.securitycenter.v1.SecurityCenterClient.ListNotificationConfigsPagedResponse;
import static com.google.cloud.securitycenter.v1.SecurityCenterClient.ListSourcesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.securitycenter.v1.BigQueryExport;
import com.google.cloud.securitycenter.v1.BulkMuteFindingsRequest;
import com.google.cloud.securitycenter.v1.BulkMuteFindingsResponse;
import com.google.cloud.securitycenter.v1.CreateBigQueryExportRequest;
import com.google.cloud.securitycenter.v1.CreateFindingRequest;
import com.google.cloud.securitycenter.v1.CreateMuteConfigRequest;
import com.google.cloud.securitycenter.v1.CreateNotificationConfigRequest;
import com.google.cloud.securitycenter.v1.CreateSourceRequest;
import com.google.cloud.securitycenter.v1.DeleteBigQueryExportRequest;
import com.google.cloud.securitycenter.v1.DeleteMuteConfigRequest;
import com.google.cloud.securitycenter.v1.DeleteNotificationConfigRequest;
import com.google.cloud.securitycenter.v1.ExternalSystem;
import com.google.cloud.securitycenter.v1.Finding;
import com.google.cloud.securitycenter.v1.GetBigQueryExportRequest;
import com.google.cloud.securitycenter.v1.GetMuteConfigRequest;
import com.google.cloud.securitycenter.v1.GetNotificationConfigRequest;
import com.google.cloud.securitycenter.v1.GetOrganizationSettingsRequest;
import com.google.cloud.securitycenter.v1.GetSourceRequest;
import com.google.cloud.securitycenter.v1.GroupAssetsRequest;
import com.google.cloud.securitycenter.v1.GroupAssetsResponse;
import com.google.cloud.securitycenter.v1.GroupFindingsRequest;
import com.google.cloud.securitycenter.v1.GroupFindingsResponse;
import com.google.cloud.securitycenter.v1.ListAssetsRequest;
import com.google.cloud.securitycenter.v1.ListAssetsResponse;
import com.google.cloud.securitycenter.v1.ListBigQueryExportsRequest;
import com.google.cloud.securitycenter.v1.ListBigQueryExportsResponse;
import com.google.cloud.securitycenter.v1.ListFindingsRequest;
import com.google.cloud.securitycenter.v1.ListFindingsResponse;
import com.google.cloud.securitycenter.v1.ListMuteConfigsRequest;
import com.google.cloud.securitycenter.v1.ListMuteConfigsResponse;
import com.google.cloud.securitycenter.v1.ListNotificationConfigsRequest;
import com.google.cloud.securitycenter.v1.ListNotificationConfigsResponse;
import com.google.cloud.securitycenter.v1.ListSourcesRequest;
import com.google.cloud.securitycenter.v1.ListSourcesResponse;
import com.google.cloud.securitycenter.v1.MuteConfig;
import com.google.cloud.securitycenter.v1.NotificationConfig;
import com.google.cloud.securitycenter.v1.OrganizationSettings;
import com.google.cloud.securitycenter.v1.RunAssetDiscoveryRequest;
import com.google.cloud.securitycenter.v1.RunAssetDiscoveryResponse;
import com.google.cloud.securitycenter.v1.SecurityMarks;
import com.google.cloud.securitycenter.v1.SetFindingStateRequest;
import com.google.cloud.securitycenter.v1.SetMuteRequest;
import com.google.cloud.securitycenter.v1.Source;
import com.google.cloud.securitycenter.v1.UpdateBigQueryExportRequest;
import com.google.cloud.securitycenter.v1.UpdateExternalSystemRequest;
import com.google.cloud.securitycenter.v1.UpdateFindingRequest;
import com.google.cloud.securitycenter.v1.UpdateMuteConfigRequest;
import com.google.cloud.securitycenter.v1.UpdateNotificationConfigRequest;
import com.google.cloud.securitycenter.v1.UpdateOrganizationSettingsRequest;
import com.google.cloud.securitycenter.v1.UpdateSecurityMarksRequest;
import com.google.cloud.securitycenter.v1.UpdateSourceRequest;
import com.google.common.collect.ImmutableMap;
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
  private static final MethodDescriptor<BulkMuteFindingsRequest, Operation>
      bulkMuteFindingsMethodDescriptor =
          MethodDescriptor.<BulkMuteFindingsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.securitycenter.v1.SecurityCenter/BulkMuteFindings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BulkMuteFindingsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateSourceRequest, Source> createSourceMethodDescriptor =
      MethodDescriptor.<CreateSourceRequest, Source>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.securitycenter.v1.SecurityCenter/CreateSource")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateSourceRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Source.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateFindingRequest, Finding>
      createFindingMethodDescriptor =
          MethodDescriptor.<CreateFindingRequest, Finding>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.securitycenter.v1.SecurityCenter/CreateFinding")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateFindingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Finding.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateMuteConfigRequest, MuteConfig>
      createMuteConfigMethodDescriptor =
          MethodDescriptor.<CreateMuteConfigRequest, MuteConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.securitycenter.v1.SecurityCenter/CreateMuteConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateMuteConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(MuteConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateNotificationConfigRequest, NotificationConfig>
      createNotificationConfigMethodDescriptor =
          MethodDescriptor.<CreateNotificationConfigRequest, NotificationConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securitycenter.v1.SecurityCenter/CreateNotificationConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateNotificationConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(NotificationConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteMuteConfigRequest, Empty>
      deleteMuteConfigMethodDescriptor =
          MethodDescriptor.<DeleteMuteConfigRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.securitycenter.v1.SecurityCenter/DeleteMuteConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteMuteConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteNotificationConfigRequest, Empty>
      deleteNotificationConfigMethodDescriptor =
          MethodDescriptor.<DeleteNotificationConfigRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securitycenter.v1.SecurityCenter/DeleteNotificationConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteNotificationConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetBigQueryExportRequest, BigQueryExport>
      getBigQueryExportMethodDescriptor =
          MethodDescriptor.<GetBigQueryExportRequest, BigQueryExport>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.securitycenter.v1.SecurityCenter/GetBigQueryExport")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetBigQueryExportRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(BigQueryExport.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.securitycenter.v1.SecurityCenter/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetMuteConfigRequest, MuteConfig>
      getMuteConfigMethodDescriptor =
          MethodDescriptor.<GetMuteConfigRequest, MuteConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.securitycenter.v1.SecurityCenter/GetMuteConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetMuteConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(MuteConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetNotificationConfigRequest, NotificationConfig>
      getNotificationConfigMethodDescriptor =
          MethodDescriptor.<GetNotificationConfigRequest, NotificationConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securitycenter.v1.SecurityCenter/GetNotificationConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetNotificationConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(NotificationConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetOrganizationSettingsRequest, OrganizationSettings>
      getOrganizationSettingsMethodDescriptor =
          MethodDescriptor.<GetOrganizationSettingsRequest, OrganizationSettings>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securitycenter.v1.SecurityCenter/GetOrganizationSettings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetOrganizationSettingsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(OrganizationSettings.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetSourceRequest, Source> getSourceMethodDescriptor =
      MethodDescriptor.<GetSourceRequest, Source>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.securitycenter.v1.SecurityCenter/GetSource")
          .setRequestMarshaller(ProtoUtils.marshaller(GetSourceRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Source.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GroupAssetsRequest, GroupAssetsResponse>
      groupAssetsMethodDescriptor =
          MethodDescriptor.<GroupAssetsRequest, GroupAssetsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.securitycenter.v1.SecurityCenter/GroupAssets")
              .setRequestMarshaller(ProtoUtils.marshaller(GroupAssetsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GroupAssetsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GroupFindingsRequest, GroupFindingsResponse>
      groupFindingsMethodDescriptor =
          MethodDescriptor.<GroupFindingsRequest, GroupFindingsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.securitycenter.v1.SecurityCenter/GroupFindings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GroupFindingsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GroupFindingsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListAssetsRequest, ListAssetsResponse>
      listAssetsMethodDescriptor =
          MethodDescriptor.<ListAssetsRequest, ListAssetsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.securitycenter.v1.SecurityCenter/ListAssets")
              .setRequestMarshaller(ProtoUtils.marshaller(ListAssetsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListAssetsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListFindingsRequest, ListFindingsResponse>
      listFindingsMethodDescriptor =
          MethodDescriptor.<ListFindingsRequest, ListFindingsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.securitycenter.v1.SecurityCenter/ListFindings")
              .setRequestMarshaller(ProtoUtils.marshaller(ListFindingsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListFindingsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListMuteConfigsRequest, ListMuteConfigsResponse>
      listMuteConfigsMethodDescriptor =
          MethodDescriptor.<ListMuteConfigsRequest, ListMuteConfigsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.securitycenter.v1.SecurityCenter/ListMuteConfigs")
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
                  "google.cloud.securitycenter.v1.SecurityCenter/ListNotificationConfigs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListNotificationConfigsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListNotificationConfigsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListSourcesRequest, ListSourcesResponse>
      listSourcesMethodDescriptor =
          MethodDescriptor.<ListSourcesRequest, ListSourcesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.securitycenter.v1.SecurityCenter/ListSources")
              .setRequestMarshaller(ProtoUtils.marshaller(ListSourcesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListSourcesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RunAssetDiscoveryRequest, Operation>
      runAssetDiscoveryMethodDescriptor =
          MethodDescriptor.<RunAssetDiscoveryRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.securitycenter.v1.SecurityCenter/RunAssetDiscovery")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RunAssetDiscoveryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SetFindingStateRequest, Finding>
      setFindingStateMethodDescriptor =
          MethodDescriptor.<SetFindingStateRequest, Finding>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.securitycenter.v1.SecurityCenter/SetFindingState")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SetFindingStateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Finding.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SetMuteRequest, Finding> setMuteMethodDescriptor =
      MethodDescriptor.<SetMuteRequest, Finding>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.securitycenter.v1.SecurityCenter/SetMute")
          .setRequestMarshaller(ProtoUtils.marshaller(SetMuteRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Finding.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.securitycenter.v1.SecurityCenter/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          MethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.securitycenter.v1.SecurityCenter/TestIamPermissions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateExternalSystemRequest, ExternalSystem>
      updateExternalSystemMethodDescriptor =
          MethodDescriptor.<UpdateExternalSystemRequest, ExternalSystem>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securitycenter.v1.SecurityCenter/UpdateExternalSystem")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateExternalSystemRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ExternalSystem.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateFindingRequest, Finding>
      updateFindingMethodDescriptor =
          MethodDescriptor.<UpdateFindingRequest, Finding>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.securitycenter.v1.SecurityCenter/UpdateFinding")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateFindingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Finding.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateMuteConfigRequest, MuteConfig>
      updateMuteConfigMethodDescriptor =
          MethodDescriptor.<UpdateMuteConfigRequest, MuteConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.securitycenter.v1.SecurityCenter/UpdateMuteConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateMuteConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(MuteConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateNotificationConfigRequest, NotificationConfig>
      updateNotificationConfigMethodDescriptor =
          MethodDescriptor.<UpdateNotificationConfigRequest, NotificationConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securitycenter.v1.SecurityCenter/UpdateNotificationConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateNotificationConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(NotificationConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateOrganizationSettingsRequest, OrganizationSettings>
      updateOrganizationSettingsMethodDescriptor =
          MethodDescriptor.<UpdateOrganizationSettingsRequest, OrganizationSettings>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securitycenter.v1.SecurityCenter/UpdateOrganizationSettings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateOrganizationSettingsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(OrganizationSettings.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateSourceRequest, Source> updateSourceMethodDescriptor =
      MethodDescriptor.<UpdateSourceRequest, Source>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.securitycenter.v1.SecurityCenter/UpdateSource")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateSourceRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Source.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateSecurityMarksRequest, SecurityMarks>
      updateSecurityMarksMethodDescriptor =
          MethodDescriptor.<UpdateSecurityMarksRequest, SecurityMarks>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securitycenter.v1.SecurityCenter/UpdateSecurityMarks")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateSecurityMarksRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(SecurityMarks.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateBigQueryExportRequest, BigQueryExport>
      createBigQueryExportMethodDescriptor =
          MethodDescriptor.<CreateBigQueryExportRequest, BigQueryExport>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securitycenter.v1.SecurityCenter/CreateBigQueryExport")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateBigQueryExportRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(BigQueryExport.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteBigQueryExportRequest, Empty>
      deleteBigQueryExportMethodDescriptor =
          MethodDescriptor.<DeleteBigQueryExportRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securitycenter.v1.SecurityCenter/DeleteBigQueryExport")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteBigQueryExportRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateBigQueryExportRequest, BigQueryExport>
      updateBigQueryExportMethodDescriptor =
          MethodDescriptor.<UpdateBigQueryExportRequest, BigQueryExport>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securitycenter.v1.SecurityCenter/UpdateBigQueryExport")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateBigQueryExportRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(BigQueryExport.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListBigQueryExportsRequest, ListBigQueryExportsResponse>
      listBigQueryExportsMethodDescriptor =
          MethodDescriptor.<ListBigQueryExportsRequest, ListBigQueryExportsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.securitycenter.v1.SecurityCenter/ListBigQueryExports")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListBigQueryExportsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListBigQueryExportsResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<BulkMuteFindingsRequest, Operation> bulkMuteFindingsCallable;
  private final OperationCallable<BulkMuteFindingsRequest, BulkMuteFindingsResponse, Empty>
      bulkMuteFindingsOperationCallable;
  private final UnaryCallable<CreateSourceRequest, Source> createSourceCallable;
  private final UnaryCallable<CreateFindingRequest, Finding> createFindingCallable;
  private final UnaryCallable<CreateMuteConfigRequest, MuteConfig> createMuteConfigCallable;
  private final UnaryCallable<CreateNotificationConfigRequest, NotificationConfig>
      createNotificationConfigCallable;
  private final UnaryCallable<DeleteMuteConfigRequest, Empty> deleteMuteConfigCallable;
  private final UnaryCallable<DeleteNotificationConfigRequest, Empty>
      deleteNotificationConfigCallable;
  private final UnaryCallable<GetBigQueryExportRequest, BigQueryExport> getBigQueryExportCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<GetMuteConfigRequest, MuteConfig> getMuteConfigCallable;
  private final UnaryCallable<GetNotificationConfigRequest, NotificationConfig>
      getNotificationConfigCallable;
  private final UnaryCallable<GetOrganizationSettingsRequest, OrganizationSettings>
      getOrganizationSettingsCallable;
  private final UnaryCallable<GetSourceRequest, Source> getSourceCallable;
  private final UnaryCallable<GroupAssetsRequest, GroupAssetsResponse> groupAssetsCallable;
  private final UnaryCallable<GroupAssetsRequest, GroupAssetsPagedResponse>
      groupAssetsPagedCallable;
  private final UnaryCallable<GroupFindingsRequest, GroupFindingsResponse> groupFindingsCallable;
  private final UnaryCallable<GroupFindingsRequest, GroupFindingsPagedResponse>
      groupFindingsPagedCallable;
  private final UnaryCallable<ListAssetsRequest, ListAssetsResponse> listAssetsCallable;
  private final UnaryCallable<ListAssetsRequest, ListAssetsPagedResponse> listAssetsPagedCallable;
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
  private final UnaryCallable<ListSourcesRequest, ListSourcesResponse> listSourcesCallable;
  private final UnaryCallable<ListSourcesRequest, ListSourcesPagedResponse>
      listSourcesPagedCallable;
  private final UnaryCallable<RunAssetDiscoveryRequest, Operation> runAssetDiscoveryCallable;
  private final OperationCallable<RunAssetDiscoveryRequest, RunAssetDiscoveryResponse, Empty>
      runAssetDiscoveryOperationCallable;
  private final UnaryCallable<SetFindingStateRequest, Finding> setFindingStateCallable;
  private final UnaryCallable<SetMuteRequest, Finding> setMuteCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;
  private final UnaryCallable<UpdateExternalSystemRequest, ExternalSystem>
      updateExternalSystemCallable;
  private final UnaryCallable<UpdateFindingRequest, Finding> updateFindingCallable;
  private final UnaryCallable<UpdateMuteConfigRequest, MuteConfig> updateMuteConfigCallable;
  private final UnaryCallable<UpdateNotificationConfigRequest, NotificationConfig>
      updateNotificationConfigCallable;
  private final UnaryCallable<UpdateOrganizationSettingsRequest, OrganizationSettings>
      updateOrganizationSettingsCallable;
  private final UnaryCallable<UpdateSourceRequest, Source> updateSourceCallable;
  private final UnaryCallable<UpdateSecurityMarksRequest, SecurityMarks>
      updateSecurityMarksCallable;
  private final UnaryCallable<CreateBigQueryExportRequest, BigQueryExport>
      createBigQueryExportCallable;
  private final UnaryCallable<DeleteBigQueryExportRequest, Empty> deleteBigQueryExportCallable;
  private final UnaryCallable<UpdateBigQueryExportRequest, BigQueryExport>
      updateBigQueryExportCallable;
  private final UnaryCallable<ListBigQueryExportsRequest, ListBigQueryExportsResponse>
      listBigQueryExportsCallable;
  private final UnaryCallable<ListBigQueryExportsRequest, ListBigQueryExportsPagedResponse>
      listBigQueryExportsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

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

    GrpcCallSettings<BulkMuteFindingsRequest, Operation> bulkMuteFindingsTransportSettings =
        GrpcCallSettings.<BulkMuteFindingsRequest, Operation>newBuilder()
            .setMethodDescriptor(bulkMuteFindingsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateSourceRequest, Source> createSourceTransportSettings =
        GrpcCallSettings.<CreateSourceRequest, Source>newBuilder()
            .setMethodDescriptor(createSourceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateFindingRequest, Finding> createFindingTransportSettings =
        GrpcCallSettings.<CreateFindingRequest, Finding>newBuilder()
            .setMethodDescriptor(createFindingMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateMuteConfigRequest, MuteConfig> createMuteConfigTransportSettings =
        GrpcCallSettings.<CreateMuteConfigRequest, MuteConfig>newBuilder()
            .setMethodDescriptor(createMuteConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateNotificationConfigRequest, NotificationConfig>
        createNotificationConfigTransportSettings =
            GrpcCallSettings.<CreateNotificationConfigRequest, NotificationConfig>newBuilder()
                .setMethodDescriptor(createNotificationConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteMuteConfigRequest, Empty> deleteMuteConfigTransportSettings =
        GrpcCallSettings.<DeleteMuteConfigRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteMuteConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteNotificationConfigRequest, Empty>
        deleteNotificationConfigTransportSettings =
            GrpcCallSettings.<DeleteNotificationConfigRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteNotificationConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetBigQueryExportRequest, BigQueryExport> getBigQueryExportTransportSettings =
        GrpcCallSettings.<GetBigQueryExportRequest, BigQueryExport>newBuilder()
            .setMethodDescriptor(getBigQueryExportMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        GrpcCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("resource", String.valueOf(request.getResource()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetMuteConfigRequest, MuteConfig> getMuteConfigTransportSettings =
        GrpcCallSettings.<GetMuteConfigRequest, MuteConfig>newBuilder()
            .setMethodDescriptor(getMuteConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetNotificationConfigRequest, NotificationConfig>
        getNotificationConfigTransportSettings =
            GrpcCallSettings.<GetNotificationConfigRequest, NotificationConfig>newBuilder()
                .setMethodDescriptor(getNotificationConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetOrganizationSettingsRequest, OrganizationSettings>
        getOrganizationSettingsTransportSettings =
            GrpcCallSettings.<GetOrganizationSettingsRequest, OrganizationSettings>newBuilder()
                .setMethodDescriptor(getOrganizationSettingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
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
    GrpcCallSettings<GroupAssetsRequest, GroupAssetsResponse> groupAssetsTransportSettings =
        GrpcCallSettings.<GroupAssetsRequest, GroupAssetsResponse>newBuilder()
            .setMethodDescriptor(groupAssetsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GroupFindingsRequest, GroupFindingsResponse> groupFindingsTransportSettings =
        GrpcCallSettings.<GroupFindingsRequest, GroupFindingsResponse>newBuilder()
            .setMethodDescriptor(groupFindingsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListAssetsRequest, ListAssetsResponse> listAssetsTransportSettings =
        GrpcCallSettings.<ListAssetsRequest, ListAssetsResponse>newBuilder()
            .setMethodDescriptor(listAssetsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListFindingsRequest, ListFindingsResponse> listFindingsTransportSettings =
        GrpcCallSettings.<ListFindingsRequest, ListFindingsResponse>newBuilder()
            .setMethodDescriptor(listFindingsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListMuteConfigsRequest, ListMuteConfigsResponse>
        listMuteConfigsTransportSettings =
            GrpcCallSettings.<ListMuteConfigsRequest, ListMuteConfigsResponse>newBuilder()
                .setMethodDescriptor(listMuteConfigsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListNotificationConfigsRequest, ListNotificationConfigsResponse>
        listNotificationConfigsTransportSettings =
            GrpcCallSettings
                .<ListNotificationConfigsRequest, ListNotificationConfigsResponse>newBuilder()
                .setMethodDescriptor(listNotificationConfigsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
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
    GrpcCallSettings<RunAssetDiscoveryRequest, Operation> runAssetDiscoveryTransportSettings =
        GrpcCallSettings.<RunAssetDiscoveryRequest, Operation>newBuilder()
            .setMethodDescriptor(runAssetDiscoveryMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<SetFindingStateRequest, Finding> setFindingStateTransportSettings =
        GrpcCallSettings.<SetFindingStateRequest, Finding>newBuilder()
            .setMethodDescriptor(setFindingStateMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<SetMuteRequest, Finding> setMuteTransportSettings =
        GrpcCallSettings.<SetMuteRequest, Finding>newBuilder()
            .setMethodDescriptor(setMuteMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        GrpcCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("resource", String.valueOf(request.getResource()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            GrpcCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("resource", String.valueOf(request.getResource()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UpdateExternalSystemRequest, ExternalSystem>
        updateExternalSystemTransportSettings =
            GrpcCallSettings.<UpdateExternalSystemRequest, ExternalSystem>newBuilder()
                .setMethodDescriptor(updateExternalSystemMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put(
                          "external_system.name",
                          String.valueOf(request.getExternalSystem().getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UpdateFindingRequest, Finding> updateFindingTransportSettings =
        GrpcCallSettings.<UpdateFindingRequest, Finding>newBuilder()
            .setMethodDescriptor(updateFindingMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("finding.name", String.valueOf(request.getFinding().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateMuteConfigRequest, MuteConfig> updateMuteConfigTransportSettings =
        GrpcCallSettings.<UpdateMuteConfigRequest, MuteConfig>newBuilder()
            .setMethodDescriptor(updateMuteConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("mute_config.name", String.valueOf(request.getMuteConfig().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateNotificationConfigRequest, NotificationConfig>
        updateNotificationConfigTransportSettings =
            GrpcCallSettings.<UpdateNotificationConfigRequest, NotificationConfig>newBuilder()
                .setMethodDescriptor(updateNotificationConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put(
                          "notification_config.name",
                          String.valueOf(request.getNotificationConfig().getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UpdateOrganizationSettingsRequest, OrganizationSettings>
        updateOrganizationSettingsTransportSettings =
            GrpcCallSettings.<UpdateOrganizationSettingsRequest, OrganizationSettings>newBuilder()
                .setMethodDescriptor(updateOrganizationSettingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put(
                          "organization_settings.name",
                          String.valueOf(request.getOrganizationSettings().getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UpdateSourceRequest, Source> updateSourceTransportSettings =
        GrpcCallSettings.<UpdateSourceRequest, Source>newBuilder()
            .setMethodDescriptor(updateSourceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("source.name", String.valueOf(request.getSource().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateSecurityMarksRequest, SecurityMarks>
        updateSecurityMarksTransportSettings =
            GrpcCallSettings.<UpdateSecurityMarksRequest, SecurityMarks>newBuilder()
                .setMethodDescriptor(updateSecurityMarksMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put(
                          "security_marks.name",
                          String.valueOf(request.getSecurityMarks().getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<CreateBigQueryExportRequest, BigQueryExport>
        createBigQueryExportTransportSettings =
            GrpcCallSettings.<CreateBigQueryExportRequest, BigQueryExport>newBuilder()
                .setMethodDescriptor(createBigQueryExportMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteBigQueryExportRequest, Empty> deleteBigQueryExportTransportSettings =
        GrpcCallSettings.<DeleteBigQueryExportRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteBigQueryExportMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateBigQueryExportRequest, BigQueryExport>
        updateBigQueryExportTransportSettings =
            GrpcCallSettings.<UpdateBigQueryExportRequest, BigQueryExport>newBuilder()
                .setMethodDescriptor(updateBigQueryExportMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put(
                          "big_query_export.name",
                          String.valueOf(request.getBigQueryExport().getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListBigQueryExportsRequest, ListBigQueryExportsResponse>
        listBigQueryExportsTransportSettings =
            GrpcCallSettings.<ListBigQueryExportsRequest, ListBigQueryExportsResponse>newBuilder()
                .setMethodDescriptor(listBigQueryExportsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();

    this.bulkMuteFindingsCallable =
        callableFactory.createUnaryCallable(
            bulkMuteFindingsTransportSettings, settings.bulkMuteFindingsSettings(), clientContext);
    this.bulkMuteFindingsOperationCallable =
        callableFactory.createOperationCallable(
            bulkMuteFindingsTransportSettings,
            settings.bulkMuteFindingsOperationSettings(),
            clientContext,
            operationsStub);
    this.createSourceCallable =
        callableFactory.createUnaryCallable(
            createSourceTransportSettings, settings.createSourceSettings(), clientContext);
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
    this.deleteMuteConfigCallable =
        callableFactory.createUnaryCallable(
            deleteMuteConfigTransportSettings, settings.deleteMuteConfigSettings(), clientContext);
    this.deleteNotificationConfigCallable =
        callableFactory.createUnaryCallable(
            deleteNotificationConfigTransportSettings,
            settings.deleteNotificationConfigSettings(),
            clientContext);
    this.getBigQueryExportCallable =
        callableFactory.createUnaryCallable(
            getBigQueryExportTransportSettings,
            settings.getBigQueryExportSettings(),
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
    this.getOrganizationSettingsCallable =
        callableFactory.createUnaryCallable(
            getOrganizationSettingsTransportSettings,
            settings.getOrganizationSettingsSettings(),
            clientContext);
    this.getSourceCallable =
        callableFactory.createUnaryCallable(
            getSourceTransportSettings, settings.getSourceSettings(), clientContext);
    this.groupAssetsCallable =
        callableFactory.createUnaryCallable(
            groupAssetsTransportSettings, settings.groupAssetsSettings(), clientContext);
    this.groupAssetsPagedCallable =
        callableFactory.createPagedCallable(
            groupAssetsTransportSettings, settings.groupAssetsSettings(), clientContext);
    this.groupFindingsCallable =
        callableFactory.createUnaryCallable(
            groupFindingsTransportSettings, settings.groupFindingsSettings(), clientContext);
    this.groupFindingsPagedCallable =
        callableFactory.createPagedCallable(
            groupFindingsTransportSettings, settings.groupFindingsSettings(), clientContext);
    this.listAssetsCallable =
        callableFactory.createUnaryCallable(
            listAssetsTransportSettings, settings.listAssetsSettings(), clientContext);
    this.listAssetsPagedCallable =
        callableFactory.createPagedCallable(
            listAssetsTransportSettings, settings.listAssetsSettings(), clientContext);
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
    this.listSourcesCallable =
        callableFactory.createUnaryCallable(
            listSourcesTransportSettings, settings.listSourcesSettings(), clientContext);
    this.listSourcesPagedCallable =
        callableFactory.createPagedCallable(
            listSourcesTransportSettings, settings.listSourcesSettings(), clientContext);
    this.runAssetDiscoveryCallable =
        callableFactory.createUnaryCallable(
            runAssetDiscoveryTransportSettings,
            settings.runAssetDiscoverySettings(),
            clientContext);
    this.runAssetDiscoveryOperationCallable =
        callableFactory.createOperationCallable(
            runAssetDiscoveryTransportSettings,
            settings.runAssetDiscoveryOperationSettings(),
            clientContext,
            operationsStub);
    this.setFindingStateCallable =
        callableFactory.createUnaryCallable(
            setFindingStateTransportSettings, settings.setFindingStateSettings(), clientContext);
    this.setMuteCallable =
        callableFactory.createUnaryCallable(
            setMuteTransportSettings, settings.setMuteSettings(), clientContext);
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.testIamPermissionsCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsTransportSettings,
            settings.testIamPermissionsSettings(),
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
    this.updateOrganizationSettingsCallable =
        callableFactory.createUnaryCallable(
            updateOrganizationSettingsTransportSettings,
            settings.updateOrganizationSettingsSettings(),
            clientContext);
    this.updateSourceCallable =
        callableFactory.createUnaryCallable(
            updateSourceTransportSettings, settings.updateSourceSettings(), clientContext);
    this.updateSecurityMarksCallable =
        callableFactory.createUnaryCallable(
            updateSecurityMarksTransportSettings,
            settings.updateSecurityMarksSettings(),
            clientContext);
    this.createBigQueryExportCallable =
        callableFactory.createUnaryCallable(
            createBigQueryExportTransportSettings,
            settings.createBigQueryExportSettings(),
            clientContext);
    this.deleteBigQueryExportCallable =
        callableFactory.createUnaryCallable(
            deleteBigQueryExportTransportSettings,
            settings.deleteBigQueryExportSettings(),
            clientContext);
    this.updateBigQueryExportCallable =
        callableFactory.createUnaryCallable(
            updateBigQueryExportTransportSettings,
            settings.updateBigQueryExportSettings(),
            clientContext);
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

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
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
  public UnaryCallable<CreateSourceRequest, Source> createSourceCallable() {
    return createSourceCallable;
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
  public UnaryCallable<DeleteMuteConfigRequest, Empty> deleteMuteConfigCallable() {
    return deleteMuteConfigCallable;
  }

  @Override
  public UnaryCallable<DeleteNotificationConfigRequest, Empty> deleteNotificationConfigCallable() {
    return deleteNotificationConfigCallable;
  }

  @Override
  public UnaryCallable<GetBigQueryExportRequest, BigQueryExport> getBigQueryExportCallable() {
    return getBigQueryExportCallable;
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
  public UnaryCallable<GetOrganizationSettingsRequest, OrganizationSettings>
      getOrganizationSettingsCallable() {
    return getOrganizationSettingsCallable;
  }

  @Override
  public UnaryCallable<GetSourceRequest, Source> getSourceCallable() {
    return getSourceCallable;
  }

  @Override
  public UnaryCallable<GroupAssetsRequest, GroupAssetsResponse> groupAssetsCallable() {
    return groupAssetsCallable;
  }

  @Override
  public UnaryCallable<GroupAssetsRequest, GroupAssetsPagedResponse> groupAssetsPagedCallable() {
    return groupAssetsPagedCallable;
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
  public UnaryCallable<ListAssetsRequest, ListAssetsResponse> listAssetsCallable() {
    return listAssetsCallable;
  }

  @Override
  public UnaryCallable<ListAssetsRequest, ListAssetsPagedResponse> listAssetsPagedCallable() {
    return listAssetsPagedCallable;
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
  public UnaryCallable<ListSourcesRequest, ListSourcesResponse> listSourcesCallable() {
    return listSourcesCallable;
  }

  @Override
  public UnaryCallable<ListSourcesRequest, ListSourcesPagedResponse> listSourcesPagedCallable() {
    return listSourcesPagedCallable;
  }

  @Override
  public UnaryCallable<RunAssetDiscoveryRequest, Operation> runAssetDiscoveryCallable() {
    return runAssetDiscoveryCallable;
  }

  @Override
  public OperationCallable<RunAssetDiscoveryRequest, RunAssetDiscoveryResponse, Empty>
      runAssetDiscoveryOperationCallable() {
    return runAssetDiscoveryOperationCallable;
  }

  @Override
  public UnaryCallable<SetFindingStateRequest, Finding> setFindingStateCallable() {
    return setFindingStateCallable;
  }

  @Override
  public UnaryCallable<SetMuteRequest, Finding> setMuteCallable() {
    return setMuteCallable;
  }

  @Override
  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
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
  public UnaryCallable<UpdateOrganizationSettingsRequest, OrganizationSettings>
      updateOrganizationSettingsCallable() {
    return updateOrganizationSettingsCallable;
  }

  @Override
  public UnaryCallable<UpdateSourceRequest, Source> updateSourceCallable() {
    return updateSourceCallable;
  }

  @Override
  public UnaryCallable<UpdateSecurityMarksRequest, SecurityMarks> updateSecurityMarksCallable() {
    return updateSecurityMarksCallable;
  }

  @Override
  public UnaryCallable<CreateBigQueryExportRequest, BigQueryExport> createBigQueryExportCallable() {
    return createBigQueryExportCallable;
  }

  @Override
  public UnaryCallable<DeleteBigQueryExportRequest, Empty> deleteBigQueryExportCallable() {
    return deleteBigQueryExportCallable;
  }

  @Override
  public UnaryCallable<UpdateBigQueryExportRequest, BigQueryExport> updateBigQueryExportCallable() {
    return updateBigQueryExportCallable;
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
