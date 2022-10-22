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

package com.google.cloud.discoveryengine.v1beta.stub;

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
import com.google.cloud.discoveryengine.v1beta.RecommendRequest;
import com.google.cloud.discoveryengine.v1beta.RecommendResponse;
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
 * REST stub implementation for the RecommendationService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonRecommendationServiceStub extends RecommendationServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<RecommendRequest, RecommendResponse>
      recommendMethodDescriptor =
          ApiMethodDescriptor.<RecommendRequest, RecommendResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1beta.RecommendationService/Recommend")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RecommendRequest>newBuilder()
                      .setPath(
                          "/v1beta/{servingConfig=projects/*/locations/*/dataStores/*/servingConfigs/*}:recommend",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RecommendRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "servingConfig", request.getServingConfig());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RecommendRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*", request.toBuilder().clearServingConfig().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RecommendResponse>newBuilder()
                      .setDefaultInstance(RecommendResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<RecommendRequest, RecommendResponse> recommendCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonRecommendationServiceStub create(
      RecommendationServiceStubSettings settings) throws IOException {
    return new HttpJsonRecommendationServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonRecommendationServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonRecommendationServiceStub(
        RecommendationServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonRecommendationServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonRecommendationServiceStub(
        RecommendationServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonRecommendationServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRecommendationServiceStub(
      RecommendationServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonRecommendationServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonRecommendationServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRecommendationServiceStub(
      RecommendationServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<RecommendRequest, RecommendResponse> recommendTransportSettings =
        HttpJsonCallSettings.<RecommendRequest, RecommendResponse>newBuilder()
            .setMethodDescriptor(recommendMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.recommendCallable =
        callableFactory.createUnaryCallable(
            recommendTransportSettings, settings.recommendSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(recommendMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<RecommendRequest, RecommendResponse> recommendCallable() {
    return recommendCallable;
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
