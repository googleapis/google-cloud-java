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

package com.google.shopping.merchant.productstudio.v1alpha.stub;

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
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.protobuf.TypeRegistry;
import com.google.shopping.merchant.productstudio.v1alpha.GenerateProductTextSuggestionsRequest;
import com.google.shopping.merchant.productstudio.v1alpha.GenerateProductTextSuggestionsResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the TextSuggestionsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonTextSuggestionsServiceStub extends TextSuggestionsServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<
          GenerateProductTextSuggestionsRequest, GenerateProductTextSuggestionsResponse>
      generateProductTextSuggestionsMethodDescriptor =
          ApiMethodDescriptor
              .<GenerateProductTextSuggestionsRequest, GenerateProductTextSuggestionsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.productstudio.v1alpha.TextSuggestionsService/GenerateProductTextSuggestions")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GenerateProductTextSuggestionsRequest>newBuilder()
                      .setPath(
                          "/productstudio/v1alpha/{name=accounts/*}:generateProductTextSuggestions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateProductTextSuggestionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateProductTextSuggestionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GenerateProductTextSuggestionsResponse>newBuilder()
                      .setDefaultInstance(
                          GenerateProductTextSuggestionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<
          GenerateProductTextSuggestionsRequest, GenerateProductTextSuggestionsResponse>
      generateProductTextSuggestionsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonTextSuggestionsServiceStub create(
      TextSuggestionsServiceStubSettings settings) throws IOException {
    return new HttpJsonTextSuggestionsServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonTextSuggestionsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonTextSuggestionsServiceStub(
        TextSuggestionsServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonTextSuggestionsServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonTextSuggestionsServiceStub(
        TextSuggestionsServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonTextSuggestionsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonTextSuggestionsServiceStub(
      TextSuggestionsServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonTextSuggestionsServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonTextSuggestionsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonTextSuggestionsServiceStub(
      TextSuggestionsServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<
            GenerateProductTextSuggestionsRequest, GenerateProductTextSuggestionsResponse>
        generateProductTextSuggestionsTransportSettings =
            HttpJsonCallSettings
                .<GenerateProductTextSuggestionsRequest, GenerateProductTextSuggestionsResponse>
                    newBuilder()
                .setMethodDescriptor(generateProductTextSuggestionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();

    this.generateProductTextSuggestionsCallable =
        callableFactory.createUnaryCallable(
            generateProductTextSuggestionsTransportSettings,
            settings.generateProductTextSuggestionsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(generateProductTextSuggestionsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<
          GenerateProductTextSuggestionsRequest, GenerateProductTextSuggestionsResponse>
      generateProductTextSuggestionsCallable() {
    return generateProductTextSuggestionsCallable;
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
