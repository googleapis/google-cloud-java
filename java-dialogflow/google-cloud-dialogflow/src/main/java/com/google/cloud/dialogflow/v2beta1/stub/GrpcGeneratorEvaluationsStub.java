/*
 * Copyright 2026 Google LLC
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

import static com.google.cloud.dialogflow.v2beta1.GeneratorEvaluationsClient.ListGeneratorEvaluationsPagedResponse;
import static com.google.cloud.dialogflow.v2beta1.GeneratorEvaluationsClient.ListLocationsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.v2beta1.CreateGeneratorEvaluationRequest;
import com.google.cloud.dialogflow.v2beta1.DeleteGeneratorEvaluationRequest;
import com.google.cloud.dialogflow.v2beta1.GeneratorEvaluation;
import com.google.cloud.dialogflow.v2beta1.GeneratorEvaluationOperationMetadata;
import com.google.cloud.dialogflow.v2beta1.GetGeneratorEvaluationRequest;
import com.google.cloud.dialogflow.v2beta1.ListGeneratorEvaluationsRequest;
import com.google.cloud.dialogflow.v2beta1.ListGeneratorEvaluationsResponse;
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
 * gRPC stub implementation for the GeneratorEvaluations service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcGeneratorEvaluationsStub extends GeneratorEvaluationsStub {
  private static final MethodDescriptor<CreateGeneratorEvaluationRequest, Operation>
      createGeneratorEvaluationMethodDescriptor =
          MethodDescriptor.<CreateGeneratorEvaluationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dialogflow.v2beta1.GeneratorEvaluations/CreateGeneratorEvaluation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateGeneratorEvaluationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetGeneratorEvaluationRequest, GeneratorEvaluation>
      getGeneratorEvaluationMethodDescriptor =
          MethodDescriptor.<GetGeneratorEvaluationRequest, GeneratorEvaluation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dialogflow.v2beta1.GeneratorEvaluations/GetGeneratorEvaluation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetGeneratorEvaluationRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GeneratorEvaluation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListGeneratorEvaluationsRequest, ListGeneratorEvaluationsResponse>
      listGeneratorEvaluationsMethodDescriptor =
          MethodDescriptor
              .<ListGeneratorEvaluationsRequest, ListGeneratorEvaluationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dialogflow.v2beta1.GeneratorEvaluations/ListGeneratorEvaluations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListGeneratorEvaluationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListGeneratorEvaluationsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteGeneratorEvaluationRequest, Empty>
      deleteGeneratorEvaluationMethodDescriptor =
          MethodDescriptor.<DeleteGeneratorEvaluationRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dialogflow.v2beta1.GeneratorEvaluations/DeleteGeneratorEvaluation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteGeneratorEvaluationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
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

  private final UnaryCallable<CreateGeneratorEvaluationRequest, Operation>
      createGeneratorEvaluationCallable;
  private final OperationCallable<
          CreateGeneratorEvaluationRequest,
          GeneratorEvaluation,
          GeneratorEvaluationOperationMetadata>
      createGeneratorEvaluationOperationCallable;
  private final UnaryCallable<GetGeneratorEvaluationRequest, GeneratorEvaluation>
      getGeneratorEvaluationCallable;
  private final UnaryCallable<ListGeneratorEvaluationsRequest, ListGeneratorEvaluationsResponse>
      listGeneratorEvaluationsCallable;
  private final UnaryCallable<
          ListGeneratorEvaluationsRequest, ListGeneratorEvaluationsPagedResponse>
      listGeneratorEvaluationsPagedCallable;
  private final UnaryCallable<DeleteGeneratorEvaluationRequest, Empty>
      deleteGeneratorEvaluationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcGeneratorEvaluationsStub create(GeneratorEvaluationsStubSettings settings)
      throws IOException {
    return new GrpcGeneratorEvaluationsStub(settings, ClientContext.create(settings));
  }

  public static final GrpcGeneratorEvaluationsStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcGeneratorEvaluationsStub(
        GeneratorEvaluationsStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcGeneratorEvaluationsStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcGeneratorEvaluationsStub(
        GeneratorEvaluationsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcGeneratorEvaluationsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcGeneratorEvaluationsStub(
      GeneratorEvaluationsStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcGeneratorEvaluationsCallableFactory());
  }

  /**
   * Constructs an instance of GrpcGeneratorEvaluationsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcGeneratorEvaluationsStub(
      GeneratorEvaluationsStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateGeneratorEvaluationRequest, Operation>
        createGeneratorEvaluationTransportSettings =
            GrpcCallSettings.<CreateGeneratorEvaluationRequest, Operation>newBuilder()
                .setMethodDescriptor(createGeneratorEvaluationMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetGeneratorEvaluationRequest, GeneratorEvaluation>
        getGeneratorEvaluationTransportSettings =
            GrpcCallSettings.<GetGeneratorEvaluationRequest, GeneratorEvaluation>newBuilder()
                .setMethodDescriptor(getGeneratorEvaluationMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListGeneratorEvaluationsRequest, ListGeneratorEvaluationsResponse>
        listGeneratorEvaluationsTransportSettings =
            GrpcCallSettings
                .<ListGeneratorEvaluationsRequest, ListGeneratorEvaluationsResponse>newBuilder()
                .setMethodDescriptor(listGeneratorEvaluationsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteGeneratorEvaluationRequest, Empty>
        deleteGeneratorEvaluationTransportSettings =
            GrpcCallSettings.<DeleteGeneratorEvaluationRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteGeneratorEvaluationMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
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

    this.createGeneratorEvaluationCallable =
        callableFactory.createUnaryCallable(
            createGeneratorEvaluationTransportSettings,
            settings.createGeneratorEvaluationSettings(),
            clientContext);
    this.createGeneratorEvaluationOperationCallable =
        callableFactory.createOperationCallable(
            createGeneratorEvaluationTransportSettings,
            settings.createGeneratorEvaluationOperationSettings(),
            clientContext,
            operationsStub);
    this.getGeneratorEvaluationCallable =
        callableFactory.createUnaryCallable(
            getGeneratorEvaluationTransportSettings,
            settings.getGeneratorEvaluationSettings(),
            clientContext);
    this.listGeneratorEvaluationsCallable =
        callableFactory.createUnaryCallable(
            listGeneratorEvaluationsTransportSettings,
            settings.listGeneratorEvaluationsSettings(),
            clientContext);
    this.listGeneratorEvaluationsPagedCallable =
        callableFactory.createPagedCallable(
            listGeneratorEvaluationsTransportSettings,
            settings.listGeneratorEvaluationsSettings(),
            clientContext);
    this.deleteGeneratorEvaluationCallable =
        callableFactory.createUnaryCallable(
            deleteGeneratorEvaluationTransportSettings,
            settings.deleteGeneratorEvaluationSettings(),
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
  public UnaryCallable<CreateGeneratorEvaluationRequest, Operation>
      createGeneratorEvaluationCallable() {
    return createGeneratorEvaluationCallable;
  }

  @Override
  public OperationCallable<
          CreateGeneratorEvaluationRequest,
          GeneratorEvaluation,
          GeneratorEvaluationOperationMetadata>
      createGeneratorEvaluationOperationCallable() {
    return createGeneratorEvaluationOperationCallable;
  }

  @Override
  public UnaryCallable<GetGeneratorEvaluationRequest, GeneratorEvaluation>
      getGeneratorEvaluationCallable() {
    return getGeneratorEvaluationCallable;
  }

  @Override
  public UnaryCallable<ListGeneratorEvaluationsRequest, ListGeneratorEvaluationsResponse>
      listGeneratorEvaluationsCallable() {
    return listGeneratorEvaluationsCallable;
  }

  @Override
  public UnaryCallable<ListGeneratorEvaluationsRequest, ListGeneratorEvaluationsPagedResponse>
      listGeneratorEvaluationsPagedCallable() {
    return listGeneratorEvaluationsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteGeneratorEvaluationRequest, Empty>
      deleteGeneratorEvaluationCallable() {
    return deleteGeneratorEvaluationCallable;
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
