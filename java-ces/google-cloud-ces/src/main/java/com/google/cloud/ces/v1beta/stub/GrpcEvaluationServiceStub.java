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

package com.google.cloud.ces.v1beta.stub;

import static com.google.cloud.ces.v1beta.EvaluationServiceClient.ListEvaluationDatasetsPagedResponse;
import static com.google.cloud.ces.v1beta.EvaluationServiceClient.ListEvaluationExpectationsPagedResponse;
import static com.google.cloud.ces.v1beta.EvaluationServiceClient.ListEvaluationResultsPagedResponse;
import static com.google.cloud.ces.v1beta.EvaluationServiceClient.ListEvaluationRunsPagedResponse;
import static com.google.cloud.ces.v1beta.EvaluationServiceClient.ListEvaluationsPagedResponse;
import static com.google.cloud.ces.v1beta.EvaluationServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.ces.v1beta.EvaluationServiceClient.ListScheduledEvaluationRunsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.ces.v1beta.CreateEvaluationDatasetRequest;
import com.google.cloud.ces.v1beta.CreateEvaluationExpectationRequest;
import com.google.cloud.ces.v1beta.CreateEvaluationRequest;
import com.google.cloud.ces.v1beta.CreateScheduledEvaluationRunRequest;
import com.google.cloud.ces.v1beta.DeleteEvaluationDatasetRequest;
import com.google.cloud.ces.v1beta.DeleteEvaluationExpectationRequest;
import com.google.cloud.ces.v1beta.DeleteEvaluationRequest;
import com.google.cloud.ces.v1beta.DeleteEvaluationResultRequest;
import com.google.cloud.ces.v1beta.DeleteEvaluationRunOperationMetadata;
import com.google.cloud.ces.v1beta.DeleteEvaluationRunRequest;
import com.google.cloud.ces.v1beta.DeleteScheduledEvaluationRunRequest;
import com.google.cloud.ces.v1beta.Evaluation;
import com.google.cloud.ces.v1beta.EvaluationDataset;
import com.google.cloud.ces.v1beta.EvaluationExpectation;
import com.google.cloud.ces.v1beta.EvaluationResult;
import com.google.cloud.ces.v1beta.EvaluationRun;
import com.google.cloud.ces.v1beta.GenerateEvaluationOperationMetadata;
import com.google.cloud.ces.v1beta.GenerateEvaluationRequest;
import com.google.cloud.ces.v1beta.GetEvaluationDatasetRequest;
import com.google.cloud.ces.v1beta.GetEvaluationExpectationRequest;
import com.google.cloud.ces.v1beta.GetEvaluationRequest;
import com.google.cloud.ces.v1beta.GetEvaluationResultRequest;
import com.google.cloud.ces.v1beta.GetEvaluationRunRequest;
import com.google.cloud.ces.v1beta.GetScheduledEvaluationRunRequest;
import com.google.cloud.ces.v1beta.ImportEvaluationsOperationMetadata;
import com.google.cloud.ces.v1beta.ImportEvaluationsRequest;
import com.google.cloud.ces.v1beta.ImportEvaluationsResponse;
import com.google.cloud.ces.v1beta.ListEvaluationDatasetsRequest;
import com.google.cloud.ces.v1beta.ListEvaluationDatasetsResponse;
import com.google.cloud.ces.v1beta.ListEvaluationExpectationsRequest;
import com.google.cloud.ces.v1beta.ListEvaluationExpectationsResponse;
import com.google.cloud.ces.v1beta.ListEvaluationResultsRequest;
import com.google.cloud.ces.v1beta.ListEvaluationResultsResponse;
import com.google.cloud.ces.v1beta.ListEvaluationRunsRequest;
import com.google.cloud.ces.v1beta.ListEvaluationRunsResponse;
import com.google.cloud.ces.v1beta.ListEvaluationsRequest;
import com.google.cloud.ces.v1beta.ListEvaluationsResponse;
import com.google.cloud.ces.v1beta.ListScheduledEvaluationRunsRequest;
import com.google.cloud.ces.v1beta.ListScheduledEvaluationRunsResponse;
import com.google.cloud.ces.v1beta.RunEvaluationOperationMetadata;
import com.google.cloud.ces.v1beta.RunEvaluationRequest;
import com.google.cloud.ces.v1beta.RunEvaluationResponse;
import com.google.cloud.ces.v1beta.ScheduledEvaluationRun;
import com.google.cloud.ces.v1beta.TestPersonaVoiceRequest;
import com.google.cloud.ces.v1beta.TestPersonaVoiceResponse;
import com.google.cloud.ces.v1beta.UpdateEvaluationDatasetRequest;
import com.google.cloud.ces.v1beta.UpdateEvaluationExpectationRequest;
import com.google.cloud.ces.v1beta.UpdateEvaluationRequest;
import com.google.cloud.ces.v1beta.UpdateScheduledEvaluationRunRequest;
import com.google.cloud.ces.v1beta.UploadEvaluationAudioRequest;
import com.google.cloud.ces.v1beta.UploadEvaluationAudioResponse;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
 * gRPC stub implementation for the EvaluationService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcEvaluationServiceStub extends EvaluationServiceStub {
  private static final MethodDescriptor<RunEvaluationRequest, Operation>
      runEvaluationMethodDescriptor =
          MethodDescriptor.<RunEvaluationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.ces.v1beta.EvaluationService/RunEvaluation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RunEvaluationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UploadEvaluationAudioRequest, UploadEvaluationAudioResponse>
      uploadEvaluationAudioMethodDescriptor =
          MethodDescriptor.<UploadEvaluationAudioRequest, UploadEvaluationAudioResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.ces.v1beta.EvaluationService/UploadEvaluationAudio")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UploadEvaluationAudioRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(UploadEvaluationAudioResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateEvaluationRequest, Evaluation>
      createEvaluationMethodDescriptor =
          MethodDescriptor.<CreateEvaluationRequest, Evaluation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.ces.v1beta.EvaluationService/CreateEvaluation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateEvaluationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Evaluation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GenerateEvaluationRequest, Operation>
      generateEvaluationMethodDescriptor =
          MethodDescriptor.<GenerateEvaluationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.ces.v1beta.EvaluationService/GenerateEvaluation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GenerateEvaluationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ImportEvaluationsRequest, Operation>
      importEvaluationsMethodDescriptor =
          MethodDescriptor.<ImportEvaluationsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.ces.v1beta.EvaluationService/ImportEvaluations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ImportEvaluationsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateEvaluationDatasetRequest, EvaluationDataset>
      createEvaluationDatasetMethodDescriptor =
          MethodDescriptor.<CreateEvaluationDatasetRequest, EvaluationDataset>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.ces.v1beta.EvaluationService/CreateEvaluationDataset")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateEvaluationDatasetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(EvaluationDataset.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateEvaluationRequest, Evaluation>
      updateEvaluationMethodDescriptor =
          MethodDescriptor.<UpdateEvaluationRequest, Evaluation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.ces.v1beta.EvaluationService/UpdateEvaluation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateEvaluationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Evaluation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateEvaluationDatasetRequest, EvaluationDataset>
      updateEvaluationDatasetMethodDescriptor =
          MethodDescriptor.<UpdateEvaluationDatasetRequest, EvaluationDataset>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.ces.v1beta.EvaluationService/UpdateEvaluationDataset")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateEvaluationDatasetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(EvaluationDataset.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteEvaluationRequest, Empty>
      deleteEvaluationMethodDescriptor =
          MethodDescriptor.<DeleteEvaluationRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.ces.v1beta.EvaluationService/DeleteEvaluation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteEvaluationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteEvaluationResultRequest, Empty>
      deleteEvaluationResultMethodDescriptor =
          MethodDescriptor.<DeleteEvaluationResultRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.ces.v1beta.EvaluationService/DeleteEvaluationResult")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteEvaluationResultRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteEvaluationDatasetRequest, Empty>
      deleteEvaluationDatasetMethodDescriptor =
          MethodDescriptor.<DeleteEvaluationDatasetRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.ces.v1beta.EvaluationService/DeleteEvaluationDataset")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteEvaluationDatasetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteEvaluationRunRequest, Operation>
      deleteEvaluationRunMethodDescriptor =
          MethodDescriptor.<DeleteEvaluationRunRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.ces.v1beta.EvaluationService/DeleteEvaluationRun")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteEvaluationRunRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetEvaluationRequest, Evaluation>
      getEvaluationMethodDescriptor =
          MethodDescriptor.<GetEvaluationRequest, Evaluation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.ces.v1beta.EvaluationService/GetEvaluation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetEvaluationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Evaluation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetEvaluationResultRequest, EvaluationResult>
      getEvaluationResultMethodDescriptor =
          MethodDescriptor.<GetEvaluationResultRequest, EvaluationResult>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.ces.v1beta.EvaluationService/GetEvaluationResult")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetEvaluationResultRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(EvaluationResult.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetEvaluationDatasetRequest, EvaluationDataset>
      getEvaluationDatasetMethodDescriptor =
          MethodDescriptor.<GetEvaluationDatasetRequest, EvaluationDataset>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.ces.v1beta.EvaluationService/GetEvaluationDataset")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetEvaluationDatasetRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(EvaluationDataset.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetEvaluationRunRequest, EvaluationRun>
      getEvaluationRunMethodDescriptor =
          MethodDescriptor.<GetEvaluationRunRequest, EvaluationRun>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.ces.v1beta.EvaluationService/GetEvaluationRun")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetEvaluationRunRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(EvaluationRun.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListEvaluationsRequest, ListEvaluationsResponse>
      listEvaluationsMethodDescriptor =
          MethodDescriptor.<ListEvaluationsRequest, ListEvaluationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.ces.v1beta.EvaluationService/ListEvaluations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListEvaluationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListEvaluationsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListEvaluationResultsRequest, ListEvaluationResultsResponse>
      listEvaluationResultsMethodDescriptor =
          MethodDescriptor.<ListEvaluationResultsRequest, ListEvaluationResultsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.ces.v1beta.EvaluationService/ListEvaluationResults")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListEvaluationResultsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListEvaluationResultsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListEvaluationDatasetsRequest, ListEvaluationDatasetsResponse>
      listEvaluationDatasetsMethodDescriptor =
          MethodDescriptor
              .<ListEvaluationDatasetsRequest, ListEvaluationDatasetsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.ces.v1beta.EvaluationService/ListEvaluationDatasets")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListEvaluationDatasetsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListEvaluationDatasetsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListEvaluationRunsRequest, ListEvaluationRunsResponse>
      listEvaluationRunsMethodDescriptor =
          MethodDescriptor.<ListEvaluationRunsRequest, ListEvaluationRunsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.ces.v1beta.EvaluationService/ListEvaluationRuns")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListEvaluationRunsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListEvaluationRunsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListEvaluationExpectationsRequest, ListEvaluationExpectationsResponse>
      listEvaluationExpectationsMethodDescriptor =
          MethodDescriptor
              .<ListEvaluationExpectationsRequest, ListEvaluationExpectationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.ces.v1beta.EvaluationService/ListEvaluationExpectations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListEvaluationExpectationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListEvaluationExpectationsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetEvaluationExpectationRequest, EvaluationExpectation>
      getEvaluationExpectationMethodDescriptor =
          MethodDescriptor.<GetEvaluationExpectationRequest, EvaluationExpectation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.ces.v1beta.EvaluationService/GetEvaluationExpectation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetEvaluationExpectationRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(EvaluationExpectation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateEvaluationExpectationRequest, EvaluationExpectation>
      createEvaluationExpectationMethodDescriptor =
          MethodDescriptor.<CreateEvaluationExpectationRequest, EvaluationExpectation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.ces.v1beta.EvaluationService/CreateEvaluationExpectation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateEvaluationExpectationRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(EvaluationExpectation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateEvaluationExpectationRequest, EvaluationExpectation>
      updateEvaluationExpectationMethodDescriptor =
          MethodDescriptor.<UpdateEvaluationExpectationRequest, EvaluationExpectation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.ces.v1beta.EvaluationService/UpdateEvaluationExpectation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateEvaluationExpectationRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(EvaluationExpectation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteEvaluationExpectationRequest, Empty>
      deleteEvaluationExpectationMethodDescriptor =
          MethodDescriptor.<DeleteEvaluationExpectationRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.ces.v1beta.EvaluationService/DeleteEvaluationExpectation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteEvaluationExpectationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateScheduledEvaluationRunRequest, ScheduledEvaluationRun>
      createScheduledEvaluationRunMethodDescriptor =
          MethodDescriptor.<CreateScheduledEvaluationRunRequest, ScheduledEvaluationRun>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.ces.v1beta.EvaluationService/CreateScheduledEvaluationRun")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateScheduledEvaluationRunRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ScheduledEvaluationRun.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetScheduledEvaluationRunRequest, ScheduledEvaluationRun>
      getScheduledEvaluationRunMethodDescriptor =
          MethodDescriptor.<GetScheduledEvaluationRunRequest, ScheduledEvaluationRun>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.ces.v1beta.EvaluationService/GetScheduledEvaluationRun")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetScheduledEvaluationRunRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ScheduledEvaluationRun.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListScheduledEvaluationRunsRequest, ListScheduledEvaluationRunsResponse>
      listScheduledEvaluationRunsMethodDescriptor =
          MethodDescriptor
              .<ListScheduledEvaluationRunsRequest, ListScheduledEvaluationRunsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.ces.v1beta.EvaluationService/ListScheduledEvaluationRuns")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListScheduledEvaluationRunsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListScheduledEvaluationRunsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateScheduledEvaluationRunRequest, ScheduledEvaluationRun>
      updateScheduledEvaluationRunMethodDescriptor =
          MethodDescriptor.<UpdateScheduledEvaluationRunRequest, ScheduledEvaluationRun>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.ces.v1beta.EvaluationService/UpdateScheduledEvaluationRun")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateScheduledEvaluationRunRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ScheduledEvaluationRun.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteScheduledEvaluationRunRequest, Empty>
      deleteScheduledEvaluationRunMethodDescriptor =
          MethodDescriptor.<DeleteScheduledEvaluationRunRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.ces.v1beta.EvaluationService/DeleteScheduledEvaluationRun")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteScheduledEvaluationRunRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<TestPersonaVoiceRequest, TestPersonaVoiceResponse>
      testPersonaVoiceMethodDescriptor =
          MethodDescriptor.<TestPersonaVoiceRequest, TestPersonaVoiceResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.ces.v1beta.EvaluationService/TestPersonaVoice")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TestPersonaVoiceRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TestPersonaVoiceResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
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
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetLocationRequest, Location> getLocationMethodDescriptor =
      MethodDescriptor.<GetLocationRequest, Location>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.location.Locations/GetLocation")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLocationRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Location.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private final UnaryCallable<RunEvaluationRequest, Operation> runEvaluationCallable;
  private final OperationCallable<
          RunEvaluationRequest, RunEvaluationResponse, RunEvaluationOperationMetadata>
      runEvaluationOperationCallable;
  private final UnaryCallable<UploadEvaluationAudioRequest, UploadEvaluationAudioResponse>
      uploadEvaluationAudioCallable;
  private final UnaryCallable<CreateEvaluationRequest, Evaluation> createEvaluationCallable;
  private final UnaryCallable<GenerateEvaluationRequest, Operation> generateEvaluationCallable;
  private final OperationCallable<
          GenerateEvaluationRequest, Evaluation, GenerateEvaluationOperationMetadata>
      generateEvaluationOperationCallable;
  private final UnaryCallable<ImportEvaluationsRequest, Operation> importEvaluationsCallable;
  private final OperationCallable<
          ImportEvaluationsRequest, ImportEvaluationsResponse, ImportEvaluationsOperationMetadata>
      importEvaluationsOperationCallable;
  private final UnaryCallable<CreateEvaluationDatasetRequest, EvaluationDataset>
      createEvaluationDatasetCallable;
  private final UnaryCallable<UpdateEvaluationRequest, Evaluation> updateEvaluationCallable;
  private final UnaryCallable<UpdateEvaluationDatasetRequest, EvaluationDataset>
      updateEvaluationDatasetCallable;
  private final UnaryCallable<DeleteEvaluationRequest, Empty> deleteEvaluationCallable;
  private final UnaryCallable<DeleteEvaluationResultRequest, Empty> deleteEvaluationResultCallable;
  private final UnaryCallable<DeleteEvaluationDatasetRequest, Empty>
      deleteEvaluationDatasetCallable;
  private final UnaryCallable<DeleteEvaluationRunRequest, Operation> deleteEvaluationRunCallable;
  private final OperationCallable<
          DeleteEvaluationRunRequest, Empty, DeleteEvaluationRunOperationMetadata>
      deleteEvaluationRunOperationCallable;
  private final UnaryCallable<GetEvaluationRequest, Evaluation> getEvaluationCallable;
  private final UnaryCallable<GetEvaluationResultRequest, EvaluationResult>
      getEvaluationResultCallable;
  private final UnaryCallable<GetEvaluationDatasetRequest, EvaluationDataset>
      getEvaluationDatasetCallable;
  private final UnaryCallable<GetEvaluationRunRequest, EvaluationRun> getEvaluationRunCallable;
  private final UnaryCallable<ListEvaluationsRequest, ListEvaluationsResponse>
      listEvaluationsCallable;
  private final UnaryCallable<ListEvaluationsRequest, ListEvaluationsPagedResponse>
      listEvaluationsPagedCallable;
  private final UnaryCallable<ListEvaluationResultsRequest, ListEvaluationResultsResponse>
      listEvaluationResultsCallable;
  private final UnaryCallable<ListEvaluationResultsRequest, ListEvaluationResultsPagedResponse>
      listEvaluationResultsPagedCallable;
  private final UnaryCallable<ListEvaluationDatasetsRequest, ListEvaluationDatasetsResponse>
      listEvaluationDatasetsCallable;
  private final UnaryCallable<ListEvaluationDatasetsRequest, ListEvaluationDatasetsPagedResponse>
      listEvaluationDatasetsPagedCallable;
  private final UnaryCallable<ListEvaluationRunsRequest, ListEvaluationRunsResponse>
      listEvaluationRunsCallable;
  private final UnaryCallable<ListEvaluationRunsRequest, ListEvaluationRunsPagedResponse>
      listEvaluationRunsPagedCallable;
  private final UnaryCallable<ListEvaluationExpectationsRequest, ListEvaluationExpectationsResponse>
      listEvaluationExpectationsCallable;
  private final UnaryCallable<
          ListEvaluationExpectationsRequest, ListEvaluationExpectationsPagedResponse>
      listEvaluationExpectationsPagedCallable;
  private final UnaryCallable<GetEvaluationExpectationRequest, EvaluationExpectation>
      getEvaluationExpectationCallable;
  private final UnaryCallable<CreateEvaluationExpectationRequest, EvaluationExpectation>
      createEvaluationExpectationCallable;
  private final UnaryCallable<UpdateEvaluationExpectationRequest, EvaluationExpectation>
      updateEvaluationExpectationCallable;
  private final UnaryCallable<DeleteEvaluationExpectationRequest, Empty>
      deleteEvaluationExpectationCallable;
  private final UnaryCallable<CreateScheduledEvaluationRunRequest, ScheduledEvaluationRun>
      createScheduledEvaluationRunCallable;
  private final UnaryCallable<GetScheduledEvaluationRunRequest, ScheduledEvaluationRun>
      getScheduledEvaluationRunCallable;
  private final UnaryCallable<
          ListScheduledEvaluationRunsRequest, ListScheduledEvaluationRunsResponse>
      listScheduledEvaluationRunsCallable;
  private final UnaryCallable<
          ListScheduledEvaluationRunsRequest, ListScheduledEvaluationRunsPagedResponse>
      listScheduledEvaluationRunsPagedCallable;
  private final UnaryCallable<UpdateScheduledEvaluationRunRequest, ScheduledEvaluationRun>
      updateScheduledEvaluationRunCallable;
  private final UnaryCallable<DeleteScheduledEvaluationRunRequest, Empty>
      deleteScheduledEvaluationRunCallable;
  private final UnaryCallable<TestPersonaVoiceRequest, TestPersonaVoiceResponse>
      testPersonaVoiceCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcEvaluationServiceStub create(EvaluationServiceStubSettings settings)
      throws IOException {
    return new GrpcEvaluationServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcEvaluationServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcEvaluationServiceStub(
        EvaluationServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcEvaluationServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcEvaluationServiceStub(
        EvaluationServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcEvaluationServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcEvaluationServiceStub(
      EvaluationServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcEvaluationServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcEvaluationServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcEvaluationServiceStub(
      EvaluationServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<RunEvaluationRequest, Operation> runEvaluationTransportSettings =
        GrpcCallSettings.<RunEvaluationRequest, Operation>newBuilder()
            .setMethodDescriptor(runEvaluationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("app", String.valueOf(request.getApp()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UploadEvaluationAudioRequest, UploadEvaluationAudioResponse>
        uploadEvaluationAudioTransportSettings =
            GrpcCallSettings
                .<UploadEvaluationAudioRequest, UploadEvaluationAudioResponse>newBuilder()
                .setMethodDescriptor(uploadEvaluationAudioMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("app", String.valueOf(request.getApp()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateEvaluationRequest, Evaluation> createEvaluationTransportSettings =
        GrpcCallSettings.<CreateEvaluationRequest, Evaluation>newBuilder()
            .setMethodDescriptor(createEvaluationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GenerateEvaluationRequest, Operation> generateEvaluationTransportSettings =
        GrpcCallSettings.<GenerateEvaluationRequest, Operation>newBuilder()
            .setMethodDescriptor(generateEvaluationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("conversation", String.valueOf(request.getConversation()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ImportEvaluationsRequest, Operation> importEvaluationsTransportSettings =
        GrpcCallSettings.<ImportEvaluationsRequest, Operation>newBuilder()
            .setMethodDescriptor(importEvaluationsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateEvaluationDatasetRequest, EvaluationDataset>
        createEvaluationDatasetTransportSettings =
            GrpcCallSettings.<CreateEvaluationDatasetRequest, EvaluationDataset>newBuilder()
                .setMethodDescriptor(createEvaluationDatasetMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateEvaluationRequest, Evaluation> updateEvaluationTransportSettings =
        GrpcCallSettings.<UpdateEvaluationRequest, Evaluation>newBuilder()
            .setMethodDescriptor(updateEvaluationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("evaluation.name", String.valueOf(request.getEvaluation().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateEvaluationDatasetRequest, EvaluationDataset>
        updateEvaluationDatasetTransportSettings =
            GrpcCallSettings.<UpdateEvaluationDatasetRequest, EvaluationDataset>newBuilder()
                .setMethodDescriptor(updateEvaluationDatasetMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "evaluation_dataset.name",
                          String.valueOf(request.getEvaluationDataset().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteEvaluationRequest, Empty> deleteEvaluationTransportSettings =
        GrpcCallSettings.<DeleteEvaluationRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteEvaluationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteEvaluationResultRequest, Empty> deleteEvaluationResultTransportSettings =
        GrpcCallSettings.<DeleteEvaluationResultRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteEvaluationResultMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteEvaluationDatasetRequest, Empty>
        deleteEvaluationDatasetTransportSettings =
            GrpcCallSettings.<DeleteEvaluationDatasetRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteEvaluationDatasetMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteEvaluationRunRequest, Operation> deleteEvaluationRunTransportSettings =
        GrpcCallSettings.<DeleteEvaluationRunRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteEvaluationRunMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetEvaluationRequest, Evaluation> getEvaluationTransportSettings =
        GrpcCallSettings.<GetEvaluationRequest, Evaluation>newBuilder()
            .setMethodDescriptor(getEvaluationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetEvaluationResultRequest, EvaluationResult>
        getEvaluationResultTransportSettings =
            GrpcCallSettings.<GetEvaluationResultRequest, EvaluationResult>newBuilder()
                .setMethodDescriptor(getEvaluationResultMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetEvaluationDatasetRequest, EvaluationDataset>
        getEvaluationDatasetTransportSettings =
            GrpcCallSettings.<GetEvaluationDatasetRequest, EvaluationDataset>newBuilder()
                .setMethodDescriptor(getEvaluationDatasetMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetEvaluationRunRequest, EvaluationRun> getEvaluationRunTransportSettings =
        GrpcCallSettings.<GetEvaluationRunRequest, EvaluationRun>newBuilder()
            .setMethodDescriptor(getEvaluationRunMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListEvaluationsRequest, ListEvaluationsResponse>
        listEvaluationsTransportSettings =
            GrpcCallSettings.<ListEvaluationsRequest, ListEvaluationsResponse>newBuilder()
                .setMethodDescriptor(listEvaluationsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListEvaluationResultsRequest, ListEvaluationResultsResponse>
        listEvaluationResultsTransportSettings =
            GrpcCallSettings
                .<ListEvaluationResultsRequest, ListEvaluationResultsResponse>newBuilder()
                .setMethodDescriptor(listEvaluationResultsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListEvaluationDatasetsRequest, ListEvaluationDatasetsResponse>
        listEvaluationDatasetsTransportSettings =
            GrpcCallSettings
                .<ListEvaluationDatasetsRequest, ListEvaluationDatasetsResponse>newBuilder()
                .setMethodDescriptor(listEvaluationDatasetsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListEvaluationRunsRequest, ListEvaluationRunsResponse>
        listEvaluationRunsTransportSettings =
            GrpcCallSettings.<ListEvaluationRunsRequest, ListEvaluationRunsResponse>newBuilder()
                .setMethodDescriptor(listEvaluationRunsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListEvaluationExpectationsRequest, ListEvaluationExpectationsResponse>
        listEvaluationExpectationsTransportSettings =
            GrpcCallSettings
                .<ListEvaluationExpectationsRequest, ListEvaluationExpectationsResponse>newBuilder()
                .setMethodDescriptor(listEvaluationExpectationsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetEvaluationExpectationRequest, EvaluationExpectation>
        getEvaluationExpectationTransportSettings =
            GrpcCallSettings.<GetEvaluationExpectationRequest, EvaluationExpectation>newBuilder()
                .setMethodDescriptor(getEvaluationExpectationMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateEvaluationExpectationRequest, EvaluationExpectation>
        createEvaluationExpectationTransportSettings =
            GrpcCallSettings.<CreateEvaluationExpectationRequest, EvaluationExpectation>newBuilder()
                .setMethodDescriptor(createEvaluationExpectationMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateEvaluationExpectationRequest, EvaluationExpectation>
        updateEvaluationExpectationTransportSettings =
            GrpcCallSettings.<UpdateEvaluationExpectationRequest, EvaluationExpectation>newBuilder()
                .setMethodDescriptor(updateEvaluationExpectationMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "evaluation_expectation.name",
                          String.valueOf(request.getEvaluationExpectation().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteEvaluationExpectationRequest, Empty>
        deleteEvaluationExpectationTransportSettings =
            GrpcCallSettings.<DeleteEvaluationExpectationRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteEvaluationExpectationMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateScheduledEvaluationRunRequest, ScheduledEvaluationRun>
        createScheduledEvaluationRunTransportSettings =
            GrpcCallSettings
                .<CreateScheduledEvaluationRunRequest, ScheduledEvaluationRun>newBuilder()
                .setMethodDescriptor(createScheduledEvaluationRunMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetScheduledEvaluationRunRequest, ScheduledEvaluationRun>
        getScheduledEvaluationRunTransportSettings =
            GrpcCallSettings.<GetScheduledEvaluationRunRequest, ScheduledEvaluationRun>newBuilder()
                .setMethodDescriptor(getScheduledEvaluationRunMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListScheduledEvaluationRunsRequest, ListScheduledEvaluationRunsResponse>
        listScheduledEvaluationRunsTransportSettings =
            GrpcCallSettings
                .<ListScheduledEvaluationRunsRequest, ListScheduledEvaluationRunsResponse>
                    newBuilder()
                .setMethodDescriptor(listScheduledEvaluationRunsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateScheduledEvaluationRunRequest, ScheduledEvaluationRun>
        updateScheduledEvaluationRunTransportSettings =
            GrpcCallSettings
                .<UpdateScheduledEvaluationRunRequest, ScheduledEvaluationRun>newBuilder()
                .setMethodDescriptor(updateScheduledEvaluationRunMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "scheduled_evaluation_run.name",
                          String.valueOf(request.getScheduledEvaluationRun().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteScheduledEvaluationRunRequest, Empty>
        deleteScheduledEvaluationRunTransportSettings =
            GrpcCallSettings.<DeleteScheduledEvaluationRunRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteScheduledEvaluationRunMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<TestPersonaVoiceRequest, TestPersonaVoiceResponse>
        testPersonaVoiceTransportSettings =
            GrpcCallSettings.<TestPersonaVoiceRequest, TestPersonaVoiceResponse>newBuilder()
                .setMethodDescriptor(testPersonaVoiceMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("app", String.valueOf(request.getApp()));
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

    this.runEvaluationCallable =
        callableFactory.createUnaryCallable(
            runEvaluationTransportSettings, settings.runEvaluationSettings(), clientContext);
    this.runEvaluationOperationCallable =
        callableFactory.createOperationCallable(
            runEvaluationTransportSettings,
            settings.runEvaluationOperationSettings(),
            clientContext,
            operationsStub);
    this.uploadEvaluationAudioCallable =
        callableFactory.createUnaryCallable(
            uploadEvaluationAudioTransportSettings,
            settings.uploadEvaluationAudioSettings(),
            clientContext);
    this.createEvaluationCallable =
        callableFactory.createUnaryCallable(
            createEvaluationTransportSettings, settings.createEvaluationSettings(), clientContext);
    this.generateEvaluationCallable =
        callableFactory.createUnaryCallable(
            generateEvaluationTransportSettings,
            settings.generateEvaluationSettings(),
            clientContext);
    this.generateEvaluationOperationCallable =
        callableFactory.createOperationCallable(
            generateEvaluationTransportSettings,
            settings.generateEvaluationOperationSettings(),
            clientContext,
            operationsStub);
    this.importEvaluationsCallable =
        callableFactory.createUnaryCallable(
            importEvaluationsTransportSettings,
            settings.importEvaluationsSettings(),
            clientContext);
    this.importEvaluationsOperationCallable =
        callableFactory.createOperationCallable(
            importEvaluationsTransportSettings,
            settings.importEvaluationsOperationSettings(),
            clientContext,
            operationsStub);
    this.createEvaluationDatasetCallable =
        callableFactory.createUnaryCallable(
            createEvaluationDatasetTransportSettings,
            settings.createEvaluationDatasetSettings(),
            clientContext);
    this.updateEvaluationCallable =
        callableFactory.createUnaryCallable(
            updateEvaluationTransportSettings, settings.updateEvaluationSettings(), clientContext);
    this.updateEvaluationDatasetCallable =
        callableFactory.createUnaryCallable(
            updateEvaluationDatasetTransportSettings,
            settings.updateEvaluationDatasetSettings(),
            clientContext);
    this.deleteEvaluationCallable =
        callableFactory.createUnaryCallable(
            deleteEvaluationTransportSettings, settings.deleteEvaluationSettings(), clientContext);
    this.deleteEvaluationResultCallable =
        callableFactory.createUnaryCallable(
            deleteEvaluationResultTransportSettings,
            settings.deleteEvaluationResultSettings(),
            clientContext);
    this.deleteEvaluationDatasetCallable =
        callableFactory.createUnaryCallable(
            deleteEvaluationDatasetTransportSettings,
            settings.deleteEvaluationDatasetSettings(),
            clientContext);
    this.deleteEvaluationRunCallable =
        callableFactory.createUnaryCallable(
            deleteEvaluationRunTransportSettings,
            settings.deleteEvaluationRunSettings(),
            clientContext);
    this.deleteEvaluationRunOperationCallable =
        callableFactory.createOperationCallable(
            deleteEvaluationRunTransportSettings,
            settings.deleteEvaluationRunOperationSettings(),
            clientContext,
            operationsStub);
    this.getEvaluationCallable =
        callableFactory.createUnaryCallable(
            getEvaluationTransportSettings, settings.getEvaluationSettings(), clientContext);
    this.getEvaluationResultCallable =
        callableFactory.createUnaryCallable(
            getEvaluationResultTransportSettings,
            settings.getEvaluationResultSettings(),
            clientContext);
    this.getEvaluationDatasetCallable =
        callableFactory.createUnaryCallable(
            getEvaluationDatasetTransportSettings,
            settings.getEvaluationDatasetSettings(),
            clientContext);
    this.getEvaluationRunCallable =
        callableFactory.createUnaryCallable(
            getEvaluationRunTransportSettings, settings.getEvaluationRunSettings(), clientContext);
    this.listEvaluationsCallable =
        callableFactory.createUnaryCallable(
            listEvaluationsTransportSettings, settings.listEvaluationsSettings(), clientContext);
    this.listEvaluationsPagedCallable =
        callableFactory.createPagedCallable(
            listEvaluationsTransportSettings, settings.listEvaluationsSettings(), clientContext);
    this.listEvaluationResultsCallable =
        callableFactory.createUnaryCallable(
            listEvaluationResultsTransportSettings,
            settings.listEvaluationResultsSettings(),
            clientContext);
    this.listEvaluationResultsPagedCallable =
        callableFactory.createPagedCallable(
            listEvaluationResultsTransportSettings,
            settings.listEvaluationResultsSettings(),
            clientContext);
    this.listEvaluationDatasetsCallable =
        callableFactory.createUnaryCallable(
            listEvaluationDatasetsTransportSettings,
            settings.listEvaluationDatasetsSettings(),
            clientContext);
    this.listEvaluationDatasetsPagedCallable =
        callableFactory.createPagedCallable(
            listEvaluationDatasetsTransportSettings,
            settings.listEvaluationDatasetsSettings(),
            clientContext);
    this.listEvaluationRunsCallable =
        callableFactory.createUnaryCallable(
            listEvaluationRunsTransportSettings,
            settings.listEvaluationRunsSettings(),
            clientContext);
    this.listEvaluationRunsPagedCallable =
        callableFactory.createPagedCallable(
            listEvaluationRunsTransportSettings,
            settings.listEvaluationRunsSettings(),
            clientContext);
    this.listEvaluationExpectationsCallable =
        callableFactory.createUnaryCallable(
            listEvaluationExpectationsTransportSettings,
            settings.listEvaluationExpectationsSettings(),
            clientContext);
    this.listEvaluationExpectationsPagedCallable =
        callableFactory.createPagedCallable(
            listEvaluationExpectationsTransportSettings,
            settings.listEvaluationExpectationsSettings(),
            clientContext);
    this.getEvaluationExpectationCallable =
        callableFactory.createUnaryCallable(
            getEvaluationExpectationTransportSettings,
            settings.getEvaluationExpectationSettings(),
            clientContext);
    this.createEvaluationExpectationCallable =
        callableFactory.createUnaryCallable(
            createEvaluationExpectationTransportSettings,
            settings.createEvaluationExpectationSettings(),
            clientContext);
    this.updateEvaluationExpectationCallable =
        callableFactory.createUnaryCallable(
            updateEvaluationExpectationTransportSettings,
            settings.updateEvaluationExpectationSettings(),
            clientContext);
    this.deleteEvaluationExpectationCallable =
        callableFactory.createUnaryCallable(
            deleteEvaluationExpectationTransportSettings,
            settings.deleteEvaluationExpectationSettings(),
            clientContext);
    this.createScheduledEvaluationRunCallable =
        callableFactory.createUnaryCallable(
            createScheduledEvaluationRunTransportSettings,
            settings.createScheduledEvaluationRunSettings(),
            clientContext);
    this.getScheduledEvaluationRunCallable =
        callableFactory.createUnaryCallable(
            getScheduledEvaluationRunTransportSettings,
            settings.getScheduledEvaluationRunSettings(),
            clientContext);
    this.listScheduledEvaluationRunsCallable =
        callableFactory.createUnaryCallable(
            listScheduledEvaluationRunsTransportSettings,
            settings.listScheduledEvaluationRunsSettings(),
            clientContext);
    this.listScheduledEvaluationRunsPagedCallable =
        callableFactory.createPagedCallable(
            listScheduledEvaluationRunsTransportSettings,
            settings.listScheduledEvaluationRunsSettings(),
            clientContext);
    this.updateScheduledEvaluationRunCallable =
        callableFactory.createUnaryCallable(
            updateScheduledEvaluationRunTransportSettings,
            settings.updateScheduledEvaluationRunSettings(),
            clientContext);
    this.deleteScheduledEvaluationRunCallable =
        callableFactory.createUnaryCallable(
            deleteScheduledEvaluationRunTransportSettings,
            settings.deleteScheduledEvaluationRunSettings(),
            clientContext);
    this.testPersonaVoiceCallable =
        callableFactory.createUnaryCallable(
            testPersonaVoiceTransportSettings, settings.testPersonaVoiceSettings(), clientContext);
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
  public UnaryCallable<RunEvaluationRequest, Operation> runEvaluationCallable() {
    return runEvaluationCallable;
  }

  @Override
  public OperationCallable<
          RunEvaluationRequest, RunEvaluationResponse, RunEvaluationOperationMetadata>
      runEvaluationOperationCallable() {
    return runEvaluationOperationCallable;
  }

  @Override
  public UnaryCallable<UploadEvaluationAudioRequest, UploadEvaluationAudioResponse>
      uploadEvaluationAudioCallable() {
    return uploadEvaluationAudioCallable;
  }

  @Override
  public UnaryCallable<CreateEvaluationRequest, Evaluation> createEvaluationCallable() {
    return createEvaluationCallable;
  }

  @Override
  public UnaryCallable<GenerateEvaluationRequest, Operation> generateEvaluationCallable() {
    return generateEvaluationCallable;
  }

  @Override
  public OperationCallable<
          GenerateEvaluationRequest, Evaluation, GenerateEvaluationOperationMetadata>
      generateEvaluationOperationCallable() {
    return generateEvaluationOperationCallable;
  }

  @Override
  public UnaryCallable<ImportEvaluationsRequest, Operation> importEvaluationsCallable() {
    return importEvaluationsCallable;
  }

  @Override
  public OperationCallable<
          ImportEvaluationsRequest, ImportEvaluationsResponse, ImportEvaluationsOperationMetadata>
      importEvaluationsOperationCallable() {
    return importEvaluationsOperationCallable;
  }

  @Override
  public UnaryCallable<CreateEvaluationDatasetRequest, EvaluationDataset>
      createEvaluationDatasetCallable() {
    return createEvaluationDatasetCallable;
  }

  @Override
  public UnaryCallable<UpdateEvaluationRequest, Evaluation> updateEvaluationCallable() {
    return updateEvaluationCallable;
  }

  @Override
  public UnaryCallable<UpdateEvaluationDatasetRequest, EvaluationDataset>
      updateEvaluationDatasetCallable() {
    return updateEvaluationDatasetCallable;
  }

  @Override
  public UnaryCallable<DeleteEvaluationRequest, Empty> deleteEvaluationCallable() {
    return deleteEvaluationCallable;
  }

  @Override
  public UnaryCallable<DeleteEvaluationResultRequest, Empty> deleteEvaluationResultCallable() {
    return deleteEvaluationResultCallable;
  }

  @Override
  public UnaryCallable<DeleteEvaluationDatasetRequest, Empty> deleteEvaluationDatasetCallable() {
    return deleteEvaluationDatasetCallable;
  }

  @Override
  public UnaryCallable<DeleteEvaluationRunRequest, Operation> deleteEvaluationRunCallable() {
    return deleteEvaluationRunCallable;
  }

  @Override
  public OperationCallable<DeleteEvaluationRunRequest, Empty, DeleteEvaluationRunOperationMetadata>
      deleteEvaluationRunOperationCallable() {
    return deleteEvaluationRunOperationCallable;
  }

  @Override
  public UnaryCallable<GetEvaluationRequest, Evaluation> getEvaluationCallable() {
    return getEvaluationCallable;
  }

  @Override
  public UnaryCallable<GetEvaluationResultRequest, EvaluationResult> getEvaluationResultCallable() {
    return getEvaluationResultCallable;
  }

  @Override
  public UnaryCallable<GetEvaluationDatasetRequest, EvaluationDataset>
      getEvaluationDatasetCallable() {
    return getEvaluationDatasetCallable;
  }

  @Override
  public UnaryCallable<GetEvaluationRunRequest, EvaluationRun> getEvaluationRunCallable() {
    return getEvaluationRunCallable;
  }

  @Override
  public UnaryCallable<ListEvaluationsRequest, ListEvaluationsResponse> listEvaluationsCallable() {
    return listEvaluationsCallable;
  }

  @Override
  public UnaryCallable<ListEvaluationsRequest, ListEvaluationsPagedResponse>
      listEvaluationsPagedCallable() {
    return listEvaluationsPagedCallable;
  }

  @Override
  public UnaryCallable<ListEvaluationResultsRequest, ListEvaluationResultsResponse>
      listEvaluationResultsCallable() {
    return listEvaluationResultsCallable;
  }

  @Override
  public UnaryCallable<ListEvaluationResultsRequest, ListEvaluationResultsPagedResponse>
      listEvaluationResultsPagedCallable() {
    return listEvaluationResultsPagedCallable;
  }

  @Override
  public UnaryCallable<ListEvaluationDatasetsRequest, ListEvaluationDatasetsResponse>
      listEvaluationDatasetsCallable() {
    return listEvaluationDatasetsCallable;
  }

  @Override
  public UnaryCallable<ListEvaluationDatasetsRequest, ListEvaluationDatasetsPagedResponse>
      listEvaluationDatasetsPagedCallable() {
    return listEvaluationDatasetsPagedCallable;
  }

  @Override
  public UnaryCallable<ListEvaluationRunsRequest, ListEvaluationRunsResponse>
      listEvaluationRunsCallable() {
    return listEvaluationRunsCallable;
  }

  @Override
  public UnaryCallable<ListEvaluationRunsRequest, ListEvaluationRunsPagedResponse>
      listEvaluationRunsPagedCallable() {
    return listEvaluationRunsPagedCallable;
  }

  @Override
  public UnaryCallable<ListEvaluationExpectationsRequest, ListEvaluationExpectationsResponse>
      listEvaluationExpectationsCallable() {
    return listEvaluationExpectationsCallable;
  }

  @Override
  public UnaryCallable<ListEvaluationExpectationsRequest, ListEvaluationExpectationsPagedResponse>
      listEvaluationExpectationsPagedCallable() {
    return listEvaluationExpectationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetEvaluationExpectationRequest, EvaluationExpectation>
      getEvaluationExpectationCallable() {
    return getEvaluationExpectationCallable;
  }

  @Override
  public UnaryCallable<CreateEvaluationExpectationRequest, EvaluationExpectation>
      createEvaluationExpectationCallable() {
    return createEvaluationExpectationCallable;
  }

  @Override
  public UnaryCallable<UpdateEvaluationExpectationRequest, EvaluationExpectation>
      updateEvaluationExpectationCallable() {
    return updateEvaluationExpectationCallable;
  }

  @Override
  public UnaryCallable<DeleteEvaluationExpectationRequest, Empty>
      deleteEvaluationExpectationCallable() {
    return deleteEvaluationExpectationCallable;
  }

  @Override
  public UnaryCallable<CreateScheduledEvaluationRunRequest, ScheduledEvaluationRun>
      createScheduledEvaluationRunCallable() {
    return createScheduledEvaluationRunCallable;
  }

  @Override
  public UnaryCallable<GetScheduledEvaluationRunRequest, ScheduledEvaluationRun>
      getScheduledEvaluationRunCallable() {
    return getScheduledEvaluationRunCallable;
  }

  @Override
  public UnaryCallable<ListScheduledEvaluationRunsRequest, ListScheduledEvaluationRunsResponse>
      listScheduledEvaluationRunsCallable() {
    return listScheduledEvaluationRunsCallable;
  }

  @Override
  public UnaryCallable<ListScheduledEvaluationRunsRequest, ListScheduledEvaluationRunsPagedResponse>
      listScheduledEvaluationRunsPagedCallable() {
    return listScheduledEvaluationRunsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateScheduledEvaluationRunRequest, ScheduledEvaluationRun>
      updateScheduledEvaluationRunCallable() {
    return updateScheduledEvaluationRunCallable;
  }

  @Override
  public UnaryCallable<DeleteScheduledEvaluationRunRequest, Empty>
      deleteScheduledEvaluationRunCallable() {
    return deleteScheduledEvaluationRunCallable;
  }

  @Override
  public UnaryCallable<TestPersonaVoiceRequest, TestPersonaVoiceResponse>
      testPersonaVoiceCallable() {
    return testPersonaVoiceCallable;
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
