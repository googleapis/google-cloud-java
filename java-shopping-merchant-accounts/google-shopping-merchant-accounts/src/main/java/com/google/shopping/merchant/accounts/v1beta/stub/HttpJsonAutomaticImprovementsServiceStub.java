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
import com.google.shopping.merchant.accounts.v1beta.AutomaticImprovements;
import com.google.shopping.merchant.accounts.v1beta.GetAutomaticImprovementsRequest;
import com.google.shopping.merchant.accounts.v1beta.UpdateAutomaticImprovementsRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the AutomaticImprovementsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonAutomaticImprovementsServiceStub extends AutomaticImprovementsServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetAutomaticImprovementsRequest, AutomaticImprovements>
      getAutomaticImprovementsMethodDescriptor =
          ApiMethodDescriptor.<GetAutomaticImprovementsRequest, AutomaticImprovements>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.AutomaticImprovementsService/GetAutomaticImprovements")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAutomaticImprovementsRequest>newBuilder()
                      .setPath(
                          "/accounts/v1beta/{name=accounts/*/automaticImprovements}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAutomaticImprovementsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAutomaticImprovementsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AutomaticImprovements>newBuilder()
                      .setDefaultInstance(AutomaticImprovements.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          UpdateAutomaticImprovementsRequest, AutomaticImprovements>
      updateAutomaticImprovementsMethodDescriptor =
          ApiMethodDescriptor
              .<UpdateAutomaticImprovementsRequest, AutomaticImprovements>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1beta.AutomaticImprovementsService/UpdateAutomaticImprovements")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateAutomaticImprovementsRequest>newBuilder()
                      .setPath(
                          "/accounts/v1beta/{automaticImprovements.name=accounts/*/automaticImprovements}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAutomaticImprovementsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "automaticImprovements.name",
                                request.getAutomaticImprovements().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAutomaticImprovementsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "automaticImprovements",
                                      request.getAutomaticImprovements(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AutomaticImprovements>newBuilder()
                      .setDefaultInstance(AutomaticImprovements.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetAutomaticImprovementsRequest, AutomaticImprovements>
      getAutomaticImprovementsCallable;
  private final UnaryCallable<UpdateAutomaticImprovementsRequest, AutomaticImprovements>
      updateAutomaticImprovementsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonAutomaticImprovementsServiceStub create(
      AutomaticImprovementsServiceStubSettings settings) throws IOException {
    return new HttpJsonAutomaticImprovementsServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonAutomaticImprovementsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonAutomaticImprovementsServiceStub(
        AutomaticImprovementsServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonAutomaticImprovementsServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonAutomaticImprovementsServiceStub(
        AutomaticImprovementsServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonAutomaticImprovementsServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonAutomaticImprovementsServiceStub(
      AutomaticImprovementsServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonAutomaticImprovementsServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonAutomaticImprovementsServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonAutomaticImprovementsServiceStub(
      AutomaticImprovementsServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetAutomaticImprovementsRequest, AutomaticImprovements>
        getAutomaticImprovementsTransportSettings =
            HttpJsonCallSettings
                .<GetAutomaticImprovementsRequest, AutomaticImprovements>newBuilder()
                .setMethodDescriptor(getAutomaticImprovementsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateAutomaticImprovementsRequest, AutomaticImprovements>
        updateAutomaticImprovementsTransportSettings =
            HttpJsonCallSettings
                .<UpdateAutomaticImprovementsRequest, AutomaticImprovements>newBuilder()
                .setMethodDescriptor(updateAutomaticImprovementsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "automatic_improvements.name",
                          String.valueOf(request.getAutomaticImprovements().getName()));
                      return builder.build();
                    })
                .build();

    this.getAutomaticImprovementsCallable =
        callableFactory.createUnaryCallable(
            getAutomaticImprovementsTransportSettings,
            settings.getAutomaticImprovementsSettings(),
            clientContext);
    this.updateAutomaticImprovementsCallable =
        callableFactory.createUnaryCallable(
            updateAutomaticImprovementsTransportSettings,
            settings.updateAutomaticImprovementsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getAutomaticImprovementsMethodDescriptor);
    methodDescriptors.add(updateAutomaticImprovementsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetAutomaticImprovementsRequest, AutomaticImprovements>
      getAutomaticImprovementsCallable() {
    return getAutomaticImprovementsCallable;
  }

  @Override
  public UnaryCallable<UpdateAutomaticImprovementsRequest, AutomaticImprovements>
      updateAutomaticImprovementsCallable() {
    return updateAutomaticImprovementsCallable;
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
