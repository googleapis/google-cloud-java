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

package com.google.cloud.aiplatform.v1.stub;

import static com.google.cloud.aiplatform.v1.JobServiceClient.ListBatchPredictionJobsPagedResponse;
import static com.google.cloud.aiplatform.v1.JobServiceClient.ListCustomJobsPagedResponse;
import static com.google.cloud.aiplatform.v1.JobServiceClient.ListDataLabelingJobsPagedResponse;
import static com.google.cloud.aiplatform.v1.JobServiceClient.ListHyperparameterTuningJobsPagedResponse;
import static com.google.cloud.aiplatform.v1.JobServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1.JobServiceClient.ListModelDeploymentMonitoringJobsPagedResponse;
import static com.google.cloud.aiplatform.v1.JobServiceClient.SearchModelDeploymentMonitoringStatsAnomaliesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1.BatchPredictionJob;
import com.google.cloud.aiplatform.v1.CancelBatchPredictionJobRequest;
import com.google.cloud.aiplatform.v1.CancelCustomJobRequest;
import com.google.cloud.aiplatform.v1.CancelDataLabelingJobRequest;
import com.google.cloud.aiplatform.v1.CancelHyperparameterTuningJobRequest;
import com.google.cloud.aiplatform.v1.CreateBatchPredictionJobRequest;
import com.google.cloud.aiplatform.v1.CreateCustomJobRequest;
import com.google.cloud.aiplatform.v1.CreateDataLabelingJobRequest;
import com.google.cloud.aiplatform.v1.CreateHyperparameterTuningJobRequest;
import com.google.cloud.aiplatform.v1.CreateModelDeploymentMonitoringJobRequest;
import com.google.cloud.aiplatform.v1.CustomJob;
import com.google.cloud.aiplatform.v1.DataLabelingJob;
import com.google.cloud.aiplatform.v1.DeleteBatchPredictionJobRequest;
import com.google.cloud.aiplatform.v1.DeleteCustomJobRequest;
import com.google.cloud.aiplatform.v1.DeleteDataLabelingJobRequest;
import com.google.cloud.aiplatform.v1.DeleteHyperparameterTuningJobRequest;
import com.google.cloud.aiplatform.v1.DeleteModelDeploymentMonitoringJobRequest;
import com.google.cloud.aiplatform.v1.DeleteOperationMetadata;
import com.google.cloud.aiplatform.v1.GetBatchPredictionJobRequest;
import com.google.cloud.aiplatform.v1.GetCustomJobRequest;
import com.google.cloud.aiplatform.v1.GetDataLabelingJobRequest;
import com.google.cloud.aiplatform.v1.GetHyperparameterTuningJobRequest;
import com.google.cloud.aiplatform.v1.GetModelDeploymentMonitoringJobRequest;
import com.google.cloud.aiplatform.v1.HyperparameterTuningJob;
import com.google.cloud.aiplatform.v1.ListBatchPredictionJobsRequest;
import com.google.cloud.aiplatform.v1.ListBatchPredictionJobsResponse;
import com.google.cloud.aiplatform.v1.ListCustomJobsRequest;
import com.google.cloud.aiplatform.v1.ListCustomJobsResponse;
import com.google.cloud.aiplatform.v1.ListDataLabelingJobsRequest;
import com.google.cloud.aiplatform.v1.ListDataLabelingJobsResponse;
import com.google.cloud.aiplatform.v1.ListHyperparameterTuningJobsRequest;
import com.google.cloud.aiplatform.v1.ListHyperparameterTuningJobsResponse;
import com.google.cloud.aiplatform.v1.ListModelDeploymentMonitoringJobsRequest;
import com.google.cloud.aiplatform.v1.ListModelDeploymentMonitoringJobsResponse;
import com.google.cloud.aiplatform.v1.ModelDeploymentMonitoringJob;
import com.google.cloud.aiplatform.v1.PauseModelDeploymentMonitoringJobRequest;
import com.google.cloud.aiplatform.v1.ResumeModelDeploymentMonitoringJobRequest;
import com.google.cloud.aiplatform.v1.SearchModelDeploymentMonitoringStatsAnomaliesRequest;
import com.google.cloud.aiplatform.v1.SearchModelDeploymentMonitoringStatsAnomaliesResponse;
import com.google.cloud.aiplatform.v1.UpdateModelDeploymentMonitoringJobOperationMetadata;
import com.google.cloud.aiplatform.v1.UpdateModelDeploymentMonitoringJobRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the JobService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcJobServiceStub extends JobServiceStub {
  private static final MethodDescriptor<CreateCustomJobRequest, CustomJob>
      createCustomJobMethodDescriptor =
          MethodDescriptor.<CreateCustomJobRequest, CustomJob>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1.JobService/CreateCustomJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateCustomJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CustomJob.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetCustomJobRequest, CustomJob>
      getCustomJobMethodDescriptor =
          MethodDescriptor.<GetCustomJobRequest, CustomJob>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1.JobService/GetCustomJob")
              .setRequestMarshaller(ProtoUtils.marshaller(GetCustomJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(CustomJob.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListCustomJobsRequest, ListCustomJobsResponse>
      listCustomJobsMethodDescriptor =
          MethodDescriptor.<ListCustomJobsRequest, ListCustomJobsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1.JobService/ListCustomJobs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListCustomJobsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListCustomJobsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteCustomJobRequest, Operation>
      deleteCustomJobMethodDescriptor =
          MethodDescriptor.<DeleteCustomJobRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1.JobService/DeleteCustomJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteCustomJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CancelCustomJobRequest, Empty>
      cancelCustomJobMethodDescriptor =
          MethodDescriptor.<CancelCustomJobRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1.JobService/CancelCustomJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CancelCustomJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateDataLabelingJobRequest, DataLabelingJob>
      createDataLabelingJobMethodDescriptor =
          MethodDescriptor.<CreateDataLabelingJobRequest, DataLabelingJob>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1.JobService/CreateDataLabelingJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateDataLabelingJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DataLabelingJob.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetDataLabelingJobRequest, DataLabelingJob>
      getDataLabelingJobMethodDescriptor =
          MethodDescriptor.<GetDataLabelingJobRequest, DataLabelingJob>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1.JobService/GetDataLabelingJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetDataLabelingJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(DataLabelingJob.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListDataLabelingJobsRequest, ListDataLabelingJobsResponse>
      listDataLabelingJobsMethodDescriptor =
          MethodDescriptor.<ListDataLabelingJobsRequest, ListDataLabelingJobsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1.JobService/ListDataLabelingJobs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListDataLabelingJobsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListDataLabelingJobsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteDataLabelingJobRequest, Operation>
      deleteDataLabelingJobMethodDescriptor =
          MethodDescriptor.<DeleteDataLabelingJobRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1.JobService/DeleteDataLabelingJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteDataLabelingJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CancelDataLabelingJobRequest, Empty>
      cancelDataLabelingJobMethodDescriptor =
          MethodDescriptor.<CancelDataLabelingJobRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1.JobService/CancelDataLabelingJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CancelDataLabelingJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          CreateHyperparameterTuningJobRequest, HyperparameterTuningJob>
      createHyperparameterTuningJobMethodDescriptor =
          MethodDescriptor
              .<CreateHyperparameterTuningJobRequest, HyperparameterTuningJob>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.JobService/CreateHyperparameterTuningJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateHyperparameterTuningJobRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(HyperparameterTuningJob.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetHyperparameterTuningJobRequest, HyperparameterTuningJob>
      getHyperparameterTuningJobMethodDescriptor =
          MethodDescriptor.<GetHyperparameterTuningJobRequest, HyperparameterTuningJob>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1.JobService/GetHyperparameterTuningJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetHyperparameterTuningJobRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(HyperparameterTuningJob.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListHyperparameterTuningJobsRequest, ListHyperparameterTuningJobsResponse>
      listHyperparameterTuningJobsMethodDescriptor =
          MethodDescriptor
              .<ListHyperparameterTuningJobsRequest, ListHyperparameterTuningJobsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.JobService/ListHyperparameterTuningJobs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListHyperparameterTuningJobsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListHyperparameterTuningJobsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteHyperparameterTuningJobRequest, Operation>
      deleteHyperparameterTuningJobMethodDescriptor =
          MethodDescriptor.<DeleteHyperparameterTuningJobRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.JobService/DeleteHyperparameterTuningJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteHyperparameterTuningJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CancelHyperparameterTuningJobRequest, Empty>
      cancelHyperparameterTuningJobMethodDescriptor =
          MethodDescriptor.<CancelHyperparameterTuningJobRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.JobService/CancelHyperparameterTuningJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CancelHyperparameterTuningJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateBatchPredictionJobRequest, BatchPredictionJob>
      createBatchPredictionJobMethodDescriptor =
          MethodDescriptor.<CreateBatchPredictionJobRequest, BatchPredictionJob>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1.JobService/CreateBatchPredictionJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateBatchPredictionJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(BatchPredictionJob.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetBatchPredictionJobRequest, BatchPredictionJob>
      getBatchPredictionJobMethodDescriptor =
          MethodDescriptor.<GetBatchPredictionJobRequest, BatchPredictionJob>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1.JobService/GetBatchPredictionJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetBatchPredictionJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(BatchPredictionJob.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListBatchPredictionJobsRequest, ListBatchPredictionJobsResponse>
      listBatchPredictionJobsMethodDescriptor =
          MethodDescriptor
              .<ListBatchPredictionJobsRequest, ListBatchPredictionJobsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1.JobService/ListBatchPredictionJobs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListBatchPredictionJobsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListBatchPredictionJobsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteBatchPredictionJobRequest, Operation>
      deleteBatchPredictionJobMethodDescriptor =
          MethodDescriptor.<DeleteBatchPredictionJobRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1.JobService/DeleteBatchPredictionJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteBatchPredictionJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CancelBatchPredictionJobRequest, Empty>
      cancelBatchPredictionJobMethodDescriptor =
          MethodDescriptor.<CancelBatchPredictionJobRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1.JobService/CancelBatchPredictionJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CancelBatchPredictionJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          CreateModelDeploymentMonitoringJobRequest, ModelDeploymentMonitoringJob>
      createModelDeploymentMonitoringJobMethodDescriptor =
          MethodDescriptor
              .<CreateModelDeploymentMonitoringJobRequest, ModelDeploymentMonitoringJob>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.JobService/CreateModelDeploymentMonitoringJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      CreateModelDeploymentMonitoringJobRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ModelDeploymentMonitoringJob.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          SearchModelDeploymentMonitoringStatsAnomaliesRequest,
          SearchModelDeploymentMonitoringStatsAnomaliesResponse>
      searchModelDeploymentMonitoringStatsAnomaliesMethodDescriptor =
          MethodDescriptor
              .<SearchModelDeploymentMonitoringStatsAnomaliesRequest,
                  SearchModelDeploymentMonitoringStatsAnomaliesResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.JobService/SearchModelDeploymentMonitoringStatsAnomalies")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      SearchModelDeploymentMonitoringStatsAnomaliesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      SearchModelDeploymentMonitoringStatsAnomaliesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          GetModelDeploymentMonitoringJobRequest, ModelDeploymentMonitoringJob>
      getModelDeploymentMonitoringJobMethodDescriptor =
          MethodDescriptor
              .<GetModelDeploymentMonitoringJobRequest, ModelDeploymentMonitoringJob>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.JobService/GetModelDeploymentMonitoringJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      GetModelDeploymentMonitoringJobRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ModelDeploymentMonitoringJob.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListModelDeploymentMonitoringJobsRequest, ListModelDeploymentMonitoringJobsResponse>
      listModelDeploymentMonitoringJobsMethodDescriptor =
          MethodDescriptor
              .<ListModelDeploymentMonitoringJobsRequest, ListModelDeploymentMonitoringJobsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.JobService/ListModelDeploymentMonitoringJobs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      ListModelDeploymentMonitoringJobsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      ListModelDeploymentMonitoringJobsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateModelDeploymentMonitoringJobRequest, Operation>
      updateModelDeploymentMonitoringJobMethodDescriptor =
          MethodDescriptor.<UpdateModelDeploymentMonitoringJobRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.JobService/UpdateModelDeploymentMonitoringJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      UpdateModelDeploymentMonitoringJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteModelDeploymentMonitoringJobRequest, Operation>
      deleteModelDeploymentMonitoringJobMethodDescriptor =
          MethodDescriptor.<DeleteModelDeploymentMonitoringJobRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.JobService/DeleteModelDeploymentMonitoringJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      DeleteModelDeploymentMonitoringJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<PauseModelDeploymentMonitoringJobRequest, Empty>
      pauseModelDeploymentMonitoringJobMethodDescriptor =
          MethodDescriptor.<PauseModelDeploymentMonitoringJobRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.JobService/PauseModelDeploymentMonitoringJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      PauseModelDeploymentMonitoringJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ResumeModelDeploymentMonitoringJobRequest, Empty>
      resumeModelDeploymentMonitoringJobMethodDescriptor =
          MethodDescriptor.<ResumeModelDeploymentMonitoringJobRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.JobService/ResumeModelDeploymentMonitoringJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      ResumeModelDeploymentMonitoringJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
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

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          MethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.v1.IAMPolicy/TestIamPermissions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreateCustomJobRequest, CustomJob> createCustomJobCallable;
  private final UnaryCallable<GetCustomJobRequest, CustomJob> getCustomJobCallable;
  private final UnaryCallable<ListCustomJobsRequest, ListCustomJobsResponse> listCustomJobsCallable;
  private final UnaryCallable<ListCustomJobsRequest, ListCustomJobsPagedResponse>
      listCustomJobsPagedCallable;
  private final UnaryCallable<DeleteCustomJobRequest, Operation> deleteCustomJobCallable;
  private final OperationCallable<DeleteCustomJobRequest, Empty, DeleteOperationMetadata>
      deleteCustomJobOperationCallable;
  private final UnaryCallable<CancelCustomJobRequest, Empty> cancelCustomJobCallable;
  private final UnaryCallable<CreateDataLabelingJobRequest, DataLabelingJob>
      createDataLabelingJobCallable;
  private final UnaryCallable<GetDataLabelingJobRequest, DataLabelingJob>
      getDataLabelingJobCallable;
  private final UnaryCallable<ListDataLabelingJobsRequest, ListDataLabelingJobsResponse>
      listDataLabelingJobsCallable;
  private final UnaryCallable<ListDataLabelingJobsRequest, ListDataLabelingJobsPagedResponse>
      listDataLabelingJobsPagedCallable;
  private final UnaryCallable<DeleteDataLabelingJobRequest, Operation>
      deleteDataLabelingJobCallable;
  private final OperationCallable<DeleteDataLabelingJobRequest, Empty, DeleteOperationMetadata>
      deleteDataLabelingJobOperationCallable;
  private final UnaryCallable<CancelDataLabelingJobRequest, Empty> cancelDataLabelingJobCallable;
  private final UnaryCallable<CreateHyperparameterTuningJobRequest, HyperparameterTuningJob>
      createHyperparameterTuningJobCallable;
  private final UnaryCallable<GetHyperparameterTuningJobRequest, HyperparameterTuningJob>
      getHyperparameterTuningJobCallable;
  private final UnaryCallable<
          ListHyperparameterTuningJobsRequest, ListHyperparameterTuningJobsResponse>
      listHyperparameterTuningJobsCallable;
  private final UnaryCallable<
          ListHyperparameterTuningJobsRequest, ListHyperparameterTuningJobsPagedResponse>
      listHyperparameterTuningJobsPagedCallable;
  private final UnaryCallable<DeleteHyperparameterTuningJobRequest, Operation>
      deleteHyperparameterTuningJobCallable;
  private final OperationCallable<
          DeleteHyperparameterTuningJobRequest, Empty, DeleteOperationMetadata>
      deleteHyperparameterTuningJobOperationCallable;
  private final UnaryCallable<CancelHyperparameterTuningJobRequest, Empty>
      cancelHyperparameterTuningJobCallable;
  private final UnaryCallable<CreateBatchPredictionJobRequest, BatchPredictionJob>
      createBatchPredictionJobCallable;
  private final UnaryCallable<GetBatchPredictionJobRequest, BatchPredictionJob>
      getBatchPredictionJobCallable;
  private final UnaryCallable<ListBatchPredictionJobsRequest, ListBatchPredictionJobsResponse>
      listBatchPredictionJobsCallable;
  private final UnaryCallable<ListBatchPredictionJobsRequest, ListBatchPredictionJobsPagedResponse>
      listBatchPredictionJobsPagedCallable;
  private final UnaryCallable<DeleteBatchPredictionJobRequest, Operation>
      deleteBatchPredictionJobCallable;
  private final OperationCallable<DeleteBatchPredictionJobRequest, Empty, DeleteOperationMetadata>
      deleteBatchPredictionJobOperationCallable;
  private final UnaryCallable<CancelBatchPredictionJobRequest, Empty>
      cancelBatchPredictionJobCallable;
  private final UnaryCallable<
          CreateModelDeploymentMonitoringJobRequest, ModelDeploymentMonitoringJob>
      createModelDeploymentMonitoringJobCallable;
  private final UnaryCallable<
          SearchModelDeploymentMonitoringStatsAnomaliesRequest,
          SearchModelDeploymentMonitoringStatsAnomaliesResponse>
      searchModelDeploymentMonitoringStatsAnomaliesCallable;
  private final UnaryCallable<
          SearchModelDeploymentMonitoringStatsAnomaliesRequest,
          SearchModelDeploymentMonitoringStatsAnomaliesPagedResponse>
      searchModelDeploymentMonitoringStatsAnomaliesPagedCallable;
  private final UnaryCallable<GetModelDeploymentMonitoringJobRequest, ModelDeploymentMonitoringJob>
      getModelDeploymentMonitoringJobCallable;
  private final UnaryCallable<
          ListModelDeploymentMonitoringJobsRequest, ListModelDeploymentMonitoringJobsResponse>
      listModelDeploymentMonitoringJobsCallable;
  private final UnaryCallable<
          ListModelDeploymentMonitoringJobsRequest, ListModelDeploymentMonitoringJobsPagedResponse>
      listModelDeploymentMonitoringJobsPagedCallable;
  private final UnaryCallable<UpdateModelDeploymentMonitoringJobRequest, Operation>
      updateModelDeploymentMonitoringJobCallable;
  private final OperationCallable<
          UpdateModelDeploymentMonitoringJobRequest,
          ModelDeploymentMonitoringJob,
          UpdateModelDeploymentMonitoringJobOperationMetadata>
      updateModelDeploymentMonitoringJobOperationCallable;
  private final UnaryCallable<DeleteModelDeploymentMonitoringJobRequest, Operation>
      deleteModelDeploymentMonitoringJobCallable;
  private final OperationCallable<
          DeleteModelDeploymentMonitoringJobRequest, Empty, DeleteOperationMetadata>
      deleteModelDeploymentMonitoringJobOperationCallable;
  private final UnaryCallable<PauseModelDeploymentMonitoringJobRequest, Empty>
      pauseModelDeploymentMonitoringJobCallable;
  private final UnaryCallable<ResumeModelDeploymentMonitoringJobRequest, Empty>
      resumeModelDeploymentMonitoringJobCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcJobServiceStub create(JobServiceStubSettings settings)
      throws IOException {
    return new GrpcJobServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcJobServiceStub create(ClientContext clientContext) throws IOException {
    return new GrpcJobServiceStub(JobServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcJobServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcJobServiceStub(
        JobServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcJobServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcJobServiceStub(JobServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcJobServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcJobServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcJobServiceStub(
      JobServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateCustomJobRequest, CustomJob> createCustomJobTransportSettings =
        GrpcCallSettings.<CreateCustomJobRequest, CustomJob>newBuilder()
            .setMethodDescriptor(createCustomJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetCustomJobRequest, CustomJob> getCustomJobTransportSettings =
        GrpcCallSettings.<GetCustomJobRequest, CustomJob>newBuilder()
            .setMethodDescriptor(getCustomJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListCustomJobsRequest, ListCustomJobsResponse>
        listCustomJobsTransportSettings =
            GrpcCallSettings.<ListCustomJobsRequest, ListCustomJobsResponse>newBuilder()
                .setMethodDescriptor(listCustomJobsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteCustomJobRequest, Operation> deleteCustomJobTransportSettings =
        GrpcCallSettings.<DeleteCustomJobRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteCustomJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CancelCustomJobRequest, Empty> cancelCustomJobTransportSettings =
        GrpcCallSettings.<CancelCustomJobRequest, Empty>newBuilder()
            .setMethodDescriptor(cancelCustomJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateDataLabelingJobRequest, DataLabelingJob>
        createDataLabelingJobTransportSettings =
            GrpcCallSettings.<CreateDataLabelingJobRequest, DataLabelingJob>newBuilder()
                .setMethodDescriptor(createDataLabelingJobMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetDataLabelingJobRequest, DataLabelingJob>
        getDataLabelingJobTransportSettings =
            GrpcCallSettings.<GetDataLabelingJobRequest, DataLabelingJob>newBuilder()
                .setMethodDescriptor(getDataLabelingJobMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListDataLabelingJobsRequest, ListDataLabelingJobsResponse>
        listDataLabelingJobsTransportSettings =
            GrpcCallSettings.<ListDataLabelingJobsRequest, ListDataLabelingJobsResponse>newBuilder()
                .setMethodDescriptor(listDataLabelingJobsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteDataLabelingJobRequest, Operation>
        deleteDataLabelingJobTransportSettings =
            GrpcCallSettings.<DeleteDataLabelingJobRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteDataLabelingJobMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<CancelDataLabelingJobRequest, Empty> cancelDataLabelingJobTransportSettings =
        GrpcCallSettings.<CancelDataLabelingJobRequest, Empty>newBuilder()
            .setMethodDescriptor(cancelDataLabelingJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateHyperparameterTuningJobRequest, HyperparameterTuningJob>
        createHyperparameterTuningJobTransportSettings =
            GrpcCallSettings
                .<CreateHyperparameterTuningJobRequest, HyperparameterTuningJob>newBuilder()
                .setMethodDescriptor(createHyperparameterTuningJobMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetHyperparameterTuningJobRequest, HyperparameterTuningJob>
        getHyperparameterTuningJobTransportSettings =
            GrpcCallSettings
                .<GetHyperparameterTuningJobRequest, HyperparameterTuningJob>newBuilder()
                .setMethodDescriptor(getHyperparameterTuningJobMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListHyperparameterTuningJobsRequest, ListHyperparameterTuningJobsResponse>
        listHyperparameterTuningJobsTransportSettings =
            GrpcCallSettings
                .<ListHyperparameterTuningJobsRequest, ListHyperparameterTuningJobsResponse>
                    newBuilder()
                .setMethodDescriptor(listHyperparameterTuningJobsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteHyperparameterTuningJobRequest, Operation>
        deleteHyperparameterTuningJobTransportSettings =
            GrpcCallSettings.<DeleteHyperparameterTuningJobRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteHyperparameterTuningJobMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<CancelHyperparameterTuningJobRequest, Empty>
        cancelHyperparameterTuningJobTransportSettings =
            GrpcCallSettings.<CancelHyperparameterTuningJobRequest, Empty>newBuilder()
                .setMethodDescriptor(cancelHyperparameterTuningJobMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<CreateBatchPredictionJobRequest, BatchPredictionJob>
        createBatchPredictionJobTransportSettings =
            GrpcCallSettings.<CreateBatchPredictionJobRequest, BatchPredictionJob>newBuilder()
                .setMethodDescriptor(createBatchPredictionJobMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetBatchPredictionJobRequest, BatchPredictionJob>
        getBatchPredictionJobTransportSettings =
            GrpcCallSettings.<GetBatchPredictionJobRequest, BatchPredictionJob>newBuilder()
                .setMethodDescriptor(getBatchPredictionJobMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListBatchPredictionJobsRequest, ListBatchPredictionJobsResponse>
        listBatchPredictionJobsTransportSettings =
            GrpcCallSettings
                .<ListBatchPredictionJobsRequest, ListBatchPredictionJobsResponse>newBuilder()
                .setMethodDescriptor(listBatchPredictionJobsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteBatchPredictionJobRequest, Operation>
        deleteBatchPredictionJobTransportSettings =
            GrpcCallSettings.<DeleteBatchPredictionJobRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteBatchPredictionJobMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<CancelBatchPredictionJobRequest, Empty>
        cancelBatchPredictionJobTransportSettings =
            GrpcCallSettings.<CancelBatchPredictionJobRequest, Empty>newBuilder()
                .setMethodDescriptor(cancelBatchPredictionJobMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<CreateModelDeploymentMonitoringJobRequest, ModelDeploymentMonitoringJob>
        createModelDeploymentMonitoringJobTransportSettings =
            GrpcCallSettings
                .<CreateModelDeploymentMonitoringJobRequest, ModelDeploymentMonitoringJob>
                    newBuilder()
                .setMethodDescriptor(createModelDeploymentMonitoringJobMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<
            SearchModelDeploymentMonitoringStatsAnomaliesRequest,
            SearchModelDeploymentMonitoringStatsAnomaliesResponse>
        searchModelDeploymentMonitoringStatsAnomaliesTransportSettings =
            GrpcCallSettings
                .<SearchModelDeploymentMonitoringStatsAnomaliesRequest,
                    SearchModelDeploymentMonitoringStatsAnomaliesResponse>
                    newBuilder()
                .setMethodDescriptor(searchModelDeploymentMonitoringStatsAnomaliesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put(
                          "model_deployment_monitoring_job",
                          String.valueOf(request.getModelDeploymentMonitoringJob()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetModelDeploymentMonitoringJobRequest, ModelDeploymentMonitoringJob>
        getModelDeploymentMonitoringJobTransportSettings =
            GrpcCallSettings
                .<GetModelDeploymentMonitoringJobRequest, ModelDeploymentMonitoringJob>newBuilder()
                .setMethodDescriptor(getModelDeploymentMonitoringJobMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<
            ListModelDeploymentMonitoringJobsRequest, ListModelDeploymentMonitoringJobsResponse>
        listModelDeploymentMonitoringJobsTransportSettings =
            GrpcCallSettings
                .<ListModelDeploymentMonitoringJobsRequest,
                    ListModelDeploymentMonitoringJobsResponse>
                    newBuilder()
                .setMethodDescriptor(listModelDeploymentMonitoringJobsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UpdateModelDeploymentMonitoringJobRequest, Operation>
        updateModelDeploymentMonitoringJobTransportSettings =
            GrpcCallSettings.<UpdateModelDeploymentMonitoringJobRequest, Operation>newBuilder()
                .setMethodDescriptor(updateModelDeploymentMonitoringJobMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put(
                          "model_deployment_monitoring_job.name",
                          String.valueOf(request.getModelDeploymentMonitoringJob().getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteModelDeploymentMonitoringJobRequest, Operation>
        deleteModelDeploymentMonitoringJobTransportSettings =
            GrpcCallSettings.<DeleteModelDeploymentMonitoringJobRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteModelDeploymentMonitoringJobMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<PauseModelDeploymentMonitoringJobRequest, Empty>
        pauseModelDeploymentMonitoringJobTransportSettings =
            GrpcCallSettings.<PauseModelDeploymentMonitoringJobRequest, Empty>newBuilder()
                .setMethodDescriptor(pauseModelDeploymentMonitoringJobMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ResumeModelDeploymentMonitoringJobRequest, Empty>
        resumeModelDeploymentMonitoringJobTransportSettings =
            GrpcCallSettings.<ResumeModelDeploymentMonitoringJobRequest, Empty>newBuilder()
                .setMethodDescriptor(resumeModelDeploymentMonitoringJobMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListLocationsRequest, ListLocationsResponse> listLocationsTransportSettings =
        GrpcCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
            .setMethodDescriptor(listLocationsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        GrpcCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
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

    this.createCustomJobCallable =
        callableFactory.createUnaryCallable(
            createCustomJobTransportSettings, settings.createCustomJobSettings(), clientContext);
    this.getCustomJobCallable =
        callableFactory.createUnaryCallable(
            getCustomJobTransportSettings, settings.getCustomJobSettings(), clientContext);
    this.listCustomJobsCallable =
        callableFactory.createUnaryCallable(
            listCustomJobsTransportSettings, settings.listCustomJobsSettings(), clientContext);
    this.listCustomJobsPagedCallable =
        callableFactory.createPagedCallable(
            listCustomJobsTransportSettings, settings.listCustomJobsSettings(), clientContext);
    this.deleteCustomJobCallable =
        callableFactory.createUnaryCallable(
            deleteCustomJobTransportSettings, settings.deleteCustomJobSettings(), clientContext);
    this.deleteCustomJobOperationCallable =
        callableFactory.createOperationCallable(
            deleteCustomJobTransportSettings,
            settings.deleteCustomJobOperationSettings(),
            clientContext,
            operationsStub);
    this.cancelCustomJobCallable =
        callableFactory.createUnaryCallable(
            cancelCustomJobTransportSettings, settings.cancelCustomJobSettings(), clientContext);
    this.createDataLabelingJobCallable =
        callableFactory.createUnaryCallable(
            createDataLabelingJobTransportSettings,
            settings.createDataLabelingJobSettings(),
            clientContext);
    this.getDataLabelingJobCallable =
        callableFactory.createUnaryCallable(
            getDataLabelingJobTransportSettings,
            settings.getDataLabelingJobSettings(),
            clientContext);
    this.listDataLabelingJobsCallable =
        callableFactory.createUnaryCallable(
            listDataLabelingJobsTransportSettings,
            settings.listDataLabelingJobsSettings(),
            clientContext);
    this.listDataLabelingJobsPagedCallable =
        callableFactory.createPagedCallable(
            listDataLabelingJobsTransportSettings,
            settings.listDataLabelingJobsSettings(),
            clientContext);
    this.deleteDataLabelingJobCallable =
        callableFactory.createUnaryCallable(
            deleteDataLabelingJobTransportSettings,
            settings.deleteDataLabelingJobSettings(),
            clientContext);
    this.deleteDataLabelingJobOperationCallable =
        callableFactory.createOperationCallable(
            deleteDataLabelingJobTransportSettings,
            settings.deleteDataLabelingJobOperationSettings(),
            clientContext,
            operationsStub);
    this.cancelDataLabelingJobCallable =
        callableFactory.createUnaryCallable(
            cancelDataLabelingJobTransportSettings,
            settings.cancelDataLabelingJobSettings(),
            clientContext);
    this.createHyperparameterTuningJobCallable =
        callableFactory.createUnaryCallable(
            createHyperparameterTuningJobTransportSettings,
            settings.createHyperparameterTuningJobSettings(),
            clientContext);
    this.getHyperparameterTuningJobCallable =
        callableFactory.createUnaryCallable(
            getHyperparameterTuningJobTransportSettings,
            settings.getHyperparameterTuningJobSettings(),
            clientContext);
    this.listHyperparameterTuningJobsCallable =
        callableFactory.createUnaryCallable(
            listHyperparameterTuningJobsTransportSettings,
            settings.listHyperparameterTuningJobsSettings(),
            clientContext);
    this.listHyperparameterTuningJobsPagedCallable =
        callableFactory.createPagedCallable(
            listHyperparameterTuningJobsTransportSettings,
            settings.listHyperparameterTuningJobsSettings(),
            clientContext);
    this.deleteHyperparameterTuningJobCallable =
        callableFactory.createUnaryCallable(
            deleteHyperparameterTuningJobTransportSettings,
            settings.deleteHyperparameterTuningJobSettings(),
            clientContext);
    this.deleteHyperparameterTuningJobOperationCallable =
        callableFactory.createOperationCallable(
            deleteHyperparameterTuningJobTransportSettings,
            settings.deleteHyperparameterTuningJobOperationSettings(),
            clientContext,
            operationsStub);
    this.cancelHyperparameterTuningJobCallable =
        callableFactory.createUnaryCallable(
            cancelHyperparameterTuningJobTransportSettings,
            settings.cancelHyperparameterTuningJobSettings(),
            clientContext);
    this.createBatchPredictionJobCallable =
        callableFactory.createUnaryCallable(
            createBatchPredictionJobTransportSettings,
            settings.createBatchPredictionJobSettings(),
            clientContext);
    this.getBatchPredictionJobCallable =
        callableFactory.createUnaryCallable(
            getBatchPredictionJobTransportSettings,
            settings.getBatchPredictionJobSettings(),
            clientContext);
    this.listBatchPredictionJobsCallable =
        callableFactory.createUnaryCallable(
            listBatchPredictionJobsTransportSettings,
            settings.listBatchPredictionJobsSettings(),
            clientContext);
    this.listBatchPredictionJobsPagedCallable =
        callableFactory.createPagedCallable(
            listBatchPredictionJobsTransportSettings,
            settings.listBatchPredictionJobsSettings(),
            clientContext);
    this.deleteBatchPredictionJobCallable =
        callableFactory.createUnaryCallable(
            deleteBatchPredictionJobTransportSettings,
            settings.deleteBatchPredictionJobSettings(),
            clientContext);
    this.deleteBatchPredictionJobOperationCallable =
        callableFactory.createOperationCallable(
            deleteBatchPredictionJobTransportSettings,
            settings.deleteBatchPredictionJobOperationSettings(),
            clientContext,
            operationsStub);
    this.cancelBatchPredictionJobCallable =
        callableFactory.createUnaryCallable(
            cancelBatchPredictionJobTransportSettings,
            settings.cancelBatchPredictionJobSettings(),
            clientContext);
    this.createModelDeploymentMonitoringJobCallable =
        callableFactory.createUnaryCallable(
            createModelDeploymentMonitoringJobTransportSettings,
            settings.createModelDeploymentMonitoringJobSettings(),
            clientContext);
    this.searchModelDeploymentMonitoringStatsAnomaliesCallable =
        callableFactory.createUnaryCallable(
            searchModelDeploymentMonitoringStatsAnomaliesTransportSettings,
            settings.searchModelDeploymentMonitoringStatsAnomaliesSettings(),
            clientContext);
    this.searchModelDeploymentMonitoringStatsAnomaliesPagedCallable =
        callableFactory.createPagedCallable(
            searchModelDeploymentMonitoringStatsAnomaliesTransportSettings,
            settings.searchModelDeploymentMonitoringStatsAnomaliesSettings(),
            clientContext);
    this.getModelDeploymentMonitoringJobCallable =
        callableFactory.createUnaryCallable(
            getModelDeploymentMonitoringJobTransportSettings,
            settings.getModelDeploymentMonitoringJobSettings(),
            clientContext);
    this.listModelDeploymentMonitoringJobsCallable =
        callableFactory.createUnaryCallable(
            listModelDeploymentMonitoringJobsTransportSettings,
            settings.listModelDeploymentMonitoringJobsSettings(),
            clientContext);
    this.listModelDeploymentMonitoringJobsPagedCallable =
        callableFactory.createPagedCallable(
            listModelDeploymentMonitoringJobsTransportSettings,
            settings.listModelDeploymentMonitoringJobsSettings(),
            clientContext);
    this.updateModelDeploymentMonitoringJobCallable =
        callableFactory.createUnaryCallable(
            updateModelDeploymentMonitoringJobTransportSettings,
            settings.updateModelDeploymentMonitoringJobSettings(),
            clientContext);
    this.updateModelDeploymentMonitoringJobOperationCallable =
        callableFactory.createOperationCallable(
            updateModelDeploymentMonitoringJobTransportSettings,
            settings.updateModelDeploymentMonitoringJobOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteModelDeploymentMonitoringJobCallable =
        callableFactory.createUnaryCallable(
            deleteModelDeploymentMonitoringJobTransportSettings,
            settings.deleteModelDeploymentMonitoringJobSettings(),
            clientContext);
    this.deleteModelDeploymentMonitoringJobOperationCallable =
        callableFactory.createOperationCallable(
            deleteModelDeploymentMonitoringJobTransportSettings,
            settings.deleteModelDeploymentMonitoringJobOperationSettings(),
            clientContext,
            operationsStub);
    this.pauseModelDeploymentMonitoringJobCallable =
        callableFactory.createUnaryCallable(
            pauseModelDeploymentMonitoringJobTransportSettings,
            settings.pauseModelDeploymentMonitoringJobSettings(),
            clientContext);
    this.resumeModelDeploymentMonitoringJobCallable =
        callableFactory.createUnaryCallable(
            resumeModelDeploymentMonitoringJobTransportSettings,
            settings.resumeModelDeploymentMonitoringJobSettings(),
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
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.testIamPermissionsCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsTransportSettings,
            settings.testIamPermissionsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateCustomJobRequest, CustomJob> createCustomJobCallable() {
    return createCustomJobCallable;
  }

  @Override
  public UnaryCallable<GetCustomJobRequest, CustomJob> getCustomJobCallable() {
    return getCustomJobCallable;
  }

  @Override
  public UnaryCallable<ListCustomJobsRequest, ListCustomJobsResponse> listCustomJobsCallable() {
    return listCustomJobsCallable;
  }

  @Override
  public UnaryCallable<ListCustomJobsRequest, ListCustomJobsPagedResponse>
      listCustomJobsPagedCallable() {
    return listCustomJobsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteCustomJobRequest, Operation> deleteCustomJobCallable() {
    return deleteCustomJobCallable;
  }

  @Override
  public OperationCallable<DeleteCustomJobRequest, Empty, DeleteOperationMetadata>
      deleteCustomJobOperationCallable() {
    return deleteCustomJobOperationCallable;
  }

  @Override
  public UnaryCallable<CancelCustomJobRequest, Empty> cancelCustomJobCallable() {
    return cancelCustomJobCallable;
  }

  @Override
  public UnaryCallable<CreateDataLabelingJobRequest, DataLabelingJob>
      createDataLabelingJobCallable() {
    return createDataLabelingJobCallable;
  }

  @Override
  public UnaryCallable<GetDataLabelingJobRequest, DataLabelingJob> getDataLabelingJobCallable() {
    return getDataLabelingJobCallable;
  }

  @Override
  public UnaryCallable<ListDataLabelingJobsRequest, ListDataLabelingJobsResponse>
      listDataLabelingJobsCallable() {
    return listDataLabelingJobsCallable;
  }

  @Override
  public UnaryCallable<ListDataLabelingJobsRequest, ListDataLabelingJobsPagedResponse>
      listDataLabelingJobsPagedCallable() {
    return listDataLabelingJobsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteDataLabelingJobRequest, Operation> deleteDataLabelingJobCallable() {
    return deleteDataLabelingJobCallable;
  }

  @Override
  public OperationCallable<DeleteDataLabelingJobRequest, Empty, DeleteOperationMetadata>
      deleteDataLabelingJobOperationCallable() {
    return deleteDataLabelingJobOperationCallable;
  }

  @Override
  public UnaryCallable<CancelDataLabelingJobRequest, Empty> cancelDataLabelingJobCallable() {
    return cancelDataLabelingJobCallable;
  }

  @Override
  public UnaryCallable<CreateHyperparameterTuningJobRequest, HyperparameterTuningJob>
      createHyperparameterTuningJobCallable() {
    return createHyperparameterTuningJobCallable;
  }

  @Override
  public UnaryCallable<GetHyperparameterTuningJobRequest, HyperparameterTuningJob>
      getHyperparameterTuningJobCallable() {
    return getHyperparameterTuningJobCallable;
  }

  @Override
  public UnaryCallable<ListHyperparameterTuningJobsRequest, ListHyperparameterTuningJobsResponse>
      listHyperparameterTuningJobsCallable() {
    return listHyperparameterTuningJobsCallable;
  }

  @Override
  public UnaryCallable<
          ListHyperparameterTuningJobsRequest, ListHyperparameterTuningJobsPagedResponse>
      listHyperparameterTuningJobsPagedCallable() {
    return listHyperparameterTuningJobsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteHyperparameterTuningJobRequest, Operation>
      deleteHyperparameterTuningJobCallable() {
    return deleteHyperparameterTuningJobCallable;
  }

  @Override
  public OperationCallable<DeleteHyperparameterTuningJobRequest, Empty, DeleteOperationMetadata>
      deleteHyperparameterTuningJobOperationCallable() {
    return deleteHyperparameterTuningJobOperationCallable;
  }

  @Override
  public UnaryCallable<CancelHyperparameterTuningJobRequest, Empty>
      cancelHyperparameterTuningJobCallable() {
    return cancelHyperparameterTuningJobCallable;
  }

  @Override
  public UnaryCallable<CreateBatchPredictionJobRequest, BatchPredictionJob>
      createBatchPredictionJobCallable() {
    return createBatchPredictionJobCallable;
  }

  @Override
  public UnaryCallable<GetBatchPredictionJobRequest, BatchPredictionJob>
      getBatchPredictionJobCallable() {
    return getBatchPredictionJobCallable;
  }

  @Override
  public UnaryCallable<ListBatchPredictionJobsRequest, ListBatchPredictionJobsResponse>
      listBatchPredictionJobsCallable() {
    return listBatchPredictionJobsCallable;
  }

  @Override
  public UnaryCallable<ListBatchPredictionJobsRequest, ListBatchPredictionJobsPagedResponse>
      listBatchPredictionJobsPagedCallable() {
    return listBatchPredictionJobsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteBatchPredictionJobRequest, Operation>
      deleteBatchPredictionJobCallable() {
    return deleteBatchPredictionJobCallable;
  }

  @Override
  public OperationCallable<DeleteBatchPredictionJobRequest, Empty, DeleteOperationMetadata>
      deleteBatchPredictionJobOperationCallable() {
    return deleteBatchPredictionJobOperationCallable;
  }

  @Override
  public UnaryCallable<CancelBatchPredictionJobRequest, Empty> cancelBatchPredictionJobCallable() {
    return cancelBatchPredictionJobCallable;
  }

  @Override
  public UnaryCallable<CreateModelDeploymentMonitoringJobRequest, ModelDeploymentMonitoringJob>
      createModelDeploymentMonitoringJobCallable() {
    return createModelDeploymentMonitoringJobCallable;
  }

  @Override
  public UnaryCallable<
          SearchModelDeploymentMonitoringStatsAnomaliesRequest,
          SearchModelDeploymentMonitoringStatsAnomaliesResponse>
      searchModelDeploymentMonitoringStatsAnomaliesCallable() {
    return searchModelDeploymentMonitoringStatsAnomaliesCallable;
  }

  @Override
  public UnaryCallable<
          SearchModelDeploymentMonitoringStatsAnomaliesRequest,
          SearchModelDeploymentMonitoringStatsAnomaliesPagedResponse>
      searchModelDeploymentMonitoringStatsAnomaliesPagedCallable() {
    return searchModelDeploymentMonitoringStatsAnomaliesPagedCallable;
  }

  @Override
  public UnaryCallable<GetModelDeploymentMonitoringJobRequest, ModelDeploymentMonitoringJob>
      getModelDeploymentMonitoringJobCallable() {
    return getModelDeploymentMonitoringJobCallable;
  }

  @Override
  public UnaryCallable<
          ListModelDeploymentMonitoringJobsRequest, ListModelDeploymentMonitoringJobsResponse>
      listModelDeploymentMonitoringJobsCallable() {
    return listModelDeploymentMonitoringJobsCallable;
  }

  @Override
  public UnaryCallable<
          ListModelDeploymentMonitoringJobsRequest, ListModelDeploymentMonitoringJobsPagedResponse>
      listModelDeploymentMonitoringJobsPagedCallable() {
    return listModelDeploymentMonitoringJobsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateModelDeploymentMonitoringJobRequest, Operation>
      updateModelDeploymentMonitoringJobCallable() {
    return updateModelDeploymentMonitoringJobCallable;
  }

  @Override
  public OperationCallable<
          UpdateModelDeploymentMonitoringJobRequest,
          ModelDeploymentMonitoringJob,
          UpdateModelDeploymentMonitoringJobOperationMetadata>
      updateModelDeploymentMonitoringJobOperationCallable() {
    return updateModelDeploymentMonitoringJobOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteModelDeploymentMonitoringJobRequest, Operation>
      deleteModelDeploymentMonitoringJobCallable() {
    return deleteModelDeploymentMonitoringJobCallable;
  }

  @Override
  public OperationCallable<
          DeleteModelDeploymentMonitoringJobRequest, Empty, DeleteOperationMetadata>
      deleteModelDeploymentMonitoringJobOperationCallable() {
    return deleteModelDeploymentMonitoringJobOperationCallable;
  }

  @Override
  public UnaryCallable<PauseModelDeploymentMonitoringJobRequest, Empty>
      pauseModelDeploymentMonitoringJobCallable() {
    return pauseModelDeploymentMonitoringJobCallable;
  }

  @Override
  public UnaryCallable<ResumeModelDeploymentMonitoringJobRequest, Empty>
      resumeModelDeploymentMonitoringJobCallable() {
    return resumeModelDeploymentMonitoringJobCallable;
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
  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
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
