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

package com.google.cloud.visionai.v1.stub;

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
import com.google.cloud.visionai.v1.HealthCheckRequest;
import com.google.cloud.visionai.v1.HealthCheckResponse;
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
 * REST stub implementation for the HealthCheckService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonHealthCheckServiceStub extends HealthCheckServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<HealthCheckRequest, HealthCheckResponse>
      healthCheckMethodDescriptor =
          ApiMethodDescriptor.<HealthCheckRequest, HealthCheckResponse>newBuilder()
              .setFullMethodName("google.cloud.visionai.v1.HealthCheckService/HealthCheck")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<HealthCheckRequest>newBuilder()
                      .setPath(
                          "/v1/{cluster=projects/*/locations/*/clusters/*}:healthCheck",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<HealthCheckRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "cluster", request.getCluster());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<HealthCheckRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<HealthCheckResponse>newBuilder()
                      .setDefaultInstance(HealthCheckResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<HealthCheckRequest, HealthCheckResponse> healthCheckCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonHealthCheckServiceStub create(HealthCheckServiceStubSettings settings)
      throws IOException {
    return new HttpJsonHealthCheckServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonHealthCheckServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonHealthCheckServiceStub(
        HealthCheckServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonHealthCheckServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonHealthCheckServiceStub(
        HealthCheckServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonHealthCheckServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonHealthCheckServiceStub(
      HealthCheckServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonHealthCheckServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonHealthCheckServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonHealthCheckServiceStub(
      HealthCheckServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<HealthCheckRequest, HealthCheckResponse> healthCheckTransportSettings =
        HttpJsonCallSettings.<HealthCheckRequest, HealthCheckResponse>newBuilder()
            .setMethodDescriptor(healthCheckMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("cluster", String.valueOf(request.getCluster()));
                  return builder.build();
                })
            .build();

    this.healthCheckCallable =
        callableFactory.createUnaryCallable(
            healthCheckTransportSettings, settings.healthCheckSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(healthCheckMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<HealthCheckRequest, HealthCheckResponse> healthCheckCallable() {
    return healthCheckCallable;
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
