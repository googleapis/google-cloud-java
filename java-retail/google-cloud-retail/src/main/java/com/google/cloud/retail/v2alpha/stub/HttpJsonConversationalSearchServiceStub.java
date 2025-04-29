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

package com.google.cloud.retail.v2alpha.stub;

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
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.cloud.retail.v2alpha.ConversationalSearchRequest;
import com.google.cloud.retail.v2alpha.ConversationalSearchResponse;
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
 * REST stub implementation for the ConversationalSearchService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonConversationalSearchServiceStub extends ConversationalSearchServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<
          ConversationalSearchRequest, ConversationalSearchResponse>
      conversationalSearchMethodDescriptor =
          ApiMethodDescriptor
              .<ConversationalSearchRequest, ConversationalSearchResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.retail.v2alpha.ConversationalSearchService/ConversationalSearch")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.SERVER_STREAMING)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ConversationalSearchRequest>newBuilder()
                      .setPath(
                          "/v2alpha/{placement=projects/*/locations/*/catalogs/*/placements/*}:conversationalSearch",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ConversationalSearchRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "placement", request.getPlacement());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2alpha/{placement=projects/*/locations/*/catalogs/*/servingConfigs/*}:conversationalSearch")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ConversationalSearchRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearPlacement().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ConversationalSearchResponse>newBuilder()
                      .setDefaultInstance(ConversationalSearchResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final ServerStreamingCallable<ConversationalSearchRequest, ConversationalSearchResponse>
      conversationalSearchCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonConversationalSearchServiceStub create(
      ConversationalSearchServiceStubSettings settings) throws IOException {
    return new HttpJsonConversationalSearchServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonConversationalSearchServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonConversationalSearchServiceStub(
        ConversationalSearchServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonConversationalSearchServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonConversationalSearchServiceStub(
        ConversationalSearchServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonConversationalSearchServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonConversationalSearchServiceStub(
      ConversationalSearchServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonConversationalSearchServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonConversationalSearchServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonConversationalSearchServiceStub(
      ConversationalSearchServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<ConversationalSearchRequest, ConversationalSearchResponse>
        conversationalSearchTransportSettings =
            HttpJsonCallSettings
                .<ConversationalSearchRequest, ConversationalSearchResponse>newBuilder()
                .setMethodDescriptor(conversationalSearchMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("placement", String.valueOf(request.getPlacement()));
                      return builder.build();
                    })
                .build();

    this.conversationalSearchCallable =
        callableFactory.createServerStreamingCallable(
            conversationalSearchTransportSettings,
            settings.conversationalSearchSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(conversationalSearchMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public ServerStreamingCallable<ConversationalSearchRequest, ConversationalSearchResponse>
      conversationalSearchCallable() {
    return conversationalSearchCallable;
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
