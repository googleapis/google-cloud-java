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
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonOperationSnapshot;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.httpjson.longrunning.stub.HttpJsonOperationsStub;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.texttospeech.v1beta1.SynthesizeLongAudioMetadata;
import com.google.cloud.texttospeech.v1beta1.SynthesizeLongAudioRequest;
import com.google.cloud.texttospeech.v1beta1.SynthesizeLongAudioResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the TextToSpeechLongAudioSynthesize service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonTextToSpeechLongAudioSynthesizeStub
    extends TextToSpeechLongAudioSynthesizeStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(SynthesizeLongAudioResponse.getDescriptor())
          .add(SynthesizeLongAudioMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<SynthesizeLongAudioRequest, Operation>
      synthesizeLongAudioMethodDescriptor =
          ApiMethodDescriptor.<SynthesizeLongAudioRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.texttospeech.v1beta1.TextToSpeechLongAudioSynthesize/SynthesizeLongAudio")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SynthesizeLongAudioRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*/voices/*}:SynthesizeLongAudio",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SynthesizeLongAudioRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SynthesizeLongAudioRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (SynthesizeLongAudioRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private final UnaryCallable<SynthesizeLongAudioRequest, Operation> synthesizeLongAudioCallable;
  private final OperationCallable<
          SynthesizeLongAudioRequest, SynthesizeLongAudioResponse, SynthesizeLongAudioMetadata>
      synthesizeLongAudioOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonTextToSpeechLongAudioSynthesizeStub create(
      TextToSpeechLongAudioSynthesizeStubSettings settings) throws IOException {
    return new HttpJsonTextToSpeechLongAudioSynthesizeStub(
        settings, ClientContext.create(settings));
  }

  public static final HttpJsonTextToSpeechLongAudioSynthesizeStub create(
      ClientContext clientContext) throws IOException {
    return new HttpJsonTextToSpeechLongAudioSynthesizeStub(
        TextToSpeechLongAudioSynthesizeStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonTextToSpeechLongAudioSynthesizeStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonTextToSpeechLongAudioSynthesizeStub(
        TextToSpeechLongAudioSynthesizeStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonTextToSpeechLongAudioSynthesizeStub, using the given
   * settings. This is protected so that it is easy to make a subclass, but otherwise, the static
   * factory methods should be preferred.
   */
  protected HttpJsonTextToSpeechLongAudioSynthesizeStub(
      TextToSpeechLongAudioSynthesizeStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonTextToSpeechLongAudioSynthesizeCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonTextToSpeechLongAudioSynthesizeStub, using the given
   * settings. This is protected so that it is easy to make a subclass, but otherwise, the static
   * factory methods should be preferred.
   */
  protected HttpJsonTextToSpeechLongAudioSynthesizeStub(
      TextToSpeechLongAudioSynthesizeStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<SynthesizeLongAudioRequest, Operation>
        synthesizeLongAudioTransportSettings =
            HttpJsonCallSettings.<SynthesizeLongAudioRequest, Operation>newBuilder()
                .setMethodDescriptor(synthesizeLongAudioMethodDescriptor)
                .setTypeRegistry(typeRegistry)
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
            httpJsonOperationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(synthesizeLongAudioMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
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
