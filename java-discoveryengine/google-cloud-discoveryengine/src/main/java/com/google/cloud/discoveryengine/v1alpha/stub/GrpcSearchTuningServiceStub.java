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

package com.google.cloud.discoveryengine.v1alpha.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1alpha.TrainCustomModelMetadata;
import com.google.cloud.discoveryengine.v1alpha.TrainCustomModelRequest;
import com.google.cloud.discoveryengine.v1alpha.TrainCustomModelResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the SearchTuningService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcSearchTuningServiceStub extends SearchTuningServiceStub {
  private static final MethodDescriptor<TrainCustomModelRequest, Operation>
      trainCustomModelMethodDescriptor =
          MethodDescriptor.<TrainCustomModelRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1alpha.SearchTuningService/TrainCustomModel")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TrainCustomModelRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private final UnaryCallable<TrainCustomModelRequest, Operation> trainCustomModelCallable;
  private final OperationCallable<
          TrainCustomModelRequest, TrainCustomModelResponse, TrainCustomModelMetadata>
      trainCustomModelOperationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcSearchTuningServiceStub create(SearchTuningServiceStubSettings settings)
      throws IOException {
    return new GrpcSearchTuningServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcSearchTuningServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcSearchTuningServiceStub(
        SearchTuningServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcSearchTuningServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcSearchTuningServiceStub(
        SearchTuningServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcSearchTuningServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcSearchTuningServiceStub(
      SearchTuningServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcSearchTuningServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcSearchTuningServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcSearchTuningServiceStub(
      SearchTuningServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<TrainCustomModelRequest, Operation> trainCustomModelTransportSettings =
        GrpcCallSettings.<TrainCustomModelRequest, Operation>newBuilder()
            .setMethodDescriptor(trainCustomModelMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("data_store", String.valueOf(request.getDataStore()));
                  return builder.build();
                })
            .build();

    this.trainCustomModelCallable =
        callableFactory.createUnaryCallable(
            trainCustomModelTransportSettings, settings.trainCustomModelSettings(), clientContext);
    this.trainCustomModelOperationCallable =
        callableFactory.createOperationCallable(
            trainCustomModelTransportSettings,
            settings.trainCustomModelOperationSettings(),
            clientContext,
            operationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<TrainCustomModelRequest, Operation> trainCustomModelCallable() {
    return trainCustomModelCallable;
  }

  @Override
  public OperationCallable<
          TrainCustomModelRequest, TrainCustomModelResponse, TrainCustomModelMetadata>
      trainCustomModelOperationCallable() {
    return trainCustomModelOperationCallable;
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
