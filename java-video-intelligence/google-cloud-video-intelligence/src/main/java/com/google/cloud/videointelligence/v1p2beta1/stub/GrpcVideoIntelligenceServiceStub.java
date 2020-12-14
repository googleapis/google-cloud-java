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

package com.google.cloud.videointelligence.v1p2beta1.stub;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.videointelligence.v1p2beta1.AnnotateVideoProgress;
import com.google.cloud.videointelligence.v1p2beta1.AnnotateVideoRequest;
import com.google.cloud.videointelligence.v1p2beta1.AnnotateVideoResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the VideoIntelligenceService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcVideoIntelligenceServiceStub extends VideoIntelligenceServiceStub {
  private static final MethodDescriptor<AnnotateVideoRequest, Operation>
      annotateVideoMethodDescriptor =
          MethodDescriptor.<AnnotateVideoRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.videointelligence.v1p2beta1.VideoIntelligenceService/AnnotateVideo")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(AnnotateVideoRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private final UnaryCallable<AnnotateVideoRequest, Operation> annotateVideoCallable;
  private final OperationCallable<
          AnnotateVideoRequest, AnnotateVideoResponse, AnnotateVideoProgress>
      annotateVideoOperationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcVideoIntelligenceServiceStub create(
      VideoIntelligenceServiceStubSettings settings) throws IOException {
    return new GrpcVideoIntelligenceServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcVideoIntelligenceServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcVideoIntelligenceServiceStub(
        VideoIntelligenceServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcVideoIntelligenceServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcVideoIntelligenceServiceStub(
        VideoIntelligenceServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcVideoIntelligenceServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcVideoIntelligenceServiceStub(
      VideoIntelligenceServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcVideoIntelligenceServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcVideoIntelligenceServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcVideoIntelligenceServiceStub(
      VideoIntelligenceServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<AnnotateVideoRequest, Operation> annotateVideoTransportSettings =
        GrpcCallSettings.<AnnotateVideoRequest, Operation>newBuilder()
            .setMethodDescriptor(annotateVideoMethodDescriptor)
            .build();

    this.annotateVideoCallable =
        callableFactory.createUnaryCallable(
            annotateVideoTransportSettings, settings.annotateVideoSettings(), clientContext);
    this.annotateVideoOperationCallable =
        callableFactory.createOperationCallable(
            annotateVideoTransportSettings,
            settings.annotateVideoOperationSettings(),
            clientContext,
            operationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  public UnaryCallable<AnnotateVideoRequest, Operation> annotateVideoCallable() {
    return annotateVideoCallable;
  }

  public OperationCallable<AnnotateVideoRequest, AnnotateVideoResponse, AnnotateVideoProgress>
      annotateVideoOperationCallable() {
    return annotateVideoOperationCallable;
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
