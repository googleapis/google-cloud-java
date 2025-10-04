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

package com.google.shopping.merchant.ordertracking.v1beta.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.shopping.merchant.ordertracking.v1beta.CreateOrderTrackingSignalRequest;
import com.google.shopping.merchant.ordertracking.v1beta.OrderTrackingSignal;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the OrderTrackingSignalsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcOrderTrackingSignalsServiceStub extends OrderTrackingSignalsServiceStub {
  private static final MethodDescriptor<CreateOrderTrackingSignalRequest, OrderTrackingSignal>
      createOrderTrackingSignalMethodDescriptor =
          MethodDescriptor.<CreateOrderTrackingSignalRequest, OrderTrackingSignal>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.ordertracking.v1beta.OrderTrackingSignalsService/CreateOrderTrackingSignal")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateOrderTrackingSignalRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(OrderTrackingSignal.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<CreateOrderTrackingSignalRequest, OrderTrackingSignal>
      createOrderTrackingSignalCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcOrderTrackingSignalsServiceStub create(
      OrderTrackingSignalsServiceStubSettings settings) throws IOException {
    return new GrpcOrderTrackingSignalsServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcOrderTrackingSignalsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcOrderTrackingSignalsServiceStub(
        OrderTrackingSignalsServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcOrderTrackingSignalsServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcOrderTrackingSignalsServiceStub(
        OrderTrackingSignalsServiceStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of GrpcOrderTrackingSignalsServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcOrderTrackingSignalsServiceStub(
      OrderTrackingSignalsServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcOrderTrackingSignalsServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcOrderTrackingSignalsServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcOrderTrackingSignalsServiceStub(
      OrderTrackingSignalsServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateOrderTrackingSignalRequest, OrderTrackingSignal>
        createOrderTrackingSignalTransportSettings =
            GrpcCallSettings.<CreateOrderTrackingSignalRequest, OrderTrackingSignal>newBuilder()
                .setMethodDescriptor(createOrderTrackingSignalMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.createOrderTrackingSignalCallable =
        callableFactory.createUnaryCallable(
            createOrderTrackingSignalTransportSettings,
            settings.createOrderTrackingSignalSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateOrderTrackingSignalRequest, OrderTrackingSignal>
      createOrderTrackingSignalCallable() {
    return createOrderTrackingSignalCallable;
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
