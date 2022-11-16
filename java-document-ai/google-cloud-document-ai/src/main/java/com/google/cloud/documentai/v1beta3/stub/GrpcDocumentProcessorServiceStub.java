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

package com.google.cloud.documentai.v1beta3.stub;

import static com.google.cloud.documentai.v1beta3.DocumentProcessorServiceClient.ListEvaluationsPagedResponse;
import static com.google.cloud.documentai.v1beta3.DocumentProcessorServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.documentai.v1beta3.DocumentProcessorServiceClient.ListProcessorTypesPagedResponse;
import static com.google.cloud.documentai.v1beta3.DocumentProcessorServiceClient.ListProcessorVersionsPagedResponse;
import static com.google.cloud.documentai.v1beta3.DocumentProcessorServiceClient.ListProcessorsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.documentai.v1beta3.BatchProcessMetadata;
import com.google.cloud.documentai.v1beta3.BatchProcessRequest;
import com.google.cloud.documentai.v1beta3.BatchProcessResponse;
import com.google.cloud.documentai.v1beta3.CreateProcessorRequest;
import com.google.cloud.documentai.v1beta3.DeleteProcessorMetadata;
import com.google.cloud.documentai.v1beta3.DeleteProcessorRequest;
import com.google.cloud.documentai.v1beta3.DeleteProcessorVersionMetadata;
import com.google.cloud.documentai.v1beta3.DeleteProcessorVersionRequest;
import com.google.cloud.documentai.v1beta3.DeployProcessorVersionMetadata;
import com.google.cloud.documentai.v1beta3.DeployProcessorVersionRequest;
import com.google.cloud.documentai.v1beta3.DeployProcessorVersionResponse;
import com.google.cloud.documentai.v1beta3.DisableProcessorMetadata;
import com.google.cloud.documentai.v1beta3.DisableProcessorRequest;
import com.google.cloud.documentai.v1beta3.DisableProcessorResponse;
import com.google.cloud.documentai.v1beta3.EnableProcessorMetadata;
import com.google.cloud.documentai.v1beta3.EnableProcessorRequest;
import com.google.cloud.documentai.v1beta3.EnableProcessorResponse;
import com.google.cloud.documentai.v1beta3.EvaluateProcessorVersionMetadata;
import com.google.cloud.documentai.v1beta3.EvaluateProcessorVersionRequest;
import com.google.cloud.documentai.v1beta3.EvaluateProcessorVersionResponse;
import com.google.cloud.documentai.v1beta3.Evaluation;
import com.google.cloud.documentai.v1beta3.FetchProcessorTypesRequest;
import com.google.cloud.documentai.v1beta3.FetchProcessorTypesResponse;
import com.google.cloud.documentai.v1beta3.GetEvaluationRequest;
import com.google.cloud.documentai.v1beta3.GetProcessorRequest;
import com.google.cloud.documentai.v1beta3.GetProcessorVersionRequest;
import com.google.cloud.documentai.v1beta3.ListEvaluationsRequest;
import com.google.cloud.documentai.v1beta3.ListEvaluationsResponse;
import com.google.cloud.documentai.v1beta3.ListProcessorTypesRequest;
import com.google.cloud.documentai.v1beta3.ListProcessorTypesResponse;
import com.google.cloud.documentai.v1beta3.ListProcessorVersionsRequest;
import com.google.cloud.documentai.v1beta3.ListProcessorVersionsResponse;
import com.google.cloud.documentai.v1beta3.ListProcessorsRequest;
import com.google.cloud.documentai.v1beta3.ListProcessorsResponse;
import com.google.cloud.documentai.v1beta3.ProcessRequest;
import com.google.cloud.documentai.v1beta3.ProcessResponse;
import com.google.cloud.documentai.v1beta3.Processor;
import com.google.cloud.documentai.v1beta3.ProcessorVersion;
import com.google.cloud.documentai.v1beta3.ReviewDocumentOperationMetadata;
import com.google.cloud.documentai.v1beta3.ReviewDocumentRequest;
import com.google.cloud.documentai.v1beta3.ReviewDocumentResponse;
import com.google.cloud.documentai.v1beta3.SetDefaultProcessorVersionMetadata;
import com.google.cloud.documentai.v1beta3.SetDefaultProcessorVersionRequest;
import com.google.cloud.documentai.v1beta3.SetDefaultProcessorVersionResponse;
import com.google.cloud.documentai.v1beta3.TrainProcessorVersionMetadata;
import com.google.cloud.documentai.v1beta3.TrainProcessorVersionRequest;
import com.google.cloud.documentai.v1beta3.TrainProcessorVersionResponse;
import com.google.cloud.documentai.v1beta3.UndeployProcessorVersionMetadata;
import com.google.cloud.documentai.v1beta3.UndeployProcessorVersionRequest;
import com.google.cloud.documentai.v1beta3.UndeployProcessorVersionResponse;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
 * gRPC stub implementation for the DocumentProcessorService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcDocumentProcessorServiceStub extends DocumentProcessorServiceStub {
  private static final MethodDescriptor<ProcessRequest, ProcessResponse>
      processDocumentMethodDescriptor =
          MethodDescriptor.<ProcessRequest, ProcessResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.documentai.v1beta3.DocumentProcessorService/ProcessDocument")
              .setRequestMarshaller(ProtoUtils.marshaller(ProcessRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ProcessResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<BatchProcessRequest, Operation>
      batchProcessDocumentsMethodDescriptor =
          MethodDescriptor.<BatchProcessRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.documentai.v1beta3.DocumentProcessorService/BatchProcessDocuments")
              .setRequestMarshaller(ProtoUtils.marshaller(BatchProcessRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<FetchProcessorTypesRequest, FetchProcessorTypesResponse>
      fetchProcessorTypesMethodDescriptor =
          MethodDescriptor.<FetchProcessorTypesRequest, FetchProcessorTypesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.documentai.v1beta3.DocumentProcessorService/FetchProcessorTypes")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(FetchProcessorTypesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(FetchProcessorTypesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListProcessorTypesRequest, ListProcessorTypesResponse>
      listProcessorTypesMethodDescriptor =
          MethodDescriptor.<ListProcessorTypesRequest, ListProcessorTypesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.documentai.v1beta3.DocumentProcessorService/ListProcessorTypes")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListProcessorTypesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListProcessorTypesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListProcessorsRequest, ListProcessorsResponse>
      listProcessorsMethodDescriptor =
          MethodDescriptor.<ListProcessorsRequest, ListProcessorsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.documentai.v1beta3.DocumentProcessorService/ListProcessors")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListProcessorsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListProcessorsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetProcessorRequest, Processor>
      getProcessorMethodDescriptor =
          MethodDescriptor.<GetProcessorRequest, Processor>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.documentai.v1beta3.DocumentProcessorService/GetProcessor")
              .setRequestMarshaller(ProtoUtils.marshaller(GetProcessorRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Processor.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<TrainProcessorVersionRequest, Operation>
      trainProcessorVersionMethodDescriptor =
          MethodDescriptor.<TrainProcessorVersionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.documentai.v1beta3.DocumentProcessorService/TrainProcessorVersion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TrainProcessorVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetProcessorVersionRequest, ProcessorVersion>
      getProcessorVersionMethodDescriptor =
          MethodDescriptor.<GetProcessorVersionRequest, ProcessorVersion>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.documentai.v1beta3.DocumentProcessorService/GetProcessorVersion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetProcessorVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ProcessorVersion.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListProcessorVersionsRequest, ListProcessorVersionsResponse>
      listProcessorVersionsMethodDescriptor =
          MethodDescriptor.<ListProcessorVersionsRequest, ListProcessorVersionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.documentai.v1beta3.DocumentProcessorService/ListProcessorVersions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListProcessorVersionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListProcessorVersionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteProcessorVersionRequest, Operation>
      deleteProcessorVersionMethodDescriptor =
          MethodDescriptor.<DeleteProcessorVersionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.documentai.v1beta3.DocumentProcessorService/DeleteProcessorVersion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteProcessorVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeployProcessorVersionRequest, Operation>
      deployProcessorVersionMethodDescriptor =
          MethodDescriptor.<DeployProcessorVersionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.documentai.v1beta3.DocumentProcessorService/DeployProcessorVersion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeployProcessorVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UndeployProcessorVersionRequest, Operation>
      undeployProcessorVersionMethodDescriptor =
          MethodDescriptor.<UndeployProcessorVersionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.documentai.v1beta3.DocumentProcessorService/UndeployProcessorVersion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UndeployProcessorVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateProcessorRequest, Processor>
      createProcessorMethodDescriptor =
          MethodDescriptor.<CreateProcessorRequest, Processor>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.documentai.v1beta3.DocumentProcessorService/CreateProcessor")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateProcessorRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Processor.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteProcessorRequest, Operation>
      deleteProcessorMethodDescriptor =
          MethodDescriptor.<DeleteProcessorRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.documentai.v1beta3.DocumentProcessorService/DeleteProcessor")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteProcessorRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<EnableProcessorRequest, Operation>
      enableProcessorMethodDescriptor =
          MethodDescriptor.<EnableProcessorRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.documentai.v1beta3.DocumentProcessorService/EnableProcessor")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(EnableProcessorRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DisableProcessorRequest, Operation>
      disableProcessorMethodDescriptor =
          MethodDescriptor.<DisableProcessorRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.documentai.v1beta3.DocumentProcessorService/DisableProcessor")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DisableProcessorRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SetDefaultProcessorVersionRequest, Operation>
      setDefaultProcessorVersionMethodDescriptor =
          MethodDescriptor.<SetDefaultProcessorVersionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.documentai.v1beta3.DocumentProcessorService/SetDefaultProcessorVersion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SetDefaultProcessorVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ReviewDocumentRequest, Operation>
      reviewDocumentMethodDescriptor =
          MethodDescriptor.<ReviewDocumentRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.documentai.v1beta3.DocumentProcessorService/ReviewDocument")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ReviewDocumentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<EvaluateProcessorVersionRequest, Operation>
      evaluateProcessorVersionMethodDescriptor =
          MethodDescriptor.<EvaluateProcessorVersionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.documentai.v1beta3.DocumentProcessorService/EvaluateProcessorVersion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(EvaluateProcessorVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetEvaluationRequest, Evaluation>
      getEvaluationMethodDescriptor =
          MethodDescriptor.<GetEvaluationRequest, Evaluation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.documentai.v1beta3.DocumentProcessorService/GetEvaluation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetEvaluationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Evaluation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListEvaluationsRequest, ListEvaluationsResponse>
      listEvaluationsMethodDescriptor =
          MethodDescriptor.<ListEvaluationsRequest, ListEvaluationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.documentai.v1beta3.DocumentProcessorService/ListEvaluations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListEvaluationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListEvaluationsResponse.getDefaultInstance()))
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

  private final UnaryCallable<ProcessRequest, ProcessResponse> processDocumentCallable;
  private final UnaryCallable<BatchProcessRequest, Operation> batchProcessDocumentsCallable;
  private final OperationCallable<BatchProcessRequest, BatchProcessResponse, BatchProcessMetadata>
      batchProcessDocumentsOperationCallable;
  private final UnaryCallable<FetchProcessorTypesRequest, FetchProcessorTypesResponse>
      fetchProcessorTypesCallable;
  private final UnaryCallable<ListProcessorTypesRequest, ListProcessorTypesResponse>
      listProcessorTypesCallable;
  private final UnaryCallable<ListProcessorTypesRequest, ListProcessorTypesPagedResponse>
      listProcessorTypesPagedCallable;
  private final UnaryCallable<ListProcessorsRequest, ListProcessorsResponse> listProcessorsCallable;
  private final UnaryCallable<ListProcessorsRequest, ListProcessorsPagedResponse>
      listProcessorsPagedCallable;
  private final UnaryCallable<GetProcessorRequest, Processor> getProcessorCallable;
  private final UnaryCallable<TrainProcessorVersionRequest, Operation>
      trainProcessorVersionCallable;
  private final OperationCallable<
          TrainProcessorVersionRequest,
          TrainProcessorVersionResponse,
          TrainProcessorVersionMetadata>
      trainProcessorVersionOperationCallable;
  private final UnaryCallable<GetProcessorVersionRequest, ProcessorVersion>
      getProcessorVersionCallable;
  private final UnaryCallable<ListProcessorVersionsRequest, ListProcessorVersionsResponse>
      listProcessorVersionsCallable;
  private final UnaryCallable<ListProcessorVersionsRequest, ListProcessorVersionsPagedResponse>
      listProcessorVersionsPagedCallable;
  private final UnaryCallable<DeleteProcessorVersionRequest, Operation>
      deleteProcessorVersionCallable;
  private final OperationCallable<
          DeleteProcessorVersionRequest, Empty, DeleteProcessorVersionMetadata>
      deleteProcessorVersionOperationCallable;
  private final UnaryCallable<DeployProcessorVersionRequest, Operation>
      deployProcessorVersionCallable;
  private final OperationCallable<
          DeployProcessorVersionRequest,
          DeployProcessorVersionResponse,
          DeployProcessorVersionMetadata>
      deployProcessorVersionOperationCallable;
  private final UnaryCallable<UndeployProcessorVersionRequest, Operation>
      undeployProcessorVersionCallable;
  private final OperationCallable<
          UndeployProcessorVersionRequest,
          UndeployProcessorVersionResponse,
          UndeployProcessorVersionMetadata>
      undeployProcessorVersionOperationCallable;
  private final UnaryCallable<CreateProcessorRequest, Processor> createProcessorCallable;
  private final UnaryCallable<DeleteProcessorRequest, Operation> deleteProcessorCallable;
  private final OperationCallable<DeleteProcessorRequest, Empty, DeleteProcessorMetadata>
      deleteProcessorOperationCallable;
  private final UnaryCallable<EnableProcessorRequest, Operation> enableProcessorCallable;
  private final OperationCallable<
          EnableProcessorRequest, EnableProcessorResponse, EnableProcessorMetadata>
      enableProcessorOperationCallable;
  private final UnaryCallable<DisableProcessorRequest, Operation> disableProcessorCallable;
  private final OperationCallable<
          DisableProcessorRequest, DisableProcessorResponse, DisableProcessorMetadata>
      disableProcessorOperationCallable;
  private final UnaryCallable<SetDefaultProcessorVersionRequest, Operation>
      setDefaultProcessorVersionCallable;
  private final OperationCallable<
          SetDefaultProcessorVersionRequest,
          SetDefaultProcessorVersionResponse,
          SetDefaultProcessorVersionMetadata>
      setDefaultProcessorVersionOperationCallable;
  private final UnaryCallable<ReviewDocumentRequest, Operation> reviewDocumentCallable;
  private final OperationCallable<
          ReviewDocumentRequest, ReviewDocumentResponse, ReviewDocumentOperationMetadata>
      reviewDocumentOperationCallable;
  private final UnaryCallable<EvaluateProcessorVersionRequest, Operation>
      evaluateProcessorVersionCallable;
  private final OperationCallable<
          EvaluateProcessorVersionRequest,
          EvaluateProcessorVersionResponse,
          EvaluateProcessorVersionMetadata>
      evaluateProcessorVersionOperationCallable;
  private final UnaryCallable<GetEvaluationRequest, Evaluation> getEvaluationCallable;
  private final UnaryCallable<ListEvaluationsRequest, ListEvaluationsResponse>
      listEvaluationsCallable;
  private final UnaryCallable<ListEvaluationsRequest, ListEvaluationsPagedResponse>
      listEvaluationsPagedCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcDocumentProcessorServiceStub create(
      DocumentProcessorServiceStubSettings settings) throws IOException {
    return new GrpcDocumentProcessorServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcDocumentProcessorServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcDocumentProcessorServiceStub(
        DocumentProcessorServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcDocumentProcessorServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcDocumentProcessorServiceStub(
        DocumentProcessorServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcDocumentProcessorServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcDocumentProcessorServiceStub(
      DocumentProcessorServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcDocumentProcessorServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcDocumentProcessorServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcDocumentProcessorServiceStub(
      DocumentProcessorServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ProcessRequest, ProcessResponse> processDocumentTransportSettings =
        GrpcCallSettings.<ProcessRequest, ProcessResponse>newBuilder()
            .setMethodDescriptor(processDocumentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<BatchProcessRequest, Operation> batchProcessDocumentsTransportSettings =
        GrpcCallSettings.<BatchProcessRequest, Operation>newBuilder()
            .setMethodDescriptor(batchProcessDocumentsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<FetchProcessorTypesRequest, FetchProcessorTypesResponse>
        fetchProcessorTypesTransportSettings =
            GrpcCallSettings.<FetchProcessorTypesRequest, FetchProcessorTypesResponse>newBuilder()
                .setMethodDescriptor(fetchProcessorTypesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListProcessorTypesRequest, ListProcessorTypesResponse>
        listProcessorTypesTransportSettings =
            GrpcCallSettings.<ListProcessorTypesRequest, ListProcessorTypesResponse>newBuilder()
                .setMethodDescriptor(listProcessorTypesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListProcessorsRequest, ListProcessorsResponse>
        listProcessorsTransportSettings =
            GrpcCallSettings.<ListProcessorsRequest, ListProcessorsResponse>newBuilder()
                .setMethodDescriptor(listProcessorsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetProcessorRequest, Processor> getProcessorTransportSettings =
        GrpcCallSettings.<GetProcessorRequest, Processor>newBuilder()
            .setMethodDescriptor(getProcessorMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<TrainProcessorVersionRequest, Operation>
        trainProcessorVersionTransportSettings =
            GrpcCallSettings.<TrainProcessorVersionRequest, Operation>newBuilder()
                .setMethodDescriptor(trainProcessorVersionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetProcessorVersionRequest, ProcessorVersion>
        getProcessorVersionTransportSettings =
            GrpcCallSettings.<GetProcessorVersionRequest, ProcessorVersion>newBuilder()
                .setMethodDescriptor(getProcessorVersionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListProcessorVersionsRequest, ListProcessorVersionsResponse>
        listProcessorVersionsTransportSettings =
            GrpcCallSettings
                .<ListProcessorVersionsRequest, ListProcessorVersionsResponse>newBuilder()
                .setMethodDescriptor(listProcessorVersionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteProcessorVersionRequest, Operation>
        deleteProcessorVersionTransportSettings =
            GrpcCallSettings.<DeleteProcessorVersionRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteProcessorVersionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeployProcessorVersionRequest, Operation>
        deployProcessorVersionTransportSettings =
            GrpcCallSettings.<DeployProcessorVersionRequest, Operation>newBuilder()
                .setMethodDescriptor(deployProcessorVersionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UndeployProcessorVersionRequest, Operation>
        undeployProcessorVersionTransportSettings =
            GrpcCallSettings.<UndeployProcessorVersionRequest, Operation>newBuilder()
                .setMethodDescriptor(undeployProcessorVersionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<CreateProcessorRequest, Processor> createProcessorTransportSettings =
        GrpcCallSettings.<CreateProcessorRequest, Processor>newBuilder()
            .setMethodDescriptor(createProcessorMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteProcessorRequest, Operation> deleteProcessorTransportSettings =
        GrpcCallSettings.<DeleteProcessorRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteProcessorMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<EnableProcessorRequest, Operation> enableProcessorTransportSettings =
        GrpcCallSettings.<EnableProcessorRequest, Operation>newBuilder()
            .setMethodDescriptor(enableProcessorMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DisableProcessorRequest, Operation> disableProcessorTransportSettings =
        GrpcCallSettings.<DisableProcessorRequest, Operation>newBuilder()
            .setMethodDescriptor(disableProcessorMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<SetDefaultProcessorVersionRequest, Operation>
        setDefaultProcessorVersionTransportSettings =
            GrpcCallSettings.<SetDefaultProcessorVersionRequest, Operation>newBuilder()
                .setMethodDescriptor(setDefaultProcessorVersionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("processor", String.valueOf(request.getProcessor()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ReviewDocumentRequest, Operation> reviewDocumentTransportSettings =
        GrpcCallSettings.<ReviewDocumentRequest, Operation>newBuilder()
            .setMethodDescriptor(reviewDocumentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("human_review_config", String.valueOf(request.getHumanReviewConfig()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<EvaluateProcessorVersionRequest, Operation>
        evaluateProcessorVersionTransportSettings =
            GrpcCallSettings.<EvaluateProcessorVersionRequest, Operation>newBuilder()
                .setMethodDescriptor(evaluateProcessorVersionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put(
                          "processor_version", String.valueOf(request.getProcessorVersion()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetEvaluationRequest, Evaluation> getEvaluationTransportSettings =
        GrpcCallSettings.<GetEvaluationRequest, Evaluation>newBuilder()
            .setMethodDescriptor(getEvaluationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListEvaluationsRequest, ListEvaluationsResponse>
        listEvaluationsTransportSettings =
            GrpcCallSettings.<ListEvaluationsRequest, ListEvaluationsResponse>newBuilder()
                .setMethodDescriptor(listEvaluationsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
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

    this.processDocumentCallable =
        callableFactory.createUnaryCallable(
            processDocumentTransportSettings, settings.processDocumentSettings(), clientContext);
    this.batchProcessDocumentsCallable =
        callableFactory.createUnaryCallable(
            batchProcessDocumentsTransportSettings,
            settings.batchProcessDocumentsSettings(),
            clientContext);
    this.batchProcessDocumentsOperationCallable =
        callableFactory.createOperationCallable(
            batchProcessDocumentsTransportSettings,
            settings.batchProcessDocumentsOperationSettings(),
            clientContext,
            operationsStub);
    this.fetchProcessorTypesCallable =
        callableFactory.createUnaryCallable(
            fetchProcessorTypesTransportSettings,
            settings.fetchProcessorTypesSettings(),
            clientContext);
    this.listProcessorTypesCallable =
        callableFactory.createUnaryCallable(
            listProcessorTypesTransportSettings,
            settings.listProcessorTypesSettings(),
            clientContext);
    this.listProcessorTypesPagedCallable =
        callableFactory.createPagedCallable(
            listProcessorTypesTransportSettings,
            settings.listProcessorTypesSettings(),
            clientContext);
    this.listProcessorsCallable =
        callableFactory.createUnaryCallable(
            listProcessorsTransportSettings, settings.listProcessorsSettings(), clientContext);
    this.listProcessorsPagedCallable =
        callableFactory.createPagedCallable(
            listProcessorsTransportSettings, settings.listProcessorsSettings(), clientContext);
    this.getProcessorCallable =
        callableFactory.createUnaryCallable(
            getProcessorTransportSettings, settings.getProcessorSettings(), clientContext);
    this.trainProcessorVersionCallable =
        callableFactory.createUnaryCallable(
            trainProcessorVersionTransportSettings,
            settings.trainProcessorVersionSettings(),
            clientContext);
    this.trainProcessorVersionOperationCallable =
        callableFactory.createOperationCallable(
            trainProcessorVersionTransportSettings,
            settings.trainProcessorVersionOperationSettings(),
            clientContext,
            operationsStub);
    this.getProcessorVersionCallable =
        callableFactory.createUnaryCallable(
            getProcessorVersionTransportSettings,
            settings.getProcessorVersionSettings(),
            clientContext);
    this.listProcessorVersionsCallable =
        callableFactory.createUnaryCallable(
            listProcessorVersionsTransportSettings,
            settings.listProcessorVersionsSettings(),
            clientContext);
    this.listProcessorVersionsPagedCallable =
        callableFactory.createPagedCallable(
            listProcessorVersionsTransportSettings,
            settings.listProcessorVersionsSettings(),
            clientContext);
    this.deleteProcessorVersionCallable =
        callableFactory.createUnaryCallable(
            deleteProcessorVersionTransportSettings,
            settings.deleteProcessorVersionSettings(),
            clientContext);
    this.deleteProcessorVersionOperationCallable =
        callableFactory.createOperationCallable(
            deleteProcessorVersionTransportSettings,
            settings.deleteProcessorVersionOperationSettings(),
            clientContext,
            operationsStub);
    this.deployProcessorVersionCallable =
        callableFactory.createUnaryCallable(
            deployProcessorVersionTransportSettings,
            settings.deployProcessorVersionSettings(),
            clientContext);
    this.deployProcessorVersionOperationCallable =
        callableFactory.createOperationCallable(
            deployProcessorVersionTransportSettings,
            settings.deployProcessorVersionOperationSettings(),
            clientContext,
            operationsStub);
    this.undeployProcessorVersionCallable =
        callableFactory.createUnaryCallable(
            undeployProcessorVersionTransportSettings,
            settings.undeployProcessorVersionSettings(),
            clientContext);
    this.undeployProcessorVersionOperationCallable =
        callableFactory.createOperationCallable(
            undeployProcessorVersionTransportSettings,
            settings.undeployProcessorVersionOperationSettings(),
            clientContext,
            operationsStub);
    this.createProcessorCallable =
        callableFactory.createUnaryCallable(
            createProcessorTransportSettings, settings.createProcessorSettings(), clientContext);
    this.deleteProcessorCallable =
        callableFactory.createUnaryCallable(
            deleteProcessorTransportSettings, settings.deleteProcessorSettings(), clientContext);
    this.deleteProcessorOperationCallable =
        callableFactory.createOperationCallable(
            deleteProcessorTransportSettings,
            settings.deleteProcessorOperationSettings(),
            clientContext,
            operationsStub);
    this.enableProcessorCallable =
        callableFactory.createUnaryCallable(
            enableProcessorTransportSettings, settings.enableProcessorSettings(), clientContext);
    this.enableProcessorOperationCallable =
        callableFactory.createOperationCallable(
            enableProcessorTransportSettings,
            settings.enableProcessorOperationSettings(),
            clientContext,
            operationsStub);
    this.disableProcessorCallable =
        callableFactory.createUnaryCallable(
            disableProcessorTransportSettings, settings.disableProcessorSettings(), clientContext);
    this.disableProcessorOperationCallable =
        callableFactory.createOperationCallable(
            disableProcessorTransportSettings,
            settings.disableProcessorOperationSettings(),
            clientContext,
            operationsStub);
    this.setDefaultProcessorVersionCallable =
        callableFactory.createUnaryCallable(
            setDefaultProcessorVersionTransportSettings,
            settings.setDefaultProcessorVersionSettings(),
            clientContext);
    this.setDefaultProcessorVersionOperationCallable =
        callableFactory.createOperationCallable(
            setDefaultProcessorVersionTransportSettings,
            settings.setDefaultProcessorVersionOperationSettings(),
            clientContext,
            operationsStub);
    this.reviewDocumentCallable =
        callableFactory.createUnaryCallable(
            reviewDocumentTransportSettings, settings.reviewDocumentSettings(), clientContext);
    this.reviewDocumentOperationCallable =
        callableFactory.createOperationCallable(
            reviewDocumentTransportSettings,
            settings.reviewDocumentOperationSettings(),
            clientContext,
            operationsStub);
    this.evaluateProcessorVersionCallable =
        callableFactory.createUnaryCallable(
            evaluateProcessorVersionTransportSettings,
            settings.evaluateProcessorVersionSettings(),
            clientContext);
    this.evaluateProcessorVersionOperationCallable =
        callableFactory.createOperationCallable(
            evaluateProcessorVersionTransportSettings,
            settings.evaluateProcessorVersionOperationSettings(),
            clientContext,
            operationsStub);
    this.getEvaluationCallable =
        callableFactory.createUnaryCallable(
            getEvaluationTransportSettings, settings.getEvaluationSettings(), clientContext);
    this.listEvaluationsCallable =
        callableFactory.createUnaryCallable(
            listEvaluationsTransportSettings, settings.listEvaluationsSettings(), clientContext);
    this.listEvaluationsPagedCallable =
        callableFactory.createPagedCallable(
            listEvaluationsTransportSettings, settings.listEvaluationsSettings(), clientContext);
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
  public UnaryCallable<ProcessRequest, ProcessResponse> processDocumentCallable() {
    return processDocumentCallable;
  }

  @Override
  public UnaryCallable<BatchProcessRequest, Operation> batchProcessDocumentsCallable() {
    return batchProcessDocumentsCallable;
  }

  @Override
  public OperationCallable<BatchProcessRequest, BatchProcessResponse, BatchProcessMetadata>
      batchProcessDocumentsOperationCallable() {
    return batchProcessDocumentsOperationCallable;
  }

  @Override
  public UnaryCallable<FetchProcessorTypesRequest, FetchProcessorTypesResponse>
      fetchProcessorTypesCallable() {
    return fetchProcessorTypesCallable;
  }

  @Override
  public UnaryCallable<ListProcessorTypesRequest, ListProcessorTypesResponse>
      listProcessorTypesCallable() {
    return listProcessorTypesCallable;
  }

  @Override
  public UnaryCallable<ListProcessorTypesRequest, ListProcessorTypesPagedResponse>
      listProcessorTypesPagedCallable() {
    return listProcessorTypesPagedCallable;
  }

  @Override
  public UnaryCallable<ListProcessorsRequest, ListProcessorsResponse> listProcessorsCallable() {
    return listProcessorsCallable;
  }

  @Override
  public UnaryCallable<ListProcessorsRequest, ListProcessorsPagedResponse>
      listProcessorsPagedCallable() {
    return listProcessorsPagedCallable;
  }

  @Override
  public UnaryCallable<GetProcessorRequest, Processor> getProcessorCallable() {
    return getProcessorCallable;
  }

  @Override
  public UnaryCallable<TrainProcessorVersionRequest, Operation> trainProcessorVersionCallable() {
    return trainProcessorVersionCallable;
  }

  @Override
  public OperationCallable<
          TrainProcessorVersionRequest,
          TrainProcessorVersionResponse,
          TrainProcessorVersionMetadata>
      trainProcessorVersionOperationCallable() {
    return trainProcessorVersionOperationCallable;
  }

  @Override
  public UnaryCallable<GetProcessorVersionRequest, ProcessorVersion> getProcessorVersionCallable() {
    return getProcessorVersionCallable;
  }

  @Override
  public UnaryCallable<ListProcessorVersionsRequest, ListProcessorVersionsResponse>
      listProcessorVersionsCallable() {
    return listProcessorVersionsCallable;
  }

  @Override
  public UnaryCallable<ListProcessorVersionsRequest, ListProcessorVersionsPagedResponse>
      listProcessorVersionsPagedCallable() {
    return listProcessorVersionsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteProcessorVersionRequest, Operation> deleteProcessorVersionCallable() {
    return deleteProcessorVersionCallable;
  }

  @Override
  public OperationCallable<DeleteProcessorVersionRequest, Empty, DeleteProcessorVersionMetadata>
      deleteProcessorVersionOperationCallable() {
    return deleteProcessorVersionOperationCallable;
  }

  @Override
  public UnaryCallable<DeployProcessorVersionRequest, Operation> deployProcessorVersionCallable() {
    return deployProcessorVersionCallable;
  }

  @Override
  public OperationCallable<
          DeployProcessorVersionRequest,
          DeployProcessorVersionResponse,
          DeployProcessorVersionMetadata>
      deployProcessorVersionOperationCallable() {
    return deployProcessorVersionOperationCallable;
  }

  @Override
  public UnaryCallable<UndeployProcessorVersionRequest, Operation>
      undeployProcessorVersionCallable() {
    return undeployProcessorVersionCallable;
  }

  @Override
  public OperationCallable<
          UndeployProcessorVersionRequest,
          UndeployProcessorVersionResponse,
          UndeployProcessorVersionMetadata>
      undeployProcessorVersionOperationCallable() {
    return undeployProcessorVersionOperationCallable;
  }

  @Override
  public UnaryCallable<CreateProcessorRequest, Processor> createProcessorCallable() {
    return createProcessorCallable;
  }

  @Override
  public UnaryCallable<DeleteProcessorRequest, Operation> deleteProcessorCallable() {
    return deleteProcessorCallable;
  }

  @Override
  public OperationCallable<DeleteProcessorRequest, Empty, DeleteProcessorMetadata>
      deleteProcessorOperationCallable() {
    return deleteProcessorOperationCallable;
  }

  @Override
  public UnaryCallable<EnableProcessorRequest, Operation> enableProcessorCallable() {
    return enableProcessorCallable;
  }

  @Override
  public OperationCallable<EnableProcessorRequest, EnableProcessorResponse, EnableProcessorMetadata>
      enableProcessorOperationCallable() {
    return enableProcessorOperationCallable;
  }

  @Override
  public UnaryCallable<DisableProcessorRequest, Operation> disableProcessorCallable() {
    return disableProcessorCallable;
  }

  @Override
  public OperationCallable<
          DisableProcessorRequest, DisableProcessorResponse, DisableProcessorMetadata>
      disableProcessorOperationCallable() {
    return disableProcessorOperationCallable;
  }

  @Override
  public UnaryCallable<SetDefaultProcessorVersionRequest, Operation>
      setDefaultProcessorVersionCallable() {
    return setDefaultProcessorVersionCallable;
  }

  @Override
  public OperationCallable<
          SetDefaultProcessorVersionRequest,
          SetDefaultProcessorVersionResponse,
          SetDefaultProcessorVersionMetadata>
      setDefaultProcessorVersionOperationCallable() {
    return setDefaultProcessorVersionOperationCallable;
  }

  @Override
  public UnaryCallable<ReviewDocumentRequest, Operation> reviewDocumentCallable() {
    return reviewDocumentCallable;
  }

  @Override
  public OperationCallable<
          ReviewDocumentRequest, ReviewDocumentResponse, ReviewDocumentOperationMetadata>
      reviewDocumentOperationCallable() {
    return reviewDocumentOperationCallable;
  }

  @Override
  public UnaryCallable<EvaluateProcessorVersionRequest, Operation>
      evaluateProcessorVersionCallable() {
    return evaluateProcessorVersionCallable;
  }

  @Override
  public OperationCallable<
          EvaluateProcessorVersionRequest,
          EvaluateProcessorVersionResponse,
          EvaluateProcessorVersionMetadata>
      evaluateProcessorVersionOperationCallable() {
    return evaluateProcessorVersionOperationCallable;
  }

  @Override
  public UnaryCallable<GetEvaluationRequest, Evaluation> getEvaluationCallable() {
    return getEvaluationCallable;
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
