/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.vision.v1p1beta1.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.vision.v1p1beta1.BatchAnnotateImagesRequest;
import com.google.cloud.vision.v1p1beta1.BatchAnnotateImagesResponse;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * gRPC stub implementation for Google Cloud Vision API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by GAPIC v0.0.5")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class GrpcImageAnnotatorStub extends ImageAnnotatorStub {

  private static final MethodDescriptor<BatchAnnotateImagesRequest, BatchAnnotateImagesResponse>
      batchAnnotateImagesMethodDescriptor =
          MethodDescriptor.<BatchAnnotateImagesRequest, BatchAnnotateImagesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vision.v1p1beta1.ImageAnnotator/BatchAnnotateImages")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchAnnotateImagesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(BatchAnnotateImagesResponse.getDefaultInstance()))
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<BatchAnnotateImagesRequest, BatchAnnotateImagesResponse>
      batchAnnotateImagesCallable;

  public static final GrpcImageAnnotatorStub create(ImageAnnotatorStubSettings settings)
      throws IOException {
    return new GrpcImageAnnotatorStub(settings, ClientContext.create(settings));
  }

  public static final GrpcImageAnnotatorStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcImageAnnotatorStub(
        ImageAnnotatorStubSettings.newBuilder().build(), clientContext);
  }

  /**
   * Constructs an instance of GrpcImageAnnotatorStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcImageAnnotatorStub(ImageAnnotatorStubSettings settings, ClientContext clientContext)
      throws IOException {

    GrpcCallSettings<BatchAnnotateImagesRequest, BatchAnnotateImagesResponse>
        batchAnnotateImagesTransportSettings =
            GrpcCallSettings.<BatchAnnotateImagesRequest, BatchAnnotateImagesResponse>newBuilder()
                .setMethodDescriptor(batchAnnotateImagesMethodDescriptor)
                .build();

    this.batchAnnotateImagesCallable =
        GrpcCallableFactory.createUnaryCallable(
            batchAnnotateImagesTransportSettings,
            settings.batchAnnotateImagesSettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public UnaryCallable<BatchAnnotateImagesRequest, BatchAnnotateImagesResponse>
      batchAnnotateImagesCallable() {
    return batchAnnotateImagesCallable;
  }

  @Override
  public final void close() throws Exception {
    shutdown();
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
