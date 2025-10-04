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

package com.google.shopping.merchant.accounts.v1.stub;

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
import com.google.shopping.merchant.accounts.v1.AcceptTermsOfServiceRequest;
import com.google.shopping.merchant.accounts.v1.AcceptTermsOfServiceResponse;
import com.google.shopping.merchant.accounts.v1.GetTermsOfServiceRequest;
import com.google.shopping.merchant.accounts.v1.RetrieveLatestTermsOfServiceRequest;
import com.google.shopping.merchant.accounts.v1.TermsOfService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the TermsOfServiceService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonTermsOfServiceServiceStub extends TermsOfServiceServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetTermsOfServiceRequest, TermsOfService>
      getTermsOfServiceMethodDescriptor =
          ApiMethodDescriptor.<GetTermsOfServiceRequest, TermsOfService>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1.TermsOfServiceService/GetTermsOfService")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetTermsOfServiceRequest>newBuilder()
                      .setPath(
                          "/accounts/v1/{name=termsOfService/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetTermsOfServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetTermsOfServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TermsOfService>newBuilder()
                      .setDefaultInstance(TermsOfService.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<RetrieveLatestTermsOfServiceRequest, TermsOfService>
      retrieveLatestTermsOfServiceMethodDescriptor =
          ApiMethodDescriptor.<RetrieveLatestTermsOfServiceRequest, TermsOfService>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1.TermsOfServiceService/RetrieveLatestTermsOfService")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RetrieveLatestTermsOfServiceRequest>newBuilder()
                      .setPath(
                          "/accounts/v1/termsOfService:retrieveLatest",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RetrieveLatestTermsOfServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RetrieveLatestTermsOfServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "kind", request.getKindValue());
                            serializer.putQueryParam(fields, "regionCode", request.getRegionCode());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TermsOfService>newBuilder()
                      .setDefaultInstance(TermsOfService.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          AcceptTermsOfServiceRequest, AcceptTermsOfServiceResponse>
      acceptTermsOfServiceMethodDescriptor =
          ApiMethodDescriptor
              .<AcceptTermsOfServiceRequest, AcceptTermsOfServiceResponse>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1.TermsOfServiceService/AcceptTermsOfService")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AcceptTermsOfServiceRequest>newBuilder()
                      .setPath(
                          "/accounts/v1/{name=termsOfService/*}:accept",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AcceptTermsOfServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AcceptTermsOfServiceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "account", request.getAccount());
                            serializer.putQueryParam(fields, "regionCode", request.getRegionCode());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AcceptTermsOfServiceResponse>newBuilder()
                      .setDefaultInstance(AcceptTermsOfServiceResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetTermsOfServiceRequest, TermsOfService> getTermsOfServiceCallable;
  private final UnaryCallable<RetrieveLatestTermsOfServiceRequest, TermsOfService>
      retrieveLatestTermsOfServiceCallable;
  private final UnaryCallable<AcceptTermsOfServiceRequest, AcceptTermsOfServiceResponse>
      acceptTermsOfServiceCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonTermsOfServiceServiceStub create(
      TermsOfServiceServiceStubSettings settings) throws IOException {
    return new HttpJsonTermsOfServiceServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonTermsOfServiceServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonTermsOfServiceServiceStub(
        TermsOfServiceServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonTermsOfServiceServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonTermsOfServiceServiceStub(
        TermsOfServiceServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonTermsOfServiceServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonTermsOfServiceServiceStub(
      TermsOfServiceServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonTermsOfServiceServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonTermsOfServiceServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonTermsOfServiceServiceStub(
      TermsOfServiceServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetTermsOfServiceRequest, TermsOfService>
        getTermsOfServiceTransportSettings =
            HttpJsonCallSettings.<GetTermsOfServiceRequest, TermsOfService>newBuilder()
                .setMethodDescriptor(getTermsOfServiceMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<RetrieveLatestTermsOfServiceRequest, TermsOfService>
        retrieveLatestTermsOfServiceTransportSettings =
            HttpJsonCallSettings.<RetrieveLatestTermsOfServiceRequest, TermsOfService>newBuilder()
                .setMethodDescriptor(retrieveLatestTermsOfServiceMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<AcceptTermsOfServiceRequest, AcceptTermsOfServiceResponse>
        acceptTermsOfServiceTransportSettings =
            HttpJsonCallSettings
                .<AcceptTermsOfServiceRequest, AcceptTermsOfServiceResponse>newBuilder()
                .setMethodDescriptor(acceptTermsOfServiceMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();

    this.getTermsOfServiceCallable =
        callableFactory.createUnaryCallable(
            getTermsOfServiceTransportSettings,
            settings.getTermsOfServiceSettings(),
            clientContext);
    this.retrieveLatestTermsOfServiceCallable =
        callableFactory.createUnaryCallable(
            retrieveLatestTermsOfServiceTransportSettings,
            settings.retrieveLatestTermsOfServiceSettings(),
            clientContext);
    this.acceptTermsOfServiceCallable =
        callableFactory.createUnaryCallable(
            acceptTermsOfServiceTransportSettings,
            settings.acceptTermsOfServiceSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getTermsOfServiceMethodDescriptor);
    methodDescriptors.add(retrieveLatestTermsOfServiceMethodDescriptor);
    methodDescriptors.add(acceptTermsOfServiceMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetTermsOfServiceRequest, TermsOfService> getTermsOfServiceCallable() {
    return getTermsOfServiceCallable;
  }

  @Override
  public UnaryCallable<RetrieveLatestTermsOfServiceRequest, TermsOfService>
      retrieveLatestTermsOfServiceCallable() {
    return retrieveLatestTermsOfServiceCallable;
  }

  @Override
  public UnaryCallable<AcceptTermsOfServiceRequest, AcceptTermsOfServiceResponse>
      acceptTermsOfServiceCallable() {
    return acceptTermsOfServiceCallable;
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
