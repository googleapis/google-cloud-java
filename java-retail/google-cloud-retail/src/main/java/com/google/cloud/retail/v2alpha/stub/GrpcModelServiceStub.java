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

package com.google.cloud.retail.v2alpha.stub;

import static com.google.cloud.retail.v2alpha.ModelServiceClient.ListModelsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.retail.v2alpha.CreateModelMetadata;
import com.google.cloud.retail.v2alpha.CreateModelRequest;
import com.google.cloud.retail.v2alpha.DeleteModelRequest;
import com.google.cloud.retail.v2alpha.ListModelsRequest;
import com.google.cloud.retail.v2alpha.ListModelsResponse;
import com.google.cloud.retail.v2alpha.Model;
import com.google.cloud.retail.v2alpha.PauseModelRequest;
import com.google.cloud.retail.v2alpha.ResumeModelRequest;
import com.google.cloud.retail.v2alpha.TuneModelMetadata;
import com.google.cloud.retail.v2alpha.TuneModelRequest;
import com.google.cloud.retail.v2alpha.TuneModelResponse;
import com.google.cloud.retail.v2alpha.UpdateModelRequest;
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
 * gRPC stub implementation for the ModelService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcModelServiceStub extends ModelServiceStub {
  private static final MethodDescriptor<CreateModelRequest, Operation> createModelMethodDescriptor =
      MethodDescriptor.<CreateModelRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.retail.v2alpha.ModelService/CreateModel")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateModelRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<PauseModelRequest, Model> pauseModelMethodDescriptor =
      MethodDescriptor.<PauseModelRequest, Model>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.retail.v2alpha.ModelService/PauseModel")
          .setRequestMarshaller(ProtoUtils.marshaller(PauseModelRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Model.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ResumeModelRequest, Model> resumeModelMethodDescriptor =
      MethodDescriptor.<ResumeModelRequest, Model>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.retail.v2alpha.ModelService/ResumeModel")
          .setRequestMarshaller(ProtoUtils.marshaller(ResumeModelRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Model.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteModelRequest, Empty> deleteModelMethodDescriptor =
      MethodDescriptor.<DeleteModelRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.retail.v2alpha.ModelService/DeleteModel")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteModelRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListModelsRequest, ListModelsResponse>
      listModelsMethodDescriptor =
          MethodDescriptor.<ListModelsRequest, ListModelsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.retail.v2alpha.ModelService/ListModels")
              .setRequestMarshaller(ProtoUtils.marshaller(ListModelsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListModelsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateModelRequest, Model> updateModelMethodDescriptor =
      MethodDescriptor.<UpdateModelRequest, Model>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.retail.v2alpha.ModelService/UpdateModel")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateModelRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Model.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<TuneModelRequest, Operation> tuneModelMethodDescriptor =
      MethodDescriptor.<TuneModelRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.retail.v2alpha.ModelService/TuneModel")
          .setRequestMarshaller(ProtoUtils.marshaller(TuneModelRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private final UnaryCallable<CreateModelRequest, Operation> createModelCallable;
  private final OperationCallable<CreateModelRequest, Model, CreateModelMetadata>
      createModelOperationCallable;
  private final UnaryCallable<PauseModelRequest, Model> pauseModelCallable;
  private final UnaryCallable<ResumeModelRequest, Model> resumeModelCallable;
  private final UnaryCallable<DeleteModelRequest, Empty> deleteModelCallable;
  private final UnaryCallable<ListModelsRequest, ListModelsResponse> listModelsCallable;
  private final UnaryCallable<ListModelsRequest, ListModelsPagedResponse> listModelsPagedCallable;
  private final UnaryCallable<UpdateModelRequest, Model> updateModelCallable;
  private final UnaryCallable<TuneModelRequest, Operation> tuneModelCallable;
  private final OperationCallable<TuneModelRequest, TuneModelResponse, TuneModelMetadata>
      tuneModelOperationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcModelServiceStub create(ModelServiceStubSettings settings)
      throws IOException {
    return new GrpcModelServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcModelServiceStub create(ClientContext clientContext) throws IOException {
    return new GrpcModelServiceStub(ModelServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcModelServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcModelServiceStub(
        ModelServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcModelServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcModelServiceStub(ModelServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcModelServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcModelServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcModelServiceStub(
      ModelServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateModelRequest, Operation> createModelTransportSettings =
        GrpcCallSettings.<CreateModelRequest, Operation>newBuilder()
            .setMethodDescriptor(createModelMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<PauseModelRequest, Model> pauseModelTransportSettings =
        GrpcCallSettings.<PauseModelRequest, Model>newBuilder()
            .setMethodDescriptor(pauseModelMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ResumeModelRequest, Model> resumeModelTransportSettings =
        GrpcCallSettings.<ResumeModelRequest, Model>newBuilder()
            .setMethodDescriptor(resumeModelMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteModelRequest, Empty> deleteModelTransportSettings =
        GrpcCallSettings.<DeleteModelRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteModelMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListModelsRequest, ListModelsResponse> listModelsTransportSettings =
        GrpcCallSettings.<ListModelsRequest, ListModelsResponse>newBuilder()
            .setMethodDescriptor(listModelsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateModelRequest, Model> updateModelTransportSettings =
        GrpcCallSettings.<UpdateModelRequest, Model>newBuilder()
            .setMethodDescriptor(updateModelMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("model.name", String.valueOf(request.getModel().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<TuneModelRequest, Operation> tuneModelTransportSettings =
        GrpcCallSettings.<TuneModelRequest, Operation>newBuilder()
            .setMethodDescriptor(tuneModelMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();

    this.createModelCallable =
        callableFactory.createUnaryCallable(
            createModelTransportSettings, settings.createModelSettings(), clientContext);
    this.createModelOperationCallable =
        callableFactory.createOperationCallable(
            createModelTransportSettings,
            settings.createModelOperationSettings(),
            clientContext,
            operationsStub);
    this.pauseModelCallable =
        callableFactory.createUnaryCallable(
            pauseModelTransportSettings, settings.pauseModelSettings(), clientContext);
    this.resumeModelCallable =
        callableFactory.createUnaryCallable(
            resumeModelTransportSettings, settings.resumeModelSettings(), clientContext);
    this.deleteModelCallable =
        callableFactory.createUnaryCallable(
            deleteModelTransportSettings, settings.deleteModelSettings(), clientContext);
    this.listModelsCallable =
        callableFactory.createUnaryCallable(
            listModelsTransportSettings, settings.listModelsSettings(), clientContext);
    this.listModelsPagedCallable =
        callableFactory.createPagedCallable(
            listModelsTransportSettings, settings.listModelsSettings(), clientContext);
    this.updateModelCallable =
        callableFactory.createUnaryCallable(
            updateModelTransportSettings, settings.updateModelSettings(), clientContext);
    this.tuneModelCallable =
        callableFactory.createUnaryCallable(
            tuneModelTransportSettings, settings.tuneModelSettings(), clientContext);
    this.tuneModelOperationCallable =
        callableFactory.createOperationCallable(
            tuneModelTransportSettings,
            settings.tuneModelOperationSettings(),
            clientContext,
            operationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateModelRequest, Operation> createModelCallable() {
    return createModelCallable;
  }

  @Override
  public OperationCallable<CreateModelRequest, Model, CreateModelMetadata>
      createModelOperationCallable() {
    return createModelOperationCallable;
  }

  @Override
  public UnaryCallable<PauseModelRequest, Model> pauseModelCallable() {
    return pauseModelCallable;
  }

  @Override
  public UnaryCallable<ResumeModelRequest, Model> resumeModelCallable() {
    return resumeModelCallable;
  }

  @Override
  public UnaryCallable<DeleteModelRequest, Empty> deleteModelCallable() {
    return deleteModelCallable;
  }

  @Override
  public UnaryCallable<ListModelsRequest, ListModelsResponse> listModelsCallable() {
    return listModelsCallable;
  }

  @Override
  public UnaryCallable<ListModelsRequest, ListModelsPagedResponse> listModelsPagedCallable() {
    return listModelsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateModelRequest, Model> updateModelCallable() {
    return updateModelCallable;
  }

  @Override
  public UnaryCallable<TuneModelRequest, Operation> tuneModelCallable() {
    return tuneModelCallable;
  }

  @Override
  public OperationCallable<TuneModelRequest, TuneModelResponse, TuneModelMetadata>
      tuneModelOperationCallable() {
    return tuneModelOperationCallable;
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
