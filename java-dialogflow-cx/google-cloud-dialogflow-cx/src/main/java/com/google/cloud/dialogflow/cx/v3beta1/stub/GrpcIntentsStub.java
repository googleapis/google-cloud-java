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

import static com.google.cloud.dialogflow.cx.v3beta1.IntentsClient.ListIntentsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3beta1.IntentsClient.ListLocationsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.cx.v3beta1.CreateIntentRequest;
import com.google.cloud.dialogflow.cx.v3beta1.DeleteIntentRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ExportIntentsMetadata;
import com.google.cloud.dialogflow.cx.v3beta1.ExportIntentsRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ExportIntentsResponse;
import com.google.cloud.dialogflow.cx.v3beta1.GetIntentRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ImportIntentsMetadata;
import com.google.cloud.dialogflow.cx.v3beta1.ImportIntentsRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ImportIntentsResponse;
import com.google.cloud.dialogflow.cx.v3beta1.Intent;
import com.google.cloud.dialogflow.cx.v3beta1.ListIntentsRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ListIntentsResponse;
import com.google.cloud.dialogflow.cx.v3beta1.UpdateIntentRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
              .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Intents/ListIntents")
              .setRequestMarshaller(ProtoUtils.marshaller(ListIntentsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListIntentsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetIntentRequest, Intent> getIntentMethodDescriptor =
      MethodDescriptor.<GetIntentRequest, Intent>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Intents/GetIntent")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIntentRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Intent.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<CreateIntentRequest, Intent> createIntentMethodDescriptor =
      MethodDescriptor.<CreateIntentRequest, Intent>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Intents/CreateIntent")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateIntentRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Intent.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<UpdateIntentRequest, Intent> updateIntentMethodDescriptor =
      MethodDescriptor.<UpdateIntentRequest, Intent>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Intents/UpdateIntent")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateIntentRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Intent.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<DeleteIntentRequest, Empty> deleteIntentMethodDescriptor =
      MethodDescriptor.<DeleteIntentRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Intents/DeleteIntent")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteIntentRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ImportIntentsRequest, Operation>
      importIntentsMethodDescriptor =
          MethodDescriptor.<ImportIntentsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Intents/ImportIntents")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ImportIntentsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ExportIntentsRequest, Operation>
      exportIntentsMethodDescriptor =
          MethodDescriptor.<ExportIntentsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Intents/ExportIntents")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ExportIntentsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
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

  private final UnaryCallable<ListIntentsRequest, ListIntentsResponse> listIntentsCallable;
  private final UnaryCallable<ListIntentsRequest, ListIntentsPagedResponse>
      listIntentsPagedCallable;
  private final UnaryCallable<GetIntentRequest, Intent> getIntentCallable;
  private final UnaryCallable<CreateIntentRequest, Intent> createIntentCallable;
  private final UnaryCallable<UpdateIntentRequest, Intent> updateIntentCallable;
  private final UnaryCallable<DeleteIntentRequest, Empty> deleteIntentCallable;
  private final UnaryCallable<ImportIntentsRequest, Operation> importIntentsCallable;
  private final OperationCallable<
          ImportIntentsRequest, ImportIntentsResponse, ImportIntentsMetadata>
      importIntentsOperationCallable;
  private final UnaryCallable<ExportIntentsRequest, Operation> exportIntentsCallable;
  private final OperationCallable<
          ExportIntentsRequest, ExportIntentsResponse, ExportIntentsMetadata>
      exportIntentsOperationCallable;
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
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetIntentRequest, Intent> getIntentTransportSettings =
        GrpcCallSettings.<GetIntentRequest, Intent>newBuilder()
            .setMethodDescriptor(getIntentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateIntentRequest, Intent> createIntentTransportSettings =
        GrpcCallSettings.<CreateIntentRequest, Intent>newBuilder()
            .setMethodDescriptor(createIntentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateIntentRequest, Intent> updateIntentTransportSettings =
        GrpcCallSettings.<UpdateIntentRequest, Intent>newBuilder()
            .setMethodDescriptor(updateIntentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("intent.name", String.valueOf(request.getIntent().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteIntentRequest, Empty> deleteIntentTransportSettings =
        GrpcCallSettings.<DeleteIntentRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteIntentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ImportIntentsRequest, Operation> importIntentsTransportSettings =
        GrpcCallSettings.<ImportIntentsRequest, Operation>newBuilder()
            .setMethodDescriptor(importIntentsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ExportIntentsRequest, Operation> exportIntentsTransportSettings =
        GrpcCallSettings.<ExportIntentsRequest, Operation>newBuilder()
            .setMethodDescriptor(exportIntentsMethodDescriptor)
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
    this.importIntentsCallable =
        callableFactory.createUnaryCallable(
            importIntentsTransportSettings, settings.importIntentsSettings(), clientContext);
    this.importIntentsOperationCallable =
        callableFactory.createOperationCallable(
            importIntentsTransportSettings,
            settings.importIntentsOperationSettings(),
            clientContext,
            operationsStub);
    this.exportIntentsCallable =
        callableFactory.createUnaryCallable(
            exportIntentsTransportSettings, settings.exportIntentsSettings(), clientContext);
    this.exportIntentsOperationCallable =
        callableFactory.createOperationCallable(
            exportIntentsTransportSettings,
            settings.exportIntentsOperationSettings(),
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
  public UnaryCallable<ImportIntentsRequest, Operation> importIntentsCallable() {
    return importIntentsCallable;
  }

  @Override
  public OperationCallable<ImportIntentsRequest, ImportIntentsResponse, ImportIntentsMetadata>
      importIntentsOperationCallable() {
    return importIntentsOperationCallable;
  }

  @Override
  public UnaryCallable<ExportIntentsRequest, Operation> exportIntentsCallable() {
    return exportIntentsCallable;
  }

  @Override
  public OperationCallable<ExportIntentsRequest, ExportIntentsResponse, ExportIntentsMetadata>
      exportIntentsOperationCallable() {
    return exportIntentsOperationCallable;
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
