/*
 * Copyright 2017, Google LLC All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.videointelligence.v1beta2.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.videointelligence.v1beta2.AnnotateVideoProgress;
import com.google.cloud.videointelligence.v1beta2.AnnotateVideoRequest;
import com.google.cloud.videointelligence.v1beta2.AnnotateVideoResponse;
import com.google.cloud.videointelligence.v1beta2.VideoIntelligenceServiceSettings;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * gRPC stub implementation for Google Cloud Video Intelligence API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by GAPIC v0.0.5")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class GrpcVideoIntelligenceServiceStub extends VideoIntelligenceServiceStub {

  private static final MethodDescriptor<AnnotateVideoRequest, Operation>
      annotateVideoMethodDescriptor =
          MethodDescriptor.<AnnotateVideoRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.videointelligence.v1beta2.VideoIntelligenceService/AnnotateVideo")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(AnnotateVideoRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;

  private final UnaryCallable<AnnotateVideoRequest, Operation> annotateVideoCallable;
  private final OperationCallable<
          AnnotateVideoRequest, AnnotateVideoResponse, AnnotateVideoProgress>
      annotateVideoOperationCallable;

  public static final GrpcVideoIntelligenceServiceStub create(
      VideoIntelligenceServiceSettings settings) throws IOException {
    return new GrpcVideoIntelligenceServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcVideoIntelligenceServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcVideoIntelligenceServiceStub(
        VideoIntelligenceServiceSettings.newBuilder().build(), clientContext);
  }

  /**
   * Constructs an instance of GrpcVideoIntelligenceServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcVideoIntelligenceServiceStub(
      VideoIntelligenceServiceSettings settings, ClientContext clientContext) throws IOException {
    this.operationsStub = GrpcOperationsStub.create(clientContext);

    GrpcCallSettings<AnnotateVideoRequest, Operation> annotateVideoTransportSettings =
        GrpcCallSettings.<AnnotateVideoRequest, Operation>newBuilder()
            .setMethodDescriptor(annotateVideoMethodDescriptor)
            .build();

    this.annotateVideoCallable =
        GrpcCallableFactory.createUnaryCallable(
            annotateVideoTransportSettings, settings.annotateVideoSettings(), clientContext);
    this.annotateVideoOperationCallable =
        GrpcCallableFactory.createOperationCallable(
            annotateVideoTransportSettings,
            settings.annotateVideoOperationSettings(),
            clientContext,
            this.operationsStub);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  public OperationCallable<AnnotateVideoRequest, AnnotateVideoResponse, AnnotateVideoProgress>
      annotateVideoOperationCallable() {
    return annotateVideoOperationCallable;
  }

  public UnaryCallable<AnnotateVideoRequest, Operation> annotateVideoCallable() {
    return annotateVideoCallable;
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
