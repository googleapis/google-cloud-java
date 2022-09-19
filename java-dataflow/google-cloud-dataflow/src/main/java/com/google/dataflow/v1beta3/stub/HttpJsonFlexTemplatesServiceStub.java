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

package com.google.dataflow.v1beta3.stub;

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
import com.google.dataflow.v1beta3.LaunchFlexTemplateRequest;
import com.google.dataflow.v1beta3.LaunchFlexTemplateResponse;
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
 * REST stub implementation for the FlexTemplatesService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonFlexTemplatesServiceStub extends FlexTemplatesServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<LaunchFlexTemplateRequest, LaunchFlexTemplateResponse>
      launchFlexTemplateMethodDescriptor =
          ApiMethodDescriptor.<LaunchFlexTemplateRequest, LaunchFlexTemplateResponse>newBuilder()
              .setFullMethodName("google.dataflow.v1beta3.FlexTemplatesService/LaunchFlexTemplate")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<LaunchFlexTemplateRequest>newBuilder()
                      .setPath(
                          "/v1b3/projects/{projectId}/locations/{location}/flexTemplates:launch",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<LaunchFlexTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "location", request.getLocation());
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<LaunchFlexTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*",
                                      request.toBuilder().clearLocation().clearProjectId().build(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<LaunchFlexTemplateResponse>newBuilder()
                      .setDefaultInstance(LaunchFlexTemplateResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<LaunchFlexTemplateRequest, LaunchFlexTemplateResponse>
      launchFlexTemplateCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonFlexTemplatesServiceStub create(
      FlexTemplatesServiceStubSettings settings) throws IOException {
    return new HttpJsonFlexTemplatesServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonFlexTemplatesServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonFlexTemplatesServiceStub(
        FlexTemplatesServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonFlexTemplatesServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonFlexTemplatesServiceStub(
        FlexTemplatesServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonFlexTemplatesServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonFlexTemplatesServiceStub(
      FlexTemplatesServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonFlexTemplatesServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonFlexTemplatesServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonFlexTemplatesServiceStub(
      FlexTemplatesServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<LaunchFlexTemplateRequest, LaunchFlexTemplateResponse>
        launchFlexTemplateTransportSettings =
            HttpJsonCallSettings.<LaunchFlexTemplateRequest, LaunchFlexTemplateResponse>newBuilder()
                .setMethodDescriptor(launchFlexTemplateMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.launchFlexTemplateCallable =
        callableFactory.createUnaryCallable(
            launchFlexTemplateTransportSettings,
            settings.launchFlexTemplateSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(launchFlexTemplateMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<LaunchFlexTemplateRequest, LaunchFlexTemplateResponse>
      launchFlexTemplateCallable() {
    return launchFlexTemplateCallable;
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
