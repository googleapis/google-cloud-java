/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.dialogflow.v2beta1.stub;

import static com.google.cloud.dialogflow.v2beta1.PagedResponseWrappers.ListIntentsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.v2beta1.BatchDeleteIntentsRequest;
import com.google.cloud.dialogflow.v2beta1.BatchUpdateIntentsRequest;
import com.google.cloud.dialogflow.v2beta1.BatchUpdateIntentsResponse;
import com.google.cloud.dialogflow.v2beta1.CreateIntentRequest;
import com.google.cloud.dialogflow.v2beta1.DeleteIntentRequest;
import com.google.cloud.dialogflow.v2beta1.GetIntentRequest;
import com.google.cloud.dialogflow.v2beta1.Intent;
import com.google.cloud.dialogflow.v2beta1.ListIntentsRequest;
import com.google.cloud.dialogflow.v2beta1.ListIntentsResponse;
import com.google.cloud.dialogflow.v2beta1.UpdateIntentRequest;
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
public class GrpcIntentsStub extends IntentsStub {

  private static final MethodDescriptor<ListIntentsRequest, ListIntentsResponse>
      listIntentsMethodDescriptor =
          MethodDescriptor.<ListIntentsRequest, ListIntentsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.v2beta1.Intents/ListIntents")
              .setRequestMarshaller(ProtoUtils.marshaller(ListIntentsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListIntentsResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<GetIntentRequest, Intent> getIntentMethodDescriptor =
      MethodDescriptor.<GetIntentRequest, Intent>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dialogflow.v2beta1.Intents/GetIntent")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIntentRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Intent.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<CreateIntentRequest, Intent> createIntentMethodDescriptor =
      MethodDescriptor.<CreateIntentRequest, Intent>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dialogflow.v2beta1.Intents/CreateIntent")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateIntentRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Intent.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<UpdateIntentRequest, Intent> updateIntentMethodDescriptor =
      MethodDescriptor.<UpdateIntentRequest, Intent>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dialogflow.v2beta1.Intents/UpdateIntent")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateIntentRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Intent.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<DeleteIntentRequest, Empty> deleteIntentMethodDescriptor =
      MethodDescriptor.<DeleteIntentRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dialogflow.v2beta1.Intents/DeleteIntent")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteIntentRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<BatchUpdateIntentsRequest, Operation>
      batchUpdateIntentsMethodDescriptor =
          MethodDescriptor.<BatchUpdateIntentsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.v2beta1.Intents/BatchUpdateIntents")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchUpdateIntentsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<BatchDeleteIntentsRequest, Operation>
      batchDeleteIntentsMethodDescriptor =
          MethodDescriptor.<BatchDeleteIntentsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.v2beta1.Intents/BatchDeleteIntents")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchDeleteIntentsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;

  private final UnaryCallable<ListIntentsRequest, ListIntentsResponse> listIntentsCallable;
  private final UnaryCallable<ListIntentsRequest, ListIntentsPagedResponse>
      listIntentsPagedCallable;
  private final UnaryCallable<GetIntentRequest, Intent> getIntentCallable;
  private final UnaryCallable<CreateIntentRequest, Intent> createIntentCallable;
  private final UnaryCallable<UpdateIntentRequest, Intent> updateIntentCallable;
  private final UnaryCallable<DeleteIntentRequest, Empty> deleteIntentCallable;
  private final UnaryCallable<BatchUpdateIntentsRequest, Operation> batchUpdateIntentsCallable;
  private final OperationCallable<BatchUpdateIntentsRequest, BatchUpdateIntentsResponse, Struct>
      batchUpdateIntentsOperationCallable;
  private final UnaryCallable<BatchDeleteIntentsRequest, Operation> batchDeleteIntentsCallable;
  private final OperationCallable<BatchDeleteIntentsRequest, Empty, Struct>
      batchDeleteIntentsOperationCallable;

  public static final GrpcIntentsStub create(IntentsStubSettings settings) throws IOException {
    return new GrpcIntentsStub(settings, ClientContext.create(settings));
  }

  public static final GrpcIntentsStub create(ClientContext clientContext) throws IOException {
    return new GrpcIntentsStub(IntentsStubSettings.newBuilder().build(), clientContext);
  }

  /**
   * Constructs an instance of GrpcIntentsStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcIntentsStub(IntentsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this.operationsStub = GrpcOperationsStub.create(clientContext);

    GrpcCallSettings<ListIntentsRequest, ListIntentsResponse> listIntentsTransportSettings =
        GrpcCallSettings.<ListIntentsRequest, ListIntentsResponse>newBuilder()
            .setMethodDescriptor(listIntentsMethodDescriptor)
            .build();
    GrpcCallSettings<GetIntentRequest, Intent> getIntentTransportSettings =
        GrpcCallSettings.<GetIntentRequest, Intent>newBuilder()
            .setMethodDescriptor(getIntentMethodDescriptor)
            .build();
    GrpcCallSettings<CreateIntentRequest, Intent> createIntentTransportSettings =
        GrpcCallSettings.<CreateIntentRequest, Intent>newBuilder()
            .setMethodDescriptor(createIntentMethodDescriptor)
            .build();
    GrpcCallSettings<UpdateIntentRequest, Intent> updateIntentTransportSettings =
        GrpcCallSettings.<UpdateIntentRequest, Intent>newBuilder()
            .setMethodDescriptor(updateIntentMethodDescriptor)
            .build();
    GrpcCallSettings<DeleteIntentRequest, Empty> deleteIntentTransportSettings =
        GrpcCallSettings.<DeleteIntentRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteIntentMethodDescriptor)
            .build();
    GrpcCallSettings<BatchUpdateIntentsRequest, Operation> batchUpdateIntentsTransportSettings =
        GrpcCallSettings.<BatchUpdateIntentsRequest, Operation>newBuilder()
            .setMethodDescriptor(batchUpdateIntentsMethodDescriptor)
            .build();
    GrpcCallSettings<BatchDeleteIntentsRequest, Operation> batchDeleteIntentsTransportSettings =
        GrpcCallSettings.<BatchDeleteIntentsRequest, Operation>newBuilder()
            .setMethodDescriptor(batchDeleteIntentsMethodDescriptor)
            .build();

    this.listIntentsCallable =
        GrpcCallableFactory.createUnaryCallable(
            listIntentsTransportSettings, settings.listIntentsSettings(), clientContext);
    this.listIntentsPagedCallable =
        GrpcCallableFactory.createPagedCallable(
            listIntentsTransportSettings, settings.listIntentsSettings(), clientContext);
    this.getIntentCallable =
        GrpcCallableFactory.createUnaryCallable(
            getIntentTransportSettings, settings.getIntentSettings(), clientContext);
    this.createIntentCallable =
        GrpcCallableFactory.createUnaryCallable(
            createIntentTransportSettings, settings.createIntentSettings(), clientContext);
    this.updateIntentCallable =
        GrpcCallableFactory.createUnaryCallable(
            updateIntentTransportSettings, settings.updateIntentSettings(), clientContext);
    this.deleteIntentCallable =
        GrpcCallableFactory.createUnaryCallable(
            deleteIntentTransportSettings, settings.deleteIntentSettings(), clientContext);
    this.batchUpdateIntentsCallable =
        GrpcCallableFactory.createUnaryCallable(
            batchUpdateIntentsTransportSettings,
            settings.batchUpdateIntentsSettings(),
            clientContext);
    this.batchUpdateIntentsOperationCallable =
        GrpcCallableFactory.createOperationCallable(
            batchUpdateIntentsTransportSettings,
            settings.batchUpdateIntentsOperationSettings(),
            clientContext,
            this.operationsStub);
    this.batchDeleteIntentsCallable =
        GrpcCallableFactory.createUnaryCallable(
            batchDeleteIntentsTransportSettings,
            settings.batchDeleteIntentsSettings(),
            clientContext);
    this.batchDeleteIntentsOperationCallable =
        GrpcCallableFactory.createOperationCallable(
            batchDeleteIntentsTransportSettings,
            settings.batchDeleteIntentsOperationSettings(),
            clientContext,
            this.operationsStub);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  public UnaryCallable<ListIntentsRequest, ListIntentsPagedResponse> listIntentsPagedCallable() {
    return listIntentsPagedCallable;
  }

  public UnaryCallable<ListIntentsRequest, ListIntentsResponse> listIntentsCallable() {
    return listIntentsCallable;
  }

  public UnaryCallable<GetIntentRequest, Intent> getIntentCallable() {
    return getIntentCallable;
  }

  public UnaryCallable<CreateIntentRequest, Intent> createIntentCallable() {
    return createIntentCallable;
  }

  public UnaryCallable<UpdateIntentRequest, Intent> updateIntentCallable() {
    return updateIntentCallable;
  }

  public UnaryCallable<DeleteIntentRequest, Empty> deleteIntentCallable() {
    return deleteIntentCallable;
  }

  public OperationCallable<BatchUpdateIntentsRequest, BatchUpdateIntentsResponse, Struct>
      batchUpdateIntentsOperationCallable() {
    return batchUpdateIntentsOperationCallable;
  }

  public UnaryCallable<BatchUpdateIntentsRequest, Operation> batchUpdateIntentsCallable() {
    return batchUpdateIntentsCallable;
  }

  public OperationCallable<BatchDeleteIntentsRequest, Empty, Struct>
      batchDeleteIntentsOperationCallable() {
    return batchDeleteIntentsOperationCallable;
  }

  public UnaryCallable<BatchDeleteIntentsRequest, Operation> batchDeleteIntentsCallable() {
    return batchDeleteIntentsCallable;
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
