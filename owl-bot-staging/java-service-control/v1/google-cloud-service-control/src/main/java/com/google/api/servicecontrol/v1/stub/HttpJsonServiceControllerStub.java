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

package com.google.api.servicecontrol.v1.stub;

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
import com.google.api.servicecontrol.v1.CheckRequest;
import com.google.api.servicecontrol.v1.CheckResponse;
import com.google.api.servicecontrol.v1.ReportRequest;
import com.google.api.servicecontrol.v1.ReportResponse;
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
 * REST stub implementation for the ServiceController service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonServiceControllerStub extends ServiceControllerStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<CheckRequest, CheckResponse> checkMethodDescriptor =
      ApiMethodDescriptor.<CheckRequest, CheckResponse>newBuilder()
          .setFullMethodName("google.api.servicecontrol.v1.ServiceController/Check")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<CheckRequest>newBuilder()
                  .setPath(
                      "/v1/services/{serviceName}:check",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<CheckRequest> serializer = ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "serviceName", request.getServiceName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<CheckRequest> serializer = ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create()
                              .toBody("*", request.toBuilder().clearServiceName().build(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<CheckResponse>newBuilder()
                  .setDefaultInstance(CheckResponse.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ReportRequest, ReportResponse> reportMethodDescriptor =
      ApiMethodDescriptor.<ReportRequest, ReportResponse>newBuilder()
          .setFullMethodName("google.api.servicecontrol.v1.ServiceController/Report")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<ReportRequest>newBuilder()
                  .setPath(
                      "/v1/services/{serviceName}:report",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<ReportRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "serviceName", request.getServiceName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<ReportRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create()
                              .toBody("*", request.toBuilder().clearServiceName().build(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<ReportResponse>newBuilder()
                  .setDefaultInstance(ReportResponse.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private final UnaryCallable<CheckRequest, CheckResponse> checkCallable;
  private final UnaryCallable<ReportRequest, ReportResponse> reportCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonServiceControllerStub create(ServiceControllerStubSettings settings)
      throws IOException {
    return new HttpJsonServiceControllerStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonServiceControllerStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonServiceControllerStub(
        ServiceControllerStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonServiceControllerStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonServiceControllerStub(
        ServiceControllerStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonServiceControllerStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonServiceControllerStub(
      ServiceControllerStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonServiceControllerCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonServiceControllerStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonServiceControllerStub(
      ServiceControllerStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CheckRequest, CheckResponse> checkTransportSettings =
        HttpJsonCallSettings.<CheckRequest, CheckResponse>newBuilder()
            .setMethodDescriptor(checkMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ReportRequest, ReportResponse> reportTransportSettings =
        HttpJsonCallSettings.<ReportRequest, ReportResponse>newBuilder()
            .setMethodDescriptor(reportMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.checkCallable =
        callableFactory.createUnaryCallable(
            checkTransportSettings, settings.checkSettings(), clientContext);
    this.reportCallable =
        callableFactory.createUnaryCallable(
            reportTransportSettings, settings.reportSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(checkMethodDescriptor);
    methodDescriptors.add(reportMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<CheckRequest, CheckResponse> checkCallable() {
    return checkCallable;
  }

  @Override
  public UnaryCallable<ReportRequest, ReportResponse> reportCallable() {
    return reportCallable;
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
