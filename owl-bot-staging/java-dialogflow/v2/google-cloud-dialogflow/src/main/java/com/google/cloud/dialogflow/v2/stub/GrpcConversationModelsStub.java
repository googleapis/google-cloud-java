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

package com.google.cloud.dialogflow.v2.stub;

import static com.google.cloud.dialogflow.v2.ConversationModelsClient.ListConversationModelEvaluationsPagedResponse;
import static com.google.cloud.dialogflow.v2.ConversationModelsClient.ListConversationModelsPagedResponse;
import static com.google.cloud.dialogflow.v2.ConversationModelsClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.v2.ConversationModel;
import com.google.cloud.dialogflow.v2.ConversationModelEvaluation;
import com.google.cloud.dialogflow.v2.CreateConversationModelEvaluationOperationMetadata;
import com.google.cloud.dialogflow.v2.CreateConversationModelEvaluationRequest;
import com.google.cloud.dialogflow.v2.CreateConversationModelOperationMetadata;
import com.google.cloud.dialogflow.v2.CreateConversationModelRequest;
import com.google.cloud.dialogflow.v2.DeleteConversationModelOperationMetadata;
import com.google.cloud.dialogflow.v2.DeleteConversationModelRequest;
import com.google.cloud.dialogflow.v2.DeployConversationModelOperationMetadata;
import com.google.cloud.dialogflow.v2.DeployConversationModelRequest;
import com.google.cloud.dialogflow.v2.GetConversationModelEvaluationRequest;
import com.google.cloud.dialogflow.v2.GetConversationModelRequest;
import com.google.cloud.dialogflow.v2.ListConversationModelEvaluationsRequest;
import com.google.cloud.dialogflow.v2.ListConversationModelEvaluationsResponse;
import com.google.cloud.dialogflow.v2.ListConversationModelsRequest;
import com.google.cloud.dialogflow.v2.ListConversationModelsResponse;
import com.google.cloud.dialogflow.v2.UndeployConversationModelOperationMetadata;
import com.google.cloud.dialogflow.v2.UndeployConversationModelRequest;
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
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the ConversationModels service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcConversationModelsStub extends ConversationModelsStub {
  private static final MethodDescriptor<CreateConversationModelRequest, Operation>
      createConversationModelMethodDescriptor =
          MethodDescriptor.<CreateConversationModelRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dialogflow.v2.ConversationModels/CreateConversationModel")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateConversationModelRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetConversationModelRequest, ConversationModel>
      getConversationModelMethodDescriptor =
          MethodDescriptor.<GetConversationModelRequest, ConversationModel>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dialogflow.v2.ConversationModels/GetConversationModel")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetConversationModelRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ConversationModel.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListConversationModelsRequest, ListConversationModelsResponse>
      listConversationModelsMethodDescriptor =
          MethodDescriptor
              .<ListConversationModelsRequest, ListConversationModelsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dialogflow.v2.ConversationModels/ListConversationModels")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListConversationModelsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListConversationModelsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteConversationModelRequest, Operation>
      deleteConversationModelMethodDescriptor =
          MethodDescriptor.<DeleteConversationModelRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dialogflow.v2.ConversationModels/DeleteConversationModel")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteConversationModelRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeployConversationModelRequest, Operation>
      deployConversationModelMethodDescriptor =
          MethodDescriptor.<DeployConversationModelRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dialogflow.v2.ConversationModels/DeployConversationModel")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeployConversationModelRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UndeployConversationModelRequest, Operation>
      undeployConversationModelMethodDescriptor =
          MethodDescriptor.<UndeployConversationModelRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dialogflow.v2.ConversationModels/UndeployConversationModel")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UndeployConversationModelRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          GetConversationModelEvaluationRequest, ConversationModelEvaluation>
      getConversationModelEvaluationMethodDescriptor =
          MethodDescriptor
              .<GetConversationModelEvaluationRequest, ConversationModelEvaluation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dialogflow.v2.ConversationModels/GetConversationModelEvaluation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetConversationModelEvaluationRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ConversationModelEvaluation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListConversationModelEvaluationsRequest, ListConversationModelEvaluationsResponse>
      listConversationModelEvaluationsMethodDescriptor =
          MethodDescriptor
              .<ListConversationModelEvaluationsRequest, ListConversationModelEvaluationsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dialogflow.v2.ConversationModels/ListConversationModelEvaluations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      ListConversationModelEvaluationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      ListConversationModelEvaluationsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateConversationModelEvaluationRequest, Operation>
      createConversationModelEvaluationMethodDescriptor =
          MethodDescriptor.<CreateConversationModelEvaluationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dialogflow.v2.ConversationModels/CreateConversationModelEvaluation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      CreateConversationModelEvaluationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
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

  private final UnaryCallable<CreateConversationModelRequest, Operation>
      createConversationModelCallable;
  private final OperationCallable<
          CreateConversationModelRequest,
          ConversationModel,
          CreateConversationModelOperationMetadata>
      createConversationModelOperationCallable;
  private final UnaryCallable<GetConversationModelRequest, ConversationModel>
      getConversationModelCallable;
  private final UnaryCallable<ListConversationModelsRequest, ListConversationModelsResponse>
      listConversationModelsCallable;
  private final UnaryCallable<ListConversationModelsRequest, ListConversationModelsPagedResponse>
      listConversationModelsPagedCallable;
  private final UnaryCallable<DeleteConversationModelRequest, Operation>
      deleteConversationModelCallable;
  private final OperationCallable<
          DeleteConversationModelRequest, Empty, DeleteConversationModelOperationMetadata>
      deleteConversationModelOperationCallable;
  private final UnaryCallable<DeployConversationModelRequest, Operation>
      deployConversationModelCallable;
  private final OperationCallable<
          DeployConversationModelRequest, Empty, DeployConversationModelOperationMetadata>
      deployConversationModelOperationCallable;
  private final UnaryCallable<UndeployConversationModelRequest, Operation>
      undeployConversationModelCallable;
  private final OperationCallable<
          UndeployConversationModelRequest, Empty, UndeployConversationModelOperationMetadata>
      undeployConversationModelOperationCallable;
  private final UnaryCallable<GetConversationModelEvaluationRequest, ConversationModelEvaluation>
      getConversationModelEvaluationCallable;
  private final UnaryCallable<
          ListConversationModelEvaluationsRequest, ListConversationModelEvaluationsResponse>
      listConversationModelEvaluationsCallable;
  private final UnaryCallable<
          ListConversationModelEvaluationsRequest, ListConversationModelEvaluationsPagedResponse>
      listConversationModelEvaluationsPagedCallable;
  private final UnaryCallable<CreateConversationModelEvaluationRequest, Operation>
      createConversationModelEvaluationCallable;
  private final OperationCallable<
          CreateConversationModelEvaluationRequest,
          ConversationModelEvaluation,
          CreateConversationModelEvaluationOperationMetadata>
      createConversationModelEvaluationOperationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcConversationModelsStub create(ConversationModelsStubSettings settings)
      throws IOException {
    return new GrpcConversationModelsStub(settings, ClientContext.create(settings));
  }

  public static final GrpcConversationModelsStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcConversationModelsStub(
        ConversationModelsStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcConversationModelsStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcConversationModelsStub(
        ConversationModelsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcConversationModelsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcConversationModelsStub(
      ConversationModelsStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcConversationModelsCallableFactory());
  }

  /**
   * Constructs an instance of GrpcConversationModelsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcConversationModelsStub(
      ConversationModelsStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateConversationModelRequest, Operation>
        createConversationModelTransportSettings =
            GrpcCallSettings.<CreateConversationModelRequest, Operation>newBuilder()
                .setMethodDescriptor(createConversationModelMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetConversationModelRequest, ConversationModel>
        getConversationModelTransportSettings =
            GrpcCallSettings.<GetConversationModelRequest, ConversationModel>newBuilder()
                .setMethodDescriptor(getConversationModelMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListConversationModelsRequest, ListConversationModelsResponse>
        listConversationModelsTransportSettings =
            GrpcCallSettings
                .<ListConversationModelsRequest, ListConversationModelsResponse>newBuilder()
                .setMethodDescriptor(listConversationModelsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteConversationModelRequest, Operation>
        deleteConversationModelTransportSettings =
            GrpcCallSettings.<DeleteConversationModelRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteConversationModelMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeployConversationModelRequest, Operation>
        deployConversationModelTransportSettings =
            GrpcCallSettings.<DeployConversationModelRequest, Operation>newBuilder()
                .setMethodDescriptor(deployConversationModelMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UndeployConversationModelRequest, Operation>
        undeployConversationModelTransportSettings =
            GrpcCallSettings.<UndeployConversationModelRequest, Operation>newBuilder()
                .setMethodDescriptor(undeployConversationModelMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetConversationModelEvaluationRequest, ConversationModelEvaluation>
        getConversationModelEvaluationTransportSettings =
            GrpcCallSettings
                .<GetConversationModelEvaluationRequest, ConversationModelEvaluation>newBuilder()
                .setMethodDescriptor(getConversationModelEvaluationMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<
            ListConversationModelEvaluationsRequest, ListConversationModelEvaluationsResponse>
        listConversationModelEvaluationsTransportSettings =
            GrpcCallSettings
                .<ListConversationModelEvaluationsRequest, ListConversationModelEvaluationsResponse>
                    newBuilder()
                .setMethodDescriptor(listConversationModelEvaluationsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<CreateConversationModelEvaluationRequest, Operation>
        createConversationModelEvaluationTransportSettings =
            GrpcCallSettings.<CreateConversationModelEvaluationRequest, Operation>newBuilder()
                .setMethodDescriptor(createConversationModelEvaluationMethodDescriptor)
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

    this.createConversationModelCallable =
        callableFactory.createUnaryCallable(
            createConversationModelTransportSettings,
            settings.createConversationModelSettings(),
            clientContext);
    this.createConversationModelOperationCallable =
        callableFactory.createOperationCallable(
            createConversationModelTransportSettings,
            settings.createConversationModelOperationSettings(),
            clientContext,
            operationsStub);
    this.getConversationModelCallable =
        callableFactory.createUnaryCallable(
            getConversationModelTransportSettings,
            settings.getConversationModelSettings(),
            clientContext);
    this.listConversationModelsCallable =
        callableFactory.createUnaryCallable(
            listConversationModelsTransportSettings,
            settings.listConversationModelsSettings(),
            clientContext);
    this.listConversationModelsPagedCallable =
        callableFactory.createPagedCallable(
            listConversationModelsTransportSettings,
            settings.listConversationModelsSettings(),
            clientContext);
    this.deleteConversationModelCallable =
        callableFactory.createUnaryCallable(
            deleteConversationModelTransportSettings,
            settings.deleteConversationModelSettings(),
            clientContext);
    this.deleteConversationModelOperationCallable =
        callableFactory.createOperationCallable(
            deleteConversationModelTransportSettings,
            settings.deleteConversationModelOperationSettings(),
            clientContext,
            operationsStub);
    this.deployConversationModelCallable =
        callableFactory.createUnaryCallable(
            deployConversationModelTransportSettings,
            settings.deployConversationModelSettings(),
            clientContext);
    this.deployConversationModelOperationCallable =
        callableFactory.createOperationCallable(
            deployConversationModelTransportSettings,
            settings.deployConversationModelOperationSettings(),
            clientContext,
            operationsStub);
    this.undeployConversationModelCallable =
        callableFactory.createUnaryCallable(
            undeployConversationModelTransportSettings,
            settings.undeployConversationModelSettings(),
            clientContext);
    this.undeployConversationModelOperationCallable =
        callableFactory.createOperationCallable(
            undeployConversationModelTransportSettings,
            settings.undeployConversationModelOperationSettings(),
            clientContext,
            operationsStub);
    this.getConversationModelEvaluationCallable =
        callableFactory.createUnaryCallable(
            getConversationModelEvaluationTransportSettings,
            settings.getConversationModelEvaluationSettings(),
            clientContext);
    this.listConversationModelEvaluationsCallable =
        callableFactory.createUnaryCallable(
            listConversationModelEvaluationsTransportSettings,
            settings.listConversationModelEvaluationsSettings(),
            clientContext);
    this.listConversationModelEvaluationsPagedCallable =
        callableFactory.createPagedCallable(
            listConversationModelEvaluationsTransportSettings,
            settings.listConversationModelEvaluationsSettings(),
            clientContext);
    this.createConversationModelEvaluationCallable =
        callableFactory.createUnaryCallable(
            createConversationModelEvaluationTransportSettings,
            settings.createConversationModelEvaluationSettings(),
            clientContext);
    this.createConversationModelEvaluationOperationCallable =
        callableFactory.createOperationCallable(
            createConversationModelEvaluationTransportSettings,
            settings.createConversationModelEvaluationOperationSettings(),
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

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateConversationModelRequest, Operation>
      createConversationModelCallable() {
    return createConversationModelCallable;
  }

  @Override
  public OperationCallable<
          CreateConversationModelRequest,
          ConversationModel,
          CreateConversationModelOperationMetadata>
      createConversationModelOperationCallable() {
    return createConversationModelOperationCallable;
  }

  @Override
  public UnaryCallable<GetConversationModelRequest, ConversationModel>
      getConversationModelCallable() {
    return getConversationModelCallable;
  }

  @Override
  public UnaryCallable<ListConversationModelsRequest, ListConversationModelsResponse>
      listConversationModelsCallable() {
    return listConversationModelsCallable;
  }

  @Override
  public UnaryCallable<ListConversationModelsRequest, ListConversationModelsPagedResponse>
      listConversationModelsPagedCallable() {
    return listConversationModelsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteConversationModelRequest, Operation>
      deleteConversationModelCallable() {
    return deleteConversationModelCallable;
  }

  @Override
  public OperationCallable<
          DeleteConversationModelRequest, Empty, DeleteConversationModelOperationMetadata>
      deleteConversationModelOperationCallable() {
    return deleteConversationModelOperationCallable;
  }

  @Override
  public UnaryCallable<DeployConversationModelRequest, Operation>
      deployConversationModelCallable() {
    return deployConversationModelCallable;
  }

  @Override
  public OperationCallable<
          DeployConversationModelRequest, Empty, DeployConversationModelOperationMetadata>
      deployConversationModelOperationCallable() {
    return deployConversationModelOperationCallable;
  }

  @Override
  public UnaryCallable<UndeployConversationModelRequest, Operation>
      undeployConversationModelCallable() {
    return undeployConversationModelCallable;
  }

  @Override
  public OperationCallable<
          UndeployConversationModelRequest, Empty, UndeployConversationModelOperationMetadata>
      undeployConversationModelOperationCallable() {
    return undeployConversationModelOperationCallable;
  }

  @Override
  public UnaryCallable<GetConversationModelEvaluationRequest, ConversationModelEvaluation>
      getConversationModelEvaluationCallable() {
    return getConversationModelEvaluationCallable;
  }

  @Override
  public UnaryCallable<
          ListConversationModelEvaluationsRequest, ListConversationModelEvaluationsResponse>
      listConversationModelEvaluationsCallable() {
    return listConversationModelEvaluationsCallable;
  }

  @Override
  public UnaryCallable<
          ListConversationModelEvaluationsRequest, ListConversationModelEvaluationsPagedResponse>
      listConversationModelEvaluationsPagedCallable() {
    return listConversationModelEvaluationsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateConversationModelEvaluationRequest, Operation>
      createConversationModelEvaluationCallable() {
    return createConversationModelEvaluationCallable;
  }

  @Override
  public OperationCallable<
          CreateConversationModelEvaluationRequest,
          ConversationModelEvaluation,
          CreateConversationModelEvaluationOperationMetadata>
      createConversationModelEvaluationOperationCallable() {
    return createConversationModelEvaluationOperationCallable;
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
