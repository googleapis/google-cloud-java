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

package com.google.cloud.texttospeech.v1beta1.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.texttospeech.v1beta1.SynthesizeLongAudioMetadata;
import com.google.cloud.texttospeech.v1beta1.SynthesizeLongAudioRequest;
import com.google.cloud.texttospeech.v1beta1.SynthesizeLongAudioResponse;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the TextToSpeechLongAudioSynthesize service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcTextToSpeechLongAudioSynthesizeStub extends TextToSpeechLongAudioSynthesizeStub {
  private static final MethodDescriptor<SynthesizeLongAudioRequest, Operation>
      synthesizeLongAudioMethodDescriptor =
          MethodDescriptor.<SynthesizeLongAudioRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.texttospeech.v1beta1.TextToSpeechLongAudioSynthesize/SynthesizeLongAudio")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SynthesizeLongAudioRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private final UnaryCallable<SynthesizeLongAudioRequest, Operation> synthesizeLongAudioCallable;
  private final OperationCallable<
          SynthesizeLongAudioRequest, SynthesizeLongAudioResponse, SynthesizeLongAudioMetadata>
      synthesizeLongAudioOperationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcTextToSpeechLongAudioSynthesizeStub create(
      TextToSpeechLongAudioSynthesizeStubSettings settings) throws IOException {
    return new GrpcTextToSpeechLongAudioSynthesizeStub(settings, ClientContext.create(settings));
  }

  public static final GrpcTextToSpeechLongAudioSynthesizeStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcTextToSpeechLongAudioSynthesizeStub(
        TextToSpeechLongAudioSynthesizeStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcTextToSpeechLongAudioSynthesizeStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcTextToSpeechLongAudioSynthesizeStub(
        TextToSpeechLongAudioSynthesizeStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of GrpcTextToSpeechLongAudioSynthesizeStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected GrpcTextToSpeechLongAudioSynthesizeStub(
      TextToSpeechLongAudioSynthesizeStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcTextToSpeechLongAudioSynthesizeCallableFactory());
  }

  /**
   * Constructs an instance of GrpcTextToSpeechLongAudioSynthesizeStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected GrpcTextToSpeechLongAudioSynthesizeStub(
      TextToSpeechLongAudioSynthesizeStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<SynthesizeLongAudioRequest, Operation> synthesizeLongAudioTransportSettings =
        GrpcCallSettings.<SynthesizeLongAudioRequest, Operation>newBuilder()
            .setMethodDescriptor(synthesizeLongAudioMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();

    this.synthesizeLongAudioCallable =
        callableFactory.createUnaryCallable(
            synthesizeLongAudioTransportSettings,
            settings.synthesizeLongAudioSettings(),
            clientContext);
    this.synthesizeLongAudioOperationCallable =
        callableFactory.createOperationCallable(
            synthesizeLongAudioTransportSettings,
            settings.synthesizeLongAudioOperationSettings(),
            clientContext,
            operationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<SynthesizeLongAudioRequest, Operation> synthesizeLongAudioCallable() {
    return synthesizeLongAudioCallable;
  }

  @Override
  public OperationCallable<
          SynthesizeLongAudioRequest, SynthesizeLongAudioResponse, SynthesizeLongAudioMetadata>
      synthesizeLongAudioOperationCallable() {
    return synthesizeLongAudioOperationCallable;
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
