/*
 * Copyright 2017, Google LLC All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.dialogflow.v2beta1.stub;

import static com.google.cloud.dialogflow.v2beta1.PagedResponseWrappers.SearchAgentsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.v2beta1.Agent;
import com.google.cloud.dialogflow.v2beta1.AgentsSettings;
import com.google.cloud.dialogflow.v2beta1.ExportAgentRequest;
import com.google.cloud.dialogflow.v2beta1.ExportAgentResponse;
import com.google.cloud.dialogflow.v2beta1.GetAgentRequest;
import com.google.cloud.dialogflow.v2beta1.ImportAgentRequest;
import com.google.cloud.dialogflow.v2beta1.RestoreAgentRequest;
import com.google.cloud.dialogflow.v2beta1.SearchAgentsRequest;
import com.google.cloud.dialogflow.v2beta1.SearchAgentsResponse;
import com.google.cloud.dialogflow.v2beta1.TrainAgentRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import com.google.protobuf.Struct;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * gRPC stub implementation for Dialogflow API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by GAPIC v0.0.5")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class GrpcAgentsStub extends AgentsStub {

  private static final MethodDescriptor<GetAgentRequest, Agent> getAgentMethodDescriptor =
      MethodDescriptor.<GetAgentRequest, Agent>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dialogflow.v2beta1.Agents/GetAgent")
          .setRequestMarshaller(ProtoUtils.marshaller(GetAgentRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Agent.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<SearchAgentsRequest, SearchAgentsResponse>
      searchAgentsMethodDescriptor =
          MethodDescriptor.<SearchAgentsRequest, SearchAgentsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.v2beta1.Agents/SearchAgents")
              .setRequestMarshaller(ProtoUtils.marshaller(SearchAgentsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SearchAgentsResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<TrainAgentRequest, Operation> trainAgentMethodDescriptor =
      MethodDescriptor.<TrainAgentRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dialogflow.v2beta1.Agents/TrainAgent")
          .setRequestMarshaller(ProtoUtils.marshaller(TrainAgentRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<ExportAgentRequest, Operation> exportAgentMethodDescriptor =
      MethodDescriptor.<ExportAgentRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dialogflow.v2beta1.Agents/ExportAgent")
          .setRequestMarshaller(ProtoUtils.marshaller(ExportAgentRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<ImportAgentRequest, Operation> importAgentMethodDescriptor =
      MethodDescriptor.<ImportAgentRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dialogflow.v2beta1.Agents/ImportAgent")
          .setRequestMarshaller(ProtoUtils.marshaller(ImportAgentRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<RestoreAgentRequest, Operation>
      restoreAgentMethodDescriptor =
          MethodDescriptor.<RestoreAgentRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.v2beta1.Agents/RestoreAgent")
              .setRequestMarshaller(ProtoUtils.marshaller(RestoreAgentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;

  private final UnaryCallable<GetAgentRequest, Agent> getAgentCallable;
  private final UnaryCallable<SearchAgentsRequest, SearchAgentsResponse> searchAgentsCallable;
  private final UnaryCallable<SearchAgentsRequest, SearchAgentsPagedResponse>
      searchAgentsPagedCallable;
  private final UnaryCallable<TrainAgentRequest, Operation> trainAgentCallable;
  private final OperationCallable<TrainAgentRequest, Empty, Struct> trainAgentOperationCallable;
  private final UnaryCallable<ExportAgentRequest, Operation> exportAgentCallable;
  private final OperationCallable<ExportAgentRequest, ExportAgentResponse, Struct>
      exportAgentOperationCallable;
  private final UnaryCallable<ImportAgentRequest, Operation> importAgentCallable;
  private final OperationCallable<ImportAgentRequest, Empty, Struct> importAgentOperationCallable;
  private final UnaryCallable<RestoreAgentRequest, Operation> restoreAgentCallable;
  private final OperationCallable<RestoreAgentRequest, Empty, Struct> restoreAgentOperationCallable;

  public static final GrpcAgentsStub create(AgentsSettings settings) throws IOException {
    return new GrpcAgentsStub(settings, ClientContext.create(settings));
  }

  public static final GrpcAgentsStub create(ClientContext clientContext) throws IOException {
    return new GrpcAgentsStub(AgentsSettings.newBuilder().build(), clientContext);
  }

  /**
   * Constructs an instance of GrpcAgentsStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcAgentsStub(AgentsSettings settings, ClientContext clientContext)
      throws IOException {
    this.operationsStub = GrpcOperationsStub.create(clientContext);

    GrpcCallSettings<GetAgentRequest, Agent> getAgentTransportSettings =
        GrpcCallSettings.<GetAgentRequest, Agent>newBuilder()
            .setMethodDescriptor(getAgentMethodDescriptor)
            .build();
    GrpcCallSettings<SearchAgentsRequest, SearchAgentsResponse> searchAgentsTransportSettings =
        GrpcCallSettings.<SearchAgentsRequest, SearchAgentsResponse>newBuilder()
            .setMethodDescriptor(searchAgentsMethodDescriptor)
            .build();
    GrpcCallSettings<TrainAgentRequest, Operation> trainAgentTransportSettings =
        GrpcCallSettings.<TrainAgentRequest, Operation>newBuilder()
            .setMethodDescriptor(trainAgentMethodDescriptor)
            .build();
    GrpcCallSettings<ExportAgentRequest, Operation> exportAgentTransportSettings =
        GrpcCallSettings.<ExportAgentRequest, Operation>newBuilder()
            .setMethodDescriptor(exportAgentMethodDescriptor)
            .build();
    GrpcCallSettings<ImportAgentRequest, Operation> importAgentTransportSettings =
        GrpcCallSettings.<ImportAgentRequest, Operation>newBuilder()
            .setMethodDescriptor(importAgentMethodDescriptor)
            .build();
    GrpcCallSettings<RestoreAgentRequest, Operation> restoreAgentTransportSettings =
        GrpcCallSettings.<RestoreAgentRequest, Operation>newBuilder()
            .setMethodDescriptor(restoreAgentMethodDescriptor)
            .build();

    this.getAgentCallable =
        GrpcCallableFactory.createUnaryCallable(
            getAgentTransportSettings, settings.getAgentSettings(), clientContext);
    this.searchAgentsCallable =
        GrpcCallableFactory.createUnaryCallable(
            searchAgentsTransportSettings, settings.searchAgentsSettings(), clientContext);
    this.searchAgentsPagedCallable =
        GrpcCallableFactory.createPagedCallable(
            searchAgentsTransportSettings, settings.searchAgentsSettings(), clientContext);
    this.trainAgentCallable =
        GrpcCallableFactory.createUnaryCallable(
            trainAgentTransportSettings, settings.trainAgentSettings(), clientContext);
    this.trainAgentOperationCallable =
        GrpcCallableFactory.createOperationCallable(
            trainAgentTransportSettings,
            settings.trainAgentOperationSettings(),
            clientContext,
            this.operationsStub);
    this.exportAgentCallable =
        GrpcCallableFactory.createUnaryCallable(
            exportAgentTransportSettings, settings.exportAgentSettings(), clientContext);
    this.exportAgentOperationCallable =
        GrpcCallableFactory.createOperationCallable(
            exportAgentTransportSettings,
            settings.exportAgentOperationSettings(),
            clientContext,
            this.operationsStub);
    this.importAgentCallable =
        GrpcCallableFactory.createUnaryCallable(
            importAgentTransportSettings, settings.importAgentSettings(), clientContext);
    this.importAgentOperationCallable =
        GrpcCallableFactory.createOperationCallable(
            importAgentTransportSettings,
            settings.importAgentOperationSettings(),
            clientContext,
            this.operationsStub);
    this.restoreAgentCallable =
        GrpcCallableFactory.createUnaryCallable(
            restoreAgentTransportSettings, settings.restoreAgentSettings(), clientContext);
    this.restoreAgentOperationCallable =
        GrpcCallableFactory.createOperationCallable(
            restoreAgentTransportSettings,
            settings.restoreAgentOperationSettings(),
            clientContext,
            this.operationsStub);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  public UnaryCallable<GetAgentRequest, Agent> getAgentCallable() {
    return getAgentCallable;
  }

  public UnaryCallable<SearchAgentsRequest, SearchAgentsPagedResponse> searchAgentsPagedCallable() {
    return searchAgentsPagedCallable;
  }

  public UnaryCallable<SearchAgentsRequest, SearchAgentsResponse> searchAgentsCallable() {
    return searchAgentsCallable;
  }

  public OperationCallable<TrainAgentRequest, Empty, Struct> trainAgentOperationCallable() {
    return trainAgentOperationCallable;
  }

  public UnaryCallable<TrainAgentRequest, Operation> trainAgentCallable() {
    return trainAgentCallable;
  }

  public OperationCallable<ExportAgentRequest, ExportAgentResponse, Struct>
      exportAgentOperationCallable() {
    return exportAgentOperationCallable;
  }

  public UnaryCallable<ExportAgentRequest, Operation> exportAgentCallable() {
    return exportAgentCallable;
  }

  public OperationCallable<ImportAgentRequest, Empty, Struct> importAgentOperationCallable() {
    return importAgentOperationCallable;
  }

  public UnaryCallable<ImportAgentRequest, Operation> importAgentCallable() {
    return importAgentCallable;
  }

  public OperationCallable<RestoreAgentRequest, Empty, Struct> restoreAgentOperationCallable() {
    return restoreAgentOperationCallable;
  }

  public UnaryCallable<RestoreAgentRequest, Operation> restoreAgentCallable() {
    return restoreAgentCallable;
  }

  @Override
  public final void close() throws Exception {
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
