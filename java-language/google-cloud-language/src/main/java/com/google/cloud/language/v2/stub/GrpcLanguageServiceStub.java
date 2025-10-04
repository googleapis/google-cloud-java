/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.language.v2.stub;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.language.v2.AnalyzeEntitiesRequest;
import com.google.cloud.language.v2.AnalyzeEntitiesResponse;
import com.google.cloud.language.v2.AnalyzeSentimentRequest;
import com.google.cloud.language.v2.AnalyzeSentimentResponse;
import com.google.cloud.language.v2.AnnotateTextRequest;
import com.google.cloud.language.v2.AnnotateTextResponse;
import com.google.cloud.language.v2.ClassifyTextRequest;
import com.google.cloud.language.v2.ClassifyTextResponse;
import com.google.cloud.language.v2.ModerateTextRequest;
import com.google.cloud.language.v2.ModerateTextResponse;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the LanguageService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcLanguageServiceStub extends LanguageServiceStub {
  private static final MethodDescriptor<AnalyzeSentimentRequest, AnalyzeSentimentResponse>
      analyzeSentimentMethodDescriptor =
          MethodDescriptor.<AnalyzeSentimentRequest, AnalyzeSentimentResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.language.v2.LanguageService/AnalyzeSentiment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(AnalyzeSentimentRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(AnalyzeSentimentResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<AnalyzeEntitiesRequest, AnalyzeEntitiesResponse>
      analyzeEntitiesMethodDescriptor =
          MethodDescriptor.<AnalyzeEntitiesRequest, AnalyzeEntitiesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.language.v2.LanguageService/AnalyzeEntities")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(AnalyzeEntitiesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(AnalyzeEntitiesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ClassifyTextRequest, ClassifyTextResponse>
      classifyTextMethodDescriptor =
          MethodDescriptor.<ClassifyTextRequest, ClassifyTextResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.language.v2.LanguageService/ClassifyText")
              .setRequestMarshaller(ProtoUtils.marshaller(ClassifyTextRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ClassifyTextResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ModerateTextRequest, ModerateTextResponse>
      moderateTextMethodDescriptor =
          MethodDescriptor.<ModerateTextRequest, ModerateTextResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.language.v2.LanguageService/ModerateText")
              .setRequestMarshaller(ProtoUtils.marshaller(ModerateTextRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ModerateTextResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<AnnotateTextRequest, AnnotateTextResponse>
      annotateTextMethodDescriptor =
          MethodDescriptor.<AnnotateTextRequest, AnnotateTextResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.language.v2.LanguageService/AnnotateText")
              .setRequestMarshaller(ProtoUtils.marshaller(AnnotateTextRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(AnnotateTextResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<AnalyzeSentimentRequest, AnalyzeSentimentResponse>
      analyzeSentimentCallable;
  private final UnaryCallable<AnalyzeEntitiesRequest, AnalyzeEntitiesResponse>
      analyzeEntitiesCallable;
  private final UnaryCallable<ClassifyTextRequest, ClassifyTextResponse> classifyTextCallable;
  private final UnaryCallable<ModerateTextRequest, ModerateTextResponse> moderateTextCallable;
  private final UnaryCallable<AnnotateTextRequest, AnnotateTextResponse> annotateTextCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcLanguageServiceStub create(LanguageServiceStubSettings settings)
      throws IOException {
    return new GrpcLanguageServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcLanguageServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcLanguageServiceStub(
        LanguageServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcLanguageServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcLanguageServiceStub(
        LanguageServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcLanguageServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcLanguageServiceStub(
      LanguageServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcLanguageServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcLanguageServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcLanguageServiceStub(
      LanguageServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<AnalyzeSentimentRequest, AnalyzeSentimentResponse>
        analyzeSentimentTransportSettings =
            GrpcCallSettings.<AnalyzeSentimentRequest, AnalyzeSentimentResponse>newBuilder()
                .setMethodDescriptor(analyzeSentimentMethodDescriptor)
                .build();
    GrpcCallSettings<AnalyzeEntitiesRequest, AnalyzeEntitiesResponse>
        analyzeEntitiesTransportSettings =
            GrpcCallSettings.<AnalyzeEntitiesRequest, AnalyzeEntitiesResponse>newBuilder()
                .setMethodDescriptor(analyzeEntitiesMethodDescriptor)
                .build();
    GrpcCallSettings<ClassifyTextRequest, ClassifyTextResponse> classifyTextTransportSettings =
        GrpcCallSettings.<ClassifyTextRequest, ClassifyTextResponse>newBuilder()
            .setMethodDescriptor(classifyTextMethodDescriptor)
            .build();
    GrpcCallSettings<ModerateTextRequest, ModerateTextResponse> moderateTextTransportSettings =
        GrpcCallSettings.<ModerateTextRequest, ModerateTextResponse>newBuilder()
            .setMethodDescriptor(moderateTextMethodDescriptor)
            .build();
    GrpcCallSettings<AnnotateTextRequest, AnnotateTextResponse> annotateTextTransportSettings =
        GrpcCallSettings.<AnnotateTextRequest, AnnotateTextResponse>newBuilder()
            .setMethodDescriptor(annotateTextMethodDescriptor)
            .build();

    this.analyzeSentimentCallable =
        callableFactory.createUnaryCallable(
            analyzeSentimentTransportSettings, settings.analyzeSentimentSettings(), clientContext);
    this.analyzeEntitiesCallable =
        callableFactory.createUnaryCallable(
            analyzeEntitiesTransportSettings, settings.analyzeEntitiesSettings(), clientContext);
    this.classifyTextCallable =
        callableFactory.createUnaryCallable(
            classifyTextTransportSettings, settings.classifyTextSettings(), clientContext);
    this.moderateTextCallable =
        callableFactory.createUnaryCallable(
            moderateTextTransportSettings, settings.moderateTextSettings(), clientContext);
    this.annotateTextCallable =
        callableFactory.createUnaryCallable(
            annotateTextTransportSettings, settings.annotateTextSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
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
  public UnaryCallable<ClassifyTextRequest, ClassifyTextResponse> classifyTextCallable() {
    return classifyTextCallable;
  }

  @Override
  public UnaryCallable<ModerateTextRequest, ModerateTextResponse> moderateTextCallable() {
    return moderateTextCallable;
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
