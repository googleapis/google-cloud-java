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

package com.google.api.servicecontrol.v1.stub;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.servicecontrol.v1.AllocateQuotaRequest;
import com.google.api.servicecontrol.v1.AllocateQuotaResponse;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the QuotaController service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcQuotaControllerStub extends QuotaControllerStub {
  private static final MethodDescriptor<AllocateQuotaRequest, AllocateQuotaResponse>
      allocateQuotaMethodDescriptor =
          MethodDescriptor.<AllocateQuotaRequest, AllocateQuotaResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.api.servicecontrol.v1.QuotaController/AllocateQuota")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(AllocateQuotaRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(AllocateQuotaResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<AllocateQuotaRequest, AllocateQuotaResponse> allocateQuotaCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcQuotaControllerStub create(QuotaControllerStubSettings settings)
      throws IOException {
    return new GrpcQuotaControllerStub(settings, ClientContext.create(settings));
  }

  public static final GrpcQuotaControllerStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcQuotaControllerStub(
        QuotaControllerStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcQuotaControllerStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcQuotaControllerStub(
        QuotaControllerStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcQuotaControllerStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcQuotaControllerStub(
      QuotaControllerStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcQuotaControllerCallableFactory());
  }

  /**
   * Constructs an instance of GrpcQuotaControllerStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcQuotaControllerStub(
      QuotaControllerStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<AllocateQuotaRequest, AllocateQuotaResponse> allocateQuotaTransportSettings =
        GrpcCallSettings.<AllocateQuotaRequest, AllocateQuotaResponse>newBuilder()
            .setMethodDescriptor(allocateQuotaMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("service_name", String.valueOf(request.getServiceName()));
                  return builder.build();
                })
            .build();

    this.allocateQuotaCallable =
        callableFactory.createUnaryCallable(
            allocateQuotaTransportSettings, settings.allocateQuotaSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<AllocateQuotaRequest, AllocateQuotaResponse> allocateQuotaCallable() {
    return allocateQuotaCallable;
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
