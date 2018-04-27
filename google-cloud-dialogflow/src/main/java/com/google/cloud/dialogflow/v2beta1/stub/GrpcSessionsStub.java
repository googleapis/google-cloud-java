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
package com.google.cloud.dialogflow.v2beta1.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.v2beta1.DetectIntentRequest;
import com.google.cloud.dialogflow.v2beta1.DetectIntentResponse;
import com.google.cloud.dialogflow.v2beta1.StreamingDetectIntentRequest;
import com.google.cloud.dialogflow.v2beta1.StreamingDetectIntentResponse;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * gRPC stub implementation for Dialogflow API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class GrpcSessionsStub extends SessionsStub {

  private static final MethodDescriptor<DetectIntentRequest, DetectIntentResponse>
      detectIntentMethodDescriptor =
          MethodDescriptor.<DetectIntentRequest, DetectIntentResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.v2beta1.Sessions/DetectIntent")
              .setRequestMarshaller(ProtoUtils.marshaller(DetectIntentRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(DetectIntentResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<StreamingDetectIntentRequest, StreamingDetectIntentResponse>
      streamingDetectIntentMethodDescriptor =
          MethodDescriptor.<StreamingDetectIntentRequest, StreamingDetectIntentResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName("google.cloud.dialogflow.v2beta1.Sessions/StreamingDetectIntent")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(StreamingDetectIntentRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(StreamingDetectIntentResponse.getDefaultInstance()))
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<DetectIntentRequest, DetectIntentResponse> detectIntentCallable;
  private final BidiStreamingCallable<StreamingDetectIntentRequest, StreamingDetectIntentResponse>
      streamingDetectIntentCallable;

  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcSessionsStub create(SessionsStubSettings settings) throws IOException {
    return new GrpcSessionsStub(settings, ClientContext.create(settings));
  }

  public static final GrpcSessionsStub create(ClientContext clientContext) throws IOException {
    return new GrpcSessionsStub(SessionsStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcSessionsStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcSessionsStub(
        SessionsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcSessionsStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcSessionsStub(SessionsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcSessionsCallableFactory());
  }

  /**
   * Constructs an instance of GrpcSessionsStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcSessionsStub(
      SessionsStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    GrpcCallSettings<DetectIntentRequest, DetectIntentResponse> detectIntentTransportSettings =
        GrpcCallSettings.<DetectIntentRequest, DetectIntentResponse>newBuilder()
            .setMethodDescriptor(detectIntentMethodDescriptor)
            .build();
    GrpcCallSettings<StreamingDetectIntentRequest, StreamingDetectIntentResponse>
        streamingDetectIntentTransportSettings =
            GrpcCallSettings
                .<StreamingDetectIntentRequest, StreamingDetectIntentResponse>newBuilder()
                .setMethodDescriptor(streamingDetectIntentMethodDescriptor)
                .build();

    this.detectIntentCallable =
        callableFactory.createUnaryCallable(
            detectIntentTransportSettings, settings.detectIntentSettings(), clientContext);
    this.streamingDetectIntentCallable =
        callableFactory.createBidiStreamingCallable(
            streamingDetectIntentTransportSettings,
            settings.streamingDetectIntentSettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public UnaryCallable<DetectIntentRequest, DetectIntentResponse> detectIntentCallable() {
    return detectIntentCallable;
  }

  public BidiStreamingCallable<StreamingDetectIntentRequest, StreamingDetectIntentResponse>
      streamingDetectIntentCallable() {
    return streamingDetectIntentCallable;
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
