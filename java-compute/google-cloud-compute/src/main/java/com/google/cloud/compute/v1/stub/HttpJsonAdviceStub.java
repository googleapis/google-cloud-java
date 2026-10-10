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

package com.google.cloud.compute.v1.stub;

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
import com.google.cloud.compute.v1.CalendarModeAdviceResponse;
import com.google.cloud.compute.v1.CalendarModeAdviceRpcRequest;
import com.google.cloud.compute.v1.CapacityAdviceResponse;
import com.google.cloud.compute.v1.CapacityAdviceRpcRequest;
import com.google.cloud.compute.v1.CapacityHistoryAdviceRequest;
import com.google.cloud.compute.v1.CapacityHistoryResponse;
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
 * REST stub implementation for the Advice service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class HttpJsonAdviceStub extends AdviceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<CalendarModeAdviceRpcRequest, CalendarModeAdviceResponse>
      calendarModeMethodDescriptor =
          ApiMethodDescriptor.<CalendarModeAdviceRpcRequest, CalendarModeAdviceResponse>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Advice/CalendarMode")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CalendarModeAdviceRpcRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/advice/calendarMode",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CalendarModeAdviceRpcRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CalendarModeAdviceRpcRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "calendarModeAdviceRequestResource",
                                      request.getCalendarModeAdviceRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CalendarModeAdviceResponse>newBuilder()
                      .setDefaultInstance(CalendarModeAdviceResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CapacityAdviceRpcRequest, CapacityAdviceResponse>
      capacityMethodDescriptor =
          ApiMethodDescriptor.<CapacityAdviceRpcRequest, CapacityAdviceResponse>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Advice/Capacity")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CapacityAdviceRpcRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/advice/capacity",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CapacityAdviceRpcRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CapacityAdviceRpcRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "capacityAdviceRequestResource",
                                      request.getCapacityAdviceRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CapacityAdviceResponse>newBuilder()
                      .setDefaultInstance(CapacityAdviceResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CapacityHistoryAdviceRequest, CapacityHistoryResponse>
      capacityHistoryMethodDescriptor =
          ApiMethodDescriptor.<CapacityHistoryAdviceRequest, CapacityHistoryResponse>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.Advice/CapacityHistory")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CapacityHistoryAdviceRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/advice/capacityHistory",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CapacityHistoryAdviceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CapacityHistoryAdviceRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "capacityHistoryRequestResource",
                                      request.getCapacityHistoryRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CapacityHistoryResponse>newBuilder()
                      .setDefaultInstance(CapacityHistoryResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CalendarModeAdviceRpcRequest, CalendarModeAdviceResponse>
      calendarModeCallable;
  private final UnaryCallable<CapacityAdviceRpcRequest, CapacityAdviceResponse> capacityCallable;
  private final UnaryCallable<CapacityHistoryAdviceRequest, CapacityHistoryResponse>
      capacityHistoryCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonAdviceStub create(AdviceStubSettings settings) throws IOException {
    return new HttpJsonAdviceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonAdviceStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonAdviceStub(AdviceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonAdviceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonAdviceStub(
        AdviceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonAdviceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonAdviceStub(AdviceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonAdviceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonAdviceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonAdviceStub(
      AdviceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CalendarModeAdviceRpcRequest, CalendarModeAdviceResponse>
        calendarModeTransportSettings =
            HttpJsonCallSettings
                .<CalendarModeAdviceRpcRequest, CalendarModeAdviceResponse>newBuilder()
                .setMethodDescriptor(calendarModeMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("project", String.valueOf(request.getProject()));
                      builder.add("region", String.valueOf(request.getRegion()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CapacityAdviceRpcRequest, CapacityAdviceResponse>
        capacityTransportSettings =
            HttpJsonCallSettings.<CapacityAdviceRpcRequest, CapacityAdviceResponse>newBuilder()
                .setMethodDescriptor(capacityMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("project", String.valueOf(request.getProject()));
                      builder.add("region", String.valueOf(request.getRegion()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CapacityHistoryAdviceRequest, CapacityHistoryResponse>
        capacityHistoryTransportSettings =
            HttpJsonCallSettings.<CapacityHistoryAdviceRequest, CapacityHistoryResponse>newBuilder()
                .setMethodDescriptor(capacityHistoryMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("project", String.valueOf(request.getProject()));
                      builder.add("region", String.valueOf(request.getRegion()));
                      return builder.build();
                    })
                .build();

    this.calendarModeCallable =
        callableFactory.createUnaryCallable(
            calendarModeTransportSettings, settings.calendarModeSettings(), clientContext);
    this.capacityCallable =
        callableFactory.createUnaryCallable(
            capacityTransportSettings, settings.capacitySettings(), clientContext);
    this.capacityHistoryCallable =
        callableFactory.createUnaryCallable(
            capacityHistoryTransportSettings, settings.capacityHistorySettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(calendarModeMethodDescriptor);
    methodDescriptors.add(capacityMethodDescriptor);
    methodDescriptors.add(capacityHistoryMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<CalendarModeAdviceRpcRequest, CalendarModeAdviceResponse>
      calendarModeCallable() {
    return calendarModeCallable;
  }

  @Override
  public UnaryCallable<CapacityAdviceRpcRequest, CapacityAdviceResponse> capacityCallable() {
    return capacityCallable;
  }

  @Override
  public UnaryCallable<CapacityHistoryAdviceRequest, CapacityHistoryResponse>
      capacityHistoryCallable() {
    return capacityHistoryCallable;
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
