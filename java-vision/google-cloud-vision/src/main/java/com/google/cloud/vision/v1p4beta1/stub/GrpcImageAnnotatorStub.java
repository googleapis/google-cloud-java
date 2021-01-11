/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.vision.v1p4beta1.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.vision.v1p4beta1.AsyncBatchAnnotateFilesRequest;
import com.google.cloud.vision.v1p4beta1.AsyncBatchAnnotateFilesResponse;
import com.google.cloud.vision.v1p4beta1.AsyncBatchAnnotateImagesRequest;
import com.google.cloud.vision.v1p4beta1.AsyncBatchAnnotateImagesResponse;
import com.google.cloud.vision.v1p4beta1.BatchAnnotateFilesRequest;
import com.google.cloud.vision.v1p4beta1.BatchAnnotateFilesResponse;
import com.google.cloud.vision.v1p4beta1.BatchAnnotateImagesRequest;
import com.google.cloud.vision.v1p4beta1.BatchAnnotateImagesResponse;
import com.google.cloud.vision.v1p4beta1.OperationMetadata;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the ImageAnnotator service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcImageAnnotatorStub extends ImageAnnotatorStub {
  private static final MethodDescriptor<BatchAnnotateImagesRequest, BatchAnnotateImagesResponse>
      batchAnnotateImagesMethodDescriptor =
          MethodDescriptor.<BatchAnnotateImagesRequest, BatchAnnotateImagesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vision.v1p4beta1.ImageAnnotator/BatchAnnotateImages")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchAnnotateImagesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(BatchAnnotateImagesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<BatchAnnotateFilesRequest, BatchAnnotateFilesResponse>
      batchAnnotateFilesMethodDescriptor =
          MethodDescriptor.<BatchAnnotateFilesRequest, BatchAnnotateFilesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vision.v1p4beta1.ImageAnnotator/BatchAnnotateFiles")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchAnnotateFilesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(BatchAnnotateFilesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<AsyncBatchAnnotateImagesRequest, Operation>
      asyncBatchAnnotateImagesMethodDescriptor =
          MethodDescriptor.<AsyncBatchAnnotateImagesRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.vision.v1p4beta1.ImageAnnotator/AsyncBatchAnnotateImages")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(AsyncBatchAnnotateImagesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<AsyncBatchAnnotateFilesRequest, Operation>
      asyncBatchAnnotateFilesMethodDescriptor =
          MethodDescriptor.<AsyncBatchAnnotateFilesRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.vision.v1p4beta1.ImageAnnotator/AsyncBatchAnnotateFiles")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(AsyncBatchAnnotateFilesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private final UnaryCallable<BatchAnnotateImagesRequest, BatchAnnotateImagesResponse>
      batchAnnotateImagesCallable;
  private final UnaryCallable<BatchAnnotateFilesRequest, BatchAnnotateFilesResponse>
      batchAnnotateFilesCallable;
  private final UnaryCallable<AsyncBatchAnnotateImagesRequest, Operation>
      asyncBatchAnnotateImagesCallable;
  private final OperationCallable<
          AsyncBatchAnnotateImagesRequest, AsyncBatchAnnotateImagesResponse, OperationMetadata>
      asyncBatchAnnotateImagesOperationCallable;
  private final UnaryCallable<AsyncBatchAnnotateFilesRequest, Operation>
      asyncBatchAnnotateFilesCallable;
  private final OperationCallable<
          AsyncBatchAnnotateFilesRequest, AsyncBatchAnnotateFilesResponse, OperationMetadata>
      asyncBatchAnnotateFilesOperationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcImageAnnotatorStub create(ImageAnnotatorStubSettings settings)
      throws IOException {
    return new GrpcImageAnnotatorStub(settings, ClientContext.create(settings));
  }

  public static final GrpcImageAnnotatorStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcImageAnnotatorStub(
        ImageAnnotatorStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcImageAnnotatorStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcImageAnnotatorStub(
        ImageAnnotatorStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcImageAnnotatorStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcImageAnnotatorStub(ImageAnnotatorStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcImageAnnotatorCallableFactory());
  }

  /**
   * Constructs an instance of GrpcImageAnnotatorStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcImageAnnotatorStub(
      ImageAnnotatorStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<BatchAnnotateImagesRequest, BatchAnnotateImagesResponse>
        batchAnnotateImagesTransportSettings =
            GrpcCallSettings.<BatchAnnotateImagesRequest, BatchAnnotateImagesResponse>newBuilder()
                .setMethodDescriptor(batchAnnotateImagesMethodDescriptor)
                .build();
    GrpcCallSettings<BatchAnnotateFilesRequest, BatchAnnotateFilesResponse>
        batchAnnotateFilesTransportSettings =
            GrpcCallSettings.<BatchAnnotateFilesRequest, BatchAnnotateFilesResponse>newBuilder()
                .setMethodDescriptor(batchAnnotateFilesMethodDescriptor)
                .build();
    GrpcCallSettings<AsyncBatchAnnotateImagesRequest, Operation>
        asyncBatchAnnotateImagesTransportSettings =
            GrpcCallSettings.<AsyncBatchAnnotateImagesRequest, Operation>newBuilder()
                .setMethodDescriptor(asyncBatchAnnotateImagesMethodDescriptor)
                .build();
    GrpcCallSettings<AsyncBatchAnnotateFilesRequest, Operation>
        asyncBatchAnnotateFilesTransportSettings =
            GrpcCallSettings.<AsyncBatchAnnotateFilesRequest, Operation>newBuilder()
                .setMethodDescriptor(asyncBatchAnnotateFilesMethodDescriptor)
                .build();

    this.batchAnnotateImagesCallable =
        callableFactory.createUnaryCallable(
            batchAnnotateImagesTransportSettings,
            settings.batchAnnotateImagesSettings(),
            clientContext);
    this.batchAnnotateFilesCallable =
        callableFactory.createUnaryCallable(
            batchAnnotateFilesTransportSettings,
            settings.batchAnnotateFilesSettings(),
            clientContext);
    this.asyncBatchAnnotateImagesCallable =
        callableFactory.createUnaryCallable(
            asyncBatchAnnotateImagesTransportSettings,
            settings.asyncBatchAnnotateImagesSettings(),
            clientContext);
    this.asyncBatchAnnotateImagesOperationCallable =
        callableFactory.createOperationCallable(
            asyncBatchAnnotateImagesTransportSettings,
            settings.asyncBatchAnnotateImagesOperationSettings(),
            clientContext,
            operationsStub);
    this.asyncBatchAnnotateFilesCallable =
        callableFactory.createUnaryCallable(
            asyncBatchAnnotateFilesTransportSettings,
            settings.asyncBatchAnnotateFilesSettings(),
            clientContext);
    this.asyncBatchAnnotateFilesOperationCallable =
        callableFactory.createOperationCallable(
            asyncBatchAnnotateFilesTransportSettings,
            settings.asyncBatchAnnotateFilesOperationSettings(),
            clientContext,
            operationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  public UnaryCallable<BatchAnnotateImagesRequest, BatchAnnotateImagesResponse>
      batchAnnotateImagesCallable() {
    return batchAnnotateImagesCallable;
  }

  public UnaryCallable<BatchAnnotateFilesRequest, BatchAnnotateFilesResponse>
      batchAnnotateFilesCallable() {
    return batchAnnotateFilesCallable;
  }

  public UnaryCallable<AsyncBatchAnnotateImagesRequest, Operation>
      asyncBatchAnnotateImagesCallable() {
    return asyncBatchAnnotateImagesCallable;
  }

  public OperationCallable<
          AsyncBatchAnnotateImagesRequest, AsyncBatchAnnotateImagesResponse, OperationMetadata>
      asyncBatchAnnotateImagesOperationCallable() {
    return asyncBatchAnnotateImagesOperationCallable;
  }

  public UnaryCallable<AsyncBatchAnnotateFilesRequest, Operation>
      asyncBatchAnnotateFilesCallable() {
    return asyncBatchAnnotateFilesCallable;
  }

  public OperationCallable<
          AsyncBatchAnnotateFilesRequest, AsyncBatchAnnotateFilesResponse, OperationMetadata>
      asyncBatchAnnotateFilesOperationCallable() {
    return asyncBatchAnnotateFilesOperationCallable;
  }

  @Override
  public final void close() {
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
