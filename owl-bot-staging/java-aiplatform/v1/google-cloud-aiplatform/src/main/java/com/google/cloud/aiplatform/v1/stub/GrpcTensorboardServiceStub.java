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

import static com.google.cloud.aiplatform.v1.TensorboardServiceClient.ExportTensorboardTimeSeriesDataPagedResponse;
import static com.google.cloud.aiplatform.v1.TensorboardServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1.TensorboardServiceClient.ListTensorboardExperimentsPagedResponse;
import static com.google.cloud.aiplatform.v1.TensorboardServiceClient.ListTensorboardRunsPagedResponse;
import static com.google.cloud.aiplatform.v1.TensorboardServiceClient.ListTensorboardTimeSeriesPagedResponse;
import static com.google.cloud.aiplatform.v1.TensorboardServiceClient.ListTensorboardsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1.BatchCreateTensorboardRunsRequest;
import com.google.cloud.aiplatform.v1.BatchCreateTensorboardRunsResponse;
import com.google.cloud.aiplatform.v1.BatchCreateTensorboardTimeSeriesRequest;
import com.google.cloud.aiplatform.v1.BatchCreateTensorboardTimeSeriesResponse;
import com.google.cloud.aiplatform.v1.BatchReadTensorboardTimeSeriesDataRequest;
import com.google.cloud.aiplatform.v1.BatchReadTensorboardTimeSeriesDataResponse;
import com.google.cloud.aiplatform.v1.CreateTensorboardExperimentRequest;
import com.google.cloud.aiplatform.v1.CreateTensorboardOperationMetadata;
import com.google.cloud.aiplatform.v1.CreateTensorboardRequest;
import com.google.cloud.aiplatform.v1.CreateTensorboardRunRequest;
import com.google.cloud.aiplatform.v1.CreateTensorboardTimeSeriesRequest;
import com.google.cloud.aiplatform.v1.DeleteOperationMetadata;
import com.google.cloud.aiplatform.v1.DeleteTensorboardExperimentRequest;
import com.google.cloud.aiplatform.v1.DeleteTensorboardRequest;
import com.google.cloud.aiplatform.v1.DeleteTensorboardRunRequest;
import com.google.cloud.aiplatform.v1.DeleteTensorboardTimeSeriesRequest;
import com.google.cloud.aiplatform.v1.ExportTensorboardTimeSeriesDataRequest;
import com.google.cloud.aiplatform.v1.ExportTensorboardTimeSeriesDataResponse;
import com.google.cloud.aiplatform.v1.GetTensorboardExperimentRequest;
import com.google.cloud.aiplatform.v1.GetTensorboardRequest;
import com.google.cloud.aiplatform.v1.GetTensorboardRunRequest;
import com.google.cloud.aiplatform.v1.GetTensorboardTimeSeriesRequest;
import com.google.cloud.aiplatform.v1.ListTensorboardExperimentsRequest;
import com.google.cloud.aiplatform.v1.ListTensorboardExperimentsResponse;
import com.google.cloud.aiplatform.v1.ListTensorboardRunsRequest;
import com.google.cloud.aiplatform.v1.ListTensorboardRunsResponse;
import com.google.cloud.aiplatform.v1.ListTensorboardTimeSeriesRequest;
import com.google.cloud.aiplatform.v1.ListTensorboardTimeSeriesResponse;
import com.google.cloud.aiplatform.v1.ListTensorboardsRequest;
import com.google.cloud.aiplatform.v1.ListTensorboardsResponse;
import com.google.cloud.aiplatform.v1.ReadTensorboardBlobDataRequest;
import com.google.cloud.aiplatform.v1.ReadTensorboardBlobDataResponse;
import com.google.cloud.aiplatform.v1.ReadTensorboardTimeSeriesDataRequest;
import com.google.cloud.aiplatform.v1.ReadTensorboardTimeSeriesDataResponse;
import com.google.cloud.aiplatform.v1.ReadTensorboardUsageRequest;
import com.google.cloud.aiplatform.v1.ReadTensorboardUsageResponse;
import com.google.cloud.aiplatform.v1.Tensorboard;
import com.google.cloud.aiplatform.v1.TensorboardExperiment;
import com.google.cloud.aiplatform.v1.TensorboardRun;
import com.google.cloud.aiplatform.v1.TensorboardTimeSeries;
import com.google.cloud.aiplatform.v1.UpdateTensorboardExperimentRequest;
import com.google.cloud.aiplatform.v1.UpdateTensorboardOperationMetadata;
import com.google.cloud.aiplatform.v1.UpdateTensorboardRequest;
import com.google.cloud.aiplatform.v1.UpdateTensorboardRunRequest;
import com.google.cloud.aiplatform.v1.UpdateTensorboardTimeSeriesRequest;
import com.google.cloud.aiplatform.v1.WriteTensorboardExperimentDataRequest;
import com.google.cloud.aiplatform.v1.WriteTensorboardExperimentDataResponse;
import com.google.cloud.aiplatform.v1.WriteTensorboardRunDataRequest;
import com.google.cloud.aiplatform.v1.WriteTensorboardRunDataResponse;
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
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the TensorboardService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcTensorboardServiceStub extends TensorboardServiceStub {
  private static final MethodDescriptor<CreateTensorboardRequest, Operation>
      createTensorboardMethodDescriptor =
          MethodDescriptor.<CreateTensorboardRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1.TensorboardService/CreateTensorboard")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateTensorboardRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetTensorboardRequest, Tensorboard>
      getTensorboardMethodDescriptor =
          MethodDescriptor.<GetTensorboardRequest, Tensorboard>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1.TensorboardService/GetTensorboard")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetTensorboardRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Tensorboard.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ReadTensorboardUsageRequest, ReadTensorboardUsageResponse>
      readTensorboardUsageMethodDescriptor =
          MethodDescriptor.<ReadTensorboardUsageRequest, ReadTensorboardUsageResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.TensorboardService/ReadTensorboardUsage")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ReadTensorboardUsageRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ReadTensorboardUsageResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateTensorboardRequest, Operation>
      updateTensorboardMethodDescriptor =
          MethodDescriptor.<UpdateTensorboardRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1.TensorboardService/UpdateTensorboard")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateTensorboardRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListTensorboardsRequest, ListTensorboardsResponse>
      listTensorboardsMethodDescriptor =
          MethodDescriptor.<ListTensorboardsRequest, ListTensorboardsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1.TensorboardService/ListTensorboards")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListTensorboardsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListTensorboardsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteTensorboardRequest, Operation>
      deleteTensorboardMethodDescriptor =
          MethodDescriptor.<DeleteTensorboardRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1.TensorboardService/DeleteTensorboard")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteTensorboardRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateTensorboardExperimentRequest, TensorboardExperiment>
      createTensorboardExperimentMethodDescriptor =
          MethodDescriptor.<CreateTensorboardExperimentRequest, TensorboardExperiment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.TensorboardService/CreateTensorboardExperiment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateTensorboardExperimentRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TensorboardExperiment.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetTensorboardExperimentRequest, TensorboardExperiment>
      getTensorboardExperimentMethodDescriptor =
          MethodDescriptor.<GetTensorboardExperimentRequest, TensorboardExperiment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.TensorboardService/GetTensorboardExperiment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetTensorboardExperimentRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TensorboardExperiment.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateTensorboardExperimentRequest, TensorboardExperiment>
      updateTensorboardExperimentMethodDescriptor =
          MethodDescriptor.<UpdateTensorboardExperimentRequest, TensorboardExperiment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.TensorboardService/UpdateTensorboardExperiment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateTensorboardExperimentRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TensorboardExperiment.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListTensorboardExperimentsRequest, ListTensorboardExperimentsResponse>
      listTensorboardExperimentsMethodDescriptor =
          MethodDescriptor
              .<ListTensorboardExperimentsRequest, ListTensorboardExperimentsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.TensorboardService/ListTensorboardExperiments")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListTensorboardExperimentsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListTensorboardExperimentsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteTensorboardExperimentRequest, Operation>
      deleteTensorboardExperimentMethodDescriptor =
          MethodDescriptor.<DeleteTensorboardExperimentRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.TensorboardService/DeleteTensorboardExperiment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteTensorboardExperimentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateTensorboardRunRequest, TensorboardRun>
      createTensorboardRunMethodDescriptor =
          MethodDescriptor.<CreateTensorboardRunRequest, TensorboardRun>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.TensorboardService/CreateTensorboardRun")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateTensorboardRunRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(TensorboardRun.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          BatchCreateTensorboardRunsRequest, BatchCreateTensorboardRunsResponse>
      batchCreateTensorboardRunsMethodDescriptor =
          MethodDescriptor
              .<BatchCreateTensorboardRunsRequest, BatchCreateTensorboardRunsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.TensorboardService/BatchCreateTensorboardRuns")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchCreateTensorboardRunsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(BatchCreateTensorboardRunsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetTensorboardRunRequest, TensorboardRun>
      getTensorboardRunMethodDescriptor =
          MethodDescriptor.<GetTensorboardRunRequest, TensorboardRun>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1.TensorboardService/GetTensorboardRun")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetTensorboardRunRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(TensorboardRun.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateTensorboardRunRequest, TensorboardRun>
      updateTensorboardRunMethodDescriptor =
          MethodDescriptor.<UpdateTensorboardRunRequest, TensorboardRun>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.TensorboardService/UpdateTensorboardRun")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateTensorboardRunRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(TensorboardRun.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListTensorboardRunsRequest, ListTensorboardRunsResponse>
      listTensorboardRunsMethodDescriptor =
          MethodDescriptor.<ListTensorboardRunsRequest, ListTensorboardRunsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.TensorboardService/ListTensorboardRuns")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListTensorboardRunsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListTensorboardRunsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteTensorboardRunRequest, Operation>
      deleteTensorboardRunMethodDescriptor =
          MethodDescriptor.<DeleteTensorboardRunRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.TensorboardService/DeleteTensorboardRun")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteTensorboardRunRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          BatchCreateTensorboardTimeSeriesRequest, BatchCreateTensorboardTimeSeriesResponse>
      batchCreateTensorboardTimeSeriesMethodDescriptor =
          MethodDescriptor
              .<BatchCreateTensorboardTimeSeriesRequest, BatchCreateTensorboardTimeSeriesResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.TensorboardService/BatchCreateTensorboardTimeSeries")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      BatchCreateTensorboardTimeSeriesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      BatchCreateTensorboardTimeSeriesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateTensorboardTimeSeriesRequest, TensorboardTimeSeries>
      createTensorboardTimeSeriesMethodDescriptor =
          MethodDescriptor.<CreateTensorboardTimeSeriesRequest, TensorboardTimeSeries>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.TensorboardService/CreateTensorboardTimeSeries")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateTensorboardTimeSeriesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TensorboardTimeSeries.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetTensorboardTimeSeriesRequest, TensorboardTimeSeries>
      getTensorboardTimeSeriesMethodDescriptor =
          MethodDescriptor.<GetTensorboardTimeSeriesRequest, TensorboardTimeSeries>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.TensorboardService/GetTensorboardTimeSeries")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetTensorboardTimeSeriesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TensorboardTimeSeries.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateTensorboardTimeSeriesRequest, TensorboardTimeSeries>
      updateTensorboardTimeSeriesMethodDescriptor =
          MethodDescriptor.<UpdateTensorboardTimeSeriesRequest, TensorboardTimeSeries>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.TensorboardService/UpdateTensorboardTimeSeries")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateTensorboardTimeSeriesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TensorboardTimeSeries.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListTensorboardTimeSeriesRequest, ListTensorboardTimeSeriesResponse>
      listTensorboardTimeSeriesMethodDescriptor =
          MethodDescriptor
              .<ListTensorboardTimeSeriesRequest, ListTensorboardTimeSeriesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.TensorboardService/ListTensorboardTimeSeries")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListTensorboardTimeSeriesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListTensorboardTimeSeriesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteTensorboardTimeSeriesRequest, Operation>
      deleteTensorboardTimeSeriesMethodDescriptor =
          MethodDescriptor.<DeleteTensorboardTimeSeriesRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.TensorboardService/DeleteTensorboardTimeSeries")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteTensorboardTimeSeriesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          BatchReadTensorboardTimeSeriesDataRequest, BatchReadTensorboardTimeSeriesDataResponse>
      batchReadTensorboardTimeSeriesDataMethodDescriptor =
          MethodDescriptor
              .<BatchReadTensorboardTimeSeriesDataRequest,
                  BatchReadTensorboardTimeSeriesDataResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.TensorboardService/BatchReadTensorboardTimeSeriesData")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      BatchReadTensorboardTimeSeriesDataRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      BatchReadTensorboardTimeSeriesDataResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ReadTensorboardTimeSeriesDataRequest, ReadTensorboardTimeSeriesDataResponse>
      readTensorboardTimeSeriesDataMethodDescriptor =
          MethodDescriptor
              .<ReadTensorboardTimeSeriesDataRequest, ReadTensorboardTimeSeriesDataResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.TensorboardService/ReadTensorboardTimeSeriesData")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ReadTensorboardTimeSeriesDataRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ReadTensorboardTimeSeriesDataResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ReadTensorboardBlobDataRequest, ReadTensorboardBlobDataResponse>
      readTensorboardBlobDataMethodDescriptor =
          MethodDescriptor
              .<ReadTensorboardBlobDataRequest, ReadTensorboardBlobDataResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.TensorboardService/ReadTensorboardBlobData")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ReadTensorboardBlobDataRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ReadTensorboardBlobDataResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          WriteTensorboardExperimentDataRequest, WriteTensorboardExperimentDataResponse>
      writeTensorboardExperimentDataMethodDescriptor =
          MethodDescriptor
              .<WriteTensorboardExperimentDataRequest, WriteTensorboardExperimentDataResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.TensorboardService/WriteTensorboardExperimentData")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(WriteTensorboardExperimentDataRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      WriteTensorboardExperimentDataResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          WriteTensorboardRunDataRequest, WriteTensorboardRunDataResponse>
      writeTensorboardRunDataMethodDescriptor =
          MethodDescriptor
              .<WriteTensorboardRunDataRequest, WriteTensorboardRunDataResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.TensorboardService/WriteTensorboardRunData")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(WriteTensorboardRunDataRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(WriteTensorboardRunDataResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ExportTensorboardTimeSeriesDataRequest, ExportTensorboardTimeSeriesDataResponse>
      exportTensorboardTimeSeriesDataMethodDescriptor =
          MethodDescriptor
              .<ExportTensorboardTimeSeriesDataRequest, ExportTensorboardTimeSeriesDataResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.TensorboardService/ExportTensorboardTimeSeriesData")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      ExportTensorboardTimeSeriesDataRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      ExportTensorboardTimeSeriesDataResponse.getDefaultInstance()))
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

  private final UnaryCallable<CreateTensorboardRequest, Operation> createTensorboardCallable;
  private final OperationCallable<
          CreateTensorboardRequest, Tensorboard, CreateTensorboardOperationMetadata>
      createTensorboardOperationCallable;
  private final UnaryCallable<GetTensorboardRequest, Tensorboard> getTensorboardCallable;
  private final UnaryCallable<ReadTensorboardUsageRequest, ReadTensorboardUsageResponse>
      readTensorboardUsageCallable;
  private final UnaryCallable<UpdateTensorboardRequest, Operation> updateTensorboardCallable;
  private final OperationCallable<
          UpdateTensorboardRequest, Tensorboard, UpdateTensorboardOperationMetadata>
      updateTensorboardOperationCallable;
  private final UnaryCallable<ListTensorboardsRequest, ListTensorboardsResponse>
      listTensorboardsCallable;
  private final UnaryCallable<ListTensorboardsRequest, ListTensorboardsPagedResponse>
      listTensorboardsPagedCallable;
  private final UnaryCallable<DeleteTensorboardRequest, Operation> deleteTensorboardCallable;
  private final OperationCallable<DeleteTensorboardRequest, Empty, DeleteOperationMetadata>
      deleteTensorboardOperationCallable;
  private final UnaryCallable<CreateTensorboardExperimentRequest, TensorboardExperiment>
      createTensorboardExperimentCallable;
  private final UnaryCallable<GetTensorboardExperimentRequest, TensorboardExperiment>
      getTensorboardExperimentCallable;
  private final UnaryCallable<UpdateTensorboardExperimentRequest, TensorboardExperiment>
      updateTensorboardExperimentCallable;
  private final UnaryCallable<ListTensorboardExperimentsRequest, ListTensorboardExperimentsResponse>
      listTensorboardExperimentsCallable;
  private final UnaryCallable<
          ListTensorboardExperimentsRequest, ListTensorboardExperimentsPagedResponse>
      listTensorboardExperimentsPagedCallable;
  private final UnaryCallable<DeleteTensorboardExperimentRequest, Operation>
      deleteTensorboardExperimentCallable;
  private final OperationCallable<
          DeleteTensorboardExperimentRequest, Empty, DeleteOperationMetadata>
      deleteTensorboardExperimentOperationCallable;
  private final UnaryCallable<CreateTensorboardRunRequest, TensorboardRun>
      createTensorboardRunCallable;
  private final UnaryCallable<BatchCreateTensorboardRunsRequest, BatchCreateTensorboardRunsResponse>
      batchCreateTensorboardRunsCallable;
  private final UnaryCallable<GetTensorboardRunRequest, TensorboardRun> getTensorboardRunCallable;
  private final UnaryCallable<UpdateTensorboardRunRequest, TensorboardRun>
      updateTensorboardRunCallable;
  private final UnaryCallable<ListTensorboardRunsRequest, ListTensorboardRunsResponse>
      listTensorboardRunsCallable;
  private final UnaryCallable<ListTensorboardRunsRequest, ListTensorboardRunsPagedResponse>
      listTensorboardRunsPagedCallable;
  private final UnaryCallable<DeleteTensorboardRunRequest, Operation> deleteTensorboardRunCallable;
  private final OperationCallable<DeleteTensorboardRunRequest, Empty, DeleteOperationMetadata>
      deleteTensorboardRunOperationCallable;
  private final UnaryCallable<
          BatchCreateTensorboardTimeSeriesRequest, BatchCreateTensorboardTimeSeriesResponse>
      batchCreateTensorboardTimeSeriesCallable;
  private final UnaryCallable<CreateTensorboardTimeSeriesRequest, TensorboardTimeSeries>
      createTensorboardTimeSeriesCallable;
  private final UnaryCallable<GetTensorboardTimeSeriesRequest, TensorboardTimeSeries>
      getTensorboardTimeSeriesCallable;
  private final UnaryCallable<UpdateTensorboardTimeSeriesRequest, TensorboardTimeSeries>
      updateTensorboardTimeSeriesCallable;
  private final UnaryCallable<ListTensorboardTimeSeriesRequest, ListTensorboardTimeSeriesResponse>
      listTensorboardTimeSeriesCallable;
  private final UnaryCallable<
          ListTensorboardTimeSeriesRequest, ListTensorboardTimeSeriesPagedResponse>
      listTensorboardTimeSeriesPagedCallable;
  private final UnaryCallable<DeleteTensorboardTimeSeriesRequest, Operation>
      deleteTensorboardTimeSeriesCallable;
  private final OperationCallable<
          DeleteTensorboardTimeSeriesRequest, Empty, DeleteOperationMetadata>
      deleteTensorboardTimeSeriesOperationCallable;
  private final UnaryCallable<
          BatchReadTensorboardTimeSeriesDataRequest, BatchReadTensorboardTimeSeriesDataResponse>
      batchReadTensorboardTimeSeriesDataCallable;
  private final UnaryCallable<
          ReadTensorboardTimeSeriesDataRequest, ReadTensorboardTimeSeriesDataResponse>
      readTensorboardTimeSeriesDataCallable;
  private final ServerStreamingCallable<
          ReadTensorboardBlobDataRequest, ReadTensorboardBlobDataResponse>
      readTensorboardBlobDataCallable;
  private final UnaryCallable<
          WriteTensorboardExperimentDataRequest, WriteTensorboardExperimentDataResponse>
      writeTensorboardExperimentDataCallable;
  private final UnaryCallable<WriteTensorboardRunDataRequest, WriteTensorboardRunDataResponse>
      writeTensorboardRunDataCallable;
  private final UnaryCallable<
          ExportTensorboardTimeSeriesDataRequest, ExportTensorboardTimeSeriesDataResponse>
      exportTensorboardTimeSeriesDataCallable;
  private final UnaryCallable<
          ExportTensorboardTimeSeriesDataRequest, ExportTensorboardTimeSeriesDataPagedResponse>
      exportTensorboardTimeSeriesDataPagedCallable;
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

  public static final GrpcTensorboardServiceStub create(TensorboardServiceStubSettings settings)
      throws IOException {
    return new GrpcTensorboardServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcTensorboardServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcTensorboardServiceStub(
        TensorboardServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcTensorboardServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcTensorboardServiceStub(
        TensorboardServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcTensorboardServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcTensorboardServiceStub(
      TensorboardServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcTensorboardServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcTensorboardServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcTensorboardServiceStub(
      TensorboardServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateTensorboardRequest, Operation> createTensorboardTransportSettings =
        GrpcCallSettings.<CreateTensorboardRequest, Operation>newBuilder()
            .setMethodDescriptor(createTensorboardMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetTensorboardRequest, Tensorboard> getTensorboardTransportSettings =
        GrpcCallSettings.<GetTensorboardRequest, Tensorboard>newBuilder()
            .setMethodDescriptor(getTensorboardMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ReadTensorboardUsageRequest, ReadTensorboardUsageResponse>
        readTensorboardUsageTransportSettings =
            GrpcCallSettings.<ReadTensorboardUsageRequest, ReadTensorboardUsageResponse>newBuilder()
                .setMethodDescriptor(readTensorboardUsageMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("tensorboard", String.valueOf(request.getTensorboard()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UpdateTensorboardRequest, Operation> updateTensorboardTransportSettings =
        GrpcCallSettings.<UpdateTensorboardRequest, Operation>newBuilder()
            .setMethodDescriptor(updateTensorboardMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put(
                      "tensorboard.name", String.valueOf(request.getTensorboard().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListTensorboardsRequest, ListTensorboardsResponse>
        listTensorboardsTransportSettings =
            GrpcCallSettings.<ListTensorboardsRequest, ListTensorboardsResponse>newBuilder()
                .setMethodDescriptor(listTensorboardsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteTensorboardRequest, Operation> deleteTensorboardTransportSettings =
        GrpcCallSettings.<DeleteTensorboardRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteTensorboardMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateTensorboardExperimentRequest, TensorboardExperiment>
        createTensorboardExperimentTransportSettings =
            GrpcCallSettings.<CreateTensorboardExperimentRequest, TensorboardExperiment>newBuilder()
                .setMethodDescriptor(createTensorboardExperimentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetTensorboardExperimentRequest, TensorboardExperiment>
        getTensorboardExperimentTransportSettings =
            GrpcCallSettings.<GetTensorboardExperimentRequest, TensorboardExperiment>newBuilder()
                .setMethodDescriptor(getTensorboardExperimentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UpdateTensorboardExperimentRequest, TensorboardExperiment>
        updateTensorboardExperimentTransportSettings =
            GrpcCallSettings.<UpdateTensorboardExperimentRequest, TensorboardExperiment>newBuilder()
                .setMethodDescriptor(updateTensorboardExperimentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put(
                          "tensorboard_experiment.name",
                          String.valueOf(request.getTensorboardExperiment().getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListTensorboardExperimentsRequest, ListTensorboardExperimentsResponse>
        listTensorboardExperimentsTransportSettings =
            GrpcCallSettings
                .<ListTensorboardExperimentsRequest, ListTensorboardExperimentsResponse>newBuilder()
                .setMethodDescriptor(listTensorboardExperimentsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteTensorboardExperimentRequest, Operation>
        deleteTensorboardExperimentTransportSettings =
            GrpcCallSettings.<DeleteTensorboardExperimentRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteTensorboardExperimentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<CreateTensorboardRunRequest, TensorboardRun>
        createTensorboardRunTransportSettings =
            GrpcCallSettings.<CreateTensorboardRunRequest, TensorboardRun>newBuilder()
                .setMethodDescriptor(createTensorboardRunMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<BatchCreateTensorboardRunsRequest, BatchCreateTensorboardRunsResponse>
        batchCreateTensorboardRunsTransportSettings =
            GrpcCallSettings
                .<BatchCreateTensorboardRunsRequest, BatchCreateTensorboardRunsResponse>newBuilder()
                .setMethodDescriptor(batchCreateTensorboardRunsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetTensorboardRunRequest, TensorboardRun> getTensorboardRunTransportSettings =
        GrpcCallSettings.<GetTensorboardRunRequest, TensorboardRun>newBuilder()
            .setMethodDescriptor(getTensorboardRunMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateTensorboardRunRequest, TensorboardRun>
        updateTensorboardRunTransportSettings =
            GrpcCallSettings.<UpdateTensorboardRunRequest, TensorboardRun>newBuilder()
                .setMethodDescriptor(updateTensorboardRunMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put(
                          "tensorboard_run.name",
                          String.valueOf(request.getTensorboardRun().getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListTensorboardRunsRequest, ListTensorboardRunsResponse>
        listTensorboardRunsTransportSettings =
            GrpcCallSettings.<ListTensorboardRunsRequest, ListTensorboardRunsResponse>newBuilder()
                .setMethodDescriptor(listTensorboardRunsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteTensorboardRunRequest, Operation> deleteTensorboardRunTransportSettings =
        GrpcCallSettings.<DeleteTensorboardRunRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteTensorboardRunMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<
            BatchCreateTensorboardTimeSeriesRequest, BatchCreateTensorboardTimeSeriesResponse>
        batchCreateTensorboardTimeSeriesTransportSettings =
            GrpcCallSettings
                .<BatchCreateTensorboardTimeSeriesRequest, BatchCreateTensorboardTimeSeriesResponse>
                    newBuilder()
                .setMethodDescriptor(batchCreateTensorboardTimeSeriesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<CreateTensorboardTimeSeriesRequest, TensorboardTimeSeries>
        createTensorboardTimeSeriesTransportSettings =
            GrpcCallSettings.<CreateTensorboardTimeSeriesRequest, TensorboardTimeSeries>newBuilder()
                .setMethodDescriptor(createTensorboardTimeSeriesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetTensorboardTimeSeriesRequest, TensorboardTimeSeries>
        getTensorboardTimeSeriesTransportSettings =
            GrpcCallSettings.<GetTensorboardTimeSeriesRequest, TensorboardTimeSeries>newBuilder()
                .setMethodDescriptor(getTensorboardTimeSeriesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UpdateTensorboardTimeSeriesRequest, TensorboardTimeSeries>
        updateTensorboardTimeSeriesTransportSettings =
            GrpcCallSettings.<UpdateTensorboardTimeSeriesRequest, TensorboardTimeSeries>newBuilder()
                .setMethodDescriptor(updateTensorboardTimeSeriesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put(
                          "tensorboard_time_series.name",
                          String.valueOf(request.getTensorboardTimeSeries().getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListTensorboardTimeSeriesRequest, ListTensorboardTimeSeriesResponse>
        listTensorboardTimeSeriesTransportSettings =
            GrpcCallSettings
                .<ListTensorboardTimeSeriesRequest, ListTensorboardTimeSeriesResponse>newBuilder()
                .setMethodDescriptor(listTensorboardTimeSeriesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteTensorboardTimeSeriesRequest, Operation>
        deleteTensorboardTimeSeriesTransportSettings =
            GrpcCallSettings.<DeleteTensorboardTimeSeriesRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteTensorboardTimeSeriesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<
            BatchReadTensorboardTimeSeriesDataRequest, BatchReadTensorboardTimeSeriesDataResponse>
        batchReadTensorboardTimeSeriesDataTransportSettings =
            GrpcCallSettings
                .<BatchReadTensorboardTimeSeriesDataRequest,
                    BatchReadTensorboardTimeSeriesDataResponse>
                    newBuilder()
                .setMethodDescriptor(batchReadTensorboardTimeSeriesDataMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("tensorboard", String.valueOf(request.getTensorboard()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ReadTensorboardTimeSeriesDataRequest, ReadTensorboardTimeSeriesDataResponse>
        readTensorboardTimeSeriesDataTransportSettings =
            GrpcCallSettings
                .<ReadTensorboardTimeSeriesDataRequest, ReadTensorboardTimeSeriesDataResponse>
                    newBuilder()
                .setMethodDescriptor(readTensorboardTimeSeriesDataMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put(
                          "tensorboard_time_series",
                          String.valueOf(request.getTensorboardTimeSeries()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ReadTensorboardBlobDataRequest, ReadTensorboardBlobDataResponse>
        readTensorboardBlobDataTransportSettings =
            GrpcCallSettings
                .<ReadTensorboardBlobDataRequest, ReadTensorboardBlobDataResponse>newBuilder()
                .setMethodDescriptor(readTensorboardBlobDataMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("time_series", String.valueOf(request.getTimeSeries()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<WriteTensorboardExperimentDataRequest, WriteTensorboardExperimentDataResponse>
        writeTensorboardExperimentDataTransportSettings =
            GrpcCallSettings
                .<WriteTensorboardExperimentDataRequest, WriteTensorboardExperimentDataResponse>
                    newBuilder()
                .setMethodDescriptor(writeTensorboardExperimentDataMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put(
                          "tensorboard_experiment",
                          String.valueOf(request.getTensorboardExperiment()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<WriteTensorboardRunDataRequest, WriteTensorboardRunDataResponse>
        writeTensorboardRunDataTransportSettings =
            GrpcCallSettings
                .<WriteTensorboardRunDataRequest, WriteTensorboardRunDataResponse>newBuilder()
                .setMethodDescriptor(writeTensorboardRunDataMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("tensorboard_run", String.valueOf(request.getTensorboardRun()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<
            ExportTensorboardTimeSeriesDataRequest, ExportTensorboardTimeSeriesDataResponse>
        exportTensorboardTimeSeriesDataTransportSettings =
            GrpcCallSettings
                .<ExportTensorboardTimeSeriesDataRequest, ExportTensorboardTimeSeriesDataResponse>
                    newBuilder()
                .setMethodDescriptor(exportTensorboardTimeSeriesDataMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put(
                          "tensorboard_time_series",
                          String.valueOf(request.getTensorboardTimeSeries()));
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

    this.createTensorboardCallable =
        callableFactory.createUnaryCallable(
            createTensorboardTransportSettings,
            settings.createTensorboardSettings(),
            clientContext);
    this.createTensorboardOperationCallable =
        callableFactory.createOperationCallable(
            createTensorboardTransportSettings,
            settings.createTensorboardOperationSettings(),
            clientContext,
            operationsStub);
    this.getTensorboardCallable =
        callableFactory.createUnaryCallable(
            getTensorboardTransportSettings, settings.getTensorboardSettings(), clientContext);
    this.readTensorboardUsageCallable =
        callableFactory.createUnaryCallable(
            readTensorboardUsageTransportSettings,
            settings.readTensorboardUsageSettings(),
            clientContext);
    this.updateTensorboardCallable =
        callableFactory.createUnaryCallable(
            updateTensorboardTransportSettings,
            settings.updateTensorboardSettings(),
            clientContext);
    this.updateTensorboardOperationCallable =
        callableFactory.createOperationCallable(
            updateTensorboardTransportSettings,
            settings.updateTensorboardOperationSettings(),
            clientContext,
            operationsStub);
    this.listTensorboardsCallable =
        callableFactory.createUnaryCallable(
            listTensorboardsTransportSettings, settings.listTensorboardsSettings(), clientContext);
    this.listTensorboardsPagedCallable =
        callableFactory.createPagedCallable(
            listTensorboardsTransportSettings, settings.listTensorboardsSettings(), clientContext);
    this.deleteTensorboardCallable =
        callableFactory.createUnaryCallable(
            deleteTensorboardTransportSettings,
            settings.deleteTensorboardSettings(),
            clientContext);
    this.deleteTensorboardOperationCallable =
        callableFactory.createOperationCallable(
            deleteTensorboardTransportSettings,
            settings.deleteTensorboardOperationSettings(),
            clientContext,
            operationsStub);
    this.createTensorboardExperimentCallable =
        callableFactory.createUnaryCallable(
            createTensorboardExperimentTransportSettings,
            settings.createTensorboardExperimentSettings(),
            clientContext);
    this.getTensorboardExperimentCallable =
        callableFactory.createUnaryCallable(
            getTensorboardExperimentTransportSettings,
            settings.getTensorboardExperimentSettings(),
            clientContext);
    this.updateTensorboardExperimentCallable =
        callableFactory.createUnaryCallable(
            updateTensorboardExperimentTransportSettings,
            settings.updateTensorboardExperimentSettings(),
            clientContext);
    this.listTensorboardExperimentsCallable =
        callableFactory.createUnaryCallable(
            listTensorboardExperimentsTransportSettings,
            settings.listTensorboardExperimentsSettings(),
            clientContext);
    this.listTensorboardExperimentsPagedCallable =
        callableFactory.createPagedCallable(
            listTensorboardExperimentsTransportSettings,
            settings.listTensorboardExperimentsSettings(),
            clientContext);
    this.deleteTensorboardExperimentCallable =
        callableFactory.createUnaryCallable(
            deleteTensorboardExperimentTransportSettings,
            settings.deleteTensorboardExperimentSettings(),
            clientContext);
    this.deleteTensorboardExperimentOperationCallable =
        callableFactory.createOperationCallable(
            deleteTensorboardExperimentTransportSettings,
            settings.deleteTensorboardExperimentOperationSettings(),
            clientContext,
            operationsStub);
    this.createTensorboardRunCallable =
        callableFactory.createUnaryCallable(
            createTensorboardRunTransportSettings,
            settings.createTensorboardRunSettings(),
            clientContext);
    this.batchCreateTensorboardRunsCallable =
        callableFactory.createUnaryCallable(
            batchCreateTensorboardRunsTransportSettings,
            settings.batchCreateTensorboardRunsSettings(),
            clientContext);
    this.getTensorboardRunCallable =
        callableFactory.createUnaryCallable(
            getTensorboardRunTransportSettings,
            settings.getTensorboardRunSettings(),
            clientContext);
    this.updateTensorboardRunCallable =
        callableFactory.createUnaryCallable(
            updateTensorboardRunTransportSettings,
            settings.updateTensorboardRunSettings(),
            clientContext);
    this.listTensorboardRunsCallable =
        callableFactory.createUnaryCallable(
            listTensorboardRunsTransportSettings,
            settings.listTensorboardRunsSettings(),
            clientContext);
    this.listTensorboardRunsPagedCallable =
        callableFactory.createPagedCallable(
            listTensorboardRunsTransportSettings,
            settings.listTensorboardRunsSettings(),
            clientContext);
    this.deleteTensorboardRunCallable =
        callableFactory.createUnaryCallable(
            deleteTensorboardRunTransportSettings,
            settings.deleteTensorboardRunSettings(),
            clientContext);
    this.deleteTensorboardRunOperationCallable =
        callableFactory.createOperationCallable(
            deleteTensorboardRunTransportSettings,
            settings.deleteTensorboardRunOperationSettings(),
            clientContext,
            operationsStub);
    this.batchCreateTensorboardTimeSeriesCallable =
        callableFactory.createUnaryCallable(
            batchCreateTensorboardTimeSeriesTransportSettings,
            settings.batchCreateTensorboardTimeSeriesSettings(),
            clientContext);
    this.createTensorboardTimeSeriesCallable =
        callableFactory.createUnaryCallable(
            createTensorboardTimeSeriesTransportSettings,
            settings.createTensorboardTimeSeriesSettings(),
            clientContext);
    this.getTensorboardTimeSeriesCallable =
        callableFactory.createUnaryCallable(
            getTensorboardTimeSeriesTransportSettings,
            settings.getTensorboardTimeSeriesSettings(),
            clientContext);
    this.updateTensorboardTimeSeriesCallable =
        callableFactory.createUnaryCallable(
            updateTensorboardTimeSeriesTransportSettings,
            settings.updateTensorboardTimeSeriesSettings(),
            clientContext);
    this.listTensorboardTimeSeriesCallable =
        callableFactory.createUnaryCallable(
            listTensorboardTimeSeriesTransportSettings,
            settings.listTensorboardTimeSeriesSettings(),
            clientContext);
    this.listTensorboardTimeSeriesPagedCallable =
        callableFactory.createPagedCallable(
            listTensorboardTimeSeriesTransportSettings,
            settings.listTensorboardTimeSeriesSettings(),
            clientContext);
    this.deleteTensorboardTimeSeriesCallable =
        callableFactory.createUnaryCallable(
            deleteTensorboardTimeSeriesTransportSettings,
            settings.deleteTensorboardTimeSeriesSettings(),
            clientContext);
    this.deleteTensorboardTimeSeriesOperationCallable =
        callableFactory.createOperationCallable(
            deleteTensorboardTimeSeriesTransportSettings,
            settings.deleteTensorboardTimeSeriesOperationSettings(),
            clientContext,
            operationsStub);
    this.batchReadTensorboardTimeSeriesDataCallable =
        callableFactory.createUnaryCallable(
            batchReadTensorboardTimeSeriesDataTransportSettings,
            settings.batchReadTensorboardTimeSeriesDataSettings(),
            clientContext);
    this.readTensorboardTimeSeriesDataCallable =
        callableFactory.createUnaryCallable(
            readTensorboardTimeSeriesDataTransportSettings,
            settings.readTensorboardTimeSeriesDataSettings(),
            clientContext);
    this.readTensorboardBlobDataCallable =
        callableFactory.createServerStreamingCallable(
            readTensorboardBlobDataTransportSettings,
            settings.readTensorboardBlobDataSettings(),
            clientContext);
    this.writeTensorboardExperimentDataCallable =
        callableFactory.createUnaryCallable(
            writeTensorboardExperimentDataTransportSettings,
            settings.writeTensorboardExperimentDataSettings(),
            clientContext);
    this.writeTensorboardRunDataCallable =
        callableFactory.createUnaryCallable(
            writeTensorboardRunDataTransportSettings,
            settings.writeTensorboardRunDataSettings(),
            clientContext);
    this.exportTensorboardTimeSeriesDataCallable =
        callableFactory.createUnaryCallable(
            exportTensorboardTimeSeriesDataTransportSettings,
            settings.exportTensorboardTimeSeriesDataSettings(),
            clientContext);
    this.exportTensorboardTimeSeriesDataPagedCallable =
        callableFactory.createPagedCallable(
            exportTensorboardTimeSeriesDataTransportSettings,
            settings.exportTensorboardTimeSeriesDataSettings(),
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
  public UnaryCallable<CreateTensorboardRequest, Operation> createTensorboardCallable() {
    return createTensorboardCallable;
  }

  @Override
  public OperationCallable<
          CreateTensorboardRequest, Tensorboard, CreateTensorboardOperationMetadata>
      createTensorboardOperationCallable() {
    return createTensorboardOperationCallable;
  }

  @Override
  public UnaryCallable<GetTensorboardRequest, Tensorboard> getTensorboardCallable() {
    return getTensorboardCallable;
  }

  @Override
  public UnaryCallable<ReadTensorboardUsageRequest, ReadTensorboardUsageResponse>
      readTensorboardUsageCallable() {
    return readTensorboardUsageCallable;
  }

  @Override
  public UnaryCallable<UpdateTensorboardRequest, Operation> updateTensorboardCallable() {
    return updateTensorboardCallable;
  }

  @Override
  public OperationCallable<
          UpdateTensorboardRequest, Tensorboard, UpdateTensorboardOperationMetadata>
      updateTensorboardOperationCallable() {
    return updateTensorboardOperationCallable;
  }

  @Override
  public UnaryCallable<ListTensorboardsRequest, ListTensorboardsResponse>
      listTensorboardsCallable() {
    return listTensorboardsCallable;
  }

  @Override
  public UnaryCallable<ListTensorboardsRequest, ListTensorboardsPagedResponse>
      listTensorboardsPagedCallable() {
    return listTensorboardsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteTensorboardRequest, Operation> deleteTensorboardCallable() {
    return deleteTensorboardCallable;
  }

  @Override
  public OperationCallable<DeleteTensorboardRequest, Empty, DeleteOperationMetadata>
      deleteTensorboardOperationCallable() {
    return deleteTensorboardOperationCallable;
  }

  @Override
  public UnaryCallable<CreateTensorboardExperimentRequest, TensorboardExperiment>
      createTensorboardExperimentCallable() {
    return createTensorboardExperimentCallable;
  }

  @Override
  public UnaryCallable<GetTensorboardExperimentRequest, TensorboardExperiment>
      getTensorboardExperimentCallable() {
    return getTensorboardExperimentCallable;
  }

  @Override
  public UnaryCallable<UpdateTensorboardExperimentRequest, TensorboardExperiment>
      updateTensorboardExperimentCallable() {
    return updateTensorboardExperimentCallable;
  }

  @Override
  public UnaryCallable<ListTensorboardExperimentsRequest, ListTensorboardExperimentsResponse>
      listTensorboardExperimentsCallable() {
    return listTensorboardExperimentsCallable;
  }

  @Override
  public UnaryCallable<ListTensorboardExperimentsRequest, ListTensorboardExperimentsPagedResponse>
      listTensorboardExperimentsPagedCallable() {
    return listTensorboardExperimentsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteTensorboardExperimentRequest, Operation>
      deleteTensorboardExperimentCallable() {
    return deleteTensorboardExperimentCallable;
  }

  @Override
  public OperationCallable<DeleteTensorboardExperimentRequest, Empty, DeleteOperationMetadata>
      deleteTensorboardExperimentOperationCallable() {
    return deleteTensorboardExperimentOperationCallable;
  }

  @Override
  public UnaryCallable<CreateTensorboardRunRequest, TensorboardRun> createTensorboardRunCallable() {
    return createTensorboardRunCallable;
  }

  @Override
  public UnaryCallable<BatchCreateTensorboardRunsRequest, BatchCreateTensorboardRunsResponse>
      batchCreateTensorboardRunsCallable() {
    return batchCreateTensorboardRunsCallable;
  }

  @Override
  public UnaryCallable<GetTensorboardRunRequest, TensorboardRun> getTensorboardRunCallable() {
    return getTensorboardRunCallable;
  }

  @Override
  public UnaryCallable<UpdateTensorboardRunRequest, TensorboardRun> updateTensorboardRunCallable() {
    return updateTensorboardRunCallable;
  }

  @Override
  public UnaryCallable<ListTensorboardRunsRequest, ListTensorboardRunsResponse>
      listTensorboardRunsCallable() {
    return listTensorboardRunsCallable;
  }

  @Override
  public UnaryCallable<ListTensorboardRunsRequest, ListTensorboardRunsPagedResponse>
      listTensorboardRunsPagedCallable() {
    return listTensorboardRunsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteTensorboardRunRequest, Operation> deleteTensorboardRunCallable() {
    return deleteTensorboardRunCallable;
  }

  @Override
  public OperationCallable<DeleteTensorboardRunRequest, Empty, DeleteOperationMetadata>
      deleteTensorboardRunOperationCallable() {
    return deleteTensorboardRunOperationCallable;
  }

  @Override
  public UnaryCallable<
          BatchCreateTensorboardTimeSeriesRequest, BatchCreateTensorboardTimeSeriesResponse>
      batchCreateTensorboardTimeSeriesCallable() {
    return batchCreateTensorboardTimeSeriesCallable;
  }

  @Override
  public UnaryCallable<CreateTensorboardTimeSeriesRequest, TensorboardTimeSeries>
      createTensorboardTimeSeriesCallable() {
    return createTensorboardTimeSeriesCallable;
  }

  @Override
  public UnaryCallable<GetTensorboardTimeSeriesRequest, TensorboardTimeSeries>
      getTensorboardTimeSeriesCallable() {
    return getTensorboardTimeSeriesCallable;
  }

  @Override
  public UnaryCallable<UpdateTensorboardTimeSeriesRequest, TensorboardTimeSeries>
      updateTensorboardTimeSeriesCallable() {
    return updateTensorboardTimeSeriesCallable;
  }

  @Override
  public UnaryCallable<ListTensorboardTimeSeriesRequest, ListTensorboardTimeSeriesResponse>
      listTensorboardTimeSeriesCallable() {
    return listTensorboardTimeSeriesCallable;
  }

  @Override
  public UnaryCallable<ListTensorboardTimeSeriesRequest, ListTensorboardTimeSeriesPagedResponse>
      listTensorboardTimeSeriesPagedCallable() {
    return listTensorboardTimeSeriesPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteTensorboardTimeSeriesRequest, Operation>
      deleteTensorboardTimeSeriesCallable() {
    return deleteTensorboardTimeSeriesCallable;
  }

  @Override
  public OperationCallable<DeleteTensorboardTimeSeriesRequest, Empty, DeleteOperationMetadata>
      deleteTensorboardTimeSeriesOperationCallable() {
    return deleteTensorboardTimeSeriesOperationCallable;
  }

  @Override
  public UnaryCallable<
          BatchReadTensorboardTimeSeriesDataRequest, BatchReadTensorboardTimeSeriesDataResponse>
      batchReadTensorboardTimeSeriesDataCallable() {
    return batchReadTensorboardTimeSeriesDataCallable;
  }

  @Override
  public UnaryCallable<ReadTensorboardTimeSeriesDataRequest, ReadTensorboardTimeSeriesDataResponse>
      readTensorboardTimeSeriesDataCallable() {
    return readTensorboardTimeSeriesDataCallable;
  }

  @Override
  public ServerStreamingCallable<ReadTensorboardBlobDataRequest, ReadTensorboardBlobDataResponse>
      readTensorboardBlobDataCallable() {
    return readTensorboardBlobDataCallable;
  }

  @Override
  public UnaryCallable<
          WriteTensorboardExperimentDataRequest, WriteTensorboardExperimentDataResponse>
      writeTensorboardExperimentDataCallable() {
    return writeTensorboardExperimentDataCallable;
  }

  @Override
  public UnaryCallable<WriteTensorboardRunDataRequest, WriteTensorboardRunDataResponse>
      writeTensorboardRunDataCallable() {
    return writeTensorboardRunDataCallable;
  }

  @Override
  public UnaryCallable<
          ExportTensorboardTimeSeriesDataRequest, ExportTensorboardTimeSeriesDataResponse>
      exportTensorboardTimeSeriesDataCallable() {
    return exportTensorboardTimeSeriesDataCallable;
  }

  @Override
  public UnaryCallable<
          ExportTensorboardTimeSeriesDataRequest, ExportTensorboardTimeSeriesDataPagedResponse>
      exportTensorboardTimeSeriesDataPagedCallable() {
    return exportTensorboardTimeSeriesDataPagedCallable;
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
