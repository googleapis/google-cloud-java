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
import com.google.dataflow.v1beta3.CreateJobFromTemplateRequest;
import com.google.dataflow.v1beta3.GetTemplateRequest;
import com.google.dataflow.v1beta3.GetTemplateResponse;
import com.google.dataflow.v1beta3.Job;
import com.google.dataflow.v1beta3.LaunchTemplateRequest;
import com.google.dataflow.v1beta3.LaunchTemplateResponse;
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
 * REST stub implementation for the TemplatesService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonTemplatesServiceStub extends TemplatesServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<CreateJobFromTemplateRequest, Job>
      createJobFromTemplateMethodDescriptor =
          ApiMethodDescriptor.<CreateJobFromTemplateRequest, Job>newBuilder()
              .setFullMethodName("google.dataflow.v1beta3.TemplatesService/CreateJobFromTemplate")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateJobFromTemplateRequest>newBuilder()
                      .setPath(
                          "/v1b3/projects/{projectId}/locations/{location}/templates",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateJobFromTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "location", request.getLocation());
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            return fields;
                          })
                      .setAdditionalPaths("/v1b3/projects/{projectId}/templates")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateJobFromTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*",
                                      request.toBuilder().clearLocation().clearProjectId().build(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Job>newBuilder()
                      .setDefaultInstance(Job.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<LaunchTemplateRequest, LaunchTemplateResponse>
      launchTemplateMethodDescriptor =
          ApiMethodDescriptor.<LaunchTemplateRequest, LaunchTemplateResponse>newBuilder()
              .setFullMethodName("google.dataflow.v1beta3.TemplatesService/LaunchTemplate")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<LaunchTemplateRequest>newBuilder()
                      .setPath(
                          "/v1b3/projects/{projectId}/locations/{location}/templates:launch",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<LaunchTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "location", request.getLocation());
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            return fields;
                          })
                      .setAdditionalPaths("/v1b3/projects/{projectId}/templates:launch")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<LaunchTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "dynamicTemplate", request.getDynamicTemplate());
                            serializer.putQueryParam(fields, "gcsPath", request.getGcsPath());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("launchParameters", request.getLaunchParameters(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<LaunchTemplateResponse>newBuilder()
                      .setDefaultInstance(LaunchTemplateResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetTemplateRequest, GetTemplateResponse>
      getTemplateMethodDescriptor =
          ApiMethodDescriptor.<GetTemplateRequest, GetTemplateResponse>newBuilder()
              .setFullMethodName("google.dataflow.v1beta3.TemplatesService/GetTemplate")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetTemplateRequest>newBuilder()
                      .setPath(
                          "/v1b3/projects/{projectId}/locations/{location}/templates:get",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "location", request.getLocation());
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            return fields;
                          })
                      .setAdditionalPaths("/v1b3/projects/{projectId}/templates:get")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "gcsPath", request.getGcsPath());
                            serializer.putQueryParam(fields, "view", request.getViewValue());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GetTemplateResponse>newBuilder()
                      .setDefaultInstance(GetTemplateResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CreateJobFromTemplateRequest, Job> createJobFromTemplateCallable;
  private final UnaryCallable<LaunchTemplateRequest, LaunchTemplateResponse> launchTemplateCallable;
  private final UnaryCallable<GetTemplateRequest, GetTemplateResponse> getTemplateCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonTemplatesServiceStub create(TemplatesServiceStubSettings settings)
      throws IOException {
    return new HttpJsonTemplatesServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonTemplatesServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonTemplatesServiceStub(
        TemplatesServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonTemplatesServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonTemplatesServiceStub(
        TemplatesServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonTemplatesServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonTemplatesServiceStub(
      TemplatesServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonTemplatesServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonTemplatesServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonTemplatesServiceStub(
      TemplatesServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CreateJobFromTemplateRequest, Job> createJobFromTemplateTransportSettings =
        HttpJsonCallSettings.<CreateJobFromTemplateRequest, Job>newBuilder()
            .setMethodDescriptor(createJobFromTemplateMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<LaunchTemplateRequest, LaunchTemplateResponse>
        launchTemplateTransportSettings =
            HttpJsonCallSettings.<LaunchTemplateRequest, LaunchTemplateResponse>newBuilder()
                .setMethodDescriptor(launchTemplateMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetTemplateRequest, GetTemplateResponse> getTemplateTransportSettings =
        HttpJsonCallSettings.<GetTemplateRequest, GetTemplateResponse>newBuilder()
            .setMethodDescriptor(getTemplateMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.createJobFromTemplateCallable =
        callableFactory.createUnaryCallable(
            createJobFromTemplateTransportSettings,
            settings.createJobFromTemplateSettings(),
            clientContext);
    this.launchTemplateCallable =
        callableFactory.createUnaryCallable(
            launchTemplateTransportSettings, settings.launchTemplateSettings(), clientContext);
    this.getTemplateCallable =
        callableFactory.createUnaryCallable(
            getTemplateTransportSettings, settings.getTemplateSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createJobFromTemplateMethodDescriptor);
    methodDescriptors.add(launchTemplateMethodDescriptor);
    methodDescriptors.add(getTemplateMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<CreateJobFromTemplateRequest, Job> createJobFromTemplateCallable() {
    return createJobFromTemplateCallable;
  }

  @Override
  public UnaryCallable<LaunchTemplateRequest, LaunchTemplateResponse> launchTemplateCallable() {
    return launchTemplateCallable;
  }

  @Override
  public UnaryCallable<GetTemplateRequest, GetTemplateResponse> getTemplateCallable() {
    return getTemplateCallable;
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
