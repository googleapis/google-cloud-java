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

package com.google.cloud.trace.v2.stub;

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
import com.google.devtools.cloudtrace.v2.BatchWriteSpansRequest;
import com.google.devtools.cloudtrace.v2.Span;
import com.google.protobuf.Empty;
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
 * REST stub implementation for the TraceService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonTraceServiceStub extends TraceServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<BatchWriteSpansRequest, Empty>
      batchWriteSpansMethodDescriptor =
          ApiMethodDescriptor.<BatchWriteSpansRequest, Empty>newBuilder()
              .setFullMethodName("google.devtools.cloudtrace.v2.TraceService/BatchWriteSpans")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchWriteSpansRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*}/traces:batchWrite",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchWriteSpansRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchWriteSpansRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<Span, Span> createSpanMethodDescriptor =
      ApiMethodDescriptor.<Span, Span>newBuilder()
          .setFullMethodName("google.devtools.cloudtrace.v2.TraceService/CreateSpan")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<Span>newBuilder()
                  .setPath(
                      "/v2/{name=projects/*/traces/*/spans/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<Span> serializer = ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<Span> serializer = ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create()
                              .toBody("*", request.toBuilder().clearName().build(), false))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Span>newBuilder()
                  .setDefaultInstance(Span.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private final UnaryCallable<BatchWriteSpansRequest, Empty> batchWriteSpansCallable;
  private final UnaryCallable<Span, Span> createSpanCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonTraceServiceStub create(TraceServiceStubSettings settings)
      throws IOException {
    return new HttpJsonTraceServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonTraceServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonTraceServiceStub(
        TraceServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonTraceServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonTraceServiceStub(
        TraceServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonTraceServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonTraceServiceStub(TraceServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonTraceServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonTraceServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonTraceServiceStub(
      TraceServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<BatchWriteSpansRequest, Empty> batchWriteSpansTransportSettings =
        HttpJsonCallSettings.<BatchWriteSpansRequest, Empty>newBuilder()
            .setMethodDescriptor(batchWriteSpansMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<Span, Span> createSpanTransportSettings =
        HttpJsonCallSettings.<Span, Span>newBuilder()
            .setMethodDescriptor(createSpanMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.batchWriteSpansCallable =
        callableFactory.createUnaryCallable(
            batchWriteSpansTransportSettings, settings.batchWriteSpansSettings(), clientContext);
    this.createSpanCallable =
        callableFactory.createUnaryCallable(
            createSpanTransportSettings, settings.createSpanSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(batchWriteSpansMethodDescriptor);
    methodDescriptors.add(createSpanMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<BatchWriteSpansRequest, Empty> batchWriteSpansCallable() {
    return batchWriteSpansCallable;
  }

  @Override
  public UnaryCallable<Span, Span> createSpanCallable() {
    return createSpanCallable;
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
