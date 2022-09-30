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

package com.google.cloud.language.v1beta2.stub;

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
import com.google.cloud.language.v1beta2.AnalyzeEntitiesRequest;
import com.google.cloud.language.v1beta2.AnalyzeEntitiesResponse;
import com.google.cloud.language.v1beta2.AnalyzeEntitySentimentRequest;
import com.google.cloud.language.v1beta2.AnalyzeEntitySentimentResponse;
import com.google.cloud.language.v1beta2.AnalyzeSentimentRequest;
import com.google.cloud.language.v1beta2.AnalyzeSentimentResponse;
import com.google.cloud.language.v1beta2.AnalyzeSyntaxRequest;
import com.google.cloud.language.v1beta2.AnalyzeSyntaxResponse;
import com.google.cloud.language.v1beta2.AnnotateTextRequest;
import com.google.cloud.language.v1beta2.AnnotateTextResponse;
import com.google.cloud.language.v1beta2.ClassifyTextRequest;
import com.google.cloud.language.v1beta2.ClassifyTextResponse;
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
 * REST stub implementation for the LanguageService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonLanguageServiceStub extends LanguageServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<AnalyzeSentimentRequest, AnalyzeSentimentResponse>
      analyzeSentimentMethodDescriptor =
          ApiMethodDescriptor.<AnalyzeSentimentRequest, AnalyzeSentimentResponse>newBuilder()
              .setFullMethodName("google.cloud.language.v1beta2.LanguageService/AnalyzeSentiment")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AnalyzeSentimentRequest>newBuilder()
                      .setPath(
                          "/v1beta2/documents:analyzeSentiment",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AnalyzeSentimentRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AnalyzeSentimentRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AnalyzeSentimentResponse>newBuilder()
                      .setDefaultInstance(AnalyzeSentimentResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<AnalyzeEntitiesRequest, AnalyzeEntitiesResponse>
      analyzeEntitiesMethodDescriptor =
          ApiMethodDescriptor.<AnalyzeEntitiesRequest, AnalyzeEntitiesResponse>newBuilder()
              .setFullMethodName("google.cloud.language.v1beta2.LanguageService/AnalyzeEntities")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AnalyzeEntitiesRequest>newBuilder()
                      .setPath(
                          "/v1beta2/documents:analyzeEntities",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AnalyzeEntitiesRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AnalyzeEntitiesRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AnalyzeEntitiesResponse>newBuilder()
                      .setDefaultInstance(AnalyzeEntitiesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          AnalyzeEntitySentimentRequest, AnalyzeEntitySentimentResponse>
      analyzeEntitySentimentMethodDescriptor =
          ApiMethodDescriptor
              .<AnalyzeEntitySentimentRequest, AnalyzeEntitySentimentResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.language.v1beta2.LanguageService/AnalyzeEntitySentiment")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AnalyzeEntitySentimentRequest>newBuilder()
                      .setPath(
                          "/v1beta2/documents:analyzeEntitySentiment",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AnalyzeEntitySentimentRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AnalyzeEntitySentimentRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AnalyzeEntitySentimentResponse>newBuilder()
                      .setDefaultInstance(AnalyzeEntitySentimentResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<AnalyzeSyntaxRequest, AnalyzeSyntaxResponse>
      analyzeSyntaxMethodDescriptor =
          ApiMethodDescriptor.<AnalyzeSyntaxRequest, AnalyzeSyntaxResponse>newBuilder()
              .setFullMethodName("google.cloud.language.v1beta2.LanguageService/AnalyzeSyntax")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AnalyzeSyntaxRequest>newBuilder()
                      .setPath(
                          "/v1beta2/documents:analyzeSyntax",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AnalyzeSyntaxRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AnalyzeSyntaxRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AnalyzeSyntaxResponse>newBuilder()
                      .setDefaultInstance(AnalyzeSyntaxResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ClassifyTextRequest, ClassifyTextResponse>
      classifyTextMethodDescriptor =
          ApiMethodDescriptor.<ClassifyTextRequest, ClassifyTextResponse>newBuilder()
              .setFullMethodName("google.cloud.language.v1beta2.LanguageService/ClassifyText")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ClassifyTextRequest>newBuilder()
                      .setPath(
                          "/v1beta2/documents:classifyText",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ClassifyTextRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ClassifyTextRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ClassifyTextResponse>newBuilder()
                      .setDefaultInstance(ClassifyTextResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<AnnotateTextRequest, AnnotateTextResponse>
      annotateTextMethodDescriptor =
          ApiMethodDescriptor.<AnnotateTextRequest, AnnotateTextResponse>newBuilder()
              .setFullMethodName("google.cloud.language.v1beta2.LanguageService/AnnotateText")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AnnotateTextRequest>newBuilder()
                      .setPath(
                          "/v1beta2/documents:annotateText",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AnnotateTextRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AnnotateTextRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AnnotateTextResponse>newBuilder()
                      .setDefaultInstance(AnnotateTextResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<AnalyzeSentimentRequest, AnalyzeSentimentResponse>
      analyzeSentimentCallable;
  private final UnaryCallable<AnalyzeEntitiesRequest, AnalyzeEntitiesResponse>
      analyzeEntitiesCallable;
  private final UnaryCallable<AnalyzeEntitySentimentRequest, AnalyzeEntitySentimentResponse>
      analyzeEntitySentimentCallable;
  private final UnaryCallable<AnalyzeSyntaxRequest, AnalyzeSyntaxResponse> analyzeSyntaxCallable;
  private final UnaryCallable<ClassifyTextRequest, ClassifyTextResponse> classifyTextCallable;
  private final UnaryCallable<AnnotateTextRequest, AnnotateTextResponse> annotateTextCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonLanguageServiceStub create(LanguageServiceStubSettings settings)
      throws IOException {
    return new HttpJsonLanguageServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonLanguageServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonLanguageServiceStub(
        LanguageServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonLanguageServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonLanguageServiceStub(
        LanguageServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonLanguageServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonLanguageServiceStub(
      LanguageServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonLanguageServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonLanguageServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonLanguageServiceStub(
      LanguageServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<AnalyzeSentimentRequest, AnalyzeSentimentResponse>
        analyzeSentimentTransportSettings =
            HttpJsonCallSettings.<AnalyzeSentimentRequest, AnalyzeSentimentResponse>newBuilder()
                .setMethodDescriptor(analyzeSentimentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<AnalyzeEntitiesRequest, AnalyzeEntitiesResponse>
        analyzeEntitiesTransportSettings =
            HttpJsonCallSettings.<AnalyzeEntitiesRequest, AnalyzeEntitiesResponse>newBuilder()
                .setMethodDescriptor(analyzeEntitiesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<AnalyzeEntitySentimentRequest, AnalyzeEntitySentimentResponse>
        analyzeEntitySentimentTransportSettings =
            HttpJsonCallSettings
                .<AnalyzeEntitySentimentRequest, AnalyzeEntitySentimentResponse>newBuilder()
                .setMethodDescriptor(analyzeEntitySentimentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<AnalyzeSyntaxRequest, AnalyzeSyntaxResponse>
        analyzeSyntaxTransportSettings =
            HttpJsonCallSettings.<AnalyzeSyntaxRequest, AnalyzeSyntaxResponse>newBuilder()
                .setMethodDescriptor(analyzeSyntaxMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ClassifyTextRequest, ClassifyTextResponse> classifyTextTransportSettings =
        HttpJsonCallSettings.<ClassifyTextRequest, ClassifyTextResponse>newBuilder()
            .setMethodDescriptor(classifyTextMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<AnnotateTextRequest, AnnotateTextResponse> annotateTextTransportSettings =
        HttpJsonCallSettings.<AnnotateTextRequest, AnnotateTextResponse>newBuilder()
            .setMethodDescriptor(annotateTextMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.analyzeSentimentCallable =
        callableFactory.createUnaryCallable(
            analyzeSentimentTransportSettings, settings.analyzeSentimentSettings(), clientContext);
    this.analyzeEntitiesCallable =
        callableFactory.createUnaryCallable(
            analyzeEntitiesTransportSettings, settings.analyzeEntitiesSettings(), clientContext);
    this.analyzeEntitySentimentCallable =
        callableFactory.createUnaryCallable(
            analyzeEntitySentimentTransportSettings,
            settings.analyzeEntitySentimentSettings(),
            clientContext);
    this.analyzeSyntaxCallable =
        callableFactory.createUnaryCallable(
            analyzeSyntaxTransportSettings, settings.analyzeSyntaxSettings(), clientContext);
    this.classifyTextCallable =
        callableFactory.createUnaryCallable(
            classifyTextTransportSettings, settings.classifyTextSettings(), clientContext);
    this.annotateTextCallable =
        callableFactory.createUnaryCallable(
            annotateTextTransportSettings, settings.annotateTextSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(analyzeSentimentMethodDescriptor);
    methodDescriptors.add(analyzeEntitiesMethodDescriptor);
    methodDescriptors.add(analyzeEntitySentimentMethodDescriptor);
    methodDescriptors.add(analyzeSyntaxMethodDescriptor);
    methodDescriptors.add(classifyTextMethodDescriptor);
    methodDescriptors.add(annotateTextMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<AnalyzeSentimentRequest, AnalyzeSentimentResponse>
      analyzeSentimentCallable() {
    return analyzeSentimentCallable;
  }

  @Override
  public UnaryCallable<AnalyzeEntitiesRequest, AnalyzeEntitiesResponse> analyzeEntitiesCallable() {
    return analyzeEntitiesCallable;
  }

  @Override
  public UnaryCallable<AnalyzeEntitySentimentRequest, AnalyzeEntitySentimentResponse>
      analyzeEntitySentimentCallable() {
    return analyzeEntitySentimentCallable;
  }

  @Override
  public UnaryCallable<AnalyzeSyntaxRequest, AnalyzeSyntaxResponse> analyzeSyntaxCallable() {
    return analyzeSyntaxCallable;
  }

  @Override
  public UnaryCallable<ClassifyTextRequest, ClassifyTextResponse> classifyTextCallable() {
    return classifyTextCallable;
  }

  @Override
  public UnaryCallable<AnnotateTextRequest, AnnotateTextResponse> annotateTextCallable() {
    return annotateTextCallable;
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
