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
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1beta.CheckGroundingRequest;
import com.google.cloud.discoveryengine.v1beta.CheckGroundingResponse;
import com.google.cloud.discoveryengine.v1beta.GenerateGroundedContentRequest;
import com.google.cloud.discoveryengine.v1beta.GenerateGroundedContentResponse;
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
 * REST stub implementation for the GroundedGenerationService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonGroundedGenerationServiceStub extends GroundedGenerationServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<
          GenerateGroundedContentRequest, GenerateGroundedContentResponse>
      generateGroundedContentMethodDescriptor =
          ApiMethodDescriptor
              .<GenerateGroundedContentRequest, GenerateGroundedContentResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1beta.GroundedGenerationService/GenerateGroundedContent")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GenerateGroundedContentRequest>newBuilder()
                      .setPath(
                          "/v1beta/{location=projects/*/locations/*}:generateGroundedContent",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateGroundedContentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "location", request.getLocation());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateGroundedContentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearLocation().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GenerateGroundedContentResponse>newBuilder()
                      .setDefaultInstance(GenerateGroundedContentResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CheckGroundingRequest, CheckGroundingResponse>
      checkGroundingMethodDescriptor =
          ApiMethodDescriptor.<CheckGroundingRequest, CheckGroundingResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1beta.GroundedGenerationService/CheckGrounding")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CheckGroundingRequest>newBuilder()
                      .setPath(
                          "/v1beta/{groundingConfig=projects/*/locations/*/groundingConfigs/*}:check",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CheckGroundingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "groundingConfig", request.getGroundingConfig());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CheckGroundingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*",
                                      request.toBuilder().clearGroundingConfig().build(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CheckGroundingResponse>newBuilder()
                      .setDefaultInstance(CheckGroundingResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GenerateGroundedContentRequest, GenerateGroundedContentResponse>
      generateGroundedContentCallable;
  private final UnaryCallable<CheckGroundingRequest, CheckGroundingResponse> checkGroundingCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonGroundedGenerationServiceStub create(
      GroundedGenerationServiceStubSettings settings) throws IOException {
    return new HttpJsonGroundedGenerationServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonGroundedGenerationServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonGroundedGenerationServiceStub(
        GroundedGenerationServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonGroundedGenerationServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonGroundedGenerationServiceStub(
        GroundedGenerationServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonGroundedGenerationServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonGroundedGenerationServiceStub(
      GroundedGenerationServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonGroundedGenerationServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonGroundedGenerationServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonGroundedGenerationServiceStub(
      GroundedGenerationServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GenerateGroundedContentRequest, GenerateGroundedContentResponse>
        generateGroundedContentTransportSettings =
            HttpJsonCallSettings
                .<GenerateGroundedContentRequest, GenerateGroundedContentResponse>newBuilder()
                .setMethodDescriptor(generateGroundedContentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("location", String.valueOf(request.getLocation()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CheckGroundingRequest, CheckGroundingResponse>
        checkGroundingTransportSettings =
            HttpJsonCallSettings.<CheckGroundingRequest, CheckGroundingResponse>newBuilder()
                .setMethodDescriptor(checkGroundingMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("grounding_config", String.valueOf(request.getGroundingConfig()));
                      return builder.build();
                    })
                .build();

    this.generateGroundedContentCallable =
        callableFactory.createUnaryCallable(
            generateGroundedContentTransportSettings,
            settings.generateGroundedContentSettings(),
            clientContext);
    this.checkGroundingCallable =
        callableFactory.createUnaryCallable(
            checkGroundingTransportSettings, settings.checkGroundingSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(generateGroundedContentMethodDescriptor);
    methodDescriptors.add(checkGroundingMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GenerateGroundedContentRequest, GenerateGroundedContentResponse>
      generateGroundedContentCallable() {
    return generateGroundedContentCallable;
  }

  @Override
  public UnaryCallable<CheckGroundingRequest, CheckGroundingResponse> checkGroundingCallable() {
    return checkGroundingCallable;
  }

  @Override
  public BidiStreamingCallable<GenerateGroundedContentRequest, GenerateGroundedContentResponse>
      streamGenerateGroundedContentCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: streamGenerateGroundedContentCallable(). REST transport is not implemented for this method yet.");
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
