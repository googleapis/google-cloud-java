/*
 * Copyright 2024 Google LLC
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

package com.google.maps.routeoptimization.v1.stub;

import com.google.api.HttpRule;
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
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
import com.google.maps.routeoptimization.v1.BatchOptimizeToursMetadata;
import com.google.maps.routeoptimization.v1.BatchOptimizeToursRequest;
import com.google.maps.routeoptimization.v1.BatchOptimizeToursResponse;
import com.google.maps.routeoptimization.v1.OptimizeToursRequest;
import com.google.maps.routeoptimization.v1.OptimizeToursResponse;
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
 * REST stub implementation for the RouteOptimization service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonRouteOptimizationStub extends RouteOptimizationStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(BatchOptimizeToursResponse.getDescriptor())
          .add(BatchOptimizeToursMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<OptimizeToursRequest, OptimizeToursResponse>
      optimizeToursMethodDescriptor =
          ApiMethodDescriptor.<OptimizeToursRequest, OptimizeToursResponse>newBuilder()
              .setFullMethodName("google.maps.routeoptimization.v1.RouteOptimization/OptimizeTours")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<OptimizeToursRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}:optimizeTours",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<OptimizeToursRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths("/v1/{parent=projects/*}:optimizeTours")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<OptimizeToursRequest> serializer =
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
                  ProtoMessageResponseParser.<OptimizeToursResponse>newBuilder()
                      .setDefaultInstance(OptimizeToursResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<BatchOptimizeToursRequest, Operation>
      batchOptimizeToursMethodDescriptor =
          ApiMethodDescriptor.<BatchOptimizeToursRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.maps.routeoptimization.v1.RouteOptimization/BatchOptimizeTours")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchOptimizeToursRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}:batchOptimizeTours",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchOptimizeToursRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths("/v1/{parent=projects/*}:batchOptimizeTours")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchOptimizeToursRequest> serializer =
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
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (BatchOptimizeToursRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private final UnaryCallable<OptimizeToursRequest, OptimizeToursResponse> optimizeToursCallable;
  private final UnaryCallable<BatchOptimizeToursRequest, Operation> batchOptimizeToursCallable;
  private final OperationCallable<
          BatchOptimizeToursRequest, BatchOptimizeToursResponse, BatchOptimizeToursMetadata>
      batchOptimizeToursOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonRouteOptimizationStub create(RouteOptimizationStubSettings settings)
      throws IOException {
    return new HttpJsonRouteOptimizationStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonRouteOptimizationStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonRouteOptimizationStub(
        RouteOptimizationStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonRouteOptimizationStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonRouteOptimizationStub(
        RouteOptimizationStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonRouteOptimizationStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRouteOptimizationStub(
      RouteOptimizationStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonRouteOptimizationCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonRouteOptimizationStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRouteOptimizationStub(
      RouteOptimizationStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(
            clientContext,
            callableFactory,
            typeRegistry,
            ImmutableMap.<String, HttpRule>builder()
                .put(
                    "google.longrunning.Operations.GetOperation",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/locations/*/operations/*}")
                        .build())
                .build());

    HttpJsonCallSettings<OptimizeToursRequest, OptimizeToursResponse>
        optimizeToursTransportSettings =
            HttpJsonCallSettings.<OptimizeToursRequest, OptimizeToursResponse>newBuilder()
                .setMethodDescriptor(optimizeToursMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<BatchOptimizeToursRequest, Operation> batchOptimizeToursTransportSettings =
        HttpJsonCallSettings.<BatchOptimizeToursRequest, Operation>newBuilder()
            .setMethodDescriptor(batchOptimizeToursMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();

    this.optimizeToursCallable =
        callableFactory.createUnaryCallable(
            optimizeToursTransportSettings, settings.optimizeToursSettings(), clientContext);
    this.batchOptimizeToursCallable =
        callableFactory.createUnaryCallable(
            batchOptimizeToursTransportSettings,
            settings.batchOptimizeToursSettings(),
            clientContext);
    this.batchOptimizeToursOperationCallable =
        callableFactory.createOperationCallable(
            batchOptimizeToursTransportSettings,
            settings.batchOptimizeToursOperationSettings(),
            clientContext,
            httpJsonOperationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(optimizeToursMethodDescriptor);
    methodDescriptors.add(batchOptimizeToursMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<OptimizeToursRequest, OptimizeToursResponse> optimizeToursCallable() {
    return optimizeToursCallable;
  }

  @Override
  public UnaryCallable<BatchOptimizeToursRequest, Operation> batchOptimizeToursCallable() {
    return batchOptimizeToursCallable;
  }

  @Override
  public OperationCallable<
          BatchOptimizeToursRequest, BatchOptimizeToursResponse, BatchOptimizeToursMetadata>
      batchOptimizeToursOperationCallable() {
    return batchOptimizeToursOperationCallable;
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
