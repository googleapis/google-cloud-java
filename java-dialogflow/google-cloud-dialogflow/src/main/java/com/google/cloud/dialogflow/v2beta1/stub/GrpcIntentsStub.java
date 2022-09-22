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

package com.google.cloud.dialogflow.v2beta1.stub;

import static com.google.cloud.dialogflow.v2beta1.IntentsClient.ListIntentsPagedResponse;
import static com.google.cloud.dialogflow.v2beta1.IntentsClient.ListLocationsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
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
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.ImmutableMap;
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
 * gRPC stub implementation for the Intents service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
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
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcIntentsStub create(IntentsStubSettings settings) throws IOException {
    return new GrpcIntentsStub(settings, ClientContext.create(settings));
  }

  public static final GrpcIntentsStub create(ClientContext clientContext) throws IOException {
    return new GrpcIntentsStub(IntentsStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcIntentsStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcIntentsStub(
        IntentsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcIntentsStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcIntentsStub(IntentsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcIntentsCallableFactory());
  }

  /**
   * Constructs an instance of GrpcIntentsStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcIntentsStub(
      IntentsStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListIntentsRequest, ListIntentsResponse> listIntentsTransportSettings =
        GrpcCallSettings.<ListIntentsRequest, ListIntentsResponse>newBuilder()
            .setMethodDescriptor(listIntentsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetIntentRequest, Intent> getIntentTransportSettings =
        GrpcCallSettings.<GetIntentRequest, Intent>newBuilder()
            .setMethodDescriptor(getIntentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateIntentRequest, Intent> createIntentTransportSettings =
        GrpcCallSettings.<CreateIntentRequest, Intent>newBuilder()
            .setMethodDescriptor(createIntentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateIntentRequest, Intent> updateIntentTransportSettings =
        GrpcCallSettings.<UpdateIntentRequest, Intent>newBuilder()
            .setMethodDescriptor(updateIntentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("intent.name", String.valueOf(request.getIntent().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteIntentRequest, Empty> deleteIntentTransportSettings =
        GrpcCallSettings.<DeleteIntentRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteIntentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<BatchUpdateIntentsRequest, Operation> batchUpdateIntentsTransportSettings =
        GrpcCallSettings.<BatchUpdateIntentsRequest, Operation>newBuilder()
            .setMethodDescriptor(batchUpdateIntentsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<BatchDeleteIntentsRequest, Operation> batchDeleteIntentsTransportSettings =
        GrpcCallSettings.<BatchDeleteIntentsRequest, Operation>newBuilder()
            .setMethodDescriptor(batchDeleteIntentsMethodDescriptor)
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

    this.listIntentsCallable =
        callableFactory.createUnaryCallable(
            listIntentsTransportSettings, settings.listIntentsSettings(), clientContext);
    this.listIntentsPagedCallable =
        callableFactory.createPagedCallable(
            listIntentsTransportSettings, settings.listIntentsSettings(), clientContext);
    this.getIntentCallable =
        callableFactory.createUnaryCallable(
            getIntentTransportSettings, settings.getIntentSettings(), clientContext);
    this.createIntentCallable =
        callableFactory.createUnaryCallable(
            createIntentTransportSettings, settings.createIntentSettings(), clientContext);
    this.updateIntentCallable =
        callableFactory.createUnaryCallable(
            updateIntentTransportSettings, settings.updateIntentSettings(), clientContext);
    this.deleteIntentCallable =
        callableFactory.createUnaryCallable(
            deleteIntentTransportSettings, settings.deleteIntentSettings(), clientContext);
    this.batchUpdateIntentsCallable =
        callableFactory.createUnaryCallable(
            batchUpdateIntentsTransportSettings,
            settings.batchUpdateIntentsSettings(),
            clientContext);
    this.batchUpdateIntentsOperationCallable =
        callableFactory.createOperationCallable(
            batchUpdateIntentsTransportSettings,
            settings.batchUpdateIntentsOperationSettings(),
            clientContext,
            operationsStub);
    this.batchDeleteIntentsCallable =
        callableFactory.createUnaryCallable(
            batchDeleteIntentsTransportSettings,
            settings.batchDeleteIntentsSettings(),
            clientContext);
    this.batchDeleteIntentsOperationCallable =
        callableFactory.createOperationCallable(
            batchDeleteIntentsTransportSettings,
            settings.batchDeleteIntentsOperationSettings(),
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
  public UnaryCallable<ListIntentsRequest, ListIntentsResponse> listIntentsCallable() {
    return listIntentsCallable;
  }

  @Override
  public UnaryCallable<ListIntentsRequest, ListIntentsPagedResponse> listIntentsPagedCallable() {
    return listIntentsPagedCallable;
  }

  @Override
  public UnaryCallable<GetIntentRequest, Intent> getIntentCallable() {
    return getIntentCallable;
  }

  @Override
  public UnaryCallable<CreateIntentRequest, Intent> createIntentCallable() {
    return createIntentCallable;
  }

  @Override
  public UnaryCallable<UpdateIntentRequest, Intent> updateIntentCallable() {
    return updateIntentCallable;
  }

  @Override
  public UnaryCallable<DeleteIntentRequest, Empty> deleteIntentCallable() {
    return deleteIntentCallable;
  }

  @Override
  public UnaryCallable<BatchUpdateIntentsRequest, Operation> batchUpdateIntentsCallable() {
    return batchUpdateIntentsCallable;
  }

  @Override
  public OperationCallable<BatchUpdateIntentsRequest, BatchUpdateIntentsResponse, Struct>
      batchUpdateIntentsOperationCallable() {
    return batchUpdateIntentsOperationCallable;
  }

  @Override
  public UnaryCallable<BatchDeleteIntentsRequest, Operation> batchDeleteIntentsCallable() {
    return batchDeleteIntentsCallable;
  }

  @Override
  public OperationCallable<BatchDeleteIntentsRequest, Empty, Struct>
      batchDeleteIntentsOperationCallable() {
    return batchDeleteIntentsOperationCallable;
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
