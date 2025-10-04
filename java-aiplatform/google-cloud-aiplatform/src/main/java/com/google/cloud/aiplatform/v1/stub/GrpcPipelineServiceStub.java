/*
 * Copyright 2025 Google LLC
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

import static com.google.cloud.aiplatform.v1.PipelineServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1.PipelineServiceClient.ListPipelineJobsPagedResponse;
import static com.google.cloud.aiplatform.v1.PipelineServiceClient.ListTrainingPipelinesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1.BatchCancelPipelineJobsOperationMetadata;
import com.google.cloud.aiplatform.v1.BatchCancelPipelineJobsRequest;
import com.google.cloud.aiplatform.v1.BatchCancelPipelineJobsResponse;
import com.google.cloud.aiplatform.v1.BatchDeletePipelineJobsRequest;
import com.google.cloud.aiplatform.v1.BatchDeletePipelineJobsResponse;
import com.google.cloud.aiplatform.v1.CancelPipelineJobRequest;
import com.google.cloud.aiplatform.v1.CancelTrainingPipelineRequest;
import com.google.cloud.aiplatform.v1.CreatePipelineJobRequest;
import com.google.cloud.aiplatform.v1.CreateTrainingPipelineRequest;
import com.google.cloud.aiplatform.v1.DeleteOperationMetadata;
import com.google.cloud.aiplatform.v1.DeletePipelineJobRequest;
import com.google.cloud.aiplatform.v1.DeleteTrainingPipelineRequest;
import com.google.cloud.aiplatform.v1.GetPipelineJobRequest;
import com.google.cloud.aiplatform.v1.GetTrainingPipelineRequest;
import com.google.cloud.aiplatform.v1.ListPipelineJobsRequest;
import com.google.cloud.aiplatform.v1.ListPipelineJobsResponse;
import com.google.cloud.aiplatform.v1.ListTrainingPipelinesRequest;
import com.google.cloud.aiplatform.v1.ListTrainingPipelinesResponse;
import com.google.cloud.aiplatform.v1.PipelineJob;
import com.google.cloud.aiplatform.v1.TrainingPipeline;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
 * gRPC stub implementation for the PipelineService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcPipelineServiceStub extends PipelineServiceStub {
  private static final MethodDescriptor<CreateTrainingPipelineRequest, TrainingPipeline>
      createTrainingPipelineMethodDescriptor =
          MethodDescriptor.<CreateTrainingPipelineRequest, TrainingPipeline>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.PipelineService/CreateTrainingPipeline")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateTrainingPipelineRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(TrainingPipeline.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetTrainingPipelineRequest, TrainingPipeline>
      getTrainingPipelineMethodDescriptor =
          MethodDescriptor.<GetTrainingPipelineRequest, TrainingPipeline>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1.PipelineService/GetTrainingPipeline")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetTrainingPipelineRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(TrainingPipeline.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListTrainingPipelinesRequest, ListTrainingPipelinesResponse>
      listTrainingPipelinesMethodDescriptor =
          MethodDescriptor.<ListTrainingPipelinesRequest, ListTrainingPipelinesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1.PipelineService/ListTrainingPipelines")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListTrainingPipelinesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListTrainingPipelinesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteTrainingPipelineRequest, Operation>
      deleteTrainingPipelineMethodDescriptor =
          MethodDescriptor.<DeleteTrainingPipelineRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.PipelineService/DeleteTrainingPipeline")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteTrainingPipelineRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CancelTrainingPipelineRequest, Empty>
      cancelTrainingPipelineMethodDescriptor =
          MethodDescriptor.<CancelTrainingPipelineRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.PipelineService/CancelTrainingPipeline")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CancelTrainingPipelineRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreatePipelineJobRequest, PipelineJob>
      createPipelineJobMethodDescriptor =
          MethodDescriptor.<CreatePipelineJobRequest, PipelineJob>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1.PipelineService/CreatePipelineJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreatePipelineJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(PipelineJob.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetPipelineJobRequest, PipelineJob>
      getPipelineJobMethodDescriptor =
          MethodDescriptor.<GetPipelineJobRequest, PipelineJob>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1.PipelineService/GetPipelineJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetPipelineJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(PipelineJob.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListPipelineJobsRequest, ListPipelineJobsResponse>
      listPipelineJobsMethodDescriptor =
          MethodDescriptor.<ListPipelineJobsRequest, ListPipelineJobsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1.PipelineService/ListPipelineJobs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListPipelineJobsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListPipelineJobsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeletePipelineJobRequest, Operation>
      deletePipelineJobMethodDescriptor =
          MethodDescriptor.<DeletePipelineJobRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1.PipelineService/DeletePipelineJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeletePipelineJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<BatchDeletePipelineJobsRequest, Operation>
      batchDeletePipelineJobsMethodDescriptor =
          MethodDescriptor.<BatchDeletePipelineJobsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.PipelineService/BatchDeletePipelineJobs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchDeletePipelineJobsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CancelPipelineJobRequest, Empty>
      cancelPipelineJobMethodDescriptor =
          MethodDescriptor.<CancelPipelineJobRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.aiplatform.v1.PipelineService/CancelPipelineJob")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CancelPipelineJobRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<BatchCancelPipelineJobsRequest, Operation>
      batchCancelPipelineJobsMethodDescriptor =
          MethodDescriptor.<BatchCancelPipelineJobsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.aiplatform.v1.PipelineService/BatchCancelPipelineJobs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchCancelPipelineJobsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
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

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .setSampledToLocalTracing(true)
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
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<CreateTrainingPipelineRequest, TrainingPipeline>
      createTrainingPipelineCallable;
  private final UnaryCallable<GetTrainingPipelineRequest, TrainingPipeline>
      getTrainingPipelineCallable;
  private final UnaryCallable<ListTrainingPipelinesRequest, ListTrainingPipelinesResponse>
      listTrainingPipelinesCallable;
  private final UnaryCallable<ListTrainingPipelinesRequest, ListTrainingPipelinesPagedResponse>
      listTrainingPipelinesPagedCallable;
  private final UnaryCallable<DeleteTrainingPipelineRequest, Operation>
      deleteTrainingPipelineCallable;
  private final OperationCallable<DeleteTrainingPipelineRequest, Empty, DeleteOperationMetadata>
      deleteTrainingPipelineOperationCallable;
  private final UnaryCallable<CancelTrainingPipelineRequest, Empty> cancelTrainingPipelineCallable;
  private final UnaryCallable<CreatePipelineJobRequest, PipelineJob> createPipelineJobCallable;
  private final UnaryCallable<GetPipelineJobRequest, PipelineJob> getPipelineJobCallable;
  private final UnaryCallable<ListPipelineJobsRequest, ListPipelineJobsResponse>
      listPipelineJobsCallable;
  private final UnaryCallable<ListPipelineJobsRequest, ListPipelineJobsPagedResponse>
      listPipelineJobsPagedCallable;
  private final UnaryCallable<DeletePipelineJobRequest, Operation> deletePipelineJobCallable;
  private final OperationCallable<DeletePipelineJobRequest, Empty, DeleteOperationMetadata>
      deletePipelineJobOperationCallable;
  private final UnaryCallable<BatchDeletePipelineJobsRequest, Operation>
      batchDeletePipelineJobsCallable;
  private final OperationCallable<
          BatchDeletePipelineJobsRequest, BatchDeletePipelineJobsResponse, DeleteOperationMetadata>
      batchDeletePipelineJobsOperationCallable;
  private final UnaryCallable<CancelPipelineJobRequest, Empty> cancelPipelineJobCallable;
  private final UnaryCallable<BatchCancelPipelineJobsRequest, Operation>
      batchCancelPipelineJobsCallable;
  private final OperationCallable<
          BatchCancelPipelineJobsRequest,
          BatchCancelPipelineJobsResponse,
          BatchCancelPipelineJobsOperationMetadata>
      batchCancelPipelineJobsOperationCallable;
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

  public static final GrpcPipelineServiceStub create(PipelineServiceStubSettings settings)
      throws IOException {
    return new GrpcPipelineServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcPipelineServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcPipelineServiceStub(
        PipelineServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcPipelineServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcPipelineServiceStub(
        PipelineServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcPipelineServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcPipelineServiceStub(
      PipelineServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcPipelineServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcPipelineServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcPipelineServiceStub(
      PipelineServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateTrainingPipelineRequest, TrainingPipeline>
        createTrainingPipelineTransportSettings =
            GrpcCallSettings.<CreateTrainingPipelineRequest, TrainingPipeline>newBuilder()
                .setMethodDescriptor(createTrainingPipelineMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetTrainingPipelineRequest, TrainingPipeline>
        getTrainingPipelineTransportSettings =
            GrpcCallSettings.<GetTrainingPipelineRequest, TrainingPipeline>newBuilder()
                .setMethodDescriptor(getTrainingPipelineMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListTrainingPipelinesRequest, ListTrainingPipelinesResponse>
        listTrainingPipelinesTransportSettings =
            GrpcCallSettings
                .<ListTrainingPipelinesRequest, ListTrainingPipelinesResponse>newBuilder()
                .setMethodDescriptor(listTrainingPipelinesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteTrainingPipelineRequest, Operation>
        deleteTrainingPipelineTransportSettings =
            GrpcCallSettings.<DeleteTrainingPipelineRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteTrainingPipelineMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CancelTrainingPipelineRequest, Empty> cancelTrainingPipelineTransportSettings =
        GrpcCallSettings.<CancelTrainingPipelineRequest, Empty>newBuilder()
            .setMethodDescriptor(cancelTrainingPipelineMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreatePipelineJobRequest, PipelineJob> createPipelineJobTransportSettings =
        GrpcCallSettings.<CreatePipelineJobRequest, PipelineJob>newBuilder()
            .setMethodDescriptor(createPipelineJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetPipelineJobRequest, PipelineJob> getPipelineJobTransportSettings =
        GrpcCallSettings.<GetPipelineJobRequest, PipelineJob>newBuilder()
            .setMethodDescriptor(getPipelineJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListPipelineJobsRequest, ListPipelineJobsResponse>
        listPipelineJobsTransportSettings =
            GrpcCallSettings.<ListPipelineJobsRequest, ListPipelineJobsResponse>newBuilder()
                .setMethodDescriptor(listPipelineJobsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeletePipelineJobRequest, Operation> deletePipelineJobTransportSettings =
        GrpcCallSettings.<DeletePipelineJobRequest, Operation>newBuilder()
            .setMethodDescriptor(deletePipelineJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<BatchDeletePipelineJobsRequest, Operation>
        batchDeletePipelineJobsTransportSettings =
            GrpcCallSettings.<BatchDeletePipelineJobsRequest, Operation>newBuilder()
                .setMethodDescriptor(batchDeletePipelineJobsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CancelPipelineJobRequest, Empty> cancelPipelineJobTransportSettings =
        GrpcCallSettings.<CancelPipelineJobRequest, Empty>newBuilder()
            .setMethodDescriptor(cancelPipelineJobMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<BatchCancelPipelineJobsRequest, Operation>
        batchCancelPipelineJobsTransportSettings =
            GrpcCallSettings.<BatchCancelPipelineJobsRequest, Operation>newBuilder()
                .setMethodDescriptor(batchCancelPipelineJobsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
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

    this.createTrainingPipelineCallable =
        callableFactory.createUnaryCallable(
            createTrainingPipelineTransportSettings,
            settings.createTrainingPipelineSettings(),
            clientContext);
    this.getTrainingPipelineCallable =
        callableFactory.createUnaryCallable(
            getTrainingPipelineTransportSettings,
            settings.getTrainingPipelineSettings(),
            clientContext);
    this.listTrainingPipelinesCallable =
        callableFactory.createUnaryCallable(
            listTrainingPipelinesTransportSettings,
            settings.listTrainingPipelinesSettings(),
            clientContext);
    this.listTrainingPipelinesPagedCallable =
        callableFactory.createPagedCallable(
            listTrainingPipelinesTransportSettings,
            settings.listTrainingPipelinesSettings(),
            clientContext);
    this.deleteTrainingPipelineCallable =
        callableFactory.createUnaryCallable(
            deleteTrainingPipelineTransportSettings,
            settings.deleteTrainingPipelineSettings(),
            clientContext);
    this.deleteTrainingPipelineOperationCallable =
        callableFactory.createOperationCallable(
            deleteTrainingPipelineTransportSettings,
            settings.deleteTrainingPipelineOperationSettings(),
            clientContext,
            operationsStub);
    this.cancelTrainingPipelineCallable =
        callableFactory.createUnaryCallable(
            cancelTrainingPipelineTransportSettings,
            settings.cancelTrainingPipelineSettings(),
            clientContext);
    this.createPipelineJobCallable =
        callableFactory.createUnaryCallable(
            createPipelineJobTransportSettings,
            settings.createPipelineJobSettings(),
            clientContext);
    this.getPipelineJobCallable =
        callableFactory.createUnaryCallable(
            getPipelineJobTransportSettings, settings.getPipelineJobSettings(), clientContext);
    this.listPipelineJobsCallable =
        callableFactory.createUnaryCallable(
            listPipelineJobsTransportSettings, settings.listPipelineJobsSettings(), clientContext);
    this.listPipelineJobsPagedCallable =
        callableFactory.createPagedCallable(
            listPipelineJobsTransportSettings, settings.listPipelineJobsSettings(), clientContext);
    this.deletePipelineJobCallable =
        callableFactory.createUnaryCallable(
            deletePipelineJobTransportSettings,
            settings.deletePipelineJobSettings(),
            clientContext);
    this.deletePipelineJobOperationCallable =
        callableFactory.createOperationCallable(
            deletePipelineJobTransportSettings,
            settings.deletePipelineJobOperationSettings(),
            clientContext,
            operationsStub);
    this.batchDeletePipelineJobsCallable =
        callableFactory.createUnaryCallable(
            batchDeletePipelineJobsTransportSettings,
            settings.batchDeletePipelineJobsSettings(),
            clientContext);
    this.batchDeletePipelineJobsOperationCallable =
        callableFactory.createOperationCallable(
            batchDeletePipelineJobsTransportSettings,
            settings.batchDeletePipelineJobsOperationSettings(),
            clientContext,
            operationsStub);
    this.cancelPipelineJobCallable =
        callableFactory.createUnaryCallable(
            cancelPipelineJobTransportSettings,
            settings.cancelPipelineJobSettings(),
            clientContext);
    this.batchCancelPipelineJobsCallable =
        callableFactory.createUnaryCallable(
            batchCancelPipelineJobsTransportSettings,
            settings.batchCancelPipelineJobsSettings(),
            clientContext);
    this.batchCancelPipelineJobsOperationCallable =
        callableFactory.createOperationCallable(
            batchCancelPipelineJobsTransportSettings,
            settings.batchCancelPipelineJobsOperationSettings(),
            clientContext,
            operationsStub);
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
  public UnaryCallable<CreateTrainingPipelineRequest, TrainingPipeline>
      createTrainingPipelineCallable() {
    return createTrainingPipelineCallable;
  }

  @Override
  public UnaryCallable<GetTrainingPipelineRequest, TrainingPipeline> getTrainingPipelineCallable() {
    return getTrainingPipelineCallable;
  }

  @Override
  public UnaryCallable<ListTrainingPipelinesRequest, ListTrainingPipelinesResponse>
      listTrainingPipelinesCallable() {
    return listTrainingPipelinesCallable;
  }

  @Override
  public UnaryCallable<ListTrainingPipelinesRequest, ListTrainingPipelinesPagedResponse>
      listTrainingPipelinesPagedCallable() {
    return listTrainingPipelinesPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteTrainingPipelineRequest, Operation> deleteTrainingPipelineCallable() {
    return deleteTrainingPipelineCallable;
  }

  @Override
  public OperationCallable<DeleteTrainingPipelineRequest, Empty, DeleteOperationMetadata>
      deleteTrainingPipelineOperationCallable() {
    return deleteTrainingPipelineOperationCallable;
  }

  @Override
  public UnaryCallable<CancelTrainingPipelineRequest, Empty> cancelTrainingPipelineCallable() {
    return cancelTrainingPipelineCallable;
  }

  @Override
  public UnaryCallable<CreatePipelineJobRequest, PipelineJob> createPipelineJobCallable() {
    return createPipelineJobCallable;
  }

  @Override
  public UnaryCallable<GetPipelineJobRequest, PipelineJob> getPipelineJobCallable() {
    return getPipelineJobCallable;
  }

  @Override
  public UnaryCallable<ListPipelineJobsRequest, ListPipelineJobsResponse>
      listPipelineJobsCallable() {
    return listPipelineJobsCallable;
  }

  @Override
  public UnaryCallable<ListPipelineJobsRequest, ListPipelineJobsPagedResponse>
      listPipelineJobsPagedCallable() {
    return listPipelineJobsPagedCallable;
  }

  @Override
  public UnaryCallable<DeletePipelineJobRequest, Operation> deletePipelineJobCallable() {
    return deletePipelineJobCallable;
  }

  @Override
  public OperationCallable<DeletePipelineJobRequest, Empty, DeleteOperationMetadata>
      deletePipelineJobOperationCallable() {
    return deletePipelineJobOperationCallable;
  }

  @Override
  public UnaryCallable<BatchDeletePipelineJobsRequest, Operation>
      batchDeletePipelineJobsCallable() {
    return batchDeletePipelineJobsCallable;
  }

  @Override
  public OperationCallable<
          BatchDeletePipelineJobsRequest, BatchDeletePipelineJobsResponse, DeleteOperationMetadata>
      batchDeletePipelineJobsOperationCallable() {
    return batchDeletePipelineJobsOperationCallable;
  }

  @Override
  public UnaryCallable<CancelPipelineJobRequest, Empty> cancelPipelineJobCallable() {
    return cancelPipelineJobCallable;
  }

  @Override
  public UnaryCallable<BatchCancelPipelineJobsRequest, Operation>
      batchCancelPipelineJobsCallable() {
    return batchCancelPipelineJobsCallable;
  }

  @Override
  public OperationCallable<
          BatchCancelPipelineJobsRequest,
          BatchCancelPipelineJobsResponse,
          BatchCancelPipelineJobsOperationMetadata>
      batchCancelPipelineJobsOperationCallable() {
    return batchCancelPipelineJobsOperationCallable;
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
