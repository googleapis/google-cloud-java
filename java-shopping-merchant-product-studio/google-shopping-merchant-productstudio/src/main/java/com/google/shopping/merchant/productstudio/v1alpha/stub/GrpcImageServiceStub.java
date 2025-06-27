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

package com.google.shopping.merchant.productstudio.v1alpha.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.shopping.merchant.productstudio.v1alpha.GenerateProductImageBackgroundRequest;
import com.google.shopping.merchant.productstudio.v1alpha.GenerateProductImageBackgroundResponse;
import com.google.shopping.merchant.productstudio.v1alpha.RemoveProductImageBackgroundRequest;
import com.google.shopping.merchant.productstudio.v1alpha.RemoveProductImageBackgroundResponse;
import com.google.shopping.merchant.productstudio.v1alpha.UpscaleProductImageRequest;
import com.google.shopping.merchant.productstudio.v1alpha.UpscaleProductImageResponse;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the ImageService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcImageServiceStub extends ImageServiceStub {
  private static final MethodDescriptor<
          GenerateProductImageBackgroundRequest, GenerateProductImageBackgroundResponse>
      generateProductImageBackgroundMethodDescriptor =
          MethodDescriptor
              .<GenerateProductImageBackgroundRequest, GenerateProductImageBackgroundResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.productstudio.v1alpha.ImageService/GenerateProductImageBackground")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GenerateProductImageBackgroundRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      GenerateProductImageBackgroundResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          RemoveProductImageBackgroundRequest, RemoveProductImageBackgroundResponse>
      removeProductImageBackgroundMethodDescriptor =
          MethodDescriptor
              .<RemoveProductImageBackgroundRequest, RemoveProductImageBackgroundResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.productstudio.v1alpha.ImageService/RemoveProductImageBackground")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RemoveProductImageBackgroundRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(RemoveProductImageBackgroundResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpscaleProductImageRequest, UpscaleProductImageResponse>
      upscaleProductImageMethodDescriptor =
          MethodDescriptor.<UpscaleProductImageRequest, UpscaleProductImageResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.productstudio.v1alpha.ImageService/UpscaleProductImage")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpscaleProductImageRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(UpscaleProductImageResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<
          GenerateProductImageBackgroundRequest, GenerateProductImageBackgroundResponse>
      generateProductImageBackgroundCallable;
  private final UnaryCallable<
          RemoveProductImageBackgroundRequest, RemoveProductImageBackgroundResponse>
      removeProductImageBackgroundCallable;
  private final UnaryCallable<UpscaleProductImageRequest, UpscaleProductImageResponse>
      upscaleProductImageCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcImageServiceStub create(ImageServiceStubSettings settings)
      throws IOException {
    return new GrpcImageServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcImageServiceStub create(ClientContext clientContext) throws IOException {
    return new GrpcImageServiceStub(ImageServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcImageServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcImageServiceStub(
        ImageServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcImageServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcImageServiceStub(ImageServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcImageServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcImageServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcImageServiceStub(
      ImageServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GenerateProductImageBackgroundRequest, GenerateProductImageBackgroundResponse>
        generateProductImageBackgroundTransportSettings =
            GrpcCallSettings
                .<GenerateProductImageBackgroundRequest, GenerateProductImageBackgroundResponse>
                    newBuilder()
                .setMethodDescriptor(generateProductImageBackgroundMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<RemoveProductImageBackgroundRequest, RemoveProductImageBackgroundResponse>
        removeProductImageBackgroundTransportSettings =
            GrpcCallSettings
                .<RemoveProductImageBackgroundRequest, RemoveProductImageBackgroundResponse>
                    newBuilder()
                .setMethodDescriptor(removeProductImageBackgroundMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpscaleProductImageRequest, UpscaleProductImageResponse>
        upscaleProductImageTransportSettings =
            GrpcCallSettings.<UpscaleProductImageRequest, UpscaleProductImageResponse>newBuilder()
                .setMethodDescriptor(upscaleProductImageMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();

    this.generateProductImageBackgroundCallable =
        callableFactory.createUnaryCallable(
            generateProductImageBackgroundTransportSettings,
            settings.generateProductImageBackgroundSettings(),
            clientContext);
    this.removeProductImageBackgroundCallable =
        callableFactory.createUnaryCallable(
            removeProductImageBackgroundTransportSettings,
            settings.removeProductImageBackgroundSettings(),
            clientContext);
    this.upscaleProductImageCallable =
        callableFactory.createUnaryCallable(
            upscaleProductImageTransportSettings,
            settings.upscaleProductImageSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<
          GenerateProductImageBackgroundRequest, GenerateProductImageBackgroundResponse>
      generateProductImageBackgroundCallable() {
    return generateProductImageBackgroundCallable;
  }

  @Override
  public UnaryCallable<RemoveProductImageBackgroundRequest, RemoveProductImageBackgroundResponse>
      removeProductImageBackgroundCallable() {
    return removeProductImageBackgroundCallable;
  }

  @Override
  public UnaryCallable<UpscaleProductImageRequest, UpscaleProductImageResponse>
      upscaleProductImageCallable() {
    return upscaleProductImageCallable;
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
