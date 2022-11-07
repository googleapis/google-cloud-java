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

package com.google.maps.routing.v2.stub;

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
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.maps.routing.v2.ComputeRouteMatrixRequest;
import com.google.maps.routing.v2.ComputeRoutesRequest;
import com.google.maps.routing.v2.ComputeRoutesResponse;
import com.google.maps.routing.v2.RouteMatrixElement;
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
 * REST stub implementation for the Routes service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonRoutesStub extends RoutesStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<ComputeRoutesRequest, ComputeRoutesResponse>
      computeRoutesMethodDescriptor =
          ApiMethodDescriptor.<ComputeRoutesRequest, ComputeRoutesResponse>newBuilder()
              .setFullMethodName("google.maps.routing.v2.Routes/ComputeRoutes")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ComputeRoutesRequest>newBuilder()
                      .setPath(
                          "/directions/v2:computeRoutes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ComputeRoutesRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ComputeRoutesRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ComputeRoutesResponse>newBuilder()
                      .setDefaultInstance(ComputeRoutesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ComputeRouteMatrixRequest, RouteMatrixElement>
      computeRouteMatrixMethodDescriptor =
          ApiMethodDescriptor.<ComputeRouteMatrixRequest, RouteMatrixElement>newBuilder()
              .setFullMethodName("google.maps.routing.v2.Routes/ComputeRouteMatrix")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.SERVER_STREAMING)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ComputeRouteMatrixRequest>newBuilder()
                      .setPath(
                          "/distanceMatrix/v2:computeRouteMatrix",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ComputeRouteMatrixRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ComputeRouteMatrixRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RouteMatrixElement>newBuilder()
                      .setDefaultInstance(RouteMatrixElement.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<ComputeRoutesRequest, ComputeRoutesResponse> computeRoutesCallable;
  private final ServerStreamingCallable<ComputeRouteMatrixRequest, RouteMatrixElement>
      computeRouteMatrixCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonRoutesStub create(RoutesStubSettings settings) throws IOException {
    return new HttpJsonRoutesStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonRoutesStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonRoutesStub(RoutesStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonRoutesStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonRoutesStub(
        RoutesStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonRoutesStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonRoutesStub(RoutesStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonRoutesCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonRoutesStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonRoutesStub(
      RoutesStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<ComputeRoutesRequest, ComputeRoutesResponse>
        computeRoutesTransportSettings =
            HttpJsonCallSettings.<ComputeRoutesRequest, ComputeRoutesResponse>newBuilder()
                .setMethodDescriptor(computeRoutesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ComputeRouteMatrixRequest, RouteMatrixElement>
        computeRouteMatrixTransportSettings =
            HttpJsonCallSettings.<ComputeRouteMatrixRequest, RouteMatrixElement>newBuilder()
                .setMethodDescriptor(computeRouteMatrixMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.computeRoutesCallable =
        callableFactory.createUnaryCallable(
            computeRoutesTransportSettings, settings.computeRoutesSettings(), clientContext);
    this.computeRouteMatrixCallable =
        callableFactory.createServerStreamingCallable(
            computeRouteMatrixTransportSettings,
            settings.computeRouteMatrixSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(computeRoutesMethodDescriptor);
    methodDescriptors.add(computeRouteMatrixMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<ComputeRoutesRequest, ComputeRoutesResponse> computeRoutesCallable() {
    return computeRoutesCallable;
  }

  @Override
  public ServerStreamingCallable<ComputeRouteMatrixRequest, RouteMatrixElement>
      computeRouteMatrixCallable() {
    return computeRouteMatrixCallable;
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
