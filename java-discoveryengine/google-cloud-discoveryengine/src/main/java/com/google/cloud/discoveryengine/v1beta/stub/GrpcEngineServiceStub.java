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

package com.google.cloud.discoveryengine.v1beta.stub;

import static com.google.cloud.discoveryengine.v1beta.EngineServiceClient.ListEnginesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1beta.CreateEngineMetadata;
import com.google.cloud.discoveryengine.v1beta.CreateEngineRequest;
import com.google.cloud.discoveryengine.v1beta.DeleteEngineMetadata;
import com.google.cloud.discoveryengine.v1beta.DeleteEngineRequest;
import com.google.cloud.discoveryengine.v1beta.Engine;
import com.google.cloud.discoveryengine.v1beta.GetEngineRequest;
import com.google.cloud.discoveryengine.v1beta.ListEnginesRequest;
import com.google.cloud.discoveryengine.v1beta.ListEnginesResponse;
import com.google.cloud.discoveryengine.v1beta.PauseEngineRequest;
import com.google.cloud.discoveryengine.v1beta.ResumeEngineRequest;
import com.google.cloud.discoveryengine.v1beta.TuneEngineMetadata;
import com.google.cloud.discoveryengine.v1beta.TuneEngineRequest;
import com.google.cloud.discoveryengine.v1beta.TuneEngineResponse;
import com.google.cloud.discoveryengine.v1beta.UpdateEngineRequest;
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
 * gRPC stub implementation for the EngineService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcEngineServiceStub extends EngineServiceStub {
  private static final MethodDescriptor<CreateEngineRequest, Operation>
      createEngineMethodDescriptor =
          MethodDescriptor.<CreateEngineRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.discoveryengine.v1beta.EngineService/CreateEngine")
              .setRequestMarshaller(ProtoUtils.marshaller(CreateEngineRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteEngineRequest, Operation>
      deleteEngineMethodDescriptor =
          MethodDescriptor.<DeleteEngineRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.discoveryengine.v1beta.EngineService/DeleteEngine")
              .setRequestMarshaller(ProtoUtils.marshaller(DeleteEngineRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateEngineRequest, Engine> updateEngineMethodDescriptor =
      MethodDescriptor.<UpdateEngineRequest, Engine>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.discoveryengine.v1beta.EngineService/UpdateEngine")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateEngineRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Engine.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetEngineRequest, Engine> getEngineMethodDescriptor =
      MethodDescriptor.<GetEngineRequest, Engine>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.discoveryengine.v1beta.EngineService/GetEngine")
          .setRequestMarshaller(ProtoUtils.marshaller(GetEngineRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Engine.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListEnginesRequest, ListEnginesResponse>
      listEnginesMethodDescriptor =
          MethodDescriptor.<ListEnginesRequest, ListEnginesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.discoveryengine.v1beta.EngineService/ListEngines")
              .setRequestMarshaller(ProtoUtils.marshaller(ListEnginesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListEnginesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<PauseEngineRequest, Engine> pauseEngineMethodDescriptor =
      MethodDescriptor.<PauseEngineRequest, Engine>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.discoveryengine.v1beta.EngineService/PauseEngine")
          .setRequestMarshaller(ProtoUtils.marshaller(PauseEngineRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Engine.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ResumeEngineRequest, Engine> resumeEngineMethodDescriptor =
      MethodDescriptor.<ResumeEngineRequest, Engine>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.discoveryengine.v1beta.EngineService/ResumeEngine")
          .setRequestMarshaller(ProtoUtils.marshaller(ResumeEngineRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Engine.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<TuneEngineRequest, Operation> tuneEngineMethodDescriptor =
      MethodDescriptor.<TuneEngineRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.discoveryengine.v1beta.EngineService/TuneEngine")
          .setRequestMarshaller(ProtoUtils.marshaller(TuneEngineRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private final UnaryCallable<CreateEngineRequest, Operation> createEngineCallable;
  private final OperationCallable<CreateEngineRequest, Engine, CreateEngineMetadata>
      createEngineOperationCallable;
  private final UnaryCallable<DeleteEngineRequest, Operation> deleteEngineCallable;
  private final OperationCallable<DeleteEngineRequest, Empty, DeleteEngineMetadata>
      deleteEngineOperationCallable;
  private final UnaryCallable<UpdateEngineRequest, Engine> updateEngineCallable;
  private final UnaryCallable<GetEngineRequest, Engine> getEngineCallable;
  private final UnaryCallable<ListEnginesRequest, ListEnginesResponse> listEnginesCallable;
  private final UnaryCallable<ListEnginesRequest, ListEnginesPagedResponse>
      listEnginesPagedCallable;
  private final UnaryCallable<PauseEngineRequest, Engine> pauseEngineCallable;
  private final UnaryCallable<ResumeEngineRequest, Engine> resumeEngineCallable;
  private final UnaryCallable<TuneEngineRequest, Operation> tuneEngineCallable;
  private final OperationCallable<TuneEngineRequest, TuneEngineResponse, TuneEngineMetadata>
      tuneEngineOperationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcEngineServiceStub create(EngineServiceStubSettings settings)
      throws IOException {
    return new GrpcEngineServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcEngineServiceStub create(ClientContext clientContext) throws IOException {
    return new GrpcEngineServiceStub(EngineServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcEngineServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcEngineServiceStub(
        EngineServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcEngineServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcEngineServiceStub(EngineServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcEngineServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcEngineServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcEngineServiceStub(
      EngineServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateEngineRequest, Operation> createEngineTransportSettings =
        GrpcCallSettings.<CreateEngineRequest, Operation>newBuilder()
            .setMethodDescriptor(createEngineMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteEngineRequest, Operation> deleteEngineTransportSettings =
        GrpcCallSettings.<DeleteEngineRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteEngineMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateEngineRequest, Engine> updateEngineTransportSettings =
        GrpcCallSettings.<UpdateEngineRequest, Engine>newBuilder()
            .setMethodDescriptor(updateEngineMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("engine.name", String.valueOf(request.getEngine().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetEngineRequest, Engine> getEngineTransportSettings =
        GrpcCallSettings.<GetEngineRequest, Engine>newBuilder()
            .setMethodDescriptor(getEngineMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListEnginesRequest, ListEnginesResponse> listEnginesTransportSettings =
        GrpcCallSettings.<ListEnginesRequest, ListEnginesResponse>newBuilder()
            .setMethodDescriptor(listEnginesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<PauseEngineRequest, Engine> pauseEngineTransportSettings =
        GrpcCallSettings.<PauseEngineRequest, Engine>newBuilder()
            .setMethodDescriptor(pauseEngineMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ResumeEngineRequest, Engine> resumeEngineTransportSettings =
        GrpcCallSettings.<ResumeEngineRequest, Engine>newBuilder()
            .setMethodDescriptor(resumeEngineMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<TuneEngineRequest, Operation> tuneEngineTransportSettings =
        GrpcCallSettings.<TuneEngineRequest, Operation>newBuilder()
            .setMethodDescriptor(tuneEngineMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.createEngineCallable =
        callableFactory.createUnaryCallable(
            createEngineTransportSettings, settings.createEngineSettings(), clientContext);
    this.createEngineOperationCallable =
        callableFactory.createOperationCallable(
            createEngineTransportSettings,
            settings.createEngineOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteEngineCallable =
        callableFactory.createUnaryCallable(
            deleteEngineTransportSettings, settings.deleteEngineSettings(), clientContext);
    this.deleteEngineOperationCallable =
        callableFactory.createOperationCallable(
            deleteEngineTransportSettings,
            settings.deleteEngineOperationSettings(),
            clientContext,
            operationsStub);
    this.updateEngineCallable =
        callableFactory.createUnaryCallable(
            updateEngineTransportSettings, settings.updateEngineSettings(), clientContext);
    this.getEngineCallable =
        callableFactory.createUnaryCallable(
            getEngineTransportSettings, settings.getEngineSettings(), clientContext);
    this.listEnginesCallable =
        callableFactory.createUnaryCallable(
            listEnginesTransportSettings, settings.listEnginesSettings(), clientContext);
    this.listEnginesPagedCallable =
        callableFactory.createPagedCallable(
            listEnginesTransportSettings, settings.listEnginesSettings(), clientContext);
    this.pauseEngineCallable =
        callableFactory.createUnaryCallable(
            pauseEngineTransportSettings, settings.pauseEngineSettings(), clientContext);
    this.resumeEngineCallable =
        callableFactory.createUnaryCallable(
            resumeEngineTransportSettings, settings.resumeEngineSettings(), clientContext);
    this.tuneEngineCallable =
        callableFactory.createUnaryCallable(
            tuneEngineTransportSettings, settings.tuneEngineSettings(), clientContext);
    this.tuneEngineOperationCallable =
        callableFactory.createOperationCallable(
            tuneEngineTransportSettings,
            settings.tuneEngineOperationSettings(),
            clientContext,
            operationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateEngineRequest, Operation> createEngineCallable() {
    return createEngineCallable;
  }

  @Override
  public OperationCallable<CreateEngineRequest, Engine, CreateEngineMetadata>
      createEngineOperationCallable() {
    return createEngineOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteEngineRequest, Operation> deleteEngineCallable() {
    return deleteEngineCallable;
  }

  @Override
  public OperationCallable<DeleteEngineRequest, Empty, DeleteEngineMetadata>
      deleteEngineOperationCallable() {
    return deleteEngineOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateEngineRequest, Engine> updateEngineCallable() {
    return updateEngineCallable;
  }

  @Override
  public UnaryCallable<GetEngineRequest, Engine> getEngineCallable() {
    return getEngineCallable;
  }

  @Override
  public UnaryCallable<ListEnginesRequest, ListEnginesResponse> listEnginesCallable() {
    return listEnginesCallable;
  }

  @Override
  public UnaryCallable<ListEnginesRequest, ListEnginesPagedResponse> listEnginesPagedCallable() {
    return listEnginesPagedCallable;
  }

  @Override
  public UnaryCallable<PauseEngineRequest, Engine> pauseEngineCallable() {
    return pauseEngineCallable;
  }

  @Override
  public UnaryCallable<ResumeEngineRequest, Engine> resumeEngineCallable() {
    return resumeEngineCallable;
  }

  @Override
  public UnaryCallable<TuneEngineRequest, Operation> tuneEngineCallable() {
    return tuneEngineCallable;
  }

  @Override
  public OperationCallable<TuneEngineRequest, TuneEngineResponse, TuneEngineMetadata>
      tuneEngineOperationCallable() {
    return tuneEngineOperationCallable;
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
