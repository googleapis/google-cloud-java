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

package com.google.cloud.dlp.v2.stub;

import static com.google.cloud.dlp.v2.DlpServiceClient.ListColumnDataProfilesPagedResponse;
import static com.google.cloud.dlp.v2.DlpServiceClient.ListConnectionsPagedResponse;
import static com.google.cloud.dlp.v2.DlpServiceClient.ListDeidentifyTemplatesPagedResponse;
import static com.google.cloud.dlp.v2.DlpServiceClient.ListDiscoveryConfigsPagedResponse;
import static com.google.cloud.dlp.v2.DlpServiceClient.ListDlpJobsPagedResponse;
import static com.google.cloud.dlp.v2.DlpServiceClient.ListInspectTemplatesPagedResponse;
import static com.google.cloud.dlp.v2.DlpServiceClient.ListJobTriggersPagedResponse;
import static com.google.cloud.dlp.v2.DlpServiceClient.ListProjectDataProfilesPagedResponse;
import static com.google.cloud.dlp.v2.DlpServiceClient.ListStoredInfoTypesPagedResponse;
import static com.google.cloud.dlp.v2.DlpServiceClient.ListTableDataProfilesPagedResponse;
import static com.google.cloud.dlp.v2.DlpServiceClient.SearchConnectionsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.privacy.dlp.v2.ActivateJobTriggerRequest;
import com.google.privacy.dlp.v2.CancelDlpJobRequest;
import com.google.privacy.dlp.v2.ColumnDataProfile;
import com.google.privacy.dlp.v2.Connection;
import com.google.privacy.dlp.v2.CreateConnectionRequest;
import com.google.privacy.dlp.v2.CreateDeidentifyTemplateRequest;
import com.google.privacy.dlp.v2.CreateDiscoveryConfigRequest;
import com.google.privacy.dlp.v2.CreateDlpJobRequest;
import com.google.privacy.dlp.v2.CreateInspectTemplateRequest;
import com.google.privacy.dlp.v2.CreateJobTriggerRequest;
import com.google.privacy.dlp.v2.CreateStoredInfoTypeRequest;
import com.google.privacy.dlp.v2.DeidentifyContentRequest;
import com.google.privacy.dlp.v2.DeidentifyContentResponse;
import com.google.privacy.dlp.v2.DeidentifyTemplate;
import com.google.privacy.dlp.v2.DeleteConnectionRequest;
import com.google.privacy.dlp.v2.DeleteDeidentifyTemplateRequest;
import com.google.privacy.dlp.v2.DeleteDiscoveryConfigRequest;
import com.google.privacy.dlp.v2.DeleteDlpJobRequest;
import com.google.privacy.dlp.v2.DeleteInspectTemplateRequest;
import com.google.privacy.dlp.v2.DeleteJobTriggerRequest;
import com.google.privacy.dlp.v2.DeleteStoredInfoTypeRequest;
import com.google.privacy.dlp.v2.DeleteTableDataProfileRequest;
import com.google.privacy.dlp.v2.DiscoveryConfig;
import com.google.privacy.dlp.v2.DlpJob;
import com.google.privacy.dlp.v2.FinishDlpJobRequest;
import com.google.privacy.dlp.v2.GetColumnDataProfileRequest;
import com.google.privacy.dlp.v2.GetConnectionRequest;
import com.google.privacy.dlp.v2.GetDeidentifyTemplateRequest;
import com.google.privacy.dlp.v2.GetDiscoveryConfigRequest;
import com.google.privacy.dlp.v2.GetDlpJobRequest;
import com.google.privacy.dlp.v2.GetInspectTemplateRequest;
import com.google.privacy.dlp.v2.GetJobTriggerRequest;
import com.google.privacy.dlp.v2.GetProjectDataProfileRequest;
import com.google.privacy.dlp.v2.GetStoredInfoTypeRequest;
import com.google.privacy.dlp.v2.GetTableDataProfileRequest;
import com.google.privacy.dlp.v2.HybridInspectDlpJobRequest;
import com.google.privacy.dlp.v2.HybridInspectJobTriggerRequest;
import com.google.privacy.dlp.v2.HybridInspectResponse;
import com.google.privacy.dlp.v2.InspectContentRequest;
import com.google.privacy.dlp.v2.InspectContentResponse;
import com.google.privacy.dlp.v2.InspectTemplate;
import com.google.privacy.dlp.v2.JobTrigger;
import com.google.privacy.dlp.v2.ListColumnDataProfilesRequest;
import com.google.privacy.dlp.v2.ListColumnDataProfilesResponse;
import com.google.privacy.dlp.v2.ListConnectionsRequest;
import com.google.privacy.dlp.v2.ListConnectionsResponse;
import com.google.privacy.dlp.v2.ListDeidentifyTemplatesRequest;
import com.google.privacy.dlp.v2.ListDeidentifyTemplatesResponse;
import com.google.privacy.dlp.v2.ListDiscoveryConfigsRequest;
import com.google.privacy.dlp.v2.ListDiscoveryConfigsResponse;
import com.google.privacy.dlp.v2.ListDlpJobsRequest;
import com.google.privacy.dlp.v2.ListDlpJobsResponse;
import com.google.privacy.dlp.v2.ListInfoTypesRequest;
import com.google.privacy.dlp.v2.ListInfoTypesResponse;
import com.google.privacy.dlp.v2.ListInspectTemplatesRequest;
import com.google.privacy.dlp.v2.ListInspectTemplatesResponse;
import com.google.privacy.dlp.v2.ListJobTriggersRequest;
import com.google.privacy.dlp.v2.ListJobTriggersResponse;
import com.google.privacy.dlp.v2.ListProjectDataProfilesRequest;
import com.google.privacy.dlp.v2.ListProjectDataProfilesResponse;
import com.google.privacy.dlp.v2.ListStoredInfoTypesRequest;
import com.google.privacy.dlp.v2.ListStoredInfoTypesResponse;
import com.google.privacy.dlp.v2.ListTableDataProfilesRequest;
import com.google.privacy.dlp.v2.ListTableDataProfilesResponse;
import com.google.privacy.dlp.v2.ProjectDataProfile;
import com.google.privacy.dlp.v2.RedactImageRequest;
import com.google.privacy.dlp.v2.RedactImageResponse;
import com.google.privacy.dlp.v2.ReidentifyContentRequest;
import com.google.privacy.dlp.v2.ReidentifyContentResponse;
import com.google.privacy.dlp.v2.SearchConnectionsRequest;
import com.google.privacy.dlp.v2.SearchConnectionsResponse;
import com.google.privacy.dlp.v2.StoredInfoType;
import com.google.privacy.dlp.v2.TableDataProfile;
import com.google.privacy.dlp.v2.UpdateConnectionRequest;
import com.google.privacy.dlp.v2.UpdateDeidentifyTemplateRequest;
import com.google.privacy.dlp.v2.UpdateDiscoveryConfigRequest;
import com.google.privacy.dlp.v2.UpdateInspectTemplateRequest;
import com.google.privacy.dlp.v2.UpdateJobTriggerRequest;
import com.google.privacy.dlp.v2.UpdateStoredInfoTypeRequest;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the DlpService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcDlpServiceStub extends DlpServiceStub {
  private static final MethodDescriptor<InspectContentRequest, InspectContentResponse>
      inspectContentMethodDescriptor =
          MethodDescriptor.<InspectContentRequest, InspectContentResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.privacy.dlp.v2.DlpService/InspectContent")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(InspectContentRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(InspectContentResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RedactImageRequest, RedactImageResponse>
      redactImageMethodDescriptor =
          MethodDescriptor.<RedactImageRequest, RedactImageResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.privacy.dlp.v2.DlpService/RedactImage")
              .setRequestMarshaller(ProtoUtils.marshaller(RedactImageRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(RedactImageResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeidentifyContentRequest, DeidentifyContentResponse>
      deidentifyContentMethodDescriptor =
          MethodDescriptor.<DeidentifyContentRequest, DeidentifyContentResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.privacy.dlp.v2.DlpService/DeidentifyContent")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeidentifyContentRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(DeidentifyContentResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ReidentifyContentRequest, ReidentifyContentResponse>
      reidentifyContentMethodDescriptor =
          MethodDescriptor.<ReidentifyContentRequest, ReidentifyContentResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.privacy.dlp.v2.DlpService/ReidentifyContent")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ReidentifyContentRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ReidentifyContentResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListInfoTypesRequest, ListInfoTypesResponse>
      listInfoTypesMethodDescriptor =
          MethodDescriptor.<ListInfoTypesRequest, ListInfoTypesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.privacy.dlp.v2.DlpService/ListInfoTypes")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListInfoTypesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListInfoTypesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateInspectTemplateRequest, InspectTemplate>
      createInspectTemplateMethodDescriptor =
          MethodDescriptor.<CreateInspectTemplateRequest, InspectTemplate>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.privacy.dlp.v2.DlpService/CreateInspectTemplate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateInspectTemplateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(InspectTemplate.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateInspectTemplateRequest, InspectTemplate>
      updateInspectTemplateMethodDescriptor =
          MethodDescriptor.<UpdateInspectTemplateRequest, InspectTemplate>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.privacy.dlp.v2.DlpService/UpdateInspectTemplate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateInspectTemplateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(InspectTemplate.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetInspectTemplateRequest, InspectTemplate>
      getInspectTemplateMethodDescriptor =
          MethodDescriptor.<GetInspectTemplateRequest, InspectTemplate>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.privacy.dlp.v2.DlpService/GetInspectTemplate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetInspectTemplateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(InspectTemplate.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListInspectTemplatesRequest, ListInspectTemplatesResponse>
      listInspectTemplatesMethodDescriptor =
          MethodDescriptor.<ListInspectTemplatesRequest, ListInspectTemplatesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.privacy.dlp.v2.DlpService/ListInspectTemplates")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListInspectTemplatesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListInspectTemplatesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteInspectTemplateRequest, Empty>
      deleteInspectTemplateMethodDescriptor =
          MethodDescriptor.<DeleteInspectTemplateRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.privacy.dlp.v2.DlpService/DeleteInspectTemplate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteInspectTemplateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateDeidentifyTemplateRequest, DeidentifyTemplate>
      createDeidentifyTemplateMethodDescriptor =
          MethodDescriptor.<CreateDeidentifyTemplateRequest, DeidentifyTemplate>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.privacy.dlp.v2.DlpService/CreateDeidentifyTemplate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateDeidentifyTemplateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DeidentifyTemplate.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateDeidentifyTemplateRequest, DeidentifyTemplate>
      updateDeidentifyTemplateMethodDescriptor =
          MethodDescriptor.<UpdateDeidentifyTemplateRequest, DeidentifyTemplate>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.privacy.dlp.v2.DlpService/UpdateDeidentifyTemplate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateDeidentifyTemplateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DeidentifyTemplate.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetDeidentifyTemplateRequest, DeidentifyTemplate>
      getDeidentifyTemplateMethodDescriptor =
          MethodDescriptor.<GetDeidentifyTemplateRequest, DeidentifyTemplate>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.privacy.dlp.v2.DlpService/GetDeidentifyTemplate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetDeidentifyTemplateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DeidentifyTemplate.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListDeidentifyTemplatesRequest, ListDeidentifyTemplatesResponse>
      listDeidentifyTemplatesMethodDescriptor =
          MethodDescriptor
              .<ListDeidentifyTemplatesRequest, ListDeidentifyTemplatesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.privacy.dlp.v2.DlpService/ListDeidentifyTemplates")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDeidentifyTemplatesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDeidentifyTemplatesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteDeidentifyTemplateRequest, Empty>
      deleteDeidentifyTemplateMethodDescriptor =
          MethodDescriptor.<DeleteDeidentifyTemplateRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.privacy.dlp.v2.DlpService/DeleteDeidentifyTemplate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteDeidentifyTemplateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateJobTriggerRequest, JobTrigger>
      createJobTriggerMethodDescriptor =
          MethodDescriptor.<CreateJobTriggerRequest, JobTrigger>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.privacy.dlp.v2.DlpService/CreateJobTrigger")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateJobTriggerRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(JobTrigger.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateJobTriggerRequest, JobTrigger>
      updateJobTriggerMethodDescriptor =
          MethodDescriptor.<UpdateJobTriggerRequest, JobTrigger>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.privacy.dlp.v2.DlpService/UpdateJobTrigger")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateJobTriggerRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(JobTrigger.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<HybridInspectJobTriggerRequest, HybridInspectResponse>
      hybridInspectJobTriggerMethodDescriptor =
          MethodDescriptor.<HybridInspectJobTriggerRequest, HybridInspectResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.privacy.dlp.v2.DlpService/HybridInspectJobTrigger")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(HybridInspectJobTriggerRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(HybridInspectResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetJobTriggerRequest, JobTrigger>
      getJobTriggerMethodDescriptor =
          MethodDescriptor.<GetJobTriggerRequest, JobTrigger>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.privacy.dlp.v2.DlpService/GetJobTrigger")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetJobTriggerRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(JobTrigger.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListJobTriggersRequest, ListJobTriggersResponse>
      listJobTriggersMethodDescriptor =
          MethodDescriptor.<ListJobTriggersRequest, ListJobTriggersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.privacy.dlp.v2.DlpService/ListJobTriggers")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListJobTriggersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListJobTriggersResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteJobTriggerRequest, Empty>
      deleteJobTriggerMethodDescriptor =
          MethodDescriptor.<DeleteJobTriggerRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.privacy.dlp.v2.DlpService/DeleteJobTrigger")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteJobTriggerRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ActivateJobTriggerRequest, DlpJob>
      activateJobTriggerMethodDescriptor =
          MethodDescriptor.<ActivateJobTriggerRequest, DlpJob>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.privacy.dlp.v2.DlpService/ActivateJobTrigger")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ActivateJobTriggerRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DlpJob.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateDiscoveryConfigRequest, DiscoveryConfig>
      createDiscoveryConfigMethodDescriptor =
          MethodDescriptor.<CreateDiscoveryConfigRequest, DiscoveryConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.privacy.dlp.v2.DlpService/CreateDiscoveryConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateDiscoveryConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DiscoveryConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateDiscoveryConfigRequest, DiscoveryConfig>
      updateDiscoveryConfigMethodDescriptor =
          MethodDescriptor.<UpdateDiscoveryConfigRequest, DiscoveryConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.privacy.dlp.v2.DlpService/UpdateDiscoveryConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateDiscoveryConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DiscoveryConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetDiscoveryConfigRequest, DiscoveryConfig>
      getDiscoveryConfigMethodDescriptor =
          MethodDescriptor.<GetDiscoveryConfigRequest, DiscoveryConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.privacy.dlp.v2.DlpService/GetDiscoveryConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetDiscoveryConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DiscoveryConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListDiscoveryConfigsRequest, ListDiscoveryConfigsResponse>
      listDiscoveryConfigsMethodDescriptor =
          MethodDescriptor.<ListDiscoveryConfigsRequest, ListDiscoveryConfigsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.privacy.dlp.v2.DlpService/ListDiscoveryConfigs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDiscoveryConfigsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDiscoveryConfigsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteDiscoveryConfigRequest, Empty>
      deleteDiscoveryConfigMethodDescriptor =
          MethodDescriptor.<DeleteDiscoveryConfigRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.privacy.dlp.v2.DlpService/DeleteDiscoveryConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteDiscoveryConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateDlpJobRequest, DlpJob> createDlpJobMethodDescriptor =
      MethodDescriptor.<CreateDlpJobRequest, DlpJob>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.privacy.dlp.v2.DlpService/CreateDlpJob")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateDlpJobRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(DlpJob.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListDlpJobsRequest, ListDlpJobsResponse>
      listDlpJobsMethodDescriptor =
          MethodDescriptor.<ListDlpJobsRequest, ListDlpJobsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.privacy.dlp.v2.DlpService/ListDlpJobs")
              .setRequestMarshaller(ProtoUtils.marshaller(ListDlpJobsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDlpJobsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetDlpJobRequest, DlpJob> getDlpJobMethodDescriptor =
      MethodDescriptor.<GetDlpJobRequest, DlpJob>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.privacy.dlp.v2.DlpService/GetDlpJob")
          .setRequestMarshaller(ProtoUtils.marshaller(GetDlpJobRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(DlpJob.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteDlpJobRequest, Empty> deleteDlpJobMethodDescriptor =
      MethodDescriptor.<DeleteDlpJobRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.privacy.dlp.v2.DlpService/DeleteDlpJob")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteDlpJobRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CancelDlpJobRequest, Empty> cancelDlpJobMethodDescriptor =
      MethodDescriptor.<CancelDlpJobRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.privacy.dlp.v2.DlpService/CancelDlpJob")
          .setRequestMarshaller(ProtoUtils.marshaller(CancelDlpJobRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateStoredInfoTypeRequest, StoredInfoType>
      createStoredInfoTypeMethodDescriptor =
          MethodDescriptor.<CreateStoredInfoTypeRequest, StoredInfoType>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.privacy.dlp.v2.DlpService/CreateStoredInfoType")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateStoredInfoTypeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(StoredInfoType.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateStoredInfoTypeRequest, StoredInfoType>
      updateStoredInfoTypeMethodDescriptor =
          MethodDescriptor.<UpdateStoredInfoTypeRequest, StoredInfoType>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.privacy.dlp.v2.DlpService/UpdateStoredInfoType")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateStoredInfoTypeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(StoredInfoType.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetStoredInfoTypeRequest, StoredInfoType>
      getStoredInfoTypeMethodDescriptor =
          MethodDescriptor.<GetStoredInfoTypeRequest, StoredInfoType>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.privacy.dlp.v2.DlpService/GetStoredInfoType")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetStoredInfoTypeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(StoredInfoType.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListStoredInfoTypesRequest, ListStoredInfoTypesResponse>
      listStoredInfoTypesMethodDescriptor =
          MethodDescriptor.<ListStoredInfoTypesRequest, ListStoredInfoTypesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.privacy.dlp.v2.DlpService/ListStoredInfoTypes")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListStoredInfoTypesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListStoredInfoTypesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteStoredInfoTypeRequest, Empty>
      deleteStoredInfoTypeMethodDescriptor =
          MethodDescriptor.<DeleteStoredInfoTypeRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.privacy.dlp.v2.DlpService/DeleteStoredInfoType")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteStoredInfoTypeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListProjectDataProfilesRequest, ListProjectDataProfilesResponse>
      listProjectDataProfilesMethodDescriptor =
          MethodDescriptor
              .<ListProjectDataProfilesRequest, ListProjectDataProfilesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.privacy.dlp.v2.DlpService/ListProjectDataProfiles")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListProjectDataProfilesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListProjectDataProfilesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListTableDataProfilesRequest, ListTableDataProfilesResponse>
      listTableDataProfilesMethodDescriptor =
          MethodDescriptor.<ListTableDataProfilesRequest, ListTableDataProfilesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.privacy.dlp.v2.DlpService/ListTableDataProfiles")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListTableDataProfilesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListTableDataProfilesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListColumnDataProfilesRequest, ListColumnDataProfilesResponse>
      listColumnDataProfilesMethodDescriptor =
          MethodDescriptor
              .<ListColumnDataProfilesRequest, ListColumnDataProfilesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.privacy.dlp.v2.DlpService/ListColumnDataProfiles")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListColumnDataProfilesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListColumnDataProfilesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetProjectDataProfileRequest, ProjectDataProfile>
      getProjectDataProfileMethodDescriptor =
          MethodDescriptor.<GetProjectDataProfileRequest, ProjectDataProfile>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.privacy.dlp.v2.DlpService/GetProjectDataProfile")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetProjectDataProfileRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ProjectDataProfile.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetTableDataProfileRequest, TableDataProfile>
      getTableDataProfileMethodDescriptor =
          MethodDescriptor.<GetTableDataProfileRequest, TableDataProfile>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.privacy.dlp.v2.DlpService/GetTableDataProfile")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetTableDataProfileRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(TableDataProfile.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetColumnDataProfileRequest, ColumnDataProfile>
      getColumnDataProfileMethodDescriptor =
          MethodDescriptor.<GetColumnDataProfileRequest, ColumnDataProfile>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.privacy.dlp.v2.DlpService/GetColumnDataProfile")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetColumnDataProfileRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ColumnDataProfile.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteTableDataProfileRequest, Empty>
      deleteTableDataProfileMethodDescriptor =
          MethodDescriptor.<DeleteTableDataProfileRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.privacy.dlp.v2.DlpService/DeleteTableDataProfile")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteTableDataProfileRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<HybridInspectDlpJobRequest, HybridInspectResponse>
      hybridInspectDlpJobMethodDescriptor =
          MethodDescriptor.<HybridInspectDlpJobRequest, HybridInspectResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.privacy.dlp.v2.DlpService/HybridInspectDlpJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(HybridInspectDlpJobRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(HybridInspectResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<FinishDlpJobRequest, Empty> finishDlpJobMethodDescriptor =
      MethodDescriptor.<FinishDlpJobRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.privacy.dlp.v2.DlpService/FinishDlpJob")
          .setRequestMarshaller(ProtoUtils.marshaller(FinishDlpJobRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateConnectionRequest, Connection>
      createConnectionMethodDescriptor =
          MethodDescriptor.<CreateConnectionRequest, Connection>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.privacy.dlp.v2.DlpService/CreateConnection")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateConnectionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Connection.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetConnectionRequest, Connection>
      getConnectionMethodDescriptor =
          MethodDescriptor.<GetConnectionRequest, Connection>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.privacy.dlp.v2.DlpService/GetConnection")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetConnectionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Connection.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListConnectionsRequest, ListConnectionsResponse>
      listConnectionsMethodDescriptor =
          MethodDescriptor.<ListConnectionsRequest, ListConnectionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.privacy.dlp.v2.DlpService/ListConnections")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListConnectionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListConnectionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SearchConnectionsRequest, SearchConnectionsResponse>
      searchConnectionsMethodDescriptor =
          MethodDescriptor.<SearchConnectionsRequest, SearchConnectionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.privacy.dlp.v2.DlpService/SearchConnections")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SearchConnectionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SearchConnectionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteConnectionRequest, Empty>
      deleteConnectionMethodDescriptor =
          MethodDescriptor.<DeleteConnectionRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.privacy.dlp.v2.DlpService/DeleteConnection")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteConnectionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateConnectionRequest, Connection>
      updateConnectionMethodDescriptor =
          MethodDescriptor.<UpdateConnectionRequest, Connection>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.privacy.dlp.v2.DlpService/UpdateConnection")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateConnectionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Connection.getDefaultInstance()))
              .build();

  private final UnaryCallable<InspectContentRequest, InspectContentResponse> inspectContentCallable;
  private final UnaryCallable<RedactImageRequest, RedactImageResponse> redactImageCallable;
  private final UnaryCallable<DeidentifyContentRequest, DeidentifyContentResponse>
      deidentifyContentCallable;
  private final UnaryCallable<ReidentifyContentRequest, ReidentifyContentResponse>
      reidentifyContentCallable;
  private final UnaryCallable<ListInfoTypesRequest, ListInfoTypesResponse> listInfoTypesCallable;
  private final UnaryCallable<CreateInspectTemplateRequest, InspectTemplate>
      createInspectTemplateCallable;
  private final UnaryCallable<UpdateInspectTemplateRequest, InspectTemplate>
      updateInspectTemplateCallable;
  private final UnaryCallable<GetInspectTemplateRequest, InspectTemplate>
      getInspectTemplateCallable;
  private final UnaryCallable<ListInspectTemplatesRequest, ListInspectTemplatesResponse>
      listInspectTemplatesCallable;
  private final UnaryCallable<ListInspectTemplatesRequest, ListInspectTemplatesPagedResponse>
      listInspectTemplatesPagedCallable;
  private final UnaryCallable<DeleteInspectTemplateRequest, Empty> deleteInspectTemplateCallable;
  private final UnaryCallable<CreateDeidentifyTemplateRequest, DeidentifyTemplate>
      createDeidentifyTemplateCallable;
  private final UnaryCallable<UpdateDeidentifyTemplateRequest, DeidentifyTemplate>
      updateDeidentifyTemplateCallable;
  private final UnaryCallable<GetDeidentifyTemplateRequest, DeidentifyTemplate>
      getDeidentifyTemplateCallable;
  private final UnaryCallable<ListDeidentifyTemplatesRequest, ListDeidentifyTemplatesResponse>
      listDeidentifyTemplatesCallable;
  private final UnaryCallable<ListDeidentifyTemplatesRequest, ListDeidentifyTemplatesPagedResponse>
      listDeidentifyTemplatesPagedCallable;
  private final UnaryCallable<DeleteDeidentifyTemplateRequest, Empty>
      deleteDeidentifyTemplateCallable;
  private final UnaryCallable<CreateJobTriggerRequest, JobTrigger> createJobTriggerCallable;
  private final UnaryCallable<UpdateJobTriggerRequest, JobTrigger> updateJobTriggerCallable;
  private final UnaryCallable<HybridInspectJobTriggerRequest, HybridInspectResponse>
      hybridInspectJobTriggerCallable;
  private final UnaryCallable<GetJobTriggerRequest, JobTrigger> getJobTriggerCallable;
  private final UnaryCallable<ListJobTriggersRequest, ListJobTriggersResponse>
      listJobTriggersCallable;
  private final UnaryCallable<ListJobTriggersRequest, ListJobTriggersPagedResponse>
      listJobTriggersPagedCallable;
  private final UnaryCallable<DeleteJobTriggerRequest, Empty> deleteJobTriggerCallable;
  private final UnaryCallable<ActivateJobTriggerRequest, DlpJob> activateJobTriggerCallable;
  private final UnaryCallable<CreateDiscoveryConfigRequest, DiscoveryConfig>
      createDiscoveryConfigCallable;
  private final UnaryCallable<UpdateDiscoveryConfigRequest, DiscoveryConfig>
      updateDiscoveryConfigCallable;
  private final UnaryCallable<GetDiscoveryConfigRequest, DiscoveryConfig>
      getDiscoveryConfigCallable;
  private final UnaryCallable<ListDiscoveryConfigsRequest, ListDiscoveryConfigsResponse>
      listDiscoveryConfigsCallable;
  private final UnaryCallable<ListDiscoveryConfigsRequest, ListDiscoveryConfigsPagedResponse>
      listDiscoveryConfigsPagedCallable;
  private final UnaryCallable<DeleteDiscoveryConfigRequest, Empty> deleteDiscoveryConfigCallable;
  private final UnaryCallable<CreateDlpJobRequest, DlpJob> createDlpJobCallable;
  private final UnaryCallable<ListDlpJobsRequest, ListDlpJobsResponse> listDlpJobsCallable;
  private final UnaryCallable<ListDlpJobsRequest, ListDlpJobsPagedResponse>
      listDlpJobsPagedCallable;
  private final UnaryCallable<GetDlpJobRequest, DlpJob> getDlpJobCallable;
  private final UnaryCallable<DeleteDlpJobRequest, Empty> deleteDlpJobCallable;
  private final UnaryCallable<CancelDlpJobRequest, Empty> cancelDlpJobCallable;
  private final UnaryCallable<CreateStoredInfoTypeRequest, StoredInfoType>
      createStoredInfoTypeCallable;
  private final UnaryCallable<UpdateStoredInfoTypeRequest, StoredInfoType>
      updateStoredInfoTypeCallable;
  private final UnaryCallable<GetStoredInfoTypeRequest, StoredInfoType> getStoredInfoTypeCallable;
  private final UnaryCallable<ListStoredInfoTypesRequest, ListStoredInfoTypesResponse>
      listStoredInfoTypesCallable;
  private final UnaryCallable<ListStoredInfoTypesRequest, ListStoredInfoTypesPagedResponse>
      listStoredInfoTypesPagedCallable;
  private final UnaryCallable<DeleteStoredInfoTypeRequest, Empty> deleteStoredInfoTypeCallable;
  private final UnaryCallable<ListProjectDataProfilesRequest, ListProjectDataProfilesResponse>
      listProjectDataProfilesCallable;
  private final UnaryCallable<ListProjectDataProfilesRequest, ListProjectDataProfilesPagedResponse>
      listProjectDataProfilesPagedCallable;
  private final UnaryCallable<ListTableDataProfilesRequest, ListTableDataProfilesResponse>
      listTableDataProfilesCallable;
  private final UnaryCallable<ListTableDataProfilesRequest, ListTableDataProfilesPagedResponse>
      listTableDataProfilesPagedCallable;
  private final UnaryCallable<ListColumnDataProfilesRequest, ListColumnDataProfilesResponse>
      listColumnDataProfilesCallable;
  private final UnaryCallable<ListColumnDataProfilesRequest, ListColumnDataProfilesPagedResponse>
      listColumnDataProfilesPagedCallable;
  private final UnaryCallable<GetProjectDataProfileRequest, ProjectDataProfile>
      getProjectDataProfileCallable;
  private final UnaryCallable<GetTableDataProfileRequest, TableDataProfile>
      getTableDataProfileCallable;
  private final UnaryCallable<GetColumnDataProfileRequest, ColumnDataProfile>
      getColumnDataProfileCallable;
  private final UnaryCallable<DeleteTableDataProfileRequest, Empty> deleteTableDataProfileCallable;
  private final UnaryCallable<HybridInspectDlpJobRequest, HybridInspectResponse>
      hybridInspectDlpJobCallable;
  private final UnaryCallable<FinishDlpJobRequest, Empty> finishDlpJobCallable;
  private final UnaryCallable<CreateConnectionRequest, Connection> createConnectionCallable;
  private final UnaryCallable<GetConnectionRequest, Connection> getConnectionCallable;
  private final UnaryCallable<ListConnectionsRequest, ListConnectionsResponse>
      listConnectionsCallable;
  private final UnaryCallable<ListConnectionsRequest, ListConnectionsPagedResponse>
      listConnectionsPagedCallable;
  private final UnaryCallable<SearchConnectionsRequest, SearchConnectionsResponse>
      searchConnectionsCallable;
  private final UnaryCallable<SearchConnectionsRequest, SearchConnectionsPagedResponse>
      searchConnectionsPagedCallable;
  private final UnaryCallable<DeleteConnectionRequest, Empty> deleteConnectionCallable;
  private final UnaryCallable<UpdateConnectionRequest, Connection> updateConnectionCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcDlpServiceStub create(DlpServiceStubSettings settings)
      throws IOException {
    return new GrpcDlpServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcDlpServiceStub create(ClientContext clientContext) throws IOException {
    return new GrpcDlpServiceStub(DlpServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcDlpServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcDlpServiceStub(
        DlpServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcDlpServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcDlpServiceStub(DlpServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcDlpServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcDlpServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcDlpServiceStub(
      DlpServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<InspectContentRequest, InspectContentResponse>
        inspectContentTransportSettings =
            GrpcCallSettings.<InspectContentRequest, InspectContentResponse>newBuilder()
                .setMethodDescriptor(inspectContentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<RedactImageRequest, RedactImageResponse> redactImageTransportSettings =
        GrpcCallSettings.<RedactImageRequest, RedactImageResponse>newBuilder()
            .setMethodDescriptor(redactImageMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeidentifyContentRequest, DeidentifyContentResponse>
        deidentifyContentTransportSettings =
            GrpcCallSettings.<DeidentifyContentRequest, DeidentifyContentResponse>newBuilder()
                .setMethodDescriptor(deidentifyContentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ReidentifyContentRequest, ReidentifyContentResponse>
        reidentifyContentTransportSettings =
            GrpcCallSettings.<ReidentifyContentRequest, ReidentifyContentResponse>newBuilder()
                .setMethodDescriptor(reidentifyContentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListInfoTypesRequest, ListInfoTypesResponse> listInfoTypesTransportSettings =
        GrpcCallSettings.<ListInfoTypesRequest, ListInfoTypesResponse>newBuilder()
            .setMethodDescriptor(listInfoTypesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateInspectTemplateRequest, InspectTemplate>
        createInspectTemplateTransportSettings =
            GrpcCallSettings.<CreateInspectTemplateRequest, InspectTemplate>newBuilder()
                .setMethodDescriptor(createInspectTemplateMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateInspectTemplateRequest, InspectTemplate>
        updateInspectTemplateTransportSettings =
            GrpcCallSettings.<UpdateInspectTemplateRequest, InspectTemplate>newBuilder()
                .setMethodDescriptor(updateInspectTemplateMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetInspectTemplateRequest, InspectTemplate>
        getInspectTemplateTransportSettings =
            GrpcCallSettings.<GetInspectTemplateRequest, InspectTemplate>newBuilder()
                .setMethodDescriptor(getInspectTemplateMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListInspectTemplatesRequest, ListInspectTemplatesResponse>
        listInspectTemplatesTransportSettings =
            GrpcCallSettings.<ListInspectTemplatesRequest, ListInspectTemplatesResponse>newBuilder()
                .setMethodDescriptor(listInspectTemplatesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteInspectTemplateRequest, Empty> deleteInspectTemplateTransportSettings =
        GrpcCallSettings.<DeleteInspectTemplateRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteInspectTemplateMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateDeidentifyTemplateRequest, DeidentifyTemplate>
        createDeidentifyTemplateTransportSettings =
            GrpcCallSettings.<CreateDeidentifyTemplateRequest, DeidentifyTemplate>newBuilder()
                .setMethodDescriptor(createDeidentifyTemplateMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateDeidentifyTemplateRequest, DeidentifyTemplate>
        updateDeidentifyTemplateTransportSettings =
            GrpcCallSettings.<UpdateDeidentifyTemplateRequest, DeidentifyTemplate>newBuilder()
                .setMethodDescriptor(updateDeidentifyTemplateMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetDeidentifyTemplateRequest, DeidentifyTemplate>
        getDeidentifyTemplateTransportSettings =
            GrpcCallSettings.<GetDeidentifyTemplateRequest, DeidentifyTemplate>newBuilder()
                .setMethodDescriptor(getDeidentifyTemplateMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListDeidentifyTemplatesRequest, ListDeidentifyTemplatesResponse>
        listDeidentifyTemplatesTransportSettings =
            GrpcCallSettings
                .<ListDeidentifyTemplatesRequest, ListDeidentifyTemplatesResponse>newBuilder()
                .setMethodDescriptor(listDeidentifyTemplatesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteDeidentifyTemplateRequest, Empty>
        deleteDeidentifyTemplateTransportSettings =
            GrpcCallSettings.<DeleteDeidentifyTemplateRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteDeidentifyTemplateMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateJobTriggerRequest, JobTrigger> createJobTriggerTransportSettings =
        GrpcCallSettings.<CreateJobTriggerRequest, JobTrigger>newBuilder()
            .setMethodDescriptor(createJobTriggerMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateJobTriggerRequest, JobTrigger> updateJobTriggerTransportSettings =
        GrpcCallSettings.<UpdateJobTriggerRequest, JobTrigger>newBuilder()
            .setMethodDescriptor(updateJobTriggerMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<HybridInspectJobTriggerRequest, HybridInspectResponse>
        hybridInspectJobTriggerTransportSettings =
            GrpcCallSettings.<HybridInspectJobTriggerRequest, HybridInspectResponse>newBuilder()
                .setMethodDescriptor(hybridInspectJobTriggerMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetJobTriggerRequest, JobTrigger> getJobTriggerTransportSettings =
        GrpcCallSettings.<GetJobTriggerRequest, JobTrigger>newBuilder()
            .setMethodDescriptor(getJobTriggerMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListJobTriggersRequest, ListJobTriggersResponse>
        listJobTriggersTransportSettings =
            GrpcCallSettings.<ListJobTriggersRequest, ListJobTriggersResponse>newBuilder()
                .setMethodDescriptor(listJobTriggersMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteJobTriggerRequest, Empty> deleteJobTriggerTransportSettings =
        GrpcCallSettings.<DeleteJobTriggerRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteJobTriggerMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ActivateJobTriggerRequest, DlpJob> activateJobTriggerTransportSettings =
        GrpcCallSettings.<ActivateJobTriggerRequest, DlpJob>newBuilder()
            .setMethodDescriptor(activateJobTriggerMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateDiscoveryConfigRequest, DiscoveryConfig>
        createDiscoveryConfigTransportSettings =
            GrpcCallSettings.<CreateDiscoveryConfigRequest, DiscoveryConfig>newBuilder()
                .setMethodDescriptor(createDiscoveryConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateDiscoveryConfigRequest, DiscoveryConfig>
        updateDiscoveryConfigTransportSettings =
            GrpcCallSettings.<UpdateDiscoveryConfigRequest, DiscoveryConfig>newBuilder()
                .setMethodDescriptor(updateDiscoveryConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetDiscoveryConfigRequest, DiscoveryConfig>
        getDiscoveryConfigTransportSettings =
            GrpcCallSettings.<GetDiscoveryConfigRequest, DiscoveryConfig>newBuilder()
                .setMethodDescriptor(getDiscoveryConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListDiscoveryConfigsRequest, ListDiscoveryConfigsResponse>
        listDiscoveryConfigsTransportSettings =
            GrpcCallSettings.<ListDiscoveryConfigsRequest, ListDiscoveryConfigsResponse>newBuilder()
                .setMethodDescriptor(listDiscoveryConfigsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteDiscoveryConfigRequest, Empty> deleteDiscoveryConfigTransportSettings =
        GrpcCallSettings.<DeleteDiscoveryConfigRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteDiscoveryConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateDlpJobRequest, DlpJob> createDlpJobTransportSettings =
        GrpcCallSettings.<CreateDlpJobRequest, DlpJob>newBuilder()
            .setMethodDescriptor(createDlpJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListDlpJobsRequest, ListDlpJobsResponse> listDlpJobsTransportSettings =
        GrpcCallSettings.<ListDlpJobsRequest, ListDlpJobsResponse>newBuilder()
            .setMethodDescriptor(listDlpJobsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetDlpJobRequest, DlpJob> getDlpJobTransportSettings =
        GrpcCallSettings.<GetDlpJobRequest, DlpJob>newBuilder()
            .setMethodDescriptor(getDlpJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteDlpJobRequest, Empty> deleteDlpJobTransportSettings =
        GrpcCallSettings.<DeleteDlpJobRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteDlpJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CancelDlpJobRequest, Empty> cancelDlpJobTransportSettings =
        GrpcCallSettings.<CancelDlpJobRequest, Empty>newBuilder()
            .setMethodDescriptor(cancelDlpJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateStoredInfoTypeRequest, StoredInfoType>
        createStoredInfoTypeTransportSettings =
            GrpcCallSettings.<CreateStoredInfoTypeRequest, StoredInfoType>newBuilder()
                .setMethodDescriptor(createStoredInfoTypeMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateStoredInfoTypeRequest, StoredInfoType>
        updateStoredInfoTypeTransportSettings =
            GrpcCallSettings.<UpdateStoredInfoTypeRequest, StoredInfoType>newBuilder()
                .setMethodDescriptor(updateStoredInfoTypeMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetStoredInfoTypeRequest, StoredInfoType> getStoredInfoTypeTransportSettings =
        GrpcCallSettings.<GetStoredInfoTypeRequest, StoredInfoType>newBuilder()
            .setMethodDescriptor(getStoredInfoTypeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListStoredInfoTypesRequest, ListStoredInfoTypesResponse>
        listStoredInfoTypesTransportSettings =
            GrpcCallSettings.<ListStoredInfoTypesRequest, ListStoredInfoTypesResponse>newBuilder()
                .setMethodDescriptor(listStoredInfoTypesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteStoredInfoTypeRequest, Empty> deleteStoredInfoTypeTransportSettings =
        GrpcCallSettings.<DeleteStoredInfoTypeRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteStoredInfoTypeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListProjectDataProfilesRequest, ListProjectDataProfilesResponse>
        listProjectDataProfilesTransportSettings =
            GrpcCallSettings
                .<ListProjectDataProfilesRequest, ListProjectDataProfilesResponse>newBuilder()
                .setMethodDescriptor(listProjectDataProfilesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListTableDataProfilesRequest, ListTableDataProfilesResponse>
        listTableDataProfilesTransportSettings =
            GrpcCallSettings
                .<ListTableDataProfilesRequest, ListTableDataProfilesResponse>newBuilder()
                .setMethodDescriptor(listTableDataProfilesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListColumnDataProfilesRequest, ListColumnDataProfilesResponse>
        listColumnDataProfilesTransportSettings =
            GrpcCallSettings
                .<ListColumnDataProfilesRequest, ListColumnDataProfilesResponse>newBuilder()
                .setMethodDescriptor(listColumnDataProfilesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetProjectDataProfileRequest, ProjectDataProfile>
        getProjectDataProfileTransportSettings =
            GrpcCallSettings.<GetProjectDataProfileRequest, ProjectDataProfile>newBuilder()
                .setMethodDescriptor(getProjectDataProfileMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetTableDataProfileRequest, TableDataProfile>
        getTableDataProfileTransportSettings =
            GrpcCallSettings.<GetTableDataProfileRequest, TableDataProfile>newBuilder()
                .setMethodDescriptor(getTableDataProfileMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetColumnDataProfileRequest, ColumnDataProfile>
        getColumnDataProfileTransportSettings =
            GrpcCallSettings.<GetColumnDataProfileRequest, ColumnDataProfile>newBuilder()
                .setMethodDescriptor(getColumnDataProfileMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteTableDataProfileRequest, Empty> deleteTableDataProfileTransportSettings =
        GrpcCallSettings.<DeleteTableDataProfileRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteTableDataProfileMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<HybridInspectDlpJobRequest, HybridInspectResponse>
        hybridInspectDlpJobTransportSettings =
            GrpcCallSettings.<HybridInspectDlpJobRequest, HybridInspectResponse>newBuilder()
                .setMethodDescriptor(hybridInspectDlpJobMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<FinishDlpJobRequest, Empty> finishDlpJobTransportSettings =
        GrpcCallSettings.<FinishDlpJobRequest, Empty>newBuilder()
            .setMethodDescriptor(finishDlpJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateConnectionRequest, Connection> createConnectionTransportSettings =
        GrpcCallSettings.<CreateConnectionRequest, Connection>newBuilder()
            .setMethodDescriptor(createConnectionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetConnectionRequest, Connection> getConnectionTransportSettings =
        GrpcCallSettings.<GetConnectionRequest, Connection>newBuilder()
            .setMethodDescriptor(getConnectionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListConnectionsRequest, ListConnectionsResponse>
        listConnectionsTransportSettings =
            GrpcCallSettings.<ListConnectionsRequest, ListConnectionsResponse>newBuilder()
                .setMethodDescriptor(listConnectionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<SearchConnectionsRequest, SearchConnectionsResponse>
        searchConnectionsTransportSettings =
            GrpcCallSettings.<SearchConnectionsRequest, SearchConnectionsResponse>newBuilder()
                .setMethodDescriptor(searchConnectionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteConnectionRequest, Empty> deleteConnectionTransportSettings =
        GrpcCallSettings.<DeleteConnectionRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteConnectionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateConnectionRequest, Connection> updateConnectionTransportSettings =
        GrpcCallSettings.<UpdateConnectionRequest, Connection>newBuilder()
            .setMethodDescriptor(updateConnectionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.inspectContentCallable =
        callableFactory.createUnaryCallable(
            inspectContentTransportSettings, settings.inspectContentSettings(), clientContext);
    this.redactImageCallable =
        callableFactory.createUnaryCallable(
            redactImageTransportSettings, settings.redactImageSettings(), clientContext);
    this.deidentifyContentCallable =
        callableFactory.createUnaryCallable(
            deidentifyContentTransportSettings,
            settings.deidentifyContentSettings(),
            clientContext);
    this.reidentifyContentCallable =
        callableFactory.createUnaryCallable(
            reidentifyContentTransportSettings,
            settings.reidentifyContentSettings(),
            clientContext);
    this.listInfoTypesCallable =
        callableFactory.createUnaryCallable(
            listInfoTypesTransportSettings, settings.listInfoTypesSettings(), clientContext);
    this.createInspectTemplateCallable =
        callableFactory.createUnaryCallable(
            createInspectTemplateTransportSettings,
            settings.createInspectTemplateSettings(),
            clientContext);
    this.updateInspectTemplateCallable =
        callableFactory.createUnaryCallable(
            updateInspectTemplateTransportSettings,
            settings.updateInspectTemplateSettings(),
            clientContext);
    this.getInspectTemplateCallable =
        callableFactory.createUnaryCallable(
            getInspectTemplateTransportSettings,
            settings.getInspectTemplateSettings(),
            clientContext);
    this.listInspectTemplatesCallable =
        callableFactory.createUnaryCallable(
            listInspectTemplatesTransportSettings,
            settings.listInspectTemplatesSettings(),
            clientContext);
    this.listInspectTemplatesPagedCallable =
        callableFactory.createPagedCallable(
            listInspectTemplatesTransportSettings,
            settings.listInspectTemplatesSettings(),
            clientContext);
    this.deleteInspectTemplateCallable =
        callableFactory.createUnaryCallable(
            deleteInspectTemplateTransportSettings,
            settings.deleteInspectTemplateSettings(),
            clientContext);
    this.createDeidentifyTemplateCallable =
        callableFactory.createUnaryCallable(
            createDeidentifyTemplateTransportSettings,
            settings.createDeidentifyTemplateSettings(),
            clientContext);
    this.updateDeidentifyTemplateCallable =
        callableFactory.createUnaryCallable(
            updateDeidentifyTemplateTransportSettings,
            settings.updateDeidentifyTemplateSettings(),
            clientContext);
    this.getDeidentifyTemplateCallable =
        callableFactory.createUnaryCallable(
            getDeidentifyTemplateTransportSettings,
            settings.getDeidentifyTemplateSettings(),
            clientContext);
    this.listDeidentifyTemplatesCallable =
        callableFactory.createUnaryCallable(
            listDeidentifyTemplatesTransportSettings,
            settings.listDeidentifyTemplatesSettings(),
            clientContext);
    this.listDeidentifyTemplatesPagedCallable =
        callableFactory.createPagedCallable(
            listDeidentifyTemplatesTransportSettings,
            settings.listDeidentifyTemplatesSettings(),
            clientContext);
    this.deleteDeidentifyTemplateCallable =
        callableFactory.createUnaryCallable(
            deleteDeidentifyTemplateTransportSettings,
            settings.deleteDeidentifyTemplateSettings(),
            clientContext);
    this.createJobTriggerCallable =
        callableFactory.createUnaryCallable(
            createJobTriggerTransportSettings, settings.createJobTriggerSettings(), clientContext);
    this.updateJobTriggerCallable =
        callableFactory.createUnaryCallable(
            updateJobTriggerTransportSettings, settings.updateJobTriggerSettings(), clientContext);
    this.hybridInspectJobTriggerCallable =
        callableFactory.createUnaryCallable(
            hybridInspectJobTriggerTransportSettings,
            settings.hybridInspectJobTriggerSettings(),
            clientContext);
    this.getJobTriggerCallable =
        callableFactory.createUnaryCallable(
            getJobTriggerTransportSettings, settings.getJobTriggerSettings(), clientContext);
    this.listJobTriggersCallable =
        callableFactory.createUnaryCallable(
            listJobTriggersTransportSettings, settings.listJobTriggersSettings(), clientContext);
    this.listJobTriggersPagedCallable =
        callableFactory.createPagedCallable(
            listJobTriggersTransportSettings, settings.listJobTriggersSettings(), clientContext);
    this.deleteJobTriggerCallable =
        callableFactory.createUnaryCallable(
            deleteJobTriggerTransportSettings, settings.deleteJobTriggerSettings(), clientContext);
    this.activateJobTriggerCallable =
        callableFactory.createUnaryCallable(
            activateJobTriggerTransportSettings,
            settings.activateJobTriggerSettings(),
            clientContext);
    this.createDiscoveryConfigCallable =
        callableFactory.createUnaryCallable(
            createDiscoveryConfigTransportSettings,
            settings.createDiscoveryConfigSettings(),
            clientContext);
    this.updateDiscoveryConfigCallable =
        callableFactory.createUnaryCallable(
            updateDiscoveryConfigTransportSettings,
            settings.updateDiscoveryConfigSettings(),
            clientContext);
    this.getDiscoveryConfigCallable =
        callableFactory.createUnaryCallable(
            getDiscoveryConfigTransportSettings,
            settings.getDiscoveryConfigSettings(),
            clientContext);
    this.listDiscoveryConfigsCallable =
        callableFactory.createUnaryCallable(
            listDiscoveryConfigsTransportSettings,
            settings.listDiscoveryConfigsSettings(),
            clientContext);
    this.listDiscoveryConfigsPagedCallable =
        callableFactory.createPagedCallable(
            listDiscoveryConfigsTransportSettings,
            settings.listDiscoveryConfigsSettings(),
            clientContext);
    this.deleteDiscoveryConfigCallable =
        callableFactory.createUnaryCallable(
            deleteDiscoveryConfigTransportSettings,
            settings.deleteDiscoveryConfigSettings(),
            clientContext);
    this.createDlpJobCallable =
        callableFactory.createUnaryCallable(
            createDlpJobTransportSettings, settings.createDlpJobSettings(), clientContext);
    this.listDlpJobsCallable =
        callableFactory.createUnaryCallable(
            listDlpJobsTransportSettings, settings.listDlpJobsSettings(), clientContext);
    this.listDlpJobsPagedCallable =
        callableFactory.createPagedCallable(
            listDlpJobsTransportSettings, settings.listDlpJobsSettings(), clientContext);
    this.getDlpJobCallable =
        callableFactory.createUnaryCallable(
            getDlpJobTransportSettings, settings.getDlpJobSettings(), clientContext);
    this.deleteDlpJobCallable =
        callableFactory.createUnaryCallable(
            deleteDlpJobTransportSettings, settings.deleteDlpJobSettings(), clientContext);
    this.cancelDlpJobCallable =
        callableFactory.createUnaryCallable(
            cancelDlpJobTransportSettings, settings.cancelDlpJobSettings(), clientContext);
    this.createStoredInfoTypeCallable =
        callableFactory.createUnaryCallable(
            createStoredInfoTypeTransportSettings,
            settings.createStoredInfoTypeSettings(),
            clientContext);
    this.updateStoredInfoTypeCallable =
        callableFactory.createUnaryCallable(
            updateStoredInfoTypeTransportSettings,
            settings.updateStoredInfoTypeSettings(),
            clientContext);
    this.getStoredInfoTypeCallable =
        callableFactory.createUnaryCallable(
            getStoredInfoTypeTransportSettings,
            settings.getStoredInfoTypeSettings(),
            clientContext);
    this.listStoredInfoTypesCallable =
        callableFactory.createUnaryCallable(
            listStoredInfoTypesTransportSettings,
            settings.listStoredInfoTypesSettings(),
            clientContext);
    this.listStoredInfoTypesPagedCallable =
        callableFactory.createPagedCallable(
            listStoredInfoTypesTransportSettings,
            settings.listStoredInfoTypesSettings(),
            clientContext);
    this.deleteStoredInfoTypeCallable =
        callableFactory.createUnaryCallable(
            deleteStoredInfoTypeTransportSettings,
            settings.deleteStoredInfoTypeSettings(),
            clientContext);
    this.listProjectDataProfilesCallable =
        callableFactory.createUnaryCallable(
            listProjectDataProfilesTransportSettings,
            settings.listProjectDataProfilesSettings(),
            clientContext);
    this.listProjectDataProfilesPagedCallable =
        callableFactory.createPagedCallable(
            listProjectDataProfilesTransportSettings,
            settings.listProjectDataProfilesSettings(),
            clientContext);
    this.listTableDataProfilesCallable =
        callableFactory.createUnaryCallable(
            listTableDataProfilesTransportSettings,
            settings.listTableDataProfilesSettings(),
            clientContext);
    this.listTableDataProfilesPagedCallable =
        callableFactory.createPagedCallable(
            listTableDataProfilesTransportSettings,
            settings.listTableDataProfilesSettings(),
            clientContext);
    this.listColumnDataProfilesCallable =
        callableFactory.createUnaryCallable(
            listColumnDataProfilesTransportSettings,
            settings.listColumnDataProfilesSettings(),
            clientContext);
    this.listColumnDataProfilesPagedCallable =
        callableFactory.createPagedCallable(
            listColumnDataProfilesTransportSettings,
            settings.listColumnDataProfilesSettings(),
            clientContext);
    this.getProjectDataProfileCallable =
        callableFactory.createUnaryCallable(
            getProjectDataProfileTransportSettings,
            settings.getProjectDataProfileSettings(),
            clientContext);
    this.getTableDataProfileCallable =
        callableFactory.createUnaryCallable(
            getTableDataProfileTransportSettings,
            settings.getTableDataProfileSettings(),
            clientContext);
    this.getColumnDataProfileCallable =
        callableFactory.createUnaryCallable(
            getColumnDataProfileTransportSettings,
            settings.getColumnDataProfileSettings(),
            clientContext);
    this.deleteTableDataProfileCallable =
        callableFactory.createUnaryCallable(
            deleteTableDataProfileTransportSettings,
            settings.deleteTableDataProfileSettings(),
            clientContext);
    this.hybridInspectDlpJobCallable =
        callableFactory.createUnaryCallable(
            hybridInspectDlpJobTransportSettings,
            settings.hybridInspectDlpJobSettings(),
            clientContext);
    this.finishDlpJobCallable =
        callableFactory.createUnaryCallable(
            finishDlpJobTransportSettings, settings.finishDlpJobSettings(), clientContext);
    this.createConnectionCallable =
        callableFactory.createUnaryCallable(
            createConnectionTransportSettings, settings.createConnectionSettings(), clientContext);
    this.getConnectionCallable =
        callableFactory.createUnaryCallable(
            getConnectionTransportSettings, settings.getConnectionSettings(), clientContext);
    this.listConnectionsCallable =
        callableFactory.createUnaryCallable(
            listConnectionsTransportSettings, settings.listConnectionsSettings(), clientContext);
    this.listConnectionsPagedCallable =
        callableFactory.createPagedCallable(
            listConnectionsTransportSettings, settings.listConnectionsSettings(), clientContext);
    this.searchConnectionsCallable =
        callableFactory.createUnaryCallable(
            searchConnectionsTransportSettings,
            settings.searchConnectionsSettings(),
            clientContext);
    this.searchConnectionsPagedCallable =
        callableFactory.createPagedCallable(
            searchConnectionsTransportSettings,
            settings.searchConnectionsSettings(),
            clientContext);
    this.deleteConnectionCallable =
        callableFactory.createUnaryCallable(
            deleteConnectionTransportSettings, settings.deleteConnectionSettings(), clientContext);
    this.updateConnectionCallable =
        callableFactory.createUnaryCallable(
            updateConnectionTransportSettings, settings.updateConnectionSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<InspectContentRequest, InspectContentResponse> inspectContentCallable() {
    return inspectContentCallable;
  }

  @Override
  public UnaryCallable<RedactImageRequest, RedactImageResponse> redactImageCallable() {
    return redactImageCallable;
  }

  @Override
  public UnaryCallable<DeidentifyContentRequest, DeidentifyContentResponse>
      deidentifyContentCallable() {
    return deidentifyContentCallable;
  }

  @Override
  public UnaryCallable<ReidentifyContentRequest, ReidentifyContentResponse>
      reidentifyContentCallable() {
    return reidentifyContentCallable;
  }

  @Override
  public UnaryCallable<ListInfoTypesRequest, ListInfoTypesResponse> listInfoTypesCallable() {
    return listInfoTypesCallable;
  }

  @Override
  public UnaryCallable<CreateInspectTemplateRequest, InspectTemplate>
      createInspectTemplateCallable() {
    return createInspectTemplateCallable;
  }

  @Override
  public UnaryCallable<UpdateInspectTemplateRequest, InspectTemplate>
      updateInspectTemplateCallable() {
    return updateInspectTemplateCallable;
  }

  @Override
  public UnaryCallable<GetInspectTemplateRequest, InspectTemplate> getInspectTemplateCallable() {
    return getInspectTemplateCallable;
  }

  @Override
  public UnaryCallable<ListInspectTemplatesRequest, ListInspectTemplatesResponse>
      listInspectTemplatesCallable() {
    return listInspectTemplatesCallable;
  }

  @Override
  public UnaryCallable<ListInspectTemplatesRequest, ListInspectTemplatesPagedResponse>
      listInspectTemplatesPagedCallable() {
    return listInspectTemplatesPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteInspectTemplateRequest, Empty> deleteInspectTemplateCallable() {
    return deleteInspectTemplateCallable;
  }

  @Override
  public UnaryCallable<CreateDeidentifyTemplateRequest, DeidentifyTemplate>
      createDeidentifyTemplateCallable() {
    return createDeidentifyTemplateCallable;
  }

  @Override
  public UnaryCallable<UpdateDeidentifyTemplateRequest, DeidentifyTemplate>
      updateDeidentifyTemplateCallable() {
    return updateDeidentifyTemplateCallable;
  }

  @Override
  public UnaryCallable<GetDeidentifyTemplateRequest, DeidentifyTemplate>
      getDeidentifyTemplateCallable() {
    return getDeidentifyTemplateCallable;
  }

  @Override
  public UnaryCallable<ListDeidentifyTemplatesRequest, ListDeidentifyTemplatesResponse>
      listDeidentifyTemplatesCallable() {
    return listDeidentifyTemplatesCallable;
  }

  @Override
  public UnaryCallable<ListDeidentifyTemplatesRequest, ListDeidentifyTemplatesPagedResponse>
      listDeidentifyTemplatesPagedCallable() {
    return listDeidentifyTemplatesPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteDeidentifyTemplateRequest, Empty> deleteDeidentifyTemplateCallable() {
    return deleteDeidentifyTemplateCallable;
  }

  @Override
  public UnaryCallable<CreateJobTriggerRequest, JobTrigger> createJobTriggerCallable() {
    return createJobTriggerCallable;
  }

  @Override
  public UnaryCallable<UpdateJobTriggerRequest, JobTrigger> updateJobTriggerCallable() {
    return updateJobTriggerCallable;
  }

  @Override
  public UnaryCallable<HybridInspectJobTriggerRequest, HybridInspectResponse>
      hybridInspectJobTriggerCallable() {
    return hybridInspectJobTriggerCallable;
  }

  @Override
  public UnaryCallable<GetJobTriggerRequest, JobTrigger> getJobTriggerCallable() {
    return getJobTriggerCallable;
  }

  @Override
  public UnaryCallable<ListJobTriggersRequest, ListJobTriggersResponse> listJobTriggersCallable() {
    return listJobTriggersCallable;
  }

  @Override
  public UnaryCallable<ListJobTriggersRequest, ListJobTriggersPagedResponse>
      listJobTriggersPagedCallable() {
    return listJobTriggersPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteJobTriggerRequest, Empty> deleteJobTriggerCallable() {
    return deleteJobTriggerCallable;
  }

  @Override
  public UnaryCallable<ActivateJobTriggerRequest, DlpJob> activateJobTriggerCallable() {
    return activateJobTriggerCallable;
  }

  @Override
  public UnaryCallable<CreateDiscoveryConfigRequest, DiscoveryConfig>
      createDiscoveryConfigCallable() {
    return createDiscoveryConfigCallable;
  }

  @Override
  public UnaryCallable<UpdateDiscoveryConfigRequest, DiscoveryConfig>
      updateDiscoveryConfigCallable() {
    return updateDiscoveryConfigCallable;
  }

  @Override
  public UnaryCallable<GetDiscoveryConfigRequest, DiscoveryConfig> getDiscoveryConfigCallable() {
    return getDiscoveryConfigCallable;
  }

  @Override
  public UnaryCallable<ListDiscoveryConfigsRequest, ListDiscoveryConfigsResponse>
      listDiscoveryConfigsCallable() {
    return listDiscoveryConfigsCallable;
  }

  @Override
  public UnaryCallable<ListDiscoveryConfigsRequest, ListDiscoveryConfigsPagedResponse>
      listDiscoveryConfigsPagedCallable() {
    return listDiscoveryConfigsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteDiscoveryConfigRequest, Empty> deleteDiscoveryConfigCallable() {
    return deleteDiscoveryConfigCallable;
  }

  @Override
  public UnaryCallable<CreateDlpJobRequest, DlpJob> createDlpJobCallable() {
    return createDlpJobCallable;
  }

  @Override
  public UnaryCallable<ListDlpJobsRequest, ListDlpJobsResponse> listDlpJobsCallable() {
    return listDlpJobsCallable;
  }

  @Override
  public UnaryCallable<ListDlpJobsRequest, ListDlpJobsPagedResponse> listDlpJobsPagedCallable() {
    return listDlpJobsPagedCallable;
  }

  @Override
  public UnaryCallable<GetDlpJobRequest, DlpJob> getDlpJobCallable() {
    return getDlpJobCallable;
  }

  @Override
  public UnaryCallable<DeleteDlpJobRequest, Empty> deleteDlpJobCallable() {
    return deleteDlpJobCallable;
  }

  @Override
  public UnaryCallable<CancelDlpJobRequest, Empty> cancelDlpJobCallable() {
    return cancelDlpJobCallable;
  }

  @Override
  public UnaryCallable<CreateStoredInfoTypeRequest, StoredInfoType> createStoredInfoTypeCallable() {
    return createStoredInfoTypeCallable;
  }

  @Override
  public UnaryCallable<UpdateStoredInfoTypeRequest, StoredInfoType> updateStoredInfoTypeCallable() {
    return updateStoredInfoTypeCallable;
  }

  @Override
  public UnaryCallable<GetStoredInfoTypeRequest, StoredInfoType> getStoredInfoTypeCallable() {
    return getStoredInfoTypeCallable;
  }

  @Override
  public UnaryCallable<ListStoredInfoTypesRequest, ListStoredInfoTypesResponse>
      listStoredInfoTypesCallable() {
    return listStoredInfoTypesCallable;
  }

  @Override
  public UnaryCallable<ListStoredInfoTypesRequest, ListStoredInfoTypesPagedResponse>
      listStoredInfoTypesPagedCallable() {
    return listStoredInfoTypesPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteStoredInfoTypeRequest, Empty> deleteStoredInfoTypeCallable() {
    return deleteStoredInfoTypeCallable;
  }

  @Override
  public UnaryCallable<ListProjectDataProfilesRequest, ListProjectDataProfilesResponse>
      listProjectDataProfilesCallable() {
    return listProjectDataProfilesCallable;
  }

  @Override
  public UnaryCallable<ListProjectDataProfilesRequest, ListProjectDataProfilesPagedResponse>
      listProjectDataProfilesPagedCallable() {
    return listProjectDataProfilesPagedCallable;
  }

  @Override
  public UnaryCallable<ListTableDataProfilesRequest, ListTableDataProfilesResponse>
      listTableDataProfilesCallable() {
    return listTableDataProfilesCallable;
  }

  @Override
  public UnaryCallable<ListTableDataProfilesRequest, ListTableDataProfilesPagedResponse>
      listTableDataProfilesPagedCallable() {
    return listTableDataProfilesPagedCallable;
  }

  @Override
  public UnaryCallable<ListColumnDataProfilesRequest, ListColumnDataProfilesResponse>
      listColumnDataProfilesCallable() {
    return listColumnDataProfilesCallable;
  }

  @Override
  public UnaryCallable<ListColumnDataProfilesRequest, ListColumnDataProfilesPagedResponse>
      listColumnDataProfilesPagedCallable() {
    return listColumnDataProfilesPagedCallable;
  }

  @Override
  public UnaryCallable<GetProjectDataProfileRequest, ProjectDataProfile>
      getProjectDataProfileCallable() {
    return getProjectDataProfileCallable;
  }

  @Override
  public UnaryCallable<GetTableDataProfileRequest, TableDataProfile> getTableDataProfileCallable() {
    return getTableDataProfileCallable;
  }

  @Override
  public UnaryCallable<GetColumnDataProfileRequest, ColumnDataProfile>
      getColumnDataProfileCallable() {
    return getColumnDataProfileCallable;
  }

  @Override
  public UnaryCallable<DeleteTableDataProfileRequest, Empty> deleteTableDataProfileCallable() {
    return deleteTableDataProfileCallable;
  }

  @Override
  public UnaryCallable<HybridInspectDlpJobRequest, HybridInspectResponse>
      hybridInspectDlpJobCallable() {
    return hybridInspectDlpJobCallable;
  }

  @Override
  public UnaryCallable<FinishDlpJobRequest, Empty> finishDlpJobCallable() {
    return finishDlpJobCallable;
  }

  @Override
  public UnaryCallable<CreateConnectionRequest, Connection> createConnectionCallable() {
    return createConnectionCallable;
  }

  @Override
  public UnaryCallable<GetConnectionRequest, Connection> getConnectionCallable() {
    return getConnectionCallable;
  }

  @Override
  public UnaryCallable<ListConnectionsRequest, ListConnectionsResponse> listConnectionsCallable() {
    return listConnectionsCallable;
  }

  @Override
  public UnaryCallable<ListConnectionsRequest, ListConnectionsPagedResponse>
      listConnectionsPagedCallable() {
    return listConnectionsPagedCallable;
  }

  @Override
  public UnaryCallable<SearchConnectionsRequest, SearchConnectionsResponse>
      searchConnectionsCallable() {
    return searchConnectionsCallable;
  }

  @Override
  public UnaryCallable<SearchConnectionsRequest, SearchConnectionsPagedResponse>
      searchConnectionsPagedCallable() {
    return searchConnectionsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteConnectionRequest, Empty> deleteConnectionCallable() {
    return deleteConnectionCallable;
  }

  @Override
  public UnaryCallable<UpdateConnectionRequest, Connection> updateConnectionCallable() {
    return updateConnectionCallable;
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
