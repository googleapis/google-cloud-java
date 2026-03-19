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

package com.google.maps.navconnect.v1.stub;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.maps.navconnect.v1.CreateTripRequest;
import com.google.maps.navconnect.v1.GetTripRequest;
import com.google.maps.navconnect.v1.Trip;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the NavConnectService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcNavConnectServiceStub extends NavConnectServiceStub {
  private static final MethodDescriptor<CreateTripRequest, Trip> createTripMethodDescriptor =
      MethodDescriptor.<CreateTripRequest, Trip>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.maps.navconnect.v1.NavConnectService/CreateTrip")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateTripRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Trip.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<GetTripRequest, Trip> getTripMethodDescriptor =
      MethodDescriptor.<GetTripRequest, Trip>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.maps.navconnect.v1.NavConnectService/GetTrip")
          .setRequestMarshaller(ProtoUtils.marshaller(GetTripRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Trip.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private final UnaryCallable<CreateTripRequest, Trip> createTripCallable;
  private final UnaryCallable<GetTripRequest, Trip> getTripCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcNavConnectServiceStub create(NavConnectServiceStubSettings settings)
      throws IOException {
    return new GrpcNavConnectServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcNavConnectServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcNavConnectServiceStub(
        NavConnectServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcNavConnectServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcNavConnectServiceStub(
        NavConnectServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcNavConnectServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcNavConnectServiceStub(
      NavConnectServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcNavConnectServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcNavConnectServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcNavConnectServiceStub(
      NavConnectServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateTripRequest, Trip> createTripTransportSettings =
        GrpcCallSettings.<CreateTripRequest, Trip>newBuilder()
            .setMethodDescriptor(createTripMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetTripRequest, Trip> getTripTransportSettings =
        GrpcCallSettings.<GetTripRequest, Trip>newBuilder()
            .setMethodDescriptor(getTripMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.createTripCallable =
        callableFactory.createUnaryCallable(
            createTripTransportSettings, settings.createTripSettings(), clientContext);
    this.getTripCallable =
        callableFactory.createUnaryCallable(
            getTripTransportSettings, settings.getTripSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateTripRequest, Trip> createTripCallable() {
    return createTripCallable;
  }

  @Override
  public UnaryCallable<GetTripRequest, Trip> getTripCallable() {
    return getTripCallable;
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
