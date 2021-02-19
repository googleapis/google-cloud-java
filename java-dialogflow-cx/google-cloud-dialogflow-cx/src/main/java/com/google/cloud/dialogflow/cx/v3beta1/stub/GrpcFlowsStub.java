/*
 * Copyright 2020 Google LLC
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

import static com.google.cloud.dialogflow.cx.v3beta1.FlowsClient.ListFlowsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.cx.v3beta1.CreateFlowRequest;
import com.google.cloud.dialogflow.cx.v3beta1.DeleteFlowRequest;
import com.google.cloud.dialogflow.cx.v3beta1.Flow;
import com.google.cloud.dialogflow.cx.v3beta1.FlowValidationResult;
import com.google.cloud.dialogflow.cx.v3beta1.GetFlowRequest;
import com.google.cloud.dialogflow.cx.v3beta1.GetFlowValidationResultRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ListFlowsRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ListFlowsResponse;
import com.google.cloud.dialogflow.cx.v3beta1.TrainFlowRequest;
import com.google.cloud.dialogflow.cx.v3beta1.UpdateFlowRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ValidateFlowRequest;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import com.google.protobuf.Struct;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the Flows service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcFlowsStub extends FlowsStub {
  private static final MethodDescriptor<CreateFlowRequest, Flow> createFlowMethodDescriptor =
      MethodDescriptor.<CreateFlowRequest, Flow>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Flows/CreateFlow")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateFlowRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Flow.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteFlowRequest, Empty> deleteFlowMethodDescriptor =
      MethodDescriptor.<DeleteFlowRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Flows/DeleteFlow")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteFlowRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListFlowsRequest, ListFlowsResponse>
      listFlowsMethodDescriptor =
          MethodDescriptor.<ListFlowsRequest, ListFlowsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Flows/ListFlows")
              .setRequestMarshaller(ProtoUtils.marshaller(ListFlowsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListFlowsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetFlowRequest, Flow> getFlowMethodDescriptor =
      MethodDescriptor.<GetFlowRequest, Flow>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Flows/GetFlow")
          .setRequestMarshaller(ProtoUtils.marshaller(GetFlowRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Flow.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateFlowRequest, Flow> updateFlowMethodDescriptor =
      MethodDescriptor.<UpdateFlowRequest, Flow>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Flows/UpdateFlow")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateFlowRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Flow.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<TrainFlowRequest, Operation> trainFlowMethodDescriptor =
      MethodDescriptor.<TrainFlowRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Flows/TrainFlow")
          .setRequestMarshaller(ProtoUtils.marshaller(TrainFlowRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ValidateFlowRequest, FlowValidationResult>
      validateFlowMethodDescriptor =
          MethodDescriptor.<ValidateFlowRequest, FlowValidationResult>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Flows/ValidateFlow")
              .setRequestMarshaller(ProtoUtils.marshaller(ValidateFlowRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(FlowValidationResult.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetFlowValidationResultRequest, FlowValidationResult>
      getFlowValidationResultMethodDescriptor =
          MethodDescriptor.<GetFlowValidationResultRequest, FlowValidationResult>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Flows/GetFlowValidationResult")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetFlowValidationResultRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(FlowValidationResult.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreateFlowRequest, Flow> createFlowCallable;
  private final UnaryCallable<DeleteFlowRequest, Empty> deleteFlowCallable;
  private final UnaryCallable<ListFlowsRequest, ListFlowsResponse> listFlowsCallable;
  private final UnaryCallable<ListFlowsRequest, ListFlowsPagedResponse> listFlowsPagedCallable;
  private final UnaryCallable<GetFlowRequest, Flow> getFlowCallable;
  private final UnaryCallable<UpdateFlowRequest, Flow> updateFlowCallable;
  private final UnaryCallable<TrainFlowRequest, Operation> trainFlowCallable;
  private final OperationCallable<TrainFlowRequest, Empty, Struct> trainFlowOperationCallable;
  private final UnaryCallable<ValidateFlowRequest, FlowValidationResult> validateFlowCallable;
  private final UnaryCallable<GetFlowValidationResultRequest, FlowValidationResult>
      getFlowValidationResultCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcFlowsStub create(FlowsStubSettings settings) throws IOException {
    return new GrpcFlowsStub(settings, ClientContext.create(settings));
  }

  public static final GrpcFlowsStub create(ClientContext clientContext) throws IOException {
    return new GrpcFlowsStub(FlowsStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcFlowsStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcFlowsStub(
        FlowsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcFlowsStub, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcFlowsStub(FlowsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcFlowsCallableFactory());
  }

  /**
   * Constructs an instance of GrpcFlowsStub, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcFlowsStub(
      FlowsStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateFlowRequest, Flow> createFlowTransportSettings =
        GrpcCallSettings.<CreateFlowRequest, Flow>newBuilder()
            .setMethodDescriptor(createFlowMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateFlowRequest>() {
                  @Override
                  public Map<String, String> extract(CreateFlowRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeleteFlowRequest, Empty> deleteFlowTransportSettings =
        GrpcCallSettings.<DeleteFlowRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteFlowMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteFlowRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteFlowRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListFlowsRequest, ListFlowsResponse> listFlowsTransportSettings =
        GrpcCallSettings.<ListFlowsRequest, ListFlowsResponse>newBuilder()
            .setMethodDescriptor(listFlowsMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ListFlowsRequest>() {
                  @Override
                  public Map<String, String> extract(ListFlowsRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetFlowRequest, Flow> getFlowTransportSettings =
        GrpcCallSettings.<GetFlowRequest, Flow>newBuilder()
            .setMethodDescriptor(getFlowMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetFlowRequest>() {
                  @Override
                  public Map<String, String> extract(GetFlowRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UpdateFlowRequest, Flow> updateFlowTransportSettings =
        GrpcCallSettings.<UpdateFlowRequest, Flow>newBuilder()
            .setMethodDescriptor(updateFlowMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateFlowRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateFlowRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("flow.name", String.valueOf(request.getFlow().getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<TrainFlowRequest, Operation> trainFlowTransportSettings =
        GrpcCallSettings.<TrainFlowRequest, Operation>newBuilder()
            .setMethodDescriptor(trainFlowMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<TrainFlowRequest>() {
                  @Override
                  public Map<String, String> extract(TrainFlowRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ValidateFlowRequest, FlowValidationResult> validateFlowTransportSettings =
        GrpcCallSettings.<ValidateFlowRequest, FlowValidationResult>newBuilder()
            .setMethodDescriptor(validateFlowMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ValidateFlowRequest>() {
                  @Override
                  public Map<String, String> extract(ValidateFlowRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetFlowValidationResultRequest, FlowValidationResult>
        getFlowValidationResultTransportSettings =
            GrpcCallSettings.<GetFlowValidationResultRequest, FlowValidationResult>newBuilder()
                .setMethodDescriptor(getFlowValidationResultMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<GetFlowValidationResultRequest>() {
                      @Override
                      public Map<String, String> extract(GetFlowValidationResultRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();

    this.createFlowCallable =
        callableFactory.createUnaryCallable(
            createFlowTransportSettings, settings.createFlowSettings(), clientContext);
    this.deleteFlowCallable =
        callableFactory.createUnaryCallable(
            deleteFlowTransportSettings, settings.deleteFlowSettings(), clientContext);
    this.listFlowsCallable =
        callableFactory.createUnaryCallable(
            listFlowsTransportSettings, settings.listFlowsSettings(), clientContext);
    this.listFlowsPagedCallable =
        callableFactory.createPagedCallable(
            listFlowsTransportSettings, settings.listFlowsSettings(), clientContext);
    this.getFlowCallable =
        callableFactory.createUnaryCallable(
            getFlowTransportSettings, settings.getFlowSettings(), clientContext);
    this.updateFlowCallable =
        callableFactory.createUnaryCallable(
            updateFlowTransportSettings, settings.updateFlowSettings(), clientContext);
    this.trainFlowCallable =
        callableFactory.createUnaryCallable(
            trainFlowTransportSettings, settings.trainFlowSettings(), clientContext);
    this.trainFlowOperationCallable =
        callableFactory.createOperationCallable(
            trainFlowTransportSettings,
            settings.trainFlowOperationSettings(),
            clientContext,
            operationsStub);
    this.validateFlowCallable =
        callableFactory.createUnaryCallable(
            validateFlowTransportSettings, settings.validateFlowSettings(), clientContext);
    this.getFlowValidationResultCallable =
        callableFactory.createUnaryCallable(
            getFlowValidationResultTransportSettings,
            settings.getFlowValidationResultSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateFlowRequest, Flow> createFlowCallable() {
    return createFlowCallable;
  }

  @Override
  public UnaryCallable<DeleteFlowRequest, Empty> deleteFlowCallable() {
    return deleteFlowCallable;
  }

  @Override
  public UnaryCallable<ListFlowsRequest, ListFlowsResponse> listFlowsCallable() {
    return listFlowsCallable;
  }

  @Override
  public UnaryCallable<ListFlowsRequest, ListFlowsPagedResponse> listFlowsPagedCallable() {
    return listFlowsPagedCallable;
  }

  @Override
  public UnaryCallable<GetFlowRequest, Flow> getFlowCallable() {
    return getFlowCallable;
  }

  @Override
  public UnaryCallable<UpdateFlowRequest, Flow> updateFlowCallable() {
    return updateFlowCallable;
  }

  @Override
  public UnaryCallable<TrainFlowRequest, Operation> trainFlowCallable() {
    return trainFlowCallable;
  }

  @Override
  public OperationCallable<TrainFlowRequest, Empty, Struct> trainFlowOperationCallable() {
    return trainFlowOperationCallable;
  }

  @Override
  public UnaryCallable<ValidateFlowRequest, FlowValidationResult> validateFlowCallable() {
    return validateFlowCallable;
  }

  @Override
  public UnaryCallable<GetFlowValidationResultRequest, FlowValidationResult>
      getFlowValidationResultCallable() {
    return getFlowValidationResultCallable;
  }

  @Override
  public final void close() {
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
