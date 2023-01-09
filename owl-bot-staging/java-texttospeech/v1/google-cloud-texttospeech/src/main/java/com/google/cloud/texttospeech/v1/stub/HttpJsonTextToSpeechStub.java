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

package com.google.cloud.texttospeech.v1.stub;

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.texttospeech.v1.ListVoicesRequest;
import com.google.cloud.texttospeech.v1.ListVoicesResponse;
import com.google.cloud.texttospeech.v1.SynthesizeSpeechRequest;
import com.google.cloud.texttospeech.v1.SynthesizeSpeechResponse;
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
 * REST stub implementation for the TextToSpeech service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonTextToSpeechStub extends TextToSpeechStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<ListVoicesRequest, ListVoicesResponse>
      listVoicesMethodDescriptor =
          ApiMethodDescriptor.<ListVoicesRequest, ListVoicesResponse>newBuilder()
              .setFullMethodName("google.cloud.texttospeech.v1.TextToSpeech/ListVoices")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListVoicesRequest>newBuilder()
                      .setPath(
                          "/v1/voices",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListVoicesRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListVoicesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "languageCode", request.getLanguageCode());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListVoicesResponse>newBuilder()
                      .setDefaultInstance(ListVoicesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SynthesizeSpeechRequest, SynthesizeSpeechResponse>
      synthesizeSpeechMethodDescriptor =
          ApiMethodDescriptor.<SynthesizeSpeechRequest, SynthesizeSpeechResponse>newBuilder()
              .setFullMethodName("google.cloud.texttospeech.v1.TextToSpeech/SynthesizeSpeech")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SynthesizeSpeechRequest>newBuilder()
                      .setPath(
                          "/v1/text:synthesize",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SynthesizeSpeechRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SynthesizeSpeechRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SynthesizeSpeechResponse>newBuilder()
                      .setDefaultInstance(SynthesizeSpeechResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<ListVoicesRequest, ListVoicesResponse> listVoicesCallable;
  private final UnaryCallable<SynthesizeSpeechRequest, SynthesizeSpeechResponse>
      synthesizeSpeechCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonTextToSpeechStub create(TextToSpeechStubSettings settings)
      throws IOException {
    return new HttpJsonTextToSpeechStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonTextToSpeechStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonTextToSpeechStub(
        TextToSpeechStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonTextToSpeechStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonTextToSpeechStub(
        TextToSpeechStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonTextToSpeechStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonTextToSpeechStub(TextToSpeechStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonTextToSpeechCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonTextToSpeechStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonTextToSpeechStub(
      TextToSpeechStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<ListVoicesRequest, ListVoicesResponse> listVoicesTransportSettings =
        HttpJsonCallSettings.<ListVoicesRequest, ListVoicesResponse>newBuilder()
            .setMethodDescriptor(listVoicesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<SynthesizeSpeechRequest, SynthesizeSpeechResponse>
        synthesizeSpeechTransportSettings =
            HttpJsonCallSettings.<SynthesizeSpeechRequest, SynthesizeSpeechResponse>newBuilder()
                .setMethodDescriptor(synthesizeSpeechMethodDescriptor)
                .setTypeRegistry(typeRegistry)
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

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listVoicesMethodDescriptor);
    methodDescriptors.add(synthesizeSpeechMethodDescriptor);
    return methodDescriptors;
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
