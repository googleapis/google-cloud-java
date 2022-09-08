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

package com.google.cloud.speech.v1.stub;

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
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.speech.v1.LongRunningRecognizeMetadata;
import com.google.cloud.speech.v1.LongRunningRecognizeRequest;
import com.google.cloud.speech.v1.LongRunningRecognizeResponse;
import com.google.cloud.speech.v1.RecognizeRequest;
import com.google.cloud.speech.v1.RecognizeResponse;
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
 * REST stub implementation for the Speech service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonSpeechStub extends SpeechStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(LongRunningRecognizeResponse.getDescriptor())
          .add(LongRunningRecognizeMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<RecognizeRequest, RecognizeResponse>
      recognizeMethodDescriptor =
          ApiMethodDescriptor.<RecognizeRequest, RecognizeResponse>newBuilder()
              .setFullMethodName("google.cloud.speech.v1.Speech/Recognize")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RecognizeRequest>newBuilder()
                      .setPath(
                          "/v1/speech:recognize",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RecognizeRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RecognizeRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RecognizeResponse>newBuilder()
                      .setDefaultInstance(RecognizeResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<LongRunningRecognizeRequest, Operation>
      longRunningRecognizeMethodDescriptor =
          ApiMethodDescriptor.<LongRunningRecognizeRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.speech.v1.Speech/LongRunningRecognize")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<LongRunningRecognizeRequest>newBuilder()
                      .setPath(
                          "/v1/speech:longrunningrecognize",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<LongRunningRecognizeRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<LongRunningRecognizeRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (LongRunningRecognizeRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private final UnaryCallable<RecognizeRequest, RecognizeResponse> recognizeCallable;
  private final UnaryCallable<LongRunningRecognizeRequest, Operation> longRunningRecognizeCallable;
  private final OperationCallable<
          LongRunningRecognizeRequest, LongRunningRecognizeResponse, LongRunningRecognizeMetadata>
      longRunningRecognizeOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonSpeechStub create(SpeechStubSettings settings) throws IOException {
    return new HttpJsonSpeechStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonSpeechStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonSpeechStub(SpeechStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonSpeechStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonSpeechStub(
        SpeechStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonSpeechStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonSpeechStub(SpeechStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonSpeechCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonSpeechStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonSpeechStub(
      SpeechStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<RecognizeRequest, RecognizeResponse> recognizeTransportSettings =
        HttpJsonCallSettings.<RecognizeRequest, RecognizeResponse>newBuilder()
            .setMethodDescriptor(recognizeMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<LongRunningRecognizeRequest, Operation>
        longRunningRecognizeTransportSettings =
            HttpJsonCallSettings.<LongRunningRecognizeRequest, Operation>newBuilder()
                .setMethodDescriptor(longRunningRecognizeMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.recognizeCallable =
        callableFactory.createUnaryCallable(
            recognizeTransportSettings, settings.recognizeSettings(), clientContext);
    this.longRunningRecognizeCallable =
        callableFactory.createUnaryCallable(
            longRunningRecognizeTransportSettings,
            settings.longRunningRecognizeSettings(),
            clientContext);
    this.longRunningRecognizeOperationCallable =
        callableFactory.createOperationCallable(
            longRunningRecognizeTransportSettings,
            settings.longRunningRecognizeOperationSettings(),
            clientContext,
            httpJsonOperationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(recognizeMethodDescriptor);
    methodDescriptors.add(longRunningRecognizeMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<RecognizeRequest, RecognizeResponse> recognizeCallable() {
    return recognizeCallable;
  }

  @Override
  public UnaryCallable<LongRunningRecognizeRequest, Operation> longRunningRecognizeCallable() {
    return longRunningRecognizeCallable;
  }

  @Override
  public OperationCallable<
          LongRunningRecognizeRequest, LongRunningRecognizeResponse, LongRunningRecognizeMetadata>
      longRunningRecognizeOperationCallable() {
    return longRunningRecognizeOperationCallable;
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
