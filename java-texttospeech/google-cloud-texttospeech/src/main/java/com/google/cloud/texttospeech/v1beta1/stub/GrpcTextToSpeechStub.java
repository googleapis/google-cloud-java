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

package com.google.cloud.texttospeech.v1beta1.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.texttospeech.v1beta1.ListVoicesRequest;
import com.google.cloud.texttospeech.v1beta1.ListVoicesResponse;
import com.google.cloud.texttospeech.v1beta1.SynthesizeSpeechRequest;
import com.google.cloud.texttospeech.v1beta1.SynthesizeSpeechResponse;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the TextToSpeech service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcTextToSpeechStub extends TextToSpeechStub {
  private static final MethodDescriptor<ListVoicesRequest, ListVoicesResponse>
      listVoicesMethodDescriptor =
          MethodDescriptor.<ListVoicesRequest, ListVoicesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.texttospeech.v1beta1.TextToSpeech/ListVoices")
              .setRequestMarshaller(ProtoUtils.marshaller(ListVoicesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListVoicesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SynthesizeSpeechRequest, SynthesizeSpeechResponse>
      synthesizeSpeechMethodDescriptor =
          MethodDescriptor.<SynthesizeSpeechRequest, SynthesizeSpeechResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.texttospeech.v1beta1.TextToSpeech/SynthesizeSpeech")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SynthesizeSpeechRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SynthesizeSpeechResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListVoicesRequest, ListVoicesResponse> listVoicesCallable;
  private final UnaryCallable<SynthesizeSpeechRequest, SynthesizeSpeechResponse>
      synthesizeSpeechCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcTextToSpeechStub create(TextToSpeechStubSettings settings)
      throws IOException {
    return new GrpcTextToSpeechStub(settings, ClientContext.create(settings));
  }

  public static final GrpcTextToSpeechStub create(ClientContext clientContext) throws IOException {
    return new GrpcTextToSpeechStub(TextToSpeechStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcTextToSpeechStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcTextToSpeechStub(
        TextToSpeechStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcTextToSpeechStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcTextToSpeechStub(TextToSpeechStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcTextToSpeechCallableFactory());
  }

  /**
   * Constructs an instance of GrpcTextToSpeechStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcTextToSpeechStub(
      TextToSpeechStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListVoicesRequest, ListVoicesResponse> listVoicesTransportSettings =
        GrpcCallSettings.<ListVoicesRequest, ListVoicesResponse>newBuilder()
            .setMethodDescriptor(listVoicesMethodDescriptor)
            .build();
    GrpcCallSettings<SynthesizeSpeechRequest, SynthesizeSpeechResponse>
        synthesizeSpeechTransportSettings =
            GrpcCallSettings.<SynthesizeSpeechRequest, SynthesizeSpeechResponse>newBuilder()
                .setMethodDescriptor(synthesizeSpeechMethodDescriptor)
                .build();

    this.listVoicesCallable =
        callableFactory.createUnaryCallable(
            listVoicesTransportSettings, settings.listVoicesSettings(), clientContext);
    this.synthesizeSpeechCallable =
        callableFactory.createUnaryCallable(
            synthesizeSpeechTransportSettings, settings.synthesizeSpeechSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListVoicesRequest, ListVoicesResponse> listVoicesCallable() {
    return listVoicesCallable;
  }

  @Override
  public UnaryCallable<SynthesizeSpeechRequest, SynthesizeSpeechResponse>
      synthesizeSpeechCallable() {
    return synthesizeSpeechCallable;
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
