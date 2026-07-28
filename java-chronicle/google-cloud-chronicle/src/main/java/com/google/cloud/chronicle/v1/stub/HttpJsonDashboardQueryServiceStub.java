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

package com.google.cloud.chronicle.v1.stub;

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
import com.google.cloud.chronicle.v1.DashboardQuery;
import com.google.cloud.chronicle.v1.ExecuteDashboardQueryRequest;
import com.google.cloud.chronicle.v1.ExecuteDashboardQueryResponse;
import com.google.cloud.chronicle.v1.GetDashboardQueryRequest;
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
 * REST stub implementation for the DashboardQueryService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class HttpJsonDashboardQueryServiceStub extends DashboardQueryServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetDashboardQueryRequest, DashboardQuery>
      getDashboardQueryMethodDescriptor =
          ApiMethodDescriptor.<GetDashboardQueryRequest, DashboardQuery>newBuilder()
              .setFullMethodName(
                  "google.cloud.chronicle.v1.DashboardQueryService/GetDashboardQuery")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetDashboardQueryRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/instances/*/dashboardQueries/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetDashboardQueryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetDashboardQueryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DashboardQuery>newBuilder()
                      .setDefaultInstance(DashboardQuery.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ExecuteDashboardQueryRequest, ExecuteDashboardQueryResponse>
      executeDashboardQueryMethodDescriptor =
          ApiMethodDescriptor
              .<ExecuteDashboardQueryRequest, ExecuteDashboardQueryResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.chronicle.v1.DashboardQueryService/ExecuteDashboardQuery")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ExecuteDashboardQueryRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/instances/*}/dashboardQueries:execute",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ExecuteDashboardQueryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ExecuteDashboardQueryRequest> serializer =
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
                  ProtoMessageResponseParser.<ExecuteDashboardQueryResponse>newBuilder()
                      .setDefaultInstance(ExecuteDashboardQueryResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetDashboardQueryRequest, DashboardQuery> getDashboardQueryCallable;
  private final UnaryCallable<ExecuteDashboardQueryRequest, ExecuteDashboardQueryResponse>
      executeDashboardQueryCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonDashboardQueryServiceStub create(
      DashboardQueryServiceStubSettings settings) throws IOException {
    return new HttpJsonDashboardQueryServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonDashboardQueryServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonDashboardQueryServiceStub(
        DashboardQueryServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonDashboardQueryServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonDashboardQueryServiceStub(
        DashboardQueryServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonDashboardQueryServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonDashboardQueryServiceStub(
      DashboardQueryServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonDashboardQueryServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonDashboardQueryServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonDashboardQueryServiceStub(
      DashboardQueryServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetDashboardQueryRequest, DashboardQuery>
        getDashboardQueryTransportSettings =
            HttpJsonCallSettings.<GetDashboardQueryRequest, DashboardQuery>newBuilder()
                .setMethodDescriptor(getDashboardQueryMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<ExecuteDashboardQueryRequest, ExecuteDashboardQueryResponse>
        executeDashboardQueryTransportSettings =
            HttpJsonCallSettings
                .<ExecuteDashboardQueryRequest, ExecuteDashboardQueryResponse>newBuilder()
                .setMethodDescriptor(executeDashboardQueryMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();

    this.getDashboardQueryCallable =
        callableFactory.createUnaryCallable(
            getDashboardQueryTransportSettings,
            settings.getDashboardQuerySettings(),
            clientContext);
    this.executeDashboardQueryCallable =
        callableFactory.createUnaryCallable(
            executeDashboardQueryTransportSettings,
            settings.executeDashboardQuerySettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getDashboardQueryMethodDescriptor);
    methodDescriptors.add(executeDashboardQueryMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetDashboardQueryRequest, DashboardQuery> getDashboardQueryCallable() {
    return getDashboardQueryCallable;
  }

  @Override
  public UnaryCallable<ExecuteDashboardQueryRequest, ExecuteDashboardQueryResponse>
      executeDashboardQueryCallable() {
    return executeDashboardQueryCallable;
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
