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

package com.google.maps.isochrones.v1.stub;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.maps.isochrones.v1.GenerateIsochroneRequest;
import com.google.maps.isochrones.v1.GenerateIsochroneResponse;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the IsochroneService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class GrpcIsochroneServiceStub extends IsochroneServiceStub {
  private static final MethodDescriptor<GenerateIsochroneRequest, GenerateIsochroneResponse>
      generateIsochroneMethodDescriptor =
          MethodDescriptor.<GenerateIsochroneRequest, GenerateIsochroneResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.maps.isochrones.v1.IsochroneService/GenerateIsochrone")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GenerateIsochroneRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GenerateIsochroneResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<GenerateIsochroneRequest, GenerateIsochroneResponse>
      generateIsochroneCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcIsochroneServiceStub create(IsochroneServiceStubSettings settings)
      throws IOException {
    return new GrpcIsochroneServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcIsochroneServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcIsochroneServiceStub(
        IsochroneServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcIsochroneServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcIsochroneServiceStub(
        IsochroneServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcIsochroneServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcIsochroneServiceStub(
      IsochroneServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcIsochroneServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcIsochroneServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcIsochroneServiceStub(
      IsochroneServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GenerateIsochroneRequest, GenerateIsochroneResponse>
        generateIsochroneTransportSettings =
            GrpcCallSettings.<GenerateIsochroneRequest, GenerateIsochroneResponse>newBuilder()
                .setMethodDescriptor(generateIsochroneMethodDescriptor)
                .setResourceNameExtractor(request -> request.getPlace())
                .build();

    this.generateIsochroneCallable =
        callableFactory.createUnaryCallable(
            generateIsochroneTransportSettings,
            settings.generateIsochroneSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GenerateIsochroneRequest, GenerateIsochroneResponse>
      generateIsochroneCallable() {
    return generateIsochroneCallable;
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
