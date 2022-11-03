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

package com.google.maps.routing.v2.stub;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.maps.routing.v2.ComputeRouteMatrixRequest;
import com.google.maps.routing.v2.ComputeRoutesRequest;
import com.google.maps.routing.v2.ComputeRoutesResponse;
import com.google.maps.routing.v2.RouteMatrixElement;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the Routes service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcRoutesStub extends RoutesStub {
  private static final MethodDescriptor<ComputeRoutesRequest, ComputeRoutesResponse>
      computeRoutesMethodDescriptor =
          MethodDescriptor.<ComputeRoutesRequest, ComputeRoutesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.maps.routing.v2.Routes/ComputeRoutes")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ComputeRoutesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ComputeRoutesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ComputeRouteMatrixRequest, RouteMatrixElement>
      computeRouteMatrixMethodDescriptor =
          MethodDescriptor.<ComputeRouteMatrixRequest, RouteMatrixElement>newBuilder()
              .setType(MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName("google.maps.routing.v2.Routes/ComputeRouteMatrix")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ComputeRouteMatrixRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(RouteMatrixElement.getDefaultInstance()))
              .build();

  private final UnaryCallable<ComputeRoutesRequest, ComputeRoutesResponse> computeRoutesCallable;
  private final ServerStreamingCallable<ComputeRouteMatrixRequest, RouteMatrixElement>
      computeRouteMatrixCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcRoutesStub create(RoutesStubSettings settings) throws IOException {
    return new GrpcRoutesStub(settings, ClientContext.create(settings));
  }

  public static final GrpcRoutesStub create(ClientContext clientContext) throws IOException {
    return new GrpcRoutesStub(RoutesStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcRoutesStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcRoutesStub(
        RoutesStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcRoutesStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcRoutesStub(RoutesStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcRoutesCallableFactory());
  }

  /**
   * Constructs an instance of GrpcRoutesStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcRoutesStub(
      RoutesStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ComputeRoutesRequest, ComputeRoutesResponse> computeRoutesTransportSettings =
        GrpcCallSettings.<ComputeRoutesRequest, ComputeRoutesResponse>newBuilder()
            .setMethodDescriptor(computeRoutesMethodDescriptor)
            .build();
    GrpcCallSettings<ComputeRouteMatrixRequest, RouteMatrixElement>
        computeRouteMatrixTransportSettings =
            GrpcCallSettings.<ComputeRouteMatrixRequest, RouteMatrixElement>newBuilder()
                .setMethodDescriptor(computeRouteMatrixMethodDescriptor)
                .build();

    this.computeRoutesCallable =
        callableFactory.createUnaryCallable(
            computeRoutesTransportSettings, settings.computeRoutesSettings(), clientContext);
    this.computeRouteMatrixCallable =
        callableFactory.createServerStreamingCallable(
            computeRouteMatrixTransportSettings,
            settings.computeRouteMatrixSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ComputeRoutesRequest, ComputeRoutesResponse> computeRoutesCallable() {
    return computeRoutesCallable;
  }

  @Override
  public ServerStreamingCallable<ComputeRouteMatrixRequest, RouteMatrixElement>
      computeRouteMatrixCallable() {
    return computeRouteMatrixCallable;
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
