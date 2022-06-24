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

package com.google.cloud.dialogflow.cx.v3beta1.stub;

import static com.google.cloud.dialogflow.cx.v3beta1.ExperimentsClient.ListExperimentsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3beta1.ExperimentsClient.ListLocationsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.cx.v3beta1.CreateExperimentRequest;
import com.google.cloud.dialogflow.cx.v3beta1.DeleteExperimentRequest;
import com.google.cloud.dialogflow.cx.v3beta1.Experiment;
import com.google.cloud.dialogflow.cx.v3beta1.GetExperimentRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ListExperimentsRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ListExperimentsResponse;
import com.google.cloud.dialogflow.cx.v3beta1.StartExperimentRequest;
import com.google.cloud.dialogflow.cx.v3beta1.StopExperimentRequest;
import com.google.cloud.dialogflow.cx.v3beta1.UpdateExperimentRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the Experiments service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcExperimentsStub extends ExperimentsStub {
  private static final MethodDescriptor<ListExperimentsRequest, ListExperimentsResponse>
      listExperimentsMethodDescriptor =
          MethodDescriptor.<ListExperimentsRequest, ListExperimentsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Experiments/ListExperiments")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListExperimentsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListExperimentsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetExperimentRequest, Experiment>
      getExperimentMethodDescriptor =
          MethodDescriptor.<GetExperimentRequest, Experiment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Experiments/GetExperiment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetExperimentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Experiment.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateExperimentRequest, Experiment>
      createExperimentMethodDescriptor =
          MethodDescriptor.<CreateExperimentRequest, Experiment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Experiments/CreateExperiment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateExperimentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Experiment.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateExperimentRequest, Experiment>
      updateExperimentMethodDescriptor =
          MethodDescriptor.<UpdateExperimentRequest, Experiment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Experiments/UpdateExperiment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateExperimentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Experiment.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteExperimentRequest, Empty>
      deleteExperimentMethodDescriptor =
          MethodDescriptor.<DeleteExperimentRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Experiments/DeleteExperiment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteExperimentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<StartExperimentRequest, Experiment>
      startExperimentMethodDescriptor =
          MethodDescriptor.<StartExperimentRequest, Experiment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Experiments/StartExperiment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(StartExperimentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Experiment.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<StopExperimentRequest, Experiment>
      stopExperimentMethodDescriptor =
          MethodDescriptor.<StopExperimentRequest, Experiment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Experiments/StopExperiment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(StopExperimentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Experiment.getDefaultInstance()))
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

  private final UnaryCallable<ListExperimentsRequest, ListExperimentsResponse>
      listExperimentsCallable;
  private final UnaryCallable<ListExperimentsRequest, ListExperimentsPagedResponse>
      listExperimentsPagedCallable;
  private final UnaryCallable<GetExperimentRequest, Experiment> getExperimentCallable;
  private final UnaryCallable<CreateExperimentRequest, Experiment> createExperimentCallable;
  private final UnaryCallable<UpdateExperimentRequest, Experiment> updateExperimentCallable;
  private final UnaryCallable<DeleteExperimentRequest, Empty> deleteExperimentCallable;
  private final UnaryCallable<StartExperimentRequest, Experiment> startExperimentCallable;
  private final UnaryCallable<StopExperimentRequest, Experiment> stopExperimentCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcExperimentsStub create(ExperimentsStubSettings settings)
      throws IOException {
    return new GrpcExperimentsStub(settings, ClientContext.create(settings));
  }

  public static final GrpcExperimentsStub create(ClientContext clientContext) throws IOException {
    return new GrpcExperimentsStub(ExperimentsStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcExperimentsStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcExperimentsStub(
        ExperimentsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcExperimentsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcExperimentsStub(ExperimentsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcExperimentsCallableFactory());
  }

  /**
   * Constructs an instance of GrpcExperimentsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcExperimentsStub(
      ExperimentsStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListExperimentsRequest, ListExperimentsResponse>
        listExperimentsTransportSettings =
            GrpcCallSettings.<ListExperimentsRequest, ListExperimentsResponse>newBuilder()
                .setMethodDescriptor(listExperimentsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetExperimentRequest, Experiment> getExperimentTransportSettings =
        GrpcCallSettings.<GetExperimentRequest, Experiment>newBuilder()
            .setMethodDescriptor(getExperimentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateExperimentRequest, Experiment> createExperimentTransportSettings =
        GrpcCallSettings.<CreateExperimentRequest, Experiment>newBuilder()
            .setMethodDescriptor(createExperimentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateExperimentRequest, Experiment> updateExperimentTransportSettings =
        GrpcCallSettings.<UpdateExperimentRequest, Experiment>newBuilder()
            .setMethodDescriptor(updateExperimentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("experiment.name", String.valueOf(request.getExperiment().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteExperimentRequest, Empty> deleteExperimentTransportSettings =
        GrpcCallSettings.<DeleteExperimentRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteExperimentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<StartExperimentRequest, Experiment> startExperimentTransportSettings =
        GrpcCallSettings.<StartExperimentRequest, Experiment>newBuilder()
            .setMethodDescriptor(startExperimentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<StopExperimentRequest, Experiment> stopExperimentTransportSettings =
        GrpcCallSettings.<StopExperimentRequest, Experiment>newBuilder()
            .setMethodDescriptor(stopExperimentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
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

    this.listExperimentsCallable =
        callableFactory.createUnaryCallable(
            listExperimentsTransportSettings, settings.listExperimentsSettings(), clientContext);
    this.listExperimentsPagedCallable =
        callableFactory.createPagedCallable(
            listExperimentsTransportSettings, settings.listExperimentsSettings(), clientContext);
    this.getExperimentCallable =
        callableFactory.createUnaryCallable(
            getExperimentTransportSettings, settings.getExperimentSettings(), clientContext);
    this.createExperimentCallable =
        callableFactory.createUnaryCallable(
            createExperimentTransportSettings, settings.createExperimentSettings(), clientContext);
    this.updateExperimentCallable =
        callableFactory.createUnaryCallable(
            updateExperimentTransportSettings, settings.updateExperimentSettings(), clientContext);
    this.deleteExperimentCallable =
        callableFactory.createUnaryCallable(
            deleteExperimentTransportSettings, settings.deleteExperimentSettings(), clientContext);
    this.startExperimentCallable =
        callableFactory.createUnaryCallable(
            startExperimentTransportSettings, settings.startExperimentSettings(), clientContext);
    this.stopExperimentCallable =
        callableFactory.createUnaryCallable(
            stopExperimentTransportSettings, settings.stopExperimentSettings(), clientContext);
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
  public UnaryCallable<ListExperimentsRequest, ListExperimentsResponse> listExperimentsCallable() {
    return listExperimentsCallable;
  }

  @Override
  public UnaryCallable<ListExperimentsRequest, ListExperimentsPagedResponse>
      listExperimentsPagedCallable() {
    return listExperimentsPagedCallable;
  }

  @Override
  public UnaryCallable<GetExperimentRequest, Experiment> getExperimentCallable() {
    return getExperimentCallable;
  }

  @Override
  public UnaryCallable<CreateExperimentRequest, Experiment> createExperimentCallable() {
    return createExperimentCallable;
  }

  @Override
  public UnaryCallable<UpdateExperimentRequest, Experiment> updateExperimentCallable() {
    return updateExperimentCallable;
  }

  @Override
  public UnaryCallable<DeleteExperimentRequest, Empty> deleteExperimentCallable() {
    return deleteExperimentCallable;
  }

  @Override
  public UnaryCallable<StartExperimentRequest, Experiment> startExperimentCallable() {
    return startExperimentCallable;
  }

  @Override
  public UnaryCallable<StopExperimentRequest, Experiment> stopExperimentCallable() {
    return stopExperimentCallable;
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
