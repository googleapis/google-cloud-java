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

package com.google.shopping.merchant.accounts.v1beta.stub;

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
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.protobuf.TypeRegistry;
import com.google.shopping.merchant.accounts.v1beta.ClaimHomepageRequest;
import com.google.shopping.merchant.accounts.v1beta.GetHomepageRequest;
import com.google.shopping.merchant.accounts.v1beta.Homepage;
import com.google.shopping.merchant.accounts.v1beta.UnclaimHomepageRequest;
import com.google.shopping.merchant.accounts.v1beta.UpdateHomepageRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the HomepageService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonHomepageServiceStub extends HomepageServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetHomepageRequest, Homepage>
      getHomepageMethodDescriptor =
          ApiMethodDescriptor.<GetHomepageRequest, Homepage>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.HomepageService/GetHomepage")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetHomepageRequest>newBuilder()
                      .setPath(
                          "/accounts/v1beta/{name=accounts/*/homepage}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetHomepageRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetHomepageRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Homepage>newBuilder()
                      .setDefaultInstance(Homepage.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateHomepageRequest, Homepage>
      updateHomepageMethodDescriptor =
          ApiMethodDescriptor.<UpdateHomepageRequest, Homepage>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.HomepageService/UpdateHomepage")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateHomepageRequest>newBuilder()
                      .setPath(
                          "/accounts/v1beta/{homepage.name=accounts/*/homepage}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateHomepageRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "homepage.name", request.getHomepage().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateHomepageRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("homepage", request.getHomepage(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Homepage>newBuilder()
                      .setDefaultInstance(Homepage.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ClaimHomepageRequest, Homepage>
      claimHomepageMethodDescriptor =
          ApiMethodDescriptor.<ClaimHomepageRequest, Homepage>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.HomepageService/ClaimHomepage")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ClaimHomepageRequest>newBuilder()
                      .setPath(
                          "/accounts/v1beta/{name=accounts/*/homepage}:claim",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ClaimHomepageRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ClaimHomepageRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Homepage>newBuilder()
                      .setDefaultInstance(Homepage.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UnclaimHomepageRequest, Homepage>
      unclaimHomepageMethodDescriptor =
          ApiMethodDescriptor.<UnclaimHomepageRequest, Homepage>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.HomepageService/UnclaimHomepage")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UnclaimHomepageRequest>newBuilder()
                      .setPath(
                          "/accounts/v1beta/{name=accounts/*/homepage}:unclaim",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UnclaimHomepageRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UnclaimHomepageRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Homepage>newBuilder()
                      .setDefaultInstance(Homepage.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetHomepageRequest, Homepage> getHomepageCallable;
  private final UnaryCallable<UpdateHomepageRequest, Homepage> updateHomepageCallable;
  private final UnaryCallable<ClaimHomepageRequest, Homepage> claimHomepageCallable;
  private final UnaryCallable<UnclaimHomepageRequest, Homepage> unclaimHomepageCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonHomepageServiceStub create(HomepageServiceStubSettings settings)
      throws IOException {
    return new HttpJsonHomepageServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonHomepageServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonHomepageServiceStub(
        HomepageServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonHomepageServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonHomepageServiceStub(
        HomepageServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonHomepageServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonHomepageServiceStub(
      HomepageServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonHomepageServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonHomepageServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonHomepageServiceStub(
      HomepageServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetHomepageRequest, Homepage> getHomepageTransportSettings =
        HttpJsonCallSettings.<GetHomepageRequest, Homepage>newBuilder()
            .setMethodDescriptor(getHomepageMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateHomepageRequest, Homepage> updateHomepageTransportSettings =
        HttpJsonCallSettings.<UpdateHomepageRequest, Homepage>newBuilder()
            .setMethodDescriptor(updateHomepageMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("homepage.name", String.valueOf(request.getHomepage().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ClaimHomepageRequest, Homepage> claimHomepageTransportSettings =
        HttpJsonCallSettings.<ClaimHomepageRequest, Homepage>newBuilder()
            .setMethodDescriptor(claimHomepageMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UnclaimHomepageRequest, Homepage> unclaimHomepageTransportSettings =
        HttpJsonCallSettings.<UnclaimHomepageRequest, Homepage>newBuilder()
            .setMethodDescriptor(unclaimHomepageMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.getHomepageCallable =
        callableFactory.createUnaryCallable(
            getHomepageTransportSettings, settings.getHomepageSettings(), clientContext);
    this.updateHomepageCallable =
        callableFactory.createUnaryCallable(
            updateHomepageTransportSettings, settings.updateHomepageSettings(), clientContext);
    this.claimHomepageCallable =
        callableFactory.createUnaryCallable(
            claimHomepageTransportSettings, settings.claimHomepageSettings(), clientContext);
    this.unclaimHomepageCallable =
        callableFactory.createUnaryCallable(
            unclaimHomepageTransportSettings, settings.unclaimHomepageSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getHomepageMethodDescriptor);
    methodDescriptors.add(updateHomepageMethodDescriptor);
    methodDescriptors.add(claimHomepageMethodDescriptor);
    methodDescriptors.add(unclaimHomepageMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetHomepageRequest, Homepage> getHomepageCallable() {
    return getHomepageCallable;
  }

  @Override
  public UnaryCallable<UpdateHomepageRequest, Homepage> updateHomepageCallable() {
    return updateHomepageCallable;
  }

  @Override
  public UnaryCallable<ClaimHomepageRequest, Homepage> claimHomepageCallable() {
    return claimHomepageCallable;
  }

  @Override
  public UnaryCallable<UnclaimHomepageRequest, Homepage> unclaimHomepageCallable() {
    return unclaimHomepageCallable;
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
