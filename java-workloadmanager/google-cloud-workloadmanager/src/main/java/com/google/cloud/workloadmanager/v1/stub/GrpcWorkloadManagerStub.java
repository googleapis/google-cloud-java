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

package com.google.cloud.workloadmanager.v1.stub;

import static com.google.cloud.workloadmanager.v1.WorkloadManagerClient.ListEvaluationsPagedResponse;
import static com.google.cloud.workloadmanager.v1.WorkloadManagerClient.ListExecutionResultsPagedResponse;
import static com.google.cloud.workloadmanager.v1.WorkloadManagerClient.ListExecutionsPagedResponse;
import static com.google.cloud.workloadmanager.v1.WorkloadManagerClient.ListLocationsPagedResponse;
import static com.google.cloud.workloadmanager.v1.WorkloadManagerClient.ListScannedResourcesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.workloadmanager.v1.CreateEvaluationRequest;
import com.google.cloud.workloadmanager.v1.DeleteEvaluationRequest;
import com.google.cloud.workloadmanager.v1.DeleteExecutionRequest;
import com.google.cloud.workloadmanager.v1.Evaluation;
import com.google.cloud.workloadmanager.v1.Execution;
import com.google.cloud.workloadmanager.v1.GetEvaluationRequest;
import com.google.cloud.workloadmanager.v1.GetExecutionRequest;
import com.google.cloud.workloadmanager.v1.ListEvaluationsRequest;
import com.google.cloud.workloadmanager.v1.ListEvaluationsResponse;
import com.google.cloud.workloadmanager.v1.ListExecutionResultsRequest;
import com.google.cloud.workloadmanager.v1.ListExecutionResultsResponse;
import com.google.cloud.workloadmanager.v1.ListExecutionsRequest;
import com.google.cloud.workloadmanager.v1.ListExecutionsResponse;
import com.google.cloud.workloadmanager.v1.ListRulesRequest;
import com.google.cloud.workloadmanager.v1.ListRulesResponse;
import com.google.cloud.workloadmanager.v1.ListScannedResourcesRequest;
import com.google.cloud.workloadmanager.v1.ListScannedResourcesResponse;
import com.google.cloud.workloadmanager.v1.OperationMetadata;
import com.google.cloud.workloadmanager.v1.RunEvaluationRequest;
import com.google.cloud.workloadmanager.v1.UpdateEvaluationRequest;
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
 * gRPC stub implementation for the WorkloadManager service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcWorkloadManagerStub extends WorkloadManagerStub {
  private static final MethodDescriptor<ListEvaluationsRequest, ListEvaluationsResponse>
      listEvaluationsMethodDescriptor =
          MethodDescriptor.<ListEvaluationsRequest, ListEvaluationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.workloadmanager.v1.WorkloadManager/ListEvaluations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListEvaluationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListEvaluationsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetEvaluationRequest, Evaluation>
      getEvaluationMethodDescriptor =
          MethodDescriptor.<GetEvaluationRequest, Evaluation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.workloadmanager.v1.WorkloadManager/GetEvaluation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetEvaluationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Evaluation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateEvaluationRequest, Operation>
      createEvaluationMethodDescriptor =
          MethodDescriptor.<CreateEvaluationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.workloadmanager.v1.WorkloadManager/CreateEvaluation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateEvaluationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateEvaluationRequest, Operation>
      updateEvaluationMethodDescriptor =
          MethodDescriptor.<UpdateEvaluationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.workloadmanager.v1.WorkloadManager/UpdateEvaluation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateEvaluationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteEvaluationRequest, Operation>
      deleteEvaluationMethodDescriptor =
          MethodDescriptor.<DeleteEvaluationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.workloadmanager.v1.WorkloadManager/DeleteEvaluation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteEvaluationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListExecutionsRequest, ListExecutionsResponse>
      listExecutionsMethodDescriptor =
          MethodDescriptor.<ListExecutionsRequest, ListExecutionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.workloadmanager.v1.WorkloadManager/ListExecutions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListExecutionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListExecutionsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetExecutionRequest, Execution>
      getExecutionMethodDescriptor =
          MethodDescriptor.<GetExecutionRequest, Execution>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.workloadmanager.v1.WorkloadManager/GetExecution")
              .setRequestMarshaller(ProtoUtils.marshaller(GetExecutionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Execution.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<RunEvaluationRequest, Operation>
      runEvaluationMethodDescriptor =
          MethodDescriptor.<RunEvaluationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.workloadmanager.v1.WorkloadManager/RunEvaluation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RunEvaluationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteExecutionRequest, Operation>
      deleteExecutionMethodDescriptor =
          MethodDescriptor.<DeleteExecutionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.workloadmanager.v1.WorkloadManager/DeleteExecution")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteExecutionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListExecutionResultsRequest, ListExecutionResultsResponse>
      listExecutionResultsMethodDescriptor =
          MethodDescriptor.<ListExecutionResultsRequest, ListExecutionResultsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.workloadmanager.v1.WorkloadManager/ListExecutionResults")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListExecutionResultsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListExecutionResultsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListRulesRequest, ListRulesResponse>
      listRulesMethodDescriptor =
          MethodDescriptor.<ListRulesRequest, ListRulesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.workloadmanager.v1.WorkloadManager/ListRules")
              .setRequestMarshaller(ProtoUtils.marshaller(ListRulesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListRulesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListScannedResourcesRequest, ListScannedResourcesResponse>
      listScannedResourcesMethodDescriptor =
          MethodDescriptor.<ListScannedResourcesRequest, ListScannedResourcesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.workloadmanager.v1.WorkloadManager/ListScannedResources")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListScannedResourcesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListScannedResourcesResponse.getDefaultInstance()))
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

  private final UnaryCallable<ListEvaluationsRequest, ListEvaluationsResponse>
      listEvaluationsCallable;
  private final UnaryCallable<ListEvaluationsRequest, ListEvaluationsPagedResponse>
      listEvaluationsPagedCallable;
  private final UnaryCallable<GetEvaluationRequest, Evaluation> getEvaluationCallable;
  private final UnaryCallable<CreateEvaluationRequest, Operation> createEvaluationCallable;
  private final OperationCallable<CreateEvaluationRequest, Evaluation, OperationMetadata>
      createEvaluationOperationCallable;
  private final UnaryCallable<UpdateEvaluationRequest, Operation> updateEvaluationCallable;
  private final OperationCallable<UpdateEvaluationRequest, Evaluation, OperationMetadata>
      updateEvaluationOperationCallable;
  private final UnaryCallable<DeleteEvaluationRequest, Operation> deleteEvaluationCallable;
  private final OperationCallable<DeleteEvaluationRequest, Empty, OperationMetadata>
      deleteEvaluationOperationCallable;
  private final UnaryCallable<ListExecutionsRequest, ListExecutionsResponse> listExecutionsCallable;
  private final UnaryCallable<ListExecutionsRequest, ListExecutionsPagedResponse>
      listExecutionsPagedCallable;
  private final UnaryCallable<GetExecutionRequest, Execution> getExecutionCallable;
  private final UnaryCallable<RunEvaluationRequest, Operation> runEvaluationCallable;
  private final OperationCallable<RunEvaluationRequest, Execution, OperationMetadata>
      runEvaluationOperationCallable;
  private final UnaryCallable<DeleteExecutionRequest, Operation> deleteExecutionCallable;
  private final OperationCallable<DeleteExecutionRequest, Empty, OperationMetadata>
      deleteExecutionOperationCallable;
  private final UnaryCallable<ListExecutionResultsRequest, ListExecutionResultsResponse>
      listExecutionResultsCallable;
  private final UnaryCallable<ListExecutionResultsRequest, ListExecutionResultsPagedResponse>
      listExecutionResultsPagedCallable;
  private final UnaryCallable<ListRulesRequest, ListRulesResponse> listRulesCallable;
  private final UnaryCallable<ListScannedResourcesRequest, ListScannedResourcesResponse>
      listScannedResourcesCallable;
  private final UnaryCallable<ListScannedResourcesRequest, ListScannedResourcesPagedResponse>
      listScannedResourcesPagedCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcWorkloadManagerStub create(WorkloadManagerStubSettings settings)
      throws IOException {
    return new GrpcWorkloadManagerStub(settings, ClientContext.create(settings));
  }

  public static final GrpcWorkloadManagerStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcWorkloadManagerStub(
        WorkloadManagerStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcWorkloadManagerStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcWorkloadManagerStub(
        WorkloadManagerStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcWorkloadManagerStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcWorkloadManagerStub(
      WorkloadManagerStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcWorkloadManagerCallableFactory());
  }

  /**
   * Constructs an instance of GrpcWorkloadManagerStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcWorkloadManagerStub(
      WorkloadManagerStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

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
    GrpcCallSettings<CreateEvaluationRequest, Operation> createEvaluationTransportSettings =
        GrpcCallSettings.<CreateEvaluationRequest, Operation>newBuilder()
            .setMethodDescriptor(createEvaluationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateEvaluationRequest, Operation> updateEvaluationTransportSettings =
        GrpcCallSettings.<UpdateEvaluationRequest, Operation>newBuilder()
            .setMethodDescriptor(updateEvaluationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("evaluation.name", String.valueOf(request.getEvaluation().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteEvaluationRequest, Operation> deleteEvaluationTransportSettings =
        GrpcCallSettings.<DeleteEvaluationRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteEvaluationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListExecutionsRequest, ListExecutionsResponse>
        listExecutionsTransportSettings =
            GrpcCallSettings.<ListExecutionsRequest, ListExecutionsResponse>newBuilder()
                .setMethodDescriptor(listExecutionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetExecutionRequest, Execution> getExecutionTransportSettings =
        GrpcCallSettings.<GetExecutionRequest, Execution>newBuilder()
            .setMethodDescriptor(getExecutionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<RunEvaluationRequest, Operation> runEvaluationTransportSettings =
        GrpcCallSettings.<RunEvaluationRequest, Operation>newBuilder()
            .setMethodDescriptor(runEvaluationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteExecutionRequest, Operation> deleteExecutionTransportSettings =
        GrpcCallSettings.<DeleteExecutionRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteExecutionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListExecutionResultsRequest, ListExecutionResultsResponse>
        listExecutionResultsTransportSettings =
            GrpcCallSettings.<ListExecutionResultsRequest, ListExecutionResultsResponse>newBuilder()
                .setMethodDescriptor(listExecutionResultsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListRulesRequest, ListRulesResponse> listRulesTransportSettings =
        GrpcCallSettings.<ListRulesRequest, ListRulesResponse>newBuilder()
            .setMethodDescriptor(listRulesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListScannedResourcesRequest, ListScannedResourcesResponse>
        listScannedResourcesTransportSettings =
            GrpcCallSettings.<ListScannedResourcesRequest, ListScannedResourcesResponse>newBuilder()
                .setMethodDescriptor(listScannedResourcesMethodDescriptor)
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

    this.listEvaluationsCallable =
        callableFactory.createUnaryCallable(
            listEvaluationsTransportSettings, settings.listEvaluationsSettings(), clientContext);
    this.listEvaluationsPagedCallable =
        callableFactory.createPagedCallable(
            listEvaluationsTransportSettings, settings.listEvaluationsSettings(), clientContext);
    this.getEvaluationCallable =
        callableFactory.createUnaryCallable(
            getEvaluationTransportSettings, settings.getEvaluationSettings(), clientContext);
    this.createEvaluationCallable =
        callableFactory.createUnaryCallable(
            createEvaluationTransportSettings, settings.createEvaluationSettings(), clientContext);
    this.createEvaluationOperationCallable =
        callableFactory.createOperationCallable(
            createEvaluationTransportSettings,
            settings.createEvaluationOperationSettings(),
            clientContext,
            operationsStub);
    this.updateEvaluationCallable =
        callableFactory.createUnaryCallable(
            updateEvaluationTransportSettings, settings.updateEvaluationSettings(), clientContext);
    this.updateEvaluationOperationCallable =
        callableFactory.createOperationCallable(
            updateEvaluationTransportSettings,
            settings.updateEvaluationOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteEvaluationCallable =
        callableFactory.createUnaryCallable(
            deleteEvaluationTransportSettings, settings.deleteEvaluationSettings(), clientContext);
    this.deleteEvaluationOperationCallable =
        callableFactory.createOperationCallable(
            deleteEvaluationTransportSettings,
            settings.deleteEvaluationOperationSettings(),
            clientContext,
            operationsStub);
    this.listExecutionsCallable =
        callableFactory.createUnaryCallable(
            listExecutionsTransportSettings, settings.listExecutionsSettings(), clientContext);
    this.listExecutionsPagedCallable =
        callableFactory.createPagedCallable(
            listExecutionsTransportSettings, settings.listExecutionsSettings(), clientContext);
    this.getExecutionCallable =
        callableFactory.createUnaryCallable(
            getExecutionTransportSettings, settings.getExecutionSettings(), clientContext);
    this.runEvaluationCallable =
        callableFactory.createUnaryCallable(
            runEvaluationTransportSettings, settings.runEvaluationSettings(), clientContext);
    this.runEvaluationOperationCallable =
        callableFactory.createOperationCallable(
            runEvaluationTransportSettings,
            settings.runEvaluationOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteExecutionCallable =
        callableFactory.createUnaryCallable(
            deleteExecutionTransportSettings, settings.deleteExecutionSettings(), clientContext);
    this.deleteExecutionOperationCallable =
        callableFactory.createOperationCallable(
            deleteExecutionTransportSettings,
            settings.deleteExecutionOperationSettings(),
            clientContext,
            operationsStub);
    this.listExecutionResultsCallable =
        callableFactory.createUnaryCallable(
            listExecutionResultsTransportSettings,
            settings.listExecutionResultsSettings(),
            clientContext);
    this.listExecutionResultsPagedCallable =
        callableFactory.createPagedCallable(
            listExecutionResultsTransportSettings,
            settings.listExecutionResultsSettings(),
            clientContext);
    this.listRulesCallable =
        callableFactory.createUnaryCallable(
            listRulesTransportSettings, settings.listRulesSettings(), clientContext);
    this.listScannedResourcesCallable =
        callableFactory.createUnaryCallable(
            listScannedResourcesTransportSettings,
            settings.listScannedResourcesSettings(),
            clientContext);
    this.listScannedResourcesPagedCallable =
        callableFactory.createPagedCallable(
            listScannedResourcesTransportSettings,
            settings.listScannedResourcesSettings(),
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

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
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
  public UnaryCallable<GetEvaluationRequest, Evaluation> getEvaluationCallable() {
    return getEvaluationCallable;
  }

  @Override
  public UnaryCallable<CreateEvaluationRequest, Operation> createEvaluationCallable() {
    return createEvaluationCallable;
  }

  @Override
  public OperationCallable<CreateEvaluationRequest, Evaluation, OperationMetadata>
      createEvaluationOperationCallable() {
    return createEvaluationOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateEvaluationRequest, Operation> updateEvaluationCallable() {
    return updateEvaluationCallable;
  }

  @Override
  public OperationCallable<UpdateEvaluationRequest, Evaluation, OperationMetadata>
      updateEvaluationOperationCallable() {
    return updateEvaluationOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteEvaluationRequest, Operation> deleteEvaluationCallable() {
    return deleteEvaluationCallable;
  }

  @Override
  public OperationCallable<DeleteEvaluationRequest, Empty, OperationMetadata>
      deleteEvaluationOperationCallable() {
    return deleteEvaluationOperationCallable;
  }

  @Override
  public UnaryCallable<ListExecutionsRequest, ListExecutionsResponse> listExecutionsCallable() {
    return listExecutionsCallable;
  }

  @Override
  public UnaryCallable<ListExecutionsRequest, ListExecutionsPagedResponse>
      listExecutionsPagedCallable() {
    return listExecutionsPagedCallable;
  }

  @Override
  public UnaryCallable<GetExecutionRequest, Execution> getExecutionCallable() {
    return getExecutionCallable;
  }

  @Override
  public UnaryCallable<RunEvaluationRequest, Operation> runEvaluationCallable() {
    return runEvaluationCallable;
  }

  @Override
  public OperationCallable<RunEvaluationRequest, Execution, OperationMetadata>
      runEvaluationOperationCallable() {
    return runEvaluationOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteExecutionRequest, Operation> deleteExecutionCallable() {
    return deleteExecutionCallable;
  }

  @Override
  public OperationCallable<DeleteExecutionRequest, Empty, OperationMetadata>
      deleteExecutionOperationCallable() {
    return deleteExecutionOperationCallable;
  }

  @Override
  public UnaryCallable<ListExecutionResultsRequest, ListExecutionResultsResponse>
      listExecutionResultsCallable() {
    return listExecutionResultsCallable;
  }

  @Override
  public UnaryCallable<ListExecutionResultsRequest, ListExecutionResultsPagedResponse>
      listExecutionResultsPagedCallable() {
    return listExecutionResultsPagedCallable;
  }

  @Override
  public UnaryCallable<ListRulesRequest, ListRulesResponse> listRulesCallable() {
    return listRulesCallable;
  }

  @Override
  public UnaryCallable<ListScannedResourcesRequest, ListScannedResourcesResponse>
      listScannedResourcesCallable() {
    return listScannedResourcesCallable;
  }

  @Override
  public UnaryCallable<ListScannedResourcesRequest, ListScannedResourcesPagedResponse>
      listScannedResourcesPagedCallable() {
    return listScannedResourcesPagedCallable;
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
