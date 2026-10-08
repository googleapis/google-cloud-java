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

package com.google.ads.admanager.v1.stub;

import com.google.ads.admanager.v1.RunAvailabilityForecastRequest;
import com.google.ads.admanager.v1.RunAvailabilityForecastResponse;
import com.google.ads.admanager.v1.RunDeliveryForecastRequest;
import com.google.ads.admanager.v1.RunDeliveryForecastResponse;
import com.google.ads.admanager.v1.RunTrafficDataRequest;
import com.google.ads.admanager.v1.RunTrafficDataResponse;
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
 * REST stub implementation for the ForecastService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class HttpJsonForecastServiceStub extends ForecastServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<
          RunAvailabilityForecastRequest, RunAvailabilityForecastResponse>
      runAvailabilityForecastMethodDescriptor =
          ApiMethodDescriptor
              .<RunAvailabilityForecastRequest, RunAvailabilityForecastResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.ForecastService/RunAvailabilityForecast")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RunAvailabilityForecastRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}:runAvailabilityForecast",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RunAvailabilityForecastRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RunAvailabilityForecastRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RunAvailabilityForecastResponse>newBuilder()
                      .setDefaultInstance(RunAvailabilityForecastResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<RunDeliveryForecastRequest, RunDeliveryForecastResponse>
      runDeliveryForecastMethodDescriptor =
          ApiMethodDescriptor.<RunDeliveryForecastRequest, RunDeliveryForecastResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.ForecastService/RunDeliveryForecast")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RunDeliveryForecastRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}:runDeliveryForecast",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RunDeliveryForecastRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RunDeliveryForecastRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RunDeliveryForecastResponse>newBuilder()
                      .setDefaultInstance(RunDeliveryForecastResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<RunTrafficDataRequest, RunTrafficDataResponse>
      runTrafficDataMethodDescriptor =
          ApiMethodDescriptor.<RunTrafficDataRequest, RunTrafficDataResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.ForecastService/RunTrafficData")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RunTrafficDataRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}:runTrafficData",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RunTrafficDataRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RunTrafficDataRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RunTrafficDataResponse>newBuilder()
                      .setDefaultInstance(RunTrafficDataResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<RunAvailabilityForecastRequest, RunAvailabilityForecastResponse>
      runAvailabilityForecastCallable;
  private final UnaryCallable<RunDeliveryForecastRequest, RunDeliveryForecastResponse>
      runDeliveryForecastCallable;
  private final UnaryCallable<RunTrafficDataRequest, RunTrafficDataResponse> runTrafficDataCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonForecastServiceStub create(ForecastServiceStubSettings settings)
      throws IOException {
    return new HttpJsonForecastServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonForecastServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonForecastServiceStub(
        ForecastServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonForecastServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonForecastServiceStub(
        ForecastServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonForecastServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonForecastServiceStub(
      ForecastServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonForecastServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonForecastServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonForecastServiceStub(
      ForecastServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<RunAvailabilityForecastRequest, RunAvailabilityForecastResponse>
        runAvailabilityForecastTransportSettings =
            HttpJsonCallSettings
                .<RunAvailabilityForecastRequest, RunAvailabilityForecastResponse>newBuilder()
                .setMethodDescriptor(runAvailabilityForecastMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getExistingLineItem())
                .build();
    HttpJsonCallSettings<RunDeliveryForecastRequest, RunDeliveryForecastResponse>
        runDeliveryForecastTransportSettings =
            HttpJsonCallSettings
                .<RunDeliveryForecastRequest, RunDeliveryForecastResponse>newBuilder()
                .setMethodDescriptor(runDeliveryForecastMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<RunTrafficDataRequest, RunTrafficDataResponse>
        runTrafficDataTransportSettings =
            HttpJsonCallSettings.<RunTrafficDataRequest, RunTrafficDataResponse>newBuilder()
                .setMethodDescriptor(runTrafficDataMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();

    this.runAvailabilityForecastCallable =
        callableFactory.createUnaryCallable(
            runAvailabilityForecastTransportSettings,
            settings.runAvailabilityForecastSettings(),
            clientContext);
    this.runDeliveryForecastCallable =
        callableFactory.createUnaryCallable(
            runDeliveryForecastTransportSettings,
            settings.runDeliveryForecastSettings(),
            clientContext);
    this.runTrafficDataCallable =
        callableFactory.createUnaryCallable(
            runTrafficDataTransportSettings, settings.runTrafficDataSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(runAvailabilityForecastMethodDescriptor);
    methodDescriptors.add(runDeliveryForecastMethodDescriptor);
    methodDescriptors.add(runTrafficDataMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<RunAvailabilityForecastRequest, RunAvailabilityForecastResponse>
      runAvailabilityForecastCallable() {
    return runAvailabilityForecastCallable;
  }

  @Override
  public UnaryCallable<RunDeliveryForecastRequest, RunDeliveryForecastResponse>
      runDeliveryForecastCallable() {
    return runDeliveryForecastCallable;
  }

  @Override
  public UnaryCallable<RunTrafficDataRequest, RunTrafficDataResponse> runTrafficDataCallable() {
    return runTrafficDataCallable;
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
