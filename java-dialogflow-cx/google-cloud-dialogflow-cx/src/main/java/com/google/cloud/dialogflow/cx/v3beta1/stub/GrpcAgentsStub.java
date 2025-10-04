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

package com.google.cloud.dialogflow.cx.v3beta1.stub;

import static com.google.cloud.dialogflow.cx.v3beta1.AgentsClient.ListAgentsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3beta1.AgentsClient.ListLocationsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.cx.v3beta1.Agent;
import com.google.cloud.dialogflow.cx.v3beta1.AgentValidationResult;
import com.google.cloud.dialogflow.cx.v3beta1.CreateAgentRequest;
import com.google.cloud.dialogflow.cx.v3beta1.DeleteAgentRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ExportAgentRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ExportAgentResponse;
import com.google.cloud.dialogflow.cx.v3beta1.GenerativeSettings;
import com.google.cloud.dialogflow.cx.v3beta1.GetAgentRequest;
import com.google.cloud.dialogflow.cx.v3beta1.GetAgentValidationResultRequest;
import com.google.cloud.dialogflow.cx.v3beta1.GetGenerativeSettingsRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ListAgentsRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ListAgentsResponse;
import com.google.cloud.dialogflow.cx.v3beta1.RestoreAgentRequest;
import com.google.cloud.dialogflow.cx.v3beta1.UpdateAgentRequest;
import com.google.cloud.dialogflow.cx.v3beta1.UpdateGenerativeSettingsRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ValidateAgentRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import com.google.protobuf.Struct;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the Agents service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcAgentsStub extends AgentsStub {
  private static final MethodDescriptor<ListAgentsRequest, ListAgentsResponse>
      listAgentsMethodDescriptor =
          MethodDescriptor.<ListAgentsRequest, ListAgentsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Agents/ListAgents")
              .setRequestMarshaller(ProtoUtils.marshaller(ListAgentsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListAgentsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetAgentRequest, Agent> getAgentMethodDescriptor =
      MethodDescriptor.<GetAgentRequest, Agent>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Agents/GetAgent")
          .setRequestMarshaller(ProtoUtils.marshaller(GetAgentRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Agent.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<CreateAgentRequest, Agent> createAgentMethodDescriptor =
      MethodDescriptor.<CreateAgentRequest, Agent>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Agents/CreateAgent")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateAgentRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Agent.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<UpdateAgentRequest, Agent> updateAgentMethodDescriptor =
      MethodDescriptor.<UpdateAgentRequest, Agent>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Agents/UpdateAgent")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateAgentRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Agent.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<DeleteAgentRequest, Empty> deleteAgentMethodDescriptor =
      MethodDescriptor.<DeleteAgentRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Agents/DeleteAgent")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteAgentRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ExportAgentRequest, Operation> exportAgentMethodDescriptor =
      MethodDescriptor.<ExportAgentRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Agents/ExportAgent")
          .setRequestMarshaller(ProtoUtils.marshaller(ExportAgentRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<RestoreAgentRequest, Operation>
      restoreAgentMethodDescriptor =
          MethodDescriptor.<RestoreAgentRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Agents/RestoreAgent")
              .setRequestMarshaller(ProtoUtils.marshaller(RestoreAgentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ValidateAgentRequest, AgentValidationResult>
      validateAgentMethodDescriptor =
          MethodDescriptor.<ValidateAgentRequest, AgentValidationResult>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Agents/ValidateAgent")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ValidateAgentRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(AgentValidationResult.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetAgentValidationResultRequest, AgentValidationResult>
      getAgentValidationResultMethodDescriptor =
          MethodDescriptor.<GetAgentValidationResultRequest, AgentValidationResult>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dialogflow.cx.v3beta1.Agents/GetAgentValidationResult")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAgentValidationResultRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(AgentValidationResult.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetGenerativeSettingsRequest, GenerativeSettings>
      getGenerativeSettingsMethodDescriptor =
          MethodDescriptor.<GetGenerativeSettingsRequest, GenerativeSettings>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Agents/GetGenerativeSettings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetGenerativeSettingsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(GenerativeSettings.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateGenerativeSettingsRequest, GenerativeSettings>
      updateGenerativeSettingsMethodDescriptor =
          MethodDescriptor.<UpdateGenerativeSettingsRequest, GenerativeSettings>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dialogflow.cx.v3beta1.Agents/UpdateGenerativeSettings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateGenerativeSettingsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(GenerativeSettings.getDefaultInstance()))
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

  private final UnaryCallable<ListAgentsRequest, ListAgentsResponse> listAgentsCallable;
  private final UnaryCallable<ListAgentsRequest, ListAgentsPagedResponse> listAgentsPagedCallable;
  private final UnaryCallable<GetAgentRequest, Agent> getAgentCallable;
  private final UnaryCallable<CreateAgentRequest, Agent> createAgentCallable;
  private final UnaryCallable<UpdateAgentRequest, Agent> updateAgentCallable;
  private final UnaryCallable<DeleteAgentRequest, Empty> deleteAgentCallable;
  private final UnaryCallable<ExportAgentRequest, Operation> exportAgentCallable;
  private final OperationCallable<ExportAgentRequest, ExportAgentResponse, Struct>
      exportAgentOperationCallable;
  private final UnaryCallable<RestoreAgentRequest, Operation> restoreAgentCallable;
  private final OperationCallable<RestoreAgentRequest, Empty, Struct> restoreAgentOperationCallable;
  private final UnaryCallable<ValidateAgentRequest, AgentValidationResult> validateAgentCallable;
  private final UnaryCallable<GetAgentValidationResultRequest, AgentValidationResult>
      getAgentValidationResultCallable;
  private final UnaryCallable<GetGenerativeSettingsRequest, GenerativeSettings>
      getGenerativeSettingsCallable;
  private final UnaryCallable<UpdateGenerativeSettingsRequest, GenerativeSettings>
      updateGenerativeSettingsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcAgentsStub create(AgentsStubSettings settings) throws IOException {
    return new GrpcAgentsStub(settings, ClientContext.create(settings));
  }

  public static final GrpcAgentsStub create(ClientContext clientContext) throws IOException {
    return new GrpcAgentsStub(AgentsStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcAgentsStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcAgentsStub(
        AgentsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcAgentsStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcAgentsStub(AgentsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcAgentsCallableFactory());
  }

  /**
   * Constructs an instance of GrpcAgentsStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcAgentsStub(
      AgentsStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListAgentsRequest, ListAgentsResponse> listAgentsTransportSettings =
        GrpcCallSettings.<ListAgentsRequest, ListAgentsResponse>newBuilder()
            .setMethodDescriptor(listAgentsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetAgentRequest, Agent> getAgentTransportSettings =
        GrpcCallSettings.<GetAgentRequest, Agent>newBuilder()
            .setMethodDescriptor(getAgentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateAgentRequest, Agent> createAgentTransportSettings =
        GrpcCallSettings.<CreateAgentRequest, Agent>newBuilder()
            .setMethodDescriptor(createAgentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateAgentRequest, Agent> updateAgentTransportSettings =
        GrpcCallSettings.<UpdateAgentRequest, Agent>newBuilder()
            .setMethodDescriptor(updateAgentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("agent.name", String.valueOf(request.getAgent().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteAgentRequest, Empty> deleteAgentTransportSettings =
        GrpcCallSettings.<DeleteAgentRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteAgentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ExportAgentRequest, Operation> exportAgentTransportSettings =
        GrpcCallSettings.<ExportAgentRequest, Operation>newBuilder()
            .setMethodDescriptor(exportAgentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<RestoreAgentRequest, Operation> restoreAgentTransportSettings =
        GrpcCallSettings.<RestoreAgentRequest, Operation>newBuilder()
            .setMethodDescriptor(restoreAgentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ValidateAgentRequest, AgentValidationResult> validateAgentTransportSettings =
        GrpcCallSettings.<ValidateAgentRequest, AgentValidationResult>newBuilder()
            .setMethodDescriptor(validateAgentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetAgentValidationResultRequest, AgentValidationResult>
        getAgentValidationResultTransportSettings =
            GrpcCallSettings.<GetAgentValidationResultRequest, AgentValidationResult>newBuilder()
                .setMethodDescriptor(getAgentValidationResultMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetGenerativeSettingsRequest, GenerativeSettings>
        getGenerativeSettingsTransportSettings =
            GrpcCallSettings.<GetGenerativeSettingsRequest, GenerativeSettings>newBuilder()
                .setMethodDescriptor(getGenerativeSettingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateGenerativeSettingsRequest, GenerativeSettings>
        updateGenerativeSettingsTransportSettings =
            GrpcCallSettings.<UpdateGenerativeSettingsRequest, GenerativeSettings>newBuilder()
                .setMethodDescriptor(updateGenerativeSettingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "generative_settings.name",
                          String.valueOf(request.getGenerativeSettings().getName()));
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

    this.listAgentsCallable =
        callableFactory.createUnaryCallable(
            listAgentsTransportSettings, settings.listAgentsSettings(), clientContext);
    this.listAgentsPagedCallable =
        callableFactory.createPagedCallable(
            listAgentsTransportSettings, settings.listAgentsSettings(), clientContext);
    this.getAgentCallable =
        callableFactory.createUnaryCallable(
            getAgentTransportSettings, settings.getAgentSettings(), clientContext);
    this.createAgentCallable =
        callableFactory.createUnaryCallable(
            createAgentTransportSettings, settings.createAgentSettings(), clientContext);
    this.updateAgentCallable =
        callableFactory.createUnaryCallable(
            updateAgentTransportSettings, settings.updateAgentSettings(), clientContext);
    this.deleteAgentCallable =
        callableFactory.createUnaryCallable(
            deleteAgentTransportSettings, settings.deleteAgentSettings(), clientContext);
    this.exportAgentCallable =
        callableFactory.createUnaryCallable(
            exportAgentTransportSettings, settings.exportAgentSettings(), clientContext);
    this.exportAgentOperationCallable =
        callableFactory.createOperationCallable(
            exportAgentTransportSettings,
            settings.exportAgentOperationSettings(),
            clientContext,
            operationsStub);
    this.restoreAgentCallable =
        callableFactory.createUnaryCallable(
            restoreAgentTransportSettings, settings.restoreAgentSettings(), clientContext);
    this.restoreAgentOperationCallable =
        callableFactory.createOperationCallable(
            restoreAgentTransportSettings,
            settings.restoreAgentOperationSettings(),
            clientContext,
            operationsStub);
    this.validateAgentCallable =
        callableFactory.createUnaryCallable(
            validateAgentTransportSettings, settings.validateAgentSettings(), clientContext);
    this.getAgentValidationResultCallable =
        callableFactory.createUnaryCallable(
            getAgentValidationResultTransportSettings,
            settings.getAgentValidationResultSettings(),
            clientContext);
    this.getGenerativeSettingsCallable =
        callableFactory.createUnaryCallable(
            getGenerativeSettingsTransportSettings,
            settings.getGenerativeSettingsSettings(),
            clientContext);
    this.updateGenerativeSettingsCallable =
        callableFactory.createUnaryCallable(
            updateGenerativeSettingsTransportSettings,
            settings.updateGenerativeSettingsSettings(),
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
  public UnaryCallable<ListAgentsRequest, ListAgentsResponse> listAgentsCallable() {
    return listAgentsCallable;
  }

  @Override
  public UnaryCallable<ListAgentsRequest, ListAgentsPagedResponse> listAgentsPagedCallable() {
    return listAgentsPagedCallable;
  }

  @Override
  public UnaryCallable<GetAgentRequest, Agent> getAgentCallable() {
    return getAgentCallable;
  }

  @Override
  public UnaryCallable<CreateAgentRequest, Agent> createAgentCallable() {
    return createAgentCallable;
  }

  @Override
  public UnaryCallable<UpdateAgentRequest, Agent> updateAgentCallable() {
    return updateAgentCallable;
  }

  @Override
  public UnaryCallable<DeleteAgentRequest, Empty> deleteAgentCallable() {
    return deleteAgentCallable;
  }

  @Override
  public UnaryCallable<ExportAgentRequest, Operation> exportAgentCallable() {
    return exportAgentCallable;
  }

  @Override
  public OperationCallable<ExportAgentRequest, ExportAgentResponse, Struct>
      exportAgentOperationCallable() {
    return exportAgentOperationCallable;
  }

  @Override
  public UnaryCallable<RestoreAgentRequest, Operation> restoreAgentCallable() {
    return restoreAgentCallable;
  }

  @Override
  public OperationCallable<RestoreAgentRequest, Empty, Struct> restoreAgentOperationCallable() {
    return restoreAgentOperationCallable;
  }

  @Override
  public UnaryCallable<ValidateAgentRequest, AgentValidationResult> validateAgentCallable() {
    return validateAgentCallable;
  }

  @Override
  public UnaryCallable<GetAgentValidationResultRequest, AgentValidationResult>
      getAgentValidationResultCallable() {
    return getAgentValidationResultCallable;
  }

  @Override
  public UnaryCallable<GetGenerativeSettingsRequest, GenerativeSettings>
      getGenerativeSettingsCallable() {
    return getGenerativeSettingsCallable;
  }

  @Override
  public UnaryCallable<UpdateGenerativeSettingsRequest, GenerativeSettings>
      updateGenerativeSettingsCallable() {
    return updateGenerativeSettingsCallable;
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
