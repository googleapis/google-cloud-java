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

package com.google.cloud.videointelligence.v1p3beta1.stub;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ClientContext;
import com.google.cloud.videointelligence.v1p3beta1.StreamingAnnotateVideoRequest;
import com.google.cloud.videointelligence.v1p3beta1.StreamingAnnotateVideoResponse;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the StreamingVideoIntelligenceService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcStreamingVideoIntelligenceServiceStub
    extends StreamingVideoIntelligenceServiceStub {
  private static final MethodDescriptor<
          StreamingAnnotateVideoRequest, StreamingAnnotateVideoResponse>
      streamingAnnotateVideoMethodDescriptor =
          MethodDescriptor
              .<StreamingAnnotateVideoRequest, StreamingAnnotateVideoResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(
                  "google.cloud.videointelligence.v1p3beta1.StreamingVideoIntelligenceService/StreamingAnnotateVideo")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(StreamingAnnotateVideoRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(StreamingAnnotateVideoResponse.getDefaultInstance()))
              .build();

  private final BidiStreamingCallable<StreamingAnnotateVideoRequest, StreamingAnnotateVideoResponse>
      streamingAnnotateVideoCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcStreamingVideoIntelligenceServiceStub create(
      StreamingVideoIntelligenceServiceStubSettings settings) throws IOException {
    return new GrpcStreamingVideoIntelligenceServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcStreamingVideoIntelligenceServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcStreamingVideoIntelligenceServiceStub(
        StreamingVideoIntelligenceServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcStreamingVideoIntelligenceServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcStreamingVideoIntelligenceServiceStub(
        StreamingVideoIntelligenceServiceStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of GrpcStreamingVideoIntelligenceServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected GrpcStreamingVideoIntelligenceServiceStub(
      StreamingVideoIntelligenceServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcStreamingVideoIntelligenceServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcStreamingVideoIntelligenceServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected GrpcStreamingVideoIntelligenceServiceStub(
      StreamingVideoIntelligenceServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<StreamingAnnotateVideoRequest, StreamingAnnotateVideoResponse>
        streamingAnnotateVideoTransportSettings =
            GrpcCallSettings
                .<StreamingAnnotateVideoRequest, StreamingAnnotateVideoResponse>newBuilder()
                .setMethodDescriptor(streamingAnnotateVideoMethodDescriptor)
                .build();

    this.streamingAnnotateVideoCallable =
        callableFactory.createBidiStreamingCallable(
            streamingAnnotateVideoTransportSettings,
            settings.streamingAnnotateVideoSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  public BidiStreamingCallable<StreamingAnnotateVideoRequest, StreamingAnnotateVideoResponse>
      streamingAnnotateVideoCallable() {
    return streamingAnnotateVideoCallable;
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
