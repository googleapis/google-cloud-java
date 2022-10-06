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

package com.google.cloud.videointelligence.v1.stub;

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
import com.google.cloud.videointelligence.v1.AnnotateVideoProgress;
import com.google.cloud.videointelligence.v1.AnnotateVideoRequest;
import com.google.cloud.videointelligence.v1.AnnotateVideoResponse;
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
 * REST stub implementation for the VideoIntelligenceService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonVideoIntelligenceServiceStub extends VideoIntelligenceServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(AnnotateVideoProgress.getDescriptor())
          .add(AnnotateVideoResponse.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<AnnotateVideoRequest, Operation>
      annotateVideoMethodDescriptor =
          ApiMethodDescriptor.<AnnotateVideoRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.videointelligence.v1.VideoIntelligenceService/AnnotateVideo")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AnnotateVideoRequest>newBuilder()
                      .setPath(
                          "/v1/videos:annotate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AnnotateVideoRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AnnotateVideoRequest> serializer =
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
                  (AnnotateVideoRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private final UnaryCallable<AnnotateVideoRequest, Operation> annotateVideoCallable;
  private final OperationCallable<
          AnnotateVideoRequest, AnnotateVideoResponse, AnnotateVideoProgress>
      annotateVideoOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonVideoIntelligenceServiceStub create(
      VideoIntelligenceServiceStubSettings settings) throws IOException {
    return new HttpJsonVideoIntelligenceServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonVideoIntelligenceServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonVideoIntelligenceServiceStub(
        VideoIntelligenceServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonVideoIntelligenceServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonVideoIntelligenceServiceStub(
        VideoIntelligenceServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonVideoIntelligenceServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonVideoIntelligenceServiceStub(
      VideoIntelligenceServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonVideoIntelligenceServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonVideoIntelligenceServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonVideoIntelligenceServiceStub(
      VideoIntelligenceServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<AnnotateVideoRequest, Operation> annotateVideoTransportSettings =
        HttpJsonCallSettings.<AnnotateVideoRequest, Operation>newBuilder()
            .setMethodDescriptor(annotateVideoMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.annotateVideoCallable =
        callableFactory.createUnaryCallable(
            annotateVideoTransportSettings, settings.annotateVideoSettings(), clientContext);
    this.annotateVideoOperationCallable =
        callableFactory.createOperationCallable(
            annotateVideoTransportSettings,
            settings.annotateVideoOperationSettings(),
            clientContext,
            httpJsonOperationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(annotateVideoMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<AnnotateVideoRequest, Operation> annotateVideoCallable() {
    return annotateVideoCallable;
  }

  @Override
  public OperationCallable<AnnotateVideoRequest, AnnotateVideoResponse, AnnotateVideoProgress>
      annotateVideoOperationCallable() {
    return annotateVideoOperationCallable;
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
