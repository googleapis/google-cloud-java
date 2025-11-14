/*
 * Copyright 2025 Google LLC
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

package com.google.shopping.merchant.issueresolution.v1.stub;

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
import com.google.shopping.merchant.issueresolution.v1.RenderAccountIssuesRequest;
import com.google.shopping.merchant.issueresolution.v1.RenderAccountIssuesResponse;
import com.google.shopping.merchant.issueresolution.v1.RenderProductIssuesRequest;
import com.google.shopping.merchant.issueresolution.v1.RenderProductIssuesResponse;
import com.google.shopping.merchant.issueresolution.v1.TriggerActionRequest;
import com.google.shopping.merchant.issueresolution.v1.TriggerActionResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the IssueResolutionService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonIssueResolutionServiceStub extends IssueResolutionServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<RenderAccountIssuesRequest, RenderAccountIssuesResponse>
      renderAccountIssuesMethodDescriptor =
          ApiMethodDescriptor.<RenderAccountIssuesRequest, RenderAccountIssuesResponse>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.issueresolution.v1.IssueResolutionService/RenderAccountIssues")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RenderAccountIssuesRequest>newBuilder()
                      .setPath(
                          "/issueresolution/v1/{name=accounts/*}:renderaccountissues",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RenderAccountIssuesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RenderAccountIssuesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "languageCode", request.getLanguageCode());
                            serializer.putQueryParam(fields, "timeZone", request.getTimeZone());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("payload", request.getPayload(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RenderAccountIssuesResponse>newBuilder()
                      .setDefaultInstance(RenderAccountIssuesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<RenderProductIssuesRequest, RenderProductIssuesResponse>
      renderProductIssuesMethodDescriptor =
          ApiMethodDescriptor.<RenderProductIssuesRequest, RenderProductIssuesResponse>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.issueresolution.v1.IssueResolutionService/RenderProductIssues")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RenderProductIssuesRequest>newBuilder()
                      .setPath(
                          "/issueresolution/v1/{name=accounts/*/products/*}:renderproductissues",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RenderProductIssuesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RenderProductIssuesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "languageCode", request.getLanguageCode());
                            serializer.putQueryParam(fields, "timeZone", request.getTimeZone());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("payload", request.getPayload(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RenderProductIssuesResponse>newBuilder()
                      .setDefaultInstance(RenderProductIssuesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<TriggerActionRequest, TriggerActionResponse>
      triggerActionMethodDescriptor =
          ApiMethodDescriptor.<TriggerActionRequest, TriggerActionResponse>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.issueresolution.v1.IssueResolutionService/TriggerAction")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TriggerActionRequest>newBuilder()
                      .setPath(
                          "/issueresolution/v1/{name=accounts/*}:triggeraction",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TriggerActionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TriggerActionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "languageCode", request.getLanguageCode());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("payload", request.getPayload(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TriggerActionResponse>newBuilder()
                      .setDefaultInstance(TriggerActionResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<RenderAccountIssuesRequest, RenderAccountIssuesResponse>
      renderAccountIssuesCallable;
  private final UnaryCallable<RenderProductIssuesRequest, RenderProductIssuesResponse>
      renderProductIssuesCallable;
  private final UnaryCallable<TriggerActionRequest, TriggerActionResponse> triggerActionCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonIssueResolutionServiceStub create(
      IssueResolutionServiceStubSettings settings) throws IOException {
    return new HttpJsonIssueResolutionServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonIssueResolutionServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonIssueResolutionServiceStub(
        IssueResolutionServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonIssueResolutionServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonIssueResolutionServiceStub(
        IssueResolutionServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonIssueResolutionServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonIssueResolutionServiceStub(
      IssueResolutionServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonIssueResolutionServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonIssueResolutionServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonIssueResolutionServiceStub(
      IssueResolutionServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<RenderAccountIssuesRequest, RenderAccountIssuesResponse>
        renderAccountIssuesTransportSettings =
            HttpJsonCallSettings
                .<RenderAccountIssuesRequest, RenderAccountIssuesResponse>newBuilder()
                .setMethodDescriptor(renderAccountIssuesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<RenderProductIssuesRequest, RenderProductIssuesResponse>
        renderProductIssuesTransportSettings =
            HttpJsonCallSettings
                .<RenderProductIssuesRequest, RenderProductIssuesResponse>newBuilder()
                .setMethodDescriptor(renderProductIssuesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<TriggerActionRequest, TriggerActionResponse>
        triggerActionTransportSettings =
            HttpJsonCallSettings.<TriggerActionRequest, TriggerActionResponse>newBuilder()
                .setMethodDescriptor(triggerActionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();

    this.renderAccountIssuesCallable =
        callableFactory.createUnaryCallable(
            renderAccountIssuesTransportSettings,
            settings.renderAccountIssuesSettings(),
            clientContext);
    this.renderProductIssuesCallable =
        callableFactory.createUnaryCallable(
            renderProductIssuesTransportSettings,
            settings.renderProductIssuesSettings(),
            clientContext);
    this.triggerActionCallable =
        callableFactory.createUnaryCallable(
            triggerActionTransportSettings, settings.triggerActionSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(renderAccountIssuesMethodDescriptor);
    methodDescriptors.add(renderProductIssuesMethodDescriptor);
    methodDescriptors.add(triggerActionMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<RenderAccountIssuesRequest, RenderAccountIssuesResponse>
      renderAccountIssuesCallable() {
    return renderAccountIssuesCallable;
  }

  @Override
  public UnaryCallable<RenderProductIssuesRequest, RenderProductIssuesResponse>
      renderProductIssuesCallable() {
    return renderProductIssuesCallable;
  }

  @Override
  public UnaryCallable<TriggerActionRequest, TriggerActionResponse> triggerActionCallable() {
    return triggerActionCallable;
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
