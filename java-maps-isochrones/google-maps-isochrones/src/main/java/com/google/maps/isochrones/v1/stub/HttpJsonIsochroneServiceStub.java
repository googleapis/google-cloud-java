/*
 * Copyright 2026 Google LLC
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

package com.google.maps.isochrones.v1.stub;

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
import com.google.maps.isochrones.v1.GenerateIsochroneRequest;
import com.google.maps.isochrones.v1.GenerateIsochroneResponse;
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the IsochroneService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class HttpJsonIsochroneServiceStub extends IsochroneServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GenerateIsochroneRequest, GenerateIsochroneResponse>
      generateIsochroneMethodDescriptor =
          ApiMethodDescriptor.<GenerateIsochroneRequest, GenerateIsochroneResponse>newBuilder()
              .setFullMethodName("google.maps.isochrones.v1.IsochroneService/GenerateIsochrone")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GenerateIsochroneRequest>newBuilder()
                      .setPath(
                          "/v1/isochrones:generate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateIsochroneRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateIsochroneRequest> serializer =
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
                  ProtoMessageResponseParser.<GenerateIsochroneResponse>newBuilder()
                      .setDefaultInstance(GenerateIsochroneResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GenerateIsochroneRequest, GenerateIsochroneResponse>
      generateIsochroneCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonIsochroneServiceStub create(IsochroneServiceStubSettings settings)
      throws IOException {
    return new HttpJsonIsochroneServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonIsochroneServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonIsochroneServiceStub(
        IsochroneServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonIsochroneServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonIsochroneServiceStub(
        IsochroneServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonIsochroneServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonIsochroneServiceStub(
      IsochroneServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonIsochroneServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonIsochroneServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonIsochroneServiceStub(
      IsochroneServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GenerateIsochroneRequest, GenerateIsochroneResponse>
        generateIsochroneTransportSettings =
            HttpJsonCallSettings.<GenerateIsochroneRequest, GenerateIsochroneResponse>newBuilder()
                .setMethodDescriptor(generateIsochroneMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setResourceNameExtractor(request -> request.getPlace())
                .build();

    this.generateIsochroneCallable =
        callableFactory.createUnaryCallable(
            generateIsochroneTransportSettings,
            settings.generateIsochroneSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(generateIsochroneMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GenerateIsochroneRequest, GenerateIsochroneResponse>
      generateIsochroneCallable() {
    return generateIsochroneCallable;
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
