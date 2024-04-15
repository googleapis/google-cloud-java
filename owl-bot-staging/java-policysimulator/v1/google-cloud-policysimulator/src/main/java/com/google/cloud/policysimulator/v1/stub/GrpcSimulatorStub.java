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

package com.google.cloud.policysimulator.v1.stub;

import static com.google.cloud.policysimulator.v1.SimulatorClient.ListReplayResultsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.policysimulator.v1.CreateReplayRequest;
import com.google.cloud.policysimulator.v1.GetReplayRequest;
import com.google.cloud.policysimulator.v1.ListReplayResultsRequest;
import com.google.cloud.policysimulator.v1.ListReplayResultsResponse;
import com.google.cloud.policysimulator.v1.Replay;
import com.google.cloud.policysimulator.v1.ReplayOperationMetadata;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the Simulator service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcSimulatorStub extends SimulatorStub {
  private static final MethodDescriptor<GetReplayRequest, Replay> getReplayMethodDescriptor =
      MethodDescriptor.<GetReplayRequest, Replay>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.policysimulator.v1.Simulator/GetReplay")
          .setRequestMarshaller(ProtoUtils.marshaller(GetReplayRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Replay.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateReplayRequest, Operation>
      createReplayMethodDescriptor =
          MethodDescriptor.<CreateReplayRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.policysimulator.v1.Simulator/CreateReplay")
              .setRequestMarshaller(ProtoUtils.marshaller(CreateReplayRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListReplayResultsRequest, ListReplayResultsResponse>
      listReplayResultsMethodDescriptor =
          MethodDescriptor.<ListReplayResultsRequest, ListReplayResultsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.policysimulator.v1.Simulator/ListReplayResults")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListReplayResultsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListReplayResultsResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<GetReplayRequest, Replay> getReplayCallable;
  private final UnaryCallable<CreateReplayRequest, Operation> createReplayCallable;
  private final OperationCallable<CreateReplayRequest, Replay, ReplayOperationMetadata>
      createReplayOperationCallable;
  private final UnaryCallable<ListReplayResultsRequest, ListReplayResultsResponse>
      listReplayResultsCallable;
  private final UnaryCallable<ListReplayResultsRequest, ListReplayResultsPagedResponse>
      listReplayResultsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcSimulatorStub create(SimulatorStubSettings settings) throws IOException {
    return new GrpcSimulatorStub(settings, ClientContext.create(settings));
  }

  public static final GrpcSimulatorStub create(ClientContext clientContext) throws IOException {
    return new GrpcSimulatorStub(SimulatorStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcSimulatorStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcSimulatorStub(
        SimulatorStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcSimulatorStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcSimulatorStub(SimulatorStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcSimulatorCallableFactory());
  }

  /**
   * Constructs an instance of GrpcSimulatorStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcSimulatorStub(
      SimulatorStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetReplayRequest, Replay> getReplayTransportSettings =
        GrpcCallSettings.<GetReplayRequest, Replay>newBuilder()
            .setMethodDescriptor(getReplayMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateReplayRequest, Operation> createReplayTransportSettings =
        GrpcCallSettings.<CreateReplayRequest, Operation>newBuilder()
            .setMethodDescriptor(createReplayMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListReplayResultsRequest, ListReplayResultsResponse>
        listReplayResultsTransportSettings =
            GrpcCallSettings.<ListReplayResultsRequest, ListReplayResultsResponse>newBuilder()
                .setMethodDescriptor(listReplayResultsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.getReplayCallable =
        callableFactory.createUnaryCallable(
            getReplayTransportSettings, settings.getReplaySettings(), clientContext);
    this.createReplayCallable =
        callableFactory.createUnaryCallable(
            createReplayTransportSettings, settings.createReplaySettings(), clientContext);
    this.createReplayOperationCallable =
        callableFactory.createOperationCallable(
            createReplayTransportSettings,
            settings.createReplayOperationSettings(),
            clientContext,
            operationsStub);
    this.listReplayResultsCallable =
        callableFactory.createUnaryCallable(
            listReplayResultsTransportSettings,
            settings.listReplayResultsSettings(),
            clientContext);
    this.listReplayResultsPagedCallable =
        callableFactory.createPagedCallable(
            listReplayResultsTransportSettings,
            settings.listReplayResultsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetReplayRequest, Replay> getReplayCallable() {
    return getReplayCallable;
  }

  @Override
  public UnaryCallable<CreateReplayRequest, Operation> createReplayCallable() {
    return createReplayCallable;
  }

  @Override
  public OperationCallable<CreateReplayRequest, Replay, ReplayOperationMetadata>
      createReplayOperationCallable() {
    return createReplayOperationCallable;
  }

  @Override
  public UnaryCallable<ListReplayResultsRequest, ListReplayResultsResponse>
      listReplayResultsCallable() {
    return listReplayResultsCallable;
  }

  @Override
  public UnaryCallable<ListReplayResultsRequest, ListReplayResultsPagedResponse>
      listReplayResultsPagedCallable() {
    return listReplayResultsPagedCallable;
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
