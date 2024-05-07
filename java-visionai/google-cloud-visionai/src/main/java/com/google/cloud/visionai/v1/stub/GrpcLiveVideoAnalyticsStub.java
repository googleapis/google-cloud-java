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

package com.google.cloud.visionai.v1.stub;

import static com.google.cloud.visionai.v1.LiveVideoAnalyticsClient.ListAnalysesPagedResponse;
import static com.google.cloud.visionai.v1.LiveVideoAnalyticsClient.ListOperatorsPagedResponse;
import static com.google.cloud.visionai.v1.LiveVideoAnalyticsClient.ListProcessesPagedResponse;
import static com.google.cloud.visionai.v1.LiveVideoAnalyticsClient.ListPublicOperatorsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.visionai.v1.Analysis;
import com.google.cloud.visionai.v1.BatchRunProcessRequest;
import com.google.cloud.visionai.v1.BatchRunProcessResponse;
import com.google.cloud.visionai.v1.CreateAnalysisRequest;
import com.google.cloud.visionai.v1.CreateOperatorRequest;
import com.google.cloud.visionai.v1.CreateProcessRequest;
import com.google.cloud.visionai.v1.DeleteAnalysisRequest;
import com.google.cloud.visionai.v1.DeleteOperatorRequest;
import com.google.cloud.visionai.v1.DeleteProcessRequest;
import com.google.cloud.visionai.v1.GetAnalysisRequest;
import com.google.cloud.visionai.v1.GetOperatorRequest;
import com.google.cloud.visionai.v1.GetProcessRequest;
import com.google.cloud.visionai.v1.ListAnalysesRequest;
import com.google.cloud.visionai.v1.ListAnalysesResponse;
import com.google.cloud.visionai.v1.ListOperatorsRequest;
import com.google.cloud.visionai.v1.ListOperatorsResponse;
import com.google.cloud.visionai.v1.ListProcessesRequest;
import com.google.cloud.visionai.v1.ListProcessesResponse;
import com.google.cloud.visionai.v1.ListPublicOperatorsRequest;
import com.google.cloud.visionai.v1.ListPublicOperatorsResponse;
import com.google.cloud.visionai.v1.OperationMetadata;
import com.google.cloud.visionai.v1.Operator;
import com.google.cloud.visionai.v1.Process;
import com.google.cloud.visionai.v1.ResolveOperatorInfoRequest;
import com.google.cloud.visionai.v1.ResolveOperatorInfoResponse;
import com.google.cloud.visionai.v1.UpdateAnalysisRequest;
import com.google.cloud.visionai.v1.UpdateOperatorRequest;
import com.google.cloud.visionai.v1.UpdateProcessRequest;
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
 * gRPC stub implementation for the LiveVideoAnalytics service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcLiveVideoAnalyticsStub extends LiveVideoAnalyticsStub {
  private static final MethodDescriptor<ListPublicOperatorsRequest, ListPublicOperatorsResponse>
      listPublicOperatorsMethodDescriptor =
          MethodDescriptor.<ListPublicOperatorsRequest, ListPublicOperatorsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.LiveVideoAnalytics/ListPublicOperators")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListPublicOperatorsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListPublicOperatorsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ResolveOperatorInfoRequest, ResolveOperatorInfoResponse>
      resolveOperatorInfoMethodDescriptor =
          MethodDescriptor.<ResolveOperatorInfoRequest, ResolveOperatorInfoResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.LiveVideoAnalytics/ResolveOperatorInfo")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ResolveOperatorInfoRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ResolveOperatorInfoResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListOperatorsRequest, ListOperatorsResponse>
      listOperatorsMethodDescriptor =
          MethodDescriptor.<ListOperatorsRequest, ListOperatorsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.LiveVideoAnalytics/ListOperators")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListOperatorsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListOperatorsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetOperatorRequest, Operator> getOperatorMethodDescriptor =
      MethodDescriptor.<GetOperatorRequest, Operator>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.visionai.v1.LiveVideoAnalytics/GetOperator")
          .setRequestMarshaller(ProtoUtils.marshaller(GetOperatorRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operator.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateOperatorRequest, Operation>
      createOperatorMethodDescriptor =
          MethodDescriptor.<CreateOperatorRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.LiveVideoAnalytics/CreateOperator")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateOperatorRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateOperatorRequest, Operation>
      updateOperatorMethodDescriptor =
          MethodDescriptor.<UpdateOperatorRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.LiveVideoAnalytics/UpdateOperator")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateOperatorRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteOperatorRequest, Operation>
      deleteOperatorMethodDescriptor =
          MethodDescriptor.<DeleteOperatorRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.LiveVideoAnalytics/DeleteOperator")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteOperatorRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListAnalysesRequest, ListAnalysesResponse>
      listAnalysesMethodDescriptor =
          MethodDescriptor.<ListAnalysesRequest, ListAnalysesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.LiveVideoAnalytics/ListAnalyses")
              .setRequestMarshaller(ProtoUtils.marshaller(ListAnalysesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAnalysesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetAnalysisRequest, Analysis> getAnalysisMethodDescriptor =
      MethodDescriptor.<GetAnalysisRequest, Analysis>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.visionai.v1.LiveVideoAnalytics/GetAnalysis")
          .setRequestMarshaller(ProtoUtils.marshaller(GetAnalysisRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Analysis.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateAnalysisRequest, Operation>
      createAnalysisMethodDescriptor =
          MethodDescriptor.<CreateAnalysisRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.LiveVideoAnalytics/CreateAnalysis")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateAnalysisRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateAnalysisRequest, Operation>
      updateAnalysisMethodDescriptor =
          MethodDescriptor.<UpdateAnalysisRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.LiveVideoAnalytics/UpdateAnalysis")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateAnalysisRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteAnalysisRequest, Operation>
      deleteAnalysisMethodDescriptor =
          MethodDescriptor.<DeleteAnalysisRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.LiveVideoAnalytics/DeleteAnalysis")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteAnalysisRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListProcessesRequest, ListProcessesResponse>
      listProcessesMethodDescriptor =
          MethodDescriptor.<ListProcessesRequest, ListProcessesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.LiveVideoAnalytics/ListProcesses")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListProcessesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListProcessesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetProcessRequest, Process> getProcessMethodDescriptor =
      MethodDescriptor.<GetProcessRequest, Process>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.visionai.v1.LiveVideoAnalytics/GetProcess")
          .setRequestMarshaller(ProtoUtils.marshaller(GetProcessRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Process.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateProcessRequest, Operation>
      createProcessMethodDescriptor =
          MethodDescriptor.<CreateProcessRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.LiveVideoAnalytics/CreateProcess")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateProcessRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateProcessRequest, Operation>
      updateProcessMethodDescriptor =
          MethodDescriptor.<UpdateProcessRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.LiveVideoAnalytics/UpdateProcess")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateProcessRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteProcessRequest, Operation>
      deleteProcessMethodDescriptor =
          MethodDescriptor.<DeleteProcessRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.LiveVideoAnalytics/DeleteProcess")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteProcessRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<BatchRunProcessRequest, Operation>
      batchRunProcessMethodDescriptor =
          MethodDescriptor.<BatchRunProcessRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.LiveVideoAnalytics/BatchRunProcess")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchRunProcessRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListPublicOperatorsRequest, ListPublicOperatorsResponse>
      listPublicOperatorsCallable;
  private final UnaryCallable<ListPublicOperatorsRequest, ListPublicOperatorsPagedResponse>
      listPublicOperatorsPagedCallable;
  private final UnaryCallable<ResolveOperatorInfoRequest, ResolveOperatorInfoResponse>
      resolveOperatorInfoCallable;
  private final UnaryCallable<ListOperatorsRequest, ListOperatorsResponse> listOperatorsCallable;
  private final UnaryCallable<ListOperatorsRequest, ListOperatorsPagedResponse>
      listOperatorsPagedCallable;
  private final UnaryCallable<GetOperatorRequest, Operator> getOperatorCallable;
  private final UnaryCallable<CreateOperatorRequest, Operation> createOperatorCallable;
  private final OperationCallable<CreateOperatorRequest, Operator, OperationMetadata>
      createOperatorOperationCallable;
  private final UnaryCallable<UpdateOperatorRequest, Operation> updateOperatorCallable;
  private final OperationCallable<UpdateOperatorRequest, Operator, OperationMetadata>
      updateOperatorOperationCallable;
  private final UnaryCallable<DeleteOperatorRequest, Operation> deleteOperatorCallable;
  private final OperationCallable<DeleteOperatorRequest, Empty, OperationMetadata>
      deleteOperatorOperationCallable;
  private final UnaryCallable<ListAnalysesRequest, ListAnalysesResponse> listAnalysesCallable;
  private final UnaryCallable<ListAnalysesRequest, ListAnalysesPagedResponse>
      listAnalysesPagedCallable;
  private final UnaryCallable<GetAnalysisRequest, Analysis> getAnalysisCallable;
  private final UnaryCallable<CreateAnalysisRequest, Operation> createAnalysisCallable;
  private final OperationCallable<CreateAnalysisRequest, Analysis, OperationMetadata>
      createAnalysisOperationCallable;
  private final UnaryCallable<UpdateAnalysisRequest, Operation> updateAnalysisCallable;
  private final OperationCallable<UpdateAnalysisRequest, Analysis, OperationMetadata>
      updateAnalysisOperationCallable;
  private final UnaryCallable<DeleteAnalysisRequest, Operation> deleteAnalysisCallable;
  private final OperationCallable<DeleteAnalysisRequest, Empty, OperationMetadata>
      deleteAnalysisOperationCallable;
  private final UnaryCallable<ListProcessesRequest, ListProcessesResponse> listProcessesCallable;
  private final UnaryCallable<ListProcessesRequest, ListProcessesPagedResponse>
      listProcessesPagedCallable;
  private final UnaryCallable<GetProcessRequest, Process> getProcessCallable;
  private final UnaryCallable<CreateProcessRequest, Operation> createProcessCallable;
  private final OperationCallable<CreateProcessRequest, Process, OperationMetadata>
      createProcessOperationCallable;
  private final UnaryCallable<UpdateProcessRequest, Operation> updateProcessCallable;
  private final OperationCallable<UpdateProcessRequest, Process, OperationMetadata>
      updateProcessOperationCallable;
  private final UnaryCallable<DeleteProcessRequest, Operation> deleteProcessCallable;
  private final OperationCallable<DeleteProcessRequest, Empty, OperationMetadata>
      deleteProcessOperationCallable;
  private final UnaryCallable<BatchRunProcessRequest, Operation> batchRunProcessCallable;
  private final OperationCallable<
          BatchRunProcessRequest, BatchRunProcessResponse, OperationMetadata>
      batchRunProcessOperationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcLiveVideoAnalyticsStub create(LiveVideoAnalyticsStubSettings settings)
      throws IOException {
    return new GrpcLiveVideoAnalyticsStub(settings, ClientContext.create(settings));
  }

  public static final GrpcLiveVideoAnalyticsStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcLiveVideoAnalyticsStub(
        LiveVideoAnalyticsStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcLiveVideoAnalyticsStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcLiveVideoAnalyticsStub(
        LiveVideoAnalyticsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcLiveVideoAnalyticsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcLiveVideoAnalyticsStub(
      LiveVideoAnalyticsStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcLiveVideoAnalyticsCallableFactory());
  }

  /**
   * Constructs an instance of GrpcLiveVideoAnalyticsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcLiveVideoAnalyticsStub(
      LiveVideoAnalyticsStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListPublicOperatorsRequest, ListPublicOperatorsResponse>
        listPublicOperatorsTransportSettings =
            GrpcCallSettings.<ListPublicOperatorsRequest, ListPublicOperatorsResponse>newBuilder()
                .setMethodDescriptor(listPublicOperatorsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ResolveOperatorInfoRequest, ResolveOperatorInfoResponse>
        resolveOperatorInfoTransportSettings =
            GrpcCallSettings.<ResolveOperatorInfoRequest, ResolveOperatorInfoResponse>newBuilder()
                .setMethodDescriptor(resolveOperatorInfoMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListOperatorsRequest, ListOperatorsResponse> listOperatorsTransportSettings =
        GrpcCallSettings.<ListOperatorsRequest, ListOperatorsResponse>newBuilder()
            .setMethodDescriptor(listOperatorsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetOperatorRequest, Operator> getOperatorTransportSettings =
        GrpcCallSettings.<GetOperatorRequest, Operator>newBuilder()
            .setMethodDescriptor(getOperatorMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateOperatorRequest, Operation> createOperatorTransportSettings =
        GrpcCallSettings.<CreateOperatorRequest, Operation>newBuilder()
            .setMethodDescriptor(createOperatorMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateOperatorRequest, Operation> updateOperatorTransportSettings =
        GrpcCallSettings.<UpdateOperatorRequest, Operation>newBuilder()
            .setMethodDescriptor(updateOperatorMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("operator.name", String.valueOf(request.getOperator().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteOperatorRequest, Operation> deleteOperatorTransportSettings =
        GrpcCallSettings.<DeleteOperatorRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteOperatorMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListAnalysesRequest, ListAnalysesResponse> listAnalysesTransportSettings =
        GrpcCallSettings.<ListAnalysesRequest, ListAnalysesResponse>newBuilder()
            .setMethodDescriptor(listAnalysesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetAnalysisRequest, Analysis> getAnalysisTransportSettings =
        GrpcCallSettings.<GetAnalysisRequest, Analysis>newBuilder()
            .setMethodDescriptor(getAnalysisMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateAnalysisRequest, Operation> createAnalysisTransportSettings =
        GrpcCallSettings.<CreateAnalysisRequest, Operation>newBuilder()
            .setMethodDescriptor(createAnalysisMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateAnalysisRequest, Operation> updateAnalysisTransportSettings =
        GrpcCallSettings.<UpdateAnalysisRequest, Operation>newBuilder()
            .setMethodDescriptor(updateAnalysisMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("analysis.name", String.valueOf(request.getAnalysis().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteAnalysisRequest, Operation> deleteAnalysisTransportSettings =
        GrpcCallSettings.<DeleteAnalysisRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteAnalysisMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListProcessesRequest, ListProcessesResponse> listProcessesTransportSettings =
        GrpcCallSettings.<ListProcessesRequest, ListProcessesResponse>newBuilder()
            .setMethodDescriptor(listProcessesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetProcessRequest, Process> getProcessTransportSettings =
        GrpcCallSettings.<GetProcessRequest, Process>newBuilder()
            .setMethodDescriptor(getProcessMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateProcessRequest, Operation> createProcessTransportSettings =
        GrpcCallSettings.<CreateProcessRequest, Operation>newBuilder()
            .setMethodDescriptor(createProcessMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateProcessRequest, Operation> updateProcessTransportSettings =
        GrpcCallSettings.<UpdateProcessRequest, Operation>newBuilder()
            .setMethodDescriptor(updateProcessMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("process.name", String.valueOf(request.getProcess().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteProcessRequest, Operation> deleteProcessTransportSettings =
        GrpcCallSettings.<DeleteProcessRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteProcessMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<BatchRunProcessRequest, Operation> batchRunProcessTransportSettings =
        GrpcCallSettings.<BatchRunProcessRequest, Operation>newBuilder()
            .setMethodDescriptor(batchRunProcessMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();

    this.listPublicOperatorsCallable =
        callableFactory.createUnaryCallable(
            listPublicOperatorsTransportSettings,
            settings.listPublicOperatorsSettings(),
            clientContext);
    this.listPublicOperatorsPagedCallable =
        callableFactory.createPagedCallable(
            listPublicOperatorsTransportSettings,
            settings.listPublicOperatorsSettings(),
            clientContext);
    this.resolveOperatorInfoCallable =
        callableFactory.createUnaryCallable(
            resolveOperatorInfoTransportSettings,
            settings.resolveOperatorInfoSettings(),
            clientContext);
    this.listOperatorsCallable =
        callableFactory.createUnaryCallable(
            listOperatorsTransportSettings, settings.listOperatorsSettings(), clientContext);
    this.listOperatorsPagedCallable =
        callableFactory.createPagedCallable(
            listOperatorsTransportSettings, settings.listOperatorsSettings(), clientContext);
    this.getOperatorCallable =
        callableFactory.createUnaryCallable(
            getOperatorTransportSettings, settings.getOperatorSettings(), clientContext);
    this.createOperatorCallable =
        callableFactory.createUnaryCallable(
            createOperatorTransportSettings, settings.createOperatorSettings(), clientContext);
    this.createOperatorOperationCallable =
        callableFactory.createOperationCallable(
            createOperatorTransportSettings,
            settings.createOperatorOperationSettings(),
            clientContext,
            operationsStub);
    this.updateOperatorCallable =
        callableFactory.createUnaryCallable(
            updateOperatorTransportSettings, settings.updateOperatorSettings(), clientContext);
    this.updateOperatorOperationCallable =
        callableFactory.createOperationCallable(
            updateOperatorTransportSettings,
            settings.updateOperatorOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteOperatorCallable =
        callableFactory.createUnaryCallable(
            deleteOperatorTransportSettings, settings.deleteOperatorSettings(), clientContext);
    this.deleteOperatorOperationCallable =
        callableFactory.createOperationCallable(
            deleteOperatorTransportSettings,
            settings.deleteOperatorOperationSettings(),
            clientContext,
            operationsStub);
    this.listAnalysesCallable =
        callableFactory.createUnaryCallable(
            listAnalysesTransportSettings, settings.listAnalysesSettings(), clientContext);
    this.listAnalysesPagedCallable =
        callableFactory.createPagedCallable(
            listAnalysesTransportSettings, settings.listAnalysesSettings(), clientContext);
    this.getAnalysisCallable =
        callableFactory.createUnaryCallable(
            getAnalysisTransportSettings, settings.getAnalysisSettings(), clientContext);
    this.createAnalysisCallable =
        callableFactory.createUnaryCallable(
            createAnalysisTransportSettings, settings.createAnalysisSettings(), clientContext);
    this.createAnalysisOperationCallable =
        callableFactory.createOperationCallable(
            createAnalysisTransportSettings,
            settings.createAnalysisOperationSettings(),
            clientContext,
            operationsStub);
    this.updateAnalysisCallable =
        callableFactory.createUnaryCallable(
            updateAnalysisTransportSettings, settings.updateAnalysisSettings(), clientContext);
    this.updateAnalysisOperationCallable =
        callableFactory.createOperationCallable(
            updateAnalysisTransportSettings,
            settings.updateAnalysisOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteAnalysisCallable =
        callableFactory.createUnaryCallable(
            deleteAnalysisTransportSettings, settings.deleteAnalysisSettings(), clientContext);
    this.deleteAnalysisOperationCallable =
        callableFactory.createOperationCallable(
            deleteAnalysisTransportSettings,
            settings.deleteAnalysisOperationSettings(),
            clientContext,
            operationsStub);
    this.listProcessesCallable =
        callableFactory.createUnaryCallable(
            listProcessesTransportSettings, settings.listProcessesSettings(), clientContext);
    this.listProcessesPagedCallable =
        callableFactory.createPagedCallable(
            listProcessesTransportSettings, settings.listProcessesSettings(), clientContext);
    this.getProcessCallable =
        callableFactory.createUnaryCallable(
            getProcessTransportSettings, settings.getProcessSettings(), clientContext);
    this.createProcessCallable =
        callableFactory.createUnaryCallable(
            createProcessTransportSettings, settings.createProcessSettings(), clientContext);
    this.createProcessOperationCallable =
        callableFactory.createOperationCallable(
            createProcessTransportSettings,
            settings.createProcessOperationSettings(),
            clientContext,
            operationsStub);
    this.updateProcessCallable =
        callableFactory.createUnaryCallable(
            updateProcessTransportSettings, settings.updateProcessSettings(), clientContext);
    this.updateProcessOperationCallable =
        callableFactory.createOperationCallable(
            updateProcessTransportSettings,
            settings.updateProcessOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteProcessCallable =
        callableFactory.createUnaryCallable(
            deleteProcessTransportSettings, settings.deleteProcessSettings(), clientContext);
    this.deleteProcessOperationCallable =
        callableFactory.createOperationCallable(
            deleteProcessTransportSettings,
            settings.deleteProcessOperationSettings(),
            clientContext,
            operationsStub);
    this.batchRunProcessCallable =
        callableFactory.createUnaryCallable(
            batchRunProcessTransportSettings, settings.batchRunProcessSettings(), clientContext);
    this.batchRunProcessOperationCallable =
        callableFactory.createOperationCallable(
            batchRunProcessTransportSettings,
            settings.batchRunProcessOperationSettings(),
            clientContext,
            operationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListPublicOperatorsRequest, ListPublicOperatorsResponse>
      listPublicOperatorsCallable() {
    return listPublicOperatorsCallable;
  }

  @Override
  public UnaryCallable<ListPublicOperatorsRequest, ListPublicOperatorsPagedResponse>
      listPublicOperatorsPagedCallable() {
    return listPublicOperatorsPagedCallable;
  }

  @Override
  public UnaryCallable<ResolveOperatorInfoRequest, ResolveOperatorInfoResponse>
      resolveOperatorInfoCallable() {
    return resolveOperatorInfoCallable;
  }

  @Override
  public UnaryCallable<ListOperatorsRequest, ListOperatorsResponse> listOperatorsCallable() {
    return listOperatorsCallable;
  }

  @Override
  public UnaryCallable<ListOperatorsRequest, ListOperatorsPagedResponse>
      listOperatorsPagedCallable() {
    return listOperatorsPagedCallable;
  }

  @Override
  public UnaryCallable<GetOperatorRequest, Operator> getOperatorCallable() {
    return getOperatorCallable;
  }

  @Override
  public UnaryCallable<CreateOperatorRequest, Operation> createOperatorCallable() {
    return createOperatorCallable;
  }

  @Override
  public OperationCallable<CreateOperatorRequest, Operator, OperationMetadata>
      createOperatorOperationCallable() {
    return createOperatorOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateOperatorRequest, Operation> updateOperatorCallable() {
    return updateOperatorCallable;
  }

  @Override
  public OperationCallable<UpdateOperatorRequest, Operator, OperationMetadata>
      updateOperatorOperationCallable() {
    return updateOperatorOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteOperatorRequest, Operation> deleteOperatorCallable() {
    return deleteOperatorCallable;
  }

  @Override
  public OperationCallable<DeleteOperatorRequest, Empty, OperationMetadata>
      deleteOperatorOperationCallable() {
    return deleteOperatorOperationCallable;
  }

  @Override
  public UnaryCallable<ListAnalysesRequest, ListAnalysesResponse> listAnalysesCallable() {
    return listAnalysesCallable;
  }

  @Override
  public UnaryCallable<ListAnalysesRequest, ListAnalysesPagedResponse> listAnalysesPagedCallable() {
    return listAnalysesPagedCallable;
  }

  @Override
  public UnaryCallable<GetAnalysisRequest, Analysis> getAnalysisCallable() {
    return getAnalysisCallable;
  }

  @Override
  public UnaryCallable<CreateAnalysisRequest, Operation> createAnalysisCallable() {
    return createAnalysisCallable;
  }

  @Override
  public OperationCallable<CreateAnalysisRequest, Analysis, OperationMetadata>
      createAnalysisOperationCallable() {
    return createAnalysisOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateAnalysisRequest, Operation> updateAnalysisCallable() {
    return updateAnalysisCallable;
  }

  @Override
  public OperationCallable<UpdateAnalysisRequest, Analysis, OperationMetadata>
      updateAnalysisOperationCallable() {
    return updateAnalysisOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteAnalysisRequest, Operation> deleteAnalysisCallable() {
    return deleteAnalysisCallable;
  }

  @Override
  public OperationCallable<DeleteAnalysisRequest, Empty, OperationMetadata>
      deleteAnalysisOperationCallable() {
    return deleteAnalysisOperationCallable;
  }

  @Override
  public UnaryCallable<ListProcessesRequest, ListProcessesResponse> listProcessesCallable() {
    return listProcessesCallable;
  }

  @Override
  public UnaryCallable<ListProcessesRequest, ListProcessesPagedResponse>
      listProcessesPagedCallable() {
    return listProcessesPagedCallable;
  }

  @Override
  public UnaryCallable<GetProcessRequest, Process> getProcessCallable() {
    return getProcessCallable;
  }

  @Override
  public UnaryCallable<CreateProcessRequest, Operation> createProcessCallable() {
    return createProcessCallable;
  }

  @Override
  public OperationCallable<CreateProcessRequest, Process, OperationMetadata>
      createProcessOperationCallable() {
    return createProcessOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateProcessRequest, Operation> updateProcessCallable() {
    return updateProcessCallable;
  }

  @Override
  public OperationCallable<UpdateProcessRequest, Process, OperationMetadata>
      updateProcessOperationCallable() {
    return updateProcessOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteProcessRequest, Operation> deleteProcessCallable() {
    return deleteProcessCallable;
  }

  @Override
  public OperationCallable<DeleteProcessRequest, Empty, OperationMetadata>
      deleteProcessOperationCallable() {
    return deleteProcessOperationCallable;
  }

  @Override
  public UnaryCallable<BatchRunProcessRequest, Operation> batchRunProcessCallable() {
    return batchRunProcessCallable;
  }

  @Override
  public OperationCallable<BatchRunProcessRequest, BatchRunProcessResponse, OperationMetadata>
      batchRunProcessOperationCallable() {
    return batchRunProcessOperationCallable;
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
