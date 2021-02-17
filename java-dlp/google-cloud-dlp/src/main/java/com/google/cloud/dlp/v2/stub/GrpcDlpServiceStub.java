/*
 * Copyright 2020 Google LLC
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

import static com.google.cloud.dlp.v2.DlpServiceClient.ListDeidentifyTemplatesPagedResponse;
import static com.google.cloud.dlp.v2.DlpServiceClient.ListDlpJobsPagedResponse;
import static com.google.cloud.dlp.v2.DlpServiceClient.ListInspectTemplatesPagedResponse;
import static com.google.cloud.dlp.v2.DlpServiceClient.ListJobTriggersPagedResponse;
import static com.google.cloud.dlp.v2.DlpServiceClient.ListStoredInfoTypesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.privacy.dlp.v2.ActivateJobTriggerRequest;
import com.google.privacy.dlp.v2.CancelDlpJobRequest;
import com.google.privacy.dlp.v2.CreateDeidentifyTemplateRequest;
import com.google.privacy.dlp.v2.CreateDlpJobRequest;
import com.google.privacy.dlp.v2.CreateInspectTemplateRequest;
import com.google.privacy.dlp.v2.CreateJobTriggerRequest;
import com.google.privacy.dlp.v2.CreateStoredInfoTypeRequest;
import com.google.privacy.dlp.v2.DeidentifyContentRequest;
import com.google.privacy.dlp.v2.DeidentifyContentResponse;
import com.google.privacy.dlp.v2.DeidentifyTemplate;
import com.google.privacy.dlp.v2.DeleteDeidentifyTemplateRequest;
import com.google.privacy.dlp.v2.DeleteDlpJobRequest;
import com.google.privacy.dlp.v2.DeleteInspectTemplateRequest;
import com.google.privacy.dlp.v2.DeleteJobTriggerRequest;
import com.google.privacy.dlp.v2.DeleteStoredInfoTypeRequest;
import com.google.privacy.dlp.v2.DlpJob;
import com.google.privacy.dlp.v2.FinishDlpJobRequest;
import com.google.privacy.dlp.v2.GetDeidentifyTemplateRequest;
import com.google.privacy.dlp.v2.GetDlpJobRequest;
import com.google.privacy.dlp.v2.GetInspectTemplateRequest;
import com.google.privacy.dlp.v2.GetJobTriggerRequest;
import com.google.privacy.dlp.v2.GetStoredInfoTypeRequest;
import com.google.privacy.dlp.v2.HybridInspectDlpJobRequest;
import com.google.privacy.dlp.v2.HybridInspectJobTriggerRequest;
import com.google.privacy.dlp.v2.HybridInspectResponse;
import com.google.privacy.dlp.v2.InspectContentRequest;
import com.google.privacy.dlp.v2.InspectContentResponse;
import com.google.privacy.dlp.v2.InspectTemplate;
import com.google.privacy.dlp.v2.JobTrigger;
import com.google.privacy.dlp.v2.ListDeidentifyTemplatesRequest;
import com.google.privacy.dlp.v2.ListDeidentifyTemplatesResponse;
import com.google.privacy.dlp.v2.ListDlpJobsRequest;
import com.google.privacy.dlp.v2.ListDlpJobsResponse;
import com.google.privacy.dlp.v2.ListInfoTypesRequest;
import com.google.privacy.dlp.v2.ListInfoTypesResponse;
import com.google.privacy.dlp.v2.ListInspectTemplatesRequest;
import com.google.privacy.dlp.v2.ListInspectTemplatesResponse;
import com.google.privacy.dlp.v2.ListJobTriggersRequest;
import com.google.privacy.dlp.v2.ListJobTriggersResponse;
import com.google.privacy.dlp.v2.ListStoredInfoTypesRequest;
import com.google.privacy.dlp.v2.ListStoredInfoTypesResponse;
import com.google.privacy.dlp.v2.RedactImageRequest;
import com.google.privacy.dlp.v2.RedactImageResponse;
import com.google.privacy.dlp.v2.ReidentifyContentRequest;
import com.google.privacy.dlp.v2.ReidentifyContentResponse;
import com.google.privacy.dlp.v2.StoredInfoType;
import com.google.privacy.dlp.v2.UpdateDeidentifyTemplateRequest;
import com.google.privacy.dlp.v2.UpdateInspectTemplateRequest;
import com.google.privacy.dlp.v2.UpdateJobTriggerRequest;
import com.google.privacy.dlp.v2.UpdateStoredInfoTypeRequest;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
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
  private final UnaryCallable<HybridInspectDlpJobRequest, HybridInspectResponse>
      hybridInspectDlpJobCallable;
  private final UnaryCallable<FinishDlpJobRequest, Empty> finishDlpJobCallable;

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
                    new RequestParamsExtractor<InspectContentRequest>() {
                      @Override
                      public Map<String, String> extract(InspectContentRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<RedactImageRequest, RedactImageResponse> redactImageTransportSettings =
        GrpcCallSettings.<RedactImageRequest, RedactImageResponse>newBuilder()
            .setMethodDescriptor(redactImageMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<RedactImageRequest>() {
                  @Override
                  public Map<String, String> extract(RedactImageRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeidentifyContentRequest, DeidentifyContentResponse>
        deidentifyContentTransportSettings =
            GrpcCallSettings.<DeidentifyContentRequest, DeidentifyContentResponse>newBuilder()
                .setMethodDescriptor(deidentifyContentMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<DeidentifyContentRequest>() {
                      @Override
                      public Map<String, String> extract(DeidentifyContentRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<ReidentifyContentRequest, ReidentifyContentResponse>
        reidentifyContentTransportSettings =
            GrpcCallSettings.<ReidentifyContentRequest, ReidentifyContentResponse>newBuilder()
                .setMethodDescriptor(reidentifyContentMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ReidentifyContentRequest>() {
                      @Override
                      public Map<String, String> extract(ReidentifyContentRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<ListInfoTypesRequest, ListInfoTypesResponse> listInfoTypesTransportSettings =
        GrpcCallSettings.<ListInfoTypesRequest, ListInfoTypesResponse>newBuilder()
            .setMethodDescriptor(listInfoTypesMethodDescriptor)
            .build();
    GrpcCallSettings<CreateInspectTemplateRequest, InspectTemplate>
        createInspectTemplateTransportSettings =
            GrpcCallSettings.<CreateInspectTemplateRequest, InspectTemplate>newBuilder()
                .setMethodDescriptor(createInspectTemplateMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<CreateInspectTemplateRequest>() {
                      @Override
                      public Map<String, String> extract(CreateInspectTemplateRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<UpdateInspectTemplateRequest, InspectTemplate>
        updateInspectTemplateTransportSettings =
            GrpcCallSettings.<UpdateInspectTemplateRequest, InspectTemplate>newBuilder()
                .setMethodDescriptor(updateInspectTemplateMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<UpdateInspectTemplateRequest>() {
                      @Override
                      public Map<String, String> extract(UpdateInspectTemplateRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<GetInspectTemplateRequest, InspectTemplate>
        getInspectTemplateTransportSettings =
            GrpcCallSettings.<GetInspectTemplateRequest, InspectTemplate>newBuilder()
                .setMethodDescriptor(getInspectTemplateMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<GetInspectTemplateRequest>() {
                      @Override
                      public Map<String, String> extract(GetInspectTemplateRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<ListInspectTemplatesRequest, ListInspectTemplatesResponse>
        listInspectTemplatesTransportSettings =
            GrpcCallSettings.<ListInspectTemplatesRequest, ListInspectTemplatesResponse>newBuilder()
                .setMethodDescriptor(listInspectTemplatesMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListInspectTemplatesRequest>() {
                      @Override
                      public Map<String, String> extract(ListInspectTemplatesRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<DeleteInspectTemplateRequest, Empty> deleteInspectTemplateTransportSettings =
        GrpcCallSettings.<DeleteInspectTemplateRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteInspectTemplateMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteInspectTemplateRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteInspectTemplateRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CreateDeidentifyTemplateRequest, DeidentifyTemplate>
        createDeidentifyTemplateTransportSettings =
            GrpcCallSettings.<CreateDeidentifyTemplateRequest, DeidentifyTemplate>newBuilder()
                .setMethodDescriptor(createDeidentifyTemplateMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<CreateDeidentifyTemplateRequest>() {
                      @Override
                      public Map<String, String> extract(CreateDeidentifyTemplateRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<UpdateDeidentifyTemplateRequest, DeidentifyTemplate>
        updateDeidentifyTemplateTransportSettings =
            GrpcCallSettings.<UpdateDeidentifyTemplateRequest, DeidentifyTemplate>newBuilder()
                .setMethodDescriptor(updateDeidentifyTemplateMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<UpdateDeidentifyTemplateRequest>() {
                      @Override
                      public Map<String, String> extract(UpdateDeidentifyTemplateRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<GetDeidentifyTemplateRequest, DeidentifyTemplate>
        getDeidentifyTemplateTransportSettings =
            GrpcCallSettings.<GetDeidentifyTemplateRequest, DeidentifyTemplate>newBuilder()
                .setMethodDescriptor(getDeidentifyTemplateMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<GetDeidentifyTemplateRequest>() {
                      @Override
                      public Map<String, String> extract(GetDeidentifyTemplateRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<ListDeidentifyTemplatesRequest, ListDeidentifyTemplatesResponse>
        listDeidentifyTemplatesTransportSettings =
            GrpcCallSettings
                .<ListDeidentifyTemplatesRequest, ListDeidentifyTemplatesResponse>newBuilder()
                .setMethodDescriptor(listDeidentifyTemplatesMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListDeidentifyTemplatesRequest>() {
                      @Override
                      public Map<String, String> extract(ListDeidentifyTemplatesRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<DeleteDeidentifyTemplateRequest, Empty>
        deleteDeidentifyTemplateTransportSettings =
            GrpcCallSettings.<DeleteDeidentifyTemplateRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteDeidentifyTemplateMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<DeleteDeidentifyTemplateRequest>() {
                      @Override
                      public Map<String, String> extract(DeleteDeidentifyTemplateRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<CreateJobTriggerRequest, JobTrigger> createJobTriggerTransportSettings =
        GrpcCallSettings.<CreateJobTriggerRequest, JobTrigger>newBuilder()
            .setMethodDescriptor(createJobTriggerMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateJobTriggerRequest>() {
                  @Override
                  public Map<String, String> extract(CreateJobTriggerRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UpdateJobTriggerRequest, JobTrigger> updateJobTriggerTransportSettings =
        GrpcCallSettings.<UpdateJobTriggerRequest, JobTrigger>newBuilder()
            .setMethodDescriptor(updateJobTriggerMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateJobTriggerRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateJobTriggerRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<HybridInspectJobTriggerRequest, HybridInspectResponse>
        hybridInspectJobTriggerTransportSettings =
            GrpcCallSettings.<HybridInspectJobTriggerRequest, HybridInspectResponse>newBuilder()
                .setMethodDescriptor(hybridInspectJobTriggerMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<HybridInspectJobTriggerRequest>() {
                      @Override
                      public Map<String, String> extract(HybridInspectJobTriggerRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<GetJobTriggerRequest, JobTrigger> getJobTriggerTransportSettings =
        GrpcCallSettings.<GetJobTriggerRequest, JobTrigger>newBuilder()
            .setMethodDescriptor(getJobTriggerMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetJobTriggerRequest>() {
                  @Override
                  public Map<String, String> extract(GetJobTriggerRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListJobTriggersRequest, ListJobTriggersResponse>
        listJobTriggersTransportSettings =
            GrpcCallSettings.<ListJobTriggersRequest, ListJobTriggersResponse>newBuilder()
                .setMethodDescriptor(listJobTriggersMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListJobTriggersRequest>() {
                      @Override
                      public Map<String, String> extract(ListJobTriggersRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<DeleteJobTriggerRequest, Empty> deleteJobTriggerTransportSettings =
        GrpcCallSettings.<DeleteJobTriggerRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteJobTriggerMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteJobTriggerRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteJobTriggerRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ActivateJobTriggerRequest, DlpJob> activateJobTriggerTransportSettings =
        GrpcCallSettings.<ActivateJobTriggerRequest, DlpJob>newBuilder()
            .setMethodDescriptor(activateJobTriggerMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ActivateJobTriggerRequest>() {
                  @Override
                  public Map<String, String> extract(ActivateJobTriggerRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CreateDlpJobRequest, DlpJob> createDlpJobTransportSettings =
        GrpcCallSettings.<CreateDlpJobRequest, DlpJob>newBuilder()
            .setMethodDescriptor(createDlpJobMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateDlpJobRequest>() {
                  @Override
                  public Map<String, String> extract(CreateDlpJobRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListDlpJobsRequest, ListDlpJobsResponse> listDlpJobsTransportSettings =
        GrpcCallSettings.<ListDlpJobsRequest, ListDlpJobsResponse>newBuilder()
            .setMethodDescriptor(listDlpJobsMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ListDlpJobsRequest>() {
                  @Override
                  public Map<String, String> extract(ListDlpJobsRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetDlpJobRequest, DlpJob> getDlpJobTransportSettings =
        GrpcCallSettings.<GetDlpJobRequest, DlpJob>newBuilder()
            .setMethodDescriptor(getDlpJobMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetDlpJobRequest>() {
                  @Override
                  public Map<String, String> extract(GetDlpJobRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeleteDlpJobRequest, Empty> deleteDlpJobTransportSettings =
        GrpcCallSettings.<DeleteDlpJobRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteDlpJobMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteDlpJobRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteDlpJobRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CancelDlpJobRequest, Empty> cancelDlpJobTransportSettings =
        GrpcCallSettings.<CancelDlpJobRequest, Empty>newBuilder()
            .setMethodDescriptor(cancelDlpJobMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CancelDlpJobRequest>() {
                  @Override
                  public Map<String, String> extract(CancelDlpJobRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CreateStoredInfoTypeRequest, StoredInfoType>
        createStoredInfoTypeTransportSettings =
            GrpcCallSettings.<CreateStoredInfoTypeRequest, StoredInfoType>newBuilder()
                .setMethodDescriptor(createStoredInfoTypeMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<CreateStoredInfoTypeRequest>() {
                      @Override
                      public Map<String, String> extract(CreateStoredInfoTypeRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<UpdateStoredInfoTypeRequest, StoredInfoType>
        updateStoredInfoTypeTransportSettings =
            GrpcCallSettings.<UpdateStoredInfoTypeRequest, StoredInfoType>newBuilder()
                .setMethodDescriptor(updateStoredInfoTypeMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<UpdateStoredInfoTypeRequest>() {
                      @Override
                      public Map<String, String> extract(UpdateStoredInfoTypeRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<GetStoredInfoTypeRequest, StoredInfoType> getStoredInfoTypeTransportSettings =
        GrpcCallSettings.<GetStoredInfoTypeRequest, StoredInfoType>newBuilder()
            .setMethodDescriptor(getStoredInfoTypeMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetStoredInfoTypeRequest>() {
                  @Override
                  public Map<String, String> extract(GetStoredInfoTypeRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListStoredInfoTypesRequest, ListStoredInfoTypesResponse>
        listStoredInfoTypesTransportSettings =
            GrpcCallSettings.<ListStoredInfoTypesRequest, ListStoredInfoTypesResponse>newBuilder()
                .setMethodDescriptor(listStoredInfoTypesMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListStoredInfoTypesRequest>() {
                      @Override
                      public Map<String, String> extract(ListStoredInfoTypesRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<DeleteStoredInfoTypeRequest, Empty> deleteStoredInfoTypeTransportSettings =
        GrpcCallSettings.<DeleteStoredInfoTypeRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteStoredInfoTypeMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteStoredInfoTypeRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteStoredInfoTypeRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<HybridInspectDlpJobRequest, HybridInspectResponse>
        hybridInspectDlpJobTransportSettings =
            GrpcCallSettings.<HybridInspectDlpJobRequest, HybridInspectResponse>newBuilder()
                .setMethodDescriptor(hybridInspectDlpJobMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<HybridInspectDlpJobRequest>() {
                      @Override
                      public Map<String, String> extract(HybridInspectDlpJobRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<FinishDlpJobRequest, Empty> finishDlpJobTransportSettings =
        GrpcCallSettings.<FinishDlpJobRequest, Empty>newBuilder()
            .setMethodDescriptor(finishDlpJobMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<FinishDlpJobRequest>() {
                  @Override
                  public Map<String, String> extract(FinishDlpJobRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
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
    this.hybridInspectDlpJobCallable =
        callableFactory.createUnaryCallable(
            hybridInspectDlpJobTransportSettings,
            settings.hybridInspectDlpJobSettings(),
            clientContext);
    this.finishDlpJobCallable =
        callableFactory.createUnaryCallable(
            finishDlpJobTransportSettings, settings.finishDlpJobSettings(), clientContext);

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
  public UnaryCallable<HybridInspectDlpJobRequest, HybridInspectResponse>
      hybridInspectDlpJobCallable() {
    return hybridInspectDlpJobCallable;
  }

  @Override
  public UnaryCallable<FinishDlpJobRequest, Empty> finishDlpJobCallable() {
    return finishDlpJobCallable;
  }

  @Override
  public final void close() {
    shutdown();
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
