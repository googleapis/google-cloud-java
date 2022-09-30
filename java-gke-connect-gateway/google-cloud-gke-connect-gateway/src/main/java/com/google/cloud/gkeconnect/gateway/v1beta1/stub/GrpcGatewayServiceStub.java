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

package com.google.cloud.gkeconnect.gateway.v1beta1.stub;

import com.google.api.HttpBody;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the GatewayService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcGatewayServiceStub extends GatewayServiceStub {
  private static final MethodDescriptor<HttpBody, HttpBody> getResourceMethodDescriptor =
      MethodDescriptor.<HttpBody, HttpBody>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.gkeconnect.gateway.v1beta1.GatewayService/GetResource")
          .setRequestMarshaller(ProtoUtils.marshaller(HttpBody.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(HttpBody.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<HttpBody, HttpBody> postResourceMethodDescriptor =
      MethodDescriptor.<HttpBody, HttpBody>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.gkeconnect.gateway.v1beta1.GatewayService/PostResource")
          .setRequestMarshaller(ProtoUtils.marshaller(HttpBody.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(HttpBody.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<HttpBody, HttpBody> deleteResourceMethodDescriptor =
      MethodDescriptor.<HttpBody, HttpBody>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.gkeconnect.gateway.v1beta1.GatewayService/DeleteResource")
          .setRequestMarshaller(ProtoUtils.marshaller(HttpBody.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(HttpBody.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<HttpBody, HttpBody> putResourceMethodDescriptor =
      MethodDescriptor.<HttpBody, HttpBody>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.gkeconnect.gateway.v1beta1.GatewayService/PutResource")
          .setRequestMarshaller(ProtoUtils.marshaller(HttpBody.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(HttpBody.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<HttpBody, HttpBody> patchResourceMethodDescriptor =
      MethodDescriptor.<HttpBody, HttpBody>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.gkeconnect.gateway.v1beta1.GatewayService/PatchResource")
          .setRequestMarshaller(ProtoUtils.marshaller(HttpBody.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(HttpBody.getDefaultInstance()))
          .build();

  private final UnaryCallable<HttpBody, HttpBody> getResourceCallable;
  private final UnaryCallable<HttpBody, HttpBody> postResourceCallable;
  private final UnaryCallable<HttpBody, HttpBody> deleteResourceCallable;
  private final UnaryCallable<HttpBody, HttpBody> putResourceCallable;
  private final UnaryCallable<HttpBody, HttpBody> patchResourceCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcGatewayServiceStub create(GatewayServiceStubSettings settings)
      throws IOException {
    return new GrpcGatewayServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcGatewayServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcGatewayServiceStub(
        GatewayServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcGatewayServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcGatewayServiceStub(
        GatewayServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcGatewayServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcGatewayServiceStub(GatewayServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcGatewayServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcGatewayServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcGatewayServiceStub(
      GatewayServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<HttpBody, HttpBody> getResourceTransportSettings =
        GrpcCallSettings.<HttpBody, HttpBody>newBuilder()
            .setMethodDescriptor(getResourceMethodDescriptor)
            .build();
    GrpcCallSettings<HttpBody, HttpBody> postResourceTransportSettings =
        GrpcCallSettings.<HttpBody, HttpBody>newBuilder()
            .setMethodDescriptor(postResourceMethodDescriptor)
            .build();
    GrpcCallSettings<HttpBody, HttpBody> deleteResourceTransportSettings =
        GrpcCallSettings.<HttpBody, HttpBody>newBuilder()
            .setMethodDescriptor(deleteResourceMethodDescriptor)
            .build();
    GrpcCallSettings<HttpBody, HttpBody> putResourceTransportSettings =
        GrpcCallSettings.<HttpBody, HttpBody>newBuilder()
            .setMethodDescriptor(putResourceMethodDescriptor)
            .build();
    GrpcCallSettings<HttpBody, HttpBody> patchResourceTransportSettings =
        GrpcCallSettings.<HttpBody, HttpBody>newBuilder()
            .setMethodDescriptor(patchResourceMethodDescriptor)
            .build();

    this.getResourceCallable =
        callableFactory.createUnaryCallable(
            getResourceTransportSettings, settings.getResourceSettings(), clientContext);
    this.postResourceCallable =
        callableFactory.createUnaryCallable(
            postResourceTransportSettings, settings.postResourceSettings(), clientContext);
    this.deleteResourceCallable =
        callableFactory.createUnaryCallable(
            deleteResourceTransportSettings, settings.deleteResourceSettings(), clientContext);
    this.putResourceCallable =
        callableFactory.createUnaryCallable(
            putResourceTransportSettings, settings.putResourceSettings(), clientContext);
    this.patchResourceCallable =
        callableFactory.createUnaryCallable(
            patchResourceTransportSettings, settings.patchResourceSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<HttpBody, HttpBody> getResourceCallable() {
    return getResourceCallable;
  }

  @Override
  public UnaryCallable<HttpBody, HttpBody> postResourceCallable() {
    return postResourceCallable;
  }

  @Override
  public UnaryCallable<HttpBody, HttpBody> deleteResourceCallable() {
    return deleteResourceCallable;
  }

  @Override
  public UnaryCallable<HttpBody, HttpBody> putResourceCallable() {
    return putResourceCallable;
  }

  @Override
  public UnaryCallable<HttpBody, HttpBody> patchResourceCallable() {
    return patchResourceCallable;
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
