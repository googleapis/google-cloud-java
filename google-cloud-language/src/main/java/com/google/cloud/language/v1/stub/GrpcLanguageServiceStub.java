/*
 * Copyright 2017, Google Inc. All rights reserved.
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
package com.google.cloud.language.v1.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.language.v1.AnalyzeEntitiesRequest;
import com.google.cloud.language.v1.AnalyzeEntitiesResponse;
import com.google.cloud.language.v1.AnalyzeSentimentRequest;
import com.google.cloud.language.v1.AnalyzeSentimentResponse;
import com.google.cloud.language.v1.AnalyzeSyntaxRequest;
import com.google.cloud.language.v1.AnalyzeSyntaxResponse;
import com.google.cloud.language.v1.AnnotateTextRequest;
import com.google.cloud.language.v1.AnnotateTextResponse;
import com.google.cloud.language.v1.LanguageServiceSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * gRPC stub implementation for Google Cloud Natural Language API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by GAPIC v0.0.5")
@BetaApi
public class GrpcLanguageServiceStub extends LanguageServiceStub {
  private static final UnaryCallable<AnalyzeSentimentRequest, AnalyzeSentimentResponse>
      directAnalyzeSentimentCallable =
          GrpcCallableFactory.createDirectCallable(
              io.grpc.MethodDescriptor.create(
                  io.grpc.MethodDescriptor.MethodType.UNARY,
                  "google.cloud.language.v1.LanguageService/AnalyzeSentiment",
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      AnalyzeSentimentRequest.getDefaultInstance()),
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      AnalyzeSentimentResponse.getDefaultInstance())));
  private static final UnaryCallable<AnalyzeEntitiesRequest, AnalyzeEntitiesResponse>
      directAnalyzeEntitiesCallable =
          GrpcCallableFactory.createDirectCallable(
              io.grpc.MethodDescriptor.create(
                  io.grpc.MethodDescriptor.MethodType.UNARY,
                  "google.cloud.language.v1.LanguageService/AnalyzeEntities",
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      AnalyzeEntitiesRequest.getDefaultInstance()),
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      AnalyzeEntitiesResponse.getDefaultInstance())));
  private static final UnaryCallable<AnalyzeSyntaxRequest, AnalyzeSyntaxResponse>
      directAnalyzeSyntaxCallable =
          GrpcCallableFactory.createDirectCallable(
              io.grpc.MethodDescriptor.create(
                  io.grpc.MethodDescriptor.MethodType.UNARY,
                  "google.cloud.language.v1.LanguageService/AnalyzeSyntax",
                  io.grpc.protobuf.ProtoUtils.marshaller(AnalyzeSyntaxRequest.getDefaultInstance()),
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      AnalyzeSyntaxResponse.getDefaultInstance())));
  private static final UnaryCallable<AnnotateTextRequest, AnnotateTextResponse>
      directAnnotateTextCallable =
          GrpcCallableFactory.createDirectCallable(
              io.grpc.MethodDescriptor.create(
                  io.grpc.MethodDescriptor.MethodType.UNARY,
                  "google.cloud.language.v1.LanguageService/AnnotateText",
                  io.grpc.protobuf.ProtoUtils.marshaller(AnnotateTextRequest.getDefaultInstance()),
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      AnnotateTextResponse.getDefaultInstance())));

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<AnalyzeSentimentRequest, AnalyzeSentimentResponse>
      analyzeSentimentCallable;
  private final UnaryCallable<AnalyzeEntitiesRequest, AnalyzeEntitiesResponse>
      analyzeEntitiesCallable;
  private final UnaryCallable<AnalyzeSyntaxRequest, AnalyzeSyntaxResponse> analyzeSyntaxCallable;
  private final UnaryCallable<AnnotateTextRequest, AnnotateTextResponse> annotateTextCallable;

  public static final GrpcLanguageServiceStub create(LanguageServiceSettings settings)
      throws IOException {
    return new GrpcLanguageServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcLanguageServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcLanguageServiceStub(LanguageServiceSettings.newBuilder().build(), clientContext);
  }

  /**
   * Constructs an instance of GrpcLanguageServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcLanguageServiceStub(LanguageServiceSettings settings, ClientContext clientContext)
      throws IOException {

    this.analyzeSentimentCallable =
        GrpcCallableFactory.create(
            directAnalyzeSentimentCallable, settings.analyzeSentimentSettings(), clientContext);
    this.analyzeEntitiesCallable =
        GrpcCallableFactory.create(
            directAnalyzeEntitiesCallable, settings.analyzeEntitiesSettings(), clientContext);
    this.analyzeSyntaxCallable =
        GrpcCallableFactory.create(
            directAnalyzeSyntaxCallable, settings.analyzeSyntaxSettings(), clientContext);
    this.annotateTextCallable =
        GrpcCallableFactory.create(
            directAnnotateTextCallable, settings.annotateTextSettings(), clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public UnaryCallable<AnalyzeSentimentRequest, AnalyzeSentimentResponse>
      analyzeSentimentCallable() {
    return analyzeSentimentCallable;
  }

  public UnaryCallable<AnalyzeEntitiesRequest, AnalyzeEntitiesResponse> analyzeEntitiesCallable() {
    return analyzeEntitiesCallable;
  }

  public UnaryCallable<AnalyzeSyntaxRequest, AnalyzeSyntaxResponse> analyzeSyntaxCallable() {
    return analyzeSyntaxCallable;
  }

  public UnaryCallable<AnnotateTextRequest, AnnotateTextResponse> annotateTextCallable() {
    return annotateTextCallable;
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
